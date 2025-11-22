package net.loobaid.notitlemod.entity.client;

import net.loobaid.notitlemod.NoTitleMod;
import net.loobaid.notitlemod.entity.custom.HumanEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;


public class HumanModel<T extends HumanEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer HUMAN_LAYER = new EntityModelLayer(Identifier.of(NoTitleMod.MOD_ID, "human"),
            "main");

    private final ModelPart head;
    private final ModelPart bb_main;

    public HumanModel(ModelPart root) {
        this.head = root.getChild("head");
        this.bb_main = root.getChild("bb_main");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData leg1 = modelPartData.addChild("leg1", ModelPartBuilder.create().uv(0, 24).cuboid(-2.0F, -5.0F, -1.0F, 3.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 22.0F, -1.0F));

        ModelPartData leg2 = modelPartData.addChild("leg2", ModelPartBuilder.create().uv(24, 0).cuboid(-1.0F, -5.0F, -1.0F, 3.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 22.0F, -1.0F));

        ModelPartData hand1 = modelPartData.addChild("hand1", ModelPartBuilder.create().uv(24, 9).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, 13.0F, -1.0F));

        ModelPartData hand2 = modelPartData.addChild("hand2", ModelPartBuilder.create().uv(10, 24).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 13.0F, -1.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 14).cuboid(-3.0F, -21.0F, -4.0F, 6.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -17.0F, -3.0F, 8.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        bb_main.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return bb_main;
    }

    @Override
    public void setAngles(HumanEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform); // important !!!
        this.setHeadAngles(headYaw, headPitch);

        // for the animations
        this.animateMovement(HumanAnimations.MOVE, limbAngle, limbDistance, 2f, 2.5f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.17453292F;
        this.head.pitch = headPitch * 0.17453292F;
    }
}
