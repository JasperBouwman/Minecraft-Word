package com.spaceman.word.commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.spaceman.word.Fonts;
import com.spaceman.word.Main;

public class Font implements CommandExecutor {
	Main p;

	public Font(Main instance) {
		p = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("must be a player to use this");
			return false;
		}

		Player player = (Player) sender;

		if (args.length == 0) {
			player.sendMessage("must use [add/remove/select]");
			return false;
		}

		if (args[0].equalsIgnoreCase("add")) {
			if (args.length == 2) {
				if (p.getConfig().contains("font." + args[1])) {
					player.sendMessage("font exist");
					return false;
				}
				
				boolean f = new File(p.getDataFolder().toString(), args[1] + ".yml").exists();
				if (f) {
					player.sendMessage("this dont already exist");
					return false;
				}
				
				Fonts txt = new Fonts(p, args[1] + ".yml");
				
				for (int i = 1; i < 9; i++) {
					txt.getConfig().set("a." + i, "XXXXX");
					txt.getConfig().set("b." + i, "XXXXX");
					txt.getConfig().set("c." + i, "XXXXX");
					txt.getConfig().set("d." + i, "XXXXX");
					txt.getConfig().set("e." + i, "XXXXX");
					txt.getConfig().set("f." + i, "XXXXX");
					txt.getConfig().set("g." + i, "XXXXX");
					txt.getConfig().set("h." + i, "XXXXX");
					txt.getConfig().set("i." + i, "XXXXX");
					txt.getConfig().set("j." + i, "XXXXX");
					txt.getConfig().set("k." + i, "XXXXX");
					txt.getConfig().set("l." + i, "XXXXX");
					txt.getConfig().set("m." + i, "XXXXX");
					txt.getConfig().set("n." + i, "XXXXX");
					txt.getConfig().set("o." + i, "XXXXX");
					txt.getConfig().set("p." + i, "XXXXX");
					txt.getConfig().set("q." + i, "XXXXX");
					txt.getConfig().set("r." + i, "XXXXX");
					txt.getConfig().set("s." + i, "XXXXX");
					txt.getConfig().set("t." + i, "XXXXX");
					txt.getConfig().set("u." + i, "XXXXX");
					txt.getConfig().set("v." + i, "XXXXX");
					txt.getConfig().set("w." + i, "XXXXX");
					txt.getConfig().set("x." + i, "XXXXX");
					txt.getConfig().set("y." + i, "XXXXX");
					txt.getConfig().set("z." + i, "XXXXX");

					txt.getConfig().set("A." + i, "XXXXX");
					txt.getConfig().set("B." + i, "XXXXX");
					txt.getConfig().set("C." + i, "XXXXX");
					txt.getConfig().set("D." + i, "XXXXX");
					txt.getConfig().set("E." + i, "XXXXX");
					txt.getConfig().set("F." + i, "XXXXX");
					txt.getConfig().set("G." + i, "XXXXX");
					txt.getConfig().set("H." + i, "XXXXX");
					txt.getConfig().set("I." + i, "XXXXX");
					txt.getConfig().set("J." + i, "XXXXX");
					txt.getConfig().set("K." + i, "XXXXX");
					txt.getConfig().set("L." + i, "XXXXX");
					txt.getConfig().set("M." + i, "XXXXX");
					txt.getConfig().set("N." + i, "XXXXX");
					txt.getConfig().set("O." + i, "XXXXX");
					txt.getConfig().set("P." + i, "XXXXX");
					txt.getConfig().set("Q." + i, "XXXXX");
					txt.getConfig().set("R." + i, "XXXXX");
					txt.getConfig().set("S." + i, "XXXXX");
					txt.getConfig().set("T." + i, "XXXXX");
					txt.getConfig().set("U." + i, "XXXXX");
					txt.getConfig().set("V." + i, "XXXXX");
					txt.getConfig().set("W." + i, "XXXXX");
					txt.getConfig().set("X." + i, "XXXXX");
					txt.getConfig().set("Y." + i, "XXXXX");
					txt.getConfig().set("Z." + i, "XXXXX");

					txt.getConfig().set("1." + i, "XXXXX");
					txt.getConfig().set("2." + i, "XXXXX");
					txt.getConfig().set("3." + i, "XXXXX");
					txt.getConfig().set("4." + i, "XXXXX");
					txt.getConfig().set("5." + i, "XXXXX");
					txt.getConfig().set("6." + i, "XXXXX");
					txt.getConfig().set("7." + i, "XXXXX");
					txt.getConfig().set("8." + i, "XXXXX");
					txt.getConfig().set("9." + i, "XXXXX");
					txt.getConfig().set("0." + i, "XXXXX");
					
					txt.getConfig().set("`." + i, "XXXXX");
					txt.getConfig().set("~." + i, "XXXXX");
					txt.getConfig().set("!." + i, "XXXXX");
					txt.getConfig().set("@." + i, "XXXXX");
					txt.getConfig().set("#." + i, "XXXXX");
					txt.getConfig().set("$." + i, "XXXXX");
					txt.getConfig().set("%." + i, "XXXXX");
					txt.getConfig().set("^." + i, "XXXXX");
					txt.getConfig().set("&." + i, "XXXXX");
					txt.getConfig().set("*." + i, "XXXXX");
					txt.getConfig().set("(." + i, "XXXXX");
					txt.getConfig().set(")." + i, "XXXXX");
					txt.getConfig().set("-." + i, "XXXXX");
					txt.getConfig().set("_." + i, "XXXXX");
					txt.getConfig().set("=." + i, "XXXXX");
					txt.getConfig().set("+." + i, "XXXXX");
					txt.getConfig().set("[." + i, "XXXXX");
					txt.getConfig().set("{." + i, "XXXXX");
					txt.getConfig().set("]." + i, "XXXXX");
					txt.getConfig().set("}." + i, "XXXXX");
					txt.getConfig().set("\\." + i, "XXXXX");
					txt.getConfig().set("|." + i, "XXXXX");
					txt.getConfig().set(";." + i, "XXXXX");
					txt.getConfig().set(":." + i, "XXXXX");
					txt.getConfig().set("'." + i, "XXXXX");
					txt.getConfig().set("\"." + i, "XXXXX");
					txt.getConfig().set(",." + i, "XXXXX");
					txt.getConfig().set("<." + i, "XXXXX");
					txt.getConfig().set("dot." + i, "XXXXX");
					txt.getConfig().set(">." + i, "XXXXX");
					txt.getConfig().set("/." + i, "XXXXX");
					txt.getConfig().set("?." + i, "XXXXX");
					
					txt.getConfig().set("unsupported." + i, "XXXXX");
					
					
				}
				
				txt.saveConfig();
				player.sendMessage("succesfully added the font " + args[1] + " now you have to add the font in the " + args[1] + ".txt");
			} else {
				player.sendMessage("give up a name of your font");
			}
		} else if (args[0].equalsIgnoreCase("select")) {
			
			boolean f = new File(p.getDataFolder().toString(), args[1] + ".yml").exists();
			if (!f) {
				player.sendMessage("this font doesn't exist");
				return false;
			}
			
			p.getConfig().set("word.font", args[1]);
			p.saveConfig();
			player.sendMessage("selected the font " + args[1]);
		}
		
		return false;
	}
}
