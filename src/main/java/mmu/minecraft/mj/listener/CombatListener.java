package mmu.minecraft.mj.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class CombatListener extends MythListenerDefinition {

  // To handle melee attacks from players
  @EventHandler()
  public void playerAttackEvent(final EntityDamageByEntityEvent event) {

  }

  // To handle range attack of bow from players
  @EventHandler()
  public void playerShootEvent(final EntityShootBowEvent event) {

  }

  // To simulate effect when player trying to use a magic wand
  @EventHandler()
  public void playerWandEvent(final PlayerInteractEvent event) {
    
  }
  
}
