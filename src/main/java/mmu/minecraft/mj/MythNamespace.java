package mmu.minecraft.mj;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public enum MythNamespace {

  MYTH_ITEM("myth_item"),
  MYTH_GROUP_TYPE("myth_group_type"),
  MYTH_RECIPE("myth_recipe"),
  RECIPE_RESULT("recipe_result")

  ;

  public static void register(JavaPlugin plugin) {
    for (MythNamespace namespace : MythNamespace.values()) {
      namespace.namespacedKey = new NamespacedKey(plugin, namespace.key);
    }
  }

  private String key;
  private NamespacedKey namespacedKey;

  private MythNamespace(String key) {
    this.key = key;
    this.namespacedKey = null;
  }
  
  public NamespacedKey get() {
    if (this.namespacedKey == null) throw new NullPointerException("Namespace not registered.");
    return this.namespacedKey;
  }

  public String getKey() {
    return this.key;
  }

}
