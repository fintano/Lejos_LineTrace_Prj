package delivery_robot;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Stopwatch;
import java.lang.System;

/**
 * Example leJOS EV3 Project with an ant build file
 *
 */
public class TouchSensor_Interface{
	  private static boolean collison_flag = false;
	  private static long lasttick = 0;
	  private static int collison_count = 0;
	  private static Stopwatch stopwatch = new Stopwatch();//leJOS API
	  private static EV3TouchSensor sensor = new EV3TouchSensor(SensorPort.S1);//leJOS API
	  private static float[] sample = new float[sensor.sampleSize()];
	  public static boolean isPressed(){
		  sensor.fetchSample(sample, 0);
		  if(java.lang.System.currentTimeMillis() - lasttick > 1000){
			  if(collison_count>0) collison_count--;
			  lasttick = java.lang.System.currentTimeMillis();
		  }
		  if(sample[0]==1){
			  if(collison_flag==false){
				  collison_count++;
				  stopwatch.reset();
			  }
			  collison_flag = true;
			  return true;
		  }else{
			  collison_flag = false;
			  return false;
		  }
	  }
	  public static int getCount(){
		  return collison_count;
	  }
	  public static int getTime(){
		  if(collison_flag)
			  return stopwatch.elapsed();//milli-second
		  else
			  return 9999;
	  }
	  public static void main(String[] args) {
		  float[] sample = new float[sensor.sampleSize()];
		  while(true){
			  sensor.fetchSample(sample, 0);
			  System.out.println(sample[0]);
		  }
	  }
}
