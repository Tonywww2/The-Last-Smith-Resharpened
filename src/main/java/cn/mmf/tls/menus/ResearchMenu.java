package cn.mmf.tls.menus;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import cn.mmf.tls.block.BlockRegistry;
import cn.mmf.tls.data.tag.TLSItemTags;
import cn.mmf.tls.recipe.RecipeSerializerRegistry;
import cn.mmf.tls.recipe.TLSResearchRecipe;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.ItemCombinerMenuSlotDefinition;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ResearchMenu extends ItemCombinerMenu {
	private final Level level;
	@Nullable
	private TLSResearchRecipe selectedRecipe;
	private final List<TLSResearchRecipe> recipes;

	public ResearchMenu(int pContainerId, Inventory pPlayerInventory) {
		this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
	}

	public ResearchMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
		super(ContainerRegistry.RESEARCH_TABLE.get(), pContainerId, pPlayerInventory, pAccess);
		this.level = pPlayerInventory.player.level();
		this.recipes = this.level.getRecipeManager()
				.getAllRecipesFor(RecipeSerializerRegistry.RESEARCH_RECIPE_TYPE.get());
	}

	protected ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
		return ItemCombinerMenuSlotDefinition.create().withSlot(0, 43, 13, (stack) -> {
			return this.recipes.stream().anyMatch((recipe) -> {
				return recipe.isBladeIngredient(stack);
			});
		}).withSlot(1, 33, 37, (stack) -> {
			return this.recipes.stream().anyMatch((recipe) -> {
				return recipe.isPaperIngredient(stack);
			});
		}).withSlot(2, 53, 37, (stack) -> {
			return this.recipes.stream().anyMatch((recipe) -> {
				return recipe.isInkIngredient(stack);
			});
		}).withResultSlot(3, 111, 25).build();
	}

	protected boolean isValidBlock(BlockState pState) {
		return pState.is(BlockRegistry.RESEARCH_TABLE.get());
	}

	protected boolean mayPickup(Player pPlayer, boolean pHasStack) {
		return this.selectedRecipe != null && this.selectedRecipe.matches(this.inputSlots, this.level);
	}

	protected void onTake(Player pPlayer, ItemStack pStack) {
		pStack.onCraftedBy(pPlayer.level(), pPlayer, pStack.getCount());
		this.resultSlots.awardUsedRecipes(pPlayer, this.getRelevantItems());
		if(this.inputSlots.getItem(0).is(TLSItemTags.RESEARCH_CONSUMABLE))
			this.shrinkStackInSlot(0);
		this.shrinkStackInSlot(1);
		this.shrinkStackInSlot(2);
        this.access.execute((level, pos) -> {
            player.playSound(SoundEvents.BOOK_PAGE_TURN, 1F, 1F);
        });
	}

	private List<ItemStack> getRelevantItems() {
		return List.of(this.inputSlots.getItem(0), this.inputSlots.getItem(1), this.inputSlots.getItem(2));
	}

	private void shrinkStackInSlot(int pIndex) {
		ItemStack itemstack = this.inputSlots.getItem(pIndex);
		if (!itemstack.isEmpty()) {
			itemstack.shrink(1);
			this.inputSlots.setItem(pIndex, itemstack);
		}
	}

	public void createResult() {
		List<TLSResearchRecipe> list = this.level.getRecipeManager()
				.getRecipesFor(RecipeSerializerRegistry.RESEARCH_RECIPE_TYPE.get(), this.inputSlots, this.level);
		if (list.isEmpty()) {
			this.resultSlots.setItem(0, ItemStack.EMPTY);
		} else {
			TLSResearchRecipe smithingrecipe = list.get(0);
			ItemStack itemstack = smithingrecipe.assemble(this.inputSlots, this.level.registryAccess());
			if (itemstack.isItemEnabled(this.level.enabledFeatures())) {
				this.selectedRecipe = smithingrecipe;
				this.resultSlots.setRecipeUsed(smithingrecipe);
				this.resultSlots.setItem(0, itemstack);
			}
		}

	}

	public int getSlotToQuickMoveTo(ItemStack pStack) {
		return this.recipes.stream().map((p_266640_) -> {
			return findSlotMatchingIngredient(p_266640_, pStack);
		}).filter(Optional::isPresent).findFirst().orElse(Optional.of(0)).get();
	}

	private static Optional<Integer> findSlotMatchingIngredient(TLSResearchRecipe pRecipe, ItemStack pStack) {
		if (pRecipe.isBladeIngredient(pStack)) {
			return Optional.of(0);
		} else if (pRecipe.isPaperIngredient(pStack)) {
			return Optional.of(1);
		} else {
			return pRecipe.isInkIngredient(pStack) ? Optional.of(2) : Optional.empty();
		}
	}

	public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot) {
		return pSlot.container != this.resultSlots && super.canTakeItemForPickAll(pStack, pSlot);
	}

	public boolean canMoveIntoInputSlots(ItemStack pStack) {
		return this.recipes.stream().map((p_266647_) -> {
			return findSlotMatchingIngredient(p_266647_, pStack);
		}).anyMatch(Optional::isPresent);
	}
}