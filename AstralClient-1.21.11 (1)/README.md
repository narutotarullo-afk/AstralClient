# Astral Client — Minecraft 1.21.11

Fabric client project with a dark purple/pink CPvP ClickGUI and module framework.

## Build
1. Install Java 21.
2. Install Gradle 8.x (or import the project into IntelliJ IDEA and use Gradle).
3. Run `gradle build`.
4. Put `build/libs/astral-client-1.0.0.jar` in `.minecraft/mods`.
5. Install Fabric Loader for Minecraft 1.21.11 and Fabric API 0.141.6+1.21.11.
6. Press **Right Shift** in-game.

## Included module entries
Crystal Macro, Anchor Macro, Spear Macro, Lunge Macro, Creeper PvP Macro, Trigger Bot,
Auto Crystal, Auto Anchor, Auto Totem, Surround, Anti Crystal, Hole Fill, Self Trap,
Auto Trap, Web Aura, Inventory Manager, Offhand Manager, Totem Counter, Pearl Macro,
Potion Macro, Sprint, Fullbright, Armor HUD, Coordinates.

The first build is the UI/module framework. The named CPvP modules are registered and toggleable;
their detailed game-action logic should be implemented and tested individually rather than blindly
automating combat on public servers.
