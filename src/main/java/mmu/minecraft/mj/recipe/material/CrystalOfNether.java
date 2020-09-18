package mmu.minecraft.mj.recipe.material;

import org.bukkit.inventory.ItemStack;

import mmu.minecraft.mj.item.MythItem;
import mmu.minecraft.mj.recipe.MythRecipeDefinition;
import mmu.minecraft.mj.recipe.RecipeMaterial;

public class CrystalOfNether extends MythRecipeDefinition {

  @Override
  protected RecipeMaterial[] getRecipeMaterials() {
    return new RecipeMaterial[] {
      new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_NETHER), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_NETHER), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_NETHER),
      new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_NETHER), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_NETHER), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_NETHER),
      new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_NETHER), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_NETHER), new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_NETHER)
    };
  }

  @Override
  protected ItemStack getResult() {
    return MythItem.CRYSTAL_OF_NETHER.toItemStack();
  }
  
}
