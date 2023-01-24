package net.jxtremeog.extendedmod.terrablender;

import net.jxtremeog.extendedmod.ExtendedMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class TestBiomes
{
    public static final ResourceKey<Biome> HOT_RED = register("hot_red");
    public static final ResourceKey<Biome> COLD_BLUE = register("cold_blue");

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(ExtendedMod.MOD_ID, name));
    }
}
