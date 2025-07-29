package cn.mmf.tls.recipe;

import java.util.stream.Stream;

import com.google.gson.JsonObject;

import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.registries.ForgeRegistries;

public class TLSResearchRecipe implements Recipe<Container> {
	private final ResourceLocation id;
	
	public Ingredient blade;
	public Ingredient paper;
	public Ingredient ink;

	public ItemStack output;
	
	public TLSResearchRecipe(ResourceLocation id, ItemStack output, Ingredient blade, Ingredient paper, Ingredient ink) {
		super();
		this.id = id;
		this.output = output;
		this.blade = blade;
		this.paper = paper;
		this.ink = ink;
	}

	public TLSResearchRecipe(ItemStack output, Ingredient blade, Ingredient paper, Ingredient ink) {
		this(ForgeRegistries.ITEMS.getKey(output.getItem()), output, blade, paper, ink);
	}


	@Override
	public boolean matches(Container wrapper, Level level) {
		return this.blade.test(wrapper.getItem(0)) && this.paper.test(wrapper.getItem(1))
				&& this.ink.test(wrapper.getItem(2));
	}

	@Override
	public boolean isIncomplete() {
		return Stream.of(this.blade, this.paper, this.ink).anyMatch(ForgeHooks::hasNoElements);
	}

	@Override
	public ItemStack assemble(Container wrapper, RegistryAccess access) {
		return this.output;
	}

	@Override
	public boolean canCraftInDimensions(int x, int y) {
		return x >= 3 && y >= 1;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess access) {
		return this.output;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return RecipeSerializerRegistry.RESEARCH_RECIPE_SERIALIZER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return RecipeSerializerRegistry.RESEARCH_RECIPE_TYPE.get();
	}

	public boolean isBladeIngredient(ItemStack stack) {
		return this.blade.test(stack);
	}

	public boolean isPaperIngredient(ItemStack stack) {
		return this.paper.test(stack);
	}

	public boolean isInkIngredient(ItemStack stack) {
		return this.ink.test(stack);
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}
	
	public static class Serializer implements RecipeSerializer<TLSResearchRecipe> {
        public TLSResearchRecipe fromJson(ResourceLocation id, JsonObject json) {
           Ingredient blade = Ingredient.fromJson(GsonHelper.getNonNull(json, "blade"));
           Ingredient paper = Ingredient.fromJson(GsonHelper.getNonNull(json, "paper"));
           Ingredient ink = Ingredient.fromJson(GsonHelper.getNonNull(json, "ink"));
           ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));
           return new TLSResearchRecipe(id, output, blade, paper, ink);
        }

        public TLSResearchRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
           Ingredient blade = Ingredient.fromNetwork(buffer);
           Ingredient paper = Ingredient.fromNetwork(buffer);
           Ingredient ink = Ingredient.fromNetwork(buffer);
           ItemStack output = buffer.readItem();
           return new TLSResearchRecipe(id, output, blade, paper, ink);
        }

        public void toNetwork(FriendlyByteBuf buffer, TLSResearchRecipe recipe) {
           recipe.blade.toNetwork(buffer);
           recipe.paper.toNetwork(buffer);
           recipe.ink.toNetwork(buffer);
           buffer.writeItem(recipe.output);
        }
     }
}
