// ------------------------------------------------------------------------ //
//                              File Reference                              //
// Author: Patrick le Duc                                                   //
// Filename: CommandEditListener.java                                       //
// License: GNU GPLv2                                                       //
// Description:                                                             //
// -- SOMETHING --                                                          //
//                                                                          //
// ------------------------------------------------------------------------ //

package nl.pleduc.mc.CommandEdit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.Listener;


public class CommandEditListener implements Listener
{
    private CommandEdit m_Base;
    
    public CommandEditListener( CommandEdit base )
    {
        m_Base = base;
    }
    
    @EventHandler( priority = EventPriority.HIGH )
    public void onPlayerCommand( PlayerCommandPreprocessEvent event )
    {
        String m = event.getMessage();
        
        m_Base.getLogger().info( "Command Edit catched the following command: " + m );
    }
}