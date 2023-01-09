package net.jxtremeog.extendedmod.item;

import net.jxtremeog.extendedmod.ExtendedMod;
import net.jxtremeog.extendedmod.fluid.ModFluids;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExtendedMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> NETHERITE_HORSE_ARMOR = ITEMS.register("netherite_horse_armor",
            () -> new HorseArmorItem(11, "netherite",
                    (new Item.Properties().tab(ModCreativeModeTab.EXTENDED_TAB)
                            .stacksTo(1))));

    //Regeneration Bucket
    public static final RegistryObject<Item> REGENERATION_BUCKET = ITEMS.register("regeneration_bucket",
            () -> new BucketItem(ModFluids.SOURCE_REGENERATION,
                    new Item.Properties().tab(ModCreativeModeTab.EXTENDED_TAB)
                            .craftRemainder(Items.BUCKET).stacksTo(1)));



    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}
