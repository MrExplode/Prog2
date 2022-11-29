package me.sunstorm.zhgyak;

import me.sunstorm.zhgyak.domain.MediaFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MediaFileContainer implements Iterable<MediaFile> {
    private final List<MediaFile> mediaFileList = new ArrayList<>();

    public void add(MediaFile file) {
        mediaFileList.add(file);
    }

    @Override
    public Iterator<MediaFile> iterator() {
        return mediaFileList.iterator();
    }

    @Override
    public void forEach(Consumer<? super MediaFile> action) {
        mediaFileList.forEach(action);
    }

    @Override
    public Spliterator<MediaFile> spliterator() {
        return mediaFileList.spliterator();
    }
}
