package me.sunstorm.zhgyak;

import me.sunstorm.zhgyak.domain.Picture;
import me.sunstorm.zhgyak.domain.Video;

public interface MediaHandler {

    void captureScreenShot(String name);
    void captureVideo(String name);
    Video playVideo(String name);
    Picture showPicture(String name);
}
