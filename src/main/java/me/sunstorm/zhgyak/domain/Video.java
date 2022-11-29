package me.sunstorm.zhgyak.domain;

public class Video extends MediaFile {
    private final long length;

    public Video(String name, Long size, long length) {
        super(name, size);
        this.length = length;
    }

    public long getLength() {
        return length;
    }
}
