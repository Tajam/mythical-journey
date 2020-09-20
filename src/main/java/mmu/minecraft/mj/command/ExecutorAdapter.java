package mmu.minecraft.mj.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import mmu.minecraft.mj.Log;

public class ExecutorAdapter implements CommandExecutor, TabCompleter {

  private final List<Parameter> parameters;

  ExecutorAdapter() {
    this.parameters = new ArrayList<>();
  }

  void addParameter(Parameter parameter) throws IllegalArgumentException {
    if (parameters.size() > 0) {
      final Parameter lastParameter = parameters.get(parameters.size() - 1);
      if (!lastParameter.isRequired() && parameter.isRequired()) {
        throw new IllegalArgumentException("Required parameter cannot come after optional parameter!");
      }
    }
    parameters.add(parameter);
  }

  void register(String name, JavaPlugin plugin) {
    final PluginCommand command = plugin.getCommand(name);
    command.setExecutor(this);
    command.setTabCompleter(this);
    Log usageSMS = new Log("Usage").info().t("/").a(name);
    for (Parameter parameter : parameters) {
      usageSMS.rst(" ").rst(parameter.toString());
    }
    command.setUsage(usageSMS.text());
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
    try {
      final int index = args.length - 1;
      final Parameter parameter = parameters.get(index);
      return parameter.onComplete(args[index], sender);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!command.testPermissionSilent(sender)) {
      new Log().eror().t("You do not have permission to use this command.").send(sender);
      return true;
    }
    if (args.length > parameters.size()) return false;
    if (args.length < parameters.size()) {
      if (args.length <= 0 || parameters.get(args.length - 1).isRequired()) {
        if (parameters.get(args.length).isRequired()) return false;
      }
    }
    return (sender instanceof Player) ? executePlayer((Player)sender, args) : executeCommand(sender, args);
  }

  public boolean executePlayer(Player sender, String[] args) {
    new Log().info().t("This command is only for ").t().t(".").send(sender, "console");
    return true;
  }

  public boolean executeCommand(CommandSender sender, String[] args) {
    new Log().info().t("This command is only for ").t().t(".").send(sender, "players");
    return true;
  }
  
}
