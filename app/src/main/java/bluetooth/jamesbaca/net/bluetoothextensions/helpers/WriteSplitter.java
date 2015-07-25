package bluetooth.jamesbaca.net.bluetoothextensions.helpers;

import java.util.Arrays;
import java.util.Iterator;

public class WriteSplitter implements Iterator<byte[]> {

    int mSplitByteSize;
    int mBytesOffsetWrite = 0;
    byte[] mTotalByteBufferToWrite;
    byte[] mByteChunk;
    boolean mNeedsFinalZeroSizedWrite = false;

    public WriteSplitter(int splitByteSize){
        mSplitByteSize = splitByteSize;
    }

    public void setTotalByteArrayPayload(byte[] payload){
        mTotalByteBufferToWrite = payload;
        mNeedsFinalZeroSizedWrite = mTotalByteBufferToWrite.length % mSplitByteSize == 0;
    }

    @Override
    public boolean hasNext() {
        return mBytesOffsetWrite != mTotalByteBufferToWrite.length || mNeedsFinalZeroSizedWrite;
    }

    @Override
    public byte[] next() {
        int bytesToCopy = Math.min(mSplitByteSize, mTotalByteBufferToWrite.length - mBytesOffsetWrite);
        if(bytesToCopy == 0 && mNeedsFinalZeroSizedWrite){
            mNeedsFinalZeroSizedWrite = false;
        }

        if (mByteChunk == null || mByteChunk.length != bytesToCopy) {
            mByteChunk = new byte[bytesToCopy];
        } else {
            Arrays.fill(mByteChunk, (byte) 0);
        }
        System.arraycopy(mTotalByteBufferToWrite, mBytesOffsetWrite, mByteChunk, 0, bytesToCopy);
        mBytesOffsetWrite += bytesToCopy;
        return mByteChunk;
    }

    @Override
    public void remove() {

    }
}
