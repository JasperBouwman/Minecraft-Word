package com.spaceman.word.Font;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import com.spaceman.word.Main;


public class CursorRemove {

	Main p;

	public CursorRemove(Main instance) {
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

					if (!block.getType().equals(Material.AIR)) {
						block.setType(p.getConfig().getItemStack("word.paper").getType());
						block.setData((byte) p.getConfig().getInt("word.block.damage"));
					}
				}
			}
		}
	}
}