package cn.mmf.tls.recipe;

import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmithingRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class SlashBladeSmithingRecipe implements SmithingRecipe {
	// TODO: 关联分类-刀-材料的合成
	
	private final ResourceLocation outputBlade;
	
	public SlashBladeSmithingRecipe(ResourceLocation outputBlade) {
		super();
		this.outputBlade = outputBlade;
	}
	
    private static ItemStack getResultBlade(ResourceLocation outputBlade) {
        Item bladeItem = ForgeRegistries.ITEMS.containsKey(outputBlade) ? ForgeRegistries.ITEMS.getValue(outputBlade)
                : SBItems.slashblade;

        return bladeItem.getDefaultInstance();
    }
    
    @Override
    public ItemStack getResultItem(RegistryAccess access) {
        ItemStack result = SlashBladeSmithingRecipe.getResultBlade(this.getOutputBlade());

        if (!ForgeRegistries.ITEMS.getKey(result.getItem()).equals(getOutputBlade())) {
            result = access.registryOrThrow(SlashBladeDefinition.REGISTRY_KEY).get(getOutputBlade())
                    .getBlade(result.getItem());
        }

        return result;
    }
	
	@Override
	public boolean matches(Container container, Level level) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack assemble(Container container, RegistryAccess access) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResourceLocation getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTemplateIngredient(ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBaseIngredient(ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdditionIngredient(ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	public ResourceLocation getOutputBlade() {
		return outputBlade;
	}

}
