package bluetooth.jamesbaca.net.bluetoothextensions.visiter;

import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitable;
import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitor;

public class ReliableWriteCompleted implements Visitable {
    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
}
