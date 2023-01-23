package net.jxtremeog.extendedmod.terrablender;

import net.jxtremeog.extendedmod.ExtendedMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes
{
    public static DeferredRegister<Biome> BIOME_REGISTER =
            DeferredRegister.create(Registry.BIOME_REGISTRY, ExtendedMod.MOD_ID);

    public static void registerBiomes()
    {
        register(TestBiomes.HOT_RED, TestOverworldBiomes::hotRed);
        register(TestBiomes.COLD_BLUE, TestOverworldBiomes::coldBlue);
    }

    public static RegistryObject<Biome> register(ResourceKey<Biome> key, Supplier<Biome> biomeSupplier)
    {
        return BIOME_REGISTER.register(key.location().getPath(), biomeSupplier);
    }

    public static void register(IEventBus eventbus){
        BIOME_REGISTER.register(eventbus);
    }
}