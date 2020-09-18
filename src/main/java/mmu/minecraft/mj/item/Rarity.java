package mmu.minecraft.mj.item;

import org.bukkit.ChatColor;

public enum Rarity {
  
  COMMON("Common", ChatColor.GRAY),
  FINE("Fine", ChatColor.BLUE),
  MASTERWORK("Masterwork", ChatColor.GREEN),
  RARE("Rare", ChatColor.YELLOW),
  EXOTIC("Exotic", ChatColor.GOLD),
  ASCENDED("Ascended", ChatColor.RED),
  LEGENDARY("Legendary", ChatColor.LIGHT_PURPLE)
  
  ;

  private ChatColor color;
  private String name;

  private Rarity(String name, ChatColor color) {
    this.color = color;
    this.name = name;
  }

  public String applyFormat(String text) {
    return ChatColor.DARK_GRAY + "[ " + this.color + text + ChatColor.DARK_GRAY + " ]" + ChatColor.RESET;
  }

  public String getName() {
    return this.color + name + ChatColor.RESET;
  }

}
