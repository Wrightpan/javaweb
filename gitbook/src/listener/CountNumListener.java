package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountNumListener implements HttpSessionListener {
	
	
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//得到ServletContext
		ServletContext context = se.getSession().getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		if (count == null) {
			count = 1;
			context.setAttribute("count", count);
		} else {
			count++;
			context.setAttribute("count", count);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//得到ServletContext
		ServletContext context = se.getSession().getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		count--;
		context.setAttribute("count", count);
	}

}

