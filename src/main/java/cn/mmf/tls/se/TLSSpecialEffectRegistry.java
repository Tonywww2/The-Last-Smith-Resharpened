package cn.mmf.tls.se;

import cn.mmf.tls.TheLastSmith;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TLSSpecialEffectRegistry {
	public static final DeferredRegister<SpecialEffect> SPECIAL_EFFECT = DeferredRegister.create(SpecialEffect.REGISTRY_KEY,
            TheLastSmith.MODID);

    public static final RegistryObject<ExtraSharpnessSE> EXTRA_SHARPNESS = SPECIAL_EFFECT.register("extra_sharpness", 
    		() -> new ExtraSharpnessSE(1, 15, true, true));
    
    public static final RegistryObject<ExtraSharpnessSE> EXTREME_SHARPNESS = SPECIAL_EFFECT.register("extreme_sharpness", 
    		() -> new ExtraSharpnessSE(2, 30, false, false));
	
    public static final RegistryObject<ExtraPowerSE> EXTRA_POWER = SPECIAL_EFFECT.register("extra_power", 
    		() -> new ExtraPowerSE(1, 15, true, true));
	
    public static final RegistryObject<ExtraPowerSE> BEWITCHED_POWER = SPECIAL_EFFECT.register("bewitched_power", 
    		() -> new ExtraPowerSE(2, 30, false, false));
    
    public static final RegistryObject<FushigiriSE> SMITE_SE = SPECIAL_EFFECT.register("smite_se", 
    		() -> new FushigiriSE(1, 15, true, true));
    
    public static final RegistryObject<FushigiriSE> EXTRA_SMITE = SPECIAL_EFFECT.register("extra_smite", 
    		() -> new FushigiriSE(2, 30, true, true));
    
    public static final RegistryObject<FushigiriSE> FUSHIGIRI_SE = SPECIAL_EFFECT.register("fushigiri_se", 
    		() -> new FushigiriSE(3, 30, false, false));

	public static final RegistryObject<SectumsempraSE> SECTUMSEMPRA_SE = SPECIAL_EFFECT.register("sectumsempra_se",
    		() -> new SectumsempraSE(3, 40, false, false));
    
}
