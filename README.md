__If the iron is blunt, and one does not sharpen the edge, he must use more strength, but wisdom helps one to succeed.__

_King Solomon, Book of Ecclesiastes 10,10_

# de.acegen

_DSL (Domain Specific Language) and code generator implemented with Xtext based on [the ACE-architecture](#The-ACE-Architecture)_

This tool helps you to write web APIs and web clients and can be plugged into Eclipse.

# The Action - Command - Event Pattern

The action-command-event pattern is a simple pattern for 

* [separating read and write operations](#action)
* [simplifying tests on all levels](#Automated Testing)
* [writing and replaying a timeline](#The replay mechanism)

It can be used anywhere. Here are examples for the usage in a REST API

* [TodoMVC-Server](https://github.com/annettedorothea/TodoMVC---Server)
* [SuperMemo App Server](https://github.com/annettedorothea/com.anfelisa.server)

and in the UI of a web client

* [TodoMVC-Client](https://github.com/annettedorothea/TodoMVC---Client)
* [SuperMemo App Client](https://github.com/annettedorothea/com.anfelisa.client).

It consists of three steps that are executed sequentially:

* [Action](#action)
* [Command](#command)
* [Event](#event)

In these three steps you pass data from one to the other and process it.

So what are these three steps for?

## Action

We have to distinguish two types of actions:

1. ReadAction
2. WriteAction

### Read Action

A read action has no side effects and just reads the current state of the application and returns data. If the action is done there will be no command or event.

### Write Action

A write action is always followed by a command and one or more events. As the command contains the business logic to perform the desired side effect the action just serves to prepare it by initializing the *squishy* data. **Squishy data**?!? What's that?!?

#### Squishy Data

I admit squishy data is a rather weird category of data but just try to follow along. Squishy is everything that makes programming complex and unpredictable. Consider a function that always returns the same result no matter when or why or under whatever circumstance it is executed. It is like 2+2=4. Simple and predictable.

On the other hand if a functions returns 2 on Monday and 3 on Tuesday and 5 if an admin executes it for the same input there is squishy data involved. This is complex and unpredictable. So you know what I mean? And because life is complex and we can't get rid of complex stuff in our software we need so do something in order to tame this beast.

#### What data is *squishy*?

* Time. Time is always squishy and makes programming (and even life) hard.
* Tokens are squishy.
* Any random value.

#### Why do we initialize *squishy* data before we execute the business logic?

There are two benefits if you start to put data in either the category *squishy* or not.

1. It creates awareness of the complexity to be expected in the software.
2. We do that in order to simplify our tests:
   * Writing unit testing will be easier because one specific input has to result in only one outcome.
   * Integration and E2E tests are challenging and fragile because ot the *squishy* data. But you can master it by finding a way to bypass the *squishy* data to the action and initialize it with specific test data so you can predict the outcome of the test.

## Command

The command contains the core of your application: the business logic. It is only limited by the fact that it must not cause any side effect but is only allowed to read the current state of your application. So what the command basically does is collect data, validate it and prepare the desired side effects.

A command has one or more outcomes that result in events that will be fired.

## Event

The event contains the prepared data and will be consumed by one or more listeners or views that will perform the desired side effect. You can distinguish between side effects that are executed in a transaction or outside a transaction if a database is involved, just what best fits the scenario.

An event is absolutely forbidden to change the data it receives!

For the event contains all data to cause the desired side effect you can store it in a timeline and replay it afterwards for example to find a bug, to rebuild the state of the application or to prepare migrations.

The [TodoMVC example](https://todo.acegen.de) provides a way to see the [replay](https://github.com/annettedorothea/TodoMVC---Client#replay) mechanism on the client.

---

# TodoMVC app as example

* [Server](https://github.com/annettedorothea/TodoMVC---Server)
* [Client](https://github.com/annettedorothea/TodoMVC---Client)


## The REST API

### POST, PUT and DELETE as WriteActions

In case of a REST API you have the resource or controller that receives the incoming request. Here you create the appropriate action and the data object that is going to be passed the action-command-event chain:

[CreateTodoResource.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/gen/java/com/anfelisa/todo/resources/CreateTodoResource.java)

The WriteAction superclass looks like this:

[WriteAction.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/gen/java/de/acegen/WriteAction.java)

There you can see that 

* a transaction is opened
* the system time and 
* the squishy data is initialized
* in case you are running in DEV mode squishy data gets overwritten (this is the bypassing of test data)
* the command is called 
* the events are published
* the transaction is commited
* the events that should run outside the transaction are published
* data is returned

This is the corresponding command:

[CreateTodoCommand.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/main/java/com/anfelisa/todo/commands/CreateTodoCommand.java)

[AbstractCreateTodoCommand.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/gen/java/com/anfelisa/todo/commands/AbstractCreateTodoCommand.java)

And in this view you find the listeners that react on the published events:

[TodoView.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/main/java/com/anfelisa/todo/views/TodoView.java)

### GET as ReadAction

The read action is rather simple:

[GetAllTodosAction.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/main/java/com/anfelisa/todo/actions/GetAllTodosAction.java)

[ReadAction.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/gen/java/de/acegen/ReadAction.java)

## The Single Page Application of the TodoMVC example

If you are using this pattern in an UI that is connected to a REST API there are some things to consider:

* the client's view is not a database but a thin presentational layer of the current app's state
* there are no read actions because the user 'reads' the current app state and not the app itself
* you need 
  * synchronous actions when the user is just changing the UI and
  * asynchronous actions when a server call is performed
* in case of an asynchronous action you might want to display a loading indicator and a shortcut for doing so might be a good idea
* you might want to create sequences of actions, so when one action is finished you want to trigger a second one based on the outcome
* in your E2E tests you need to bypass values to the client application and to the server API

Here are the base classes:

[base classes](https://github.com/annettedorothea/TodoMVC---Client/tree/master/es6/gen/ace)

The commands and actions are located here:

* [hand written](https://github.com/annettedorothea/TodoMVC---Client/tree/master/es6/src/todo)
* [generated](https://github.com/annettedorothea/TodoMVC---Client/tree/master/es6/gen/todo)

Here are the components of the thin and logic free presentational layer:

[presentational layer](https://github.com/annettedorothea/TodoMVC---Client/tree/master/es6/src/components)

---

# Additional Notes

## DSL and code generator

There is a code generator based on Xtext that helps to write the boilerplate code that is needed for the action - command - event pattern:

https://github.com/annettedorothea/de.acegen

All files that are located in a gen folder are generated files in the above examples.

These are the corresponding DSL file: 

* [TodoMVC server DSL file](https://github.com/annettedorothea/TodoMVC---Server/blob/master/todo-server.ace)
* [TodoMVC client DSL file](https://github.com/annettedorothea/TodoMVC---Client/blob/master/todo-client.ace)

Here you can find the scenario DSL files for 

* [TodoMVC integration tests](https://github.com/annettedorothea/TodoMVC---Server/tree/master/todo-server)
* [TodoMVC E2E tests](https://github.com/annettedorothea/TodoMVC---Client/tree/master/scenarios)

## SuperMemo app as a PoC

Check out a more complex implementation of a SuperMemo app:

* [SuperMemo server](https://github.com/annettedorothea/com.anfelisa.server)
* [SuperMemo client](https://github.com/annettedorothea/com.anfelisa.client)

## The replay mechanism

### Bug fixing

You can see the replay mechanism on the client if you follow the instructions on the bottom left in the [TodoMVC example](https://todo.acegen.de). It may serve you as a way to find and fix bugs because you do not have to guess what the user did when he encoutnered the bug but you **know** what was going on.

### Migrations

As you can replay the events on a server you can rebuild the state of the application with a changed data model. For example: If one of your select statements to query complex data with many joins gets really slow when the amount of data rises you might want to create a table that contains all data you need for the query in a way that is optimized for reading. You can fill this table by replaying all events. But you have to be aware of the fact that changing the structure of your events will make the attempt to always have a replayable timeline rather hard because you will have to migrate the events. So if you are live already and you have to make structural changes to your system you might want to give up the ability to replay the timeline on the server.

## Automated Testing

When we write unit tests we are always in the tension of testing the behaviour and testing the implementation. And I think we cannot get rid of it, we have to live with it and be smart to avoid the pitfalls into which we can fall when writing automated tests.

So I would suggest that we need a mixture of unit tests, integration and E2E test and let me try to explain how this mixture should be composed and how the action - command - event pattern can help you writing your tests more efficiently:

### Unit Tests

I really love TDD. And writing unit tests with TDD for the *real* business logic in a software is fun. Writing unit tests with TDD for the UI is a pain, at least I think so.

On the other hand unit tests are really annoying when you do a structural refactoring of your software.

So there is the tension:

For unit tests are tied to a unit they are not receptive for structural changes. And the promise that you can make refactorings very easily if you have unit tests proves to be deceptive.

With the action - command - event pattern we only write unit tests for the commands because they contain the business logic. You also might want to write unit tests for the actions in order to verify that the squishy data was initialized correctly.

### Integration and E2E tests

For the bigger picture and to make sure our tests a not prone to fail on structural changes of your software we write integration and E2E tests and chose a more behavioural way for our tests.

The common problems with integration and E2E test as far as I perceive them is:

1. They are fragile because of the *squishy* data.
2. The preparation of the test data is hard to achieve.

#### Squishy Data

As we have seen in this pattern the solution for the *squishy' data is already included by initializing it in the action. The only thing you have to do is to find a way to bypass the squishy data to your application during the execution of the integration and E2E tests.

#### Prepare the test data

In order to prepare test data you simply could execute a sequence of events before the test is executed.

In the acegen DSL there is a BDD way to write integration and E2E scenarios based on the action - command - event pattern.

Just take a look at the scenarios found in these files:

* [TodoMVC integration tests](https://github.com/annettedorothea/TodoMVC---Server/tree/master/todo-server)
* [TodoMVC E2E tests](https://github.com/annettedorothea/TodoMVC---Client/tree/master/scenarios)
