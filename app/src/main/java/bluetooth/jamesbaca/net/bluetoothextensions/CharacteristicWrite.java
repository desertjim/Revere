package bluetooth.jamesbaca.net.bluetoothextensions;

public class CharacteristicWrite implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
