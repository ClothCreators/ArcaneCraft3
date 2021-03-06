package io.github.clothcreators.arcanecraft.item;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import io.github.clothcreators.arcanecraft.block.ModBlocks;
import io.github.clothcreators.arcanecraft.item.wand.EvokerFangsWandItem;
import io.github.clothcreators.arcanecraft.item.wand.FireWandItem;
import io.github.clothcreators.arcanecraft.item.wand.IceWandItem;
import io.github.clothcreators.arcanecraft.item.wand.LifeDrainWandItem;
import io.github.clothcreators.arcanecraft.item.wand.LightningWandItem;
import io.github.clothcreators.arcanecraft.item.wand.NoSpellWandItem;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

@SuppressWarnings("unused")
public class ModItems {
	private ModItems() {
	}

	private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(id("item_group")).icon(() -> new ItemStack(ModBlocks.CRYSTALS)).build();
	public static final Item RUNIC_STONE = register("runic_stone", ModBlocks.RUNIC_STONE, new FabricItemSettings().group(ITEM_GROUP));
	public static final Item CRYSTAL_ORE = register("crystal_ore", ModBlocks.CRYSTAL_ORE, new FabricItemSettings().group(ITEM_GROUP));
	public static final Item CRYSTAL_DUST = register("crystal_dust", new Item(new FabricItemSettings().group(ITEM_GROUP)));
	public static final Item CRYSTALS = register("crystals", ModBlocks.CRYSTALS, new FabricItemSettings().group(ITEM_GROUP));
	public static final Item CRYSTAL = register("crystal", new CrystalItem(new FabricItemSettings().group(ITEM_GROUP)));
	public static final Item RUNIC_PILLAR = register("runic_pillar", ModBlocks.RUNIC_PILLAR, new FabricItemSettings().group(ITEM_GROUP));
	public static final Item RUNIC_STONE_SLAB = register("runic_stone_slab", ModBlocks.RUNIC_STONE_SLAB, new FabricItemSettings().group(ITEM_GROUP));
	public static final Item RUNIC_STONE_STAIRS = register("runic_stone_stairs", ModBlocks.RUNIC_STONE_STAIRS, new FabricItemSettings().group(ITEM_GROUP));
	public static final Item RUNIC_STONE_WALL = register("runic_stone_wall", ModBlocks.RUNIC_STONE_WALL, new FabricItemSettings().group(ITEM_GROUP));
	public static final Item SOUL_ITEM = register("soul", new SoulItem(new FabricItemSettings().group(ITEM_GROUP)));
	public static final Item WAND = register("wand", new NoSpellWandItem(new FabricItemSettings().group(ITEM_GROUP).maxCount(1)));
	public static final Item ICE_WAND = register("wand_ice", new IceWandItem(new FabricItemSettings().group(ITEM_GROUP).maxDamage(421)));
	public static final Item FIRE_WAND = register("wand_fire", new FireWandItem(new FabricItemSettings().group(ITEM_GROUP).maxDamage(421)));
	public static final Item LIGHTNING_WAND = register("wand_lightning", new LightningWandItem(new FabricItemSettings().group(ITEM_GROUP).maxDamage(421)));
	public static final Item EVOKER_FANGS_WAND = register("wand_evoker", new EvokerFangsWandItem(new FabricItemSettings().group(ITEM_GROUP).maxDamage(421)));
	public static final Item LIFE_DRAIN_WAND = register("wand_life_drain", new LifeDrainWandItem(new FabricItemSettings().group(ITEM_GROUP).maxDamage(421)));

	private static Item register(String name, Block block, Item.Settings settings) {
		return Registry.register(Registry.ITEM, id(name), new BlockItem(block, settings));
	}

	private static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, id(name), item);
	}

	public static void init() {
		// just loads the class
	}
}
