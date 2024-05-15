import processing.core.PApplet;

public class Sketch extends PApplet {

  float [] snowX = new float [30];
  float [] snowY = new float [30];  
  int snowDiameter = 20;
  int playerSize = 20;
  float circleX = 200;
  float circleY = 350;
  float livesX = 270;
  float livesY = 40;
  int intLives = 3;

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
    if (intLives == 0){
      background(255);
    }
    else {
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

    //lives
    for (int i = 1; i <= intLives; i++){
      fill (255, 0, 0);
      rect(width - i * 50, height - 400, 40, 40);
    }

    //draw player
    player();
    
    }
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

      //collision FINISH LIVES THINGS
      if (dist(snowX[i], snowY[i], circleX, circleY) < snowDiameter / 2 + playerSize / 2 ){
        snowY[i] = 0;
        intLives --;
      }
    }
  }

  //player circle
  public void player(){
    fill(0, 0, 255);
    circle(circleX, circleY, playerSize);
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


 

  
  

}  
  
    
  
