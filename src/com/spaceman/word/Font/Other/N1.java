package com.spaceman.word.Font.Other;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.spaceman.word.Main;

public class N1 {
	Main p;

	public N1(Main instance) {
		p = instance;
	}

	public void Font() {
		// get all needed info
		ItemStack item = p.getConfig().getItemStack("word.material");
		Material m = item.getType();
		Location l = (Location) p.getConfig().get("word.offset");
		// set all blocks
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY(), l.getBlockZ()).setType(m);

		// saves new offset
		Location newl = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() + 2);
		p.getConfig().set("word.offset", newl);
		p.saveConfig();
	}
}
