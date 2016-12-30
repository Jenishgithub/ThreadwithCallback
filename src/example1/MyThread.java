package example1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyThread extends Thread {

    AbstractClasses.InternetAbstract internetAbs;

    public MyThread(AbstractClasses.InternetAbstract inernetAbs) {
        this.internetAbs = inernetAbs;
    }

    @Override
    public void run() {
        super.run();
        //do time consuming task here
        boolean success = false;
        try {
            URL url = new URL("https://google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(10000);
            connection.connect();
            success = connection.getResponseCode() == 200;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        internetAbs.checkInternet(success);


    }
}
