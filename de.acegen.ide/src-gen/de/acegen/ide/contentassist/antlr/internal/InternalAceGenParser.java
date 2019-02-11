package de.acegen.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import de.acegen.services.AceGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAceGenParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'GET'", "'set'", "'merge'", "'reset'", "'init'", "'POST'", "'PUT'", "'DELETE'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'Long'", "'NotEmpty'", "'NotNull'", "'HttpClient'", "'HttpServer'", "'ACE'", "'appState'", "'<'", "'>'", "','", "'call'", "'loadingFlag'", "'on'", "'('", "')'", "'triggers'", "'|'", "':'", "'{'", "'}'", "'Authorization'", "'import'", "'views'", "'models'", "'pathParams'", "'queryParams'", "'payload'", "'response'", "'extends'", "'references'", "'.'", "'list'", "'location.hash'", "'storage'", "'proxy'", "'authorize'", "'persistent'", "'Unique'", "'PrimaryKey'", "'List'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalAceGenParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAceGenParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAceGenParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAceGen.g"; }


    	private AceGenGrammarAccess grammarAccess;

    	public void setGrammarAccess(AceGenGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleProject"
    // InternalAceGen.g:53:1: entryRuleProject : ruleProject EOF ;
    public final void entryRuleProject() throws RecognitionException {
        try {
            // InternalAceGen.g:54:1: ( ruleProject EOF )
            // InternalAceGen.g:55:1: ruleProject EOF
            {
             before(grammarAccess.getProjectRule()); 
            pushFollow(FOLLOW_1);
            ruleProject();

            state._fsp--;

             after(grammarAccess.getProjectRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalAceGen.g:62:1: ruleProject : ( ( rule__Project__Alternatives ) ) ;
    public final void ruleProject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:66:2: ( ( ( rule__Project__Alternatives ) ) )
            // InternalAceGen.g:67:2: ( ( rule__Project__Alternatives ) )
            {
            // InternalAceGen.g:67:2: ( ( rule__Project__Alternatives ) )
            // InternalAceGen.g:68:3: ( rule__Project__Alternatives )
            {
             before(grammarAccess.getProjectAccess().getAlternatives()); 
            // InternalAceGen.g:69:3: ( rule__Project__Alternatives )
            // InternalAceGen.g:69:4: rule__Project__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Project__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getProjectAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleHttpClient"
    // InternalAceGen.g:78:1: entryRuleHttpClient : ruleHttpClient EOF ;
    public final void entryRuleHttpClient() throws RecognitionException {
        try {
            // InternalAceGen.g:79:1: ( ruleHttpClient EOF )
            // InternalAceGen.g:80:1: ruleHttpClient EOF
            {
             before(grammarAccess.getHttpClientRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpClient();

            state._fsp--;

             after(grammarAccess.getHttpClientRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpClient"


    // $ANTLR start "ruleHttpClient"
    // InternalAceGen.g:87:1: ruleHttpClient : ( ( rule__HttpClient__Group__0 ) ) ;
    public final void ruleHttpClient() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:91:2: ( ( ( rule__HttpClient__Group__0 ) ) )
            // InternalAceGen.g:92:2: ( ( rule__HttpClient__Group__0 ) )
            {
            // InternalAceGen.g:92:2: ( ( rule__HttpClient__Group__0 ) )
            // InternalAceGen.g:93:3: ( rule__HttpClient__Group__0 )
            {
             before(grammarAccess.getHttpClientAccess().getGroup()); 
            // InternalAceGen.g:94:3: ( rule__HttpClient__Group__0 )
            // InternalAceGen.g:94:4: rule__HttpClient__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpClient__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpClient"


    // $ANTLR start "entryRuleHttpClientAce"
    // InternalAceGen.g:103:1: entryRuleHttpClientAce : ruleHttpClientAce EOF ;
    public final void entryRuleHttpClientAce() throws RecognitionException {
        try {
            // InternalAceGen.g:104:1: ( ruleHttpClientAce EOF )
            // InternalAceGen.g:105:1: ruleHttpClientAce EOF
            {
             before(grammarAccess.getHttpClientAceRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpClientAce();

            state._fsp--;

             after(grammarAccess.getHttpClientAceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpClientAce"


    // $ANTLR start "ruleHttpClientAce"
    // InternalAceGen.g:112:1: ruleHttpClientAce : ( ( rule__HttpClientAce__Group__0 ) ) ;
    public final void ruleHttpClientAce() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:116:2: ( ( ( rule__HttpClientAce__Group__0 ) ) )
            // InternalAceGen.g:117:2: ( ( rule__HttpClientAce__Group__0 ) )
            {
            // InternalAceGen.g:117:2: ( ( rule__HttpClientAce__Group__0 ) )
            // InternalAceGen.g:118:3: ( rule__HttpClientAce__Group__0 )
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup()); 
            // InternalAceGen.g:119:3: ( rule__HttpClientAce__Group__0 )
            // InternalAceGen.g:119:4: rule__HttpClientAce__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpClientAce"


    // $ANTLR start "entryRuleHttpClientOutcome"
    // InternalAceGen.g:128:1: entryRuleHttpClientOutcome : ruleHttpClientOutcome EOF ;
    public final void entryRuleHttpClientOutcome() throws RecognitionException {
        try {
            // InternalAceGen.g:129:1: ( ruleHttpClientOutcome EOF )
            // InternalAceGen.g:130:1: ruleHttpClientOutcome EOF
            {
             before(grammarAccess.getHttpClientOutcomeRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpClientOutcome();

            state._fsp--;

             after(grammarAccess.getHttpClientOutcomeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpClientOutcome"


    // $ANTLR start "ruleHttpClientOutcome"
    // InternalAceGen.g:137:1: ruleHttpClientOutcome : ( ( rule__HttpClientOutcome__Group__0 ) ) ;
    public final void ruleHttpClientOutcome() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:141:2: ( ( ( rule__HttpClientOutcome__Group__0 ) ) )
            // InternalAceGen.g:142:2: ( ( rule__HttpClientOutcome__Group__0 ) )
            {
            // InternalAceGen.g:142:2: ( ( rule__HttpClientOutcome__Group__0 ) )
            // InternalAceGen.g:143:3: ( rule__HttpClientOutcome__Group__0 )
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getGroup()); 
            // InternalAceGen.g:144:3: ( rule__HttpClientOutcome__Group__0 )
            // InternalAceGen.g:144:4: rule__HttpClientOutcome__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientOutcomeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpClientOutcome"


    // $ANTLR start "entryRuleHttpClientStateFunction"
    // InternalAceGen.g:153:1: entryRuleHttpClientStateFunction : ruleHttpClientStateFunction EOF ;
    public final void entryRuleHttpClientStateFunction() throws RecognitionException {
        try {
            // InternalAceGen.g:154:1: ( ruleHttpClientStateFunction EOF )
            // InternalAceGen.g:155:1: ruleHttpClientStateFunction EOF
            {
             before(grammarAccess.getHttpClientStateFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpClientStateFunction();

            state._fsp--;

             after(grammarAccess.getHttpClientStateFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpClientStateFunction"


    // $ANTLR start "ruleHttpClientStateFunction"
    // InternalAceGen.g:162:1: ruleHttpClientStateFunction : ( ( rule__HttpClientStateFunction__Group__0 ) ) ;
    public final void ruleHttpClientStateFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:166:2: ( ( ( rule__HttpClientStateFunction__Group__0 ) ) )
            // InternalAceGen.g:167:2: ( ( rule__HttpClientStateFunction__Group__0 ) )
            {
            // InternalAceGen.g:167:2: ( ( rule__HttpClientStateFunction__Group__0 ) )
            // InternalAceGen.g:168:3: ( rule__HttpClientStateFunction__Group__0 )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getGroup()); 
            // InternalAceGen.g:169:3: ( rule__HttpClientStateFunction__Group__0 )
            // InternalAceGen.g:169:4: rule__HttpClientStateFunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateFunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientStateFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpClientStateFunction"


    // $ANTLR start "entryRuleHttpClientStateFunctionType"
    // InternalAceGen.g:178:1: entryRuleHttpClientStateFunctionType : ruleHttpClientStateFunctionType EOF ;
    public final void entryRuleHttpClientStateFunctionType() throws RecognitionException {
        try {
            // InternalAceGen.g:179:1: ( ruleHttpClientStateFunctionType EOF )
            // InternalAceGen.g:180:1: ruleHttpClientStateFunctionType EOF
            {
             before(grammarAccess.getHttpClientStateFunctionTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpClientStateFunctionType();

            state._fsp--;

             after(grammarAccess.getHttpClientStateFunctionTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpClientStateFunctionType"


    // $ANTLR start "ruleHttpClientStateFunctionType"
    // InternalAceGen.g:187:1: ruleHttpClientStateFunctionType : ( ( rule__HttpClientStateFunctionType__Alternatives ) ) ;
    public final void ruleHttpClientStateFunctionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:191:2: ( ( ( rule__HttpClientStateFunctionType__Alternatives ) ) )
            // InternalAceGen.g:192:2: ( ( rule__HttpClientStateFunctionType__Alternatives ) )
            {
            // InternalAceGen.g:192:2: ( ( rule__HttpClientStateFunctionType__Alternatives ) )
            // InternalAceGen.g:193:3: ( rule__HttpClientStateFunctionType__Alternatives )
            {
             before(grammarAccess.getHttpClientStateFunctionTypeAccess().getAlternatives()); 
            // InternalAceGen.g:194:3: ( rule__HttpClientStateFunctionType__Alternatives )
            // InternalAceGen.g:194:4: rule__HttpClientStateFunctionType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateFunctionType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientStateFunctionTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpClientStateFunctionType"


    // $ANTLR start "entryRuleHttpClientStateElement"
    // InternalAceGen.g:203:1: entryRuleHttpClientStateElement : ruleHttpClientStateElement EOF ;
    public final void entryRuleHttpClientStateElement() throws RecognitionException {
        try {
            // InternalAceGen.g:204:1: ( ruleHttpClientStateElement EOF )
            // InternalAceGen.g:205:1: ruleHttpClientStateElement EOF
            {
             before(grammarAccess.getHttpClientStateElementRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpClientStateElement();

            state._fsp--;

             after(grammarAccess.getHttpClientStateElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpClientStateElement"


    // $ANTLR start "ruleHttpClientStateElement"
    // InternalAceGen.g:212:1: ruleHttpClientStateElement : ( ( rule__HttpClientStateElement__Group__0 ) ) ;
    public final void ruleHttpClientStateElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:216:2: ( ( ( rule__HttpClientStateElement__Group__0 ) ) )
            // InternalAceGen.g:217:2: ( ( rule__HttpClientStateElement__Group__0 ) )
            {
            // InternalAceGen.g:217:2: ( ( rule__HttpClientStateElement__Group__0 ) )
            // InternalAceGen.g:218:3: ( rule__HttpClientStateElement__Group__0 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getGroup()); 
            // InternalAceGen.g:219:3: ( rule__HttpClientStateElement__Group__0 )
            // InternalAceGen.g:219:4: rule__HttpClientStateElement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientStateElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpClientStateElement"


    // $ANTLR start "entryRuleHttpClientTypeDefinition"
    // InternalAceGen.g:228:1: entryRuleHttpClientTypeDefinition : ruleHttpClientTypeDefinition EOF ;
    public final void entryRuleHttpClientTypeDefinition() throws RecognitionException {
        try {
            // InternalAceGen.g:229:1: ( ruleHttpClientTypeDefinition EOF )
            // InternalAceGen.g:230:1: ruleHttpClientTypeDefinition EOF
            {
             before(grammarAccess.getHttpClientTypeDefinitionRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpClientTypeDefinition();

            state._fsp--;

             after(grammarAccess.getHttpClientTypeDefinitionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpClientTypeDefinition"


    // $ANTLR start "ruleHttpClientTypeDefinition"
    // InternalAceGen.g:237:1: ruleHttpClientTypeDefinition : ( ( rule__HttpClientTypeDefinition__Group__0 ) ) ;
    public final void ruleHttpClientTypeDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:241:2: ( ( ( rule__HttpClientTypeDefinition__Group__0 ) ) )
            // InternalAceGen.g:242:2: ( ( rule__HttpClientTypeDefinition__Group__0 ) )
            {
            // InternalAceGen.g:242:2: ( ( rule__HttpClientTypeDefinition__Group__0 ) )
            // InternalAceGen.g:243:3: ( rule__HttpClientTypeDefinition__Group__0 )
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getGroup()); 
            // InternalAceGen.g:244:3: ( rule__HttpClientTypeDefinition__Group__0 )
            // InternalAceGen.g:244:4: rule__HttpClientTypeDefinition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientTypeDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientTypeDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpClientTypeDefinition"


    // $ANTLR start "entryRuleHttpServer"
    // InternalAceGen.g:253:1: entryRuleHttpServer : ruleHttpServer EOF ;
    public final void entryRuleHttpServer() throws RecognitionException {
        try {
            // InternalAceGen.g:254:1: ( ruleHttpServer EOF )
            // InternalAceGen.g:255:1: ruleHttpServer EOF
            {
             before(grammarAccess.getHttpServerRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpServer();

            state._fsp--;

             after(grammarAccess.getHttpServerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpServer"


    // $ANTLR start "ruleHttpServer"
    // InternalAceGen.g:262:1: ruleHttpServer : ( ( rule__HttpServer__Group__0 ) ) ;
    public final void ruleHttpServer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:266:2: ( ( ( rule__HttpServer__Group__0 ) ) )
            // InternalAceGen.g:267:2: ( ( rule__HttpServer__Group__0 ) )
            {
            // InternalAceGen.g:267:2: ( ( rule__HttpServer__Group__0 ) )
            // InternalAceGen.g:268:3: ( rule__HttpServer__Group__0 )
            {
             before(grammarAccess.getHttpServerAccess().getGroup()); 
            // InternalAceGen.g:269:3: ( rule__HttpServer__Group__0 )
            // InternalAceGen.g:269:4: rule__HttpServer__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpServer"


    // $ANTLR start "entryRuleHttpServerAce"
    // InternalAceGen.g:278:1: entryRuleHttpServerAce : ruleHttpServerAce EOF ;
    public final void entryRuleHttpServerAce() throws RecognitionException {
        try {
            // InternalAceGen.g:279:1: ( ruleHttpServerAce EOF )
            // InternalAceGen.g:280:1: ruleHttpServerAce EOF
            {
             before(grammarAccess.getHttpServerAceRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpServerAce();

            state._fsp--;

             after(grammarAccess.getHttpServerAceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpServerAce"


    // $ANTLR start "ruleHttpServerAce"
    // InternalAceGen.g:287:1: ruleHttpServerAce : ( ( rule__HttpServerAce__Alternatives ) ) ;
    public final void ruleHttpServerAce() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:291:2: ( ( ( rule__HttpServerAce__Alternatives ) ) )
            // InternalAceGen.g:292:2: ( ( rule__HttpServerAce__Alternatives ) )
            {
            // InternalAceGen.g:292:2: ( ( rule__HttpServerAce__Alternatives ) )
            // InternalAceGen.g:293:3: ( rule__HttpServerAce__Alternatives )
            {
             before(grammarAccess.getHttpServerAceAccess().getAlternatives()); 
            // InternalAceGen.g:294:3: ( rule__HttpServerAce__Alternatives )
            // InternalAceGen.g:294:4: rule__HttpServerAce__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAce__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAceAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpServerAce"


    // $ANTLR start "entryRuleHttpServerAceWrite"
    // InternalAceGen.g:303:1: entryRuleHttpServerAceWrite : ruleHttpServerAceWrite EOF ;
    public final void entryRuleHttpServerAceWrite() throws RecognitionException {
        try {
            // InternalAceGen.g:304:1: ( ruleHttpServerAceWrite EOF )
            // InternalAceGen.g:305:1: ruleHttpServerAceWrite EOF
            {
             before(grammarAccess.getHttpServerAceWriteRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpServerAceWrite();

            state._fsp--;

             after(grammarAccess.getHttpServerAceWriteRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpServerAceWrite"


    // $ANTLR start "ruleHttpServerAceWrite"
    // InternalAceGen.g:312:1: ruleHttpServerAceWrite : ( ( rule__HttpServerAceWrite__Group__0 ) ) ;
    public final void ruleHttpServerAceWrite() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:316:2: ( ( ( rule__HttpServerAceWrite__Group__0 ) ) )
            // InternalAceGen.g:317:2: ( ( rule__HttpServerAceWrite__Group__0 ) )
            {
            // InternalAceGen.g:317:2: ( ( rule__HttpServerAceWrite__Group__0 ) )
            // InternalAceGen.g:318:3: ( rule__HttpServerAceWrite__Group__0 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup()); 
            // InternalAceGen.g:319:3: ( rule__HttpServerAceWrite__Group__0 )
            // InternalAceGen.g:319:4: rule__HttpServerAceWrite__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAceWriteAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpServerAceWrite"


    // $ANTLR start "entryRuleHttpServerOutcome"
    // InternalAceGen.g:328:1: entryRuleHttpServerOutcome : ruleHttpServerOutcome EOF ;
    public final void entryRuleHttpServerOutcome() throws RecognitionException {
        try {
            // InternalAceGen.g:329:1: ( ruleHttpServerOutcome EOF )
            // InternalAceGen.g:330:1: ruleHttpServerOutcome EOF
            {
             before(grammarAccess.getHttpServerOutcomeRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpServerOutcome();

            state._fsp--;

             after(grammarAccess.getHttpServerOutcomeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpServerOutcome"


    // $ANTLR start "ruleHttpServerOutcome"
    // InternalAceGen.g:337:1: ruleHttpServerOutcome : ( ( rule__HttpServerOutcome__Group__0 ) ) ;
    public final void ruleHttpServerOutcome() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:341:2: ( ( ( rule__HttpServerOutcome__Group__0 ) ) )
            // InternalAceGen.g:342:2: ( ( rule__HttpServerOutcome__Group__0 ) )
            {
            // InternalAceGen.g:342:2: ( ( rule__HttpServerOutcome__Group__0 ) )
            // InternalAceGen.g:343:3: ( rule__HttpServerOutcome__Group__0 )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getGroup()); 
            // InternalAceGen.g:344:3: ( rule__HttpServerOutcome__Group__0 )
            // InternalAceGen.g:344:4: rule__HttpServerOutcome__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerOutcomeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpServerOutcome"


    // $ANTLR start "entryRuleHttpServerAceRead"
    // InternalAceGen.g:353:1: entryRuleHttpServerAceRead : ruleHttpServerAceRead EOF ;
    public final void entryRuleHttpServerAceRead() throws RecognitionException {
        try {
            // InternalAceGen.g:354:1: ( ruleHttpServerAceRead EOF )
            // InternalAceGen.g:355:1: ruleHttpServerAceRead EOF
            {
             before(grammarAccess.getHttpServerAceReadRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpServerAceRead();

            state._fsp--;

             after(grammarAccess.getHttpServerAceReadRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpServerAceRead"


    // $ANTLR start "ruleHttpServerAceRead"
    // InternalAceGen.g:362:1: ruleHttpServerAceRead : ( ( rule__HttpServerAceRead__Group__0 ) ) ;
    public final void ruleHttpServerAceRead() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:366:2: ( ( ( rule__HttpServerAceRead__Group__0 ) ) )
            // InternalAceGen.g:367:2: ( ( rule__HttpServerAceRead__Group__0 ) )
            {
            // InternalAceGen.g:367:2: ( ( rule__HttpServerAceRead__Group__0 ) )
            // InternalAceGen.g:368:3: ( rule__HttpServerAceRead__Group__0 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup()); 
            // InternalAceGen.g:369:3: ( rule__HttpServerAceRead__Group__0 )
            // InternalAceGen.g:369:4: rule__HttpServerAceRead__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAceReadAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpServerAceRead"


    // $ANTLR start "entryRuleHttpServerView"
    // InternalAceGen.g:378:1: entryRuleHttpServerView : ruleHttpServerView EOF ;
    public final void entryRuleHttpServerView() throws RecognitionException {
        try {
            // InternalAceGen.g:379:1: ( ruleHttpServerView EOF )
            // InternalAceGen.g:380:1: ruleHttpServerView EOF
            {
             before(grammarAccess.getHttpServerViewRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpServerView();

            state._fsp--;

             after(grammarAccess.getHttpServerViewRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpServerView"


    // $ANTLR start "ruleHttpServerView"
    // InternalAceGen.g:387:1: ruleHttpServerView : ( ( rule__HttpServerView__Group__0 ) ) ;
    public final void ruleHttpServerView() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:391:2: ( ( ( rule__HttpServerView__Group__0 ) ) )
            // InternalAceGen.g:392:2: ( ( rule__HttpServerView__Group__0 ) )
            {
            // InternalAceGen.g:392:2: ( ( rule__HttpServerView__Group__0 ) )
            // InternalAceGen.g:393:3: ( rule__HttpServerView__Group__0 )
            {
             before(grammarAccess.getHttpServerViewAccess().getGroup()); 
            // InternalAceGen.g:394:3: ( rule__HttpServerView__Group__0 )
            // InternalAceGen.g:394:4: rule__HttpServerView__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerView__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerViewAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpServerView"


    // $ANTLR start "entryRuleHttpServerViewFunction"
    // InternalAceGen.g:403:1: entryRuleHttpServerViewFunction : ruleHttpServerViewFunction EOF ;
    public final void entryRuleHttpServerViewFunction() throws RecognitionException {
        try {
            // InternalAceGen.g:404:1: ( ruleHttpServerViewFunction EOF )
            // InternalAceGen.g:405:1: ruleHttpServerViewFunction EOF
            {
             before(grammarAccess.getHttpServerViewFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleHttpServerViewFunction();

            state._fsp--;

             after(grammarAccess.getHttpServerViewFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHttpServerViewFunction"


    // $ANTLR start "ruleHttpServerViewFunction"
    // InternalAceGen.g:412:1: ruleHttpServerViewFunction : ( ( rule__HttpServerViewFunction__Group__0 ) ) ;
    public final void ruleHttpServerViewFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:416:2: ( ( ( rule__HttpServerViewFunction__Group__0 ) ) )
            // InternalAceGen.g:417:2: ( ( rule__HttpServerViewFunction__Group__0 ) )
            {
            // InternalAceGen.g:417:2: ( ( rule__HttpServerViewFunction__Group__0 ) )
            // InternalAceGen.g:418:3: ( rule__HttpServerViewFunction__Group__0 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getGroup()); 
            // InternalAceGen.g:419:3: ( rule__HttpServerViewFunction__Group__0 )
            // InternalAceGen.g:419:4: rule__HttpServerViewFunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerViewFunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerViewFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHttpServerViewFunction"


    // $ANTLR start "entryRuleAuthUser"
    // InternalAceGen.g:428:1: entryRuleAuthUser : ruleAuthUser EOF ;
    public final void entryRuleAuthUser() throws RecognitionException {
        try {
            // InternalAceGen.g:429:1: ( ruleAuthUser EOF )
            // InternalAceGen.g:430:1: ruleAuthUser EOF
            {
             before(grammarAccess.getAuthUserRule()); 
            pushFollow(FOLLOW_1);
            ruleAuthUser();

            state._fsp--;

             after(grammarAccess.getAuthUserRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAuthUser"


    // $ANTLR start "ruleAuthUser"
    // InternalAceGen.g:437:1: ruleAuthUser : ( ( rule__AuthUser__Group__0 ) ) ;
    public final void ruleAuthUser() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:441:2: ( ( ( rule__AuthUser__Group__0 ) ) )
            // InternalAceGen.g:442:2: ( ( rule__AuthUser__Group__0 ) )
            {
            // InternalAceGen.g:442:2: ( ( rule__AuthUser__Group__0 ) )
            // InternalAceGen.g:443:3: ( rule__AuthUser__Group__0 )
            {
             before(grammarAccess.getAuthUserAccess().getGroup()); 
            // InternalAceGen.g:444:3: ( rule__AuthUser__Group__0 )
            // InternalAceGen.g:444:4: rule__AuthUser__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AuthUser__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAuthUserAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAuthUser"


    // $ANTLR start "entryRuleModel"
    // InternalAceGen.g:453:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalAceGen.g:454:1: ( ruleModel EOF )
            // InternalAceGen.g:455:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalAceGen.g:462:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:466:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalAceGen.g:467:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalAceGen.g:467:2: ( ( rule__Model__Group__0 ) )
            // InternalAceGen.g:468:3: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalAceGen.g:469:3: ( rule__Model__Group__0 )
            // InternalAceGen.g:469:4: rule__Model__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAttribute"
    // InternalAceGen.g:478:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalAceGen.g:479:1: ( ruleAttribute EOF )
            // InternalAceGen.g:480:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalAceGen.g:487:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:491:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalAceGen.g:492:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalAceGen.g:492:2: ( ( rule__Attribute__Group__0 ) )
            // InternalAceGen.g:493:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalAceGen.g:494:3: ( rule__Attribute__Group__0 )
            // InternalAceGen.g:494:4: rule__Attribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalAceGen.g:503:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalAceGen.g:504:1: ( ruleQualifiedName EOF )
            // InternalAceGen.g:505:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalAceGen.g:512:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:516:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalAceGen.g:517:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalAceGen.g:517:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalAceGen.g:518:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalAceGen.g:519:3: ( rule__QualifiedName__Group__0 )
            // InternalAceGen.g:519:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleWriteFunctionType"
    // InternalAceGen.g:528:1: entryRuleWriteFunctionType : ruleWriteFunctionType EOF ;
    public final void entryRuleWriteFunctionType() throws RecognitionException {
        try {
            // InternalAceGen.g:529:1: ( ruleWriteFunctionType EOF )
            // InternalAceGen.g:530:1: ruleWriteFunctionType EOF
            {
             before(grammarAccess.getWriteFunctionTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleWriteFunctionType();

            state._fsp--;

             after(grammarAccess.getWriteFunctionTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWriteFunctionType"


    // $ANTLR start "ruleWriteFunctionType"
    // InternalAceGen.g:537:1: ruleWriteFunctionType : ( ( rule__WriteFunctionType__Alternatives ) ) ;
    public final void ruleWriteFunctionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:541:2: ( ( ( rule__WriteFunctionType__Alternatives ) ) )
            // InternalAceGen.g:542:2: ( ( rule__WriteFunctionType__Alternatives ) )
            {
            // InternalAceGen.g:542:2: ( ( rule__WriteFunctionType__Alternatives ) )
            // InternalAceGen.g:543:3: ( rule__WriteFunctionType__Alternatives )
            {
             before(grammarAccess.getWriteFunctionTypeAccess().getAlternatives()); 
            // InternalAceGen.g:544:3: ( rule__WriteFunctionType__Alternatives )
            // InternalAceGen.g:544:4: rule__WriteFunctionType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__WriteFunctionType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getWriteFunctionTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWriteFunctionType"


    // $ANTLR start "entryRuleReadFunctionType"
    // InternalAceGen.g:553:1: entryRuleReadFunctionType : ruleReadFunctionType EOF ;
    public final void entryRuleReadFunctionType() throws RecognitionException {
        try {
            // InternalAceGen.g:554:1: ( ruleReadFunctionType EOF )
            // InternalAceGen.g:555:1: ruleReadFunctionType EOF
            {
             before(grammarAccess.getReadFunctionTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleReadFunctionType();

            state._fsp--;

             after(grammarAccess.getReadFunctionTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReadFunctionType"


    // $ANTLR start "ruleReadFunctionType"
    // InternalAceGen.g:562:1: ruleReadFunctionType : ( 'GET' ) ;
    public final void ruleReadFunctionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:566:2: ( ( 'GET' ) )
            // InternalAceGen.g:567:2: ( 'GET' )
            {
            // InternalAceGen.g:567:2: ( 'GET' )
            // InternalAceGen.g:568:3: 'GET'
            {
             before(grammarAccess.getReadFunctionTypeAccess().getGETKeyword()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getReadFunctionTypeAccess().getGETKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReadFunctionType"


    // $ANTLR start "entryRuleType"
    // InternalAceGen.g:578:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalAceGen.g:579:1: ( ruleType EOF )
            // InternalAceGen.g:580:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalAceGen.g:587:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:591:2: ( ( ( rule__Type__Alternatives ) ) )
            // InternalAceGen.g:592:2: ( ( rule__Type__Alternatives ) )
            {
            // InternalAceGen.g:592:2: ( ( rule__Type__Alternatives ) )
            // InternalAceGen.g:593:3: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // InternalAceGen.g:594:3: ( rule__Type__Alternatives )
            // InternalAceGen.g:594:4: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Type__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleConstraint"
    // InternalAceGen.g:603:1: entryRuleConstraint : ruleConstraint EOF ;
    public final void entryRuleConstraint() throws RecognitionException {
        try {
            // InternalAceGen.g:604:1: ( ruleConstraint EOF )
            // InternalAceGen.g:605:1: ruleConstraint EOF
            {
             before(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalAceGen.g:612:1: ruleConstraint : ( ( rule__Constraint__Alternatives ) ) ;
    public final void ruleConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:616:2: ( ( ( rule__Constraint__Alternatives ) ) )
            // InternalAceGen.g:617:2: ( ( rule__Constraint__Alternatives ) )
            {
            // InternalAceGen.g:617:2: ( ( rule__Constraint__Alternatives ) )
            // InternalAceGen.g:618:3: ( rule__Constraint__Alternatives )
            {
             before(grammarAccess.getConstraintAccess().getAlternatives()); 
            // InternalAceGen.g:619:3: ( rule__Constraint__Alternatives )
            // InternalAceGen.g:619:4: rule__Constraint__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "rule__Project__Alternatives"
    // InternalAceGen.g:627:1: rule__Project__Alternatives : ( ( ( rule__Project__Group_0__0 ) ) | ( ( rule__Project__Group_1__0 ) ) );
    public final void rule__Project__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:631:1: ( ( ( rule__Project__Group_0__0 ) ) | ( ( rule__Project__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==27) ) {
                alt1=1;
            }
            else if ( (LA1_0==28) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalAceGen.g:632:2: ( ( rule__Project__Group_0__0 ) )
                    {
                    // InternalAceGen.g:632:2: ( ( rule__Project__Group_0__0 ) )
                    // InternalAceGen.g:633:3: ( rule__Project__Group_0__0 )
                    {
                     before(grammarAccess.getProjectAccess().getGroup_0()); 
                    // InternalAceGen.g:634:3: ( rule__Project__Group_0__0 )
                    // InternalAceGen.g:634:4: rule__Project__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Project__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getProjectAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:638:2: ( ( rule__Project__Group_1__0 ) )
                    {
                    // InternalAceGen.g:638:2: ( ( rule__Project__Group_1__0 ) )
                    // InternalAceGen.g:639:3: ( rule__Project__Group_1__0 )
                    {
                     before(grammarAccess.getProjectAccess().getGroup_1()); 
                    // InternalAceGen.g:640:3: ( rule__Project__Group_1__0 )
                    // InternalAceGen.g:640:4: rule__Project__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Project__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getProjectAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Alternatives"


    // $ANTLR start "rule__HttpClientStateFunctionType__Alternatives"
    // InternalAceGen.g:648:1: rule__HttpClientStateFunctionType__Alternatives : ( ( 'set' ) | ( 'merge' ) | ( 'reset' ) | ( 'init' ) );
    public final void rule__HttpClientStateFunctionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:652:1: ( ( 'set' ) | ( 'merge' ) | ( 'reset' ) | ( 'init' ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt2=1;
                }
                break;
            case 13:
                {
                alt2=2;
                }
                break;
            case 14:
                {
                alt2=3;
                }
                break;
            case 15:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalAceGen.g:653:2: ( 'set' )
                    {
                    // InternalAceGen.g:653:2: ( 'set' )
                    // InternalAceGen.g:654:3: 'set'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:659:2: ( 'merge' )
                    {
                    // InternalAceGen.g:659:2: ( 'merge' )
                    // InternalAceGen.g:660:3: 'merge'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:665:2: ( 'reset' )
                    {
                    // InternalAceGen.g:665:2: ( 'reset' )
                    // InternalAceGen.g:666:3: 'reset'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getResetKeyword_2()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getResetKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:671:2: ( 'init' )
                    {
                    // InternalAceGen.g:671:2: ( 'init' )
                    // InternalAceGen.g:672:3: 'init'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getInitKeyword_3()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getInitKeyword_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateFunctionType__Alternatives"


    // $ANTLR start "rule__HttpServerAce__Alternatives"
    // InternalAceGen.g:681:1: rule__HttpServerAce__Alternatives : ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) );
    public final void rule__HttpServerAce__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:685:1: ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalAceGen.g:686:2: ( ruleHttpServerAceWrite )
                    {
                    // InternalAceGen.g:686:2: ( ruleHttpServerAceWrite )
                    // InternalAceGen.g:687:3: ruleHttpServerAceWrite
                    {
                     before(grammarAccess.getHttpServerAceAccess().getHttpServerAceWriteParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleHttpServerAceWrite();

                    state._fsp--;

                     after(grammarAccess.getHttpServerAceAccess().getHttpServerAceWriteParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:692:2: ( ruleHttpServerAceRead )
                    {
                    // InternalAceGen.g:692:2: ( ruleHttpServerAceRead )
                    // InternalAceGen.g:693:3: ruleHttpServerAceRead
                    {
                     before(grammarAccess.getHttpServerAceAccess().getHttpServerAceReadParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleHttpServerAceRead();

                    state._fsp--;

                     after(grammarAccess.getHttpServerAceAccess().getHttpServerAceReadParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAce__Alternatives"


    // $ANTLR start "rule__Attribute__Alternatives_4"
    // InternalAceGen.g:702:1: rule__Attribute__Alternatives_4 : ( ( ( rule__Attribute__TypeAssignment_4_0 ) ) | ( ( rule__Attribute__ModelAssignment_4_1 ) ) );
    public final void rule__Attribute__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:706:1: ( ( ( rule__Attribute__TypeAssignment_4_0 ) ) | ( ( rule__Attribute__ModelAssignment_4_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=19 && LA4_0<=24)) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalAceGen.g:707:2: ( ( rule__Attribute__TypeAssignment_4_0 ) )
                    {
                    // InternalAceGen.g:707:2: ( ( rule__Attribute__TypeAssignment_4_0 ) )
                    // InternalAceGen.g:708:3: ( rule__Attribute__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getAttributeAccess().getTypeAssignment_4_0()); 
                    // InternalAceGen.g:709:3: ( rule__Attribute__TypeAssignment_4_0 )
                    // InternalAceGen.g:709:4: rule__Attribute__TypeAssignment_4_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__TypeAssignment_4_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttributeAccess().getTypeAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:713:2: ( ( rule__Attribute__ModelAssignment_4_1 ) )
                    {
                    // InternalAceGen.g:713:2: ( ( rule__Attribute__ModelAssignment_4_1 ) )
                    // InternalAceGen.g:714:3: ( rule__Attribute__ModelAssignment_4_1 )
                    {
                     before(grammarAccess.getAttributeAccess().getModelAssignment_4_1()); 
                    // InternalAceGen.g:715:3: ( rule__Attribute__ModelAssignment_4_1 )
                    // InternalAceGen.g:715:4: rule__Attribute__ModelAssignment_4_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__ModelAssignment_4_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttributeAccess().getModelAssignment_4_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Alternatives_4"


    // $ANTLR start "rule__WriteFunctionType__Alternatives"
    // InternalAceGen.g:723:1: rule__WriteFunctionType__Alternatives : ( ( 'POST' ) | ( 'PUT' ) | ( 'DELETE' ) );
    public final void rule__WriteFunctionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:727:1: ( ( 'POST' ) | ( 'PUT' ) | ( 'DELETE' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt5=1;
                }
                break;
            case 17:
                {
                alt5=2;
                }
                break;
            case 18:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalAceGen.g:728:2: ( 'POST' )
                    {
                    // InternalAceGen.g:728:2: ( 'POST' )
                    // InternalAceGen.g:729:3: 'POST'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:734:2: ( 'PUT' )
                    {
                    // InternalAceGen.g:734:2: ( 'PUT' )
                    // InternalAceGen.g:735:3: 'PUT'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:740:2: ( 'DELETE' )
                    {
                    // InternalAceGen.g:740:2: ( 'DELETE' )
                    // InternalAceGen.g:741:3: 'DELETE'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getDELETEKeyword_2()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getWriteFunctionTypeAccess().getDELETEKeyword_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WriteFunctionType__Alternatives"


    // $ANTLR start "rule__Type__Alternatives"
    // InternalAceGen.g:750:1: rule__Type__Alternatives : ( ( 'Integer' ) | ( 'String' ) | ( 'Float' ) | ( 'Boolean' ) | ( 'DateTime' ) | ( 'Long' ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:754:1: ( ( 'Integer' ) | ( 'String' ) | ( 'Float' ) | ( 'Boolean' ) | ( 'DateTime' ) | ( 'Long' ) )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt6=1;
                }
                break;
            case 20:
                {
                alt6=2;
                }
                break;
            case 21:
                {
                alt6=3;
                }
                break;
            case 22:
                {
                alt6=4;
                }
                break;
            case 23:
                {
                alt6=5;
                }
                break;
            case 24:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalAceGen.g:755:2: ( 'Integer' )
                    {
                    // InternalAceGen.g:755:2: ( 'Integer' )
                    // InternalAceGen.g:756:3: 'Integer'
                    {
                     before(grammarAccess.getTypeAccess().getIntegerKeyword_0()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getIntegerKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:761:2: ( 'String' )
                    {
                    // InternalAceGen.g:761:2: ( 'String' )
                    // InternalAceGen.g:762:3: 'String'
                    {
                     before(grammarAccess.getTypeAccess().getStringKeyword_1()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getStringKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:767:2: ( 'Float' )
                    {
                    // InternalAceGen.g:767:2: ( 'Float' )
                    // InternalAceGen.g:768:3: 'Float'
                    {
                     before(grammarAccess.getTypeAccess().getFloatKeyword_2()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getFloatKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:773:2: ( 'Boolean' )
                    {
                    // InternalAceGen.g:773:2: ( 'Boolean' )
                    // InternalAceGen.g:774:3: 'Boolean'
                    {
                     before(grammarAccess.getTypeAccess().getBooleanKeyword_3()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getBooleanKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalAceGen.g:779:2: ( 'DateTime' )
                    {
                    // InternalAceGen.g:779:2: ( 'DateTime' )
                    // InternalAceGen.g:780:3: 'DateTime'
                    {
                     before(grammarAccess.getTypeAccess().getDateTimeKeyword_4()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getDateTimeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalAceGen.g:785:2: ( 'Long' )
                    {
                    // InternalAceGen.g:785:2: ( 'Long' )
                    // InternalAceGen.g:786:3: 'Long'
                    {
                     before(grammarAccess.getTypeAccess().getLongKeyword_5()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getLongKeyword_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Type__Alternatives"


    // $ANTLR start "rule__Constraint__Alternatives"
    // InternalAceGen.g:795:1: rule__Constraint__Alternatives : ( ( 'NotEmpty' ) | ( 'NotNull' ) );
    public final void rule__Constraint__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:799:1: ( ( 'NotEmpty' ) | ( 'NotNull' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==25) ) {
                alt7=1;
            }
            else if ( (LA7_0==26) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalAceGen.g:800:2: ( 'NotEmpty' )
                    {
                    // InternalAceGen.g:800:2: ( 'NotEmpty' )
                    // InternalAceGen.g:801:3: 'NotEmpty'
                    {
                     before(grammarAccess.getConstraintAccess().getNotEmptyKeyword_0()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getConstraintAccess().getNotEmptyKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:806:2: ( 'NotNull' )
                    {
                    // InternalAceGen.g:806:2: ( 'NotNull' )
                    // InternalAceGen.g:807:3: 'NotNull'
                    {
                     before(grammarAccess.getConstraintAccess().getNotNullKeyword_1()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getConstraintAccess().getNotNullKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Alternatives"


    // $ANTLR start "rule__Project__Group_0__0"
    // InternalAceGen.g:816:1: rule__Project__Group_0__0 : rule__Project__Group_0__0__Impl rule__Project__Group_0__1 ;
    public final void rule__Project__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:820:1: ( rule__Project__Group_0__0__Impl rule__Project__Group_0__1 )
            // InternalAceGen.g:821:2: rule__Project__Group_0__0__Impl rule__Project__Group_0__1
            {
            pushFollow(FOLLOW_3);
            rule__Project__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_0__0"


    // $ANTLR start "rule__Project__Group_0__0__Impl"
    // InternalAceGen.g:828:1: rule__Project__Group_0__0__Impl : ( () ) ;
    public final void rule__Project__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:832:1: ( ( () ) )
            // InternalAceGen.g:833:1: ( () )
            {
            // InternalAceGen.g:833:1: ( () )
            // InternalAceGen.g:834:2: ()
            {
             before(grammarAccess.getProjectAccess().getProjectAction_0_0()); 
            // InternalAceGen.g:835:2: ()
            // InternalAceGen.g:835:3: 
            {
            }

             after(grammarAccess.getProjectAccess().getProjectAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_0__0__Impl"


    // $ANTLR start "rule__Project__Group_0__1"
    // InternalAceGen.g:843:1: rule__Project__Group_0__1 : rule__Project__Group_0__1__Impl rule__Project__Group_0__2 ;
    public final void rule__Project__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:847:1: ( rule__Project__Group_0__1__Impl rule__Project__Group_0__2 )
            // InternalAceGen.g:848:2: rule__Project__Group_0__1__Impl rule__Project__Group_0__2
            {
            pushFollow(FOLLOW_4);
            rule__Project__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_0__1"


    // $ANTLR start "rule__Project__Group_0__1__Impl"
    // InternalAceGen.g:855:1: rule__Project__Group_0__1__Impl : ( 'HttpClient' ) ;
    public final void rule__Project__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:859:1: ( ( 'HttpClient' ) )
            // InternalAceGen.g:860:1: ( 'HttpClient' )
            {
            // InternalAceGen.g:860:1: ( 'HttpClient' )
            // InternalAceGen.g:861:2: 'HttpClient'
            {
             before(grammarAccess.getProjectAccess().getHttpClientKeyword_0_1()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getHttpClientKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_0__1__Impl"


    // $ANTLR start "rule__Project__Group_0__2"
    // InternalAceGen.g:870:1: rule__Project__Group_0__2 : rule__Project__Group_0__2__Impl ;
    public final void rule__Project__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:874:1: ( rule__Project__Group_0__2__Impl )
            // InternalAceGen.g:875:2: rule__Project__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_0__2"


    // $ANTLR start "rule__Project__Group_0__2__Impl"
    // InternalAceGen.g:881:1: rule__Project__Group_0__2__Impl : ( ( rule__Project__HttpClientAssignment_0_2 )? ) ;
    public final void rule__Project__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:885:1: ( ( ( rule__Project__HttpClientAssignment_0_2 )? ) )
            // InternalAceGen.g:886:1: ( ( rule__Project__HttpClientAssignment_0_2 )? )
            {
            // InternalAceGen.g:886:1: ( ( rule__Project__HttpClientAssignment_0_2 )? )
            // InternalAceGen.g:887:2: ( rule__Project__HttpClientAssignment_0_2 )?
            {
             before(grammarAccess.getProjectAccess().getHttpClientAssignment_0_2()); 
            // InternalAceGen.g:888:2: ( rule__Project__HttpClientAssignment_0_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalAceGen.g:888:3: rule__Project__HttpClientAssignment_0_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Project__HttpClientAssignment_0_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProjectAccess().getHttpClientAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_0__2__Impl"


    // $ANTLR start "rule__Project__Group_1__0"
    // InternalAceGen.g:897:1: rule__Project__Group_1__0 : rule__Project__Group_1__0__Impl rule__Project__Group_1__1 ;
    public final void rule__Project__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:901:1: ( rule__Project__Group_1__0__Impl rule__Project__Group_1__1 )
            // InternalAceGen.g:902:2: rule__Project__Group_1__0__Impl rule__Project__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__Project__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_1__0"


    // $ANTLR start "rule__Project__Group_1__0__Impl"
    // InternalAceGen.g:909:1: rule__Project__Group_1__0__Impl : ( 'HttpServer' ) ;
    public final void rule__Project__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:913:1: ( ( 'HttpServer' ) )
            // InternalAceGen.g:914:1: ( 'HttpServer' )
            {
            // InternalAceGen.g:914:1: ( 'HttpServer' )
            // InternalAceGen.g:915:2: 'HttpServer'
            {
             before(grammarAccess.getProjectAccess().getHttpServerKeyword_1_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getHttpServerKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_1__0__Impl"


    // $ANTLR start "rule__Project__Group_1__1"
    // InternalAceGen.g:924:1: rule__Project__Group_1__1 : rule__Project__Group_1__1__Impl ;
    public final void rule__Project__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:928:1: ( rule__Project__Group_1__1__Impl )
            // InternalAceGen.g:929:2: rule__Project__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_1__1"


    // $ANTLR start "rule__Project__Group_1__1__Impl"
    // InternalAceGen.g:935:1: rule__Project__Group_1__1__Impl : ( ( rule__Project__HttpServerAssignment_1_1 )? ) ;
    public final void rule__Project__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:939:1: ( ( ( rule__Project__HttpServerAssignment_1_1 )? ) )
            // InternalAceGen.g:940:1: ( ( rule__Project__HttpServerAssignment_1_1 )? )
            {
            // InternalAceGen.g:940:1: ( ( rule__Project__HttpServerAssignment_1_1 )? )
            // InternalAceGen.g:941:2: ( rule__Project__HttpServerAssignment_1_1 )?
            {
             before(grammarAccess.getProjectAccess().getHttpServerAssignment_1_1()); 
            // InternalAceGen.g:942:2: ( rule__Project__HttpServerAssignment_1_1 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAceGen.g:942:3: rule__Project__HttpServerAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Project__HttpServerAssignment_1_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProjectAccess().getHttpServerAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group_1__1__Impl"


    // $ANTLR start "rule__HttpClient__Group__0"
    // InternalAceGen.g:951:1: rule__HttpClient__Group__0 : rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1 ;
    public final void rule__HttpClient__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:955:1: ( rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1 )
            // InternalAceGen.g:956:2: rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__HttpClient__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClient__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group__0"


    // $ANTLR start "rule__HttpClient__Group__0__Impl"
    // InternalAceGen.g:963:1: rule__HttpClient__Group__0__Impl : ( ( rule__HttpClient__NameAssignment_0 ) ) ;
    public final void rule__HttpClient__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:967:1: ( ( ( rule__HttpClient__NameAssignment_0 ) ) )
            // InternalAceGen.g:968:1: ( ( rule__HttpClient__NameAssignment_0 ) )
            {
            // InternalAceGen.g:968:1: ( ( rule__HttpClient__NameAssignment_0 ) )
            // InternalAceGen.g:969:2: ( rule__HttpClient__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientAccess().getNameAssignment_0()); 
            // InternalAceGen.g:970:2: ( rule__HttpClient__NameAssignment_0 )
            // InternalAceGen.g:970:3: rule__HttpClient__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__HttpClient__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group__0__Impl"


    // $ANTLR start "rule__HttpClient__Group__1"
    // InternalAceGen.g:978:1: rule__HttpClient__Group__1 : rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2 ;
    public final void rule__HttpClient__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:982:1: ( rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2 )
            // InternalAceGen.g:983:2: rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__HttpClient__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClient__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group__1"


    // $ANTLR start "rule__HttpClient__Group__1__Impl"
    // InternalAceGen.g:990:1: rule__HttpClient__Group__1__Impl : ( ( rule__HttpClient__Group_1__0 )? ) ;
    public final void rule__HttpClient__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:994:1: ( ( ( rule__HttpClient__Group_1__0 )? ) )
            // InternalAceGen.g:995:1: ( ( rule__HttpClient__Group_1__0 )? )
            {
            // InternalAceGen.g:995:1: ( ( rule__HttpClient__Group_1__0 )? )
            // InternalAceGen.g:996:2: ( rule__HttpClient__Group_1__0 )?
            {
             before(grammarAccess.getHttpClientAccess().getGroup_1()); 
            // InternalAceGen.g:997:2: ( rule__HttpClient__Group_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAceGen.g:997:3: rule__HttpClient__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClient__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group__1__Impl"


    // $ANTLR start "rule__HttpClient__Group__2"
    // InternalAceGen.g:1005:1: rule__HttpClient__Group__2 : rule__HttpClient__Group__2__Impl ;
    public final void rule__HttpClient__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1009:1: ( rule__HttpClient__Group__2__Impl )
            // InternalAceGen.g:1010:2: rule__HttpClient__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClient__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group__2"


    // $ANTLR start "rule__HttpClient__Group__2__Impl"
    // InternalAceGen.g:1016:1: rule__HttpClient__Group__2__Impl : ( ( rule__HttpClient__Group_2__0 )? ) ;
    public final void rule__HttpClient__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1020:1: ( ( ( rule__HttpClient__Group_2__0 )? ) )
            // InternalAceGen.g:1021:1: ( ( rule__HttpClient__Group_2__0 )? )
            {
            // InternalAceGen.g:1021:1: ( ( rule__HttpClient__Group_2__0 )? )
            // InternalAceGen.g:1022:2: ( rule__HttpClient__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientAccess().getGroup_2()); 
            // InternalAceGen.g:1023:2: ( rule__HttpClient__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==30) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAceGen.g:1023:3: rule__HttpClient__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClient__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group__2__Impl"


    // $ANTLR start "rule__HttpClient__Group_1__0"
    // InternalAceGen.g:1032:1: rule__HttpClient__Group_1__0 : rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1 ;
    public final void rule__HttpClient__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1036:1: ( rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1 )
            // InternalAceGen.g:1037:2: rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpClient__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClient__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group_1__0"


    // $ANTLR start "rule__HttpClient__Group_1__0__Impl"
    // InternalAceGen.g:1044:1: rule__HttpClient__Group_1__0__Impl : ( 'ACE' ) ;
    public final void rule__HttpClient__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1048:1: ( ( 'ACE' ) )
            // InternalAceGen.g:1049:1: ( 'ACE' )
            {
            // InternalAceGen.g:1049:1: ( 'ACE' )
            // InternalAceGen.g:1050:2: 'ACE'
            {
             before(grammarAccess.getHttpClientAccess().getACEKeyword_1_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getHttpClientAccess().getACEKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group_1__0__Impl"


    // $ANTLR start "rule__HttpClient__Group_1__1"
    // InternalAceGen.g:1059:1: rule__HttpClient__Group_1__1 : rule__HttpClient__Group_1__1__Impl ;
    public final void rule__HttpClient__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1063:1: ( rule__HttpClient__Group_1__1__Impl )
            // InternalAceGen.g:1064:2: rule__HttpClient__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClient__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group_1__1"


    // $ANTLR start "rule__HttpClient__Group_1__1__Impl"
    // InternalAceGen.g:1070:1: rule__HttpClient__Group_1__1__Impl : ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* ) ;
    public final void rule__HttpClient__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1074:1: ( ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* ) )
            // InternalAceGen.g:1075:1: ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* )
            {
            // InternalAceGen.g:1075:1: ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* )
            // InternalAceGen.g:1076:2: ( rule__HttpClient__AceOperationsAssignment_1_1 )*
            {
             before(grammarAccess.getHttpClientAccess().getAceOperationsAssignment_1_1()); 
            // InternalAceGen.g:1077:2: ( rule__HttpClient__AceOperationsAssignment_1_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAceGen.g:1077:3: rule__HttpClient__AceOperationsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpClient__AceOperationsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getHttpClientAccess().getAceOperationsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group_1__1__Impl"


    // $ANTLR start "rule__HttpClient__Group_2__0"
    // InternalAceGen.g:1086:1: rule__HttpClient__Group_2__0 : rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1 ;
    public final void rule__HttpClient__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1090:1: ( rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1 )
            // InternalAceGen.g:1091:2: rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpClient__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClient__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group_2__0"


    // $ANTLR start "rule__HttpClient__Group_2__0__Impl"
    // InternalAceGen.g:1098:1: rule__HttpClient__Group_2__0__Impl : ( 'appState' ) ;
    public final void rule__HttpClient__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1102:1: ( ( 'appState' ) )
            // InternalAceGen.g:1103:1: ( 'appState' )
            {
            // InternalAceGen.g:1103:1: ( 'appState' )
            // InternalAceGen.g:1104:2: 'appState'
            {
             before(grammarAccess.getHttpClientAccess().getAppStateKeyword_2_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getHttpClientAccess().getAppStateKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group_2__0__Impl"


    // $ANTLR start "rule__HttpClient__Group_2__1"
    // InternalAceGen.g:1113:1: rule__HttpClient__Group_2__1 : rule__HttpClient__Group_2__1__Impl ;
    public final void rule__HttpClient__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1117:1: ( rule__HttpClient__Group_2__1__Impl )
            // InternalAceGen.g:1118:2: rule__HttpClient__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClient__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group_2__1"


    // $ANTLR start "rule__HttpClient__Group_2__1__Impl"
    // InternalAceGen.g:1124:1: rule__HttpClient__Group_2__1__Impl : ( ( rule__HttpClient__AppStateAssignment_2_1 ) ) ;
    public final void rule__HttpClient__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1128:1: ( ( ( rule__HttpClient__AppStateAssignment_2_1 ) ) )
            // InternalAceGen.g:1129:1: ( ( rule__HttpClient__AppStateAssignment_2_1 ) )
            {
            // InternalAceGen.g:1129:1: ( ( rule__HttpClient__AppStateAssignment_2_1 ) )
            // InternalAceGen.g:1130:2: ( rule__HttpClient__AppStateAssignment_2_1 )
            {
             before(grammarAccess.getHttpClientAccess().getAppStateAssignment_2_1()); 
            // InternalAceGen.g:1131:2: ( rule__HttpClient__AppStateAssignment_2_1 )
            // InternalAceGen.g:1131:3: rule__HttpClient__AppStateAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClient__AppStateAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAccess().getAppStateAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__Group_2__1__Impl"


    // $ANTLR start "rule__HttpClientAce__Group__0"
    // InternalAceGen.g:1140:1: rule__HttpClientAce__Group__0 : rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1 ;
    public final void rule__HttpClientAce__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1144:1: ( rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1 )
            // InternalAceGen.g:1145:2: rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__HttpClientAce__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group__0"


    // $ANTLR start "rule__HttpClientAce__Group__0__Impl"
    // InternalAceGen.g:1152:1: rule__HttpClientAce__Group__0__Impl : ( ( rule__HttpClientAce__NameAssignment_0 ) ) ;
    public final void rule__HttpClientAce__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1156:1: ( ( ( rule__HttpClientAce__NameAssignment_0 ) ) )
            // InternalAceGen.g:1157:1: ( ( rule__HttpClientAce__NameAssignment_0 ) )
            {
            // InternalAceGen.g:1157:1: ( ( rule__HttpClientAce__NameAssignment_0 ) )
            // InternalAceGen.g:1158:2: ( rule__HttpClientAce__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientAceAccess().getNameAssignment_0()); 
            // InternalAceGen.g:1159:2: ( rule__HttpClientAce__NameAssignment_0 )
            // InternalAceGen.g:1159:3: rule__HttpClientAce__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAceAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group__0__Impl"


    // $ANTLR start "rule__HttpClientAce__Group__1"
    // InternalAceGen.g:1167:1: rule__HttpClientAce__Group__1 : rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2 ;
    public final void rule__HttpClientAce__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1171:1: ( rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2 )
            // InternalAceGen.g:1172:2: rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__HttpClientAce__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group__1"


    // $ANTLR start "rule__HttpClientAce__Group__1__Impl"
    // InternalAceGen.g:1179:1: rule__HttpClientAce__Group__1__Impl : ( ( rule__HttpClientAce__Group_1__0 )? ) ;
    public final void rule__HttpClientAce__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1183:1: ( ( ( rule__HttpClientAce__Group_1__0 )? ) )
            // InternalAceGen.g:1184:1: ( ( rule__HttpClientAce__Group_1__0 )? )
            {
            // InternalAceGen.g:1184:1: ( ( rule__HttpClientAce__Group_1__0 )? )
            // InternalAceGen.g:1185:2: ( rule__HttpClientAce__Group_1__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_1()); 
            // InternalAceGen.g:1186:2: ( rule__HttpClientAce__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==31) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalAceGen.g:1186:3: rule__HttpClientAce__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClientAce__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientAceAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group__1__Impl"


    // $ANTLR start "rule__HttpClientAce__Group__2"
    // InternalAceGen.g:1194:1: rule__HttpClientAce__Group__2 : rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3 ;
    public final void rule__HttpClientAce__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1198:1: ( rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3 )
            // InternalAceGen.g:1199:2: rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__HttpClientAce__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group__2"


    // $ANTLR start "rule__HttpClientAce__Group__2__Impl"
    // InternalAceGen.g:1206:1: rule__HttpClientAce__Group__2__Impl : ( ( rule__HttpClientAce__Group_2__0 )? ) ;
    public final void rule__HttpClientAce__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1210:1: ( ( ( rule__HttpClientAce__Group_2__0 )? ) )
            // InternalAceGen.g:1211:1: ( ( rule__HttpClientAce__Group_2__0 )? )
            {
            // InternalAceGen.g:1211:1: ( ( rule__HttpClientAce__Group_2__0 )? )
            // InternalAceGen.g:1212:2: ( rule__HttpClientAce__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_2()); 
            // InternalAceGen.g:1213:2: ( rule__HttpClientAce__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==34) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalAceGen.g:1213:3: rule__HttpClientAce__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClientAce__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientAceAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group__2__Impl"


    // $ANTLR start "rule__HttpClientAce__Group__3"
    // InternalAceGen.g:1221:1: rule__HttpClientAce__Group__3 : rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4 ;
    public final void rule__HttpClientAce__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1225:1: ( rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4 )
            // InternalAceGen.g:1226:2: rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__HttpClientAce__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group__3"


    // $ANTLR start "rule__HttpClientAce__Group__3__Impl"
    // InternalAceGen.g:1233:1: rule__HttpClientAce__Group__3__Impl : ( ( rule__HttpClientAce__Group_3__0 )? ) ;
    public final void rule__HttpClientAce__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1237:1: ( ( ( rule__HttpClientAce__Group_3__0 )? ) )
            // InternalAceGen.g:1238:1: ( ( rule__HttpClientAce__Group_3__0 )? )
            {
            // InternalAceGen.g:1238:1: ( ( rule__HttpClientAce__Group_3__0 )? )
            // InternalAceGen.g:1239:2: ( rule__HttpClientAce__Group_3__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_3()); 
            // InternalAceGen.g:1240:2: ( rule__HttpClientAce__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalAceGen.g:1240:3: rule__HttpClientAce__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClientAce__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientAceAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group__3__Impl"


    // $ANTLR start "rule__HttpClientAce__Group__4"
    // InternalAceGen.g:1248:1: rule__HttpClientAce__Group__4 : rule__HttpClientAce__Group__4__Impl ;
    public final void rule__HttpClientAce__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1252:1: ( rule__HttpClientAce__Group__4__Impl )
            // InternalAceGen.g:1253:2: rule__HttpClientAce__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group__4"


    // $ANTLR start "rule__HttpClientAce__Group__4__Impl"
    // InternalAceGen.g:1259:1: rule__HttpClientAce__Group__4__Impl : ( ( rule__HttpClientAce__OutcomesAssignment_4 )* ) ;
    public final void rule__HttpClientAce__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1263:1: ( ( ( rule__HttpClientAce__OutcomesAssignment_4 )* ) )
            // InternalAceGen.g:1264:1: ( ( rule__HttpClientAce__OutcomesAssignment_4 )* )
            {
            // InternalAceGen.g:1264:1: ( ( rule__HttpClientAce__OutcomesAssignment_4 )* )
            // InternalAceGen.g:1265:2: ( rule__HttpClientAce__OutcomesAssignment_4 )*
            {
             before(grammarAccess.getHttpClientAceAccess().getOutcomesAssignment_4()); 
            // InternalAceGen.g:1266:2: ( rule__HttpClientAce__OutcomesAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==36) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalAceGen.g:1266:3: rule__HttpClientAce__OutcomesAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__HttpClientAce__OutcomesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getHttpClientAceAccess().getOutcomesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group__4__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_1__0"
    // InternalAceGen.g:1275:1: rule__HttpClientAce__Group_1__0 : rule__HttpClientAce__Group_1__0__Impl rule__HttpClientAce__Group_1__1 ;
    public final void rule__HttpClientAce__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1279:1: ( rule__HttpClientAce__Group_1__0__Impl rule__HttpClientAce__Group_1__1 )
            // InternalAceGen.g:1280:2: rule__HttpClientAce__Group_1__0__Impl rule__HttpClientAce__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpClientAce__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1__0"


    // $ANTLR start "rule__HttpClientAce__Group_1__0__Impl"
    // InternalAceGen.g:1287:1: rule__HttpClientAce__Group_1__0__Impl : ( '<' ) ;
    public final void rule__HttpClientAce__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1291:1: ( ( '<' ) )
            // InternalAceGen.g:1292:1: ( '<' )
            {
            // InternalAceGen.g:1292:1: ( '<' )
            // InternalAceGen.g:1293:2: '<'
            {
             before(grammarAccess.getHttpClientAceAccess().getLessThanSignKeyword_1_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getLessThanSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1__0__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_1__1"
    // InternalAceGen.g:1302:1: rule__HttpClientAce__Group_1__1 : rule__HttpClientAce__Group_1__1__Impl rule__HttpClientAce__Group_1__2 ;
    public final void rule__HttpClientAce__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1306:1: ( rule__HttpClientAce__Group_1__1__Impl rule__HttpClientAce__Group_1__2 )
            // InternalAceGen.g:1307:2: rule__HttpClientAce__Group_1__1__Impl rule__HttpClientAce__Group_1__2
            {
            pushFollow(FOLLOW_9);
            rule__HttpClientAce__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1__1"


    // $ANTLR start "rule__HttpClientAce__Group_1__1__Impl"
    // InternalAceGen.g:1314:1: rule__HttpClientAce__Group_1__1__Impl : ( ( rule__HttpClientAce__InputAssignment_1_1 ) ) ;
    public final void rule__HttpClientAce__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1318:1: ( ( ( rule__HttpClientAce__InputAssignment_1_1 ) ) )
            // InternalAceGen.g:1319:1: ( ( rule__HttpClientAce__InputAssignment_1_1 ) )
            {
            // InternalAceGen.g:1319:1: ( ( rule__HttpClientAce__InputAssignment_1_1 ) )
            // InternalAceGen.g:1320:2: ( rule__HttpClientAce__InputAssignment_1_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getInputAssignment_1_1()); 
            // InternalAceGen.g:1321:2: ( rule__HttpClientAce__InputAssignment_1_1 )
            // InternalAceGen.g:1321:3: rule__HttpClientAce__InputAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__InputAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAceAccess().getInputAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1__1__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_1__2"
    // InternalAceGen.g:1329:1: rule__HttpClientAce__Group_1__2 : rule__HttpClientAce__Group_1__2__Impl rule__HttpClientAce__Group_1__3 ;
    public final void rule__HttpClientAce__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1333:1: ( rule__HttpClientAce__Group_1__2__Impl rule__HttpClientAce__Group_1__3 )
            // InternalAceGen.g:1334:2: rule__HttpClientAce__Group_1__2__Impl rule__HttpClientAce__Group_1__3
            {
            pushFollow(FOLLOW_9);
            rule__HttpClientAce__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1__2"


    // $ANTLR start "rule__HttpClientAce__Group_1__2__Impl"
    // InternalAceGen.g:1341:1: rule__HttpClientAce__Group_1__2__Impl : ( ( rule__HttpClientAce__Group_1_2__0 )* ) ;
    public final void rule__HttpClientAce__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1345:1: ( ( ( rule__HttpClientAce__Group_1_2__0 )* ) )
            // InternalAceGen.g:1346:1: ( ( rule__HttpClientAce__Group_1_2__0 )* )
            {
            // InternalAceGen.g:1346:1: ( ( rule__HttpClientAce__Group_1_2__0 )* )
            // InternalAceGen.g:1347:2: ( rule__HttpClientAce__Group_1_2__0 )*
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_1_2()); 
            // InternalAceGen.g:1348:2: ( rule__HttpClientAce__Group_1_2__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==33) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalAceGen.g:1348:3: rule__HttpClientAce__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__HttpClientAce__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getHttpClientAceAccess().getGroup_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1__2__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_1__3"
    // InternalAceGen.g:1356:1: rule__HttpClientAce__Group_1__3 : rule__HttpClientAce__Group_1__3__Impl ;
    public final void rule__HttpClientAce__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1360:1: ( rule__HttpClientAce__Group_1__3__Impl )
            // InternalAceGen.g:1361:2: rule__HttpClientAce__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1__3"


    // $ANTLR start "rule__HttpClientAce__Group_1__3__Impl"
    // InternalAceGen.g:1367:1: rule__HttpClientAce__Group_1__3__Impl : ( '>' ) ;
    public final void rule__HttpClientAce__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1371:1: ( ( '>' ) )
            // InternalAceGen.g:1372:1: ( '>' )
            {
            // InternalAceGen.g:1372:1: ( '>' )
            // InternalAceGen.g:1373:2: '>'
            {
             before(grammarAccess.getHttpClientAceAccess().getGreaterThanSignKeyword_1_3()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getGreaterThanSignKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1__3__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_1_2__0"
    // InternalAceGen.g:1383:1: rule__HttpClientAce__Group_1_2__0 : rule__HttpClientAce__Group_1_2__0__Impl rule__HttpClientAce__Group_1_2__1 ;
    public final void rule__HttpClientAce__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1387:1: ( rule__HttpClientAce__Group_1_2__0__Impl rule__HttpClientAce__Group_1_2__1 )
            // InternalAceGen.g:1388:2: rule__HttpClientAce__Group_1_2__0__Impl rule__HttpClientAce__Group_1_2__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpClientAce__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1_2__0"


    // $ANTLR start "rule__HttpClientAce__Group_1_2__0__Impl"
    // InternalAceGen.g:1395:1: rule__HttpClientAce__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__HttpClientAce__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1399:1: ( ( ',' ) )
            // InternalAceGen.g:1400:1: ( ',' )
            {
            // InternalAceGen.g:1400:1: ( ',' )
            // InternalAceGen.g:1401:2: ','
            {
             before(grammarAccess.getHttpClientAceAccess().getCommaKeyword_1_2_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getCommaKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1_2__0__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_1_2__1"
    // InternalAceGen.g:1410:1: rule__HttpClientAce__Group_1_2__1 : rule__HttpClientAce__Group_1_2__1__Impl ;
    public final void rule__HttpClientAce__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1414:1: ( rule__HttpClientAce__Group_1_2__1__Impl )
            // InternalAceGen.g:1415:2: rule__HttpClientAce__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1_2__1"


    // $ANTLR start "rule__HttpClientAce__Group_1_2__1__Impl"
    // InternalAceGen.g:1421:1: rule__HttpClientAce__Group_1_2__1__Impl : ( ( rule__HttpClientAce__InputAssignment_1_2_1 ) ) ;
    public final void rule__HttpClientAce__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1425:1: ( ( ( rule__HttpClientAce__InputAssignment_1_2_1 ) ) )
            // InternalAceGen.g:1426:1: ( ( rule__HttpClientAce__InputAssignment_1_2_1 ) )
            {
            // InternalAceGen.g:1426:1: ( ( rule__HttpClientAce__InputAssignment_1_2_1 ) )
            // InternalAceGen.g:1427:2: ( rule__HttpClientAce__InputAssignment_1_2_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getInputAssignment_1_2_1()); 
            // InternalAceGen.g:1428:2: ( rule__HttpClientAce__InputAssignment_1_2_1 )
            // InternalAceGen.g:1428:3: rule__HttpClientAce__InputAssignment_1_2_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__InputAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAceAccess().getInputAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_1_2__1__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_2__0"
    // InternalAceGen.g:1437:1: rule__HttpClientAce__Group_2__0 : rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1 ;
    public final void rule__HttpClientAce__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1441:1: ( rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1 )
            // InternalAceGen.g:1442:2: rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpClientAce__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_2__0"


    // $ANTLR start "rule__HttpClientAce__Group_2__0__Impl"
    // InternalAceGen.g:1449:1: rule__HttpClientAce__Group_2__0__Impl : ( 'call' ) ;
    public final void rule__HttpClientAce__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1453:1: ( ( 'call' ) )
            // InternalAceGen.g:1454:1: ( 'call' )
            {
            // InternalAceGen.g:1454:1: ( 'call' )
            // InternalAceGen.g:1455:2: 'call'
            {
             before(grammarAccess.getHttpClientAceAccess().getCallKeyword_2_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getCallKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_2__0__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_2__1"
    // InternalAceGen.g:1464:1: rule__HttpClientAce__Group_2__1 : rule__HttpClientAce__Group_2__1__Impl ;
    public final void rule__HttpClientAce__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1468:1: ( rule__HttpClientAce__Group_2__1__Impl )
            // InternalAceGen.g:1469:2: rule__HttpClientAce__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_2__1"


    // $ANTLR start "rule__HttpClientAce__Group_2__1__Impl"
    // InternalAceGen.g:1475:1: rule__HttpClientAce__Group_2__1__Impl : ( ( rule__HttpClientAce__ServerCallAssignment_2_1 ) ) ;
    public final void rule__HttpClientAce__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1479:1: ( ( ( rule__HttpClientAce__ServerCallAssignment_2_1 ) ) )
            // InternalAceGen.g:1480:1: ( ( rule__HttpClientAce__ServerCallAssignment_2_1 ) )
            {
            // InternalAceGen.g:1480:1: ( ( rule__HttpClientAce__ServerCallAssignment_2_1 ) )
            // InternalAceGen.g:1481:2: ( rule__HttpClientAce__ServerCallAssignment_2_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallAssignment_2_1()); 
            // InternalAceGen.g:1482:2: ( rule__HttpClientAce__ServerCallAssignment_2_1 )
            // InternalAceGen.g:1482:3: rule__HttpClientAce__ServerCallAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__ServerCallAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAceAccess().getServerCallAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_2__1__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_3__0"
    // InternalAceGen.g:1491:1: rule__HttpClientAce__Group_3__0 : rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1 ;
    public final void rule__HttpClientAce__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1495:1: ( rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1 )
            // InternalAceGen.g:1496:2: rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpClientAce__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_3__0"


    // $ANTLR start "rule__HttpClientAce__Group_3__0__Impl"
    // InternalAceGen.g:1503:1: rule__HttpClientAce__Group_3__0__Impl : ( 'loadingFlag' ) ;
    public final void rule__HttpClientAce__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1507:1: ( ( 'loadingFlag' ) )
            // InternalAceGen.g:1508:1: ( 'loadingFlag' )
            {
            // InternalAceGen.g:1508:1: ( 'loadingFlag' )
            // InternalAceGen.g:1509:2: 'loadingFlag'
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagKeyword_3_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getLoadingFlagKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_3__0__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_3__1"
    // InternalAceGen.g:1518:1: rule__HttpClientAce__Group_3__1 : rule__HttpClientAce__Group_3__1__Impl ;
    public final void rule__HttpClientAce__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1522:1: ( rule__HttpClientAce__Group_3__1__Impl )
            // InternalAceGen.g:1523:2: rule__HttpClientAce__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_3__1"


    // $ANTLR start "rule__HttpClientAce__Group_3__1__Impl"
    // InternalAceGen.g:1529:1: rule__HttpClientAce__Group_3__1__Impl : ( ( rule__HttpClientAce__LoadingFlagAssignment_3_1 ) ) ;
    public final void rule__HttpClientAce__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1533:1: ( ( ( rule__HttpClientAce__LoadingFlagAssignment_3_1 ) ) )
            // InternalAceGen.g:1534:1: ( ( rule__HttpClientAce__LoadingFlagAssignment_3_1 ) )
            {
            // InternalAceGen.g:1534:1: ( ( rule__HttpClientAce__LoadingFlagAssignment_3_1 ) )
            // InternalAceGen.g:1535:2: ( rule__HttpClientAce__LoadingFlagAssignment_3_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagAssignment_3_1()); 
            // InternalAceGen.g:1536:2: ( rule__HttpClientAce__LoadingFlagAssignment_3_1 )
            // InternalAceGen.g:1536:3: rule__HttpClientAce__LoadingFlagAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__LoadingFlagAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAceAccess().getLoadingFlagAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__Group_3__1__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group__0"
    // InternalAceGen.g:1545:1: rule__HttpClientOutcome__Group__0 : rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1 ;
    public final void rule__HttpClientOutcome__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1549:1: ( rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1 )
            // InternalAceGen.g:1550:2: rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpClientOutcome__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group__0"


    // $ANTLR start "rule__HttpClientOutcome__Group__0__Impl"
    // InternalAceGen.g:1557:1: rule__HttpClientOutcome__Group__0__Impl : ( 'on' ) ;
    public final void rule__HttpClientOutcome__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1561:1: ( ( 'on' ) )
            // InternalAceGen.g:1562:1: ( 'on' )
            {
            // InternalAceGen.g:1562:1: ( 'on' )
            // InternalAceGen.g:1563:2: 'on'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getOnKeyword_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getHttpClientOutcomeAccess().getOnKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group__0__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group__1"
    // InternalAceGen.g:1572:1: rule__HttpClientOutcome__Group__1 : rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2 ;
    public final void rule__HttpClientOutcome__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1576:1: ( rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2 )
            // InternalAceGen.g:1577:2: rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__HttpClientOutcome__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group__1"


    // $ANTLR start "rule__HttpClientOutcome__Group__1__Impl"
    // InternalAceGen.g:1584:1: rule__HttpClientOutcome__Group__1__Impl : ( ( rule__HttpClientOutcome__NameAssignment_1 ) ) ;
    public final void rule__HttpClientOutcome__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1588:1: ( ( ( rule__HttpClientOutcome__NameAssignment_1 ) ) )
            // InternalAceGen.g:1589:1: ( ( rule__HttpClientOutcome__NameAssignment_1 ) )
            {
            // InternalAceGen.g:1589:1: ( ( rule__HttpClientOutcome__NameAssignment_1 ) )
            // InternalAceGen.g:1590:2: ( rule__HttpClientOutcome__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getNameAssignment_1()); 
            // InternalAceGen.g:1591:2: ( rule__HttpClientOutcome__NameAssignment_1 )
            // InternalAceGen.g:1591:3: rule__HttpClientOutcome__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientOutcomeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group__1__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group__2"
    // InternalAceGen.g:1599:1: rule__HttpClientOutcome__Group__2 : rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3 ;
    public final void rule__HttpClientOutcome__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1603:1: ( rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3 )
            // InternalAceGen.g:1604:2: rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__HttpClientOutcome__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group__2"


    // $ANTLR start "rule__HttpClientOutcome__Group__2__Impl"
    // InternalAceGen.g:1611:1: rule__HttpClientOutcome__Group__2__Impl : ( ( rule__HttpClientOutcome__Group_2__0 )? ) ;
    public final void rule__HttpClientOutcome__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1615:1: ( ( ( rule__HttpClientOutcome__Group_2__0 )? ) )
            // InternalAceGen.g:1616:1: ( ( rule__HttpClientOutcome__Group_2__0 )? )
            {
            // InternalAceGen.g:1616:1: ( ( rule__HttpClientOutcome__Group_2__0 )? )
            // InternalAceGen.g:1617:2: ( rule__HttpClientOutcome__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getGroup_2()); 
            // InternalAceGen.g:1618:2: ( rule__HttpClientOutcome__Group_2__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==37) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAceGen.g:1618:3: rule__HttpClientOutcome__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClientOutcome__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientOutcomeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group__2__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group__3"
    // InternalAceGen.g:1626:1: rule__HttpClientOutcome__Group__3 : rule__HttpClientOutcome__Group__3__Impl ;
    public final void rule__HttpClientOutcome__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1630:1: ( rule__HttpClientOutcome__Group__3__Impl )
            // InternalAceGen.g:1631:2: rule__HttpClientOutcome__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group__3"


    // $ANTLR start "rule__HttpClientOutcome__Group__3__Impl"
    // InternalAceGen.g:1637:1: rule__HttpClientOutcome__Group__3__Impl : ( ( rule__HttpClientOutcome__Group_3__0 )? ) ;
    public final void rule__HttpClientOutcome__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1641:1: ( ( ( rule__HttpClientOutcome__Group_3__0 )? ) )
            // InternalAceGen.g:1642:1: ( ( rule__HttpClientOutcome__Group_3__0 )? )
            {
            // InternalAceGen.g:1642:1: ( ( rule__HttpClientOutcome__Group_3__0 )? )
            // InternalAceGen.g:1643:2: ( rule__HttpClientOutcome__Group_3__0 )?
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getGroup_3()); 
            // InternalAceGen.g:1644:2: ( rule__HttpClientOutcome__Group_3__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==39) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAceGen.g:1644:3: rule__HttpClientOutcome__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClientOutcome__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientOutcomeAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group__3__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group_2__0"
    // InternalAceGen.g:1653:1: rule__HttpClientOutcome__Group_2__0 : rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1 ;
    public final void rule__HttpClientOutcome__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1657:1: ( rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1 )
            // InternalAceGen.g:1658:2: rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1
            {
            pushFollow(FOLLOW_12);
            rule__HttpClientOutcome__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_2__0"


    // $ANTLR start "rule__HttpClientOutcome__Group_2__0__Impl"
    // InternalAceGen.g:1665:1: rule__HttpClientOutcome__Group_2__0__Impl : ( '(' ) ;
    public final void rule__HttpClientOutcome__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1669:1: ( ( '(' ) )
            // InternalAceGen.g:1670:1: ( '(' )
            {
            // InternalAceGen.g:1670:1: ( '(' )
            // InternalAceGen.g:1671:2: '('
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_2__0__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group_2__1"
    // InternalAceGen.g:1680:1: rule__HttpClientOutcome__Group_2__1 : rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2 ;
    public final void rule__HttpClientOutcome__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1684:1: ( rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2 )
            // InternalAceGen.g:1685:2: rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2
            {
            pushFollow(FOLLOW_12);
            rule__HttpClientOutcome__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_2__1"


    // $ANTLR start "rule__HttpClientOutcome__Group_2__1__Impl"
    // InternalAceGen.g:1692:1: rule__HttpClientOutcome__Group_2__1__Impl : ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* ) ;
    public final void rule__HttpClientOutcome__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1696:1: ( ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* ) )
            // InternalAceGen.g:1697:1: ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* )
            {
            // InternalAceGen.g:1697:1: ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* )
            // InternalAceGen.g:1698:2: ( rule__HttpClientOutcome__ListenersAssignment_2_1 )*
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getListenersAssignment_2_1()); 
            // InternalAceGen.g:1699:2: ( rule__HttpClientOutcome__ListenersAssignment_2_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=12 && LA20_0<=15)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalAceGen.g:1699:3: rule__HttpClientOutcome__ListenersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__HttpClientOutcome__ListenersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getHttpClientOutcomeAccess().getListenersAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_2__1__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group_2__2"
    // InternalAceGen.g:1707:1: rule__HttpClientOutcome__Group_2__2 : rule__HttpClientOutcome__Group_2__2__Impl ;
    public final void rule__HttpClientOutcome__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1711:1: ( rule__HttpClientOutcome__Group_2__2__Impl )
            // InternalAceGen.g:1712:2: rule__HttpClientOutcome__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_2__2"


    // $ANTLR start "rule__HttpClientOutcome__Group_2__2__Impl"
    // InternalAceGen.g:1718:1: rule__HttpClientOutcome__Group_2__2__Impl : ( ')' ) ;
    public final void rule__HttpClientOutcome__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1722:1: ( ( ')' ) )
            // InternalAceGen.g:1723:1: ( ')' )
            {
            // InternalAceGen.g:1723:1: ( ')' )
            // InternalAceGen.g:1724:2: ')'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_2_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_2__2__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group_3__0"
    // InternalAceGen.g:1734:1: rule__HttpClientOutcome__Group_3__0 : rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1 ;
    public final void rule__HttpClientOutcome__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1738:1: ( rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1 )
            // InternalAceGen.g:1739:2: rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1
            {
            pushFollow(FOLLOW_14);
            rule__HttpClientOutcome__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_3__0"


    // $ANTLR start "rule__HttpClientOutcome__Group_3__0__Impl"
    // InternalAceGen.g:1746:1: rule__HttpClientOutcome__Group_3__0__Impl : ( 'triggers' ) ;
    public final void rule__HttpClientOutcome__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1750:1: ( ( 'triggers' ) )
            // InternalAceGen.g:1751:1: ( 'triggers' )
            {
            // InternalAceGen.g:1751:1: ( 'triggers' )
            // InternalAceGen.g:1752:2: 'triggers'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getTriggersKeyword_3_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getHttpClientOutcomeAccess().getTriggersKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_3__0__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group_3__1"
    // InternalAceGen.g:1761:1: rule__HttpClientOutcome__Group_3__1 : rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2 ;
    public final void rule__HttpClientOutcome__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1765:1: ( rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2 )
            // InternalAceGen.g:1766:2: rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2
            {
            pushFollow(FOLLOW_15);
            rule__HttpClientOutcome__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_3__1"


    // $ANTLR start "rule__HttpClientOutcome__Group_3__1__Impl"
    // InternalAceGen.g:1773:1: rule__HttpClientOutcome__Group_3__1__Impl : ( '(' ) ;
    public final void rule__HttpClientOutcome__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1777:1: ( ( '(' ) )
            // InternalAceGen.g:1778:1: ( '(' )
            {
            // InternalAceGen.g:1778:1: ( '(' )
            // InternalAceGen.g:1779:2: '('
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_3__1__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group_3__2"
    // InternalAceGen.g:1788:1: rule__HttpClientOutcome__Group_3__2 : rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3 ;
    public final void rule__HttpClientOutcome__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1792:1: ( rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3 )
            // InternalAceGen.g:1793:2: rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3
            {
            pushFollow(FOLLOW_15);
            rule__HttpClientOutcome__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_3__2"


    // $ANTLR start "rule__HttpClientOutcome__Group_3__2__Impl"
    // InternalAceGen.g:1800:1: rule__HttpClientOutcome__Group_3__2__Impl : ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* ) ;
    public final void rule__HttpClientOutcome__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1804:1: ( ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* ) )
            // InternalAceGen.g:1805:1: ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* )
            {
            // InternalAceGen.g:1805:1: ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* )
            // InternalAceGen.g:1806:2: ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )*
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsAssignment_3_2()); 
            // InternalAceGen.g:1807:2: ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalAceGen.g:1807:3: rule__HttpClientOutcome__AceOperationsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpClientOutcome__AceOperationsAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_3__2__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group_3__3"
    // InternalAceGen.g:1815:1: rule__HttpClientOutcome__Group_3__3 : rule__HttpClientOutcome__Group_3__3__Impl ;
    public final void rule__HttpClientOutcome__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1819:1: ( rule__HttpClientOutcome__Group_3__3__Impl )
            // InternalAceGen.g:1820:2: rule__HttpClientOutcome__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientOutcome__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_3__3"


    // $ANTLR start "rule__HttpClientOutcome__Group_3__3__Impl"
    // InternalAceGen.g:1826:1: rule__HttpClientOutcome__Group_3__3__Impl : ( ')' ) ;
    public final void rule__HttpClientOutcome__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1830:1: ( ( ')' ) )
            // InternalAceGen.g:1831:1: ( ')' )
            {
            // InternalAceGen.g:1831:1: ( ')' )
            // InternalAceGen.g:1832:2: ')'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_3_3()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__Group_3__3__Impl"


    // $ANTLR start "rule__HttpClientStateFunction__Group__0"
    // InternalAceGen.g:1842:1: rule__HttpClientStateFunction__Group__0 : rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1 ;
    public final void rule__HttpClientStateFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1846:1: ( rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1 )
            // InternalAceGen.g:1847:2: rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpClientStateFunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientStateFunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateFunction__Group__0"


    // $ANTLR start "rule__HttpClientStateFunction__Group__0__Impl"
    // InternalAceGen.g:1854:1: rule__HttpClientStateFunction__Group__0__Impl : ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) ) ;
    public final void rule__HttpClientStateFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1858:1: ( ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) ) )
            // InternalAceGen.g:1859:1: ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) )
            {
            // InternalAceGen.g:1859:1: ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) )
            // InternalAceGen.g:1860:2: ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeAssignment_0()); 
            // InternalAceGen.g:1861:2: ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 )
            // InternalAceGen.g:1861:3: rule__HttpClientStateFunction__StateFunctionTypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateFunction__StateFunctionTypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateFunction__Group__0__Impl"


    // $ANTLR start "rule__HttpClientStateFunction__Group__1"
    // InternalAceGen.g:1869:1: rule__HttpClientStateFunction__Group__1 : rule__HttpClientStateFunction__Group__1__Impl ;
    public final void rule__HttpClientStateFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1873:1: ( rule__HttpClientStateFunction__Group__1__Impl )
            // InternalAceGen.g:1874:2: rule__HttpClientStateFunction__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateFunction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateFunction__Group__1"


    // $ANTLR start "rule__HttpClientStateFunction__Group__1__Impl"
    // InternalAceGen.g:1880:1: rule__HttpClientStateFunction__Group__1__Impl : ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) ) ;
    public final void rule__HttpClientStateFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1884:1: ( ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) ) )
            // InternalAceGen.g:1885:1: ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) )
            {
            // InternalAceGen.g:1885:1: ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) )
            // InternalAceGen.g:1886:2: ( rule__HttpClientStateFunction__AttributeAssignment_1 )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getAttributeAssignment_1()); 
            // InternalAceGen.g:1887:2: ( rule__HttpClientStateFunction__AttributeAssignment_1 )
            // InternalAceGen.g:1887:3: rule__HttpClientStateFunction__AttributeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateFunction__AttributeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientStateFunctionAccess().getAttributeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateFunction__Group__1__Impl"


    // $ANTLR start "rule__HttpClientStateElement__Group__0"
    // InternalAceGen.g:1896:1: rule__HttpClientStateElement__Group__0 : rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1 ;
    public final void rule__HttpClientStateElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1900:1: ( rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1 )
            // InternalAceGen.g:1901:2: rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__HttpClientStateElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group__0"


    // $ANTLR start "rule__HttpClientStateElement__Group__0__Impl"
    // InternalAceGen.g:1908:1: rule__HttpClientStateElement__Group__0__Impl : ( ( rule__HttpClientStateElement__NameAssignment_0 ) ) ;
    public final void rule__HttpClientStateElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1912:1: ( ( ( rule__HttpClientStateElement__NameAssignment_0 ) ) )
            // InternalAceGen.g:1913:1: ( ( rule__HttpClientStateElement__NameAssignment_0 ) )
            {
            // InternalAceGen.g:1913:1: ( ( rule__HttpClientStateElement__NameAssignment_0 ) )
            // InternalAceGen.g:1914:2: ( rule__HttpClientStateElement__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getNameAssignment_0()); 
            // InternalAceGen.g:1915:2: ( rule__HttpClientStateElement__NameAssignment_0 )
            // InternalAceGen.g:1915:3: rule__HttpClientStateElement__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientStateElementAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group__0__Impl"


    // $ANTLR start "rule__HttpClientStateElement__Group__1"
    // InternalAceGen.g:1923:1: rule__HttpClientStateElement__Group__1 : rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2 ;
    public final void rule__HttpClientStateElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1927:1: ( rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2 )
            // InternalAceGen.g:1928:2: rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__HttpClientStateElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group__1"


    // $ANTLR start "rule__HttpClientStateElement__Group__1__Impl"
    // InternalAceGen.g:1935:1: rule__HttpClientStateElement__Group__1__Impl : ( ( rule__HttpClientStateElement__ListAssignment_1 )? ) ;
    public final void rule__HttpClientStateElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1939:1: ( ( ( rule__HttpClientStateElement__ListAssignment_1 )? ) )
            // InternalAceGen.g:1940:1: ( ( rule__HttpClientStateElement__ListAssignment_1 )? )
            {
            // InternalAceGen.g:1940:1: ( ( rule__HttpClientStateElement__ListAssignment_1 )? )
            // InternalAceGen.g:1941:2: ( rule__HttpClientStateElement__ListAssignment_1 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListAssignment_1()); 
            // InternalAceGen.g:1942:2: ( rule__HttpClientStateElement__ListAssignment_1 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==55) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalAceGen.g:1942:3: rule__HttpClientStateElement__ListAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClientStateElement__ListAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientStateElementAccess().getListAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group__1__Impl"


    // $ANTLR start "rule__HttpClientStateElement__Group__2"
    // InternalAceGen.g:1950:1: rule__HttpClientStateElement__Group__2 : rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3 ;
    public final void rule__HttpClientStateElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1954:1: ( rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3 )
            // InternalAceGen.g:1955:2: rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__HttpClientStateElement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group__2"


    // $ANTLR start "rule__HttpClientStateElement__Group__2__Impl"
    // InternalAceGen.g:1962:1: rule__HttpClientStateElement__Group__2__Impl : ( ( rule__HttpClientStateElement__HashAssignment_2 )? ) ;
    public final void rule__HttpClientStateElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1966:1: ( ( ( rule__HttpClientStateElement__HashAssignment_2 )? ) )
            // InternalAceGen.g:1967:1: ( ( rule__HttpClientStateElement__HashAssignment_2 )? )
            {
            // InternalAceGen.g:1967:1: ( ( rule__HttpClientStateElement__HashAssignment_2 )? )
            // InternalAceGen.g:1968:2: ( rule__HttpClientStateElement__HashAssignment_2 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashAssignment_2()); 
            // InternalAceGen.g:1969:2: ( rule__HttpClientStateElement__HashAssignment_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==56) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalAceGen.g:1969:3: rule__HttpClientStateElement__HashAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClientStateElement__HashAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientStateElementAccess().getHashAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group__2__Impl"


    // $ANTLR start "rule__HttpClientStateElement__Group__3"
    // InternalAceGen.g:1977:1: rule__HttpClientStateElement__Group__3 : rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4 ;
    public final void rule__HttpClientStateElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1981:1: ( rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4 )
            // InternalAceGen.g:1982:2: rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__HttpClientStateElement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group__3"


    // $ANTLR start "rule__HttpClientStateElement__Group__3__Impl"
    // InternalAceGen.g:1989:1: rule__HttpClientStateElement__Group__3__Impl : ( ( rule__HttpClientStateElement__StorageAssignment_3 )? ) ;
    public final void rule__HttpClientStateElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1993:1: ( ( ( rule__HttpClientStateElement__StorageAssignment_3 )? ) )
            // InternalAceGen.g:1994:1: ( ( rule__HttpClientStateElement__StorageAssignment_3 )? )
            {
            // InternalAceGen.g:1994:1: ( ( rule__HttpClientStateElement__StorageAssignment_3 )? )
            // InternalAceGen.g:1995:2: ( rule__HttpClientStateElement__StorageAssignment_3 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageAssignment_3()); 
            // InternalAceGen.g:1996:2: ( rule__HttpClientStateElement__StorageAssignment_3 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==57) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalAceGen.g:1996:3: rule__HttpClientStateElement__StorageAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClientStateElement__StorageAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientStateElementAccess().getStorageAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group__3__Impl"


    // $ANTLR start "rule__HttpClientStateElement__Group__4"
    // InternalAceGen.g:2004:1: rule__HttpClientStateElement__Group__4 : rule__HttpClientStateElement__Group__4__Impl ;
    public final void rule__HttpClientStateElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2008:1: ( rule__HttpClientStateElement__Group__4__Impl )
            // InternalAceGen.g:2009:2: rule__HttpClientStateElement__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group__4"


    // $ANTLR start "rule__HttpClientStateElement__Group__4__Impl"
    // InternalAceGen.g:2015:1: rule__HttpClientStateElement__Group__4__Impl : ( ( rule__HttpClientStateElement__Group_4__0 )? ) ;
    public final void rule__HttpClientStateElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2019:1: ( ( ( rule__HttpClientStateElement__Group_4__0 )? ) )
            // InternalAceGen.g:2020:1: ( ( rule__HttpClientStateElement__Group_4__0 )? )
            {
            // InternalAceGen.g:2020:1: ( ( rule__HttpClientStateElement__Group_4__0 )? )
            // InternalAceGen.g:2021:2: ( rule__HttpClientStateElement__Group_4__0 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getGroup_4()); 
            // InternalAceGen.g:2022:2: ( rule__HttpClientStateElement__Group_4__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==41) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalAceGen.g:2022:3: rule__HttpClientStateElement__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClientStateElement__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientStateElementAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group__4__Impl"


    // $ANTLR start "rule__HttpClientStateElement__Group_4__0"
    // InternalAceGen.g:2031:1: rule__HttpClientStateElement__Group_4__0 : rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1 ;
    public final void rule__HttpClientStateElement__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2035:1: ( rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1 )
            // InternalAceGen.g:2036:2: rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1
            {
            pushFollow(FOLLOW_17);
            rule__HttpClientStateElement__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group_4__0"


    // $ANTLR start "rule__HttpClientStateElement__Group_4__0__Impl"
    // InternalAceGen.g:2043:1: rule__HttpClientStateElement__Group_4__0__Impl : ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) ) ;
    public final void rule__HttpClientStateElement__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2047:1: ( ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) ) )
            // InternalAceGen.g:2048:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) )
            {
            // InternalAceGen.g:2048:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) )
            // InternalAceGen.g:2049:2: ( rule__HttpClientStateElement__TypesAssignment_4_0 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_0()); 
            // InternalAceGen.g:2050:2: ( rule__HttpClientStateElement__TypesAssignment_4_0 )
            // InternalAceGen.g:2050:3: rule__HttpClientStateElement__TypesAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__TypesAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group_4__0__Impl"


    // $ANTLR start "rule__HttpClientStateElement__Group_4__1"
    // InternalAceGen.g:2058:1: rule__HttpClientStateElement__Group_4__1 : rule__HttpClientStateElement__Group_4__1__Impl ;
    public final void rule__HttpClientStateElement__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2062:1: ( rule__HttpClientStateElement__Group_4__1__Impl )
            // InternalAceGen.g:2063:2: rule__HttpClientStateElement__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group_4__1"


    // $ANTLR start "rule__HttpClientStateElement__Group_4__1__Impl"
    // InternalAceGen.g:2069:1: rule__HttpClientStateElement__Group_4__1__Impl : ( ( rule__HttpClientStateElement__Group_4_1__0 )* ) ;
    public final void rule__HttpClientStateElement__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2073:1: ( ( ( rule__HttpClientStateElement__Group_4_1__0 )* ) )
            // InternalAceGen.g:2074:1: ( ( rule__HttpClientStateElement__Group_4_1__0 )* )
            {
            // InternalAceGen.g:2074:1: ( ( rule__HttpClientStateElement__Group_4_1__0 )* )
            // InternalAceGen.g:2075:2: ( rule__HttpClientStateElement__Group_4_1__0 )*
            {
             before(grammarAccess.getHttpClientStateElementAccess().getGroup_4_1()); 
            // InternalAceGen.g:2076:2: ( rule__HttpClientStateElement__Group_4_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==40) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalAceGen.g:2076:3: rule__HttpClientStateElement__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpClientStateElement__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getHttpClientStateElementAccess().getGroup_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group_4__1__Impl"


    // $ANTLR start "rule__HttpClientStateElement__Group_4_1__0"
    // InternalAceGen.g:2085:1: rule__HttpClientStateElement__Group_4_1__0 : rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1 ;
    public final void rule__HttpClientStateElement__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2089:1: ( rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1 )
            // InternalAceGen.g:2090:2: rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1
            {
            pushFollow(FOLLOW_19);
            rule__HttpClientStateElement__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group_4_1__0"


    // $ANTLR start "rule__HttpClientStateElement__Group_4_1__0__Impl"
    // InternalAceGen.g:2097:1: rule__HttpClientStateElement__Group_4_1__0__Impl : ( '|' ) ;
    public final void rule__HttpClientStateElement__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2101:1: ( ( '|' ) )
            // InternalAceGen.g:2102:1: ( '|' )
            {
            // InternalAceGen.g:2102:1: ( '|' )
            // InternalAceGen.g:2103:2: '|'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getVerticalLineKeyword_4_1_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getHttpClientStateElementAccess().getVerticalLineKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group_4_1__0__Impl"


    // $ANTLR start "rule__HttpClientStateElement__Group_4_1__1"
    // InternalAceGen.g:2112:1: rule__HttpClientStateElement__Group_4_1__1 : rule__HttpClientStateElement__Group_4_1__1__Impl ;
    public final void rule__HttpClientStateElement__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2116:1: ( rule__HttpClientStateElement__Group_4_1__1__Impl )
            // InternalAceGen.g:2117:2: rule__HttpClientStateElement__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__Group_4_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group_4_1__1"


    // $ANTLR start "rule__HttpClientStateElement__Group_4_1__1__Impl"
    // InternalAceGen.g:2123:1: rule__HttpClientStateElement__Group_4_1__1__Impl : ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) ) ;
    public final void rule__HttpClientStateElement__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2127:1: ( ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) ) )
            // InternalAceGen.g:2128:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) )
            {
            // InternalAceGen.g:2128:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) )
            // InternalAceGen.g:2129:2: ( rule__HttpClientStateElement__TypesAssignment_4_1_1 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_1_1()); 
            // InternalAceGen.g:2130:2: ( rule__HttpClientStateElement__TypesAssignment_4_1_1 )
            // InternalAceGen.g:2130:3: rule__HttpClientStateElement__TypesAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientStateElement__TypesAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__Group_4_1__1__Impl"


    // $ANTLR start "rule__HttpClientTypeDefinition__Group__0"
    // InternalAceGen.g:2139:1: rule__HttpClientTypeDefinition__Group__0 : rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1 ;
    public final void rule__HttpClientTypeDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2143:1: ( rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1 )
            // InternalAceGen.g:2144:2: rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpClientTypeDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientTypeDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__Group__0"


    // $ANTLR start "rule__HttpClientTypeDefinition__Group__0__Impl"
    // InternalAceGen.g:2151:1: rule__HttpClientTypeDefinition__Group__0__Impl : ( ':' ) ;
    public final void rule__HttpClientTypeDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2155:1: ( ( ':' ) )
            // InternalAceGen.g:2156:1: ( ':' )
            {
            // InternalAceGen.g:2156:1: ( ':' )
            // InternalAceGen.g:2157:2: ':'
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getColonKeyword_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getHttpClientTypeDefinitionAccess().getColonKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__Group__0__Impl"


    // $ANTLR start "rule__HttpClientTypeDefinition__Group__1"
    // InternalAceGen.g:2166:1: rule__HttpClientTypeDefinition__Group__1 : rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2 ;
    public final void rule__HttpClientTypeDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2170:1: ( rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2 )
            // InternalAceGen.g:2171:2: rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__HttpClientTypeDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientTypeDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__Group__1"


    // $ANTLR start "rule__HttpClientTypeDefinition__Group__1__Impl"
    // InternalAceGen.g:2178:1: rule__HttpClientTypeDefinition__Group__1__Impl : ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) ) ;
    public final void rule__HttpClientTypeDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2182:1: ( ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) ) )
            // InternalAceGen.g:2183:1: ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) )
            {
            // InternalAceGen.g:2183:1: ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) )
            // InternalAceGen.g:2184:2: ( rule__HttpClientTypeDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getNameAssignment_1()); 
            // InternalAceGen.g:2185:2: ( rule__HttpClientTypeDefinition__NameAssignment_1 )
            // InternalAceGen.g:2185:3: rule__HttpClientTypeDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientTypeDefinition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientTypeDefinitionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__Group__1__Impl"


    // $ANTLR start "rule__HttpClientTypeDefinition__Group__2"
    // InternalAceGen.g:2193:1: rule__HttpClientTypeDefinition__Group__2 : rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3 ;
    public final void rule__HttpClientTypeDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2197:1: ( rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3 )
            // InternalAceGen.g:2198:2: rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__HttpClientTypeDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientTypeDefinition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__Group__2"


    // $ANTLR start "rule__HttpClientTypeDefinition__Group__2__Impl"
    // InternalAceGen.g:2205:1: rule__HttpClientTypeDefinition__Group__2__Impl : ( '{' ) ;
    public final void rule__HttpClientTypeDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2209:1: ( ( '{' ) )
            // InternalAceGen.g:2210:1: ( '{' )
            {
            // InternalAceGen.g:2210:1: ( '{' )
            // InternalAceGen.g:2211:2: '{'
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getHttpClientTypeDefinitionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__Group__2__Impl"


    // $ANTLR start "rule__HttpClientTypeDefinition__Group__3"
    // InternalAceGen.g:2220:1: rule__HttpClientTypeDefinition__Group__3 : rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4 ;
    public final void rule__HttpClientTypeDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2224:1: ( rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4 )
            // InternalAceGen.g:2225:2: rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__HttpClientTypeDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientTypeDefinition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__Group__3"


    // $ANTLR start "rule__HttpClientTypeDefinition__Group__3__Impl"
    // InternalAceGen.g:2232:1: rule__HttpClientTypeDefinition__Group__3__Impl : ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* ) ;
    public final void rule__HttpClientTypeDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2236:1: ( ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* ) )
            // InternalAceGen.g:2237:1: ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* )
            {
            // InternalAceGen.g:2237:1: ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* )
            // InternalAceGen.g:2238:2: ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )*
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getElementsAssignment_3()); 
            // InternalAceGen.g:2239:2: ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalAceGen.g:2239:3: rule__HttpClientTypeDefinition__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpClientTypeDefinition__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getHttpClientTypeDefinitionAccess().getElementsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__Group__3__Impl"


    // $ANTLR start "rule__HttpClientTypeDefinition__Group__4"
    // InternalAceGen.g:2247:1: rule__HttpClientTypeDefinition__Group__4 : rule__HttpClientTypeDefinition__Group__4__Impl ;
    public final void rule__HttpClientTypeDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2251:1: ( rule__HttpClientTypeDefinition__Group__4__Impl )
            // InternalAceGen.g:2252:2: rule__HttpClientTypeDefinition__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientTypeDefinition__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__Group__4"


    // $ANTLR start "rule__HttpClientTypeDefinition__Group__4__Impl"
    // InternalAceGen.g:2258:1: rule__HttpClientTypeDefinition__Group__4__Impl : ( '}' ) ;
    public final void rule__HttpClientTypeDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2262:1: ( ( '}' ) )
            // InternalAceGen.g:2263:1: ( '}' )
            {
            // InternalAceGen.g:2263:1: ( '}' )
            // InternalAceGen.g:2264:2: '}'
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getHttpClientTypeDefinitionAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__Group__4__Impl"


    // $ANTLR start "rule__HttpServer__Group__0"
    // InternalAceGen.g:2274:1: rule__HttpServer__Group__0 : rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1 ;
    public final void rule__HttpServer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2278:1: ( rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1 )
            // InternalAceGen.g:2279:2: rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__HttpServer__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__0"


    // $ANTLR start "rule__HttpServer__Group__0__Impl"
    // InternalAceGen.g:2286:1: rule__HttpServer__Group__0__Impl : ( ( rule__HttpServer__NameAssignment_0 ) ) ;
    public final void rule__HttpServer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2290:1: ( ( ( rule__HttpServer__NameAssignment_0 ) ) )
            // InternalAceGen.g:2291:1: ( ( rule__HttpServer__NameAssignment_0 ) )
            {
            // InternalAceGen.g:2291:1: ( ( rule__HttpServer__NameAssignment_0 ) )
            // InternalAceGen.g:2292:2: ( rule__HttpServer__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerAccess().getNameAssignment_0()); 
            // InternalAceGen.g:2293:2: ( rule__HttpServer__NameAssignment_0 )
            // InternalAceGen.g:2293:3: rule__HttpServer__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__0__Impl"


    // $ANTLR start "rule__HttpServer__Group__1"
    // InternalAceGen.g:2301:1: rule__HttpServer__Group__1 : rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2 ;
    public final void rule__HttpServer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2305:1: ( rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2 )
            // InternalAceGen.g:2306:2: rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__HttpServer__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__1"


    // $ANTLR start "rule__HttpServer__Group__1__Impl"
    // InternalAceGen.g:2313:1: rule__HttpServer__Group__1__Impl : ( ( rule__HttpServer__Group_1__0 )? ) ;
    public final void rule__HttpServer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2317:1: ( ( ( rule__HttpServer__Group_1__0 )? ) )
            // InternalAceGen.g:2318:1: ( ( rule__HttpServer__Group_1__0 )? )
            {
            // InternalAceGen.g:2318:1: ( ( rule__HttpServer__Group_1__0 )? )
            // InternalAceGen.g:2319:2: ( rule__HttpServer__Group_1__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_1()); 
            // InternalAceGen.g:2320:2: ( rule__HttpServer__Group_1__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==44) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAceGen.g:2320:3: rule__HttpServer__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServer__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__1__Impl"


    // $ANTLR start "rule__HttpServer__Group__2"
    // InternalAceGen.g:2328:1: rule__HttpServer__Group__2 : rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3 ;
    public final void rule__HttpServer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2332:1: ( rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3 )
            // InternalAceGen.g:2333:2: rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__HttpServer__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__2"


    // $ANTLR start "rule__HttpServer__Group__2__Impl"
    // InternalAceGen.g:2340:1: rule__HttpServer__Group__2__Impl : ( ( rule__HttpServer__Group_2__0 )? ) ;
    public final void rule__HttpServer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2344:1: ( ( ( rule__HttpServer__Group_2__0 )? ) )
            // InternalAceGen.g:2345:1: ( ( rule__HttpServer__Group_2__0 )? )
            {
            // InternalAceGen.g:2345:1: ( ( rule__HttpServer__Group_2__0 )? )
            // InternalAceGen.g:2346:2: ( rule__HttpServer__Group_2__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_2()); 
            // InternalAceGen.g:2347:2: ( rule__HttpServer__Group_2__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==45) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAceGen.g:2347:3: rule__HttpServer__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServer__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__2__Impl"


    // $ANTLR start "rule__HttpServer__Group__3"
    // InternalAceGen.g:2355:1: rule__HttpServer__Group__3 : rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4 ;
    public final void rule__HttpServer__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2359:1: ( rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4 )
            // InternalAceGen.g:2360:2: rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__HttpServer__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__3"


    // $ANTLR start "rule__HttpServer__Group__3__Impl"
    // InternalAceGen.g:2367:1: rule__HttpServer__Group__3__Impl : ( ( rule__HttpServer__Group_3__0 )? ) ;
    public final void rule__HttpServer__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2371:1: ( ( ( rule__HttpServer__Group_3__0 )? ) )
            // InternalAceGen.g:2372:1: ( ( rule__HttpServer__Group_3__0 )? )
            {
            // InternalAceGen.g:2372:1: ( ( rule__HttpServer__Group_3__0 )? )
            // InternalAceGen.g:2373:2: ( rule__HttpServer__Group_3__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_3()); 
            // InternalAceGen.g:2374:2: ( rule__HttpServer__Group_3__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==29) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalAceGen.g:2374:3: rule__HttpServer__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServer__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__3__Impl"


    // $ANTLR start "rule__HttpServer__Group__4"
    // InternalAceGen.g:2382:1: rule__HttpServer__Group__4 : rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5 ;
    public final void rule__HttpServer__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2386:1: ( rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5 )
            // InternalAceGen.g:2387:2: rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5
            {
            pushFollow(FOLLOW_22);
            rule__HttpServer__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__4"


    // $ANTLR start "rule__HttpServer__Group__4__Impl"
    // InternalAceGen.g:2394:1: rule__HttpServer__Group__4__Impl : ( ( rule__HttpServer__Group_4__0 )? ) ;
    public final void rule__HttpServer__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2398:1: ( ( ( rule__HttpServer__Group_4__0 )? ) )
            // InternalAceGen.g:2399:1: ( ( rule__HttpServer__Group_4__0 )? )
            {
            // InternalAceGen.g:2399:1: ( ( rule__HttpServer__Group_4__0 )? )
            // InternalAceGen.g:2400:2: ( rule__HttpServer__Group_4__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_4()); 
            // InternalAceGen.g:2401:2: ( rule__HttpServer__Group_4__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==46) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalAceGen.g:2401:3: rule__HttpServer__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServer__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__4__Impl"


    // $ANTLR start "rule__HttpServer__Group__5"
    // InternalAceGen.g:2409:1: rule__HttpServer__Group__5 : rule__HttpServer__Group__5__Impl ;
    public final void rule__HttpServer__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2413:1: ( rule__HttpServer__Group__5__Impl )
            // InternalAceGen.g:2414:2: rule__HttpServer__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__5"


    // $ANTLR start "rule__HttpServer__Group__5__Impl"
    // InternalAceGen.g:2420:1: rule__HttpServer__Group__5__Impl : ( ( rule__HttpServer__Group_5__0 )? ) ;
    public final void rule__HttpServer__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2424:1: ( ( ( rule__HttpServer__Group_5__0 )? ) )
            // InternalAceGen.g:2425:1: ( ( rule__HttpServer__Group_5__0 )? )
            {
            // InternalAceGen.g:2425:1: ( ( rule__HttpServer__Group_5__0 )? )
            // InternalAceGen.g:2426:2: ( rule__HttpServer__Group_5__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_5()); 
            // InternalAceGen.g:2427:2: ( rule__HttpServer__Group_5__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==47) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAceGen.g:2427:3: rule__HttpServer__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServer__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group__5__Impl"


    // $ANTLR start "rule__HttpServer__Group_1__0"
    // InternalAceGen.g:2436:1: rule__HttpServer__Group_1__0 : rule__HttpServer__Group_1__0__Impl rule__HttpServer__Group_1__1 ;
    public final void rule__HttpServer__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2440:1: ( rule__HttpServer__Group_1__0__Impl rule__HttpServer__Group_1__1 )
            // InternalAceGen.g:2441:2: rule__HttpServer__Group_1__0__Impl rule__HttpServer__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServer__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_1__0"


    // $ANTLR start "rule__HttpServer__Group_1__0__Impl"
    // InternalAceGen.g:2448:1: rule__HttpServer__Group_1__0__Impl : ( 'Authorization' ) ;
    public final void rule__HttpServer__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2452:1: ( ( 'Authorization' ) )
            // InternalAceGen.g:2453:1: ( 'Authorization' )
            {
            // InternalAceGen.g:2453:1: ( 'Authorization' )
            // InternalAceGen.g:2454:2: 'Authorization'
            {
             before(grammarAccess.getHttpServerAccess().getAuthorizationKeyword_1_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getAuthorizationKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_1__0__Impl"


    // $ANTLR start "rule__HttpServer__Group_1__1"
    // InternalAceGen.g:2463:1: rule__HttpServer__Group_1__1 : rule__HttpServer__Group_1__1__Impl ;
    public final void rule__HttpServer__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2467:1: ( rule__HttpServer__Group_1__1__Impl )
            // InternalAceGen.g:2468:2: rule__HttpServer__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_1__1"


    // $ANTLR start "rule__HttpServer__Group_1__1__Impl"
    // InternalAceGen.g:2474:1: rule__HttpServer__Group_1__1__Impl : ( ( rule__HttpServer__AuthUserAssignment_1_1 ) ) ;
    public final void rule__HttpServer__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2478:1: ( ( ( rule__HttpServer__AuthUserAssignment_1_1 ) ) )
            // InternalAceGen.g:2479:1: ( ( rule__HttpServer__AuthUserAssignment_1_1 ) )
            {
            // InternalAceGen.g:2479:1: ( ( rule__HttpServer__AuthUserAssignment_1_1 ) )
            // InternalAceGen.g:2480:2: ( rule__HttpServer__AuthUserAssignment_1_1 )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserAssignment_1_1()); 
            // InternalAceGen.g:2481:2: ( rule__HttpServer__AuthUserAssignment_1_1 )
            // InternalAceGen.g:2481:3: rule__HttpServer__AuthUserAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__AuthUserAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAccess().getAuthUserAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_1__1__Impl"


    // $ANTLR start "rule__HttpServer__Group_2__0"
    // InternalAceGen.g:2490:1: rule__HttpServer__Group_2__0 : rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1 ;
    public final void rule__HttpServer__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2494:1: ( rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1 )
            // InternalAceGen.g:2495:2: rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServer__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_2__0"


    // $ANTLR start "rule__HttpServer__Group_2__0__Impl"
    // InternalAceGen.g:2502:1: rule__HttpServer__Group_2__0__Impl : ( 'import' ) ;
    public final void rule__HttpServer__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2506:1: ( ( 'import' ) )
            // InternalAceGen.g:2507:1: ( 'import' )
            {
            // InternalAceGen.g:2507:1: ( 'import' )
            // InternalAceGen.g:2508:2: 'import'
            {
             before(grammarAccess.getHttpServerAccess().getImportKeyword_2_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getImportKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_2__0__Impl"


    // $ANTLR start "rule__HttpServer__Group_2__1"
    // InternalAceGen.g:2517:1: rule__HttpServer__Group_2__1 : rule__HttpServer__Group_2__1__Impl ;
    public final void rule__HttpServer__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2521:1: ( rule__HttpServer__Group_2__1__Impl )
            // InternalAceGen.g:2522:2: rule__HttpServer__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_2__1"


    // $ANTLR start "rule__HttpServer__Group_2__1__Impl"
    // InternalAceGen.g:2528:1: rule__HttpServer__Group_2__1__Impl : ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) ) ;
    public final void rule__HttpServer__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2532:1: ( ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) ) )
            // InternalAceGen.g:2533:1: ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) )
            {
            // InternalAceGen.g:2533:1: ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) )
            // InternalAceGen.g:2534:2: ( rule__HttpServer__AuthUserRefAssignment_2_1 )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAssignment_2_1()); 
            // InternalAceGen.g:2535:2: ( rule__HttpServer__AuthUserRefAssignment_2_1 )
            // InternalAceGen.g:2535:3: rule__HttpServer__AuthUserRefAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__AuthUserRefAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAccess().getAuthUserRefAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_2__1__Impl"


    // $ANTLR start "rule__HttpServer__Group_3__0"
    // InternalAceGen.g:2544:1: rule__HttpServer__Group_3__0 : rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1 ;
    public final void rule__HttpServer__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2548:1: ( rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1 )
            // InternalAceGen.g:2549:2: rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1
            {
            pushFollow(FOLLOW_23);
            rule__HttpServer__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_3__0"


    // $ANTLR start "rule__HttpServer__Group_3__0__Impl"
    // InternalAceGen.g:2556:1: rule__HttpServer__Group_3__0__Impl : ( 'ACE' ) ;
    public final void rule__HttpServer__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2560:1: ( ( 'ACE' ) )
            // InternalAceGen.g:2561:1: ( 'ACE' )
            {
            // InternalAceGen.g:2561:1: ( 'ACE' )
            // InternalAceGen.g:2562:2: 'ACE'
            {
             before(grammarAccess.getHttpServerAccess().getACEKeyword_3_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getACEKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_3__0__Impl"


    // $ANTLR start "rule__HttpServer__Group_3__1"
    // InternalAceGen.g:2571:1: rule__HttpServer__Group_3__1 : rule__HttpServer__Group_3__1__Impl ;
    public final void rule__HttpServer__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2575:1: ( rule__HttpServer__Group_3__1__Impl )
            // InternalAceGen.g:2576:2: rule__HttpServer__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_3__1"


    // $ANTLR start "rule__HttpServer__Group_3__1__Impl"
    // InternalAceGen.g:2582:1: rule__HttpServer__Group_3__1__Impl : ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* ) ;
    public final void rule__HttpServer__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2586:1: ( ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* ) )
            // InternalAceGen.g:2587:1: ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* )
            {
            // InternalAceGen.g:2587:1: ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* )
            // InternalAceGen.g:2588:2: ( rule__HttpServer__AceOperationsAssignment_3_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getAceOperationsAssignment_3_1()); 
            // InternalAceGen.g:2589:2: ( rule__HttpServer__AceOperationsAssignment_3_1 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID||LA33_0==58) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalAceGen.g:2589:3: rule__HttpServer__AceOperationsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__HttpServer__AceOperationsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getHttpServerAccess().getAceOperationsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_3__1__Impl"


    // $ANTLR start "rule__HttpServer__Group_4__0"
    // InternalAceGen.g:2598:1: rule__HttpServer__Group_4__0 : rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1 ;
    public final void rule__HttpServer__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2602:1: ( rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1 )
            // InternalAceGen.g:2603:2: rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServer__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_4__0"


    // $ANTLR start "rule__HttpServer__Group_4__0__Impl"
    // InternalAceGen.g:2610:1: rule__HttpServer__Group_4__0__Impl : ( 'views' ) ;
    public final void rule__HttpServer__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2614:1: ( ( 'views' ) )
            // InternalAceGen.g:2615:1: ( 'views' )
            {
            // InternalAceGen.g:2615:1: ( 'views' )
            // InternalAceGen.g:2616:2: 'views'
            {
             before(grammarAccess.getHttpServerAccess().getViewsKeyword_4_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getViewsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_4__0__Impl"


    // $ANTLR start "rule__HttpServer__Group_4__1"
    // InternalAceGen.g:2625:1: rule__HttpServer__Group_4__1 : rule__HttpServer__Group_4__1__Impl ;
    public final void rule__HttpServer__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2629:1: ( rule__HttpServer__Group_4__1__Impl )
            // InternalAceGen.g:2630:2: rule__HttpServer__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_4__1"


    // $ANTLR start "rule__HttpServer__Group_4__1__Impl"
    // InternalAceGen.g:2636:1: rule__HttpServer__Group_4__1__Impl : ( ( rule__HttpServer__ViewsAssignment_4_1 )* ) ;
    public final void rule__HttpServer__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2640:1: ( ( ( rule__HttpServer__ViewsAssignment_4_1 )* ) )
            // InternalAceGen.g:2641:1: ( ( rule__HttpServer__ViewsAssignment_4_1 )* )
            {
            // InternalAceGen.g:2641:1: ( ( rule__HttpServer__ViewsAssignment_4_1 )* )
            // InternalAceGen.g:2642:2: ( rule__HttpServer__ViewsAssignment_4_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getViewsAssignment_4_1()); 
            // InternalAceGen.g:2643:2: ( rule__HttpServer__ViewsAssignment_4_1 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalAceGen.g:2643:3: rule__HttpServer__ViewsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServer__ViewsAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getHttpServerAccess().getViewsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_4__1__Impl"


    // $ANTLR start "rule__HttpServer__Group_5__0"
    // InternalAceGen.g:2652:1: rule__HttpServer__Group_5__0 : rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1 ;
    public final void rule__HttpServer__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2656:1: ( rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1 )
            // InternalAceGen.g:2657:2: rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1
            {
            pushFollow(FOLLOW_25);
            rule__HttpServer__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_5__0"


    // $ANTLR start "rule__HttpServer__Group_5__0__Impl"
    // InternalAceGen.g:2664:1: rule__HttpServer__Group_5__0__Impl : ( 'models' ) ;
    public final void rule__HttpServer__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2668:1: ( ( 'models' ) )
            // InternalAceGen.g:2669:1: ( 'models' )
            {
            // InternalAceGen.g:2669:1: ( 'models' )
            // InternalAceGen.g:2670:2: 'models'
            {
             before(grammarAccess.getHttpServerAccess().getModelsKeyword_5_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getModelsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_5__0__Impl"


    // $ANTLR start "rule__HttpServer__Group_5__1"
    // InternalAceGen.g:2679:1: rule__HttpServer__Group_5__1 : rule__HttpServer__Group_5__1__Impl ;
    public final void rule__HttpServer__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2683:1: ( rule__HttpServer__Group_5__1__Impl )
            // InternalAceGen.g:2684:2: rule__HttpServer__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_5__1"


    // $ANTLR start "rule__HttpServer__Group_5__1__Impl"
    // InternalAceGen.g:2690:1: rule__HttpServer__Group_5__1__Impl : ( ( rule__HttpServer__ModelsAssignment_5_1 )* ) ;
    public final void rule__HttpServer__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2694:1: ( ( ( rule__HttpServer__ModelsAssignment_5_1 )* ) )
            // InternalAceGen.g:2695:1: ( ( rule__HttpServer__ModelsAssignment_5_1 )* )
            {
            // InternalAceGen.g:2695:1: ( ( rule__HttpServer__ModelsAssignment_5_1 )* )
            // InternalAceGen.g:2696:2: ( rule__HttpServer__ModelsAssignment_5_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getModelsAssignment_5_1()); 
            // InternalAceGen.g:2697:2: ( rule__HttpServer__ModelsAssignment_5_1 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID||LA35_0==60) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalAceGen.g:2697:3: rule__HttpServer__ModelsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__HttpServer__ModelsAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getHttpServerAccess().getModelsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__Group_5__1__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__0"
    // InternalAceGen.g:2706:1: rule__HttpServerAceWrite__Group__0 : rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1 ;
    public final void rule__HttpServerAceWrite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2710:1: ( rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1 )
            // InternalAceGen.g:2711:2: rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__HttpServerAceWrite__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__0"


    // $ANTLR start "rule__HttpServerAceWrite__Group__0__Impl"
    // InternalAceGen.g:2718:1: rule__HttpServerAceWrite__Group__0__Impl : ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2722:1: ( ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? ) )
            // InternalAceGen.g:2723:1: ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? )
            {
            // InternalAceGen.g:2723:1: ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? )
            // InternalAceGen.g:2724:2: ( rule__HttpServerAceWrite__ProxyAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyAssignment_0()); 
            // InternalAceGen.g:2725:2: ( rule__HttpServerAceWrite__ProxyAssignment_0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==58) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalAceGen.g:2725:3: rule__HttpServerAceWrite__ProxyAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceWrite__ProxyAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getProxyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__0__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__1"
    // InternalAceGen.g:2733:1: rule__HttpServerAceWrite__Group__1 : rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2 ;
    public final void rule__HttpServerAceWrite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2737:1: ( rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2 )
            // InternalAceGen.g:2738:2: rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__HttpServerAceWrite__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__1"


    // $ANTLR start "rule__HttpServerAceWrite__Group__1__Impl"
    // InternalAceGen.g:2745:1: rule__HttpServerAceWrite__Group__1__Impl : ( ( rule__HttpServerAceWrite__NameAssignment_1 ) ) ;
    public final void rule__HttpServerAceWrite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2749:1: ( ( ( rule__HttpServerAceWrite__NameAssignment_1 ) ) )
            // InternalAceGen.g:2750:1: ( ( rule__HttpServerAceWrite__NameAssignment_1 ) )
            {
            // InternalAceGen.g:2750:1: ( ( rule__HttpServerAceWrite__NameAssignment_1 ) )
            // InternalAceGen.g:2751:2: ( rule__HttpServerAceWrite__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getNameAssignment_1()); 
            // InternalAceGen.g:2752:2: ( rule__HttpServerAceWrite__NameAssignment_1 )
            // InternalAceGen.g:2752:3: rule__HttpServerAceWrite__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAceWriteAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__1__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__2"
    // InternalAceGen.g:2760:1: rule__HttpServerAceWrite__Group__2 : rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3 ;
    public final void rule__HttpServerAceWrite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2764:1: ( rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3 )
            // InternalAceGen.g:2765:2: rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerAceWrite__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__2"


    // $ANTLR start "rule__HttpServerAceWrite__Group__2__Impl"
    // InternalAceGen.g:2772:1: rule__HttpServerAceWrite__Group__2__Impl : ( '<' ) ;
    public final void rule__HttpServerAceWrite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2776:1: ( ( '<' ) )
            // InternalAceGen.g:2777:1: ( '<' )
            {
            // InternalAceGen.g:2777:1: ( '<' )
            // InternalAceGen.g:2778:2: '<'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getLessThanSignKeyword_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceWriteAccess().getLessThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__2__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__3"
    // InternalAceGen.g:2787:1: rule__HttpServerAceWrite__Group__3 : rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4 ;
    public final void rule__HttpServerAceWrite__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2791:1: ( rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4 )
            // InternalAceGen.g:2792:2: rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4
            {
            pushFollow(FOLLOW_28);
            rule__HttpServerAceWrite__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__3"


    // $ANTLR start "rule__HttpServerAceWrite__Group__3__Impl"
    // InternalAceGen.g:2799:1: rule__HttpServerAceWrite__Group__3__Impl : ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) ) ;
    public final void rule__HttpServerAceWrite__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2803:1: ( ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) ) )
            // InternalAceGen.g:2804:1: ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) )
            {
            // InternalAceGen.g:2804:1: ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) )
            // InternalAceGen.g:2805:2: ( rule__HttpServerAceWrite__ModelAssignment_3 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getModelAssignment_3()); 
            // InternalAceGen.g:2806:2: ( rule__HttpServerAceWrite__ModelAssignment_3 )
            // InternalAceGen.g:2806:3: rule__HttpServerAceWrite__ModelAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__ModelAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAceWriteAccess().getModelAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__3__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__4"
    // InternalAceGen.g:2814:1: rule__HttpServerAceWrite__Group__4 : rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5 ;
    public final void rule__HttpServerAceWrite__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2818:1: ( rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5 )
            // InternalAceGen.g:2819:2: rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5
            {
            pushFollow(FOLLOW_29);
            rule__HttpServerAceWrite__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__4"


    // $ANTLR start "rule__HttpServerAceWrite__Group__4__Impl"
    // InternalAceGen.g:2826:1: rule__HttpServerAceWrite__Group__4__Impl : ( '>' ) ;
    public final void rule__HttpServerAceWrite__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2830:1: ( ( '>' ) )
            // InternalAceGen.g:2831:1: ( '>' )
            {
            // InternalAceGen.g:2831:1: ( '>' )
            // InternalAceGen.g:2832:2: '>'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGreaterThanSignKeyword_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceWriteAccess().getGreaterThanSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__4__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__5"
    // InternalAceGen.g:2841:1: rule__HttpServerAceWrite__Group__5 : rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6 ;
    public final void rule__HttpServerAceWrite__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2845:1: ( rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6 )
            // InternalAceGen.g:2846:2: rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6
            {
            pushFollow(FOLLOW_30);
            rule__HttpServerAceWrite__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__5"


    // $ANTLR start "rule__HttpServerAceWrite__Group__5__Impl"
    // InternalAceGen.g:2853:1: rule__HttpServerAceWrite__Group__5__Impl : ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) ) ;
    public final void rule__HttpServerAceWrite__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2857:1: ( ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) ) )
            // InternalAceGen.g:2858:1: ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) )
            {
            // InternalAceGen.g:2858:1: ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) )
            // InternalAceGen.g:2859:2: ( rule__HttpServerAceWrite__TypeAssignment_5 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getTypeAssignment_5()); 
            // InternalAceGen.g:2860:2: ( rule__HttpServerAceWrite__TypeAssignment_5 )
            // InternalAceGen.g:2860:3: rule__HttpServerAceWrite__TypeAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__TypeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAceWriteAccess().getTypeAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__5__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__6"
    // InternalAceGen.g:2868:1: rule__HttpServerAceWrite__Group__6 : rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7 ;
    public final void rule__HttpServerAceWrite__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2872:1: ( rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7 )
            // InternalAceGen.g:2873:2: rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7
            {
            pushFollow(FOLLOW_31);
            rule__HttpServerAceWrite__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__6"


    // $ANTLR start "rule__HttpServerAceWrite__Group__6__Impl"
    // InternalAceGen.g:2880:1: rule__HttpServerAceWrite__Group__6__Impl : ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) ) ;
    public final void rule__HttpServerAceWrite__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2884:1: ( ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) ) )
            // InternalAceGen.g:2885:1: ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) )
            {
            // InternalAceGen.g:2885:1: ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) )
            // InternalAceGen.g:2886:2: ( rule__HttpServerAceWrite__UrlAssignment_6 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getUrlAssignment_6()); 
            // InternalAceGen.g:2887:2: ( rule__HttpServerAceWrite__UrlAssignment_6 )
            // InternalAceGen.g:2887:3: rule__HttpServerAceWrite__UrlAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__UrlAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAceWriteAccess().getUrlAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__6__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__7"
    // InternalAceGen.g:2895:1: rule__HttpServerAceWrite__Group__7 : rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8 ;
    public final void rule__HttpServerAceWrite__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2899:1: ( rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8 )
            // InternalAceGen.g:2900:2: rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8
            {
            pushFollow(FOLLOW_31);
            rule__HttpServerAceWrite__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__7"


    // $ANTLR start "rule__HttpServerAceWrite__Group__7__Impl"
    // InternalAceGen.g:2907:1: rule__HttpServerAceWrite__Group__7__Impl : ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? ) ;
    public final void rule__HttpServerAceWrite__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2911:1: ( ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? ) )
            // InternalAceGen.g:2912:1: ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? )
            {
            // InternalAceGen.g:2912:1: ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? )
            // InternalAceGen.g:2913:2: ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAssignment_7()); 
            // InternalAceGen.g:2914:2: ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==59) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalAceGen.g:2914:3: rule__HttpServerAceWrite__AuthorizeAssignment_7
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceWrite__AuthorizeAssignment_7();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__7__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__8"
    // InternalAceGen.g:2922:1: rule__HttpServerAceWrite__Group__8 : rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9 ;
    public final void rule__HttpServerAceWrite__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2926:1: ( rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9 )
            // InternalAceGen.g:2927:2: rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9
            {
            pushFollow(FOLLOW_31);
            rule__HttpServerAceWrite__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__8"


    // $ANTLR start "rule__HttpServerAceWrite__Group__8__Impl"
    // InternalAceGen.g:2934:1: rule__HttpServerAceWrite__Group__8__Impl : ( ( rule__HttpServerAceWrite__Group_8__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2938:1: ( ( ( rule__HttpServerAceWrite__Group_8__0 )? ) )
            // InternalAceGen.g:2939:1: ( ( rule__HttpServerAceWrite__Group_8__0 )? )
            {
            // InternalAceGen.g:2939:1: ( ( rule__HttpServerAceWrite__Group_8__0 )? )
            // InternalAceGen.g:2940:2: ( rule__HttpServerAceWrite__Group_8__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_8()); 
            // InternalAceGen.g:2941:2: ( rule__HttpServerAceWrite__Group_8__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==48) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAceGen.g:2941:3: rule__HttpServerAceWrite__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceWrite__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__8__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__9"
    // InternalAceGen.g:2949:1: rule__HttpServerAceWrite__Group__9 : rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10 ;
    public final void rule__HttpServerAceWrite__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2953:1: ( rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10 )
            // InternalAceGen.g:2954:2: rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10
            {
            pushFollow(FOLLOW_31);
            rule__HttpServerAceWrite__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__9"


    // $ANTLR start "rule__HttpServerAceWrite__Group__9__Impl"
    // InternalAceGen.g:2961:1: rule__HttpServerAceWrite__Group__9__Impl : ( ( rule__HttpServerAceWrite__Group_9__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2965:1: ( ( ( rule__HttpServerAceWrite__Group_9__0 )? ) )
            // InternalAceGen.g:2966:1: ( ( rule__HttpServerAceWrite__Group_9__0 )? )
            {
            // InternalAceGen.g:2966:1: ( ( rule__HttpServerAceWrite__Group_9__0 )? )
            // InternalAceGen.g:2967:2: ( rule__HttpServerAceWrite__Group_9__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_9()); 
            // InternalAceGen.g:2968:2: ( rule__HttpServerAceWrite__Group_9__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==49) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalAceGen.g:2968:3: rule__HttpServerAceWrite__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceWrite__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__9__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__10"
    // InternalAceGen.g:2976:1: rule__HttpServerAceWrite__Group__10 : rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11 ;
    public final void rule__HttpServerAceWrite__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2980:1: ( rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11 )
            // InternalAceGen.g:2981:2: rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11
            {
            pushFollow(FOLLOW_31);
            rule__HttpServerAceWrite__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__10"


    // $ANTLR start "rule__HttpServerAceWrite__Group__10__Impl"
    // InternalAceGen.g:2988:1: rule__HttpServerAceWrite__Group__10__Impl : ( ( rule__HttpServerAceWrite__Group_10__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2992:1: ( ( ( rule__HttpServerAceWrite__Group_10__0 )? ) )
            // InternalAceGen.g:2993:1: ( ( rule__HttpServerAceWrite__Group_10__0 )? )
            {
            // InternalAceGen.g:2993:1: ( ( rule__HttpServerAceWrite__Group_10__0 )? )
            // InternalAceGen.g:2994:2: ( rule__HttpServerAceWrite__Group_10__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_10()); 
            // InternalAceGen.g:2995:2: ( rule__HttpServerAceWrite__Group_10__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==50) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalAceGen.g:2995:3: rule__HttpServerAceWrite__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceWrite__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__10__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__11"
    // InternalAceGen.g:3003:1: rule__HttpServerAceWrite__Group__11 : rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12 ;
    public final void rule__HttpServerAceWrite__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3007:1: ( rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12 )
            // InternalAceGen.g:3008:2: rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12
            {
            pushFollow(FOLLOW_31);
            rule__HttpServerAceWrite__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__11"


    // $ANTLR start "rule__HttpServerAceWrite__Group__11__Impl"
    // InternalAceGen.g:3015:1: rule__HttpServerAceWrite__Group__11__Impl : ( ( rule__HttpServerAceWrite__Group_11__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3019:1: ( ( ( rule__HttpServerAceWrite__Group_11__0 )? ) )
            // InternalAceGen.g:3020:1: ( ( rule__HttpServerAceWrite__Group_11__0 )? )
            {
            // InternalAceGen.g:3020:1: ( ( rule__HttpServerAceWrite__Group_11__0 )? )
            // InternalAceGen.g:3021:2: ( rule__HttpServerAceWrite__Group_11__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_11()); 
            // InternalAceGen.g:3022:2: ( rule__HttpServerAceWrite__Group_11__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==51) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalAceGen.g:3022:3: rule__HttpServerAceWrite__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceWrite__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__11__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__12"
    // InternalAceGen.g:3030:1: rule__HttpServerAceWrite__Group__12 : rule__HttpServerAceWrite__Group__12__Impl ;
    public final void rule__HttpServerAceWrite__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3034:1: ( rule__HttpServerAceWrite__Group__12__Impl )
            // InternalAceGen.g:3035:2: rule__HttpServerAceWrite__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__12"


    // $ANTLR start "rule__HttpServerAceWrite__Group__12__Impl"
    // InternalAceGen.g:3041:1: rule__HttpServerAceWrite__Group__12__Impl : ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* ) ;
    public final void rule__HttpServerAceWrite__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3045:1: ( ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* ) )
            // InternalAceGen.g:3046:1: ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* )
            {
            // InternalAceGen.g:3046:1: ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* )
            // InternalAceGen.g:3047:2: ( rule__HttpServerAceWrite__OutcomesAssignment_12 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getOutcomesAssignment_12()); 
            // InternalAceGen.g:3048:2: ( rule__HttpServerAceWrite__OutcomesAssignment_12 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==36) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalAceGen.g:3048:3: rule__HttpServerAceWrite__OutcomesAssignment_12
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__HttpServerAceWrite__OutcomesAssignment_12();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getHttpServerAceWriteAccess().getOutcomesAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group__12__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group_8__0"
    // InternalAceGen.g:3057:1: rule__HttpServerAceWrite__Group_8__0 : rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1 ;
    public final void rule__HttpServerAceWrite__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3061:1: ( rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1 )
            // InternalAceGen.g:3062:2: rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerAceWrite__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_8__0"


    // $ANTLR start "rule__HttpServerAceWrite__Group_8__0__Impl"
    // InternalAceGen.g:3069:1: rule__HttpServerAceWrite__Group_8__0__Impl : ( 'pathParams' ) ;
    public final void rule__HttpServerAceWrite__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3073:1: ( ( 'pathParams' ) )
            // InternalAceGen.g:3074:1: ( 'pathParams' )
            {
            // InternalAceGen.g:3074:1: ( 'pathParams' )
            // InternalAceGen.g:3075:2: 'pathParams'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_8_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_8__0__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group_8__1"
    // InternalAceGen.g:3084:1: rule__HttpServerAceWrite__Group_8__1 : rule__HttpServerAceWrite__Group_8__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3088:1: ( rule__HttpServerAceWrite__Group_8__1__Impl )
            // InternalAceGen.g:3089:2: rule__HttpServerAceWrite__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_8__1"


    // $ANTLR start "rule__HttpServerAceWrite__Group_8__1__Impl"
    // InternalAceGen.g:3095:1: rule__HttpServerAceWrite__Group_8__1__Impl : ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3099:1: ( ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* ) )
            // InternalAceGen.g:3100:1: ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* )
            {
            // InternalAceGen.g:3100:1: ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* )
            // InternalAceGen.g:3101:2: ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAssignment_8_1()); 
            // InternalAceGen.g:3102:2: ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID) ) {
                    int LA43_2 = input.LA(2);

                    if ( (LA43_2==EOF||LA43_2==RULE_ID||LA43_2==36||(LA43_2>=46 && LA43_2<=47)||(LA43_2>=49 && LA43_2<=51)||LA43_2==54||LA43_2==58) ) {
                        alt43=1;
                    }


                }


                switch (alt43) {
            	case 1 :
            	    // InternalAceGen.g:3102:3: rule__HttpServerAceWrite__PathParamsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceWrite__PathParamsAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_8__1__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group_9__0"
    // InternalAceGen.g:3111:1: rule__HttpServerAceWrite__Group_9__0 : rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1 ;
    public final void rule__HttpServerAceWrite__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3115:1: ( rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1 )
            // InternalAceGen.g:3116:2: rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerAceWrite__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_9__0"


    // $ANTLR start "rule__HttpServerAceWrite__Group_9__0__Impl"
    // InternalAceGen.g:3123:1: rule__HttpServerAceWrite__Group_9__0__Impl : ( 'queryParams' ) ;
    public final void rule__HttpServerAceWrite__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3127:1: ( ( 'queryParams' ) )
            // InternalAceGen.g:3128:1: ( 'queryParams' )
            {
            // InternalAceGen.g:3128:1: ( 'queryParams' )
            // InternalAceGen.g:3129:2: 'queryParams'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_9_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_9__0__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group_9__1"
    // InternalAceGen.g:3138:1: rule__HttpServerAceWrite__Group_9__1 : rule__HttpServerAceWrite__Group_9__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3142:1: ( rule__HttpServerAceWrite__Group_9__1__Impl )
            // InternalAceGen.g:3143:2: rule__HttpServerAceWrite__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_9__1"


    // $ANTLR start "rule__HttpServerAceWrite__Group_9__1__Impl"
    // InternalAceGen.g:3149:1: rule__HttpServerAceWrite__Group_9__1__Impl : ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3153:1: ( ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* ) )
            // InternalAceGen.g:3154:1: ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* )
            {
            // InternalAceGen.g:3154:1: ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* )
            // InternalAceGen.g:3155:2: ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAssignment_9_1()); 
            // InternalAceGen.g:3156:2: ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_ID) ) {
                    int LA44_2 = input.LA(2);

                    if ( (LA44_2==EOF||LA44_2==RULE_ID||LA44_2==36||(LA44_2>=46 && LA44_2<=47)||(LA44_2>=50 && LA44_2<=51)||LA44_2==54||LA44_2==58) ) {
                        alt44=1;
                    }


                }


                switch (alt44) {
            	case 1 :
            	    // InternalAceGen.g:3156:3: rule__HttpServerAceWrite__QueryParamsAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceWrite__QueryParamsAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_9__1__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group_10__0"
    // InternalAceGen.g:3165:1: rule__HttpServerAceWrite__Group_10__0 : rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1 ;
    public final void rule__HttpServerAceWrite__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3169:1: ( rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1 )
            // InternalAceGen.g:3170:2: rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerAceWrite__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_10__0"


    // $ANTLR start "rule__HttpServerAceWrite__Group_10__0__Impl"
    // InternalAceGen.g:3177:1: rule__HttpServerAceWrite__Group_10__0__Impl : ( 'payload' ) ;
    public final void rule__HttpServerAceWrite__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3181:1: ( ( 'payload' ) )
            // InternalAceGen.g:3182:1: ( 'payload' )
            {
            // InternalAceGen.g:3182:1: ( 'payload' )
            // InternalAceGen.g:3183:2: 'payload'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_10_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_10__0__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group_10__1"
    // InternalAceGen.g:3192:1: rule__HttpServerAceWrite__Group_10__1 : rule__HttpServerAceWrite__Group_10__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3196:1: ( rule__HttpServerAceWrite__Group_10__1__Impl )
            // InternalAceGen.g:3197:2: rule__HttpServerAceWrite__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_10__1"


    // $ANTLR start "rule__HttpServerAceWrite__Group_10__1__Impl"
    // InternalAceGen.g:3203:1: rule__HttpServerAceWrite__Group_10__1__Impl : ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3207:1: ( ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* ) )
            // InternalAceGen.g:3208:1: ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* )
            {
            // InternalAceGen.g:3208:1: ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* )
            // InternalAceGen.g:3209:2: ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadAssignment_10_1()); 
            // InternalAceGen.g:3210:2: ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_ID) ) {
                    int LA45_2 = input.LA(2);

                    if ( (LA45_2==EOF||LA45_2==RULE_ID||LA45_2==36||(LA45_2>=46 && LA45_2<=47)||LA45_2==51||LA45_2==54||LA45_2==58) ) {
                        alt45=1;
                    }


                }


                switch (alt45) {
            	case 1 :
            	    // InternalAceGen.g:3210:3: rule__HttpServerAceWrite__PayloadAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceWrite__PayloadAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

             after(grammarAccess.getHttpServerAceWriteAccess().getPayloadAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_10__1__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group_11__0"
    // InternalAceGen.g:3219:1: rule__HttpServerAceWrite__Group_11__0 : rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1 ;
    public final void rule__HttpServerAceWrite__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3223:1: ( rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1 )
            // InternalAceGen.g:3224:2: rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerAceWrite__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_11__0"


    // $ANTLR start "rule__HttpServerAceWrite__Group_11__0__Impl"
    // InternalAceGen.g:3231:1: rule__HttpServerAceWrite__Group_11__0__Impl : ( 'response' ) ;
    public final void rule__HttpServerAceWrite__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3235:1: ( ( 'response' ) )
            // InternalAceGen.g:3236:1: ( 'response' )
            {
            // InternalAceGen.g:3236:1: ( 'response' )
            // InternalAceGen.g:3237:2: 'response'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_11_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_11__0__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group_11__1"
    // InternalAceGen.g:3246:1: rule__HttpServerAceWrite__Group_11__1 : rule__HttpServerAceWrite__Group_11__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3250:1: ( rule__HttpServerAceWrite__Group_11__1__Impl )
            // InternalAceGen.g:3251:2: rule__HttpServerAceWrite__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceWrite__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_11__1"


    // $ANTLR start "rule__HttpServerAceWrite__Group_11__1__Impl"
    // InternalAceGen.g:3257:1: rule__HttpServerAceWrite__Group_11__1__Impl : ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3261:1: ( ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* ) )
            // InternalAceGen.g:3262:1: ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* )
            {
            // InternalAceGen.g:3262:1: ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* )
            // InternalAceGen.g:3263:2: ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseAssignment_11_1()); 
            // InternalAceGen.g:3264:2: ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID) ) {
                    int LA46_2 = input.LA(2);

                    if ( (LA46_2==EOF||LA46_2==RULE_ID||LA46_2==36||(LA46_2>=46 && LA46_2<=47)||LA46_2==54||LA46_2==58) ) {
                        alt46=1;
                    }


                }


                switch (alt46) {
            	case 1 :
            	    // InternalAceGen.g:3264:3: rule__HttpServerAceWrite__ResponseAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceWrite__ResponseAssignment_11_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getHttpServerAceWriteAccess().getResponseAssignment_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__Group_11__1__Impl"


    // $ANTLR start "rule__HttpServerOutcome__Group__0"
    // InternalAceGen.g:3273:1: rule__HttpServerOutcome__Group__0 : rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1 ;
    public final void rule__HttpServerOutcome__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3277:1: ( rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1 )
            // InternalAceGen.g:3278:2: rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerOutcome__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group__0"


    // $ANTLR start "rule__HttpServerOutcome__Group__0__Impl"
    // InternalAceGen.g:3285:1: rule__HttpServerOutcome__Group__0__Impl : ( 'on' ) ;
    public final void rule__HttpServerOutcome__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3289:1: ( ( 'on' ) )
            // InternalAceGen.g:3290:1: ( 'on' )
            {
            // InternalAceGen.g:3290:1: ( 'on' )
            // InternalAceGen.g:3291:2: 'on'
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getOnKeyword_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getHttpServerOutcomeAccess().getOnKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group__0__Impl"


    // $ANTLR start "rule__HttpServerOutcome__Group__1"
    // InternalAceGen.g:3300:1: rule__HttpServerOutcome__Group__1 : rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2 ;
    public final void rule__HttpServerOutcome__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3304:1: ( rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2 )
            // InternalAceGen.g:3305:2: rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__HttpServerOutcome__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group__1"


    // $ANTLR start "rule__HttpServerOutcome__Group__1__Impl"
    // InternalAceGen.g:3312:1: rule__HttpServerOutcome__Group__1__Impl : ( ( rule__HttpServerOutcome__NameAssignment_1 ) ) ;
    public final void rule__HttpServerOutcome__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3316:1: ( ( ( rule__HttpServerOutcome__NameAssignment_1 ) ) )
            // InternalAceGen.g:3317:1: ( ( rule__HttpServerOutcome__NameAssignment_1 ) )
            {
            // InternalAceGen.g:3317:1: ( ( rule__HttpServerOutcome__NameAssignment_1 ) )
            // InternalAceGen.g:3318:2: ( rule__HttpServerOutcome__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getNameAssignment_1()); 
            // InternalAceGen.g:3319:2: ( rule__HttpServerOutcome__NameAssignment_1 )
            // InternalAceGen.g:3319:3: rule__HttpServerOutcome__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerOutcomeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group__1__Impl"


    // $ANTLR start "rule__HttpServerOutcome__Group__2"
    // InternalAceGen.g:3327:1: rule__HttpServerOutcome__Group__2 : rule__HttpServerOutcome__Group__2__Impl rule__HttpServerOutcome__Group__3 ;
    public final void rule__HttpServerOutcome__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3331:1: ( rule__HttpServerOutcome__Group__2__Impl rule__HttpServerOutcome__Group__3 )
            // InternalAceGen.g:3332:2: rule__HttpServerOutcome__Group__2__Impl rule__HttpServerOutcome__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__HttpServerOutcome__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group__2"


    // $ANTLR start "rule__HttpServerOutcome__Group__2__Impl"
    // InternalAceGen.g:3339:1: rule__HttpServerOutcome__Group__2__Impl : ( ( rule__HttpServerOutcome__Group_2__0 )* ) ;
    public final void rule__HttpServerOutcome__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3343:1: ( ( ( rule__HttpServerOutcome__Group_2__0 )* ) )
            // InternalAceGen.g:3344:1: ( ( rule__HttpServerOutcome__Group_2__0 )* )
            {
            // InternalAceGen.g:3344:1: ( ( rule__HttpServerOutcome__Group_2__0 )* )
            // InternalAceGen.g:3345:2: ( rule__HttpServerOutcome__Group_2__0 )*
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getGroup_2()); 
            // InternalAceGen.g:3346:2: ( rule__HttpServerOutcome__Group_2__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==37) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalAceGen.g:3346:3: rule__HttpServerOutcome__Group_2__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__HttpServerOutcome__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getHttpServerOutcomeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group__2__Impl"


    // $ANTLR start "rule__HttpServerOutcome__Group__3"
    // InternalAceGen.g:3354:1: rule__HttpServerOutcome__Group__3 : rule__HttpServerOutcome__Group__3__Impl ;
    public final void rule__HttpServerOutcome__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3358:1: ( rule__HttpServerOutcome__Group__3__Impl )
            // InternalAceGen.g:3359:2: rule__HttpServerOutcome__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group__3"


    // $ANTLR start "rule__HttpServerOutcome__Group__3__Impl"
    // InternalAceGen.g:3365:1: rule__HttpServerOutcome__Group__3__Impl : ( ( rule__HttpServerOutcome__Group_3__0 )? ) ;
    public final void rule__HttpServerOutcome__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3369:1: ( ( ( rule__HttpServerOutcome__Group_3__0 )? ) )
            // InternalAceGen.g:3370:1: ( ( rule__HttpServerOutcome__Group_3__0 )? )
            {
            // InternalAceGen.g:3370:1: ( ( rule__HttpServerOutcome__Group_3__0 )? )
            // InternalAceGen.g:3371:2: ( rule__HttpServerOutcome__Group_3__0 )?
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getGroup_3()); 
            // InternalAceGen.g:3372:2: ( rule__HttpServerOutcome__Group_3__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==39) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalAceGen.g:3372:3: rule__HttpServerOutcome__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerOutcome__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerOutcomeAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group__3__Impl"


    // $ANTLR start "rule__HttpServerOutcome__Group_2__0"
    // InternalAceGen.g:3381:1: rule__HttpServerOutcome__Group_2__0 : rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1 ;
    public final void rule__HttpServerOutcome__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3385:1: ( rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1 )
            // InternalAceGen.g:3386:2: rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1
            {
            pushFollow(FOLLOW_15);
            rule__HttpServerOutcome__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_2__0"


    // $ANTLR start "rule__HttpServerOutcome__Group_2__0__Impl"
    // InternalAceGen.g:3393:1: rule__HttpServerOutcome__Group_2__0__Impl : ( '(' ) ;
    public final void rule__HttpServerOutcome__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3397:1: ( ( '(' ) )
            // InternalAceGen.g:3398:1: ( '(' )
            {
            // InternalAceGen.g:3398:1: ( '(' )
            // InternalAceGen.g:3399:2: '('
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_2__0__Impl"


    // $ANTLR start "rule__HttpServerOutcome__Group_2__1"
    // InternalAceGen.g:3408:1: rule__HttpServerOutcome__Group_2__1 : rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2 ;
    public final void rule__HttpServerOutcome__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3412:1: ( rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2 )
            // InternalAceGen.g:3413:2: rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2
            {
            pushFollow(FOLLOW_15);
            rule__HttpServerOutcome__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_2__1"


    // $ANTLR start "rule__HttpServerOutcome__Group_2__1__Impl"
    // InternalAceGen.g:3420:1: rule__HttpServerOutcome__Group_2__1__Impl : ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* ) ;
    public final void rule__HttpServerOutcome__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3424:1: ( ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* ) )
            // InternalAceGen.g:3425:1: ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* )
            {
            // InternalAceGen.g:3425:1: ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* )
            // InternalAceGen.g:3426:2: ( rule__HttpServerOutcome__ListenersAssignment_2_1 )*
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getListenersAssignment_2_1()); 
            // InternalAceGen.g:3427:2: ( rule__HttpServerOutcome__ListenersAssignment_2_1 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_ID) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalAceGen.g:3427:3: rule__HttpServerOutcome__ListenersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerOutcome__ListenersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getHttpServerOutcomeAccess().getListenersAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_2__1__Impl"


    // $ANTLR start "rule__HttpServerOutcome__Group_2__2"
    // InternalAceGen.g:3435:1: rule__HttpServerOutcome__Group_2__2 : rule__HttpServerOutcome__Group_2__2__Impl ;
    public final void rule__HttpServerOutcome__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3439:1: ( rule__HttpServerOutcome__Group_2__2__Impl )
            // InternalAceGen.g:3440:2: rule__HttpServerOutcome__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_2__2"


    // $ANTLR start "rule__HttpServerOutcome__Group_2__2__Impl"
    // InternalAceGen.g:3446:1: rule__HttpServerOutcome__Group_2__2__Impl : ( ')' ) ;
    public final void rule__HttpServerOutcome__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3450:1: ( ( ')' ) )
            // InternalAceGen.g:3451:1: ( ')' )
            {
            // InternalAceGen.g:3451:1: ( ')' )
            // InternalAceGen.g:3452:2: ')'
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_2__2__Impl"


    // $ANTLR start "rule__HttpServerOutcome__Group_3__0"
    // InternalAceGen.g:3462:1: rule__HttpServerOutcome__Group_3__0 : rule__HttpServerOutcome__Group_3__0__Impl rule__HttpServerOutcome__Group_3__1 ;
    public final void rule__HttpServerOutcome__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3466:1: ( rule__HttpServerOutcome__Group_3__0__Impl rule__HttpServerOutcome__Group_3__1 )
            // InternalAceGen.g:3467:2: rule__HttpServerOutcome__Group_3__0__Impl rule__HttpServerOutcome__Group_3__1
            {
            pushFollow(FOLLOW_14);
            rule__HttpServerOutcome__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_3__0"


    // $ANTLR start "rule__HttpServerOutcome__Group_3__0__Impl"
    // InternalAceGen.g:3474:1: rule__HttpServerOutcome__Group_3__0__Impl : ( 'triggers' ) ;
    public final void rule__HttpServerOutcome__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3478:1: ( ( 'triggers' ) )
            // InternalAceGen.g:3479:1: ( 'triggers' )
            {
            // InternalAceGen.g:3479:1: ( 'triggers' )
            // InternalAceGen.g:3480:2: 'triggers'
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getTriggersKeyword_3_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getHttpServerOutcomeAccess().getTriggersKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_3__0__Impl"


    // $ANTLR start "rule__HttpServerOutcome__Group_3__1"
    // InternalAceGen.g:3489:1: rule__HttpServerOutcome__Group_3__1 : rule__HttpServerOutcome__Group_3__1__Impl rule__HttpServerOutcome__Group_3__2 ;
    public final void rule__HttpServerOutcome__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3493:1: ( rule__HttpServerOutcome__Group_3__1__Impl rule__HttpServerOutcome__Group_3__2 )
            // InternalAceGen.g:3494:2: rule__HttpServerOutcome__Group_3__1__Impl rule__HttpServerOutcome__Group_3__2
            {
            pushFollow(FOLLOW_15);
            rule__HttpServerOutcome__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_3__1"


    // $ANTLR start "rule__HttpServerOutcome__Group_3__1__Impl"
    // InternalAceGen.g:3501:1: rule__HttpServerOutcome__Group_3__1__Impl : ( '(' ) ;
    public final void rule__HttpServerOutcome__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3505:1: ( ( '(' ) )
            // InternalAceGen.g:3506:1: ( '(' )
            {
            // InternalAceGen.g:3506:1: ( '(' )
            // InternalAceGen.g:3507:2: '('
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_3__1__Impl"


    // $ANTLR start "rule__HttpServerOutcome__Group_3__2"
    // InternalAceGen.g:3516:1: rule__HttpServerOutcome__Group_3__2 : rule__HttpServerOutcome__Group_3__2__Impl rule__HttpServerOutcome__Group_3__3 ;
    public final void rule__HttpServerOutcome__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3520:1: ( rule__HttpServerOutcome__Group_3__2__Impl rule__HttpServerOutcome__Group_3__3 )
            // InternalAceGen.g:3521:2: rule__HttpServerOutcome__Group_3__2__Impl rule__HttpServerOutcome__Group_3__3
            {
            pushFollow(FOLLOW_15);
            rule__HttpServerOutcome__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_3__2"


    // $ANTLR start "rule__HttpServerOutcome__Group_3__2__Impl"
    // InternalAceGen.g:3528:1: rule__HttpServerOutcome__Group_3__2__Impl : ( ( rule__HttpServerOutcome__AceOperationsAssignment_3_2 )* ) ;
    public final void rule__HttpServerOutcome__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3532:1: ( ( ( rule__HttpServerOutcome__AceOperationsAssignment_3_2 )* ) )
            // InternalAceGen.g:3533:1: ( ( rule__HttpServerOutcome__AceOperationsAssignment_3_2 )* )
            {
            // InternalAceGen.g:3533:1: ( ( rule__HttpServerOutcome__AceOperationsAssignment_3_2 )* )
            // InternalAceGen.g:3534:2: ( rule__HttpServerOutcome__AceOperationsAssignment_3_2 )*
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getAceOperationsAssignment_3_2()); 
            // InternalAceGen.g:3535:2: ( rule__HttpServerOutcome__AceOperationsAssignment_3_2 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalAceGen.g:3535:3: rule__HttpServerOutcome__AceOperationsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerOutcome__AceOperationsAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

             after(grammarAccess.getHttpServerOutcomeAccess().getAceOperationsAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_3__2__Impl"


    // $ANTLR start "rule__HttpServerOutcome__Group_3__3"
    // InternalAceGen.g:3543:1: rule__HttpServerOutcome__Group_3__3 : rule__HttpServerOutcome__Group_3__3__Impl ;
    public final void rule__HttpServerOutcome__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3547:1: ( rule__HttpServerOutcome__Group_3__3__Impl )
            // InternalAceGen.g:3548:2: rule__HttpServerOutcome__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_3__3"


    // $ANTLR start "rule__HttpServerOutcome__Group_3__3__Impl"
    // InternalAceGen.g:3554:1: rule__HttpServerOutcome__Group_3__3__Impl : ( ')' ) ;
    public final void rule__HttpServerOutcome__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3558:1: ( ( ')' ) )
            // InternalAceGen.g:3559:1: ( ')' )
            {
            // InternalAceGen.g:3559:1: ( ')' )
            // InternalAceGen.g:3560:2: ')'
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_3_3()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__Group_3__3__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__0"
    // InternalAceGen.g:3570:1: rule__HttpServerAceRead__Group__0 : rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1 ;
    public final void rule__HttpServerAceRead__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3574:1: ( rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1 )
            // InternalAceGen.g:3575:2: rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__HttpServerAceRead__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__0"


    // $ANTLR start "rule__HttpServerAceRead__Group__0__Impl"
    // InternalAceGen.g:3582:1: rule__HttpServerAceRead__Group__0__Impl : ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? ) ;
    public final void rule__HttpServerAceRead__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3586:1: ( ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? ) )
            // InternalAceGen.g:3587:1: ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? )
            {
            // InternalAceGen.g:3587:1: ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? )
            // InternalAceGen.g:3588:2: ( rule__HttpServerAceRead__ProxyAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyAssignment_0()); 
            // InternalAceGen.g:3589:2: ( rule__HttpServerAceRead__ProxyAssignment_0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==58) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalAceGen.g:3589:3: rule__HttpServerAceRead__ProxyAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceRead__ProxyAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceReadAccess().getProxyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__0__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__1"
    // InternalAceGen.g:3597:1: rule__HttpServerAceRead__Group__1 : rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2 ;
    public final void rule__HttpServerAceRead__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3601:1: ( rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2 )
            // InternalAceGen.g:3602:2: rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__HttpServerAceRead__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__1"


    // $ANTLR start "rule__HttpServerAceRead__Group__1__Impl"
    // InternalAceGen.g:3609:1: rule__HttpServerAceRead__Group__1__Impl : ( ( rule__HttpServerAceRead__NameAssignment_1 ) ) ;
    public final void rule__HttpServerAceRead__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3613:1: ( ( ( rule__HttpServerAceRead__NameAssignment_1 ) ) )
            // InternalAceGen.g:3614:1: ( ( rule__HttpServerAceRead__NameAssignment_1 ) )
            {
            // InternalAceGen.g:3614:1: ( ( rule__HttpServerAceRead__NameAssignment_1 ) )
            // InternalAceGen.g:3615:2: ( rule__HttpServerAceRead__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getNameAssignment_1()); 
            // InternalAceGen.g:3616:2: ( rule__HttpServerAceRead__NameAssignment_1 )
            // InternalAceGen.g:3616:3: rule__HttpServerAceRead__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAceReadAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__1__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__2"
    // InternalAceGen.g:3624:1: rule__HttpServerAceRead__Group__2 : rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3 ;
    public final void rule__HttpServerAceRead__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3628:1: ( rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3 )
            // InternalAceGen.g:3629:2: rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerAceRead__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__2"


    // $ANTLR start "rule__HttpServerAceRead__Group__2__Impl"
    // InternalAceGen.g:3636:1: rule__HttpServerAceRead__Group__2__Impl : ( '<' ) ;
    public final void rule__HttpServerAceRead__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3640:1: ( ( '<' ) )
            // InternalAceGen.g:3641:1: ( '<' )
            {
            // InternalAceGen.g:3641:1: ( '<' )
            // InternalAceGen.g:3642:2: '<'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getLessThanSignKeyword_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceReadAccess().getLessThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__2__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__3"
    // InternalAceGen.g:3651:1: rule__HttpServerAceRead__Group__3 : rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4 ;
    public final void rule__HttpServerAceRead__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3655:1: ( rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4 )
            // InternalAceGen.g:3656:2: rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4
            {
            pushFollow(FOLLOW_28);
            rule__HttpServerAceRead__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__3"


    // $ANTLR start "rule__HttpServerAceRead__Group__3__Impl"
    // InternalAceGen.g:3663:1: rule__HttpServerAceRead__Group__3__Impl : ( ( rule__HttpServerAceRead__ModelAssignment_3 ) ) ;
    public final void rule__HttpServerAceRead__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3667:1: ( ( ( rule__HttpServerAceRead__ModelAssignment_3 ) ) )
            // InternalAceGen.g:3668:1: ( ( rule__HttpServerAceRead__ModelAssignment_3 ) )
            {
            // InternalAceGen.g:3668:1: ( ( rule__HttpServerAceRead__ModelAssignment_3 ) )
            // InternalAceGen.g:3669:2: ( rule__HttpServerAceRead__ModelAssignment_3 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getModelAssignment_3()); 
            // InternalAceGen.g:3670:2: ( rule__HttpServerAceRead__ModelAssignment_3 )
            // InternalAceGen.g:3670:3: rule__HttpServerAceRead__ModelAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__ModelAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAceReadAccess().getModelAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__3__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__4"
    // InternalAceGen.g:3678:1: rule__HttpServerAceRead__Group__4 : rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5 ;
    public final void rule__HttpServerAceRead__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3682:1: ( rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5 )
            // InternalAceGen.g:3683:2: rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5
            {
            pushFollow(FOLLOW_33);
            rule__HttpServerAceRead__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__4"


    // $ANTLR start "rule__HttpServerAceRead__Group__4__Impl"
    // InternalAceGen.g:3690:1: rule__HttpServerAceRead__Group__4__Impl : ( '>' ) ;
    public final void rule__HttpServerAceRead__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3694:1: ( ( '>' ) )
            // InternalAceGen.g:3695:1: ( '>' )
            {
            // InternalAceGen.g:3695:1: ( '>' )
            // InternalAceGen.g:3696:2: '>'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGreaterThanSignKeyword_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceReadAccess().getGreaterThanSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__4__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__5"
    // InternalAceGen.g:3705:1: rule__HttpServerAceRead__Group__5 : rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6 ;
    public final void rule__HttpServerAceRead__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3709:1: ( rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6 )
            // InternalAceGen.g:3710:2: rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6
            {
            pushFollow(FOLLOW_30);
            rule__HttpServerAceRead__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__5"


    // $ANTLR start "rule__HttpServerAceRead__Group__5__Impl"
    // InternalAceGen.g:3717:1: rule__HttpServerAceRead__Group__5__Impl : ( ( rule__HttpServerAceRead__TypeAssignment_5 ) ) ;
    public final void rule__HttpServerAceRead__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3721:1: ( ( ( rule__HttpServerAceRead__TypeAssignment_5 ) ) )
            // InternalAceGen.g:3722:1: ( ( rule__HttpServerAceRead__TypeAssignment_5 ) )
            {
            // InternalAceGen.g:3722:1: ( ( rule__HttpServerAceRead__TypeAssignment_5 ) )
            // InternalAceGen.g:3723:2: ( rule__HttpServerAceRead__TypeAssignment_5 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getTypeAssignment_5()); 
            // InternalAceGen.g:3724:2: ( rule__HttpServerAceRead__TypeAssignment_5 )
            // InternalAceGen.g:3724:3: rule__HttpServerAceRead__TypeAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__TypeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAceReadAccess().getTypeAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__5__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__6"
    // InternalAceGen.g:3732:1: rule__HttpServerAceRead__Group__6 : rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7 ;
    public final void rule__HttpServerAceRead__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3736:1: ( rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7 )
            // InternalAceGen.g:3737:2: rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7
            {
            pushFollow(FOLLOW_34);
            rule__HttpServerAceRead__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__6"


    // $ANTLR start "rule__HttpServerAceRead__Group__6__Impl"
    // InternalAceGen.g:3744:1: rule__HttpServerAceRead__Group__6__Impl : ( ( rule__HttpServerAceRead__UrlAssignment_6 ) ) ;
    public final void rule__HttpServerAceRead__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3748:1: ( ( ( rule__HttpServerAceRead__UrlAssignment_6 ) ) )
            // InternalAceGen.g:3749:1: ( ( rule__HttpServerAceRead__UrlAssignment_6 ) )
            {
            // InternalAceGen.g:3749:1: ( ( rule__HttpServerAceRead__UrlAssignment_6 ) )
            // InternalAceGen.g:3750:2: ( rule__HttpServerAceRead__UrlAssignment_6 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getUrlAssignment_6()); 
            // InternalAceGen.g:3751:2: ( rule__HttpServerAceRead__UrlAssignment_6 )
            // InternalAceGen.g:3751:3: rule__HttpServerAceRead__UrlAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__UrlAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAceReadAccess().getUrlAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__6__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__7"
    // InternalAceGen.g:3759:1: rule__HttpServerAceRead__Group__7 : rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8 ;
    public final void rule__HttpServerAceRead__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3763:1: ( rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8 )
            // InternalAceGen.g:3764:2: rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8
            {
            pushFollow(FOLLOW_34);
            rule__HttpServerAceRead__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__7"


    // $ANTLR start "rule__HttpServerAceRead__Group__7__Impl"
    // InternalAceGen.g:3771:1: rule__HttpServerAceRead__Group__7__Impl : ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? ) ;
    public final void rule__HttpServerAceRead__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3775:1: ( ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? ) )
            // InternalAceGen.g:3776:1: ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? )
            {
            // InternalAceGen.g:3776:1: ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? )
            // InternalAceGen.g:3777:2: ( rule__HttpServerAceRead__AuthorizeAssignment_7 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAssignment_7()); 
            // InternalAceGen.g:3778:2: ( rule__HttpServerAceRead__AuthorizeAssignment_7 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==59) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalAceGen.g:3778:3: rule__HttpServerAceRead__AuthorizeAssignment_7
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceRead__AuthorizeAssignment_7();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__7__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__8"
    // InternalAceGen.g:3786:1: rule__HttpServerAceRead__Group__8 : rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9 ;
    public final void rule__HttpServerAceRead__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3790:1: ( rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9 )
            // InternalAceGen.g:3791:2: rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9
            {
            pushFollow(FOLLOW_34);
            rule__HttpServerAceRead__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__8"


    // $ANTLR start "rule__HttpServerAceRead__Group__8__Impl"
    // InternalAceGen.g:3798:1: rule__HttpServerAceRead__Group__8__Impl : ( ( rule__HttpServerAceRead__Group_8__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3802:1: ( ( ( rule__HttpServerAceRead__Group_8__0 )? ) )
            // InternalAceGen.g:3803:1: ( ( rule__HttpServerAceRead__Group_8__0 )? )
            {
            // InternalAceGen.g:3803:1: ( ( rule__HttpServerAceRead__Group_8__0 )? )
            // InternalAceGen.g:3804:2: ( rule__HttpServerAceRead__Group_8__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_8()); 
            // InternalAceGen.g:3805:2: ( rule__HttpServerAceRead__Group_8__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==48) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalAceGen.g:3805:3: rule__HttpServerAceRead__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceRead__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceReadAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__8__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__9"
    // InternalAceGen.g:3813:1: rule__HttpServerAceRead__Group__9 : rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10 ;
    public final void rule__HttpServerAceRead__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3817:1: ( rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10 )
            // InternalAceGen.g:3818:2: rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10
            {
            pushFollow(FOLLOW_34);
            rule__HttpServerAceRead__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__9"


    // $ANTLR start "rule__HttpServerAceRead__Group__9__Impl"
    // InternalAceGen.g:3825:1: rule__HttpServerAceRead__Group__9__Impl : ( ( rule__HttpServerAceRead__Group_9__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3829:1: ( ( ( rule__HttpServerAceRead__Group_9__0 )? ) )
            // InternalAceGen.g:3830:1: ( ( rule__HttpServerAceRead__Group_9__0 )? )
            {
            // InternalAceGen.g:3830:1: ( ( rule__HttpServerAceRead__Group_9__0 )? )
            // InternalAceGen.g:3831:2: ( rule__HttpServerAceRead__Group_9__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_9()); 
            // InternalAceGen.g:3832:2: ( rule__HttpServerAceRead__Group_9__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==49) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalAceGen.g:3832:3: rule__HttpServerAceRead__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceRead__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceReadAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__9__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__10"
    // InternalAceGen.g:3840:1: rule__HttpServerAceRead__Group__10 : rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11 ;
    public final void rule__HttpServerAceRead__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3844:1: ( rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11 )
            // InternalAceGen.g:3845:2: rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11
            {
            pushFollow(FOLLOW_34);
            rule__HttpServerAceRead__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__10"


    // $ANTLR start "rule__HttpServerAceRead__Group__10__Impl"
    // InternalAceGen.g:3852:1: rule__HttpServerAceRead__Group__10__Impl : ( ( rule__HttpServerAceRead__Group_10__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3856:1: ( ( ( rule__HttpServerAceRead__Group_10__0 )? ) )
            // InternalAceGen.g:3857:1: ( ( rule__HttpServerAceRead__Group_10__0 )? )
            {
            // InternalAceGen.g:3857:1: ( ( rule__HttpServerAceRead__Group_10__0 )? )
            // InternalAceGen.g:3858:2: ( rule__HttpServerAceRead__Group_10__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_10()); 
            // InternalAceGen.g:3859:2: ( rule__HttpServerAceRead__Group_10__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==50) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalAceGen.g:3859:3: rule__HttpServerAceRead__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceRead__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceReadAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__10__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group__11"
    // InternalAceGen.g:3867:1: rule__HttpServerAceRead__Group__11 : rule__HttpServerAceRead__Group__11__Impl ;
    public final void rule__HttpServerAceRead__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3871:1: ( rule__HttpServerAceRead__Group__11__Impl )
            // InternalAceGen.g:3872:2: rule__HttpServerAceRead__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__11"


    // $ANTLR start "rule__HttpServerAceRead__Group__11__Impl"
    // InternalAceGen.g:3878:1: rule__HttpServerAceRead__Group__11__Impl : ( ( rule__HttpServerAceRead__Group_11__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3882:1: ( ( ( rule__HttpServerAceRead__Group_11__0 )? ) )
            // InternalAceGen.g:3883:1: ( ( rule__HttpServerAceRead__Group_11__0 )? )
            {
            // InternalAceGen.g:3883:1: ( ( rule__HttpServerAceRead__Group_11__0 )? )
            // InternalAceGen.g:3884:2: ( rule__HttpServerAceRead__Group_11__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_11()); 
            // InternalAceGen.g:3885:2: ( rule__HttpServerAceRead__Group_11__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==51) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalAceGen.g:3885:3: rule__HttpServerAceRead__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerAceRead__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAceReadAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group__11__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group_8__0"
    // InternalAceGen.g:3894:1: rule__HttpServerAceRead__Group_8__0 : rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1 ;
    public final void rule__HttpServerAceRead__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3898:1: ( rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1 )
            // InternalAceGen.g:3899:2: rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerAceRead__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_8__0"


    // $ANTLR start "rule__HttpServerAceRead__Group_8__0__Impl"
    // InternalAceGen.g:3906:1: rule__HttpServerAceRead__Group_8__0__Impl : ( 'pathParams' ) ;
    public final void rule__HttpServerAceRead__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3910:1: ( ( 'pathParams' ) )
            // InternalAceGen.g:3911:1: ( 'pathParams' )
            {
            // InternalAceGen.g:3911:1: ( 'pathParams' )
            // InternalAceGen.g:3912:2: 'pathParams'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_8_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_8__0__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group_8__1"
    // InternalAceGen.g:3921:1: rule__HttpServerAceRead__Group_8__1 : rule__HttpServerAceRead__Group_8__1__Impl ;
    public final void rule__HttpServerAceRead__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3925:1: ( rule__HttpServerAceRead__Group_8__1__Impl )
            // InternalAceGen.g:3926:2: rule__HttpServerAceRead__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_8__1"


    // $ANTLR start "rule__HttpServerAceRead__Group_8__1__Impl"
    // InternalAceGen.g:3932:1: rule__HttpServerAceRead__Group_8__1__Impl : ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3936:1: ( ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* ) )
            // InternalAceGen.g:3937:1: ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* )
            {
            // InternalAceGen.g:3937:1: ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* )
            // InternalAceGen.g:3938:2: ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsAssignment_8_1()); 
            // InternalAceGen.g:3939:2: ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_ID) ) {
                    int LA57_2 = input.LA(2);

                    if ( (LA57_2==EOF||LA57_2==RULE_ID||(LA57_2>=46 && LA57_2<=47)||(LA57_2>=49 && LA57_2<=51)||LA57_2==54||LA57_2==58) ) {
                        alt57=1;
                    }


                }


                switch (alt57) {
            	case 1 :
            	    // InternalAceGen.g:3939:3: rule__HttpServerAceRead__PathParamsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceRead__PathParamsAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

             after(grammarAccess.getHttpServerAceReadAccess().getPathParamsAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_8__1__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group_9__0"
    // InternalAceGen.g:3948:1: rule__HttpServerAceRead__Group_9__0 : rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1 ;
    public final void rule__HttpServerAceRead__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3952:1: ( rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1 )
            // InternalAceGen.g:3953:2: rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerAceRead__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_9__0"


    // $ANTLR start "rule__HttpServerAceRead__Group_9__0__Impl"
    // InternalAceGen.g:3960:1: rule__HttpServerAceRead__Group_9__0__Impl : ( 'queryParams' ) ;
    public final void rule__HttpServerAceRead__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3964:1: ( ( 'queryParams' ) )
            // InternalAceGen.g:3965:1: ( 'queryParams' )
            {
            // InternalAceGen.g:3965:1: ( 'queryParams' )
            // InternalAceGen.g:3966:2: 'queryParams'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_9_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_9__0__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group_9__1"
    // InternalAceGen.g:3975:1: rule__HttpServerAceRead__Group_9__1 : rule__HttpServerAceRead__Group_9__1__Impl ;
    public final void rule__HttpServerAceRead__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3979:1: ( rule__HttpServerAceRead__Group_9__1__Impl )
            // InternalAceGen.g:3980:2: rule__HttpServerAceRead__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_9__1"


    // $ANTLR start "rule__HttpServerAceRead__Group_9__1__Impl"
    // InternalAceGen.g:3986:1: rule__HttpServerAceRead__Group_9__1__Impl : ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3990:1: ( ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* ) )
            // InternalAceGen.g:3991:1: ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* )
            {
            // InternalAceGen.g:3991:1: ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* )
            // InternalAceGen.g:3992:2: ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAssignment_9_1()); 
            // InternalAceGen.g:3993:2: ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ID) ) {
                    int LA58_2 = input.LA(2);

                    if ( (LA58_2==EOF||LA58_2==RULE_ID||(LA58_2>=46 && LA58_2<=47)||(LA58_2>=50 && LA58_2<=51)||LA58_2==54||LA58_2==58) ) {
                        alt58=1;
                    }


                }


                switch (alt58) {
            	case 1 :
            	    // InternalAceGen.g:3993:3: rule__HttpServerAceRead__QueryParamsAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceRead__QueryParamsAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

             after(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_9__1__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group_10__0"
    // InternalAceGen.g:4002:1: rule__HttpServerAceRead__Group_10__0 : rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1 ;
    public final void rule__HttpServerAceRead__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4006:1: ( rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1 )
            // InternalAceGen.g:4007:2: rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerAceRead__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_10__0"


    // $ANTLR start "rule__HttpServerAceRead__Group_10__0__Impl"
    // InternalAceGen.g:4014:1: rule__HttpServerAceRead__Group_10__0__Impl : ( 'payload' ) ;
    public final void rule__HttpServerAceRead__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4018:1: ( ( 'payload' ) )
            // InternalAceGen.g:4019:1: ( 'payload' )
            {
            // InternalAceGen.g:4019:1: ( 'payload' )
            // InternalAceGen.g:4020:2: 'payload'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_10_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_10__0__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group_10__1"
    // InternalAceGen.g:4029:1: rule__HttpServerAceRead__Group_10__1 : rule__HttpServerAceRead__Group_10__1__Impl ;
    public final void rule__HttpServerAceRead__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4033:1: ( rule__HttpServerAceRead__Group_10__1__Impl )
            // InternalAceGen.g:4034:2: rule__HttpServerAceRead__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_10__1"


    // $ANTLR start "rule__HttpServerAceRead__Group_10__1__Impl"
    // InternalAceGen.g:4040:1: rule__HttpServerAceRead__Group_10__1__Impl : ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4044:1: ( ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* ) )
            // InternalAceGen.g:4045:1: ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* )
            {
            // InternalAceGen.g:4045:1: ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* )
            // InternalAceGen.g:4046:2: ( rule__HttpServerAceRead__PayloadAssignment_10_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadAssignment_10_1()); 
            // InternalAceGen.g:4047:2: ( rule__HttpServerAceRead__PayloadAssignment_10_1 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_ID) ) {
                    int LA59_2 = input.LA(2);

                    if ( (LA59_2==EOF||LA59_2==RULE_ID||(LA59_2>=46 && LA59_2<=47)||LA59_2==51||LA59_2==54||LA59_2==58) ) {
                        alt59=1;
                    }


                }


                switch (alt59) {
            	case 1 :
            	    // InternalAceGen.g:4047:3: rule__HttpServerAceRead__PayloadAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceRead__PayloadAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

             after(grammarAccess.getHttpServerAceReadAccess().getPayloadAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_10__1__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group_11__0"
    // InternalAceGen.g:4056:1: rule__HttpServerAceRead__Group_11__0 : rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1 ;
    public final void rule__HttpServerAceRead__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4060:1: ( rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1 )
            // InternalAceGen.g:4061:2: rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerAceRead__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_11__0"


    // $ANTLR start "rule__HttpServerAceRead__Group_11__0__Impl"
    // InternalAceGen.g:4068:1: rule__HttpServerAceRead__Group_11__0__Impl : ( 'response' ) ;
    public final void rule__HttpServerAceRead__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4072:1: ( ( 'response' ) )
            // InternalAceGen.g:4073:1: ( 'response' )
            {
            // InternalAceGen.g:4073:1: ( 'response' )
            // InternalAceGen.g:4074:2: 'response'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_11_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_11__0__Impl"


    // $ANTLR start "rule__HttpServerAceRead__Group_11__1"
    // InternalAceGen.g:4083:1: rule__HttpServerAceRead__Group_11__1 : rule__HttpServerAceRead__Group_11__1__Impl ;
    public final void rule__HttpServerAceRead__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4087:1: ( rule__HttpServerAceRead__Group_11__1__Impl )
            // InternalAceGen.g:4088:2: rule__HttpServerAceRead__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerAceRead__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_11__1"


    // $ANTLR start "rule__HttpServerAceRead__Group_11__1__Impl"
    // InternalAceGen.g:4094:1: rule__HttpServerAceRead__Group_11__1__Impl : ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4098:1: ( ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* ) )
            // InternalAceGen.g:4099:1: ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* )
            {
            // InternalAceGen.g:4099:1: ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* )
            // InternalAceGen.g:4100:2: ( rule__HttpServerAceRead__ResponseAssignment_11_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseAssignment_11_1()); 
            // InternalAceGen.g:4101:2: ( rule__HttpServerAceRead__ResponseAssignment_11_1 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID) ) {
                    int LA60_2 = input.LA(2);

                    if ( (LA60_2==EOF||LA60_2==RULE_ID||(LA60_2>=46 && LA60_2<=47)||LA60_2==54||LA60_2==58) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // InternalAceGen.g:4101:3: rule__HttpServerAceRead__ResponseAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceRead__ResponseAssignment_11_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

             after(grammarAccess.getHttpServerAceReadAccess().getResponseAssignment_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__Group_11__1__Impl"


    // $ANTLR start "rule__HttpServerView__Group__0"
    // InternalAceGen.g:4110:1: rule__HttpServerView__Group__0 : rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1 ;
    public final void rule__HttpServerView__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4114:1: ( rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1 )
            // InternalAceGen.g:4115:2: rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__HttpServerView__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerView__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__Group__0"


    // $ANTLR start "rule__HttpServerView__Group__0__Impl"
    // InternalAceGen.g:4122:1: rule__HttpServerView__Group__0__Impl : ( ( rule__HttpServerView__NameAssignment_0 ) ) ;
    public final void rule__HttpServerView__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4126:1: ( ( ( rule__HttpServerView__NameAssignment_0 ) ) )
            // InternalAceGen.g:4127:1: ( ( rule__HttpServerView__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4127:1: ( ( rule__HttpServerView__NameAssignment_0 ) )
            // InternalAceGen.g:4128:2: ( rule__HttpServerView__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerViewAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4129:2: ( rule__HttpServerView__NameAssignment_0 )
            // InternalAceGen.g:4129:3: rule__HttpServerView__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerView__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerViewAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__Group__0__Impl"


    // $ANTLR start "rule__HttpServerView__Group__1"
    // InternalAceGen.g:4137:1: rule__HttpServerView__Group__1 : rule__HttpServerView__Group__1__Impl ;
    public final void rule__HttpServerView__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4141:1: ( rule__HttpServerView__Group__1__Impl )
            // InternalAceGen.g:4142:2: rule__HttpServerView__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerView__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__Group__1"


    // $ANTLR start "rule__HttpServerView__Group__1__Impl"
    // InternalAceGen.g:4148:1: rule__HttpServerView__Group__1__Impl : ( ( rule__HttpServerView__Group_1__0 )? ) ;
    public final void rule__HttpServerView__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4152:1: ( ( ( rule__HttpServerView__Group_1__0 )? ) )
            // InternalAceGen.g:4153:1: ( ( rule__HttpServerView__Group_1__0 )? )
            {
            // InternalAceGen.g:4153:1: ( ( rule__HttpServerView__Group_1__0 )? )
            // InternalAceGen.g:4154:2: ( rule__HttpServerView__Group_1__0 )?
            {
             before(grammarAccess.getHttpServerViewAccess().getGroup_1()); 
            // InternalAceGen.g:4155:2: ( rule__HttpServerView__Group_1__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==42) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalAceGen.g:4155:3: rule__HttpServerView__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServerView__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerViewAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__Group__1__Impl"


    // $ANTLR start "rule__HttpServerView__Group_1__0"
    // InternalAceGen.g:4164:1: rule__HttpServerView__Group_1__0 : rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1 ;
    public final void rule__HttpServerView__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4168:1: ( rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1 )
            // InternalAceGen.g:4169:2: rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1
            {
            pushFollow(FOLLOW_21);
            rule__HttpServerView__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerView__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__Group_1__0"


    // $ANTLR start "rule__HttpServerView__Group_1__0__Impl"
    // InternalAceGen.g:4176:1: rule__HttpServerView__Group_1__0__Impl : ( '{' ) ;
    public final void rule__HttpServerView__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4180:1: ( ( '{' ) )
            // InternalAceGen.g:4181:1: ( '{' )
            {
            // InternalAceGen.g:4181:1: ( '{' )
            // InternalAceGen.g:4182:2: '{'
            {
             before(grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__Group_1__0__Impl"


    // $ANTLR start "rule__HttpServerView__Group_1__1"
    // InternalAceGen.g:4191:1: rule__HttpServerView__Group_1__1 : rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2 ;
    public final void rule__HttpServerView__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4195:1: ( rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2 )
            // InternalAceGen.g:4196:2: rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2
            {
            pushFollow(FOLLOW_21);
            rule__HttpServerView__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerView__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__Group_1__1"


    // $ANTLR start "rule__HttpServerView__Group_1__1__Impl"
    // InternalAceGen.g:4203:1: rule__HttpServerView__Group_1__1__Impl : ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* ) ;
    public final void rule__HttpServerView__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4207:1: ( ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* ) )
            // InternalAceGen.g:4208:1: ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* )
            {
            // InternalAceGen.g:4208:1: ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* )
            // InternalAceGen.g:4209:2: ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )*
            {
             before(grammarAccess.getHttpServerViewAccess().getRenderFunctionsAssignment_1_1()); 
            // InternalAceGen.g:4210:2: ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalAceGen.g:4210:3: rule__HttpServerView__RenderFunctionsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerView__RenderFunctionsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

             after(grammarAccess.getHttpServerViewAccess().getRenderFunctionsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__Group_1__1__Impl"


    // $ANTLR start "rule__HttpServerView__Group_1__2"
    // InternalAceGen.g:4218:1: rule__HttpServerView__Group_1__2 : rule__HttpServerView__Group_1__2__Impl ;
    public final void rule__HttpServerView__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4222:1: ( rule__HttpServerView__Group_1__2__Impl )
            // InternalAceGen.g:4223:2: rule__HttpServerView__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerView__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__Group_1__2"


    // $ANTLR start "rule__HttpServerView__Group_1__2__Impl"
    // InternalAceGen.g:4229:1: rule__HttpServerView__Group_1__2__Impl : ( '}' ) ;
    public final void rule__HttpServerView__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4233:1: ( ( '}' ) )
            // InternalAceGen.g:4234:1: ( '}' )
            {
            // InternalAceGen.g:4234:1: ( '}' )
            // InternalAceGen.g:4235:2: '}'
            {
             before(grammarAccess.getHttpServerViewAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getHttpServerViewAccess().getRightCurlyBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__Group_1__2__Impl"


    // $ANTLR start "rule__HttpServerViewFunction__Group__0"
    // InternalAceGen.g:4245:1: rule__HttpServerViewFunction__Group__0 : rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1 ;
    public final void rule__HttpServerViewFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4249:1: ( rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1 )
            // InternalAceGen.g:4250:2: rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__HttpServerViewFunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerViewFunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerViewFunction__Group__0"


    // $ANTLR start "rule__HttpServerViewFunction__Group__0__Impl"
    // InternalAceGen.g:4257:1: rule__HttpServerViewFunction__Group__0__Impl : ( ( rule__HttpServerViewFunction__NameAssignment_0 ) ) ;
    public final void rule__HttpServerViewFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4261:1: ( ( ( rule__HttpServerViewFunction__NameAssignment_0 ) ) )
            // InternalAceGen.g:4262:1: ( ( rule__HttpServerViewFunction__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4262:1: ( ( rule__HttpServerViewFunction__NameAssignment_0 ) )
            // InternalAceGen.g:4263:2: ( rule__HttpServerViewFunction__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4264:2: ( rule__HttpServerViewFunction__NameAssignment_0 )
            // InternalAceGen.g:4264:3: rule__HttpServerViewFunction__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerViewFunction__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerViewFunctionAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerViewFunction__Group__0__Impl"


    // $ANTLR start "rule__HttpServerViewFunction__Group__1"
    // InternalAceGen.g:4272:1: rule__HttpServerViewFunction__Group__1 : rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2 ;
    public final void rule__HttpServerViewFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4276:1: ( rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2 )
            // InternalAceGen.g:4277:2: rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__HttpServerViewFunction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerViewFunction__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerViewFunction__Group__1"


    // $ANTLR start "rule__HttpServerViewFunction__Group__1__Impl"
    // InternalAceGen.g:4284:1: rule__HttpServerViewFunction__Group__1__Impl : ( '(' ) ;
    public final void rule__HttpServerViewFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4288:1: ( ( '(' ) )
            // InternalAceGen.g:4289:1: ( '(' )
            {
            // InternalAceGen.g:4289:1: ( '(' )
            // InternalAceGen.g:4290:2: '('
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getLeftParenthesisKeyword_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getHttpServerViewFunctionAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerViewFunction__Group__1__Impl"


    // $ANTLR start "rule__HttpServerViewFunction__Group__2"
    // InternalAceGen.g:4299:1: rule__HttpServerViewFunction__Group__2 : rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3 ;
    public final void rule__HttpServerViewFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4303:1: ( rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3 )
            // InternalAceGen.g:4304:2: rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3
            {
            pushFollow(FOLLOW_35);
            rule__HttpServerViewFunction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServerViewFunction__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerViewFunction__Group__2"


    // $ANTLR start "rule__HttpServerViewFunction__Group__2__Impl"
    // InternalAceGen.g:4311:1: rule__HttpServerViewFunction__Group__2__Impl : ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) ) ;
    public final void rule__HttpServerViewFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4315:1: ( ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) ) )
            // InternalAceGen.g:4316:1: ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) )
            {
            // InternalAceGen.g:4316:1: ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) )
            // InternalAceGen.g:4317:2: ( rule__HttpServerViewFunction__ModelAssignment_2 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getModelAssignment_2()); 
            // InternalAceGen.g:4318:2: ( rule__HttpServerViewFunction__ModelAssignment_2 )
            // InternalAceGen.g:4318:3: rule__HttpServerViewFunction__ModelAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerViewFunction__ModelAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerViewFunctionAccess().getModelAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerViewFunction__Group__2__Impl"


    // $ANTLR start "rule__HttpServerViewFunction__Group__3"
    // InternalAceGen.g:4326:1: rule__HttpServerViewFunction__Group__3 : rule__HttpServerViewFunction__Group__3__Impl ;
    public final void rule__HttpServerViewFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4330:1: ( rule__HttpServerViewFunction__Group__3__Impl )
            // InternalAceGen.g:4331:2: rule__HttpServerViewFunction__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerViewFunction__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerViewFunction__Group__3"


    // $ANTLR start "rule__HttpServerViewFunction__Group__3__Impl"
    // InternalAceGen.g:4337:1: rule__HttpServerViewFunction__Group__3__Impl : ( ')' ) ;
    public final void rule__HttpServerViewFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4341:1: ( ( ')' ) )
            // InternalAceGen.g:4342:1: ( ')' )
            {
            // InternalAceGen.g:4342:1: ( ')' )
            // InternalAceGen.g:4343:2: ')'
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getRightParenthesisKeyword_3()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getHttpServerViewFunctionAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerViewFunction__Group__3__Impl"


    // $ANTLR start "rule__AuthUser__Group__0"
    // InternalAceGen.g:4353:1: rule__AuthUser__Group__0 : rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1 ;
    public final void rule__AuthUser__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4357:1: ( rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1 )
            // InternalAceGen.g:4358:2: rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__AuthUser__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AuthUser__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__Group__0"


    // $ANTLR start "rule__AuthUser__Group__0__Impl"
    // InternalAceGen.g:4365:1: rule__AuthUser__Group__0__Impl : ( ( rule__AuthUser__NameAssignment_0 ) ) ;
    public final void rule__AuthUser__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4369:1: ( ( ( rule__AuthUser__NameAssignment_0 ) ) )
            // InternalAceGen.g:4370:1: ( ( rule__AuthUser__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4370:1: ( ( rule__AuthUser__NameAssignment_0 ) )
            // InternalAceGen.g:4371:2: ( rule__AuthUser__NameAssignment_0 )
            {
             before(grammarAccess.getAuthUserAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4372:2: ( rule__AuthUser__NameAssignment_0 )
            // InternalAceGen.g:4372:3: rule__AuthUser__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AuthUser__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAuthUserAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__Group__0__Impl"


    // $ANTLR start "rule__AuthUser__Group__1"
    // InternalAceGen.g:4380:1: rule__AuthUser__Group__1 : rule__AuthUser__Group__1__Impl ;
    public final void rule__AuthUser__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4384:1: ( rule__AuthUser__Group__1__Impl )
            // InternalAceGen.g:4385:2: rule__AuthUser__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AuthUser__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__Group__1"


    // $ANTLR start "rule__AuthUser__Group__1__Impl"
    // InternalAceGen.g:4391:1: rule__AuthUser__Group__1__Impl : ( ( rule__AuthUser__Group_1__0 ) ) ;
    public final void rule__AuthUser__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4395:1: ( ( ( rule__AuthUser__Group_1__0 ) ) )
            // InternalAceGen.g:4396:1: ( ( rule__AuthUser__Group_1__0 ) )
            {
            // InternalAceGen.g:4396:1: ( ( rule__AuthUser__Group_1__0 ) )
            // InternalAceGen.g:4397:2: ( rule__AuthUser__Group_1__0 )
            {
             before(grammarAccess.getAuthUserAccess().getGroup_1()); 
            // InternalAceGen.g:4398:2: ( rule__AuthUser__Group_1__0 )
            // InternalAceGen.g:4398:3: rule__AuthUser__Group_1__0
            {
            pushFollow(FOLLOW_2);
            rule__AuthUser__Group_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAuthUserAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__Group__1__Impl"


    // $ANTLR start "rule__AuthUser__Group_1__0"
    // InternalAceGen.g:4407:1: rule__AuthUser__Group_1__0 : rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1 ;
    public final void rule__AuthUser__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4411:1: ( rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1 )
            // InternalAceGen.g:4412:2: rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1
            {
            pushFollow(FOLLOW_36);
            rule__AuthUser__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AuthUser__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__Group_1__0"


    // $ANTLR start "rule__AuthUser__Group_1__0__Impl"
    // InternalAceGen.g:4419:1: rule__AuthUser__Group_1__0__Impl : ( '{' ) ;
    public final void rule__AuthUser__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4423:1: ( ( '{' ) )
            // InternalAceGen.g:4424:1: ( '{' )
            {
            // InternalAceGen.g:4424:1: ( '{' )
            // InternalAceGen.g:4425:2: '{'
            {
             before(grammarAccess.getAuthUserAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getAuthUserAccess().getLeftCurlyBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__Group_1__0__Impl"


    // $ANTLR start "rule__AuthUser__Group_1__1"
    // InternalAceGen.g:4434:1: rule__AuthUser__Group_1__1 : rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2 ;
    public final void rule__AuthUser__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4438:1: ( rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2 )
            // InternalAceGen.g:4439:2: rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2
            {
            pushFollow(FOLLOW_36);
            rule__AuthUser__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AuthUser__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__Group_1__1"


    // $ANTLR start "rule__AuthUser__Group_1__1__Impl"
    // InternalAceGen.g:4446:1: rule__AuthUser__Group_1__1__Impl : ( ( rule__AuthUser__AttributesAssignment_1_1 )* ) ;
    public final void rule__AuthUser__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4450:1: ( ( ( rule__AuthUser__AttributesAssignment_1_1 )* ) )
            // InternalAceGen.g:4451:1: ( ( rule__AuthUser__AttributesAssignment_1_1 )* )
            {
            // InternalAceGen.g:4451:1: ( ( rule__AuthUser__AttributesAssignment_1_1 )* )
            // InternalAceGen.g:4452:2: ( rule__AuthUser__AttributesAssignment_1_1 )*
            {
             before(grammarAccess.getAuthUserAccess().getAttributesAssignment_1_1()); 
            // InternalAceGen.g:4453:2: ( rule__AuthUser__AttributesAssignment_1_1 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ID||(LA63_0>=19 && LA63_0<=26)||(LA63_0>=61 && LA63_0<=63)) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalAceGen.g:4453:3: rule__AuthUser__AttributesAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__AuthUser__AttributesAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

             after(grammarAccess.getAuthUserAccess().getAttributesAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__Group_1__1__Impl"


    // $ANTLR start "rule__AuthUser__Group_1__2"
    // InternalAceGen.g:4461:1: rule__AuthUser__Group_1__2 : rule__AuthUser__Group_1__2__Impl ;
    public final void rule__AuthUser__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4465:1: ( rule__AuthUser__Group_1__2__Impl )
            // InternalAceGen.g:4466:2: rule__AuthUser__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AuthUser__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__Group_1__2"


    // $ANTLR start "rule__AuthUser__Group_1__2__Impl"
    // InternalAceGen.g:4472:1: rule__AuthUser__Group_1__2__Impl : ( '}' ) ;
    public final void rule__AuthUser__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4476:1: ( ( '}' ) )
            // InternalAceGen.g:4477:1: ( '}' )
            {
            // InternalAceGen.g:4477:1: ( '}' )
            // InternalAceGen.g:4478:2: '}'
            {
             before(grammarAccess.getAuthUserAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getAuthUserAccess().getRightCurlyBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__Group_1__2__Impl"


    // $ANTLR start "rule__Model__Group__0"
    // InternalAceGen.g:4488:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4492:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalAceGen.g:4493:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalAceGen.g:4500:1: rule__Model__Group__0__Impl : ( ( rule__Model__PersistentAssignment_0 )? ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4504:1: ( ( ( rule__Model__PersistentAssignment_0 )? ) )
            // InternalAceGen.g:4505:1: ( ( rule__Model__PersistentAssignment_0 )? )
            {
            // InternalAceGen.g:4505:1: ( ( rule__Model__PersistentAssignment_0 )? )
            // InternalAceGen.g:4506:2: ( rule__Model__PersistentAssignment_0 )?
            {
             before(grammarAccess.getModelAccess().getPersistentAssignment_0()); 
            // InternalAceGen.g:4507:2: ( rule__Model__PersistentAssignment_0 )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==60) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalAceGen.g:4507:3: rule__Model__PersistentAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__PersistentAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getPersistentAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalAceGen.g:4515:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4519:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalAceGen.g:4520:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_38);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalAceGen.g:4527:1: rule__Model__Group__1__Impl : ( ( rule__Model__NameAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4531:1: ( ( ( rule__Model__NameAssignment_1 ) ) )
            // InternalAceGen.g:4532:1: ( ( rule__Model__NameAssignment_1 ) )
            {
            // InternalAceGen.g:4532:1: ( ( rule__Model__NameAssignment_1 ) )
            // InternalAceGen.g:4533:2: ( rule__Model__NameAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1()); 
            // InternalAceGen.g:4534:2: ( rule__Model__NameAssignment_1 )
            // InternalAceGen.g:4534:3: rule__Model__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // InternalAceGen.g:4542:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4546:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalAceGen.g:4547:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_38);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // InternalAceGen.g:4554:1: rule__Model__Group__2__Impl : ( ( rule__Model__Group_2__0 )? ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4558:1: ( ( ( rule__Model__Group_2__0 )? ) )
            // InternalAceGen.g:4559:1: ( ( rule__Model__Group_2__0 )? )
            {
            // InternalAceGen.g:4559:1: ( ( rule__Model__Group_2__0 )? )
            // InternalAceGen.g:4560:2: ( rule__Model__Group_2__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalAceGen.g:4561:2: ( rule__Model__Group_2__0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==52) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalAceGen.g:4561:3: rule__Model__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // InternalAceGen.g:4569:1: rule__Model__Group__3 : rule__Model__Group__3__Impl ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4573:1: ( rule__Model__Group__3__Impl )
            // InternalAceGen.g:4574:2: rule__Model__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // InternalAceGen.g:4580:1: rule__Model__Group__3__Impl : ( ( rule__Model__Group_3__0 )? ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4584:1: ( ( ( rule__Model__Group_3__0 )? ) )
            // InternalAceGen.g:4585:1: ( ( rule__Model__Group_3__0 )? )
            {
            // InternalAceGen.g:4585:1: ( ( rule__Model__Group_3__0 )? )
            // InternalAceGen.g:4586:2: ( rule__Model__Group_3__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_3()); 
            // InternalAceGen.g:4587:2: ( rule__Model__Group_3__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==42) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalAceGen.g:4587:3: rule__Model__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group_2__0"
    // InternalAceGen.g:4596:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4600:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalAceGen.g:4601:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__0"


    // $ANTLR start "rule__Model__Group_2__0__Impl"
    // InternalAceGen.g:4608:1: rule__Model__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4612:1: ( ( 'extends' ) )
            // InternalAceGen.g:4613:1: ( 'extends' )
            {
            // InternalAceGen.g:4613:1: ( 'extends' )
            // InternalAceGen.g:4614:2: 'extends'
            {
             before(grammarAccess.getModelAccess().getExtendsKeyword_2_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getExtendsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__0__Impl"


    // $ANTLR start "rule__Model__Group_2__1"
    // InternalAceGen.g:4623:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl rule__Model__Group_2__2 ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4627:1: ( rule__Model__Group_2__1__Impl rule__Model__Group_2__2 )
            // InternalAceGen.g:4628:2: rule__Model__Group_2__1__Impl rule__Model__Group_2__2
            {
            pushFollow(FOLLOW_39);
            rule__Model__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__1"


    // $ANTLR start "rule__Model__Group_2__1__Impl"
    // InternalAceGen.g:4635:1: rule__Model__Group_2__1__Impl : ( ( rule__Model__SuperModelsAssignment_2_1 ) ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4639:1: ( ( ( rule__Model__SuperModelsAssignment_2_1 ) ) )
            // InternalAceGen.g:4640:1: ( ( rule__Model__SuperModelsAssignment_2_1 ) )
            {
            // InternalAceGen.g:4640:1: ( ( rule__Model__SuperModelsAssignment_2_1 ) )
            // InternalAceGen.g:4641:2: ( rule__Model__SuperModelsAssignment_2_1 )
            {
             before(grammarAccess.getModelAccess().getSuperModelsAssignment_2_1()); 
            // InternalAceGen.g:4642:2: ( rule__Model__SuperModelsAssignment_2_1 )
            // InternalAceGen.g:4642:3: rule__Model__SuperModelsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__SuperModelsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getSuperModelsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__1__Impl"


    // $ANTLR start "rule__Model__Group_2__2"
    // InternalAceGen.g:4650:1: rule__Model__Group_2__2 : rule__Model__Group_2__2__Impl ;
    public final void rule__Model__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4654:1: ( rule__Model__Group_2__2__Impl )
            // InternalAceGen.g:4655:2: rule__Model__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__2"


    // $ANTLR start "rule__Model__Group_2__2__Impl"
    // InternalAceGen.g:4661:1: rule__Model__Group_2__2__Impl : ( ( rule__Model__Group_2_2__0 )* ) ;
    public final void rule__Model__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4665:1: ( ( ( rule__Model__Group_2_2__0 )* ) )
            // InternalAceGen.g:4666:1: ( ( rule__Model__Group_2_2__0 )* )
            {
            // InternalAceGen.g:4666:1: ( ( rule__Model__Group_2_2__0 )* )
            // InternalAceGen.g:4667:2: ( rule__Model__Group_2_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_2_2()); 
            // InternalAceGen.g:4668:2: ( rule__Model__Group_2_2__0 )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==33) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalAceGen.g:4668:3: rule__Model__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Model__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__2__Impl"


    // $ANTLR start "rule__Model__Group_2_2__0"
    // InternalAceGen.g:4677:1: rule__Model__Group_2_2__0 : rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1 ;
    public final void rule__Model__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4681:1: ( rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1 )
            // InternalAceGen.g:4682:2: rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2_2__0"


    // $ANTLR start "rule__Model__Group_2_2__0__Impl"
    // InternalAceGen.g:4689:1: rule__Model__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Model__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4693:1: ( ( ',' ) )
            // InternalAceGen.g:4694:1: ( ',' )
            {
            // InternalAceGen.g:4694:1: ( ',' )
            // InternalAceGen.g:4695:2: ','
            {
             before(grammarAccess.getModelAccess().getCommaKeyword_2_2_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2_2__0__Impl"


    // $ANTLR start "rule__Model__Group_2_2__1"
    // InternalAceGen.g:4704:1: rule__Model__Group_2_2__1 : rule__Model__Group_2_2__1__Impl ;
    public final void rule__Model__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4708:1: ( rule__Model__Group_2_2__1__Impl )
            // InternalAceGen.g:4709:2: rule__Model__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2_2__1"


    // $ANTLR start "rule__Model__Group_2_2__1__Impl"
    // InternalAceGen.g:4715:1: rule__Model__Group_2_2__1__Impl : ( ( rule__Model__SuperModelsAssignment_2_2_1 ) ) ;
    public final void rule__Model__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4719:1: ( ( ( rule__Model__SuperModelsAssignment_2_2_1 ) ) )
            // InternalAceGen.g:4720:1: ( ( rule__Model__SuperModelsAssignment_2_2_1 ) )
            {
            // InternalAceGen.g:4720:1: ( ( rule__Model__SuperModelsAssignment_2_2_1 ) )
            // InternalAceGen.g:4721:2: ( rule__Model__SuperModelsAssignment_2_2_1 )
            {
             before(grammarAccess.getModelAccess().getSuperModelsAssignment_2_2_1()); 
            // InternalAceGen.g:4722:2: ( rule__Model__SuperModelsAssignment_2_2_1 )
            // InternalAceGen.g:4722:3: rule__Model__SuperModelsAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__SuperModelsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getSuperModelsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2_2__1__Impl"


    // $ANTLR start "rule__Model__Group_3__0"
    // InternalAceGen.g:4731:1: rule__Model__Group_3__0 : rule__Model__Group_3__0__Impl rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4735:1: ( rule__Model__Group_3__0__Impl rule__Model__Group_3__1 )
            // InternalAceGen.g:4736:2: rule__Model__Group_3__0__Impl rule__Model__Group_3__1
            {
            pushFollow(FOLLOW_36);
            rule__Model__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__0"


    // $ANTLR start "rule__Model__Group_3__0__Impl"
    // InternalAceGen.g:4743:1: rule__Model__Group_3__0__Impl : ( '{' ) ;
    public final void rule__Model__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4747:1: ( ( '{' ) )
            // InternalAceGen.g:4748:1: ( '{' )
            {
            // InternalAceGen.g:4748:1: ( '{' )
            // InternalAceGen.g:4749:2: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__0__Impl"


    // $ANTLR start "rule__Model__Group_3__1"
    // InternalAceGen.g:4758:1: rule__Model__Group_3__1 : rule__Model__Group_3__1__Impl rule__Model__Group_3__2 ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4762:1: ( rule__Model__Group_3__1__Impl rule__Model__Group_3__2 )
            // InternalAceGen.g:4763:2: rule__Model__Group_3__1__Impl rule__Model__Group_3__2
            {
            pushFollow(FOLLOW_36);
            rule__Model__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__1"


    // $ANTLR start "rule__Model__Group_3__1__Impl"
    // InternalAceGen.g:4770:1: rule__Model__Group_3__1__Impl : ( ( rule__Model__AttributesAssignment_3_1 )* ) ;
    public final void rule__Model__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4774:1: ( ( ( rule__Model__AttributesAssignment_3_1 )* ) )
            // InternalAceGen.g:4775:1: ( ( rule__Model__AttributesAssignment_3_1 )* )
            {
            // InternalAceGen.g:4775:1: ( ( rule__Model__AttributesAssignment_3_1 )* )
            // InternalAceGen.g:4776:2: ( rule__Model__AttributesAssignment_3_1 )*
            {
             before(grammarAccess.getModelAccess().getAttributesAssignment_3_1()); 
            // InternalAceGen.g:4777:2: ( rule__Model__AttributesAssignment_3_1 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==RULE_ID||(LA68_0>=19 && LA68_0<=26)||(LA68_0>=61 && LA68_0<=63)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalAceGen.g:4777:3: rule__Model__AttributesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__Model__AttributesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAttributesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__1__Impl"


    // $ANTLR start "rule__Model__Group_3__2"
    // InternalAceGen.g:4785:1: rule__Model__Group_3__2 : rule__Model__Group_3__2__Impl ;
    public final void rule__Model__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4789:1: ( rule__Model__Group_3__2__Impl )
            // InternalAceGen.g:4790:2: rule__Model__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__2"


    // $ANTLR start "rule__Model__Group_3__2__Impl"
    // InternalAceGen.g:4796:1: rule__Model__Group_3__2__Impl : ( '}' ) ;
    public final void rule__Model__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4800:1: ( ( '}' ) )
            // InternalAceGen.g:4801:1: ( '}' )
            {
            // InternalAceGen.g:4801:1: ( '}' )
            // InternalAceGen.g:4802:2: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_3_2()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__2__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalAceGen.g:4812:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4816:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalAceGen.g:4817:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_40);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // InternalAceGen.g:4824:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__UniqueAssignment_0 )? ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4828:1: ( ( ( rule__Attribute__UniqueAssignment_0 )? ) )
            // InternalAceGen.g:4829:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            {
            // InternalAceGen.g:4829:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            // InternalAceGen.g:4830:2: ( rule__Attribute__UniqueAssignment_0 )?
            {
             before(grammarAccess.getAttributeAccess().getUniqueAssignment_0()); 
            // InternalAceGen.g:4831:2: ( rule__Attribute__UniqueAssignment_0 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==61) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalAceGen.g:4831:3: rule__Attribute__UniqueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__UniqueAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getUniqueAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalAceGen.g:4839:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4843:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalAceGen.g:4844:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FOLLOW_40);
            rule__Attribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // InternalAceGen.g:4851:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__PrimaryKeyAssignment_1 )? ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4855:1: ( ( ( rule__Attribute__PrimaryKeyAssignment_1 )? ) )
            // InternalAceGen.g:4856:1: ( ( rule__Attribute__PrimaryKeyAssignment_1 )? )
            {
            // InternalAceGen.g:4856:1: ( ( rule__Attribute__PrimaryKeyAssignment_1 )? )
            // InternalAceGen.g:4857:2: ( rule__Attribute__PrimaryKeyAssignment_1 )?
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyAssignment_1()); 
            // InternalAceGen.g:4858:2: ( rule__Attribute__PrimaryKeyAssignment_1 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==62) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalAceGen.g:4858:3: rule__Attribute__PrimaryKeyAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__PrimaryKeyAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getPrimaryKeyAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // InternalAceGen.g:4866:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4870:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // InternalAceGen.g:4871:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
            {
            pushFollow(FOLLOW_40);
            rule__Attribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // InternalAceGen.g:4878:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ConstraintAssignment_2 )? ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4882:1: ( ( ( rule__Attribute__ConstraintAssignment_2 )? ) )
            // InternalAceGen.g:4883:1: ( ( rule__Attribute__ConstraintAssignment_2 )? )
            {
            // InternalAceGen.g:4883:1: ( ( rule__Attribute__ConstraintAssignment_2 )? )
            // InternalAceGen.g:4884:2: ( rule__Attribute__ConstraintAssignment_2 )?
            {
             before(grammarAccess.getAttributeAccess().getConstraintAssignment_2()); 
            // InternalAceGen.g:4885:2: ( rule__Attribute__ConstraintAssignment_2 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=25 && LA71_0<=26)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalAceGen.g:4885:3: rule__Attribute__ConstraintAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__ConstraintAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getConstraintAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__Attribute__Group__3"
    // InternalAceGen.g:4893:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl rule__Attribute__Group__4 ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4897:1: ( rule__Attribute__Group__3__Impl rule__Attribute__Group__4 )
            // InternalAceGen.g:4898:2: rule__Attribute__Group__3__Impl rule__Attribute__Group__4
            {
            pushFollow(FOLLOW_40);
            rule__Attribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__3"


    // $ANTLR start "rule__Attribute__Group__3__Impl"
    // InternalAceGen.g:4905:1: rule__Attribute__Group__3__Impl : ( ( rule__Attribute__ListAssignment_3 )? ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4909:1: ( ( ( rule__Attribute__ListAssignment_3 )? ) )
            // InternalAceGen.g:4910:1: ( ( rule__Attribute__ListAssignment_3 )? )
            {
            // InternalAceGen.g:4910:1: ( ( rule__Attribute__ListAssignment_3 )? )
            // InternalAceGen.g:4911:2: ( rule__Attribute__ListAssignment_3 )?
            {
             before(grammarAccess.getAttributeAccess().getListAssignment_3()); 
            // InternalAceGen.g:4912:2: ( rule__Attribute__ListAssignment_3 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==63) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalAceGen.g:4912:3: rule__Attribute__ListAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__ListAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getListAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__3__Impl"


    // $ANTLR start "rule__Attribute__Group__4"
    // InternalAceGen.g:4920:1: rule__Attribute__Group__4 : rule__Attribute__Group__4__Impl rule__Attribute__Group__5 ;
    public final void rule__Attribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4924:1: ( rule__Attribute__Group__4__Impl rule__Attribute__Group__5 )
            // InternalAceGen.g:4925:2: rule__Attribute__Group__4__Impl rule__Attribute__Group__5
            {
            pushFollow(FOLLOW_4);
            rule__Attribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__4"


    // $ANTLR start "rule__Attribute__Group__4__Impl"
    // InternalAceGen.g:4932:1: rule__Attribute__Group__4__Impl : ( ( rule__Attribute__Alternatives_4 ) ) ;
    public final void rule__Attribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4936:1: ( ( ( rule__Attribute__Alternatives_4 ) ) )
            // InternalAceGen.g:4937:1: ( ( rule__Attribute__Alternatives_4 ) )
            {
            // InternalAceGen.g:4937:1: ( ( rule__Attribute__Alternatives_4 ) )
            // InternalAceGen.g:4938:2: ( rule__Attribute__Alternatives_4 )
            {
             before(grammarAccess.getAttributeAccess().getAlternatives_4()); 
            // InternalAceGen.g:4939:2: ( rule__Attribute__Alternatives_4 )
            // InternalAceGen.g:4939:3: rule__Attribute__Alternatives_4
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__4__Impl"


    // $ANTLR start "rule__Attribute__Group__5"
    // InternalAceGen.g:4947:1: rule__Attribute__Group__5 : rule__Attribute__Group__5__Impl rule__Attribute__Group__6 ;
    public final void rule__Attribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4951:1: ( rule__Attribute__Group__5__Impl rule__Attribute__Group__6 )
            // InternalAceGen.g:4952:2: rule__Attribute__Group__5__Impl rule__Attribute__Group__6
            {
            pushFollow(FOLLOW_41);
            rule__Attribute__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__5"


    // $ANTLR start "rule__Attribute__Group__5__Impl"
    // InternalAceGen.g:4959:1: rule__Attribute__Group__5__Impl : ( ( rule__Attribute__NameAssignment_5 ) ) ;
    public final void rule__Attribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4963:1: ( ( ( rule__Attribute__NameAssignment_5 ) ) )
            // InternalAceGen.g:4964:1: ( ( rule__Attribute__NameAssignment_5 ) )
            {
            // InternalAceGen.g:4964:1: ( ( rule__Attribute__NameAssignment_5 ) )
            // InternalAceGen.g:4965:2: ( rule__Attribute__NameAssignment_5 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_5()); 
            // InternalAceGen.g:4966:2: ( rule__Attribute__NameAssignment_5 )
            // InternalAceGen.g:4966:3: rule__Attribute__NameAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__NameAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__5__Impl"


    // $ANTLR start "rule__Attribute__Group__6"
    // InternalAceGen.g:4974:1: rule__Attribute__Group__6 : rule__Attribute__Group__6__Impl ;
    public final void rule__Attribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4978:1: ( rule__Attribute__Group__6__Impl )
            // InternalAceGen.g:4979:2: rule__Attribute__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__6"


    // $ANTLR start "rule__Attribute__Group__6__Impl"
    // InternalAceGen.g:4985:1: rule__Attribute__Group__6__Impl : ( ( rule__Attribute__Group_6__0 )? ) ;
    public final void rule__Attribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4989:1: ( ( ( rule__Attribute__Group_6__0 )? ) )
            // InternalAceGen.g:4990:1: ( ( rule__Attribute__Group_6__0 )? )
            {
            // InternalAceGen.g:4990:1: ( ( rule__Attribute__Group_6__0 )? )
            // InternalAceGen.g:4991:2: ( rule__Attribute__Group_6__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_6()); 
            // InternalAceGen.g:4992:2: ( rule__Attribute__Group_6__0 )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==53) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalAceGen.g:4992:3: rule__Attribute__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__6__Impl"


    // $ANTLR start "rule__Attribute__Group_6__0"
    // InternalAceGen.g:5001:1: rule__Attribute__Group_6__0 : rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 ;
    public final void rule__Attribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5005:1: ( rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 )
            // InternalAceGen.g:5006:2: rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1
            {
            pushFollow(FOLLOW_4);
            rule__Attribute__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_6__0"


    // $ANTLR start "rule__Attribute__Group_6__0__Impl"
    // InternalAceGen.g:5013:1: rule__Attribute__Group_6__0__Impl : ( 'references' ) ;
    public final void rule__Attribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5017:1: ( ( 'references' ) )
            // InternalAceGen.g:5018:1: ( 'references' )
            {
            // InternalAceGen.g:5018:1: ( 'references' )
            // InternalAceGen.g:5019:2: 'references'
            {
             before(grammarAccess.getAttributeAccess().getReferencesKeyword_6_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getReferencesKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_6__0__Impl"


    // $ANTLR start "rule__Attribute__Group_6__1"
    // InternalAceGen.g:5028:1: rule__Attribute__Group_6__1 : rule__Attribute__Group_6__1__Impl ;
    public final void rule__Attribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5032:1: ( rule__Attribute__Group_6__1__Impl )
            // InternalAceGen.g:5033:2: rule__Attribute__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_6__1"


    // $ANTLR start "rule__Attribute__Group_6__1__Impl"
    // InternalAceGen.g:5039:1: rule__Attribute__Group_6__1__Impl : ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) ) ;
    public final void rule__Attribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5043:1: ( ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) ) )
            // InternalAceGen.g:5044:1: ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) )
            {
            // InternalAceGen.g:5044:1: ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) )
            // InternalAceGen.g:5045:2: ( rule__Attribute__ForeignKeyAssignment_6_1 )
            {
             before(grammarAccess.getAttributeAccess().getForeignKeyAssignment_6_1()); 
            // InternalAceGen.g:5046:2: ( rule__Attribute__ForeignKeyAssignment_6_1 )
            // InternalAceGen.g:5046:3: rule__Attribute__ForeignKeyAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__ForeignKeyAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getForeignKeyAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group_6__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalAceGen.g:5055:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5059:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalAceGen.g:5060:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalAceGen.g:5067:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5071:1: ( ( RULE_ID ) )
            // InternalAceGen.g:5072:1: ( RULE_ID )
            {
            // InternalAceGen.g:5072:1: ( RULE_ID )
            // InternalAceGen.g:5073:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalAceGen.g:5082:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5086:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalAceGen.g:5087:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalAceGen.g:5093:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5097:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalAceGen.g:5098:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalAceGen.g:5098:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalAceGen.g:5099:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalAceGen.g:5100:2: ( rule__QualifiedName__Group_1__0 )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==54) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalAceGen.g:5100:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalAceGen.g:5109:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5113:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalAceGen.g:5114:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalAceGen.g:5121:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5125:1: ( ( '.' ) )
            // InternalAceGen.g:5126:1: ( '.' )
            {
            // InternalAceGen.g:5126:1: ( '.' )
            // InternalAceGen.g:5127:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalAceGen.g:5136:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5140:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalAceGen.g:5141:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalAceGen.g:5147:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5151:1: ( ( RULE_ID ) )
            // InternalAceGen.g:5152:1: ( RULE_ID )
            {
            // InternalAceGen.g:5152:1: ( RULE_ID )
            // InternalAceGen.g:5153:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Project__HttpClientAssignment_0_2"
    // InternalAceGen.g:5163:1: rule__Project__HttpClientAssignment_0_2 : ( ruleHttpClient ) ;
    public final void rule__Project__HttpClientAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5167:1: ( ( ruleHttpClient ) )
            // InternalAceGen.g:5168:2: ( ruleHttpClient )
            {
            // InternalAceGen.g:5168:2: ( ruleHttpClient )
            // InternalAceGen.g:5169:3: ruleHttpClient
            {
             before(grammarAccess.getProjectAccess().getHttpClientHttpClientParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpClient();

            state._fsp--;

             after(grammarAccess.getProjectAccess().getHttpClientHttpClientParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__HttpClientAssignment_0_2"


    // $ANTLR start "rule__Project__HttpServerAssignment_1_1"
    // InternalAceGen.g:5178:1: rule__Project__HttpServerAssignment_1_1 : ( ruleHttpServer ) ;
    public final void rule__Project__HttpServerAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5182:1: ( ( ruleHttpServer ) )
            // InternalAceGen.g:5183:2: ( ruleHttpServer )
            {
            // InternalAceGen.g:5183:2: ( ruleHttpServer )
            // InternalAceGen.g:5184:3: ruleHttpServer
            {
             before(grammarAccess.getProjectAccess().getHttpServerHttpServerParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpServer();

            state._fsp--;

             after(grammarAccess.getProjectAccess().getHttpServerHttpServerParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__HttpServerAssignment_1_1"


    // $ANTLR start "rule__HttpClient__NameAssignment_0"
    // InternalAceGen.g:5193:1: rule__HttpClient__NameAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__HttpClient__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5197:1: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5198:2: ( ruleQualifiedName )
            {
            // InternalAceGen.g:5198:2: ( ruleQualifiedName )
            // InternalAceGen.g:5199:3: ruleQualifiedName
            {
             before(grammarAccess.getHttpClientAccess().getNameQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpClientAccess().getNameQualifiedNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__NameAssignment_0"


    // $ANTLR start "rule__HttpClient__AceOperationsAssignment_1_1"
    // InternalAceGen.g:5208:1: rule__HttpClient__AceOperationsAssignment_1_1 : ( ruleHttpClientAce ) ;
    public final void rule__HttpClient__AceOperationsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5212:1: ( ( ruleHttpClientAce ) )
            // InternalAceGen.g:5213:2: ( ruleHttpClientAce )
            {
            // InternalAceGen.g:5213:2: ( ruleHttpClientAce )
            // InternalAceGen.g:5214:3: ruleHttpClientAce
            {
             before(grammarAccess.getHttpClientAccess().getAceOperationsHttpClientAceParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpClientAce();

            state._fsp--;

             after(grammarAccess.getHttpClientAccess().getAceOperationsHttpClientAceParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__AceOperationsAssignment_1_1"


    // $ANTLR start "rule__HttpClient__AppStateAssignment_2_1"
    // InternalAceGen.g:5223:1: rule__HttpClient__AppStateAssignment_2_1 : ( ruleHttpClientStateElement ) ;
    public final void rule__HttpClient__AppStateAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5227:1: ( ( ruleHttpClientStateElement ) )
            // InternalAceGen.g:5228:2: ( ruleHttpClientStateElement )
            {
            // InternalAceGen.g:5228:2: ( ruleHttpClientStateElement )
            // InternalAceGen.g:5229:3: ruleHttpClientStateElement
            {
             before(grammarAccess.getHttpClientAccess().getAppStateHttpClientStateElementParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpClientStateElement();

            state._fsp--;

             after(grammarAccess.getHttpClientAccess().getAppStateHttpClientStateElementParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClient__AppStateAssignment_2_1"


    // $ANTLR start "rule__HttpClientAce__NameAssignment_0"
    // InternalAceGen.g:5238:1: rule__HttpClientAce__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5242:1: ( ( RULE_ID ) )
            // InternalAceGen.g:5243:2: ( RULE_ID )
            {
            // InternalAceGen.g:5243:2: ( RULE_ID )
            // InternalAceGen.g:5244:3: RULE_ID
            {
             before(grammarAccess.getHttpClientAceAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__NameAssignment_0"


    // $ANTLR start "rule__HttpClientAce__InputAssignment_1_1"
    // InternalAceGen.g:5253:1: rule__HttpClientAce__InputAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__InputAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5257:1: ( ( RULE_ID ) )
            // InternalAceGen.g:5258:2: ( RULE_ID )
            {
            // InternalAceGen.g:5258:2: ( RULE_ID )
            // InternalAceGen.g:5259:3: RULE_ID
            {
             before(grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__InputAssignment_1_1"


    // $ANTLR start "rule__HttpClientAce__InputAssignment_1_2_1"
    // InternalAceGen.g:5268:1: rule__HttpClientAce__InputAssignment_1_2_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__InputAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5272:1: ( ( RULE_ID ) )
            // InternalAceGen.g:5273:2: ( RULE_ID )
            {
            // InternalAceGen.g:5273:2: ( RULE_ID )
            // InternalAceGen.g:5274:3: RULE_ID
            {
             before(grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_1_2_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__InputAssignment_1_2_1"


    // $ANTLR start "rule__HttpClientAce__ServerCallAssignment_2_1"
    // InternalAceGen.g:5283:1: rule__HttpClientAce__ServerCallAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientAce__ServerCallAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5287:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5288:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5288:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5289:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceCrossReference_2_1_0()); 
            // InternalAceGen.g:5290:3: ( ruleQualifiedName )
            // InternalAceGen.g:5291:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceQualifiedNameParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__ServerCallAssignment_2_1"


    // $ANTLR start "rule__HttpClientAce__LoadingFlagAssignment_3_1"
    // InternalAceGen.g:5302:1: rule__HttpClientAce__LoadingFlagAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientAce__LoadingFlagAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5306:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5307:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5307:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5308:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementCrossReference_3_1_0()); 
            // InternalAceGen.g:5309:3: ( ruleQualifiedName )
            // InternalAceGen.g:5310:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__LoadingFlagAssignment_3_1"


    // $ANTLR start "rule__HttpClientAce__OutcomesAssignment_4"
    // InternalAceGen.g:5321:1: rule__HttpClientAce__OutcomesAssignment_4 : ( ruleHttpClientOutcome ) ;
    public final void rule__HttpClientAce__OutcomesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5325:1: ( ( ruleHttpClientOutcome ) )
            // InternalAceGen.g:5326:2: ( ruleHttpClientOutcome )
            {
            // InternalAceGen.g:5326:2: ( ruleHttpClientOutcome )
            // InternalAceGen.g:5327:3: ruleHttpClientOutcome
            {
             before(grammarAccess.getHttpClientAceAccess().getOutcomesHttpClientOutcomeParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpClientOutcome();

            state._fsp--;

             after(grammarAccess.getHttpClientAceAccess().getOutcomesHttpClientOutcomeParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientAce__OutcomesAssignment_4"


    // $ANTLR start "rule__HttpClientOutcome__NameAssignment_1"
    // InternalAceGen.g:5336:1: rule__HttpClientOutcome__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientOutcome__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5340:1: ( ( RULE_ID ) )
            // InternalAceGen.g:5341:2: ( RULE_ID )
            {
            // InternalAceGen.g:5341:2: ( RULE_ID )
            // InternalAceGen.g:5342:3: RULE_ID
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpClientOutcomeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__NameAssignment_1"


    // $ANTLR start "rule__HttpClientOutcome__ListenersAssignment_2_1"
    // InternalAceGen.g:5351:1: rule__HttpClientOutcome__ListenersAssignment_2_1 : ( ruleHttpClientStateFunction ) ;
    public final void rule__HttpClientOutcome__ListenersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5355:1: ( ( ruleHttpClientStateFunction ) )
            // InternalAceGen.g:5356:2: ( ruleHttpClientStateFunction )
            {
            // InternalAceGen.g:5356:2: ( ruleHttpClientStateFunction )
            // InternalAceGen.g:5357:3: ruleHttpClientStateFunction
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getListenersHttpClientStateFunctionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpClientStateFunction();

            state._fsp--;

             after(grammarAccess.getHttpClientOutcomeAccess().getListenersHttpClientStateFunctionParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__ListenersAssignment_2_1"


    // $ANTLR start "rule__HttpClientOutcome__AceOperationsAssignment_3_2"
    // InternalAceGen.g:5366:1: rule__HttpClientOutcome__AceOperationsAssignment_3_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientOutcome__AceOperationsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5370:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5371:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5371:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5372:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsHttpClientAceCrossReference_3_2_0()); 
            // InternalAceGen.g:5373:3: ( ruleQualifiedName )
            // InternalAceGen.g:5374:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsHttpClientAceQualifiedNameParserRuleCall_3_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsHttpClientAceQualifiedNameParserRuleCall_3_2_0_1()); 

            }

             after(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsHttpClientAceCrossReference_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientOutcome__AceOperationsAssignment_3_2"


    // $ANTLR start "rule__HttpClientStateFunction__StateFunctionTypeAssignment_0"
    // InternalAceGen.g:5385:1: rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 : ( ruleHttpClientStateFunctionType ) ;
    public final void rule__HttpClientStateFunction__StateFunctionTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5389:1: ( ( ruleHttpClientStateFunctionType ) )
            // InternalAceGen.g:5390:2: ( ruleHttpClientStateFunctionType )
            {
            // InternalAceGen.g:5390:2: ( ruleHttpClientStateFunctionType )
            // InternalAceGen.g:5391:3: ruleHttpClientStateFunctionType
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeHttpClientStateFunctionTypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpClientStateFunctionType();

            state._fsp--;

             after(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeHttpClientStateFunctionTypeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateFunction__StateFunctionTypeAssignment_0"


    // $ANTLR start "rule__HttpClientStateFunction__AttributeAssignment_1"
    // InternalAceGen.g:5400:1: rule__HttpClientStateFunction__AttributeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientStateFunction__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5404:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5405:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5405:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5406:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getAttributeHttpClientStateElementCrossReference_1_0()); 
            // InternalAceGen.g:5407:3: ( ruleQualifiedName )
            // InternalAceGen.g:5408:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getAttributeHttpClientStateElementQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpClientStateFunctionAccess().getAttributeHttpClientStateElementQualifiedNameParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getHttpClientStateFunctionAccess().getAttributeHttpClientStateElementCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateFunction__AttributeAssignment_1"


    // $ANTLR start "rule__HttpClientStateElement__NameAssignment_0"
    // InternalAceGen.g:5419:1: rule__HttpClientStateElement__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpClientStateElement__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5423:1: ( ( RULE_ID ) )
            // InternalAceGen.g:5424:2: ( RULE_ID )
            {
            // InternalAceGen.g:5424:2: ( RULE_ID )
            // InternalAceGen.g:5425:3: RULE_ID
            {
             before(grammarAccess.getHttpClientStateElementAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpClientStateElementAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__NameAssignment_0"


    // $ANTLR start "rule__HttpClientStateElement__ListAssignment_1"
    // InternalAceGen.g:5434:1: rule__HttpClientStateElement__ListAssignment_1 : ( ( 'list' ) ) ;
    public final void rule__HttpClientStateElement__ListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5438:1: ( ( ( 'list' ) ) )
            // InternalAceGen.g:5439:2: ( ( 'list' ) )
            {
            // InternalAceGen.g:5439:2: ( ( 'list' ) )
            // InternalAceGen.g:5440:3: ( 'list' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 
            // InternalAceGen.g:5441:3: ( 'list' )
            // InternalAceGen.g:5442:4: 'list'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 

            }

             after(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__ListAssignment_1"


    // $ANTLR start "rule__HttpClientStateElement__HashAssignment_2"
    // InternalAceGen.g:5453:1: rule__HttpClientStateElement__HashAssignment_2 : ( ( 'location.hash' ) ) ;
    public final void rule__HttpClientStateElement__HashAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5457:1: ( ( ( 'location.hash' ) ) )
            // InternalAceGen.g:5458:2: ( ( 'location.hash' ) )
            {
            // InternalAceGen.g:5458:2: ( ( 'location.hash' ) )
            // InternalAceGen.g:5459:3: ( 'location.hash' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 
            // InternalAceGen.g:5460:3: ( 'location.hash' )
            // InternalAceGen.g:5461:4: 'location.hash'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 

            }

             after(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__HashAssignment_2"


    // $ANTLR start "rule__HttpClientStateElement__StorageAssignment_3"
    // InternalAceGen.g:5472:1: rule__HttpClientStateElement__StorageAssignment_3 : ( ( 'storage' ) ) ;
    public final void rule__HttpClientStateElement__StorageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5476:1: ( ( ( 'storage' ) ) )
            // InternalAceGen.g:5477:2: ( ( 'storage' ) )
            {
            // InternalAceGen.g:5477:2: ( ( 'storage' ) )
            // InternalAceGen.g:5478:3: ( 'storage' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 
            // InternalAceGen.g:5479:3: ( 'storage' )
            // InternalAceGen.g:5480:4: 'storage'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 

            }

             after(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__StorageAssignment_3"


    // $ANTLR start "rule__HttpClientStateElement__TypesAssignment_4_0"
    // InternalAceGen.g:5491:1: rule__HttpClientStateElement__TypesAssignment_4_0 : ( ruleHttpClientTypeDefinition ) ;
    public final void rule__HttpClientStateElement__TypesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5495:1: ( ( ruleHttpClientTypeDefinition ) )
            // InternalAceGen.g:5496:2: ( ruleHttpClientTypeDefinition )
            {
            // InternalAceGen.g:5496:2: ( ruleHttpClientTypeDefinition )
            // InternalAceGen.g:5497:3: ruleHttpClientTypeDefinition
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesHttpClientTypeDefinitionParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpClientTypeDefinition();

            state._fsp--;

             after(grammarAccess.getHttpClientStateElementAccess().getTypesHttpClientTypeDefinitionParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__TypesAssignment_4_0"


    // $ANTLR start "rule__HttpClientStateElement__TypesAssignment_4_1_1"
    // InternalAceGen.g:5506:1: rule__HttpClientStateElement__TypesAssignment_4_1_1 : ( ruleHttpClientTypeDefinition ) ;
    public final void rule__HttpClientStateElement__TypesAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5510:1: ( ( ruleHttpClientTypeDefinition ) )
            // InternalAceGen.g:5511:2: ( ruleHttpClientTypeDefinition )
            {
            // InternalAceGen.g:5511:2: ( ruleHttpClientTypeDefinition )
            // InternalAceGen.g:5512:3: ruleHttpClientTypeDefinition
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesHttpClientTypeDefinitionParserRuleCall_4_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpClientTypeDefinition();

            state._fsp--;

             after(grammarAccess.getHttpClientStateElementAccess().getTypesHttpClientTypeDefinitionParserRuleCall_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientStateElement__TypesAssignment_4_1_1"


    // $ANTLR start "rule__HttpClientTypeDefinition__NameAssignment_1"
    // InternalAceGen.g:5521:1: rule__HttpClientTypeDefinition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientTypeDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5525:1: ( ( RULE_ID ) )
            // InternalAceGen.g:5526:2: ( RULE_ID )
            {
            // InternalAceGen.g:5526:2: ( RULE_ID )
            // InternalAceGen.g:5527:3: RULE_ID
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpClientTypeDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__NameAssignment_1"


    // $ANTLR start "rule__HttpClientTypeDefinition__ElementsAssignment_3"
    // InternalAceGen.g:5536:1: rule__HttpClientTypeDefinition__ElementsAssignment_3 : ( ruleHttpClientStateElement ) ;
    public final void rule__HttpClientTypeDefinition__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5540:1: ( ( ruleHttpClientStateElement ) )
            // InternalAceGen.g:5541:2: ( ruleHttpClientStateElement )
            {
            // InternalAceGen.g:5541:2: ( ruleHttpClientStateElement )
            // InternalAceGen.g:5542:3: ruleHttpClientStateElement
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getElementsHttpClientStateElementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpClientStateElement();

            state._fsp--;

             after(grammarAccess.getHttpClientTypeDefinitionAccess().getElementsHttpClientStateElementParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpClientTypeDefinition__ElementsAssignment_3"


    // $ANTLR start "rule__HttpServer__NameAssignment_0"
    // InternalAceGen.g:5551:1: rule__HttpServer__NameAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__HttpServer__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5555:1: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5556:2: ( ruleQualifiedName )
            {
            // InternalAceGen.g:5556:2: ( ruleQualifiedName )
            // InternalAceGen.g:5557:3: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAccess().getNameQualifiedNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getNameQualifiedNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__NameAssignment_0"


    // $ANTLR start "rule__HttpServer__AuthUserAssignment_1_1"
    // InternalAceGen.g:5566:1: rule__HttpServer__AuthUserAssignment_1_1 : ( ruleAuthUser ) ;
    public final void rule__HttpServer__AuthUserAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5570:1: ( ( ruleAuthUser ) )
            // InternalAceGen.g:5571:2: ( ruleAuthUser )
            {
            // InternalAceGen.g:5571:2: ( ruleAuthUser )
            // InternalAceGen.g:5572:3: ruleAuthUser
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserAuthUserParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAuthUser();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getAuthUserAuthUserParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__AuthUserAssignment_1_1"


    // $ANTLR start "rule__HttpServer__AuthUserRefAssignment_2_1"
    // InternalAceGen.g:5581:1: rule__HttpServer__AuthUserRefAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServer__AuthUserRefAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5585:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5586:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5586:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5587:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_2_1_0()); 
            // InternalAceGen.g:5588:3: ( ruleQualifiedName )
            // InternalAceGen.g:5589:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserQualifiedNameParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__AuthUserRefAssignment_2_1"


    // $ANTLR start "rule__HttpServer__AceOperationsAssignment_3_1"
    // InternalAceGen.g:5600:1: rule__HttpServer__AceOperationsAssignment_3_1 : ( ruleHttpServerAce ) ;
    public final void rule__HttpServer__AceOperationsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5604:1: ( ( ruleHttpServerAce ) )
            // InternalAceGen.g:5605:2: ( ruleHttpServerAce )
            {
            // InternalAceGen.g:5605:2: ( ruleHttpServerAce )
            // InternalAceGen.g:5606:3: ruleHttpServerAce
            {
             before(grammarAccess.getHttpServerAccess().getAceOperationsHttpServerAceParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpServerAce();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getAceOperationsHttpServerAceParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__AceOperationsAssignment_3_1"


    // $ANTLR start "rule__HttpServer__ViewsAssignment_4_1"
    // InternalAceGen.g:5615:1: rule__HttpServer__ViewsAssignment_4_1 : ( ruleHttpServerView ) ;
    public final void rule__HttpServer__ViewsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5619:1: ( ( ruleHttpServerView ) )
            // InternalAceGen.g:5620:2: ( ruleHttpServerView )
            {
            // InternalAceGen.g:5620:2: ( ruleHttpServerView )
            // InternalAceGen.g:5621:3: ruleHttpServerView
            {
             before(grammarAccess.getHttpServerAccess().getViewsHttpServerViewParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpServerView();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getViewsHttpServerViewParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__ViewsAssignment_4_1"


    // $ANTLR start "rule__HttpServer__ModelsAssignment_5_1"
    // InternalAceGen.g:5630:1: rule__HttpServer__ModelsAssignment_5_1 : ( ruleModel ) ;
    public final void rule__HttpServer__ModelsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5634:1: ( ( ruleModel ) )
            // InternalAceGen.g:5635:2: ( ruleModel )
            {
            // InternalAceGen.g:5635:2: ( ruleModel )
            // InternalAceGen.g:5636:3: ruleModel
            {
             before(grammarAccess.getHttpServerAccess().getModelsModelParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getModelsModelParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__ModelsAssignment_5_1"


    // $ANTLR start "rule__HttpServerAceWrite__ProxyAssignment_0"
    // InternalAceGen.g:5645:1: rule__HttpServerAceWrite__ProxyAssignment_0 : ( ( 'proxy' ) ) ;
    public final void rule__HttpServerAceWrite__ProxyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5649:1: ( ( ( 'proxy' ) ) )
            // InternalAceGen.g:5650:2: ( ( 'proxy' ) )
            {
            // InternalAceGen.g:5650:2: ( ( 'proxy' ) )
            // InternalAceGen.g:5651:3: ( 'proxy' )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 
            // InternalAceGen.g:5652:3: ( 'proxy' )
            // InternalAceGen.g:5653:4: 'proxy'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__ProxyAssignment_0"


    // $ANTLR start "rule__HttpServerAceWrite__NameAssignment_1"
    // InternalAceGen.g:5664:1: rule__HttpServerAceWrite__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerAceWrite__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5668:1: ( ( RULE_ID ) )
            // InternalAceGen.g:5669:2: ( RULE_ID )
            {
            // InternalAceGen.g:5669:2: ( RULE_ID )
            // InternalAceGen.g:5670:3: RULE_ID
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceWriteAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__NameAssignment_1"


    // $ANTLR start "rule__HttpServerAceWrite__ModelAssignment_3"
    // InternalAceGen.g:5679:1: rule__HttpServerAceWrite__ModelAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5683:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5684:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5684:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5685:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_3_0()); 
            // InternalAceGen.g:5686:3: ( ruleQualifiedName )
            // InternalAceGen.g:5687:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getModelModelQualifiedNameParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAceWriteAccess().getModelModelQualifiedNameParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__ModelAssignment_3"


    // $ANTLR start "rule__HttpServerAceWrite__TypeAssignment_5"
    // InternalAceGen.g:5698:1: rule__HttpServerAceWrite__TypeAssignment_5 : ( ruleWriteFunctionType ) ;
    public final void rule__HttpServerAceWrite__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5702:1: ( ( ruleWriteFunctionType ) )
            // InternalAceGen.g:5703:2: ( ruleWriteFunctionType )
            {
            // InternalAceGen.g:5703:2: ( ruleWriteFunctionType )
            // InternalAceGen.g:5704:3: ruleWriteFunctionType
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getTypeWriteFunctionTypeParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleWriteFunctionType();

            state._fsp--;

             after(grammarAccess.getHttpServerAceWriteAccess().getTypeWriteFunctionTypeParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__TypeAssignment_5"


    // $ANTLR start "rule__HttpServerAceWrite__UrlAssignment_6"
    // InternalAceGen.g:5713:1: rule__HttpServerAceWrite__UrlAssignment_6 : ( RULE_STRING ) ;
    public final void rule__HttpServerAceWrite__UrlAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5717:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:5718:2: ( RULE_STRING )
            {
            // InternalAceGen.g:5718:2: ( RULE_STRING )
            // InternalAceGen.g:5719:3: RULE_STRING
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getUrlSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceWriteAccess().getUrlSTRINGTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__UrlAssignment_6"


    // $ANTLR start "rule__HttpServerAceWrite__AuthorizeAssignment_7"
    // InternalAceGen.g:5728:1: rule__HttpServerAceWrite__AuthorizeAssignment_7 : ( ( 'authorize' ) ) ;
    public final void rule__HttpServerAceWrite__AuthorizeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5732:1: ( ( ( 'authorize' ) ) )
            // InternalAceGen.g:5733:2: ( ( 'authorize' ) )
            {
            // InternalAceGen.g:5733:2: ( ( 'authorize' ) )
            // InternalAceGen.g:5734:3: ( 'authorize' )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            // InternalAceGen.g:5735:3: ( 'authorize' )
            // InternalAceGen.g:5736:4: 'authorize'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__AuthorizeAssignment_7"


    // $ANTLR start "rule__HttpServerAceWrite__PathParamsAssignment_8_1"
    // InternalAceGen.g:5747:1: rule__HttpServerAceWrite__PathParamsAssignment_8_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__PathParamsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5751:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5752:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5752:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5753:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeCrossReference_8_1_0()); 
            // InternalAceGen.g:5754:3: ( ruleQualifiedName )
            // InternalAceGen.g:5755:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeQualifiedNameParserRuleCall_8_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeQualifiedNameParserRuleCall_8_1_0_1()); 

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeCrossReference_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__PathParamsAssignment_8_1"


    // $ANTLR start "rule__HttpServerAceWrite__QueryParamsAssignment_9_1"
    // InternalAceGen.g:5766:1: rule__HttpServerAceWrite__QueryParamsAssignment_9_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__QueryParamsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5770:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5771:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5771:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5772:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeCrossReference_9_1_0()); 
            // InternalAceGen.g:5773:3: ( ruleQualifiedName )
            // InternalAceGen.g:5774:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeQualifiedNameParserRuleCall_9_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeQualifiedNameParserRuleCall_9_1_0_1()); 

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeCrossReference_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__QueryParamsAssignment_9_1"


    // $ANTLR start "rule__HttpServerAceWrite__PayloadAssignment_10_1"
    // InternalAceGen.g:5785:1: rule__HttpServerAceWrite__PayloadAssignment_10_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__PayloadAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5789:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5790:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5790:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5791:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeCrossReference_10_1_0()); 
            // InternalAceGen.g:5792:3: ( ruleQualifiedName )
            // InternalAceGen.g:5793:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeQualifiedNameParserRuleCall_10_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeQualifiedNameParserRuleCall_10_1_0_1()); 

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeCrossReference_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__PayloadAssignment_10_1"


    // $ANTLR start "rule__HttpServerAceWrite__ResponseAssignment_11_1"
    // InternalAceGen.g:5804:1: rule__HttpServerAceWrite__ResponseAssignment_11_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__ResponseAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5808:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5809:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5809:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5810:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeCrossReference_11_1_0()); 
            // InternalAceGen.g:5811:3: ( ruleQualifiedName )
            // InternalAceGen.g:5812:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeQualifiedNameParserRuleCall_11_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeQualifiedNameParserRuleCall_11_1_0_1()); 

            }

             after(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeCrossReference_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__ResponseAssignment_11_1"


    // $ANTLR start "rule__HttpServerAceWrite__OutcomesAssignment_12"
    // InternalAceGen.g:5823:1: rule__HttpServerAceWrite__OutcomesAssignment_12 : ( ruleHttpServerOutcome ) ;
    public final void rule__HttpServerAceWrite__OutcomesAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5827:1: ( ( ruleHttpServerOutcome ) )
            // InternalAceGen.g:5828:2: ( ruleHttpServerOutcome )
            {
            // InternalAceGen.g:5828:2: ( ruleHttpServerOutcome )
            // InternalAceGen.g:5829:3: ruleHttpServerOutcome
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getOutcomesHttpServerOutcomeParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpServerOutcome();

            state._fsp--;

             after(grammarAccess.getHttpServerAceWriteAccess().getOutcomesHttpServerOutcomeParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceWrite__OutcomesAssignment_12"


    // $ANTLR start "rule__HttpServerOutcome__NameAssignment_1"
    // InternalAceGen.g:5838:1: rule__HttpServerOutcome__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerOutcome__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5842:1: ( ( RULE_ID ) )
            // InternalAceGen.g:5843:2: ( RULE_ID )
            {
            // InternalAceGen.g:5843:2: ( RULE_ID )
            // InternalAceGen.g:5844:3: RULE_ID
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpServerOutcomeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__NameAssignment_1"


    // $ANTLR start "rule__HttpServerOutcome__ListenersAssignment_2_1"
    // InternalAceGen.g:5853:1: rule__HttpServerOutcome__ListenersAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerOutcome__ListenersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5857:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5858:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5858:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5859:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0()); 
            // InternalAceGen.g:5860:3: ( ruleQualifiedName )
            // InternalAceGen.g:5861:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionQualifiedNameParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__ListenersAssignment_2_1"


    // $ANTLR start "rule__HttpServerOutcome__AceOperationsAssignment_3_2"
    // InternalAceGen.g:5872:1: rule__HttpServerOutcome__AceOperationsAssignment_3_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerOutcome__AceOperationsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5876:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5877:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5877:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5878:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getAceOperationsHttpServerAceWriteCrossReference_3_2_0()); 
            // InternalAceGen.g:5879:3: ( ruleQualifiedName )
            // InternalAceGen.g:5880:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getAceOperationsHttpServerAceWriteQualifiedNameParserRuleCall_3_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerOutcomeAccess().getAceOperationsHttpServerAceWriteQualifiedNameParserRuleCall_3_2_0_1()); 

            }

             after(grammarAccess.getHttpServerOutcomeAccess().getAceOperationsHttpServerAceWriteCrossReference_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerOutcome__AceOperationsAssignment_3_2"


    // $ANTLR start "rule__HttpServerAceRead__ProxyAssignment_0"
    // InternalAceGen.g:5891:1: rule__HttpServerAceRead__ProxyAssignment_0 : ( ( 'proxy' ) ) ;
    public final void rule__HttpServerAceRead__ProxyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5895:1: ( ( ( 'proxy' ) ) )
            // InternalAceGen.g:5896:2: ( ( 'proxy' ) )
            {
            // InternalAceGen.g:5896:2: ( ( 'proxy' ) )
            // InternalAceGen.g:5897:3: ( 'proxy' )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 
            // InternalAceGen.g:5898:3: ( 'proxy' )
            // InternalAceGen.g:5899:4: 'proxy'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 

            }

             after(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__ProxyAssignment_0"


    // $ANTLR start "rule__HttpServerAceRead__NameAssignment_1"
    // InternalAceGen.g:5910:1: rule__HttpServerAceRead__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerAceRead__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5914:1: ( ( RULE_ID ) )
            // InternalAceGen.g:5915:2: ( RULE_ID )
            {
            // InternalAceGen.g:5915:2: ( RULE_ID )
            // InternalAceGen.g:5916:3: RULE_ID
            {
             before(grammarAccess.getHttpServerAceReadAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceReadAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__NameAssignment_1"


    // $ANTLR start "rule__HttpServerAceRead__ModelAssignment_3"
    // InternalAceGen.g:5925:1: rule__HttpServerAceRead__ModelAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5929:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5930:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5930:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5931:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_3_0()); 
            // InternalAceGen.g:5932:3: ( ruleQualifiedName )
            // InternalAceGen.g:5933:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAceReadAccess().getModelModelQualifiedNameParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAceReadAccess().getModelModelQualifiedNameParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__ModelAssignment_3"


    // $ANTLR start "rule__HttpServerAceRead__TypeAssignment_5"
    // InternalAceGen.g:5944:1: rule__HttpServerAceRead__TypeAssignment_5 : ( ruleReadFunctionType ) ;
    public final void rule__HttpServerAceRead__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5948:1: ( ( ruleReadFunctionType ) )
            // InternalAceGen.g:5949:2: ( ruleReadFunctionType )
            {
            // InternalAceGen.g:5949:2: ( ruleReadFunctionType )
            // InternalAceGen.g:5950:3: ruleReadFunctionType
            {
             before(grammarAccess.getHttpServerAceReadAccess().getTypeReadFunctionTypeParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleReadFunctionType();

            state._fsp--;

             after(grammarAccess.getHttpServerAceReadAccess().getTypeReadFunctionTypeParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__TypeAssignment_5"


    // $ANTLR start "rule__HttpServerAceRead__UrlAssignment_6"
    // InternalAceGen.g:5959:1: rule__HttpServerAceRead__UrlAssignment_6 : ( RULE_STRING ) ;
    public final void rule__HttpServerAceRead__UrlAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5963:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:5964:2: ( RULE_STRING )
            {
            // InternalAceGen.g:5964:2: ( RULE_STRING )
            // InternalAceGen.g:5965:3: RULE_STRING
            {
             before(grammarAccess.getHttpServerAceReadAccess().getUrlSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceReadAccess().getUrlSTRINGTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__UrlAssignment_6"


    // $ANTLR start "rule__HttpServerAceRead__AuthorizeAssignment_7"
    // InternalAceGen.g:5974:1: rule__HttpServerAceRead__AuthorizeAssignment_7 : ( ( 'authorize' ) ) ;
    public final void rule__HttpServerAceRead__AuthorizeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5978:1: ( ( ( 'authorize' ) ) )
            // InternalAceGen.g:5979:2: ( ( 'authorize' ) )
            {
            // InternalAceGen.g:5979:2: ( ( 'authorize' ) )
            // InternalAceGen.g:5980:3: ( 'authorize' )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            // InternalAceGen.g:5981:3: ( 'authorize' )
            // InternalAceGen.g:5982:4: 'authorize'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 

            }

             after(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__AuthorizeAssignment_7"


    // $ANTLR start "rule__HttpServerAceRead__PathParamsAssignment_8_1"
    // InternalAceGen.g:5993:1: rule__HttpServerAceRead__PathParamsAssignment_8_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__PathParamsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5997:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:5998:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:5998:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5999:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeCrossReference_8_1_0()); 
            // InternalAceGen.g:6000:3: ( ruleQualifiedName )
            // InternalAceGen.g:6001:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeQualifiedNameParserRuleCall_8_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeQualifiedNameParserRuleCall_8_1_0_1()); 

            }

             after(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeCrossReference_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__PathParamsAssignment_8_1"


    // $ANTLR start "rule__HttpServerAceRead__QueryParamsAssignment_9_1"
    // InternalAceGen.g:6012:1: rule__HttpServerAceRead__QueryParamsAssignment_9_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__QueryParamsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6016:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6017:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6017:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6018:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeCrossReference_9_1_0()); 
            // InternalAceGen.g:6019:3: ( ruleQualifiedName )
            // InternalAceGen.g:6020:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeQualifiedNameParserRuleCall_9_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeQualifiedNameParserRuleCall_9_1_0_1()); 

            }

             after(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeCrossReference_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__QueryParamsAssignment_9_1"


    // $ANTLR start "rule__HttpServerAceRead__PayloadAssignment_10_1"
    // InternalAceGen.g:6031:1: rule__HttpServerAceRead__PayloadAssignment_10_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__PayloadAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6035:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6036:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6036:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6037:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeCrossReference_10_1_0()); 
            // InternalAceGen.g:6038:3: ( ruleQualifiedName )
            // InternalAceGen.g:6039:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeQualifiedNameParserRuleCall_10_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeQualifiedNameParserRuleCall_10_1_0_1()); 

            }

             after(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeCrossReference_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__PayloadAssignment_10_1"


    // $ANTLR start "rule__HttpServerAceRead__ResponseAssignment_11_1"
    // InternalAceGen.g:6050:1: rule__HttpServerAceRead__ResponseAssignment_11_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__ResponseAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6054:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6055:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6055:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6056:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseAttributeCrossReference_11_1_0()); 
            // InternalAceGen.g:6057:3: ( ruleQualifiedName )
            // InternalAceGen.g:6058:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseAttributeQualifiedNameParserRuleCall_11_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAceReadAccess().getResponseAttributeQualifiedNameParserRuleCall_11_1_0_1()); 

            }

             after(grammarAccess.getHttpServerAceReadAccess().getResponseAttributeCrossReference_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerAceRead__ResponseAssignment_11_1"


    // $ANTLR start "rule__HttpServerView__NameAssignment_0"
    // InternalAceGen.g:6069:1: rule__HttpServerView__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpServerView__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6073:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6074:2: ( RULE_ID )
            {
            // InternalAceGen.g:6074:2: ( RULE_ID )
            // InternalAceGen.g:6075:3: RULE_ID
            {
             before(grammarAccess.getHttpServerViewAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpServerViewAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__NameAssignment_0"


    // $ANTLR start "rule__HttpServerView__RenderFunctionsAssignment_1_1"
    // InternalAceGen.g:6084:1: rule__HttpServerView__RenderFunctionsAssignment_1_1 : ( ruleHttpServerViewFunction ) ;
    public final void rule__HttpServerView__RenderFunctionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6088:1: ( ( ruleHttpServerViewFunction ) )
            // InternalAceGen.g:6089:2: ( ruleHttpServerViewFunction )
            {
            // InternalAceGen.g:6089:2: ( ruleHttpServerViewFunction )
            // InternalAceGen.g:6090:3: ruleHttpServerViewFunction
            {
             before(grammarAccess.getHttpServerViewAccess().getRenderFunctionsHttpServerViewFunctionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpServerViewFunction();

            state._fsp--;

             after(grammarAccess.getHttpServerViewAccess().getRenderFunctionsHttpServerViewFunctionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerView__RenderFunctionsAssignment_1_1"


    // $ANTLR start "rule__HttpServerViewFunction__NameAssignment_0"
    // InternalAceGen.g:6099:1: rule__HttpServerViewFunction__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpServerViewFunction__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6103:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6104:2: ( RULE_ID )
            {
            // InternalAceGen.g:6104:2: ( RULE_ID )
            // InternalAceGen.g:6105:3: RULE_ID
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpServerViewFunctionAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerViewFunction__NameAssignment_0"


    // $ANTLR start "rule__HttpServerViewFunction__ModelAssignment_2"
    // InternalAceGen.g:6114:1: rule__HttpServerViewFunction__ModelAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerViewFunction__ModelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6118:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6119:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6119:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6120:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0()); 
            // InternalAceGen.g:6121:3: ( ruleQualifiedName )
            // InternalAceGen.g:6122:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getModelModelQualifiedNameParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerViewFunctionAccess().getModelModelQualifiedNameParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServerViewFunction__ModelAssignment_2"


    // $ANTLR start "rule__AuthUser__NameAssignment_0"
    // InternalAceGen.g:6133:1: rule__AuthUser__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__AuthUser__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6137:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6138:2: ( RULE_ID )
            {
            // InternalAceGen.g:6138:2: ( RULE_ID )
            // InternalAceGen.g:6139:3: RULE_ID
            {
             before(grammarAccess.getAuthUserAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAuthUserAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__NameAssignment_0"


    // $ANTLR start "rule__AuthUser__AttributesAssignment_1_1"
    // InternalAceGen.g:6148:1: rule__AuthUser__AttributesAssignment_1_1 : ( ruleAttribute ) ;
    public final void rule__AuthUser__AttributesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6152:1: ( ( ruleAttribute ) )
            // InternalAceGen.g:6153:2: ( ruleAttribute )
            {
            // InternalAceGen.g:6153:2: ( ruleAttribute )
            // InternalAceGen.g:6154:3: ruleAttribute
            {
             before(grammarAccess.getAuthUserAccess().getAttributesAttributeParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAuthUserAccess().getAttributesAttributeParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AuthUser__AttributesAssignment_1_1"


    // $ANTLR start "rule__Model__PersistentAssignment_0"
    // InternalAceGen.g:6163:1: rule__Model__PersistentAssignment_0 : ( ( 'persistent' ) ) ;
    public final void rule__Model__PersistentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6167:1: ( ( ( 'persistent' ) ) )
            // InternalAceGen.g:6168:2: ( ( 'persistent' ) )
            {
            // InternalAceGen.g:6168:2: ( ( 'persistent' ) )
            // InternalAceGen.g:6169:3: ( 'persistent' )
            {
             before(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 
            // InternalAceGen.g:6170:3: ( 'persistent' )
            // InternalAceGen.g:6171:4: 'persistent'
            {
             before(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 

            }

             after(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__PersistentAssignment_0"


    // $ANTLR start "rule__Model__NameAssignment_1"
    // InternalAceGen.g:6182:1: rule__Model__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6186:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6187:2: ( RULE_ID )
            {
            // InternalAceGen.g:6187:2: ( RULE_ID )
            // InternalAceGen.g:6188:3: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_1"


    // $ANTLR start "rule__Model__SuperModelsAssignment_2_1"
    // InternalAceGen.g:6197:1: rule__Model__SuperModelsAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Model__SuperModelsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6201:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6202:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6202:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6203:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0()); 
            // InternalAceGen.g:6204:3: ( ruleQualifiedName )
            // InternalAceGen.g:6205:4: ruleQualifiedName
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getModelAccess().getSuperModelsModelQualifiedNameParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__SuperModelsAssignment_2_1"


    // $ANTLR start "rule__Model__SuperModelsAssignment_2_2_1"
    // InternalAceGen.g:6216:1: rule__Model__SuperModelsAssignment_2_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Model__SuperModelsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6220:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6221:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6221:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6222:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0()); 
            // InternalAceGen.g:6223:3: ( ruleQualifiedName )
            // InternalAceGen.g:6224:4: ruleQualifiedName
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelQualifiedNameParserRuleCall_2_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getModelAccess().getSuperModelsModelQualifiedNameParserRuleCall_2_2_1_0_1()); 

            }

             after(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__SuperModelsAssignment_2_2_1"


    // $ANTLR start "rule__Model__AttributesAssignment_3_1"
    // InternalAceGen.g:6235:1: rule__Model__AttributesAssignment_3_1 : ( ruleAttribute ) ;
    public final void rule__Model__AttributesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6239:1: ( ( ruleAttribute ) )
            // InternalAceGen.g:6240:2: ( ruleAttribute )
            {
            // InternalAceGen.g:6240:2: ( ruleAttribute )
            // InternalAceGen.g:6241:3: ruleAttribute
            {
             before(grammarAccess.getModelAccess().getAttributesAttributeParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getModelAccess().getAttributesAttributeParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__AttributesAssignment_3_1"


    // $ANTLR start "rule__Attribute__UniqueAssignment_0"
    // InternalAceGen.g:6250:1: rule__Attribute__UniqueAssignment_0 : ( ( 'Unique' ) ) ;
    public final void rule__Attribute__UniqueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6254:1: ( ( ( 'Unique' ) ) )
            // InternalAceGen.g:6255:2: ( ( 'Unique' ) )
            {
            // InternalAceGen.g:6255:2: ( ( 'Unique' ) )
            // InternalAceGen.g:6256:3: ( 'Unique' )
            {
             before(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 
            // InternalAceGen.g:6257:3: ( 'Unique' )
            // InternalAceGen.g:6258:4: 'Unique'
            {
             before(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 

            }

             after(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__UniqueAssignment_0"


    // $ANTLR start "rule__Attribute__PrimaryKeyAssignment_1"
    // InternalAceGen.g:6269:1: rule__Attribute__PrimaryKeyAssignment_1 : ( ( 'PrimaryKey' ) ) ;
    public final void rule__Attribute__PrimaryKeyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6273:1: ( ( ( 'PrimaryKey' ) ) )
            // InternalAceGen.g:6274:2: ( ( 'PrimaryKey' ) )
            {
            // InternalAceGen.g:6274:2: ( ( 'PrimaryKey' ) )
            // InternalAceGen.g:6275:3: ( 'PrimaryKey' )
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 
            // InternalAceGen.g:6276:3: ( 'PrimaryKey' )
            // InternalAceGen.g:6277:4: 'PrimaryKey'
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 

            }

             after(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__PrimaryKeyAssignment_1"


    // $ANTLR start "rule__Attribute__ConstraintAssignment_2"
    // InternalAceGen.g:6288:1: rule__Attribute__ConstraintAssignment_2 : ( ruleConstraint ) ;
    public final void rule__Attribute__ConstraintAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6292:1: ( ( ruleConstraint ) )
            // InternalAceGen.g:6293:2: ( ruleConstraint )
            {
            // InternalAceGen.g:6293:2: ( ruleConstraint )
            // InternalAceGen.g:6294:3: ruleConstraint
            {
             before(grammarAccess.getAttributeAccess().getConstraintConstraintParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getConstraintConstraintParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__ConstraintAssignment_2"


    // $ANTLR start "rule__Attribute__ListAssignment_3"
    // InternalAceGen.g:6303:1: rule__Attribute__ListAssignment_3 : ( ( 'List' ) ) ;
    public final void rule__Attribute__ListAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6307:1: ( ( ( 'List' ) ) )
            // InternalAceGen.g:6308:2: ( ( 'List' ) )
            {
            // InternalAceGen.g:6308:2: ( ( 'List' ) )
            // InternalAceGen.g:6309:3: ( 'List' )
            {
             before(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 
            // InternalAceGen.g:6310:3: ( 'List' )
            // InternalAceGen.g:6311:4: 'List'
            {
             before(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 

            }

             after(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__ListAssignment_3"


    // $ANTLR start "rule__Attribute__TypeAssignment_4_0"
    // InternalAceGen.g:6322:1: rule__Attribute__TypeAssignment_4_0 : ( ruleType ) ;
    public final void rule__Attribute__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6326:1: ( ( ruleType ) )
            // InternalAceGen.g:6327:2: ( ruleType )
            {
            // InternalAceGen.g:6327:2: ( ruleType )
            // InternalAceGen.g:6328:3: ruleType
            {
             before(grammarAccess.getAttributeAccess().getTypeTypeParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getTypeTypeParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__TypeAssignment_4_0"


    // $ANTLR start "rule__Attribute__ModelAssignment_4_1"
    // InternalAceGen.g:6337:1: rule__Attribute__ModelAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Attribute__ModelAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6341:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6342:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6342:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6343:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeAccess().getModelModelCrossReference_4_1_0()); 
            // InternalAceGen.g:6344:3: ( ruleQualifiedName )
            // InternalAceGen.g:6345:4: ruleQualifiedName
            {
             before(grammarAccess.getAttributeAccess().getModelModelQualifiedNameParserRuleCall_4_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getModelModelQualifiedNameParserRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getModelModelCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__ModelAssignment_4_1"


    // $ANTLR start "rule__Attribute__NameAssignment_5"
    // InternalAceGen.g:6356:1: rule__Attribute__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6360:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6361:2: ( RULE_ID )
            {
            // InternalAceGen.g:6361:2: ( RULE_ID )
            // InternalAceGen.g:6362:3: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__NameAssignment_5"


    // $ANTLR start "rule__Attribute__ForeignKeyAssignment_6_1"
    // InternalAceGen.g:6371:1: rule__Attribute__ForeignKeyAssignment_6_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Attribute__ForeignKeyAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6375:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6376:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6376:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6377:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0()); 
            // InternalAceGen.g:6378:3: ( ruleQualifiedName )
            // InternalAceGen.g:6379:4: ruleQualifiedName
            {
             before(grammarAccess.getAttributeAccess().getForeignKeyAttributeQualifiedNameParserRuleCall_6_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getForeignKeyAttributeQualifiedNameParserRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__ForeignKeyAssignment_6_1"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\2\4\1\37\1\4\1\40\1\4\1\13\1\40\2\uffff";
    static final String dfa_3s = "\1\72\1\4\1\37\1\4\1\66\1\4\1\22\1\66\2\uffff";
    static final String dfa_4s = "\10\uffff\1\2\1\1";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\65\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\25\uffff\1\5",
            "\1\7",
            "\1\10\4\uffff\3\11",
            "\1\6\25\uffff\1\5",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "681:1: rule__HttpServerAce__Alternatives : ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000001C80000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000A000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000000400000F000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000000F002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0380020000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000F00020000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0400000000000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0400000000000012L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x1000000000000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x1000000000000012L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x080F001000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x080F000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0xE000080007F80010L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0xE000000007F80012L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0010040000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0xE000000007F80010L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0040000000000002L});

}