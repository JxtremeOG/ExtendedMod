package net.jxtremeog.extendedmod.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import it.unimi.dsi.fastutil.ints.IntList;
import net.jxtremeog.extendedmod.ExtendedMod;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class TierOneRecipe implements Recipe<CraftingContainer>{
    //implements Recipe<CraftingContainer>
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    private final boolean isSimple;

    public TierOneRecipe(ResourceLocation id, ItemStack output,
                                    NonNullList<Ingredient> recipeItems) {
//        super(id); Needs to extend CustomRecipe to implement
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.isSimple = recipeItems.stream().allMatch(Ingredient::isSimple);
    }

    @Override
    public boolean matches(CraftingContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()){
            return false;
        }
        StackedContents stackedcontents = new StackedContents();
        java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
        int i = 0;

        for(int j = 0; j < pContainer.getContainerSize(); ++j) {
            ItemStack itemstack = pContainer.getItem(j);
            if (!itemstack.isEmpty()) {
                ++i;
                if (isSimple)
                    stackedcontents.accountStack(itemstack, 1);
                else inputs.add(itemstack);
            }
        }
        return i == this.recipeItems.size() && (isSimple ? stackedcontents.canCraft(this, (IntList)null) : net.minecraftforge.common.util.RecipeMatcher.findMatches(inputs,  this.recipeItems) != null);
//        //TAKE NOTE OF INDEX
//        return recipeItems.get(0).test(pContainer.getItem(4));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    @Override
    public ItemStack assemble(CraftingContainer pContainer) {
        return this.getResultItem().copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.WORKBENCH_ONE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.WORKBENCH_ONE;
    }

    public static class Type implements RecipeType<TierOneRecipe> {
        private Type() { }
        public static final Type WORKBENCH_ONE = new Type();
        public static final String ID = "workbench_one";
    }

    public static class Serializer implements RecipeSerializer<TierOneRecipe> {
        public static final Serializer WORKBENCH_ONE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(ExtendedMod.MOD_ID, "workbench_one");

        @Override
//        public TierOneRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
//            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
//            NonNullList<Ingredient> inputs = NonNullList.withSize(/*AMOUNT OF INGREDIENTS*/2, Ingredient.EMPTY);
//
//            for (int i = 0; i < inputs.size(); i++) {
//                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
//            }
//            ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));
//            return new TierOneRecipe(pRecipeId,itemstack, inputs);
//        }

        public TierOneRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            NonNullList<Ingredient> nonnulllist = itemsFromJson(GsonHelper.getAsJsonArray(pJson, "ingredients"));
            if (nonnulllist.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            } else if (nonnulllist.size() > 9) {
                throw new JsonParseException("Too many ingredients for shapeless recipe. The maximum is " + (9));
            } else {
                ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));
                return new TierOneRecipe(pRecipeId, itemstack, nonnulllist);
            }
        }

        private static NonNullList<Ingredient> itemsFromJson(JsonArray pIngredientArray) {
            NonNullList<Ingredient> nonnulllist = NonNullList.create();

            for(int i = 0; i < pIngredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(pIngredientArray.get(i));
                if (true || !ingredient.isEmpty()) { // FORGE: Skip checking if an ingredient is empty during shapeless recipe deserialization to prevent complex ingredients from caching tags too early. Can not be done using a config value due to sync issues.
                    nonnulllist.add(ingredient);
                }
            }

            return nonnulllist;
        }

        @Override
        public @Nullable TierOneRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new TierOneRecipe(id, output, inputs);
        }
        @Override
        public void toNetwork(FriendlyByteBuf buf, TierOneRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
    }
