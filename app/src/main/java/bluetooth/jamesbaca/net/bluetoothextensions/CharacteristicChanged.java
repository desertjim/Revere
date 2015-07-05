package bluetooth.jamesbaca.net.bluetoothextensions;

public class CharacteristicChanged implements Visitable{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
