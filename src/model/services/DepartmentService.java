package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {

	public List<Department> findAll() {
		// MOCK - Um mock é basicamente um objeto simulado aonde você pode controlar
		// certos aspectos dele com o intuito de testar um comportamento
		// específico dele próprio ou de outro que dependa dele.

		List<Department> list = new ArrayList<>();

		list.add(new Department(1, "Books"));
		list.add(new Department(2, "Computers"));
		list.add(new Department(3, "Electronics"));

		return list;
	}
}
