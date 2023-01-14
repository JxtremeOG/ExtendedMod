package net.jxtremeog.extendedmod.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.extensions.IExtendableRecipeCategory;
import mezz.jei.api.recipe.category.extensions.vanilla.crafting.ICraftingCategoryExtension;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import net.jxtremeog.extendedmod.ExtendedMod;
import net.jxtremeog.extendedmod.recipe.TempRecipe;
import net.jxtremeog.extendedmod.recipe.TierOneRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIExtendedModPlugin implements IModPlugin {

    public static RecipeType<TempRecipe> TEMP_TYPE =
            new RecipeType<>(TempRecipeCategory.UID, TempRecipe.class);
    public static RecipeType<TierOneRecipe> TIER_ONE_TYPE =
            new RecipeType<>(TierOneRecipeCategory.UID, TierOneRecipe.class);
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

        List<TierOneRecipe> recipesTierOne = rm.getAllRecipesFor(TierOneRecipe.Type.WORKBENCH_ONE);
        registration.addRecipes(TIER_ONE_TYPE, recipesTierOne);
    }
}
