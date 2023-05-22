package com.req.java_contest.java_mac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class ProductDB {
	Connection conn = null;
	public ProductDB() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","manohar","Manohar@519");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void save(Product p) {
		String query = "insert into products (name,type,place,warranty) values (?,?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, p.getName());
			st.setString(2, p.getType());
			st.setString(3, p.getPlace());
			st.setInt(4, p.getWarranty());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();
		String query = "select * from products";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setName(rs.getString(1));
				p.setType(rs.getString(2));
				p.setPlace(rs.getString(3));
				p.setWarranty(rs.getInt(4));
				products.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

}
