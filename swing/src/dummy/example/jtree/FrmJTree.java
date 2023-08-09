package dummy.example.jtree;


import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

/**
 * @saozdemir
 * @Hv.Müh.Ütğm
 */
public class FrmJTree extends JFrame {
    private JTree tree;

    public FrmJTree() throws HeadlessException {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(300, 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        initTree();
    }

    private void initTree() {
        tree = new JTree(createTree());
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        this.add(new JScrollPane(tree), BorderLayout.CENTER);
        actions();
    }

    private void actions() {
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node =
                        (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                String userObject = (String) node.getUserObject();

                System.out.println(userObject );
            }
        });
    }

    private DefaultMutableTreeNode createTree() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Servers");

        DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("USA");
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("Boston");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("New York");
        DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("Los Angeles");

        branch1.add(node1);
        branch1.add(node2);
        branch1.add(node3);

        DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("TR");
        DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("İstanbul");
        DefaultMutableTreeNode node5 = new DefaultMutableTreeNode("İzmir");
        DefaultMutableTreeNode node6 = new DefaultMutableTreeNode("Ankara");
        DefaultMutableTreeNode node7 = new DefaultMutableTreeNode("Bursa");

        branch2.add(node4);
        branch2.add(node5);
        branch2.add(node6);
        branch2.add(node7);


        top.add(branch1);
        top.add(branch2);

        return top;
    }
}
