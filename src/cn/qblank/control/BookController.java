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


@Controller  //控制器注解
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String add(@ModelAttribute @Valid Book book,BindingResult bindingResult){
		//调用业务
		//添加图书
		bookService.addBook(book);
		if (bindingResult.hasErrors()) {
			return "add";
		}
		//跳转
		return "redirect:/list";
	}
	
	/**
	 * 展示图书列表
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(Model model){
		//调用service处理业务
		List<Book> books = bookService.findAll();
		//存入model中
		model.addAttribute("books", books);
		return "list";
	}
	
	/**
	 * 删除功能
	 * @param book
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public String delete(@ModelAttribute Book book){
		bookService.deleteBook(book.getId());
		return "redirect:/list";
	}
	
	/**
	 * 跳转到修改页面
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
	 * 跳转到主页
	 */
	@RequestMapping(value = "/updateJsp")
	public String updateJsp(Model model,@Valid Book book, BindingResult bindingResult){
//		if (bindingResult)
		book = bookService.findById(book.getId());
		//进行修改操作
		bookService.updateBook(book);
		return "redirect:/list";
	}
	/**
	 * 跳转到jsp页面
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET , value = "/addJsp")
	public String addJsp(@ModelAttribute @Valid Book book,BindingResult bindingResult){
		return "add";
	}
	
}
