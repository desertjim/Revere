package bluetooth.jamesbaca.net.bluetoothextensions;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.CharacteristicReadByteArray;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.PluggableGattCallback;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.Progress;
import bluetooth.jamesbaca.net.bluetoothextensions.helpers.ReadSplitter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricTestRunner.class)
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
@Config(manifest= Config.NONE)
public class BluetoothPluggableTest extends PluggableGattCallback{

    @Test
    public void TestSettingCallback(){
        PluggableGattCallback callback = new PluggableGattCallback();
        PluggableGattCallback callback1 = new PluggableGattCallback();
        callback.setSubCallback(callback1);
        assertThat("Callback isn't the same instance and should be", callback.getSubCallback(), CoreMatchers.<BluetoothGattCallback>equalTo(callback1));
    }

    @Test
    public void TestChangingCallback() {
        PluggableGattCallback callback = new PluggableGattCallback();
        PluggableGattCallback callback1 = new PluggableGattCallback();
        PluggableGattCallback callback2 = new PluggableGattCallback();
        callback.setSubCallback(callback1);
        callback.setSubCallback(callback2);
        assertThat("Callback isn't the same instance and should be", callback.getSubCallback(), CoreMatchers.<BluetoothGattCallback>equalTo(callback2));
    }
}
