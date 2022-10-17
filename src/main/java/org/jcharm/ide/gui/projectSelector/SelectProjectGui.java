package org.jcharm.ide.gui.projectSelector;

import org.jcharm.ide.Main;
import org.jcharm.ide.gui.main.MainGui;
import org.jcharm.ide.gui.projectSelector.events.OpenProjectSelectorEvent;
import org.jcharm.ide.gui.projectSelector.events.ProjectSelectorDisposeEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectProjectGui extends JFrame {

    public JFrame frame;

    public SelectProjectGui() {
        Main.eventBus.post(new OpenProjectSelectorEvent());
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("JCharm");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        fileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGui mainGui = new MainGui(fileChooser.getSelectedFile().getPath());
                Main.configManager.setLastProjectPath(fileChooser.getSelectedFile().getPath());
                dispose();
            }
        });

        frame.setBounds(new Rectangle((int) (size.getWidth()/2-250), (int) (size.getHeight()/2-500),500,500));
        frame.add(fileChooser);
        frame.setVisible(true);
    }

    public void dispose() {
        Main.eventBus.post(new ProjectSelectorDisposeEvent());
        frame.dispose();
    }
}
