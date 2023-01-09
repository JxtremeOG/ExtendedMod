package net.jxtremeog.extendedmod.client;

import net.minecraft.client.player.Input;

public class TestInput extends Input {
    public boolean isJumping() {
        return jumping;
    }

    @Override
    public boolean hasForwardImpulse() {
        return super.hasForwardImpulse();
    }
}
