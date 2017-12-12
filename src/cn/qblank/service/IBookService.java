package cn.qblank.service;

import java.util.List;

import cn.qblank.entity.Book;

public interface IBookService {
	/**
	 * ��ѯ����
	 * @return
	 */
	List<Book> findAll();
	/**
	 * ���ͼ��
	 */
	void addBook(Book book);
	/**
	 * �޸�ͼ��
	 */
	void updateBook(Book book);
	
	/**
	 * ɾ��ͼ��
	 */
	void deleteBook(Long id);
	/**
	 * ͨ��id��ѯ
	 * @param id
	 * @return
	 */
	Book findById(Long id);
}
