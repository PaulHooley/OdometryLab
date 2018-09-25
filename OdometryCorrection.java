/*
 * OdometryCorrection.java
 */
package ca.mcgill.ecse211.odometer;

public class OdometryCorrection implements Runnable {
  private static final long CORRECTION_PERIOD = 10;
  private Odometer odometer;
  private LightSensor lightsensor = new LightSensor(SensorPort.S1,true);

  /**
   * This is the default class constructor. An existing instance of the odometer is used. This is to
   * ensure thread safety.
   * 
   * @throws OdometerExceptions
   */
  public OdometryCorrection() throws OdometerExceptions {

    this.odometer = Odometer.getOdometer();

  }

  /**
   * Here is where the odometer correction code should be run.
   * 
   * @throws OdometerExceptions
   */
  // run method (required for Thread)
  public void run() {
    long correctionStart, correctionEnd;

    while (true) {
      this.colorsensor.setFloodlight(true);
      correctionStart = System.currentTimeMillis();
      int lineCounter = 0;
      int modCounter = linecounter%3;
      double[] position = Odometer.getOdometer().getXYT();
      
      // TODO Trigger correction (When do I have information to correct?)
      if(data[0] < 0.1){
    	  if(position[2] < 80){ // if theta is less than 90 should be at 0
    		  //set Theta = 0
    	  }else if(position[2] < 170){
    		  
    	  }else if(position[2] < 260){
    		  
    	  }else if(position[2] < 350)
    	  
      }
      // TODO Calculate new (accurate) robot position
    
      // TODO Update odometer with new calculated (and more accurate) vales

      odometer.setXYT(0.3, 19.23, 5.0);

      // this ensure the odometry correction occurs only once every period
      correctionEnd = System.currentTimeMillis();
      if (correctionEnd - correctionStart < CORRECTION_PERIOD) {
        try {
          Thread.sleep(CORRECTION_PERIOD - (correctionEnd - correctionStart));
        } catch (InterruptedException e) {
          // there is nothing to be done here
        }
      }
    }
  }
}
