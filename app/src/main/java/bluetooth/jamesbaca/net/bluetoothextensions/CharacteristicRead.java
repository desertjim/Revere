package bluetooth.jamesbaca.net.bluetoothextensions;

public class CharacteristicRead implements Visitable{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
