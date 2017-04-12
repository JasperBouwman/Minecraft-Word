package com.spaceman.word.Font;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

import com.spaceman.word.Main;

import net.minecraft.server.v1_11_R1.Material;

public class EnterChecker {
	
	Main p;
	
	public EnterChecker(Main instance) {
		p = instance;
	}
	
	@SuppressWarnings("deprecation")
	public void Tile() {
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

	public void Enter(String s) {
		
		Location l = (Location) p.getConfig().get("word.offset");
		
		if (s.equals("i") || s.equals(".") || s.equals(",") || s.equals("|") || s.equals(":") || s.equals(";") || s.equals("!")) {
			
			l.setZ(l.getZ() + 2);
			
		} else if (s.equals("`") || s.equals("'") || s.equals("l")) {
			
			l.setZ(l.getZ() + 3);
		
		} else if (s.equals("I") || s.equals("t") || s.equals("[") || s.equals("]")) {

			l.setZ(l.getZ() + 4);
			
		} else if (s.equals("f") || s.equals("t") || s.equals("{") || s.equals("}") || s.equals("(") || s.equals(")") || s.equals("<") || s.equals(">")) {

			l.setZ(l.getZ() + 5);
			
		}
		
		Block block = Bukkit.getWorld(l.getWorld().getName()).getBlockAt(l);
		if (block.getType().equals(Material.AIR)) {
			
			Tile();

			Location l1 = (Location) p.getConfig().get("word.offset");
			Location l2 = (Location) p.getConfig().get("word.location");
			Location newl = new Location(l1.getWorld(), l1.getX(), l1.getY() - 9, l2.getZ());
			p.getConfig().set("word.offset", newl);
			p.saveConfig();
		}
	}
}
