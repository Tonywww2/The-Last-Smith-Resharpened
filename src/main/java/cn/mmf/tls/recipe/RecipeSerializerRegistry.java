package cn.mmf.tls.recipe;

import cn.mmf.tls.TheLastSmith;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeSerializerRegistry {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister
            .create(ForgeRegistries.RECIPE_SERIALIZERS, TheLastSmith.MODID);

    public static final RegistryObject<RecipeSerializer<?>> SLASHBLADE_SMITHING = RECIPE_SERIALIZER
            .register("slashblade_smithing", () -> SlashBladeSmithingRecipe.SERIALIZER);
}
