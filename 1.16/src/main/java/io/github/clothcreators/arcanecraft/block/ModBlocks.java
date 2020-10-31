package io.github.clothcreators.arcanecraft.block;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

public class ModBlocks {
	private ModBlocks() {
	}

	public static final Block RUNIC_STONE = register("runic_stone", new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(1.1F, 17.5F).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 0)));

	private static Block register(String name, Block block) {
		return Registry.register(Registry.BLOCK, id(name), block);
	}
}
