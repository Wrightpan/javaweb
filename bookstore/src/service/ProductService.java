package service;

import java.util.List;

import annotation.PrivilegeInfo;
import  domain.Product;
import  domain.User;
import  exception.PrivilegeException;

public interface ProductService {

	// �����Ʒ
	@PrivilegeInfo("�����Ʒ")
	public void add(User user, Product product) throws PrivilegeException,
			Exception;

	// ������Ʒ
	public List<Product> findAll() throws Exception;

	// ����id������Ʒ
	public Product findById(String id) throws Exception;

	// ��ѯ���۰�
	@PrivilegeInfo("���ذ�")
	public List<Product> findSell(User user) throws PrivilegeException,
			Exception;
}
