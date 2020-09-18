package mmu.minecraft.mj.listener;

import org.bukkit.plugin.java.JavaPlugin;

public enum MythListener {
  
  COMBAT(new CombatListener()),
  CRAFT(new CraftListener())

  ;

  public static void register(JavaPlugin plugin) {
    for (final MythListener listener : MythListener.values()) {
      listener.getDefinition().register(plugin);
    }
  }

  private MythListenerDefinition definition;

  private MythListener(MythListenerDefinition definition) {
    this.definition = definition;
  }

  public MythListenerDefinition getDefinition() {
    return this.definition;
  }

}
