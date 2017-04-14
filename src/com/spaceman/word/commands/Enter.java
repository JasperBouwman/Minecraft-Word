package com.spaceman.word.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.spaceman.word.Main;
import com.spaceman.word.font.CursorRemove;

public class Enter implements CommandExecutor {

	Main p;

	public Enter(Main instance) {
		p = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		Player player = (Player) sender;
		if (p.getConfig().contains("word.offset")) {
			CursorRemove CR = new CursorRemove(p);
			CR.Cursor();

			Location l1 = (Location) p.getConfig().get("word.offset");
			Location l2 = (Location) p.getConfig().get("word.location");
			Location newl = new Location(l1.getWorld(), l1.getX(), l1.getY() - 9, l2.getZ());

			if (Bukkit.getWorld(newl.getWorld().getName())
					.getBlockAt(newl.getBlockX(), newl.getBlockY() - 8, newl.getBlockZ()).getType()
					.equals(p.getConfig().getItemStack("word.paper").getType())) {

				p.getConfig().set("word.offset", newl);
				p.saveConfig();
				player.sendMessage("enter created");
			} else {
				player.sendMessage("end of file");
			}
		}
		return false;
	}
}