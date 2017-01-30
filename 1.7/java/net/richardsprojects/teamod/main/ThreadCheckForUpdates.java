package net.richardsprojects.teamod.main;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ThreadCheckForUpdates implements Runnable {

	private EntityPlayer player;
	
	public ThreadCheckForUpdates(EntityPlayer player)
	{
		this.player = player;
	}
	
	@Override
	public void run() 
	{
	   String returnData = "";
		  try {
			   URL url = new URL("https://dl.dropboxusercontent.com/u/97875111/CoffeeAndTeaMod/currentVersion.txt");
			   Scanner s = new Scanner(url.openStream());
				   
			   while (s.hasNextLine())
               {
				   // Read an entire line, which contains all the details for 1 account
		           returnData = s.nextLine();
		       }
			   s.close();

		  }
		  catch(IOException ex) {
			  ex.printStackTrace();
			  returnData = "ERROR";
			}
		  
		  if(!TempData.players.contains(player.getDisplayName())) {
			  player.addChatComponentMessage(new ChatComponentText("\u00a7eThank you for downloading the Coffee & Tea Mod."));
		  }
		  
		  if(returnData.equals("ERROR"))
		  {
			  if(!TempData.players.contains(player.getDisplayName())) {
				  player.addChatComponentMessage(new ChatComponentText("\u00a7eError checking for updates to the Coffee & Tea Mod."));
			  }
		  }
		  else if(returnData.equals("1.2.1"))
		  {
			  if(!TempData.players.contains(player.getDisplayName())) {
				  player.addChatComponentMessage(new ChatComponentText("\u00a7eThe Coffee & Tea Mod is up to date. v1.2.1"));
			  }
		  }
		  else
		  {
			  if(!TempData.players.contains(player.getDisplayName())) {
				  player.addChatComponentMessage(new ChatComponentText("\u00a7eA newer version of the mod is available! v" + returnData));
			  }
		  }
		  if(!TempData.players.contains(player.getDisplayName())) {
			  player.addChatComponentMessage(new ChatComponentText("\u00a7eBe sure to check out my other mod the Recipe Expansion Pack."));
		  }
		  TempData.players = TempData.players + player.getDisplayName() + ",";
	  }
		
}


