package com.garfild63.coffee;

public class MyCafe {
    int id = 0;
    String name = "";
    Point point = new Point(0, 0);

    public static class Point {
        double latitude;
        double longitude;

        public Point(double latitude,  double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}
