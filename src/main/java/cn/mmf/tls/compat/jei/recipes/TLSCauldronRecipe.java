package cn.mmf.tls.compat.jei.recipes;

import java.util.List;

import net.minecraft.world.item.ItemStack;

public class TLSCauldronRecipe extends JEISimpleRecipe {

	public TLSCauldronRecipe(ItemStack input, ItemStack output) {
		super(List.of(input), List.of(output));
	}

}
