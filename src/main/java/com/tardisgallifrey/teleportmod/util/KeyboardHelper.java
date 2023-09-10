package com.tardisgallifrey.teleportmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

//KeyBoard Helper so that we can tell which keys
//user is holding down
public class KeyboardHelper {

    //Get static variable WINDOW from Minecraft Window Instance
    private static final long WINDOW = Minecraft.getInstance()
                            .getWindow().getWindow();

    //method to check for Shift Keys
    //using OpenGL GLFW values from Mojang Blaze3d class
    public static boolean isHoldingShift() {
        return InputConstants
                .isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputConstants
                                    .isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    //Same as above, but for Control Keys
    public static boolean isHoldingControl() {
        return InputConstants
                .isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_CONTROL) || InputConstants
                                    .isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_CONTROL);
    }

    //Same as above, but for Space Bar
    public static boolean isHoldingSpace() {
        return InputConstants.isKeyDown(WINDOW, GLFW.GLFW_KEY_SPACE);
    }
}
