package com.employeemgmt.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeemgmt.Domain.Employee;
import com.employeemgmt.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@RequestMapping("/editDetails")
	public String editDetailsForm(HttpServletRequest req, ModelMap m) throws JsonMappingException, NumberFormatException, JsonProcessingException {
		String id = req.getParameter("empId");
		m.addAttribute("employee", employeeService.fetchEmployeeById(id));
		return "editDetails";
	}
	
	@RequestMapping("/updateDetails")
	public String updateDetailsSubmission(HttpServletRequest req, ModelMap m) throws IOException {
		Employee ob = new Employee();
		ob.setDob(req.getParameter("empDOB"));
		ob.setEmail(req.getParameter("empEmail"));
		ob.setEmployeeCode(Integer.parseInt(req.getParameter("empId")));
		ob.setLocation(req.getParameter("empLocation"));
		ob.setFirstName(req.getParameter("firstName"));
		ob.setLastName(req.getParameter("lastName"));
		
		employeeService.updateEmployeeDetails(ob);
		m.addAttribute("employees", employeeService.fetchAllEmployees());
		return "view";
	}
	
	@RequestMapping("/delete")
	public String deleteUserDetails(HttpServletRequest req, ModelMap m) throws JsonParseException, JsonMappingException, IOException {
//		int id = Integer.parseInt(req.getParameter("id"));
		employeeService.deleteEmployee(req.getParameter("id"));
		m.addAttribute("employees", employeeService.fetchAllEmployees());
		return "view";	
	}
	@RequestMapping("/addNewEmployee")
	public String addNewDetails () throws IOException {
		return "addUser";
	}
	@RequestMapping("/addEmployee")
	public String addEmployeeDetails (HttpServletRequest req, ModelMap model) throws IOException {
		Employee emp = new Employee();		
		emp.setDob(req.getParameter("empDOB"));
		emp.setEmail(req.getParameter("empEmail"));
		emp.setEmployeeCode(Long.parseLong(req.getParameter("empId")));
		emp.setLocation(req.getParameter("empLocation"));
		emp.setFirstName(req.getParameter("firstName"));
		emp.setLastName(req.getParameter("lastName"));
			
		this.employeeService.addEmployee(emp);
		model.addAttribute("employees", this.employeeService.fetchAllEmployees());
		return "view";
	}
	
	@RequestMapping("/downloadData")
	public void downloadData (HttpServletRequest req, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		String jsonfile = employeeService.fetchAllEmployeesFile();
		InputStream stream = new ByteArrayInputStream(jsonfile.getBytes(StandardCharsets.UTF_8));
		PrintWriter out = response.getWriter();  
		response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=employeesInfo.pdf");
        int i;   
        while ((i=stream.read()) != -1) {  
        out.write(i);   
        }   
        stream.close();   
        out.close();   
	}
	
}
