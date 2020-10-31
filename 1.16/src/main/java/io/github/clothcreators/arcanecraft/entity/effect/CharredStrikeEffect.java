package io.github.clothcreators.arcanecraft.entity.effect;

import io.github.clothcreators.arcanecraft.ArcaneCraft3;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class CharredStrikeEffect extends StatusEffect {
	public CharredStrikeEffect(StatusEffectType type, int color) {
		super(type, color);
	}

	@Override
	public String getTranslationKey() {
		return ArcaneCraft3.MOD_ID + "statuseffect.charred_strike";
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean isBeneficial() {
		return true;
	}
}
