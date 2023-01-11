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
import net.jxtremeog.extendedmod.recipe.TierOneShapelessRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class TierOneRecipeCategory implements IRecipeCategory<TierOneShapelessRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(ExtendedMod.MOD_ID, "workbench_one_shapeless");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ExtendedMod.MOD_ID, "textures/gui/tier_one_table_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public TierOneRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TIERONE.get()));
    }

    @Override
    public RecipeType<TierOneShapelessRecipe> getRecipeType() {
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
    public void setRecipe(IRecipeLayoutBuilder builder, TierOneShapelessRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 48, 35).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 35).addItemStack(recipe.getResultItem());
    }
}
