package com.spaceman.word.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.spaceman.word.Main;

public class Enter implements CommandExecutor {

	Main p;

	public Enter(Main instance) {
		p = instance;
	}
	
	@SuppressWarnings("deprecation")
	public void Cursor() {
		Location l = (Location) p.getConfig().get("word.offset");

		Location L1 = new Location(l.getWorld(), l.getX(), l.getY() - 7, l.getZ() + 1);
		Location L2 = new Location(l.getWorld(), l.getX(), l.getY() - 7, l.getZ() + 5);

		int minX = Math.min(L1.getBlockX(), L2.getBlockX());
		int minY = Math.min(L1.getBlockY(), L2.getBlockY());
		int minZ = Math.min(L1.getBlockZ(), L2.getBlockZ());
		int maxX = Math.max(L1.getBlockX(), L2.getBlockX());
		int maxY = Math.max(L1.getBlockY(), L2.getBlockY());
		int maxZ = Math.max(L1.getBlockZ(), L2.getBlockZ());

		for (int xx = minX; xx <= maxX; xx++) {
			for (int yy = minY; yy <= maxY; yy++) {
				for (int zz = minZ; zz <= maxZ; zz++) {
					Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(new Location(l.getWorld(), xx, yy, zz)).setType(p.getConfig().getItemStack("word.paper").getType());
					Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(new Location(l.getWorld(), xx, yy, zz)).setData((byte) p.getConfig().getInt("word.block.damage"));
				}
			}
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		Player player = (Player) sender;
		if (p.getConfig().contains("word.offset")) {
			Cursor();
			player.sendMessage("enter");

			Location l1 = (Location) p.getConfig().get("word.offset");
			Location l2 = (Location) p.getConfig().get("word.location");
			Location newl = new Location(l1.getWorld(), l1.getX(), l1.getY() - 9, l2.getZ());
			p.getConfig().set("word.offset", newl);
			p.saveConfig();
		}
		return false;
	}
}