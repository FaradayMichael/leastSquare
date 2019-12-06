import java.util.ArrayList;

public class Points {

    public static ArrayList<Double> listX = new ArrayList<Double>();
    public static ArrayList<Double> listY = new ArrayList<Double>();
    public static int size = 0;

    public static void addPoint(Double x, Double y) {
        listX.add(x);
        listY.add(y);
        size++;
    }

    public static void clean() {
        listX.clear();
        listY.clear();
        size = 0;
    }

    public static Double[] lSM() {
        ArrayList<Double> listXY = new ArrayList<Double>();
        for (int i = 0; i < listX.size(); i++) {
            listXY.add(listX.get(i) * listY.get(i));
        }

        ArrayList<Double> listXX = new ArrayList<Double>();
        for (int i = 0; i < listX.size(); i++) {
            listXX.add(listX.get(i) * listX.get(i));
        }

        int n = listX.size();

        Double summX = 0.0;
        for (Double d : listX) {
            summX = summX + d;
        }

        Double summY = 0.0;
        for (Double d : listY) {
            summY = summY + d;
        }

        Double summXY = 0.0;
        for (Double d : listXY) {
            summXY = summXY + d;
        }

        Double summXX = 0.0;
        for (Double d : listXX) {
            summXX = summXX + d;
        }
        //System.out.println(summX+"\n"+summY+"\n"+summXY+"\n"+summXX+"\n"+n);

        Double a = (n * summXY - summX * summY) / (n * summXX - summX * summX);
        Double b = (summY - a * summX) / 5;

        Double res[] = new Double[2];
        res[0] = a;
        res[1] = b;

        System.out.println("y = " + String.format("%.2f", res[0]) + ((b > 0) ? ("x + " + String.format("%.2f", res[1])) : ("x - " + String.format("%.2f", -res[1]))));

        return res;
    }
}
