package bluetooth.jamesbaca.net.bluetoothextensions;

public class ReadRemoteRssi implements Visitable{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
