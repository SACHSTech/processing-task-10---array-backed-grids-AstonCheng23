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

  int[] columnColourCheck = new int[10];

  int mouseSquareX = 300;
  int mouseSquareY = 300;

  int checkColouredSquares = 0;
  int checkNotColouredSquares = 100;
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

    //intGrid[1][1] = 1;
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    columnCheck = -1;
    //checkColouredSquares = 0;
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
        if (mouseSquareX == rowCheck && mouseSquareY == columnCheck && mousePressed == true){
          for(int i = 0; i < 10; i ++){
            columnColourCheck[i] = 0;
          }
          checkColouredSquares = 0;
          checkNotColouredSquares = 0;
          colourSquare();
        } 
      }
    }
    mouseSquareX = -100;
    mouseSquareY = -100;

    

  }

  public void mousePressed(){
    mouseSquareX = (int)(mouseX/25.5);
    mouseSquareY = (int)(mouseY/25.5);
    println("click " + mouseX + " " + mouseY + " " + mouseSquareX + " " + mouseSquareY);

//    println("Total of " + checkColouredSquares + " cells are selected.");
  }

  public void colourSquare(){
    try{
      if(intGrid[rowCheck][columnCheck] == 0){
        intGrid[rowCheck][columnCheck] = 1;

      } else if(intGrid[rowCheck][columnCheck] == 1){
        intGrid[rowCheck][columnCheck] = 0;
   

      }
    } catch(java.lang.ArrayIndexOutOfBoundsException error){

    }
    try{
      if(intGrid[rowCheck + 1][columnCheck] == 0){
        intGrid[rowCheck + 1][columnCheck] = 1;

      } else if(intGrid[rowCheck + 1][columnCheck] == 1){
        intGrid[rowCheck + 1][columnCheck] = 0;
    

      }
    } catch(java.lang.ArrayIndexOutOfBoundsException error){

    }
    try{
      if(intGrid[rowCheck - 1][columnCheck] == 0){
        intGrid[rowCheck - 1][columnCheck] = 1;

      } else if(intGrid[rowCheck - 1][columnCheck] == 1){
        intGrid[rowCheck - 1][columnCheck] = 0;
        

      }
    } catch(java.lang.ArrayIndexOutOfBoundsException error){

    }
    try{      
      if(intGrid[rowCheck][columnCheck + 1] == 0){
        intGrid[rowCheck][columnCheck + 1] = 1;

    } else if(intGrid[rowCheck][columnCheck + 1] == 1){
        intGrid[rowCheck][columnCheck + 1] = 0;
        
    }
    } catch(java.lang.ArrayIndexOutOfBoundsException error){

    }
    try{
      if(intGrid[rowCheck][columnCheck - 1] == 0){
        intGrid[rowCheck][columnCheck - 1] = 1;

      } else if(intGrid[rowCheck][columnCheck - 1] == 1){
        intGrid[rowCheck][columnCheck - 1] = 0;
        
      }
    } catch(java.lang.ArrayIndexOutOfBoundsException error){

    }

    println("-----------");
    for(int checkX = 0; checkX < 10; checkX ++){
      for(int checkY = 0; checkY < 10; checkY ++){
        if(intGrid[checkX][checkY] == 1){
          checkColouredSquares += 1;
          columnColourCheck[checkY] += 1;
        }
        if(intGrid[checkX][checkY] == 0){
          checkNotColouredSquares += 1;
        }
      }
      println("Row " + checkX + " has " + columnColourCheck[checkX] + " cells selected"); 

    }
    println("Total of " + checkColouredSquares + " cells are selected.");
    println("-----------");   
  }

}
