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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'GET'", "'set'", "'merge'", "'reset'", "'init'", "'POST'", "'PUT'", "'DELETE'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'Long'", "'NotEmpty'", "'NotNull'", "'HttpClient'", "'HttpServer'", "'ACE'", "'appState'", "'<'", "'>'", "','", "'call'", "'loadingFlag'", "'on'", "'('", "')'", "'triggers'", "'|'", "':'", "'{'", "'}'", "'Authorization'", "'import'", "'views'", "'models'", "'scenarios'", "'pathParams'", "'queryParams'", "'payload'", "'response'", "'extends'", "'WHEN'", "'THEN'", "'GIVEN'", "'x'", "'uuid'", "'systemTime'", "'authorization'", "'['", "']'", "'references'", "'.'", "'async'", "'list'", "'location.hash'", "'storage'", "'proxy'", "'authorize'", "'persistent'", "'Unique'", "'PrimaryKey'", "'List'", "'notReplayable'"
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
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
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


    // $ANTLR start "entryRuleGivenRef"
    // InternalAceGen.g:503:1: entryRuleGivenRef : ruleGivenRef EOF ;
    public final void entryRuleGivenRef() throws RecognitionException {
        try {
            // InternalAceGen.g:504:1: ( ruleGivenRef EOF )
            // InternalAceGen.g:505:1: ruleGivenRef EOF
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
    // InternalAceGen.g:512:1: ruleGivenRef : ( ( rule__GivenRef__Group__0 ) ) ;
    public final void ruleGivenRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:516:2: ( ( ( rule__GivenRef__Group__0 ) ) )
            // InternalAceGen.g:517:2: ( ( rule__GivenRef__Group__0 ) )
            {
            // InternalAceGen.g:517:2: ( ( rule__GivenRef__Group__0 ) )
            // InternalAceGen.g:518:3: ( rule__GivenRef__Group__0 )
            {
             before(grammarAccess.getGivenRefAccess().getGroup()); 
            // InternalAceGen.g:519:3: ( rule__GivenRef__Group__0 )
            // InternalAceGen.g:519:4: rule__GivenRef__Group__0
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
    // InternalAceGen.g:528:1: entryRuleWhenBlock : ruleWhenBlock EOF ;
    public final void entryRuleWhenBlock() throws RecognitionException {
        try {
            // InternalAceGen.g:529:1: ( ruleWhenBlock EOF )
            // InternalAceGen.g:530:1: ruleWhenBlock EOF
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
    // InternalAceGen.g:537:1: ruleWhenBlock : ( ( rule__WhenBlock__Group__0 ) ) ;
    public final void ruleWhenBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:541:2: ( ( ( rule__WhenBlock__Group__0 ) ) )
            // InternalAceGen.g:542:2: ( ( rule__WhenBlock__Group__0 ) )
            {
            // InternalAceGen.g:542:2: ( ( rule__WhenBlock__Group__0 ) )
            // InternalAceGen.g:543:3: ( rule__WhenBlock__Group__0 )
            {
             before(grammarAccess.getWhenBlockAccess().getGroup()); 
            // InternalAceGen.g:544:3: ( rule__WhenBlock__Group__0 )
            // InternalAceGen.g:544:4: rule__WhenBlock__Group__0
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
    // InternalAceGen.g:553:1: entryRuleThenBlock : ruleThenBlock EOF ;
    public final void entryRuleThenBlock() throws RecognitionException {
        try {
            // InternalAceGen.g:554:1: ( ruleThenBlock EOF )
            // InternalAceGen.g:555:1: ruleThenBlock EOF
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
    // InternalAceGen.g:562:1: ruleThenBlock : ( ( rule__ThenBlock__Group__0 ) ) ;
    public final void ruleThenBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:566:2: ( ( ( rule__ThenBlock__Group__0 ) ) )
            // InternalAceGen.g:567:2: ( ( rule__ThenBlock__Group__0 ) )
            {
            // InternalAceGen.g:567:2: ( ( rule__ThenBlock__Group__0 ) )
            // InternalAceGen.g:568:3: ( rule__ThenBlock__Group__0 )
            {
             before(grammarAccess.getThenBlockAccess().getGroup()); 
            // InternalAceGen.g:569:3: ( rule__ThenBlock__Group__0 )
            // InternalAceGen.g:569:4: rule__ThenBlock__Group__0
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
    // InternalAceGen.g:578:1: entryRuleDataDefinition : ruleDataDefinition EOF ;
    public final void entryRuleDataDefinition() throws RecognitionException {
        try {
            // InternalAceGen.g:579:1: ( ruleDataDefinition EOF )
            // InternalAceGen.g:580:1: ruleDataDefinition EOF
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
    // InternalAceGen.g:587:1: ruleDataDefinition : ( ( rule__DataDefinition__Group__0 ) ) ;
    public final void ruleDataDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:591:2: ( ( ( rule__DataDefinition__Group__0 ) ) )
            // InternalAceGen.g:592:2: ( ( rule__DataDefinition__Group__0 ) )
            {
            // InternalAceGen.g:592:2: ( ( rule__DataDefinition__Group__0 ) )
            // InternalAceGen.g:593:3: ( rule__DataDefinition__Group__0 )
            {
             before(grammarAccess.getDataDefinitionAccess().getGroup()); 
            // InternalAceGen.g:594:3: ( rule__DataDefinition__Group__0 )
            // InternalAceGen.g:594:4: rule__DataDefinition__Group__0
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
    // InternalAceGen.g:603:1: entryRuleAuthorization : ruleAuthorization EOF ;
    public final void entryRuleAuthorization() throws RecognitionException {
        try {
            // InternalAceGen.g:604:1: ( ruleAuthorization EOF )
            // InternalAceGen.g:605:1: ruleAuthorization EOF
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
    // InternalAceGen.g:612:1: ruleAuthorization : ( ( rule__Authorization__Group__0 ) ) ;
    public final void ruleAuthorization() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:616:2: ( ( ( rule__Authorization__Group__0 ) ) )
            // InternalAceGen.g:617:2: ( ( rule__Authorization__Group__0 ) )
            {
            // InternalAceGen.g:617:2: ( ( rule__Authorization__Group__0 ) )
            // InternalAceGen.g:618:3: ( rule__Authorization__Group__0 )
            {
             before(grammarAccess.getAuthorizationAccess().getGroup()); 
            // InternalAceGen.g:619:3: ( rule__Authorization__Group__0 )
            // InternalAceGen.g:619:4: rule__Authorization__Group__0
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
    // InternalAceGen.g:628:1: entryRuleAttributeDefinitionList : ruleAttributeDefinitionList EOF ;
    public final void entryRuleAttributeDefinitionList() throws RecognitionException {
        try {
            // InternalAceGen.g:629:1: ( ruleAttributeDefinitionList EOF )
            // InternalAceGen.g:630:1: ruleAttributeDefinitionList EOF
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
    // InternalAceGen.g:637:1: ruleAttributeDefinitionList : ( ( rule__AttributeDefinitionList__Group__0 ) ) ;
    public final void ruleAttributeDefinitionList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:641:2: ( ( ( rule__AttributeDefinitionList__Group__0 ) ) )
            // InternalAceGen.g:642:2: ( ( rule__AttributeDefinitionList__Group__0 ) )
            {
            // InternalAceGen.g:642:2: ( ( rule__AttributeDefinitionList__Group__0 ) )
            // InternalAceGen.g:643:3: ( rule__AttributeDefinitionList__Group__0 )
            {
             before(grammarAccess.getAttributeDefinitionListAccess().getGroup()); 
            // InternalAceGen.g:644:3: ( rule__AttributeDefinitionList__Group__0 )
            // InternalAceGen.g:644:4: rule__AttributeDefinitionList__Group__0
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
    // InternalAceGen.g:653:1: entryRuleListAttributeDefinitionList : ruleListAttributeDefinitionList EOF ;
    public final void entryRuleListAttributeDefinitionList() throws RecognitionException {
        try {
            // InternalAceGen.g:654:1: ( ruleListAttributeDefinitionList EOF )
            // InternalAceGen.g:655:1: ruleListAttributeDefinitionList EOF
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
    // InternalAceGen.g:662:1: ruleListAttributeDefinitionList : ( ( rule__ListAttributeDefinitionList__Alternatives ) ) ;
    public final void ruleListAttributeDefinitionList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:666:2: ( ( ( rule__ListAttributeDefinitionList__Alternatives ) ) )
            // InternalAceGen.g:667:2: ( ( rule__ListAttributeDefinitionList__Alternatives ) )
            {
            // InternalAceGen.g:667:2: ( ( rule__ListAttributeDefinitionList__Alternatives ) )
            // InternalAceGen.g:668:3: ( rule__ListAttributeDefinitionList__Alternatives )
            {
             before(grammarAccess.getListAttributeDefinitionListAccess().getAlternatives()); 
            // InternalAceGen.g:669:3: ( rule__ListAttributeDefinitionList__Alternatives )
            // InternalAceGen.g:669:4: rule__ListAttributeDefinitionList__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ListAttributeDefinitionList__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getListAttributeDefinitionListAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleAttributeDefinitionListForList"
    // InternalAceGen.g:678:1: entryRuleAttributeDefinitionListForList : ruleAttributeDefinitionListForList EOF ;
    public final void entryRuleAttributeDefinitionListForList() throws RecognitionException {
        try {
            // InternalAceGen.g:679:1: ( ruleAttributeDefinitionListForList EOF )
            // InternalAceGen.g:680:1: ruleAttributeDefinitionListForList EOF
            {
             before(grammarAccess.getAttributeDefinitionListForListRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeDefinitionListForList();

            state._fsp--;

             after(grammarAccess.getAttributeDefinitionListForListRule()); 
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
    // $ANTLR end "entryRuleAttributeDefinitionListForList"


    // $ANTLR start "ruleAttributeDefinitionListForList"
    // InternalAceGen.g:687:1: ruleAttributeDefinitionListForList : ( ( rule__AttributeDefinitionListForList__Group__0 ) ) ;
    public final void ruleAttributeDefinitionListForList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:691:2: ( ( ( rule__AttributeDefinitionListForList__Group__0 ) ) )
            // InternalAceGen.g:692:2: ( ( rule__AttributeDefinitionListForList__Group__0 ) )
            {
            // InternalAceGen.g:692:2: ( ( rule__AttributeDefinitionListForList__Group__0 ) )
            // InternalAceGen.g:693:3: ( rule__AttributeDefinitionListForList__Group__0 )
            {
             before(grammarAccess.getAttributeDefinitionListForListAccess().getGroup()); 
            // InternalAceGen.g:694:3: ( rule__AttributeDefinitionListForList__Group__0 )
            // InternalAceGen.g:694:4: rule__AttributeDefinitionListForList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionListForList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeDefinitionListForListAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeDefinitionListForList"


    // $ANTLR start "entryRulePrimitiveValueDefinitionForList"
    // InternalAceGen.g:703:1: entryRulePrimitiveValueDefinitionForList : rulePrimitiveValueDefinitionForList EOF ;
    public final void entryRulePrimitiveValueDefinitionForList() throws RecognitionException {
        try {
            // InternalAceGen.g:704:1: ( rulePrimitiveValueDefinitionForList EOF )
            // InternalAceGen.g:705:1: rulePrimitiveValueDefinitionForList EOF
            {
             before(grammarAccess.getPrimitiveValueDefinitionForListRule()); 
            pushFollow(FOLLOW_1);
            rulePrimitiveValueDefinitionForList();

            state._fsp--;

             after(grammarAccess.getPrimitiveValueDefinitionForListRule()); 
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
    // $ANTLR end "entryRulePrimitiveValueDefinitionForList"


    // $ANTLR start "rulePrimitiveValueDefinitionForList"
    // InternalAceGen.g:712:1: rulePrimitiveValueDefinitionForList : ( ( rule__PrimitiveValueDefinitionForList__Group__0 ) ) ;
    public final void rulePrimitiveValueDefinitionForList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:716:2: ( ( ( rule__PrimitiveValueDefinitionForList__Group__0 ) ) )
            // InternalAceGen.g:717:2: ( ( rule__PrimitiveValueDefinitionForList__Group__0 ) )
            {
            // InternalAceGen.g:717:2: ( ( rule__PrimitiveValueDefinitionForList__Group__0 ) )
            // InternalAceGen.g:718:3: ( rule__PrimitiveValueDefinitionForList__Group__0 )
            {
             before(grammarAccess.getPrimitiveValueDefinitionForListAccess().getGroup()); 
            // InternalAceGen.g:719:3: ( rule__PrimitiveValueDefinitionForList__Group__0 )
            // InternalAceGen.g:719:4: rule__PrimitiveValueDefinitionForList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveValueDefinitionForList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveValueDefinitionForListAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimitiveValueDefinitionForList"


    // $ANTLR start "entryRuleAttributeDefinition"
    // InternalAceGen.g:728:1: entryRuleAttributeDefinition : ruleAttributeDefinition EOF ;
    public final void entryRuleAttributeDefinition() throws RecognitionException {
        try {
            // InternalAceGen.g:729:1: ( ruleAttributeDefinition EOF )
            // InternalAceGen.g:730:1: ruleAttributeDefinition EOF
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
    // InternalAceGen.g:737:1: ruleAttributeDefinition : ( ( rule__AttributeDefinition__Group__0 ) ) ;
    public final void ruleAttributeDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:741:2: ( ( ( rule__AttributeDefinition__Group__0 ) ) )
            // InternalAceGen.g:742:2: ( ( rule__AttributeDefinition__Group__0 ) )
            {
            // InternalAceGen.g:742:2: ( ( rule__AttributeDefinition__Group__0 ) )
            // InternalAceGen.g:743:3: ( rule__AttributeDefinition__Group__0 )
            {
             before(grammarAccess.getAttributeDefinitionAccess().getGroup()); 
            // InternalAceGen.g:744:3: ( rule__AttributeDefinition__Group__0 )
            // InternalAceGen.g:744:4: rule__AttributeDefinition__Group__0
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


    // $ANTLR start "entryRuleValueDefinitionList"
    // InternalAceGen.g:753:1: entryRuleValueDefinitionList : ruleValueDefinitionList EOF ;
    public final void entryRuleValueDefinitionList() throws RecognitionException {
        try {
            // InternalAceGen.g:754:1: ( ruleValueDefinitionList EOF )
            // InternalAceGen.g:755:1: ruleValueDefinitionList EOF
            {
             before(grammarAccess.getValueDefinitionListRule()); 
            pushFollow(FOLLOW_1);
            ruleValueDefinitionList();

            state._fsp--;

             after(grammarAccess.getValueDefinitionListRule()); 
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
    // $ANTLR end "entryRuleValueDefinitionList"


    // $ANTLR start "ruleValueDefinitionList"
    // InternalAceGen.g:762:1: ruleValueDefinitionList : ( ( rule__ValueDefinitionList__PrimitiveValueAssignment ) ) ;
    public final void ruleValueDefinitionList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:766:2: ( ( ( rule__ValueDefinitionList__PrimitiveValueAssignment ) ) )
            // InternalAceGen.g:767:2: ( ( rule__ValueDefinitionList__PrimitiveValueAssignment ) )
            {
            // InternalAceGen.g:767:2: ( ( rule__ValueDefinitionList__PrimitiveValueAssignment ) )
            // InternalAceGen.g:768:3: ( rule__ValueDefinitionList__PrimitiveValueAssignment )
            {
             before(grammarAccess.getValueDefinitionListAccess().getPrimitiveValueAssignment()); 
            // InternalAceGen.g:769:3: ( rule__ValueDefinitionList__PrimitiveValueAssignment )
            // InternalAceGen.g:769:4: rule__ValueDefinitionList__PrimitiveValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ValueDefinitionList__PrimitiveValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getValueDefinitionListAccess().getPrimitiveValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueDefinitionList"


    // $ANTLR start "entryRuleAttribute"
    // InternalAceGen.g:778:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalAceGen.g:779:1: ( ruleAttribute EOF )
            // InternalAceGen.g:780:1: ruleAttribute EOF
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
    // InternalAceGen.g:787:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:791:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalAceGen.g:792:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalAceGen.g:792:2: ( ( rule__Attribute__Group__0 ) )
            // InternalAceGen.g:793:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalAceGen.g:794:3: ( rule__Attribute__Group__0 )
            // InternalAceGen.g:794:4: rule__Attribute__Group__0
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
    // InternalAceGen.g:803:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalAceGen.g:804:1: ( ruleQualifiedName EOF )
            // InternalAceGen.g:805:1: ruleQualifiedName EOF
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
    // InternalAceGen.g:812:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:816:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalAceGen.g:817:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalAceGen.g:817:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalAceGen.g:818:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalAceGen.g:819:3: ( rule__QualifiedName__Group__0 )
            // InternalAceGen.g:819:4: rule__QualifiedName__Group__0
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
    // InternalAceGen.g:828:1: entryRuleWriteFunctionType : ruleWriteFunctionType EOF ;
    public final void entryRuleWriteFunctionType() throws RecognitionException {
        try {
            // InternalAceGen.g:829:1: ( ruleWriteFunctionType EOF )
            // InternalAceGen.g:830:1: ruleWriteFunctionType EOF
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
    // InternalAceGen.g:837:1: ruleWriteFunctionType : ( ( rule__WriteFunctionType__Alternatives ) ) ;
    public final void ruleWriteFunctionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:841:2: ( ( ( rule__WriteFunctionType__Alternatives ) ) )
            // InternalAceGen.g:842:2: ( ( rule__WriteFunctionType__Alternatives ) )
            {
            // InternalAceGen.g:842:2: ( ( rule__WriteFunctionType__Alternatives ) )
            // InternalAceGen.g:843:3: ( rule__WriteFunctionType__Alternatives )
            {
             before(grammarAccess.getWriteFunctionTypeAccess().getAlternatives()); 
            // InternalAceGen.g:844:3: ( rule__WriteFunctionType__Alternatives )
            // InternalAceGen.g:844:4: rule__WriteFunctionType__Alternatives
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
    // InternalAceGen.g:853:1: entryRuleReadFunctionType : ruleReadFunctionType EOF ;
    public final void entryRuleReadFunctionType() throws RecognitionException {
        try {
            // InternalAceGen.g:854:1: ( ruleReadFunctionType EOF )
            // InternalAceGen.g:855:1: ruleReadFunctionType EOF
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
    // InternalAceGen.g:862:1: ruleReadFunctionType : ( 'GET' ) ;
    public final void ruleReadFunctionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:866:2: ( ( 'GET' ) )
            // InternalAceGen.g:867:2: ( 'GET' )
            {
            // InternalAceGen.g:867:2: ( 'GET' )
            // InternalAceGen.g:868:3: 'GET'
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
    // InternalAceGen.g:878:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalAceGen.g:879:1: ( ruleType EOF )
            // InternalAceGen.g:880:1: ruleType EOF
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
    // InternalAceGen.g:887:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:891:2: ( ( ( rule__Type__Alternatives ) ) )
            // InternalAceGen.g:892:2: ( ( rule__Type__Alternatives ) )
            {
            // InternalAceGen.g:892:2: ( ( rule__Type__Alternatives ) )
            // InternalAceGen.g:893:3: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // InternalAceGen.g:894:3: ( rule__Type__Alternatives )
            // InternalAceGen.g:894:4: rule__Type__Alternatives
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
    // InternalAceGen.g:903:1: entryRuleConstraint : ruleConstraint EOF ;
    public final void entryRuleConstraint() throws RecognitionException {
        try {
            // InternalAceGen.g:904:1: ( ruleConstraint EOF )
            // InternalAceGen.g:905:1: ruleConstraint EOF
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
    // InternalAceGen.g:912:1: ruleConstraint : ( ( rule__Constraint__Alternatives ) ) ;
    public final void ruleConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:916:2: ( ( ( rule__Constraint__Alternatives ) ) )
            // InternalAceGen.g:917:2: ( ( rule__Constraint__Alternatives ) )
            {
            // InternalAceGen.g:917:2: ( ( rule__Constraint__Alternatives ) )
            // InternalAceGen.g:918:3: ( rule__Constraint__Alternatives )
            {
             before(grammarAccess.getConstraintAccess().getAlternatives()); 
            // InternalAceGen.g:919:3: ( rule__Constraint__Alternatives )
            // InternalAceGen.g:919:4: rule__Constraint__Alternatives
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
    // InternalAceGen.g:928:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // InternalAceGen.g:929:1: ( ruleValue EOF )
            // InternalAceGen.g:930:1: ruleValue EOF
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
    // InternalAceGen.g:937:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:941:2: ( ( ( rule__Value__Alternatives ) ) )
            // InternalAceGen.g:942:2: ( ( rule__Value__Alternatives ) )
            {
            // InternalAceGen.g:942:2: ( ( rule__Value__Alternatives ) )
            // InternalAceGen.g:943:3: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // InternalAceGen.g:944:3: ( rule__Value__Alternatives )
            // InternalAceGen.g:944:4: rule__Value__Alternatives
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


    // $ANTLR start "entryRulePrimitiveValue"
    // InternalAceGen.g:953:1: entryRulePrimitiveValue : rulePrimitiveValue EOF ;
    public final void entryRulePrimitiveValue() throws RecognitionException {
        try {
            // InternalAceGen.g:954:1: ( rulePrimitiveValue EOF )
            // InternalAceGen.g:955:1: rulePrimitiveValue EOF
            {
             before(grammarAccess.getPrimitiveValueRule()); 
            pushFollow(FOLLOW_1);
            rulePrimitiveValue();

            state._fsp--;

             after(grammarAccess.getPrimitiveValueRule()); 
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
    // $ANTLR end "entryRulePrimitiveValue"


    // $ANTLR start "rulePrimitiveValue"
    // InternalAceGen.g:962:1: rulePrimitiveValue : ( ( rule__PrimitiveValue__Alternatives ) ) ;
    public final void rulePrimitiveValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:966:2: ( ( ( rule__PrimitiveValue__Alternatives ) ) )
            // InternalAceGen.g:967:2: ( ( rule__PrimitiveValue__Alternatives ) )
            {
            // InternalAceGen.g:967:2: ( ( rule__PrimitiveValue__Alternatives ) )
            // InternalAceGen.g:968:3: ( rule__PrimitiveValue__Alternatives )
            {
             before(grammarAccess.getPrimitiveValueAccess().getAlternatives()); 
            // InternalAceGen.g:969:3: ( rule__PrimitiveValue__Alternatives )
            // InternalAceGen.g:969:4: rule__PrimitiveValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimitiveValue"


    // $ANTLR start "rule__Project__Alternatives_1"
    // InternalAceGen.g:977:1: rule__Project__Alternatives_1 : ( ( ( rule__Project__Group_1_0__0 ) ) | ( ( rule__Project__Group_1_1__0 ) ) );
    public final void rule__Project__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:981:1: ( ( ( rule__Project__Group_1_0__0 ) ) | ( ( rule__Project__Group_1_1__0 ) ) )
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
                    // InternalAceGen.g:982:2: ( ( rule__Project__Group_1_0__0 ) )
                    {
                    // InternalAceGen.g:982:2: ( ( rule__Project__Group_1_0__0 ) )
                    // InternalAceGen.g:983:3: ( rule__Project__Group_1_0__0 )
                    {
                     before(grammarAccess.getProjectAccess().getGroup_1_0()); 
                    // InternalAceGen.g:984:3: ( rule__Project__Group_1_0__0 )
                    // InternalAceGen.g:984:4: rule__Project__Group_1_0__0
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
                    // InternalAceGen.g:988:2: ( ( rule__Project__Group_1_1__0 ) )
                    {
                    // InternalAceGen.g:988:2: ( ( rule__Project__Group_1_1__0 ) )
                    // InternalAceGen.g:989:3: ( rule__Project__Group_1_1__0 )
                    {
                     before(grammarAccess.getProjectAccess().getGroup_1_1()); 
                    // InternalAceGen.g:990:3: ( rule__Project__Group_1_1__0 )
                    // InternalAceGen.g:990:4: rule__Project__Group_1_1__0
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
    // InternalAceGen.g:998:1: rule__HttpClientStateFunctionType__Alternatives : ( ( 'set' ) | ( 'merge' ) | ( 'reset' ) | ( 'init' ) );
    public final void rule__HttpClientStateFunctionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1002:1: ( ( 'set' ) | ( 'merge' ) | ( 'reset' ) | ( 'init' ) )
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
                    // InternalAceGen.g:1003:2: ( 'set' )
                    {
                    // InternalAceGen.g:1003:2: ( 'set' )
                    // InternalAceGen.g:1004:3: 'set'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1009:2: ( 'merge' )
                    {
                    // InternalAceGen.g:1009:2: ( 'merge' )
                    // InternalAceGen.g:1010:3: 'merge'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:1015:2: ( 'reset' )
                    {
                    // InternalAceGen.g:1015:2: ( 'reset' )
                    // InternalAceGen.g:1016:3: 'reset'
                    {
                     before(grammarAccess.getHttpClientStateFunctionTypeAccess().getResetKeyword_2()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getHttpClientStateFunctionTypeAccess().getResetKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:1021:2: ( 'init' )
                    {
                    // InternalAceGen.g:1021:2: ( 'init' )
                    // InternalAceGen.g:1022:3: 'init'
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
    // InternalAceGen.g:1031:1: rule__HttpServerAce__Alternatives : ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) );
    public final void rule__HttpServerAce__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1035:1: ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalAceGen.g:1036:2: ( ruleHttpServerAceWrite )
                    {
                    // InternalAceGen.g:1036:2: ( ruleHttpServerAceWrite )
                    // InternalAceGen.g:1037:3: ruleHttpServerAceWrite
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
                    // InternalAceGen.g:1042:2: ( ruleHttpServerAceRead )
                    {
                    // InternalAceGen.g:1042:2: ( ruleHttpServerAceRead )
                    // InternalAceGen.g:1043:3: ruleHttpServerAceRead
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


    // $ANTLR start "rule__ListAttributeDefinitionList__Alternatives"
    // InternalAceGen.g:1052:1: rule__ListAttributeDefinitionList__Alternatives : ( ( rulePrimitiveValueDefinitionForList ) | ( ruleAttributeDefinitionListForList ) );
    public final void rule__ListAttributeDefinitionList__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1056:1: ( ( rulePrimitiveValueDefinitionForList ) | ( ruleAttributeDefinitionListForList ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==37) ) {
                alt4=1;
            }
            else if ( (LA4_0==61) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalAceGen.g:1057:2: ( rulePrimitiveValueDefinitionForList )
                    {
                    // InternalAceGen.g:1057:2: ( rulePrimitiveValueDefinitionForList )
                    // InternalAceGen.g:1058:3: rulePrimitiveValueDefinitionForList
                    {
                     before(grammarAccess.getListAttributeDefinitionListAccess().getPrimitiveValueDefinitionForListParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePrimitiveValueDefinitionForList();

                    state._fsp--;

                     after(grammarAccess.getListAttributeDefinitionListAccess().getPrimitiveValueDefinitionForListParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1063:2: ( ruleAttributeDefinitionListForList )
                    {
                    // InternalAceGen.g:1063:2: ( ruleAttributeDefinitionListForList )
                    // InternalAceGen.g:1064:3: ruleAttributeDefinitionListForList
                    {
                     before(grammarAccess.getListAttributeDefinitionListAccess().getAttributeDefinitionListForListParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleAttributeDefinitionListForList();

                    state._fsp--;

                     after(grammarAccess.getListAttributeDefinitionListAccess().getAttributeDefinitionListForListParserRuleCall_1()); 

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
    // $ANTLR end "rule__ListAttributeDefinitionList__Alternatives"


    // $ANTLR start "rule__Attribute__Alternatives_4"
    // InternalAceGen.g:1073:1: rule__Attribute__Alternatives_4 : ( ( ( rule__Attribute__TypeAssignment_4_0 ) ) | ( ( rule__Attribute__ModelAssignment_4_1 ) ) );
    public final void rule__Attribute__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1077:1: ( ( ( rule__Attribute__TypeAssignment_4_0 ) ) | ( ( rule__Attribute__ModelAssignment_4_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=19 && LA5_0<=24)) ) {
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
                    // InternalAceGen.g:1078:2: ( ( rule__Attribute__TypeAssignment_4_0 ) )
                    {
                    // InternalAceGen.g:1078:2: ( ( rule__Attribute__TypeAssignment_4_0 ) )
                    // InternalAceGen.g:1079:3: ( rule__Attribute__TypeAssignment_4_0 )
                    {
                     before(grammarAccess.getAttributeAccess().getTypeAssignment_4_0()); 
                    // InternalAceGen.g:1080:3: ( rule__Attribute__TypeAssignment_4_0 )
                    // InternalAceGen.g:1080:4: rule__Attribute__TypeAssignment_4_0
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
                    // InternalAceGen.g:1084:2: ( ( rule__Attribute__ModelAssignment_4_1 ) )
                    {
                    // InternalAceGen.g:1084:2: ( ( rule__Attribute__ModelAssignment_4_1 ) )
                    // InternalAceGen.g:1085:3: ( rule__Attribute__ModelAssignment_4_1 )
                    {
                     before(grammarAccess.getAttributeAccess().getModelAssignment_4_1()); 
                    // InternalAceGen.g:1086:3: ( rule__Attribute__ModelAssignment_4_1 )
                    // InternalAceGen.g:1086:4: rule__Attribute__ModelAssignment_4_1
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
    // InternalAceGen.g:1094:1: rule__WriteFunctionType__Alternatives : ( ( 'POST' ) | ( 'PUT' ) | ( 'DELETE' ) );
    public final void rule__WriteFunctionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1098:1: ( ( 'POST' ) | ( 'PUT' ) | ( 'DELETE' ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt6=1;
                }
                break;
            case 17:
                {
                alt6=2;
                }
                break;
            case 18:
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
                    // InternalAceGen.g:1099:2: ( 'POST' )
                    {
                    // InternalAceGen.g:1099:2: ( 'POST' )
                    // InternalAceGen.g:1100:3: 'POST'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1105:2: ( 'PUT' )
                    {
                    // InternalAceGen.g:1105:2: ( 'PUT' )
                    // InternalAceGen.g:1106:3: 'PUT'
                    {
                     before(grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:1111:2: ( 'DELETE' )
                    {
                    // InternalAceGen.g:1111:2: ( 'DELETE' )
                    // InternalAceGen.g:1112:3: 'DELETE'
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
    // InternalAceGen.g:1121:1: rule__Type__Alternatives : ( ( 'Integer' ) | ( 'String' ) | ( 'Float' ) | ( 'Boolean' ) | ( 'DateTime' ) | ( 'Long' ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1125:1: ( ( 'Integer' ) | ( 'String' ) | ( 'Float' ) | ( 'Boolean' ) | ( 'DateTime' ) | ( 'Long' ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt7=1;
                }
                break;
            case 20:
                {
                alt7=2;
                }
                break;
            case 21:
                {
                alt7=3;
                }
                break;
            case 22:
                {
                alt7=4;
                }
                break;
            case 23:
                {
                alt7=5;
                }
                break;
            case 24:
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
                    // InternalAceGen.g:1126:2: ( 'Integer' )
                    {
                    // InternalAceGen.g:1126:2: ( 'Integer' )
                    // InternalAceGen.g:1127:3: 'Integer'
                    {
                     before(grammarAccess.getTypeAccess().getIntegerKeyword_0()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getIntegerKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1132:2: ( 'String' )
                    {
                    // InternalAceGen.g:1132:2: ( 'String' )
                    // InternalAceGen.g:1133:3: 'String'
                    {
                     before(grammarAccess.getTypeAccess().getStringKeyword_1()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getStringKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:1138:2: ( 'Float' )
                    {
                    // InternalAceGen.g:1138:2: ( 'Float' )
                    // InternalAceGen.g:1139:3: 'Float'
                    {
                     before(grammarAccess.getTypeAccess().getFloatKeyword_2()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getFloatKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:1144:2: ( 'Boolean' )
                    {
                    // InternalAceGen.g:1144:2: ( 'Boolean' )
                    // InternalAceGen.g:1145:3: 'Boolean'
                    {
                     before(grammarAccess.getTypeAccess().getBooleanKeyword_3()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getBooleanKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalAceGen.g:1150:2: ( 'DateTime' )
                    {
                    // InternalAceGen.g:1150:2: ( 'DateTime' )
                    // InternalAceGen.g:1151:3: 'DateTime'
                    {
                     before(grammarAccess.getTypeAccess().getDateTimeKeyword_4()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getTypeAccess().getDateTimeKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalAceGen.g:1156:2: ( 'Long' )
                    {
                    // InternalAceGen.g:1156:2: ( 'Long' )
                    // InternalAceGen.g:1157:3: 'Long'
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
    // InternalAceGen.g:1166:1: rule__Constraint__Alternatives : ( ( 'NotEmpty' ) | ( 'NotNull' ) );
    public final void rule__Constraint__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1170:1: ( ( 'NotEmpty' ) | ( 'NotNull' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==25) ) {
                alt8=1;
            }
            else if ( (LA8_0==26) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalAceGen.g:1171:2: ( 'NotEmpty' )
                    {
                    // InternalAceGen.g:1171:2: ( 'NotEmpty' )
                    // InternalAceGen.g:1172:3: 'NotEmpty'
                    {
                     before(grammarAccess.getConstraintAccess().getNotEmptyKeyword_0()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getConstraintAccess().getNotEmptyKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1177:2: ( 'NotNull' )
                    {
                    // InternalAceGen.g:1177:2: ( 'NotNull' )
                    // InternalAceGen.g:1178:3: 'NotNull'
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
    // InternalAceGen.g:1187:1: rule__Value__Alternatives : ( ( ( rule__Value__StringValueAssignment_0 ) ) | ( ( rule__Value__IntValueAssignment_1 ) ) | ( ( rule__Value__Group_2__0 ) ) | ( ( rule__Value__AttributeDefinitionListAssignment_3 ) ) | ( ( rule__Value__ListAttributeDefinitionListAssignment_4 ) ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1191:1: ( ( ( rule__Value__StringValueAssignment_0 ) ) | ( ( rule__Value__IntValueAssignment_1 ) ) | ( ( rule__Value__Group_2__0 ) ) | ( ( rule__Value__AttributeDefinitionListAssignment_3 ) ) | ( ( rule__Value__ListAttributeDefinitionListAssignment_4 ) ) )
            int alt9=5;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==RULE_STRING) ) {
                    alt9=3;
                }
                else if ( (LA9_1==EOF||LA9_1==RULE_ID||LA9_1==43) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt9=2;
                }
                break;
            case 42:
                {
                alt9=4;
                }
                break;
            case 37:
            case 61:
                {
                alt9=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalAceGen.g:1192:2: ( ( rule__Value__StringValueAssignment_0 ) )
                    {
                    // InternalAceGen.g:1192:2: ( ( rule__Value__StringValueAssignment_0 ) )
                    // InternalAceGen.g:1193:3: ( rule__Value__StringValueAssignment_0 )
                    {
                     before(grammarAccess.getValueAccess().getStringValueAssignment_0()); 
                    // InternalAceGen.g:1194:3: ( rule__Value__StringValueAssignment_0 )
                    // InternalAceGen.g:1194:4: rule__Value__StringValueAssignment_0
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
                    // InternalAceGen.g:1198:2: ( ( rule__Value__IntValueAssignment_1 ) )
                    {
                    // InternalAceGen.g:1198:2: ( ( rule__Value__IntValueAssignment_1 ) )
                    // InternalAceGen.g:1199:3: ( rule__Value__IntValueAssignment_1 )
                    {
                     before(grammarAccess.getValueAccess().getIntValueAssignment_1()); 
                    // InternalAceGen.g:1200:3: ( rule__Value__IntValueAssignment_1 )
                    // InternalAceGen.g:1200:4: rule__Value__IntValueAssignment_1
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
                    // InternalAceGen.g:1204:2: ( ( rule__Value__Group_2__0 ) )
                    {
                    // InternalAceGen.g:1204:2: ( ( rule__Value__Group_2__0 ) )
                    // InternalAceGen.g:1205:3: ( rule__Value__Group_2__0 )
                    {
                     before(grammarAccess.getValueAccess().getGroup_2()); 
                    // InternalAceGen.g:1206:3: ( rule__Value__Group_2__0 )
                    // InternalAceGen.g:1206:4: rule__Value__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAceGen.g:1210:2: ( ( rule__Value__AttributeDefinitionListAssignment_3 ) )
                    {
                    // InternalAceGen.g:1210:2: ( ( rule__Value__AttributeDefinitionListAssignment_3 ) )
                    // InternalAceGen.g:1211:3: ( rule__Value__AttributeDefinitionListAssignment_3 )
                    {
                     before(grammarAccess.getValueAccess().getAttributeDefinitionListAssignment_3()); 
                    // InternalAceGen.g:1212:3: ( rule__Value__AttributeDefinitionListAssignment_3 )
                    // InternalAceGen.g:1212:4: rule__Value__AttributeDefinitionListAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__AttributeDefinitionListAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getAttributeDefinitionListAssignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalAceGen.g:1216:2: ( ( rule__Value__ListAttributeDefinitionListAssignment_4 ) )
                    {
                    // InternalAceGen.g:1216:2: ( ( rule__Value__ListAttributeDefinitionListAssignment_4 ) )
                    // InternalAceGen.g:1217:3: ( rule__Value__ListAttributeDefinitionListAssignment_4 )
                    {
                     before(grammarAccess.getValueAccess().getListAttributeDefinitionListAssignment_4()); 
                    // InternalAceGen.g:1218:3: ( rule__Value__ListAttributeDefinitionListAssignment_4 )
                    // InternalAceGen.g:1218:4: rule__Value__ListAttributeDefinitionListAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Value__ListAttributeDefinitionListAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueAccess().getListAttributeDefinitionListAssignment_4()); 

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


    // $ANTLR start "rule__PrimitiveValue__Alternatives"
    // InternalAceGen.g:1226:1: rule__PrimitiveValue__Alternatives : ( ( ( rule__PrimitiveValue__StringValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__IntValueAssignment_1 ) ) );
    public final void rule__PrimitiveValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1230:1: ( ( ( rule__PrimitiveValue__StringValueAssignment_0 ) ) | ( ( rule__PrimitiveValue__IntValueAssignment_1 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_STRING) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_INT) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalAceGen.g:1231:2: ( ( rule__PrimitiveValue__StringValueAssignment_0 ) )
                    {
                    // InternalAceGen.g:1231:2: ( ( rule__PrimitiveValue__StringValueAssignment_0 ) )
                    // InternalAceGen.g:1232:3: ( rule__PrimitiveValue__StringValueAssignment_0 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getStringValueAssignment_0()); 
                    // InternalAceGen.g:1233:3: ( rule__PrimitiveValue__StringValueAssignment_0 )
                    // InternalAceGen.g:1233:4: rule__PrimitiveValue__StringValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveValue__StringValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveValueAccess().getStringValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1237:2: ( ( rule__PrimitiveValue__IntValueAssignment_1 ) )
                    {
                    // InternalAceGen.g:1237:2: ( ( rule__PrimitiveValue__IntValueAssignment_1 ) )
                    // InternalAceGen.g:1238:3: ( rule__PrimitiveValue__IntValueAssignment_1 )
                    {
                     before(grammarAccess.getPrimitiveValueAccess().getIntValueAssignment_1()); 
                    // InternalAceGen.g:1239:3: ( rule__PrimitiveValue__IntValueAssignment_1 )
                    // InternalAceGen.g:1239:4: rule__PrimitiveValue__IntValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimitiveValue__IntValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimitiveValueAccess().getIntValueAssignment_1()); 

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
    // $ANTLR end "rule__PrimitiveValue__Alternatives"


    // $ANTLR start "rule__Project__Group__0"
    // InternalAceGen.g:1247:1: rule__Project__Group__0 : rule__Project__Group__0__Impl rule__Project__Group__1 ;
    public final void rule__Project__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1251:1: ( rule__Project__Group__0__Impl rule__Project__Group__1 )
            // InternalAceGen.g:1252:2: rule__Project__Group__0__Impl rule__Project__Group__1
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
    // InternalAceGen.g:1259:1: rule__Project__Group__0__Impl : ( () ) ;
    public final void rule__Project__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1263:1: ( ( () ) )
            // InternalAceGen.g:1264:1: ( () )
            {
            // InternalAceGen.g:1264:1: ( () )
            // InternalAceGen.g:1265:2: ()
            {
             before(grammarAccess.getProjectAccess().getProjectAction_0()); 
            // InternalAceGen.g:1266:2: ()
            // InternalAceGen.g:1266:3: 
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
    // InternalAceGen.g:1274:1: rule__Project__Group__1 : rule__Project__Group__1__Impl ;
    public final void rule__Project__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1278:1: ( rule__Project__Group__1__Impl )
            // InternalAceGen.g:1279:2: rule__Project__Group__1__Impl
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
    // InternalAceGen.g:1285:1: rule__Project__Group__1__Impl : ( ( rule__Project__Alternatives_1 )? ) ;
    public final void rule__Project__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1289:1: ( ( ( rule__Project__Alternatives_1 )? ) )
            // InternalAceGen.g:1290:1: ( ( rule__Project__Alternatives_1 )? )
            {
            // InternalAceGen.g:1290:1: ( ( rule__Project__Alternatives_1 )? )
            // InternalAceGen.g:1291:2: ( rule__Project__Alternatives_1 )?
            {
             before(grammarAccess.getProjectAccess().getAlternatives_1()); 
            // InternalAceGen.g:1292:2: ( rule__Project__Alternatives_1 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=27 && LA11_0<=28)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAceGen.g:1292:3: rule__Project__Alternatives_1
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
    // InternalAceGen.g:1301:1: rule__Project__Group_1_0__0 : rule__Project__Group_1_0__0__Impl rule__Project__Group_1_0__1 ;
    public final void rule__Project__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1305:1: ( rule__Project__Group_1_0__0__Impl rule__Project__Group_1_0__1 )
            // InternalAceGen.g:1306:2: rule__Project__Group_1_0__0__Impl rule__Project__Group_1_0__1
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
    // InternalAceGen.g:1313:1: rule__Project__Group_1_0__0__Impl : ( 'HttpClient' ) ;
    public final void rule__Project__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1317:1: ( ( 'HttpClient' ) )
            // InternalAceGen.g:1318:1: ( 'HttpClient' )
            {
            // InternalAceGen.g:1318:1: ( 'HttpClient' )
            // InternalAceGen.g:1319:2: 'HttpClient'
            {
             before(grammarAccess.getProjectAccess().getHttpClientKeyword_1_0_0()); 
            match(input,27,FOLLOW_2); 
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
    // InternalAceGen.g:1328:1: rule__Project__Group_1_0__1 : rule__Project__Group_1_0__1__Impl ;
    public final void rule__Project__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1332:1: ( rule__Project__Group_1_0__1__Impl )
            // InternalAceGen.g:1333:2: rule__Project__Group_1_0__1__Impl
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
    // InternalAceGen.g:1339:1: rule__Project__Group_1_0__1__Impl : ( ( rule__Project__HttpClientAssignment_1_0_1 )? ) ;
    public final void rule__Project__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1343:1: ( ( ( rule__Project__HttpClientAssignment_1_0_1 )? ) )
            // InternalAceGen.g:1344:1: ( ( rule__Project__HttpClientAssignment_1_0_1 )? )
            {
            // InternalAceGen.g:1344:1: ( ( rule__Project__HttpClientAssignment_1_0_1 )? )
            // InternalAceGen.g:1345:2: ( rule__Project__HttpClientAssignment_1_0_1 )?
            {
             before(grammarAccess.getProjectAccess().getHttpClientAssignment_1_0_1()); 
            // InternalAceGen.g:1346:2: ( rule__Project__HttpClientAssignment_1_0_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalAceGen.g:1346:3: rule__Project__HttpClientAssignment_1_0_1
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
    // InternalAceGen.g:1355:1: rule__Project__Group_1_1__0 : rule__Project__Group_1_1__0__Impl rule__Project__Group_1_1__1 ;
    public final void rule__Project__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1359:1: ( rule__Project__Group_1_1__0__Impl rule__Project__Group_1_1__1 )
            // InternalAceGen.g:1360:2: rule__Project__Group_1_1__0__Impl rule__Project__Group_1_1__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalAceGen.g:1367:1: rule__Project__Group_1_1__0__Impl : ( 'HttpServer' ) ;
    public final void rule__Project__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1371:1: ( ( 'HttpServer' ) )
            // InternalAceGen.g:1372:1: ( 'HttpServer' )
            {
            // InternalAceGen.g:1372:1: ( 'HttpServer' )
            // InternalAceGen.g:1373:2: 'HttpServer'
            {
             before(grammarAccess.getProjectAccess().getHttpServerKeyword_1_1_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalAceGen.g:1382:1: rule__Project__Group_1_1__1 : rule__Project__Group_1_1__1__Impl ;
    public final void rule__Project__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1386:1: ( rule__Project__Group_1_1__1__Impl )
            // InternalAceGen.g:1387:2: rule__Project__Group_1_1__1__Impl
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
    // InternalAceGen.g:1393:1: rule__Project__Group_1_1__1__Impl : ( ( rule__Project__HttpServerAssignment_1_1_1 )? ) ;
    public final void rule__Project__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1397:1: ( ( ( rule__Project__HttpServerAssignment_1_1_1 )? ) )
            // InternalAceGen.g:1398:1: ( ( rule__Project__HttpServerAssignment_1_1_1 )? )
            {
            // InternalAceGen.g:1398:1: ( ( rule__Project__HttpServerAssignment_1_1_1 )? )
            // InternalAceGen.g:1399:2: ( rule__Project__HttpServerAssignment_1_1_1 )?
            {
             before(grammarAccess.getProjectAccess().getHttpServerAssignment_1_1_1()); 
            // InternalAceGen.g:1400:2: ( rule__Project__HttpServerAssignment_1_1_1 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalAceGen.g:1400:3: rule__Project__HttpServerAssignment_1_1_1
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
    // InternalAceGen.g:1409:1: rule__HttpClient__Group__0 : rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1 ;
    public final void rule__HttpClient__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1413:1: ( rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1 )
            // InternalAceGen.g:1414:2: rule__HttpClient__Group__0__Impl rule__HttpClient__Group__1
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
    // InternalAceGen.g:1421:1: rule__HttpClient__Group__0__Impl : ( ( rule__HttpClient__NameAssignment_0 ) ) ;
    public final void rule__HttpClient__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1425:1: ( ( ( rule__HttpClient__NameAssignment_0 ) ) )
            // InternalAceGen.g:1426:1: ( ( rule__HttpClient__NameAssignment_0 ) )
            {
            // InternalAceGen.g:1426:1: ( ( rule__HttpClient__NameAssignment_0 ) )
            // InternalAceGen.g:1427:2: ( rule__HttpClient__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientAccess().getNameAssignment_0()); 
            // InternalAceGen.g:1428:2: ( rule__HttpClient__NameAssignment_0 )
            // InternalAceGen.g:1428:3: rule__HttpClient__NameAssignment_0
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
    // InternalAceGen.g:1436:1: rule__HttpClient__Group__1 : rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2 ;
    public final void rule__HttpClient__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1440:1: ( rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2 )
            // InternalAceGen.g:1441:2: rule__HttpClient__Group__1__Impl rule__HttpClient__Group__2
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
    // InternalAceGen.g:1448:1: rule__HttpClient__Group__1__Impl : ( ( rule__HttpClient__Group_1__0 )? ) ;
    public final void rule__HttpClient__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1452:1: ( ( ( rule__HttpClient__Group_1__0 )? ) )
            // InternalAceGen.g:1453:1: ( ( rule__HttpClient__Group_1__0 )? )
            {
            // InternalAceGen.g:1453:1: ( ( rule__HttpClient__Group_1__0 )? )
            // InternalAceGen.g:1454:2: ( rule__HttpClient__Group_1__0 )?
            {
             before(grammarAccess.getHttpClientAccess().getGroup_1()); 
            // InternalAceGen.g:1455:2: ( rule__HttpClient__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==29) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalAceGen.g:1455:3: rule__HttpClient__Group_1__0
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
    // InternalAceGen.g:1463:1: rule__HttpClient__Group__2 : rule__HttpClient__Group__2__Impl ;
    public final void rule__HttpClient__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1467:1: ( rule__HttpClient__Group__2__Impl )
            // InternalAceGen.g:1468:2: rule__HttpClient__Group__2__Impl
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
    // InternalAceGen.g:1474:1: rule__HttpClient__Group__2__Impl : ( ( rule__HttpClient__Group_2__0 )? ) ;
    public final void rule__HttpClient__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1478:1: ( ( ( rule__HttpClient__Group_2__0 )? ) )
            // InternalAceGen.g:1479:1: ( ( rule__HttpClient__Group_2__0 )? )
            {
            // InternalAceGen.g:1479:1: ( ( rule__HttpClient__Group_2__0 )? )
            // InternalAceGen.g:1480:2: ( rule__HttpClient__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientAccess().getGroup_2()); 
            // InternalAceGen.g:1481:2: ( rule__HttpClient__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==30) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalAceGen.g:1481:3: rule__HttpClient__Group_2__0
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
    // InternalAceGen.g:1490:1: rule__HttpClient__Group_1__0 : rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1 ;
    public final void rule__HttpClient__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1494:1: ( rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1 )
            // InternalAceGen.g:1495:2: rule__HttpClient__Group_1__0__Impl rule__HttpClient__Group_1__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalAceGen.g:1502:1: rule__HttpClient__Group_1__0__Impl : ( 'ACE' ) ;
    public final void rule__HttpClient__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1506:1: ( ( 'ACE' ) )
            // InternalAceGen.g:1507:1: ( 'ACE' )
            {
            // InternalAceGen.g:1507:1: ( 'ACE' )
            // InternalAceGen.g:1508:2: 'ACE'
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
    // InternalAceGen.g:1517:1: rule__HttpClient__Group_1__1 : rule__HttpClient__Group_1__1__Impl ;
    public final void rule__HttpClient__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1521:1: ( rule__HttpClient__Group_1__1__Impl )
            // InternalAceGen.g:1522:2: rule__HttpClient__Group_1__1__Impl
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
    // InternalAceGen.g:1528:1: rule__HttpClient__Group_1__1__Impl : ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* ) ;
    public final void rule__HttpClient__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1532:1: ( ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* ) )
            // InternalAceGen.g:1533:1: ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* )
            {
            // InternalAceGen.g:1533:1: ( ( rule__HttpClient__AceOperationsAssignment_1_1 )* )
            // InternalAceGen.g:1534:2: ( rule__HttpClient__AceOperationsAssignment_1_1 )*
            {
             before(grammarAccess.getHttpClientAccess().getAceOperationsAssignment_1_1()); 
            // InternalAceGen.g:1535:2: ( rule__HttpClient__AceOperationsAssignment_1_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID||LA16_0==65) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalAceGen.g:1535:3: rule__HttpClient__AceOperationsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__HttpClient__AceOperationsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalAceGen.g:1544:1: rule__HttpClient__Group_2__0 : rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1 ;
    public final void rule__HttpClient__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1548:1: ( rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1 )
            // InternalAceGen.g:1549:2: rule__HttpClient__Group_2__0__Impl rule__HttpClient__Group_2__1
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
    // InternalAceGen.g:1556:1: rule__HttpClient__Group_2__0__Impl : ( 'appState' ) ;
    public final void rule__HttpClient__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1560:1: ( ( 'appState' ) )
            // InternalAceGen.g:1561:1: ( 'appState' )
            {
            // InternalAceGen.g:1561:1: ( 'appState' )
            // InternalAceGen.g:1562:2: 'appState'
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
    // InternalAceGen.g:1571:1: rule__HttpClient__Group_2__1 : rule__HttpClient__Group_2__1__Impl ;
    public final void rule__HttpClient__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1575:1: ( rule__HttpClient__Group_2__1__Impl )
            // InternalAceGen.g:1576:2: rule__HttpClient__Group_2__1__Impl
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
    // InternalAceGen.g:1582:1: rule__HttpClient__Group_2__1__Impl : ( ( rule__HttpClient__AppStateAssignment_2_1 ) ) ;
    public final void rule__HttpClient__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1586:1: ( ( ( rule__HttpClient__AppStateAssignment_2_1 ) ) )
            // InternalAceGen.g:1587:1: ( ( rule__HttpClient__AppStateAssignment_2_1 ) )
            {
            // InternalAceGen.g:1587:1: ( ( rule__HttpClient__AppStateAssignment_2_1 ) )
            // InternalAceGen.g:1588:2: ( rule__HttpClient__AppStateAssignment_2_1 )
            {
             before(grammarAccess.getHttpClientAccess().getAppStateAssignment_2_1()); 
            // InternalAceGen.g:1589:2: ( rule__HttpClient__AppStateAssignment_2_1 )
            // InternalAceGen.g:1589:3: rule__HttpClient__AppStateAssignment_2_1
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
    // InternalAceGen.g:1598:1: rule__HttpClientAce__Group__0 : rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1 ;
    public final void rule__HttpClientAce__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1602:1: ( rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1 )
            // InternalAceGen.g:1603:2: rule__HttpClientAce__Group__0__Impl rule__HttpClientAce__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalAceGen.g:1610:1: rule__HttpClientAce__Group__0__Impl : ( ( rule__HttpClientAce__AsyncAssignment_0 )? ) ;
    public final void rule__HttpClientAce__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1614:1: ( ( ( rule__HttpClientAce__AsyncAssignment_0 )? ) )
            // InternalAceGen.g:1615:1: ( ( rule__HttpClientAce__AsyncAssignment_0 )? )
            {
            // InternalAceGen.g:1615:1: ( ( rule__HttpClientAce__AsyncAssignment_0 )? )
            // InternalAceGen.g:1616:2: ( rule__HttpClientAce__AsyncAssignment_0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getAsyncAssignment_0()); 
            // InternalAceGen.g:1617:2: ( rule__HttpClientAce__AsyncAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==65) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAceGen.g:1617:3: rule__HttpClientAce__AsyncAssignment_0
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
    // InternalAceGen.g:1625:1: rule__HttpClientAce__Group__1 : rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2 ;
    public final void rule__HttpClientAce__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1629:1: ( rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2 )
            // InternalAceGen.g:1630:2: rule__HttpClientAce__Group__1__Impl rule__HttpClientAce__Group__2
            {
            pushFollow(FOLLOW_8);
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
    // InternalAceGen.g:1637:1: rule__HttpClientAce__Group__1__Impl : ( ( rule__HttpClientAce__NameAssignment_1 ) ) ;
    public final void rule__HttpClientAce__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1641:1: ( ( ( rule__HttpClientAce__NameAssignment_1 ) ) )
            // InternalAceGen.g:1642:1: ( ( rule__HttpClientAce__NameAssignment_1 ) )
            {
            // InternalAceGen.g:1642:1: ( ( rule__HttpClientAce__NameAssignment_1 ) )
            // InternalAceGen.g:1643:2: ( rule__HttpClientAce__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getNameAssignment_1()); 
            // InternalAceGen.g:1644:2: ( rule__HttpClientAce__NameAssignment_1 )
            // InternalAceGen.g:1644:3: rule__HttpClientAce__NameAssignment_1
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
    // InternalAceGen.g:1652:1: rule__HttpClientAce__Group__2 : rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3 ;
    public final void rule__HttpClientAce__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1656:1: ( rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3 )
            // InternalAceGen.g:1657:2: rule__HttpClientAce__Group__2__Impl rule__HttpClientAce__Group__3
            {
            pushFollow(FOLLOW_8);
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
    // InternalAceGen.g:1664:1: rule__HttpClientAce__Group__2__Impl : ( ( rule__HttpClientAce__Group_2__0 )? ) ;
    public final void rule__HttpClientAce__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1668:1: ( ( ( rule__HttpClientAce__Group_2__0 )? ) )
            // InternalAceGen.g:1669:1: ( ( rule__HttpClientAce__Group_2__0 )? )
            {
            // InternalAceGen.g:1669:1: ( ( rule__HttpClientAce__Group_2__0 )? )
            // InternalAceGen.g:1670:2: ( rule__HttpClientAce__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_2()); 
            // InternalAceGen.g:1671:2: ( rule__HttpClientAce__Group_2__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==31) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAceGen.g:1671:3: rule__HttpClientAce__Group_2__0
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
    // InternalAceGen.g:1679:1: rule__HttpClientAce__Group__3 : rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4 ;
    public final void rule__HttpClientAce__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1683:1: ( rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4 )
            // InternalAceGen.g:1684:2: rule__HttpClientAce__Group__3__Impl rule__HttpClientAce__Group__4
            {
            pushFollow(FOLLOW_8);
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
    // InternalAceGen.g:1691:1: rule__HttpClientAce__Group__3__Impl : ( ( rule__HttpClientAce__Group_3__0 )? ) ;
    public final void rule__HttpClientAce__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1695:1: ( ( ( rule__HttpClientAce__Group_3__0 )? ) )
            // InternalAceGen.g:1696:1: ( ( rule__HttpClientAce__Group_3__0 )? )
            {
            // InternalAceGen.g:1696:1: ( ( rule__HttpClientAce__Group_3__0 )? )
            // InternalAceGen.g:1697:2: ( rule__HttpClientAce__Group_3__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_3()); 
            // InternalAceGen.g:1698:2: ( rule__HttpClientAce__Group_3__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==34) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAceGen.g:1698:3: rule__HttpClientAce__Group_3__0
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
    // InternalAceGen.g:1706:1: rule__HttpClientAce__Group__4 : rule__HttpClientAce__Group__4__Impl rule__HttpClientAce__Group__5 ;
    public final void rule__HttpClientAce__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1710:1: ( rule__HttpClientAce__Group__4__Impl rule__HttpClientAce__Group__5 )
            // InternalAceGen.g:1711:2: rule__HttpClientAce__Group__4__Impl rule__HttpClientAce__Group__5
            {
            pushFollow(FOLLOW_8);
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
    // InternalAceGen.g:1718:1: rule__HttpClientAce__Group__4__Impl : ( ( rule__HttpClientAce__Group_4__0 )? ) ;
    public final void rule__HttpClientAce__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1722:1: ( ( ( rule__HttpClientAce__Group_4__0 )? ) )
            // InternalAceGen.g:1723:1: ( ( rule__HttpClientAce__Group_4__0 )? )
            {
            // InternalAceGen.g:1723:1: ( ( rule__HttpClientAce__Group_4__0 )? )
            // InternalAceGen.g:1724:2: ( rule__HttpClientAce__Group_4__0 )?
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_4()); 
            // InternalAceGen.g:1725:2: ( rule__HttpClientAce__Group_4__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==35) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalAceGen.g:1725:3: rule__HttpClientAce__Group_4__0
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
    // InternalAceGen.g:1733:1: rule__HttpClientAce__Group__5 : rule__HttpClientAce__Group__5__Impl ;
    public final void rule__HttpClientAce__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1737:1: ( rule__HttpClientAce__Group__5__Impl )
            // InternalAceGen.g:1738:2: rule__HttpClientAce__Group__5__Impl
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
    // InternalAceGen.g:1744:1: rule__HttpClientAce__Group__5__Impl : ( ( rule__HttpClientAce__OutcomesAssignment_5 )* ) ;
    public final void rule__HttpClientAce__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1748:1: ( ( ( rule__HttpClientAce__OutcomesAssignment_5 )* ) )
            // InternalAceGen.g:1749:1: ( ( rule__HttpClientAce__OutcomesAssignment_5 )* )
            {
            // InternalAceGen.g:1749:1: ( ( rule__HttpClientAce__OutcomesAssignment_5 )* )
            // InternalAceGen.g:1750:2: ( rule__HttpClientAce__OutcomesAssignment_5 )*
            {
             before(grammarAccess.getHttpClientAceAccess().getOutcomesAssignment_5()); 
            // InternalAceGen.g:1751:2: ( rule__HttpClientAce__OutcomesAssignment_5 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==36) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalAceGen.g:1751:3: rule__HttpClientAce__OutcomesAssignment_5
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__HttpClientAce__OutcomesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalAceGen.g:1760:1: rule__HttpClientAce__Group_2__0 : rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1 ;
    public final void rule__HttpClientAce__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1764:1: ( rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1 )
            // InternalAceGen.g:1765:2: rule__HttpClientAce__Group_2__0__Impl rule__HttpClientAce__Group_2__1
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
    // InternalAceGen.g:1772:1: rule__HttpClientAce__Group_2__0__Impl : ( '<' ) ;
    public final void rule__HttpClientAce__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1776:1: ( ( '<' ) )
            // InternalAceGen.g:1777:1: ( '<' )
            {
            // InternalAceGen.g:1777:1: ( '<' )
            // InternalAceGen.g:1778:2: '<'
            {
             before(grammarAccess.getHttpClientAceAccess().getLessThanSignKeyword_2_0()); 
            match(input,31,FOLLOW_2); 
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
    // InternalAceGen.g:1787:1: rule__HttpClientAce__Group_2__1 : rule__HttpClientAce__Group_2__1__Impl rule__HttpClientAce__Group_2__2 ;
    public final void rule__HttpClientAce__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1791:1: ( rule__HttpClientAce__Group_2__1__Impl rule__HttpClientAce__Group_2__2 )
            // InternalAceGen.g:1792:2: rule__HttpClientAce__Group_2__1__Impl rule__HttpClientAce__Group_2__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalAceGen.g:1799:1: rule__HttpClientAce__Group_2__1__Impl : ( ( rule__HttpClientAce__InputAssignment_2_1 ) ) ;
    public final void rule__HttpClientAce__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1803:1: ( ( ( rule__HttpClientAce__InputAssignment_2_1 ) ) )
            // InternalAceGen.g:1804:1: ( ( rule__HttpClientAce__InputAssignment_2_1 ) )
            {
            // InternalAceGen.g:1804:1: ( ( rule__HttpClientAce__InputAssignment_2_1 ) )
            // InternalAceGen.g:1805:2: ( rule__HttpClientAce__InputAssignment_2_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getInputAssignment_2_1()); 
            // InternalAceGen.g:1806:2: ( rule__HttpClientAce__InputAssignment_2_1 )
            // InternalAceGen.g:1806:3: rule__HttpClientAce__InputAssignment_2_1
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
    // InternalAceGen.g:1814:1: rule__HttpClientAce__Group_2__2 : rule__HttpClientAce__Group_2__2__Impl rule__HttpClientAce__Group_2__3 ;
    public final void rule__HttpClientAce__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1818:1: ( rule__HttpClientAce__Group_2__2__Impl rule__HttpClientAce__Group_2__3 )
            // InternalAceGen.g:1819:2: rule__HttpClientAce__Group_2__2__Impl rule__HttpClientAce__Group_2__3
            {
            pushFollow(FOLLOW_10);
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
    // InternalAceGen.g:1826:1: rule__HttpClientAce__Group_2__2__Impl : ( ( rule__HttpClientAce__Group_2_2__0 )* ) ;
    public final void rule__HttpClientAce__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1830:1: ( ( ( rule__HttpClientAce__Group_2_2__0 )* ) )
            // InternalAceGen.g:1831:1: ( ( rule__HttpClientAce__Group_2_2__0 )* )
            {
            // InternalAceGen.g:1831:1: ( ( rule__HttpClientAce__Group_2_2__0 )* )
            // InternalAceGen.g:1832:2: ( rule__HttpClientAce__Group_2_2__0 )*
            {
             before(grammarAccess.getHttpClientAceAccess().getGroup_2_2()); 
            // InternalAceGen.g:1833:2: ( rule__HttpClientAce__Group_2_2__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==33) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalAceGen.g:1833:3: rule__HttpClientAce__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__HttpClientAce__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalAceGen.g:1841:1: rule__HttpClientAce__Group_2__3 : rule__HttpClientAce__Group_2__3__Impl ;
    public final void rule__HttpClientAce__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1845:1: ( rule__HttpClientAce__Group_2__3__Impl )
            // InternalAceGen.g:1846:2: rule__HttpClientAce__Group_2__3__Impl
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
    // InternalAceGen.g:1852:1: rule__HttpClientAce__Group_2__3__Impl : ( '>' ) ;
    public final void rule__HttpClientAce__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1856:1: ( ( '>' ) )
            // InternalAceGen.g:1857:1: ( '>' )
            {
            // InternalAceGen.g:1857:1: ( '>' )
            // InternalAceGen.g:1858:2: '>'
            {
             before(grammarAccess.getHttpClientAceAccess().getGreaterThanSignKeyword_2_3()); 
            match(input,32,FOLLOW_2); 
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
    // InternalAceGen.g:1868:1: rule__HttpClientAce__Group_2_2__0 : rule__HttpClientAce__Group_2_2__0__Impl rule__HttpClientAce__Group_2_2__1 ;
    public final void rule__HttpClientAce__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1872:1: ( rule__HttpClientAce__Group_2_2__0__Impl rule__HttpClientAce__Group_2_2__1 )
            // InternalAceGen.g:1873:2: rule__HttpClientAce__Group_2_2__0__Impl rule__HttpClientAce__Group_2_2__1
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
    // InternalAceGen.g:1880:1: rule__HttpClientAce__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__HttpClientAce__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1884:1: ( ( ',' ) )
            // InternalAceGen.g:1885:1: ( ',' )
            {
            // InternalAceGen.g:1885:1: ( ',' )
            // InternalAceGen.g:1886:2: ','
            {
             before(grammarAccess.getHttpClientAceAccess().getCommaKeyword_2_2_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalAceGen.g:1895:1: rule__HttpClientAce__Group_2_2__1 : rule__HttpClientAce__Group_2_2__1__Impl ;
    public final void rule__HttpClientAce__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1899:1: ( rule__HttpClientAce__Group_2_2__1__Impl )
            // InternalAceGen.g:1900:2: rule__HttpClientAce__Group_2_2__1__Impl
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
    // InternalAceGen.g:1906:1: rule__HttpClientAce__Group_2_2__1__Impl : ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) ) ;
    public final void rule__HttpClientAce__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1910:1: ( ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) ) )
            // InternalAceGen.g:1911:1: ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) )
            {
            // InternalAceGen.g:1911:1: ( ( rule__HttpClientAce__InputAssignment_2_2_1 ) )
            // InternalAceGen.g:1912:2: ( rule__HttpClientAce__InputAssignment_2_2_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getInputAssignment_2_2_1()); 
            // InternalAceGen.g:1913:2: ( rule__HttpClientAce__InputAssignment_2_2_1 )
            // InternalAceGen.g:1913:3: rule__HttpClientAce__InputAssignment_2_2_1
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
    // InternalAceGen.g:1922:1: rule__HttpClientAce__Group_3__0 : rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1 ;
    public final void rule__HttpClientAce__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1926:1: ( rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1 )
            // InternalAceGen.g:1927:2: rule__HttpClientAce__Group_3__0__Impl rule__HttpClientAce__Group_3__1
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
    // InternalAceGen.g:1934:1: rule__HttpClientAce__Group_3__0__Impl : ( 'call' ) ;
    public final void rule__HttpClientAce__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1938:1: ( ( 'call' ) )
            // InternalAceGen.g:1939:1: ( 'call' )
            {
            // InternalAceGen.g:1939:1: ( 'call' )
            // InternalAceGen.g:1940:2: 'call'
            {
             before(grammarAccess.getHttpClientAceAccess().getCallKeyword_3_0()); 
            match(input,34,FOLLOW_2); 
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
    // InternalAceGen.g:1949:1: rule__HttpClientAce__Group_3__1 : rule__HttpClientAce__Group_3__1__Impl ;
    public final void rule__HttpClientAce__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1953:1: ( rule__HttpClientAce__Group_3__1__Impl )
            // InternalAceGen.g:1954:2: rule__HttpClientAce__Group_3__1__Impl
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
    // InternalAceGen.g:1960:1: rule__HttpClientAce__Group_3__1__Impl : ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) ) ;
    public final void rule__HttpClientAce__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1964:1: ( ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) ) )
            // InternalAceGen.g:1965:1: ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) )
            {
            // InternalAceGen.g:1965:1: ( ( rule__HttpClientAce__ServerCallAssignment_3_1 ) )
            // InternalAceGen.g:1966:2: ( rule__HttpClientAce__ServerCallAssignment_3_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallAssignment_3_1()); 
            // InternalAceGen.g:1967:2: ( rule__HttpClientAce__ServerCallAssignment_3_1 )
            // InternalAceGen.g:1967:3: rule__HttpClientAce__ServerCallAssignment_3_1
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
    // InternalAceGen.g:1976:1: rule__HttpClientAce__Group_4__0 : rule__HttpClientAce__Group_4__0__Impl rule__HttpClientAce__Group_4__1 ;
    public final void rule__HttpClientAce__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1980:1: ( rule__HttpClientAce__Group_4__0__Impl rule__HttpClientAce__Group_4__1 )
            // InternalAceGen.g:1981:2: rule__HttpClientAce__Group_4__0__Impl rule__HttpClientAce__Group_4__1
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
    // InternalAceGen.g:1988:1: rule__HttpClientAce__Group_4__0__Impl : ( 'loadingFlag' ) ;
    public final void rule__HttpClientAce__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:1992:1: ( ( 'loadingFlag' ) )
            // InternalAceGen.g:1993:1: ( 'loadingFlag' )
            {
            // InternalAceGen.g:1993:1: ( 'loadingFlag' )
            // InternalAceGen.g:1994:2: 'loadingFlag'
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagKeyword_4_0()); 
            match(input,35,FOLLOW_2); 
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
    // InternalAceGen.g:2003:1: rule__HttpClientAce__Group_4__1 : rule__HttpClientAce__Group_4__1__Impl ;
    public final void rule__HttpClientAce__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2007:1: ( rule__HttpClientAce__Group_4__1__Impl )
            // InternalAceGen.g:2008:2: rule__HttpClientAce__Group_4__1__Impl
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
    // InternalAceGen.g:2014:1: rule__HttpClientAce__Group_4__1__Impl : ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) ) ;
    public final void rule__HttpClientAce__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2018:1: ( ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) ) )
            // InternalAceGen.g:2019:1: ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) )
            {
            // InternalAceGen.g:2019:1: ( ( rule__HttpClientAce__LoadingFlagAssignment_4_1 ) )
            // InternalAceGen.g:2020:2: ( rule__HttpClientAce__LoadingFlagAssignment_4_1 )
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagAssignment_4_1()); 
            // InternalAceGen.g:2021:2: ( rule__HttpClientAce__LoadingFlagAssignment_4_1 )
            // InternalAceGen.g:2021:3: rule__HttpClientAce__LoadingFlagAssignment_4_1
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
    // InternalAceGen.g:2030:1: rule__HttpClientOutcome__Group__0 : rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1 ;
    public final void rule__HttpClientOutcome__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2034:1: ( rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1 )
            // InternalAceGen.g:2035:2: rule__HttpClientOutcome__Group__0__Impl rule__HttpClientOutcome__Group__1
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
    // InternalAceGen.g:2042:1: rule__HttpClientOutcome__Group__0__Impl : ( 'on' ) ;
    public final void rule__HttpClientOutcome__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2046:1: ( ( 'on' ) )
            // InternalAceGen.g:2047:1: ( 'on' )
            {
            // InternalAceGen.g:2047:1: ( 'on' )
            // InternalAceGen.g:2048:2: 'on'
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
    // InternalAceGen.g:2057:1: rule__HttpClientOutcome__Group__1 : rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2 ;
    public final void rule__HttpClientOutcome__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2061:1: ( rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2 )
            // InternalAceGen.g:2062:2: rule__HttpClientOutcome__Group__1__Impl rule__HttpClientOutcome__Group__2
            {
            pushFollow(FOLLOW_12);
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
    // InternalAceGen.g:2069:1: rule__HttpClientOutcome__Group__1__Impl : ( ( rule__HttpClientOutcome__NameAssignment_1 ) ) ;
    public final void rule__HttpClientOutcome__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2073:1: ( ( ( rule__HttpClientOutcome__NameAssignment_1 ) ) )
            // InternalAceGen.g:2074:1: ( ( rule__HttpClientOutcome__NameAssignment_1 ) )
            {
            // InternalAceGen.g:2074:1: ( ( rule__HttpClientOutcome__NameAssignment_1 ) )
            // InternalAceGen.g:2075:2: ( rule__HttpClientOutcome__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getNameAssignment_1()); 
            // InternalAceGen.g:2076:2: ( rule__HttpClientOutcome__NameAssignment_1 )
            // InternalAceGen.g:2076:3: rule__HttpClientOutcome__NameAssignment_1
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
    // InternalAceGen.g:2084:1: rule__HttpClientOutcome__Group__2 : rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3 ;
    public final void rule__HttpClientOutcome__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2088:1: ( rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3 )
            // InternalAceGen.g:2089:2: rule__HttpClientOutcome__Group__2__Impl rule__HttpClientOutcome__Group__3
            {
            pushFollow(FOLLOW_12);
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
    // InternalAceGen.g:2096:1: rule__HttpClientOutcome__Group__2__Impl : ( ( rule__HttpClientOutcome__Group_2__0 )? ) ;
    public final void rule__HttpClientOutcome__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2100:1: ( ( ( rule__HttpClientOutcome__Group_2__0 )? ) )
            // InternalAceGen.g:2101:1: ( ( rule__HttpClientOutcome__Group_2__0 )? )
            {
            // InternalAceGen.g:2101:1: ( ( rule__HttpClientOutcome__Group_2__0 )? )
            // InternalAceGen.g:2102:2: ( rule__HttpClientOutcome__Group_2__0 )?
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getGroup_2()); 
            // InternalAceGen.g:2103:2: ( rule__HttpClientOutcome__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==37) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalAceGen.g:2103:3: rule__HttpClientOutcome__Group_2__0
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
    // InternalAceGen.g:2111:1: rule__HttpClientOutcome__Group__3 : rule__HttpClientOutcome__Group__3__Impl ;
    public final void rule__HttpClientOutcome__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2115:1: ( rule__HttpClientOutcome__Group__3__Impl )
            // InternalAceGen.g:2116:2: rule__HttpClientOutcome__Group__3__Impl
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
    // InternalAceGen.g:2122:1: rule__HttpClientOutcome__Group__3__Impl : ( ( rule__HttpClientOutcome__Group_3__0 )? ) ;
    public final void rule__HttpClientOutcome__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2126:1: ( ( ( rule__HttpClientOutcome__Group_3__0 )? ) )
            // InternalAceGen.g:2127:1: ( ( rule__HttpClientOutcome__Group_3__0 )? )
            {
            // InternalAceGen.g:2127:1: ( ( rule__HttpClientOutcome__Group_3__0 )? )
            // InternalAceGen.g:2128:2: ( rule__HttpClientOutcome__Group_3__0 )?
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getGroup_3()); 
            // InternalAceGen.g:2129:2: ( rule__HttpClientOutcome__Group_3__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==39) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalAceGen.g:2129:3: rule__HttpClientOutcome__Group_3__0
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
    // InternalAceGen.g:2138:1: rule__HttpClientOutcome__Group_2__0 : rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1 ;
    public final void rule__HttpClientOutcome__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2142:1: ( rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1 )
            // InternalAceGen.g:2143:2: rule__HttpClientOutcome__Group_2__0__Impl rule__HttpClientOutcome__Group_2__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalAceGen.g:2150:1: rule__HttpClientOutcome__Group_2__0__Impl : ( '(' ) ;
    public final void rule__HttpClientOutcome__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2154:1: ( ( '(' ) )
            // InternalAceGen.g:2155:1: ( '(' )
            {
            // InternalAceGen.g:2155:1: ( '(' )
            // InternalAceGen.g:2156:2: '('
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
    // InternalAceGen.g:2165:1: rule__HttpClientOutcome__Group_2__1 : rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2 ;
    public final void rule__HttpClientOutcome__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2169:1: ( rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2 )
            // InternalAceGen.g:2170:2: rule__HttpClientOutcome__Group_2__1__Impl rule__HttpClientOutcome__Group_2__2
            {
            pushFollow(FOLLOW_13);
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
    // InternalAceGen.g:2177:1: rule__HttpClientOutcome__Group_2__1__Impl : ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* ) ;
    public final void rule__HttpClientOutcome__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2181:1: ( ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* ) )
            // InternalAceGen.g:2182:1: ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* )
            {
            // InternalAceGen.g:2182:1: ( ( rule__HttpClientOutcome__ListenersAssignment_2_1 )* )
            // InternalAceGen.g:2183:2: ( rule__HttpClientOutcome__ListenersAssignment_2_1 )*
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getListenersAssignment_2_1()); 
            // InternalAceGen.g:2184:2: ( rule__HttpClientOutcome__ListenersAssignment_2_1 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=12 && LA25_0<=15)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalAceGen.g:2184:3: rule__HttpClientOutcome__ListenersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__HttpClientOutcome__ListenersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalAceGen.g:2192:1: rule__HttpClientOutcome__Group_2__2 : rule__HttpClientOutcome__Group_2__2__Impl ;
    public final void rule__HttpClientOutcome__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2196:1: ( rule__HttpClientOutcome__Group_2__2__Impl )
            // InternalAceGen.g:2197:2: rule__HttpClientOutcome__Group_2__2__Impl
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
    // InternalAceGen.g:2203:1: rule__HttpClientOutcome__Group_2__2__Impl : ( ')' ) ;
    public final void rule__HttpClientOutcome__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2207:1: ( ( ')' ) )
            // InternalAceGen.g:2208:1: ( ')' )
            {
            // InternalAceGen.g:2208:1: ( ')' )
            // InternalAceGen.g:2209:2: ')'
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
    // InternalAceGen.g:2219:1: rule__HttpClientOutcome__Group_3__0 : rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1 ;
    public final void rule__HttpClientOutcome__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2223:1: ( rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1 )
            // InternalAceGen.g:2224:2: rule__HttpClientOutcome__Group_3__0__Impl rule__HttpClientOutcome__Group_3__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalAceGen.g:2231:1: rule__HttpClientOutcome__Group_3__0__Impl : ( 'triggers' ) ;
    public final void rule__HttpClientOutcome__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2235:1: ( ( 'triggers' ) )
            // InternalAceGen.g:2236:1: ( 'triggers' )
            {
            // InternalAceGen.g:2236:1: ( 'triggers' )
            // InternalAceGen.g:2237:2: 'triggers'
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
    // InternalAceGen.g:2246:1: rule__HttpClientOutcome__Group_3__1 : rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2 ;
    public final void rule__HttpClientOutcome__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2250:1: ( rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2 )
            // InternalAceGen.g:2251:2: rule__HttpClientOutcome__Group_3__1__Impl rule__HttpClientOutcome__Group_3__2
            {
            pushFollow(FOLLOW_16);
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
    // InternalAceGen.g:2258:1: rule__HttpClientOutcome__Group_3__1__Impl : ( '(' ) ;
    public final void rule__HttpClientOutcome__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2262:1: ( ( '(' ) )
            // InternalAceGen.g:2263:1: ( '(' )
            {
            // InternalAceGen.g:2263:1: ( '(' )
            // InternalAceGen.g:2264:2: '('
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
    // InternalAceGen.g:2273:1: rule__HttpClientOutcome__Group_3__2 : rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3 ;
    public final void rule__HttpClientOutcome__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2277:1: ( rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3 )
            // InternalAceGen.g:2278:2: rule__HttpClientOutcome__Group_3__2__Impl rule__HttpClientOutcome__Group_3__3
            {
            pushFollow(FOLLOW_16);
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
    // InternalAceGen.g:2285:1: rule__HttpClientOutcome__Group_3__2__Impl : ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* ) ;
    public final void rule__HttpClientOutcome__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2289:1: ( ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* ) )
            // InternalAceGen.g:2290:1: ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* )
            {
            // InternalAceGen.g:2290:1: ( ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )* )
            // InternalAceGen.g:2291:2: ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )*
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsAssignment_3_2()); 
            // InternalAceGen.g:2292:2: ( rule__HttpClientOutcome__AceOperationsAssignment_3_2 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalAceGen.g:2292:3: rule__HttpClientOutcome__AceOperationsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__HttpClientOutcome__AceOperationsAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalAceGen.g:2300:1: rule__HttpClientOutcome__Group_3__3 : rule__HttpClientOutcome__Group_3__3__Impl ;
    public final void rule__HttpClientOutcome__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2304:1: ( rule__HttpClientOutcome__Group_3__3__Impl )
            // InternalAceGen.g:2305:2: rule__HttpClientOutcome__Group_3__3__Impl
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
    // InternalAceGen.g:2311:1: rule__HttpClientOutcome__Group_3__3__Impl : ( ')' ) ;
    public final void rule__HttpClientOutcome__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2315:1: ( ( ')' ) )
            // InternalAceGen.g:2316:1: ( ')' )
            {
            // InternalAceGen.g:2316:1: ( ')' )
            // InternalAceGen.g:2317:2: ')'
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
    // InternalAceGen.g:2327:1: rule__HttpClientStateFunction__Group__0 : rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1 ;
    public final void rule__HttpClientStateFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2331:1: ( rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1 )
            // InternalAceGen.g:2332:2: rule__HttpClientStateFunction__Group__0__Impl rule__HttpClientStateFunction__Group__1
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
    // InternalAceGen.g:2339:1: rule__HttpClientStateFunction__Group__0__Impl : ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) ) ;
    public final void rule__HttpClientStateFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2343:1: ( ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) ) )
            // InternalAceGen.g:2344:1: ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) )
            {
            // InternalAceGen.g:2344:1: ( ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 ) )
            // InternalAceGen.g:2345:2: ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeAssignment_0()); 
            // InternalAceGen.g:2346:2: ( rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 )
            // InternalAceGen.g:2346:3: rule__HttpClientStateFunction__StateFunctionTypeAssignment_0
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
    // InternalAceGen.g:2354:1: rule__HttpClientStateFunction__Group__1 : rule__HttpClientStateFunction__Group__1__Impl ;
    public final void rule__HttpClientStateFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2358:1: ( rule__HttpClientStateFunction__Group__1__Impl )
            // InternalAceGen.g:2359:2: rule__HttpClientStateFunction__Group__1__Impl
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
    // InternalAceGen.g:2365:1: rule__HttpClientStateFunction__Group__1__Impl : ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) ) ;
    public final void rule__HttpClientStateFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2369:1: ( ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) ) )
            // InternalAceGen.g:2370:1: ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) )
            {
            // InternalAceGen.g:2370:1: ( ( rule__HttpClientStateFunction__AttributeAssignment_1 ) )
            // InternalAceGen.g:2371:2: ( rule__HttpClientStateFunction__AttributeAssignment_1 )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getAttributeAssignment_1()); 
            // InternalAceGen.g:2372:2: ( rule__HttpClientStateFunction__AttributeAssignment_1 )
            // InternalAceGen.g:2372:3: rule__HttpClientStateFunction__AttributeAssignment_1
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
    // InternalAceGen.g:2381:1: rule__HttpClientStateElement__Group__0 : rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1 ;
    public final void rule__HttpClientStateElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2385:1: ( rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1 )
            // InternalAceGen.g:2386:2: rule__HttpClientStateElement__Group__0__Impl rule__HttpClientStateElement__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalAceGen.g:2393:1: rule__HttpClientStateElement__Group__0__Impl : ( ( rule__HttpClientStateElement__NameAssignment_0 ) ) ;
    public final void rule__HttpClientStateElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2397:1: ( ( ( rule__HttpClientStateElement__NameAssignment_0 ) ) )
            // InternalAceGen.g:2398:1: ( ( rule__HttpClientStateElement__NameAssignment_0 ) )
            {
            // InternalAceGen.g:2398:1: ( ( rule__HttpClientStateElement__NameAssignment_0 ) )
            // InternalAceGen.g:2399:2: ( rule__HttpClientStateElement__NameAssignment_0 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getNameAssignment_0()); 
            // InternalAceGen.g:2400:2: ( rule__HttpClientStateElement__NameAssignment_0 )
            // InternalAceGen.g:2400:3: rule__HttpClientStateElement__NameAssignment_0
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
    // InternalAceGen.g:2408:1: rule__HttpClientStateElement__Group__1 : rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2 ;
    public final void rule__HttpClientStateElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2412:1: ( rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2 )
            // InternalAceGen.g:2413:2: rule__HttpClientStateElement__Group__1__Impl rule__HttpClientStateElement__Group__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalAceGen.g:2420:1: rule__HttpClientStateElement__Group__1__Impl : ( ( rule__HttpClientStateElement__ListAssignment_1 )? ) ;
    public final void rule__HttpClientStateElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2424:1: ( ( ( rule__HttpClientStateElement__ListAssignment_1 )? ) )
            // InternalAceGen.g:2425:1: ( ( rule__HttpClientStateElement__ListAssignment_1 )? )
            {
            // InternalAceGen.g:2425:1: ( ( rule__HttpClientStateElement__ListAssignment_1 )? )
            // InternalAceGen.g:2426:2: ( rule__HttpClientStateElement__ListAssignment_1 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListAssignment_1()); 
            // InternalAceGen.g:2427:2: ( rule__HttpClientStateElement__ListAssignment_1 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==66) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalAceGen.g:2427:3: rule__HttpClientStateElement__ListAssignment_1
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
    // InternalAceGen.g:2435:1: rule__HttpClientStateElement__Group__2 : rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3 ;
    public final void rule__HttpClientStateElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2439:1: ( rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3 )
            // InternalAceGen.g:2440:2: rule__HttpClientStateElement__Group__2__Impl rule__HttpClientStateElement__Group__3
            {
            pushFollow(FOLLOW_18);
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
    // InternalAceGen.g:2447:1: rule__HttpClientStateElement__Group__2__Impl : ( ( rule__HttpClientStateElement__HashAssignment_2 )? ) ;
    public final void rule__HttpClientStateElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2451:1: ( ( ( rule__HttpClientStateElement__HashAssignment_2 )? ) )
            // InternalAceGen.g:2452:1: ( ( rule__HttpClientStateElement__HashAssignment_2 )? )
            {
            // InternalAceGen.g:2452:1: ( ( rule__HttpClientStateElement__HashAssignment_2 )? )
            // InternalAceGen.g:2453:2: ( rule__HttpClientStateElement__HashAssignment_2 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashAssignment_2()); 
            // InternalAceGen.g:2454:2: ( rule__HttpClientStateElement__HashAssignment_2 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==67) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAceGen.g:2454:3: rule__HttpClientStateElement__HashAssignment_2
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
    // InternalAceGen.g:2462:1: rule__HttpClientStateElement__Group__3 : rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4 ;
    public final void rule__HttpClientStateElement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2466:1: ( rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4 )
            // InternalAceGen.g:2467:2: rule__HttpClientStateElement__Group__3__Impl rule__HttpClientStateElement__Group__4
            {
            pushFollow(FOLLOW_18);
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
    // InternalAceGen.g:2474:1: rule__HttpClientStateElement__Group__3__Impl : ( ( rule__HttpClientStateElement__StorageAssignment_3 )? ) ;
    public final void rule__HttpClientStateElement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2478:1: ( ( ( rule__HttpClientStateElement__StorageAssignment_3 )? ) )
            // InternalAceGen.g:2479:1: ( ( rule__HttpClientStateElement__StorageAssignment_3 )? )
            {
            // InternalAceGen.g:2479:1: ( ( rule__HttpClientStateElement__StorageAssignment_3 )? )
            // InternalAceGen.g:2480:2: ( rule__HttpClientStateElement__StorageAssignment_3 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageAssignment_3()); 
            // InternalAceGen.g:2481:2: ( rule__HttpClientStateElement__StorageAssignment_3 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==68) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAceGen.g:2481:3: rule__HttpClientStateElement__StorageAssignment_3
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
    // InternalAceGen.g:2489:1: rule__HttpClientStateElement__Group__4 : rule__HttpClientStateElement__Group__4__Impl ;
    public final void rule__HttpClientStateElement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2493:1: ( rule__HttpClientStateElement__Group__4__Impl )
            // InternalAceGen.g:2494:2: rule__HttpClientStateElement__Group__4__Impl
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
    // InternalAceGen.g:2500:1: rule__HttpClientStateElement__Group__4__Impl : ( ( rule__HttpClientStateElement__Group_4__0 )? ) ;
    public final void rule__HttpClientStateElement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2504:1: ( ( ( rule__HttpClientStateElement__Group_4__0 )? ) )
            // InternalAceGen.g:2505:1: ( ( rule__HttpClientStateElement__Group_4__0 )? )
            {
            // InternalAceGen.g:2505:1: ( ( rule__HttpClientStateElement__Group_4__0 )? )
            // InternalAceGen.g:2506:2: ( rule__HttpClientStateElement__Group_4__0 )?
            {
             before(grammarAccess.getHttpClientStateElementAccess().getGroup_4()); 
            // InternalAceGen.g:2507:2: ( rule__HttpClientStateElement__Group_4__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==41) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalAceGen.g:2507:3: rule__HttpClientStateElement__Group_4__0
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
    // InternalAceGen.g:2516:1: rule__HttpClientStateElement__Group_4__0 : rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1 ;
    public final void rule__HttpClientStateElement__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2520:1: ( rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1 )
            // InternalAceGen.g:2521:2: rule__HttpClientStateElement__Group_4__0__Impl rule__HttpClientStateElement__Group_4__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalAceGen.g:2528:1: rule__HttpClientStateElement__Group_4__0__Impl : ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) ) ;
    public final void rule__HttpClientStateElement__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2532:1: ( ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) ) )
            // InternalAceGen.g:2533:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) )
            {
            // InternalAceGen.g:2533:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_0 ) )
            // InternalAceGen.g:2534:2: ( rule__HttpClientStateElement__TypesAssignment_4_0 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_0()); 
            // InternalAceGen.g:2535:2: ( rule__HttpClientStateElement__TypesAssignment_4_0 )
            // InternalAceGen.g:2535:3: rule__HttpClientStateElement__TypesAssignment_4_0
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
    // InternalAceGen.g:2543:1: rule__HttpClientStateElement__Group_4__1 : rule__HttpClientStateElement__Group_4__1__Impl ;
    public final void rule__HttpClientStateElement__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2547:1: ( rule__HttpClientStateElement__Group_4__1__Impl )
            // InternalAceGen.g:2548:2: rule__HttpClientStateElement__Group_4__1__Impl
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
    // InternalAceGen.g:2554:1: rule__HttpClientStateElement__Group_4__1__Impl : ( ( rule__HttpClientStateElement__Group_4_1__0 )* ) ;
    public final void rule__HttpClientStateElement__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2558:1: ( ( ( rule__HttpClientStateElement__Group_4_1__0 )* ) )
            // InternalAceGen.g:2559:1: ( ( rule__HttpClientStateElement__Group_4_1__0 )* )
            {
            // InternalAceGen.g:2559:1: ( ( rule__HttpClientStateElement__Group_4_1__0 )* )
            // InternalAceGen.g:2560:2: ( rule__HttpClientStateElement__Group_4_1__0 )*
            {
             before(grammarAccess.getHttpClientStateElementAccess().getGroup_4_1()); 
            // InternalAceGen.g:2561:2: ( rule__HttpClientStateElement__Group_4_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==40) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalAceGen.g:2561:3: rule__HttpClientStateElement__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__HttpClientStateElement__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // InternalAceGen.g:2570:1: rule__HttpClientStateElement__Group_4_1__0 : rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1 ;
    public final void rule__HttpClientStateElement__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2574:1: ( rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1 )
            // InternalAceGen.g:2575:2: rule__HttpClientStateElement__Group_4_1__0__Impl rule__HttpClientStateElement__Group_4_1__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalAceGen.g:2582:1: rule__HttpClientStateElement__Group_4_1__0__Impl : ( '|' ) ;
    public final void rule__HttpClientStateElement__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2586:1: ( ( '|' ) )
            // InternalAceGen.g:2587:1: ( '|' )
            {
            // InternalAceGen.g:2587:1: ( '|' )
            // InternalAceGen.g:2588:2: '|'
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
    // InternalAceGen.g:2597:1: rule__HttpClientStateElement__Group_4_1__1 : rule__HttpClientStateElement__Group_4_1__1__Impl ;
    public final void rule__HttpClientStateElement__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2601:1: ( rule__HttpClientStateElement__Group_4_1__1__Impl )
            // InternalAceGen.g:2602:2: rule__HttpClientStateElement__Group_4_1__1__Impl
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
    // InternalAceGen.g:2608:1: rule__HttpClientStateElement__Group_4_1__1__Impl : ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) ) ;
    public final void rule__HttpClientStateElement__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2612:1: ( ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) ) )
            // InternalAceGen.g:2613:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) )
            {
            // InternalAceGen.g:2613:1: ( ( rule__HttpClientStateElement__TypesAssignment_4_1_1 ) )
            // InternalAceGen.g:2614:2: ( rule__HttpClientStateElement__TypesAssignment_4_1_1 )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getTypesAssignment_4_1_1()); 
            // InternalAceGen.g:2615:2: ( rule__HttpClientStateElement__TypesAssignment_4_1_1 )
            // InternalAceGen.g:2615:3: rule__HttpClientStateElement__TypesAssignment_4_1_1
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
    // InternalAceGen.g:2624:1: rule__HttpClientTypeDefinition__Group__0 : rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1 ;
    public final void rule__HttpClientTypeDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2628:1: ( rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1 )
            // InternalAceGen.g:2629:2: rule__HttpClientTypeDefinition__Group__0__Impl rule__HttpClientTypeDefinition__Group__1
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
    // InternalAceGen.g:2636:1: rule__HttpClientTypeDefinition__Group__0__Impl : ( ':' ) ;
    public final void rule__HttpClientTypeDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2640:1: ( ( ':' ) )
            // InternalAceGen.g:2641:1: ( ':' )
            {
            // InternalAceGen.g:2641:1: ( ':' )
            // InternalAceGen.g:2642:2: ':'
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
    // InternalAceGen.g:2651:1: rule__HttpClientTypeDefinition__Group__1 : rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2 ;
    public final void rule__HttpClientTypeDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2655:1: ( rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2 )
            // InternalAceGen.g:2656:2: rule__HttpClientTypeDefinition__Group__1__Impl rule__HttpClientTypeDefinition__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalAceGen.g:2663:1: rule__HttpClientTypeDefinition__Group__1__Impl : ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) ) ;
    public final void rule__HttpClientTypeDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2667:1: ( ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) ) )
            // InternalAceGen.g:2668:1: ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) )
            {
            // InternalAceGen.g:2668:1: ( ( rule__HttpClientTypeDefinition__NameAssignment_1 ) )
            // InternalAceGen.g:2669:2: ( rule__HttpClientTypeDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getNameAssignment_1()); 
            // InternalAceGen.g:2670:2: ( rule__HttpClientTypeDefinition__NameAssignment_1 )
            // InternalAceGen.g:2670:3: rule__HttpClientTypeDefinition__NameAssignment_1
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
    // InternalAceGen.g:2678:1: rule__HttpClientTypeDefinition__Group__2 : rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3 ;
    public final void rule__HttpClientTypeDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2682:1: ( rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3 )
            // InternalAceGen.g:2683:2: rule__HttpClientTypeDefinition__Group__2__Impl rule__HttpClientTypeDefinition__Group__3
            {
            pushFollow(FOLLOW_23);
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
    // InternalAceGen.g:2690:1: rule__HttpClientTypeDefinition__Group__2__Impl : ( '{' ) ;
    public final void rule__HttpClientTypeDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2694:1: ( ( '{' ) )
            // InternalAceGen.g:2695:1: ( '{' )
            {
            // InternalAceGen.g:2695:1: ( '{' )
            // InternalAceGen.g:2696:2: '{'
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
    // InternalAceGen.g:2705:1: rule__HttpClientTypeDefinition__Group__3 : rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4 ;
    public final void rule__HttpClientTypeDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2709:1: ( rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4 )
            // InternalAceGen.g:2710:2: rule__HttpClientTypeDefinition__Group__3__Impl rule__HttpClientTypeDefinition__Group__4
            {
            pushFollow(FOLLOW_23);
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
    // InternalAceGen.g:2717:1: rule__HttpClientTypeDefinition__Group__3__Impl : ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* ) ;
    public final void rule__HttpClientTypeDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2721:1: ( ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* ) )
            // InternalAceGen.g:2722:1: ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* )
            {
            // InternalAceGen.g:2722:1: ( ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )* )
            // InternalAceGen.g:2723:2: ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )*
            {
             before(grammarAccess.getHttpClientTypeDefinitionAccess().getElementsAssignment_3()); 
            // InternalAceGen.g:2724:2: ( rule__HttpClientTypeDefinition__ElementsAssignment_3 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalAceGen.g:2724:3: rule__HttpClientTypeDefinition__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__HttpClientTypeDefinition__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalAceGen.g:2732:1: rule__HttpClientTypeDefinition__Group__4 : rule__HttpClientTypeDefinition__Group__4__Impl ;
    public final void rule__HttpClientTypeDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2736:1: ( rule__HttpClientTypeDefinition__Group__4__Impl )
            // InternalAceGen.g:2737:2: rule__HttpClientTypeDefinition__Group__4__Impl
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
    // InternalAceGen.g:2743:1: rule__HttpClientTypeDefinition__Group__4__Impl : ( '}' ) ;
    public final void rule__HttpClientTypeDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2747:1: ( ( '}' ) )
            // InternalAceGen.g:2748:1: ( '}' )
            {
            // InternalAceGen.g:2748:1: ( '}' )
            // InternalAceGen.g:2749:2: '}'
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
    // InternalAceGen.g:2759:1: rule__HttpServer__Group__0 : rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1 ;
    public final void rule__HttpServer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2763:1: ( rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1 )
            // InternalAceGen.g:2764:2: rule__HttpServer__Group__0__Impl rule__HttpServer__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalAceGen.g:2771:1: rule__HttpServer__Group__0__Impl : ( ( rule__HttpServer__NameAssignment_0 ) ) ;
    public final void rule__HttpServer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2775:1: ( ( ( rule__HttpServer__NameAssignment_0 ) ) )
            // InternalAceGen.g:2776:1: ( ( rule__HttpServer__NameAssignment_0 ) )
            {
            // InternalAceGen.g:2776:1: ( ( rule__HttpServer__NameAssignment_0 ) )
            // InternalAceGen.g:2777:2: ( rule__HttpServer__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerAccess().getNameAssignment_0()); 
            // InternalAceGen.g:2778:2: ( rule__HttpServer__NameAssignment_0 )
            // InternalAceGen.g:2778:3: rule__HttpServer__NameAssignment_0
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
    // InternalAceGen.g:2786:1: rule__HttpServer__Group__1 : rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2 ;
    public final void rule__HttpServer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2790:1: ( rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2 )
            // InternalAceGen.g:2791:2: rule__HttpServer__Group__1__Impl rule__HttpServer__Group__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalAceGen.g:2798:1: rule__HttpServer__Group__1__Impl : ( ( rule__HttpServer__Group_1__0 )? ) ;
    public final void rule__HttpServer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2802:1: ( ( ( rule__HttpServer__Group_1__0 )? ) )
            // InternalAceGen.g:2803:1: ( ( rule__HttpServer__Group_1__0 )? )
            {
            // InternalAceGen.g:2803:1: ( ( rule__HttpServer__Group_1__0 )? )
            // InternalAceGen.g:2804:2: ( rule__HttpServer__Group_1__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_1()); 
            // InternalAceGen.g:2805:2: ( rule__HttpServer__Group_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==44) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalAceGen.g:2805:3: rule__HttpServer__Group_1__0
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
    // InternalAceGen.g:2813:1: rule__HttpServer__Group__2 : rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3 ;
    public final void rule__HttpServer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2817:1: ( rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3 )
            // InternalAceGen.g:2818:2: rule__HttpServer__Group__2__Impl rule__HttpServer__Group__3
            {
            pushFollow(FOLLOW_24);
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
    // InternalAceGen.g:2825:1: rule__HttpServer__Group__2__Impl : ( ( rule__HttpServer__Group_2__0 )? ) ;
    public final void rule__HttpServer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2829:1: ( ( ( rule__HttpServer__Group_2__0 )? ) )
            // InternalAceGen.g:2830:1: ( ( rule__HttpServer__Group_2__0 )? )
            {
            // InternalAceGen.g:2830:1: ( ( rule__HttpServer__Group_2__0 )? )
            // InternalAceGen.g:2831:2: ( rule__HttpServer__Group_2__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_2()); 
            // InternalAceGen.g:2832:2: ( rule__HttpServer__Group_2__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==45) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAceGen.g:2832:3: rule__HttpServer__Group_2__0
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
    // InternalAceGen.g:2840:1: rule__HttpServer__Group__3 : rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4 ;
    public final void rule__HttpServer__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2844:1: ( rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4 )
            // InternalAceGen.g:2845:2: rule__HttpServer__Group__3__Impl rule__HttpServer__Group__4
            {
            pushFollow(FOLLOW_24);
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
    // InternalAceGen.g:2852:1: rule__HttpServer__Group__3__Impl : ( ( rule__HttpServer__Group_3__0 )? ) ;
    public final void rule__HttpServer__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2856:1: ( ( ( rule__HttpServer__Group_3__0 )? ) )
            // InternalAceGen.g:2857:1: ( ( rule__HttpServer__Group_3__0 )? )
            {
            // InternalAceGen.g:2857:1: ( ( rule__HttpServer__Group_3__0 )? )
            // InternalAceGen.g:2858:2: ( rule__HttpServer__Group_3__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_3()); 
            // InternalAceGen.g:2859:2: ( rule__HttpServer__Group_3__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==29) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalAceGen.g:2859:3: rule__HttpServer__Group_3__0
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
    // InternalAceGen.g:2867:1: rule__HttpServer__Group__4 : rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5 ;
    public final void rule__HttpServer__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2871:1: ( rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5 )
            // InternalAceGen.g:2872:2: rule__HttpServer__Group__4__Impl rule__HttpServer__Group__5
            {
            pushFollow(FOLLOW_24);
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
    // InternalAceGen.g:2879:1: rule__HttpServer__Group__4__Impl : ( ( rule__HttpServer__Group_4__0 )? ) ;
    public final void rule__HttpServer__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2883:1: ( ( ( rule__HttpServer__Group_4__0 )? ) )
            // InternalAceGen.g:2884:1: ( ( rule__HttpServer__Group_4__0 )? )
            {
            // InternalAceGen.g:2884:1: ( ( rule__HttpServer__Group_4__0 )? )
            // InternalAceGen.g:2885:2: ( rule__HttpServer__Group_4__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_4()); 
            // InternalAceGen.g:2886:2: ( rule__HttpServer__Group_4__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==46) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalAceGen.g:2886:3: rule__HttpServer__Group_4__0
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
    // InternalAceGen.g:2894:1: rule__HttpServer__Group__5 : rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6 ;
    public final void rule__HttpServer__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2898:1: ( rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6 )
            // InternalAceGen.g:2899:2: rule__HttpServer__Group__5__Impl rule__HttpServer__Group__6
            {
            pushFollow(FOLLOW_24);
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
    // InternalAceGen.g:2906:1: rule__HttpServer__Group__5__Impl : ( ( rule__HttpServer__Group_5__0 )? ) ;
    public final void rule__HttpServer__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2910:1: ( ( ( rule__HttpServer__Group_5__0 )? ) )
            // InternalAceGen.g:2911:1: ( ( rule__HttpServer__Group_5__0 )? )
            {
            // InternalAceGen.g:2911:1: ( ( rule__HttpServer__Group_5__0 )? )
            // InternalAceGen.g:2912:2: ( rule__HttpServer__Group_5__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_5()); 
            // InternalAceGen.g:2913:2: ( rule__HttpServer__Group_5__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==47) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalAceGen.g:2913:3: rule__HttpServer__Group_5__0
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
    // InternalAceGen.g:2921:1: rule__HttpServer__Group__6 : rule__HttpServer__Group__6__Impl ;
    public final void rule__HttpServer__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2925:1: ( rule__HttpServer__Group__6__Impl )
            // InternalAceGen.g:2926:2: rule__HttpServer__Group__6__Impl
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
    // InternalAceGen.g:2932:1: rule__HttpServer__Group__6__Impl : ( ( rule__HttpServer__Group_6__0 )? ) ;
    public final void rule__HttpServer__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2936:1: ( ( ( rule__HttpServer__Group_6__0 )? ) )
            // InternalAceGen.g:2937:1: ( ( rule__HttpServer__Group_6__0 )? )
            {
            // InternalAceGen.g:2937:1: ( ( rule__HttpServer__Group_6__0 )? )
            // InternalAceGen.g:2938:2: ( rule__HttpServer__Group_6__0 )?
            {
             before(grammarAccess.getHttpServerAccess().getGroup_6()); 
            // InternalAceGen.g:2939:2: ( rule__HttpServer__Group_6__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==48) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAceGen.g:2939:3: rule__HttpServer__Group_6__0
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
    // InternalAceGen.g:2948:1: rule__HttpServer__Group_1__0 : rule__HttpServer__Group_1__0__Impl rule__HttpServer__Group_1__1 ;
    public final void rule__HttpServer__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2952:1: ( rule__HttpServer__Group_1__0__Impl rule__HttpServer__Group_1__1 )
            // InternalAceGen.g:2953:2: rule__HttpServer__Group_1__0__Impl rule__HttpServer__Group_1__1
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
    // InternalAceGen.g:2960:1: rule__HttpServer__Group_1__0__Impl : ( 'Authorization' ) ;
    public final void rule__HttpServer__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2964:1: ( ( 'Authorization' ) )
            // InternalAceGen.g:2965:1: ( 'Authorization' )
            {
            // InternalAceGen.g:2965:1: ( 'Authorization' )
            // InternalAceGen.g:2966:2: 'Authorization'
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
    // InternalAceGen.g:2975:1: rule__HttpServer__Group_1__1 : rule__HttpServer__Group_1__1__Impl ;
    public final void rule__HttpServer__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2979:1: ( rule__HttpServer__Group_1__1__Impl )
            // InternalAceGen.g:2980:2: rule__HttpServer__Group_1__1__Impl
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
    // InternalAceGen.g:2986:1: rule__HttpServer__Group_1__1__Impl : ( ( rule__HttpServer__AuthUserAssignment_1_1 ) ) ;
    public final void rule__HttpServer__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:2990:1: ( ( ( rule__HttpServer__AuthUserAssignment_1_1 ) ) )
            // InternalAceGen.g:2991:1: ( ( rule__HttpServer__AuthUserAssignment_1_1 ) )
            {
            // InternalAceGen.g:2991:1: ( ( rule__HttpServer__AuthUserAssignment_1_1 ) )
            // InternalAceGen.g:2992:2: ( rule__HttpServer__AuthUserAssignment_1_1 )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserAssignment_1_1()); 
            // InternalAceGen.g:2993:2: ( rule__HttpServer__AuthUserAssignment_1_1 )
            // InternalAceGen.g:2993:3: rule__HttpServer__AuthUserAssignment_1_1
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
    // InternalAceGen.g:3002:1: rule__HttpServer__Group_2__0 : rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1 ;
    public final void rule__HttpServer__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3006:1: ( rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1 )
            // InternalAceGen.g:3007:2: rule__HttpServer__Group_2__0__Impl rule__HttpServer__Group_2__1
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
    // InternalAceGen.g:3014:1: rule__HttpServer__Group_2__0__Impl : ( 'import' ) ;
    public final void rule__HttpServer__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3018:1: ( ( 'import' ) )
            // InternalAceGen.g:3019:1: ( 'import' )
            {
            // InternalAceGen.g:3019:1: ( 'import' )
            // InternalAceGen.g:3020:2: 'import'
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
    // InternalAceGen.g:3029:1: rule__HttpServer__Group_2__1 : rule__HttpServer__Group_2__1__Impl ;
    public final void rule__HttpServer__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3033:1: ( rule__HttpServer__Group_2__1__Impl )
            // InternalAceGen.g:3034:2: rule__HttpServer__Group_2__1__Impl
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
    // InternalAceGen.g:3040:1: rule__HttpServer__Group_2__1__Impl : ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) ) ;
    public final void rule__HttpServer__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3044:1: ( ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) ) )
            // InternalAceGen.g:3045:1: ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) )
            {
            // InternalAceGen.g:3045:1: ( ( rule__HttpServer__AuthUserRefAssignment_2_1 ) )
            // InternalAceGen.g:3046:2: ( rule__HttpServer__AuthUserRefAssignment_2_1 )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAssignment_2_1()); 
            // InternalAceGen.g:3047:2: ( rule__HttpServer__AuthUserRefAssignment_2_1 )
            // InternalAceGen.g:3047:3: rule__HttpServer__AuthUserRefAssignment_2_1
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
    // InternalAceGen.g:3056:1: rule__HttpServer__Group_3__0 : rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1 ;
    public final void rule__HttpServer__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3060:1: ( rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1 )
            // InternalAceGen.g:3061:2: rule__HttpServer__Group_3__0__Impl rule__HttpServer__Group_3__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalAceGen.g:3068:1: rule__HttpServer__Group_3__0__Impl : ( 'ACE' ) ;
    public final void rule__HttpServer__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3072:1: ( ( 'ACE' ) )
            // InternalAceGen.g:3073:1: ( 'ACE' )
            {
            // InternalAceGen.g:3073:1: ( 'ACE' )
            // InternalAceGen.g:3074:2: 'ACE'
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
    // InternalAceGen.g:3083:1: rule__HttpServer__Group_3__1 : rule__HttpServer__Group_3__1__Impl ;
    public final void rule__HttpServer__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3087:1: ( rule__HttpServer__Group_3__1__Impl )
            // InternalAceGen.g:3088:2: rule__HttpServer__Group_3__1__Impl
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
    // InternalAceGen.g:3094:1: rule__HttpServer__Group_3__1__Impl : ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* ) ;
    public final void rule__HttpServer__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3098:1: ( ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* ) )
            // InternalAceGen.g:3099:1: ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* )
            {
            // InternalAceGen.g:3099:1: ( ( rule__HttpServer__AceOperationsAssignment_3_1 )* )
            // InternalAceGen.g:3100:2: ( rule__HttpServer__AceOperationsAssignment_3_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getAceOperationsAssignment_3_1()); 
            // InternalAceGen.g:3101:2: ( rule__HttpServer__AceOperationsAssignment_3_1 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID||LA39_0==69) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalAceGen.g:3101:3: rule__HttpServer__AceOperationsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__HttpServer__AceOperationsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalAceGen.g:3110:1: rule__HttpServer__Group_4__0 : rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1 ;
    public final void rule__HttpServer__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3114:1: ( rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1 )
            // InternalAceGen.g:3115:2: rule__HttpServer__Group_4__0__Impl rule__HttpServer__Group_4__1
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
    // InternalAceGen.g:3122:1: rule__HttpServer__Group_4__0__Impl : ( 'views' ) ;
    public final void rule__HttpServer__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3126:1: ( ( 'views' ) )
            // InternalAceGen.g:3127:1: ( 'views' )
            {
            // InternalAceGen.g:3127:1: ( 'views' )
            // InternalAceGen.g:3128:2: 'views'
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
    // InternalAceGen.g:3137:1: rule__HttpServer__Group_4__1 : rule__HttpServer__Group_4__1__Impl ;
    public final void rule__HttpServer__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3141:1: ( rule__HttpServer__Group_4__1__Impl )
            // InternalAceGen.g:3142:2: rule__HttpServer__Group_4__1__Impl
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
    // InternalAceGen.g:3148:1: rule__HttpServer__Group_4__1__Impl : ( ( rule__HttpServer__ViewsAssignment_4_1 )* ) ;
    public final void rule__HttpServer__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3152:1: ( ( ( rule__HttpServer__ViewsAssignment_4_1 )* ) )
            // InternalAceGen.g:3153:1: ( ( rule__HttpServer__ViewsAssignment_4_1 )* )
            {
            // InternalAceGen.g:3153:1: ( ( rule__HttpServer__ViewsAssignment_4_1 )* )
            // InternalAceGen.g:3154:2: ( rule__HttpServer__ViewsAssignment_4_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getViewsAssignment_4_1()); 
            // InternalAceGen.g:3155:2: ( rule__HttpServer__ViewsAssignment_4_1 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_ID) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalAceGen.g:3155:3: rule__HttpServer__ViewsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__HttpServer__ViewsAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
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
    // InternalAceGen.g:3164:1: rule__HttpServer__Group_5__0 : rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1 ;
    public final void rule__HttpServer__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3168:1: ( rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1 )
            // InternalAceGen.g:3169:2: rule__HttpServer__Group_5__0__Impl rule__HttpServer__Group_5__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalAceGen.g:3176:1: rule__HttpServer__Group_5__0__Impl : ( 'models' ) ;
    public final void rule__HttpServer__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3180:1: ( ( 'models' ) )
            // InternalAceGen.g:3181:1: ( 'models' )
            {
            // InternalAceGen.g:3181:1: ( 'models' )
            // InternalAceGen.g:3182:2: 'models'
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
    // InternalAceGen.g:3191:1: rule__HttpServer__Group_5__1 : rule__HttpServer__Group_5__1__Impl ;
    public final void rule__HttpServer__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3195:1: ( rule__HttpServer__Group_5__1__Impl )
            // InternalAceGen.g:3196:2: rule__HttpServer__Group_5__1__Impl
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
    // InternalAceGen.g:3202:1: rule__HttpServer__Group_5__1__Impl : ( ( rule__HttpServer__ModelsAssignment_5_1 )* ) ;
    public final void rule__HttpServer__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3206:1: ( ( ( rule__HttpServer__ModelsAssignment_5_1 )* ) )
            // InternalAceGen.g:3207:1: ( ( rule__HttpServer__ModelsAssignment_5_1 )* )
            {
            // InternalAceGen.g:3207:1: ( ( rule__HttpServer__ModelsAssignment_5_1 )* )
            // InternalAceGen.g:3208:2: ( rule__HttpServer__ModelsAssignment_5_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getModelsAssignment_5_1()); 
            // InternalAceGen.g:3209:2: ( rule__HttpServer__ModelsAssignment_5_1 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID||LA41_0==71) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalAceGen.g:3209:3: rule__HttpServer__ModelsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__HttpServer__ModelsAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
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
    // InternalAceGen.g:3218:1: rule__HttpServer__Group_6__0 : rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1 ;
    public final void rule__HttpServer__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3222:1: ( rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1 )
            // InternalAceGen.g:3223:2: rule__HttpServer__Group_6__0__Impl rule__HttpServer__Group_6__1
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
    // InternalAceGen.g:3230:1: rule__HttpServer__Group_6__0__Impl : ( 'scenarios' ) ;
    public final void rule__HttpServer__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3234:1: ( ( 'scenarios' ) )
            // InternalAceGen.g:3235:1: ( 'scenarios' )
            {
            // InternalAceGen.g:3235:1: ( 'scenarios' )
            // InternalAceGen.g:3236:2: 'scenarios'
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
    // InternalAceGen.g:3245:1: rule__HttpServer__Group_6__1 : rule__HttpServer__Group_6__1__Impl ;
    public final void rule__HttpServer__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3249:1: ( rule__HttpServer__Group_6__1__Impl )
            // InternalAceGen.g:3250:2: rule__HttpServer__Group_6__1__Impl
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
    // InternalAceGen.g:3256:1: rule__HttpServer__Group_6__1__Impl : ( ( rule__HttpServer__ScenariosAssignment_6_1 )* ) ;
    public final void rule__HttpServer__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3260:1: ( ( ( rule__HttpServer__ScenariosAssignment_6_1 )* ) )
            // InternalAceGen.g:3261:1: ( ( rule__HttpServer__ScenariosAssignment_6_1 )* )
            {
            // InternalAceGen.g:3261:1: ( ( rule__HttpServer__ScenariosAssignment_6_1 )* )
            // InternalAceGen.g:3262:2: ( rule__HttpServer__ScenariosAssignment_6_1 )*
            {
             before(grammarAccess.getHttpServerAccess().getScenariosAssignment_6_1()); 
            // InternalAceGen.g:3263:2: ( rule__HttpServer__ScenariosAssignment_6_1 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_ID) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalAceGen.g:3263:3: rule__HttpServer__ScenariosAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__HttpServer__ScenariosAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // InternalAceGen.g:3272:1: rule__HttpServerAceWrite__Group__0 : rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1 ;
    public final void rule__HttpServerAceWrite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3276:1: ( rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1 )
            // InternalAceGen.g:3277:2: rule__HttpServerAceWrite__Group__0__Impl rule__HttpServerAceWrite__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalAceGen.g:3284:1: rule__HttpServerAceWrite__Group__0__Impl : ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3288:1: ( ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? ) )
            // InternalAceGen.g:3289:1: ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? )
            {
            // InternalAceGen.g:3289:1: ( ( rule__HttpServerAceWrite__ProxyAssignment_0 )? )
            // InternalAceGen.g:3290:2: ( rule__HttpServerAceWrite__ProxyAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyAssignment_0()); 
            // InternalAceGen.g:3291:2: ( rule__HttpServerAceWrite__ProxyAssignment_0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==69) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalAceGen.g:3291:3: rule__HttpServerAceWrite__ProxyAssignment_0
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
    // InternalAceGen.g:3299:1: rule__HttpServerAceWrite__Group__1 : rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2 ;
    public final void rule__HttpServerAceWrite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3303:1: ( rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2 )
            // InternalAceGen.g:3304:2: rule__HttpServerAceWrite__Group__1__Impl rule__HttpServerAceWrite__Group__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalAceGen.g:3311:1: rule__HttpServerAceWrite__Group__1__Impl : ( ( rule__HttpServerAceWrite__NameAssignment_1 ) ) ;
    public final void rule__HttpServerAceWrite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3315:1: ( ( ( rule__HttpServerAceWrite__NameAssignment_1 ) ) )
            // InternalAceGen.g:3316:1: ( ( rule__HttpServerAceWrite__NameAssignment_1 ) )
            {
            // InternalAceGen.g:3316:1: ( ( rule__HttpServerAceWrite__NameAssignment_1 ) )
            // InternalAceGen.g:3317:2: ( rule__HttpServerAceWrite__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getNameAssignment_1()); 
            // InternalAceGen.g:3318:2: ( rule__HttpServerAceWrite__NameAssignment_1 )
            // InternalAceGen.g:3318:3: rule__HttpServerAceWrite__NameAssignment_1
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
    // InternalAceGen.g:3326:1: rule__HttpServerAceWrite__Group__2 : rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3 ;
    public final void rule__HttpServerAceWrite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3330:1: ( rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3 )
            // InternalAceGen.g:3331:2: rule__HttpServerAceWrite__Group__2__Impl rule__HttpServerAceWrite__Group__3
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
    // InternalAceGen.g:3338:1: rule__HttpServerAceWrite__Group__2__Impl : ( '<' ) ;
    public final void rule__HttpServerAceWrite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3342:1: ( ( '<' ) )
            // InternalAceGen.g:3343:1: ( '<' )
            {
            // InternalAceGen.g:3343:1: ( '<' )
            // InternalAceGen.g:3344:2: '<'
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
    // InternalAceGen.g:3353:1: rule__HttpServerAceWrite__Group__3 : rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4 ;
    public final void rule__HttpServerAceWrite__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3357:1: ( rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4 )
            // InternalAceGen.g:3358:2: rule__HttpServerAceWrite__Group__3__Impl rule__HttpServerAceWrite__Group__4
            {
            pushFollow(FOLLOW_30);
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
    // InternalAceGen.g:3365:1: rule__HttpServerAceWrite__Group__3__Impl : ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) ) ;
    public final void rule__HttpServerAceWrite__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3369:1: ( ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) ) )
            // InternalAceGen.g:3370:1: ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) )
            {
            // InternalAceGen.g:3370:1: ( ( rule__HttpServerAceWrite__ModelAssignment_3 ) )
            // InternalAceGen.g:3371:2: ( rule__HttpServerAceWrite__ModelAssignment_3 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getModelAssignment_3()); 
            // InternalAceGen.g:3372:2: ( rule__HttpServerAceWrite__ModelAssignment_3 )
            // InternalAceGen.g:3372:3: rule__HttpServerAceWrite__ModelAssignment_3
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
    // InternalAceGen.g:3380:1: rule__HttpServerAceWrite__Group__4 : rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5 ;
    public final void rule__HttpServerAceWrite__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3384:1: ( rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5 )
            // InternalAceGen.g:3385:2: rule__HttpServerAceWrite__Group__4__Impl rule__HttpServerAceWrite__Group__5
            {
            pushFollow(FOLLOW_31);
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
    // InternalAceGen.g:3392:1: rule__HttpServerAceWrite__Group__4__Impl : ( '>' ) ;
    public final void rule__HttpServerAceWrite__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3396:1: ( ( '>' ) )
            // InternalAceGen.g:3397:1: ( '>' )
            {
            // InternalAceGen.g:3397:1: ( '>' )
            // InternalAceGen.g:3398:2: '>'
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
    // InternalAceGen.g:3407:1: rule__HttpServerAceWrite__Group__5 : rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6 ;
    public final void rule__HttpServerAceWrite__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3411:1: ( rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6 )
            // InternalAceGen.g:3412:2: rule__HttpServerAceWrite__Group__5__Impl rule__HttpServerAceWrite__Group__6
            {
            pushFollow(FOLLOW_32);
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
    // InternalAceGen.g:3419:1: rule__HttpServerAceWrite__Group__5__Impl : ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) ) ;
    public final void rule__HttpServerAceWrite__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3423:1: ( ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) ) )
            // InternalAceGen.g:3424:1: ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) )
            {
            // InternalAceGen.g:3424:1: ( ( rule__HttpServerAceWrite__TypeAssignment_5 ) )
            // InternalAceGen.g:3425:2: ( rule__HttpServerAceWrite__TypeAssignment_5 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getTypeAssignment_5()); 
            // InternalAceGen.g:3426:2: ( rule__HttpServerAceWrite__TypeAssignment_5 )
            // InternalAceGen.g:3426:3: rule__HttpServerAceWrite__TypeAssignment_5
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
    // InternalAceGen.g:3434:1: rule__HttpServerAceWrite__Group__6 : rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7 ;
    public final void rule__HttpServerAceWrite__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3438:1: ( rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7 )
            // InternalAceGen.g:3439:2: rule__HttpServerAceWrite__Group__6__Impl rule__HttpServerAceWrite__Group__7
            {
            pushFollow(FOLLOW_33);
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
    // InternalAceGen.g:3446:1: rule__HttpServerAceWrite__Group__6__Impl : ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) ) ;
    public final void rule__HttpServerAceWrite__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3450:1: ( ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) ) )
            // InternalAceGen.g:3451:1: ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) )
            {
            // InternalAceGen.g:3451:1: ( ( rule__HttpServerAceWrite__UrlAssignment_6 ) )
            // InternalAceGen.g:3452:2: ( rule__HttpServerAceWrite__UrlAssignment_6 )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getUrlAssignment_6()); 
            // InternalAceGen.g:3453:2: ( rule__HttpServerAceWrite__UrlAssignment_6 )
            // InternalAceGen.g:3453:3: rule__HttpServerAceWrite__UrlAssignment_6
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
    // InternalAceGen.g:3461:1: rule__HttpServerAceWrite__Group__7 : rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8 ;
    public final void rule__HttpServerAceWrite__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3465:1: ( rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8 )
            // InternalAceGen.g:3466:2: rule__HttpServerAceWrite__Group__7__Impl rule__HttpServerAceWrite__Group__8
            {
            pushFollow(FOLLOW_33);
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
    // InternalAceGen.g:3473:1: rule__HttpServerAceWrite__Group__7__Impl : ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? ) ;
    public final void rule__HttpServerAceWrite__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3477:1: ( ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? ) )
            // InternalAceGen.g:3478:1: ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? )
            {
            // InternalAceGen.g:3478:1: ( ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )? )
            // InternalAceGen.g:3479:2: ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAssignment_7()); 
            // InternalAceGen.g:3480:2: ( rule__HttpServerAceWrite__AuthorizeAssignment_7 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==70) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalAceGen.g:3480:3: rule__HttpServerAceWrite__AuthorizeAssignment_7
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
    // InternalAceGen.g:3488:1: rule__HttpServerAceWrite__Group__8 : rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9 ;
    public final void rule__HttpServerAceWrite__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3492:1: ( rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9 )
            // InternalAceGen.g:3493:2: rule__HttpServerAceWrite__Group__8__Impl rule__HttpServerAceWrite__Group__9
            {
            pushFollow(FOLLOW_33);
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
    // InternalAceGen.g:3500:1: rule__HttpServerAceWrite__Group__8__Impl : ( ( rule__HttpServerAceWrite__Group_8__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3504:1: ( ( ( rule__HttpServerAceWrite__Group_8__0 )? ) )
            // InternalAceGen.g:3505:1: ( ( rule__HttpServerAceWrite__Group_8__0 )? )
            {
            // InternalAceGen.g:3505:1: ( ( rule__HttpServerAceWrite__Group_8__0 )? )
            // InternalAceGen.g:3506:2: ( rule__HttpServerAceWrite__Group_8__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_8()); 
            // InternalAceGen.g:3507:2: ( rule__HttpServerAceWrite__Group_8__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==49) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAceGen.g:3507:3: rule__HttpServerAceWrite__Group_8__0
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
    // InternalAceGen.g:3515:1: rule__HttpServerAceWrite__Group__9 : rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10 ;
    public final void rule__HttpServerAceWrite__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3519:1: ( rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10 )
            // InternalAceGen.g:3520:2: rule__HttpServerAceWrite__Group__9__Impl rule__HttpServerAceWrite__Group__10
            {
            pushFollow(FOLLOW_33);
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
    // InternalAceGen.g:3527:1: rule__HttpServerAceWrite__Group__9__Impl : ( ( rule__HttpServerAceWrite__Group_9__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3531:1: ( ( ( rule__HttpServerAceWrite__Group_9__0 )? ) )
            // InternalAceGen.g:3532:1: ( ( rule__HttpServerAceWrite__Group_9__0 )? )
            {
            // InternalAceGen.g:3532:1: ( ( rule__HttpServerAceWrite__Group_9__0 )? )
            // InternalAceGen.g:3533:2: ( rule__HttpServerAceWrite__Group_9__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_9()); 
            // InternalAceGen.g:3534:2: ( rule__HttpServerAceWrite__Group_9__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==50) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalAceGen.g:3534:3: rule__HttpServerAceWrite__Group_9__0
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
    // InternalAceGen.g:3542:1: rule__HttpServerAceWrite__Group__10 : rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11 ;
    public final void rule__HttpServerAceWrite__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3546:1: ( rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11 )
            // InternalAceGen.g:3547:2: rule__HttpServerAceWrite__Group__10__Impl rule__HttpServerAceWrite__Group__11
            {
            pushFollow(FOLLOW_33);
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
    // InternalAceGen.g:3554:1: rule__HttpServerAceWrite__Group__10__Impl : ( ( rule__HttpServerAceWrite__Group_10__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3558:1: ( ( ( rule__HttpServerAceWrite__Group_10__0 )? ) )
            // InternalAceGen.g:3559:1: ( ( rule__HttpServerAceWrite__Group_10__0 )? )
            {
            // InternalAceGen.g:3559:1: ( ( rule__HttpServerAceWrite__Group_10__0 )? )
            // InternalAceGen.g:3560:2: ( rule__HttpServerAceWrite__Group_10__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_10()); 
            // InternalAceGen.g:3561:2: ( rule__HttpServerAceWrite__Group_10__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==51) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalAceGen.g:3561:3: rule__HttpServerAceWrite__Group_10__0
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
    // InternalAceGen.g:3569:1: rule__HttpServerAceWrite__Group__11 : rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12 ;
    public final void rule__HttpServerAceWrite__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3573:1: ( rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12 )
            // InternalAceGen.g:3574:2: rule__HttpServerAceWrite__Group__11__Impl rule__HttpServerAceWrite__Group__12
            {
            pushFollow(FOLLOW_33);
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
    // InternalAceGen.g:3581:1: rule__HttpServerAceWrite__Group__11__Impl : ( ( rule__HttpServerAceWrite__Group_11__0 )? ) ;
    public final void rule__HttpServerAceWrite__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3585:1: ( ( ( rule__HttpServerAceWrite__Group_11__0 )? ) )
            // InternalAceGen.g:3586:1: ( ( rule__HttpServerAceWrite__Group_11__0 )? )
            {
            // InternalAceGen.g:3586:1: ( ( rule__HttpServerAceWrite__Group_11__0 )? )
            // InternalAceGen.g:3587:2: ( rule__HttpServerAceWrite__Group_11__0 )?
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getGroup_11()); 
            // InternalAceGen.g:3588:2: ( rule__HttpServerAceWrite__Group_11__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==52) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalAceGen.g:3588:3: rule__HttpServerAceWrite__Group_11__0
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
    // InternalAceGen.g:3596:1: rule__HttpServerAceWrite__Group__12 : rule__HttpServerAceWrite__Group__12__Impl ;
    public final void rule__HttpServerAceWrite__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3600:1: ( rule__HttpServerAceWrite__Group__12__Impl )
            // InternalAceGen.g:3601:2: rule__HttpServerAceWrite__Group__12__Impl
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
    // InternalAceGen.g:3607:1: rule__HttpServerAceWrite__Group__12__Impl : ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* ) ;
    public final void rule__HttpServerAceWrite__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3611:1: ( ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* ) )
            // InternalAceGen.g:3612:1: ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* )
            {
            // InternalAceGen.g:3612:1: ( ( rule__HttpServerAceWrite__OutcomesAssignment_12 )* )
            // InternalAceGen.g:3613:2: ( rule__HttpServerAceWrite__OutcomesAssignment_12 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getOutcomesAssignment_12()); 
            // InternalAceGen.g:3614:2: ( rule__HttpServerAceWrite__OutcomesAssignment_12 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==36) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalAceGen.g:3614:3: rule__HttpServerAceWrite__OutcomesAssignment_12
            	    {
            	    pushFollow(FOLLOW_9);
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
    // InternalAceGen.g:3623:1: rule__HttpServerAceWrite__Group_8__0 : rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1 ;
    public final void rule__HttpServerAceWrite__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3627:1: ( rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1 )
            // InternalAceGen.g:3628:2: rule__HttpServerAceWrite__Group_8__0__Impl rule__HttpServerAceWrite__Group_8__1
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
    // InternalAceGen.g:3635:1: rule__HttpServerAceWrite__Group_8__0__Impl : ( 'pathParams' ) ;
    public final void rule__HttpServerAceWrite__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3639:1: ( ( 'pathParams' ) )
            // InternalAceGen.g:3640:1: ( 'pathParams' )
            {
            // InternalAceGen.g:3640:1: ( 'pathParams' )
            // InternalAceGen.g:3641:2: 'pathParams'
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
    // InternalAceGen.g:3650:1: rule__HttpServerAceWrite__Group_8__1 : rule__HttpServerAceWrite__Group_8__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3654:1: ( rule__HttpServerAceWrite__Group_8__1__Impl )
            // InternalAceGen.g:3655:2: rule__HttpServerAceWrite__Group_8__1__Impl
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
    // InternalAceGen.g:3661:1: rule__HttpServerAceWrite__Group_8__1__Impl : ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3665:1: ( ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* ) )
            // InternalAceGen.g:3666:1: ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* )
            {
            // InternalAceGen.g:3666:1: ( ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )* )
            // InternalAceGen.g:3667:2: ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAssignment_8_1()); 
            // InternalAceGen.g:3668:2: ( rule__HttpServerAceWrite__PathParamsAssignment_8_1 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    int LA50_2 = input.LA(2);

                    if ( (LA50_2==EOF||LA50_2==RULE_ID||LA50_2==36||(LA50_2>=46 && LA50_2<=48)||(LA50_2>=50 && LA50_2<=52)||LA50_2==64||LA50_2==69) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // InternalAceGen.g:3668:3: rule__HttpServerAceWrite__PathParamsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:3677:1: rule__HttpServerAceWrite__Group_9__0 : rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1 ;
    public final void rule__HttpServerAceWrite__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3681:1: ( rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1 )
            // InternalAceGen.g:3682:2: rule__HttpServerAceWrite__Group_9__0__Impl rule__HttpServerAceWrite__Group_9__1
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
    // InternalAceGen.g:3689:1: rule__HttpServerAceWrite__Group_9__0__Impl : ( 'queryParams' ) ;
    public final void rule__HttpServerAceWrite__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3693:1: ( ( 'queryParams' ) )
            // InternalAceGen.g:3694:1: ( 'queryParams' )
            {
            // InternalAceGen.g:3694:1: ( 'queryParams' )
            // InternalAceGen.g:3695:2: 'queryParams'
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
    // InternalAceGen.g:3704:1: rule__HttpServerAceWrite__Group_9__1 : rule__HttpServerAceWrite__Group_9__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3708:1: ( rule__HttpServerAceWrite__Group_9__1__Impl )
            // InternalAceGen.g:3709:2: rule__HttpServerAceWrite__Group_9__1__Impl
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
    // InternalAceGen.g:3715:1: rule__HttpServerAceWrite__Group_9__1__Impl : ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3719:1: ( ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* ) )
            // InternalAceGen.g:3720:1: ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* )
            {
            // InternalAceGen.g:3720:1: ( ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )* )
            // InternalAceGen.g:3721:2: ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAssignment_9_1()); 
            // InternalAceGen.g:3722:2: ( rule__HttpServerAceWrite__QueryParamsAssignment_9_1 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID) ) {
                    int LA51_2 = input.LA(2);

                    if ( (LA51_2==EOF||LA51_2==RULE_ID||LA51_2==36||(LA51_2>=46 && LA51_2<=48)||(LA51_2>=51 && LA51_2<=52)||LA51_2==64||LA51_2==69) ) {
                        alt51=1;
                    }


                }


                switch (alt51) {
            	case 1 :
            	    // InternalAceGen.g:3722:3: rule__HttpServerAceWrite__QueryParamsAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:3731:1: rule__HttpServerAceWrite__Group_10__0 : rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1 ;
    public final void rule__HttpServerAceWrite__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3735:1: ( rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1 )
            // InternalAceGen.g:3736:2: rule__HttpServerAceWrite__Group_10__0__Impl rule__HttpServerAceWrite__Group_10__1
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
    // InternalAceGen.g:3743:1: rule__HttpServerAceWrite__Group_10__0__Impl : ( 'payload' ) ;
    public final void rule__HttpServerAceWrite__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3747:1: ( ( 'payload' ) )
            // InternalAceGen.g:3748:1: ( 'payload' )
            {
            // InternalAceGen.g:3748:1: ( 'payload' )
            // InternalAceGen.g:3749:2: 'payload'
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
    // InternalAceGen.g:3758:1: rule__HttpServerAceWrite__Group_10__1 : rule__HttpServerAceWrite__Group_10__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3762:1: ( rule__HttpServerAceWrite__Group_10__1__Impl )
            // InternalAceGen.g:3763:2: rule__HttpServerAceWrite__Group_10__1__Impl
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
    // InternalAceGen.g:3769:1: rule__HttpServerAceWrite__Group_10__1__Impl : ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3773:1: ( ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* ) )
            // InternalAceGen.g:3774:1: ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* )
            {
            // InternalAceGen.g:3774:1: ( ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )* )
            // InternalAceGen.g:3775:2: ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadAssignment_10_1()); 
            // InternalAceGen.g:3776:2: ( rule__HttpServerAceWrite__PayloadAssignment_10_1 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    int LA52_2 = input.LA(2);

                    if ( (LA52_2==EOF||LA52_2==RULE_ID||LA52_2==36||(LA52_2>=46 && LA52_2<=48)||LA52_2==52||LA52_2==64||LA52_2==69) ) {
                        alt52=1;
                    }


                }


                switch (alt52) {
            	case 1 :
            	    // InternalAceGen.g:3776:3: rule__HttpServerAceWrite__PayloadAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:3785:1: rule__HttpServerAceWrite__Group_11__0 : rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1 ;
    public final void rule__HttpServerAceWrite__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3789:1: ( rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1 )
            // InternalAceGen.g:3790:2: rule__HttpServerAceWrite__Group_11__0__Impl rule__HttpServerAceWrite__Group_11__1
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
    // InternalAceGen.g:3797:1: rule__HttpServerAceWrite__Group_11__0__Impl : ( 'response' ) ;
    public final void rule__HttpServerAceWrite__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3801:1: ( ( 'response' ) )
            // InternalAceGen.g:3802:1: ( 'response' )
            {
            // InternalAceGen.g:3802:1: ( 'response' )
            // InternalAceGen.g:3803:2: 'response'
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
    // InternalAceGen.g:3812:1: rule__HttpServerAceWrite__Group_11__1 : rule__HttpServerAceWrite__Group_11__1__Impl ;
    public final void rule__HttpServerAceWrite__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3816:1: ( rule__HttpServerAceWrite__Group_11__1__Impl )
            // InternalAceGen.g:3817:2: rule__HttpServerAceWrite__Group_11__1__Impl
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
    // InternalAceGen.g:3823:1: rule__HttpServerAceWrite__Group_11__1__Impl : ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* ) ;
    public final void rule__HttpServerAceWrite__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3827:1: ( ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* ) )
            // InternalAceGen.g:3828:1: ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* )
            {
            // InternalAceGen.g:3828:1: ( ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )* )
            // InternalAceGen.g:3829:2: ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )*
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseAssignment_11_1()); 
            // InternalAceGen.g:3830:2: ( rule__HttpServerAceWrite__ResponseAssignment_11_1 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID) ) {
                    int LA53_2 = input.LA(2);

                    if ( (LA53_2==EOF||LA53_2==RULE_ID||LA53_2==36||(LA53_2>=46 && LA53_2<=48)||LA53_2==64||LA53_2==69) ) {
                        alt53=1;
                    }


                }


                switch (alt53) {
            	case 1 :
            	    // InternalAceGen.g:3830:3: rule__HttpServerAceWrite__ResponseAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:3839:1: rule__HttpServerOutcome__Group__0 : rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1 ;
    public final void rule__HttpServerOutcome__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3843:1: ( rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1 )
            // InternalAceGen.g:3844:2: rule__HttpServerOutcome__Group__0__Impl rule__HttpServerOutcome__Group__1
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
    // InternalAceGen.g:3851:1: rule__HttpServerOutcome__Group__0__Impl : ( 'on' ) ;
    public final void rule__HttpServerOutcome__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3855:1: ( ( 'on' ) )
            // InternalAceGen.g:3856:1: ( 'on' )
            {
            // InternalAceGen.g:3856:1: ( 'on' )
            // InternalAceGen.g:3857:2: 'on'
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
    // InternalAceGen.g:3866:1: rule__HttpServerOutcome__Group__1 : rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2 ;
    public final void rule__HttpServerOutcome__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3870:1: ( rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2 )
            // InternalAceGen.g:3871:2: rule__HttpServerOutcome__Group__1__Impl rule__HttpServerOutcome__Group__2
            {
            pushFollow(FOLLOW_15);
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
    // InternalAceGen.g:3878:1: rule__HttpServerOutcome__Group__1__Impl : ( ( rule__HttpServerOutcome__NameAssignment_1 ) ) ;
    public final void rule__HttpServerOutcome__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3882:1: ( ( ( rule__HttpServerOutcome__NameAssignment_1 ) ) )
            // InternalAceGen.g:3883:1: ( ( rule__HttpServerOutcome__NameAssignment_1 ) )
            {
            // InternalAceGen.g:3883:1: ( ( rule__HttpServerOutcome__NameAssignment_1 ) )
            // InternalAceGen.g:3884:2: ( rule__HttpServerOutcome__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getNameAssignment_1()); 
            // InternalAceGen.g:3885:2: ( rule__HttpServerOutcome__NameAssignment_1 )
            // InternalAceGen.g:3885:3: rule__HttpServerOutcome__NameAssignment_1
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
    // InternalAceGen.g:3893:1: rule__HttpServerOutcome__Group__2 : rule__HttpServerOutcome__Group__2__Impl ;
    public final void rule__HttpServerOutcome__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3897:1: ( rule__HttpServerOutcome__Group__2__Impl )
            // InternalAceGen.g:3898:2: rule__HttpServerOutcome__Group__2__Impl
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
    // InternalAceGen.g:3904:1: rule__HttpServerOutcome__Group__2__Impl : ( ( rule__HttpServerOutcome__Group_2__0 )* ) ;
    public final void rule__HttpServerOutcome__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3908:1: ( ( ( rule__HttpServerOutcome__Group_2__0 )* ) )
            // InternalAceGen.g:3909:1: ( ( rule__HttpServerOutcome__Group_2__0 )* )
            {
            // InternalAceGen.g:3909:1: ( ( rule__HttpServerOutcome__Group_2__0 )* )
            // InternalAceGen.g:3910:2: ( rule__HttpServerOutcome__Group_2__0 )*
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getGroup_2()); 
            // InternalAceGen.g:3911:2: ( rule__HttpServerOutcome__Group_2__0 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==37) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalAceGen.g:3911:3: rule__HttpServerOutcome__Group_2__0
            	    {
            	    pushFollow(FOLLOW_34);
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
    // InternalAceGen.g:3920:1: rule__HttpServerOutcome__Group_2__0 : rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1 ;
    public final void rule__HttpServerOutcome__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3924:1: ( rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1 )
            // InternalAceGen.g:3925:2: rule__HttpServerOutcome__Group_2__0__Impl rule__HttpServerOutcome__Group_2__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalAceGen.g:3932:1: rule__HttpServerOutcome__Group_2__0__Impl : ( '(' ) ;
    public final void rule__HttpServerOutcome__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3936:1: ( ( '(' ) )
            // InternalAceGen.g:3937:1: ( '(' )
            {
            // InternalAceGen.g:3937:1: ( '(' )
            // InternalAceGen.g:3938:2: '('
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
    // InternalAceGen.g:3947:1: rule__HttpServerOutcome__Group_2__1 : rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2 ;
    public final void rule__HttpServerOutcome__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3951:1: ( rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2 )
            // InternalAceGen.g:3952:2: rule__HttpServerOutcome__Group_2__1__Impl rule__HttpServerOutcome__Group_2__2
            {
            pushFollow(FOLLOW_16);
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
    // InternalAceGen.g:3959:1: rule__HttpServerOutcome__Group_2__1__Impl : ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* ) ;
    public final void rule__HttpServerOutcome__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3963:1: ( ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* ) )
            // InternalAceGen.g:3964:1: ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* )
            {
            // InternalAceGen.g:3964:1: ( ( rule__HttpServerOutcome__ListenersAssignment_2_1 )* )
            // InternalAceGen.g:3965:2: ( rule__HttpServerOutcome__ListenersAssignment_2_1 )*
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getListenersAssignment_2_1()); 
            // InternalAceGen.g:3966:2: ( rule__HttpServerOutcome__ListenersAssignment_2_1 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_ID) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalAceGen.g:3966:3: rule__HttpServerOutcome__ListenersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:3974:1: rule__HttpServerOutcome__Group_2__2 : rule__HttpServerOutcome__Group_2__2__Impl ;
    public final void rule__HttpServerOutcome__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3978:1: ( rule__HttpServerOutcome__Group_2__2__Impl )
            // InternalAceGen.g:3979:2: rule__HttpServerOutcome__Group_2__2__Impl
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
    // InternalAceGen.g:3985:1: rule__HttpServerOutcome__Group_2__2__Impl : ( ')' ) ;
    public final void rule__HttpServerOutcome__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:3989:1: ( ( ')' ) )
            // InternalAceGen.g:3990:1: ( ')' )
            {
            // InternalAceGen.g:3990:1: ( ')' )
            // InternalAceGen.g:3991:2: ')'
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
    // InternalAceGen.g:4001:1: rule__HttpServerAceRead__Group__0 : rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1 ;
    public final void rule__HttpServerAceRead__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4005:1: ( rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1 )
            // InternalAceGen.g:4006:2: rule__HttpServerAceRead__Group__0__Impl rule__HttpServerAceRead__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalAceGen.g:4013:1: rule__HttpServerAceRead__Group__0__Impl : ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? ) ;
    public final void rule__HttpServerAceRead__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4017:1: ( ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? ) )
            // InternalAceGen.g:4018:1: ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? )
            {
            // InternalAceGen.g:4018:1: ( ( rule__HttpServerAceRead__ProxyAssignment_0 )? )
            // InternalAceGen.g:4019:2: ( rule__HttpServerAceRead__ProxyAssignment_0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyAssignment_0()); 
            // InternalAceGen.g:4020:2: ( rule__HttpServerAceRead__ProxyAssignment_0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==69) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalAceGen.g:4020:3: rule__HttpServerAceRead__ProxyAssignment_0
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
    // InternalAceGen.g:4028:1: rule__HttpServerAceRead__Group__1 : rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2 ;
    public final void rule__HttpServerAceRead__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4032:1: ( rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2 )
            // InternalAceGen.g:4033:2: rule__HttpServerAceRead__Group__1__Impl rule__HttpServerAceRead__Group__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalAceGen.g:4040:1: rule__HttpServerAceRead__Group__1__Impl : ( ( rule__HttpServerAceRead__NameAssignment_1 ) ) ;
    public final void rule__HttpServerAceRead__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4044:1: ( ( ( rule__HttpServerAceRead__NameAssignment_1 ) ) )
            // InternalAceGen.g:4045:1: ( ( rule__HttpServerAceRead__NameAssignment_1 ) )
            {
            // InternalAceGen.g:4045:1: ( ( rule__HttpServerAceRead__NameAssignment_1 ) )
            // InternalAceGen.g:4046:2: ( rule__HttpServerAceRead__NameAssignment_1 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getNameAssignment_1()); 
            // InternalAceGen.g:4047:2: ( rule__HttpServerAceRead__NameAssignment_1 )
            // InternalAceGen.g:4047:3: rule__HttpServerAceRead__NameAssignment_1
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
    // InternalAceGen.g:4055:1: rule__HttpServerAceRead__Group__2 : rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3 ;
    public final void rule__HttpServerAceRead__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4059:1: ( rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3 )
            // InternalAceGen.g:4060:2: rule__HttpServerAceRead__Group__2__Impl rule__HttpServerAceRead__Group__3
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
    // InternalAceGen.g:4067:1: rule__HttpServerAceRead__Group__2__Impl : ( '<' ) ;
    public final void rule__HttpServerAceRead__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4071:1: ( ( '<' ) )
            // InternalAceGen.g:4072:1: ( '<' )
            {
            // InternalAceGen.g:4072:1: ( '<' )
            // InternalAceGen.g:4073:2: '<'
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
    // InternalAceGen.g:4082:1: rule__HttpServerAceRead__Group__3 : rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4 ;
    public final void rule__HttpServerAceRead__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4086:1: ( rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4 )
            // InternalAceGen.g:4087:2: rule__HttpServerAceRead__Group__3__Impl rule__HttpServerAceRead__Group__4
            {
            pushFollow(FOLLOW_30);
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
    // InternalAceGen.g:4094:1: rule__HttpServerAceRead__Group__3__Impl : ( ( rule__HttpServerAceRead__ModelAssignment_3 ) ) ;
    public final void rule__HttpServerAceRead__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4098:1: ( ( ( rule__HttpServerAceRead__ModelAssignment_3 ) ) )
            // InternalAceGen.g:4099:1: ( ( rule__HttpServerAceRead__ModelAssignment_3 ) )
            {
            // InternalAceGen.g:4099:1: ( ( rule__HttpServerAceRead__ModelAssignment_3 ) )
            // InternalAceGen.g:4100:2: ( rule__HttpServerAceRead__ModelAssignment_3 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getModelAssignment_3()); 
            // InternalAceGen.g:4101:2: ( rule__HttpServerAceRead__ModelAssignment_3 )
            // InternalAceGen.g:4101:3: rule__HttpServerAceRead__ModelAssignment_3
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
    // InternalAceGen.g:4109:1: rule__HttpServerAceRead__Group__4 : rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5 ;
    public final void rule__HttpServerAceRead__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4113:1: ( rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5 )
            // InternalAceGen.g:4114:2: rule__HttpServerAceRead__Group__4__Impl rule__HttpServerAceRead__Group__5
            {
            pushFollow(FOLLOW_35);
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
    // InternalAceGen.g:4121:1: rule__HttpServerAceRead__Group__4__Impl : ( '>' ) ;
    public final void rule__HttpServerAceRead__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4125:1: ( ( '>' ) )
            // InternalAceGen.g:4126:1: ( '>' )
            {
            // InternalAceGen.g:4126:1: ( '>' )
            // InternalAceGen.g:4127:2: '>'
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
    // InternalAceGen.g:4136:1: rule__HttpServerAceRead__Group__5 : rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6 ;
    public final void rule__HttpServerAceRead__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4140:1: ( rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6 )
            // InternalAceGen.g:4141:2: rule__HttpServerAceRead__Group__5__Impl rule__HttpServerAceRead__Group__6
            {
            pushFollow(FOLLOW_32);
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
    // InternalAceGen.g:4148:1: rule__HttpServerAceRead__Group__5__Impl : ( ( rule__HttpServerAceRead__TypeAssignment_5 ) ) ;
    public final void rule__HttpServerAceRead__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4152:1: ( ( ( rule__HttpServerAceRead__TypeAssignment_5 ) ) )
            // InternalAceGen.g:4153:1: ( ( rule__HttpServerAceRead__TypeAssignment_5 ) )
            {
            // InternalAceGen.g:4153:1: ( ( rule__HttpServerAceRead__TypeAssignment_5 ) )
            // InternalAceGen.g:4154:2: ( rule__HttpServerAceRead__TypeAssignment_5 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getTypeAssignment_5()); 
            // InternalAceGen.g:4155:2: ( rule__HttpServerAceRead__TypeAssignment_5 )
            // InternalAceGen.g:4155:3: rule__HttpServerAceRead__TypeAssignment_5
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
    // InternalAceGen.g:4163:1: rule__HttpServerAceRead__Group__6 : rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7 ;
    public final void rule__HttpServerAceRead__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4167:1: ( rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7 )
            // InternalAceGen.g:4168:2: rule__HttpServerAceRead__Group__6__Impl rule__HttpServerAceRead__Group__7
            {
            pushFollow(FOLLOW_36);
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
    // InternalAceGen.g:4175:1: rule__HttpServerAceRead__Group__6__Impl : ( ( rule__HttpServerAceRead__UrlAssignment_6 ) ) ;
    public final void rule__HttpServerAceRead__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4179:1: ( ( ( rule__HttpServerAceRead__UrlAssignment_6 ) ) )
            // InternalAceGen.g:4180:1: ( ( rule__HttpServerAceRead__UrlAssignment_6 ) )
            {
            // InternalAceGen.g:4180:1: ( ( rule__HttpServerAceRead__UrlAssignment_6 ) )
            // InternalAceGen.g:4181:2: ( rule__HttpServerAceRead__UrlAssignment_6 )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getUrlAssignment_6()); 
            // InternalAceGen.g:4182:2: ( rule__HttpServerAceRead__UrlAssignment_6 )
            // InternalAceGen.g:4182:3: rule__HttpServerAceRead__UrlAssignment_6
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
    // InternalAceGen.g:4190:1: rule__HttpServerAceRead__Group__7 : rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8 ;
    public final void rule__HttpServerAceRead__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4194:1: ( rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8 )
            // InternalAceGen.g:4195:2: rule__HttpServerAceRead__Group__7__Impl rule__HttpServerAceRead__Group__8
            {
            pushFollow(FOLLOW_36);
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
    // InternalAceGen.g:4202:1: rule__HttpServerAceRead__Group__7__Impl : ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? ) ;
    public final void rule__HttpServerAceRead__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4206:1: ( ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? ) )
            // InternalAceGen.g:4207:1: ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? )
            {
            // InternalAceGen.g:4207:1: ( ( rule__HttpServerAceRead__AuthorizeAssignment_7 )? )
            // InternalAceGen.g:4208:2: ( rule__HttpServerAceRead__AuthorizeAssignment_7 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAssignment_7()); 
            // InternalAceGen.g:4209:2: ( rule__HttpServerAceRead__AuthorizeAssignment_7 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==70) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalAceGen.g:4209:3: rule__HttpServerAceRead__AuthorizeAssignment_7
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
    // InternalAceGen.g:4217:1: rule__HttpServerAceRead__Group__8 : rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9 ;
    public final void rule__HttpServerAceRead__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4221:1: ( rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9 )
            // InternalAceGen.g:4222:2: rule__HttpServerAceRead__Group__8__Impl rule__HttpServerAceRead__Group__9
            {
            pushFollow(FOLLOW_36);
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
    // InternalAceGen.g:4229:1: rule__HttpServerAceRead__Group__8__Impl : ( ( rule__HttpServerAceRead__Group_8__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4233:1: ( ( ( rule__HttpServerAceRead__Group_8__0 )? ) )
            // InternalAceGen.g:4234:1: ( ( rule__HttpServerAceRead__Group_8__0 )? )
            {
            // InternalAceGen.g:4234:1: ( ( rule__HttpServerAceRead__Group_8__0 )? )
            // InternalAceGen.g:4235:2: ( rule__HttpServerAceRead__Group_8__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_8()); 
            // InternalAceGen.g:4236:2: ( rule__HttpServerAceRead__Group_8__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==49) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalAceGen.g:4236:3: rule__HttpServerAceRead__Group_8__0
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
    // InternalAceGen.g:4244:1: rule__HttpServerAceRead__Group__9 : rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10 ;
    public final void rule__HttpServerAceRead__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4248:1: ( rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10 )
            // InternalAceGen.g:4249:2: rule__HttpServerAceRead__Group__9__Impl rule__HttpServerAceRead__Group__10
            {
            pushFollow(FOLLOW_36);
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
    // InternalAceGen.g:4256:1: rule__HttpServerAceRead__Group__9__Impl : ( ( rule__HttpServerAceRead__Group_9__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4260:1: ( ( ( rule__HttpServerAceRead__Group_9__0 )? ) )
            // InternalAceGen.g:4261:1: ( ( rule__HttpServerAceRead__Group_9__0 )? )
            {
            // InternalAceGen.g:4261:1: ( ( rule__HttpServerAceRead__Group_9__0 )? )
            // InternalAceGen.g:4262:2: ( rule__HttpServerAceRead__Group_9__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_9()); 
            // InternalAceGen.g:4263:2: ( rule__HttpServerAceRead__Group_9__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==50) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalAceGen.g:4263:3: rule__HttpServerAceRead__Group_9__0
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
    // InternalAceGen.g:4271:1: rule__HttpServerAceRead__Group__10 : rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11 ;
    public final void rule__HttpServerAceRead__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4275:1: ( rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11 )
            // InternalAceGen.g:4276:2: rule__HttpServerAceRead__Group__10__Impl rule__HttpServerAceRead__Group__11
            {
            pushFollow(FOLLOW_36);
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
    // InternalAceGen.g:4283:1: rule__HttpServerAceRead__Group__10__Impl : ( ( rule__HttpServerAceRead__Group_10__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4287:1: ( ( ( rule__HttpServerAceRead__Group_10__0 )? ) )
            // InternalAceGen.g:4288:1: ( ( rule__HttpServerAceRead__Group_10__0 )? )
            {
            // InternalAceGen.g:4288:1: ( ( rule__HttpServerAceRead__Group_10__0 )? )
            // InternalAceGen.g:4289:2: ( rule__HttpServerAceRead__Group_10__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_10()); 
            // InternalAceGen.g:4290:2: ( rule__HttpServerAceRead__Group_10__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==51) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalAceGen.g:4290:3: rule__HttpServerAceRead__Group_10__0
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
    // InternalAceGen.g:4298:1: rule__HttpServerAceRead__Group__11 : rule__HttpServerAceRead__Group__11__Impl ;
    public final void rule__HttpServerAceRead__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4302:1: ( rule__HttpServerAceRead__Group__11__Impl )
            // InternalAceGen.g:4303:2: rule__HttpServerAceRead__Group__11__Impl
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
    // InternalAceGen.g:4309:1: rule__HttpServerAceRead__Group__11__Impl : ( ( rule__HttpServerAceRead__Group_11__0 )? ) ;
    public final void rule__HttpServerAceRead__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4313:1: ( ( ( rule__HttpServerAceRead__Group_11__0 )? ) )
            // InternalAceGen.g:4314:1: ( ( rule__HttpServerAceRead__Group_11__0 )? )
            {
            // InternalAceGen.g:4314:1: ( ( rule__HttpServerAceRead__Group_11__0 )? )
            // InternalAceGen.g:4315:2: ( rule__HttpServerAceRead__Group_11__0 )?
            {
             before(grammarAccess.getHttpServerAceReadAccess().getGroup_11()); 
            // InternalAceGen.g:4316:2: ( rule__HttpServerAceRead__Group_11__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==52) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalAceGen.g:4316:3: rule__HttpServerAceRead__Group_11__0
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
    // InternalAceGen.g:4325:1: rule__HttpServerAceRead__Group_8__0 : rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1 ;
    public final void rule__HttpServerAceRead__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4329:1: ( rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1 )
            // InternalAceGen.g:4330:2: rule__HttpServerAceRead__Group_8__0__Impl rule__HttpServerAceRead__Group_8__1
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
    // InternalAceGen.g:4337:1: rule__HttpServerAceRead__Group_8__0__Impl : ( 'pathParams' ) ;
    public final void rule__HttpServerAceRead__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4341:1: ( ( 'pathParams' ) )
            // InternalAceGen.g:4342:1: ( 'pathParams' )
            {
            // InternalAceGen.g:4342:1: ( 'pathParams' )
            // InternalAceGen.g:4343:2: 'pathParams'
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
    // InternalAceGen.g:4352:1: rule__HttpServerAceRead__Group_8__1 : rule__HttpServerAceRead__Group_8__1__Impl ;
    public final void rule__HttpServerAceRead__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4356:1: ( rule__HttpServerAceRead__Group_8__1__Impl )
            // InternalAceGen.g:4357:2: rule__HttpServerAceRead__Group_8__1__Impl
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
    // InternalAceGen.g:4363:1: rule__HttpServerAceRead__Group_8__1__Impl : ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4367:1: ( ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* ) )
            // InternalAceGen.g:4368:1: ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* )
            {
            // InternalAceGen.g:4368:1: ( ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )* )
            // InternalAceGen.g:4369:2: ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsAssignment_8_1()); 
            // InternalAceGen.g:4370:2: ( rule__HttpServerAceRead__PathParamsAssignment_8_1 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID) ) {
                    int LA62_2 = input.LA(2);

                    if ( (LA62_2==EOF||LA62_2==RULE_ID||(LA62_2>=46 && LA62_2<=48)||(LA62_2>=50 && LA62_2<=52)||LA62_2==64||LA62_2==69) ) {
                        alt62=1;
                    }


                }


                switch (alt62) {
            	case 1 :
            	    // InternalAceGen.g:4370:3: rule__HttpServerAceRead__PathParamsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:4379:1: rule__HttpServerAceRead__Group_9__0 : rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1 ;
    public final void rule__HttpServerAceRead__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4383:1: ( rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1 )
            // InternalAceGen.g:4384:2: rule__HttpServerAceRead__Group_9__0__Impl rule__HttpServerAceRead__Group_9__1
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
    // InternalAceGen.g:4391:1: rule__HttpServerAceRead__Group_9__0__Impl : ( 'queryParams' ) ;
    public final void rule__HttpServerAceRead__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4395:1: ( ( 'queryParams' ) )
            // InternalAceGen.g:4396:1: ( 'queryParams' )
            {
            // InternalAceGen.g:4396:1: ( 'queryParams' )
            // InternalAceGen.g:4397:2: 'queryParams'
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
    // InternalAceGen.g:4406:1: rule__HttpServerAceRead__Group_9__1 : rule__HttpServerAceRead__Group_9__1__Impl ;
    public final void rule__HttpServerAceRead__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4410:1: ( rule__HttpServerAceRead__Group_9__1__Impl )
            // InternalAceGen.g:4411:2: rule__HttpServerAceRead__Group_9__1__Impl
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
    // InternalAceGen.g:4417:1: rule__HttpServerAceRead__Group_9__1__Impl : ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4421:1: ( ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* ) )
            // InternalAceGen.g:4422:1: ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* )
            {
            // InternalAceGen.g:4422:1: ( ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )* )
            // InternalAceGen.g:4423:2: ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAssignment_9_1()); 
            // InternalAceGen.g:4424:2: ( rule__HttpServerAceRead__QueryParamsAssignment_9_1 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ID) ) {
                    int LA63_2 = input.LA(2);

                    if ( (LA63_2==EOF||LA63_2==RULE_ID||(LA63_2>=46 && LA63_2<=48)||(LA63_2>=51 && LA63_2<=52)||LA63_2==64||LA63_2==69) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // InternalAceGen.g:4424:3: rule__HttpServerAceRead__QueryParamsAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:4433:1: rule__HttpServerAceRead__Group_10__0 : rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1 ;
    public final void rule__HttpServerAceRead__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4437:1: ( rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1 )
            // InternalAceGen.g:4438:2: rule__HttpServerAceRead__Group_10__0__Impl rule__HttpServerAceRead__Group_10__1
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
    // InternalAceGen.g:4445:1: rule__HttpServerAceRead__Group_10__0__Impl : ( 'payload' ) ;
    public final void rule__HttpServerAceRead__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4449:1: ( ( 'payload' ) )
            // InternalAceGen.g:4450:1: ( 'payload' )
            {
            // InternalAceGen.g:4450:1: ( 'payload' )
            // InternalAceGen.g:4451:2: 'payload'
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
    // InternalAceGen.g:4460:1: rule__HttpServerAceRead__Group_10__1 : rule__HttpServerAceRead__Group_10__1__Impl ;
    public final void rule__HttpServerAceRead__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4464:1: ( rule__HttpServerAceRead__Group_10__1__Impl )
            // InternalAceGen.g:4465:2: rule__HttpServerAceRead__Group_10__1__Impl
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
    // InternalAceGen.g:4471:1: rule__HttpServerAceRead__Group_10__1__Impl : ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4475:1: ( ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* ) )
            // InternalAceGen.g:4476:1: ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* )
            {
            // InternalAceGen.g:4476:1: ( ( rule__HttpServerAceRead__PayloadAssignment_10_1 )* )
            // InternalAceGen.g:4477:2: ( rule__HttpServerAceRead__PayloadAssignment_10_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadAssignment_10_1()); 
            // InternalAceGen.g:4478:2: ( rule__HttpServerAceRead__PayloadAssignment_10_1 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID) ) {
                    int LA64_2 = input.LA(2);

                    if ( (LA64_2==EOF||LA64_2==RULE_ID||(LA64_2>=46 && LA64_2<=48)||LA64_2==52||LA64_2==64||LA64_2==69) ) {
                        alt64=1;
                    }


                }


                switch (alt64) {
            	case 1 :
            	    // InternalAceGen.g:4478:3: rule__HttpServerAceRead__PayloadAssignment_10_1
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:4487:1: rule__HttpServerAceRead__Group_11__0 : rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1 ;
    public final void rule__HttpServerAceRead__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4491:1: ( rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1 )
            // InternalAceGen.g:4492:2: rule__HttpServerAceRead__Group_11__0__Impl rule__HttpServerAceRead__Group_11__1
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
    // InternalAceGen.g:4499:1: rule__HttpServerAceRead__Group_11__0__Impl : ( 'response' ) ;
    public final void rule__HttpServerAceRead__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4503:1: ( ( 'response' ) )
            // InternalAceGen.g:4504:1: ( 'response' )
            {
            // InternalAceGen.g:4504:1: ( 'response' )
            // InternalAceGen.g:4505:2: 'response'
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
    // InternalAceGen.g:4514:1: rule__HttpServerAceRead__Group_11__1 : rule__HttpServerAceRead__Group_11__1__Impl ;
    public final void rule__HttpServerAceRead__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4518:1: ( rule__HttpServerAceRead__Group_11__1__Impl )
            // InternalAceGen.g:4519:2: rule__HttpServerAceRead__Group_11__1__Impl
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
    // InternalAceGen.g:4525:1: rule__HttpServerAceRead__Group_11__1__Impl : ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* ) ;
    public final void rule__HttpServerAceRead__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4529:1: ( ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* ) )
            // InternalAceGen.g:4530:1: ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* )
            {
            // InternalAceGen.g:4530:1: ( ( rule__HttpServerAceRead__ResponseAssignment_11_1 )* )
            // InternalAceGen.g:4531:2: ( rule__HttpServerAceRead__ResponseAssignment_11_1 )*
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseAssignment_11_1()); 
            // InternalAceGen.g:4532:2: ( rule__HttpServerAceRead__ResponseAssignment_11_1 )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_ID) ) {
                    int LA65_2 = input.LA(2);

                    if ( (LA65_2==EOF||LA65_2==RULE_ID||(LA65_2>=46 && LA65_2<=48)||LA65_2==64||LA65_2==69) ) {
                        alt65=1;
                    }


                }


                switch (alt65) {
            	case 1 :
            	    // InternalAceGen.g:4532:3: rule__HttpServerAceRead__ResponseAssignment_11_1
            	    {
            	    pushFollow(FOLLOW_17);
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


    // $ANTLR start "rule__HttpServerView__Group__0"
    // InternalAceGen.g:4541:1: rule__HttpServerView__Group__0 : rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1 ;
    public final void rule__HttpServerView__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4545:1: ( rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1 )
            // InternalAceGen.g:4546:2: rule__HttpServerView__Group__0__Impl rule__HttpServerView__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalAceGen.g:4553:1: rule__HttpServerView__Group__0__Impl : ( ( rule__HttpServerView__NameAssignment_0 ) ) ;
    public final void rule__HttpServerView__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4557:1: ( ( ( rule__HttpServerView__NameAssignment_0 ) ) )
            // InternalAceGen.g:4558:1: ( ( rule__HttpServerView__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4558:1: ( ( rule__HttpServerView__NameAssignment_0 ) )
            // InternalAceGen.g:4559:2: ( rule__HttpServerView__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerViewAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4560:2: ( rule__HttpServerView__NameAssignment_0 )
            // InternalAceGen.g:4560:3: rule__HttpServerView__NameAssignment_0
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
    // InternalAceGen.g:4568:1: rule__HttpServerView__Group__1 : rule__HttpServerView__Group__1__Impl ;
    public final void rule__HttpServerView__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4572:1: ( rule__HttpServerView__Group__1__Impl )
            // InternalAceGen.g:4573:2: rule__HttpServerView__Group__1__Impl
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
    // InternalAceGen.g:4579:1: rule__HttpServerView__Group__1__Impl : ( ( rule__HttpServerView__Group_1__0 )? ) ;
    public final void rule__HttpServerView__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4583:1: ( ( ( rule__HttpServerView__Group_1__0 )? ) )
            // InternalAceGen.g:4584:1: ( ( rule__HttpServerView__Group_1__0 )? )
            {
            // InternalAceGen.g:4584:1: ( ( rule__HttpServerView__Group_1__0 )? )
            // InternalAceGen.g:4585:2: ( rule__HttpServerView__Group_1__0 )?
            {
             before(grammarAccess.getHttpServerViewAccess().getGroup_1()); 
            // InternalAceGen.g:4586:2: ( rule__HttpServerView__Group_1__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==42) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalAceGen.g:4586:3: rule__HttpServerView__Group_1__0
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
    // InternalAceGen.g:4595:1: rule__HttpServerView__Group_1__0 : rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1 ;
    public final void rule__HttpServerView__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4599:1: ( rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1 )
            // InternalAceGen.g:4600:2: rule__HttpServerView__Group_1__0__Impl rule__HttpServerView__Group_1__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalAceGen.g:4607:1: rule__HttpServerView__Group_1__0__Impl : ( '{' ) ;
    public final void rule__HttpServerView__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4611:1: ( ( '{' ) )
            // InternalAceGen.g:4612:1: ( '{' )
            {
            // InternalAceGen.g:4612:1: ( '{' )
            // InternalAceGen.g:4613:2: '{'
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
    // InternalAceGen.g:4622:1: rule__HttpServerView__Group_1__1 : rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2 ;
    public final void rule__HttpServerView__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4626:1: ( rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2 )
            // InternalAceGen.g:4627:2: rule__HttpServerView__Group_1__1__Impl rule__HttpServerView__Group_1__2
            {
            pushFollow(FOLLOW_23);
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
    // InternalAceGen.g:4634:1: rule__HttpServerView__Group_1__1__Impl : ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* ) ;
    public final void rule__HttpServerView__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4638:1: ( ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* ) )
            // InternalAceGen.g:4639:1: ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* )
            {
            // InternalAceGen.g:4639:1: ( ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )* )
            // InternalAceGen.g:4640:2: ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )*
            {
             before(grammarAccess.getHttpServerViewAccess().getRenderFunctionsAssignment_1_1()); 
            // InternalAceGen.g:4641:2: ( rule__HttpServerView__RenderFunctionsAssignment_1_1 )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==RULE_ID) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalAceGen.g:4641:3: rule__HttpServerView__RenderFunctionsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:4649:1: rule__HttpServerView__Group_1__2 : rule__HttpServerView__Group_1__2__Impl ;
    public final void rule__HttpServerView__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4653:1: ( rule__HttpServerView__Group_1__2__Impl )
            // InternalAceGen.g:4654:2: rule__HttpServerView__Group_1__2__Impl
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
    // InternalAceGen.g:4660:1: rule__HttpServerView__Group_1__2__Impl : ( '}' ) ;
    public final void rule__HttpServerView__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4664:1: ( ( '}' ) )
            // InternalAceGen.g:4665:1: ( '}' )
            {
            // InternalAceGen.g:4665:1: ( '}' )
            // InternalAceGen.g:4666:2: '}'
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
    // InternalAceGen.g:4676:1: rule__HttpServerViewFunction__Group__0 : rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1 ;
    public final void rule__HttpServerViewFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4680:1: ( rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1 )
            // InternalAceGen.g:4681:2: rule__HttpServerViewFunction__Group__0__Impl rule__HttpServerViewFunction__Group__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalAceGen.g:4688:1: rule__HttpServerViewFunction__Group__0__Impl : ( ( rule__HttpServerViewFunction__NameAssignment_0 ) ) ;
    public final void rule__HttpServerViewFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4692:1: ( ( ( rule__HttpServerViewFunction__NameAssignment_0 ) ) )
            // InternalAceGen.g:4693:1: ( ( rule__HttpServerViewFunction__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4693:1: ( ( rule__HttpServerViewFunction__NameAssignment_0 ) )
            // InternalAceGen.g:4694:2: ( rule__HttpServerViewFunction__NameAssignment_0 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4695:2: ( rule__HttpServerViewFunction__NameAssignment_0 )
            // InternalAceGen.g:4695:3: rule__HttpServerViewFunction__NameAssignment_0
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
    // InternalAceGen.g:4703:1: rule__HttpServerViewFunction__Group__1 : rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2 ;
    public final void rule__HttpServerViewFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4707:1: ( rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2 )
            // InternalAceGen.g:4708:2: rule__HttpServerViewFunction__Group__1__Impl rule__HttpServerViewFunction__Group__2
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
    // InternalAceGen.g:4715:1: rule__HttpServerViewFunction__Group__1__Impl : ( '(' ) ;
    public final void rule__HttpServerViewFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4719:1: ( ( '(' ) )
            // InternalAceGen.g:4720:1: ( '(' )
            {
            // InternalAceGen.g:4720:1: ( '(' )
            // InternalAceGen.g:4721:2: '('
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
    // InternalAceGen.g:4730:1: rule__HttpServerViewFunction__Group__2 : rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3 ;
    public final void rule__HttpServerViewFunction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4734:1: ( rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3 )
            // InternalAceGen.g:4735:2: rule__HttpServerViewFunction__Group__2__Impl rule__HttpServerViewFunction__Group__3
            {
            pushFollow(FOLLOW_37);
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
    // InternalAceGen.g:4742:1: rule__HttpServerViewFunction__Group__2__Impl : ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) ) ;
    public final void rule__HttpServerViewFunction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4746:1: ( ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) ) )
            // InternalAceGen.g:4747:1: ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) )
            {
            // InternalAceGen.g:4747:1: ( ( rule__HttpServerViewFunction__ModelAssignment_2 ) )
            // InternalAceGen.g:4748:2: ( rule__HttpServerViewFunction__ModelAssignment_2 )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getModelAssignment_2()); 
            // InternalAceGen.g:4749:2: ( rule__HttpServerViewFunction__ModelAssignment_2 )
            // InternalAceGen.g:4749:3: rule__HttpServerViewFunction__ModelAssignment_2
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
    // InternalAceGen.g:4757:1: rule__HttpServerViewFunction__Group__3 : rule__HttpServerViewFunction__Group__3__Impl ;
    public final void rule__HttpServerViewFunction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4761:1: ( rule__HttpServerViewFunction__Group__3__Impl )
            // InternalAceGen.g:4762:2: rule__HttpServerViewFunction__Group__3__Impl
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
    // InternalAceGen.g:4768:1: rule__HttpServerViewFunction__Group__3__Impl : ( ')' ) ;
    public final void rule__HttpServerViewFunction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4772:1: ( ( ')' ) )
            // InternalAceGen.g:4773:1: ( ')' )
            {
            // InternalAceGen.g:4773:1: ( ')' )
            // InternalAceGen.g:4774:2: ')'
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
    // InternalAceGen.g:4784:1: rule__AuthUser__Group__0 : rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1 ;
    public final void rule__AuthUser__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4788:1: ( rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1 )
            // InternalAceGen.g:4789:2: rule__AuthUser__Group__0__Impl rule__AuthUser__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalAceGen.g:4796:1: rule__AuthUser__Group__0__Impl : ( ( rule__AuthUser__NameAssignment_0 ) ) ;
    public final void rule__AuthUser__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4800:1: ( ( ( rule__AuthUser__NameAssignment_0 ) ) )
            // InternalAceGen.g:4801:1: ( ( rule__AuthUser__NameAssignment_0 ) )
            {
            // InternalAceGen.g:4801:1: ( ( rule__AuthUser__NameAssignment_0 ) )
            // InternalAceGen.g:4802:2: ( rule__AuthUser__NameAssignment_0 )
            {
             before(grammarAccess.getAuthUserAccess().getNameAssignment_0()); 
            // InternalAceGen.g:4803:2: ( rule__AuthUser__NameAssignment_0 )
            // InternalAceGen.g:4803:3: rule__AuthUser__NameAssignment_0
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
    // InternalAceGen.g:4811:1: rule__AuthUser__Group__1 : rule__AuthUser__Group__1__Impl ;
    public final void rule__AuthUser__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4815:1: ( rule__AuthUser__Group__1__Impl )
            // InternalAceGen.g:4816:2: rule__AuthUser__Group__1__Impl
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
    // InternalAceGen.g:4822:1: rule__AuthUser__Group__1__Impl : ( ( rule__AuthUser__Group_1__0 ) ) ;
    public final void rule__AuthUser__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4826:1: ( ( ( rule__AuthUser__Group_1__0 ) ) )
            // InternalAceGen.g:4827:1: ( ( rule__AuthUser__Group_1__0 ) )
            {
            // InternalAceGen.g:4827:1: ( ( rule__AuthUser__Group_1__0 ) )
            // InternalAceGen.g:4828:2: ( rule__AuthUser__Group_1__0 )
            {
             before(grammarAccess.getAuthUserAccess().getGroup_1()); 
            // InternalAceGen.g:4829:2: ( rule__AuthUser__Group_1__0 )
            // InternalAceGen.g:4829:3: rule__AuthUser__Group_1__0
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
    // InternalAceGen.g:4838:1: rule__AuthUser__Group_1__0 : rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1 ;
    public final void rule__AuthUser__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4842:1: ( rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1 )
            // InternalAceGen.g:4843:2: rule__AuthUser__Group_1__0__Impl rule__AuthUser__Group_1__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalAceGen.g:4850:1: rule__AuthUser__Group_1__0__Impl : ( '{' ) ;
    public final void rule__AuthUser__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4854:1: ( ( '{' ) )
            // InternalAceGen.g:4855:1: ( '{' )
            {
            // InternalAceGen.g:4855:1: ( '{' )
            // InternalAceGen.g:4856:2: '{'
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
    // InternalAceGen.g:4865:1: rule__AuthUser__Group_1__1 : rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2 ;
    public final void rule__AuthUser__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4869:1: ( rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2 )
            // InternalAceGen.g:4870:2: rule__AuthUser__Group_1__1__Impl rule__AuthUser__Group_1__2
            {
            pushFollow(FOLLOW_38);
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
    // InternalAceGen.g:4877:1: rule__AuthUser__Group_1__1__Impl : ( ( rule__AuthUser__AttributesAssignment_1_1 )* ) ;
    public final void rule__AuthUser__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4881:1: ( ( ( rule__AuthUser__AttributesAssignment_1_1 )* ) )
            // InternalAceGen.g:4882:1: ( ( rule__AuthUser__AttributesAssignment_1_1 )* )
            {
            // InternalAceGen.g:4882:1: ( ( rule__AuthUser__AttributesAssignment_1_1 )* )
            // InternalAceGen.g:4883:2: ( rule__AuthUser__AttributesAssignment_1_1 )*
            {
             before(grammarAccess.getAuthUserAccess().getAttributesAssignment_1_1()); 
            // InternalAceGen.g:4884:2: ( rule__AuthUser__AttributesAssignment_1_1 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==RULE_ID||(LA68_0>=19 && LA68_0<=26)||(LA68_0>=72 && LA68_0<=74)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalAceGen.g:4884:3: rule__AuthUser__AttributesAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_39);
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
    // InternalAceGen.g:4892:1: rule__AuthUser__Group_1__2 : rule__AuthUser__Group_1__2__Impl ;
    public final void rule__AuthUser__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4896:1: ( rule__AuthUser__Group_1__2__Impl )
            // InternalAceGen.g:4897:2: rule__AuthUser__Group_1__2__Impl
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
    // InternalAceGen.g:4903:1: rule__AuthUser__Group_1__2__Impl : ( '}' ) ;
    public final void rule__AuthUser__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4907:1: ( ( '}' ) )
            // InternalAceGen.g:4908:1: ( '}' )
            {
            // InternalAceGen.g:4908:1: ( '}' )
            // InternalAceGen.g:4909:2: '}'
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
    // InternalAceGen.g:4919:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4923:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalAceGen.g:4924:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalAceGen.g:4931:1: rule__Model__Group__0__Impl : ( ( rule__Model__PersistentAssignment_0 )? ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4935:1: ( ( ( rule__Model__PersistentAssignment_0 )? ) )
            // InternalAceGen.g:4936:1: ( ( rule__Model__PersistentAssignment_0 )? )
            {
            // InternalAceGen.g:4936:1: ( ( rule__Model__PersistentAssignment_0 )? )
            // InternalAceGen.g:4937:2: ( rule__Model__PersistentAssignment_0 )?
            {
             before(grammarAccess.getModelAccess().getPersistentAssignment_0()); 
            // InternalAceGen.g:4938:2: ( rule__Model__PersistentAssignment_0 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==71) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalAceGen.g:4938:3: rule__Model__PersistentAssignment_0
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
    // InternalAceGen.g:4946:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4950:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalAceGen.g:4951:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_40);
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
    // InternalAceGen.g:4958:1: rule__Model__Group__1__Impl : ( ( rule__Model__NameAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4962:1: ( ( ( rule__Model__NameAssignment_1 ) ) )
            // InternalAceGen.g:4963:1: ( ( rule__Model__NameAssignment_1 ) )
            {
            // InternalAceGen.g:4963:1: ( ( rule__Model__NameAssignment_1 ) )
            // InternalAceGen.g:4964:2: ( rule__Model__NameAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1()); 
            // InternalAceGen.g:4965:2: ( rule__Model__NameAssignment_1 )
            // InternalAceGen.g:4965:3: rule__Model__NameAssignment_1
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
    // InternalAceGen.g:4973:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4977:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalAceGen.g:4978:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_40);
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
    // InternalAceGen.g:4985:1: rule__Model__Group__2__Impl : ( ( rule__Model__Group_2__0 )? ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:4989:1: ( ( ( rule__Model__Group_2__0 )? ) )
            // InternalAceGen.g:4990:1: ( ( rule__Model__Group_2__0 )? )
            {
            // InternalAceGen.g:4990:1: ( ( rule__Model__Group_2__0 )? )
            // InternalAceGen.g:4991:2: ( rule__Model__Group_2__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalAceGen.g:4992:2: ( rule__Model__Group_2__0 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==53) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalAceGen.g:4992:3: rule__Model__Group_2__0
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
    // InternalAceGen.g:5000:1: rule__Model__Group__3 : rule__Model__Group__3__Impl ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5004:1: ( rule__Model__Group__3__Impl )
            // InternalAceGen.g:5005:2: rule__Model__Group__3__Impl
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
    // InternalAceGen.g:5011:1: rule__Model__Group__3__Impl : ( ( rule__Model__Group_3__0 )? ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5015:1: ( ( ( rule__Model__Group_3__0 )? ) )
            // InternalAceGen.g:5016:1: ( ( rule__Model__Group_3__0 )? )
            {
            // InternalAceGen.g:5016:1: ( ( rule__Model__Group_3__0 )? )
            // InternalAceGen.g:5017:2: ( rule__Model__Group_3__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_3()); 
            // InternalAceGen.g:5018:2: ( rule__Model__Group_3__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==42) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalAceGen.g:5018:3: rule__Model__Group_3__0
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
    // InternalAceGen.g:5027:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5031:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalAceGen.g:5032:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
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
    // InternalAceGen.g:5039:1: rule__Model__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5043:1: ( ( 'extends' ) )
            // InternalAceGen.g:5044:1: ( 'extends' )
            {
            // InternalAceGen.g:5044:1: ( 'extends' )
            // InternalAceGen.g:5045:2: 'extends'
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
    // InternalAceGen.g:5054:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl rule__Model__Group_2__2 ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5058:1: ( rule__Model__Group_2__1__Impl rule__Model__Group_2__2 )
            // InternalAceGen.g:5059:2: rule__Model__Group_2__1__Impl rule__Model__Group_2__2
            {
            pushFollow(FOLLOW_41);
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
    // InternalAceGen.g:5066:1: rule__Model__Group_2__1__Impl : ( ( rule__Model__SuperModelsAssignment_2_1 ) ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5070:1: ( ( ( rule__Model__SuperModelsAssignment_2_1 ) ) )
            // InternalAceGen.g:5071:1: ( ( rule__Model__SuperModelsAssignment_2_1 ) )
            {
            // InternalAceGen.g:5071:1: ( ( rule__Model__SuperModelsAssignment_2_1 ) )
            // InternalAceGen.g:5072:2: ( rule__Model__SuperModelsAssignment_2_1 )
            {
             before(grammarAccess.getModelAccess().getSuperModelsAssignment_2_1()); 
            // InternalAceGen.g:5073:2: ( rule__Model__SuperModelsAssignment_2_1 )
            // InternalAceGen.g:5073:3: rule__Model__SuperModelsAssignment_2_1
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
    // InternalAceGen.g:5081:1: rule__Model__Group_2__2 : rule__Model__Group_2__2__Impl ;
    public final void rule__Model__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5085:1: ( rule__Model__Group_2__2__Impl )
            // InternalAceGen.g:5086:2: rule__Model__Group_2__2__Impl
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
    // InternalAceGen.g:5092:1: rule__Model__Group_2__2__Impl : ( ( rule__Model__Group_2_2__0 )* ) ;
    public final void rule__Model__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5096:1: ( ( ( rule__Model__Group_2_2__0 )* ) )
            // InternalAceGen.g:5097:1: ( ( rule__Model__Group_2_2__0 )* )
            {
            // InternalAceGen.g:5097:1: ( ( rule__Model__Group_2_2__0 )* )
            // InternalAceGen.g:5098:2: ( rule__Model__Group_2_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_2_2()); 
            // InternalAceGen.g:5099:2: ( rule__Model__Group_2_2__0 )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==33) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalAceGen.g:5099:3: rule__Model__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_11);
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
    // InternalAceGen.g:5108:1: rule__Model__Group_2_2__0 : rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1 ;
    public final void rule__Model__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5112:1: ( rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1 )
            // InternalAceGen.g:5113:2: rule__Model__Group_2_2__0__Impl rule__Model__Group_2_2__1
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
    // InternalAceGen.g:5120:1: rule__Model__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Model__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5124:1: ( ( ',' ) )
            // InternalAceGen.g:5125:1: ( ',' )
            {
            // InternalAceGen.g:5125:1: ( ',' )
            // InternalAceGen.g:5126:2: ','
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
    // InternalAceGen.g:5135:1: rule__Model__Group_2_2__1 : rule__Model__Group_2_2__1__Impl ;
    public final void rule__Model__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5139:1: ( rule__Model__Group_2_2__1__Impl )
            // InternalAceGen.g:5140:2: rule__Model__Group_2_2__1__Impl
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
    // InternalAceGen.g:5146:1: rule__Model__Group_2_2__1__Impl : ( ( rule__Model__SuperModelsAssignment_2_2_1 ) ) ;
    public final void rule__Model__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5150:1: ( ( ( rule__Model__SuperModelsAssignment_2_2_1 ) ) )
            // InternalAceGen.g:5151:1: ( ( rule__Model__SuperModelsAssignment_2_2_1 ) )
            {
            // InternalAceGen.g:5151:1: ( ( rule__Model__SuperModelsAssignment_2_2_1 ) )
            // InternalAceGen.g:5152:2: ( rule__Model__SuperModelsAssignment_2_2_1 )
            {
             before(grammarAccess.getModelAccess().getSuperModelsAssignment_2_2_1()); 
            // InternalAceGen.g:5153:2: ( rule__Model__SuperModelsAssignment_2_2_1 )
            // InternalAceGen.g:5153:3: rule__Model__SuperModelsAssignment_2_2_1
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
    // InternalAceGen.g:5162:1: rule__Model__Group_3__0 : rule__Model__Group_3__0__Impl rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5166:1: ( rule__Model__Group_3__0__Impl rule__Model__Group_3__1 )
            // InternalAceGen.g:5167:2: rule__Model__Group_3__0__Impl rule__Model__Group_3__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalAceGen.g:5174:1: rule__Model__Group_3__0__Impl : ( '{' ) ;
    public final void rule__Model__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5178:1: ( ( '{' ) )
            // InternalAceGen.g:5179:1: ( '{' )
            {
            // InternalAceGen.g:5179:1: ( '{' )
            // InternalAceGen.g:5180:2: '{'
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
    // InternalAceGen.g:5189:1: rule__Model__Group_3__1 : rule__Model__Group_3__1__Impl rule__Model__Group_3__2 ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5193:1: ( rule__Model__Group_3__1__Impl rule__Model__Group_3__2 )
            // InternalAceGen.g:5194:2: rule__Model__Group_3__1__Impl rule__Model__Group_3__2
            {
            pushFollow(FOLLOW_38);
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
    // InternalAceGen.g:5201:1: rule__Model__Group_3__1__Impl : ( ( rule__Model__AttributesAssignment_3_1 )* ) ;
    public final void rule__Model__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5205:1: ( ( ( rule__Model__AttributesAssignment_3_1 )* ) )
            // InternalAceGen.g:5206:1: ( ( rule__Model__AttributesAssignment_3_1 )* )
            {
            // InternalAceGen.g:5206:1: ( ( rule__Model__AttributesAssignment_3_1 )* )
            // InternalAceGen.g:5207:2: ( rule__Model__AttributesAssignment_3_1 )*
            {
             before(grammarAccess.getModelAccess().getAttributesAssignment_3_1()); 
            // InternalAceGen.g:5208:2: ( rule__Model__AttributesAssignment_3_1 )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_ID||(LA73_0>=19 && LA73_0<=26)||(LA73_0>=72 && LA73_0<=74)) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalAceGen.g:5208:3: rule__Model__AttributesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_39);
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
    // InternalAceGen.g:5216:1: rule__Model__Group_3__2 : rule__Model__Group_3__2__Impl ;
    public final void rule__Model__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5220:1: ( rule__Model__Group_3__2__Impl )
            // InternalAceGen.g:5221:2: rule__Model__Group_3__2__Impl
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
    // InternalAceGen.g:5227:1: rule__Model__Group_3__2__Impl : ( '}' ) ;
    public final void rule__Model__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5231:1: ( ( '}' ) )
            // InternalAceGen.g:5232:1: ( '}' )
            {
            // InternalAceGen.g:5232:1: ( '}' )
            // InternalAceGen.g:5233:2: '}'
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
    // InternalAceGen.g:5243:1: rule__Scenario__Group__0 : rule__Scenario__Group__0__Impl rule__Scenario__Group__1 ;
    public final void rule__Scenario__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5247:1: ( rule__Scenario__Group__0__Impl rule__Scenario__Group__1 )
            // InternalAceGen.g:5248:2: rule__Scenario__Group__0__Impl rule__Scenario__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalAceGen.g:5255:1: rule__Scenario__Group__0__Impl : ( ( rule__Scenario__NameAssignment_0 ) ) ;
    public final void rule__Scenario__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5259:1: ( ( ( rule__Scenario__NameAssignment_0 ) ) )
            // InternalAceGen.g:5260:1: ( ( rule__Scenario__NameAssignment_0 ) )
            {
            // InternalAceGen.g:5260:1: ( ( rule__Scenario__NameAssignment_0 ) )
            // InternalAceGen.g:5261:2: ( rule__Scenario__NameAssignment_0 )
            {
             before(grammarAccess.getScenarioAccess().getNameAssignment_0()); 
            // InternalAceGen.g:5262:2: ( rule__Scenario__NameAssignment_0 )
            // InternalAceGen.g:5262:3: rule__Scenario__NameAssignment_0
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
    // InternalAceGen.g:5270:1: rule__Scenario__Group__1 : rule__Scenario__Group__1__Impl rule__Scenario__Group__2 ;
    public final void rule__Scenario__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5274:1: ( rule__Scenario__Group__1__Impl rule__Scenario__Group__2 )
            // InternalAceGen.g:5275:2: rule__Scenario__Group__1__Impl rule__Scenario__Group__2
            {
            pushFollow(FOLLOW_42);
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
    // InternalAceGen.g:5282:1: rule__Scenario__Group__1__Impl : ( ( rule__Scenario__Group_1__0 )? ) ;
    public final void rule__Scenario__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5286:1: ( ( ( rule__Scenario__Group_1__0 )? ) )
            // InternalAceGen.g:5287:1: ( ( rule__Scenario__Group_1__0 )? )
            {
            // InternalAceGen.g:5287:1: ( ( rule__Scenario__Group_1__0 )? )
            // InternalAceGen.g:5288:2: ( rule__Scenario__Group_1__0 )?
            {
             before(grammarAccess.getScenarioAccess().getGroup_1()); 
            // InternalAceGen.g:5289:2: ( rule__Scenario__Group_1__0 )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==56) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalAceGen.g:5289:3: rule__Scenario__Group_1__0
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
    // InternalAceGen.g:5297:1: rule__Scenario__Group__2 : rule__Scenario__Group__2__Impl rule__Scenario__Group__3 ;
    public final void rule__Scenario__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5301:1: ( rule__Scenario__Group__2__Impl rule__Scenario__Group__3 )
            // InternalAceGen.g:5302:2: rule__Scenario__Group__2__Impl rule__Scenario__Group__3
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
    // InternalAceGen.g:5309:1: rule__Scenario__Group__2__Impl : ( 'WHEN' ) ;
    public final void rule__Scenario__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5313:1: ( ( 'WHEN' ) )
            // InternalAceGen.g:5314:1: ( 'WHEN' )
            {
            // InternalAceGen.g:5314:1: ( 'WHEN' )
            // InternalAceGen.g:5315:2: 'WHEN'
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
    // InternalAceGen.g:5324:1: rule__Scenario__Group__3 : rule__Scenario__Group__3__Impl rule__Scenario__Group__4 ;
    public final void rule__Scenario__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5328:1: ( rule__Scenario__Group__3__Impl rule__Scenario__Group__4 )
            // InternalAceGen.g:5329:2: rule__Scenario__Group__3__Impl rule__Scenario__Group__4
            {
            pushFollow(FOLLOW_43);
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
    // InternalAceGen.g:5336:1: rule__Scenario__Group__3__Impl : ( ( rule__Scenario__WhenBlockAssignment_3 ) ) ;
    public final void rule__Scenario__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5340:1: ( ( ( rule__Scenario__WhenBlockAssignment_3 ) ) )
            // InternalAceGen.g:5341:1: ( ( rule__Scenario__WhenBlockAssignment_3 ) )
            {
            // InternalAceGen.g:5341:1: ( ( rule__Scenario__WhenBlockAssignment_3 ) )
            // InternalAceGen.g:5342:2: ( rule__Scenario__WhenBlockAssignment_3 )
            {
             before(grammarAccess.getScenarioAccess().getWhenBlockAssignment_3()); 
            // InternalAceGen.g:5343:2: ( rule__Scenario__WhenBlockAssignment_3 )
            // InternalAceGen.g:5343:3: rule__Scenario__WhenBlockAssignment_3
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
    // InternalAceGen.g:5351:1: rule__Scenario__Group__4 : rule__Scenario__Group__4__Impl rule__Scenario__Group__5 ;
    public final void rule__Scenario__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5355:1: ( rule__Scenario__Group__4__Impl rule__Scenario__Group__5 )
            // InternalAceGen.g:5356:2: rule__Scenario__Group__4__Impl rule__Scenario__Group__5
            {
            pushFollow(FOLLOW_44);
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
    // InternalAceGen.g:5363:1: rule__Scenario__Group__4__Impl : ( 'THEN' ) ;
    public final void rule__Scenario__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5367:1: ( ( 'THEN' ) )
            // InternalAceGen.g:5368:1: ( 'THEN' )
            {
            // InternalAceGen.g:5368:1: ( 'THEN' )
            // InternalAceGen.g:5369:2: 'THEN'
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
    // InternalAceGen.g:5378:1: rule__Scenario__Group__5 : rule__Scenario__Group__5__Impl ;
    public final void rule__Scenario__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5382:1: ( rule__Scenario__Group__5__Impl )
            // InternalAceGen.g:5383:2: rule__Scenario__Group__5__Impl
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
    // InternalAceGen.g:5389:1: rule__Scenario__Group__5__Impl : ( ( rule__Scenario__ThenBlockAssignment_5 ) ) ;
    public final void rule__Scenario__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5393:1: ( ( ( rule__Scenario__ThenBlockAssignment_5 ) ) )
            // InternalAceGen.g:5394:1: ( ( rule__Scenario__ThenBlockAssignment_5 ) )
            {
            // InternalAceGen.g:5394:1: ( ( rule__Scenario__ThenBlockAssignment_5 ) )
            // InternalAceGen.g:5395:2: ( rule__Scenario__ThenBlockAssignment_5 )
            {
             before(grammarAccess.getScenarioAccess().getThenBlockAssignment_5()); 
            // InternalAceGen.g:5396:2: ( rule__Scenario__ThenBlockAssignment_5 )
            // InternalAceGen.g:5396:3: rule__Scenario__ThenBlockAssignment_5
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
    // InternalAceGen.g:5405:1: rule__Scenario__Group_1__0 : rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1 ;
    public final void rule__Scenario__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5409:1: ( rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1 )
            // InternalAceGen.g:5410:2: rule__Scenario__Group_1__0__Impl rule__Scenario__Group_1__1
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
    // InternalAceGen.g:5417:1: rule__Scenario__Group_1__0__Impl : ( 'GIVEN' ) ;
    public final void rule__Scenario__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5421:1: ( ( 'GIVEN' ) )
            // InternalAceGen.g:5422:1: ( 'GIVEN' )
            {
            // InternalAceGen.g:5422:1: ( 'GIVEN' )
            // InternalAceGen.g:5423:2: 'GIVEN'
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
    // InternalAceGen.g:5432:1: rule__Scenario__Group_1__1 : rule__Scenario__Group_1__1__Impl ;
    public final void rule__Scenario__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5436:1: ( rule__Scenario__Group_1__1__Impl )
            // InternalAceGen.g:5437:2: rule__Scenario__Group_1__1__Impl
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
    // InternalAceGen.g:5443:1: rule__Scenario__Group_1__1__Impl : ( ( rule__Scenario__GivenRefsAssignment_1_1 )* ) ;
    public final void rule__Scenario__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5447:1: ( ( ( rule__Scenario__GivenRefsAssignment_1_1 )* ) )
            // InternalAceGen.g:5448:1: ( ( rule__Scenario__GivenRefsAssignment_1_1 )* )
            {
            // InternalAceGen.g:5448:1: ( ( rule__Scenario__GivenRefsAssignment_1_1 )* )
            // InternalAceGen.g:5449:2: ( rule__Scenario__GivenRefsAssignment_1_1 )*
            {
             before(grammarAccess.getScenarioAccess().getGivenRefsAssignment_1_1()); 
            // InternalAceGen.g:5450:2: ( rule__Scenario__GivenRefsAssignment_1_1 )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==RULE_ID) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalAceGen.g:5450:3: rule__Scenario__GivenRefsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalAceGen.g:5459:1: rule__GivenRef__Group__0 : rule__GivenRef__Group__0__Impl rule__GivenRef__Group__1 ;
    public final void rule__GivenRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5463:1: ( rule__GivenRef__Group__0__Impl rule__GivenRef__Group__1 )
            // InternalAceGen.g:5464:2: rule__GivenRef__Group__0__Impl rule__GivenRef__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalAceGen.g:5471:1: rule__GivenRef__Group__0__Impl : ( ( rule__GivenRef__ScenarioAssignment_0 ) ) ;
    public final void rule__GivenRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5475:1: ( ( ( rule__GivenRef__ScenarioAssignment_0 ) ) )
            // InternalAceGen.g:5476:1: ( ( rule__GivenRef__ScenarioAssignment_0 ) )
            {
            // InternalAceGen.g:5476:1: ( ( rule__GivenRef__ScenarioAssignment_0 ) )
            // InternalAceGen.g:5477:2: ( rule__GivenRef__ScenarioAssignment_0 )
            {
             before(grammarAccess.getGivenRefAccess().getScenarioAssignment_0()); 
            // InternalAceGen.g:5478:2: ( rule__GivenRef__ScenarioAssignment_0 )
            // InternalAceGen.g:5478:3: rule__GivenRef__ScenarioAssignment_0
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
    // InternalAceGen.g:5486:1: rule__GivenRef__Group__1 : rule__GivenRef__Group__1__Impl ;
    public final void rule__GivenRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5490:1: ( rule__GivenRef__Group__1__Impl )
            // InternalAceGen.g:5491:2: rule__GivenRef__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GivenRef__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalAceGen.g:5497:1: rule__GivenRef__Group__1__Impl : ( ( rule__GivenRef__Group_1__0 )? ) ;
    public final void rule__GivenRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5501:1: ( ( ( rule__GivenRef__Group_1__0 )? ) )
            // InternalAceGen.g:5502:1: ( ( rule__GivenRef__Group_1__0 )? )
            {
            // InternalAceGen.g:5502:1: ( ( rule__GivenRef__Group_1__0 )? )
            // InternalAceGen.g:5503:2: ( rule__GivenRef__Group_1__0 )?
            {
             before(grammarAccess.getGivenRefAccess().getGroup_1()); 
            // InternalAceGen.g:5504:2: ( rule__GivenRef__Group_1__0 )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_INT) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalAceGen.g:5504:3: rule__GivenRef__Group_1__0
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


    // $ANTLR start "rule__GivenRef__Group_1__0"
    // InternalAceGen.g:5513:1: rule__GivenRef__Group_1__0 : rule__GivenRef__Group_1__0__Impl rule__GivenRef__Group_1__1 ;
    public final void rule__GivenRef__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5517:1: ( rule__GivenRef__Group_1__0__Impl rule__GivenRef__Group_1__1 )
            // InternalAceGen.g:5518:2: rule__GivenRef__Group_1__0__Impl rule__GivenRef__Group_1__1
            {
            pushFollow(FOLLOW_45);
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
    // InternalAceGen.g:5525:1: rule__GivenRef__Group_1__0__Impl : ( ( rule__GivenRef__TimesAssignment_1_0 ) ) ;
    public final void rule__GivenRef__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5529:1: ( ( ( rule__GivenRef__TimesAssignment_1_0 ) ) )
            // InternalAceGen.g:5530:1: ( ( rule__GivenRef__TimesAssignment_1_0 ) )
            {
            // InternalAceGen.g:5530:1: ( ( rule__GivenRef__TimesAssignment_1_0 ) )
            // InternalAceGen.g:5531:2: ( rule__GivenRef__TimesAssignment_1_0 )
            {
             before(grammarAccess.getGivenRefAccess().getTimesAssignment_1_0()); 
            // InternalAceGen.g:5532:2: ( rule__GivenRef__TimesAssignment_1_0 )
            // InternalAceGen.g:5532:3: rule__GivenRef__TimesAssignment_1_0
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
    // InternalAceGen.g:5540:1: rule__GivenRef__Group_1__1 : rule__GivenRef__Group_1__1__Impl ;
    public final void rule__GivenRef__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5544:1: ( rule__GivenRef__Group_1__1__Impl )
            // InternalAceGen.g:5545:2: rule__GivenRef__Group_1__1__Impl
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
    // InternalAceGen.g:5551:1: rule__GivenRef__Group_1__1__Impl : ( 'x' ) ;
    public final void rule__GivenRef__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5555:1: ( ( 'x' ) )
            // InternalAceGen.g:5556:1: ( 'x' )
            {
            // InternalAceGen.g:5556:1: ( 'x' )
            // InternalAceGen.g:5557:2: 'x'
            {
             before(grammarAccess.getGivenRefAccess().getXKeyword_1_1()); 
            match(input,57,FOLLOW_2); 
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
    // InternalAceGen.g:5567:1: rule__WhenBlock__Group__0 : rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1 ;
    public final void rule__WhenBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5571:1: ( rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1 )
            // InternalAceGen.g:5572:2: rule__WhenBlock__Group__0__Impl rule__WhenBlock__Group__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalAceGen.g:5579:1: rule__WhenBlock__Group__0__Impl : ( ( rule__WhenBlock__ActionAssignment_0 ) ) ;
    public final void rule__WhenBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5583:1: ( ( ( rule__WhenBlock__ActionAssignment_0 ) ) )
            // InternalAceGen.g:5584:1: ( ( rule__WhenBlock__ActionAssignment_0 ) )
            {
            // InternalAceGen.g:5584:1: ( ( rule__WhenBlock__ActionAssignment_0 ) )
            // InternalAceGen.g:5585:2: ( rule__WhenBlock__ActionAssignment_0 )
            {
             before(grammarAccess.getWhenBlockAccess().getActionAssignment_0()); 
            // InternalAceGen.g:5586:2: ( rule__WhenBlock__ActionAssignment_0 )
            // InternalAceGen.g:5586:3: rule__WhenBlock__ActionAssignment_0
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
    // InternalAceGen.g:5594:1: rule__WhenBlock__Group__1 : rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2 ;
    public final void rule__WhenBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5598:1: ( rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2 )
            // InternalAceGen.g:5599:2: rule__WhenBlock__Group__1__Impl rule__WhenBlock__Group__2
            {
            pushFollow(FOLLOW_47);
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
    // InternalAceGen.g:5606:1: rule__WhenBlock__Group__1__Impl : ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) ) ;
    public final void rule__WhenBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5610:1: ( ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) ) )
            // InternalAceGen.g:5611:1: ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) )
            {
            // InternalAceGen.g:5611:1: ( ( rule__WhenBlock__DataDefinitionAssignment_1 ) )
            // InternalAceGen.g:5612:2: ( rule__WhenBlock__DataDefinitionAssignment_1 )
            {
             before(grammarAccess.getWhenBlockAccess().getDataDefinitionAssignment_1()); 
            // InternalAceGen.g:5613:2: ( rule__WhenBlock__DataDefinitionAssignment_1 )
            // InternalAceGen.g:5613:3: rule__WhenBlock__DataDefinitionAssignment_1
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
    // InternalAceGen.g:5621:1: rule__WhenBlock__Group__2 : rule__WhenBlock__Group__2__Impl ;
    public final void rule__WhenBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5625:1: ( rule__WhenBlock__Group__2__Impl )
            // InternalAceGen.g:5626:2: rule__WhenBlock__Group__2__Impl
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
    // InternalAceGen.g:5632:1: rule__WhenBlock__Group__2__Impl : ( ( rule__WhenBlock__AuthorizationAssignment_2 )? ) ;
    public final void rule__WhenBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5636:1: ( ( ( rule__WhenBlock__AuthorizationAssignment_2 )? ) )
            // InternalAceGen.g:5637:1: ( ( rule__WhenBlock__AuthorizationAssignment_2 )? )
            {
            // InternalAceGen.g:5637:1: ( ( rule__WhenBlock__AuthorizationAssignment_2 )? )
            // InternalAceGen.g:5638:2: ( rule__WhenBlock__AuthorizationAssignment_2 )?
            {
             before(grammarAccess.getWhenBlockAccess().getAuthorizationAssignment_2()); 
            // InternalAceGen.g:5639:2: ( rule__WhenBlock__AuthorizationAssignment_2 )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==60) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalAceGen.g:5639:3: rule__WhenBlock__AuthorizationAssignment_2
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
    // InternalAceGen.g:5648:1: rule__ThenBlock__Group__0 : rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1 ;
    public final void rule__ThenBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5652:1: ( rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1 )
            // InternalAceGen.g:5653:2: rule__ThenBlock__Group__0__Impl rule__ThenBlock__Group__1
            {
            pushFollow(FOLLOW_48);
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
    // InternalAceGen.g:5660:1: rule__ThenBlock__Group__0__Impl : ( ( rule__ThenBlock__StatusCodeAssignment_0 ) ) ;
    public final void rule__ThenBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5664:1: ( ( ( rule__ThenBlock__StatusCodeAssignment_0 ) ) )
            // InternalAceGen.g:5665:1: ( ( rule__ThenBlock__StatusCodeAssignment_0 ) )
            {
            // InternalAceGen.g:5665:1: ( ( rule__ThenBlock__StatusCodeAssignment_0 ) )
            // InternalAceGen.g:5666:2: ( rule__ThenBlock__StatusCodeAssignment_0 )
            {
             before(grammarAccess.getThenBlockAccess().getStatusCodeAssignment_0()); 
            // InternalAceGen.g:5667:2: ( rule__ThenBlock__StatusCodeAssignment_0 )
            // InternalAceGen.g:5667:3: rule__ThenBlock__StatusCodeAssignment_0
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
    // InternalAceGen.g:5675:1: rule__ThenBlock__Group__1 : rule__ThenBlock__Group__1__Impl ;
    public final void rule__ThenBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5679:1: ( rule__ThenBlock__Group__1__Impl )
            // InternalAceGen.g:5680:2: rule__ThenBlock__Group__1__Impl
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
    // InternalAceGen.g:5686:1: rule__ThenBlock__Group__1__Impl : ( ( rule__ThenBlock__Group_1__0 )? ) ;
    public final void rule__ThenBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5690:1: ( ( ( rule__ThenBlock__Group_1__0 )? ) )
            // InternalAceGen.g:5691:1: ( ( rule__ThenBlock__Group_1__0 )? )
            {
            // InternalAceGen.g:5691:1: ( ( rule__ThenBlock__Group_1__0 )? )
            // InternalAceGen.g:5692:2: ( rule__ThenBlock__Group_1__0 )?
            {
             before(grammarAccess.getThenBlockAccess().getGroup_1()); 
            // InternalAceGen.g:5693:2: ( rule__ThenBlock__Group_1__0 )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==52) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalAceGen.g:5693:3: rule__ThenBlock__Group_1__0
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
    // InternalAceGen.g:5702:1: rule__ThenBlock__Group_1__0 : rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1 ;
    public final void rule__ThenBlock__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5706:1: ( rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1 )
            // InternalAceGen.g:5707:2: rule__ThenBlock__Group_1__0__Impl rule__ThenBlock__Group_1__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalAceGen.g:5714:1: rule__ThenBlock__Group_1__0__Impl : ( 'response' ) ;
    public final void rule__ThenBlock__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5718:1: ( ( 'response' ) )
            // InternalAceGen.g:5719:1: ( 'response' )
            {
            // InternalAceGen.g:5719:1: ( 'response' )
            // InternalAceGen.g:5720:2: 'response'
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
    // InternalAceGen.g:5729:1: rule__ThenBlock__Group_1__1 : rule__ThenBlock__Group_1__1__Impl ;
    public final void rule__ThenBlock__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5733:1: ( rule__ThenBlock__Group_1__1__Impl )
            // InternalAceGen.g:5734:2: rule__ThenBlock__Group_1__1__Impl
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
    // InternalAceGen.g:5740:1: rule__ThenBlock__Group_1__1__Impl : ( ( rule__ThenBlock__ResponseAssignment_1_1 ) ) ;
    public final void rule__ThenBlock__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5744:1: ( ( ( rule__ThenBlock__ResponseAssignment_1_1 ) ) )
            // InternalAceGen.g:5745:1: ( ( rule__ThenBlock__ResponseAssignment_1_1 ) )
            {
            // InternalAceGen.g:5745:1: ( ( rule__ThenBlock__ResponseAssignment_1_1 ) )
            // InternalAceGen.g:5746:2: ( rule__ThenBlock__ResponseAssignment_1_1 )
            {
             before(grammarAccess.getThenBlockAccess().getResponseAssignment_1_1()); 
            // InternalAceGen.g:5747:2: ( rule__ThenBlock__ResponseAssignment_1_1 )
            // InternalAceGen.g:5747:3: rule__ThenBlock__ResponseAssignment_1_1
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
    // InternalAceGen.g:5756:1: rule__DataDefinition__Group__0 : rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1 ;
    public final void rule__DataDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5760:1: ( rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1 )
            // InternalAceGen.g:5761:2: rule__DataDefinition__Group__0__Impl rule__DataDefinition__Group__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalAceGen.g:5768:1: rule__DataDefinition__Group__0__Impl : ( () ) ;
    public final void rule__DataDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5772:1: ( ( () ) )
            // InternalAceGen.g:5773:1: ( () )
            {
            // InternalAceGen.g:5773:1: ( () )
            // InternalAceGen.g:5774:2: ()
            {
             before(grammarAccess.getDataDefinitionAccess().getDataDefinitionAction_0()); 
            // InternalAceGen.g:5775:2: ()
            // InternalAceGen.g:5775:3: 
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
    // InternalAceGen.g:5783:1: rule__DataDefinition__Group__1 : rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2 ;
    public final void rule__DataDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5787:1: ( rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2 )
            // InternalAceGen.g:5788:2: rule__DataDefinition__Group__1__Impl rule__DataDefinition__Group__2
            {
            pushFollow(FOLLOW_46);
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
    // InternalAceGen.g:5795:1: rule__DataDefinition__Group__1__Impl : ( ( rule__DataDefinition__Group_1__0 )? ) ;
    public final void rule__DataDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5799:1: ( ( ( rule__DataDefinition__Group_1__0 )? ) )
            // InternalAceGen.g:5800:1: ( ( rule__DataDefinition__Group_1__0 )? )
            {
            // InternalAceGen.g:5800:1: ( ( rule__DataDefinition__Group_1__0 )? )
            // InternalAceGen.g:5801:2: ( rule__DataDefinition__Group_1__0 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getGroup_1()); 
            // InternalAceGen.g:5802:2: ( rule__DataDefinition__Group_1__0 )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==58) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalAceGen.g:5802:3: rule__DataDefinition__Group_1__0
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
    // InternalAceGen.g:5810:1: rule__DataDefinition__Group__2 : rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3 ;
    public final void rule__DataDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5814:1: ( rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3 )
            // InternalAceGen.g:5815:2: rule__DataDefinition__Group__2__Impl rule__DataDefinition__Group__3
            {
            pushFollow(FOLLOW_46);
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
    // InternalAceGen.g:5822:1: rule__DataDefinition__Group__2__Impl : ( ( rule__DataDefinition__Group_2__0 )? ) ;
    public final void rule__DataDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5826:1: ( ( ( rule__DataDefinition__Group_2__0 )? ) )
            // InternalAceGen.g:5827:1: ( ( rule__DataDefinition__Group_2__0 )? )
            {
            // InternalAceGen.g:5827:1: ( ( rule__DataDefinition__Group_2__0 )? )
            // InternalAceGen.g:5828:2: ( rule__DataDefinition__Group_2__0 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getGroup_2()); 
            // InternalAceGen.g:5829:2: ( rule__DataDefinition__Group_2__0 )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==59) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalAceGen.g:5829:3: rule__DataDefinition__Group_2__0
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
    // InternalAceGen.g:5837:1: rule__DataDefinition__Group__3 : rule__DataDefinition__Group__3__Impl ;
    public final void rule__DataDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5841:1: ( rule__DataDefinition__Group__3__Impl )
            // InternalAceGen.g:5842:2: rule__DataDefinition__Group__3__Impl
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
    // InternalAceGen.g:5848:1: rule__DataDefinition__Group__3__Impl : ( ( rule__DataDefinition__DataAssignment_3 )? ) ;
    public final void rule__DataDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5852:1: ( ( ( rule__DataDefinition__DataAssignment_3 )? ) )
            // InternalAceGen.g:5853:1: ( ( rule__DataDefinition__DataAssignment_3 )? )
            {
            // InternalAceGen.g:5853:1: ( ( rule__DataDefinition__DataAssignment_3 )? )
            // InternalAceGen.g:5854:2: ( rule__DataDefinition__DataAssignment_3 )?
            {
             before(grammarAccess.getDataDefinitionAccess().getDataAssignment_3()); 
            // InternalAceGen.g:5855:2: ( rule__DataDefinition__DataAssignment_3 )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==42) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalAceGen.g:5855:3: rule__DataDefinition__DataAssignment_3
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
    // InternalAceGen.g:5864:1: rule__DataDefinition__Group_1__0 : rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1 ;
    public final void rule__DataDefinition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5868:1: ( rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1 )
            // InternalAceGen.g:5869:2: rule__DataDefinition__Group_1__0__Impl rule__DataDefinition__Group_1__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalAceGen.g:5876:1: rule__DataDefinition__Group_1__0__Impl : ( 'uuid' ) ;
    public final void rule__DataDefinition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5880:1: ( ( 'uuid' ) )
            // InternalAceGen.g:5881:1: ( 'uuid' )
            {
            // InternalAceGen.g:5881:1: ( 'uuid' )
            // InternalAceGen.g:5882:2: 'uuid'
            {
             before(grammarAccess.getDataDefinitionAccess().getUuidKeyword_1_0()); 
            match(input,58,FOLLOW_2); 
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
    // InternalAceGen.g:5891:1: rule__DataDefinition__Group_1__1 : rule__DataDefinition__Group_1__1__Impl ;
    public final void rule__DataDefinition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5895:1: ( rule__DataDefinition__Group_1__1__Impl )
            // InternalAceGen.g:5896:2: rule__DataDefinition__Group_1__1__Impl
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
    // InternalAceGen.g:5902:1: rule__DataDefinition__Group_1__1__Impl : ( ( rule__DataDefinition__UuidAssignment_1_1 ) ) ;
    public final void rule__DataDefinition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5906:1: ( ( ( rule__DataDefinition__UuidAssignment_1_1 ) ) )
            // InternalAceGen.g:5907:1: ( ( rule__DataDefinition__UuidAssignment_1_1 ) )
            {
            // InternalAceGen.g:5907:1: ( ( rule__DataDefinition__UuidAssignment_1_1 ) )
            // InternalAceGen.g:5908:2: ( rule__DataDefinition__UuidAssignment_1_1 )
            {
             before(grammarAccess.getDataDefinitionAccess().getUuidAssignment_1_1()); 
            // InternalAceGen.g:5909:2: ( rule__DataDefinition__UuidAssignment_1_1 )
            // InternalAceGen.g:5909:3: rule__DataDefinition__UuidAssignment_1_1
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
    // InternalAceGen.g:5918:1: rule__DataDefinition__Group_2__0 : rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1 ;
    public final void rule__DataDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5922:1: ( rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1 )
            // InternalAceGen.g:5923:2: rule__DataDefinition__Group_2__0__Impl rule__DataDefinition__Group_2__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalAceGen.g:5930:1: rule__DataDefinition__Group_2__0__Impl : ( 'systemTime' ) ;
    public final void rule__DataDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5934:1: ( ( 'systemTime' ) )
            // InternalAceGen.g:5935:1: ( 'systemTime' )
            {
            // InternalAceGen.g:5935:1: ( 'systemTime' )
            // InternalAceGen.g:5936:2: 'systemTime'
            {
             before(grammarAccess.getDataDefinitionAccess().getSystemTimeKeyword_2_0()); 
            match(input,59,FOLLOW_2); 
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
    // InternalAceGen.g:5945:1: rule__DataDefinition__Group_2__1 : rule__DataDefinition__Group_2__1__Impl rule__DataDefinition__Group_2__2 ;
    public final void rule__DataDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5949:1: ( rule__DataDefinition__Group_2__1__Impl rule__DataDefinition__Group_2__2 )
            // InternalAceGen.g:5950:2: rule__DataDefinition__Group_2__1__Impl rule__DataDefinition__Group_2__2
            {
            pushFollow(FOLLOW_32);
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
    // InternalAceGen.g:5957:1: rule__DataDefinition__Group_2__1__Impl : ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) ) ;
    public final void rule__DataDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5961:1: ( ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) ) )
            // InternalAceGen.g:5962:1: ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) )
            {
            // InternalAceGen.g:5962:1: ( ( rule__DataDefinition__SystemtimeAssignment_2_1 ) )
            // InternalAceGen.g:5963:2: ( rule__DataDefinition__SystemtimeAssignment_2_1 )
            {
             before(grammarAccess.getDataDefinitionAccess().getSystemtimeAssignment_2_1()); 
            // InternalAceGen.g:5964:2: ( rule__DataDefinition__SystemtimeAssignment_2_1 )
            // InternalAceGen.g:5964:3: rule__DataDefinition__SystemtimeAssignment_2_1
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
    // InternalAceGen.g:5972:1: rule__DataDefinition__Group_2__2 : rule__DataDefinition__Group_2__2__Impl ;
    public final void rule__DataDefinition__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5976:1: ( rule__DataDefinition__Group_2__2__Impl )
            // InternalAceGen.g:5977:2: rule__DataDefinition__Group_2__2__Impl
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
    // InternalAceGen.g:5983:1: rule__DataDefinition__Group_2__2__Impl : ( ( rule__DataDefinition__PatternAssignment_2_2 ) ) ;
    public final void rule__DataDefinition__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:5987:1: ( ( ( rule__DataDefinition__PatternAssignment_2_2 ) ) )
            // InternalAceGen.g:5988:1: ( ( rule__DataDefinition__PatternAssignment_2_2 ) )
            {
            // InternalAceGen.g:5988:1: ( ( rule__DataDefinition__PatternAssignment_2_2 ) )
            // InternalAceGen.g:5989:2: ( rule__DataDefinition__PatternAssignment_2_2 )
            {
             before(grammarAccess.getDataDefinitionAccess().getPatternAssignment_2_2()); 
            // InternalAceGen.g:5990:2: ( rule__DataDefinition__PatternAssignment_2_2 )
            // InternalAceGen.g:5990:3: rule__DataDefinition__PatternAssignment_2_2
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
    // InternalAceGen.g:5999:1: rule__Authorization__Group__0 : rule__Authorization__Group__0__Impl rule__Authorization__Group__1 ;
    public final void rule__Authorization__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6003:1: ( rule__Authorization__Group__0__Impl rule__Authorization__Group__1 )
            // InternalAceGen.g:6004:2: rule__Authorization__Group__0__Impl rule__Authorization__Group__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalAceGen.g:6011:1: rule__Authorization__Group__0__Impl : ( 'authorization' ) ;
    public final void rule__Authorization__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6015:1: ( ( 'authorization' ) )
            // InternalAceGen.g:6016:1: ( 'authorization' )
            {
            // InternalAceGen.g:6016:1: ( 'authorization' )
            // InternalAceGen.g:6017:2: 'authorization'
            {
             before(grammarAccess.getAuthorizationAccess().getAuthorizationKeyword_0()); 
            match(input,60,FOLLOW_2); 
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
    // InternalAceGen.g:6026:1: rule__Authorization__Group__1 : rule__Authorization__Group__1__Impl rule__Authorization__Group__2 ;
    public final void rule__Authorization__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6030:1: ( rule__Authorization__Group__1__Impl rule__Authorization__Group__2 )
            // InternalAceGen.g:6031:2: rule__Authorization__Group__1__Impl rule__Authorization__Group__2
            {
            pushFollow(FOLLOW_21);
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
    // InternalAceGen.g:6038:1: rule__Authorization__Group__1__Impl : ( ( rule__Authorization__UsernameAssignment_1 ) ) ;
    public final void rule__Authorization__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6042:1: ( ( ( rule__Authorization__UsernameAssignment_1 ) ) )
            // InternalAceGen.g:6043:1: ( ( rule__Authorization__UsernameAssignment_1 ) )
            {
            // InternalAceGen.g:6043:1: ( ( rule__Authorization__UsernameAssignment_1 ) )
            // InternalAceGen.g:6044:2: ( rule__Authorization__UsernameAssignment_1 )
            {
             before(grammarAccess.getAuthorizationAccess().getUsernameAssignment_1()); 
            // InternalAceGen.g:6045:2: ( rule__Authorization__UsernameAssignment_1 )
            // InternalAceGen.g:6045:3: rule__Authorization__UsernameAssignment_1
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
    // InternalAceGen.g:6053:1: rule__Authorization__Group__2 : rule__Authorization__Group__2__Impl rule__Authorization__Group__3 ;
    public final void rule__Authorization__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6057:1: ( rule__Authorization__Group__2__Impl rule__Authorization__Group__3 )
            // InternalAceGen.g:6058:2: rule__Authorization__Group__2__Impl rule__Authorization__Group__3
            {
            pushFollow(FOLLOW_32);
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
    // InternalAceGen.g:6065:1: rule__Authorization__Group__2__Impl : ( ':' ) ;
    public final void rule__Authorization__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6069:1: ( ( ':' ) )
            // InternalAceGen.g:6070:1: ( ':' )
            {
            // InternalAceGen.g:6070:1: ( ':' )
            // InternalAceGen.g:6071:2: ':'
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
    // InternalAceGen.g:6080:1: rule__Authorization__Group__3 : rule__Authorization__Group__3__Impl ;
    public final void rule__Authorization__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6084:1: ( rule__Authorization__Group__3__Impl )
            // InternalAceGen.g:6085:2: rule__Authorization__Group__3__Impl
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
    // InternalAceGen.g:6091:1: rule__Authorization__Group__3__Impl : ( ( rule__Authorization__PasswordAssignment_3 ) ) ;
    public final void rule__Authorization__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6095:1: ( ( ( rule__Authorization__PasswordAssignment_3 ) ) )
            // InternalAceGen.g:6096:1: ( ( rule__Authorization__PasswordAssignment_3 ) )
            {
            // InternalAceGen.g:6096:1: ( ( rule__Authorization__PasswordAssignment_3 ) )
            // InternalAceGen.g:6097:2: ( rule__Authorization__PasswordAssignment_3 )
            {
             before(grammarAccess.getAuthorizationAccess().getPasswordAssignment_3()); 
            // InternalAceGen.g:6098:2: ( rule__Authorization__PasswordAssignment_3 )
            // InternalAceGen.g:6098:3: rule__Authorization__PasswordAssignment_3
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
    // InternalAceGen.g:6107:1: rule__AttributeDefinitionList__Group__0 : rule__AttributeDefinitionList__Group__0__Impl rule__AttributeDefinitionList__Group__1 ;
    public final void rule__AttributeDefinitionList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6111:1: ( rule__AttributeDefinitionList__Group__0__Impl rule__AttributeDefinitionList__Group__1 )
            // InternalAceGen.g:6112:2: rule__AttributeDefinitionList__Group__0__Impl rule__AttributeDefinitionList__Group__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalAceGen.g:6119:1: rule__AttributeDefinitionList__Group__0__Impl : ( () ) ;
    public final void rule__AttributeDefinitionList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6123:1: ( ( () ) )
            // InternalAceGen.g:6124:1: ( () )
            {
            // InternalAceGen.g:6124:1: ( () )
            // InternalAceGen.g:6125:2: ()
            {
             before(grammarAccess.getAttributeDefinitionListAccess().getAttributeDefinitionListAction_0()); 
            // InternalAceGen.g:6126:2: ()
            // InternalAceGen.g:6126:3: 
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
    // InternalAceGen.g:6134:1: rule__AttributeDefinitionList__Group__1 : rule__AttributeDefinitionList__Group__1__Impl rule__AttributeDefinitionList__Group__2 ;
    public final void rule__AttributeDefinitionList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6138:1: ( rule__AttributeDefinitionList__Group__1__Impl rule__AttributeDefinitionList__Group__2 )
            // InternalAceGen.g:6139:2: rule__AttributeDefinitionList__Group__1__Impl rule__AttributeDefinitionList__Group__2
            {
            pushFollow(FOLLOW_23);
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
    // InternalAceGen.g:6146:1: rule__AttributeDefinitionList__Group__1__Impl : ( '{' ) ;
    public final void rule__AttributeDefinitionList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6150:1: ( ( '{' ) )
            // InternalAceGen.g:6151:1: ( '{' )
            {
            // InternalAceGen.g:6151:1: ( '{' )
            // InternalAceGen.g:6152:2: '{'
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
    // InternalAceGen.g:6161:1: rule__AttributeDefinitionList__Group__2 : rule__AttributeDefinitionList__Group__2__Impl rule__AttributeDefinitionList__Group__3 ;
    public final void rule__AttributeDefinitionList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6165:1: ( rule__AttributeDefinitionList__Group__2__Impl rule__AttributeDefinitionList__Group__3 )
            // InternalAceGen.g:6166:2: rule__AttributeDefinitionList__Group__2__Impl rule__AttributeDefinitionList__Group__3
            {
            pushFollow(FOLLOW_23);
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
    // InternalAceGen.g:6173:1: rule__AttributeDefinitionList__Group__2__Impl : ( ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )* ) ;
    public final void rule__AttributeDefinitionList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6177:1: ( ( ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )* ) )
            // InternalAceGen.g:6178:1: ( ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )* )
            {
            // InternalAceGen.g:6178:1: ( ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )* )
            // InternalAceGen.g:6179:2: ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )*
            {
             before(grammarAccess.getAttributeDefinitionListAccess().getAttributeDefinitionsAssignment_2()); 
            // InternalAceGen.g:6180:2: ( rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==RULE_ID) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalAceGen.g:6180:3: rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop82;
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
    // InternalAceGen.g:6188:1: rule__AttributeDefinitionList__Group__3 : rule__AttributeDefinitionList__Group__3__Impl ;
    public final void rule__AttributeDefinitionList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6192:1: ( rule__AttributeDefinitionList__Group__3__Impl )
            // InternalAceGen.g:6193:2: rule__AttributeDefinitionList__Group__3__Impl
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
    // InternalAceGen.g:6199:1: rule__AttributeDefinitionList__Group__3__Impl : ( '}' ) ;
    public final void rule__AttributeDefinitionList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6203:1: ( ( '}' ) )
            // InternalAceGen.g:6204:1: ( '}' )
            {
            // InternalAceGen.g:6204:1: ( '}' )
            // InternalAceGen.g:6205:2: '}'
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


    // $ANTLR start "rule__AttributeDefinitionListForList__Group__0"
    // InternalAceGen.g:6215:1: rule__AttributeDefinitionListForList__Group__0 : rule__AttributeDefinitionListForList__Group__0__Impl rule__AttributeDefinitionListForList__Group__1 ;
    public final void rule__AttributeDefinitionListForList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6219:1: ( rule__AttributeDefinitionListForList__Group__0__Impl rule__AttributeDefinitionListForList__Group__1 )
            // InternalAceGen.g:6220:2: rule__AttributeDefinitionListForList__Group__0__Impl rule__AttributeDefinitionListForList__Group__1
            {
            pushFollow(FOLLOW_49);
            rule__AttributeDefinitionListForList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionListForList__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionListForList__Group__0"


    // $ANTLR start "rule__AttributeDefinitionListForList__Group__0__Impl"
    // InternalAceGen.g:6227:1: rule__AttributeDefinitionListForList__Group__0__Impl : ( () ) ;
    public final void rule__AttributeDefinitionListForList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6231:1: ( ( () ) )
            // InternalAceGen.g:6232:1: ( () )
            {
            // InternalAceGen.g:6232:1: ( () )
            // InternalAceGen.g:6233:2: ()
            {
             before(grammarAccess.getAttributeDefinitionListForListAccess().getAttributeDefinitionListForListAction_0()); 
            // InternalAceGen.g:6234:2: ()
            // InternalAceGen.g:6234:3: 
            {
            }

             after(grammarAccess.getAttributeDefinitionListForListAccess().getAttributeDefinitionListForListAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionListForList__Group__0__Impl"


    // $ANTLR start "rule__AttributeDefinitionListForList__Group__1"
    // InternalAceGen.g:6242:1: rule__AttributeDefinitionListForList__Group__1 : rule__AttributeDefinitionListForList__Group__1__Impl rule__AttributeDefinitionListForList__Group__2 ;
    public final void rule__AttributeDefinitionListForList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6246:1: ( rule__AttributeDefinitionListForList__Group__1__Impl rule__AttributeDefinitionListForList__Group__2 )
            // InternalAceGen.g:6247:2: rule__AttributeDefinitionListForList__Group__1__Impl rule__AttributeDefinitionListForList__Group__2
            {
            pushFollow(FOLLOW_50);
            rule__AttributeDefinitionListForList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionListForList__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionListForList__Group__1"


    // $ANTLR start "rule__AttributeDefinitionListForList__Group__1__Impl"
    // InternalAceGen.g:6254:1: rule__AttributeDefinitionListForList__Group__1__Impl : ( '[' ) ;
    public final void rule__AttributeDefinitionListForList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6258:1: ( ( '[' ) )
            // InternalAceGen.g:6259:1: ( '[' )
            {
            // InternalAceGen.g:6259:1: ( '[' )
            // InternalAceGen.g:6260:2: '['
            {
             before(grammarAccess.getAttributeDefinitionListForListAccess().getLeftSquareBracketKeyword_1()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getAttributeDefinitionListForListAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionListForList__Group__1__Impl"


    // $ANTLR start "rule__AttributeDefinitionListForList__Group__2"
    // InternalAceGen.g:6269:1: rule__AttributeDefinitionListForList__Group__2 : rule__AttributeDefinitionListForList__Group__2__Impl rule__AttributeDefinitionListForList__Group__3 ;
    public final void rule__AttributeDefinitionListForList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6273:1: ( rule__AttributeDefinitionListForList__Group__2__Impl rule__AttributeDefinitionListForList__Group__3 )
            // InternalAceGen.g:6274:2: rule__AttributeDefinitionListForList__Group__2__Impl rule__AttributeDefinitionListForList__Group__3
            {
            pushFollow(FOLLOW_50);
            rule__AttributeDefinitionListForList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionListForList__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionListForList__Group__2"


    // $ANTLR start "rule__AttributeDefinitionListForList__Group__2__Impl"
    // InternalAceGen.g:6281:1: rule__AttributeDefinitionListForList__Group__2__Impl : ( ( rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2 )* ) ;
    public final void rule__AttributeDefinitionListForList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6285:1: ( ( ( rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2 )* ) )
            // InternalAceGen.g:6286:1: ( ( rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2 )* )
            {
            // InternalAceGen.g:6286:1: ( ( rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2 )* )
            // InternalAceGen.g:6287:2: ( rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2 )*
            {
             before(grammarAccess.getAttributeDefinitionListForListAccess().getAttributeDefinitionListAssignment_2()); 
            // InternalAceGen.g:6288:2: ( rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2 )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==42) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalAceGen.g:6288:3: rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2
            	    {
            	    pushFollow(FOLLOW_51);
            	    rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);

             after(grammarAccess.getAttributeDefinitionListForListAccess().getAttributeDefinitionListAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionListForList__Group__2__Impl"


    // $ANTLR start "rule__AttributeDefinitionListForList__Group__3"
    // InternalAceGen.g:6296:1: rule__AttributeDefinitionListForList__Group__3 : rule__AttributeDefinitionListForList__Group__3__Impl ;
    public final void rule__AttributeDefinitionListForList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6300:1: ( rule__AttributeDefinitionListForList__Group__3__Impl )
            // InternalAceGen.g:6301:2: rule__AttributeDefinitionListForList__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeDefinitionListForList__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionListForList__Group__3"


    // $ANTLR start "rule__AttributeDefinitionListForList__Group__3__Impl"
    // InternalAceGen.g:6307:1: rule__AttributeDefinitionListForList__Group__3__Impl : ( ']' ) ;
    public final void rule__AttributeDefinitionListForList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6311:1: ( ( ']' ) )
            // InternalAceGen.g:6312:1: ( ']' )
            {
            // InternalAceGen.g:6312:1: ( ']' )
            // InternalAceGen.g:6313:2: ']'
            {
             before(grammarAccess.getAttributeDefinitionListForListAccess().getRightSquareBracketKeyword_3()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getAttributeDefinitionListForListAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionListForList__Group__3__Impl"


    // $ANTLR start "rule__PrimitiveValueDefinitionForList__Group__0"
    // InternalAceGen.g:6323:1: rule__PrimitiveValueDefinitionForList__Group__0 : rule__PrimitiveValueDefinitionForList__Group__0__Impl rule__PrimitiveValueDefinitionForList__Group__1 ;
    public final void rule__PrimitiveValueDefinitionForList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6327:1: ( rule__PrimitiveValueDefinitionForList__Group__0__Impl rule__PrimitiveValueDefinitionForList__Group__1 )
            // InternalAceGen.g:6328:2: rule__PrimitiveValueDefinitionForList__Group__0__Impl rule__PrimitiveValueDefinitionForList__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__PrimitiveValueDefinitionForList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveValueDefinitionForList__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueDefinitionForList__Group__0"


    // $ANTLR start "rule__PrimitiveValueDefinitionForList__Group__0__Impl"
    // InternalAceGen.g:6335:1: rule__PrimitiveValueDefinitionForList__Group__0__Impl : ( () ) ;
    public final void rule__PrimitiveValueDefinitionForList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6339:1: ( ( () ) )
            // InternalAceGen.g:6340:1: ( () )
            {
            // InternalAceGen.g:6340:1: ( () )
            // InternalAceGen.g:6341:2: ()
            {
             before(grammarAccess.getPrimitiveValueDefinitionForListAccess().getPrimitiveValueDefinitionForListAction_0()); 
            // InternalAceGen.g:6342:2: ()
            // InternalAceGen.g:6342:3: 
            {
            }

             after(grammarAccess.getPrimitiveValueDefinitionForListAccess().getPrimitiveValueDefinitionForListAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueDefinitionForList__Group__0__Impl"


    // $ANTLR start "rule__PrimitiveValueDefinitionForList__Group__1"
    // InternalAceGen.g:6350:1: rule__PrimitiveValueDefinitionForList__Group__1 : rule__PrimitiveValueDefinitionForList__Group__1__Impl rule__PrimitiveValueDefinitionForList__Group__2 ;
    public final void rule__PrimitiveValueDefinitionForList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6354:1: ( rule__PrimitiveValueDefinitionForList__Group__1__Impl rule__PrimitiveValueDefinitionForList__Group__2 )
            // InternalAceGen.g:6355:2: rule__PrimitiveValueDefinitionForList__Group__1__Impl rule__PrimitiveValueDefinitionForList__Group__2
            {
            pushFollow(FOLLOW_52);
            rule__PrimitiveValueDefinitionForList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveValueDefinitionForList__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueDefinitionForList__Group__1"


    // $ANTLR start "rule__PrimitiveValueDefinitionForList__Group__1__Impl"
    // InternalAceGen.g:6362:1: rule__PrimitiveValueDefinitionForList__Group__1__Impl : ( '(' ) ;
    public final void rule__PrimitiveValueDefinitionForList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6366:1: ( ( '(' ) )
            // InternalAceGen.g:6367:1: ( '(' )
            {
            // InternalAceGen.g:6367:1: ( '(' )
            // InternalAceGen.g:6368:2: '('
            {
             before(grammarAccess.getPrimitiveValueDefinitionForListAccess().getLeftParenthesisKeyword_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getPrimitiveValueDefinitionForListAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueDefinitionForList__Group__1__Impl"


    // $ANTLR start "rule__PrimitiveValueDefinitionForList__Group__2"
    // InternalAceGen.g:6377:1: rule__PrimitiveValueDefinitionForList__Group__2 : rule__PrimitiveValueDefinitionForList__Group__2__Impl rule__PrimitiveValueDefinitionForList__Group__3 ;
    public final void rule__PrimitiveValueDefinitionForList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6381:1: ( rule__PrimitiveValueDefinitionForList__Group__2__Impl rule__PrimitiveValueDefinitionForList__Group__3 )
            // InternalAceGen.g:6382:2: rule__PrimitiveValueDefinitionForList__Group__2__Impl rule__PrimitiveValueDefinitionForList__Group__3
            {
            pushFollow(FOLLOW_52);
            rule__PrimitiveValueDefinitionForList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimitiveValueDefinitionForList__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueDefinitionForList__Group__2"


    // $ANTLR start "rule__PrimitiveValueDefinitionForList__Group__2__Impl"
    // InternalAceGen.g:6389:1: rule__PrimitiveValueDefinitionForList__Group__2__Impl : ( ( rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2 )* ) ;
    public final void rule__PrimitiveValueDefinitionForList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6393:1: ( ( ( rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2 )* ) )
            // InternalAceGen.g:6394:1: ( ( rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2 )* )
            {
            // InternalAceGen.g:6394:1: ( ( rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2 )* )
            // InternalAceGen.g:6395:2: ( rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2 )*
            {
             before(grammarAccess.getPrimitiveValueDefinitionForListAccess().getValueDefinitionListAssignment_2()); 
            // InternalAceGen.g:6396:2: ( rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2 )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( ((LA84_0>=RULE_STRING && LA84_0<=RULE_INT)) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalAceGen.g:6396:3: rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2
            	    {
            	    pushFollow(FOLLOW_53);
            	    rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

             after(grammarAccess.getPrimitiveValueDefinitionForListAccess().getValueDefinitionListAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueDefinitionForList__Group__2__Impl"


    // $ANTLR start "rule__PrimitiveValueDefinitionForList__Group__3"
    // InternalAceGen.g:6404:1: rule__PrimitiveValueDefinitionForList__Group__3 : rule__PrimitiveValueDefinitionForList__Group__3__Impl ;
    public final void rule__PrimitiveValueDefinitionForList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6408:1: ( rule__PrimitiveValueDefinitionForList__Group__3__Impl )
            // InternalAceGen.g:6409:2: rule__PrimitiveValueDefinitionForList__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveValueDefinitionForList__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueDefinitionForList__Group__3"


    // $ANTLR start "rule__PrimitiveValueDefinitionForList__Group__3__Impl"
    // InternalAceGen.g:6415:1: rule__PrimitiveValueDefinitionForList__Group__3__Impl : ( ')' ) ;
    public final void rule__PrimitiveValueDefinitionForList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6419:1: ( ( ')' ) )
            // InternalAceGen.g:6420:1: ( ')' )
            {
            // InternalAceGen.g:6420:1: ( ')' )
            // InternalAceGen.g:6421:2: ')'
            {
             before(grammarAccess.getPrimitiveValueDefinitionForListAccess().getRightParenthesisKeyword_3()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getPrimitiveValueDefinitionForListAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueDefinitionForList__Group__3__Impl"


    // $ANTLR start "rule__AttributeDefinition__Group__0"
    // InternalAceGen.g:6431:1: rule__AttributeDefinition__Group__0 : rule__AttributeDefinition__Group__0__Impl rule__AttributeDefinition__Group__1 ;
    public final void rule__AttributeDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6435:1: ( rule__AttributeDefinition__Group__0__Impl rule__AttributeDefinition__Group__1 )
            // InternalAceGen.g:6436:2: rule__AttributeDefinition__Group__0__Impl rule__AttributeDefinition__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalAceGen.g:6443:1: rule__AttributeDefinition__Group__0__Impl : ( ( rule__AttributeDefinition__AttributeAssignment_0 ) ) ;
    public final void rule__AttributeDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6447:1: ( ( ( rule__AttributeDefinition__AttributeAssignment_0 ) ) )
            // InternalAceGen.g:6448:1: ( ( rule__AttributeDefinition__AttributeAssignment_0 ) )
            {
            // InternalAceGen.g:6448:1: ( ( rule__AttributeDefinition__AttributeAssignment_0 ) )
            // InternalAceGen.g:6449:2: ( rule__AttributeDefinition__AttributeAssignment_0 )
            {
             before(grammarAccess.getAttributeDefinitionAccess().getAttributeAssignment_0()); 
            // InternalAceGen.g:6450:2: ( rule__AttributeDefinition__AttributeAssignment_0 )
            // InternalAceGen.g:6450:3: rule__AttributeDefinition__AttributeAssignment_0
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
    // InternalAceGen.g:6458:1: rule__AttributeDefinition__Group__1 : rule__AttributeDefinition__Group__1__Impl rule__AttributeDefinition__Group__2 ;
    public final void rule__AttributeDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6462:1: ( rule__AttributeDefinition__Group__1__Impl rule__AttributeDefinition__Group__2 )
            // InternalAceGen.g:6463:2: rule__AttributeDefinition__Group__1__Impl rule__AttributeDefinition__Group__2
            {
            pushFollow(FOLLOW_54);
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
    // InternalAceGen.g:6470:1: rule__AttributeDefinition__Group__1__Impl : ( ':' ) ;
    public final void rule__AttributeDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6474:1: ( ( ':' ) )
            // InternalAceGen.g:6475:1: ( ':' )
            {
            // InternalAceGen.g:6475:1: ( ':' )
            // InternalAceGen.g:6476:2: ':'
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
    // InternalAceGen.g:6485:1: rule__AttributeDefinition__Group__2 : rule__AttributeDefinition__Group__2__Impl ;
    public final void rule__AttributeDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6489:1: ( rule__AttributeDefinition__Group__2__Impl )
            // InternalAceGen.g:6490:2: rule__AttributeDefinition__Group__2__Impl
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
    // InternalAceGen.g:6496:1: rule__AttributeDefinition__Group__2__Impl : ( ( rule__AttributeDefinition__ValueAssignment_2 ) ) ;
    public final void rule__AttributeDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6500:1: ( ( ( rule__AttributeDefinition__ValueAssignment_2 ) ) )
            // InternalAceGen.g:6501:1: ( ( rule__AttributeDefinition__ValueAssignment_2 ) )
            {
            // InternalAceGen.g:6501:1: ( ( rule__AttributeDefinition__ValueAssignment_2 ) )
            // InternalAceGen.g:6502:2: ( rule__AttributeDefinition__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeDefinitionAccess().getValueAssignment_2()); 
            // InternalAceGen.g:6503:2: ( rule__AttributeDefinition__ValueAssignment_2 )
            // InternalAceGen.g:6503:3: rule__AttributeDefinition__ValueAssignment_2
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
    // InternalAceGen.g:6512:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6516:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalAceGen.g:6517:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_55);
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
    // InternalAceGen.g:6524:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__UniqueAssignment_0 )? ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6528:1: ( ( ( rule__Attribute__UniqueAssignment_0 )? ) )
            // InternalAceGen.g:6529:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            {
            // InternalAceGen.g:6529:1: ( ( rule__Attribute__UniqueAssignment_0 )? )
            // InternalAceGen.g:6530:2: ( rule__Attribute__UniqueAssignment_0 )?
            {
             before(grammarAccess.getAttributeAccess().getUniqueAssignment_0()); 
            // InternalAceGen.g:6531:2: ( rule__Attribute__UniqueAssignment_0 )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==72) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalAceGen.g:6531:3: rule__Attribute__UniqueAssignment_0
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
    // InternalAceGen.g:6539:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6543:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalAceGen.g:6544:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FOLLOW_55);
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
    // InternalAceGen.g:6551:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__PrimaryKeyAssignment_1 )? ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6555:1: ( ( ( rule__Attribute__PrimaryKeyAssignment_1 )? ) )
            // InternalAceGen.g:6556:1: ( ( rule__Attribute__PrimaryKeyAssignment_1 )? )
            {
            // InternalAceGen.g:6556:1: ( ( rule__Attribute__PrimaryKeyAssignment_1 )? )
            // InternalAceGen.g:6557:2: ( rule__Attribute__PrimaryKeyAssignment_1 )?
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyAssignment_1()); 
            // InternalAceGen.g:6558:2: ( rule__Attribute__PrimaryKeyAssignment_1 )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==73) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalAceGen.g:6558:3: rule__Attribute__PrimaryKeyAssignment_1
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
    // InternalAceGen.g:6566:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6570:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // InternalAceGen.g:6571:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
            {
            pushFollow(FOLLOW_55);
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
    // InternalAceGen.g:6578:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ConstraintAssignment_2 )? ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6582:1: ( ( ( rule__Attribute__ConstraintAssignment_2 )? ) )
            // InternalAceGen.g:6583:1: ( ( rule__Attribute__ConstraintAssignment_2 )? )
            {
            // InternalAceGen.g:6583:1: ( ( rule__Attribute__ConstraintAssignment_2 )? )
            // InternalAceGen.g:6584:2: ( rule__Attribute__ConstraintAssignment_2 )?
            {
             before(grammarAccess.getAttributeAccess().getConstraintAssignment_2()); 
            // InternalAceGen.g:6585:2: ( rule__Attribute__ConstraintAssignment_2 )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( ((LA87_0>=25 && LA87_0<=26)) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalAceGen.g:6585:3: rule__Attribute__ConstraintAssignment_2
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
    // InternalAceGen.g:6593:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl rule__Attribute__Group__4 ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6597:1: ( rule__Attribute__Group__3__Impl rule__Attribute__Group__4 )
            // InternalAceGen.g:6598:2: rule__Attribute__Group__3__Impl rule__Attribute__Group__4
            {
            pushFollow(FOLLOW_55);
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
    // InternalAceGen.g:6605:1: rule__Attribute__Group__3__Impl : ( ( rule__Attribute__ListAssignment_3 )? ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6609:1: ( ( ( rule__Attribute__ListAssignment_3 )? ) )
            // InternalAceGen.g:6610:1: ( ( rule__Attribute__ListAssignment_3 )? )
            {
            // InternalAceGen.g:6610:1: ( ( rule__Attribute__ListAssignment_3 )? )
            // InternalAceGen.g:6611:2: ( rule__Attribute__ListAssignment_3 )?
            {
             before(grammarAccess.getAttributeAccess().getListAssignment_3()); 
            // InternalAceGen.g:6612:2: ( rule__Attribute__ListAssignment_3 )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==74) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalAceGen.g:6612:3: rule__Attribute__ListAssignment_3
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
    // InternalAceGen.g:6620:1: rule__Attribute__Group__4 : rule__Attribute__Group__4__Impl rule__Attribute__Group__5 ;
    public final void rule__Attribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6624:1: ( rule__Attribute__Group__4__Impl rule__Attribute__Group__5 )
            // InternalAceGen.g:6625:2: rule__Attribute__Group__4__Impl rule__Attribute__Group__5
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
    // InternalAceGen.g:6632:1: rule__Attribute__Group__4__Impl : ( ( rule__Attribute__Alternatives_4 ) ) ;
    public final void rule__Attribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6636:1: ( ( ( rule__Attribute__Alternatives_4 ) ) )
            // InternalAceGen.g:6637:1: ( ( rule__Attribute__Alternatives_4 ) )
            {
            // InternalAceGen.g:6637:1: ( ( rule__Attribute__Alternatives_4 ) )
            // InternalAceGen.g:6638:2: ( rule__Attribute__Alternatives_4 )
            {
             before(grammarAccess.getAttributeAccess().getAlternatives_4()); 
            // InternalAceGen.g:6639:2: ( rule__Attribute__Alternatives_4 )
            // InternalAceGen.g:6639:3: rule__Attribute__Alternatives_4
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
    // InternalAceGen.g:6647:1: rule__Attribute__Group__5 : rule__Attribute__Group__5__Impl rule__Attribute__Group__6 ;
    public final void rule__Attribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6651:1: ( rule__Attribute__Group__5__Impl rule__Attribute__Group__6 )
            // InternalAceGen.g:6652:2: rule__Attribute__Group__5__Impl rule__Attribute__Group__6
            {
            pushFollow(FOLLOW_56);
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
    // InternalAceGen.g:6659:1: rule__Attribute__Group__5__Impl : ( ( rule__Attribute__NameAssignment_5 ) ) ;
    public final void rule__Attribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6663:1: ( ( ( rule__Attribute__NameAssignment_5 ) ) )
            // InternalAceGen.g:6664:1: ( ( rule__Attribute__NameAssignment_5 ) )
            {
            // InternalAceGen.g:6664:1: ( ( rule__Attribute__NameAssignment_5 ) )
            // InternalAceGen.g:6665:2: ( rule__Attribute__NameAssignment_5 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_5()); 
            // InternalAceGen.g:6666:2: ( rule__Attribute__NameAssignment_5 )
            // InternalAceGen.g:6666:3: rule__Attribute__NameAssignment_5
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
    // InternalAceGen.g:6674:1: rule__Attribute__Group__6 : rule__Attribute__Group__6__Impl rule__Attribute__Group__7 ;
    public final void rule__Attribute__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6678:1: ( rule__Attribute__Group__6__Impl rule__Attribute__Group__7 )
            // InternalAceGen.g:6679:2: rule__Attribute__Group__6__Impl rule__Attribute__Group__7
            {
            pushFollow(FOLLOW_56);
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
    // InternalAceGen.g:6686:1: rule__Attribute__Group__6__Impl : ( ( rule__Attribute__Group_6__0 )? ) ;
    public final void rule__Attribute__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6690:1: ( ( ( rule__Attribute__Group_6__0 )? ) )
            // InternalAceGen.g:6691:1: ( ( rule__Attribute__Group_6__0 )? )
            {
            // InternalAceGen.g:6691:1: ( ( rule__Attribute__Group_6__0 )? )
            // InternalAceGen.g:6692:2: ( rule__Attribute__Group_6__0 )?
            {
             before(grammarAccess.getAttributeAccess().getGroup_6()); 
            // InternalAceGen.g:6693:2: ( rule__Attribute__Group_6__0 )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==63) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalAceGen.g:6693:3: rule__Attribute__Group_6__0
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
    // InternalAceGen.g:6701:1: rule__Attribute__Group__7 : rule__Attribute__Group__7__Impl ;
    public final void rule__Attribute__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6705:1: ( rule__Attribute__Group__7__Impl )
            // InternalAceGen.g:6706:2: rule__Attribute__Group__7__Impl
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
    // InternalAceGen.g:6712:1: rule__Attribute__Group__7__Impl : ( ( rule__Attribute__NotReplayableAssignment_7 )? ) ;
    public final void rule__Attribute__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6716:1: ( ( ( rule__Attribute__NotReplayableAssignment_7 )? ) )
            // InternalAceGen.g:6717:1: ( ( rule__Attribute__NotReplayableAssignment_7 )? )
            {
            // InternalAceGen.g:6717:1: ( ( rule__Attribute__NotReplayableAssignment_7 )? )
            // InternalAceGen.g:6718:2: ( rule__Attribute__NotReplayableAssignment_7 )?
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableAssignment_7()); 
            // InternalAceGen.g:6719:2: ( rule__Attribute__NotReplayableAssignment_7 )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==75) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalAceGen.g:6719:3: rule__Attribute__NotReplayableAssignment_7
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
    // InternalAceGen.g:6728:1: rule__Attribute__Group_6__0 : rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 ;
    public final void rule__Attribute__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6732:1: ( rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1 )
            // InternalAceGen.g:6733:2: rule__Attribute__Group_6__0__Impl rule__Attribute__Group_6__1
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
    // InternalAceGen.g:6740:1: rule__Attribute__Group_6__0__Impl : ( 'references' ) ;
    public final void rule__Attribute__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6744:1: ( ( 'references' ) )
            // InternalAceGen.g:6745:1: ( 'references' )
            {
            // InternalAceGen.g:6745:1: ( 'references' )
            // InternalAceGen.g:6746:2: 'references'
            {
             before(grammarAccess.getAttributeAccess().getReferencesKeyword_6_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalAceGen.g:6755:1: rule__Attribute__Group_6__1 : rule__Attribute__Group_6__1__Impl ;
    public final void rule__Attribute__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6759:1: ( rule__Attribute__Group_6__1__Impl )
            // InternalAceGen.g:6760:2: rule__Attribute__Group_6__1__Impl
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
    // InternalAceGen.g:6766:1: rule__Attribute__Group_6__1__Impl : ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) ) ;
    public final void rule__Attribute__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6770:1: ( ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) ) )
            // InternalAceGen.g:6771:1: ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) )
            {
            // InternalAceGen.g:6771:1: ( ( rule__Attribute__ForeignKeyAssignment_6_1 ) )
            // InternalAceGen.g:6772:2: ( rule__Attribute__ForeignKeyAssignment_6_1 )
            {
             before(grammarAccess.getAttributeAccess().getForeignKeyAssignment_6_1()); 
            // InternalAceGen.g:6773:2: ( rule__Attribute__ForeignKeyAssignment_6_1 )
            // InternalAceGen.g:6773:3: rule__Attribute__ForeignKeyAssignment_6_1
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
    // InternalAceGen.g:6782:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6786:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalAceGen.g:6787:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_57);
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
    // InternalAceGen.g:6794:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6798:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6799:1: ( RULE_ID )
            {
            // InternalAceGen.g:6799:1: ( RULE_ID )
            // InternalAceGen.g:6800:2: RULE_ID
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
    // InternalAceGen.g:6809:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6813:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalAceGen.g:6814:2: rule__QualifiedName__Group__1__Impl
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
    // InternalAceGen.g:6820:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6824:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalAceGen.g:6825:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalAceGen.g:6825:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalAceGen.g:6826:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalAceGen.g:6827:2: ( rule__QualifiedName__Group_1__0 )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==64) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalAceGen.g:6827:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_58);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop91;
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
    // InternalAceGen.g:6836:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6840:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalAceGen.g:6841:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalAceGen.g:6848:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6852:1: ( ( '.' ) )
            // InternalAceGen.g:6853:1: ( '.' )
            {
            // InternalAceGen.g:6853:1: ( '.' )
            // InternalAceGen.g:6854:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,64,FOLLOW_2); 
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
    // InternalAceGen.g:6863:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6867:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalAceGen.g:6868:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalAceGen.g:6874:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6878:1: ( ( RULE_ID ) )
            // InternalAceGen.g:6879:1: ( RULE_ID )
            {
            // InternalAceGen.g:6879:1: ( RULE_ID )
            // InternalAceGen.g:6880:2: RULE_ID
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


    // $ANTLR start "rule__Value__Group_2__0"
    // InternalAceGen.g:6890:1: rule__Value__Group_2__0 : rule__Value__Group_2__0__Impl rule__Value__Group_2__1 ;
    public final void rule__Value__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6894:1: ( rule__Value__Group_2__0__Impl rule__Value__Group_2__1 )
            // InternalAceGen.g:6895:2: rule__Value__Group_2__0__Impl rule__Value__Group_2__1
            {
            pushFollow(FOLLOW_32);
            rule__Value__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Value__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__0"


    // $ANTLR start "rule__Value__Group_2__0__Impl"
    // InternalAceGen.g:6902:1: rule__Value__Group_2__0__Impl : ( ( rule__Value__DateValueAssignment_2_0 ) ) ;
    public final void rule__Value__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6906:1: ( ( ( rule__Value__DateValueAssignment_2_0 ) ) )
            // InternalAceGen.g:6907:1: ( ( rule__Value__DateValueAssignment_2_0 ) )
            {
            // InternalAceGen.g:6907:1: ( ( rule__Value__DateValueAssignment_2_0 ) )
            // InternalAceGen.g:6908:2: ( rule__Value__DateValueAssignment_2_0 )
            {
             before(grammarAccess.getValueAccess().getDateValueAssignment_2_0()); 
            // InternalAceGen.g:6909:2: ( rule__Value__DateValueAssignment_2_0 )
            // InternalAceGen.g:6909:3: rule__Value__DateValueAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Value__DateValueAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getDateValueAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__0__Impl"


    // $ANTLR start "rule__Value__Group_2__1"
    // InternalAceGen.g:6917:1: rule__Value__Group_2__1 : rule__Value__Group_2__1__Impl ;
    public final void rule__Value__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6921:1: ( rule__Value__Group_2__1__Impl )
            // InternalAceGen.g:6922:2: rule__Value__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Value__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__1"


    // $ANTLR start "rule__Value__Group_2__1__Impl"
    // InternalAceGen.g:6928:1: rule__Value__Group_2__1__Impl : ( ( rule__Value__PatternAssignment_2_1 ) ) ;
    public final void rule__Value__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6932:1: ( ( ( rule__Value__PatternAssignment_2_1 ) ) )
            // InternalAceGen.g:6933:1: ( ( rule__Value__PatternAssignment_2_1 ) )
            {
            // InternalAceGen.g:6933:1: ( ( rule__Value__PatternAssignment_2_1 ) )
            // InternalAceGen.g:6934:2: ( rule__Value__PatternAssignment_2_1 )
            {
             before(grammarAccess.getValueAccess().getPatternAssignment_2_1()); 
            // InternalAceGen.g:6935:2: ( rule__Value__PatternAssignment_2_1 )
            // InternalAceGen.g:6935:3: rule__Value__PatternAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Value__PatternAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getPatternAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__1__Impl"


    // $ANTLR start "rule__Project__HttpClientAssignment_1_0_1"
    // InternalAceGen.g:6944:1: rule__Project__HttpClientAssignment_1_0_1 : ( ruleHttpClient ) ;
    public final void rule__Project__HttpClientAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6948:1: ( ( ruleHttpClient ) )
            // InternalAceGen.g:6949:2: ( ruleHttpClient )
            {
            // InternalAceGen.g:6949:2: ( ruleHttpClient )
            // InternalAceGen.g:6950:3: ruleHttpClient
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
    // InternalAceGen.g:6959:1: rule__Project__HttpServerAssignment_1_1_1 : ( ruleHttpServer ) ;
    public final void rule__Project__HttpServerAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6963:1: ( ( ruleHttpServer ) )
            // InternalAceGen.g:6964:2: ( ruleHttpServer )
            {
            // InternalAceGen.g:6964:2: ( ruleHttpServer )
            // InternalAceGen.g:6965:3: ruleHttpServer
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
    // InternalAceGen.g:6974:1: rule__HttpClient__NameAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__HttpClient__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6978:1: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:6979:2: ( ruleQualifiedName )
            {
            // InternalAceGen.g:6979:2: ( ruleQualifiedName )
            // InternalAceGen.g:6980:3: ruleQualifiedName
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
    // InternalAceGen.g:6989:1: rule__HttpClient__AceOperationsAssignment_1_1 : ( ruleHttpClientAce ) ;
    public final void rule__HttpClient__AceOperationsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:6993:1: ( ( ruleHttpClientAce ) )
            // InternalAceGen.g:6994:2: ( ruleHttpClientAce )
            {
            // InternalAceGen.g:6994:2: ( ruleHttpClientAce )
            // InternalAceGen.g:6995:3: ruleHttpClientAce
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
    // InternalAceGen.g:7004:1: rule__HttpClient__AppStateAssignment_2_1 : ( ruleHttpClientStateElement ) ;
    public final void rule__HttpClient__AppStateAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7008:1: ( ( ruleHttpClientStateElement ) )
            // InternalAceGen.g:7009:2: ( ruleHttpClientStateElement )
            {
            // InternalAceGen.g:7009:2: ( ruleHttpClientStateElement )
            // InternalAceGen.g:7010:3: ruleHttpClientStateElement
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
    // InternalAceGen.g:7019:1: rule__HttpClientAce__AsyncAssignment_0 : ( ( 'async' ) ) ;
    public final void rule__HttpClientAce__AsyncAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7023:1: ( ( ( 'async' ) ) )
            // InternalAceGen.g:7024:2: ( ( 'async' ) )
            {
            // InternalAceGen.g:7024:2: ( ( 'async' ) )
            // InternalAceGen.g:7025:3: ( 'async' )
            {
             before(grammarAccess.getHttpClientAceAccess().getAsyncAsyncKeyword_0_0()); 
            // InternalAceGen.g:7026:3: ( 'async' )
            // InternalAceGen.g:7027:4: 'async'
            {
             before(grammarAccess.getHttpClientAceAccess().getAsyncAsyncKeyword_0_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalAceGen.g:7038:1: rule__HttpClientAce__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7042:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7043:2: ( RULE_ID )
            {
            // InternalAceGen.g:7043:2: ( RULE_ID )
            // InternalAceGen.g:7044:3: RULE_ID
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
    // InternalAceGen.g:7053:1: rule__HttpClientAce__InputAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__InputAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7057:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7058:2: ( RULE_ID )
            {
            // InternalAceGen.g:7058:2: ( RULE_ID )
            // InternalAceGen.g:7059:3: RULE_ID
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
    // InternalAceGen.g:7068:1: rule__HttpClientAce__InputAssignment_2_2_1 : ( RULE_ID ) ;
    public final void rule__HttpClientAce__InputAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7072:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7073:2: ( RULE_ID )
            {
            // InternalAceGen.g:7073:2: ( RULE_ID )
            // InternalAceGen.g:7074:3: RULE_ID
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
    // InternalAceGen.g:7083:1: rule__HttpClientAce__ServerCallAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientAce__ServerCallAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7087:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7088:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7088:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7089:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceCrossReference_3_1_0()); 
            // InternalAceGen.g:7090:3: ( ruleQualifiedName )
            // InternalAceGen.g:7091:4: ruleQualifiedName
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
    // InternalAceGen.g:7102:1: rule__HttpClientAce__LoadingFlagAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientAce__LoadingFlagAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7106:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7107:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7107:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7108:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementCrossReference_4_1_0()); 
            // InternalAceGen.g:7109:3: ( ruleQualifiedName )
            // InternalAceGen.g:7110:4: ruleQualifiedName
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
    // InternalAceGen.g:7121:1: rule__HttpClientAce__OutcomesAssignment_5 : ( ruleHttpClientOutcome ) ;
    public final void rule__HttpClientAce__OutcomesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7125:1: ( ( ruleHttpClientOutcome ) )
            // InternalAceGen.g:7126:2: ( ruleHttpClientOutcome )
            {
            // InternalAceGen.g:7126:2: ( ruleHttpClientOutcome )
            // InternalAceGen.g:7127:3: ruleHttpClientOutcome
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
    // InternalAceGen.g:7136:1: rule__HttpClientOutcome__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientOutcome__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7140:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7141:2: ( RULE_ID )
            {
            // InternalAceGen.g:7141:2: ( RULE_ID )
            // InternalAceGen.g:7142:3: RULE_ID
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
    // InternalAceGen.g:7151:1: rule__HttpClientOutcome__ListenersAssignment_2_1 : ( ruleHttpClientStateFunction ) ;
    public final void rule__HttpClientOutcome__ListenersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7155:1: ( ( ruleHttpClientStateFunction ) )
            // InternalAceGen.g:7156:2: ( ruleHttpClientStateFunction )
            {
            // InternalAceGen.g:7156:2: ( ruleHttpClientStateFunction )
            // InternalAceGen.g:7157:3: ruleHttpClientStateFunction
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
    // InternalAceGen.g:7166:1: rule__HttpClientOutcome__AceOperationsAssignment_3_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientOutcome__AceOperationsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7170:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7171:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7171:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7172:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsHttpClientAceCrossReference_3_2_0()); 
            // InternalAceGen.g:7173:3: ( ruleQualifiedName )
            // InternalAceGen.g:7174:4: ruleQualifiedName
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
    // InternalAceGen.g:7185:1: rule__HttpClientStateFunction__StateFunctionTypeAssignment_0 : ( ruleHttpClientStateFunctionType ) ;
    public final void rule__HttpClientStateFunction__StateFunctionTypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7189:1: ( ( ruleHttpClientStateFunctionType ) )
            // InternalAceGen.g:7190:2: ( ruleHttpClientStateFunctionType )
            {
            // InternalAceGen.g:7190:2: ( ruleHttpClientStateFunctionType )
            // InternalAceGen.g:7191:3: ruleHttpClientStateFunctionType
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
    // InternalAceGen.g:7200:1: rule__HttpClientStateFunction__AttributeAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpClientStateFunction__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7204:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7205:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7205:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7206:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpClientStateFunctionAccess().getAttributeHttpClientStateElementCrossReference_1_0()); 
            // InternalAceGen.g:7207:3: ( ruleQualifiedName )
            // InternalAceGen.g:7208:4: ruleQualifiedName
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
    // InternalAceGen.g:7219:1: rule__HttpClientStateElement__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpClientStateElement__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7223:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7224:2: ( RULE_ID )
            {
            // InternalAceGen.g:7224:2: ( RULE_ID )
            // InternalAceGen.g:7225:3: RULE_ID
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
    // InternalAceGen.g:7234:1: rule__HttpClientStateElement__ListAssignment_1 : ( ( 'list' ) ) ;
    public final void rule__HttpClientStateElement__ListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7238:1: ( ( ( 'list' ) ) )
            // InternalAceGen.g:7239:2: ( ( 'list' ) )
            {
            // InternalAceGen.g:7239:2: ( ( 'list' ) )
            // InternalAceGen.g:7240:3: ( 'list' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 
            // InternalAceGen.g:7241:3: ( 'list' )
            // InternalAceGen.g:7242:4: 'list'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalAceGen.g:7253:1: rule__HttpClientStateElement__HashAssignment_2 : ( ( 'location.hash' ) ) ;
    public final void rule__HttpClientStateElement__HashAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7257:1: ( ( ( 'location.hash' ) ) )
            // InternalAceGen.g:7258:2: ( ( 'location.hash' ) )
            {
            // InternalAceGen.g:7258:2: ( ( 'location.hash' ) )
            // InternalAceGen.g:7259:3: ( 'location.hash' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 
            // InternalAceGen.g:7260:3: ( 'location.hash' )
            // InternalAceGen.g:7261:4: 'location.hash'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0()); 
            match(input,67,FOLLOW_2); 
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
    // InternalAceGen.g:7272:1: rule__HttpClientStateElement__StorageAssignment_3 : ( ( 'storage' ) ) ;
    public final void rule__HttpClientStateElement__StorageAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7276:1: ( ( ( 'storage' ) ) )
            // InternalAceGen.g:7277:2: ( ( 'storage' ) )
            {
            // InternalAceGen.g:7277:2: ( ( 'storage' ) )
            // InternalAceGen.g:7278:3: ( 'storage' )
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 
            // InternalAceGen.g:7279:3: ( 'storage' )
            // InternalAceGen.g:7280:4: 'storage'
            {
             before(grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalAceGen.g:7291:1: rule__HttpClientStateElement__TypesAssignment_4_0 : ( ruleHttpClientTypeDefinition ) ;
    public final void rule__HttpClientStateElement__TypesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7295:1: ( ( ruleHttpClientTypeDefinition ) )
            // InternalAceGen.g:7296:2: ( ruleHttpClientTypeDefinition )
            {
            // InternalAceGen.g:7296:2: ( ruleHttpClientTypeDefinition )
            // InternalAceGen.g:7297:3: ruleHttpClientTypeDefinition
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
    // InternalAceGen.g:7306:1: rule__HttpClientStateElement__TypesAssignment_4_1_1 : ( ruleHttpClientTypeDefinition ) ;
    public final void rule__HttpClientStateElement__TypesAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7310:1: ( ( ruleHttpClientTypeDefinition ) )
            // InternalAceGen.g:7311:2: ( ruleHttpClientTypeDefinition )
            {
            // InternalAceGen.g:7311:2: ( ruleHttpClientTypeDefinition )
            // InternalAceGen.g:7312:3: ruleHttpClientTypeDefinition
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
    // InternalAceGen.g:7321:1: rule__HttpClientTypeDefinition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpClientTypeDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7325:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7326:2: ( RULE_ID )
            {
            // InternalAceGen.g:7326:2: ( RULE_ID )
            // InternalAceGen.g:7327:3: RULE_ID
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
    // InternalAceGen.g:7336:1: rule__HttpClientTypeDefinition__ElementsAssignment_3 : ( ruleHttpClientStateElement ) ;
    public final void rule__HttpClientTypeDefinition__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7340:1: ( ( ruleHttpClientStateElement ) )
            // InternalAceGen.g:7341:2: ( ruleHttpClientStateElement )
            {
            // InternalAceGen.g:7341:2: ( ruleHttpClientStateElement )
            // InternalAceGen.g:7342:3: ruleHttpClientStateElement
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
    // InternalAceGen.g:7351:1: rule__HttpServer__NameAssignment_0 : ( ruleQualifiedName ) ;
    public final void rule__HttpServer__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7355:1: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7356:2: ( ruleQualifiedName )
            {
            // InternalAceGen.g:7356:2: ( ruleQualifiedName )
            // InternalAceGen.g:7357:3: ruleQualifiedName
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
    // InternalAceGen.g:7366:1: rule__HttpServer__AuthUserAssignment_1_1 : ( ruleAuthUser ) ;
    public final void rule__HttpServer__AuthUserAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7370:1: ( ( ruleAuthUser ) )
            // InternalAceGen.g:7371:2: ( ruleAuthUser )
            {
            // InternalAceGen.g:7371:2: ( ruleAuthUser )
            // InternalAceGen.g:7372:3: ruleAuthUser
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
    // InternalAceGen.g:7381:1: rule__HttpServer__AuthUserRefAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServer__AuthUserRefAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7385:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7386:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7386:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7387:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_2_1_0()); 
            // InternalAceGen.g:7388:3: ( ruleQualifiedName )
            // InternalAceGen.g:7389:4: ruleQualifiedName
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
    // InternalAceGen.g:7400:1: rule__HttpServer__AceOperationsAssignment_3_1 : ( ruleHttpServerAce ) ;
    public final void rule__HttpServer__AceOperationsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7404:1: ( ( ruleHttpServerAce ) )
            // InternalAceGen.g:7405:2: ( ruleHttpServerAce )
            {
            // InternalAceGen.g:7405:2: ( ruleHttpServerAce )
            // InternalAceGen.g:7406:3: ruleHttpServerAce
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
    // InternalAceGen.g:7415:1: rule__HttpServer__ViewsAssignment_4_1 : ( ruleHttpServerView ) ;
    public final void rule__HttpServer__ViewsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7419:1: ( ( ruleHttpServerView ) )
            // InternalAceGen.g:7420:2: ( ruleHttpServerView )
            {
            // InternalAceGen.g:7420:2: ( ruleHttpServerView )
            // InternalAceGen.g:7421:3: ruleHttpServerView
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
    // InternalAceGen.g:7430:1: rule__HttpServer__ModelsAssignment_5_1 : ( ruleModel ) ;
    public final void rule__HttpServer__ModelsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7434:1: ( ( ruleModel ) )
            // InternalAceGen.g:7435:2: ( ruleModel )
            {
            // InternalAceGen.g:7435:2: ( ruleModel )
            // InternalAceGen.g:7436:3: ruleModel
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
    // InternalAceGen.g:7445:1: rule__HttpServer__ScenariosAssignment_6_1 : ( ruleScenario ) ;
    public final void rule__HttpServer__ScenariosAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7449:1: ( ( ruleScenario ) )
            // InternalAceGen.g:7450:2: ( ruleScenario )
            {
            // InternalAceGen.g:7450:2: ( ruleScenario )
            // InternalAceGen.g:7451:3: ruleScenario
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
    // InternalAceGen.g:7460:1: rule__HttpServerAceWrite__ProxyAssignment_0 : ( ( 'proxy' ) ) ;
    public final void rule__HttpServerAceWrite__ProxyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7464:1: ( ( ( 'proxy' ) ) )
            // InternalAceGen.g:7465:2: ( ( 'proxy' ) )
            {
            // InternalAceGen.g:7465:2: ( ( 'proxy' ) )
            // InternalAceGen.g:7466:3: ( 'proxy' )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 
            // InternalAceGen.g:7467:3: ( 'proxy' )
            // InternalAceGen.g:7468:4: 'proxy'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0()); 
            match(input,69,FOLLOW_2); 
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
    // InternalAceGen.g:7479:1: rule__HttpServerAceWrite__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerAceWrite__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7483:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7484:2: ( RULE_ID )
            {
            // InternalAceGen.g:7484:2: ( RULE_ID )
            // InternalAceGen.g:7485:3: RULE_ID
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
    // InternalAceGen.g:7494:1: rule__HttpServerAceWrite__ModelAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7498:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7499:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7499:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7500:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_3_0()); 
            // InternalAceGen.g:7501:3: ( ruleQualifiedName )
            // InternalAceGen.g:7502:4: ruleQualifiedName
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
    // InternalAceGen.g:7513:1: rule__HttpServerAceWrite__TypeAssignment_5 : ( ruleWriteFunctionType ) ;
    public final void rule__HttpServerAceWrite__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7517:1: ( ( ruleWriteFunctionType ) )
            // InternalAceGen.g:7518:2: ( ruleWriteFunctionType )
            {
            // InternalAceGen.g:7518:2: ( ruleWriteFunctionType )
            // InternalAceGen.g:7519:3: ruleWriteFunctionType
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
    // InternalAceGen.g:7528:1: rule__HttpServerAceWrite__UrlAssignment_6 : ( RULE_STRING ) ;
    public final void rule__HttpServerAceWrite__UrlAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7532:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7533:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7533:2: ( RULE_STRING )
            // InternalAceGen.g:7534:3: RULE_STRING
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
    // InternalAceGen.g:7543:1: rule__HttpServerAceWrite__AuthorizeAssignment_7 : ( ( 'authorize' ) ) ;
    public final void rule__HttpServerAceWrite__AuthorizeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7547:1: ( ( ( 'authorize' ) ) )
            // InternalAceGen.g:7548:2: ( ( 'authorize' ) )
            {
            // InternalAceGen.g:7548:2: ( ( 'authorize' ) )
            // InternalAceGen.g:7549:3: ( 'authorize' )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            // InternalAceGen.g:7550:3: ( 'authorize' )
            // InternalAceGen.g:7551:4: 'authorize'
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            match(input,70,FOLLOW_2); 
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
    // InternalAceGen.g:7562:1: rule__HttpServerAceWrite__PathParamsAssignment_8_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__PathParamsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7566:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7567:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7567:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7568:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeCrossReference_8_1_0()); 
            // InternalAceGen.g:7569:3: ( ruleQualifiedName )
            // InternalAceGen.g:7570:4: ruleQualifiedName
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
    // InternalAceGen.g:7581:1: rule__HttpServerAceWrite__QueryParamsAssignment_9_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__QueryParamsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7585:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7586:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7586:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7587:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeCrossReference_9_1_0()); 
            // InternalAceGen.g:7588:3: ( ruleQualifiedName )
            // InternalAceGen.g:7589:4: ruleQualifiedName
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
    // InternalAceGen.g:7600:1: rule__HttpServerAceWrite__PayloadAssignment_10_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__PayloadAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7604:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7605:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7605:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7606:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeCrossReference_10_1_0()); 
            // InternalAceGen.g:7607:3: ( ruleQualifiedName )
            // InternalAceGen.g:7608:4: ruleQualifiedName
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
    // InternalAceGen.g:7619:1: rule__HttpServerAceWrite__ResponseAssignment_11_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceWrite__ResponseAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7623:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7624:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7624:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7625:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeCrossReference_11_1_0()); 
            // InternalAceGen.g:7626:3: ( ruleQualifiedName )
            // InternalAceGen.g:7627:4: ruleQualifiedName
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
    // InternalAceGen.g:7638:1: rule__HttpServerAceWrite__OutcomesAssignment_12 : ( ruleHttpServerOutcome ) ;
    public final void rule__HttpServerAceWrite__OutcomesAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7642:1: ( ( ruleHttpServerOutcome ) )
            // InternalAceGen.g:7643:2: ( ruleHttpServerOutcome )
            {
            // InternalAceGen.g:7643:2: ( ruleHttpServerOutcome )
            // InternalAceGen.g:7644:3: ruleHttpServerOutcome
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
    // InternalAceGen.g:7653:1: rule__HttpServerOutcome__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerOutcome__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7657:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7658:2: ( RULE_ID )
            {
            // InternalAceGen.g:7658:2: ( RULE_ID )
            // InternalAceGen.g:7659:3: RULE_ID
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
    // InternalAceGen.g:7668:1: rule__HttpServerOutcome__ListenersAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerOutcome__ListenersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7672:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7673:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7673:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7674:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0()); 
            // InternalAceGen.g:7675:3: ( ruleQualifiedName )
            // InternalAceGen.g:7676:4: ruleQualifiedName
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
    // InternalAceGen.g:7687:1: rule__HttpServerAceRead__ProxyAssignment_0 : ( ( 'proxy' ) ) ;
    public final void rule__HttpServerAceRead__ProxyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7691:1: ( ( ( 'proxy' ) ) )
            // InternalAceGen.g:7692:2: ( ( 'proxy' ) )
            {
            // InternalAceGen.g:7692:2: ( ( 'proxy' ) )
            // InternalAceGen.g:7693:3: ( 'proxy' )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 
            // InternalAceGen.g:7694:3: ( 'proxy' )
            // InternalAceGen.g:7695:4: 'proxy'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0()); 
            match(input,69,FOLLOW_2); 
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
    // InternalAceGen.g:7706:1: rule__HttpServerAceRead__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__HttpServerAceRead__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7710:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7711:2: ( RULE_ID )
            {
            // InternalAceGen.g:7711:2: ( RULE_ID )
            // InternalAceGen.g:7712:3: RULE_ID
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
    // InternalAceGen.g:7721:1: rule__HttpServerAceRead__ModelAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7725:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7726:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7726:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7727:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_3_0()); 
            // InternalAceGen.g:7728:3: ( ruleQualifiedName )
            // InternalAceGen.g:7729:4: ruleQualifiedName
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
    // InternalAceGen.g:7740:1: rule__HttpServerAceRead__TypeAssignment_5 : ( ruleReadFunctionType ) ;
    public final void rule__HttpServerAceRead__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7744:1: ( ( ruleReadFunctionType ) )
            // InternalAceGen.g:7745:2: ( ruleReadFunctionType )
            {
            // InternalAceGen.g:7745:2: ( ruleReadFunctionType )
            // InternalAceGen.g:7746:3: ruleReadFunctionType
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
    // InternalAceGen.g:7755:1: rule__HttpServerAceRead__UrlAssignment_6 : ( RULE_STRING ) ;
    public final void rule__HttpServerAceRead__UrlAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7759:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:7760:2: ( RULE_STRING )
            {
            // InternalAceGen.g:7760:2: ( RULE_STRING )
            // InternalAceGen.g:7761:3: RULE_STRING
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
    // InternalAceGen.g:7770:1: rule__HttpServerAceRead__AuthorizeAssignment_7 : ( ( 'authorize' ) ) ;
    public final void rule__HttpServerAceRead__AuthorizeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7774:1: ( ( ( 'authorize' ) ) )
            // InternalAceGen.g:7775:2: ( ( 'authorize' ) )
            {
            // InternalAceGen.g:7775:2: ( ( 'authorize' ) )
            // InternalAceGen.g:7776:3: ( 'authorize' )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            // InternalAceGen.g:7777:3: ( 'authorize' )
            // InternalAceGen.g:7778:4: 'authorize'
            {
             before(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0()); 
            match(input,70,FOLLOW_2); 
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
    // InternalAceGen.g:7789:1: rule__HttpServerAceRead__PathParamsAssignment_8_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__PathParamsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7793:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7794:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7794:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7795:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeCrossReference_8_1_0()); 
            // InternalAceGen.g:7796:3: ( ruleQualifiedName )
            // InternalAceGen.g:7797:4: ruleQualifiedName
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
    // InternalAceGen.g:7808:1: rule__HttpServerAceRead__QueryParamsAssignment_9_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__QueryParamsAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7812:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7813:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7813:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7814:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeCrossReference_9_1_0()); 
            // InternalAceGen.g:7815:3: ( ruleQualifiedName )
            // InternalAceGen.g:7816:4: ruleQualifiedName
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
    // InternalAceGen.g:7827:1: rule__HttpServerAceRead__PayloadAssignment_10_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__PayloadAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7831:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7832:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7832:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7833:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeCrossReference_10_1_0()); 
            // InternalAceGen.g:7834:3: ( ruleQualifiedName )
            // InternalAceGen.g:7835:4: ruleQualifiedName
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
    // InternalAceGen.g:7846:1: rule__HttpServerAceRead__ResponseAssignment_11_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerAceRead__ResponseAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7850:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7851:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7851:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7852:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerAceReadAccess().getResponseAttributeCrossReference_11_1_0()); 
            // InternalAceGen.g:7853:3: ( ruleQualifiedName )
            // InternalAceGen.g:7854:4: ruleQualifiedName
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
    // InternalAceGen.g:7865:1: rule__HttpServerView__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpServerView__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7869:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7870:2: ( RULE_ID )
            {
            // InternalAceGen.g:7870:2: ( RULE_ID )
            // InternalAceGen.g:7871:3: RULE_ID
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
    // InternalAceGen.g:7880:1: rule__HttpServerView__RenderFunctionsAssignment_1_1 : ( ruleHttpServerViewFunction ) ;
    public final void rule__HttpServerView__RenderFunctionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7884:1: ( ( ruleHttpServerViewFunction ) )
            // InternalAceGen.g:7885:2: ( ruleHttpServerViewFunction )
            {
            // InternalAceGen.g:7885:2: ( ruleHttpServerViewFunction )
            // InternalAceGen.g:7886:3: ruleHttpServerViewFunction
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
    // InternalAceGen.g:7895:1: rule__HttpServerViewFunction__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__HttpServerViewFunction__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7899:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7900:2: ( RULE_ID )
            {
            // InternalAceGen.g:7900:2: ( RULE_ID )
            // InternalAceGen.g:7901:3: RULE_ID
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
    // InternalAceGen.g:7910:1: rule__HttpServerViewFunction__ModelAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__HttpServerViewFunction__ModelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7914:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7915:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7915:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7916:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0()); 
            // InternalAceGen.g:7917:3: ( ruleQualifiedName )
            // InternalAceGen.g:7918:4: ruleQualifiedName
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
    // InternalAceGen.g:7929:1: rule__AuthUser__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__AuthUser__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7933:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7934:2: ( RULE_ID )
            {
            // InternalAceGen.g:7934:2: ( RULE_ID )
            // InternalAceGen.g:7935:3: RULE_ID
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
    // InternalAceGen.g:7944:1: rule__AuthUser__AttributesAssignment_1_1 : ( ruleAttribute ) ;
    public final void rule__AuthUser__AttributesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7948:1: ( ( ruleAttribute ) )
            // InternalAceGen.g:7949:2: ( ruleAttribute )
            {
            // InternalAceGen.g:7949:2: ( ruleAttribute )
            // InternalAceGen.g:7950:3: ruleAttribute
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
    // InternalAceGen.g:7959:1: rule__Model__PersistentAssignment_0 : ( ( 'persistent' ) ) ;
    public final void rule__Model__PersistentAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7963:1: ( ( ( 'persistent' ) ) )
            // InternalAceGen.g:7964:2: ( ( 'persistent' ) )
            {
            // InternalAceGen.g:7964:2: ( ( 'persistent' ) )
            // InternalAceGen.g:7965:3: ( 'persistent' )
            {
             before(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 
            // InternalAceGen.g:7966:3: ( 'persistent' )
            // InternalAceGen.g:7967:4: 'persistent'
            {
             before(grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0()); 
            match(input,71,FOLLOW_2); 
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
    // InternalAceGen.g:7978:1: rule__Model__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7982:1: ( ( RULE_ID ) )
            // InternalAceGen.g:7983:2: ( RULE_ID )
            {
            // InternalAceGen.g:7983:2: ( RULE_ID )
            // InternalAceGen.g:7984:3: RULE_ID
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
    // InternalAceGen.g:7993:1: rule__Model__SuperModelsAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Model__SuperModelsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:7997:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:7998:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:7998:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:7999:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0()); 
            // InternalAceGen.g:8000:3: ( ruleQualifiedName )
            // InternalAceGen.g:8001:4: ruleQualifiedName
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
    // InternalAceGen.g:8012:1: rule__Model__SuperModelsAssignment_2_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Model__SuperModelsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8016:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8017:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8017:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8018:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0()); 
            // InternalAceGen.g:8019:3: ( ruleQualifiedName )
            // InternalAceGen.g:8020:4: ruleQualifiedName
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
    // InternalAceGen.g:8031:1: rule__Model__AttributesAssignment_3_1 : ( ruleAttribute ) ;
    public final void rule__Model__AttributesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8035:1: ( ( ruleAttribute ) )
            // InternalAceGen.g:8036:2: ( ruleAttribute )
            {
            // InternalAceGen.g:8036:2: ( ruleAttribute )
            // InternalAceGen.g:8037:3: ruleAttribute
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
    // InternalAceGen.g:8046:1: rule__Scenario__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Scenario__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8050:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8051:2: ( RULE_ID )
            {
            // InternalAceGen.g:8051:2: ( RULE_ID )
            // InternalAceGen.g:8052:3: RULE_ID
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
    // InternalAceGen.g:8061:1: rule__Scenario__GivenRefsAssignment_1_1 : ( ruleGivenRef ) ;
    public final void rule__Scenario__GivenRefsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8065:1: ( ( ruleGivenRef ) )
            // InternalAceGen.g:8066:2: ( ruleGivenRef )
            {
            // InternalAceGen.g:8066:2: ( ruleGivenRef )
            // InternalAceGen.g:8067:3: ruleGivenRef
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
    // InternalAceGen.g:8076:1: rule__Scenario__WhenBlockAssignment_3 : ( ruleWhenBlock ) ;
    public final void rule__Scenario__WhenBlockAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8080:1: ( ( ruleWhenBlock ) )
            // InternalAceGen.g:8081:2: ( ruleWhenBlock )
            {
            // InternalAceGen.g:8081:2: ( ruleWhenBlock )
            // InternalAceGen.g:8082:3: ruleWhenBlock
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
    // InternalAceGen.g:8091:1: rule__Scenario__ThenBlockAssignment_5 : ( ruleThenBlock ) ;
    public final void rule__Scenario__ThenBlockAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8095:1: ( ( ruleThenBlock ) )
            // InternalAceGen.g:8096:2: ( ruleThenBlock )
            {
            // InternalAceGen.g:8096:2: ( ruleThenBlock )
            // InternalAceGen.g:8097:3: ruleThenBlock
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
    // InternalAceGen.g:8106:1: rule__GivenRef__ScenarioAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__GivenRef__ScenarioAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8110:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8111:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8111:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8112:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getGivenRefAccess().getScenarioScenarioCrossReference_0_0()); 
            // InternalAceGen.g:8113:3: ( ruleQualifiedName )
            // InternalAceGen.g:8114:4: ruleQualifiedName
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
    // InternalAceGen.g:8125:1: rule__GivenRef__TimesAssignment_1_0 : ( RULE_INT ) ;
    public final void rule__GivenRef__TimesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8129:1: ( ( RULE_INT ) )
            // InternalAceGen.g:8130:2: ( RULE_INT )
            {
            // InternalAceGen.g:8130:2: ( RULE_INT )
            // InternalAceGen.g:8131:3: RULE_INT
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


    // $ANTLR start "rule__WhenBlock__ActionAssignment_0"
    // InternalAceGen.g:8140:1: rule__WhenBlock__ActionAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__WhenBlock__ActionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8144:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8145:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8145:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8146:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getWhenBlockAccess().getActionHttpServerAceCrossReference_0_0()); 
            // InternalAceGen.g:8147:3: ( ruleQualifiedName )
            // InternalAceGen.g:8148:4: ruleQualifiedName
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
    // InternalAceGen.g:8159:1: rule__WhenBlock__DataDefinitionAssignment_1 : ( ruleDataDefinition ) ;
    public final void rule__WhenBlock__DataDefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8163:1: ( ( ruleDataDefinition ) )
            // InternalAceGen.g:8164:2: ( ruleDataDefinition )
            {
            // InternalAceGen.g:8164:2: ( ruleDataDefinition )
            // InternalAceGen.g:8165:3: ruleDataDefinition
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
    // InternalAceGen.g:8174:1: rule__WhenBlock__AuthorizationAssignment_2 : ( ruleAuthorization ) ;
    public final void rule__WhenBlock__AuthorizationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8178:1: ( ( ruleAuthorization ) )
            // InternalAceGen.g:8179:2: ( ruleAuthorization )
            {
            // InternalAceGen.g:8179:2: ( ruleAuthorization )
            // InternalAceGen.g:8180:3: ruleAuthorization
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
    // InternalAceGen.g:8189:1: rule__ThenBlock__StatusCodeAssignment_0 : ( RULE_INT ) ;
    public final void rule__ThenBlock__StatusCodeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8193:1: ( ( RULE_INT ) )
            // InternalAceGen.g:8194:2: ( RULE_INT )
            {
            // InternalAceGen.g:8194:2: ( RULE_INT )
            // InternalAceGen.g:8195:3: RULE_INT
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
    // InternalAceGen.g:8204:1: rule__ThenBlock__ResponseAssignment_1_1 : ( ruleDataDefinition ) ;
    public final void rule__ThenBlock__ResponseAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8208:1: ( ( ruleDataDefinition ) )
            // InternalAceGen.g:8209:2: ( ruleDataDefinition )
            {
            // InternalAceGen.g:8209:2: ( ruleDataDefinition )
            // InternalAceGen.g:8210:3: ruleDataDefinition
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
    // InternalAceGen.g:8219:1: rule__DataDefinition__UuidAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__DataDefinition__UuidAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8223:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8224:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8224:2: ( RULE_STRING )
            // InternalAceGen.g:8225:3: RULE_STRING
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
    // InternalAceGen.g:8234:1: rule__DataDefinition__SystemtimeAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__DataDefinition__SystemtimeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8238:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8239:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8239:2: ( RULE_STRING )
            // InternalAceGen.g:8240:3: RULE_STRING
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
    // InternalAceGen.g:8249:1: rule__DataDefinition__PatternAssignment_2_2 : ( RULE_STRING ) ;
    public final void rule__DataDefinition__PatternAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8253:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8254:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8254:2: ( RULE_STRING )
            // InternalAceGen.g:8255:3: RULE_STRING
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
    // InternalAceGen.g:8264:1: rule__DataDefinition__DataAssignment_3 : ( ruleAttributeDefinitionList ) ;
    public final void rule__DataDefinition__DataAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8268:1: ( ( ruleAttributeDefinitionList ) )
            // InternalAceGen.g:8269:2: ( ruleAttributeDefinitionList )
            {
            // InternalAceGen.g:8269:2: ( ruleAttributeDefinitionList )
            // InternalAceGen.g:8270:3: ruleAttributeDefinitionList
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
    // InternalAceGen.g:8279:1: rule__Authorization__UsernameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Authorization__UsernameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8283:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8284:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8284:2: ( RULE_STRING )
            // InternalAceGen.g:8285:3: RULE_STRING
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
    // InternalAceGen.g:8294:1: rule__Authorization__PasswordAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Authorization__PasswordAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8298:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8299:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8299:2: ( RULE_STRING )
            // InternalAceGen.g:8300:3: RULE_STRING
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
    // InternalAceGen.g:8309:1: rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2 : ( ruleAttributeDefinition ) ;
    public final void rule__AttributeDefinitionList__AttributeDefinitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8313:1: ( ( ruleAttributeDefinition ) )
            // InternalAceGen.g:8314:2: ( ruleAttributeDefinition )
            {
            // InternalAceGen.g:8314:2: ( ruleAttributeDefinition )
            // InternalAceGen.g:8315:3: ruleAttributeDefinition
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


    // $ANTLR start "rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2"
    // InternalAceGen.g:8324:1: rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2 : ( ruleAttributeDefinitionList ) ;
    public final void rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8328:1: ( ( ruleAttributeDefinitionList ) )
            // InternalAceGen.g:8329:2: ( ruleAttributeDefinitionList )
            {
            // InternalAceGen.g:8329:2: ( ruleAttributeDefinitionList )
            // InternalAceGen.g:8330:3: ruleAttributeDefinitionList
            {
             before(grammarAccess.getAttributeDefinitionListForListAccess().getAttributeDefinitionListAttributeDefinitionListParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeDefinitionList();

            state._fsp--;

             after(grammarAccess.getAttributeDefinitionListForListAccess().getAttributeDefinitionListAttributeDefinitionListParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeDefinitionListForList__AttributeDefinitionListAssignment_2"


    // $ANTLR start "rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2"
    // InternalAceGen.g:8339:1: rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2 : ( ruleValueDefinitionList ) ;
    public final void rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8343:1: ( ( ruleValueDefinitionList ) )
            // InternalAceGen.g:8344:2: ( ruleValueDefinitionList )
            {
            // InternalAceGen.g:8344:2: ( ruleValueDefinitionList )
            // InternalAceGen.g:8345:3: ruleValueDefinitionList
            {
             before(grammarAccess.getPrimitiveValueDefinitionForListAccess().getValueDefinitionListValueDefinitionListParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleValueDefinitionList();

            state._fsp--;

             after(grammarAccess.getPrimitiveValueDefinitionForListAccess().getValueDefinitionListValueDefinitionListParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValueDefinitionForList__ValueDefinitionListAssignment_2"


    // $ANTLR start "rule__AttributeDefinition__AttributeAssignment_0"
    // InternalAceGen.g:8354:1: rule__AttributeDefinition__AttributeAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__AttributeDefinition__AttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8358:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8359:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8359:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8360:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeDefinitionAccess().getAttributeAttributeCrossReference_0_0()); 
            // InternalAceGen.g:8361:3: ( ruleQualifiedName )
            // InternalAceGen.g:8362:4: ruleQualifiedName
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
    // InternalAceGen.g:8373:1: rule__AttributeDefinition__ValueAssignment_2 : ( ruleValue ) ;
    public final void rule__AttributeDefinition__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8377:1: ( ( ruleValue ) )
            // InternalAceGen.g:8378:2: ( ruleValue )
            {
            // InternalAceGen.g:8378:2: ( ruleValue )
            // InternalAceGen.g:8379:3: ruleValue
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


    // $ANTLR start "rule__ValueDefinitionList__PrimitiveValueAssignment"
    // InternalAceGen.g:8388:1: rule__ValueDefinitionList__PrimitiveValueAssignment : ( rulePrimitiveValue ) ;
    public final void rule__ValueDefinitionList__PrimitiveValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8392:1: ( ( rulePrimitiveValue ) )
            // InternalAceGen.g:8393:2: ( rulePrimitiveValue )
            {
            // InternalAceGen.g:8393:2: ( rulePrimitiveValue )
            // InternalAceGen.g:8394:3: rulePrimitiveValue
            {
             before(grammarAccess.getValueDefinitionListAccess().getPrimitiveValuePrimitiveValueParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePrimitiveValue();

            state._fsp--;

             after(grammarAccess.getValueDefinitionListAccess().getPrimitiveValuePrimitiveValueParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueDefinitionList__PrimitiveValueAssignment"


    // $ANTLR start "rule__Attribute__UniqueAssignment_0"
    // InternalAceGen.g:8403:1: rule__Attribute__UniqueAssignment_0 : ( ( 'Unique' ) ) ;
    public final void rule__Attribute__UniqueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8407:1: ( ( ( 'Unique' ) ) )
            // InternalAceGen.g:8408:2: ( ( 'Unique' ) )
            {
            // InternalAceGen.g:8408:2: ( ( 'Unique' ) )
            // InternalAceGen.g:8409:3: ( 'Unique' )
            {
             before(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 
            // InternalAceGen.g:8410:3: ( 'Unique' )
            // InternalAceGen.g:8411:4: 'Unique'
            {
             before(grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0()); 
            match(input,72,FOLLOW_2); 
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
    // InternalAceGen.g:8422:1: rule__Attribute__PrimaryKeyAssignment_1 : ( ( 'PrimaryKey' ) ) ;
    public final void rule__Attribute__PrimaryKeyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8426:1: ( ( ( 'PrimaryKey' ) ) )
            // InternalAceGen.g:8427:2: ( ( 'PrimaryKey' ) )
            {
            // InternalAceGen.g:8427:2: ( ( 'PrimaryKey' ) )
            // InternalAceGen.g:8428:3: ( 'PrimaryKey' )
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 
            // InternalAceGen.g:8429:3: ( 'PrimaryKey' )
            // InternalAceGen.g:8430:4: 'PrimaryKey'
            {
             before(grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0()); 
            match(input,73,FOLLOW_2); 
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
    // InternalAceGen.g:8441:1: rule__Attribute__ConstraintAssignment_2 : ( ruleConstraint ) ;
    public final void rule__Attribute__ConstraintAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8445:1: ( ( ruleConstraint ) )
            // InternalAceGen.g:8446:2: ( ruleConstraint )
            {
            // InternalAceGen.g:8446:2: ( ruleConstraint )
            // InternalAceGen.g:8447:3: ruleConstraint
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
    // InternalAceGen.g:8456:1: rule__Attribute__ListAssignment_3 : ( ( 'List' ) ) ;
    public final void rule__Attribute__ListAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8460:1: ( ( ( 'List' ) ) )
            // InternalAceGen.g:8461:2: ( ( 'List' ) )
            {
            // InternalAceGen.g:8461:2: ( ( 'List' ) )
            // InternalAceGen.g:8462:3: ( 'List' )
            {
             before(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 
            // InternalAceGen.g:8463:3: ( 'List' )
            // InternalAceGen.g:8464:4: 'List'
            {
             before(grammarAccess.getAttributeAccess().getListListKeyword_3_0()); 
            match(input,74,FOLLOW_2); 
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
    // InternalAceGen.g:8475:1: rule__Attribute__TypeAssignment_4_0 : ( ruleType ) ;
    public final void rule__Attribute__TypeAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8479:1: ( ( ruleType ) )
            // InternalAceGen.g:8480:2: ( ruleType )
            {
            // InternalAceGen.g:8480:2: ( ruleType )
            // InternalAceGen.g:8481:3: ruleType
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
    // InternalAceGen.g:8490:1: rule__Attribute__ModelAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Attribute__ModelAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8494:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8495:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8495:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8496:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeAccess().getModelModelCrossReference_4_1_0()); 
            // InternalAceGen.g:8497:3: ( ruleQualifiedName )
            // InternalAceGen.g:8498:4: ruleQualifiedName
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
    // InternalAceGen.g:8509:1: rule__Attribute__NameAssignment_5 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8513:1: ( ( RULE_ID ) )
            // InternalAceGen.g:8514:2: ( RULE_ID )
            {
            // InternalAceGen.g:8514:2: ( RULE_ID )
            // InternalAceGen.g:8515:3: RULE_ID
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
    // InternalAceGen.g:8524:1: rule__Attribute__ForeignKeyAssignment_6_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Attribute__ForeignKeyAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8528:1: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:8529:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:8529:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:8530:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0()); 
            // InternalAceGen.g:8531:3: ( ruleQualifiedName )
            // InternalAceGen.g:8532:4: ruleQualifiedName
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
    // InternalAceGen.g:8543:1: rule__Attribute__NotReplayableAssignment_7 : ( ( 'notReplayable' ) ) ;
    public final void rule__Attribute__NotReplayableAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8547:1: ( ( ( 'notReplayable' ) ) )
            // InternalAceGen.g:8548:2: ( ( 'notReplayable' ) )
            {
            // InternalAceGen.g:8548:2: ( ( 'notReplayable' ) )
            // InternalAceGen.g:8549:3: ( 'notReplayable' )
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableNotReplayableKeyword_7_0()); 
            // InternalAceGen.g:8550:3: ( 'notReplayable' )
            // InternalAceGen.g:8551:4: 'notReplayable'
            {
             before(grammarAccess.getAttributeAccess().getNotReplayableNotReplayableKeyword_7_0()); 
            match(input,75,FOLLOW_2); 
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
    // InternalAceGen.g:8562:1: rule__Value__StringValueAssignment_0 : ( RULE_STRING ) ;
    public final void rule__Value__StringValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8566:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8567:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8567:2: ( RULE_STRING )
            // InternalAceGen.g:8568:3: RULE_STRING
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
    // InternalAceGen.g:8577:1: rule__Value__IntValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__Value__IntValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8581:1: ( ( RULE_INT ) )
            // InternalAceGen.g:8582:2: ( RULE_INT )
            {
            // InternalAceGen.g:8582:2: ( RULE_INT )
            // InternalAceGen.g:8583:3: RULE_INT
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


    // $ANTLR start "rule__Value__DateValueAssignment_2_0"
    // InternalAceGen.g:8592:1: rule__Value__DateValueAssignment_2_0 : ( RULE_STRING ) ;
    public final void rule__Value__DateValueAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8596:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8597:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8597:2: ( RULE_STRING )
            // InternalAceGen.g:8598:3: RULE_STRING
            {
             before(grammarAccess.getValueAccess().getDateValueSTRINGTerminalRuleCall_2_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getValueAccess().getDateValueSTRINGTerminalRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__DateValueAssignment_2_0"


    // $ANTLR start "rule__Value__PatternAssignment_2_1"
    // InternalAceGen.g:8607:1: rule__Value__PatternAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__Value__PatternAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8611:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8612:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8612:2: ( RULE_STRING )
            // InternalAceGen.g:8613:3: RULE_STRING
            {
             before(grammarAccess.getValueAccess().getPatternSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getValueAccess().getPatternSTRINGTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__PatternAssignment_2_1"


    // $ANTLR start "rule__Value__AttributeDefinitionListAssignment_3"
    // InternalAceGen.g:8622:1: rule__Value__AttributeDefinitionListAssignment_3 : ( ruleAttributeDefinitionList ) ;
    public final void rule__Value__AttributeDefinitionListAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8626:1: ( ( ruleAttributeDefinitionList ) )
            // InternalAceGen.g:8627:2: ( ruleAttributeDefinitionList )
            {
            // InternalAceGen.g:8627:2: ( ruleAttributeDefinitionList )
            // InternalAceGen.g:8628:3: ruleAttributeDefinitionList
            {
             before(grammarAccess.getValueAccess().getAttributeDefinitionListAttributeDefinitionListParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeDefinitionList();

            state._fsp--;

             after(grammarAccess.getValueAccess().getAttributeDefinitionListAttributeDefinitionListParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__AttributeDefinitionListAssignment_3"


    // $ANTLR start "rule__Value__ListAttributeDefinitionListAssignment_4"
    // InternalAceGen.g:8637:1: rule__Value__ListAttributeDefinitionListAssignment_4 : ( ruleListAttributeDefinitionList ) ;
    public final void rule__Value__ListAttributeDefinitionListAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8641:1: ( ( ruleListAttributeDefinitionList ) )
            // InternalAceGen.g:8642:2: ( ruleListAttributeDefinitionList )
            {
            // InternalAceGen.g:8642:2: ( ruleListAttributeDefinitionList )
            // InternalAceGen.g:8643:3: ruleListAttributeDefinitionList
            {
             before(grammarAccess.getValueAccess().getListAttributeDefinitionListListAttributeDefinitionListParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleListAttributeDefinitionList();

            state._fsp--;

             after(grammarAccess.getValueAccess().getListAttributeDefinitionListListAttributeDefinitionListParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__ListAttributeDefinitionListAssignment_4"


    // $ANTLR start "rule__PrimitiveValue__StringValueAssignment_0"
    // InternalAceGen.g:8652:1: rule__PrimitiveValue__StringValueAssignment_0 : ( RULE_STRING ) ;
    public final void rule__PrimitiveValue__StringValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8656:1: ( ( RULE_STRING ) )
            // InternalAceGen.g:8657:2: ( RULE_STRING )
            {
            // InternalAceGen.g:8657:2: ( RULE_STRING )
            // InternalAceGen.g:8658:3: RULE_STRING
            {
             before(grammarAccess.getPrimitiveValueAccess().getStringValueSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getPrimitiveValueAccess().getStringValueSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValue__StringValueAssignment_0"


    // $ANTLR start "rule__PrimitiveValue__IntValueAssignment_1"
    // InternalAceGen.g:8667:1: rule__PrimitiveValue__IntValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__PrimitiveValue__IntValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAceGen.g:8671:1: ( ( RULE_INT ) )
            // InternalAceGen.g:8672:2: ( RULE_INT )
            {
            // InternalAceGen.g:8672:2: ( RULE_INT )
            // InternalAceGen.g:8673:3: RULE_INT
            {
             before(grammarAccess.getPrimitiveValueAccess().getIntValueINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPrimitiveValueAccess().getIntValueINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveValue__IntValueAssignment_1"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\2\4\1\37\1\4\1\40\1\4\1\13\1\40\2\uffff";
    static final String dfa_3s = "\1\105\1\4\1\37\1\4\1\100\1\4\1\22\1\100\2\uffff";
    static final String dfa_4s = "\10\uffff\1\1\1\2";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\100\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\37\uffff\1\5",
            "\1\7",
            "\1\11\4\uffff\3\10",
            "\1\6\37\uffff\1\5",
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
            return "1031:1: rule__HttpServerAce__Alternatives : ( ( ruleHttpServerAceWrite ) | ( ruleHttpServerAceRead ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000001C80000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000000A000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000400000F000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000000F002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000020000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0001F00020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000020L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000080L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000080L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x001E001000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x001E000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000080007F80010L,0x0000000000000700L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000007F80012L,0x0000000000000700L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0020040000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0C00040000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x4000040000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000004000000060L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x2000042000000060L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000007F80010L,0x0000000000000700L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});

}