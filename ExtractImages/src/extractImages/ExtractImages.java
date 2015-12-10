package extractImages;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.text.AttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class ExtractImages {

	private static void downloadImage(String url, String imgSrc, String folderPath) throws IOException {
		BufferedImage image = null;
		url = url.substring(0, url.lastIndexOf("/") + 1);
		try {
			if (! (imgSrc.startsWith("http"))){
				url = url + imgSrc;
			} else {
				url = imgSrc;
			}
			imgSrc = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
			String imageFormat = imgSrc.substring(imgSrc.lastIndexOf(".") + 1);
			String imgPath = folderPath + imgSrc + "";
			URL imgUrl = new URL(url);
			image = ImageIO.read(imgUrl);
			if (image != null) {
				File file = new File(imgPath);
				file.mkdirs();
				ImageIO.write(image, imageFormat, file);
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String webUrl = "http://ancensored.com/nude-appearance/Miscellaneous/Rila-Fukushima/";
		URL url = new URL(webUrl);
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		HTMLEditorKit htmlKit = new HTMLEditorKit();
		HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
		HTMLEditorKit.Parser parser = new ParserDelegator();
		HTMLEditorKit.ParserCallback cb = htmlDoc.getReader(0);
		parser.parse(br, cb, true);	
		String folderPath = "/Users/datrick/Downloads/javaDownloadedImages/";
		for(int i = 0; i < 200; i ++){
			if( Files.notExists(Paths.get(folderPath + Integer.toString(i) + "/"))){
				folderPath = folderPath + Integer.toString(i) + "/";
				break;
			}
		}
		for(HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.A); iterator.isValid(); iterator.next()){
			AttributeSet attributes = iterator.getAttributes();
			String imgSrc = (String) attributes.getAttribute(HTML.Attribute.HREF);
			System.out.println(imgSrc);
			if (imgSrc != null && (imgSrc.endsWith(".jpg") || imgSrc.endsWith(".jpeg") || imgSrc.endsWith(".bmp"))){
				try{
					downloadImage(webUrl, imgSrc, folderPath);
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
				System.out.println("Image Finished");
	}
}
