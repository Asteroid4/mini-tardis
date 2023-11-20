package dev.enjarai.minitardis.canvas;

import dev.enjarai.minitardis.MiniTardis;
import eu.pb4.mapcanvas.api.core.CanvasImage;
import eu.pb4.mapcanvas.api.core.DrawableCanvas;
import net.fabricmc.loader.api.FabricLoader;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.nio.file.Files;
import java.util.NoSuchElementException;

public class ModCanvasUtils {
    public static final CanvasImage SCREEN_BACKGROUND = loadImage("screen_background.png");
    public static final CanvasImage APP_BACKGROUND = loadImage("app_background.png");
    public static final CanvasImage STATUS_BACKGROUND = loadImage("status_background.png");
    public static final CanvasImage SCREEN_SIDE_BUTTON = loadImage("screen_side_button.png");
    public static final CanvasImage SCREEN_SIDE_BUTTON_PRESSED = loadImage("screen_side_button_pressed.png");
    public static final CanvasImage COORD_WIDGET_X = loadImage("coord_widget_x.png");
    public static final CanvasImage COORD_WIDGET_Z = loadImage("coord_widget_z.png");
    public static final CanvasImage DESTINATION_FACING_WIDGET = loadImage("destination_facing_widget.png");
    public static final CanvasImage CURRENT_FACING_WIDGET = loadImage("current_facing_widget.png");
    public static final CanvasImage SCANNER_APP = loadImage("app/scanner.png");
    public static final CanvasImage GPS_APP = loadImage("app/gps.png");
    public static final CanvasImage BAD_APPLE_APP = loadImage("app/bad_apple.png");
    public static final CanvasImage STATUS_APP = loadImage("app/status.png");

    private static CanvasImage loadImage(String filename) {
        try (var stream = Files.newInputStream(FabricLoader.getInstance().getModContainer(MiniTardis.MOD_ID).orElseThrow()
                .findPath("data/" + MiniTardis.MOD_ID + "/textures/map/" + filename).orElseThrow())) {
            return CanvasImage.from(ImageIO.read(stream));
        } catch (IOException | NoSuchElementException e) {
            MiniTardis.LOGGER.error("Failed to load canvas image " + filename, e);
            return new CanvasImage(16, 16);
        }
    }

    public static void load() {
    }
}