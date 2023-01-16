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

    public static final RegistryObject<FlowingFluid> SOURCE_POISON = FLUIDS.register("source_poison",
            () -> new ForgeFlowingFluid.Source(ModFluids.POISON_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_POISON = FLUIDS.register("flowing_poison",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.POISON_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_INVIS = FLUIDS.register("source_invis",
            () -> new ForgeFlowingFluid.Source(ModFluids.INVIS_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_INVIS = FLUIDS.register("flowing_invis",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.INVIS_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_SWIFTNESS = FLUIDS.register("source_swiftness",
            () -> new ForgeFlowingFluid.Source(ModFluids.SWIFTNESS_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SWIFTNESS = FLUIDS.register("flowing_swiftness",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SWIFTNESS_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_SLOWNESS = FLUIDS.register("source_slowness",
            () -> new ForgeFlowingFluid.Source(ModFluids.SLOWNESS_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SLOWNESS = FLUIDS.register("flowing_slowness",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SLOWNESS_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_STRENGTH = FLUIDS.register("source_strength",
            () -> new ForgeFlowingFluid.Source(ModFluids.STRENGTH_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_STRENGTH = FLUIDS.register("flowing_strength",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.STRENGTH_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_WEAKNESS = FLUIDS.register("source_weakness",
            () -> new ForgeFlowingFluid.Source(ModFluids.WEAKNESS_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_WEAKNESS = FLUIDS.register("flowing_weakness",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.WEAKNESS_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties REGENERATION_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.REGENERATION_FLUID_TYPE, SOURCE_REGENERATION, FLOWING_REGENERATION)
            .slopeFindDistance(1).levelDecreasePerBlock(1).block(ModBlocks.REGENERATION_BLOCK)
            .bucket(ModItems.REGENERATION_BUCKET);

    public static final ForgeFlowingFluid.Properties POISON_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.POISON_FLUID_TYPE, SOURCE_POISON, FLOWING_POISON)
            .slopeFindDistance(1).levelDecreasePerBlock(1).block(ModBlocks.POISON_BLOCK)
            .bucket(ModItems.POISON_BUCKET);

    public static final ForgeFlowingFluid.Properties INVIS_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.INVIS_FLUID_TYPE, SOURCE_INVIS, FLOWING_INVIS)
            .slopeFindDistance(1).levelDecreasePerBlock(1).block(ModBlocks.INVIS_BLOCK)
            .bucket(ModItems.INVIS_BUCKET);

    public static final ForgeFlowingFluid.Properties SWIFTNESS_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.SWIFTNESS_FLUID_TYPE, SOURCE_SWIFTNESS, FLOWING_SWIFTNESS)
            .slopeFindDistance(1).levelDecreasePerBlock(1).block(ModBlocks.SWIFTNESS_BLOCK)
            .bucket(ModItems.SWIFTNESS_BUCKET);

    public static final ForgeFlowingFluid.Properties SLOWNESS_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.SLOWNESS_FLUID_TYPE, SOURCE_SLOWNESS, FLOWING_SLOWNESS)
            .slopeFindDistance(1).levelDecreasePerBlock(1).block(ModBlocks.SLOWNESS_BLOCK)
            .bucket(ModItems.SLOWNESS_BUCKET);

    public static final ForgeFlowingFluid.Properties STRENGTH_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.STRENGTH_FLUID_TYPE, SOURCE_STRENGTH, FLOWING_STRENGTH)
            .slopeFindDistance(1).levelDecreasePerBlock(1).block(ModBlocks.STRENGTH_BLOCK)
            .bucket(ModItems.STRENGTH_BUCKET);

    public static final ForgeFlowingFluid.Properties WEAKNESS_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.WEAKNESS_FLUID_TYPE, SOURCE_WEAKNESS, FLOWING_WEAKNESS)
            .slopeFindDistance(1).levelDecreasePerBlock(1).block(ModBlocks.WEAKNESS_BLOCK)
            .bucket(ModItems.WEAKNESS_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
