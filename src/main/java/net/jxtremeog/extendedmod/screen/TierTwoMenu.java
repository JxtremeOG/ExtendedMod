package net.jxtremeog.extendedmod.screen;

import net.jxtremeog.extendedmod.recipe.TierOneShapedRecipe;
import net.jxtremeog.extendedmod.recipe.TierOneShapelessRecipe;
import net.jxtremeog.extendedmod.recipe.TierTwoShapedRecipe;
import net.jxtremeog.extendedmod.recipe.TierTwoShapelessRecipe;
import net.jxtremeog.extendedmod.world.inventory.ModResultSlot;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.Optional;

public class TierTwoMenu extends RecipeBookMenu<CraftingContainer> {
    public static final int RESULT_SLOT = 0;
    private static final int CRAFT_SLOT_START = 1;
    private static final int CRAFT_SLOT_END = 10;
    private static final int INV_SLOT_START = 10;
    private static final int INV_SLOT_END = 37;
    private static final int USE_ROW_SLOT_START = 37;
    private static final int USE_ROW_SLOT_END = 46;
    private final CraftingContainer craftSlots = new CraftingContainer(this, 3, 3);
    public final ResultContainer resultSlots = new ResultContainer();
    private final ContainerLevelAccess access;
    private final Player player;
    public static ResourceLocation currentRecipe;

