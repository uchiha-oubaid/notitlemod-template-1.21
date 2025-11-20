package net.loobaid.notitlemod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.loobaid.notitlemod.datagen.ModModelProvider;
import net.loobaid.notitlemod.datagen.ModRecipeProvider;
import net.minecraft.data.DataGenerator;

public class NoTitleModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        DataGenerator.Pack pack = fabricDataGenerator.createPack();
        // adding the datagen providers...
        pack.addProvider(ModModelProvider::new);
        //pack.addProvider(ModRecipeProvider::new);
	}
}
