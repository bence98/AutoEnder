package csokicraft.forge.autoender;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(modid = AutoEnderMod.MODID, version = AutoEnderMod.VERSION)
@EventBusSubscriber
public class AutoEnderMod
{
    public static final String MODID = "autoender";
    public static final String VERSION = "1.0.5.1";
    
    public static Block blockAutoEnderChest=new BlockAutoEnderChest().setUnlocalizedName("autoEnderChest").setRegistryName("autoEnderChest");
    public static Item itemAutoEnderChest=new ItemBlock(blockAutoEnderChest).setUnlocalizedName("autoEnderChest").setRegistryName("autoEnderChest");
    
    @Instance
    public static AutoEnderMod inst;
    @SidedProxy(clientSide="csokicraft.forge.autoender.ClientProxy", serverSide="csokicraft.forge.autoender.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerTileEntity(TileEntityAutoEnderChest.class, "AutoEnderChest");
    	proxy.registerModels();
    }
    
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
    	IForgeRegistry<Block> registry=event.getRegistry();
    	registry.register(blockAutoEnderChest);
    }
    
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
    	IForgeRegistry<Item> registry=event.getRegistry();
    	registry.register(itemAutoEnderChest);
    }
}
