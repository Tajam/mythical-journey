package mmu.minecraft.mj;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.junit.Test;

import mmu.minecraft.mj.item.MythItem;
import mmu.minecraft.mj.recipe.RecipeMaterial;

public class MythTest {
  
  @Test
  public void test() {
    final Map<RecipeMaterial, Integer> testMap = new HashMap<>();
    testMap.put(new RecipeMaterial(Material.STICK), 1);
    testMap.put(new RecipeMaterial(MythItem.CRYSTAL_OF_AETHER), 2);
    testMap.put(new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_OVERWORLD), 3);
    testMap.put(new RecipeMaterial(Material.DIAMOND), 4);

    System.out.println(testMap.get(new RecipeMaterial(Material.STICK)));
    System.out.println(testMap.get(new RecipeMaterial(MythItem.CRYSTAL_OF_AETHER)));
    System.out.println(testMap.get(new RecipeMaterial(MythItem.CRYSTAL_SHARD_OF_OVERWORLD)));
    System.out.println(testMap.get(new RecipeMaterial(Material.DIAMOND)));
  }

}
