package bluetooth.jamesbaca.net.bluetoothextensions.visitor;

import android.bluetooth.BluetoothGatt;

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
