package vitalkrilov.itmo.prog.lab3.world;

public enum WeatherType {

    Clear,
    Sunny,
    PartlySunny,
    PartlyCloudy,
    SunAndRain,
    Raining,
    Thunderstorms,
    Snowing,
    Cloudy,
    Windy,
    Rainbow,
    TornadoesOrHurricanes;

    @Override
    public String toString() {
        return switch (this) {
            case Clear -> "Ясная";
            case Sunny -> "Солнечная";
            case PartlySunny -> "Переменная_солнечная";
            case PartlyCloudy -> "Переменная_облачность";
            case SunAndRain -> "Солнечная_с_дождём";
            case Raining -> "Дождливая";
            case Thunderstorms -> "Гроза";
            case Snowing -> "Снег";
            case Cloudy -> "Облачная";
            case Windy -> "Ветреная";
            case Rainbow -> "Радуга";
            case TornadoesOrHurricanes -> "Торнадо_или_ураган";
        };
    }

}