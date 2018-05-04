package com.practice.lambda.unit1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaComparator {

	public static void main(String args[]){
		List<PersonBean> personList = new ArrayList<PersonBean>();
		
		Collections.sort(personList, new Comparator<PersonBean>() {

			@Override
			public int compare(PersonBean p1, PersonBean p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
			
		});
		
		// Equivalent Lambda
		Collections.sort(personList, (PersonBean p1, PersonBean p2) -> p1.getLastName().compareTo(p2.getLastName()));
		//(or)
		Collections.sort(personList, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
	}
}
