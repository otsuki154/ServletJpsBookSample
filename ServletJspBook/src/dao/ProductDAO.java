package dao;

import bean.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ProductDAO extends DAO {

	public List<Product> search(String keyword) throws Exception {
		List<Product> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from product where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Product p=new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

	public int insert(Product product) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"insert into product values(null, ?, ?)");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
	
	public int delete(Integer id) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"delete from product where id = ?");
		st.setInt(1, id);
		
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}