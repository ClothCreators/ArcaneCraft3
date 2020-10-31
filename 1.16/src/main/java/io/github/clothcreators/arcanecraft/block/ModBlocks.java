package io.github.clothcreators.arcanecraft.block;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

public class ModBlocks {
	private ModBlocks() {
	}

	public static final Block RUNIC_STONE = register("runic_stone", new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(1.1F, 17.5F).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 0)));
	public static final Block CRYSTAL_ORE = register("crystal_ore", new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.METAL).strength(2.0F, 17.5F).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2)));
	public static final Block RUNIC_STONE_STAIRS = register("runic_stone_stairs", new StairsBlock(RUNIC_STONE.getDefaultState(), FabricBlockSettings.copyOf(RUNIC_STONE)));
	public static final Block RUNIC_STONE_SLAB = register("runic_stone_slab", new SlabBlock(FabricBlockSettings.copyOf(RUNIC_STONE)));
	public static final Block RUNIC_STONE_WALL = register("runic_stone_wall", new WallBlock(FabricBlockSettings.copyOf(RUNIC_STONE)));
	public static final Block RUNIC_PILLAR = register("runic_pillar", new RunicPillarBlock(FabricBlockSettings.copyOf(RUNIC_STONE)));
	public static final Block CRYSTALS = register("crystals", new CrystalsBlock(FabricBlockSettings.of(Material.STONE).strength(0.15F, 10F).nonOpaque()));

	private static Block register(String name, Block block) {
		return Registry.register(Registry.BLOCK, id(name), block);
	}

	public static void init() {
		// just loads the class
	}

	private static class StairsBlock extends net.minecraft.block.StairsBlock {
		private StairsBlock(BlockState baseBlockState, Settings settings) {
			super(baseBlockState, settings);
		}
	}
}
