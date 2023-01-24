package net.jxtremeog.extendedmod;

import com.mojang.logging.LogUtils;
import net.jxtremeog.extendedmod.block.ModBlocks;
import net.jxtremeog.extendedmod.block.entity.ModBlockEntities;
import net.jxtremeog.extendedmod.fluid.ModFluidTypes;
import net.jxtremeog.extendedmod.fluid.ModFluids;
import net.jxtremeog.extendedmod.item.ModItems;
import net.jxtremeog.extendedmod.loot.ModLootModifiers;
import net.jxtremeog.extendedmod.recipe.ModRecipes;
import net.jxtremeog.extendedmod.screen.ModMenuTypes;
import net.jxtremeog.extendedmod.screen.TempScreen;
import net.jxtremeog.extendedmod.terrablender.ModBiomes;
import net.jxtremeog.extendedmod.terrablender.TestRegion;
import net.jxtremeog.extendedmod.terrablender.TestSurfaceRuleData;
import net.jxtremeog.extendedmod.villager.ModPOIs;
import net.jxtremeog.extendedmod.villager.ModVillagers;
import net.jxtremeog.extendedmod.world.dimension.ModDimensions;
import net.jxtremeog.extendedmod.world.feature.ModConfiguredFeatures;
import net.jxtremeog.extendedmod.world.feature.ModPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExtendedMod.MOD_ID)
public class ExtendedMod
{
    public static final String MOD_ID = "extendedmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExtendedMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModDimensions.register();
        ModPOIs.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModBiomes.BIOME_REGISTER.register(modEventBus);
        ModBiomes.registerBiomes();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModVillagers.registerPOIS();

            // Given we only add two biomes, we should keep our weight relatively low.
            Regions.register(new TestRegion(new ResourceLocation(MOD_ID, "overworld"), 2));

            // Register our surface rules
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, TestSurfaceRuleData.makeRules());
        });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_REGENERATION.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_REGENERATION.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_POISON.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_POISON.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_INVIS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_INVIS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SWIFTNESS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SWIFTNESS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SLOWNESS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SLOWNESS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_STRENGTH.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_STRENGTH.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_WEAKNESS.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_WEAKNESS.get(), RenderType.translucent());

            MenuScreens.register(ModMenuTypes.TEMP_MENU.get(), TempScreen::new);
        }
    }
}
