package io.github.clothcreators.arcanecraft.entity;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.EnvironmentInterface;
import net.fabricmc.api.EnvironmentInterfaces;

@EnvironmentInterfaces({@EnvironmentInterface(
		value = EnvType.CLIENT,
		itf = FlyingItemEntity.class
)})
@SuppressWarnings("EntityConstructor")
public class ItemProjectileEntity extends PersistentProjectileEntity implements FlyingItemEntity, NetworkSynced {
	private ItemStack stack;
	private Consumer<LivingEntity> hitConsumer = entity -> {};
	private Consumer<ItemProjectileEntity>  tickConsumer = entity -> {};
	private BiConsumer<BlockPos, World> blockConsumer;

	protected ItemProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
		super(entityType, world);
		this.stack = new ItemStack(Blocks.AIR);
	}

	protected ItemProjectileEntity(EntityType<? extends PersistentProjectileEntity> type, double x, double y, double z, World world) {
		super(type, x, y, z, world);
		this.stack = ItemStack.EMPTY;
	}

	public ItemProjectileEntity(EntityType<ItemProjectileEntity> type, LivingEntity entity, World world, ItemStack stack) {
		super(type, entity, world);
		this.stack = stack;
	}

	@Override
	public ItemStack getStack() {
		return this.stack;
	}

	@Override
	protected ItemStack asItemStack() {
		return this.stack;
	}

	public void setTickConsumer(Consumer<ItemProjectileEntity> tickConsumer) {
		this.tickConsumer = tickConsumer;
	}

	public void setBlockConsumer(BiConsumer<BlockPos, World> blockConsumer) {
		this.blockConsumer = blockConsumer;
	}

	@Override
	public void apply(CompoundTag syncedTag) {
		this.stack = ItemStack.fromTag(syncedTag.getCompound("stack"));
	}

	@Override
	protected void onHit(LivingEntity target) {
		super.onHit(target);
		this.hitConsumer.accept(target);
		if (this.blockConsumer != null && this.inGround) {
			this.blockConsumer.accept(new BlockPos(this.getX(), this.getY(), this.getZ()), this.world);
			this.remove();
		}
	}

	@Override
	public void tick() {
		this.tickConsumer.accept(this);
	}

	@Override
	public CompoundTag getSyncedTag() {
		CompoundTag tag = new CompoundTag();
		tag.put("stack", this.stack.toTag(new CompoundTag()));
		return tag;
	}

	public void setHitConsumer(Consumer<LivingEntity> hitConsumer) {
		this.hitConsumer = hitConsumer;
	}
}
