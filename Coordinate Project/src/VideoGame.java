public class VideoGame { //only the videoGame class can use the Coordinate class
    //nested class structure is an alternative to using access modifiers
    public class Coordinate {
        final int x;
        //int x; would set the access modifier to default
        final int y;
        //using x y coordinates
        private Coordinate(int x, int y) { //Constructor made private to force user to use factory methods
            this.x = x;
            this.y = y;
        }
        //Factory method using polar coordinates
        public Coordinate fromPolar(int r, int theta) {
            int tempx = (int)(r*Math.cos(theta));
            int tempy = (int)(r*Math.sin(theta));
            return new Coordinate(tempx,tempy);
        }
        //Factory method using x-y
        public Coordinate fromXY(int x, int y) {
            return new Coordinate(x,y);
        }
        //Factory methods need to be static so that they can be accessed without first creating a coordinate
        //(you wouldn't be able to create a coordinate otherwise since the constructor is private)
        @Override public String toString() {
            return "(" + x + ", " + y + ")";
        }
        public double distanceFrom(Coordinate other) {
            return Math.sqrt(Math.pow((other.x-this.x),2)+Math.pow((other.y-this.y),2));
        }
        public double distanceFrom() {
            return distanceFrom(new Coordinate(0,0));
        }
        //when writing a class, you should generally provide:
        //  .equals
        public boolean equals(Coordinate other) {
            return (this.x == other.x && this.y == other.y);
        }
        //  copy constructor
        public Coordinate(Coordinate other) {
            this(other.x,other.y);
        }
        //  hashcode
        public int hashCode() {
            return this.x * 31 + this.y;
        }
    }
}
