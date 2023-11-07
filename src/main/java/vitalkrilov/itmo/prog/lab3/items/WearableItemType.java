package vitalkrilov.itmo.prog.lab3.items;

public enum WearableItemType {

    Cap;

    @Override
    public String toString() {
        return switch (this) {
            case Cap -> "Фуражка";
        };
    }

}
