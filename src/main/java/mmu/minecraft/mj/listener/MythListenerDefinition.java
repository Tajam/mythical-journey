package mmu.minecraft.mj.listener;

import org.bukkit.Server;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MythListenerDefinition implements Listener {
  
  private YamlConfiguration configuration;

  public final void register(JavaPlugin plugin) {
    final Server server = plugin.getServer();
    server.getPluginManager().registerEvents(this, plugin);

    this.configuration = server.spigot().getConfig();
  }

  protected final YamlConfiguration getConfig() {
    return this.configuration;
  }

}
