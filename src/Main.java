import processing.core.PApplet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;


public class Main extends PApplet {
    ArrayList<Particle> particles;

    public static void main(String[] args) {
        PApplet.main(new String[]{"Main"});
    }

    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {
        particles = createRandomParticles(1);
    }

    @Override
    public void draw() {
        background(100);
        for (Particle p : particles) {
            p.display();
        }
        for (Particle p : particles) {
            p.update();
        }
    }

    private ArrayList<Particle> createRandomParticles(int numParticles) {
        ArrayList<Particle> particles = new ArrayList();
        for (int i = 0; i < numParticles; i++) {
            addRandomParticles(particles);
        }
        return particles;
    }

    private void addRandomParticles(ArrayList<Particle> particles) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            particles.add(Spark.createRandomSpark(this));
        } else
            particles.add(Teleporter.createRandomTeleporter(this));
    }

    public void mousePressed() {
        addRandomParticles(particles);
        println("Mouse button pressed!");
        background(random(255), random(255), random(255));
    }
}