package org.main.ph.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.main.ph.PH;

public class HVP {

    public static void hide(Player player){
        if (!player.hasMetadata("spacestudio")) {
            player.setMetadata("spacestudio", new FixedMetadataValue(PH.Instance, 1));
            for (Player pl : Bukkit.getOnlinePlayers()) {
                player.hidePlayer(PH.Instance, pl);
            }
            player.sendMessage(Color.translate(Item.getStr("Message.OffMsg")));
        } else {
            player.removeMetadata("spacestudio", PH.Instance);
            for (Player pl : Bukkit.getOnlinePlayers()) {
                player.showPlayer(PH.Instance, pl);
            }
            player.sendMessage(Color.translate(Item.getStr("Message.OnMsg")));
        }
    }
}
