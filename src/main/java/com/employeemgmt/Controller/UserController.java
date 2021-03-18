package com.employeemgmt.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employeemgmt.Domain.Employee;
import com.employeemgmt.Domain.User;
import com.employeemgmt.Service.EmployeeService;
import com.employeemgmt.Service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String loginform(@ModelAttribute User user, Model model, HttpServletRequest req)
			throws JsonParseException, JsonMappingException, IOException {
		String url = "login";
		String userName = user.getUserName();
		String password = user.getPassword();
		HttpSession session = req.getSession();
		session.setAttribute("userInfo", "Hello " + userName);
		if (this.userService.validate(userName, password)) {
			url = "view";
			model.addAttribute("employees", this.employeeService.fetchAllEmployees());
		}
		Employee[] emp = this.employeeService.fetchAllEmployees();
		for (Employee employee : emp) {
			System.out.println(employee.toString());
		}
		return url;
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String registerform(@ModelAttribute User user, Model model) {
		this.userService.register(user);
		return "login";
	}

	@RequestMapping("/registration")
	public String registration() {
		return "registration";
	}

	@RequestMapping("/")
	public String home() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logOut() throws IOException {
		return "login";
	}
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value = Exception.class)
//	public String exceptionHandler(Model model) {
//		model.addAttribute("message", "Something Wrong Occured. Please try again later");
//		return "error";
//	}
}
