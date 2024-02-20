package org.main.ph.Listeners;

import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.main.ph.PH;
import org.main.ph.Utils.Cooldown;
import org.main.ph.Utils.HVP;
import org.main.ph.Utils.Item;

import java.util.Arrays;
import java.util.Objects;

public class PlayerListener implements Listener {

    @EventHandler
    public void Join(PlayerJoinEvent e){
        Player player = e.getPlayer();
        Inventory inv = player.getInventory();
        if (inv.getItem(PH.Instance.getConfig().getInt("Settings.Slot")) == null){
            inv.setItem(PH.Instance.getConfig().getInt("Settings.Slot"), Item.ItemSet(Material.getMaterial(Item.getStr("Settings.On_hide.Item")), Item.getStr("Settings.Off_hide.DisplayName"), PH.Instance.getConfig().getStringList("Settings.Off_hide.Lore")));
        }
    }

    @EventHandler
    public void Click(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getItem() != null) {
            if (!Cooldown.isCooldown(player.getUniqueId(), PH.Instance.getConfig().getInt("Message.Sec"))) {
                int slot = PH.Instance.getConfig().getInt("Settings.Slot");
                if (e.getPlayer().getItemInHand().getType() == Material.getMaterial(Item.getStr("Settings.On_hide.Item"))) {
                    HVP.hide(player);
                    player.getInventory().setItem(slot,
                            Item.ItemSet(Material.getMaterial(Item.getStr("Settings.Off_hide.Item")),
                                    Item.getStr("Settings.Off_hide.DisplayName"), PH.Instance.getConfig().getStringList("Settings.Off_hide.Lore")));
                    Cooldown.setCooldown(player.getUniqueId());
                } else if (e.getPlayer().getItemInHand().getType() == Material.getMaterial(Item.getStr("Settings.Off_hide.Item"))) {
                    HVP.hide(player);
                    player.getInventory().setItem(slot,
                            Item.ItemSet(Material.getMaterial(Item.getStr("Settings.On_hide.Item")),
                                    Item.getStr("Settings.On_hide.DisplayName"), PH.Instance.getConfig().getStringList("Settings.On_hide.Lore")));
                    Cooldown.setCooldown(player.getUniqueId());
                }
            } else {
                String time = Cooldown.getCooldownValue(player.getUniqueId(), PH.Instance.getConfig().getInt("Message.Sec"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Item.getStr("Message.Cooldown").replace("%time%", time)));
            }
        }
    }
}
