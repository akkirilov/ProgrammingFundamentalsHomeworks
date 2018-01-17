package app.factory;

import java.lang.reflect.InvocationTargetException;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.models.participants.Boss;
import app.models.participants.Necromancer;
import app.models.participants.Warrior;
import app.models.participants.Wizard;

public class TargetableFactoryImpl implements TargetableFactory {

	@Override
	public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException,
			InstantiationException, NoSuchMethodException, InvocationTargetException {
		Targetable target = null;
		switch (className) {
		case "Warrior":
			target = new Warrior();
			target.setName(name);
			break;
		case "Wizard":
			target = new Wizard();
			target.setName(name);
			break;
		case "Necromancer":
			target = new Necromancer();
			target.setName(name);
			break;
		case "Boss":
			target = new Boss();
			target.setName(name);
			break;
		default:
			break;
		}
		
		return target;
	}

}
