package io.github.clothcreators.arcanecraft.client;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import io.github.clothcreators.arcanecraft.entity.FireSplashEntity;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.SlimeEntityModel;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@SuppressWarnings("unused")
public class FireSplashEntityRenderer extends MobEntityRenderer<FireSplashEntity, SlimeEntityModel<FireSplashEntity>> {
	public FireSplashEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, EntityRendererRegistry.Context ctx) {
		super(entityRenderDispatcher, new SlimeEntityModel<>(0), 0F);
	}

	@Override
	public Identifier getTexture(FireSplashEntity entity) {
		return id("textures/air.png");
	}
}
