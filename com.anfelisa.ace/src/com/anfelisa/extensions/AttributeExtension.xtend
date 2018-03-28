package com.anfelisa.extensions

import com.anfelisa.ace.Attribute
import javax.inject.Inject
import com.anfelisa.ace.PrimitiveAttribute

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
	
	def String param(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.param;
		}	
		if (complexAttribute !== null) {
			return complexAttribute.param;
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
	
	def String getter(Attribute it) {
		if (primitiveAttribute !== null) {
			return primitiveAttribute.getter;
		}	
		if (complexAttribute !== null) {
			return complexAttribute.getter;
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