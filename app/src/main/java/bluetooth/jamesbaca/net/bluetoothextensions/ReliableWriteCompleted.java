package bluetooth.jamesbaca.net.bluetoothextensions;

public class ReliableWriteCompleted implements Visitable{
    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
}
