package jp.tool.linux.organizer.top.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class TopItemModel {

    private int pid;
    private String user;
    private String pr;
    private int ni;
    private String virt;
    private String res;
    private String shr;
    private String s;
    private float cpu;
    private float mem;
    private String time;
    private String command;
    
    public TopItemModel(String line) {
        List<String> tmpList = new ArrayList<String>();
        String[] splited = line.split(" ");
        for(String item : splited) {
            if(!StringUtils.isEmpty(item)) {
                tmpList.add(item);
            }
        }
        
        int index = 0;
        pid = Integer.parseInt(tmpList.get(index++));
        user = tmpList.get(index++);
        pr = tmpList.get(index++);
        ni = Integer.parseInt(tmpList.get(index++));
        virt = tmpList.get(index++);
        res = tmpList.get(index++);
        shr = tmpList.get(index++);
        s = tmpList.get(index++);
        cpu = Float.parseFloat(tmpList.get(index++));
        mem = Float.parseFloat(tmpList.get(index++));
        time = tmpList.get(index++);
        command = "";
        for( ; index < tmpList.size() ; ){
            command += tmpList.get(index++) + " ";
        }
        command = command.trim();
    }
    
}