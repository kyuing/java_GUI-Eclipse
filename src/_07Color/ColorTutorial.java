package _07Color;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.beans.ConstructorProperties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ColorTutorial {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("KT's frame");	//create an instance of JFrame
		Dimension dim = new Dimension(600, 400);	//create an instance of Dimension with the Dimension (frame size) constructor parameters
		frame.setLocation(980, 470); 	//set location of frame
		frame.setPreferredSize(dim);	//set the dimension(size) of frame at axis (700, 300)

		JLabel label = new JLabel();	//create an instance of JLabel using a default constructor in JLabel class
		label.setText("text with the setter setText()");	//set text using setter; we need setter since we are using the default constructor from JLabel class. 
		label.setVerticalAlignment(SwingConstants.TOP);	//SwingConstants.TOP is a parameter which has a TOP attribute. SwingConstants is an interface for alignment
		label.setHorizontalAlignment(SwingConstants.RIGHT);	//SwingConstants.RIGHT is a parameter which has a RIGHT attribute. SwingConstants is an interface for alignment
		
		Font font = new Font("Verdana", Font.ITALIC, 20);	//create an instance of Font with a specified constructor having three parameters
		label.setFont(font);	//set a font of label with the instance "font"		
		
		
		label.setOpaque(true);	//set setOpaque (background color) to be true. If true the component paints every pixel within its bounds.

		/* In Color class, there are some of specified constructors
		   The following specified constructors are what we are going to use
		  
		  	# color1
		    public Color(int rgb) {
           		value = 0xff000000 | rgb;
    		}
    		
    		# color2                                               
    		public Color(int r, int g, int b) {	  =========================> 		@ConstructorProperties({"red", "green", "blue", "alpha"})  
    		                                         calls the following            public Color(int r, int g, int b, int a) {	
        		this(r, g, b, 255);               =========================>        	value = ((a & 0xFF) << 24) |
    		}             					                                            		((r & 0xFF) << 16) |
    																							((g & 0xFF) << 8)  |
    																							((b & 0xFF) << 0);
    																					testColorValueRange(r,g,b,a);
			    																	}                                                           */
		/* hex R  G  B 
		   0X  00 00 FF 
		   
		   Creates an opaque sRGB color with the specified combined RGB value
		   consisting of the red component in bits 16-23, 
		   the green component in bits 8-15, 
		   and the blue component in bits 0-7.  
		   The actual color used in rendering depends on finding the best match given the color space available for a particular output device.  
		   Alpha is defaulted to 255. */
		Color color1 = new Color(0X0000FF);	//create an instance of Color with a specified constructor having a parameters
		 
		/* Creates an sRGB color with the specified red, green, blue, and alpha values in the range (0 - 255) each. */
		Color color2 = new Color(255,0,0);	//create an instance of Color with a specified constructor having three parameters
		
		label.setForeground(color1);	//set foreground color of label with color1; 0X0000FF. foreground is in front of or on a background. In this program, this is the text color we've set before. 
		label.setBackground(color2);	//set background color of label with color2; 255,0,0
		
		/* you can also set a text-based static default color into the instance label from Color class directly without having to creating an instance of Color
		label.setForeground(Color.BLUE);	  
		label.setBackground(Color.RED); 	*/
		
		frame.add(label);	//add label to frame
		frame.pack();	//modulate the window size of frame
		frame.setVisible(true);	//true == display.  false == not display
		
		//useful methods in Font class. there is no a default constructor and setter methods in Color class. So, we should use an appropriate specified constructor of Color class in instantiating.
		System.out.println("color1.getAlpha(): " + color1.getAlpha());	//get transparency
		System.out.println("color1.getRed(): " + color1.getRed());	//get red
		System.out.println("color1.getGreen(): " + color1.getGreen());	//get green
		System.out.println("color1.getBlue(): " + color1.getBlue());	//get blue
		System.out.println("color1.getRGB(): " + Integer.toHexString(color1.getRGB()));	//get ARGB in hexadecimal
				
		System.out.println("\ncolor2.getAlpha(): " + color2.getAlpha());	//get transparency
		System.out.println("color2.getRed(): " + color2.getRed());	//get red
		System.out.println("color2.getGreen(): " + color2.getGreen());	//get green
		System.out.println("color2.getBlue(): " + color2.getBlue());	//get blue
		System.out.println("color2.getRGB(): " + Integer.toHexString(color2.getRGB()));	//get ARGB in hexadecimal
        
	}
}
