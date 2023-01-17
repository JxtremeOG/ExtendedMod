package net.jxtremeog.extendedmod.loot;

import com.mojang.serialization.Codec;
import net.jxtremeog.extendedmod.ExtendedMod;
import net.jxtremeog.extendedmod.loot.AdvancedBlueprint.AdvancedBlueprintAncient;
import net.jxtremeog.extendedmod.loot.AdvancedBlueprint.AdvancedBlueprintBastion;
import net.jxtremeog.extendedmod.loot.ImprovedBlueprint.*;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, ExtendedMod.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItemModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> IMPROVED_BLUEPRINT_IN_ABANDONED_MINESHAFTS =
            LOOT_MODIFIER_SERIALIZERS.register("improved_blueprint_in_mineshaft", ImprovedBlueprintMineshaft.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> IMPROVED_BLUEPRINT_IN_DESERT_PYRAMID =
            LOOT_MODIFIER_SERIALIZERS.register("improved_blueprint_in_pyramid", ImprovedBlueprintPyramid.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> IMPROVED_BLUEPRINT_IN_DUNGEON =
            LOOT_MODIFIER_SERIALIZERS.register("improved_blueprint_in_dungeon", ImprovedBlueprintDungeon.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> IMPROVED_BLUEPRINT_IN_SHIPWRECK_TREASURE =
            LOOT_MODIFIER_SERIALIZERS.register("improved_blueprint_in_shipwreck", ImprovedBlueprintShipwreck.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> IMPROVED_BLUEPRINT_IN_JUNGLE_TEMPLE =
            LOOT_MODIFIER_SERIALIZERS.register("improved_blueprint_in_temple", ImprovedBlueprintTemple.CODEC);



    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADVANCED_BLUEPRINT_IN_BASTION_TREASURE =
            LOOT_MODIFIER_SERIALIZERS.register("advanced_blueprint_in_bastion", AdvancedBlueprintBastion.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADVANCED_BLUEPRINT_IN_ANCIENT_CITY =
            LOOT_MODIFIER_SERIALIZERS.register("advanced_blueprint_in_ancient", AdvancedBlueprintAncient.CODEC);

    public static void register(IEventBus eventbus){
        LOOT_MODIFIER_SERIALIZERS.register(eventbus);
    }
}
