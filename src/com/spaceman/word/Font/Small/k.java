package com.spaceman.word.font.small;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import com.spaceman.word.Main;
import com.spaceman.word.font.EnterChecker;

public class k {
	Main p;

	public k(Main instance) {
		p = instance;
	}

	@SuppressWarnings("deprecation")
	public void Font() {

		EnterChecker ec = new EnterChecker(p);
		ec.EnterLetter(5);

		//get all needed info
		ItemStack item = p.getConfig().getItemStack("word.material");
		int m = item.getType().getId();
		Location l = (Location) p.getConfig().get("word.offset");

		if (!Bukkit.getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY(), l.getBlockZ() + 5).getType().equals(p.getConfig().getItemStack("word.paper").getType())) {
			p.getConfig().set("word.end", "true");
			return;
		}

		//set all blocks
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 7, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 7, l.getBlockZ() + 4).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 6, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 6, l.getBlockZ() + 3).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 5, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 5, l.getBlockZ() + 2).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 4, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 4, l.getBlockZ() + 3).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 3, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 3, l.getBlockZ() + 4).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 2, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);
		Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(l.getBlockX(), l.getBlockY() - 1, l.getBlockZ() + 1).setTypeIdAndData(m, p.getConfig().getItemStack("word.material").getData().getData(), true);

		//saves new offset
		Location newl = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() + 5);
		p.getConfig().set("word.offset", newl);
		p.saveConfig();
	}
}
