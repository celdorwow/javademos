package fwp.domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import fwp.io.ResourcesReader;

public class LoadFile {
    private final String fileName;
    private final List<String> lines;

    public LoadFile(String fileName) {
        this.lines = new ArrayList<>();
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public List<String> getLines() {
        return lines;
    }

    public void read() throws FileNotFoundException {
        ResourcesReader.getReader(fileName, Main.class)
            .lines()
            .map(e -> String.join(" ::: ", e.split(",")))
            .forEach(lines::add);
    }
}
