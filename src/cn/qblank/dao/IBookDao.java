package cn.qblank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.entity.Book;

public interface IBookDao {
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
	 * ͨ��id����
	 */
	Book findById(long id);
}
