package de.acegen.extensions.java;

import de.acegen.aceGen.Attribute;
import de.acegen.aceGen.HttpServer;
import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceWrite;
import de.acegen.aceGen.Model;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class EcoreExtension {
  public HttpServer parent(final Model it) {
    EObject _eContainer = it.eContainer();
    return ((HttpServer) _eContainer);
  }

  public Model parent(final Attribute it) {
    EObject _eContainer = it.eContainer();
    return ((Model) _eContainer);
  }

  public HttpServer parent(final HttpServerAce it) {
    EObject _eContainer = it.eContainer();
    return ((HttpServer) _eContainer);
  }

  public Boolean isMulitpartFormData(final HttpServerAce it) {
    return Boolean.valueOf(((it instanceof HttpServerAceWrite) && ((HttpServerAceWrite) it).isMultipartFormData()));
  }
}
