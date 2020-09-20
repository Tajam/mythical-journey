package mmu.minecraft.mj.item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import mmu.minecraft.mj.MythNamespace;
import mmu.minecraft.mj.item.material.*;
// import mmu.minecraft.mj.item.weapon.*;
// import mmu.minecraft.mj.item.consumable.*;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public enum MythItem {

  /*=============*\
  |* Consumables *|
  \*=============*/

  

  /*========*\
  |* Weapon *|
  \*========*/



  /*==========*\
  |* Material *|
  \*==========*/

  CRYSTAL_SHARD_OF_OVERWORLD(new CrystalShardOfOverworld(), Material.STICK, 1),
  CRYSTAL_SHARD_OF_NETHER(new CrystalShardOfNether(), Material.STICK, 2),
  CRYSTAL_SHARD_OF_AETHER(new CrystalShardOfAether(), Material.STICK, 3),
  CRYSTAL_SHARD_OF_VOID(new CrystalShardOfVoid(), Material.STICK, 4),

  CRYSTAL_OF_OVERWORLD(new CrystalOfOverworld(), Material.STICK, 11),
  CRYSTAL_OF_NETHER(new CrystalOfNether(), Material.STICK, 12),
  CRYSTAL_OF_AETHER(new CrystalOfAether(), Material.STICK, 13),
  CRYSTAL_OF_VOID(new CrystalOfVoid(), Material.STICK, 14),

  ;

  private static Map<String, MythItem> mythMaterialMap;

  private static void registerItem(MythItem mythItem) {
    if (mythMaterialMap == null) mythMaterialMap = new HashMap<>();
    if (!mythMaterialMap.containsKey(mythItem.toString())) {
      mythMaterialMap.put(mythItem.toString(), mythItem);
      return;
    }
    throw new UnsupportedOperationException("Non unique name registration.");
  }

  public static MythItem getItemById(String id) {
    return mythMaterialMap.get(id);
  }

  private MythItemDefinition definition;
  private Material material;
  private int customModelData;

  private MythItem(MythItemDefinition definition, Material material, int customModelData) {
    this.definition = definition;
    MythItem.registerItem(this);
  }

  public MythItemDefinition getDefinition() {
    return this.definition;
  }

  public Material getMaterial() {
    return this.material;
  }

  public int getCustomModelData() {
    return this.customModelData;
  }

  public ItemStack toItemStack() {
    final ItemStack item = new ItemStack(getMaterial());
    final ItemMeta meta = item.getItemMeta();
    meta.setCustomModelData(getCustomModelData());
    meta.setDisplayName(getDefinition().getRarity().applyFormat(getDefinition().getDisplayName()));
    meta.setLore(Arrays.asList(new String[] {
      ChatColor.ITALIC + getDefinition().getRarity().getName() + ChatColor.RESET,
      ChatColor.GRAY + getDefinition().getDescription() + ChatColor.RESET,
      ChatColor.DARK_GRAY + getDefinition().getLore() + ChatColor.RESET
    }));
    final PersistentDataContainer container = meta.getPersistentDataContainer();
    container.set(MythNamespace.MYTH_ITEM.get(), PersistentDataType.STRING, getMaterial().toString());
    container.set(MythNamespace.MYTH_GROUP_TYPE.get(), PersistentDataType.STRING, getDefinition().getGroupType());
    item.setItemMeta(meta);
    return getDefinition().toItemStackExt(item);
  }

  @Override
  public String toString() {
    return super.name().toLowerCase();
  }

}
