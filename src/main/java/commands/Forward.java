package commands;

import interpreter.Action;
import interpreter.RegularExpression;

import java.util.Enumeration;

public class Forward implements RegularExpression {

    private int number = 0;

    public Forward(int n) {
        this.number = n;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public Action interprete() {
        return null;
    }

}
