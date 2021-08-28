package controller;

import compiler.Expression;

public interface Controller {
    Expression nextInstruction();
    Expression prevInstruction();
    Action computeInstruction();
    void updateView();
}
