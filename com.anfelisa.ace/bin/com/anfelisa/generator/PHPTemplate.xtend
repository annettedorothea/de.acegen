package com.anfelisa.generator

import com.anfelisa.ace.Action
import com.anfelisa.ace.View
import com.anfelisa.extensions.ActionExtension
import com.anfelisa.extensions.CommandExtension
import com.anfelisa.extensions.EventExtension
import com.anfelisa.extensions.ViewExtension
import javax.inject.Inject
import com.anfelisa.ace.Project
import com.anfelisa.ace.Event
import com.anfelisa.ace.Command

class PHPTemplate {
	@Inject
	extension ActionExtension

	@Inject
	extension CommandExtension

	@Inject
	extension EventExtension
	
	@Inject
	extension ViewExtension
	
	def generateAbstractActionFile(Action it, Project project) '''
		<?php
		
		class «abstractActionName» {
		    
		    public $actionName;
		    public $actionParam;
		    public $actionData;
		    
		    function __construct($actionParam) {
		        $this->actionParam = $actionParam;
		        $this->actionName = "«actionName»";
		        $this->actionData = [];
		    }

		    function getCommand() {
		        return new «command.commandName»($this->actionData);
		    }
		    
			function apply() {
		        $actionId = getIdForAction($this->actionParam["uuid"]);
		        if (!$actionId) {
			        $this->initActionDataFromView();
		            saveAction($this, $this->actionParam["uuid"]);
		            $command = $this->getCommand();
		            if ($command != null) {
		                $command->execute();
		                $command->publishEvents();
		            }
		        } else {
		            if (databaseResetNeeded($actionId)) {
		                resetDatabase();
		            }
		            replayToAction($actionId);
		            replayAction($actionId);
		        }
			}
		
			function replayAsPrepare() {
		        $command = $this->getCommand();
		        if ($command != null) {
		            $command->execute();
		        }
		    }
		
			function replay() {
		        $command = $this->getCommand();
		        if ($command != null) {
		            $command->execute();
		            $command->publishEvents();
		        }
		    }
		    
		}
		
		/*       S.D.G.       */
	'''

	def generateAbstractCommandFile(Command it, Project project) '''
		<?php

		class «abstractCommandName» {
		
			«FOR eventOnOutcome : eventsOnOutcome»
				const «eventOnOutcome.outcome» = "«eventOnOutcome.outcome»";
			«ENDFOR»

			protected $commandName;
			protected $commandParam;
			protected $commandData;
		
		    function __construct($commandParam) {
				$this->commandParam = $commandParam;
				$this->commandName = "«commandName»";
				$this->commandData = [];
		    }
		
		    function publishEvents() {
		        switch ($this->commandData["outcome"]) {
					«FOR eventOnOutcome : eventsOnOutcome»
						case self::«eventOnOutcome.outcome»:
							«FOR event : eventOnOutcome.events»
								«FOR listenerFunction : event.listeners»
									«(listenerFunction.eContainer as View).viewName»::«listenerFunction.name»(new «event.eventName»($this->commandData));
								«ENDFOR»
							«ENDFOR»
							break;
					«ENDFOR»
		        }
		    }
		
		}
		
		/*       S.D.G.       */
	'''

	def generateEventFile(Event it, Project project) '''
		<?php

		class «eventName» {
		
			public $eventName;
			public $eventData;
		
		    function __construct($eventParam) {
				$this->eventData = $eventParam;
				$this->eventName = "«eventName»";
		        
		    }
		
		}		
		
		/*       S.D.G.       */
	'''

	def generateInitialActionFile(Action it, Project project) '''
		<?php
		
		class «actionName» extends «abstractActionName» {
		    function initActionDataFromView() {
		        $this->actionData = $this->actionParam;
		    }
		}
	'''
	
	def generateInitialCommandFile(Command it, Project project) '''
		<?php
		
		class «commandName» extends «abstractCommandName» {
		
		    function execute() {
		    }
		}
		
		/*       S.D.G.       */
	'''
	
	def generateInitialFile(Action it, Project project) '''
		<?php

		spl_autoload_register('abstractActionsLoader');
		spl_autoload_register('abstractCommandsLoader');
		spl_autoload_register('eventsLoader');
		spl_autoload_register('actionsLoader');
		spl_autoload_register('commandsLoader');
		spl_autoload_register('viewsLoader');
		
		include_once getcwd() . '/dbConfig.php';
		include_once getcwd() . '/Timeline.php';
		
		function abstractActionsLoader($className) {
		    $path = '../gen/«project.name»/actions/';
		    include $path.$className.'.php';
		}
		function abstractCommandsLoader($className) {
		    $path = '../gen/«project.name»/commands/';
		    include $path.$className.'.php';
		}
		function eventsLoader($className) {
		    $path = '../gen/«project.name»/events/';
		    include $path.$className.'.php';
		}
		function actionsLoader($className) {
		    $path = 'actions/';
		    include $path.$className.'.php';
		}
		function commandsLoader($className) {
		    $path = 'commands/';
		    include $path.$className.'.php';
		}
		function viewsLoader($className) {
		    $path = 'views/';
		    include $path.$className.'.php';
		}
		
		$dbconn = pg_connect ( "host=" . getDbServer () . " dbname=" . getDbDatabase() . " user=" . getDbUser() . " password=" . getDbPassword() ) or die ( 'Error connecting to database: ' . pg_last_error () );
		
		(new «actionName»(array_merge($_GET, $_POST)))->apply();
		
		pg_close($dbconn);
		
		/*       S.D.G.       */
	'''
	
	def generateView(View it) '''
		<?php
		
		class «viewName» {
			
		    «FOR renderFunction : renderFunctions»
		    	public static function «renderFunction.name»($event) {
		    	}
		    	
		    «ENDFOR»
		}	
		
		/*                    S.D.G.                    */
	'''

	
}