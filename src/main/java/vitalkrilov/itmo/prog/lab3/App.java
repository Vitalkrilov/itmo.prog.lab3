package vitalkrilov.itmo.prog.lab3;

import vitalkrilov.itmo.prog.lab3.entities.Bird;
import vitalkrilov.itmo.prog.lab3.entities.Hemulen;
import vitalkrilov.itmo.prog.lab3.entities.OnBodyPosition;
import vitalkrilov.itmo.prog.lab3.items.*;
import vitalkrilov.itmo.prog.lab3.others.*;
import vitalkrilov.itmo.prog.lab3.world.*;

import java.util.ArrayList;

/**
 * Entry point of App.
 *
 */
public class App {

    public static void main(String[] args) {
        Date.setStoryStartDayNumber(1);
        System.out.printf("Пусть история началась в день №%d.%n", Date.getStoryStartDayNumber());

        // Set up locations for posters
        ArrayList<Location> postersLocations = new ArrayList<>();
        for (LocationType lt : new LocationType[]{LocationType.Forest, LocationType.Bay, LocationType.Meadow, LocationType.Water, LocationType.Garden}) {
            postersLocations.add(new Location(lt));
        }
        postersLocations.add(new House(HouseLocationType.Roof));
        Location jail = new Location(LocationType.Jail);

        Bird b = new Bird(new Location(LocationType.Bay));

        // Create posters
        int numOfPosters = postersLocations.size() * 2; //NOTE: Let it be 2 * num of locations
        int postersPerLocation = (int)Math.ceil((float)numOfPosters / postersLocations.size());
        System.out.printf("Пусть было второстепенных %d постеров, по %d в каждую нужную локацию.%n", numOfPosters, postersPerLocation);
        ArrayList<Poster> posters = new ArrayList<Poster>();
        for (Location l : postersLocations) {
            for (int i = 0; i < postersPerLocation; ++i) {
                Poster p = new Poster(PosterType.Theatrical, l);
                p.setColorful(true); // All except special posters?.. (because it's not stated in text)
                posters.add(p);
            }
        }
        Poster specialBirdsPoster = new Poster(PosterType.Theatrical, b.getCurrentLocation());
        specialBirdsPoster.setStoryNameAlias("Плакат");
        posters.add(specialBirdsPoster);
        Poster specialJailPoster = new Poster(PosterType.Theatrical, jail);
        posters.add(specialJailPoster);
        // Assign authors
        for (Poster p : posters) {
            p.addAuthor("Хомса");
            p.addAuthor("Мюмля");
        }

        Sender s = new Sender();
        Date postersSendDate = new Date(DayPart.Morning, Date.getStoryStartDayNumber() + 1);
        for (Poster p : posters) {
            s.scheduleSending(p, postersSendDate);
        }

        b.flyAround();
        b.dropItem(specialBirdsPoster);

        for (Poster p : posters) {
            if (p == specialBirdsPoster) continue; // Skip dropped poster
            p.spinInAirAround();
        }

        //specialJailPoster.spinInAirAround(); // Could be spinned here but it's already spinned with others
        DirectPosition hemulenPos = new DirectPosition("Где-то у тюрьмы на солнышке (около ног Хемуля)");
        Hemulen h = new Hemulen(hemulenPos);
        specialJailPoster.fallTo(h.getCurrentLocation());
        h.sit();
        WorldsWeatherTypesStorage wwts = new WorldsWeatherTypesStorage();
        wwts.setWeather(hemulenPos, WeatherType.Sunny);
        System.out.println("Погода около " + h.toString() + " в данных момент " + wwts.getWeather(hemulenPos) + ".");
        h.sleep();
        WearableItem wi =  new WearableItem(WearableItemType.Cap);
        wi.addCharacteristicIfCan(ItemCharacteristic.Police);
        h.wearIfCan(OnBodyPosition.Forehead, wi);
        Message msg = new Message("[Некое тайное послание...]");
        msg.registerReceiversIfCan(new ReceiversGroup(ReceiversGroupTypes.Prisoners));
        h.suspect(msg);
        h.take(specialJailPoster);
    }

}
