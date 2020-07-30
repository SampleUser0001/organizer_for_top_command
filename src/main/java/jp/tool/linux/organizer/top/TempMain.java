package jp.tool.linux.organizer.top;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import jp.tool.linux.organizer.top.model.MemModel;
import jp.tool.linux.organizer.top.model.TopItemModel;

public class TempMain {
    public static void main(String[] args) {
        try {
            System.out.println(Paths.get(args[0]).toAbsolutePath());
            List<Path> pathList
             = Files.walk(Paths.get(args[0]), 1)
                 .filter(path -> !Files.isDirectory(path))
                 .collect(Collectors.toList());
            for(Path path : pathList) {
                System.out.println(path);
                List<String> lineList = Files.readAllLines(path);
                int index = 3;
                System.out.println(new MemModel(lineList.get(index++)).toString());

                for( index = 7 ; index < lineList.size() ; index++ ) {
                    String line = lineList.get(index);
                    if(!StringUtils.isEmpty(line)) {
                        System.out.println(new TopItemModel(line).toString());
                    }
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        
    }
}