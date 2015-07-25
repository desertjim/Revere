package bluetooth.jamesbaca.net.bluetoothextensions.callbacks;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

public interface Progress {
    void onProgress(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status, byte[] value);
    void onError(Throwable e);
    void onComplete();
}
