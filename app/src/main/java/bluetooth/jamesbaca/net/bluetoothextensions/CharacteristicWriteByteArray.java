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

    public void writeByteArrayToCharacteristic(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] bytesToWrite) {
        mBytesOffsetWrite = 0;
        mTotalByteBufferToWrite = bytesToWrite;
        mNeedsFinalZeroSizedWrite = bytesToWrite.length % DEFAULT_BTLE_MAX_BYTE_ARRAY_SIZE == 0;
        handleChunk(gatt, characteristic, mTotalByteBufferToWrite);
    }

    private void handleChunk(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] array) {
        if (mBytesOffsetWrite >= array.length && !mNeedsFinalZeroSizedWrite) {
            return;
        }
        mMAXByteChunkToWrite = generateSubArray(array, mMAXByteChunkToWrite, mBytesOffsetWrite);
        mBytesOffsetWrite += _writeByteArrayToCharacteristic(gatt, characteristic, mMAXByteChunkToWrite);
        if (mMAXByteChunkToWrite.length == 0) {
            mNeedsFinalZeroSizedWrite = false;
        }
    }

    private byte[] generateSubArray(byte[] source, byte[] destination, int offset) {
        int bytesToCopy = Math.min(DEFAULT_BTLE_MAX_BYTE_ARRAY_SIZE, source.length - offset);

        if (destination == null || destination.length != bytesToCopy) {
            destination = new byte[bytesToCopy];
        } else {
            Arrays.fill(destination, (byte) 0);
        }

        System.arraycopy(source, offset, destination, 0, bytesToCopy);
        return destination;
    }

    private int _writeByteArrayToCharacteristic(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] array) {
        characteristic.setValue(array);
        gatt.writeCharacteristic(characteristic);
        return array.length;
    }
}
