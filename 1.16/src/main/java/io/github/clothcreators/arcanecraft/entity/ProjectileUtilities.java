package io.github.clothcreators.arcanecraft.entity;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ProjectileUtilities {
	private ProjectileUtilities() {
	}

	public static ItemProjectileEntity shoot(ItemStack stack, World world, LivingEntity entity, Random random, float power, double damage, int knockback, Consumer<LivingEntity> hitConsumer, SoundEvent sound, Consumer<ItemProjectileEntity> tickConsumer, BiConsumer<BlockPos, World> blockConsumer) {
		ItemProjectileEntity arrow = new ItemProjectileEntity(ModEntityTypes.ITEM_PROJECTILE, entity, world, stack);
		arrow.setHitConsumer(hitConsumer);
		arrow.setBlockConsumer(blockConsumer);
		arrow.setVelocity(entity.getRotationVector().x, entity.getRotationVector().y, entity.getRotationVector().z, power * 2, 0);
		arrow.setSilent(true);
		arrow.setCritical(false);
		arrow.setDamage(damage);
		arrow.setPunch(knockback);
		world.spawnEntity(arrow);
		if (sound != null) {
			world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), sound, SoundCategory.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		}
		return arrow;
	}

	public static ItemProjectileEntity shoot(ItemStack stack, LivingEntity entity, LivingEntity target, Consumer<LivingEntity> hitConsumer, SoundEvent sound, Consumer<ItemProjectileEntity> tickConsumer, BiConsumer<BlockPos, World> blockConsumer) {
		ItemProjectileEntity arrow = new ItemProjectileEntity(ModEntityTypes.ITEM_PROJECTILE, entity, entity.world, stack);
		arrow.setHitConsumer(hitConsumer);
		arrow.setBlockConsumer(blockConsumer);
		double x = target.getX() - entity.getX();
		double y = target.getY() + (double) target.getEyeHeight(target.getPose()) - 1.1;
		double z = target.getZ() - entity.getZ();
		arrow.setVelocity(x, y - arrow.getY() + (double) MathHelper.sqrt(x * x + z * z) * 0.2F, z, 1.6F, 12.0F);
		arrow.setSilent(true);
		arrow.setCritical(false);
		entity.world.spawnEntity(arrow);
		if (sound != null) {
			entity.world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), sound, SoundCategory.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
		}
		return arrow;
	}
}
