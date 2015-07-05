package bluetooth.jamesbaca.net.bluetoothextensions;

public class DescriptorWrite implements Visitable{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
