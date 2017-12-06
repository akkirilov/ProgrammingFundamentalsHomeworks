package health.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Organism {

	private String name;
	private List<Cluster> clusters;
	
	public Organism(String name) {
		this.name = name;
		this.clusters = new ArrayList<>();
	}

	public void addClusters(Cluster cluster) {
		this.clusters.add(cluster);
	}

	@Override
	public String toString() {
		long totalCells = this.getTotalCells();
		StringBuilder sb = new StringBuilder("Organism - ");
		sb.append(this.name).append("\r\n");
		sb.append("--Clusters: ").append(this.clusters.size()).append("\r\n");
		sb.append("--Cells: ").append(totalCells);
		sb.append("\r\n");
		for (Cluster c : clusters) {
			sb.append(c);
		}
		return sb.toString();
		
	}

	private long getTotalCells() {
		long res = 0L;
		for (Cluster c : clusters) {
			res += c.getCells().size();
		}
		return res;
	}

	public int getCellCountFromCluster(String clusterId) {
		for (Cluster c : clusters) {
			if (c.getId().equals(clusterId)) {
				return c.getCells().size();
			}
		}
		return 0;
	}
	
	public List<Cluster> getClusters() {
		return Collections.unmodifiableList(clusters);
	}

	public String activateNextCluster() {
		if (this.clusters.size() == 0) {
			return null;
		}
		
		Cluster cluster = this.clusters.remove(0);
		this.addClusters(cluster);
		if (!cluster.activate()) {
			return null;
		}
		
		return cluster.getId();
	}

}
