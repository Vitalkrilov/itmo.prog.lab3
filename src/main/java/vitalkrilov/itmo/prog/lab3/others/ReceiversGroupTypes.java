package vitalkrilov.itmo.prog.lab3.others;

public enum ReceiversGroupTypes {

    Prisoners;

    @Override
    public String toString() {
        return switch (this) {
            case Prisoners -> "Узники";
        };
    }

}
