package net.jxtremeog.extendedmod.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.ICraftingGridHelper;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.category.extensions.IExtendableRecipeCategory;
import mezz.jei.api.recipe.category.extensions.vanilla.crafting.ICraftingCategoryExtension;
import net.jxtremeog.extendedmod.ExtendedMod;
import net.jxtremeog.extendedmod.block.ModBlocks;
import net.jxtremeog.extendedmod.recipe.TempRecipe;
import net.jxtremeog.extendedmod.recipe.TierOneRecipe;
import net.jxtremeog.extendedmod.recipe.TierOneShapedRecipe;
import net.jxtremeog.extendedmod.recipe.TierOneShapelessRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.Nullable;


import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class TierOneRecipeCategory implements IExtendableRecipeCategory<TierOneRecipe, ICraftingCategoryExtension>{
    public final static ResourceLocation UID = new ResourceLocation(ExtendedMod.MOD_ID, "workbench_one");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ExtendedMod.MOD_ID, "textures/gui/tier_one_table_gui.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final ICraftingGridHelper craftingGridHelper;

    public TierOneRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TIERONE.get()));
        craftingGridHelper = helper.createCraftingGridHelper();
    }

    @Override
    public RecipeType<TierOneRecipe> getRecipeType() {
        return JEIExtendedModPlugin.TIER_ONE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Workbench One");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TierOneRecipe recipe, IFocusGroup focuses) {
        WorkbenchShapedIngredientLocation slotLocations;
        String recipeId = recipe.getId()+"";
        if(recipeId.contains("shaped")){
            int test = recipeId.indexOf("shaped")+7;
            //GETS THE ENUM NAME
            slotLocations = WorkbenchShapedIngredientLocation.valueOf((recipeId.substring(recipeId.indexOf("shaped")+7).toUpperCase()));
            //USES THE NAME TO GET SLOT LOCATIONS FOR INGREDIENTS
            for(int ingredient = 0; ingredient<slotLocations.getSlotLocations().length(); ingredient++){
                int xLoc = 30;
                int yLoc = 17;
                int slotNum = Integer.parseInt(slotLocations.getSlotLocations().substring(ingredient,ingredient+1));
                for(int x = 0; x<slotNum; x++){
                    xLoc+=18;
                    if(xLoc == 84){
                        xLoc=30;
                        yLoc+=18;
                    }
                }
                builder.addSlot(RecipeIngredientRole.INPUT, xLoc, yLoc).addIngredients(recipe.getIngredients().get(ingredient));
            }

        }else{
            int xLoc = 30;
            int yLoc = 17;
            for(int ingredient = 0; ingredient<recipe.getIngredients().size(); ingredient++){
                builder.addSlot(RecipeIngredientRole.INPUT, xLoc, yLoc).addIngredients(recipe.getIngredients().get(ingredient));
                xLoc+=18;
                if(xLoc == 84){
                    xLoc=30;
                    yLoc+=18;
                }
            }
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 35).addItemStack(recipe.getResultItem());
    }

    @Override
    public <R extends TierOneRecipe> void addCategoryExtension(Class<? extends R> recipeClass, Function<R, ? extends ICraftingCategoryExtension> extensionFactory) {

    }

    @Override
    public <R extends TierOneRecipe> void addCategoryExtension(Class<? extends R> recipeClass, Predicate<R> extensionFilter, Function<R, ? extends ICraftingCategoryExtension> extensionFactory) {

    }
}
