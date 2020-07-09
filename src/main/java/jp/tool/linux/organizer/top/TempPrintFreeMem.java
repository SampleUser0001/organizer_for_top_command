package jp.tool.linux.organizer.top;

import java.io.IOException;
import java.io.BufferedWriter;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import jp.tool.linux.organizer.top.model.MemModel;
import jp.tool.linux.organizer.top.model.TopItemModel;

public class TempPrintFreeMem {

    public static final Path OUTPUT_PATH = 
        Paths.get(System.getProperty("user.dir"),"output","free-mem.csv");

    public static void main(String[] args) {
        
        try (BufferedWriter writer = Files.newBufferedWriter(OUTPUT_PATH)) {
            List<Path> pathList
             = Files.walk(Paths.get(args[0]), 1)
                 .filter(path -> !Files.isDirectory(path))
                 .collect(Collectors.toList());
            for(Path path : pathList) {
                List<String> lineList = Files.readAllLines(path);
                int index = 3;
                writer.write(new MemModel(lineList.get(index++)).getFree() + "\n");
            }
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        
    }
}