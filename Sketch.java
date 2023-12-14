import processing.core.PApplet;
import java.util.Random;
import processing.core.PImage; 

public class Sketch extends PApplet {

  PImage img;
	
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(colour1, colour2, colour3);
    // Loads the cat image
    img = loadImage("cat.png");
    img.resize(50, 50);
  }
  
  // Background colour is randomized
  Random myRandom = new Random();
  int colour1 = myRandom.nextInt(255);
  int colour2 = myRandom.nextInt(255);
  int colour3 = myRandom.nextInt(255);

  // Booleans to support handling multiple keys
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  // The position of the smiley face, so it can move
  float smileyX = 50;
  float smileyY = 50;

  public void draw() {

    // Randomizes background colour if you press r, g, or b
    if (keyPressed) {
      if (key == 'r') {
        int colour2 = myRandom.nextInt(255);
        int colour3 = myRandom.nextInt(255);
        background(colour1, colour2, colour3);
      }
      else if (key == 'g') {
        int colour1 = myRandom.nextInt(255);
        int colour3 = myRandom.nextInt(255);
        background(colour1, colour2, colour3);
      }
      else if (key == 'b') {
        int colour1 = myRandom.nextInt(255);
        int colour2 = myRandom.nextInt(255);
        background(colour1, colour2, colour3);
      }
    }

    // Moves the smiley face
    if (keyPressed) {
      if (upPressed) {
        smileyY -= 10;
      }
      if (downPressed) {
        smileyY += 10;
      }
      if(leftPressed){
        smileyX -= 10;
      }
      if(rightPressed){
       smileyX += 10;
      }
    }

    // Draws a flower when the user pressed their mouse
    if (mousePressed) {
      drawFlower(mouseX, mouseY, 5);
    }

    // Smiley face drawings constantly repeat so movement can work
    drawSmileyFace(smileyX, smileyY, 30);
  }

  /**
  * Draws a flower given the parameters
  *
  * @param x  The x coordinate of where the flower is drawn
  * @param y  The y coordinate of where the flower is drawn
  * @param radius  How big the flower is
  *
  */  
  public void drawFlower(float x, float y, float radius) {
    fill(255, 0, 0);
    ellipse(x, y - radius, radius * 2, radius * 2);
    ellipse(x, y + radius, radius * 2, radius * 2);
    ellipse(x - radius, y, radius * 2, radius * 2);
    ellipse(x + radius, y, radius * 2, radius * 2);
  }

  /**
  * Draws a smiley face given the parameters
  *
  * @param x  The x coordinate of where the face is drawn
  * @param y  The y coordinate of where the face is drawn
  * @param diameter  How big the smiley face is
  *
  */  
  public void drawSmileyFace(float x, float y, float diameter) {
    fill(255,255,153);
    ellipse(x, y, diameter, diameter);

    noStroke();
    fill(0);
    float eyeSize = diameter / 10;
    ellipse(x - diameter / 5, y - diameter / 10, eyeSize, eyeSize);
    ellipse(x + diameter / 5, y - diameter / 10, eyeSize, eyeSize);

    noFill();
    stroke(0);
    float smileSize = (diameter * 3) / 5 ;
    arc(x, y, smileSize, smileSize, radians(0), radians(180));
  }

  /**
  * Supports handling multiple keys with booleans
  */  
  public void keyPressed() {
    if (keyCode == UP) {
      upPressed = true;
    }
    else if (keyCode == DOWN) {
      downPressed = true;
    }
    else if (keyCode == LEFT) {
      leftPressed = true;
    }
    else if (keyCode == RIGHT) {
      rightPressed = true;
    }
  }
  
  /**
  * Supports handling multiple keys with booleans
  */
  public void keyReleased() {
    if (keyCode == UP) {
      upPressed = false;
    }
    else if (keyCode == DOWN) {
      downPressed = false;
    }
    else if (keyCode == LEFT) {
      leftPressed = false;
    }
    else if (keyCode == RIGHT) {
      rightPressed = false;
    }
  }

  /**
  * Flower stems are drawn when the mouse is dragged
  */
  public void mouseDragged() {
    noStroke();
    fill(0, 255, 0);
    ellipse(mouseX, mouseY, 8, 8);
  }

  /**
  * Draws grass when user uses mouse wheel
  */
  public void mouseWheel() {
    int intGrassPositionX = myRandom.nextInt(400);
    int intGrassPositionY = myRandom.nextInt(350, 400);
    stroke(0, 200, 0);
    line(intGrassPositionX, intGrassPositionY, intGrassPositionX, 400);
  }

  /**
  * When a mouse press is released, it draws a cat
  */
  public void mouseReleased() {
    image(img, mouseX, mouseY);
  }

}