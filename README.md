__If the iron is blunt, and one does not sharpen the edge, he must use more strength, but wisdom helps one to succeed.__

_King Solomon, Book of Ecclesiastes 10,10_

# de.acegen

_DSL (Domain Specific Language) and code generator implemented with Xtext based on [the ACE-architecture](#The-ACE-Architecture)_

This tool helps you to write web APIs and web clients and can be plugged into Eclipse, Theia and VS Code.
You will benefit from:

_(first link leeds to server sample, second to client)_

- [expressive](https://github.com/annettedorothea/TodoMVC---Server/blob/master/todo-server.ace) 
[DSL](https://github.com/annettedorothea/TodoMVC---Client/blob/master/todo-client.ace) 
that makes documentation obsolete
- a code generator writes [boilerplate](https://github.com/annettedorothea/TodoMVC---Server/tree/master/src/gen/java/com/anfelisa/todo) [code](https://github.com/annettedorothea/TodoMVC---Client/tree/master/es6/gen/todo) so you can focus on the business logic
- a simple but effective [software architecture](#The-ACE-Architecture)
- the business logic is located in 
[simple](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/main/java/com/anfelisa/todo/commands/CreateTodoCommand.java) 
[classes](https://github.com/annettedorothea/TodoMVC---Client/blob/master/es6/src/todo/commands/CreateTodoCommand.js)
and is free of any framework dependency
- you get a [replayable timeline](https://acegen.de/#/336ace6-a52f-11e8-98d0-529269fb1489/scenarios) 
that might save your day when finding or reproducing a bug
- [scenarios](https://github.com/annettedorothea/TodoMVC---Server/tree/master/src/test/java/com/anfelisa/todo/scenarios) 
that result in integration tests and can even serve as load tests

See [https://todo.acegen.de](https://todo.acegen.de) for a simple todoMVC example.

## Installation

You can get the latest Eclipse plugin from [http://acegen.de](http://acegen.de).

## Usage

Please take a look at [TodoMVC server sample](https://github.com/annettedorothea/TodoMVC---Server) 
and [TodoMVC client sample](https://github.com/annettedorothea/TodoMVC---Client).

## The ACE-Architecture

ACE is an architecture that allows you to write an executable timeline during the execution
of your application. ACE stands for Action - Command - Event:

- The action captures the user input.
- The command contains the business logic and fires events.
- The views listen to these events and update themselves accordingly.

### Web API

In the context of an Web API the action is your API endpoint. In case of a GET request 
the action selects the data for the answer from your persistence layer and returns it. If your 
endpoint is a change request (POST, PUT, DELETE) a command is executed.

The command can read from your persistence layer, validates data and decides which event to fire 
or returns an error.

The event is then transferred to your listeners which perform the data change in your persistence layer.

### UI

If you are in the context of an UI you can also apply this architeture. The action is triggered 
by an user interaction and captures the user input. 

The command is executed and performs validation and if need be a call to your API. According to
the outcome an event is fired.

The event results in a change of the UI state and a rerender will be performed. It is then possible
to trigger another action so that you can chain actions with one another.
      


