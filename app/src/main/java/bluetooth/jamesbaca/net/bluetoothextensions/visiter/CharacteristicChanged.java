package bluetooth.jamesbaca.net.bluetoothextensions.visiter;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitable;
import bluetooth.jamesbaca.net.bluetoothextensions.visiter.Visitor;

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
