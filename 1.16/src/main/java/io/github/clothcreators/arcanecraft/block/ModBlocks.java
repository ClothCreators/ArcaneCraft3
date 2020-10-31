package io.github.clothcreators.arcanecraft.block;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	private ModBlocks() {
	}

	private static Block register(String name, Block block) {
		return Registry.register(Registry.BLOCK, id(name), block);
	}
}
