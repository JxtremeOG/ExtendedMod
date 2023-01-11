package net.jxtremeog.extendedmod.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.jxtremeog.extendedmod.ExtendedMod;
import net.jxtremeog.extendedmod.recipe.TempRecipe;
import net.jxtremeog.extendedmod.recipe.TierOneShapelessRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIExtendedModPlugin implements IModPlugin {

    public static RecipeType<TempRecipe> TEMP_TYPE =
            new RecipeType<>(TempRecipeCategory.UID, TempRecipe.class);
    public static RecipeType<TierOneShapelessRecipe> TIER_ONE_TYPE =
            new RecipeType<>(TierOneRecipeCategory.UID, TierOneShapelessRecipe.class);
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ExtendedMod.MOD_ID,"jei_plugin");
    }

    //MUST REGISTER RECIPE CATEGORY BELOW
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                TempRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                TierOneRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<TempRecipe> recipesInfusing = rm.getAllRecipesFor(TempRecipe.Type.INSTANCE);
        registration.addRecipes(TEMP_TYPE, recipesInfusing);

        List<TierOneShapelessRecipe> recipesTierOne = rm.getAllRecipesFor(TierOneShapelessRecipe.Type.WORKBENCH_ONE_SHAPELESS);
        registration.addRecipes(TIER_ONE_TYPE, recipesTierOne);
    }
}
