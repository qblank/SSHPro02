package cn.qblank.service;

import java.util.List;

import cn.qblank.entity.Book;

public interface IBookService {
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
	 * 通过id查询
	 * @param id
	 * @return
	 */
	Book findById(Long id);
}
