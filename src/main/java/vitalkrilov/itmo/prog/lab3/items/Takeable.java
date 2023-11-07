package vitalkrilov.itmo.prog.lab3.items;

import vitalkrilov.itmo.prog.lab3.entities.LivingEntity;

public interface Takeable {

    default void notifyTakenBy(LivingEntity entity) {}

}
