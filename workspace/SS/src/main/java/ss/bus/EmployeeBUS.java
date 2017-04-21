package ss.bus;

import java.util.ArrayList;

import ss.dao.EmployeeDAO;
import ss.dto.EmployeeDTO;

public class EmployeeBUS implements IEmployee{
	EmployeeDAO employeeDAO = new EmployeeDAO();

	public ArrayList<EmployeeDTO> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

}
