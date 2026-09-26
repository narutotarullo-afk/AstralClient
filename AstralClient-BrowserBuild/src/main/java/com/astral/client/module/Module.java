package com.astral.client.module;

import net.minecraft.client.MinecraftClient;

public class Module {
    public final String name;
    public final String category;
    public boolean enabled;
    public int key;

    public Module(String name, String category, int key) {
        this.name = name;
        this.category = category;
        this.key = key;
    }

    public void toggle() {
        enabled = !enabled;
    }

    public void onTick(MinecraftClient client) {
        // QoL modules can add their client-side behavior here.
    }
}
