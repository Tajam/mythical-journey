package mmu.minecraft.mj.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import mmu.minecraft.mj.MythNamespace;
import mmu.minecraft.mj.recipe.MythRecipeDefinition;

public class CraftListener extends MythListenerDefinition {

  @EventHandler()
  public void customCraftEvent(final PrepareItemCraftEvent event) {
    final ItemMeta meta = event.getRecipe().getResult().getItemMeta();
    final Integer check = meta.getPersistentDataContainer().get(MythNamespace.RECIPE_RESULT.get(), PersistentDataType.INTEGER);
    if (check != null) {
      final CraftingInventory inventory = event.getInventory();
      final ItemStack result = MythRecipeDefinition.getResult(inventory.getMatrix());
      if (result == null) {
        inventory.setResult(new ItemStack(Material.AIR));
        return;
      }
      inventory.setResult(result);
    }
  }
  
}
