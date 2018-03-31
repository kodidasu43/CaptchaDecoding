package captchadecoding;
import net.sourceforge.tess4j.*;
import java.io.File;

public class OcrDemo {

	public static void main(String[] args) throws TesseractException {
		
		File imageFile = new File ("H:\\Tess4J\\captcha.jpg");
		
		 Tesseract instance = new Tesseract();
	        instance.setDatapath("H:\\Tess4J");
	        instance.setLanguage("eng");
	 
	        // the doOCR method of Tesseract will retrive the text
	        
	        String result = instance.doOCR(imageFile);
	        
	        System.out.println(result);

	}

}
