/********************************************************************************
 * Copyright (c) 2020 Annette Pohl
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/


package de.acegen.templates.java.models

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.EcoreExtension
import de.acegen.extensions.java.TypeExtension

class Liquibase {
	
	extension AttributeExtension
	
	extension TypeExtension
	
	extension EcoreExtension
	
	def generateMigration(de.acegen.aceGen.Model it, HttpServer httpServer) '''
		<createTable tableName="«tableName»">
			«FOR attribute : attributes»
				<column name="«attribute.propertyName»" type="«attribute.sqlType»">
					<constraints «IF attribute.isPrimaryKey»primaryKey="true"«ENDIF» «IF attribute.notNull»nullable="false"«ENDIF» «IF attribute.foreignKey !== null» references="«attribute.parent.tableName»(«attribute.foreignKey.propertyName»)" deleteCascade="true" foreignKeyName="fk_«tableName»_«attribute.foreignKey.propertyName»"«ENDIF» />
				</column>
			«ENDFOR»
		</createTable>
	'''
	
	def generateAceMigration() '''
		<createTable tableName="timeline">
			<column name="type" type="character varying">
				<constraints nullable="false" />
			</column>
			<column name="name" type="character varying">
				<constraints nullable="false" />
			</column>
			<column name="time" type="timestamp">
				<constraints nullable="false" />
			</column>
			<column name="data" type="text">
				<constraints nullable="false" />
			</column>
			<column name="uuid" type="character varying">
				<constraints nullable="false" />
			</column>
		</createTable>
		
	'''

	
}