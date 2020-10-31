package io.github.clothcreators.arcanecraft.item.wand;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import io.github.clothcreators.arcanecraft.entity.ItemProjectileEntity;
import io.github.clothcreators.arcanecraft.entity.ProjectileUtilities;
import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class IceWandItem extends AbstractWandItem {
	public IceWandItem(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);
		tooltip.add(new TranslatableText("tooltip.arcanecraft3.ice_wand").formatted(Formatting.AQUA));
	}

	@Override
	public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
		if (!world.isClient() && user instanceof ServerPlayerEntity) {
			ServerPlayerEntity entity = (ServerPlayerEntity) user;
			ItemProjectileEntity arrow = ProjectileUtilities.shoot(ItemStack.EMPTY, world, entity, ThreadLocalRandom.current(), 0.7F, 2, 0, (hitEntity) -> hitEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 190, 2)), SoundEvents.ENTITY_EVOKER_CAST_SPELL);
			stack.damage(1, entity, e -> e.sendToolBreakStatus(entity.getActiveHand()));
			arrow.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
			entity.stopUsingItem();
		}
		super.usageTick(world, user, stack, remainingUseTicks);
	}
}
