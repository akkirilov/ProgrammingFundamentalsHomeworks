package health.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import health.entities.cells.Cell;

public class Cluster {
	
	private String id;
	private int rows;
	private int cols;
	private List<Cell> cells;
	
	public Cluster(String id, int rows, int cols) {
		this.id = id;
		this.rows = rows;
		this.cols = cols;
		this.cells = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public List<Cell> getCells() {
		return Collections.unmodifiableList(this.cells);
	}

	public boolean addCell(Cell cell) {
		if (cell.getPositionRow() < 0 || cell.getPositionRow() > this.rows 
				|| cell.getPositionCol() < 0 || cell.getPositionCol() > this.cols) {
			return false;
		}
		this.cells.add(cell);
		return true;
	}
	
	private void sortCells() {
		this.cells = this.cells.stream()
				.sorted((a, b) -> {
					int res = Integer.compare(a.getPositionRow(), b.getPositionRow());
					if (res == 0) {
						res = Integer.compare(a.getPositionCol(), b.getPositionCol());
					}
					
					return res;
				})
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("----Cluster ");
		sb.append(this.getId()).append("\r\n");
		sortCells();
		for (Cell c : this.cells) {
			sb.append(c).append("\r\n");
		}
		
		return sb.toString();
	}
	
	public Cell activateBloodCell(Cell cell) {
		for (int i = 0; i < this.cells.size(); i++) {
			cell.addHealth(this.cells.get(i).getHealth());
			cell.setNewPositions(this.cells.get(i));
		}
		return cell;
	}
	
	public Cell activateMicrobeCell(Cell cell) {
		for (int i = 0; i < this.cells.size(); i++) {
			int count = 2;
			while(true) {
				if (count % 2 == 0) {
					this.cells.get(i).reduceHealth(cell.getEnergy());
					if (this.cells.get(i).getHealth() <= 0) {
						cell.setNewPositions(this.cells.get(i));
						this.cells.remove(i);
						i--;
						break;
					}
				} else {
					cell.reduceHealth(this.cells.get(i).getEnergy());
					if (cell.getHealth() <= 0) {
						cell = this.cells.get(i);
						String type = cell.getClass().getSimpleName();
						this.cells.remove(i);
						i--;
						if (type.equals("WhiteBloodCell") || type.equals("RedBloodCell")) {
							activateBloodCell(cell);
						}
						break;
					}
				}
				count++;
			}
		
		}
		return cell;
	}

	public boolean activate() {
		if (this.cells.size() < 1) {
			return false;
		} else if (this.cells.size() == 1) {
			return true;
		}
		
		sortCells();
		Cell cell = this.cells.remove(0);
		
		String type = cell.getClass().getSimpleName();
		if (type.equals("WhiteBloodCell") || type.equals("RedBloodCell")) {
			cell = activateBloodCell(cell);
		} else {
			cell = activateMicrobeCell(cell);
		}
		
		this.cells.clear();
		this.cells.add(cell);
		return true;
	
	}
	

}
