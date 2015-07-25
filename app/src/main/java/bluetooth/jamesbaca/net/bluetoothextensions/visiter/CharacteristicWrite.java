package bluetooth.jamesbaca.net.bluetoothextensions.visiter;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitable;
import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitor;

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
