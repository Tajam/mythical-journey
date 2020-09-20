package mmu.minecraft.mj.recipe;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import mmu.minecraft.mj.item.MythItem;

public class RecipeMaterial {
  
  private final Material material;
  private final MythItem mythItem;
  private final boolean isBase;

  public RecipeMaterial(Material material) {
    this(material, null, true);
  }

  public RecipeMaterial(MythItem mythItem) {
    this(mythItem.getMaterial(), mythItem, false);
  }

  public RecipeMaterial(ItemStack item) {
    final MythItem mythItem = MythItem.getItemByItemStack(item);
    if (mythItem == null) {
      this.material = item.getType();
      this.mythItem = null;
      this.isBase = true;
      return;
    }
    this.material = mythItem.getMaterial();
    this.mythItem = mythItem;
    this.isBase = false;
  }

  private RecipeMaterial(Material material, MythItem mythItem, boolean isBase) {
    this.material = material;
    this.mythItem = mythItem;
    this.isBase = isBase;
  }

  public Material getMaterial() {
    return this.material;
  }

  public MythItem getMythItem() {
    return this.mythItem;
  }

  public boolean isBase() {
    return this.isBase;
  }

  @Override
  public int hashCode() {
    return (isBase) ? this.material.hashCode() : this.mythItem.hashCode();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null) return false;
    if (!(object instanceof RecipeMaterial)) return false;
    RecipeMaterial other = (RecipeMaterial) object;
    if (isBase != other.isBase) return false;
    if (isBase) {
      return (this.material == other.material);
    } else {
      return (this.mythItem == other.mythItem);
    }
  }

}
