# Astral Client 1.21.11 — Browser Build

This is the simplified Astral PvP/QoL Fabric client.

Included GUI modules:
- Armor HUD
- Coordinates
- Totem Counter
- FPS Display
- Ping Display
- Sprint Toggle
- Fullbright
- Crosshair
- Item Highlight
- Inventory Sorter
- Keybinds

No automated combat modules are included.

## Build without installing Java or Gradle on your PC

1. Create a GitHub repository.
2. Upload the contents of this project.
3. Open **Actions**.
4. Select **Build Astral Client**.
5. Click **Run workflow**.
6. Wait for the build to finish.
7. Open the completed workflow run.
8. Under **Artifacts**, download `AstralClient-JAR`.
9. The downloaded artifact contains the real `.jar`.

The GitHub Actions runner installs Java and Gradle only on the cloud build machine.
