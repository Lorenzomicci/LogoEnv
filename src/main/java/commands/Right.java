package commands;

import controller.LogoController;
import interpreter.RegularExpression;
import model.LogoModel;
import model.Orientation;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Right implements RegularExpression {

    private static final Logger LOGGER = Logger.getLogger( LogoController.class.getName() );

    LogoModel lm;

    public Right(LogoModel logoModel) throws IOException {
        this.lm = logoModel;
        FileHandler filehandler = new FileHandler("src/main/java/CommandsLog/instructions.log",true);
        LOGGER.addHandler(filehandler);
    }

    @Override
    public void interprete() {
        interpreteIndstruction();
        interpreteIndstruction();LOGGER.info("Right ");
        System.out.println("Right");
    }

    private void interpreteIndstruction() {
        this.lm.getCursorState().rotate(Orientation.W);
    }

}
