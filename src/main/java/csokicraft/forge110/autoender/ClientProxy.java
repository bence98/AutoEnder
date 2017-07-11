package csokicraft.forge110.autoender;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerModels(){
		ItemModelMesher imm=Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		ModelResourceLocation loc=new ModelResourceLocation("autoender:autoEnderChest", "inventory");
		imm.register(AutoEnderMod.itemAutoEnderChest, 0, loc);
		ModelBakery.registerItemVariants(AutoEnderMod.itemAutoEnderChest, loc);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAutoEnderChest.class, new RendererAutoEnderChest());
	}
}
