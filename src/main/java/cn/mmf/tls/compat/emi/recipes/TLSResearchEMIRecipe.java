package cn.mmf.tls.compat.emi.recipes;

import cn.mmf.tls.compat.emi.EMICompat;
import cn.mmf.tls.recipe.TLSResearchRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import java.util.ArrayList;
import java.util.List;

public class TLSResearchEMIRecipe extends EMISimpleRecipe {
    private final TLSResearchRecipe recipe;

    public TLSResearchEMIRecipe(TLSResearchRecipe recipe) {
        super(createInputs(recipe), List.of(EmiStack.of(recipe.output)), recipe.getId());
        this.recipe = recipe;
    }

    private static List<EmiIngredient> createInputs(TLSResearchRecipe recipe) {
        List<EmiIngredient> inputs = new ArrayList<>();
        inputs.add(EmiIngredient.of(recipe.blade));
        inputs.add(EmiIngredient.of(recipe.paper));
        inputs.add(EmiIngredient.of(recipe.ink));
        return inputs;
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return EMICompat.RESEARCH_CATEGORY;
    }

    @Override
    public int getDisplayWidth() {
        return 105;
    }

    @Override
    public int getDisplayHeight() {
        return 54;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addSlot(EmiIngredient.of(recipe.blade), 14, 7);
        widgets.addSlot(EmiIngredient.of(recipe.paper), 4, 31);
        widgets.addSlot(EmiIngredient.of(recipe.ink), 24, 31);
        widgets.addSlot(outputs.get(0), 82, 19);
    }
}