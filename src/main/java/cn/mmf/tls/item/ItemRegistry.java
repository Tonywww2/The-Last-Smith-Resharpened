package cn.mmf.tls.item;

import java.util.function.Supplier;

import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.block.BlockRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			TheLastSmith.MODID);
	
    public static final RegistryObject<Item> RESEARCH_TABLE = register("research_table",
            () -> new BlockItem(BlockRegistry.RESEARCH_TABLE.get(), new Item.Properties()));
	
    public static final RegistryObject<Item> SAKURA = register("sakura", ItemRegistry::newMaterial);
    public static final RegistryObject<Item> SAKURA_FULL = register("sakura_full", ItemRegistry::newMaterial);
    public static final RegistryObject<Item> SAKURA_STEEL_INGOT = register("sakura_steel_ingot", ItemRegistry::newMaterial);
    
    public static final RegistryObject<Item> SCROLL = register("scroll", ItemRegistry::newMaterial);
    
    public static final RegistryObject<Item> BLADE_UNFINISHED_1 = register("blade_unfinished_1", ItemRegistry::newBladeMaterial);
    public static final RegistryObject<Item> BLADE_UNFINISHED_2 = register("blade_unfinished_2", ItemRegistry::newBladeMaterial);
    public static final RegistryObject<Item> BLADE_UNFINISHED_3 = register("blade_unfinished_3", ItemRegistry::newBladeMaterial);
    public static final RegistryObject<Item> BLADE_UNFINISHED_4 = register("blade_unfinished_4", ItemRegistry::newBladeMaterial);
    public static final RegistryObject<Item> BLADE = register("blade", ItemRegistry::newMaterial);
    
    public static final RegistryObject<Item> BLADE_SAKURA_UNFINISHED_1 = register("blade_sakura_unfinished_1", ItemRegistry::newBladeMaterial);
    public static final RegistryObject<Item> BLADE_SAKURA_UNFINISHED_2 = register("blade_sakura_unfinished_2", ItemRegistry::newBladeMaterial);
    public static final RegistryObject<Item> BLADE_SAKURA_UNFINISHED_3 = register("blade_sakura_unfinished_3", ItemRegistry::newBladeMaterial);
    public static final RegistryObject<Item> BLADE_SAKURA_UNFINISHED_4 = register("blade_sakura_unfinished_4", ItemRegistry::newBladeMaterial);
    public static final RegistryObject<Item> BLADE_SAKURA = register("blade_sakura", ItemRegistry::newMaterial);
    
    private static <V extends Item> RegistryObject<V> register(String name, Supplier<V> item) {
        return ITEMS.register(name, item);
    }
    
	private static Item newMaterial() {
		return new Item(new Item.Properties());
	}
	
	private static Item newBladeMaterial() {
		return new Item(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}
