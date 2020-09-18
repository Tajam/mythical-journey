package mmu.minecraft.mj.item.material;

import org.bukkit.inventory.ItemStack;

import mmu.minecraft.mj.item.MythItemDefinition;

/**
 * Base class for common Myth materials that does not have any special
 * functionality.
 */
public abstract class MythMaterial implements MythItemDefinition {
  
  @Override
  public String getGroupType() {
    return "material";
  }

  @Override
  public ItemStack toItemStackExt(ItemStack item) {
    return item;
  }

}
