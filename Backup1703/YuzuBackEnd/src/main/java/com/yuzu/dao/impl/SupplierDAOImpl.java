package com.yuzu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yuzu.dao.SupplierDAO;
import com.yuzu.domain.Category;
import com.yuzu.domain.Product;
import com.yuzu.domain.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<Supplier> list() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	public boolean save(Supplier supplier) {
		try {

			getSession().save(supplier);

			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) {
		try {

			getSession().update(supplier);

			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Supplier supplier) {
		try {

			getSession().delete(supplier);

			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Supplier getSupplierByID(String id) {

		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where id='" + id + "'")
				.uniqueResult();
	}

	public Supplier getSupplierByName(String name) {

		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where name='" + name + "'")
				.uniqueResult();
	}

}
