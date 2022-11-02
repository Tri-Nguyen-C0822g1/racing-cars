package RacingCars;

import java.util.Random;

public class Cars implements Runnable{

    private  String name;

    public Cars(String name){
        this.name = name;
    }

    @Override
    public void run(){
        // Khoi tao km ban dau;
         int runDistance = 0;
         // Khoi tao thoi gian bat dau cuoc dua;
        long starTime = System.currentTimeMillis();

        // Kiểm tra chừng nào vẫn còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp tục chạy;
         while(runDistance < Main.DISTANCE){
             try{
                 // Random speed (km/h);
                 int speed = (new Random()).nextInt(20);
                 // Calculate traveled distance;
                 runDistance += speed;
                 // Build result graphic;
                 String log = "|";
                 int percentTravel = (runDistance * 100)/ Main.DISTANCE;
                 for(int i = 0; i < Main.DISTANCE; i += Main.STEP){
                     if(percentTravel >= i + Main.STEP) {
                         log += "=";
                     } else if (percentTravel >= i && percentTravel < i + Main.STEP) {
                         log += "o";
                     } else {
                         log += "-";
                 }

                 }
                 log += "|";
                 System.out.println("Car :" + this.name + " " + log + " " + Math.min(Main.DISTANCE, runDistance) + "KM");
                 Thread.sleep(1000);

             } catch (InterruptedException e){
                 System.out.println("Car " + this.name + "broken....");
             break;
             }
            long endTime = System.currentTimeMillis();
             System.out.println("Car " + this.name + "finish in " + (endTime - starTime)/1000 + "s");
         }
    }
}
