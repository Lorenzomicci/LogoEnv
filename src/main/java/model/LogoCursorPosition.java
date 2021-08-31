package model;

import java.util.Objects;
import java.util.function.Function;

public class LogoCursorPosition implements Position {

    private int currentX = 0;
    private int currentY = 0;
    Orientation currentOrientation = Orientation.E;

    /*
    * Functions
    * */
    private final Function<Integer,Integer> setPositionX = x -> this.currentX = x;

    private final Function<Integer,Boolean> checkXPos = x -> x > 100;

    private final Function<Integer, Boolean> setx = checkXPos.compose(setPositionX);



    private final Function<Integer,Integer> setPositionY = y -> this.currentY = y;

    private final Function<Integer,Boolean> checkYPos = y -> y > 100;

    private final Function<Integer,Boolean> sety = checkYPos.compose(setPositionY);



    private final Function<Orientation,Orientation> setOrientation = o -> this.currentOrientation = o;

    private final Function<Orientation,Boolean> checkOrientation = Objects::nonNull;

    private final Function<Orientation,Boolean> setor = checkOrientation.compose(setOrientation);

    /***************************************************************/

    @Override
    public void setX(int x){
        setx.apply(x);
    }

    @Override
    public void setY(int y){
        sety.apply(y);
    }

    @Override
    public void setOrientation(Orientation o) {
        setor.apply(o);
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
