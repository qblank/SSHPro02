package cn.qblank.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.qblank.entity.Book;
import cn.qblank.service.IBookService;


@Controller  //������ע��
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String add(@ModelAttribute @Valid Book book,BindingResult bindingResult){
		//����ҵ��
		//���ͼ��
		bookService.addBook(book);
		if (bindingResult.hasErrors()) {
			return "add";
		}
		//��ת
		return "redirect:/list";
	}
	
	/**
	 * չʾͼ���б�
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(Model model){
		//����service����ҵ��
		List<Book> books = bookService.findAll();
		//����model��
		model.addAttribute("books", books);
		return "list";
	}
	
	/**
	 * ɾ������
	 * @param book
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String delete(@ModelAttribute Book book){
		bookService.deleteBook(book.getId());
		return "redirect:/list";
	}
	
	/**
	 * ��ת���޸�ҳ��
	 * @param model
	 * @param book
	 * @return
	 */
	@RequestMapping(value = "/update/{id}")
	public String update(@PathVariable long id,Model model){
		Book book = bookService.findById(id);
		
		System.out.println(book);
		model.addAttribute("book",book);
		return "update";
	}
	
	/**
	 * ��ת����ҳ
	 */
	@RequestMapping(value = "/updateJsp")
	public String updateJsp(Model model,@Valid Book book, BindingResult bindingResult){
//		if (bindingResult)
		book = bookService.findById(book.getId());
		//�����޸Ĳ���
		bookService.updateBook(book);
		return "redirect:/list";
	}
	/**
	 * ��ת��jspҳ��
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET , value = "/addJsp")
	public String addJsp(@ModelAttribute @Valid Book book,BindingResult bindingResult){
		return "add";
	}
	
}
