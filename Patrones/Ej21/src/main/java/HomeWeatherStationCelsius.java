import java.util.List;
import java.util.stream.Collectors;

public class HomeWeatherStationCelsius extends HomeWeatherStation {
    @Override
    public double getTemperatura(){
        return (2.5 - 32) / 1.8;
    }

    @Override
    //retorna una lista con todas las temperaturas sensadas hasta el momento, en grados Fahrenheit
    public List<Double> getTemperaturas(){
        return super.getTemperaturas().stream()
                .map(temp -> (temp -32) / 1.8)
                .collect(Collectors.toList());
    }

    @Override
    //retorna  un reporte de todos los datos: temperatura, presión, y radiación solar.
    public String displayData(){
        return "Temperatura F: " + this.getTemperatura() +
                "Presión atmosf: " + this.getPresion() +
                "Radiación solar: " + this.getRadiacionSolar();
    }
}
