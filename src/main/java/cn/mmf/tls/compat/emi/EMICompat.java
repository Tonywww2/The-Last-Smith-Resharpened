package cn.mmf.tls.compat.emi;

import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.compat.emi.recipes.TLSCauldronEMIRecipe;
import cn.mmf.tls.compat.emi.recipes.TLSResearchEMIRecipe;
import cn.mmf.tls.item.ItemRegistry;
import cn.mmf.tls.recipe.RecipeSerializerRegistry;
import cn.mmf.tls.recipe.TLSResearchRecipe;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.Container;

import java.util.List;

@EmiEntrypoint
public class EMICompat implements EmiPlugin {

    public static final EmiRecipeCategory RESEARCH_CATEGORY = new EmiRecipeCategory(
            TheLastSmith.prefix("research"),
            EmiStack.of(ItemRegistry.RESEARCH_TABLE.get())
    );

    public static final EmiRecipeCategory CAULDRON_CATEGORY = new EmiRecipeCategory(
            TheLastSmith.prefix("cauldron"),
            EmiStack.of(Items.CAULDRON)
    );

    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(RESEARCH_CATEGORY);
        registry.addCategory(CAULDRON_CATEGORY);

        List<TLSResearchRecipe> researchRecipes = findRecipesByType(RecipeSerializerRegistry.RESEARCH_RECIPE_TYPE.get());
        for (TLSResearchRecipe recipe : researchRecipes) {
            registry.addRecipe(new TLSResearchEMIRecipe(recipe));
        }

        registry.addRecipe(new TLSCauldronEMIRecipe(
                ItemRegistry.BLADE_SAKURA_UNFINISHED_3.get().getDefaultInstance(),
                ItemRegistry.BLADE_SAKURA_UNFINISHED_4.get().getDefaultInstance(),
                TheLastSmith.prefix("cauldron_sakura_blade")
        ));

        registry.addRecipe(new TLSCauldronEMIRecipe(
                ItemRegistry.BLADE_UNFINISHED_3.get().getDefaultInstance(),
                ItemRegistry.BLADE_UNFINISHED_4.get().getDefaultInstance(),
                TheLastSmith.prefix("cauldron_normal_blade")
        ));


        registry.addWorkstation(RESEARCH_CATEGORY, EmiStack.of(ItemRegistry.RESEARCH_TABLE.get()));
        registry.addWorkstation(CAULDRON_CATEGORY, EmiStack.of(Items.CAULDRON));
    }

	private static <C extends Container, T extends Recipe<C>> List<T> findRecipesByType(RecipeType<T> type) {
        Minecraft instance = Minecraft.getInstance();
		return instance.level.getRecipeManager().getAllRecipesFor(type);
    }
}