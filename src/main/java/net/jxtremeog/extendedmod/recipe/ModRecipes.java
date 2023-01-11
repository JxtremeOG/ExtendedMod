package net.jxtremeog.extendedmod.recipe;

import net.jxtremeog.extendedmod.ExtendedMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ExtendedMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<TempRecipe>> TEMP_SERIALIZER =
            SERIALIZERS.register("testing", () -> TempRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<TierOneShapelessRecipe>> WORKBENCH_ONE_SHAPELESS_SERIALIZER =
            SERIALIZERS.register("workbench_one_shapeless", () -> TierOneShapelessRecipe.Serializer.WORKBENCH_ONE_SHAPELESS);

    public static final RegistryObject<RecipeSerializer<TierOneShapedRecipe>> WORKBENCH_ONE_SHAPED_SERIALIZER =
            SERIALIZERS.register("workbench_one_shaped", () -> TierOneShapedRecipe.Serializer.WORKBENCH_ONE_SHAPED);

    public static final RegistryObject<RecipeSerializer<TierTwoShapelessRecipe>> WORKBENCH_TWO_SHAPELESS_SERIALIZER =
            SERIALIZERS.register("workbench_two_shapeless", () -> TierTwoShapelessRecipe.Serializer.WORKBENCH_TWO_SHAPELESS);

    public static final RegistryObject<RecipeSerializer<TierTwoShapedRecipe>> WORKBENCH_TWO_SHAPED_SERIALIZER =
            SERIALIZERS.register("workbench_two_shaped", () -> TierTwoShapedRecipe.Serializer.WORKBENCH_TWO_SHAPED);

    public static final RegistryObject<RecipeSerializer<TierThreeShapelessRecipe>> WORKBENCH_THREE_SHAPELESS_SERIALIZER =
            SERIALIZERS.register("workbench_three_shapeless", () -> TierThreeShapelessRecipe.Serializer.WORKBENCH_THREE_SHAPELESS);

    public static final RegistryObject<RecipeSerializer<TierThreeShapedRecipe>> WORKBENCH_THREE_SHAPED_SERIALIZER =
            SERIALIZERS.register("workbench_three_shaped", () -> TierThreeShapedRecipe.Serializer.WORKBENCH_THREE_SHAPED);


    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
