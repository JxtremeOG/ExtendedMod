package net.jxtremeog.extendedmod.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.ICraftingGridHelper;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.extensions.IExtendableRecipeCategory;
import mezz.jei.api.recipe.category.extensions.vanilla.crafting.ICraftingCategoryExtension;
import net.jxtremeog.extendedmod.ExtendedMod;
import net.jxtremeog.extendedmod.block.ModBlocks;
import net.jxtremeog.extendedmod.recipe.TierThreeRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.function.Function;
import java.util.function.Predicate;

public class TierThreeRecipeCategory implements IExtendableRecipeCategory<TierThreeRecipe, ICraftingCategoryExtension>{
    public final static ResourceLocation UID = new ResourceLocation(ExtendedMod.MOD_ID, "workbench_three");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ExtendedMod.MOD_ID, "textures/gui/tier_one_table_gui.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final ICraftingGridHelper craftingGridHelper;

    public TierThreeRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TIERTHREE.get()));
        craftingGridHelper = helper.createCraftingGridHelper();
    }

    @Override
    public RecipeType<TierThreeRecipe> getRecipeType() {
        return JEIExtendedModPlugin.TIER_THREE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Workbench Three");
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
    public void setRecipe(IRecipeLayoutBuilder builder, TierThreeRecipe recipe, IFocusGroup focuses) {
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
    public <R extends TierThreeRecipe> void addCategoryExtension(Class<? extends R> recipeClass, Function<R, ? extends ICraftingCategoryExtension> extensionFactory) {

    }

    @Override
    public <R extends TierThreeRecipe> void addCategoryExtension(Class<? extends R> recipeClass, Predicate<R> extensionFilter, Function<R, ? extends ICraftingCategoryExtension> extensionFactory) {

    }
}
