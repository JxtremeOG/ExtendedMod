package net.jxtremeog.extendedmod.block;

import net.jxtremeog.extendedmod.ExtendedMod;
import net.jxtremeog.extendedmod.block.custom.*;
import net.jxtremeog.extendedmod.fluid.ModFluids;
import net.jxtremeog.extendedmod.fluid.custom.*;
import net.jxtremeog.extendedmod.item.ModCreativeModeTab;
import net.jxtremeog.extendedmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExtendedMod.MOD_ID);


    //Mine
    public static final RegistryObject<Block> TEMP = registerBlock("temp",
            () -> new TempBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.EXTENDED_TAB);

    public static final RegistryObject<Block> TIERONE = registerBlock("tierone_table",
            () -> new TierOneBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.EXTENDED_TAB);

    public static final RegistryObject<Block> TIERTWO = registerBlock("tiertwo_table",
            () -> new TierTwoBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.EXTENDED_TAB);

    public static final RegistryObject<Block> TIERTHREE = registerBlock("tierthree_table",
            () -> new TierThreeBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.EXTENDED_TAB);

    //Quartz Ore
    public static final RegistryObject<Block> QUARTZ_ORE = registerBlock("quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.EXTENDED_TAB);

    //Deepslate Quartz Ore
    public static final RegistryObject<Block> DEEPSLATE_QUARTZ_ORE = registerBlock("deepslate_quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.EXTENDED_TAB);

    //Nether Coal
    public static final RegistryObject<Block> NETHER_COAL_ORE = registerBlock("nether_coal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.EXTENDED_TAB);
    //Nether Iron
    public static final RegistryObject<Block> NETHER_IRON_ORE = registerBlock("nether_iron_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.EXTENDED_TAB);
    //Nether Diamond
    public static final RegistryObject<Block> NETHER_DIAMOND_ORE = registerBlock("nether_diamond_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.EXTENDED_TAB);
    //Nether Emerald
    public static final RegistryObject<Block> NETHER_EMERALD_ORE = registerBlock("nether_emerald_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.EXTENDED_TAB);
    //Nether Lapis
    public static final RegistryObject<Block> NETHER_LAPIS_ORE = registerBlock("nether_lapis_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.EXTENDED_TAB);
    //Nether Redstone
    public static final RegistryObject<Block> NETHER_REDSTONE_ORE = registerBlock("nether_redstone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.EXTENDED_TAB);
    //Nether Copper
    public static final RegistryObject<Block> NETHER_COPPER_ORE = registerBlock("nether_copper_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.EXTENDED_TAB);

    public static final RegistryObject<Block> REDSTONE_LAMP_RED = registerBlock("redstone_lamp_red",
            () -> new RedstoneLampColoredBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(6f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(RedstoneLampColoredBlock.LIT) ? 15 : 0)),
            ModCreativeModeTab.EXTENDED_TAB);

    public static final RegistryObject<Block> WORKED_WOOD = registerBlock("worked_wood",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(6f), UniformInt.of(3,7)), ModCreativeModeTab.EXTENDED_TAB);

    public static final RegistryObject<Block> WORKED_STONE = registerBlock("worked_stone",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.EXTENDED_TAB);

    //Fluids
    public static final RegistryObject<LiquidBlock> REGENERATION_BLOCK = BLOCKS.register("regeneration_block",
            () -> new RegenerationFluid(ModFluids.SOURCE_REGENERATION,
                    BlockBehaviour.Properties.copy(Blocks.WATER).jumpFactor(0)));

    public static final RegistryObject<LiquidBlock> POISON_BLOCK = BLOCKS.register("poison_block",
            () -> new PoisonFluid(ModFluids.SOURCE_POISON,
                    BlockBehaviour.Properties.copy(Blocks.WATER).jumpFactor(0)));

    public static final RegistryObject<LiquidBlock> INVIS_BLOCK = BLOCKS.register("invis_block",
            () -> new InvisibilityFluid(ModFluids.SOURCE_INVIS,
                    BlockBehaviour.Properties.copy(Blocks.WATER).jumpFactor(0)));

    public static final RegistryObject<LiquidBlock> SWIFTNESS_BLOCK = BLOCKS.register("swiftness_block",
            () -> new SwiftnessFluid(ModFluids.SOURCE_SWIFTNESS,
                    BlockBehaviour.Properties.copy(Blocks.WATER).jumpFactor(0)));

    public static final RegistryObject<LiquidBlock> SLOWNESS_BLOCK = BLOCKS.register("slowness_block",
            () -> new SlownessFluid(ModFluids.SOURCE_SLOWNESS,
                    BlockBehaviour.Properties.copy(Blocks.WATER).jumpFactor(0)));

    public static final RegistryObject<LiquidBlock> STRENGTH_BLOCK = BLOCKS.register("strength_block",
            () -> new StrengthFluid(ModFluids.SOURCE_STRENGTH,
                    BlockBehaviour.Properties.copy(Blocks.WATER).jumpFactor(0)));

    public static final RegistryObject<LiquidBlock> WEAKNESS_BLOCK = BLOCKS.register("weakness_block",
            () -> new WeaknessFluid(ModFluids.SOURCE_WEAKNESS,
                    BlockBehaviour.Properties.copy(Blocks.WATER).jumpFactor(0)));

    //TUTORIAL
    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> NETHERRACK_ZIRCON_ORE = registerBlock("netherrack_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> ENDSTONE_ZIRCON_ORE = registerBlock("endstone_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_MISC);


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }



}
