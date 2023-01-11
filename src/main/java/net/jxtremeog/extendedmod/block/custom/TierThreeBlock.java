package net.jxtremeog.extendedmod.block.custom;

import net.jxtremeog.extendedmod.screen.TierOneScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TierThreeBlock extends CraftingTableBlock {
    private static final Component GUI_TITLE = Component.translatable("container.crafting");

    public TierThreeBlock(Properties properties) {
        super(properties);
    }

    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        return new SimpleMenuProvider((id, inventory, entity) -> new TierOneScreen(id, inventory, ContainerLevelAccess.create((Level)worldIn, (BlockPos)pos), (Block)this), GUI_TITLE);
    }
}
