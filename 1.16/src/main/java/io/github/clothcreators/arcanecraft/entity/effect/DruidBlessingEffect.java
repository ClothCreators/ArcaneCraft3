package io.github.clothcreators.arcanecraft.entity.effect;

import java.util.concurrent.ThreadLocalRandom;

import io.github.clothcreators.arcanecraft.ArcaneCraft3;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

public class DruidBlessingEffect extends StatusEffect {
	public DruidBlessingEffect(StatusEffectType type, int color) {
		super(type, color);
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public String getTranslationKey() {
		return ArcaneCraft3.MOD_ID + "statuseffect.druid_blessing";
	}

	@Override
	public boolean isBeneficial() {
		return true;
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}

	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (ThreadLocalRandom.current().nextDouble() < 0.1) {
			BoneMealItem.useOnFertilizable(new ItemStack(Items.BONE_MEAL), entity.world, new BlockPos(entity.getX(), entity.getY() - 1, entity.getZ()));
			BoneMealItem.useOnGround(new ItemStack(Items.BONE_MEAL), entity.world, new BlockPos(entity.getX(), entity.getY() - 1, entity.getZ()), null);
		}
	}
}
