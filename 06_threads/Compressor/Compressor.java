package Compressor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Compressor {

    public static void compress(String baseAddress) throws IOException {
        File baseAddressFolder = new File(baseAddress);
        if(!baseAddressFolder.exists())
            baseAddressFolder.mkdir();
        File moviesFolder = new File(baseAddress + "movies");
        if(!moviesFolder.exists())
            moviesFolder.mkdir();
        FileWriter outputFileWriter = new FileWriter(baseAddress + "out.txt");
        for(File movieFile: Objects.requireNonNull(moviesFolder.listFiles())) {
            Scanner fileScanner = new Scanner(movieFile);
            String name = "-", link = "-", rating = "-", director = "-";

            while(fileScanner.hasNextLine()) {
                String tag = fileScanner.next(),
                    value = fileScanner.nextLine().trim();
                switch(tag.toLowerCase()) {
                    case "name:":
                        name = value; break;
                    case "link:":
                        link = value; break;
                    case "rating:":
                        rating = value; break;
                    case "director:":
                        director = value; break;
                    default:
                        throw new IOException("File is not in supported format!");

                }
            }
            fileScanner.close();
            outputFileWriter.write(String.format("%s;%s;%s;%s\n", name, link, rating, director));
        }
        outputFileWriter.close();
    }

    public static void main(String[] args) {
        try {
            String baseAddress = new Scanner(System.in).nextLine();
            compress(baseAddress);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}