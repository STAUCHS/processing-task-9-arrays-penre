import processing.core.PApplet;

public class Sketch extends PApplet {

  float [] snowX = new float [30];
  float [] snowY = new float [30];  
  int snowDiameter = 30;
  float circleX = 200;
  float circleY = 350;
  float livesX = 270;
  float livesY = 40;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0);

    //generate random x and y values for snowflakes
    for (int i = 0; i < snowX.length; i++){
      snowX[i] = random(width);
      snowY[i] = random(height);
    }
  }
    
  public void draw() {
    background(0);
    
    //draw snow
    snow();

    //control speed of snow
    for (int i = 0; i < snowX.length; i++){
      if (keyCode == UP){
        snowY[i] -= 1;
      }
      else if (keyCode == DOWN){
        snowY[i] += 10;
      }
      else if (keyCode == RIGHT){
        snowY[i] += 2;
      }
    }

    //draw player
    player();

    //draw lives 
    lives();
  }
  //snow
  public void snow(){
    fill(255);
    for (int i = 0; i < snowX.length; i++){
      circle(snowX[i], snowY[i], snowDiameter);

      snowY[i] += 2;

      //reset snowflakes
      if (snowY[i] > height){
        snowY[i] = -10;
      }
    }
  }

  //player circle
  public void player(){
    fill(0, 0, 255);
    ellipse(circleX, circleY, 20, 20);
    if (keyPressed){
      if (key == 'w'){
        circleY -= 2;
      }
      else if (key == 's'){
        circleY += 2;
      }
      else if (key == 'a'){
        circleX -= 2;
      }
      else if (key == 'd'){
       circleX += 2;
      }
    }
  }

  //lives
  public void lives(){
    fill (255, 0, 0);
    ellipse (livesX, livesY, 40, 40);
  }

}    
  
    
  
