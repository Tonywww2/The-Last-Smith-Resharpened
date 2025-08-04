package cn.mmf.tls.data.tag;

import cn.mcmod_mmf.mmlib.utils.TagUtils;
import cn.mmf.tls.TheLastSmith;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TLSItemTags {
    public static final TagKey<Item> BAMBOO = TagUtils.forgeItemTag("bamboo");
    public static final TagKey<Item> LEAVES_CHERRY = TagUtils.forgeItemTag("leaves/cherry");
    
    public static final TagKey<Item> RESEARCH_CONSUMABLE = TagUtils.modItemTag(TheLastSmith.MODID, "research/consumable");
}
