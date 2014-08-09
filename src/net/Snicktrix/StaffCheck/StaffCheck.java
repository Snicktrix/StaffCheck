package net.Snicktrix.StaffCheck;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

/**
 * Created by Luke on 8/1/14.
 */
public class StaffCheck extends JavaPlugin {
    private ConfigData configData;

    @Override
    public void onEnable() {
        this.configData = new ConfigData(this);
        System.out.println("Enabled Staff Check");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (command.getName().equalsIgnoreCase("staff")) {
            this.showStaff(sender);
        }
        return false;
    }

    private void showStaff(CommandSender sender) {

        //We need to find which players are actually online from the list
        ArrayList<String> onlineAdmins = new ArrayList<String>();
        for (String admin : this.configData.getAdmins()) {
            if (Bukkit.getPlayerExact(admin) != null) {
                onlineAdmins.add(admin);
            }
        }
        ArrayList<String> onlineMods = new ArrayList<String>();
        for (String mod : this.configData.getMods()) {
            if (Bukkit.getPlayerExact(mod) != null) {
                onlineMods.add(mod);
            }
        }
        ArrayList<String> onlineAssistants = new ArrayList<String>();
        for (String assistant : this.configData.getAssistants()) {
            if (Bukkit.getPlayerExact(assistant) != null) {
                onlineAssistants.add(assistant);
            }
        }

        //We have all of our online players
        //Time to display them

        //Lets format our ArrayLists into a nice string message
        String onlineAdminMessage = ChatColor.RED + "Admins: ";
        for (String s : onlineAdmins)
        {
            onlineAdminMessage += ChatColor.GREEN + s + ChatColor.WHITE + ", ";
        }
        String onlineModMessage = ChatColor.YELLOW + "Mods: ";
        for (String s : onlineMods)
        {
            onlineModMessage += ChatColor.GREEN + s + ChatColor.WHITE + ", ";
        }
        String onlineAssistantMessage = ChatColor.BLUE + "Assistants: ";
        for (String s : onlineAssistants)
        {
            onlineAssistantMessage += ChatColor.GREEN + s + ChatColor.WHITE + ", ";
        }

        //Nice title message
        sender.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString()
                + "<-+-> Staff Check <-+->");

        //Finally, we can display the message
        sender.sendMessage(onlineAdminMessage);
        sender.sendMessage(onlineModMessage);
        sender.sendMessage(onlineAssistantMessage);

        //The End :)
    }
}
