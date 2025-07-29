package cn.mmf.tls.menus;

import cn.mmf.tls.TheLastSmith;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ContainerRegistry {
    public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister
            .create(ForgeRegistries.MENU_TYPES, TheLastSmith.MODID);
    
    public static final RegistryObject<MenuType<ResearchMenu>> RESEARCH_TABLE = CONTAINER_TYPES
            .register("research_table", () -> new MenuType<>((ResearchMenu::new), FeatureFlags.DEFAULT_FLAGS));
}
