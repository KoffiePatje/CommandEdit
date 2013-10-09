// ------------------------------------------------------------------------ //
//                              File Reference                              //
// Author: Patrick le Duc                                                   //
// Filename: CommandEditFileLoader.java                                     //
// License: GNU GPLv2                                                       //
// Description:                                                             //
// Loads the configuration file for this plugin                             //
//                                                                          //
// ------------------------------------------------------------------------ //
package nl.pleduc.mc.CommandEdit;

import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.configuration.file.FileConfiguration;

public class CommandEditFileLoader 
{
    private CommandEdit m_Base;
    private CustomConfig m_Config;
    
    private ArrayList< CommandEditCommand > m_Commands;
    
    CommandEditFileLoader( CommandEdit base )
    {
        m_Base = base;
        m_Config = new CustomConfig( "commands.yml", base );
        
        m_Commands = new ArrayList< CommandEditCommand >();
    }
    
    FileConfiguration getCustomConfig()
    {
        return m_Config.getConfig();
    }
    
    ArrayList< CommandEditCommand > GetCommandList()
    {
        return m_Commands;
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
        Load();
    }
    
    public CommandEditCommand ProcessLine( String a_Line )
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
        
        // Split into command + args
        String[] commandArgs = command.split( " " );
        String[] aliasArgs = alias.split( " " );
        
        command = commandArgs[0];
        alias = aliasArgs[0];
        
        if( commandArgs.length > 1 )
        { 
            commandArgs = Arrays.copyOfRange( commandArgs, 1, commandArgs.length ); 
        }
        else
        {
            commandArgs[0] = "";
        }
        if( aliasArgs.length > 1 )
        { 
            aliasArgs = Arrays.copyOfRange( aliasArgs, 1, aliasArgs.length ); 
        }
        else
        {
            aliasArgs[0] = "";
        }
        
        CommandEditCommand a_Command = new CommandEditCommand();
        
        a_Command.m_Command = command;
        a_Command.m_CommandArgs = commandArgs;
        
        a_Command.m_Alias = alias;
        a_Command.m_AliasArgs = aliasArgs;
        
        a_Command.m_String = ( commandArgs[ commandArgs.length - 1 ].equalsIgnoreCase( "{$String}" ) );
        a_Command.m_Function = ( alias.matches( "(\\[).*?(\\])" )?true:false );
        
        m_Commands.add( a_Command );
        
        if( m_Base.isDebugging() )
        { 
            m_Commands.get( m_Commands.size() - 1 ).PrintContent( m_Base.getLogger() );
        }
        
        return a_Command;
    }
    
    
}
