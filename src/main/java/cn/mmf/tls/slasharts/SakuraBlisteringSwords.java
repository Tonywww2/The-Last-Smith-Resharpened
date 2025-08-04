package cn.mmf.tls.slasharts;

import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.capability.concentrationrank.CapabilityConcentrationRank;
import mods.flammpfeil.slashblade.entity.EntityBlisteringSwords;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class SakuraBlisteringSwords {
	public static void summonSwords(LivingEntity playerIn, boolean critical, double damage) {
		int colorCode = playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE)
				.map(state -> state.getColorCode()).orElse(0xFF3333FF);
		summonSwords(playerIn, colorCode, critical, damage, 4);
	}

	public static void summonSwords(LivingEntity playerIn, int colorCode, boolean critical, double damage, int baseCount) {
		if (playerIn.level().isClientSide())
			return;

		playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {

			Level worldIn = playerIn.level();

			int rank = playerIn.getCapability(CapabilityConcentrationRank.RANK_POINT)
					.map(r -> r.getRank(worldIn.getGameTime()).level).orElse(0);
			int count = baseCount + rank;

			for (int i = 0; i < count; i++) {
				EntityBlisteringSwords ss = new EntityBlisteringSwords(SlashBlade.RegistryEvents.BlisteringSwords,
						worldIn);

				ss.setPos(playerIn.position());
				ss.setIsCritical(critical);
				ss.setOwner(playerIn);
				ss.setColor(colorCode);
				ss.setRoll(0);
				ss.setDamage(damage);
				// force riding
				ss.startRiding(playerIn, true);

				ss.setDelay(i);

				worldIn.addFreshEntity(ss);

				playerIn.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);
			}
		});
	}
}
