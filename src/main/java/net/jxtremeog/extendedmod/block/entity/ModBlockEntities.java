package net.jxtremeog.extendedmod.block.entity;

import net.jxtremeog.extendedmod.ExtendedMod;
import net.jxtremeog.extendedmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExtendedMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<TempBlockEntity>> TEMP =
            BLOCK_ENTITIES.register("temp", () ->
                    BlockEntityType.Builder.of(TempBlockEntity::new,
                            ModBlocks.TEMP.get()).build(null));
    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}

