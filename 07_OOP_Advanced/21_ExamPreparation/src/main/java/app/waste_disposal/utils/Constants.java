package app.waste_disposal.utils;

public class Constants {
	
	public final static String RECYCLABLE_STRATEGY_TYPE = "Recyclable";
	public final static String BURNABLE_STRATEGY_TYPE = "Burnable";
	public final static String STORABLE_STRATEGY_TYPE = "Storable";
	
	public final static String WASTE_FORMAT = "%.2f kg of %s successfully processed!";
	public final static String STATUS_FORMAT = "Energy: %.2f Capital: %.2f";
	
	public static final Object TERMINATION_COMMAND = "TimeToRecycle";
	public static final String PROCESS_GARBAGE_COMMAND = "ProcessGarbage";
	public static final String STATUS_COMMAND = "Status";
	public static final String CHANGE_MANAGEMENT_REQUIREMENTS_COMMAND = "ChangeManagementRequirement";
	
	public static final String CHANGE_MANAGEMENT_REQUIREMENTS_MSG = "Management requirement changed!";
	public static final String PROCESSING_DENIED_MSG = "Processing Denied!";

}
