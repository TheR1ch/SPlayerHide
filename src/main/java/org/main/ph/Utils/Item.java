package org.main.ph.Utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.main.ph.PH;

import java.util.ArrayList;
import java.util.List;

public class Item {
    public static String getStr(String s){
        return PH.Instance.getConfig().getString(Color.translate(s));
    }

    public static ItemStack ItemSet(Material material, String DisplayName, List<String> lore){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Color.translate(DisplayName));
        List<String> coloredLore = new ArrayList<>();
        for (String line : lore) {
            coloredLore.add(Color.translate(line));
        }
        meta.setLore(coloredLore);
        item.setItemMeta(meta);
        return item;
    }
}
