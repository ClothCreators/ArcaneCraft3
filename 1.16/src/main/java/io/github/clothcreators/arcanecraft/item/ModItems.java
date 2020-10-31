package io.github.clothcreators.arcanecraft.item;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class ModItems {
	private ModItems() {
	}

	private static Item register(String name, Block block, Item.Settings settings) {
		return Registry.register(Registry.ITEM, id(name), new BlockItem(block, settings));
	}

	private static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, id(name), item);
	}
}
