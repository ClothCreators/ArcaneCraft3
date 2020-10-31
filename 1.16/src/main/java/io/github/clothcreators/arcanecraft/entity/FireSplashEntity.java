package io.github.clothcreators.arcanecraft.entity;

import java.util.Random;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

@SuppressWarnings("EntityConstructor")
public class FireSplashEntity extends PathAwareEntity {
	public static DefaultAttributeContainer.Builder createFireSplashAttributes() {
		DefaultAttributeContainer.Builder builder = new DefaultAttributeContainer.Builder();
		builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
		builder.add(EntityAttributes.GENERIC_MAX_HEALTH, 1);
		builder.add(EntityAttributes.GENERIC_ARMOR, 0);
		builder.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3);
		return builder;
	}

	public FireSplashEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public EntityGroup getGroup() {
		return EntityGroup.DEFAULT;
	}

	@Override
	public boolean canImmediatelyDespawn(double distanceSquared) {
		return false;
	}

	@Override
	protected @Nullable SoundEvent getAmbientSound() {
		return null;
	}

	@Override
	protected @Nullable SoundEvent getDeathSound() {
		return null;
	}

	@Override
	protected @Nullable SoundEvent getHurtSound(DamageSource source) {
		return null;
	}

	@Override
	public boolean isInvulnerableTo(DamageSource damageSource) {
		if (damageSource.getSource() instanceof ArrowEntity) {
			return true;
		} else if (damageSource.getSource() instanceof PlayerEntity) {
			return true;
		} else if (damageSource.getSource() instanceof PotionEntity) {
			return true;
		} else if (damageSource == DamageSource.FALL) {
			return true;
		} else if (damageSource == DamageSource.CACTUS) {
			return true;
		} else if (damageSource == DamageSource.DROWN) {
			return true;
		} else if (damageSource == DamageSource.LIGHTNING_BOLT) {
			return true;
		} else {
			return super.isInvulnerableTo(damageSource);
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		// TODO: implement baseTick procedure
	}

	@Override
	public void tickMovement() {
		super.tickMovement();
		Random random = this.random;
		for (int l = 0; l < 5; ++l) {
			double x = (this.getX() + random.nextFloat());
			double y = (this.getY() + random.nextFloat());
			double z = (this.getZ() + random.nextFloat());
			double velocityX = (random.nextFloat() - 0.5D) * 0.4000000014901161D;
			double velocityY = (random.nextFloat() - 0.5D) * 0.4000000014901161D;
			double velocityZ = (random.nextFloat() - 0.5D) * 0.4000000014901161D;
			this.world.addParticle(ParticleTypes.FLAME, x, y, z, velocityX, velocityY, velocityZ);
		}
	}
}
