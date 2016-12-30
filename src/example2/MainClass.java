package example2;
public class MainClass {
    public static void main(String[] args) {
        AbstractClasses.InternetAbstract absinternet = new AbstractClasses().new InternetAbstract() {
            @Override
            public void checkInternetStatus(boolean status) {
                if (status)
                    System.out.println("Yess!!! there is internet");
                else
                    System.out.println("No!!! no internet today");
            }
        };
        new WorkHorse(absinternet).thr1.start();
        new WorkHorse().thr2.start();
        new WorkHorse().thr3.start();
    }

}
