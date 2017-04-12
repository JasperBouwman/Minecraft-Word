package com.spaceman.word.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.spaceman.word.Main;

public class Cls implements CommandExecutor {

	Main p;

	public Cls(Main instance) {
		p = instance;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (p.getConfig().contains("word.offset")) {
			Player player = (Player) sender;

			player.sendMessage("cleared the file");

			Location L1 = (Location) p.getConfig().get("word.location");
			Location L2 = new Location(L1.getWorld(), L1.getX(), 100, L1.getZ() + 200);

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
						Block block = Bukkit.getServer().getWorld(player.getWorld().getName())
								.getBlockAt(new Location(player.getWorld(), xx, yy, zz));
						block.setType(p.getConfig().getItemStack("word.paper").getType());
						block.setData((byte) p.getConfig().getInt("word.block.damage"));
					}
				}
			}
			p.getConfig().set("word.offset", L1);
			p.saveConfig();
		}
		return false;
	}
}
