package com.astral.client.module;

import net.minecraft.client.MinecraftClient;
import java.util.*;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        add("Crystal Macro", "Crystal", 0);
        add("Anchor Macro", "Anchor", 0);
        add("Spear Macro", "Combat", 0);
        add("Lunge Macro", "Combat", 0);
        add("Creeper PvP Macro", "Combat", 0);
        add("Trigger Bot", "Combat", 0);
        add("Auto Crystal", "Crystal", 0);
        add("Auto Anchor", "Anchor", 0);
        add("Auto Totem", "Player", 0);
        add("Surround", "Combat", 0);
        add("Anti Crystal", "Combat", 0);
        add("Hole Fill", "Combat", 0);
        add("Self Trap", "Combat", 0);
        add("Auto Trap", "Combat", 0);
        add("Web Aura", "Combat", 0);
        add("Inventory Manager", "Player", 0);
        add("Offhand Manager", "Player", 0);
        add("Totem Counter", "HUD", 0);
        add("Pearl Macro", "Utility", 0);
        add("Potion Macro", "Utility", 0);
        add("Sprint", "Player", 0);
        add("Fullbright", "Render", 0);
        add("Armor HUD", "HUD", 0);
        add("Coordinates", "HUD", 0);
    }

    private void add(String name, String category, int key) {
        modules.add(new Module(name, category, key));
    }

    public List<Module> all() { return Collections.unmodifiableList(modules); }

    public void tick(MinecraftClient client) {
        for (Module m : modules) if (m.enabled) m.onTick(client);
    }
}
