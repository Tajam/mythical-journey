package mmu.minecraft.mj.item.material;

import mmu.minecraft.mj.item.Rarity;

public class CrystalShardOfNether extends MythMaterial {

  @Override
  public String getDescription() {
    return "A small fragment of Nether crystal.";
  }

  @Override
  public String getDisplayName() {
    return "Crystal Shard of Nether";
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
