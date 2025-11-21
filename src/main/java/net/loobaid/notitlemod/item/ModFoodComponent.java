package net.loobaid.notitlemod.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponent {
    public static final FoodComponent CHOCOLATE =
            new FoodComponent.Builder().snack().nutrition(2).saturationModifier(2.3f)
                    .build();
}