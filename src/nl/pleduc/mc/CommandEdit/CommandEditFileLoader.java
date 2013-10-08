// ------------------------------------------------------------------------ //
//                              File Reference                              //
// Author: Patrick le Duc                                                   //
// Filename: CommandEditFileLoader.java                                     //
// License: GNU GPLv2                                                       //
// Description:                                                             //
// -- SOMETHING --                                                          //
//                                                                          //
// ------------------------------------------------------------------------ //
package nl.pleduc.mc.CommandEdit;

import java.util.List;
import java.util.ArrayList;

public class CommandEditFileLoader 
{
    private CommandEdit m_Base;
    private CustomConfig m_Config;
    
    private ArrayList< String > m_Commands;
    private ArrayList< String > m_Aliases;
    
    CommandEditFileLoader( CommandEdit base )
    {
        m_Base = base;
        m_Config = new CustomConfig( "commands.yml", base );
        
        m_Commands = new ArrayList< String >();
        m_Aliases = new ArrayList< String >();
    }
    
    public void Load()
    {
        ArrayList< String > stringList = ( ArrayList<String> )m_Config.getConfig().getList( "commands" );
        
        for( int i = 0; i < stringList.size(); i++ )
        {
            String commandString = stringList.get( i ).toLowerCase();
            ProcessLine( commandString );
        }
    }
    
    public void Reload()
    {
        m_Commands.clear();
        m_Aliases.clear();
        Load();
    }
    
    private void ProcessLine( String a_Line )
    {
        String command = "";
        String alias = "";
        
        String[] splitString = a_Line.split( "=" );
    
        if( splitString[0] != null && splitString[1] != null )
        {   
            command = splitString[0];
            alias = splitString[1];
        }
        
        // Remove spaces at start and end ( if they are there )
        if( command.indexOf( " " ) == 0 )                           command = command.substring( 1 ); 
        if( command.lastIndexOf( " " ) == command.length() - 1 )    command = command.substring( 0, command.length() - 1 );
        
        if( alias.indexOf( " " ) == 0 )                             alias = alias.substring( 1 ); 
        if( alias.lastIndexOf( " " ) == alias.length() - 1 )        alias = alias.substring( 0, alias.length() - 1 );
        
        AddCommand( command, alias );
    }
    
    private void AddCommand( String a_Command, String a_Alias )
    {
        m_Commands.add( a_Command );
        m_Aliases.add( a_Alias );
        m_Base.getLogger().info( "Registered command: \"" + a_Command + "\" with the alias: \"" + a_Alias + "\"" );
    }
    
}
