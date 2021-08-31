package model;

public interface Position {

    int getX();
    int getY();
    Orientation getOrientation();
    void setX(int x);
    void setY(int y);
    void setOrientation(Orientation o);
}
