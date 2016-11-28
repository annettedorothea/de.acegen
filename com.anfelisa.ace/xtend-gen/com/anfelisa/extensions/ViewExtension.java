package com.anfelisa.extensions;

@SuppressWarnings("all")
public class ViewExtension {
  public String viewName(final /* View */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field name is undefined"
      + "\ntoFirstUpper cannot be resolved");
  }
  
  public String viewNameAsVariable(final /* View */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field name is undefined"
      + "\ntoFirstLower cannot be resolved");
  }
  
  public String viewFunctionWithViewName(final /* ViewFunction */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nView cannot be resolved to a type."
      + "\nThe method or field name is undefined"
      + "\neContainer cannot be resolved"
      + "\nviewName cannot be resolved");
  }
  
  public String viewFunctionWithViewNameAsVariable(final /* ViewFunction */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nView cannot be resolved to a type."
      + "\nThe method or field name is undefined"
      + "\neContainer cannot be resolved"
      + "\nviewName cannot be resolved"
      + "\ntoFirstLower cannot be resolved");
  }
}
