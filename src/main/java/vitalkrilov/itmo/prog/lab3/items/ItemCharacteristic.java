package vitalkrilov.itmo.prog.lab3.items;

public enum ItemCharacteristic {

    Police;

    @Override
    public String toString() {
        return switch (this) {
            case Police -> "Полицейский";
        };
    }

}
