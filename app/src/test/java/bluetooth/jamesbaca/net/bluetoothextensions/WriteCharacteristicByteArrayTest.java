package bluetooth.jamesbaca.net.bluetoothextensions;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.RobolectricTestRunner;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class WriteCharacteristicByteArrayTest {

    @Test public void WriteCharacteristicByteArrayTest(){
        BluetoothDevice device = mock(BluetoothDevice.class);
        final BluetoothGatt gatt = mock(BluetoothGatt.class);
        final BluetoothGattCharacteristic characteristic = mock(BluetoothGattCharacteristic.class);
        final CharacteristicWriteByteArray array = new CharacteristicWriteByteArray();
        WriteSplitter splitter = new WriteSplitter(20);
        final byte[] expectedChunk1Contents = new byte[20];
        final byte[] expectedChunk2Contents = new byte[0];
        Arrays.fill(expectedChunk1Contents, (byte) 8);
        splitter.setTotalByteArrayPayload(expectedChunk1Contents);

        Progress progress = new Progress() {
            int post = 0;
            @Override
            public void onProgress(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status, byte[] value) {
                if(0 == post) {
                    assertThat("First chunk should be all 1s", Arrays.equals(expectedChunk1Contents, value));
                    post++;
                }else{
                    assertThat("First chunk should be 0", Arrays.equals(expectedChunk2Contents, value));
                }
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
                array.onCharacteristicWrite(gatt, characteristic, 0);
                return null;
            }
        }).when(gatt).writeCharacteristic(characteristic);

        array.start(gatt, characteristic, splitter, progress);

    }
}
