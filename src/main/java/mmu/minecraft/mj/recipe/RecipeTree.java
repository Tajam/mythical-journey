package mmu.minecraft.mj.recipe;

import org.bukkit.inventory.ItemStack;

public class RecipeTree {
  
  private RecipeNode root;

  public RecipeTree() {
    this.root = new RecipeNode();
  }

  public void addBranch(RecipeMaterial[] materials, ItemStack result) {
    RecipeNode node = this.root;
    for (final RecipeMaterial material : materials) {
      node = node.addChild(material);
    }
    node.setResult(result);
  }

  public ItemStack getResult(ItemStack[] materials) {
    RecipeNode node = this.root;
    for (final ItemStack material : materials) {
      RecipeNode next = node.getChild(new RecipeMaterial(material));
      if (next == null) return null;
      node = next;
    }
    return node.getResult();
  }

}
