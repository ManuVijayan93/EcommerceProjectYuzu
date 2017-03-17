package com.yuzu.dao;

import java.util.List;

import com.yuzu.domain.Category;
import com.yuzu.domain.Product;

public interface ProductDAO {

	public List<Product> list();

	public boolean save(Product product);

	public boolean update(Product product);

	public boolean delete(Product product);

	public Product getProductByID(String id);

	public Product getProductByName(String name);
}
