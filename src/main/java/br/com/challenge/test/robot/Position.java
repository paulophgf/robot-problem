package br.com.challenge.test.robot;

import java.util.Objects;

public class Position {

    private int x;
    private int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void increaseX() {
        this.x++;
    }

    public void decreaseX() {
        this.x--;
    }

    public int getY() {
        return y;
    }

    public void increaseY() {
        this.y++;
    }

    public void decreaseY() {
        this.y--;
    }


    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Position position = (Position) o;
        if(position != null){
            return this.getX() == position.getX() && this.getY() == position.getY();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
