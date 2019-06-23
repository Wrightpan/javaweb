package com.atguigu.mvcapp.dao.impl;

import java.util.List;

import com.atguigu.mvcapp.dao.CriteriaCustomer;
import com.atguigu.mvcapp.dao.CustomerDAO;
import com.atguigu.mvcapp.dao.DAO;
import com.atguigu.mvcapp.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		String sql = "SELECT id, name, address, phone FROM customers WHERE " +
				"name LIKE ? AND address LIKE ? AND phone LIKE ?";
		//修改了 CriteriaCustomer 的 getter 方法: 使其返回的字符串中有 "%%".
		//若返回值为 null 则返回 "%%", 若不为 null, 则返回 "%" + 字段本身的值 + "%"
		return getForList(sql, cc.getName(), cc.getAddress(), cc.getPhone());
	}
	
	@Override
	public List<Customer> getAll() {
		String sql = "SELECT id, name, address, phone FROM customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		String sql = "INSERT INTO customers(name, address, phone) VALUES(?,?,?)";
		update(sql, customer.getName(), customer.getAddress(), customer.getPhone()); 
	}

	@Override
	public Customer get(Integer id) {
		String sql = "SELECT id, name, address, phone FROM customers WHERE id = ?";
		return get(sql, id); 
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM customers WHERE id = ?";
		update(sql, id);
	}

	@Override
	public long getCountWithName(String name) {
		String sql = "SELECT count(id) FROM customers WHERE name = ?";
		return getForValue(sql, name); 
	}

	@Override
	public void update(Customer customer) {
		String sql = "UPDATE customers SET name = ?, address = ?, phone = ? " +
				"WHERE id = ?";
		update(sql, customer.getName(), customer.getAddress(), 
				customer.getPhone(), customer.getId());
	}

}
