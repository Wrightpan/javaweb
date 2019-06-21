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

//�����ϴ�����
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<String> types = Arrays.asList(".jpg", ".gif", ".avi", ".txt");
		List<String> types = Arrays.asList("jpg", "gif", "avi", "txt");
		String savepath;
		try {
			//������������
			DiskFileItemFactory factory = new DiskFileItemFactory();//�ڴ滺�����Ĵ�С��Ĭ��ֵΪ10K
			factory.setSizeThreshold(1024 * 1024);//�����ڴ滺�����Ĵ�СΪ1M
			factory.setRepository(new File(this.getServletContext().getRealPath("/img/temp")));
			
			//����������
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//�����ϴ��ļ��Ĵ�С
			upload.setFileSizeMax(1024 * 1024 * 5);//ֻҪ����5M��forѭ���ڽ�����ʱ��ͻ����쳣
			
			//�ύ�ı����Ͳ���multipart/form-data����û��Ҫ�ý��������н������ݣ����մ�ͳ��ʽ��ȡ�����ݼ���
			if (!upload.isMultipartContent(request)) {
				//���մ�ͳ��ʽ��ȡ������
				request.getParameter("username");
				//balabala......
				return;
			}
			
			//����ϴ��ļ����������Ƶ������������⣬���ý������ı��룬������ʲô���룬Ҳ����Ϲд��һ��Ҫ��������������ʲô�����ύ�ģ�
            upload.setHeaderEncoding("UTF-8");
			
			//���ý���������request���õ������������ϴ����ݵ�List����
			List<FileItem> list = upload.parseRequest(request);
			//����List���ϣ��õ���װ��ÿһ�����������ݵ�FileItem����
			for (FileItem item : list) {
				//�ж�FileItem�����ͣ��������ͨ�ֶΣ���ֱ�ӻ�ȡ���ݣ�������ϴ��ļ������������ȡ����д������Ӳ��
				if (item.isFormField()) {
					//Ϊ��ͨ�����������
					String inputName = item.getFieldName();
					String inputValue = item.getString("UTF-8");//�����ͨ������������������⣬�������ͬ������������
					//inputValue = new String(inputValue.getBytes("ISO8859-1"), "UTF-8");
					System.out.println(inputName + "=" + inputValue);
				} else {
					//����ǰ�����item�����װ�����ϴ��ļ�
					//IE6�������ȡ�����ϴ��ļ���������D:\a.txt����IE7����a.txt
					String filename = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
					
					if (filename == null || filename.trim().equals("")) {
						//return;ǧ����return
						continue;
					}
					
					//�õ��ļ�����չ��
					String ext = filename.substring(filename.lastIndexOf(".") + 1);
					if (!types.contains(ext)) {
						request.setAttribute("message", "��ϵͳ��֧��" + ext + "���������ļ����ϴ�");
						request.getRequestDispatcher("/message.jsp").forward(request, response);
						return;
					}
					
					InputStream in = item.getInputStream();
					int len = 0;
					byte[] buffer = new byte[1024];
					
					//�õ������ڷ�������Ψһ���ļ���
					String saveFileName = generateFileName(filename);
					//�����ļ��ı���Ŀ¼
					 savepath = generateSavePath(this.getServletContext().getRealPath("/img"), saveFileName);
					 request.setAttribute("imgurl",savepath);
					FileOutputStream out = new FileOutputStream(savepath + File.separator + saveFileName);
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					out.close();
					in.close();
					
					/*
                     * �ϴ��ļ�����֮�󣬶�Ҫɾ����ʱ�ļ���
                     * ǧ��ע�⣺������һ��Ҫ�������ر�֮�󣬷��򣬻�����������������Ǿ�ɾ��������ʱ�ļ���
                     * Ϊ��ȷ�����رա�ɾ������ʱ�ļ�����ð���Щ����ŵ�finally������С�
                     */
					item.delete();//ɾ����ʱ�ļ�������λ�����ر�֮��
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			request.setAttribute("meassage", "�ļ���С���ܳ���5M");
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
		int hashCode = filename.hashCode();//�õ��ַ������ڴ��еĵ�ַ����121221
		int dir1 = hashCode & 15;//int dir1 = hashCode & 0xf;����һ��Ŀ¼
		int dir2 = (hashCode >> 4) & 0xf;//�������Ŀ¼
		
		//�û���һ���ϴ��ļ�����savepathĿ¼�ڷ�������Ӳ����ԭ����û�еģ�����Ӧ���䴴������
		String savepath = path + File.separator + dir1 + File.separator + dir2;
		//����savepath���Ŀ¼
		File file = new File(savepath);
		if (!file.exists()) {
			file.mkdirs();//�����༶Ŀ¼��mkdirs()����
		}
		
		return savepath;
	}  

	private String generateFileName(String filename) {
		//��������7e8edb28-2084-4125-9dbf-966303805ef5_���.txt�������ļ���
		return UUID.randomUUID().toString() + "_" + filename;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
