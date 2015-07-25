package bluetooth.jamesbaca.net.bluetoothextensions.visitor;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

public class CharacteristicRead implements Visitable {
    BluetoothGatt gatt;
    BluetoothGattCharacteristic characteristic;
    int status;

    public CharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        this.gatt = gatt;
        this.characteristic = characteristic;
        this.status = status;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
