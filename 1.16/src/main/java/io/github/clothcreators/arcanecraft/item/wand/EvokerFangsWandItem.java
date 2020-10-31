package io.github.clothcreators.arcanecraft.item.wand;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import io.github.clothcreators.arcanecraft.entity.ItemProjectileEntity;
import io.github.clothcreators.arcanecraft.entity.ProjectileUtilities;
import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class EvokerFangsWandItem extends AbstractWandItem {
	public EvokerFangsWandItem(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);
		tooltip.add(new TranslatableText("tooltip.arcanecraft3.evoker_fangs_wand").formatted(Formatting.DARK_PURPLE));
	}

	@Override
	public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
		if (!world.isClient() && user instanceof ServerPlayerEntity) {
			ServerPlayerEntity entity = (ServerPlayerEntity) user;
			ItemProjectileEntity arrow = ProjectileUtilities.shoot(ItemStack.EMPTY, world, entity, ThreadLocalRandom.current(), 0.7F, 2, 0, (hitEntity) -> {}, SoundEvents.ENTITY_EVOKER_CAST_SPELL, (arrow1) -> {
				if (!arrow1.world.isClient()) {
					Entity entityToSpawn = new EvokerFangsEntity(EntityType.EVOKER_FANGS, world);
					entityToSpawn.refreshPositionAndAngles(arrow1.getX(), (arrow1.getY() - 1), arrow1.getZ(), world.random.nextFloat() * 360F, 0);
					world.spawnEntity(entityToSpawn);
				}
			}, null);
			stack.damage(1, entity, e -> e.sendToolBreakStatus(entity.getActiveHand()));
			arrow.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
			entity.stopUsingItem();
			AbstractWandItem.grantAdvancement(entity);
		}
		super.usageTick(world, user, stack, remainingUseTicks);
	}
}
