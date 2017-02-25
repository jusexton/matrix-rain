import processing.core.PApplet;

/**
 * Represents a symbol that will drift and change as it is
 * continuously displayed
 */
public class Symbol {
    private float xPosition;
    private float yPosition;
    private char symbol;
    private PApplet parent;
    private float size = 35f;
    private float velocity = 3f;
    private int changeInterval;
    private Color color;
    private int opacity = 255;

    public Symbol(final PApplet parent,
                  final float xPosition,
                  final float yPosition) {
        this.parent = parent;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        // Sets symbol to a random Katakana character.
        this.symbol = generateRandomSymbol(0x30A0, 96);
        changeInterval = MathUtil.getRandomInt(15, 25);
        color = new Color(0, 255, 70);
    }

    public Symbol(final PApplet parent,
                  final float xPosition,
                  final float yPosition,
                  final char symbol) {
        this(parent, xPosition, yPosition);
        this.symbol = symbol;
    }

    /**
     * Returns a random character given the origin and bounds. Mostly
     * used to generate one of 96 Katakana symbols.
     *
     * @param origin The origin of randomness
     * @param bound  The bound of randomness
     * @return The randomly generated character
     */
    public static char generateRandomSymbol(final int origin, final int bound) {
        return (char) (origin + MathUtil.getRandomInt(0, bound));
    }

    /**
     * Displays the symbol instance onto the parent
     * and updates the instance.
     */
    public void show() {
        parent.fill(color.getRed(), color.getGreen(), color.getBlue(), opacity);
        // TODO: Fix this dumb bug
        // parent.textSize(size);
        parent.text(symbol, xPosition, yPosition);
        update();
    }

    /**
     * Responsible for changing the symbol during display and
     * progressing the symbol down the screen.
     */
    private void update() {
        if (yPosition >= parent.height) {
            yPosition = 0;
        }
        if (parent.frameCount % changeInterval == 0) {
            symbol = generateRandomSymbol(0x30A0, 96);
        }
        yPosition += velocity;
    }

    public float getxPosition() {
        return xPosition;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PApplet getParent() {
        return parent;
    }

    public void setParent(PApplet parent) {
        this.parent = parent;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public int getChangeInterval() {
        return changeInterval;
    }

    public void setChangeInterval(int changeInterval) {
        this.changeInterval = changeInterval;
    }

    public int getOpacity() {
        return opacity;
    }

    public void setOpacity(int opacity) {
        this.opacity = opacity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
