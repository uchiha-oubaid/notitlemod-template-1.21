package net.loobaid.notitlemod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.client.ModelProvider;

public class NoTitleModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        DataGenerator.Pack pack = fabricDataGenerator.createPack();
        // adding the datagen providers...
        pack.addProvider(ModelProvider::new);
	}
}
