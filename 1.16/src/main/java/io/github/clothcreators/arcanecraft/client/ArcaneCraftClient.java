package io.github.clothcreators.arcanecraft.client;

import io.github.clothcreators.arcanecraft.block.ModBlocks;

import net.minecraft.client.render.RenderLayer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

public class ArcaneCraftClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRYSTALS, RenderLayer.getTranslucent());
	}
}
