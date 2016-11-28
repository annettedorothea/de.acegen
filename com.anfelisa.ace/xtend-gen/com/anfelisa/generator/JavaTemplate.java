package com.anfelisa.generator;

import com.anfelisa.extensions.ActionExtension;
import com.anfelisa.extensions.AttributeExtension;
import com.anfelisa.extensions.CommandExtension;
import com.anfelisa.extensions.DataExtension;
import com.anfelisa.extensions.EventExtension;
import com.anfelisa.extensions.ModelExtension;
import com.anfelisa.extensions.ViewExtension;
import javax.inject.Inject;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JavaTemplate {
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
  
  @Inject
  @Extension
  private ModelExtension _modelExtension;
  
  @Inject
  @Extension
  private DataExtension _dataExtension;
  
  @Inject
  @Extension
  private AttributeExtension _attributeExtension;
  
  public CharSequence generateModel(final /* Model */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field models is undefined"
      + "\nThe method modelName(Model) from the type ModelExtension refers to the missing type Model"
      + "\nname cannot be resolved"
      + "\ninterfaceGetter cannot be resolved"
      + "\ninterfaceGetter cannot be resolved");
  }
  
  public CharSequence generateModelClass(final /* Model */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field models is undefined"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field models is undefined"
      + "\nThe method modelClassName(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelName(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelClassName(Model) from the type ModelExtension refers to the missing type Model"
      + "\nname cannot be resolved"
      + "\ndeclaration cannot be resolved"
      + "\ndeclaration cannot be resolved"
      + "\nparam cannot be resolved"
      + "\nassign cannot be resolved"
      + "\ngetter cannot be resolved"
      + "\nsetter cannot be resolved"
      + "\ngetter cannot be resolved"
      + "\nsetter cannot be resolved");
  }
  
  public CharSequence generateData(final Data it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field models is undefined"
      + "\nThe method or field models is undefined"
      + "\nThe method or field models is undefined"
      + "\nThe method allNonListModels(Data) from the type DataExtension refers to the missing type Model"
      + "\nThe method allAttributes(Data) from the type DataExtension refers to the missing type Attribute"
      + "\nThe method allListModels(Data) from the type DataExtension refers to the missing type Model"
      + "\nThe method allAttributes(Data) from the type DataExtension refers to the missing type Attribute"
      + "\nThe method allAttributes(Data) from the type DataExtension refers to the missing type Attribute"
      + "\nThe method allAttributes(Data) from the type DataExtension refers to the missing type Attribute"
      + "\nThe method allListModels(Data) from the type DataExtension refers to the missing type Model"
      + "\nname cannot be resolved"
      + "\nmodel cannot be resolved"
      + "\nimportModel cannot be resolved"
      + "\nmodelName cannot be resolved"
      + "\ndeclaration cannot be resolved"
      + "\nmodelName cannot be resolved"
      + "\nmodelListAttributeName cannot be resolved"
      + "\nmodel cannot be resolved"
      + "\nmodels cannot be resolved"
      + "\ndeclaration cannot be resolved"
      + "\nparam cannot be resolved"
      + "\nassign cannot be resolved"
      + "\ngetter cannot be resolved"
      + "\nsetter cannot be resolved"
      + "\nlistGetter cannot be resolved"
      + "\nlistSetter cannot be resolved"
      + "\nmodel cannot be resolved"
      + "\nmodels cannot be resolved"
      + "\ngetter cannot be resolved"
      + "\nsetter cannot be resolved");
  }
  
  public CharSequence generateDao(final /* Model */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field attributes is undefined"
      + "\nThe method or field attributes is undefined"
      + "\nThe method modelDao(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method table(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method table(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method table(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method table(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelName(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelParam(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method findSerialAttribute(Model) from the type ModelExtension refers to the missing type Attribute"
      + "\nThe method modelParam(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method findSerialAttribute(Model) from the type ModelExtension refers to the missing type Attribute"
      + "\nThe method table(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelParam(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method table(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method allNonSerialAttributes(Model) from the type ModelExtension refers to the missing type Attribute"
      + "\nThe method allNonSerialAttributes(Model) from the type ModelExtension refers to the missing type Attribute"
      + "\nThe method allNonSerialAttributes(Model) from the type ModelExtension refers to the missing type Attribute"
      + "\nThe method modelParam(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method table(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method allNonSerialAttributes(Model) from the type ModelExtension refers to the missing type Attribute"
      + "\nThe method allNonSerialAttributes(Model) from the type ModelExtension refers to the missing type Attribute"
      + "\nThe method allNonSerialAttributes(Model) from the type ModelExtension refers to the missing type Attribute"
      + "\nThe method modelParam(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelName(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelParam(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method table(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelParam(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method allUniqueAttributes(Model) from the type ModelExtension refers to the missing type Attribute"
      + "\nThe method table(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelName(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method table(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelMapper(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelName(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method table(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelMapper(Model) from the type ModelExtension refers to the missing type Model"
      + "\nname cannot be resolved"
      + "\ntableDefinition cannot be resolved"
      + "\nprimaryKey cannot be resolved"
      + "\nforeignKey cannot be resolved"
      + "\nuniqueConstraint cannot be resolved"
      + "\n!= cannot be resolved"
      + "\ngetterCall cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\ngetterCall cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\ngetterCall cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\ngetterCall cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\ngetterCall cannot be resolved"
      + "\nname cannot be resolved"
      + "\ntoFirstUpper cannot be resolved"
      + "\njavaType cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\ntoFirstUpper cannot be resolved"
      + "\njavaType cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  public CharSequence generateMapper(final /* Model */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field attributes is undefined"
      + "\nThe method modelMapper(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelName(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelName(Model) from the type ModelExtension refers to the missing type Model"
      + "\nThe method modelClassName(Model) from the type ModelExtension refers to the missing type Model"
      + "\nname cannot be resolved"
      + "\nmapperInit cannot be resolved");
  }
  
  public CharSequence generateAbstractActionFile(final /* Action */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field data is undefined"
      + "\nThe method or field command is undefined"
      + "\nThe method or field command is undefined"
      + "\nThe method or field data is undefined"
      + "\nThe method or field data is undefined"
      + "\nThe method or field type is undefined"
      + "\nThe method or field command is undefined"
      + "\nThe method or field command is undefined"
      + "\nThe method abstractActionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method abstractActionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method actionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nname cannot be resolved"
      + "\ndataImport cannot be resolved"
      + "\n!= cannot be resolved"
      + "\nname cannot be resolved"
      + "\ncommandName cannot be resolved"
      + "\ndataParamType cannot be resolved"
      + "\ndataParamType cannot be resolved"
      + "\n!= cannot be resolved"
      + "\ncommandName cannot be resolved");
  }
  
  public CharSequence generateAbstractCommandFile(final /* Command */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field data is undefined"
      + "\nThe method or field data is undefined"
      + "\nThe method or field eventsOnOutcome is undefined"
      + "\nThe method or field data is undefined"
      + "\nThe method or field eventsOnOutcome is undefined"
      + "\nThe method abstractCommandName(Command) from the type CommandExtension refers to the missing type Command"
      + "\nThe method abstractCommandName(Command) from the type CommandExtension refers to the missing type Command"
      + "\nThe method commandName(Command) from the type CommandExtension refers to the missing type Command"
      + "\nname cannot be resolved"
      + "\ndataImport cannot be resolved"
      + "\ndataParamType cannot be resolved"
      + "\noutcome cannot be resolved"
      + "\noutcome cannot be resolved"
      + "\ndataParamType cannot be resolved"
      + "\noutcome cannot be resolved"
      + "\nevents cannot be resolved"
      + "\neventNameWithPackage cannot be resolved"
      + "\nactions cannot be resolved"
      + "\nnewAction cannot be resolved");
  }
  
  public CharSequence generateAbstractEventFile(final /* Event */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field data is undefined"
      + "\nThe method or field data is undefined"
      + "\nThe method or field data is undefined"
      + "\nThe method abstractEventName(Event) from the type EventExtension refers to the missing type Event"
      + "\nThe method abstractEventName(Event) from the type EventExtension refers to the missing type Event"
      + "\nThe method eventName(Event) from the type EventExtension refers to the missing type Event"
      + "\nname cannot be resolved"
      + "\ndataImport cannot be resolved"
      + "\ndataParamType cannot be resolved"
      + "\ndataParamType cannot be resolved");
  }
  
  public CharSequence generateInitialActionFile(final /* Action */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field data is undefined"
      + "\nThe method or field data is undefined"
      + "\nThe method actionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method abstractActionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method actionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method actionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nname cannot be resolved"
      + "\ndataImport cannot be resolved"
      + "\ndataParamType cannot be resolved");
  }
  
  public CharSequence generateInitialCommandFile(final /* Command */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field data is undefined"
      + "\nThe method or field data is undefined"
      + "\nThe method or field eventsOnOutcome is undefined"
      + "\nThe method or field eventsOnOutcome is undefined"
      + "\nThe method commandName(Command) from the type CommandExtension refers to the missing type Command"
      + "\nThe method abstractCommandName(Command) from the type CommandExtension refers to the missing type Command"
      + "\nThe method commandName(Command) from the type CommandExtension refers to the missing type Command"
      + "\nThe method commandName(Command) from the type CommandExtension refers to the missing type Command"
      + "\nname cannot be resolved"
      + "\ndataImport cannot be resolved"
      + "\ndataParamType cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n> cannot be resolved"
      + "\nget cannot be resolved"
      + "\noutcome cannot be resolved");
  }
  
  public CharSequence generateInitialEventFile(final /* Event */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field data is undefined"
      + "\nThe method or field data is undefined"
      + "\nThe method eventName(Event) from the type EventExtension refers to the missing type Event"
      + "\nThe method abstractEventName(Event) from the type EventExtension refers to the missing type Event"
      + "\nThe method eventName(Event) from the type EventExtension refers to the missing type Event"
      + "\nThe method eventName(Event) from the type EventExtension refers to the missing type Event"
      + "\nname cannot be resolved"
      + "\ndataImport cannot be resolved"
      + "\ndataParamType cannot be resolved");
  }
  
  public CharSequence generateInitialResourceFile(final /* Action */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field data is undefined"
      + "\nThe method or field type is undefined"
      + "\nThe method or field type is undefined"
      + "\nThe method or field type is undefined"
      + "\nThe method or field type is undefined"
      + "\nThe method or field type is undefined"
      + "\nThe method or field type is undefined"
      + "\nThe method or field data is undefined"
      + "\nThe method actionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method resourceName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method resourceName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method resourceName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method resourceName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method resourceName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method resourceName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nThe method actionName(Action) from the type ActionExtension refers to the missing type Action"
      + "\nname cannot be resolved"
      + "\nname cannot be resolved"
      + "\ndataImport cannot be resolved"
      + "\n!= cannot be resolved"
      + "\n!= cannot be resolved"
      + "\ntoLowerCase cannot be resolved"
      + "\n!= cannot be resolved"
      + "\ntoLowerCase cannot be resolved"
      + "\ndataParamType cannot be resolved");
  }
  
  public CharSequence generateView(final /* View */Object it, final /* Project */Object project) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field renderFunctions is undefined"
      + "\nThe method or field renderFunctions is undefined"
      + "\nThe method viewName(View) from the type ViewExtension refers to the missing type View"
      + "\nname cannot be resolved"
      + "\ndata cannot be resolved"
      + "\ndataImport cannot be resolved"
      + "\ndata cannot be resolved"
      + "\ndataName cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  public CharSequence generateAppRegistration(final /* Project */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field name is undefined"
      + "\nThe method or field views is undefined"
      + "\nThe method or field name is undefined"
      + "\nThe method or field actions is undefined"
      + "\nThe method or field name is undefined"
      + "\nThe method or field actions is undefined"
      + "\nThe method or field views is undefined"
      + "\nThe method or field events is undefined"
      + "\nsize cannot be resolved"
      + "\n> cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n> cannot be resolved"
      + "\nresourceName cannot be resolved"
      + "\nviewName cannot be resolved"
      + "\nviewNameAsVariable cannot be resolved"
      + "\nviewName cannot be resolved"
      + "\nlisteners cannot be resolved"
      + "\neventName cannot be resolved"
      + "\nviewFunctionWithViewNameAsVariable cannot be resolved");
  }
}
