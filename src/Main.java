import processing.core.PApplet;
import java.util.Arrays;


public class Main extends PApplet {
    Spark[] sparks;
    Teleporter[] teleporters;
    Particle[] particles;
    public static void main(String[] args) {
        PApplet.main(new String[]{"Main"});
    }
    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {
        sparks = Spark.createSparks(this, 100);
        teleporters = Teleporter.createTeleporters(this, 50);
        particles = new Particle[sparks.length + teleporters.length];
        System.arraycopy(sparks, 0, particles, 0, sparks.length);
        System.arraycopy(teleporters, 0, particles, sparks.length, teleporters.length);
    }


    @Override
    public void draw() {
    background(100);
        for (Particle p : particles){
            p.display();
        }

        for (Particle p : particles){
            p.update();
        }
    }
}