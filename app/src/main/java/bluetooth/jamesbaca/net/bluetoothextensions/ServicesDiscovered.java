package bluetooth.jamesbaca.net.bluetoothextensions;

public class ServicesDiscovered implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
