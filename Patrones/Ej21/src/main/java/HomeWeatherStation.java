import java.util.List;

public class HomeWeatherStation {
    //retorna la temperatura en grados Fahrenheit.
    public double getTemperatura(){
        return 2.5;
    }

    //retorna la presión atmosférica en hPa
    public double getPresion(){
        return 1008;
    }

    //retorna la radiación solar
    public double getRadiacionSolar(){
        return 300;
    }

    //retorna una lista con todas las temperaturas sensadas hasta el momento, en grados Fahrenheit
    public List<Double> getTemperaturas(){
        return List.of(2.5, 6.5, 4.3);
    }

    //retorna  un reporte de todos los datos: temperatura, presión, y radiación solar.
    public String displayData(){
        return "Temperatura F: " + this.getTemperatura() +
                "Presión atmosf: " + this.getPresion() +
                "Radiación solar: " + this.getRadiacionSolar();
    }

}
