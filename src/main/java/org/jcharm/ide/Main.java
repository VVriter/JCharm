package org.jcharm.ide;

import com.puncake.event.EventBus;
import org.jcharm.ide.config.ConfigManager;
import org.jcharm.ide.events.TickEvent;
import org.jcharm.ide.gui.main.MainGui;
import org.jcharm.ide.gui.projectSelector.StartGui;
import org.jcharm.ide.splash.SplashScreen;

public class Main {

    public static EventBus eventBus = new EventBus();
    public static Logger logger = new Logger();

    public static ConfigManager configManager;
    public static SplashScreen splashScreen;

    public static void main(String[] args) {
        logger.log("Starting load JCharm");
        eventBus.register(new Logger());
        logger.log("Registering event system!");

        splashScreen = new SplashScreen();
        configManager = new ConfigManager();

        if (configManager.hasLastProject()) {
            MainGui mainGui = new MainGui(configManager.getLastWorkPath());
            splashScreen.dispose();
        } else {
            StartGui startGui = new StartGui();
            splashScreen.dispose();
        }


        while (true) {
            eventBus.post(new TickEvent());
        }
    }

}