package net.jxtremeog.extendedmod.recipe;

import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface TierThreeRecipe extends Recipe<CraftingContainer> {
    class Type implements RecipeType<TierThreeRecipe> {
        private Type() { }
        public static final TierThreeRecipe.Type WORKBENCH_THREE = new TierThreeRecipe.Type();
        public static final String ID = "workbench_three";
    }
    default RecipeType<?> getType() {
        return TierThreeRecipe.Type.WORKBENCH_THREE;
    }
}
