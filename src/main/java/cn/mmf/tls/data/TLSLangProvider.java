package cn.mmf.tls.data;

import cn.mcmod_mmf.mmlib.data.AbstractLangProvider;
import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.data.builtin.TLSSlashBladeRegistry;
import cn.mmf.tls.item.ItemRegistry;
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
		addSlashBlade(TLSSlashBladeRegistry.AMAGUMO_KAZE, "Amagumo -Kaze-");
		addSlashBlade(TLSSlashBladeRegistry.AMAGUMO_KUMO, "Amagumo -Kumo-");
		addSlashBlade(TLSSlashBladeRegistry.AMAGUMO_MUNIN, "Amagumo -Munin-");
		addSlashBlade(TLSSlashBladeRegistry.BUNSHI, "-BunShi-");
		addSlashBlade(TLSSlashBladeRegistry.SAKURAGIRI, "-Sakura Giri-");
		addSlashBlade(TLSSlashBladeRegistry.YAMATO, "-Yamato-");
		addSlashBlade(TLSSlashBladeRegistry.ROUKANKEN, "-Roukanken-");
		addSlashBlade(TLSSlashBladeRegistry.ROUKANKEN_NETHER, "Inferno -Roukanken-");
		addSlashBlade(TLSSlashBladeRegistry.HAKUROUKEN, "-Hakuroken-");
		addSlashBlade(TLSSlashBladeRegistry.HAKUROUKEN_NETHER, "Inferno -Hakuroken-");
		
		addSlashBlade(TLSSlashBladeRegistry.NAMELESS_ODACHI, "Odachi --");
		addSlashBlade(TLSSlashBladeRegistry.MURAMASA_KAGURA, "-Kagura- Muramasa");
		
		addSlashBlade(TLSSlashBladeRegistry.EXORCISM_SAKURA, "Exorcism-Sakura-");
		addSlashBlade(TLSSlashBladeRegistry.EXORCISM_GINKGO, "Exorcism-Ginkgo-");
		addSlashBlade(TLSSlashBladeRegistry.EXORCISM_YUKI, "Exorcism-Yukikage-");
		addSlashBlade(TLSSlashBladeRegistry.EVIL_KATAWARE, "Evil-Kataware-");
		addSlashBlade(TLSSlashBladeRegistry.EVIL_SHURA, "Evil-Shura-");
		
		add("slash_art.last_smith.transmigration_slash", "Transmigration Slash");
		
		addItem(ItemRegistry.SAKURA, "Spirit Sakura Leaf");
        addItem(ItemRegistry.SAKURA_FULL, "Spirit Sakura");
        addItem(ItemRegistry.SAKURA_STEEL_INGOT, "Spirit Sakura Steel");
        addItem(ItemRegistry.SAKURA_SPHERE, "Sakura Spirit Sphere");
        addItem(ItemRegistry.YAKIBATSUCHI, "Yakibatsuchi");
        
		addItem(ItemRegistry.BLADE, "Iron Blade");
        addItem(ItemRegistry.BLADE_UNFINISHED_1, "Unfinished Blade");
        addItem(ItemRegistry.BLADE_UNFINISHED_2, "Unfinished Blade");
        addItem(ItemRegistry.BLADE_UNFINISHED_3, "Unfinished Blade");
        addItem(ItemRegistry.BLADE_UNFINISHED_4, "Unfinished Blade");
        
		addItem(ItemRegistry.BLADE_SAKURA, "Sprite Sakura Blade");
        addItem(ItemRegistry.BLADE_SAKURA_UNFINISHED_1, "Unfinished Sprite Blade");
        addItem(ItemRegistry.BLADE_SAKURA_UNFINISHED_2, "Unfinished Sprite Blade");
        addItem(ItemRegistry.BLADE_SAKURA_UNFINISHED_3, "Unfinished Sprite Blade");
        addItem(ItemRegistry.BLADE_SAKURA_UNFINISHED_4, "Unfinished Sprite Blade");
		
        addItem(ItemRegistry.SCROLL_BASIC, "Basic Note");
        addItem(ItemRegistry.SCROLL_WOOD_BASIC, "Note of Bamboo Blade");
        addItem(ItemRegistry.SCROLL_BLADE, "Note of Iron Blade");
        addItem(ItemRegistry.SCROLL_WOOD_KIWAMI, "Story of The Ultimate Wood");
        addItem(ItemRegistry.SCROLL_SAKURA, "Note of Sprite Sakura");
        addItem(ItemRegistry.SCROLL_SAKURA_BLADE, "Note of Sprite Blade");
        addItem(ItemRegistry.SCROLL_SAKURA_FULL, "The Full Research of Sprite Sakura");
        addItem(ItemRegistry.SCROLL_EXORCISM, "Story of The Exorcism Blades");
        addItem(ItemRegistry.SCROLL_KATANA, "Note of Katana");
        addItem(ItemRegistry.SCROLL_ODACHI, "Notes of Odachi");
        addItem(ItemRegistry.SCROLL_MURAMASA, "Story of The Muramasa");
        addItem(ItemRegistry.SCROLL_STAR, "Story of The Meteorn");
        addItem(ItemRegistry.SCROLL_GOD, "Story of The God's Blade");
        addItem(ItemRegistry.SCROLL_BLOOD, "Story of The Blood Blade");
        addItem(ItemRegistry.SCROLL_MORTAL, "Story of The Mortal Blade");
        addItem(ItemRegistry.SCROLL_BEWITCHED, "Story of The Bewitched Power");
        addItem(ItemRegistry.SCROLL_HEIL, "Story of The Inferno Blade");
        addItem(ItemRegistry.SCROLL_TENGU_VOL1, "History of Tengu Vol.1");
        addItem(ItemRegistry.SCROLL_TENGU_VOL2, "History of Tengu Vol.2");
        addItem(ItemRegistry.SCROLL_TENGU_FULL, "The Story of The Last Smith");
	}
    private void addSlashBlade(ResourceKey<SlashBladeDefinition> data, String name) {
        this.addSlashBlade(data.location(), name);
    }

    private void addSlashBlade(ResourceLocation key, String name) {
        add(Util.makeDescriptionId("item", key), name);
    }

}
