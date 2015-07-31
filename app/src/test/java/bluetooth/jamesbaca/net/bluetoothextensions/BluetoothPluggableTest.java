package bluetooth.jamesbaca.net.bluetoothextensions;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.RobolectricTestRunner;

import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.CharacteristicReadByteArray;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.PluggableGattCallback;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.Progress;
import bluetooth.jamesbaca.net.bluetoothextensions.helpers.ReadSplitter;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricTestRunner.class)
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class BluetoothPluggableTest extends PluggableGattCallback{

    @Test
    public void TestSettingCallback(){
        PluggableGattCallback callback = new PluggableGattCallback();
        PluggableGattCallback callback1 = new PluggableGattCallback();
        callback.setSubCallback(callback1);
        assert callback.getSubCallback().equals(callback1);
    }

    @Test
    public void TestChangingCallback() {
        PluggableGattCallback callback = new PluggableGattCallback();
        PluggableGattCallback callback1 = new PluggableGattCallback();
        PluggableGattCallback callback2 = new PluggableGattCallback();
        callback.setSubCallback(callback1);
        callback.setSubCallback(callback2);
        assert callback.getSubCallback().equals(callback2);
    }
}
