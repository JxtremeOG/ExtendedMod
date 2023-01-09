package net.jxtremeog.extendedmod.fluid;

import net.jxtremeog.extendedmod.ExtendedMod;
import net.jxtremeog.extendedmod.block.ModBlocks;
import net.jxtremeog.extendedmod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, ExtendedMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_REGENERATION = FLUIDS.register("source_regeneration",
            () -> new ForgeFlowingFluid.Source(ModFluids.REGENERATION_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_REGENERATION = FLUIDS.register("flowing_regeneration",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.REGENERATION_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties REGENERATION_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.REGENERATION_FLUID_TYPE, SOURCE_REGENERATION, FLOWING_REGENERATION)
            .slopeFindDistance(1).levelDecreasePerBlock(1).block(ModBlocks.REGENERATION_BLOCK)
            .bucket(ModItems.REGENERATION_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
