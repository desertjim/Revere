package bluetooth.jamesbaca.net.bluetoothextensions;

import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.CharacteristicChanged;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.CharacteristicRead;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.CharacteristicWrite;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.ConnectionStateChange;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.DescriptorRead;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.DescriptorWrite;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.MtuChanged;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.ReadRemoteRssi;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.ReliableWriteCompleted;
import bluetooth.jamesbaca.net.bluetoothextensions.callbacks.ServicesDiscovered;

public interface Visitor{
    void visit(ConnectionStateChange connectionStateChange);
    void visit(ServicesDiscovered servicesDiscovered);
    void visit(CharacteristicRead characteristicRead);
    void visit(CharacteristicWrite characteristicWrite);
    void visit(CharacteristicChanged changed);
    void visit(DescriptorRead descriptorRead);
    void visit(DescriptorWrite descriptorWrite);
    void visit(ReliableWriteCompleted reliableWriteCompleted);
    void visit(ReadRemoteRssi readRemoteRssi);
    void visit(MtuChanged mtuChanged);
}
