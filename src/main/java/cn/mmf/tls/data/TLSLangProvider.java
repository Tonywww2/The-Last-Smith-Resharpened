package cn.mmf.tls.data;

import cn.mcmod_mmf.mmlib.data.AbstractLangProvider;
import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.block.BlockRegistry;
import cn.mmf.tls.data.builtin.TLSSlashBladeRegistry;
import cn.mmf.tls.enchantments.EnchantmentsRegistry;
import cn.mmf.tls.item.ItemRegistry;
import cn.mmf.tls.se.TLSSpecialEffectRegistry;
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
		add("itemGroup.the_last_smith", "The Last Smith");
		add("last_smith.jei.research", "Researching");
		add("container.last_smith.research", "Researching");
		
		add("last_smith.jei.cauldron", "Cauldron Quenching");
		add("last_smith.jei.cauldron_need_water", "Need some water in the cauldron.");

		add("emi.category.last_smith.research", "Researching");
		add("emi.category.last_smith.cauldron", "Cauldron Quenching");

		add("container.last_smith.research.error_tooltip", "Can't do any research this way");
		add("container.last_smith.research.missing_blade_tooltip", "Add the blade or research");
		add("container.last_smith.research.missing_paper_tooltip", "Add papers or research");
		add("container.last_smith.research.missing_ink_tooltip", "Add ink");
		
		addBlock(BlockRegistry.RESEARCH_TABLE, "Researching Table");
		
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
		
		addSlashBlade(TLSSlashBladeRegistry.EXORCISM_SAKURA, "Exorcism -Sakura-");
		addSlashBlade(TLSSlashBladeRegistry.EXORCISM_GINKGO, "Exorcism -Ginkgo-");
		addSlashBlade(TLSSlashBladeRegistry.EXORCISM_YUKI, "Exorcism -Yukikage-");
		addSlashBlade(TLSSlashBladeRegistry.EVIL_KATAWARE, "Evil -Kataware-");
		addSlashBlade(TLSSlashBladeRegistry.EVIL_SHURA, "Evil -Shura-");
		
		addSlashBlade(TLSSlashBladeRegistry.NAGASADA, "Spirit -Nagasada-");
		
		addSlashBlade(TLSSlashBladeRegistry.KUSABIMARU, "Named -Kusabimaru-");
		addSlashBlade(TLSSlashBladeRegistry.FUSHIGIRI, "Fushigiri -Hairui-");
		
		addSlashBlade(TLSSlashBladeRegistry.SAGEQUOIA, "Named -Sagequoia-");
		
		addSlashBlade(TLSSlashBladeRegistry.BAMBOO_TOP, "Top -Bamboo Light-");
		addSlashBlade(TLSSlashBladeRegistry.BAMBOO_HERMIT, "The Hermit's Bamboo Light");
		addSlashBlade(TLSSlashBladeRegistry.GOLDENBAMBOO, "Noted -Golden Bamboo Light-");
		addSlashBlade(TLSSlashBladeRegistry.SILVERBAMBOO_TOP, "Top -Silver Bamboo Light-");
		addSlashBlade(TLSSlashBladeRegistry.SILVERBAMBOO_BLOOD, "-Bloody Bamboo Light-");
		
		add("slash_art.last_smith.transmigration_slash", "Transmigration Slash");
		add("slash_art.last_smith.fushigiri", "Mortal Draw");
		add("slash_art.last_smith.iai_cross", "Ashina Cross");
		add("slash_art.last_smith.sakura_blistering_swords", "Sakura -Blistering-");
		
		addEnchantment(EnchantmentsRegistry.SPIRIT_SLASH, "Spirit Slash");
		
		addSpecialEffect(TLSSpecialEffectRegistry.EXTRA_POWER.getId(), "Spirit Power");
		addSpecialEffect(TLSSpecialEffectRegistry.BEWITCHED_POWER.getId(), "Bewitched Power");
		addSpecialEffect(TLSSpecialEffectRegistry.EXTRA_SHARPNESS.getId(), "Spirit Sharpness");
		addSpecialEffect(TLSSpecialEffectRegistry.EXTREME_SHARPNESS.getId(), "Extreme Sharpness");
		
		addSpecialEffect(TLSSpecialEffectRegistry.SMITE_SE.getId(), "Exorcism");
		addSpecialEffect(TLSSpecialEffectRegistry.EXTRA_SMITE.getId(), "Nirvana");
		addSpecialEffect(TLSSpecialEffectRegistry.FUSHIGIRI_SE.getId(), "Fushigiri");
		
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
        addItem(ItemRegistry.SCROLL_SHURA, "Story of The Shura");
        addItem(ItemRegistry.SCROLL_MURAMASA, "Story of The Muramasa");
        addItem(ItemRegistry.SCROLL_STAR, "Story of The Meteorn");
        addItem(ItemRegistry.SCROLL_GOD, "Story of The God's Blade");
        addItem(ItemRegistry.SCROLL_BLOOD, "Story of The Blood Blade");
        addItem(ItemRegistry.SCROLL_YAMATO, "Story of The Yamato");
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
    
    private void addSpecialEffect(ResourceLocation key, String name) {
        add(Util.makeDescriptionId("se", key), name);
    }

}
