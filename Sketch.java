import processing.core.PApplet;

public class Sketch extends PApplet {
	
  int cellWidth = 20;
  int cellHeight = 20;
  int cellMargin = 5;

  int rowCount = 10;
  int columnCount = 10;

  int rowCheck = -1;
  int columnCheck = -1;

  int width = (cellWidth * rowCount) + (cellMargin * (rowCount + 1));
  int height = (cellHeight * columnCount) + (cellMargin * (columnCount + 1));

  int[][] intGrid = new int[rowCount][columnCount];

  int mouseSquareX = 300;
  int mouseSquareY = 300;

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

    intGrid[1][1] = 1;
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    //println(width + " " + height);

    columnCheck = -1;
	  for(int column = cellMargin; column < width; column += (width/columnCount)){
      columnCheck += 1;
      rowCheck = -1;
      for(int row = cellMargin; row < height; row += (height/columnCount)){
        rowCheck += 1;
        if(intGrid[rowCheck][columnCheck] == 1){
          fill(0,255,0);
          rect(row, column, cellWidth, cellHeight);
        } else if(intGrid[rowCheck][columnCheck] == 0){
          fill(255,255,255);
          rect(row, column, cellWidth, cellHeight);
        }

        if (mouseSquareX == rowCheck && mouseSquareY == columnCheck){
          intGrid[rowCheck][columnCheck] = 1;
        }
      }
    }
  }

  public void mousePressed(){
    mouseSquareX = (int)(mouseX/25.5);
    mouseSquareY = (int)(mouseY/25.5);
    println("click " + mouseX + " " + mouseY + " " + mouseSquareX + " " + mouseSquareY);
  }
}
