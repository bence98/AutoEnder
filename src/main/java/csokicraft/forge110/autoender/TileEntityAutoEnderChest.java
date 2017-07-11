package csokicraft.forge110.autoender;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class TileEntityAutoEnderChest extends TileEntity implements IInventory{
	protected UUID playerID;
	IItemHandler itemhndl;
	
	public void setPlayer(EntityPlayer p){
		playerID=p.getPersistentID();
	}
	
	public InventoryEnderChest getEnderInv(){
		try{
			return worldObj.getPlayerEntityByUUID(playerID).getInventoryEnderChest();
		}catch(NullPointerException e){
			return null;
		}
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		InventoryEnderChest inv=getEnderInv();
		if(inv!=null&&capability==CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
			if(itemhndl==null) itemhndl=new InvWrapper(inv);
			return (T) itemhndl;
		}
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		return capability==CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		if(compound.hasUniqueId("playerID"))
			playerID=compound.getUniqueId("playerID");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		if(playerID!=null)
			compound.setUniqueId("playerID", playerID);
		return super.writeToNBT(compound);
	}

	@Override
	public String getName(){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return null;
		return inv.getName();
	}

	@Override
	public boolean hasCustomName(){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return false;
		return inv.hasCustomName();
	}

	@Override
	public int getSizeInventory(){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return 0;
		return inv.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int index){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return null;
		return inv.getStackInSlot(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return null;
		return inv.decrStackSize(index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return null;
		return inv.removeStackFromSlot(index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return;
		inv.setInventorySlotContents(index, stack);
	}

	@Override
	public int getInventoryStackLimit(){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return 0;
		return inv.getInventoryStackLimit();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return false;
		return inv.isUseableByPlayer(player);
	}

	@Override
	public void openInventory(EntityPlayer player){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return;
		inv.openInventory(player);
	}

	@Override
	public void closeInventory(EntityPlayer player){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return;
		inv.closeInventory(player);
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return false;
		return inv.isItemValidForSlot(index, stack);
	}

	@Override
	public int getField(int id){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return 0;
		return inv.getField(id);
	}

	@Override
	public void setField(int id, int value){
		getEnderInv().setField(id, value);
	}

	@Override
	public int getFieldCount(){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return 0;
		return inv.getFieldCount();
	}

	@Override
	public void clear(){
		InventoryEnderChest inv=getEnderInv();
		if(inv==null) return;
		inv.clear();
	}
}
