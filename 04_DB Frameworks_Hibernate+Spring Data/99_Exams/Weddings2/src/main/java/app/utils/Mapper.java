package app.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import app.domain.entities.*;
import app.domain.dtos.*;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
	
	private ModelMapper mapper = new ModelMapper();
		
	public <S, D> D mapOne(S source, Class<D> destinationClass) {
		return mapper.map(source, destinationClass);
	}
	
	public <S, D> List<D> mapToList(List<S> source, Class<D> destinationClass) {
		List<D> resultList = new ArrayList<>();
		for (S s : source) {
			resultList.add(mapOne(s, destinationClass));
		}
		return resultList;
	}
	
	public <S, D> List<D> mapToList(Set<S> source, Class<D> destinationClass) {
		List<D> resultList = new ArrayList<>();
		for (S s : source) {
			resultList.add(mapOne(s, destinationClass));
		}
		return resultList;
	}
	
	public <S, D> Set<D> mapToSet(Set<S> source, Class<D> destinationClass) {
		Set<D> resultList = new HashSet<>();
		for (S s : source) {
			resultList.add(mapOne(s, destinationClass));
		}
		return resultList;
	}
	
	public <S, D> Set<D> mapToSet(List<S> source, Class<D> destinationClass) {
		Set<D> resultList = new HashSet<>();
		for (S s : source) {
			resultList.add(mapOne(s, destinationClass));
		}
		return resultList;
	}
	
	//	ModelMapper mp = new ModelMapper();
	//	PropertyMap<Product, ProductWithSellerDto> propertyMap = new PropertyMap<Product, ProductWithSellerDto>() {
	//	     protected void configure() {
	//	    	 map().setSellerName(source.getSeller().getFullName());
	//	     }
	//		};
	//	mp.addMappings(propertyMap);
	
}
