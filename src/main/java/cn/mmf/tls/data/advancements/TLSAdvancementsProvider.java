package cn.mmf.tls.data.advancements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.block.BlockRegistry;
import cn.mmf.tls.data.builtin.TLSSlashBladeRegistry;
import cn.mmf.tls.data.tag.TLSItemTags;
import cn.mmf.tls.item.ItemRegistry;
import mods.flammpfeil.slashblade.advancement.SlashBladeItemPredicate;
import mods.flammpfeil.slashblade.data.builtin.SlashBladeBuiltInRegistry;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.recipe.RequestDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.registries.DataPackRegistriesHooks;

public class TLSAdvancementsProvider extends ForgeAdvancementProvider {

	public TLSAdvancementsProvider(PackOutput output, CompletableFuture<Provider> registries,
			RegistrySetBuilder datapackEntriesBuilder,
			ExistingFileHelper existingFileHelper, List<AdvancementGenerator> subProviders) {
		super(output, registries.thenApply(r -> constructRegistries(r, datapackEntriesBuilder)), existingFileHelper, subProviders);
	}

    private static HolderLookup.Provider constructRegistries(HolderLookup.Provider original, RegistrySetBuilder datapackEntriesBuilder)
    {
        var builderKeys = new HashSet<>(datapackEntriesBuilder.getEntryKeys());
        DataPackRegistriesHooks.getDataPackRegistriesWithDimensions().filter(data -> !builderKeys.contains(data.key())).forEach(data -> datapackEntriesBuilder.add(data.key(), context -> {}));
        return datapackEntriesBuilder.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), original);
    }
	
	public static class TLSAdvancementsSubProvider implements AdvancementGenerator {

		@Override
		public void generate(Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
			Advancement root = Advancement.Builder.advancement().display(ItemRegistry.SCROLL_WOOD_BASIC.get(),
					Component.translatable("advancement.last_smith.root.title"),
					Component.translatable("advancement.last_smith.root.desc"),
					TheLastSmith.prefix("textures/advancements/backgrounds.png"), FrameType.TASK, true, false, false)
					.addCriterion("has_wood", has(SBItems.slashblade_wood))
					.save(saver, TheLastSmith.prefix("root"), existingFileHelper);
			Advancement research = Advancement.Builder.advancement().parent(root)
					.display(BlockRegistry.RESEARCH_TABLE.get(),
							Component.translatable("advancement.last_smith.research_table.title"),
							Component.translatable("advancement.last_smith.research_table.desc"),
							(ResourceLocation) null, FrameType.TASK, true, false, false)
					.addCriterion("has_table", has(BlockRegistry.RESEARCH_TABLE.get()))
					.save(saver, TheLastSmith.prefix("research_table"), existingFileHelper);
			Advancement scroll = Advancement.Builder.advancement().parent(research)
					.display(ItemRegistry.SCROLL_BASIC.get(),
							Component.translatable("advancement.last_smith.scrolls.title"),
							Component.translatable("advancement.last_smith.scrolls.desc"),
							(ResourceLocation) null, FrameType.TASK, false, false, false)
					.addCriterion("has_table", has(TLSItemTags.SCROLL))
					.save(saver, TheLastSmith.prefix("scrolls"), existingFileHelper);
			Advancement blade = Advancement.Builder.advancement().parent(root)
					.display(ItemRegistry.BLADE.get(),
							Component.translatable("advancement.last_smith.blade.title"),
							Component.translatable("advancement.last_smith.blade.desc"),
							(ResourceLocation) null, FrameType.TASK, true, false, false)
					.addCriterion("has_scroll", has(ItemRegistry.BLADE.get()))
					.save(saver, TheLastSmith.prefix("blade"), existingFileHelper);
			Advancement blade_sakura = Advancement.Builder.advancement().parent(blade)
					.display(ItemRegistry.BLADE_SAKURA.get(),
							Component.translatable("advancement.last_smith.blade_sakura.title"),
							Component.translatable("advancement.last_smith.blade_sakura.desc"),
							(ResourceLocation) null, FrameType.TASK, true, false, false)
					.addCriterion("has_blade", has(ItemRegistry.BLADE_SAKURA.get()))
					.save(saver, TheLastSmith.prefix("blade_sakura"), existingFileHelper);
			
			Advancement scroll_sakura_full = Advancement.Builder.advancement().parent(scroll)
					.display(ItemRegistry.SCROLL_SAKURA_FULL.get(),
							Component.translatable("advancement.last_smith.scrolls_sakura_full.title"),
							Component.translatable("advancement.last_smith.scrolls_sakura_full.desc"),
							(ResourceLocation) null, FrameType.TASK, true, false, false)
					.addCriterion("has_scroll", has(ItemRegistry.SCROLL_SAKURA_FULL.get()))
					.save(saver, TheLastSmith.prefix("scrolls_sakura_full"), existingFileHelper);
			
			Advancement scroll_named = Advancement.Builder.advancement().parent(scroll)
					.display(getBlade(registries, SlashBladeBuiltInRegistry.RUBY),
							Component.translatable("advancement.last_smith.scroll_named.title"),
							Component.translatable("advancement.last_smith.scroll_named.desc"),
							(ResourceLocation) null, FrameType.TASK, true, false, false)
					.addCriterion("has_scroll", has(ItemRegistry.SCROLL_NAMED.get()))
					.save(saver, TheLastSmith.prefix("scroll_named"), existingFileHelper);
			
			Advancement scroll_muramasa = Advancement.Builder.advancement().parent(scroll_named)
					.display(getBlade(registries, SlashBladeBuiltInRegistry.MURAMASA),
							Component.translatable("advancement.last_smith.scroll_muramasa.title"),
							Component.translatable("advancement.last_smith.scroll_muramasa.desc"),
							(ResourceLocation) null, FrameType.TASK, true, false, false)
					.addCriterion("has_scroll", has(ItemRegistry.SCROLL_MURAMASA.get()))
					.save(saver, TheLastSmith.prefix("scroll_muramasa"), existingFileHelper);
			
			Advancement oboro_muramasa = Advancement.Builder.advancement().parent(scroll_muramasa)
					.display(getBlade(registries, TLSSlashBladeRegistry.OBORO_MURAMASA),
							Component.translatable("advancement.last_smith.oboro_muramasa.title"),
							Component.translatable("advancement.last_smith.oboro_muramasa.desc"),
							(ResourceLocation) null, FrameType.GOAL, true, false, false)
					.addCriterion("has_blade", hasBlade(
							TLSSlashBladeRegistry.OBORO_MURAMASA.location()
							))
					.save(saver, TheLastSmith.prefix("oboro_muramasa"), existingFileHelper);
			
			Advancement meteorn = Advancement.Builder.advancement().parent(scroll_named)
					.display(getBlade(registries, SlashBladeBuiltInRegistry.SANGE),
							Component.translatable("advancement.last_smith.meteorn.title"),
							Component.translatable("advancement.last_smith.meteorn.desc"),
							(ResourceLocation) null, FrameType.CHALLENGE, true, false, false)
					.addCriterion("has_scroll", has(ItemRegistry.SCROLL_STAR.get()))
					.save(saver, TheLastSmith.prefix("meteorn"), existingFileHelper);
			
			Advancement.Builder.advancement().parent(meteorn)
					.display(getBlade(registries, TLSSlashBladeRegistry.YAMATO),
							Component.translatable("advancement.last_smith.yamato.title"),
							Component.translatable("advancement.last_smith.yamato.desc"),
							(ResourceLocation) null, FrameType.GOAL, true, false, false)
					.addCriterion("has_blade", hasBlade(TLSSlashBladeRegistry.YAMATO.location()))
					.save(saver, TheLastSmith.prefix("yamato"), existingFileHelper);
			
			Advancement.Builder.advancement().parent(oboro_muramasa)
					.display(getBlade(registries, TLSSlashBladeRegistry.AMAGUMO_KAZE),
							Component.translatable("advancement.last_smith.sharpness.title"),
							Component.translatable("advancement.last_smith.sharpness.desc"),
							(ResourceLocation) null, FrameType.CHALLENGE, true, true, false)
					.addCriterion("has_scroll", has(ItemRegistry.SCROLL_SHARPNESS.get()))
					.save(saver, TheLastSmith.prefix("sharpness"), existingFileHelper);

			Advancement scroll_bamboo = Advancement.Builder.advancement().parent(scroll_sakura_full)
					.display(getBlade(registries, TLSSlashBladeRegistry.BAMBOO_HERMIT),
							Component.translatable("advancement.last_smith.scroll_bamboo.title"),
							Component.translatable("advancement.last_smith.scroll_bamboo.desc"),
							(ResourceLocation) null, FrameType.GOAL, false, false, false)
					.requirements(RequirementsStrategy.OR)
					.addCriterion("bamboo_hermit", hasBlade(
							TLSSlashBladeRegistry.BAMBOO_HERMIT.location()
							))
					.addCriterion("bloody_bamboo", hasBlade(
							TLSSlashBladeRegistry.SILVERBAMBOO_BLOOD.location()
							))
					.save(saver, TheLastSmith.prefix("scroll_bamboo"), existingFileHelper);
			
			Advancement.Builder.advancement().parent(scroll_bamboo)
					.display(getBlade(registries, TLSSlashBladeRegistry.SAGEQUOIA),
							Component.translatable("advancement.last_smith.sagequoia.title"),
							Component.translatable("advancement.last_smith.sagequoia.desc"),
							(ResourceLocation) null, FrameType.GOAL, true, false, true)
					.addCriterion("has_blade", hasBlade(
							TLSSlashBladeRegistry.SAGEQUOIA.location()
							))
					.save(saver, TheLastSmith.prefix("sagequoia"), existingFileHelper);
			
			Advancement blade_nagasada = Advancement.Builder.advancement().parent(blade_sakura)
					.display(getBlade(registries, TLSSlashBladeRegistry.NAGASADA),
							Component.translatable("advancement.last_smith.nagasada.title"),
							Component.translatable("advancement.last_smith.nagasada.desc"),
							(ResourceLocation) null, FrameType.TASK, true, false, false)
					.addCriterion("has_blade", hasBlade(TLSSlashBladeRegistry.NAGASADA.location()))
					.save(saver, TheLastSmith.prefix("nagasada"), existingFileHelper);
			
			Advancement odachi = Advancement.Builder.advancement().parent(blade)
					.display(getBlade(registries, TLSSlashBladeRegistry.NAMELESS_ODACHI),
							Component.translatable("advancement.last_smith.odachi.title"),
							Component.translatable("advancement.last_smith.odachi.desc"),
							(ResourceLocation) null, FrameType.TASK, true, false, false)
					.addCriterion("has_blade", hasBlade(TLSSlashBladeRegistry.NAMELESS_ODACHI.location()))
					.save(saver, TheLastSmith.prefix("odachi"), existingFileHelper);
			
			Advancement.Builder.advancement().parent(odachi)
					.display(getBlade(registries, TLSSlashBladeRegistry.FUSHIGIRI),
							Component.translatable("advancement.last_smith.fushigiri.title"),
							Component.translatable("advancement.last_smith.fushigiri.desc"),
							(ResourceLocation) null, FrameType.GOAL, true, false, false)
					.addCriterion("has_blade", hasBlade(TLSSlashBladeRegistry.FUSHIGIRI.location()))
					.save(saver, TheLastSmith.prefix("fushigiri"), existingFileHelper);
			
			Advancement sakura_blade = Advancement.Builder.advancement().parent(blade_nagasada)
					.display(getBlade(registries, TLSSlashBladeRegistry.EXORCISM_SAKURA),
							Component.translatable("advancement.last_smith.exorcism_sakura.title"),
							Component.translatable("advancement.last_smith.exorcism_sakura.desc"),
							(ResourceLocation) null, FrameType.TASK, true, false, false)
					.requirements(RequirementsStrategy.OR)
					.addCriterion("exorcism_sakura", hasBlade(
							TLSSlashBladeRegistry.EXORCISM_SAKURA.location()
							))
					.addCriterion("exorcism_ginkgo", hasBlade(
							TLSSlashBladeRegistry.EXORCISM_GINKGO.location()
							))
					.addCriterion("exorcism_yuki", hasBlade(
							TLSSlashBladeRegistry.EXORCISM_YUKI.location()
							))
					.save(saver, TheLastSmith.prefix("exorcism_sakura"), existingFileHelper);
			
			Advancement.Builder.advancement().parent(sakura_blade)
					.display(getBlade(registries, TLSSlashBladeRegistry.EVIL_SHURA),
							Component.translatable("advancement.last_smith.shura.title"),
							Component.translatable("advancement.last_smith.shura.desc"),
							(ResourceLocation) null, FrameType.GOAL, true, false, false)
					.addCriterion("has_blade", hasBlade(TLSSlashBladeRegistry.EVIL_SHURA.location()))
					.save(saver, TheLastSmith.prefix("shura"), existingFileHelper);
			
			Advancement roukan_hakurou = Advancement.Builder.advancement().parent(sakura_blade)
					.display(getBlade(registries, TLSSlashBladeRegistry.ROUKANKEN),
							Component.translatable("advancement.last_smith.roukan_hakurou.title"),
							Component.translatable("advancement.last_smith.roukan_hakurou.desc"),
							(ResourceLocation) null, FrameType.GOAL, true, false, false)
					.requirements(RequirementsStrategy.OR)
					.addCriterion("roukanken", hasBlade(
							TLSSlashBladeRegistry.ROUKANKEN.location()
							))
					.addCriterion("hakurouken", hasBlade(
							TLSSlashBladeRegistry.HAKUROUKEN.location()
							))
					.save(saver, TheLastSmith.prefix("roukan_hakurou"), existingFileHelper);
			
			Advancement inferno = Advancement.Builder.advancement().parent(roukan_hakurou)
					.display(getBlade(registries, TLSSlashBladeRegistry.ROUKANKEN_NETHER),
							Component.translatable("advancement.last_smith.inferno.title"),
							Component.translatable("advancement.last_smith.inferno.desc"),
							(ResourceLocation) null, FrameType.CHALLENGE, true, false, false)
					.requirements(RequirementsStrategy.OR)
					.addCriterion("has_scroll", has(ItemRegistry.SCROLL_HEIL.get()))
					.save(saver, TheLastSmith.prefix("inferno"), existingFileHelper);
			
			Advancement.Builder.advancement().parent(inferno)
					.display(getBlade(registries, TLSSlashBladeRegistry.AMAGUMO_KUMO),
							Component.translatable("advancement.last_smith.bewitched.title"),
							Component.translatable("advancement.last_smith.bewitched.desc"),
							(ResourceLocation) null, FrameType.CHALLENGE, true, true, false)
					.addCriterion("has_scroll", has(ItemRegistry.SCROLL_BEWITCHED.get()))
					.save(saver, TheLastSmith.prefix("bewitched"), existingFileHelper);
			
			Advancement.Builder.advancement().parent(blade_nagasada)
					.display(getBlade(registries, TLSSlashBladeRegistry.AMAGUMO_MUNIN),
							Component.translatable("advancement.last_smith.munin.title"),
							Component.translatable("advancement.last_smith.munin.desc"),
							(ResourceLocation) null, FrameType.CHALLENGE, true, true, true)
					.addCriterion("has_blade", hasBlade(
							TLSSlashBladeRegistry.AMAGUMO_MUNIN.location()
							))
					.save(saver, TheLastSmith.prefix("munin"), existingFileHelper);
		}

	}
	
	protected static ItemStack getBlade(Provider registries, ResourceKey<SlashBladeDefinition> key) {
		return registries.lookup(SlashBladeDefinition.REGISTRY_KEY).get().get(key).orElseThrow().get().getBlade();
	}
	
	protected static InventoryChangeTrigger.TriggerInstance hasBlade(ResourceLocation... locs) {
		List<SlashBladeItemPredicate> list = new ArrayList<>();
		for(ResourceLocation loc : locs) {
			list.add(new SlashBladeItemPredicate(RequestDefinition.Builder.newInstance().name(loc).build()));
		}
		return inventoryTrigger( (ItemPredicate[]) list.toArray(new ItemPredicate[list.size()]) );
	}

	protected static InventoryChangeTrigger.TriggerInstance inventoryTrigger(ItemPredicate... predicates) {
		return new InventoryChangeTrigger.TriggerInstance(ContextAwarePredicate.ANY, MinMaxBounds.Ints.ANY,
				MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, predicates);
	}

	protected static InventoryChangeTrigger.TriggerInstance has(ItemLike item) {
		return inventoryTrigger(ItemPredicate.Builder.item().of(item).build());
	}

	protected static InventoryChangeTrigger.TriggerInstance has(TagKey<Item> tag) {
		return inventoryTrigger(ItemPredicate.Builder.item().of(tag).build());
	}

}
