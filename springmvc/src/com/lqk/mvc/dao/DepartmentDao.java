package com.lqk.mvc.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.lqk.mvc.entities.Department;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments = null;
	
	static{
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(101, "D-Mercury"));
		departments.put(102, new Department(102, "D-Venus"));
		departments.put(103, new Department(103, "D-Mars"));
		departments.put(104, new Department(104, "D-Jupiter"));
		departments.put(105, new Department(105, "D-Saturn"));
	}
	
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartment(Integer id){
		return departments.get(id);
	}
	
}
