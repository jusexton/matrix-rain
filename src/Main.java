import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Main extends PApplet {
    private List<RainStream> streams;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void setup() {
        noCursor();
        background(0);
        streams = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < width / 50; i++) {
            RainStream stream = new RainStream(this, MathUtil.getRandomInt(8, 20));
            stream.setVelocity((float) MathUtil.getRandomDouble(1.0, 2.0));
            stream.setColor(new Color(MathUtil.getRandomInt(1, 255),
                    MathUtil.getRandomInt(1, 255),
                    MathUtil.getRandomInt(1, 255)));
            stream.generateStream(x, MathUtil.getRandomInt(-1000, 0));
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
