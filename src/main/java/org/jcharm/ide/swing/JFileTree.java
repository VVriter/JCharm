package org.jcharm.ide.swing;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import java.io.File;

public class JFileTree extends JTree {
    public JFileTree(String path) {
        super(scan(new File(path)));
    }

    private static MutableTreeNode scan(File node) {
        DefaultMutableTreeNode ret = new DefaultMutableTreeNode(node.getName());
        if (node.isDirectory())
            for (File child: node.listFiles())
                ret.add(scan(child));
        return ret;
    }
}