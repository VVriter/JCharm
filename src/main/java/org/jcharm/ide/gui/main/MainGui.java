package org.jcharm.ide.gui.main;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.jcharm.ide.swing.JFileTree;

import javax.swing.*;
import java.awt.*;

public class MainGui extends JFrame {

    private String WORK_PATH;
    public MainGui(String path) {
        this.WORK_PATH = path;

        JFrame frame = new JFrame("JCharm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(new Rectangle(0,0, (int) size.getWidth(), (int) size.getHeight()));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        JFileTree fileTree = new JFileTree(getPath());
        frame.add(fileTree);

        frame.setVisible(true);
    }

    @Getter
    public String getPath() {
        return WORK_PATH;
    }
}
