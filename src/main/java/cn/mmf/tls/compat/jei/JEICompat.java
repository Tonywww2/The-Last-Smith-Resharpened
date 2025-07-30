package cn.mmf.tls.compat.jei;

import java.util.List;

import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.client.screen.ResearchTableScreen;
import cn.mmf.tls.item.ItemRegistry;
import cn.mmf.tls.menus.ResearchMenu;
import cn.mmf.tls.recipe.RecipeSerializerRegistry;
import cn.mmf.tls.recipe.SlashBladeSmithingRecipe;
import cn.mmf.tls.recipe.TLSResearchRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.category.extensions.vanilla.smithing.IExtendableSmithingRecipeCategory;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

@JeiPlugin
public class JEICompat implements IModPlugin {
    public static final mezz.jei.api.recipe.RecipeType<TLSResearchRecipe> RESEARCH_JEI_TYPE = mezz.jei.api.recipe.RecipeType
            .create(TheLastSmith.MODID, "research", TLSResearchRecipe.class);
    
    private static final Minecraft MC = Minecraft.getInstance();

    private static <C extends Container, T extends Recipe<C>> List<T> findRecipesByType(RecipeType<T> type) {
        return MC.level.getRecipeManager().getAllRecipesFor(type);
    }
    
	@Override
	public ResourceLocation getPluginUid() {
		return TheLastSmith.prefix(TheLastSmith.MODID);
	}
	
    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new TLSResearchJEICategory(registry.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(RESEARCH_JEI_TYPE, findRecipesByType(RecipeSerializerRegistry.RESEARCH_RECIPE_TYPE.get()));
    }
    
	@Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(ItemRegistry.RESEARCH_TABLE.get().getDefaultInstance(), RESEARCH_JEI_TYPE);
    }
	
    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(ResearchTableScreen.class, 74, 22, 28, 21, RESEARCH_JEI_TYPE);

    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(ResearchMenu.class, null, RESEARCH_JEI_TYPE, 0, 3, 4, 36);
    }

	@Override
	public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {
		IExtendableSmithingRecipeCategory smithingCategory = registration.getSmithingCategory();
		
		smithingCategory.addExtension(SlashBladeSmithingRecipe.class, new SlashBladeSmithingCategoryExtension());
	}
}
