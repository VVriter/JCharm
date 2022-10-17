package org.jcharm.ide;

import com.puncake.event.Listener;
import com.puncake.event.Subscribe;
import org.jcharm.ide.splash.event.SplashScreenDisposeEvent;
import org.jcharm.ide.splash.event.SplashScreenEvent;

public class Logger {

    public String PREFIX;

    public Logger() {
        PREFIX = "[JCHARM-IDE]";
    }

    public void log(String args) {
        System.out.println(PREFIX + " " + args);
    }


    @Subscribe
    public Listener<SplashScreenEvent> splash_screen_is_processing = new Listener<>(e-> {
        log("Splash screen is processing");
    });

    @Subscribe
    public Listener<SplashScreenDisposeEvent> splashScreenDisposeEventListener = new Listener<>(e-> {
        log("Splash screen is disposed");
    });

}
