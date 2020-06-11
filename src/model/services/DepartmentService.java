package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {

	public List<Department> findAll() {
		// MOCK - Um mock � basicamente um objeto simulado aonde voc� pode controlar
		// certos aspectos dele com o intuito de testar um comportamento
		// espec�fico dele pr�prio ou de outro que dependa dele.

		List<Department> list = new ArrayList<>();

		list.add(new Department(1, "Books"));
		list.add(new Department(2, "Computers"));
		list.add(new Department(3, "Electronics"));

		return list;
	}
}
