package net.jxtremeog.extendedmod.recipe;

import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface TierOneRecipe extends Recipe<CraftingContainer> {
    class Type implements RecipeType<TierOneRecipe> {
        private Type() { }
        public static final TierOneRecipe.Type WORKBENCH_ONE = new TierOneRecipe.Type();
        public static final String ID = "workbench_one";
    }
    default RecipeType<?> getType() {
        return TierOneRecipe.Type.WORKBENCH_ONE;
    }
}
