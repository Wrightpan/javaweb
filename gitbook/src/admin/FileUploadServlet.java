package admin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//处理上传数据
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<String> types = Arrays.asList(".jpg", ".gif", ".avi", ".txt");
		List<String> types = Arrays.asList("jpg", "gif", "avi", "txt");
		String savepath;
		try {
			//创建解析工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();//内存缓冲区的大小，默认值为10K
			factory.setSizeThreshold(1024 * 1024);//设置内存缓冲区的大小为1M
			factory.setRepository(new File(this.getServletContext().getRealPath("/img/temp")));
			
			//创建解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//限制上传文件的大小
			upload.setFileSizeMax(1024 * 1024 * 5);//只要超出5M，for循环在解析的时候就会抛异常
			
			//提交的表单类型不是multipart/form-data，则没必要用解析器进行解析数据，按照传统方式获取表单数据即可
			if (!upload.isMultipartContent(request)) {
				//按照传统方式获取表单数据
				request.getParameter("username");
				//balabala......
				return;
			}
			
			//解决上传文件的中文名称的中文乱码问题，设置解析器的编码，到底设什么编码，也不能瞎写，一定要看表单的数据是以什么编码提交的！
            upload.setHeaderEncoding("UTF-8");
			
			//调用解析器解析request，得到保存了所有上传数据的List集合
			List<FileItem> list = upload.parseRequest(request);
			//迭代List集合，拿到封装了每一个输入项数据的FileItem对象
			for (FileItem item : list) {
				//判断FileItem的类型，如果是普通字段，则直接获取数据，如果是上传文件，则调用流获取数据写到本地硬盘
				if (item.isFormField()) {
					//为普通输入项的数据
					String inputName = item.getFieldName();
					String inputValue = item.getString("UTF-8");//解决普通输入项的中文乱码问题，这句代码等同于下面这句代码
					//inputValue = new String(inputValue.getBytes("ISO8859-1"), "UTF-8");
					System.out.println(inputName + "=" + inputValue);
				} else {
					//代表当前处理的item里面封装的是上传文件
					//IE6浏览器获取到的上传文件的名称是D:\a.txt；而IE7则是a.txt
					String filename = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
					
					if (filename == null || filename.trim().equals("")) {
						//return;千万不能return
						continue;
					}
					
					//拿到文件的扩展名
					String ext = filename.substring(filename.lastIndexOf(".") + 1);
					if (!types.contains(ext)) {
						request.setAttribute("message", "本系统不支持" + ext + "这种类型文件的上传");
						request.getRequestDispatcher("/message.jsp").forward(request, response);
						return;
					}
					
					InputStream in = item.getInputStream();
					int len = 0;
					byte[] buffer = new byte[1024];
					
					//得到保存在服务器中唯一的文件名
					String saveFileName = generateFileName(filename);
					//产生文件的保存目录
					 savepath = generateSavePath(this.getServletContext().getRealPath("/img"), saveFileName);
					 request.setAttribute("imgurl",savepath);
					FileOutputStream out = new FileOutputStream(savepath + File.separator + saveFileName);
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					out.close();
					in.close();
					
					/*
                     * 上传文件完了之后，定要删除临时文件，
                     * 千万注意：这句代码一定要放在流关闭之后，否则，还有流和它相关联，那就删除不掉临时文件，
                     * 为了确保流关闭、删除掉临时文件，最好把这些代码放到finally代码块中。
                     */
					item.delete();//删除临时文件，必须位于流关闭之后
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			request.setAttribute("meassage", "文件大小不能超过5M");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		//Object savepath;
		//return savepath;
		
        request.getRequestDispatcher("/admin/add_production.jsp").forward(request, response);
	}

	private String generateSavePath(String path, String filename) {
		int hashCode = filename.hashCode();//得到字符串在内存中的地址，如121221
		int dir1 = hashCode & 15;//int dir1 = hashCode & 0xf;代表一级目录
		int dir2 = (hashCode >> 4) & 0xf;//代表二级目录
		
		//用户第一次上传文件，此savepath目录在服务器的硬盘里原本是没有的，所以应将其创建出来
		String savepath = path + File.separator + dir1 + File.separator + dir2;
		//创建savepath这个目录
		File file = new File(savepath);
		if (!file.exists()) {
			file.mkdirs();//创建多级目录用mkdirs()方法
		}
		
		return savepath;
	}  

	private String generateFileName(String filename) {
		//返回诸如7e8edb28-2084-4125-9dbf-966303805ef5_李阿昀.txt这样的文件名
		return UUID.randomUUID().toString() + "_" + filename;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
