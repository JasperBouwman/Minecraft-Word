package com.spaceman.word;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.spaceman.word.commands.Back;
import com.spaceman.word.commands.Cls;
import com.spaceman.word.commands.Delete;
import com.spaceman.word.commands.Edit;
import com.spaceman.word.commands.Enter;
import com.spaceman.word.commands.New;
import com.spaceman.word.commands.Print;

public class Main extends JavaPlugin {

	public void onEnable() {

		getCommand("print").setExecutor(new Print(this));
		getCommand("back").setExecutor(new Back(this));
		getCommand("edit").setExecutor(new Edit(this));
		getCommand("enter").setExecutor(new Enter(this));
		getCommand("new").setExecutor(new New(this));
		getCommand("delete").setExecutor(new Delete(this));
		getCommand("cls").setExecutor(new Cls(this));

		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				if (getConfig().contains("word.offset")) {
					ItemStack item = getConfig().getItemStack("word.material");
					Material m = item.getType();
					Location l = (Location) getConfig().get("word.offset");

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
								Block block = Bukkit.getServer().getWorld(l.getWorld().getName()).getBlockAt(new Location(l.getWorld(), xx, yy, zz));
								if (block.getType() == m) {
									block.setType(getConfig().getItemStack("word.paper").getType());
									block.setData((byte) getConfig().getInt("word.block.damage"));
								} else {
									block.setType(m);
								}
							}
						}
					}
				}
			}
		}, 6, 6);
		
	}
}
