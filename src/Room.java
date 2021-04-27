import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Room extends JPanel implements ComponentListener, MouseListener
{
    private int frameWidth, frameHeight;

    private BufferedImage background;
    private String backgroundPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "rm.jpg";

    private Element box;
    private ArrayList<Element> boxes;

    public Room() throws Exception
    {
        addComponentListener(this);
        setDoubleBuffered(true);

        //TODO: fixme! this doesn't work because the panel has no height/width until added to a container
        this.frameWidth = getWidth();
        this.frameHeight = getHeight();

        File backgroundFile = new File(backgroundPath);
        background = ImageIO.read(backgroundFile);

        box = new Element("box.png", "box_open.png", 637, 850, 100, 100);
        this.add(box);

        //boxes = new ArrayList<>();
        //int x = 10;
        //int y = 850;
        //for(int i=0;i<20;i++)
        //{
          //  Element ox = new Element("box.png", "box_open.png", x, y, 100, 100);
          //  this.add(ox);
          //boxes.add(ox);
          //  x+=101;
        //}

        this.setLayout(null);
        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
       // g.drawImage(box.getImg(), box.getxPos(), box.getyPos(), box.getWidth(), box.getHeight(), this);
    }


    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}


    @Override
    public void mouseClicked(MouseEvent e)
    {
        PointerInfo pi = MouseInfo.getPointerInfo();
        Point point = new Point(pi.getLocation());
        SwingUtilities.convertPointFromScreen(point, e.getComponent());
        int x=(int) point.getX();
        int y=(int) point.getY();
        System.out.println("Location: x=" + x + " y=" + y);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
