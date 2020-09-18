package mmu.minecraft.mj.recipe.material;

import org.bukkit.inventory.ItemStack;

import mmu.minecraft.mj.item.MythItem;
import mmu.minecraft.mj.recipe.MythRecipeDefinition;
import mmu.minecraft.mj.recipe.RecipeMaterial;

public class CrystalOfVoid extends MythRecipeDefinition {

  @Override
  protected RecipeMaterial[] getRecipeMaterials() {
    return new RecipeMaterial[] {
      new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_VOID), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_VOID), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_VOID),
      new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_VOID), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_VOID), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_VOID),
      new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_VOID), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_VOID), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_VOID)
    };
  }

  @Override
  protected ItemStack getResult() {
    return MythItem.CRYSTAL_OF_VOID.toItemStack();
  }
  
}
