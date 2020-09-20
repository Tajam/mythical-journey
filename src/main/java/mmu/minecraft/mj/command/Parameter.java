package mmu.minecraft.mj.command;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import mmu.minecraft.mj.Log;

public abstract class Parameter {
  
  private final boolean required;

  public Parameter(boolean required) {
    this.required = required;
  }

  public boolean isRequired() {
    return this.required;
  }

  public abstract String getName();

  public abstract List<String> onComplete(String parameter, CommandSender sender);

  @Override
  public String toString() {
    Log sms = new Log().rst(((required)? "[" : "<")).rst().rst(((required)? "]" : ">"));
    return sms.text((required)? ChatColor.LIGHT_PURPLE + getName() : ChatColor.DARK_PURPLE + getName());
  }

}
