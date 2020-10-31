package io.github.clothcreators.arcanecraft.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class DruidBlessingEffect extends StatusEffect {
	public DruidBlessingEffect(StatusEffectType type, int color) {
		super(type, color);
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public boolean isBeneficial() {
		return true;
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
