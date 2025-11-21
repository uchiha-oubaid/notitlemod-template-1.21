package net.loobaid.notitlemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.loobaid.notitlemod.NoTitleMod;
import net.loobaid.notitlemod.item.custom.PhoneItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PHONE = register(new PhoneItem(new Item.Settings().maxCount(1)),
            "phone");

    public static final Item CHOCOLATE = register(new Item(new Item.Settings().food(ModFoodComponent.CHOCOLATE)),
            "chocolate");

    private static Item register(Item item, String name) {
        Identifier itemName = Identifier.of(NoTitleMod.MOD_ID, name);
        // the registered item
        Item registeredItem;
        registeredItem = Registry.register(Registries.ITEM, itemName, item);
        return registeredItem;
    }

    public static void initialize() {
        NoTitleMod.LOGGER.info("Initializing mod items");
        // Initializing an item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(entries -> {
                    entries.add(PHONE);
                });

    }
}
