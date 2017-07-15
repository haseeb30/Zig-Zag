package lab3;

/**
 * A class that represents two dimensional spatial vectors (a direction and a
 * magnitude). Every vector has a real-valued x-component and a y-component. The
 * class provides some basic mathematical operations such as vector addition and
 * subtraction, and scalar multiplicaton.
 * 
 * @author EECS2030 Fall 2016
 * 
 */
public final class Vector2 {
        private double x;
        private double y;

        public Vector2() {

                this.x = 0.0;

                this.y = 0.0;

        }

        public Vector2(double x, double y) {
                this.x = x;

                this.y = y;
        }

        public Vector2(Vector2 other) {
                this.x = other.getX();
                this.y = other.getY();
        }

        /**
         * Returns the x component of the vector.
         * 
         * @return the x component of the vector.
         */
        public double getX() {
                return this.x;
        }

        public void setX(double x) {
                this.x = x;
        }

        /**
         * Returns the y component of the vector.
         * 
         * @return the y component of the vector.
         */
        public double getY() {
                return this.y;
        }

        public void setY(double y) {
                this.y = y;
        }

        public void set(double x, double y) {
                this.x = x;
                this.y = y;

        }

        public Vector2 add(Vector2 other)

        {
                this.x = this.x + other.getX();

                this.y = this.y + other.getY();

                return new Vector2(this.x, this.y);

        }

        public Vector2 subtract(Vector2 other)

        {

                this.x = this.x - other.getX();

                this.y = this.y - other.getY();

                return new Vector2(this.x, this.y);

        }

        public Vector2 multiply(double s)

        {
                this.x = getX() * s;
                this.y = getY() * s;
                return new Vector2(this.x, this.y);
        }

        public double mag() {

                return Math.sqrt(getX() * getX() + getY() * getY());
        }

        public static Vector2 add(Vector2 a, Vector2 b) {

                double xcor = a.getX() + b.getX();

                double ycor = a.getY() + b.getY();

                return new Vector2(xcor, ycor);

        }

        public static Vector2 subtract(Vector2 a, Vector2 b) {

                double xcor = a.getX() - b.getX();

                double ycor = a.getY() - b.getY();

                return new Vector2(xcor, ycor);

        }

        public static Vector2 multiply(double s, Vector2 a) {
                double xcor = a.getX() * s;

                double ycor = a.getY() * s;

                return new Vector2(xcor, ycor);

        }

        public static Vector2 dirVector(double theta) {

                double x = Math.cos(Math.toRadians(theta));
                double y = Math.sin(Math.toRadians(theta));

                return new Vector2(x, y);
        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                long temp;
                temp = Double.doubleToLongBits(x);
                result = prime * result + (int) (temp ^ (temp >>> 32));
                temp = Double.doubleToLongBits(y);
                result = prime * result + (int) (temp ^ (temp >>> 32));
                return result;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                Vector2 other = (Vector2) obj;
                if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
                        return false;
                if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
                        return false;
                return true;
        }

        public boolean similarTo(Vector2 other, double tol) {
                double g = Math.abs(this.mag() - other.mag());

                if (g < tol) {
                        return true;
                } else {
                        return false;
                }
        }

        /**
         * Returns a string representation of the vector. The string is the name of
         * the vector, followed by the comma separated components of the vector
         * inside parentheses.
         * 
         * @return a string representation of the vector
         */
        @Override
        public String toString() {
                return "(" + this.getX() + ", " + this.getY() + ")";
        }

}