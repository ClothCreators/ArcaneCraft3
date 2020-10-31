package io.github.clothcreators.arcanecraft.item.wand;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class NoSpellWandItem extends AbstractWandItem {
	public NoSpellWandItem(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);
		tooltip.add(new TranslatableText("tooltip.arcanecraft3.no_spell").formatted(Formatting.DARK_GRAY));
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(stack, world, entity, slot, selected);
		if (!stack.getOrCreateTag().contains("Slots")) {
			CompoundTag slots = new CompoundTag();
			slots.putString("Slot1", "[No Spell]");
			slots.putString("Slot2", "[No Spell]");
			slots.putString("Slot3", "[No Spell]");
			slots.putString("Slot4", "[No Spell]");
			stack.getOrCreateTag().put("Slots", slots);
		}
	}
}
