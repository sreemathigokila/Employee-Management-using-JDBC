package in.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.kce.bean.Employee;
import in.kce.util.DBUtil;

public class EmployeeDAO {
	//Store Employee
	public boolean saveEmployee(Employee employee) {
		
		Connection connection=DBUtil.getConnection();
		String query="insert into employee2 values(?,?,?)";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setString(3, employee.getDesignation());
			int row=preparedStatement.executeUpdate();
			if(row>=1) {
				return true;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
				
		
	}
	//update Employee
	public boolean updateEmployee(Employee employee) {
		
		Connection connection=DBUtil.getConnection();
		String query="update employee2 set empName=? where empId=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, employee.getEmpName());
			ps.setInt(2, employee.getEmpId());
			int n=ps.executeUpdate();
			if(n>=1) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//delete Employee
	public boolean deleteEmployee(int empId) {
		
		Connection con=DBUtil.getConnection();
		String query="delete from employee2 where empId=? ";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, empId);
			int m=ps.executeUpdate();
			if(m>=1) {
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
		
	}
	//fetch one employee
	public Employee getEmployee(int empId) {
		
		Connection con=DBUtil.getConnection();
		String query="select * from employee2 where empId=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,empId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setDesignation(rs.getString(3));
				return emp;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	//fetch all employees
	public ArrayList<Employee> getAllEmployees(){
		
		Connection con=DBUtil.getConnection();
		String query="select * from employee2";
		ArrayList<Employee> l=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setDesignation(rs.getString(3));
				l.add(emp);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
}
