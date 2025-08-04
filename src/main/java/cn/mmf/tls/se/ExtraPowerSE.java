package cn.mmf.tls.se;

import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber
public class ExtraPowerSE extends SpecialEffect {
	private final int seLevel;
	public ExtraPowerSE(int seLevel, int requestLevel, boolean isCopiable, boolean isRemovable) {
		super(requestLevel, isCopiable, isRemovable);
		this.seLevel = seLevel;
	}

	@SubscribeEvent
	public static void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {
		ISlashBladeState state = event.getSlashBladeState();
		
		setEffect(event, state, TLSSpecialEffectRegistry.EXTRA_POWER);
		setEffect(event, state, TLSSpecialEffectRegistry.BEWITCHED_POWER);
	}

	private static void setEffect(SlashBladeEvent.DoSlashEvent event, ISlashBladeState state, RegistryObject<ExtraPowerSE> se) {
		if(state.hasSpecialEffect(se.getId())) {
			if (!(event.getUser() instanceof Player)) {
				return;
			}
			
			Player player = (Player) event.getUser();
			
			int level = player.experienceLevel;
			
			if(SpecialEffect.isEffective(se.get(), level)) {
				event.setDamage(event.getDamage() * 
						1 + (event.getBlade().getEnchantmentLevel(Enchantments.POWER_ARROWS) 
								* se.get().getSELevel() * 0.1F));
			}
		}
	}

	public int getSELevel() {
		return seLevel;
	}

}
