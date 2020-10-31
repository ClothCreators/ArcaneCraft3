package io.github.clothcreators.arcanecraft.entity.effect;

import io.github.clothcreators.arcanecraft.ArcaneCraft3;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class SoulTrapperEffect extends StatusEffect {
	public SoulTrapperEffect(StatusEffectType type, int color) {
		super(type, color);
	}

	@Override
	public boolean isBeneficial() {
		return true;
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public String getTranslationKey() {
		return ArcaneCraft3.MOD_ID + "statuseffect.soul_trapper";
	}
}
