package net.jxtremeog.extendedmod.item;

import net.jxtremeog.extendedmod.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab EXTENDED_TAB = new CreativeModeTab("extendedtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.QUARTZ_ORE.get());
        }
    };
}
