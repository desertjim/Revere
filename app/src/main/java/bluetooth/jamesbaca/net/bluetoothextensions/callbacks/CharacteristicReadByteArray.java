package bluetooth.jamesbaca.net.bluetoothextensions.callbacks;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;

import bluetooth.jamesbaca.net.bluetoothextensions.helpers.ReadSplitter;

public class CharacteristicReadByteArray extends BluetoothGattCallback {

    byte[] mMAXByteChunkToWrite;
    ReadSplitter mSplitter;
    Progress mProgress;

    public CharacteristicReadByteArray() {

    }

    @Override
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        if (status == BluetoothGatt.GATT_SUCCESS) {
            storeChunk(gatt, characteristic);
            mProgress.onProgress(gatt, characteristic, status, mMAXByteChunkToWrite);
            readChunk(gatt, characteristic);
        } else {
            mProgress.onError(new RuntimeException("Characteristic Read Failed: " + status));
        }
    }

    public void start(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, Progress progress) {
        mProgress = progress;
        readChunk(gatt, characteristic);
    }

    private void readChunk(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        if (mSplitter.hasNext()) {
            gatt.readCharacteristic(characteristic);
        } else {
            mProgress.onComplete();
        }
    }

    private void storeChunk(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        mMAXByteChunkToWrite = characteristic.getValue();

        try {

            mSplitter.addNext(mMAXByteChunkToWrite);

        } catch (Exception e) {
            mProgress.onError(e);
        }
    }
}
