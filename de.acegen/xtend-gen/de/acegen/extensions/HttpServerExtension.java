package de.acegen.extensions;

import de.acegen.aceGen.HttpServerAce;
import de.acegen.aceGen.HttpServerAceWrite;

@SuppressWarnings("all")
public class HttpServerExtension {
  public Boolean isMulitpartFormData(final HttpServerAce it) {
    return Boolean.valueOf(((it instanceof HttpServerAceWrite) && ((HttpServerAceWrite) it).isMultipartFormData()));
  }
}
