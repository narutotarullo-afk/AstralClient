package com.astral.client.gui;

import com.astral.client.AstralClient;
import com.astral.client.module.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AstralScreen extends Screen {
    private final Set<String> categories = new LinkedHashSet<>();
    private String selected = "Combat";
    private int left = 30, top = 30;

    public AstralScreen() {
        super(Text.literal("Astral Client"));
        for (Module m : AstralClient.MODULES.all()) categories.add(m.category);
    }

    @Override
    protected void init() {}

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        int w = this.width, h = this.height;
        ctx.fill(0, 0, w, h, 0xE90A0A10);
        ctx.fill(left, top, w - 30, h - 30, 0xF010101A);
        ctx.fill(left, top, left + 170, h - 30, 0xFF0B0B13);
        ctx.drawTextWithShadow(textRenderer, Text.literal("ASTRAL"), left + 22, top + 18, 0xFFFF4FA3);
        ctx.drawTextWithShadow(textRenderer, Text.literal("CPVP CLIENT"), left + 22, top + 34, 0xFF9B7CFF);

        int y = top + 65;
        for (String cat : categories) {
            int color = cat.equals(selected) ? 0xFF8A2BE2 : 0xFFB8B8C8;
            if (cat.equals(selected)) ctx.fill(left + 10, y - 4, left + 160, y + 17, 0xFF241336);
            ctx.drawTextWithShadow(textRenderer, Text.literal(cat), left + 22, y, color);
            y += 25;
        }

        int panelX = left + 190;
        ctx.drawTextWithShadow(textRenderer, Text.literal(selected), panelX, top + 20, 0xFFFFFFFF);
        ctx.drawTextWithShadow(textRenderer, Text.literal("Right Shift = GUI"), panelX + 110, top + 20, 0xFF777788);

        int my = top + 55;
        for (Module m : AstralClient.MODULES.all()) {
            if (!m.category.equals(selected)) continue;
            int box = m.enabled ? 0xFF351A4A : 0xFF181820;
            ctx.fill(panelX, my, panelX + 300, my + 28, box);
            ctx.drawTextWithShadow(textRenderer, Text.literal(m.name), panelX + 10, my + 9, m.enabled ? 0xFFFF4FA3 : 0xFFD0D0DD);
            ctx.drawTextWithShadow(textRenderer, Text.literal(m.enabled ? "ON" : "OFF"), panelX + 260, my + 9, m.enabled ? 0xFFB000FF : 0xFF666677);
            my += 34;
        }
        super.render(ctx, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button != GLFW.GLFW_MOUSE_BUTTON_LEFT) return super.mouseClicked(mouseX, mouseY, button);
        int y = top + 65;
        for (String cat : categories) {
            if (mouseX >= left + 10 && mouseX <= left + 160 && mouseY >= y - 4 && mouseY <= y + 17) {
                selected = cat;
                return true;
            }
            y += 25;
        }

        int panelX = left + 190, my = top + 55;
        for (Module m : AstralClient.MODULES.all()) {
            if (!m.category.equals(selected)) continue;
            if (mouseX >= panelX && mouseX <= panelX + 300 && mouseY >= my && mouseY <= my + 28) {
                m.toggle();
                return true;
            }
            my += 34;
        }
        return true;
    }

    @Override
    public boolean shouldPause() { return false; }
}
