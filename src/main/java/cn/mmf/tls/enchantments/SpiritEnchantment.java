package cn.mmf.tls.enchantments;

import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class SpiritEnchantment extends Enchantment {

	public SpiritEnchantment() {
		super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return stack.getCapability(ItemSlashBlade.BLADESTATE).isPresent();
	}
	
	@Override
	public int getMaxLevel() {
		return 4;
	}
	
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onLivingDeathEvent(LivingDeathEvent event) {
        Entity trueSource = event.getSource().getEntity();

        if (!(trueSource instanceof LivingEntity))
            return;

        ItemStack stack = ((LivingEntity) trueSource).getMainHandItem();
        if (stack.isEmpty())
            return;
        if (!(stack.getCapability(ItemSlashBlade.BLADESTATE).isPresent()))
            return;
        
        int enchantmentLevel = stack.getEnchantmentLevel(EnchantmentsRegistry.SPIRIT_SLASH.get());
		if (enchantmentLevel <= 0)
        	return;
		
        stack.getCapability(ItemSlashBlade.BLADESTATE).ifPresent(state -> {

            state.setKillCount(state.getKillCount() + enchantmentLevel);
        });
    }

}
