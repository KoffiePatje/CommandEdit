<<<<<<< HEAD
// ------------------------------------------------------------------------ //
//                              File Reference                              //
// Author: Patrick le Duc                                                   //
<<<<<<< HEAD
// Filename: CommandEditListener.java                                       //
// License: GNU GPLv2                                                       //
// Description:                                                             //
// -- SOMETHING --                                                          //
=======
// Filename: CommandEditListener.java                                                   //
// License: GNU GPLv2                                                       //
// Description:                                                             //
// -- SOMETHING --                                                           //
>>>>>>> 8aceaaa1fec98e84cde622414f9ab079ca04f048
//                                                                          //
// ------------------------------------------------------------------------ //

package nl.pleduc.mc.CommandEdit;

<<<<<<< HEAD
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
=======

public class CommandEditListener {

>>>>>>> 8aceaaa1fec98e84cde622414f9ab079ca04f048
}
=======
// ------------------------------------------------------------------------ //
//                              File Reference                              //
// Author: Patrick le Duc                                                   //
// Filename: CommandEditListener.java                                                   //
// License: GNU GPLv2                                                       //
// Description:                                                             //
// -- SOMETHING --                                                           //
//                                                                          //
// ------------------------------------------------------------------------ //

package nl.pleduc.mc.CommandEdit;


public class CommandEditListener {

}
>>>>>>> 8aceaaa1fec98e84cde622414f9ab079ca04f048
