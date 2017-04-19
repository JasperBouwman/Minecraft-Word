package com.spaceman.word.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.spaceman.word.Main;

public class Edit implements CommandExecutor {

	Main p;

	public Edit(Main instance) {
		p = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("must be player to use this");
		}
		
		Player player = (Player) sender;

		if (p.getConfig().contains("word.offset")) {
			if (args.length == 0) {
				player.sendMessage("must specify a material");
			}

			ItemStack paper = p.getConfig().getItemStack("word.paper");
			if (paper.getType().equals("s")) {

			}
			if (args.length == 1) {
				try {
					ItemStack i = new ItemStack(Material.getMaterial(args[0].toUpperCase()));
					if (paper.getType().equals(i.getType())) {
						player.sendMessage("must use another material than the material of the paper");
						return false;
					}
					p.getConfig().set("word.material", i);
					p.saveConfig();
				} catch (NullPointerException NPE) {
					player.sendMessage("given material not found");
				}
			} else if (args.length == 2) {
				try {
					int damage = 0;
					try {
						damage = Integer.parseInt(args[1]);
					} catch (NumberFormatException nfe) {
						player.sendMessage("damage value must be an number");
						return false;
					}
					ItemStack i = new ItemStack(Material.getMaterial(args[0].toUpperCase()), 1, (short) damage);
					if (paper.getType().equals(i.getType())) {
						player.sendMessage("must use another material than the material of the paper");
						return false;
					}
					p.getConfig().set("word.material", i);
					p.saveConfig();
				} catch (NullPointerException NPE) {
					player.sendMessage("given material not found");
				}
			}
		} else {
			player.sendMessage("no document set");
		}
		return false;
	}
}
