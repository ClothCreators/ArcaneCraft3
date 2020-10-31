package io.github.clothcreators.arcanecraft.world.feature;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

@SuppressWarnings("deprecation")
public class ModFeatures {
	public static final ConfiguredFeature<?, ?> CRYSTAL_ORE = register("crystal_ore", Feature.ORE.configure(null));
	public static final RegistryKey<ConfiguredFeature<?, ?>> CRYSTAL_ORE_KEY = keyOf(CRYSTAL_ORE);

	private static ConfiguredFeature<?, ?> register(String name, ConfiguredFeature<?, ?> feature) {
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id(name), feature);
	}

	private static RegistryKey<ConfiguredFeature<?, ?>> keyOf(ConfiguredFeature<?, ?> feature) {
		return BuiltinRegistries.CONFIGURED_FEATURE.getKey(feature).orElseThrow(IllegalStateException::new);
	}

	public static void init() {
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, CRYSTAL_ORE_KEY);
	}
}
