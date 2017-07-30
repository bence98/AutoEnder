package csokicraft.forge.autoender;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

@Mod(modid = AutoEnderMod.MODID, version = AutoEnderMod.VERSION)
public class AutoEnderMod
{
    public static final String MODID = "autoender";
    public static final String VERSION = "1.0.4.2";
    
    public static Block blockAutoEnderChest=new BlockAutoEnderChest().setUnlocalizedName("autoEnderChest").setRegistryName("autoEnderChest");
    public static Item itemAutoEnderChest=new ItemBlock(blockAutoEnderChest).setUnlocalizedName("autoEnderChest").setRegistryName("autoEnderChest");
    
    @Instance
    public static AutoEnderMod inst;
    @SidedProxy(clientSide="csokicraft.forge.autoender.ClientProxy", serverSide="csokicraft.forge.autoender.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.register(blockAutoEnderChest);
        GameRegistry.register(itemAutoEnderChest);
        GameRegistry.registerTileEntity(TileEntityAutoEnderChest.class, "AutoEnderChest");
        
        GameRegistry.addRecipe(new ShapedOreRecipe(blockAutoEnderChest,
        		"iri", "rer", "iri",
        		'r', "dustRedstone",
        		'i', "ingotIron",
        		'e', "chestEnder"));
    	proxy.registerModels();
    }
}
