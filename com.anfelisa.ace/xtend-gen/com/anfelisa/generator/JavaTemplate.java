package com.anfelisa.generator;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.Attribute;
import com.anfelisa.ace.Command;
import com.anfelisa.ace.ComplexAttribute;
import com.anfelisa.ace.Data;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.EventOnOutcome;
import com.anfelisa.ace.Model;
import com.anfelisa.ace.ModelRef;
import com.anfelisa.ace.Project;
import com.anfelisa.ace.View;
import com.anfelisa.ace.ViewFunction;
import com.anfelisa.extensions.ActionExtension;
import com.anfelisa.extensions.AttributeExtension;
import com.anfelisa.extensions.CommandExtension;
import com.anfelisa.extensions.ComplexAttributeExtension;
import com.anfelisa.extensions.DataExtension;
import com.anfelisa.extensions.EventExtension;
import com.anfelisa.extensions.ModelExtension;
import com.anfelisa.extensions.ViewExtension;
import com.google.common.base.Objects;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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
  
  @Inject
  @Extension
  private ComplexAttributeExtension _complexAttributeExtension;
  
  public CharSequence generateModel(final Model it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@JsonDeserialize(as=");
    String _modelClassName = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName, "");
    _builder.append(".class)");
    _builder.newLineIfNotEmpty();
    _builder.append("public interface ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Attribute> _attributes = it.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.append("\t");
        String _interfaceGetter = this._attributeExtension.interfaceGetter(attribute);
        _builder.append(_interfaceGetter, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      EList<ComplexAttribute> _models = it.getModels();
      for(final ComplexAttribute complexAttribute : _models) {
        _builder.append("\t");
        String _interfaceGetter_1 = this._complexAttributeExtension.interfaceGetter(complexAttribute);
        _builder.append(_interfaceGetter_1, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateModelResource(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<form class=\"form-horizontal\">");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<div class=\"form-group\">");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<label class=\"col-sm-3 control-label\"></label>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<div class=\"col-sm-9\">");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<h4>{{texts.");
    String _name = it.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    _builder.append(_firstLower, "            ");
    _builder.append("}}</h4>");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</div>");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Attribute> _attributes = it.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.append("\t");
        _builder.append("<div class=\"form-group\" id=\"");
        String _name_1 = it.getName();
        String _firstLower_1 = StringExtensions.toFirstLower(_name_1);
        _builder.append(_firstLower_1, "\t");
        String _name_2 = attribute.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_2);
        _builder.append(_firstUpper, "\t");
        _builder.append("Div\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("<label for=\"");
        String _name_3 = it.getName();
        String _firstLower_2 = StringExtensions.toFirstLower(_name_3);
        _builder.append(_firstLower_2, "\t    ");
        String _name_4 = attribute.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_4);
        _builder.append(_firstUpper_1, "\t    ");
        _builder.append("\" class=\"col-sm-3 control-label\">");
        {
          String _constraint = attribute.getConstraint();
          boolean _notEquals = (!Objects.equal(_constraint, null));
          if (_notEquals) {
            _builder.append("* ");
          }
        }
        _builder.append("{{texts.");
        String _name_5 = it.getName();
        String _lowerCase = _name_5.toLowerCase();
        _builder.append(_lowerCase, "\t    ");
        _builder.append(".");
        String _name_6 = attribute.getName();
        _builder.append(_name_6, "\t    ");
        _builder.append("}}</label>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("<div class=\"col-sm-9\">");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("        ");
        _builder.append("<input type=\"text\" class=\"form-control\" id=\"");
        String _name_7 = it.getName();
        String _firstLower_3 = StringExtensions.toFirstLower(_name_7);
        _builder.append(_firstLower_3, "\t        ");
        String _name_8 = attribute.getName();
        String _firstUpper_2 = StringExtensions.toFirstUpper(_name_8);
        _builder.append(_firstUpper_2, "\t        ");
        _builder.append("\" placeholder=\"{{texts.");
        String _name_9 = it.getName();
        String _lowerCase_1 = _name_9.toLowerCase();
        _builder.append(_lowerCase_1, "\t        ");
        _builder.append(".");
        String _name_10 = attribute.getName();
        _builder.append(_name_10, "\t        ");
        _builder.append("}}\" value=\"{{");
        String _name_11 = it.getName();
        String _firstLower_4 = StringExtensions.toFirstLower(_name_11);
        _builder.append(_firstLower_4, "\t        ");
        _builder.append(".");
        String _name_12 = attribute.getName();
        _builder.append(_name_12, "\t        ");
        _builder.append("}}\"");
        {
          String _constraint_1 = attribute.getConstraint();
          boolean _notEquals_1 = (!Objects.equal(_constraint_1, null));
          if (_notEquals_1) {
            _builder.append(" onblur=\"new ValidateRequiredFieldAction({id : \'");
            String _name_13 = it.getName();
            String _firstLower_5 = StringExtensions.toFirstLower(_name_13);
            _builder.append(_firstLower_5, "\t        ");
            String _name_14 = attribute.getName();
            String _firstUpper_3 = StringExtensions.toFirstUpper(_name_14);
            _builder.append(_firstUpper_3, "\t        ");
            _builder.append("\'}).apply()\"");
          }
        }
        _builder.append(">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("        ");
        {
          String _constraint_2 = attribute.getConstraint();
          boolean _notEquals_2 = (!Objects.equal(_constraint_2, null));
          if (_notEquals_2) {
            _builder.append("<span class=\"help-block notEmpty\" style=\"display: none\">{{texts.");
            String _name_15 = it.getName();
            String _lowerCase_2 = _name_15.toLowerCase();
            _builder.append(_lowerCase_2, "\t        ");
            _builder.append(".");
            String _name_16 = attribute.getName();
            _builder.append(_name_16, "\t        ");
            _builder.append("NotEmpty}}</span>");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("    ");
        _builder.append("</div>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</div>");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    {
      EList<ComplexAttribute> _models = it.getModels();
      for(final ComplexAttribute modelRef : _models) {
        {
          boolean _isList = modelRef.isList();
          if (_isList) {
            _builder.append("\t");
            _builder.append("{{#");
            String _name_17 = modelRef.getName();
            _builder.append(_name_17, "\t");
            _builder.append("}}");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("<div class=\"panel panel-default\">");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("<div class=\"panel-heading\">");
            _builder.newLine();
            {
              Model _model = modelRef.getModel();
              EList<Attribute> _attributes_1 = _model.getAttributes();
              for(final Attribute attribute_1 : _attributes_1) {
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("<h4 class=\"panel-title\">{{texts.");
                String _name_18 = attribute_1.getName();
                _builder.append(_name_18, "\t\t\t");
                _builder.append("}}: {{");
                String _name_19 = attribute_1.getName();
                _builder.append(_name_19, "\t\t\t");
                _builder.append("}}</h4>");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("</div>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("<div class=\"panel-body\">");
            _builder.newLine();
            {
              Model _model_1 = modelRef.getModel();
              EList<Attribute> _attributes_2 = _model_1.getAttributes();
              for(final Attribute attribute_2 : _attributes_2) {
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("{{texts.");
                String _name_20 = attribute_2.getName();
                _builder.append(_name_20, "\t\t\t");
                _builder.append("}}: {{");
                String _name_21 = attribute_2.getName();
                _builder.append(_name_21, "\t\t\t");
                _builder.append("}}<br>");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("</div>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("</div>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("{{/");
            String _name_22 = modelRef.getName();
            _builder.append(_name_22, "\t");
            _builder.append("}}");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("{{^");
            String _name_23 = modelRef.getName();
            _builder.append(_name_23, "\t");
            _builder.append("}}");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("<div class=\"panel panel-default\">");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("<div class=\"panel-heading\">");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append("<h3 class=\"panel-title\">{{texts.empty");
            String _name_24 = modelRef.getName();
            String _firstUpper_4 = StringExtensions.toFirstUpper(_name_24);
            _builder.append(_firstUpper_4, "\t        ");
            _builder.append("}}</h3>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("</div>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("</div>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("{{/");
            String _name_25 = modelRef.getName();
            _builder.append(_name_25, "\t");
            _builder.append("}}");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("<div class=\"table-responsive\">");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("<table class=\"table table-bordered table-hover table-responsive\">");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append("<tr>");
            _builder.newLine();
            {
              Model _model_2 = modelRef.getModel();
              EList<Attribute> _attributes_3 = _model_2.getAttributes();
              for(final Attribute attribute_3 : _attributes_3) {
                _builder.append("\t");
                _builder.append("\t\t\t");
                _builder.append("<th>{{texts.");
                String _name_26 = attribute_3.getName();
                _builder.append(_name_26, "\t\t\t\t");
                _builder.append("}}</th>");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("        ");
            _builder.append("</tr>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append("{{#");
            String _name_27 = modelRef.getName();
            _builder.append(_name_27, "\t        ");
            _builder.append("}}");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append("<tr>");
            _builder.newLine();
            {
              Model _model_3 = modelRef.getModel();
              EList<Attribute> _attributes_4 = _model_3.getAttributes();
              for(final Attribute attribute_4 : _attributes_4) {
                _builder.append("\t");
                _builder.append("\t\t\t");
                _builder.append("<td>{{");
                String _name_28 = attribute_4.getName();
                _builder.append(_name_28, "\t\t\t\t");
                _builder.append("}}</td>");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("        ");
            _builder.append("</tr>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append("{{/");
            String _name_29 = modelRef.getName();
            _builder.append(_name_29, "\t        ");
            _builder.append("}}");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append("{{^");
            String _name_30 = modelRef.getName();
            _builder.append(_name_30, "\t        ");
            _builder.append("}}");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append("<tr>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("            ");
            _builder.append("<td colspan=\"");
            Model _model_4 = modelRef.getModel();
            EList<Attribute> _attributes_5 = _model_4.getAttributes();
            int _size = _attributes_5.size();
            _builder.append(_size, "\t            ");
            _builder.append("\">{{texts.empty");
            String _name_31 = modelRef.getName();
            String _firstUpper_5 = StringExtensions.toFirstUpper(_name_31);
            _builder.append(_firstUpper_5, "\t            ");
            _builder.append("}}</td>");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append("</tr>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("        ");
            _builder.append("{{/");
            String _name_32 = modelRef.getName();
            _builder.append(_name_32, "\t        ");
            _builder.append("}}");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("    ");
            _builder.append("</table>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("</div>");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("</form>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateModelClass(final Model it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.append("import org.hibernate.validator.constraints.NotEmpty;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class ");
    String _modelClassName = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName, "");
    _builder.append(" implements ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Attribute> _attributes = it.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      EList<ComplexAttribute> _models = it.getModels();
      for(final ComplexAttribute modelRef : _models) {
        _builder.append("\t");
        String _declaration_1 = this._complexAttributeExtension.declaration(modelRef);
        _builder.append(_declaration_1, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _modelClassName_1 = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName_1, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_1 = it.getAttributes();
      boolean _hasElements = false;
      for(final Attribute attribute_1 : _attributes_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t");
        }
        _builder.append("\t\t");
        String _param = this._attributeExtension.param(attribute_1);
        _builder.append(_param, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    {
      EList<Attribute> _attributes_2 = it.getAttributes();
      for(final Attribute attribute_2 : _attributes_2) {
        _builder.append("\t\t");
        String _assign = this._attributeExtension.assign(attribute_2);
        _builder.append(_assign, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<Attribute> _attributes_3 = it.getAttributes();
      for(final Attribute attribute_3 : _attributes_3) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_3);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _setter = this._attributeExtension.setter(attribute_3);
        _builder.append(_setter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      EList<ComplexAttribute> _models_1 = it.getModels();
      for(final ComplexAttribute modelRef_1 : _models_1) {
        _builder.append("\t");
        String _ter_1 = this._complexAttributeExtension.getter(modelRef_1);
        _builder.append(_ter_1, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _setter_1 = this._complexAttributeExtension.setter(modelRef_1);
        _builder.append(_setter_1, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateDataInterface(final Data it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<ModelRef> _models = it.getModels();
      for(final ModelRef model : _models) {
        Model _model = model.getModel();
        String _importModel = this._modelExtension.importModel(_model);
        _builder.append(_importModel, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@JsonDeserialize(as=");
    String _dataName = this._dataExtension.dataName(it);
    _builder.append(_dataName, "");
    _builder.append(".class)");
    _builder.newLineIfNotEmpty();
    _builder.append("public interface ");
    String _dataInterfaceName = this._dataExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName, "");
    _builder.append(" extends ");
    {
      EList<ModelRef> _models_1 = it.getModels();
      boolean _hasElements = false;
      for(final ModelRef modelRef : _models_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        Model _model_1 = modelRef.getModel();
        String _modelName = this._modelExtension.modelName(_model_1);
        _builder.append(_modelName, "");
      }
      if (_hasElements) {
        _builder.append(",", "");
      }
    }
    _builder.append(" IDataContainer {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateData(final Data it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".data;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonIgnore;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.validation.constraints.NotNull;");
    _builder.newLine();
    _builder.append("import org.hibernate.validator.constraints.NotEmpty;");
    _builder.newLine();
    _builder.append("import org.joda.time.DateTime;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<ModelRef> _models = it.getModels();
      for(final ModelRef model : _models) {
        Model _model = model.getModel();
        String _importModel = this._modelExtension.importModel(_model);
        _builder.append(_importModel, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("public class ");
    String _dataName = this._dataExtension.dataName(it);
    _builder.append(_dataName, "");
    _builder.append(" implements ");
    String _dataInterfaceName = this._dataExtension.dataInterfaceName(it);
    _builder.append(_dataInterfaceName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String createdId;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allAttributes = this._dataExtension.allAttributes(it);
      for(final Attribute attribute : _allAttributes) {
        _builder.append("\t");
        String _declaration = this._attributeExtension.declaration(attribute);
        _builder.append(_declaration, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      EList<ModelRef> _models_1 = it.getModels();
      for(final ModelRef modelRef : _models_1) {
        {
          Model _model_1 = modelRef.getModel();
          EList<ComplexAttribute> _models_2 = _model_1.getModels();
          for(final ComplexAttribute modelModelRef : _models_2) {
            _builder.append("\t");
            String _declaration_1 = this._complexAttributeExtension.declaration(modelModelRef);
            _builder.append(_declaration_1, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("private org.joda.time.DateTime systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _dataName_1 = this._dataExtension.dataName(it);
    _builder.append(_dataName_1, "\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      List<Attribute> _allAttributes_1 = this._dataExtension.allAttributes(it);
      boolean _hasElements = false;
      for(final Attribute attribute_1 : _allAttributes_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t");
        }
        _builder.append("\t\t");
        String _param = this._attributeExtension.param(attribute_1);
        _builder.append(_param, "\t\t");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements) {
        _builder.append(",", "\t\t");
      }
    }
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"uuid\") String uuid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    {
      List<Attribute> _allAttributes_2 = this._dataExtension.allAttributes(it);
      for(final Attribute attribute_2 : _allAttributes_2) {
        _builder.append("\t\t");
        String _assign = this._attributeExtension.assign(attribute_2);
        _builder.append(_assign, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("this.uuid = uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      List<Attribute> _allAttributes_3 = this._dataExtension.allAttributes(it);
      int _length = ((Object[])Conversions.unwrapArray(_allAttributes_3, Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        _builder.append("\t");
        _builder.append("public ");
        String _dataName_2 = this._dataExtension.dataName(it);
        _builder.append(_dataName_2, "\t");
        _builder.append("( String uuid ) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.uuid = uuid;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      List<Attribute> _allAttributes_4 = this._dataExtension.allAttributes(it);
      for(final Attribute attribute_3 : _allAttributes_4) {
        _builder.append("\t");
        String _ter = this._attributeExtension.getter(attribute_3);
        _builder.append(_ter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _setter = this._attributeExtension.setter(attribute_3);
        _builder.append(_setter, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _dataName_3 = this._dataExtension.dataName(it);
        String _initializer = this._attributeExtension.initializer(attribute_3, _dataName_3);
        _builder.append(_initializer, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    {
      EList<ModelRef> _models_3 = it.getModels();
      for(final ModelRef modelRef_1 : _models_3) {
        {
          Model _model_2 = modelRef_1.getModel();
          EList<ComplexAttribute> _models_4 = _model_2.getModels();
          for(final ComplexAttribute modelModelRef_1 : _models_4) {
            _builder.append("\t");
            String _ter_1 = this._complexAttributeExtension.getter(modelModelRef_1);
            _builder.append(_ter_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _setter_1 = this._complexAttributeExtension.setter(modelModelRef_1);
            _builder.append(_setter_1, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getUuid() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonIgnore");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getCreatedId() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return createdId;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setCreatedId(String createdId) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.createdId = createdId;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public org.joda.time.DateTime getSystemTime() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setSystemTime(org.joda.time.DateTime systemTime) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.systemTime = systemTime;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateDao(final Model it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.Handle;");
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.Query;");
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.Update;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonIgnoreType;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("@JsonIgnoreType");
    _builder.newLine();
    _builder.append("public class ");
    String _modelDao = this._modelExtension.modelDao(it);
    _builder.append(_modelDao, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void create(Handle handle) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("handle.execute(\"CREATE TABLE IF NOT EXISTS ");
    String _schema = project.getSchema();
    _builder.append(_schema, "\t\t");
    _builder.append(".");
    String _table = this._modelExtension.table(it);
    _builder.append(_table, "\t\t");
    _builder.append(" (");
    {
      EList<Attribute> _attributes = it.getAttributes();
      boolean _hasElements = false;
      for(final Attribute attribute : _attributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t\t");
        }
        String _table_1 = this._modelExtension.table(it);
        String _tableDefinition = this._attributeExtension.tableDefinition(attribute, _table_1);
        _builder.append(_tableDefinition, "\t\t");
      }
    }
    {
      EList<Attribute> _attributes_1 = it.getAttributes();
      for(final Attribute attribute_1 : _attributes_1) {
        String _table_2 = this._modelExtension.table(it);
        String _primaryKey = this._attributeExtension.primaryKey(attribute_1, _table_2);
        _builder.append(_primaryKey, "\t\t");
      }
    }
    {
      EList<Attribute> _attributes_2 = it.getAttributes();
      for(final Attribute attribute_2 : _attributes_2) {
        String _table_3 = this._modelExtension.table(it);
        String _schema_1 = project.getSchema();
        String _foreignKey = this._attributeExtension.foreignKey(attribute_2, _table_3, _schema_1);
        _builder.append(_foreignKey, "\t\t");
      }
    }
    {
      EList<Attribute> _attributes_3 = it.getAttributes();
      for(final Attribute attribute_3 : _attributes_3) {
        String _table_4 = this._modelExtension.table(it);
        String _uniqueConstraint = this._attributeExtension.uniqueConstraint(attribute_3, _table_4);
        _builder.append(_uniqueConstraint, "\t\t");
      }
    }
    _builder.append(")\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    {
      Attribute _findPrimaryKeyAttribute = this._modelExtension.findPrimaryKeyAttribute(it);
      boolean _notEquals = (!Objects.equal(_findPrimaryKeyAttribute, null));
      if (_notEquals) {
        Attribute _findPrimaryKeyAttribute_1 = this._modelExtension.findPrimaryKeyAttribute(it);
        String _javaType = this._attributeExtension.javaType(_findPrimaryKeyAttribute_1);
        _builder.append(_javaType, "\t");
      } else {
        _builder.append("void");
      }
    }
    _builder.append(" insert(Handle handle, ");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName, "\t");
    _builder.append(" ");
    String _modelParam = this._modelExtension.modelParam(it);
    _builder.append(_modelParam, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      Attribute _findPrimaryKeyAttribute_2 = this._modelExtension.findPrimaryKeyAttribute(it);
      boolean _notEquals_1 = (!Objects.equal(_findPrimaryKeyAttribute_2, null));
      if (_notEquals_1) {
        _builder.append("\t\t");
        _builder.append("if (");
        String _modelParam_1 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_1, "\t\t");
        _builder.append(".");
        Attribute _findPrimaryKeyAttribute_3 = this._modelExtension.findPrimaryKeyAttribute(it);
        String _terCall = this._attributeExtension.getterCall(_findPrimaryKeyAttribute_3);
        _builder.append(_terCall, "\t\t");
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("Update statement = handle.createStatement(\"INSERT INTO ");
        String _schema_2 = project.getSchema();
        _builder.append(_schema_2, "\t\t\t");
        _builder.append(".");
        String _table_5 = this._modelExtension.table(it);
        _builder.append(_table_5, "\t\t\t");
        _builder.append(" (");
        {
          EList<Attribute> _attributes_4 = it.getAttributes();
          boolean _hasElements_1 = false;
          for(final Attribute attribute_4 : _attributes_4) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t\t");
            }
            String _name_1 = attribute_4.getName();
            _builder.append(_name_1, "\t\t\t");
          }
        }
        _builder.append(") VALUES (");
        {
          EList<Attribute> _attributes_5 = it.getAttributes();
          boolean _hasElements_2 = false;
          for(final Attribute attribute_5 : _attributes_5) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t\t");
            }
            _builder.append(":");
            String _name_2 = attribute_5.getName();
            _builder.append(_name_2, "\t\t\t");
          }
        }
        _builder.append(")\");");
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_6 = it.getAttributes();
          for(final Attribute attribute_6 : _attributes_6) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("statement.bind(\"");
            String _name_3 = attribute_6.getName();
            _builder.append(_name_3, "\t\t\t");
            _builder.append("\", ");
            String _modelParam_2 = this._modelExtension.modelParam(it);
            _builder.append(_modelParam_2, "\t\t\t");
            _builder.append(".");
            String _terCall_1 = this._attributeExtension.getterCall(attribute_6);
            _builder.append(_terCall_1, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("statement.execute();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        {
          Attribute _findSerialAttribute = this._modelExtension.findSerialAttribute(it);
          boolean _notEquals_2 = (!Objects.equal(_findSerialAttribute, null));
          if (_notEquals_2) {
            _builder.append("handle.createStatement(\"SELECT setval(\'");
            String _schema_3 = project.getSchema();
            _builder.append(_schema_3, "\t\t\t");
            _builder.append(".");
            String _table_6 = this._modelExtension.table(it);
            _builder.append(_table_6, "\t\t\t");
            _builder.append("_");
            Attribute _findSerialAttribute_1 = this._modelExtension.findSerialAttribute(it);
            String _name_4 = _findSerialAttribute_1.getName();
            _builder.append(_name_4, "\t\t\t");
            _builder.append("_seq\', (SELECT MAX(");
            Attribute _findSerialAttribute_2 = this._modelExtension.findSerialAttribute(it);
            String _name_5 = _findSerialAttribute_2.getName();
            _builder.append(_name_5, "\t\t\t");
            _builder.append(") FROM ");
            String _schema_4 = project.getSchema();
            _builder.append(_schema_4, "\t\t\t");
            _builder.append(".");
            String _table_7 = this._modelExtension.table(it);
            _builder.append(_table_7, "\t\t\t");
            _builder.append("));\").execute();");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("return ");
        String _modelParam_3 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_3, "\t\t\t");
        _builder.append(".");
        Attribute _findPrimaryKeyAttribute_4 = this._modelExtension.findPrimaryKeyAttribute(it);
        String _terCall_2 = this._attributeExtension.getterCall(_findPrimaryKeyAttribute_4);
        _builder.append(_terCall_2, "\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("Query<Map<String, Object>> statement = handle.createQuery(\"INSERT INTO ");
        String _schema_5 = project.getSchema();
        _builder.append(_schema_5, "\t\t\t");
        _builder.append(".");
        String _table_8 = this._modelExtension.table(it);
        _builder.append(_table_8, "\t\t\t");
        _builder.append(" (");
        {
          List<Attribute> _allNonSerialAttributes = this._modelExtension.allNonSerialAttributes(it);
          boolean _hasElements_3 = false;
          for(final Attribute attribute_7 : _allNonSerialAttributes) {
            if (!_hasElements_3) {
              _hasElements_3 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t\t");
            }
            String _name_6 = attribute_7.getName();
            _builder.append(_name_6, "\t\t\t");
          }
        }
        _builder.append(") VALUES (");
        {
          List<Attribute> _allNonSerialAttributes_1 = this._modelExtension.allNonSerialAttributes(it);
          boolean _hasElements_4 = false;
          for(final Attribute attribute_8 : _allNonSerialAttributes_1) {
            if (!_hasElements_4) {
              _hasElements_4 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t\t");
            }
            _builder.append(":");
            String _name_7 = attribute_8.getName();
            _builder.append(_name_7, "\t\t\t");
          }
        }
        _builder.append(") RETURNING ");
        Attribute _findPrimaryKeyAttribute_5 = this._modelExtension.findPrimaryKeyAttribute(it);
        String _name_8 = _findPrimaryKeyAttribute_5.getName();
        _builder.append(_name_8, "\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        {
          List<Attribute> _allNonSerialAttributes_2 = this._modelExtension.allNonSerialAttributes(it);
          for(final Attribute attribute_9 : _allNonSerialAttributes_2) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("statement.bind(\"");
            String _name_9 = attribute_9.getName();
            _builder.append(_name_9, "\t\t\t");
            _builder.append("\", ");
            String _modelParam_4 = this._modelExtension.modelParam(it);
            _builder.append(_modelParam_4, "\t\t\t");
            _builder.append(".");
            String _terCall_3 = this._attributeExtension.getterCall(attribute_9);
            _builder.append(_terCall_3, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("Map<String, Object> first = statement.first();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("return (");
        Attribute _findPrimaryKeyAttribute_6 = this._modelExtension.findPrimaryKeyAttribute(it);
        String _javaType_1 = this._attributeExtension.javaType(_findPrimaryKeyAttribute_6);
        _builder.append(_javaType_1, "\t\t\t");
        _builder.append(") first.get(\"");
        Attribute _findPrimaryKeyAttribute_7 = this._modelExtension.findPrimaryKeyAttribute(it);
        String _name_10 = _findPrimaryKeyAttribute_7.getName();
        _builder.append(_name_10, "\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("\t\t");
        _builder.append("Update statement = handle.createStatement(\"INSERT INTO ");
        String _schema_6 = project.getSchema();
        _builder.append(_schema_6, "\t\t");
        _builder.append(".");
        String _table_9 = this._modelExtension.table(it);
        _builder.append(_table_9, "\t\t");
        _builder.append(" (");
        {
          List<Attribute> _allNonSerialAttributes_3 = this._modelExtension.allNonSerialAttributes(it);
          boolean _hasElements_5 = false;
          for(final Attribute attribute_10 : _allNonSerialAttributes_3) {
            if (!_hasElements_5) {
              _hasElements_5 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t");
            }
            String _name_11 = attribute_10.getName();
            _builder.append(_name_11, "\t\t");
          }
        }
        _builder.append(") VALUES (");
        {
          List<Attribute> _allNonSerialAttributes_4 = this._modelExtension.allNonSerialAttributes(it);
          boolean _hasElements_6 = false;
          for(final Attribute attribute_11 : _allNonSerialAttributes_4) {
            if (!_hasElements_6) {
              _hasElements_6 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t");
            }
            _builder.append(":");
            String _name_12 = attribute_11.getName();
            _builder.append(_name_12, "\t\t");
          }
        }
        _builder.append(")\");");
        _builder.newLineIfNotEmpty();
        {
          List<Attribute> _allNonSerialAttributes_5 = this._modelExtension.allNonSerialAttributes(it);
          for(final Attribute attribute_12 : _allNonSerialAttributes_5) {
            _builder.append("\t\t");
            _builder.append("statement.bind(\"");
            String _name_13 = attribute_12.getName();
            _builder.append(_name_13, "\t\t");
            _builder.append("\", ");
            String _modelParam_5 = this._modelExtension.modelParam(it);
            _builder.append(_modelParam_5, "\t\t");
            _builder.append(".");
            String _terCall_4 = this._attributeExtension.getterCall(attribute_12);
            _builder.append(_terCall_4, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("statement.execute();");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      List<Attribute> _allUniqueAttributes = this._modelExtension.allUniqueAttributes(it);
      for(final Attribute attribute_13 : _allUniqueAttributes) {
        _builder.append("\t");
        _builder.append("public void updateBy");
        String _name_14 = attribute_13.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_14);
        _builder.append(_firstUpper, "\t");
        _builder.append("(Handle handle, ");
        String _modelName_1 = this._modelExtension.modelName(it);
        _builder.append(_modelName_1, "\t");
        _builder.append(" ");
        String _modelParam_6 = this._modelExtension.modelParam(it);
        _builder.append(_modelParam_6, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Update statement = handle.createStatement(\"UPDATE ");
        String _schema_7 = project.getSchema();
        _builder.append(_schema_7, "\t\t");
        _builder.append(".");
        String _table_10 = this._modelExtension.table(it);
        _builder.append(_table_10, "\t\t");
        _builder.append(" SET ");
        {
          EList<Attribute> _attributes_7 = it.getAttributes();
          boolean _hasElements_7 = false;
          for(final Attribute attr : _attributes_7) {
            if (!_hasElements_7) {
              _hasElements_7 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t");
            }
            String _name_15 = attr.getName();
            _builder.append(_name_15, "\t\t");
            _builder.append(" = :");
            String _name_16 = attr.getName();
            _builder.append(_name_16, "\t\t");
          }
        }
        _builder.append(" WHERE ");
        String _name_17 = attribute_13.getName();
        _builder.append(_name_17, "\t\t");
        _builder.append(" = :");
        String _name_18 = attribute_13.getName();
        _builder.append(_name_18, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_8 = it.getAttributes();
          for(final Attribute attr_1 : _attributes_8) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("statement.bind(\"");
            String _name_19 = attr_1.getName();
            _builder.append(_name_19, "\t\t");
            _builder.append("\", ");
            String _modelParam_7 = this._modelExtension.modelParam(it);
            _builder.append(_modelParam_7, "\t\t");
            _builder.append(".");
            String _terCall_5 = this._attributeExtension.getterCall(attr_1);
            _builder.append(_terCall_5, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("statement.execute();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void deleteBy");
        String _name_20 = attribute_13.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_20);
        _builder.append(_firstUpper_1, "\t");
        _builder.append("(Handle handle, ");
        String _javaType_2 = this._attributeExtension.javaType(attribute_13);
        _builder.append(_javaType_2, "\t");
        _builder.append(" ");
        String _name_21 = attribute_13.getName();
        _builder.append(_name_21, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Update statement = handle.createStatement(\"DELETE FROM ");
        String _schema_8 = project.getSchema();
        _builder.append(_schema_8, "\t\t");
        _builder.append(".");
        String _table_11 = this._modelExtension.table(it);
        _builder.append(_table_11, "\t\t");
        _builder.append(" WHERE ");
        String _name_22 = attribute_13.getName();
        _builder.append(_name_22, "\t\t");
        _builder.append(" = :");
        String _name_23 = attribute_13.getName();
        _builder.append(_name_23, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("statement.bind(\"");
        String _name_24 = attribute_13.getName();
        _builder.append(_name_24, "\t\t");
        _builder.append("\", ");
        String _name_25 = attribute_13.getName();
        _builder.append(_name_25, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("statement.execute();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _modelName_2 = this._modelExtension.modelName(it);
        _builder.append(_modelName_2, "\t");
        _builder.append(" selectBy");
        String _name_26 = attribute_13.getName();
        String _firstUpper_2 = StringExtensions.toFirstUpper(_name_26);
        _builder.append(_firstUpper_2, "\t");
        _builder.append("(Handle handle, ");
        String _javaType_3 = this._attributeExtension.javaType(attribute_13);
        _builder.append(_javaType_3, "\t");
        _builder.append(" ");
        String _name_27 = attribute_13.getName();
        _builder.append(_name_27, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return handle.createQuery(\"SELECT * FROM ");
        String _schema_9 = project.getSchema();
        _builder.append(_schema_9, "\t\t");
        _builder.append(".");
        String _table_12 = this._modelExtension.table(it);
        _builder.append(_table_12, "\t\t");
        _builder.append(" WHERE ");
        String _name_28 = attribute_13.getName();
        _builder.append(_name_28, "\t\t");
        _builder.append(" = :");
        String _name_29 = attribute_13.getName();
        _builder.append(_name_29, "\t\t");
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".bind(\"");
        String _name_30 = attribute_13.getName();
        _builder.append(_name_30, "\t\t\t");
        _builder.append("\", ");
        String _name_31 = attribute_13.getName();
        _builder.append(_name_31, "\t\t\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".map(new ");
        String _modelMapper = this._modelExtension.modelMapper(it);
        _builder.append(_modelMapper, "\t\t\t");
        _builder.append("())");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append(".first();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<");
    String _modelName_3 = this._modelExtension.modelName(it);
    _builder.append(_modelName_3, "\t");
    _builder.append("> selectAll(Handle handle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return handle.createQuery(\"SELECT * FROM ");
    String _schema_10 = project.getSchema();
    _builder.append(_schema_10, "\t\t");
    _builder.append(".");
    String _table_13 = this._modelExtension.table(it);
    _builder.append(_table_13, "\t\t");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append(".map(new ");
    String _modelMapper_1 = this._modelExtension.modelMapper(it);
    _builder.append(_modelMapper_1, "\t\t\t");
    _builder.append("())");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append(".list();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateMigration(final Model it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<createTable tableName=\"");
    String _table = this._modelExtension.table(it);
    _builder.append(_table, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes = it.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.append("\t");
        _builder.append("<column name=\"");
        String _name = attribute.getName();
        _builder.append(_name, "\t");
        _builder.append("\" type=\"");
        String _sqlType = this._attributeExtension.sqlType(attribute);
        _builder.append(_sqlType, "\t");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<constraints ");
        {
          boolean _isPrimaryKey = attribute.isPrimaryKey();
          if (_isPrimaryKey) {
            _builder.append("primaryKey=\"true\"");
          }
        }
        _builder.append(" ");
        {
          if (((!Objects.equal(attribute.getConstraint(), null)) && attribute.getConstraint().equals("NotNull"))) {
            _builder.append("nullable=\"false\"");
          }
        }
        _builder.append("/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</column>");
        _builder.newLine();
      }
    }
    _builder.append("</createTable>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateMapper(final Model it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".models;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.sql.ResultSet;");
    _builder.newLine();
    _builder.append("import java.sql.SQLException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.StatementContext;");
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.tweak.ResultSetMapper;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _modelMapper = this._modelExtension.modelMapper(it);
    _builder.append(_modelMapper, "");
    _builder.append(" implements ResultSetMapper<");
    String _modelName = this._modelExtension.modelName(it);
    _builder.append(_modelName, "");
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _modelName_1 = this._modelExtension.modelName(it);
    _builder.append(_modelName_1, "\t");
    _builder.append(" map(int index, ResultSet r, StatementContext ctx) throws SQLException {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return new ");
    String _modelClassName = this._modelExtension.modelClassName(it);
    _builder.append(_modelClassName, "\t\t");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes = it.getAttributes();
      boolean _hasElements = false;
      for(final Attribute attribute : _attributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t\t");
        }
        _builder.append("\t\t\t");
        String _mapperInit = this._attributeExtension.mapperInit(attribute);
        _builder.append(_mapperInit, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractActionFile(final Action it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.DBI;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.WebApplicationException;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Action;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.HttpMethod;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.ICommand;");
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      Command _command = it.getCommand();
      boolean _notEquals = (!Objects.equal(_command, null));
      if (_notEquals) {
        _builder.append("import ");
        String _name_1 = project.getName();
        _builder.append(_name_1, "");
        _builder.append(".commands.");
        Command _command_1 = it.getCommand();
        String _commandName = this._commandExtension.commandName(_command_1);
        _builder.append(_commandName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractActionName = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName, "");
    _builder.append(" extends Action<");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "");
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractActionName_1 = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName_1, "\t");
    _builder.append("(DBI jdbi) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "\t\t");
    _builder.append("\", HttpMethod.");
    String _type = it.getType();
    _builder.append(_type, "\t\t");
    _builder.append(", jdbi);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ICommand getCommand() {");
    _builder.newLine();
    {
      Command _command_2 = it.getCommand();
      boolean _notEquals_1 = (!Objects.equal(_command_2, null));
      if (_notEquals_1) {
        _builder.append("\t\t");
        _builder.append("return new ");
        Command _command_3 = it.getCommand();
        String _commandName_1 = this._commandExtension.commandName(_command_3);
        _builder.append(_commandName_1, "\t\t");
        _builder.append("(this.actionData, databaseHandle);");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      String _type_1 = it.getType();
      boolean _equals = _type_1.equals("GET");
      boolean _not = (!_equals);
      if (_not) {
        _builder.append("\t");
        _builder.append("protected final void loadDataForGetRequest() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void throwUnauthorized() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new WebApplicationException(Response.Status.UNAUTHORIZED);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void throwBadRequest() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new WebApplicationException(Response.Status.BAD_REQUEST);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractCommandFile(final Command it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".commands;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.ws.rs.WebApplicationException;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Command;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractCommandName = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName, "");
    _builder.append(" extends Command<");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "");
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<EventOnOutcome> _eventsOnOutcome = it.getEventsOnOutcome();
      for(final EventOnOutcome eventOnOutcome : _eventsOnOutcome) {
        _builder.append("\t");
        _builder.append("protected static final String ");
        String _outcome = eventOnOutcome.getOutcome();
        _builder.append(_outcome, "\t");
        _builder.append(" = \"");
        String _outcome_1 = eventOnOutcome.getOutcome();
        _builder.append(_outcome_1, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractCommandName_1 = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName_1, "\t");
    _builder.append("(");
    Data _data_2 = it.getData();
    String _dataParamType_1 = this._dataExtension.dataParamType(_data_2);
    _builder.append(_dataParamType_1, "\t");
    _builder.append(" commandParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _commandName = this._commandExtension.commandName(it);
    _builder.append(_commandName, "\t\t");
    _builder.append("\", commandParam, databaseHandle);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void publishEvents() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (this.outcome) {");
    _builder.newLine();
    {
      EList<EventOnOutcome> _eventsOnOutcome_1 = it.getEventsOnOutcome();
      for(final EventOnOutcome eventOnOutcome_1 : _eventsOnOutcome_1) {
        _builder.append("\t\t");
        _builder.append("case ");
        String _outcome_2 = eventOnOutcome_1.getOutcome();
        _builder.append(_outcome_2, "\t\t");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        {
          EList<Event> _events = eventOnOutcome_1.getEvents();
          for(final Event event : _events) {
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("new ");
            String _eventNameWithPackage = this._eventExtension.eventNameWithPackage(event);
            _builder.append(_eventNameWithPackage, "\t\t\t");
            _builder.append("(this.commandData, databaseHandle).publish();");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EList<Action> _actions = eventOnOutcome_1.getActions();
          for(final Action action : _actions) {
            _builder.append("\t\t");
            _builder.append("\t");
            String _newAction = this._actionExtension.newAction(action);
            _builder.append(_newAction, "\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("Thread actionThread = new Thread(new Runnable() {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("public void run() {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("action.apply();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("});");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("actionThread.start();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("break;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new WebApplicationException(\"unhandled outcome \" + outcome);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void throwUnauthorized() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new WebApplicationException(Response.Status.UNAUTHORIZED);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void throwBadRequest() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new WebApplicationException(Response.Status.BAD_REQUEST);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAbstractEventFile(final Event it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".events;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.Event;");
    _builder.newLine();
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public abstract class ");
    String _abstractEventName = this._eventExtension.abstractEventName(it);
    _builder.append(_abstractEventName, "");
    _builder.append(" extends Event<");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "");
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractEventName_1 = this._eventExtension.abstractEventName(it);
    _builder.append(_abstractEventName_1, "\t");
    _builder.append("(");
    Data _data_2 = it.getData();
    String _dataParamType_1 = this._dataExtension.dataParamType(_data_2);
    _builder.append(_dataParamType_1, "\t");
    _builder.append(" eventParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _eventName = this._eventExtension.eventName(it);
    _builder.append(_eventName, "\t\t");
    _builder.append("\", eventParam, databaseHandle);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialActionFile(final Action it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".actions;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.annotation.security.PermitAll;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Consumes;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.POST;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.PUT;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.DELETE;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.GET;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Path;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.Produces;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.MediaType;");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.Response;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.codahale.metrics.annotation.Timed;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.core.JsonProcessingException;");
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.DBI;");
    _builder.newLine();
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@Path(\"/");
    Data _data_1 = it.getData();
    String _name_1 = _data_1.getName();
    _builder.append(_name_1, "");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    {
      if (((!Objects.equal(it.getType(), null)) && Objects.equal(it.getType(), "POST"))) {
        _builder.append("@Produces(MediaType.TEXT_PLAIN)");
      } else {
        _builder.append("@Produces(MediaType.APPLICATION_JSON)");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public class ");
    String _actionName = this._actionExtension.actionName(it);
    _builder.append(_actionName, "\t");
    _builder.append(" extends ");
    String _abstractActionName = this._actionExtension.abstractActionName(it);
    _builder.append(_abstractActionName, "\t");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _actionName_1 = this._actionExtension.actionName(it);
    _builder.append(_actionName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _actionName_2 = this._actionExtension.actionName(it);
    _builder.append(_actionName_2, "\t");
    _builder.append("(DBI jdbi) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(jdbi);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    {
      String _type = it.getType();
      boolean _notEquals = (!Objects.equal(_type, null));
      if (_notEquals) {
        _builder.append("@");
        String _type_1 = it.getType();
        _builder.append(_type_1, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Timed");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Path(\"/");
    {
      String _type_2 = it.getType();
      boolean _notEquals_1 = (!Objects.equal(_type_2, null));
      if (_notEquals_1) {
        String _type_3 = it.getType();
        String _lowerCase = _type_3.toLowerCase();
        _builder.append(_lowerCase, "\t");
      } else {
        String _resourceName = this._actionExtension.resourceName(it);
        String _lowerCase_1 = _resourceName.toLowerCase();
        _builder.append(_lowerCase_1, "\t");
      }
    }
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@PermitAll");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Response ");
    {
      String _type_4 = it.getType();
      boolean _notEquals_2 = (!Objects.equal(_type_4, null));
      if (_notEquals_2) {
        String _type_5 = it.getType();
        String _lowerCase_2 = _type_5.toLowerCase();
        _builder.append(_lowerCase_2, "\t");
      } else {
        String _resourceName_1 = this._actionExtension.resourceName(it);
        String _firstLower = StringExtensions.toFirstLower(_resourceName_1);
        _builder.append(_firstLower, "\t");
      }
    }
    _builder.append("() throws JsonProcessingException {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this.actionData = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.apply();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      String _type_6 = it.getType();
      boolean _equals = _type_6.equals("GET");
      if (_equals) {
        _builder.append("\t");
        _builder.append("protected final void loadDataForGetRequest() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialCommandFile(final Command it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".commands;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _commandName = this._commandExtension.commandName(it);
    _builder.append(_commandName, "");
    _builder.append(" extends ");
    String _abstractCommandName = this._commandExtension.abstractCommandName(it);
    _builder.append(_abstractCommandName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _commandName_1 = this._commandExtension.commandName(it);
    _builder.append(_commandName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _commandName_2 = this._commandExtension.commandName(it);
    _builder.append(_commandName_2, "\t");
    _builder.append("(");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "\t");
    _builder.append(" commandParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(commandParam, databaseHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void executeCommand() {");
    _builder.newLine();
    {
      EList<EventOnOutcome> _eventsOnOutcome = it.getEventsOnOutcome();
      int _size = _eventsOnOutcome.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("\t\t");
        _builder.append("this.outcome = ");
        EList<EventOnOutcome> _eventsOnOutcome_1 = it.getEventsOnOutcome();
        EventOnOutcome _get = _eventsOnOutcome_1.get(0);
        String _outcome = _get.getOutcome();
        _builder.append(_outcome, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInitialEventFile(final Event it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".events;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.DatabaseHandle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    Data _data = it.getData();
    String _dataImport = this._dataExtension.dataImport(_data);
    _builder.append(_dataImport, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _eventName = this._eventExtension.eventName(it);
    _builder.append(_eventName, "");
    _builder.append(" extends ");
    String _abstractEventName = this._eventExtension.abstractEventName(it);
    _builder.append(_abstractEventName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final Logger LOG = LoggerFactory.getLogger(");
    String _eventName_1 = this._eventExtension.eventName(it);
    _builder.append(_eventName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _eventName_2 = this._eventExtension.eventName(it);
    _builder.append(_eventName_2, "\t");
    _builder.append("(");
    Data _data_1 = it.getData();
    String _dataParamType = this._dataExtension.dataParamType(_data_1);
    _builder.append(_dataParamType, "\t");
    _builder.append(" eventParam, DatabaseHandle databaseHandle) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(eventParam, databaseHandle);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void prepareDataForView() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.eventData = this.eventParam;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*       S.D.G.       */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateView(final View it, final Project project) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = project.getName();
    _builder.append(_name, "");
    _builder.append(".views;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.function.BiConsumer;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.Handle;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.IDataContainer;");
    _builder.newLine();
    {
      EList<ViewFunction> _renderFunctions = it.getRenderFunctions();
      for(final ViewFunction renderFunction : _renderFunctions) {
        Data _data = renderFunction.getData();
        String _dataImport = this._dataExtension.dataImport(_data);
        _builder.append(_dataImport, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    String _viewName = this._viewExtension.viewName(it);
    _builder.append(_viewName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<ViewFunction> _renderFunctions_1 = it.getRenderFunctions();
      for(final ViewFunction renderFunction_1 : _renderFunctions_1) {
        _builder.append("\t");
        _builder.append("public BiConsumer<");
        Data _data_1 = renderFunction_1.getData();
        String _dataName = this._dataExtension.dataName(_data_1);
        _builder.append(_dataName, "\t");
        _builder.append(", Handle> ");
        String _name_1 = renderFunction_1.getName();
        _builder.append(_name_1, "\t");
        _builder.append(" = (dataContainer, handle) -> {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("};");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*                    S.D.G.                    */");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAppRegistration(final Project it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import io.dropwizard.setup.Environment;");
    _builder.newLine();
    _builder.append("import com.anfelisa.ace.AceController;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.skife.jdbi.v2.DBI;");
    _builder.newLine();
    _builder.newLine();
    {
      EList<View> _views = it.getViews();
      int _size = _views.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("import ");
        String _name_1 = it.getName();
        _builder.append(_name_1, "");
        _builder.append(".views.*;");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Action> _actions = it.getActions();
      int _size_1 = _actions.size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("import ");
        String _name_2 = it.getName();
        _builder.append(_name_2, "");
        _builder.append(".actions.*;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class AppRegistration {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void registerResources(Environment environment, DBI jdbi) {");
    _builder.newLine();
    {
      EList<Action> _actions_1 = it.getActions();
      for(final Action action : _actions_1) {
        _builder.append("\t\t");
        _builder.append("environment.jersey().register(new ");
        String _actionName = this._actionExtension.actionName(action);
        _builder.append(_actionName, "\t\t");
        _builder.append("(jdbi));");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void registerConsumers() {");
    _builder.newLine();
    {
      EList<View> _views_1 = it.getViews();
      for(final View view : _views_1) {
        _builder.append("\t\t");
        String _viewName = this._viewExtension.viewName(view);
        _builder.append(_viewName, "\t\t");
        _builder.append(" ");
        String _viewNameAsVariable = this._viewExtension.viewNameAsVariable(view);
        _builder.append(_viewNameAsVariable, "\t\t");
        _builder.append(" = new ");
        String _viewName_1 = this._viewExtension.viewName(view);
        _builder.append(_viewName_1, "\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    {
      EList<Event> _events = it.getEvents();
      for(final Event event : _events) {
        {
          EList<ViewFunction> _listeners = event.getListeners();
          for(final ViewFunction renderFunction : _listeners) {
            _builder.append("\t\t");
            _builder.append("AceController.addConsumer(\"");
            String _eventName = this._eventExtension.eventName(event);
            _builder.append(_eventName, "\t\t");
            _builder.append("\", ");
            String _viewFunctionWithViewNameAsVariable = this._viewExtension.viewFunctionWithViewNameAsVariable(renderFunction);
            _builder.append(_viewFunctionWithViewNameAsVariable, "\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*                    S.D.G.                    */");
    _builder.newLine();
    return _builder;
  }
}
