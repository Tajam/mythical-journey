package mmu.minecraft.mj.recipe;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.inventory.ItemStack;

public class RecipeNode {
  
  private ItemStack result;
  private Map<RecipeMaterial, RecipeNode> childs;

  public RecipeNode() {
    this.result = null;
    this.childs = new HashMap<>();
  }

  public RecipeNode addChild(RecipeMaterial material) {
    if (this.childs.containsKey(material)) {
      return this.getChild(material);
    }
    return this.childs.put(material, new RecipeNode());
  }

  public RecipeNode getChild(RecipeMaterial material) {
    return this.childs.get(material);
  }

  public void setResult(ItemStack result) {
    this.result = result;
  }

  public ItemStack getResult() {
    return this.result;
  }

}
