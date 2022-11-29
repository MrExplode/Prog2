package me.sunstorm.zhgyak.domain;

public class Picture extends MediaFile {
    private final String resolution;

    public Picture(String name, Long size, String resolution) {
        super(name, size);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }
}
