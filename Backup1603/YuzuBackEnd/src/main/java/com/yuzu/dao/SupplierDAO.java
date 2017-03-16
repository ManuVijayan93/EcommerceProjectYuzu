package com.yuzu.dao;

import java.util.List;


import com.yuzu.domain.Product;
import com.yuzu.domain.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> list();
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	
	public Supplier getSupplierByID(String id);

	public Supplier getSupplierByName(String name);

}
