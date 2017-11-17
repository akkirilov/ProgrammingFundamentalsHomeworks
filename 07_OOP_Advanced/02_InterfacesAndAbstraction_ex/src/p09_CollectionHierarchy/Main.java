package p09_CollectionHierarchy;

import java.util.Scanner;

import p09_CollectionHierarchy.collections.addCollections.*;
import p09_CollectionHierarchy.collections.addRemoveCollections.*;
import p09_CollectionHierarchy.collections.myLists.*;

public class Main {

	public static void main(String[] args) {
		
		AddCollection addCollection = new AddCollectionImpl();
		AddRemoveCollection addRemoveCollection = new AddRemoveCollectionImpl();
		MyList myList = new MyListImpl();
		
		Scanner scanner = new Scanner(System.in);
		
		String[] tokens = scanner.nextLine().split("\\s+");
		int n = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < tokens.length; i++) {
			sb.append(addCollection.add(tokens[i])).append(" ");
		}
		sb.append(System.lineSeparator());
		
		for (int i = 0; i < tokens.length; i++) {
			sb.append(addRemoveCollection.add(tokens[i])).append(" ");
		}
		sb.append(System.lineSeparator());
		
		for (int i = 0; i < tokens.length; i++) {
			sb.append(myList.add(tokens[i])).append(" ");
		}
		sb.append(System.lineSeparator());

		for (int i = 0; i < n; i++) {
			sb.append(addRemoveCollection.remove()).append(" ");
		}
		sb.append(System.lineSeparator());
		
		for (int i = 0; i < n; i++) {
			sb.append(myList.remove()).append(" ");
		}
		sb.append(System.lineSeparator());
		
		System.out.print(sb.toString());
		
	}

}
