package io.github.clothcreators.arcanecraft.networking;

import static io.github.clothcreators.arcanecraft.ArcaneCraft3.id;

import java.util.UUID;

import io.github.clothcreators.arcanecraft.entity.NetworkSynced;
import io.netty.buffer.Unpooled;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.PacketContext;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;

public class EntityPacketUtils {
	public static final Identifier ID;

	private EntityPacketUtils() {
	}

	public static Packet<?> createPacket(Entity entity) {
		PacketByteBuf buf = createBuf();
		buf.writeVarInt(Registry.ENTITY_TYPE.getRawId(entity.getType()));
		buf.writeUuid(entity.getUuid());
		buf.writeVarInt(entity.getEntityId());
		buf.writeDouble(entity.getX());
		buf.writeDouble(entity.getY());
		buf.writeDouble(entity.getZ());
		buf.writeByte(MathHelper.floor(entity.pitch * 256.0F / 360.0F));
		buf.writeByte(MathHelper.floor(entity.yaw * 256.0F / 360.0F));
		buf.writeFloat(entity.pitch);
		buf.writeFloat(entity.yaw);
		buf.writeDouble(entity.getVelocity().x);
		buf.writeDouble(entity.getVelocity().y);
		buf.writeDouble(entity.getVelocity().z);
		buf.writeCompoundTag(entity instanceof NetworkSynced ? ((NetworkSynced) entity).getSyncedTag() : new CompoundTag());
		return ServerSidePacketRegistry.INSTANCE.toPacket(ID, buf);
	}

	@Environment(EnvType.CLIENT)
	public static void onPacket(PacketContext ctx, PacketByteBuf byteBuf) {
		EntityType<?> type = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
		UUID entityUUID = byteBuf.readUuid();
		int entityID = byteBuf.readVarInt();
		double x = byteBuf.readDouble();
		double y = byteBuf.readDouble();
		double z = byteBuf.readDouble();
		float pitch = (float)(byteBuf.readByte() * 360) / 256.0F;
		float yaw = (float)(byteBuf.readByte() * 360) / 256.0F;
		double vX = byteBuf.readDouble();
		double vY = byteBuf.readDouble();
		double vZ = byteBuf.readDouble();
		CompoundTag syncedTag = byteBuf.readCompoundTag();
		ctx.getTaskQueue().execute(() -> {
			ClientWorld world = MinecraftClient.getInstance().world;
			Entity entity = type.create(world);
			if (entity != null && world != null) {
				entity.updatePosition(x, y, z);
				entity.updateTrackedPosition(x, y, z);
				entity.pitch = pitch;
				entity.yaw = yaw;
				entity.setVelocity(vX, vY, vZ);
				entity.setEntityId(entityID);
				entity.setUuid(entityUUID);
				if (entity instanceof NetworkSynced) {
					((NetworkSynced) entity).apply(syncedTag);
				}
				world.addEntity(entityID, entity);
			}

		});
	}

	private static PacketByteBuf createBuf() {
		return new PacketByteBuf(Unpooled.buffer());
	}

	static {
		ID = id("spawn_entity");
	}
}
