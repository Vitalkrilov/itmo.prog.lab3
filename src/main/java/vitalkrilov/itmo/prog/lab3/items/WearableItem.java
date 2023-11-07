package vitalkrilov.itmo.prog.lab3.items;

import vitalkrilov.itmo.prog.lab3.entities.LivingEntity;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class WearableItem implements Takeable {

    private final WearableItemType type;
    private final Set<ItemCharacteristic> characteristics;

    public WearableItem(WearableItemType type) {
        this.type = type;
        this.characteristics = new HashSet<>();
    }

    public void addCharacteristicIfCan(ItemCharacteristic characteristic) {
        //TODO: Add on lab4 exception throwing
        //if (!this.characteristics.contains(characteristic))
        this.characteristics.add(characteristic);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;
        WearableItem o2 = (WearableItem) o;
        return this.type == o2.type && Objects.equals(this.characteristics, o2.characteristics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.type.hashCode(), this.characteristics.hashCode());
    }

    @Override
    public String toString() {
        return String.format("Надеваемый_предмет { тип=%s, характеристики=%s }", this.type.toString(), this.characteristics.toString());
    }

}
