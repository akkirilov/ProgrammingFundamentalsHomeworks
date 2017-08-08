package app.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import app.domain.entities.*;
import app.domain.dtos.*;
import app.domain.dtos.cameras.CameraImportJsonDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

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



	//	ModelMapper mp = new ModelMapper();
	//	PropertyMap<Product, ProductWithSellerDto> propertyMap = new PropertyMap<Product, ProductWithSellerDto>() {
	//	     protected void configure() {
	//	    	 map().setSellerName(source.getSeller().getFullName());
	//	     }
	//		};
	//	mp.addMappings(propertyMap);
	
}
