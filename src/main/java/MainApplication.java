import core.Color;
import core.RainStream;
import processing.core.PApplet;
import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class MainApplication extends PApplet {
    private List<RainStream> streams;

    public static void main(String[] args) {
        PApplet.main(MainApplication.class);
    }

    public void setup() {
        noCursor();
        background(0);
        streams = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < width / 50; i++) {
            RainStream stream = new RainStream(this, RandomUtil.getRandomInt(8, 20));
            stream.setVelocity((float) RandomUtil.getRandomDouble(1.0, 2.0));
            stream.setColor(new Color(RandomUtil.getRandomInt(1, 255),
                    RandomUtil.getRandomInt(1, 255),
                    RandomUtil.getRandomInt(1, 255)));
            stream.generateStream(x, RandomUtil.getRandomInt(-1000, 0));
            streams.add(stream);
            x += 50;
        }
    }

    public void settings() {
        fullScreen();
    }

    public void draw() {
        background(0);
        streams.forEach(RainStream::show);
    }
}
