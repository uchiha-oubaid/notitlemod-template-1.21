package net.loobaid.notitlemod;

import net.fabricmc.api.ModInitializer;

import net.loobaid.notitlemod.entity.ModEntities;
import net.loobaid.notitlemod.item.ModItems;
import net.loobaid.notitlemod.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoTitleMod implements ModInitializer {
	public static final String MOD_ID = "notitlemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.initialize();
        ModEntities.registerModEntities();
        ModSounds.registerSounds();
	}
}