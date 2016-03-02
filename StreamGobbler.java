/**
 * 
 */
package pdf2htmlex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @author war3Gao
 *
 */
public class StreamGobbler extends Thread {

	private InputStream ins;
	
	private String type;
	
	private OutputStream outs;
	
	public void run() {
		InputStreamReader insReader = null;
		BufferedReader bfReader = null;
		PrintWriter pw = null;
		try {
			if (outs != null) {
				pw = new PrintWriter(outs);
				insReader = new InputStreamReader(ins);
				bfReader = new BufferedReader(insReader);
				String line=null;
				while ((line = bfReader.readLine()) != null) {
					if (pw != null) {
						pw.println(line);
						System.out.println(type + ">" + line);
					}
				}
				if (pw != null ) {
					pw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pw != null ) {
					pw.close();
				}
				if (bfReader != null) {
					bfReader.close();
				}
				if (insReader != null){
					insReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	/**
	 * @return the ins
	 */
	public InputStream getIns() {
		return ins;
	}

	/**
	 * @param ins the ins to set
	 */
	public void setIns(InputStream ins) {
		this.ins = ins;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the outs
	 */
	public OutputStream getOuts() {
		return outs;
	}

	/**
	 * @param outs the outs to set
	 */
	public void setOuts(OutputStream outs) {
		this.outs = outs;
	}
}
