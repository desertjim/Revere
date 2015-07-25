package bluetooth.jamesbaca.net.bluetoothextensions.visiter;

import android.bluetooth.BluetoothGatt;

import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitable;
import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitor;

public class ReliableWriteCompleted implements Visitable {
    BluetoothGatt gatt;
    int status;

    public ReliableWriteCompleted(BluetoothGatt gatt, int status) {
        this.gatt = gatt;
        this.status = status;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
