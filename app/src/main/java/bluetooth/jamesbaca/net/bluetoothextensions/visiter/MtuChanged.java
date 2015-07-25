package bluetooth.jamesbaca.net.bluetoothextensions.visiter;

import android.bluetooth.BluetoothGatt;

import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitable;
import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitor;

public class MtuChanged implements Visitable {

    BluetoothGatt gatt;
    int mtu;
    int status;

    public MtuChanged(BluetoothGatt gatt, int mtu, int status){
        this.gatt = gatt;
        this.mtu = mtu;
        this.status = status;
    }

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
}
