package bluetooth.jamesbaca.net.bluetoothextensions;

import java.util.Arrays;

public class Splitter {

    int mSplitByteSize;
    public Splitter(int splitByteSize){
        mSplitByteSize = splitByteSize;
    }

    public byte[] generateSubArray(byte[] source, byte[] destination, int offset) {
        int bytesToCopy = Math.min(mSplitByteSize, source.length - offset);

        if (destination == null || destination.length != bytesToCopy) {
            destination = new byte[bytesToCopy];
        } else {
            Arrays.fill(destination, (byte) 0);
        }

        System.arraycopy(source, offset, destination, 0, bytesToCopy);
        return destination;
    }
}
