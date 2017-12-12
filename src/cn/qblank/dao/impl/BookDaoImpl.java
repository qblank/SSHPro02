package cn.qblank.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.qblank.dao.IBookDao;
import cn.qblank.entity.Book;

@Repository
@Transactional
public class BookDaoImpl implements IBookDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Book").list();
	}

	@Override
	public void addBook(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.save(book);
	}

	@Override
	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	@Override
	public void deleteBook(Long id) {
		Session session = sessionFactory.getCurrentSession();
		//通过id查询到对象
		Book book = session.get(Book.class, id);
		session.delete(book);
	}

	@Override
	public Book findById(long id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}
	
}
