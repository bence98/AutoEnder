package csokicraft.forge.autoender;

import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockAutoEnderChest extends BlockEnderChest{

	protected BlockAutoEnderChest(){
		super();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new TileEntityAutoEnderChest();
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		if(placer instanceof EntityPlayer){
			TileEntityAutoEnderChest te=(TileEntityAutoEnderChest) worldIn.getTileEntity(pos);
			te.setPlayer((EntityPlayer) placer);
		}
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityAutoEnderChest te=(TileEntityAutoEnderChest) worldIn.getTileEntity(pos);
		if(te!=null){
			InventoryEnderChest inv=te.getEnderInv();
			if(inv!=null){
				if(!worldIn.isRemote)
					playerIn.displayGUIChest(inv);
				return true;
			}
		}
		return false;
	}
}
