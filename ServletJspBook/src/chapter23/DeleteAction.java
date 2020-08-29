package chapter23;

import bean.Product;
import dao.ProductDAO;
import tool.Action;
import javax.servlet.http.*;
import java.util.List;

public class DeleteAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		Integer id=Integer.parseInt(request.getParameter("id"));

		Product p=new Product();
		p.setId(id);
		ProductDAO dao=new ProductDAO();
		dao.delete(p.getId());

		List<Product> list=dao.search("");
		request.setAttribute("list", list);

		return "list.jsp";
	}
}
