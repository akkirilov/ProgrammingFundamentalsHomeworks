package p03_05_BarracksWars.core.factories;

import p03_05_BarracksWars.contracts.Unit;
import p03_05_BarracksWars.contracts.UnitFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"p03_05_BarracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		// TODO: implement for problem 3
		throw new NotImplementedException();
	}
}
