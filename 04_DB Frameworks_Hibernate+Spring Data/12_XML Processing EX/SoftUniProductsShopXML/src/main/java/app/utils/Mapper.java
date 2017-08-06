package app.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import app.entities.*;
import app.models.*;
import app.models.productsDto.ProductWithBayerDto;
import app.models.productsDto.ProductWithSellerDto;
import app.models.productsDto.ProductsDto;

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
	
	public static ProductsDto mapToProductsWithSellerDtoXml(List<Product> source) {
		List<ProductWithSellerDto> productsWithSeller = new ArrayList<>();
		ModelMapper mp = new ModelMapper();
		PropertyMap<Product, ProductWithSellerDto> propertyMap = new PropertyMap<Product, ProductWithSellerDto>() {
		     protected void configure() {
		    	 map().setSellerName(source.getSeller().getFullName());
		     }
		   };
		mp.addMappings(propertyMap);
		for (Product product : source) {
			productsWithSeller.add(mp.map(product, ProductWithSellerDto.class));			
		}
		ProductsDto productsDtos = new ProductsDto();
		productsDtos.setProductWithSellerDtos(productsWithSeller);
		return productsDtos;
	}
	
	
	
	
	//
	//public static List<ProductInRangeJsonDto> mapToProductInRangeList(List<Product> source) {
	//	List<ProductInRangeJsonDto> resultList = new ArrayList<>();
	//	ModelMapper mp = new ModelMapper();
	//	PropertyMap<Product, ProductInRangeJsonDto> propertyMap = new PropertyMap<Product, ProductInRangeJsonDto>() {
	//	     protected void configure() {
	//	    	map().setSeller(source.getSeller().getFullName());
	//	     }
	//	   };
	//	mp.addMappings(propertyMap);
	//	for (Product p : source) {
	//		resultList.add(mp.map(p, ProductInRangeJsonDto.class));
	//	}
	//	return resultList;
	//}
	//	
	//public static List<CategoryInfo> mapToCategoryInfoList(List<Category> source) {
	//	List<CategoryInfo> resultList = new ArrayList<>();
	//	Integer size;
	//	BigDecimal sum;
	//	for (Category c : source) {
	//		CategoryInfo ci = new CategoryInfo();
	//		sum = BigDecimal.ZERO;
	//		ci.setCategory(c.getName());
	//		size = c.getProducts().size();
	//		ci.setProductsCount(size);
	//		for (Product p : c.getProducts()) {
	//			sum = sum.add(p.getPrice());
	//		}
	//		ci.setTotalRevenue(sum);
	//		ci.setAveragePrice(sum.divide(BigDecimal.valueOf(size), 6));
	//		resultList.add(ci);
	//	}
	//	return resultList;
	//}
    //
	//public static UsersInfoDto mapToUsersInfo(List<User> users) {
	//	Set<UserProductsInfoDto> upiSet = new HashSet<>();
	//	
	//	UsersInfoDto usersInfo = new UsersInfoDto();
	//	for (User user : users) {
	//		
	//		UserProductsInfoDto upi = new UserProductsInfoDto();
	//					
	//		SoldProductsInfoDto spi = new SoldProductsInfoDto();
	//		
	//		Set<ProductSoldBasicJsonDto> psbSet = new HashSet<>();
	//		for (Product p : user.getSoldProducts()) {
	//			psbSet.add(new ProductSoldBasicJsonDto(p.getName(), p.getPrice()));
	//		}
	//		
	//		spi.setSoldProducts(psbSet);
	//		spi.setCount(psbSet.size());
	//		
	//		upi.setSoldProducts(spi);
	//		upi.setFirstName(user.getFirstName());
	//		upi.setLastName(user.getLastName());
	//		upi.setAge(user.getAge());
	//		
	//		upiSet.add(upi);
	//	}
	//	usersInfo.setUsers(upiSet);
	//	usersInfo.setUserCount(upiSet.size());
    //
	//	return usersInfo;
	//	
	//}
	
}
