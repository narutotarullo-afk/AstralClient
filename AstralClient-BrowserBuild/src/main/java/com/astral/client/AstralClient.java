package com.astral.client;

import com.astral.client.gui.AstralScreen;
import com.astral.client.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class AstralClient implements ClientModInitializer {
    public static ModuleManager MODULES;
    private static KeyBinding menuKey;

    @Override
    public void onInitializeClient() {
        MODULES = new ModuleManager();

        menuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.astralclient.menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.astralclient"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            MODULES.tick(client);
            while (menuKey.wasPressed()) {
                client.setScreen(new AstralScreen());
            }
        });
    }
}
