package mmu.minecraft.mj.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;

import mmu.minecraft.mj.item.MythItem;

public class ParameterItem extends Parameter {

  public ParameterItem(boolean required) {
    super(required);
  }

  @Override
  public String getName() {
    return "item";
  }

  @Override
  public List<String> onComplete(String parameter, CommandSender sender) {
    final List<String> matches = new ArrayList<>();
    for (final MythItem mythItem : MythItem.values()) {
      if (matches.size() >= 8) break;
      if (mythItem.toString().startsWith(parameter.toLowerCase())) {
        matches.add(mythItem.toString());
      }
    }
    if (matches.size() > 0) return matches;
    return null;
  }
  
}
