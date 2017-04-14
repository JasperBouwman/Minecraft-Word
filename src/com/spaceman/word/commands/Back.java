package com.spaceman.word.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.spaceman.word.Main;
import com.spaceman.word.Font.CursorRemove;

public class Back implements CommandExecutor {

	Main p;

	public Back(Main instance) {
		p = instance;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		int intloop = 0;

		if (args.length == 1) {

			try {
				intloop = Integer.parseInt(args[0]) - 1;
			} catch (NumberFormatException nfe) {
				player.sendMessage("back time must be an number");
				return false;
			}

		}
		for (int i4 = 0; i4 <= intloop; i4++) {
			if (p.getConfig().contains("word.offset")) {

				Location l = (Location) p.getConfig().get("word.offset");

				ItemStack item = p.getConfig().getItemStack("word.material");
				Material m = item.getType();

				boolean blocks = true;

				for (int i = 1; i <= 2; i++) {

					Location L1 = new Location(l.getWorld(), l.getX(), l.getY() - 1, l.getZ() - i);
					Location L2 = new Location(l.getWorld(), l.getX(), l.getY() - 8, l.getZ() - i);

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

								if (block.getType().equals(m)) {
									blocks = false;
								}
								if (block.getType().equals(Material.AIR)) {

									Location a = (Location) p.getConfig().get("word.location");
									Location Lenter = new Location(l.getWorld(), l.getX(), l.getY() + 9,
											a.getZ() + 200);

									if (Bukkit.getWorld(l.getWorld().getName()).getBlockAt(Lenter).getType()
											.equals(Material.AIR)) {
										player.sendMessage("end of file, couldn't backspace");
										return false;
									}

									CursorRemove CR = new CursorRemove(p);
									CR.Cursor();
									int i3 = 0;
									boolean loop = true;
									boolean material = false;

									while (loop) {

										boolean bool = true;

										Location L13 = Lenter;
										Location L23 = new Location(l.getWorld(), Lenter.getX(), Lenter.getY() - 8, Lenter.getZ() - i3);

										int minX3 = Math.min(L13.getBlockX(), L23.getBlockX());
										int minY3 = Math.min(L13.getBlockY(), L23.getBlockY());
										int minZ3 = Math.min(L13.getBlockZ(), L23.getBlockZ());
										int maxX3 = Math.max(L13.getBlockX(), L23.getBlockX());
										int maxY3 = Math.max(L13.getBlockY(), L23.getBlockY());
										int maxZ3 = Math.max(L13.getBlockZ(), L23.getBlockZ());

										for (int xx3 = minX3; xx3 <= maxX3; xx3++) {
											for (int yy3 = minY3; yy3 <= maxY3; yy3++) {
												for (int zz3 = minZ3; zz3 <= maxZ3; zz3++) {
													Block block3 = Bukkit.getServer().getWorld(l.getWorld().getName())
															.getBlockAt(new Location(l.getWorld(), xx3, yy3, zz3));

													if (block3.getType().equals(Material.AIR)) {
														Location ln = (Location) p.getConfig().get("word.offset");
														Location newl = new Location(ln.getWorld(), ln.getX(),
																ln.getY() + 9, a.getZ());
														p.getConfig().set("word.offset", newl);
														p.saveConfig();
														player.sendMessage("enter removed");
														loop = false;
														return false;
													}

													if (block3.getType().equals(
															p.getConfig().getItemStack("word.material").getType())) {
														material = true;
													} else if (bool) {
														i3++;
														bool = false;
													}
												}
											}
										}
										if (material) {
											loop = false;

											Location ln = (Location) p.getConfig().get("word.offset");
											Location newl = new Location(ln.getWorld(), ln.getX(), ln.getY() + 9,
													a.getZ() - i3 + 202);
											p.getConfig().set("word.offset", newl);
											p.saveConfig();
											player.sendMessage("enter removed");
										}
									}

									return false;
								}
							}
						}
					}
				}

				if (blocks) {
					// Cursor();
					CursorRemove CR = new CursorRemove(p);
					CR.Cursor();
					Location newl = new Location(l.getWorld(), l.getX(), l.getY(), l.getZ() - 2);
					p.getConfig().set("word.offset", newl);
					p.saveConfig();
					player.sendMessage("space removed");

				} else {
					// Cursor();
					CursorRemove CR = new CursorRemove(p);
					CR.Cursor();
					int i = 1;
					boolean loop = true;

					while (loop) {

						boolean loop2 = true;
						int ii = 0;

						Location L1 = new Location(l.getWorld(), l.getX(), l.getY() - 1, l.getZ() - i);
						Location L2 = new Location(l.getWorld(), l.getX(), l.getY() - 8, l.getZ() - i);

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

									if (block.getType().equals(p.getConfig().getItemStack("word.material").getType())
											&& loop2) {
										i++;
										loop2 = false;
									} else {
										ii++;
									}
								}
							}
						}
						if (ii == 8) {
							loop = false;

							Location L12 = new Location(l.getWorld(), l.getX(), l.getY() - 1, l.getZ() - i + 1);
							Location L22 = new Location(l.getWorld(), l.getX(), l.getY() - 8, l.getZ());

							int minX2 = Math.min(L12.getBlockX(), L22.getBlockX());
							int minY2 = Math.min(L12.getBlockY(), L22.getBlockY());
							int minZ2 = Math.min(L12.getBlockZ(), L22.getBlockZ());
							int maxX2 = Math.max(L12.getBlockX(), L22.getBlockX());
							int maxY2 = Math.max(L12.getBlockY(), L22.getBlockY());
							int maxZ2 = Math.max(L12.getBlockZ(), L22.getBlockZ());

							for (int xx2 = minX2; xx2 <= maxX2; xx2++) {
								for (int yy2 = minY2; yy2 <= maxY2; yy2++) {
									for (int zz2 = minZ2; zz2 <= maxZ2; zz2++) {
										Block block = Bukkit.getServer().getWorld(l.getWorld().getName())
												.getBlockAt(new Location(l.getWorld(), xx2, yy2, zz2));
										
										block.setType(p.getConfig().getItemStack("word.paper").getType());
										block.setData((byte) p.getConfig().getInt("word.block.damage"));
									}
								}
							}
							Location ln = (Location) p.getConfig().get("word.offset");
							Location newl = new Location(ln.getWorld(), ln.getX(), ln.getY(), ln.getZ() - i);
							p.getConfig().set("word.offset", newl);
							p.saveConfig();
							player.sendMessage("letter removed");
						}
					}
				}
			}
		}
		return false;
	}
}