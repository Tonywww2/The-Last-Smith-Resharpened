 package cn.mmf.tls;

import com.mojang.logging.LogUtils;

import cn.mmf.tls.block.BlockRegistry;
import cn.mmf.tls.combo.ComboStateRegistry;
import cn.mmf.tls.item.ItemRegistry;
import cn.mmf.tls.menus.ContainerRegistry;
import cn.mmf.tls.recipe.RecipeSerializerRegistry;
import cn.mmf.tls.slasharts.TLSSlashArtsRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TheLastSmith.MODID)
public class TheLastSmith {
	public static final String MODID = "last_smith";
	private static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation prefix(String path) {
        return new ResourceLocation(MODID, path);
    }

	public TheLastSmith() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemRegistry.ITEMS.register(modEventBus);
		BlockRegistry.BLOCKS.register(modEventBus);
		TLSCreativeGroup.CREATIVE_MODE_TABS.register(modEventBus);
		RecipeSerializerRegistry.RECIPE_TYPES.register(modEventBus);
		RecipeSerializerRegistry.RECIPE_SERIALIZER.register(modEventBus);
		ContainerRegistry.CONTAINER_TYPES.register(modEventBus);
		
		ComboStateRegistry.COMBO_STATE.register(modEventBus);
		TLSSlashArtsRegistry.SLASH_ARTS.register(modEventBus);

	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
