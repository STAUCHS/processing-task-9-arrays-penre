import processing.core.PApplet;

public class Sketch extends PApplet {

  float [] snowX = new float [30];
  float [] snowY = new float [30];  
  boolean [] ballHideStatus = new boolean [30];

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
    for (int i = 0; i < snowX.length; i++){
      //generate random x and y values for snowflakes
      snowX[i] = random(width);
      snowY[i] = random(height);
      ballHideStatus[i] = false;
    }
  }
    
  public void draw() {

    //if lives is 0 then screen turns white
    if (intLives == 0){
      background(255);
    }
    else {
      background(0);
    
      //draw snow
      snow();

      //lives
      for (int i = 1; i <= intLives; i++){
        fill(255, 0, 0);
        rect (width - i * 50, height - 400, 40, 40);
      }

      //draw player
      player();
    }
  }
    
  public void snow(){
    fill (255);
    for (int i = 0; i < snowX.length; i++){
      //reset snowflakes
      if (snowY[i] > height){
        snowY[i] = -10;
      }

      //clicking snow to clear
      if (!ballHideStatus[i]){
        circle(snowX[i], snowY[i], snowDiameter);

        //collision with player
        if (dist(snowX[i], snowY[i], circleX, circleY) < snowDiameter / 2 + playerSize / 2 ){
          snowY[i] = 0;
          intLives --;
        }

        // mouse clicks
        if (mousePressed){
          if (dist(mouseX, mouseY, snowX[i], snowY[i]) < snowDiameter){
            ballHideStatus[i] = true;
          }
        }

        //controls speed of snow
        if (keyCode == UP){
          snowY[i] -= 1;
        } 
        else if (keyCode == DOWN){
          snowY[i] += 10;
        }
        else{
          snowY[i] += 2;
        }
      }
    }
  }

  //player circle moving around
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
  
    
  
