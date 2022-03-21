package com.sao.wallarea;

public class TestWall {
    public static void main(String[] args) {
        Wall wall = new Wall(5,4);
        System.out.println("Area= " + wall.getArea());
        wall.setHeight(-1.5);
        System.out.println("Width= " + wall.getWidth());
        System.out.println("Height= " + wall.getHeight());
        System.out.println("Area= " + wall.getArea());

        Wall wall1 =new Wall(-1.25,-1.25);
        System.out.println(wall1.getArea());
    }
}
