import java.awt.*;

public class Triangle extends Polygon {
    public Triangle(int x0, int y0, int radius, int sides) {
        sides=3;
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            double x = x0 + radius * Math.cos(alpha * i);
            double y = y0 + radius * Math.sin(alpha * i);
            this.addPoint((int) x, (int) y);
        }
    }
}
