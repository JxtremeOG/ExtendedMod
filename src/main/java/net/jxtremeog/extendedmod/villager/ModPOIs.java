package net.jxtremeog.extendedmod.villager;

import com.google.common.collect.ImmutableSet;
import net.jxtremeog.extendedmod.ExtendedMod;
import net.jxtremeog.extendedmod.block.ModBlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPOIs {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, ExtendedMod.MOD_ID);

    public static final RegistryObject<PoiType> JX_PORTAL =
            POI.register("jx_portal", () -> new PoiType(
                    ImmutableSet.copyOf(ModBlocks.JX_PORTAL.get().getStateDefinition()
                                    .getPossibleStates()), 0, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}
