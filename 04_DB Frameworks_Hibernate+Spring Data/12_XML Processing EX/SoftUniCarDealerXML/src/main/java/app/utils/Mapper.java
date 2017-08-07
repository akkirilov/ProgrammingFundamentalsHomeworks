package app.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;

public class Mapper {
	
	private static ModelMapper mapper = new ModelMapper();
	
	public static <S, D> D mapOne(S source, Class<D> destinationClass) {
		return mapper.map(source, destinationClass);
	}
	
	public static <S, D> List<D> mapToList(List<S> source, Class<D> destinationClass) {
		List<D> resultList = new ArrayList<>();
		for (S s : source) {
			resultList.add(mapOne(s, destinationClass));
		}
		return resultList;
	}
	
	public static <S, D> List<D> mapToList(Set<S> source, Class<D> destinationClass) {
		List<D> resultList = new ArrayList<>();
		for (S s : source) {
			resultList.add(mapOne(s, destinationClass));
		}
		return resultList;
	}

	public static <S, D> Set<D> mapToSet(List<S> source, Class<D> destinationClass) {
		Set<D> resultSet = new HashSet<>();
		for (S s : source) {
			resultSet.add(mapOne(s, destinationClass));
		}
		return resultSet;
	}
	
	public static <S, D> Set<D> mapToSet(Set<S> source, Class<D> destinationClass) {
		Set<D> resultSet = new HashSet<>();
		for (S s : source) {
			resultSet.add(mapOne(s, destinationClass));
		}
		return resultSet;
	}

}
