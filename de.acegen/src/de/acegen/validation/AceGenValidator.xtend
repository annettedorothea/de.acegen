/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
 

package de.acegen.validation

import de.acegen.aceGen.AceGenPackage
import org.eclipse.xtext.validation.Check
import de.acegen.aceGen.HttpServerAce

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class AceGenValidator extends AbstractAceGenValidator {
	
	@Check
    def void checkNameStartsWithCapital(HttpServerAce ace) {
    	if ("GET".equals(ace.getType) && ace.response.size == 0) {
    		warning('GET request should have a response', 
					AceGenPackage.Literals.HTTP_SERVER__NAME)
    	}
    }
	
}
	
	
/******* S.D.G. *******/
	
	
