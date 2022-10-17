package org.jcharm.ide.splash;

import org.jcharm.ide.Main;
import org.jcharm.ide.splash.event.SplashScreenDisposeEvent;
import org.jcharm.ide.splash.event.SplashScreenEvent;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {

    public JFrame frame;

    public SplashScreen() {
        Main.eventBus.post(new SplashScreenEvent());
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("JCharm");
        frame.setUndecorated(true);
        frame.setBounds(new Rectangle((int) (size.getWidth()/2-200), (int) (size.getHeight()/2-150),400,300));
        frame.setBackground(new Color(238, 237, 237, 161));
        frame.setVisible(true);
    }

    public void dispose() {
        Main.eventBus.post(new SplashScreenDisposeEvent());
        frame.dispose();
    }
}
