package net.richardsprojects.teamod;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.TextComponentString;

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
			   URL url = new URL("https://s3.amazonaws.com/minecraftmedia.net/currentVersion.txt");
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
		  
		  if(!TempData.players.contains(player.getDisplayName().getUnformattedText())) {
			  player.sendMessage(new TextComponentString("\u00a7eThank you for downloading the Coffee & Tea Mod."));
		  }
		  
		  if(returnData.equals("ERROR"))
		  {
			  if(!TempData.players.contains(player.getDisplayName().getUnformattedText())) {
				  player.sendMessage(new TextComponentString("\u00a7eError checking for updates to the Coffee & Tea Mod."));
			  }
		  }
		  else if(returnData.equals("1.2.1"))
		  {
			  if(!TempData.players.contains(player.getDisplayName().getUnformattedText())) {
				  player.sendMessage(new TextComponentString("\u00a7eThe Coffee & Tea Mod is up to date. v1.2.1"));
			  }
		  }
		  else
		  {
			  if(!TempData.players.contains(player.getDisplayName().getUnformattedText())) {
				  player.sendMessage(new TextComponentString("\u00a7eA newer version of the mod is available! v" + returnData));
			  }
		  }
		  if(!TempData.players.contains(player.getDisplayName().getUnformattedText())) {
			  player.sendMessage(new TextComponentString("\u00a7eCheck out minecraftmedia.net for screenshots, seeds & videos."));
		  }
		  TempData.players = TempData.players + player.getDisplayName().getUnformattedText() + ",";
	  }
		
}

