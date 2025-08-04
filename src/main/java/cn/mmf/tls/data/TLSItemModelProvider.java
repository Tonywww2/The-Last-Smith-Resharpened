package cn.mmf.tls.data;

import java.util.function.Supplier;

import cn.mcmod_mmf.mmlib.data.AbstractItemModelProvider;
import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.item.ItemRegistry;
import cn.mmf.tls.item.ScrollItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class TLSItemModelProvider extends AbstractItemModelProvider {

    public TLSItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, TheLastSmith.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ItemRegistry.ITEMS.getEntries().forEach((item) -> {
        	if (item.get() instanceof ScrollItem)
        		return;
            if (item.get() instanceof BlockItem block)
                itemBlock(block::getBlock);
            else
                normalItem(item);
           
        });
        
        normalItem(ItemRegistry.SCROLL_BASIC, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_WOOD_BASIC, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_BLADE, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_WOOD_KIWAMI, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_SAKURA, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_SAKURA_BLADE, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_SAKURA_FULL, TheLastSmith.prefix("scroll_double"));
        normalItem(ItemRegistry.SCROLL_EXORCISM, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_KATANA, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_ODACHI, TheLastSmith.prefix("scroll_double"));
        normalItem(ItemRegistry.SCROLL_MURAMASA, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_STAR, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_GOD, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_YAMATO, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_SHURA, TheLastSmith.prefix("scroll_blood"));
        normalItem(ItemRegistry.SCROLL_BLOOD, TheLastSmith.prefix("scroll_blood"));
        normalItem(ItemRegistry.SCROLL_MORTAL, TheLastSmith.prefix("scroll_blood"));
        normalItem(ItemRegistry.SCROLL_BEWITCHED, TheLastSmith.prefix("scroll_blood"));
        normalItem(ItemRegistry.SCROLL_HEIL, TheLastSmith.prefix("scroll_blood"));
        normalItem(ItemRegistry.SCROLL_TENGU_VOL1, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_TENGU_VOL2, TheLastSmith.prefix("scroll"));
        normalItem(ItemRegistry.SCROLL_TENGU_FULL, TheLastSmith.prefix("scroll_double"));
    }
    
    public ItemModelBuilder normalItem(Supplier<? extends Item> item, ResourceLocation texture) {
        return withExistingParent(ForgeRegistries.ITEMS.getKey(item.get()).getPath(), mcLoc("item/generated")).texture("layer0",
                modLoc("item/" + texture.getPath()));
    }
}
