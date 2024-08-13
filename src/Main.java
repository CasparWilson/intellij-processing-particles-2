import processing.core.PApplet;
import java.util.Random;


public class Main extends PApplet {
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
        particles = createRandomParticles(10);
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

    private Particle[] createRandomParticles(int numParticles){
        Random rand = new Random();
        Particle[] particles = new Particle[numParticles];
        for (int i = 0; i < numParticles; i++) {
            if(rand.nextBoolean()){
                particles[i] = Spark.createRandomSpark(this);
            } else
                particles[i] = Teleporter.createRandomTeleporter(this);
        }
        return particles;
    }
}