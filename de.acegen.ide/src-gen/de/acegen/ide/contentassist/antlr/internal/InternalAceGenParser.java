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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'GET'", "'set'", "'merge'", "'reset'", "'init'", "'POST'", "'PUT'", "'DELETE'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'Long'", "'NotEmpty'", "'NotNull'", "'HttpClient'", "'HttpServer'", "'ACE'", "'appState'", "'<'", "'>'", "','", "'call'", "'loadingFlag'", "'on'", "'('", "')'", "'triggers'", "'|'", "':'", "'{'", "'}'", "'Authorization'", "'import'", "'views'", "'models'", "'scenarios'", "'pathParams'", "'queryParams'", "'payload'", "'response'", "'extends'", "'WHEN'", "'THEN'", "'GIVEN'", "'uuid'", "'systemTime'", "'authorization'", "'['", "']'", "'references'", "'.'", "'list'", "'location.hash'", "'storage'", "'proxy'", "'authorize'", "'persistent'", "'Unique'", "'PrimaryKey'", "'List'", "'notReplayable'"
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
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
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


    // $ANTLR start "entryRuleScenario"
    // InternalAceGen.g:478:1: entryRuleScenario : ruleScenario EOF ;
    public final void entryRuleScenario() throws RecognitionException {
        try {
            // InternalAceGen.g:479:1: ( ruleScenario EOF )
            // InternalAceGen.g:480:1: ruleScenario EOF
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
    // InternalAceGen.g:487:1: ruleScenario : ( ( rule__Scenario__Group__0 ) ) ;
    public final void ruleScenario() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:491:2: ( ( ( rule__Scenario__Group__0 ) ) )
            // InternalAceGen.g:492:2: ( ( rule__Scenario__Group__0 ) )
            {
            // InternalAceGen.g:492:2: ( ( rule__Scenario__Group__0 ) )
            // InternalAceGen.g:493:3: ( rule__Scenario__Group__0 )
            {
             before(grammarAccess.getScenarioAccess().getGroup()); 
            // InternalAceGen.g:494:3: ( rule__Scenario__Group__0 )
            // InternalAceGen.g:494:4: rule__Scenario__Group__0
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


    // $ANTLR start "entryRuleWhenBlock"
    // InternalAceGen.g:503:1: entryRuleWhenBlock : ruleWhenBlock EOF ;
    public final void entryRuleWhenBlock() throws RecognitionException {
        try {
            // InternalAceGen.g:504:1: ( ruleWhenBlock EOF )
            // InternalAceGen.g:505:1: ruleWhenBlock EOF
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
    // InternalAceGen.g:512:1: ruleWhenBlock : ( ( rule__WhenBlock__Group__0 ) ) ;
    public final void ruleWhenBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:516:2: ( ( ( rule__WhenBlock__Group__0 ) ) )
            // InternalAceGen.g:517:2: ( ( rule__WhenBlock__Group__0 ) )
            {
            // InternalAceGen.g:517:2: ( ( rule__WhenBlock__Group__0 ) )
            // InternalAceGen.g:518:3: ( rule__WhenBlock__Group__0 )
            {
             before(grammarAccess.getWhenBlockAccess().getGroup()); 
            // InternalAceGen.g:519:3: ( rule__WhenBlock__Group__0 )
            // InternalAceGen.g:519:4: rule__WhenBlock__Group__0
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
    // InternalAceGen.g:528:1: entryRuleThenBlock : ruleThenBlock EOF ;
    public final void entryRuleThenBlock() throws RecognitionException {
        try {
            // InternalAceGen.g:529:1: ( ruleThenBlock EOF )
            // InternalAceGen.g:530:1: ruleThenBlock EOF
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
    // InternalAceGen.g:537:1: ruleThenBlock : ( ( rule__ThenBlock__Group__0 ) ) ;
    public final void ruleThenBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:541:2: ( ( ( rule__ThenBlock__Group__0 ) ) )
            // InternalAceGen.g:542:2: ( ( rule__ThenBlock__Group__0 ) )
            {
            // InternalAceGen.g:542:2: ( ( rule__ThenBlock__Group__0 ) )
            // InternalAceGen.g:543:3: ( rule__ThenBlock__Group__0 )
            {
             before(grammarAccess.getThenBlockAccess().getGroup()); 
            // InternalAceGen.g:544:3: ( rule__ThenBlock__Group__0 )
            // InternalAceGen.g:544:4: rule__ThenBlock__Group__0
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
    // InternalAceGen.g:553:1: entryRuleDataDefinition : ruleDataDefinition EOF ;
    public final void entryRuleDataDefinition() throws RecognitionException {
        try {
            // InternalAceGen.g:554:1: ( ruleDataDefinition EOF )
            // InternalAceGen.g:555:1: ruleDataDefinition EOF
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
    // InternalAceGen.g:562:1: ruleDataDefinition : ( ( rule__DataDefinition__Group__0 ) ) ;
    public final void ruleDataDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:566:2: ( ( ( rule__DataDefinition__Group__0 ) ) )
            // InternalAceGen.g:567:2: ( ( rule__DataDefinition__Group__0 ) )
            {
            // InternalAceGen.g:567:2: ( ( rule__DataDefinition__Group__0 ) )
            // InternalAceGen.g:568:3: ( rule__DataDefinition__Group__0 )
            {
             before(grammarAccess.getDataDefinitionAccess().getGroup()); 
            // InternalAceGen.g:569:3: ( rule__DataDefinition__Group__0 )
            // InternalAceGen.g:569:4: rule__DataDefinition__Group__0
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
    // InternalAceGen.g:578:1: entryRuleAuthorization : ruleAuthorization EOF ;
    public final void entryRuleAuthorization() throws RecognitionException {
        try {
            // InternalAceGen.g:579:1: ( ruleAuthorization EOF )
            // InternalAceGen.g:580:1: ruleAuthorization EOF
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
    // InternalAceGen.g:587:1: ruleAuthorization : ( ( rule__Authorization__Group__0 ) ) ;
    public final void ruleAuthorization() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:591:2: ( ( ( rule__Authorization__Group__0 ) ) )
            // InternalAceGen.g:592:2: ( ( rule__Authorization__Group__0 ) )
            {
            // InternalAceGen.g:592:2: ( ( rule__Authorization__Group__0 ) )
            // InternalAceGen.g:593:3: ( rule__Authorization__Group__0 )
            {
             before(grammarAccess.getAuthorizationAccess().getGroup()); 
            // InternalAceGen.g:594:3: ( rule__Authorization__Group__0 )
            // InternalAceGen.g:594:4: rule__Authorization__Group__0
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


    // $ANTLR start "entryRuleAttributeDefinitionList"
    // InternalAceGen.g:603:1: entryRuleAttributeDefinitionList : ruleAttributeDefinitionList EOF ;
    public final void entryRuleAttributeDefinitionList() throws RecognitionException {
        try {
            // InternalAceGen.g:604:1: ( ruleAttributeDefinitionList EOF )
            // InternalAceGen.g:605:1: ruleAttributeDefinitionList EOF
            {
             before(grammarAccess.getAttributeDefinitionListRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeDefinitionList();

            state._fsp--;

             after(grammarAccess.getAttributeDefinitionListRule()); 
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
    // $ANTLR end "entryRuleAttributeDefinitionList"


    // $ANTLR start "ruleAttributeDefinitionList"
    // InternalAceGen.g:612:1: ruleAttributeDefinitionList : ( ( rule__AttributeDefinitionList__Group__0 ) ) ;
    public final void ruleAttributeDefinitionList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:616:2: ( ( ( rule__AttributeDefinitionList__Group__0 ) ) )
            // InternalAceGen.g:617:2: ( ( rule__AttributeDefinitionList__Group__0 ) )
            {
            // InternalAceGen.g:617:2: ( ( rule__AttributeDefinitionList__Group__0 ) )
            // InternalAceGen.g:618:3: ( rule__AttributeDefinitionList__Group__0 )
            {
             before(grammarAccess.getAttributeDefinitionListAccess().getGroup()); 
            // InternalAceGen.g:619:3: ( rule__AttributeDefinitionList__Group__0 )
            // InternalAceGen.g:619:4: rule__AttributeDefinitionList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeDefinitionListAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeDefinitionList"


    // $ANTLR start "entryRuleListAttributeDefinitionList"
    // InternalAceGen.g:628:1: entryRuleListAttributeDefinitionList : ruleListAttributeDefinitionList EOF ;
    public final void entryRuleListAttributeDefinitionList() throws RecognitionException {
        try {
            // InternalAceGen.g:629:1: ( ruleListAttributeDefinitionList EOF )
            // InternalAceGen.g:630:1: ruleListAttributeDefinitionList EOF
            {
             before(grammarAccess.getListAttributeDefinitionListRule()); 
            pushFollow(FOLLOW_1);
            ruleListAttributeDefinitionList();

            state._fsp--;

             after(grammarAccess.getListAttributeDefinitionListRule()); 
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
    // $ANTLR end "entryRuleListAttributeDefinitionList"


    // $ANTLR start "ruleListAttributeDefinitionList"
    // InternalAceGen.g:637:1: ruleListAttributeDefinitionList : ( ( rule__ListAttributeDefinitionList__Group__0 ) ) ;
    public final void ruleListAttributeDefinitionList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:641:2: ( ( ( rule__ListAttributeDefinitionList__Group__0 ) ) )
            // InternalAceGen.g:642:2: ( ( rule__ListAttributeDefinitionList__Group__0 ) )
            {
            // InternalAceGen.g:642:2: ( ( rule__ListAttributeDefinitionList__Group__0 ) )
            // InternalAceGen.g:643:3: ( rule__ListAttributeDefinitionList__Group__0 )
            {
             before(grammarAccess.getListAttributeDefinitionListAccess().getGroup()); 
            // InternalAceGen.g:644:3: ( rule__ListAttributeDefinitionList__Group__0 )
            // InternalAceGen.g:644:4: rule__ListAttributeDefinitionList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ListAttributeDefinitionList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getListAttributeDefinitionListAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleListAttributeDefinitionList"


    // $ANTLR start "entryRuleAttributeDefinition"
    // InternalAceGen.g:653:1: entryRuleAttributeDefinition : ruleAttributeDefinition EOF ;
    public final void entryRuleAttributeDefinition() throws RecognitionException {
        try {
            // InternalAceGen.g:654:1: ( ruleAttributeDefinition EOF )
            // InternalAceGen.g:655:1: ruleAttributeDefinition EOF
            {
             before(grammarAccess.getAttributeDefinitionRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeDefinition();

            state._fsp--;

             after(grammarAccess.getAttributeDefinitionRule()); 
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
    // $ANTLR end "entryRuleAttributeDefinition"


    // $ANTLR start "ruleAttributeDefinition"
    // InternalAceGen.g:662:1: ruleAttributeDefinition : ( ( rule__AttributeDefinition__Group__0 ) ) ;
    public final void ruleAttributeDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:666:2: ( ( ( rule__AttributeDefinition__Group__0 ) ) )
            // InternalAceGen.g:667:2: ( ( rule__AttributeDefinition__Group__0 ) )
            {
            // InternalAceGen.g:667:2: ( ( rule__AttributeDefinition__Group__0 ) )
            // InternalAceGen.g:668:3: ( rule__AttributeDefinition__Group__0 )
            {
             before(grammarAccess.getAttributeDefinitionAccess().getGroup()); 
            // InternalAceGen.g:669:3: ( rule__AttributeDefinition__Group__0 )
            // InternalAceGen.g:669:4: rule__AttributeDefinition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeDefinition"


    // $ANTLR start "entryRuleAttribute"
    // InternalAceGen.g:678:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalAceGen.g:679:1: ( ruleAttribute EOF )
            // InternalAceGen.g:680:1: ruleAttribute EOF
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
    // InternalAceGen.g:687:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:691:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalAceGen.g:692:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalAceGen.g:692:2: ( ( rule__Attribute__Group__0 ) )
            // InternalAceGen.g:693:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalAceGen.g:694:3: ( rule__Attribute__Group__0 )
            // InternalAceGen.g:694:4: rule__Attribute__Group__0
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
    // InternalAceGen.g:703:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalAceGen.g:704:1: ( ruleQualifiedName EOF )
            // InternalAceGen.g:705:1: ruleQualifiedName EOF
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
    // InternalAceGen.g:712:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:716:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalAceGen.g:717:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalAceGen.g:717:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalAceGen.g:718:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalAceGen.g:719:3: ( rule__QualifiedName__Group__0 )
            // InternalAceGen.g:719:4: rule__QualifiedName__Group__0
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
    // InternalAceGen.g:728:1: entryRuleWriteFunctionType : ruleWriteFunctionType EOF ;
    public final void entryRuleWriteFunctionType() throws RecognitionException {
        try {
            // InternalAceGen.g:729:1: ( ruleWriteFunctionType EOF )
            // InternalAceGen.g:730:1: ruleWriteFunctionType EOF
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
    // InternalAceGen.g:737:1: ruleWriteFunctionType : ( ( rule__WriteFunctionType__Alternatives ) ) ;
    public final void ruleWriteFunctionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:741:2: ( ( ( rule__WriteFunctionType__Alternatives ) ) )
            // InternalAceGen.g:742:2: ( ( rule__WriteFunctionType__Alternatives ) )
            {
            // InternalAceGen.g:742:2: ( ( rule__WriteFunctionType__Alternatives ) )
            // InternalAceGen.g:743:3: ( rule__WriteFunctionType__Alternatives )
            {
             before(grammarAccess.getWriteFunctionTypeAccess().getAlternatives()); 
            // InternalAceGen.g:744:3: ( rule__WriteFunctionType__Alternatives )
            // InternalAceGen.g:744:4: rule__WriteFunctionType__Alternatives
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
    // InternalAceGen.g:753:1: entryRuleReadFunctionType : ruleReadFunctionType EOF ;
    public final void entryRuleReadFunctionType() throws RecognitionException {
        try {
            // InternalAceGen.g:754:1: ( ruleReadFunctionType EOF )
            // InternalAceGen.g:755:1: ruleReadFunctionType EOF
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
    // InternalAceGen.g:762:1: ruleReadFunctionType : ( 'GET' ) ;
    public final void ruleReadFunctionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:766:2: ( ( 'GET' ) )
            // InternalAceGen.g:767:2: ( 'GET' )
            {
            // InternalAceGen.g:767:2: ( 'GET' )
            // InternalAceGen.g:768:3: 'GET'
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
    // InternalAceGen.g:778:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalAceGen.g:779:1: ( ruleType EOF )
            // InternalAceGen.g:780:1: ruleType EOF
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
    // InternalAceGen.g:787:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:791:2: ( ( ( rule__Type__Alternatives ) ) )
            // InternalAceGen.g:792:2: ( ( rule__Type__Alternatives ) )
            {
            // InternalAceGen.g:792:2: ( ( rule__Type__Alternatives ) )
            // InternalAceGen.g:793:3: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // InternalAceGen.g:794:3: ( rule__Type__Alternatives )
            // InternalAceGen.g:794:4: rule__Type__Alternatives
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
    // InternalAceGen.g:803:1: entryRuleConstraint : ruleConstraint EOF ;
    public final void entryRuleConstraint() throws RecognitionException {
        try {
            // InternalAceGen.g:804:1: ( ruleConstraint EOF )
            // InternalAceGen.g:805:1: ruleConstraint EOF
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
    // InternalAceGen.g:812:1: ruleConstraint : ( ( rule__Constraint__Alternatives ) ) ;
    public final void ruleConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:816:2: ( ( ( rule__Constraint__Alternatives ) ) )
            // InternalAceGen.g:817:2: ( ( rule__Constraint__Alternatives ) )
            {
            // InternalAceGen.g:817:2: ( ( rule__Constraint__Alternatives ) )
            // InternalAceGen.g:818:3: ( rule__Constraint__Alternatives )
            {
             before(grammarAccess.getConstraintAccess().getAlternatives()); 
            // InternalAceGen.g:819:3: ( rule__Constraint__Alternatives )
            // InternalAceGen.g:819:4: rule__Constraint__Alternatives
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


    // $ANTLR start "entryRuleValue"
    // InternalAceGen.g:828:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // InternalAceGen.g:829:1: ( ruleValue EOF )
            // InternalAceGen.g:830:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalAceGen.g:837:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:841:2: ( ( ( rule__Value__Alternatives ) ) )
            // InternalAceGen.g:842:2: ( ( rule__Value__Alternatives ) )
            {
            // InternalAceGen.g:842:2: ( ( rule__Value__Alternatives ) )
            // InternalAceGen.g:843:3: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // InternalAceGen.g:844:3: ( rule__Value__Alternatives )
            // InternalAceGen.g:844:4: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Value__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "rule__Project__Alternatives"
    // InternalAceGen.g:852:1: rule__Project__Alternatives : ( ( ( rule__Project__Group_0__0 ) ) | ( ( rule__Project__Group_1__0 ) ) );
    public final void rule__Project__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:856:1: ( ( ( rule__Project__Group_0__0 ) ) | ( ( rule__Project__Group_1__0 ) ) )
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
                    // InternalAceGen.g:857:2: ( ( rule__Project__Group_0__0 ) )
                    {
                    // InternalAceGen.g:857:2: ( ( rule__Project__Group_0__0 ) )
                    // InternalAceGen.g:858:3: ( rule__Project__Group_0__0 )
                    {
                     before(grammarAccess.getProjectAccess().getGroup_0()); 
                    // InternalAceGen.g:859:3: ( rule__Project__Group_0__0 )
                    // InternalAceGen.g:859:4: rule__Project__Group_0__0
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
                    // InternalAceGen.g:863:2: ( ( rule__Project__Group_1__0 ) )
                    {
                    // InternalAceGen.g:863:2: ( ( rule__Project__Group_1__0 ) )
                    // InternalAceGen.g:864:3: ( rule__Project__Group_1__0 )
                    {
                     before(grammarAccess.getProjectAccess().getGroup_1()); 
                    // InternalAceGen.g:865:3: ( rule__Project__Group_1__0 )
                    // InternalAceGen.g:865:4: rule__Project__Group_1__0
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
    // InternalAceGen.g:873:1: rule__HttpClientStateFunctionType__Alternatives : ( ( 'set' ) | ( 'merge' ) | ( 'reset' ) | ( 'init' ) );
    public final void rule__HttpClientStateFunctionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:877:1: ( ( 'set' ) | ( 'merge' ) | ( 'reset' ) | ( 'init' ) )
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
                    // InternalAceGen.g:878:2: ( 'set' )
                    {
                    // InternalAceGen.g:878:2: ( 'set' )
                    // InternalAceGen.g:879:3: 'set'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:884:2: ( 'merge' )
                    {
                    // InternalAceGen.g:884:2: ( 'merge' )
                    // InternalAceGen.g:885:3: 'merge'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:890:2: ( 'reset' )
                    {
                    // InternalAceGen.g:890:2: ( 'reset' )
                    // InternalAceGen.g:891:3: 'reset'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getResetKeyword_2()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getResetKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:896:2: ( 'init' )
                    {
                    // InternalAceGen.g:896:2: ( 'init' )
                    // InternalAceGen.g:897:3: 'init'
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
    // InternalAceGen.g:906:1: rule__HttpServerAce__Alternatives : ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) );
    public final void rule__HttpServerAce__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:910:1: ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalAceGen.g:911:2: ( ruleHttpServerAceWrite )
                    {
                    // InternalAceGen.g:911:2: ( ruleHttpServerAceWrite )
                    // InternalAceGen.g:912:3: ruleHttpServerAceWrite
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
                    // InternalAceGen.g:917:2: ( ruleHttpServerAceRead )
                    {
                    // InternalAceGen.g:917:2: ( ruleHttpServerAceRead )
                    // InternalAceGen.g:918:3: ruleHttpServerAceRead
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
    // InternalAceGen.g:927:1: rule__Attribute__Alternatives_4 : ( ( ( rule__Attribute__TypeAssignment_4_0 ) ) | ( ( rule__Attribute__ModelAssignment_4_1 ) ) );
    public final void rule__Attribute__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:931:1: ( ( ( rule__Attribute__TypeAssignment_4_0 ) ) | ( ( rule__Attribute__ModelAssignment_4_1 ) ) )
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
                    // InternalAceGen.g:932:2: ( ( rule__Attribute__TypeAssignment_4_0 ) )
                    {
                    // InternalAceGen.g:932:2: ( ( rule__Attribute__TypeAssignment_4_0 ) )
                    // InternalAceGen.g:933:3: ( rule__Attribute__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getAttributeAccess().getTypeAssignment_4_0()); 
                    // InternalAceGen.g:934:3: ( rule__Attribute__TypeAssignment_4_0 )
                    // InternalAceGen.g:934:4: rule__Attribute__TypeAssignment_4_0
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
                    // InternalAceGen.g:938:2: ( ( rule__Attribute__ModelAssignment_4_1 ) )
                    {
                    // InternalAceGen.g:938:2: ( ( rule__Attribute__ModelAssignment_4_1 ) )
                    // InternalAceGen.g:939:3: ( rule__Attribute__ModelAssignment_4_1 )
                    {
                     before(grammarAccess.getAttributeAccess().getModelAssignment_4_1()); 
                    // InternalAceGen.g:940:3: ( rule__Attribute__ModelAssignment_4_1 )
                    // InternalAceGen.g:940:4: rule__Attribute__ModelAssignment_4_1
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
    // InternalAceGen.g:948:1: rule__WriteFunctionType__Alternatives : ( ( 'POST' ) | ( 'PUT' ) | ( 'DELETE' ) );
    public final void rule__WriteFunctionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:952:1: ( ( 'POST' ) | ( 'PUT' ) | ( 'DELETE' ) )
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
                    // InternalAceGen.g:953:2: ( 'POST' )
                    {
                    // InternalAceGen.g:953:2: ( 'POST' )
                    // InternalAceGen.g:954:3: 'POST'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:959:2: ( 'PUT' )
                    {
                    // InternalAceGen.g:959:2: ( 'PUT' )
                    // InternalAceGen.g:960:3: 'PUT'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:965:2: ( 'DELETE' )
                    {
                    // InternalAceGen.g:965:2: ( 'DELETE' )
                    // InternalAceGen.g:966:3: 'DELETE'
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
    // InternalAceGen.g:975:1: rule__Type__Alternatives : ( ( 'Integer' ) | ( 'String' ) | ( 'Float' ) | ( 'Boolean' ) | ( 'DateTime' ) | ( 'Long' ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:979:1: ( ( 'Integer' ) | ( 'String' ) | ( 'Float' ) | ( 'Boolean' ) | ( 'DateTime' ) | ( 'Long' ) )
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
                    // InternalAceGen.g:980:2: ( 'Integer' )
                    {
                    // InternalAceGen.g:980:2: ( 'Integer' )
                    // InternalAceGen.g:981:3: 'Integer'
                    {
                     before(grammarAccess.getTypeAccess().getIntegerKeyword_0()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getIntegerKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:986:2: ( 'String' )
                    {
                    // InternalAceGen.g:986:2: ( 'String' )
                    // InternalAceGen.g:987:3: 'String'
                    {
                     before(grammarAccess.getTypeAccess().getStringKeyword_1()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getStringKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:992:2: ( 'Float' )
                    {
                    // InternalAceGen.g:992:2: ( 'Float' )
                    // InternalAceGen.g:993:3: 'Float'
                    {
                     before(grammarAccess.getTypeAccess().getFloatKeyword_2()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getFloatKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:998:2: ( 'Boolean' )
                    {
                    // InternalAceGen.g:998:2: ( 'Boolean' )
                    // InternalAceGen.g:999:3: 'Boolean'
                    {
                     before(grammarAccess.getTypeAccess().getBooleanKeyword_3()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getBooleanKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalAceGen.g:1004:2: ( 'DateTime' )
                    {
                    // InternalAceGen.g:1004:2: ( 'DateTime' )
                    // InternalAceGen.g:1005:3: 'DateTime'
                    {
                     before(grammarAccess.getTypeAccess().getDateTimeKeyword_4()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getDateTimeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalAceGen.g:1010:2: ( 'Long' )
                    {
                    // InternalAceGen.g:1010:2: ( 'Long' )
                    // InternalAceGen.g:1011:3: 'Long'
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
    // InternalAceGen.g:1020:1: rule__Constraint__Alternatives : ( ( 'NotEmpty' ) | ( 'NotNull' ) );
    public final void rule__Constraint__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1024:1: ( ( 'NotEmpty' ) | ( 'NotNull' ) )
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
                    // InternalAceGen.g:1025:2: ( 'NotEmpty' )
                    {
                    // InternalAceGen.g:1025:2: ( 'NotEmpty' )
                    // InternalAceGen.g:1026:3: 'NotEmpty'
                    {
                     before(grammarAccess.getConstraintAccess().getNotEmptyKeyword_0()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getConstraintAccess().getNotEmptyKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1031:2: ( 'NotNull' )
                    {
                    // InternalAceGen.g:1031:2: ( 'NotNull' )
                    // InternalAceGen.g:1032:3: 'NotNull'
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


    // $ANTLR start "rule__Value__Alternatives"
    // InternalAceGen.g:1041:1: rule__Value__Alternatives : ( ( ( rule__Value__StringValueAssignment_0 ) ) | ( ( rule__Value__IntValueAssignment_1 ) ) | ( ( rule__Value__AttributeDefinitionListAssignment_2 ) ) | ( ( rule__Value__ListAttributeDefinitionListAssignment_3 ) ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1045:1: ( ( ( rule__Value__StringValueAssignment_0 ) ) | ( ( rule__Value__IntValueAssignment_1 ) ) | ( ( rule__Value__AttributeDefinitionListAssignment_2 ) ) | ( ( rule__Value__ListAttributeDefinitionListAssignment_3 ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt8=1;
                }
                break;
            case RULE_INT:
                {
                alt8=2;
                }
                break;
            case 42:
                {
                alt8=3;
                }
                break;
            case 60:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalAceGen.g:1046:2: ( ( rule__Value__StringValueAssignment_0 ) )
                    {
                    // InternalAceGen.g:1046:2: ( ( rule__Value__StringValueAssignment_0 ) )
                    // InternalAceGen.g:1047:3: ( rule__Value__StringValueAssignment_0 )
                    {
                     before(grammarAccess.getValueAccess().getStringValueAssignment_0()); 
                    // InternalAceGen.g:1048:3: ( rule__Value__StringValueAssignment_0 )
                    // InternalAceGen.g:1048:4: rule__Value__StringValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__StringValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getStringValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1052:2: ( ( rule__Value__IntValueAssignment_1 ) )
                    {
                    // InternalAceGen.g:1052:2: ( ( rule__Value__IntValueAssignment_1 ) )
                    // InternalAceGen.g:1053:3: ( rule__Value__IntValueAssignment_1 )
                    {
                     before(grammarAccess.getValueAccess().getIntValueAssignment_1()); 
                    // InternalAceGen.g:1054:3: ( rule__Value__IntValueAssignment_1 )
                    // InternalAceGen.g:1054:4: rule__Value__IntValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__IntValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getIntValueAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:1058:2: ( ( rule__Value__AttributeDefinitionListAssignment_2 ) )
                    {
                    // InternalAceGen.g:1058:2: ( ( rule__Value__AttributeDefinitionListAssignment_2 ) )
                    // InternalAceGen.g:1059:3: ( rule__Value__AttributeDefinitionListAssignment_2 )
                    {
                     before(grammarAccess.getValueAccess().getAttributeDefinitionListAssignment_2()); 
                    // InternalAceGen.g:1060:3: ( rule__Value__AttributeDefinitionListAssignment_2 )
                    // InternalAceGen.g:1060:4: rule__Value__AttributeDefinitionListAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__AttributeDefinitionListAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getAttributeDefinitionListAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:1064:2: ( ( rule__Value__ListAttributeDefinitionListAssignment_3 ) )
                    {
                    // InternalAceGen.g:1064:2: ( ( rule__Value__ListAttributeDefinitionListAssignment_3 ) )
                    // InternalAceGen.g:1065:3: ( rule__Value__ListAttributeDefinitionListAssignment_3 )
                    {
                     before(grammarAccess.getValueAccess().getListAttributeDefinitionListAssignment_3()); 
                    // InternalAceGen.g:1066:3: ( rule__Value__ListAttributeDefinitionListAssignment_3 )
                    // InternalAceGen.g:1066:4: rule__Value__ListAttributeDefinitionListAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__ListAttributeDefinitionListAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getListAttributeDefinitionListAssignment_3()); 

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
    // $ANTLR end "rule__Value__Alternatives"


    // $ANTLR start "rule__Project__Group_0__0"
    // InternalAceGen.g:1074:1: rule__Project__Group_0__0 : rule__Project__Group_0__0__Impl rule__Project__Group_0__1 ;
    public final void rule__Project__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1078:1: ( rule__Project__Group_0__0__Impl rule__Project__Group_0__1 )
            // InternalAceGen.g:1079:2: rule__Project__Group_0__0__Impl rule__Project__Group_0__1
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
    // InternalAceGen.g:1086:1: rule__Project__Group_0__0__Impl : ( () ) ;
    public final void rule__Project__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1090:1: ( ( () ) )
            // InternalAceGen.g:1091:1: ( () )
            {
            // InternalAceGen.g:1091:1: ( () )
            // InternalAceGen.g:1092:2: ()
            {
             before(grammarAccess.getProjectAccess().getProjectAction_0_0()); 
            // InternalAceGen.g:1093:2: ()
            // InternalAceGen.g:1093:3: 
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
    // InternalAceGen.g:1101:1: rule__Project__Group_0__1 : rule__Project__Group_0__1__Impl rule__Project__Group_0__2 ;
    public final void rule__Project__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1105:1: ( rule__Project__Group_0__1__Impl rule__Project__Group_0__2 )
            // InternalAceGen.g:1106:2: rule__Project__Group_0__1__Impl rule__Project__Group_0__2
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
    // InternalAceGen.g:1113:1: rule__Project__Group_0__1__Impl : ( 'HttpClient' ) ;
    public final void rule__Project__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1117:1: ( ( 'HttpClient' ) )
            // InternalAceGen.g:1118:1: ( 'HttpClient' )
            {
            // InternalAceGen.g:1118:1: ( 'HttpClient' )
            // InternalAceGen.g:1119:2: 'HttpClient'
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
    // InternalAceGen.g:1128:1: rule__Project__Group_0__2 : rule__Project__Group_0__2__Impl ;
    public final void rule__Project__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1132:1: ( rule__Project__Group_0__2__Impl )
            // InternalAceGen.g:1133:2: rule__Project__Group_0__2__Impl
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
    // InternalAceGen.g:1139:1: rule__Project__Group_0__2__Impl : ( ( rule__Project__HttpClientAssignment_0_2 )? ) ;
    public final void rule__Project__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1143:1: ( ( ( rule__Project__HttpClientAssignment_0_2 )? ) )
            // InternalAceGen.g:1144:1: ( ( rule__Project__HttpClientAssignment_0_2 )? )
            {
            // InternalAceGen.g:1144:1: ( ( rule__Project__HttpClientAssignment_0_2 )? )
            // InternalAceGen.g:1145:2: ( rule__Project__HttpClientAssignment_0_2 )?
            {
             before(grammarAccess.getProjectAccess().getHttpClientAssignment_0_2()); 
            // InternalAceGen.g:1146:2: ( rule__Project__HttpClientAssignment_0_2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAceGen.g:1146:3: rule__Project__HttpClientAssignment_0_2
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
    // InternalAceGen.g:1155:1: rule__Project__Group_1__0 : rule__Project__Group_1__0__Impl rule__Project__Group_1__1 ;
    public final void rule__Project__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1159:1: ( rule__Project__Group_1__0__Impl rule__Project__Group_1__1 )
            // InternalAceGen.g:1160:2: rule__Project__Group_1__0__Impl rule__Project__Group_1__1
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
    // InternalAceGen.g:1167:1: rule__Project__Group_1__0__Impl : ( 'HttpServer' ) ;
    public final void rule__Project__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1171:1: ( ( 'HttpServer' ) )
            // InternalAceGen.g:1172:1: ( 'HttpServer' )
            {
            // InternalAceGen.g:1172:1: ( 'HttpServer' )
            // InternalAceGen.g:1173:2: 'HttpServer'
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
    // InternalAceGen.g:1182:1: rule__Project__Group_1__1 : rule__Project__Group_1__1__Impl ;
    public final void rule__Project__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1186:1: ( rule__Project__Group_1__1__Impl )
            // InternalAceGen.g:1187:2: rule__Project__Group_1__1__Impl
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
    // InternalAceGen.g:1193:1: rule__Project__Group_1__1__Impl : ( ( rule__Project__HttpServerAssignment_1_1 )? ) ;
    public final void rule__Project__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1197:1: ( ( ( rule__Project__HttpServerAssignment_1_1 )? ) )
            // InternalAceGen.g:1198:1: ( ( rule__Project__HttpServerAssignment_1_1 )? )
            {
            // InternalAceGen.g:1198:1: ( ( rule__Project__HttpServerAssignment_1_1 )? )
            // InternalAceGen.g:1199:2: ( rule__Project__HttpServerAssignment_1_1 )?
            {
             before(grammarAccess.getProjectAccess().getHttpServerAssignment_1_1()); 
            // InternalAceGen.g:1200:2: ( rule__Project__HttpServerAssignment_1_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAceGen.g:1200:3: rule__Project__HttpServerAssignment_1_1
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
    // InternalAceGen.g:1209:1: rule__HttpClient__Group__0 : rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1 ;
    public final void rule__HttpClient__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1213:1: ( rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1 )
            // InternalAceGen.g:1214:2: rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1
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
    // InternalAceGen.g:1221:1: rule__HttpClient__Group__0__Impl : ( ( rule__HttpClient__NameAssignment_0 ) ) ;
    public final void rule__HttpClient__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1225:1: ( ( ( rule__HttpClient__NameAssignment_0 ) ) )
            // InternalAceGen.g:1226:1: ( ( rule__HttpClient__NameAssignment_0 ) )
            {
            // InternalAceGen.g:1226:1: ( ( rule__HttpClient__NameAssignment_0 ) )
            // InternalAceGen.g:1227:2: ( rule__HttpClient__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientAccess().getNameAssignment_0()); 
            // InternalAceGen.g:1228:2: ( rule__HttpClient__NameAssignment_0 )
            // InternalAceGen.g:1228:3: rule__HttpClient__NameAssignment_0
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
    // InternalAceGen.g:1236:1: rule__HttpClient__Group__1 : rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2 ;
    public final void rule__HttpClient__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1240:1: ( rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2 )
            // InternalAceGen.g:1241:2: rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2
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
    // InternalAceGen.g:1248:1: rule__HttpClient__Group__1__Impl : ( ( rule__HttpClient__Group_1__0 )? ) ;
    public final void rule__HttpClient__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1252:1: ( ( ( rule__HttpClient__Group_1__0 )? ) )
            // InternalAceGen.g:1253:1: ( ( rule__HttpClient__Group_1__0 )? )
            {
            // InternalAceGen.g:1253:1: ( ( rule__HttpClient__Group_1__0 )? )
            // InternalAceGen.g:1254:2: ( rule__HttpClient__Group_1__0 )?
            {
             before(grammarAccess.getHttpClientAccess().getGroup_1()); 
            // InternalAceGen.g:1255:2: ( rule__HttpClient__Group_1__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==29) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAceGen.g:1255:3: rule__HttpClient__Group_1__0
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
    // InternalAceGen.g:1263:1: rule__HttpClient__Group__2 : rule__HttpClient__Group__2__Impl ;
    public final void rule__HttpClient__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1267:1: ( rule__HttpClient__Group__2__Impl )
            // InternalAceGen.g:1268:2: rule__HttpClient__Group__2__Impl
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
    // InternalAceGen.g:1274:1: rule__HttpClient__Group__2__Impl : ( ( rule__HttpClient__Group_2__0 )? ) ;
    public final void rule__HttpClient__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1278:1: ( ( ( rule__HttpClient__Group_2__0 )? ) )
            // InternalAceGen.g:1279:1: ( ( rule__HttpClient__Group_2__0 )? )
            {
            // InternalAceGen.g:1279:1: ( ( rule__HttpClient__Group_2__0 )? )
            // InternalAceGen.g:1280:2: ( rule__HttpClient__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientAccess().getGroup_2()); 
            // InternalAceGen.g:1281:2: ( rule__HttpClient__Group_2__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==30) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalAceGen.g:1281:3: rule__HttpClient__Group_2__0
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
    // InternalAceGen.g:1290:1: rule__HttpClient__Group_1__0 : rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1 ;
    public final void rule__HttpClient__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1294:1: ( rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1 )
            // InternalAceGen.g:1295:2: rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1
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
    // InternalAceGen.g:1302:1: rule__HttpClient__Group_1__0__Impl : ( 'ACE' ) ;
    public final void rule__HttpClient__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1306:1: ( ( 'ACE' ) )
            // InternalAceGen.g:1307:1: ( 'ACE' )
            {
            // InternalAceGen.g:1307:1: ( 'ACE' )
            // InternalAceGen.g:1308:2: 'ACE'
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
    // InternalAceGen.g:1317:1: rule__HttpClient__Group_1__1 : rule__HttpClient__Group_1__1__Impl ;
    public final void rule__HttpClient__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1321:1: ( rule__HttpClient__Group_1__1__Impl )
            // InternalAceGen.g:1322:2: rule__HttpClient__Group_1__1__Impl
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
    // InternalAceGen.g:1328:1: rule__HttpClient__Group_1__1__Impl : ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* ) ;
    public final void rule__HttpClient__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1332:1: ( ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* ) )
            // InternalAceGen.g:1333:1: ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* )
            {
            // InternalAceGen.g:1333:1: ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* )
            // InternalAceGen.g:1334:2: ( rule__HttpClient__AceOperationsAssignment_1_1 )*
            {
             before(grammarAccess.getHttpClientAccess().getAceOperationsAssignment_1_1()); 
            // InternalAceGen.g:1335:2: ( rule__HttpClient__AceOperationsAssignment_1_1 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalAceGen.g:1335:3: rule__HttpClient__AceOperationsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpClient__AceOperationsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // InternalAceGen.g:1344:1: rule__HttpClient__Group_2__0 : rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1 ;
    public final void rule__HttpClient__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1348:1: ( rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1 )
            // InternalAceGen.g:1349:2: rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1
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
    // InternalAceGen.g:1356:1: rule__HttpClient__Group_2__0__Impl : ( 'appState' ) ;
    public final void rule__HttpClient__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1360:1: ( ( 'appState' ) )
            // InternalAceGen.g:1361:1: ( 'appState' )
            {
            // InternalAceGen.g:1361:1: ( 'appState' )
            // InternalAceGen.g:1362:2: 'appState'
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
    // InternalAceGen.g:1371:1: rule__HttpClient__Group_2__1 : rule__HttpClient__Group_2__1__Impl ;
    public final void rule__HttpClient__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1375:1: ( rule__HttpClient__Group_2__1__Impl )
            // InternalAceGen.g:1376:2: rule__HttpClient__Group_2__1__Impl
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
    // InternalAceGen.g:1382:1: rule__HttpClient__Group_2__1__Impl : ( ( rule__HttpClient__AppStateAssignment_2_1 ) ) ;
    public final void rule__HttpClient__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1386:1: ( ( ( rule__HttpClient__AppStateAssignment_2_1 ) ) )
            // InternalAceGen.g:1387:1: ( ( rule__HttpClient__AppStateAssignment_2_1 ) )
            {
            // InternalAceGen.g:1387:1: ( ( rule__HttpClient__AppStateAssignment_2_1 ) )
            // InternalAceGen.g:1388:2: ( rule__HttpClient__AppStateAssignment_2_1 )
            {
             before(grammarAccess.getHttpClientAccess().getAppStateAssignment_2_1()); 
            // InternalAceGen.g:1389:2: ( rule__HttpClient__AppStateAssignment_2_1 )
            // InternalAceGen.g:1389:3: rule__HttpClient__AppStateAssignment_2_1
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
    // InternalAceGen.g:1398:1: rule__HttpClientAce__Group__0 : rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1 ;
    public final void rule__HttpClientAce__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1402:1: ( rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1 )
            // InternalAceGen.g:1403:2: rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1
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
    // InternalAceGen.g:1410:1: rule__HttpClientAce__Group__0__Impl : ( ( rule__HttpClientAce__NameAssignment_0 ) ) ;
    public final void rule__HttpClientAce__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1414:1: ( ( ( rule__HttpClientAce__NameAssignment_0 ) ) )
            // InternalAceGen.g:1415:1: ( ( rule__HttpClientAce__NameAssignment_0 ) )
            {
            // InternalAceGen.g:1415:1: ( ( rule__HttpClientAce__NameAssignment_0 ) )
            // InternalAceGen.g:1416:2: ( rule__HttpClientAce__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientAceAccess().getNameAssignment_0()); 
            // InternalAceGen.g:1417:2: ( rule__HttpClientAce__NameAssignment_0 )
            // InternalAceGen.g:1417:3: rule__HttpClientAce__NameAssignment_0
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
    // InternalAceGen.g:1425:1: rule__HttpClientAce__Group__1 : rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2 ;
    public final void rule__HttpClientAce__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1429:1: ( rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2 )
            // InternalAceGen.g:1430:2: rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2
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
    // InternalAceGen.g:1437:1: rule__HttpClientAce__Group__1__Impl : ( ( rule__HttpClientAce__Group_1__0 )? ) ;
    public final void rule__HttpClientAce__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1441:1: ( ( ( rule__HttpClientAce__Group_1__0 )? ) )
            // InternalAceGen.g:1442:1: ( ( rule__HttpClientAce__Group_1__0 )? )
            {
            // InternalAceGen.g:1442:1: ( ( rule__HttpClientAce__Group_1__0 )? )
            // InternalAceGen.g:1443:2: ( rule__HttpClientAce__Group_1__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_1()); 
            // InternalAceGen.g:1444:2: ( rule__HttpClientAce__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==31) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalAceGen.g:1444:3: rule__HttpClientAce__Group_1__0
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
    // InternalAceGen.g:1452:1: rule__HttpClientAce__Group__2 : rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3 ;
    public final void rule__HttpClientAce__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1456:1: ( rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3 )
            // InternalAceGen.g:1457:2: rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3
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
    // InternalAceGen.g:1464:1: rule__HttpClientAce__Group__2__Impl : ( ( rule__HttpClientAce__Group_2__0 )? ) ;
    public final void rule__HttpClientAce__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1468:1: ( ( ( rule__HttpClientAce__Group_2__0 )? ) )
            // InternalAceGen.g:1469:1: ( ( rule__HttpClientAce__Group_2__0 )? )
            {
            // InternalAceGen.g:1469:1: ( ( rule__HttpClientAce__Group_2__0 )? )
            // InternalAceGen.g:1470:2: ( rule__HttpClientAce__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_2()); 
            // InternalAceGen.g:1471:2: ( rule__HttpClientAce__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==34) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalAceGen.g:1471:3: rule__HttpClientAce__Group_2__0
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
    // InternalAceGen.g:1479:1: rule__HttpClientAce__Group__3 : rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4 ;
    public final void rule__HttpClientAce__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1483:1: ( rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4 )
            // InternalAceGen.g:1484:2: rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4
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
    // InternalAceGen.g:1491:1: rule__HttpClientAce__Group__3__Impl : ( ( rule__HttpClientAce__Group_3__0 )? ) ;
    public final void rule__HttpClientAce__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1495:1: ( ( ( rule__HttpClientAce__Group_3__0 )? ) )
            // InternalAceGen.g:1496:1: ( ( rule__HttpClientAce__Group_3__0 )? )
            {
            // InternalAceGen.g:1496:1: ( ( rule__HttpClientAce__Group_3__0 )? )
            // InternalAceGen.g:1497:2: ( rule__HttpClientAce__Group_3__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_3()); 
            // InternalAceGen.g:1498:2: ( rule__HttpClientAce__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAceGen.g:1498:3: rule__HttpClientAce__Group_3__0
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
    // InternalAceGen.g:1506:1: rule__HttpClientAce__Group__4 : rule__HttpClientAce__Group__4__Impl ;
    public final void rule__HttpClientAce__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1510:1: ( rule__HttpClientAce__Group__4__Impl )
            // InternalAceGen.g:1511:2: rule__HttpClientAce__Group__4__Impl
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
    // InternalAceGen.g:1517:1: rule__HttpClientAce__Group__4__Impl : ( ( rule__HttpClientAce__OutcomesAssignment_4 )* ) ;
    public final void rule__HttpClientAce__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1521:1: ( ( ( rule__HttpClientAce__OutcomesAssignment_4 )* ) )
            // InternalAceGen.g:1522:1: ( ( rule__HttpClientAce__OutcomesAssignment_4 )* )
            {
            // InternalAceGen.g:1522:1: ( ( rule__HttpClientAce__OutcomesAssignment_4 )* )
            // InternalAceGen.g:1523:2: ( rule__HttpClientAce__OutcomesAssignment_4 )*
            {
             before(grammarAccess.getHttpClientAceAccess().getOutcomesAssignment_4()); 
            // InternalAceGen.g:1524:2: ( rule__HttpClientAce__OutcomesAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==36) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalAceGen.g:1524:3: rule__HttpClientAce__OutcomesAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__HttpClientAce__OutcomesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalAceGen.g:1533:1: rule__HttpClientAce__Group_1__0 : rule__HttpClientAce__Group_1__0__Impl rule__HttpClientAce__Group_1__1 ;
    public final void rule__HttpClientAce__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1537:1: ( rule__HttpClientAce__Group_1__0__Impl rule__HttpClientAce__Group_1__1 )
            // InternalAceGen.g:1538:2: rule__HttpClientAce__Group_1__0__Impl rule__HttpClientAce__Group_1__1
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
    // InternalAceGen.g:1545:1: rule__HttpClientAce__Group_1__0__Impl : ( '<' ) ;
    public final void rule__HttpClientAce__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1549:1: ( ( '<' ) )
            // InternalAceGen.g:1550:1: ( '<' )
            {
            // InternalAceGen.g:1550:1: ( '<' )
            // InternalAceGen.g:1551:2: '<'
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
    // InternalAceGen.g:1560:1: rule__HttpClientAce__Group_1__1 : rule__HttpClientAce__Group_1__1__Impl rule__HttpClientAce__Group_1__2 ;
    public final void rule__HttpClientAce__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1564:1: ( rule__HttpClientAce__Group_1__1__Impl rule__HttpClientAce__Group_1__2 )
            // InternalAceGen.g:1565:2: rule__HttpClientAce__Group_1__1__Impl rule__HttpClientAce__Group_1__2
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
    // InternalAceGen.g:1572:1: rule__HttpClientAce__Group_1__1__Impl : ( ( rule__HttpClientAce__InputAssignment_1_1 ) ) ;
    public final void rule__HttpClientAce__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1576:1: ( ( ( rule__HttpClientAce__InputAssignment_1_1 ) ) )
            // InternalAceGen.g:1577:1: ( ( rule__HttpClientAce__InputAssignment_1_1 ) )
            {
            // InternalAceGen.g:1577:1: ( ( rule__HttpClientAce__InputAssignment_1_1 ) )
            // InternalAceGen.g:1578:2: ( rule__HttpClientAce__InputAssignment_1_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getInputAssignment_1_1()); 
            // InternalAceGen.g:1579:2: ( rule__HttpClientAce__InputAssignment_1_1 )
            // InternalAceGen.g:1579:3: rule__HttpClientAce__InputAssignment_1_1
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
    // InternalAceGen.g:1587:1: rule__HttpClientAce__Group_1__2 : rule__HttpClientAce__Group_1__2__Impl rule__HttpClientAce__Group_1__3 ;
    public final void rule__HttpClientAce__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1591:1: ( rule__HttpClientAce__Group_1__2__Impl rule__HttpClientAce__Group_1__3 )
            // InternalAceGen.g:1592:2: rule__HttpClientAce__Group_1__2__Impl rule__HttpClientAce__Group_1__3
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
    // InternalAceGen.g:1599:1: rule__HttpClientAce__Group_1__2__Impl : ( ( rule__HttpClientAce__Group_1_2__0 )* ) ;
    public final void rule__HttpClientAce__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1603:1: ( ( ( rule__HttpClientAce__Group_1_2__0 )* ) )
            // InternalAceGen.g:1604:1: ( ( rule__HttpClientAce__Group_1_2__0 )* )
            {
            // InternalAceGen.g:1604:1: ( ( rule__HttpClientAce__Group_1_2__0 )* )
            // InternalAceGen.g:1605:2: ( rule__HttpClientAce__Group_1_2__0 )*
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_1_2()); 
            // InternalAceGen.g:1606:2: ( rule__HttpClientAce__Group_1_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==33) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalAceGen.g:1606:3: rule__HttpClientAce__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__HttpClientAce__Group_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalAceGen.g:1614:1: rule__HttpClientAce__Group_1__3 : rule__HttpClientAce__Group_1__3__Impl ;
    public final void rule__HttpClientAce__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1618:1: ( rule__HttpClientAce__Group_1__3__Impl )
            // InternalAceGen.g:1619:2: rule__HttpClientAce__Group_1__3__Impl
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
    // InternalAceGen.g:1625:1: rule__HttpClientAce__Group_1__3__Impl : ( '>' ) ;
    public final void rule__HttpClientAce__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1629:1: ( ( '>' ) )
            // InternalAceGen.g:1630:1: ( '>' )
            {
            // InternalAceGen.g:1630:1: ( '>' )
            // InternalAceGen.g:1631:2: '>'
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
    // InternalAceGen.g:1641:1: rule__HttpClientAce__Group_1_2__0 : rule__HttpClientAce__Group_1_2__0__Impl rule__HttpClientAce__Group_1_2__1 ;
    public final void rule__HttpClientAce__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1645:1: ( rule__HttpClientAce__Group_1_2__0__Impl rule__HttpClientAce__Group_1_2__1 )
            // InternalAceGen.g:1646:2: rule__HttpClientAce__Group_1_2__0__Impl rule__HttpClientAce__Group_1_2__1
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
    // InternalAceGen.g:1653:1: rule__HttpClientAce__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__HttpClientAce__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1657:1: ( ( ',' ) )
            // InternalAceGen.g:1658:1: ( ',' )
            {
            // InternalAceGen.g:1658:1: ( ',' )
            // InternalAceGen.g:1659:2: ','
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
    // InternalAceGen.g:1668:1: rule__HttpClientAce__Group_1_2__1 : rule__HttpClientAce__Group_1_2__1__Impl ;
    public final void rule__HttpClientAce__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1672:1: ( rule__HttpClientAce__Group_1_2__1__Impl )
            // InternalAceGen.g:1673:2: rule__HttpClientAce__Group_1_2__1__Impl
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
    // InternalAceGen.g:1679:1: rule__HttpClientAce__Group_1_2__1__Impl : ( ( rule__HttpClientAce__InputAssignment_1_2_1 ) ) ;
    public final void rule__HttpClientAce__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1683:1: ( ( ( rule__HttpClientAce__InputAssignment_1_2_1 ) ) )
            // InternalAceGen.g:1684:1: ( ( rule__HttpClientAce__InputAssignment_1_2_1 ) )
            {
            // InternalAceGen.g:1684:1: ( ( rule__HttpClientAce__InputAssignment_1_2_1 ) )
            // InternalAceGen.g:1685:2: ( rule__HttpClientAce__InputAssignment_1_2_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getInputAssignment_1_2_1()); 
            // InternalAceGen.g:1686:2: ( rule__HttpClientAce__InputAssignment_1_2_1 )
            // InternalAceGen.g:1686:3: rule__HttpClientAce__InputAssignment_1_2_1
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
    // InternalAceGen.g:1695:1: rule__HttpClientAce__Group_2__0 : rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1 ;
    public final void rule__HttpClientAce__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1699:1: ( rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1 )
            // InternalAceGen.g:1700:2: rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1
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
    // InternalAceGen.g:1707:1: rule__HttpClientAce__Group_2__0__Impl : ( 'call' ) ;
    public final void rule__HttpClientAce__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1711:1: ( ( 'call' ) )
            // InternalAceGen.g:1712:1: ( 'call' )
            {
            // InternalAceGen.g:1712:1: ( 'call' )
            // InternalAceGen.g:1713:2: 'call'
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
    // InternalAceGen.g:1722:1: rule__HttpClientAce__Group_2__1 : rule__HttpClientAce__Group_2__1__Impl ;
    public final void rule__HttpClientAce__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1726:1: ( rule__HttpClientAce__Group_2__1__Impl )
            // InternalAceGen.g:1727:2: rule__HttpClientAce__Group_2__1__Impl
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
    // InternalAceGen.g:1733:1: rule__HttpClientAce__Group_2__1__Impl : ( ( rule__HttpClientAce__ServerCallAssignment_2_1 ) ) ;
    public final void rule__HttpClientAce__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1737:1: ( ( ( rule__HttpClientAce__ServerCallAssignment_2_1 ) ) )
            // InternalAceGen.g:1738:1: ( ( rule__HttpClientAce__ServerCallAssignment_2_1 ) )
            {
            // InternalAceGen.g:1738:1: ( ( rule__HttpClientAce__ServerCallAssignment_2_1 ) )
            // InternalAceGen.g:1739:2: ( rule__HttpClientAce__ServerCallAssignment_2_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallAssignment_2_1()); 
            // InternalAceGen.g:1740:2: ( rule__HttpClientAce__ServerCallAssignment_2_1 )
            // InternalAceGen.g:1740:3: rule__HttpClientAce__ServerCallAssignment_2_1
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
    // InternalAceGen.g:1749:1: rule__HttpClientAce__Group_3__0 : rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1 ;
    public final void rule__HttpClientAce__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1753:1: ( rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1 )
            // InternalAceGen.g:1754:2: rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1
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
    // InternalAceGen.g:1761:1: rule__HttpClientAce__Group_3__0__Impl : ( 'loadingFlag' ) ;
    public final void rule__HttpClientAce__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1765:1: ( ( 'loadingFlag' ) )
            // InternalAceGen.g:1766:1: ( 'loadingFlag' )
            {
            // InternalAceGen.g:1766:1: ( 'loadingFlag' )
            // InternalAceGen.g:1767:2: 'loadingFlag'
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
    // InternalAceGen.g:1776:1: rule__HttpClientAce__Group_3__1 : rule__HttpClientAce__Group_3__1__Impl ;
    public final void rule__HttpClientAce__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1780:1: ( rule__HttpClientAce__Group_3__1__Impl )
            // InternalAceGen.g:1781:2: rule__HttpClientAce__Group_3__1__Impl
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
    // InternalAceGen.g:1787:1: rule__HttpClientAce__Group_3__1__Impl : ( ( rule__HttpClientAce__LoadingFlagAssignment_3_1 ) ) ;
    public final void rule__HttpClientAce__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1791:1: ( ( ( rule__HttpClientAce__LoadingFlagAssignment_3_1 ) ) )
            // InternalAceGen.g:1792:1: ( ( rule__HttpClientAce__LoadingFlagAssignment_3_1 ) )
            {
            // InternalAceGen.g:1792:1: ( ( rule__HttpClientAce__LoadingFlagAssignment_3_1 ) )
            // InternalAceGen.g:1793:2: ( rule__HttpClientAce__LoadingFlagAssignment_3_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagAssignment_3_1()); 
            // InternalAceGen.g:1794:2: ( rule__HttpClientAce__LoadingFlagAssignment_3_1 )
            // InternalAceGen.g:1794:3: rule__HttpClientAce__LoadingFlagAssignment_3_1
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
    // InternalAceGen.g:1803:1: rule__HttpClientOutcome__Group__0 : rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1 ;
    public final void rule__HttpClientOutcome__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1807:1: ( rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1 )
            // InternalAceGen.g:1808:2: rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1
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
    // InternalAceGen.g:1815:1: rule__HttpClientOutcome__Group__0__Impl : ( 'on' ) ;
    public final void rule__HttpClientOutcome__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1819:1: ( ( 'on' ) )
            // InternalAceGen.g:1820:1: ( 'on' )
            {
            // InternalAceGen.g:1820:1: ( 'on' )
            // InternalAceGen.g:1821:2: 'on'
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
    // InternalAceGen.g:1830:1: rule__HttpClientOutcome__Group__1 : rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2 ;
    public final void rule__HttpClientOutcome__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1834:1: ( rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2 )
            // InternalAceGen.g:1835:2: rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2
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
    // InternalAceGen.g:1842:1: rule__HttpClientOutcome__Group__1__Impl : ( ( rule__HttpClientOutcome__NameAssignment_1 ) ) ;
    public final void rule__HttpClientOutcome__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1846:1: ( ( ( rule__HttpClientOutcome__NameAssignment_1 ) ) )
            // InternalAceGen.g:1847:1: ( ( rule__HttpClientOutcome__NameAssignment_1 ) )
            {
            // InternalAceGen.g:1847:1: ( ( rule__HttpClientOutcome__NameAssignment_1 ) )
            // InternalAceGen.g:1848:2: ( rule__HttpClientOutcome__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getNameAssignment_1()); 
            // InternalAceGen.g:1849:2: ( rule__HttpClientOutcome__NameAssignment_1 )
            // InternalAceGen.g:1849:3: rule__HttpClientOutcome__NameAssignment_1
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
    // InternalAceGen.g:1857:1: rule__HttpClientOutcome__Group__2 : rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3 ;
    public final void rule__HttpClientOutcome__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1861:1: ( rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3 )
            // InternalAceGen.g:1862:2: rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3
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
    // InternalAceGen.g:1869:1: rule__HttpClientOutcome__Group__2__Impl : ( ( rule__HttpClientOutcome__Group_2__0 )? ) ;
    public final void rule__HttpClientOutcome__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1873:1: ( ( ( rule__HttpClientOutcome__Group_2__0 )? ) )
            // InternalAceGen.g:1874:1: ( ( rule__HttpClientOutcome__Group_2__0 )? )
            {
            // InternalAceGen.g:1874:1: ( ( rule__HttpClientOutcome__Group_2__0 )? )
            // InternalAceGen.g:1875:2: ( rule__HttpClientOutcome__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getGroup_2()); 
            // InternalAceGen.g:1876:2: ( rule__HttpClientOutcome__Group_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==37) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAceGen.g:1876:3: rule__HttpClientOutcome__Group_2__0
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
    // InternalAceGen.g:1884:1: rule__HttpClientOutcome__Group__3 : rule__HttpClientOutcome__Group__3__Impl ;
    public final void rule__HttpClientOutcome__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1888:1: ( rule__HttpClientOutcome__Group__3__Impl )
            // InternalAceGen.g:1889:2: rule__HttpClientOutcome__Group__3__Impl
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
    // InternalAceGen.g:1895:1: rule__HttpClientOutcome__Group__3__Impl : ( ( rule__HttpClientOutcome__Group_3__0 )? ) ;
    public final void rule__HttpClientOutcome__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1899:1: ( ( ( rule__HttpClientOutcome__Group_3__0 )? ) )
            // InternalAceGen.g:1900:1: ( ( rule__HttpClientOutcome__Group_3__0 )? )
            {
            // InternalAceGen.g:1900:1: ( ( rule__HttpClientOutcome__Group_3__0 )? )
            // InternalAceGen.g:1901:2: ( rule__HttpClientOutcome__Group_3__0 )?
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getGroup_3()); 
            // InternalAceGen.g:1902:2: ( rule__HttpClientOutcome__Group_3__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==39) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalAceGen.g:1902:3: rule__HttpClientOutcome__Group_3__0
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
    // InternalAceGen.g:1911:1: rule__HttpClientOutcome__Group_2__0 : rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1 ;
    public final void rule__HttpClientOutcome__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1915:1: ( rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1 )
            // InternalAceGen.g:1916:2: rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1
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
    // InternalAceGen.g:1923:1: rule__HttpClientOutcome__Group_2__0__Impl : ( '(' ) ;
    public final void rule__HttpClientOutcome__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1927:1: ( ( '(' ) )
            // InternalAceGen.g:1928:1: ( '(' )
            {
            // InternalAceGen.g:1928:1: ( '(' )
            // InternalAceGen.g:1929:2: '('
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
    // InternalAceGen.g:1938:1: rule__HttpClientOutcome__Group_2__1 : rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2 ;
    public final void rule__HttpClientOutcome__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1942:1: ( rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2 )
            // InternalAceGen.g:1943:2: rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2
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
    // InternalAceGen.g:1950:1: rule__HttpClientOutcome__Group_2__1__Impl : ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* ) ;
    public final void rule__HttpClientOutcome__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1954:1: ( ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* ) )
            // InternalAceGen.g:1955:1: ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* )
            {
            // InternalAceGen.g:1955:1: ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* )
            // InternalAceGen.g:1956:2: ( rule__HttpClientOutcome__ListenersAssignment_2_1 )*
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getListenersAssignment_2_1()); 
            // InternalAceGen.g:1957:2: ( rule__HttpClientOutcome__ListenersAssignment_2_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=12 && LA21_0<=15)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalAceGen.g:1957:3: rule__HttpClientOutcome__ListenersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__HttpClientOutcome__ListenersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalAceGen.g:1965:1: rule__HttpClientOutcome__Group_2__2 : rule__HttpClientOutcome__Group_2__2__Impl ;
    public final void rule__HttpClientOutcome__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1969:1: ( rule__HttpClientOutcome__Group_2__2__Impl )
            // InternalAceGen.g:1970:2: rule__HttpClientOutcome__Group_2__2__Impl
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
    // InternalAceGen.g:1976:1: rule__HttpClientOutcome__Group_2__2__Impl : ( ')' ) ;
    public final void rule__HttpClientOutcome__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1980:1: ( ( ')' ) )
            // InternalAceGen.g:1981:1: ( ')' )
            {
            // InternalAceGen.g:1981:1: ( ')' )
            // InternalAceGen.g:1982:2: ')'
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
    // InternalAceGen.g:1992:1: rule__HttpClientOutcome__Group_3__0 : rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1 ;
    public final void rule__HttpClientOutcome__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1996:1: ( rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1 )
            // InternalAceGen.g:1997:2: rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1
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
    // InternalAceGen.g:2004:1: rule__HttpClientOutcome__Group_3__0__Impl : ( 'triggers' ) ;
    public final void rule__HttpClientOutcome__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2008:1: ( ( 'triggers' ) )
            // InternalAceGen.g:2009:1: ( 'triggers' )
            {
            // InternalAceGen.g:2009:1: ( 'triggers' )
            // InternalAceGen.g:2010:2: 'triggers'
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
    // InternalAceGen.g:2019:1: rule__HttpClientOutcome__Group_3__1 : rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2 ;
    public final void rule__HttpClientOutcome__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2023:1: ( rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2 )
            // InternalAceGen.g:2024:2: rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2
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
    // InternalAceGen.g:2031:1: rule__HttpClientOutcome__Group_3__1__Impl : ( '(' ) ;
    public final void rule__HttpClientOutcome__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2035:1: ( ( '(' ) )
            // InternalAceGen.g:2036:1: ( '(' )
            {
            // InternalAceGen.g:2036:1: ( '(' )
            // InternalAceGen.g:2037:2: '('
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
    // InternalAceGen.g:2046:1: rule__HttpClientOutcome__Group_3__2 : rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3 ;
    public final void rule__HttpClientOutcome__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2050:1: ( rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3 )
            // InternalAceGen.g:2051:2: rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3
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
    // InternalAceGen.g:2058:1: rule__HttpClientOutcome__Group_3__2__Impl : ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* ) ;
    public final void rule__HttpClientOutcome__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2062:1: ( ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* ) )
            // InternalAceGen.g:2063:1: ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* )
            {
            // InternalAceGen.g:2063:1: ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* )
            // InternalAceGen.g:2064:2: ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )*
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsAssignment_3_2()); 
            // InternalAceGen.g:2065:2: ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalAceGen.g:2065:3: rule__HttpClientOutcome__AceOperationsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpClientOutcome__AceOperationsAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalAceGen.g:2073:1: rule__HttpClientOutcome__Group_3__3 : rule__HttpClientOutcome__Group_3__3__Impl ;
    public final void rule__HttpClientOutcome__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2077:1: ( rule__HttpClientOutcome__Group_3__3__Impl )
            // InternalAceGen.g:2078:2: rule__HttpClientOutcome__Group_3__3__Impl
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
    // InternalAceGen.g:2084:1: rule__HttpClientOutcome__Group_3__3__Impl : ( ')' ) ;
    public final void rule__HttpClientOutcome__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2088:1: ( ( ')' ) )
            // InternalAceGen.g:2089:1: ( ')' )
            {
            // InternalAceGen.g:2089:1: ( ')' )
            // InternalAceGen.g:2090:2: ')'
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
    // InternalAceGen.g:2100:1: rule__HttpClientStateFunction__Group__0 : rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1 ;
    public final void rule__HttpClientStateFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2104:1: ( rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1 )
            // InternalAceGen.g:2105:2: rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1
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
    // InternalAceGen.g:2112:1: rule__HttpClientStateFunction__Group__0__Impl : ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) ) ;
    public final void rule__HttpClientStateFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2116:1: ( ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) ) )
            // InternalAceGen.g:2117:1: ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) )
            {
            // InternalAceGen.g:2117:1: ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) )
            // InternalAceGen.g:2118:2: ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeAssignment_0()); 
            // InternalAceGen.g:2119:2: ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 )
            // InternalAceGen.g:2119:3: rule__HttpClientStateFunction__StateFunctionTypeAssignment_0
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
    // InternalAceGen.g:2127:1: rule__HttpClientStateFunction__Group__1 : rule__HttpClientStateFunction__Group__1__Impl ;
    public final void rule__HttpClientStateFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2131:1: ( rule__HttpClientStateFunction__Group__1__Impl )
            // InternalAceGen.g:2132:2: rule__HttpClientStateFunction__Group__1__Impl
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
    // InternalAceGen.g:2138:1: rule__HttpClientStateFunction__Group__1__Impl : ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) ) ;
    public final void rule__HttpClientStateFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2142:1: ( ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) ) )
            // InternalAceGen.g:2143:1: ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) )
            {
            // InternalAceGen.g:2143:1: ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) )
            // InternalAceGen.g:2144:2: ( rule__HttpClientStateFunction__AttributeAssignment_1 )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getAttributeAssignment_1()); 
            // InternalAceGen.g:2145:2: ( rule__HttpClientStateFunction__AttributeAssignment_1 )
            // InternalAceGen.g:2145:3: rule__HttpClientStateFunction__AttributeAssignment_1
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
    // InternalAceGen.g:2154:1: rule__HttpClientStateElement__Group__0 : rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1 ;
    public final void rule__HttpClientStateElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2158:1: ( rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1 )
            // InternalAceGen.g:2159:2: rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1
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
    // InternalAceGen.g:2166:1: rule__HttpClientStateElement__Group__0__Impl : ( ( rule__HttpClientStateElement__NameAssignment_0 ) ) ;
    public final void rule__HttpClientStateElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2170:1: ( ( ( rule__HttpClientStateElement__NameAssignment_0 ) ) )
            // InternalAceGen.g:2171:1: ( ( rule__HttpClientStateElement__NameAssignment_0 ) )
            {
            // InternalAceGen.g:2171:1: ( ( rule__HttpClientStateElement__NameAssignment_0 ) )
            // InternalAceGen.g:2172:2: ( rule__HttpClientStateElement__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getNameAssignment_0()); 
            // InternalAceGen.g:2173:2: ( rule__HttpClientStateElement__NameAssignment_0 )
            // InternalAceGen.g:2173:3: rule__HttpClientStateElement__NameAssignment_0
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
    // InternalAceGen.g:2181:1: rule__HttpClientStateElement__Group__1 : rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2 ;
    public final void rule__HttpClientStateElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2185:1: ( rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2 )
            // InternalAceGen.g:2186:2: rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2
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
    // InternalAceGen.g:2193:1: rule__HttpClientStateElement__Group__1__Impl : ( ( rule__HttpClientStateElement__ListAssignment_1 )? ) ;
    public final void rule__HttpClientStateElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2197:1: ( ( ( rule__HttpClientStateElement__ListAssignment_1 )? ) )
            // InternalAceGen.g:2198:1: ( ( rule__HttpClientStateElement__ListAssignment_1 )? )
            {
            // InternalAceGen.g:2198:1: ( ( rule__HttpClientStateElement__ListAssignment_1 )? )
            // InternalAceGen.g:2199:2: ( rule__HttpClientStateElement__ListAssignment_1 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListAssignment_1()); 
            // InternalAceGen.g:2200:2: ( rule__HttpClientStateElement__ListAssignment_1 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==64) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalAceGen.g:2200:3: rule__HttpClientStateElement__ListAssignment_1
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
    // InternalAceGen.g:2208:1: rule__HttpClientStateElement__Group__2 : rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3 ;
    public final void rule__HttpClientStateElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2212:1: ( rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3 )
            // InternalAceGen.g:2213:2: rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3
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
    // InternalAceGen.g:2220:1: rule__HttpClientStateElement__Group__2__Impl : ( ( rule__HttpClientStateElement__HashAssignment_2 )? ) ;
    public final void rule__HttpClientStateElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2224:1: ( ( ( rule__HttpClientStateElement__HashAssignment_2 )? ) )
            // InternalAceGen.g:2225:1: ( ( rule__HttpClientStateElement__HashAssignment_2 )? )
            {
            // InternalAceGen.g:2225:1: ( ( rule__HttpClientStateElement__HashAssignment_2 )? )
            // InternalAceGen.g:2226:2: ( rule__HttpClientStateElement__HashAssignment_2 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashAssignment_2()); 
            // InternalAceGen.g:2227:2: ( rule__HttpClientStateElement__HashAssignment_2 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==65) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalAceGen.g:2227:3: rule__HttpClientStateElement__HashAssignment_2
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
    // InternalAceGen.g:2235:1: rule__HttpClientStateElement__Group__3 : rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4 ;
    public final void rule__HttpClientStateElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2239:1: ( rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4 )
            // InternalAceGen.g:2240:2: rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4
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
    // InternalAceGen.g:2247:1: rule__HttpClientStateElement__Group__3__Impl : ( ( rule__HttpClientStateElement__StorageAssignment_3 )? ) ;
    public final void rule__HttpClientStateElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2251:1: ( ( ( rule__HttpClientStateElement__StorageAssignment_3 )? ) )
            // InternalAceGen.g:2252:1: ( ( rule__HttpClientStateElement__StorageAssignment_3 )? )
            {
            // InternalAceGen.g:2252:1: ( ( rule__HttpClientStateElement__StorageAssignment_3 )? )
            // InternalAceGen.g:2253:2: ( rule__HttpClientStateElement__StorageAssignment_3 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageAssignment_3()); 
            // InternalAceGen.g:2254:2: ( rule__HttpClientStateElement__StorageAssignment_3 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==66) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalAceGen.g:2254:3: rule__HttpClientStateElement__StorageAssignment_3
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
    // InternalAceGen.g:2262:1: rule__HttpClientStateElement__Group__4 : rule__HttpClientStateElement__Group__4__Impl ;
    public final void rule__HttpClientStateElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2266:1: ( rule__HttpClientStateElement__Group__4__Impl )
            // InternalAceGen.g:2267:2: rule__HttpClientStateElement__Group__4__Impl
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
    // InternalAceGen.g:2273:1: rule__HttpClientStateElement__Group__4__Impl : ( ( rule__HttpClientStateElement__Group_4__0 )? ) ;
    public final void rule__HttpClientStateElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2277:1: ( ( ( rule__HttpClientStateElement__Group_4__0 )? ) )
            // InternalAceGen.g:2278:1: ( ( rule__HttpClientStateElement__Group_4__0 )? )
            {
            // InternalAceGen.g:2278:1: ( ( rule__HttpClientStateElement__Group_4__0 )? )
            // InternalAceGen.g:2279:2: ( rule__HttpClientStateElement__Group_4__0 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getGroup_4()); 
            // InternalAceGen.g:2280:2: ( rule__HttpClientStateElement__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==41) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalAceGen.g:2280:3: rule__HttpClientStateElement__Group_4__0
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
    // InternalAceGen.g:2289:1: rule__HttpClientStateElement__Group_4__0 : rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1 ;
    public final void rule__HttpClientStateElement__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2293:1: ( rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1 )
            // InternalAceGen.g:2294:2: rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1
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
    // InternalAceGen.g:2301:1: rule__HttpClientStateElement__Group_4__0__Impl : ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) ) ;
    public final void rule__HttpClientStateElement__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2305:1: ( ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) ) )
            // InternalAceGen.g:2306:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) )
            {
            // InternalAceGen.g:2306:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) )
            // InternalAceGen.g:2307:2: ( rule__HttpClientStateElement__TypesAssignment_4_0 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_0()); 
            // InternalAceGen.g:2308:2: ( rule__HttpClientStateElement__TypesAssignment_4_0 )
            // InternalAceGen.g:2308:3: rule__HttpClientStateElement__TypesAssignment_4_0
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
    // InternalAceGen.g:2316:1: rule__HttpClientStateElement__Group_4__1 : rule__HttpClientStateElement__Group_4__1__Impl ;
    public final void rule__HttpClientStateElement__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2320:1: ( rule__HttpClientStateElement__Group_4__1__Impl )
            // InternalAceGen.g:2321:2: rule__HttpClientStateElement__Group_4__1__Impl
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
    // InternalAceGen.g:2327:1: rule__HttpClientStateElement__Group_4__1__Impl : ( ( rule__HttpClientStateElement__Group_4_1__0 )* ) ;
    public final void rule__HttpClientStateElement__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2331:1: ( ( ( rule__HttpClientStateElement__Group_4_1__0 )* ) )
            // InternalAceGen.g:2332:1: ( ( rule__HttpClientStateElement__Group_4_1__0 )* )
            {
            // InternalAceGen.g:2332:1: ( ( rule__HttpClientStateElement__Group_4_1__0 )* )
            // InternalAceGen.g:2333:2: ( rule__HttpClientStateElement__Group_4_1__0 )*
            {
             before(grammarAccess.getHttpClientStateElementAccess().getGroup_4_1()); 
            // InternalAceGen.g:2334:2: ( rule__HttpClientStateElement__Group_4_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==40) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalAceGen.g:2334:3: rule__HttpClientStateElement__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__HttpClientStateElement__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalAceGen.g:2343:1: rule__HttpClientStateElement__Group_4_1__0 : rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1 ;
    public final void rule__HttpClientStateElement__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2347:1: ( rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1 )
            // InternalAceGen.g:2348:2: rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1
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
    // InternalAceGen.g:2355:1: rule__HttpClientStateElement__Group_4_1__0__Impl : ( '|' ) ;
    public final void rule__HttpClientStateElement__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2359:1: ( ( '|' ) )
            // InternalAceGen.g:2360:1: ( '|' )
            {
            // InternalAceGen.g:2360:1: ( '|' )
            // InternalAceGen.g:2361:2: '|'
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
    // InternalAceGen.g:2370:1: rule__HttpClientStateElement__Group_4_1__1 : rule__HttpClientStateElement__Group_4_1__1__Impl ;
    public final void rule__HttpClientStateElement__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2374:1: ( rule__HttpClientStateElement__Group_4_1__1__Impl )
            // InternalAceGen.g:2375:2: rule__HttpClientStateElement__Group_4_1__1__Impl
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
    // InternalAceGen.g:2381:1: rule__HttpClientStateElement__Group_4_1__1__Impl : ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) ) ;
    public final void rule__HttpClientStateElement__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2385:1: ( ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) ) )
            // InternalAceGen.g:2386:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) )
            {
            // InternalAceGen.g:2386:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) )
            // InternalAceGen.g:2387:2: ( rule__HttpClientStateElement__TypesAssignment_4_1_1 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_1_1()); 
            // InternalAceGen.g:2388:2: ( rule__HttpClientStateElement__TypesAssignment_4_1_1 )
            // InternalAceGen.g:2388:3: rule__HttpClientStateElement__TypesAssignment_4_1_1
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
    // InternalAceGen.g:2397:1: rule__HttpClientTypeDefinition__Group__0 : rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1 ;
    public final void rule__HttpClientTypeDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2401:1: ( rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1 )
            // InternalAceGen.g:2402:2: rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1
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
    // InternalAceGen.g:2409:1: rule__HttpClientTypeDefinition__Group__0__Impl : ( ':' ) ;
    public final void rule__HttpClientTypeDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2413:1: ( ( ':' ) )
            // InternalAceGen.g:2414:1: ( ':' )
            {
            // InternalAceGen.g:2414:1: ( ':' )
            // InternalAceGen.g:2415:2: ':'
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
    // InternalAceGen.g:2424:1: rule__HttpClientTypeDefinition__Group__1 : rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2 ;
    public final void rule__HttpClientTypeDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2428:1: ( rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2 )
            // InternalAceGen.g:2429:2: rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2
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
    // InternalAceGen.g:2436:1: rule__HttpClientTypeDefinition__Group__1__Impl : ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) ) ;
    public final void rule__HttpClientTypeDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2440:1: ( ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) ) )
            // InternalAceGen.g:2441:1: ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) )
            {
            // InternalAceGen.g:2441:1: ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) )
            // InternalAceGen.g:2442:2: ( rule__HttpClientTypeDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getNameAssignment_1()); 
            // InternalAceGen.g:2443:2: ( rule__HttpClientTypeDefinition__NameAssignment_1 )
            // InternalAceGen.g:2443:3: rule__HttpClientTypeDefinition__NameAssignment_1
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
    // InternalAceGen.g:2451:1: rule__HttpClientTypeDefinition__Group__2 : rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3 ;
    public final void rule__HttpClientTypeDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2455:1: ( rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3 )
            // InternalAceGen.g:2456:2: rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3
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
    // InternalAceGen.g:2463:1: rule__HttpClientTypeDefinition__Group__2__Impl : ( '{' ) ;
    public final void rule__HttpClientTypeDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2467:1: ( ( '{' ) )
            // InternalAceGen.g:2468:1: ( '{' )
            {
            // InternalAceGen.g:2468:1: ( '{' )
            // InternalAceGen.g:2469:2: '{'
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
    // InternalAceGen.g:2478:1: rule__HttpClientTypeDefinition__Group__3 : rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4 ;
    public final void rule__HttpClientTypeDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2482:1: ( rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4 )
            // InternalAceGen.g:2483:2: rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4
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
    // InternalAceGen.g:2490:1: rule__HttpClientTypeDefinition__Group__3__Impl : ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* ) ;
    public final void rule__HttpClientTypeDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2494:1: ( ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* ) )
            // InternalAceGen.g:2495:1: ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* )
            {
            // InternalAceGen.g:2495:1: ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* )
            // InternalAceGen.g:2496:2: ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )*
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getElementsAssignment_3()); 
            // InternalAceGen.g:2497:2: ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalAceGen.g:2497:3: rule__HttpClientTypeDefinition__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpClientTypeDefinition__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalAceGen.g:2505:1: rule__HttpClientTypeDefinition__Group__4 : rule__HttpClientTypeDefinition__Group__4__Impl ;
    public final void rule__HttpClientTypeDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2509:1: ( rule__HttpClientTypeDefinition__Group__4__Impl )
            // InternalAceGen.g:2510:2: rule__HttpClientTypeDefinition__Group__4__Impl
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
    // InternalAceGen.g:2516:1: rule__HttpClientTypeDefinition__Group__4__Impl : ( '}' ) ;
    public final void rule__HttpClientTypeDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2520:1: ( ( '}' ) )
            // InternalAceGen.g:2521:1: ( '}' )
            {
            // InternalAceGen.g:2521:1: ( '}' )
            // InternalAceGen.g:2522:2: '}'
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
    // InternalAceGen.g:2532:1: rule__HttpServer__Group__0 : rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1 ;
    public final void rule__HttpServer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2536:1: ( rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1 )
            // InternalAceGen.g:2537:2: rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1
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
    // InternalAceGen.g:2544:1: rule__HttpServer__Group__0__Impl : ( ( rule__HttpServer__NameAssignment_0 ) ) ;
    public final void rule__HttpServer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2548:1: ( ( ( rule__HttpServer__NameAssignment_0 ) ) )
            // InternalAceGen.g:2549:1: ( ( rule__HttpServer__NameAssignment_0 ) )
            {
            // InternalAceGen.g:2549:1: ( ( rule__HttpServer__NameAssignment_0 ) )
            // InternalAceGen.g:2550:2: ( rule__HttpServer__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerAccess().getNameAssignment_0()); 
            // InternalAceGen.g:2551:2: ( rule__HttpServer__NameAssignment_0 )
            // InternalAceGen.g:2551:3: rule__HttpServer__NameAssignment_0
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
    // InternalAceGen.g:2559:1: rule__HttpServer__Group__1 : rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2 ;
    public final void rule__HttpServer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2563:1: ( rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2 )
            // InternalAceGen.g:2564:2: rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2
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
    // InternalAceGen.g:2571:1: rule__HttpServer__Group__1__Impl : ( ( rule__HttpServer__Group_1__0 )? ) ;
    public final void rule__HttpServer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2575:1: ( ( ( rule__HttpServer__Group_1__0 )? ) )
            // InternalAceGen.g:2576:1: ( ( rule__HttpServer__Group_1__0 )? )
            {
            // InternalAceGen.g:2576:1: ( ( rule__HttpServer__Group_1__0 )? )
            // InternalAceGen.g:2577:2: ( rule__HttpServer__Group_1__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_1()); 
            // InternalAceGen.g:2578:2: ( rule__HttpServer__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==44) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAceGen.g:2578:3: rule__HttpServer__Group_1__0
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
    // InternalAceGen.g:2586:1: rule__HttpServer__Group__2 : rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3 ;
    public final void rule__HttpServer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2590:1: ( rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3 )
            // InternalAceGen.g:2591:2: rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3
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
    // InternalAceGen.g:2598:1: rule__HttpServer__Group__2__Impl : ( ( rule__HttpServer__Group_2__0 )? ) ;
    public final void rule__HttpServer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2602:1: ( ( ( rule__HttpServer__Group_2__0 )? ) )
            // InternalAceGen.g:2603:1: ( ( rule__HttpServer__Group_2__0 )? )
            {
            // InternalAceGen.g:2603:1: ( ( rule__HttpServer__Group_2__0 )? )
            // InternalAceGen.g:2604:2: ( rule__HttpServer__Group_2__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_2()); 
            // InternalAceGen.g:2605:2: ( rule__HttpServer__Group_2__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==45) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalAceGen.g:2605:3: rule__HttpServer__Group_2__0
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
    // InternalAceGen.g:2613:1: rule__HttpServer__Group__3 : rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4 ;
    public final void rule__HttpServer__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2617:1: ( rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4 )
            // InternalAceGen.g:2618:2: rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4
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
    // InternalAceGen.g:2625:1: rule__HttpServer__Group__3__Impl : ( ( rule__HttpServer__Group_3__0 )? ) ;
    public final void rule__HttpServer__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2629:1: ( ( ( rule__HttpServer__Group_3__0 )? ) )
            // InternalAceGen.g:2630:1: ( ( rule__HttpServer__Group_3__0 )? )
            {
            // InternalAceGen.g:2630:1: ( ( rule__HttpServer__Group_3__0 )? )
            // InternalAceGen.g:2631:2: ( rule__HttpServer__Group_3__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_3()); 
            // InternalAceGen.g:2632:2: ( rule__HttpServer__Group_3__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==29) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalAceGen.g:2632:3: rule__HttpServer__Group_3__0
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
    // InternalAceGen.g:2640:1: rule__HttpServer__Group__4 : rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5 ;
    public final void rule__HttpServer__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2644:1: ( rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5 )
            // InternalAceGen.g:2645:2: rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5
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
    // InternalAceGen.g:2652:1: rule__HttpServer__Group__4__Impl : ( ( rule__HttpServer__Group_4__0 )? ) ;
    public final void rule__HttpServer__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2656:1: ( ( ( rule__HttpServer__Group_4__0 )? ) )
            // InternalAceGen.g:2657:1: ( ( rule__HttpServer__Group_4__0 )? )
            {
            // InternalAceGen.g:2657:1: ( ( rule__HttpServer__Group_4__0 )? )
            // InternalAceGen.g:2658:2: ( rule__HttpServer__Group_4__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_4()); 
            // InternalAceGen.g:2659:2: ( rule__HttpServer__Group_4__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==46) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAceGen.g:2659:3: rule__HttpServer__Group_4__0
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
    // InternalAceGen.g:2667:1: rule__HttpServer__Group__5 : rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6 ;
    public final void rule__HttpServer__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2671:1: ( rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6 )
            // InternalAceGen.g:2672:2: rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6
            {
            pushFollow(FOLLOW_22);
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
    // InternalAceGen.g:2679:1: rule__HttpServer__Group__5__Impl : ( ( rule__HttpServer__Group_5__0 )? ) ;
    public final void rule__HttpServer__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2683:1: ( ( ( rule__HttpServer__Group_5__0 )? ) )
            // InternalAceGen.g:2684:1: ( ( rule__HttpServer__Group_5__0 )? )
            {
            // InternalAceGen.g:2684:1: ( ( rule__HttpServer__Group_5__0 )? )
            // InternalAceGen.g:2685:2: ( rule__HttpServer__Group_5__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_5()); 
            // InternalAceGen.g:2686:2: ( rule__HttpServer__Group_5__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==47) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalAceGen.g:2686:3: rule__HttpServer__Group_5__0
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
    // InternalAceGen.g:2694:1: rule__HttpServer__Group__6 : rule__HttpServer__Group__6__Impl ;
    public final void rule__HttpServer__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2698:1: ( rule__HttpServer__Group__6__Impl )
            // InternalAceGen.g:2699:2: rule__HttpServer__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HttpServer__Group__6__Impl();

            state._fsp--;


            }

        }
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
    // InternalAceGen.g:2705:1: rule__HttpServer__Group__6__Impl : ( ( rule__HttpServer__Group_6__0 )? ) ;
    public final void rule__HttpServer__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2709:1: ( ( ( rule__HttpServer__Group_6__0 )? ) )
            // InternalAceGen.g:2710:1: ( ( rule__HttpServer__Group_6__0 )? )
            {
            // InternalAceGen.g:2710:1: ( ( rule__HttpServer__Group_6__0 )? )
            // InternalAceGen.g:2711:2: ( rule__HttpServer__Group_6__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_6()); 
            // InternalAceGen.g:2712:2: ( rule__HttpServer__Group_6__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==48) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAceGen.g:2712:3: rule__HttpServer__Group_6__0
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


    // $ANTLR start "rule__HttpServer__Group_1__0"
    // InternalAceGen.g:2721:1: rule__HttpServer__Group_1__0 : rule__HttpServer__Group_1__0__Impl rule__HttpServer__Group_1__1 ;
    public final void rule__HttpServer__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2725:1: ( rule__HttpServer__Group_1__0__Impl rule__HttpServer__Group_1__1 )
            // InternalAceGen.g:2726:2: rule__HttpServer__Group_1__0__Impl rule__HttpServer__Group_1__1
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
    // InternalAceGen.g:2733:1: rule__HttpServer__Group_1__0__Impl : ( 'Authorization' ) ;
    public final void rule__HttpServer__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2737:1: ( ( 'Authorization' ) )
            // InternalAceGen.g:2738:1: ( 'Authorization' )
            {
            // InternalAceGen.g:2738:1: ( 'Authorization' )
            // InternalAceGen.g:2739:2: 'Authorization'
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
    // InternalAceGen.g:2748:1: rule__HttpServer__Group_1__1 : rule__HttpServer__Group_1__1__Impl ;
    public final void rule__HttpServer__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2752:1: ( rule__HttpServer__Group_1__1__Impl )
            // InternalAceGen.g:2753:2: rule__HttpServer__Group_1__1__Impl
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
    // InternalAceGen.g:2759:1: rule__HttpServer__Group_1__1__Impl : ( ( rule__HttpServer__AuthUserAssignment_1_1 ) ) ;
    public final void rule__HttpServer__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2763:1: ( ( ( rule__HttpServer__AuthUserAssignment_1_1 ) ) )
            // InternalAceGen.g:2764:1: ( ( rule__HttpServer__AuthUserAssignment_1_1 ) )
            {
            // InternalAceGen.g:2764:1: ( ( rule__HttpServer__AuthUserAssignment_1_1 ) )
            // InternalAceGen.g:2765:2: ( rule__HttpServer__AuthUserAssignment_1_1 )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserAssignment_1_1()); 
            // InternalAceGen.g:2766:2: ( rule__HttpServer__AuthUserAssignment_1_1 )
            // InternalAceGen.g:2766:3: rule__HttpServer__AuthUserAssignment_1_1
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
    // InternalAceGen.g:2775:1: rule__HttpServer__Group_2__0 : rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1 ;
    public final void rule__HttpServer__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2779:1: ( rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1 )
            // InternalAceGen.g:2780:2: rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1
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
    // InternalAceGen.g:2787:1: rule__HttpServer__Group_2__0__Impl : ( 'import' ) ;
    public final void rule__HttpServer__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2791:1: ( ( 'import' ) )
            // InternalAceGen.g:2792:1: ( 'import' )
            {
            // InternalAceGen.g:2792:1: ( 'import' )
            // InternalAceGen.g:2793:2: 'import'
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
    // InternalAceGen.g:2802:1: rule__HttpServer__Group_2__1 : rule__HttpServer__Group_2__1__Impl ;
    public final void rule__HttpServer__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2806:1: ( rule__HttpServer__Group_2__1__Impl )
            // InternalAceGen.g:2807:2: rule__HttpServer__Group_2__1__Impl
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
    // InternalAceGen.g:2813:1: rule__HttpServer__Group_2__1__Impl : ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) ) ;
    public final void rule__HttpServer__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2817:1: ( ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) ) )
            // InternalAceGen.g:2818:1: ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) )
            {
            // InternalAceGen.g:2818:1: ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) )
            // InternalAceGen.g:2819:2: ( rule__HttpServer__AuthUserRefAssignment_2_1 )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAssignment_2_1()); 
            // InternalAceGen.g:2820:2: ( rule__HttpServer__AuthUserRefAssignment_2_1 )
            // InternalAceGen.g:2820:3: rule__HttpServer__AuthUserRefAssignment_2_1
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
    // InternalAceGen.g:2829:1: rule__HttpServer__Group_3__0 : rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1 ;
    public final void rule__HttpServer__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2833:1: ( rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1 )
            // InternalAceGen.g:2834:2: rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1
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
    // InternalAceGen.g:2841:1: rule__HttpServer__Group_3__0__Impl : ( 'ACE' ) ;
    public final void rule__HttpServer__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2845:1: ( ( 'ACE' ) )
            // InternalAceGen.g:2846:1: ( 'ACE' )
            {
            // InternalAceGen.g:2846:1: ( 'ACE' )
            // InternalAceGen.g:2847:2: 'ACE'
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
    // InternalAceGen.g:2856:1: rule__HttpServer__Group_3__1 : rule__HttpServer__Group_3__1__Impl ;
    public final void rule__HttpServer__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2860:1: ( rule__HttpServer__Group_3__1__Impl )
            // InternalAceGen.g:2861:2: rule__HttpServer__Group_3__1__Impl
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
    // InternalAceGen.g:2867:1: rule__HttpServer__Group_3__1__Impl : ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* ) ;
    public final void rule__HttpServer__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2871:1: ( ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* ) )
            // InternalAceGen.g:2872:1: ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* )
            {
            // InternalAceGen.g:2872:1: ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* )
            // InternalAceGen.g:2873:2: ( rule__HttpServer__AceOperationsAssignment_3_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getAceOperationsAssignment_3_1()); 
            // InternalAceGen.g:2874:2: ( rule__HttpServer__AceOperationsAssignment_3_1 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID||LA35_0==67) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalAceGen.g:2874:3: rule__HttpServer__AceOperationsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__HttpServer__AceOperationsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalAceGen.g:2883:1: rule__HttpServer__Group_4__0 : rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1 ;
    public final void rule__HttpServer__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2887:1: ( rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1 )
            // InternalAceGen.g:2888:2: rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1
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
    // InternalAceGen.g:2895:1: rule__HttpServer__Group_4__0__Impl : ( 'views' ) ;
    public final void rule__HttpServer__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2899:1: ( ( 'views' ) )
            // InternalAceGen.g:2900:1: ( 'views' )
            {
            // InternalAceGen.g:2900:1: ( 'views' )
            // InternalAceGen.g:2901:2: 'views'
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
    // InternalAceGen.g:2910:1: rule__HttpServer__Group_4__1 : rule__HttpServer__Group_4__1__Impl ;
    public final void rule__HttpServer__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2914:1: ( rule__HttpServer__Group_4__1__Impl )
            // InternalAceGen.g:2915:2: rule__HttpServer__Group_4__1__Impl
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
    // InternalAceGen.g:2921:1: rule__HttpServer__Group_4__1__Impl : ( ( rule__HttpServer__ViewsAssignment_4_1 )* ) ;
    public final void rule__HttpServer__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2925:1: ( ( ( rule__HttpServer__ViewsAssignment_4_1 )* ) )
            // InternalAceGen.g:2926:1: ( ( rule__HttpServer__ViewsAssignment_4_1 )* )
            {
            // InternalAceGen.g:2926:1: ( ( rule__HttpServer__ViewsAssignment_4_1 )* )
            // InternalAceGen.g:2927:2: ( rule__HttpServer__ViewsAssignment_4_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getViewsAssignment_4_1()); 
            // InternalAceGen.g:2928:2: ( rule__HttpServer__ViewsAssignment_4_1 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalAceGen.g:2928:3: rule__HttpServer__ViewsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServer__ViewsAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalAceGen.g:2937:1: rule__HttpServer__Group_5__0 : rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1 ;
    public final void rule__HttpServer__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2941:1: ( rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1 )
            // InternalAceGen.g:2942:2: rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1
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
    // InternalAceGen.g:2949:1: rule__HttpServer__Group_5__0__Impl : ( 'models' ) ;
    public final void rule__HttpServer__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2953:1: ( ( 'models' ) )
            // InternalAceGen.g:2954:1: ( 'models' )
            {
            // InternalAceGen.g:2954:1: ( 'models' )
            // InternalAceGen.g:2955:2: 'models'
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
    // InternalAceGen.g:2964:1: rule__HttpServer__Group_5__1 : rule__HttpServer__Group_5__1__Impl ;
    public final void rule__HttpServer__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2968:1: ( rule__HttpServer__Group_5__1__Impl )
            // InternalAceGen.g:2969:2: rule__HttpServer__Group_5__1__Impl
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
    // InternalAceGen.g:2975:1: rule__HttpServer__Group_5__1__Impl : ( ( rule__HttpServer__ModelsAssignment_5_1 )* ) ;
    public final void rule__HttpServer__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2979:1: ( ( ( rule__HttpServer__ModelsAssignment_5_1 )* ) )
            // InternalAceGen.g:2980:1: ( ( rule__HttpServer__ModelsAssignment_5_1 )* )
            {
            // InternalAceGen.g:2980:1: ( ( rule__HttpServer__ModelsAssignment_5_1 )* )
            // InternalAceGen.g:2981:2: ( rule__HttpServer__ModelsAssignment_5_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getModelsAssignment_5_1()); 
            // InternalAceGen.g:2982:2: ( rule__HttpServer__ModelsAssignment_5_1 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID||LA37_0==69) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalAceGen.g:2982:3: rule__HttpServer__ModelsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__HttpServer__ModelsAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
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


    // $ANTLR start "rule__HttpServer__Group_6__0"
    // InternalAceGen.g:2991:1: rule__HttpServer__Group_6__0 : rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1 ;
    public final void rule__HttpServer__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2995:1: ( rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1 )
            // InternalAceGen.g:2996:2: rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalAceGen.g:3003:1: rule__HttpServer__Group_6__0__Impl : ( 'scenarios' ) ;
    public final void rule__HttpServer__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3007:1: ( ( 'scenarios' ) )
            // InternalAceGen.g:3008:1: ( 'scenarios' )
            {
            // InternalAceGen.g:3008:1: ( 'scenarios' )
            // InternalAceGen.g:3009:2: 'scenarios'
            {
             before(grammarAccess.getHttpServerAccess().getScenariosKeyword_6_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getHttpServerAccess().getScenariosKeyword_6_0()); 

            }


            }

        }
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
    // InternalAceGen.g:3018:1: rule__HttpServer__Group_6__1 : rule__HttpServer__Group_6__1__Impl ;
    public final void rule__HttpServer__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3022:1: ( rule__HttpServer__Group_6__1__Impl )
            // InternalAceGen.g:3023:2: rule__HttpServer__Group_6__1__Impl
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
    // InternalAceGen.g:3029:1: rule__HttpServer__Group_6__1__Impl : ( ( rule__HttpServer__ScenariosAssignment_6_1 )* ) ;
    public final void rule__HttpServer__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3033:1: ( ( ( rule__HttpServer__ScenariosAssignment_6_1 )* ) )
            // InternalAceGen.g:3034:1: ( ( rule__HttpServer__ScenariosAssignment_6_1 )* )
            {
            // InternalAceGen.g:3034:1: ( ( rule__HttpServer__ScenariosAssignment_6_1 )* )
            // InternalAceGen.g:3035:2: ( rule__HttpServer__ScenariosAssignment_6_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getScenariosAssignment_6_1()); 
            // InternalAceGen.g:3036:2: ( rule__HttpServer__ScenariosAssignment_6_1 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalAceGen.g:3036:3: rule__HttpServer__ScenariosAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServer__ScenariosAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getHttpServerAccess().getScenariosAssignment_6_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__HttpServerAceWrite__Group__0"
    // InternalAceGen.g:3045:1: rule__HttpServerAceWrite__Group__0 : rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1 ;
    public final void rule__HttpServerAceWrite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3049:1: ( rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1 )
            // InternalAceGen.g:3050:2: rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1
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
    // InternalAceGen.g:3057:1: rule__HttpServerAceWrite__Group__0__Impl : ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3061:1: ( ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? ) )
            // InternalAceGen.g:3062:1: ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? )
            {
            // InternalAceGen.g:3062:1: ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? )
            // InternalAceGen.g:3063:2: ( rule__HttpServerAceWrite__ProxyAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyAssignment_0()); 
            // InternalAceGen.g:3064:2: ( rule__HttpServerAceWrite__ProxyAssignment_0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==67) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalAceGen.g:3064:3: rule__HttpServerAceWrite__ProxyAssignment_0
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
    // InternalAceGen.g:3072:1: rule__HttpServerAceWrite__Group__1 : rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2 ;
    public final void rule__HttpServerAceWrite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3076:1: ( rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2 )
            // InternalAceGen.g:3077:2: rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2
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
    // InternalAceGen.g:3084:1: rule__HttpServerAceWrite__Group__1__Impl : ( ( rule__HttpServerAceWrite__NameAssignment_1 ) ) ;
    public final void rule__HttpServerAceWrite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3088:1: ( ( ( rule__HttpServerAceWrite__NameAssignment_1 ) ) )
            // InternalAceGen.g:3089:1: ( ( rule__HttpServerAceWrite__NameAssignment_1 ) )
            {
            // InternalAceGen.g:3089:1: ( ( rule__HttpServerAceWrite__NameAssignment_1 ) )
            // InternalAceGen.g:3090:2: ( rule__HttpServerAceWrite__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getNameAssignment_1()); 
            // InternalAceGen.g:3091:2: ( rule__HttpServerAceWrite__NameAssignment_1 )
            // InternalAceGen.g:3091:3: rule__HttpServerAceWrite__NameAssignment_1
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
    // InternalAceGen.g:3099:1: rule__HttpServerAceWrite__Group__2 : rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3 ;
    public final void rule__HttpServerAceWrite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3103:1: ( rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3 )
            // InternalAceGen.g:3104:2: rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3
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
    // InternalAceGen.g:3111:1: rule__HttpServerAceWrite__Group__2__Impl : ( '<' ) ;
    public final void rule__HttpServerAceWrite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3115:1: ( ( '<' ) )
            // InternalAceGen.g:3116:1: ( '<' )
            {
            // InternalAceGen.g:3116:1: ( '<' )
            // InternalAceGen.g:3117:2: '<'
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
    // InternalAceGen.g:3126:1: rule__HttpServerAceWrite__Group__3 : rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4 ;
    public final void rule__HttpServerAceWrite__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3130:1: ( rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4 )
            // InternalAceGen.g:3131:2: rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4
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
    // InternalAceGen.g:3138:1: rule__HttpServerAceWrite__Group__3__Impl : ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) ) ;
    public final void rule__HttpServerAceWrite__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3142:1: ( ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) ) )
            // InternalAceGen.g:3143:1: ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) )
            {
            // InternalAceGen.g:3143:1: ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) )
            // InternalAceGen.g:3144:2: ( rule__HttpServerAceWrite__ModelAssignment_3 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getModelAssignment_3()); 
            // InternalAceGen.g:3145:2: ( rule__HttpServerAceWrite__ModelAssignment_3 )
            // InternalAceGen.g:3145:3: rule__HttpServerAceWrite__ModelAssignment_3
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
    // InternalAceGen.g:3153:1: rule__HttpServerAceWrite__Group__4 : rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5 ;
    public final void rule__HttpServerAceWrite__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3157:1: ( rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5 )
            // InternalAceGen.g:3158:2: rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5
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
    // InternalAceGen.g:3165:1: rule__HttpServerAceWrite__Group__4__Impl : ( '>' ) ;
    public final void rule__HttpServerAceWrite__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3169:1: ( ( '>' ) )
            // InternalAceGen.g:3170:1: ( '>' )
            {
            // InternalAceGen.g:3170:1: ( '>' )
            // InternalAceGen.g:3171:2: '>'
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
    // InternalAceGen.g:3180:1: rule__HttpServerAceWrite__Group__5 : rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6 ;
    public final void rule__HttpServerAceWrite__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3184:1: ( rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6 )
            // InternalAceGen.g:3185:2: rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6
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
    // InternalAceGen.g:3192:1: rule__HttpServerAceWrite__Group__5__Impl : ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) ) ;
    public final void rule__HttpServerAceWrite__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3196:1: ( ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) ) )
            // InternalAceGen.g:3197:1: ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) )
            {
            // InternalAceGen.g:3197:1: ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) )
            // InternalAceGen.g:3198:2: ( rule__HttpServerAceWrite__TypeAssignment_5 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getTypeAssignment_5()); 
            // InternalAceGen.g:3199:2: ( rule__HttpServerAceWrite__TypeAssignment_5 )
            // InternalAceGen.g:3199:3: rule__HttpServerAceWrite__TypeAssignment_5
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
    // InternalAceGen.g:3207:1: rule__HttpServerAceWrite__Group__6 : rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7 ;
    public final void rule__HttpServerAceWrite__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3211:1: ( rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7 )
            // InternalAceGen.g:3212:2: rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7
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
    // InternalAceGen.g:3219:1: rule__HttpServerAceWrite__Group__6__Impl : ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) ) ;
    public final void rule__HttpServerAceWrite__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3223:1: ( ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) ) )
            // InternalAceGen.g:3224:1: ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) )
            {
            // InternalAceGen.g:3224:1: ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) )
            // InternalAceGen.g:3225:2: ( rule__HttpServerAceWrite__UrlAssignment_6 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getUrlAssignment_6()); 
            // InternalAceGen.g:3226:2: ( rule__HttpServerAceWrite__UrlAssignment_6 )
            // InternalAceGen.g:3226:3: rule__HttpServerAceWrite__UrlAssignment_6
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
    // InternalAceGen.g:3234:1: rule__HttpServerAceWrite__Group__7 : rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8 ;
    public final void rule__HttpServerAceWrite__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3238:1: ( rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8 )
            // InternalAceGen.g:3239:2: rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8
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
    // InternalAceGen.g:3246:1: rule__HttpServerAceWrite__Group__7__Impl : ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? ) ;
    public final void rule__HttpServerAceWrite__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3250:1: ( ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? ) )
            // InternalAceGen.g:3251:1: ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? )
            {
            // InternalAceGen.g:3251:1: ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? )
            // InternalAceGen.g:3252:2: ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAssignment_7()); 
            // InternalAceGen.g:3253:2: ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==68) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalAceGen.g:3253:3: rule__HttpServerAceWrite__AuthorizeAssignment_7
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
    // InternalAceGen.g:3261:1: rule__HttpServerAceWrite__Group__8 : rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9 ;
    public final void rule__HttpServerAceWrite__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3265:1: ( rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9 )
            // InternalAceGen.g:3266:2: rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9
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
    // InternalAceGen.g:3273:1: rule__HttpServerAceWrite__Group__8__Impl : ( ( rule__HttpServerAceWrite__Group_8__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3277:1: ( ( ( rule__HttpServerAceWrite__Group_8__0 )? ) )
            // InternalAceGen.g:3278:1: ( ( rule__HttpServerAceWrite__Group_8__0 )? )
            {
            // InternalAceGen.g:3278:1: ( ( rule__HttpServerAceWrite__Group_8__0 )? )
            // InternalAceGen.g:3279:2: ( rule__HttpServerAceWrite__Group_8__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_8()); 
            // InternalAceGen.g:3280:2: ( rule__HttpServerAceWrite__Group_8__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==49) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalAceGen.g:3280:3: rule__HttpServerAceWrite__Group_8__0
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
    // InternalAceGen.g:3288:1: rule__HttpServerAceWrite__Group__9 : rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10 ;
    public final void rule__HttpServerAceWrite__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3292:1: ( rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10 )
            // InternalAceGen.g:3293:2: rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10
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
    // InternalAceGen.g:3300:1: rule__HttpServerAceWrite__Group__9__Impl : ( ( rule__HttpServerAceWrite__Group_9__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3304:1: ( ( ( rule__HttpServerAceWrite__Group_9__0 )? ) )
            // InternalAceGen.g:3305:1: ( ( rule__HttpServerAceWrite__Group_9__0 )? )
            {
            // InternalAceGen.g:3305:1: ( ( rule__HttpServerAceWrite__Group_9__0 )? )
            // InternalAceGen.g:3306:2: ( rule__HttpServerAceWrite__Group_9__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_9()); 
            // InternalAceGen.g:3307:2: ( rule__HttpServerAceWrite__Group_9__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==50) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalAceGen.g:3307:3: rule__HttpServerAceWrite__Group_9__0
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
    // InternalAceGen.g:3315:1: rule__HttpServerAceWrite__Group__10 : rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11 ;
    public final void rule__HttpServerAceWrite__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3319:1: ( rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11 )
            // InternalAceGen.g:3320:2: rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11
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
    // InternalAceGen.g:3327:1: rule__HttpServerAceWrite__Group__10__Impl : ( ( rule__HttpServerAceWrite__Group_10__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3331:1: ( ( ( rule__HttpServerAceWrite__Group_10__0 )? ) )
            // InternalAceGen.g:3332:1: ( ( rule__HttpServerAceWrite__Group_10__0 )? )
            {
            // InternalAceGen.g:3332:1: ( ( rule__HttpServerAceWrite__Group_10__0 )? )
            // InternalAceGen.g:3333:2: ( rule__HttpServerAceWrite__Group_10__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_10()); 
            // InternalAceGen.g:3334:2: ( rule__HttpServerAceWrite__Group_10__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==51) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalAceGen.g:3334:3: rule__HttpServerAceWrite__Group_10__0
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
    // InternalAceGen.g:3342:1: rule__HttpServerAceWrite__Group__11 : rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12 ;
    public final void rule__HttpServerAceWrite__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3346:1: ( rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12 )
            // InternalAceGen.g:3347:2: rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12
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
    // InternalAceGen.g:3354:1: rule__HttpServerAceWrite__Group__11__Impl : ( ( rule__HttpServerAceWrite__Group_11__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3358:1: ( ( ( rule__HttpServerAceWrite__Group_11__0 )? ) )
            // InternalAceGen.g:3359:1: ( ( rule__HttpServerAceWrite__Group_11__0 )? )
            {
            // InternalAceGen.g:3359:1: ( ( rule__HttpServerAceWrite__Group_11__0 )? )
            // InternalAceGen.g:3360:2: ( rule__HttpServerAceWrite__Group_11__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_11()); 
            // InternalAceGen.g:3361:2: ( rule__HttpServerAceWrite__Group_11__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==52) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalAceGen.g:3361:3: rule__HttpServerAceWrite__Group_11__0
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
    // InternalAceGen.g:3369:1: rule__HttpServerAceWrite__Group__12 : rule__HttpServerAceWrite__Group__12__Impl ;
    public final void rule__HttpServerAceWrite__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3373:1: ( rule__HttpServerAceWrite__Group__12__Impl )
            // InternalAceGen.g:3374:2: rule__HttpServerAceWrite__Group__12__Impl
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
    // InternalAceGen.g:3380:1: rule__HttpServerAceWrite__Group__12__Impl : ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* ) ;
    public final void rule__HttpServerAceWrite__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3384:1: ( ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* ) )
            // InternalAceGen.g:3385:1: ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* )
            {
            // InternalAceGen.g:3385:1: ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* )
            // InternalAceGen.g:3386:2: ( rule__HttpServerAceWrite__OutcomesAssignment_12 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getOutcomesAssignment_12()); 
            // InternalAceGen.g:3387:2: ( rule__HttpServerAceWrite__OutcomesAssignment_12 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==36) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalAceGen.g:3387:3: rule__HttpServerAceWrite__OutcomesAssignment_12
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__HttpServerAceWrite__OutcomesAssignment_12();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
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
    // InternalAceGen.g:3396:1: rule__HttpServerAceWrite__Group_8__0 : rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1 ;
    public final void rule__HttpServerAceWrite__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3400:1: ( rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1 )
            // InternalAceGen.g:3401:2: rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1
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
    // InternalAceGen.g:3408:1: rule__HttpServerAceWrite__Group_8__0__Impl : ( 'pathParams' ) ;
    public final void rule__HttpServerAceWrite__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3412:1: ( ( 'pathParams' ) )
            // InternalAceGen.g:3413:1: ( 'pathParams' )
            {
            // InternalAceGen.g:3413:1: ( 'pathParams' )
            // InternalAceGen.g:3414:2: 'pathParams'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_8_0()); 
            match(input,49,FOLLOW_2); 
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
    // InternalAceGen.g:3423:1: rule__HttpServerAceWrite__Group_8__1 : rule__HttpServerAceWrite__Group_8__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3427:1: ( rule__HttpServerAceWrite__Group_8__1__Impl )
            // InternalAceGen.g:3428:2: rule__HttpServerAceWrite__Group_8__1__Impl
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
    // InternalAceGen.g:3434:1: rule__HttpServerAceWrite__Group_8__1__Impl : ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3438:1: ( ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* ) )
            // InternalAceGen.g:3439:1: ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* )
            {
            // InternalAceGen.g:3439:1: ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* )
            // InternalAceGen.g:3440:2: ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAssignment_8_1()); 
            // InternalAceGen.g:3441:2: ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID) ) {
                    int LA46_2 = input.LA(2);

                    if ( (LA46_2==EOF||LA46_2==RULE_ID||LA46_2==36||(LA46_2>=46 && LA46_2<=48)||(LA46_2>=50 && LA46_2<=52)||LA46_2==63||LA46_2==67) ) {
                        alt46=1;
                    }


                }


                switch (alt46) {
            	case 1 :
            	    // InternalAceGen.g:3441:3: rule__HttpServerAceWrite__PathParamsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceWrite__PathParamsAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
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
    // InternalAceGen.g:3450:1: rule__HttpServerAceWrite__Group_9__0 : rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1 ;
    public final void rule__HttpServerAceWrite__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3454:1: ( rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1 )
            // InternalAceGen.g:3455:2: rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1
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
    // InternalAceGen.g:3462:1: rule__HttpServerAceWrite__Group_9__0__Impl : ( 'queryParams' ) ;
    public final void rule__HttpServerAceWrite__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3466:1: ( ( 'queryParams' ) )
            // InternalAceGen.g:3467:1: ( 'queryParams' )
            {
            // InternalAceGen.g:3467:1: ( 'queryParams' )
            // InternalAceGen.g:3468:2: 'queryParams'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_9_0()); 
            match(input,50,FOLLOW_2); 
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
    // InternalAceGen.g:3477:1: rule__HttpServerAceWrite__Group_9__1 : rule__HttpServerAceWrite__Group_9__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3481:1: ( rule__HttpServerAceWrite__Group_9__1__Impl )
            // InternalAceGen.g:3482:2: rule__HttpServerAceWrite__Group_9__1__Impl
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
    // InternalAceGen.g:3488:1: rule__HttpServerAceWrite__Group_9__1__Impl : ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3492:1: ( ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* ) )
            // InternalAceGen.g:3493:1: ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* )
            {
            // InternalAceGen.g:3493:1: ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* )
            // InternalAceGen.g:3494:2: ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAssignment_9_1()); 
            // InternalAceGen.g:3495:2: ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_ID) ) {
                    int LA47_2 = input.LA(2);

                    if ( (LA47_2==EOF||LA47_2==RULE_ID||LA47_2==36||(LA47_2>=46 && LA47_2<=48)||(LA47_2>=51 && LA47_2<=52)||LA47_2==63||LA47_2==67) ) {
                        alt47=1;
                    }


                }


                switch (alt47) {
            	case 1 :
            	    // InternalAceGen.g:3495:3: rule__HttpServerAceWrite__QueryParamsAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceWrite__QueryParamsAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
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
    // InternalAceGen.g:3504:1: rule__HttpServerAceWrite__Group_10__0 : rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1 ;
    public final void rule__HttpServerAceWrite__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3508:1: ( rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1 )
            // InternalAceGen.g:3509:2: rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1
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
    // InternalAceGen.g:3516:1: rule__HttpServerAceWrite__Group_10__0__Impl : ( 'payload' ) ;
    public final void rule__HttpServerAceWrite__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3520:1: ( ( 'payload' ) )
            // InternalAceGen.g:3521:1: ( 'payload' )
            {
            // InternalAceGen.g:3521:1: ( 'payload' )
            // InternalAceGen.g:3522:2: 'payload'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_10_0()); 
            match(input,51,FOLLOW_2); 
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
    // InternalAceGen.g:3531:1: rule__HttpServerAceWrite__Group_10__1 : rule__HttpServerAceWrite__Group_10__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3535:1: ( rule__HttpServerAceWrite__Group_10__1__Impl )
            // InternalAceGen.g:3536:2: rule__HttpServerAceWrite__Group_10__1__Impl
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
    // InternalAceGen.g:3542:1: rule__HttpServerAceWrite__Group_10__1__Impl : ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3546:1: ( ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* ) )
            // InternalAceGen.g:3547:1: ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* )
            {
            // InternalAceGen.g:3547:1: ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* )
            // InternalAceGen.g:3548:2: ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadAssignment_10_1()); 
            // InternalAceGen.g:3549:2: ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID) ) {
                    int LA48_2 = input.LA(2);

                    if ( (LA48_2==EOF||LA48_2==RULE_ID||LA48_2==36||(LA48_2>=46 && LA48_2<=48)||LA48_2==52||LA48_2==63||LA48_2==67) ) {
                        alt48=1;
                    }


                }


                switch (alt48) {
            	case 1 :
            	    // InternalAceGen.g:3549:3: rule__HttpServerAceWrite__PayloadAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceWrite__PayloadAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
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
    // InternalAceGen.g:3558:1: rule__HttpServerAceWrite__Group_11__0 : rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1 ;
    public final void rule__HttpServerAceWrite__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3562:1: ( rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1 )
            // InternalAceGen.g:3563:2: rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1
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
    // InternalAceGen.g:3570:1: rule__HttpServerAceWrite__Group_11__0__Impl : ( 'response' ) ;
    public final void rule__HttpServerAceWrite__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3574:1: ( ( 'response' ) )
            // InternalAceGen.g:3575:1: ( 'response' )
            {
            // InternalAceGen.g:3575:1: ( 'response' )
            // InternalAceGen.g:3576:2: 'response'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_11_0()); 
            match(input,52,FOLLOW_2); 
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
    // InternalAceGen.g:3585:1: rule__HttpServerAceWrite__Group_11__1 : rule__HttpServerAceWrite__Group_11__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3589:1: ( rule__HttpServerAceWrite__Group_11__1__Impl )
            // InternalAceGen.g:3590:2: rule__HttpServerAceWrite__Group_11__1__Impl
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
    // InternalAceGen.g:3596:1: rule__HttpServerAceWrite__Group_11__1__Impl : ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3600:1: ( ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* ) )
            // InternalAceGen.g:3601:1: ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* )
            {
            // InternalAceGen.g:3601:1: ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* )
            // InternalAceGen.g:3602:2: ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseAssignment_11_1()); 
            // InternalAceGen.g:3603:2: ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_ID) ) {
                    int LA49_2 = input.LA(2);

                    if ( (LA49_2==EOF||LA49_2==RULE_ID||LA49_2==36||(LA49_2>=46 && LA49_2<=48)||LA49_2==63||LA49_2==67) ) {
                        alt49=1;
                    }


                }


                switch (alt49) {
            	case 1 :
            	    // InternalAceGen.g:3603:3: rule__HttpServerAceWrite__ResponseAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceWrite__ResponseAssignment_11_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
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
    // InternalAceGen.g:3612:1: rule__HttpServerOutcome__Group__0 : rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1 ;
    public final void rule__HttpServerOutcome__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3616:1: ( rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1 )
            // InternalAceGen.g:3617:2: rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1
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
    // InternalAceGen.g:3624:1: rule__HttpServerOutcome__Group__0__Impl : ( 'on' ) ;
    public final void rule__HttpServerOutcome__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3628:1: ( ( 'on' ) )
            // InternalAceGen.g:3629:1: ( 'on' )
            {
            // InternalAceGen.g:3629:1: ( 'on' )
            // InternalAceGen.g:3630:2: 'on'
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
    // InternalAceGen.g:3639:1: rule__HttpServerOutcome__Group__1 : rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2 ;
    public final void rule__HttpServerOutcome__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3643:1: ( rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2 )
            // InternalAceGen.g:3644:2: rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2
            {
            pushFollow(FOLLOW_14);
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
    // InternalAceGen.g:3651:1: rule__HttpServerOutcome__Group__1__Impl : ( ( rule__HttpServerOutcome__NameAssignment_1 ) ) ;
    public final void rule__HttpServerOutcome__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3655:1: ( ( ( rule__HttpServerOutcome__NameAssignment_1 ) ) )
            // InternalAceGen.g:3656:1: ( ( rule__HttpServerOutcome__NameAssignment_1 ) )
            {
            // InternalAceGen.g:3656:1: ( ( rule__HttpServerOutcome__NameAssignment_1 ) )
            // InternalAceGen.g:3657:2: ( rule__HttpServerOutcome__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getNameAssignment_1()); 
            // InternalAceGen.g:3658:2: ( rule__HttpServerOutcome__NameAssignment_1 )
            // InternalAceGen.g:3658:3: rule__HttpServerOutcome__NameAssignment_1
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
    // InternalAceGen.g:3666:1: rule__HttpServerOutcome__Group__2 : rule__HttpServerOutcome__Group__2__Impl ;
    public final void rule__HttpServerOutcome__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3670:1: ( rule__HttpServerOutcome__Group__2__Impl )
            // InternalAceGen.g:3671:2: rule__HttpServerOutcome__Group__2__Impl
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
    // InternalAceGen.g:3677:1: rule__HttpServerOutcome__Group__2__Impl : ( ( rule__HttpServerOutcome__Group_2__0 )* ) ;
    public final void rule__HttpServerOutcome__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3681:1: ( ( ( rule__HttpServerOutcome__Group_2__0 )* ) )
            // InternalAceGen.g:3682:1: ( ( rule__HttpServerOutcome__Group_2__0 )* )
            {
            // InternalAceGen.g:3682:1: ( ( rule__HttpServerOutcome__Group_2__0 )* )
            // InternalAceGen.g:3683:2: ( rule__HttpServerOutcome__Group_2__0 )*
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getGroup_2()); 
            // InternalAceGen.g:3684:2: ( rule__HttpServerOutcome__Group_2__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==37) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalAceGen.g:3684:3: rule__HttpServerOutcome__Group_2__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__HttpServerOutcome__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
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
    // InternalAceGen.g:3693:1: rule__HttpServerOutcome__Group_2__0 : rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1 ;
    public final void rule__HttpServerOutcome__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3697:1: ( rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1 )
            // InternalAceGen.g:3698:2: rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1
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
    // InternalAceGen.g:3705:1: rule__HttpServerOutcome__Group_2__0__Impl : ( '(' ) ;
    public final void rule__HttpServerOutcome__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3709:1: ( ( '(' ) )
            // InternalAceGen.g:3710:1: ( '(' )
            {
            // InternalAceGen.g:3710:1: ( '(' )
            // InternalAceGen.g:3711:2: '('
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
    // InternalAceGen.g:3720:1: rule__HttpServerOutcome__Group_2__1 : rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2 ;
    public final void rule__HttpServerOutcome__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3724:1: ( rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2 )
            // InternalAceGen.g:3725:2: rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2
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
    // InternalAceGen.g:3732:1: rule__HttpServerOutcome__Group_2__1__Impl : ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* ) ;
    public final void rule__HttpServerOutcome__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3736:1: ( ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* ) )
            // InternalAceGen.g:3737:1: ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* )
            {
            // InternalAceGen.g:3737:1: ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* )
            // InternalAceGen.g:3738:2: ( rule__HttpServerOutcome__ListenersAssignment_2_1 )*
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getListenersAssignment_2_1()); 
            // InternalAceGen.g:3739:2: ( rule__HttpServerOutcome__ListenersAssignment_2_1 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalAceGen.g:3739:3: rule__HttpServerOutcome__ListenersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerOutcome__ListenersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
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
    // InternalAceGen.g:3747:1: rule__HttpServerOutcome__Group_2__2 : rule__HttpServerOutcome__Group_2__2__Impl ;
    public final void rule__HttpServerOutcome__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3751:1: ( rule__HttpServerOutcome__Group_2__2__Impl )
            // InternalAceGen.g:3752:2: rule__HttpServerOutcome__Group_2__2__Impl
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
    // InternalAceGen.g:3758:1: rule__HttpServerOutcome__Group_2__2__Impl : ( ')' ) ;
    public final void rule__HttpServerOutcome__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3762:1: ( ( ')' ) )
            // InternalAceGen.g:3763:1: ( ')' )
            {
            // InternalAceGen.g:3763:1: ( ')' )
            // InternalAceGen.g:3764:2: ')'
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


    // $ANTLR start "rule__HttpServerAceRead__Group__0"
    // InternalAceGen.g:3774:1: rule__HttpServerAceRead__Group__0 : rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1 ;
    public final void rule__HttpServerAceRead__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3778:1: ( rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1 )
            // InternalAceGen.g:3779:2: rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1
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
    // InternalAceGen.g:3786:1: rule__HttpServerAceRead__Group__0__Impl : ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? ) ;
    public final void rule__HttpServerAceRead__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3790:1: ( ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? ) )
            // InternalAceGen.g:3791:1: ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? )
            {
            // InternalAceGen.g:3791:1: ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? )
            // InternalAceGen.g:3792:2: ( rule__HttpServerAceRead__ProxyAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyAssignment_0()); 
            // InternalAceGen.g:3793:2: ( rule__HttpServerAceRead__ProxyAssignment_0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==67) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalAceGen.g:3793:3: rule__HttpServerAceRead__ProxyAssignment_0
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
    // InternalAceGen.g:3801:1: rule__HttpServerAceRead__Group__1 : rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2 ;
    public final void rule__HttpServerAceRead__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3805:1: ( rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2 )
            // InternalAceGen.g:3806:2: rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2
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
    // InternalAceGen.g:3813:1: rule__HttpServerAceRead__Group__1__Impl : ( ( rule__HttpServerAceRead__NameAssignment_1 ) ) ;
    public final void rule__HttpServerAceRead__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3817:1: ( ( ( rule__HttpServerAceRead__NameAssignment_1 ) ) )
            // InternalAceGen.g:3818:1: ( ( rule__HttpServerAceRead__NameAssignment_1 ) )
            {
            // InternalAceGen.g:3818:1: ( ( rule__HttpServerAceRead__NameAssignment_1 ) )
            // InternalAceGen.g:3819:2: ( rule__HttpServerAceRead__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getNameAssignment_1()); 
            // InternalAceGen.g:3820:2: ( rule__HttpServerAceRead__NameAssignment_1 )
            // InternalAceGen.g:3820:3: rule__HttpServerAceRead__NameAssignment_1
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
    // InternalAceGen.g:3828:1: rule__HttpServerAceRead__Group__2 : rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3 ;
    public final void rule__HttpServerAceRead__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3832:1: ( rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3 )
            // InternalAceGen.g:3833:2: rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3
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
    // InternalAceGen.g:3840:1: rule__HttpServerAceRead__Group__2__Impl : ( '<' ) ;
    public final void rule__HttpServerAceRead__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3844:1: ( ( '<' ) )
            // InternalAceGen.g:3845:1: ( '<' )
            {
            // InternalAceGen.g:3845:1: ( '<' )
            // InternalAceGen.g:3846:2: '<'
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
    // InternalAceGen.g:3855:1: rule__HttpServerAceRead__Group__3 : rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4 ;
    public final void rule__HttpServerAceRead__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3859:1: ( rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4 )
            // InternalAceGen.g:3860:2: rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4
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
    // InternalAceGen.g:3867:1: rule__HttpServerAceRead__Group__3__Impl : ( ( rule__HttpServerAceRead__ModelAssignment_3 ) ) ;
    public final void rule__HttpServerAceRead__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3871:1: ( ( ( rule__HttpServerAceRead__ModelAssignment_3 ) ) )
            // InternalAceGen.g:3872:1: ( ( rule__HttpServerAceRead__ModelAssignment_3 ) )
            {
            // InternalAceGen.g:3872:1: ( ( rule__HttpServerAceRead__ModelAssignment_3 ) )
            // InternalAceGen.g:3873:2: ( rule__HttpServerAceRead__ModelAssignment_3 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getModelAssignment_3()); 
            // InternalAceGen.g:3874:2: ( rule__HttpServerAceRead__ModelAssignment_3 )
            // InternalAceGen.g:3874:3: rule__HttpServerAceRead__ModelAssignment_3
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
    // InternalAceGen.g:3882:1: rule__HttpServerAceRead__Group__4 : rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5 ;
    public final void rule__HttpServerAceRead__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3886:1: ( rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5 )
            // InternalAceGen.g:3887:2: rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5
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
    // InternalAceGen.g:3894:1: rule__HttpServerAceRead__Group__4__Impl : ( '>' ) ;
    public final void rule__HttpServerAceRead__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3898:1: ( ( '>' ) )
            // InternalAceGen.g:3899:1: ( '>' )
            {
            // InternalAceGen.g:3899:1: ( '>' )
            // InternalAceGen.g:3900:2: '>'
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
    // InternalAceGen.g:3909:1: rule__HttpServerAceRead__Group__5 : rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6 ;
    public final void rule__HttpServerAceRead__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3913:1: ( rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6 )
            // InternalAceGen.g:3914:2: rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6
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
    // InternalAceGen.g:3921:1: rule__HttpServerAceRead__Group__5__Impl : ( ( rule__HttpServerAceRead__TypeAssignment_5 ) ) ;
    public final void rule__HttpServerAceRead__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3925:1: ( ( ( rule__HttpServerAceRead__TypeAssignment_5 ) ) )
            // InternalAceGen.g:3926:1: ( ( rule__HttpServerAceRead__TypeAssignment_5 ) )
            {
            // InternalAceGen.g:3926:1: ( ( rule__HttpServerAceRead__TypeAssignment_5 ) )
            // InternalAceGen.g:3927:2: ( rule__HttpServerAceRead__TypeAssignment_5 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getTypeAssignment_5()); 
            // InternalAceGen.g:3928:2: ( rule__HttpServerAceRead__TypeAssignment_5 )
            // InternalAceGen.g:3928:3: rule__HttpServerAceRead__TypeAssignment_5
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
    // InternalAceGen.g:3936:1: rule__HttpServerAceRead__Group__6 : rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7 ;
    public final void rule__HttpServerAceRead__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3940:1: ( rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7 )
            // InternalAceGen.g:3941:2: rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7
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
    // InternalAceGen.g:3948:1: rule__HttpServerAceRead__Group__6__Impl : ( ( rule__HttpServerAceRead__UrlAssignment_6 ) ) ;
    public final void rule__HttpServerAceRead__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3952:1: ( ( ( rule__HttpServerAceRead__UrlAssignment_6 ) ) )
            // InternalAceGen.g:3953:1: ( ( rule__HttpServerAceRead__UrlAssignment_6 ) )
            {
            // InternalAceGen.g:3953:1: ( ( rule__HttpServerAceRead__UrlAssignment_6 ) )
            // InternalAceGen.g:3954:2: ( rule__HttpServerAceRead__UrlAssignment_6 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getUrlAssignment_6()); 
            // InternalAceGen.g:3955:2: ( rule__HttpServerAceRead__UrlAssignment_6 )
            // InternalAceGen.g:3955:3: rule__HttpServerAceRead__UrlAssignment_6
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
    // InternalAceGen.g:3963:1: rule__HttpServerAceRead__Group__7 : rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8 ;
    public final void rule__HttpServerAceRead__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3967:1: ( rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8 )
            // InternalAceGen.g:3968:2: rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8
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
    // InternalAceGen.g:3975:1: rule__HttpServerAceRead__Group__7__Impl : ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? ) ;
    public final void rule__HttpServerAceRead__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3979:1: ( ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? ) )
            // InternalAceGen.g:3980:1: ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? )
            {
            // InternalAceGen.g:3980:1: ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? )
            // InternalAceGen.g:3981:2: ( rule__HttpServerAceRead__AuthorizeAssignment_7 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAssignment_7()); 
            // InternalAceGen.g:3982:2: ( rule__HttpServerAceRead__AuthorizeAssignment_7 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==68) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalAceGen.g:3982:3: rule__HttpServerAceRead__AuthorizeAssignment_7
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
    // InternalAceGen.g:3990:1: rule__HttpServerAceRead__Group__8 : rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9 ;
    public final void rule__HttpServerAceRead__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3994:1: ( rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9 )
            // InternalAceGen.g:3995:2: rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9
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
    // InternalAceGen.g:4002:1: rule__HttpServerAceRead__Group__8__Impl : ( ( rule__HttpServerAceRead__Group_8__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4006:1: ( ( ( rule__HttpServerAceRead__Group_8__0 )? ) )
            // InternalAceGen.g:4007:1: ( ( rule__HttpServerAceRead__Group_8__0 )? )
            {
            // InternalAceGen.g:4007:1: ( ( rule__HttpServerAceRead__Group_8__0 )? )
            // InternalAceGen.g:4008:2: ( rule__HttpServerAceRead__Group_8__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_8()); 
            // InternalAceGen.g:4009:2: ( rule__HttpServerAceRead__Group_8__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==49) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalAceGen.g:4009:3: rule__HttpServerAceRead__Group_8__0
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
    // InternalAceGen.g:4017:1: rule__HttpServerAceRead__Group__9 : rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10 ;
    public final void rule__HttpServerAceRead__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4021:1: ( rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10 )
            // InternalAceGen.g:4022:2: rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10
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
    // InternalAceGen.g:4029:1: rule__HttpServerAceRead__Group__9__Impl : ( ( rule__HttpServerAceRead__Group_9__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4033:1: ( ( ( rule__HttpServerAceRead__Group_9__0 )? ) )
            // InternalAceGen.g:4034:1: ( ( rule__HttpServerAceRead__Group_9__0 )? )
            {
            // InternalAceGen.g:4034:1: ( ( rule__HttpServerAceRead__Group_9__0 )? )
            // InternalAceGen.g:4035:2: ( rule__HttpServerAceRead__Group_9__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_9()); 
            // InternalAceGen.g:4036:2: ( rule__HttpServerAceRead__Group_9__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==50) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalAceGen.g:4036:3: rule__HttpServerAceRead__Group_9__0
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
    // InternalAceGen.g:4044:1: rule__HttpServerAceRead__Group__10 : rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11 ;
    public final void rule__HttpServerAceRead__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4048:1: ( rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11 )
            // InternalAceGen.g:4049:2: rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11
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
    // InternalAceGen.g:4056:1: rule__HttpServerAceRead__Group__10__Impl : ( ( rule__HttpServerAceRead__Group_10__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4060:1: ( ( ( rule__HttpServerAceRead__Group_10__0 )? ) )
            // InternalAceGen.g:4061:1: ( ( rule__HttpServerAceRead__Group_10__0 )? )
            {
            // InternalAceGen.g:4061:1: ( ( rule__HttpServerAceRead__Group_10__0 )? )
            // InternalAceGen.g:4062:2: ( rule__HttpServerAceRead__Group_10__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_10()); 
            // InternalAceGen.g:4063:2: ( rule__HttpServerAceRead__Group_10__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==51) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalAceGen.g:4063:3: rule__HttpServerAceRead__Group_10__0
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
    // InternalAceGen.g:4071:1: rule__HttpServerAceRead__Group__11 : rule__HttpServerAceRead__Group__11__Impl ;
    public final void rule__HttpServerAceRead__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4075:1: ( rule__HttpServerAceRead__Group__11__Impl )
            // InternalAceGen.g:4076:2: rule__HttpServerAceRead__Group__11__Impl
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
    // InternalAceGen.g:4082:1: rule__HttpServerAceRead__Group__11__Impl : ( ( rule__HttpServerAceRead__Group_11__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4086:1: ( ( ( rule__HttpServerAceRead__Group_11__0 )? ) )
            // InternalAceGen.g:4087:1: ( ( rule__HttpServerAceRead__Group_11__0 )? )
            {
            // InternalAceGen.g:4087:1: ( ( rule__HttpServerAceRead__Group_11__0 )? )
            // InternalAceGen.g:4088:2: ( rule__HttpServerAceRead__Group_11__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_11()); 
            // InternalAceGen.g:4089:2: ( rule__HttpServerAceRead__Group_11__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==52) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalAceGen.g:4089:3: rule__HttpServerAceRead__Group_11__0
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
    // InternalAceGen.g:4098:1: rule__HttpServerAceRead__Group_8__0 : rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1 ;
    public final void rule__HttpServerAceRead__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4102:1: ( rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1 )
            // InternalAceGen.g:4103:2: rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1
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
    // InternalAceGen.g:4110:1: rule__HttpServerAceRead__Group_8__0__Impl : ( 'pathParams' ) ;
    public final void rule__HttpServerAceRead__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4114:1: ( ( 'pathParams' ) )
            // InternalAceGen.g:4115:1: ( 'pathParams' )
            {
            // InternalAceGen.g:4115:1: ( 'pathParams' )
            // InternalAceGen.g:4116:2: 'pathParams'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_8_0()); 
            match(input,49,FOLLOW_2); 
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
    // InternalAceGen.g:4125:1: rule__HttpServerAceRead__Group_8__1 : rule__HttpServerAceRead__Group_8__1__Impl ;
    public final void rule__HttpServerAceRead__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4129:1: ( rule__HttpServerAceRead__Group_8__1__Impl )
            // InternalAceGen.g:4130:2: rule__HttpServerAceRead__Group_8__1__Impl
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
    // InternalAceGen.g:4136:1: rule__HttpServerAceRead__Group_8__1__Impl : ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4140:1: ( ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* ) )
            // InternalAceGen.g:4141:1: ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* )
            {
            // InternalAceGen.g:4141:1: ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* )
            // InternalAceGen.g:4142:2: ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsAssignment_8_1()); 
            // InternalAceGen.g:4143:2: ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ID) ) {
                    int LA58_2 = input.LA(2);

                    if ( (LA58_2==EOF||LA58_2==RULE_ID||(LA58_2>=46 && LA58_2<=48)||(LA58_2>=50 && LA58_2<=52)||LA58_2==63||LA58_2==67) ) {
                        alt58=1;
                    }


                }


                switch (alt58) {
            	case 1 :
            	    // InternalAceGen.g:4143:3: rule__HttpServerAceRead__PathParamsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceRead__PathParamsAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
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
    // InternalAceGen.g:4152:1: rule__HttpServerAceRead__Group_9__0 : rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1 ;
    public final void rule__HttpServerAceRead__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4156:1: ( rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1 )
            // InternalAceGen.g:4157:2: rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1
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
    // InternalAceGen.g:4164:1: rule__HttpServerAceRead__Group_9__0__Impl : ( 'queryParams' ) ;
    public final void rule__HttpServerAceRead__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4168:1: ( ( 'queryParams' ) )
            // InternalAceGen.g:4169:1: ( 'queryParams' )
            {
            // InternalAceGen.g:4169:1: ( 'queryParams' )
            // InternalAceGen.g:4170:2: 'queryParams'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_9_0()); 
            match(input,50,FOLLOW_2); 
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
    // InternalAceGen.g:4179:1: rule__HttpServerAceRead__Group_9__1 : rule__HttpServerAceRead__Group_9__1__Impl ;
    public final void rule__HttpServerAceRead__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4183:1: ( rule__HttpServerAceRead__Group_9__1__Impl )
            // InternalAceGen.g:4184:2: rule__HttpServerAceRead__Group_9__1__Impl
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
    // InternalAceGen.g:4190:1: rule__HttpServerAceRead__Group_9__1__Impl : ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4194:1: ( ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* ) )
            // InternalAceGen.g:4195:1: ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* )
            {
            // InternalAceGen.g:4195:1: ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* )
            // InternalAceGen.g:4196:2: ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAssignment_9_1()); 
            // InternalAceGen.g:4197:2: ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_ID) ) {
                    int LA59_2 = input.LA(2);

                    if ( (LA59_2==EOF||LA59_2==RULE_ID||(LA59_2>=46 && LA59_2<=48)||(LA59_2>=51 && LA59_2<=52)||LA59_2==63||LA59_2==67) ) {
                        alt59=1;
                    }


                }


                switch (alt59) {
            	case 1 :
            	    // InternalAceGen.g:4197:3: rule__HttpServerAceRead__QueryParamsAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceRead__QueryParamsAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop59;
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
    // InternalAceGen.g:4206:1: rule__HttpServerAceRead__Group_10__0 : rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1 ;
    public final void rule__HttpServerAceRead__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4210:1: ( rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1 )
            // InternalAceGen.g:4211:2: rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1
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
    // InternalAceGen.g:4218:1: rule__HttpServerAceRead__Group_10__0__Impl : ( 'payload' ) ;
    public final void rule__HttpServerAceRead__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4222:1: ( ( 'payload' ) )
            // InternalAceGen.g:4223:1: ( 'payload' )
            {
            // InternalAceGen.g:4223:1: ( 'payload' )
            // InternalAceGen.g:4224:2: 'payload'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_10_0()); 
            match(input,51,FOLLOW_2); 
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
    // InternalAceGen.g:4233:1: rule__HttpServerAceRead__Group_10__1 : rule__HttpServerAceRead__Group_10__1__Impl ;
    public final void rule__HttpServerAceRead__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4237:1: ( rule__HttpServerAceRead__Group_10__1__Impl )
            // InternalAceGen.g:4238:2: rule__HttpServerAceRead__Group_10__1__Impl
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
    // InternalAceGen.g:4244:1: rule__HttpServerAceRead__Group_10__1__Impl : ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4248:1: ( ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* ) )
            // InternalAceGen.g:4249:1: ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* )
            {
            // InternalAceGen.g:4249:1: ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* )
            // InternalAceGen.g:4250:2: ( rule__HttpServerAceRead__PayloadAssignment_10_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadAssignment_10_1()); 
            // InternalAceGen.g:4251:2: ( rule__HttpServerAceRead__PayloadAssignment_10_1 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID) ) {
                    int LA60_2 = input.LA(2);

                    if ( (LA60_2==EOF||LA60_2==RULE_ID||(LA60_2>=46 && LA60_2<=48)||LA60_2==52||LA60_2==63||LA60_2==67) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // InternalAceGen.g:4251:3: rule__HttpServerAceRead__PayloadAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceRead__PayloadAssignment_10_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop60;
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
    // InternalAceGen.g:4260:1: rule__HttpServerAceRead__Group_11__0 : rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1 ;
    public final void rule__HttpServerAceRead__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4264:1: ( rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1 )
            // InternalAceGen.g:4265:2: rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1
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
    // InternalAceGen.g:4272:1: rule__HttpServerAceRead__Group_11__0__Impl : ( 'response' ) ;
    public final void rule__HttpServerAceRead__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4276:1: ( ( 'response' ) )
            // InternalAceGen.g:4277:1: ( 'response' )
            {
            // InternalAceGen.g:4277:1: ( 'response' )
            // InternalAceGen.g:4278:2: 'response'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_11_0()); 
            match(input,52,FOLLOW_2); 
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
    // InternalAceGen.g:4287:1: rule__HttpServerAceRead__Group_11__1 : rule__HttpServerAceRead__Group_11__1__Impl ;
    public final void rule__HttpServerAceRead__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4291:1: ( rule__HttpServerAceRead__Group_11__1__Impl )
            // InternalAceGen.g:4292:2: rule__HttpServerAceRead__Group_11__1__Impl
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
    // InternalAceGen.g:4298:1: rule__HttpServerAceRead__Group_11__1__Impl : ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4302:1: ( ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* ) )
            // InternalAceGen.g:4303:1: ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* )
            {
            // InternalAceGen.g:4303:1: ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* )
            // InternalAceGen.g:4304:2: ( rule__HttpServerAceRead__ResponseAssignment_11_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseAssignment_11_1()); 
            // InternalAceGen.g:4305:2: ( rule__HttpServerAceRead__ResponseAssignment_11_1 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_ID) ) {
                    int LA61_2 = input.LA(2);

                    if ( (LA61_2==EOF||LA61_2==RULE_ID||(LA61_2>=46 && LA61_2<=48)||LA61_2==63||LA61_2==67) ) {
                        alt61=1;
                    }


                }


                switch (alt61) {
            	case 1 :
            	    // InternalAceGen.g:4305:3: rule__HttpServerAceRead__ResponseAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerAceRead__ResponseAssignment_11_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop61;
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
    // InternalAceGen.g:4314:1: rule__HttpServerView__Group__0 : rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1 ;
    public final void rule__HttpServerView__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4318:1: ( rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1 )
            // InternalAceGen.g:4319:2: rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1
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
    // InternalAceGen.g:4326:1: rule__HttpServerView__Group__0__Impl : ( ( rule__HttpServerView__NameAssignment_0 ) ) ;
    public final void rule__HttpServerView__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4330:1: ( ( ( rule__HttpServerView__NameAssignment_0 ) ) )
            // InternalAceGen.g:4331:1: ( ( rule__HttpServerView__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4331:1: ( ( rule__HttpServerView__NameAssignment_0 ) )
            // InternalAceGen.g:4332:2: ( rule__HttpServerView__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerViewAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4333:2: ( rule__HttpServerView__NameAssignment_0 )
            // InternalAceGen.g:4333:3: rule__HttpServerView__NameAssignment_0
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
    // InternalAceGen.g:4341:1: rule__HttpServerView__Group__1 : rule__HttpServerView__Group__1__Impl ;
    public final void rule__HttpServerView__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4345:1: ( rule__HttpServerView__Group__1__Impl )
            // InternalAceGen.g:4346:2: rule__HttpServerView__Group__1__Impl
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
    // InternalAceGen.g:4352:1: rule__HttpServerView__Group__1__Impl : ( ( rule__HttpServerView__Group_1__0 )? ) ;
    public final void rule__HttpServerView__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4356:1: ( ( ( rule__HttpServerView__Group_1__0 )? ) )
            // InternalAceGen.g:4357:1: ( ( rule__HttpServerView__Group_1__0 )? )
            {
            // InternalAceGen.g:4357:1: ( ( rule__HttpServerView__Group_1__0 )? )
            // InternalAceGen.g:4358:2: ( rule__HttpServerView__Group_1__0 )?
            {
             before(grammarAccess.getHttpServerViewAccess().getGroup_1()); 
            // InternalAceGen.g:4359:2: ( rule__HttpServerView__Group_1__0 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==42) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalAceGen.g:4359:3: rule__HttpServerView__Group_1__0
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
    // InternalAceGen.g:4368:1: rule__HttpServerView__Group_1__0 : rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1 ;
    public final void rule__HttpServerView__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4372:1: ( rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1 )
            // InternalAceGen.g:4373:2: rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1
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
    // InternalAceGen.g:4380:1: rule__HttpServerView__Group_1__0__Impl : ( '{' ) ;
    public final void rule__HttpServerView__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4384:1: ( ( '{' ) )
            // InternalAceGen.g:4385:1: ( '{' )
            {
            // InternalAceGen.g:4385:1: ( '{' )
            // InternalAceGen.g:4386:2: '{'
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
    // InternalAceGen.g:4395:1: rule__HttpServerView__Group_1__1 : rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2 ;
    public final void rule__HttpServerView__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4399:1: ( rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2 )
            // InternalAceGen.g:4400:2: rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2
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
    // InternalAceGen.g:4407:1: rule__HttpServerView__Group_1__1__Impl : ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* ) ;
    public final void rule__HttpServerView__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4411:1: ( ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* ) )
            // InternalAceGen.g:4412:1: ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* )
            {
            // InternalAceGen.g:4412:1: ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* )
            // InternalAceGen.g:4413:2: ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )*
            {
             before(grammarAccess.getHttpServerViewAccess().getRenderFunctionsAssignment_1_1()); 
            // InternalAceGen.g:4414:2: ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ID) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalAceGen.g:4414:3: rule__HttpServerView__RenderFunctionsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__HttpServerView__RenderFunctionsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
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
    // InternalAceGen.g:4422:1: rule__HttpServerView__Group_1__2 : rule__HttpServerView__Group_1__2__Impl ;
    public final void rule__HttpServerView__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4426:1: ( rule__HttpServerView__Group_1__2__Impl )
            // InternalAceGen.g:4427:2: rule__HttpServerView__Group_1__2__Impl
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
    // InternalAceGen.g:4433:1: rule__HttpServerView__Group_1__2__Impl : ( '}' ) ;
    public final void rule__HttpServerView__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4437:1: ( ( '}' ) )
            // InternalAceGen.g:4438:1: ( '}' )
            {
            // InternalAceGen.g:4438:1: ( '}' )
            // InternalAceGen.g:4439:2: '}'
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
    // InternalAceGen.g:4449:1: rule__HttpServerViewFunction__Group__0 : rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1 ;
    public final void rule__HttpServerViewFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4453:1: ( rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1 )
            // InternalAceGen.g:4454:2: rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1
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
    // InternalAceGen.g:4461:1: rule__HttpServerViewFunction__Group__0__Impl : ( ( rule__HttpServerViewFunction__NameAssignment_0 ) ) ;
    public final void rule__HttpServerViewFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4465:1: ( ( ( rule__HttpServerViewFunction__NameAssignment_0 ) ) )
            // InternalAceGen.g:4466:1: ( ( rule__HttpServerViewFunction__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4466:1: ( ( rule__HttpServerViewFunction__NameAssignment_0 ) )
            // InternalAceGen.g:4467:2: ( rule__HttpServerViewFunction__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4468:2: ( rule__HttpServerViewFunction__NameAssignment_0 )
            // InternalAceGen.g:4468:3: rule__HttpServerViewFunction__NameAssignment_0
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
    // InternalAceGen.g:4476:1: rule__HttpServerViewFunction__Group__1 : rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2 ;
    public final void rule__HttpServerViewFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4480:1: ( rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2 )
            // InternalAceGen.g:4481:2: rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2
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
    // InternalAceGen.g:4488:1: rule__HttpServerViewFunction__Group__1__Impl : ( '(' ) ;
    public final void rule__HttpServerViewFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4492:1: ( ( '(' ) )
            // InternalAceGen.g:4493:1: ( '(' )
            {
            // InternalAceGen.g:4493:1: ( '(' )
            // InternalAceGen.g:4494:2: '('
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
    // InternalAceGen.g:4503:1: rule__HttpServerViewFunction__Group__2 : rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3 ;
    public final void rule__HttpServerViewFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4507:1: ( rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3 )
            // InternalAceGen.g:4508:2: rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3
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
    // InternalAceGen.g:4515:1: rule__HttpServerViewFunction__Group__2__Impl : ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) ) ;
    public final void rule__HttpServerViewFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4519:1: ( ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) ) )
            // InternalAceGen.g:4520:1: ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) )
            {
            // InternalAceGen.g:4520:1: ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) )
            // InternalAceGen.g:4521:2: ( rule__HttpServerViewFunction__ModelAssignment_2 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getModelAssignment_2()); 
            // InternalAceGen.g:4522:2: ( rule__HttpServerViewFunction__ModelAssignment_2 )
            // InternalAceGen.g:4522:3: rule__HttpServerViewFunction__ModelAssignment_2
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
    // InternalAceGen.g:4530:1: rule__HttpServerViewFunction__Group__3 : rule__HttpServerViewFunction__Group__3__Impl ;
    public final void rule__HttpServerViewFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4534:1: ( rule__HttpServerViewFunction__Group__3__Impl )
            // InternalAceGen.g:4535:2: rule__HttpServerViewFunction__Group__3__Impl
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
    // InternalAceGen.g:4541:1: rule__HttpServerViewFunction__Group__3__Impl : ( ')' ) ;
    public final void rule__HttpServerViewFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4545:1: ( ( ')' ) )
            // InternalAceGen.g:4546:1: ( ')' )
            {
            // InternalAceGen.g:4546:1: ( ')' )
            // InternalAceGen.g:4547:2: ')'
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
    // InternalAceGen.g:4557:1: rule__AuthUser__Group__0 : rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1 ;
    public final void rule__AuthUser__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4561:1: ( rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1 )
            // InternalAceGen.g:4562:2: rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1
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
    // InternalAceGen.g:4569:1: rule__AuthUser__Group__0__Impl : ( ( rule__AuthUser__NameAssignment_0 ) ) ;
    public final void rule__AuthUser__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4573:1: ( ( ( rule__AuthUser__NameAssignment_0 ) ) )
            // InternalAceGen.g:4574:1: ( ( rule__AuthUser__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4574:1: ( ( rule__AuthUser__NameAssignment_0 ) )
            // InternalAceGen.g:4575:2: ( rule__AuthUser__NameAssignment_0 )
            {
             before(grammarAccess.getAuthUserAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4576:2: ( rule__AuthUser__NameAssignment_0 )
            // InternalAceGen.g:4576:3: rule__AuthUser__NameAssignment_0
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
    // InternalAceGen.g:4584:1: rule__AuthUser__Group__1 : rule__AuthUser__Group__1__Impl ;
    public final void rule__AuthUser__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4588:1: ( rule__AuthUser__Group__1__Impl )
            // InternalAceGen.g:4589:2: rule__AuthUser__Group__1__Impl
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
    // InternalAceGen.g:4595:1: rule__AuthUser__Group__1__Impl : ( ( rule__AuthUser__Group_1__0 ) ) ;
    public final void rule__AuthUser__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4599:1: ( ( ( rule__AuthUser__Group_1__0 ) ) )
            // InternalAceGen.g:4600:1: ( ( rule__AuthUser__Group_1__0 ) )
            {
            // InternalAceGen.g:4600:1: ( ( rule__AuthUser__Group_1__0 ) )
            // InternalAceGen.g:4601:2: ( rule__AuthUser__Group_1__0 )
            {
             before(grammarAccess.getAuthUserAccess().getGroup_1()); 
            // InternalAceGen.g:4602:2: ( rule__AuthUser__Group_1__0 )
            // InternalAceGen.g:4602:3: rule__AuthUser__Group_1__0
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
    // InternalAceGen.g:4611:1: rule__AuthUser__Group_1__0 : rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1 ;
    public final void rule__AuthUser__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4615:1: ( rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1 )
            // InternalAceGen.g:4616:2: rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1
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
    // InternalAceGen.g:4623:1: rule__AuthUser__Group_1__0__Impl : ( '{' ) ;
    public final void rule__AuthUser__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4627:1: ( ( '{' ) )
            // InternalAceGen.g:4628:1: ( '{' )
            {
            // InternalAceGen.g:4628:1: ( '{' )
            // InternalAceGen.g:4629:2: '{'
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
    // InternalAceGen.g:4638:1: rule__AuthUser__Group_1__1 : rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2 ;
    public final void rule__AuthUser__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4642:1: ( rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2 )
            // InternalAceGen.g:4643:2: rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2
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
    // InternalAceGen.g:4650:1: rule__AuthUser__Group_1__1__Impl : ( ( rule__AuthUser__AttributesAssignment_1_1 )* ) ;
    public final void rule__AuthUser__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4654:1: ( ( ( rule__AuthUser__AttributesAssignment_1_1 )* ) )
            // InternalAceGen.g:4655:1: ( ( rule__AuthUser__AttributesAssignment_1_1 )* )
            {
            // InternalAceGen.g:4655:1: ( ( rule__AuthUser__AttributesAssignment_1_1 )* )
            // InternalAceGen.g:4656:2: ( rule__AuthUser__AttributesAssignment_1_1 )*
            {
             before(grammarAccess.getAuthUserAccess().getAttributesAssignment_1_1()); 
            // InternalAceGen.g:4657:2: ( rule__AuthUser__AttributesAssignment_1_1 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID||(LA64_0>=19 && LA64_0<=26)||(LA64_0>=70 && LA64_0<=72)) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalAceGen.g:4657:3: rule__AuthUser__AttributesAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__AuthUser__AttributesAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
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
    // InternalAceGen.g:4665:1: rule__AuthUser__Group_1__2 : rule__AuthUser__Group_1__2__Impl ;
    public final void rule__AuthUser__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4669:1: ( rule__AuthUser__Group_1__2__Impl )
            // InternalAceGen.g:4670:2: rule__AuthUser__Group_1__2__Impl
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
    // InternalAceGen.g:4676:1: rule__AuthUser__Group_1__2__Impl : ( '}' ) ;
    public final void rule__AuthUser__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4680:1: ( ( '}' ) )
            // InternalAceGen.g:4681:1: ( '}' )
            {
            // InternalAceGen.g:4681:1: ( '}' )
            // InternalAceGen.g:4682:2: '}'
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
    // InternalAceGen.g:4692:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4696:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalAceGen.g:4697:2: rule__Model__Group__0__Impl rule__Model__Group__1
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
    // InternalAceGen.g:4704:1: rule__Model__Group__0__Impl : ( ( rule__Model__PersistentAssignment_0 )? ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4708:1: ( ( ( rule__Model__PersistentAssignment_0 )? ) )
            // InternalAceGen.g:4709:1: ( ( rule__Model__PersistentAssignment_0 )? )
            {
            // InternalAceGen.g:4709:1: ( ( rule__Model__PersistentAssignment_0 )? )
            // InternalAceGen.g:4710:2: ( rule__Model__PersistentAssignment_0 )?
            {
             before(grammarAccess.getModelAccess().getPersistentAssignment_0()); 
            // InternalAceGen.g:4711:2: ( rule__Model__PersistentAssignment_0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==69) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalAceGen.g:4711:3: rule__Model__PersistentAssignment_0
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
    // InternalAceGen.g:4719:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4723:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalAceGen.g:4724:2: rule__Model__Group__1__Impl rule__Model__Group__2
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
    // InternalAceGen.g:4731:1: rule__Model__Group__1__Impl : ( ( rule__Model__NameAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4735:1: ( ( ( rule__Model__NameAssignment_1 ) ) )
            // InternalAceGen.g:4736:1: ( ( rule__Model__NameAssignment_1 ) )
            {
            // InternalAceGen.g:4736:1: ( ( rule__Model__NameAssignment_1 ) )
            // InternalAceGen.g:4737:2: ( rule__Model__NameAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1()); 
            // InternalAceGen.g:4738:2: ( rule__Model__NameAssignment_1 )
            // InternalAceGen.g:4738:3: rule__Model__NameAssignment_1
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
    // InternalAceGen.g:4746:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4750:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalAceGen.g:4751:2: rule__Model__Group__2__Impl rule__Model__Group__3
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
    // InternalAceGen.g:4758:1: rule__Model__Group__2__Impl : ( ( rule__Model__Group_2__0 )? ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4762:1: ( ( ( rule__Model__Group_2__0 )? ) )
            // InternalAceGen.g:4763:1: ( ( rule__Model__Group_2__0 )? )
            {
            // InternalAceGen.g:4763:1: ( ( rule__Model__Group_2__0 )? )
            // InternalAceGen.g:4764:2: ( rule__Model__Group_2__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalAceGen.g:4765:2: ( rule__Model__Group_2__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==53) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalAceGen.g:4765:3: rule__Model__Group_2__0
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
    // InternalAceGen.g:4773:1: rule__Model__Group__3 : rule__Model__Group__3__Impl ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4777:1: ( rule__Model__Group__3__Impl )
            // InternalAceGen.g:4778:2: rule__Model__Group__3__Impl
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
    // InternalAceGen.g:4784:1: rule__Model__Group__3__Impl : ( ( rule__Model__Group_3__0 )? ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4788:1: ( ( ( rule__Model__Group_3__0 )? ) )
            // InternalAceGen.g:4789:1: ( ( rule__Model__Group_3__0 )? )
            {
            // InternalAceGen.g:4789:1: ( ( rule__Model__Group_3__0 )? )
            // InternalAceGen.g:4790:2: ( rule__Model__Group_3__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_3()); 
            // InternalAceGen.g:4791:2: ( rule__Model__Group_3__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==42) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalAceGen.g:4791:3: rule__Model__Group_3__0
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
    // InternalAceGen.g:4800:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4804:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalAceGen.g:4805:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
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
    // InternalAceGen.g:4812:1: rule__Model__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4816:1: ( ( 'extends' ) )
            // InternalAceGen.g:4817:1: ( 'extends' )
            {
            // InternalAceGen.g:4817:1: ( 'extends' )
            // InternalAceGen.g:4818:2: 'extends'
            {
             before(grammarAccess.getModelAccess().getExtendsKeyword_2_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalAceGen.g:4827:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl rule__Model__Group_2__2 ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4831:1: ( rule__Model__Group_2__1__Impl rule__Model__Group_2__2 )
            // InternalAceGen.g:4832:2: rule__Model__Group_2__1__Impl rule__Model__Group_2__2
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
    // InternalAceGen.g:4839:1: rule__Model__Group_2__1__Impl : ( ( rule__Model__SuperModelsAssignment_2_1 ) ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4843:1: ( ( ( rule__Model__SuperModelsAssignment_2_1 ) ) )
            // InternalAceGen.g:4844:1: ( ( rule__Model__SuperModelsAssignment_2_1 ) )
            {
            // InternalAceGen.g:4844:1: ( ( rule__Model__SuperModelsAssignment_2_1 ) )
            // InternalAceGen.g:4845:2: ( rule__Model__SuperModelsAssignment_2_1 )
            {
             before(grammarAccess.getModelAccess().getSuperModelsAssignment_2_1()); 
            // InternalAceGen.g:4846:2: ( rule__Model__SuperModelsAssignment_2_1 )
            // InternalAceGen.g:4846:3: rule__Model__SuperModelsAssignment_2_1
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
    // InternalAceGen.g:4854:1: rule__Model__Group_2__2 : rule__Model__Group_2__2__Impl ;
    public final void rule__Model__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4858:1: ( rule__Model__Group_2__2__Impl )
            // InternalAceGen.g:4859:2: rule__Model__Group_2__2__Impl
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
    // InternalAceGen.g:4865:1: rule__Model__Group_2__2__Impl : ( ( rule__Model__Group_2_2__0 )* ) ;
    public final void rule__Model__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4869:1: ( ( ( rule__Model__Group_2_2__0 )* ) )
            // InternalAceGen.g:4870:1: ( ( rule__Model__Group_2_2__0 )* )
            {
            // InternalAceGen.g:4870:1: ( ( rule__Model__Group_2_2__0 )* )
            // InternalAceGen.g:4871:2: ( rule__Model__Group_2_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_2_2()); 
            // InternalAceGen.g:4872:2: ( rule__Model__Group_2_2__0 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==33) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalAceGen.g:4872:3: rule__Model__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Model__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop68;
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
    // InternalAceGen.g:4881:1: rule__Model__Group_2_2__0 : rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1 ;
    public final void rule__Model__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4885:1: ( rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1 )
            // InternalAceGen.g:4886:2: rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1
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
    // InternalAceGen.g:4893:1: rule__Model__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Model__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4897:1: ( ( ',' ) )
            // InternalAceGen.g:4898:1: ( ',' )
            {
            // InternalAceGen.g:4898:1: ( ',' )
            // InternalAceGen.g:4899:2: ','
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
    // InternalAceGen.g:4908:1: rule__Model__Group_2_2__1 : rule__Model__Group_2_2__1__Impl ;
    public final void rule__Model__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4912:1: ( rule__Model__Group_2_2__1__Impl )
            // InternalAceGen.g:4913:2: rule__Model__Group_2_2__1__Impl
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
    // InternalAceGen.g:4919:1: rule__Model__Group_2_2__1__Impl : ( ( rule__Model__SuperModelsAssignment_2_2_1 ) ) ;
    public final void rule__Model__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4923:1: ( ( ( rule__Model__SuperModelsAssignment_2_2_1 ) ) )
            // InternalAceGen.g:4924:1: ( ( rule__Model__SuperModelsAssignment_2_2_1 ) )
            {
            // InternalAceGen.g:4924:1: ( ( rule__Model__SuperModelsAssignment_2_2_1 ) )
            // InternalAceGen.g:4925:2: ( rule__Model__SuperModelsAssignment_2_2_1 )
            {
             before(grammarAccess.getModelAccess().getSuperModelsAssignment_2_2_1()); 
            // InternalAceGen.g:4926:2: ( rule__Model__SuperModelsAssignment_2_2_1 )
            // InternalAceGen.g:4926:3: rule__Model__SuperModelsAssignment_2_2_1
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
    // InternalAceGen.g:4935:1: rule__Model__Group_3__0 : rule__Model__Group_3__0__Impl rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4939:1: ( rule__Model__Group_3__0__Impl rule__Model__Group_3__1 )
            // InternalAceGen.g:4940:2: rule__Model__Group_3__0__Impl rule__Model__Group_3__1
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
    // InternalAceGen.g:4947:1: rule__Model__Group_3__0__Impl : ( '{' ) ;
    public final void rule__Model__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4951:1: ( ( '{' ) )
            // InternalAceGen.g:4952:1: ( '{' )
            {
            // InternalAceGen.g:4952:1: ( '{' )
            // InternalAceGen.g:4953:2: '{'
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
    // InternalAceGen.g:4962:1: rule__Model__Group_3__1 : rule__Model__Group_3__1__Impl rule__Model__Group_3__2 ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4966:1: ( rule__Model__Group_3__1__Impl rule__Model__Group_3__2 )
            // InternalAceGen.g:4967:2: rule__Model__Group_3__1__Impl rule__Model__Group_3__2
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
    // InternalAceGen.g:4974:1: rule__Model__Group_3__1__Impl : ( ( rule__Model__AttributesAssignment_3_1 )* ) ;
    public final void rule__Model__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4978:1: ( ( ( rule__Model__AttributesAssignment_3_1 )* ) )
            // InternalAceGen.g:4979:1: ( ( rule__Model__AttributesAssignment_3_1 )* )
            {
            // InternalAceGen.g:4979:1: ( ( rule__Model__AttributesAssignment_3_1 )* )
            // InternalAceGen.g:4980:2: ( rule__Model__AttributesAssignment_3_1 )*
            {
             before(grammarAccess.getModelAccess().getAttributesAssignment_3_1()); 
            // InternalAceGen.g:4981:2: ( rule__Model__AttributesAssignment_3_1 )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==RULE_ID||(LA69_0>=19 && LA69_0<=26)||(LA69_0>=70 && LA69_0<=72)) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalAceGen.g:4981:3: rule__Model__AttributesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__Model__AttributesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop69;
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
    // InternalAceGen.g:4989:1: rule__Model__Group_3__2 : rule__Model__Group_3__2__Impl ;
    public final void rule__Model__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4993:1: ( rule__Model__Group_3__2__Impl )
            // InternalAceGen.g:4994:2: rule__Model__Group_3__2__Impl
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
    // InternalAceGen.g:5000:1: rule__Model__Group_3__2__Impl : ( '}' ) ;
    public final void rule__Model__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5004:1: ( ( '}' ) )
            // InternalAceGen.g:5005:1: ( '}' )
            {
            // InternalAceGen.g:5005:1: ( '}' )
            // InternalAceGen.g:5006:2: '}'
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


    // $ANTLR start "rule__Scenario__Group__0"
    // InternalAceGen.g:5016:1: rule__Scenario__Group__0 : rule__Scenario__Group__0__Impl rule__Scenario__Group__1 ;
    public final void rule__Scenario__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5020:1: ( rule__Scenario__Group__0__Impl rule__Scenario__Group__1 )
            // InternalAceGen.g:5021:2: rule__Scenario__Group__0__Impl rule__Scenario__Group__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalAceGen.g:5028:1: rule__Scenario__Group__0__Impl : ( ( rule__Scenario__NameAssignment_0 ) ) ;
    public final void rule__Scenario__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5032:1: ( ( ( rule__Scenario__NameAssignment_0 ) ) )
            // InternalAceGen.g:5033:1: ( ( rule__Scenario__NameAssignment_0 ) )
            {
            // InternalAceGen.g:5033:1: ( ( rule__Scenario__NameAssignment_0 ) )
            // InternalAceGen.g:5034:2: ( rule__Scenario__NameAssignment_0 )
            {
             before(grammarAccess.getScenarioAccess().getNameAssignment_0()); 
            // InternalAceGen.g:5035:2: ( rule__Scenario__NameAssignment_0 )
            // InternalAceGen.g:5035:3: rule__Scenario__NameAssignment_0
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
    // InternalAceGen.g:5043:1: rule__Scenario__Group__1 : rule__Scenario__Group__1__Impl rule__Scenario__Group__2 ;
    public final void rule__Scenario__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5047:1: ( rule__Scenario__Group__1__Impl rule__Scenario__Group__2 )
            // InternalAceGen.g:5048:2: rule__Scenario__Group__1__Impl rule__Scenario__Group__2
            {
            pushFollow(FOLLOW_40);
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
    // InternalAceGen.g:5055:1: rule__Scenario__Group__1__Impl : ( ( rule__Scenario__Group_1__0 )? ) ;
    public final void rule__Scenario__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5059:1: ( ( ( rule__Scenario__Group_1__0 )? ) )
            // InternalAceGen.g:5060:1: ( ( rule__Scenario__Group_1__0 )? )
            {
            // InternalAceGen.g:5060:1: ( ( rule__Scenario__Group_1__0 )? )
            // InternalAceGen.g:5061:2: ( rule__Scenario__Group_1__0 )?
            {
             before(grammarAccess.getScenarioAccess().getGroup_1()); 
            // InternalAceGen.g:5062:2: ( rule__Scenario__Group_1__0 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==56) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalAceGen.g:5062:3: rule__Scenario__Group_1__0
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
    // InternalAceGen.g:5070:1: rule__Scenario__Group__2 : rule__Scenario__Group__2__Impl rule__Scenario__Group__3 ;
    public final void rule__Scenario__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5074:1: ( rule__Scenario__Group__2__Impl rule__Scenario__Group__3 )
            // InternalAceGen.g:5075:2: rule__Scenario__Group__2__Impl rule__Scenario__Group__3
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
    // InternalAceGen.g:5082:1: rule__Scenario__Group__2__Impl : ( 'WHEN' ) ;
    public final void rule__Scenario__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5086:1: ( ( 'WHEN' ) )
            // InternalAceGen.g:5087:1: ( 'WHEN' )
            {
            // InternalAceGen.g:5087:1: ( 'WHEN' )
            // InternalAceGen.g:5088:2: 'WHEN'
            {
             before(grammarAccess.getScenarioAccess().getWHENKeyword_2()); 
            match(input,54,FOLLOW_2); 
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
    // InternalAceGen.g:5097:1: rule__Scenario__Group__3 : rule__Scenario__Group__3__Impl rule__Scenario__Group__4 ;
    public final void rule__Scenario__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5101:1: ( rule__Scenario__Group__3__Impl rule__Scenario__Group__4 )
            // InternalAceGen.g:5102:2: rule__Scenario__Group__3__Impl rule__Scenario__Group__4
            {
            pushFollow(FOLLOW_41);
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
    // InternalAceGen.g:5109:1: rule__Scenario__Group__3__Impl : ( ( rule__Scenario__WhenBlockAssignment_3 ) ) ;
    public final void rule__Scenario__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5113:1: ( ( ( rule__Scenario__WhenBlockAssignment_3 ) ) )
            // InternalAceGen.g:5114:1: ( ( rule__Scenario__WhenBlockAssignment_3 ) )
            {
            // InternalAceGen.g:5114:1: ( ( rule__Scenario__WhenBlockAssignment_3 ) )
            // InternalAceGen.g:5115:2: ( rule__Scenario__WhenBlockAssignment_3 )
            {
             before(grammarAccess.getScenarioAccess().getWhenBlockAssignment_3()); 
            // InternalAceGen.g:5116:2: ( rule__Scenario__WhenBlockAssignment_3 )
            // InternalAceGen.g:5116:3: rule__Scenario__WhenBlockAssignment_3
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
    // InternalAceGen.g:5124:1: rule__Scenario__Group__4 : rule__Scenario__Group__4__Impl rule__Scenario__Group__5 ;
    public final void rule__Scenario__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5128:1: ( rule__Scenario__Group__4__Impl rule__Scenario__Group__5 )
            // InternalAceGen.g:5129:2: rule__Scenario__Group__4__Impl rule__Scenario__Group__5
            {
            pushFollow(FOLLOW_42);
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
    // InternalAceGen.g:5136:1: rule__Scenario__Group__4__Impl : ( 'THEN' ) ;
    public final void rule__Scenario__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5140:1: ( ( 'THEN' ) )
            // InternalAceGen.g:5141:1: ( 'THEN' )
            {
            // InternalAceGen.g:5141:1: ( 'THEN' )
            // InternalAceGen.g:5142:2: 'THEN'
            {
             before(grammarAccess.getScenarioAccess().getTHENKeyword_4()); 
            match(input,55,FOLLOW_2); 
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
    // InternalAceGen.g:5151:1: rule__Scenario__Group__5 : rule__Scenario__Group__5__Impl ;
    public final void rule__Scenario__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5155:1: ( rule__Scenario__Group__5__Impl )
            // InternalAceGen.g:5156:2: rule__Scenario__Group__5__Impl
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
    // InternalAceGen.g:5162:1: rule__Scenario__Group__5__Impl : ( ( rule__Scenario__ThenBlockAssignment_5 ) ) ;
    public final void rule__Scenario__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5166:1: ( ( ( rule__Scenario__ThenBlockAssignment_5 ) ) )
            // InternalAceGen.g:5167:1: ( ( rule__Scenario__ThenBlockAssignment_5 ) )
            {
            // InternalAceGen.g:5167:1: ( ( rule__Scenario__ThenBlockAssignment_5 ) )
            // InternalAceGen.g:5168:2: ( rule__Scenario__ThenBlockAssignment_5 )
            {
             before(grammarAccess.getScenarioAccess().getThenBlockAssignment_5()); 
            // InternalAceGen.g:5169:2: ( rule__Scenario__ThenBlockAssignment_5 )
            // InternalAceGen.g:5169:3: rule__Scenario__ThenBlockAssignment_5
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
    // InternalAceGen.g:5178:1: rule__Scenario__Group_1__0 : rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1 ;
    public final void rule__Scenario__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5182:1: ( rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1 )
            // InternalAceGen.g:5183:2: rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1
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
    // InternalAceGen.g:5190:1: rule__Scenario__Group_1__0__Impl : ( 'GIVEN' ) ;
    public final void rule__Scenario__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5194:1: ( ( 'GIVEN' ) )
            // InternalAceGen.g:5195:1: ( 'GIVEN' )
            {
            // InternalAceGen.g:5195:1: ( 'GIVEN' )
            // InternalAceGen.g:5196:2: 'GIVEN'
            {
             before(grammarAccess.getScenarioAccess().getGIVENKeyword_1_0()); 
            match(input,56,FOLLOW_2); 
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
    // InternalAceGen.g:5205:1: rule__Scenario__Group_1__1 : rule__Scenario__Group_1__1__Impl ;
    public final void rule__Scenario__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5209:1: ( rule__Scenario__Group_1__1__Impl )
            // InternalAceGen.g:5210:2: rule__Scenario__Group_1__1__Impl
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
    // InternalAceGen.g:5216:1: rule__Scenario__Group_1__1__Impl : ( ( rule__Scenario__ScenariosAssignment_1_1 )* ) ;
    public final void rule__Scenario__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5220:1: ( ( ( rule__Scenario__ScenariosAssignment_1_1 )* ) )
            // InternalAceGen.g:5221:1: ( ( rule__Scenario__ScenariosAssignment_1_1 )* )
            {
            // InternalAceGen.g:5221:1: ( ( rule__Scenario__ScenariosAssignment_1_1 )* )
            // InternalAceGen.g:5222:2: ( rule__Scenario__ScenariosAssignment_1_1 )*
            {
             before(grammarAccess.getScenarioAccess().getScenariosAssignment_1_1()); 
            // InternalAceGen.g:5223:2: ( rule__Scenario__ScenariosAssignment_1_1 )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_ID) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalAceGen.g:5223:3: rule__Scenario__ScenariosAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Scenario__ScenariosAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

             after(grammarAccess.getScenarioAccess().getScenariosAssignment_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__WhenBlock__Group__0"
    // InternalAceGen.g:5232:1: rule__WhenBlock__Group__0 : rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1 ;
    public final void rule__WhenBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5236:1: ( rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1 )
            // InternalAceGen.g:5237:2: rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalAceGen.g:5244:1: rule__WhenBlock__Group__0__Impl : ( ( rule__WhenBlock__ActionAssignment_0 ) ) ;
    public final void rule__WhenBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5248:1: ( ( ( rule__WhenBlock__ActionAssignment_0 ) ) )
            // InternalAceGen.g:5249:1: ( ( rule__WhenBlock__ActionAssignment_0 ) )
            {
            // InternalAceGen.g:5249:1: ( ( rule__WhenBlock__ActionAssignment_0 ) )
            // InternalAceGen.g:5250:2: ( rule__WhenBlock__ActionAssignment_0 )
            {
             before(grammarAccess.getWhenBlockAccess().getActionAssignment_0()); 
            // InternalAceGen.g:5251:2: ( rule__WhenBlock__ActionAssignment_0 )
            // InternalAceGen.g:5251:3: rule__WhenBlock__ActionAssignment_0
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
    // InternalAceGen.g:5259:1: rule__WhenBlock__Group__1 : rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2 ;
    public final void rule__WhenBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5263:1: ( rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2 )
            // InternalAceGen.g:5264:2: rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2
            {
            pushFollow(FOLLOW_44);
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
    // InternalAceGen.g:5271:1: rule__WhenBlock__Group__1__Impl : ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) ) ;
    public final void rule__WhenBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5275:1: ( ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) ) )
            // InternalAceGen.g:5276:1: ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) )
            {
            // InternalAceGen.g:5276:1: ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) )
            // InternalAceGen.g:5277:2: ( rule__WhenBlock__DataDefinitionAssignment_1 )
            {
             before(grammarAccess.getWhenBlockAccess().getDataDefinitionAssignment_1()); 
            // InternalAceGen.g:5278:2: ( rule__WhenBlock__DataDefinitionAssignment_1 )
            // InternalAceGen.g:5278:3: rule__WhenBlock__DataDefinitionAssignment_1
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
    // InternalAceGen.g:5286:1: rule__WhenBlock__Group__2 : rule__WhenBlock__Group__2__Impl ;
    public final void rule__WhenBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5290:1: ( rule__WhenBlock__Group__2__Impl )
            // InternalAceGen.g:5291:2: rule__WhenBlock__Group__2__Impl
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
    // InternalAceGen.g:5297:1: rule__WhenBlock__Group__2__Impl : ( ( rule__WhenBlock__AuthorizationAssignment_2 )? ) ;
    public final void rule__WhenBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5301:1: ( ( ( rule__WhenBlock__AuthorizationAssignment_2 )? ) )
            // InternalAceGen.g:5302:1: ( ( rule__WhenBlock__AuthorizationAssignment_2 )? )
            {
            // InternalAceGen.g:5302:1: ( ( rule__WhenBlock__AuthorizationAssignment_2 )? )
            // InternalAceGen.g:5303:2: ( rule__WhenBlock__AuthorizationAssignment_2 )?
            {
             before(grammarAccess.getWhenBlockAccess().getAuthorizationAssignment_2()); 
            // InternalAceGen.g:5304:2: ( rule__WhenBlock__AuthorizationAssignment_2 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==59) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalAceGen.g:5304:3: rule__WhenBlock__AuthorizationAssignment_2
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
    // InternalAceGen.g:5313:1: rule__ThenBlock__Group__0 : rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1 ;
    public final void rule__ThenBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5317:1: ( rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1 )
            // InternalAceGen.g:5318:2: rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1
            {
            pushFollow(FOLLOW_45);
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
    // InternalAceGen.g:5325:1: rule__ThenBlock__Group__0__Impl : ( ( rule__ThenBlock__StatusCodeAssignment_0 ) ) ;
    public final void rule__ThenBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5329:1: ( ( ( rule__ThenBlock__StatusCodeAssignment_0 ) ) )
            // InternalAceGen.g:5330:1: ( ( rule__ThenBlock__StatusCodeAssignment_0 ) )
            {
            // InternalAceGen.g:5330:1: ( ( rule__ThenBlock__StatusCodeAssignment_0 ) )
            // InternalAceGen.g:5331:2: ( rule__ThenBlock__StatusCodeAssignment_0 )
            {
             before(grammarAccess.getThenBlockAccess().getStatusCodeAssignment_0()); 
            // InternalAceGen.g:5332:2: ( rule__ThenBlock__StatusCodeAssignment_0 )
            // InternalAceGen.g:5332:3: rule__ThenBlock__StatusCodeAssignment_0
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
    // InternalAceGen.g:5340:1: rule__ThenBlock__Group__1 : rule__ThenBlock__Group__1__Impl ;
    public final void rule__ThenBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5344:1: ( rule__ThenBlock__Group__1__Impl )
            // InternalAceGen.g:5345:2: rule__ThenBlock__Group__1__Impl
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
    // InternalAceGen.g:5351:1: rule__ThenBlock__Group__1__Impl : ( ( rule__ThenBlock__Group_1__0 )? ) ;
    public final void rule__ThenBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5355:1: ( ( ( rule__ThenBlock__Group_1__0 )? ) )
            // InternalAceGen.g:5356:1: ( ( rule__ThenBlock__Group_1__0 )? )
            {
            // InternalAceGen.g:5356:1: ( ( rule__ThenBlock__Group_1__0 )? )
            // InternalAceGen.g:5357:2: ( rule__ThenBlock__Group_1__0 )?
            {
             before(grammarAccess.getThenBlockAccess().getGroup_1()); 
            // InternalAceGen.g:5358:2: ( rule__ThenBlock__Group_1__0 )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==52) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalAceGen.g:5358:3: rule__ThenBlock__Group_1__0
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
    // InternalAceGen.g:5367:1: rule__ThenBlock__Group_1__0 : rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1 ;
    public final void rule__ThenBlock__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5371:1: ( rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1 )
            // InternalAceGen.g:5372:2: rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalAceGen.g:5379:1: rule__ThenBlock__Group_1__0__Impl : ( 'response' ) ;
    public final void rule__ThenBlock__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5383:1: ( ( 'response' ) )
            // InternalAceGen.g:5384:1: ( 'response' )
            {
            // InternalAceGen.g:5384:1: ( 'response' )
            // InternalAceGen.g:5385:2: 'response'
            {
             before(grammarAccess.getThenBlockAccess().getResponseKeyword_1_0()); 
            match(input,52,FOLLOW_2); 
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
    // InternalAceGen.g:5394:1: rule__ThenBlock__Group_1__1 : rule__ThenBlock__Group_1__1__Impl ;
    public final void rule__ThenBlock__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5398:1: ( rule__ThenBlock__Group_1__1__Impl )
            // InternalAceGen.g:5399:2: rule__ThenBlock__Group_1__1__Impl
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
    // InternalAceGen.g:5405:1: rule__ThenBlock__Group_1__1__Impl : ( ( rule__ThenBlock__ResponseAssignment_1_1 ) ) ;
    public final void rule__ThenBlock__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5409:1: ( ( ( rule__ThenBlock__ResponseAssignment_1_1 ) ) )
            // InternalAceGen.g:5410:1: ( ( rule__ThenBlock__ResponseAssignment_1_1 ) )
            {
            // InternalAceGen.g:5410:1: ( ( rule__ThenBlock__ResponseAssignment_1_1 ) )
            // InternalAceGen.g:5411:2: ( rule__ThenBlock__ResponseAssignment_1_1 )
            {
             before(grammarAccess.getThenBlockAccess().getResponseAssignment_1_1()); 
            // InternalAceGen.g:5412:2: ( rule__ThenBlock__ResponseAssignment_1_1 )
            // InternalAceGen.g:5412:3: rule__ThenBlock__ResponseAssignment_1_1
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
    // InternalAceGen.g:5421:1: rule__DataDefinition__Group__0 : rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1 ;
    public final void rule__DataDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5425:1: ( rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1 )
            // InternalAceGen.g:5426:2: rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalAceGen.g:5433:1: rule__DataDefinition__Group__0__Impl : ( () ) ;
    public final void rule__DataDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5437:1: ( ( () ) )
            // InternalAceGen.g:5438:1: ( () )
            {
            // InternalAceGen.g:5438:1: ( () )
            // InternalAceGen.g:5439:2: ()
            {
             before(grammarAccess.getDataDefinitionAccess().getDataDefinitionAction_0()); 
            // InternalAceGen.g:5440:2: ()
            // InternalAceGen.g:5440:3: 
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
    // InternalAceGen.g:5448:1: rule__DataDefinition__Group__1 : rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2 ;
    public final void rule__DataDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5452:1: ( rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2 )
            // InternalAceGen.g:5453:2: rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2
            {
            pushFollow(FOLLOW_43);
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
    // InternalAceGen.g:5460:1: rule__DataDefinition__Group__1__Impl : ( ( rule__DataDefinition__Group_1__0 )? ) ;
    public final void rule__DataDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5464:1: ( ( ( rule__DataDefinition__Group_1__0 )? ) )
            // InternalAceGen.g:5465:1: ( ( rule__DataDefinition__Group_1__0 )? )
            {
            // InternalAceGen.g:5465:1: ( ( rule__DataDefinition__Group_1__0 )? )
            // InternalAceGen.g:5466:2: ( rule__DataDefinition__Group_1__0 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getGroup_1()); 
            // InternalAceGen.g:5467:2: ( rule__DataDefinition__Group_1__0 )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==57) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalAceGen.g:5467:3: rule__DataDefinition__Group_1__0
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
    // InternalAceGen.g:5475:1: rule__DataDefinition__Group__2 : rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3 ;
    public final void rule__DataDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5479:1: ( rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3 )
            // InternalAceGen.g:5480:2: rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3
            {
            pushFollow(FOLLOW_43);
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
    // InternalAceGen.g:5487:1: rule__DataDefinition__Group__2__Impl : ( ( rule__DataDefinition__Group_2__0 )? ) ;
    public final void rule__DataDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5491:1: ( ( ( rule__DataDefinition__Group_2__0 )? ) )
            // InternalAceGen.g:5492:1: ( ( rule__DataDefinition__Group_2__0 )? )
            {
            // InternalAceGen.g:5492:1: ( ( rule__DataDefinition__Group_2__0 )? )
            // InternalAceGen.g:5493:2: ( rule__DataDefinition__Group_2__0 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getGroup_2()); 
            // InternalAceGen.g:5494:2: ( rule__DataDefinition__Group_2__0 )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==58) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalAceGen.g:5494:3: rule__DataDefinition__Group_2__0
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
    // InternalAceGen.g:5502:1: rule__DataDefinition__Group__3 : rule__DataDefinition__Group__3__Impl ;
    public final void rule__DataDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5506:1: ( rule__DataDefinition__Group__3__Impl )
            // InternalAceGen.g:5507:2: rule__DataDefinition__Group__3__Impl
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
    // InternalAceGen.g:5513:1: rule__DataDefinition__Group__3__Impl : ( ( rule__DataDefinition__DataAssignment_3 )? ) ;
    public final void rule__DataDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5517:1: ( ( ( rule__DataDefinition__DataAssignment_3 )? ) )
            // InternalAceGen.g:5518:1: ( ( rule__DataDefinition__DataAssignment_3 )? )
            {
            // InternalAceGen.g:5518:1: ( ( rule__DataDefinition__DataAssignment_3 )? )
            // InternalAceGen.g:5519:2: ( rule__DataDefinition__DataAssignment_3 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getDataAssignment_3()); 
            // InternalAceGen.g:5520:2: ( rule__DataDefinition__DataAssignment_3 )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==42) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalAceGen.g:5520:3: rule__DataDefinition__DataAssignment_3
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
    // InternalAceGen.g:5529:1: rule__DataDefinition__Group_1__0 : rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1 ;
    public final void rule__DataDefinition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5533:1: ( rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1 )
            // InternalAceGen.g:5534:2: rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalAceGen.g:5541:1: rule__DataDefinition__Group_1__0__Impl : ( 'uuid' ) ;
    public final void rule__DataDefinition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5545:1: ( ( 'uuid' ) )
            // InternalAceGen.g:5546:1: ( 'uuid' )
            {
            // InternalAceGen.g:5546:1: ( 'uuid' )
            // InternalAceGen.g:5547:2: 'uuid'
            {
             before(grammarAccess.getDataDefinitionAccess().getUuidKeyword_1_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalAceGen.g:5556:1: rule__DataDefinition__Group_1__1 : rule__DataDefinition__Group_1__1__Impl ;
    public final void rule__DataDefinition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5560:1: ( rule__DataDefinition__Group_1__1__Impl )
            // InternalAceGen.g:5561:2: rule__DataDefinition__Group_1__1__Impl
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
    // InternalAceGen.g:5567:1: rule__DataDefinition__Group_1__1__Impl : ( ( rule__DataDefinition__UuidAssignment_1_1 ) ) ;
    public final void rule__DataDefinition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5571:1: ( ( ( rule__DataDefinition__UuidAssignment_1_1 ) ) )
            // InternalAceGen.g:5572:1: ( ( rule__DataDefinition__UuidAssignment_1_1 ) )
            {
            // InternalAceGen.g:5572:1: ( ( rule__DataDefinition__UuidAssignment_1_1 ) )
            // InternalAceGen.g:5573:2: ( rule__DataDefinition__UuidAssignment_1_1 )
            {
             before(grammarAccess.getDataDefinitionAccess().getUuidAssignment_1_1()); 
            // InternalAceGen.g:5574:2: ( rule__DataDefinition__UuidAssignment_1_1 )
            // InternalAceGen.g:5574:3: rule__DataDefinition__UuidAssignment_1_1
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
    // InternalAceGen.g:5583:1: rule__DataDefinition__Group_2__0 : rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1 ;
    public final void rule__DataDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5587:1: ( rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1 )
            // InternalAceGen.g:5588:2: rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalAceGen.g:5595:1: rule__DataDefinition__Group_2__0__Impl : ( 'systemTime' ) ;
    public final void rule__DataDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5599:1: ( ( 'systemTime' ) )
            // InternalAceGen.g:5600:1: ( 'systemTime' )
            {
            // InternalAceGen.g:5600:1: ( 'systemTime' )
            // InternalAceGen.g:5601:2: 'systemTime'
            {
             before(grammarAccess.getDataDefinitionAccess().getSystemTimeKeyword_2_0()); 
            match(input,58,FOLLOW_2); 
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
    // InternalAceGen.g:5610:1: rule__DataDefinition__Group_2__1 : rule__DataDefinition__Group_2__1__Impl ;
    public final void rule__DataDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5614:1: ( rule__DataDefinition__Group_2__1__Impl )
            // InternalAceGen.g:5615:2: rule__DataDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DataDefinition__Group_2__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalAceGen.g:5621:1: rule__DataDefinition__Group_2__1__Impl : ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) ) ;
    public final void rule__DataDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5625:1: ( ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) ) )
            // InternalAceGen.g:5626:1: ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) )
            {
            // InternalAceGen.g:5626:1: ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) )
            // InternalAceGen.g:5627:2: ( rule__DataDefinition__SystemtimeAssignment_2_1 )
            {
             before(grammarAccess.getDataDefinitionAccess().getSystemtimeAssignment_2_1()); 
            // InternalAceGen.g:5628:2: ( rule__DataDefinition__SystemtimeAssignment_2_1 )
            // InternalAceGen.g:5628:3: rule__DataDefinition__SystemtimeAssignment_2_1
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


    // $ANTLR start "rule__Authorization__Group__0"
    // InternalAceGen.g:5637:1: rule__Authorization__Group__0 : rule__Authorization__Group__0__Impl rule__Authorization__Group__1 ;
    public final void rule__Authorization__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5641:1: ( rule__Authorization__Group__0__Impl rule__Authorization__Group__1 )
            // InternalAceGen.g:5642:2: rule__Authorization__Group__0__Impl rule__Authorization__Group__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalAceGen.g:5649:1: rule__Authorization__Group__0__Impl : ( 'authorization' ) ;
    public final void rule__Authorization__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5653:1: ( ( 'authorization' ) )
            // InternalAceGen.g:5654:1: ( 'authorization' )
            {
            // InternalAceGen.g:5654:1: ( 'authorization' )
            // InternalAceGen.g:5655:2: 'authorization'
            {
             before(grammarAccess.getAuthorizationAccess().getAuthorizationKeyword_0()); 
            match(input,59,FOLLOW_2); 
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
    // InternalAceGen.g:5664:1: rule__Authorization__Group__1 : rule__Authorization__Group__1__Impl rule__Authorization__Group__2 ;
    public final void rule__Authorization__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5668:1: ( rule__Authorization__Group__1__Impl rule__Authorization__Group__2 )
            // InternalAceGen.g:5669:2: rule__Authorization__Group__1__Impl rule__Authorization__Group__2
            {
            pushFollow(FOLLOW_19);
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
    // InternalAceGen.g:5676:1: rule__Authorization__Group__1__Impl : ( ( rule__Authorization__UsernameAssignment_1 ) ) ;
    public final void rule__Authorization__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5680:1: ( ( ( rule__Authorization__UsernameAssignment_1 ) ) )
            // InternalAceGen.g:5681:1: ( ( rule__Authorization__UsernameAssignment_1 ) )
            {
            // InternalAceGen.g:5681:1: ( ( rule__Authorization__UsernameAssignment_1 ) )
            // InternalAceGen.g:5682:2: ( rule__Authorization__UsernameAssignment_1 )
            {
             before(grammarAccess.getAuthorizationAccess().getUsernameAssignment_1()); 
            // InternalAceGen.g:5683:2: ( rule__Authorization__UsernameAssignment_1 )
            // InternalAceGen.g:5683:3: rule__Authorization__UsernameAssignment_1
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
    // InternalAceGen.g:5691:1: rule__Authorization__Group__2 : rule__Authorization__Group__2__Impl rule__Authorization__Group__3 ;
    public final void rule__Authorization__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5695:1: ( rule__Authorization__Group__2__Impl rule__Authorization__Group__3 )
            // InternalAceGen.g:5696:2: rule__Authorization__Group__2__Impl rule__Authorization__Group__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalAceGen.g:5703:1: rule__Authorization__Group__2__Impl : ( ':' ) ;
    public final void rule__Authorization__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5707:1: ( ( ':' ) )
            // InternalAceGen.g:5708:1: ( ':' )
            {
            // InternalAceGen.g:5708:1: ( ':' )
            // InternalAceGen.g:5709:2: ':'
            {
             before(grammarAccess.getAuthorizationAccess().getColonKeyword_2()); 
            match(input,41,FOLLOW_2); 
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
    // InternalAceGen.g:5718:1: rule__Authorization__Group__3 : rule__Authorization__Group__3__Impl ;
    public final void rule__Authorization__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5722:1: ( rule__Authorization__Group__3__Impl )
            // InternalAceGen.g:5723:2: rule__Authorization__Group__3__Impl
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
    // InternalAceGen.g:5729:1: rule__Authorization__Group__3__Impl : ( ( rule__Authorization__PasswordAssignment_3 ) ) ;
    public final void rule__Authorization__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5733:1: ( ( ( rule__Authorization__PasswordAssignment_3 ) ) )
            // InternalAceGen.g:5734:1: ( ( rule__Authorization__PasswordAssignment_3 ) )
            {
            // InternalAceGen.g:5734:1: ( ( rule__Authorization__PasswordAssignment_3 ) )
            // InternalAceGen.g:5735:2: ( rule__Authorization__PasswordAssignment_3 )
            {
             before(grammarAccess.getAuthorizationAccess().getPasswordAssignment_3()); 
            // InternalAceGen.g:5736:2: ( rule__Authorization__PasswordAssignment_3 )
            // InternalAceGen.g:5736:3: rule__Authorization__PasswordAssignment_3
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


    // $ANTLR start "rule__AttributeDefinitionList__Group__0"
    // InternalAceGen.g:5745:1: rule__AttributeDefinitionList__Group__0 : rule__AttributeDefinitionList__Group__0__Impl rule__AttributeDefinitionList__Group__1 ;
    public final void rule__AttributeDefinitionList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5749:1: ( rule__AttributeDefinitionList__Group__0__Impl rule__AttributeDefinitionList__Group__1 )
            // InternalAceGen.g:5750:2: rule__AttributeDefinitionList__Group__0__Impl rule__AttributeDefinitionList__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__AttributeDefinitionList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionList__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionList__Group__0"


    // $ANTLR start "rule__AttributeDefinitionList__Group__0__Impl"
    // InternalAceGen.g:5757:1: rule__AttributeDefinitionList__Group__0__Impl : ( () ) ;
    public final void rule__AttributeDefinitionList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5761:1: ( ( () ) )
            // InternalAceGen.g:5762:1: ( () )
            {
            // InternalAceGen.g:5762:1: ( () )
            // InternalAceGen.g:5763:2: ()
            {
             before(grammarAccess.getAttributeDefinitionListAccess().getAttributeDefinitionListAction_0()); 
            // InternalAceGen.g:5764:2: ()
            // InternalAceGen.g:5764:3: 
            {
            }

             after(grammarAccess.getAttributeDefinitionListAccess().getAttributeDefinitionListAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionList__Group__0__Impl"


    // $ANTLR start "rule__AttributeDefinitionList__Group__1"
    // InternalAceGen.g:5772:1: rule__AttributeDefinitionList__Group__1 : rule__AttributeDefinitionList__Group__1__Impl rule__AttributeDefinitionList__Group__2 ;
    public final void rule__AttributeDefinitionList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5776:1: ( rule__AttributeDefinitionList__Group__1__Impl rule__AttributeDefinitionList__Group__2 )
            // InternalAceGen.g:5777:2: rule__AttributeDefinitionList__Group__1__Impl rule__AttributeDefinitionList__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__AttributeDefinitionList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionList__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionList__Group__1"


    // $ANTLR start "rule__AttributeDefinitionList__Group__1__Impl"
    // InternalAceGen.g:5784:1: rule__AttributeDefinitionList__Group__1__Impl : ( '{' ) ;
    public final void rule__AttributeDefinitionList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5788:1: ( ( '{' ) )
            // InternalAceGen.g:5789:1: ( '{' )
            {
            // InternalAceGen.g:5789:1: ( '{' )
            // InternalAceGen.g:5790:2: '{'
            {
             before(grammarAccess.getAttributeDefinitionListAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getAttributeDefinitionListAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionList__Group__1__Impl"


    // $ANTLR start "rule__AttributeDefinitionList__Group__2"
    // InternalAceGen.g:5799:1: rule__AttributeDefinitionList__Group__2 : rule__AttributeDefinitionList__Group__2__Impl rule__AttributeDefinitionList__Group__3 ;
    public final void rule__AttributeDefinitionList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5803:1: ( rule__AttributeDefinitionList__Group__2__Impl rule__AttributeDefinitionList__Group__3 )
            // InternalAceGen.g:5804:2: rule__AttributeDefinitionList__Group__2__Impl rule__AttributeDefinitionList__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__AttributeDefinitionList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionList__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionList__Group__2"


    // $ANTLR start "rule__AttributeDefinitionList__Group__2__Impl"
    // InternalAceGen.g:5811:1: rule__AttributeDefinitionList__Group__2__Impl : ( ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )* ) ;
    public final void rule__AttributeDefinitionList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5815:1: ( ( ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )* ) )
            // InternalAceGen.g:5816:1: ( ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )* )
            {
            // InternalAceGen.g:5816:1: ( ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )* )
            // InternalAceGen.g:5817:2: ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )*
            {
             before(grammarAccess.getAttributeDefinitionListAccess().getAttributeDefinitionsAssignment_2()); 
            // InternalAceGen.g:5818:2: ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==RULE_ID) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalAceGen.g:5818:3: rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

             after(grammarAccess.getAttributeDefinitionListAccess().getAttributeDefinitionsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionList__Group__2__Impl"


    // $ANTLR start "rule__AttributeDefinitionList__Group__3"
    // InternalAceGen.g:5826:1: rule__AttributeDefinitionList__Group__3 : rule__AttributeDefinitionList__Group__3__Impl ;
    public final void rule__AttributeDefinitionList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5830:1: ( rule__AttributeDefinitionList__Group__3__Impl )
            // InternalAceGen.g:5831:2: rule__AttributeDefinitionList__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionList__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionList__Group__3"


    // $ANTLR start "rule__AttributeDefinitionList__Group__3__Impl"
    // InternalAceGen.g:5837:1: rule__AttributeDefinitionList__Group__3__Impl : ( '}' ) ;
    public final void rule__AttributeDefinitionList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5841:1: ( ( '}' ) )
            // InternalAceGen.g:5842:1: ( '}' )
            {
            // InternalAceGen.g:5842:1: ( '}' )
            // InternalAceGen.g:5843:2: '}'
            {
             before(grammarAccess.getAttributeDefinitionListAccess().getRightCurlyBracketKeyword_3()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getAttributeDefinitionListAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionList__Group__3__Impl"


    // $ANTLR start "rule__ListAttributeDefinitionList__Group__0"
    // InternalAceGen.g:5853:1: rule__ListAttributeDefinitionList__Group__0 : rule__ListAttributeDefinitionList__Group__0__Impl rule__ListAttributeDefinitionList__Group__1 ;
    public final void rule__ListAttributeDefinitionList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5857:1: ( rule__ListAttributeDefinitionList__Group__0__Impl rule__ListAttributeDefinitionList__Group__1 )
            // InternalAceGen.g:5858:2: rule__ListAttributeDefinitionList__Group__0__Impl rule__ListAttributeDefinitionList__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__ListAttributeDefinitionList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListAttributeDefinitionList__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListAttributeDefinitionList__Group__0"


    // $ANTLR start "rule__ListAttributeDefinitionList__Group__0__Impl"
    // InternalAceGen.g:5865:1: rule__ListAttributeDefinitionList__Group__0__Impl : ( () ) ;
    public final void rule__ListAttributeDefinitionList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5869:1: ( ( () ) )
            // InternalAceGen.g:5870:1: ( () )
            {
            // InternalAceGen.g:5870:1: ( () )
            // InternalAceGen.g:5871:2: ()
            {
             before(grammarAccess.getListAttributeDefinitionListAccess().getListAttributeDefinitionListAction_0()); 
            // InternalAceGen.g:5872:2: ()
            // InternalAceGen.g:5872:3: 
            {
            }

             after(grammarAccess.getListAttributeDefinitionListAccess().getListAttributeDefinitionListAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListAttributeDefinitionList__Group__0__Impl"


    // $ANTLR start "rule__ListAttributeDefinitionList__Group__1"
    // InternalAceGen.g:5880:1: rule__ListAttributeDefinitionList__Group__1 : rule__ListAttributeDefinitionList__Group__1__Impl rule__ListAttributeDefinitionList__Group__2 ;
    public final void rule__ListAttributeDefinitionList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5884:1: ( rule__ListAttributeDefinitionList__Group__1__Impl rule__ListAttributeDefinitionList__Group__2 )
            // InternalAceGen.g:5885:2: rule__ListAttributeDefinitionList__Group__1__Impl rule__ListAttributeDefinitionList__Group__2
            {
            pushFollow(FOLLOW_47);
            rule__ListAttributeDefinitionList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListAttributeDefinitionList__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListAttributeDefinitionList__Group__1"


    // $ANTLR start "rule__ListAttributeDefinitionList__Group__1__Impl"
    // InternalAceGen.g:5892:1: rule__ListAttributeDefinitionList__Group__1__Impl : ( '[' ) ;
    public final void rule__ListAttributeDefinitionList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5896:1: ( ( '[' ) )
            // InternalAceGen.g:5897:1: ( '[' )
            {
            // InternalAceGen.g:5897:1: ( '[' )
            // InternalAceGen.g:5898:2: '['
            {
             before(grammarAccess.getListAttributeDefinitionListAccess().getLeftSquareBracketKeyword_1()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getListAttributeDefinitionListAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListAttributeDefinitionList__Group__1__Impl"


    // $ANTLR start "rule__ListAttributeDefinitionList__Group__2"
    // InternalAceGen.g:5907:1: rule__ListAttributeDefinitionList__Group__2 : rule__ListAttributeDefinitionList__Group__2__Impl rule__ListAttributeDefinitionList__Group__3 ;
    public final void rule__ListAttributeDefinitionList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5911:1: ( rule__ListAttributeDefinitionList__Group__2__Impl rule__ListAttributeDefinitionList__Group__3 )
            // InternalAceGen.g:5912:2: rule__ListAttributeDefinitionList__Group__2__Impl rule__ListAttributeDefinitionList__Group__3
            {
            pushFollow(FOLLOW_47);
            rule__ListAttributeDefinitionList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ListAttributeDefinitionList__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListAttributeDefinitionList__Group__2"


    // $ANTLR start "rule__ListAttributeDefinitionList__Group__2__Impl"
    // InternalAceGen.g:5919:1: rule__ListAttributeDefinitionList__Group__2__Impl : ( ( rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2 )* ) ;
    public final void rule__ListAttributeDefinitionList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5923:1: ( ( ( rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2 )* ) )
            // InternalAceGen.g:5924:1: ( ( rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2 )* )
            {
            // InternalAceGen.g:5924:1: ( ( rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2 )* )
            // InternalAceGen.g:5925:2: ( rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2 )*
            {
             before(grammarAccess.getListAttributeDefinitionListAccess().getAttributeDefinitionListAssignment_2()); 
            // InternalAceGen.g:5926:2: ( rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2 )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==42) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalAceGen.g:5926:3: rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

             after(grammarAccess.getListAttributeDefinitionListAccess().getAttributeDefinitionListAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListAttributeDefinitionList__Group__2__Impl"


    // $ANTLR start "rule__ListAttributeDefinitionList__Group__3"
    // InternalAceGen.g:5934:1: rule__ListAttributeDefinitionList__Group__3 : rule__ListAttributeDefinitionList__Group__3__Impl ;
    public final void rule__ListAttributeDefinitionList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5938:1: ( rule__ListAttributeDefinitionList__Group__3__Impl )
            // InternalAceGen.g:5939:2: rule__ListAttributeDefinitionList__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ListAttributeDefinitionList__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListAttributeDefinitionList__Group__3"


    // $ANTLR start "rule__ListAttributeDefinitionList__Group__3__Impl"
    // InternalAceGen.g:5945:1: rule__ListAttributeDefinitionList__Group__3__Impl : ( ']' ) ;
    public final void rule__ListAttributeDefinitionList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5949:1: ( ( ']' ) )
            // InternalAceGen.g:5950:1: ( ']' )
            {
            // InternalAceGen.g:5950:1: ( ']' )
            // InternalAceGen.g:5951:2: ']'
            {
             before(grammarAccess.getListAttributeDefinitionListAccess().getRightSquareBracketKeyword_3()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getListAttributeDefinitionListAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListAttributeDefinitionList__Group__3__Impl"


    // $ANTLR start "rule__AttributeDefinition__Group__0"
    // InternalAceGen.g:5961:1: rule__AttributeDefinition__Group__0 : rule__AttributeDefinition__Group__0__Impl rule__AttributeDefinition__Group__1 ;
    public final void rule__AttributeDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5965:1: ( rule__AttributeDefinition__Group__0__Impl rule__AttributeDefinition__Group__1 )
            // InternalAceGen.g:5966:2: rule__AttributeDefinition__Group__0__Impl rule__AttributeDefinition__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__AttributeDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinition__Group__0"


    // $ANTLR start "rule__AttributeDefinition__Group__0__Impl"
    // InternalAceGen.g:5973:1: rule__AttributeDefinition__Group__0__Impl : ( ( rule__AttributeDefinition__AttributeAssignment_0 ) ) ;
    public final void rule__AttributeDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5977:1: ( ( ( rule__AttributeDefinition__AttributeAssignment_0 ) ) )
            // InternalAceGen.g:5978:1: ( ( rule__AttributeDefinition__AttributeAssignment_0 ) )
            {
            // InternalAceGen.g:5978:1: ( ( rule__AttributeDefinition__AttributeAssignment_0 ) )
            // InternalAceGen.g:5979:2: ( rule__AttributeDefinition__AttributeAssignment_0 )
            {
             before(grammarAccess.getAttributeDefinitionAccess().getAttributeAssignment_0()); 
            // InternalAceGen.g:5980:2: ( rule__AttributeDefinition__AttributeAssignment_0 )
            // InternalAceGen.g:5980:3: rule__AttributeDefinition__AttributeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinition__AttributeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeDefinitionAccess().getAttributeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinition__Group__0__Impl"


    // $ANTLR start "rule__AttributeDefinition__Group__1"
    // InternalAceGen.g:5988:1: rule__AttributeDefinition__Group__1 : rule__AttributeDefinition__Group__1__Impl rule__AttributeDefinition__Group__2 ;
    public final void rule__AttributeDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5992:1: ( rule__AttributeDefinition__Group__1__Impl rule__AttributeDefinition__Group__2 )
            // InternalAceGen.g:5993:2: rule__AttributeDefinition__Group__1__Impl rule__AttributeDefinition__Group__2
            {
            pushFollow(FOLLOW_49);
            rule__AttributeDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinition__Group__1"


    // $ANTLR start "rule__AttributeDefinition__Group__1__Impl"
    // InternalAceGen.g:6000:1: rule__AttributeDefinition__Group__1__Impl : ( ':' ) ;
    public final void rule__AttributeDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6004:1: ( ( ':' ) )
            // InternalAceGen.g:6005:1: ( ':' )
            {
            // InternalAceGen.g:6005:1: ( ':' )
            // InternalAceGen.g:6006:2: ':'
            {
             before(grammarAccess.getAttributeDefinitionAccess().getColonKeyword_1()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getAttributeDefinitionAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinition__Group__1__Impl"


    // $ANTLR start "rule__AttributeDefinition__Group__2"
    // InternalAceGen.g:6015:1: rule__AttributeDefinition__Group__2 : rule__AttributeDefinition__Group__2__Impl ;
    public final void rule__AttributeDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6019:1: ( rule__AttributeDefinition__Group__2__Impl )
            // InternalAceGen.g:6020:2: rule__AttributeDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinition__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinition__Group__2"


    // $ANTLR start "rule__AttributeDefinition__Group__2__Impl"
    // InternalAceGen.g:6026:1: rule__AttributeDefinition__Group__2__Impl : ( ( rule__AttributeDefinition__ValueAssignment_2 ) ) ;
    public final void rule__AttributeDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6030:1: ( ( ( rule__AttributeDefinition__ValueAssignment_2 ) ) )
            // InternalAceGen.g:6031:1: ( ( rule__AttributeDefinition__ValueAssignment_2 ) )
            {
            // InternalAceGen.g:6031:1: ( ( rule__AttributeDefinition__ValueAssignment_2 ) )
            // InternalAceGen.g:6032:2: ( rule__AttributeDefinition__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeDefinitionAccess().getValueAssignment_2()); 
            // InternalAceGen.g:6033:2: ( rule__AttributeDefinition__ValueAssignment_2 )
            // InternalAceGen.g:6033:3: rule__AttributeDefinition__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinition__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeDefinitionAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinition__Group__2__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalAceGen.g:6042:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6046:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalAceGen.g:6047:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalAceGen.g:6054:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__UniqueAssignment_0 )? ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6058:1: ( ( ( rule__Attribute__UniqueAssignment_0 )? ) )
            // InternalAceGen.g:6059:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            {
            // InternalAceGen.g:6059:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            // InternalAceGen.g:6060:2: ( rule__Attribute__UniqueAssignment_0 )?
            {
             before(grammarAccess.getAttributeAccess().getUniqueAssignment_0()); 
            // InternalAceGen.g:6061:2: ( rule__Attribute__UniqueAssignment_0 )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==70) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalAceGen.g:6061:3: rule__Attribute__UniqueAssignment_0
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
    // InternalAceGen.g:6069:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6073:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalAceGen.g:6074:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FOLLOW_50);
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
    // InternalAceGen.g:6081:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__PrimaryKeyAssignment_1 )? ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6085:1: ( ( ( rule__Attribute__PrimaryKeyAssignment_1 )? ) )
            // InternalAceGen.g:6086:1: ( ( rule__Attribute__PrimaryKeyAssignment_1 )? )
            {
            // InternalAceGen.g:6086:1: ( ( rule__Attribute__PrimaryKeyAssignment_1 )? )
            // InternalAceGen.g:6087:2: ( rule__Attribute__PrimaryKeyAssignment_1 )?
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyAssignment_1()); 
            // InternalAceGen.g:6088:2: ( rule__Attribute__PrimaryKeyAssignment_1 )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==71) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalAceGen.g:6088:3: rule__Attribute__PrimaryKeyAssignment_1
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
    // InternalAceGen.g:6096:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6100:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // InternalAceGen.g:6101:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
            {
            pushFollow(FOLLOW_50);
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
    // InternalAceGen.g:6108:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ConstraintAssignment_2 )? ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6112:1: ( ( ( rule__Attribute__ConstraintAssignment_2 )? ) )
            // InternalAceGen.g:6113:1: ( ( rule__Attribute__ConstraintAssignment_2 )? )
            {
            // InternalAceGen.g:6113:1: ( ( rule__Attribute__ConstraintAssignment_2 )? )
            // InternalAceGen.g:6114:2: ( rule__Attribute__ConstraintAssignment_2 )?
            {
             before(grammarAccess.getAttributeAccess().getConstraintAssignment_2()); 
            // InternalAceGen.g:6115:2: ( rule__Attribute__ConstraintAssignment_2 )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=25 && LA81_0<=26)) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalAceGen.g:6115:3: rule__Attribute__ConstraintAssignment_2
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
    // InternalAceGen.g:6123:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl rule__Attribute__Group__4 ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6127:1: ( rule__Attribute__Group__3__Impl rule__Attribute__Group__4 )
            // InternalAceGen.g:6128:2: rule__Attribute__Group__3__Impl rule__Attribute__Group__4
            {
            pushFollow(FOLLOW_50);
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
    // InternalAceGen.g:6135:1: rule__Attribute__Group__3__Impl : ( ( rule__Attribute__ListAssignment_3 )? ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6139:1: ( ( ( rule__Attribute__ListAssignment_3 )? ) )
            // InternalAceGen.g:6140:1: ( ( rule__Attribute__ListAssignment_3 )? )
            {
            // InternalAceGen.g:6140:1: ( ( rule__Attribute__ListAssignment_3 )? )
            // InternalAceGen.g:6141:2: ( rule__Attribute__ListAssignment_3 )?
            {
             before(grammarAccess.getAttributeAccess().getListAssignment_3()); 
            // InternalAceGen.g:6142:2: ( rule__Attribute__ListAssignment_3 )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==72) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalAceGen.g:6142:3: rule__Attribute__ListAssignment_3
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
    // InternalAceGen.g:6150:1: rule__Attribute__Group__4 : rule__Attribute__Group__4__Impl rule__Attribute__Group__5 ;
    public final void rule__Attribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6154:1: ( rule__Attribute__Group__4__Impl rule__Attribute__Group__5 )
            // InternalAceGen.g:6155:2: rule__Attribute__Group__4__Impl rule__Attribute__Group__5
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
    // InternalAceGen.g:6162:1: rule__Attribute__Group__4__Impl : ( ( rule__Attribute__Alternatives_4 ) ) ;
    public final void rule__Attribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6166:1: ( ( ( rule__Attribute__Alternatives_4 ) ) )
            // InternalAceGen.g:6167:1: ( ( rule__Attribute__Alternatives_4 ) )
            {
            // InternalAceGen.g:6167:1: ( ( rule__Attribute__Alternatives_4 ) )
            // InternalAceGen.g:6168:2: ( rule__Attribute__Alternatives_4 )
            {
             before(grammarAccess.getAttributeAccess().getAlternatives_4()); 
            // InternalAceGen.g:6169:2: ( rule__Attribute__Alternatives_4 )
            // InternalAceGen.g:6169:3: rule__Attribute__Alternatives_4
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
    // InternalAceGen.g:6177:1: rule__Attribute__Group__5 : rule__Attribute__Group__5__Impl rule__Attribute__Group__6 ;
    public final void rule__Attribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6181:1: ( rule__Attribute__Group__5__Impl rule__Attribute__Group__6 )
            // InternalAceGen.g:6182:2: rule__Attribute__Group__5__Impl rule__Attribute__Group__6
            {
            pushFollow(FOLLOW_51);
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
    // InternalAceGen.g:6189:1: rule__Attribute__Group__5__Impl : ( ( rule__Attribute__NameAssignment_5 ) ) ;
    public final void rule__Attribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6193:1: ( ( ( rule__Attribute__NameAssignment_5 ) ) )
            // InternalAceGen.g:6194:1: ( ( rule__Attribute__NameAssignment_5 ) )
            {
            // InternalAceGen.g:6194:1: ( ( rule__Attribute__NameAssignment_5 ) )
            // InternalAceGen.g:6195:2: ( rule__Attribute__NameAssignment_5 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_5()); 
            // InternalAceGen.g:6196:2: ( rule__Attribute__NameAssignment_5 )
            // InternalAceGen.g:6196:3: rule__Attribute__NameAssignment_5
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
    // InternalAceGen.g:6204:1: rule__Attribute__Group__6 : rule__Attribute__Group__6__Impl rule__Attribute__Group__7 ;
    public final void rule__Attribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6208:1: ( rule__Attribute__Group__6__Impl rule__Attribute__Group__7 )
            // InternalAceGen.g:6209:2: rule__Attribute__Group__6__Impl rule__Attribute__Group__7
            {
            pushFollow(FOLLOW_51);
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
    // InternalAceGen.g:6216:1: rule__Attribute__Group__6__Impl : ( ( rule__Attribute__Group_6__0 )? ) ;
    public final void rule__Attribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6220:1: ( ( ( rule__Attribute__Group_6__0 )? ) )
            // InternalAceGen.g:6221:1: ( ( rule__Attribute__Group_6__0 )? )
            {
            // InternalAceGen.g:6221:1: ( ( rule__Attribute__Group_6__0 )? )
            // InternalAceGen.g:6222:2: ( rule__Attribute__Group_6__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_6()); 
            // InternalAceGen.g:6223:2: ( rule__Attribute__Group_6__0 )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==62) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalAceGen.g:6223:3: rule__Attribute__Group_6__0
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
    // InternalAceGen.g:6231:1: rule__Attribute__Group__7 : rule__Attribute__Group__7__Impl ;
    public final void rule__Attribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6235:1: ( rule__Attribute__Group__7__Impl )
            // InternalAceGen.g:6236:2: rule__Attribute__Group__7__Impl
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
    // InternalAceGen.g:6242:1: rule__Attribute__Group__7__Impl : ( ( rule__Attribute__NotReplayableAssignment_7 )? ) ;
    public final void rule__Attribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6246:1: ( ( ( rule__Attribute__NotReplayableAssignment_7 )? ) )
            // InternalAceGen.g:6247:1: ( ( rule__Attribute__NotReplayableAssignment_7 )? )
            {
            // InternalAceGen.g:6247:1: ( ( rule__Attribute__NotReplayableAssignment_7 )? )
            // InternalAceGen.g:6248:2: ( rule__Attribute__NotReplayableAssignment_7 )?
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableAssignment_7()); 
            // InternalAceGen.g:6249:2: ( rule__Attribute__NotReplayableAssignment_7 )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==73) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalAceGen.g:6249:3: rule__Attribute__NotReplayableAssignment_7
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
    // InternalAceGen.g:6258:1: rule__Attribute__Group_6__0 : rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 ;
    public final void rule__Attribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6262:1: ( rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 )
            // InternalAceGen.g:6263:2: rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1
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
    // InternalAceGen.g:6270:1: rule__Attribute__Group_6__0__Impl : ( 'references' ) ;
    public final void rule__Attribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6274:1: ( ( 'references' ) )
            // InternalAceGen.g:6275:1: ( 'references' )
            {
            // InternalAceGen.g:6275:1: ( 'references' )
            // InternalAceGen.g:6276:2: 'references'
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
    // InternalAceGen.g:6285:1: rule__Attribute__Group_6__1 : rule__Attribute__Group_6__1__Impl ;
    public final void rule__Attribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6289:1: ( rule__Attribute__Group_6__1__Impl )
            // InternalAceGen.g:6290:2: rule__Attribute__Group_6__1__Impl
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
    // InternalAceGen.g:6296:1: rule__Attribute__Group_6__1__Impl : ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) ) ;
    public final void rule__Attribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6300:1: ( ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) ) )
            // InternalAceGen.g:6301:1: ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) )
            {
            // InternalAceGen.g:6301:1: ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) )
            // InternalAceGen.g:6302:2: ( rule__Attribute__ForeignKeyAssignment_6_1 )
            {
             before(grammarAccess.getAttributeAccess().getForeignKeyAssignment_6_1()); 
            // InternalAceGen.g:6303:2: ( rule__Attribute__ForeignKeyAssignment_6_1 )
            // InternalAceGen.g:6303:3: rule__Attribute__ForeignKeyAssignment_6_1
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
    // InternalAceGen.g:6312:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6316:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalAceGen.g:6317:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_52);
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
    // InternalAceGen.g:6324:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6328:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6329:1: ( RULE_ID )
            {
            // InternalAceGen.g:6329:1: ( RULE_ID )
            // InternalAceGen.g:6330:2: RULE_ID
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
    // InternalAceGen.g:6339:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6343:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalAceGen.g:6344:2: rule__QualifiedName__Group__1__Impl
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
    // InternalAceGen.g:6350:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6354:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalAceGen.g:6355:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalAceGen.g:6355:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalAceGen.g:6356:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalAceGen.g:6357:2: ( rule__QualifiedName__Group_1__0 )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==63) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalAceGen.g:6357:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_53);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop85;
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
    // InternalAceGen.g:6366:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6370:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalAceGen.g:6371:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalAceGen.g:6378:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6382:1: ( ( '.' ) )
            // InternalAceGen.g:6383:1: ( '.' )
            {
            // InternalAceGen.g:6383:1: ( '.' )
            // InternalAceGen.g:6384:2: '.'
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
    // InternalAceGen.g:6393:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6397:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalAceGen.g:6398:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalAceGen.g:6404:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6408:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6409:1: ( RULE_ID )
            {
            // InternalAceGen.g:6409:1: ( RULE_ID )
            // InternalAceGen.g:6410:2: RULE_ID
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
    // InternalAceGen.g:6420:1: rule__Project__HttpClientAssignment_0_2 : ( ruleHttpClient ) ;
    public final void rule__Project__HttpClientAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6424:1: ( ( ruleHttpClient ) )
            // InternalAceGen.g:6425:2: ( ruleHttpClient )
            {
            // InternalAceGen.g:6425:2: ( ruleHttpClient )
            // InternalAceGen.g:6426:3: ruleHttpClient
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
    // InternalAceGen.g:6435:1: rule__Project__HttpServerAssignment_1_1 : ( ruleHttpServer ) ;
    public final void rule__Project__HttpServerAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6439:1: ( ( ruleHttpServer ) )
            // InternalAceGen.g:6440:2: ( ruleHttpServer )
            {
            // InternalAceGen.g:6440:2: ( ruleHttpServer )
            // InternalAceGen.g:6441:3: ruleHttpServer
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
    // InternalAceGen.g:6450:1: rule__HttpClient__NameAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__HttpClient__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6454:1: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6455:2: ( ruleQualifiedName )
            {
            // InternalAceGen.g:6455:2: ( ruleQualifiedName )
            // InternalAceGen.g:6456:3: ruleQualifiedName
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
    // InternalAceGen.g:6465:1: rule__HttpClient__AceOperationsAssignment_1_1 : ( ruleHttpClientAce ) ;
    public final void rule__HttpClient__AceOperationsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6469:1: ( ( ruleHttpClientAce ) )
            // InternalAceGen.g:6470:2: ( ruleHttpClientAce )
            {
            // InternalAceGen.g:6470:2: ( ruleHttpClientAce )
            // InternalAceGen.g:6471:3: ruleHttpClientAce
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
    // InternalAceGen.g:6480:1: rule__HttpClient__AppStateAssignment_2_1 : ( ruleHttpClientStateElement ) ;
    public final void rule__HttpClient__AppStateAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6484:1: ( ( ruleHttpClientStateElement ) )
            // InternalAceGen.g:6485:2: ( ruleHttpClientStateElement )
            {
            // InternalAceGen.g:6485:2: ( ruleHttpClientStateElement )
            // InternalAceGen.g:6486:3: ruleHttpClientStateElement
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
    // InternalAceGen.g:6495:1: rule__HttpClientAce__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6499:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6500:2: ( RULE_ID )
            {
            // InternalAceGen.g:6500:2: ( RULE_ID )
            // InternalAceGen.g:6501:3: RULE_ID
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
    // InternalAceGen.g:6510:1: rule__HttpClientAce__InputAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__InputAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6514:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6515:2: ( RULE_ID )
            {
            // InternalAceGen.g:6515:2: ( RULE_ID )
            // InternalAceGen.g:6516:3: RULE_ID
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
    // InternalAceGen.g:6525:1: rule__HttpClientAce__InputAssignment_1_2_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__InputAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6529:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6530:2: ( RULE_ID )
            {
            // InternalAceGen.g:6530:2: ( RULE_ID )
            // InternalAceGen.g:6531:3: RULE_ID
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
    // InternalAceGen.g:6540:1: rule__HttpClientAce__ServerCallAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientAce__ServerCallAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6544:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6545:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6545:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6546:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceCrossReference_2_1_0()); 
            // InternalAceGen.g:6547:3: ( ruleQualifiedName )
            // InternalAceGen.g:6548:4: ruleQualifiedName
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
    // InternalAceGen.g:6559:1: rule__HttpClientAce__LoadingFlagAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientAce__LoadingFlagAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6563:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6564:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6564:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6565:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementCrossReference_3_1_0()); 
            // InternalAceGen.g:6566:3: ( ruleQualifiedName )
            // InternalAceGen.g:6567:4: ruleQualifiedName
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
    // InternalAceGen.g:6578:1: rule__HttpClientAce__OutcomesAssignment_4 : ( ruleHttpClientOutcome ) ;
    public final void rule__HttpClientAce__OutcomesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6582:1: ( ( ruleHttpClientOutcome ) )
            // InternalAceGen.g:6583:2: ( ruleHttpClientOutcome )
            {
            // InternalAceGen.g:6583:2: ( ruleHttpClientOutcome )
            // InternalAceGen.g:6584:3: ruleHttpClientOutcome
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
    // InternalAceGen.g:6593:1: rule__HttpClientOutcome__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientOutcome__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6597:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6598:2: ( RULE_ID )
            {
            // InternalAceGen.g:6598:2: ( RULE_ID )
            // InternalAceGen.g:6599:3: RULE_ID
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
    // InternalAceGen.g:6608:1: rule__HttpClientOutcome__ListenersAssignment_2_1 : ( ruleHttpClientStateFunction ) ;
    public final void rule__HttpClientOutcome__ListenersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6612:1: ( ( ruleHttpClientStateFunction ) )
            // InternalAceGen.g:6613:2: ( ruleHttpClientStateFunction )
            {
            // InternalAceGen.g:6613:2: ( ruleHttpClientStateFunction )
            // InternalAceGen.g:6614:3: ruleHttpClientStateFunction
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
    // InternalAceGen.g:6623:1: rule__HttpClientOutcome__AceOperationsAssignment_3_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientOutcome__AceOperationsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6627:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6628:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6628:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6629:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsHttpClientAceCrossReference_3_2_0()); 
            // InternalAceGen.g:6630:3: ( ruleQualifiedName )
            // InternalAceGen.g:6631:4: ruleQualifiedName
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
    // InternalAceGen.g:6642:1: rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 : ( ruleHttpClientStateFunctionType ) ;
    public final void rule__HttpClientStateFunction__StateFunctionTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6646:1: ( ( ruleHttpClientStateFunctionType ) )
            // InternalAceGen.g:6647:2: ( ruleHttpClientStateFunctionType )
            {
            // InternalAceGen.g:6647:2: ( ruleHttpClientStateFunctionType )
            // InternalAceGen.g:6648:3: ruleHttpClientStateFunctionType
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
    // InternalAceGen.g:6657:1: rule__HttpClientStateFunction__AttributeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientStateFunction__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6661:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6662:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6662:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6663:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getAttributeHttpClientStateElementCrossReference_1_0()); 
            // InternalAceGen.g:6664:3: ( ruleQualifiedName )
            // InternalAceGen.g:6665:4: ruleQualifiedName
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
    // InternalAceGen.g:6676:1: rule__HttpClientStateElement__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpClientStateElement__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6680:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6681:2: ( RULE_ID )
            {
            // InternalAceGen.g:6681:2: ( RULE_ID )
            // InternalAceGen.g:6682:3: RULE_ID
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
    // InternalAceGen.g:6691:1: rule__HttpClientStateElement__ListAssignment_1 : ( ( 'list' ) ) ;
    public final void rule__HttpClientStateElement__ListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6695:1: ( ( ( 'list' ) ) )
            // InternalAceGen.g:6696:2: ( ( 'list' ) )
            {
            // InternalAceGen.g:6696:2: ( ( 'list' ) )
            // InternalAceGen.g:6697:3: ( 'list' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 
            // InternalAceGen.g:6698:3: ( 'list' )
            // InternalAceGen.g:6699:4: 'list'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 
            match(input,64,FOLLOW_2); 
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
    // InternalAceGen.g:6710:1: rule__HttpClientStateElement__HashAssignment_2 : ( ( 'location.hash' ) ) ;
    public final void rule__HttpClientStateElement__HashAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6714:1: ( ( ( 'location.hash' ) ) )
            // InternalAceGen.g:6715:2: ( ( 'location.hash' ) )
            {
            // InternalAceGen.g:6715:2: ( ( 'location.hash' ) )
            // InternalAceGen.g:6716:3: ( 'location.hash' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 
            // InternalAceGen.g:6717:3: ( 'location.hash' )
            // InternalAceGen.g:6718:4: 'location.hash'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalAceGen.g:6729:1: rule__HttpClientStateElement__StorageAssignment_3 : ( ( 'storage' ) ) ;
    public final void rule__HttpClientStateElement__StorageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6733:1: ( ( ( 'storage' ) ) )
            // InternalAceGen.g:6734:2: ( ( 'storage' ) )
            {
            // InternalAceGen.g:6734:2: ( ( 'storage' ) )
            // InternalAceGen.g:6735:3: ( 'storage' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 
            // InternalAceGen.g:6736:3: ( 'storage' )
            // InternalAceGen.g:6737:4: 'storage'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalAceGen.g:6748:1: rule__HttpClientStateElement__TypesAssignment_4_0 : ( ruleHttpClientTypeDefinition ) ;
    public final void rule__HttpClientStateElement__TypesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6752:1: ( ( ruleHttpClientTypeDefinition ) )
            // InternalAceGen.g:6753:2: ( ruleHttpClientTypeDefinition )
            {
            // InternalAceGen.g:6753:2: ( ruleHttpClientTypeDefinition )
            // InternalAceGen.g:6754:3: ruleHttpClientTypeDefinition
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
    // InternalAceGen.g:6763:1: rule__HttpClientStateElement__TypesAssignment_4_1_1 : ( ruleHttpClientTypeDefinition ) ;
    public final void rule__HttpClientStateElement__TypesAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6767:1: ( ( ruleHttpClientTypeDefinition ) )
            // InternalAceGen.g:6768:2: ( ruleHttpClientTypeDefinition )
            {
            // InternalAceGen.g:6768:2: ( ruleHttpClientTypeDefinition )
            // InternalAceGen.g:6769:3: ruleHttpClientTypeDefinition
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
    // InternalAceGen.g:6778:1: rule__HttpClientTypeDefinition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientTypeDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6782:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6783:2: ( RULE_ID )
            {
            // InternalAceGen.g:6783:2: ( RULE_ID )
            // InternalAceGen.g:6784:3: RULE_ID
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
    // InternalAceGen.g:6793:1: rule__HttpClientTypeDefinition__ElementsAssignment_3 : ( ruleHttpClientStateElement ) ;
    public final void rule__HttpClientTypeDefinition__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6797:1: ( ( ruleHttpClientStateElement ) )
            // InternalAceGen.g:6798:2: ( ruleHttpClientStateElement )
            {
            // InternalAceGen.g:6798:2: ( ruleHttpClientStateElement )
            // InternalAceGen.g:6799:3: ruleHttpClientStateElement
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
    // InternalAceGen.g:6808:1: rule__HttpServer__NameAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__HttpServer__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6812:1: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6813:2: ( ruleQualifiedName )
            {
            // InternalAceGen.g:6813:2: ( ruleQualifiedName )
            // InternalAceGen.g:6814:3: ruleQualifiedName
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
    // InternalAceGen.g:6823:1: rule__HttpServer__AuthUserAssignment_1_1 : ( ruleAuthUser ) ;
    public final void rule__HttpServer__AuthUserAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6827:1: ( ( ruleAuthUser ) )
            // InternalAceGen.g:6828:2: ( ruleAuthUser )
            {
            // InternalAceGen.g:6828:2: ( ruleAuthUser )
            // InternalAceGen.g:6829:3: ruleAuthUser
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
    // InternalAceGen.g:6838:1: rule__HttpServer__AuthUserRefAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServer__AuthUserRefAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6842:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6843:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6843:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6844:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_2_1_0()); 
            // InternalAceGen.g:6845:3: ( ruleQualifiedName )
            // InternalAceGen.g:6846:4: ruleQualifiedName
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
    // InternalAceGen.g:6857:1: rule__HttpServer__AceOperationsAssignment_3_1 : ( ruleHttpServerAce ) ;
    public final void rule__HttpServer__AceOperationsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6861:1: ( ( ruleHttpServerAce ) )
            // InternalAceGen.g:6862:2: ( ruleHttpServerAce )
            {
            // InternalAceGen.g:6862:2: ( ruleHttpServerAce )
            // InternalAceGen.g:6863:3: ruleHttpServerAce
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
    // InternalAceGen.g:6872:1: rule__HttpServer__ViewsAssignment_4_1 : ( ruleHttpServerView ) ;
    public final void rule__HttpServer__ViewsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6876:1: ( ( ruleHttpServerView ) )
            // InternalAceGen.g:6877:2: ( ruleHttpServerView )
            {
            // InternalAceGen.g:6877:2: ( ruleHttpServerView )
            // InternalAceGen.g:6878:3: ruleHttpServerView
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
    // InternalAceGen.g:6887:1: rule__HttpServer__ModelsAssignment_5_1 : ( ruleModel ) ;
    public final void rule__HttpServer__ModelsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6891:1: ( ( ruleModel ) )
            // InternalAceGen.g:6892:2: ( ruleModel )
            {
            // InternalAceGen.g:6892:2: ( ruleModel )
            // InternalAceGen.g:6893:3: ruleModel
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


    // $ANTLR start "rule__HttpServer__ScenariosAssignment_6_1"
    // InternalAceGen.g:6902:1: rule__HttpServer__ScenariosAssignment_6_1 : ( ruleScenario ) ;
    public final void rule__HttpServer__ScenariosAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6906:1: ( ( ruleScenario ) )
            // InternalAceGen.g:6907:2: ( ruleScenario )
            {
            // InternalAceGen.g:6907:2: ( ruleScenario )
            // InternalAceGen.g:6908:3: ruleScenario
            {
             before(grammarAccess.getHttpServerAccess().getScenariosScenarioParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleScenario();

            state._fsp--;

             after(grammarAccess.getHttpServerAccess().getScenariosScenarioParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HttpServer__ScenariosAssignment_6_1"


    // $ANTLR start "rule__HttpServerAceWrite__ProxyAssignment_0"
    // InternalAceGen.g:6917:1: rule__HttpServerAceWrite__ProxyAssignment_0 : ( ( 'proxy' ) ) ;
    public final void rule__HttpServerAceWrite__ProxyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6921:1: ( ( ( 'proxy' ) ) )
            // InternalAceGen.g:6922:2: ( ( 'proxy' ) )
            {
            // InternalAceGen.g:6922:2: ( ( 'proxy' ) )
            // InternalAceGen.g:6923:3: ( 'proxy' )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 
            // InternalAceGen.g:6924:3: ( 'proxy' )
            // InternalAceGen.g:6925:4: 'proxy'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 
            match(input,67,FOLLOW_2); 
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
    // InternalAceGen.g:6936:1: rule__HttpServerAceWrite__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerAceWrite__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6940:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6941:2: ( RULE_ID )
            {
            // InternalAceGen.g:6941:2: ( RULE_ID )
            // InternalAceGen.g:6942:3: RULE_ID
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
    // InternalAceGen.g:6951:1: rule__HttpServerAceWrite__ModelAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6955:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:6956:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:6956:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6957:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_3_0()); 
            // InternalAceGen.g:6958:3: ( ruleQualifiedName )
            // InternalAceGen.g:6959:4: ruleQualifiedName
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
    // InternalAceGen.g:6970:1: rule__HttpServerAceWrite__TypeAssignment_5 : ( ruleWriteFunctionType ) ;
    public final void rule__HttpServerAceWrite__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6974:1: ( ( ruleWriteFunctionType ) )
            // InternalAceGen.g:6975:2: ( ruleWriteFunctionType )
            {
            // InternalAceGen.g:6975:2: ( ruleWriteFunctionType )
            // InternalAceGen.g:6976:3: ruleWriteFunctionType
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
    // InternalAceGen.g:6985:1: rule__HttpServerAceWrite__UrlAssignment_6 : ( RULE_STRING ) ;
    public final void rule__HttpServerAceWrite__UrlAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6989:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:6990:2: ( RULE_STRING )
            {
            // InternalAceGen.g:6990:2: ( RULE_STRING )
            // InternalAceGen.g:6991:3: RULE_STRING
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
    // InternalAceGen.g:7000:1: rule__HttpServerAceWrite__AuthorizeAssignment_7 : ( ( 'authorize' ) ) ;
    public final void rule__HttpServerAceWrite__AuthorizeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7004:1: ( ( ( 'authorize' ) ) )
            // InternalAceGen.g:7005:2: ( ( 'authorize' ) )
            {
            // InternalAceGen.g:7005:2: ( ( 'authorize' ) )
            // InternalAceGen.g:7006:3: ( 'authorize' )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            // InternalAceGen.g:7007:3: ( 'authorize' )
            // InternalAceGen.g:7008:4: 'authorize'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalAceGen.g:7019:1: rule__HttpServerAceWrite__PathParamsAssignment_8_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__PathParamsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7023:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7024:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7024:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7025:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeCrossReference_8_1_0()); 
            // InternalAceGen.g:7026:3: ( ruleQualifiedName )
            // InternalAceGen.g:7027:4: ruleQualifiedName
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
    // InternalAceGen.g:7038:1: rule__HttpServerAceWrite__QueryParamsAssignment_9_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__QueryParamsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7042:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7043:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7043:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7044:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeCrossReference_9_1_0()); 
            // InternalAceGen.g:7045:3: ( ruleQualifiedName )
            // InternalAceGen.g:7046:4: ruleQualifiedName
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
    // InternalAceGen.g:7057:1: rule__HttpServerAceWrite__PayloadAssignment_10_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__PayloadAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7061:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7062:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7062:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7063:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeCrossReference_10_1_0()); 
            // InternalAceGen.g:7064:3: ( ruleQualifiedName )
            // InternalAceGen.g:7065:4: ruleQualifiedName
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
    // InternalAceGen.g:7076:1: rule__HttpServerAceWrite__ResponseAssignment_11_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__ResponseAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7080:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7081:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7081:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7082:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeCrossReference_11_1_0()); 
            // InternalAceGen.g:7083:3: ( ruleQualifiedName )
            // InternalAceGen.g:7084:4: ruleQualifiedName
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
    // InternalAceGen.g:7095:1: rule__HttpServerAceWrite__OutcomesAssignment_12 : ( ruleHttpServerOutcome ) ;
    public final void rule__HttpServerAceWrite__OutcomesAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7099:1: ( ( ruleHttpServerOutcome ) )
            // InternalAceGen.g:7100:2: ( ruleHttpServerOutcome )
            {
            // InternalAceGen.g:7100:2: ( ruleHttpServerOutcome )
            // InternalAceGen.g:7101:3: ruleHttpServerOutcome
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
    // InternalAceGen.g:7110:1: rule__HttpServerOutcome__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerOutcome__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7114:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7115:2: ( RULE_ID )
            {
            // InternalAceGen.g:7115:2: ( RULE_ID )
            // InternalAceGen.g:7116:3: RULE_ID
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
    // InternalAceGen.g:7125:1: rule__HttpServerOutcome__ListenersAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerOutcome__ListenersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7129:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7130:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7130:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7131:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0()); 
            // InternalAceGen.g:7132:3: ( ruleQualifiedName )
            // InternalAceGen.g:7133:4: ruleQualifiedName
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
    // InternalAceGen.g:7144:1: rule__HttpServerAceRead__ProxyAssignment_0 : ( ( 'proxy' ) ) ;
    public final void rule__HttpServerAceRead__ProxyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7148:1: ( ( ( 'proxy' ) ) )
            // InternalAceGen.g:7149:2: ( ( 'proxy' ) )
            {
            // InternalAceGen.g:7149:2: ( ( 'proxy' ) )
            // InternalAceGen.g:7150:3: ( 'proxy' )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 
            // InternalAceGen.g:7151:3: ( 'proxy' )
            // InternalAceGen.g:7152:4: 'proxy'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 
            match(input,67,FOLLOW_2); 
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
    // InternalAceGen.g:7163:1: rule__HttpServerAceRead__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerAceRead__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7167:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7168:2: ( RULE_ID )
            {
            // InternalAceGen.g:7168:2: ( RULE_ID )
            // InternalAceGen.g:7169:3: RULE_ID
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
    // InternalAceGen.g:7178:1: rule__HttpServerAceRead__ModelAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7182:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7183:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7183:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7184:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_3_0()); 
            // InternalAceGen.g:7185:3: ( ruleQualifiedName )
            // InternalAceGen.g:7186:4: ruleQualifiedName
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
    // InternalAceGen.g:7197:1: rule__HttpServerAceRead__TypeAssignment_5 : ( ruleReadFunctionType ) ;
    public final void rule__HttpServerAceRead__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7201:1: ( ( ruleReadFunctionType ) )
            // InternalAceGen.g:7202:2: ( ruleReadFunctionType )
            {
            // InternalAceGen.g:7202:2: ( ruleReadFunctionType )
            // InternalAceGen.g:7203:3: ruleReadFunctionType
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
    // InternalAceGen.g:7212:1: rule__HttpServerAceRead__UrlAssignment_6 : ( RULE_STRING ) ;
    public final void rule__HttpServerAceRead__UrlAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7216:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7217:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7217:2: ( RULE_STRING )
            // InternalAceGen.g:7218:3: RULE_STRING
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
    // InternalAceGen.g:7227:1: rule__HttpServerAceRead__AuthorizeAssignment_7 : ( ( 'authorize' ) ) ;
    public final void rule__HttpServerAceRead__AuthorizeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7231:1: ( ( ( 'authorize' ) ) )
            // InternalAceGen.g:7232:2: ( ( 'authorize' ) )
            {
            // InternalAceGen.g:7232:2: ( ( 'authorize' ) )
            // InternalAceGen.g:7233:3: ( 'authorize' )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            // InternalAceGen.g:7234:3: ( 'authorize' )
            // InternalAceGen.g:7235:4: 'authorize'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalAceGen.g:7246:1: rule__HttpServerAceRead__PathParamsAssignment_8_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__PathParamsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7250:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7251:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7251:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7252:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeCrossReference_8_1_0()); 
            // InternalAceGen.g:7253:3: ( ruleQualifiedName )
            // InternalAceGen.g:7254:4: ruleQualifiedName
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
    // InternalAceGen.g:7265:1: rule__HttpServerAceRead__QueryParamsAssignment_9_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__QueryParamsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7269:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7270:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7270:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7271:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeCrossReference_9_1_0()); 
            // InternalAceGen.g:7272:3: ( ruleQualifiedName )
            // InternalAceGen.g:7273:4: ruleQualifiedName
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
    // InternalAceGen.g:7284:1: rule__HttpServerAceRead__PayloadAssignment_10_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__PayloadAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7288:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7289:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7289:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7290:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeCrossReference_10_1_0()); 
            // InternalAceGen.g:7291:3: ( ruleQualifiedName )
            // InternalAceGen.g:7292:4: ruleQualifiedName
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
    // InternalAceGen.g:7303:1: rule__HttpServerAceRead__ResponseAssignment_11_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__ResponseAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7307:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7308:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7308:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7309:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseAttributeCrossReference_11_1_0()); 
            // InternalAceGen.g:7310:3: ( ruleQualifiedName )
            // InternalAceGen.g:7311:4: ruleQualifiedName
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
    // InternalAceGen.g:7322:1: rule__HttpServerView__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpServerView__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7326:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7327:2: ( RULE_ID )
            {
            // InternalAceGen.g:7327:2: ( RULE_ID )
            // InternalAceGen.g:7328:3: RULE_ID
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
    // InternalAceGen.g:7337:1: rule__HttpServerView__RenderFunctionsAssignment_1_1 : ( ruleHttpServerViewFunction ) ;
    public final void rule__HttpServerView__RenderFunctionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7341:1: ( ( ruleHttpServerViewFunction ) )
            // InternalAceGen.g:7342:2: ( ruleHttpServerViewFunction )
            {
            // InternalAceGen.g:7342:2: ( ruleHttpServerViewFunction )
            // InternalAceGen.g:7343:3: ruleHttpServerViewFunction
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
    // InternalAceGen.g:7352:1: rule__HttpServerViewFunction__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpServerViewFunction__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7356:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7357:2: ( RULE_ID )
            {
            // InternalAceGen.g:7357:2: ( RULE_ID )
            // InternalAceGen.g:7358:3: RULE_ID
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
    // InternalAceGen.g:7367:1: rule__HttpServerViewFunction__ModelAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerViewFunction__ModelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7371:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7372:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7372:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7373:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0()); 
            // InternalAceGen.g:7374:3: ( ruleQualifiedName )
            // InternalAceGen.g:7375:4: ruleQualifiedName
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
    // InternalAceGen.g:7386:1: rule__AuthUser__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__AuthUser__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7390:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7391:2: ( RULE_ID )
            {
            // InternalAceGen.g:7391:2: ( RULE_ID )
            // InternalAceGen.g:7392:3: RULE_ID
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
    // InternalAceGen.g:7401:1: rule__AuthUser__AttributesAssignment_1_1 : ( ruleAttribute ) ;
    public final void rule__AuthUser__AttributesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7405:1: ( ( ruleAttribute ) )
            // InternalAceGen.g:7406:2: ( ruleAttribute )
            {
            // InternalAceGen.g:7406:2: ( ruleAttribute )
            // InternalAceGen.g:7407:3: ruleAttribute
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
    // InternalAceGen.g:7416:1: rule__Model__PersistentAssignment_0 : ( ( 'persistent' ) ) ;
    public final void rule__Model__PersistentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7420:1: ( ( ( 'persistent' ) ) )
            // InternalAceGen.g:7421:2: ( ( 'persistent' ) )
            {
            // InternalAceGen.g:7421:2: ( ( 'persistent' ) )
            // InternalAceGen.g:7422:3: ( 'persistent' )
            {
             before(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 
            // InternalAceGen.g:7423:3: ( 'persistent' )
            // InternalAceGen.g:7424:4: 'persistent'
            {
             before(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 
            match(input,69,FOLLOW_2); 
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
    // InternalAceGen.g:7435:1: rule__Model__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7439:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7440:2: ( RULE_ID )
            {
            // InternalAceGen.g:7440:2: ( RULE_ID )
            // InternalAceGen.g:7441:3: RULE_ID
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
    // InternalAceGen.g:7450:1: rule__Model__SuperModelsAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Model__SuperModelsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7454:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7455:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7455:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7456:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0()); 
            // InternalAceGen.g:7457:3: ( ruleQualifiedName )
            // InternalAceGen.g:7458:4: ruleQualifiedName
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
    // InternalAceGen.g:7469:1: rule__Model__SuperModelsAssignment_2_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Model__SuperModelsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7473:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7474:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7474:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7475:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0()); 
            // InternalAceGen.g:7476:3: ( ruleQualifiedName )
            // InternalAceGen.g:7477:4: ruleQualifiedName
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
    // InternalAceGen.g:7488:1: rule__Model__AttributesAssignment_3_1 : ( ruleAttribute ) ;
    public final void rule__Model__AttributesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7492:1: ( ( ruleAttribute ) )
            // InternalAceGen.g:7493:2: ( ruleAttribute )
            {
            // InternalAceGen.g:7493:2: ( ruleAttribute )
            // InternalAceGen.g:7494:3: ruleAttribute
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
    // InternalAceGen.g:7503:1: rule__Scenario__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Scenario__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7507:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7508:2: ( RULE_ID )
            {
            // InternalAceGen.g:7508:2: ( RULE_ID )
            // InternalAceGen.g:7509:3: RULE_ID
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


    // $ANTLR start "rule__Scenario__ScenariosAssignment_1_1"
    // InternalAceGen.g:7518:1: rule__Scenario__ScenariosAssignment_1_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Scenario__ScenariosAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7522:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7523:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7523:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7524:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getScenarioAccess().getScenariosScenarioCrossReference_1_1_0()); 
            // InternalAceGen.g:7525:3: ( ruleQualifiedName )
            // InternalAceGen.g:7526:4: ruleQualifiedName
            {
             before(grammarAccess.getScenarioAccess().getScenariosScenarioQualifiedNameParserRuleCall_1_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getScenarioAccess().getScenariosScenarioQualifiedNameParserRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getScenarioAccess().getScenariosScenarioCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scenario__ScenariosAssignment_1_1"


    // $ANTLR start "rule__Scenario__WhenBlockAssignment_3"
    // InternalAceGen.g:7537:1: rule__Scenario__WhenBlockAssignment_3 : ( ruleWhenBlock ) ;
    public final void rule__Scenario__WhenBlockAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7541:1: ( ( ruleWhenBlock ) )
            // InternalAceGen.g:7542:2: ( ruleWhenBlock )
            {
            // InternalAceGen.g:7542:2: ( ruleWhenBlock )
            // InternalAceGen.g:7543:3: ruleWhenBlock
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
    // InternalAceGen.g:7552:1: rule__Scenario__ThenBlockAssignment_5 : ( ruleThenBlock ) ;
    public final void rule__Scenario__ThenBlockAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7556:1: ( ( ruleThenBlock ) )
            // InternalAceGen.g:7557:2: ( ruleThenBlock )
            {
            // InternalAceGen.g:7557:2: ( ruleThenBlock )
            // InternalAceGen.g:7558:3: ruleThenBlock
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


    // $ANTLR start "rule__WhenBlock__ActionAssignment_0"
    // InternalAceGen.g:7567:1: rule__WhenBlock__ActionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__WhenBlock__ActionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7571:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7572:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7572:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7573:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getWhenBlockAccess().getActionHttpServerAceCrossReference_0_0()); 
            // InternalAceGen.g:7574:3: ( ruleQualifiedName )
            // InternalAceGen.g:7575:4: ruleQualifiedName
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
    // InternalAceGen.g:7586:1: rule__WhenBlock__DataDefinitionAssignment_1 : ( ruleDataDefinition ) ;
    public final void rule__WhenBlock__DataDefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7590:1: ( ( ruleDataDefinition ) )
            // InternalAceGen.g:7591:2: ( ruleDataDefinition )
            {
            // InternalAceGen.g:7591:2: ( ruleDataDefinition )
            // InternalAceGen.g:7592:3: ruleDataDefinition
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
    // InternalAceGen.g:7601:1: rule__WhenBlock__AuthorizationAssignment_2 : ( ruleAuthorization ) ;
    public final void rule__WhenBlock__AuthorizationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7605:1: ( ( ruleAuthorization ) )
            // InternalAceGen.g:7606:2: ( ruleAuthorization )
            {
            // InternalAceGen.g:7606:2: ( ruleAuthorization )
            // InternalAceGen.g:7607:3: ruleAuthorization
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
    // InternalAceGen.g:7616:1: rule__ThenBlock__StatusCodeAssignment_0 : ( RULE_INT ) ;
    public final void rule__ThenBlock__StatusCodeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7620:1: ( ( RULE_INT ) )
            // InternalAceGen.g:7621:2: ( RULE_INT )
            {
            // InternalAceGen.g:7621:2: ( RULE_INT )
            // InternalAceGen.g:7622:3: RULE_INT
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
    // InternalAceGen.g:7631:1: rule__ThenBlock__ResponseAssignment_1_1 : ( ruleDataDefinition ) ;
    public final void rule__ThenBlock__ResponseAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7635:1: ( ( ruleDataDefinition ) )
            // InternalAceGen.g:7636:2: ( ruleDataDefinition )
            {
            // InternalAceGen.g:7636:2: ( ruleDataDefinition )
            // InternalAceGen.g:7637:3: ruleDataDefinition
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
    // InternalAceGen.g:7646:1: rule__DataDefinition__UuidAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__DataDefinition__UuidAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7650:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7651:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7651:2: ( RULE_STRING )
            // InternalAceGen.g:7652:3: RULE_STRING
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
    // InternalAceGen.g:7661:1: rule__DataDefinition__SystemtimeAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__DataDefinition__SystemtimeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7665:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7666:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7666:2: ( RULE_STRING )
            // InternalAceGen.g:7667:3: RULE_STRING
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


    // $ANTLR start "rule__DataDefinition__DataAssignment_3"
    // InternalAceGen.g:7676:1: rule__DataDefinition__DataAssignment_3 : ( ruleAttributeDefinitionList ) ;
    public final void rule__DataDefinition__DataAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7680:1: ( ( ruleAttributeDefinitionList ) )
            // InternalAceGen.g:7681:2: ( ruleAttributeDefinitionList )
            {
            // InternalAceGen.g:7681:2: ( ruleAttributeDefinitionList )
            // InternalAceGen.g:7682:3: ruleAttributeDefinitionList
            {
             before(grammarAccess.getDataDefinitionAccess().getDataAttributeDefinitionListParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeDefinitionList();

            state._fsp--;

             after(grammarAccess.getDataDefinitionAccess().getDataAttributeDefinitionListParserRuleCall_3_0()); 

            }


            }

        }
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
    // InternalAceGen.g:7691:1: rule__Authorization__UsernameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Authorization__UsernameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7695:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7696:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7696:2: ( RULE_STRING )
            // InternalAceGen.g:7697:3: RULE_STRING
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
    // InternalAceGen.g:7706:1: rule__Authorization__PasswordAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Authorization__PasswordAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7710:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7711:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7711:2: ( RULE_STRING )
            // InternalAceGen.g:7712:3: RULE_STRING
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


    // $ANTLR start "rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2"
    // InternalAceGen.g:7721:1: rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 : ( ruleAttributeDefinition ) ;
    public final void rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7725:1: ( ( ruleAttributeDefinition ) )
            // InternalAceGen.g:7726:2: ( ruleAttributeDefinition )
            {
            // InternalAceGen.g:7726:2: ( ruleAttributeDefinition )
            // InternalAceGen.g:7727:3: ruleAttributeDefinition
            {
             before(grammarAccess.getAttributeDefinitionListAccess().getAttributeDefinitionsAttributeDefinitionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeDefinition();

            state._fsp--;

             after(grammarAccess.getAttributeDefinitionListAccess().getAttributeDefinitionsAttributeDefinitionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2"


    // $ANTLR start "rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2"
    // InternalAceGen.g:7736:1: rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2 : ( ruleAttributeDefinitionList ) ;
    public final void rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7740:1: ( ( ruleAttributeDefinitionList ) )
            // InternalAceGen.g:7741:2: ( ruleAttributeDefinitionList )
            {
            // InternalAceGen.g:7741:2: ( ruleAttributeDefinitionList )
            // InternalAceGen.g:7742:3: ruleAttributeDefinitionList
            {
             before(grammarAccess.getListAttributeDefinitionListAccess().getAttributeDefinitionListAttributeDefinitionListParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeDefinitionList();

            state._fsp--;

             after(grammarAccess.getListAttributeDefinitionListAccess().getAttributeDefinitionListAttributeDefinitionListParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ListAttributeDefinitionList__AttributeDefinitionListAssignment_2"


    // $ANTLR start "rule__AttributeDefinition__AttributeAssignment_0"
    // InternalAceGen.g:7751:1: rule__AttributeDefinition__AttributeAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__AttributeDefinition__AttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7755:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7756:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7756:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7757:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeDefinitionAccess().getAttributeAttributeCrossReference_0_0()); 
            // InternalAceGen.g:7758:3: ( ruleQualifiedName )
            // InternalAceGen.g:7759:4: ruleQualifiedName
            {
             before(grammarAccess.getAttributeDefinitionAccess().getAttributeAttributeQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getAttributeDefinitionAccess().getAttributeAttributeQualifiedNameParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAttributeDefinitionAccess().getAttributeAttributeCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinition__AttributeAssignment_0"


    // $ANTLR start "rule__AttributeDefinition__ValueAssignment_2"
    // InternalAceGen.g:7770:1: rule__AttributeDefinition__ValueAssignment_2 : ( ruleValue ) ;
    public final void rule__AttributeDefinition__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7774:1: ( ( ruleValue ) )
            // InternalAceGen.g:7775:2: ( ruleValue )
            {
            // InternalAceGen.g:7775:2: ( ruleValue )
            // InternalAceGen.g:7776:3: ruleValue
            {
             before(grammarAccess.getAttributeDefinitionAccess().getValueValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getAttributeDefinitionAccess().getValueValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinition__ValueAssignment_2"


    // $ANTLR start "rule__Attribute__UniqueAssignment_0"
    // InternalAceGen.g:7785:1: rule__Attribute__UniqueAssignment_0 : ( ( 'Unique' ) ) ;
    public final void rule__Attribute__UniqueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7789:1: ( ( ( 'Unique' ) ) )
            // InternalAceGen.g:7790:2: ( ( 'Unique' ) )
            {
            // InternalAceGen.g:7790:2: ( ( 'Unique' ) )
            // InternalAceGen.g:7791:3: ( 'Unique' )
            {
             before(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 
            // InternalAceGen.g:7792:3: ( 'Unique' )
            // InternalAceGen.g:7793:4: 'Unique'
            {
             before(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 
            match(input,70,FOLLOW_2); 
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
    // InternalAceGen.g:7804:1: rule__Attribute__PrimaryKeyAssignment_1 : ( ( 'PrimaryKey' ) ) ;
    public final void rule__Attribute__PrimaryKeyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7808:1: ( ( ( 'PrimaryKey' ) ) )
            // InternalAceGen.g:7809:2: ( ( 'PrimaryKey' ) )
            {
            // InternalAceGen.g:7809:2: ( ( 'PrimaryKey' ) )
            // InternalAceGen.g:7810:3: ( 'PrimaryKey' )
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 
            // InternalAceGen.g:7811:3: ( 'PrimaryKey' )
            // InternalAceGen.g:7812:4: 'PrimaryKey'
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 
            match(input,71,FOLLOW_2); 
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
    // InternalAceGen.g:7823:1: rule__Attribute__ConstraintAssignment_2 : ( ruleConstraint ) ;
    public final void rule__Attribute__ConstraintAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7827:1: ( ( ruleConstraint ) )
            // InternalAceGen.g:7828:2: ( ruleConstraint )
            {
            // InternalAceGen.g:7828:2: ( ruleConstraint )
            // InternalAceGen.g:7829:3: ruleConstraint
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
    // InternalAceGen.g:7838:1: rule__Attribute__ListAssignment_3 : ( ( 'List' ) ) ;
    public final void rule__Attribute__ListAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7842:1: ( ( ( 'List' ) ) )
            // InternalAceGen.g:7843:2: ( ( 'List' ) )
            {
            // InternalAceGen.g:7843:2: ( ( 'List' ) )
            // InternalAceGen.g:7844:3: ( 'List' )
            {
             before(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 
            // InternalAceGen.g:7845:3: ( 'List' )
            // InternalAceGen.g:7846:4: 'List'
            {
             before(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 
            match(input,72,FOLLOW_2); 
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
    // InternalAceGen.g:7857:1: rule__Attribute__TypeAssignment_4_0 : ( ruleType ) ;
    public final void rule__Attribute__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7861:1: ( ( ruleType ) )
            // InternalAceGen.g:7862:2: ( ruleType )
            {
            // InternalAceGen.g:7862:2: ( ruleType )
            // InternalAceGen.g:7863:3: ruleType
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
    // InternalAceGen.g:7872:1: rule__Attribute__ModelAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Attribute__ModelAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7876:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7877:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7877:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7878:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeAccess().getModelModelCrossReference_4_1_0()); 
            // InternalAceGen.g:7879:3: ( ruleQualifiedName )
            // InternalAceGen.g:7880:4: ruleQualifiedName
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
    // InternalAceGen.g:7891:1: rule__Attribute__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7895:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7896:2: ( RULE_ID )
            {
            // InternalAceGen.g:7896:2: ( RULE_ID )
            // InternalAceGen.g:7897:3: RULE_ID
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
    // InternalAceGen.g:7906:1: rule__Attribute__ForeignKeyAssignment_6_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Attribute__ForeignKeyAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7910:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7911:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7911:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7912:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0()); 
            // InternalAceGen.g:7913:3: ( ruleQualifiedName )
            // InternalAceGen.g:7914:4: ruleQualifiedName
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
    // InternalAceGen.g:7925:1: rule__Attribute__NotReplayableAssignment_7 : ( ( 'notReplayable' ) ) ;
    public final void rule__Attribute__NotReplayableAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7929:1: ( ( ( 'notReplayable' ) ) )
            // InternalAceGen.g:7930:2: ( ( 'notReplayable' ) )
            {
            // InternalAceGen.g:7930:2: ( ( 'notReplayable' ) )
            // InternalAceGen.g:7931:3: ( 'notReplayable' )
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableNotReplayableKeyword_7_0()); 
            // InternalAceGen.g:7932:3: ( 'notReplayable' )
            // InternalAceGen.g:7933:4: 'notReplayable'
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableNotReplayableKeyword_7_0()); 
            match(input,73,FOLLOW_2); 
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


    // $ANTLR start "rule__Value__StringValueAssignment_0"
    // InternalAceGen.g:7944:1: rule__Value__StringValueAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Value__StringValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7948:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7949:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7949:2: ( RULE_STRING )
            // InternalAceGen.g:7950:3: RULE_STRING
            {
             before(grammarAccess.getValueAccess().getStringValueSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getValueAccess().getStringValueSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__StringValueAssignment_0"


    // $ANTLR start "rule__Value__IntValueAssignment_1"
    // InternalAceGen.g:7959:1: rule__Value__IntValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__Value__IntValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7963:1: ( ( RULE_INT ) )
            // InternalAceGen.g:7964:2: ( RULE_INT )
            {
            // InternalAceGen.g:7964:2: ( RULE_INT )
            // InternalAceGen.g:7965:3: RULE_INT
            {
             before(grammarAccess.getValueAccess().getIntValueINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getValueAccess().getIntValueINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__IntValueAssignment_1"


    // $ANTLR start "rule__Value__AttributeDefinitionListAssignment_2"
    // InternalAceGen.g:7974:1: rule__Value__AttributeDefinitionListAssignment_2 : ( ruleAttributeDefinitionList ) ;
    public final void rule__Value__AttributeDefinitionListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7978:1: ( ( ruleAttributeDefinitionList ) )
            // InternalAceGen.g:7979:2: ( ruleAttributeDefinitionList )
            {
            // InternalAceGen.g:7979:2: ( ruleAttributeDefinitionList )
            // InternalAceGen.g:7980:3: ruleAttributeDefinitionList
            {
             before(grammarAccess.getValueAccess().getAttributeDefinitionListAttributeDefinitionListParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeDefinitionList();

            state._fsp--;

             after(grammarAccess.getValueAccess().getAttributeDefinitionListAttributeDefinitionListParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__AttributeDefinitionListAssignment_2"


    // $ANTLR start "rule__Value__ListAttributeDefinitionListAssignment_3"
    // InternalAceGen.g:7989:1: rule__Value__ListAttributeDefinitionListAssignment_3 : ( ruleListAttributeDefinitionList ) ;
    public final void rule__Value__ListAttributeDefinitionListAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7993:1: ( ( ruleListAttributeDefinitionList ) )
            // InternalAceGen.g:7994:2: ( ruleListAttributeDefinitionList )
            {
            // InternalAceGen.g:7994:2: ( ruleListAttributeDefinitionList )
            // InternalAceGen.g:7995:3: ruleListAttributeDefinitionList
            {
             before(grammarAccess.getValueAccess().getListAttributeDefinitionListListAttributeDefinitionListParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleListAttributeDefinitionList();

            state._fsp--;

             after(grammarAccess.getValueAccess().getListAttributeDefinitionListListAttributeDefinitionListParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__ListAttributeDefinitionListAssignment_3"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\2\4\1\37\1\4\1\40\1\4\1\13\1\40\2\uffff";
    static final String dfa_3s = "\1\103\1\4\1\37\1\4\1\77\1\4\1\22\1\77\2\uffff";
    static final String dfa_4s = "\10\uffff\1\2\1\1";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\76\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\36\uffff\1\5",
            "\1\7",
            "\1\10\4\uffff\3\11",
            "\1\6\36\uffff\1\5",
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
            return "906:1: rule__HttpServerAce__Alternatives : ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) );";
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
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0001F00020000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000008L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000008L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000020L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x001E001000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x001E000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000080007F80010L,0x00000000000001C0L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000007F80012L,0x00000000000001C0L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0020040000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0600040000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x2000040000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x1000040000000060L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000007F80010L,0x00000000000001C0L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x8000000000000002L});

}