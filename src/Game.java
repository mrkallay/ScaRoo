import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game implements KeyListener
{
    private static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private boolean INGAME;
    private static JFrame mainFrame;
    private JPanel topPanel;
    private JButton pauseButton;
    private JButton startGame;
    private Thread gameThread;
    private boolean gameOn;

    private Room room;


    public static void main(String[] args) throws Exception {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Game game = new Game();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                mainFrame.setVisible(true);
            }
        });

    }

    private Game() throws Exception {
        startGame();
    }


    private void startGame() throws Exception
    {

        mainFrame = new JFrame("EscaRoo");
        mainFrame.setMinimumSize(new Dimension(SCREEN_WIDTH / 4, SCREEN_HEIGHT / 4));
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                gameOn = false;
            }
        });
        mainFrame.setAlwaysOnTop(false);
        mainFrame.addKeyListener(this);
        mainFrame.setContentPane(createContentPane());

        gameOn = true;
        startGameLoop();
    }

    private JPanel createContentPane() throws Exception {
        topPanel = new JPanel();    // topmost JPanel in layout hierarchy
        topPanel.setBackground(Color.BLACK);
        topPanel.addKeyListener(this);

        LayoutManager overlay = new OverlayLayout(topPanel);
        topPanel.setLayout(overlay);

        room = new Room();
        topPanel.add(room);
        return topPanel;
    }

    private void startGameLoop() {
        // initialise the thread
        gameThread = new Thread(() -> {

            while (gameOn) {


                this.room.repaint();

                // here we throttle our game loop, because we are using a while loop this will execute as fast as it possible can, which might not be needed
                // so here we call Thread#slepp so we can give the CPU some time to breathe :)
                try {
                    Thread.sleep(15);
                } catch (InterruptedException ex) {
                }
            }
        });

        gameThread.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
