package ru.abstractmenus.placeholders.hooks.dnd;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.abstractmenus.api.inventory.Menu;
import ru.abstractmenus.extractors.ItemStackExtractor;
import ru.abstractmenus.menu.AbstractMenu;
import ru.abstractmenus.placeholders.PlaceholderHook;
import ru.abstractmenus.services.MenuManager;

public class PlacedItemPlaceholders implements PlaceholderHook {

    @Override
    public String replace(String placeholder, Player player) {
        Menu menu = MenuManager.instance().getOpenedMenu(player);

        if (menu instanceof AbstractMenu) {
            AbstractMenu am = (AbstractMenu) menu;

            if (placeholder.equalsIgnoreCase("slot"))
                return String.valueOf(am.getLastPlacedSlot());

            ItemStack item = am.getLastPlaced();

            if (item != null)
                return ItemStackExtractor.INSTANCE.extract(item, placeholder);
        }

        return null;
    }
}
