package de.acegen.templates.es6

import de.acegen.aceGen.ClientScenario
import de.acegen.extensions.CommonExtension
import javax.inject.Inject

class Scenario {
	
	@Inject
	extension CommonExtension

	def generateScenarioUtils() '''
		«copyright»
		
		«sdg»
		
		
	'''

	def generateScenario(ClientScenario it) '''
		«copyright»
		
		context('«name»', () => {
		    beforeEach(() => {
		    	«FOR givenRef: givenRefs»
		    		// «givenRef.scenario.name»
		    	«ENDFOR»
		    	
		    	«IF whenBlock.uuid !== null»
		    		localStorage.setItem("uuid", "whenBlock.uuid")
		    	«ENDIF»
		        AppUtils.httpPut('/api/test/non-deterministic/system-time?uuid=9d0723a3&system-time=2020-07-07T16:30:21')
		        cy.visit('http://127.0.0.1:9999/')
		        cy.get('#newTodoInput').type('NEW')
		    })
		
		    it('should reset newTodo and reload todoList', () => {
		        const lastAppState = JSON.parse(localStorage.getItem('appState'));
		        cy.get('#newTodoInput').type(String.fromCharCode(13)).should(() => {
		            const appState = JSON.parse(localStorage.getItem('appState'));
		            expect(appState.newTodo, 'reset newTodo').to.eq('')
		            expect(appState.todoList.length).to.eq(lastAppState.todoList.length + 1)
		            expect(appState.todoList[appState.todoList.length - 1].description).to.eq('NEW')
		            expect(appState.todoList[appState.todoList.length - 1].done).to.eq(false)
		        })
		    })
		})
		
		
		«sdg»
		
		
	'''
}