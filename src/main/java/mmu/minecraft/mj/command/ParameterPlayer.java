package mmu.minecraft.mj.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParameterPlayer extends Parameter {
  
  public ParameterPlayer(boolean required) {
    super(required);
  }

  @Override
  public String getName() {
    return "player";
  }

  @Override
  public List<String> onComplete(String parameter, CommandSender sender) {
    final List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
    final Set<String> selectors = PlayerSelector.getSelectorStrings();
    final List<String> matches = new ArrayList<>();
    for (String selector : selectors) {
      if (matches.size() >= 12) break;
      if (selector.startsWith(parameter.toLowerCase())) {
        matches.add(selector);
      }
    }
    for (Player player : players) {
      if (matches.size() >= 12) break;
      final String name = player.getName();
      if (name.toLowerCase().startsWith(parameter.toLowerCase())) {
        matches.add(name);
      }
    }
    if (matches.size() > 0) return matches;
    return null;
  }

}
