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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'GET'", "'null'", "'set'", "'merge'", "'reset'", "'init'", "'Dropwizard'", "'SpringBoot'", "'POST'", "'PUT'", "'DELETE'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'Long'", "'true'", "'false'", "'HttpClient'", "'HttpServer'", "'ACE'", "'appState'", "'<'", "'>'", "','", "'call'", "'loadingFlag'", "'on'", "'('", "')'", "'triggers'", "'|'", "':'", "'{'", "'}'", "'Authorization'", "'import'", "'views'", "'models'", "'scenarios'", "'pathParams'", "'queryParams'", "'payload'", "'response'", "'extends'", "'WHEN'", "'THEN'", "'GIVEN'", "'x'", "'uuid'", "'systemTime'", "'authorization'", "'references'", "'.'", "'['", "']'", "'async'", "'list'", "'location.hash'", "'storage'", "'proxy'", "'authorize'", "'optional'", "'persistent'", "'excludeGIVEN'", "'Unique'", "'PrimaryKey'", "'NotNull'", "'List'", "'notReplayable'"
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
    public static final int T__81=81;
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

            if ( (LA1_0==30) ) {
                alt1=1;
            }
            else if ( (LA1_0==31) ) {
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


    // $ANTLR start "rule__HttpServer__TypeAlternatives_0_0"
    // InternalAceGen.g:1006:1: rule__HttpServer__TypeAlternatives_0_0 : ( ( 'Dropwizard' ) | ( 'SpringBoot' ) );
    public final void rule__HttpServer__TypeAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1010:1: ( ( 'Dropwizard' ) | ( 'SpringBoot' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalAceGen.g:1011:2: ( 'Dropwizard' )
                    {
                    // InternalAceGen.g:1011:2: ( 'Dropwizard' )
                    // InternalAceGen.g:1012:3: 'Dropwizard'
                    {
                     before(grammarAccess.getHttpServerAccess().getTypeDropwizardKeyword_0_0_0()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getHttpServerAccess().getTypeDropwizardKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1017:2: ( 'SpringBoot' )
                    {
                    // InternalAceGen.g:1017:2: ( 'SpringBoot' )
                    // InternalAceGen.g:1018:3: 'SpringBoot'
                    {
                     before(grammarAccess.getHttpServerAccess().getTypeSpringBootKeyword_0_0_1()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getHttpServerAccess().getTypeSpringBootKeyword_0_0_1()); 

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
    // $ANTLR end "rule__HttpServer__TypeAlternatives_0_0"


    // $ANTLR start "rule__HttpServerAce__Alternatives"
    // InternalAceGen.g:1027:1: rule__HttpServerAce__Alternatives : ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) );
    public final void rule__HttpServerAce__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1031:1: ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalAceGen.g:1032:2: ( ruleHttpServerAceWrite )
                    {
                    // InternalAceGen.g:1032:2: ( ruleHttpServerAceWrite )
                    // InternalAceGen.g:1033:3: ruleHttpServerAceWrite
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
                    // InternalAceGen.g:1038:2: ( ruleHttpServerAceRead )
                    {
                    // InternalAceGen.g:1038:2: ( ruleHttpServerAceRead )
                    // InternalAceGen.g:1039:3: ruleHttpServerAceRead
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
    // InternalAceGen.g:1048:1: rule__Attribute__Alternatives_4 : ( ( ( rule__Attribute__TypeAssignment_4_0 ) ) | ( ( rule__Attribute__ModelAssignment_4_1 ) ) );
    public final void rule__Attribute__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1052:1: ( ( ( rule__Attribute__TypeAssignment_4_0 ) ) | ( ( rule__Attribute__ModelAssignment_4_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=22 && LA5_0<=27)) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalAceGen.g:1053:2: ( ( rule__Attribute__TypeAssignment_4_0 ) )
                    {
                    // InternalAceGen.g:1053:2: ( ( rule__Attribute__TypeAssignment_4_0 ) )
                    // InternalAceGen.g:1054:3: ( rule__Attribute__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getAttributeAccess().getTypeAssignment_4_0()); 
                    // InternalAceGen.g:1055:3: ( rule__Attribute__TypeAssignment_4_0 )
                    // InternalAceGen.g:1055:4: rule__Attribute__TypeAssignment_4_0
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
                    // InternalAceGen.g:1059:2: ( ( rule__Attribute__ModelAssignment_4_1 ) )
                    {
                    // InternalAceGen.g:1059:2: ( ( rule__Attribute__ModelAssignment_4_1 ) )
                    // InternalAceGen.g:1060:3: ( rule__Attribute__ModelAssignment_4_1 )
                    {
                     before(grammarAccess.getAttributeAccess().getModelAssignment_4_1()); 
                    // InternalAceGen.g:1061:3: ( rule__Attribute__ModelAssignment_4_1 )
                    // InternalAceGen.g:1061:4: rule__Attribute__ModelAssignment_4_1
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
    // InternalAceGen.g:1069:1: rule__WriteFunctionType__Alternatives : ( ( 'POST' ) | ( 'PUT' ) | ( 'DELETE' ) );
    public final void rule__WriteFunctionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1073:1: ( ( 'POST' ) | ( 'PUT' ) | ( 'DELETE' ) )
            int alt6=3;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalAceGen.g:1074:2: ( 'POST' )
                    {
                    // InternalAceGen.g:1074:2: ( 'POST' )
                    // InternalAceGen.g:1075:3: 'POST'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1080:2: ( 'PUT' )
                    {
                    // InternalAceGen.g:1080:2: ( 'PUT' )
                    // InternalAceGen.g:1081:3: 'PUT'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:1086:2: ( 'DELETE' )
                    {
                    // InternalAceGen.g:1086:2: ( 'DELETE' )
                    // InternalAceGen.g:1087:3: 'DELETE'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getDELETEKeyword_2()); 
                    match(input,21,FOLLOW_2); 
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
    // InternalAceGen.g:1096:1: rule__Type__Alternatives : ( ( 'Integer' ) | ( 'String' ) | ( 'Float' ) | ( 'Boolean' ) | ( 'DateTime' ) | ( 'Long' ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1100:1: ( ( 'Integer' ) | ( 'String' ) | ( 'Float' ) | ( 'Boolean' ) | ( 'DateTime' ) | ( 'Long' ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt7=1;
                }
                break;
            case 23:
                {
                alt7=2;
                }
                break;
            case 24:
                {
                alt7=3;
                }
                break;
            case 25:
                {
                alt7=4;
                }
                break;
            case 26:
                {
                alt7=5;
                }
                break;
            case 27:
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
                    // InternalAceGen.g:1101:2: ( 'Integer' )
                    {
                    // InternalAceGen.g:1101:2: ( 'Integer' )
                    // InternalAceGen.g:1102:3: 'Integer'
                    {
                     before(grammarAccess.getTypeAccess().getIntegerKeyword_0()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getIntegerKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1107:2: ( 'String' )
                    {
                    // InternalAceGen.g:1107:2: ( 'String' )
                    // InternalAceGen.g:1108:3: 'String'
                    {
                     before(grammarAccess.getTypeAccess().getStringKeyword_1()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getStringKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:1113:2: ( 'Float' )
                    {
                    // InternalAceGen.g:1113:2: ( 'Float' )
                    // InternalAceGen.g:1114:3: 'Float'
                    {
                     before(grammarAccess.getTypeAccess().getFloatKeyword_2()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getFloatKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:1119:2: ( 'Boolean' )
                    {
                    // InternalAceGen.g:1119:2: ( 'Boolean' )
                    // InternalAceGen.g:1120:3: 'Boolean'
                    {
                     before(grammarAccess.getTypeAccess().getBooleanKeyword_3()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getBooleanKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalAceGen.g:1125:2: ( 'DateTime' )
                    {
                    // InternalAceGen.g:1125:2: ( 'DateTime' )
                    // InternalAceGen.g:1126:3: 'DateTime'
                    {
                     before(grammarAccess.getTypeAccess().getDateTimeKeyword_4()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getDateTimeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalAceGen.g:1131:2: ( 'Long' )
                    {
                    // InternalAceGen.g:1131:2: ( 'Long' )
                    // InternalAceGen.g:1132:3: 'Long'
                    {
                     before(grammarAccess.getTypeAccess().getLongKeyword_5()); 
                    match(input,27,FOLLOW_2); 
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
    // InternalAceGen.g:1141:1: rule__JsonValue__Alternatives : ( ( ruleJsonObject ) | ( ( rule__JsonValue__StringAssignment_1 ) ) | ( ruleJsonArray ) | ( ( rule__JsonValue__BooleanAssignment_3 ) ) | ( ( rule__JsonValue__NullAssignment_4 ) ) | ( ( rule__JsonValue__LongAssignment_5 ) ) | ( ruleJsonDateTime ) );
    public final void rule__JsonValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1145:1: ( ( ruleJsonObject ) | ( ( rule__JsonValue__StringAssignment_1 ) ) | ( ruleJsonArray ) | ( ( rule__JsonValue__BooleanAssignment_3 ) ) | ( ( rule__JsonValue__NullAssignment_4 ) ) | ( ( rule__JsonValue__LongAssignment_5 ) ) | ( ruleJsonDateTime ) )
            int alt8=7;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt8=1;
                }
                break;
            case RULE_STRING:
                {
                int LA8_2 = input.LA(2);

                if ( (LA8_2==EOF||LA8_2==36||LA8_2==46||LA8_2==67) ) {
                    alt8=2;
                }
                else if ( (LA8_2==RULE_STRING) ) {
                    alt8=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;
                }
                }
                break;
            case 66:
                {
                alt8=3;
                }
                break;
            case 28:
            case 29:
                {
                alt8=4;
                }
                break;
            case 12:
                {
                alt8=5;
                }
                break;
            case RULE_INT:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalAceGen.g:1146:2: ( ruleJsonObject )
                    {
                    // InternalAceGen.g:1146:2: ( ruleJsonObject )
                    // InternalAceGen.g:1147:3: ruleJsonObject
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
                    // InternalAceGen.g:1152:2: ( ( rule__JsonValue__StringAssignment_1 ) )
                    {
                    // InternalAceGen.g:1152:2: ( ( rule__JsonValue__StringAssignment_1 ) )
                    // InternalAceGen.g:1153:3: ( rule__JsonValue__StringAssignment_1 )
                    {
                     before(grammarAccess.getJsonValueAccess().getStringAssignment_1()); 
                    // InternalAceGen.g:1154:3: ( rule__JsonValue__StringAssignment_1 )
                    // InternalAceGen.g:1154:4: rule__JsonValue__StringAssignment_1
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
                    // InternalAceGen.g:1158:2: ( ruleJsonArray )
                    {
                    // InternalAceGen.g:1158:2: ( ruleJsonArray )
                    // InternalAceGen.g:1159:3: ruleJsonArray
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
                    // InternalAceGen.g:1164:2: ( ( rule__JsonValue__BooleanAssignment_3 ) )
                    {
                    // InternalAceGen.g:1164:2: ( ( rule__JsonValue__BooleanAssignment_3 ) )
                    // InternalAceGen.g:1165:3: ( rule__JsonValue__BooleanAssignment_3 )
                    {
                     before(grammarAccess.getJsonValueAccess().getBooleanAssignment_3()); 
                    // InternalAceGen.g:1166:3: ( rule__JsonValue__BooleanAssignment_3 )
                    // InternalAceGen.g:1166:4: rule__JsonValue__BooleanAssignment_3
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
                    // InternalAceGen.g:1170:2: ( ( rule__JsonValue__NullAssignment_4 ) )
                    {
                    // InternalAceGen.g:1170:2: ( ( rule__JsonValue__NullAssignment_4 ) )
                    // InternalAceGen.g:1171:3: ( rule__JsonValue__NullAssignment_4 )
                    {
                     before(grammarAccess.getJsonValueAccess().getNullAssignment_4()); 
                    // InternalAceGen.g:1172:3: ( rule__JsonValue__NullAssignment_4 )
                    // InternalAceGen.g:1172:4: rule__JsonValue__NullAssignment_4
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
                    // InternalAceGen.g:1176:2: ( ( rule__JsonValue__LongAssignment_5 ) )
                    {
                    // InternalAceGen.g:1176:2: ( ( rule__JsonValue__LongAssignment_5 ) )
                    // InternalAceGen.g:1177:3: ( rule__JsonValue__LongAssignment_5 )
                    {
                     before(grammarAccess.getJsonValueAccess().getLongAssignment_5()); 
                    // InternalAceGen.g:1178:3: ( rule__JsonValue__LongAssignment_5 )
                    // InternalAceGen.g:1178:4: rule__JsonValue__LongAssignment_5
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
                    // InternalAceGen.g:1182:2: ( ruleJsonDateTime )
                    {
                    // InternalAceGen.g:1182:2: ( ruleJsonDateTime )
                    // InternalAceGen.g:1183:3: ruleJsonDateTime
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
    // InternalAceGen.g:1192:1: rule__JsonBoolean__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__JsonBoolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1196:1: ( ( 'true' ) | ( 'false' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==28) ) {
                alt9=1;
            }
            else if ( (LA9_0==29) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalAceGen.g:1197:2: ( 'true' )
                    {
                    // InternalAceGen.g:1197:2: ( 'true' )
                    // InternalAceGen.g:1198:3: 'true'
                    {
                     before(grammarAccess.getJsonBooleanAccess().getTrueKeyword_0()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getJsonBooleanAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1203:2: ( 'false' )
                    {
                    // InternalAceGen.g:1203:2: ( 'false' )
                    // InternalAceGen.g:1204:3: 'false'
                    {
                     before(grammarAccess.getJsonBooleanAccess().getFalseKeyword_1()); 
                    match(input,29,FOLLOW_2); 
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
    // InternalAceGen.g:1213:1: rule__Project__Group__0 : rule__Project__Group__0__Impl rule__Project__Group__1 ;
    public final void rule__Project__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1217:1: ( rule__Project__Group__0__Impl rule__Project__Group__1 )
            // InternalAceGen.g:1218:2: rule__Project__Group__0__Impl rule__Project__Group__1
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
    // InternalAceGen.g:1225:1: rule__Project__Group__0__Impl : ( () ) ;
    public final void rule__Project__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1229:1: ( ( () ) )
            // InternalAceGen.g:1230:1: ( () )
            {
            // InternalAceGen.g:1230:1: ( () )
            // InternalAceGen.g:1231:2: ()
            {
             before(grammarAccess.getProjectAccess().getProjectAction_0()); 
            // InternalAceGen.g:1232:2: ()
            // InternalAceGen.g:1232:3: 
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
    // InternalAceGen.g:1240:1: rule__Project__Group__1 : rule__Project__Group__1__Impl ;
    public final void rule__Project__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1244:1: ( rule__Project__Group__1__Impl )
            // InternalAceGen.g:1245:2: rule__Project__Group__1__Impl
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
    // InternalAceGen.g:1251:1: rule__Project__Group__1__Impl : ( ( rule__Project__Alternatives_1 )? ) ;
    public final void rule__Project__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1255:1: ( ( ( rule__Project__Alternatives_1 )? ) )
            // InternalAceGen.g:1256:1: ( ( rule__Project__Alternatives_1 )? )
            {
            // InternalAceGen.g:1256:1: ( ( rule__Project__Alternatives_1 )? )
            // InternalAceGen.g:1257:2: ( rule__Project__Alternatives_1 )?
            {
             before(grammarAccess.getProjectAccess().getAlternatives_1()); 
            // InternalAceGen.g:1258:2: ( rule__Project__Alternatives_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=30 && LA10_0<=31)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAceGen.g:1258:3: rule__Project__Alternatives_1
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
    // InternalAceGen.g:1267:1: rule__Project__Group_1_0__0 : rule__Project__Group_1_0__0__Impl rule__Project__Group_1_0__1 ;
    public final void rule__Project__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1271:1: ( rule__Project__Group_1_0__0__Impl rule__Project__Group_1_0__1 )
            // InternalAceGen.g:1272:2: rule__Project__Group_1_0__0__Impl rule__Project__Group_1_0__1
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
    // InternalAceGen.g:1279:1: rule__Project__Group_1_0__0__Impl : ( 'HttpClient' ) ;
    public final void rule__Project__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1283:1: ( ( 'HttpClient' ) )
            // InternalAceGen.g:1284:1: ( 'HttpClient' )
            {
            // InternalAceGen.g:1284:1: ( 'HttpClient' )
            // InternalAceGen.g:1285:2: 'HttpClient'
            {
             before(grammarAccess.getProjectAccess().getHttpClientKeyword_1_0_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalAceGen.g:1294:1: rule__Project__Group_1_0__1 : rule__Project__Group_1_0__1__Impl ;
    public final void rule__Project__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1298:1: ( rule__Project__Group_1_0__1__Impl )
            // InternalAceGen.g:1299:2: rule__Project__Group_1_0__1__Impl
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
    // InternalAceGen.g:1305:1: rule__Project__Group_1_0__1__Impl : ( ( rule__Project__HttpClientAssignment_1_0_1 )? ) ;
    public final void rule__Project__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1309:1: ( ( ( rule__Project__HttpClientAssignment_1_0_1 )? ) )
            // InternalAceGen.g:1310:1: ( ( rule__Project__HttpClientAssignment_1_0_1 )? )
            {
            // InternalAceGen.g:1310:1: ( ( rule__Project__HttpClientAssignment_1_0_1 )? )
            // InternalAceGen.g:1311:2: ( rule__Project__HttpClientAssignment_1_0_1 )?
            {
             before(grammarAccess.getProjectAccess().getHttpClientAssignment_1_0_1()); 
            // InternalAceGen.g:1312:2: ( rule__Project__HttpClientAssignment_1_0_1 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAceGen.g:1312:3: rule__Project__HttpClientAssignment_1_0_1
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
    // InternalAceGen.g:1321:1: rule__Project__Group_1_1__0 : rule__Project__Group_1_1__0__Impl rule__Project__Group_1_1__1 ;
    public final void rule__Project__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1325:1: ( rule__Project__Group_1_1__0__Impl rule__Project__Group_1_1__1 )
            // InternalAceGen.g:1326:2: rule__Project__Group_1_1__0__Impl rule__Project__Group_1_1__1
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
    // InternalAceGen.g:1333:1: rule__Project__Group_1_1__0__Impl : ( 'HttpServer' ) ;
    public final void rule__Project__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1337:1: ( ( 'HttpServer' ) )
            // InternalAceGen.g:1338:1: ( 'HttpServer' )
            {
            // InternalAceGen.g:1338:1: ( 'HttpServer' )
            // InternalAceGen.g:1339:2: 'HttpServer'
            {
             before(grammarAccess.getProjectAccess().getHttpServerKeyword_1_1_0()); 
            match(input,31,FOLLOW_2); 
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
    // InternalAceGen.g:1348:1: rule__Project__Group_1_1__1 : rule__Project__Group_1_1__1__Impl ;
    public final void rule__Project__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1352:1: ( rule__Project__Group_1_1__1__Impl )
            // InternalAceGen.g:1353:2: rule__Project__Group_1_1__1__Impl
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
    // InternalAceGen.g:1359:1: rule__Project__Group_1_1__1__Impl : ( ( rule__Project__HttpServerAssignment_1_1_1 )? ) ;
    public final void rule__Project__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1363:1: ( ( ( rule__Project__HttpServerAssignment_1_1_1 )? ) )
            // InternalAceGen.g:1364:1: ( ( rule__Project__HttpServerAssignment_1_1_1 )? )
            {
            // InternalAceGen.g:1364:1: ( ( rule__Project__HttpServerAssignment_1_1_1 )? )
            // InternalAceGen.g:1365:2: ( rule__Project__HttpServerAssignment_1_1_1 )?
            {
             before(grammarAccess.getProjectAccess().getHttpServerAssignment_1_1_1()); 
            // InternalAceGen.g:1366:2: ( rule__Project__HttpServerAssignment_1_1_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||(LA12_0>=17 && LA12_0<=18)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalAceGen.g:1366:3: rule__Project__HttpServerAssignment_1_1_1
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
    // InternalAceGen.g:1375:1: rule__HttpClient__Group__0 : rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1 ;
    public final void rule__HttpClient__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1379:1: ( rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1 )
            // InternalAceGen.g:1380:2: rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1
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
    // InternalAceGen.g:1387:1: rule__HttpClient__Group__0__Impl : ( ( rule__HttpClient__NameAssignment_0 ) ) ;
    public final void rule__HttpClient__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1391:1: ( ( ( rule__HttpClient__NameAssignment_0 ) ) )
            // InternalAceGen.g:1392:1: ( ( rule__HttpClient__NameAssignment_0 ) )
            {
            // InternalAceGen.g:1392:1: ( ( rule__HttpClient__NameAssignment_0 ) )
            // InternalAceGen.g:1393:2: ( rule__HttpClient__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientAccess().getNameAssignment_0()); 
            // InternalAceGen.g:1394:2: ( rule__HttpClient__NameAssignment_0 )
            // InternalAceGen.g:1394:3: rule__HttpClient__NameAssignment_0
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
    // InternalAceGen.g:1402:1: rule__HttpClient__Group__1 : rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2 ;
    public final void rule__HttpClient__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1406:1: ( rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2 )
            // InternalAceGen.g:1407:2: rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2
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
    // InternalAceGen.g:1414:1: rule__HttpClient__Group__1__Impl : ( ( rule__HttpClient__Group_1__0 )? ) ;
    public final void rule__HttpClient__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1418:1: ( ( ( rule__HttpClient__Group_1__0 )? ) )
            // InternalAceGen.g:1419:1: ( ( rule__HttpClient__Group_1__0 )? )
            {
            // InternalAceGen.g:1419:1: ( ( rule__HttpClient__Group_1__0 )? )
            // InternalAceGen.g:1420:2: ( rule__HttpClient__Group_1__0 )?
            {
             before(grammarAccess.getHttpClientAccess().getGroup_1()); 
            // InternalAceGen.g:1421:2: ( rule__HttpClient__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==32) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalAceGen.g:1421:3: rule__HttpClient__Group_1__0
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
    // InternalAceGen.g:1429:1: rule__HttpClient__Group__2 : rule__HttpClient__Group__2__Impl ;
    public final void rule__HttpClient__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1433:1: ( rule__HttpClient__Group__2__Impl )
            // InternalAceGen.g:1434:2: rule__HttpClient__Group__2__Impl
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
    // InternalAceGen.g:1440:1: rule__HttpClient__Group__2__Impl : ( ( rule__HttpClient__Group_2__0 )? ) ;
    public final void rule__HttpClient__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1444:1: ( ( ( rule__HttpClient__Group_2__0 )? ) )
            // InternalAceGen.g:1445:1: ( ( rule__HttpClient__Group_2__0 )? )
            {
            // InternalAceGen.g:1445:1: ( ( rule__HttpClient__Group_2__0 )? )
            // InternalAceGen.g:1446:2: ( rule__HttpClient__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientAccess().getGroup_2()); 
            // InternalAceGen.g:1447:2: ( rule__HttpClient__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==33) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalAceGen.g:1447:3: rule__HttpClient__Group_2__0
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
    // InternalAceGen.g:1456:1: rule__HttpClient__Group_1__0 : rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1 ;
    public final void rule__HttpClient__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1460:1: ( rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1 )
            // InternalAceGen.g:1461:2: rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1
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
    // InternalAceGen.g:1468:1: rule__HttpClient__Group_1__0__Impl : ( 'ACE' ) ;
    public final void rule__HttpClient__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1472:1: ( ( 'ACE' ) )
            // InternalAceGen.g:1473:1: ( 'ACE' )
            {
            // InternalAceGen.g:1473:1: ( 'ACE' )
            // InternalAceGen.g:1474:2: 'ACE'
            {
             before(grammarAccess.getHttpClientAccess().getACEKeyword_1_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalAceGen.g:1483:1: rule__HttpClient__Group_1__1 : rule__HttpClient__Group_1__1__Impl ;
    public final void rule__HttpClient__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1487:1: ( rule__HttpClient__Group_1__1__Impl )
            // InternalAceGen.g:1488:2: rule__HttpClient__Group_1__1__Impl
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
    // InternalAceGen.g:1494:1: rule__HttpClient__Group_1__1__Impl : ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* ) ;
    public final void rule__HttpClient__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1498:1: ( ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* ) )
            // InternalAceGen.g:1499:1: ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* )
            {
            // InternalAceGen.g:1499:1: ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* )
            // InternalAceGen.g:1500:2: ( rule__HttpClient__AceOperationsAssignment_1_1 )*
            {
             before(grammarAccess.getHttpClientAccess().getAceOperationsAssignment_1_1()); 
            // InternalAceGen.g:1501:2: ( rule__HttpClient__AceOperationsAssignment_1_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID||LA15_0==68) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalAceGen.g:1501:3: rule__HttpClient__AceOperationsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__HttpClient__AceOperationsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalAceGen.g:1510:1: rule__HttpClient__Group_2__0 : rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1 ;
    public final void rule__HttpClient__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1514:1: ( rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1 )
            // InternalAceGen.g:1515:2: rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1
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
    // InternalAceGen.g:1522:1: rule__HttpClient__Group_2__0__Impl : ( 'appState' ) ;
    public final void rule__HttpClient__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1526:1: ( ( 'appState' ) )
            // InternalAceGen.g:1527:1: ( 'appState' )
            {
            // InternalAceGen.g:1527:1: ( 'appState' )
            // InternalAceGen.g:1528:2: 'appState'
            {
             before(grammarAccess.getHttpClientAccess().getAppStateKeyword_2_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalAceGen.g:1537:1: rule__HttpClient__Group_2__1 : rule__HttpClient__Group_2__1__Impl ;
    public final void rule__HttpClient__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1541:1: ( rule__HttpClient__Group_2__1__Impl )
            // InternalAceGen.g:1542:2: rule__HttpClient__Group_2__1__Impl
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
    // InternalAceGen.g:1548:1: rule__HttpClient__Group_2__1__Impl : ( ( rule__HttpClient__AppStateAssignment_2_1 ) ) ;
    public final void rule__HttpClient__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1552:1: ( ( ( rule__HttpClient__AppStateAssignment_2_1 ) ) )
            // InternalAceGen.g:1553:1: ( ( rule__HttpClient__AppStateAssignment_2_1 ) )
            {
            // InternalAceGen.g:1553:1: ( ( rule__HttpClient__AppStateAssignment_2_1 ) )
            // InternalAceGen.g:1554:2: ( rule__HttpClient__AppStateAssignment_2_1 )
            {
             before(grammarAccess.getHttpClientAccess().getAppStateAssignment_2_1()); 
            // InternalAceGen.g:1555:2: ( rule__HttpClient__AppStateAssignment_2_1 )
            // InternalAceGen.g:1555:3: rule__HttpClient__AppStateAssignment_2_1
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
    // InternalAceGen.g:1564:1: rule__HttpClientAce__Group__0 : rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1 ;
    public final void rule__HttpClientAce__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1568:1: ( rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1 )
            // InternalAceGen.g:1569:2: rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1
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
    // InternalAceGen.g:1576:1: rule__HttpClientAce__Group__0__Impl : ( ( rule__HttpClientAce__AsyncAssignment_0 )? ) ;
    public final void rule__HttpClientAce__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1580:1: ( ( ( rule__HttpClientAce__AsyncAssignment_0 )? ) )
            // InternalAceGen.g:1581:1: ( ( rule__HttpClientAce__AsyncAssignment_0 )? )
            {
            // InternalAceGen.g:1581:1: ( ( rule__HttpClientAce__AsyncAssignment_0 )? )
            // InternalAceGen.g:1582:2: ( rule__HttpClientAce__AsyncAssignment_0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getAsyncAssignment_0()); 
            // InternalAceGen.g:1583:2: ( rule__HttpClientAce__AsyncAssignment_0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==68) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAceGen.g:1583:3: rule__HttpClientAce__AsyncAssignment_0
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
    // InternalAceGen.g:1591:1: rule__HttpClientAce__Group__1 : rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2 ;
    public final void rule__HttpClientAce__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1595:1: ( rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2 )
            // InternalAceGen.g:1596:2: rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2
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
    // InternalAceGen.g:1603:1: rule__HttpClientAce__Group__1__Impl : ( ( rule__HttpClientAce__NameAssignment_1 ) ) ;
    public final void rule__HttpClientAce__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1607:1: ( ( ( rule__HttpClientAce__NameAssignment_1 ) ) )
            // InternalAceGen.g:1608:1: ( ( rule__HttpClientAce__NameAssignment_1 ) )
            {
            // InternalAceGen.g:1608:1: ( ( rule__HttpClientAce__NameAssignment_1 ) )
            // InternalAceGen.g:1609:2: ( rule__HttpClientAce__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getNameAssignment_1()); 
            // InternalAceGen.g:1610:2: ( rule__HttpClientAce__NameAssignment_1 )
            // InternalAceGen.g:1610:3: rule__HttpClientAce__NameAssignment_1
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
    // InternalAceGen.g:1618:1: rule__HttpClientAce__Group__2 : rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3 ;
    public final void rule__HttpClientAce__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1622:1: ( rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3 )
            // InternalAceGen.g:1623:2: rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3
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
    // InternalAceGen.g:1630:1: rule__HttpClientAce__Group__2__Impl : ( ( rule__HttpClientAce__Group_2__0 )? ) ;
    public final void rule__HttpClientAce__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1634:1: ( ( ( rule__HttpClientAce__Group_2__0 )? ) )
            // InternalAceGen.g:1635:1: ( ( rule__HttpClientAce__Group_2__0 )? )
            {
            // InternalAceGen.g:1635:1: ( ( rule__HttpClientAce__Group_2__0 )? )
            // InternalAceGen.g:1636:2: ( rule__HttpClientAce__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_2()); 
            // InternalAceGen.g:1637:2: ( rule__HttpClientAce__Group_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==34) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAceGen.g:1637:3: rule__HttpClientAce__Group_2__0
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
    // InternalAceGen.g:1645:1: rule__HttpClientAce__Group__3 : rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4 ;
    public final void rule__HttpClientAce__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1649:1: ( rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4 )
            // InternalAceGen.g:1650:2: rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4
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
    // InternalAceGen.g:1657:1: rule__HttpClientAce__Group__3__Impl : ( ( rule__HttpClientAce__Group_3__0 )? ) ;
    public final void rule__HttpClientAce__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1661:1: ( ( ( rule__HttpClientAce__Group_3__0 )? ) )
            // InternalAceGen.g:1662:1: ( ( rule__HttpClientAce__Group_3__0 )? )
            {
            // InternalAceGen.g:1662:1: ( ( rule__HttpClientAce__Group_3__0 )? )
            // InternalAceGen.g:1663:2: ( rule__HttpClientAce__Group_3__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_3()); 
            // InternalAceGen.g:1664:2: ( rule__HttpClientAce__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==37) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAceGen.g:1664:3: rule__HttpClientAce__Group_3__0
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
    // InternalAceGen.g:1672:1: rule__HttpClientAce__Group__4 : rule__HttpClientAce__Group__4__Impl rule__HttpClientAce__Group__5 ;
    public final void rule__HttpClientAce__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1676:1: ( rule__HttpClientAce__Group__4__Impl rule__HttpClientAce__Group__5 )
            // InternalAceGen.g:1677:2: rule__HttpClientAce__Group__4__Impl rule__HttpClientAce__Group__5
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
    // InternalAceGen.g:1684:1: rule__HttpClientAce__Group__4__Impl : ( ( rule__HttpClientAce__Group_4__0 )? ) ;
    public final void rule__HttpClientAce__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1688:1: ( ( ( rule__HttpClientAce__Group_4__0 )? ) )
            // InternalAceGen.g:1689:1: ( ( rule__HttpClientAce__Group_4__0 )? )
            {
            // InternalAceGen.g:1689:1: ( ( rule__HttpClientAce__Group_4__0 )? )
            // InternalAceGen.g:1690:2: ( rule__HttpClientAce__Group_4__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_4()); 
            // InternalAceGen.g:1691:2: ( rule__HttpClientAce__Group_4__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==38) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAceGen.g:1691:3: rule__HttpClientAce__Group_4__0
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
    // InternalAceGen.g:1699:1: rule__HttpClientAce__Group__5 : rule__HttpClientAce__Group__5__Impl ;
    public final void rule__HttpClientAce__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1703:1: ( rule__HttpClientAce__Group__5__Impl )
            // InternalAceGen.g:1704:2: rule__HttpClientAce__Group__5__Impl
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
    // InternalAceGen.g:1710:1: rule__HttpClientAce__Group__5__Impl : ( ( rule__HttpClientAce__OutcomesAssignment_5 )* ) ;
    public final void rule__HttpClientAce__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1714:1: ( ( ( rule__HttpClientAce__OutcomesAssignment_5 )* ) )
            // InternalAceGen.g:1715:1: ( ( rule__HttpClientAce__OutcomesAssignment_5 )* )
            {
            // InternalAceGen.g:1715:1: ( ( rule__HttpClientAce__OutcomesAssignment_5 )* )
            // InternalAceGen.g:1716:2: ( rule__HttpClientAce__OutcomesAssignment_5 )*
            {
             before(grammarAccess.getHttpClientAceAccess().getOutcomesAssignment_5()); 
            // InternalAceGen.g:1717:2: ( rule__HttpClientAce__OutcomesAssignment_5 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==39) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalAceGen.g:1717:3: rule__HttpClientAce__OutcomesAssignment_5
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__HttpClientAce__OutcomesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalAceGen.g:1726:1: rule__HttpClientAce__Group_2__0 : rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1 ;
    public final void rule__HttpClientAce__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1730:1: ( rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1 )
            // InternalAceGen.g:1731:2: rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1
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
    // InternalAceGen.g:1738:1: rule__HttpClientAce__Group_2__0__Impl : ( '<' ) ;
    public final void rule__HttpClientAce__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1742:1: ( ( '<' ) )
            // InternalAceGen.g:1743:1: ( '<' )
            {
            // InternalAceGen.g:1743:1: ( '<' )
            // InternalAceGen.g:1744:2: '<'
            {
             before(grammarAccess.getHttpClientAceAccess().getLessThanSignKeyword_2_0()); 
            match(input,34,FOLLOW_2); 
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
    // InternalAceGen.g:1753:1: rule__HttpClientAce__Group_2__1 : rule__HttpClientAce__Group_2__1__Impl rule__HttpClientAce__Group_2__2 ;
    public final void rule__HttpClientAce__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1757:1: ( rule__HttpClientAce__Group_2__1__Impl rule__HttpClientAce__Group_2__2 )
            // InternalAceGen.g:1758:2: rule__HttpClientAce__Group_2__1__Impl rule__HttpClientAce__Group_2__2
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
    // InternalAceGen.g:1765:1: rule__HttpClientAce__Group_2__1__Impl : ( ( rule__HttpClientAce__InputAssignment_2_1 ) ) ;
    public final void rule__HttpClientAce__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1769:1: ( ( ( rule__HttpClientAce__InputAssignment_2_1 ) ) )
            // InternalAceGen.g:1770:1: ( ( rule__HttpClientAce__InputAssignment_2_1 ) )
            {
            // InternalAceGen.g:1770:1: ( ( rule__HttpClientAce__InputAssignment_2_1 ) )
            // InternalAceGen.g:1771:2: ( rule__HttpClientAce__InputAssignment_2_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getInputAssignment_2_1()); 
            // InternalAceGen.g:1772:2: ( rule__HttpClientAce__InputAssignment_2_1 )
            // InternalAceGen.g:1772:3: rule__HttpClientAce__InputAssignment_2_1
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
    // InternalAceGen.g:1780:1: rule__HttpClientAce__Group_2__2 : rule__HttpClientAce__Group_2__2__Impl rule__HttpClientAce__Group_2__3 ;
    public final void rule__HttpClientAce__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1784:1: ( rule__HttpClientAce__Group_2__2__Impl rule__HttpClientAce__Group_2__3 )
            // InternalAceGen.g:1785:2: rule__HttpClientAce__Group_2__2__Impl rule__HttpClientAce__Group_2__3
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
    // InternalAceGen.g:1792:1: rule__HttpClientAce__Group_2__2__Impl : ( ( rule__HttpClientAce__Group_2_2__0 )* ) ;
    public final void rule__HttpClientAce__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1796:1: ( ( ( rule__HttpClientAce__Group_2_2__0 )* ) )
            // InternalAceGen.g:1797:1: ( ( rule__HttpClientAce__Group_2_2__0 )* )
            {
            // InternalAceGen.g:1797:1: ( ( rule__HttpClientAce__Group_2_2__0 )* )
            // InternalAceGen.g:1798:2: ( rule__HttpClientAce__Group_2_2__0 )*
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_2_2()); 
            // InternalAceGen.g:1799:2: ( rule__HttpClientAce__Group_2_2__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==36) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalAceGen.g:1799:3: rule__HttpClientAce__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__HttpClientAce__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalAceGen.g:1807:1: rule__HttpClientAce__Group_2__3 : rule__HttpClientAce__Group_2__3__Impl ;
    public final void rule__HttpClientAce__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1811:1: ( rule__HttpClientAce__Group_2__3__Impl )
            // InternalAceGen.g:1812:2: rule__HttpClientAce__Group_2__3__Impl
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
    // InternalAceGen.g:1818:1: rule__HttpClientAce__Group_2__3__Impl : ( '>' ) ;
    public final void rule__HttpClientAce__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1822:1: ( ( '>' ) )
            // InternalAceGen.g:1823:1: ( '>' )
            {
            // InternalAceGen.g:1823:1: ( '>' )
            // InternalAceGen.g:1824:2: '>'
            {
             before(grammarAccess.getHttpClientAceAccess().getGreaterThanSignKeyword_2_3()); 
            match(input,35,FOLLOW_2); 
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
    // InternalAceGen.g:1834:1: rule__HttpClientAce__Group_2_2__0 : rule__HttpClientAce__Group_2_2__0__Impl rule__HttpClientAce__Group_2_2__1 ;
    public final void rule__HttpClientAce__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1838:1: ( rule__HttpClientAce__Group_2_2__0__Impl rule__HttpClientAce__Group_2_2__1 )
            // InternalAceGen.g:1839:2: rule__HttpClientAce__Group_2_2__0__Impl rule__HttpClientAce__Group_2_2__1
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
    // InternalAceGen.g:1846:1: rule__HttpClientAce__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__HttpClientAce__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1850:1: ( ( ',' ) )
            // InternalAceGen.g:1851:1: ( ',' )
            {
            // InternalAceGen.g:1851:1: ( ',' )
            // InternalAceGen.g:1852:2: ','
            {
             before(grammarAccess.getHttpClientAceAccess().getCommaKeyword_2_2_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalAceGen.g:1861:1: rule__HttpClientAce__Group_2_2__1 : rule__HttpClientAce__Group_2_2__1__Impl ;
    public final void rule__HttpClientAce__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1865:1: ( rule__HttpClientAce__Group_2_2__1__Impl )
            // InternalAceGen.g:1866:2: rule__HttpClientAce__Group_2_2__1__Impl
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
    // InternalAceGen.g:1872:1: rule__HttpClientAce__Group_2_2__1__Impl : ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) ) ;
    public final void rule__HttpClientAce__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1876:1: ( ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) ) )
            // InternalAceGen.g:1877:1: ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) )
            {
            // InternalAceGen.g:1877:1: ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) )
            // InternalAceGen.g:1878:2: ( rule__HttpClientAce__InputAssignment_2_2_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getInputAssignment_2_2_1()); 
            // InternalAceGen.g:1879:2: ( rule__HttpClientAce__InputAssignment_2_2_1 )
            // InternalAceGen.g:1879:3: rule__HttpClientAce__InputAssignment_2_2_1
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
    // InternalAceGen.g:1888:1: rule__HttpClientAce__Group_3__0 : rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1 ;
    public final void rule__HttpClientAce__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1892:1: ( rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1 )
            // InternalAceGen.g:1893:2: rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1
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
    // InternalAceGen.g:1900:1: rule__HttpClientAce__Group_3__0__Impl : ( 'call' ) ;
    public final void rule__HttpClientAce__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1904:1: ( ( 'call' ) )
            // InternalAceGen.g:1905:1: ( 'call' )
            {
            // InternalAceGen.g:1905:1: ( 'call' )
            // InternalAceGen.g:1906:2: 'call'
            {
             before(grammarAccess.getHttpClientAceAccess().getCallKeyword_3_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalAceGen.g:1915:1: rule__HttpClientAce__Group_3__1 : rule__HttpClientAce__Group_3__1__Impl ;
    public final void rule__HttpClientAce__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1919:1: ( rule__HttpClientAce__Group_3__1__Impl )
            // InternalAceGen.g:1920:2: rule__HttpClientAce__Group_3__1__Impl
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
    // InternalAceGen.g:1926:1: rule__HttpClientAce__Group_3__1__Impl : ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) ) ;
    public final void rule__HttpClientAce__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1930:1: ( ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) ) )
            // InternalAceGen.g:1931:1: ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) )
            {
            // InternalAceGen.g:1931:1: ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) )
            // InternalAceGen.g:1932:2: ( rule__HttpClientAce__ServerCallAssignment_3_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallAssignment_3_1()); 
            // InternalAceGen.g:1933:2: ( rule__HttpClientAce__ServerCallAssignment_3_1 )
            // InternalAceGen.g:1933:3: rule__HttpClientAce__ServerCallAssignment_3_1
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
    // InternalAceGen.g:1942:1: rule__HttpClientAce__Group_4__0 : rule__HttpClientAce__Group_4__0__Impl rule__HttpClientAce__Group_4__1 ;
    public final void rule__HttpClientAce__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1946:1: ( rule__HttpClientAce__Group_4__0__Impl rule__HttpClientAce__Group_4__1 )
            // InternalAceGen.g:1947:2: rule__HttpClientAce__Group_4__0__Impl rule__HttpClientAce__Group_4__1
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
    // InternalAceGen.g:1954:1: rule__HttpClientAce__Group_4__0__Impl : ( 'loadingFlag' ) ;
    public final void rule__HttpClientAce__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1958:1: ( ( 'loadingFlag' ) )
            // InternalAceGen.g:1959:1: ( 'loadingFlag' )
            {
            // InternalAceGen.g:1959:1: ( 'loadingFlag' )
            // InternalAceGen.g:1960:2: 'loadingFlag'
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagKeyword_4_0()); 
            match(input,38,FOLLOW_2); 
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
    // InternalAceGen.g:1969:1: rule__HttpClientAce__Group_4__1 : rule__HttpClientAce__Group_4__1__Impl ;
    public final void rule__HttpClientAce__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1973:1: ( rule__HttpClientAce__Group_4__1__Impl )
            // InternalAceGen.g:1974:2: rule__HttpClientAce__Group_4__1__Impl
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
    // InternalAceGen.g:1980:1: rule__HttpClientAce__Group_4__1__Impl : ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) ) ;
    public final void rule__HttpClientAce__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1984:1: ( ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) ) )
            // InternalAceGen.g:1985:1: ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) )
            {
            // InternalAceGen.g:1985:1: ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) )
            // InternalAceGen.g:1986:2: ( rule__HttpClientAce__LoadingFlagAssignment_4_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagAssignment_4_1()); 
            // InternalAceGen.g:1987:2: ( rule__HttpClientAce__LoadingFlagAssignment_4_1 )
            // InternalAceGen.g:1987:3: rule__HttpClientAce__LoadingFlagAssignment_4_1
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
    // InternalAceGen.g:1996:1: rule__HttpClientOutcome__Group__0 : rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1 ;
    public final void rule__HttpClientOutcome__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2000:1: ( rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1 )
            // InternalAceGen.g:2001:2: rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1
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
    // InternalAceGen.g:2008:1: rule__HttpClientOutcome__Group__0__Impl : ( 'on' ) ;
    public final void rule__HttpClientOutcome__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2012:1: ( ( 'on' ) )
            // InternalAceGen.g:2013:1: ( 'on' )
            {
            // InternalAceGen.g:2013:1: ( 'on' )
            // InternalAceGen.g:2014:2: 'on'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getOnKeyword_0()); 
            match(input,39,FOLLOW_2); 
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
    // InternalAceGen.g:2023:1: rule__HttpClientOutcome__Group__1 : rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2 ;
    public final void rule__HttpClientOutcome__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2027:1: ( rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2 )
            // InternalAceGen.g:2028:2: rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2
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
    // InternalAceGen.g:2035:1: rule__HttpClientOutcome__Group__1__Impl : ( ( rule__HttpClientOutcome__NameAssignment_1 ) ) ;
    public final void rule__HttpClientOutcome__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2039:1: ( ( ( rule__HttpClientOutcome__NameAssignment_1 ) ) )
            // InternalAceGen.g:2040:1: ( ( rule__HttpClientOutcome__NameAssignment_1 ) )
            {
            // InternalAceGen.g:2040:1: ( ( rule__HttpClientOutcome__NameAssignment_1 ) )
            // InternalAceGen.g:2041:2: ( rule__HttpClientOutcome__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getNameAssignment_1()); 
            // InternalAceGen.g:2042:2: ( rule__HttpClientOutcome__NameAssignment_1 )
            // InternalAceGen.g:2042:3: rule__HttpClientOutcome__NameAssignment_1
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
    // InternalAceGen.g:2050:1: rule__HttpClientOutcome__Group__2 : rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3 ;
    public final void rule__HttpClientOutcome__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2054:1: ( rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3 )
            // InternalAceGen.g:2055:2: rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3
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
    // InternalAceGen.g:2062:1: rule__HttpClientOutcome__Group__2__Impl : ( ( rule__HttpClientOutcome__Group_2__0 )? ) ;
    public final void rule__HttpClientOutcome__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2066:1: ( ( ( rule__HttpClientOutcome__Group_2__0 )? ) )
            // InternalAceGen.g:2067:1: ( ( rule__HttpClientOutcome__Group_2__0 )? )
            {
            // InternalAceGen.g:2067:1: ( ( rule__HttpClientOutcome__Group_2__0 )? )
            // InternalAceGen.g:2068:2: ( rule__HttpClientOutcome__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getGroup_2()); 
            // InternalAceGen.g:2069:2: ( rule__HttpClientOutcome__Group_2__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==40) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalAceGen.g:2069:3: rule__HttpClientOutcome__Group_2__0
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
    // InternalAceGen.g:2077:1: rule__HttpClientOutcome__Group__3 : rule__HttpClientOutcome__Group__3__Impl ;
    public final void rule__HttpClientOutcome__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2081:1: ( rule__HttpClientOutcome__Group__3__Impl )
            // InternalAceGen.g:2082:2: rule__HttpClientOutcome__Group__3__Impl
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
    // InternalAceGen.g:2088:1: rule__HttpClientOutcome__Group__3__Impl : ( ( rule__HttpClientOutcome__Group_3__0 )? ) ;
    public final void rule__HttpClientOutcome__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2092:1: ( ( ( rule__HttpClientOutcome__Group_3__0 )? ) )
            // InternalAceGen.g:2093:1: ( ( rule__HttpClientOutcome__Group_3__0 )? )
            {
            // InternalAceGen.g:2093:1: ( ( rule__HttpClientOutcome__Group_3__0 )? )
            // InternalAceGen.g:2094:2: ( rule__HttpClientOutcome__Group_3__0 )?
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getGroup_3()); 
            // InternalAceGen.g:2095:2: ( rule__HttpClientOutcome__Group_3__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==42) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalAceGen.g:2095:3: rule__HttpClientOutcome__Group_3__0
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
    // InternalAceGen.g:2104:1: rule__HttpClientOutcome__Group_2__0 : rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1 ;
    public final void rule__HttpClientOutcome__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2108:1: ( rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1 )
            // InternalAceGen.g:2109:2: rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1
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
    // InternalAceGen.g:2116:1: rule__HttpClientOutcome__Group_2__0__Impl : ( '(' ) ;
    public final void rule__HttpClientOutcome__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2120:1: ( ( '(' ) )
            // InternalAceGen.g:2121:1: ( '(' )
            {
            // InternalAceGen.g:2121:1: ( '(' )
            // InternalAceGen.g:2122:2: '('
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,40,FOLLOW_2); 
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
    // InternalAceGen.g:2131:1: rule__HttpClientOutcome__Group_2__1 : rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2 ;
    public final void rule__HttpClientOutcome__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2135:1: ( rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2 )
            // InternalAceGen.g:2136:2: rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2
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
    // InternalAceGen.g:2143:1: rule__HttpClientOutcome__Group_2__1__Impl : ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* ) ;
    public final void rule__HttpClientOutcome__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2147:1: ( ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* ) )
            // InternalAceGen.g:2148:1: ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* )
            {
            // InternalAceGen.g:2148:1: ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* )
            // InternalAceGen.g:2149:2: ( rule__HttpClientOutcome__ListenersAssignment_2_1 )*
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getListenersAssignment_2_1()); 
            // InternalAceGen.g:2150:2: ( rule__HttpClientOutcome__ListenersAssignment_2_1 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=13 && LA24_0<=16)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalAceGen.g:2150:3: rule__HttpClientOutcome__ListenersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__HttpClientOutcome__ListenersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalAceGen.g:2158:1: rule__HttpClientOutcome__Group_2__2 : rule__HttpClientOutcome__Group_2__2__Impl ;
    public final void rule__HttpClientOutcome__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2162:1: ( rule__HttpClientOutcome__Group_2__2__Impl )
            // InternalAceGen.g:2163:2: rule__HttpClientOutcome__Group_2__2__Impl
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
    // InternalAceGen.g:2169:1: rule__HttpClientOutcome__Group_2__2__Impl : ( ')' ) ;
    public final void rule__HttpClientOutcome__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2173:1: ( ( ')' ) )
            // InternalAceGen.g:2174:1: ( ')' )
            {
            // InternalAceGen.g:2174:1: ( ')' )
            // InternalAceGen.g:2175:2: ')'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_2_2()); 
            match(input,41,FOLLOW_2); 
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
    // InternalAceGen.g:2185:1: rule__HttpClientOutcome__Group_3__0 : rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1 ;
    public final void rule__HttpClientOutcome__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2189:1: ( rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1 )
            // InternalAceGen.g:2190:2: rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1
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
    // InternalAceGen.g:2197:1: rule__HttpClientOutcome__Group_3__0__Impl : ( 'triggers' ) ;
    public final void rule__HttpClientOutcome__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2201:1: ( ( 'triggers' ) )
            // InternalAceGen.g:2202:1: ( 'triggers' )
            {
            // InternalAceGen.g:2202:1: ( 'triggers' )
            // InternalAceGen.g:2203:2: 'triggers'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getTriggersKeyword_3_0()); 
            match(input,42,FOLLOW_2); 
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
    // InternalAceGen.g:2212:1: rule__HttpClientOutcome__Group_3__1 : rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2 ;
    public final void rule__HttpClientOutcome__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2216:1: ( rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2 )
            // InternalAceGen.g:2217:2: rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2
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
    // InternalAceGen.g:2224:1: rule__HttpClientOutcome__Group_3__1__Impl : ( '(' ) ;
    public final void rule__HttpClientOutcome__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2228:1: ( ( '(' ) )
            // InternalAceGen.g:2229:1: ( '(' )
            {
            // InternalAceGen.g:2229:1: ( '(' )
            // InternalAceGen.g:2230:2: '('
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,40,FOLLOW_2); 
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
    // InternalAceGen.g:2239:1: rule__HttpClientOutcome__Group_3__2 : rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3 ;
    public final void rule__HttpClientOutcome__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2243:1: ( rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3 )
            // InternalAceGen.g:2244:2: rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3
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
    // InternalAceGen.g:2251:1: rule__HttpClientOutcome__Group_3__2__Impl : ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* ) ;
    public final void rule__HttpClientOutcome__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2255:1: ( ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* ) )
            // InternalAceGen.g:2256:1: ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* )
            {
            // InternalAceGen.g:2256:1: ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* )
            // InternalAceGen.g:2257:2: ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )*
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsAssignment_3_2()); 
            // InternalAceGen.g:2258:2: ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalAceGen.g:2258:3: rule__HttpClientOutcome__AceOperationsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpClientOutcome__AceOperationsAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalAceGen.g:2266:1: rule__HttpClientOutcome__Group_3__3 : rule__HttpClientOutcome__Group_3__3__Impl ;
    public final void rule__HttpClientOutcome__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2270:1: ( rule__HttpClientOutcome__Group_3__3__Impl )
            // InternalAceGen.g:2271:2: rule__HttpClientOutcome__Group_3__3__Impl
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
    // InternalAceGen.g:2277:1: rule__HttpClientOutcome__Group_3__3__Impl : ( ')' ) ;
    public final void rule__HttpClientOutcome__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2281:1: ( ( ')' ) )
            // InternalAceGen.g:2282:1: ( ')' )
            {
            // InternalAceGen.g:2282:1: ( ')' )
            // InternalAceGen.g:2283:2: ')'
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_3_3()); 
            match(input,41,FOLLOW_2); 
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
    // InternalAceGen.g:2293:1: rule__HttpClientStateFunction__Group__0 : rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1 ;
    public final void rule__HttpClientStateFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2297:1: ( rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1 )
            // InternalAceGen.g:2298:2: rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1
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
    // InternalAceGen.g:2305:1: rule__HttpClientStateFunction__Group__0__Impl : ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) ) ;
    public final void rule__HttpClientStateFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2309:1: ( ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) ) )
            // InternalAceGen.g:2310:1: ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) )
            {
            // InternalAceGen.g:2310:1: ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) )
            // InternalAceGen.g:2311:2: ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeAssignment_0()); 
            // InternalAceGen.g:2312:2: ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 )
            // InternalAceGen.g:2312:3: rule__HttpClientStateFunction__StateFunctionTypeAssignment_0
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
    // InternalAceGen.g:2320:1: rule__HttpClientStateFunction__Group__1 : rule__HttpClientStateFunction__Group__1__Impl ;
    public final void rule__HttpClientStateFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2324:1: ( rule__HttpClientStateFunction__Group__1__Impl )
            // InternalAceGen.g:2325:2: rule__HttpClientStateFunction__Group__1__Impl
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
    // InternalAceGen.g:2331:1: rule__HttpClientStateFunction__Group__1__Impl : ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) ) ;
    public final void rule__HttpClientStateFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2335:1: ( ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) ) )
            // InternalAceGen.g:2336:1: ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) )
            {
            // InternalAceGen.g:2336:1: ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) )
            // InternalAceGen.g:2337:2: ( rule__HttpClientStateFunction__AttributeAssignment_1 )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getAttributeAssignment_1()); 
            // InternalAceGen.g:2338:2: ( rule__HttpClientStateFunction__AttributeAssignment_1 )
            // InternalAceGen.g:2338:3: rule__HttpClientStateFunction__AttributeAssignment_1
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
    // InternalAceGen.g:2347:1: rule__HttpClientStateElement__Group__0 : rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1 ;
    public final void rule__HttpClientStateElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2351:1: ( rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1 )
            // InternalAceGen.g:2352:2: rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1
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
    // InternalAceGen.g:2359:1: rule__HttpClientStateElement__Group__0__Impl : ( ( rule__HttpClientStateElement__NameAssignment_0 ) ) ;
    public final void rule__HttpClientStateElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2363:1: ( ( ( rule__HttpClientStateElement__NameAssignment_0 ) ) )
            // InternalAceGen.g:2364:1: ( ( rule__HttpClientStateElement__NameAssignment_0 ) )
            {
            // InternalAceGen.g:2364:1: ( ( rule__HttpClientStateElement__NameAssignment_0 ) )
            // InternalAceGen.g:2365:2: ( rule__HttpClientStateElement__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getNameAssignment_0()); 
            // InternalAceGen.g:2366:2: ( rule__HttpClientStateElement__NameAssignment_0 )
            // InternalAceGen.g:2366:3: rule__HttpClientStateElement__NameAssignment_0
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
    // InternalAceGen.g:2374:1: rule__HttpClientStateElement__Group__1 : rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2 ;
    public final void rule__HttpClientStateElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2378:1: ( rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2 )
            // InternalAceGen.g:2379:2: rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2
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
    // InternalAceGen.g:2386:1: rule__HttpClientStateElement__Group__1__Impl : ( ( rule__HttpClientStateElement__ListAssignment_1 )? ) ;
    public final void rule__HttpClientStateElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2390:1: ( ( ( rule__HttpClientStateElement__ListAssignment_1 )? ) )
            // InternalAceGen.g:2391:1: ( ( rule__HttpClientStateElement__ListAssignment_1 )? )
            {
            // InternalAceGen.g:2391:1: ( ( rule__HttpClientStateElement__ListAssignment_1 )? )
            // InternalAceGen.g:2392:2: ( rule__HttpClientStateElement__ListAssignment_1 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListAssignment_1()); 
            // InternalAceGen.g:2393:2: ( rule__HttpClientStateElement__ListAssignment_1 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==69) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalAceGen.g:2393:3: rule__HttpClientStateElement__ListAssignment_1
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
    // InternalAceGen.g:2401:1: rule__HttpClientStateElement__Group__2 : rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3 ;
    public final void rule__HttpClientStateElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2405:1: ( rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3 )
            // InternalAceGen.g:2406:2: rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3
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
    // InternalAceGen.g:2413:1: rule__HttpClientStateElement__Group__2__Impl : ( ( rule__HttpClientStateElement__HashAssignment_2 )? ) ;
    public final void rule__HttpClientStateElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2417:1: ( ( ( rule__HttpClientStateElement__HashAssignment_2 )? ) )
            // InternalAceGen.g:2418:1: ( ( rule__HttpClientStateElement__HashAssignment_2 )? )
            {
            // InternalAceGen.g:2418:1: ( ( rule__HttpClientStateElement__HashAssignment_2 )? )
            // InternalAceGen.g:2419:2: ( rule__HttpClientStateElement__HashAssignment_2 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashAssignment_2()); 
            // InternalAceGen.g:2420:2: ( rule__HttpClientStateElement__HashAssignment_2 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==70) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalAceGen.g:2420:3: rule__HttpClientStateElement__HashAssignment_2
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
    // InternalAceGen.g:2428:1: rule__HttpClientStateElement__Group__3 : rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4 ;
    public final void rule__HttpClientStateElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2432:1: ( rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4 )
            // InternalAceGen.g:2433:2: rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4
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
    // InternalAceGen.g:2440:1: rule__HttpClientStateElement__Group__3__Impl : ( ( rule__HttpClientStateElement__StorageAssignment_3 )? ) ;
    public final void rule__HttpClientStateElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2444:1: ( ( ( rule__HttpClientStateElement__StorageAssignment_3 )? ) )
            // InternalAceGen.g:2445:1: ( ( rule__HttpClientStateElement__StorageAssignment_3 )? )
            {
            // InternalAceGen.g:2445:1: ( ( rule__HttpClientStateElement__StorageAssignment_3 )? )
            // InternalAceGen.g:2446:2: ( rule__HttpClientStateElement__StorageAssignment_3 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageAssignment_3()); 
            // InternalAceGen.g:2447:2: ( rule__HttpClientStateElement__StorageAssignment_3 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==71) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAceGen.g:2447:3: rule__HttpClientStateElement__StorageAssignment_3
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
    // InternalAceGen.g:2455:1: rule__HttpClientStateElement__Group__4 : rule__HttpClientStateElement__Group__4__Impl ;
    public final void rule__HttpClientStateElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2459:1: ( rule__HttpClientStateElement__Group__4__Impl )
            // InternalAceGen.g:2460:2: rule__HttpClientStateElement__Group__4__Impl
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
    // InternalAceGen.g:2466:1: rule__HttpClientStateElement__Group__4__Impl : ( ( rule__HttpClientStateElement__Group_4__0 )? ) ;
    public final void rule__HttpClientStateElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2470:1: ( ( ( rule__HttpClientStateElement__Group_4__0 )? ) )
            // InternalAceGen.g:2471:1: ( ( rule__HttpClientStateElement__Group_4__0 )? )
            {
            // InternalAceGen.g:2471:1: ( ( rule__HttpClientStateElement__Group_4__0 )? )
            // InternalAceGen.g:2472:2: ( rule__HttpClientStateElement__Group_4__0 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getGroup_4()); 
            // InternalAceGen.g:2473:2: ( rule__HttpClientStateElement__Group_4__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==44) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAceGen.g:2473:3: rule__HttpClientStateElement__Group_4__0
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
    // InternalAceGen.g:2482:1: rule__HttpClientStateElement__Group_4__0 : rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1 ;
    public final void rule__HttpClientStateElement__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2486:1: ( rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1 )
            // InternalAceGen.g:2487:2: rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1
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
    // InternalAceGen.g:2494:1: rule__HttpClientStateElement__Group_4__0__Impl : ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) ) ;
    public final void rule__HttpClientStateElement__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2498:1: ( ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) ) )
            // InternalAceGen.g:2499:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) )
            {
            // InternalAceGen.g:2499:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) )
            // InternalAceGen.g:2500:2: ( rule__HttpClientStateElement__TypesAssignment_4_0 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_0()); 
            // InternalAceGen.g:2501:2: ( rule__HttpClientStateElement__TypesAssignment_4_0 )
            // InternalAceGen.g:2501:3: rule__HttpClientStateElement__TypesAssignment_4_0
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
    // InternalAceGen.g:2509:1: rule__HttpClientStateElement__Group_4__1 : rule__HttpClientStateElement__Group_4__1__Impl ;
    public final void rule__HttpClientStateElement__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2513:1: ( rule__HttpClientStateElement__Group_4__1__Impl )
            // InternalAceGen.g:2514:2: rule__HttpClientStateElement__Group_4__1__Impl
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
    // InternalAceGen.g:2520:1: rule__HttpClientStateElement__Group_4__1__Impl : ( ( rule__HttpClientStateElement__Group_4_1__0 )* ) ;
    public final void rule__HttpClientStateElement__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2524:1: ( ( ( rule__HttpClientStateElement__Group_4_1__0 )* ) )
            // InternalAceGen.g:2525:1: ( ( rule__HttpClientStateElement__Group_4_1__0 )* )
            {
            // InternalAceGen.g:2525:1: ( ( rule__HttpClientStateElement__Group_4_1__0 )* )
            // InternalAceGen.g:2526:2: ( rule__HttpClientStateElement__Group_4_1__0 )*
            {
             before(grammarAccess.getHttpClientStateElementAccess().getGroup_4_1()); 
            // InternalAceGen.g:2527:2: ( rule__HttpClientStateElement__Group_4_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==43) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalAceGen.g:2527:3: rule__HttpClientStateElement__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__HttpClientStateElement__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalAceGen.g:2536:1: rule__HttpClientStateElement__Group_4_1__0 : rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1 ;
    public final void rule__HttpClientStateElement__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2540:1: ( rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1 )
            // InternalAceGen.g:2541:2: rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1
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
    // InternalAceGen.g:2548:1: rule__HttpClientStateElement__Group_4_1__0__Impl : ( '|' ) ;
    public final void rule__HttpClientStateElement__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2552:1: ( ( '|' ) )
            // InternalAceGen.g:2553:1: ( '|' )
            {
            // InternalAceGen.g:2553:1: ( '|' )
            // InternalAceGen.g:2554:2: '|'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getVerticalLineKeyword_4_1_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalAceGen.g:2563:1: rule__HttpClientStateElement__Group_4_1__1 : rule__HttpClientStateElement__Group_4_1__1__Impl ;
    public final void rule__HttpClientStateElement__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2567:1: ( rule__HttpClientStateElement__Group_4_1__1__Impl )
            // InternalAceGen.g:2568:2: rule__HttpClientStateElement__Group_4_1__1__Impl
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
    // InternalAceGen.g:2574:1: rule__HttpClientStateElement__Group_4_1__1__Impl : ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) ) ;
    public final void rule__HttpClientStateElement__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2578:1: ( ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) ) )
            // InternalAceGen.g:2579:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) )
            {
            // InternalAceGen.g:2579:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) )
            // InternalAceGen.g:2580:2: ( rule__HttpClientStateElement__TypesAssignment_4_1_1 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_1_1()); 
            // InternalAceGen.g:2581:2: ( rule__HttpClientStateElement__TypesAssignment_4_1_1 )
            // InternalAceGen.g:2581:3: rule__HttpClientStateElement__TypesAssignment_4_1_1
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
    // InternalAceGen.g:2590:1: rule__HttpClientTypeDefinition__Group__0 : rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1 ;
    public final void rule__HttpClientTypeDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2594:1: ( rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1 )
            // InternalAceGen.g:2595:2: rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1
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
    // InternalAceGen.g:2602:1: rule__HttpClientTypeDefinition__Group__0__Impl : ( ':' ) ;
    public final void rule__HttpClientTypeDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2606:1: ( ( ':' ) )
            // InternalAceGen.g:2607:1: ( ':' )
            {
            // InternalAceGen.g:2607:1: ( ':' )
            // InternalAceGen.g:2608:2: ':'
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getColonKeyword_0()); 
            match(input,44,FOLLOW_2); 
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
    // InternalAceGen.g:2617:1: rule__HttpClientTypeDefinition__Group__1 : rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2 ;
    public final void rule__HttpClientTypeDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2621:1: ( rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2 )
            // InternalAceGen.g:2622:2: rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2
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
    // InternalAceGen.g:2629:1: rule__HttpClientTypeDefinition__Group__1__Impl : ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) ) ;
    public final void rule__HttpClientTypeDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2633:1: ( ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) ) )
            // InternalAceGen.g:2634:1: ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) )
            {
            // InternalAceGen.g:2634:1: ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) )
            // InternalAceGen.g:2635:2: ( rule__HttpClientTypeDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getNameAssignment_1()); 
            // InternalAceGen.g:2636:2: ( rule__HttpClientTypeDefinition__NameAssignment_1 )
            // InternalAceGen.g:2636:3: rule__HttpClientTypeDefinition__NameAssignment_1
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
    // InternalAceGen.g:2644:1: rule__HttpClientTypeDefinition__Group__2 : rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3 ;
    public final void rule__HttpClientTypeDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2648:1: ( rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3 )
            // InternalAceGen.g:2649:2: rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3
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
    // InternalAceGen.g:2656:1: rule__HttpClientTypeDefinition__Group__2__Impl : ( '{' ) ;
    public final void rule__HttpClientTypeDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2660:1: ( ( '{' ) )
            // InternalAceGen.g:2661:1: ( '{' )
            {
            // InternalAceGen.g:2661:1: ( '{' )
            // InternalAceGen.g:2662:2: '{'
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,45,FOLLOW_2); 
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
    // InternalAceGen.g:2671:1: rule__HttpClientTypeDefinition__Group__3 : rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4 ;
    public final void rule__HttpClientTypeDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2675:1: ( rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4 )
            // InternalAceGen.g:2676:2: rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4
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
    // InternalAceGen.g:2683:1: rule__HttpClientTypeDefinition__Group__3__Impl : ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* ) ;
    public final void rule__HttpClientTypeDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2687:1: ( ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* ) )
            // InternalAceGen.g:2688:1: ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* )
            {
            // InternalAceGen.g:2688:1: ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* )
            // InternalAceGen.g:2689:2: ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )*
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getElementsAssignment_3()); 
            // InternalAceGen.g:2690:2: ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalAceGen.g:2690:3: rule__HttpClientTypeDefinition__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpClientTypeDefinition__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalAceGen.g:2698:1: rule__HttpClientTypeDefinition__Group__4 : rule__HttpClientTypeDefinition__Group__4__Impl ;
    public final void rule__HttpClientTypeDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2702:1: ( rule__HttpClientTypeDefinition__Group__4__Impl )
            // InternalAceGen.g:2703:2: rule__HttpClientTypeDefinition__Group__4__Impl
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
    // InternalAceGen.g:2709:1: rule__HttpClientTypeDefinition__Group__4__Impl : ( '}' ) ;
    public final void rule__HttpClientTypeDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2713:1: ( ( '}' ) )
            // InternalAceGen.g:2714:1: ( '}' )
            {
            // InternalAceGen.g:2714:1: ( '}' )
            // InternalAceGen.g:2715:2: '}'
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,46,FOLLOW_2); 
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
    // InternalAceGen.g:2725:1: rule__HttpServer__Group__0 : rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1 ;
    public final void rule__HttpServer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2729:1: ( rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1 )
            // InternalAceGen.g:2730:2: rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1
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
    // InternalAceGen.g:2737:1: rule__HttpServer__Group__0__Impl : ( ( rule__HttpServer__TypeAssignment_0 )? ) ;
    public final void rule__HttpServer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2741:1: ( ( ( rule__HttpServer__TypeAssignment_0 )? ) )
            // InternalAceGen.g:2742:1: ( ( rule__HttpServer__TypeAssignment_0 )? )
            {
            // InternalAceGen.g:2742:1: ( ( rule__HttpServer__TypeAssignment_0 )? )
            // InternalAceGen.g:2743:2: ( rule__HttpServer__TypeAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAccess().getTypeAssignment_0()); 
            // InternalAceGen.g:2744:2: ( rule__HttpServer__TypeAssignment_0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=17 && LA32_0<=18)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAceGen.g:2744:3: rule__HttpServer__TypeAssignment_0
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
    // InternalAceGen.g:2752:1: rule__HttpServer__Group__1 : rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2 ;
    public final void rule__HttpServer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2756:1: ( rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2 )
            // InternalAceGen.g:2757:2: rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2
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
    // InternalAceGen.g:2764:1: rule__HttpServer__Group__1__Impl : ( ( rule__HttpServer__NameAssignment_1 ) ) ;
    public final void rule__HttpServer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2768:1: ( ( ( rule__HttpServer__NameAssignment_1 ) ) )
            // InternalAceGen.g:2769:1: ( ( rule__HttpServer__NameAssignment_1 ) )
            {
            // InternalAceGen.g:2769:1: ( ( rule__HttpServer__NameAssignment_1 ) )
            // InternalAceGen.g:2770:2: ( rule__HttpServer__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAccess().getNameAssignment_1()); 
            // InternalAceGen.g:2771:2: ( rule__HttpServer__NameAssignment_1 )
            // InternalAceGen.g:2771:3: rule__HttpServer__NameAssignment_1
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
    // InternalAceGen.g:2779:1: rule__HttpServer__Group__2 : rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3 ;
    public final void rule__HttpServer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2783:1: ( rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3 )
            // InternalAceGen.g:2784:2: rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3
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
    // InternalAceGen.g:2791:1: rule__HttpServer__Group__2__Impl : ( ( rule__HttpServer__Group_2__0 )? ) ;
    public final void rule__HttpServer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2795:1: ( ( ( rule__HttpServer__Group_2__0 )? ) )
            // InternalAceGen.g:2796:1: ( ( rule__HttpServer__Group_2__0 )? )
            {
            // InternalAceGen.g:2796:1: ( ( rule__HttpServer__Group_2__0 )? )
            // InternalAceGen.g:2797:2: ( rule__HttpServer__Group_2__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_2()); 
            // InternalAceGen.g:2798:2: ( rule__HttpServer__Group_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==47) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalAceGen.g:2798:3: rule__HttpServer__Group_2__0
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
    // InternalAceGen.g:2806:1: rule__HttpServer__Group__3 : rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4 ;
    public final void rule__HttpServer__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2810:1: ( rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4 )
            // InternalAceGen.g:2811:2: rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4
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
    // InternalAceGen.g:2818:1: rule__HttpServer__Group__3__Impl : ( ( rule__HttpServer__Group_3__0 )? ) ;
    public final void rule__HttpServer__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2822:1: ( ( ( rule__HttpServer__Group_3__0 )? ) )
            // InternalAceGen.g:2823:1: ( ( rule__HttpServer__Group_3__0 )? )
            {
            // InternalAceGen.g:2823:1: ( ( rule__HttpServer__Group_3__0 )? )
            // InternalAceGen.g:2824:2: ( rule__HttpServer__Group_3__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_3()); 
            // InternalAceGen.g:2825:2: ( rule__HttpServer__Group_3__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==48) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAceGen.g:2825:3: rule__HttpServer__Group_3__0
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
    // InternalAceGen.g:2833:1: rule__HttpServer__Group__4 : rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5 ;
    public final void rule__HttpServer__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2837:1: ( rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5 )
            // InternalAceGen.g:2838:2: rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5
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
    // InternalAceGen.g:2845:1: rule__HttpServer__Group__4__Impl : ( ( rule__HttpServer__Group_4__0 )? ) ;
    public final void rule__HttpServer__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2849:1: ( ( ( rule__HttpServer__Group_4__0 )? ) )
            // InternalAceGen.g:2850:1: ( ( rule__HttpServer__Group_4__0 )? )
            {
            // InternalAceGen.g:2850:1: ( ( rule__HttpServer__Group_4__0 )? )
            // InternalAceGen.g:2851:2: ( rule__HttpServer__Group_4__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_4()); 
            // InternalAceGen.g:2852:2: ( rule__HttpServer__Group_4__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==32) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalAceGen.g:2852:3: rule__HttpServer__Group_4__0
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
    // InternalAceGen.g:2860:1: rule__HttpServer__Group__5 : rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6 ;
    public final void rule__HttpServer__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2864:1: ( rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6 )
            // InternalAceGen.g:2865:2: rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6
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
    // InternalAceGen.g:2872:1: rule__HttpServer__Group__5__Impl : ( ( rule__HttpServer__Group_5__0 )? ) ;
    public final void rule__HttpServer__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2876:1: ( ( ( rule__HttpServer__Group_5__0 )? ) )
            // InternalAceGen.g:2877:1: ( ( rule__HttpServer__Group_5__0 )? )
            {
            // InternalAceGen.g:2877:1: ( ( rule__HttpServer__Group_5__0 )? )
            // InternalAceGen.g:2878:2: ( rule__HttpServer__Group_5__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_5()); 
            // InternalAceGen.g:2879:2: ( rule__HttpServer__Group_5__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==49) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalAceGen.g:2879:3: rule__HttpServer__Group_5__0
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
    // InternalAceGen.g:2887:1: rule__HttpServer__Group__6 : rule__HttpServer__Group__6__Impl rule__HttpServer__Group__7 ;
    public final void rule__HttpServer__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2891:1: ( rule__HttpServer__Group__6__Impl rule__HttpServer__Group__7 )
            // InternalAceGen.g:2892:2: rule__HttpServer__Group__6__Impl rule__HttpServer__Group__7
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
    // InternalAceGen.g:2899:1: rule__HttpServer__Group__6__Impl : ( ( rule__HttpServer__Group_6__0 )? ) ;
    public final void rule__HttpServer__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2903:1: ( ( ( rule__HttpServer__Group_6__0 )? ) )
            // InternalAceGen.g:2904:1: ( ( rule__HttpServer__Group_6__0 )? )
            {
            // InternalAceGen.g:2904:1: ( ( rule__HttpServer__Group_6__0 )? )
            // InternalAceGen.g:2905:2: ( rule__HttpServer__Group_6__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_6()); 
            // InternalAceGen.g:2906:2: ( rule__HttpServer__Group_6__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==50) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalAceGen.g:2906:3: rule__HttpServer__Group_6__0
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
    // InternalAceGen.g:2914:1: rule__HttpServer__Group__7 : rule__HttpServer__Group__7__Impl ;
    public final void rule__HttpServer__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2918:1: ( rule__HttpServer__Group__7__Impl )
            // InternalAceGen.g:2919:2: rule__HttpServer__Group__7__Impl
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
    // InternalAceGen.g:2925:1: rule__HttpServer__Group__7__Impl : ( ( rule__HttpServer__Group_7__0 )? ) ;
    public final void rule__HttpServer__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2929:1: ( ( ( rule__HttpServer__Group_7__0 )? ) )
            // InternalAceGen.g:2930:1: ( ( rule__HttpServer__Group_7__0 )? )
            {
            // InternalAceGen.g:2930:1: ( ( rule__HttpServer__Group_7__0 )? )
            // InternalAceGen.g:2931:2: ( rule__HttpServer__Group_7__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_7()); 
            // InternalAceGen.g:2932:2: ( rule__HttpServer__Group_7__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==51) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAceGen.g:2932:3: rule__HttpServer__Group_7__0
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
    // InternalAceGen.g:2941:1: rule__HttpServer__Group_2__0 : rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1 ;
    public final void rule__HttpServer__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2945:1: ( rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1 )
            // InternalAceGen.g:2946:2: rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1
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
    // InternalAceGen.g:2953:1: rule__HttpServer__Group_2__0__Impl : ( 'Authorization' ) ;
    public final void rule__HttpServer__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2957:1: ( ( 'Authorization' ) )
            // InternalAceGen.g:2958:1: ( 'Authorization' )
            {
            // InternalAceGen.g:2958:1: ( 'Authorization' )
            // InternalAceGen.g:2959:2: 'Authorization'
            {
             before(grammarAccess.getHttpServerAccess().getAuthorizationKeyword_2_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalAceGen.g:2968:1: rule__HttpServer__Group_2__1 : rule__HttpServer__Group_2__1__Impl ;
    public final void rule__HttpServer__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2972:1: ( rule__HttpServer__Group_2__1__Impl )
            // InternalAceGen.g:2973:2: rule__HttpServer__Group_2__1__Impl
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
    // InternalAceGen.g:2979:1: rule__HttpServer__Group_2__1__Impl : ( ( rule__HttpServer__AuthUserAssignment_2_1 ) ) ;
    public final void rule__HttpServer__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2983:1: ( ( ( rule__HttpServer__AuthUserAssignment_2_1 ) ) )
            // InternalAceGen.g:2984:1: ( ( rule__HttpServer__AuthUserAssignment_2_1 ) )
            {
            // InternalAceGen.g:2984:1: ( ( rule__HttpServer__AuthUserAssignment_2_1 ) )
            // InternalAceGen.g:2985:2: ( rule__HttpServer__AuthUserAssignment_2_1 )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserAssignment_2_1()); 
            // InternalAceGen.g:2986:2: ( rule__HttpServer__AuthUserAssignment_2_1 )
            // InternalAceGen.g:2986:3: rule__HttpServer__AuthUserAssignment_2_1
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
    // InternalAceGen.g:2995:1: rule__HttpServer__Group_3__0 : rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1 ;
    public final void rule__HttpServer__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2999:1: ( rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1 )
            // InternalAceGen.g:3000:2: rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1
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
    // InternalAceGen.g:3007:1: rule__HttpServer__Group_3__0__Impl : ( 'import' ) ;
    public final void rule__HttpServer__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3011:1: ( ( 'import' ) )
            // InternalAceGen.g:3012:1: ( 'import' )
            {
            // InternalAceGen.g:3012:1: ( 'import' )
            // InternalAceGen.g:3013:2: 'import'
            {
             before(grammarAccess.getHttpServerAccess().getImportKeyword_3_0()); 
            match(input,48,FOLLOW_2); 
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
    // InternalAceGen.g:3022:1: rule__HttpServer__Group_3__1 : rule__HttpServer__Group_3__1__Impl ;
    public final void rule__HttpServer__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3026:1: ( rule__HttpServer__Group_3__1__Impl )
            // InternalAceGen.g:3027:2: rule__HttpServer__Group_3__1__Impl
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
    // InternalAceGen.g:3033:1: rule__HttpServer__Group_3__1__Impl : ( ( rule__HttpServer__AuthUserRefAssignment_3_1 ) ) ;
    public final void rule__HttpServer__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3037:1: ( ( ( rule__HttpServer__AuthUserRefAssignment_3_1 ) ) )
            // InternalAceGen.g:3038:1: ( ( rule__HttpServer__AuthUserRefAssignment_3_1 ) )
            {
            // InternalAceGen.g:3038:1: ( ( rule__HttpServer__AuthUserRefAssignment_3_1 ) )
            // InternalAceGen.g:3039:2: ( rule__HttpServer__AuthUserRefAssignment_3_1 )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAssignment_3_1()); 
            // InternalAceGen.g:3040:2: ( rule__HttpServer__AuthUserRefAssignment_3_1 )
            // InternalAceGen.g:3040:3: rule__HttpServer__AuthUserRefAssignment_3_1
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
    // InternalAceGen.g:3049:1: rule__HttpServer__Group_4__0 : rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1 ;
    public final void rule__HttpServer__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3053:1: ( rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1 )
            // InternalAceGen.g:3054:2: rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1
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
    // InternalAceGen.g:3061:1: rule__HttpServer__Group_4__0__Impl : ( 'ACE' ) ;
    public final void rule__HttpServer__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3065:1: ( ( 'ACE' ) )
            // InternalAceGen.g:3066:1: ( 'ACE' )
            {
            // InternalAceGen.g:3066:1: ( 'ACE' )
            // InternalAceGen.g:3067:2: 'ACE'
            {
             before(grammarAccess.getHttpServerAccess().getACEKeyword_4_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalAceGen.g:3076:1: rule__HttpServer__Group_4__1 : rule__HttpServer__Group_4__1__Impl ;
    public final void rule__HttpServer__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3080:1: ( rule__HttpServer__Group_4__1__Impl )
            // InternalAceGen.g:3081:2: rule__HttpServer__Group_4__1__Impl
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
    // InternalAceGen.g:3087:1: rule__HttpServer__Group_4__1__Impl : ( ( rule__HttpServer__AceOperationsAssignment_4_1 )* ) ;
    public final void rule__HttpServer__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3091:1: ( ( ( rule__HttpServer__AceOperationsAssignment_4_1 )* ) )
            // InternalAceGen.g:3092:1: ( ( rule__HttpServer__AceOperationsAssignment_4_1 )* )
            {
            // InternalAceGen.g:3092:1: ( ( rule__HttpServer__AceOperationsAssignment_4_1 )* )
            // InternalAceGen.g:3093:2: ( rule__HttpServer__AceOperationsAssignment_4_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getAceOperationsAssignment_4_1()); 
            // InternalAceGen.g:3094:2: ( rule__HttpServer__AceOperationsAssignment_4_1 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID||LA39_0==72) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalAceGen.g:3094:3: rule__HttpServer__AceOperationsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__HttpServer__AceOperationsAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalAceGen.g:3103:1: rule__HttpServer__Group_5__0 : rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1 ;
    public final void rule__HttpServer__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3107:1: ( rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1 )
            // InternalAceGen.g:3108:2: rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1
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
    // InternalAceGen.g:3115:1: rule__HttpServer__Group_5__0__Impl : ( 'views' ) ;
    public final void rule__HttpServer__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3119:1: ( ( 'views' ) )
            // InternalAceGen.g:3120:1: ( 'views' )
            {
            // InternalAceGen.g:3120:1: ( 'views' )
            // InternalAceGen.g:3121:2: 'views'
            {
             before(grammarAccess.getHttpServerAccess().getViewsKeyword_5_0()); 
            match(input,49,FOLLOW_2); 
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
    // InternalAceGen.g:3130:1: rule__HttpServer__Group_5__1 : rule__HttpServer__Group_5__1__Impl ;
    public final void rule__HttpServer__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3134:1: ( rule__HttpServer__Group_5__1__Impl )
            // InternalAceGen.g:3135:2: rule__HttpServer__Group_5__1__Impl
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
    // InternalAceGen.g:3141:1: rule__HttpServer__Group_5__1__Impl : ( ( rule__HttpServer__ViewsAssignment_5_1 )* ) ;
    public final void rule__HttpServer__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3145:1: ( ( ( rule__HttpServer__ViewsAssignment_5_1 )* ) )
            // InternalAceGen.g:3146:1: ( ( rule__HttpServer__ViewsAssignment_5_1 )* )
            {
            // InternalAceGen.g:3146:1: ( ( rule__HttpServer__ViewsAssignment_5_1 )* )
            // InternalAceGen.g:3147:2: ( rule__HttpServer__ViewsAssignment_5_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getViewsAssignment_5_1()); 
            // InternalAceGen.g:3148:2: ( rule__HttpServer__ViewsAssignment_5_1 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_ID) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalAceGen.g:3148:3: rule__HttpServer__ViewsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServer__ViewsAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
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
    // InternalAceGen.g:3157:1: rule__HttpServer__Group_6__0 : rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1 ;
    public final void rule__HttpServer__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3161:1: ( rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1 )
            // InternalAceGen.g:3162:2: rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1
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
    // InternalAceGen.g:3169:1: rule__HttpServer__Group_6__0__Impl : ( 'models' ) ;
    public final void rule__HttpServer__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3173:1: ( ( 'models' ) )
            // InternalAceGen.g:3174:1: ( 'models' )
            {
            // InternalAceGen.g:3174:1: ( 'models' )
            // InternalAceGen.g:3175:2: 'models'
            {
             before(grammarAccess.getHttpServerAccess().getModelsKeyword_6_0()); 
            match(input,50,FOLLOW_2); 
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
    // InternalAceGen.g:3184:1: rule__HttpServer__Group_6__1 : rule__HttpServer__Group_6__1__Impl ;
    public final void rule__HttpServer__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3188:1: ( rule__HttpServer__Group_6__1__Impl )
            // InternalAceGen.g:3189:2: rule__HttpServer__Group_6__1__Impl
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
    // InternalAceGen.g:3195:1: rule__HttpServer__Group_6__1__Impl : ( ( rule__HttpServer__ModelsAssignment_6_1 )* ) ;
    public final void rule__HttpServer__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3199:1: ( ( ( rule__HttpServer__ModelsAssignment_6_1 )* ) )
            // InternalAceGen.g:3200:1: ( ( rule__HttpServer__ModelsAssignment_6_1 )* )
            {
            // InternalAceGen.g:3200:1: ( ( rule__HttpServer__ModelsAssignment_6_1 )* )
            // InternalAceGen.g:3201:2: ( rule__HttpServer__ModelsAssignment_6_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getModelsAssignment_6_1()); 
            // InternalAceGen.g:3202:2: ( rule__HttpServer__ModelsAssignment_6_1 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID||LA41_0==75) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalAceGen.g:3202:3: rule__HttpServer__ModelsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_29);
            	    rule__HttpServer__ModelsAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
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
    // InternalAceGen.g:3211:1: rule__HttpServer__Group_7__0 : rule__HttpServer__Group_7__0__Impl rule__HttpServer__Group_7__1 ;
    public final void rule__HttpServer__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3215:1: ( rule__HttpServer__Group_7__0__Impl rule__HttpServer__Group_7__1 )
            // InternalAceGen.g:3216:2: rule__HttpServer__Group_7__0__Impl rule__HttpServer__Group_7__1
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
    // InternalAceGen.g:3223:1: rule__HttpServer__Group_7__0__Impl : ( 'scenarios' ) ;
    public final void rule__HttpServer__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3227:1: ( ( 'scenarios' ) )
            // InternalAceGen.g:3228:1: ( 'scenarios' )
            {
            // InternalAceGen.g:3228:1: ( 'scenarios' )
            // InternalAceGen.g:3229:2: 'scenarios'
            {
             before(grammarAccess.getHttpServerAccess().getScenariosKeyword_7_0()); 
            match(input,51,FOLLOW_2); 
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
    // InternalAceGen.g:3238:1: rule__HttpServer__Group_7__1 : rule__HttpServer__Group_7__1__Impl ;
    public final void rule__HttpServer__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3242:1: ( rule__HttpServer__Group_7__1__Impl )
            // InternalAceGen.g:3243:2: rule__HttpServer__Group_7__1__Impl
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
    // InternalAceGen.g:3249:1: rule__HttpServer__Group_7__1__Impl : ( ( rule__HttpServer__ScenariosAssignment_7_1 )* ) ;
    public final void rule__HttpServer__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3253:1: ( ( ( rule__HttpServer__ScenariosAssignment_7_1 )* ) )
            // InternalAceGen.g:3254:1: ( ( rule__HttpServer__ScenariosAssignment_7_1 )* )
            {
            // InternalAceGen.g:3254:1: ( ( rule__HttpServer__ScenariosAssignment_7_1 )* )
            // InternalAceGen.g:3255:2: ( rule__HttpServer__ScenariosAssignment_7_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getScenariosAssignment_7_1()); 
            // InternalAceGen.g:3256:2: ( rule__HttpServer__ScenariosAssignment_7_1 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_ID) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalAceGen.g:3256:3: rule__HttpServer__ScenariosAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServer__ScenariosAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // InternalAceGen.g:3265:1: rule__HttpServerAceWrite__Group__0 : rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1 ;
    public final void rule__HttpServerAceWrite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3269:1: ( rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1 )
            // InternalAceGen.g:3270:2: rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1
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
    // InternalAceGen.g:3277:1: rule__HttpServerAceWrite__Group__0__Impl : ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3281:1: ( ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? ) )
            // InternalAceGen.g:3282:1: ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? )
            {
            // InternalAceGen.g:3282:1: ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? )
            // InternalAceGen.g:3283:2: ( rule__HttpServerAceWrite__ProxyAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyAssignment_0()); 
            // InternalAceGen.g:3284:2: ( rule__HttpServerAceWrite__ProxyAssignment_0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==72) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalAceGen.g:3284:3: rule__HttpServerAceWrite__ProxyAssignment_0
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
    // InternalAceGen.g:3292:1: rule__HttpServerAceWrite__Group__1 : rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2 ;
    public final void rule__HttpServerAceWrite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3296:1: ( rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2 )
            // InternalAceGen.g:3297:2: rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2
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
    // InternalAceGen.g:3304:1: rule__HttpServerAceWrite__Group__1__Impl : ( ( rule__HttpServerAceWrite__NameAssignment_1 ) ) ;
    public final void rule__HttpServerAceWrite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3308:1: ( ( ( rule__HttpServerAceWrite__NameAssignment_1 ) ) )
            // InternalAceGen.g:3309:1: ( ( rule__HttpServerAceWrite__NameAssignment_1 ) )
            {
            // InternalAceGen.g:3309:1: ( ( rule__HttpServerAceWrite__NameAssignment_1 ) )
            // InternalAceGen.g:3310:2: ( rule__HttpServerAceWrite__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getNameAssignment_1()); 
            // InternalAceGen.g:3311:2: ( rule__HttpServerAceWrite__NameAssignment_1 )
            // InternalAceGen.g:3311:3: rule__HttpServerAceWrite__NameAssignment_1
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
    // InternalAceGen.g:3319:1: rule__HttpServerAceWrite__Group__2 : rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3 ;
    public final void rule__HttpServerAceWrite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3323:1: ( rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3 )
            // InternalAceGen.g:3324:2: rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3
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
    // InternalAceGen.g:3331:1: rule__HttpServerAceWrite__Group__2__Impl : ( '<' ) ;
    public final void rule__HttpServerAceWrite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3335:1: ( ( '<' ) )
            // InternalAceGen.g:3336:1: ( '<' )
            {
            // InternalAceGen.g:3336:1: ( '<' )
            // InternalAceGen.g:3337:2: '<'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getLessThanSignKeyword_2()); 
            match(input,34,FOLLOW_2); 
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
    // InternalAceGen.g:3346:1: rule__HttpServerAceWrite__Group__3 : rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4 ;
    public final void rule__HttpServerAceWrite__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3350:1: ( rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4 )
            // InternalAceGen.g:3351:2: rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4
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
    // InternalAceGen.g:3358:1: rule__HttpServerAceWrite__Group__3__Impl : ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) ) ;
    public final void rule__HttpServerAceWrite__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3362:1: ( ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) ) )
            // InternalAceGen.g:3363:1: ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) )
            {
            // InternalAceGen.g:3363:1: ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) )
            // InternalAceGen.g:3364:2: ( rule__HttpServerAceWrite__ModelAssignment_3 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getModelAssignment_3()); 
            // InternalAceGen.g:3365:2: ( rule__HttpServerAceWrite__ModelAssignment_3 )
            // InternalAceGen.g:3365:3: rule__HttpServerAceWrite__ModelAssignment_3
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
    // InternalAceGen.g:3373:1: rule__HttpServerAceWrite__Group__4 : rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5 ;
    public final void rule__HttpServerAceWrite__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3377:1: ( rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5 )
            // InternalAceGen.g:3378:2: rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5
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
    // InternalAceGen.g:3385:1: rule__HttpServerAceWrite__Group__4__Impl : ( '>' ) ;
    public final void rule__HttpServerAceWrite__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3389:1: ( ( '>' ) )
            // InternalAceGen.g:3390:1: ( '>' )
            {
            // InternalAceGen.g:3390:1: ( '>' )
            // InternalAceGen.g:3391:2: '>'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGreaterThanSignKeyword_4()); 
            match(input,35,FOLLOW_2); 
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
    // InternalAceGen.g:3400:1: rule__HttpServerAceWrite__Group__5 : rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6 ;
    public final void rule__HttpServerAceWrite__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3404:1: ( rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6 )
            // InternalAceGen.g:3405:2: rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6
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
    // InternalAceGen.g:3412:1: rule__HttpServerAceWrite__Group__5__Impl : ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) ) ;
    public final void rule__HttpServerAceWrite__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3416:1: ( ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) ) )
            // InternalAceGen.g:3417:1: ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) )
            {
            // InternalAceGen.g:3417:1: ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) )
            // InternalAceGen.g:3418:2: ( rule__HttpServerAceWrite__TypeAssignment_5 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getTypeAssignment_5()); 
            // InternalAceGen.g:3419:2: ( rule__HttpServerAceWrite__TypeAssignment_5 )
            // InternalAceGen.g:3419:3: rule__HttpServerAceWrite__TypeAssignment_5
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
    // InternalAceGen.g:3427:1: rule__HttpServerAceWrite__Group__6 : rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7 ;
    public final void rule__HttpServerAceWrite__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3431:1: ( rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7 )
            // InternalAceGen.g:3432:2: rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7
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
    // InternalAceGen.g:3439:1: rule__HttpServerAceWrite__Group__6__Impl : ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) ) ;
    public final void rule__HttpServerAceWrite__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3443:1: ( ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) ) )
            // InternalAceGen.g:3444:1: ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) )
            {
            // InternalAceGen.g:3444:1: ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) )
            // InternalAceGen.g:3445:2: ( rule__HttpServerAceWrite__UrlAssignment_6 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getUrlAssignment_6()); 
            // InternalAceGen.g:3446:2: ( rule__HttpServerAceWrite__UrlAssignment_6 )
            // InternalAceGen.g:3446:3: rule__HttpServerAceWrite__UrlAssignment_6
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
    // InternalAceGen.g:3454:1: rule__HttpServerAceWrite__Group__7 : rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8 ;
    public final void rule__HttpServerAceWrite__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3458:1: ( rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8 )
            // InternalAceGen.g:3459:2: rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8
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
    // InternalAceGen.g:3466:1: rule__HttpServerAceWrite__Group__7__Impl : ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? ) ;
    public final void rule__HttpServerAceWrite__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3470:1: ( ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? ) )
            // InternalAceGen.g:3471:1: ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? )
            {
            // InternalAceGen.g:3471:1: ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? )
            // InternalAceGen.g:3472:2: ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAssignment_7()); 
            // InternalAceGen.g:3473:2: ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==73) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalAceGen.g:3473:3: rule__HttpServerAceWrite__AuthorizeAssignment_7
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
    // InternalAceGen.g:3481:1: rule__HttpServerAceWrite__Group__8 : rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9 ;
    public final void rule__HttpServerAceWrite__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3485:1: ( rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9 )
            // InternalAceGen.g:3486:2: rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9
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
    // InternalAceGen.g:3493:1: rule__HttpServerAceWrite__Group__8__Impl : ( ( rule__HttpServerAceWrite__Group_8__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3497:1: ( ( ( rule__HttpServerAceWrite__Group_8__0 )? ) )
            // InternalAceGen.g:3498:1: ( ( rule__HttpServerAceWrite__Group_8__0 )? )
            {
            // InternalAceGen.g:3498:1: ( ( rule__HttpServerAceWrite__Group_8__0 )? )
            // InternalAceGen.g:3499:2: ( rule__HttpServerAceWrite__Group_8__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_8()); 
            // InternalAceGen.g:3500:2: ( rule__HttpServerAceWrite__Group_8__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==52) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAceGen.g:3500:3: rule__HttpServerAceWrite__Group_8__0
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
    // InternalAceGen.g:3508:1: rule__HttpServerAceWrite__Group__9 : rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10 ;
    public final void rule__HttpServerAceWrite__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3512:1: ( rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10 )
            // InternalAceGen.g:3513:2: rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10
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
    // InternalAceGen.g:3520:1: rule__HttpServerAceWrite__Group__9__Impl : ( ( rule__HttpServerAceWrite__Group_9__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3524:1: ( ( ( rule__HttpServerAceWrite__Group_9__0 )? ) )
            // InternalAceGen.g:3525:1: ( ( rule__HttpServerAceWrite__Group_9__0 )? )
            {
            // InternalAceGen.g:3525:1: ( ( rule__HttpServerAceWrite__Group_9__0 )? )
            // InternalAceGen.g:3526:2: ( rule__HttpServerAceWrite__Group_9__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_9()); 
            // InternalAceGen.g:3527:2: ( rule__HttpServerAceWrite__Group_9__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==53) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalAceGen.g:3527:3: rule__HttpServerAceWrite__Group_9__0
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
    // InternalAceGen.g:3535:1: rule__HttpServerAceWrite__Group__10 : rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11 ;
    public final void rule__HttpServerAceWrite__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3539:1: ( rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11 )
            // InternalAceGen.g:3540:2: rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11
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
    // InternalAceGen.g:3547:1: rule__HttpServerAceWrite__Group__10__Impl : ( ( rule__HttpServerAceWrite__Group_10__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3551:1: ( ( ( rule__HttpServerAceWrite__Group_10__0 )? ) )
            // InternalAceGen.g:3552:1: ( ( rule__HttpServerAceWrite__Group_10__0 )? )
            {
            // InternalAceGen.g:3552:1: ( ( rule__HttpServerAceWrite__Group_10__0 )? )
            // InternalAceGen.g:3553:2: ( rule__HttpServerAceWrite__Group_10__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_10()); 
            // InternalAceGen.g:3554:2: ( rule__HttpServerAceWrite__Group_10__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==54) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalAceGen.g:3554:3: rule__HttpServerAceWrite__Group_10__0
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
    // InternalAceGen.g:3562:1: rule__HttpServerAceWrite__Group__11 : rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12 ;
    public final void rule__HttpServerAceWrite__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3566:1: ( rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12 )
            // InternalAceGen.g:3567:2: rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12
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
    // InternalAceGen.g:3574:1: rule__HttpServerAceWrite__Group__11__Impl : ( ( rule__HttpServerAceWrite__Group_11__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3578:1: ( ( ( rule__HttpServerAceWrite__Group_11__0 )? ) )
            // InternalAceGen.g:3579:1: ( ( rule__HttpServerAceWrite__Group_11__0 )? )
            {
            // InternalAceGen.g:3579:1: ( ( rule__HttpServerAceWrite__Group_11__0 )? )
            // InternalAceGen.g:3580:2: ( rule__HttpServerAceWrite__Group_11__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_11()); 
            // InternalAceGen.g:3581:2: ( rule__HttpServerAceWrite__Group_11__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==55) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalAceGen.g:3581:3: rule__HttpServerAceWrite__Group_11__0
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
    // InternalAceGen.g:3589:1: rule__HttpServerAceWrite__Group__12 : rule__HttpServerAceWrite__Group__12__Impl ;
    public final void rule__HttpServerAceWrite__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3593:1: ( rule__HttpServerAceWrite__Group__12__Impl )
            // InternalAceGen.g:3594:2: rule__HttpServerAceWrite__Group__12__Impl
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
    // InternalAceGen.g:3600:1: rule__HttpServerAceWrite__Group__12__Impl : ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* ) ;
    public final void rule__HttpServerAceWrite__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3604:1: ( ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* ) )
            // InternalAceGen.g:3605:1: ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* )
            {
            // InternalAceGen.g:3605:1: ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* )
            // InternalAceGen.g:3606:2: ( rule__HttpServerAceWrite__OutcomesAssignment_12 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getOutcomesAssignment_12()); 
            // InternalAceGen.g:3607:2: ( rule__HttpServerAceWrite__OutcomesAssignment_12 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==39) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalAceGen.g:3607:3: rule__HttpServerAceWrite__OutcomesAssignment_12
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__HttpServerAceWrite__OutcomesAssignment_12();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
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
    // InternalAceGen.g:3616:1: rule__HttpServerAceWrite__Group_8__0 : rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1 ;
    public final void rule__HttpServerAceWrite__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3620:1: ( rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1 )
            // InternalAceGen.g:3621:2: rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1
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
    // InternalAceGen.g:3628:1: rule__HttpServerAceWrite__Group_8__0__Impl : ( 'pathParams' ) ;
    public final void rule__HttpServerAceWrite__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3632:1: ( ( 'pathParams' ) )
            // InternalAceGen.g:3633:1: ( 'pathParams' )
            {
            // InternalAceGen.g:3633:1: ( 'pathParams' )
            // InternalAceGen.g:3634:2: 'pathParams'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_8_0()); 
            match(input,52,FOLLOW_2); 
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
    // InternalAceGen.g:3643:1: rule__HttpServerAceWrite__Group_8__1 : rule__HttpServerAceWrite__Group_8__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3647:1: ( rule__HttpServerAceWrite__Group_8__1__Impl )
            // InternalAceGen.g:3648:2: rule__HttpServerAceWrite__Group_8__1__Impl
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
    // InternalAceGen.g:3654:1: rule__HttpServerAceWrite__Group_8__1__Impl : ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3658:1: ( ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* ) )
            // InternalAceGen.g:3659:1: ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* )
            {
            // InternalAceGen.g:3659:1: ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* )
            // InternalAceGen.g:3660:2: ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAssignment_8_1()); 
            // InternalAceGen.g:3661:2: ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    int LA50_2 = input.LA(2);

                    if ( (LA50_2==EOF||LA50_2==RULE_ID||LA50_2==39||(LA50_2>=49 && LA50_2<=51)||(LA50_2>=53 && LA50_2<=55)||LA50_2==65||LA50_2==72||LA50_2==74) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // InternalAceGen.g:3661:3: rule__HttpServerAceWrite__PathParamsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceWrite__PathParamsAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
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
    // InternalAceGen.g:3670:1: rule__HttpServerAceWrite__Group_9__0 : rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1 ;
    public final void rule__HttpServerAceWrite__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3674:1: ( rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1 )
            // InternalAceGen.g:3675:2: rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1
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
    // InternalAceGen.g:3682:1: rule__HttpServerAceWrite__Group_9__0__Impl : ( 'queryParams' ) ;
    public final void rule__HttpServerAceWrite__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3686:1: ( ( 'queryParams' ) )
            // InternalAceGen.g:3687:1: ( 'queryParams' )
            {
            // InternalAceGen.g:3687:1: ( 'queryParams' )
            // InternalAceGen.g:3688:2: 'queryParams'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_9_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalAceGen.g:3697:1: rule__HttpServerAceWrite__Group_9__1 : rule__HttpServerAceWrite__Group_9__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3701:1: ( rule__HttpServerAceWrite__Group_9__1__Impl )
            // InternalAceGen.g:3702:2: rule__HttpServerAceWrite__Group_9__1__Impl
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
    // InternalAceGen.g:3708:1: rule__HttpServerAceWrite__Group_9__1__Impl : ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3712:1: ( ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* ) )
            // InternalAceGen.g:3713:1: ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* )
            {
            // InternalAceGen.g:3713:1: ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* )
            // InternalAceGen.g:3714:2: ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAssignment_9_1()); 
            // InternalAceGen.g:3715:2: ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID) ) {
                    int LA51_2 = input.LA(2);

                    if ( (LA51_2==EOF||LA51_2==RULE_ID||LA51_2==39||(LA51_2>=49 && LA51_2<=51)||(LA51_2>=54 && LA51_2<=55)||LA51_2==65||LA51_2==72||LA51_2==74) ) {
                        alt51=1;
                    }


                }


                switch (alt51) {
            	case 1 :
            	    // InternalAceGen.g:3715:3: rule__HttpServerAceWrite__QueryParamsAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceWrite__QueryParamsAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
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
    // InternalAceGen.g:3724:1: rule__HttpServerAceWrite__Group_10__0 : rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1 ;
    public final void rule__HttpServerAceWrite__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3728:1: ( rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1 )
            // InternalAceGen.g:3729:2: rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1
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
    // InternalAceGen.g:3736:1: rule__HttpServerAceWrite__Group_10__0__Impl : ( 'payload' ) ;
    public final void rule__HttpServerAceWrite__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3740:1: ( ( 'payload' ) )
            // InternalAceGen.g:3741:1: ( 'payload' )
            {
            // InternalAceGen.g:3741:1: ( 'payload' )
            // InternalAceGen.g:3742:2: 'payload'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_10_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalAceGen.g:3751:1: rule__HttpServerAceWrite__Group_10__1 : rule__HttpServerAceWrite__Group_10__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3755:1: ( rule__HttpServerAceWrite__Group_10__1__Impl )
            // InternalAceGen.g:3756:2: rule__HttpServerAceWrite__Group_10__1__Impl
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
    // InternalAceGen.g:3762:1: rule__HttpServerAceWrite__Group_10__1__Impl : ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3766:1: ( ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* ) )
            // InternalAceGen.g:3767:1: ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* )
            {
            // InternalAceGen.g:3767:1: ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* )
            // InternalAceGen.g:3768:2: ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadAssignment_10_1()); 
            // InternalAceGen.g:3769:2: ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    int LA52_2 = input.LA(2);

                    if ( (LA52_2==EOF||LA52_2==RULE_ID||LA52_2==39||(LA52_2>=49 && LA52_2<=51)||LA52_2==55||LA52_2==65||LA52_2==72||LA52_2==74) ) {
                        alt52=1;
                    }


                }


                switch (alt52) {
            	case 1 :
            	    // InternalAceGen.g:3769:3: rule__HttpServerAceWrite__PayloadAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceWrite__PayloadAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
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
    // InternalAceGen.g:3778:1: rule__HttpServerAceWrite__Group_11__0 : rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1 ;
    public final void rule__HttpServerAceWrite__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3782:1: ( rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1 )
            // InternalAceGen.g:3783:2: rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1
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
    // InternalAceGen.g:3790:1: rule__HttpServerAceWrite__Group_11__0__Impl : ( 'response' ) ;
    public final void rule__HttpServerAceWrite__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3794:1: ( ( 'response' ) )
            // InternalAceGen.g:3795:1: ( 'response' )
            {
            // InternalAceGen.g:3795:1: ( 'response' )
            // InternalAceGen.g:3796:2: 'response'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_11_0()); 
            match(input,55,FOLLOW_2); 
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
    // InternalAceGen.g:3805:1: rule__HttpServerAceWrite__Group_11__1 : rule__HttpServerAceWrite__Group_11__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3809:1: ( rule__HttpServerAceWrite__Group_11__1__Impl )
            // InternalAceGen.g:3810:2: rule__HttpServerAceWrite__Group_11__1__Impl
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
    // InternalAceGen.g:3816:1: rule__HttpServerAceWrite__Group_11__1__Impl : ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3820:1: ( ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* ) )
            // InternalAceGen.g:3821:1: ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* )
            {
            // InternalAceGen.g:3821:1: ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* )
            // InternalAceGen.g:3822:2: ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseAssignment_11_1()); 
            // InternalAceGen.g:3823:2: ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID) ) {
                    int LA53_2 = input.LA(2);

                    if ( (LA53_2==EOF||LA53_2==RULE_ID||LA53_2==39||(LA53_2>=49 && LA53_2<=51)||LA53_2==65||LA53_2==72) ) {
                        alt53=1;
                    }


                }


                switch (alt53) {
            	case 1 :
            	    // InternalAceGen.g:3823:3: rule__HttpServerAceWrite__ResponseAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceWrite__ResponseAssignment_11_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
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
    // InternalAceGen.g:3832:1: rule__HttpServerOutcome__Group__0 : rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1 ;
    public final void rule__HttpServerOutcome__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3836:1: ( rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1 )
            // InternalAceGen.g:3837:2: rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1
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
    // InternalAceGen.g:3844:1: rule__HttpServerOutcome__Group__0__Impl : ( 'on' ) ;
    public final void rule__HttpServerOutcome__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3848:1: ( ( 'on' ) )
            // InternalAceGen.g:3849:1: ( 'on' )
            {
            // InternalAceGen.g:3849:1: ( 'on' )
            // InternalAceGen.g:3850:2: 'on'
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getOnKeyword_0()); 
            match(input,39,FOLLOW_2); 
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
    // InternalAceGen.g:3859:1: rule__HttpServerOutcome__Group__1 : rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2 ;
    public final void rule__HttpServerOutcome__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3863:1: ( rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2 )
            // InternalAceGen.g:3864:2: rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2
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
    // InternalAceGen.g:3871:1: rule__HttpServerOutcome__Group__1__Impl : ( ( rule__HttpServerOutcome__NameAssignment_1 ) ) ;
    public final void rule__HttpServerOutcome__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3875:1: ( ( ( rule__HttpServerOutcome__NameAssignment_1 ) ) )
            // InternalAceGen.g:3876:1: ( ( rule__HttpServerOutcome__NameAssignment_1 ) )
            {
            // InternalAceGen.g:3876:1: ( ( rule__HttpServerOutcome__NameAssignment_1 ) )
            // InternalAceGen.g:3877:2: ( rule__HttpServerOutcome__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getNameAssignment_1()); 
            // InternalAceGen.g:3878:2: ( rule__HttpServerOutcome__NameAssignment_1 )
            // InternalAceGen.g:3878:3: rule__HttpServerOutcome__NameAssignment_1
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
    // InternalAceGen.g:3886:1: rule__HttpServerOutcome__Group__2 : rule__HttpServerOutcome__Group__2__Impl ;
    public final void rule__HttpServerOutcome__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3890:1: ( rule__HttpServerOutcome__Group__2__Impl )
            // InternalAceGen.g:3891:2: rule__HttpServerOutcome__Group__2__Impl
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
    // InternalAceGen.g:3897:1: rule__HttpServerOutcome__Group__2__Impl : ( ( rule__HttpServerOutcome__Group_2__0 )* ) ;
    public final void rule__HttpServerOutcome__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3901:1: ( ( ( rule__HttpServerOutcome__Group_2__0 )* ) )
            // InternalAceGen.g:3902:1: ( ( rule__HttpServerOutcome__Group_2__0 )* )
            {
            // InternalAceGen.g:3902:1: ( ( rule__HttpServerOutcome__Group_2__0 )* )
            // InternalAceGen.g:3903:2: ( rule__HttpServerOutcome__Group_2__0 )*
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getGroup_2()); 
            // InternalAceGen.g:3904:2: ( rule__HttpServerOutcome__Group_2__0 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==40) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalAceGen.g:3904:3: rule__HttpServerOutcome__Group_2__0
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__HttpServerOutcome__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop54;
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
    // InternalAceGen.g:3913:1: rule__HttpServerOutcome__Group_2__0 : rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1 ;
    public final void rule__HttpServerOutcome__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3917:1: ( rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1 )
            // InternalAceGen.g:3918:2: rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1
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
    // InternalAceGen.g:3925:1: rule__HttpServerOutcome__Group_2__0__Impl : ( '(' ) ;
    public final void rule__HttpServerOutcome__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3929:1: ( ( '(' ) )
            // InternalAceGen.g:3930:1: ( '(' )
            {
            // InternalAceGen.g:3930:1: ( '(' )
            // InternalAceGen.g:3931:2: '('
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,40,FOLLOW_2); 
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
    // InternalAceGen.g:3940:1: rule__HttpServerOutcome__Group_2__1 : rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2 ;
    public final void rule__HttpServerOutcome__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3944:1: ( rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2 )
            // InternalAceGen.g:3945:2: rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2
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
    // InternalAceGen.g:3952:1: rule__HttpServerOutcome__Group_2__1__Impl : ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* ) ;
    public final void rule__HttpServerOutcome__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3956:1: ( ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* ) )
            // InternalAceGen.g:3957:1: ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* )
            {
            // InternalAceGen.g:3957:1: ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* )
            // InternalAceGen.g:3958:2: ( rule__HttpServerOutcome__ListenersAssignment_2_1 )*
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getListenersAssignment_2_1()); 
            // InternalAceGen.g:3959:2: ( rule__HttpServerOutcome__ListenersAssignment_2_1 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_ID) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalAceGen.g:3959:3: rule__HttpServerOutcome__ListenersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerOutcome__ListenersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop55;
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
    // InternalAceGen.g:3967:1: rule__HttpServerOutcome__Group_2__2 : rule__HttpServerOutcome__Group_2__2__Impl ;
    public final void rule__HttpServerOutcome__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3971:1: ( rule__HttpServerOutcome__Group_2__2__Impl )
            // InternalAceGen.g:3972:2: rule__HttpServerOutcome__Group_2__2__Impl
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
    // InternalAceGen.g:3978:1: rule__HttpServerOutcome__Group_2__2__Impl : ( ')' ) ;
    public final void rule__HttpServerOutcome__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3982:1: ( ( ')' ) )
            // InternalAceGen.g:3983:1: ( ')' )
            {
            // InternalAceGen.g:3983:1: ( ')' )
            // InternalAceGen.g:3984:2: ')'
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2()); 
            match(input,41,FOLLOW_2); 
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
    // InternalAceGen.g:3994:1: rule__HttpServerAceRead__Group__0 : rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1 ;
    public final void rule__HttpServerAceRead__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3998:1: ( rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1 )
            // InternalAceGen.g:3999:2: rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1
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
    // InternalAceGen.g:4006:1: rule__HttpServerAceRead__Group__0__Impl : ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? ) ;
    public final void rule__HttpServerAceRead__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4010:1: ( ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? ) )
            // InternalAceGen.g:4011:1: ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? )
            {
            // InternalAceGen.g:4011:1: ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? )
            // InternalAceGen.g:4012:2: ( rule__HttpServerAceRead__ProxyAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyAssignment_0()); 
            // InternalAceGen.g:4013:2: ( rule__HttpServerAceRead__ProxyAssignment_0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==72) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalAceGen.g:4013:3: rule__HttpServerAceRead__ProxyAssignment_0
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
    // InternalAceGen.g:4021:1: rule__HttpServerAceRead__Group__1 : rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2 ;
    public final void rule__HttpServerAceRead__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4025:1: ( rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2 )
            // InternalAceGen.g:4026:2: rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2
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
    // InternalAceGen.g:4033:1: rule__HttpServerAceRead__Group__1__Impl : ( ( rule__HttpServerAceRead__NameAssignment_1 ) ) ;
    public final void rule__HttpServerAceRead__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4037:1: ( ( ( rule__HttpServerAceRead__NameAssignment_1 ) ) )
            // InternalAceGen.g:4038:1: ( ( rule__HttpServerAceRead__NameAssignment_1 ) )
            {
            // InternalAceGen.g:4038:1: ( ( rule__HttpServerAceRead__NameAssignment_1 ) )
            // InternalAceGen.g:4039:2: ( rule__HttpServerAceRead__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getNameAssignment_1()); 
            // InternalAceGen.g:4040:2: ( rule__HttpServerAceRead__NameAssignment_1 )
            // InternalAceGen.g:4040:3: rule__HttpServerAceRead__NameAssignment_1
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
    // InternalAceGen.g:4048:1: rule__HttpServerAceRead__Group__2 : rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3 ;
    public final void rule__HttpServerAceRead__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4052:1: ( rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3 )
            // InternalAceGen.g:4053:2: rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3
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
    // InternalAceGen.g:4060:1: rule__HttpServerAceRead__Group__2__Impl : ( '<' ) ;
    public final void rule__HttpServerAceRead__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4064:1: ( ( '<' ) )
            // InternalAceGen.g:4065:1: ( '<' )
            {
            // InternalAceGen.g:4065:1: ( '<' )
            // InternalAceGen.g:4066:2: '<'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getLessThanSignKeyword_2()); 
            match(input,34,FOLLOW_2); 
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
    // InternalAceGen.g:4075:1: rule__HttpServerAceRead__Group__3 : rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4 ;
    public final void rule__HttpServerAceRead__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4079:1: ( rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4 )
            // InternalAceGen.g:4080:2: rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4
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
    // InternalAceGen.g:4087:1: rule__HttpServerAceRead__Group__3__Impl : ( ( rule__HttpServerAceRead__ModelAssignment_3 ) ) ;
    public final void rule__HttpServerAceRead__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4091:1: ( ( ( rule__HttpServerAceRead__ModelAssignment_3 ) ) )
            // InternalAceGen.g:4092:1: ( ( rule__HttpServerAceRead__ModelAssignment_3 ) )
            {
            // InternalAceGen.g:4092:1: ( ( rule__HttpServerAceRead__ModelAssignment_3 ) )
            // InternalAceGen.g:4093:2: ( rule__HttpServerAceRead__ModelAssignment_3 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getModelAssignment_3()); 
            // InternalAceGen.g:4094:2: ( rule__HttpServerAceRead__ModelAssignment_3 )
            // InternalAceGen.g:4094:3: rule__HttpServerAceRead__ModelAssignment_3
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
    // InternalAceGen.g:4102:1: rule__HttpServerAceRead__Group__4 : rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5 ;
    public final void rule__HttpServerAceRead__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4106:1: ( rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5 )
            // InternalAceGen.g:4107:2: rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5
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
    // InternalAceGen.g:4114:1: rule__HttpServerAceRead__Group__4__Impl : ( '>' ) ;
    public final void rule__HttpServerAceRead__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4118:1: ( ( '>' ) )
            // InternalAceGen.g:4119:1: ( '>' )
            {
            // InternalAceGen.g:4119:1: ( '>' )
            // InternalAceGen.g:4120:2: '>'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGreaterThanSignKeyword_4()); 
            match(input,35,FOLLOW_2); 
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
    // InternalAceGen.g:4129:1: rule__HttpServerAceRead__Group__5 : rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6 ;
    public final void rule__HttpServerAceRead__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4133:1: ( rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6 )
            // InternalAceGen.g:4134:2: rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6
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
    // InternalAceGen.g:4141:1: rule__HttpServerAceRead__Group__5__Impl : ( ( rule__HttpServerAceRead__TypeAssignment_5 ) ) ;
    public final void rule__HttpServerAceRead__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4145:1: ( ( ( rule__HttpServerAceRead__TypeAssignment_5 ) ) )
            // InternalAceGen.g:4146:1: ( ( rule__HttpServerAceRead__TypeAssignment_5 ) )
            {
            // InternalAceGen.g:4146:1: ( ( rule__HttpServerAceRead__TypeAssignment_5 ) )
            // InternalAceGen.g:4147:2: ( rule__HttpServerAceRead__TypeAssignment_5 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getTypeAssignment_5()); 
            // InternalAceGen.g:4148:2: ( rule__HttpServerAceRead__TypeAssignment_5 )
            // InternalAceGen.g:4148:3: rule__HttpServerAceRead__TypeAssignment_5
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
    // InternalAceGen.g:4156:1: rule__HttpServerAceRead__Group__6 : rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7 ;
    public final void rule__HttpServerAceRead__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4160:1: ( rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7 )
            // InternalAceGen.g:4161:2: rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7
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
    // InternalAceGen.g:4168:1: rule__HttpServerAceRead__Group__6__Impl : ( ( rule__HttpServerAceRead__UrlAssignment_6 ) ) ;
    public final void rule__HttpServerAceRead__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4172:1: ( ( ( rule__HttpServerAceRead__UrlAssignment_6 ) ) )
            // InternalAceGen.g:4173:1: ( ( rule__HttpServerAceRead__UrlAssignment_6 ) )
            {
            // InternalAceGen.g:4173:1: ( ( rule__HttpServerAceRead__UrlAssignment_6 ) )
            // InternalAceGen.g:4174:2: ( rule__HttpServerAceRead__UrlAssignment_6 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getUrlAssignment_6()); 
            // InternalAceGen.g:4175:2: ( rule__HttpServerAceRead__UrlAssignment_6 )
            // InternalAceGen.g:4175:3: rule__HttpServerAceRead__UrlAssignment_6
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
    // InternalAceGen.g:4183:1: rule__HttpServerAceRead__Group__7 : rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8 ;
    public final void rule__HttpServerAceRead__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4187:1: ( rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8 )
            // InternalAceGen.g:4188:2: rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8
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
    // InternalAceGen.g:4195:1: rule__HttpServerAceRead__Group__7__Impl : ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? ) ;
    public final void rule__HttpServerAceRead__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4199:1: ( ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? ) )
            // InternalAceGen.g:4200:1: ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? )
            {
            // InternalAceGen.g:4200:1: ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? )
            // InternalAceGen.g:4201:2: ( rule__HttpServerAceRead__AuthorizeAssignment_7 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAssignment_7()); 
            // InternalAceGen.g:4202:2: ( rule__HttpServerAceRead__AuthorizeAssignment_7 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==73) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalAceGen.g:4202:3: rule__HttpServerAceRead__AuthorizeAssignment_7
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
    // InternalAceGen.g:4210:1: rule__HttpServerAceRead__Group__8 : rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9 ;
    public final void rule__HttpServerAceRead__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4214:1: ( rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9 )
            // InternalAceGen.g:4215:2: rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9
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
    // InternalAceGen.g:4222:1: rule__HttpServerAceRead__Group__8__Impl : ( ( rule__HttpServerAceRead__Group_8__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4226:1: ( ( ( rule__HttpServerAceRead__Group_8__0 )? ) )
            // InternalAceGen.g:4227:1: ( ( rule__HttpServerAceRead__Group_8__0 )? )
            {
            // InternalAceGen.g:4227:1: ( ( rule__HttpServerAceRead__Group_8__0 )? )
            // InternalAceGen.g:4228:2: ( rule__HttpServerAceRead__Group_8__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_8()); 
            // InternalAceGen.g:4229:2: ( rule__HttpServerAceRead__Group_8__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==52) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalAceGen.g:4229:3: rule__HttpServerAceRead__Group_8__0
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
    // InternalAceGen.g:4237:1: rule__HttpServerAceRead__Group__9 : rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10 ;
    public final void rule__HttpServerAceRead__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4241:1: ( rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10 )
            // InternalAceGen.g:4242:2: rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10
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
    // InternalAceGen.g:4249:1: rule__HttpServerAceRead__Group__9__Impl : ( ( rule__HttpServerAceRead__Group_9__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4253:1: ( ( ( rule__HttpServerAceRead__Group_9__0 )? ) )
            // InternalAceGen.g:4254:1: ( ( rule__HttpServerAceRead__Group_9__0 )? )
            {
            // InternalAceGen.g:4254:1: ( ( rule__HttpServerAceRead__Group_9__0 )? )
            // InternalAceGen.g:4255:2: ( rule__HttpServerAceRead__Group_9__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_9()); 
            // InternalAceGen.g:4256:2: ( rule__HttpServerAceRead__Group_9__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==53) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalAceGen.g:4256:3: rule__HttpServerAceRead__Group_9__0
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
    // InternalAceGen.g:4264:1: rule__HttpServerAceRead__Group__10 : rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11 ;
    public final void rule__HttpServerAceRead__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4268:1: ( rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11 )
            // InternalAceGen.g:4269:2: rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11
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
    // InternalAceGen.g:4276:1: rule__HttpServerAceRead__Group__10__Impl : ( ( rule__HttpServerAceRead__Group_10__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4280:1: ( ( ( rule__HttpServerAceRead__Group_10__0 )? ) )
            // InternalAceGen.g:4281:1: ( ( rule__HttpServerAceRead__Group_10__0 )? )
            {
            // InternalAceGen.g:4281:1: ( ( rule__HttpServerAceRead__Group_10__0 )? )
            // InternalAceGen.g:4282:2: ( rule__HttpServerAceRead__Group_10__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_10()); 
            // InternalAceGen.g:4283:2: ( rule__HttpServerAceRead__Group_10__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==54) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalAceGen.g:4283:3: rule__HttpServerAceRead__Group_10__0
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
    // InternalAceGen.g:4291:1: rule__HttpServerAceRead__Group__11 : rule__HttpServerAceRead__Group__11__Impl ;
    public final void rule__HttpServerAceRead__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4295:1: ( rule__HttpServerAceRead__Group__11__Impl )
            // InternalAceGen.g:4296:2: rule__HttpServerAceRead__Group__11__Impl
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
    // InternalAceGen.g:4302:1: rule__HttpServerAceRead__Group__11__Impl : ( ( rule__HttpServerAceRead__Group_11__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4306:1: ( ( ( rule__HttpServerAceRead__Group_11__0 )? ) )
            // InternalAceGen.g:4307:1: ( ( rule__HttpServerAceRead__Group_11__0 )? )
            {
            // InternalAceGen.g:4307:1: ( ( rule__HttpServerAceRead__Group_11__0 )? )
            // InternalAceGen.g:4308:2: ( rule__HttpServerAceRead__Group_11__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_11()); 
            // InternalAceGen.g:4309:2: ( rule__HttpServerAceRead__Group_11__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==55) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalAceGen.g:4309:3: rule__HttpServerAceRead__Group_11__0
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
    // InternalAceGen.g:4318:1: rule__HttpServerAceRead__Group_8__0 : rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1 ;
    public final void rule__HttpServerAceRead__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4322:1: ( rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1 )
            // InternalAceGen.g:4323:2: rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1
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
    // InternalAceGen.g:4330:1: rule__HttpServerAceRead__Group_8__0__Impl : ( 'pathParams' ) ;
    public final void rule__HttpServerAceRead__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4334:1: ( ( 'pathParams' ) )
            // InternalAceGen.g:4335:1: ( 'pathParams' )
            {
            // InternalAceGen.g:4335:1: ( 'pathParams' )
            // InternalAceGen.g:4336:2: 'pathParams'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_8_0()); 
            match(input,52,FOLLOW_2); 
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
    // InternalAceGen.g:4345:1: rule__HttpServerAceRead__Group_8__1 : rule__HttpServerAceRead__Group_8__1__Impl ;
    public final void rule__HttpServerAceRead__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4349:1: ( rule__HttpServerAceRead__Group_8__1__Impl )
            // InternalAceGen.g:4350:2: rule__HttpServerAceRead__Group_8__1__Impl
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
    // InternalAceGen.g:4356:1: rule__HttpServerAceRead__Group_8__1__Impl : ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4360:1: ( ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* ) )
            // InternalAceGen.g:4361:1: ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* )
            {
            // InternalAceGen.g:4361:1: ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* )
            // InternalAceGen.g:4362:2: ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsAssignment_8_1()); 
            // InternalAceGen.g:4363:2: ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID) ) {
                    int LA62_2 = input.LA(2);

                    if ( (LA62_2==EOF||LA62_2==RULE_ID||(LA62_2>=49 && LA62_2<=51)||(LA62_2>=53 && LA62_2<=55)||LA62_2==65||LA62_2==72||LA62_2==74) ) {
                        alt62=1;
                    }


                }


                switch (alt62) {
            	case 1 :
            	    // InternalAceGen.g:4363:3: rule__HttpServerAceRead__PathParamsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceRead__PathParamsAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop62;
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
    // InternalAceGen.g:4372:1: rule__HttpServerAceRead__Group_9__0 : rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1 ;
    public final void rule__HttpServerAceRead__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4376:1: ( rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1 )
            // InternalAceGen.g:4377:2: rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1
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
    // InternalAceGen.g:4384:1: rule__HttpServerAceRead__Group_9__0__Impl : ( 'queryParams' ) ;
    public final void rule__HttpServerAceRead__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4388:1: ( ( 'queryParams' ) )
            // InternalAceGen.g:4389:1: ( 'queryParams' )
            {
            // InternalAceGen.g:4389:1: ( 'queryParams' )
            // InternalAceGen.g:4390:2: 'queryParams'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_9_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalAceGen.g:4399:1: rule__HttpServerAceRead__Group_9__1 : rule__HttpServerAceRead__Group_9__1__Impl ;
    public final void rule__HttpServerAceRead__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4403:1: ( rule__HttpServerAceRead__Group_9__1__Impl )
            // InternalAceGen.g:4404:2: rule__HttpServerAceRead__Group_9__1__Impl
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
    // InternalAceGen.g:4410:1: rule__HttpServerAceRead__Group_9__1__Impl : ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4414:1: ( ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* ) )
            // InternalAceGen.g:4415:1: ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* )
            {
            // InternalAceGen.g:4415:1: ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* )
            // InternalAceGen.g:4416:2: ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAssignment_9_1()); 
            // InternalAceGen.g:4417:2: ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ID) ) {
                    int LA63_2 = input.LA(2);

                    if ( (LA63_2==EOF||LA63_2==RULE_ID||(LA63_2>=49 && LA63_2<=51)||(LA63_2>=54 && LA63_2<=55)||LA63_2==65||LA63_2==72||LA63_2==74) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // InternalAceGen.g:4417:3: rule__HttpServerAceRead__QueryParamsAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceRead__QueryParamsAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
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
    // InternalAceGen.g:4426:1: rule__HttpServerAceRead__Group_10__0 : rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1 ;
    public final void rule__HttpServerAceRead__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4430:1: ( rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1 )
            // InternalAceGen.g:4431:2: rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1
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
    // InternalAceGen.g:4438:1: rule__HttpServerAceRead__Group_10__0__Impl : ( 'payload' ) ;
    public final void rule__HttpServerAceRead__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4442:1: ( ( 'payload' ) )
            // InternalAceGen.g:4443:1: ( 'payload' )
            {
            // InternalAceGen.g:4443:1: ( 'payload' )
            // InternalAceGen.g:4444:2: 'payload'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_10_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalAceGen.g:4453:1: rule__HttpServerAceRead__Group_10__1 : rule__HttpServerAceRead__Group_10__1__Impl ;
    public final void rule__HttpServerAceRead__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4457:1: ( rule__HttpServerAceRead__Group_10__1__Impl )
            // InternalAceGen.g:4458:2: rule__HttpServerAceRead__Group_10__1__Impl
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
    // InternalAceGen.g:4464:1: rule__HttpServerAceRead__Group_10__1__Impl : ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4468:1: ( ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* ) )
            // InternalAceGen.g:4469:1: ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* )
            {
            // InternalAceGen.g:4469:1: ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* )
            // InternalAceGen.g:4470:2: ( rule__HttpServerAceRead__PayloadAssignment_10_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadAssignment_10_1()); 
            // InternalAceGen.g:4471:2: ( rule__HttpServerAceRead__PayloadAssignment_10_1 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID) ) {
                    int LA64_2 = input.LA(2);

                    if ( (LA64_2==EOF||LA64_2==RULE_ID||(LA64_2>=49 && LA64_2<=51)||LA64_2==55||LA64_2==65||LA64_2==72||LA64_2==74) ) {
                        alt64=1;
                    }


                }


                switch (alt64) {
            	case 1 :
            	    // InternalAceGen.g:4471:3: rule__HttpServerAceRead__PayloadAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceRead__PayloadAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
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
    // InternalAceGen.g:4480:1: rule__HttpServerAceRead__Group_11__0 : rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1 ;
    public final void rule__HttpServerAceRead__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4484:1: ( rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1 )
            // InternalAceGen.g:4485:2: rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1
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
    // InternalAceGen.g:4492:1: rule__HttpServerAceRead__Group_11__0__Impl : ( 'response' ) ;
    public final void rule__HttpServerAceRead__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4496:1: ( ( 'response' ) )
            // InternalAceGen.g:4497:1: ( 'response' )
            {
            // InternalAceGen.g:4497:1: ( 'response' )
            // InternalAceGen.g:4498:2: 'response'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_11_0()); 
            match(input,55,FOLLOW_2); 
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
    // InternalAceGen.g:4507:1: rule__HttpServerAceRead__Group_11__1 : rule__HttpServerAceRead__Group_11__1__Impl ;
    public final void rule__HttpServerAceRead__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4511:1: ( rule__HttpServerAceRead__Group_11__1__Impl )
            // InternalAceGen.g:4512:2: rule__HttpServerAceRead__Group_11__1__Impl
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
    // InternalAceGen.g:4518:1: rule__HttpServerAceRead__Group_11__1__Impl : ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4522:1: ( ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* ) )
            // InternalAceGen.g:4523:1: ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* )
            {
            // InternalAceGen.g:4523:1: ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* )
            // InternalAceGen.g:4524:2: ( rule__HttpServerAceRead__ResponseAssignment_11_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseAssignment_11_1()); 
            // InternalAceGen.g:4525:2: ( rule__HttpServerAceRead__ResponseAssignment_11_1 )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_ID) ) {
                    int LA65_2 = input.LA(2);

                    if ( (LA65_2==EOF||LA65_2==RULE_ID||(LA65_2>=49 && LA65_2<=51)||LA65_2==65||LA65_2==72) ) {
                        alt65=1;
                    }


                }


                switch (alt65) {
            	case 1 :
            	    // InternalAceGen.g:4525:3: rule__HttpServerAceRead__ResponseAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerAceRead__ResponseAssignment_11_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop65;
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
    // InternalAceGen.g:4534:1: rule__AttributeParamRef__Group__0 : rule__AttributeParamRef__Group__0__Impl rule__AttributeParamRef__Group__1 ;
    public final void rule__AttributeParamRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4538:1: ( rule__AttributeParamRef__Group__0__Impl rule__AttributeParamRef__Group__1 )
            // InternalAceGen.g:4539:2: rule__AttributeParamRef__Group__0__Impl rule__AttributeParamRef__Group__1
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
    // InternalAceGen.g:4546:1: rule__AttributeParamRef__Group__0__Impl : ( ( rule__AttributeParamRef__AttributeAssignment_0 ) ) ;
    public final void rule__AttributeParamRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4550:1: ( ( ( rule__AttributeParamRef__AttributeAssignment_0 ) ) )
            // InternalAceGen.g:4551:1: ( ( rule__AttributeParamRef__AttributeAssignment_0 ) )
            {
            // InternalAceGen.g:4551:1: ( ( rule__AttributeParamRef__AttributeAssignment_0 ) )
            // InternalAceGen.g:4552:2: ( rule__AttributeParamRef__AttributeAssignment_0 )
            {
             before(grammarAccess.getAttributeParamRefAccess().getAttributeAssignment_0()); 
            // InternalAceGen.g:4553:2: ( rule__AttributeParamRef__AttributeAssignment_0 )
            // InternalAceGen.g:4553:3: rule__AttributeParamRef__AttributeAssignment_0
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
    // InternalAceGen.g:4561:1: rule__AttributeParamRef__Group__1 : rule__AttributeParamRef__Group__1__Impl ;
    public final void rule__AttributeParamRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4565:1: ( rule__AttributeParamRef__Group__1__Impl )
            // InternalAceGen.g:4566:2: rule__AttributeParamRef__Group__1__Impl
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
    // InternalAceGen.g:4572:1: rule__AttributeParamRef__Group__1__Impl : ( ( rule__AttributeParamRef__OptionalAssignment_1 )? ) ;
    public final void rule__AttributeParamRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4576:1: ( ( ( rule__AttributeParamRef__OptionalAssignment_1 )? ) )
            // InternalAceGen.g:4577:1: ( ( rule__AttributeParamRef__OptionalAssignment_1 )? )
            {
            // InternalAceGen.g:4577:1: ( ( rule__AttributeParamRef__OptionalAssignment_1 )? )
            // InternalAceGen.g:4578:2: ( rule__AttributeParamRef__OptionalAssignment_1 )?
            {
             before(grammarAccess.getAttributeParamRefAccess().getOptionalAssignment_1()); 
            // InternalAceGen.g:4579:2: ( rule__AttributeParamRef__OptionalAssignment_1 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==74) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalAceGen.g:4579:3: rule__AttributeParamRef__OptionalAssignment_1
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
    // InternalAceGen.g:4588:1: rule__HttpServerView__Group__0 : rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1 ;
    public final void rule__HttpServerView__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4592:1: ( rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1 )
            // InternalAceGen.g:4593:2: rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1
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
    // InternalAceGen.g:4600:1: rule__HttpServerView__Group__0__Impl : ( ( rule__HttpServerView__NameAssignment_0 ) ) ;
    public final void rule__HttpServerView__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4604:1: ( ( ( rule__HttpServerView__NameAssignment_0 ) ) )
            // InternalAceGen.g:4605:1: ( ( rule__HttpServerView__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4605:1: ( ( rule__HttpServerView__NameAssignment_0 ) )
            // InternalAceGen.g:4606:2: ( rule__HttpServerView__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerViewAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4607:2: ( rule__HttpServerView__NameAssignment_0 )
            // InternalAceGen.g:4607:3: rule__HttpServerView__NameAssignment_0
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
    // InternalAceGen.g:4615:1: rule__HttpServerView__Group__1 : rule__HttpServerView__Group__1__Impl ;
    public final void rule__HttpServerView__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4619:1: ( rule__HttpServerView__Group__1__Impl )
            // InternalAceGen.g:4620:2: rule__HttpServerView__Group__1__Impl
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
    // InternalAceGen.g:4626:1: rule__HttpServerView__Group__1__Impl : ( ( rule__HttpServerView__Group_1__0 )? ) ;
    public final void rule__HttpServerView__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4630:1: ( ( ( rule__HttpServerView__Group_1__0 )? ) )
            // InternalAceGen.g:4631:1: ( ( rule__HttpServerView__Group_1__0 )? )
            {
            // InternalAceGen.g:4631:1: ( ( rule__HttpServerView__Group_1__0 )? )
            // InternalAceGen.g:4632:2: ( rule__HttpServerView__Group_1__0 )?
            {
             before(grammarAccess.getHttpServerViewAccess().getGroup_1()); 
            // InternalAceGen.g:4633:2: ( rule__HttpServerView__Group_1__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==45) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalAceGen.g:4633:3: rule__HttpServerView__Group_1__0
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
    // InternalAceGen.g:4642:1: rule__HttpServerView__Group_1__0 : rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1 ;
    public final void rule__HttpServerView__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4646:1: ( rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1 )
            // InternalAceGen.g:4647:2: rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1
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
    // InternalAceGen.g:4654:1: rule__HttpServerView__Group_1__0__Impl : ( '{' ) ;
    public final void rule__HttpServerView__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4658:1: ( ( '{' ) )
            // InternalAceGen.g:4659:1: ( '{' )
            {
            // InternalAceGen.g:4659:1: ( '{' )
            // InternalAceGen.g:4660:2: '{'
            {
             before(grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalAceGen.g:4669:1: rule__HttpServerView__Group_1__1 : rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2 ;
    public final void rule__HttpServerView__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4673:1: ( rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2 )
            // InternalAceGen.g:4674:2: rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2
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
    // InternalAceGen.g:4681:1: rule__HttpServerView__Group_1__1__Impl : ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* ) ;
    public final void rule__HttpServerView__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4685:1: ( ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* ) )
            // InternalAceGen.g:4686:1: ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* )
            {
            // InternalAceGen.g:4686:1: ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* )
            // InternalAceGen.g:4687:2: ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )*
            {
             before(grammarAccess.getHttpServerViewAccess().getRenderFunctionsAssignment_1_1()); 
            // InternalAceGen.g:4688:2: ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==RULE_ID) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalAceGen.g:4688:3: rule__HttpServerView__RenderFunctionsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpServerView__RenderFunctionsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop68;
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
    // InternalAceGen.g:4696:1: rule__HttpServerView__Group_1__2 : rule__HttpServerView__Group_1__2__Impl ;
    public final void rule__HttpServerView__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4700:1: ( rule__HttpServerView__Group_1__2__Impl )
            // InternalAceGen.g:4701:2: rule__HttpServerView__Group_1__2__Impl
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
    // InternalAceGen.g:4707:1: rule__HttpServerView__Group_1__2__Impl : ( '}' ) ;
    public final void rule__HttpServerView__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4711:1: ( ( '}' ) )
            // InternalAceGen.g:4712:1: ( '}' )
            {
            // InternalAceGen.g:4712:1: ( '}' )
            // InternalAceGen.g:4713:2: '}'
            {
             before(grammarAccess.getHttpServerViewAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,46,FOLLOW_2); 
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
    // InternalAceGen.g:4723:1: rule__HttpServerViewFunction__Group__0 : rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1 ;
    public final void rule__HttpServerViewFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4727:1: ( rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1 )
            // InternalAceGen.g:4728:2: rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1
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
    // InternalAceGen.g:4735:1: rule__HttpServerViewFunction__Group__0__Impl : ( ( rule__HttpServerViewFunction__NameAssignment_0 ) ) ;
    public final void rule__HttpServerViewFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4739:1: ( ( ( rule__HttpServerViewFunction__NameAssignment_0 ) ) )
            // InternalAceGen.g:4740:1: ( ( rule__HttpServerViewFunction__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4740:1: ( ( rule__HttpServerViewFunction__NameAssignment_0 ) )
            // InternalAceGen.g:4741:2: ( rule__HttpServerViewFunction__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4742:2: ( rule__HttpServerViewFunction__NameAssignment_0 )
            // InternalAceGen.g:4742:3: rule__HttpServerViewFunction__NameAssignment_0
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
    // InternalAceGen.g:4750:1: rule__HttpServerViewFunction__Group__1 : rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2 ;
    public final void rule__HttpServerViewFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4754:1: ( rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2 )
            // InternalAceGen.g:4755:2: rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2
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
    // InternalAceGen.g:4762:1: rule__HttpServerViewFunction__Group__1__Impl : ( '(' ) ;
    public final void rule__HttpServerViewFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4766:1: ( ( '(' ) )
            // InternalAceGen.g:4767:1: ( '(' )
            {
            // InternalAceGen.g:4767:1: ( '(' )
            // InternalAceGen.g:4768:2: '('
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getLeftParenthesisKeyword_1()); 
            match(input,40,FOLLOW_2); 
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
    // InternalAceGen.g:4777:1: rule__HttpServerViewFunction__Group__2 : rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3 ;
    public final void rule__HttpServerViewFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4781:1: ( rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3 )
            // InternalAceGen.g:4782:2: rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3
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
    // InternalAceGen.g:4789:1: rule__HttpServerViewFunction__Group__2__Impl : ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) ) ;
    public final void rule__HttpServerViewFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4793:1: ( ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) ) )
            // InternalAceGen.g:4794:1: ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) )
            {
            // InternalAceGen.g:4794:1: ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) )
            // InternalAceGen.g:4795:2: ( rule__HttpServerViewFunction__ModelAssignment_2 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getModelAssignment_2()); 
            // InternalAceGen.g:4796:2: ( rule__HttpServerViewFunction__ModelAssignment_2 )
            // InternalAceGen.g:4796:3: rule__HttpServerViewFunction__ModelAssignment_2
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
    // InternalAceGen.g:4804:1: rule__HttpServerViewFunction__Group__3 : rule__HttpServerViewFunction__Group__3__Impl ;
    public final void rule__HttpServerViewFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4808:1: ( rule__HttpServerViewFunction__Group__3__Impl )
            // InternalAceGen.g:4809:2: rule__HttpServerViewFunction__Group__3__Impl
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
    // InternalAceGen.g:4815:1: rule__HttpServerViewFunction__Group__3__Impl : ( ')' ) ;
    public final void rule__HttpServerViewFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4819:1: ( ( ')' ) )
            // InternalAceGen.g:4820:1: ( ')' )
            {
            // InternalAceGen.g:4820:1: ( ')' )
            // InternalAceGen.g:4821:2: ')'
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getRightParenthesisKeyword_3()); 
            match(input,41,FOLLOW_2); 
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
    // InternalAceGen.g:4831:1: rule__AuthUser__Group__0 : rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1 ;
    public final void rule__AuthUser__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4835:1: ( rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1 )
            // InternalAceGen.g:4836:2: rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1
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
    // InternalAceGen.g:4843:1: rule__AuthUser__Group__0__Impl : ( ( rule__AuthUser__NameAssignment_0 ) ) ;
    public final void rule__AuthUser__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4847:1: ( ( ( rule__AuthUser__NameAssignment_0 ) ) )
            // InternalAceGen.g:4848:1: ( ( rule__AuthUser__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4848:1: ( ( rule__AuthUser__NameAssignment_0 ) )
            // InternalAceGen.g:4849:2: ( rule__AuthUser__NameAssignment_0 )
            {
             before(grammarAccess.getAuthUserAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4850:2: ( rule__AuthUser__NameAssignment_0 )
            // InternalAceGen.g:4850:3: rule__AuthUser__NameAssignment_0
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
    // InternalAceGen.g:4858:1: rule__AuthUser__Group__1 : rule__AuthUser__Group__1__Impl ;
    public final void rule__AuthUser__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4862:1: ( rule__AuthUser__Group__1__Impl )
            // InternalAceGen.g:4863:2: rule__AuthUser__Group__1__Impl
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
    // InternalAceGen.g:4869:1: rule__AuthUser__Group__1__Impl : ( ( rule__AuthUser__Group_1__0 ) ) ;
    public final void rule__AuthUser__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4873:1: ( ( ( rule__AuthUser__Group_1__0 ) ) )
            // InternalAceGen.g:4874:1: ( ( rule__AuthUser__Group_1__0 ) )
            {
            // InternalAceGen.g:4874:1: ( ( rule__AuthUser__Group_1__0 ) )
            // InternalAceGen.g:4875:2: ( rule__AuthUser__Group_1__0 )
            {
             before(grammarAccess.getAuthUserAccess().getGroup_1()); 
            // InternalAceGen.g:4876:2: ( rule__AuthUser__Group_1__0 )
            // InternalAceGen.g:4876:3: rule__AuthUser__Group_1__0
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
    // InternalAceGen.g:4885:1: rule__AuthUser__Group_1__0 : rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1 ;
    public final void rule__AuthUser__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4889:1: ( rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1 )
            // InternalAceGen.g:4890:2: rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1
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
    // InternalAceGen.g:4897:1: rule__AuthUser__Group_1__0__Impl : ( '{' ) ;
    public final void rule__AuthUser__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4901:1: ( ( '{' ) )
            // InternalAceGen.g:4902:1: ( '{' )
            {
            // InternalAceGen.g:4902:1: ( '{' )
            // InternalAceGen.g:4903:2: '{'
            {
             before(grammarAccess.getAuthUserAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalAceGen.g:4912:1: rule__AuthUser__Group_1__1 : rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2 ;
    public final void rule__AuthUser__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4916:1: ( rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2 )
            // InternalAceGen.g:4917:2: rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2
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
    // InternalAceGen.g:4924:1: rule__AuthUser__Group_1__1__Impl : ( ( rule__AuthUser__AttributesAssignment_1_1 )* ) ;
    public final void rule__AuthUser__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4928:1: ( ( ( rule__AuthUser__AttributesAssignment_1_1 )* ) )
            // InternalAceGen.g:4929:1: ( ( rule__AuthUser__AttributesAssignment_1_1 )* )
            {
            // InternalAceGen.g:4929:1: ( ( rule__AuthUser__AttributesAssignment_1_1 )* )
            // InternalAceGen.g:4930:2: ( rule__AuthUser__AttributesAssignment_1_1 )*
            {
             before(grammarAccess.getAuthUserAccess().getAttributesAssignment_1_1()); 
            // InternalAceGen.g:4931:2: ( rule__AuthUser__AttributesAssignment_1_1 )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==RULE_ID||(LA69_0>=22 && LA69_0<=27)||(LA69_0>=77 && LA69_0<=80)) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalAceGen.g:4931:3: rule__AuthUser__AttributesAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_41);
            	    rule__AuthUser__AttributesAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop69;
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
    // InternalAceGen.g:4939:1: rule__AuthUser__Group_1__2 : rule__AuthUser__Group_1__2__Impl ;
    public final void rule__AuthUser__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4943:1: ( rule__AuthUser__Group_1__2__Impl )
            // InternalAceGen.g:4944:2: rule__AuthUser__Group_1__2__Impl
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
    // InternalAceGen.g:4950:1: rule__AuthUser__Group_1__2__Impl : ( '}' ) ;
    public final void rule__AuthUser__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4954:1: ( ( '}' ) )
            // InternalAceGen.g:4955:1: ( '}' )
            {
            // InternalAceGen.g:4955:1: ( '}' )
            // InternalAceGen.g:4956:2: '}'
            {
             before(grammarAccess.getAuthUserAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,46,FOLLOW_2); 
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
    // InternalAceGen.g:4966:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4970:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalAceGen.g:4971:2: rule__Model__Group__0__Impl rule__Model__Group__1
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
    // InternalAceGen.g:4978:1: rule__Model__Group__0__Impl : ( ( rule__Model__PersistentAssignment_0 )? ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4982:1: ( ( ( rule__Model__PersistentAssignment_0 )? ) )
            // InternalAceGen.g:4983:1: ( ( rule__Model__PersistentAssignment_0 )? )
            {
            // InternalAceGen.g:4983:1: ( ( rule__Model__PersistentAssignment_0 )? )
            // InternalAceGen.g:4984:2: ( rule__Model__PersistentAssignment_0 )?
            {
             before(grammarAccess.getModelAccess().getPersistentAssignment_0()); 
            // InternalAceGen.g:4985:2: ( rule__Model__PersistentAssignment_0 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==75) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalAceGen.g:4985:3: rule__Model__PersistentAssignment_0
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
    // InternalAceGen.g:4993:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4997:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalAceGen.g:4998:2: rule__Model__Group__1__Impl rule__Model__Group__2
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
    // InternalAceGen.g:5005:1: rule__Model__Group__1__Impl : ( ( rule__Model__NameAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5009:1: ( ( ( rule__Model__NameAssignment_1 ) ) )
            // InternalAceGen.g:5010:1: ( ( rule__Model__NameAssignment_1 ) )
            {
            // InternalAceGen.g:5010:1: ( ( rule__Model__NameAssignment_1 ) )
            // InternalAceGen.g:5011:2: ( rule__Model__NameAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1()); 
            // InternalAceGen.g:5012:2: ( rule__Model__NameAssignment_1 )
            // InternalAceGen.g:5012:3: rule__Model__NameAssignment_1
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
    // InternalAceGen.g:5020:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5024:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalAceGen.g:5025:2: rule__Model__Group__2__Impl rule__Model__Group__3
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
    // InternalAceGen.g:5032:1: rule__Model__Group__2__Impl : ( ( rule__Model__Group_2__0 )? ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5036:1: ( ( ( rule__Model__Group_2__0 )? ) )
            // InternalAceGen.g:5037:1: ( ( rule__Model__Group_2__0 )? )
            {
            // InternalAceGen.g:5037:1: ( ( rule__Model__Group_2__0 )? )
            // InternalAceGen.g:5038:2: ( rule__Model__Group_2__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalAceGen.g:5039:2: ( rule__Model__Group_2__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==56) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalAceGen.g:5039:3: rule__Model__Group_2__0
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
    // InternalAceGen.g:5047:1: rule__Model__Group__3 : rule__Model__Group__3__Impl ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5051:1: ( rule__Model__Group__3__Impl )
            // InternalAceGen.g:5052:2: rule__Model__Group__3__Impl
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
    // InternalAceGen.g:5058:1: rule__Model__Group__3__Impl : ( ( rule__Model__Group_3__0 )? ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5062:1: ( ( ( rule__Model__Group_3__0 )? ) )
            // InternalAceGen.g:5063:1: ( ( rule__Model__Group_3__0 )? )
            {
            // InternalAceGen.g:5063:1: ( ( rule__Model__Group_3__0 )? )
            // InternalAceGen.g:5064:2: ( rule__Model__Group_3__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_3()); 
            // InternalAceGen.g:5065:2: ( rule__Model__Group_3__0 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==45) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalAceGen.g:5065:3: rule__Model__Group_3__0
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
    // InternalAceGen.g:5074:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5078:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalAceGen.g:5079:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
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
    // InternalAceGen.g:5086:1: rule__Model__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5090:1: ( ( 'extends' ) )
            // InternalAceGen.g:5091:1: ( 'extends' )
            {
            // InternalAceGen.g:5091:1: ( 'extends' )
            // InternalAceGen.g:5092:2: 'extends'
            {
             before(grammarAccess.getModelAccess().getExtendsKeyword_2_0()); 
            match(input,56,FOLLOW_2); 
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
    // InternalAceGen.g:5101:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl rule__Model__Group_2__2 ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5105:1: ( rule__Model__Group_2__1__Impl rule__Model__Group_2__2 )
            // InternalAceGen.g:5106:2: rule__Model__Group_2__1__Impl rule__Model__Group_2__2
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
    // InternalAceGen.g:5113:1: rule__Model__Group_2__1__Impl : ( ( rule__Model__SuperModelsAssignment_2_1 ) ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5117:1: ( ( ( rule__Model__SuperModelsAssignment_2_1 ) ) )
            // InternalAceGen.g:5118:1: ( ( rule__Model__SuperModelsAssignment_2_1 ) )
            {
            // InternalAceGen.g:5118:1: ( ( rule__Model__SuperModelsAssignment_2_1 ) )
            // InternalAceGen.g:5119:2: ( rule__Model__SuperModelsAssignment_2_1 )
            {
             before(grammarAccess.getModelAccess().getSuperModelsAssignment_2_1()); 
            // InternalAceGen.g:5120:2: ( rule__Model__SuperModelsAssignment_2_1 )
            // InternalAceGen.g:5120:3: rule__Model__SuperModelsAssignment_2_1
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
    // InternalAceGen.g:5128:1: rule__Model__Group_2__2 : rule__Model__Group_2__2__Impl ;
    public final void rule__Model__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5132:1: ( rule__Model__Group_2__2__Impl )
            // InternalAceGen.g:5133:2: rule__Model__Group_2__2__Impl
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
    // InternalAceGen.g:5139:1: rule__Model__Group_2__2__Impl : ( ( rule__Model__Group_2_2__0 )* ) ;
    public final void rule__Model__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5143:1: ( ( ( rule__Model__Group_2_2__0 )* ) )
            // InternalAceGen.g:5144:1: ( ( rule__Model__Group_2_2__0 )* )
            {
            // InternalAceGen.g:5144:1: ( ( rule__Model__Group_2_2__0 )* )
            // InternalAceGen.g:5145:2: ( rule__Model__Group_2_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_2_2()); 
            // InternalAceGen.g:5146:2: ( rule__Model__Group_2_2__0 )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==36) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalAceGen.g:5146:3: rule__Model__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Model__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop73;
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
    // InternalAceGen.g:5155:1: rule__Model__Group_2_2__0 : rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1 ;
    public final void rule__Model__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5159:1: ( rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1 )
            // InternalAceGen.g:5160:2: rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1
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
    // InternalAceGen.g:5167:1: rule__Model__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Model__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5171:1: ( ( ',' ) )
            // InternalAceGen.g:5172:1: ( ',' )
            {
            // InternalAceGen.g:5172:1: ( ',' )
            // InternalAceGen.g:5173:2: ','
            {
             before(grammarAccess.getModelAccess().getCommaKeyword_2_2_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalAceGen.g:5182:1: rule__Model__Group_2_2__1 : rule__Model__Group_2_2__1__Impl ;
    public final void rule__Model__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5186:1: ( rule__Model__Group_2_2__1__Impl )
            // InternalAceGen.g:5187:2: rule__Model__Group_2_2__1__Impl
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
    // InternalAceGen.g:5193:1: rule__Model__Group_2_2__1__Impl : ( ( rule__Model__SuperModelsAssignment_2_2_1 ) ) ;
    public final void rule__Model__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5197:1: ( ( ( rule__Model__SuperModelsAssignment_2_2_1 ) ) )
            // InternalAceGen.g:5198:1: ( ( rule__Model__SuperModelsAssignment_2_2_1 ) )
            {
            // InternalAceGen.g:5198:1: ( ( rule__Model__SuperModelsAssignment_2_2_1 ) )
            // InternalAceGen.g:5199:2: ( rule__Model__SuperModelsAssignment_2_2_1 )
            {
             before(grammarAccess.getModelAccess().getSuperModelsAssignment_2_2_1()); 
            // InternalAceGen.g:5200:2: ( rule__Model__SuperModelsAssignment_2_2_1 )
            // InternalAceGen.g:5200:3: rule__Model__SuperModelsAssignment_2_2_1
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
    // InternalAceGen.g:5209:1: rule__Model__Group_3__0 : rule__Model__Group_3__0__Impl rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5213:1: ( rule__Model__Group_3__0__Impl rule__Model__Group_3__1 )
            // InternalAceGen.g:5214:2: rule__Model__Group_3__0__Impl rule__Model__Group_3__1
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
    // InternalAceGen.g:5221:1: rule__Model__Group_3__0__Impl : ( '{' ) ;
    public final void rule__Model__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5225:1: ( ( '{' ) )
            // InternalAceGen.g:5226:1: ( '{' )
            {
            // InternalAceGen.g:5226:1: ( '{' )
            // InternalAceGen.g:5227:2: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalAceGen.g:5236:1: rule__Model__Group_3__1 : rule__Model__Group_3__1__Impl rule__Model__Group_3__2 ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5240:1: ( rule__Model__Group_3__1__Impl rule__Model__Group_3__2 )
            // InternalAceGen.g:5241:2: rule__Model__Group_3__1__Impl rule__Model__Group_3__2
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
    // InternalAceGen.g:5248:1: rule__Model__Group_3__1__Impl : ( ( rule__Model__AttributesAssignment_3_1 )* ) ;
    public final void rule__Model__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5252:1: ( ( ( rule__Model__AttributesAssignment_3_1 )* ) )
            // InternalAceGen.g:5253:1: ( ( rule__Model__AttributesAssignment_3_1 )* )
            {
            // InternalAceGen.g:5253:1: ( ( rule__Model__AttributesAssignment_3_1 )* )
            // InternalAceGen.g:5254:2: ( rule__Model__AttributesAssignment_3_1 )*
            {
             before(grammarAccess.getModelAccess().getAttributesAssignment_3_1()); 
            // InternalAceGen.g:5255:2: ( rule__Model__AttributesAssignment_3_1 )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==RULE_ID||(LA74_0>=22 && LA74_0<=27)||(LA74_0>=77 && LA74_0<=80)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalAceGen.g:5255:3: rule__Model__AttributesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_41);
            	    rule__Model__AttributesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop74;
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
    // InternalAceGen.g:5263:1: rule__Model__Group_3__2 : rule__Model__Group_3__2__Impl ;
    public final void rule__Model__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5267:1: ( rule__Model__Group_3__2__Impl )
            // InternalAceGen.g:5268:2: rule__Model__Group_3__2__Impl
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
    // InternalAceGen.g:5274:1: rule__Model__Group_3__2__Impl : ( '}' ) ;
    public final void rule__Model__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5278:1: ( ( '}' ) )
            // InternalAceGen.g:5279:1: ( '}' )
            {
            // InternalAceGen.g:5279:1: ( '}' )
            // InternalAceGen.g:5280:2: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_3_2()); 
            match(input,46,FOLLOW_2); 
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
    // InternalAceGen.g:5290:1: rule__Scenario__Group__0 : rule__Scenario__Group__0__Impl rule__Scenario__Group__1 ;
    public final void rule__Scenario__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5294:1: ( rule__Scenario__Group__0__Impl rule__Scenario__Group__1 )
            // InternalAceGen.g:5295:2: rule__Scenario__Group__0__Impl rule__Scenario__Group__1
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
    // InternalAceGen.g:5302:1: rule__Scenario__Group__0__Impl : ( ( rule__Scenario__NameAssignment_0 ) ) ;
    public final void rule__Scenario__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5306:1: ( ( ( rule__Scenario__NameAssignment_0 ) ) )
            // InternalAceGen.g:5307:1: ( ( rule__Scenario__NameAssignment_0 ) )
            {
            // InternalAceGen.g:5307:1: ( ( rule__Scenario__NameAssignment_0 ) )
            // InternalAceGen.g:5308:2: ( rule__Scenario__NameAssignment_0 )
            {
             before(grammarAccess.getScenarioAccess().getNameAssignment_0()); 
            // InternalAceGen.g:5309:2: ( rule__Scenario__NameAssignment_0 )
            // InternalAceGen.g:5309:3: rule__Scenario__NameAssignment_0
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
    // InternalAceGen.g:5317:1: rule__Scenario__Group__1 : rule__Scenario__Group__1__Impl rule__Scenario__Group__2 ;
    public final void rule__Scenario__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5321:1: ( rule__Scenario__Group__1__Impl rule__Scenario__Group__2 )
            // InternalAceGen.g:5322:2: rule__Scenario__Group__1__Impl rule__Scenario__Group__2
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
    // InternalAceGen.g:5329:1: rule__Scenario__Group__1__Impl : ( ( rule__Scenario__Group_1__0 )? ) ;
    public final void rule__Scenario__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5333:1: ( ( ( rule__Scenario__Group_1__0 )? ) )
            // InternalAceGen.g:5334:1: ( ( rule__Scenario__Group_1__0 )? )
            {
            // InternalAceGen.g:5334:1: ( ( rule__Scenario__Group_1__0 )? )
            // InternalAceGen.g:5335:2: ( rule__Scenario__Group_1__0 )?
            {
             before(grammarAccess.getScenarioAccess().getGroup_1()); 
            // InternalAceGen.g:5336:2: ( rule__Scenario__Group_1__0 )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==59) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalAceGen.g:5336:3: rule__Scenario__Group_1__0
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
    // InternalAceGen.g:5344:1: rule__Scenario__Group__2 : rule__Scenario__Group__2__Impl rule__Scenario__Group__3 ;
    public final void rule__Scenario__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5348:1: ( rule__Scenario__Group__2__Impl rule__Scenario__Group__3 )
            // InternalAceGen.g:5349:2: rule__Scenario__Group__2__Impl rule__Scenario__Group__3
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
    // InternalAceGen.g:5356:1: rule__Scenario__Group__2__Impl : ( 'WHEN' ) ;
    public final void rule__Scenario__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5360:1: ( ( 'WHEN' ) )
            // InternalAceGen.g:5361:1: ( 'WHEN' )
            {
            // InternalAceGen.g:5361:1: ( 'WHEN' )
            // InternalAceGen.g:5362:2: 'WHEN'
            {
             before(grammarAccess.getScenarioAccess().getWHENKeyword_2()); 
            match(input,57,FOLLOW_2); 
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
    // InternalAceGen.g:5371:1: rule__Scenario__Group__3 : rule__Scenario__Group__3__Impl rule__Scenario__Group__4 ;
    public final void rule__Scenario__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5375:1: ( rule__Scenario__Group__3__Impl rule__Scenario__Group__4 )
            // InternalAceGen.g:5376:2: rule__Scenario__Group__3__Impl rule__Scenario__Group__4
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
    // InternalAceGen.g:5383:1: rule__Scenario__Group__3__Impl : ( ( rule__Scenario__WhenBlockAssignment_3 ) ) ;
    public final void rule__Scenario__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5387:1: ( ( ( rule__Scenario__WhenBlockAssignment_3 ) ) )
            // InternalAceGen.g:5388:1: ( ( rule__Scenario__WhenBlockAssignment_3 ) )
            {
            // InternalAceGen.g:5388:1: ( ( rule__Scenario__WhenBlockAssignment_3 ) )
            // InternalAceGen.g:5389:2: ( rule__Scenario__WhenBlockAssignment_3 )
            {
             before(grammarAccess.getScenarioAccess().getWhenBlockAssignment_3()); 
            // InternalAceGen.g:5390:2: ( rule__Scenario__WhenBlockAssignment_3 )
            // InternalAceGen.g:5390:3: rule__Scenario__WhenBlockAssignment_3
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
    // InternalAceGen.g:5398:1: rule__Scenario__Group__4 : rule__Scenario__Group__4__Impl rule__Scenario__Group__5 ;
    public final void rule__Scenario__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5402:1: ( rule__Scenario__Group__4__Impl rule__Scenario__Group__5 )
            // InternalAceGen.g:5403:2: rule__Scenario__Group__4__Impl rule__Scenario__Group__5
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
    // InternalAceGen.g:5410:1: rule__Scenario__Group__4__Impl : ( 'THEN' ) ;
    public final void rule__Scenario__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5414:1: ( ( 'THEN' ) )
            // InternalAceGen.g:5415:1: ( 'THEN' )
            {
            // InternalAceGen.g:5415:1: ( 'THEN' )
            // InternalAceGen.g:5416:2: 'THEN'
            {
             before(grammarAccess.getScenarioAccess().getTHENKeyword_4()); 
            match(input,58,FOLLOW_2); 
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
    // InternalAceGen.g:5425:1: rule__Scenario__Group__5 : rule__Scenario__Group__5__Impl ;
    public final void rule__Scenario__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5429:1: ( rule__Scenario__Group__5__Impl )
            // InternalAceGen.g:5430:2: rule__Scenario__Group__5__Impl
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
    // InternalAceGen.g:5436:1: rule__Scenario__Group__5__Impl : ( ( rule__Scenario__ThenBlockAssignment_5 ) ) ;
    public final void rule__Scenario__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5440:1: ( ( ( rule__Scenario__ThenBlockAssignment_5 ) ) )
            // InternalAceGen.g:5441:1: ( ( rule__Scenario__ThenBlockAssignment_5 ) )
            {
            // InternalAceGen.g:5441:1: ( ( rule__Scenario__ThenBlockAssignment_5 ) )
            // InternalAceGen.g:5442:2: ( rule__Scenario__ThenBlockAssignment_5 )
            {
             before(grammarAccess.getScenarioAccess().getThenBlockAssignment_5()); 
            // InternalAceGen.g:5443:2: ( rule__Scenario__ThenBlockAssignment_5 )
            // InternalAceGen.g:5443:3: rule__Scenario__ThenBlockAssignment_5
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
    // InternalAceGen.g:5452:1: rule__Scenario__Group_1__0 : rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1 ;
    public final void rule__Scenario__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5456:1: ( rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1 )
            // InternalAceGen.g:5457:2: rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1
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
    // InternalAceGen.g:5464:1: rule__Scenario__Group_1__0__Impl : ( 'GIVEN' ) ;
    public final void rule__Scenario__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5468:1: ( ( 'GIVEN' ) )
            // InternalAceGen.g:5469:1: ( 'GIVEN' )
            {
            // InternalAceGen.g:5469:1: ( 'GIVEN' )
            // InternalAceGen.g:5470:2: 'GIVEN'
            {
             before(grammarAccess.getScenarioAccess().getGIVENKeyword_1_0()); 
            match(input,59,FOLLOW_2); 
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
    // InternalAceGen.g:5479:1: rule__Scenario__Group_1__1 : rule__Scenario__Group_1__1__Impl ;
    public final void rule__Scenario__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5483:1: ( rule__Scenario__Group_1__1__Impl )
            // InternalAceGen.g:5484:2: rule__Scenario__Group_1__1__Impl
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
    // InternalAceGen.g:5490:1: rule__Scenario__Group_1__1__Impl : ( ( rule__Scenario__GivenRefsAssignment_1_1 )* ) ;
    public final void rule__Scenario__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5494:1: ( ( ( rule__Scenario__GivenRefsAssignment_1_1 )* ) )
            // InternalAceGen.g:5495:1: ( ( rule__Scenario__GivenRefsAssignment_1_1 )* )
            {
            // InternalAceGen.g:5495:1: ( ( rule__Scenario__GivenRefsAssignment_1_1 )* )
            // InternalAceGen.g:5496:2: ( rule__Scenario__GivenRefsAssignment_1_1 )*
            {
             before(grammarAccess.getScenarioAccess().getGivenRefsAssignment_1_1()); 
            // InternalAceGen.g:5497:2: ( rule__Scenario__GivenRefsAssignment_1_1 )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_ID) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalAceGen.g:5497:3: rule__Scenario__GivenRefsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Scenario__GivenRefsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop76;
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
    // InternalAceGen.g:5506:1: rule__GivenRef__Group__0 : rule__GivenRef__Group__0__Impl rule__GivenRef__Group__1 ;
    public final void rule__GivenRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5510:1: ( rule__GivenRef__Group__0__Impl rule__GivenRef__Group__1 )
            // InternalAceGen.g:5511:2: rule__GivenRef__Group__0__Impl rule__GivenRef__Group__1
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
    // InternalAceGen.g:5518:1: rule__GivenRef__Group__0__Impl : ( ( rule__GivenRef__ScenarioAssignment_0 ) ) ;
    public final void rule__GivenRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5522:1: ( ( ( rule__GivenRef__ScenarioAssignment_0 ) ) )
            // InternalAceGen.g:5523:1: ( ( rule__GivenRef__ScenarioAssignment_0 ) )
            {
            // InternalAceGen.g:5523:1: ( ( rule__GivenRef__ScenarioAssignment_0 ) )
            // InternalAceGen.g:5524:2: ( rule__GivenRef__ScenarioAssignment_0 )
            {
             before(grammarAccess.getGivenRefAccess().getScenarioAssignment_0()); 
            // InternalAceGen.g:5525:2: ( rule__GivenRef__ScenarioAssignment_0 )
            // InternalAceGen.g:5525:3: rule__GivenRef__ScenarioAssignment_0
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
    // InternalAceGen.g:5533:1: rule__GivenRef__Group__1 : rule__GivenRef__Group__1__Impl rule__GivenRef__Group__2 ;
    public final void rule__GivenRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5537:1: ( rule__GivenRef__Group__1__Impl rule__GivenRef__Group__2 )
            // InternalAceGen.g:5538:2: rule__GivenRef__Group__1__Impl rule__GivenRef__Group__2
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
    // InternalAceGen.g:5545:1: rule__GivenRef__Group__1__Impl : ( ( rule__GivenRef__Group_1__0 )? ) ;
    public final void rule__GivenRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5549:1: ( ( ( rule__GivenRef__Group_1__0 )? ) )
            // InternalAceGen.g:5550:1: ( ( rule__GivenRef__Group_1__0 )? )
            {
            // InternalAceGen.g:5550:1: ( ( rule__GivenRef__Group_1__0 )? )
            // InternalAceGen.g:5551:2: ( rule__GivenRef__Group_1__0 )?
            {
             before(grammarAccess.getGivenRefAccess().getGroup_1()); 
            // InternalAceGen.g:5552:2: ( rule__GivenRef__Group_1__0 )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_INT) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalAceGen.g:5552:3: rule__GivenRef__Group_1__0
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
    // InternalAceGen.g:5560:1: rule__GivenRef__Group__2 : rule__GivenRef__Group__2__Impl ;
    public final void rule__GivenRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5564:1: ( rule__GivenRef__Group__2__Impl )
            // InternalAceGen.g:5565:2: rule__GivenRef__Group__2__Impl
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
    // InternalAceGen.g:5571:1: rule__GivenRef__Group__2__Impl : ( ( rule__GivenRef__ExcludeGivenAssignment_2 )? ) ;
    public final void rule__GivenRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5575:1: ( ( ( rule__GivenRef__ExcludeGivenAssignment_2 )? ) )
            // InternalAceGen.g:5576:1: ( ( rule__GivenRef__ExcludeGivenAssignment_2 )? )
            {
            // InternalAceGen.g:5576:1: ( ( rule__GivenRef__ExcludeGivenAssignment_2 )? )
            // InternalAceGen.g:5577:2: ( rule__GivenRef__ExcludeGivenAssignment_2 )?
            {
             before(grammarAccess.getGivenRefAccess().getExcludeGivenAssignment_2()); 
            // InternalAceGen.g:5578:2: ( rule__GivenRef__ExcludeGivenAssignment_2 )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==76) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalAceGen.g:5578:3: rule__GivenRef__ExcludeGivenAssignment_2
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
    // InternalAceGen.g:5587:1: rule__GivenRef__Group_1__0 : rule__GivenRef__Group_1__0__Impl rule__GivenRef__Group_1__1 ;
    public final void rule__GivenRef__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5591:1: ( rule__GivenRef__Group_1__0__Impl rule__GivenRef__Group_1__1 )
            // InternalAceGen.g:5592:2: rule__GivenRef__Group_1__0__Impl rule__GivenRef__Group_1__1
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
    // InternalAceGen.g:5599:1: rule__GivenRef__Group_1__0__Impl : ( ( rule__GivenRef__TimesAssignment_1_0 ) ) ;
    public final void rule__GivenRef__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5603:1: ( ( ( rule__GivenRef__TimesAssignment_1_0 ) ) )
            // InternalAceGen.g:5604:1: ( ( rule__GivenRef__TimesAssignment_1_0 ) )
            {
            // InternalAceGen.g:5604:1: ( ( rule__GivenRef__TimesAssignment_1_0 ) )
            // InternalAceGen.g:5605:2: ( rule__GivenRef__TimesAssignment_1_0 )
            {
             before(grammarAccess.getGivenRefAccess().getTimesAssignment_1_0()); 
            // InternalAceGen.g:5606:2: ( rule__GivenRef__TimesAssignment_1_0 )
            // InternalAceGen.g:5606:3: rule__GivenRef__TimesAssignment_1_0
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
    // InternalAceGen.g:5614:1: rule__GivenRef__Group_1__1 : rule__GivenRef__Group_1__1__Impl ;
    public final void rule__GivenRef__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5618:1: ( rule__GivenRef__Group_1__1__Impl )
            // InternalAceGen.g:5619:2: rule__GivenRef__Group_1__1__Impl
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
    // InternalAceGen.g:5625:1: rule__GivenRef__Group_1__1__Impl : ( 'x' ) ;
    public final void rule__GivenRef__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5629:1: ( ( 'x' ) )
            // InternalAceGen.g:5630:1: ( 'x' )
            {
            // InternalAceGen.g:5630:1: ( 'x' )
            // InternalAceGen.g:5631:2: 'x'
            {
             before(grammarAccess.getGivenRefAccess().getXKeyword_1_1()); 
            match(input,60,FOLLOW_2); 
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
    // InternalAceGen.g:5641:1: rule__WhenBlock__Group__0 : rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1 ;
    public final void rule__WhenBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5645:1: ( rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1 )
            // InternalAceGen.g:5646:2: rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1
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
    // InternalAceGen.g:5653:1: rule__WhenBlock__Group__0__Impl : ( ( rule__WhenBlock__ActionAssignment_0 ) ) ;
    public final void rule__WhenBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5657:1: ( ( ( rule__WhenBlock__ActionAssignment_0 ) ) )
            // InternalAceGen.g:5658:1: ( ( rule__WhenBlock__ActionAssignment_0 ) )
            {
            // InternalAceGen.g:5658:1: ( ( rule__WhenBlock__ActionAssignment_0 ) )
            // InternalAceGen.g:5659:2: ( rule__WhenBlock__ActionAssignment_0 )
            {
             before(grammarAccess.getWhenBlockAccess().getActionAssignment_0()); 
            // InternalAceGen.g:5660:2: ( rule__WhenBlock__ActionAssignment_0 )
            // InternalAceGen.g:5660:3: rule__WhenBlock__ActionAssignment_0
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
    // InternalAceGen.g:5668:1: rule__WhenBlock__Group__1 : rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2 ;
    public final void rule__WhenBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5672:1: ( rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2 )
            // InternalAceGen.g:5673:2: rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2
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
    // InternalAceGen.g:5680:1: rule__WhenBlock__Group__1__Impl : ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) ) ;
    public final void rule__WhenBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5684:1: ( ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) ) )
            // InternalAceGen.g:5685:1: ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) )
            {
            // InternalAceGen.g:5685:1: ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) )
            // InternalAceGen.g:5686:2: ( rule__WhenBlock__DataDefinitionAssignment_1 )
            {
             before(grammarAccess.getWhenBlockAccess().getDataDefinitionAssignment_1()); 
            // InternalAceGen.g:5687:2: ( rule__WhenBlock__DataDefinitionAssignment_1 )
            // InternalAceGen.g:5687:3: rule__WhenBlock__DataDefinitionAssignment_1
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
    // InternalAceGen.g:5695:1: rule__WhenBlock__Group__2 : rule__WhenBlock__Group__2__Impl ;
    public final void rule__WhenBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5699:1: ( rule__WhenBlock__Group__2__Impl )
            // InternalAceGen.g:5700:2: rule__WhenBlock__Group__2__Impl
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
    // InternalAceGen.g:5706:1: rule__WhenBlock__Group__2__Impl : ( ( rule__WhenBlock__AuthorizationAssignment_2 )? ) ;
    public final void rule__WhenBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5710:1: ( ( ( rule__WhenBlock__AuthorizationAssignment_2 )? ) )
            // InternalAceGen.g:5711:1: ( ( rule__WhenBlock__AuthorizationAssignment_2 )? )
            {
            // InternalAceGen.g:5711:1: ( ( rule__WhenBlock__AuthorizationAssignment_2 )? )
            // InternalAceGen.g:5712:2: ( rule__WhenBlock__AuthorizationAssignment_2 )?
            {
             before(grammarAccess.getWhenBlockAccess().getAuthorizationAssignment_2()); 
            // InternalAceGen.g:5713:2: ( rule__WhenBlock__AuthorizationAssignment_2 )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==63) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalAceGen.g:5713:3: rule__WhenBlock__AuthorizationAssignment_2
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
    // InternalAceGen.g:5722:1: rule__ThenBlock__Group__0 : rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1 ;
    public final void rule__ThenBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5726:1: ( rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1 )
            // InternalAceGen.g:5727:2: rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1
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
    // InternalAceGen.g:5734:1: rule__ThenBlock__Group__0__Impl : ( ( rule__ThenBlock__StatusCodeAssignment_0 ) ) ;
    public final void rule__ThenBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5738:1: ( ( ( rule__ThenBlock__StatusCodeAssignment_0 ) ) )
            // InternalAceGen.g:5739:1: ( ( rule__ThenBlock__StatusCodeAssignment_0 ) )
            {
            // InternalAceGen.g:5739:1: ( ( rule__ThenBlock__StatusCodeAssignment_0 ) )
            // InternalAceGen.g:5740:2: ( rule__ThenBlock__StatusCodeAssignment_0 )
            {
             before(grammarAccess.getThenBlockAccess().getStatusCodeAssignment_0()); 
            // InternalAceGen.g:5741:2: ( rule__ThenBlock__StatusCodeAssignment_0 )
            // InternalAceGen.g:5741:3: rule__ThenBlock__StatusCodeAssignment_0
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
    // InternalAceGen.g:5749:1: rule__ThenBlock__Group__1 : rule__ThenBlock__Group__1__Impl ;
    public final void rule__ThenBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5753:1: ( rule__ThenBlock__Group__1__Impl )
            // InternalAceGen.g:5754:2: rule__ThenBlock__Group__1__Impl
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
    // InternalAceGen.g:5760:1: rule__ThenBlock__Group__1__Impl : ( ( rule__ThenBlock__Group_1__0 )? ) ;
    public final void rule__ThenBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5764:1: ( ( ( rule__ThenBlock__Group_1__0 )? ) )
            // InternalAceGen.g:5765:1: ( ( rule__ThenBlock__Group_1__0 )? )
            {
            // InternalAceGen.g:5765:1: ( ( rule__ThenBlock__Group_1__0 )? )
            // InternalAceGen.g:5766:2: ( rule__ThenBlock__Group_1__0 )?
            {
             before(grammarAccess.getThenBlockAccess().getGroup_1()); 
            // InternalAceGen.g:5767:2: ( rule__ThenBlock__Group_1__0 )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==55) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalAceGen.g:5767:3: rule__ThenBlock__Group_1__0
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
    // InternalAceGen.g:5776:1: rule__ThenBlock__Group_1__0 : rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1 ;
    public final void rule__ThenBlock__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5780:1: ( rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1 )
            // InternalAceGen.g:5781:2: rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1
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
    // InternalAceGen.g:5788:1: rule__ThenBlock__Group_1__0__Impl : ( 'response' ) ;
    public final void rule__ThenBlock__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5792:1: ( ( 'response' ) )
            // InternalAceGen.g:5793:1: ( 'response' )
            {
            // InternalAceGen.g:5793:1: ( 'response' )
            // InternalAceGen.g:5794:2: 'response'
            {
             before(grammarAccess.getThenBlockAccess().getResponseKeyword_1_0()); 
            match(input,55,FOLLOW_2); 
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
    // InternalAceGen.g:5803:1: rule__ThenBlock__Group_1__1 : rule__ThenBlock__Group_1__1__Impl ;
    public final void rule__ThenBlock__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5807:1: ( rule__ThenBlock__Group_1__1__Impl )
            // InternalAceGen.g:5808:2: rule__ThenBlock__Group_1__1__Impl
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
    // InternalAceGen.g:5814:1: rule__ThenBlock__Group_1__1__Impl : ( ( rule__ThenBlock__ResponseAssignment_1_1 ) ) ;
    public final void rule__ThenBlock__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5818:1: ( ( ( rule__ThenBlock__ResponseAssignment_1_1 ) ) )
            // InternalAceGen.g:5819:1: ( ( rule__ThenBlock__ResponseAssignment_1_1 ) )
            {
            // InternalAceGen.g:5819:1: ( ( rule__ThenBlock__ResponseAssignment_1_1 ) )
            // InternalAceGen.g:5820:2: ( rule__ThenBlock__ResponseAssignment_1_1 )
            {
             before(grammarAccess.getThenBlockAccess().getResponseAssignment_1_1()); 
            // InternalAceGen.g:5821:2: ( rule__ThenBlock__ResponseAssignment_1_1 )
            // InternalAceGen.g:5821:3: rule__ThenBlock__ResponseAssignment_1_1
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
    // InternalAceGen.g:5830:1: rule__DataDefinition__Group__0 : rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1 ;
    public final void rule__DataDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5834:1: ( rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1 )
            // InternalAceGen.g:5835:2: rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1
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
    // InternalAceGen.g:5842:1: rule__DataDefinition__Group__0__Impl : ( () ) ;
    public final void rule__DataDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5846:1: ( ( () ) )
            // InternalAceGen.g:5847:1: ( () )
            {
            // InternalAceGen.g:5847:1: ( () )
            // InternalAceGen.g:5848:2: ()
            {
             before(grammarAccess.getDataDefinitionAccess().getDataDefinitionAction_0()); 
            // InternalAceGen.g:5849:2: ()
            // InternalAceGen.g:5849:3: 
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
    // InternalAceGen.g:5857:1: rule__DataDefinition__Group__1 : rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2 ;
    public final void rule__DataDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5861:1: ( rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2 )
            // InternalAceGen.g:5862:2: rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2
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
    // InternalAceGen.g:5869:1: rule__DataDefinition__Group__1__Impl : ( ( rule__DataDefinition__Group_1__0 )? ) ;
    public final void rule__DataDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5873:1: ( ( ( rule__DataDefinition__Group_1__0 )? ) )
            // InternalAceGen.g:5874:1: ( ( rule__DataDefinition__Group_1__0 )? )
            {
            // InternalAceGen.g:5874:1: ( ( rule__DataDefinition__Group_1__0 )? )
            // InternalAceGen.g:5875:2: ( rule__DataDefinition__Group_1__0 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getGroup_1()); 
            // InternalAceGen.g:5876:2: ( rule__DataDefinition__Group_1__0 )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==61) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalAceGen.g:5876:3: rule__DataDefinition__Group_1__0
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
    // InternalAceGen.g:5884:1: rule__DataDefinition__Group__2 : rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3 ;
    public final void rule__DataDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5888:1: ( rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3 )
            // InternalAceGen.g:5889:2: rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3
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
    // InternalAceGen.g:5896:1: rule__DataDefinition__Group__2__Impl : ( ( rule__DataDefinition__Group_2__0 )? ) ;
    public final void rule__DataDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5900:1: ( ( ( rule__DataDefinition__Group_2__0 )? ) )
            // InternalAceGen.g:5901:1: ( ( rule__DataDefinition__Group_2__0 )? )
            {
            // InternalAceGen.g:5901:1: ( ( rule__DataDefinition__Group_2__0 )? )
            // InternalAceGen.g:5902:2: ( rule__DataDefinition__Group_2__0 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getGroup_2()); 
            // InternalAceGen.g:5903:2: ( rule__DataDefinition__Group_2__0 )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==62) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalAceGen.g:5903:3: rule__DataDefinition__Group_2__0
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
    // InternalAceGen.g:5911:1: rule__DataDefinition__Group__3 : rule__DataDefinition__Group__3__Impl ;
    public final void rule__DataDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5915:1: ( rule__DataDefinition__Group__3__Impl )
            // InternalAceGen.g:5916:2: rule__DataDefinition__Group__3__Impl
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
    // InternalAceGen.g:5922:1: rule__DataDefinition__Group__3__Impl : ( ( rule__DataDefinition__DataAssignment_3 )? ) ;
    public final void rule__DataDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5926:1: ( ( ( rule__DataDefinition__DataAssignment_3 )? ) )
            // InternalAceGen.g:5927:1: ( ( rule__DataDefinition__DataAssignment_3 )? )
            {
            // InternalAceGen.g:5927:1: ( ( rule__DataDefinition__DataAssignment_3 )? )
            // InternalAceGen.g:5928:2: ( rule__DataDefinition__DataAssignment_3 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getDataAssignment_3()); 
            // InternalAceGen.g:5929:2: ( rule__DataDefinition__DataAssignment_3 )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==45) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalAceGen.g:5929:3: rule__DataDefinition__DataAssignment_3
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
    // InternalAceGen.g:5938:1: rule__DataDefinition__Group_1__0 : rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1 ;
    public final void rule__DataDefinition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5942:1: ( rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1 )
            // InternalAceGen.g:5943:2: rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1
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
    // InternalAceGen.g:5950:1: rule__DataDefinition__Group_1__0__Impl : ( 'uuid' ) ;
    public final void rule__DataDefinition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5954:1: ( ( 'uuid' ) )
            // InternalAceGen.g:5955:1: ( 'uuid' )
            {
            // InternalAceGen.g:5955:1: ( 'uuid' )
            // InternalAceGen.g:5956:2: 'uuid'
            {
             before(grammarAccess.getDataDefinitionAccess().getUuidKeyword_1_0()); 
            match(input,61,FOLLOW_2); 
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
    // InternalAceGen.g:5965:1: rule__DataDefinition__Group_1__1 : rule__DataDefinition__Group_1__1__Impl ;
    public final void rule__DataDefinition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5969:1: ( rule__DataDefinition__Group_1__1__Impl )
            // InternalAceGen.g:5970:2: rule__DataDefinition__Group_1__1__Impl
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
    // InternalAceGen.g:5976:1: rule__DataDefinition__Group_1__1__Impl : ( ( rule__DataDefinition__UuidAssignment_1_1 ) ) ;
    public final void rule__DataDefinition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5980:1: ( ( ( rule__DataDefinition__UuidAssignment_1_1 ) ) )
            // InternalAceGen.g:5981:1: ( ( rule__DataDefinition__UuidAssignment_1_1 ) )
            {
            // InternalAceGen.g:5981:1: ( ( rule__DataDefinition__UuidAssignment_1_1 ) )
            // InternalAceGen.g:5982:2: ( rule__DataDefinition__UuidAssignment_1_1 )
            {
             before(grammarAccess.getDataDefinitionAccess().getUuidAssignment_1_1()); 
            // InternalAceGen.g:5983:2: ( rule__DataDefinition__UuidAssignment_1_1 )
            // InternalAceGen.g:5983:3: rule__DataDefinition__UuidAssignment_1_1
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
    // InternalAceGen.g:5992:1: rule__DataDefinition__Group_2__0 : rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1 ;
    public final void rule__DataDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5996:1: ( rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1 )
            // InternalAceGen.g:5997:2: rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1
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
    // InternalAceGen.g:6004:1: rule__DataDefinition__Group_2__0__Impl : ( 'systemTime' ) ;
    public final void rule__DataDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6008:1: ( ( 'systemTime' ) )
            // InternalAceGen.g:6009:1: ( 'systemTime' )
            {
            // InternalAceGen.g:6009:1: ( 'systemTime' )
            // InternalAceGen.g:6010:2: 'systemTime'
            {
             before(grammarAccess.getDataDefinitionAccess().getSystemTimeKeyword_2_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalAceGen.g:6019:1: rule__DataDefinition__Group_2__1 : rule__DataDefinition__Group_2__1__Impl rule__DataDefinition__Group_2__2 ;
    public final void rule__DataDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6023:1: ( rule__DataDefinition__Group_2__1__Impl rule__DataDefinition__Group_2__2 )
            // InternalAceGen.g:6024:2: rule__DataDefinition__Group_2__1__Impl rule__DataDefinition__Group_2__2
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
    // InternalAceGen.g:6031:1: rule__DataDefinition__Group_2__1__Impl : ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) ) ;
    public final void rule__DataDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6035:1: ( ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) ) )
            // InternalAceGen.g:6036:1: ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) )
            {
            // InternalAceGen.g:6036:1: ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) )
            // InternalAceGen.g:6037:2: ( rule__DataDefinition__SystemtimeAssignment_2_1 )
            {
             before(grammarAccess.getDataDefinitionAccess().getSystemtimeAssignment_2_1()); 
            // InternalAceGen.g:6038:2: ( rule__DataDefinition__SystemtimeAssignment_2_1 )
            // InternalAceGen.g:6038:3: rule__DataDefinition__SystemtimeAssignment_2_1
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
    // InternalAceGen.g:6046:1: rule__DataDefinition__Group_2__2 : rule__DataDefinition__Group_2__2__Impl ;
    public final void rule__DataDefinition__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6050:1: ( rule__DataDefinition__Group_2__2__Impl )
            // InternalAceGen.g:6051:2: rule__DataDefinition__Group_2__2__Impl
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
    // InternalAceGen.g:6057:1: rule__DataDefinition__Group_2__2__Impl : ( ( rule__DataDefinition__PatternAssignment_2_2 ) ) ;
    public final void rule__DataDefinition__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6061:1: ( ( ( rule__DataDefinition__PatternAssignment_2_2 ) ) )
            // InternalAceGen.g:6062:1: ( ( rule__DataDefinition__PatternAssignment_2_2 ) )
            {
            // InternalAceGen.g:6062:1: ( ( rule__DataDefinition__PatternAssignment_2_2 ) )
            // InternalAceGen.g:6063:2: ( rule__DataDefinition__PatternAssignment_2_2 )
            {
             before(grammarAccess.getDataDefinitionAccess().getPatternAssignment_2_2()); 
            // InternalAceGen.g:6064:2: ( rule__DataDefinition__PatternAssignment_2_2 )
            // InternalAceGen.g:6064:3: rule__DataDefinition__PatternAssignment_2_2
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
    // InternalAceGen.g:6073:1: rule__Authorization__Group__0 : rule__Authorization__Group__0__Impl rule__Authorization__Group__1 ;
    public final void rule__Authorization__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6077:1: ( rule__Authorization__Group__0__Impl rule__Authorization__Group__1 )
            // InternalAceGen.g:6078:2: rule__Authorization__Group__0__Impl rule__Authorization__Group__1
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
    // InternalAceGen.g:6085:1: rule__Authorization__Group__0__Impl : ( 'authorization' ) ;
    public final void rule__Authorization__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6089:1: ( ( 'authorization' ) )
            // InternalAceGen.g:6090:1: ( 'authorization' )
            {
            // InternalAceGen.g:6090:1: ( 'authorization' )
            // InternalAceGen.g:6091:2: 'authorization'
            {
             before(grammarAccess.getAuthorizationAccess().getAuthorizationKeyword_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalAceGen.g:6100:1: rule__Authorization__Group__1 : rule__Authorization__Group__1__Impl rule__Authorization__Group__2 ;
    public final void rule__Authorization__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6104:1: ( rule__Authorization__Group__1__Impl rule__Authorization__Group__2 )
            // InternalAceGen.g:6105:2: rule__Authorization__Group__1__Impl rule__Authorization__Group__2
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
    // InternalAceGen.g:6112:1: rule__Authorization__Group__1__Impl : ( ( rule__Authorization__UsernameAssignment_1 ) ) ;
    public final void rule__Authorization__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6116:1: ( ( ( rule__Authorization__UsernameAssignment_1 ) ) )
            // InternalAceGen.g:6117:1: ( ( rule__Authorization__UsernameAssignment_1 ) )
            {
            // InternalAceGen.g:6117:1: ( ( rule__Authorization__UsernameAssignment_1 ) )
            // InternalAceGen.g:6118:2: ( rule__Authorization__UsernameAssignment_1 )
            {
             before(grammarAccess.getAuthorizationAccess().getUsernameAssignment_1()); 
            // InternalAceGen.g:6119:2: ( rule__Authorization__UsernameAssignment_1 )
            // InternalAceGen.g:6119:3: rule__Authorization__UsernameAssignment_1
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
    // InternalAceGen.g:6127:1: rule__Authorization__Group__2 : rule__Authorization__Group__2__Impl rule__Authorization__Group__3 ;
    public final void rule__Authorization__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6131:1: ( rule__Authorization__Group__2__Impl rule__Authorization__Group__3 )
            // InternalAceGen.g:6132:2: rule__Authorization__Group__2__Impl rule__Authorization__Group__3
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
    // InternalAceGen.g:6139:1: rule__Authorization__Group__2__Impl : ( ':' ) ;
    public final void rule__Authorization__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6143:1: ( ( ':' ) )
            // InternalAceGen.g:6144:1: ( ':' )
            {
            // InternalAceGen.g:6144:1: ( ':' )
            // InternalAceGen.g:6145:2: ':'
            {
             before(grammarAccess.getAuthorizationAccess().getColonKeyword_2()); 
            match(input,44,FOLLOW_2); 
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
    // InternalAceGen.g:6154:1: rule__Authorization__Group__3 : rule__Authorization__Group__3__Impl ;
    public final void rule__Authorization__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6158:1: ( rule__Authorization__Group__3__Impl )
            // InternalAceGen.g:6159:2: rule__Authorization__Group__3__Impl
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
    // InternalAceGen.g:6165:1: rule__Authorization__Group__3__Impl : ( ( rule__Authorization__PasswordAssignment_3 ) ) ;
    public final void rule__Authorization__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6169:1: ( ( ( rule__Authorization__PasswordAssignment_3 ) ) )
            // InternalAceGen.g:6170:1: ( ( rule__Authorization__PasswordAssignment_3 ) )
            {
            // InternalAceGen.g:6170:1: ( ( rule__Authorization__PasswordAssignment_3 ) )
            // InternalAceGen.g:6171:2: ( rule__Authorization__PasswordAssignment_3 )
            {
             before(grammarAccess.getAuthorizationAccess().getPasswordAssignment_3()); 
            // InternalAceGen.g:6172:2: ( rule__Authorization__PasswordAssignment_3 )
            // InternalAceGen.g:6172:3: rule__Authorization__PasswordAssignment_3
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
    // InternalAceGen.g:6181:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6185:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalAceGen.g:6186:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
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
    // InternalAceGen.g:6193:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__UniqueAssignment_0 )? ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6197:1: ( ( ( rule__Attribute__UniqueAssignment_0 )? ) )
            // InternalAceGen.g:6198:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            {
            // InternalAceGen.g:6198:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            // InternalAceGen.g:6199:2: ( rule__Attribute__UniqueAssignment_0 )?
            {
             before(grammarAccess.getAttributeAccess().getUniqueAssignment_0()); 
            // InternalAceGen.g:6200:2: ( rule__Attribute__UniqueAssignment_0 )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==77) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalAceGen.g:6200:3: rule__Attribute__UniqueAssignment_0
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
    // InternalAceGen.g:6208:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6212:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalAceGen.g:6213:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
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
    // InternalAceGen.g:6220:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__PrimaryKeyAssignment_1 )? ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6224:1: ( ( ( rule__Attribute__PrimaryKeyAssignment_1 )? ) )
            // InternalAceGen.g:6225:1: ( ( rule__Attribute__PrimaryKeyAssignment_1 )? )
            {
            // InternalAceGen.g:6225:1: ( ( rule__Attribute__PrimaryKeyAssignment_1 )? )
            // InternalAceGen.g:6226:2: ( rule__Attribute__PrimaryKeyAssignment_1 )?
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyAssignment_1()); 
            // InternalAceGen.g:6227:2: ( rule__Attribute__PrimaryKeyAssignment_1 )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==78) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalAceGen.g:6227:3: rule__Attribute__PrimaryKeyAssignment_1
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
    // InternalAceGen.g:6235:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6239:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // InternalAceGen.g:6240:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
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
    // InternalAceGen.g:6247:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__NotNullAssignment_2 )? ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6251:1: ( ( ( rule__Attribute__NotNullAssignment_2 )? ) )
            // InternalAceGen.g:6252:1: ( ( rule__Attribute__NotNullAssignment_2 )? )
            {
            // InternalAceGen.g:6252:1: ( ( rule__Attribute__NotNullAssignment_2 )? )
            // InternalAceGen.g:6253:2: ( rule__Attribute__NotNullAssignment_2 )?
            {
             before(grammarAccess.getAttributeAccess().getNotNullAssignment_2()); 
            // InternalAceGen.g:6254:2: ( rule__Attribute__NotNullAssignment_2 )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==79) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalAceGen.g:6254:3: rule__Attribute__NotNullAssignment_2
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
    // InternalAceGen.g:6262:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl rule__Attribute__Group__4 ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6266:1: ( rule__Attribute__Group__3__Impl rule__Attribute__Group__4 )
            // InternalAceGen.g:6267:2: rule__Attribute__Group__3__Impl rule__Attribute__Group__4
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
    // InternalAceGen.g:6274:1: rule__Attribute__Group__3__Impl : ( ( rule__Attribute__ListAssignment_3 )? ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6278:1: ( ( ( rule__Attribute__ListAssignment_3 )? ) )
            // InternalAceGen.g:6279:1: ( ( rule__Attribute__ListAssignment_3 )? )
            {
            // InternalAceGen.g:6279:1: ( ( rule__Attribute__ListAssignment_3 )? )
            // InternalAceGen.g:6280:2: ( rule__Attribute__ListAssignment_3 )?
            {
             before(grammarAccess.getAttributeAccess().getListAssignment_3()); 
            // InternalAceGen.g:6281:2: ( rule__Attribute__ListAssignment_3 )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==80) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalAceGen.g:6281:3: rule__Attribute__ListAssignment_3
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
    // InternalAceGen.g:6289:1: rule__Attribute__Group__4 : rule__Attribute__Group__4__Impl rule__Attribute__Group__5 ;
    public final void rule__Attribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6293:1: ( rule__Attribute__Group__4__Impl rule__Attribute__Group__5 )
            // InternalAceGen.g:6294:2: rule__Attribute__Group__4__Impl rule__Attribute__Group__5
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
    // InternalAceGen.g:6301:1: rule__Attribute__Group__4__Impl : ( ( rule__Attribute__Alternatives_4 ) ) ;
    public final void rule__Attribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6305:1: ( ( ( rule__Attribute__Alternatives_4 ) ) )
            // InternalAceGen.g:6306:1: ( ( rule__Attribute__Alternatives_4 ) )
            {
            // InternalAceGen.g:6306:1: ( ( rule__Attribute__Alternatives_4 ) )
            // InternalAceGen.g:6307:2: ( rule__Attribute__Alternatives_4 )
            {
             before(grammarAccess.getAttributeAccess().getAlternatives_4()); 
            // InternalAceGen.g:6308:2: ( rule__Attribute__Alternatives_4 )
            // InternalAceGen.g:6308:3: rule__Attribute__Alternatives_4
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
    // InternalAceGen.g:6316:1: rule__Attribute__Group__5 : rule__Attribute__Group__5__Impl rule__Attribute__Group__6 ;
    public final void rule__Attribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6320:1: ( rule__Attribute__Group__5__Impl rule__Attribute__Group__6 )
            // InternalAceGen.g:6321:2: rule__Attribute__Group__5__Impl rule__Attribute__Group__6
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
    // InternalAceGen.g:6328:1: rule__Attribute__Group__5__Impl : ( ( rule__Attribute__NameAssignment_5 ) ) ;
    public final void rule__Attribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6332:1: ( ( ( rule__Attribute__NameAssignment_5 ) ) )
            // InternalAceGen.g:6333:1: ( ( rule__Attribute__NameAssignment_5 ) )
            {
            // InternalAceGen.g:6333:1: ( ( rule__Attribute__NameAssignment_5 ) )
            // InternalAceGen.g:6334:2: ( rule__Attribute__NameAssignment_5 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_5()); 
            // InternalAceGen.g:6335:2: ( rule__Attribute__NameAssignment_5 )
            // InternalAceGen.g:6335:3: rule__Attribute__NameAssignment_5
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
    // InternalAceGen.g:6343:1: rule__Attribute__Group__6 : rule__Attribute__Group__6__Impl rule__Attribute__Group__7 ;
    public final void rule__Attribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6347:1: ( rule__Attribute__Group__6__Impl rule__Attribute__Group__7 )
            // InternalAceGen.g:6348:2: rule__Attribute__Group__6__Impl rule__Attribute__Group__7
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
    // InternalAceGen.g:6355:1: rule__Attribute__Group__6__Impl : ( ( rule__Attribute__Group_6__0 )? ) ;
    public final void rule__Attribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6359:1: ( ( ( rule__Attribute__Group_6__0 )? ) )
            // InternalAceGen.g:6360:1: ( ( rule__Attribute__Group_6__0 )? )
            {
            // InternalAceGen.g:6360:1: ( ( rule__Attribute__Group_6__0 )? )
            // InternalAceGen.g:6361:2: ( rule__Attribute__Group_6__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_6()); 
            // InternalAceGen.g:6362:2: ( rule__Attribute__Group_6__0 )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==64) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalAceGen.g:6362:3: rule__Attribute__Group_6__0
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
    // InternalAceGen.g:6370:1: rule__Attribute__Group__7 : rule__Attribute__Group__7__Impl ;
    public final void rule__Attribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6374:1: ( rule__Attribute__Group__7__Impl )
            // InternalAceGen.g:6375:2: rule__Attribute__Group__7__Impl
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
    // InternalAceGen.g:6381:1: rule__Attribute__Group__7__Impl : ( ( rule__Attribute__NotReplayableAssignment_7 )? ) ;
    public final void rule__Attribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6385:1: ( ( ( rule__Attribute__NotReplayableAssignment_7 )? ) )
            // InternalAceGen.g:6386:1: ( ( rule__Attribute__NotReplayableAssignment_7 )? )
            {
            // InternalAceGen.g:6386:1: ( ( rule__Attribute__NotReplayableAssignment_7 )? )
            // InternalAceGen.g:6387:2: ( rule__Attribute__NotReplayableAssignment_7 )?
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableAssignment_7()); 
            // InternalAceGen.g:6388:2: ( rule__Attribute__NotReplayableAssignment_7 )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==81) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalAceGen.g:6388:3: rule__Attribute__NotReplayableAssignment_7
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
    // InternalAceGen.g:6397:1: rule__Attribute__Group_6__0 : rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 ;
    public final void rule__Attribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6401:1: ( rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 )
            // InternalAceGen.g:6402:2: rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1
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
    // InternalAceGen.g:6409:1: rule__Attribute__Group_6__0__Impl : ( 'references' ) ;
    public final void rule__Attribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6413:1: ( ( 'references' ) )
            // InternalAceGen.g:6414:1: ( 'references' )
            {
            // InternalAceGen.g:6414:1: ( 'references' )
            // InternalAceGen.g:6415:2: 'references'
            {
             before(grammarAccess.getAttributeAccess().getReferencesKeyword_6_0()); 
            match(input,64,FOLLOW_2); 
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
    // InternalAceGen.g:6424:1: rule__Attribute__Group_6__1 : rule__Attribute__Group_6__1__Impl ;
    public final void rule__Attribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6428:1: ( rule__Attribute__Group_6__1__Impl )
            // InternalAceGen.g:6429:2: rule__Attribute__Group_6__1__Impl
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
    // InternalAceGen.g:6435:1: rule__Attribute__Group_6__1__Impl : ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) ) ;
    public final void rule__Attribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6439:1: ( ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) ) )
            // InternalAceGen.g:6440:1: ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) )
            {
            // InternalAceGen.g:6440:1: ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) )
            // InternalAceGen.g:6441:2: ( rule__Attribute__ForeignKeyAssignment_6_1 )
            {
             before(grammarAccess.getAttributeAccess().getForeignKeyAssignment_6_1()); 
            // InternalAceGen.g:6442:2: ( rule__Attribute__ForeignKeyAssignment_6_1 )
            // InternalAceGen.g:6442:3: rule__Attribute__ForeignKeyAssignment_6_1
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
    // InternalAceGen.g:6451:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6455:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalAceGen.g:6456:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalAceGen.g:6463:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6467:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6468:1: ( RULE_ID )
            {
            // InternalAceGen.g:6468:1: ( RULE_ID )
            // InternalAceGen.g:6469:2: RULE_ID
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
    // InternalAceGen.g:6478:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6482:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalAceGen.g:6483:2: rule__QualifiedName__Group__1__Impl
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
    // InternalAceGen.g:6489:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6493:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalAceGen.g:6494:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalAceGen.g:6494:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalAceGen.g:6495:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalAceGen.g:6496:2: ( rule__QualifiedName__Group_1__0 )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==65) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalAceGen.g:6496:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_55);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop90;
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
    // InternalAceGen.g:6505:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6509:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalAceGen.g:6510:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalAceGen.g:6517:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6521:1: ( ( '.' ) )
            // InternalAceGen.g:6522:1: ( '.' )
            {
            // InternalAceGen.g:6522:1: ( '.' )
            // InternalAceGen.g:6523:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalAceGen.g:6532:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6536:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalAceGen.g:6537:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalAceGen.g:6543:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6547:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6548:1: ( RULE_ID )
            {
            // InternalAceGen.g:6548:1: ( RULE_ID )
            // InternalAceGen.g:6549:2: RULE_ID
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
    // InternalAceGen.g:6559:1: rule__JsonDateTime__Group__0 : rule__JsonDateTime__Group__0__Impl rule__JsonDateTime__Group__1 ;
    public final void rule__JsonDateTime__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6563:1: ( rule__JsonDateTime__Group__0__Impl rule__JsonDateTime__Group__1 )
            // InternalAceGen.g:6564:2: rule__JsonDateTime__Group__0__Impl rule__JsonDateTime__Group__1
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
    // InternalAceGen.g:6571:1: rule__JsonDateTime__Group__0__Impl : ( ( rule__JsonDateTime__DateTimeAssignment_0 ) ) ;
    public final void rule__JsonDateTime__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6575:1: ( ( ( rule__JsonDateTime__DateTimeAssignment_0 ) ) )
            // InternalAceGen.g:6576:1: ( ( rule__JsonDateTime__DateTimeAssignment_0 ) )
            {
            // InternalAceGen.g:6576:1: ( ( rule__JsonDateTime__DateTimeAssignment_0 ) )
            // InternalAceGen.g:6577:2: ( rule__JsonDateTime__DateTimeAssignment_0 )
            {
             before(grammarAccess.getJsonDateTimeAccess().getDateTimeAssignment_0()); 
            // InternalAceGen.g:6578:2: ( rule__JsonDateTime__DateTimeAssignment_0 )
            // InternalAceGen.g:6578:3: rule__JsonDateTime__DateTimeAssignment_0
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
    // InternalAceGen.g:6586:1: rule__JsonDateTime__Group__1 : rule__JsonDateTime__Group__1__Impl ;
    public final void rule__JsonDateTime__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6590:1: ( rule__JsonDateTime__Group__1__Impl )
            // InternalAceGen.g:6591:2: rule__JsonDateTime__Group__1__Impl
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
    // InternalAceGen.g:6597:1: rule__JsonDateTime__Group__1__Impl : ( ( rule__JsonDateTime__PatternAssignment_1 ) ) ;
    public final void rule__JsonDateTime__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6601:1: ( ( ( rule__JsonDateTime__PatternAssignment_1 ) ) )
            // InternalAceGen.g:6602:1: ( ( rule__JsonDateTime__PatternAssignment_1 ) )
            {
            // InternalAceGen.g:6602:1: ( ( rule__JsonDateTime__PatternAssignment_1 ) )
            // InternalAceGen.g:6603:2: ( rule__JsonDateTime__PatternAssignment_1 )
            {
             before(grammarAccess.getJsonDateTimeAccess().getPatternAssignment_1()); 
            // InternalAceGen.g:6604:2: ( rule__JsonDateTime__PatternAssignment_1 )
            // InternalAceGen.g:6604:3: rule__JsonDateTime__PatternAssignment_1
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
    // InternalAceGen.g:6613:1: rule__JsonObject__Group__0 : rule__JsonObject__Group__0__Impl rule__JsonObject__Group__1 ;
    public final void rule__JsonObject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6617:1: ( rule__JsonObject__Group__0__Impl rule__JsonObject__Group__1 )
            // InternalAceGen.g:6618:2: rule__JsonObject__Group__0__Impl rule__JsonObject__Group__1
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
    // InternalAceGen.g:6625:1: rule__JsonObject__Group__0__Impl : ( () ) ;
    public final void rule__JsonObject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6629:1: ( ( () ) )
            // InternalAceGen.g:6630:1: ( () )
            {
            // InternalAceGen.g:6630:1: ( () )
            // InternalAceGen.g:6631:2: ()
            {
             before(grammarAccess.getJsonObjectAccess().getJsonObjectAction_0()); 
            // InternalAceGen.g:6632:2: ()
            // InternalAceGen.g:6632:3: 
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
    // InternalAceGen.g:6640:1: rule__JsonObject__Group__1 : rule__JsonObject__Group__1__Impl rule__JsonObject__Group__2 ;
    public final void rule__JsonObject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6644:1: ( rule__JsonObject__Group__1__Impl rule__JsonObject__Group__2 )
            // InternalAceGen.g:6645:2: rule__JsonObject__Group__1__Impl rule__JsonObject__Group__2
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
    // InternalAceGen.g:6652:1: rule__JsonObject__Group__1__Impl : ( '{' ) ;
    public final void rule__JsonObject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6656:1: ( ( '{' ) )
            // InternalAceGen.g:6657:1: ( '{' )
            {
            // InternalAceGen.g:6657:1: ( '{' )
            // InternalAceGen.g:6658:2: '{'
            {
             before(grammarAccess.getJsonObjectAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,45,FOLLOW_2); 
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
    // InternalAceGen.g:6667:1: rule__JsonObject__Group__2 : rule__JsonObject__Group__2__Impl rule__JsonObject__Group__3 ;
    public final void rule__JsonObject__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6671:1: ( rule__JsonObject__Group__2__Impl rule__JsonObject__Group__3 )
            // InternalAceGen.g:6672:2: rule__JsonObject__Group__2__Impl rule__JsonObject__Group__3
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
    // InternalAceGen.g:6679:1: rule__JsonObject__Group__2__Impl : ( ( rule__JsonObject__MembersAssignment_2 )? ) ;
    public final void rule__JsonObject__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6683:1: ( ( ( rule__JsonObject__MembersAssignment_2 )? ) )
            // InternalAceGen.g:6684:1: ( ( rule__JsonObject__MembersAssignment_2 )? )
            {
            // InternalAceGen.g:6684:1: ( ( rule__JsonObject__MembersAssignment_2 )? )
            // InternalAceGen.g:6685:2: ( rule__JsonObject__MembersAssignment_2 )?
            {
             before(grammarAccess.getJsonObjectAccess().getMembersAssignment_2()); 
            // InternalAceGen.g:6686:2: ( rule__JsonObject__MembersAssignment_2 )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_ID) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalAceGen.g:6686:3: rule__JsonObject__MembersAssignment_2
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
    // InternalAceGen.g:6694:1: rule__JsonObject__Group__3 : rule__JsonObject__Group__3__Impl rule__JsonObject__Group__4 ;
    public final void rule__JsonObject__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6698:1: ( rule__JsonObject__Group__3__Impl rule__JsonObject__Group__4 )
            // InternalAceGen.g:6699:2: rule__JsonObject__Group__3__Impl rule__JsonObject__Group__4
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
    // InternalAceGen.g:6706:1: rule__JsonObject__Group__3__Impl : ( ( rule__JsonObject__Group_3__0 )* ) ;
    public final void rule__JsonObject__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6710:1: ( ( ( rule__JsonObject__Group_3__0 )* ) )
            // InternalAceGen.g:6711:1: ( ( rule__JsonObject__Group_3__0 )* )
            {
            // InternalAceGen.g:6711:1: ( ( rule__JsonObject__Group_3__0 )* )
            // InternalAceGen.g:6712:2: ( rule__JsonObject__Group_3__0 )*
            {
             before(grammarAccess.getJsonObjectAccess().getGroup_3()); 
            // InternalAceGen.g:6713:2: ( rule__JsonObject__Group_3__0 )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==36) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalAceGen.g:6713:3: rule__JsonObject__Group_3__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__JsonObject__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop92;
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
    // InternalAceGen.g:6721:1: rule__JsonObject__Group__4 : rule__JsonObject__Group__4__Impl ;
    public final void rule__JsonObject__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6725:1: ( rule__JsonObject__Group__4__Impl )
            // InternalAceGen.g:6726:2: rule__JsonObject__Group__4__Impl
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
    // InternalAceGen.g:6732:1: rule__JsonObject__Group__4__Impl : ( '}' ) ;
    public final void rule__JsonObject__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6736:1: ( ( '}' ) )
            // InternalAceGen.g:6737:1: ( '}' )
            {
            // InternalAceGen.g:6737:1: ( '}' )
            // InternalAceGen.g:6738:2: '}'
            {
             before(grammarAccess.getJsonObjectAccess().getRightCurlyBracketKeyword_4()); 
            match(input,46,FOLLOW_2); 
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
    // InternalAceGen.g:6748:1: rule__JsonObject__Group_3__0 : rule__JsonObject__Group_3__0__Impl rule__JsonObject__Group_3__1 ;
    public final void rule__JsonObject__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6752:1: ( rule__JsonObject__Group_3__0__Impl rule__JsonObject__Group_3__1 )
            // InternalAceGen.g:6753:2: rule__JsonObject__Group_3__0__Impl rule__JsonObject__Group_3__1
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
    // InternalAceGen.g:6760:1: rule__JsonObject__Group_3__0__Impl : ( ',' ) ;
    public final void rule__JsonObject__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6764:1: ( ( ',' ) )
            // InternalAceGen.g:6765:1: ( ',' )
            {
            // InternalAceGen.g:6765:1: ( ',' )
            // InternalAceGen.g:6766:2: ','
            {
             before(grammarAccess.getJsonObjectAccess().getCommaKeyword_3_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalAceGen.g:6775:1: rule__JsonObject__Group_3__1 : rule__JsonObject__Group_3__1__Impl ;
    public final void rule__JsonObject__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6779:1: ( rule__JsonObject__Group_3__1__Impl )
            // InternalAceGen.g:6780:2: rule__JsonObject__Group_3__1__Impl
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
    // InternalAceGen.g:6786:1: rule__JsonObject__Group_3__1__Impl : ( ( rule__JsonObject__MembersAssignment_3_1 ) ) ;
    public final void rule__JsonObject__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6790:1: ( ( ( rule__JsonObject__MembersAssignment_3_1 ) ) )
            // InternalAceGen.g:6791:1: ( ( rule__JsonObject__MembersAssignment_3_1 ) )
            {
            // InternalAceGen.g:6791:1: ( ( rule__JsonObject__MembersAssignment_3_1 ) )
            // InternalAceGen.g:6792:2: ( rule__JsonObject__MembersAssignment_3_1 )
            {
             before(grammarAccess.getJsonObjectAccess().getMembersAssignment_3_1()); 
            // InternalAceGen.g:6793:2: ( rule__JsonObject__MembersAssignment_3_1 )
            // InternalAceGen.g:6793:3: rule__JsonObject__MembersAssignment_3_1
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
    // InternalAceGen.g:6802:1: rule__JsonMember__Group__0 : rule__JsonMember__Group__0__Impl rule__JsonMember__Group__1 ;
    public final void rule__JsonMember__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6806:1: ( rule__JsonMember__Group__0__Impl rule__JsonMember__Group__1 )
            // InternalAceGen.g:6807:2: rule__JsonMember__Group__0__Impl rule__JsonMember__Group__1
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
    // InternalAceGen.g:6814:1: rule__JsonMember__Group__0__Impl : ( ( rule__JsonMember__AttributeAssignment_0 ) ) ;
    public final void rule__JsonMember__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6818:1: ( ( ( rule__JsonMember__AttributeAssignment_0 ) ) )
            // InternalAceGen.g:6819:1: ( ( rule__JsonMember__AttributeAssignment_0 ) )
            {
            // InternalAceGen.g:6819:1: ( ( rule__JsonMember__AttributeAssignment_0 ) )
            // InternalAceGen.g:6820:2: ( rule__JsonMember__AttributeAssignment_0 )
            {
             before(grammarAccess.getJsonMemberAccess().getAttributeAssignment_0()); 
            // InternalAceGen.g:6821:2: ( rule__JsonMember__AttributeAssignment_0 )
            // InternalAceGen.g:6821:3: rule__JsonMember__AttributeAssignment_0
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
    // InternalAceGen.g:6829:1: rule__JsonMember__Group__1 : rule__JsonMember__Group__1__Impl rule__JsonMember__Group__2 ;
    public final void rule__JsonMember__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6833:1: ( rule__JsonMember__Group__1__Impl rule__JsonMember__Group__2 )
            // InternalAceGen.g:6834:2: rule__JsonMember__Group__1__Impl rule__JsonMember__Group__2
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
    // InternalAceGen.g:6841:1: rule__JsonMember__Group__1__Impl : ( ':' ) ;
    public final void rule__JsonMember__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6845:1: ( ( ':' ) )
            // InternalAceGen.g:6846:1: ( ':' )
            {
            // InternalAceGen.g:6846:1: ( ':' )
            // InternalAceGen.g:6847:2: ':'
            {
             before(grammarAccess.getJsonMemberAccess().getColonKeyword_1()); 
            match(input,44,FOLLOW_2); 
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
    // InternalAceGen.g:6856:1: rule__JsonMember__Group__2 : rule__JsonMember__Group__2__Impl ;
    public final void rule__JsonMember__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6860:1: ( rule__JsonMember__Group__2__Impl )
            // InternalAceGen.g:6861:2: rule__JsonMember__Group__2__Impl
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
    // InternalAceGen.g:6867:1: rule__JsonMember__Group__2__Impl : ( ( rule__JsonMember__ValueAssignment_2 ) ) ;
    public final void rule__JsonMember__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6871:1: ( ( ( rule__JsonMember__ValueAssignment_2 ) ) )
            // InternalAceGen.g:6872:1: ( ( rule__JsonMember__ValueAssignment_2 ) )
            {
            // InternalAceGen.g:6872:1: ( ( rule__JsonMember__ValueAssignment_2 ) )
            // InternalAceGen.g:6873:2: ( rule__JsonMember__ValueAssignment_2 )
            {
             before(grammarAccess.getJsonMemberAccess().getValueAssignment_2()); 
            // InternalAceGen.g:6874:2: ( rule__JsonMember__ValueAssignment_2 )
            // InternalAceGen.g:6874:3: rule__JsonMember__ValueAssignment_2
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
    // InternalAceGen.g:6883:1: rule__JsonArray__Group__0 : rule__JsonArray__Group__0__Impl rule__JsonArray__Group__1 ;
    public final void rule__JsonArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6887:1: ( rule__JsonArray__Group__0__Impl rule__JsonArray__Group__1 )
            // InternalAceGen.g:6888:2: rule__JsonArray__Group__0__Impl rule__JsonArray__Group__1
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
    // InternalAceGen.g:6895:1: rule__JsonArray__Group__0__Impl : ( () ) ;
    public final void rule__JsonArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6899:1: ( ( () ) )
            // InternalAceGen.g:6900:1: ( () )
            {
            // InternalAceGen.g:6900:1: ( () )
            // InternalAceGen.g:6901:2: ()
            {
             before(grammarAccess.getJsonArrayAccess().getJsonArrayAction_0()); 
            // InternalAceGen.g:6902:2: ()
            // InternalAceGen.g:6902:3: 
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
    // InternalAceGen.g:6910:1: rule__JsonArray__Group__1 : rule__JsonArray__Group__1__Impl rule__JsonArray__Group__2 ;
    public final void rule__JsonArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6914:1: ( rule__JsonArray__Group__1__Impl rule__JsonArray__Group__2 )
            // InternalAceGen.g:6915:2: rule__JsonArray__Group__1__Impl rule__JsonArray__Group__2
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
    // InternalAceGen.g:6922:1: rule__JsonArray__Group__1__Impl : ( '[' ) ;
    public final void rule__JsonArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6926:1: ( ( '[' ) )
            // InternalAceGen.g:6927:1: ( '[' )
            {
            // InternalAceGen.g:6927:1: ( '[' )
            // InternalAceGen.g:6928:2: '['
            {
             before(grammarAccess.getJsonArrayAccess().getLeftSquareBracketKeyword_1()); 
            match(input,66,FOLLOW_2); 
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
    // InternalAceGen.g:6937:1: rule__JsonArray__Group__2 : rule__JsonArray__Group__2__Impl rule__JsonArray__Group__3 ;
    public final void rule__JsonArray__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6941:1: ( rule__JsonArray__Group__2__Impl rule__JsonArray__Group__3 )
            // InternalAceGen.g:6942:2: rule__JsonArray__Group__2__Impl rule__JsonArray__Group__3
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
    // InternalAceGen.g:6949:1: rule__JsonArray__Group__2__Impl : ( ( rule__JsonArray__ValuesAssignment_2 )? ) ;
    public final void rule__JsonArray__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6953:1: ( ( ( rule__JsonArray__ValuesAssignment_2 )? ) )
            // InternalAceGen.g:6954:1: ( ( rule__JsonArray__ValuesAssignment_2 )? )
            {
            // InternalAceGen.g:6954:1: ( ( rule__JsonArray__ValuesAssignment_2 )? )
            // InternalAceGen.g:6955:2: ( rule__JsonArray__ValuesAssignment_2 )?
            {
             before(grammarAccess.getJsonArrayAccess().getValuesAssignment_2()); 
            // InternalAceGen.g:6956:2: ( rule__JsonArray__ValuesAssignment_2 )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( ((LA93_0>=RULE_STRING && LA93_0<=RULE_INT)||LA93_0==12||(LA93_0>=28 && LA93_0<=29)||LA93_0==45||LA93_0==66) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalAceGen.g:6956:3: rule__JsonArray__ValuesAssignment_2
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
    // InternalAceGen.g:6964:1: rule__JsonArray__Group__3 : rule__JsonArray__Group__3__Impl rule__JsonArray__Group__4 ;
    public final void rule__JsonArray__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6968:1: ( rule__JsonArray__Group__3__Impl rule__JsonArray__Group__4 )
            // InternalAceGen.g:6969:2: rule__JsonArray__Group__3__Impl rule__JsonArray__Group__4
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
    // InternalAceGen.g:6976:1: rule__JsonArray__Group__3__Impl : ( ( rule__JsonArray__Group_3__0 )* ) ;
    public final void rule__JsonArray__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6980:1: ( ( ( rule__JsonArray__Group_3__0 )* ) )
            // InternalAceGen.g:6981:1: ( ( rule__JsonArray__Group_3__0 )* )
            {
            // InternalAceGen.g:6981:1: ( ( rule__JsonArray__Group_3__0 )* )
            // InternalAceGen.g:6982:2: ( rule__JsonArray__Group_3__0 )*
            {
             before(grammarAccess.getJsonArrayAccess().getGroup_3()); 
            // InternalAceGen.g:6983:2: ( rule__JsonArray__Group_3__0 )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==36) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalAceGen.g:6983:3: rule__JsonArray__Group_3__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__JsonArray__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop94;
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
    // InternalAceGen.g:6991:1: rule__JsonArray__Group__4 : rule__JsonArray__Group__4__Impl ;
    public final void rule__JsonArray__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6995:1: ( rule__JsonArray__Group__4__Impl )
            // InternalAceGen.g:6996:2: rule__JsonArray__Group__4__Impl
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
    // InternalAceGen.g:7002:1: rule__JsonArray__Group__4__Impl : ( ']' ) ;
    public final void rule__JsonArray__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7006:1: ( ( ']' ) )
            // InternalAceGen.g:7007:1: ( ']' )
            {
            // InternalAceGen.g:7007:1: ( ']' )
            // InternalAceGen.g:7008:2: ']'
            {
             before(grammarAccess.getJsonArrayAccess().getRightSquareBracketKeyword_4()); 
            match(input,67,FOLLOW_2); 
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
    // InternalAceGen.g:7018:1: rule__JsonArray__Group_3__0 : rule__JsonArray__Group_3__0__Impl rule__JsonArray__Group_3__1 ;
    public final void rule__JsonArray__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7022:1: ( rule__JsonArray__Group_3__0__Impl rule__JsonArray__Group_3__1 )
            // InternalAceGen.g:7023:2: rule__JsonArray__Group_3__0__Impl rule__JsonArray__Group_3__1
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
    // InternalAceGen.g:7030:1: rule__JsonArray__Group_3__0__Impl : ( ',' ) ;
    public final void rule__JsonArray__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7034:1: ( ( ',' ) )
            // InternalAceGen.g:7035:1: ( ',' )
            {
            // InternalAceGen.g:7035:1: ( ',' )
            // InternalAceGen.g:7036:2: ','
            {
             before(grammarAccess.getJsonArrayAccess().getCommaKeyword_3_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalAceGen.g:7045:1: rule__JsonArray__Group_3__1 : rule__JsonArray__Group_3__1__Impl ;
    public final void rule__JsonArray__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7049:1: ( rule__JsonArray__Group_3__1__Impl )
            // InternalAceGen.g:7050:2: rule__JsonArray__Group_3__1__Impl
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
    // InternalAceGen.g:7056:1: rule__JsonArray__Group_3__1__Impl : ( ( rule__JsonArray__ValuesAssignment_3_1 ) ) ;
    public final void rule__JsonArray__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7060:1: ( ( ( rule__JsonArray__ValuesAssignment_3_1 ) ) )
            // InternalAceGen.g:7061:1: ( ( rule__JsonArray__ValuesAssignment_3_1 ) )
            {
            // InternalAceGen.g:7061:1: ( ( rule__JsonArray__ValuesAssignment_3_1 ) )
            // InternalAceGen.g:7062:2: ( rule__JsonArray__ValuesAssignment_3_1 )
            {
             before(grammarAccess.getJsonArrayAccess().getValuesAssignment_3_1()); 
            // InternalAceGen.g:7063:2: ( rule__JsonArray__ValuesAssignment_3_1 )
            // InternalAceGen.g:7063:3: rule__JsonArray__ValuesAssignment_3_1
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
    // InternalAceGen.g:7072:1: rule__Project__HttpClientAssignment_1_0_1 : ( ruleHttpClient ) ;
    public final void rule__Project__HttpClientAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7076:1: ( ( ruleHttpClient ) )
            // InternalAceGen.g:7077:2: ( ruleHttpClient )
            {
            // InternalAceGen.g:7077:2: ( ruleHttpClient )
            // InternalAceGen.g:7078:3: ruleHttpClient
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
    // InternalAceGen.g:7087:1: rule__Project__HttpServerAssignment_1_1_1 : ( ruleHttpServer ) ;
    public final void rule__Project__HttpServerAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7091:1: ( ( ruleHttpServer ) )
            // InternalAceGen.g:7092:2: ( ruleHttpServer )
            {
            // InternalAceGen.g:7092:2: ( ruleHttpServer )
            // InternalAceGen.g:7093:3: ruleHttpServer
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
    // InternalAceGen.g:7102:1: rule__HttpClient__NameAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__HttpClient__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7106:1: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7107:2: ( ruleQualifiedName )
            {
            // InternalAceGen.g:7107:2: ( ruleQualifiedName )
            // InternalAceGen.g:7108:3: ruleQualifiedName
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
    // InternalAceGen.g:7117:1: rule__HttpClient__AceOperationsAssignment_1_1 : ( ruleHttpClientAce ) ;
    public final void rule__HttpClient__AceOperationsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7121:1: ( ( ruleHttpClientAce ) )
            // InternalAceGen.g:7122:2: ( ruleHttpClientAce )
            {
            // InternalAceGen.g:7122:2: ( ruleHttpClientAce )
            // InternalAceGen.g:7123:3: ruleHttpClientAce
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
    // InternalAceGen.g:7132:1: rule__HttpClient__AppStateAssignment_2_1 : ( ruleHttpClientStateElement ) ;
    public final void rule__HttpClient__AppStateAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7136:1: ( ( ruleHttpClientStateElement ) )
            // InternalAceGen.g:7137:2: ( ruleHttpClientStateElement )
            {
            // InternalAceGen.g:7137:2: ( ruleHttpClientStateElement )
            // InternalAceGen.g:7138:3: ruleHttpClientStateElement
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
    // InternalAceGen.g:7147:1: rule__HttpClientAce__AsyncAssignment_0 : ( ( 'async' ) ) ;
    public final void rule__HttpClientAce__AsyncAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7151:1: ( ( ( 'async' ) ) )
            // InternalAceGen.g:7152:2: ( ( 'async' ) )
            {
            // InternalAceGen.g:7152:2: ( ( 'async' ) )
            // InternalAceGen.g:7153:3: ( 'async' )
            {
             before(grammarAccess.getHttpClientAceAccess().getAsyncAsyncKeyword_0_0()); 
            // InternalAceGen.g:7154:3: ( 'async' )
            // InternalAceGen.g:7155:4: 'async'
            {
             before(grammarAccess.getHttpClientAceAccess().getAsyncAsyncKeyword_0_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalAceGen.g:7166:1: rule__HttpClientAce__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7170:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7171:2: ( RULE_ID )
            {
            // InternalAceGen.g:7171:2: ( RULE_ID )
            // InternalAceGen.g:7172:3: RULE_ID
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
    // InternalAceGen.g:7181:1: rule__HttpClientAce__InputAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__InputAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7185:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7186:2: ( RULE_ID )
            {
            // InternalAceGen.g:7186:2: ( RULE_ID )
            // InternalAceGen.g:7187:3: RULE_ID
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
    // InternalAceGen.g:7196:1: rule__HttpClientAce__InputAssignment_2_2_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__InputAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7200:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7201:2: ( RULE_ID )
            {
            // InternalAceGen.g:7201:2: ( RULE_ID )
            // InternalAceGen.g:7202:3: RULE_ID
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
    // InternalAceGen.g:7211:1: rule__HttpClientAce__ServerCallAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientAce__ServerCallAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7215:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7216:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7216:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7217:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceCrossReference_3_1_0()); 
            // InternalAceGen.g:7218:3: ( ruleQualifiedName )
            // InternalAceGen.g:7219:4: ruleQualifiedName
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
    // InternalAceGen.g:7230:1: rule__HttpClientAce__LoadingFlagAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientAce__LoadingFlagAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7234:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7235:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7235:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7236:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementCrossReference_4_1_0()); 
            // InternalAceGen.g:7237:3: ( ruleQualifiedName )
            // InternalAceGen.g:7238:4: ruleQualifiedName
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
    // InternalAceGen.g:7249:1: rule__HttpClientAce__OutcomesAssignment_5 : ( ruleHttpClientOutcome ) ;
    public final void rule__HttpClientAce__OutcomesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7253:1: ( ( ruleHttpClientOutcome ) )
            // InternalAceGen.g:7254:2: ( ruleHttpClientOutcome )
            {
            // InternalAceGen.g:7254:2: ( ruleHttpClientOutcome )
            // InternalAceGen.g:7255:3: ruleHttpClientOutcome
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
    // InternalAceGen.g:7264:1: rule__HttpClientOutcome__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientOutcome__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7268:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7269:2: ( RULE_ID )
            {
            // InternalAceGen.g:7269:2: ( RULE_ID )
            // InternalAceGen.g:7270:3: RULE_ID
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
    // InternalAceGen.g:7279:1: rule__HttpClientOutcome__ListenersAssignment_2_1 : ( ruleHttpClientStateFunction ) ;
    public final void rule__HttpClientOutcome__ListenersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7283:1: ( ( ruleHttpClientStateFunction ) )
            // InternalAceGen.g:7284:2: ( ruleHttpClientStateFunction )
            {
            // InternalAceGen.g:7284:2: ( ruleHttpClientStateFunction )
            // InternalAceGen.g:7285:3: ruleHttpClientStateFunction
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
    // InternalAceGen.g:7294:1: rule__HttpClientOutcome__AceOperationsAssignment_3_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientOutcome__AceOperationsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7298:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7299:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7299:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7300:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsHttpClientAceCrossReference_3_2_0()); 
            // InternalAceGen.g:7301:3: ( ruleQualifiedName )
            // InternalAceGen.g:7302:4: ruleQualifiedName
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
    // InternalAceGen.g:7313:1: rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 : ( ruleHttpClientStateFunctionType ) ;
    public final void rule__HttpClientStateFunction__StateFunctionTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7317:1: ( ( ruleHttpClientStateFunctionType ) )
            // InternalAceGen.g:7318:2: ( ruleHttpClientStateFunctionType )
            {
            // InternalAceGen.g:7318:2: ( ruleHttpClientStateFunctionType )
            // InternalAceGen.g:7319:3: ruleHttpClientStateFunctionType
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
    // InternalAceGen.g:7328:1: rule__HttpClientStateFunction__AttributeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientStateFunction__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7332:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7333:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7333:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7334:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getAttributeHttpClientStateElementCrossReference_1_0()); 
            // InternalAceGen.g:7335:3: ( ruleQualifiedName )
            // InternalAceGen.g:7336:4: ruleQualifiedName
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
    // InternalAceGen.g:7347:1: rule__HttpClientStateElement__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpClientStateElement__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7351:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7352:2: ( RULE_ID )
            {
            // InternalAceGen.g:7352:2: ( RULE_ID )
            // InternalAceGen.g:7353:3: RULE_ID
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
    // InternalAceGen.g:7362:1: rule__HttpClientStateElement__ListAssignment_1 : ( ( 'list' ) ) ;
    public final void rule__HttpClientStateElement__ListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7366:1: ( ( ( 'list' ) ) )
            // InternalAceGen.g:7367:2: ( ( 'list' ) )
            {
            // InternalAceGen.g:7367:2: ( ( 'list' ) )
            // InternalAceGen.g:7368:3: ( 'list' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 
            // InternalAceGen.g:7369:3: ( 'list' )
            // InternalAceGen.g:7370:4: 'list'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 
            match(input,69,FOLLOW_2); 
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
    // InternalAceGen.g:7381:1: rule__HttpClientStateElement__HashAssignment_2 : ( ( 'location.hash' ) ) ;
    public final void rule__HttpClientStateElement__HashAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7385:1: ( ( ( 'location.hash' ) ) )
            // InternalAceGen.g:7386:2: ( ( 'location.hash' ) )
            {
            // InternalAceGen.g:7386:2: ( ( 'location.hash' ) )
            // InternalAceGen.g:7387:3: ( 'location.hash' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 
            // InternalAceGen.g:7388:3: ( 'location.hash' )
            // InternalAceGen.g:7389:4: 'location.hash'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 
            match(input,70,FOLLOW_2); 
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
    // InternalAceGen.g:7400:1: rule__HttpClientStateElement__StorageAssignment_3 : ( ( 'storage' ) ) ;
    public final void rule__HttpClientStateElement__StorageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7404:1: ( ( ( 'storage' ) ) )
            // InternalAceGen.g:7405:2: ( ( 'storage' ) )
            {
            // InternalAceGen.g:7405:2: ( ( 'storage' ) )
            // InternalAceGen.g:7406:3: ( 'storage' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 
            // InternalAceGen.g:7407:3: ( 'storage' )
            // InternalAceGen.g:7408:4: 'storage'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 
            match(input,71,FOLLOW_2); 
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
    // InternalAceGen.g:7419:1: rule__HttpClientStateElement__TypesAssignment_4_0 : ( ruleHttpClientTypeDefinition ) ;
    public final void rule__HttpClientStateElement__TypesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7423:1: ( ( ruleHttpClientTypeDefinition ) )
            // InternalAceGen.g:7424:2: ( ruleHttpClientTypeDefinition )
            {
            // InternalAceGen.g:7424:2: ( ruleHttpClientTypeDefinition )
            // InternalAceGen.g:7425:3: ruleHttpClientTypeDefinition
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
    // InternalAceGen.g:7434:1: rule__HttpClientStateElement__TypesAssignment_4_1_1 : ( ruleHttpClientTypeDefinition ) ;
    public final void rule__HttpClientStateElement__TypesAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7438:1: ( ( ruleHttpClientTypeDefinition ) )
            // InternalAceGen.g:7439:2: ( ruleHttpClientTypeDefinition )
            {
            // InternalAceGen.g:7439:2: ( ruleHttpClientTypeDefinition )
            // InternalAceGen.g:7440:3: ruleHttpClientTypeDefinition
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
    // InternalAceGen.g:7449:1: rule__HttpClientTypeDefinition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientTypeDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7453:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7454:2: ( RULE_ID )
            {
            // InternalAceGen.g:7454:2: ( RULE_ID )
            // InternalAceGen.g:7455:3: RULE_ID
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
    // InternalAceGen.g:7464:1: rule__HttpClientTypeDefinition__ElementsAssignment_3 : ( ruleHttpClientStateElement ) ;
    public final void rule__HttpClientTypeDefinition__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7468:1: ( ( ruleHttpClientStateElement ) )
            // InternalAceGen.g:7469:2: ( ruleHttpClientStateElement )
            {
            // InternalAceGen.g:7469:2: ( ruleHttpClientStateElement )
            // InternalAceGen.g:7470:3: ruleHttpClientStateElement
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
    // InternalAceGen.g:7479:1: rule__HttpServer__TypeAssignment_0 : ( ( rule__HttpServer__TypeAlternatives_0_0 ) ) ;
    public final void rule__HttpServer__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7483:1: ( ( ( rule__HttpServer__TypeAlternatives_0_0 ) ) )
            // InternalAceGen.g:7484:2: ( ( rule__HttpServer__TypeAlternatives_0_0 ) )
            {
            // InternalAceGen.g:7484:2: ( ( rule__HttpServer__TypeAlternatives_0_0 ) )
            // InternalAceGen.g:7485:3: ( rule__HttpServer__TypeAlternatives_0_0 )
            {
             before(grammarAccess.getHttpServerAccess().getTypeAlternatives_0_0()); 
            // InternalAceGen.g:7486:3: ( rule__HttpServer__TypeAlternatives_0_0 )
            // InternalAceGen.g:7486:4: rule__HttpServer__TypeAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__TypeAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getHttpServerAccess().getTypeAlternatives_0_0()); 

            }


            }

        }
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
    // InternalAceGen.g:7494:1: rule__HttpServer__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__HttpServer__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7498:1: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7499:2: ( ruleQualifiedName )
            {
            // InternalAceGen.g:7499:2: ( ruleQualifiedName )
            // InternalAceGen.g:7500:3: ruleQualifiedName
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
    // InternalAceGen.g:7509:1: rule__HttpServer__AuthUserAssignment_2_1 : ( ruleAuthUser ) ;
    public final void rule__HttpServer__AuthUserAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7513:1: ( ( ruleAuthUser ) )
            // InternalAceGen.g:7514:2: ( ruleAuthUser )
            {
            // InternalAceGen.g:7514:2: ( ruleAuthUser )
            // InternalAceGen.g:7515:3: ruleAuthUser
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
    // InternalAceGen.g:7524:1: rule__HttpServer__AuthUserRefAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServer__AuthUserRefAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7528:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7529:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7529:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7530:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_3_1_0()); 
            // InternalAceGen.g:7531:3: ( ruleQualifiedName )
            // InternalAceGen.g:7532:4: ruleQualifiedName
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
    // InternalAceGen.g:7543:1: rule__HttpServer__AceOperationsAssignment_4_1 : ( ruleHttpServerAce ) ;
    public final void rule__HttpServer__AceOperationsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7547:1: ( ( ruleHttpServerAce ) )
            // InternalAceGen.g:7548:2: ( ruleHttpServerAce )
            {
            // InternalAceGen.g:7548:2: ( ruleHttpServerAce )
            // InternalAceGen.g:7549:3: ruleHttpServerAce
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
    // InternalAceGen.g:7558:1: rule__HttpServer__ViewsAssignment_5_1 : ( ruleHttpServerView ) ;
    public final void rule__HttpServer__ViewsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7562:1: ( ( ruleHttpServerView ) )
            // InternalAceGen.g:7563:2: ( ruleHttpServerView )
            {
            // InternalAceGen.g:7563:2: ( ruleHttpServerView )
            // InternalAceGen.g:7564:3: ruleHttpServerView
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
    // InternalAceGen.g:7573:1: rule__HttpServer__ModelsAssignment_6_1 : ( ruleModel ) ;
    public final void rule__HttpServer__ModelsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7577:1: ( ( ruleModel ) )
            // InternalAceGen.g:7578:2: ( ruleModel )
            {
            // InternalAceGen.g:7578:2: ( ruleModel )
            // InternalAceGen.g:7579:3: ruleModel
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
    // InternalAceGen.g:7588:1: rule__HttpServer__ScenariosAssignment_7_1 : ( ruleScenario ) ;
    public final void rule__HttpServer__ScenariosAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7592:1: ( ( ruleScenario ) )
            // InternalAceGen.g:7593:2: ( ruleScenario )
            {
            // InternalAceGen.g:7593:2: ( ruleScenario )
            // InternalAceGen.g:7594:3: ruleScenario
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
    // InternalAceGen.g:7603:1: rule__HttpServerAceWrite__ProxyAssignment_0 : ( ( 'proxy' ) ) ;
    public final void rule__HttpServerAceWrite__ProxyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7607:1: ( ( ( 'proxy' ) ) )
            // InternalAceGen.g:7608:2: ( ( 'proxy' ) )
            {
            // InternalAceGen.g:7608:2: ( ( 'proxy' ) )
            // InternalAceGen.g:7609:3: ( 'proxy' )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 
            // InternalAceGen.g:7610:3: ( 'proxy' )
            // InternalAceGen.g:7611:4: 'proxy'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 
            match(input,72,FOLLOW_2); 
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
    // InternalAceGen.g:7622:1: rule__HttpServerAceWrite__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerAceWrite__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7626:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7627:2: ( RULE_ID )
            {
            // InternalAceGen.g:7627:2: ( RULE_ID )
            // InternalAceGen.g:7628:3: RULE_ID
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
    // InternalAceGen.g:7637:1: rule__HttpServerAceWrite__ModelAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7641:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7642:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7642:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7643:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_3_0()); 
            // InternalAceGen.g:7644:3: ( ruleQualifiedName )
            // InternalAceGen.g:7645:4: ruleQualifiedName
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
    // InternalAceGen.g:7656:1: rule__HttpServerAceWrite__TypeAssignment_5 : ( ruleWriteFunctionType ) ;
    public final void rule__HttpServerAceWrite__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7660:1: ( ( ruleWriteFunctionType ) )
            // InternalAceGen.g:7661:2: ( ruleWriteFunctionType )
            {
            // InternalAceGen.g:7661:2: ( ruleWriteFunctionType )
            // InternalAceGen.g:7662:3: ruleWriteFunctionType
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
    // InternalAceGen.g:7671:1: rule__HttpServerAceWrite__UrlAssignment_6 : ( RULE_STRING ) ;
    public final void rule__HttpServerAceWrite__UrlAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7675:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7676:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7676:2: ( RULE_STRING )
            // InternalAceGen.g:7677:3: RULE_STRING
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
    // InternalAceGen.g:7686:1: rule__HttpServerAceWrite__AuthorizeAssignment_7 : ( ( 'authorize' ) ) ;
    public final void rule__HttpServerAceWrite__AuthorizeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7690:1: ( ( ( 'authorize' ) ) )
            // InternalAceGen.g:7691:2: ( ( 'authorize' ) )
            {
            // InternalAceGen.g:7691:2: ( ( 'authorize' ) )
            // InternalAceGen.g:7692:3: ( 'authorize' )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            // InternalAceGen.g:7693:3: ( 'authorize' )
            // InternalAceGen.g:7694:4: 'authorize'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            match(input,73,FOLLOW_2); 
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
    // InternalAceGen.g:7705:1: rule__HttpServerAceWrite__PathParamsAssignment_8_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceWrite__PathParamsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7709:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7710:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7710:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7711:3: ruleAttributeParamRef
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
    // InternalAceGen.g:7720:1: rule__HttpServerAceWrite__QueryParamsAssignment_9_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceWrite__QueryParamsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7724:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7725:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7725:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7726:3: ruleAttributeParamRef
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
    // InternalAceGen.g:7735:1: rule__HttpServerAceWrite__PayloadAssignment_10_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceWrite__PayloadAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7739:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7740:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7740:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7741:3: ruleAttributeParamRef
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
    // InternalAceGen.g:7750:1: rule__HttpServerAceWrite__ResponseAssignment_11_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__ResponseAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7754:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7755:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7755:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7756:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeCrossReference_11_1_0()); 
            // InternalAceGen.g:7757:3: ( ruleQualifiedName )
            // InternalAceGen.g:7758:4: ruleQualifiedName
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
    // InternalAceGen.g:7769:1: rule__HttpServerAceWrite__OutcomesAssignment_12 : ( ruleHttpServerOutcome ) ;
    public final void rule__HttpServerAceWrite__OutcomesAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7773:1: ( ( ruleHttpServerOutcome ) )
            // InternalAceGen.g:7774:2: ( ruleHttpServerOutcome )
            {
            // InternalAceGen.g:7774:2: ( ruleHttpServerOutcome )
            // InternalAceGen.g:7775:3: ruleHttpServerOutcome
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
    // InternalAceGen.g:7784:1: rule__HttpServerOutcome__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerOutcome__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7788:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7789:2: ( RULE_ID )
            {
            // InternalAceGen.g:7789:2: ( RULE_ID )
            // InternalAceGen.g:7790:3: RULE_ID
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
    // InternalAceGen.g:7799:1: rule__HttpServerOutcome__ListenersAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerOutcome__ListenersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7803:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7804:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7804:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7805:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0()); 
            // InternalAceGen.g:7806:3: ( ruleQualifiedName )
            // InternalAceGen.g:7807:4: ruleQualifiedName
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
    // InternalAceGen.g:7818:1: rule__HttpServerAceRead__ProxyAssignment_0 : ( ( 'proxy' ) ) ;
    public final void rule__HttpServerAceRead__ProxyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7822:1: ( ( ( 'proxy' ) ) )
            // InternalAceGen.g:7823:2: ( ( 'proxy' ) )
            {
            // InternalAceGen.g:7823:2: ( ( 'proxy' ) )
            // InternalAceGen.g:7824:3: ( 'proxy' )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 
            // InternalAceGen.g:7825:3: ( 'proxy' )
            // InternalAceGen.g:7826:4: 'proxy'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 
            match(input,72,FOLLOW_2); 
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
    // InternalAceGen.g:7837:1: rule__HttpServerAceRead__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerAceRead__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7841:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7842:2: ( RULE_ID )
            {
            // InternalAceGen.g:7842:2: ( RULE_ID )
            // InternalAceGen.g:7843:3: RULE_ID
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
    // InternalAceGen.g:7852:1: rule__HttpServerAceRead__ModelAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7856:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7857:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7857:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7858:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_3_0()); 
            // InternalAceGen.g:7859:3: ( ruleQualifiedName )
            // InternalAceGen.g:7860:4: ruleQualifiedName
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
    // InternalAceGen.g:7871:1: rule__HttpServerAceRead__TypeAssignment_5 : ( ruleReadFunctionType ) ;
    public final void rule__HttpServerAceRead__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7875:1: ( ( ruleReadFunctionType ) )
            // InternalAceGen.g:7876:2: ( ruleReadFunctionType )
            {
            // InternalAceGen.g:7876:2: ( ruleReadFunctionType )
            // InternalAceGen.g:7877:3: ruleReadFunctionType
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
    // InternalAceGen.g:7886:1: rule__HttpServerAceRead__UrlAssignment_6 : ( RULE_STRING ) ;
    public final void rule__HttpServerAceRead__UrlAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7890:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7891:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7891:2: ( RULE_STRING )
            // InternalAceGen.g:7892:3: RULE_STRING
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
    // InternalAceGen.g:7901:1: rule__HttpServerAceRead__AuthorizeAssignment_7 : ( ( 'authorize' ) ) ;
    public final void rule__HttpServerAceRead__AuthorizeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7905:1: ( ( ( 'authorize' ) ) )
            // InternalAceGen.g:7906:2: ( ( 'authorize' ) )
            {
            // InternalAceGen.g:7906:2: ( ( 'authorize' ) )
            // InternalAceGen.g:7907:3: ( 'authorize' )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            // InternalAceGen.g:7908:3: ( 'authorize' )
            // InternalAceGen.g:7909:4: 'authorize'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            match(input,73,FOLLOW_2); 
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
    // InternalAceGen.g:7920:1: rule__HttpServerAceRead__PathParamsAssignment_8_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceRead__PathParamsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7924:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7925:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7925:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7926:3: ruleAttributeParamRef
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
    // InternalAceGen.g:7935:1: rule__HttpServerAceRead__QueryParamsAssignment_9_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceRead__QueryParamsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7939:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7940:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7940:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7941:3: ruleAttributeParamRef
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
    // InternalAceGen.g:7950:1: rule__HttpServerAceRead__PayloadAssignment_10_1 : ( ruleAttributeParamRef ) ;
    public final void rule__HttpServerAceRead__PayloadAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7954:1: ( ( ruleAttributeParamRef ) )
            // InternalAceGen.g:7955:2: ( ruleAttributeParamRef )
            {
            // InternalAceGen.g:7955:2: ( ruleAttributeParamRef )
            // InternalAceGen.g:7956:3: ruleAttributeParamRef
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
    // InternalAceGen.g:7965:1: rule__HttpServerAceRead__ResponseAssignment_11_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__ResponseAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7969:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7970:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7970:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7971:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseAttributeCrossReference_11_1_0()); 
            // InternalAceGen.g:7972:3: ( ruleQualifiedName )
            // InternalAceGen.g:7973:4: ruleQualifiedName
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
    // InternalAceGen.g:7984:1: rule__AttributeParamRef__AttributeAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__AttributeParamRef__AttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7988:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7989:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7989:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7990:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeParamRefAccess().getAttributeAttributeCrossReference_0_0()); 
            // InternalAceGen.g:7991:3: ( ruleQualifiedName )
            // InternalAceGen.g:7992:4: ruleQualifiedName
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
    // InternalAceGen.g:8003:1: rule__AttributeParamRef__OptionalAssignment_1 : ( ( 'optional' ) ) ;
    public final void rule__AttributeParamRef__OptionalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8007:1: ( ( ( 'optional' ) ) )
            // InternalAceGen.g:8008:2: ( ( 'optional' ) )
            {
            // InternalAceGen.g:8008:2: ( ( 'optional' ) )
            // InternalAceGen.g:8009:3: ( 'optional' )
            {
             before(grammarAccess.getAttributeParamRefAccess().getOptionalOptionalKeyword_1_0()); 
            // InternalAceGen.g:8010:3: ( 'optional' )
            // InternalAceGen.g:8011:4: 'optional'
            {
             before(grammarAccess.getAttributeParamRefAccess().getOptionalOptionalKeyword_1_0()); 
            match(input,74,FOLLOW_2); 
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
    // InternalAceGen.g:8022:1: rule__HttpServerView__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpServerView__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8026:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8027:2: ( RULE_ID )
            {
            // InternalAceGen.g:8027:2: ( RULE_ID )
            // InternalAceGen.g:8028:3: RULE_ID
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
    // InternalAceGen.g:8037:1: rule__HttpServerView__RenderFunctionsAssignment_1_1 : ( ruleHttpServerViewFunction ) ;
    public final void rule__HttpServerView__RenderFunctionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8041:1: ( ( ruleHttpServerViewFunction ) )
            // InternalAceGen.g:8042:2: ( ruleHttpServerViewFunction )
            {
            // InternalAceGen.g:8042:2: ( ruleHttpServerViewFunction )
            // InternalAceGen.g:8043:3: ruleHttpServerViewFunction
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
    // InternalAceGen.g:8052:1: rule__HttpServerViewFunction__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpServerViewFunction__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8056:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8057:2: ( RULE_ID )
            {
            // InternalAceGen.g:8057:2: ( RULE_ID )
            // InternalAceGen.g:8058:3: RULE_ID
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
    // InternalAceGen.g:8067:1: rule__HttpServerViewFunction__ModelAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerViewFunction__ModelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8071:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8072:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8072:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8073:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0()); 
            // InternalAceGen.g:8074:3: ( ruleQualifiedName )
            // InternalAceGen.g:8075:4: ruleQualifiedName
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
    // InternalAceGen.g:8086:1: rule__AuthUser__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__AuthUser__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8090:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8091:2: ( RULE_ID )
            {
            // InternalAceGen.g:8091:2: ( RULE_ID )
            // InternalAceGen.g:8092:3: RULE_ID
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
    // InternalAceGen.g:8101:1: rule__AuthUser__AttributesAssignment_1_1 : ( ruleAttribute ) ;
    public final void rule__AuthUser__AttributesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8105:1: ( ( ruleAttribute ) )
            // InternalAceGen.g:8106:2: ( ruleAttribute )
            {
            // InternalAceGen.g:8106:2: ( ruleAttribute )
            // InternalAceGen.g:8107:3: ruleAttribute
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
    // InternalAceGen.g:8116:1: rule__Model__PersistentAssignment_0 : ( ( 'persistent' ) ) ;
    public final void rule__Model__PersistentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8120:1: ( ( ( 'persistent' ) ) )
            // InternalAceGen.g:8121:2: ( ( 'persistent' ) )
            {
            // InternalAceGen.g:8121:2: ( ( 'persistent' ) )
            // InternalAceGen.g:8122:3: ( 'persistent' )
            {
             before(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 
            // InternalAceGen.g:8123:3: ( 'persistent' )
            // InternalAceGen.g:8124:4: 'persistent'
            {
             before(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 
            match(input,75,FOLLOW_2); 
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
    // InternalAceGen.g:8135:1: rule__Model__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8139:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8140:2: ( RULE_ID )
            {
            // InternalAceGen.g:8140:2: ( RULE_ID )
            // InternalAceGen.g:8141:3: RULE_ID
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
    // InternalAceGen.g:8150:1: rule__Model__SuperModelsAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Model__SuperModelsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8154:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8155:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8155:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8156:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0()); 
            // InternalAceGen.g:8157:3: ( ruleQualifiedName )
            // InternalAceGen.g:8158:4: ruleQualifiedName
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
    // InternalAceGen.g:8169:1: rule__Model__SuperModelsAssignment_2_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Model__SuperModelsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8173:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8174:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8174:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8175:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0()); 
            // InternalAceGen.g:8176:3: ( ruleQualifiedName )
            // InternalAceGen.g:8177:4: ruleQualifiedName
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
    // InternalAceGen.g:8188:1: rule__Model__AttributesAssignment_3_1 : ( ruleAttribute ) ;
    public final void rule__Model__AttributesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8192:1: ( ( ruleAttribute ) )
            // InternalAceGen.g:8193:2: ( ruleAttribute )
            {
            // InternalAceGen.g:8193:2: ( ruleAttribute )
            // InternalAceGen.g:8194:3: ruleAttribute
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
    // InternalAceGen.g:8203:1: rule__Scenario__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Scenario__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8207:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8208:2: ( RULE_ID )
            {
            // InternalAceGen.g:8208:2: ( RULE_ID )
            // InternalAceGen.g:8209:3: RULE_ID
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
    // InternalAceGen.g:8218:1: rule__Scenario__GivenRefsAssignment_1_1 : ( ruleGivenRef ) ;
    public final void rule__Scenario__GivenRefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8222:1: ( ( ruleGivenRef ) )
            // InternalAceGen.g:8223:2: ( ruleGivenRef )
            {
            // InternalAceGen.g:8223:2: ( ruleGivenRef )
            // InternalAceGen.g:8224:3: ruleGivenRef
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
    // InternalAceGen.g:8233:1: rule__Scenario__WhenBlockAssignment_3 : ( ruleWhenBlock ) ;
    public final void rule__Scenario__WhenBlockAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8237:1: ( ( ruleWhenBlock ) )
            // InternalAceGen.g:8238:2: ( ruleWhenBlock )
            {
            // InternalAceGen.g:8238:2: ( ruleWhenBlock )
            // InternalAceGen.g:8239:3: ruleWhenBlock
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
    // InternalAceGen.g:8248:1: rule__Scenario__ThenBlockAssignment_5 : ( ruleThenBlock ) ;
    public final void rule__Scenario__ThenBlockAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8252:1: ( ( ruleThenBlock ) )
            // InternalAceGen.g:8253:2: ( ruleThenBlock )
            {
            // InternalAceGen.g:8253:2: ( ruleThenBlock )
            // InternalAceGen.g:8254:3: ruleThenBlock
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
    // InternalAceGen.g:8263:1: rule__GivenRef__ScenarioAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__GivenRef__ScenarioAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8267:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8268:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8268:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8269:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getGivenRefAccess().getScenarioScenarioCrossReference_0_0()); 
            // InternalAceGen.g:8270:3: ( ruleQualifiedName )
            // InternalAceGen.g:8271:4: ruleQualifiedName
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
    // InternalAceGen.g:8282:1: rule__GivenRef__TimesAssignment_1_0 : ( RULE_INT ) ;
    public final void rule__GivenRef__TimesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8286:1: ( ( RULE_INT ) )
            // InternalAceGen.g:8287:2: ( RULE_INT )
            {
            // InternalAceGen.g:8287:2: ( RULE_INT )
            // InternalAceGen.g:8288:3: RULE_INT
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
    // InternalAceGen.g:8297:1: rule__GivenRef__ExcludeGivenAssignment_2 : ( ( 'excludeGIVEN' ) ) ;
    public final void rule__GivenRef__ExcludeGivenAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8301:1: ( ( ( 'excludeGIVEN' ) ) )
            // InternalAceGen.g:8302:2: ( ( 'excludeGIVEN' ) )
            {
            // InternalAceGen.g:8302:2: ( ( 'excludeGIVEN' ) )
            // InternalAceGen.g:8303:3: ( 'excludeGIVEN' )
            {
             before(grammarAccess.getGivenRefAccess().getExcludeGivenExcludeGIVENKeyword_2_0()); 
            // InternalAceGen.g:8304:3: ( 'excludeGIVEN' )
            // InternalAceGen.g:8305:4: 'excludeGIVEN'
            {
             before(grammarAccess.getGivenRefAccess().getExcludeGivenExcludeGIVENKeyword_2_0()); 
            match(input,76,FOLLOW_2); 
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
    // InternalAceGen.g:8316:1: rule__WhenBlock__ActionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__WhenBlock__ActionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8320:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8321:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8321:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8322:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getWhenBlockAccess().getActionHttpServerAceCrossReference_0_0()); 
            // InternalAceGen.g:8323:3: ( ruleQualifiedName )
            // InternalAceGen.g:8324:4: ruleQualifiedName
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
    // InternalAceGen.g:8335:1: rule__WhenBlock__DataDefinitionAssignment_1 : ( ruleDataDefinition ) ;
    public final void rule__WhenBlock__DataDefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8339:1: ( ( ruleDataDefinition ) )
            // InternalAceGen.g:8340:2: ( ruleDataDefinition )
            {
            // InternalAceGen.g:8340:2: ( ruleDataDefinition )
            // InternalAceGen.g:8341:3: ruleDataDefinition
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
    // InternalAceGen.g:8350:1: rule__WhenBlock__AuthorizationAssignment_2 : ( ruleAuthorization ) ;
    public final void rule__WhenBlock__AuthorizationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8354:1: ( ( ruleAuthorization ) )
            // InternalAceGen.g:8355:2: ( ruleAuthorization )
            {
            // InternalAceGen.g:8355:2: ( ruleAuthorization )
            // InternalAceGen.g:8356:3: ruleAuthorization
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
    // InternalAceGen.g:8365:1: rule__ThenBlock__StatusCodeAssignment_0 : ( RULE_INT ) ;
    public final void rule__ThenBlock__StatusCodeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8369:1: ( ( RULE_INT ) )
            // InternalAceGen.g:8370:2: ( RULE_INT )
            {
            // InternalAceGen.g:8370:2: ( RULE_INT )
            // InternalAceGen.g:8371:3: RULE_INT
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
    // InternalAceGen.g:8380:1: rule__ThenBlock__ResponseAssignment_1_1 : ( ruleDataDefinition ) ;
    public final void rule__ThenBlock__ResponseAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8384:1: ( ( ruleDataDefinition ) )
            // InternalAceGen.g:8385:2: ( ruleDataDefinition )
            {
            // InternalAceGen.g:8385:2: ( ruleDataDefinition )
            // InternalAceGen.g:8386:3: ruleDataDefinition
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
    // InternalAceGen.g:8395:1: rule__DataDefinition__UuidAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__DataDefinition__UuidAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8399:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8400:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8400:2: ( RULE_STRING )
            // InternalAceGen.g:8401:3: RULE_STRING
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
    // InternalAceGen.g:8410:1: rule__DataDefinition__SystemtimeAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__DataDefinition__SystemtimeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8414:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8415:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8415:2: ( RULE_STRING )
            // InternalAceGen.g:8416:3: RULE_STRING
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
    // InternalAceGen.g:8425:1: rule__DataDefinition__PatternAssignment_2_2 : ( RULE_STRING ) ;
    public final void rule__DataDefinition__PatternAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8429:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8430:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8430:2: ( RULE_STRING )
            // InternalAceGen.g:8431:3: RULE_STRING
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
    // InternalAceGen.g:8440:1: rule__DataDefinition__DataAssignment_3 : ( ruleJsonObject ) ;
    public final void rule__DataDefinition__DataAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8444:1: ( ( ruleJsonObject ) )
            // InternalAceGen.g:8445:2: ( ruleJsonObject )
            {
            // InternalAceGen.g:8445:2: ( ruleJsonObject )
            // InternalAceGen.g:8446:3: ruleJsonObject
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
    // InternalAceGen.g:8455:1: rule__Authorization__UsernameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Authorization__UsernameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8459:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8460:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8460:2: ( RULE_STRING )
            // InternalAceGen.g:8461:3: RULE_STRING
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
    // InternalAceGen.g:8470:1: rule__Authorization__PasswordAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Authorization__PasswordAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8474:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8475:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8475:2: ( RULE_STRING )
            // InternalAceGen.g:8476:3: RULE_STRING
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
    // InternalAceGen.g:8485:1: rule__Attribute__UniqueAssignment_0 : ( ( 'Unique' ) ) ;
    public final void rule__Attribute__UniqueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8489:1: ( ( ( 'Unique' ) ) )
            // InternalAceGen.g:8490:2: ( ( 'Unique' ) )
            {
            // InternalAceGen.g:8490:2: ( ( 'Unique' ) )
            // InternalAceGen.g:8491:3: ( 'Unique' )
            {
             before(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 
            // InternalAceGen.g:8492:3: ( 'Unique' )
            // InternalAceGen.g:8493:4: 'Unique'
            {
             before(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 
            match(input,77,FOLLOW_2); 
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
    // InternalAceGen.g:8504:1: rule__Attribute__PrimaryKeyAssignment_1 : ( ( 'PrimaryKey' ) ) ;
    public final void rule__Attribute__PrimaryKeyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8508:1: ( ( ( 'PrimaryKey' ) ) )
            // InternalAceGen.g:8509:2: ( ( 'PrimaryKey' ) )
            {
            // InternalAceGen.g:8509:2: ( ( 'PrimaryKey' ) )
            // InternalAceGen.g:8510:3: ( 'PrimaryKey' )
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 
            // InternalAceGen.g:8511:3: ( 'PrimaryKey' )
            // InternalAceGen.g:8512:4: 'PrimaryKey'
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 
            match(input,78,FOLLOW_2); 
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
    // InternalAceGen.g:8523:1: rule__Attribute__NotNullAssignment_2 : ( ( 'NotNull' ) ) ;
    public final void rule__Attribute__NotNullAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8527:1: ( ( ( 'NotNull' ) ) )
            // InternalAceGen.g:8528:2: ( ( 'NotNull' ) )
            {
            // InternalAceGen.g:8528:2: ( ( 'NotNull' ) )
            // InternalAceGen.g:8529:3: ( 'NotNull' )
            {
             before(grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_2_0()); 
            // InternalAceGen.g:8530:3: ( 'NotNull' )
            // InternalAceGen.g:8531:4: 'NotNull'
            {
             before(grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_2_0()); 
            match(input,79,FOLLOW_2); 
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
    // InternalAceGen.g:8542:1: rule__Attribute__ListAssignment_3 : ( ( 'List' ) ) ;
    public final void rule__Attribute__ListAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8546:1: ( ( ( 'List' ) ) )
            // InternalAceGen.g:8547:2: ( ( 'List' ) )
            {
            // InternalAceGen.g:8547:2: ( ( 'List' ) )
            // InternalAceGen.g:8548:3: ( 'List' )
            {
             before(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 
            // InternalAceGen.g:8549:3: ( 'List' )
            // InternalAceGen.g:8550:4: 'List'
            {
             before(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 
            match(input,80,FOLLOW_2); 
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
    // InternalAceGen.g:8561:1: rule__Attribute__TypeAssignment_4_0 : ( ruleType ) ;
    public final void rule__Attribute__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8565:1: ( ( ruleType ) )
            // InternalAceGen.g:8566:2: ( ruleType )
            {
            // InternalAceGen.g:8566:2: ( ruleType )
            // InternalAceGen.g:8567:3: ruleType
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
    // InternalAceGen.g:8576:1: rule__Attribute__ModelAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Attribute__ModelAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8580:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8581:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8581:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8582:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeAccess().getModelModelCrossReference_4_1_0()); 
            // InternalAceGen.g:8583:3: ( ruleQualifiedName )
            // InternalAceGen.g:8584:4: ruleQualifiedName
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
    // InternalAceGen.g:8595:1: rule__Attribute__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8599:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8600:2: ( RULE_ID )
            {
            // InternalAceGen.g:8600:2: ( RULE_ID )
            // InternalAceGen.g:8601:3: RULE_ID
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
    // InternalAceGen.g:8610:1: rule__Attribute__ForeignKeyAssignment_6_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Attribute__ForeignKeyAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8614:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8615:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8615:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8616:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0()); 
            // InternalAceGen.g:8617:3: ( ruleQualifiedName )
            // InternalAceGen.g:8618:4: ruleQualifiedName
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
    // InternalAceGen.g:8629:1: rule__Attribute__NotReplayableAssignment_7 : ( ( 'notReplayable' ) ) ;
    public final void rule__Attribute__NotReplayableAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8633:1: ( ( ( 'notReplayable' ) ) )
            // InternalAceGen.g:8634:2: ( ( 'notReplayable' ) )
            {
            // InternalAceGen.g:8634:2: ( ( 'notReplayable' ) )
            // InternalAceGen.g:8635:3: ( 'notReplayable' )
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableNotReplayableKeyword_7_0()); 
            // InternalAceGen.g:8636:3: ( 'notReplayable' )
            // InternalAceGen.g:8637:4: 'notReplayable'
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableNotReplayableKeyword_7_0()); 
            match(input,81,FOLLOW_2); 
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
    // InternalAceGen.g:8648:1: rule__JsonDateTime__DateTimeAssignment_0 : ( RULE_STRING ) ;
    public final void rule__JsonDateTime__DateTimeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8652:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8653:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8653:2: ( RULE_STRING )
            // InternalAceGen.g:8654:3: RULE_STRING
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
    // InternalAceGen.g:8663:1: rule__JsonDateTime__PatternAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JsonDateTime__PatternAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8667:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8668:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8668:2: ( RULE_STRING )
            // InternalAceGen.g:8669:3: RULE_STRING
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
    // InternalAceGen.g:8678:1: rule__JsonObject__MembersAssignment_2 : ( ruleJsonMember ) ;
    public final void rule__JsonObject__MembersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8682:1: ( ( ruleJsonMember ) )
            // InternalAceGen.g:8683:2: ( ruleJsonMember )
            {
            // InternalAceGen.g:8683:2: ( ruleJsonMember )
            // InternalAceGen.g:8684:3: ruleJsonMember
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
    // InternalAceGen.g:8693:1: rule__JsonObject__MembersAssignment_3_1 : ( ruleJsonMember ) ;
    public final void rule__JsonObject__MembersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8697:1: ( ( ruleJsonMember ) )
            // InternalAceGen.g:8698:2: ( ruleJsonMember )
            {
            // InternalAceGen.g:8698:2: ( ruleJsonMember )
            // InternalAceGen.g:8699:3: ruleJsonMember
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
    // InternalAceGen.g:8708:1: rule__JsonMember__AttributeAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__JsonMember__AttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8712:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8713:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8713:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8714:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getJsonMemberAccess().getAttributeAttributeCrossReference_0_0()); 
            // InternalAceGen.g:8715:3: ( ruleQualifiedName )
            // InternalAceGen.g:8716:4: ruleQualifiedName
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
    // InternalAceGen.g:8727:1: rule__JsonMember__ValueAssignment_2 : ( ruleJsonValue ) ;
    public final void rule__JsonMember__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8731:1: ( ( ruleJsonValue ) )
            // InternalAceGen.g:8732:2: ( ruleJsonValue )
            {
            // InternalAceGen.g:8732:2: ( ruleJsonValue )
            // InternalAceGen.g:8733:3: ruleJsonValue
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
    // InternalAceGen.g:8742:1: rule__JsonValue__StringAssignment_1 : ( RULE_STRING ) ;
    public final void rule__JsonValue__StringAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8746:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8747:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8747:2: ( RULE_STRING )
            // InternalAceGen.g:8748:3: RULE_STRING
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
    // InternalAceGen.g:8757:1: rule__JsonValue__BooleanAssignment_3 : ( ruleJsonBoolean ) ;
    public final void rule__JsonValue__BooleanAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8761:1: ( ( ruleJsonBoolean ) )
            // InternalAceGen.g:8762:2: ( ruleJsonBoolean )
            {
            // InternalAceGen.g:8762:2: ( ruleJsonBoolean )
            // InternalAceGen.g:8763:3: ruleJsonBoolean
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
    // InternalAceGen.g:8772:1: rule__JsonValue__NullAssignment_4 : ( ruleJsonNull ) ;
    public final void rule__JsonValue__NullAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8776:1: ( ( ruleJsonNull ) )
            // InternalAceGen.g:8777:2: ( ruleJsonNull )
            {
            // InternalAceGen.g:8777:2: ( ruleJsonNull )
            // InternalAceGen.g:8778:3: ruleJsonNull
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
    // InternalAceGen.g:8787:1: rule__JsonValue__LongAssignment_5 : ( RULE_INT ) ;
    public final void rule__JsonValue__LongAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8791:1: ( ( RULE_INT ) )
            // InternalAceGen.g:8792:2: ( RULE_INT )
            {
            // InternalAceGen.g:8792:2: ( RULE_INT )
            // InternalAceGen.g:8793:3: RULE_INT
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
    // InternalAceGen.g:8802:1: rule__JsonArray__ValuesAssignment_2 : ( ruleJsonValue ) ;
    public final void rule__JsonArray__ValuesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8806:1: ( ( ruleJsonValue ) )
            // InternalAceGen.g:8807:2: ( ruleJsonValue )
            {
            // InternalAceGen.g:8807:2: ( ruleJsonValue )
            // InternalAceGen.g:8808:3: ruleJsonValue
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
    // InternalAceGen.g:8817:1: rule__JsonArray__ValuesAssignment_3_1 : ( ruleJsonValue ) ;
    public final void rule__JsonArray__ValuesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8821:1: ( ( ruleJsonValue ) )
            // InternalAceGen.g:8822:2: ( ruleJsonValue )
            {
            // InternalAceGen.g:8822:2: ( ruleJsonValue )
            // InternalAceGen.g:8823:3: ruleJsonValue
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


    protected DFA4 dfa4 = new DFA4(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\2\4\1\42\1\4\1\43\1\4\1\13\1\43\2\uffff";
    static final String dfa_3s = "\1\110\1\4\1\42\1\4\1\101\1\4\1\25\1\101\2\uffff";
    static final String dfa_4s = "\10\uffff\1\1\1\2";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\103\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\35\uffff\1\5",
            "\1\7",
            "\1\11\7\uffff\3\10",
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

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1027:1: rule__HttpServerAce__Alternatives : ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000060010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000E400000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000002000001E000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000100000000000L,0x00000000000000E0L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000400000000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000F800100000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000100L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000100L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000800L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000800L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00F0008000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00F0000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x000040000FC00010L,0x000000000001E000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x000000000FC00012L,0x000000000001E000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0100200000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0A00000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000040L,0x0000000000001000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x6000200000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x000000000FC00010L,0x000000000001E000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020001L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000401000000010L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000200030001060L,0x0000000000000004L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000201030001060L,0x000000000000000CL});

}