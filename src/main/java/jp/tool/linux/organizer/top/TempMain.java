package jp.tool.linux.organizer.top;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import jp.tool.linux.organizer.top.model.TopItemModel;

public class TempMain {
    public static void main(String[] args) throws IOException {
        try {
            Files.walk(Paths.get(args[0]), 1)
                 .filter(path -> !Files.isDirectory(path))
                 .map(path -> Files.lines(path))
                 .forEach(stream -> {
                     
                     stream.skip(7);
                     stream.forEach(line -> {
                         System.out.println(new TopItemModel(line).toString());
                     });
                 });
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}