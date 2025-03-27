package cn.mmf.tls.data;

import cn.mcmod_mmf.mmlib.data.AbstractLangProvider;
import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.data.builtin.BuiltInSlashBladeRegistry;
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
		addSlashBlade(BuiltInSlashBladeRegistry.AMAGUMO_KAZE, "Amagumo-Kaze-");
		addSlashBlade(BuiltInSlashBladeRegistry.AMAGUMO_KUMO, "Amagumo-Kumo-");
		addSlashBlade(BuiltInSlashBladeRegistry.AMAGUMO_MUNIN, "Amagumo-Munin-");
		addSlashBlade(BuiltInSlashBladeRegistry.BUNSHI, "-BunShi-");
		addSlashBlade(BuiltInSlashBladeRegistry.SAKURAGIRI, "-Sakura Giri-");
		addSlashBlade(BuiltInSlashBladeRegistry.YAMATO, "-Yamato-");
		addSlashBlade(BuiltInSlashBladeRegistry.ROUKANKEN, "-Roukanken-");
		addSlashBlade(BuiltInSlashBladeRegistry.ROUKANKEN_NETHER, "Gokukaiken-Roukanken-");
		addSlashBlade(BuiltInSlashBladeRegistry.HAKUROUKEN, "-Hakuroken-");
		addSlashBlade(BuiltInSlashBladeRegistry.HAKUROUKEN_NETHER, "Gokukaiken-Hakuroken-");
		
		addSlashBlade(BuiltInSlashBladeRegistry.NAMELESS_ODACHI, "Anonymity -Nameless-");
		addSlashBlade(BuiltInSlashBladeRegistry.MURAMASA_KAGURA, "-Kagura- Muramasa");
		
		addSlashBlade(BuiltInSlashBladeRegistry.EXORCISM_SAKURA, "Exorcism-Sakura-");
		addSlashBlade(BuiltInSlashBladeRegistry.EXORCISM_GINKGO, "Exorcism-Ginkgo-");
		addSlashBlade(BuiltInSlashBladeRegistry.EXORCISM_YUKI, "Exorcism-Yukikage-");
		addSlashBlade(BuiltInSlashBladeRegistry.EVIL_KATAWARE, "Evil-Kataware-");
		addSlashBlade(BuiltInSlashBladeRegistry.EVIL_SHURA, "Evil-Shura-");
		
		add("slash_art.last_smith.transmigration_slash", "Transmigration Slash");
	}
    private void addSlashBlade(ResourceKey<SlashBladeDefinition> data, String name) {
        this.addSlashBlade(data.location(), name);
    }

    private void addSlashBlade(ResourceLocation key, String name) {
        add(Util.makeDescriptionId("item", key), name);
    }
}
