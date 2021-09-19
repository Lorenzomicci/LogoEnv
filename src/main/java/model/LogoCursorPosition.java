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
    /**
     * Duo di funzioni di tipo <code>Function</code> per inizializzare i campi necessari alla posizione
     */
    private final Function<Integer,Integer> setPositionX = x -> this.currentX += x;

    private final Function<Integer,Boolean> checkXPos = x -> x > 100;


    /**
     * Inizializzazione di y
      */
    private final Function<Integer,Integer> setPositionY = y -> this.currentY += y;

    private final Function<Integer,Boolean> checkYPos = y -> y > 100;


    /**
     * Inizializzazione dell'orientamento
     */
    private final Function<Orientation,Orientation> setOrientation = o -> this.currentOrientation = o;

    private final Function<Orientation,Boolean> checkOrientation = Objects::nonNull;

    /***************************************************************/

    @Override
    public void setX(int x){
        if(checkXPos.apply(x))
        setPositionX.apply(x);
    }

    @Override
    public void setY(int y){
        if(checkXPos.apply(y))
        setPositionY.apply(y);
    }

    @Override
    public void setOrientation(Orientation o) {
        if(checkOrientation.apply(o))
            setOrientation.apply(o);
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
