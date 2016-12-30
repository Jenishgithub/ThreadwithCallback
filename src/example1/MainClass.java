package example1;

public class MainClass {
    public static void main(String[] args) {

        AbstractClasses.InternetAbstract internetabs = new AbstractClasses().new InternetAbstract() {
            @Override
            public void checkInternet(boolean status) {
                if (status) {
                    System.out.println("Yes!!! there is intenet acccess");
                } else {
                    System.out.println("Sorry!!! no internet access");
                }
            }
        };
        new MyThread(internetabs).start();
    }
}
