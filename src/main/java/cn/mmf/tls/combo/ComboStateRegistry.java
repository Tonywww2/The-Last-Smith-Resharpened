package cn.mmf.tls.combo;

import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.slasharts.SakuraBlisteringSwords;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.event.client.UserPoseOverrider;
import mods.flammpfeil.slashblade.init.DefaultResources;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.util.AttackManager;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ComboStateRegistry {
    public static final DeferredRegister<ComboState> COMBO_STATE = DeferredRegister.create(ComboState.REGISTRY_KEY,
            TheLastSmith.MODID);
    public static final RegistryObject<ComboState> ODACHI_COMBO_A1 = COMBO_STATE.register("odachi_combo_a1",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(17, entity -> TheLastSmith.prefix("odachi_combo_a2")))
                    .nextOfTimeout(entity -> TheLastSmith.prefix("odachi_combo_a1_end"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(3, (entityIn) -> 
                            AttackManager.doSlash(entityIn, -30, Vec3.ZERO, false, AttackManager.isPowered(entityIn), 
                            		AttackManager.isPowered(entityIn) ? 1.5F:1.1F)
                            )
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    
    public static final RegistryObject<ComboState> ODACHI_COMBO_A1_END = COMBO_STATE.register("odachi_combo_a1_end",
            ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(entity -> SlashBlade.prefix("none"))
                    .nextOfTimeout(entity -> SlashBlade.prefix("none"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(0, AttackManager::playQuickSheathSoundAction).build())
                    .releaseAction(ComboState::releaseActionQuickCharge)::build);
    
    public static final RegistryObject<ComboState> ODACHI_COMBO_A2 = COMBO_STATE.register("odachi_combo_a2",
            ComboState.Builder.newInstance().startAndEnd(814, 839).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(8, entity -> TheLastSmith.prefix("odachi_combo_a3")))
                    .nextOfTimeout(entity -> TheLastSmith.prefix("odachi_combo_a2_end"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(0, (entityIn) -> 
                                    AttackManager.doSlash(entityIn, 180 + 75, Vec3.ZERO, false, AttackManager.isPowered(entityIn), 
                                    		AttackManager.isPowered(entityIn) ? 1.5F:1.1F)
                            		).build())
                    .addHitEffect(StunManager::setStun)::build);
    public static final RegistryObject<ComboState> ODACHI_COMBO_A2_END = COMBO_STATE.register("odachi_combo_a2_end",
            ComboState.Builder.newInstance().startAndEnd(839, 877).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
                    .nextOfTimeout(entity -> TheLastSmith.prefix("odachi_combo_a2_end2"))::build);
    public static final RegistryObject<ComboState> ODACHI_COMBO_A2_END2 = COMBO_STATE.register("odachi_combo_a2_end2",
            ComboState.Builder.newInstance().startAndEnd(877, 894).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
                    .nextOfTimeout(entity -> SlashBlade.prefix("none"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(0, AttackManager::playQuickSheathSoundAction).build())
                    .releaseAction(ComboState::releaseActionQuickCharge)::build);
    
    public static final RegistryObject<ComboState> ODACHI_COMBO_A3 = COMBO_STATE.register("odachi_combo_a3",
            ComboState.Builder.newInstance().startAndEnd(900, 1013).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(33, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> TheLastSmith.prefix("odachi_combo_a3_end"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(15, (entityIn) -> 
                            		AttackManager.doSlash(entityIn, 35, Vec3.ZERO, false, true, 
                            		AttackManager.isPowered(entityIn) ? 1.6F:1.1F))
                            .put(17, (entityIn) -> AttackManager.doSlash(entityIn, 40, true, true))
                            .put(19, (entityIn) -> AttackManager.doSlash(entityIn, 30, true, true))
                            .build())
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(13 + 0, (entityIn) -> UserPoseOverrider.setRot(entityIn, 72, true))
                            .put(13 + 1, (entityIn) -> UserPoseOverrider.setRot(entityIn, 72, true))
                            .put(13 + 2, (entityIn) -> UserPoseOverrider.setRot(entityIn, 72, true))
                            .put(13 + 3, (entityIn) -> UserPoseOverrider.setRot(entityIn, 72, true))
                            .put(13 + 4, (entityIn) -> UserPoseOverrider.setRot(entityIn, 72, true))
                            .put(13 + 5, (entityIn) -> UserPoseOverrider.resetRot(entityIn)).build())
                    .addHitEffect(StunManager::setStun)::build);
    public static final RegistryObject<ComboState> ODACHI_COMBO_A3_END = COMBO_STATE.register("odachi_combo_a3_end",
            ComboState.Builder.newInstance().startAndEnd(1013, 1061).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
                    .nextOfTimeout(entity -> SlashBlade.prefix("none"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(0, AttackManager::playQuickSheathSoundAction).build())
                    .releaseAction(ComboState::releaseActionQuickCharge)::build);
    
    public static final RegistryObject<ComboState> FUSHIGIRI_LEFT = COMBO_STATE.register("fushigiri_left",
            ComboState.Builder.newInstance().startAndEnd(400, 415).priority(50)
                    .next((entity) -> TheLastSmith.prefix("fushigiri_left"))
                    .nextOfTimeout(entity -> TheLastSmith.prefix("fushigiri_right"))
                    .clickAction((entityIn) -> AttackManager.doSlash(entityIn,  - 30F, Vec3.ZERO, false, true, 1.5F))
                    .addTickAction((entityIn) -> UserPoseOverrider.resetRot(entityIn))
                    .addHitEffect(StunManager::setStun)::build);

    public static final RegistryObject<ComboState> FUSHIGIRI_RIGHT = COMBO_STATE.register("fushigiri_right",
            ComboState.Builder.newInstance().startAndEnd(1816, 1859).priority(50)
		            .next((entity) -> SlashBlade.prefix("none"))
		            .nextOfTimeout(entity -> TheLastSmith.prefix("fushigiri_finish"))
		            .clickAction((entityIn) -> AttackManager.doSlash(entityIn, 30F, Vec3.ZERO, false, true, 1.5F))
		            .addTickAction((entityIn) -> UserPoseOverrider.resetRot(entityIn))
		            .addHitEffect(StunManager::setStun)::build);

    public static final RegistryObject<ComboState> FUSHIGIRI_FINISH = COMBO_STATE.register("fushigiri_finish",
            ComboState.Builder.newInstance().startAndEnd(1859, 1886).priority(50)
		            .next(entity -> SlashBlade.prefix("none"))
		            .nextOfTimeout(entity -> SlashBlade.prefix("none"))
		            .addTickAction(ComboState.TimeLineTickAction.getBuilder()
		                    .put(0, AttackManager::playQuickSheathSoundAction).build())
		            .addTickAction((entityIn) -> UserPoseOverrider.resetRot(entityIn))
		            .releaseAction(ComboState::releaseActionQuickCharge)::build);

    public static final RegistryObject<ComboState> IAI_CROSS_SLASH = COMBO_STATE.register("iai_cross_slash",
            ComboState.Builder.newInstance().startAndEnd(200, 218)
                    .priority(50)
                    .next(ComboState.TimeoutNext.buildFromFrame(9,
                            entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> TheLastSmith.prefix("iai_cross_end"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(0, (entityIn) -> AttackManager.doSlash(entityIn, -22.5F, false, false, 0.75f))
                            .put(6, (entityIn) -> AttackManager.doSlash(entityIn, 180 - 82.5F, false, false, 0.75f)).build())
                    .addHitEffect(StunManager::setStun)::build);

    public static final RegistryObject<ComboState> IAI_CROSS_SLASH_END = COMBO_STATE.register("iai_cross_end",
            ComboState.Builder.newInstance().startAndEnd(218, 281).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
                    .nextOfTimeout(entity -> TheLastSmith.prefix("iai_cross_end2"))::build);

    public static final RegistryObject<ComboState> IAI_CROSS_SLASH_END2 = COMBO_STATE.register("iai_cross_end2",
            ComboState.Builder.newInstance().startAndEnd(281, 306).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
                    .nextOfTimeout(entity -> SlashBlade.prefix("none"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(0, AttackManager::playQuickSheathSoundAction).build())
                    .releaseAction(ComboState::releaseActionQuickCharge)::build);

	public static final RegistryObject<ComboState> SAKURA_BLISTERING_SWORDS = COMBO_STATE.register(
			"sakura_blistering_swords",
			ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
					.motionLoc(DefaultResources.ExMotionLocation)
					.next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
					.nextOfTimeout(entity -> TheLastSmith.prefix("sakura_blistering_swords_end"))
					.addTickAction(ComboState.TimeLineTickAction.getBuilder()
							.put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
							.put(3, (entityIn) -> SakuraBlisteringSwords.summonSwords(entityIn, false, 4)).build())
					.addHitEffect(StunManager::setStun)::build);

	public static final RegistryObject<ComboState> SAKURA_BLISTERING_SWORDS_END = COMBO_STATE.register(
			"sakura_blistering_swords_end",
			ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
					.motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
					.nextOfTimeout(entity -> SlashBlade.prefix("none"))
					.addTickAction(ComboState.TimeLineTickAction.getBuilder()
							.put(0, AttackManager::playQuickSheathSoundAction).build())
					.releaseAction(ComboState::releaseActionQuickCharge)::build);
}
