package mmu.minecraft.mj.command;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mmu.minecraft.mj.Log;
import mmu.minecraft.mj.item.MythItem;
import mmu.minecraft.mj.item.MythItemDefinition;

public class ExecutorGiveItem extends ExecutorAdapter {
  
  public ExecutorGiveItem() {
    addParameter(new ParameterPlayer(true));
    addParameter(new ParameterItem(true));
    addParameter(new ParameterNumber(false, 1, 16, 32, 64).setName("count"));
  }

  @Override
  public boolean executePlayer(Player sender, String[] args) {
    return execute(sender, args);
  }

  @Override
  public boolean executeCommand(CommandSender sender, String[] args) {
    return execute(sender, args);
  }

  private boolean execute(CommandSender sender, String[] args) {
    final List<Player> players = new PlayerSelector(sender, args[0]).getPlayers();
    if (players == null) return true;

    final MythItem mythItem = MythItem.getItemById(args[1]);
    if (mythItem == null) {
      new Log().eror().t("Item with the name ").o(args[1]).t(" doesn't exists.").send(sender);
      return true;
    }

    int count = 1;
    if (args.length >= 3) {
      try {
        count = Integer.parseInt(args[2]);
      } catch (Exception e) {
        new Log().eror().t("Wrong number format for count parameter.").send(sender);
        return true;
      }
    }

    final MythItemDefinition definition = mythItem.getDefinition();
    final String name = definition.getRarity().applyFormat(definition.getDisplayName());
    for (Player player : players) {
      final ItemStack itemStack = mythItem.toItemStack();
      itemStack.setAmount(count);
      player.getInventory().addItem(itemStack);
      new Log().info().t("Received ").p().t(" x").t().send(player, name, count);
    }

    final Integer playerCount = players.size();
    if (playerCount >= 2) {
      new Log().warn().t("Given ").o(name).t(" x").o().t(" to ").o().t(" players!").send(sender, count, playerCount);
    } else if (playerCount == 1) {
      new Log().warn().t("Given ").o(name).t(" x").o().t(" to ").t(players.get(0).getDisplayName()).t("!").send(sender, count);
    } else {
      new Log().eror().t("Given item to no player, something might when wrong!").send(sender);
    }
    return true;
  }

}
