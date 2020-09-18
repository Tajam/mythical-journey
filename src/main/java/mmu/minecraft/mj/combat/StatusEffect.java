package mmu.minecraft.mj.combat;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class StatusEffect implements CombatEffect {

  private PotionEffectType type;
  private int amplifier;
  private int duration;

  public StatusEffect(PotionEffectType type, int amplifier, int duration) {
    this.type = type;
    this.amplifier = amplifier;
    this.duration = duration;
  }

  @Override
  public void apply(LivingEntity entity) {
    entity.addPotionEffect(new PotionEffect(type, duration, amplifier));
  }

  @Override
  public String getDescription() {
    return String.format("Applies level %d of %s with the duration of %.2f second(s) to the target.", this.amplifier, this.type.getName(), this.duration / 20);
  }
  
}
