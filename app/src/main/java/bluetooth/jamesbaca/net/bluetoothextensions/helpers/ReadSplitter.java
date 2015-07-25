package bluetooth.jamesbaca.net.bluetoothextensions.helpers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class ReadSplitter implements Iterator<byte[]> {

    int mSplitByteSize;
    int mLastByteSizeRead;
    ByteArrayOutputStream mByteArrayOutputStream = new ByteArrayOutputStream();

    public ReadSplitter(int splitByteSize) {
        mSplitByteSize = splitByteSize;
    }

    @Override
    public boolean hasNext() {
        return mLastByteSizeRead == mSplitByteSize;
    }

    @Override
    public byte[] next() {
        return null;
    }

    @Override
    public void remove() {

    }

    public void addNext(byte[] contents){
        try {
            if (contents != null && contents.length > 0) {
                mByteArrayOutputStream.write(contents);
            }
            mLastByteSizeRead = contents.length;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
