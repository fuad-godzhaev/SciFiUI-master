package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PShape;
import java.util.Random;

import org.w3c.dom.Text;

import processing.core.PConstants;


public class StatusBar /*extends UI*/
{
    private UI ui;
    private float x;
    private float y;
    private float arc_1 = PApplet.PI + PApplet.HALF_PI;
    private float size1 = 200;
    private float size2 = 180;
    private float gap_y = 30;
    private float gap_x = 75;
    private int r = 0;
    private int g = 0;
    private int b = 0;
    private float deg = 0;
    private int degree = 15;
    private float design = 10;
    private float theta = 0;
    private Random rand = new Random();
    PShape bar;
    PShape box;
    PShape speed;

    public StatusBar(UI ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
    }
    
    public void render()
    {        
        //Shapes for status bar, such as health, oxygen etc.
        bar = ui.createShape();
        bar.beginShape();
        bar.fill(187 + r, 233 + g, 246 + b, 255);
        bar.stroke(0);
        
        bar.vertex(100, 5);
        bar.vertex(100, 15);
        bar.vertex(65, 15);
        bar.vertex(80, 5);
        
        bar.vertex(140, 5);
        bar.vertex(140, 15);
        bar.vertex(105, 15);
        bar.vertex(105, 5);
        
        bar.vertex(180, 5);
        bar.vertex(180, 15);
        bar.vertex(145, 15);
        bar.vertex(145, 5);

        bar.vertex(185, 5);
        bar.vertex(185, 15);
        bar.vertex(220, 15);
        bar.vertex(205, 5);
        bar.vertex(185, 5);
        bar.endShape();
        

        //Shapes for the box in which all the status info will be stored
        box = ui.createShape();
        box.beginShape();
        box.stroke(0);
        box.fill(35, 40, 39, 70);

        box.vertex(100, 10);
        box.vertex(110, 5);
        box.vertex(340, 5); 
        box.vertex(350, 15); 
        box.vertex(510, 15); 
        box.vertex(520, 25); 
        box.vertex(520, 95); 
        box.vertex(450, 165);
        box.vertex(340, 165);
        box.vertex(335, 160);
        box.vertex(110, 160);
        box.vertex(100, 155);
        box.vertex(100, 10);
        box.endShape();

        //Shapes for the speed bar
        
        speed = ui.createShape();
        speed.beginShape();
        //speed.noFill();
        speed.stroke(187, 233, 246, 255);
        speed.strokeWeight(40);
        speed.strokeCap(PConstants.SQUARE);
        speed.strokeJoin(PConstants.ROUND);

        speed.vertex(160, 70);
        speed.vertex(130, 70);
        speed.vertex(100, 75);
        speed.vertex(70, 90);
        speed.vertex(50, 120);
        speed.vertex(45, 185);
        
        speed.endShape();

        //Drawing pre-defined shapes

        ui.shape(bar, x + gap_x, y + gap_y); //680
        ui.shape(bar, x + gap_x, y + 2*gap_y); //710
        ui.shape(bar, x + gap_x, y + 3*gap_y); //740
        ui.shape(bar, x + gap_x, y + 4*gap_y); //770

        ui.shape(box, x, y);
 
        ui.shape(speed, x + 4*gap_x + 30, y - gap_y);
 
    }

    
    float time;
    float timeDelta = 1.0f / 60.0f;


    public void update()
    {
        time += timeDelta;
        //randomising temperature every 0.2 seconds
        if(time > 0.2)
        {
            arc_1 = PApplet.PI + rand.nextFloat()*(PApplet.TWO_PI - PApplet.PI);
            deg = PApplet.map(arc_1, PApplet.PI, PApplet.TWO_PI,-40, 40);
            time =0;
        }
    }
    
}