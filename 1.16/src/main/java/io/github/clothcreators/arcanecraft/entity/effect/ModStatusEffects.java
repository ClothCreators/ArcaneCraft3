package io.github.clothcreators.arcanecraft.entity.effect;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {
	private ModStatusEffects() {
	}

	public static final StatusEffect SOUL_TRAPPER = register("soul_trapper", new SoulTrapperEffect(StatusEffectType.BENEFICIAL, 0xFF48_5D5D));
	public static final StatusEffect CHARRED_STRIKE = register("charred_strike", new SoulTrapperEffect(StatusEffectType.BENEFICIAL, 0xFFD0_521D));
	public static final StatusEffect DRUID_BLESSING = register("druid_blessing", new SoulTrapperEffect(StatusEffectType.BENEFICIAL, 0xFFD0_521D));

	private static StatusEffect register(String name, StatusEffect effect) {
		return Registry.register(Registry.STATUS_EFFECT, id(name), effect);
	}

	public static void init() {
		// just loads the class
	}
}
