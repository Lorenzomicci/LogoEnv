package commands;

import controller.LogoController;
import interpreter.RegularExpression;
import model.LogoModel;
import model.Orientation;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Forward implements RegularExpression {

    private static final Logger LOGGER = Logger.getLogger( LogoController.class.getName() );

    private int number = 0;
    private LogoModel lm;

    public Forward(int n, LogoModel logoModel) throws IOException {
        this.number = n;
        lm = logoModel;
        FileHandler filehandler = new FileHandler("src/main/java/CommandsLog/instructions.log",true);
        LOGGER.addHandler(filehandler);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public void interprete() {
        interpreteInstruction();
        LOGGER.info("Forward " + this.number);
        System.out.println("Forward" + this.number);
    }

    private void  interpreteInstruction() {
        if (this.lm.getCursorState().getPosition().getOrientation() == Orientation.N ||
                this.lm.getCursorState().getPosition().getOrientation() == Orientation.S)
             lm.getCursorState().getPosition().setY(this.number);

        if (this.lm.getCursorState().getPosition().getOrientation() == Orientation.E ||
                this.lm.getCursorState().getPosition().getOrientation() == Orientation.W)
            lm.getCursorState().getPosition().setX(this.number);

    }

}
