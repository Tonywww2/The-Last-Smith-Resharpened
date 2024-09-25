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
}
