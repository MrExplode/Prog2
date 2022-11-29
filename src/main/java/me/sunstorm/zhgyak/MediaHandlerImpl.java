package me.sunstorm.zhgyak;

import me.sunstorm.zhgyak.domain.Picture;
import me.sunstorm.zhgyak.domain.Video;
import me.sunstorm.zhgyak.exceptions.MediaNotFoundException;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.StreamSupport;

public class MediaHandlerImpl implements MediaHandler {
    private final MediaFileContainer container = new MediaFileContainer();

    @Override
    public void captureScreenShot(String name) {
        var screenshot = new Picture(
                LocalDate.now() + "_" + name,
                ThreadLocalRandom.current().nextLong(5000) + 1000,
                "1920x1080");
        container.add(screenshot);
    }

    @Override
    public void captureVideo(String name) {
        var video = new Video(
                LocalDate.now() + "_" + name,
                ThreadLocalRandom.current().nextLong(10000) + 2000,
                ThreadLocalRandom.current().nextLong(10000) + 2000);
        container.add(video);
    }

    @Override
    public Video playVideo(String name) {
        return StreamSupport.stream(container.spliterator(), false)
                .filter(Video.class::isInstance)
                .filter(m -> m.getName().equals(name))
                .map(Video.class::cast)
                .findFirst().orElseThrow(() -> new MediaNotFoundException(name));
    }

    @Override
    public Picture showPicture(String name) {
        return StreamSupport.stream(container.spliterator(), false)
                .filter(Picture.class::isInstance)
                .filter(m -> m.getName().equals(name))
                .map(Picture.class::cast)
                .findFirst().orElseThrow(() -> new MediaNotFoundException(name));
    }
}
