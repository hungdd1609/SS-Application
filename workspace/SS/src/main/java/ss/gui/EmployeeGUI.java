package ss.gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ss.bus.EmployeeBUS;
import ss.dto.EmployeeDTO;

public class EmployeeGUI {

	private JFrame frame;
	private JTable table;
	
	EmployeeBUS emBUS = new EmployeeBUS();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeGUI window = new EmployeeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setVisible(Boolean isVisible) {
		this.frame.setVisible(isVisible);
	}

	/**
	 * Create the application.
	 */
	public EmployeeGUI() {
		initialize();
		loadAllEmployee();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "EmployeeName", "PhoneNumber", "Address"
			}
		));	        

		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
	}
	
	public void loadAllEmployee(){
        String[] header = {"STT","EmployeeName","PhoneNumber","Address"};
        DefaultTableModel dtm = new DefaultTableModel(header,0);
        ArrayList<EmployeeDTO> arr = new ArrayList<EmployeeDTO>();
        arr = emBUS.getAllEmployee();
        EmployeeDTO em = new EmployeeDTO();
        for(int i = 0; i < arr.size(); i++){
            em = arr.get(i);
            int id =  em.getEmployeeId();
            String name = em.getEmployeeName();
            int phone = em.getPhonenumber();
            String address = em.getAddress();
            Object[] row = {id,name,phone,address};
            dtm.addRow(row);
        }
        table.setModel(dtm);

    }

}
