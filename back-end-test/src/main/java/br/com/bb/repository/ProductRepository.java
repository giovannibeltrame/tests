package br.com.bb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.bb.entity.Category;
import br.com.bb.entity.Product;

@Repository
public class ProductRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setCategory(new Category(rs.getInt("idcategory"), ""));
			product.setValue(rs.getDouble("pricevalue"));
			return product;
		}
	}
	
	public List<Product> findByIdCategory(Integer id) {
		return jdbcTemplate.query("select * from product where idcategory=?", new Object[] { id }, new ProductRowMapper());
	}
	
	public Double findAvgPriceValue() {
		return jdbcTemplate.queryForObject("select avg(pricevalue) from product", Double.class);
	}
	
}
