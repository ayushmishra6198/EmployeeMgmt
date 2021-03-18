package com.employeemgmt.Service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employeemgmt.Domain.Employee;
import com.employeemgmt.Utils.CommonConstants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Service
public class EmployeeService {

	public Employee[] fetchAllEmployees() throws JsonParseException, JsonMappingException, IOException {
		final String uri = CommonConstants.URL;
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		Employee[] users = new ObjectMapper().readValue(result, Employee[].class);
		return users;
	}

	public Employee fetchEmployeeById(String id) throws JsonMappingException, JsonProcessingException {
		final String uri = CommonConstants.URL + id;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return new ObjectMapper().readValue(result, Employee.class);
	}

	public void updateEmployeeDetails(Employee object) throws JsonProcessingException {
		final String uri = CommonConstants.URL;

		ObjectMapper m = new ObjectMapper();
		String json = m.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		Client client = Client.create();
		WebResource webResource = client.resource(uri);
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);
		response.close();
	}

	public void deleteEmployee(String id) {
		final String uri = CommonConstants.URL + id;
		Client client = Client.create();
		WebResource webResource = client.resource(uri);
		webResource.delete();
	}

	public void addEmployee(Employee object) throws JsonProcessingException {
		final String uri = CommonConstants.URL;

		ObjectMapper m = new ObjectMapper();
		String json = m.writerWithDefaultPrettyPrinter().writeValueAsString(object);

		Client client = Client.create();
		WebResource webResource = client.resource(uri);
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);
		response.close();
	}

	public String fetchAllEmployeesFile() throws IOException {
		final String uri = CommonConstants.URL;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri, String.class);
	}

}
