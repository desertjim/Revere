package bluetooth.jamesbaca.net.bluetoothextensions;

public class DescriptorRead implements Visitable{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
