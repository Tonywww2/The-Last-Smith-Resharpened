package cn.mmf.tls.enchantments;

import cn.mmf.tls.TheLastSmith;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentsRegistry {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(
    		ForgeRegistries.ENCHANTMENTS,
            TheLastSmith.MODID);
    public static final RegistryObject<Enchantment> SPIRIT_SLASH = ENCHANTMENTS.register("spirit_slash", SpiritSlashEnchantment::new);
    
    public static final RegistryObject<Enchantment> SPIRIT_ABSORPTION = ENCHANTMENTS.register("spirit_absorption", SpiritAbsorptionEnchantment::new);
}
