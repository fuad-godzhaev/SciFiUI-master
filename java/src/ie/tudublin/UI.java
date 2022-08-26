package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    Radar radar;
    StatusBar sb;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        //size(800, 800);
        //Use fullscreen instead of size to make your interface fullscreen
        fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, -70, 600);
        radar = new Radar(this, 1, width / 2, height / 2, 100);
        sb = new StatusBar(this, -80, 650);
    }

    public void draw()
    {
        background(255, 255, 255);
        b.render();

        radar.update();
        radar.render();

        sb.update();
        sb.render();
    }
}

