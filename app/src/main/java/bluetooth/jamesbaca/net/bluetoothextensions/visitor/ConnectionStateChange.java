package bluetooth.jamesbaca.net.bluetoothextensions.visitor;

import android.bluetooth.BluetoothGatt;

public class ConnectionStateChange implements Visitable {
    BluetoothGatt gatt;
    int status;
    int newState;

    public ConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
        this.gatt = gatt;
        this.status = status;
        this.newState = newState;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
