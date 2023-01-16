package net.jxtremeog.extendedmod.fluid;
import com.mojang.math.Vector3f;
import net.jxtremeog.extendedmod.ExtendedMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ExtendedMod.MOD_ID);

    //SPECIFIC FLUID
    public static final RegistryObject<FluidType> REGENERATION_FLUID_TYPE = register("regeneration_fluid",
            FluidType.Properties.create()
                    .canDrown(true).canExtinguish(true).canSwim(true).canPushEntity(true)
                    .lightLevel(0/*2*/).density(1000).temperature(300).viscosity(1000).motionScale(.008).fallDistanceModifier(0));

    public static final RegistryObject<FluidType> POISON_FLUID_TYPE = register("poison_fluid",
            FluidType.Properties.create()
                    .canDrown(true).canExtinguish(true).canSwim(true).canPushEntity(true)
                    .lightLevel(0/*2*/).density(1000).temperature(300).viscosity(1000).motionScale(.008).fallDistanceModifier(0));

    public static final RegistryObject<FluidType> INVIS_FLUID_TYPE = register("invis_fluid",
            FluidType.Properties.create()
                    .canDrown(true).canExtinguish(true).canSwim(true).canPushEntity(true)
                    .lightLevel(0/*2*/).density(1000).temperature(300).viscosity(1000).motionScale(.008).fallDistanceModifier(0));

    public static final RegistryObject<FluidType> SWIFTNESS_FLUID_TYPE = register("swiftness_fluid",
            FluidType.Properties.create()
                    .canDrown(true).canExtinguish(true).canSwim(true).canPushEntity(true)
                    .lightLevel(0/*2*/).density(1000).temperature(300).viscosity(1000).motionScale(.016).fallDistanceModifier(0));

    public static final RegistryObject<FluidType> SLOWNESS_FLUID_TYPE = register("slowness_fluid",
            FluidType.Properties.create()
                    .canDrown(true).canExtinguish(true).canSwim(true).canPushEntity(true)
                    .lightLevel(0/*2*/).density(1000).temperature(300).viscosity(1000).motionScale(.004).fallDistanceModifier(0));

    public static final RegistryObject<FluidType> STRENGTH_FLUID_TYPE = register("strength_fluid",
            FluidType.Properties.create()
                    .canDrown(true).canExtinguish(true).canSwim(true).canPushEntity(true)
                    .lightLevel(0/*2*/).density(1000).temperature(300).viscosity(1000).motionScale(.006).fallDistanceModifier(0));

    public static final RegistryObject<FluidType> WEAKNESS_FLUID_TYPE = register("weakness_fluid",
            FluidType.Properties.create()
                    .canDrown(true).canExtinguish(true).canSwim(true).canPushEntity(true)
                    .lightLevel(0/*2*/).density(1000).temperature(300).viscosity(1000).motionScale(.008).fallDistanceModifier(0));

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        if(name == "regeneration_fluid")
            return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL,
                    0xA1d12acf , new Vector3f(224f / 255f, 56f / 255f, 208f / 255f), properties));
        else if (name == "poison_fluid")
            return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL,
                    0xA1124f10 , new Vector3f(18f / 255f, 79f / 255f, 16f / 255f), properties));
        else if (name == "swiftness_fluid")
            return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL,
                    0xA17EB2CA , new Vector3f(126f / 255f, 178f / 255f, 202f / 255f), properties));
        else if (name == "slowness_fluid")
            return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL,
                    0xA15C6E83 , new Vector3f(92f / 255f, 110f / 255f, 131f / 255f), properties));
        else if (name == "strength_fluid")
            return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL,
                    0xA1962524 , new Vector3f(150f / 255f, 37f / 255f, 36f / 255f), properties));
        else
            return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL,
                    0xA1494E49 , new Vector3f(73f / 255f, 78f / 255f, 73f / 255f), properties));
    }



    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
