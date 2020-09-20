package mmu.minecraft.mj.recipe;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import mmu.minecraft.mj.MythNamespace;
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
    final PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
    if (container.has(MythNamespace.MYTH_ITEM.get(), PersistentDataType.STRING)) {
      final MythItem mythItem = MythItem.getItemById(
        container.get(MythNamespace.MYTH_ITEM.get(), PersistentDataType.STRING)
      );
      this.material = mythItem.getMaterial();
      this.mythItem = mythItem;
      this.isBase = false;
      return;
    }
    this.material = item.getType();
    this.mythItem = null;
    this.isBase = true;
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
    if (getClass() != object.getClass()) return false;
    RecipeMaterial other = (RecipeMaterial) object;
    if (isBase != other.isBase) return false;
    if (isBase) {
      return (this.material == other.material);
    } else {
      return (this.mythItem == other.mythItem);
    }
  }

}
