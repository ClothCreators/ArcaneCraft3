package io.github.clothcreators.arcanecraft.entity.effect;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {
	private ModStatusEffects() {
	}

	public static final StatusEffect SOUL_TRAPPER = register("soul_trapper", new SoulTrapperEffect(StatusEffectType.BENEFICIAL, 0xFF485D5D));

	private static StatusEffect register(String name, StatusEffect effect) {
		return Registry.register(Registry.STATUS_EFFECT, id(name), effect);
	}

	public static void init() {
		// just loads the class
	}
}
