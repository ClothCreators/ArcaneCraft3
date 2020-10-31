package io.github.clothcreators.arcanecraft.entity;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

@SuppressWarnings("SameParameterValue")
public class ModEntityTypes {
	private ModEntityTypes() {
	}

	public static final EntityType<FireSplashEntity> FIRE_SPLASH = register("fire_splash", FabricEntityTypeBuilder.<FireSplashEntity>createLiving().entityFactory(FireSplashEntity::new).trackRangeBlocks(64).trackedUpdateRate(3).fireImmune().dimensions(EntityDimensions.fixed(0, 0)).forceTrackedVelocityUpdates(true).build());
	public static final EntityType<ItemProjectileEntity> ITEM_PROJECTILE = register("item_projectile", FabricEntityTypeBuilder.<ItemProjectileEntity>create().entityFactory(ItemProjectileEntity::new).trackedUpdateRate(1).trackRangeBlocks(64).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).forceTrackedVelocityUpdates(true).build());

	private static <T extends Entity> EntityType<T> register(String name, EntityType<T> entityType) {
		return Registry.register(Registry.ENTITY_TYPE, id(name), entityType);
	}

	public static void init() {
		FabricDefaultAttributeRegistry.register(FIRE_SPLASH, FireSplashEntity.createFireSplashAttributes());
	}
}
