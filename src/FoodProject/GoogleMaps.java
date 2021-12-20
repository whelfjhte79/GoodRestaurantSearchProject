package FoodProject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.net.URLEncoder;

public class GoogleMaps {
	String imageUrl;
	String coordX = "";
	String coordY = "";
	String fileName = "image.jpg";
	public void setURL(String urlName) {
		try {
			imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="+ URLEncoder.encode(urlName, "UTF-8") +"&zoom=19&scale=1&size=344x300&maptype=roadmap&markers=color:red%7Clabel:E%7C" + URLEncoder.encode(urlName, "UTF-8") + "&key=KEY";
		}catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	public void setURL(double coordX, double coordY) {
		imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="+coordX+","+coordY+ "&zoom=19&scale=1&size=344x300&maptype=roadmap&markers=color:red%7Clabel:E%7C" + coordX + "," + coordY + "&key=KEY";
	}
	public void loadMap() {

		try {
			//imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="+ URLEncoder.encode(urlName, "UTF-8") +"&zoom=18&scale=1&size=344x300&maptype=roadmap&markers=color:red%7Clabel:E%7C" + URLEncoder.encode(urlName, "UTF-8") + "&key=KEY";
			//imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=37.6598492,126.6656916&zoom=18&scale=1&size=344x300&maptype=roadmap&markers=color:red%7Clabel:E%7C37.6598492,126.6656916&key=KEY";

			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(fileName);
			
			byte[] b = new byte[2048];
			int length;
			
			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}
			
			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
    }
    public ImageIcon getMap(int sizeX, int sizeY) {
    	return new ImageIcon((new ImageIcon(this.fileName)).getImage().getScaledInstance(sizeX, sizeY, java.awt.Image.SCALE_SMOOTH));
    }
    public ImageIcon getMap() {
    	return new ImageIcon((new ImageIcon(this.fileName)).getImage().getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH));
    }
    public String getFileName() {
    	return this.fileName;
    }
    public String getURL() {
    	return this.imageUrl;
    }
    public void deleteMap() {
    	File f = new File(this.imageUrl);
    	f.delete();
    }
}