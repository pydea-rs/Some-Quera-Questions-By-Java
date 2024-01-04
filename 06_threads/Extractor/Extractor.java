package Extractor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Extractor {
    public static void extract(String baseAddress) throws IOException {
        File baseAddressFolder = new File(baseAddress);
        if(!baseAddressFolder.exists())
            baseAddressFolder.mkdir();
        File inputFile = new File(baseAddress + "in.txt");
        final String moviesLocation = baseAddress + "movies";
        File moviesFolder = new File(moviesLocation);
        if(!moviesFolder.exists())
            moviesFolder.mkdir();
        Scanner fileScanner = new Scanner(inputFile);
        while(fileScanner.hasNextLine()) {
            final String nextMovie = fileScanner.nextLine().trim();
            String[] metadata = nextMovie.split(";");
            if(metadata.length != 4)
                throw new IOException("Input file is not in the standard format!");
            final String fileName = metadata[0].replaceAll("[\\\\/:*?'\"<>|]", "");
            FileWriter movieFileWriter = new FileWriter(String.format("%s/%s.txt", moviesFolder, fileName));
            movieFileWriter.write(String.format("Name: %s\nLink: %s\nRating: %s\nDirector: %s",
                    metadata[0], metadata[1], metadata[2], metadata[3]));
            movieFileWriter.close();
        }

    }

    public static void main(String[] args) {
        try {
            extract(new Scanner(System.in).nextLine());
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}