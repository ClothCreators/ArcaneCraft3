package io.github.clothcreators.arcanecraft.item.wand;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public abstract class AbstractWandItem extends Item {
	public AbstractWandItem(Settings settings) {
		super(settings);
	}

	protected static void grantAdvancement(ServerPlayerEntity entity) {
		Advancement advancement = entity.server.getAdvancementLoader().get(new Identifier("arcanecraft3:woo_magic"));
		AdvancementProgress progress = entity.getAdvancementTracker().getProgress(advancement);
		if (!progress.isDone()) {
			entity.getAdvancementTracker().grantCriterion(advancement, "impossible");
		}
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		user.setCurrentHand(hand);
		return TypedActionResult.success(user.getStackInHand(hand));
	}
}
