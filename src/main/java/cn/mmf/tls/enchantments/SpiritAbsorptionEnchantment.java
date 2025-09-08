package cn.mmf.tls.enchantments;

import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class SpiritAbsorptionEnchantment extends Enchantment {

	public SpiritAbsorptionEnchantment() {
		super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return stack.getCapability(ItemSlashBlade.BLADESTATE).isPresent();
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}
	
	@SubscribeEvent
    public static void onLivingDeathEvent(SlashBladeEvent.AddProudSoulEvent event) {
        ItemStack stack = event.getBlade();
        if (stack.isEmpty())
            return;
        if (!(stack.getCapability(ItemSlashBlade.BLADESTATE).isPresent()))
            return;
        
        int enchantmentLevel = stack.getEnchantmentLevel(EnchantmentsRegistry.SPIRIT_ABSORPTION.get());
		if (enchantmentLevel <= 0)
        	return;
		
		event.setNewCount((int) (event.getOriginCount() * (1D + enchantmentLevel * 0.2D)));
    }

}
