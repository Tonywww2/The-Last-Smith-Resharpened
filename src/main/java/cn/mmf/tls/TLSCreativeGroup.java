package cn.mmf.tls;

import cn.mmf.tls.item.ItemRegistry;
import mods.flammpfeil.slashblade.SlashBladeCreativeGroup;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TLSCreativeGroup {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
			.create(Registries.CREATIVE_MODE_TAB, TheLastSmith.MODID);

	private static final CreativeModeTab SLASHBLADE = CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.the_last_smith")).icon(() -> {
				ItemStack stack = new ItemStack(SBItems.slashblade);
				stack.getCapability(ItemSlashBlade.BLADESTATE).ifPresent(s -> {
					s.setModel(new ResourceLocation(TheLastSmith.MODID, "model/nagasada/model.obj"));
					s.setTexture(new ResourceLocation(TheLastSmith.MODID, "model/nagasada/texture.png"));
				});
				return stack;
			}).displayItems((features, output) -> {
				ItemRegistry.ITEMS.getEntries().forEach(item -> {
					output.accept(item.get());
				});
				
			}).withTabsBefore(SlashBladeCreativeGroup.SLASHBLADE_GROUP.getKey()).build();

	public static final RegistryObject<CreativeModeTab> SLASHBLADE_GROUP = CREATIVE_MODE_TABS.register("slashblade",
			() -> SLASHBLADE);

}
