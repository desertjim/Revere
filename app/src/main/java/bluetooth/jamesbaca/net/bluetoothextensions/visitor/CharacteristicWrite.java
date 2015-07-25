package bluetooth.jamesbaca.net.bluetoothextensions.visitor;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

public class CharacteristicWrite implements Visitable {

    BluetoothGatt gatt;
    BluetoothGattCharacteristic characteristic;
    int status;

    public CharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        this.gatt = gatt;
        this.characteristic = characteristic;
        this.status = status;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
