package bluetooth.jamesbaca.net.bluetoothextensions;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;

import java.util.Iterator;

public class CharacteristicWriteByteArray extends BluetoothGattCallback{

    public static final int DEFAULT_BTLE_MAX_BYTE_ARRAY_SIZE = 20;
    byte[] mMAXByteChunkToWrite;
    Iterator<byte[]> mSplitter;
    Progress mProgress;
    public CharacteristicWriteByteArray() {

    }

    @Override
    public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        if (status == BluetoothGatt.GATT_SUCCESS) {
            mProgress.onProgress(gatt, characteristic, status, mMAXByteChunkToWrite);
            if (!mSplitter.hasNext()) {
                writeChunk(gatt, characteristic);
            } else {
               mProgress.onComplete();
            }
        } else {
            mProgress.onError(new RuntimeException("Characteristic Write Failed: " + status));
        }
    }

    public void start(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, Iterator<byte[]> splitter, Progress progress){
        mProgress = progress;
        mSplitter = splitter;
        writeChunk(gatt, characteristic);
    }

    private void writeChunk(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        mMAXByteChunkToWrite = mSplitter.next();
        _writeByteArrayToCharacteristic(gatt, characteristic, mMAXByteChunkToWrite);
    }

    private void _writeByteArrayToCharacteristic(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] array) {
        characteristic.setValue(array);
        gatt.writeCharacteristic(characteristic);
    }
}
