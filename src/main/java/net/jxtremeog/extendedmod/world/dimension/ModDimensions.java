package net.jxtremeog.extendedmod.world.dimension;

import net.jxtremeog.extendedmod.ExtendedMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> JXDIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(ExtendedMod.MOD_ID, "jxdim"));
    public static final ResourceKey<DimensionType> JXDIM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
                    new ResourceLocation(ExtendedMod.MOD_ID, "jxdim"));

    public static void register(){
        System.out.println("Registering ModDimensions for " + ExtendedMod.MOD_ID);
    }
}
