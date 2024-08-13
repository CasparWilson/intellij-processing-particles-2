import processing.core.PApplet;

public class Teleporter implements Particle {
    private final PApplet p5;
    private float size;
    private float x;
    private float y;
    private int myColour;

    public static Teleporter createRandomTeleporter(PApplet p5) {
        float x = p5.random(0f, 800f);
        float y = p5.random(0f, 600f);
        float size = p5.random(10, 50);
        return new Teleporter(p5, x, y, size);
    }

    public Teleporter(PApplet p5, float x, float y, float size) {
        this.p5 = p5;
        this.x = x;
        this.y = y;
        this.size = size;
        this.myColour = p5.color(p5.random(0, 255), p5.random(0, 255), p5.random(0, 255));
    }

    public void display() {
        p5.fill(myColour);
        p5.circle(x, y, size);
    }
    public void update() {
        x = p5.random(0f, 800f);
        y = p5.random(0f, 600f);
        size = PApplet.constrain(size + p5.random(-1, 1), 5, 100);
    }
}
