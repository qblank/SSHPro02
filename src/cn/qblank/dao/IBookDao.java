package cn.qblank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.entity.Book;

public interface IBookDao {
	/**
	 * 查询所有
	 * @return
	 */
	List<Book> findAll();
	/**
	 * 添加图书
	 */
	void addBook(Book book);
	/**
	 * 修改图书
	 */
	void updateBook(Book book);
	
	/**
	 * 删除图书
	 */
	void deleteBook(Long id);
	
	/**
	 * 通过id查找
	 */
	Book findById(long id);
}
