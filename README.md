

***If the axe is dull and its edge unsharpened, more strength is needed, but skill will bring success.***

_King Solomon, Book of Ecclesiastes 10,10_

Acegen is a DSL (Domain Specific Language) and code generator implemented with Xtext based on the Action-Command-Event pattern and it helps you to write web APIs and web clients and can be plugged into Eclipse.

# Table Of Contents

* [The Action-Command-Event Pattern](#the-action---command---event-pattern)
  * [Action](#action)
  * [Command](#command)
  * [Event](#event)
* [TodoMVC App As Example](#todomvc-app-as-example)
  * [The REST API](#the-rest-api)
  * [The Single Page Application](#the-single-page-application)
* [Additional Notes](#additional-notes)
  * [DSL And Code Generator](#dsl-and-code-generator)
  * [SuperMemo App As PoC](#supermemo-app-as-poc) 
  * [The Replay Mechanism](#the-replay-mechanism) 
  * [A Word On Frameworks](#a-word-on-frameworks)
  * [Automated Testing](#automated-testing) 

# The Action-Command-Event Pattern

The Action-Command-Event pattern is a simple pattern for 

* [separating read-and-write operations](#action)
* [simplifying tests on all levels](#automated-testing)
* [writing and replaying a timeline](#the-replay-mechanism)

It can be used anywhere. Here are examples for the usage in a REST API

* [TodoMVC Server](https://github.com/annettedorothea/TodoMVC---Server)
* [SuperMemo App Server](https://github.com/annettedorothea/com.anfelisa.server)

and in the UI of a web client

* [TodoMVC Client](https://github.com/annettedorothea/TodoMVC---Client)
* [SuperMemo App Client](https://github.com/annettedorothea/com.anfelisa.client).

It consists of three steps that are executed sequentially:

* [Action](#action)
* [Command](#command)
* [Event](#event)

In these three steps you pass data from one step to the next and process it.

So what are these three steps for?

## Action

We have to distinguish two types of actions:

1. ReadAction
2. WriteAction

### Read Action

A read action has no side effects. It merely reads the current state of the application and returns the data. If the action is done, there will be no further command or event.

### Write Action

A write action is always followed by a command and one or more subsequent events. As the command contains the business logic to perform the desired side effect, the action merely serves to prepare this by initializing the *squishy* data. 

####  *Squishy data* - what is that?!?

I must admit that *squishy* data is a rather peculiar category of data, but please try to follow along anyway. *Squishy* is everything that makes programming complex and unpredictable. 

Consider a function that always returns the same result no matter when or why or under what circumstances it is executed. It is like 2+2=4. Simple and predictable.

On the other hand, if a function returns 2 on Monday and 3 on Tuesday and 5 if an admin executes it, there is *squishy* data involved. It is complex and unpredictable. Do you know what I mean? Because life is complex and we cannot get rid of complex requirements, we need to do something in order to tame this beast.

#### Examples for *squishy* data

* Time,
* Tokens and 
* Random values

#### Why should I distinguish *squishy* data from *normal* data?

There are basically two benefits:

1. It creates awareness of the complexity to be expected in the software.
2. If you initialize the *squishy* data separately, it will simplify your tests:
   * Writing unit testing will be easier because one specific input has to result in only one outcome.
   * Integration and E2E tests are challenging and fragile mainly because of *squishy* data. But you can master it by finding a way to bypass *squishy* data to the action and initialize it with specific test data, so you can predict the outcome of the test more accurately.

#### Is The State Of An Application Not *Squishy*, too?

Yes, in fact it is. Imagine a register user operation: If a username is already taken, you would expect an error; if it is not, you would expect the user to be created. But keep in mind that the intention of *squishy* data is to make writing tests more easy and to bypass a value for testing purposes to the application. The state of an application is not achieved by bypassing test data but by writing a prepare function (for unit tests) or a given function (in a more behavioural approach) that is executed before the actual test runs.

## Command

The command contains the core of your application: the business logic. It is only limited by the fact that it must not cause any side effects but is only allowed to read the current state of your application. So what the command basically does is 

* collect data,
* validate it and
* prepare the desired side effects.

A command has one or more outcomes resulting in events that will be fired.

## Event

The event contains the prepared data and will be consumed by one or more listeners or views that will perform the desired side effect. You can distinguish between side effects that are executed within a transaction or outside a transaction if a database is involved.

The listener or view that consumes the event is absolutely forbidden to change the data it receives!

Because the event contains all data to cause the desired side effect you can store it in a timeline and replay it afterwards, for example to find a bug, to rebuild the state of the application or to prepare migrations.

The [TodoMVC example](https://todo.acegen.de) provides a way to see the [replay](https://github.com/annettedorothea/TodoMVC---Client#replay) mechanism on the client.

---

# TodoMVC App As Example

* [Server source code](https://github.com/annettedorothea/TodoMVC---Server)
* [Client source code](https://github.com/annettedorothea/TodoMVC---Client)


## The REST API

### POST, PUT and DELETE As WriteActions

In case of a REST API you have the resource or controller that receives the incoming request. Here you create the appropriate action and the data object that is supposed to be passed the Action-Command-Event chain:

[CreateTodoResource.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/gen/java/com/anfelisa/todo/resources/CreateTodoResource.java)

The WriteAction superclass looks like this:

[WriteAction.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/gen/java/de/acegen/WriteAction.java)

There you can see that 

* a transaction is opened
* the system time and 
* the *squishy* data is initialized
* in case you are running in DEV mode, *squishy* data gets overwritten (this is the bypassing of test data)
* the command is called 
* the events are published
* the transaction is commited
* the events that should run outside the transaction are published
* data is returned

This is the corresponding command:

[CreateTodoCommand.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/main/java/com/anfelisa/todo/commands/CreateTodoCommand.java)

[AbstractCreateTodoCommand.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/gen/java/com/anfelisa/todo/commands/AbstractCreateTodoCommand.java)

And in this view you will find the listeners that react to the published events:

[TodoView.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/main/java/com/anfelisa/todo/views/TodoView.java)

### GET As ReadAction

The read action is rather simple:

[ReadAction.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/gen/java/de/acegen/ReadAction.java)

[GetAllTodosAction.java](https://github.com/annettedorothea/TodoMVC---Server/blob/master/src/main/java/com/anfelisa/todo/actions/GetAllTodosAction.java)

## The Single Page Application

If you are using this pattern in a UI that is connected to a REST API, there are some things to consider:

* The client's view is not a database but a thin presentational layer of the current state ot the app.
* There are no read actions because the user 'reads' the current app state and not the app itself.
* You need 
  * synchronous actions when the user is merely changing the UI and
  * asynchronous actions when a server call is performed.
* In case of an asynchronous action you might want to display a loading indicator. A shortcut for doing so might be a good idea.
* You might want to create sequences of actions, so when one action is finished you can trigger a second one based on the outcome.
* In your E2E tests you need to bypass values to the client application and to the server API.

Here are the base classes:

[Base classes](https://github.com/annettedorothea/TodoMVC---Client/tree/master/es6/gen/ace)

The commands and actions are located here:

* [Hand written](https://github.com/annettedorothea/TodoMVC---Client/tree/master/es6/src/todo)
* [Generated](https://github.com/annettedorothea/TodoMVC---Client/tree/master/es6/gen/todo)

Here are the components of the thin and logic free presentational layer:

[Presentational layer](https://github.com/annettedorothea/TodoMVC---Client/tree/master/es6/src/components)

---

# Additional Notes

## DSL And Code Generator

All files that are located in a gen folder are generated files in the above examples.

These are the corresponding DSL files: 

* [TodoMVC server DSL file](https://github.com/annettedorothea/TodoMVC---Server/blob/master/todo-server.ace)
* [TodoMVC client DSL file](https://github.com/annettedorothea/TodoMVC---Client/blob/master/todo-client.ace)

Here you can find the scenario DSL files for 

* [TodoMVC integration tests](https://github.com/annettedorothea/TodoMVC---Server/tree/master/todo-server)
* [TodoMVC E2E tests](https://github.com/annettedorothea/TodoMVC---Client/tree/master/scenarios)

You can install the plugin from http://acegen.de in Eclipse.

## SuperMemo App As PoC

Check out a more complex implementation of a SuperMemo app that was written as a proof of concept for the Action-Command-Event pattern.

* [SuperMemo server](https://github.com/annettedorothea/com.anfelisa.server)
* [SuperMemo client](https://github.com/annettedorothea/com.anfelisa.client)

## The Replay Mechanism

### Bug Fixing

You can see the replay mechanism on the client if you follow the instructions on the bottom left in the [TodoMVC example](https://todo.acegen.de). It may serve you as a way to find and fix bugs because you do not have to guess what the user did when he encountered the bug but you **know** what actually happened.

### Migrations

As you can replay the events on a server you can rebuild the state of the application with a changed data model. For example: If one of your select statements to query complex data with many joins gets very slow due to the rise of the amount of data, you might want to create a table that contains all data you need for the query in a way that is optimized for reading. You can fill this table by replaying all the events. 

But you have to be aware of the fact that changing the structure of your events will make the attempt to always have a replayable timeline rather difficult because you will have to migrate the events. So if you are live already and you have to make structural changes to your system, you might want to give up the ability to replay the timeline on the server.

## A Word On Frameworks

I strongly believe that we should implement the business logic in a way that is framework agnostic. I would not advise completely abandoning the use of frameworks, but you should try to banish them to the edges of the software. For example:

* It's fine to use a JS framework in the presentation layer of a user interface.
* In addition, it is advisable to rely on a tried and tested framework for the REST interface.
* And the same is true for the persistence layer.

## Automated Testing

When we write unit tests we are always in the tension of having to test the behaviour as well as the implementation. I think we cannot get rid of this tension, we have to live with it and find clever ways to avoid the pitfalls into which we can fall when writing automated tests.

So I would suggest a mixture of unit tests, integration and E2E test. Let me try to explain what this mixture should be composed of and how the Action-Command-Event pattern can help you writing your tests more efficiently:

### Unit Tests

I really like TDD. Writing unit tests with TDD for the *real* business logic is fun. Writing unit tests with TDD for the UI for example is a pain, at least I think so.

On the other hand, unit tests are very annoying when you do structural refactorings of your software because they are prone to fail on these kinds of changes.

So there is the tension:

Because unit tests are tied to a unit, they are not receptive to structural changes. The promise that you can refactor the software easily if you have unit tests proves to be deceptive.

With the Action-Command-Event pattern we only write unit tests for the commands because they contain the business logic. You might also want to write unit tests for the actions in order to verify that the *squishy* data has been initialized correctly.

### Integration and E2E tests

For the bigger picture and to make sure our tests are not prone to fail on structural changes, we write integration and E2E tests and choose a more behavioural way for our tests.

The common problems with integration and E2E tests as far as I perceive them are:

1. They are fragile because of the *squishy* data.
2. The preparation of the test data is difficult.

#### *Squishy* Data

As we have seen in this pattern the solution for the *squishy* data is already included by initializing it in the action. The only thing you have to do is to find a way to bypass the *squishy* data to your application during the execution of the integration and E2E tests.

#### Prepare the test data

In order to prepare test data you can simply execute a sequence of events before the test is executed.

In the acegen DSL there is a BDD way to write integration and E2E scenarios based on the Action-Command-Event pattern.

Take a look at the scenarios found in these files:

* [TodoMVC integration tests](https://github.com/annettedorothea/TodoMVC---Server/tree/master/todo-server)
* [TodoMVC E2E tests](https://github.com/annettedorothea/TodoMVC---Client/tree/master/scenarios)
