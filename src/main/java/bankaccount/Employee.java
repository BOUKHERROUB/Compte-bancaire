package bankaccount;

import utils.Address;
import common.Person;

public class Employee extends Person {

	private Integer employeeId;
	private FunctionEnum function;
	private Agency agency;
	private double salary;
	
	public Employee(String name, String fullName, String dateOfBirth,
			Address address, String phoneNumber, String mailAddress, FunctionEnum function,
			double salary, Agency agency) {
		super(name, fullName, dateOfBirth, address, phoneNumber, mailAddress);
		this.function = function;
		this.salary = salary;
		this.agency = agency;
		AgencyContext.getAgencyInstance().addEmployeeToAgency(agency, this);
	}

	public FunctionEnum getFunction() {
		return function;
	}

	public void setFunction(FunctionEnum function) {
		this.function = function;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public Integer getId() {
		return employeeId;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.employeeId = id;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
}
