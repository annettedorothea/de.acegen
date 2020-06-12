package de.acegen.templates.java.models

import de.acegen.aceGen.HttpServer
import de.acegen.extensions.java.AttributeExtension
import de.acegen.extensions.java.ModelExtension
import javax.inject.Inject

class Liquibase {
	
	@Inject
	extension ModelExtension
	
	@Inject
	extension AttributeExtension
	
	def generateMigration(de.acegen.aceGen.Model it, HttpServer httpServer) '''
		<createTable tableName="«name.toLowerCase»">
			«FOR attribute : attributes»
				<column name="«attribute.name.toLowerCase»" type="«attribute.sqlType»">
					<constraints «IF attribute.isPrimaryKey»primaryKey="true"«ENDIF» «IF attribute.notNull»nullable="false"«ENDIF» «IF attribute.foreignKey !== null» references="«attribute.foreignKey.tableName»(«attribute.foreignKey.name.toLowerCase»)" deleteCascade="true" foreignKeyName="fk_«table»_«attribute.foreignKey.name.toLowerCase»"«ENDIF» />
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
		
		<addUniqueConstraint columnNames="type, uuid" tableName="timeline" />
		
	'''

	
}