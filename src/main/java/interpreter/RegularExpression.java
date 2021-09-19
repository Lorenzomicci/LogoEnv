package interpreter;

/**
 * Una {@link RegularExpression} rappresenta una istruzione LOGO in java, un oggetto di tipo {@link RegularExpression}
 * ha al suo interno metodi che codificano l istruzione in questione modificando lo stato interno del {@link model.LogoModel}
 */
public interface RegularExpression {
    void interprete();
}
