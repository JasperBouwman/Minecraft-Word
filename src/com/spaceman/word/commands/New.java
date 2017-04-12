package com.spaceman.word.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.spaceman.word.Main;

public class New implements CommandExecutor {

	Main p;

	public New(Main instance) {
		p = instance;
	}

	public void cls() {
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
						// block.setType(Material.REDSTONE_BLOCK);
						block.setType(Material.AIR);
					}
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void paper(Player player, Material m, byte data) {
		int x = player.getLocation().getBlockX() + 30;
		int z = player.getLocation().getBlockZ();

		Location L1 = new Location(player.getWorld(), x, 200, z + 200);
		Location L2 = new Location(player.getWorld(), x, 100, z);
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
					block.setType(m);
					block.setData(data);
				}
			}
		}
		player.sendMessage("new file made");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;

		if (args.length == 0) {

			cls();
			paper(player, Material.QUARTZ_BLOCK, (byte) 0);
			int x = player.getLocation().getBlockX() + 30;
			int z = player.getLocation().getBlockZ();
			p.getConfig().set("word.location", new Location(player.getWorld(), x, 200, z));
			p.getConfig().set("word.offset", new Location(player.getWorld(), x, 200, z));
			p.getConfig().set("word.material", new ItemStack(Material.COAL_BLOCK));
			p.getConfig().set("word.paper", new ItemStack(Material.QUARTZ_BLOCK));
			p.getConfig().set("word.block.damage", 0);
			p.saveConfig();
		} else if (args.length == 1) {

			Material m = Material.getMaterial(args[0].toUpperCase());
			if (m == null) {
				player.sendMessage("error 404, given material not found");
				return false;
			}
			cls();
			paper(player, m, (byte) 0);

			int x = player.getLocation().getBlockX() + 30;
			int z = player.getLocation().getBlockZ();
			p.getConfig().set("word.location", new Location(player.getWorld(), x, 200, z));
			p.getConfig().set("word.offset", new Location(player.getWorld(), x, 200, z));
			p.getConfig().set("word.material", new ItemStack(Material.COAL_BLOCK));
			p.getConfig().set("word.paper", new ItemStack(m));
			p.getConfig().set("word.block.damage", 0);
			p.saveConfig();

		} else if (args.length == 2) {
			int damage = 0;
			try {
				damage = Integer.parseInt(args[1]) + 1;
			} catch (NumberFormatException nfe) {
				player.sendMessage("damage value must be an number");
				return false;
			}

			Material m = Material.getMaterial(args[0].toUpperCase());
			if (m == null) {
				player.sendMessage("error 404, given material not found");
				return false;
			}
			cls();
			paper(player, m, (byte) damage);

			int x = player.getLocation().getBlockX() + 30;
			int z = player.getLocation().getBlockZ();
			p.getConfig().set("word.location", new Location(player.getWorld(), x, 200, z));
			p.getConfig().set("word.offset", new Location(player.getWorld(), x, 200, z));
			p.getConfig().set("word.material", new ItemStack(Material.COAL_BLOCK));
			p.getConfig().set("word.paper", new ItemStack(m));
			p.getConfig().set("word.block.damage", damage);
			p.saveConfig();

		}

		return false;
	}
}
