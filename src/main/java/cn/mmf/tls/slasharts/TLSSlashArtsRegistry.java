package cn.mmf.tls.slasharts;

import cn.mmf.tls.TheLastSmith;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import cn.mmf.tls.combo.ComboStateRegistry;

public class TLSSlashArtsRegistry {
    public static final DeferredRegister<SlashArts> SLASH_ARTS = DeferredRegister.create(SlashArts.REGISTRY_KEY,
            TheLastSmith.MODID);
    public static final RegistryObject<SlashArts> Transmigration_Slash = SLASH_ARTS.register("transmigration_slash",
            () -> new SlashArts(e -> ComboStateRegistry.ODACHI_COMBO_A1.getId()));
    
    public static final RegistryObject<SlashArts> FUSHIGIRI = SLASH_ARTS.register("fushigiri",
            () -> new SlashArts(e -> ComboStateRegistry.FUSHIGIRI_LEFT.getId()));
    
    public static final RegistryObject<SlashArts> IAI_CROSS = SLASH_ARTS.register("iai_cross",
            () -> new SlashArts(e -> ComboStateRegistry.IAI_CROSS_SLASH.getId()));
    
    public static final RegistryObject<SlashArts> SAKURA_BLISTERING_SWORDS = SLASH_ARTS.register("sakura_blistering_swords",
            () -> new SlashArts(e -> ComboStateRegistry.SAKURA_BLISTERING_SWORDS.getId()));
}
