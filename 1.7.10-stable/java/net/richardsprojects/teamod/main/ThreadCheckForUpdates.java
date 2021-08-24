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
		if(!TempData.players.contains(player.getDisplayName())) {
			player.addChatComponentMessage(new ChatComponentText("\u00a7eThank you for downloading the Coffee & Tea Mod!"));
		}
		if(!TempData.players.contains(player.getDisplayName())) {
			player.addChatComponentMessage(new ChatComponentText("\u00a7eCheck out minecraftmedia.net for screenshots, seeds & videos."));
		}
		TempData.players = TempData.players + player.getDisplayName() + ",";
	  }
		
}


