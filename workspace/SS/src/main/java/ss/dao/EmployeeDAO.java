package ss.dao;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ss.bus.IEmployee;
import ss.dto.EmployeeDTO;
import ss.entities.Employee;
import ss.utils.HibernateUtils;

public class EmployeeDAO implements IEmployee{

	Mapper mapper = new DozerBeanMapper();
	SessionFactory factory = HibernateUtils.getSessionFactory();
	Session session = factory.getCurrentSession();

	public ArrayList<EmployeeDTO> getAllEmployee() {

		ArrayList<EmployeeDTO> arr = new ArrayList<EmployeeDTO>();

		try {
			session.getTransaction().begin(); 

			String sql = "Select e from " + Employee.class.getName() + " e ";
			Query<Employee> query = session.createQuery(sql);
			List<Employee> employees = query.getResultList();

			for (Employee emp : employees) {       	                              

				EmployeeDTO employeeDTO = mapper.map(emp, EmployeeDTO.class);
				arr.add(employeeDTO);
			} 

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}


		return arr;
	}

}
