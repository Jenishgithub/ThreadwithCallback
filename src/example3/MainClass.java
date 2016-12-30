package example3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainClass {

    public static void main(String[] args) {
        Runnable work1 = new Runnable() {
            @Override
            public void run() {
                //check internet status
                //do time consuming task here
                boolean success = false;
                try {
                    //System.out.print(parameters);//this will be null
                    URL url = new URL("https://google.com");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(10000);
                    connection.connect();
                    success = connection.getResponseCode() == 200;
                    System.out.println("the status of internet is : " + success);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        Runnable work2 = new Runnable() {
            @Override
            public void run() {
                //check wifi status or something
                for (int i = 0; i < 5; i++) {
                    System.out.print(i * 5);
                    System.out.print(", ");
                }
            }
        };
        Thread thr1 = new Thread(work1);
        Thread thr2 = new Thread(work2);
        thr1.start();
        thr2.start();

    }


}
