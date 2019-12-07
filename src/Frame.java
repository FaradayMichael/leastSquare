import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private static final int WIDTH = 800;
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

        JLabel resLabel = new JLabel();

        JPanel mainPane = new JPanel(new BorderLayout());
        paintPanel = new paintPanel();
        toolPane = new JPanel(new FlowLayout(3));

        JButton approximate = new JButton("Approximate");
        approximate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Points.size>2) {
                    resLabel.setText(paintPanel.printFunction(Points.lSM()));
                }
            }
        });
        JButton cleanBtn = new JButton("Clean");
        cleanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Points.clean();
                mainPane.remove(paintPanel);
                paintPanel = new paintPanel();
                mainPane.add(paintPanel, BorderLayout.CENTER);
                resLabel.setText("");
                mainPane.updateUI();
            }
        });
        JButton addPointsBtn = new JButton("Add points");
        addPointsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddFrame(paintPanel);
            }
        });

        toolPane.add(approximate);
        toolPane.add(cleanBtn);
        toolPane.add(addPointsBtn);
        toolPane.add(resLabel);

        mainPane.add(toolPane, BorderLayout.SOUTH);
        mainPane.add(paintPanel, BorderLayout.CENTER);

        this.add(mainPane);
        this.setVisible(true);
    }
}
