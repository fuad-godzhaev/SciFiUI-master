package ie.tudublin;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Button
{
    UI ui;
    private float x;
    private float y;
    private float gap = 65;
    private float gap_y = 30;
    private float gap_x = 75;
    private int health = 100;
    private int oxygen = 100;
    private int energy = 100;
    private int hydrogen = 100;
    private int speed = 0;
    private int transparacy =  0;
    private int transparacy2 = 0;
    private int transparacy3 = 0;
    PShape button;

    public Button(UI ui, float x, float y)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
    }

    public void render()
    {
        //ui.noFill();
        //ui.stroke(255);
        //ui.rect(x, y, width, height);
        //ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        //ui.text(text, x + width * 0.5f, y + height * 0.5f);


        //Shapes for the buttons
        button = ui.createShape();
        button.beginShape();
        button.stroke(0);
        button.fill(35, 40, 39, 70);
        
        button.vertex(100, 10);
        button.vertex(120, -10);
        button.vertex(160, -10);
        button.vertex(160, 50);
        button.vertex(100, 50);
        button.vertex(100, 10);

        button.endShape();

        String str1 = Integer.toString(health);
        String str2 = Integer.toString(oxygen);
        String str3 = Integer.toString(energy);
        String str4 = Integer.toString(hydrogen);
        String str5 = Integer.toString(speed);
    
        //Drawing the shapes
        ui.pushMatrix();
        ui.fill(0);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(20);
        ui.text("X", x + 135, y);
        ui.text("O", x + 135 + gap, y);
        ui.text("P", x + 135 + 2*gap, y);

        ui.text(str1, x + gap_x + 240, y + gap_y + 60);
        ui.text(str2, x + gap_x + 240, y + 2*gap_y + 60);
        ui.text(str3, x + gap_x + 240, y + 3*gap_y + 60);
        ui.text(str4, x + gap_x + 240, y + 4*gap_y + 60);
        ui.text(str5 + " m/s", x + gap_x + 365, y + 3*gap_y + 60);
        
        ui.text("+", x + gap_x + 40, y + gap_y + 60);
        ui.text("O2", x + gap_x + 40, y + 2*gap_y + 60);
        ui.text("NRG", x + gap_x + 40, y + 3*gap_y + 60);
        ui.text("H", x + gap_x + 40, y + 4*gap_y + 60);

        ui.text("Press x to lift helmet", 1350, 50);
        ui.text("Press o to accelerate", 1350, 100);
        ui.text("Press p to turn on flashlight", 1350, 150);

        ui.fill(255, 0, 0, transparacy);
        ui.text("GAME OVER", 750, 400);

        ui.fill(255, 0, 0, transparacy2);
        ui.textSize(35);
        ui.text("NO FUEL LEFT", 250, 100);

        ui.fill(255, 0, 0, transparacy3);
        ui.textSize(35);
        ui.text("NO ENERGY LEFT", 250, 200);        
        ui.popMatrix();

        ui.shape(button, x, y);
        ui.shape(button, x + gap, y);
        ui.shape(button, x + 2*gap, y);

        if (ui.keyPressed) {
            if (ui.key == 'x')
            {
                if (oxygen > 0)
                {
                    oxygen = oxygen - 1;
                }

                else if (health > 0)
                {
                    ui.pushMatrix();
                    ui.translate(350, 150);
                    ui.textSize(25);
                    ui.text("WARNING: NO OXYGEN LEFT. SUFFOCATION IMMINENT", 0, 0);
                    ui.popMatrix();
                    health = health - 1;
                }

                else if (oxygen == 0 && health == 0)
                {
                    transparacy = 255;
                }
            }
        }

        if (ui.keyPressed) {
            if (ui.key == 'o')
            {
                if (hydrogen > 0)
                {
                    hydrogen = hydrogen - 1;
                    speed = speed + 1;
                }

                else if (hydrogen == 0)
                {
                    transparacy2 = 255;
                }
            }
        }

        if (ui.keyPressed) {
            if (ui.key == 'p')
            {
                if (energy > 0)
                {
                    energy = energy - 1;
                }

                else if (energy == 0)
                {
                    transparacy3 = 255;
                }
            }
        }

    }
}