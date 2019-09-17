import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphic extends JPanel
{
	int screen_X, screen_Y;
	int button_pressed;
	int mouse_x, mouse_y;

	JFrame frame;
	JPanel panel;
	Button ResetButton;
	Button PauseButton;
	BufferedImage image;
	Graphics graphics;

	public Graphic(int Xi, int Yi, String title, String button_1s, String button_2s)
	{
		button_pressed=0;
		frame = new JFrame();
		screen_X=Xi;
		screen_Y=Yi;

		ResetButton= new java.awt.Button(button_1s);
		ResetButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				button_1();
				}
			}
		);
		ResetButton.setVisible(true);
		ResetButton.setLocation(0, 0);
		ResetButton.setSize(50, 30);
		frame.add(ResetButton);

		PauseButton= new java.awt.Button(button_2s);
		PauseButton.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				button_2();
				}
			}
		);
		PauseButton.setVisible(true);
		PauseButton.setLocation(50, 0);
		PauseButton.setSize(50, 30);
		frame.add(PauseButton);

		frame.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					System.exit(0);
				}
			}
		);
		frame.setTitle(title);
		frame.getContentPane().add(this);//new Main());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screen_X+6, screen_Y+34);
		frame.setVisible(true);

		frame.addMouseListener(
			new MouseAdapter()
			{
			@Override
				public void mouseClicked(MouseEvent e)
				{
					System.out.println(e.getX() + "," + e.getY());
					mouse_x=e.getX();
					mouse_y=e.getY();
					button_pressed = 255;
				}
			}
		);
	}

	public void paint(Graphics g)
	{
		g.drawImage(image,0,0,this);// draw it
	}

	void button_1()
	{
		button_pressed=1;
		this.repaint();
	}

	void button_2()
	{
		button_pressed=2;
		this.repaint();
	}

	int getMouseX()
	{
		mouse_x-=4;
		if (mouse_x<0)mouse_x=0;
		else if (mouse_x>=screen_X)mouse_x=screen_X-1;
System.out.println("mouse_x "+mouse_x);
		return mouse_x;
	}
	int getMouseY()
	{
		mouse_y-=31;
		if (mouse_y<0)mouse_y=0;
		else if (mouse_y>=screen_Y)mouse_y=screen_Y-1;
System.out.println("mouse_y "+mouse_y);
		return mouse_y;
	}

	public int getButton()
	{
		int a = button_pressed;
		button_pressed=0;
		return a;
	}

	void setScreen(int img[], int img_x, int img_y)// throws Exception
	{
		int screen[] = new int[screen_X* screen_Y];
		int color, tmp_x, tmp_y;
		float r;

		for(int y = 0; y < screen_Y; y++)
		{
			for(int x = 0; x < screen_X; x++)
			{
				r=(float)x/(float)screen_X;
				tmp_x = (int)(r*img_x);

				r=(float)y/(float)screen_Y;
				tmp_y=(int)(r*img_y);

				screen[x+y*screen_X]=img[tmp_x+tmp_y*img_x];
			}
		}

		image = new BufferedImage(screen_X,screen_Y,1);
		image.setRGB(0,0,screen_X,screen_Y,screen,0,screen_X);
		this.repaint();
	}

	void setScreenFromBitmap(boolean img[][], int img_x, int img_y)// throws Exception
	{
		int screen[] = new int[screen_X* screen_Y];
		int color, tmp_x, tmp_y;
		float r;

		for(int y = 0; y < screen_Y; y++)
		{
			for(int x = 0; x < screen_X; x++)
			{
				r=(float)x/(float)screen_X;
				tmp_x = (int)(r*img_x);

				r=(float)y/(float)screen_Y;
				tmp_y=(int)(r*img_y);

				if (img[tmp_x][tmp_y])
				{
					color=0xffffff;
				}
				else
				{
					color=0;
				}

				screen[x+y*screen_X]=color;
			}
		}

		image = new BufferedImage(screen_X,screen_Y,1);
		image.setRGB(0,0,screen_X,screen_Y,screen,0,screen_X);
		this.repaint();
	}
}
