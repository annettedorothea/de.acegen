package de.acegen.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.acegen.services.AceGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAceGenParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'HttpClient'", "'HttpServer'", "'ACE'", "'appState'", "'async'", "'<'", "','", "'>'", "'call'", "'loadingFlag'", "'on'", "'('", "')'", "'triggers'", "'set'", "'merge'", "'reset'", "'init'", "'list'", "'location.hash'", "'storage'", "'|'", "':'", "'{'", "'}'", "'Dropwizard'", "'Authorization'", "'import'", "'views'", "'models'", "'scenarios'", "'proxy'", "'authorize'", "'pathParams'", "'queryParams'", "'payload'", "'response'", "'optional'", "'persistent'", "'extends'", "'GIVEN'", "'WHEN'", "'THEN'", "'x'", "'excludeGIVEN'", "'uuid'", "'systemTime'", "'authorization'", "'Unique'", "'PrimaryKey'", "'NotNull'", "'List'", "'references'", "'notReplayable'", "'.'", "'POST'", "'PUT'", "'DELETE'", "'GET'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'Long'", "'['", "']'", "'true'", "'false'", "'null'"
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

        public InternalAceGenParser(TokenStream input, AceGenGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Project";
       	}

       	@Override
       	protected AceGenGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProject"
    // InternalAceGen.g:64:1: entryRuleProject returns [EObject current=null] : iv_ruleProject= ruleProject EOF ;
    public final EObject entryRuleProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProject = null;


        try {
            // InternalAceGen.g:64:48: (iv_ruleProject= ruleProject EOF )
            // InternalAceGen.g:65:2: iv_ruleProject= ruleProject EOF
            {
             newCompositeNode(grammarAccess.getProjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProject=ruleProject();

            state._fsp--;

             current =iv_ruleProject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalAceGen.g:71:1: ruleProject returns [EObject current=null] : ( () ( (otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? ) | (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? ) )? ) ;
    public final EObject ruleProject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_httpClient_2_0 = null;

        EObject lv_httpServer_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:77:2: ( ( () ( (otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? ) | (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? ) )? ) )
            // InternalAceGen.g:78:2: ( () ( (otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? ) | (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? ) )? )
            {
            // InternalAceGen.g:78:2: ( () ( (otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? ) | (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? ) )? )
            // InternalAceGen.g:79:3: () ( (otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? ) | (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? ) )?
            {
            // InternalAceGen.g:79:3: ()
            // InternalAceGen.g:80:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProjectAccess().getProjectAction_0(),
            					current);
            			

            }

            // InternalAceGen.g:86:3: ( (otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? ) | (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? ) )?
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            switch (alt3) {
                case 1 :
                    // InternalAceGen.g:87:4: (otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? )
                    {
                    // InternalAceGen.g:87:4: (otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? )
                    // InternalAceGen.g:88:5: otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )?
                    {
                    otherlv_1=(Token)match(input,11,FOLLOW_3); 

                    					newLeafNode(otherlv_1, grammarAccess.getProjectAccess().getHttpClientKeyword_1_0_0());
                    				
                    // InternalAceGen.g:92:5: ( (lv_httpClient_2_0= ruleHttpClient ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_ID) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalAceGen.g:93:6: (lv_httpClient_2_0= ruleHttpClient )
                            {
                            // InternalAceGen.g:93:6: (lv_httpClient_2_0= ruleHttpClient )
                            // InternalAceGen.g:94:7: lv_httpClient_2_0= ruleHttpClient
                            {

                            							newCompositeNode(grammarAccess.getProjectAccess().getHttpClientHttpClientParserRuleCall_1_0_1_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_httpClient_2_0=ruleHttpClient();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getProjectRule());
                            							}
                            							set(
                            								current,
                            								"httpClient",
                            								lv_httpClient_2_0,
                            								"de.acegen.AceGen.HttpClient");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:113:4: (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? )
                    {
                    // InternalAceGen.g:113:4: (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? )
                    // InternalAceGen.g:114:5: otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )?
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_4); 

                    					newLeafNode(otherlv_3, grammarAccess.getProjectAccess().getHttpServerKeyword_1_1_0());
                    				
                    // InternalAceGen.g:118:5: ( (lv_httpServer_4_0= ruleHttpServer ) )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==RULE_ID||LA2_0==36) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalAceGen.g:119:6: (lv_httpServer_4_0= ruleHttpServer )
                            {
                            // InternalAceGen.g:119:6: (lv_httpServer_4_0= ruleHttpServer )
                            // InternalAceGen.g:120:7: lv_httpServer_4_0= ruleHttpServer
                            {

                            							newCompositeNode(grammarAccess.getProjectAccess().getHttpServerHttpServerParserRuleCall_1_1_1_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_httpServer_4_0=ruleHttpServer();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getProjectRule());
                            							}
                            							set(
                            								current,
                            								"httpServer",
                            								lv_httpServer_4_0,
                            								"de.acegen.AceGen.HttpServer");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleHttpClient"
    // InternalAceGen.g:143:1: entryRuleHttpClient returns [EObject current=null] : iv_ruleHttpClient= ruleHttpClient EOF ;
    public final EObject entryRuleHttpClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClient = null;


        try {
            // InternalAceGen.g:143:51: (iv_ruleHttpClient= ruleHttpClient EOF )
            // InternalAceGen.g:144:2: iv_ruleHttpClient= ruleHttpClient EOF
            {
             newCompositeNode(grammarAccess.getHttpClientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpClient=ruleHttpClient();

            state._fsp--;

             current =iv_ruleHttpClient; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpClient"


    // $ANTLR start "ruleHttpClient"
    // InternalAceGen.g:150:1: ruleHttpClient returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )? ) ;
    public final EObject ruleHttpClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_aceOperations_2_0 = null;

        EObject lv_appState_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:156:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )? ) )
            // InternalAceGen.g:157:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )? )
            {
            // InternalAceGen.g:157:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )? )
            // InternalAceGen.g:158:3: ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )?
            {
            // InternalAceGen.g:158:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalAceGen.g:159:4: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalAceGen.g:159:4: (lv_name_0_0= ruleQualifiedName )
            // InternalAceGen.g:160:5: lv_name_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getHttpClientAccess().getNameQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHttpClientRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"de.acegen.AceGen.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:177:3: (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalAceGen.g:178:4: otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )*
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getHttpClientAccess().getACEKeyword_1_0());
                    			
                    // InternalAceGen.g:182:4: ( (lv_aceOperations_2_0= ruleHttpClientAce ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID||LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalAceGen.g:183:5: (lv_aceOperations_2_0= ruleHttpClientAce )
                    	    {
                    	    // InternalAceGen.g:183:5: (lv_aceOperations_2_0= ruleHttpClientAce )
                    	    // InternalAceGen.g:184:6: lv_aceOperations_2_0= ruleHttpClientAce
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpClientAccess().getAceOperationsHttpClientAceParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_aceOperations_2_0=ruleHttpClientAce();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpClientRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aceOperations",
                    	    							lv_aceOperations_2_0,
                    	    							"de.acegen.AceGen.HttpClientAce");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:202:3: (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAceGen.g:203:4: otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getHttpClientAccess().getAppStateKeyword_2_0());
                    			
                    // InternalAceGen.g:207:4: ( (lv_appState_4_0= ruleHttpClientStateElement ) )
                    // InternalAceGen.g:208:5: (lv_appState_4_0= ruleHttpClientStateElement )
                    {
                    // InternalAceGen.g:208:5: (lv_appState_4_0= ruleHttpClientStateElement )
                    // InternalAceGen.g:209:6: lv_appState_4_0= ruleHttpClientStateElement
                    {

                    						newCompositeNode(grammarAccess.getHttpClientAccess().getAppStateHttpClientStateElementParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_appState_4_0=ruleHttpClientStateElement();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHttpClientRule());
                    						}
                    						set(
                    							current,
                    							"appState",
                    							lv_appState_4_0,
                    							"de.acegen.AceGen.HttpClientStateElement");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpClient"


    // $ANTLR start "entryRuleHttpClientAce"
    // InternalAceGen.g:231:1: entryRuleHttpClientAce returns [EObject current=null] : iv_ruleHttpClientAce= ruleHttpClientAce EOF ;
    public final EObject entryRuleHttpClientAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientAce = null;


        try {
            // InternalAceGen.g:231:54: (iv_ruleHttpClientAce= ruleHttpClientAce EOF )
            // InternalAceGen.g:232:2: iv_ruleHttpClientAce= ruleHttpClientAce EOF
            {
             newCompositeNode(grammarAccess.getHttpClientAceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpClientAce=ruleHttpClientAce();

            state._fsp--;

             current =iv_ruleHttpClientAce; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpClientAce"


    // $ANTLR start "ruleHttpClientAce"
    // InternalAceGen.g:238:1: ruleHttpClientAce returns [EObject current=null] : ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_input_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_input_5_0= RULE_ID ) ) )* otherlv_6= '>' )? (otherlv_7= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_11_0= ruleHttpClientOutcome ) )* ) ;
    public final EObject ruleHttpClientAce() throws RecognitionException {
        EObject current = null;

        Token lv_async_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_input_3_0=null;
        Token otherlv_4=null;
        Token lv_input_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_outcomes_11_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:244:2: ( ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_input_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_input_5_0= RULE_ID ) ) )* otherlv_6= '>' )? (otherlv_7= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_11_0= ruleHttpClientOutcome ) )* ) )
            // InternalAceGen.g:245:2: ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_input_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_input_5_0= RULE_ID ) ) )* otherlv_6= '>' )? (otherlv_7= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_11_0= ruleHttpClientOutcome ) )* )
            {
            // InternalAceGen.g:245:2: ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_input_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_input_5_0= RULE_ID ) ) )* otherlv_6= '>' )? (otherlv_7= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_11_0= ruleHttpClientOutcome ) )* )
            // InternalAceGen.g:246:3: ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (lv_input_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_input_5_0= RULE_ID ) ) )* otherlv_6= '>' )? (otherlv_7= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_11_0= ruleHttpClientOutcome ) )*
            {
            // InternalAceGen.g:246:3: ( (lv_async_0_0= 'async' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAceGen.g:247:4: (lv_async_0_0= 'async' )
                    {
                    // InternalAceGen.g:247:4: (lv_async_0_0= 'async' )
                    // InternalAceGen.g:248:5: lv_async_0_0= 'async'
                    {
                    lv_async_0_0=(Token)match(input,15,FOLLOW_7); 

                    					newLeafNode(lv_async_0_0, grammarAccess.getHttpClientAceAccess().getAsyncAsyncKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpClientAceRule());
                    					}
                    					setWithLastConsumed(current, "async", true, "async");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:260:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:261:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:261:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:262:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_1_0, grammarAccess.getHttpClientAceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpClientAceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:278:3: (otherlv_2= '<' ( (lv_input_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_input_5_0= RULE_ID ) ) )* otherlv_6= '>' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAceGen.g:279:4: otherlv_2= '<' ( (lv_input_3_0= RULE_ID ) ) (otherlv_4= ',' ( (lv_input_5_0= RULE_ID ) ) )* otherlv_6= '>'
                    {
                    otherlv_2=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getHttpClientAceAccess().getLessThanSignKeyword_2_0());
                    			
                    // InternalAceGen.g:283:4: ( (lv_input_3_0= RULE_ID ) )
                    // InternalAceGen.g:284:5: (lv_input_3_0= RULE_ID )
                    {
                    // InternalAceGen.g:284:5: (lv_input_3_0= RULE_ID )
                    // InternalAceGen.g:285:6: lv_input_3_0= RULE_ID
                    {
                    lv_input_3_0=(Token)match(input,RULE_ID,FOLLOW_9); 

                    						newLeafNode(lv_input_3_0, grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpClientAceRule());
                    						}
                    						addWithLastConsumed(
                    							current,
                    							"input",
                    							lv_input_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalAceGen.g:301:4: (otherlv_4= ',' ( (lv_input_5_0= RULE_ID ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==17) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalAceGen.g:302:5: otherlv_4= ',' ( (lv_input_5_0= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_7); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getHttpClientAceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:306:5: ( (lv_input_5_0= RULE_ID ) )
                    	    // InternalAceGen.g:307:6: (lv_input_5_0= RULE_ID )
                    	    {
                    	    // InternalAceGen.g:307:6: (lv_input_5_0= RULE_ID )
                    	    // InternalAceGen.g:308:7: lv_input_5_0= RULE_ID
                    	    {
                    	    lv_input_5_0=(Token)match(input,RULE_ID,FOLLOW_9); 

                    	    							newLeafNode(lv_input_5_0, grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_2_2_1_0());
                    	    						

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getHttpClientAceRule());
                    	    							}
                    	    							addWithLastConsumed(
                    	    								current,
                    	    								"input",
                    	    								lv_input_5_0,
                    	    								"org.eclipse.xtext.common.Terminals.ID");
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,18,FOLLOW_10); 

                    				newLeafNode(otherlv_6, grammarAccess.getHttpClientAceAccess().getGreaterThanSignKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:330:3: (otherlv_7= 'call' ( ( ruleQualifiedName ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAceGen.g:331:4: otherlv_7= 'call' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getHttpClientAceAccess().getCallKeyword_3_0());
                    			
                    // InternalAceGen.g:335:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:336:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:336:5: ( ruleQualifiedName )
                    // InternalAceGen.g:337:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpClientAceRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:352:3: (otherlv_9= 'loadingFlag' ( ( ruleQualifiedName ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAceGen.g:353:4: otherlv_9= 'loadingFlag' ( ( ruleQualifiedName ) )
                    {
                    otherlv_9=(Token)match(input,20,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getHttpClientAceAccess().getLoadingFlagKeyword_4_0());
                    			
                    // InternalAceGen.g:357:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:358:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:358:5: ( ruleQualifiedName )
                    // InternalAceGen.g:359:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpClientAceRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:374:3: ( (lv_outcomes_11_0= ruleHttpClientOutcome ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAceGen.g:375:4: (lv_outcomes_11_0= ruleHttpClientOutcome )
            	    {
            	    // InternalAceGen.g:375:4: (lv_outcomes_11_0= ruleHttpClientOutcome )
            	    // InternalAceGen.g:376:5: lv_outcomes_11_0= ruleHttpClientOutcome
            	    {

            	    					newCompositeNode(grammarAccess.getHttpClientAceAccess().getOutcomesHttpClientOutcomeParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_outcomes_11_0=ruleHttpClientOutcome();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHttpClientAceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"outcomes",
            	    						lv_outcomes_11_0,
            	    						"de.acegen.AceGen.HttpClientOutcome");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpClientAce"


    // $ANTLR start "entryRuleHttpClientOutcome"
    // InternalAceGen.g:397:1: entryRuleHttpClientOutcome returns [EObject current=null] : iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF ;
    public final EObject entryRuleHttpClientOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientOutcome = null;


        try {
            // InternalAceGen.g:397:58: (iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF )
            // InternalAceGen.g:398:2: iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF
            {
             newCompositeNode(grammarAccess.getHttpClientOutcomeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpClientOutcome=ruleHttpClientOutcome();

            state._fsp--;

             current =iv_ruleHttpClientOutcome; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpClientOutcome"


    // $ANTLR start "ruleHttpClientOutcome"
    // InternalAceGen.g:404:1: ruleHttpClientOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? ) ;
    public final EObject ruleHttpClientOutcome() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_listeners_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:410:2: ( (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? ) )
            // InternalAceGen.g:411:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? )
            {
            // InternalAceGen.g:411:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? )
            // InternalAceGen.g:412:3: otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpClientOutcomeAccess().getOnKeyword_0());
            		
            // InternalAceGen.g:416:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:417:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:417:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:418:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_name_1_0, grammarAccess.getHttpClientOutcomeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpClientOutcomeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:434:3: (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalAceGen.g:435:4: otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_14); 

                    				newLeafNode(otherlv_2, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalAceGen.g:439:4: ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=25 && LA13_0<=28)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalAceGen.g:440:5: (lv_listeners_3_0= ruleHttpClientStateFunction )
                    	    {
                    	    // InternalAceGen.g:440:5: (lv_listeners_3_0= ruleHttpClientStateFunction )
                    	    // InternalAceGen.g:441:6: lv_listeners_3_0= ruleHttpClientStateFunction
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpClientOutcomeAccess().getListenersHttpClientStateFunctionParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_14);
                    	    lv_listeners_3_0=ruleHttpClientStateFunction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpClientOutcomeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"listeners",
                    	    							lv_listeners_3_0,
                    	    							"de.acegen.AceGen.HttpClientStateFunction");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,23,FOLLOW_15); 

                    				newLeafNode(otherlv_4, grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:463:3: (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAceGen.g:464:4: otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,24,FOLLOW_16); 

                    				newLeafNode(otherlv_5, grammarAccess.getHttpClientOutcomeAccess().getTriggersKeyword_3_0());
                    			
                    otherlv_6=(Token)match(input,22,FOLLOW_17); 

                    				newLeafNode(otherlv_6, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalAceGen.g:472:4: ( ( ruleQualifiedName ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==RULE_ID) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalAceGen.g:473:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:473:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:474:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpClientOutcomeRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsHttpClientAceCrossReference_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_17);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,23,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_3_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpClientOutcome"


    // $ANTLR start "entryRuleHttpClientStateFunction"
    // InternalAceGen.g:497:1: entryRuleHttpClientStateFunction returns [EObject current=null] : iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF ;
    public final EObject entryRuleHttpClientStateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientStateFunction = null;


        try {
            // InternalAceGen.g:497:64: (iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF )
            // InternalAceGen.g:498:2: iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF
            {
             newCompositeNode(grammarAccess.getHttpClientStateFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpClientStateFunction=ruleHttpClientStateFunction();

            state._fsp--;

             current =iv_ruleHttpClientStateFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpClientStateFunction"


    // $ANTLR start "ruleHttpClientStateFunction"
    // InternalAceGen.g:504:1: ruleHttpClientStateFunction returns [EObject current=null] : ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleHttpClientStateFunction() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_stateFunctionType_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:510:2: ( ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:511:2: ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:511:2: ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:512:3: ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:512:3: ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) )
            // InternalAceGen.g:513:4: (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType )
            {
            // InternalAceGen.g:513:4: (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType )
            // InternalAceGen.g:514:5: lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeHttpClientStateFunctionTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_stateFunctionType_0_0=ruleHttpClientStateFunctionType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHttpClientStateFunctionRule());
            					}
            					set(
            						current,
            						"stateFunctionType",
            						lv_stateFunctionType_0_0,
            						"de.acegen.AceGen.HttpClientStateFunctionType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:531:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:532:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:532:4: ( ruleQualifiedName )
            // InternalAceGen.g:533:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpClientStateFunctionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpClientStateFunctionAccess().getAttributeHttpClientStateElementCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpClientStateFunction"


    // $ANTLR start "entryRuleHttpClientStateFunctionType"
    // InternalAceGen.g:551:1: entryRuleHttpClientStateFunctionType returns [String current=null] : iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF ;
    public final String entryRuleHttpClientStateFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHttpClientStateFunctionType = null;


        try {
            // InternalAceGen.g:551:67: (iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF )
            // InternalAceGen.g:552:2: iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF
            {
             newCompositeNode(grammarAccess.getHttpClientStateFunctionTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpClientStateFunctionType=ruleHttpClientStateFunctionType();

            state._fsp--;

             current =iv_ruleHttpClientStateFunctionType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpClientStateFunctionType"


    // $ANTLR start "ruleHttpClientStateFunctionType"
    // InternalAceGen.g:558:1: ruleHttpClientStateFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'set' | kw= 'merge' | kw= 'reset' | kw= 'init' ) ;
    public final AntlrDatatypeRuleToken ruleHttpClientStateFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:564:2: ( (kw= 'set' | kw= 'merge' | kw= 'reset' | kw= 'init' ) )
            // InternalAceGen.g:565:2: (kw= 'set' | kw= 'merge' | kw= 'reset' | kw= 'init' )
            {
            // InternalAceGen.g:565:2: (kw= 'set' | kw= 'merge' | kw= 'reset' | kw= 'init' )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt17=1;
                }
                break;
            case 26:
                {
                alt17=2;
                }
                break;
            case 27:
                {
                alt17=3;
                }
                break;
            case 28:
                {
                alt17=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalAceGen.g:566:3: kw= 'set'
                    {
                    kw=(Token)match(input,25,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:572:3: kw= 'merge'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:578:3: kw= 'reset'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getResetKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAceGen.g:584:3: kw= 'init'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getInitKeyword_3());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpClientStateFunctionType"


    // $ANTLR start "entryRuleHttpClientStateElement"
    // InternalAceGen.g:593:1: entryRuleHttpClientStateElement returns [EObject current=null] : iv_ruleHttpClientStateElement= ruleHttpClientStateElement EOF ;
    public final EObject entryRuleHttpClientStateElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientStateElement = null;


        try {
            // InternalAceGen.g:593:63: (iv_ruleHttpClientStateElement= ruleHttpClientStateElement EOF )
            // InternalAceGen.g:594:2: iv_ruleHttpClientStateElement= ruleHttpClientStateElement EOF
            {
             newCompositeNode(grammarAccess.getHttpClientStateElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpClientStateElement=ruleHttpClientStateElement();

            state._fsp--;

             current =iv_ruleHttpClientStateElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpClientStateElement"


    // $ANTLR start "ruleHttpClientStateElement"
    // InternalAceGen.g:600:1: ruleHttpClientStateElement returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_list_1_0= 'list' ) )? ( (lv_hash_2_0= 'location.hash' ) )? ( (lv_storage_3_0= 'storage' ) )? ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )? ) ;
    public final EObject ruleHttpClientStateElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_list_1_0=null;
        Token lv_hash_2_0=null;
        Token lv_storage_3_0=null;
        Token otherlv_5=null;
        EObject lv_types_4_0 = null;

        EObject lv_types_6_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:606:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_list_1_0= 'list' ) )? ( (lv_hash_2_0= 'location.hash' ) )? ( (lv_storage_3_0= 'storage' ) )? ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )? ) )
            // InternalAceGen.g:607:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_list_1_0= 'list' ) )? ( (lv_hash_2_0= 'location.hash' ) )? ( (lv_storage_3_0= 'storage' ) )? ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )? )
            {
            // InternalAceGen.g:607:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_list_1_0= 'list' ) )? ( (lv_hash_2_0= 'location.hash' ) )? ( (lv_storage_3_0= 'storage' ) )? ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )? )
            // InternalAceGen.g:608:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_list_1_0= 'list' ) )? ( (lv_hash_2_0= 'location.hash' ) )? ( (lv_storage_3_0= 'storage' ) )? ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )?
            {
            // InternalAceGen.g:608:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:609:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:609:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:610:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(lv_name_0_0, grammarAccess.getHttpClientStateElementAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpClientStateElementRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:626:3: ( (lv_list_1_0= 'list' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==29) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAceGen.g:627:4: (lv_list_1_0= 'list' )
                    {
                    // InternalAceGen.g:627:4: (lv_list_1_0= 'list' )
                    // InternalAceGen.g:628:5: lv_list_1_0= 'list'
                    {
                    lv_list_1_0=(Token)match(input,29,FOLLOW_19); 

                    					newLeafNode(lv_list_1_0, grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpClientStateElementRule());
                    					}
                    					setWithLastConsumed(current, "list", true, "list");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:640:3: ( (lv_hash_2_0= 'location.hash' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==30) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAceGen.g:641:4: (lv_hash_2_0= 'location.hash' )
                    {
                    // InternalAceGen.g:641:4: (lv_hash_2_0= 'location.hash' )
                    // InternalAceGen.g:642:5: lv_hash_2_0= 'location.hash'
                    {
                    lv_hash_2_0=(Token)match(input,30,FOLLOW_20); 

                    					newLeafNode(lv_hash_2_0, grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpClientStateElementRule());
                    					}
                    					setWithLastConsumed(current, "hash", true, "location.hash");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:654:3: ( (lv_storage_3_0= 'storage' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalAceGen.g:655:4: (lv_storage_3_0= 'storage' )
                    {
                    // InternalAceGen.g:655:4: (lv_storage_3_0= 'storage' )
                    // InternalAceGen.g:656:5: lv_storage_3_0= 'storage'
                    {
                    lv_storage_3_0=(Token)match(input,31,FOLLOW_21); 

                    					newLeafNode(lv_storage_3_0, grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpClientStateElementRule());
                    					}
                    					setWithLastConsumed(current, "storage", true, "storage");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:668:3: ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalAceGen.g:669:4: ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )*
                    {
                    // InternalAceGen.g:669:4: ( (lv_types_4_0= ruleHttpClientTypeDefinition ) )
                    // InternalAceGen.g:670:5: (lv_types_4_0= ruleHttpClientTypeDefinition )
                    {
                    // InternalAceGen.g:670:5: (lv_types_4_0= ruleHttpClientTypeDefinition )
                    // InternalAceGen.g:671:6: lv_types_4_0= ruleHttpClientTypeDefinition
                    {

                    						newCompositeNode(grammarAccess.getHttpClientStateElementAccess().getTypesHttpClientTypeDefinitionParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_types_4_0=ruleHttpClientTypeDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHttpClientStateElementRule());
                    						}
                    						add(
                    							current,
                    							"types",
                    							lv_types_4_0,
                    							"de.acegen.AceGen.HttpClientTypeDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:688:4: (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==32) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalAceGen.g:689:5: otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) )
                    	    {
                    	    otherlv_5=(Token)match(input,32,FOLLOW_23); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getHttpClientStateElementAccess().getVerticalLineKeyword_4_1_0());
                    	    				
                    	    // InternalAceGen.g:693:5: ( (lv_types_6_0= ruleHttpClientTypeDefinition ) )
                    	    // InternalAceGen.g:694:6: (lv_types_6_0= ruleHttpClientTypeDefinition )
                    	    {
                    	    // InternalAceGen.g:694:6: (lv_types_6_0= ruleHttpClientTypeDefinition )
                    	    // InternalAceGen.g:695:7: lv_types_6_0= ruleHttpClientTypeDefinition
                    	    {

                    	    							newCompositeNode(grammarAccess.getHttpClientStateElementAccess().getTypesHttpClientTypeDefinitionParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_22);
                    	    lv_types_6_0=ruleHttpClientTypeDefinition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getHttpClientStateElementRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"types",
                    	    								lv_types_6_0,
                    	    								"de.acegen.AceGen.HttpClientTypeDefinition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpClientStateElement"


    // $ANTLR start "entryRuleHttpClientTypeDefinition"
    // InternalAceGen.g:718:1: entryRuleHttpClientTypeDefinition returns [EObject current=null] : iv_ruleHttpClientTypeDefinition= ruleHttpClientTypeDefinition EOF ;
    public final EObject entryRuleHttpClientTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientTypeDefinition = null;


        try {
            // InternalAceGen.g:718:65: (iv_ruleHttpClientTypeDefinition= ruleHttpClientTypeDefinition EOF )
            // InternalAceGen.g:719:2: iv_ruleHttpClientTypeDefinition= ruleHttpClientTypeDefinition EOF
            {
             newCompositeNode(grammarAccess.getHttpClientTypeDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpClientTypeDefinition=ruleHttpClientTypeDefinition();

            state._fsp--;

             current =iv_ruleHttpClientTypeDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpClientTypeDefinition"


    // $ANTLR start "ruleHttpClientTypeDefinition"
    // InternalAceGen.g:725:1: ruleHttpClientTypeDefinition returns [EObject current=null] : (otherlv_0= ':' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleHttpClientStateElement ) )* otherlv_4= '}' ) ;
    public final EObject ruleHttpClientTypeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:731:2: ( (otherlv_0= ':' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleHttpClientStateElement ) )* otherlv_4= '}' ) )
            // InternalAceGen.g:732:2: (otherlv_0= ':' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleHttpClientStateElement ) )* otherlv_4= '}' )
            {
            // InternalAceGen.g:732:2: (otherlv_0= ':' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleHttpClientStateElement ) )* otherlv_4= '}' )
            // InternalAceGen.g:733:3: otherlv_0= ':' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleHttpClientStateElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpClientTypeDefinitionAccess().getColonKeyword_0());
            		
            // InternalAceGen.g:737:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:738:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:738:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:739:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_1_0, grammarAccess.getHttpClientTypeDefinitionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpClientTypeDefinitionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,34,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getHttpClientTypeDefinitionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalAceGen.g:759:3: ( (lv_elements_3_0= ruleHttpClientStateElement ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalAceGen.g:760:4: (lv_elements_3_0= ruleHttpClientStateElement )
            	    {
            	    // InternalAceGen.g:760:4: (lv_elements_3_0= ruleHttpClientStateElement )
            	    // InternalAceGen.g:761:5: lv_elements_3_0= ruleHttpClientStateElement
            	    {

            	    					newCompositeNode(grammarAccess.getHttpClientTypeDefinitionAccess().getElementsHttpClientStateElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_25);
            	    lv_elements_3_0=ruleHttpClientStateElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHttpClientTypeDefinitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_3_0,
            	    						"de.acegen.AceGen.HttpClientStateElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_4=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getHttpClientTypeDefinitionAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpClientTypeDefinition"


    // $ANTLR start "entryRuleHttpServer"
    // InternalAceGen.g:786:1: entryRuleHttpServer returns [EObject current=null] : iv_ruleHttpServer= ruleHttpServer EOF ;
    public final EObject entryRuleHttpServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServer = null;


        try {
            // InternalAceGen.g:786:51: (iv_ruleHttpServer= ruleHttpServer EOF )
            // InternalAceGen.g:787:2: iv_ruleHttpServer= ruleHttpServer EOF
            {
             newCompositeNode(grammarAccess.getHttpServerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpServer=ruleHttpServer();

            state._fsp--;

             current =iv_ruleHttpServer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpServer"


    // $ANTLR start "ruleHttpServer"
    // InternalAceGen.g:793:1: ruleHttpServer returns [EObject current=null] : ( ( (lv_type_0_0= 'Dropwizard' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'Authorization' ( (lv_authUser_3_0= ruleAuthUser ) ) )? (otherlv_4= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_6= 'ACE' ( (lv_aceOperations_7_0= ruleHttpServerAce ) )* )? (otherlv_8= 'views' ( (lv_views_9_0= ruleHttpServerView ) )* )? (otherlv_10= 'models' ( (lv_models_11_0= ruleModel ) )* )? (otherlv_12= 'scenarios' ( (lv_scenarios_13_0= ruleScenario ) )* )? ) ;
    public final EObject ruleHttpServer() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_authUser_3_0 = null;

        EObject lv_aceOperations_7_0 = null;

        EObject lv_views_9_0 = null;

        EObject lv_models_11_0 = null;

        EObject lv_scenarios_13_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:799:2: ( ( ( (lv_type_0_0= 'Dropwizard' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'Authorization' ( (lv_authUser_3_0= ruleAuthUser ) ) )? (otherlv_4= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_6= 'ACE' ( (lv_aceOperations_7_0= ruleHttpServerAce ) )* )? (otherlv_8= 'views' ( (lv_views_9_0= ruleHttpServerView ) )* )? (otherlv_10= 'models' ( (lv_models_11_0= ruleModel ) )* )? (otherlv_12= 'scenarios' ( (lv_scenarios_13_0= ruleScenario ) )* )? ) )
            // InternalAceGen.g:800:2: ( ( (lv_type_0_0= 'Dropwizard' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'Authorization' ( (lv_authUser_3_0= ruleAuthUser ) ) )? (otherlv_4= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_6= 'ACE' ( (lv_aceOperations_7_0= ruleHttpServerAce ) )* )? (otherlv_8= 'views' ( (lv_views_9_0= ruleHttpServerView ) )* )? (otherlv_10= 'models' ( (lv_models_11_0= ruleModel ) )* )? (otherlv_12= 'scenarios' ( (lv_scenarios_13_0= ruleScenario ) )* )? )
            {
            // InternalAceGen.g:800:2: ( ( (lv_type_0_0= 'Dropwizard' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'Authorization' ( (lv_authUser_3_0= ruleAuthUser ) ) )? (otherlv_4= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_6= 'ACE' ( (lv_aceOperations_7_0= ruleHttpServerAce ) )* )? (otherlv_8= 'views' ( (lv_views_9_0= ruleHttpServerView ) )* )? (otherlv_10= 'models' ( (lv_models_11_0= ruleModel ) )* )? (otherlv_12= 'scenarios' ( (lv_scenarios_13_0= ruleScenario ) )* )? )
            // InternalAceGen.g:801:3: ( (lv_type_0_0= 'Dropwizard' ) )? ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'Authorization' ( (lv_authUser_3_0= ruleAuthUser ) ) )? (otherlv_4= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_6= 'ACE' ( (lv_aceOperations_7_0= ruleHttpServerAce ) )* )? (otherlv_8= 'views' ( (lv_views_9_0= ruleHttpServerView ) )* )? (otherlv_10= 'models' ( (lv_models_11_0= ruleModel ) )* )? (otherlv_12= 'scenarios' ( (lv_scenarios_13_0= ruleScenario ) )* )?
            {
            // InternalAceGen.g:801:3: ( (lv_type_0_0= 'Dropwizard' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalAceGen.g:802:4: (lv_type_0_0= 'Dropwizard' )
                    {
                    // InternalAceGen.g:802:4: (lv_type_0_0= 'Dropwizard' )
                    // InternalAceGen.g:803:5: lv_type_0_0= 'Dropwizard'
                    {
                    lv_type_0_0=(Token)match(input,36,FOLLOW_7); 

                    					newLeafNode(lv_type_0_0, grammarAccess.getHttpServerAccess().getTypeDropwizardKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_0_0, "Dropwizard");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:815:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalAceGen.g:816:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalAceGen.g:816:4: (lv_name_1_0= ruleQualifiedName )
            // InternalAceGen.g:817:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getHttpServerAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_26);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHttpServerRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.acegen.AceGen.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:834:3: (otherlv_2= 'Authorization' ( (lv_authUser_3_0= ruleAuthUser ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==37) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalAceGen.g:835:4: otherlv_2= 'Authorization' ( (lv_authUser_3_0= ruleAuthUser ) )
                    {
                    otherlv_2=(Token)match(input,37,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getHttpServerAccess().getAuthorizationKeyword_2_0());
                    			
                    // InternalAceGen.g:839:4: ( (lv_authUser_3_0= ruleAuthUser ) )
                    // InternalAceGen.g:840:5: (lv_authUser_3_0= ruleAuthUser )
                    {
                    // InternalAceGen.g:840:5: (lv_authUser_3_0= ruleAuthUser )
                    // InternalAceGen.g:841:6: lv_authUser_3_0= ruleAuthUser
                    {

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserAuthUserParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_authUser_3_0=ruleAuthUser();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    						}
                    						set(
                    							current,
                    							"authUser",
                    							lv_authUser_3_0,
                    							"de.acegen.AceGen.AuthUser");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:859:3: (otherlv_4= 'import' ( ( ruleQualifiedName ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==38) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalAceGen.g:860:4: otherlv_4= 'import' ( ( ruleQualifiedName ) )
                    {
                    otherlv_4=(Token)match(input,38,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getHttpServerAccess().getImportKeyword_3_0());
                    			
                    // InternalAceGen.g:864:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:865:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:865:5: ( ruleQualifiedName )
                    // InternalAceGen.g:866:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpServerRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_28);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:881:3: (otherlv_6= 'ACE' ( (lv_aceOperations_7_0= ruleHttpServerAce ) )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==13) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAceGen.g:882:4: otherlv_6= 'ACE' ( (lv_aceOperations_7_0= ruleHttpServerAce ) )*
                    {
                    otherlv_6=(Token)match(input,13,FOLLOW_29); 

                    				newLeafNode(otherlv_6, grammarAccess.getHttpServerAccess().getACEKeyword_4_0());
                    			
                    // InternalAceGen.g:886:4: ( (lv_aceOperations_7_0= ruleHttpServerAce ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==RULE_ID||LA27_0==42) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalAceGen.g:887:5: (lv_aceOperations_7_0= ruleHttpServerAce )
                    	    {
                    	    // InternalAceGen.g:887:5: (lv_aceOperations_7_0= ruleHttpServerAce )
                    	    // InternalAceGen.g:888:6: lv_aceOperations_7_0= ruleHttpServerAce
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getAceOperationsHttpServerAceParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_29);
                    	    lv_aceOperations_7_0=ruleHttpServerAce();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aceOperations",
                    	    							lv_aceOperations_7_0,
                    	    							"de.acegen.AceGen.HttpServerAce");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:906:3: (otherlv_8= 'views' ( (lv_views_9_0= ruleHttpServerView ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==39) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalAceGen.g:907:4: otherlv_8= 'views' ( (lv_views_9_0= ruleHttpServerView ) )*
                    {
                    otherlv_8=(Token)match(input,39,FOLLOW_30); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerAccess().getViewsKeyword_5_0());
                    			
                    // InternalAceGen.g:911:4: ( (lv_views_9_0= ruleHttpServerView ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_ID) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalAceGen.g:912:5: (lv_views_9_0= ruleHttpServerView )
                    	    {
                    	    // InternalAceGen.g:912:5: (lv_views_9_0= ruleHttpServerView )
                    	    // InternalAceGen.g:913:6: lv_views_9_0= ruleHttpServerView
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getViewsHttpServerViewParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_30);
                    	    lv_views_9_0=ruleHttpServerView();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"views",
                    	    							lv_views_9_0,
                    	    							"de.acegen.AceGen.HttpServerView");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:931:3: (otherlv_10= 'models' ( (lv_models_11_0= ruleModel ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==40) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAceGen.g:932:4: otherlv_10= 'models' ( (lv_models_11_0= ruleModel ) )*
                    {
                    otherlv_10=(Token)match(input,40,FOLLOW_31); 

                    				newLeafNode(otherlv_10, grammarAccess.getHttpServerAccess().getModelsKeyword_6_0());
                    			
                    // InternalAceGen.g:936:4: ( (lv_models_11_0= ruleModel ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==RULE_ID||LA31_0==49) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalAceGen.g:937:5: (lv_models_11_0= ruleModel )
                    	    {
                    	    // InternalAceGen.g:937:5: (lv_models_11_0= ruleModel )
                    	    // InternalAceGen.g:938:6: lv_models_11_0= ruleModel
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getModelsModelParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_31);
                    	    lv_models_11_0=ruleModel();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"models",
                    	    							lv_models_11_0,
                    	    							"de.acegen.AceGen.Model");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:956:3: (otherlv_12= 'scenarios' ( (lv_scenarios_13_0= ruleScenario ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==41) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAceGen.g:957:4: otherlv_12= 'scenarios' ( (lv_scenarios_13_0= ruleScenario ) )*
                    {
                    otherlv_12=(Token)match(input,41,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpServerAccess().getScenariosKeyword_7_0());
                    			
                    // InternalAceGen.g:961:4: ( (lv_scenarios_13_0= ruleScenario ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_ID) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalAceGen.g:962:5: (lv_scenarios_13_0= ruleScenario )
                    	    {
                    	    // InternalAceGen.g:962:5: (lv_scenarios_13_0= ruleScenario )
                    	    // InternalAceGen.g:963:6: lv_scenarios_13_0= ruleScenario
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getScenariosScenarioParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_3);
                    	    lv_scenarios_13_0=ruleScenario();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"scenarios",
                    	    							lv_scenarios_13_0,
                    	    							"de.acegen.AceGen.Scenario");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpServer"


    // $ANTLR start "entryRuleHttpServerAce"
    // InternalAceGen.g:985:1: entryRuleHttpServerAce returns [EObject current=null] : iv_ruleHttpServerAce= ruleHttpServerAce EOF ;
    public final EObject entryRuleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAce = null;


        try {
            // InternalAceGen.g:985:54: (iv_ruleHttpServerAce= ruleHttpServerAce EOF )
            // InternalAceGen.g:986:2: iv_ruleHttpServerAce= ruleHttpServerAce EOF
            {
             newCompositeNode(grammarAccess.getHttpServerAceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpServerAce=ruleHttpServerAce();

            state._fsp--;

             current =iv_ruleHttpServerAce; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpServerAce"


    // $ANTLR start "ruleHttpServerAce"
    // InternalAceGen.g:992:1: ruleHttpServerAce returns [EObject current=null] : (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) ;
    public final EObject ruleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject this_HttpServerAceWrite_0 = null;

        EObject this_HttpServerAceRead_1 = null;



        	enterRule();

        try {
            // InternalAceGen.g:998:2: ( (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) )
            // InternalAceGen.g:999:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            {
            // InternalAceGen.g:999:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // InternalAceGen.g:1000:3: this_HttpServerAceWrite_0= ruleHttpServerAceWrite
                    {

                    			newCompositeNode(grammarAccess.getHttpServerAceAccess().getHttpServerAceWriteParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_HttpServerAceWrite_0=ruleHttpServerAceWrite();

                    state._fsp--;


                    			current = this_HttpServerAceWrite_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1009:3: this_HttpServerAceRead_1= ruleHttpServerAceRead
                    {

                    			newCompositeNode(grammarAccess.getHttpServerAceAccess().getHttpServerAceReadParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_HttpServerAceRead_1=ruleHttpServerAceRead();

                    state._fsp--;


                    			current = this_HttpServerAceRead_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpServerAce"


    // $ANTLR start "entryRuleHttpServerAceWrite"
    // InternalAceGen.g:1021:1: entryRuleHttpServerAceWrite returns [EObject current=null] : iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF ;
    public final EObject entryRuleHttpServerAceWrite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceWrite = null;


        try {
            // InternalAceGen.g:1021:59: (iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF )
            // InternalAceGen.g:1022:2: iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF
            {
             newCompositeNode(grammarAccess.getHttpServerAceWriteRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpServerAceWrite=ruleHttpServerAceWrite();

            state._fsp--;

             current =iv_ruleHttpServerAceWrite; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpServerAceWrite"


    // $ANTLR start "ruleHttpServerAceWrite"
    // InternalAceGen.g:1028:1: ruleHttpServerAceWrite returns [EObject current=null] : ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* ) ;
    public final EObject ruleHttpServerAceWrite() throws RecognitionException {
        EObject current = null;

        Token lv_proxy_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_url_6_0=null;
        Token lv_authorize_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_type_5_0 = null;

        EObject lv_pathParams_9_0 = null;

        EObject lv_queryParams_11_0 = null;

        EObject lv_payload_13_0 = null;

        EObject lv_outcomes_16_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1034:2: ( ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* ) )
            // InternalAceGen.g:1035:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* )
            {
            // InternalAceGen.g:1035:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* )
            // InternalAceGen.g:1036:3: ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )*
            {
            // InternalAceGen.g:1036:3: ( (lv_proxy_0_0= 'proxy' ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==42) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalAceGen.g:1037:4: (lv_proxy_0_0= 'proxy' )
                    {
                    // InternalAceGen.g:1037:4: (lv_proxy_0_0= 'proxy' )
                    // InternalAceGen.g:1038:5: lv_proxy_0_0= 'proxy'
                    {
                    lv_proxy_0_0=(Token)match(input,42,FOLLOW_7); 

                    					newLeafNode(lv_proxy_0_0, grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    					}
                    					setWithLastConsumed(current, "proxy", true, "proxy");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1050:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:1051:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:1051:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:1052:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(lv_name_1_0, grammarAccess.getHttpServerAceWriteAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getHttpServerAceWriteAccess().getLessThanSignKeyword_2());
            		
            // InternalAceGen.g:1072:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1073:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1073:4: ( ruleQualifiedName )
            // InternalAceGen.g:1074:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_3_0());
            				
            pushFollow(FOLLOW_33);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_34); 

            			newLeafNode(otherlv_4, grammarAccess.getHttpServerAceWriteAccess().getGreaterThanSignKeyword_4());
            		
            // InternalAceGen.g:1092:3: ( (lv_type_5_0= ruleWriteFunctionType ) )
            // InternalAceGen.g:1093:4: (lv_type_5_0= ruleWriteFunctionType )
            {
            // InternalAceGen.g:1093:4: (lv_type_5_0= ruleWriteFunctionType )
            // InternalAceGen.g:1094:5: lv_type_5_0= ruleWriteFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getTypeWriteFunctionTypeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_35);
            lv_type_5_0=ruleWriteFunctionType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHttpServerAceWriteRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_5_0,
            						"de.acegen.AceGen.WriteFunctionType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1111:3: ( (lv_url_6_0= RULE_STRING ) )
            // InternalAceGen.g:1112:4: (lv_url_6_0= RULE_STRING )
            {
            // InternalAceGen.g:1112:4: (lv_url_6_0= RULE_STRING )
            // InternalAceGen.g:1113:5: lv_url_6_0= RULE_STRING
            {
            lv_url_6_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

            					newLeafNode(lv_url_6_0, grammarAccess.getHttpServerAceWriteAccess().getUrlSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
            					}
            					setWithLastConsumed(
            						current,
            						"url",
            						lv_url_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalAceGen.g:1129:3: ( (lv_authorize_7_0= 'authorize' ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==43) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalAceGen.g:1130:4: (lv_authorize_7_0= 'authorize' )
                    {
                    // InternalAceGen.g:1130:4: (lv_authorize_7_0= 'authorize' )
                    // InternalAceGen.g:1131:5: lv_authorize_7_0= 'authorize'
                    {
                    lv_authorize_7_0=(Token)match(input,43,FOLLOW_37); 

                    					newLeafNode(lv_authorize_7_0, grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    					}
                    					setWithLastConsumed(current, "authorize", true, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1143:3: (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==44) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalAceGen.g:1144:4: otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_8=(Token)match(input,44,FOLLOW_38); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:1148:4: ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==RULE_ID) ) {
                            int LA38_2 = input.LA(2);

                            if ( (LA38_2==EOF||LA38_2==RULE_ID||LA38_2==21||(LA38_2>=39 && LA38_2<=42)||(LA38_2>=45 && LA38_2<=48)||LA38_2==65) ) {
                                alt38=1;
                            }


                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalAceGen.g:1149:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:1149:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:1150:6: lv_pathParams_9_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeParamRefParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_38);
                    	    lv_pathParams_9_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceWriteRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"pathParams",
                    	    							lv_pathParams_9_0,
                    	    							"de.acegen.AceGen.AttributeParamRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1168:3: (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==45) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalAceGen.g:1169:4: otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_10=(Token)match(input,45,FOLLOW_39); 

                    				newLeafNode(otherlv_10, grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_9_0());
                    			
                    // InternalAceGen.g:1173:4: ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID) ) {
                            int LA40_2 = input.LA(2);

                            if ( (LA40_2==EOF||LA40_2==RULE_ID||LA40_2==21||(LA40_2>=39 && LA40_2<=42)||(LA40_2>=46 && LA40_2<=48)||LA40_2==65) ) {
                                alt40=1;
                            }


                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalAceGen.g:1174:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:1174:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:1175:6: lv_queryParams_11_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeParamRefParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_39);
                    	    lv_queryParams_11_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceWriteRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"queryParams",
                    	    							lv_queryParams_11_0,
                    	    							"de.acegen.AceGen.AttributeParamRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1193:3: (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==46) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalAceGen.g:1194:4: otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_12=(Token)match(input,46,FOLLOW_40); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_10_0());
                    			
                    // InternalAceGen.g:1198:4: ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==RULE_ID) ) {
                            int LA42_2 = input.LA(2);

                            if ( (LA42_2==EOF||LA42_2==RULE_ID||LA42_2==21||(LA42_2>=39 && LA42_2<=42)||(LA42_2>=47 && LA42_2<=48)||LA42_2==65) ) {
                                alt42=1;
                            }


                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalAceGen.g:1199:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:1199:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:1200:6: lv_payload_13_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeParamRefParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_40);
                    	    lv_payload_13_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceWriteRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"payload",
                    	    							lv_payload_13_0,
                    	    							"de.acegen.AceGen.AttributeParamRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1218:3: (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==47) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAceGen.g:1219:4: otherlv_14= 'response' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_14=(Token)match(input,47,FOLLOW_41); 

                    				newLeafNode(otherlv_14, grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_11_0());
                    			
                    // InternalAceGen.g:1223:4: ( ( ruleQualifiedName ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==RULE_ID) ) {
                            int LA44_2 = input.LA(2);

                            if ( (LA44_2==EOF||LA44_2==RULE_ID||LA44_2==21||(LA44_2>=39 && LA44_2<=42)||LA44_2==65) ) {
                                alt44=1;
                            }


                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalAceGen.g:1224:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1224:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1225:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeCrossReference_11_1_0());
                    	    					
                    	    pushFollow(FOLLOW_41);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1240:3: ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==21) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalAceGen.g:1241:4: (lv_outcomes_16_0= ruleHttpServerOutcome )
            	    {
            	    // InternalAceGen.g:1241:4: (lv_outcomes_16_0= ruleHttpServerOutcome )
            	    // InternalAceGen.g:1242:5: lv_outcomes_16_0= ruleHttpServerOutcome
            	    {

            	    					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getOutcomesHttpServerOutcomeParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_12);
            	    lv_outcomes_16_0=ruleHttpServerOutcome();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHttpServerAceWriteRule());
            	    					}
            	    					add(
            	    						current,
            	    						"outcomes",
            	    						lv_outcomes_16_0,
            	    						"de.acegen.AceGen.HttpServerOutcome");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpServerAceWrite"


    // $ANTLR start "entryRuleHttpServerOutcome"
    // InternalAceGen.g:1263:1: entryRuleHttpServerOutcome returns [EObject current=null] : iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF ;
    public final EObject entryRuleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerOutcome = null;


        try {
            // InternalAceGen.g:1263:58: (iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF )
            // InternalAceGen.g:1264:2: iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF
            {
             newCompositeNode(grammarAccess.getHttpServerOutcomeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpServerOutcome=ruleHttpServerOutcome();

            state._fsp--;

             current =iv_ruleHttpServerOutcome; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpServerOutcome"


    // $ANTLR start "ruleHttpServerOutcome"
    // InternalAceGen.g:1270:1: ruleHttpServerOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* ) ;
    public final EObject ruleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAceGen.g:1276:2: ( (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* ) )
            // InternalAceGen.g:1277:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* )
            {
            // InternalAceGen.g:1277:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* )
            // InternalAceGen.g:1278:3: otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )*
            {
            otherlv_0=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpServerOutcomeAccess().getOnKeyword_0());
            		
            // InternalAceGen.g:1282:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:1283:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:1283:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:1284:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(lv_name_1_0, grammarAccess.getHttpServerOutcomeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerOutcomeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:1300:3: (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==22) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalAceGen.g:1301:4: otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')'
            	    {
            	    otherlv_2=(Token)match(input,22,FOLLOW_17); 

            	    				newLeafNode(otherlv_2, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0());
            	    			
            	    // InternalAceGen.g:1305:4: ( ( ruleQualifiedName ) )*
            	    loop47:
            	    do {
            	        int alt47=2;
            	        int LA47_0 = input.LA(1);

            	        if ( (LA47_0==RULE_ID) ) {
            	            alt47=1;
            	        }


            	        switch (alt47) {
            	    	case 1 :
            	    	    // InternalAceGen.g:1306:5: ( ruleQualifiedName )
            	    	    {
            	    	    // InternalAceGen.g:1306:5: ( ruleQualifiedName )
            	    	    // InternalAceGen.g:1307:6: ruleQualifiedName
            	    	    {

            	    	    						if (current==null) {
            	    	    							current = createModelElement(grammarAccess.getHttpServerOutcomeRule());
            	    	    						}
            	    	    					

            	    	    						newCompositeNode(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0());
            	    	    					
            	    	    pushFollow(FOLLOW_17);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;


            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop47;
            	        }
            	    } while (true);

            	    otherlv_4=(Token)match(input,23,FOLLOW_42); 

            	    				newLeafNode(otherlv_4, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpServerOutcome"


    // $ANTLR start "entryRuleHttpServerAceRead"
    // InternalAceGen.g:1330:1: entryRuleHttpServerAceRead returns [EObject current=null] : iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF ;
    public final EObject entryRuleHttpServerAceRead() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceRead = null;


        try {
            // InternalAceGen.g:1330:58: (iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF )
            // InternalAceGen.g:1331:2: iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF
            {
             newCompositeNode(grammarAccess.getHttpServerAceReadRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpServerAceRead=ruleHttpServerAceRead();

            state._fsp--;

             current =iv_ruleHttpServerAceRead; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpServerAceRead"


    // $ANTLR start "ruleHttpServerAceRead"
    // InternalAceGen.g:1337:1: ruleHttpServerAceRead returns [EObject current=null] : ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ) ;
    public final EObject ruleHttpServerAceRead() throws RecognitionException {
        EObject current = null;

        Token lv_proxy_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_url_6_0=null;
        Token lv_authorize_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_type_5_0 = null;

        EObject lv_pathParams_9_0 = null;

        EObject lv_queryParams_11_0 = null;

        EObject lv_payload_13_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1343:2: ( ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ) )
            // InternalAceGen.g:1344:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? )
            {
            // InternalAceGen.g:1344:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? )
            // InternalAceGen.g:1345:3: ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )?
            {
            // InternalAceGen.g:1345:3: ( (lv_proxy_0_0= 'proxy' ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==42) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalAceGen.g:1346:4: (lv_proxy_0_0= 'proxy' )
                    {
                    // InternalAceGen.g:1346:4: (lv_proxy_0_0= 'proxy' )
                    // InternalAceGen.g:1347:5: lv_proxy_0_0= 'proxy'
                    {
                    lv_proxy_0_0=(Token)match(input,42,FOLLOW_7); 

                    					newLeafNode(lv_proxy_0_0, grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    					}
                    					setWithLastConsumed(current, "proxy", true, "proxy");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1359:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:1360:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:1360:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:1361:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(lv_name_1_0, grammarAccess.getHttpServerAceReadAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getHttpServerAceReadAccess().getLessThanSignKeyword_2());
            		
            // InternalAceGen.g:1381:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1382:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1382:4: ( ruleQualifiedName )
            // InternalAceGen.g:1383:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_3_0());
            				
            pushFollow(FOLLOW_33);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_43); 

            			newLeafNode(otherlv_4, grammarAccess.getHttpServerAceReadAccess().getGreaterThanSignKeyword_4());
            		
            // InternalAceGen.g:1401:3: ( (lv_type_5_0= ruleReadFunctionType ) )
            // InternalAceGen.g:1402:4: (lv_type_5_0= ruleReadFunctionType )
            {
            // InternalAceGen.g:1402:4: (lv_type_5_0= ruleReadFunctionType )
            // InternalAceGen.g:1403:5: lv_type_5_0= ruleReadFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getTypeReadFunctionTypeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_35);
            lv_type_5_0=ruleReadFunctionType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHttpServerAceReadRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_5_0,
            						"de.acegen.AceGen.ReadFunctionType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1420:3: ( (lv_url_6_0= RULE_STRING ) )
            // InternalAceGen.g:1421:4: (lv_url_6_0= RULE_STRING )
            {
            // InternalAceGen.g:1421:4: (lv_url_6_0= RULE_STRING )
            // InternalAceGen.g:1422:5: lv_url_6_0= RULE_STRING
            {
            lv_url_6_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

            					newLeafNode(lv_url_6_0, grammarAccess.getHttpServerAceReadAccess().getUrlSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
            					}
            					setWithLastConsumed(
            						current,
            						"url",
            						lv_url_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalAceGen.g:1438:3: ( (lv_authorize_7_0= 'authorize' ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==43) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalAceGen.g:1439:4: (lv_authorize_7_0= 'authorize' )
                    {
                    // InternalAceGen.g:1439:4: (lv_authorize_7_0= 'authorize' )
                    // InternalAceGen.g:1440:5: lv_authorize_7_0= 'authorize'
                    {
                    lv_authorize_7_0=(Token)match(input,43,FOLLOW_45); 

                    					newLeafNode(lv_authorize_7_0, grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    					}
                    					setWithLastConsumed(current, "authorize", true, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1452:3: (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==44) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalAceGen.g:1453:4: otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_8=(Token)match(input,44,FOLLOW_46); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:1457:4: ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==RULE_ID) ) {
                            int LA51_2 = input.LA(2);

                            if ( (LA51_2==EOF||LA51_2==RULE_ID||(LA51_2>=39 && LA51_2<=42)||(LA51_2>=45 && LA51_2<=48)||LA51_2==65) ) {
                                alt51=1;
                            }


                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalAceGen.g:1458:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:1458:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:1459:6: lv_pathParams_9_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeParamRefParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_46);
                    	    lv_pathParams_9_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceReadRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"pathParams",
                    	    							lv_pathParams_9_0,
                    	    							"de.acegen.AceGen.AttributeParamRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1477:3: (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==45) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalAceGen.g:1478:4: otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_10=(Token)match(input,45,FOLLOW_47); 

                    				newLeafNode(otherlv_10, grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_9_0());
                    			
                    // InternalAceGen.g:1482:4: ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==RULE_ID) ) {
                            int LA53_2 = input.LA(2);

                            if ( (LA53_2==EOF||LA53_2==RULE_ID||(LA53_2>=39 && LA53_2<=42)||(LA53_2>=46 && LA53_2<=48)||LA53_2==65) ) {
                                alt53=1;
                            }


                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalAceGen.g:1483:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:1483:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:1484:6: lv_queryParams_11_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeParamRefParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_47);
                    	    lv_queryParams_11_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceReadRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"queryParams",
                    	    							lv_queryParams_11_0,
                    	    							"de.acegen.AceGen.AttributeParamRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1502:3: (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==46) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalAceGen.g:1503:4: otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_12=(Token)match(input,46,FOLLOW_48); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_10_0());
                    			
                    // InternalAceGen.g:1507:4: ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==RULE_ID) ) {
                            int LA55_2 = input.LA(2);

                            if ( (LA55_2==EOF||LA55_2==RULE_ID||(LA55_2>=39 && LA55_2<=42)||(LA55_2>=47 && LA55_2<=48)||LA55_2==65) ) {
                                alt55=1;
                            }


                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalAceGen.g:1508:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:1508:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:1509:6: lv_payload_13_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeParamRefParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_48);
                    	    lv_payload_13_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceReadRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"payload",
                    	    							lv_payload_13_0,
                    	    							"de.acegen.AceGen.AttributeParamRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1527:3: (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==47) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalAceGen.g:1528:4: otherlv_14= 'response' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_14=(Token)match(input,47,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_11_0());
                    			
                    // InternalAceGen.g:1532:4: ( ( ruleQualifiedName ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==RULE_ID) ) {
                            int LA57_2 = input.LA(2);

                            if ( (LA57_2==EOF||LA57_2==RULE_ID||(LA57_2>=39 && LA57_2<=42)||LA57_2==65) ) {
                                alt57=1;
                            }


                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalAceGen.g:1533:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1533:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1534:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getResponseAttributeCrossReference_11_1_0());
                    	    					
                    	    pushFollow(FOLLOW_3);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpServerAceRead"


    // $ANTLR start "entryRuleAttributeParamRef"
    // InternalAceGen.g:1553:1: entryRuleAttributeParamRef returns [EObject current=null] : iv_ruleAttributeParamRef= ruleAttributeParamRef EOF ;
    public final EObject entryRuleAttributeParamRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeParamRef = null;


        try {
            // InternalAceGen.g:1553:58: (iv_ruleAttributeParamRef= ruleAttributeParamRef EOF )
            // InternalAceGen.g:1554:2: iv_ruleAttributeParamRef= ruleAttributeParamRef EOF
            {
             newCompositeNode(grammarAccess.getAttributeParamRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeParamRef=ruleAttributeParamRef();

            state._fsp--;

             current =iv_ruleAttributeParamRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeParamRef"


    // $ANTLR start "ruleAttributeParamRef"
    // InternalAceGen.g:1560:1: ruleAttributeParamRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_optional_1_0= 'optional' ) )? ) ;
    public final EObject ruleAttributeParamRef() throws RecognitionException {
        EObject current = null;

        Token lv_optional_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:1566:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_optional_1_0= 'optional' ) )? ) )
            // InternalAceGen.g:1567:2: ( ( ( ruleQualifiedName ) ) ( (lv_optional_1_0= 'optional' ) )? )
            {
            // InternalAceGen.g:1567:2: ( ( ( ruleQualifiedName ) ) ( (lv_optional_1_0= 'optional' ) )? )
            // InternalAceGen.g:1568:3: ( ( ruleQualifiedName ) ) ( (lv_optional_1_0= 'optional' ) )?
            {
            // InternalAceGen.g:1568:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1569:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1569:4: ( ruleQualifiedName )
            // InternalAceGen.g:1570:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeParamRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAttributeParamRefAccess().getAttributeAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_49);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1584:3: ( (lv_optional_1_0= 'optional' ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==48) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalAceGen.g:1585:4: (lv_optional_1_0= 'optional' )
                    {
                    // InternalAceGen.g:1585:4: (lv_optional_1_0= 'optional' )
                    // InternalAceGen.g:1586:5: lv_optional_1_0= 'optional'
                    {
                    lv_optional_1_0=(Token)match(input,48,FOLLOW_2); 

                    					newLeafNode(lv_optional_1_0, grammarAccess.getAttributeParamRefAccess().getOptionalOptionalKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeParamRefRule());
                    					}
                    					setWithLastConsumed(current, "optional", true, "optional");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeParamRef"


    // $ANTLR start "entryRuleHttpServerView"
    // InternalAceGen.g:1602:1: entryRuleHttpServerView returns [EObject current=null] : iv_ruleHttpServerView= ruleHttpServerView EOF ;
    public final EObject entryRuleHttpServerView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerView = null;


        try {
            // InternalAceGen.g:1602:55: (iv_ruleHttpServerView= ruleHttpServerView EOF )
            // InternalAceGen.g:1603:2: iv_ruleHttpServerView= ruleHttpServerView EOF
            {
             newCompositeNode(grammarAccess.getHttpServerViewRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpServerView=ruleHttpServerView();

            state._fsp--;

             current =iv_ruleHttpServerView; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpServerView"


    // $ANTLR start "ruleHttpServerView"
    // InternalAceGen.g:1609:1: ruleHttpServerView returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleHttpServerView() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_renderFunctions_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1615:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? ) )
            // InternalAceGen.g:1616:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? )
            {
            // InternalAceGen.g:1616:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? )
            // InternalAceGen.g:1617:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )?
            {
            // InternalAceGen.g:1617:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1618:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1618:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1619:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_50); 

            					newLeafNode(lv_name_0_0, grammarAccess.getHttpServerViewAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerViewRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:1635:3: (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==34) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalAceGen.g:1636:4: otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_25); 

                    				newLeafNode(otherlv_1, grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalAceGen.g:1640:4: ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==RULE_ID) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalAceGen.g:1641:5: (lv_renderFunctions_2_0= ruleHttpServerViewFunction )
                    	    {
                    	    // InternalAceGen.g:1641:5: (lv_renderFunctions_2_0= ruleHttpServerViewFunction )
                    	    // InternalAceGen.g:1642:6: lv_renderFunctions_2_0= ruleHttpServerViewFunction
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerViewAccess().getRenderFunctionsHttpServerViewFunctionParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_25);
                    	    lv_renderFunctions_2_0=ruleHttpServerViewFunction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerViewRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"renderFunctions",
                    	    							lv_renderFunctions_2_0,
                    	    							"de.acegen.AceGen.HttpServerViewFunction");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,35,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getHttpServerViewAccess().getRightCurlyBracketKeyword_1_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpServerView"


    // $ANTLR start "entryRuleHttpServerViewFunction"
    // InternalAceGen.g:1668:1: entryRuleHttpServerViewFunction returns [EObject current=null] : iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF ;
    public final EObject entryRuleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerViewFunction = null;


        try {
            // InternalAceGen.g:1668:63: (iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF )
            // InternalAceGen.g:1669:2: iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF
            {
             newCompositeNode(grammarAccess.getHttpServerViewFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHttpServerViewFunction=ruleHttpServerViewFunction();

            state._fsp--;

             current =iv_ruleHttpServerViewFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHttpServerViewFunction"


    // $ANTLR start "ruleHttpServerViewFunction"
    // InternalAceGen.g:1675:1: ruleHttpServerViewFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) ;
    public final EObject ruleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalAceGen.g:1681:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) )
            // InternalAceGen.g:1682:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            {
            // InternalAceGen.g:1682:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            // InternalAceGen.g:1683:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')'
            {
            // InternalAceGen.g:1683:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1684:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1684:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1685:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_0_0, grammarAccess.getHttpServerViewFunctionAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerViewFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getHttpServerViewFunctionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:1705:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1706:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1706:4: ( ruleQualifiedName )
            // InternalAceGen.g:1707:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerViewFunctionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_51);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getHttpServerViewFunctionAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHttpServerViewFunction"


    // $ANTLR start "entryRuleAuthUser"
    // InternalAceGen.g:1729:1: entryRuleAuthUser returns [EObject current=null] : iv_ruleAuthUser= ruleAuthUser EOF ;
    public final EObject entryRuleAuthUser() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthUser = null;


        try {
            // InternalAceGen.g:1729:49: (iv_ruleAuthUser= ruleAuthUser EOF )
            // InternalAceGen.g:1730:2: iv_ruleAuthUser= ruleAuthUser EOF
            {
             newCompositeNode(grammarAccess.getAuthUserRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAuthUser=ruleAuthUser();

            state._fsp--;

             current =iv_ruleAuthUser; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAuthUser"


    // $ANTLR start "ruleAuthUser"
    // InternalAceGen.g:1736:1: ruleAuthUser returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) ;
    public final EObject ruleAuthUser() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1742:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) )
            // InternalAceGen.g:1743:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            {
            // InternalAceGen.g:1743:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            // InternalAceGen.g:1744:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            {
            // InternalAceGen.g:1744:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1745:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1745:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1746:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_0_0, grammarAccess.getAuthUserAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAuthUserRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:1762:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            // InternalAceGen.g:1763:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}'
            {
            otherlv_1=(Token)match(input,34,FOLLOW_52); 

            				newLeafNode(otherlv_1, grammarAccess.getAuthUserAccess().getLeftCurlyBracketKeyword_1_0());
            			
            // InternalAceGen.g:1767:4: ( (lv_attributes_2_0= ruleAttribute ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID||(LA62_0>=59 && LA62_0<=62)||(LA62_0>=70 && LA62_0<=75)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalAceGen.g:1768:5: (lv_attributes_2_0= ruleAttribute )
            	    {
            	    // InternalAceGen.g:1768:5: (lv_attributes_2_0= ruleAttribute )
            	    // InternalAceGen.g:1769:6: lv_attributes_2_0= ruleAttribute
            	    {

            	    						newCompositeNode(grammarAccess.getAuthUserAccess().getAttributesAttributeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_52);
            	    lv_attributes_2_0=ruleAttribute();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAuthUserRule());
            	    						}
            	    						add(
            	    							current,
            	    							"attributes",
            	    							lv_attributes_2_0,
            	    							"de.acegen.AceGen.Attribute");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            otherlv_3=(Token)match(input,35,FOLLOW_2); 

            				newLeafNode(otherlv_3, grammarAccess.getAuthUserAccess().getRightCurlyBracketKeyword_1_2());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAuthUser"


    // $ANTLR start "entryRuleModel"
    // InternalAceGen.g:1795:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAceGen.g:1795:46: (iv_ruleModel= ruleModel EOF )
            // InternalAceGen.g:1796:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalAceGen.g:1802:1: ruleModel returns [EObject current=null] : ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_persistent_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_attributes_7_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1808:2: ( ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) )
            // InternalAceGen.g:1809:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            {
            // InternalAceGen.g:1809:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            // InternalAceGen.g:1810:3: ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            {
            // InternalAceGen.g:1810:3: ( (lv_persistent_0_0= 'persistent' ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==49) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalAceGen.g:1811:4: (lv_persistent_0_0= 'persistent' )
                    {
                    // InternalAceGen.g:1811:4: (lv_persistent_0_0= 'persistent' )
                    // InternalAceGen.g:1812:5: lv_persistent_0_0= 'persistent'
                    {
                    lv_persistent_0_0=(Token)match(input,49,FOLLOW_7); 

                    					newLeafNode(lv_persistent_0_0, grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(current, "persistent", true, "persistent");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1824:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:1825:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:1825:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:1826:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_53); 

            					newLeafNode(lv_name_1_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:1842:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==50) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalAceGen.g:1843:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_2=(Token)match(input,50,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getExtendsKeyword_2_0());
                    			
                    // InternalAceGen.g:1847:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:1848:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:1848:5: ( ruleQualifiedName )
                    // InternalAceGen.g:1849:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_54);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:1863:4: (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==17) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalAceGen.g:1864:5: otherlv_4= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_7); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getModelAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:1868:5: ( ( ruleQualifiedName ) )
                    	    // InternalAceGen.g:1869:6: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1869:6: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1870:7: ruleQualifiedName
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModelRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_54);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1886:3: (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==34) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalAceGen.g:1887:4: otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,34,FOLLOW_52); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalAceGen.g:1891:4: ( (lv_attributes_7_0= ruleAttribute ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==RULE_ID||(LA66_0>=59 && LA66_0<=62)||(LA66_0>=70 && LA66_0<=75)) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalAceGen.g:1892:5: (lv_attributes_7_0= ruleAttribute )
                    	    {
                    	    // InternalAceGen.g:1892:5: (lv_attributes_7_0= ruleAttribute )
                    	    // InternalAceGen.g:1893:6: lv_attributes_7_0= ruleAttribute
                    	    {

                    	    						newCompositeNode(grammarAccess.getModelAccess().getAttributesAttributeParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_52);
                    	    lv_attributes_7_0=ruleAttribute();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getModelRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"attributes",
                    	    							lv_attributes_7_0,
                    	    							"de.acegen.AceGen.Attribute");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop66;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,35,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_3_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleScenario"
    // InternalAceGen.g:1919:1: entryRuleScenario returns [EObject current=null] : iv_ruleScenario= ruleScenario EOF ;
    public final EObject entryRuleScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario = null;


        try {
            // InternalAceGen.g:1919:49: (iv_ruleScenario= ruleScenario EOF )
            // InternalAceGen.g:1920:2: iv_ruleScenario= ruleScenario EOF
            {
             newCompositeNode(grammarAccess.getScenarioRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScenario=ruleScenario();

            state._fsp--;

             current =iv_ruleScenario; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenario"


    // $ANTLR start "ruleScenario"
    // InternalAceGen.g:1926:1: ruleScenario returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) ) ;
    public final EObject ruleScenario() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_givenRefs_2_0 = null;

        EObject lv_whenBlock_4_0 = null;

        EObject lv_thenBlock_6_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1932:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) ) )
            // InternalAceGen.g:1933:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) )
            {
            // InternalAceGen.g:1933:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) )
            // InternalAceGen.g:1934:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) )
            {
            // InternalAceGen.g:1934:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1935:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1935:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1936:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_55); 

            					newLeafNode(lv_name_0_0, grammarAccess.getScenarioAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScenarioRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:1952:3: (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==51) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalAceGen.g:1953:4: otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )*
                    {
                    otherlv_1=(Token)match(input,51,FOLLOW_56); 

                    				newLeafNode(otherlv_1, grammarAccess.getScenarioAccess().getGIVENKeyword_1_0());
                    			
                    // InternalAceGen.g:1957:4: ( (lv_givenRefs_2_0= ruleGivenRef ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==RULE_ID) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalAceGen.g:1958:5: (lv_givenRefs_2_0= ruleGivenRef )
                    	    {
                    	    // InternalAceGen.g:1958:5: (lv_givenRefs_2_0= ruleGivenRef )
                    	    // InternalAceGen.g:1959:6: lv_givenRefs_2_0= ruleGivenRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getScenarioAccess().getGivenRefsGivenRefParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_56);
                    	    lv_givenRefs_2_0=ruleGivenRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getScenarioRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"givenRefs",
                    	    							lv_givenRefs_2_0,
                    	    							"de.acegen.AceGen.GivenRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_3=(Token)match(input,52,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getScenarioAccess().getWHENKeyword_2());
            		
            // InternalAceGen.g:1981:3: ( (lv_whenBlock_4_0= ruleWhenBlock ) )
            // InternalAceGen.g:1982:4: (lv_whenBlock_4_0= ruleWhenBlock )
            {
            // InternalAceGen.g:1982:4: (lv_whenBlock_4_0= ruleWhenBlock )
            // InternalAceGen.g:1983:5: lv_whenBlock_4_0= ruleWhenBlock
            {

            					newCompositeNode(grammarAccess.getScenarioAccess().getWhenBlockWhenBlockParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_57);
            lv_whenBlock_4_0=ruleWhenBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioRule());
            					}
            					set(
            						current,
            						"whenBlock",
            						lv_whenBlock_4_0,
            						"de.acegen.AceGen.WhenBlock");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,53,FOLLOW_58); 

            			newLeafNode(otherlv_5, grammarAccess.getScenarioAccess().getTHENKeyword_4());
            		
            // InternalAceGen.g:2004:3: ( (lv_thenBlock_6_0= ruleThenBlock ) )
            // InternalAceGen.g:2005:4: (lv_thenBlock_6_0= ruleThenBlock )
            {
            // InternalAceGen.g:2005:4: (lv_thenBlock_6_0= ruleThenBlock )
            // InternalAceGen.g:2006:5: lv_thenBlock_6_0= ruleThenBlock
            {

            					newCompositeNode(grammarAccess.getScenarioAccess().getThenBlockThenBlockParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_thenBlock_6_0=ruleThenBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioRule());
            					}
            					set(
            						current,
            						"thenBlock",
            						lv_thenBlock_6_0,
            						"de.acegen.AceGen.ThenBlock");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario"


    // $ANTLR start "entryRuleGivenRef"
    // InternalAceGen.g:2027:1: entryRuleGivenRef returns [EObject current=null] : iv_ruleGivenRef= ruleGivenRef EOF ;
    public final EObject entryRuleGivenRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGivenRef = null;


        try {
            // InternalAceGen.g:2027:49: (iv_ruleGivenRef= ruleGivenRef EOF )
            // InternalAceGen.g:2028:2: iv_ruleGivenRef= ruleGivenRef EOF
            {
             newCompositeNode(grammarAccess.getGivenRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGivenRef=ruleGivenRef();

            state._fsp--;

             current =iv_ruleGivenRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGivenRef"


    // $ANTLR start "ruleGivenRef"
    // InternalAceGen.g:2034:1: ruleGivenRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? ) ;
    public final EObject ruleGivenRef() throws RecognitionException {
        EObject current = null;

        Token lv_times_1_0=null;
        Token otherlv_2=null;
        Token lv_excludeGiven_3_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:2040:2: ( ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? ) )
            // InternalAceGen.g:2041:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? )
            {
            // InternalAceGen.g:2041:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? )
            // InternalAceGen.g:2042:3: ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )?
            {
            // InternalAceGen.g:2042:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2043:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2043:4: ( ruleQualifiedName )
            // InternalAceGen.g:2044:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGivenRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGivenRefAccess().getScenarioScenarioCrossReference_0_0());
            				
            pushFollow(FOLLOW_59);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:2058:3: ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_INT) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalAceGen.g:2059:4: ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x'
                    {
                    // InternalAceGen.g:2059:4: ( (lv_times_1_0= RULE_INT ) )
                    // InternalAceGen.g:2060:5: (lv_times_1_0= RULE_INT )
                    {
                    // InternalAceGen.g:2060:5: (lv_times_1_0= RULE_INT )
                    // InternalAceGen.g:2061:6: lv_times_1_0= RULE_INT
                    {
                    lv_times_1_0=(Token)match(input,RULE_INT,FOLLOW_60); 

                    						newLeafNode(lv_times_1_0, grammarAccess.getGivenRefAccess().getTimesINTTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGivenRefRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"times",
                    							lv_times_1_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,54,FOLLOW_61); 

                    				newLeafNode(otherlv_2, grammarAccess.getGivenRefAccess().getXKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:2082:3: ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==55) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalAceGen.g:2083:4: (lv_excludeGiven_3_0= 'excludeGIVEN' )
                    {
                    // InternalAceGen.g:2083:4: (lv_excludeGiven_3_0= 'excludeGIVEN' )
                    // InternalAceGen.g:2084:5: lv_excludeGiven_3_0= 'excludeGIVEN'
                    {
                    lv_excludeGiven_3_0=(Token)match(input,55,FOLLOW_2); 

                    					newLeafNode(lv_excludeGiven_3_0, grammarAccess.getGivenRefAccess().getExcludeGivenExcludeGIVENKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getGivenRefRule());
                    					}
                    					setWithLastConsumed(current, "excludeGiven", true, "excludeGIVEN");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGivenRef"


    // $ANTLR start "entryRuleWhenBlock"
    // InternalAceGen.g:2100:1: entryRuleWhenBlock returns [EObject current=null] : iv_ruleWhenBlock= ruleWhenBlock EOF ;
    public final EObject entryRuleWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhenBlock = null;


        try {
            // InternalAceGen.g:2100:50: (iv_ruleWhenBlock= ruleWhenBlock EOF )
            // InternalAceGen.g:2101:2: iv_ruleWhenBlock= ruleWhenBlock EOF
            {
             newCompositeNode(grammarAccess.getWhenBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWhenBlock=ruleWhenBlock();

            state._fsp--;

             current =iv_ruleWhenBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhenBlock"


    // $ANTLR start "ruleWhenBlock"
    // InternalAceGen.g:2107:1: ruleWhenBlock returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ) ;
    public final EObject ruleWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_dataDefinition_1_0 = null;

        EObject lv_authorization_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2113:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ) )
            // InternalAceGen.g:2114:2: ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? )
            {
            // InternalAceGen.g:2114:2: ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? )
            // InternalAceGen.g:2115:3: ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )?
            {
            // InternalAceGen.g:2115:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2116:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2116:4: ( ruleQualifiedName )
            // InternalAceGen.g:2117:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWhenBlockRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWhenBlockAccess().getActionHttpServerAceCrossReference_0_0());
            				
            pushFollow(FOLLOW_62);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:2131:3: ( (lv_dataDefinition_1_0= ruleDataDefinition ) )
            // InternalAceGen.g:2132:4: (lv_dataDefinition_1_0= ruleDataDefinition )
            {
            // InternalAceGen.g:2132:4: (lv_dataDefinition_1_0= ruleDataDefinition )
            // InternalAceGen.g:2133:5: lv_dataDefinition_1_0= ruleDataDefinition
            {

            					newCompositeNode(grammarAccess.getWhenBlockAccess().getDataDefinitionDataDefinitionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_63);
            lv_dataDefinition_1_0=ruleDataDefinition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhenBlockRule());
            					}
            					set(
            						current,
            						"dataDefinition",
            						lv_dataDefinition_1_0,
            						"de.acegen.AceGen.DataDefinition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:2150:3: ( (lv_authorization_2_0= ruleAuthorization ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==58) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalAceGen.g:2151:4: (lv_authorization_2_0= ruleAuthorization )
                    {
                    // InternalAceGen.g:2151:4: (lv_authorization_2_0= ruleAuthorization )
                    // InternalAceGen.g:2152:5: lv_authorization_2_0= ruleAuthorization
                    {

                    					newCompositeNode(grammarAccess.getWhenBlockAccess().getAuthorizationAuthorizationParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_authorization_2_0=ruleAuthorization();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getWhenBlockRule());
                    					}
                    					set(
                    						current,
                    						"authorization",
                    						lv_authorization_2_0,
                    						"de.acegen.AceGen.Authorization");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhenBlock"


    // $ANTLR start "entryRuleThenBlock"
    // InternalAceGen.g:2173:1: entryRuleThenBlock returns [EObject current=null] : iv_ruleThenBlock= ruleThenBlock EOF ;
    public final EObject entryRuleThenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThenBlock = null;


        try {
            // InternalAceGen.g:2173:50: (iv_ruleThenBlock= ruleThenBlock EOF )
            // InternalAceGen.g:2174:2: iv_ruleThenBlock= ruleThenBlock EOF
            {
             newCompositeNode(grammarAccess.getThenBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThenBlock=ruleThenBlock();

            state._fsp--;

             current =iv_ruleThenBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThenBlock"


    // $ANTLR start "ruleThenBlock"
    // InternalAceGen.g:2180:1: ruleThenBlock returns [EObject current=null] : ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' ( (lv_response_2_0= ruleDataDefinition ) ) )? ) ;
    public final EObject ruleThenBlock() throws RecognitionException {
        EObject current = null;

        Token lv_statusCode_0_0=null;
        Token otherlv_1=null;
        EObject lv_response_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2186:2: ( ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' ( (lv_response_2_0= ruleDataDefinition ) ) )? ) )
            // InternalAceGen.g:2187:2: ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' ( (lv_response_2_0= ruleDataDefinition ) ) )? )
            {
            // InternalAceGen.g:2187:2: ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' ( (lv_response_2_0= ruleDataDefinition ) ) )? )
            // InternalAceGen.g:2188:3: ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' ( (lv_response_2_0= ruleDataDefinition ) ) )?
            {
            // InternalAceGen.g:2188:3: ( (lv_statusCode_0_0= RULE_INT ) )
            // InternalAceGen.g:2189:4: (lv_statusCode_0_0= RULE_INT )
            {
            // InternalAceGen.g:2189:4: (lv_statusCode_0_0= RULE_INT )
            // InternalAceGen.g:2190:5: lv_statusCode_0_0= RULE_INT
            {
            lv_statusCode_0_0=(Token)match(input,RULE_INT,FOLLOW_64); 

            					newLeafNode(lv_statusCode_0_0, grammarAccess.getThenBlockAccess().getStatusCodeINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getThenBlockRule());
            					}
            					setWithLastConsumed(
            						current,
            						"statusCode",
            						lv_statusCode_0_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalAceGen.g:2206:3: (otherlv_1= 'response' ( (lv_response_2_0= ruleDataDefinition ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==47) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalAceGen.g:2207:4: otherlv_1= 'response' ( (lv_response_2_0= ruleDataDefinition ) )
                    {
                    otherlv_1=(Token)match(input,47,FOLLOW_65); 

                    				newLeafNode(otherlv_1, grammarAccess.getThenBlockAccess().getResponseKeyword_1_0());
                    			
                    // InternalAceGen.g:2211:4: ( (lv_response_2_0= ruleDataDefinition ) )
                    // InternalAceGen.g:2212:5: (lv_response_2_0= ruleDataDefinition )
                    {
                    // InternalAceGen.g:2212:5: (lv_response_2_0= ruleDataDefinition )
                    // InternalAceGen.g:2213:6: lv_response_2_0= ruleDataDefinition
                    {

                    						newCompositeNode(grammarAccess.getThenBlockAccess().getResponseDataDefinitionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_response_2_0=ruleDataDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getThenBlockRule());
                    						}
                    						set(
                    							current,
                    							"response",
                    							lv_response_2_0,
                    							"de.acegen.AceGen.DataDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThenBlock"


    // $ANTLR start "entryRuleDataDefinition"
    // InternalAceGen.g:2235:1: entryRuleDataDefinition returns [EObject current=null] : iv_ruleDataDefinition= ruleDataDefinition EOF ;
    public final EObject entryRuleDataDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDefinition = null;


        try {
            // InternalAceGen.g:2235:55: (iv_ruleDataDefinition= ruleDataDefinition EOF )
            // InternalAceGen.g:2236:2: iv_ruleDataDefinition= ruleDataDefinition EOF
            {
             newCompositeNode(grammarAccess.getDataDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataDefinition=ruleDataDefinition();

            state._fsp--;

             current =iv_ruleDataDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataDefinition"


    // $ANTLR start "ruleDataDefinition"
    // InternalAceGen.g:2242:1: ruleDataDefinition returns [EObject current=null] : ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? ) ;
    public final EObject ruleDataDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_uuid_2_0=null;
        Token otherlv_3=null;
        Token lv_systemtime_4_0=null;
        Token lv_pattern_5_0=null;
        EObject lv_data_6_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2248:2: ( ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? ) )
            // InternalAceGen.g:2249:2: ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? )
            {
            // InternalAceGen.g:2249:2: ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? )
            // InternalAceGen.g:2250:3: () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )?
            {
            // InternalAceGen.g:2250:3: ()
            // InternalAceGen.g:2251:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataDefinitionAccess().getDataDefinitionAction_0(),
            					current);
            			

            }

            // InternalAceGen.g:2257:3: (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==56) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalAceGen.g:2258:4: otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,56,FOLLOW_35); 

                    				newLeafNode(otherlv_1, grammarAccess.getDataDefinitionAccess().getUuidKeyword_1_0());
                    			
                    // InternalAceGen.g:2262:4: ( (lv_uuid_2_0= RULE_STRING ) )
                    // InternalAceGen.g:2263:5: (lv_uuid_2_0= RULE_STRING )
                    {
                    // InternalAceGen.g:2263:5: (lv_uuid_2_0= RULE_STRING )
                    // InternalAceGen.g:2264:6: lv_uuid_2_0= RULE_STRING
                    {
                    lv_uuid_2_0=(Token)match(input,RULE_STRING,FOLLOW_66); 

                    						newLeafNode(lv_uuid_2_0, grammarAccess.getDataDefinitionAccess().getUuidSTRINGTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataDefinitionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"uuid",
                    							lv_uuid_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:2281:3: (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==57) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalAceGen.g:2282:4: otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,57,FOLLOW_35); 

                    				newLeafNode(otherlv_3, grammarAccess.getDataDefinitionAccess().getSystemTimeKeyword_2_0());
                    			
                    // InternalAceGen.g:2286:4: ( (lv_systemtime_4_0= RULE_STRING ) )
                    // InternalAceGen.g:2287:5: (lv_systemtime_4_0= RULE_STRING )
                    {
                    // InternalAceGen.g:2287:5: (lv_systemtime_4_0= RULE_STRING )
                    // InternalAceGen.g:2288:6: lv_systemtime_4_0= RULE_STRING
                    {
                    lv_systemtime_4_0=(Token)match(input,RULE_STRING,FOLLOW_35); 

                    						newLeafNode(lv_systemtime_4_0, grammarAccess.getDataDefinitionAccess().getSystemtimeSTRINGTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataDefinitionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"systemtime",
                    							lv_systemtime_4_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    // InternalAceGen.g:2304:4: ( (lv_pattern_5_0= RULE_STRING ) )
                    // InternalAceGen.g:2305:5: (lv_pattern_5_0= RULE_STRING )
                    {
                    // InternalAceGen.g:2305:5: (lv_pattern_5_0= RULE_STRING )
                    // InternalAceGen.g:2306:6: lv_pattern_5_0= RULE_STRING
                    {
                    lv_pattern_5_0=(Token)match(input,RULE_STRING,FOLLOW_50); 

                    						newLeafNode(lv_pattern_5_0, grammarAccess.getDataDefinitionAccess().getPatternSTRINGTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataDefinitionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"pattern",
                    							lv_pattern_5_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:2323:3: ( (lv_data_6_0= ruleJsonObject ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==34) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalAceGen.g:2324:4: (lv_data_6_0= ruleJsonObject )
                    {
                    // InternalAceGen.g:2324:4: (lv_data_6_0= ruleJsonObject )
                    // InternalAceGen.g:2325:5: lv_data_6_0= ruleJsonObject
                    {

                    					newCompositeNode(grammarAccess.getDataDefinitionAccess().getDataJsonObjectParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_data_6_0=ruleJsonObject();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDataDefinitionRule());
                    					}
                    					set(
                    						current,
                    						"data",
                    						lv_data_6_0,
                    						"de.acegen.AceGen.JsonObject");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataDefinition"


    // $ANTLR start "entryRuleAuthorization"
    // InternalAceGen.g:2346:1: entryRuleAuthorization returns [EObject current=null] : iv_ruleAuthorization= ruleAuthorization EOF ;
    public final EObject entryRuleAuthorization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthorization = null;


        try {
            // InternalAceGen.g:2346:54: (iv_ruleAuthorization= ruleAuthorization EOF )
            // InternalAceGen.g:2347:2: iv_ruleAuthorization= ruleAuthorization EOF
            {
             newCompositeNode(grammarAccess.getAuthorizationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAuthorization=ruleAuthorization();

            state._fsp--;

             current =iv_ruleAuthorization; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAuthorization"


    // $ANTLR start "ruleAuthorization"
    // InternalAceGen.g:2353:1: ruleAuthorization returns [EObject current=null] : (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleAuthorization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_username_1_0=null;
        Token otherlv_2=null;
        Token lv_password_3_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:2359:2: ( (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) ) )
            // InternalAceGen.g:2360:2: (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) )
            {
            // InternalAceGen.g:2360:2: (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) )
            // InternalAceGen.g:2361:3: otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_35); 

            			newLeafNode(otherlv_0, grammarAccess.getAuthorizationAccess().getAuthorizationKeyword_0());
            		
            // InternalAceGen.g:2365:3: ( (lv_username_1_0= RULE_STRING ) )
            // InternalAceGen.g:2366:4: (lv_username_1_0= RULE_STRING )
            {
            // InternalAceGen.g:2366:4: (lv_username_1_0= RULE_STRING )
            // InternalAceGen.g:2367:5: lv_username_1_0= RULE_STRING
            {
            lv_username_1_0=(Token)match(input,RULE_STRING,FOLLOW_23); 

            					newLeafNode(lv_username_1_0, grammarAccess.getAuthorizationAccess().getUsernameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAuthorizationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"username",
            						lv_username_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,33,FOLLOW_35); 

            			newLeafNode(otherlv_2, grammarAccess.getAuthorizationAccess().getColonKeyword_2());
            		
            // InternalAceGen.g:2387:3: ( (lv_password_3_0= RULE_STRING ) )
            // InternalAceGen.g:2388:4: (lv_password_3_0= RULE_STRING )
            {
            // InternalAceGen.g:2388:4: (lv_password_3_0= RULE_STRING )
            // InternalAceGen.g:2389:5: lv_password_3_0= RULE_STRING
            {
            lv_password_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_password_3_0, grammarAccess.getAuthorizationAccess().getPasswordSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAuthorizationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"password",
            						lv_password_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAuthorization"


    // $ANTLR start "entryRuleAttribute"
    // InternalAceGen.g:2409:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalAceGen.g:2409:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalAceGen.g:2410:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalAceGen.g:2416:1: ruleAttribute returns [EObject current=null] : ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_notReplayable_9_0= 'notReplayable' ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_unique_0_0=null;
        Token lv_primaryKey_1_0=null;
        Token lv_notNull_2_0=null;
        Token lv_list_3_0=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token lv_notReplayable_9_0=null;
        AntlrDatatypeRuleToken lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2422:2: ( ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_notReplayable_9_0= 'notReplayable' ) )? ) )
            // InternalAceGen.g:2423:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_notReplayable_9_0= 'notReplayable' ) )? )
            {
            // InternalAceGen.g:2423:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_notReplayable_9_0= 'notReplayable' ) )? )
            // InternalAceGen.g:2424:3: ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_notReplayable_9_0= 'notReplayable' ) )?
            {
            // InternalAceGen.g:2424:3: ( (lv_unique_0_0= 'Unique' ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==59) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalAceGen.g:2425:4: (lv_unique_0_0= 'Unique' )
                    {
                    // InternalAceGen.g:2425:4: (lv_unique_0_0= 'Unique' )
                    // InternalAceGen.g:2426:5: lv_unique_0_0= 'Unique'
                    {
                    lv_unique_0_0=(Token)match(input,59,FOLLOW_67); 

                    					newLeafNode(lv_unique_0_0, grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "unique", true, "Unique");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2438:3: ( (lv_primaryKey_1_0= 'PrimaryKey' ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==60) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalAceGen.g:2439:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    {
                    // InternalAceGen.g:2439:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    // InternalAceGen.g:2440:5: lv_primaryKey_1_0= 'PrimaryKey'
                    {
                    lv_primaryKey_1_0=(Token)match(input,60,FOLLOW_68); 

                    					newLeafNode(lv_primaryKey_1_0, grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "primaryKey", true, "PrimaryKey");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2452:3: ( (lv_notNull_2_0= 'NotNull' ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==61) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalAceGen.g:2453:4: (lv_notNull_2_0= 'NotNull' )
                    {
                    // InternalAceGen.g:2453:4: (lv_notNull_2_0= 'NotNull' )
                    // InternalAceGen.g:2454:5: lv_notNull_2_0= 'NotNull'
                    {
                    lv_notNull_2_0=(Token)match(input,61,FOLLOW_69); 

                    					newLeafNode(lv_notNull_2_0, grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "notNull", true, "NotNull");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2466:3: ( (lv_list_3_0= 'List' ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==62) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalAceGen.g:2467:4: (lv_list_3_0= 'List' )
                    {
                    // InternalAceGen.g:2467:4: (lv_list_3_0= 'List' )
                    // InternalAceGen.g:2468:5: lv_list_3_0= 'List'
                    {
                    lv_list_3_0=(Token)match(input,62,FOLLOW_70); 

                    					newLeafNode(lv_list_3_0, grammarAccess.getAttributeAccess().getListListKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "list", true, "List");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2480:3: ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=70 && LA81_0<=75)) ) {
                alt81=1;
            }
            else if ( (LA81_0==RULE_ID) ) {
                alt81=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // InternalAceGen.g:2481:4: ( (lv_type_4_0= ruleType ) )
                    {
                    // InternalAceGen.g:2481:4: ( (lv_type_4_0= ruleType ) )
                    // InternalAceGen.g:2482:5: (lv_type_4_0= ruleType )
                    {
                    // InternalAceGen.g:2482:5: (lv_type_4_0= ruleType )
                    // InternalAceGen.g:2483:6: lv_type_4_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getAttributeAccess().getTypeTypeParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_type_4_0=ruleType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAttributeRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_4_0,
                    							"de.acegen.AceGen.Type");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:2501:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalAceGen.g:2501:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:2502:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:2502:5: ( ruleQualifiedName )
                    // InternalAceGen.g:2503:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getModelModelCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:2518:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalAceGen.g:2519:4: (lv_name_6_0= RULE_ID )
            {
            // InternalAceGen.g:2519:4: (lv_name_6_0= RULE_ID )
            // InternalAceGen.g:2520:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_71); 

            					newLeafNode(lv_name_6_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_6_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:2536:3: (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==63) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalAceGen.g:2537:4: otherlv_7= 'references' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,63,FOLLOW_7); 

                    				newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getReferencesKeyword_6_0());
                    			
                    // InternalAceGen.g:2541:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:2542:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:2542:5: ( ruleQualifiedName )
                    // InternalAceGen.g:2543:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_72);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:2558:3: ( (lv_notReplayable_9_0= 'notReplayable' ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==64) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalAceGen.g:2559:4: (lv_notReplayable_9_0= 'notReplayable' )
                    {
                    // InternalAceGen.g:2559:4: (lv_notReplayable_9_0= 'notReplayable' )
                    // InternalAceGen.g:2560:5: lv_notReplayable_9_0= 'notReplayable'
                    {
                    lv_notReplayable_9_0=(Token)match(input,64,FOLLOW_2); 

                    					newLeafNode(lv_notReplayable_9_0, grammarAccess.getAttributeAccess().getNotReplayableNotReplayableKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "notReplayable", true, "notReplayable");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalAceGen.g:2576:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalAceGen.g:2576:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalAceGen.g:2577:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalAceGen.g:2583:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalAceGen.g:2589:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalAceGen.g:2590:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalAceGen.g:2590:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalAceGen.g:2591:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_73); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalAceGen.g:2598:3: (kw= '.' this_ID_2= RULE_ID )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==65) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalAceGen.g:2599:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,65,FOLLOW_7); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_73); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleWriteFunctionType"
    // InternalAceGen.g:2616:1: entryRuleWriteFunctionType returns [String current=null] : iv_ruleWriteFunctionType= ruleWriteFunctionType EOF ;
    public final String entryRuleWriteFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWriteFunctionType = null;


        try {
            // InternalAceGen.g:2616:57: (iv_ruleWriteFunctionType= ruleWriteFunctionType EOF )
            // InternalAceGen.g:2617:2: iv_ruleWriteFunctionType= ruleWriteFunctionType EOF
            {
             newCompositeNode(grammarAccess.getWriteFunctionTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWriteFunctionType=ruleWriteFunctionType();

            state._fsp--;

             current =iv_ruleWriteFunctionType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWriteFunctionType"


    // $ANTLR start "ruleWriteFunctionType"
    // InternalAceGen.g:2623:1: ruleWriteFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) ;
    public final AntlrDatatypeRuleToken ruleWriteFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:2629:2: ( (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) )
            // InternalAceGen.g:2630:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            {
            // InternalAceGen.g:2630:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            int alt85=3;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt85=1;
                }
                break;
            case 67:
                {
                alt85=2;
                }
                break;
            case 68:
                {
                alt85=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalAceGen.g:2631:3: kw= 'POST'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:2637:3: kw= 'PUT'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:2643:3: kw= 'DELETE'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getDELETEKeyword_2());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWriteFunctionType"


    // $ANTLR start "entryRuleReadFunctionType"
    // InternalAceGen.g:2652:1: entryRuleReadFunctionType returns [String current=null] : iv_ruleReadFunctionType= ruleReadFunctionType EOF ;
    public final String entryRuleReadFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReadFunctionType = null;


        try {
            // InternalAceGen.g:2652:56: (iv_ruleReadFunctionType= ruleReadFunctionType EOF )
            // InternalAceGen.g:2653:2: iv_ruleReadFunctionType= ruleReadFunctionType EOF
            {
             newCompositeNode(grammarAccess.getReadFunctionTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReadFunctionType=ruleReadFunctionType();

            state._fsp--;

             current =iv_ruleReadFunctionType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReadFunctionType"


    // $ANTLR start "ruleReadFunctionType"
    // InternalAceGen.g:2659:1: ruleReadFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'GET' ;
    public final AntlrDatatypeRuleToken ruleReadFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:2665:2: (kw= 'GET' )
            // InternalAceGen.g:2666:2: kw= 'GET'
            {
            kw=(Token)match(input,69,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getReadFunctionTypeAccess().getGETKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReadFunctionType"


    // $ANTLR start "entryRuleType"
    // InternalAceGen.g:2674:1: entryRuleType returns [String current=null] : iv_ruleType= ruleType EOF ;
    public final String entryRuleType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType = null;


        try {
            // InternalAceGen.g:2674:44: (iv_ruleType= ruleType EOF )
            // InternalAceGen.g:2675:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalAceGen.g:2681:1: ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' ) ;
    public final AntlrDatatypeRuleToken ruleType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:2687:2: ( (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' ) )
            // InternalAceGen.g:2688:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' )
            {
            // InternalAceGen.g:2688:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' )
            int alt86=6;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt86=1;
                }
                break;
            case 71:
                {
                alt86=2;
                }
                break;
            case 72:
                {
                alt86=3;
                }
                break;
            case 73:
                {
                alt86=4;
                }
                break;
            case 74:
                {
                alt86=5;
                }
                break;
            case 75:
                {
                alt86=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // InternalAceGen.g:2689:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getIntegerKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:2695:3: kw= 'String'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getStringKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:2701:3: kw= 'Float'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getFloatKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAceGen.g:2707:3: kw= 'Boolean'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getBooleanKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalAceGen.g:2713:3: kw= 'DateTime'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getDateTimeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalAceGen.g:2719:3: kw= 'Long'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getLongKeyword_5());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleJsonDateTime"
    // InternalAceGen.g:2728:1: entryRuleJsonDateTime returns [EObject current=null] : iv_ruleJsonDateTime= ruleJsonDateTime EOF ;
    public final EObject entryRuleJsonDateTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonDateTime = null;


        try {
            // InternalAceGen.g:2728:53: (iv_ruleJsonDateTime= ruleJsonDateTime EOF )
            // InternalAceGen.g:2729:2: iv_ruleJsonDateTime= ruleJsonDateTime EOF
            {
             newCompositeNode(grammarAccess.getJsonDateTimeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonDateTime=ruleJsonDateTime();

            state._fsp--;

             current =iv_ruleJsonDateTime; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsonDateTime"


    // $ANTLR start "ruleJsonDateTime"
    // InternalAceGen.g:2735:1: ruleJsonDateTime returns [EObject current=null] : ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleJsonDateTime() throws RecognitionException {
        EObject current = null;

        Token lv_dateTime_0_0=null;
        Token lv_pattern_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:2741:2: ( ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) ) )
            // InternalAceGen.g:2742:2: ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) )
            {
            // InternalAceGen.g:2742:2: ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) )
            // InternalAceGen.g:2743:3: ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) )
            {
            // InternalAceGen.g:2743:3: ( (lv_dateTime_0_0= RULE_STRING ) )
            // InternalAceGen.g:2744:4: (lv_dateTime_0_0= RULE_STRING )
            {
            // InternalAceGen.g:2744:4: (lv_dateTime_0_0= RULE_STRING )
            // InternalAceGen.g:2745:5: lv_dateTime_0_0= RULE_STRING
            {
            lv_dateTime_0_0=(Token)match(input,RULE_STRING,FOLLOW_35); 

            					newLeafNode(lv_dateTime_0_0, grammarAccess.getJsonDateTimeAccess().getDateTimeSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonDateTimeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"dateTime",
            						lv_dateTime_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalAceGen.g:2761:3: ( (lv_pattern_1_0= RULE_STRING ) )
            // InternalAceGen.g:2762:4: (lv_pattern_1_0= RULE_STRING )
            {
            // InternalAceGen.g:2762:4: (lv_pattern_1_0= RULE_STRING )
            // InternalAceGen.g:2763:5: lv_pattern_1_0= RULE_STRING
            {
            lv_pattern_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_pattern_1_0, grammarAccess.getJsonDateTimeAccess().getPatternSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonDateTimeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"pattern",
            						lv_pattern_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsonDateTime"


    // $ANTLR start "entryRuleJsonObject"
    // InternalAceGen.g:2783:1: entryRuleJsonObject returns [EObject current=null] : iv_ruleJsonObject= ruleJsonObject EOF ;
    public final EObject entryRuleJsonObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObject = null;


        try {
            // InternalAceGen.g:2783:51: (iv_ruleJsonObject= ruleJsonObject EOF )
            // InternalAceGen.g:2784:2: iv_ruleJsonObject= ruleJsonObject EOF
            {
             newCompositeNode(grammarAccess.getJsonObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonObject=ruleJsonObject();

            state._fsp--;

             current =iv_ruleJsonObject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsonObject"


    // $ANTLR start "ruleJsonObject"
    // InternalAceGen.g:2790:1: ruleJsonObject returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleJsonObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_members_2_0 = null;

        EObject lv_members_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2796:2: ( ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' ) )
            // InternalAceGen.g:2797:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' )
            {
            // InternalAceGen.g:2797:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' )
            // InternalAceGen.g:2798:3: () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}'
            {
            // InternalAceGen.g:2798:3: ()
            // InternalAceGen.g:2799:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonObjectAccess().getJsonObjectAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,34,FOLLOW_74); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonObjectAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:2809:3: ( (lv_members_2_0= ruleJsonMember ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_ID) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalAceGen.g:2810:4: (lv_members_2_0= ruleJsonMember )
                    {
                    // InternalAceGen.g:2810:4: (lv_members_2_0= ruleJsonMember )
                    // InternalAceGen.g:2811:5: lv_members_2_0= ruleJsonMember
                    {

                    					newCompositeNode(grammarAccess.getJsonObjectAccess().getMembersJsonMemberParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_75);
                    lv_members_2_0=ruleJsonMember();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJsonObjectRule());
                    					}
                    					add(
                    						current,
                    						"members",
                    						lv_members_2_0,
                    						"de.acegen.AceGen.JsonMember");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2828:3: (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==17) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalAceGen.g:2829:4: otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) )
            	    {
            	    otherlv_3=(Token)match(input,17,FOLLOW_7); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonObjectAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:2833:4: ( (lv_members_4_0= ruleJsonMember ) )
            	    // InternalAceGen.g:2834:5: (lv_members_4_0= ruleJsonMember )
            	    {
            	    // InternalAceGen.g:2834:5: (lv_members_4_0= ruleJsonMember )
            	    // InternalAceGen.g:2835:6: lv_members_4_0= ruleJsonMember
            	    {

            	    						newCompositeNode(grammarAccess.getJsonObjectAccess().getMembersJsonMemberParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_75);
            	    lv_members_4_0=ruleJsonMember();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJsonObjectRule());
            	    						}
            	    						add(
            	    							current,
            	    							"members",
            	    							lv_members_4_0,
            	    							"de.acegen.AceGen.JsonMember");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);

            otherlv_5=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getJsonObjectAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsonObject"


    // $ANTLR start "entryRuleJsonMember"
    // InternalAceGen.g:2861:1: entryRuleJsonMember returns [EObject current=null] : iv_ruleJsonMember= ruleJsonMember EOF ;
    public final EObject entryRuleJsonMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonMember = null;


        try {
            // InternalAceGen.g:2861:51: (iv_ruleJsonMember= ruleJsonMember EOF )
            // InternalAceGen.g:2862:2: iv_ruleJsonMember= ruleJsonMember EOF
            {
             newCompositeNode(grammarAccess.getJsonMemberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonMember=ruleJsonMember();

            state._fsp--;

             current =iv_ruleJsonMember; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsonMember"


    // $ANTLR start "ruleJsonMember"
    // InternalAceGen.g:2868:1: ruleJsonMember returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) ) ;
    public final EObject ruleJsonMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2874:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) ) )
            // InternalAceGen.g:2875:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) )
            {
            // InternalAceGen.g:2875:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) )
            // InternalAceGen.g:2876:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) )
            {
            // InternalAceGen.g:2876:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2877:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2877:4: ( ruleQualifiedName )
            // InternalAceGen.g:2878:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonMemberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJsonMemberAccess().getAttributeAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_23);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,33,FOLLOW_76); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonMemberAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:2896:3: ( (lv_value_2_0= ruleJsonValue ) )
            // InternalAceGen.g:2897:4: (lv_value_2_0= ruleJsonValue )
            {
            // InternalAceGen.g:2897:4: (lv_value_2_0= ruleJsonValue )
            // InternalAceGen.g:2898:5: lv_value_2_0= ruleJsonValue
            {

            					newCompositeNode(grammarAccess.getJsonMemberAccess().getValueJsonValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleJsonValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJsonMemberRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"de.acegen.AceGen.JsonValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsonMember"


    // $ANTLR start "entryRuleJsonValue"
    // InternalAceGen.g:2919:1: entryRuleJsonValue returns [EObject current=null] : iv_ruleJsonValue= ruleJsonValue EOF ;
    public final EObject entryRuleJsonValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonValue = null;


        try {
            // InternalAceGen.g:2919:50: (iv_ruleJsonValue= ruleJsonValue EOF )
            // InternalAceGen.g:2920:2: iv_ruleJsonValue= ruleJsonValue EOF
            {
             newCompositeNode(grammarAccess.getJsonValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonValue=ruleJsonValue();

            state._fsp--;

             current =iv_ruleJsonValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsonValue"


    // $ANTLR start "ruleJsonValue"
    // InternalAceGen.g:2926:1: ruleJsonValue returns [EObject current=null] : (this_JsonObject_0= ruleJsonObject | ( (lv_string_1_0= RULE_STRING ) ) | this_JsonArray_2= ruleJsonArray | ( (lv_boolean_3_0= ruleJsonBoolean ) ) | ( (lv_null_4_0= ruleJsonNull ) ) | ( (lv_long_5_0= RULE_INT ) ) | this_JsonDateTime_6= ruleJsonDateTime ) ;
    public final EObject ruleJsonValue() throws RecognitionException {
        EObject current = null;

        Token lv_string_1_0=null;
        Token lv_long_5_0=null;
        EObject this_JsonObject_0 = null;

        EObject this_JsonArray_2 = null;

        AntlrDatatypeRuleToken lv_boolean_3_0 = null;

        AntlrDatatypeRuleToken lv_null_4_0 = null;

        EObject this_JsonDateTime_6 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2932:2: ( (this_JsonObject_0= ruleJsonObject | ( (lv_string_1_0= RULE_STRING ) ) | this_JsonArray_2= ruleJsonArray | ( (lv_boolean_3_0= ruleJsonBoolean ) ) | ( (lv_null_4_0= ruleJsonNull ) ) | ( (lv_long_5_0= RULE_INT ) ) | this_JsonDateTime_6= ruleJsonDateTime ) )
            // InternalAceGen.g:2933:2: (this_JsonObject_0= ruleJsonObject | ( (lv_string_1_0= RULE_STRING ) ) | this_JsonArray_2= ruleJsonArray | ( (lv_boolean_3_0= ruleJsonBoolean ) ) | ( (lv_null_4_0= ruleJsonNull ) ) | ( (lv_long_5_0= RULE_INT ) ) | this_JsonDateTime_6= ruleJsonDateTime )
            {
            // InternalAceGen.g:2933:2: (this_JsonObject_0= ruleJsonObject | ( (lv_string_1_0= RULE_STRING ) ) | this_JsonArray_2= ruleJsonArray | ( (lv_boolean_3_0= ruleJsonBoolean ) ) | ( (lv_null_4_0= ruleJsonNull ) ) | ( (lv_long_5_0= RULE_INT ) ) | this_JsonDateTime_6= ruleJsonDateTime )
            int alt89=7;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt89=1;
                }
                break;
            case RULE_STRING:
                {
                int LA89_2 = input.LA(2);

                if ( (LA89_2==EOF||LA89_2==17||LA89_2==35||LA89_2==77) ) {
                    alt89=2;
                }
                else if ( (LA89_2==RULE_STRING) ) {
                    alt89=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 2, input);

                    throw nvae;
                }
                }
                break;
            case 76:
                {
                alt89=3;
                }
                break;
            case 78:
            case 79:
                {
                alt89=4;
                }
                break;
            case 80:
                {
                alt89=5;
                }
                break;
            case RULE_INT:
                {
                alt89=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalAceGen.g:2934:3: this_JsonObject_0= ruleJsonObject
                    {

                    			newCompositeNode(grammarAccess.getJsonValueAccess().getJsonObjectParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_JsonObject_0=ruleJsonObject();

                    state._fsp--;


                    			current = this_JsonObject_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:2943:3: ( (lv_string_1_0= RULE_STRING ) )
                    {
                    // InternalAceGen.g:2943:3: ( (lv_string_1_0= RULE_STRING ) )
                    // InternalAceGen.g:2944:4: (lv_string_1_0= RULE_STRING )
                    {
                    // InternalAceGen.g:2944:4: (lv_string_1_0= RULE_STRING )
                    // InternalAceGen.g:2945:5: lv_string_1_0= RULE_STRING
                    {
                    lv_string_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_string_1_0, grammarAccess.getJsonValueAccess().getStringSTRINGTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getJsonValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"string",
                    						lv_string_1_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:2962:3: this_JsonArray_2= ruleJsonArray
                    {

                    			newCompositeNode(grammarAccess.getJsonValueAccess().getJsonArrayParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_JsonArray_2=ruleJsonArray();

                    state._fsp--;


                    			current = this_JsonArray_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalAceGen.g:2971:3: ( (lv_boolean_3_0= ruleJsonBoolean ) )
                    {
                    // InternalAceGen.g:2971:3: ( (lv_boolean_3_0= ruleJsonBoolean ) )
                    // InternalAceGen.g:2972:4: (lv_boolean_3_0= ruleJsonBoolean )
                    {
                    // InternalAceGen.g:2972:4: (lv_boolean_3_0= ruleJsonBoolean )
                    // InternalAceGen.g:2973:5: lv_boolean_3_0= ruleJsonBoolean
                    {

                    					newCompositeNode(grammarAccess.getJsonValueAccess().getBooleanJsonBooleanParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_boolean_3_0=ruleJsonBoolean();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJsonValueRule());
                    					}
                    					set(
                    						current,
                    						"boolean",
                    						lv_boolean_3_0,
                    						"de.acegen.AceGen.JsonBoolean");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalAceGen.g:2991:3: ( (lv_null_4_0= ruleJsonNull ) )
                    {
                    // InternalAceGen.g:2991:3: ( (lv_null_4_0= ruleJsonNull ) )
                    // InternalAceGen.g:2992:4: (lv_null_4_0= ruleJsonNull )
                    {
                    // InternalAceGen.g:2992:4: (lv_null_4_0= ruleJsonNull )
                    // InternalAceGen.g:2993:5: lv_null_4_0= ruleJsonNull
                    {

                    					newCompositeNode(grammarAccess.getJsonValueAccess().getNullJsonNullParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_null_4_0=ruleJsonNull();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJsonValueRule());
                    					}
                    					set(
                    						current,
                    						"null",
                    						lv_null_4_0,
                    						"de.acegen.AceGen.JsonNull");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalAceGen.g:3011:3: ( (lv_long_5_0= RULE_INT ) )
                    {
                    // InternalAceGen.g:3011:3: ( (lv_long_5_0= RULE_INT ) )
                    // InternalAceGen.g:3012:4: (lv_long_5_0= RULE_INT )
                    {
                    // InternalAceGen.g:3012:4: (lv_long_5_0= RULE_INT )
                    // InternalAceGen.g:3013:5: lv_long_5_0= RULE_INT
                    {
                    lv_long_5_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    					newLeafNode(lv_long_5_0, grammarAccess.getJsonValueAccess().getLongINTTerminalRuleCall_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getJsonValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"long",
                    						lv_long_5_0,
                    						"org.eclipse.xtext.common.Terminals.INT");
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalAceGen.g:3030:3: this_JsonDateTime_6= ruleJsonDateTime
                    {

                    			newCompositeNode(grammarAccess.getJsonValueAccess().getJsonDateTimeParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_JsonDateTime_6=ruleJsonDateTime();

                    state._fsp--;


                    			current = this_JsonDateTime_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsonValue"


    // $ANTLR start "entryRuleJsonArray"
    // InternalAceGen.g:3042:1: entryRuleJsonArray returns [EObject current=null] : iv_ruleJsonArray= ruleJsonArray EOF ;
    public final EObject entryRuleJsonArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonArray = null;


        try {
            // InternalAceGen.g:3042:50: (iv_ruleJsonArray= ruleJsonArray EOF )
            // InternalAceGen.g:3043:2: iv_ruleJsonArray= ruleJsonArray EOF
            {
             newCompositeNode(grammarAccess.getJsonArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonArray=ruleJsonArray();

            state._fsp--;

             current =iv_ruleJsonArray; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsonArray"


    // $ANTLR start "ruleJsonArray"
    // InternalAceGen.g:3049:1: ruleJsonArray returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleJsonArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3055:2: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' ) )
            // InternalAceGen.g:3056:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' )
            {
            // InternalAceGen.g:3056:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' )
            // InternalAceGen.g:3057:3: () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']'
            {
            // InternalAceGen.g:3057:3: ()
            // InternalAceGen.g:3058:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonArrayAccess().getJsonArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,76,FOLLOW_77); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonArrayAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalAceGen.g:3068:3: ( (lv_values_2_0= ruleJsonValue ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( ((LA90_0>=RULE_STRING && LA90_0<=RULE_INT)||LA90_0==34||LA90_0==76||(LA90_0>=78 && LA90_0<=80)) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalAceGen.g:3069:4: (lv_values_2_0= ruleJsonValue )
                    {
                    // InternalAceGen.g:3069:4: (lv_values_2_0= ruleJsonValue )
                    // InternalAceGen.g:3070:5: lv_values_2_0= ruleJsonValue
                    {

                    					newCompositeNode(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_78);
                    lv_values_2_0=ruleJsonValue();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJsonArrayRule());
                    					}
                    					add(
                    						current,
                    						"values",
                    						lv_values_2_0,
                    						"de.acegen.AceGen.JsonValue");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:3087:3: (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==17) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalAceGen.g:3088:4: otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) )
            	    {
            	    otherlv_3=(Token)match(input,17,FOLLOW_76); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonArrayAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:3092:4: ( (lv_values_4_0= ruleJsonValue ) )
            	    // InternalAceGen.g:3093:5: (lv_values_4_0= ruleJsonValue )
            	    {
            	    // InternalAceGen.g:3093:5: (lv_values_4_0= ruleJsonValue )
            	    // InternalAceGen.g:3094:6: lv_values_4_0= ruleJsonValue
            	    {

            	    						newCompositeNode(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_78);
            	    lv_values_4_0=ruleJsonValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJsonArrayRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_4_0,
            	    							"de.acegen.AceGen.JsonValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);

            otherlv_5=(Token)match(input,77,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getJsonArrayAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsonArray"


    // $ANTLR start "entryRuleJsonBoolean"
    // InternalAceGen.g:3120:1: entryRuleJsonBoolean returns [String current=null] : iv_ruleJsonBoolean= ruleJsonBoolean EOF ;
    public final String entryRuleJsonBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleJsonBoolean = null;


        try {
            // InternalAceGen.g:3120:51: (iv_ruleJsonBoolean= ruleJsonBoolean EOF )
            // InternalAceGen.g:3121:2: iv_ruleJsonBoolean= ruleJsonBoolean EOF
            {
             newCompositeNode(grammarAccess.getJsonBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonBoolean=ruleJsonBoolean();

            state._fsp--;

             current =iv_ruleJsonBoolean.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsonBoolean"


    // $ANTLR start "ruleJsonBoolean"
    // InternalAceGen.g:3127:1: ruleJsonBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleJsonBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:3133:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalAceGen.g:3134:2: (kw= 'true' | kw= 'false' )
            {
            // InternalAceGen.g:3134:2: (kw= 'true' | kw= 'false' )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==78) ) {
                alt92=1;
            }
            else if ( (LA92_0==79) ) {
                alt92=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // InternalAceGen.g:3135:3: kw= 'true'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJsonBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:3141:3: kw= 'false'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJsonBooleanAccess().getFalseKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsonBoolean"


    // $ANTLR start "entryRuleJsonNull"
    // InternalAceGen.g:3150:1: entryRuleJsonNull returns [String current=null] : iv_ruleJsonNull= ruleJsonNull EOF ;
    public final String entryRuleJsonNull() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleJsonNull = null;


        try {
            // InternalAceGen.g:3150:48: (iv_ruleJsonNull= ruleJsonNull EOF )
            // InternalAceGen.g:3151:2: iv_ruleJsonNull= ruleJsonNull EOF
            {
             newCompositeNode(grammarAccess.getJsonNullRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonNull=ruleJsonNull();

            state._fsp--;

             current =iv_ruleJsonNull.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJsonNull"


    // $ANTLR start "ruleJsonNull"
    // InternalAceGen.g:3157:1: ruleJsonNull returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'null' ;
    public final AntlrDatatypeRuleToken ruleJsonNull() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:3163:2: (kw= 'null' )
            // InternalAceGen.g:3164:2: kw= 'null'
            {
            kw=(Token)match(input,80,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getJsonNullAccess().getNullKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJsonNull"

    // Delegated rules


    protected DFA35 dfa35 = new DFA35(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\2\4\1\20\1\4\1\22\1\4\1\102\1\22\2\uffff";
    static final String dfa_3s = "\1\52\1\4\1\20\1\4\1\101\1\4\1\105\1\101\2\uffff";
    static final String dfa_4s = "\10\uffff\1\2\1\1";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\45\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\56\uffff\1\5",
            "\1\7",
            "\3\11\1\10",
            "\1\6\56\uffff\1\5",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "999:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000001000000012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000C012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000390002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001400002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000001E800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000002E0000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000002C0000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000280000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x000003E000002002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000003C000002002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000038000002002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000078000000012L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000030000000012L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0002020000000012L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001CL});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000F80000200002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000F00000200002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000E00000200012L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000C00000200012L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000800000200012L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000200012L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000F80000000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000F00000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000E00000000012L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000C00000000012L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000800000000012L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x7800000800000010L,0x0000000000000FC0L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0004000400000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000400020002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0018000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0010000000000010L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0080000000000042L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0700000400000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0300000400000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0200000400000002L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x7000000000000010L,0x0000000000000FC0L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x6000000000000010L,0x0000000000000FC0L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x4000000000000010L,0x0000000000000FC0L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000FC0L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000800020010L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000800020000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000400000060L,0x000000000001D000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000400020060L,0x000000000001F000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000020000L,0x0000000000002000L});

}