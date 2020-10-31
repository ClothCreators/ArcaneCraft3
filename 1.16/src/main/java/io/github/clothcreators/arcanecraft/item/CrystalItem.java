package io.github.clothcreators.arcanecraft.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CrystalItem extends Item {
	public CrystalItem(Settings settings) {
		super(settings);
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 0;
	}

	// TODO: implement use procedure
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		return super.use(world, user, hand);
	}
}
