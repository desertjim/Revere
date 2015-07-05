package bluetooth.jamesbaca.net.bluetoothextensions;

public class ConnectionStateChange implements Visitable{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
