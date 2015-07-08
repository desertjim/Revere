package bluetooth.jamesbaca.net.bluetoothextensions;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;

import java.util.Arrays;

public class CharacteristicWriteByteArray extends BluetoothGattCallback {

    static final int DEFAULT_BTLE_MAX_BYTE_ARRAY_SIZE = 20;
    int mBytesOffsetWrite = 0;
    byte[] mTotalByteBufferToWrite;
    byte[] mMAXByteChunkToWrite;
    boolean mNeedsFinalZeroSizedWrite = false;
    Splitter mSplitter;

    @Override
    public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        super.onCharacteristicWrite(gatt, characteristic, status);
        if (status == BluetoothGatt.GATT_SUCCESS) {
            if (mBytesOffsetWrite != mTotalByteBufferToWrite.length || mNeedsFinalZeroSizedWrite) {
                handleChunk(gatt, characteristic, mTotalByteBufferToWrite);
            } else {
                // TODO signal completion somehow
            }
        } else {
            throw new RuntimeException("Characteristic Write Failed: " + status);
        }
    }

    private void handleChunk(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] array) {
        if (mBytesOffsetWrite >= array.length && !mNeedsFinalZeroSizedWrite) {
            return;
        }
        mMAXByteChunkToWrite = mSplitter.generateSubArray(array, mMAXByteChunkToWrite, DEFAULT_BTLE_MAX_BYTE_ARRAY_SIZE, mBytesOffsetWrite);
        mBytesOffsetWrite += _writeByteArrayToCharacteristic(gatt, characteristic, mMAXByteChunkToWrite);
        if (mMAXByteChunkToWrite.length == 0) {
            mNeedsFinalZeroSizedWrite = false;
        }
    }

    public void writeByteArrayToCharacteristic(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] bytesToWrite) {
        mBytesOffsetWrite = 0;
        mTotalByteBufferToWrite = bytesToWrite;
        mNeedsFinalZeroSizedWrite = bytesToWrite.length % DEFAULT_BTLE_MAX_BYTE_ARRAY_SIZE == 0;
        handleChunk(gatt, characteristic, mTotalByteBufferToWrite);
    }

    private int _writeByteArrayToCharacteristic(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] array) {
        characteristic.setValue(array);
        gatt.writeCharacteristic(characteristic);
        return array.length;
    }
}
