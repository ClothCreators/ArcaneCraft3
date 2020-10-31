package io.github.clothcreators.arcanecraft;

import io.github.clothcreators.arcanecraft.block.ModBlocks;
import io.github.clothcreators.arcanecraft.entity.effect.ModStatusEffects;
import io.github.clothcreators.arcanecraft.item.ModItems;

import net.minecraft.util.Identifier;

import net.fabricmc.api.ModInitializer;

public class ArcaneCraft3 implements ModInitializer {
	public static final String MOD_ID = "arcanecraft3";

	@Override
	public void onInitialize() {
		ModBlocks.init();
		ModItems.init();
		ModStatusEffects.init();
	}

	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}
}
