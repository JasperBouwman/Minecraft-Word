package com.spaceman.word.font.other;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import com.spaceman.word.Main;
import com.spaceman.word.font.EnterChecker;

public class E07 {

	Main p;

	public E07(Main instance) {
		p = instance;
	}

	@SuppressWarnings("deprecation")
	public void Font() {

		EnterChecker ec = new EnterChecker(p);
		ec.EnterLetter(2);

		ItemStack item = p.getConfig().getItemStack("word.material");
		int m = item.getType().getId();
		Location l = (Location) p.getConfig().get("word.offset");

		if (!Bukkit.getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY(), l.getBlockZ() + 2).getType().equals(p.getConfig().getItemStack("word.paper").getType())) {
			p.getConfig().set("word.end", "true");
			return;
		}

		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 8, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 7, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 6, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 3, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 2, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);

		//saves new offset
		Location newl = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() + 2);
		p.getConfig().set("word.offset", newl);
	}
}
