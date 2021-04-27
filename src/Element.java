import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Element extends JLabel implements MouseListener
{
    Icon normal;
    Icon clicked;

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    public Element(String imgName, String clickedImgName, int xPos, int yPos, int width, int height)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

        this.setBounds(xPos, yPos, width, height);

        String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + imgName;
        String clickedImgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + clickedImgName;
        try
        {
            File imgFile = new File(imgPath);
            BufferedImage img = ImageIO.read(imgFile);

            File clickedFile = new File(clickedImgPath);
            BufferedImage clickedImg = ImageIO.read(clickedFile);

            normal = new ImageIcon(img.getScaledInstance(width,height, Image.SCALE_DEFAULT));
            clicked = new ImageIcon(clickedImg.getScaledInstance(width*2,height*2, Image.SCALE_DEFAULT));
            this.setIcon(normal);
        }
        catch(IOException e)
        {
            System.err.println("Problem loading image: " + imgPath);
        }

        this.addMouseListener(this);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }

    private void swapIcons()
    {
        if(getIcon() == normal)
        {
           this.setBounds(xPos, yPos, width*2, height*2);
           setIcon(clicked);
        }
        else
        {
            this.setBounds(xPos, yPos, width, height);
            setIcon(normal);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {
        swapIcons();
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
