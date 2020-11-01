package io.github.clothcreators.arcanecraft.mixins;

import io.github.clothcreators.arcanecraft.entity.effect.ModStatusEffects;
import io.github.clothcreators.arcanecraft.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(at = @At("HEAD"), method = "damage")
	public void interceptDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		Entity attacker = source.getAttacker();
		if (attacker instanceof LivingEntity && ((LivingEntity) attacker).hasStatusEffect(ModStatusEffects.CHARRED_STRIKE)) {
			this.setOnFireFor(3);
		}
	}

	@Inject(at = @At("HEAD"), method = "onDeath")
	public void interceptOnDeath(DamageSource source, CallbackInfo ci) {
		Entity attacker = source.getAttacker();
		if (attacker instanceof LivingEntity && ((LivingEntity) attacker).hasStatusEffect(ModStatusEffects.SOUL_TRAPPER) && !this.world.isClient) {
			ItemEntity entityToSpawn = new ItemEntity(this.world, this.getX(), this.getY(), this.getZ(), new ItemStack(ModItems.SOUL_ITEM, 1));
			entityToSpawn.setPickupDelay(10);
			this.world.spawnEntity(entityToSpawn);
		}
	}
}
