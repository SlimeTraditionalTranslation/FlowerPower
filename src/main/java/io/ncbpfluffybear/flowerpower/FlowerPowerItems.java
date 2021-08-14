package io.ncbpfluffybear.flowerpower;

import io.ncbpfluffybear.flowerpower.FlowerPowerPlugin;
import io.ncbpfluffybear.flowerpower.items.InfinityApple;
import io.ncbpfluffybear.flowerpower.items.InfinityBandage;
import io.ncbpfluffybear.flowerpower.items.RecallCharm;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import utils.Constants;
import utils.ItemTags;

/**
 * SlimefunItemStack registration
 * @author NCBPFluffyBear
 */
public class FlowerPowerItems {

    public static final Category FLOWERPOWER_CATEGORY = new Category(new NamespacedKey(FlowerPowerPlugin.getInstance(),
            "flowerpower_category"), new CustomItem(Material.ALLIUM, "&5花魔法")
    );
    // Multiblocks
    public static final SlimefunItemStack MAGIC_BASIN = new SlimefunItemStack("MAGIC_BASIN",
            Material.CAULDRON,
            "&b魔法盆栽",
            "",
            "&7&o用來製作魔法物品的盆栽",
            "",
            "&e右鍵 &7用魔法杖啟用",
            ItemTags.MULTIBLOCK
    );
    // Blocks
    public static final SlimefunItemStack EXPERIENCE_CAULDRON = new SlimefunItemStack("EXPERIENCE_CAULDRON",
            Material.CAULDRON,
            "&a經驗鍋釜",
            "",
            "&7&o一個儲存經驗值的方塊",
            "&7&o用來製作魔法盆栽",
            "",
            "&e右鍵 &7來儲存經驗值",
            "&e蹲下右鍵 &7來提取經驗值",
            ItemTags.MULTIBLOCK
    );
    // Glistening Flowers
    public static final SlimefunItemStack GLISTENING_POPPY = new SlimefunItemStack("GLISTENING_POPPY",
            Material.POPPY,
            "&a閃耀罌粟",
            "",
            "&7&o發光的罌粟",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack GLISTENING_DANDELION = new SlimefunItemStack("GLISTENING_DANDELION",
            Material.DANDELION,
            "&a閃耀蒲公英",
            "",
            "&7&o發光的蒲公英",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack GLISTENING_OXEYE_DAISY = new SlimefunItemStack("GLISTENING_OXEYE_DAISY",
            Material.OXEYE_DAISY,
            "&a閃耀雛菊",
            "",
            "&7&o發光的雛菊",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack GLISTENING_ALLIUM = new SlimefunItemStack("GLISTENING_ALLIUM",
            Material.ALLIUM,
            "&a閃耀紫紅球花",
            "",
            "&7&o發光的紫紅球花",
            "",
            ItemTags.CRAFTING_ITEM
    );
    // Items
    public static final SlimefunItemStack MAGICAL_WAND = new SlimefunItemStack("MAGICAL_WAND",
            Material.BLAZE_ROD,
            "&5魔法杖",
            "",
            "&e右鍵 &7在魔法盆栽",
            "&7來啟用它",
            "",
            ItemTags.TOOL
    );
    public static final SlimefunItemStack MAGIC_CREAM = new SlimefunItemStack("MAGIC_CREAM",
            Material.MAGMA_CREAM,
            "&6&l魔法膏",
            "",
            "&7&o具有魔法屬性的黏糊糊球",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack OVERGROWTH_SEED = new SlimefunItemStack("OVERGROWTH_SEED",
            Material.WHEAT_SEEDS,
            "&3盛開種子",
            "",
            "",
            "&e右鍵 &7在兼容的花上來",
            "&7產生它的多個複製花朵",
            "",
            ItemTags.MAGICAL_ITEM
    );
    // Flower Crystals
    public static final SlimefunItemStack RED_CRYSTAL = new SlimefunItemStack("RED_CRYSTAL",
            Material.RED_GLAZED_TERRACOTTA,
            "&c紅色結晶",
            "",
            "&7&o看起來非常閃亮...",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack YELLOW_CRYSTAL = new SlimefunItemStack("YELLOW_CRYSTAL",
            Material.YELLOW_GLAZED_TERRACOTTA,
            "&e黃色結晶",
            "",
            "&7&o看起來非常閃亮...",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack WHITE_CRYSTAL = new SlimefunItemStack("WHITE_CRYSTAL",
            Material.WHITE_GLAZED_TERRACOTTA,
            "&f白色結晶",
            "",
            "&7&o看起來非常閃亮...",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack PURPLE_CRYSTAL = new SlimefunItemStack("PURPLE_CRYSTAL",
            Material.PURPLE_GLAZED_TERRACOTTA,
            "&5紫色水晶",
            "",
            "&7&o看起來非常閃亮...",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack MOVEMENT_SPEED_CHARM = new SlimefunItemStack("MOVEMENT_SPEED_CHARM",
            Material.SUGAR,
            "&a移動加速魔法符",
            "",
            "&e右鍵 &c檢查這個魔法符",
            "&7&o把此魔法符放在副手來跑更快",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack ATTACK_SPEED_CHARM = new SlimefunItemStack("ATTACK_SPEED_CHARM",
            Material.SUGAR,
            "&a攻擊速度魔法符",
            "",
            "&e右鍵 &c檢查這個魔法符",
            "&7&o把此魔法符放在副手來攻擊更快",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack FLY_SPEED_CHARM = new SlimefunItemStack("FLY_SPEED_CHARM",
            Material.SUGAR,
            "&a飛行速度魔法符",
            "",
            "&e右鍵 &c檢查這個魔法符",
            "&7&o把此魔法符放在副手來飛的更快",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack DAMAGE_CHARM = new SlimefunItemStack("DAMAGE_CHARM",
            Material.SUGAR,
            "&a傷害魔法符",
            "",
            "&e右鍵 &c檢查這個魔法符",
            "&7&o把此魔法符放在副手來造成更多傷害",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack HEALTH_CHARM = new SlimefunItemStack("HEALTH_CHARM",
            Material.SUGAR,
            "&a血量魔法符",
            "",
            "&e右鍵 &c檢查這個魔法符",
            "&7&o把此魔法符放在副手來獲得更多血量",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack EXPERIENCE_TOME = new SlimefunItemStack("EXPERIENCE_TOME",
            Material.ENCHANTED_BOOK,
            "&e經驗之書 &a(0 / 1000000)",
            "",
            "&7&o能夠儲存大量的經驗值",
            "",
            "&e右鍵 &7來儲存經驗",
            "&e蹲下右鍵 &7來提取經驗",
            "&e左建 &7來批量執行操作",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack INFINITY_APPLE = new SlimefunItemStack("INFINITY_APPLE",
            new CustomItem(SkullItem.fromHash("99a79d7e5d1ba739ab4471643e744ef781f7c1d4ea52efc99168d6cb5732326")),
            "&e無限蘋果",
            "",
            "&7&o將經驗值轉換成食物",
            "",
            "&e右鍵 &7來吃",
            "",
            "&a消耗: " + InfinityApple.EXP_PER_CONSUME + "經驗值 每" + InfinityApple.FOOD_PER_CONSUME + "飢餓值",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack INFINITY_BANDAGE = new SlimefunItemStack("INFINITY_BANDAGE",
            Material.PAPER,
            "&c無限繃帶",
            "",
            "&7&o將經驗值轉換成血量",
            "",
            "&e右鍵 &7來治療",
            "",
            "&a消耗: " + InfinityBandage.EXP_PER_CONSUME + "經驗值 每" + InfinityBandage.HEALTH_PER_CONSUME + "血量",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack RECALL_CHARM = new SlimefunItemStack("RECALL_CHARM",
            Material.ENDER_EYE,
            "&5回傳魔法符",
            "",
            "&7&o用經驗值將你傳送",
            "&7&o回你記住的位置...",
            "",
            "&e蹲下右鍵 &7來綁定當前位置",
            "&e右鍵 &7來傳送",
            "",
            "&3綁定位置: None",
            "",
            "&a消耗: " + RecallCharm.TELEPORT_COST + " 經驗值 每次傳送",
            ItemTags.MAGICAL_ITEM
    );


    private static final Enchantment glowEnchant = Enchantment.getByKey(Constants.GLOW_ENCHANT);

    static {
        GLISTENING_POPPY.addEnchantment(glowEnchant, 1);
        GLISTENING_DANDELION.addEnchantment(glowEnchant, 1);
        GLISTENING_OXEYE_DAISY.addEnchantment(glowEnchant, 1);
        GLISTENING_ALLIUM.addEnchantment(glowEnchant, 1);

        OVERGROWTH_SEED.addEnchantment(glowEnchant, 1);
        INFINITY_BANDAGE.addEnchantment(glowEnchant, 1);
        RECALL_CHARM.addEnchantment(glowEnchant, 1);
    }


    private FlowerPowerItems() {
    }

}
