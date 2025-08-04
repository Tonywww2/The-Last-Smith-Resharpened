package cn.mmf.tls.data.tag;

import java.util.concurrent.CompletableFuture;

import cn.mmf.tls.item.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tracen.umapyoi.Umapyoi;

public class TLSItemTagsProvider extends ItemTagsProvider {

    public TLSItemTagsProvider(PackOutput pGenerator, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> provider,
            ExistingFileHelper existingFileHelper) {
        super(pGenerator, lookupProvider, provider, Umapyoi.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookup) {
    	tag(TLSItemTags.BAMBOO).add(Items.BAMBOO);
    	tag(TLSItemTags.LEAVES_CHERRY).add(Items.CHERRY_LEAVES).addOptional(new ResourceLocation("sakura", "sakuraleaves"));
    	tag(TLSItemTags.RESEARCH_CONSUMABLE)
    	.add(
    			ItemRegistry.SCROLL_TENGU_VOL1.get(), 
    			ItemRegistry.SCROLL_TENGU_VOL2.get(), 
    			ItemRegistry.SCROLL_KATANA.get(), 
    			ItemRegistry.SAKURA_FULL.get(), 
    			ItemRegistry.SCROLL_STAR.get()
    		);
    }

}
