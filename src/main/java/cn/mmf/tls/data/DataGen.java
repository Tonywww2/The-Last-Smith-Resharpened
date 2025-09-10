package cn.mmf.tls.data;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import cn.mcmod_mmf.mmlib.data.loot.LootTableProviderBuilder;
import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.data.advancements.TLSAdvancementsProvider;
import cn.mmf.tls.data.builtin.TLSSlashBladeRegistry;
import cn.mmf.tls.data.loot.TLSBlockLoot;
import cn.mmf.tls.data.tag.TLSBlockTagsProvider;
import cn.mmf.tls.data.tag.TLSItemTagsProvider;
import mods.flammpfeil.slashblade.data.builtin.SlashBladeBuiltInRegistry;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
	@SubscribeEvent
	public static void dataGen(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		CompletableFuture<Provider> lookupProvider = event.getLookupProvider();
		PackOutput packOutput = dataGenerator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        RegistrySetBuilder bladeBuilder = new RegistrySetBuilder().add(SlashBladeDefinition.REGISTRY_KEY,
                TLSSlashBladeRegistry::registerAll);
        
        dataGenerator.addProvider(event.includeClient(), new TLSLangProvider(packOutput));
        
        dataGenerator.addProvider(event.includeClient(), new TLSBlockStateProvider(packOutput, existingFileHelper));
        
        dataGenerator.addProvider(event.includeClient(), new TLSItemModelProvider(packOutput, existingFileHelper));
        
        dataGenerator.addProvider(event.includeServer(),
                new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, bladeBuilder, Set.of(TheLastSmith.MODID, "slashblade_addon")) {

                    @Override
                    public String getName() {
                        return "TLS SlashBlade Definition Registry";
                    }

        });
        var blockTagsProvider = new TLSBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        
        dataGenerator.addProvider(event.includeServer(), DataGen.getLootTableProvider(packOutput));
        
        dataGenerator.addProvider(event.includeServer(), blockTagsProvider);
        dataGenerator.addProvider(event.includeServer(), new TLSItemTagsProvider(packOutput, lookupProvider, 
        		blockTagsProvider.contentsGetter(), existingFileHelper));
        bladeBuilder = new RegistrySetBuilder().add(SlashBladeDefinition.REGISTRY_KEY,
                k->{
                	SlashBladeBuiltInRegistry.registerAll(k);
                	TLSSlashBladeRegistry.registerAll(k);
                });
        dataGenerator.addProvider(event.includeServer(), new TLSRecipeProvider(packOutput));
        dataGenerator.addProvider(event.includeServer(), new TLSAdvancementsProvider(packOutput, lookupProvider, bladeBuilder, 
        		existingFileHelper, 
        		List.of(new TLSAdvancementsProvider.TLSAdvancementsSubProvider())
        		));
	}
    private static LootTableProvider getLootTableProvider(PackOutput packOutput) {
        LootTableProviderBuilder builder = LootTableProviderBuilder.create();
        builder.addSubProvider(
                new LootTableProvider.SubProviderEntry(TLSBlockLoot::new, LootContextParamSets.BLOCK));
        return builder.build(packOutput);
    }
}
