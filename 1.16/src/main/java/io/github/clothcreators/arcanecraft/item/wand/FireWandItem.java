package io.github.clothcreators.arcanecraft.item.wand;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import io.github.clothcreators.arcanecraft.entity.FireSplashEntity;
import io.github.clothcreators.arcanecraft.entity.ItemProjectileEntity;
import io.github.clothcreators.arcanecraft.entity.ModEntityTypes;
import io.github.clothcreators.arcanecraft.entity.ProjectileUtilities;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class FireWandItem extends AbstractWandItem {
	public FireWandItem(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);
		tooltip.add(new TranslatableText("tooltip.arcanecraft3.fire_wand").formatted(Formatting.GOLD));
	}

	@Override
	public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
		if (!world.isClient() && user instanceof ServerPlayerEntity) {
			ServerPlayerEntity entity = (ServerPlayerEntity) user;
			ItemProjectileEntity arrow = ProjectileUtilities.shoot(ItemStack.EMPTY, world, entity, ThreadLocalRandom.current(), 0.7F, 2, 0, (hitEntity) -> {
				hitEntity.setOnFireFor(15);
			}, SoundEvents.ENTITY_EVOKER_CAST_SPELL, (arrow1) -> {
				if (!arrow1.world.isClient()) {
					Entity entityToSpawn = new FireSplashEntity(ModEntityTypes.FIRE_SPLASH, arrow1.world);
					entityToSpawn.refreshPositionAndAngles(arrow1.getX(), arrow1.getY(), arrow1.getZ(), world.random.nextFloat() * 360F, 0);
					world.spawnEntity(entityToSpawn);
				}
			}, (pos, world1) -> {
				if (world.getBlockState(pos).isOf(Blocks.CAMPFIRE)) {
					world.setBlockState(pos, Blocks.CAMPFIRE.getDefaultState());
				}
			});
			stack.damage(1, entity, e -> e.sendToolBreakStatus(entity.getActiveHand()));
			arrow.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
			entity.stopUsingItem();
			grantAdvancement(entity);
		}
		super.usageTick(world, user, stack, remainingUseTicks);
	}
}
