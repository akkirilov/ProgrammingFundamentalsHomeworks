package health.controllers;

import java.util.HashMap;
import java.util.Map;

import health.entities.Cluster;
import health.entities.Organism;
import health.factories.CellFactory;

public class HealthManager {

	private Map<String, Organism> organisms;

	public HealthManager() {
		this.organisms = new HashMap<>();
	}

	public String checkCondition(String organismName) {
		if (!organisms.containsKey(organismName)) {
			return null;
		}
		
		return organisms.get(organismName).toString();
	}

	public String createOrganism(String name) {
		if (organisms.containsKey(name)) {
			return String.format("Organism %s already exists", name);
		}
		
		organisms.put(name, new Organism(name));
		return String.format("Created organism %s", name);
	}

	public String addCluster(String organismName, String id, int rows, int cols) {
		if (!organisms.containsKey(organismName)) {
			return null;
		}

		for (Cluster c : organisms.get(organismName).getClusters()) {
			if (c.getId().equals(id)) {
				return null;
			}
		}

		organisms.get(organismName).addClusters(new Cluster(id, rows, cols));

		return String.format("Organism %s: Created cluster %s", organismName, id);
	}

	public String addCell(String organismName, String clusterId, String cellType, String cellId, int health,
			int positionRow, int positionCol, int additionalProperty) {
		if (!organisms.containsKey(organismName)) {
			return null;
		}
		for (Cluster c : organisms.get(organismName).getClusters()) {
			if (c.getId().equals(clusterId)) {
				if (c.addCell(CellFactory.create(cellType, cellId, health, positionRow, positionCol, additionalProperty))) {
					return String.format("Organism %s: Created cell %s in cluster %s", organismName, cellId, clusterId);
				} else {
					return null;
				}
			}
		}
		return null;
	}

	public String activateCluster(String organismName) {
		if (!organisms.containsKey(organismName)) {
			return null;
		}
		
		String clusterId = organisms.get(organismName).activateNextCluster();
		if (clusterId == null) {
			return null;
		}
		
		int cellsLeft = organisms.get(organismName).getCellCountFromCluster(clusterId);
		
		return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName, clusterId, cellsLeft);
	}
}
