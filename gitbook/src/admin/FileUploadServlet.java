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


@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> types = Arrays.asList("jpg", "gif", "avi", "txt");
		String savepath;
		try {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024 * 1024);
			factory.setRepository(new File(this.getServletContext().getRealPath("/img/temp")));
			
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			
			upload.setFileSizeMax(1024 * 1024 * 5);
			
			
			if (!upload.isMultipartContent(request)) {
				
				request.getParameter("username");
				
				return;
			}
			
			
            upload.setHeaderEncoding("UTF-8");
			
			
			List<FileItem> list = upload.parseRequest(request);
			
			for (FileItem item : list) {
				
				if (item.isFormField()) {
					
					String inputName = item.getFieldName();
					String inputValue = item.getString("UTF-8");
					
					System.out.println(inputName + "=" + inputValue);
				} else {
					
					String filename = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
					
					if (filename == null || filename.trim().equals("")) {
						
						continue;
					}
					
					
					String ext = filename.substring(filename.lastIndexOf(".") + 1);
					if (!types.contains(ext)) {
						
						return;
					}
					
					InputStream in = item.getInputStream();
					int len = 0;
					byte[] buffer = new byte[1024];
					
					
					String saveFileName = generateFileName(filename);
					
					 savepath = generateSavePath(this.getServletContext().getRealPath("/img"), saveFileName);
					 request.setAttribute("imgurl",savepath);
					FileOutputStream out = new FileOutputStream(savepath + File.separator + saveFileName);
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					out.close();
					in.close();
					
					
					item.delete();
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			
			return;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
        request.getRequestDispatcher("/admin/add_production.jsp").forward(request, response);
	}

	private String generateSavePath(String path, String filename) {
		int hashCode = filename.hashCode();
		int dir1 = hashCode & 15;
		int dir2 = (hashCode >> 4) & 0xf;
		
		
		String savepath = path + File.separator + dir1 + File.separator + dir2;
		
		File file = new File(savepath);
		if (!file.exists()) {
			file.mkdirs();
		}
		
		return savepath;
	}  

	private String generateFileName(String filename) {
		
		return UUID.randomUUID().toString() + "_" + filename;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
