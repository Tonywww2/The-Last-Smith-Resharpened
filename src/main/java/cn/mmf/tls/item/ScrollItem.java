package cn.mmf.tls.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class ScrollItem extends Item {

	public ScrollItem(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return stack.getRarity() == Rarity.EPIC;
	}
}
