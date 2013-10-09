// ------------------------------------------------------------------------ //
//                              File Reference                              //
// Author: Patrick le Duc                                                   //
// Filename: CommandEditCommand.java                                                   //
// License: GNU GPLv2                                                       //
// Description:                                                             //
// -- SOMETHING --                                                           //
//                                                                          //
// ------------------------------------------------------------------------ //

package nl.pleduc.mc.CommandEdit;

import java.util.logging.Logger;

public class CommandEditCommand 
{
    public String   m_Command;
    public String[] m_CommandArgs;
    
    public String   m_Alias;
    public String[] m_AliasArgs;
    
    public boolean m_String;
    public boolean m_Function;
    
    // Debugging Purposes
    void PrintContent( Logger a_Logger )
    {
        String CommandLine = m_Command;
        for( int i = 0; i < m_CommandArgs.length; i++ )
        {
            CommandLine += " " + m_CommandArgs[i];
        }
        a_Logger.info( "Registered Command: " + CommandLine ); 
        
        String AliasLine = m_Alias;
        for( int i = 0; i < m_AliasArgs.length; i++ )
        {
            AliasLine += " " + m_AliasArgs[i];
        }
        a_Logger.info( "Registered Alias: " + AliasLine ); 
        
        a_Logger.info( "String: " + Boolean.toString( m_String ) + " Function: " + Boolean.toString( m_Function ) );
    }
}
