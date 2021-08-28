package model;

import java.util.function.Function;

public class LogoCursorPosition implements Position {

    private int currentX = 0;
    private int currentY = 0;
    Orientation currentOrientation = Orientation.E;

    Function<Integer,Integer> setPositionX = x -> this.currentX = x;
    Function<Integer,Integer> setPositionY = y -> this.currentY = y;

    public void setX(int x){
        setPositionX.apply(x);
    }

    public void setY(int y){
        setPositionY.apply(y);
    }

    @Override
    public int getX() {
        return this.currentX;
    }

    @Override
    public int getY() {
        return this.currentY;
    }

    @Override
    public Orientation getOrientation() {
        return this.currentOrientation;
    }
}
