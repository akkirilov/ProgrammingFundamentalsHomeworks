package app.domain.dtos.employees;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeWrapperXmlDto implements Serializable {

	@XmlElement(name = "employee")
	private List<EmployeeXmlDto> employeeXmlDtos;

	public EmployeeWrapperXmlDto() {
		super();
	}

	public List<EmployeeXmlDto> getEmployeeXmlDtos() {
		return employeeXmlDtos;
	}

	public void setEmployeeXmlDtos(List<EmployeeXmlDto> employeeXmlDtos) {
		this.employeeXmlDtos = employeeXmlDtos;
	}
	
}
