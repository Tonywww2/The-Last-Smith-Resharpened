package cn.mmf.tls.data;

import cn.mcmod_mmf.mmlib.data.AbstractLangProvider;
import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.data.builtin.TLSSlashBladeRegistry;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class TLSLangProvider extends AbstractLangProvider {

	public TLSLangProvider(PackOutput gen) {
		super(gen, TheLastSmith.MODID, "en_us");
	}

	@Override
	protected void addTranslations() {
		addSlashBlade(TLSSlashBladeRegistry.AMAGUMO_KAZE, "Amagumo-Kaze-");
		addSlashBlade(TLSSlashBladeRegistry.AMAGUMO_KUMO, "Amagumo-Kumo-");
		addSlashBlade(TLSSlashBladeRegistry.AMAGUMO_MUNIN, "Amagumo-Munin-");
		addSlashBlade(TLSSlashBladeRegistry.BUNSHI, "-BunShi-");
		addSlashBlade(TLSSlashBladeRegistry.SAKURAGIRI, "-Sakura Giri-");
		addSlashBlade(TLSSlashBladeRegistry.YAMATO, "-Yamato-");
		addSlashBlade(TLSSlashBladeRegistry.ROUKANKEN, "-Roukanken-");
		addSlashBlade(TLSSlashBladeRegistry.ROUKANKEN_NETHER, "Gokukaiken-Roukanken-");
		addSlashBlade(TLSSlashBladeRegistry.HAKUROUKEN, "-Hakuroken-");
		addSlashBlade(TLSSlashBladeRegistry.HAKUROUKEN_NETHER, "Gokukaiken-Hakuroken-");
		
		addSlashBlade(TLSSlashBladeRegistry.NAMELESS_ODACHI, "Anonymity -Nameless-");
		addSlashBlade(TLSSlashBladeRegistry.MURAMASA_KAGURA, "-Kagura- Muramasa");
		
		addSlashBlade(TLSSlashBladeRegistry.EXORCISM_SAKURA, "Exorcism-Sakura-");
		addSlashBlade(TLSSlashBladeRegistry.EXORCISM_GINKGO, "Exorcism-Ginkgo-");
		addSlashBlade(TLSSlashBladeRegistry.EXORCISM_YUKI, "Exorcism-Yukikage-");
		addSlashBlade(TLSSlashBladeRegistry.EVIL_KATAWARE, "Evil-Kataware-");
		addSlashBlade(TLSSlashBladeRegistry.EVIL_SHURA, "Evil-Shura-");
		
		add("slash_art.last_smith.transmigration_slash", "Transmigration Slash");
	}
    private void addSlashBlade(ResourceKey<SlashBladeDefinition> data, String name) {
        this.addSlashBlade(data.location(), name);
    }

    private void addSlashBlade(ResourceLocation key, String name) {
        add(Util.makeDescriptionId("item", key), name);
    }
}
