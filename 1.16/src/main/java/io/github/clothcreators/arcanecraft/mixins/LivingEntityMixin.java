package io.github.clothcreators.arcanecraft.mixins;

import io.github.clothcreators.arcanecraft.entity.effect.ModStatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
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
			this.setOnFireFor(15);
		}
	}
}
