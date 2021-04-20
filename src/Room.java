import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;

public class Room extends JPanel implements ComponentListener, MouseListener
{
    private int frameWidth, frameHeight;

    private BufferedImage background;
    private String backgroundPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "rm.jpg";

    private BufferedImage box;
    private String boxPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "box.png";


    public Room() throws Exception
    {
        addComponentListener(this);
        setDoubleBuffered(true);
        this.frameWidth = getWidth();
        this.frameHeight = getHeight();
        File backgroundFile = new File(backgroundPath);
        background = ImageIO.read(backgroundFile);

        File  boxFile = new File(boxPath);
        box = ImageIO.read(boxFile);

        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(box, getWidth()/3, getHeight()-150, 100, 100, this);
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
        System.out.println(MouseInfo.getPointerInfo().getLocation());
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
