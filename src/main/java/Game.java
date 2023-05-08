import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable {

    public static int Width=300;
    public static int Height=Width/16*9;
    public static int scale=3;

    private Thread thread;
    private boolean running=false;
    private JFrame frame;

    public Game(){
        Dimension size= new Dimension(Width*scale,Height*scale);
        setPreferredSize(size);
        frame=new JFrame();
    }

    public synchronized void start(){
        running=true;
        thread=new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        running=false;
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running){
            System.out.println("Hello this is a window Running....");
        }
    }

    public static void main(String args[]){
        Game game= new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Rain");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }
}
