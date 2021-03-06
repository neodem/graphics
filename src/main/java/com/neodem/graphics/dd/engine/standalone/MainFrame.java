package com.neodem.graphics.dd.engine.standalone;

import com.neodem.graphics.dd.engine.common.Color;
import com.neodem.graphics.dd.engine.core.ActiveCanvas;
import com.neodem.graphics.dd.engine.core.AppFrame;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

    private static final int APP_WIDTH = 800;
    private static final int APP_HEIGHT = 600;
    private static final String APP_NAME = "Rays";

    private MainFrame() {
        ActiveCanvas panel = new TestCanvas(APP_WIDTH, APP_HEIGHT, Color.lightGray);
        AppFrame appFrame = new AppFrame(APP_NAME, panel);
        appFrame.start();
    }

    public static void main(String argv[]) {
        new MainFrame();
    }
}
