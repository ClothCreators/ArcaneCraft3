package io.github.clothcreators.arcanecraft.entity;

import net.minecraft.nbt.CompoundTag;

public interface NetworkSynced {
	void apply(CompoundTag syncedTag);

	CompoundTag getSyncedTag();
}
