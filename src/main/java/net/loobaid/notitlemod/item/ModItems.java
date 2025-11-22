package net.loobaid.notitlemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.loobaid.notitlemod.NoTitleMod;
import net.loobaid.notitlemod.item.custom.PhoneItem;
import net.loobaid.notitlemod.sound.ModSounds;
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

    public static final Item GIGACHAD_MUSIC_DISK =
            register(new Item(new Item.Settings().jukeboxPlayable(ModSounds.GIGACHAD_SONG_KEY)),
                    "gigachad_music_disk");

    private static Item register(Item item, String name) { // a helper method to register items
        Identifier itemName = Identifier.of(NoTitleMod.MOD_ID, name);
        // the registered item
        Item registeredItem;
        registeredItem = Registry.register(Registries.ITEM, itemName, item);
        return registeredItem;
    }

    public static void initialize() {
        NoTitleMod.LOGGER.info("Initializing mod items");
        // Adding to the creative tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(entries -> {
                    entries.add(PHONE);
                    entries.add(CHOCOLATE);
                });

    }
}
