package jp.tool.linux.organizer.top.enums;

public enum SizeUnitEnum {
    KiB(1024),
    MiB(1024*1024),
    GiB(1024*1024*1024);

    private final long size;

    private SizeUnitEnum(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }
}