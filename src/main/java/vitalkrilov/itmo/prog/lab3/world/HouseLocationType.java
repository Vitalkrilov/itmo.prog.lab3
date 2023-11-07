package vitalkrilov.itmo.prog.lab3.world;

public enum HouseLocationType {

    Roof;

    @Override
    public String toString() {
        return switch (this) {
            case Roof -> "Крыша";
        };
    }
  
}
