package bluetooth.jamesbaca.net.bluetoothextensions.visitor;

import android.bluetooth.BluetoothGatt;

public class ServicesDiscovered implements Visitable {
    BluetoothGatt gatt;
    int status;

    public ServicesDiscovered(BluetoothGatt gatt, int status){
        this.gatt = gatt;
        this.status = status;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
