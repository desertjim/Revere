package bluetooth.jamesbaca.net.bluetoothextensions;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;

import java.util.Arrays;

public class CharacteristicWriteByteArray extends BluetoothGattCallback{

    public static final int DEFAULT_BTLE_MAX_BYTE_ARRAY_SIZE = 20;
    byte[] mMAXByteChunkToWrite;
    Splitter mSplitter;

    public CharacteristicWriteByteArray() {

    }

    @Override
    public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        if (status == BluetoothGatt.GATT_SUCCESS) {
            if (!mSplitter.isCompleted()) {
                handleChunk(gatt, characteristic);
            } else {
                // TODO signal completion somehow
            }
        } else {
            throw new RuntimeException("Characteristic Write Failed: " + status);
        }
    }

    public void start(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, Splitter splitter){
        mSplitter = splitter;
        handleChunk(gatt, characteristic);
    }

    private void handleChunk(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        mMAXByteChunkToWrite = mSplitter.generateSubArray();
        _writeByteArrayToCharacteristic(gatt, characteristic, mMAXByteChunkToWrite);
    }

    private void _writeByteArrayToCharacteristic(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] array) {
        characteristic.setValue(array);
        gatt.writeCharacteristic(characteristic);
    }
}
