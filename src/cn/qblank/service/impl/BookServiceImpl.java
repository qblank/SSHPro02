package cn.qblank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.dao.IBookDao;
import cn.qblank.entity.Book;
import cn.qblank.service.IBookService;

@Service
@Transactional
public class BookServiceImpl implements IBookService{
	@Autowired
	private IBookDao bookDao;

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void updateBook(Book book) {
		System.out.println("service:" + book);
		bookDao.updateBook(book);
	}

	@Override
	public void deleteBook(Long id) {
		bookDao.deleteBook(id);
	}

	@Override
	public Book findById(Long id) {
		return bookDao.findById(id);
	}
	
}
