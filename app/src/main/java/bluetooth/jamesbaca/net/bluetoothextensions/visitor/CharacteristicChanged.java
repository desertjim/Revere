package bluetooth.jamesbaca.net.bluetoothextensions.visitor;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

public class CharacteristicChanged implements Visitable {
    BluetoothGatt gatt;
    BluetoothGattCharacteristic characteristic;

    public CharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic){
        this.gatt = gatt;
        this.characteristic = characteristic;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
