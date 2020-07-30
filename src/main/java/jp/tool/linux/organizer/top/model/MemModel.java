package jp.tool.linux.organizer.top.model;

import jp.tool.linux.organizer.top.enums.SizeUnitEnum;

import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;

import org.apache.commons.lang3.StringUtils;
import lombok.Data;

@Data
public class MemModel {
    private SizeUnitEnum unit;

    private double total;
    private double used;
    private double free;
    private double buff;

    public MemModel(String line) throws IllegalArgumentException {
        String[] splited = line.split(":");
        try {
            unit = SizeUnitEnum.valueOf(splited[0].split(" ")[0]);
        } catch (IllegalArgumentException | NullPointerException e) {
            unit = null;
        }

        String[] values = splited[1].split(",");
        int index = 0;
        total = getValue(values[index++]);
        used = getValue(values[index++]);
        free = getValue(values[index++]);
        buff = getValue(values[index++]);
    }

    private static double getValue(String value) throws IllegalArgumentException {
        for(String v : value.split(" ")){
            if(!StringUtils.isEmpty(v)){
                return Double.parseDouble(v);
            }
        }
        throw new IllegalArgumentException("Can't get value : " + value);
    }
}