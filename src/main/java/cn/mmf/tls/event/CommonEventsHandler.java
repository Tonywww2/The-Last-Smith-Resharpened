package cn.mmf.tls.event;

import mods.flammpfeil.slashblade.event.SlashBladeRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class CommonEventsHandler {
	@SubscribeEvent
	public static void onLoadingBlade(SlashBladeRegistryEvent.Pre event){
		if(!ModList.get().isLoaded(event.getSlashBladeDefinition().getName().getNamespace()))
			event.setCanceled(true);
	}
}
