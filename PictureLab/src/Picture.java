import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  /** sets red and green to 0 */
  public void keepOnlyBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        Color onlyBlue = new Color(0, 0, pixelObj.getBlue());
        pixelObj.setColor(onlyBlue);
      }
    }
  }

  /** negates each pixel by subtracting 255 by each RGB value */
  public void negate() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        int red = 255 - pixelObj.getRed();
        int green = 255 - pixelObj.getGreen();
        int blue = 255 - pixelObj.getBlue();
        Color negates = new Color(red, green, blue);
        pixelObj.setColor(negates);
      }
    }
  }

  /** Method that turns a picture into a gray version of itself */
  public void grayscale() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        int averageColor = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
        Color gray = new Color(averageColor, averageColor, averageColor);
        pixelObj.setColor(gray);
      }
    }
  }

  /** Method to increase visibility of fish in water.jpg */
  public void fixUnderwater() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        if (pixelObj.getBlue() > pixelObj.getGreen() && pixelObj.getBlue() > pixelObj.getRed()) {
          // gets rid of the bright blue
          pixelObj.setBlue(pixelObj.getGreen()-5);
          pixelObj.setRed(20);
        }
      }
    }
  }

  /** Method to mirror a picture right to left */
  public void mirrorVerticalRightToLeft() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }

  /** Method to mirror a picture horizontally */
  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel bottomPixel = null;
    Pixel topPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        bottomPixel = pixels[height - 1 - row][col];
        topPixel = pixels[row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }

  /** Methord to mirror a picture horizontally bottom to top */
  public void mirrorHorizontalBotToTop() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel bottomPixel = null;
    Pixel topPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        bottomPixel = pixels[height - 1 - row][col];
        topPixel = pixels[row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  /** Method to mirror a picture diagonally */
  public void mirrorDiagonal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int height = pixels.length;
    int width = pixels[0].length;
    int square = height > width ? width : height;
    for (int row = 0; row < square; row++)
    {
      for (int col = 0; col < square; col++)
      {
          leftPixel = pixels[col][row];
          rightPixel = pixels[row][col];
          rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  /** Mirror arms on the snowman */
  public void mirrorArm() {
    int mirrorPoint = 204;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel lowerLeftPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 157; row < 190; row++)
    {
      // loop from 100 to just before the mirror point
      for (int col = 100; col < 170; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row+30]                       
                         [mirrorPoint - col + mirrorPoint];
        lowerLeftPixel = pixels[row+30][col];
        rightPixel.setColor(leftPixel.getColor());
        lowerLeftPixel.setColor(leftPixel.getColor());
      }
    }
  }

  /** Mirror the seagull to make a new best friend. 
   * It's 10 PM and I'm tired. The seagull gets a new best friend because of it
   */
  public void mirrorGull() {
    int mirrorPoint = 361;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 229; row < 320; row++)
    {
      // loop from 100 to just before the mirror point
      for (int col = 235; col < 346; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("C:\\Users\\kaiho\\.VirtualBox\\PictureLab\\PictureLab\\PictureLab\\src\\images\\seagull.jpg");
    // beach.explore();
    // beach.zeroBlue();s
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this