package cn.mmf.tls.data;

import java.util.function.Consumer;

import cn.mcmod_mmf.mmlib.data.AbstractRecipeProvider;
import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.data.tag.TLSItemTags;
import cn.mmf.tls.item.ItemRegistry;
import cn.mmf.tls.recipe.SlashBladeSmithingRecipeBuilder;
import cn.mmf.tls.recipe.TLSResearchRecipeBuilder;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.init.SBItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class TLSRecipeProvider extends AbstractRecipeProvider {

	public TLSRecipeProvider(PackOutput gen) {
		super(gen);
		
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		SlashBladeSmithingRecipeBuilder.smithing(
				Ingredient.of(ItemRegistry.SCROLL.get()), 
				Ingredient.of(SBItems.slashblade_wood), 
				Ingredient.of(TLSItemTags.BAMBOO), 
				RecipeCategory.COMBAT, 
				SlashBlade.prefix("slashblade_bamboo"))
		.unlocks(getHasName(SBItems.slashblade_wood), has(SBItems.slashblade_wood))
		.save(consumer, SlashBlade.prefix("slashblade_bamboo"));
		
		TLSResearchRecipeBuilder.researching(
				Ingredient.of(Items.WOODEN_SWORD), 
				ItemRegistry.SCROLL.get()
				)	
		.unlocks(getHasName(Items.WOODEN_SWORD), has(Items.WOODEN_SWORD))
		.save(consumer, TheLastSmith.prefix("research/first_research"));
	}

}
