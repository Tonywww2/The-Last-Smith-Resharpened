package cn.mmf.tls;

import com.mojang.logging.LogUtils;

import cn.mmf.tls.combo.ComboStateRegistry;
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
		
		ComboStateRegistry.COMBO_STATE.register(modEventBus);
		TLSSlashArtsRegistry.SLASH_ARTS.register(modEventBus);
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
