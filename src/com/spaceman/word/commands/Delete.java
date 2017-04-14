package com.spaceman.word.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.spaceman.word.Main;

public class Delete implements CommandExecutor {

	Main p;

	public Delete(Main instance) {
		p = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;

		if (p.getConfig().contains("word.location")) {
			Location l = (Location) p.getConfig().get("word.location");

			Location L1 = l;
			Location L2 = new Location(l.getWorld(), l.getX(), 100, (l.getZ() + 200));
			// calculates the valuables
			int minX = Math.min(L1.getBlockX(), L2.getBlockX());
			int minY = Math.min(L1.getBlockY(), L2.getBlockY());
			int minZ = Math.min(L1.getBlockZ(), L2.getBlockZ());
			int maxX = Math.max(L1.getBlockX(), L2.getBlockX());
			int maxY = Math.max(L1.getBlockY(), L2.getBlockY());
			int maxZ = Math.max(L1.getBlockZ(), L2.getBlockZ());
			// set all blocks in this region to air
			for (int xx = minX; xx <= maxX; xx++) {
				for (int yy = minY; yy <= maxY; yy++) {
					for (int zz = minZ; zz <= maxZ; zz++) {
						Block block = Bukkit.getServer().getWorld(l.getWorld().getName())
								.getBlockAt(new Location(l.getWorld(), xx, yy, zz));
						block.setType(Material.AIR);
					}
				}
			}
			p.getConfig().set("word", null);
			p.saveConfig();
			player.sendMessage("file removed");
		} else {
			player.sendMessage("no document set");
		}

		return false;
	}
}
