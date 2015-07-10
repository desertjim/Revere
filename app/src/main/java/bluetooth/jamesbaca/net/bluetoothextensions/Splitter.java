package bluetooth.jamesbaca.net.bluetoothextensions;

import java.util.Arrays;

public class Splitter {

    int mSplitByteSize;
    int mBytesOffsetWrite = 0;
    byte[] mTotalByteBufferToWrite;
    byte[] mByteChunk;
    boolean mNeedsFinalZeroSizedWrite = false;

    public Splitter(int splitByteSize){
        mSplitByteSize = splitByteSize;
    }

    public void setTotalByteArrayPayload(byte[] payload){
        mTotalByteBufferToWrite = payload;
        mNeedsFinalZeroSizedWrite = mTotalByteBufferToWrite.length % mSplitByteSize == 0;
    }

    public byte[] generateSubArray() {
        int bytesToCopy = Math.min(mSplitByteSize, mTotalByteBufferToWrite.length - mBytesOffsetWrite);
        if(bytesToCopy > 0 && mNeedsFinalZeroSizedWrite){
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

    public boolean isCompleted(){
        return mBytesOffsetWrite != mTotalByteBufferToWrite.length || mNeedsFinalZeroSizedWrite;
    }
}
