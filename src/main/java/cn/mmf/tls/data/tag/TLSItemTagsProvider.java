package cn.mmf.tls.data.tag;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
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
    	tag(TLSItemTags.BAMBOO);
    }

}
