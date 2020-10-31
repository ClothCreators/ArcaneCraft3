package io.github.clothcreators.arcanecraft.client;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import io.github.clothcreators.arcanecraft.block.ModBlocks;
import io.github.clothcreators.arcanecraft.entity.ItemProjectileEntity;
import io.github.clothcreators.arcanecraft.entity.ModEntityTypes;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.util.Identifier;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;

public class ArcaneCraft3Client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRYSTALS, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUNIC_PILLAR, RenderLayer.getCutout());
		ClientSpriteRegistryCallback.event(new Identifier("minecraft:textures/atlas/mob_effects.png")).register((atlasTexture, registry) -> {
			registry.register(id("mob_effect/druid_blessing"));
			registry.register(id("mob_effect/charred_strike"));
			registry.register(id("mob_effect/soul_trapper"));
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.FIRE_SPLASH, FireSplashEntityRenderer::new);
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.ITEM_PROJECTILE, (dispatcher, ctx) -> new FlyingItemEntityRenderer<ItemProjectileEntity>(dispatcher, ctx.getItemRenderer()));
	}
}
