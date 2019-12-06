import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class paintPanel extends JPanel {

    private final int bound = 16;
    private int step;

    private int w;
    private int h;

    private Graphics2D g;


    public paintPanel() {
        g = (Graphics2D) super.getGraphics();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            paintAxes();
        }).start();

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                paintPoint(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void paintPoint(MouseEvent e){
        if (g==null){
            g = (Graphics2D) super.getGraphics();
        }
        g.setColor(Color.RED);
        g.fillOval(e.getX(),e.getY(),8,8);
        g.setColor(Color.BLACK);

        Double dStep = Double.valueOf(step);
        Double dX = Double.valueOf(e.getX());
        Double dY = Double.valueOf(e.getY());


        Double x = (e.getX()>w/2) ? (dX-w/2)/dStep : -(w/2-dX)/dStep;
        Double y = (e.getY()>h/2) ? -(dY-h/2)/dStep : (h/2-dY)/dStep;

        System.out.println(x+" "+y);

        Points.addPoint(x,y);
    }

    public void paintAxes(){
        if (g==null){
            g = (Graphics2D) super.getGraphics();
        }

         w = this.getWidth();
         h = this.getHeight();

        g.setStroke(new BasicStroke(2.0f));

        g.drawLine(w/2,0,w/2,h);
        g.drawLine(0,h/2,w,h/2);

         step  = w/(bound*2);

        for (int i=w/2;i<w;i+=step){
            g.drawLine(i,h/2+5,i,h/2-5);
            Integer n = (i-w/2)/step;
            g.drawString(n.toString(),i+2,h/2+13);
        }
        for (int i=w/2;i>0;i-=step){
            g.drawLine(i,h/2+5,i,h/2-5);
            Integer n = (i-w/2)/step;
            g.drawString(n.toString(),i+2,h/2+13);
        }

        for (int i=h/2;i<h;i+=step){
            g.drawLine(w/2+5,i,w/2-5,i);
            Integer n =- (i-h/2)/step;
            g.drawString(n.toString(),w/2+3,i+13);
        }
        for (int i=h/2;i>0;i-=step){
            g.drawLine(w/2+5,i,w/2-5,i);
            Integer n =- (i-h/2)/step;
            g.drawString(n.toString(),w/2+3,i+13);
        }

        g.setStroke(new BasicStroke(1.0f));

        for (int i=w/2;i<w;i+=step){
            g.drawLine(i,0,i,h);
        }
        for (int i=w/2;i>0;i-=step){
            g.drawLine(i,0,i,h);
        }
        for (int i=h/2;i<h;i+=step){
            g.drawLine(0,i,w,i);
        }
        for (int i=h/2;i>0;i-=step){
            g.drawLine(0,i,w,i);
        }






    }

    public void printFunction(Double[] r){
        Double a = r[0];
        Double b = r[1];

        if(g==null){
            g= (Graphics2D) super.getGraphics();
        }

        g.setColor(Color.BLUE);
        g.setStroke(new BasicStroke(2.0f));



    }


}
