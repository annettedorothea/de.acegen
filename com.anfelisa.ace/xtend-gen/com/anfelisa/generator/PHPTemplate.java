package com.anfelisa.generator;

import com.anfelisa.extensions.ActionExtension;
import com.anfelisa.extensions.CommandExtension;
import com.anfelisa.extensions.EventExtension;
import com.anfelisa.extensions.ViewExtension;
import javax.inject.Inject;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class PHPTemplate {
  @Inject
  @Extension
  private ActionExtension _actionExtension;
  
  @Inject
  @Extension
  private CommandExtension _commandExtension;
  
  @Inject
  @Extension
  private EventExtension _eventExtension;
  
  @Inject
  @Extension
  private ViewExtension _viewExtension;
  
  public CharSequence generateAbstractActionFile(final /* Action */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field command is undefined"
      + "\nThe method or field type is undefined"
      + "\nThe method abstractActionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method actionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\ncommandName cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public CharSequence generateAbstractCommandFile(final /* Command */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nView cannot be resolved to a type."
      + "\nThe method or field eventsOnOutcome is undefined"
      + "\nThe method or field eventsOnOutcome is undefined"
      + "\nThe method abstractCommandName(Command) from the type CommandExtension refers to the missing type Command"
      + "\nThe method commandName(Command) from the type CommandExtension refers to the missing type Command"
      + "\noutcome cannot be resolved"
      + "\noutcome cannot be resolved"
      + "\noutcome cannot be resolved"
      + "\nevents cannot be resolved"
      + "\nlisteners cannot be resolved"
      + "\neContainer cannot be resolved"
      + "\nviewName cannot be resolved"
      + "\nname cannot be resolved"
      + "\neventName cannot be resolved");
  }
  
  public CharSequence generateEventFile(final /* Event */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method eventName(Event) from the type EventExtension refers to the missing type Event"
      + "\nThe method eventName(Event) from the type EventExtension refers to the missing type Event");
  }
  
  public CharSequence generateInitialActionFile(final /* Action */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method actionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method abstractActionName(Action) from the type ActionExtension refers to the missing type Action");
  }
  
  public CharSequence generateInitialCommandFile(final /* Command */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method commandName(Command) from the type CommandExtension refers to the missing type Command"
      + "\nThe method abstractCommandName(Command) from the type CommandExtension refers to the missing type Command");
  }
  
  public CharSequence generateInitialFile(final /* Action */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method actionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  public CharSequence generateView(final /* View */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field renderFunctions is undefined"
      + "\nThe method viewName(View) from the type ViewExtension refers to the missing type View"
      + "\nname cannot be resolved");
  }
}
