package bluetooth.jamesbaca.net.bluetoothextensions;

public class MtuChanged implements Visitable{
    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }
}
