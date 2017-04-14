package com.spaceman.word.Font;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import com.spaceman.word.Main;

public class EnterChecker {

	Main p;

	public EnterChecker(Main instance) {
		p = instance;
	}

	public void Enter(String s) {

		if (s.equals("i") || s.equals(".") || s.equals(",") || s.equals("|") || s.equals(":") || s.equals(";")
				|| s.equals("!")) {

			int i = p.getConfig().getInt("word.enterChecker") + 2;
			p.getConfig().set("word.enterChecker", i);

		} else if (s.equals("`") || s.equals("'") || s.equals("l")) {

			int i = p.getConfig().getInt("word.enterChecker") + 3;
			p.getConfig().set("word.enterChecker", i);

		} else if (s.equals("I") || s.equals("t") || s.equals("[") || s.equals("]")) {

			int i = p.getConfig().getInt("word.enterChecker") + 4;
			p.getConfig().set("word.enterChecker", i);

		} else if (s.equals("f") || s.equals("t") || s.equals("{") || s.equals("}") || s.equals("(") || s.equals(")")
				|| s.equals("<") || s.equals(">")) {

			int i = p.getConfig().getInt("word.enterChecker") + 5;
			p.getConfig().set("word.enterChecker", i);

		} else {

			int i = p.getConfig().getInt("word.enterChecker") + 6;
			p.getConfig().set("word.enterChecker", i);

		}

		p.saveConfig();

		Location l = (Location) p.getConfig().get("word.offset");
		int a = (int) (l.getZ() + p.getConfig().getInt("word.enterChecker"));
		Location ll = new Location(l.getWorld(), l.getX(), l.getY(), a);
		Block block = Bukkit.getWorld(l.getWorld().getName()).getBlockAt(ll);
		if (block.getType().equals(Material.AIR)) {

			Location loc = (Location) p.getConfig().get("word.offset");
			Location loc2 = (Location) p.getConfig().get("word.location");
			if (loc.getZ() == loc2.getZ()) {
				Bukkit.broadcastMessage("to long");
				return;

			}

			CursorRemove CR = new CursorRemove(p);
			CR.Cursor();
			Bukkit.broadcastMessage("enter");
			Location l1 = (Location) p.getConfig().get("word.offset");
			Location l2 = (Location) p.getConfig().get("word.location");
			Location newl = new Location(l1.getWorld(), l1.getX(), l1.getY() - 9, l2.getZ());
			p.getConfig().set("word.offset", newl);
			p.saveConfig();
		}
	}
}
