package net.jxtremeog.extendedmod.screen;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.Block;

public class TierThreeScreen extends TierThreeMenu {
    private final Block workbench;
    private final ContainerLevelAccess worldPos;

    public TierThreeScreen(int id, Inventory playerInv, ContainerLevelAccess worldPos, Block workbench) {
        super(id, playerInv, worldPos);
        this.workbench = workbench;
        this.worldPos = worldPos;
    }

    protected static boolean isWithinUsableDistance(ContainerLevelAccess worldPos, Player playerIn, Block targetBlock) {
        return (Boolean)worldPos.evaluate((world, pos) ->
                world.getBlockState(pos).getBlock() == targetBlock && playerIn.distanceToSqr((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5) <= 64.0, (Object)true);
    }

    public boolean stillValid(Player playerIn) {
        return TierThreeScreen.isWithinUsableDistance(this.worldPos, playerIn, this.workbench);
    }
}
