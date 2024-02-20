package org.main.ph.Utils;

import org.main.ph.PH;

import java.util.HashMap;
import java.util.UUID;

public class Cooldown {

    private static final HashMap<UUID, Long> cooldown = new HashMap<>();

    public static void setCooldown(UUID uuid) {
        if (PH.Instance.getConfig().getInt("Message.Sec") != 0) {
            cooldown.put(uuid, System.currentTimeMillis());
        }
    }

    private static Long getCooldown(UUID uuid) {
        return (System.currentTimeMillis() - cooldown.get(uuid))/1000;
    }

    public static String getCooldownValue(UUID uuid, Integer timecd) {
        if(!cooldown.containsKey(uuid)) {
            return "Нет информации";
        }
        if (timecd != 0) {
            long cd = timecd - getCooldown(uuid);
            return cd + "";
        }
        return "";
    }
    public static boolean isCooldown(UUID uuid, Integer time) {
        if(cooldown.containsKey(uuid)) {
            return getCooldown(uuid) <= time;
        }
        return false;
    }
}
