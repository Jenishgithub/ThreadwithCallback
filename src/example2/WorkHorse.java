package example2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class WorkHorse {

    String parameters;
    AbstractClasses.InternetAbstract absinternet;


    public WorkHorse(AbstractClasses.InternetAbstract absinternet) {
        this.absinternet = absinternet;
    }

    public WorkHorse() {
    }

    Runnable work1 = new Runnable() {
        @Override
        public void run() {
            //check intenet status
            //do time consuming task here
            boolean success = false;
            try {
                //System.out.print(parameters);//this will be null
                URL url = new URL("https://google.com");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(10000);
                connection.connect();
                success = connection.getResponseCode() == 200;
                absinternet.checkInternetStatus(success);//callback
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

    Runnable work3 = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                System.out.println("My name is:");
            }
        }
    };

    //have as many independent runnables here

    Thread thr1 = new Thread(work1);
    Thread thr2 = new Thread(work2);
    Thread thr3 = new Thread(work3);

}
