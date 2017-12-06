package health.factories;

import health.entities.cells.Cell;
import health.entities.cells.bloodCells.*;
import health.entities.cells.microbes.*;

public class CellFactory {

	public static Cell create(String cellType, String id, int health, int positionRow, int positionCol, int additionalProperty) {
		switch (cellType) {
		case "RedBloodCell":
			return new RedBloodCell(id, health, positionRow, positionCol, additionalProperty);
		case "WhiteBloodCell":
			return new WhiteBloodCell(id, health, positionRow, positionCol, additionalProperty);
		case "Bacteria":
			return new Bacteria(id, health, positionRow, positionCol, additionalProperty);
		case "Fungi":
			return new Fungi(id, health, positionRow, positionCol, additionalProperty);
		case "Virus":
			return new Virus(id, health, positionRow, positionCol, additionalProperty);
		default:
			return null;
		}
		
	}
	
}
