package br.com.bb.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.bb.entity.Category;

@Repository
public class CategoryRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class CategoryRowMapper implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			return category;
		}
	}
	
	public List<Category> listAll() {
		return jdbcTemplate.query("select * from category", new CategoryRowMapper());
	}

}
