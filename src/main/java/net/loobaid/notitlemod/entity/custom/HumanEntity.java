package net.loobaid.notitlemod.entity.custom;


import net.loobaid.notitlemod.item.ModItems;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class HumanEntity extends AnimalEntity {
    public HumanEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    private final AnimationState ANIMATION_STATE = new AnimationState();
    private int animationTimeOut = 0;

    // adding the mob goals
    @Override
    public void initGoals() {
        this.goalSelector.add(0, new TemptGoal(this, 1.750,
                Ingredient.ofItems(ModItems.PHONE), true));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 2, 2.0f));
        this.goalSelector.add(2, new LookAroundGoal(this));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 2.0f));
    }

    public static DefaultAttributeContainer.Builder createMobAttribute() {
        return DefaultAttributeContainer.builder()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.50)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 12)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 5.0);
    }

    private void getAnimationState() {
        if (this.animationTimeOut <= 0) {
            this.animationTimeOut = 40;
            this.ANIMATION_STATE.start(this.age);
        } else {
            this.animationTimeOut--;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient) {
            this.getAnimationState();
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
