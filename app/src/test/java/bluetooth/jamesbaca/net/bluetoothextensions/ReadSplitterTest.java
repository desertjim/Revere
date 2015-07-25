package bluetooth.jamesbaca.net.bluetoothextensions;

import org.junit.Test;

import bluetooth.jamesbaca.net.bluetoothextensions.helpers.ReadSplitter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class ReadSplitterTest {

    @Test
    public void testHasNext() {
        int readSize = 20;
        byte []contents1 = new byte[20];
        ReadSplitter splitter = new ReadSplitter(readSize);
        splitter.addNext(contents1);
        assertThat("Should indicate that more is expected", splitter.hasNext(), is(true));
    }

    @Test
    public void testHasNextAfterWrite0() {
        int readSize = 20;
        byte []contents1 = new byte[20];
        byte []emptyContents = new byte[0];
        ReadSplitter splitter = new ReadSplitter(readSize);
        splitter.addNext(contents1);
        splitter.addNext(emptyContents);
        assertThat("Should indicate nothing more is expected", splitter.hasNext(), is(false));
    }


}
