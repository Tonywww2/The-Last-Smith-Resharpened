package cn.mmf.tls.data;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import cn.mmf.tls.TheLastSmith;
import cn.mmf.tls.data.builtin.BuiltInSlashBladeRegistry;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
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
        final RegistrySetBuilder bladeBuilder = new RegistrySetBuilder().add(SlashBladeDefinition.REGISTRY_KEY,
                BuiltInSlashBladeRegistry::registerAll);
        
        dataGenerator.addProvider(event.includeClient(), new TLSLangProvider(packOutput));
        
        dataGenerator.addProvider(event.includeServer(),
                new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, bladeBuilder, Set.of(TheLastSmith.MODID)) {

                    @Override
                    public String getName() {
                        return "TLS SlashBlade Definition Registry";
                    }

        });
        
        
	}
}
