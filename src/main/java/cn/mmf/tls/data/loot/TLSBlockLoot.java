package cn.mmf.tls.data.loot;

import java.util.Set;

import cn.mcmod_mmf.mmlib.data.loot.AbstartctBlockLoot;
import cn.mmf.tls.block.BlockRegistry;

public class TLSBlockLoot extends AbstartctBlockLoot {

	public TLSBlockLoot() {
		super(Set.of());
	}

	@Override
	public void addTables() {
		dropSelf(BlockRegistry.RESEARCH_TABLE.get());
	}

}
