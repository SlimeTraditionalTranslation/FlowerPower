package io.ncbpfluffybear.flowerpower.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.ncbpfluffybear.flowerpower.objects.FPNotPlaceable;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import utils.Utils;

import javax.annotation.Nonnull;

/**
 * A {@link io.github.thebusybiscuit.slimefun4.implementation.items.medical.Bandage} that consumes experience
 * instead of the item
 *
 * @author NCBPFluffyBear
 */
public class InfinityBandage extends SimpleSlimefunItem<ItemUseHandler> implements FPNotPlaceable, NotPlaceable {

    public static final double HEALTH_PER_CONSUME = 1;
    public static final int EXP_PER_CONSUME = 10;
    private final Map<Player, Long> cooldowns = new HashMap<>();

    public InfinityBandage(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();

            long cooldown = cooldowns.getOrDefault(p, 0L);
            if (cooldown + 500L >= System.currentTimeMillis()) {
                Utils.send(p, "&c這個物品正在冷卻中!");
                return;
            }

            int exp = Utils.getTotalExperience(p);
            double health = p.getHealth();
            double maxHealth = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

            // Check if player has enough exp
            if (exp < EXP_PER_CONSUME) {
                Utils.send(p, "&c你沒有足夠的經驗值! 你需要經驗值: " + EXP_PER_CONSUME);
                return;
            }

            // Check if player needs healing
            if (health >= maxHealth) {
                Utils.send(p, "&c你的血量已滿!");
                return;
            }

            // Consume exp and heal player
            p.giveExp(-EXP_PER_CONSUME);
            double newHealth = health + HEALTH_PER_CONSUME;
            if (newHealth > maxHealth) {
                newHealth = maxHealth;
            }
            p.setHealth(newHealth);
            cooldowns.put(p, System.currentTimeMillis());

            p.playSound(p.getLocation(), Sound.ENTITY_CAT_HISS, 1, 1);

        };
    }

    @Override
    public boolean isDisenchantable() {
        return false;
    }
}
