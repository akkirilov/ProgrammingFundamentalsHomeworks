package p10_InfernoInfinity.controllers;

import java.util.ArrayList;
import java.util.List;

import p10_InfernoInfinity.entities.Weapon;
import p10_InfernoInfinity.enums.Gem;
import p10_InfernoInfinity.factories.GemFactory;
import p10_InfernoInfinity.factories.WeaponFactory;

public class InfernoController {
	
	private List<Weapon> weapons;
	
	public InfernoController() {
		this.weapons = new ArrayList<>();
	}

	public void create(String weaponType, String weaponName){
		Weapon weapon = WeaponFactory.create(weaponType, weaponName);
		if (weapon == null || weapons.contains(weapon)) {
			return;
		}
		weapons.add(weapon);
	}
	
	public void add(String weaponName, int index, String gemName){
		Gem gem = GemFactory.create(gemName);
		if (gem == null) {
			return;
		}
		for (Weapon w : weapons) {
			if (w.getName().equals(weaponName)) {
				if (index >= 0 && index < w.getNumberOfSockets()) {
					w.addGem(index, gem);
				}
				break;
			}
		}
	}
	
	public void remove(String weaponName, int socketIndex) {
		for (Weapon w : weapons) {
			if (w.getName().equals(weaponName)) {
				if (socketIndex >= 0 && socketIndex < w.getNumberOfSockets()) {
					w.removeGem(socketIndex);
				}
				break;
			}
		}
	}
	
	public void print(String weaponName) {
		for (Weapon w : weapons) {
			if (w.getName().equals(weaponName)) {
				System.out.println(w);
				break;
			}
		}
	}
	
	public void compareWeapons(String weaponOneName, String weaponTwoName) {
		Weapon weaponOne = getWeaponByName(weaponOneName);
		Weapon weaponTwo = getWeaponByName(weaponTwoName);
		if (weaponOne == null || weaponTwo == null) {
			return;
		}
		if (weaponOne.compareTo(weaponTwo) > 0) {
			System.out.println(weaponTwo.additionalPrint());
		} else {
			System.out.println(weaponOne.additionalPrint());
		}
	}
	
	private Weapon getWeaponByName(String weaponName) {
		for (Weapon w : weapons) {
			if (w.getName().equals(weaponName)) {
				return w;
			}
		}
		return null;
	}

}
