package io.ncbpfluffybear.flowerpower.items;

import io.ncbpfluffybear.flowerpower.FlowerPowerPlugin;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import utils.Utils;

/**
 * Holds large amounts of experience
 * Inspired by Thermal Foundation's Tome of Knowledge
 *
 * @author NCBPFluffyBear
 */
public class ExperienceTome extends SlimefunItem implements Listener {

    private static final NamespacedKey expAmount = new NamespacedKey(FlowerPowerPlugin.getInstance(), "exp-amount");
    private static final int MAX_EXP = 1000000;
    private static final int EXP_TRANSFER_RATE = 10;

    public ExperienceTome(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

        Utils.registerEvents(this);
    }

    @EventHandler
    private void onTomeUse(PlayerInteractEvent e) {
        ItemStack tome = e.getItem();

        // Check if item is a tome
        if (!isItem(tome)) {
            return;
        }

        e.setCancelled(true);

        if (tome == null) {
            return;
        }

        ItemMeta tomeMeta = tome.getItemMeta();
        Player p = e.getPlayer();
        int tomeExp = PersistentDataAPI.getInt(tomeMeta, expAmount, 0);

        // Exp extraction
        if (p.isSneaking()) {

            // Check if the exp can be extracted from tome
            if (tomeExp == 0) {
                Utils.send(p, "&c這經驗之書是空的!");
                return;
            }

            int transferExp;

            // Left click is max withdraw
            if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                transferExp = tomeExp;
            } else {
                transferExp = EXP_TRANSFER_RATE;
            }

            // Add Exp to player
            PersistentDataAPI.setInt(tomeMeta, expAmount, tomeExp -= transferExp);
            p.giveExp(transferExp);
            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

        } else {

            // Check if exp can be added to the tome
            if (tomeExp >= MAX_EXP) {
                Utils.send(p, "&c這經驗之書已滿!");
                return;
            }

            if (p.getTotalExperience() == 0) {
                Utils.send(p, "&c你沒有足夠的經驗值!");
                return;
            }

            int transferExp;

            // Left click is max insert
            if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                transferExp = p.getTotalExperience();
            } else {
                transferExp = EXP_TRANSFER_RATE;
            }

            // Add Exp to player
            PersistentDataAPI.setInt(tomeMeta, expAmount, tomeExp += transferExp);
            p.giveExp(-transferExp);
            p.playSound(p.getLocation(), Sound.ENTITY_DROWNED_AMBIENT_WATER, 1, 1);
        }

        // Update name to display stored amount
        tomeMeta.setDisplayName(Utils.color("&e經驗之書 &a(" + tomeExp + " / 1000000)"));
        tome.setItemMeta(tomeMeta);
    }
}
