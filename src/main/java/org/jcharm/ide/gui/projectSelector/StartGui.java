package org.jcharm.ide.gui.projectSelector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGui extends JFrame {

    public JFrame frame;

    public StartGui() {
        frame = new JFrame("JCharm");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(new Rectangle((int) (size.getWidth()/2-250), (int) (size.getHeight()/2-250),500,500));
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        JButton createBtn = new JButton("Create");
        createBtn.setBounds(new Rectangle(500/2-200,500/2-50,100,100));
        frame.add(createBtn);

        JButton openBtn = new JButton("Open");
        openBtn.setBounds(new Rectangle(500/2+100,500/2-50,100,100));
        frame.add(openBtn);


        openBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectProjectGui selectProjectGui = new SelectProjectGui();
                dispose();
            }
        });
    }

    public void dispose() {
        frame.dispose();
    }
}
