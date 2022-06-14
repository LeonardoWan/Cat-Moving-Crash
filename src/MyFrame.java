
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
/*
This is the code for the main frame that is basically just a black screen with a message that says click me.
If u click the button it will spawn some new frames of the cat going around the screen with that song.
Amogus.
 */


public class MyFrame extends JFrame implements ActionListener, WindowListener {
    JButton button, button2;
    JPanel panel, panel2;
    JLabel label;
    JLabel labelimage;
    URL battlepass = getClass().getResource("battle pass.wav");
    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("cat.png"));
    int cont;

    public static void PlaySound(URL battlepass){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(battlepass));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public MyFrame(){
        this.setSize(500,500);
        this.setTitle("Totally not a program that will crash ur pc!");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        this.setLocationRelativeTo(null);
        button = new JButton("Click me :)");
        button.addActionListener(this);
        button.setSize(100,50);
        button.setFocusable(false);
        button2 = new JButton("Click for safe version!");
        button2.setSize(200,50);
        button2.setFocusable(false);
        button2.addActionListener(this);
        panel = new JPanel();
        panel.add(button);
        panel.setBackground(Color.BLACK);
        panel.setBounds(190,50,100,50);
        panel2 = new JPanel();
        panel2.add(button2);
        panel2.setBackground(Color.black);
        panel2.setBounds(140,350,200,50);
        label = new JLabel();
        label.setSize(500,500);
        //label.setForeground(Color.black);
        label.setVisible(true);

        this.add(label);
        this.add(panel);
        this.add(panel2);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            PlaySound(battlepass);
            int i = 10;
            for(int j = 0 ; j <= 10 ; j++){
                new Cat();
            }

            //JOptionPane.showMessageDialog(null, "Something's bout to happen");
            //while(i != 0){
              //  if(i % 10 == 1){
                   // i = (3*i) + 1;
                   // System.out.println(i);
              //  }else{
                    //i = (3/2);
                    //System.out.println(i);
               // }
            }else if(e.getSource() == button2){
            PlaySound(battlepass);
            new CatSafe();
        }
        }

    //}


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane.showMessageDialog(null,":)"); //just some trollish message so it dont close, but it closes anyway.
        cont++;
        if(cont == 5){
            JOptionPane.showMessageDialog(null, "Ok, closing now!");
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
}
