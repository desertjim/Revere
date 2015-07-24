package bluetooth.jamesbaca.net.bluetoothextensions.callbacks;

import bluetooth.jamesbaca.net.bluetoothextensions.Visitable;
import bluetooth.jamesbaca.net.bluetoothextensions.Visitor;

public class CharacteristicWrite implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
