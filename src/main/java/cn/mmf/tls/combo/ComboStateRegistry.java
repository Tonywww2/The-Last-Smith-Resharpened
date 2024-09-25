package cn.mmf.tls.combo;

import cn.mmf.tls.TheLastSmith;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.event.client.UserPoseOverrider;
import mods.flammpfeil.slashblade.init.DefaultResources;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.util.AttackManager;
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
                            .put(3, (entityIn) -> AttackManager.doSlash(entityIn, -30)).build())
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
                            .put(0, (entityIn) -> AttackManager.doSlash(entityIn, 180 + 75)).build())
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
                            .put(15, (entityIn) -> AttackManager.doSlash(entityIn, 35, false, true))
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
}