    public TierTwoMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public TierTwoMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(MenuType.CRAFTING, pContainerId);
        this.access = pAccess;
        this.player = pPlayerInventory.player;
        this.addSlot(new ModResultSlot(pPlayerInventory.player, this.craftSlots, this.resultSlots, 0, 124, 35));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                this.addSlot(new Slot(this.craftSlots, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }

        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(pPlayerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(pPlayerInventory, l, 8 + l * 18, 142));
        }

    }

    //CRAFTING
    protected static void slotChangedCraftingGrid(AbstractContainerMenu pMenu, Level pLevel, Player pPlayer, CraftingContainer pContainer, ResultContainer pResult) {
        if (!pLevel.isClientSide) {
            ServerPlayer serverplayer = (ServerPlayer)pPlayer;
            ItemStack itemstack = ItemStack.EMPTY;
            //RECIPE
            // TierOneRecipe.Type.WORKBENCH_ONE
            // RecipeType.CRAFTING

            Optional<TierTwoShapedRecipe> optional = pLevel.getServer().getRecipeManager().getRecipeFor(TierTwoShapedRecipe.Type.WORKBENCH_TWO_SHAPED, pContainer, pLevel);
            //CRAFTING SHAPELESS TIER ONE
            if (optional.isPresent()) {
                // && (optional.get().getId() + "").contains("tier_one")

                System.out.println("Recipe detected "+optional.get().getId());

                //currentRecipe used in ModResultSlot class
                currentRecipe = optional.get().getId();

                TierTwoShapedRecipe craftingrecipe = optional.get();
                if (pResult.setRecipeUsed(pLevel, serverplayer, craftingrecipe)) {
                    //RESULT
                    itemstack = craftingrecipe.assemble(pContainer);
                }
            }
            else {
                Optional<TierTwoShapelessRecipe> optional2 = pLevel.getServer().getRecipeManager().getRecipeFor(TierTwoShapelessRecipe.Type.WORKBENCH_TWO_SHAPELESS, pContainer, pLevel);
                System.out.println(optional2);
                //CRAFTING SHAPED TIER ONE
                if (optional2.isPresent()) {
                    // && (optional.get().getId() + "").contains("tier_one")

                    System.out.println("Recipe detected " + optional2.get().getId());

                    //currentRecipe used in ModResultSlot class
                    currentRecipe = optional2.get().getId();

                    TierTwoShapelessRecipe craftingrecipe = optional2.get();
                    if (pResult.setRecipeUsed(pLevel, serverplayer, craftingrecipe)) {
                        //RESULT
                        itemstack = craftingrecipe.assemble(pContainer);
                    }
                } else {
                    Optional<TierOneShapedRecipe> optional3 = pLevel.getServer().getRecipeManager().getRecipeFor(TierOneShapedRecipe.Type.WORKBENCH_ONE_SHAPED, pContainer, pLevel);
                    System.out.println(optional3);
                    if (optional3.isPresent()) {
                        // && (optional.get().getId() + "").contains("tier_one")

                        System.out.println("Recipe detected " + optional3.get().getId());

                        //currentRecipe used in ModResultSlot class
                        currentRecipe = optional3.get().getId();

                        TierOneShapedRecipe craftingrecipe = optional3.get();
                        if (pResult.setRecipeUsed(pLevel, serverplayer, craftingrecipe)) {
                            //RESULT
                            itemstack = craftingrecipe.assemble(pContainer);
                        }
                    } else {
                        Optional<TierOneShapelessRecipe> optional4 = pLevel.getServer().getRecipeManager().getRecipeFor(TierOneShapelessRecipe.Type.WORKBENCH_ONE_SHAPELESS, pContainer, pLevel);
                        System.out.println(optional4);
                        //CRAFTING SHAPED TIER ONE
                        if (optional4.isPresent()) {
                            // && (optional.get().getId() + "").contains("tier_one")

                            System.out.println("Recipe detected " + optional4.get().getId());

                            //currentRecipe used in ModResultSlot class
                            currentRecipe = optional4.get().getId();

                            TierOneShapelessRecipe craftingrecipe = optional4.get();
                            if (pResult.setRecipeUsed(pLevel, serverplayer, craftingrecipe)) {
                                //RESULT
                                itemstack = craftingrecipe.assemble(pContainer);
                            }
                        } else {
                            //CRAFTING VANILLA
                            Optional<CraftingRecipe> optional5 = pLevel.getServer().getRecipeManager().getRecipeFor(RecipeType.CRAFTING, pContainer, pLevel);
                            System.out.println(optional5);
                            if (optional5.isPresent()) {
                                // && (optional.get().getId() + "").contains("tier_one")

                                System.out.println("Recipe detected " + optional5.get().getId());

                                //currentRecipe used in ModResultSlot class
                                currentRecipe = optional5.get().getId();

                                CraftingRecipe craftingrecipe = optional5.get();
                                if (pResult.setRecipeUsed(pLevel, serverplayer, craftingrecipe)) {
                                    //RESULT
                                    itemstack = craftingrecipe.assemble(pContainer);
                                }
                            }
                        }
                    }
                }
            }

            pResult.setItem(0, itemstack);
            pMenu.setRemoteSlot(0, itemstack);
            serverplayer.connection.send(new ClientboundContainerSetSlotPacket(pMenu.containerId, pMenu.incrementStateId(), 0, itemstack));
        }
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void slotsChanged(Container pInventory) {
        this.access.execute((level, pos) -> {
            slotChangedCraftingGrid(this, level, this.player, this.craftSlots, this.resultSlots);
        });
    }

    public void fillCraftSlotsStackedContents(StackedContents pItemHelper) {
        this.craftSlots.fillStackedContents(pItemHelper);
    }

    public void clearCraftingContent() {
        this.craftSlots.clearContent();
        this.resultSlots.clearContent();
    }

    //CHECKS WITH BOOK NOT RELAVENT
    public boolean recipeMatches(Recipe<? super CraftingContainer> pRecipe) {
        return pRecipe.matches(this.craftSlots, this.player.level);
    }

    /**
     * Called when the container is closed.
     */
    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.access.execute((p_39371_, p_39372_) -> {
            this.clearContainer(pPlayer, this.craftSlots);
        });
    }

    /**
     * Determines whether supplied player can use this container
     */
    public boolean stillValid(Player pPlayer) {
        return stillValid(this.access, pPlayer, Blocks.CRAFTING_TABLE);
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex == 0) {
                this.access.execute((p_39378_, p_39379_) -> {
                    itemstack1.getItem().onCraftedBy(itemstack1, p_39378_, pPlayer);
                });
                if (!this.moveItemStackTo(itemstack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (pIndex >= 10 && pIndex < 46) {
                if (!this.moveItemStackTo(itemstack1, 1, 10, false)) {
                    if (pIndex < 37) {
                        if (!this.moveItemStackTo(itemstack1, 37, 46, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.moveItemStackTo(itemstack1, 10, 37, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(itemstack1, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, itemstack1);
            if (pIndex == 0) {
                pPlayer.drop(itemstack1, false);
            }
        }

        return itemstack;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in is
     * null for the initial slot that was double-clicked.
     */
    public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot) {
        return pSlot.container != this.resultSlots && super.canTakeItemForPickAll(pStack, pSlot);
    }

    public int getResultSlotIndex() {
        return 0;
    }

    public int getGridWidth() {
        return this.craftSlots.getWidth();
    }

    public int getGridHeight() {
        return this.craftSlots.getHeight();
    }

    public int getSize() {
        return 10;
    }

    public RecipeBookType getRecipeBookType() {
        System.out.println("getRecipeBookType "+RecipeBookType.CRAFTING);
        return RecipeBookType.CRAFTING;
    }

    public boolean shouldMoveToInventory(int pSlotIndex) {
        return pSlotIndex != this.getResultSlotIndex();
    }
}