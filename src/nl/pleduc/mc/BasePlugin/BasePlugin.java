// ------------------------------------------------------------------------ //
//                              File Reference                              //
// Author: Patrick le Duc                                                   //
// Filename: MyWorld.java                                                   //
// License: G
// Description:                                                             //
// Base Class of the MyWorld Plugin                                         //
//                                                                          //
// ------------------------------------------------------------------------ //

package nl.pleduc.mc.BasePlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class BasePlugin extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getLogger().info( "Hello World" );
    }
    
    @Override
    public void onDisable()
    {
        
    }
    
    @Override
    public boolean onCommand( CommandSender sender, Command cmd, String label, String[] args )
    {
        return true;
    }
    
}