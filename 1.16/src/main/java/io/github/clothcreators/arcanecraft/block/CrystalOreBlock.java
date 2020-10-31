package io.github.clothcreators.arcanecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class CrystalOreBlock extends Block {
	public CrystalOreBlock(Settings settings) {
		super(settings);
	}

	@Override
	public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
		super.onStacksDropped(state, world, pos, stack);
		if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
			this.dropExperience(world, pos, 2);
		}
	}
}
