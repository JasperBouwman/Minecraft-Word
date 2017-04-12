package com.spaceman.word.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.spaceman.word.Main;

public class Edit implements CommandExecutor {

	Main p;

	public Edit(Main instance) {
		p = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		return false;
	}
}
