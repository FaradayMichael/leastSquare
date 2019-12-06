import java.util.ArrayList;

public class main {

    public static void main(String[] args) {


        Frame f = new Frame();


        /*Double r[] = primer1();

        String a = String.format("%.3f",r[0]);
        String b = String.format("%.3f",r[1]);

        System.out.println("y = "+a+"x + "+b);*/
    }


    public static Double[] primer1(){
        /*
        X: 0,   1,    2,    4,   5
        Y: 2.1, 2.4,  2.6,  2.8  3.0
         */

        ArrayList<Double> listX = new ArrayList<Double>();
        listX.add(0.0);
        listX.add(1.0);
        listX.add(2.0);
        listX.add(4.0);
        listX.add(5.0);

        ArrayList<Double> listY = new ArrayList<Double>();
        listY.add(2.1);
        listY.add(2.4);
        listY.add(2.6);
        listY.add(2.8);
        listY.add(3.0);

        return lSM(listX,listY);
    }


    public static Double[] lSM(ArrayList<Double> listX, ArrayList<Double> listY){

        ArrayList<Double> listXY = new ArrayList<Double>();
        for (int i = 0;i<listX.size();i++){
            listXY.add(listX.get(i)*listY.get(i));
        }

        ArrayList<Double> listXX = new ArrayList<Double>();
        for (int i = 0;i<listX.size();i++){
            listXX.add(listX.get(i)*listX.get(i));
        }

        int n = listX.size();

        Double summX = 0.0;
        for (Double d:listX){
            summX = summX + d;
        }

        Double summY = 0.0;
        for (Double d:listY){
            summY = summY + d;
        }

        Double summXY = 0.0;
        for (Double d:listXY){
            summXY = summXY + d;
        }

        Double summXX = 0.0;
        for (Double d:listXX){
            summXX = summXX + d;
        }
        System.out.println(summX+"\n"+summY+"\n"+summXY+"\n"+summXX+"\n"+n);

        Double a = (n*summXY-summX*summY)/(n*summXX-summX*summX);
        Double b = (summY-a*summX)/5;

        Double res[] = new Double[2];
        res[0]=a;
        res[1]=b;

        return res;

    }



}
