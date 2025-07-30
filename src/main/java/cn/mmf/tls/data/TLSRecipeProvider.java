package cn.mmf.tls.data;

import java.util.function.Consumer;

import cn.mcmod_mmf.mmlib.data.AbstractRecipeProvider;
import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.data.builtin.TLSSlashBladeRegistry;
import cn.mmf.tls.data.tag.TLSItemTags;
import cn.mmf.tls.item.ItemRegistry;
import cn.mmf.tls.recipe.SlashBladeSmithingRecipeBuilder;
import cn.mmf.tls.recipe.TLSResearchRecipeBuilder;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.recipe.RequestDefinition;
import mods.flammpfeil.slashblade.recipe.SlashBladeIngredient;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

public class TLSRecipeProvider extends AbstractRecipeProvider {

	public TLSRecipeProvider(PackOutput gen) {
		super(gen);
		
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		vanillaSlashBladeRecipes(consumer);
		
		SlashBladeSmithingRecipeBuilder.smithing(
				Ingredient.of(ItemRegistry.SCROLL_KATANA.get()), 
				Ingredient.of(SBItems.slashblade_white),  
				Ingredient.of(Tags.Items.DYES_CYAN), 
				RecipeCategory.COMBAT, 
				TLSSlashBladeRegistry.NAGASADA.location())
		.unlocks(getHasName(ItemRegistry.SCROLL_KATANA.get()), has(ItemRegistry.SCROLL_KATANA.get()))
		.save(consumer, TheLastSmith.prefix("nagasada"));
		
		SlashBladeSmithingRecipeBuilder.smithing(
				Ingredient.of(ItemRegistry.SCROLL_ODACHI.get()), 
				Ingredient.of(SBItems.slashblade),  
				Ingredient.of(SBItems.proudsoul_ingot), 
				RecipeCategory.COMBAT, 
				TLSSlashBladeRegistry.NAMELESS_ODACHI.location())
		.unlocks(getHasName(ItemRegistry.SCROLL_ODACHI.get()), has(ItemRegistry.SCROLL_ODACHI.get()))
		.save(consumer, TheLastSmith.prefix("nameless_odachi"));
		
		researchRecipes(consumer);
	}

	private void vanillaSlashBladeRecipes(Consumer<FinishedRecipe> consumer) {
		SlashBladeSmithingRecipeBuilder.smithing(
				Ingredient.of(ItemRegistry.SCROLL_BASIC.get()), 
				Ingredient.of(SBItems.slashblade_wood), 
				Ingredient.of(TLSItemTags.BAMBOO), 
				RecipeCategory.COMBAT, 
				SlashBlade.prefix("slashblade_bamboo"))
		.unlocks(getHasName(SBItems.slashblade_wood), has(SBItems.slashblade_wood))
		.save(consumer, SlashBlade.prefix("slashblade_bamboo"));
		
		SlashBladeSmithingRecipeBuilder.smithing(
				Ingredient.of(ItemRegistry.SCROLL_BASIC.get()), 
				Ingredient.of(SBItems.slashblade_wood), 
				Ingredient.of(ItemRegistry.BLADE.get()), 
				RecipeCategory.COMBAT, 
				SlashBlade.prefix("slashblade_white"))
		.unlocks(getHasName(SBItems.slashblade_wood), has(SBItems.slashblade_wood))
		.save(consumer, SlashBlade.prefix("slashblade_white"));
		
		SlashBladeSmithingRecipeBuilder.smithing(
				Ingredient.of(ItemRegistry.SCROLL_BLADE.get()), 
				Ingredient.of(SBItems.slashblade_white), 
				 SlashBladeIngredient.of(SBItems.slashblade_silverbamboo,
                         RequestDefinition.Builder.newInstance().addSwordType(SwordType.BROKEN).build()), 
				RecipeCategory.COMBAT, 
				SlashBlade.prefix("slashblade"))
		.unlocks(getHasName(SBItems.slashblade_white), has(SBItems.slashblade_white))
		.save(consumer, SlashBlade.prefix("slashblade"));
		
		SlashBladeSmithingRecipeBuilder.smithing(
				Ingredient.of(ItemRegistry.SCROLL_KATANA.get()), 
				SlashBladeIngredient.of(SBItems.slashblade_silverbamboo,
                         RequestDefinition.Builder.newInstance().addSwordType(SwordType.BROKEN).build()), 
				Ingredient.of(ItemRegistry.BLADE.get()), 
				RecipeCategory.COMBAT, 
				SlashBlade.prefix("slashblade"))
		.unlocks(getHasName(SBItems.slashblade_white), has(SBItems.slashblade_white))
		.save(consumer, TheLastSmith.prefix("slashblade_from_bamboolight"));
	}

	private void researchRecipes(Consumer<FinishedRecipe> consumer) {
		TLSResearchRecipeBuilder.researching(
				Ingredient.of(SBItems.slashblade_wood), 
				ItemRegistry.SCROLL_BASIC.get()
				)	
		.unlocks(getHasName(SBItems.slashblade_wood), has(SBItems.slashblade_wood))
		.save(consumer, TheLastSmith.prefix("research/scroll_basic"));
		
		TLSResearchRecipeBuilder.researching(
				Ingredient.of(SBItems.slashblade_bamboo), 
				ItemRegistry.SCROLL_WOOD_BASIC.get()
				)	
		.unlocks(getHasName(SBItems.slashblade_bamboo), has(SBItems.slashblade_bamboo))
		.save(consumer, TheLastSmith.prefix("research/scroll_wood_basic"));
		
		TLSResearchRecipeBuilder.researching(
				Ingredient.of(SBItems.slashblade_white), 
				ItemRegistry.SCROLL_BLADE.get()
				)	
		.unlocks(getHasName(SBItems.slashblade_white), has(SBItems.slashblade_white))
		.save(consumer, TheLastSmith.prefix("research/scroll_blade"));
		
		TLSResearchRecipeBuilder.researching(
				Ingredient.of(SBItems.slashblade), 
				ItemRegistry.SCROLL_KATANA.get()
				)	
		.unlocks(getHasName(SBItems.slashblade), has(SBItems.slashblade))
		.save(consumer, TheLastSmith.prefix("research/scroll_katana"));
		
		TLSResearchRecipeBuilder.researching(
				Ingredient.of(ItemRegistry.SAKURA_FULL.get()), 
				ItemRegistry.SCROLL_SAKURA.get()
				)	
		.unlocks(getHasName(ItemRegistry.SAKURA_FULL.get()), has(ItemRegistry.SAKURA_FULL.get()))
		.save(consumer, TheLastSmith.prefix("research/scroll_sakura"));
		
		TLSResearchRecipeBuilder.researching(
				Ingredient.of(ItemRegistry.SCROLL_KATANA.get()), 
				Ingredient.of(ItemRegistry.SCROLL_BLADE.get()), 
				Ingredient.of(Tags.Items.DYES_BLACK),  
				RecipeCategory.MISC, 
				ItemRegistry.SCROLL_ODACHI.get().getDefaultInstance()
				)	
		.unlocks(getHasName(ItemRegistry.SCROLL_KATANA.get()), has(ItemRegistry.SCROLL_KATANA.get()))
		.save(consumer, TheLastSmith.prefix("research/scroll_odachi"));
	}

}
