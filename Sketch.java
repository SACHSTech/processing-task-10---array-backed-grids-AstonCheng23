import processing.core.PApplet;

public class Sketch extends PApplet {
	
  int cellWidth = 20;
  int cellHeight = 20;
  int cellMargin = 5;

  int rowCount = 10;
  int columnCount = 10;

  int width = (cellWidth * rowCount) + (cellMargin * (rowCount + 1));
  int height = (cellHeight * columnCount) + (cellMargin * (columnCount + 1));

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(width, height);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0, 0, 0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    println(width + " " + height);
	  for(int column = 0; column < width; column += (width/columnCount)){
      //column += cellMargin;
      rect(column, 0, 25, 25);
    }
  }

  public void mousePressed(){
    
  }
}
