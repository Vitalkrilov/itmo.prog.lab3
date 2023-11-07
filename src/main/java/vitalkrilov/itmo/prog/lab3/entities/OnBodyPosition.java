package vitalkrilov.itmo.prog.lab3.entities;

public enum OnBodyPosition {

    Forehead,
    Chest,
    Belt,
    Legs,
    Feet;

    @Override
    public String toString() {
        return switch (this) {
            case Forehead -> "Лоб";
            case Chest -> "Туловище";
            case Belt -> "Пояс";
            case Legs -> "Ноги";
            case Feet -> "Ступни";
        };
    }
}
