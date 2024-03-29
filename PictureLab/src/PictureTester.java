/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  // Gotta keep adding this on... variables!
  private static String addOn = "C:\\Users\\kaiho\\.VirtualBox\\PictureLab\\PictureLab\\PictureLab\\src\\images\\";
  // private static String addOn = "H:\\PictureLab\\src\\images\\";
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture(addOn + "beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  /** Method to test keepOnlyBlue   */
  public static void testKeepOnlyBlue() {
    Picture beach = new Picture(addOn + "beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  /** Method to test negate */
  public static void testNegate() {
    Picture beach = new Picture(addOn + "beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }

  /** Method to test grayscale */
  public static void testGrayscale() {
    Picture beach = new Picture(addOn + "beach.jpg");
    beach.explore();
    beach.grayscale();
    beach.explore();
  }

  /** Method to test fixUnderwater */
  public static void testFixUnderwater() {
    Picture water = new Picture(addOn + "water.jpg");
    water.explore();
    water.fixUnderwater();
    water.explore();
  }

  /** Method to test mirrorVerticalLeftToRight */
  public static void testMirrorVerticalRightToLeft() {
    Picture temple = new Picture(addOn + "temple.jpg");
    temple.explore();
    temple.mirrorVerticalRightToLeft();
    temple.explore();
  }

  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal() {
    Picture motor = new Picture(addOn + "redMotorcycle.jpg");
    motor.explore();
    motor.mirrorHorizontal();
    motor.explore();
  }

    /** Method to test mirrorHorizontal */
    public static void testMirrorHorizontalBotToTop() {
      Picture motor = new Picture(addOn + "redMotorcycle.jpg");
      motor.explore();
      motor.mirrorHorizontalBotToTop();
      motor.explore();
    }
    
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture(addOn + "caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  /** Method to test mirrorDiagonal */
  public static void testMirrorDiagonal() {
    Picture beach = new Picture(addOn + "beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture(addOn + "temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  /** Method to test mirrorArms */
  public static void testMirrorArms() {
    Picture snowman = new Picture(addOn + "snowman.jpg");
    snowman.explore();
    snowman.mirrorArm();
    snowman.explore();
  }

  /** Method to test mirrorGull */
  public static void testMirrorGull() {
    Picture seagull = new Picture(addOn + "seagull.jpg");
    seagull.explore();
    seagull.mirrorGull();
    seagull.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture(addOn + "640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

  /** Method to test myCollage method */
  public static void testMyCollage() {
    Picture canvas = new Picture(addOn + "640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture(addOn + "swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    // testZeroBlue();
    // testKeepOnlyBlue();
    // testKeepOnlyRed();
    //testKeepOnlyGreen();
    // testNegate();
    // testGrayscale();
    // testFixUnderwater();
    //testMirrorVertical();
    // testMirrorTemple();
    // testMirrorArms();
    // testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    // testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
    // testMirrorVerticalRightToLeft();
    // testMirrorHorizontalBotToTop();
    // testMirrorDiagonal();
    testMyCollage();
  }
}