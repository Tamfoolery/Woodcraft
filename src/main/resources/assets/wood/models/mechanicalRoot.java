package net.minecraft.src;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class mechanicalRoot extends ModelBase
{
    ModelRenderer Main_Block;
    ModelRenderer Root;
    ModelRenderer Root1;
    ModelRenderer Root2;
    ModelRenderer Root3;
    ModelRenderer Root4;
    ModelRenderer Root5;

    public mechanicalRoot()
    {
        this( 0.0f );
    }

    public mechanicalRoot( float par1 )
    {
        Main_Block = new ModelRenderer( this, 0, -16 );
        Main_Block.setTextureSize( 32, 16 );
        Main_Block.addBox( -8F, -8F, -8F, 16, 16, 16);
        Main_Block.setRotationPoint( 0F, 16F, 0F );
        Root = new ModelRenderer( this, -8, -8 );
        Root.setTextureSize( 32, 16 );
        Root.addBox( -4F, -4F, -4F, 8, 8, 8);
        Root.setRotationPoint( -7F, 21F, -8F );
        Root1 = new ModelRenderer( this, 2, -6 );
        Root1.setTextureSize( 32, 16 );
        Root1.addBox( -3F, -3F, -3F, 6, 6, 6);
        Root1.setRotationPoint( -12F, 23F, -11F );
        Root2 = new ModelRenderer( this, 4, 2 );
        Root2.setTextureSize( 32, 16 );
        Root2.addBox( -2F, -2F, -2F, 4, 4, 4);
        Root2.setRotationPoint( -14F, 25F, -15F );
        Root3 = new ModelRenderer( this, -5, -5 );
        Root3.setTextureSize( 32, 16 );
        Root3.addBox( -2.5F, -3F, -2.5F, 5, 6, 5);
        Root3.setRotationPoint( 8F, 22F, 7F );
        Root4 = new ModelRenderer( this, -5, 3 );
        Root4.setTextureSize( 32, 16 );
        Root4.addBox( -2.5F, -2.5F, -2.5F, 5, 5, 5);
        Root4.setRotationPoint( 10F, 23F, 5F );
        Root5 = new ModelRenderer( this, 2, 5 );
        Root5.setTextureSize( 32, 16 );
        Root5.addBox( -1.5F, -2F, -1.5F, 3, 4, 3);
        Root5.setRotationPoint( 13F, 25F, 7F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Main_Block.rotateAngleX = 0F;
        Main_Block.rotateAngleY = 0F;
        Main_Block.rotateAngleZ = 0F;
        Main_Block.renderWithRotation(par7);

        Root.rotateAngleX = 0F;
        Root.rotateAngleY = 0F;
        Root.rotateAngleZ = 0F;
        Root.renderWithRotation(par7);

        Root1.rotateAngleX = 0F;
        Root1.rotateAngleY = 0F;
        Root1.rotateAngleZ = 0F;
        Root1.renderWithRotation(par7);

        Root2.rotateAngleX = 0F;
        Root2.rotateAngleY = 0F;
        Root2.rotateAngleZ = 0F;
        Root2.renderWithRotation(par7);

        Root3.rotateAngleX = 0F;
        Root3.rotateAngleY = 0F;
        Root3.rotateAngleZ = 0F;
        Root3.renderWithRotation(par7);

        Root4.rotateAngleX = 0F;
        Root4.rotateAngleY = 0F;
        Root4.rotateAngleZ = 0F;
        Root4.renderWithRotation(par7);

        Root5.rotateAngleX = 0F;
        Root5.rotateAngleY = 0F;
        Root5.rotateAngleZ = 0F;
        Root5.renderWithRotation(par7);

    }

}
