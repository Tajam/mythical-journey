package mmu.minecraft.mj.item.weapon;

import java.util.List;

import mmu.minecraft.mj.combat.CombatEffect;
import mmu.minecraft.mj.combat.Nature;
import mmu.minecraft.mj.item.MythItemDefinition;

public abstract class MythWeapon implements MythItemDefinition {
  
  public abstract int getDamage();

  public abstract Nature getNature();

  public abstract List<CombatEffect> getEffects();

}
