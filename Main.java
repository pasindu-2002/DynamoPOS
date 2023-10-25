import sellclothes.UserLogin;

public class Main {

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {
                    Thread.sleep(4500);
                }
                catch(Exception e) {}
                new UserLogin().setVisible(true);
            }
        });
    }
}