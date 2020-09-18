package mmu.minecraft.mj.recipe;

import org.bukkit.plugin.java.JavaPlugin;

import mmu.minecraft.mj.recipe.material.*;
// import mmu.minecraft.mj.recipe.consumable.*;
// import mmu.minecraft.mj.recipe.weapon.*;

public enum MythRecipe {
  
  /*=============*\
  |* Consumables *|
  \*=============*/

  

  /*========*\
  |* Weapon *|
  \*========*/



  /*==========*\
  |* Material *|
  \*==========*/

  CRYSTAL_OF_OVERWORLD(new CrystalOfOverworld()),
  CRYSTAL_OF_NETHER(new CrystalOfNether()),
  CRYSTAL_OF_AETHER(new CrystalOfAether()),
  CRYSTAL_OF_VOID(new CrystalOfVoid())

  ;

  public static void register(JavaPlugin plugin) {
    for (final MythRecipe recipe : MythRecipe.values()) {
      recipe.getDefinition().register(plugin);
    }
  }

  private MythRecipeDefinition definition;

  private MythRecipe(MythRecipeDefinition definition) {
    this.definition = definition;
  }

  public MythRecipeDefinition getDefinition() {
    return this.definition;
  }

}
