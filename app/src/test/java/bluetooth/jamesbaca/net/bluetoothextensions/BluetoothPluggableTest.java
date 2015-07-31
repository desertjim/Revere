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
public class BluetoothPluggableTest {

    @Test
    public void BluetoothPluggableTest(){
        PluggableGattCallback callback = new PluggableGattCallback();
        callback.setSubCallback(new PluggableGattCallback());

    }

}
