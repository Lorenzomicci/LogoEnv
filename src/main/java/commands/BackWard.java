package commands;

import controller.LogoController;
import interpreter.RegularExpression;
import model.LogoModel;
import model.Orientation;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class BackWard implements RegularExpression {

    private static final Logger LOGGER = Logger.getLogger( LogoController.class.getName() );

    private int number = 0;
    private LogoModel lm;

    public BackWard(int n, LogoModel logoModel) throws IOException {
        this.number = n;
        this.lm = logoModel;
        FileHandler filehandler = new FileHandler("src/main/java/CommandsLog/instructions.log",true);
        LOGGER.addHandler(filehandler);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void interprete() {
        interpreteInstruction();
        LOGGER.info("Backward " + this.number);
        System.out.println("BackWard" + this.number);
    }

    private void  interpreteInstruction() {
        if (this.lm.getCursorState().getPosition().getOrientation() == Orientation.N ||
                this.lm.getCursorState().getPosition().getOrientation() == Orientation.S)
            lm.getCursorState().getPosition().setY(this.number * (-1));

        if (this.lm.getCursorState().getPosition().getOrientation() == Orientation.E ||
                this.lm.getCursorState().getPosition().getOrientation() == Orientation.W)
            lm.getCursorState().getPosition().setX(this.number * (-1));

    }


}
