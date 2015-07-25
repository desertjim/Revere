package bluetooth.jamesbaca.net.bluetoothextensions.visiter;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;

import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitable;
import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitor;

public class DescriptorWrite implements Visitable {

    BluetoothGatt gatt;
    BluetoothGattDescriptor descriptor;
    int status;

    public DescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status){
        this.gatt = gatt;
        this.descriptor = descriptor;
        this.status = status;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
