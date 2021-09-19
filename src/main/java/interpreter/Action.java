package interpreter;

import model.LogoModel;
import model.Model;

import java.io.IOException;

public interface Action {
     RegularExpression actionType(String instruction, LogoModel logoModel) throws IOException;
}
