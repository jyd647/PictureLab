
import java.awt.Color;

public class Logic {
	
	/**
	 * Alters the picture so that each pixel's blue channel has been zeroed out.
	 * All other channels remain the same 
	 * @param picture the image to be altered
	 */
	public static void zeroBlue(DigitalPicture picture) {
		
		// obtain the 2d Array rep of the picture
		Pixel[][] pixel2D = picture.getPixels2D();
		
		//traverse the pixels and alter their values per filter spec
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				pixel2D[r][c].setBlue(0);				
			}
		}
		
	}

	public static void blackAndWhite(DigitalPicture picture) {
		//1. obtain 2d rep of the pixels that we can traverse
		Pixel[][] pixel2D = picture.getPixels2D();
		// find average of rgb values and set each rgb to that value
		
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				int avg = (int)pixel2D[r][c].getAverage();
				pixel2D[r][c].setRed(avg);
				pixel2D[r][c].setGreen(avg);
				pixel2D[r][c].setBlue(avg);
			}
		}
		
	}
	public static void negative(DigitalPicture picture) {
		//1. obtain 2d rep of the pixels that we can traverse
		Pixel[][] pixel2D = picture.getPixels2D();
		
		
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				
				pixel2D[r][c].setRed(255-(pixel2D[r][c].getRed()));
				pixel2D[r][c].setGreen(255-(pixel2D[r][c].getGreen()));
				pixel2D[r][c].setBlue(255-(pixel2D[r][c].getBlue()));
			}
		}
		
	}
	public static void mirrorVertical(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();

		for (int r = 0; r < pixel2D.length/2; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				// recording original values
				int red = pixel2D[r][c].getRed();
				int green = pixel2D[r][c].getGreen();
				int blue = pixel2D[r][c].getBlue();
				// set sides to the opposite values
				pixel2D[r][c].setRed(pixel2D[pixel2D.length - 1 - r][c].getRed());
				pixel2D[pixel2D.length - 1 - r][c].setRed(red);
				pixel2D[r][c].setGreen(pixel2D[pixel2D.length - 1 - r][c].getGreen());
				pixel2D[pixel2D.length - 1 - r][c].setGreen(green);
				pixel2D[r][c].setBlue(pixel2D[pixel2D.length - 1 - r][c].getBlue());
				pixel2D[pixel2D.length - 1 - r][c].setBlue(blue);
			}
		}
	}
	public static void mirrorHorizontal(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();
		

		for (int c = 0; c < pixel2D[0].length/2; c++) {
			for (int r = 0; r < pixel2D.length; r++) {
				//recording initial values
				// set sides to the opposite values
				int red = pixel2D[r][c].getRed();
				int green = pixel2D[r][c].getGreen();
				int blue = pixel2D[r][c].getBlue();
				pixel2D[r][c].setRed(pixel2D[r][pixel2D[r].length - 1 - c].getRed());
				pixel2D[r][pixel2D[r].length - 1 - c].setRed(red);
				pixel2D[r][c].setGreen(pixel2D[r][pixel2D[r].length - 1 - c].getGreen());
				pixel2D[r][pixel2D[r].length - 1 - c].setGreen(green);
				pixel2D[r][c].setBlue(pixel2D[r][pixel2D[r].length - 1 - c].getBlue());
				pixel2D[r][pixel2D[r].length - 1 - c].setBlue(blue);
			}
		
		}
	}
		public static void makeSunset(DigitalPicture picture, double re, double gbl ) {
			Pixel[][] pixel2D = picture.getPixels2D();
			
			for (int r = 0; r < pixel2D.length; r++) {
				for (int c = 0; c < pixel2D[r].length; c++) {
					int red = (int)(re*pixel2D[r][c].getRed());
					int gr = (int)(gbl*pixel2D[r][c].getGreen());
					int bl = (int)(gbl*pixel2D[r][c].getBlue());
					pixel2D[r][c].setRed(red);
					pixel2D[r][c].setGreen(gr);
					pixel2D[r][c].setBlue(bl);				
				}
			
			}		
		}
		public static void blur(DigitalPicture picture) {
			Pixel[][] pixel2D = picture.getPixels2D();
			int sumR = 0;
			int sumG = 0;
			int sumB = 0;
			for (int r = 1; r < pixel2D.length; r++) {
				for (int c = 1; c < pixel2D[r].length; c++) {
					for (int x = r; x >= r - 1; x--) {
						for (int y = c; y >= c-1 ; y--) {
							sumR += pixel2D[x][y].getRed();
							sumG += pixel2D[x][y].getGreen();
							sumB += pixel2D[x][y].getBlue();
						
						}
						
					}
					sumR /= 4;
					sumG /= 4;
					sumB /= 4;
					pixel2D[r][c].setRed(sumR);
					pixel2D[r][c].setGreen(sumG);
					pixel2D[r][c].setBlue(sumB);
					sumR = 0;
					sumG = 0;
					sumB = 0;
				
				}
				
			}
//	/**
//	 * Alters the picture so that is is black and white by setting each pixels color value to be the average
//	 * of the pixels red, green, and blue channel. 
//	 * @param picture,  the image to be altered
//	 */
//	public static void ????(??? ???) {
//		
//		
//		
//	}

	
	}

}
