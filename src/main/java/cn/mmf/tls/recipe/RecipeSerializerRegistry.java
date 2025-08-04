package cn.mmf.tls.recipe;

import cn.mmf.tls.TheLastSmith;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeSerializerRegistry {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister
            .create(ForgeRegistries.RECIPE_TYPES, TheLastSmith.MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister
            .create(ForgeRegistries.RECIPE_SERIALIZERS, TheLastSmith.MODID);
    
    public static final RegistryObject<RecipeType<TLSResearchRecipe>> RESEARCH_RECIPE_TYPE = RECIPE_TYPES
            .register("research", () -> recipeType("research"));
    
    public static final RegistryObject<TLSResearchRecipe.Serializer> RESEARCH_RECIPE_SERIALIZER = RECIPE_SERIALIZER
            .register("research", TLSResearchRecipe.Serializer::new);

    
    private static <T extends Recipe<?>> RecipeType<T> recipeType(String name) {
        return new RecipeType<T>() {
            public String toString() {
                return new ResourceLocation(TheLastSmith.MODID, name).toString();
            }
        };
    }
}
