import java.io.*;

public class Main {


    public static void main(String[] args) {
        /*DataStreams datastream = new DataStreams("src\\main\\resources\\file.dat");
        datastream.streamWrite();
        datastream.streamRead();*/

        TemperatureFileReader temperatureFileReader = new TemperatureFileReader();
        temperatureFileReader.readFile("src\\main\\resources\\netatmo-export-201801-201804.csv");
        temperatureFileReader.printStatistics();
    }
}
