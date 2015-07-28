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

import java.util.Arrays;

import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.CharacteristicReadByteArray;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.CharacteristicWriteByteArray;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.Progress;
import bluetooth.jamesbaca.net.bluetoothextensions.helpers.ReadSplitter;
import bluetooth.jamesbaca.net.bluetoothextensions.helpers.WriteSplitter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricTestRunner.class)
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ReadCharacteristicByteArrayTest {

    @Test
    public void ReadCharacteristicByteArrayTest(){
        BluetoothDevice device = mock(BluetoothDevice.class);
        final BluetoothGatt gatt = mock(BluetoothGatt.class);
        final BluetoothGattCharacteristic characteristic = mock(BluetoothGattCharacteristic.class);
        final CharacteristicReadByteArray array = new CharacteristicReadByteArray();
        ReadSplitter splitter = new ReadSplitter(20);
        Progress progress = new Progress() {

            @Override
            public void onProgress(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status, byte[] value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                array.onCharacteristicRead(gatt, characteristic, 0);
                return null;
            }
        }).when(gatt).readCharacteristic(characteristic);

        array.start(gatt, characteristic, splitter, progress);
    }

}
