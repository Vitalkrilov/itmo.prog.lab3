package vitalkrilov.itmo.prog.lab3.world;

public enum LocationType {

    DirectPosition,
    Bay,
    Forest,
    Shore,
    Meadow,
    Water,
    House,
    Garden,
    Jail;

    @Override
    public String toString() {
        return switch (this) {
            case DirectPosition -> "Конкретная_позиция";
            case Bay -> "Залив";
            case Forest -> "Лес";
            case Shore -> "Берег";
            case Meadow -> "Луг";
            case Water -> "Вода";
            case House -> "Дом";
            case Garden -> "Сад";
            case Jail -> "Тюрьма";
        };
    }

}
