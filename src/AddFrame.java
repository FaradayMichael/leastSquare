import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddFrame extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 250;

    public AddFrame(paintPanel paintPanel) throws HeadlessException {
        this.setTitle("Xex");
        this.setResizable(false);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2 - WIDTH / 2;
        int y = screenSize.height / 2 - HEIGHT / 2;
        this.setBounds(x, y, WIDTH, HEIGHT);


        JPanel mainPane = new JPanel(new GridLayout(3,1));
        JTextArea xt = new JTextArea();
        xt.setColumns(35);
        xt.setRows(5);
        JTextArea yt = new JTextArea();
        yt.setColumns(35);
        yt.setRows(5);

        JPanel nPane = new JPanel(new FlowLayout());
        JPanel sPane = new JPanel(new FlowLayout());
        nPane.add(new Label("X:"));
        nPane.add(xt);
        sPane.add(new Label("Y:"));
        sPane.add(yt);
        JButton okBtn = new JButton("Add");
        mainPane.add(nPane);
        mainPane.add(sPane);
        JPanel bPane = new JPanel(new FlowLayout(2));
        bPane.add(new Label(" "));
        bPane.add(okBtn);
        mainPane.add(bPane);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String xStr[] = xt.getText().split(" ");
                String yStr[] = yt.getText().split(" ");
                if (xStr.length==yStr.length) {
                    ArrayList<Double> xList = new ArrayList<Double>();
                    ArrayList<Double> yList = new ArrayList<Double>();

                    for (String s : xStr) {
                        xList.add(Double.parseDouble(s));
                    }
                    for (String s : yStr) {
                        yList.add(Double.parseDouble(s));
                    }

                    for (int i = 0; i < xList.size(); i++) {
                        Points.addPoint(xList.get(i),yList.get(i));
                        System.out.println(String.format("%.2f", xList.get(i)) + " " + String.format("%.2f", yList.get(i)));
                    }

                    paintPanel.paintInputPoints(xList,yList);

                    dispose();
                }

            }
        });



        this.add(mainPane);
        this.setVisible(true);

    }
}
