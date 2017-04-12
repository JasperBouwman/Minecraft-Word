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
import com.spaceman.word.Font.EnterChecker;
import com.spaceman.word.Font.FontCreator;

public class Print implements CommandExecutor {
	// Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(),l.getBlockY()
	// - 7, l.getBlockZ() + 1).setType(m);
	Main p;

	public Print(Main instance) {
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

					Block block = Bukkit.getServer().getWorld(l.getWorld().getName())
							.getBlockAt(new Location(l.getWorld(), xx, yy, zz));
					if (block.getType().equals(Material.AIR)) {
						
					} else {

						block.setType(p.getConfig().getItemStack("word.paper").getType());
						block.setData((byte) p.getConfig().getInt("word.block.damage"));
					}
				}
			}
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;
		if (p.getConfig().contains("word.offset")) {
			if (args.length == 0) {
				Cursor();
				Location l = (Location) p.getConfig().get("word.offset");
				Location newl = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() + 2);
				p.getConfig().set("word.offset", newl);
				p.saveConfig();
				player.sendMessage("space created");
				return false;
			}
			String ss = "";
			for (int i = 0; i <= (args.length - 1); i++) {

				ss = ss + args[i] + " ";

				char[] charArray = args[i].toCharArray();

				p.getConfig().set("word.enterChecker", 0);

				for (char ch : charArray) {
					StringBuilder str = new StringBuilder();
					str.append(ch);
					String s = str.toString();

					EnterChecker ec = new EnterChecker(p);
					ec.Enter(s);

				}
				Location l4 = (Location) p.getConfig().get("word.offset");

				Block block = Bukkit.getWorld(l4.getWorld().getName()).getBlockAt(new Location(l4.getWorld(), l4.getX(),
						l4.getY(), (l4.getZ() + p.getConfig().getLong("word.enterChecker"))));
				if (block.getType() != (p.getConfig().getItemStack("word.paper").getType())) {
					
//					Location loc = (Location) p.getConfig().get("word.offset");
//					Location loc2 = (Location) p.getConfig().get("word.location");
//					if (loc.getZ() == loc2.getZ()) {
//						
//						player.sendMessage("word is to long to place");
//						return false;
//						
//					}

					Cursor();

					Location l1 = (Location) p.getConfig().get("word.offset");
					Location l2 = (Location) p.getConfig().get("word.location");
					Location newl2 = new Location(l1.getWorld(), l1.getX(), l1.getY() - 9, l2.getZ());
					p.getConfig().set("word.offset", newl2);
					p.saveConfig();
				}
				
				for (char ch : charArray) {
					StringBuilder str = new StringBuilder();
					str.append(ch);
					String s = str.toString();
					FontCreator fc = new FontCreator(p);

					Cursor();
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
