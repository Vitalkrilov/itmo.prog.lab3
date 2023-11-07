package vitalkrilov.itmo.prog.lab3.items;

public enum PosterType {

    Theatrical;

    @Override
    public String toString() {
        return switch (this) {
            case Theatrical -> "Театральная";
        };
    }

}
