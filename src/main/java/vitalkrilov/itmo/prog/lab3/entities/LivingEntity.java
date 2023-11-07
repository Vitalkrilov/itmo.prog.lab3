package vitalkrilov.itmo.prog.lab3.entities;

import vitalkrilov.itmo.prog.lab3.others.Message;
import vitalkrilov.itmo.prog.lab3.world.Movable;
import vitalkrilov.itmo.prog.lab3.others.MessageReceivingCapable;
import vitalkrilov.itmo.prog.lab3.world.Location;

import java.util.Objects;

public abstract class LivingEntity implements Movable, MessageReceivingCapable {

    protected Location currentLocation;

    protected LivingEntity(Location loc) {
        this.setCurrentLocation(loc);
    }

    @Override
    public Location getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void setCurrentLocation(Location loc) {
        this.currentLocation = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;
        LivingEntity o2 = (LivingEntity) o;
        return Objects.equals(this.currentLocation, o2.currentLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.currentLocation);
    }

    @Override
    public String toString() {
        return String.format("Живность { местоположение=%s }", this.currentLocation.toString());
    }

}
