package cn.mmf.tls.block;

import cn.mmf.tls.TheLastSmith;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TheLastSmith.MODID);
	public static final RegistryObject<Block> RESEARCH_TABLE = BLOCKS.register("research_table", ResearchTableBlock::new);
}
