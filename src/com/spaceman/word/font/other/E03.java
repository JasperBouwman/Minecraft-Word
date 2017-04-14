package com.spaceman.word.font.other;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.spaceman.word.Main;
import com.spaceman.word.font.EnterChecker;

public class E03 {

	Main p;

	public E03(Main instance) {
		p = instance;
	}

	public void Font() {
		
		EnterChecker ec = new EnterChecker(p);
		ec.EnterLetter(2);

		ItemStack item = p.getConfig().getItemStack("word.material");
		Material m = item.getType();
		Location l = (Location) p.getConfig().get("word.offset");
		
		if (!Bukkit.getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY(), l.getBlockZ() + 2).getType().equals(p.getConfig().getItemStack("word.paper").getType())) {
			p.getConfig().set("word.end", "true");
			return;
		}
		
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 7, l.getBlockZ() + 1).setType(m);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 6, l.getBlockZ() + 1).setType(m);

		//saves new offset
		Location newl = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() + 2);
		p.getConfig().set("word.offset", newl);
	}
}