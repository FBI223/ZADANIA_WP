import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

abstract class Address{

    public String country;
    public String street;
    public String city;
    public String postalCode;

    protected FileSaver saver;
    public abstract void save_to_file(String path) throws Exception;

    public Address() {}


    public abstract String getSpecificData();
    public abstract String[] getData();

    public void changeSaver( FileSaver saver ){
        this.saver = saver;
    }
}

class PolishAddress extends Address{

    public String voievodship;

    public PolishAddress(String street, String city, String postalCode, String province, FileSaver saver) {
        this.country = "PL";
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.voievodship = province;
        this.saver = saver;
    }

    @Override
    public void save_to_file(String path) throws Exception {
        saver.save(this,path);
    }

    @Override
    public String getSpecificData() {
        return voievodship;
    }

    @Override
    public String[] getData() {
        return new String[] {country, street, city, postalCode, voievodship};
    }
}


class JapaneseAddress extends Address{

    public String prefecture;

    public JapaneseAddress(String street, String city, String postalCode, String prefecture , FileSaver saver) {
        this.country = "JP";
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.prefecture = prefecture;
        this.saver = saver;
    }

    @Override
    public String[] getData() {
        return new String[]{country, street, city, postalCode, prefecture};
    }

    @Override
    public void save_to_file(String path) throws Exception {
        saver.save(this,path);
    }

    @Override
    public String getSpecificData() {
        return prefecture;
    }
}


interface FileSaver {
    void save(Address address, String filePath) throws Exception;
}


class XMLFileSaver implements FileSaver
{

    @Override
    public void save(Address address, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("<address>\n");
            writer.write("    <country>" + address.country + "</country>\n");
            writer.write("    <street>" + address.street + "</street>\n");
            writer.write("    <city>" + address.city + "</city>\n");
            writer.write("    <postalCode>" + address.postalCode + "</postalCode>\n");
            writer.write("    <specificData>" + address.getSpecificData() + "</specificData>\n");
            writer.write("</address>");
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania pliku XML: " + filePath);
            throw e;
        }
    }
}


class CSVFileSaver implements FileSaver {

    @Override
    public void save(Address address, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            String[] data = address.getData();
            writer.write(String.join(",", data) + "\n");
        }
        catch (IOException e) {
            System.err.println("Błąd podczas zapisywania pliku CSV: " + filePath);
            throw e;
        }
    }
}

class FixedLengthFileSaver implements FileSaver
{

    @Override
    public void save(Address address, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String field : address.getData()) {
                // Każde pole ma maksymalnie 15 znaków
                if (field.length() > 15) {
                    writer.write(field.substring(0, 15));
                } else {
                    writer.write(String.format("%-15s", field));
                }
            }
            writer.write("\n");
        }
        catch (IOException e) {
            System.err.println("Błąd podczas zapisywania pliku FIXED: " + filePath);
        }
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        XMLFileSaver saverXML = new XMLFileSaver();
        CSVFileSaver saverCSV = new CSVFileSaver();
        FixedLengthFileSaver saverFixed = new FixedLengthFileSaver();



        PolishAddress krakowski_adddy = new PolishAddress("Na zjezdzie 123","Krakow","30-333","malopolskie",saverXML);
        JapaneseAddress tokio_addy = new JapaneseAddress("shibuya 321","Tokyo" , "1111-13213", "metropolitarian-prefecture" , saverCSV);
        tokio_addy.save_to_file("tokio.csv");
        tokio_addy.changeSaver(saverFixed);
        tokio_addy.save_to_file("tokio.fixed");
        krakowski_adddy.save_to_file( "polishAddress.xml");
    }
}

