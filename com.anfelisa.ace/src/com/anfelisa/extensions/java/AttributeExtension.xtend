package com.anfelisa.extensions.java

import com.anfelisa.ace.Attribute
import com.anfelisa.ace.PrimitiveAttribute
import javax.inject.Inject

class AttributeExtension {

	@Inject
	extension PrimitiveAttributeExtension

	@Inject
	extension ComplexAttributeExtension

	def String name(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.name;
		}	
		if (complexAttribute !== null) {
			return complexAttribute.name;
		}
	}
	
	def String getterCall(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.getterCall;
		}	
	}
	
	def String type(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.type;
		}	
	}
	
	def String javaType(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.javaType;
		}	
		if (complexAttribute !== null) {
			return complexAttribute.javaType;
		}	
	}
	
	def String mapperInit(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.mapperInit;
		}	
		if (complexAttribute !== null) {
			return complexAttribute.mapperInit;
		}	
	}
	
	def String sqlType(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.sqlType;
		}	
	}
	
	def String constraint(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.constraint;
		}	
	}
	
	def String tableName(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.tableName;
		}	
	}
	
	def String declaration(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.declaration;
		}	
		if (complexAttribute !== null) {
			return complexAttribute.declaration;
		}	
	}
	
	def String param(Attribute it, boolean jsonProperty) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.param(jsonProperty);
		}	
		if (complexAttribute !== null) {
			return complexAttribute.param(jsonProperty);
		}	
	}
	
	def String interfaceGetter(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.interfaceGetter;
		}	
		if (complexAttribute !== null) {
			return complexAttribute.interfaceGetter;
		}	
	}
	
	def String assign(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.assign;
		}	
		if (complexAttribute !== null) {
			return complexAttribute.assign;
		}	
	}
	
	def String getter(Attribute it, boolean jsonProperty) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.getter(jsonProperty);
		}	
		if (complexAttribute !== null) {
			return complexAttribute.getter(jsonProperty);
		}	
	}
	
	def String setter(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.setter;
		}	
		if (complexAttribute !== null) {
			return complexAttribute.setter;
		}	
	}
	
	def String setterCall(Attribute it, String param) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.setterCall(param);
		}	
		if (complexAttribute !== null) {
			return complexAttribute.setterCall(param);
		}	
	}
	
	def String initializer(Attribute it, String dataName) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.initializer(dataName);
		}	
		if (complexAttribute !== null) {
			return complexAttribute.initializer(dataName);
		}	
	}
	
	def PrimitiveAttribute foreignKey(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.foreignKey;
		}	
	}
	
	def boolean isPrimaryKey(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.primaryKey;
		}
		return false;
	}
	
	def boolean isUnique(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.unique;
		}
		return false;
	}
	
}