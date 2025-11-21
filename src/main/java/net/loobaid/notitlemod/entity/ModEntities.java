package net.loobaid.notitlemod.entity;

import net.loobaid.notitlemod.NoTitleMod;
import net.loobaid.notitlemod.entity.custom.HumanEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    // Registering Human entity
    public static final EntityType<HumanEntity> HUMAN =
            Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(NoTitleMod.MOD_ID, "human"),
                    EntityType.Builder.create(HumanEntity::new, SpawnGroup.CREATURE)
                            .dimensions(1f, 2.5f).build());

    public static void registerModEntities() {
        NoTitleMod.LOGGER.info("Registering mod entities");
    }
}
