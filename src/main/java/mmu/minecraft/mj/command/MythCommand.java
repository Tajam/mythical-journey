package mmu.minecraft.mj.command;

import org.bukkit.plugin.java.JavaPlugin;

public enum MythCommand {
  
  MGIVE(new ExecutorGiveItem()),
  MSPAWN(new ExecutorSpawnMonster())

  ;

  public static void register(JavaPlugin plugin) {
    for (MythCommand mythCommand : MythCommand.values()) {
      mythCommand.executorAdapter.register(mythCommand.toString(), plugin);
    }
  }

  private ExecutorAdapter executorAdapter;

  private MythCommand(ExecutorAdapter executorAdapter) {
    this.executorAdapter = executorAdapter;
  }

  @Override
  public String toString() {
    return super.name().toLowerCase();
  }

}
