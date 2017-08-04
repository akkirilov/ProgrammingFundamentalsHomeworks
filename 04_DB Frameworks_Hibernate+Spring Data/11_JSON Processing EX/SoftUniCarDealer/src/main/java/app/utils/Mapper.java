package app.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import app.entities.Customer;
import app.entities.Part;
import app.entities.Sale;
import app.entities.Supplier;
import app.models.CarBasicDto;
import app.models.customers.CustomerStatisticDto;
import app.models.sales.SaleWithDiscountDto;
import app.models.suppliers.SupplierWithPartsCountDto;

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
	
	public static List<SupplierWithPartsCountDto> mapToSupplierWithParts(List<Supplier> source) {
		List<SupplierWithPartsCountDto> resultSet = new ArrayList<>();
		
		ModelMapper mp = new ModelMapper();
		PropertyMap<Supplier, SupplierWithPartsCountDto> propertyMap = new PropertyMap<Supplier, SupplierWithPartsCountDto>() {
		     protected void configure() {
		    	 map().setPartsCount(source.getPartsCount());
		     }
		   };
		mp.addMappings(propertyMap);
		
		for (Supplier s : source) {
			resultSet.add(mapOne(s, SupplierWithPartsCountDto.class));
		}
		return resultSet;
	}
	
	public static List<CustomerStatisticDto> mapCustomerStatisticDto(List<Customer> source) {
		List<CustomerStatisticDto> resultSet = new ArrayList<>();
		BigDecimal sum;
		for (Customer c : source) {
			CustomerStatisticDto temp = new CustomerStatisticDto();
			temp.setFullName(c.getName());
			temp.setBoughtCars(c.getSales().size());
			sum = BigDecimal.ZERO;
			for (Sale s : c.getSales()) {
				for (Part p : s.getCar().getParts()) {
					sum = sum.add(p.getPrice());
				}
			}
			temp.setSpentMoney(sum);
			resultSet.add(temp);
		}
		
		resultSet = resultSet
				.stream()
				.filter(x -> x.getBoughtCars() > 0)
				.sorted((a, b) -> {
					int res = b.getSpentMoney().compareTo(a.getSpentMoney());
					if (res == 0) {
						res = Integer.compare(b.getBoughtCars(), a.getBoughtCars());
					}
					return res;
				})
				.collect(Collectors.toList());
		return resultSet;
	}

	public static List<SaleWithDiscountDto> mapSaleWithDiscountDto(List<Sale> sales) {
		List<SaleWithDiscountDto> resultList= new ArrayList<>();
		BigDecimal sum;
		for (Sale s : sales) {
			sum = BigDecimal.ZERO;
			SaleWithDiscountDto tempSale = new SaleWithDiscountDto();
			CarBasicDto tempCar = new CarBasicDto();
			tempCar.setMake(s.getCar().getMake());
			tempCar.setModel(s.getCar().getModel());
			tempCar.setTravelledDistance(s.getCar().getTravelledDistance());
			tempSale.setCar(tempCar);
			tempSale.setCustomerName(s.getCustomer().getName());
			for (Part p : s.getCar().getParts()) {
				sum = sum.add(p.getPrice());
			}
			tempSale.setPrice(sum);
			tempSale.setDiscount(s.getDiscount().intValueExact() + "%");
			tempSale.setPriceWithDiscount(sum.subtract(sum.multiply(s.getDiscount().multiply(new BigDecimal("0.01")))));
			resultList.add(tempSale);	
		}
		
		return resultList;
	}
	
}
