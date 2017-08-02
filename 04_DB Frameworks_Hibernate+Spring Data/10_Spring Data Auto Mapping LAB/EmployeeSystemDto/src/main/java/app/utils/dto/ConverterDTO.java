package app.utils.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import app.entities.Employee;
import app.entities.EmployeeWithManagerDto;

public class ConverterDTO {

	private static ModelMapper modelMapper = new ModelMapper();
	
	public static <S, D> D convert(S source, Class<D> destinationClass) {
		return modelMapper.map(source, destinationClass);
	}
	
	public static <S, D> List<D> convert(List<S> source, Class<D> destinationClass) {
		List<D> result = new ArrayList<>();
		for (S s : source) {
			result.add(convert(s, destinationClass));
		}
		return result;
	}
	
	public static List<EmployeeWithManagerDto> convertToEmployeeWithManager(List<Employee> sources, Class<EmployeeWithManagerDto> destinationClass) {
		List<EmployeeWithManagerDto> employeeWithManagerDtos = new ArrayList<>();
		PropertyMap<Employee, EmployeeWithManagerDto> employeeWithManagerMap = new PropertyMap<Employee, EmployeeWithManagerDto>(){
			@Override
			protected void configure() {
				map().setManagerLastName(source.getManager().getLastName());
			}
		};
		modelMapper.addMappings(employeeWithManagerMap);
		for (Employee e : sources) {
			employeeWithManagerDtos.add(modelMapper.map(e, destinationClass));
		}
		return employeeWithManagerDtos; 
	}
	
}
