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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'GET'", "'null'", "'set'", "'merge'", "'reset'", "'init'", "'POST'", "'PUT'", "'DELETE'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'Long'", "'true'", "'false'", "'HttpClient'", "'HttpServer'", "'ACE'", "'appState'", "'<'", "'>'", "','", "'call'", "'loadingFlag'", "'on'", "'('", "')'", "'triggers'", "'|'", "':'", "'{'", "'}'", "'Authorization'", "'import'", "'views'", "'models'", "'scenarios'", "'pathParams'", "'queryParams'", "'payload'", "'response'", "'extends'", "'WHEN'", "'THEN'", "'GIVEN'", "'x'", "'uuid'", "'systemTime'", "'authorization'", "'references'", "'.'", "'['", "']'", "'async'", "'list'", "'location.hash'", "'storage'", "'Dropwizard'", "'proxy'", "'authorize'", "'optional'", "'persistent'", "'excludeGIVEN'", "'Unique'", "'PrimaryKey'", "'NotNull'", "'List'", "'notReplayable'"
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
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
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
    // InternalAceGen.g:62:1: ruleProject : ( ( rule__Project__Group__0 ) ) ;
    public final void ruleProject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:66:2: ( ( ( rule__Project__Group__0 ) ) )
            // InternalAceGen.g:67:2: ( ( rule__Project__Group__0 ) )
            {
            // InternalAceGen.g:67:2: ( ( rule__Project__Group__0 ) )
            // InternalAceGen.g:68:3: ( rule__Project__Group__0 )
            {
             before(grammarAccess.getProjectAccess().getGroup()); 
            // InternalAceGen.g:69:3: ( rule__Project__Group__0 )
            // InternalAceGen.g:69:4: rule__Project__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProjectAccess().getGroup()); 

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


    // $ANTLR start "entryRuleAttributeParamRef"
    // InternalAceGen.g:378:1: entryRuleAttributeParamRef : ruleAttributeParamRef EOF ;
    public final void entryRuleAttributeParamRef() throws RecognitionException {
        try {
            // InternalAceGen.g:379:1: ( ruleAttributeParamRef EOF )
            // InternalAceGen.g:380:1: ruleAttributeParamRef EOF
            {
             before(grammarAccess.getAttributeParamRefRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeParamRef();

            state._fsp--;

             after(grammarAccess.getAttributeParamRefRule()); 
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
    // $ANTLR end "entryRuleAttributeParamRef"


    // $ANTLR start "ruleAttributeParamRef"
    // InternalAceGen.g:387:1: ruleAttributeParamRef : ( ( rule__AttributeParamRef__Group__0 ) ) ;
    public final void ruleAttributeParamRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:391:2: ( ( ( rule__AttributeParamRef__Group__0 ) ) )
            // InternalAceGen.g:392:2: ( ( rule__AttributeParamRef__Group__0 ) )
            {
            // InternalAceGen.g:392:2: ( ( rule__AttributeParamRef__Group__0 ) )
            // InternalAceGen.g:393:3: ( rule__AttributeParamRef__Group__0 )
            {
             before(grammarAccess.getAttributeParamRefAccess().getGroup()); 
            // InternalAceGen.g:394:3: ( rule__AttributeParamRef__Group__0 )
            // InternalAceGen.g:394:4: rule__AttributeParamRef__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeParamRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeParamRefAccess().getGroup()); 

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
    // $ANTLR end "ruleAttributeParamRef"


    // $ANTLR start "entryRuleHttpServerView"
    // InternalAceGen.g:403:1: entryRuleHttpServerView : ruleHttpServerView EOF ;
    public final void entryRuleHttpServerView() throws RecognitionException {
        try {
            // InternalAceGen.g:404:1: ( ruleHttpServerView EOF )
            // InternalAceGen.g:405:1: ruleHttpServerView EOF
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
    // InternalAceGen.g:412:1: ruleHttpServerView : ( ( rule__HttpServerView__Group__0 ) ) ;
    public final void ruleHttpServerView() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:416:2: ( ( ( rule__HttpServerView__Group__0 ) ) )
            // InternalAceGen.g:417:2: ( ( rule__HttpServerView__Group__0 ) )
            {
            // InternalAceGen.g:417:2: ( ( rule__HttpServerView__Group__0 ) )
            // InternalAceGen.g:418:3: ( rule__HttpServerView__Group__0 )
            {
             before(grammarAccess.getHttpServerViewAccess().getGroup()); 
            // InternalAceGen.g:419:3: ( rule__HttpServerView__Group__0 )
            // InternalAceGen.g:419:4: rule__HttpServerView__Group__0
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
    // InternalAceGen.g:428:1: entryRuleHttpServerViewFunction : ruleHttpServerViewFunction EOF ;
    public final void entryRuleHttpServerViewFunction() throws RecognitionException {
        try {
            // InternalAceGen.g:429:1: ( ruleHttpServerViewFunction EOF )
            // InternalAceGen.g:430:1: ruleHttpServerViewFunction EOF
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
    // InternalAceGen.g:437:1: ruleHttpServerViewFunction : ( ( rule__HttpServerViewFunction__Group__0 ) ) ;
    public final void ruleHttpServerViewFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:441:2: ( ( ( rule__HttpServerViewFunction__Group__0 ) ) )
            // InternalAceGen.g:442:2: ( ( rule__HttpServerViewFunction__Group__0 ) )
            {
            // InternalAceGen.g:442:2: ( ( rule__HttpServerViewFunction__Group__0 ) )
            // InternalAceGen.g:443:3: ( rule__HttpServerViewFunction__Group__0 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getGroup()); 
            // InternalAceGen.g:444:3: ( rule__HttpServerViewFunction__Group__0 )
            // InternalAceGen.g:444:4: rule__HttpServerViewFunction__Group__0
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
    // InternalAceGen.g:453:1: entryRuleAuthUser : ruleAuthUser EOF ;
    public final void entryRuleAuthUser() throws RecognitionException {
        try {
            // InternalAceGen.g:454:1: ( ruleAuthUser EOF )
            // InternalAceGen.g:455:1: ruleAuthUser EOF
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
    // InternalAceGen.g:462:1: ruleAuthUser : ( ( rule__AuthUser__Group__0 ) ) ;
    public final void ruleAuthUser() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:466:2: ( ( ( rule__AuthUser__Group__0 ) ) )
            // InternalAceGen.g:467:2: ( ( rule__AuthUser__Group__0 ) )
            {
            // InternalAceGen.g:467:2: ( ( rule__AuthUser__Group__0 ) )
            // InternalAceGen.g:468:3: ( rule__AuthUser__Group__0 )
            {
             before(grammarAccess.getAuthUserAccess().getGroup()); 
            // InternalAceGen.g:469:3: ( rule__AuthUser__Group__0 )
            // InternalAceGen.g:469:4: rule__AuthUser__Group__0
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
    // InternalAceGen.g:478:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalAceGen.g:479:1: ( ruleModel EOF )
            // InternalAceGen.g:480:1: ruleModel EOF
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
    // InternalAceGen.g:487:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:491:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalAceGen.g:492:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalAceGen.g:492:2: ( ( rule__Model__Group__0 ) )
            // InternalAceGen.g:493:3: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalAceGen.g:494:3: ( rule__Model__Group__0 )
            // InternalAceGen.g:494:4: rule__Model__Group__0
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


    // $ANTLR start "entryRuleScenario"
    // InternalAceGen.g:503:1: entryRuleScenario : ruleScenario EOF ;
    public final void entryRuleScenario() throws RecognitionException {
        try {
            // InternalAceGen.g:504:1: ( ruleScenario EOF )
            // InternalAceGen.g:505:1: ruleScenario EOF
            {
             before(grammarAccess.getScenarioRule()); 
            pushFollow(FOLLOW_1);
            ruleScenario();

            state._fsp--;

             after(grammarAccess.getScenarioRule()); 
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
    // $ANTLR end "entryRuleScenario"


    // $ANTLR start "ruleScenario"
    // InternalAceGen.g:512:1: ruleScenario : ( ( rule__Scenario__Group__0 ) ) ;
    public final void ruleScenario() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:516:2: ( ( ( rule__Scenario__Group__0 ) ) )
            // InternalAceGen.g:517:2: ( ( rule__Scenario__Group__0 ) )
            {
            // InternalAceGen.g:517:2: ( ( rule__Scenario__Group__0 ) )
            // InternalAceGen.g:518:3: ( rule__Scenario__Group__0 )
            {
             before(grammarAccess.getScenarioAccess().getGroup()); 
            // InternalAceGen.g:519:3: ( rule__Scenario__Group__0 )
            // InternalAceGen.g:519:4: rule__Scenario__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Scenario__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getScenarioAccess().getGroup()); 

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
    // $ANTLR end "ruleScenario"


    // $ANTLR start "entryRuleGivenRef"
    // InternalAceGen.g:528:1: entryRuleGivenRef : ruleGivenRef EOF ;
    public final void entryRuleGivenRef() throws RecognitionException {
        try {
            // InternalAceGen.g:529:1: ( ruleGivenRef EOF )
            // InternalAceGen.g:530:1: ruleGivenRef EOF
            {
             before(grammarAccess.getGivenRefRule()); 
            pushFollow(FOLLOW_1);
            ruleGivenRef();

            state._fsp--;

             after(grammarAccess.getGivenRefRule()); 
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
    // $ANTLR end "entryRuleGivenRef"


    // $ANTLR start "ruleGivenRef"
    // InternalAceGen.g:537:1: ruleGivenRef : ( ( rule__GivenRef__Group__0 ) ) ;
    public final void ruleGivenRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:541:2: ( ( ( rule__GivenRef__Group__0 ) ) )
            // InternalAceGen.g:542:2: ( ( rule__GivenRef__Group__0 ) )
            {
            // InternalAceGen.g:542:2: ( ( rule__GivenRef__Group__0 ) )
            // InternalAceGen.g:543:3: ( rule__GivenRef__Group__0 )
            {
             before(grammarAccess.getGivenRefAccess().getGroup()); 
            // InternalAceGen.g:544:3: ( rule__GivenRef__Group__0 )
            // InternalAceGen.g:544:4: rule__GivenRef__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GivenRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGivenRefAccess().getGroup()); 

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
    // $ANTLR end "ruleGivenRef"


    // $ANTLR start "entryRuleWhenBlock"
    // InternalAceGen.g:553:1: entryRuleWhenBlock : ruleWhenBlock EOF ;
    public final void entryRuleWhenBlock() throws RecognitionException {
        try {
            // InternalAceGen.g:554:1: ( ruleWhenBlock EOF )
            // InternalAceGen.g:555:1: ruleWhenBlock EOF
            {
             before(grammarAccess.getWhenBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleWhenBlock();

            state._fsp--;

             after(grammarAccess.getWhenBlockRule()); 
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
    // $ANTLR end "entryRuleWhenBlock"


    // $ANTLR start "ruleWhenBlock"
    // InternalAceGen.g:562:1: ruleWhenBlock : ( ( rule__WhenBlock__Group__0 ) ) ;
    public final void ruleWhenBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:566:2: ( ( ( rule__WhenBlock__Group__0 ) ) )
            // InternalAceGen.g:567:2: ( ( rule__WhenBlock__Group__0 ) )
            {
            // InternalAceGen.g:567:2: ( ( rule__WhenBlock__Group__0 ) )
            // InternalAceGen.g:568:3: ( rule__WhenBlock__Group__0 )
            {
             before(grammarAccess.getWhenBlockAccess().getGroup()); 
            // InternalAceGen.g:569:3: ( rule__WhenBlock__Group__0 )
            // InternalAceGen.g:569:4: rule__WhenBlock__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WhenBlock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWhenBlockAccess().getGroup()); 

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
    // $ANTLR end "ruleWhenBlock"


    // $ANTLR start "entryRuleThenBlock"
    // InternalAceGen.g:578:1: entryRuleThenBlock : ruleThenBlock EOF ;
    public final void entryRuleThenBlock() throws RecognitionException {
        try {
            // InternalAceGen.g:579:1: ( ruleThenBlock EOF )
            // InternalAceGen.g:580:1: ruleThenBlock EOF
            {
             before(grammarAccess.getThenBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleThenBlock();

            state._fsp--;

             after(grammarAccess.getThenBlockRule()); 
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
    // $ANTLR end "entryRuleThenBlock"


    // $ANTLR start "ruleThenBlock"
    // InternalAceGen.g:587:1: ruleThenBlock : ( ( rule__ThenBlock__Group__0 ) ) ;
    public final void ruleThenBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:591:2: ( ( ( rule__ThenBlock__Group__0 ) ) )
            // InternalAceGen.g:592:2: ( ( rule__ThenBlock__Group__0 ) )
            {
            // InternalAceGen.g:592:2: ( ( rule__ThenBlock__Group__0 ) )
            // InternalAceGen.g:593:3: ( rule__ThenBlock__Group__0 )
            {
             before(grammarAccess.getThenBlockAccess().getGroup()); 
            // InternalAceGen.g:594:3: ( rule__ThenBlock__Group__0 )
            // InternalAceGen.g:594:4: rule__ThenBlock__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ThenBlock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getThenBlockAccess().getGroup()); 

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
    // $ANTLR end "ruleThenBlock"


    // $ANTLR start "entryRuleDataDefinition"
    // InternalAceGen.g:603:1: entryRuleDataDefinition : ruleDataDefinition EOF ;
    public final void entryRuleDataDefinition() throws RecognitionException {
        try {
            // InternalAceGen.g:604:1: ( ruleDataDefinition EOF )
            // InternalAceGen.g:605:1: ruleDataDefinition EOF
            {
             before(grammarAccess.getDataDefinitionRule()); 
            pushFollow(FOLLOW_1);
            ruleDataDefinition();

            state._fsp--;

             after(grammarAccess.getDataDefinitionRule()); 
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
    // $ANTLR end "entryRuleDataDefinition"


    // $ANTLR start "ruleDataDefinition"
    // InternalAceGen.g:612:1: ruleDataDefinition : ( ( rule__DataDefinition__Group__0 ) ) ;
    public final void ruleDataDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:616:2: ( ( ( rule__DataDefinition__Group__0 ) ) )
            // InternalAceGen.g:617:2: ( ( rule__DataDefinition__Group__0 ) )
            {
            // InternalAceGen.g:617:2: ( ( rule__DataDefinition__Group__0 ) )
            // InternalAceGen.g:618:3: ( rule__DataDefinition__Group__0 )
            {
             before(grammarAccess.getDataDefinitionAccess().getGroup()); 
            // InternalAceGen.g:619:3: ( rule__DataDefinition__Group__0 )
            // InternalAceGen.g:619:4: rule__DataDefinition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DataDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataDefinitionAccess().getGroup()); 

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
    // $ANTLR end "ruleDataDefinition"


    // $ANTLR start "entryRuleAuthorization"
    // InternalAceGen.g:628:1: entryRuleAuthorization : ruleAuthorization EOF ;
    public final void entryRuleAuthorization() throws RecognitionException {
        try {
            // InternalAceGen.g:629:1: ( ruleAuthorization EOF )
            // InternalAceGen.g:630:1: ruleAuthorization EOF
            {
             before(grammarAccess.getAuthorizationRule()); 
            pushFollow(FOLLOW_1);
            ruleAuthorization();

            state._fsp--;

             after(grammarAccess.getAuthorizationRule()); 
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
    // $ANTLR end "entryRuleAuthorization"


    // $ANTLR start "ruleAuthorization"
    // InternalAceGen.g:637:1: ruleAuthorization : ( ( rule__Authorization__Group__0 ) ) ;
    public final void ruleAuthorization() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:641:2: ( ( ( rule__Authorization__Group__0 ) ) )
            // InternalAceGen.g:642:2: ( ( rule__Authorization__Group__0 ) )
            {
            // InternalAceGen.g:642:2: ( ( rule__Authorization__Group__0 ) )
            // InternalAceGen.g:643:3: ( rule__Authorization__Group__0 )
            {
             before(grammarAccess.getAuthorizationAccess().getGroup()); 
            // InternalAceGen.g:644:3: ( rule__Authorization__Group__0 )
            // InternalAceGen.g:644:4: rule__Authorization__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Authorization__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAuthorizationAccess().getGroup()); 

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
    // $ANTLR end "ruleAuthorization"


    // $ANTLR start "entryRuleAttribute"
    // InternalAceGen.g:653:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalAceGen.g:654:1: ( ruleAttribute EOF )
            // InternalAceGen.g:655:1: ruleAttribute EOF
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
    // InternalAceGen.g:662:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:666:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalAceGen.g:667:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalAceGen.g:667:2: ( ( rule__Attribute__Group__0 ) )
            // InternalAceGen.g:668:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalAceGen.g:669:3: ( rule__Attribute__Group__0 )
            // InternalAceGen.g:669:4: rule__Attribute__Group__0
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
    // InternalAceGen.g:678:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalAceGen.g:679:1: ( ruleQualifiedName EOF )
            // InternalAceGen.g:680:1: ruleQualifiedName EOF
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
    // InternalAceGen.g:687:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:691:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalAceGen.g:692:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalAceGen.g:692:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalAceGen.g:693:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalAceGen.g:694:3: ( rule__QualifiedName__Group__0 )
            // InternalAceGen.g:694:4: rule__QualifiedName__Group__0
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
    // InternalAceGen.g:703:1: entryRuleWriteFunctionType : ruleWriteFunctionType EOF ;
    public final void entryRuleWriteFunctionType() throws RecognitionException {
        try {
            // InternalAceGen.g:704:1: ( ruleWriteFunctionType EOF )
            // InternalAceGen.g:705:1: ruleWriteFunctionType EOF
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
    // InternalAceGen.g:712:1: ruleWriteFunctionType : ( ( rule__WriteFunctionType__Alternatives ) ) ;
    public final void ruleWriteFunctionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:716:2: ( ( ( rule__WriteFunctionType__Alternatives ) ) )
            // InternalAceGen.g:717:2: ( ( rule__WriteFunctionType__Alternatives ) )
            {
            // InternalAceGen.g:717:2: ( ( rule__WriteFunctionType__Alternatives ) )
            // InternalAceGen.g:718:3: ( rule__WriteFunctionType__Alternatives )
            {
             before(grammarAccess.getWriteFunctionTypeAccess().getAlternatives()); 
            // InternalAceGen.g:719:3: ( rule__WriteFunctionType__Alternatives )
            // InternalAceGen.g:719:4: rule__WriteFunctionType__Alternatives
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
    // InternalAceGen.g:728:1: entryRuleReadFunctionType : ruleReadFunctionType EOF ;
    public final void entryRuleReadFunctionType() throws RecognitionException {
        try {
            // InternalAceGen.g:729:1: ( ruleReadFunctionType EOF )
            // InternalAceGen.g:730:1: ruleReadFunctionType EOF
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
    // InternalAceGen.g:737:1: ruleReadFunctionType : ( 'GET' ) ;
    public final void ruleReadFunctionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:741:2: ( ( 'GET' ) )
            // InternalAceGen.g:742:2: ( 'GET' )
            {
            // InternalAceGen.g:742:2: ( 'GET' )
            // InternalAceGen.g:743:3: 'GET'
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
    // InternalAceGen.g:753:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalAceGen.g:754:1: ( ruleType EOF )
            // InternalAceGen.g:755:1: ruleType EOF
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
    // InternalAceGen.g:762:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:766:2: ( ( ( rule__Type__Alternatives ) ) )
            // InternalAceGen.g:767:2: ( ( rule__Type__Alternatives ) )
            {
            // InternalAceGen.g:767:2: ( ( rule__Type__Alternatives ) )
            // InternalAceGen.g:768:3: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // InternalAceGen.g:769:3: ( rule__Type__Alternatives )
            // InternalAceGen.g:769:4: rule__Type__Alternatives
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


    // $ANTLR start "entryRuleJsonDateTime"
    // InternalAceGen.g:778:1: entryRuleJsonDateTime : ruleJsonDateTime EOF ;
    public final void entryRuleJsonDateTime() throws RecognitionException {
        try {
            // InternalAceGen.g:779:1: ( ruleJsonDateTime EOF )
            // InternalAceGen.g:780:1: ruleJsonDateTime EOF
            {
             before(grammarAccess.getJsonDateTimeRule()); 
            pushFollow(FOLLOW_1);
            ruleJsonDateTime();

            state._fsp--;

             after(grammarAccess.getJsonDateTimeRule()); 
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
    // $ANTLR end "entryRuleJsonDateTime"


    // $ANTLR start "ruleJsonDateTime"
    // InternalAceGen.g:787:1: ruleJsonDateTime : ( ( rule__JsonDateTime__Group__0 ) ) ;
    public final void ruleJsonDateTime() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:791:2: ( ( ( rule__JsonDateTime__Group__0 ) ) )
            // InternalAceGen.g:792:2: ( ( rule__JsonDateTime__Group__0 ) )
            {
            // InternalAceGen.g:792:2: ( ( rule__JsonDateTime__Group__0 ) )
            // InternalAceGen.g:793:3: ( rule__JsonDateTime__Group__0 )
            {
             before(grammarAccess.getJsonDateTimeAccess().getGroup()); 
            // InternalAceGen.g:794:3: ( rule__JsonDateTime__Group__0 )
            // InternalAceGen.g:794:4: rule__JsonDateTime__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JsonDateTime__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJsonDateTimeAccess().getGroup()); 

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
    // $ANTLR end "ruleJsonDateTime"


    // $ANTLR start "entryRuleJsonObject"
    // InternalAceGen.g:803:1: entryRuleJsonObject : ruleJsonObject EOF ;
    public final void entryRuleJsonObject() throws RecognitionException {
        try {
            // InternalAceGen.g:804:1: ( ruleJsonObject EOF )
            // InternalAceGen.g:805:1: ruleJsonObject EOF
            {
             before(grammarAccess.getJsonObjectRule()); 
            pushFollow(FOLLOW_1);
            ruleJsonObject();

            state._fsp--;

             after(grammarAccess.getJsonObjectRule()); 
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
    // $ANTLR end "entryRuleJsonObject"


    // $ANTLR start "ruleJsonObject"
    // InternalAceGen.g:812:1: ruleJsonObject : ( ( rule__JsonObject__Group__0 ) ) ;
    public final void ruleJsonObject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:816:2: ( ( ( rule__JsonObject__Group__0 ) ) )
            // InternalAceGen.g:817:2: ( ( rule__JsonObject__Group__0 ) )
            {
            // InternalAceGen.g:817:2: ( ( rule__JsonObject__Group__0 ) )
            // InternalAceGen.g:818:3: ( rule__JsonObject__Group__0 )
            {
             before(grammarAccess.getJsonObjectAccess().getGroup()); 
            // InternalAceGen.g:819:3: ( rule__JsonObject__Group__0 )
            // InternalAceGen.g:819:4: rule__JsonObject__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JsonObject__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJsonObjectAccess().getGroup()); 

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
    // $ANTLR end "ruleJsonObject"


    // $ANTLR start "entryRuleJsonMember"
    // InternalAceGen.g:828:1: entryRuleJsonMember : ruleJsonMember EOF ;
    public final void entryRuleJsonMember() throws RecognitionException {
        try {
            // InternalAceGen.g:829:1: ( ruleJsonMember EOF )
            // InternalAceGen.g:830:1: ruleJsonMember EOF
            {
             before(grammarAccess.getJsonMemberRule()); 
            pushFollow(FOLLOW_1);
            ruleJsonMember();

            state._fsp--;

             after(grammarAccess.getJsonMemberRule()); 
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
    // $ANTLR end "entryRuleJsonMember"


    // $ANTLR start "ruleJsonMember"
    // InternalAceGen.g:837:1: ruleJsonMember : ( ( rule__JsonMember__Group__0 ) ) ;
    public final void ruleJsonMember() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:841:2: ( ( ( rule__JsonMember__Group__0 ) ) )
            // InternalAceGen.g:842:2: ( ( rule__JsonMember__Group__0 ) )
            {
            // InternalAceGen.g:842:2: ( ( rule__JsonMember__Group__0 ) )
            // InternalAceGen.g:843:3: ( rule__JsonMember__Group__0 )
            {
             before(grammarAccess.getJsonMemberAccess().getGroup()); 
            // InternalAceGen.g:844:3: ( rule__JsonMember__Group__0 )
            // InternalAceGen.g:844:4: rule__JsonMember__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JsonMember__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJsonMemberAccess().getGroup()); 

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
    // $ANTLR end "ruleJsonMember"


    // $ANTLR start "entryRuleJsonValue"
    // InternalAceGen.g:853:1: entryRuleJsonValue : ruleJsonValue EOF ;
    public final void entryRuleJsonValue() throws RecognitionException {
        try {
            // InternalAceGen.g:854:1: ( ruleJsonValue EOF )
            // InternalAceGen.g:855:1: ruleJsonValue EOF
            {
             before(grammarAccess.getJsonValueRule()); 
            pushFollow(FOLLOW_1);
            ruleJsonValue();

            state._fsp--;

             after(grammarAccess.getJsonValueRule()); 
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
    // $ANTLR end "entryRuleJsonValue"


    // $ANTLR start "ruleJsonValue"
    // InternalAceGen.g:862:1: ruleJsonValue : ( ( rule__JsonValue__Alternatives ) ) ;
    public final void ruleJsonValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:866:2: ( ( ( rule__JsonValue__Alternatives ) ) )
            // InternalAceGen.g:867:2: ( ( rule__JsonValue__Alternatives ) )
            {
            // InternalAceGen.g:867:2: ( ( rule__JsonValue__Alternatives ) )
            // InternalAceGen.g:868:3: ( rule__JsonValue__Alternatives )
            {
             before(grammarAccess.getJsonValueAccess().getAlternatives()); 
            // InternalAceGen.g:869:3: ( rule__JsonValue__Alternatives )
            // InternalAceGen.g:869:4: rule__JsonValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JsonValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJsonValueAccess().getAlternatives()); 

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
    // $ANTLR end "ruleJsonValue"


    // $ANTLR start "entryRuleJsonArray"
    // InternalAceGen.g:878:1: entryRuleJsonArray : ruleJsonArray EOF ;
    public final void entryRuleJsonArray() throws RecognitionException {
        try {
            // InternalAceGen.g:879:1: ( ruleJsonArray EOF )
            // InternalAceGen.g:880:1: ruleJsonArray EOF
            {
             before(grammarAccess.getJsonArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleJsonArray();

            state._fsp--;

             after(grammarAccess.getJsonArrayRule()); 
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
    // $ANTLR end "entryRuleJsonArray"


    // $ANTLR start "ruleJsonArray"
    // InternalAceGen.g:887:1: ruleJsonArray : ( ( rule__JsonArray__Group__0 ) ) ;
    public final void ruleJsonArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:891:2: ( ( ( rule__JsonArray__Group__0 ) ) )
            // InternalAceGen.g:892:2: ( ( rule__JsonArray__Group__0 ) )
            {
            // InternalAceGen.g:892:2: ( ( rule__JsonArray__Group__0 ) )
            // InternalAceGen.g:893:3: ( rule__JsonArray__Group__0 )
            {
             before(grammarAccess.getJsonArrayAccess().getGroup()); 
            // InternalAceGen.g:894:3: ( rule__JsonArray__Group__0 )
            // InternalAceGen.g:894:4: rule__JsonArray__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__JsonArray__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJsonArrayAccess().getGroup()); 

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
    // $ANTLR end "ruleJsonArray"


    // $ANTLR start "entryRuleJsonBoolean"
    // InternalAceGen.g:903:1: entryRuleJsonBoolean : ruleJsonBoolean EOF ;
    public final void entryRuleJsonBoolean() throws RecognitionException {
        try {
            // InternalAceGen.g:904:1: ( ruleJsonBoolean EOF )
            // InternalAceGen.g:905:1: ruleJsonBoolean EOF
            {
             before(grammarAccess.getJsonBooleanRule()); 
            pushFollow(FOLLOW_1);
            ruleJsonBoolean();

            state._fsp--;

             after(grammarAccess.getJsonBooleanRule()); 
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
    // $ANTLR end "entryRuleJsonBoolean"


    // $ANTLR start "ruleJsonBoolean"
    // InternalAceGen.g:912:1: ruleJsonBoolean : ( ( rule__JsonBoolean__Alternatives ) ) ;
    public final void ruleJsonBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:916:2: ( ( ( rule__JsonBoolean__Alternatives ) ) )
            // InternalAceGen.g:917:2: ( ( rule__JsonBoolean__Alternatives ) )
            {
            // InternalAceGen.g:917:2: ( ( rule__JsonBoolean__Alternatives ) )
            // InternalAceGen.g:918:3: ( rule__JsonBoolean__Alternatives )
            {
             before(grammarAccess.getJsonBooleanAccess().getAlternatives()); 
            // InternalAceGen.g:919:3: ( rule__JsonBoolean__Alternatives )
            // InternalAceGen.g:919:4: rule__JsonBoolean__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JsonBoolean__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJsonBooleanAccess().getAlternatives()); 

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
    // $ANTLR end "ruleJsonBoolean"


    // $ANTLR start "entryRuleJsonNull"
    // InternalAceGen.g:928:1: entryRuleJsonNull : ruleJsonNull EOF ;
    public final void entryRuleJsonNull() throws RecognitionException {
        try {
            // InternalAceGen.g:929:1: ( ruleJsonNull EOF )
            // InternalAceGen.g:930:1: ruleJsonNull EOF
            {
             before(grammarAccess.getJsonNullRule()); 
            pushFollow(FOLLOW_1);
            ruleJsonNull();

            state._fsp--;

             after(grammarAccess.getJsonNullRule()); 
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
    // $ANTLR end "entryRuleJsonNull"


    // $ANTLR start "ruleJsonNull"
    // InternalAceGen.g:937:1: ruleJsonNull : ( 'null' ) ;
    public final void ruleJsonNull() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:941:2: ( ( 'null' ) )
            // InternalAceGen.g:942:2: ( 'null' )
            {
            // InternalAceGen.g:942:2: ( 'null' )
            // InternalAceGen.g:943:3: 'null'
            {
             before(grammarAccess.getJsonNullAccess().getNullKeyword()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getJsonNullAccess().getNullKeyword()); 

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
    // $ANTLR end "ruleJsonNull"


    // $ANTLR start "rule__Project__Alternatives_1"
    // InternalAceGen.g:952:1: rule__Project__Alternatives_1 : ( ( ( rule__Project__Group_1_0__0 ) ) | ( ( rule__Project__Group_1_1__0 ) ) );
    public final void rule__Project__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:956:1: ( ( ( rule__Project__Group_1_0__0 ) ) | ( ( rule__Project__Group_1_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==28) ) {
                alt1=1;
            }
            else if ( (LA1_0==29) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalAceGen.g:957:2: ( ( rule__Project__Group_1_0__0 ) )
                    {
                    // InternalAceGen.g:957:2: ( ( rule__Project__Group_1_0__0 ) )
                    // InternalAceGen.g:958:3: ( rule__Project__Group_1_0__0 )
                    {
                     before(grammarAccess.getProjectAccess().getGroup_1_0()); 
                    // InternalAceGen.g:959:3: ( rule__Project__Group_1_0__0 )
                    // InternalAceGen.g:959:4: rule__Project__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Project__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getProjectAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:963:2: ( ( rule__Project__Group_1_1__0 ) )
                    {
                    // InternalAceGen.g:963:2: ( ( rule__Project__Group_1_1__0 ) )
                    // InternalAceGen.g:964:3: ( rule__Project__Group_1_1__0 )
                    {
                     before(grammarAccess.getProjectAccess().getGroup_1_1()); 
                    // InternalAceGen.g:965:3: ( rule__Project__Group_1_1__0 )
                    // InternalAceGen.g:965:4: rule__Project__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Project__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getProjectAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__Project__Alternatives_1"


    // $ANTLR start "rule__HttpClientStateFunctionType__Alternatives"
    // InternalAceGen.g:973:1: rule__HttpClientStateFunctionType__Alternatives : ( ( 'set' ) | ( 'merge' ) | ( 'reset' ) | ( 'init' ) );
    public final void rule__HttpClientStateFunctionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:977:1: ( ( 'set' ) | ( 'merge' ) | ( 'reset' ) | ( 'init' ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt2=1;
                }
                break;
            case 14:
                {
                alt2=2;
                }
                break;
            case 15:
                {
                alt2=3;
                }
                break;
            case 16:
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
                    // InternalAceGen.g:978:2: ( 'set' )
                    {
                    // InternalAceGen.g:978:2: ( 'set' )
                    // InternalAceGen.g:979:3: 'set'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:984:2: ( 'merge' )
                    {
                    // InternalAceGen.g:984:2: ( 'merge' )
                    // InternalAceGen.g:985:3: 'merge'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:990:2: ( 'reset' )
                    {
                    // InternalAceGen.g:990:2: ( 'reset' )
                    // InternalAceGen.g:991:3: 'reset'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getResetKeyword_2()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getResetKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:996:2: ( 'init' )
                    {
                    // InternalAceGen.g:996:2: ( 'init' )
                    // InternalAceGen.g:997:3: 'init'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getInitKeyword_3()); 
                    match(input,16,FOLLOW_2); 
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
    // InternalAceGen.g:1006:1: rule__HttpServerAce__Alternatives : ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) );
    public final void rule__HttpServerAce__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1010:1: ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalAceGen.g:1011:2: ( ruleHttpServerAceWrite )
                    {
                    // InternalAceGen.g:1011:2: ( ruleHttpServerAceWrite )
                    // InternalAceGen.g:1012:3: ruleHttpServerAceWrite
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
                    // InternalAceGen.g:1017:2: ( ruleHttpServerAceRead )
                    {
                    // InternalAceGen.g:1017:2: ( ruleHttpServerAceRead )
                    // InternalAceGen.g:1018:3: ruleHttpServerAceRead
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
    // InternalAceGen.g:1027:1: rule__Attribute__Alternatives_4 : ( ( ( rule__Attribute__TypeAssignment_4_0 ) ) | ( ( rule__Attribute__ModelAssignment_4_1 ) ) );
    public final void rule__Attribute__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1031:1: ( ( ( rule__Attribute__TypeAssignment_4_0 ) ) | ( ( rule__Attribute__ModelAssignment_4_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=20 && LA4_0<=25)) ) {
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
                    // InternalAceGen.g:1032:2: ( ( rule__Attribute__TypeAssignment_4_0 ) )
                    {
                    // InternalAceGen.g:1032:2: ( ( rule__Attribute__TypeAssignment_4_0 ) )
                    // InternalAceGen.g:1033:3: ( rule__Attribute__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getAttributeAccess().getTypeAssignment_4_0()); 
                    // InternalAceGen.g:1034:3: ( rule__Attribute__TypeAssignment_4_0 )
                    // InternalAceGen.g:1034:4: rule__Attribute__TypeAssignment_4_0
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
                    // InternalAceGen.g:1038:2: ( ( rule__Attribute__ModelAssignment_4_1 ) )
                    {
                    // InternalAceGen.g:1038:2: ( ( rule__Attribute__ModelAssignment_4_1 ) )
                    // InternalAceGen.g:1039:3: ( rule__Attribute__ModelAssignment_4_1 )
                    {
                     before(grammarAccess.getAttributeAccess().getModelAssignment_4_1()); 
                    // InternalAceGen.g:1040:3: ( rule__Attribute__ModelAssignment_4_1 )
                    // InternalAceGen.g:1040:4: rule__Attribute__ModelAssignment_4_1
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
    // InternalAceGen.g:1048:1: rule__WriteFunctionType__Alternatives : ( ( 'POST' ) | ( 'PUT' ) | ( 'DELETE' ) );
    public final void rule__WriteFunctionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1052:1: ( ( 'POST' ) | ( 'PUT' ) | ( 'DELETE' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt5=1;
                }
                break;
            case 18:
                {
                alt5=2;
                }
                break;
            case 19:
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
                    // InternalAceGen.g:1053:2: ( 'POST' )
                    {
                    // InternalAceGen.g:1053:2: ( 'POST' )
                    // InternalAceGen.g:1054:3: 'POST'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1059:2: ( 'PUT' )
                    {
                    // InternalAceGen.g:1059:2: ( 'PUT' )
                    // InternalAceGen.g:1060:3: 'PUT'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:1065:2: ( 'DELETE' )
                    {
                    // InternalAceGen.g:1065:2: ( 'DELETE' )
                    // InternalAceGen.g:1066:3: 'DELETE'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getDELETEKeyword_2()); 
                    match(input,19,FOLLOW_2); 
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
    // InternalAceGen.g:1075:1: rule__Type__Alternatives : ( ( 'Integer' ) | ( 'String' ) | ( 'Float' ) | ( 'Boolean' ) | ( 'DateTime' ) | ( 'Long' ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1079:1: ( ( 'Integer' ) | ( 'String' ) | ( 'Float' ) | ( 'Boolean' ) | ( 'DateTime' ) | ( 'Long' ) )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt6=1;
                }
                break;
            case 21:
                {
                alt6=2;
                }
                break;
            case 22:
                {
                alt6=3;
                }
                break;
            case 23:
                {
                alt6=4;
                }
                break;
            case 24:
                {
                alt6=5;
                }
                break;
            case 25:
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
                    // InternalAceGen.g:1080:2: ( 'Integer' )
                    {
                    // InternalAceGen.g:1080:2: ( 'Integer' )
                    // InternalAceGen.g:1081:3: 'Integer'
                    {
                     before(grammarAccess.getTypeAccess().getIntegerKeyword_0()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getIntegerKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1086:2: ( 'String' )
                    {
                    // InternalAceGen.g:1086:2: ( 'String' )
                    // InternalAceGen.g:1087:3: 'String'
                    {
                     before(grammarAccess.getTypeAccess().getStringKeyword_1()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getStringKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:1092:2: ( 'Float' )
                    {
                    // InternalAceGen.g:1092:2: ( 'Float' )
                    // InternalAceGen.g:1093:3: 'Float'
                    {
                     before(grammarAccess.getTypeAccess().getFloatKeyword_2()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getFloatKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:1098:2: ( 'Boolean' )
                    {
                    // InternalAceGen.g:1098:2: ( 'Boolean' )
                    // InternalAceGen.g:1099:3: 'Boolean'
                    {
                     before(grammarAccess.getTypeAccess().getBooleanKeyword_3()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getBooleanKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalAceGen.g:1104:2: ( 'DateTime' )
                    {
                    // InternalAceGen.g:1104:2: ( 'DateTime' )
                    // InternalAceGen.g:1105:3: 'DateTime'
                    {
                     before(grammarAccess.getTypeAccess().getDateTimeKeyword_4()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getDateTimeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalAceGen.g:1110:2: ( 'Long' )
                    {
                    // InternalAceGen.g:1110:2: ( 'Long' )
                    // InternalAceGen.g:1111:3: 'Long'
                    {
                     before(grammarAccess.getTypeAccess().getLongKeyword_5()); 
                    match(input,25,FOLLOW_2); 
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


    // $ANTLR start "rule__JsonValue__Alternatives"
    // InternalAceGen.g:1120:1: rule__JsonValue__Alternatives : ( ( ruleJsonObject ) | ( ( rule__JsonValue__StringAssignment_1 ) ) | ( ruleJsonArray ) | ( ( rule__JsonValue__BooleanAssignment_3 ) ) | ( ( rule__JsonValue__NullAssignment_4 ) ) | ( ( rule__JsonValue__LongAssignment_5 ) ) | ( ruleJsonDateTime ) );
    public final void rule__JsonValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1124:1: ( ( ruleJsonObject ) | ( ( rule__JsonValue__StringAssignment_1 ) ) | ( ruleJsonArray ) | ( ( rule__JsonValue__BooleanAssignment_3 ) ) | ( ( rule__JsonValue__NullAssignment_4 ) ) | ( ( rule__JsonValue__LongAssignment_5 ) ) | ( ruleJsonDateTime ) )
            int alt7=7;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt7=1;
                }
                break;
            case RULE_STRING:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==EOF||LA7_2==34||LA7_2==44||LA7_2==65) ) {
                    alt7=2;
                }
                else if ( (LA7_2==RULE_STRING) ) {
                    alt7=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case 64:
                {
                alt7=3;
                }
                break;
            case 26:
            case 27:
                {
                alt7=4;
                }
                break;
            case 12:
                {
                alt7=5;
                }
                break;
            case RULE_INT:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalAceGen.g:1125:2: ( ruleJsonObject )
                    {
                    // InternalAceGen.g:1125:2: ( ruleJsonObject )
                    // InternalAceGen.g:1126:3: ruleJsonObject
                    {
                     before(grammarAccess.getJsonValueAccess().getJsonObjectParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleJsonObject();

                    state._fsp--;

                     after(grammarAccess.getJsonValueAccess().getJsonObjectParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1131:2: ( ( rule__JsonValue__StringAssignment_1 ) )
                    {
                    // InternalAceGen.g:1131:2: ( ( rule__JsonValue__StringAssignment_1 ) )
                    // InternalAceGen.g:1132:3: ( rule__JsonValue__StringAssignment_1 )
                    {
                     before(grammarAccess.getJsonValueAccess().getStringAssignment_1()); 
                    // InternalAceGen.g:1133:3: ( rule__JsonValue__StringAssignment_1 )
                    // InternalAceGen.g:1133:4: rule__JsonValue__StringAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__JsonValue__StringAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getJsonValueAccess().getStringAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:1137:2: ( ruleJsonArray )
                    {
                    // InternalAceGen.g:1137:2: ( ruleJsonArray )
                    // InternalAceGen.g:1138:3: ruleJsonArray
                    {
                     before(grammarAccess.getJsonValueAccess().getJsonArrayParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleJsonArray();

                    state._fsp--;

                     after(grammarAccess.getJsonValueAccess().getJsonArrayParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:1143:2: ( ( rule__JsonValue__BooleanAssignment_3 ) )
                    {
                    // InternalAceGen.g:1143:2: ( ( rule__JsonValue__BooleanAssignment_3 ) )
                    // InternalAceGen.g:1144:3: ( rule__JsonValue__BooleanAssignment_3 )
                    {
                     before(grammarAccess.getJsonValueAccess().getBooleanAssignment_3()); 
                    // InternalAceGen.g:1145:3: ( rule__JsonValue__BooleanAssignment_3 )
                    // InternalAceGen.g:1145:4: rule__JsonValue__BooleanAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__JsonValue__BooleanAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getJsonValueAccess().getBooleanAssignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalAceGen.g:1149:2: ( ( rule__JsonValue__NullAssignment_4 ) )
                    {
                    // InternalAceGen.g:1149:2: ( ( rule__JsonValue__NullAssignment_4 ) )
                    // InternalAceGen.g:1150:3: ( rule__JsonValue__NullAssignment_4 )
                    {
                     before(grammarAccess.getJsonValueAccess().getNullAssignment_4()); 
                    // InternalAceGen.g:1151:3: ( rule__JsonValue__NullAssignment_4 )
                    // InternalAceGen.g:1151:4: rule__JsonValue__NullAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__JsonValue__NullAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getJsonValueAccess().getNullAssignment_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalAceGen.g:1155:2: ( ( rule__JsonValue__LongAssignment_5 ) )
                    {
                    // InternalAceGen.g:1155:2: ( ( rule__JsonValue__LongAssignment_5 ) )
                    // InternalAceGen.g:1156:3: ( rule__JsonValue__LongAssignment_5 )
                    {
                     before(grammarAccess.getJsonValueAccess().getLongAssignment_5()); 
                    // InternalAceGen.g:1157:3: ( rule__JsonValue__LongAssignment_5 )
                    // InternalAceGen.g:1157:4: rule__JsonValue__LongAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__JsonValue__LongAssignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getJsonValueAccess().getLongAssignment_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalAceGen.g:1161:2: ( ruleJsonDateTime )
                    {
                    // InternalAceGen.g:1161:2: ( ruleJsonDateTime )
                    // InternalAceGen.g:1162:3: ruleJsonDateTime
                    {
                     before(grammarAccess.getJsonValueAccess().getJsonDateTimeParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleJsonDateTime();

                    state._fsp--;

                     after(grammarAccess.getJsonValueAccess().getJsonDateTimeParserRuleCall_6()); 

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
    // $ANTLR end "rule__JsonValue__Alternatives"


    // $ANTLR start "rule__JsonBoolean__Alternatives"
    // InternalAceGen.g:1171:1: rule__JsonBoolean__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__JsonBoolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1175:1: ( ( 'true' ) | ( 'false' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            else if ( (LA8_0==27) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalAceGen.g:1176:2: ( 'true' )
                    {
                    // InternalAceGen.g:1176:2: ( 'true' )
                    // InternalAceGen.g:1177:3: 'true'
                    {
                     before(grammarAccess.getJsonBooleanAccess().getTrueKeyword_0()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getJsonBooleanAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1182:2: ( 'false' )
                    {
                    // InternalAceGen.g:1182:2: ( 'false' )
                    // InternalAceGen.g:1183:3: 'false'
                    {
                     before(grammarAccess.getJsonBooleanAccess().getFalseKeyword_1()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getJsonBooleanAccess().getFalseKeyword_1()); 

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
    // $ANTLR end "rule__JsonBoolean__Alternatives"


    // $ANTLR start "rule__Project__Group__0"
    // InternalAceGen.g:1192:1: rule__Project__Group__0 : rule__Project__Group__0__Impl rule__Project__Group__1 ;
    public final void rule__Project__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1196:1: ( rule__Project__Group__0__Impl rule__Project__Group__1 )
            // InternalAceGen.g:1197:2: rule__Project__Group__0__Impl rule__Project__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Project__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__1();

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
    // $ANTLR end "rule__Project__Group__0"


    // $ANTLR start "rule__Project__Group__0__Impl"
    // InternalAceGen.g:1204:1: rule__Project__Group__0__Impl : ( () ) ;
    public final void rule__Project__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1208:1: ( ( () ) )
            // InternalAceGen.g:1209:1: ( () )
            {
            // InternalAceGen.g:1209:1: ( () )
            // InternalAceGen.g:1210:2: ()
            {
             before(grammarAccess.getProjectAccess().getProjectAction_0()); 
            // InternalAceGen.g:1211:2: ()
            // InternalAceGen.g:1211:3: 
            {
            }

             after(grammarAccess.getProjectAccess().getProjectAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__0__Impl"


    // $ANTLR start "rule__Project__Group__1"
    // InternalAceGen.g:1219:1: rule__Project__Group__1 : rule__Project__Group__1__Impl ;
    public final void rule__Project__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1223:1: ( rule__Project__Group__1__Impl )
            // InternalAceGen.g:1224:2: rule__Project__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group__1__Impl();

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
    // $ANTLR end "rule__Project__Group__1"


    // $ANTLR start "rule__Project__Group__1__Impl"
    // InternalAceGen.g:1230:1: rule__Project__Group__1__Impl : ( ( rule__Project__Alternatives_1 )? ) ;
    public final void rule__Project__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1234:1: ( ( ( rule__Project__Alternatives_1 )? ) )
            // InternalAceGen.g:1235:1: ( ( rule__Project__Alternatives_1 )? )
            {
            // InternalAceGen.g:1235:1: ( ( rule__Project__Alternatives_1 )? )
            // InternalAceGen.g:1236:2: ( rule__Project__Alternatives_1 )?
            {
             before(grammarAccess.getProjectAccess().getAlternatives_1()); 
            // InternalAceGen.g:1237:2: ( rule__Project__Alternatives_1 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=28 && LA9_0<=29)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAceGen.g:1237:3: rule__Project__Alternatives_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Project__Alternatives_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProjectAccess().getAlternatives_1()); 

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
    // $ANTLR end "rule__Project__Group__1__Impl"


    // $ANTLR start "rule__Project__Group_1_0__0"
    // InternalAceGen.g:1246:1: rule__Project__Group_1_0__0 : rule__Project__Group_1_0__0__Impl rule__Project__Group_1_0__1 ;
    public final void rule__Project__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1250:1: ( rule__Project__Group_1_0__0__Impl rule__Project__Group_1_0__1 )
            // InternalAceGen.g:1251:2: rule__Project__Group_1_0__0__Impl rule__Project__Group_1_0__1
            {
            pushFollow(FOLLOW_4);
            rule__Project__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group_1_0__1();

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
    // $ANTLR end "rule__Project__Group_1_0__0"


    // $ANTLR start "rule__Project__Group_1_0__0__Impl"
    // InternalAceGen.g:1258:1: rule__Project__Group_1_0__0__Impl : ( 'HttpClient' ) ;
    public final void rule__Project__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1262:1: ( ( 'HttpClient' ) )
            // InternalAceGen.g:1263:1: ( 'HttpClient' )
            {
            // InternalAceGen.g:1263:1: ( 'HttpClient' )
            // InternalAceGen.g:1264:2: 'HttpClient'
            {
             before(grammarAccess.getProjectAccess().getHttpClientKeyword_1_0_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getHttpClientKeyword_1_0_0()); 

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
    // $ANTLR end "rule__Project__Group_1_0__0__Impl"


    // $ANTLR start "rule__Project__Group_1_0__1"
    // InternalAceGen.g:1273:1: rule__Project__Group_1_0__1 : rule__Project__Group_1_0__1__Impl ;
    public final void rule__Project__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1277:1: ( rule__Project__Group_1_0__1__Impl )
            // InternalAceGen.g:1278:2: rule__Project__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group_1_0__1__Impl();

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
    // $ANTLR end "rule__Project__Group_1_0__1"


    // $ANTLR start "rule__Project__Group_1_0__1__Impl"
    // InternalAceGen.g:1284:1: rule__Project__Group_1_0__1__Impl : ( ( rule__Project__HttpClientAssignment_1_0_1 )? ) ;
    public final void rule__Project__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1288:1: ( ( ( rule__Project__HttpClientAssignment_1_0_1 )? ) )
            // InternalAceGen.g:1289:1: ( ( rule__Project__HttpClientAssignment_1_0_1 )? )
            {
            // InternalAceGen.g:1289:1: ( ( rule__Project__HttpClientAssignment_1_0_1 )? )
            // InternalAceGen.g:1290:2: ( rule__Project__HttpClientAssignment_1_0_1 )?
            {
             before(grammarAccess.getProjectAccess().getHttpClientAssignment_1_0_1()); 
            // InternalAceGen.g:1291:2: ( rule__Project__HttpClientAssignment_1_0_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAceGen.g:1291:3: rule__Project__HttpClientAssignment_1_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Project__HttpClientAssignment_1_0_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProjectAccess().getHttpClientAssignment_1_0_1()); 

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
    // $ANTLR end "rule__Project__Group_1_0__1__Impl"


    // $ANTLR start "rule__Project__Group_1_1__0"
    // InternalAceGen.g:1300:1: rule__Project__Group_1_1__0 : rule__Project__Group_1_1__0__Impl rule__Project__Group_1_1__1 ;
    public final void rule__Project__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1304:1: ( rule__Project__Group_1_1__0__Impl rule__Project__Group_1_1__1 )
            // InternalAceGen.g:1305:2: rule__Project__Group_1_1__0__Impl rule__Project__Group_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Project__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group_1_1__1();

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
    // $ANTLR end "rule__Project__Group_1_1__0"


    // $ANTLR start "rule__Project__Group_1_1__0__Impl"
    // InternalAceGen.g:1312:1: rule__Project__Group_1_1__0__Impl : ( 'HttpServer' ) ;
    public final void rule__Project__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1316:1: ( ( 'HttpServer' ) )
            // InternalAceGen.g:1317:1: ( 'HttpServer' )
            {
            // InternalAceGen.g:1317:1: ( 'HttpServer' )
            // InternalAceGen.g:1318:2: 'HttpServer'
            {
             before(grammarAccess.getProjectAccess().getHttpServerKeyword_1_1_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getHttpServerKeyword_1_1_0()); 

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
    // $ANTLR end "rule__Project__Group_1_1__0__Impl"


    // $ANTLR start "rule__Project__Group_1_1__1"
    // InternalAceGen.g:1327:1: rule__Project__Group_1_1__1 : rule__Project__Group_1_1__1__Impl ;
    public final void rule__Project__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1331:1: ( rule__Project__Group_1_1__1__Impl )
            // InternalAceGen.g:1332:2: rule__Project__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__Project__Group_1_1__1"


    // $ANTLR start "rule__Project__Group_1_1__1__Impl"
    // InternalAceGen.g:1338:1: rule__Project__Group_1_1__1__Impl : ( ( rule__Project__HttpServerAssignment_1_1_1 )? ) ;
    public final void rule__Project__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1342:1: ( ( ( rule__Project__HttpServerAssignment_1_1_1 )? ) )
            // InternalAceGen.g:1343:1: ( ( rule__Project__HttpServerAssignment_1_1_1 )? )
            {
            // InternalAceGen.g:1343:1: ( ( rule__Project__HttpServerAssignment_1_1_1 )? )
            // InternalAceGen.g:1344:2: ( rule__Project__HttpServerAssignment_1_1_1 )?
            {
             before(grammarAccess.getProjectAccess().getHttpServerAssignment_1_1_1()); 
            // InternalAceGen.g:1345:2: ( rule__Project__HttpServerAssignment_1_1_1 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==70) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAceGen.g:1345:3: rule__Project__HttpServerAssignment_1_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Project__HttpServerAssignment_1_1_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProjectAccess().getHttpServerAssignment_1_1_1()); 

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
    // $ANTLR end "rule__Project__Group_1_1__1__Impl"


    // $ANTLR start "rule__HttpClient__Group__0"
    // InternalAceGen.g:1354:1: rule__HttpClient__Group__0 : rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1 ;
    public final void rule__HttpClient__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1358:1: ( rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1 )
            // InternalAceGen.g:1359:2: rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalAceGen.g:1366:1: rule__HttpClient__Group__0__Impl : ( ( rule__HttpClient__NameAssignment_0 ) ) ;
    public final void rule__HttpClient__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1370:1: ( ( ( rule__HttpClient__NameAssignment_0 ) ) )
            // InternalAceGen.g:1371:1: ( ( rule__HttpClient__NameAssignment_0 ) )
            {
            // InternalAceGen.g:1371:1: ( ( rule__HttpClient__NameAssignment_0 ) )
            // InternalAceGen.g:1372:2: ( rule__HttpClient__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientAccess().getNameAssignment_0()); 
            // InternalAceGen.g:1373:2: ( rule__HttpClient__NameAssignment_0 )
            // InternalAceGen.g:1373:3: rule__HttpClient__NameAssignment_0
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
    // InternalAceGen.g:1381:1: rule__HttpClient__Group__1 : rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2 ;
    public final void rule__HttpClient__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1385:1: ( rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2 )
            // InternalAceGen.g:1386:2: rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2
            {
            pushFollow(FOLLOW_6);
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
    // InternalAceGen.g:1393:1: rule__HttpClient__Group__1__Impl : ( ( rule__HttpClient__Group_1__0 )? ) ;
    public final void rule__HttpClient__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1397:1: ( ( ( rule__HttpClient__Group_1__0 )? ) )
            // InternalAceGen.g:1398:1: ( ( rule__HttpClient__Group_1__0 )? )
            {
            // InternalAceGen.g:1398:1: ( ( rule__HttpClient__Group_1__0 )? )
            // InternalAceGen.g:1399:2: ( rule__HttpClient__Group_1__0 )?
            {
             before(grammarAccess.getHttpClientAccess().getGroup_1()); 
            // InternalAceGen.g:1400:2: ( rule__HttpClient__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==30) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalAceGen.g:1400:3: rule__HttpClient__Group_1__0
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
    // InternalAceGen.g:1408:1: rule__HttpClient__Group__2 : rule__HttpClient__Group__2__Impl ;
    public final void rule__HttpClient__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1412:1: ( rule__HttpClient__Group__2__Impl )
            // InternalAceGen.g:1413:2: rule__HttpClient__Group__2__Impl
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
    // InternalAceGen.g:1419:1: rule__HttpClient__Group__2__Impl : ( ( rule__HttpClient__Group_2__0 )? ) ;
    public final void rule__HttpClient__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1423:1: ( ( ( rule__HttpClient__Group_2__0 )? ) )
            // InternalAceGen.g:1424:1: ( ( rule__HttpClient__Group_2__0 )? )
            {
            // InternalAceGen.g:1424:1: ( ( rule__HttpClient__Group_2__0 )? )
            // InternalAceGen.g:1425:2: ( rule__HttpClient__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientAccess().getGroup_2()); 
            // InternalAceGen.g:1426:2: ( rule__HttpClient__Group_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==31) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalAceGen.g:1426:3: rule__HttpClient__Group_2__0
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
    // InternalAceGen.g:1435:1: rule__HttpClient__Group_1__0 : rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1 ;
    public final void rule__HttpClient__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1439:1: ( rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1 )
            // InternalAceGen.g:1440:2: rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalAceGen.g:1447:1: rule__HttpClient__Group_1__0__Impl : ( 'ACE' ) ;
    public final void rule__HttpClient__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1451:1: ( ( 'ACE' ) )
            // InternalAceGen.g:1452:1: ( 'ACE' )
            {
            // InternalAceGen.g:1452:1: ( 'ACE' )
            // InternalAceGen.g:1453:2: 'ACE'
            {
             before(grammarAccess.getHttpClientAccess().getACEKeyword_1_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalAceGen.g:1462:1: rule__HttpClient__Group_1__1 : rule__HttpClient__Group_1__1__Impl ;
    public final void rule__HttpClient__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1466:1: ( rule__HttpClient__Group_1__1__Impl )
            // InternalAceGen.g:1467:2: rule__HttpClient__Group_1__1__Impl
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
    // InternalAceGen.g:1473:1: rule__HttpClient__Group_1__1__Impl : ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* ) ;
    public final void rule__HttpClient__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1477:1: ( ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* ) )
            // InternalAceGen.g:1478:1: ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* )
            {
            // InternalAceGen.g:1478:1: ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* )
            // InternalAceGen.g:1479:2: ( rule__HttpClient__AceOperationsAssignment_1_1 )*
            {
             before(grammarAccess.getHttpClientAccess().getAceOperationsAssignment_1_1()); 
            // InternalAceGen.g:1480:2: ( rule__HttpClient__AceOperationsAssignment_1_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID||LA14_0==66) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalAceGen.g:1480:3: rule__HttpClient__AceOperationsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__HttpClient__AceOperationsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // InternalAceGen.g:1489:1: rule__HttpClient__Group_2__0 : rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1 ;
    public final void rule__HttpClient__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1493:1: ( rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1 )
            // InternalAceGen.g:1494:2: rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1
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
    // InternalAceGen.g:1501:1: rule__HttpClient__Group_2__0__Impl : ( 'appState' ) ;
    public final void rule__HttpClient__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1505:1: ( ( 'appState' ) )
            // InternalAceGen.g:1506:1: ( 'appState' )
            {
            // InternalAceGen.g:1506:1: ( 'appState' )
            // InternalAceGen.g:1507:2: 'appState'
            {
             before(grammarAccess.getHttpClientAccess().getAppStateKeyword_2_0()); 
            match(input,31,FOLLOW_2); 
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
    // InternalAceGen.g:1516:1: rule__HttpClient__Group_2__1 : rule__HttpClient__Group_2__1__Impl ;
    public final void rule__HttpClient__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1520:1: ( rule__HttpClient__Group_2__1__Impl )
            // InternalAceGen.g:1521:2: rule__HttpClient__Group_2__1__Impl
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
    // InternalAceGen.g:1527:1: rule__HttpClient__Group_2__1__Impl : ( ( rule__HttpClient__AppStateAssignment_2_1 ) ) ;
    public final void rule__HttpClient__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1531:1: ( ( ( rule__HttpClient__AppStateAssignment_2_1 ) ) )
            // InternalAceGen.g:1532:1: ( ( rule__HttpClient__AppStateAssignment_2_1 ) )
            {
            // InternalAceGen.g:1532:1: ( ( rule__HttpClient__AppStateAssignment_2_1 ) )
            // InternalAceGen.g:1533:2: ( rule__HttpClient__AppStateAssignment_2_1 )
            {
             before(grammarAccess.getHttpClientAccess().getAppStateAssignment_2_1()); 
            // InternalAceGen.g:1534:2: ( rule__HttpClient__AppStateAssignment_2_1 )
            // InternalAceGen.g:1534:3: rule__HttpClient__AppStateAssignment_2_1
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
    // InternalAceGen.g:1543:1: rule__HttpClientAce__Group__0 : rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1 ;
    public final void rule__HttpClientAce__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1547:1: ( rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1 )
            // InternalAceGen.g:1548:2: rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1
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
    // InternalAceGen.g:1555:1: rule__HttpClientAce__Group__0__Impl : ( ( rule__HttpClientAce__AsyncAssignment_0 )? ) ;
    public final void rule__HttpClientAce__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1559:1: ( ( ( rule__HttpClientAce__AsyncAssignment_0 )? ) )
            // InternalAceGen.g:1560:1: ( ( rule__HttpClientAce__AsyncAssignment_0 )? )
            {
            // InternalAceGen.g:1560:1: ( ( rule__HttpClientAce__AsyncAssignment_0 )? )
            // InternalAceGen.g:1561:2: ( rule__HttpClientAce__AsyncAssignment_0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getAsyncAssignment_0()); 
            // InternalAceGen.g:1562:2: ( rule__HttpClientAce__AsyncAssignment_0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==66) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalAceGen.g:1562:3: rule__HttpClientAce__AsyncAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClientAce__AsyncAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientAceAccess().getAsyncAssignment_0()); 

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
    // InternalAceGen.g:1570:1: rule__HttpClientAce__Group__1 : rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2 ;
    public final void rule__HttpClientAce__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1574:1: ( rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2 )
            // InternalAceGen.g:1575:2: rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2
            {
            pushFollow(FOLLOW_9);
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
    // InternalAceGen.g:1582:1: rule__HttpClientAce__Group__1__Impl : ( ( rule__HttpClientAce__NameAssignment_1 ) ) ;
    public final void rule__HttpClientAce__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1586:1: ( ( ( rule__HttpClientAce__NameAssignment_1 ) ) )
            // InternalAceGen.g:1587:1: ( ( rule__HttpClientAce__NameAssignment_1 ) )
            {
            // InternalAceGen.g:1587:1: ( ( rule__HttpClientAce__NameAssignment_1 ) )
            // InternalAceGen.g:1588:2: ( rule__HttpClientAce__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getNameAssignment_1()); 
            // InternalAceGen.g:1589:2: ( rule__HttpClientAce__NameAssignment_1 )
            // InternalAceGen.g:1589:3: rule__HttpClientAce__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAceAccess().getNameAssignment_1()); 

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
    // InternalAceGen.g:1597:1: rule__HttpClientAce__Group__2 : rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3 ;
    public final void rule__HttpClientAce__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1601:1: ( rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3 )
            // InternalAceGen.g:1602:2: rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3
            {
            pushFollow(FOLLOW_9);
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
    // InternalAceGen.g:1609:1: rule__HttpClientAce__Group__2__Impl : ( ( rule__HttpClientAce__Group_2__0 )? ) ;
    public final void rule__HttpClientAce__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1613:1: ( ( ( rule__HttpClientAce__Group_2__0 )? ) )
            // InternalAceGen.g:1614:1: ( ( rule__HttpClientAce__Group_2__0 )? )
            {
            // InternalAceGen.g:1614:1: ( ( rule__HttpClientAce__Group_2__0 )? )
            // InternalAceGen.g:1615:2: ( rule__HttpClientAce__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_2()); 
            // InternalAceGen.g:1616:2: ( rule__HttpClientAce__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==32) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAceGen.g:1616:3: rule__HttpClientAce__Group_2__0
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
    // InternalAceGen.g:1624:1: rule__HttpClientAce__Group__3 : rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4 ;
    public final void rule__HttpClientAce__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1628:1: ( rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4 )
            // InternalAceGen.g:1629:2: rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4
            {
            pushFollow(FOLLOW_9);
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
    // InternalAceGen.g:1636:1: rule__HttpClientAce__Group__3__Impl : ( ( rule__HttpClientAce__Group_3__0 )? ) ;
    public final void rule__HttpClientAce__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1640:1: ( ( ( rule__HttpClientAce__Group_3__0 )? ) )
            // InternalAceGen.g:1641:1: ( ( rule__HttpClientAce__Group_3__0 )? )
            {
            // InternalAceGen.g:1641:1: ( ( rule__HttpClientAce__Group_3__0 )? )
            // InternalAceGen.g:1642:2: ( rule__HttpClientAce__Group_3__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_3()); 
            // InternalAceGen.g:1643:2: ( rule__HttpClientAce__Group_3__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==35) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAceGen.g:1643:3: rule__HttpClientAce__Group_3__0
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
    // InternalAceGen.g:1651:1: rule__HttpClientAce__Group__4 : rule__HttpClientAce__Group__4__Impl rule__HttpClientAce__Group__5 ;
    public final void rule__HttpClientAce__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1655:1: ( rule__HttpClientAce__Group__4__Impl rule__HttpClientAce__Group__5 )
            // InternalAceGen.g:1656:2: rule__HttpClientAce__Group__4__Impl rule__HttpClientAce__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__HttpClientAce__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group__5();

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
    // InternalAceGen.g:1663:1: rule__HttpClientAce__Group__4__Impl : ( ( rule__HttpClientAce__Group_4__0 )? ) ;
    public final void rule__HttpClientAce__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1667:1: ( ( ( rule__HttpClientAce__Group_4__0 )? ) )
            // InternalAceGen.g:1668:1: ( ( rule__HttpClientAce__Group_4__0 )? )
            {
            // InternalAceGen.g:1668:1: ( ( rule__HttpClientAce__Group_4__0 )? )
            // InternalAceGen.g:1669:2: ( rule__HttpClientAce__Group_4__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_4()); 
            // InternalAceGen.g:1670:2: ( rule__HttpClientAce__Group_4__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAceGen.g:1670:3: rule__HttpClientAce__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpClientAce__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpClientAceAccess().getGroup_4()); 

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


    // $ANTLR start "rule__HttpClientAce__Group__5"
    // InternalAceGen.g:1678:1: rule__HttpClientAce__Group__5 : rule__HttpClientAce__Group__5__Impl ;
    public final void rule__HttpClientAce__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1682:1: ( rule__HttpClientAce__Group__5__Impl )
            // InternalAceGen.g:1683:2: rule__HttpClientAce__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group__5__Impl();

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
    // $ANTLR end "rule__HttpClientAce__Group__5"


    // $ANTLR start "rule__HttpClientAce__Group__5__Impl"
    // InternalAceGen.g:1689:1: rule__HttpClientAce__Group__5__Impl : ( ( rule__HttpClientAce__OutcomesAssignment_5 )* ) ;
    public final void rule__HttpClientAce__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1693:1: ( ( ( rule__HttpClientAce__OutcomesAssignment_5 )* ) )
            // InternalAceGen.g:1694:1: ( ( rule__HttpClientAce__OutcomesAssignment_5 )* )
            {
            // InternalAceGen.g:1694:1: ( ( rule__HttpClientAce__OutcomesAssignment_5 )* )
            // InternalAceGen.g:1695:2: ( rule__HttpClientAce__OutcomesAssignment_5 )*
            {
             before(grammarAccess.getHttpClientAceAccess().getOutcomesAssignment_5()); 
            // InternalAceGen.g:1696:2: ( rule__HttpClientAce__OutcomesAssignment_5 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==37) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalAceGen.g:1696:3: rule__HttpClientAce__OutcomesAssignment_5
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__HttpClientAce__OutcomesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getHttpClientAceAccess().getOutcomesAssignment_5()); 

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
    // $ANTLR end "rule__HttpClientAce__Group__5__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_2__0"
    // InternalAceGen.g:1705:1: rule__HttpClientAce__Group_2__0 : rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1 ;
    public final void rule__HttpClientAce__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1709:1: ( rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1 )
            // InternalAceGen.g:1710:2: rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1
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
    // InternalAceGen.g:1717:1: rule__HttpClientAce__Group_2__0__Impl : ( '<' ) ;
    public final void rule__HttpClientAce__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1721:1: ( ( '<' ) )
            // InternalAceGen.g:1722:1: ( '<' )
            {
            // InternalAceGen.g:1722:1: ( '<' )
            // InternalAceGen.g:1723:2: '<'
            {
             before(grammarAccess.getHttpClientAceAccess().getLessThanSignKeyword_2_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getLessThanSignKeyword_2_0()); 

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
    // InternalAceGen.g:1732:1: rule__HttpClientAce__Group_2__1 : rule__HttpClientAce__Group_2__1__Impl rule__HttpClientAce__Group_2__2 ;
    public final void rule__HttpClientAce__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1736:1: ( rule__HttpClientAce__Group_2__1__Impl rule__HttpClientAce__Group_2__2 )
            // InternalAceGen.g:1737:2: rule__HttpClientAce__Group_2__1__Impl rule__HttpClientAce__Group_2__2
            {
            pushFollow(FOLLOW_11);
            rule__HttpClientAce__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_2__2();

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
    // InternalAceGen.g:1744:1: rule__HttpClientAce__Group_2__1__Impl : ( ( rule__HttpClientAce__InputAssignment_2_1 ) ) ;
    public final void rule__HttpClientAce__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1748:1: ( ( ( rule__HttpClientAce__InputAssignment_2_1 ) ) )
            // InternalAceGen.g:1749:1: ( ( rule__HttpClientAce__InputAssignment_2_1 ) )
            {
            // InternalAceGen.g:1749:1: ( ( rule__HttpClientAce__InputAssignment_2_1 ) )
            // InternalAceGen.g:1750:2: ( rule__HttpClientAce__InputAssignment_2_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getInputAssignment_2_1()); 
            // InternalAceGen.g:1751:2: ( rule__HttpClientAce__InputAssignment_2_1 )
            // InternalAceGen.g:1751:3: rule__HttpClientAce__InputAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__InputAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAceAccess().getInputAssignment_2_1()); 

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


    // $ANTLR start "rule__HttpClientAce__Group_2__2"
    // InternalAceGen.g:1759:1: rule__HttpClientAce__Group_2__2 : rule__HttpClientAce__Group_2__2__Impl rule__HttpClientAce__Group_2__3 ;
    public final void rule__HttpClientAce__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1763:1: ( rule__HttpClientAce__Group_2__2__Impl rule__HttpClientAce__Group_2__3 )
            // InternalAceGen.g:1764:2: rule__HttpClientAce__Group_2__2__Impl rule__HttpClientAce__Group_2__3
            {
            pushFollow(FOLLOW_11);
            rule__HttpClientAce__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_2__3();

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
    // $ANTLR end "rule__HttpClientAce__Group_2__2"


    // $ANTLR start "rule__HttpClientAce__Group_2__2__Impl"
    // InternalAceGen.g:1771:1: rule__HttpClientAce__Group_2__2__Impl : ( ( rule__HttpClientAce__Group_2_2__0 )* ) ;
    public final void rule__HttpClientAce__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1775:1: ( ( ( rule__HttpClientAce__Group_2_2__0 )* ) )
            // InternalAceGen.g:1776:1: ( ( rule__HttpClientAce__Group_2_2__0 )* )
            {
            // InternalAceGen.g:1776:1: ( ( rule__HttpClientAce__Group_2_2__0 )* )
            // InternalAceGen.g:1777:2: ( rule__HttpClientAce__Group_2_2__0 )*
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_2_2()); 
            // InternalAceGen.g:1778:2: ( rule__HttpClientAce__Group_2_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==34) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalAceGen.g:1778:3: rule__HttpClientAce__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__HttpClientAce__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getHttpClientAceAccess().getGroup_2_2()); 

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
    // $ANTLR end "rule__HttpClientAce__Group_2__2__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_2__3"
    // InternalAceGen.g:1786:1: rule__HttpClientAce__Group_2__3 : rule__HttpClientAce__Group_2__3__Impl ;
    public final void rule__HttpClientAce__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1790:1: ( rule__HttpClientAce__Group_2__3__Impl )
            // InternalAceGen.g:1791:2: rule__HttpClientAce__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_2__3__Impl();

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
    // $ANTLR end "rule__HttpClientAce__Group_2__3"


    // $ANTLR start "rule__HttpClientAce__Group_2__3__Impl"
    // InternalAceGen.g:1797:1: rule__HttpClientAce__Group_2__3__Impl : ( '>' ) ;
    public final void rule__HttpClientAce__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1801:1: ( ( '>' ) )
            // InternalAceGen.g:1802:1: ( '>' )
            {
            // InternalAceGen.g:1802:1: ( '>' )
            // InternalAceGen.g:1803:2: '>'
            {
             before(grammarAccess.getHttpClientAceAccess().getGreaterThanSignKeyword_2_3()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getGreaterThanSignKeyword_2_3()); 

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
    // $ANTLR end "rule__HttpClientAce__Group_2__3__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_2_2__0"
    // InternalAceGen.g:1813:1: rule__HttpClientAce__Group_2_2__0 : rule__HttpClientAce__Group_2_2__0__Impl rule__HttpClientAce__Group_2_2__1 ;
    public final void rule__HttpClientAce__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1817:1: ( rule__HttpClientAce__Group_2_2__0__Impl rule__HttpClientAce__Group_2_2__1 )
            // InternalAceGen.g:1818:2: rule__HttpClientAce__Group_2_2__0__Impl rule__HttpClientAce__Group_2_2__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpClientAce__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_2_2__1();

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
    // $ANTLR end "rule__HttpClientAce__Group_2_2__0"


    // $ANTLR start "rule__HttpClientAce__Group_2_2__0__Impl"
    // InternalAceGen.g:1825:1: rule__HttpClientAce__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__HttpClientAce__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1829:1: ( ( ',' ) )
            // InternalAceGen.g:1830:1: ( ',' )
            {
            // InternalAceGen.g:1830:1: ( ',' )
            // InternalAceGen.g:1831:2: ','
            {
             before(grammarAccess.getHttpClientAceAccess().getCommaKeyword_2_2_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getCommaKeyword_2_2_0()); 

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
    // $ANTLR end "rule__HttpClientAce__Group_2_2__0__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_2_2__1"
    // InternalAceGen.g:1840:1: rule__HttpClientAce__Group_2_2__1 : rule__HttpClientAce__Group_2_2__1__Impl ;
    public final void rule__HttpClientAce__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1844:1: ( rule__HttpClientAce__Group_2_2__1__Impl )
            // InternalAceGen.g:1845:2: rule__HttpClientAce__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_2_2__1__Impl();

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
    // $ANTLR end "rule__HttpClientAce__Group_2_2__1"


    // $ANTLR start "rule__HttpClientAce__Group_2_2__1__Impl"
    // InternalAceGen.g:1851:1: rule__HttpClientAce__Group_2_2__1__Impl : ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) ) ;
    public final void rule__HttpClientAce__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1855:1: ( ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) ) )
            // InternalAceGen.g:1856:1: ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) )
            {
            // InternalAceGen.g:1856:1: ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) )
            // InternalAceGen.g:1857:2: ( rule__HttpClientAce__InputAssignment_2_2_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getInputAssignment_2_2_1()); 
            // InternalAceGen.g:1858:2: ( rule__HttpClientAce__InputAssignment_2_2_1 )
            // InternalAceGen.g:1858:3: rule__HttpClientAce__InputAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__InputAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAceAccess().getInputAssignment_2_2_1()); 

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
    // $ANTLR end "rule__HttpClientAce__Group_2_2__1__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_3__0"
    // InternalAceGen.g:1867:1: rule__HttpClientAce__Group_3__0 : rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1 ;
    public final void rule__HttpClientAce__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1871:1: ( rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1 )
            // InternalAceGen.g:1872:2: rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1
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
    // InternalAceGen.g:1879:1: rule__HttpClientAce__Group_3__0__Impl : ( 'call' ) ;
    public final void rule__HttpClientAce__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1883:1: ( ( 'call' ) )
            // InternalAceGen.g:1884:1: ( 'call' )
            {
            // InternalAceGen.g:1884:1: ( 'call' )
            // InternalAceGen.g:1885:2: 'call'
            {
             before(grammarAccess.getHttpClientAceAccess().getCallKeyword_3_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getCallKeyword_3_0()); 

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
    // InternalAceGen.g:1894:1: rule__HttpClientAce__Group_3__1 : rule__HttpClientAce__Group_3__1__Impl ;
    public final void rule__HttpClientAce__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1898:1: ( rule__HttpClientAce__Group_3__1__Impl )
            // InternalAceGen.g:1899:2: rule__HttpClientAce__Group_3__1__Impl
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
    // InternalAceGen.g:1905:1: rule__HttpClientAce__Group_3__1__Impl : ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) ) ;
    public final void rule__HttpClientAce__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1909:1: ( ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) ) )
            // InternalAceGen.g:1910:1: ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) )
            {
            // InternalAceGen.g:1910:1: ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) )
            // InternalAceGen.g:1911:2: ( rule__HttpClientAce__ServerCallAssignment_3_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallAssignment_3_1()); 
            // InternalAceGen.g:1912:2: ( rule__HttpClientAce__ServerCallAssignment_3_1 )
            // InternalAceGen.g:1912:3: rule__HttpClientAce__ServerCallAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__ServerCallAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAceAccess().getServerCallAssignment_3_1()); 

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


    // $ANTLR start "rule__HttpClientAce__Group_4__0"
    // InternalAceGen.g:1921:1: rule__HttpClientAce__Group_4__0 : rule__HttpClientAce__Group_4__0__Impl rule__HttpClientAce__Group_4__1 ;
    public final void rule__HttpClientAce__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1925:1: ( rule__HttpClientAce__Group_4__0__Impl rule__HttpClientAce__Group_4__1 )
            // InternalAceGen.g:1926:2: rule__HttpClientAce__Group_4__0__Impl rule__HttpClientAce__Group_4__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpClientAce__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_4__1();

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
    // $ANTLR end "rule__HttpClientAce__Group_4__0"


    // $ANTLR start "rule__HttpClientAce__Group_4__0__Impl"
    // InternalAceGen.g:1933:1: rule__HttpClientAce__Group_4__0__Impl : ( 'loadingFlag' ) ;
    public final void rule__HttpClientAce__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1937:1: ( ( 'loadingFlag' ) )
            // InternalAceGen.g:1938:1: ( 'loadingFlag' )
            {
            // InternalAceGen.g:1938:1: ( 'loadingFlag' )
            // InternalAceGen.g:1939:2: 'loadingFlag'
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagKeyword_4_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getLoadingFlagKeyword_4_0()); 

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
    // $ANTLR end "rule__HttpClientAce__Group_4__0__Impl"


    // $ANTLR start "rule__HttpClientAce__Group_4__1"
    // InternalAceGen.g:1948:1: rule__HttpClientAce__Group_4__1 : rule__HttpClientAce__Group_4__1__Impl ;
    public final void rule__HttpClientAce__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1952:1: ( rule__HttpClientAce__Group_4__1__Impl )
            // InternalAceGen.g:1953:2: rule__HttpClientAce__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__Group_4__1__Impl();

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
    // $ANTLR end "rule__HttpClientAce__Group_4__1"


    // $ANTLR start "rule__HttpClientAce__Group_4__1__Impl"
    // InternalAceGen.g:1959:1: rule__HttpClientAce__Group_4__1__Impl : ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) ) ;
    public final void rule__HttpClientAce__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1963:1: ( ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) ) )
            // InternalAceGen.g:1964:1: ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) )
            {
            // InternalAceGen.g:1964:1: ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) )
            // InternalAceGen.g:1965:2: ( rule__HttpClientAce__LoadingFlagAssignment_4_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagAssignment_4_1()); 
            // InternalAceGen.g:1966:2: ( rule__HttpClientAce__LoadingFlagAssignment_4_1 )
            // InternalAceGen.g:1966:3: rule__HttpClientAce__LoadingFlagAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpClientAce__LoadingFlagAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpClientAceAccess().getLoadingFlagAssignment_4_1()); 

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
    // $ANTLR end "rule__HttpClientAce__Group_4__1__Impl"


    // $ANTLR start "rule__HttpClientOutcome__Group__0"
    // InternalAceGen.g:1975:1: rule__HttpClientOutcome__Group__0 : rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1 ;
    public final void rule__HttpClientOutcome__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1979:1: ( rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1 )
            // InternalAceGen.g:1980:2: rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1
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
    // InternalAceGen.g:1987:1: rule__HttpClientOutcome__Group__0__Impl : ( 'on' ) ;
    public final void rule__HttpClientOutcome__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1991:1: ( ( 'on' ) )
            // InternalAceGen.g:1992:1: ( 'on' )
            {
            // InternalAceGen.g:1992:1: ( 'on' )
            // InternalAceGen.g:1993:2: 'on'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getOnKeyword_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalAceGen.g:2002:1: rule__HttpClientOutcome__Group__1 : rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2 ;
    public final void rule__HttpClientOutcome__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2006:1: ( rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2 )
            // InternalAceGen.g:2007:2: rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2
            {
            pushFollow(FOLLOW_13);
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
    // InternalAceGen.g:2014:1: rule__HttpClientOutcome__Group__1__Impl : ( ( rule__HttpClientOutcome__NameAssignment_1 ) ) ;
    public final void rule__HttpClientOutcome__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2018:1: ( ( ( rule__HttpClientOutcome__NameAssignment_1 ) ) )
            // InternalAceGen.g:2019:1: ( ( rule__HttpClientOutcome__NameAssignment_1 ) )
            {
            // InternalAceGen.g:2019:1: ( ( rule__HttpClientOutcome__NameAssignment_1 ) )
            // InternalAceGen.g:2020:2: ( rule__HttpClientOutcome__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getNameAssignment_1()); 
            // InternalAceGen.g:2021:2: ( rule__HttpClientOutcome__NameAssignment_1 )
            // InternalAceGen.g:2021:3: rule__HttpClientOutcome__NameAssignment_1
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
    // InternalAceGen.g:2029:1: rule__HttpClientOutcome__Group__2 : rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3 ;
    public final void rule__HttpClientOutcome__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2033:1: ( rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3 )
            // InternalAceGen.g:2034:2: rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3
            {
            pushFollow(FOLLOW_13);
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
    // InternalAceGen.g:2041:1: rule__HttpClientOutcome__Group__2__Impl : ( ( rule__HttpClientOutcome__Group_2__0 )? ) ;
    public final void rule__HttpClientOutcome__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2045:1: ( ( ( rule__HttpClientOutcome__Group_2__0 )? ) )
            // InternalAceGen.g:2046:1: ( ( rule__HttpClientOutcome__Group_2__0 )? )
            {
            // InternalAceGen.g:2046:1: ( ( rule__HttpClientOutcome__Group_2__0 )? )
            // InternalAceGen.g:2047:2: ( rule__HttpClientOutcome__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getGroup_2()); 
            // InternalAceGen.g:2048:2: ( rule__HttpClientOutcome__Group_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalAceGen.g:2048:3: rule__HttpClientOutcome__Group_2__0
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
    // InternalAceGen.g:2056:1: rule__HttpClientOutcome__Group__3 : rule__HttpClientOutcome__Group__3__Impl ;
    public final void rule__HttpClientOutcome__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2060:1: ( rule__HttpClientOutcome__Group__3__Impl )
            // InternalAceGen.g:2061:2: rule__HttpClientOutcome__Group__3__Impl
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
    // InternalAceGen.g:2067:1: rule__HttpClientOutcome__Group__3__Impl : ( ( rule__HttpClientOutcome__Group_3__0 )? ) ;
    public final void rule__HttpClientOutcome__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2071:1: ( ( ( rule__HttpClientOutcome__Group_3__0 )? ) )
            // InternalAceGen.g:2072:1: ( ( rule__HttpClientOutcome__Group_3__0 )? )
            {
            // InternalAceGen.g:2072:1: ( ( rule__HttpClientOutcome__Group_3__0 )? )
            // InternalAceGen.g:2073:2: ( rule__HttpClientOutcome__Group_3__0 )?
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getGroup_3()); 
            // InternalAceGen.g:2074:2: ( rule__HttpClientOutcome__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==40) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalAceGen.g:2074:3: rule__HttpClientOutcome__Group_3__0
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
    // InternalAceGen.g:2083:1: rule__HttpClientOutcome__Group_2__0 : rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1 ;
    public final void rule__HttpClientOutcome__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2087:1: ( rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1 )
            // InternalAceGen.g:2088:2: rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalAceGen.g:2095:1: rule__HttpClientOutcome__Group_2__0__Impl : ( '(' ) ;
    public final void rule__HttpClientOutcome__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2099:1: ( ( '(' ) )
            // InternalAceGen.g:2100:1: ( '(' )
            {
            // InternalAceGen.g:2100:1: ( '(' )
            // InternalAceGen.g:2101:2: '('
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,38,FOLLOW_2); 
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
    // InternalAceGen.g:2110:1: rule__HttpClientOutcome__Group_2__1 : rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2 ;
    public final void rule__HttpClientOutcome__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2114:1: ( rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2 )
            // InternalAceGen.g:2115:2: rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2
            {
            pushFollow(FOLLOW_14);
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
    // InternalAceGen.g:2122:1: rule__HttpClientOutcome__Group_2__1__Impl : ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* ) ;
    public final void rule__HttpClientOutcome__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2126:1: ( ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* ) )
            // InternalAceGen.g:2127:1: ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* )
            {
            // InternalAceGen.g:2127:1: ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* )
            // InternalAceGen.g:2128:2: ( rule__HttpClientOutcome__ListenersAssignment_2_1 )*
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getListenersAssignment_2_1()); 
            // InternalAceGen.g:2129:2: ( rule__HttpClientOutcome__ListenersAssignment_2_1 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=13 && LA23_0<=16)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalAceGen.g:2129:3: rule__HttpClientOutcome__ListenersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__HttpClientOutcome__ListenersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalAceGen.g:2137:1: rule__HttpClientOutcome__Group_2__2 : rule__HttpClientOutcome__Group_2__2__Impl ;
    public final void rule__HttpClientOutcome__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2141:1: ( rule__HttpClientOutcome__Group_2__2__Impl )
            // InternalAceGen.g:2142:2: rule__HttpClientOutcome__Group_2__2__Impl
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
    // InternalAceGen.g:2148:1: rule__HttpClientOutcome__Group_2__2__Impl : ( ')' ) ;
    public final void rule__HttpClientOutcome__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2152:1: ( ( ')' ) )
            // InternalAceGen.g:2153:1: ( ')' )
            {
            // InternalAceGen.g:2153:1: ( ')' )
            // InternalAceGen.g:2154:2: ')'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_2_2()); 
            match(input,39,FOLLOW_2); 
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
    // InternalAceGen.g:2164:1: rule__HttpClientOutcome__Group_3__0 : rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1 ;
    public final void rule__HttpClientOutcome__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2168:1: ( rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1 )
            // InternalAceGen.g:2169:2: rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalAceGen.g:2176:1: rule__HttpClientOutcome__Group_3__0__Impl : ( 'triggers' ) ;
    public final void rule__HttpClientOutcome__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2180:1: ( ( 'triggers' ) )
            // InternalAceGen.g:2181:1: ( 'triggers' )
            {
            // InternalAceGen.g:2181:1: ( 'triggers' )
            // InternalAceGen.g:2182:2: 'triggers'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getTriggersKeyword_3_0()); 
            match(input,40,FOLLOW_2); 
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
    // InternalAceGen.g:2191:1: rule__HttpClientOutcome__Group_3__1 : rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2 ;
    public final void rule__HttpClientOutcome__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2195:1: ( rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2 )
            // InternalAceGen.g:2196:2: rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:2203:1: rule__HttpClientOutcome__Group_3__1__Impl : ( '(' ) ;
    public final void rule__HttpClientOutcome__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2207:1: ( ( '(' ) )
            // InternalAceGen.g:2208:1: ( '(' )
            {
            // InternalAceGen.g:2208:1: ( '(' )
            // InternalAceGen.g:2209:2: '('
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,38,FOLLOW_2); 
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
    // InternalAceGen.g:2218:1: rule__HttpClientOutcome__Group_3__2 : rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3 ;
    public final void rule__HttpClientOutcome__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2222:1: ( rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3 )
            // InternalAceGen.g:2223:2: rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3
            {
            pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:2230:1: rule__HttpClientOutcome__Group_3__2__Impl : ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* ) ;
    public final void rule__HttpClientOutcome__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2234:1: ( ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* ) )
            // InternalAceGen.g:2235:1: ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* )
            {
            // InternalAceGen.g:2235:1: ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* )
            // InternalAceGen.g:2236:2: ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )*
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsAssignment_3_2()); 
            // InternalAceGen.g:2237:2: ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalAceGen.g:2237:3: rule__HttpClientOutcome__AceOperationsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpClientOutcome__AceOperationsAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalAceGen.g:2245:1: rule__HttpClientOutcome__Group_3__3 : rule__HttpClientOutcome__Group_3__3__Impl ;
    public final void rule__HttpClientOutcome__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2249:1: ( rule__HttpClientOutcome__Group_3__3__Impl )
            // InternalAceGen.g:2250:2: rule__HttpClientOutcome__Group_3__3__Impl
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
    // InternalAceGen.g:2256:1: rule__HttpClientOutcome__Group_3__3__Impl : ( ')' ) ;
    public final void rule__HttpClientOutcome__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2260:1: ( ( ')' ) )
            // InternalAceGen.g:2261:1: ( ')' )
            {
            // InternalAceGen.g:2261:1: ( ')' )
            // InternalAceGen.g:2262:2: ')'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_3_3()); 
            match(input,39,FOLLOW_2); 
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
    // InternalAceGen.g:2272:1: rule__HttpClientStateFunction__Group__0 : rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1 ;
    public final void rule__HttpClientStateFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2276:1: ( rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1 )
            // InternalAceGen.g:2277:2: rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1
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
    // InternalAceGen.g:2284:1: rule__HttpClientStateFunction__Group__0__Impl : ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) ) ;
    public final void rule__HttpClientStateFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2288:1: ( ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) ) )
            // InternalAceGen.g:2289:1: ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) )
            {
            // InternalAceGen.g:2289:1: ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) )
            // InternalAceGen.g:2290:2: ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeAssignment_0()); 
            // InternalAceGen.g:2291:2: ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 )
            // InternalAceGen.g:2291:3: rule__HttpClientStateFunction__StateFunctionTypeAssignment_0
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
    // InternalAceGen.g:2299:1: rule__HttpClientStateFunction__Group__1 : rule__HttpClientStateFunction__Group__1__Impl ;
    public final void rule__HttpClientStateFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2303:1: ( rule__HttpClientStateFunction__Group__1__Impl )
            // InternalAceGen.g:2304:2: rule__HttpClientStateFunction__Group__1__Impl
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
    // InternalAceGen.g:2310:1: rule__HttpClientStateFunction__Group__1__Impl : ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) ) ;
    public final void rule__HttpClientStateFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2314:1: ( ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) ) )
            // InternalAceGen.g:2315:1: ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) )
            {
            // InternalAceGen.g:2315:1: ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) )
            // InternalAceGen.g:2316:2: ( rule__HttpClientStateFunction__AttributeAssignment_1 )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getAttributeAssignment_1()); 
            // InternalAceGen.g:2317:2: ( rule__HttpClientStateFunction__AttributeAssignment_1 )
            // InternalAceGen.g:2317:3: rule__HttpClientStateFunction__AttributeAssignment_1
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
    // InternalAceGen.g:2326:1: rule__HttpClientStateElement__Group__0 : rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1 ;
    public final void rule__HttpClientStateElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2330:1: ( rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1 )
            // InternalAceGen.g:2331:2: rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalAceGen.g:2338:1: rule__HttpClientStateElement__Group__0__Impl : ( ( rule__HttpClientStateElement__NameAssignment_0 ) ) ;
    public final void rule__HttpClientStateElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2342:1: ( ( ( rule__HttpClientStateElement__NameAssignment_0 ) ) )
            // InternalAceGen.g:2343:1: ( ( rule__HttpClientStateElement__NameAssignment_0 ) )
            {
            // InternalAceGen.g:2343:1: ( ( rule__HttpClientStateElement__NameAssignment_0 ) )
            // InternalAceGen.g:2344:2: ( rule__HttpClientStateElement__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getNameAssignment_0()); 
            // InternalAceGen.g:2345:2: ( rule__HttpClientStateElement__NameAssignment_0 )
            // InternalAceGen.g:2345:3: rule__HttpClientStateElement__NameAssignment_0
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
    // InternalAceGen.g:2353:1: rule__HttpClientStateElement__Group__1 : rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2 ;
    public final void rule__HttpClientStateElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2357:1: ( rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2 )
            // InternalAceGen.g:2358:2: rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2
            {
            pushFollow(FOLLOW_19);
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
    // InternalAceGen.g:2365:1: rule__HttpClientStateElement__Group__1__Impl : ( ( rule__HttpClientStateElement__ListAssignment_1 )? ) ;
    public final void rule__HttpClientStateElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2369:1: ( ( ( rule__HttpClientStateElement__ListAssignment_1 )? ) )
            // InternalAceGen.g:2370:1: ( ( rule__HttpClientStateElement__ListAssignment_1 )? )
            {
            // InternalAceGen.g:2370:1: ( ( rule__HttpClientStateElement__ListAssignment_1 )? )
            // InternalAceGen.g:2371:2: ( rule__HttpClientStateElement__ListAssignment_1 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListAssignment_1()); 
            // InternalAceGen.g:2372:2: ( rule__HttpClientStateElement__ListAssignment_1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==67) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalAceGen.g:2372:3: rule__HttpClientStateElement__ListAssignment_1
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
    // InternalAceGen.g:2380:1: rule__HttpClientStateElement__Group__2 : rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3 ;
    public final void rule__HttpClientStateElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2384:1: ( rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3 )
            // InternalAceGen.g:2385:2: rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3
            {
            pushFollow(FOLLOW_19);
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
    // InternalAceGen.g:2392:1: rule__HttpClientStateElement__Group__2__Impl : ( ( rule__HttpClientStateElement__HashAssignment_2 )? ) ;
    public final void rule__HttpClientStateElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2396:1: ( ( ( rule__HttpClientStateElement__HashAssignment_2 )? ) )
            // InternalAceGen.g:2397:1: ( ( rule__HttpClientStateElement__HashAssignment_2 )? )
            {
            // InternalAceGen.g:2397:1: ( ( rule__HttpClientStateElement__HashAssignment_2 )? )
            // InternalAceGen.g:2398:2: ( rule__HttpClientStateElement__HashAssignment_2 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashAssignment_2()); 
            // InternalAceGen.g:2399:2: ( rule__HttpClientStateElement__HashAssignment_2 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==68) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalAceGen.g:2399:3: rule__HttpClientStateElement__HashAssignment_2
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
    // InternalAceGen.g:2407:1: rule__HttpClientStateElement__Group__3 : rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4 ;
    public final void rule__HttpClientStateElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2411:1: ( rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4 )
            // InternalAceGen.g:2412:2: rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4
            {
            pushFollow(FOLLOW_19);
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
    // InternalAceGen.g:2419:1: rule__HttpClientStateElement__Group__3__Impl : ( ( rule__HttpClientStateElement__StorageAssignment_3 )? ) ;
    public final void rule__HttpClientStateElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2423:1: ( ( ( rule__HttpClientStateElement__StorageAssignment_3 )? ) )
            // InternalAceGen.g:2424:1: ( ( rule__HttpClientStateElement__StorageAssignment_3 )? )
            {
            // InternalAceGen.g:2424:1: ( ( rule__HttpClientStateElement__StorageAssignment_3 )? )
            // InternalAceGen.g:2425:2: ( rule__HttpClientStateElement__StorageAssignment_3 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageAssignment_3()); 
            // InternalAceGen.g:2426:2: ( rule__HttpClientStateElement__StorageAssignment_3 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==69) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalAceGen.g:2426:3: rule__HttpClientStateElement__StorageAssignment_3
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
    // InternalAceGen.g:2434:1: rule__HttpClientStateElement__Group__4 : rule__HttpClientStateElement__Group__4__Impl ;
    public final void rule__HttpClientStateElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2438:1: ( rule__HttpClientStateElement__Group__4__Impl )
            // InternalAceGen.g:2439:2: rule__HttpClientStateElement__Group__4__Impl
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
    // InternalAceGen.g:2445:1: rule__HttpClientStateElement__Group__4__Impl : ( ( rule__HttpClientStateElement__Group_4__0 )? ) ;
    public final void rule__HttpClientStateElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2449:1: ( ( ( rule__HttpClientStateElement__Group_4__0 )? ) )
            // InternalAceGen.g:2450:1: ( ( rule__HttpClientStateElement__Group_4__0 )? )
            {
            // InternalAceGen.g:2450:1: ( ( rule__HttpClientStateElement__Group_4__0 )? )
            // InternalAceGen.g:2451:2: ( rule__HttpClientStateElement__Group_4__0 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getGroup_4()); 
            // InternalAceGen.g:2452:2: ( rule__HttpClientStateElement__Group_4__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==42) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAceGen.g:2452:3: rule__HttpClientStateElement__Group_4__0
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
    // InternalAceGen.g:2461:1: rule__HttpClientStateElement__Group_4__0 : rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1 ;
    public final void rule__HttpClientStateElement__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2465:1: ( rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1 )
            // InternalAceGen.g:2466:2: rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalAceGen.g:2473:1: rule__HttpClientStateElement__Group_4__0__Impl : ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) ) ;
    public final void rule__HttpClientStateElement__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2477:1: ( ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) ) )
            // InternalAceGen.g:2478:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) )
            {
            // InternalAceGen.g:2478:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) )
            // InternalAceGen.g:2479:2: ( rule__HttpClientStateElement__TypesAssignment_4_0 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_0()); 
            // InternalAceGen.g:2480:2: ( rule__HttpClientStateElement__TypesAssignment_4_0 )
            // InternalAceGen.g:2480:3: rule__HttpClientStateElement__TypesAssignment_4_0
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
    // InternalAceGen.g:2488:1: rule__HttpClientStateElement__Group_4__1 : rule__HttpClientStateElement__Group_4__1__Impl ;
    public final void rule__HttpClientStateElement__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2492:1: ( rule__HttpClientStateElement__Group_4__1__Impl )
            // InternalAceGen.g:2493:2: rule__HttpClientStateElement__Group_4__1__Impl
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
    // InternalAceGen.g:2499:1: rule__HttpClientStateElement__Group_4__1__Impl : ( ( rule__HttpClientStateElement__Group_4_1__0 )* ) ;
    public final void rule__HttpClientStateElement__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2503:1: ( ( ( rule__HttpClientStateElement__Group_4_1__0 )* ) )
            // InternalAceGen.g:2504:1: ( ( rule__HttpClientStateElement__Group_4_1__0 )* )
            {
            // InternalAceGen.g:2504:1: ( ( rule__HttpClientStateElement__Group_4_1__0 )* )
            // InternalAceGen.g:2505:2: ( rule__HttpClientStateElement__Group_4_1__0 )*
            {
             before(grammarAccess.getHttpClientStateElementAccess().getGroup_4_1()); 
            // InternalAceGen.g:2506:2: ( rule__HttpClientStateElement__Group_4_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==41) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalAceGen.g:2506:3: rule__HttpClientStateElement__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__HttpClientStateElement__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalAceGen.g:2515:1: rule__HttpClientStateElement__Group_4_1__0 : rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1 ;
    public final void rule__HttpClientStateElement__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2519:1: ( rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1 )
            // InternalAceGen.g:2520:2: rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalAceGen.g:2527:1: rule__HttpClientStateElement__Group_4_1__0__Impl : ( '|' ) ;
    public final void rule__HttpClientStateElement__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2531:1: ( ( '|' ) )
            // InternalAceGen.g:2532:1: ( '|' )
            {
            // InternalAceGen.g:2532:1: ( '|' )
            // InternalAceGen.g:2533:2: '|'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getVerticalLineKeyword_4_1_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalAceGen.g:2542:1: rule__HttpClientStateElement__Group_4_1__1 : rule__HttpClientStateElement__Group_4_1__1__Impl ;
    public final void rule__HttpClientStateElement__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2546:1: ( rule__HttpClientStateElement__Group_4_1__1__Impl )
            // InternalAceGen.g:2547:2: rule__HttpClientStateElement__Group_4_1__1__Impl
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
    // InternalAceGen.g:2553:1: rule__HttpClientStateElement__Group_4_1__1__Impl : ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) ) ;
    public final void rule__HttpClientStateElement__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2557:1: ( ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) ) )
            // InternalAceGen.g:2558:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) )
            {
            // InternalAceGen.g:2558:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) )
            // InternalAceGen.g:2559:2: ( rule__HttpClientStateElement__TypesAssignment_4_1_1 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_1_1()); 
            // InternalAceGen.g:2560:2: ( rule__HttpClientStateElement__TypesAssignment_4_1_1 )
            // InternalAceGen.g:2560:3: rule__HttpClientStateElement__TypesAssignment_4_1_1
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
    // InternalAceGen.g:2569:1: rule__HttpClientTypeDefinition__Group__0 : rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1 ;
    public final void rule__HttpClientTypeDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2573:1: ( rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1 )
            // InternalAceGen.g:2574:2: rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1
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
    // InternalAceGen.g:2581:1: rule__HttpClientTypeDefinition__Group__0__Impl : ( ':' ) ;
    public final void rule__HttpClientTypeDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2585:1: ( ( ':' ) )
            // InternalAceGen.g:2586:1: ( ':' )
            {
            // InternalAceGen.g:2586:1: ( ':' )
            // InternalAceGen.g:2587:2: ':'
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getColonKeyword_0()); 
            match(input,42,FOLLOW_2); 
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
    // InternalAceGen.g:2596:1: rule__HttpClientTypeDefinition__Group__1 : rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2 ;
    public final void rule__HttpClientTypeDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2600:1: ( rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2 )
            // InternalAceGen.g:2601:2: rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2
            {
            pushFollow(FOLLOW_23);
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
    // InternalAceGen.g:2608:1: rule__HttpClientTypeDefinition__Group__1__Impl : ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) ) ;
    public final void rule__HttpClientTypeDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2612:1: ( ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) ) )
            // InternalAceGen.g:2613:1: ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) )
            {
            // InternalAceGen.g:2613:1: ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) )
            // InternalAceGen.g:2614:2: ( rule__HttpClientTypeDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getNameAssignment_1()); 
            // InternalAceGen.g:2615:2: ( rule__HttpClientTypeDefinition__NameAssignment_1 )
            // InternalAceGen.g:2615:3: rule__HttpClientTypeDefinition__NameAssignment_1
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
    // InternalAceGen.g:2623:1: rule__HttpClientTypeDefinition__Group__2 : rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3 ;
    public final void rule__HttpClientTypeDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2627:1: ( rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3 )
            // InternalAceGen.g:2628:2: rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3
            {
            pushFollow(FOLLOW_24);
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
    // InternalAceGen.g:2635:1: rule__HttpClientTypeDefinition__Group__2__Impl : ( '{' ) ;
    public final void rule__HttpClientTypeDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2639:1: ( ( '{' ) )
            // InternalAceGen.g:2640:1: ( '{' )
            {
            // InternalAceGen.g:2640:1: ( '{' )
            // InternalAceGen.g:2641:2: '{'
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,43,FOLLOW_2); 
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
    // InternalAceGen.g:2650:1: rule__HttpClientTypeDefinition__Group__3 : rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4 ;
    public final void rule__HttpClientTypeDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2654:1: ( rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4 )
            // InternalAceGen.g:2655:2: rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4
            {
            pushFollow(FOLLOW_24);
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
    // InternalAceGen.g:2662:1: rule__HttpClientTypeDefinition__Group__3__Impl : ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* ) ;
    public final void rule__HttpClientTypeDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2666:1: ( ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* ) )
            // InternalAceGen.g:2667:1: ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* )
            {
            // InternalAceGen.g:2667:1: ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* )
            // InternalAceGen.g:2668:2: ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )*
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getElementsAssignment_3()); 
            // InternalAceGen.g:2669:2: ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalAceGen.g:2669:3: rule__HttpClientTypeDefinition__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpClientTypeDefinition__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalAceGen.g:2677:1: rule__HttpClientTypeDefinition__Group__4 : rule__HttpClientTypeDefinition__Group__4__Impl ;
    public final void rule__HttpClientTypeDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2681:1: ( rule__HttpClientTypeDefinition__Group__4__Impl )
            // InternalAceGen.g:2682:2: rule__HttpClientTypeDefinition__Group__4__Impl
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
    // InternalAceGen.g:2688:1: rule__HttpClientTypeDefinition__Group__4__Impl : ( '}' ) ;
    public final void rule__HttpClientTypeDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2692:1: ( ( '}' ) )
            // InternalAceGen.g:2693:1: ( '}' )
            {
            // InternalAceGen.g:2693:1: ( '}' )
            // InternalAceGen.g:2694:2: '}'
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,44,FOLLOW_2); 
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
    // InternalAceGen.g:2704:1: rule__HttpServer__Group__0 : rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1 ;
    public final void rule__HttpServer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2708:1: ( rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1 )
            // InternalAceGen.g:2709:2: rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalAceGen.g:2716:1: rule__HttpServer__Group__0__Impl : ( ( rule__HttpServer__TypeAssignment_0 )? ) ;
    public final void rule__HttpServer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2720:1: ( ( ( rule__HttpServer__TypeAssignment_0 )? ) )
            // InternalAceGen.g:2721:1: ( ( rule__HttpServer__TypeAssignment_0 )? )
            {
            // InternalAceGen.g:2721:1: ( ( rule__HttpServer__TypeAssignment_0 )? )
            // InternalAceGen.g:2722:2: ( rule__HttpServer__TypeAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAccess().getTypeAssignment_0()); 
            // InternalAceGen.g:2723:2: ( rule__HttpServer__TypeAssignment_0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==70) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalAceGen.g:2723:3: rule__HttpServer__TypeAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServer__TypeAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAccess().getTypeAssignment_0()); 

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
    // InternalAceGen.g:2731:1: rule__HttpServer__Group__1 : rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2 ;
    public final void rule__HttpServer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2735:1: ( rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2 )
            // InternalAceGen.g:2736:2: rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2
            {
            pushFollow(FOLLOW_25);
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
    // InternalAceGen.g:2743:1: rule__HttpServer__Group__1__Impl : ( ( rule__HttpServer__NameAssignment_1 ) ) ;
    public final void rule__HttpServer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2747:1: ( ( ( rule__HttpServer__NameAssignment_1 ) ) )
            // InternalAceGen.g:2748:1: ( ( rule__HttpServer__NameAssignment_1 ) )
            {
            // InternalAceGen.g:2748:1: ( ( rule__HttpServer__NameAssignment_1 ) )
            // InternalAceGen.g:2749:2: ( rule__HttpServer__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAccess().getNameAssignment_1()); 
            // InternalAceGen.g:2750:2: ( rule__HttpServer__NameAssignment_1 )
            // InternalAceGen.g:2750:3: rule__HttpServer__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAccess().getNameAssignment_1()); 

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
    // InternalAceGen.g:2758:1: rule__HttpServer__Group__2 : rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3 ;
    public final void rule__HttpServer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2762:1: ( rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3 )
            // InternalAceGen.g:2763:2: rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3
            {
            pushFollow(FOLLOW_25);
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
    // InternalAceGen.g:2770:1: rule__HttpServer__Group__2__Impl : ( ( rule__HttpServer__Group_2__0 )? ) ;
    public final void rule__HttpServer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2774:1: ( ( ( rule__HttpServer__Group_2__0 )? ) )
            // InternalAceGen.g:2775:1: ( ( rule__HttpServer__Group_2__0 )? )
            {
            // InternalAceGen.g:2775:1: ( ( rule__HttpServer__Group_2__0 )? )
            // InternalAceGen.g:2776:2: ( rule__HttpServer__Group_2__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_2()); 
            // InternalAceGen.g:2777:2: ( rule__HttpServer__Group_2__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==45) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAceGen.g:2777:3: rule__HttpServer__Group_2__0
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
    // InternalAceGen.g:2785:1: rule__HttpServer__Group__3 : rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4 ;
    public final void rule__HttpServer__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2789:1: ( rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4 )
            // InternalAceGen.g:2790:2: rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4
            {
            pushFollow(FOLLOW_25);
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
    // InternalAceGen.g:2797:1: rule__HttpServer__Group__3__Impl : ( ( rule__HttpServer__Group_3__0 )? ) ;
    public final void rule__HttpServer__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2801:1: ( ( ( rule__HttpServer__Group_3__0 )? ) )
            // InternalAceGen.g:2802:1: ( ( rule__HttpServer__Group_3__0 )? )
            {
            // InternalAceGen.g:2802:1: ( ( rule__HttpServer__Group_3__0 )? )
            // InternalAceGen.g:2803:2: ( rule__HttpServer__Group_3__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_3()); 
            // InternalAceGen.g:2804:2: ( rule__HttpServer__Group_3__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==46) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalAceGen.g:2804:3: rule__HttpServer__Group_3__0
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
    // InternalAceGen.g:2812:1: rule__HttpServer__Group__4 : rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5 ;
    public final void rule__HttpServer__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2816:1: ( rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5 )
            // InternalAceGen.g:2817:2: rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5
            {
            pushFollow(FOLLOW_25);
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
    // InternalAceGen.g:2824:1: rule__HttpServer__Group__4__Impl : ( ( rule__HttpServer__Group_4__0 )? ) ;
    public final void rule__HttpServer__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2828:1: ( ( ( rule__HttpServer__Group_4__0 )? ) )
            // InternalAceGen.g:2829:1: ( ( rule__HttpServer__Group_4__0 )? )
            {
            // InternalAceGen.g:2829:1: ( ( rule__HttpServer__Group_4__0 )? )
            // InternalAceGen.g:2830:2: ( rule__HttpServer__Group_4__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_4()); 
            // InternalAceGen.g:2831:2: ( rule__HttpServer__Group_4__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==30) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAceGen.g:2831:3: rule__HttpServer__Group_4__0
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
    // InternalAceGen.g:2839:1: rule__HttpServer__Group__5 : rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6 ;
    public final void rule__HttpServer__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2843:1: ( rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6 )
            // InternalAceGen.g:2844:2: rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6
            {
            pushFollow(FOLLOW_25);
            rule__HttpServer__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group__6();

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
    // InternalAceGen.g:2851:1: rule__HttpServer__Group__5__Impl : ( ( rule__HttpServer__Group_5__0 )? ) ;
    public final void rule__HttpServer__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2855:1: ( ( ( rule__HttpServer__Group_5__0 )? ) )
            // InternalAceGen.g:2856:1: ( ( rule__HttpServer__Group_5__0 )? )
            {
            // InternalAceGen.g:2856:1: ( ( rule__HttpServer__Group_5__0 )? )
            // InternalAceGen.g:2857:2: ( rule__HttpServer__Group_5__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_5()); 
            // InternalAceGen.g:2858:2: ( rule__HttpServer__Group_5__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==47) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalAceGen.g:2858:3: rule__HttpServer__Group_5__0
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


    // $ANTLR start "rule__HttpServer__Group__6"
    // InternalAceGen.g:2866:1: rule__HttpServer__Group__6 : rule__HttpServer__Group__6__Impl rule__HttpServer__Group__7 ;
    public final void rule__HttpServer__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2870:1: ( rule__HttpServer__Group__6__Impl rule__HttpServer__Group__7 )
            // InternalAceGen.g:2871:2: rule__HttpServer__Group__6__Impl rule__HttpServer__Group__7
            {
            pushFollow(FOLLOW_25);
            rule__HttpServer__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group__7();

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
    // $ANTLR end "rule__HttpServer__Group__6"


    // $ANTLR start "rule__HttpServer__Group__6__Impl"
    // InternalAceGen.g:2878:1: rule__HttpServer__Group__6__Impl : ( ( rule__HttpServer__Group_6__0 )? ) ;
    public final void rule__HttpServer__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2882:1: ( ( ( rule__HttpServer__Group_6__0 )? ) )
            // InternalAceGen.g:2883:1: ( ( rule__HttpServer__Group_6__0 )? )
            {
            // InternalAceGen.g:2883:1: ( ( rule__HttpServer__Group_6__0 )? )
            // InternalAceGen.g:2884:2: ( rule__HttpServer__Group_6__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_6()); 
            // InternalAceGen.g:2885:2: ( rule__HttpServer__Group_6__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==48) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalAceGen.g:2885:3: rule__HttpServer__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServer__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAccess().getGroup_6()); 

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
    // $ANTLR end "rule__HttpServer__Group__6__Impl"


    // $ANTLR start "rule__HttpServer__Group__7"
    // InternalAceGen.g:2893:1: rule__HttpServer__Group__7 : rule__HttpServer__Group__7__Impl ;
    public final void rule__HttpServer__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2897:1: ( rule__HttpServer__Group__7__Impl )
            // InternalAceGen.g:2898:2: rule__HttpServer__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__Group__7__Impl();

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
    // $ANTLR end "rule__HttpServer__Group__7"


    // $ANTLR start "rule__HttpServer__Group__7__Impl"
    // InternalAceGen.g:2904:1: rule__HttpServer__Group__7__Impl : ( ( rule__HttpServer__Group_7__0 )? ) ;
    public final void rule__HttpServer__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2908:1: ( ( ( rule__HttpServer__Group_7__0 )? ) )
            // InternalAceGen.g:2909:1: ( ( rule__HttpServer__Group_7__0 )? )
            {
            // InternalAceGen.g:2909:1: ( ( rule__HttpServer__Group_7__0 )? )
            // InternalAceGen.g:2910:2: ( rule__HttpServer__Group_7__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_7()); 
            // InternalAceGen.g:2911:2: ( rule__HttpServer__Group_7__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==49) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalAceGen.g:2911:3: rule__HttpServer__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HttpServer__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHttpServerAccess().getGroup_7()); 

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
    // $ANTLR end "rule__HttpServer__Group__7__Impl"


    // $ANTLR start "rule__HttpServer__Group_2__0"
    // InternalAceGen.g:2920:1: rule__HttpServer__Group_2__0 : rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1 ;
    public final void rule__HttpServer__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2924:1: ( rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1 )
            // InternalAceGen.g:2925:2: rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1
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
    // InternalAceGen.g:2932:1: rule__HttpServer__Group_2__0__Impl : ( 'Authorization' ) ;
    public final void rule__HttpServer__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2936:1: ( ( 'Authorization' ) )
            // InternalAceGen.g:2937:1: ( 'Authorization' )
            {
            // InternalAceGen.g:2937:1: ( 'Authorization' )
            // InternalAceGen.g:2938:2: 'Authorization'
            {
             before(grammarAccess.getHttpServerAccess().getAuthorizationKeyword_2_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getAuthorizationKeyword_2_0()); 

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
    // InternalAceGen.g:2947:1: rule__HttpServer__Group_2__1 : rule__HttpServer__Group_2__1__Impl ;
    public final void rule__HttpServer__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2951:1: ( rule__HttpServer__Group_2__1__Impl )
            // InternalAceGen.g:2952:2: rule__HttpServer__Group_2__1__Impl
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
    // InternalAceGen.g:2958:1: rule__HttpServer__Group_2__1__Impl : ( ( rule__HttpServer__AuthUserAssignment_2_1 ) ) ;
    public final void rule__HttpServer__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2962:1: ( ( ( rule__HttpServer__AuthUserAssignment_2_1 ) ) )
            // InternalAceGen.g:2963:1: ( ( rule__HttpServer__AuthUserAssignment_2_1 ) )
            {
            // InternalAceGen.g:2963:1: ( ( rule__HttpServer__AuthUserAssignment_2_1 ) )
            // InternalAceGen.g:2964:2: ( rule__HttpServer__AuthUserAssignment_2_1 )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserAssignment_2_1()); 
            // InternalAceGen.g:2965:2: ( rule__HttpServer__AuthUserAssignment_2_1 )
            // InternalAceGen.g:2965:3: rule__HttpServer__AuthUserAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__AuthUserAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAccess().getAuthUserAssignment_2_1()); 

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
    // InternalAceGen.g:2974:1: rule__HttpServer__Group_3__0 : rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1 ;
    public final void rule__HttpServer__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2978:1: ( rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1 )
            // InternalAceGen.g:2979:2: rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalAceGen.g:2986:1: rule__HttpServer__Group_3__0__Impl : ( 'import' ) ;
    public final void rule__HttpServer__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2990:1: ( ( 'import' ) )
            // InternalAceGen.g:2991:1: ( 'import' )
            {
            // InternalAceGen.g:2991:1: ( 'import' )
            // InternalAceGen.g:2992:2: 'import'
            {
             before(grammarAccess.getHttpServerAccess().getImportKeyword_3_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getImportKeyword_3_0()); 

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
    // InternalAceGen.g:3001:1: rule__HttpServer__Group_3__1 : rule__HttpServer__Group_3__1__Impl ;
    public final void rule__HttpServer__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3005:1: ( rule__HttpServer__Group_3__1__Impl )
            // InternalAceGen.g:3006:2: rule__HttpServer__Group_3__1__Impl
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
    // InternalAceGen.g:3012:1: rule__HttpServer__Group_3__1__Impl : ( ( rule__HttpServer__AuthUserRefAssignment_3_1 ) ) ;
    public final void rule__HttpServer__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3016:1: ( ( ( rule__HttpServer__AuthUserRefAssignment_3_1 ) ) )
            // InternalAceGen.g:3017:1: ( ( rule__HttpServer__AuthUserRefAssignment_3_1 ) )
            {
            // InternalAceGen.g:3017:1: ( ( rule__HttpServer__AuthUserRefAssignment_3_1 ) )
            // InternalAceGen.g:3018:2: ( rule__HttpServer__AuthUserRefAssignment_3_1 )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAssignment_3_1()); 
            // InternalAceGen.g:3019:2: ( rule__HttpServer__AuthUserRefAssignment_3_1 )
            // InternalAceGen.g:3019:3: rule__HttpServer__AuthUserRefAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__AuthUserRefAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAccess().getAuthUserRefAssignment_3_1()); 

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
    // InternalAceGen.g:3028:1: rule__HttpServer__Group_4__0 : rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1 ;
    public final void rule__HttpServer__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3032:1: ( rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1 )
            // InternalAceGen.g:3033:2: rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAceGen.g:3040:1: rule__HttpServer__Group_4__0__Impl : ( 'ACE' ) ;
    public final void rule__HttpServer__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3044:1: ( ( 'ACE' ) )
            // InternalAceGen.g:3045:1: ( 'ACE' )
            {
            // InternalAceGen.g:3045:1: ( 'ACE' )
            // InternalAceGen.g:3046:2: 'ACE'
            {
             before(grammarAccess.getHttpServerAccess().getACEKeyword_4_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getACEKeyword_4_0()); 

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
    // InternalAceGen.g:3055:1: rule__HttpServer__Group_4__1 : rule__HttpServer__Group_4__1__Impl ;
    public final void rule__HttpServer__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3059:1: ( rule__HttpServer__Group_4__1__Impl )
            // InternalAceGen.g:3060:2: rule__HttpServer__Group_4__1__Impl
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
    // InternalAceGen.g:3066:1: rule__HttpServer__Group_4__1__Impl : ( ( rule__HttpServer__AceOperationsAssignment_4_1 )* ) ;
    public final void rule__HttpServer__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3070:1: ( ( ( rule__HttpServer__AceOperationsAssignment_4_1 )* ) )
            // InternalAceGen.g:3071:1: ( ( rule__HttpServer__AceOperationsAssignment_4_1 )* )
            {
            // InternalAceGen.g:3071:1: ( ( rule__HttpServer__AceOperationsAssignment_4_1 )* )
            // InternalAceGen.g:3072:2: ( rule__HttpServer__AceOperationsAssignment_4_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getAceOperationsAssignment_4_1()); 
            // InternalAceGen.g:3073:2: ( rule__HttpServer__AceOperationsAssignment_4_1 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID||LA38_0==71) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalAceGen.g:3073:3: rule__HttpServer__AceOperationsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__HttpServer__AceOperationsAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getHttpServerAccess().getAceOperationsAssignment_4_1()); 

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
    // InternalAceGen.g:3082:1: rule__HttpServer__Group_5__0 : rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1 ;
    public final void rule__HttpServer__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3086:1: ( rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1 )
            // InternalAceGen.g:3087:2: rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalAceGen.g:3094:1: rule__HttpServer__Group_5__0__Impl : ( 'views' ) ;
    public final void rule__HttpServer__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3098:1: ( ( 'views' ) )
            // InternalAceGen.g:3099:1: ( 'views' )
            {
            // InternalAceGen.g:3099:1: ( 'views' )
            // InternalAceGen.g:3100:2: 'views'
            {
             before(grammarAccess.getHttpServerAccess().getViewsKeyword_5_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getViewsKeyword_5_0()); 

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
    // InternalAceGen.g:3109:1: rule__HttpServer__Group_5__1 : rule__HttpServer__Group_5__1__Impl ;
    public final void rule__HttpServer__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3113:1: ( rule__HttpServer__Group_5__1__Impl )
            // InternalAceGen.g:3114:2: rule__HttpServer__Group_5__1__Impl
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
    // InternalAceGen.g:3120:1: rule__HttpServer__Group_5__1__Impl : ( ( rule__HttpServer__ViewsAssignment_5_1 )* ) ;
    public final void rule__HttpServer__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3124:1: ( ( ( rule__HttpServer__ViewsAssignment_5_1 )* ) )
            // InternalAceGen.g:3125:1: ( ( rule__HttpServer__ViewsAssignment_5_1 )* )
            {
            // InternalAceGen.g:3125:1: ( ( rule__HttpServer__ViewsAssignment_5_1 )* )
            // InternalAceGen.g:3126:2: ( rule__HttpServer__ViewsAssignment_5_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getViewsAssignment_5_1()); 
            // InternalAceGen.g:3127:2: ( rule__HttpServer__ViewsAssignment_5_1 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalAceGen.g:3127:3: rule__HttpServer__ViewsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServer__ViewsAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getHttpServerAccess().getViewsAssignment_5_1()); 

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


    // $ANTLR start "rule__HttpServer__Group_6__0"
    // InternalAceGen.g:3136:1: rule__HttpServer__Group_6__0 : rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1 ;
    public final void rule__HttpServer__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3140:1: ( rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1 )
            // InternalAceGen.g:3141:2: rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1
            {
            pushFollow(FOLLOW_28);
            rule__HttpServer__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_6__1();

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
    // $ANTLR end "rule__HttpServer__Group_6__0"


    // $ANTLR start "rule__HttpServer__Group_6__0__Impl"
    // InternalAceGen.g:3148:1: rule__HttpServer__Group_6__0__Impl : ( 'models' ) ;
    public final void rule__HttpServer__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3152:1: ( ( 'models' ) )
            // InternalAceGen.g:3153:1: ( 'models' )
            {
            // InternalAceGen.g:3153:1: ( 'models' )
            // InternalAceGen.g:3154:2: 'models'
            {
             before(grammarAccess.getHttpServerAccess().getModelsKeyword_6_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getModelsKeyword_6_0()); 

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
    // $ANTLR end "rule__HttpServer__Group_6__0__Impl"


    // $ANTLR start "rule__HttpServer__Group_6__1"
    // InternalAceGen.g:3163:1: rule__HttpServer__Group_6__1 : rule__HttpServer__Group_6__1__Impl ;
    public final void rule__HttpServer__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3167:1: ( rule__HttpServer__Group_6__1__Impl )
            // InternalAceGen.g:3168:2: rule__HttpServer__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_6__1__Impl();

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
    // $ANTLR end "rule__HttpServer__Group_6__1"


    // $ANTLR start "rule__HttpServer__Group_6__1__Impl"
    // InternalAceGen.g:3174:1: rule__HttpServer__Group_6__1__Impl : ( ( rule__HttpServer__ModelsAssignment_6_1 )* ) ;
    public final void rule__HttpServer__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3178:1: ( ( ( rule__HttpServer__ModelsAssignment_6_1 )* ) )
            // InternalAceGen.g:3179:1: ( ( rule__HttpServer__ModelsAssignment_6_1 )* )
            {
            // InternalAceGen.g:3179:1: ( ( rule__HttpServer__ModelsAssignment_6_1 )* )
            // InternalAceGen.g:3180:2: ( rule__HttpServer__ModelsAssignment_6_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getModelsAssignment_6_1()); 
            // InternalAceGen.g:3181:2: ( rule__HttpServer__ModelsAssignment_6_1 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_ID||LA40_0==74) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalAceGen.g:3181:3: rule__HttpServer__ModelsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_29);
            	    rule__HttpServer__ModelsAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getHttpServerAccess().getModelsAssignment_6_1()); 

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
    // $ANTLR end "rule__HttpServer__Group_6__1__Impl"


    // $ANTLR start "rule__HttpServer__Group_7__0"
    // InternalAceGen.g:3190:1: rule__HttpServer__Group_7__0 : rule__HttpServer__Group_7__0__Impl rule__HttpServer__Group_7__1 ;
    public final void rule__HttpServer__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3194:1: ( rule__HttpServer__Group_7__0__Impl rule__HttpServer__Group_7__1 )
            // InternalAceGen.g:3195:2: rule__HttpServer__Group_7__0__Impl rule__HttpServer__Group_7__1
            {
            pushFollow(FOLLOW_4);
            rule__HttpServer__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_7__1();

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
    // $ANTLR end "rule__HttpServer__Group_7__0"


    // $ANTLR start "rule__HttpServer__Group_7__0__Impl"
    // InternalAceGen.g:3202:1: rule__HttpServer__Group_7__0__Impl : ( 'scenarios' ) ;
    public final void rule__HttpServer__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3206:1: ( ( 'scenarios' ) )
            // InternalAceGen.g:3207:1: ( 'scenarios' )
            {
            // InternalAceGen.g:3207:1: ( 'scenarios' )
            // InternalAceGen.g:3208:2: 'scenarios'
            {
             before(grammarAccess.getHttpServerAccess().getScenariosKeyword_7_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getScenariosKeyword_7_0()); 

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
    // $ANTLR end "rule__HttpServer__Group_7__0__Impl"


    // $ANTLR start "rule__HttpServer__Group_7__1"
    // InternalAceGen.g:3217:1: rule__HttpServer__Group_7__1 : rule__HttpServer__Group_7__1__Impl ;
    public final void rule__HttpServer__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3221:1: ( rule__HttpServer__Group_7__1__Impl )
            // InternalAceGen.g:3222:2: rule__HttpServer__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__Group_7__1__Impl();

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
    // $ANTLR end "rule__HttpServer__Group_7__1"


    // $ANTLR start "rule__HttpServer__Group_7__1__Impl"
    // InternalAceGen.g:3228:1: rule__HttpServer__Group_7__1__Impl : ( ( rule__HttpServer__ScenariosAssignment_7_1 )* ) ;
    public final void rule__HttpServer__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3232:1: ( ( ( rule__HttpServer__ScenariosAssignment_7_1 )* ) )
            // InternalAceGen.g:3233:1: ( ( rule__HttpServer__ScenariosAssignment_7_1 )* )
            {
            // InternalAceGen.g:3233:1: ( ( rule__HttpServer__ScenariosAssignment_7_1 )* )
            // InternalAceGen.g:3234:2: ( rule__HttpServer__ScenariosAssignment_7_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getScenariosAssignment_7_1()); 
            // InternalAceGen.g:3235:2: ( rule__HttpServer__ScenariosAssignment_7_1 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalAceGen.g:3235:3: rule__HttpServer__ScenariosAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServer__ScenariosAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getHttpServerAccess().getScenariosAssignment_7_1()); 

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
    // $ANTLR end "rule__HttpServer__Group_7__1__Impl"


    // $ANTLR start "rule__HttpServerAceWrite__Group__0"
    // InternalAceGen.g:3244:1: rule__HttpServerAceWrite__Group__0 : rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1 ;
    public final void rule__HttpServerAceWrite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3248:1: ( rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1 )
            // InternalAceGen.g:3249:2: rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAceGen.g:3256:1: rule__HttpServerAceWrite__Group__0__Impl : ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3260:1: ( ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? ) )
            // InternalAceGen.g:3261:1: ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? )
            {
            // InternalAceGen.g:3261:1: ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? )
            // InternalAceGen.g:3262:2: ( rule__HttpServerAceWrite__ProxyAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyAssignment_0()); 
            // InternalAceGen.g:3263:2: ( rule__HttpServerAceWrite__ProxyAssignment_0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==71) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalAceGen.g:3263:3: rule__HttpServerAceWrite__ProxyAssignment_0
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
    // InternalAceGen.g:3271:1: rule__HttpServerAceWrite__Group__1 : rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2 ;
    public final void rule__HttpServerAceWrite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3275:1: ( rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2 )
            // InternalAceGen.g:3276:2: rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2
            {
            pushFollow(FOLLOW_30);
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
    // InternalAceGen.g:3283:1: rule__HttpServerAceWrite__Group__1__Impl : ( ( rule__HttpServerAceWrite__NameAssignment_1 ) ) ;
    public final void rule__HttpServerAceWrite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3287:1: ( ( ( rule__HttpServerAceWrite__NameAssignment_1 ) ) )
            // InternalAceGen.g:3288:1: ( ( rule__HttpServerAceWrite__NameAssignment_1 ) )
            {
            // InternalAceGen.g:3288:1: ( ( rule__HttpServerAceWrite__NameAssignment_1 ) )
            // InternalAceGen.g:3289:2: ( rule__HttpServerAceWrite__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getNameAssignment_1()); 
            // InternalAceGen.g:3290:2: ( rule__HttpServerAceWrite__NameAssignment_1 )
            // InternalAceGen.g:3290:3: rule__HttpServerAceWrite__NameAssignment_1
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
    // InternalAceGen.g:3298:1: rule__HttpServerAceWrite__Group__2 : rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3 ;
    public final void rule__HttpServerAceWrite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3302:1: ( rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3 )
            // InternalAceGen.g:3303:2: rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3
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
    // InternalAceGen.g:3310:1: rule__HttpServerAceWrite__Group__2__Impl : ( '<' ) ;
    public final void rule__HttpServerAceWrite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3314:1: ( ( '<' ) )
            // InternalAceGen.g:3315:1: ( '<' )
            {
            // InternalAceGen.g:3315:1: ( '<' )
            // InternalAceGen.g:3316:2: '<'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getLessThanSignKeyword_2()); 
            match(input,32,FOLLOW_2); 
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
    // InternalAceGen.g:3325:1: rule__HttpServerAceWrite__Group__3 : rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4 ;
    public final void rule__HttpServerAceWrite__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3329:1: ( rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4 )
            // InternalAceGen.g:3330:2: rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4
            {
            pushFollow(FOLLOW_31);
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
    // InternalAceGen.g:3337:1: rule__HttpServerAceWrite__Group__3__Impl : ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) ) ;
    public final void rule__HttpServerAceWrite__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3341:1: ( ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) ) )
            // InternalAceGen.g:3342:1: ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) )
            {
            // InternalAceGen.g:3342:1: ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) )
            // InternalAceGen.g:3343:2: ( rule__HttpServerAceWrite__ModelAssignment_3 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getModelAssignment_3()); 
            // InternalAceGen.g:3344:2: ( rule__HttpServerAceWrite__ModelAssignment_3 )
            // InternalAceGen.g:3344:3: rule__HttpServerAceWrite__ModelAssignment_3
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
    // InternalAceGen.g:3352:1: rule__HttpServerAceWrite__Group__4 : rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5 ;
    public final void rule__HttpServerAceWrite__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3356:1: ( rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5 )
            // InternalAceGen.g:3357:2: rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5
            {
            pushFollow(FOLLOW_32);
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
    // InternalAceGen.g:3364:1: rule__HttpServerAceWrite__Group__4__Impl : ( '>' ) ;
    public final void rule__HttpServerAceWrite__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3368:1: ( ( '>' ) )
            // InternalAceGen.g:3369:1: ( '>' )
            {
            // InternalAceGen.g:3369:1: ( '>' )
            // InternalAceGen.g:3370:2: '>'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGreaterThanSignKeyword_4()); 
            match(input,33,FOLLOW_2); 
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
    // InternalAceGen.g:3379:1: rule__HttpServerAceWrite__Group__5 : rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6 ;
    public final void rule__HttpServerAceWrite__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3383:1: ( rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6 )
            // InternalAceGen.g:3384:2: rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6
            {
            pushFollow(FOLLOW_33);
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
    // InternalAceGen.g:3391:1: rule__HttpServerAceWrite__Group__5__Impl : ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) ) ;
    public final void rule__HttpServerAceWrite__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3395:1: ( ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) ) )
            // InternalAceGen.g:3396:1: ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) )
            {
            // InternalAceGen.g:3396:1: ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) )
            // InternalAceGen.g:3397:2: ( rule__HttpServerAceWrite__TypeAssignment_5 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getTypeAssignment_5()); 
            // InternalAceGen.g:3398:2: ( rule__HttpServerAceWrite__TypeAssignment_5 )
            // InternalAceGen.g:3398:3: rule__HttpServerAceWrite__TypeAssignment_5
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
    // InternalAceGen.g:3406:1: rule__HttpServerAceWrite__Group__6 : rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7 ;
    public final void rule__HttpServerAceWrite__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3410:1: ( rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7 )
            // InternalAceGen.g:3411:2: rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7
            {
            pushFollow(FOLLOW_34);
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
    // InternalAceGen.g:3418:1: rule__HttpServerAceWrite__Group__6__Impl : ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) ) ;
    public final void rule__HttpServerAceWrite__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3422:1: ( ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) ) )
            // InternalAceGen.g:3423:1: ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) )
            {
            // InternalAceGen.g:3423:1: ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) )
            // InternalAceGen.g:3424:2: ( rule__HttpServerAceWrite__UrlAssignment_6 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getUrlAssignment_6()); 
            // InternalAceGen.g:3425:2: ( rule__HttpServerAceWrite__UrlAssignment_6 )
            // InternalAceGen.g:3425:3: rule__HttpServerAceWrite__UrlAssignment_6
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
    // InternalAceGen.g:3433:1: rule__HttpServerAceWrite__Group__7 : rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8 ;
    public final void rule__HttpServerAceWrite__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3437:1: ( rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8 )
            // InternalAceGen.g:3438:2: rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8
            {
            pushFollow(FOLLOW_34);
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
    // InternalAceGen.g:3445:1: rule__HttpServerAceWrite__Group__7__Impl : ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? ) ;
    public final void rule__HttpServerAceWrite__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3449:1: ( ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? ) )
            // InternalAceGen.g:3450:1: ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? )
            {
            // InternalAceGen.g:3450:1: ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? )
            // InternalAceGen.g:3451:2: ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAssignment_7()); 
            // InternalAceGen.g:3452:2: ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==72) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalAceGen.g:3452:3: rule__HttpServerAceWrite__AuthorizeAssignment_7
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
    // InternalAceGen.g:3460:1: rule__HttpServerAceWrite__Group__8 : rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9 ;
    public final void rule__HttpServerAceWrite__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3464:1: ( rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9 )
            // InternalAceGen.g:3465:2: rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9
            {
            pushFollow(FOLLOW_34);
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
    // InternalAceGen.g:3472:1: rule__HttpServerAceWrite__Group__8__Impl : ( ( rule__HttpServerAceWrite__Group_8__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3476:1: ( ( ( rule__HttpServerAceWrite__Group_8__0 )? ) )
            // InternalAceGen.g:3477:1: ( ( rule__HttpServerAceWrite__Group_8__0 )? )
            {
            // InternalAceGen.g:3477:1: ( ( rule__HttpServerAceWrite__Group_8__0 )? )
            // InternalAceGen.g:3478:2: ( rule__HttpServerAceWrite__Group_8__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_8()); 
            // InternalAceGen.g:3479:2: ( rule__HttpServerAceWrite__Group_8__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==50) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalAceGen.g:3479:3: rule__HttpServerAceWrite__Group_8__0
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
    // InternalAceGen.g:3487:1: rule__HttpServerAceWrite__Group__9 : rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10 ;
    public final void rule__HttpServerAceWrite__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3491:1: ( rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10 )
            // InternalAceGen.g:3492:2: rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10
            {
            pushFollow(FOLLOW_34);
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
    // InternalAceGen.g:3499:1: rule__HttpServerAceWrite__Group__9__Impl : ( ( rule__HttpServerAceWrite__Group_9__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3503:1: ( ( ( rule__HttpServerAceWrite__Group_9__0 )? ) )
            // InternalAceGen.g:3504:1: ( ( rule__HttpServerAceWrite__Group_9__0 )? )
            {
            // InternalAceGen.g:3504:1: ( ( rule__HttpServerAceWrite__Group_9__0 )? )
            // InternalAceGen.g:3505:2: ( rule__HttpServerAceWrite__Group_9__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_9()); 
            // InternalAceGen.g:3506:2: ( rule__HttpServerAceWrite__Group_9__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==51) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAceGen.g:3506:3: rule__HttpServerAceWrite__Group_9__0
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
    // InternalAceGen.g:3514:1: rule__HttpServerAceWrite__Group__10 : rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11 ;
    public final void rule__HttpServerAceWrite__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3518:1: ( rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11 )
            // InternalAceGen.g:3519:2: rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11
            {
            pushFollow(FOLLOW_34);
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
    // InternalAceGen.g:3526:1: rule__HttpServerAceWrite__Group__10__Impl : ( ( rule__HttpServerAceWrite__Group_10__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3530:1: ( ( ( rule__HttpServerAceWrite__Group_10__0 )? ) )
            // InternalAceGen.g:3531:1: ( ( rule__HttpServerAceWrite__Group_10__0 )? )
            {
            // InternalAceGen.g:3531:1: ( ( rule__HttpServerAceWrite__Group_10__0 )? )
            // InternalAceGen.g:3532:2: ( rule__HttpServerAceWrite__Group_10__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_10()); 
            // InternalAceGen.g:3533:2: ( rule__HttpServerAceWrite__Group_10__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==52) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalAceGen.g:3533:3: rule__HttpServerAceWrite__Group_10__0
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
    // InternalAceGen.g:3541:1: rule__HttpServerAceWrite__Group__11 : rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12 ;
    public final void rule__HttpServerAceWrite__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3545:1: ( rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12 )
            // InternalAceGen.g:3546:2: rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12
            {
            pushFollow(FOLLOW_34);
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
    // InternalAceGen.g:3553:1: rule__HttpServerAceWrite__Group__11__Impl : ( ( rule__HttpServerAceWrite__Group_11__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3557:1: ( ( ( rule__HttpServerAceWrite__Group_11__0 )? ) )
            // InternalAceGen.g:3558:1: ( ( rule__HttpServerAceWrite__Group_11__0 )? )
            {
            // InternalAceGen.g:3558:1: ( ( rule__HttpServerAceWrite__Group_11__0 )? )
            // InternalAceGen.g:3559:2: ( rule__HttpServerAceWrite__Group_11__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_11()); 
            // InternalAceGen.g:3560:2: ( rule__HttpServerAceWrite__Group_11__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==53) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalAceGen.g:3560:3: rule__HttpServerAceWrite__Group_11__0
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
    // InternalAceGen.g:3568:1: rule__HttpServerAceWrite__Group__12 : rule__HttpServerAceWrite__Group__12__Impl ;
    public final void rule__HttpServerAceWrite__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3572:1: ( rule__HttpServerAceWrite__Group__12__Impl )
            // InternalAceGen.g:3573:2: rule__HttpServerAceWrite__Group__12__Impl
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
    // InternalAceGen.g:3579:1: rule__HttpServerAceWrite__Group__12__Impl : ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* ) ;
    public final void rule__HttpServerAceWrite__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3583:1: ( ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* ) )
            // InternalAceGen.g:3584:1: ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* )
            {
            // InternalAceGen.g:3584:1: ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* )
            // InternalAceGen.g:3585:2: ( rule__HttpServerAceWrite__OutcomesAssignment_12 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getOutcomesAssignment_12()); 
            // InternalAceGen.g:3586:2: ( rule__HttpServerAceWrite__OutcomesAssignment_12 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==37) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalAceGen.g:3586:3: rule__HttpServerAceWrite__OutcomesAssignment_12
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__HttpServerAceWrite__OutcomesAssignment_12();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
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
    // InternalAceGen.g:3595:1: rule__HttpServerAceWrite__Group_8__0 : rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1 ;
    public final void rule__HttpServerAceWrite__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3599:1: ( rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1 )
            // InternalAceGen.g:3600:2: rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1
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
    // InternalAceGen.g:3607:1: rule__HttpServerAceWrite__Group_8__0__Impl : ( 'pathParams' ) ;
    public final void rule__HttpServerAceWrite__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3611:1: ( ( 'pathParams' ) )
            // InternalAceGen.g:3612:1: ( 'pathParams' )
            {
            // InternalAceGen.g:3612:1: ( 'pathParams' )
            // InternalAceGen.g:3613:2: 'pathParams'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_8_0()); 
            match(input,50,FOLLOW_2); 
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
    // InternalAceGen.g:3622:1: rule__HttpServerAceWrite__Group_8__1 : rule__HttpServerAceWrite__Group_8__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3626:1: ( rule__HttpServerAceWrite__Group_8__1__Impl )
            // InternalAceGen.g:3627:2: rule__HttpServerAceWrite__Group_8__1__Impl
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
    // InternalAceGen.g:3633:1: rule__HttpServerAceWrite__Group_8__1__Impl : ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3637:1: ( ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* ) )
            // InternalAceGen.g:3638:1: ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* )
            {
            // InternalAceGen.g:3638:1: ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* )
            // InternalAceGen.g:3639:2: ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAssignment_8_1()); 
            // InternalAceGen.g:3640:2: ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_ID) ) {
                    int LA49_2 = input.LA(2);

                    if ( (LA49_2==EOF||LA49_2==RULE_ID||LA49_2==37||(LA49_2>=47 && LA49_2<=49)||(LA49_2>=51 && LA49_2<=53)||LA49_2==63||LA49_2==71||LA49_2==73) ) {
                        alt49=1;
                    }


                }


                switch (alt49) {
            	case 1 :
            	    // InternalAceGen.g:3640:3: rule__HttpServerAceWrite__PathParamsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceWrite__PathParamsAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
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
    // InternalAceGen.g:3649:1: rule__HttpServerAceWrite__Group_9__0 : rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1 ;
    public final void rule__HttpServerAceWrite__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3653:1: ( rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1 )
            // InternalAceGen.g:3654:2: rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1
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
    // InternalAceGen.g:3661:1: rule__HttpServerAceWrite__Group_9__0__Impl : ( 'queryParams' ) ;
    public final void rule__HttpServerAceWrite__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3665:1: ( ( 'queryParams' ) )
            // InternalAceGen.g:3666:1: ( 'queryParams' )
            {
            // InternalAceGen.g:3666:1: ( 'queryParams' )
            // InternalAceGen.g:3667:2: 'queryParams'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_9_0()); 
            match(input,51,FOLLOW_2); 
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
    // InternalAceGen.g:3676:1: rule__HttpServerAceWrite__Group_9__1 : rule__HttpServerAceWrite__Group_9__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3680:1: ( rule__HttpServerAceWrite__Group_9__1__Impl )
            // InternalAceGen.g:3681:2: rule__HttpServerAceWrite__Group_9__1__Impl
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
    // InternalAceGen.g:3687:1: rule__HttpServerAceWrite__Group_9__1__Impl : ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3691:1: ( ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* ) )
            // InternalAceGen.g:3692:1: ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* )
            {
            // InternalAceGen.g:3692:1: ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* )
            // InternalAceGen.g:3693:2: ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAssignment_9_1()); 
            // InternalAceGen.g:3694:2: ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    int LA50_2 = input.LA(2);

                    if ( (LA50_2==EOF||LA50_2==RULE_ID||LA50_2==37||(LA50_2>=47 && LA50_2<=49)||(LA50_2>=52 && LA50_2<=53)||LA50_2==63||LA50_2==71||LA50_2==73) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // InternalAceGen.g:3694:3: rule__HttpServerAceWrite__QueryParamsAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceWrite__QueryParamsAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
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
    // InternalAceGen.g:3703:1: rule__HttpServerAceWrite__Group_10__0 : rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1 ;
    public final void rule__HttpServerAceWrite__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3707:1: ( rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1 )
            // InternalAceGen.g:3708:2: rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1
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
    // InternalAceGen.g:3715:1: rule__HttpServerAceWrite__Group_10__0__Impl : ( 'payload' ) ;
    public final void rule__HttpServerAceWrite__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3719:1: ( ( 'payload' ) )
            // InternalAceGen.g:3720:1: ( 'payload' )
            {
            // InternalAceGen.g:3720:1: ( 'payload' )
            // InternalAceGen.g:3721:2: 'payload'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_10_0()); 
            match(input,52,FOLLOW_2); 
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
    // InternalAceGen.g:3730:1: rule__HttpServerAceWrite__Group_10__1 : rule__HttpServerAceWrite__Group_10__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3734:1: ( rule__HttpServerAceWrite__Group_10__1__Impl )
            // InternalAceGen.g:3735:2: rule__HttpServerAceWrite__Group_10__1__Impl
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
    // InternalAceGen.g:3741:1: rule__HttpServerAceWrite__Group_10__1__Impl : ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3745:1: ( ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* ) )
            // InternalAceGen.g:3746:1: ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* )
            {
            // InternalAceGen.g:3746:1: ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* )
            // InternalAceGen.g:3747:2: ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadAssignment_10_1()); 
            // InternalAceGen.g:3748:2: ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID) ) {
                    int LA51_2 = input.LA(2);

                    if ( (LA51_2==EOF||LA51_2==RULE_ID||LA51_2==37||(LA51_2>=47 && LA51_2<=49)||LA51_2==53||LA51_2==63||LA51_2==71||LA51_2==73) ) {
                        alt51=1;
                    }


                }


                switch (alt51) {
            	case 1 :
            	    // InternalAceGen.g:3748:3: rule__HttpServerAceWrite__PayloadAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceWrite__PayloadAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
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
    // InternalAceGen.g:3757:1: rule__HttpServerAceWrite__Group_11__0 : rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1 ;
    public final void rule__HttpServerAceWrite__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3761:1: ( rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1 )
            // InternalAceGen.g:3762:2: rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1
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
    // InternalAceGen.g:3769:1: rule__HttpServerAceWrite__Group_11__0__Impl : ( 'response' ) ;
    public final void rule__HttpServerAceWrite__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3773:1: ( ( 'response' ) )
            // InternalAceGen.g:3774:1: ( 'response' )
            {
            // InternalAceGen.g:3774:1: ( 'response' )
            // InternalAceGen.g:3775:2: 'response'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_11_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalAceGen.g:3784:1: rule__HttpServerAceWrite__Group_11__1 : rule__HttpServerAceWrite__Group_11__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3788:1: ( rule__HttpServerAceWrite__Group_11__1__Impl )
            // InternalAceGen.g:3789:2: rule__HttpServerAceWrite__Group_11__1__Impl
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
    // InternalAceGen.g:3795:1: rule__HttpServerAceWrite__Group_11__1__Impl : ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3799:1: ( ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* ) )
            // InternalAceGen.g:3800:1: ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* )
            {
            // InternalAceGen.g:3800:1: ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* )
            // InternalAceGen.g:3801:2: ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseAssignment_11_1()); 
            // InternalAceGen.g:3802:2: ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    int LA52_2 = input.LA(2);

                    if ( (LA52_2==EOF||LA52_2==RULE_ID||LA52_2==37||(LA52_2>=47 && LA52_2<=49)||LA52_2==63||LA52_2==71) ) {
                        alt52=1;
                    }


                }


                switch (alt52) {
            	case 1 :
            	    // InternalAceGen.g:3802:3: rule__HttpServerAceWrite__ResponseAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceWrite__ResponseAssignment_11_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
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
    // InternalAceGen.g:3811:1: rule__HttpServerOutcome__Group__0 : rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1 ;
    public final void rule__HttpServerOutcome__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3815:1: ( rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1 )
            // InternalAceGen.g:3816:2: rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1
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
    // InternalAceGen.g:3823:1: rule__HttpServerOutcome__Group__0__Impl : ( 'on' ) ;
    public final void rule__HttpServerOutcome__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3827:1: ( ( 'on' ) )
            // InternalAceGen.g:3828:1: ( 'on' )
            {
            // InternalAceGen.g:3828:1: ( 'on' )
            // InternalAceGen.g:3829:2: 'on'
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getOnKeyword_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalAceGen.g:3838:1: rule__HttpServerOutcome__Group__1 : rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2 ;
    public final void rule__HttpServerOutcome__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3842:1: ( rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2 )
            // InternalAceGen.g:3843:2: rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2
            {
            pushFollow(FOLLOW_16);
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
    // InternalAceGen.g:3850:1: rule__HttpServerOutcome__Group__1__Impl : ( ( rule__HttpServerOutcome__NameAssignment_1 ) ) ;
    public final void rule__HttpServerOutcome__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3854:1: ( ( ( rule__HttpServerOutcome__NameAssignment_1 ) ) )
            // InternalAceGen.g:3855:1: ( ( rule__HttpServerOutcome__NameAssignment_1 ) )
            {
            // InternalAceGen.g:3855:1: ( ( rule__HttpServerOutcome__NameAssignment_1 ) )
            // InternalAceGen.g:3856:2: ( rule__HttpServerOutcome__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getNameAssignment_1()); 
            // InternalAceGen.g:3857:2: ( rule__HttpServerOutcome__NameAssignment_1 )
            // InternalAceGen.g:3857:3: rule__HttpServerOutcome__NameAssignment_1
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
    // InternalAceGen.g:3865:1: rule__HttpServerOutcome__Group__2 : rule__HttpServerOutcome__Group__2__Impl ;
    public final void rule__HttpServerOutcome__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3869:1: ( rule__HttpServerOutcome__Group__2__Impl )
            // InternalAceGen.g:3870:2: rule__HttpServerOutcome__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServerOutcome__Group__2__Impl();

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
    // InternalAceGen.g:3876:1: rule__HttpServerOutcome__Group__2__Impl : ( ( rule__HttpServerOutcome__Group_2__0 )* ) ;
    public final void rule__HttpServerOutcome__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3880:1: ( ( ( rule__HttpServerOutcome__Group_2__0 )* ) )
            // InternalAceGen.g:3881:1: ( ( rule__HttpServerOutcome__Group_2__0 )* )
            {
            // InternalAceGen.g:3881:1: ( ( rule__HttpServerOutcome__Group_2__0 )* )
            // InternalAceGen.g:3882:2: ( rule__HttpServerOutcome__Group_2__0 )*
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getGroup_2()); 
            // InternalAceGen.g:3883:2: ( rule__HttpServerOutcome__Group_2__0 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==38) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalAceGen.g:3883:3: rule__HttpServerOutcome__Group_2__0
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__HttpServerOutcome__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
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


    // $ANTLR start "rule__HttpServerOutcome__Group_2__0"
    // InternalAceGen.g:3892:1: rule__HttpServerOutcome__Group_2__0 : rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1 ;
    public final void rule__HttpServerOutcome__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3896:1: ( rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1 )
            // InternalAceGen.g:3897:2: rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:3904:1: rule__HttpServerOutcome__Group_2__0__Impl : ( '(' ) ;
    public final void rule__HttpServerOutcome__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3908:1: ( ( '(' ) )
            // InternalAceGen.g:3909:1: ( '(' )
            {
            // InternalAceGen.g:3909:1: ( '(' )
            // InternalAceGen.g:3910:2: '('
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,38,FOLLOW_2); 
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
    // InternalAceGen.g:3919:1: rule__HttpServerOutcome__Group_2__1 : rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2 ;
    public final void rule__HttpServerOutcome__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3923:1: ( rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2 )
            // InternalAceGen.g:3924:2: rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:3931:1: rule__HttpServerOutcome__Group_2__1__Impl : ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* ) ;
    public final void rule__HttpServerOutcome__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3935:1: ( ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* ) )
            // InternalAceGen.g:3936:1: ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* )
            {
            // InternalAceGen.g:3936:1: ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* )
            // InternalAceGen.g:3937:2: ( rule__HttpServerOutcome__ListenersAssignment_2_1 )*
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getListenersAssignment_2_1()); 
            // InternalAceGen.g:3938:2: ( rule__HttpServerOutcome__ListenersAssignment_2_1 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalAceGen.g:3938:3: rule__HttpServerOutcome__ListenersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerOutcome__ListenersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop54;
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
    // InternalAceGen.g:3946:1: rule__HttpServerOutcome__Group_2__2 : rule__HttpServerOutcome__Group_2__2__Impl ;
    public final void rule__HttpServerOutcome__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3950:1: ( rule__HttpServerOutcome__Group_2__2__Impl )
            // InternalAceGen.g:3951:2: rule__HttpServerOutcome__Group_2__2__Impl
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
    // InternalAceGen.g:3957:1: rule__HttpServerOutcome__Group_2__2__Impl : ( ')' ) ;
    public final void rule__HttpServerOutcome__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3961:1: ( ( ')' ) )
            // InternalAceGen.g:3962:1: ( ')' )
            {
            // InternalAceGen.g:3962:1: ( ')' )
            // InternalAceGen.g:3963:2: ')'
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2()); 
            match(input,39,FOLLOW_2); 
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


    // $ANTLR start "rule__HttpServerAceRead__Group__0"
    // InternalAceGen.g:3973:1: rule__HttpServerAceRead__Group__0 : rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1 ;
    public final void rule__HttpServerAceRead__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3977:1: ( rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1 )
            // InternalAceGen.g:3978:2: rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalAceGen.g:3985:1: rule__HttpServerAceRead__Group__0__Impl : ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? ) ;
    public final void rule__HttpServerAceRead__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3989:1: ( ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? ) )
            // InternalAceGen.g:3990:1: ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? )
            {
            // InternalAceGen.g:3990:1: ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? )
            // InternalAceGen.g:3991:2: ( rule__HttpServerAceRead__ProxyAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyAssignment_0()); 
            // InternalAceGen.g:3992:2: ( rule__HttpServerAceRead__ProxyAssignment_0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==71) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalAceGen.g:3992:3: rule__HttpServerAceRead__ProxyAssignment_0
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
    // InternalAceGen.g:4000:1: rule__HttpServerAceRead__Group__1 : rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2 ;
    public final void rule__HttpServerAceRead__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4004:1: ( rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2 )
            // InternalAceGen.g:4005:2: rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2
            {
            pushFollow(FOLLOW_30);
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
    // InternalAceGen.g:4012:1: rule__HttpServerAceRead__Group__1__Impl : ( ( rule__HttpServerAceRead__NameAssignment_1 ) ) ;
    public final void rule__HttpServerAceRead__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4016:1: ( ( ( rule__HttpServerAceRead__NameAssignment_1 ) ) )
            // InternalAceGen.g:4017:1: ( ( rule__HttpServerAceRead__NameAssignment_1 ) )
            {
            // InternalAceGen.g:4017:1: ( ( rule__HttpServerAceRead__NameAssignment_1 ) )
            // InternalAceGen.g:4018:2: ( rule__HttpServerAceRead__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getNameAssignment_1()); 
            // InternalAceGen.g:4019:2: ( rule__HttpServerAceRead__NameAssignment_1 )
            // InternalAceGen.g:4019:3: rule__HttpServerAceRead__NameAssignment_1
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
    // InternalAceGen.g:4027:1: rule__HttpServerAceRead__Group__2 : rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3 ;
    public final void rule__HttpServerAceRead__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4031:1: ( rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3 )
            // InternalAceGen.g:4032:2: rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3
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
    // InternalAceGen.g:4039:1: rule__HttpServerAceRead__Group__2__Impl : ( '<' ) ;
    public final void rule__HttpServerAceRead__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4043:1: ( ( '<' ) )
            // InternalAceGen.g:4044:1: ( '<' )
            {
            // InternalAceGen.g:4044:1: ( '<' )
            // InternalAceGen.g:4045:2: '<'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getLessThanSignKeyword_2()); 
            match(input,32,FOLLOW_2); 
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
    // InternalAceGen.g:4054:1: rule__HttpServerAceRead__Group__3 : rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4 ;
    public final void rule__HttpServerAceRead__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4058:1: ( rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4 )
            // InternalAceGen.g:4059:2: rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4
            {
            pushFollow(FOLLOW_31);
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
    // InternalAceGen.g:4066:1: rule__HttpServerAceRead__Group__3__Impl : ( ( rule__HttpServerAceRead__ModelAssignment_3 ) ) ;
    public final void rule__HttpServerAceRead__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4070:1: ( ( ( rule__HttpServerAceRead__ModelAssignment_3 ) ) )
            // InternalAceGen.g:4071:1: ( ( rule__HttpServerAceRead__ModelAssignment_3 ) )
            {
            // InternalAceGen.g:4071:1: ( ( rule__HttpServerAceRead__ModelAssignment_3 ) )
            // InternalAceGen.g:4072:2: ( rule__HttpServerAceRead__ModelAssignment_3 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getModelAssignment_3()); 
            // InternalAceGen.g:4073:2: ( rule__HttpServerAceRead__ModelAssignment_3 )
            // InternalAceGen.g:4073:3: rule__HttpServerAceRead__ModelAssignment_3
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
    // InternalAceGen.g:4081:1: rule__HttpServerAceRead__Group__4 : rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5 ;
    public final void rule__HttpServerAceRead__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4085:1: ( rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5 )
            // InternalAceGen.g:4086:2: rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5
            {
            pushFollow(FOLLOW_36);
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
    // InternalAceGen.g:4093:1: rule__HttpServerAceRead__Group__4__Impl : ( '>' ) ;
    public final void rule__HttpServerAceRead__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4097:1: ( ( '>' ) )
            // InternalAceGen.g:4098:1: ( '>' )
            {
            // InternalAceGen.g:4098:1: ( '>' )
            // InternalAceGen.g:4099:2: '>'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGreaterThanSignKeyword_4()); 
            match(input,33,FOLLOW_2); 
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
    // InternalAceGen.g:4108:1: rule__HttpServerAceRead__Group__5 : rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6 ;
    public final void rule__HttpServerAceRead__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4112:1: ( rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6 )
            // InternalAceGen.g:4113:2: rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6
            {
            pushFollow(FOLLOW_33);
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
    // InternalAceGen.g:4120:1: rule__HttpServerAceRead__Group__5__Impl : ( ( rule__HttpServerAceRead__TypeAssignment_5 ) ) ;
    public final void rule__HttpServerAceRead__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4124:1: ( ( ( rule__HttpServerAceRead__TypeAssignment_5 ) ) )
            // InternalAceGen.g:4125:1: ( ( rule__HttpServerAceRead__TypeAssignment_5 ) )
            {
            // InternalAceGen.g:4125:1: ( ( rule__HttpServerAceRead__TypeAssignment_5 ) )
            // InternalAceGen.g:4126:2: ( rule__HttpServerAceRead__TypeAssignment_5 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getTypeAssignment_5()); 
            // InternalAceGen.g:4127:2: ( rule__HttpServerAceRead__TypeAssignment_5 )
            // InternalAceGen.g:4127:3: rule__HttpServerAceRead__TypeAssignment_5
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
    // InternalAceGen.g:4135:1: rule__HttpServerAceRead__Group__6 : rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7 ;
    public final void rule__HttpServerAceRead__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4139:1: ( rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7 )
            // InternalAceGen.g:4140:2: rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7
            {
            pushFollow(FOLLOW_37);
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
    // InternalAceGen.g:4147:1: rule__HttpServerAceRead__Group__6__Impl : ( ( rule__HttpServerAceRead__UrlAssignment_6 ) ) ;
    public final void rule__HttpServerAceRead__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4151:1: ( ( ( rule__HttpServerAceRead__UrlAssignment_6 ) ) )
            // InternalAceGen.g:4152:1: ( ( rule__HttpServerAceRead__UrlAssignment_6 ) )
            {
            // InternalAceGen.g:4152:1: ( ( rule__HttpServerAceRead__UrlAssignment_6 ) )
            // InternalAceGen.g:4153:2: ( rule__HttpServerAceRead__UrlAssignment_6 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getUrlAssignment_6()); 
            // InternalAceGen.g:4154:2: ( rule__HttpServerAceRead__UrlAssignment_6 )
            // InternalAceGen.g:4154:3: rule__HttpServerAceRead__UrlAssignment_6
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
    // InternalAceGen.g:4162:1: rule__HttpServerAceRead__Group__7 : rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8 ;
    public final void rule__HttpServerAceRead__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4166:1: ( rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8 )
            // InternalAceGen.g:4167:2: rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8
            {
            pushFollow(FOLLOW_37);
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
    // InternalAceGen.g:4174:1: rule__HttpServerAceRead__Group__7__Impl : ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? ) ;
    public final void rule__HttpServerAceRead__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4178:1: ( ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? ) )
            // InternalAceGen.g:4179:1: ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? )
            {
            // InternalAceGen.g:4179:1: ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? )
            // InternalAceGen.g:4180:2: ( rule__HttpServerAceRead__AuthorizeAssignment_7 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAssignment_7()); 
            // InternalAceGen.g:4181:2: ( rule__HttpServerAceRead__AuthorizeAssignment_7 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==72) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalAceGen.g:4181:3: rule__HttpServerAceRead__AuthorizeAssignment_7
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
    // InternalAceGen.g:4189:1: rule__HttpServerAceRead__Group__8 : rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9 ;
    public final void rule__HttpServerAceRead__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4193:1: ( rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9 )
            // InternalAceGen.g:4194:2: rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9
            {
            pushFollow(FOLLOW_37);
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
    // InternalAceGen.g:4201:1: rule__HttpServerAceRead__Group__8__Impl : ( ( rule__HttpServerAceRead__Group_8__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4205:1: ( ( ( rule__HttpServerAceRead__Group_8__0 )? ) )
            // InternalAceGen.g:4206:1: ( ( rule__HttpServerAceRead__Group_8__0 )? )
            {
            // InternalAceGen.g:4206:1: ( ( rule__HttpServerAceRead__Group_8__0 )? )
            // InternalAceGen.g:4207:2: ( rule__HttpServerAceRead__Group_8__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_8()); 
            // InternalAceGen.g:4208:2: ( rule__HttpServerAceRead__Group_8__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==50) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalAceGen.g:4208:3: rule__HttpServerAceRead__Group_8__0
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
    // InternalAceGen.g:4216:1: rule__HttpServerAceRead__Group__9 : rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10 ;
    public final void rule__HttpServerAceRead__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4220:1: ( rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10 )
            // InternalAceGen.g:4221:2: rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10
            {
            pushFollow(FOLLOW_37);
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
    // InternalAceGen.g:4228:1: rule__HttpServerAceRead__Group__9__Impl : ( ( rule__HttpServerAceRead__Group_9__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4232:1: ( ( ( rule__HttpServerAceRead__Group_9__0 )? ) )
            // InternalAceGen.g:4233:1: ( ( rule__HttpServerAceRead__Group_9__0 )? )
            {
            // InternalAceGen.g:4233:1: ( ( rule__HttpServerAceRead__Group_9__0 )? )
            // InternalAceGen.g:4234:2: ( rule__HttpServerAceRead__Group_9__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_9()); 
            // InternalAceGen.g:4235:2: ( rule__HttpServerAceRead__Group_9__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==51) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalAceGen.g:4235:3: rule__HttpServerAceRead__Group_9__0
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
    // InternalAceGen.g:4243:1: rule__HttpServerAceRead__Group__10 : rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11 ;
    public final void rule__HttpServerAceRead__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4247:1: ( rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11 )
            // InternalAceGen.g:4248:2: rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11
            {
            pushFollow(FOLLOW_37);
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
    // InternalAceGen.g:4255:1: rule__HttpServerAceRead__Group__10__Impl : ( ( rule__HttpServerAceRead__Group_10__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4259:1: ( ( ( rule__HttpServerAceRead__Group_10__0 )? ) )
            // InternalAceGen.g:4260:1: ( ( rule__HttpServerAceRead__Group_10__0 )? )
            {
            // InternalAceGen.g:4260:1: ( ( rule__HttpServerAceRead__Group_10__0 )? )
            // InternalAceGen.g:4261:2: ( rule__HttpServerAceRead__Group_10__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_10()); 
            // InternalAceGen.g:4262:2: ( rule__HttpServerAceRead__Group_10__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==52) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalAceGen.g:4262:3: rule__HttpServerAceRead__Group_10__0
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
    // InternalAceGen.g:4270:1: rule__HttpServerAceRead__Group__11 : rule__HttpServerAceRead__Group__11__Impl ;
    public final void rule__HttpServerAceRead__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4274:1: ( rule__HttpServerAceRead__Group__11__Impl )
            // InternalAceGen.g:4275:2: rule__HttpServerAceRead__Group__11__Impl
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
    // InternalAceGen.g:4281:1: rule__HttpServerAceRead__Group__11__Impl : ( ( rule__HttpServerAceRead__Group_11__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4285:1: ( ( ( rule__HttpServerAceRead__Group_11__0 )? ) )
            // InternalAceGen.g:4286:1: ( ( rule__HttpServerAceRead__Group_11__0 )? )
            {
            // InternalAceGen.g:4286:1: ( ( rule__HttpServerAceRead__Group_11__0 )? )
            // InternalAceGen.g:4287:2: ( rule__HttpServerAceRead__Group_11__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_11()); 
            // InternalAceGen.g:4288:2: ( rule__HttpServerAceRead__Group_11__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==53) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalAceGen.g:4288:3: rule__HttpServerAceRead__Group_11__0
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
    // InternalAceGen.g:4297:1: rule__HttpServerAceRead__Group_8__0 : rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1 ;
    public final void rule__HttpServerAceRead__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4301:1: ( rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1 )
            // InternalAceGen.g:4302:2: rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1
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
    // InternalAceGen.g:4309:1: rule__HttpServerAceRead__Group_8__0__Impl : ( 'pathParams' ) ;
    public final void rule__HttpServerAceRead__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4313:1: ( ( 'pathParams' ) )
            // InternalAceGen.g:4314:1: ( 'pathParams' )
            {
            // InternalAceGen.g:4314:1: ( 'pathParams' )
            // InternalAceGen.g:4315:2: 'pathParams'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_8_0()); 
            match(input,50,FOLLOW_2); 
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
    // InternalAceGen.g:4324:1: rule__HttpServerAceRead__Group_8__1 : rule__HttpServerAceRead__Group_8__1__Impl ;
    public final void rule__HttpServerAceRead__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4328:1: ( rule__HttpServerAceRead__Group_8__1__Impl )
            // InternalAceGen.g:4329:2: rule__HttpServerAceRead__Group_8__1__Impl
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
    // InternalAceGen.g:4335:1: rule__HttpServerAceRead__Group_8__1__Impl : ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4339:1: ( ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* ) )
            // InternalAceGen.g:4340:1: ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* )
            {
            // InternalAceGen.g:4340:1: ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* )
            // InternalAceGen.g:4341:2: ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsAssignment_8_1()); 
            // InternalAceGen.g:4342:2: ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_ID) ) {
                    int LA61_2 = input.LA(2);

                    if ( (LA61_2==EOF||LA61_2==RULE_ID||(LA61_2>=47 && LA61_2<=49)||(LA61_2>=51 && LA61_2<=53)||LA61_2==63||LA61_2==71||LA61_2==73) ) {
                        alt61=1;
                    }


                }


                switch (alt61) {
            	case 1 :
            	    // InternalAceGen.g:4342:3: rule__HttpServerAceRead__PathParamsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceRead__PathParamsAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop61;
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
    // InternalAceGen.g:4351:1: rule__HttpServerAceRead__Group_9__0 : rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1 ;
    public final void rule__HttpServerAceRead__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4355:1: ( rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1 )
            // InternalAceGen.g:4356:2: rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1
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
    // InternalAceGen.g:4363:1: rule__HttpServerAceRead__Group_9__0__Impl : ( 'queryParams' ) ;
    public final void rule__HttpServerAceRead__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4367:1: ( ( 'queryParams' ) )
            // InternalAceGen.g:4368:1: ( 'queryParams' )
            {
            // InternalAceGen.g:4368:1: ( 'queryParams' )
            // InternalAceGen.g:4369:2: 'queryParams'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_9_0()); 
            match(input,51,FOLLOW_2); 
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
    // InternalAceGen.g:4378:1: rule__HttpServerAceRead__Group_9__1 : rule__HttpServerAceRead__Group_9__1__Impl ;
    public final void rule__HttpServerAceRead__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4382:1: ( rule__HttpServerAceRead__Group_9__1__Impl )
            // InternalAceGen.g:4383:2: rule__HttpServerAceRead__Group_9__1__Impl
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
    // InternalAceGen.g:4389:1: rule__HttpServerAceRead__Group_9__1__Impl : ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4393:1: ( ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* ) )
            // InternalAceGen.g:4394:1: ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* )
            {
            // InternalAceGen.g:4394:1: ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* )
            // InternalAceGen.g:4395:2: ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAssignment_9_1()); 
            // InternalAceGen.g:4396:2: ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID) ) {
                    int LA62_2 = input.LA(2);

                    if ( (LA62_2==EOF||LA62_2==RULE_ID||(LA62_2>=47 && LA62_2<=49)||(LA62_2>=52 && LA62_2<=53)||LA62_2==63||LA62_2==71||LA62_2==73) ) {
                        alt62=1;
                    }


                }


                switch (alt62) {
            	case 1 :
            	    // InternalAceGen.g:4396:3: rule__HttpServerAceRead__QueryParamsAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceRead__QueryParamsAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop62;
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
    // InternalAceGen.g:4405:1: rule__HttpServerAceRead__Group_10__0 : rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1 ;
    public final void rule__HttpServerAceRead__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4409:1: ( rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1 )
            // InternalAceGen.g:4410:2: rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1
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
    // InternalAceGen.g:4417:1: rule__HttpServerAceRead__Group_10__0__Impl : ( 'payload' ) ;
    public final void rule__HttpServerAceRead__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4421:1: ( ( 'payload' ) )
            // InternalAceGen.g:4422:1: ( 'payload' )
            {
            // InternalAceGen.g:4422:1: ( 'payload' )
            // InternalAceGen.g:4423:2: 'payload'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_10_0()); 
            match(input,52,FOLLOW_2); 
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
    // InternalAceGen.g:4432:1: rule__HttpServerAceRead__Group_10__1 : rule__HttpServerAceRead__Group_10__1__Impl ;
    public final void rule__HttpServerAceRead__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4436:1: ( rule__HttpServerAceRead__Group_10__1__Impl )
            // InternalAceGen.g:4437:2: rule__HttpServerAceRead__Group_10__1__Impl
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
    // InternalAceGen.g:4443:1: rule__HttpServerAceRead__Group_10__1__Impl : ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4447:1: ( ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* ) )
            // InternalAceGen.g:4448:1: ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* )
            {
            // InternalAceGen.g:4448:1: ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* )
            // InternalAceGen.g:4449:2: ( rule__HttpServerAceRead__PayloadAssignment_10_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadAssignment_10_1()); 
            // InternalAceGen.g:4450:2: ( rule__HttpServerAceRead__PayloadAssignment_10_1 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ID) ) {
                    int LA63_2 = input.LA(2);

                    if ( (LA63_2==EOF||LA63_2==RULE_ID||(LA63_2>=47 && LA63_2<=49)||LA63_2==53||LA63_2==63||LA63_2==71||LA63_2==73) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // InternalAceGen.g:4450:3: rule__HttpServerAceRead__PayloadAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceRead__PayloadAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
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
    // InternalAceGen.g:4459:1: rule__HttpServerAceRead__Group_11__0 : rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1 ;
    public final void rule__HttpServerAceRead__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4463:1: ( rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1 )
            // InternalAceGen.g:4464:2: rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1
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
    // InternalAceGen.g:4471:1: rule__HttpServerAceRead__Group_11__0__Impl : ( 'response' ) ;
    public final void rule__HttpServerAceRead__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4475:1: ( ( 'response' ) )
            // InternalAceGen.g:4476:1: ( 'response' )
            {
            // InternalAceGen.g:4476:1: ( 'response' )
            // InternalAceGen.g:4477:2: 'response'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_11_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalAceGen.g:4486:1: rule__HttpServerAceRead__Group_11__1 : rule__HttpServerAceRead__Group_11__1__Impl ;
    public final void rule__HttpServerAceRead__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4490:1: ( rule__HttpServerAceRead__Group_11__1__Impl )
            // InternalAceGen.g:4491:2: rule__HttpServerAceRead__Group_11__1__Impl
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
    // InternalAceGen.g:4497:1: rule__HttpServerAceRead__Group_11__1__Impl : ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4501:1: ( ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* ) )
            // InternalAceGen.g:4502:1: ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* )
            {
            // InternalAceGen.g:4502:1: ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* )
            // InternalAceGen.g:4503:2: ( rule__HttpServerAceRead__ResponseAssignment_11_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseAssignment_11_1()); 
            // InternalAceGen.g:4504:2: ( rule__HttpServerAceRead__ResponseAssignment_11_1 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID) ) {
                    int LA64_2 = input.LA(2);

                    if ( (LA64_2==EOF||LA64_2==RULE_ID||(LA64_2>=47 && LA64_2<=49)||LA64_2==63||LA64_2==71) ) {
                        alt64=1;
                    }


                }


                switch (alt64) {
            	case 1 :
            	    // InternalAceGen.g:4504:3: rule__HttpServerAceRead__ResponseAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceRead__ResponseAssignment_11_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
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


    // $ANTLR start "rule__AttributeParamRef__Group__0"
    // InternalAceGen.g:4513:1: rule__AttributeParamRef__Group__0 : rule__AttributeParamRef__Group__0__Impl rule__AttributeParamRef__Group__1 ;
    public final void rule__AttributeParamRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4517:1: ( rule__AttributeParamRef__Group__0__Impl rule__AttributeParamRef__Group__1 )
            // InternalAceGen.g:4518:2: rule__AttributeParamRef__Group__0__Impl rule__AttributeParamRef__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__AttributeParamRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeParamRef__Group__1();

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
    // $ANTLR end "rule__AttributeParamRef__Group__0"


    // $ANTLR start "rule__AttributeParamRef__Group__0__Impl"
    // InternalAceGen.g:4525:1: rule__AttributeParamRef__Group__0__Impl : ( ( rule__AttributeParamRef__AttributeAssignment_0 ) ) ;
    public final void rule__AttributeParamRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4529:1: ( ( ( rule__AttributeParamRef__AttributeAssignment_0 ) ) )
            // InternalAceGen.g:4530:1: ( ( rule__AttributeParamRef__AttributeAssignment_0 ) )
            {
            // InternalAceGen.g:4530:1: ( ( rule__AttributeParamRef__AttributeAssignment_0 ) )
            // InternalAceGen.g:4531:2: ( rule__AttributeParamRef__AttributeAssignment_0 )
            {
             before(grammarAccess.getAttributeParamRefAccess().getAttributeAssignment_0()); 
            // InternalAceGen.g:4532:2: ( rule__AttributeParamRef__AttributeAssignment_0 )
            // InternalAceGen.g:4532:3: rule__AttributeParamRef__AttributeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeParamRef__AttributeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeParamRefAccess().getAttributeAssignment_0()); 

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
    // $ANTLR end "rule__AttributeParamRef__Group__0__Impl"


    // $ANTLR start "rule__AttributeParamRef__Group__1"
    // InternalAceGen.g:4540:1: rule__AttributeParamRef__Group__1 : rule__AttributeParamRef__Group__1__Impl ;
    public final void rule__AttributeParamRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4544:1: ( rule__AttributeParamRef__Group__1__Impl )
            // InternalAceGen.g:4545:2: rule__AttributeParamRef__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeParamRef__Group__1__Impl();

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
    // $ANTLR end "rule__AttributeParamRef__Group__1"


    // $ANTLR start "rule__AttributeParamRef__Group__1__Impl"
    // InternalAceGen.g:4551:1: rule__AttributeParamRef__Group__1__Impl : ( ( rule__AttributeParamRef__OptionalAssignment_1 )? ) ;
    public final void rule__AttributeParamRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4555:1: ( ( ( rule__AttributeParamRef__OptionalAssignment_1 )? ) )
            // InternalAceGen.g:4556:1: ( ( rule__AttributeParamRef__OptionalAssignment_1 )? )
            {
            // InternalAceGen.g:4556:1: ( ( rule__AttributeParamRef__OptionalAssignment_1 )? )
            // InternalAceGen.g:4557:2: ( rule__AttributeParamRef__OptionalAssignment_1 )?
            {
             before(grammarAccess.getAttributeParamRefAccess().getOptionalAssignment_1()); 
            // InternalAceGen.g:4558:2: ( rule__AttributeParamRef__OptionalAssignment_1 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==73) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalAceGen.g:4558:3: rule__AttributeParamRef__OptionalAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttributeParamRef__OptionalAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeParamRefAccess().getOptionalAssignment_1()); 

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
    // $ANTLR end "rule__AttributeParamRef__Group__1__Impl"


    // $ANTLR start "rule__HttpServerView__Group__0"
    // InternalAceGen.g:4567:1: rule__HttpServerView__Group__0 : rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1 ;
    public final void rule__HttpServerView__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4571:1: ( rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1 )
            // InternalAceGen.g:4572:2: rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalAceGen.g:4579:1: rule__HttpServerView__Group__0__Impl : ( ( rule__HttpServerView__NameAssignment_0 ) ) ;
    public final void rule__HttpServerView__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4583:1: ( ( ( rule__HttpServerView__NameAssignment_0 ) ) )
            // InternalAceGen.g:4584:1: ( ( rule__HttpServerView__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4584:1: ( ( rule__HttpServerView__NameAssignment_0 ) )
            // InternalAceGen.g:4585:2: ( rule__HttpServerView__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerViewAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4586:2: ( rule__HttpServerView__NameAssignment_0 )
            // InternalAceGen.g:4586:3: rule__HttpServerView__NameAssignment_0
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
    // InternalAceGen.g:4594:1: rule__HttpServerView__Group__1 : rule__HttpServerView__Group__1__Impl ;
    public final void rule__HttpServerView__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4598:1: ( rule__HttpServerView__Group__1__Impl )
            // InternalAceGen.g:4599:2: rule__HttpServerView__Group__1__Impl
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
    // InternalAceGen.g:4605:1: rule__HttpServerView__Group__1__Impl : ( ( rule__HttpServerView__Group_1__0 )? ) ;
    public final void rule__HttpServerView__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4609:1: ( ( ( rule__HttpServerView__Group_1__0 )? ) )
            // InternalAceGen.g:4610:1: ( ( rule__HttpServerView__Group_1__0 )? )
            {
            // InternalAceGen.g:4610:1: ( ( rule__HttpServerView__Group_1__0 )? )
            // InternalAceGen.g:4611:2: ( rule__HttpServerView__Group_1__0 )?
            {
             before(grammarAccess.getHttpServerViewAccess().getGroup_1()); 
            // InternalAceGen.g:4612:2: ( rule__HttpServerView__Group_1__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==43) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalAceGen.g:4612:3: rule__HttpServerView__Group_1__0
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
    // InternalAceGen.g:4621:1: rule__HttpServerView__Group_1__0 : rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1 ;
    public final void rule__HttpServerView__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4625:1: ( rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1 )
            // InternalAceGen.g:4626:2: rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalAceGen.g:4633:1: rule__HttpServerView__Group_1__0__Impl : ( '{' ) ;
    public final void rule__HttpServerView__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4637:1: ( ( '{' ) )
            // InternalAceGen.g:4638:1: ( '{' )
            {
            // InternalAceGen.g:4638:1: ( '{' )
            // InternalAceGen.g:4639:2: '{'
            {
             before(grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalAceGen.g:4648:1: rule__HttpServerView__Group_1__1 : rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2 ;
    public final void rule__HttpServerView__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4652:1: ( rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2 )
            // InternalAceGen.g:4653:2: rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalAceGen.g:4660:1: rule__HttpServerView__Group_1__1__Impl : ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* ) ;
    public final void rule__HttpServerView__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4664:1: ( ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* ) )
            // InternalAceGen.g:4665:1: ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* )
            {
            // InternalAceGen.g:4665:1: ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* )
            // InternalAceGen.g:4666:2: ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )*
            {
             before(grammarAccess.getHttpServerViewAccess().getRenderFunctionsAssignment_1_1()); 
            // InternalAceGen.g:4667:2: ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==RULE_ID) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalAceGen.g:4667:3: rule__HttpServerView__RenderFunctionsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerView__RenderFunctionsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop67;
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
    // InternalAceGen.g:4675:1: rule__HttpServerView__Group_1__2 : rule__HttpServerView__Group_1__2__Impl ;
    public final void rule__HttpServerView__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4679:1: ( rule__HttpServerView__Group_1__2__Impl )
            // InternalAceGen.g:4680:2: rule__HttpServerView__Group_1__2__Impl
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
    // InternalAceGen.g:4686:1: rule__HttpServerView__Group_1__2__Impl : ( '}' ) ;
    public final void rule__HttpServerView__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4690:1: ( ( '}' ) )
            // InternalAceGen.g:4691:1: ( '}' )
            {
            // InternalAceGen.g:4691:1: ( '}' )
            // InternalAceGen.g:4692:2: '}'
            {
             before(grammarAccess.getHttpServerViewAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,44,FOLLOW_2); 
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
    // InternalAceGen.g:4702:1: rule__HttpServerViewFunction__Group__0 : rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1 ;
    public final void rule__HttpServerViewFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4706:1: ( rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1 )
            // InternalAceGen.g:4707:2: rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalAceGen.g:4714:1: rule__HttpServerViewFunction__Group__0__Impl : ( ( rule__HttpServerViewFunction__NameAssignment_0 ) ) ;
    public final void rule__HttpServerViewFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4718:1: ( ( ( rule__HttpServerViewFunction__NameAssignment_0 ) ) )
            // InternalAceGen.g:4719:1: ( ( rule__HttpServerViewFunction__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4719:1: ( ( rule__HttpServerViewFunction__NameAssignment_0 ) )
            // InternalAceGen.g:4720:2: ( rule__HttpServerViewFunction__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4721:2: ( rule__HttpServerViewFunction__NameAssignment_0 )
            // InternalAceGen.g:4721:3: rule__HttpServerViewFunction__NameAssignment_0
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
    // InternalAceGen.g:4729:1: rule__HttpServerViewFunction__Group__1 : rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2 ;
    public final void rule__HttpServerViewFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4733:1: ( rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2 )
            // InternalAceGen.g:4734:2: rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2
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
    // InternalAceGen.g:4741:1: rule__HttpServerViewFunction__Group__1__Impl : ( '(' ) ;
    public final void rule__HttpServerViewFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4745:1: ( ( '(' ) )
            // InternalAceGen.g:4746:1: ( '(' )
            {
            // InternalAceGen.g:4746:1: ( '(' )
            // InternalAceGen.g:4747:2: '('
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getLeftParenthesisKeyword_1()); 
            match(input,38,FOLLOW_2); 
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
    // InternalAceGen.g:4756:1: rule__HttpServerViewFunction__Group__2 : rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3 ;
    public final void rule__HttpServerViewFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4760:1: ( rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3 )
            // InternalAceGen.g:4761:2: rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3
            {
            pushFollow(FOLLOW_39);
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
    // InternalAceGen.g:4768:1: rule__HttpServerViewFunction__Group__2__Impl : ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) ) ;
    public final void rule__HttpServerViewFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4772:1: ( ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) ) )
            // InternalAceGen.g:4773:1: ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) )
            {
            // InternalAceGen.g:4773:1: ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) )
            // InternalAceGen.g:4774:2: ( rule__HttpServerViewFunction__ModelAssignment_2 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getModelAssignment_2()); 
            // InternalAceGen.g:4775:2: ( rule__HttpServerViewFunction__ModelAssignment_2 )
            // InternalAceGen.g:4775:3: rule__HttpServerViewFunction__ModelAssignment_2
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
    // InternalAceGen.g:4783:1: rule__HttpServerViewFunction__Group__3 : rule__HttpServerViewFunction__Group__3__Impl ;
    public final void rule__HttpServerViewFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4787:1: ( rule__HttpServerViewFunction__Group__3__Impl )
            // InternalAceGen.g:4788:2: rule__HttpServerViewFunction__Group__3__Impl
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
    // InternalAceGen.g:4794:1: rule__HttpServerViewFunction__Group__3__Impl : ( ')' ) ;
    public final void rule__HttpServerViewFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4798:1: ( ( ')' ) )
            // InternalAceGen.g:4799:1: ( ')' )
            {
            // InternalAceGen.g:4799:1: ( ')' )
            // InternalAceGen.g:4800:2: ')'
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getRightParenthesisKeyword_3()); 
            match(input,39,FOLLOW_2); 
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
    // InternalAceGen.g:4810:1: rule__AuthUser__Group__0 : rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1 ;
    public final void rule__AuthUser__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4814:1: ( rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1 )
            // InternalAceGen.g:4815:2: rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalAceGen.g:4822:1: rule__AuthUser__Group__0__Impl : ( ( rule__AuthUser__NameAssignment_0 ) ) ;
    public final void rule__AuthUser__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4826:1: ( ( ( rule__AuthUser__NameAssignment_0 ) ) )
            // InternalAceGen.g:4827:1: ( ( rule__AuthUser__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4827:1: ( ( rule__AuthUser__NameAssignment_0 ) )
            // InternalAceGen.g:4828:2: ( rule__AuthUser__NameAssignment_0 )
            {
             before(grammarAccess.getAuthUserAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4829:2: ( rule__AuthUser__NameAssignment_0 )
            // InternalAceGen.g:4829:3: rule__AuthUser__NameAssignment_0
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
    // InternalAceGen.g:4837:1: rule__AuthUser__Group__1 : rule__AuthUser__Group__1__Impl ;
    public final void rule__AuthUser__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4841:1: ( rule__AuthUser__Group__1__Impl )
            // InternalAceGen.g:4842:2: rule__AuthUser__Group__1__Impl
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
    // InternalAceGen.g:4848:1: rule__AuthUser__Group__1__Impl : ( ( rule__AuthUser__Group_1__0 ) ) ;
    public final void rule__AuthUser__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4852:1: ( ( ( rule__AuthUser__Group_1__0 ) ) )
            // InternalAceGen.g:4853:1: ( ( rule__AuthUser__Group_1__0 ) )
            {
            // InternalAceGen.g:4853:1: ( ( rule__AuthUser__Group_1__0 ) )
            // InternalAceGen.g:4854:2: ( rule__AuthUser__Group_1__0 )
            {
             before(grammarAccess.getAuthUserAccess().getGroup_1()); 
            // InternalAceGen.g:4855:2: ( rule__AuthUser__Group_1__0 )
            // InternalAceGen.g:4855:3: rule__AuthUser__Group_1__0
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
    // InternalAceGen.g:4864:1: rule__AuthUser__Group_1__0 : rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1 ;
    public final void rule__AuthUser__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4868:1: ( rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1 )
            // InternalAceGen.g:4869:2: rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalAceGen.g:4876:1: rule__AuthUser__Group_1__0__Impl : ( '{' ) ;
    public final void rule__AuthUser__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4880:1: ( ( '{' ) )
            // InternalAceGen.g:4881:1: ( '{' )
            {
            // InternalAceGen.g:4881:1: ( '{' )
            // InternalAceGen.g:4882:2: '{'
            {
             before(grammarAccess.getAuthUserAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalAceGen.g:4891:1: rule__AuthUser__Group_1__1 : rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2 ;
    public final void rule__AuthUser__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4895:1: ( rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2 )
            // InternalAceGen.g:4896:2: rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2
            {
            pushFollow(FOLLOW_40);
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
    // InternalAceGen.g:4903:1: rule__AuthUser__Group_1__1__Impl : ( ( rule__AuthUser__AttributesAssignment_1_1 )* ) ;
    public final void rule__AuthUser__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4907:1: ( ( ( rule__AuthUser__AttributesAssignment_1_1 )* ) )
            // InternalAceGen.g:4908:1: ( ( rule__AuthUser__AttributesAssignment_1_1 )* )
            {
            // InternalAceGen.g:4908:1: ( ( rule__AuthUser__AttributesAssignment_1_1 )* )
            // InternalAceGen.g:4909:2: ( rule__AuthUser__AttributesAssignment_1_1 )*
            {
             before(grammarAccess.getAuthUserAccess().getAttributesAssignment_1_1()); 
            // InternalAceGen.g:4910:2: ( rule__AuthUser__AttributesAssignment_1_1 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==RULE_ID||(LA68_0>=20 && LA68_0<=25)||(LA68_0>=76 && LA68_0<=79)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalAceGen.g:4910:3: rule__AuthUser__AttributesAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_41);
            	    rule__AuthUser__AttributesAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop68;
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
    // InternalAceGen.g:4918:1: rule__AuthUser__Group_1__2 : rule__AuthUser__Group_1__2__Impl ;
    public final void rule__AuthUser__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4922:1: ( rule__AuthUser__Group_1__2__Impl )
            // InternalAceGen.g:4923:2: rule__AuthUser__Group_1__2__Impl
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
    // InternalAceGen.g:4929:1: rule__AuthUser__Group_1__2__Impl : ( '}' ) ;
    public final void rule__AuthUser__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4933:1: ( ( '}' ) )
            // InternalAceGen.g:4934:1: ( '}' )
            {
            // InternalAceGen.g:4934:1: ( '}' )
            // InternalAceGen.g:4935:2: '}'
            {
             before(grammarAccess.getAuthUserAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,44,FOLLOW_2); 
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
    // InternalAceGen.g:4945:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4949:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalAceGen.g:4950:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalAceGen.g:4957:1: rule__Model__Group__0__Impl : ( ( rule__Model__PersistentAssignment_0 )? ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4961:1: ( ( ( rule__Model__PersistentAssignment_0 )? ) )
            // InternalAceGen.g:4962:1: ( ( rule__Model__PersistentAssignment_0 )? )
            {
            // InternalAceGen.g:4962:1: ( ( rule__Model__PersistentAssignment_0 )? )
            // InternalAceGen.g:4963:2: ( rule__Model__PersistentAssignment_0 )?
            {
             before(grammarAccess.getModelAccess().getPersistentAssignment_0()); 
            // InternalAceGen.g:4964:2: ( rule__Model__PersistentAssignment_0 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==74) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalAceGen.g:4964:3: rule__Model__PersistentAssignment_0
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
    // InternalAceGen.g:4972:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4976:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalAceGen.g:4977:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_42);
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
    // InternalAceGen.g:4984:1: rule__Model__Group__1__Impl : ( ( rule__Model__NameAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4988:1: ( ( ( rule__Model__NameAssignment_1 ) ) )
            // InternalAceGen.g:4989:1: ( ( rule__Model__NameAssignment_1 ) )
            {
            // InternalAceGen.g:4989:1: ( ( rule__Model__NameAssignment_1 ) )
            // InternalAceGen.g:4990:2: ( rule__Model__NameAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1()); 
            // InternalAceGen.g:4991:2: ( rule__Model__NameAssignment_1 )
            // InternalAceGen.g:4991:3: rule__Model__NameAssignment_1
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
    // InternalAceGen.g:4999:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5003:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalAceGen.g:5004:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_42);
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
    // InternalAceGen.g:5011:1: rule__Model__Group__2__Impl : ( ( rule__Model__Group_2__0 )? ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5015:1: ( ( ( rule__Model__Group_2__0 )? ) )
            // InternalAceGen.g:5016:1: ( ( rule__Model__Group_2__0 )? )
            {
            // InternalAceGen.g:5016:1: ( ( rule__Model__Group_2__0 )? )
            // InternalAceGen.g:5017:2: ( rule__Model__Group_2__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalAceGen.g:5018:2: ( rule__Model__Group_2__0 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==54) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalAceGen.g:5018:3: rule__Model__Group_2__0
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
    // InternalAceGen.g:5026:1: rule__Model__Group__3 : rule__Model__Group__3__Impl ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5030:1: ( rule__Model__Group__3__Impl )
            // InternalAceGen.g:5031:2: rule__Model__Group__3__Impl
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
    // InternalAceGen.g:5037:1: rule__Model__Group__3__Impl : ( ( rule__Model__Group_3__0 )? ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5041:1: ( ( ( rule__Model__Group_3__0 )? ) )
            // InternalAceGen.g:5042:1: ( ( rule__Model__Group_3__0 )? )
            {
            // InternalAceGen.g:5042:1: ( ( rule__Model__Group_3__0 )? )
            // InternalAceGen.g:5043:2: ( rule__Model__Group_3__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_3()); 
            // InternalAceGen.g:5044:2: ( rule__Model__Group_3__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==43) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalAceGen.g:5044:3: rule__Model__Group_3__0
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
    // InternalAceGen.g:5053:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5057:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalAceGen.g:5058:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
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
    // InternalAceGen.g:5065:1: rule__Model__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5069:1: ( ( 'extends' ) )
            // InternalAceGen.g:5070:1: ( 'extends' )
            {
            // InternalAceGen.g:5070:1: ( 'extends' )
            // InternalAceGen.g:5071:2: 'extends'
            {
             before(grammarAccess.getModelAccess().getExtendsKeyword_2_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalAceGen.g:5080:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl rule__Model__Group_2__2 ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5084:1: ( rule__Model__Group_2__1__Impl rule__Model__Group_2__2 )
            // InternalAceGen.g:5085:2: rule__Model__Group_2__1__Impl rule__Model__Group_2__2
            {
            pushFollow(FOLLOW_43);
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
    // InternalAceGen.g:5092:1: rule__Model__Group_2__1__Impl : ( ( rule__Model__SuperModelsAssignment_2_1 ) ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5096:1: ( ( ( rule__Model__SuperModelsAssignment_2_1 ) ) )
            // InternalAceGen.g:5097:1: ( ( rule__Model__SuperModelsAssignment_2_1 ) )
            {
            // InternalAceGen.g:5097:1: ( ( rule__Model__SuperModelsAssignment_2_1 ) )
            // InternalAceGen.g:5098:2: ( rule__Model__SuperModelsAssignment_2_1 )
            {
             before(grammarAccess.getModelAccess().getSuperModelsAssignment_2_1()); 
            // InternalAceGen.g:5099:2: ( rule__Model__SuperModelsAssignment_2_1 )
            // InternalAceGen.g:5099:3: rule__Model__SuperModelsAssignment_2_1
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
    // InternalAceGen.g:5107:1: rule__Model__Group_2__2 : rule__Model__Group_2__2__Impl ;
    public final void rule__Model__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5111:1: ( rule__Model__Group_2__2__Impl )
            // InternalAceGen.g:5112:2: rule__Model__Group_2__2__Impl
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
    // InternalAceGen.g:5118:1: rule__Model__Group_2__2__Impl : ( ( rule__Model__Group_2_2__0 )* ) ;
    public final void rule__Model__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5122:1: ( ( ( rule__Model__Group_2_2__0 )* ) )
            // InternalAceGen.g:5123:1: ( ( rule__Model__Group_2_2__0 )* )
            {
            // InternalAceGen.g:5123:1: ( ( rule__Model__Group_2_2__0 )* )
            // InternalAceGen.g:5124:2: ( rule__Model__Group_2_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_2_2()); 
            // InternalAceGen.g:5125:2: ( rule__Model__Group_2_2__0 )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==34) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalAceGen.g:5125:3: rule__Model__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Model__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop72;
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
    // InternalAceGen.g:5134:1: rule__Model__Group_2_2__0 : rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1 ;
    public final void rule__Model__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5138:1: ( rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1 )
            // InternalAceGen.g:5139:2: rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1
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
    // InternalAceGen.g:5146:1: rule__Model__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Model__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5150:1: ( ( ',' ) )
            // InternalAceGen.g:5151:1: ( ',' )
            {
            // InternalAceGen.g:5151:1: ( ',' )
            // InternalAceGen.g:5152:2: ','
            {
             before(grammarAccess.getModelAccess().getCommaKeyword_2_2_0()); 
            match(input,34,FOLLOW_2); 
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
    // InternalAceGen.g:5161:1: rule__Model__Group_2_2__1 : rule__Model__Group_2_2__1__Impl ;
    public final void rule__Model__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5165:1: ( rule__Model__Group_2_2__1__Impl )
            // InternalAceGen.g:5166:2: rule__Model__Group_2_2__1__Impl
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
    // InternalAceGen.g:5172:1: rule__Model__Group_2_2__1__Impl : ( ( rule__Model__SuperModelsAssignment_2_2_1 ) ) ;
    public final void rule__Model__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5176:1: ( ( ( rule__Model__SuperModelsAssignment_2_2_1 ) ) )
            // InternalAceGen.g:5177:1: ( ( rule__Model__SuperModelsAssignment_2_2_1 ) )
            {
            // InternalAceGen.g:5177:1: ( ( rule__Model__SuperModelsAssignment_2_2_1 ) )
            // InternalAceGen.g:5178:2: ( rule__Model__SuperModelsAssignment_2_2_1 )
            {
             before(grammarAccess.getModelAccess().getSuperModelsAssignment_2_2_1()); 
            // InternalAceGen.g:5179:2: ( rule__Model__SuperModelsAssignment_2_2_1 )
            // InternalAceGen.g:5179:3: rule__Model__SuperModelsAssignment_2_2_1
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
    // InternalAceGen.g:5188:1: rule__Model__Group_3__0 : rule__Model__Group_3__0__Impl rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5192:1: ( rule__Model__Group_3__0__Impl rule__Model__Group_3__1 )
            // InternalAceGen.g:5193:2: rule__Model__Group_3__0__Impl rule__Model__Group_3__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalAceGen.g:5200:1: rule__Model__Group_3__0__Impl : ( '{' ) ;
    public final void rule__Model__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5204:1: ( ( '{' ) )
            // InternalAceGen.g:5205:1: ( '{' )
            {
            // InternalAceGen.g:5205:1: ( '{' )
            // InternalAceGen.g:5206:2: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalAceGen.g:5215:1: rule__Model__Group_3__1 : rule__Model__Group_3__1__Impl rule__Model__Group_3__2 ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5219:1: ( rule__Model__Group_3__1__Impl rule__Model__Group_3__2 )
            // InternalAceGen.g:5220:2: rule__Model__Group_3__1__Impl rule__Model__Group_3__2
            {
            pushFollow(FOLLOW_40);
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
    // InternalAceGen.g:5227:1: rule__Model__Group_3__1__Impl : ( ( rule__Model__AttributesAssignment_3_1 )* ) ;
    public final void rule__Model__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5231:1: ( ( ( rule__Model__AttributesAssignment_3_1 )* ) )
            // InternalAceGen.g:5232:1: ( ( rule__Model__AttributesAssignment_3_1 )* )
            {
            // InternalAceGen.g:5232:1: ( ( rule__Model__AttributesAssignment_3_1 )* )
            // InternalAceGen.g:5233:2: ( rule__Model__AttributesAssignment_3_1 )*
            {
             before(grammarAccess.getModelAccess().getAttributesAssignment_3_1()); 
            // InternalAceGen.g:5234:2: ( rule__Model__AttributesAssignment_3_1 )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_ID||(LA73_0>=20 && LA73_0<=25)||(LA73_0>=76 && LA73_0<=79)) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalAceGen.g:5234:3: rule__Model__AttributesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_41);
            	    rule__Model__AttributesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop73;
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
    // InternalAceGen.g:5242:1: rule__Model__Group_3__2 : rule__Model__Group_3__2__Impl ;
    public final void rule__Model__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5246:1: ( rule__Model__Group_3__2__Impl )
            // InternalAceGen.g:5247:2: rule__Model__Group_3__2__Impl
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
    // InternalAceGen.g:5253:1: rule__Model__Group_3__2__Impl : ( '}' ) ;
    public final void rule__Model__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5257:1: ( ( '}' ) )
            // InternalAceGen.g:5258:1: ( '}' )
            {
            // InternalAceGen.g:5258:1: ( '}' )
            // InternalAceGen.g:5259:2: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_3_2()); 
            match(input,44,FOLLOW_2); 
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


    // $ANTLR start "rule__Scenario__Group__0"
    // InternalAceGen.g:5269:1: rule__Scenario__Group__0 : rule__Scenario__Group__0__Impl rule__Scenario__Group__1 ;
    public final void rule__Scenario__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5273:1: ( rule__Scenario__Group__0__Impl rule__Scenario__Group__1 )
            // InternalAceGen.g:5274:2: rule__Scenario__Group__0__Impl rule__Scenario__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__Scenario__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Scenario__Group__1();

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
    // $ANTLR end "rule__Scenario__Group__0"


    // $ANTLR start "rule__Scenario__Group__0__Impl"
    // InternalAceGen.g:5281:1: rule__Scenario__Group__0__Impl : ( ( rule__Scenario__NameAssignment_0 ) ) ;
    public final void rule__Scenario__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5285:1: ( ( ( rule__Scenario__NameAssignment_0 ) ) )
            // InternalAceGen.g:5286:1: ( ( rule__Scenario__NameAssignment_0 ) )
            {
            // InternalAceGen.g:5286:1: ( ( rule__Scenario__NameAssignment_0 ) )
            // InternalAceGen.g:5287:2: ( rule__Scenario__NameAssignment_0 )
            {
             before(grammarAccess.getScenarioAccess().getNameAssignment_0()); 
            // InternalAceGen.g:5288:2: ( rule__Scenario__NameAssignment_0 )
            // InternalAceGen.g:5288:3: rule__Scenario__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Scenario__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getScenarioAccess().getNameAssignment_0()); 

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
    // $ANTLR end "rule__Scenario__Group__0__Impl"


    // $ANTLR start "rule__Scenario__Group__1"
    // InternalAceGen.g:5296:1: rule__Scenario__Group__1 : rule__Scenario__Group__1__Impl rule__Scenario__Group__2 ;
    public final void rule__Scenario__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5300:1: ( rule__Scenario__Group__1__Impl rule__Scenario__Group__2 )
            // InternalAceGen.g:5301:2: rule__Scenario__Group__1__Impl rule__Scenario__Group__2
            {
            pushFollow(FOLLOW_44);
            rule__Scenario__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Scenario__Group__2();

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
    // $ANTLR end "rule__Scenario__Group__1"


    // $ANTLR start "rule__Scenario__Group__1__Impl"
    // InternalAceGen.g:5308:1: rule__Scenario__Group__1__Impl : ( ( rule__Scenario__Group_1__0 )? ) ;
    public final void rule__Scenario__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5312:1: ( ( ( rule__Scenario__Group_1__0 )? ) )
            // InternalAceGen.g:5313:1: ( ( rule__Scenario__Group_1__0 )? )
            {
            // InternalAceGen.g:5313:1: ( ( rule__Scenario__Group_1__0 )? )
            // InternalAceGen.g:5314:2: ( rule__Scenario__Group_1__0 )?
            {
             before(grammarAccess.getScenarioAccess().getGroup_1()); 
            // InternalAceGen.g:5315:2: ( rule__Scenario__Group_1__0 )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==57) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalAceGen.g:5315:3: rule__Scenario__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Scenario__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getScenarioAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Scenario__Group__1__Impl"


    // $ANTLR start "rule__Scenario__Group__2"
    // InternalAceGen.g:5323:1: rule__Scenario__Group__2 : rule__Scenario__Group__2__Impl rule__Scenario__Group__3 ;
    public final void rule__Scenario__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5327:1: ( rule__Scenario__Group__2__Impl rule__Scenario__Group__3 )
            // InternalAceGen.g:5328:2: rule__Scenario__Group__2__Impl rule__Scenario__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Scenario__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Scenario__Group__3();

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
    // $ANTLR end "rule__Scenario__Group__2"


    // $ANTLR start "rule__Scenario__Group__2__Impl"
    // InternalAceGen.g:5335:1: rule__Scenario__Group__2__Impl : ( 'WHEN' ) ;
    public final void rule__Scenario__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5339:1: ( ( 'WHEN' ) )
            // InternalAceGen.g:5340:1: ( 'WHEN' )
            {
            // InternalAceGen.g:5340:1: ( 'WHEN' )
            // InternalAceGen.g:5341:2: 'WHEN'
            {
             before(grammarAccess.getScenarioAccess().getWHENKeyword_2()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getScenarioAccess().getWHENKeyword_2()); 

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
    // $ANTLR end "rule__Scenario__Group__2__Impl"


    // $ANTLR start "rule__Scenario__Group__3"
    // InternalAceGen.g:5350:1: rule__Scenario__Group__3 : rule__Scenario__Group__3__Impl rule__Scenario__Group__4 ;
    public final void rule__Scenario__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5354:1: ( rule__Scenario__Group__3__Impl rule__Scenario__Group__4 )
            // InternalAceGen.g:5355:2: rule__Scenario__Group__3__Impl rule__Scenario__Group__4
            {
            pushFollow(FOLLOW_45);
            rule__Scenario__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Scenario__Group__4();

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
    // $ANTLR end "rule__Scenario__Group__3"


    // $ANTLR start "rule__Scenario__Group__3__Impl"
    // InternalAceGen.g:5362:1: rule__Scenario__Group__3__Impl : ( ( rule__Scenario__WhenBlockAssignment_3 ) ) ;
    public final void rule__Scenario__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5366:1: ( ( ( rule__Scenario__WhenBlockAssignment_3 ) ) )
            // InternalAceGen.g:5367:1: ( ( rule__Scenario__WhenBlockAssignment_3 ) )
            {
            // InternalAceGen.g:5367:1: ( ( rule__Scenario__WhenBlockAssignment_3 ) )
            // InternalAceGen.g:5368:2: ( rule__Scenario__WhenBlockAssignment_3 )
            {
             before(grammarAccess.getScenarioAccess().getWhenBlockAssignment_3()); 
            // InternalAceGen.g:5369:2: ( rule__Scenario__WhenBlockAssignment_3 )
            // InternalAceGen.g:5369:3: rule__Scenario__WhenBlockAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Scenario__WhenBlockAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getScenarioAccess().getWhenBlockAssignment_3()); 

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
    // $ANTLR end "rule__Scenario__Group__3__Impl"


    // $ANTLR start "rule__Scenario__Group__4"
    // InternalAceGen.g:5377:1: rule__Scenario__Group__4 : rule__Scenario__Group__4__Impl rule__Scenario__Group__5 ;
    public final void rule__Scenario__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5381:1: ( rule__Scenario__Group__4__Impl rule__Scenario__Group__5 )
            // InternalAceGen.g:5382:2: rule__Scenario__Group__4__Impl rule__Scenario__Group__5
            {
            pushFollow(FOLLOW_46);
            rule__Scenario__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Scenario__Group__5();

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
    // $ANTLR end "rule__Scenario__Group__4"


    // $ANTLR start "rule__Scenario__Group__4__Impl"
    // InternalAceGen.g:5389:1: rule__Scenario__Group__4__Impl : ( 'THEN' ) ;
    public final void rule__Scenario__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5393:1: ( ( 'THEN' ) )
            // InternalAceGen.g:5394:1: ( 'THEN' )
            {
            // InternalAceGen.g:5394:1: ( 'THEN' )
            // InternalAceGen.g:5395:2: 'THEN'
            {
             before(grammarAccess.getScenarioAccess().getTHENKeyword_4()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getScenarioAccess().getTHENKeyword_4()); 

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
    // $ANTLR end "rule__Scenario__Group__4__Impl"


    // $ANTLR start "rule__Scenario__Group__5"
    // InternalAceGen.g:5404:1: rule__Scenario__Group__5 : rule__Scenario__Group__5__Impl ;
    public final void rule__Scenario__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5408:1: ( rule__Scenario__Group__5__Impl )
            // InternalAceGen.g:5409:2: rule__Scenario__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scenario__Group__5__Impl();

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
    // $ANTLR end "rule__Scenario__Group__5"


    // $ANTLR start "rule__Scenario__Group__5__Impl"
    // InternalAceGen.g:5415:1: rule__Scenario__Group__5__Impl : ( ( rule__Scenario__ThenBlockAssignment_5 ) ) ;
    public final void rule__Scenario__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5419:1: ( ( ( rule__Scenario__ThenBlockAssignment_5 ) ) )
            // InternalAceGen.g:5420:1: ( ( rule__Scenario__ThenBlockAssignment_5 ) )
            {
            // InternalAceGen.g:5420:1: ( ( rule__Scenario__ThenBlockAssignment_5 ) )
            // InternalAceGen.g:5421:2: ( rule__Scenario__ThenBlockAssignment_5 )
            {
             before(grammarAccess.getScenarioAccess().getThenBlockAssignment_5()); 
            // InternalAceGen.g:5422:2: ( rule__Scenario__ThenBlockAssignment_5 )
            // InternalAceGen.g:5422:3: rule__Scenario__ThenBlockAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Scenario__ThenBlockAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getScenarioAccess().getThenBlockAssignment_5()); 

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
    // $ANTLR end "rule__Scenario__Group__5__Impl"


    // $ANTLR start "rule__Scenario__Group_1__0"
    // InternalAceGen.g:5431:1: rule__Scenario__Group_1__0 : rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1 ;
    public final void rule__Scenario__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5435:1: ( rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1 )
            // InternalAceGen.g:5436:2: rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__Scenario__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Scenario__Group_1__1();

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
    // $ANTLR end "rule__Scenario__Group_1__0"


    // $ANTLR start "rule__Scenario__Group_1__0__Impl"
    // InternalAceGen.g:5443:1: rule__Scenario__Group_1__0__Impl : ( 'GIVEN' ) ;
    public final void rule__Scenario__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5447:1: ( ( 'GIVEN' ) )
            // InternalAceGen.g:5448:1: ( 'GIVEN' )
            {
            // InternalAceGen.g:5448:1: ( 'GIVEN' )
            // InternalAceGen.g:5449:2: 'GIVEN'
            {
             before(grammarAccess.getScenarioAccess().getGIVENKeyword_1_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getScenarioAccess().getGIVENKeyword_1_0()); 

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
    // $ANTLR end "rule__Scenario__Group_1__0__Impl"


    // $ANTLR start "rule__Scenario__Group_1__1"
    // InternalAceGen.g:5458:1: rule__Scenario__Group_1__1 : rule__Scenario__Group_1__1__Impl ;
    public final void rule__Scenario__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5462:1: ( rule__Scenario__Group_1__1__Impl )
            // InternalAceGen.g:5463:2: rule__Scenario__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Scenario__Group_1__1__Impl();

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
    // $ANTLR end "rule__Scenario__Group_1__1"


    // $ANTLR start "rule__Scenario__Group_1__1__Impl"
    // InternalAceGen.g:5469:1: rule__Scenario__Group_1__1__Impl : ( ( rule__Scenario__GivenRefsAssignment_1_1 )* ) ;
    public final void rule__Scenario__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5473:1: ( ( ( rule__Scenario__GivenRefsAssignment_1_1 )* ) )
            // InternalAceGen.g:5474:1: ( ( rule__Scenario__GivenRefsAssignment_1_1 )* )
            {
            // InternalAceGen.g:5474:1: ( ( rule__Scenario__GivenRefsAssignment_1_1 )* )
            // InternalAceGen.g:5475:2: ( rule__Scenario__GivenRefsAssignment_1_1 )*
            {
             before(grammarAccess.getScenarioAccess().getGivenRefsAssignment_1_1()); 
            // InternalAceGen.g:5476:2: ( rule__Scenario__GivenRefsAssignment_1_1 )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==RULE_ID) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalAceGen.g:5476:3: rule__Scenario__GivenRefsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Scenario__GivenRefsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

             after(grammarAccess.getScenarioAccess().getGivenRefsAssignment_1_1()); 

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
    // $ANTLR end "rule__Scenario__Group_1__1__Impl"


    // $ANTLR start "rule__GivenRef__Group__0"
    // InternalAceGen.g:5485:1: rule__GivenRef__Group__0 : rule__GivenRef__Group__0__Impl rule__GivenRef__Group__1 ;
    public final void rule__GivenRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5489:1: ( rule__GivenRef__Group__0__Impl rule__GivenRef__Group__1 )
            // InternalAceGen.g:5490:2: rule__GivenRef__Group__0__Impl rule__GivenRef__Group__1
            {
            pushFollow(FOLLOW_47);
            rule__GivenRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GivenRef__Group__1();

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
    // $ANTLR end "rule__GivenRef__Group__0"


    // $ANTLR start "rule__GivenRef__Group__0__Impl"
    // InternalAceGen.g:5497:1: rule__GivenRef__Group__0__Impl : ( ( rule__GivenRef__ScenarioAssignment_0 ) ) ;
    public final void rule__GivenRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5501:1: ( ( ( rule__GivenRef__ScenarioAssignment_0 ) ) )
            // InternalAceGen.g:5502:1: ( ( rule__GivenRef__ScenarioAssignment_0 ) )
            {
            // InternalAceGen.g:5502:1: ( ( rule__GivenRef__ScenarioAssignment_0 ) )
            // InternalAceGen.g:5503:2: ( rule__GivenRef__ScenarioAssignment_0 )
            {
             before(grammarAccess.getGivenRefAccess().getScenarioAssignment_0()); 
            // InternalAceGen.g:5504:2: ( rule__GivenRef__ScenarioAssignment_0 )
            // InternalAceGen.g:5504:3: rule__GivenRef__ScenarioAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__GivenRef__ScenarioAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getGivenRefAccess().getScenarioAssignment_0()); 

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
    // $ANTLR end "rule__GivenRef__Group__0__Impl"


    // $ANTLR start "rule__GivenRef__Group__1"
    // InternalAceGen.g:5512:1: rule__GivenRef__Group__1 : rule__GivenRef__Group__1__Impl rule__GivenRef__Group__2 ;
    public final void rule__GivenRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5516:1: ( rule__GivenRef__Group__1__Impl rule__GivenRef__Group__2 )
            // InternalAceGen.g:5517:2: rule__GivenRef__Group__1__Impl rule__GivenRef__Group__2
            {
            pushFollow(FOLLOW_47);
            rule__GivenRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GivenRef__Group__2();

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
    // $ANTLR end "rule__GivenRef__Group__1"


    // $ANTLR start "rule__GivenRef__Group__1__Impl"
    // InternalAceGen.g:5524:1: rule__GivenRef__Group__1__Impl : ( ( rule__GivenRef__Group_1__0 )? ) ;
    public final void rule__GivenRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5528:1: ( ( ( rule__GivenRef__Group_1__0 )? ) )
            // InternalAceGen.g:5529:1: ( ( rule__GivenRef__Group_1__0 )? )
            {
            // InternalAceGen.g:5529:1: ( ( rule__GivenRef__Group_1__0 )? )
            // InternalAceGen.g:5530:2: ( rule__GivenRef__Group_1__0 )?
            {
             before(grammarAccess.getGivenRefAccess().getGroup_1()); 
            // InternalAceGen.g:5531:2: ( rule__GivenRef__Group_1__0 )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_INT) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalAceGen.g:5531:3: rule__GivenRef__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__GivenRef__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGivenRefAccess().getGroup_1()); 

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
    // $ANTLR end "rule__GivenRef__Group__1__Impl"


    // $ANTLR start "rule__GivenRef__Group__2"
    // InternalAceGen.g:5539:1: rule__GivenRef__Group__2 : rule__GivenRef__Group__2__Impl ;
    public final void rule__GivenRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5543:1: ( rule__GivenRef__Group__2__Impl )
            // InternalAceGen.g:5544:2: rule__GivenRef__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GivenRef__Group__2__Impl();

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
    // $ANTLR end "rule__GivenRef__Group__2"


    // $ANTLR start "rule__GivenRef__Group__2__Impl"
    // InternalAceGen.g:5550:1: rule__GivenRef__Group__2__Impl : ( ( rule__GivenRef__ExcludeGivenAssignment_2 )? ) ;
    public final void rule__GivenRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5554:1: ( ( ( rule__GivenRef__ExcludeGivenAssignment_2 )? ) )
            // InternalAceGen.g:5555:1: ( ( rule__GivenRef__ExcludeGivenAssignment_2 )? )
            {
            // InternalAceGen.g:5555:1: ( ( rule__GivenRef__ExcludeGivenAssignment_2 )? )
            // InternalAceGen.g:5556:2: ( rule__GivenRef__ExcludeGivenAssignment_2 )?
            {
             before(grammarAccess.getGivenRefAccess().getExcludeGivenAssignment_2()); 
            // InternalAceGen.g:5557:2: ( rule__GivenRef__ExcludeGivenAssignment_2 )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==75) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalAceGen.g:5557:3: rule__GivenRef__ExcludeGivenAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__GivenRef__ExcludeGivenAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGivenRefAccess().getExcludeGivenAssignment_2()); 

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
    // $ANTLR end "rule__GivenRef__Group__2__Impl"


    // $ANTLR start "rule__GivenRef__Group_1__0"
    // InternalAceGen.g:5566:1: rule__GivenRef__Group_1__0 : rule__GivenRef__Group_1__0__Impl rule__GivenRef__Group_1__1 ;
    public final void rule__GivenRef__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5570:1: ( rule__GivenRef__Group_1__0__Impl rule__GivenRef__Group_1__1 )
            // InternalAceGen.g:5571:2: rule__GivenRef__Group_1__0__Impl rule__GivenRef__Group_1__1
            {
            pushFollow(FOLLOW_48);
            rule__GivenRef__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GivenRef__Group_1__1();

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
    // $ANTLR end "rule__GivenRef__Group_1__0"


    // $ANTLR start "rule__GivenRef__Group_1__0__Impl"
    // InternalAceGen.g:5578:1: rule__GivenRef__Group_1__0__Impl : ( ( rule__GivenRef__TimesAssignment_1_0 ) ) ;
    public final void rule__GivenRef__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5582:1: ( ( ( rule__GivenRef__TimesAssignment_1_0 ) ) )
            // InternalAceGen.g:5583:1: ( ( rule__GivenRef__TimesAssignment_1_0 ) )
            {
            // InternalAceGen.g:5583:1: ( ( rule__GivenRef__TimesAssignment_1_0 ) )
            // InternalAceGen.g:5584:2: ( rule__GivenRef__TimesAssignment_1_0 )
            {
             before(grammarAccess.getGivenRefAccess().getTimesAssignment_1_0()); 
            // InternalAceGen.g:5585:2: ( rule__GivenRef__TimesAssignment_1_0 )
            // InternalAceGen.g:5585:3: rule__GivenRef__TimesAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__GivenRef__TimesAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getGivenRefAccess().getTimesAssignment_1_0()); 

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
    // $ANTLR end "rule__GivenRef__Group_1__0__Impl"


    // $ANTLR start "rule__GivenRef__Group_1__1"
    // InternalAceGen.g:5593:1: rule__GivenRef__Group_1__1 : rule__GivenRef__Group_1__1__Impl ;
    public final void rule__GivenRef__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5597:1: ( rule__GivenRef__Group_1__1__Impl )
            // InternalAceGen.g:5598:2: rule__GivenRef__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GivenRef__Group_1__1__Impl();

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
    // $ANTLR end "rule__GivenRef__Group_1__1"


    // $ANTLR start "rule__GivenRef__Group_1__1__Impl"
    // InternalAceGen.g:5604:1: rule__GivenRef__Group_1__1__Impl : ( 'x' ) ;
    public final void rule__GivenRef__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5608:1: ( ( 'x' ) )
            // InternalAceGen.g:5609:1: ( 'x' )
            {
            // InternalAceGen.g:5609:1: ( 'x' )
            // InternalAceGen.g:5610:2: 'x'
            {
             before(grammarAccess.getGivenRefAccess().getXKeyword_1_1()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getGivenRefAccess().getXKeyword_1_1()); 

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
    // $ANTLR end "rule__GivenRef__Group_1__1__Impl"


    // $ANTLR start "rule__WhenBlock__Group__0"
    // InternalAceGen.g:5620:1: rule__WhenBlock__Group__0 : rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1 ;
    public final void rule__WhenBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5624:1: ( rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1 )
            // InternalAceGen.g:5625:2: rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1
            {
            pushFollow(FOLLOW_49);
            rule__WhenBlock__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WhenBlock__Group__1();

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
    // $ANTLR end "rule__WhenBlock__Group__0"


    // $ANTLR start "rule__WhenBlock__Group__0__Impl"
    // InternalAceGen.g:5632:1: rule__WhenBlock__Group__0__Impl : ( ( rule__WhenBlock__ActionAssignment_0 ) ) ;
    public final void rule__WhenBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5636:1: ( ( ( rule__WhenBlock__ActionAssignment_0 ) ) )
            // InternalAceGen.g:5637:1: ( ( rule__WhenBlock__ActionAssignment_0 ) )
            {
            // InternalAceGen.g:5637:1: ( ( rule__WhenBlock__ActionAssignment_0 ) )
            // InternalAceGen.g:5638:2: ( rule__WhenBlock__ActionAssignment_0 )
            {
             before(grammarAccess.getWhenBlockAccess().getActionAssignment_0()); 
            // InternalAceGen.g:5639:2: ( rule__WhenBlock__ActionAssignment_0 )
            // InternalAceGen.g:5639:3: rule__WhenBlock__ActionAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__WhenBlock__ActionAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getWhenBlockAccess().getActionAssignment_0()); 

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
    // $ANTLR end "rule__WhenBlock__Group__0__Impl"


    // $ANTLR start "rule__WhenBlock__Group__1"
    // InternalAceGen.g:5647:1: rule__WhenBlock__Group__1 : rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2 ;
    public final void rule__WhenBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5651:1: ( rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2 )
            // InternalAceGen.g:5652:2: rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2
            {
            pushFollow(FOLLOW_50);
            rule__WhenBlock__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WhenBlock__Group__2();

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
    // $ANTLR end "rule__WhenBlock__Group__1"


    // $ANTLR start "rule__WhenBlock__Group__1__Impl"
    // InternalAceGen.g:5659:1: rule__WhenBlock__Group__1__Impl : ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) ) ;
    public final void rule__WhenBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5663:1: ( ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) ) )
            // InternalAceGen.g:5664:1: ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) )
            {
            // InternalAceGen.g:5664:1: ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) )
            // InternalAceGen.g:5665:2: ( rule__WhenBlock__DataDefinitionAssignment_1 )
            {
             before(grammarAccess.getWhenBlockAccess().getDataDefinitionAssignment_1()); 
            // InternalAceGen.g:5666:2: ( rule__WhenBlock__DataDefinitionAssignment_1 )
            // InternalAceGen.g:5666:3: rule__WhenBlock__DataDefinitionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__WhenBlock__DataDefinitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWhenBlockAccess().getDataDefinitionAssignment_1()); 

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
    // $ANTLR end "rule__WhenBlock__Group__1__Impl"


    // $ANTLR start "rule__WhenBlock__Group__2"
    // InternalAceGen.g:5674:1: rule__WhenBlock__Group__2 : rule__WhenBlock__Group__2__Impl ;
    public final void rule__WhenBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5678:1: ( rule__WhenBlock__Group__2__Impl )
            // InternalAceGen.g:5679:2: rule__WhenBlock__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WhenBlock__Group__2__Impl();

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
    // $ANTLR end "rule__WhenBlock__Group__2"


    // $ANTLR start "rule__WhenBlock__Group__2__Impl"
    // InternalAceGen.g:5685:1: rule__WhenBlock__Group__2__Impl : ( ( rule__WhenBlock__AuthorizationAssignment_2 )? ) ;
    public final void rule__WhenBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5689:1: ( ( ( rule__WhenBlock__AuthorizationAssignment_2 )? ) )
            // InternalAceGen.g:5690:1: ( ( rule__WhenBlock__AuthorizationAssignment_2 )? )
            {
            // InternalAceGen.g:5690:1: ( ( rule__WhenBlock__AuthorizationAssignment_2 )? )
            // InternalAceGen.g:5691:2: ( rule__WhenBlock__AuthorizationAssignment_2 )?
            {
             before(grammarAccess.getWhenBlockAccess().getAuthorizationAssignment_2()); 
            // InternalAceGen.g:5692:2: ( rule__WhenBlock__AuthorizationAssignment_2 )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==61) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalAceGen.g:5692:3: rule__WhenBlock__AuthorizationAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__WhenBlock__AuthorizationAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getWhenBlockAccess().getAuthorizationAssignment_2()); 

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
    // $ANTLR end "rule__WhenBlock__Group__2__Impl"


    // $ANTLR start "rule__ThenBlock__Group__0"
    // InternalAceGen.g:5701:1: rule__ThenBlock__Group__0 : rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1 ;
    public final void rule__ThenBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5705:1: ( rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1 )
            // InternalAceGen.g:5706:2: rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__ThenBlock__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ThenBlock__Group__1();

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
    // $ANTLR end "rule__ThenBlock__Group__0"


    // $ANTLR start "rule__ThenBlock__Group__0__Impl"
    // InternalAceGen.g:5713:1: rule__ThenBlock__Group__0__Impl : ( ( rule__ThenBlock__StatusCodeAssignment_0 ) ) ;
    public final void rule__ThenBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5717:1: ( ( ( rule__ThenBlock__StatusCodeAssignment_0 ) ) )
            // InternalAceGen.g:5718:1: ( ( rule__ThenBlock__StatusCodeAssignment_0 ) )
            {
            // InternalAceGen.g:5718:1: ( ( rule__ThenBlock__StatusCodeAssignment_0 ) )
            // InternalAceGen.g:5719:2: ( rule__ThenBlock__StatusCodeAssignment_0 )
            {
             before(grammarAccess.getThenBlockAccess().getStatusCodeAssignment_0()); 
            // InternalAceGen.g:5720:2: ( rule__ThenBlock__StatusCodeAssignment_0 )
            // InternalAceGen.g:5720:3: rule__ThenBlock__StatusCodeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ThenBlock__StatusCodeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getThenBlockAccess().getStatusCodeAssignment_0()); 

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
    // $ANTLR end "rule__ThenBlock__Group__0__Impl"


    // $ANTLR start "rule__ThenBlock__Group__1"
    // InternalAceGen.g:5728:1: rule__ThenBlock__Group__1 : rule__ThenBlock__Group__1__Impl ;
    public final void rule__ThenBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5732:1: ( rule__ThenBlock__Group__1__Impl )
            // InternalAceGen.g:5733:2: rule__ThenBlock__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ThenBlock__Group__1__Impl();

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
    // $ANTLR end "rule__ThenBlock__Group__1"


    // $ANTLR start "rule__ThenBlock__Group__1__Impl"
    // InternalAceGen.g:5739:1: rule__ThenBlock__Group__1__Impl : ( ( rule__ThenBlock__Group_1__0 )? ) ;
    public final void rule__ThenBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5743:1: ( ( ( rule__ThenBlock__Group_1__0 )? ) )
            // InternalAceGen.g:5744:1: ( ( rule__ThenBlock__Group_1__0 )? )
            {
            // InternalAceGen.g:5744:1: ( ( rule__ThenBlock__Group_1__0 )? )
            // InternalAceGen.g:5745:2: ( rule__ThenBlock__Group_1__0 )?
            {
             before(grammarAccess.getThenBlockAccess().getGroup_1()); 
            // InternalAceGen.g:5746:2: ( rule__ThenBlock__Group_1__0 )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==53) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalAceGen.g:5746:3: rule__ThenBlock__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ThenBlock__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getThenBlockAccess().getGroup_1()); 

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
    // $ANTLR end "rule__ThenBlock__Group__1__Impl"


    // $ANTLR start "rule__ThenBlock__Group_1__0"
    // InternalAceGen.g:5755:1: rule__ThenBlock__Group_1__0 : rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1 ;
    public final void rule__ThenBlock__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5759:1: ( rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1 )
            // InternalAceGen.g:5760:2: rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1
            {
            pushFollow(FOLLOW_49);
            rule__ThenBlock__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ThenBlock__Group_1__1();

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
    // $ANTLR end "rule__ThenBlock__Group_1__0"


    // $ANTLR start "rule__ThenBlock__Group_1__0__Impl"
    // InternalAceGen.g:5767:1: rule__ThenBlock__Group_1__0__Impl : ( 'response' ) ;
    public final void rule__ThenBlock__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5771:1: ( ( 'response' ) )
            // InternalAceGen.g:5772:1: ( 'response' )
            {
            // InternalAceGen.g:5772:1: ( 'response' )
            // InternalAceGen.g:5773:2: 'response'
            {
             before(grammarAccess.getThenBlockAccess().getResponseKeyword_1_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getThenBlockAccess().getResponseKeyword_1_0()); 

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
    // $ANTLR end "rule__ThenBlock__Group_1__0__Impl"


    // $ANTLR start "rule__ThenBlock__Group_1__1"
    // InternalAceGen.g:5782:1: rule__ThenBlock__Group_1__1 : rule__ThenBlock__Group_1__1__Impl ;
    public final void rule__ThenBlock__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5786:1: ( rule__ThenBlock__Group_1__1__Impl )
            // InternalAceGen.g:5787:2: rule__ThenBlock__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ThenBlock__Group_1__1__Impl();

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
    // $ANTLR end "rule__ThenBlock__Group_1__1"


    // $ANTLR start "rule__ThenBlock__Group_1__1__Impl"
    // InternalAceGen.g:5793:1: rule__ThenBlock__Group_1__1__Impl : ( ( rule__ThenBlock__ResponseAssignment_1_1 ) ) ;
    public final void rule__ThenBlock__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5797:1: ( ( ( rule__ThenBlock__ResponseAssignment_1_1 ) ) )
            // InternalAceGen.g:5798:1: ( ( rule__ThenBlock__ResponseAssignment_1_1 ) )
            {
            // InternalAceGen.g:5798:1: ( ( rule__ThenBlock__ResponseAssignment_1_1 ) )
            // InternalAceGen.g:5799:2: ( rule__ThenBlock__ResponseAssignment_1_1 )
            {
             before(grammarAccess.getThenBlockAccess().getResponseAssignment_1_1()); 
            // InternalAceGen.g:5800:2: ( rule__ThenBlock__ResponseAssignment_1_1 )
            // InternalAceGen.g:5800:3: rule__ThenBlock__ResponseAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ThenBlock__ResponseAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getThenBlockAccess().getResponseAssignment_1_1()); 

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
    // $ANTLR end "rule__ThenBlock__Group_1__1__Impl"


    // $ANTLR start "rule__DataDefinition__Group__0"
    // InternalAceGen.g:5809:1: rule__DataDefinition__Group__0 : rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1 ;
    public final void rule__DataDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5813:1: ( rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1 )
            // InternalAceGen.g:5814:2: rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1
            {
            pushFollow(FOLLOW_49);
            rule__DataDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataDefinition__Group__1();

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
    // $ANTLR end "rule__DataDefinition__Group__0"


    // $ANTLR start "rule__DataDefinition__Group__0__Impl"
    // InternalAceGen.g:5821:1: rule__DataDefinition__Group__0__Impl : ( () ) ;
    public final void rule__DataDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5825:1: ( ( () ) )
            // InternalAceGen.g:5826:1: ( () )
            {
            // InternalAceGen.g:5826:1: ( () )
            // InternalAceGen.g:5827:2: ()
            {
             before(grammarAccess.getDataDefinitionAccess().getDataDefinitionAction_0()); 
            // InternalAceGen.g:5828:2: ()
            // InternalAceGen.g:5828:3: 
            {
            }

             after(grammarAccess.getDataDefinitionAccess().getDataDefinitionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataDefinition__Group__0__Impl"


    // $ANTLR start "rule__DataDefinition__Group__1"
    // InternalAceGen.g:5836:1: rule__DataDefinition__Group__1 : rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2 ;
    public final void rule__DataDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5840:1: ( rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2 )
            // InternalAceGen.g:5841:2: rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2
            {
            pushFollow(FOLLOW_49);
            rule__DataDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataDefinition__Group__2();

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
    // $ANTLR end "rule__DataDefinition__Group__1"


    // $ANTLR start "rule__DataDefinition__Group__1__Impl"
    // InternalAceGen.g:5848:1: rule__DataDefinition__Group__1__Impl : ( ( rule__DataDefinition__Group_1__0 )? ) ;
    public final void rule__DataDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5852:1: ( ( ( rule__DataDefinition__Group_1__0 )? ) )
            // InternalAceGen.g:5853:1: ( ( rule__DataDefinition__Group_1__0 )? )
            {
            // InternalAceGen.g:5853:1: ( ( rule__DataDefinition__Group_1__0 )? )
            // InternalAceGen.g:5854:2: ( rule__DataDefinition__Group_1__0 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getGroup_1()); 
            // InternalAceGen.g:5855:2: ( rule__DataDefinition__Group_1__0 )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==59) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalAceGen.g:5855:3: rule__DataDefinition__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataDefinition__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataDefinitionAccess().getGroup_1()); 

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
    // $ANTLR end "rule__DataDefinition__Group__1__Impl"


    // $ANTLR start "rule__DataDefinition__Group__2"
    // InternalAceGen.g:5863:1: rule__DataDefinition__Group__2 : rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3 ;
    public final void rule__DataDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5867:1: ( rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3 )
            // InternalAceGen.g:5868:2: rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3
            {
            pushFollow(FOLLOW_49);
            rule__DataDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataDefinition__Group__3();

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
    // $ANTLR end "rule__DataDefinition__Group__2"


    // $ANTLR start "rule__DataDefinition__Group__2__Impl"
    // InternalAceGen.g:5875:1: rule__DataDefinition__Group__2__Impl : ( ( rule__DataDefinition__Group_2__0 )? ) ;
    public final void rule__DataDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5879:1: ( ( ( rule__DataDefinition__Group_2__0 )? ) )
            // InternalAceGen.g:5880:1: ( ( rule__DataDefinition__Group_2__0 )? )
            {
            // InternalAceGen.g:5880:1: ( ( rule__DataDefinition__Group_2__0 )? )
            // InternalAceGen.g:5881:2: ( rule__DataDefinition__Group_2__0 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getGroup_2()); 
            // InternalAceGen.g:5882:2: ( rule__DataDefinition__Group_2__0 )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==60) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalAceGen.g:5882:3: rule__DataDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataDefinition__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataDefinitionAccess().getGroup_2()); 

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
    // $ANTLR end "rule__DataDefinition__Group__2__Impl"


    // $ANTLR start "rule__DataDefinition__Group__3"
    // InternalAceGen.g:5890:1: rule__DataDefinition__Group__3 : rule__DataDefinition__Group__3__Impl ;
    public final void rule__DataDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5894:1: ( rule__DataDefinition__Group__3__Impl )
            // InternalAceGen.g:5895:2: rule__DataDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataDefinition__Group__3__Impl();

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
    // $ANTLR end "rule__DataDefinition__Group__3"


    // $ANTLR start "rule__DataDefinition__Group__3__Impl"
    // InternalAceGen.g:5901:1: rule__DataDefinition__Group__3__Impl : ( ( rule__DataDefinition__DataAssignment_3 )? ) ;
    public final void rule__DataDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5905:1: ( ( ( rule__DataDefinition__DataAssignment_3 )? ) )
            // InternalAceGen.g:5906:1: ( ( rule__DataDefinition__DataAssignment_3 )? )
            {
            // InternalAceGen.g:5906:1: ( ( rule__DataDefinition__DataAssignment_3 )? )
            // InternalAceGen.g:5907:2: ( rule__DataDefinition__DataAssignment_3 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getDataAssignment_3()); 
            // InternalAceGen.g:5908:2: ( rule__DataDefinition__DataAssignment_3 )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==43) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalAceGen.g:5908:3: rule__DataDefinition__DataAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__DataDefinition__DataAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDataDefinitionAccess().getDataAssignment_3()); 

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
    // $ANTLR end "rule__DataDefinition__Group__3__Impl"


    // $ANTLR start "rule__DataDefinition__Group_1__0"
    // InternalAceGen.g:5917:1: rule__DataDefinition__Group_1__0 : rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1 ;
    public final void rule__DataDefinition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5921:1: ( rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1 )
            // InternalAceGen.g:5922:2: rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1
            {
            pushFollow(FOLLOW_33);
            rule__DataDefinition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataDefinition__Group_1__1();

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
    // $ANTLR end "rule__DataDefinition__Group_1__0"


    // $ANTLR start "rule__DataDefinition__Group_1__0__Impl"
    // InternalAceGen.g:5929:1: rule__DataDefinition__Group_1__0__Impl : ( 'uuid' ) ;
    public final void rule__DataDefinition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5933:1: ( ( 'uuid' ) )
            // InternalAceGen.g:5934:1: ( 'uuid' )
            {
            // InternalAceGen.g:5934:1: ( 'uuid' )
            // InternalAceGen.g:5935:2: 'uuid'
            {
             before(grammarAccess.getDataDefinitionAccess().getUuidKeyword_1_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getDataDefinitionAccess().getUuidKeyword_1_0()); 

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
    // $ANTLR end "rule__DataDefinition__Group_1__0__Impl"


    // $ANTLR start "rule__DataDefinition__Group_1__1"
    // InternalAceGen.g:5944:1: rule__DataDefinition__Group_1__1 : rule__DataDefinition__Group_1__1__Impl ;
    public final void rule__DataDefinition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5948:1: ( rule__DataDefinition__Group_1__1__Impl )
            // InternalAceGen.g:5949:2: rule__DataDefinition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataDefinition__Group_1__1__Impl();

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
    // $ANTLR end "rule__DataDefinition__Group_1__1"


    // $ANTLR start "rule__DataDefinition__Group_1__1__Impl"
    // InternalAceGen.g:5955:1: rule__DataDefinition__Group_1__1__Impl : ( ( rule__DataDefinition__UuidAssignment_1_1 ) ) ;
    public final void rule__DataDefinition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5959:1: ( ( ( rule__DataDefinition__UuidAssignment_1_1 ) ) )
            // InternalAceGen.g:5960:1: ( ( rule__DataDefinition__UuidAssignment_1_1 ) )
            {
            // InternalAceGen.g:5960:1: ( ( rule__DataDefinition__UuidAssignment_1_1 ) )
            // InternalAceGen.g:5961:2: ( rule__DataDefinition__UuidAssignment_1_1 )
            {
             before(grammarAccess.getDataDefinitionAccess().getUuidAssignment_1_1()); 
            // InternalAceGen.g:5962:2: ( rule__DataDefinition__UuidAssignment_1_1 )
            // InternalAceGen.g:5962:3: rule__DataDefinition__UuidAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DataDefinition__UuidAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDataDefinitionAccess().getUuidAssignment_1_1()); 

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
    // $ANTLR end "rule__DataDefinition__Group_1__1__Impl"


    // $ANTLR start "rule__DataDefinition__Group_2__0"
    // InternalAceGen.g:5971:1: rule__DataDefinition__Group_2__0 : rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1 ;
    public final void rule__DataDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5975:1: ( rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1 )
            // InternalAceGen.g:5976:2: rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1
            {
            pushFollow(FOLLOW_33);
            rule__DataDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataDefinition__Group_2__1();

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
    // $ANTLR end "rule__DataDefinition__Group_2__0"


    // $ANTLR start "rule__DataDefinition__Group_2__0__Impl"
    // InternalAceGen.g:5983:1: rule__DataDefinition__Group_2__0__Impl : ( 'systemTime' ) ;
    public final void rule__DataDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5987:1: ( ( 'systemTime' ) )
            // InternalAceGen.g:5988:1: ( 'systemTime' )
            {
            // InternalAceGen.g:5988:1: ( 'systemTime' )
            // InternalAceGen.g:5989:2: 'systemTime'
            {
             before(grammarAccess.getDataDefinitionAccess().getSystemTimeKeyword_2_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getDataDefinitionAccess().getSystemTimeKeyword_2_0()); 

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
    // $ANTLR end "rule__DataDefinition__Group_2__0__Impl"


    // $ANTLR start "rule__DataDefinition__Group_2__1"
    // InternalAceGen.g:5998:1: rule__DataDefinition__Group_2__1 : rule__DataDefinition__Group_2__1__Impl rule__DataDefinition__Group_2__2 ;
    public final void rule__DataDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6002:1: ( rule__DataDefinition__Group_2__1__Impl rule__DataDefinition__Group_2__2 )
            // InternalAceGen.g:6003:2: rule__DataDefinition__Group_2__1__Impl rule__DataDefinition__Group_2__2
            {
            pushFollow(FOLLOW_33);
            rule__DataDefinition__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DataDefinition__Group_2__2();

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
    // $ANTLR end "rule__DataDefinition__Group_2__1"


    // $ANTLR start "rule__DataDefinition__Group_2__1__Impl"
    // InternalAceGen.g:6010:1: rule__DataDefinition__Group_2__1__Impl : ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) ) ;
    public final void rule__DataDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6014:1: ( ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) ) )
            // InternalAceGen.g:6015:1: ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) )
            {
            // InternalAceGen.g:6015:1: ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) )
            // InternalAceGen.g:6016:2: ( rule__DataDefinition__SystemtimeAssignment_2_1 )
            {
             before(grammarAccess.getDataDefinitionAccess().getSystemtimeAssignment_2_1()); 
            // InternalAceGen.g:6017:2: ( rule__DataDefinition__SystemtimeAssignment_2_1 )
            // InternalAceGen.g:6017:3: rule__DataDefinition__SystemtimeAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__DataDefinition__SystemtimeAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDataDefinitionAccess().getSystemtimeAssignment_2_1()); 

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
    // $ANTLR end "rule__DataDefinition__Group_2__1__Impl"


    // $ANTLR start "rule__DataDefinition__Group_2__2"
    // InternalAceGen.g:6025:1: rule__DataDefinition__Group_2__2 : rule__DataDefinition__Group_2__2__Impl ;
    public final void rule__DataDefinition__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6029:1: ( rule__DataDefinition__Group_2__2__Impl )
            // InternalAceGen.g:6030:2: rule__DataDefinition__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataDefinition__Group_2__2__Impl();

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
    // $ANTLR end "rule__DataDefinition__Group_2__2"


    // $ANTLR start "rule__DataDefinition__Group_2__2__Impl"
    // InternalAceGen.g:6036:1: rule__DataDefinition__Group_2__2__Impl : ( ( rule__DataDefinition__PatternAssignment_2_2 ) ) ;
    public final void rule__DataDefinition__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6040:1: ( ( ( rule__DataDefinition__PatternAssignment_2_2 ) ) )
            // InternalAceGen.g:6041:1: ( ( rule__DataDefinition__PatternAssignment_2_2 ) )
            {
            // InternalAceGen.g:6041:1: ( ( rule__DataDefinition__PatternAssignment_2_2 ) )
            // InternalAceGen.g:6042:2: ( rule__DataDefinition__PatternAssignment_2_2 )
            {
             before(grammarAccess.getDataDefinitionAccess().getPatternAssignment_2_2()); 
            // InternalAceGen.g:6043:2: ( rule__DataDefinition__PatternAssignment_2_2 )
            // InternalAceGen.g:6043:3: rule__DataDefinition__PatternAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__DataDefinition__PatternAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getDataDefinitionAccess().getPatternAssignment_2_2()); 

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
    // $ANTLR end "rule__DataDefinition__Group_2__2__Impl"


    // $ANTLR start "rule__Authorization__Group__0"
    // InternalAceGen.g:6052:1: rule__Authorization__Group__0 : rule__Authorization__Group__0__Impl rule__Authorization__Group__1 ;
    public final void rule__Authorization__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6056:1: ( rule__Authorization__Group__0__Impl rule__Authorization__Group__1 )
            // InternalAceGen.g:6057:2: rule__Authorization__Group__0__Impl rule__Authorization__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__Authorization__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Authorization__Group__1();

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
    // $ANTLR end "rule__Authorization__Group__0"


    // $ANTLR start "rule__Authorization__Group__0__Impl"
    // InternalAceGen.g:6064:1: rule__Authorization__Group__0__Impl : ( 'authorization' ) ;
    public final void rule__Authorization__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6068:1: ( ( 'authorization' ) )
            // InternalAceGen.g:6069:1: ( 'authorization' )
            {
            // InternalAceGen.g:6069:1: ( 'authorization' )
            // InternalAceGen.g:6070:2: 'authorization'
            {
             before(grammarAccess.getAuthorizationAccess().getAuthorizationKeyword_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getAuthorizationAccess().getAuthorizationKeyword_0()); 

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
    // $ANTLR end "rule__Authorization__Group__0__Impl"


    // $ANTLR start "rule__Authorization__Group__1"
    // InternalAceGen.g:6079:1: rule__Authorization__Group__1 : rule__Authorization__Group__1__Impl rule__Authorization__Group__2 ;
    public final void rule__Authorization__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6083:1: ( rule__Authorization__Group__1__Impl rule__Authorization__Group__2 )
            // InternalAceGen.g:6084:2: rule__Authorization__Group__1__Impl rule__Authorization__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__Authorization__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Authorization__Group__2();

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
    // $ANTLR end "rule__Authorization__Group__1"


    // $ANTLR start "rule__Authorization__Group__1__Impl"
    // InternalAceGen.g:6091:1: rule__Authorization__Group__1__Impl : ( ( rule__Authorization__UsernameAssignment_1 ) ) ;
    public final void rule__Authorization__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6095:1: ( ( ( rule__Authorization__UsernameAssignment_1 ) ) )
            // InternalAceGen.g:6096:1: ( ( rule__Authorization__UsernameAssignment_1 ) )
            {
            // InternalAceGen.g:6096:1: ( ( rule__Authorization__UsernameAssignment_1 ) )
            // InternalAceGen.g:6097:2: ( rule__Authorization__UsernameAssignment_1 )
            {
             before(grammarAccess.getAuthorizationAccess().getUsernameAssignment_1()); 
            // InternalAceGen.g:6098:2: ( rule__Authorization__UsernameAssignment_1 )
            // InternalAceGen.g:6098:3: rule__Authorization__UsernameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Authorization__UsernameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAuthorizationAccess().getUsernameAssignment_1()); 

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
    // $ANTLR end "rule__Authorization__Group__1__Impl"


    // $ANTLR start "rule__Authorization__Group__2"
    // InternalAceGen.g:6106:1: rule__Authorization__Group__2 : rule__Authorization__Group__2__Impl rule__Authorization__Group__3 ;
    public final void rule__Authorization__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6110:1: ( rule__Authorization__Group__2__Impl rule__Authorization__Group__3 )
            // InternalAceGen.g:6111:2: rule__Authorization__Group__2__Impl rule__Authorization__Group__3
            {
            pushFollow(FOLLOW_33);
            rule__Authorization__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Authorization__Group__3();

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
    // $ANTLR end "rule__Authorization__Group__2"


    // $ANTLR start "rule__Authorization__Group__2__Impl"
    // InternalAceGen.g:6118:1: rule__Authorization__Group__2__Impl : ( ':' ) ;
    public final void rule__Authorization__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6122:1: ( ( ':' ) )
            // InternalAceGen.g:6123:1: ( ':' )
            {
            // InternalAceGen.g:6123:1: ( ':' )
            // InternalAceGen.g:6124:2: ':'
            {
             before(grammarAccess.getAuthorizationAccess().getColonKeyword_2()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getAuthorizationAccess().getColonKeyword_2()); 

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
    // $ANTLR end "rule__Authorization__Group__2__Impl"


    // $ANTLR start "rule__Authorization__Group__3"
    // InternalAceGen.g:6133:1: rule__Authorization__Group__3 : rule__Authorization__Group__3__Impl ;
    public final void rule__Authorization__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6137:1: ( rule__Authorization__Group__3__Impl )
            // InternalAceGen.g:6138:2: rule__Authorization__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Authorization__Group__3__Impl();

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
    // $ANTLR end "rule__Authorization__Group__3"


    // $ANTLR start "rule__Authorization__Group__3__Impl"
    // InternalAceGen.g:6144:1: rule__Authorization__Group__3__Impl : ( ( rule__Authorization__PasswordAssignment_3 ) ) ;
    public final void rule__Authorization__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6148:1: ( ( ( rule__Authorization__PasswordAssignment_3 ) ) )
            // InternalAceGen.g:6149:1: ( ( rule__Authorization__PasswordAssignment_3 ) )
            {
            // InternalAceGen.g:6149:1: ( ( rule__Authorization__PasswordAssignment_3 ) )
            // InternalAceGen.g:6150:2: ( rule__Authorization__PasswordAssignment_3 )
            {
             before(grammarAccess.getAuthorizationAccess().getPasswordAssignment_3()); 
            // InternalAceGen.g:6151:2: ( rule__Authorization__PasswordAssignment_3 )
            // InternalAceGen.g:6151:3: rule__Authorization__PasswordAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Authorization__PasswordAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAuthorizationAccess().getPasswordAssignment_3()); 

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
    // $ANTLR end "rule__Authorization__Group__3__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalAceGen.g:6160:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6164:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalAceGen.g:6165:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_52);
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
    // InternalAceGen.g:6172:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__UniqueAssignment_0 )? ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6176:1: ( ( ( rule__Attribute__UniqueAssignment_0 )? ) )
            // InternalAceGen.g:6177:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            {
            // InternalAceGen.g:6177:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            // InternalAceGen.g:6178:2: ( rule__Attribute__UniqueAssignment_0 )?
            {
             before(grammarAccess.getAttributeAccess().getUniqueAssignment_0()); 
            // InternalAceGen.g:6179:2: ( rule__Attribute__UniqueAssignment_0 )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==76) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalAceGen.g:6179:3: rule__Attribute__UniqueAssignment_0
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
    // InternalAceGen.g:6187:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6191:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalAceGen.g:6192:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FOLLOW_52);
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
    // InternalAceGen.g:6199:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__PrimaryKeyAssignment_1 )? ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6203:1: ( ( ( rule__Attribute__PrimaryKeyAssignment_1 )? ) )
            // InternalAceGen.g:6204:1: ( ( rule__Attribute__PrimaryKeyAssignment_1 )? )
            {
            // InternalAceGen.g:6204:1: ( ( rule__Attribute__PrimaryKeyAssignment_1 )? )
            // InternalAceGen.g:6205:2: ( rule__Attribute__PrimaryKeyAssignment_1 )?
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyAssignment_1()); 
            // InternalAceGen.g:6206:2: ( rule__Attribute__PrimaryKeyAssignment_1 )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==77) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalAceGen.g:6206:3: rule__Attribute__PrimaryKeyAssignment_1
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
    // InternalAceGen.g:6214:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6218:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // InternalAceGen.g:6219:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
            {
            pushFollow(FOLLOW_52);
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
    // InternalAceGen.g:6226:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__NotNullAssignment_2 )? ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6230:1: ( ( ( rule__Attribute__NotNullAssignment_2 )? ) )
            // InternalAceGen.g:6231:1: ( ( rule__Attribute__NotNullAssignment_2 )? )
            {
            // InternalAceGen.g:6231:1: ( ( rule__Attribute__NotNullAssignment_2 )? )
            // InternalAceGen.g:6232:2: ( rule__Attribute__NotNullAssignment_2 )?
            {
             before(grammarAccess.getAttributeAccess().getNotNullAssignment_2()); 
            // InternalAceGen.g:6233:2: ( rule__Attribute__NotNullAssignment_2 )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==78) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalAceGen.g:6233:3: rule__Attribute__NotNullAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__NotNullAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getNotNullAssignment_2()); 

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
    // InternalAceGen.g:6241:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl rule__Attribute__Group__4 ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6245:1: ( rule__Attribute__Group__3__Impl rule__Attribute__Group__4 )
            // InternalAceGen.g:6246:2: rule__Attribute__Group__3__Impl rule__Attribute__Group__4
            {
            pushFollow(FOLLOW_52);
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
    // InternalAceGen.g:6253:1: rule__Attribute__Group__3__Impl : ( ( rule__Attribute__ListAssignment_3 )? ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6257:1: ( ( ( rule__Attribute__ListAssignment_3 )? ) )
            // InternalAceGen.g:6258:1: ( ( rule__Attribute__ListAssignment_3 )? )
            {
            // InternalAceGen.g:6258:1: ( ( rule__Attribute__ListAssignment_3 )? )
            // InternalAceGen.g:6259:2: ( rule__Attribute__ListAssignment_3 )?
            {
             before(grammarAccess.getAttributeAccess().getListAssignment_3()); 
            // InternalAceGen.g:6260:2: ( rule__Attribute__ListAssignment_3 )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==79) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalAceGen.g:6260:3: rule__Attribute__ListAssignment_3
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
    // InternalAceGen.g:6268:1: rule__Attribute__Group__4 : rule__Attribute__Group__4__Impl rule__Attribute__Group__5 ;
    public final void rule__Attribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6272:1: ( rule__Attribute__Group__4__Impl rule__Attribute__Group__5 )
            // InternalAceGen.g:6273:2: rule__Attribute__Group__4__Impl rule__Attribute__Group__5
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
    // InternalAceGen.g:6280:1: rule__Attribute__Group__4__Impl : ( ( rule__Attribute__Alternatives_4 ) ) ;
    public final void rule__Attribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6284:1: ( ( ( rule__Attribute__Alternatives_4 ) ) )
            // InternalAceGen.g:6285:1: ( ( rule__Attribute__Alternatives_4 ) )
            {
            // InternalAceGen.g:6285:1: ( ( rule__Attribute__Alternatives_4 ) )
            // InternalAceGen.g:6286:2: ( rule__Attribute__Alternatives_4 )
            {
             before(grammarAccess.getAttributeAccess().getAlternatives_4()); 
            // InternalAceGen.g:6287:2: ( rule__Attribute__Alternatives_4 )
            // InternalAceGen.g:6287:3: rule__Attribute__Alternatives_4
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
    // InternalAceGen.g:6295:1: rule__Attribute__Group__5 : rule__Attribute__Group__5__Impl rule__Attribute__Group__6 ;
    public final void rule__Attribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6299:1: ( rule__Attribute__Group__5__Impl rule__Attribute__Group__6 )
            // InternalAceGen.g:6300:2: rule__Attribute__Group__5__Impl rule__Attribute__Group__6
            {
            pushFollow(FOLLOW_53);
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
    // InternalAceGen.g:6307:1: rule__Attribute__Group__5__Impl : ( ( rule__Attribute__NameAssignment_5 ) ) ;
    public final void rule__Attribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6311:1: ( ( ( rule__Attribute__NameAssignment_5 ) ) )
            // InternalAceGen.g:6312:1: ( ( rule__Attribute__NameAssignment_5 ) )
            {
            // InternalAceGen.g:6312:1: ( ( rule__Attribute__NameAssignment_5 ) )
            // InternalAceGen.g:6313:2: ( rule__Attribute__NameAssignment_5 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_5()); 
            // InternalAceGen.g:6314:2: ( rule__Attribute__NameAssignment_5 )
            // InternalAceGen.g:6314:3: rule__Attribute__NameAssignment_5
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
    // InternalAceGen.g:6322:1: rule__Attribute__Group__6 : rule__Attribute__Group__6__Impl rule__Attribute__Group__7 ;
    public final void rule__Attribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6326:1: ( rule__Attribute__Group__6__Impl rule__Attribute__Group__7 )
            // InternalAceGen.g:6327:2: rule__Attribute__Group__6__Impl rule__Attribute__Group__7
            {
            pushFollow(FOLLOW_53);
            rule__Attribute__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__7();

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
    // InternalAceGen.g:6334:1: rule__Attribute__Group__6__Impl : ( ( rule__Attribute__Group_6__0 )? ) ;
    public final void rule__Attribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6338:1: ( ( ( rule__Attribute__Group_6__0 )? ) )
            // InternalAceGen.g:6339:1: ( ( rule__Attribute__Group_6__0 )? )
            {
            // InternalAceGen.g:6339:1: ( ( rule__Attribute__Group_6__0 )? )
            // InternalAceGen.g:6340:2: ( rule__Attribute__Group_6__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_6()); 
            // InternalAceGen.g:6341:2: ( rule__Attribute__Group_6__0 )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==62) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalAceGen.g:6341:3: rule__Attribute__Group_6__0
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


    // $ANTLR start "rule__Attribute__Group__7"
    // InternalAceGen.g:6349:1: rule__Attribute__Group__7 : rule__Attribute__Group__7__Impl ;
    public final void rule__Attribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6353:1: ( rule__Attribute__Group__7__Impl )
            // InternalAceGen.g:6354:2: rule__Attribute__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__7__Impl();

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
    // $ANTLR end "rule__Attribute__Group__7"


    // $ANTLR start "rule__Attribute__Group__7__Impl"
    // InternalAceGen.g:6360:1: rule__Attribute__Group__7__Impl : ( ( rule__Attribute__NotReplayableAssignment_7 )? ) ;
    public final void rule__Attribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6364:1: ( ( ( rule__Attribute__NotReplayableAssignment_7 )? ) )
            // InternalAceGen.g:6365:1: ( ( rule__Attribute__NotReplayableAssignment_7 )? )
            {
            // InternalAceGen.g:6365:1: ( ( rule__Attribute__NotReplayableAssignment_7 )? )
            // InternalAceGen.g:6366:2: ( rule__Attribute__NotReplayableAssignment_7 )?
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableAssignment_7()); 
            // InternalAceGen.g:6367:2: ( rule__Attribute__NotReplayableAssignment_7 )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==80) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalAceGen.g:6367:3: rule__Attribute__NotReplayableAssignment_7
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__NotReplayableAssignment_7();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getNotReplayableAssignment_7()); 

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
    // $ANTLR end "rule__Attribute__Group__7__Impl"


    // $ANTLR start "rule__Attribute__Group_6__0"
    // InternalAceGen.g:6376:1: rule__Attribute__Group_6__0 : rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 ;
    public final void rule__Attribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6380:1: ( rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 )
            // InternalAceGen.g:6381:2: rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1
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
    // InternalAceGen.g:6388:1: rule__Attribute__Group_6__0__Impl : ( 'references' ) ;
    public final void rule__Attribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6392:1: ( ( 'references' ) )
            // InternalAceGen.g:6393:1: ( 'references' )
            {
            // InternalAceGen.g:6393:1: ( 'references' )
            // InternalAceGen.g:6394:2: 'references'
            {
             before(grammarAccess.getAttributeAccess().getReferencesKeyword_6_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalAceGen.g:6403:1: rule__Attribute__Group_6__1 : rule__Attribute__Group_6__1__Impl ;
    public final void rule__Attribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6407:1: ( rule__Attribute__Group_6__1__Impl )
            // InternalAceGen.g:6408:2: rule__Attribute__Group_6__1__Impl
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
    // InternalAceGen.g:6414:1: rule__Attribute__Group_6__1__Impl : ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) ) ;
    public final void rule__Attribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6418:1: ( ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) ) )
            // InternalAceGen.g:6419:1: ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) )
            {
            // InternalAceGen.g:6419:1: ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) )
            // InternalAceGen.g:6420:2: ( rule__Attribute__ForeignKeyAssignment_6_1 )
            {
             before(grammarAccess.getAttributeAccess().getForeignKeyAssignment_6_1()); 
            // InternalAceGen.g:6421:2: ( rule__Attribute__ForeignKeyAssignment_6_1 )
            // InternalAceGen.g:6421:3: rule__Attribute__ForeignKeyAssignment_6_1
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
    // InternalAceGen.g:6430:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6434:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalAceGen.g:6435:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_54);
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
    // InternalAceGen.g:6442:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6446:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6447:1: ( RULE_ID )
            {
            // InternalAceGen.g:6447:1: ( RULE_ID )
            // InternalAceGen.g:6448:2: RULE_ID
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
    // InternalAceGen.g:6457:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6461:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalAceGen.g:6462:2: rule__QualifiedName__Group__1__Impl
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
    // InternalAceGen.g:6468:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6472:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalAceGen.g:6473:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalAceGen.g:6473:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalAceGen.g:6474:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalAceGen.g:6475:2: ( rule__QualifiedName__Group_1__0 )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==63) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalAceGen.g:6475:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_55);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop89;
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
    // InternalAceGen.g:6484:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6488:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalAceGen.g:6489:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalAceGen.g:6496:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6500:1: ( ( '.' ) )
            // InternalAceGen.g:6501:1: ( '.' )
            {
            // InternalAceGen.g:6501:1: ( '.' )
            // InternalAceGen.g:6502:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalAceGen.g:6511:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6515:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalAceGen.g:6516:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalAceGen.g:6522:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6526:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6527:1: ( RULE_ID )
            {
            // InternalAceGen.g:6527:1: ( RULE_ID )
            // InternalAceGen.g:6528:2: RULE_ID
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


    // $ANTLR start "rule__JsonDateTime__Group__0"
    // InternalAceGen.g:6538:1: rule__JsonDateTime__Group__0 : rule__JsonDateTime__Group__0__Impl rule__JsonDateTime__Group__1 ;
    public final void rule__JsonDateTime__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6542:1: ( rule__JsonDateTime__Group__0__Impl rule__JsonDateTime__Group__1 )
            // InternalAceGen.g:6543:2: rule__JsonDateTime__Group__0__Impl rule__JsonDateTime__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__JsonDateTime__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonDateTime__Group__1();

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
    // $ANTLR end "rule__JsonDateTime__Group__0"


    // $ANTLR start "rule__JsonDateTime__Group__0__Impl"
    // InternalAceGen.g:6550:1: rule__JsonDateTime__Group__0__Impl : ( ( rule__JsonDateTime__DateTimeAssignment_0 ) ) ;
    public final void rule__JsonDateTime__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6554:1: ( ( ( rule__JsonDateTime__DateTimeAssignment_0 ) ) )
            // InternalAceGen.g:6555:1: ( ( rule__JsonDateTime__DateTimeAssignment_0 ) )
            {
            // InternalAceGen.g:6555:1: ( ( rule__JsonDateTime__DateTimeAssignment_0 ) )
            // InternalAceGen.g:6556:2: ( rule__JsonDateTime__DateTimeAssignment_0 )
            {
             before(grammarAccess.getJsonDateTimeAccess().getDateTimeAssignment_0()); 
            // InternalAceGen.g:6557:2: ( rule__JsonDateTime__DateTimeAssignment_0 )
            // InternalAceGen.g:6557:3: rule__JsonDateTime__DateTimeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JsonDateTime__DateTimeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJsonDateTimeAccess().getDateTimeAssignment_0()); 

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
    // $ANTLR end "rule__JsonDateTime__Group__0__Impl"


    // $ANTLR start "rule__JsonDateTime__Group__1"
    // InternalAceGen.g:6565:1: rule__JsonDateTime__Group__1 : rule__JsonDateTime__Group__1__Impl ;
    public final void rule__JsonDateTime__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6569:1: ( rule__JsonDateTime__Group__1__Impl )
            // InternalAceGen.g:6570:2: rule__JsonDateTime__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JsonDateTime__Group__1__Impl();

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
    // $ANTLR end "rule__JsonDateTime__Group__1"


    // $ANTLR start "rule__JsonDateTime__Group__1__Impl"
    // InternalAceGen.g:6576:1: rule__JsonDateTime__Group__1__Impl : ( ( rule__JsonDateTime__PatternAssignment_1 ) ) ;
    public final void rule__JsonDateTime__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6580:1: ( ( ( rule__JsonDateTime__PatternAssignment_1 ) ) )
            // InternalAceGen.g:6581:1: ( ( rule__JsonDateTime__PatternAssignment_1 ) )
            {
            // InternalAceGen.g:6581:1: ( ( rule__JsonDateTime__PatternAssignment_1 ) )
            // InternalAceGen.g:6582:2: ( rule__JsonDateTime__PatternAssignment_1 )
            {
             before(grammarAccess.getJsonDateTimeAccess().getPatternAssignment_1()); 
            // InternalAceGen.g:6583:2: ( rule__JsonDateTime__PatternAssignment_1 )
            // InternalAceGen.g:6583:3: rule__JsonDateTime__PatternAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__JsonDateTime__PatternAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJsonDateTimeAccess().getPatternAssignment_1()); 

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
    // $ANTLR end "rule__JsonDateTime__Group__1__Impl"


    // $ANTLR start "rule__JsonObject__Group__0"
    // InternalAceGen.g:6592:1: rule__JsonObject__Group__0 : rule__JsonObject__Group__0__Impl rule__JsonObject__Group__1 ;
    public final void rule__JsonObject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6596:1: ( rule__JsonObject__Group__0__Impl rule__JsonObject__Group__1 )
            // InternalAceGen.g:6597:2: rule__JsonObject__Group__0__Impl rule__JsonObject__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__JsonObject__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonObject__Group__1();

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
    // $ANTLR end "rule__JsonObject__Group__0"


    // $ANTLR start "rule__JsonObject__Group__0__Impl"
    // InternalAceGen.g:6604:1: rule__JsonObject__Group__0__Impl : ( () ) ;
    public final void rule__JsonObject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6608:1: ( ( () ) )
            // InternalAceGen.g:6609:1: ( () )
            {
            // InternalAceGen.g:6609:1: ( () )
            // InternalAceGen.g:6610:2: ()
            {
             before(grammarAccess.getJsonObjectAccess().getJsonObjectAction_0()); 
            // InternalAceGen.g:6611:2: ()
            // InternalAceGen.g:6611:3: 
            {
            }

             after(grammarAccess.getJsonObjectAccess().getJsonObjectAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JsonObject__Group__0__Impl"


    // $ANTLR start "rule__JsonObject__Group__1"
    // InternalAceGen.g:6619:1: rule__JsonObject__Group__1 : rule__JsonObject__Group__1__Impl rule__JsonObject__Group__2 ;
    public final void rule__JsonObject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6623:1: ( rule__JsonObject__Group__1__Impl rule__JsonObject__Group__2 )
            // InternalAceGen.g:6624:2: rule__JsonObject__Group__1__Impl rule__JsonObject__Group__2
            {
            pushFollow(FOLLOW_56);
            rule__JsonObject__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonObject__Group__2();

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
    // $ANTLR end "rule__JsonObject__Group__1"


    // $ANTLR start "rule__JsonObject__Group__1__Impl"
    // InternalAceGen.g:6631:1: rule__JsonObject__Group__1__Impl : ( '{' ) ;
    public final void rule__JsonObject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6635:1: ( ( '{' ) )
            // InternalAceGen.g:6636:1: ( '{' )
            {
            // InternalAceGen.g:6636:1: ( '{' )
            // InternalAceGen.g:6637:2: '{'
            {
             before(grammarAccess.getJsonObjectAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getJsonObjectAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__JsonObject__Group__1__Impl"


    // $ANTLR start "rule__JsonObject__Group__2"
    // InternalAceGen.g:6646:1: rule__JsonObject__Group__2 : rule__JsonObject__Group__2__Impl rule__JsonObject__Group__3 ;
    public final void rule__JsonObject__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6650:1: ( rule__JsonObject__Group__2__Impl rule__JsonObject__Group__3 )
            // InternalAceGen.g:6651:2: rule__JsonObject__Group__2__Impl rule__JsonObject__Group__3
            {
            pushFollow(FOLLOW_56);
            rule__JsonObject__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonObject__Group__3();

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
    // $ANTLR end "rule__JsonObject__Group__2"


    // $ANTLR start "rule__JsonObject__Group__2__Impl"
    // InternalAceGen.g:6658:1: rule__JsonObject__Group__2__Impl : ( ( rule__JsonObject__MembersAssignment_2 )? ) ;
    public final void rule__JsonObject__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6662:1: ( ( ( rule__JsonObject__MembersAssignment_2 )? ) )
            // InternalAceGen.g:6663:1: ( ( rule__JsonObject__MembersAssignment_2 )? )
            {
            // InternalAceGen.g:6663:1: ( ( rule__JsonObject__MembersAssignment_2 )? )
            // InternalAceGen.g:6664:2: ( rule__JsonObject__MembersAssignment_2 )?
            {
             before(grammarAccess.getJsonObjectAccess().getMembersAssignment_2()); 
            // InternalAceGen.g:6665:2: ( rule__JsonObject__MembersAssignment_2 )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_ID) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalAceGen.g:6665:3: rule__JsonObject__MembersAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__JsonObject__MembersAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJsonObjectAccess().getMembersAssignment_2()); 

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
    // $ANTLR end "rule__JsonObject__Group__2__Impl"


    // $ANTLR start "rule__JsonObject__Group__3"
    // InternalAceGen.g:6673:1: rule__JsonObject__Group__3 : rule__JsonObject__Group__3__Impl rule__JsonObject__Group__4 ;
    public final void rule__JsonObject__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6677:1: ( rule__JsonObject__Group__3__Impl rule__JsonObject__Group__4 )
            // InternalAceGen.g:6678:2: rule__JsonObject__Group__3__Impl rule__JsonObject__Group__4
            {
            pushFollow(FOLLOW_56);
            rule__JsonObject__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonObject__Group__4();

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
    // $ANTLR end "rule__JsonObject__Group__3"


    // $ANTLR start "rule__JsonObject__Group__3__Impl"
    // InternalAceGen.g:6685:1: rule__JsonObject__Group__3__Impl : ( ( rule__JsonObject__Group_3__0 )* ) ;
    public final void rule__JsonObject__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6689:1: ( ( ( rule__JsonObject__Group_3__0 )* ) )
            // InternalAceGen.g:6690:1: ( ( rule__JsonObject__Group_3__0 )* )
            {
            // InternalAceGen.g:6690:1: ( ( rule__JsonObject__Group_3__0 )* )
            // InternalAceGen.g:6691:2: ( rule__JsonObject__Group_3__0 )*
            {
             before(grammarAccess.getJsonObjectAccess().getGroup_3()); 
            // InternalAceGen.g:6692:2: ( rule__JsonObject__Group_3__0 )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==34) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalAceGen.g:6692:3: rule__JsonObject__Group_3__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__JsonObject__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);

             after(grammarAccess.getJsonObjectAccess().getGroup_3()); 

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
    // $ANTLR end "rule__JsonObject__Group__3__Impl"


    // $ANTLR start "rule__JsonObject__Group__4"
    // InternalAceGen.g:6700:1: rule__JsonObject__Group__4 : rule__JsonObject__Group__4__Impl ;
    public final void rule__JsonObject__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6704:1: ( rule__JsonObject__Group__4__Impl )
            // InternalAceGen.g:6705:2: rule__JsonObject__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JsonObject__Group__4__Impl();

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
    // $ANTLR end "rule__JsonObject__Group__4"


    // $ANTLR start "rule__JsonObject__Group__4__Impl"
    // InternalAceGen.g:6711:1: rule__JsonObject__Group__4__Impl : ( '}' ) ;
    public final void rule__JsonObject__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6715:1: ( ( '}' ) )
            // InternalAceGen.g:6716:1: ( '}' )
            {
            // InternalAceGen.g:6716:1: ( '}' )
            // InternalAceGen.g:6717:2: '}'
            {
             before(grammarAccess.getJsonObjectAccess().getRightCurlyBracketKeyword_4()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getJsonObjectAccess().getRightCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__JsonObject__Group__4__Impl"


    // $ANTLR start "rule__JsonObject__Group_3__0"
    // InternalAceGen.g:6727:1: rule__JsonObject__Group_3__0 : rule__JsonObject__Group_3__0__Impl rule__JsonObject__Group_3__1 ;
    public final void rule__JsonObject__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6731:1: ( rule__JsonObject__Group_3__0__Impl rule__JsonObject__Group_3__1 )
            // InternalAceGen.g:6732:2: rule__JsonObject__Group_3__0__Impl rule__JsonObject__Group_3__1
            {
            pushFollow(FOLLOW_4);
            rule__JsonObject__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonObject__Group_3__1();

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
    // $ANTLR end "rule__JsonObject__Group_3__0"


    // $ANTLR start "rule__JsonObject__Group_3__0__Impl"
    // InternalAceGen.g:6739:1: rule__JsonObject__Group_3__0__Impl : ( ',' ) ;
    public final void rule__JsonObject__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6743:1: ( ( ',' ) )
            // InternalAceGen.g:6744:1: ( ',' )
            {
            // InternalAceGen.g:6744:1: ( ',' )
            // InternalAceGen.g:6745:2: ','
            {
             before(grammarAccess.getJsonObjectAccess().getCommaKeyword_3_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getJsonObjectAccess().getCommaKeyword_3_0()); 

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
    // $ANTLR end "rule__JsonObject__Group_3__0__Impl"


    // $ANTLR start "rule__JsonObject__Group_3__1"
    // InternalAceGen.g:6754:1: rule__JsonObject__Group_3__1 : rule__JsonObject__Group_3__1__Impl ;
    public final void rule__JsonObject__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6758:1: ( rule__JsonObject__Group_3__1__Impl )
            // InternalAceGen.g:6759:2: rule__JsonObject__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JsonObject__Group_3__1__Impl();

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
    // $ANTLR end "rule__JsonObject__Group_3__1"


    // $ANTLR start "rule__JsonObject__Group_3__1__Impl"
    // InternalAceGen.g:6765:1: rule__JsonObject__Group_3__1__Impl : ( ( rule__JsonObject__MembersAssignment_3_1 ) ) ;
    public final void rule__JsonObject__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6769:1: ( ( ( rule__JsonObject__MembersAssignment_3_1 ) ) )
            // InternalAceGen.g:6770:1: ( ( rule__JsonObject__MembersAssignment_3_1 ) )
            {
            // InternalAceGen.g:6770:1: ( ( rule__JsonObject__MembersAssignment_3_1 ) )
            // InternalAceGen.g:6771:2: ( rule__JsonObject__MembersAssignment_3_1 )
            {
             before(grammarAccess.getJsonObjectAccess().getMembersAssignment_3_1()); 
            // InternalAceGen.g:6772:2: ( rule__JsonObject__MembersAssignment_3_1 )
            // InternalAceGen.g:6772:3: rule__JsonObject__MembersAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__JsonObject__MembersAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getJsonObjectAccess().getMembersAssignment_3_1()); 

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
    // $ANTLR end "rule__JsonObject__Group_3__1__Impl"


    // $ANTLR start "rule__JsonMember__Group__0"
    // InternalAceGen.g:6781:1: rule__JsonMember__Group__0 : rule__JsonMember__Group__0__Impl rule__JsonMember__Group__1 ;
    public final void rule__JsonMember__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6785:1: ( rule__JsonMember__Group__0__Impl rule__JsonMember__Group__1 )
            // InternalAceGen.g:6786:2: rule__JsonMember__Group__0__Impl rule__JsonMember__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__JsonMember__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonMember__Group__1();

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
    // $ANTLR end "rule__JsonMember__Group__0"


    // $ANTLR start "rule__JsonMember__Group__0__Impl"
    // InternalAceGen.g:6793:1: rule__JsonMember__Group__0__Impl : ( ( rule__JsonMember__AttributeAssignment_0 ) ) ;
    public final void rule__JsonMember__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6797:1: ( ( ( rule__JsonMember__AttributeAssignment_0 ) ) )
            // InternalAceGen.g:6798:1: ( ( rule__JsonMember__AttributeAssignment_0 ) )
            {
            // InternalAceGen.g:6798:1: ( ( rule__JsonMember__AttributeAssignment_0 ) )
            // InternalAceGen.g:6799:2: ( rule__JsonMember__AttributeAssignment_0 )
            {
             before(grammarAccess.getJsonMemberAccess().getAttributeAssignment_0()); 
            // InternalAceGen.g:6800:2: ( rule__JsonMember__AttributeAssignment_0 )
            // InternalAceGen.g:6800:3: rule__JsonMember__AttributeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__JsonMember__AttributeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJsonMemberAccess().getAttributeAssignment_0()); 

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
    // $ANTLR end "rule__JsonMember__Group__0__Impl"


    // $ANTLR start "rule__JsonMember__Group__1"
    // InternalAceGen.g:6808:1: rule__JsonMember__Group__1 : rule__JsonMember__Group__1__Impl rule__JsonMember__Group__2 ;
    public final void rule__JsonMember__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6812:1: ( rule__JsonMember__Group__1__Impl rule__JsonMember__Group__2 )
            // InternalAceGen.g:6813:2: rule__JsonMember__Group__1__Impl rule__JsonMember__Group__2
            {
            pushFollow(FOLLOW_57);
            rule__JsonMember__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonMember__Group__2();

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
    // $ANTLR end "rule__JsonMember__Group__1"


    // $ANTLR start "rule__JsonMember__Group__1__Impl"
    // InternalAceGen.g:6820:1: rule__JsonMember__Group__1__Impl : ( ':' ) ;
    public final void rule__JsonMember__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6824:1: ( ( ':' ) )
            // InternalAceGen.g:6825:1: ( ':' )
            {
            // InternalAceGen.g:6825:1: ( ':' )
            // InternalAceGen.g:6826:2: ':'
            {
             before(grammarAccess.getJsonMemberAccess().getColonKeyword_1()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getJsonMemberAccess().getColonKeyword_1()); 

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
    // $ANTLR end "rule__JsonMember__Group__1__Impl"


    // $ANTLR start "rule__JsonMember__Group__2"
    // InternalAceGen.g:6835:1: rule__JsonMember__Group__2 : rule__JsonMember__Group__2__Impl ;
    public final void rule__JsonMember__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6839:1: ( rule__JsonMember__Group__2__Impl )
            // InternalAceGen.g:6840:2: rule__JsonMember__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JsonMember__Group__2__Impl();

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
    // $ANTLR end "rule__JsonMember__Group__2"


    // $ANTLR start "rule__JsonMember__Group__2__Impl"
    // InternalAceGen.g:6846:1: rule__JsonMember__Group__2__Impl : ( ( rule__JsonMember__ValueAssignment_2 ) ) ;
    public final void rule__JsonMember__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6850:1: ( ( ( rule__JsonMember__ValueAssignment_2 ) ) )
            // InternalAceGen.g:6851:1: ( ( rule__JsonMember__ValueAssignment_2 ) )
            {
            // InternalAceGen.g:6851:1: ( ( rule__JsonMember__ValueAssignment_2 ) )
            // InternalAceGen.g:6852:2: ( rule__JsonMember__ValueAssignment_2 )
            {
             before(grammarAccess.getJsonMemberAccess().getValueAssignment_2()); 
            // InternalAceGen.g:6853:2: ( rule__JsonMember__ValueAssignment_2 )
            // InternalAceGen.g:6853:3: rule__JsonMember__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__JsonMember__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getJsonMemberAccess().getValueAssignment_2()); 

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
    // $ANTLR end "rule__JsonMember__Group__2__Impl"


    // $ANTLR start "rule__JsonArray__Group__0"
    // InternalAceGen.g:6862:1: rule__JsonArray__Group__0 : rule__JsonArray__Group__0__Impl rule__JsonArray__Group__1 ;
    public final void rule__JsonArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6866:1: ( rule__JsonArray__Group__0__Impl rule__JsonArray__Group__1 )
            // InternalAceGen.g:6867:2: rule__JsonArray__Group__0__Impl rule__JsonArray__Group__1
            {
            pushFollow(FOLLOW_58);
            rule__JsonArray__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonArray__Group__1();

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
    // $ANTLR end "rule__JsonArray__Group__0"


    // $ANTLR start "rule__JsonArray__Group__0__Impl"
    // InternalAceGen.g:6874:1: rule__JsonArray__Group__0__Impl : ( () ) ;
    public final void rule__JsonArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6878:1: ( ( () ) )
            // InternalAceGen.g:6879:1: ( () )
            {
            // InternalAceGen.g:6879:1: ( () )
            // InternalAceGen.g:6880:2: ()
            {
             before(grammarAccess.getJsonArrayAccess().getJsonArrayAction_0()); 
            // InternalAceGen.g:6881:2: ()
            // InternalAceGen.g:6881:3: 
            {
            }

             after(grammarAccess.getJsonArrayAccess().getJsonArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JsonArray__Group__0__Impl"


    // $ANTLR start "rule__JsonArray__Group__1"
    // InternalAceGen.g:6889:1: rule__JsonArray__Group__1 : rule__JsonArray__Group__1__Impl rule__JsonArray__Group__2 ;
    public final void rule__JsonArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6893:1: ( rule__JsonArray__Group__1__Impl rule__JsonArray__Group__2 )
            // InternalAceGen.g:6894:2: rule__JsonArray__Group__1__Impl rule__JsonArray__Group__2
            {
            pushFollow(FOLLOW_59);
            rule__JsonArray__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonArray__Group__2();

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
    // $ANTLR end "rule__JsonArray__Group__1"


    // $ANTLR start "rule__JsonArray__Group__1__Impl"
    // InternalAceGen.g:6901:1: rule__JsonArray__Group__1__Impl : ( '[' ) ;
    public final void rule__JsonArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6905:1: ( ( '[' ) )
            // InternalAceGen.g:6906:1: ( '[' )
            {
            // InternalAceGen.g:6906:1: ( '[' )
            // InternalAceGen.g:6907:2: '['
            {
             before(grammarAccess.getJsonArrayAccess().getLeftSquareBracketKeyword_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getJsonArrayAccess().getLeftSquareBracketKeyword_1()); 

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
    // $ANTLR end "rule__JsonArray__Group__1__Impl"


    // $ANTLR start "rule__JsonArray__Group__2"
    // InternalAceGen.g:6916:1: rule__JsonArray__Group__2 : rule__JsonArray__Group__2__Impl rule__JsonArray__Group__3 ;
    public final void rule__JsonArray__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6920:1: ( rule__JsonArray__Group__2__Impl rule__JsonArray__Group__3 )
            // InternalAceGen.g:6921:2: rule__JsonArray__Group__2__Impl rule__JsonArray__Group__3
            {
            pushFollow(FOLLOW_59);
            rule__JsonArray__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonArray__Group__3();

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
    // $ANTLR end "rule__JsonArray__Group__2"


    // $ANTLR start "rule__JsonArray__Group__2__Impl"
    // InternalAceGen.g:6928:1: rule__JsonArray__Group__2__Impl : ( ( rule__JsonArray__ValuesAssignment_2 )? ) ;
    public final void rule__JsonArray__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6932:1: ( ( ( rule__JsonArray__ValuesAssignment_2 )? ) )
            // InternalAceGen.g:6933:1: ( ( rule__JsonArray__ValuesAssignment_2 )? )
            {
            // InternalAceGen.g:6933:1: ( ( rule__JsonArray__ValuesAssignment_2 )? )
            // InternalAceGen.g:6934:2: ( rule__JsonArray__ValuesAssignment_2 )?
            {
             before(grammarAccess.getJsonArrayAccess().getValuesAssignment_2()); 
            // InternalAceGen.g:6935:2: ( rule__JsonArray__ValuesAssignment_2 )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( ((LA92_0>=RULE_STRING && LA92_0<=RULE_INT)||LA92_0==12||(LA92_0>=26 && LA92_0<=27)||LA92_0==43||LA92_0==64) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalAceGen.g:6935:3: rule__JsonArray__ValuesAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__JsonArray__ValuesAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJsonArrayAccess().getValuesAssignment_2()); 

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
    // $ANTLR end "rule__JsonArray__Group__2__Impl"


    // $ANTLR start "rule__JsonArray__Group__3"
    // InternalAceGen.g:6943:1: rule__JsonArray__Group__3 : rule__JsonArray__Group__3__Impl rule__JsonArray__Group__4 ;
    public final void rule__JsonArray__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6947:1: ( rule__JsonArray__Group__3__Impl rule__JsonArray__Group__4 )
            // InternalAceGen.g:6948:2: rule__JsonArray__Group__3__Impl rule__JsonArray__Group__4
            {
            pushFollow(FOLLOW_59);
            rule__JsonArray__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonArray__Group__4();

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
    // $ANTLR end "rule__JsonArray__Group__3"


    // $ANTLR start "rule__JsonArray__Group__3__Impl"
    // InternalAceGen.g:6955:1: rule__JsonArray__Group__3__Impl : ( ( rule__JsonArray__Group_3__0 )* ) ;
    public final void rule__JsonArray__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6959:1: ( ( ( rule__JsonArray__Group_3__0 )* ) )
            // InternalAceGen.g:6960:1: ( ( rule__JsonArray__Group_3__0 )* )
            {
            // InternalAceGen.g:6960:1: ( ( rule__JsonArray__Group_3__0 )* )
            // InternalAceGen.g:6961:2: ( rule__JsonArray__Group_3__0 )*
            {
             before(grammarAccess.getJsonArrayAccess().getGroup_3()); 
            // InternalAceGen.g:6962:2: ( rule__JsonArray__Group_3__0 )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==34) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalAceGen.g:6962:3: rule__JsonArray__Group_3__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__JsonArray__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

             after(grammarAccess.getJsonArrayAccess().getGroup_3()); 

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
    // $ANTLR end "rule__JsonArray__Group__3__Impl"


    // $ANTLR start "rule__JsonArray__Group__4"
    // InternalAceGen.g:6970:1: rule__JsonArray__Group__4 : rule__JsonArray__Group__4__Impl ;
    public final void rule__JsonArray__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6974:1: ( rule__JsonArray__Group__4__Impl )
            // InternalAceGen.g:6975:2: rule__JsonArray__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JsonArray__Group__4__Impl();

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
    // $ANTLR end "rule__JsonArray__Group__4"


    // $ANTLR start "rule__JsonArray__Group__4__Impl"
    // InternalAceGen.g:6981:1: rule__JsonArray__Group__4__Impl : ( ']' ) ;
    public final void rule__JsonArray__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6985:1: ( ( ']' ) )
            // InternalAceGen.g:6986:1: ( ']' )
            {
            // InternalAceGen.g:6986:1: ( ']' )
            // InternalAceGen.g:6987:2: ']'
            {
             before(grammarAccess.getJsonArrayAccess().getRightSquareBracketKeyword_4()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getJsonArrayAccess().getRightSquareBracketKeyword_4()); 

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
    // $ANTLR end "rule__JsonArray__Group__4__Impl"


    // $ANTLR start "rule__JsonArray__Group_3__0"
    // InternalAceGen.g:6997:1: rule__JsonArray__Group_3__0 : rule__JsonArray__Group_3__0__Impl rule__JsonArray__Group_3__1 ;
    public final void rule__JsonArray__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7001:1: ( rule__JsonArray__Group_3__0__Impl rule__JsonArray__Group_3__1 )
            // InternalAceGen.g:7002:2: rule__JsonArray__Group_3__0__Impl rule__JsonArray__Group_3__1
            {
            pushFollow(FOLLOW_57);
            rule__JsonArray__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__JsonArray__Group_3__1();

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
    // $ANTLR end "rule__JsonArray__Group_3__0"


    // $ANTLR start "rule__JsonArray__Group_3__0__Impl"
    // InternalAceGen.g:7009:1: rule__JsonArray__Group_3__0__Impl : ( ',' ) ;
    public final void rule__JsonArray__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7013:1: ( ( ',' ) )
            // InternalAceGen.g:7014:1: ( ',' )
            {
            // InternalAceGen.g:7014:1: ( ',' )
            // InternalAceGen.g:7015:2: ','
            {
             before(grammarAccess.getJsonArrayAccess().getCommaKeyword_3_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getJsonArrayAccess().getCommaKeyword_3_0()); 

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
    // $ANTLR end "rule__JsonArray__Group_3__0__Impl"


    // $ANTLR start "rule__JsonArray__Group_3__1"
    // InternalAceGen.g:7024:1: rule__JsonArray__Group_3__1 : rule__JsonArray__Group_3__1__Impl ;
    public final void rule__JsonArray__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7028:1: ( rule__JsonArray__Group_3__1__Impl )
            // InternalAceGen.g:7029:2: rule__JsonArray__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__JsonArray__Group_3__1__Impl();

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
    // $ANTLR end "rule__JsonArray__Group_3__1"


    // $ANTLR start "rule__JsonArray__Group_3__1__Impl"
    // InternalAceGen.g:7035:1: rule__JsonArray__Group_3__1__Impl : ( ( rule__JsonArray__ValuesAssignment_3_1 ) ) ;
    public final void rule__JsonArray__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7039:1: ( ( ( rule__JsonArray__ValuesAssignment_3_1 ) ) )
            // InternalAceGen.g:7040:1: ( ( rule__JsonArray__ValuesAssignment_3_1 ) )
            {
            // InternalAceGen.g:7040:1: ( ( rule__JsonArray__ValuesAssignment_3_1 ) )
            // InternalAceGen.g:7041:2: ( rule__JsonArray__ValuesAssignment_3_1 )
            {
             before(grammarAccess.getJsonArrayAccess().getValuesAssignment_3_1()); 
            // InternalAceGen.g:7042:2: ( rule__JsonArray__ValuesAssignment_3_1 )
            // InternalAceGen.g:7042:3: rule__JsonArray__ValuesAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__JsonArray__ValuesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getJsonArrayAccess().getValuesAssignment_3_1()); 

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
    // $ANTLR end "rule__JsonArray__Group_3__1__Impl"


    // $ANTLR start "rule__Project__HttpClientAssignment_1_0_1"
    // InternalAceGen.g:7051:1: rule__Project__HttpClientAssignment_1_0_1 : ( ruleHttpClient ) ;
    public final void rule__Project__HttpClientAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7055:1: ( ( ruleHttpClient ) )
            // InternalAceGen.g:7056:2: ( ruleHttpClient )
            {
            // InternalAceGen.g:7056:2: ( ruleHttpClient )
            // InternalAceGen.g:7057:3: ruleHttpClient
            {
             before(grammarAccess.getProjectAccess().getHttpClientHttpClientParserRuleCall_1_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpClient();

            state._fsp--;

             after(grammarAccess.getProjectAccess().getHttpClientHttpClientParserRuleCall_1_0_1_0()); 

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
    // $ANTLR end "rule__Project__HttpClientAssignment_1_0_1"


    // $ANTLR start "rule__Project__HttpServerAssignment_1_1_1"
    // InternalAceGen.g:7066:1: rule__Project__HttpServerAssignment_1_1_1 : ( ruleHttpServer ) ;
    public final void rule__Project__HttpServerAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7070:1: ( ( ruleHttpServer ) )
            // InternalAceGen.g:7071:2: ( ruleHttpServer )
            {
            // InternalAceGen.g:7071:2: ( ruleHttpServer )
            // InternalAceGen.g:7072:3: ruleHttpServer
            {
             before(grammarAccess.getProjectAccess().getHttpServerHttpServerParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpServer();

            state._fsp--;

             after(grammarAccess.getProjectAccess().getHttpServerHttpServerParserRuleCall_1_1_1_0()); 

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
    // $ANTLR end "rule__Project__HttpServerAssignment_1_1_1"


    // $ANTLR start "rule__HttpClient__NameAssignment_0"
    // InternalAceGen.g:7081:1: rule__HttpClient__NameAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__HttpClient__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7085:1: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7086:2: ( ruleQualifiedName )
            {
            // InternalAceGen.g:7086:2: ( ruleQualifiedName )
            // InternalAceGen.g:7087:3: ruleQualifiedName
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
    // InternalAceGen.g:7096:1: rule__HttpClient__AceOperationsAssignment_1_1 : ( ruleHttpClientAce ) ;
    public final void rule__HttpClient__AceOperationsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7100:1: ( ( ruleHttpClientAce ) )
            // InternalAceGen.g:7101:2: ( ruleHttpClientAce )
            {
            // InternalAceGen.g:7101:2: ( ruleHttpClientAce )
            // InternalAceGen.g:7102:3: ruleHttpClientAce
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
    // InternalAceGen.g:7111:1: rule__HttpClient__AppStateAssignment_2_1 : ( ruleHttpClientStateElement ) ;
    public final void rule__HttpClient__AppStateAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7115:1: ( ( ruleHttpClientStateElement ) )
            // InternalAceGen.g:7116:2: ( ruleHttpClientStateElement )
            {
            // InternalAceGen.g:7116:2: ( ruleHttpClientStateElement )
            // InternalAceGen.g:7117:3: ruleHttpClientStateElement
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


    // $ANTLR start "rule__HttpClientAce__AsyncAssignment_0"
    // InternalAceGen.g:7126:1: rule__HttpClientAce__AsyncAssignment_0 : ( ( 'async' ) ) ;
    public final void rule__HttpClientAce__AsyncAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7130:1: ( ( ( 'async' ) ) )
            // InternalAceGen.g:7131:2: ( ( 'async' ) )
            {
            // InternalAceGen.g:7131:2: ( ( 'async' ) )
            // InternalAceGen.g:7132:3: ( 'async' )
            {
             before(grammarAccess.getHttpClientAceAccess().getAsyncAsyncKeyword_0_0()); 
            // InternalAceGen.g:7133:3: ( 'async' )
            // InternalAceGen.g:7134:4: 'async'
            {
             before(grammarAccess.getHttpClientAceAccess().getAsyncAsyncKeyword_0_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getAsyncAsyncKeyword_0_0()); 

            }

             after(grammarAccess.getHttpClientAceAccess().getAsyncAsyncKeyword_0_0()); 

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
    // $ANTLR end "rule__HttpClientAce__AsyncAssignment_0"


    // $ANTLR start "rule__HttpClientAce__NameAssignment_1"
    // InternalAceGen.g:7145:1: rule__HttpClientAce__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7149:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7150:2: ( RULE_ID )
            {
            // InternalAceGen.g:7150:2: ( RULE_ID )
            // InternalAceGen.g:7151:3: RULE_ID
            {
             before(grammarAccess.getHttpClientAceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__HttpClientAce__NameAssignment_1"


    // $ANTLR start "rule__HttpClientAce__InputAssignment_2_1"
    // InternalAceGen.g:7160:1: rule__HttpClientAce__InputAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__InputAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7164:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7165:2: ( RULE_ID )
            {
            // InternalAceGen.g:7165:2: ( RULE_ID )
            // InternalAceGen.g:7166:3: RULE_ID
            {
             before(grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__HttpClientAce__InputAssignment_2_1"


    // $ANTLR start "rule__HttpClientAce__InputAssignment_2_2_1"
    // InternalAceGen.g:7175:1: rule__HttpClientAce__InputAssignment_2_2_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__InputAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7179:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7180:2: ( RULE_ID )
            {
            // InternalAceGen.g:7180:2: ( RULE_ID )
            // InternalAceGen.g:7181:3: RULE_ID
            {
             before(grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_2_2_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_2_2_1_0()); 

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
    // $ANTLR end "rule__HttpClientAce__InputAssignment_2_2_1"


    // $ANTLR start "rule__HttpClientAce__ServerCallAssignment_3_1"
    // InternalAceGen.g:7190:1: rule__HttpClientAce__ServerCallAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientAce__ServerCallAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7194:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7195:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7195:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7196:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceCrossReference_3_1_0()); 
            // InternalAceGen.g:7197:3: ( ruleQualifiedName )
            // InternalAceGen.g:7198:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceCrossReference_3_1_0()); 

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
    // $ANTLR end "rule__HttpClientAce__ServerCallAssignment_3_1"


    // $ANTLR start "rule__HttpClientAce__LoadingFlagAssignment_4_1"
    // InternalAceGen.g:7209:1: rule__HttpClientAce__LoadingFlagAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientAce__LoadingFlagAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7213:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7214:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7214:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7215:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementCrossReference_4_1_0()); 
            // InternalAceGen.g:7216:3: ( ruleQualifiedName )
            // InternalAceGen.g:7217:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementQualifiedNameParserRuleCall_4_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementQualifiedNameParserRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementCrossReference_4_1_0()); 

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
    // $ANTLR end "rule__HttpClientAce__LoadingFlagAssignment_4_1"


    // $ANTLR start "rule__HttpClientAce__OutcomesAssignment_5"
    // InternalAceGen.g:7228:1: rule__HttpClientAce__OutcomesAssignment_5 : ( ruleHttpClientOutcome ) ;
    public final void rule__HttpClientAce__OutcomesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7232:1: ( ( ruleHttpClientOutcome ) )
            // InternalAceGen.g:7233:2: ( ruleHttpClientOutcome )
            {
            // InternalAceGen.g:7233:2: ( ruleHttpClientOutcome )
            // InternalAceGen.g:7234:3: ruleHttpClientOutcome
            {
             before(grammarAccess.getHttpClientAceAccess().getOutcomesHttpClientOutcomeParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpClientOutcome();

            state._fsp--;

             after(grammarAccess.getHttpClientAceAccess().getOutcomesHttpClientOutcomeParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__HttpClientAce__OutcomesAssignment_5"


    // $ANTLR start "rule__HttpClientOutcome__NameAssignment_1"
    // InternalAceGen.g:7243:1: rule__HttpClientOutcome__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientOutcome__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7247:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7248:2: ( RULE_ID )
            {
            // InternalAceGen.g:7248:2: ( RULE_ID )
            // InternalAceGen.g:7249:3: RULE_ID
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
    // InternalAceGen.g:7258:1: rule__HttpClientOutcome__ListenersAssignment_2_1 : ( ruleHttpClientStateFunction ) ;
    public final void rule__HttpClientOutcome__ListenersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7262:1: ( ( ruleHttpClientStateFunction ) )
            // InternalAceGen.g:7263:2: ( ruleHttpClientStateFunction )
            {
            // InternalAceGen.g:7263:2: ( ruleHttpClientStateFunction )
            // InternalAceGen.g:7264:3: ruleHttpClientStateFunction
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
    // InternalAceGen.g:7273:1: rule__HttpClientOutcome__AceOperationsAssignment_3_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientOutcome__AceOperationsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7277:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7278:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7278:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7279:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsHttpClientAceCrossReference_3_2_0()); 
            // InternalAceGen.g:7280:3: ( ruleQualifiedName )
            // InternalAceGen.g:7281:4: ruleQualifiedName
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
    // InternalAceGen.g:7292:1: rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 : ( ruleHttpClientStateFunctionType ) ;
    public final void rule__HttpClientStateFunction__StateFunctionTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7296:1: ( ( ruleHttpClientStateFunctionType ) )
            // InternalAceGen.g:7297:2: ( ruleHttpClientStateFunctionType )
            {
            // InternalAceGen.g:7297:2: ( ruleHttpClientStateFunctionType )
            // InternalAceGen.g:7298:3: ruleHttpClientStateFunctionType
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
    // InternalAceGen.g:7307:1: rule__HttpClientStateFunction__AttributeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientStateFunction__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7311:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7312:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7312:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7313:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getAttributeHttpClientStateElementCrossReference_1_0()); 
            // InternalAceGen.g:7314:3: ( ruleQualifiedName )
            // InternalAceGen.g:7315:4: ruleQualifiedName
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
    // InternalAceGen.g:7326:1: rule__HttpClientStateElement__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpClientStateElement__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7330:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7331:2: ( RULE_ID )
            {
            // InternalAceGen.g:7331:2: ( RULE_ID )
            // InternalAceGen.g:7332:3: RULE_ID
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
    // InternalAceGen.g:7341:1: rule__HttpClientStateElement__ListAssignment_1 : ( ( 'list' ) ) ;
    public final void rule__HttpClientStateElement__ListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7345:1: ( ( ( 'list' ) ) )
            // InternalAceGen.g:7346:2: ( ( 'list' ) )
            {
            // InternalAceGen.g:7346:2: ( ( 'list' ) )
            // InternalAceGen.g:7347:3: ( 'list' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 
            // InternalAceGen.g:7348:3: ( 'list' )
            // InternalAceGen.g:7349:4: 'list'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 
            match(input,67,FOLLOW_2); 
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
    // InternalAceGen.g:7360:1: rule__HttpClientStateElement__HashAssignment_2 : ( ( 'location.hash' ) ) ;
    public final void rule__HttpClientStateElement__HashAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7364:1: ( ( ( 'location.hash' ) ) )
            // InternalAceGen.g:7365:2: ( ( 'location.hash' ) )
            {
            // InternalAceGen.g:7365:2: ( ( 'location.hash' ) )
            // InternalAceGen.g:7366:3: ( 'location.hash' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 
            // InternalAceGen.g:7367:3: ( 'location.hash' )
            // InternalAceGen.g:7368:4: 'location.hash'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalAceGen.g:7379:1: rule__HttpClientStateElement__StorageAssignment_3 : ( ( 'storage' ) ) ;
    public final void rule__HttpClientStateElement__StorageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7383:1: ( ( ( 'storage' ) ) )
            // InternalAceGen.g:7384:2: ( ( 'storage' ) )
            {
            // InternalAceGen.g:7384:2: ( ( 'storage' ) )
            // InternalAceGen.g:7385:3: ( 'storage' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 
            // InternalAceGen.g:7386:3: ( 'storage' )
            // InternalAceGen.g:7387:4: 'storage'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 
            match(input,69,FOLLOW_2); 
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
    // InternalAceGen.g:7398:1: rule__HttpClientStateElement__TypesAssignment_4_0 : ( ruleHttpClientTypeDefinition ) ;
    public final void rule__HttpClientStateElement__TypesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7402:1: ( ( ruleHttpClientTypeDefinition ) )
            // InternalAceGen.g:7403:2: ( ruleHttpClientTypeDefinition )
            {
            // InternalAceGen.g:7403:2: ( ruleHttpClientTypeDefinition )
            // InternalAceGen.g:7404:3: ruleHttpClientTypeDefinition
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
    // InternalAceGen.g:7413:1: rule__HttpClientStateElement__TypesAssignment_4_1_1 : ( ruleHttpClientTypeDefinition ) ;
    public final void rule__HttpClientStateElement__TypesAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7417:1: ( ( ruleHttpClientTypeDefinition ) )
            // InternalAceGen.g:7418:2: ( ruleHttpClientTypeDefinition )
            {
            // InternalAceGen.g:7418:2: ( ruleHttpClientTypeDefinition )
            // InternalAceGen.g:7419:3: ruleHttpClientTypeDefinition
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
    // InternalAceGen.g:7428:1: rule__HttpClientTypeDefinition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientTypeDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7432:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7433:2: ( RULE_ID )
            {
            // InternalAceGen.g:7433:2: ( RULE_ID )
            // InternalAceGen.g:7434:3: RULE_ID
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
    // InternalAceGen.g:7443:1: rule__HttpClientTypeDefinition__ElementsAssignment_3 : ( ruleHttpClientStateElement ) ;
    public final void rule__HttpClientTypeDefinition__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7447:1: ( ( ruleHttpClientStateElement ) )
            // InternalAceGen.g:7448:2: ( ruleHttpClientStateElement )
            {
            // InternalAceGen.g:7448:2: ( ruleHttpClientStateElement )
            // InternalAceGen.g:7449:3: ruleHttpClientStateElement
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


    // $ANTLR start "rule__HttpServer__TypeAssignment_0"
    // InternalAceGen.g:7458:1: rule__HttpServer__TypeAssignment_0 : ( ( 'Dropwizard' ) ) ;
    public final void rule__HttpServer__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7462:1: ( ( ( 'Dropwizard' ) ) )
            // InternalAceGen.g:7463:2: ( ( 'Dropwizard' ) )
            {
            // InternalAceGen.g:7463:2: ( ( 'Dropwizard' ) )
            // InternalAceGen.g:7464:3: ( 'Dropwizard' )
            {
             before(grammarAccess.getHttpServerAccess().getTypeDropwizardKeyword_0_0()); 
            // InternalAceGen.g:7465:3: ( 'Dropwizard' )
            // InternalAceGen.g:7466:4: 'Dropwizard'
            {
             before(grammarAccess.getHttpServerAccess().getTypeDropwizardKeyword_0_0()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getTypeDropwizardKeyword_0_0()); 

            }

             after(grammarAccess.getHttpServerAccess().getTypeDropwizardKeyword_0_0()); 

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
    // $ANTLR end "rule__HttpServer__TypeAssignment_0"


    // $ANTLR start "rule__HttpServer__NameAssignment_1"
    // InternalAceGen.g:7477:1: rule__HttpServer__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__HttpServer__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7481:1: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7482:2: ( ruleQualifiedName )
            {
            // InternalAceGen.g:7482:2: ( ruleQualifiedName )
            // InternalAceGen.g:7483:3: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getNameQualifiedNameParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__HttpServer__NameAssignment_1"


    // $ANTLR start "rule__HttpServer__AuthUserAssignment_2_1"
    // InternalAceGen.g:7492:1: rule__HttpServer__AuthUserAssignment_2_1 : ( ruleAuthUser ) ;
    public final void rule__HttpServer__AuthUserAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7496:1: ( ( ruleAuthUser ) )
            // InternalAceGen.g:7497:2: ( ruleAuthUser )
            {
            // InternalAceGen.g:7497:2: ( ruleAuthUser )
            // InternalAceGen.g:7498:3: ruleAuthUser
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserAuthUserParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAuthUser();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getAuthUserAuthUserParserRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__HttpServer__AuthUserAssignment_2_1"


    // $ANTLR start "rule__HttpServer__AuthUserRefAssignment_3_1"
    // InternalAceGen.g:7507:1: rule__HttpServer__AuthUserRefAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServer__AuthUserRefAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7511:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7512:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7512:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7513:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_3_1_0()); 
            // InternalAceGen.g:7514:3: ( ruleQualifiedName )
            // InternalAceGen.g:7515:4: ruleQualifiedName
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_3_1_0()); 

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
    // $ANTLR end "rule__HttpServer__AuthUserRefAssignment_3_1"


    // $ANTLR start "rule__HttpServer__AceOperationsAssignment_4_1"
    // InternalAceGen.g:7526:1: rule__HttpServer__AceOperationsAssignment_4_1 : ( ruleHttpServerAce ) ;
    public final void rule__HttpServer__AceOperationsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7530:1: ( ( ruleHttpServerAce ) )
            // InternalAceGen.g:7531:2: ( ruleHttpServerAce )
            {
            // InternalAceGen.g:7531:2: ( ruleHttpServerAce )
            // InternalAceGen.g:7532:3: ruleHttpServerAce
            {
             before(grammarAccess.getHttpServerAccess().getAceOperationsHttpServerAceParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpServerAce();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getAceOperationsHttpServerAceParserRuleCall_4_1_0()); 

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
    // $ANTLR end "rule__HttpServer__AceOperationsAssignment_4_1"


    // $ANTLR start "rule__HttpServer__ViewsAssignment_5_1"
    // InternalAceGen.g:7541:1: rule__HttpServer__ViewsAssignment_5_1 : ( ruleHttpServerView ) ;
    public final void rule__HttpServer__ViewsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7545:1: ( ( ruleHttpServerView ) )
            // InternalAceGen.g:7546:2: ( ruleHttpServerView )
            {
            // InternalAceGen.g:7546:2: ( ruleHttpServerView )
            // InternalAceGen.g:7547:3: ruleHttpServerView
            {
             before(grammarAccess.getHttpServerAccess().getViewsHttpServerViewParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHttpServerView();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getViewsHttpServerViewParserRuleCall_5_1_0()); 

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
    // $ANTLR end "rule__HttpServer__ViewsAssignment_5_1"


    // $ANTLR start "rule__HttpServer__ModelsAssignment_6_1"
    // InternalAceGen.g:7556:1: rule__HttpServer__ModelsAssignment_6_1 : ( ruleModel ) ;
    public final void rule__HttpServer__ModelsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7560:1: ( ( ruleModel ) )
            // InternalAceGen.g:7561:2: ( ruleModel )
            {
            // InternalAceGen.g:7561:2: ( ruleModel )
            // InternalAceGen.g:7562:3: ruleModel
            {
             before(grammarAccess.getHttpServerAccess().getModelsModelParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getModelsModelParserRuleCall_6_1_0()); 

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
    // $ANTLR end "rule__HttpServer__ModelsAssignment_6_1"


    // $ANTLR start "rule__HttpServer__ScenariosAssignment_7_1"
    // InternalAceGen.g:7571:1: rule__HttpServer__ScenariosAssignment_7_1 : ( ruleScenario ) ;
    public final void rule__HttpServer__ScenariosAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7575:1: ( ( ruleScenario ) )
            // InternalAceGen.g:7576:2: ( ruleScenario )
            {
            // InternalAceGen.g:7576:2: ( ruleScenario )
            // InternalAceGen.g:7577:3: ruleScenario
            {
             before(grammarAccess.getHttpServerAccess().getScenariosScenarioParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleScenario();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getScenariosScenarioParserRuleCall_7_1_0()); 

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
    // $ANTLR end "rule__HttpServer__ScenariosAssignment_7_1"


    // $ANTLR start "rule__HttpServerAceWrite__ProxyAssignment_0"
    // InternalAceGen.g:7586:1: rule__HttpServerAceWrite__ProxyAssignment_0 : ( ( 'proxy' ) ) ;
    public final void rule__HttpServerAceWrite__ProxyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7590:1: ( ( ( 'proxy' ) ) )
            // InternalAceGen.g:7591:2: ( ( 'proxy' ) )
            {
            // InternalAceGen.g:7591:2: ( ( 'proxy' ) )
            // InternalAceGen.g:7592:3: ( 'proxy' )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 
            // InternalAceGen.g:7593:3: ( 'proxy' )
            // InternalAceGen.g:7594:4: 'proxy'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 
            match(input,71,FOLLOW_2); 
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
    // InternalAceGen.g:7605:1: rule__HttpServerAceWrite__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerAceWrite__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7609:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7610:2: ( RULE_ID )
            {
            // InternalAceGen.g:7610:2: ( RULE_ID )
            // InternalAceGen.g:7611:3: RULE_ID
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
    // InternalAceGen.g:7620:1: rule__HttpServerAceWrite__ModelAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7624:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7625:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7625:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7626:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_3_0()); 
            // InternalAceGen.g:7627:3: ( ruleQualifiedName )
            // InternalAceGen.g:7628:4: ruleQualifiedName
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
    // InternalAceGen.g:7639:1: rule__HttpServerAceWrite__TypeAssignment_5 : ( ruleWriteFunctionType ) ;
    public final void rule__HttpServerAceWrite__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7643:1: ( ( ruleWriteFunctionType ) )
            // InternalAceGen.g:7644:2: ( ruleWriteFunctionType )
            {
            // InternalAceGen.g:7644:2: ( ruleWriteFunctionType )
            // InternalAceGen.g:7645:3: ruleWriteFunctionType
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
    // InternalAceGen.g:7654:1: rule__HttpServerAceWrite__UrlAssignment_6 : ( RULE_STRING ) ;
    public final void rule__HttpServerAceWrite__UrlAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7658:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7659:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7659:2: ( RULE_STRING )
            // InternalAceGen.g:7660:3: RULE_STRING
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
    // InternalAceGen.g:7669:1: rule__HttpServerAceWrite__AuthorizeAssignment_7 : ( ( 'authorize' ) ) ;
    public final void rule__HttpServerAceWrite__AuthorizeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7673:1: ( ( ( 'authorize' ) ) )
            // InternalAceGen.g:7674:2: ( ( 'authorize' ) )
            {
            // InternalAceGen.g:7674:2: ( ( 'authorize' ) )
            // InternalAceGen.g:7675:3: ( 'authorize' )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            // InternalAceGen.g:7676:3: ( 'authorize' )
            // InternalAceGen.g:7677:4: 'authorize'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            match(input,72,FOLLOW_2); 
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
    // InternalAceGen.g:7688:1: rule__HttpServerAceWrite__PathParamsAssignment_8_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceWrite__PathParamsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7692:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7693:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7693:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7694:3: ruleAttributeParamRef
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeParamRefParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeParamRef();

            state._fsp--;

             after(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeParamRefParserRuleCall_8_1_0()); 

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
    // InternalAceGen.g:7703:1: rule__HttpServerAceWrite__QueryParamsAssignment_9_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceWrite__QueryParamsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7707:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7708:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7708:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7709:3: ruleAttributeParamRef
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeParamRefParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeParamRef();

            state._fsp--;

             after(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeParamRefParserRuleCall_9_1_0()); 

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
    // InternalAceGen.g:7718:1: rule__HttpServerAceWrite__PayloadAssignment_10_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceWrite__PayloadAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7722:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7723:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7723:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7724:3: ruleAttributeParamRef
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeParamRefParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeParamRef();

            state._fsp--;

             after(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeParamRefParserRuleCall_10_1_0()); 

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
    // InternalAceGen.g:7733:1: rule__HttpServerAceWrite__ResponseAssignment_11_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__ResponseAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7737:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7738:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7738:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7739:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeCrossReference_11_1_0()); 
            // InternalAceGen.g:7740:3: ( ruleQualifiedName )
            // InternalAceGen.g:7741:4: ruleQualifiedName
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
    // InternalAceGen.g:7752:1: rule__HttpServerAceWrite__OutcomesAssignment_12 : ( ruleHttpServerOutcome ) ;
    public final void rule__HttpServerAceWrite__OutcomesAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7756:1: ( ( ruleHttpServerOutcome ) )
            // InternalAceGen.g:7757:2: ( ruleHttpServerOutcome )
            {
            // InternalAceGen.g:7757:2: ( ruleHttpServerOutcome )
            // InternalAceGen.g:7758:3: ruleHttpServerOutcome
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
    // InternalAceGen.g:7767:1: rule__HttpServerOutcome__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerOutcome__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7771:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7772:2: ( RULE_ID )
            {
            // InternalAceGen.g:7772:2: ( RULE_ID )
            // InternalAceGen.g:7773:3: RULE_ID
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
    // InternalAceGen.g:7782:1: rule__HttpServerOutcome__ListenersAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerOutcome__ListenersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7786:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7787:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7787:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7788:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0()); 
            // InternalAceGen.g:7789:3: ( ruleQualifiedName )
            // InternalAceGen.g:7790:4: ruleQualifiedName
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


    // $ANTLR start "rule__HttpServerAceRead__ProxyAssignment_0"
    // InternalAceGen.g:7801:1: rule__HttpServerAceRead__ProxyAssignment_0 : ( ( 'proxy' ) ) ;
    public final void rule__HttpServerAceRead__ProxyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7805:1: ( ( ( 'proxy' ) ) )
            // InternalAceGen.g:7806:2: ( ( 'proxy' ) )
            {
            // InternalAceGen.g:7806:2: ( ( 'proxy' ) )
            // InternalAceGen.g:7807:3: ( 'proxy' )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 
            // InternalAceGen.g:7808:3: ( 'proxy' )
            // InternalAceGen.g:7809:4: 'proxy'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 
            match(input,71,FOLLOW_2); 
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
    // InternalAceGen.g:7820:1: rule__HttpServerAceRead__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerAceRead__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7824:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7825:2: ( RULE_ID )
            {
            // InternalAceGen.g:7825:2: ( RULE_ID )
            // InternalAceGen.g:7826:3: RULE_ID
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
    // InternalAceGen.g:7835:1: rule__HttpServerAceRead__ModelAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7839:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7840:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7840:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7841:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_3_0()); 
            // InternalAceGen.g:7842:3: ( ruleQualifiedName )
            // InternalAceGen.g:7843:4: ruleQualifiedName
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
    // InternalAceGen.g:7854:1: rule__HttpServerAceRead__TypeAssignment_5 : ( ruleReadFunctionType ) ;
    public final void rule__HttpServerAceRead__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7858:1: ( ( ruleReadFunctionType ) )
            // InternalAceGen.g:7859:2: ( ruleReadFunctionType )
            {
            // InternalAceGen.g:7859:2: ( ruleReadFunctionType )
            // InternalAceGen.g:7860:3: ruleReadFunctionType
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
    // InternalAceGen.g:7869:1: rule__HttpServerAceRead__UrlAssignment_6 : ( RULE_STRING ) ;
    public final void rule__HttpServerAceRead__UrlAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7873:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7874:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7874:2: ( RULE_STRING )
            // InternalAceGen.g:7875:3: RULE_STRING
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
    // InternalAceGen.g:7884:1: rule__HttpServerAceRead__AuthorizeAssignment_7 : ( ( 'authorize' ) ) ;
    public final void rule__HttpServerAceRead__AuthorizeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7888:1: ( ( ( 'authorize' ) ) )
            // InternalAceGen.g:7889:2: ( ( 'authorize' ) )
            {
            // InternalAceGen.g:7889:2: ( ( 'authorize' ) )
            // InternalAceGen.g:7890:3: ( 'authorize' )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            // InternalAceGen.g:7891:3: ( 'authorize' )
            // InternalAceGen.g:7892:4: 'authorize'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            match(input,72,FOLLOW_2); 
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
    // InternalAceGen.g:7903:1: rule__HttpServerAceRead__PathParamsAssignment_8_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceRead__PathParamsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7907:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7908:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7908:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7909:3: ruleAttributeParamRef
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeParamRefParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeParamRef();

            state._fsp--;

             after(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeParamRefParserRuleCall_8_1_0()); 

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
    // InternalAceGen.g:7918:1: rule__HttpServerAceRead__QueryParamsAssignment_9_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceRead__QueryParamsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7922:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7923:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7923:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7924:3: ruleAttributeParamRef
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeParamRefParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeParamRef();

            state._fsp--;

             after(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeParamRefParserRuleCall_9_1_0()); 

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
    // InternalAceGen.g:7933:1: rule__HttpServerAceRead__PayloadAssignment_10_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceRead__PayloadAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7937:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7938:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7938:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7939:3: ruleAttributeParamRef
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeParamRefParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeParamRef();

            state._fsp--;

             after(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeParamRefParserRuleCall_10_1_0()); 

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
    // InternalAceGen.g:7948:1: rule__HttpServerAceRead__ResponseAssignment_11_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__ResponseAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7952:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7953:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7953:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7954:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseAttributeCrossReference_11_1_0()); 
            // InternalAceGen.g:7955:3: ( ruleQualifiedName )
            // InternalAceGen.g:7956:4: ruleQualifiedName
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


    // $ANTLR start "rule__AttributeParamRef__AttributeAssignment_0"
    // InternalAceGen.g:7967:1: rule__AttributeParamRef__AttributeAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__AttributeParamRef__AttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7971:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7972:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7972:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7973:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeParamRefAccess().getAttributeAttributeCrossReference_0_0()); 
            // InternalAceGen.g:7974:3: ( ruleQualifiedName )
            // InternalAceGen.g:7975:4: ruleQualifiedName
            {
             before(grammarAccess.getAttributeParamRefAccess().getAttributeAttributeQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getAttributeParamRefAccess().getAttributeAttributeQualifiedNameParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAttributeParamRefAccess().getAttributeAttributeCrossReference_0_0()); 

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
    // $ANTLR end "rule__AttributeParamRef__AttributeAssignment_0"


    // $ANTLR start "rule__AttributeParamRef__OptionalAssignment_1"
    // InternalAceGen.g:7986:1: rule__AttributeParamRef__OptionalAssignment_1 : ( ( 'optional' ) ) ;
    public final void rule__AttributeParamRef__OptionalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7990:1: ( ( ( 'optional' ) ) )
            // InternalAceGen.g:7991:2: ( ( 'optional' ) )
            {
            // InternalAceGen.g:7991:2: ( ( 'optional' ) )
            // InternalAceGen.g:7992:3: ( 'optional' )
            {
             before(grammarAccess.getAttributeParamRefAccess().getOptionalOptionalKeyword_1_0()); 
            // InternalAceGen.g:7993:3: ( 'optional' )
            // InternalAceGen.g:7994:4: 'optional'
            {
             before(grammarAccess.getAttributeParamRefAccess().getOptionalOptionalKeyword_1_0()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getAttributeParamRefAccess().getOptionalOptionalKeyword_1_0()); 

            }

             after(grammarAccess.getAttributeParamRefAccess().getOptionalOptionalKeyword_1_0()); 

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
    // $ANTLR end "rule__AttributeParamRef__OptionalAssignment_1"


    // $ANTLR start "rule__HttpServerView__NameAssignment_0"
    // InternalAceGen.g:8005:1: rule__HttpServerView__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpServerView__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8009:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8010:2: ( RULE_ID )
            {
            // InternalAceGen.g:8010:2: ( RULE_ID )
            // InternalAceGen.g:8011:3: RULE_ID
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
    // InternalAceGen.g:8020:1: rule__HttpServerView__RenderFunctionsAssignment_1_1 : ( ruleHttpServerViewFunction ) ;
    public final void rule__HttpServerView__RenderFunctionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8024:1: ( ( ruleHttpServerViewFunction ) )
            // InternalAceGen.g:8025:2: ( ruleHttpServerViewFunction )
            {
            // InternalAceGen.g:8025:2: ( ruleHttpServerViewFunction )
            // InternalAceGen.g:8026:3: ruleHttpServerViewFunction
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
    // InternalAceGen.g:8035:1: rule__HttpServerViewFunction__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpServerViewFunction__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8039:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8040:2: ( RULE_ID )
            {
            // InternalAceGen.g:8040:2: ( RULE_ID )
            // InternalAceGen.g:8041:3: RULE_ID
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
    // InternalAceGen.g:8050:1: rule__HttpServerViewFunction__ModelAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerViewFunction__ModelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8054:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8055:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8055:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8056:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0()); 
            // InternalAceGen.g:8057:3: ( ruleQualifiedName )
            // InternalAceGen.g:8058:4: ruleQualifiedName
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
    // InternalAceGen.g:8069:1: rule__AuthUser__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__AuthUser__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8073:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8074:2: ( RULE_ID )
            {
            // InternalAceGen.g:8074:2: ( RULE_ID )
            // InternalAceGen.g:8075:3: RULE_ID
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
    // InternalAceGen.g:8084:1: rule__AuthUser__AttributesAssignment_1_1 : ( ruleAttribute ) ;
    public final void rule__AuthUser__AttributesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8088:1: ( ( ruleAttribute ) )
            // InternalAceGen.g:8089:2: ( ruleAttribute )
            {
            // InternalAceGen.g:8089:2: ( ruleAttribute )
            // InternalAceGen.g:8090:3: ruleAttribute
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
    // InternalAceGen.g:8099:1: rule__Model__PersistentAssignment_0 : ( ( 'persistent' ) ) ;
    public final void rule__Model__PersistentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8103:1: ( ( ( 'persistent' ) ) )
            // InternalAceGen.g:8104:2: ( ( 'persistent' ) )
            {
            // InternalAceGen.g:8104:2: ( ( 'persistent' ) )
            // InternalAceGen.g:8105:3: ( 'persistent' )
            {
             before(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 
            // InternalAceGen.g:8106:3: ( 'persistent' )
            // InternalAceGen.g:8107:4: 'persistent'
            {
             before(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 
            match(input,74,FOLLOW_2); 
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
    // InternalAceGen.g:8118:1: rule__Model__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8122:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8123:2: ( RULE_ID )
            {
            // InternalAceGen.g:8123:2: ( RULE_ID )
            // InternalAceGen.g:8124:3: RULE_ID
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
    // InternalAceGen.g:8133:1: rule__Model__SuperModelsAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Model__SuperModelsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8137:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8138:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8138:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8139:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0()); 
            // InternalAceGen.g:8140:3: ( ruleQualifiedName )
            // InternalAceGen.g:8141:4: ruleQualifiedName
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
    // InternalAceGen.g:8152:1: rule__Model__SuperModelsAssignment_2_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Model__SuperModelsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8156:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8157:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8157:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8158:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0()); 
            // InternalAceGen.g:8159:3: ( ruleQualifiedName )
            // InternalAceGen.g:8160:4: ruleQualifiedName
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
    // InternalAceGen.g:8171:1: rule__Model__AttributesAssignment_3_1 : ( ruleAttribute ) ;
    public final void rule__Model__AttributesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8175:1: ( ( ruleAttribute ) )
            // InternalAceGen.g:8176:2: ( ruleAttribute )
            {
            // InternalAceGen.g:8176:2: ( ruleAttribute )
            // InternalAceGen.g:8177:3: ruleAttribute
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


    // $ANTLR start "rule__Scenario__NameAssignment_0"
    // InternalAceGen.g:8186:1: rule__Scenario__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Scenario__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8190:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8191:2: ( RULE_ID )
            {
            // InternalAceGen.g:8191:2: ( RULE_ID )
            // InternalAceGen.g:8192:3: RULE_ID
            {
             before(grammarAccess.getScenarioAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getScenarioAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__Scenario__NameAssignment_0"


    // $ANTLR start "rule__Scenario__GivenRefsAssignment_1_1"
    // InternalAceGen.g:8201:1: rule__Scenario__GivenRefsAssignment_1_1 : ( ruleGivenRef ) ;
    public final void rule__Scenario__GivenRefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8205:1: ( ( ruleGivenRef ) )
            // InternalAceGen.g:8206:2: ( ruleGivenRef )
            {
            // InternalAceGen.g:8206:2: ( ruleGivenRef )
            // InternalAceGen.g:8207:3: ruleGivenRef
            {
             before(grammarAccess.getScenarioAccess().getGivenRefsGivenRefParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGivenRef();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getGivenRefsGivenRefParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Scenario__GivenRefsAssignment_1_1"


    // $ANTLR start "rule__Scenario__WhenBlockAssignment_3"
    // InternalAceGen.g:8216:1: rule__Scenario__WhenBlockAssignment_3 : ( ruleWhenBlock ) ;
    public final void rule__Scenario__WhenBlockAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8220:1: ( ( ruleWhenBlock ) )
            // InternalAceGen.g:8221:2: ( ruleWhenBlock )
            {
            // InternalAceGen.g:8221:2: ( ruleWhenBlock )
            // InternalAceGen.g:8222:3: ruleWhenBlock
            {
             before(grammarAccess.getScenarioAccess().getWhenBlockWhenBlockParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleWhenBlock();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getWhenBlockWhenBlockParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Scenario__WhenBlockAssignment_3"


    // $ANTLR start "rule__Scenario__ThenBlockAssignment_5"
    // InternalAceGen.g:8231:1: rule__Scenario__ThenBlockAssignment_5 : ( ruleThenBlock ) ;
    public final void rule__Scenario__ThenBlockAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8235:1: ( ( ruleThenBlock ) )
            // InternalAceGen.g:8236:2: ( ruleThenBlock )
            {
            // InternalAceGen.g:8236:2: ( ruleThenBlock )
            // InternalAceGen.g:8237:3: ruleThenBlock
            {
             before(grammarAccess.getScenarioAccess().getThenBlockThenBlockParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleThenBlock();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getThenBlockThenBlockParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__Scenario__ThenBlockAssignment_5"


    // $ANTLR start "rule__GivenRef__ScenarioAssignment_0"
    // InternalAceGen.g:8246:1: rule__GivenRef__ScenarioAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__GivenRef__ScenarioAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8250:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8251:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8251:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8252:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getGivenRefAccess().getScenarioScenarioCrossReference_0_0()); 
            // InternalAceGen.g:8253:3: ( ruleQualifiedName )
            // InternalAceGen.g:8254:4: ruleQualifiedName
            {
             before(grammarAccess.getGivenRefAccess().getScenarioScenarioQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getGivenRefAccess().getScenarioScenarioQualifiedNameParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getGivenRefAccess().getScenarioScenarioCrossReference_0_0()); 

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
    // $ANTLR end "rule__GivenRef__ScenarioAssignment_0"


    // $ANTLR start "rule__GivenRef__TimesAssignment_1_0"
    // InternalAceGen.g:8265:1: rule__GivenRef__TimesAssignment_1_0 : ( RULE_INT ) ;
    public final void rule__GivenRef__TimesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8269:1: ( ( RULE_INT ) )
            // InternalAceGen.g:8270:2: ( RULE_INT )
            {
            // InternalAceGen.g:8270:2: ( RULE_INT )
            // InternalAceGen.g:8271:3: RULE_INT
            {
             before(grammarAccess.getGivenRefAccess().getTimesINTTerminalRuleCall_1_0_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getGivenRefAccess().getTimesINTTerminalRuleCall_1_0_0()); 

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
    // $ANTLR end "rule__GivenRef__TimesAssignment_1_0"


    // $ANTLR start "rule__GivenRef__ExcludeGivenAssignment_2"
    // InternalAceGen.g:8280:1: rule__GivenRef__ExcludeGivenAssignment_2 : ( ( 'excludeGIVEN' ) ) ;
    public final void rule__GivenRef__ExcludeGivenAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8284:1: ( ( ( 'excludeGIVEN' ) ) )
            // InternalAceGen.g:8285:2: ( ( 'excludeGIVEN' ) )
            {
            // InternalAceGen.g:8285:2: ( ( 'excludeGIVEN' ) )
            // InternalAceGen.g:8286:3: ( 'excludeGIVEN' )
            {
             before(grammarAccess.getGivenRefAccess().getExcludeGivenExcludeGIVENKeyword_2_0()); 
            // InternalAceGen.g:8287:3: ( 'excludeGIVEN' )
            // InternalAceGen.g:8288:4: 'excludeGIVEN'
            {
             before(grammarAccess.getGivenRefAccess().getExcludeGivenExcludeGIVENKeyword_2_0()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getGivenRefAccess().getExcludeGivenExcludeGIVENKeyword_2_0()); 

            }

             after(grammarAccess.getGivenRefAccess().getExcludeGivenExcludeGIVENKeyword_2_0()); 

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
    // $ANTLR end "rule__GivenRef__ExcludeGivenAssignment_2"


    // $ANTLR start "rule__WhenBlock__ActionAssignment_0"
    // InternalAceGen.g:8299:1: rule__WhenBlock__ActionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__WhenBlock__ActionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8303:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8304:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8304:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8305:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getWhenBlockAccess().getActionHttpServerAceCrossReference_0_0()); 
            // InternalAceGen.g:8306:3: ( ruleQualifiedName )
            // InternalAceGen.g:8307:4: ruleQualifiedName
            {
             before(grammarAccess.getWhenBlockAccess().getActionHttpServerAceQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getWhenBlockAccess().getActionHttpServerAceQualifiedNameParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getWhenBlockAccess().getActionHttpServerAceCrossReference_0_0()); 

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
    // $ANTLR end "rule__WhenBlock__ActionAssignment_0"


    // $ANTLR start "rule__WhenBlock__DataDefinitionAssignment_1"
    // InternalAceGen.g:8318:1: rule__WhenBlock__DataDefinitionAssignment_1 : ( ruleDataDefinition ) ;
    public final void rule__WhenBlock__DataDefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8322:1: ( ( ruleDataDefinition ) )
            // InternalAceGen.g:8323:2: ( ruleDataDefinition )
            {
            // InternalAceGen.g:8323:2: ( ruleDataDefinition )
            // InternalAceGen.g:8324:3: ruleDataDefinition
            {
             before(grammarAccess.getWhenBlockAccess().getDataDefinitionDataDefinitionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataDefinition();

            state._fsp--;

             after(grammarAccess.getWhenBlockAccess().getDataDefinitionDataDefinitionParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__WhenBlock__DataDefinitionAssignment_1"


    // $ANTLR start "rule__WhenBlock__AuthorizationAssignment_2"
    // InternalAceGen.g:8333:1: rule__WhenBlock__AuthorizationAssignment_2 : ( ruleAuthorization ) ;
    public final void rule__WhenBlock__AuthorizationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8337:1: ( ( ruleAuthorization ) )
            // InternalAceGen.g:8338:2: ( ruleAuthorization )
            {
            // InternalAceGen.g:8338:2: ( ruleAuthorization )
            // InternalAceGen.g:8339:3: ruleAuthorization
            {
             before(grammarAccess.getWhenBlockAccess().getAuthorizationAuthorizationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAuthorization();

            state._fsp--;

             after(grammarAccess.getWhenBlockAccess().getAuthorizationAuthorizationParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__WhenBlock__AuthorizationAssignment_2"


    // $ANTLR start "rule__ThenBlock__StatusCodeAssignment_0"
    // InternalAceGen.g:8348:1: rule__ThenBlock__StatusCodeAssignment_0 : ( RULE_INT ) ;
    public final void rule__ThenBlock__StatusCodeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8352:1: ( ( RULE_INT ) )
            // InternalAceGen.g:8353:2: ( RULE_INT )
            {
            // InternalAceGen.g:8353:2: ( RULE_INT )
            // InternalAceGen.g:8354:3: RULE_INT
            {
             before(grammarAccess.getThenBlockAccess().getStatusCodeINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getThenBlockAccess().getStatusCodeINTTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__ThenBlock__StatusCodeAssignment_0"


    // $ANTLR start "rule__ThenBlock__ResponseAssignment_1_1"
    // InternalAceGen.g:8363:1: rule__ThenBlock__ResponseAssignment_1_1 : ( ruleDataDefinition ) ;
    public final void rule__ThenBlock__ResponseAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8367:1: ( ( ruleDataDefinition ) )
            // InternalAceGen.g:8368:2: ( ruleDataDefinition )
            {
            // InternalAceGen.g:8368:2: ( ruleDataDefinition )
            // InternalAceGen.g:8369:3: ruleDataDefinition
            {
             before(grammarAccess.getThenBlockAccess().getResponseDataDefinitionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDataDefinition();

            state._fsp--;

             after(grammarAccess.getThenBlockAccess().getResponseDataDefinitionParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__ThenBlock__ResponseAssignment_1_1"


    // $ANTLR start "rule__DataDefinition__UuidAssignment_1_1"
    // InternalAceGen.g:8378:1: rule__DataDefinition__UuidAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__DataDefinition__UuidAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8382:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8383:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8383:2: ( RULE_STRING )
            // InternalAceGen.g:8384:3: RULE_STRING
            {
             before(grammarAccess.getDataDefinitionAccess().getUuidSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getDataDefinitionAccess().getUuidSTRINGTerminalRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__DataDefinition__UuidAssignment_1_1"


    // $ANTLR start "rule__DataDefinition__SystemtimeAssignment_2_1"
    // InternalAceGen.g:8393:1: rule__DataDefinition__SystemtimeAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__DataDefinition__SystemtimeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8397:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8398:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8398:2: ( RULE_STRING )
            // InternalAceGen.g:8399:3: RULE_STRING
            {
             before(grammarAccess.getDataDefinitionAccess().getSystemtimeSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getDataDefinitionAccess().getSystemtimeSTRINGTerminalRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__DataDefinition__SystemtimeAssignment_2_1"


    // $ANTLR start "rule__DataDefinition__PatternAssignment_2_2"
    // InternalAceGen.g:8408:1: rule__DataDefinition__PatternAssignment_2_2 : ( RULE_STRING ) ;
    public final void rule__DataDefinition__PatternAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8412:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8413:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8413:2: ( RULE_STRING )
            // InternalAceGen.g:8414:3: RULE_STRING
            {
             before(grammarAccess.getDataDefinitionAccess().getPatternSTRINGTerminalRuleCall_2_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getDataDefinitionAccess().getPatternSTRINGTerminalRuleCall_2_2_0()); 

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
    // $ANTLR end "rule__DataDefinition__PatternAssignment_2_2"


    // $ANTLR start "rule__DataDefinition__DataAssignment_3"
    // InternalAceGen.g:8423:1: rule__DataDefinition__DataAssignment_3 : ( ruleJsonObject ) ;
    public final void rule__DataDefinition__DataAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8427:1: ( ( ruleJsonObject ) )
            // InternalAceGen.g:8428:2: ( ruleJsonObject )
            {
            // InternalAceGen.g:8428:2: ( ruleJsonObject )
            // InternalAceGen.g:8429:3: ruleJsonObject
            {
             before(grammarAccess.getDataDefinitionAccess().getDataJsonObjectParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleJsonObject();

            state._fsp--;

             after(grammarAccess.getDataDefinitionAccess().getDataJsonObjectParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__DataDefinition__DataAssignment_3"


    // $ANTLR start "rule__Authorization__UsernameAssignment_1"
    // InternalAceGen.g:8438:1: rule__Authorization__UsernameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Authorization__UsernameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8442:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8443:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8443:2: ( RULE_STRING )
            // InternalAceGen.g:8444:3: RULE_STRING
            {
             before(grammarAccess.getAuthorizationAccess().getUsernameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getAuthorizationAccess().getUsernameSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Authorization__UsernameAssignment_1"


    // $ANTLR start "rule__Authorization__PasswordAssignment_3"
    // InternalAceGen.g:8453:1: rule__Authorization__PasswordAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Authorization__PasswordAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8457:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8458:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8458:2: ( RULE_STRING )
            // InternalAceGen.g:8459:3: RULE_STRING
            {
             before(grammarAccess.getAuthorizationAccess().getPasswordSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getAuthorizationAccess().getPasswordSTRINGTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__Authorization__PasswordAssignment_3"


    // $ANTLR start "rule__Attribute__UniqueAssignment_0"
    // InternalAceGen.g:8468:1: rule__Attribute__UniqueAssignment_0 : ( ( 'Unique' ) ) ;
    public final void rule__Attribute__UniqueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8472:1: ( ( ( 'Unique' ) ) )
            // InternalAceGen.g:8473:2: ( ( 'Unique' ) )
            {
            // InternalAceGen.g:8473:2: ( ( 'Unique' ) )
            // InternalAceGen.g:8474:3: ( 'Unique' )
            {
             before(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 
            // InternalAceGen.g:8475:3: ( 'Unique' )
            // InternalAceGen.g:8476:4: 'Unique'
            {
             before(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 
            match(input,76,FOLLOW_2); 
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
    // InternalAceGen.g:8487:1: rule__Attribute__PrimaryKeyAssignment_1 : ( ( 'PrimaryKey' ) ) ;
    public final void rule__Attribute__PrimaryKeyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8491:1: ( ( ( 'PrimaryKey' ) ) )
            // InternalAceGen.g:8492:2: ( ( 'PrimaryKey' ) )
            {
            // InternalAceGen.g:8492:2: ( ( 'PrimaryKey' ) )
            // InternalAceGen.g:8493:3: ( 'PrimaryKey' )
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 
            // InternalAceGen.g:8494:3: ( 'PrimaryKey' )
            // InternalAceGen.g:8495:4: 'PrimaryKey'
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 
            match(input,77,FOLLOW_2); 
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


    // $ANTLR start "rule__Attribute__NotNullAssignment_2"
    // InternalAceGen.g:8506:1: rule__Attribute__NotNullAssignment_2 : ( ( 'NotNull' ) ) ;
    public final void rule__Attribute__NotNullAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8510:1: ( ( ( 'NotNull' ) ) )
            // InternalAceGen.g:8511:2: ( ( 'NotNull' ) )
            {
            // InternalAceGen.g:8511:2: ( ( 'NotNull' ) )
            // InternalAceGen.g:8512:3: ( 'NotNull' )
            {
             before(grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_2_0()); 
            // InternalAceGen.g:8513:3: ( 'NotNull' )
            // InternalAceGen.g:8514:4: 'NotNull'
            {
             before(grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_2_0()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_2_0()); 

            }

             after(grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_2_0()); 

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
    // $ANTLR end "rule__Attribute__NotNullAssignment_2"


    // $ANTLR start "rule__Attribute__ListAssignment_3"
    // InternalAceGen.g:8525:1: rule__Attribute__ListAssignment_3 : ( ( 'List' ) ) ;
    public final void rule__Attribute__ListAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8529:1: ( ( ( 'List' ) ) )
            // InternalAceGen.g:8530:2: ( ( 'List' ) )
            {
            // InternalAceGen.g:8530:2: ( ( 'List' ) )
            // InternalAceGen.g:8531:3: ( 'List' )
            {
             before(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 
            // InternalAceGen.g:8532:3: ( 'List' )
            // InternalAceGen.g:8533:4: 'List'
            {
             before(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 
            match(input,79,FOLLOW_2); 
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
    // InternalAceGen.g:8544:1: rule__Attribute__TypeAssignment_4_0 : ( ruleType ) ;
    public final void rule__Attribute__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8548:1: ( ( ruleType ) )
            // InternalAceGen.g:8549:2: ( ruleType )
            {
            // InternalAceGen.g:8549:2: ( ruleType )
            // InternalAceGen.g:8550:3: ruleType
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
    // InternalAceGen.g:8559:1: rule__Attribute__ModelAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Attribute__ModelAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8563:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8564:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8564:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8565:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeAccess().getModelModelCrossReference_4_1_0()); 
            // InternalAceGen.g:8566:3: ( ruleQualifiedName )
            // InternalAceGen.g:8567:4: ruleQualifiedName
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
    // InternalAceGen.g:8578:1: rule__Attribute__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8582:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8583:2: ( RULE_ID )
            {
            // InternalAceGen.g:8583:2: ( RULE_ID )
            // InternalAceGen.g:8584:3: RULE_ID
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
    // InternalAceGen.g:8593:1: rule__Attribute__ForeignKeyAssignment_6_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Attribute__ForeignKeyAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8597:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8598:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8598:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8599:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0()); 
            // InternalAceGen.g:8600:3: ( ruleQualifiedName )
            // InternalAceGen.g:8601:4: ruleQualifiedName
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


    // $ANTLR start "rule__Attribute__NotReplayableAssignment_7"
    // InternalAceGen.g:8612:1: rule__Attribute__NotReplayableAssignment_7 : ( ( 'notReplayable' ) ) ;
    public final void rule__Attribute__NotReplayableAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8616:1: ( ( ( 'notReplayable' ) ) )
            // InternalAceGen.g:8617:2: ( ( 'notReplayable' ) )
            {
            // InternalAceGen.g:8617:2: ( ( 'notReplayable' ) )
            // InternalAceGen.g:8618:3: ( 'notReplayable' )
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableNotReplayableKeyword_7_0()); 
            // InternalAceGen.g:8619:3: ( 'notReplayable' )
            // InternalAceGen.g:8620:4: 'notReplayable'
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableNotReplayableKeyword_7_0()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNotReplayableNotReplayableKeyword_7_0()); 

            }

             after(grammarAccess.getAttributeAccess().getNotReplayableNotReplayableKeyword_7_0()); 

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
    // $ANTLR end "rule__Attribute__NotReplayableAssignment_7"


    // $ANTLR start "rule__JsonDateTime__DateTimeAssignment_0"
    // InternalAceGen.g:8631:1: rule__JsonDateTime__DateTimeAssignment_0 : ( RULE_STRING ) ;
    public final void rule__JsonDateTime__DateTimeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8635:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8636:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8636:2: ( RULE_STRING )
            // InternalAceGen.g:8637:3: RULE_STRING
            {
             before(grammarAccess.getJsonDateTimeAccess().getDateTimeSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getJsonDateTimeAccess().getDateTimeSTRINGTerminalRuleCall_0_0()); 

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
    // $ANTLR end "rule__JsonDateTime__DateTimeAssignment_0"


    // $ANTLR start "rule__JsonDateTime__PatternAssignment_1"
    // InternalAceGen.g:8646:1: rule__JsonDateTime__PatternAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JsonDateTime__PatternAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8650:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8651:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8651:2: ( RULE_STRING )
            // InternalAceGen.g:8652:3: RULE_STRING
            {
             before(grammarAccess.getJsonDateTimeAccess().getPatternSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getJsonDateTimeAccess().getPatternSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__JsonDateTime__PatternAssignment_1"


    // $ANTLR start "rule__JsonObject__MembersAssignment_2"
    // InternalAceGen.g:8661:1: rule__JsonObject__MembersAssignment_2 : ( ruleJsonMember ) ;
    public final void rule__JsonObject__MembersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8665:1: ( ( ruleJsonMember ) )
            // InternalAceGen.g:8666:2: ( ruleJsonMember )
            {
            // InternalAceGen.g:8666:2: ( ruleJsonMember )
            // InternalAceGen.g:8667:3: ruleJsonMember
            {
             before(grammarAccess.getJsonObjectAccess().getMembersJsonMemberParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleJsonMember();

            state._fsp--;

             after(grammarAccess.getJsonObjectAccess().getMembersJsonMemberParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__JsonObject__MembersAssignment_2"


    // $ANTLR start "rule__JsonObject__MembersAssignment_3_1"
    // InternalAceGen.g:8676:1: rule__JsonObject__MembersAssignment_3_1 : ( ruleJsonMember ) ;
    public final void rule__JsonObject__MembersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8680:1: ( ( ruleJsonMember ) )
            // InternalAceGen.g:8681:2: ( ruleJsonMember )
            {
            // InternalAceGen.g:8681:2: ( ruleJsonMember )
            // InternalAceGen.g:8682:3: ruleJsonMember
            {
             before(grammarAccess.getJsonObjectAccess().getMembersJsonMemberParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJsonMember();

            state._fsp--;

             after(grammarAccess.getJsonObjectAccess().getMembersJsonMemberParserRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__JsonObject__MembersAssignment_3_1"


    // $ANTLR start "rule__JsonMember__AttributeAssignment_0"
    // InternalAceGen.g:8691:1: rule__JsonMember__AttributeAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__JsonMember__AttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8695:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8696:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8696:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8697:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getJsonMemberAccess().getAttributeAttributeCrossReference_0_0()); 
            // InternalAceGen.g:8698:3: ( ruleQualifiedName )
            // InternalAceGen.g:8699:4: ruleQualifiedName
            {
             before(grammarAccess.getJsonMemberAccess().getAttributeAttributeQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getJsonMemberAccess().getAttributeAttributeQualifiedNameParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getJsonMemberAccess().getAttributeAttributeCrossReference_0_0()); 

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
    // $ANTLR end "rule__JsonMember__AttributeAssignment_0"


    // $ANTLR start "rule__JsonMember__ValueAssignment_2"
    // InternalAceGen.g:8710:1: rule__JsonMember__ValueAssignment_2 : ( ruleJsonValue ) ;
    public final void rule__JsonMember__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8714:1: ( ( ruleJsonValue ) )
            // InternalAceGen.g:8715:2: ( ruleJsonValue )
            {
            // InternalAceGen.g:8715:2: ( ruleJsonValue )
            // InternalAceGen.g:8716:3: ruleJsonValue
            {
             before(grammarAccess.getJsonMemberAccess().getValueJsonValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleJsonValue();

            state._fsp--;

             after(grammarAccess.getJsonMemberAccess().getValueJsonValueParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__JsonMember__ValueAssignment_2"


    // $ANTLR start "rule__JsonValue__StringAssignment_1"
    // InternalAceGen.g:8725:1: rule__JsonValue__StringAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JsonValue__StringAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8729:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8730:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8730:2: ( RULE_STRING )
            // InternalAceGen.g:8731:3: RULE_STRING
            {
             before(grammarAccess.getJsonValueAccess().getStringSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getJsonValueAccess().getStringSTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__JsonValue__StringAssignment_1"


    // $ANTLR start "rule__JsonValue__BooleanAssignment_3"
    // InternalAceGen.g:8740:1: rule__JsonValue__BooleanAssignment_3 : ( ruleJsonBoolean ) ;
    public final void rule__JsonValue__BooleanAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8744:1: ( ( ruleJsonBoolean ) )
            // InternalAceGen.g:8745:2: ( ruleJsonBoolean )
            {
            // InternalAceGen.g:8745:2: ( ruleJsonBoolean )
            // InternalAceGen.g:8746:3: ruleJsonBoolean
            {
             before(grammarAccess.getJsonValueAccess().getBooleanJsonBooleanParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleJsonBoolean();

            state._fsp--;

             after(grammarAccess.getJsonValueAccess().getBooleanJsonBooleanParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__JsonValue__BooleanAssignment_3"


    // $ANTLR start "rule__JsonValue__NullAssignment_4"
    // InternalAceGen.g:8755:1: rule__JsonValue__NullAssignment_4 : ( ruleJsonNull ) ;
    public final void rule__JsonValue__NullAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8759:1: ( ( ruleJsonNull ) )
            // InternalAceGen.g:8760:2: ( ruleJsonNull )
            {
            // InternalAceGen.g:8760:2: ( ruleJsonNull )
            // InternalAceGen.g:8761:3: ruleJsonNull
            {
             before(grammarAccess.getJsonValueAccess().getNullJsonNullParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleJsonNull();

            state._fsp--;

             after(grammarAccess.getJsonValueAccess().getNullJsonNullParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__JsonValue__NullAssignment_4"


    // $ANTLR start "rule__JsonValue__LongAssignment_5"
    // InternalAceGen.g:8770:1: rule__JsonValue__LongAssignment_5 : ( RULE_INT ) ;
    public final void rule__JsonValue__LongAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8774:1: ( ( RULE_INT ) )
            // InternalAceGen.g:8775:2: ( RULE_INT )
            {
            // InternalAceGen.g:8775:2: ( RULE_INT )
            // InternalAceGen.g:8776:3: RULE_INT
            {
             before(grammarAccess.getJsonValueAccess().getLongINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getJsonValueAccess().getLongINTTerminalRuleCall_5_0()); 

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
    // $ANTLR end "rule__JsonValue__LongAssignment_5"


    // $ANTLR start "rule__JsonArray__ValuesAssignment_2"
    // InternalAceGen.g:8785:1: rule__JsonArray__ValuesAssignment_2 : ( ruleJsonValue ) ;
    public final void rule__JsonArray__ValuesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8789:1: ( ( ruleJsonValue ) )
            // InternalAceGen.g:8790:2: ( ruleJsonValue )
            {
            // InternalAceGen.g:8790:2: ( ruleJsonValue )
            // InternalAceGen.g:8791:3: ruleJsonValue
            {
             before(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleJsonValue();

            state._fsp--;

             after(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__JsonArray__ValuesAssignment_2"


    // $ANTLR start "rule__JsonArray__ValuesAssignment_3_1"
    // InternalAceGen.g:8800:1: rule__JsonArray__ValuesAssignment_3_1 : ( ruleJsonValue ) ;
    public final void rule__JsonArray__ValuesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8804:1: ( ( ruleJsonValue ) )
            // InternalAceGen.g:8805:2: ( ruleJsonValue )
            {
            // InternalAceGen.g:8805:2: ( ruleJsonValue )
            // InternalAceGen.g:8806:3: ruleJsonValue
            {
             before(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJsonValue();

            state._fsp--;

             after(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__JsonArray__ValuesAssignment_3_1"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\2\4\1\40\1\4\1\41\1\4\1\13\1\41\2\uffff";
    static final String dfa_3s = "\1\107\1\4\1\40\1\4\1\77\1\4\1\23\1\77\2\uffff";
    static final String dfa_4s = "\10\uffff\1\1\1\2";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\102\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\35\uffff\1\5",
            "\1\7",
            "\1\11\5\uffff\3\10",
            "\1\6\35\uffff\1\5",
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
            return "1006:1: rule__HttpServerAce__Alternatives : ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000040L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000004L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000003900000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000800001E000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000008000000010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000100000000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0003E00040000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000080L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000080L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000400L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000400L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x003C002000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x003C000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000100003F00010L,0x000000000000F000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000003F00012L,0x000000000000F000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040080000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0280000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000800L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x1800080000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000003F00010L,0x000000000000F000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x4000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000100400000010L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x000008000C001060L,0x0000000000000001L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x000008040C001060L,0x0000000000000003L});

}