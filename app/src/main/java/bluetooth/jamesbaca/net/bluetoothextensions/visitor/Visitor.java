package bluetooth.jamesbaca.net.bluetoothextensions.visitor;

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
