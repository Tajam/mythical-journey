package mmu.minecraft.mj.item.material;

import mmu.minecraft.mj.item.Rarity;

public class CrystalShardOfAether extends MythMaterial {

  @Override
  public String getDescription() {
    return "A small fragment of Aether crystal.";
  }

  @Override
  public String getDisplayName() {
    return "Crystal Shard of Aether";
  }

  @Override
  public String getLore() {
    return null;
  }

  @Override
  public Rarity getRarity() {
    return Rarity.COMMON;
  }

}
