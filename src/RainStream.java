import processing.core.PApplet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Stores symbols and displays them in formation.
 */
public class RainStream {
    private int length;
    private Queue<Symbol> stream;
    private PApplet parent;
    private float fadeInterval = 1f;
    private float velocity = 3f;
    private Color color;
    private boolean fade = true;

    public RainStream(final PApplet parent, final int length) {
        this.parent = parent;
        this.length = length;
        this.stream = new LinkedList<>();
    }

    /**
     * Generates a stream of symbols and stores them within the instance.
     *
     * @param x The x position at which the stream will be generated/
     * @param y The y position at which the stream will be generated.
     */
    public void generateStream(float x, float y) {
        int opacity = 255;
        for (int i = 0; i < length; i++) {
            Symbol symbol = new Symbol(parent, x, y);
            symbol.setOpacity(opacity);
            symbol.setVelocity(velocity);
            if (color != null) {
                symbol.setColor(color);
            }
            stream.add(symbol);
            y -= symbol.getSize();
            if (fade) {
                opacity -= (255 / length) / fadeInterval;
            }
        }
    }

    /**
     * Displays the generated stream.
     */
    public void show() {
        stream.forEach(Symbol::show);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Queue<Symbol> getStream() {
        return stream;
    }

    public void setStream(Queue<Symbol> stream) {
        this.stream = stream;
    }

    public PApplet getParent() {
        return parent;
    }

    public void setParent(PApplet parent) {
        this.parent = parent;
    }

    public float getFadeInterval() {
        return fadeInterval;
    }

    public void setFadeInterval(float fadeInterval) {
        this.fadeInterval = fadeInterval;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean willFade() {
        return fade;
    }

    public void setFade(boolean fade) {
        this.fade = fade;
    }
}
