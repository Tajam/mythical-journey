package mmu.minecraft.mj;

import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import mmu.minecraft.mj.listener.MythListener;
import mmu.minecraft.mj.recipe.MythRecipe;

public class MythicalJourney extends JavaPlugin {
  
  @Override
  public void onLoad() {
    super.onLoad();
  }

  @Override
  public void onEnable() {
    // setup rules for each world
    for (final World world: this.getServer().getWorlds()) {
      world.setGameRule(GameRule.DO_MOB_LOOT, false);
      world.setGameRule(GameRule.FALL_DAMAGE, false);
      world.setGameRule(GameRule.KEEP_INVENTORY, true);
      world.setGameRule(GameRule.MOB_GRIEFING, false);
      world.setGameRule(GameRule.NATURAL_REGENERATION, false);
    }

    // register namespace
    MythNamespace.register(this);

    // register event listeners
    MythListener.register(this);

    // register recipes
    MythRecipe.register(this);

    super.onEnable();
  }

  @Override
  public void onDisable() {
    super.onDisable();
  }
  
}
