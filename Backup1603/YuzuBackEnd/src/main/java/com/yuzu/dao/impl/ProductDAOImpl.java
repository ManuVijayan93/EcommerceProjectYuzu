package com.yuzu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yuzu.dao.ProductDAO;
import com.yuzu.domain.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("from Product").list();

	}

	public Product getProduct(String id) {

		return (Product) getSession().get(Product.class, id);
	}

	public boolean save(Product product) {

		try {
			getSession().save(product);
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {

		try {
			getSession().update(product);
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Product product) {

		try {
			getSession().delete(product);
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Product getProductByID(String id) {

		return (Product) sessionFactory.getCurrentSession().createQuery("from Category where id='" + id + "'")
				.uniqueResult();
	}

	public Product getProductByName(String name) {

		return (Product) sessionFactory.getCurrentSession().createQuery("from Category where name='" + name + "'")
				.uniqueResult();
	}

}
