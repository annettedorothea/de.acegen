# de.acegen

Ecclesiates 10,10
When the iron...
King Salomo, ???? a.D.

DSL (Domain Specific Language) and code generator implemented with Xtext based on the ACE-architecture.

This tool helps you to write web-APIs and web-clients and can be plugged into Eclipse, Theia and VS Code.
You will benefit from:

- expressive DSL that makes documentation obsolete
- a code generator will write all boilerplate code so you can focus on the business logic
- a simple but very effective software architecture
- your precious business logic as the heart of your application is located in simple classes and is free of any dependency to a framework
- you will get a replayable timeline that might save your day when finding or reproducing a bug
- scenarios that result in executable integration tests and can even serve you as load tests (only for the web-API, for the UI we are still working on it)
- write less but simple unit tests 

See [https://todo.acegen.de](https://todo.acegen.de) for a simple todoMVC example.

## Installation

You can get the latest Eclipse plugin from [http://acegen.de](http://acegen.de).

## Usage

Please take a look at [TodoMVC server sample](https://github.com/annettedorothea/TodoMVC---Server) 
and [TodoMVC client sample](https://github.com/annettedorothea/TodoMVC---Client).

### Web API

First you need to create an .ace file and open it in latest Eclipse where you have previously installed the [plugin](http://acegen.de).

Then add this to the .ace file:

```
HttpServer Java Dropwizard JDBI3 Liquibase
com.anfelisa.todo 
```

This will result in a Web API in Java based in Dropwizard as http framework using JDBI3 as ??? and Liquibase for the database migrations.

The next line is the package for your code.

Then you can add your endpoints:

```
ACE
	GetAllTodos<TodoList> 
		GET "/todos/all"
		response todoList
	
	GetTodo<Todo> 
		GET "/todos/{id}"
			pathParams id
		response 
			id
			description
			createdDateTime
			done
			updatedDateTime
	
	CreateTodo<Todo>
		POST "/todos/create"
		payload description
		response 
			id
			createdDateTime
			description
		on success (Todo.create) 
```

