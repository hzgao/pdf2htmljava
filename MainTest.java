/**
 * 
 */
package pdf2htmlex;

import java.io.File;
import java.io.IOException;


/**
 * @author war3Gao
 *
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String exePath = "d:\\pdf2htmlEX-win32-0.14.6\\pdf2htmlEX.exe"; 
		String destDir = "E:\\POD_PDF_PATH\\(16开本1本)2016私享影评_53446_蓝雨星城_16开本_胶订_软装_特种纸";
		String pdfName = "(16开本1本)2016私享影评_53446_蓝雨星城_16开本_胶订_软装_特种纸";
		String pdf =  ".pdf";
		String html = ".html";
		
		StringBuffer sb = new StringBuffer();
		//pdf2htmlEX.exe  存放路径
		sb.append(exePath).append(" ")
		//文件保存的根目录
		.append("--dest-dir").append(" ").append(destDir)
		.append(" ")
		//尽量减少用于文本的HTML元素的数目 (default: 0)
		.append("--optimize-text 1").append(" ")
		//缩放比例 这个6666
		.append("--zoom 1").append(" ")
		//html中显示链接：0——false，1——true
		.append("--process-outline 0").append(" ")
		//嵌入字体后戳(default ttf) ttf,otf,woff,svg 
		.append("--font-format woff").append(" ")
		//pdf名称
		.append(destDir).append(File.separator).append(pdfName)
		.append(pdf).append(" ")
		//html 名称
		.append(pdfName).append(html);
		System.out.println("command  ====  " + sb.toString());
		//运行时
		Runtime rt = Runtime.getRuntime();
		//进程
		try {
			Process proc = rt.exec(sb.toString());
//			//开启屏幕标准输出流   error 级 
//			StreamGobbler out = new StreamGobbler();
//			out.setIns(proc.getErrorStream());
//			out.setType("STDOUT");
//			out.setOuts(proc.getOutputStream());
//			out.start();
			StreamGobbler out = new StreamGobbler();
			//开启屏幕标准错误流 
			out.setIns(proc.getErrorStream());
			out.setType("STDOUT");
			out.setOuts(proc.getOutputStream());
			out.start();

			int w = proc.waitFor();
			int v = proc.exitValue();
			 if(w==0&&v==0){  
	               // return true;  
				 System.out.println("ok");
	            }  
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
