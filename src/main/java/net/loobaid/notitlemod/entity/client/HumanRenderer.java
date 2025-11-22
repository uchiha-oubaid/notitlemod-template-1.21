package net.loobaid.notitlemod.entity.client;

import net.loobaid.notitlemod.NoTitleMod;
import net.loobaid.notitlemod.entity.custom.HumanEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HumanRenderer extends MobEntityRenderer<HumanEntity, HumanModel<HumanEntity>> {
    public HumanRenderer(EntityRendererFactory.Context context) {
        super(context, new HumanModel<>(context.getPart(HumanModel.HUMAN_LAYER)), 0.5f);
    }

    @Override
    public void render(HumanEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1.0f, 1.0f, 1.0f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(HumanEntity entity) {
        return Identifier.of(NoTitleMod.MOD_ID, "textures/entity/human/human.png");
    }
}
