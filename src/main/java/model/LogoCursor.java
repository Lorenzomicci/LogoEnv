package model;

import java.util.function.Function;

public class LogoCursor implements Cursor {

    Position currentPos;

    public LogoCursor() {
        currentPos = new LogoCursorPosition();
    }

    public Orientation retOr() {
       return currentPos.getOrientation();
    }

    @Override
    public Position getPosition() {
        return this.currentPos;
    }

    @Override
    public void rotate(Orientation orient) {
       currentPos.setOrientation(orient);
    }

    public final Function<LogoCursor,Orientation> retOri = LogoCursor::retOr;

    public static void main(String[] args) {

    }

}
