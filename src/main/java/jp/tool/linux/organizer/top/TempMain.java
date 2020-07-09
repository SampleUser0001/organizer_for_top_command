package jp.tool.linux.organizer.top;

import java.io.IOException;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import jp.tool.linux.organizer.top.model.TopItemModel;

public class TempMain {
    public static void main(String[] args) {
        try {
            List<Path> pathList = Files.walk(Paths.get(args[0]), 1)
                 .filter(path -> !Files.isDirectory(path))
                 .collect(Collectors.toList());
            for(Path path : pathList) {
                System.out.println(path);
                try {
                    Stream<String> lineStream = Files.lines(path);
                    lineStream.skip(7)
                              .forEach(line -> {
                        if(!StringUtils.isEmpty(line)) {
                            System.out.println(new TopItemModel(line).toString());
                        }
                    });
                    // lineStream
                    //     .skip(7);
                    //     .forEach(line -> {
                    //         System.out.println(new TopItemModel(line).toString());
                    // });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}