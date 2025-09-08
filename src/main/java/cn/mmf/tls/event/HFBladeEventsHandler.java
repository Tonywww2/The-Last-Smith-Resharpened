package cn.mmf.tls.event;

import cn.mmf.energyblade.EmpowerSlashBladeEvent;
import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.data.builtin.TLSSlashBladeRegistry;
import net.minecraft.Util;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public enum HFBladeEventsHandler {
	INSTANCE;
	
	public void init() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onSlashBladeUpdate(EmpowerSlashBladeEvent event) {
		var state = event.getSlashBladeState();
		if(!state.getTranslationKey().equals(Util.makeDescriptionId("item", TLSSlashBladeRegistry.BUNSHI.location()))) {
			return;
		}
		var offTexture = TheLastSmith.prefix("model/named/rf_roukan/texture.png");
		var onTexture = TheLastSmith.prefix("model/named/rf_roukan/texture_on.png");
		if (event.isPowered()) {
			state.setTexture(onTexture);
			state.setBaseAttackModifier(13F);
		} else {
			state.setTexture(offTexture);
			state.setBaseAttackModifier(6F);
		}
	}
}
