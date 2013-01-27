package com.company.carrental.data.util;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class SimpleLogInterecptor extends EmptyInterceptor {

	@Override
	public boolean onLoad(Object entity, 
			Serializable id, 
			Object[] state,
			String[] propertyNames, 
			Type[] types) {
		
		System.out.println(
				"Loading "+entity.getClass().getName()
				+" Id: "+id+" No. of Props in State"+state.length
				+" No. of Properties "+propertyNames.length
				+" Types of Properties "+types.length);
		
		
		return super.onLoad(entity, id, state, propertyNames, types);
	}
}
