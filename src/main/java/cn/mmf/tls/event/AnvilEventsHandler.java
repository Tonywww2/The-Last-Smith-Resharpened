package cn.mmf.tls.event;

import cn.mmf.tls.item.ItemRegistry;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.capability.slashblade.SlashBladeState;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.item.SwordType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class AnvilEventsHandler {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void onAnvilUpdateEvent(AnvilUpdateEvent event) {
        if (!event.getOutput().isEmpty())
            return;

        ItemStack base = event.getLeft();
        ItemStack material = event.getRight();

        if (base.isEmpty()) {
            return;
        }
        if (!(base.getCapability(ItemSlashBlade.BLADESTATE).isPresent())) {
            return;
        }

        if (!material.is(ItemRegistry.SAKURA_SPHERE.get())) {
            return;
        }

        ItemStack result = base.copy();

        if (result.getCapability(ItemSlashBlade.BLADESTATE).isPresent()) {
            ISlashBladeState state = result.getCapability(ItemSlashBlade.BLADESTATE).orElse(new SlashBladeState(result));
            if(state.isSealed() || SwordType.from(base).contains(SwordType.BEWITCHED))
            	return;
            if(state.getProudSoulCount() < 5000)
            	return;
            state.setDefaultBewitched(true);
            state.setProudSoulCount(state.getProudSoulCount() - 5000);
            
            if(state.isBroken()) {
            	state.setBroken(false);
            	state.setDamage(0);
            }
            result.setDamageValue(0);
            result.getOrCreateTag().put("bladeState", state.serializeNBT());
       }
        
       event.setMaterialCost(1);
       event.setCost(10);
       event.setOutput(result);
    }
}
