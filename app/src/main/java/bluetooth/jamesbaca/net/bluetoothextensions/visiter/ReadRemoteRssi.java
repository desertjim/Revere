package bluetooth.jamesbaca.net.bluetoothextensions.visiter;

import android.bluetooth.BluetoothGatt;

import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitable;
import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitor;

public class ReadRemoteRssi implements Visitable {
    BluetoothGatt gatt;
    int rssi;
    int status;

    public ReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
        this.gatt = gatt;
        this.rssi = rssi;
        this.status = status;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
