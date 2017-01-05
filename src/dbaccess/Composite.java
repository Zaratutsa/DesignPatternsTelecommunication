package dbaccess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite implements Component, Iterator<Component> {
	List<Component> components = new ArrayList<Component>();
	int currentIndex = 0;

	@Override
	public String data() {
		String results = "";
		for (Component component : components) {
			results += "<html><br>" + component.data();
		}
		return results;
	}

	public void add(Component component) {
		components.add(component);
	}

	public void remove(Component component) {
		components.remove(component);
	}

	public List<Component> getComponents() {
		return components;
	}

	public Component getComponent(int index) {
		return components.get(index);
	}

	@Override
	public boolean hasNext() {
		if (currentIndex >= components.size()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Component next() {
		return components.get(currentIndex++);
	}

	@Override
	public void remove() {
		components.remove(--currentIndex);
	}
}