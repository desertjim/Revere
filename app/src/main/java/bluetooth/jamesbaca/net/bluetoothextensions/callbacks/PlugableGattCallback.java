package bluetooth.jamesbaca.net.bluetoothextensions.callbacks;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

public class PlugableGattCallback extends BluetoothGattCallback {
    protected BluetoothGattCallback mSubCallback;


    public BluetoothGattCallback getSubCallback() {
        synchronized (this) {
            return mSubCallback;
        }
    }

    public void setSubCallback(BluetoothGattCallback subCallback) {
        synchronized (this) {
            mSubCallback = subCallback;
        }
    }

    @Override
    public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
        super.onConnectionStateChange(gatt, status, newState);
        synchronized (this) {
            if (mSubCallback != null) {
                mSubCallback.onConnectionStateChange(gatt, status, newState);
            }
        }
    }

    @Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {
        super.onServicesDiscovered(gatt, status);
        synchronized (this) {
            if (mSubCallback != null) {
                mSubCallback.onServicesDiscovered(gatt, status);
            }
        }
    }

    @Override
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        super.onCharacteristicRead(gatt, characteristic, status);
        synchronized (this) {
            if (mSubCallback != null) {
                mSubCallback.onCharacteristicRead(gatt, characteristic, status);
            }
        }
    }

    @Override
    public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        super.onCharacteristicWrite(gatt, characteristic, status);
        synchronized (this) {
            if (mSubCallback != null) {
                mSubCallback.onCharacteristicWrite(gatt, characteristic, status);
            }
        }
    }

    @Override
    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        super.onCharacteristicChanged(gatt, characteristic);
        if (mSubCallback != null) {
            mSubCallback.onCharacteristicChanged(gatt, characteristic);
        }
    }

    @Override
    public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        super.onDescriptorRead(gatt, descriptor, status);
        synchronized (this) {
            if (mSubCallback != null) {
                mSubCallback.onDescriptorRead(gatt, descriptor, status);
            }
        }
    }

    @Override
    public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        super.onDescriptorWrite(gatt, descriptor, status);
        synchronized (this) {
            if (mSubCallback != null) {
                mSubCallback.onDescriptorWrite(gatt, descriptor, status);
            }
        }
    }

    @Override
    public void onReliableWriteCompleted(BluetoothGatt gatt, int status) {
        super.onReliableWriteCompleted(gatt, status);
        synchronized (this) {
            if (mSubCallback != null) {
                mSubCallback.onReliableWriteCompleted(gatt, status);
            }
        }
    }

    @Override
    public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
        super.onReadRemoteRssi(gatt, rssi, status);
        synchronized (this) {
            if (mSubCallback != null) {
                mSubCallback.onReadRemoteRssi(gatt, rssi, status);
            }
        }
    }

    @Override
    public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
        super.onMtuChanged(gatt, mtu, status);
        synchronized (this) {
            if (mSubCallback != null) {
                mSubCallback.onMtuChanged(gatt, mtu, status);
            }
        }
    }
}
