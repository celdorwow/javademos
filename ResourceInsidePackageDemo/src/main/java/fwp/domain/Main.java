package fwp.domain;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "file.csv";
        LoadFile loader = new LoadFile(fileName);
        loader.read();
    }
}
