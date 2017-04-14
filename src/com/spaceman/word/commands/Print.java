package com.spaceman.word.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.spaceman.word.Main;
import com.spaceman.word.Font.CursorRemove;
import com.spaceman.word.Font.EnterChecker;
import com.spaceman.word.Font.FontCreator;

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
		if (p.getConfig().contains("word.offset")) {
			if (args.length == 0) {

				CursorRemove CR = new CursorRemove(p);
				CR.Cursor();

				Location l = (Location) p.getConfig().get("word.offset");
				Location newl = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() + 2);
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
					ec.Enter(s);

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
		}
		return false;
	}

}
