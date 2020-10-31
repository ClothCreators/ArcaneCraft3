package io.github.clothcreators.arcanecraft;

import net.minecraft.util.Identifier;

import net.fabricmc.api.ModInitializer;

public class ArcaneCraft3 implements ModInitializer {
	public static final String MOD_ID = "arcanecraft3";

	@Override
	public void onInitialize() {

	}

	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}
}
