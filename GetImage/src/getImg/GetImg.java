package getImg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class GetImg {
	
	private static void downloadImage(String imgSrc, String folderPath) throws IOException {
		String url = null;
		BufferedImage image = null;
		try {
			if (! (imgSrc.startsWith("http"))){
				System.err.println("Invalid image url%n");
				System.exit(-1);
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
//		String webUrl = "http://galleries.nubiles.net/samples/dasha_neal/cute-nubile/?coupon=1405013";
//		URL url = new URL(webUrl);
//		URLConnection connection = url.openConnection();
//		InputStream is = connection.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
//		HTMLEditorKit htmlKit = new HTMLEditorKit();
//		HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
//		HTMLEditorKit.Parser parser = new ParserDelegator();
		//		HTMLEditorKit.ParserCallback cb = htmlDoc.getReader(0);
		//		parser.parse(br, cb, true);	
		String folderPath = "E:/javaDownloadedImages/";
		for(int i = 0; i < 200; i ++){
			if( Files.notExists(Paths.get(folderPath + Integer.toString(i) + "/"))){
				folderPath = folderPath + Integer.toString(i) + "/";
				break;
			}
		}
		String imgSrc = "http://www.jewelrysupercenter.com/productimages/prodimg/large/107380.jpg";
		System.out.println(imgSrc);
		if (imgSrc != null && (imgSrc.endsWith(".jpg") || imgSrc.endsWith(".jpeg") || imgSrc.endsWith(".bmp"))){
			try{
				downloadImage(imgSrc, folderPath);
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		System.out.println("Image Finished");
	}
}
