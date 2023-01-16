package net.jxtremeog.extendedmod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.jxtremeog.extendedmod.ExtendedMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.minecraftforge.fluids.FluidType;


public class FluidOverlay {
    private static final ResourceLocation REGENERATION_FLUID_ICON = new ResourceLocation(ExtendedMod.MOD_ID,
            "textures/misc/regeneration_overlay.png");
    private static final ResourceLocation POISON_FLUID_ICON = new ResourceLocation(ExtendedMod.MOD_ID,
            "textures/misc/poison_overlay.png");
    private static final ResourceLocation INVISIBILITY_FLUID_ICON = new ResourceLocation(ExtendedMod.MOD_ID,
            "textures/misc/invisibility_overlay.png");
    private static final ResourceLocation SWIFTNESS_FLUID_ICON = new ResourceLocation(ExtendedMod.MOD_ID,
            "textures/misc/swiftness_overlay.png");
    private static final ResourceLocation SLOWNESS_FLUID_ICON = new ResourceLocation(ExtendedMod.MOD_ID,
            "textures/misc/slowness_overlay.png");
    private static final ResourceLocation STRENGTH_FLUID_ICON = new ResourceLocation(ExtendedMod.MOD_ID,
            "textures/misc/strength_overlay.png");
    private static final ResourceLocation WEAKNESS_FLUID_ICON = new ResourceLocation(ExtendedMod.MOD_ID,
            "textures/misc/weakness_overlay.png");

    public static final IGuiOverlay HUD_FLUID = ((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
       int x = screenWidth;
       int y = screenHeight;
       //Check fluid before applying overlay
        if((Minecraft.getInstance().player.getEyeInFluidType()+"").equals("extendedmod:regeneration_fluid")){
            RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, REGENERATION_FLUID_ICON);
            GuiComponent.blit(poseStack, 0, 0, 0, 0, x, y, 12, 12);
        } else if ((Minecraft.getInstance().player.getEyeInFluidType()+"").equals("extendedmod:poison_fluid")) {
            RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, POISON_FLUID_ICON);
            GuiComponent.blit(poseStack, 0, 0, 0, 0, x, y, 12, 12);
        } else if ((Minecraft.getInstance().player.getEyeInFluidType()+"").equals("extendedmod:invis_fluid")) {
            RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, INVISIBILITY_FLUID_ICON);
            GuiComponent.blit(poseStack, 0, 0, 0, 0, x, y, 12, 12);
        } else if ((Minecraft.getInstance().player.getEyeInFluidType()+"").equals("extendedmod:swiftness_fluid")) {
            RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, SWIFTNESS_FLUID_ICON);
            GuiComponent.blit(poseStack, 0, 0, 0, 0, x, y, 12, 12);
        } else if ((Minecraft.getInstance().player.getEyeInFluidType()+"").equals("extendedmod:slowness_fluid")) {
            RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, SLOWNESS_FLUID_ICON);
            GuiComponent.blit(poseStack, 0, 0, 0, 0, x, y, 12, 12);
        } else if ((Minecraft.getInstance().player.getEyeInFluidType()+"").equals("extendedmod:strength_fluid")) {
            RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, STRENGTH_FLUID_ICON);
            GuiComponent.blit(poseStack, 0, 0, 0, 0, x, y, 12, 12);
        } else if ((Minecraft.getInstance().player.getEyeInFluidType()+"").equals("extendedmod:weakness_fluid")) {
            RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, WEAKNESS_FLUID_ICON);
            GuiComponent.blit(poseStack, 0, 0, 0, 0, x, y, 12, 12);
        }

        FluidType tempfluid = Minecraft.getInstance().player.getEyeInFluidType();
        //Test Current Fluid ID
        //System.out.println(Minecraft.getInstance().player.getEyeInFluidType());
    });
}
