package mmu.minecraft.mj.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import mmu.minecraft.mj.MythNamespace;
import mmu.minecraft.mj.item.MythItem;
import mmu.minecraft.mj.recipe.MythRecipeDefinition;

public class CraftListener extends MythListenerDefinition {

  @EventHandler()
  public void customCraftEvent(PrepareItemCraftEvent event) {
    final Recipe recipe = event.getRecipe();
    if (recipe == null) return;
    final ItemMeta meta = recipe.getResult().getItemMeta();
    final Integer check = meta.getPersistentDataContainer().get(MythNamespace.RECIPE_RESULT.get(), PersistentDataType.INTEGER);
    final CraftingInventory inventory = event.getInventory();
    if (check != null) {
      final ItemStack result = MythRecipeDefinition.getResult(inventory.getMatrix());
      if (result == null) {
        inventory.setResult(new ItemStack(Material.AIR));
        return;
      }
      inventory.setResult(result);
      return;
    }
    if (hasCustomItem(inventory)) {
      inventory.setResult(new ItemStack(Material.AIR));
    }
  }

  private boolean hasCustomItem(CraftingInventory inventory) {
    for (ItemStack itemStack : inventory.getMatrix()) {
      final MythItem mythItem = MythItem.getItemByItemStack(itemStack);
      if (mythItem == null) continue;
      return true;
    }
    return false;
  }
  
}
