package org.kagelabs.hydrogen;

import java.util.ArrayList;

/**
 * A storage class for a bundle of directives
 * @author Patrick Kage
 * @author Caleb
 *
 */
public class DirectiveBundle {
	private ArrayList<Directive> bundle;
	
	DirectiveBundle() {
		bundle = new ArrayList<Directive>();
	}
	
	public void add(Directive dir) {
		bundle.add(dir);
	}
	
	public Directive get(int index) {
		if (bundle.size() <= index) return new Directive();
		return bundle.get(index);
	}
	
	public boolean replace(int index, Directive dir) {
		if (bundle.size() <= index) return false;
		bundle.set(index, dir);
		return true;
	}
	
	public int getSize() {
		return bundle.size();
	}
	
	
}
