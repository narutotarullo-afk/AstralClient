package com.astral.client.module;

import net.minecraft.client.MinecraftClient;
import java.util.*;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        add("Armor HUD", "HUD");
        add("Coordinates", "HUD");
        add("Totem Counter", "HUD");
        add("FPS Display", "HUD");
        add("Ping Display", "HUD");
        add("Sprint Toggle", "Player");
        add("Fullbright", "Render");
        add("Crosshair", "Render");
        add("Item Highlight", "Render");
        add("Inventory Sorter", "Utility");
        add("Keybinds", "Utility");
    }

    private void add(String name, String category) {
        modules.add(new Module(name, category, 0));
    }

    public List<Module> all() {
        return Collections.unmodifiableList(modules);
    }

    public void tick(MinecraftClient client) {
        for (Module m : modules) {
            if (m.enabled) m.onTick(client);
        }
    }
}
