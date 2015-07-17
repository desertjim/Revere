package bluetooth.jamesbaca.net.bluetoothextensions;

import android.util.Log;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class WriteSplitterTest {

    @Test
    public void testHasNext() {
        int readSize = 20;
        byte[] contents = new byte[20];
        WriteSplitter splitter = new WriteSplitter(readSize);
        splitter.setTotalByteArrayPayload(contents);
        // none has been
        assertThat("Nothing has been read, so there should be some next", splitter.hasNext(), is(true));
    }

    @Test
    public void testHasNextAfterOneRead() {
        int readSize = 20;
        byte[] contents = new byte[25];
        WriteSplitter splitter = new WriteSplitter(readSize);
        splitter.setTotalByteArrayPayload(contents);
        splitter.next();
        assertThat("Only one read took place, one more should exist", splitter.hasNext(), is(true));
    }

    @Test
    public void testHasNextAfterTwoReads() {
        int readSize = 20;
        byte[] contents = new byte[40];
        WriteSplitter splitter = new WriteSplitter(readSize);
        splitter.setTotalByteArrayPayload(contents);
        splitter.next();
        splitter.next();
        assertThat("Two reads took place one more of an empty one should exist", splitter.hasNext(), is(true));
    }

    @Test
    public void testContentsSplit() {
        int readSize = 20;
        byte[] contents = new byte[40];
        byte[] expectedChunk1Contents = new byte[20];
        byte[] expectedChunk2Contents = new byte[20];
        Arrays.fill(expectedChunk1Contents, (byte) 8);
        Arrays.fill(expectedChunk2Contents, (byte) 0);

        Arrays.fill(contents, (byte) 0, 20, (byte) 8);
        Arrays.fill(contents, (byte) 20, 40, (byte) 0);
        WriteSplitter splitter = new WriteSplitter(readSize);
        splitter.setTotalByteArrayPayload(contents);
        byte[] firstChunk = splitter.next();
        assertThat("First chunk should be all 1s", Arrays.equals(expectedChunk1Contents, firstChunk));

        byte[] secondChunk = splitter.next();
        assertThat("Second chunk should be all 0s", Arrays.equals(expectedChunk2Contents, secondChunk));
    }


}
