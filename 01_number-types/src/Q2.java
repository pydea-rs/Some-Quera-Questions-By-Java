import java.util.Scanner;

// area between two intersecting circles
public class Q2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String[] firstCircle = scanner.nextLine().trim().split(" ", 3),
                    secondCircle = scanner.nextLine().trim().split(" ", 3);
            scanner.close();

            int x1 = Integer.parseInt(firstCircle[0]), y1 = Integer.parseInt(firstCircle[1]), r1 = Integer.parseInt(firstCircle[2]),
                    x2 = Integer.parseInt(secondCircle[0]), y2 = Integer.parseInt(secondCircle[1]), r2 = Integer.parseInt(secondCircle[2]);

            // Calculation method obtained by: https://diego.assencio.com/?index=8d6ca3d82151bad815f78addf9b5c1c6
            final int dx = x2 - x1, dy = y2 - y1;
            final float d = (float) Math.sqrt(dx * dx + dy * dy), PI = 3.141f;
            float area = 0.0f;

            if(d >= r1 + r2) {
                // means that circles has no intersection
                area = 0.0f;
            }
            else if(d <= Math.abs(r1 - r2)) {
                // one of the circles is inside the other one
                final int innerCircleRadius = r1 >= r2 ? r2 : r1;
                area = innerCircleRadius * innerCircleRadius * PI;
            }
            else {
                // in this case they're connected from sides;
                final float d1 = (r1 * r1 - r2 * r2 + d * d) / (2 * d),
                        d2 = d - d1;
                area = (float) (r1 * r1 * Math.acos(d1 / r1) - d1 * Math.sqrt(r1 * r1 - d1 * d1) +
                                        r2 * r2 * Math.acos(d2 / r2) - d2 * Math.sqrt(r2 * r2 - d2 * d2));
            }
            area = (float) (Math.floor(area * 1000) / 1000); // cut to three decimal digits
            System.out.printf("%.3f%n", area);
        }
        catch(Exception ex) {
            System.out.println("Error! " + ex.toString());
        }
    }
}
