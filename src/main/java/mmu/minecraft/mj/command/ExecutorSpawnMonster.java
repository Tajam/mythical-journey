package mmu.minecraft.mj.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mmu.minecraft.mj.Log;

public class ExecutorSpawnMonster extends ExecutorAdapter {
  
  public ExecutorSpawnMonster() { }

  @Override
  public boolean executePlayer(Player sender, String[] args) {
    new Log().warn().t("Not yet implemented!").send(sender, "console");
    return true;
  }

  @Override
  public boolean executeCommand(CommandSender sender, String[] args) {
    new Log().warn().t("Not yet implemented!").send(sender, "console");
    return true;
  }

}
