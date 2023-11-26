package Chapter02.Item20;

import java.applet.AudioClip;

public interface SingerSongwriter extends Singer, Songwriter {
    AudioClip strum();
    void actSensitive();
}
