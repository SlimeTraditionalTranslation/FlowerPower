package io.ncbpfluffybear.flowerpower.setup;

import io.ncbpfluffybear.flowerpower.FlowerPowerItems;
import io.ncbpfluffybear.flowerpower.FlowerPowerPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

/**
 * Registers all of the research
 * @author NCBPFluffyBear
 */
public final class ResearchSetup {

    private ResearchSetup() {}

    public static void setup() {

        register("magic_crafting", 2711, "魔法製作", 5, FlowerPowerItems.MAGIC_BASIN, FlowerPowerItems.MAGICAL_WAND);
        register("experience_cauldron", 2712, "經驗鍋釜", 5, FlowerPowerItems.EXPERIENCE_CAULDRON);
        register("glistening_resources", 2713, "閃耀資源", 10,
                FlowerPowerItems.MAGIC_CREAM, FlowerPowerItems.GLISTENING_POPPY, FlowerPowerItems.GLISTENING_DANDELION,
                FlowerPowerItems.GLISTENING_OXEYE_DAISY, FlowerPowerItems.GLISTENING_ALLIUM, FlowerPowerItems.RED_CRYSTAL,
                FlowerPowerItems.YELLOW_CRYSTAL, FlowerPowerItems.WHITE_CRYSTAL, FlowerPowerItems.PURPLE_CRYSTAL
        );
        register("experience_storage", 2714, "經驗儲存", 50, FlowerPowerItems.EXPERIENCE_TOME);
        register("attribute_charms", 2715, "屬性魔法符", 50, FlowerPowerItems.MOVEMENT_SPEED_CHARM,
                FlowerPowerItems.ATTACK_SPEED_CHARM, FlowerPowerItems.FLY_SPEED_CHARM, FlowerPowerItems.DAMAGE_CHARM,
                FlowerPowerItems.HEALTH_CHARM
        );
        register("recall_teleportation", 2716, "回傳傳送", 30, FlowerPowerItems.RECALL_CHARM);
        register("infinity_magic", 2717, "無限魔法", 30, FlowerPowerItems.INFINITY_APPLE, FlowerPowerItems.INFINITY_BANDAGE);
        register("faster_flower_growth", 2718, "更快的花朵成長", 10, FlowerPowerItems.OVERGROWTH_SEED);

    }

    private static void register(String key, int id, String name, int defaultCost, ItemStack... items) {
        Research research = new Research(new NamespacedKey(FlowerPowerPlugin.getInstance(), key), id, name, defaultCost);

        for (ItemStack item : items) {
            SlimefunItem sfItem = SlimefunItem.getByItem(item);

            if (sfItem != null) {
                research.addItems(sfItem);
            }
        }

        research.register();
    }
}
