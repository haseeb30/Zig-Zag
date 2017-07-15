package lab3;

public class SpiroUtil {
    public static final double BIG_WHEEL_RADIUS = 1.0;

    public static double hypoX(double wheelRadius, double pencilRadius, double degrees) {
        if (wheelRadius < 0.0) {
            throw new IllegalArgumentException("wheel radius is negative");
        }
        if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
            throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
        }
        if (pencilRadius < 0.0) {
            throw new IllegalArgumentException("pencil radius is negative");
        }
        if (pencilRadius > wheelRadius) {
            throw new IllegalArgumentException("pencil radius is greater than wheel radius");
        }

        double answer = ((SpiroUtil.BIG_WHEEL_RADIUS - wheelRadius) * Math.cos(Math.toRadians(degrees))) + pencilRadius
                * Math.cos((Math.toRadians((SpiroUtil.BIG_WHEEL_RADIUS - wheelRadius) * degrees) / wheelRadius));
        return answer;

    }

    public static double hypoY(double wheelRadius, double pencilRadius, double degrees) {
        if (wheelRadius < 0.0) {
            throw new IllegalArgumentException("wheel radius is negative");
        }
        if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
            throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
        }
        if (pencilRadius < 0.0) {
            throw new IllegalArgumentException("pencil radius is negative");
        }
        if (pencilRadius > wheelRadius) {
            throw new IllegalArgumentException("pencil radius is greater than wheel radius");
        }

        double answer = (SpiroUtil.BIG_WHEEL_RADIUS - wheelRadius) * Math.sin(Math.toRadians(degrees)) - pencilRadius
                * Math.sin(Math.toRadians(degrees * (SpiroUtil.BIG_WHEEL_RADIUS - wheelRadius) / wheelRadius));
        return answer;

    }

    public static Point2 hypo(double wheelRadius, double pencilRadius, double degrees) {
        if (wheelRadius < 0.0) {
            throw new IllegalArgumentException("wheel radius is negative");
        }
        if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
            throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
        }
        if (pencilRadius < 0.0) {
            throw new IllegalArgumentException("pencil radius is negative");
        }
        if (pencilRadius > wheelRadius) {
            throw new IllegalArgumentException("pencil radius is greater than wheel radius");
        }

        return new Point2(SpiroUtil.hypoX(wheelRadius, pencilRadius, degrees),
                SpiroUtil.hypoY(wheelRadius, pencilRadius, degrees));
    }

}
