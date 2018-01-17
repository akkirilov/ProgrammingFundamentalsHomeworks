package app.factory;

import java.lang.reflect.InvocationTargetException;

import app.contracts.Action;
import app.contracts.ActionFactory;
import app.models.actions.BossFight;
import app.models.actions.OneVsOne;

public class ActionFactoryImpl implements ActionFactory {

	@Override
	public Action create(String actionName, String... participantNames) throws ClassNotFoundException,
			IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		switch (actionName) {
		case "OneVsOne":
			return new OneVsOne();
		case "BossFight":
			return new BossFight();
		default:
			return null;
		}
	}
	

}
