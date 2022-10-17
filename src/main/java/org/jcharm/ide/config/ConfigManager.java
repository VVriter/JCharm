package org.jcharm.ide.config;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.jcharm.ide.Main;
import org.jcharm.ide.config.event.CreateConfigFolderEvent;

import java.io.*;

public class ConfigManager {

    private final File CONFIG_FILE = new File("./run/");
    private final File CONFIG_LAST_PROJECT_FOLDER = new File("./run/last");

    public ConfigManager() {
        if (!CONFIG_FILE.exists()) {
            Main.eventBus.post(new CreateConfigFolderEvent());
            CONFIG_FILE.mkdir();
            CONFIG_LAST_PROJECT_FOLDER.mkdir();
        }
    }

    private final File LAST_PROJECT_FILE = new File("./run/last/project.txt");

    public boolean hasLastProject() {
        return LAST_PROJECT_FILE.exists();
    }

    public void setLastProjectPath(String lastProjectPath) {
        if (!LAST_PROJECT_FILE.exists()) {
            try {
                LAST_PROJECT_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                FileWriter writer = new FileWriter(LAST_PROJECT_FILE.getPath());
                writer.write(lastProjectPath);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            LAST_PROJECT_FILE.delete();
            try {
                LAST_PROJECT_FILE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                FileWriter writer = new FileWriter(LAST_PROJECT_FILE.getPath());
                writer.write(lastProjectPath);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Getter
    public String getLastWorkPath() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(LAST_PROJECT_FILE));
            return br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
