package com.spaceman.word.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.spaceman.word.Main;
import com.spaceman.word.font.CursorRemove;
import com.spaceman.word.font.EnterChecker;
import com.spaceman.word.font.FontCreator;

public class Print implements CommandExecutor {
	// Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(),l.getBlockY()
	// - 7, l.getBlockZ() + 1).setType(m);
	Main p;

	public Print(Main instance) {
		p = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		p.getConfig().set("word.end", "false");
		if (p.getConfig().contains("word.offset")) {
			if (args.length == 0) {

				CursorRemove CR = new CursorRemove(p);
				CR.Cursor();

				Location l = (Location) p.getConfig().get("word.offset");
				Location newl = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() + 2);
				
				if (!Bukkit.getServer().getWorld(newl.getWorld().getName()).getBlockAt(newl).getType().equals(p.getConfig().getItemStack("word.paper").getType())) {
					
					Location l1 = (Location) p.getConfig().get("word.offset");
					Location l2 = (Location) p.getConfig().get("word.location");
					Location newl1 = new Location(l1.getWorld(), l1.getX(), l1.getY() - 9, l2.getZ());

					if (Bukkit.getWorld(newl1.getWorld().getName())
							.getBlockAt(newl1.getBlockX(), newl1.getBlockY() - 8, newl1.getBlockZ()).getType()
							.equals(p.getConfig().getItemStack("word.paper").getType())) {

						p.getConfig().set("word.offset", newl1);
						p.saveConfig();
						player.sendMessage("enter created");
					} else {
						player.sendMessage("end of file");
					}
					return false;
				}
				
				p.getConfig().set("word.offset", newl);
				p.saveConfig();
				player.sendMessage("space created");
				return false;
			}
			String ss = "";

			for (int i = 0; i <= (args.length - 1); i++) {
				p.getConfig().set("word.enterChecker", 0);
				ss = ss + args[i] + " ";

				char[] charArray = args[i].toCharArray();

				for (char ch : charArray) {
					StringBuilder str = new StringBuilder();
					str.append(ch);
					String s = str.toString();

					EnterChecker ec = new EnterChecker(p);
					ec.EnterWord(s, player);

				}

				for (char ch : charArray) {
					StringBuilder str = new StringBuilder();
					str.append(ch);
					String s = str.toString();
					FontCreator fc = new FontCreator(p);

					CursorRemove CR = new CursorRemove(p);
					CR.Cursor();

					fc.Font(s);
				}
				Location l = (Location) p.getConfig().get("word.offset");
				Location newl = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() + 2);
				p.getConfig().set("word.offset", newl);
				p.saveConfig();
			}
			player.sendMessage("placed: " + ss);
			Location l = (Location) p.getConfig().get("word.offset");
			Location newl = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() - 2);
			p.getConfig().set("word.offset", newl);
			p.saveConfig();
			
			if (p.getConfig().getString("word.end").equals("true")) {
				player.sendMessage("letters didn't fit on the file");
			}
			
		}
		return false;
	}

}
