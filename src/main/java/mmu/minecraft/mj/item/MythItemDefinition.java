package mmu.minecraft.mj.item;

import org.bukkit.inventory.ItemStack;

public interface MythItemDefinition {

  public String getDescription();

  public String getDisplayName();

  public String getGroupType();

  public String getLore();

  public Rarity getRarity();

  public ItemStack toItemStackExt(ItemStack item);

}
