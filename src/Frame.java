import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;

    private paintPanel paintPanel;
    private JPanel toolPane;


    public Frame() throws HeadlessException {
        this.setTitle("Xex");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2 - WIDTH / 2;
        int y = screenSize.height / 2 - HEIGHT / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);

        JPanel mainPane = new JPanel(new BorderLayout());
        paintPanel = new paintPanel();
        toolPane = new JPanel(new FlowLayout());


        JButton p = new JButton("sss");
        toolPane.add(p);






        mainPane.add(toolPane,BorderLayout.SOUTH);
        mainPane.add(paintPanel, BorderLayout.CENTER);

        this.add(mainPane);
        this.setVisible(true);


    }
}
