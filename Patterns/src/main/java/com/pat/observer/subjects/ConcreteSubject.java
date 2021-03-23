package com.pat.observer.subjects;

import java.util.ArrayList;
import java.util.List;

import com.pat.observer.interfaces.Observer;
import com.pat.observer.interfaces.Subject;

public class ConcreteSubject implements Subject {
	List<Observer> observers = new ArrayList<>();
	int values;
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nodtifyObservers() {
		// TODO Auto-generated method stub

	}

}
