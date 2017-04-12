package com.spaceman.word.Font;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.spaceman.word.Main;

public class EnterChecker {

	Main p;

	public EnterChecker(Main instance) {
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
					Bukkit.getServer().getWorld(l.getWorld().getName())
							.getBlockAt(new Location(l.getWorld(), xx, yy, zz))
							.setType(p.getConfig().getItemStack("word.paper").getType());
					Bukkit.getServer().getWorld(l.getWorld().getName())
							.getBlockAt(new Location(l.getWorld(), xx, yy, zz))
							.setData((byte) p.getConfig().getInt("word.block.damage"));
				}
			}
		}
	}

	public void Enter(String s) {

		if (s.equals("i") || s.equals(".") || s.equals(",") || s.equals("|") || s.equals(":") || s.equals(";")
				|| s.equals("!")) {

			long i = p.getConfig().getLong("word.enterChecker") + 2;
			p.getConfig().set("word.enterChecker", i);

		} else if (s.equals("`") || s.equals("'") || s.equals("l")) {

			long i = p.getConfig().getLong("word.enterChecker") + 3;
			p.getConfig().set("word.enterChecker", i);

		} else if (s.equals("I") || s.equals("t") || s.equals("[") || s.equals("]")) {

			long i = p.getConfig().getLong("word.enterChecker") + 4;
			p.getConfig().set("word.enterChecker", i);

		} else if (s.equals("f") || s.equals("t") || s.equals("{") || s.equals("}") || s.equals("(") || s.equals(")")
				|| s.equals("<") || s.equals(">")) {

			long i = p.getConfig().getLong("word.enterChecker") + 5;
			p.getConfig().set("word.enterChecker", i);

		} else {
			long i = p.getConfig().getLong("word.enterChecker") + 6;
			p.getConfig().set("word.enterChecker", i);
		}
		p.saveConfig();
	}
}
