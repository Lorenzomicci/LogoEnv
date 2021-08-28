package model;

public interface Cursor {
    Position getPosition();
    Orientation rotate(Orientation orient);
}
