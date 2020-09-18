package mmu.minecraft.mj.item.material;

import mmu.minecraft.mj.item.Rarity;

public class CrystalOfAether extends MythMaterial {

  @Override
  public String getDescription() {
    return "A crystal filled with power of Aether.";
  }

  @Override
  public String getDisplayName() {
    return "Crystal of Aether";
  }

  @Override
  public String getLore() {
    return null;
  }

  @Override
  public Rarity getRarity() {
    return Rarity.FINE;
  }
  
}
