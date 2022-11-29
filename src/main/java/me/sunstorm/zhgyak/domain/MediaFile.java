package me.sunstorm.zhgyak.domain;

public abstract class MediaFile {
    private final String name;
    private final Long size;

    protected MediaFile(String name, Long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Long getSize() {
        return size;
    }
}
