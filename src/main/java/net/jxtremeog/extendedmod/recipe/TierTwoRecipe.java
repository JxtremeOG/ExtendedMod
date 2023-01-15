package net.jxtremeog.extendedmod.recipe;

import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface TierTwoRecipe extends Recipe<CraftingContainer> {
    class Type implements RecipeType<TierTwoRecipe> {
        private Type() { }
        public static final TierTwoRecipe.Type WORKBENCH_TWO = new TierTwoRecipe.Type();
        public static final String ID = "workbench_two";
    }
    default RecipeType<?> getType() {
        return TierTwoRecipe.Type.WORKBENCH_TWO;
    }
}
