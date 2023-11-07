package vitalkrilov.itmo.prog.lab3.entities;

import vitalkrilov.itmo.prog.lab3.items.Takeable;
import vitalkrilov.itmo.prog.lab3.items.WearableItem;
import vitalkrilov.itmo.prog.lab3.others.Message;
import vitalkrilov.itmo.prog.lab3.world.Location;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class Hemulen extends LivingEntity {

    private final Map<OnBodyPosition, WearableItem> wearSlots;

    public Hemulen(Location loc) {
        super(loc);
        this.wearSlots = new HashMap<>();
    }

    public void sit() {
        System.out.printf("%s сидит.%n", this.toString());
    }

    public void sleep() {
        System.out.printf("%s спит.%n", this.toString());
    }

    public void wearIfCan(OnBodyPosition targetSlot, WearableItem item) {
        this.wearSlots.put(targetSlot, item);
        System.out.printf("%s надел %s в %s.%n", this.toString(), item.toString(), targetSlot.toString());
    }

    public void suspect(Message msg) {
        System.out.printf("%s подозревает %s.%n", this.toString(), msg.toString());
    }

    public void take(Takeable item) {
        item.notifyTakenBy(this);
        System.out.printf("%s взял %s.%n", this.toString(), item.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hemulen o2 = (Hemulen) o;
        return Objects.equals(this.wearSlots, o2.wearSlots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.wearSlots);
    }

    @Override
    public String toString() {
        return String.format("Хемуль { %s, надетое=%s }", super.toString(), this.wearSlots.toString());
    }

}
