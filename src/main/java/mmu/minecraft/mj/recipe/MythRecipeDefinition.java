package mmu.minecraft.mj.recipe;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import mmu.minecraft.mj.MythNamespace;

public abstract class MythRecipeDefinition {
  
  private static RecipeTree tree;

  public static ItemStack getResult(ItemStack[] items) {
    return tree.getResult(items);
  }

  final public void register(JavaPlugin plugin) {
    final Server server = plugin.getServer();
    final NamespacedKey key = new NamespacedKey(plugin, generateKey());
    if (server.getRecipe(key) == null) {
      final ShapedRecipe recipe = new ShapedRecipe(key, getDummyItem());
      final RecipeMaterial[] materials = getRecipeMaterials();
      final String[] shape = new String[3];
      Arrays.fill(shape, "");
      for (int i = 0; i < materials.length; i++) {
        final char c = (char)('0' + i);
        shape[i / 3] += c;
        if (materials[i] == null) continue;
        recipe.setIngredient(c, materials[i].getMaterial());
      }
      recipe.shape(shape);
      tree.addBranch(materials, getResult());
    }
  }

  protected abstract RecipeMaterial[] getRecipeMaterials();

  protected abstract ItemStack getResult();

  final private String generateKey() {
    String key = MythNamespace.MYTH_RECIPE.getKey() + '_';
    for (RecipeMaterial recipeMaterial : getRecipeMaterials()) {
      final int value = recipeMaterial.getMythItem().getMaterial().hashCode();
      key += value;
    }
    return key;
  }

  final private ItemStack getDummyItem() {
    final ItemStack item = new ItemStack(Material.STICK);
    final ItemMeta meta = item.getItemMeta();
    meta.setDisplayName("Unobtainable Stick");
    meta.setLore(Arrays.asList(new String[] { "This is a bug! DON'T CLICK!" }));
    meta.getPersistentDataContainer().set(MythNamespace.RECIPE_RESULT.get(), PersistentDataType.INTEGER, 0);
    item.setItemMeta(meta);
    return item;
  }

}
