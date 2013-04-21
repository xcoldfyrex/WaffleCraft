package com.cfdigital.wafflecraft.classes;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.jline.internal.Log;

public class SkillClass {
	public SkillClass (String className, List<?> classItems, int pointsRequired) {
		this.setPointsRequired(pointsRequired);
		int x = 0;
		while (x < classItems.size()) {
			Material material = Material.valueOf(classItems.get(x).toString()); 
			Log.warn(material);
			this.classItems.add(material);		
		}
	}
	
	public List<Material> getClassItems() {
		return classItems;
	}
	
	public int getPointsRequired() {
		return pointsRequired;
	}

	private void setPointsRequired(int pointsRequired) {
		this.pointsRequired = pointsRequired;
	}

	public String getClassName() {
		return className;
	}

	private List<Material> classItems;
	private int pointsRequired;
	private String className;
	
}