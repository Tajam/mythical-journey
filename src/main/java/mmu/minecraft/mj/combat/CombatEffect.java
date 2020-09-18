package mmu.minecraft.mj.combat;

import org.bukkit.entity.LivingEntity;

public interface CombatEffect {

  public void apply(final LivingEntity entity);

  public String getDescription();

}
