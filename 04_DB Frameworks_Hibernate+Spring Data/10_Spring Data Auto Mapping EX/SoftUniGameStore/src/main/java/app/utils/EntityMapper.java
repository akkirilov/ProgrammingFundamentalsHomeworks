package app.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class EntityMapper {
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static <S, D> D map(S source, Class<D> destinationClass){
		D result = modelMapper.map(source, destinationClass);
		return result;
	}
	
	public static <S, D> List<D> map(List<S> source, Class<D> destinationClass){
		List<D> result = new ArrayList<>();
		for (S s : source) {
			result.add(modelMapper.map(s, destinationClass));
		}
		return result;
	}
	
}
