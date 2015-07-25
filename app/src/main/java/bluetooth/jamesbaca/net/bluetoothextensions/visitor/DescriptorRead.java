package bluetooth.jamesbaca.net.bluetoothextensions.visitor;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;

public class DescriptorRead implements Visitable {
    BluetoothGatt gatt;
    BluetoothGattDescriptor descriptor;
    int status;

    public DescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status){
        this.gatt = gatt;
        this.descriptor = descriptor;
        this.status = status;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
