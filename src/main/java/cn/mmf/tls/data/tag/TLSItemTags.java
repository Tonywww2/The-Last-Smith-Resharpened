package cn.mmf.tls.data.tag;

import cn.mcmod_mmf.mmlib.utils.TagUtils;
import cn.mmf.tls.TheLastSmith;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TLSItemTags {
    public static final TagKey<Item> BAMBOO = TagUtils.forgeItemTag("bamboo");
    public static final TagKey<Item> LEAVES_CHERRY = TagUtils.forgeItemTag("leaves/cherry");
    
    public static final TagKey<Item> RESEARCH_CONSUMABLE = TagUtils.modItemTag(TheLastSmith.MODID, "research/consumable");
    
    public static final TagKey<Item> SCROLL = TagUtils.modItemTag(TheLastSmith.MODID, "scroll");
    public static final TagKey<Item> SCROLL_RARE = TagUtils.modItemTag(TheLastSmith.MODID, "scroll/rare");
    public static final TagKey<Item> SCROLL_EPIC = TagUtils.modItemTag(TheLastSmith.MODID, "scroll/epic");
    
    public static final TagKey<Item> PROUD_SOULS = TagUtils.modItemTag("slashblade", "proudsouls");
}
