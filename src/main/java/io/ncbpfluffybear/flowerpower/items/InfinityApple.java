package io.ncbpfluffybear.flowerpower.items;

import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.ncbpfluffybear.flowerpower.objects.FPNotPlaceable;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import utils.Utils;

import javax.annotation.Nonnull;

/**
 * A "consumable" food that consumes experience
 * instead of the item
 *
 * @author NCBPFluffyBear
 */
public class InfinityApple extends SimpleSlimefunItem<ItemUseHandler> implements FPNotPlaceable, NotPlaceable {

    public static final int FOOD_PER_CONSUME = 1;
    public static final int EXP_PER_CONSUME = 1;

    public InfinityApple(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            int exp = p.getTotalExperience();
            int foodLevel = p.getFoodLevel();

            // Check if player has enough exp
            if (exp < EXP_PER_CONSUME) {
                Utils.send(p, "&c你沒有足夠的經驗值! 你需要經驗值: " + EXP_PER_CONSUME);
                return;
            }

            // Check if player needs food
            if (foodLevel > 20) {
                Utils.send(p, "&c你已經吃飽了!");
                return;
            }

            // Consume exp and feed player
            p.giveExp(-EXP_PER_CONSUME);
            p.setFoodLevel(foodLevel + FOOD_PER_CONSUME);

            p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1, 1);

        };
    }
}
