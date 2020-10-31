package io.github.clothcreators.arcanecraft.client;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import io.github.clothcreators.arcanecraft.block.ModBlocks;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;

public class ArcaneCraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRYSTALS, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUNIC_PILLAR, RenderLayer.getCutout());
		ClientSpriteRegistryCallback.event(new Identifier("textures/atlas/mob_effects.png")).register((spriteAtlasTexture, registry) -> {
			registry.register(id("textures/mob_effect/druid_blessing.png"));
			registry.register(id("textures/mob_effect/charred_strike.png"));
			registry.register(id("textures/mob_effect/soul_trapper.png"));
		});
	}
}
