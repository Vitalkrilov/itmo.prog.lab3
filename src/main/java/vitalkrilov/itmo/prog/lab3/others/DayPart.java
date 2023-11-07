package vitalkrilov.itmo.prog.lab3.others;

public enum DayPart {

    Sunrise,
    Morning,
    Noon,
    Afternoon,
    Evening,
    Night;

    @Override
    public String toString() {
        return switch (this) {
            case Sunrise -> "Восход";
            case Morning -> "Утра";
            case Noon -> "Полдень";
            case Afternoon -> "День";
            case Evening -> "Вечер";
            case Night -> "Ночь";
        };
    }

}
