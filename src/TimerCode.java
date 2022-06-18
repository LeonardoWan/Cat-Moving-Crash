import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Timer;

public class TimerCode {
    Timer timer = new Timer();
    int z = 0;
    public TimerCode(int time){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    if (z == 0){
                        Process process = Runtime.getRuntime().exec("Shutdown -s -t " + String.valueOf(time));
                        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        z = 1;
                    }
                    JOptionPane.showMessageDialog(null, "Ur pc will shutdown in " + time + " seconds!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        timer.schedule(task, 3000);
    }
}
