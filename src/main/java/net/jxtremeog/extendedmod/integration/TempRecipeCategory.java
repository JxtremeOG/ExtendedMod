package net.jxtremeog.extendedmod.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.jxtremeog.extendedmod.ExtendedMod;
import net.jxtremeog.extendedmod.block.ModBlocks;
import net.jxtremeog.extendedmod.recipe.TempRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class TempRecipeCategory implements IRecipeCategory<TempRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(ExtendedMod.MOD_ID, "testing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ExtendedMod.MOD_ID, "textures/gui/temp_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public TempRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TEMP.get()));
    }

    @Override
    public RecipeType<TempRecipe> getRecipeType() {
        return JEIExtendedModPlugin.TEMP_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Temp");
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
    public void setRecipe(IRecipeLayoutBuilder builder, TempRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).
                addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).
                addItemStack(recipe.getResultItem());
    }
}
