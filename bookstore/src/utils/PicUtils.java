package utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class PicUtils {
	private String srcFile;
	private String destFile;
	private int width;
	private int height;
	private Image img;

	/**
	 * 鏋勯�犲嚱鏁�
	 * 
	 * 
	 * @param fileName
	 *            String
	 * @throws IOException
	 */
	public PicUtils(String fileName) throws IOException {  //  a.jpg   a_s.jpg
		File _file = new File(fileName); // 璇诲叆鏂囦欢
		this.srcFile = fileName;
		// 鏌ユ壘鏈�鍚庝竴涓�.
		int index = this.srcFile.lastIndexOf(".");
		String ext = this.srcFile.substring(index);
		this.destFile = this.srcFile.substring(0, index) + "_s" + ext;
		img = javax.imageio.ImageIO.read(_file); // 鏋勯�營mage瀵硅薄
		width = img.getWidth(null); // 寰楀埌婧愬浘瀹�
		height = img.getHeight(null); // 寰楀埌婧愬浘闀�
	}

	/**
	 * 寮哄埗鍘嬬缉/鏀惧ぇ鍥剧墖鍒板浐瀹氱殑澶у皬
	 * 
	 * @param w
	 *            int 鏂板搴�
	 * @param h
	 *            int 鏂伴珮搴�
	 * @throws IOException
	 */
	public void resize(int w, int h) throws IOException {
		BufferedImage _image = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);
		_image.getGraphics().drawImage(img, 0, 0, w, h, null); // 缁樺埗缂╁皬鍚庣殑鍥�
		FileOutputStream out = new FileOutputStream(destFile); // 杈撳嚭鍒版枃浠舵祦
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(_image); // 杩慗PEG缂栫爜
		out.close();
	}

	/**
	 * 鎸夌収鍥哄畾鐨勬瘮渚嬬缉鏀惧浘鐗�
	 * 
	 * @param t
	 *            double 姣斾緥
	 * @throws IOException
	 */
	public void resize(double t) throws IOException {
		int w = (int) (width * t);
		int h = (int) (height * t);
		resize(w, h);
	}

	/**
	 * 浠ュ搴︿负鍩哄噯锛岀瓑姣斾緥鏀剧缉鍥剧墖
	 * 
	 * @param w
	 *            int 鏂板搴�
	 * @throws IOException
	 */
	public void resizeByWidth(int w) throws IOException {
		int h = (int) (height * w / width);
		resize(w, h);
	}

	/**
	 * 浠ラ珮搴︿负鍩哄噯锛岀瓑姣斾緥缂╂斁鍥剧墖
	 * 
	 * @param h
	 *            int 鏂伴珮搴�
	 * @throws IOException
	 */
	public void resizeByHeight(int h) throws IOException {
		int w = (int) (width * h / height);
		resize(w, h);
	}

	/**
	 * 鎸夌収鏈�澶ч珮搴﹂檺鍒讹紝鐢熸垚鏈�澶х殑绛夋瘮渚嬬缉鐣ュ浘
	 * 
	 * @param w
	 *            int 鏈�澶у搴�
	 * @param h
	 *            int 鏈�澶ч珮搴�
	 * @throws IOException
	 */
	public void resizeFix(int w, int h) throws IOException {
		if (width / height > w / h) {
			resizeByWidth(w);
		} else {
			resizeByHeight(h);
		}
	}

	/**
	 * 璁剧疆鐩爣鏂囦欢鍚� setDestFile
	 * 
	 * @param fileName
	 *            String 鏂囦欢鍚嶅瓧绗︿覆
	 */
	public void setDestFile(String fileName) throws Exception {
		if (!fileName.endsWith(".jpg")) {
			throw new Exception("Dest File Must end with \".jpg\".");
		}
		destFile = fileName;
	}

	/**
	 * 鑾峰彇鐩爣鏂囦欢鍚� getDestFile
	 */
	public String getDestFile() {
		return destFile;
	}

	/**
	 * 鑾峰彇鍥剧墖鍘熷瀹藉害 getSrcWidth
	 */
	public int getSrcWidth() {
		return width;
	}

	/**
	 * 鑾峰彇鍥剧墖鍘熷楂樺害 getSrcHeight
	 */
	public int getSrcHeight() {
		return height;
	}
}
