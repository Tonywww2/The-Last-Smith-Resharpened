package cn.mmf.tls.data;

import cn.mcmod_mmf.mmlib.data.AbstractItemModelProvider;
import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TLSItemModelProvider extends AbstractItemModelProvider {

    public TLSItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, TheLastSmith.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ItemRegistry.ITEMS.getEntries().forEach((item) -> {
            if (item.get() instanceof BlockItem block)
                itemBlock(block::getBlock);
            else
                normalItem(item);
        });
    }

}
