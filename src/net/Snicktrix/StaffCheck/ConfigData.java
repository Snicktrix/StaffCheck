package net.Snicktrix.StaffCheck;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;

/**
 * Created by Luke on 8/1/14.
 */
public class ConfigData {
    private StaffCheck staffCheck;

    private ArrayList<String> admins = new ArrayList<String>();
    private ArrayList<String> mods = new ArrayList<String>();
    private ArrayList<String> assistants = new ArrayList<String>();

    private FileConfiguration config;

    public ConfigData (StaffCheck staffCheck) {
        this.staffCheck = staffCheck;
        this.config = this.staffCheck.getConfig();

        this.loadConfig();
    }

    private void loadConfig() {
        //Set up the config
        this.staffCheck.getConfig().options().copyDefaults(true);
        this.staffCheck.saveDefaultConfig();

        //Admins
        for (String name : config.getStringList("Admins")) {
            this.admins.add(name);
            System.out.println("Admin: " + name);
        }
        //Mods
        for (String name : config.getStringList("Mods")) {
            this.mods.add(name);
            System.out.println("Mods: " + name);
        }
        //Assistants
        for (String name : config.getStringList("Assistants")) {
            this.assistants.add(name);
            System.out.println("Assistants: " + name);
        }

    }

    public ArrayList<String> getAdmins() {
        return admins;
    }

    public ArrayList<String> getAssistants() {
        return assistants;
    }

    public ArrayList<String> getMods() {

        return mods;
    }
}

