package io.github.clothcreators.arcanecraft.world.feature;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import io.github.clothcreators.arcanecraft.block.ModBlocks;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

@SuppressWarnings("deprecation")
public class ModFeatures {
	public static final ConfiguredFeature<?, ?> CRYSTAL_ORE = register("crystal_ore", Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.CRYSTAL_ORE.getDefaultState(), 8)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 50)))).spreadHorizontally().repeat(12);
	public static final RegistryKey<ConfiguredFeature<?, ?>> CRYSTAL_ORE_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, id("crystal_ore"));

	private static ConfiguredFeature<?, ?> register(String name, ConfiguredFeature<?, ?> feature) {
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id(name), feature);
	}

	public static void init() {
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, CRYSTAL_ORE_KEY);
	}
}
