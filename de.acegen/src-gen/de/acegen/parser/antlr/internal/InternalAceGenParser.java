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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'HttpClient'", "'HttpServer'", "'ACE'", "'appState'", "'{'", "'}'", "'scenarios'", "'async'", "'('", "','", "')'", "'call'", "'loadingFlag'", "'on'", "'triggers'", "'set'", "'merge'", "'reset'", "'NotNull'", "'List'", "'serverModel'", "'location.hash'", "'storage'", "'GIVEN'", "'WHEN'", "'THEN'", "'with'", "'response'", "':'", "'expectedServerCall'", "'expectedState'", "'triggeredActions'", "'shouldBe'", "'['", "']'", "'Java'", "'Dropwizard'", "'JDBI3'", "'Liquibase'", "'Authorization'", "'import'", "'views'", "'models'", "'proxy'", "'<'", "'>'", "'authorize'", "'pathParams'", "'queryParams'", "'payload'", "'persistent'", "'extends'", "'x'", "'excludeGIVEN'", "'persistence'", "'verifications'", "'selectByPrimaryKey'", "'selectBy'", "'filterAndCountBy'", "'notNull'", "'null'", "'uuid'", "'systemTime'", "'authorization'", "'Unique'", "'PrimaryKey'", "'references'", "'notReplayable'", "'.'", "'POST'", "'PUT'", "'DELETE'", "'GET'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'Long'", "'true'", "'false'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
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
    public static final int T__91=91;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

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

                    if ( (LA2_0==46) ) {
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
    // InternalAceGen.g:150:1: ruleHttpClient returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? ( ( (lv_appStatePresent_3_0= 'appState' ) ) (otherlv_4= '{' ( (lv_appState_5_0= ruleClientAttribute ) )* otherlv_6= '}' )? )? (otherlv_7= 'scenarios' ( (lv_scenarios_8_0= ruleClientScenario ) )* )? ) ;
    public final EObject ruleHttpClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_appStatePresent_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_aceOperations_2_0 = null;

        EObject lv_appState_5_0 = null;

        EObject lv_scenarios_8_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:156:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? ( ( (lv_appStatePresent_3_0= 'appState' ) ) (otherlv_4= '{' ( (lv_appState_5_0= ruleClientAttribute ) )* otherlv_6= '}' )? )? (otherlv_7= 'scenarios' ( (lv_scenarios_8_0= ruleClientScenario ) )* )? ) )
            // InternalAceGen.g:157:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? ( ( (lv_appStatePresent_3_0= 'appState' ) ) (otherlv_4= '{' ( (lv_appState_5_0= ruleClientAttribute ) )* otherlv_6= '}' )? )? (otherlv_7= 'scenarios' ( (lv_scenarios_8_0= ruleClientScenario ) )* )? )
            {
            // InternalAceGen.g:157:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? ( ( (lv_appStatePresent_3_0= 'appState' ) ) (otherlv_4= '{' ( (lv_appState_5_0= ruleClientAttribute ) )* otherlv_6= '}' )? )? (otherlv_7= 'scenarios' ( (lv_scenarios_8_0= ruleClientScenario ) )* )? )
            // InternalAceGen.g:158:3: ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? ( ( (lv_appStatePresent_3_0= 'appState' ) ) (otherlv_4= '{' ( (lv_appState_5_0= ruleClientAttribute ) )* otherlv_6= '}' )? )? (otherlv_7= 'scenarios' ( (lv_scenarios_8_0= ruleClientScenario ) )* )?
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

                        if ( (LA4_0==RULE_ID||LA4_0==18) ) {
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

            // InternalAceGen.g:202:3: ( ( (lv_appStatePresent_3_0= 'appState' ) ) (otherlv_4= '{' ( (lv_appState_5_0= ruleClientAttribute ) )* otherlv_6= '}' )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==14) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalAceGen.g:203:4: ( (lv_appStatePresent_3_0= 'appState' ) ) (otherlv_4= '{' ( (lv_appState_5_0= ruleClientAttribute ) )* otherlv_6= '}' )?
                    {
                    // InternalAceGen.g:203:4: ( (lv_appStatePresent_3_0= 'appState' ) )
                    // InternalAceGen.g:204:5: (lv_appStatePresent_3_0= 'appState' )
                    {
                    // InternalAceGen.g:204:5: (lv_appStatePresent_3_0= 'appState' )
                    // InternalAceGen.g:205:6: lv_appStatePresent_3_0= 'appState'
                    {
                    lv_appStatePresent_3_0=(Token)match(input,14,FOLLOW_7); 

                    						newLeafNode(lv_appStatePresent_3_0, grammarAccess.getHttpClientAccess().getAppStatePresentAppStateKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpClientRule());
                    						}
                    						setWithLastConsumed(current, "appStatePresent", true, "appState");
                    					

                    }


                    }

                    // InternalAceGen.g:217:4: (otherlv_4= '{' ( (lv_appState_5_0= ruleClientAttribute ) )* otherlv_6= '}' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==15) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalAceGen.g:218:5: otherlv_4= '{' ( (lv_appState_5_0= ruleClientAttribute ) )* otherlv_6= '}'
                            {
                            otherlv_4=(Token)match(input,15,FOLLOW_8); 

                            					newLeafNode(otherlv_4, grammarAccess.getHttpClientAccess().getLeftCurlyBracketKeyword_2_1_0());
                            				
                            // InternalAceGen.g:222:5: ( (lv_appState_5_0= ruleClientAttribute ) )*
                            loop6:
                            do {
                                int alt6=2;
                                int LA6_0 = input.LA(1);

                                if ( (LA6_0==RULE_ID||(LA6_0>=29 && LA6_0<=30)||(LA6_0>=84 && LA6_0<=89)) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // InternalAceGen.g:223:6: (lv_appState_5_0= ruleClientAttribute )
                            	    {
                            	    // InternalAceGen.g:223:6: (lv_appState_5_0= ruleClientAttribute )
                            	    // InternalAceGen.g:224:7: lv_appState_5_0= ruleClientAttribute
                            	    {

                            	    							newCompositeNode(grammarAccess.getHttpClientAccess().getAppStateClientAttributeParserRuleCall_2_1_1_0());
                            	    						
                            	    pushFollow(FOLLOW_8);
                            	    lv_appState_5_0=ruleClientAttribute();

                            	    state._fsp--;


                            	    							if (current==null) {
                            	    								current = createModelElementForParent(grammarAccess.getHttpClientRule());
                            	    							}
                            	    							add(
                            	    								current,
                            	    								"appState",
                            	    								lv_appState_5_0,
                            	    								"de.acegen.AceGen.ClientAttribute");
                            	    							afterParserOrEnumRuleCall();
                            	    						

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop6;
                                }
                            } while (true);

                            otherlv_6=(Token)match(input,16,FOLLOW_9); 

                            					newLeafNode(otherlv_6, grammarAccess.getHttpClientAccess().getRightCurlyBracketKeyword_2_1_2());
                            				

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalAceGen.g:247:3: (otherlv_7= 'scenarios' ( (lv_scenarios_8_0= ruleClientScenario ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAceGen.g:248:4: otherlv_7= 'scenarios' ( (lv_scenarios_8_0= ruleClientScenario ) )*
                    {
                    otherlv_7=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getHttpClientAccess().getScenariosKeyword_3_0());
                    			
                    // InternalAceGen.g:252:4: ( (lv_scenarios_8_0= ruleClientScenario ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalAceGen.g:253:5: (lv_scenarios_8_0= ruleClientScenario )
                    	    {
                    	    // InternalAceGen.g:253:5: (lv_scenarios_8_0= ruleClientScenario )
                    	    // InternalAceGen.g:254:6: lv_scenarios_8_0= ruleClientScenario
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpClientAccess().getScenariosClientScenarioParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_3);
                    	    lv_scenarios_8_0=ruleClientScenario();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpClientRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"scenarios",
                    	    							lv_scenarios_8_0,
                    	    							"de.acegen.AceGen.ClientScenario");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
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
    // $ANTLR end "ruleHttpClient"


    // $ANTLR start "entryRuleHttpClientAce"
    // InternalAceGen.g:276:1: entryRuleHttpClientAce returns [EObject current=null] : iv_ruleHttpClientAce= ruleHttpClientAce EOF ;
    public final EObject entryRuleHttpClientAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientAce = null;


        try {
            // InternalAceGen.g:276:54: (iv_ruleHttpClientAce= ruleHttpClientAce EOF )
            // InternalAceGen.g:277:2: iv_ruleHttpClientAce= ruleHttpClientAce EOF
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
    // InternalAceGen.g:283:1: ruleHttpClientAce returns [EObject current=null] : ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )? (otherlv_7= 'appState' otherlv_8= '(' ( ( ruleQualifiedName ) ) (otherlv_10= ',' ( ( ruleQualifiedName ) ) )* otherlv_12= ')' )? (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )* ) ;
    public final EObject ruleHttpClientAce() throws RecognitionException {
        EObject current = null;

        Token lv_async_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_input_3_0 = null;

        EObject lv_input_5_0 = null;

        EObject lv_outcomes_17_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:289:2: ( ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )? (otherlv_7= 'appState' otherlv_8= '(' ( ( ruleQualifiedName ) ) (otherlv_10= ',' ( ( ruleQualifiedName ) ) )* otherlv_12= ')' )? (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )* ) )
            // InternalAceGen.g:290:2: ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )? (otherlv_7= 'appState' otherlv_8= '(' ( ( ruleQualifiedName ) ) (otherlv_10= ',' ( ( ruleQualifiedName ) ) )* otherlv_12= ')' )? (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )* )
            {
            // InternalAceGen.g:290:2: ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )? (otherlv_7= 'appState' otherlv_8= '(' ( ( ruleQualifiedName ) ) (otherlv_10= ',' ( ( ruleQualifiedName ) ) )* otherlv_12= ')' )? (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )* )
            // InternalAceGen.g:291:3: ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )? (otherlv_7= 'appState' otherlv_8= '(' ( ( ruleQualifiedName ) ) (otherlv_10= ',' ( ( ruleQualifiedName ) ) )* otherlv_12= ')' )? (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )*
            {
            // InternalAceGen.g:291:3: ( (lv_async_0_0= 'async' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAceGen.g:292:4: (lv_async_0_0= 'async' )
                    {
                    // InternalAceGen.g:292:4: (lv_async_0_0= 'async' )
                    // InternalAceGen.g:293:5: lv_async_0_0= 'async'
                    {
                    lv_async_0_0=(Token)match(input,18,FOLLOW_10); 

                    					newLeafNode(lv_async_0_0, grammarAccess.getHttpClientAceAccess().getAsyncAsyncKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpClientAceRule());
                    					}
                    					setWithLastConsumed(current, "async", true, "async");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:305:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:306:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:306:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:307:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

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

            // InternalAceGen.g:323:3: (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalAceGen.g:324:4: otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getHttpClientAceAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalAceGen.g:328:4: ( (lv_input_3_0= ruleInput ) )
                    // InternalAceGen.g:329:5: (lv_input_3_0= ruleInput )
                    {
                    // InternalAceGen.g:329:5: (lv_input_3_0= ruleInput )
                    // InternalAceGen.g:330:6: lv_input_3_0= ruleInput
                    {

                    						newCompositeNode(grammarAccess.getHttpClientAceAccess().getInputInputParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_input_3_0=ruleInput();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHttpClientAceRule());
                    						}
                    						add(
                    							current,
                    							"input",
                    							lv_input_3_0,
                    							"de.acegen.AceGen.Input");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:347:4: (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==20) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalAceGen.g:348:5: otherlv_4= ',' ( (lv_input_5_0= ruleInput ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_10); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getHttpClientAceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:352:5: ( (lv_input_5_0= ruleInput ) )
                    	    // InternalAceGen.g:353:6: (lv_input_5_0= ruleInput )
                    	    {
                    	    // InternalAceGen.g:353:6: (lv_input_5_0= ruleInput )
                    	    // InternalAceGen.g:354:7: lv_input_5_0= ruleInput
                    	    {

                    	    							newCompositeNode(grammarAccess.getHttpClientAceAccess().getInputInputParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_input_5_0=ruleInput();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getHttpClientAceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"input",
                    	    								lv_input_5_0,
                    	    								"de.acegen.AceGen.Input");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,21,FOLLOW_13); 

                    				newLeafNode(otherlv_6, grammarAccess.getHttpClientAceAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:377:3: (otherlv_7= 'appState' otherlv_8= '(' ( ( ruleQualifiedName ) ) (otherlv_10= ',' ( ( ruleQualifiedName ) ) )* otherlv_12= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==19) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // InternalAceGen.g:378:4: otherlv_7= 'appState' otherlv_8= '(' ( ( ruleQualifiedName ) ) (otherlv_10= ',' ( ( ruleQualifiedName ) ) )* otherlv_12= ')'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_14); 

                    				newLeafNode(otherlv_7, grammarAccess.getHttpClientAceAccess().getAppStateKeyword_3_0());
                    			
                    otherlv_8=(Token)match(input,19,FOLLOW_10); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpClientAceAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalAceGen.g:386:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:387:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:387:5: ( ruleQualifiedName )
                    // InternalAceGen.g:388:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpClientAceRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpClientAceAccess().getStateElementsClientAttributeCrossReference_3_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:402:4: (otherlv_10= ',' ( ( ruleQualifiedName ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==20) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalAceGen.g:403:5: otherlv_10= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_10=(Token)match(input,20,FOLLOW_10); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getHttpClientAceAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalAceGen.g:407:5: ( ( ruleQualifiedName ) )
                    	    // InternalAceGen.g:408:6: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:408:6: ( ruleQualifiedName )
                    	    // InternalAceGen.g:409:7: ruleQualifiedName
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getHttpClientAceRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getHttpClientAceAccess().getStateElementsClientAttributeCrossReference_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,21,FOLLOW_15); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpClientAceAccess().getRightParenthesisKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:429:3: (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==22) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAceGen.g:430:4: otherlv_13= 'call' ( ( ruleQualifiedName ) )
                    {
                    otherlv_13=(Token)match(input,22,FOLLOW_10); 

                    				newLeafNode(otherlv_13, grammarAccess.getHttpClientAceAccess().getCallKeyword_4_0());
                    			
                    // InternalAceGen.g:434:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:435:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:435:5: ( ruleQualifiedName )
                    // InternalAceGen.g:436:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpClientAceRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:451:3: (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==23) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAceGen.g:452:4: otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) )
                    {
                    otherlv_15=(Token)match(input,23,FOLLOW_10); 

                    				newLeafNode(otherlv_15, grammarAccess.getHttpClientAceAccess().getLoadingFlagKeyword_5_0());
                    			
                    // InternalAceGen.g:456:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:457:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:457:5: ( ruleQualifiedName )
                    // InternalAceGen.g:458:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpClientAceRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpClientAceAccess().getLoadingFlagClientAttributeCrossReference_5_1_0());
                    					
                    pushFollow(FOLLOW_17);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:473:3: ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==24) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalAceGen.g:474:4: (lv_outcomes_17_0= ruleHttpClientOutcome )
            	    {
            	    // InternalAceGen.g:474:4: (lv_outcomes_17_0= ruleHttpClientOutcome )
            	    // InternalAceGen.g:475:5: lv_outcomes_17_0= ruleHttpClientOutcome
            	    {

            	    					newCompositeNode(grammarAccess.getHttpClientAceAccess().getOutcomesHttpClientOutcomeParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_outcomes_17_0=ruleHttpClientOutcome();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHttpClientAceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"outcomes",
            	    						lv_outcomes_17_0,
            	    						"de.acegen.AceGen.HttpClientOutcome");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
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


    // $ANTLR start "entryRuleInput"
    // InternalAceGen.g:496:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalAceGen.g:496:46: (iv_ruleInput= ruleInput EOF )
            // InternalAceGen.g:497:2: iv_ruleInput= ruleInput EOF
            {
             newCompositeNode(grammarAccess.getInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInput=ruleInput();

            state._fsp--;

             current =iv_ruleInput; 
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
    // $ANTLR end "entryRuleInput"


    // $ANTLR start "ruleInput"
    // InternalAceGen.g:503:1: ruleInput returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleInput() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:509:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalAceGen.g:510:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalAceGen.g:510:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:511:3: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:511:3: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:512:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getInputAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getInputRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // $ANTLR end "ruleInput"


    // $ANTLR start "entryRuleHttpClientOutcome"
    // InternalAceGen.g:531:1: entryRuleHttpClientOutcome returns [EObject current=null] : iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF ;
    public final EObject entryRuleHttpClientOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientOutcome = null;


        try {
            // InternalAceGen.g:531:58: (iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF )
            // InternalAceGen.g:532:2: iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF
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
    // InternalAceGen.g:538:1: ruleHttpClientOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? ) ;
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
            // InternalAceGen.g:544:2: ( (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? ) )
            // InternalAceGen.g:545:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? )
            {
            // InternalAceGen.g:545:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? )
            // InternalAceGen.g:546:3: otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpClientOutcomeAccess().getOnKeyword_0());
            		
            // InternalAceGen.g:550:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:551:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:551:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:552:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

            // InternalAceGen.g:568:3: (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==19) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalAceGen.g:569:4: otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19); 

                    				newLeafNode(otherlv_2, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalAceGen.g:573:4: ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=26 && LA19_0<=28)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalAceGen.g:574:5: (lv_listeners_3_0= ruleHttpClientStateFunction )
                    	    {
                    	    // InternalAceGen.g:574:5: (lv_listeners_3_0= ruleHttpClientStateFunction )
                    	    // InternalAceGen.g:575:6: lv_listeners_3_0= ruleHttpClientStateFunction
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpClientOutcomeAccess().getListenersHttpClientStateFunctionParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
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
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,21,FOLLOW_20); 

                    				newLeafNode(otherlv_4, grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:597:3: (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==25) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalAceGen.g:598:4: otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,25,FOLLOW_14); 

                    				newLeafNode(otherlv_5, grammarAccess.getHttpClientOutcomeAccess().getTriggersKeyword_3_0());
                    			
                    otherlv_6=(Token)match(input,19,FOLLOW_21); 

                    				newLeafNode(otherlv_6, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalAceGen.g:606:4: ( ( ruleQualifiedName ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_ID) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalAceGen.g:607:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:607:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:608:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpClientOutcomeRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsHttpClientAceCrossReference_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_21);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,21,FOLLOW_2); 

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
    // InternalAceGen.g:631:1: entryRuleHttpClientStateFunction returns [EObject current=null] : iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF ;
    public final EObject entryRuleHttpClientStateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientStateFunction = null;


        try {
            // InternalAceGen.g:631:64: (iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF )
            // InternalAceGen.g:632:2: iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF
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
    // InternalAceGen.g:638:1: ruleHttpClientStateFunction returns [EObject current=null] : ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleHttpClientStateFunction() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_stateFunctionType_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:644:2: ( ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:645:2: ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:645:2: ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:646:3: ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:646:3: ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) )
            // InternalAceGen.g:647:4: (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType )
            {
            // InternalAceGen.g:647:4: (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType )
            // InternalAceGen.g:648:5: lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeHttpClientStateFunctionTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
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

            // InternalAceGen.g:665:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:666:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:666:4: ( ruleQualifiedName )
            // InternalAceGen.g:667:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpClientStateFunctionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpClientStateFunctionAccess().getStateElementClientAttributeCrossReference_1_0());
            				
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
    // InternalAceGen.g:685:1: entryRuleHttpClientStateFunctionType returns [String current=null] : iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF ;
    public final String entryRuleHttpClientStateFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHttpClientStateFunctionType = null;


        try {
            // InternalAceGen.g:685:67: (iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF )
            // InternalAceGen.g:686:2: iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF
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
    // InternalAceGen.g:692:1: ruleHttpClientStateFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'set' | kw= 'merge' | kw= 'reset' ) ;
    public final AntlrDatatypeRuleToken ruleHttpClientStateFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:698:2: ( (kw= 'set' | kw= 'merge' | kw= 'reset' ) )
            // InternalAceGen.g:699:2: (kw= 'set' | kw= 'merge' | kw= 'reset' )
            {
            // InternalAceGen.g:699:2: (kw= 'set' | kw= 'merge' | kw= 'reset' )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt23=1;
                }
                break;
            case 27:
                {
                alt23=2;
                }
                break;
            case 28:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalAceGen.g:700:3: kw= 'set'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:706:3: kw= 'merge'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:712:3: kw= 'reset'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getResetKeyword_2());
                    		

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


    // $ANTLR start "entryRuleClientAttribute"
    // InternalAceGen.g:721:1: entryRuleClientAttribute returns [EObject current=null] : iv_ruleClientAttribute= ruleClientAttribute EOF ;
    public final EObject entryRuleClientAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientAttribute = null;


        try {
            // InternalAceGen.g:721:56: (iv_ruleClientAttribute= ruleClientAttribute EOF )
            // InternalAceGen.g:722:2: iv_ruleClientAttribute= ruleClientAttribute EOF
            {
             newCompositeNode(grammarAccess.getClientAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClientAttribute=ruleClientAttribute();

            state._fsp--;

             current =iv_ruleClientAttribute; 
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
    // $ANTLR end "entryRuleClientAttribute"


    // $ANTLR start "ruleClientAttribute"
    // InternalAceGen.g:728:1: ruleClientAttribute returns [EObject current=null] : ( ( (lv_notNull_0_0= 'NotNull' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'serverModel' ( ( ruleQualifiedName ) ) )? ( (lv_hash_6_0= 'location.hash' ) )? ( (lv_storage_7_0= 'storage' ) )? (otherlv_8= '{' ( (lv_attributes_9_0= ruleClientAttribute ) )* otherlv_10= '}' )? ) ;
    public final EObject ruleClientAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_notNull_0_0=null;
        Token lv_list_1_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_hash_6_0=null;
        Token lv_storage_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_type_2_0 = null;

        EObject lv_attributes_9_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:734:2: ( ( ( (lv_notNull_0_0= 'NotNull' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'serverModel' ( ( ruleQualifiedName ) ) )? ( (lv_hash_6_0= 'location.hash' ) )? ( (lv_storage_7_0= 'storage' ) )? (otherlv_8= '{' ( (lv_attributes_9_0= ruleClientAttribute ) )* otherlv_10= '}' )? ) )
            // InternalAceGen.g:735:2: ( ( (lv_notNull_0_0= 'NotNull' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'serverModel' ( ( ruleQualifiedName ) ) )? ( (lv_hash_6_0= 'location.hash' ) )? ( (lv_storage_7_0= 'storage' ) )? (otherlv_8= '{' ( (lv_attributes_9_0= ruleClientAttribute ) )* otherlv_10= '}' )? )
            {
            // InternalAceGen.g:735:2: ( ( (lv_notNull_0_0= 'NotNull' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'serverModel' ( ( ruleQualifiedName ) ) )? ( (lv_hash_6_0= 'location.hash' ) )? ( (lv_storage_7_0= 'storage' ) )? (otherlv_8= '{' ( (lv_attributes_9_0= ruleClientAttribute ) )* otherlv_10= '}' )? )
            // InternalAceGen.g:736:3: ( (lv_notNull_0_0= 'NotNull' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'serverModel' ( ( ruleQualifiedName ) ) )? ( (lv_hash_6_0= 'location.hash' ) )? ( (lv_storage_7_0= 'storage' ) )? (otherlv_8= '{' ( (lv_attributes_9_0= ruleClientAttribute ) )* otherlv_10= '}' )?
            {
            // InternalAceGen.g:736:3: ( (lv_notNull_0_0= 'NotNull' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==29) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalAceGen.g:737:4: (lv_notNull_0_0= 'NotNull' )
                    {
                    // InternalAceGen.g:737:4: (lv_notNull_0_0= 'NotNull' )
                    // InternalAceGen.g:738:5: lv_notNull_0_0= 'NotNull'
                    {
                    lv_notNull_0_0=(Token)match(input,29,FOLLOW_22); 

                    					newLeafNode(lv_notNull_0_0, grammarAccess.getClientAttributeAccess().getNotNullNotNullKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "notNull", true, "NotNull");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:750:3: ( (lv_list_1_0= 'List' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==30) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalAceGen.g:751:4: (lv_list_1_0= 'List' )
                    {
                    // InternalAceGen.g:751:4: (lv_list_1_0= 'List' )
                    // InternalAceGen.g:752:5: lv_list_1_0= 'List'
                    {
                    lv_list_1_0=(Token)match(input,30,FOLLOW_23); 

                    					newLeafNode(lv_list_1_0, grammarAccess.getClientAttributeAccess().getListListKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "list", true, "List");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:764:3: ( (lv_type_2_0= ruleType ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=84 && LA26_0<=89)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalAceGen.g:765:4: (lv_type_2_0= ruleType )
                    {
                    // InternalAceGen.g:765:4: (lv_type_2_0= ruleType )
                    // InternalAceGen.g:766:5: lv_type_2_0= ruleType
                    {

                    					newCompositeNode(grammarAccess.getClientAttributeAccess().getTypeTypeParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_10);
                    lv_type_2_0=ruleType();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getClientAttributeRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_2_0,
                    						"de.acegen.AceGen.Type");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:783:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalAceGen.g:784:4: (lv_name_3_0= RULE_ID )
            {
            // InternalAceGen.g:784:4: (lv_name_3_0= RULE_ID )
            // InternalAceGen.g:785:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_3_0, grammarAccess.getClientAttributeAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClientAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:801:3: (otherlv_4= 'serverModel' ( ( ruleQualifiedName ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==31) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalAceGen.g:802:4: otherlv_4= 'serverModel' ( ( ruleQualifiedName ) )
                    {
                    otherlv_4=(Token)match(input,31,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getClientAttributeAccess().getServerModelKeyword_4_0());
                    			
                    // InternalAceGen.g:806:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:807:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:807:5: ( ruleQualifiedName )
                    // InternalAceGen.g:808:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClientAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getClientAttributeAccess().getModelModelCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_25);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:823:3: ( (lv_hash_6_0= 'location.hash' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==32) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAceGen.g:824:4: (lv_hash_6_0= 'location.hash' )
                    {
                    // InternalAceGen.g:824:4: (lv_hash_6_0= 'location.hash' )
                    // InternalAceGen.g:825:5: lv_hash_6_0= 'location.hash'
                    {
                    lv_hash_6_0=(Token)match(input,32,FOLLOW_26); 

                    					newLeafNode(lv_hash_6_0, grammarAccess.getClientAttributeAccess().getHashLocationHashKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "hash", true, "location.hash");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:837:3: ( (lv_storage_7_0= 'storage' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==33) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAceGen.g:838:4: (lv_storage_7_0= 'storage' )
                    {
                    // InternalAceGen.g:838:4: (lv_storage_7_0= 'storage' )
                    // InternalAceGen.g:839:5: lv_storage_7_0= 'storage'
                    {
                    lv_storage_7_0=(Token)match(input,33,FOLLOW_27); 

                    					newLeafNode(lv_storage_7_0, grammarAccess.getClientAttributeAccess().getStorageStorageKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "storage", true, "storage");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:851:3: (otherlv_8= '{' ( (lv_attributes_9_0= ruleClientAttribute ) )* otherlv_10= '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==15) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalAceGen.g:852:4: otherlv_8= '{' ( (lv_attributes_9_0= ruleClientAttribute ) )* otherlv_10= '}'
                    {
                    otherlv_8=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_8, grammarAccess.getClientAttributeAccess().getLeftCurlyBracketKeyword_7_0());
                    			
                    // InternalAceGen.g:856:4: ( (lv_attributes_9_0= ruleClientAttribute ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID||(LA30_0>=29 && LA30_0<=30)||(LA30_0>=84 && LA30_0<=89)) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalAceGen.g:857:5: (lv_attributes_9_0= ruleClientAttribute )
                    	    {
                    	    // InternalAceGen.g:857:5: (lv_attributes_9_0= ruleClientAttribute )
                    	    // InternalAceGen.g:858:6: lv_attributes_9_0= ruleClientAttribute
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientAttributeAccess().getAttributesClientAttributeParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_8);
                    	    lv_attributes_9_0=ruleClientAttribute();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClientAttributeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"attributes",
                    	    							lv_attributes_9_0,
                    	    							"de.acegen.AceGen.ClientAttribute");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,16,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getClientAttributeAccess().getRightCurlyBracketKeyword_7_2());
                    			

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
    // $ANTLR end "ruleClientAttribute"


    // $ANTLR start "entryRuleClientScenario"
    // InternalAceGen.g:884:1: entryRuleClientScenario returns [EObject current=null] : iv_ruleClientScenario= ruleClientScenario EOF ;
    public final EObject entryRuleClientScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientScenario = null;


        try {
            // InternalAceGen.g:884:55: (iv_ruleClientScenario= ruleClientScenario EOF )
            // InternalAceGen.g:885:2: iv_ruleClientScenario= ruleClientScenario EOF
            {
             newCompositeNode(grammarAccess.getClientScenarioRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClientScenario=ruleClientScenario();

            state._fsp--;

             current =iv_ruleClientScenario; 
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
    // $ANTLR end "entryRuleClientScenario"


    // $ANTLR start "ruleClientScenario"
    // InternalAceGen.g:891:1: ruleClientScenario returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( ( ruleQualifiedName ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleClientWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) ) ;
    public final EObject ruleClientScenario() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_whenBlock_4_0 = null;

        EObject lv_thenBlock_6_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:897:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( ( ruleQualifiedName ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleClientWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) ) )
            // InternalAceGen.g:898:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( ( ruleQualifiedName ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleClientWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )
            {
            // InternalAceGen.g:898:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( ( ruleQualifiedName ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleClientWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )
            // InternalAceGen.g:899:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( ( ruleQualifiedName ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleClientWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) )
            {
            // InternalAceGen.g:899:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:900:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:900:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:901:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_name_0_0, grammarAccess.getClientScenarioAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClientScenarioRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:917:3: (otherlv_1= 'GIVEN' ( ( ruleQualifiedName ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==34) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalAceGen.g:918:4: otherlv_1= 'GIVEN' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_29); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientScenarioAccess().getGIVENKeyword_1_0());
                    			
                    // InternalAceGen.g:922:4: ( ( ruleQualifiedName ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==RULE_ID) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalAceGen.g:923:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:923:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:924:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getClientScenarioRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getClientScenarioAccess().getGivenRefsClientScenarioCrossReference_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_29);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_3=(Token)match(input,35,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getClientScenarioAccess().getWHENKeyword_2());
            		
            // InternalAceGen.g:943:3: ( (lv_whenBlock_4_0= ruleClientWhenBlock ) )
            // InternalAceGen.g:944:4: (lv_whenBlock_4_0= ruleClientWhenBlock )
            {
            // InternalAceGen.g:944:4: (lv_whenBlock_4_0= ruleClientWhenBlock )
            // InternalAceGen.g:945:5: lv_whenBlock_4_0= ruleClientWhenBlock
            {

            					newCompositeNode(grammarAccess.getClientScenarioAccess().getWhenBlockClientWhenBlockParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_30);
            lv_whenBlock_4_0=ruleClientWhenBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClientScenarioRule());
            					}
            					set(
            						current,
            						"whenBlock",
            						lv_whenBlock_4_0,
            						"de.acegen.AceGen.ClientWhenBlock");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,36,FOLLOW_31); 

            			newLeafNode(otherlv_5, grammarAccess.getClientScenarioAccess().getTHENKeyword_4());
            		
            // InternalAceGen.g:966:3: ( (lv_thenBlock_6_0= ruleClientThenBlock ) )
            // InternalAceGen.g:967:4: (lv_thenBlock_6_0= ruleClientThenBlock )
            {
            // InternalAceGen.g:967:4: (lv_thenBlock_6_0= ruleClientThenBlock )
            // InternalAceGen.g:968:5: lv_thenBlock_6_0= ruleClientThenBlock
            {

            					newCompositeNode(grammarAccess.getClientScenarioAccess().getThenBlockClientThenBlockParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_thenBlock_6_0=ruleClientThenBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClientScenarioRule());
            					}
            					set(
            						current,
            						"thenBlock",
            						lv_thenBlock_6_0,
            						"de.acegen.AceGen.ClientThenBlock");
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
    // $ANTLR end "ruleClientScenario"


    // $ANTLR start "entryRuleClientWhenBlock"
    // InternalAceGen.g:989:1: entryRuleClientWhenBlock returns [EObject current=null] : iv_ruleClientWhenBlock= ruleClientWhenBlock EOF ;
    public final EObject entryRuleClientWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientWhenBlock = null;


        try {
            // InternalAceGen.g:989:56: (iv_ruleClientWhenBlock= ruleClientWhenBlock EOF )
            // InternalAceGen.g:990:2: iv_ruleClientWhenBlock= ruleClientWhenBlock EOF
            {
             newCompositeNode(grammarAccess.getClientWhenBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClientWhenBlock=ruleClientWhenBlock();

            state._fsp--;

             current =iv_ruleClientWhenBlock; 
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
    // $ANTLR end "entryRuleClientWhenBlock"


    // $ANTLR start "ruleClientWhenBlock"
    // InternalAceGen.g:996:1: ruleClientWhenBlock returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'with' otherlv_7= 'response' ( (lv_statusCode_8_0= RULE_INT ) ) ( (lv_response_9_0= ruleJsonObject ) )? )? ) ;
    public final EObject ruleClientWhenBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_statusCode_8_0=null;
        EObject lv_inputValues_2_0 = null;

        EObject lv_inputValues_4_0 = null;

        EObject lv_response_9_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1002:2: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'with' otherlv_7= 'response' ( (lv_statusCode_8_0= RULE_INT ) ) ( (lv_response_9_0= ruleJsonObject ) )? )? ) )
            // InternalAceGen.g:1003:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'with' otherlv_7= 'response' ( (lv_statusCode_8_0= RULE_INT ) ) ( (lv_response_9_0= ruleJsonObject ) )? )? )
            {
            // InternalAceGen.g:1003:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'with' otherlv_7= 'response' ( (lv_statusCode_8_0= RULE_INT ) ) ( (lv_response_9_0= ruleJsonObject ) )? )? )
            // InternalAceGen.g:1004:3: ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'with' otherlv_7= 'response' ( (lv_statusCode_8_0= RULE_INT ) ) ( (lv_response_9_0= ruleJsonObject ) )? )?
            {
            // InternalAceGen.g:1004:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1005:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1005:4: ( ruleQualifiedName )
            // InternalAceGen.g:1006:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClientWhenBlockRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClientWhenBlockAccess().getActionHttpClientAceCrossReference_0_0());
            				
            pushFollow(FOLLOW_32);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1020:3: (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==19) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalAceGen.g:1021:4: otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_21); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientWhenBlockAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalAceGen.g:1025:4: ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==RULE_ID) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalAceGen.g:1026:5: ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )*
                            {
                            // InternalAceGen.g:1026:5: ( (lv_inputValues_2_0= ruleInputValue ) )
                            // InternalAceGen.g:1027:6: (lv_inputValues_2_0= ruleInputValue )
                            {
                            // InternalAceGen.g:1027:6: (lv_inputValues_2_0= ruleInputValue )
                            // InternalAceGen.g:1028:7: lv_inputValues_2_0= ruleInputValue
                            {

                            							newCompositeNode(grammarAccess.getClientWhenBlockAccess().getInputValuesInputValueParserRuleCall_1_1_0_0());
                            						
                            pushFollow(FOLLOW_12);
                            lv_inputValues_2_0=ruleInputValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getClientWhenBlockRule());
                            							}
                            							add(
                            								current,
                            								"inputValues",
                            								lv_inputValues_2_0,
                            								"de.acegen.AceGen.InputValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalAceGen.g:1045:5: (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )*
                            loop34:
                            do {
                                int alt34=2;
                                int LA34_0 = input.LA(1);

                                if ( (LA34_0==20) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                            	case 1 :
                            	    // InternalAceGen.g:1046:6: otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) )
                            	    {
                            	    otherlv_3=(Token)match(input,20,FOLLOW_10); 

                            	    						newLeafNode(otherlv_3, grammarAccess.getClientWhenBlockAccess().getCommaKeyword_1_1_1_0());
                            	    					
                            	    // InternalAceGen.g:1050:6: ( (lv_inputValues_4_0= ruleInputValue ) )
                            	    // InternalAceGen.g:1051:7: (lv_inputValues_4_0= ruleInputValue )
                            	    {
                            	    // InternalAceGen.g:1051:7: (lv_inputValues_4_0= ruleInputValue )
                            	    // InternalAceGen.g:1052:8: lv_inputValues_4_0= ruleInputValue
                            	    {

                            	    								newCompositeNode(grammarAccess.getClientWhenBlockAccess().getInputValuesInputValueParserRuleCall_1_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_12);
                            	    lv_inputValues_4_0=ruleInputValue();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getClientWhenBlockRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"inputValues",
                            	    									lv_inputValues_4_0,
                            	    									"de.acegen.AceGen.InputValue");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop34;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,21,FOLLOW_33); 

                    				newLeafNode(otherlv_5, grammarAccess.getClientWhenBlockAccess().getRightParenthesisKeyword_1_2());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:1076:3: (otherlv_6= 'with' otherlv_7= 'response' ( (lv_statusCode_8_0= RULE_INT ) ) ( (lv_response_9_0= ruleJsonObject ) )? )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==37) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAceGen.g:1077:4: otherlv_6= 'with' otherlv_7= 'response' ( (lv_statusCode_8_0= RULE_INT ) ) ( (lv_response_9_0= ruleJsonObject ) )?
                    {
                    otherlv_6=(Token)match(input,37,FOLLOW_34); 

                    				newLeafNode(otherlv_6, grammarAccess.getClientWhenBlockAccess().getWithKeyword_2_0());
                    			
                    otherlv_7=(Token)match(input,38,FOLLOW_35); 

                    				newLeafNode(otherlv_7, grammarAccess.getClientWhenBlockAccess().getResponseKeyword_2_1());
                    			
                    // InternalAceGen.g:1085:4: ( (lv_statusCode_8_0= RULE_INT ) )
                    // InternalAceGen.g:1086:5: (lv_statusCode_8_0= RULE_INT )
                    {
                    // InternalAceGen.g:1086:5: (lv_statusCode_8_0= RULE_INT )
                    // InternalAceGen.g:1087:6: lv_statusCode_8_0= RULE_INT
                    {
                    lv_statusCode_8_0=(Token)match(input,RULE_INT,FOLLOW_27); 

                    						newLeafNode(lv_statusCode_8_0, grammarAccess.getClientWhenBlockAccess().getStatusCodeINTTerminalRuleCall_2_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClientWhenBlockRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"statusCode",
                    							lv_statusCode_8_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    // InternalAceGen.g:1103:4: ( (lv_response_9_0= ruleJsonObject ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==15) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalAceGen.g:1104:5: (lv_response_9_0= ruleJsonObject )
                            {
                            // InternalAceGen.g:1104:5: (lv_response_9_0= ruleJsonObject )
                            // InternalAceGen.g:1105:6: lv_response_9_0= ruleJsonObject
                            {

                            						newCompositeNode(grammarAccess.getClientWhenBlockAccess().getResponseJsonObjectParserRuleCall_2_3_0());
                            					
                            pushFollow(FOLLOW_2);
                            lv_response_9_0=ruleJsonObject();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getClientWhenBlockRule());
                            						}
                            						set(
                            							current,
                            							"response",
                            							lv_response_9_0,
                            							"de.acegen.AceGen.JsonObject");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

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
    // $ANTLR end "ruleClientWhenBlock"


    // $ANTLR start "entryRuleInputValue"
    // InternalAceGen.g:1127:1: entryRuleInputValue returns [EObject current=null] : iv_ruleInputValue= ruleInputValue EOF ;
    public final EObject entryRuleInputValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputValue = null;


        try {
            // InternalAceGen.g:1127:51: (iv_ruleInputValue= ruleInputValue EOF )
            // InternalAceGen.g:1128:2: iv_ruleInputValue= ruleInputValue EOF
            {
             newCompositeNode(grammarAccess.getInputValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInputValue=ruleInputValue();

            state._fsp--;

             current =iv_ruleInputValue; 
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
    // $ANTLR end "entryRuleInputValue"


    // $ANTLR start "ruleInputValue"
    // InternalAceGen.g:1134:1: ruleInputValue returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject ruleInputValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1140:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalAceGen.g:1141:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalAceGen.g:1141:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalAceGen.g:1142:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalAceGen.g:1142:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1143:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1143:4: ( ruleQualifiedName )
            // InternalAceGen.g:1144:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInputValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInputValueAccess().getInputInputCrossReference_0_0());
            				
            pushFollow(FOLLOW_36);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_37); 

            			newLeafNode(otherlv_1, grammarAccess.getInputValueAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:1162:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalAceGen.g:1163:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalAceGen.g:1163:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalAceGen.g:1164:5: lv_value_2_0= rulePrimitiveValue
            {

            					newCompositeNode(grammarAccess.getInputValueAccess().getValuePrimitiveValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=rulePrimitiveValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInputValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"de.acegen.AceGen.PrimitiveValue");
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
    // $ANTLR end "ruleInputValue"


    // $ANTLR start "entryRuleClientThenBlock"
    // InternalAceGen.g:1185:1: entryRuleClientThenBlock returns [EObject current=null] : iv_ruleClientThenBlock= ruleClientThenBlock EOF ;
    public final EObject entryRuleClientThenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientThenBlock = null;


        try {
            // InternalAceGen.g:1185:56: (iv_ruleClientThenBlock= ruleClientThenBlock EOF )
            // InternalAceGen.g:1186:2: iv_ruleClientThenBlock= ruleClientThenBlock EOF
            {
             newCompositeNode(grammarAccess.getClientThenBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClientThenBlock=ruleClientThenBlock();

            state._fsp--;

             current =iv_ruleClientThenBlock; 
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
    // $ANTLR end "entryRuleClientThenBlock"


    // $ANTLR start "ruleClientThenBlock"
    // InternalAceGen.g:1192:1: ruleClientThenBlock returns [EObject current=null] : ( () (otherlv_1= 'expectedServerCall' ( (lv_serverCall_2_0= ruleServerCall ) ) )? (otherlv_3= 'expectedState' ( (lv_stateVerifications_4_0= ruleStateVerification ) )* )? (otherlv_5= 'triggeredActions' ( (lv_triggeredAction_6_0= ruleTriggeredAction ) )* )? ) ;
    public final EObject ruleClientThenBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_serverCall_2_0 = null;

        EObject lv_stateVerifications_4_0 = null;

        EObject lv_triggeredAction_6_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1198:2: ( ( () (otherlv_1= 'expectedServerCall' ( (lv_serverCall_2_0= ruleServerCall ) ) )? (otherlv_3= 'expectedState' ( (lv_stateVerifications_4_0= ruleStateVerification ) )* )? (otherlv_5= 'triggeredActions' ( (lv_triggeredAction_6_0= ruleTriggeredAction ) )* )? ) )
            // InternalAceGen.g:1199:2: ( () (otherlv_1= 'expectedServerCall' ( (lv_serverCall_2_0= ruleServerCall ) ) )? (otherlv_3= 'expectedState' ( (lv_stateVerifications_4_0= ruleStateVerification ) )* )? (otherlv_5= 'triggeredActions' ( (lv_triggeredAction_6_0= ruleTriggeredAction ) )* )? )
            {
            // InternalAceGen.g:1199:2: ( () (otherlv_1= 'expectedServerCall' ( (lv_serverCall_2_0= ruleServerCall ) ) )? (otherlv_3= 'expectedState' ( (lv_stateVerifications_4_0= ruleStateVerification ) )* )? (otherlv_5= 'triggeredActions' ( (lv_triggeredAction_6_0= ruleTriggeredAction ) )* )? )
            // InternalAceGen.g:1200:3: () (otherlv_1= 'expectedServerCall' ( (lv_serverCall_2_0= ruleServerCall ) ) )? (otherlv_3= 'expectedState' ( (lv_stateVerifications_4_0= ruleStateVerification ) )* )? (otherlv_5= 'triggeredActions' ( (lv_triggeredAction_6_0= ruleTriggeredAction ) )* )?
            {
            // InternalAceGen.g:1200:3: ()
            // InternalAceGen.g:1201:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClientThenBlockAccess().getClientThenBlockAction_0(),
            					current);
            			

            }

            // InternalAceGen.g:1207:3: (otherlv_1= 'expectedServerCall' ( (lv_serverCall_2_0= ruleServerCall ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==40) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalAceGen.g:1208:4: otherlv_1= 'expectedServerCall' ( (lv_serverCall_2_0= ruleServerCall ) )
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_38); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientThenBlockAccess().getExpectedServerCallKeyword_1_0());
                    			
                    // InternalAceGen.g:1212:4: ( (lv_serverCall_2_0= ruleServerCall ) )
                    // InternalAceGen.g:1213:5: (lv_serverCall_2_0= ruleServerCall )
                    {
                    // InternalAceGen.g:1213:5: (lv_serverCall_2_0= ruleServerCall )
                    // InternalAceGen.g:1214:6: lv_serverCall_2_0= ruleServerCall
                    {

                    						newCompositeNode(grammarAccess.getClientThenBlockAccess().getServerCallServerCallParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_39);
                    lv_serverCall_2_0=ruleServerCall();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClientThenBlockRule());
                    						}
                    						set(
                    							current,
                    							"serverCall",
                    							lv_serverCall_2_0,
                    							"de.acegen.AceGen.ServerCall");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:1232:3: (otherlv_3= 'expectedState' ( (lv_stateVerifications_4_0= ruleStateVerification ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==41) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalAceGen.g:1233:4: otherlv_3= 'expectedState' ( (lv_stateVerifications_4_0= ruleStateVerification ) )*
                    {
                    otherlv_3=(Token)match(input,41,FOLLOW_40); 

                    				newLeafNode(otherlv_3, grammarAccess.getClientThenBlockAccess().getExpectedStateKeyword_2_0());
                    			
                    // InternalAceGen.g:1237:4: ( (lv_stateVerifications_4_0= ruleStateVerification ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID) ) {
                            int LA40_2 = input.LA(2);

                            if ( (LA40_2==RULE_ID) ) {
                                alt40=1;
                            }


                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalAceGen.g:1238:5: (lv_stateVerifications_4_0= ruleStateVerification )
                    	    {
                    	    // InternalAceGen.g:1238:5: (lv_stateVerifications_4_0= ruleStateVerification )
                    	    // InternalAceGen.g:1239:6: lv_stateVerifications_4_0= ruleStateVerification
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientThenBlockAccess().getStateVerificationsStateVerificationParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_40);
                    	    lv_stateVerifications_4_0=ruleStateVerification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClientThenBlockRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"stateVerifications",
                    	    							lv_stateVerifications_4_0,
                    	    							"de.acegen.AceGen.StateVerification");
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

            // InternalAceGen.g:1257:3: (otherlv_5= 'triggeredActions' ( (lv_triggeredAction_6_0= ruleTriggeredAction ) )* )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==42) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalAceGen.g:1258:4: otherlv_5= 'triggeredActions' ( (lv_triggeredAction_6_0= ruleTriggeredAction ) )*
                    {
                    otherlv_5=(Token)match(input,42,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getClientThenBlockAccess().getTriggeredActionsKeyword_3_0());
                    			
                    // InternalAceGen.g:1262:4: ( (lv_triggeredAction_6_0= ruleTriggeredAction ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==RULE_ID) ) {
                            int LA42_2 = input.LA(2);

                            if ( (LA42_2==19||LA42_2==79) ) {
                                alt42=1;
                            }


                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalAceGen.g:1263:5: (lv_triggeredAction_6_0= ruleTriggeredAction )
                    	    {
                    	    // InternalAceGen.g:1263:5: (lv_triggeredAction_6_0= ruleTriggeredAction )
                    	    // InternalAceGen.g:1264:6: lv_triggeredAction_6_0= ruleTriggeredAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientThenBlockAccess().getTriggeredActionTriggeredActionParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_3);
                    	    lv_triggeredAction_6_0=ruleTriggeredAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClientThenBlockRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"triggeredAction",
                    	    							lv_triggeredAction_6_0,
                    	    							"de.acegen.AceGen.TriggeredAction");
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
    // $ANTLR end "ruleClientThenBlock"


    // $ANTLR start "entryRuleServerCall"
    // InternalAceGen.g:1286:1: entryRuleServerCall returns [EObject current=null] : iv_ruleServerCall= ruleServerCall EOF ;
    public final EObject entryRuleServerCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServerCall = null;


        try {
            // InternalAceGen.g:1286:51: (iv_ruleServerCall= ruleServerCall EOF )
            // InternalAceGen.g:1287:2: iv_ruleServerCall= ruleServerCall EOF
            {
             newCompositeNode(grammarAccess.getServerCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServerCall=ruleServerCall();

            state._fsp--;

             current =iv_ruleServerCall; 
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
    // $ANTLR end "entryRuleServerCall"


    // $ANTLR start "ruleServerCall"
    // InternalAceGen.g:1293:1: ruleServerCall returns [EObject current=null] : ( (lv_jsonObject_0_0= ruleJsonObject ) ) ;
    public final EObject ruleServerCall() throws RecognitionException {
        EObject current = null;

        EObject lv_jsonObject_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1299:2: ( ( (lv_jsonObject_0_0= ruleJsonObject ) ) )
            // InternalAceGen.g:1300:2: ( (lv_jsonObject_0_0= ruleJsonObject ) )
            {
            // InternalAceGen.g:1300:2: ( (lv_jsonObject_0_0= ruleJsonObject ) )
            // InternalAceGen.g:1301:3: (lv_jsonObject_0_0= ruleJsonObject )
            {
            // InternalAceGen.g:1301:3: (lv_jsonObject_0_0= ruleJsonObject )
            // InternalAceGen.g:1302:4: lv_jsonObject_0_0= ruleJsonObject
            {

            				newCompositeNode(grammarAccess.getServerCallAccess().getJsonObjectJsonObjectParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_jsonObject_0_0=ruleJsonObject();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getServerCallRule());
            				}
            				set(
            					current,
            					"jsonObject",
            					lv_jsonObject_0_0,
            					"de.acegen.AceGen.JsonObject");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleServerCall"


    // $ANTLR start "entryRuleTriggeredAction"
    // InternalAceGen.g:1322:1: entryRuleTriggeredAction returns [EObject current=null] : iv_ruleTriggeredAction= ruleTriggeredAction EOF ;
    public final EObject entryRuleTriggeredAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredAction = null;


        try {
            // InternalAceGen.g:1322:56: (iv_ruleTriggeredAction= ruleTriggeredAction EOF )
            // InternalAceGen.g:1323:2: iv_ruleTriggeredAction= ruleTriggeredAction EOF
            {
             newCompositeNode(grammarAccess.getTriggeredActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTriggeredAction=ruleTriggeredAction();

            state._fsp--;

             current =iv_ruleTriggeredAction; 
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
    // $ANTLR end "entryRuleTriggeredAction"


    // $ANTLR start "ruleTriggeredAction"
    // InternalAceGen.g:1329:1: ruleTriggeredAction returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleTriggeredAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_inputValues_2_0 = null;

        EObject lv_inputValues_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1335:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* otherlv_5= ')' ) )
            // InternalAceGen.g:1336:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* otherlv_5= ')' )
            {
            // InternalAceGen.g:1336:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '(' ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* otherlv_5= ')' )
            // InternalAceGen.g:1337:3: ( ( ruleQualifiedName ) ) otherlv_1= '(' ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* otherlv_5= ')'
            {
            // InternalAceGen.g:1337:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1338:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1338:4: ( ruleQualifiedName )
            // InternalAceGen.g:1339:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTriggeredActionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTriggeredActionAccess().getHttpClientAceHttpClientAceCrossReference_0_0());
            				
            pushFollow(FOLLOW_14);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getTriggeredActionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:1357:3: ( (lv_inputValues_2_0= ruleInputValue ) )
            // InternalAceGen.g:1358:4: (lv_inputValues_2_0= ruleInputValue )
            {
            // InternalAceGen.g:1358:4: (lv_inputValues_2_0= ruleInputValue )
            // InternalAceGen.g:1359:5: lv_inputValues_2_0= ruleInputValue
            {

            					newCompositeNode(grammarAccess.getTriggeredActionAccess().getInputValuesInputValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
            lv_inputValues_2_0=ruleInputValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTriggeredActionRule());
            					}
            					add(
            						current,
            						"inputValues",
            						lv_inputValues_2_0,
            						"de.acegen.AceGen.InputValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1376:3: (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==20) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalAceGen.g:1377:4: otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_10); 

            	    				newLeafNode(otherlv_3, grammarAccess.getTriggeredActionAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:1381:4: ( (lv_inputValues_4_0= ruleInputValue ) )
            	    // InternalAceGen.g:1382:5: (lv_inputValues_4_0= ruleInputValue )
            	    {
            	    // InternalAceGen.g:1382:5: (lv_inputValues_4_0= ruleInputValue )
            	    // InternalAceGen.g:1383:6: lv_inputValues_4_0= ruleInputValue
            	    {

            	    						newCompositeNode(grammarAccess.getTriggeredActionAccess().getInputValuesInputValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_inputValues_4_0=ruleInputValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTriggeredActionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputValues",
            	    							lv_inputValues_4_0,
            	    							"de.acegen.AceGen.InputValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            otherlv_5=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTriggeredActionAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleTriggeredAction"


    // $ANTLR start "entryRuleStateVerification"
    // InternalAceGen.g:1409:1: entryRuleStateVerification returns [EObject current=null] : iv_ruleStateVerification= ruleStateVerification EOF ;
    public final EObject entryRuleStateVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateVerification = null;


        try {
            // InternalAceGen.g:1409:58: (iv_ruleStateVerification= ruleStateVerification EOF )
            // InternalAceGen.g:1410:2: iv_ruleStateVerification= ruleStateVerification EOF
            {
             newCompositeNode(grammarAccess.getStateVerificationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStateVerification=ruleStateVerification();

            state._fsp--;

             current =iv_ruleStateVerification; 
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
    // $ANTLR end "entryRuleStateVerification"


    // $ANTLR start "ruleStateVerification"
    // InternalAceGen.g:1416:1: ruleStateVerification returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'shouldBe' ( (lv_value_3_0= ruleJsonValueClient ) ) ) ;
    public final EObject ruleStateVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1422:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'shouldBe' ( (lv_value_3_0= ruleJsonValueClient ) ) ) )
            // InternalAceGen.g:1423:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'shouldBe' ( (lv_value_3_0= ruleJsonValueClient ) ) )
            {
            // InternalAceGen.g:1423:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'shouldBe' ( (lv_value_3_0= ruleJsonValueClient ) ) )
            // InternalAceGen.g:1424:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'shouldBe' ( (lv_value_3_0= ruleJsonValueClient ) )
            {
            // InternalAceGen.g:1424:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1425:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1425:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1426:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_0_0, grammarAccess.getStateVerificationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateVerificationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:1442:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1443:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1443:4: ( ruleQualifiedName )
            // InternalAceGen.g:1444:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateVerificationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStateVerificationAccess().getStateRefClientAttributeCrossReference_1_0());
            				
            pushFollow(FOLLOW_41);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,43,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getStateVerificationAccess().getShouldBeKeyword_2());
            		
            // InternalAceGen.g:1462:3: ( (lv_value_3_0= ruleJsonValueClient ) )
            // InternalAceGen.g:1463:4: (lv_value_3_0= ruleJsonValueClient )
            {
            // InternalAceGen.g:1463:4: (lv_value_3_0= ruleJsonValueClient )
            // InternalAceGen.g:1464:5: lv_value_3_0= ruleJsonValueClient
            {

            					newCompositeNode(grammarAccess.getStateVerificationAccess().getValueJsonValueClientParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleJsonValueClient();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateVerificationRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"de.acegen.AceGen.JsonValueClient");
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
    // $ANTLR end "ruleStateVerification"


    // $ANTLR start "entryRuleJsonObjectClient"
    // InternalAceGen.g:1485:1: entryRuleJsonObjectClient returns [EObject current=null] : iv_ruleJsonObjectClient= ruleJsonObjectClient EOF ;
    public final EObject entryRuleJsonObjectClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObjectClient = null;


        try {
            // InternalAceGen.g:1485:57: (iv_ruleJsonObjectClient= ruleJsonObjectClient EOF )
            // InternalAceGen.g:1486:2: iv_ruleJsonObjectClient= ruleJsonObjectClient EOF
            {
             newCompositeNode(grammarAccess.getJsonObjectClientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonObjectClient=ruleJsonObjectClient();

            state._fsp--;

             current =iv_ruleJsonObjectClient; 
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
    // $ANTLR end "entryRuleJsonObjectClient"


    // $ANTLR start "ruleJsonObjectClient"
    // InternalAceGen.g:1492:1: ruleJsonObjectClient returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleJsonObjectClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_members_2_0 = null;

        EObject lv_members_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1498:2: ( ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' ) )
            // InternalAceGen.g:1499:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' )
            {
            // InternalAceGen.g:1499:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' )
            // InternalAceGen.g:1500:3: () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}'
            {
            // InternalAceGen.g:1500:3: ()
            // InternalAceGen.g:1501:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonObjectClientAccess().getJsonObjectClientAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonObjectClientAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:1511:3: ( (lv_members_2_0= ruleJsonMemberClient ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAceGen.g:1512:4: (lv_members_2_0= ruleJsonMemberClient )
                    {
                    // InternalAceGen.g:1512:4: (lv_members_2_0= ruleJsonMemberClient )
                    // InternalAceGen.g:1513:5: lv_members_2_0= ruleJsonMemberClient
                    {

                    					newCompositeNode(grammarAccess.getJsonObjectClientAccess().getMembersJsonMemberClientParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_44);
                    lv_members_2_0=ruleJsonMemberClient();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJsonObjectClientRule());
                    					}
                    					add(
                    						current,
                    						"members",
                    						lv_members_2_0,
                    						"de.acegen.AceGen.JsonMemberClient");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1530:3: (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==20) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalAceGen.g:1531:4: otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_10); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonObjectClientAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:1535:4: ( (lv_members_4_0= ruleJsonMemberClient ) )
            	    // InternalAceGen.g:1536:5: (lv_members_4_0= ruleJsonMemberClient )
            	    {
            	    // InternalAceGen.g:1536:5: (lv_members_4_0= ruleJsonMemberClient )
            	    // InternalAceGen.g:1537:6: lv_members_4_0= ruleJsonMemberClient
            	    {

            	    						newCompositeNode(grammarAccess.getJsonObjectClientAccess().getMembersJsonMemberClientParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_44);
            	    lv_members_4_0=ruleJsonMemberClient();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJsonObjectClientRule());
            	    						}
            	    						add(
            	    							current,
            	    							"members",
            	    							lv_members_4_0,
            	    							"de.acegen.AceGen.JsonMemberClient");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getJsonObjectClientAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleJsonObjectClient"


    // $ANTLR start "entryRuleJsonMemberClient"
    // InternalAceGen.g:1563:1: entryRuleJsonMemberClient returns [EObject current=null] : iv_ruleJsonMemberClient= ruleJsonMemberClient EOF ;
    public final EObject entryRuleJsonMemberClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonMemberClient = null;


        try {
            // InternalAceGen.g:1563:57: (iv_ruleJsonMemberClient= ruleJsonMemberClient EOF )
            // InternalAceGen.g:1564:2: iv_ruleJsonMemberClient= ruleJsonMemberClient EOF
            {
             newCompositeNode(grammarAccess.getJsonMemberClientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonMemberClient=ruleJsonMemberClient();

            state._fsp--;

             current =iv_ruleJsonMemberClient; 
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
    // $ANTLR end "entryRuleJsonMemberClient"


    // $ANTLR start "ruleJsonMemberClient"
    // InternalAceGen.g:1570:1: ruleJsonMemberClient returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) ) ;
    public final EObject ruleJsonMemberClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1576:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) ) )
            // InternalAceGen.g:1577:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) )
            {
            // InternalAceGen.g:1577:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) )
            // InternalAceGen.g:1578:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) )
            {
            // InternalAceGen.g:1578:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1579:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1579:4: ( ruleQualifiedName )
            // InternalAceGen.g:1580:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonMemberClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJsonMemberClientAccess().getAttributeClientAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_36);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_42); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonMemberClientAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:1598:3: ( (lv_value_2_0= ruleJsonValueClient ) )
            // InternalAceGen.g:1599:4: (lv_value_2_0= ruleJsonValueClient )
            {
            // InternalAceGen.g:1599:4: (lv_value_2_0= ruleJsonValueClient )
            // InternalAceGen.g:1600:5: lv_value_2_0= ruleJsonValueClient
            {

            					newCompositeNode(grammarAccess.getJsonMemberClientAccess().getValueJsonValueClientParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleJsonValueClient();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJsonMemberClientRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"de.acegen.AceGen.JsonValueClient");
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
    // $ANTLR end "ruleJsonMemberClient"


    // $ANTLR start "entryRuleJsonValueClient"
    // InternalAceGen.g:1621:1: entryRuleJsonValueClient returns [EObject current=null] : iv_ruleJsonValueClient= ruleJsonValueClient EOF ;
    public final EObject entryRuleJsonValueClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonValueClient = null;


        try {
            // InternalAceGen.g:1621:56: (iv_ruleJsonValueClient= ruleJsonValueClient EOF )
            // InternalAceGen.g:1622:2: iv_ruleJsonValueClient= ruleJsonValueClient EOF
            {
             newCompositeNode(grammarAccess.getJsonValueClientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonValueClient=ruleJsonValueClient();

            state._fsp--;

             current =iv_ruleJsonValueClient; 
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
    // $ANTLR end "entryRuleJsonValueClient"


    // $ANTLR start "ruleJsonValueClient"
    // InternalAceGen.g:1628:1: ruleJsonValueClient returns [EObject current=null] : (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime ) ;
    public final EObject ruleJsonValueClient() throws RecognitionException {
        EObject current = null;

        EObject this_JsonObjectClient_0 = null;

        EObject this_StringType_1 = null;

        EObject this_JsonArrayClient_2 = null;

        EObject this_BooleanType_3 = null;

        EObject this_NullType_4 = null;

        EObject this_LongType_5 = null;

        EObject this_JsonDateTime_6 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1634:2: ( (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime ) )
            // InternalAceGen.g:1635:2: (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime )
            {
            // InternalAceGen.g:1635:2: (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime )
            int alt47=7;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt47=1;
                }
                break;
            case RULE_STRING:
                {
                int LA47_2 = input.LA(2);

                if ( (LA47_2==RULE_STRING) ) {
                    alt47=7;
                }
                else if ( (LA47_2==EOF||LA47_2==RULE_ID||LA47_2==16||LA47_2==20||LA47_2==42||LA47_2==45) ) {
                    alt47=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 2, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                alt47=3;
                }
                break;
            case 90:
            case 91:
                {
                alt47=4;
                }
                break;
            case 71:
                {
                alt47=5;
                }
                break;
            case RULE_INT:
                {
                alt47=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalAceGen.g:1636:3: this_JsonObjectClient_0= ruleJsonObjectClient
                    {

                    			newCompositeNode(grammarAccess.getJsonValueClientAccess().getJsonObjectClientParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_JsonObjectClient_0=ruleJsonObjectClient();

                    state._fsp--;


                    			current = this_JsonObjectClient_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1645:3: this_StringType_1= ruleStringType
                    {

                    			newCompositeNode(grammarAccess.getJsonValueClientAccess().getStringTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringType_1=ruleStringType();

                    state._fsp--;


                    			current = this_StringType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:1654:3: this_JsonArrayClient_2= ruleJsonArrayClient
                    {

                    			newCompositeNode(grammarAccess.getJsonValueClientAccess().getJsonArrayClientParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_JsonArrayClient_2=ruleJsonArrayClient();

                    state._fsp--;


                    			current = this_JsonArrayClient_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalAceGen.g:1663:3: this_BooleanType_3= ruleBooleanType
                    {

                    			newCompositeNode(grammarAccess.getJsonValueClientAccess().getBooleanTypeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanType_3=ruleBooleanType();

                    state._fsp--;


                    			current = this_BooleanType_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalAceGen.g:1672:3: this_NullType_4= ruleNullType
                    {

                    			newCompositeNode(grammarAccess.getJsonValueClientAccess().getNullTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_NullType_4=ruleNullType();

                    state._fsp--;


                    			current = this_NullType_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalAceGen.g:1681:3: this_LongType_5= ruleLongType
                    {

                    			newCompositeNode(grammarAccess.getJsonValueClientAccess().getLongTypeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_LongType_5=ruleLongType();

                    state._fsp--;


                    			current = this_LongType_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalAceGen.g:1690:3: this_JsonDateTime_6= ruleJsonDateTime
                    {

                    			newCompositeNode(grammarAccess.getJsonValueClientAccess().getJsonDateTimeParserRuleCall_6());
                    		
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
    // $ANTLR end "ruleJsonValueClient"


    // $ANTLR start "entryRuleJsonArrayClient"
    // InternalAceGen.g:1702:1: entryRuleJsonArrayClient returns [EObject current=null] : iv_ruleJsonArrayClient= ruleJsonArrayClient EOF ;
    public final EObject entryRuleJsonArrayClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonArrayClient = null;


        try {
            // InternalAceGen.g:1702:56: (iv_ruleJsonArrayClient= ruleJsonArrayClient EOF )
            // InternalAceGen.g:1703:2: iv_ruleJsonArrayClient= ruleJsonArrayClient EOF
            {
             newCompositeNode(grammarAccess.getJsonArrayClientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonArrayClient=ruleJsonArrayClient();

            state._fsp--;

             current =iv_ruleJsonArrayClient; 
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
    // $ANTLR end "entryRuleJsonArrayClient"


    // $ANTLR start "ruleJsonArrayClient"
    // InternalAceGen.g:1709:1: ruleJsonArrayClient returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleJsonArrayClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1715:2: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' ) )
            // InternalAceGen.g:1716:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' )
            {
            // InternalAceGen.g:1716:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' )
            // InternalAceGen.g:1717:3: () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']'
            {
            // InternalAceGen.g:1717:3: ()
            // InternalAceGen.g:1718:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonArrayClientAccess().getJsonArrayClientAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,44,FOLLOW_45); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonArrayClientAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalAceGen.g:1728:3: ( (lv_values_2_0= ruleJsonValueClient ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=RULE_INT && LA48_0<=RULE_STRING)||LA48_0==15||LA48_0==44||LA48_0==71||(LA48_0>=90 && LA48_0<=91)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalAceGen.g:1729:4: (lv_values_2_0= ruleJsonValueClient )
                    {
                    // InternalAceGen.g:1729:4: (lv_values_2_0= ruleJsonValueClient )
                    // InternalAceGen.g:1730:5: lv_values_2_0= ruleJsonValueClient
                    {

                    					newCompositeNode(grammarAccess.getJsonArrayClientAccess().getValuesJsonValueClientParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_46);
                    lv_values_2_0=ruleJsonValueClient();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJsonArrayClientRule());
                    					}
                    					add(
                    						current,
                    						"values",
                    						lv_values_2_0,
                    						"de.acegen.AceGen.JsonValueClient");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1747:3: (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==20) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalAceGen.g:1748:4: otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_42); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonArrayClientAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:1752:4: ( (lv_values_4_0= ruleJsonValueClient ) )
            	    // InternalAceGen.g:1753:5: (lv_values_4_0= ruleJsonValueClient )
            	    {
            	    // InternalAceGen.g:1753:5: (lv_values_4_0= ruleJsonValueClient )
            	    // InternalAceGen.g:1754:6: lv_values_4_0= ruleJsonValueClient
            	    {

            	    						newCompositeNode(grammarAccess.getJsonArrayClientAccess().getValuesJsonValueClientParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
            	    lv_values_4_0=ruleJsonValueClient();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJsonArrayClientRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_4_0,
            	    							"de.acegen.AceGen.JsonValueClient");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            otherlv_5=(Token)match(input,45,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getJsonArrayClientAccess().getRightSquareBracketKeyword_4());
            		

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
    // $ANTLR end "ruleJsonArrayClient"


    // $ANTLR start "entryRuleHttpServer"
    // InternalAceGen.g:1780:1: entryRuleHttpServer returns [EObject current=null] : iv_ruleHttpServer= ruleHttpServer EOF ;
    public final EObject entryRuleHttpServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServer = null;


        try {
            // InternalAceGen.g:1780:51: (iv_ruleHttpServer= ruleHttpServer EOF )
            // InternalAceGen.g:1781:2: iv_ruleHttpServer= ruleHttpServer EOF
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
    // InternalAceGen.g:1787:1: ruleHttpServer returns [EObject current=null] : ( ( (lv_language_0_0= 'Java' ) ) ( (lv_type_1_0= 'Dropwizard' ) )? ( (lv_persistenceLayer_2_0= 'JDBI3' ) )? ( (lv_migrations_3_0= 'Liquibase' ) )? ( (lv_name_4_0= ruleQualifiedName ) ) (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )? (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )? (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )? (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )? (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )? ) ;
    public final EObject ruleHttpServer() throws RecognitionException {
        EObject current = null;

        Token lv_language_0_0=null;
        Token lv_type_1_0=null;
        Token lv_persistenceLayer_2_0=null;
        Token lv_migrations_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_authUser_6_0 = null;

        EObject lv_aceOperations_10_0 = null;

        EObject lv_views_12_0 = null;

        EObject lv_models_14_0 = null;

        EObject lv_scenarios_16_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1793:2: ( ( ( (lv_language_0_0= 'Java' ) ) ( (lv_type_1_0= 'Dropwizard' ) )? ( (lv_persistenceLayer_2_0= 'JDBI3' ) )? ( (lv_migrations_3_0= 'Liquibase' ) )? ( (lv_name_4_0= ruleQualifiedName ) ) (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )? (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )? (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )? (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )? (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )? ) )
            // InternalAceGen.g:1794:2: ( ( (lv_language_0_0= 'Java' ) ) ( (lv_type_1_0= 'Dropwizard' ) )? ( (lv_persistenceLayer_2_0= 'JDBI3' ) )? ( (lv_migrations_3_0= 'Liquibase' ) )? ( (lv_name_4_0= ruleQualifiedName ) ) (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )? (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )? (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )? (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )? (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )? )
            {
            // InternalAceGen.g:1794:2: ( ( (lv_language_0_0= 'Java' ) ) ( (lv_type_1_0= 'Dropwizard' ) )? ( (lv_persistenceLayer_2_0= 'JDBI3' ) )? ( (lv_migrations_3_0= 'Liquibase' ) )? ( (lv_name_4_0= ruleQualifiedName ) ) (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )? (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )? (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )? (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )? (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )? )
            // InternalAceGen.g:1795:3: ( (lv_language_0_0= 'Java' ) ) ( (lv_type_1_0= 'Dropwizard' ) )? ( (lv_persistenceLayer_2_0= 'JDBI3' ) )? ( (lv_migrations_3_0= 'Liquibase' ) )? ( (lv_name_4_0= ruleQualifiedName ) ) (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )? (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )? (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )? (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )? (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )?
            {
            // InternalAceGen.g:1795:3: ( (lv_language_0_0= 'Java' ) )
            // InternalAceGen.g:1796:4: (lv_language_0_0= 'Java' )
            {
            // InternalAceGen.g:1796:4: (lv_language_0_0= 'Java' )
            // InternalAceGen.g:1797:5: lv_language_0_0= 'Java'
            {
            lv_language_0_0=(Token)match(input,46,FOLLOW_47); 

            					newLeafNode(lv_language_0_0, grammarAccess.getHttpServerAccess().getLanguageJavaKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerRule());
            					}
            					setWithLastConsumed(current, "language", lv_language_0_0, "Java");
            				

            }


            }

            // InternalAceGen.g:1809:3: ( (lv_type_1_0= 'Dropwizard' ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==47) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalAceGen.g:1810:4: (lv_type_1_0= 'Dropwizard' )
                    {
                    // InternalAceGen.g:1810:4: (lv_type_1_0= 'Dropwizard' )
                    // InternalAceGen.g:1811:5: lv_type_1_0= 'Dropwizard'
                    {
                    lv_type_1_0=(Token)match(input,47,FOLLOW_48); 

                    					newLeafNode(lv_type_1_0, grammarAccess.getHttpServerAccess().getTypeDropwizardKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_1_0, "Dropwizard");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1823:3: ( (lv_persistenceLayer_2_0= 'JDBI3' ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==48) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalAceGen.g:1824:4: (lv_persistenceLayer_2_0= 'JDBI3' )
                    {
                    // InternalAceGen.g:1824:4: (lv_persistenceLayer_2_0= 'JDBI3' )
                    // InternalAceGen.g:1825:5: lv_persistenceLayer_2_0= 'JDBI3'
                    {
                    lv_persistenceLayer_2_0=(Token)match(input,48,FOLLOW_49); 

                    					newLeafNode(lv_persistenceLayer_2_0, grammarAccess.getHttpServerAccess().getPersistenceLayerJDBI3Keyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "persistenceLayer", lv_persistenceLayer_2_0, "JDBI3");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1837:3: ( (lv_migrations_3_0= 'Liquibase' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==49) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalAceGen.g:1838:4: (lv_migrations_3_0= 'Liquibase' )
                    {
                    // InternalAceGen.g:1838:4: (lv_migrations_3_0= 'Liquibase' )
                    // InternalAceGen.g:1839:5: lv_migrations_3_0= 'Liquibase'
                    {
                    lv_migrations_3_0=(Token)match(input,49,FOLLOW_10); 

                    					newLeafNode(lv_migrations_3_0, grammarAccess.getHttpServerAccess().getMigrationsLiquibaseKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "migrations", lv_migrations_3_0, "Liquibase");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1851:3: ( (lv_name_4_0= ruleQualifiedName ) )
            // InternalAceGen.g:1852:4: (lv_name_4_0= ruleQualifiedName )
            {
            // InternalAceGen.g:1852:4: (lv_name_4_0= ruleQualifiedName )
            // InternalAceGen.g:1853:5: lv_name_4_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getHttpServerAccess().getNameQualifiedNameParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_50);
            lv_name_4_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHttpServerRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_4_0,
            						"de.acegen.AceGen.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1870:3: (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==50) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalAceGen.g:1871:4: otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) )
                    {
                    otherlv_5=(Token)match(input,50,FOLLOW_10); 

                    				newLeafNode(otherlv_5, grammarAccess.getHttpServerAccess().getAuthorizationKeyword_5_0());
                    			
                    // InternalAceGen.g:1875:4: ( (lv_authUser_6_0= ruleAuthUser ) )
                    // InternalAceGen.g:1876:5: (lv_authUser_6_0= ruleAuthUser )
                    {
                    // InternalAceGen.g:1876:5: (lv_authUser_6_0= ruleAuthUser )
                    // InternalAceGen.g:1877:6: lv_authUser_6_0= ruleAuthUser
                    {

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserAuthUserParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_51);
                    lv_authUser_6_0=ruleAuthUser();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    						}
                    						set(
                    							current,
                    							"authUser",
                    							lv_authUser_6_0,
                    							"de.acegen.AceGen.AuthUser");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:1895:3: (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==51) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalAceGen.g:1896:4: otherlv_7= 'import' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,51,FOLLOW_10); 

                    				newLeafNode(otherlv_7, grammarAccess.getHttpServerAccess().getImportKeyword_6_0());
                    			
                    // InternalAceGen.g:1900:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:1901:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:1901:5: ( ruleQualifiedName )
                    // InternalAceGen.g:1902:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpServerRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_52);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:1917:3: (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==13) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalAceGen.g:1918:4: otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )*
                    {
                    otherlv_9=(Token)match(input,13,FOLLOW_53); 

                    				newLeafNode(otherlv_9, grammarAccess.getHttpServerAccess().getACEKeyword_7_0());
                    			
                    // InternalAceGen.g:1922:4: ( (lv_aceOperations_10_0= ruleHttpServerAce ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==RULE_ID||LA55_0==54) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalAceGen.g:1923:5: (lv_aceOperations_10_0= ruleHttpServerAce )
                    	    {
                    	    // InternalAceGen.g:1923:5: (lv_aceOperations_10_0= ruleHttpServerAce )
                    	    // InternalAceGen.g:1924:6: lv_aceOperations_10_0= ruleHttpServerAce
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getAceOperationsHttpServerAceParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_53);
                    	    lv_aceOperations_10_0=ruleHttpServerAce();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aceOperations",
                    	    							lv_aceOperations_10_0,
                    	    							"de.acegen.AceGen.HttpServerAce");
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

            // InternalAceGen.g:1942:3: (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==52) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalAceGen.g:1943:4: otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )*
                    {
                    otherlv_11=(Token)match(input,52,FOLLOW_54); 

                    				newLeafNode(otherlv_11, grammarAccess.getHttpServerAccess().getViewsKeyword_8_0());
                    			
                    // InternalAceGen.g:1947:4: ( (lv_views_12_0= ruleHttpServerView ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==RULE_ID) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalAceGen.g:1948:5: (lv_views_12_0= ruleHttpServerView )
                    	    {
                    	    // InternalAceGen.g:1948:5: (lv_views_12_0= ruleHttpServerView )
                    	    // InternalAceGen.g:1949:6: lv_views_12_0= ruleHttpServerView
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getViewsHttpServerViewParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_54);
                    	    lv_views_12_0=ruleHttpServerView();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"views",
                    	    							lv_views_12_0,
                    	    							"de.acegen.AceGen.HttpServerView");
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

            // InternalAceGen.g:1967:3: (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==53) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalAceGen.g:1968:4: otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )*
                    {
                    otherlv_13=(Token)match(input,53,FOLLOW_55); 

                    				newLeafNode(otherlv_13, grammarAccess.getHttpServerAccess().getModelsKeyword_9_0());
                    			
                    // InternalAceGen.g:1972:4: ( (lv_models_14_0= ruleModel ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==RULE_ID||LA59_0==61) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // InternalAceGen.g:1973:5: (lv_models_14_0= ruleModel )
                    	    {
                    	    // InternalAceGen.g:1973:5: (lv_models_14_0= ruleModel )
                    	    // InternalAceGen.g:1974:6: lv_models_14_0= ruleModel
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getModelsModelParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_55);
                    	    lv_models_14_0=ruleModel();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"models",
                    	    							lv_models_14_0,
                    	    							"de.acegen.AceGen.Model");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1992:3: (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==17) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalAceGen.g:1993:4: otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )*
                    {
                    otherlv_15=(Token)match(input,17,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getHttpServerAccess().getScenariosKeyword_10_0());
                    			
                    // InternalAceGen.g:1997:4: ( (lv_scenarios_16_0= ruleScenario ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==RULE_ID) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // InternalAceGen.g:1998:5: (lv_scenarios_16_0= ruleScenario )
                    	    {
                    	    // InternalAceGen.g:1998:5: (lv_scenarios_16_0= ruleScenario )
                    	    // InternalAceGen.g:1999:6: lv_scenarios_16_0= ruleScenario
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getScenariosScenarioParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_3);
                    	    lv_scenarios_16_0=ruleScenario();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"scenarios",
                    	    							lv_scenarios_16_0,
                    	    							"de.acegen.AceGen.Scenario");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
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
    // InternalAceGen.g:2021:1: entryRuleHttpServerAce returns [EObject current=null] : iv_ruleHttpServerAce= ruleHttpServerAce EOF ;
    public final EObject entryRuleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAce = null;


        try {
            // InternalAceGen.g:2021:54: (iv_ruleHttpServerAce= ruleHttpServerAce EOF )
            // InternalAceGen.g:2022:2: iv_ruleHttpServerAce= ruleHttpServerAce EOF
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
    // InternalAceGen.g:2028:1: ruleHttpServerAce returns [EObject current=null] : (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) ;
    public final EObject ruleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject this_HttpServerAceWrite_0 = null;

        EObject this_HttpServerAceRead_1 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2034:2: ( (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) )
            // InternalAceGen.g:2035:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            {
            // InternalAceGen.g:2035:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            int alt63=2;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // InternalAceGen.g:2036:3: this_HttpServerAceWrite_0= ruleHttpServerAceWrite
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
                    // InternalAceGen.g:2045:3: this_HttpServerAceRead_1= ruleHttpServerAceRead
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
    // InternalAceGen.g:2057:1: entryRuleHttpServerAceWrite returns [EObject current=null] : iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF ;
    public final EObject entryRuleHttpServerAceWrite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceWrite = null;


        try {
            // InternalAceGen.g:2057:59: (iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF )
            // InternalAceGen.g:2058:2: iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF
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
    // InternalAceGen.g:2064:1: ruleHttpServerAceWrite returns [EObject current=null] : ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? ( (lv_outcomes_14_0= ruleHttpServerOutcome ) )* ) ;
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
        AntlrDatatypeRuleToken lv_type_5_0 = null;

        EObject lv_pathParams_9_0 = null;

        EObject lv_queryParams_11_0 = null;

        EObject lv_payload_13_0 = null;

        EObject lv_outcomes_14_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2070:2: ( ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? ( (lv_outcomes_14_0= ruleHttpServerOutcome ) )* ) )
            // InternalAceGen.g:2071:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? ( (lv_outcomes_14_0= ruleHttpServerOutcome ) )* )
            {
            // InternalAceGen.g:2071:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? ( (lv_outcomes_14_0= ruleHttpServerOutcome ) )* )
            // InternalAceGen.g:2072:3: ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? ( (lv_outcomes_14_0= ruleHttpServerOutcome ) )*
            {
            // InternalAceGen.g:2072:3: ( (lv_proxy_0_0= 'proxy' ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==54) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalAceGen.g:2073:4: (lv_proxy_0_0= 'proxy' )
                    {
                    // InternalAceGen.g:2073:4: (lv_proxy_0_0= 'proxy' )
                    // InternalAceGen.g:2074:5: lv_proxy_0_0= 'proxy'
                    {
                    lv_proxy_0_0=(Token)match(input,54,FOLLOW_10); 

                    					newLeafNode(lv_proxy_0_0, grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    					}
                    					setWithLastConsumed(current, "proxy", true, "proxy");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2086:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:2087:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:2087:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:2088:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_56); 

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

            otherlv_2=(Token)match(input,55,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getHttpServerAceWriteAccess().getLessThanSignKeyword_2());
            		
            // InternalAceGen.g:2108:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2109:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2109:4: ( ruleQualifiedName )
            // InternalAceGen.g:2110:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_3_0());
            				
            pushFollow(FOLLOW_57);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,56,FOLLOW_58); 

            			newLeafNode(otherlv_4, grammarAccess.getHttpServerAceWriteAccess().getGreaterThanSignKeyword_4());
            		
            // InternalAceGen.g:2128:3: ( (lv_type_5_0= ruleWriteFunctionType ) )
            // InternalAceGen.g:2129:4: (lv_type_5_0= ruleWriteFunctionType )
            {
            // InternalAceGen.g:2129:4: (lv_type_5_0= ruleWriteFunctionType )
            // InternalAceGen.g:2130:5: lv_type_5_0= ruleWriteFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getTypeWriteFunctionTypeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_59);
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

            // InternalAceGen.g:2147:3: ( (lv_url_6_0= RULE_STRING ) )
            // InternalAceGen.g:2148:4: (lv_url_6_0= RULE_STRING )
            {
            // InternalAceGen.g:2148:4: (lv_url_6_0= RULE_STRING )
            // InternalAceGen.g:2149:5: lv_url_6_0= RULE_STRING
            {
            lv_url_6_0=(Token)match(input,RULE_STRING,FOLLOW_60); 

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

            // InternalAceGen.g:2165:3: ( (lv_authorize_7_0= 'authorize' ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==57) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalAceGen.g:2166:4: (lv_authorize_7_0= 'authorize' )
                    {
                    // InternalAceGen.g:2166:4: (lv_authorize_7_0= 'authorize' )
                    // InternalAceGen.g:2167:5: lv_authorize_7_0= 'authorize'
                    {
                    lv_authorize_7_0=(Token)match(input,57,FOLLOW_61); 

                    					newLeafNode(lv_authorize_7_0, grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    					}
                    					setWithLastConsumed(current, "authorize", true, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2179:3: (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==58) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalAceGen.g:2180:4: otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_8=(Token)match(input,58,FOLLOW_62); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:2184:4: ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==RULE_ID) ) {
                            int LA66_2 = input.LA(2);

                            if ( (LA66_2==EOF||LA66_2==RULE_ID||LA66_2==17||LA66_2==24||LA66_2==29||(LA66_2>=52 && LA66_2<=54)||(LA66_2>=59 && LA66_2<=60)||LA66_2==79) ) {
                                alt66=1;
                            }


                        }
                        else if ( (LA66_0==29) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalAceGen.g:2185:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2185:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2186:6: lv_pathParams_9_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeParamRefParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_62);
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
                    	    break loop66;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2204:3: (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==59) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalAceGen.g:2205:4: otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_10=(Token)match(input,59,FOLLOW_63); 

                    				newLeafNode(otherlv_10, grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_9_0());
                    			
                    // InternalAceGen.g:2209:4: ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==RULE_ID) ) {
                            int LA68_2 = input.LA(2);

                            if ( (LA68_2==EOF||LA68_2==RULE_ID||LA68_2==17||LA68_2==24||LA68_2==29||(LA68_2>=52 && LA68_2<=54)||LA68_2==60||LA68_2==79) ) {
                                alt68=1;
                            }


                        }
                        else if ( (LA68_0==29) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalAceGen.g:2210:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2210:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2211:6: lv_queryParams_11_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeParamRefParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_63);
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
                    	    break loop68;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2229:3: (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==60) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalAceGen.g:2230:4: otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_12=(Token)match(input,60,FOLLOW_64); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_10_0());
                    			
                    // InternalAceGen.g:2234:4: ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==RULE_ID) ) {
                            int LA70_2 = input.LA(2);

                            if ( (LA70_2==EOF||LA70_2==RULE_ID||LA70_2==17||LA70_2==24||LA70_2==29||(LA70_2>=52 && LA70_2<=54)||LA70_2==79) ) {
                                alt70=1;
                            }


                        }
                        else if ( (LA70_0==29) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalAceGen.g:2235:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2235:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2236:6: lv_payload_13_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeParamRefParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_64);
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
                    	    break loop70;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2254:3: ( (lv_outcomes_14_0= ruleHttpServerOutcome ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==24) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalAceGen.g:2255:4: (lv_outcomes_14_0= ruleHttpServerOutcome )
            	    {
            	    // InternalAceGen.g:2255:4: (lv_outcomes_14_0= ruleHttpServerOutcome )
            	    // InternalAceGen.g:2256:5: lv_outcomes_14_0= ruleHttpServerOutcome
            	    {

            	    					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getOutcomesHttpServerOutcomeParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_outcomes_14_0=ruleHttpServerOutcome();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHttpServerAceWriteRule());
            	    					}
            	    					add(
            	    						current,
            	    						"outcomes",
            	    						lv_outcomes_14_0,
            	    						"de.acegen.AceGen.HttpServerOutcome");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop72;
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
    // InternalAceGen.g:2277:1: entryRuleHttpServerOutcome returns [EObject current=null] : iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF ;
    public final EObject entryRuleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerOutcome = null;


        try {
            // InternalAceGen.g:2277:58: (iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF )
            // InternalAceGen.g:2278:2: iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF
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
    // InternalAceGen.g:2284:1: ruleHttpServerOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* ) ;
    public final EObject ruleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAceGen.g:2290:2: ( (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* ) )
            // InternalAceGen.g:2291:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* )
            {
            // InternalAceGen.g:2291:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* )
            // InternalAceGen.g:2292:3: otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )*
            {
            otherlv_0=(Token)match(input,24,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpServerOutcomeAccess().getOnKeyword_0());
            		
            // InternalAceGen.g:2296:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:2297:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:2297:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:2298:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_65); 

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

            // InternalAceGen.g:2314:3: (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==19) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalAceGen.g:2315:4: otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')'
            	    {
            	    otherlv_2=(Token)match(input,19,FOLLOW_21); 

            	    				newLeafNode(otherlv_2, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0());
            	    			
            	    // InternalAceGen.g:2319:4: ( ( ruleQualifiedName ) )*
            	    loop73:
            	    do {
            	        int alt73=2;
            	        int LA73_0 = input.LA(1);

            	        if ( (LA73_0==RULE_ID) ) {
            	            alt73=1;
            	        }


            	        switch (alt73) {
            	    	case 1 :
            	    	    // InternalAceGen.g:2320:5: ( ruleQualifiedName )
            	    	    {
            	    	    // InternalAceGen.g:2320:5: ( ruleQualifiedName )
            	    	    // InternalAceGen.g:2321:6: ruleQualifiedName
            	    	    {

            	    	    						if (current==null) {
            	    	    							current = createModelElement(grammarAccess.getHttpServerOutcomeRule());
            	    	    						}
            	    	    					

            	    	    						newCompositeNode(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0());
            	    	    					
            	    	    pushFollow(FOLLOW_21);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;


            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop73;
            	        }
            	    } while (true);

            	    otherlv_4=(Token)match(input,21,FOLLOW_65); 

            	    				newLeafNode(otherlv_4, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop74;
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
    // InternalAceGen.g:2344:1: entryRuleHttpServerAceRead returns [EObject current=null] : iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF ;
    public final EObject entryRuleHttpServerAceRead() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceRead = null;


        try {
            // InternalAceGen.g:2344:58: (iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF )
            // InternalAceGen.g:2345:2: iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF
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
    // InternalAceGen.g:2351:1: ruleHttpServerAceRead returns [EObject current=null] : ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ) ;
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
            // InternalAceGen.g:2357:2: ( ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ) )
            // InternalAceGen.g:2358:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? )
            {
            // InternalAceGen.g:2358:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? )
            // InternalAceGen.g:2359:3: ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )?
            {
            // InternalAceGen.g:2359:3: ( (lv_proxy_0_0= 'proxy' ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==54) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalAceGen.g:2360:4: (lv_proxy_0_0= 'proxy' )
                    {
                    // InternalAceGen.g:2360:4: (lv_proxy_0_0= 'proxy' )
                    // InternalAceGen.g:2361:5: lv_proxy_0_0= 'proxy'
                    {
                    lv_proxy_0_0=(Token)match(input,54,FOLLOW_10); 

                    					newLeafNode(lv_proxy_0_0, grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    					}
                    					setWithLastConsumed(current, "proxy", true, "proxy");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2373:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:2374:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:2374:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:2375:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_56); 

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

            otherlv_2=(Token)match(input,55,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getHttpServerAceReadAccess().getLessThanSignKeyword_2());
            		
            // InternalAceGen.g:2395:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2396:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2396:4: ( ruleQualifiedName )
            // InternalAceGen.g:2397:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_3_0());
            				
            pushFollow(FOLLOW_57);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,56,FOLLOW_66); 

            			newLeafNode(otherlv_4, grammarAccess.getHttpServerAceReadAccess().getGreaterThanSignKeyword_4());
            		
            // InternalAceGen.g:2415:3: ( (lv_type_5_0= ruleReadFunctionType ) )
            // InternalAceGen.g:2416:4: (lv_type_5_0= ruleReadFunctionType )
            {
            // InternalAceGen.g:2416:4: (lv_type_5_0= ruleReadFunctionType )
            // InternalAceGen.g:2417:5: lv_type_5_0= ruleReadFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getTypeReadFunctionTypeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_59);
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

            // InternalAceGen.g:2434:3: ( (lv_url_6_0= RULE_STRING ) )
            // InternalAceGen.g:2435:4: (lv_url_6_0= RULE_STRING )
            {
            // InternalAceGen.g:2435:4: (lv_url_6_0= RULE_STRING )
            // InternalAceGen.g:2436:5: lv_url_6_0= RULE_STRING
            {
            lv_url_6_0=(Token)match(input,RULE_STRING,FOLLOW_67); 

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

            // InternalAceGen.g:2452:3: ( (lv_authorize_7_0= 'authorize' ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==57) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalAceGen.g:2453:4: (lv_authorize_7_0= 'authorize' )
                    {
                    // InternalAceGen.g:2453:4: (lv_authorize_7_0= 'authorize' )
                    // InternalAceGen.g:2454:5: lv_authorize_7_0= 'authorize'
                    {
                    lv_authorize_7_0=(Token)match(input,57,FOLLOW_68); 

                    					newLeafNode(lv_authorize_7_0, grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    					}
                    					setWithLastConsumed(current, "authorize", true, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2466:3: (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==58) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalAceGen.g:2467:4: otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_8=(Token)match(input,58,FOLLOW_69); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:2471:4: ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==RULE_ID) ) {
                            int LA77_2 = input.LA(2);

                            if ( (LA77_2==EOF||LA77_2==RULE_ID||LA77_2==17||LA77_2==29||LA77_2==38||(LA77_2>=52 && LA77_2<=54)||(LA77_2>=59 && LA77_2<=60)||LA77_2==79) ) {
                                alt77=1;
                            }


                        }
                        else if ( (LA77_0==29) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // InternalAceGen.g:2472:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2472:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2473:6: lv_pathParams_9_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeParamRefParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_69);
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
                    	    break loop77;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2491:3: (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==59) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalAceGen.g:2492:4: otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_10=(Token)match(input,59,FOLLOW_70); 

                    				newLeafNode(otherlv_10, grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_9_0());
                    			
                    // InternalAceGen.g:2496:4: ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==RULE_ID) ) {
                            int LA79_2 = input.LA(2);

                            if ( (LA79_2==EOF||LA79_2==RULE_ID||LA79_2==17||LA79_2==29||LA79_2==38||(LA79_2>=52 && LA79_2<=54)||LA79_2==60||LA79_2==79) ) {
                                alt79=1;
                            }


                        }
                        else if ( (LA79_0==29) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // InternalAceGen.g:2497:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2497:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2498:6: lv_queryParams_11_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeParamRefParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_70);
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
                    	    break loop79;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2516:3: (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==60) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalAceGen.g:2517:4: otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_12=(Token)match(input,60,FOLLOW_71); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_10_0());
                    			
                    // InternalAceGen.g:2521:4: ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==RULE_ID) ) {
                            int LA81_2 = input.LA(2);

                            if ( (LA81_2==EOF||LA81_2==RULE_ID||LA81_2==17||LA81_2==29||LA81_2==38||(LA81_2>=52 && LA81_2<=54)||LA81_2==79) ) {
                                alt81=1;
                            }


                        }
                        else if ( (LA81_0==29) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // InternalAceGen.g:2522:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2522:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2523:6: lv_payload_13_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeParamRefParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_71);
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
                    	    break loop81;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2541:3: (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==38) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalAceGen.g:2542:4: otherlv_14= 'response' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_14=(Token)match(input,38,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_11_0());
                    			
                    // InternalAceGen.g:2546:4: ( ( ruleQualifiedName ) )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==RULE_ID) ) {
                            int LA83_2 = input.LA(2);

                            if ( (LA83_2==EOF||LA83_2==RULE_ID||LA83_2==17||(LA83_2>=52 && LA83_2<=54)||LA83_2==79) ) {
                                alt83=1;
                            }


                        }


                        switch (alt83) {
                    	case 1 :
                    	    // InternalAceGen.g:2547:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:2547:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:2548:6: ruleQualifiedName
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
                    	    break loop83;
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
    // InternalAceGen.g:2567:1: entryRuleAttributeParamRef returns [EObject current=null] : iv_ruleAttributeParamRef= ruleAttributeParamRef EOF ;
    public final EObject entryRuleAttributeParamRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeParamRef = null;


        try {
            // InternalAceGen.g:2567:58: (iv_ruleAttributeParamRef= ruleAttributeParamRef EOF )
            // InternalAceGen.g:2568:2: iv_ruleAttributeParamRef= ruleAttributeParamRef EOF
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
    // InternalAceGen.g:2574:1: ruleAttributeParamRef returns [EObject current=null] : ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleAttributeParamRef() throws RecognitionException {
        EObject current = null;

        Token lv_notNull_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:2580:2: ( ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:2581:2: ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:2581:2: ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:2582:3: ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:2582:3: ( (lv_notNull_0_0= 'NotNull' ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==29) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalAceGen.g:2583:4: (lv_notNull_0_0= 'NotNull' )
                    {
                    // InternalAceGen.g:2583:4: (lv_notNull_0_0= 'NotNull' )
                    // InternalAceGen.g:2584:5: lv_notNull_0_0= 'NotNull'
                    {
                    lv_notNull_0_0=(Token)match(input,29,FOLLOW_10); 

                    					newLeafNode(lv_notNull_0_0, grammarAccess.getAttributeParamRefAccess().getNotNullNotNullKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeParamRefRule());
                    					}
                    					setWithLastConsumed(current, "notNull", true, "NotNull");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2596:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2597:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2597:4: ( ruleQualifiedName )
            // InternalAceGen.g:2598:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeParamRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAttributeParamRefAccess().getAttributeAttributeCrossReference_1_0());
            				
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
    // $ANTLR end "ruleAttributeParamRef"


    // $ANTLR start "entryRuleHttpServerView"
    // InternalAceGen.g:2616:1: entryRuleHttpServerView returns [EObject current=null] : iv_ruleHttpServerView= ruleHttpServerView EOF ;
    public final EObject entryRuleHttpServerView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerView = null;


        try {
            // InternalAceGen.g:2616:55: (iv_ruleHttpServerView= ruleHttpServerView EOF )
            // InternalAceGen.g:2617:2: iv_ruleHttpServerView= ruleHttpServerView EOF
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
    // InternalAceGen.g:2623:1: ruleHttpServerView returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleHttpServerView() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_renderFunctions_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2629:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? ) )
            // InternalAceGen.g:2630:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? )
            {
            // InternalAceGen.g:2630:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? )
            // InternalAceGen.g:2631:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )?
            {
            // InternalAceGen.g:2631:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:2632:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:2632:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:2633:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_27); 

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

            // InternalAceGen.g:2649:3: (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==15) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalAceGen.g:2650:4: otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_72); 

                    				newLeafNode(otherlv_1, grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalAceGen.g:2654:4: ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==RULE_ID) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // InternalAceGen.g:2655:5: (lv_renderFunctions_2_0= ruleHttpServerViewFunction )
                    	    {
                    	    // InternalAceGen.g:2655:5: (lv_renderFunctions_2_0= ruleHttpServerViewFunction )
                    	    // InternalAceGen.g:2656:6: lv_renderFunctions_2_0= ruleHttpServerViewFunction
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerViewAccess().getRenderFunctionsHttpServerViewFunctionParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_72);
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
                    	    break loop86;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,16,FOLLOW_2); 

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
    // InternalAceGen.g:2682:1: entryRuleHttpServerViewFunction returns [EObject current=null] : iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF ;
    public final EObject entryRuleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerViewFunction = null;


        try {
            // InternalAceGen.g:2682:63: (iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF )
            // InternalAceGen.g:2683:2: iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF
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
    // InternalAceGen.g:2689:1: ruleHttpServerViewFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) ;
    public final EObject ruleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalAceGen.g:2695:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) )
            // InternalAceGen.g:2696:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            {
            // InternalAceGen.g:2696:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            // InternalAceGen.g:2697:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')'
            {
            // InternalAceGen.g:2697:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:2698:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:2698:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:2699:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            otherlv_1=(Token)match(input,19,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getHttpServerViewFunctionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:2719:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2720:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2720:4: ( ruleQualifiedName )
            // InternalAceGen.g:2721:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerViewFunctionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_73);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_2); 

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
    // InternalAceGen.g:2743:1: entryRuleAuthUser returns [EObject current=null] : iv_ruleAuthUser= ruleAuthUser EOF ;
    public final EObject entryRuleAuthUser() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthUser = null;


        try {
            // InternalAceGen.g:2743:49: (iv_ruleAuthUser= ruleAuthUser EOF )
            // InternalAceGen.g:2744:2: iv_ruleAuthUser= ruleAuthUser EOF
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
    // InternalAceGen.g:2750:1: ruleAuthUser returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) ;
    public final EObject ruleAuthUser() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2756:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) )
            // InternalAceGen.g:2757:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            {
            // InternalAceGen.g:2757:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            // InternalAceGen.g:2758:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            {
            // InternalAceGen.g:2758:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:2759:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:2759:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:2760:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_38); 

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

            // InternalAceGen.g:2776:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            // InternalAceGen.g:2777:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}'
            {
            otherlv_1=(Token)match(input,15,FOLLOW_74); 

            				newLeafNode(otherlv_1, grammarAccess.getAuthUserAccess().getLeftCurlyBracketKeyword_1_0());
            			
            // InternalAceGen.g:2781:4: ( (lv_attributes_2_0= ruleAttribute ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==RULE_ID||(LA88_0>=29 && LA88_0<=30)||(LA88_0>=75 && LA88_0<=76)||(LA88_0>=84 && LA88_0<=89)) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalAceGen.g:2782:5: (lv_attributes_2_0= ruleAttribute )
            	    {
            	    // InternalAceGen.g:2782:5: (lv_attributes_2_0= ruleAttribute )
            	    // InternalAceGen.g:2783:6: lv_attributes_2_0= ruleAttribute
            	    {

            	    						newCompositeNode(grammarAccess.getAuthUserAccess().getAttributesAttributeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_74);
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
            	    break loop88;
                }
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_2); 

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
    // InternalAceGen.g:2809:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAceGen.g:2809:46: (iv_ruleModel= ruleModel EOF )
            // InternalAceGen.g:2810:2: iv_ruleModel= ruleModel EOF
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
    // InternalAceGen.g:2816:1: ruleModel returns [EObject current=null] : ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) ;
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
            // InternalAceGen.g:2822:2: ( ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) )
            // InternalAceGen.g:2823:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            {
            // InternalAceGen.g:2823:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            // InternalAceGen.g:2824:3: ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            {
            // InternalAceGen.g:2824:3: ( (lv_persistent_0_0= 'persistent' ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==61) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalAceGen.g:2825:4: (lv_persistent_0_0= 'persistent' )
                    {
                    // InternalAceGen.g:2825:4: (lv_persistent_0_0= 'persistent' )
                    // InternalAceGen.g:2826:5: lv_persistent_0_0= 'persistent'
                    {
                    lv_persistent_0_0=(Token)match(input,61,FOLLOW_10); 

                    					newLeafNode(lv_persistent_0_0, grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(current, "persistent", true, "persistent");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2838:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:2839:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:2839:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:2840:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_75); 

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

            // InternalAceGen.g:2856:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==62) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalAceGen.g:2857:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_2=(Token)match(input,62,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getExtendsKeyword_2_0());
                    			
                    // InternalAceGen.g:2861:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:2862:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:2862:5: ( ruleQualifiedName )
                    // InternalAceGen.g:2863:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_76);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:2877:4: (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==20) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // InternalAceGen.g:2878:5: otherlv_4= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_10); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getModelAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:2882:5: ( ( ruleQualifiedName ) )
                    	    // InternalAceGen.g:2883:6: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:2883:6: ( ruleQualifiedName )
                    	    // InternalAceGen.g:2884:7: ruleQualifiedName
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModelRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_76);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop90;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2900:3: (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==15) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalAceGen.g:2901:4: otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_74); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalAceGen.g:2905:4: ( (lv_attributes_7_0= ruleAttribute ) )*
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==RULE_ID||(LA92_0>=29 && LA92_0<=30)||(LA92_0>=75 && LA92_0<=76)||(LA92_0>=84 && LA92_0<=89)) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                    	case 1 :
                    	    // InternalAceGen.g:2906:5: (lv_attributes_7_0= ruleAttribute )
                    	    {
                    	    // InternalAceGen.g:2906:5: (lv_attributes_7_0= ruleAttribute )
                    	    // InternalAceGen.g:2907:6: lv_attributes_7_0= ruleAttribute
                    	    {

                    	    						newCompositeNode(grammarAccess.getModelAccess().getAttributesAttributeParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_74);
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
                    	    break loop92;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,16,FOLLOW_2); 

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
    // InternalAceGen.g:2933:1: entryRuleScenario returns [EObject current=null] : iv_ruleScenario= ruleScenario EOF ;
    public final EObject entryRuleScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario = null;


        try {
            // InternalAceGen.g:2933:49: (iv_ruleScenario= ruleScenario EOF )
            // InternalAceGen.g:2934:2: iv_ruleScenario= ruleScenario EOF
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
    // InternalAceGen.g:2940:1: ruleScenario returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) ) ;
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
            // InternalAceGen.g:2946:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) ) )
            // InternalAceGen.g:2947:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) )
            {
            // InternalAceGen.g:2947:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) )
            // InternalAceGen.g:2948:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) )
            {
            // InternalAceGen.g:2948:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:2949:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:2949:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:2950:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_28); 

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

            // InternalAceGen.g:2966:3: (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )* )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==34) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalAceGen.g:2967:4: otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleGivenRef ) )*
                    {
                    otherlv_1=(Token)match(input,34,FOLLOW_29); 

                    				newLeafNode(otherlv_1, grammarAccess.getScenarioAccess().getGIVENKeyword_1_0());
                    			
                    // InternalAceGen.g:2971:4: ( (lv_givenRefs_2_0= ruleGivenRef ) )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==RULE_ID) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // InternalAceGen.g:2972:5: (lv_givenRefs_2_0= ruleGivenRef )
                    	    {
                    	    // InternalAceGen.g:2972:5: (lv_givenRefs_2_0= ruleGivenRef )
                    	    // InternalAceGen.g:2973:6: lv_givenRefs_2_0= ruleGivenRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getScenarioAccess().getGivenRefsGivenRefParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_29);
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
                    	    break loop94;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_3=(Token)match(input,35,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getScenarioAccess().getWHENKeyword_2());
            		
            // InternalAceGen.g:2995:3: ( (lv_whenBlock_4_0= ruleWhenBlock ) )
            // InternalAceGen.g:2996:4: (lv_whenBlock_4_0= ruleWhenBlock )
            {
            // InternalAceGen.g:2996:4: (lv_whenBlock_4_0= ruleWhenBlock )
            // InternalAceGen.g:2997:5: lv_whenBlock_4_0= ruleWhenBlock
            {

            					newCompositeNode(grammarAccess.getScenarioAccess().getWhenBlockWhenBlockParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_30);
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

            otherlv_5=(Token)match(input,36,FOLLOW_35); 

            			newLeafNode(otherlv_5, grammarAccess.getScenarioAccess().getTHENKeyword_4());
            		
            // InternalAceGen.g:3018:3: ( (lv_thenBlock_6_0= ruleThenBlock ) )
            // InternalAceGen.g:3019:4: (lv_thenBlock_6_0= ruleThenBlock )
            {
            // InternalAceGen.g:3019:4: (lv_thenBlock_6_0= ruleThenBlock )
            // InternalAceGen.g:3020:5: lv_thenBlock_6_0= ruleThenBlock
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
    // InternalAceGen.g:3041:1: entryRuleGivenRef returns [EObject current=null] : iv_ruleGivenRef= ruleGivenRef EOF ;
    public final EObject entryRuleGivenRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGivenRef = null;


        try {
            // InternalAceGen.g:3041:49: (iv_ruleGivenRef= ruleGivenRef EOF )
            // InternalAceGen.g:3042:2: iv_ruleGivenRef= ruleGivenRef EOF
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
    // InternalAceGen.g:3048:1: ruleGivenRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? ) ;
    public final EObject ruleGivenRef() throws RecognitionException {
        EObject current = null;

        Token lv_times_1_0=null;
        Token otherlv_2=null;
        Token lv_excludeGiven_3_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:3054:2: ( ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? ) )
            // InternalAceGen.g:3055:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? )
            {
            // InternalAceGen.g:3055:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? )
            // InternalAceGen.g:3056:3: ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )?
            {
            // InternalAceGen.g:3056:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3057:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3057:4: ( ruleQualifiedName )
            // InternalAceGen.g:3058:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGivenRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGivenRefAccess().getScenarioScenarioCrossReference_0_0());
            				
            pushFollow(FOLLOW_77);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3072:3: ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_INT) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalAceGen.g:3073:4: ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x'
                    {
                    // InternalAceGen.g:3073:4: ( (lv_times_1_0= RULE_INT ) )
                    // InternalAceGen.g:3074:5: (lv_times_1_0= RULE_INT )
                    {
                    // InternalAceGen.g:3074:5: (lv_times_1_0= RULE_INT )
                    // InternalAceGen.g:3075:6: lv_times_1_0= RULE_INT
                    {
                    lv_times_1_0=(Token)match(input,RULE_INT,FOLLOW_78); 

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

                    otherlv_2=(Token)match(input,63,FOLLOW_79); 

                    				newLeafNode(otherlv_2, grammarAccess.getGivenRefAccess().getXKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:3096:3: ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==64) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalAceGen.g:3097:4: (lv_excludeGiven_3_0= 'excludeGIVEN' )
                    {
                    // InternalAceGen.g:3097:4: (lv_excludeGiven_3_0= 'excludeGIVEN' )
                    // InternalAceGen.g:3098:5: lv_excludeGiven_3_0= 'excludeGIVEN'
                    {
                    lv_excludeGiven_3_0=(Token)match(input,64,FOLLOW_2); 

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
    // InternalAceGen.g:3114:1: entryRuleWhenBlock returns [EObject current=null] : iv_ruleWhenBlock= ruleWhenBlock EOF ;
    public final EObject entryRuleWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhenBlock = null;


        try {
            // InternalAceGen.g:3114:50: (iv_ruleWhenBlock= ruleWhenBlock EOF )
            // InternalAceGen.g:3115:2: iv_ruleWhenBlock= ruleWhenBlock EOF
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
    // InternalAceGen.g:3121:1: ruleWhenBlock returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ) ;
    public final EObject ruleWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_dataDefinition_1_0 = null;

        EObject lv_authorization_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3127:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ) )
            // InternalAceGen.g:3128:2: ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? )
            {
            // InternalAceGen.g:3128:2: ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? )
            // InternalAceGen.g:3129:3: ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )?
            {
            // InternalAceGen.g:3129:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3130:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3130:4: ( ruleQualifiedName )
            // InternalAceGen.g:3131:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWhenBlockRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWhenBlockAccess().getActionHttpServerAceCrossReference_0_0());
            				
            pushFollow(FOLLOW_80);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3145:3: ( (lv_dataDefinition_1_0= ruleDataDefinition ) )
            // InternalAceGen.g:3146:4: (lv_dataDefinition_1_0= ruleDataDefinition )
            {
            // InternalAceGen.g:3146:4: (lv_dataDefinition_1_0= ruleDataDefinition )
            // InternalAceGen.g:3147:5: lv_dataDefinition_1_0= ruleDataDefinition
            {

            					newCompositeNode(grammarAccess.getWhenBlockAccess().getDataDefinitionDataDefinitionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_81);
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

            // InternalAceGen.g:3164:3: ( (lv_authorization_2_0= ruleAuthorization ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==74) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalAceGen.g:3165:4: (lv_authorization_2_0= ruleAuthorization )
                    {
                    // InternalAceGen.g:3165:4: (lv_authorization_2_0= ruleAuthorization )
                    // InternalAceGen.g:3166:5: lv_authorization_2_0= ruleAuthorization
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
    // InternalAceGen.g:3187:1: entryRuleThenBlock returns [EObject current=null] : iv_ruleThenBlock= ruleThenBlock EOF ;
    public final EObject entryRuleThenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThenBlock = null;


        try {
            // InternalAceGen.g:3187:50: (iv_ruleThenBlock= ruleThenBlock EOF )
            // InternalAceGen.g:3188:2: iv_ruleThenBlock= ruleThenBlock EOF
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
    // InternalAceGen.g:3194:1: ruleThenBlock returns [EObject current=null] : ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? ) ;
    public final EObject ruleThenBlock() throws RecognitionException {
        EObject current = null;

        Token lv_statusCode_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_response_3_0 = null;

        EObject lv_persistenceVerifications_5_0 = null;

        EObject lv_verifications_7_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3200:2: ( ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? ) )
            // InternalAceGen.g:3201:2: ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? )
            {
            // InternalAceGen.g:3201:2: ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? )
            // InternalAceGen.g:3202:3: ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )?
            {
            // InternalAceGen.g:3202:3: ( (lv_statusCode_0_0= RULE_INT ) )
            // InternalAceGen.g:3203:4: (lv_statusCode_0_0= RULE_INT )
            {
            // InternalAceGen.g:3203:4: (lv_statusCode_0_0= RULE_INT )
            // InternalAceGen.g:3204:5: lv_statusCode_0_0= RULE_INT
            {
            lv_statusCode_0_0=(Token)match(input,RULE_INT,FOLLOW_82); 

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

            // InternalAceGen.g:3220:3: (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==38) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalAceGen.g:3221:4: otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) )
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_41); 

                    				newLeafNode(otherlv_1, grammarAccess.getThenBlockAccess().getResponseKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,43,FOLLOW_83); 

                    				newLeafNode(otherlv_2, grammarAccess.getThenBlockAccess().getShouldBeKeyword_1_1());
                    			
                    // InternalAceGen.g:3229:4: ( (lv_response_3_0= ruleDataDefinition ) )
                    // InternalAceGen.g:3230:5: (lv_response_3_0= ruleDataDefinition )
                    {
                    // InternalAceGen.g:3230:5: (lv_response_3_0= ruleDataDefinition )
                    // InternalAceGen.g:3231:6: lv_response_3_0= ruleDataDefinition
                    {

                    						newCompositeNode(grammarAccess.getThenBlockAccess().getResponseDataDefinitionParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_84);
                    lv_response_3_0=ruleDataDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getThenBlockRule());
                    						}
                    						set(
                    							current,
                    							"response",
                    							lv_response_3_0,
                    							"de.acegen.AceGen.DataDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:3249:3: (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==65) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalAceGen.g:3250:4: otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )*
                    {
                    otherlv_4=(Token)match(input,65,FOLLOW_85); 

                    				newLeafNode(otherlv_4, grammarAccess.getThenBlockAccess().getPersistenceKeyword_2_0());
                    			
                    // InternalAceGen.g:3254:4: ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )*
                    loop100:
                    do {
                        int alt100=2;
                        int LA100_0 = input.LA(1);

                        if ( (LA100_0==RULE_ID) ) {
                            int LA100_2 = input.LA(2);

                            if ( (LA100_2==RULE_ID) ) {
                                alt100=1;
                            }


                        }


                        switch (alt100) {
                    	case 1 :
                    	    // InternalAceGen.g:3255:5: (lv_persistenceVerifications_5_0= rulePersistenceVerification )
                    	    {
                    	    // InternalAceGen.g:3255:5: (lv_persistenceVerifications_5_0= rulePersistenceVerification )
                    	    // InternalAceGen.g:3256:6: lv_persistenceVerifications_5_0= rulePersistenceVerification
                    	    {

                    	    						newCompositeNode(grammarAccess.getThenBlockAccess().getPersistenceVerificationsPersistenceVerificationParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_85);
                    	    lv_persistenceVerifications_5_0=rulePersistenceVerification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getThenBlockRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"persistenceVerifications",
                    	    							lv_persistenceVerifications_5_0,
                    	    							"de.acegen.AceGen.PersistenceVerification");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop100;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:3274:3: (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==66) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // InternalAceGen.g:3275:4: otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )*
                    {
                    otherlv_6=(Token)match(input,66,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getThenBlockAccess().getVerificationsKeyword_3_0());
                    			
                    // InternalAceGen.g:3279:4: ( (lv_verifications_7_0= ruleVerification ) )*
                    loop102:
                    do {
                        int alt102=2;
                        int LA102_0 = input.LA(1);

                        if ( (LA102_0==RULE_ID) ) {
                            int LA102_2 = input.LA(2);

                            if ( (LA102_2==EOF||LA102_2==RULE_ID) ) {
                                alt102=1;
                            }


                        }


                        switch (alt102) {
                    	case 1 :
                    	    // InternalAceGen.g:3280:5: (lv_verifications_7_0= ruleVerification )
                    	    {
                    	    // InternalAceGen.g:3280:5: (lv_verifications_7_0= ruleVerification )
                    	    // InternalAceGen.g:3281:6: lv_verifications_7_0= ruleVerification
                    	    {

                    	    						newCompositeNode(grammarAccess.getThenBlockAccess().getVerificationsVerificationParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_3);
                    	    lv_verifications_7_0=ruleVerification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getThenBlockRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"verifications",
                    	    							lv_verifications_7_0,
                    	    							"de.acegen.AceGen.Verification");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop102;
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
    // $ANTLR end "ruleThenBlock"


    // $ANTLR start "entryRulePersistenceVerification"
    // InternalAceGen.g:3303:1: entryRulePersistenceVerification returns [EObject current=null] : iv_rulePersistenceVerification= rulePersistenceVerification EOF ;
    public final EObject entryRulePersistenceVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersistenceVerification = null;


        try {
            // InternalAceGen.g:3303:64: (iv_rulePersistenceVerification= rulePersistenceVerification EOF )
            // InternalAceGen.g:3304:2: iv_rulePersistenceVerification= rulePersistenceVerification EOF
            {
             newCompositeNode(grammarAccess.getPersistenceVerificationRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePersistenceVerification=rulePersistenceVerification();

            state._fsp--;

             current =iv_rulePersistenceVerification; 
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
    // $ANTLR end "entryRulePersistenceVerification"


    // $ANTLR start "rulePersistenceVerification"
    // InternalAceGen.g:3310:1: rulePersistenceVerification returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) ) ;
    public final EObject rulePersistenceVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3316:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) ) )
            // InternalAceGen.g:3317:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) )
            {
            // InternalAceGen.g:3317:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) )
            // InternalAceGen.g:3318:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) )
            {
            // InternalAceGen.g:3318:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3319:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3319:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3320:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPersistenceVerificationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPersistenceVerificationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:3336:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3337:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3337:4: ( ruleQualifiedName )
            // InternalAceGen.g:3338:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPersistenceVerificationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPersistenceVerificationAccess().getModelModelCrossReference_1_0());
            				
            pushFollow(FOLLOW_86);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3352:3: ( (lv_expression_2_0= rulePersistenceVerificationExpression ) )
            // InternalAceGen.g:3353:4: (lv_expression_2_0= rulePersistenceVerificationExpression )
            {
            // InternalAceGen.g:3353:4: (lv_expression_2_0= rulePersistenceVerificationExpression )
            // InternalAceGen.g:3354:5: lv_expression_2_0= rulePersistenceVerificationExpression
            {

            					newCompositeNode(grammarAccess.getPersistenceVerificationAccess().getExpressionPersistenceVerificationExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_expression_2_0=rulePersistenceVerificationExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPersistenceVerificationRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_2_0,
            						"de.acegen.AceGen.PersistenceVerificationExpression");
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
    // $ANTLR end "rulePersistenceVerification"


    // $ANTLR start "entryRulePersistenceVerificationExpression"
    // InternalAceGen.g:3375:1: entryRulePersistenceVerificationExpression returns [EObject current=null] : iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF ;
    public final EObject entryRulePersistenceVerificationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersistenceVerificationExpression = null;


        try {
            // InternalAceGen.g:3375:74: (iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF )
            // InternalAceGen.g:3376:2: iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF
            {
             newCompositeNode(grammarAccess.getPersistenceVerificationExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePersistenceVerificationExpression=rulePersistenceVerificationExpression();

            state._fsp--;

             current =iv_rulePersistenceVerificationExpression; 
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
    // $ANTLR end "entryRulePersistenceVerificationExpression"


    // $ANTLR start "rulePersistenceVerificationExpression"
    // InternalAceGen.g:3382:1: rulePersistenceVerificationExpression returns [EObject current=null] : (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount ) ;
    public final EObject rulePersistenceVerificationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_SelectByUniqueAttribute_0 = null;

        EObject this_SelectByPrimaryKeys_1 = null;

        EObject this_Count_2 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3388:2: ( (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount ) )
            // InternalAceGen.g:3389:2: (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount )
            {
            // InternalAceGen.g:3389:2: (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount )
            int alt104=3;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt104=1;
                }
                break;
            case 67:
                {
                alt104=2;
                }
                break;
            case 69:
                {
                alt104=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // InternalAceGen.g:3390:3: this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute
                    {

                    			newCompositeNode(grammarAccess.getPersistenceVerificationExpressionAccess().getSelectByUniqueAttributeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SelectByUniqueAttribute_0=ruleSelectByUniqueAttribute();

                    state._fsp--;


                    			current = this_SelectByUniqueAttribute_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:3399:3: this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys
                    {

                    			newCompositeNode(grammarAccess.getPersistenceVerificationExpressionAccess().getSelectByPrimaryKeysParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SelectByPrimaryKeys_1=ruleSelectByPrimaryKeys();

                    state._fsp--;


                    			current = this_SelectByPrimaryKeys_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:3408:3: this_Count_2= ruleCount
                    {

                    			newCompositeNode(grammarAccess.getPersistenceVerificationExpressionAccess().getCountParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Count_2=ruleCount();

                    state._fsp--;


                    			current = this_Count_2;
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
    // $ANTLR end "rulePersistenceVerificationExpression"


    // $ANTLR start "entryRuleSelectByPrimaryKeys"
    // InternalAceGen.g:3420:1: entryRuleSelectByPrimaryKeys returns [EObject current=null] : iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF ;
    public final EObject entryRuleSelectByPrimaryKeys() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByPrimaryKeys = null;


        try {
            // InternalAceGen.g:3420:60: (iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF )
            // InternalAceGen.g:3421:2: iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF
            {
             newCompositeNode(grammarAccess.getSelectByPrimaryKeysRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelectByPrimaryKeys=ruleSelectByPrimaryKeys();

            state._fsp--;

             current =iv_ruleSelectByPrimaryKeys; 
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
    // $ANTLR end "entryRuleSelectByPrimaryKeys"


    // $ANTLR start "ruleSelectByPrimaryKeys"
    // InternalAceGen.g:3427:1: ruleSelectByPrimaryKeys returns [EObject current=null] : (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) ) ;
    public final EObject ruleSelectByPrimaryKeys() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_attributeAndValues_2_0 = null;

        EObject lv_attributeAndValues_4_0 = null;

        EObject lv_expected_7_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3433:2: ( (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) ) )
            // InternalAceGen.g:3434:2: (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) )
            {
            // InternalAceGen.g:3434:2: (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) )
            // InternalAceGen.g:3435:3: otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getSelectByPrimaryKeysAccess().getSelectByPrimaryKeyKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectByPrimaryKeysAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:3443:3: ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:3444:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:3444:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:3445:5: lv_attributeAndValues_2_0= ruleAttributeAndValue
            {

            					newCompositeNode(grammarAccess.getSelectByPrimaryKeysAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
            lv_attributeAndValues_2_0=ruleAttributeAndValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSelectByPrimaryKeysRule());
            					}
            					add(
            						current,
            						"attributeAndValues",
            						lv_attributeAndValues_2_0,
            						"de.acegen.AceGen.AttributeAndValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3462:3: (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==20) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalAceGen.g:3463:4: otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_21); 

                    				newLeafNode(otherlv_3, grammarAccess.getSelectByPrimaryKeysAccess().getCommaKeyword_3_0());
                    			
                    // InternalAceGen.g:3467:4: ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( (LA105_0==RULE_ID) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // InternalAceGen.g:3468:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    {
                    	    // InternalAceGen.g:3468:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    // InternalAceGen.g:3469:6: lv_attributeAndValues_4_0= ruleAttributeAndValue
                    	    {

                    	    						newCompositeNode(grammarAccess.getSelectByPrimaryKeysAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_21);
                    	    lv_attributeAndValues_4_0=ruleAttributeAndValue();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSelectByPrimaryKeysRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"attributeAndValues",
                    	    							lv_attributeAndValues_4_0,
                    	    							"de.acegen.AceGen.AttributeAndValue");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop105;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,21,FOLLOW_41); 

            			newLeafNode(otherlv_5, grammarAccess.getSelectByPrimaryKeysAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,43,FOLLOW_87); 

            			newLeafNode(otherlv_6, grammarAccess.getSelectByPrimaryKeysAccess().getShouldBeKeyword_5());
            		
            // InternalAceGen.g:3495:3: ( (lv_expected_7_0= ruleSelectByExpectation ) )
            // InternalAceGen.g:3496:4: (lv_expected_7_0= ruleSelectByExpectation )
            {
            // InternalAceGen.g:3496:4: (lv_expected_7_0= ruleSelectByExpectation )
            // InternalAceGen.g:3497:5: lv_expected_7_0= ruleSelectByExpectation
            {

            					newCompositeNode(grammarAccess.getSelectByPrimaryKeysAccess().getExpectedSelectByExpectationParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_expected_7_0=ruleSelectByExpectation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSelectByPrimaryKeysRule());
            					}
            					set(
            						current,
            						"expected",
            						lv_expected_7_0,
            						"de.acegen.AceGen.SelectByExpectation");
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
    // $ANTLR end "ruleSelectByPrimaryKeys"


    // $ANTLR start "entryRuleSelectByUniqueAttribute"
    // InternalAceGen.g:3518:1: entryRuleSelectByUniqueAttribute returns [EObject current=null] : iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF ;
    public final EObject entryRuleSelectByUniqueAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByUniqueAttribute = null;


        try {
            // InternalAceGen.g:3518:64: (iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF )
            // InternalAceGen.g:3519:2: iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF
            {
             newCompositeNode(grammarAccess.getSelectByUniqueAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelectByUniqueAttribute=ruleSelectByUniqueAttribute();

            state._fsp--;

             current =iv_ruleSelectByUniqueAttribute; 
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
    // $ANTLR end "entryRuleSelectByUniqueAttribute"


    // $ANTLR start "ruleSelectByUniqueAttribute"
    // InternalAceGen.g:3525:1: ruleSelectByUniqueAttribute returns [EObject current=null] : (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) ) ;
    public final EObject ruleSelectByUniqueAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_attributeAndValue_2_0 = null;

        EObject lv_expected_5_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3531:2: ( (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) ) )
            // InternalAceGen.g:3532:2: (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) )
            {
            // InternalAceGen.g:3532:2: (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) )
            // InternalAceGen.g:3533:3: otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getSelectByUniqueAttributeAccess().getSelectByKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectByUniqueAttributeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:3541:3: ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:3542:4: (lv_attributeAndValue_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:3542:4: (lv_attributeAndValue_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:3543:5: lv_attributeAndValue_2_0= ruleAttributeAndValue
            {

            					newCompositeNode(grammarAccess.getSelectByUniqueAttributeAccess().getAttributeAndValueAttributeAndValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_73);
            lv_attributeAndValue_2_0=ruleAttributeAndValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSelectByUniqueAttributeRule());
            					}
            					set(
            						current,
            						"attributeAndValue",
            						lv_attributeAndValue_2_0,
            						"de.acegen.AceGen.AttributeAndValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getSelectByUniqueAttributeAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,43,FOLLOW_87); 

            			newLeafNode(otherlv_4, grammarAccess.getSelectByUniqueAttributeAccess().getShouldBeKeyword_4());
            		
            // InternalAceGen.g:3568:3: ( (lv_expected_5_0= ruleSelectByExpectation ) )
            // InternalAceGen.g:3569:4: (lv_expected_5_0= ruleSelectByExpectation )
            {
            // InternalAceGen.g:3569:4: (lv_expected_5_0= ruleSelectByExpectation )
            // InternalAceGen.g:3570:5: lv_expected_5_0= ruleSelectByExpectation
            {

            					newCompositeNode(grammarAccess.getSelectByUniqueAttributeAccess().getExpectedSelectByExpectationParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_expected_5_0=ruleSelectByExpectation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSelectByUniqueAttributeRule());
            					}
            					set(
            						current,
            						"expected",
            						lv_expected_5_0,
            						"de.acegen.AceGen.SelectByExpectation");
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
    // $ANTLR end "ruleSelectByUniqueAttribute"


    // $ANTLR start "entryRuleCount"
    // InternalAceGen.g:3591:1: entryRuleCount returns [EObject current=null] : iv_ruleCount= ruleCount EOF ;
    public final EObject entryRuleCount() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCount = null;


        try {
            // InternalAceGen.g:3591:46: (iv_ruleCount= ruleCount EOF )
            // InternalAceGen.g:3592:2: iv_ruleCount= ruleCount EOF
            {
             newCompositeNode(grammarAccess.getCountRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCount=ruleCount();

            state._fsp--;

             current =iv_ruleCount; 
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
    // $ANTLR end "entryRuleCount"


    // $ANTLR start "ruleCount"
    // InternalAceGen.g:3598:1: ruleCount returns [EObject current=null] : (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) ) ;
    public final EObject ruleCount() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_expected_7_0=null;
        EObject lv_attributeAndValues_2_0 = null;

        EObject lv_attributeAndValues_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3604:2: ( (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) ) )
            // InternalAceGen.g:3605:2: (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) )
            {
            // InternalAceGen.g:3605:2: (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) )
            // InternalAceGen.g:3606:3: otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,69,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getCountAccess().getFilterAndCountByKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getCountAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:3614:3: ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:3615:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:3615:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:3616:5: lv_attributeAndValues_2_0= ruleAttributeAndValue
            {

            					newCompositeNode(grammarAccess.getCountAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
            lv_attributeAndValues_2_0=ruleAttributeAndValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCountRule());
            					}
            					add(
            						current,
            						"attributeAndValues",
            						lv_attributeAndValues_2_0,
            						"de.acegen.AceGen.AttributeAndValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3633:3: (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==20) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalAceGen.g:3634:4: otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_21); 

                    				newLeafNode(otherlv_3, grammarAccess.getCountAccess().getCommaKeyword_3_0());
                    			
                    // InternalAceGen.g:3638:4: ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    loop107:
                    do {
                        int alt107=2;
                        int LA107_0 = input.LA(1);

                        if ( (LA107_0==RULE_ID) ) {
                            alt107=1;
                        }


                        switch (alt107) {
                    	case 1 :
                    	    // InternalAceGen.g:3639:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    {
                    	    // InternalAceGen.g:3639:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    // InternalAceGen.g:3640:6: lv_attributeAndValues_4_0= ruleAttributeAndValue
                    	    {

                    	    						newCompositeNode(grammarAccess.getCountAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_21);
                    	    lv_attributeAndValues_4_0=ruleAttributeAndValue();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCountRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"attributeAndValues",
                    	    							lv_attributeAndValues_4_0,
                    	    							"de.acegen.AceGen.AttributeAndValue");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop107;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,21,FOLLOW_41); 

            			newLeafNode(otherlv_5, grammarAccess.getCountAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,43,FOLLOW_35); 

            			newLeafNode(otherlv_6, grammarAccess.getCountAccess().getShouldBeKeyword_5());
            		
            // InternalAceGen.g:3666:3: ( (lv_expected_7_0= RULE_INT ) )
            // InternalAceGen.g:3667:4: (lv_expected_7_0= RULE_INT )
            {
            // InternalAceGen.g:3667:4: (lv_expected_7_0= RULE_INT )
            // InternalAceGen.g:3668:5: lv_expected_7_0= RULE_INT
            {
            lv_expected_7_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_expected_7_0, grammarAccess.getCountAccess().getExpectedINTTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCountRule());
            					}
            					setWithLastConsumed(
            						current,
            						"expected",
            						lv_expected_7_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // $ANTLR end "ruleCount"


    // $ANTLR start "entryRuleAttributeAndValue"
    // InternalAceGen.g:3688:1: entryRuleAttributeAndValue returns [EObject current=null] : iv_ruleAttributeAndValue= ruleAttributeAndValue EOF ;
    public final EObject entryRuleAttributeAndValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeAndValue = null;


        try {
            // InternalAceGen.g:3688:58: (iv_ruleAttributeAndValue= ruleAttributeAndValue EOF )
            // InternalAceGen.g:3689:2: iv_ruleAttributeAndValue= ruleAttributeAndValue EOF
            {
             newCompositeNode(grammarAccess.getAttributeAndValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeAndValue=ruleAttributeAndValue();

            state._fsp--;

             current =iv_ruleAttributeAndValue; 
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
    // $ANTLR end "entryRuleAttributeAndValue"


    // $ANTLR start "ruleAttributeAndValue"
    // InternalAceGen.g:3695:1: ruleAttributeAndValue returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject ruleAttributeAndValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3701:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalAceGen.g:3702:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalAceGen.g:3702:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalAceGen.g:3703:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalAceGen.g:3703:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3704:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3704:4: ( ruleQualifiedName )
            // InternalAceGen.g:3705:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeAndValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAttributeAndValueAccess().getAttributeAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_36);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_37); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeAndValueAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:3723:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalAceGen.g:3724:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalAceGen.g:3724:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalAceGen.g:3725:5: lv_value_2_0= rulePrimitiveValue
            {

            					newCompositeNode(grammarAccess.getAttributeAndValueAccess().getValuePrimitiveValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=rulePrimitiveValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeAndValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"de.acegen.AceGen.PrimitiveValue");
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
    // $ANTLR end "ruleAttributeAndValue"


    // $ANTLR start "entryRuleVerification"
    // InternalAceGen.g:3746:1: entryRuleVerification returns [EObject current=null] : iv_ruleVerification= ruleVerification EOF ;
    public final EObject entryRuleVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerification = null;


        try {
            // InternalAceGen.g:3746:53: (iv_ruleVerification= ruleVerification EOF )
            // InternalAceGen.g:3747:2: iv_ruleVerification= ruleVerification EOF
            {
             newCompositeNode(grammarAccess.getVerificationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVerification=ruleVerification();

            state._fsp--;

             current =iv_ruleVerification; 
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
    // $ANTLR end "entryRuleVerification"


    // $ANTLR start "ruleVerification"
    // InternalAceGen.g:3753:1: ruleVerification returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:3759:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalAceGen.g:3760:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalAceGen.g:3760:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3761:3: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3761:3: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3762:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getVerificationAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVerificationRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // $ANTLR end "ruleVerification"


    // $ANTLR start "entryRuleSelectByExpectation"
    // InternalAceGen.g:3781:1: entryRuleSelectByExpectation returns [EObject current=null] : iv_ruleSelectByExpectation= ruleSelectByExpectation EOF ;
    public final EObject entryRuleSelectByExpectation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByExpectation = null;


        try {
            // InternalAceGen.g:3781:60: (iv_ruleSelectByExpectation= ruleSelectByExpectation EOF )
            // InternalAceGen.g:3782:2: iv_ruleSelectByExpectation= ruleSelectByExpectation EOF
            {
             newCompositeNode(grammarAccess.getSelectByExpectationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelectByExpectation=ruleSelectByExpectation();

            state._fsp--;

             current =iv_ruleSelectByExpectation; 
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
    // $ANTLR end "entryRuleSelectByExpectation"


    // $ANTLR start "ruleSelectByExpectation"
    // InternalAceGen.g:3788:1: ruleSelectByExpectation returns [EObject current=null] : ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) ) ;
    public final EObject ruleSelectByExpectation() throws RecognitionException {
        EObject current = null;

        Token lv_isNotNull_1_0=null;
        Token lv_isNull_2_0=null;
        EObject lv_object_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3794:2: ( ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) ) )
            // InternalAceGen.g:3795:2: ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) )
            {
            // InternalAceGen.g:3795:2: ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) )
            int alt109=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt109=1;
                }
                break;
            case 70:
                {
                alt109=2;
                }
                break;
            case 71:
                {
                alt109=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }

            switch (alt109) {
                case 1 :
                    // InternalAceGen.g:3796:3: ( (lv_object_0_0= ruleJsonObject ) )
                    {
                    // InternalAceGen.g:3796:3: ( (lv_object_0_0= ruleJsonObject ) )
                    // InternalAceGen.g:3797:4: (lv_object_0_0= ruleJsonObject )
                    {
                    // InternalAceGen.g:3797:4: (lv_object_0_0= ruleJsonObject )
                    // InternalAceGen.g:3798:5: lv_object_0_0= ruleJsonObject
                    {

                    					newCompositeNode(grammarAccess.getSelectByExpectationAccess().getObjectJsonObjectParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_object_0_0=ruleJsonObject();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSelectByExpectationRule());
                    					}
                    					set(
                    						current,
                    						"object",
                    						lv_object_0_0,
                    						"de.acegen.AceGen.JsonObject");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:3816:3: ( (lv_isNotNull_1_0= 'notNull' ) )
                    {
                    // InternalAceGen.g:3816:3: ( (lv_isNotNull_1_0= 'notNull' ) )
                    // InternalAceGen.g:3817:4: (lv_isNotNull_1_0= 'notNull' )
                    {
                    // InternalAceGen.g:3817:4: (lv_isNotNull_1_0= 'notNull' )
                    // InternalAceGen.g:3818:5: lv_isNotNull_1_0= 'notNull'
                    {
                    lv_isNotNull_1_0=(Token)match(input,70,FOLLOW_2); 

                    					newLeafNode(lv_isNotNull_1_0, grammarAccess.getSelectByExpectationAccess().getIsNotNullNotNullKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSelectByExpectationRule());
                    					}
                    					setWithLastConsumed(current, "isNotNull", true, "notNull");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:3831:3: ( (lv_isNull_2_0= 'null' ) )
                    {
                    // InternalAceGen.g:3831:3: ( (lv_isNull_2_0= 'null' ) )
                    // InternalAceGen.g:3832:4: (lv_isNull_2_0= 'null' )
                    {
                    // InternalAceGen.g:3832:4: (lv_isNull_2_0= 'null' )
                    // InternalAceGen.g:3833:5: lv_isNull_2_0= 'null'
                    {
                    lv_isNull_2_0=(Token)match(input,71,FOLLOW_2); 

                    					newLeafNode(lv_isNull_2_0, grammarAccess.getSelectByExpectationAccess().getIsNullNullKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSelectByExpectationRule());
                    					}
                    					setWithLastConsumed(current, "isNull", true, "null");
                    				

                    }


                    }


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
    // $ANTLR end "ruleSelectByExpectation"


    // $ANTLR start "entryRuleDataDefinition"
    // InternalAceGen.g:3849:1: entryRuleDataDefinition returns [EObject current=null] : iv_ruleDataDefinition= ruleDataDefinition EOF ;
    public final EObject entryRuleDataDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDefinition = null;


        try {
            // InternalAceGen.g:3849:55: (iv_ruleDataDefinition= ruleDataDefinition EOF )
            // InternalAceGen.g:3850:2: iv_ruleDataDefinition= ruleDataDefinition EOF
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
    // InternalAceGen.g:3856:1: ruleDataDefinition returns [EObject current=null] : ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? ) ;
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
            // InternalAceGen.g:3862:2: ( ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? ) )
            // InternalAceGen.g:3863:2: ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? )
            {
            // InternalAceGen.g:3863:2: ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? )
            // InternalAceGen.g:3864:3: () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )?
            {
            // InternalAceGen.g:3864:3: ()
            // InternalAceGen.g:3865:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataDefinitionAccess().getDataDefinitionAction_0(),
            					current);
            			

            }

            // InternalAceGen.g:3871:3: (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==72) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalAceGen.g:3872:4: otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,72,FOLLOW_59); 

                    				newLeafNode(otherlv_1, grammarAccess.getDataDefinitionAccess().getUuidKeyword_1_0());
                    			
                    // InternalAceGen.g:3876:4: ( (lv_uuid_2_0= RULE_STRING ) )
                    // InternalAceGen.g:3877:5: (lv_uuid_2_0= RULE_STRING )
                    {
                    // InternalAceGen.g:3877:5: (lv_uuid_2_0= RULE_STRING )
                    // InternalAceGen.g:3878:6: lv_uuid_2_0= RULE_STRING
                    {
                    lv_uuid_2_0=(Token)match(input,RULE_STRING,FOLLOW_88); 

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

            // InternalAceGen.g:3895:3: (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==73) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // InternalAceGen.g:3896:4: otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,73,FOLLOW_59); 

                    				newLeafNode(otherlv_3, grammarAccess.getDataDefinitionAccess().getSystemTimeKeyword_2_0());
                    			
                    // InternalAceGen.g:3900:4: ( (lv_systemtime_4_0= RULE_STRING ) )
                    // InternalAceGen.g:3901:5: (lv_systemtime_4_0= RULE_STRING )
                    {
                    // InternalAceGen.g:3901:5: (lv_systemtime_4_0= RULE_STRING )
                    // InternalAceGen.g:3902:6: lv_systemtime_4_0= RULE_STRING
                    {
                    lv_systemtime_4_0=(Token)match(input,RULE_STRING,FOLLOW_59); 

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

                    // InternalAceGen.g:3918:4: ( (lv_pattern_5_0= RULE_STRING ) )
                    // InternalAceGen.g:3919:5: (lv_pattern_5_0= RULE_STRING )
                    {
                    // InternalAceGen.g:3919:5: (lv_pattern_5_0= RULE_STRING )
                    // InternalAceGen.g:3920:6: lv_pattern_5_0= RULE_STRING
                    {
                    lv_pattern_5_0=(Token)match(input,RULE_STRING,FOLLOW_27); 

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

            // InternalAceGen.g:3937:3: ( (lv_data_6_0= ruleJsonObject ) )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==15) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalAceGen.g:3938:4: (lv_data_6_0= ruleJsonObject )
                    {
                    // InternalAceGen.g:3938:4: (lv_data_6_0= ruleJsonObject )
                    // InternalAceGen.g:3939:5: lv_data_6_0= ruleJsonObject
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
    // InternalAceGen.g:3960:1: entryRuleAuthorization returns [EObject current=null] : iv_ruleAuthorization= ruleAuthorization EOF ;
    public final EObject entryRuleAuthorization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthorization = null;


        try {
            // InternalAceGen.g:3960:54: (iv_ruleAuthorization= ruleAuthorization EOF )
            // InternalAceGen.g:3961:2: iv_ruleAuthorization= ruleAuthorization EOF
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
    // InternalAceGen.g:3967:1: ruleAuthorization returns [EObject current=null] : (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleAuthorization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_username_1_0=null;
        Token otherlv_2=null;
        Token lv_password_3_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:3973:2: ( (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) ) )
            // InternalAceGen.g:3974:2: (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) )
            {
            // InternalAceGen.g:3974:2: (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) )
            // InternalAceGen.g:3975:3: otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_59); 

            			newLeafNode(otherlv_0, grammarAccess.getAuthorizationAccess().getAuthorizationKeyword_0());
            		
            // InternalAceGen.g:3979:3: ( (lv_username_1_0= RULE_STRING ) )
            // InternalAceGen.g:3980:4: (lv_username_1_0= RULE_STRING )
            {
            // InternalAceGen.g:3980:4: (lv_username_1_0= RULE_STRING )
            // InternalAceGen.g:3981:5: lv_username_1_0= RULE_STRING
            {
            lv_username_1_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

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

            otherlv_2=(Token)match(input,39,FOLLOW_59); 

            			newLeafNode(otherlv_2, grammarAccess.getAuthorizationAccess().getColonKeyword_2());
            		
            // InternalAceGen.g:4001:3: ( (lv_password_3_0= RULE_STRING ) )
            // InternalAceGen.g:4002:4: (lv_password_3_0= RULE_STRING )
            {
            // InternalAceGen.g:4002:4: (lv_password_3_0= RULE_STRING )
            // InternalAceGen.g:4003:5: lv_password_3_0= RULE_STRING
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
    // InternalAceGen.g:4023:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalAceGen.g:4023:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalAceGen.g:4024:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalAceGen.g:4030:1: ruleAttribute returns [EObject current=null] : ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_notReplayable_9_0= 'notReplayable' ) )? ) ;
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
            // InternalAceGen.g:4036:2: ( ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_notReplayable_9_0= 'notReplayable' ) )? ) )
            // InternalAceGen.g:4037:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_notReplayable_9_0= 'notReplayable' ) )? )
            {
            // InternalAceGen.g:4037:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_notReplayable_9_0= 'notReplayable' ) )? )
            // InternalAceGen.g:4038:3: ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_notReplayable_9_0= 'notReplayable' ) )?
            {
            // InternalAceGen.g:4038:3: ( (lv_unique_0_0= 'Unique' ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==75) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // InternalAceGen.g:4039:4: (lv_unique_0_0= 'Unique' )
                    {
                    // InternalAceGen.g:4039:4: (lv_unique_0_0= 'Unique' )
                    // InternalAceGen.g:4040:5: lv_unique_0_0= 'Unique'
                    {
                    lv_unique_0_0=(Token)match(input,75,FOLLOW_89); 

                    					newLeafNode(lv_unique_0_0, grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "unique", true, "Unique");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4052:3: ( (lv_primaryKey_1_0= 'PrimaryKey' ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==76) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalAceGen.g:4053:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    {
                    // InternalAceGen.g:4053:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    // InternalAceGen.g:4054:5: lv_primaryKey_1_0= 'PrimaryKey'
                    {
                    lv_primaryKey_1_0=(Token)match(input,76,FOLLOW_90); 

                    					newLeafNode(lv_primaryKey_1_0, grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "primaryKey", true, "PrimaryKey");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4066:3: ( (lv_notNull_2_0= 'NotNull' ) )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==29) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // InternalAceGen.g:4067:4: (lv_notNull_2_0= 'NotNull' )
                    {
                    // InternalAceGen.g:4067:4: (lv_notNull_2_0= 'NotNull' )
                    // InternalAceGen.g:4068:5: lv_notNull_2_0= 'NotNull'
                    {
                    lv_notNull_2_0=(Token)match(input,29,FOLLOW_22); 

                    					newLeafNode(lv_notNull_2_0, grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "notNull", true, "NotNull");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4080:3: ( (lv_list_3_0= 'List' ) )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==30) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalAceGen.g:4081:4: (lv_list_3_0= 'List' )
                    {
                    // InternalAceGen.g:4081:4: (lv_list_3_0= 'List' )
                    // InternalAceGen.g:4082:5: lv_list_3_0= 'List'
                    {
                    lv_list_3_0=(Token)match(input,30,FOLLOW_23); 

                    					newLeafNode(lv_list_3_0, grammarAccess.getAttributeAccess().getListListKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "list", true, "List");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4094:3: ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( ((LA117_0>=84 && LA117_0<=89)) ) {
                alt117=1;
            }
            else if ( (LA117_0==RULE_ID) ) {
                alt117=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }
            switch (alt117) {
                case 1 :
                    // InternalAceGen.g:4095:4: ( (lv_type_4_0= ruleType ) )
                    {
                    // InternalAceGen.g:4095:4: ( (lv_type_4_0= ruleType ) )
                    // InternalAceGen.g:4096:5: (lv_type_4_0= ruleType )
                    {
                    // InternalAceGen.g:4096:5: (lv_type_4_0= ruleType )
                    // InternalAceGen.g:4097:6: lv_type_4_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getAttributeAccess().getTypeTypeParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_10);
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
                    // InternalAceGen.g:4115:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalAceGen.g:4115:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:4116:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:4116:5: ( ruleQualifiedName )
                    // InternalAceGen.g:4117:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getModelModelCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:4132:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalAceGen.g:4133:4: (lv_name_6_0= RULE_ID )
            {
            // InternalAceGen.g:4133:4: (lv_name_6_0= RULE_ID )
            // InternalAceGen.g:4134:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_91); 

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

            // InternalAceGen.g:4150:3: (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==77) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // InternalAceGen.g:4151:4: otherlv_7= 'references' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,77,FOLLOW_10); 

                    				newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getReferencesKeyword_6_0());
                    			
                    // InternalAceGen.g:4155:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:4156:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:4156:5: ( ruleQualifiedName )
                    // InternalAceGen.g:4157:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_92);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:4172:3: ( (lv_notReplayable_9_0= 'notReplayable' ) )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==78) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalAceGen.g:4173:4: (lv_notReplayable_9_0= 'notReplayable' )
                    {
                    // InternalAceGen.g:4173:4: (lv_notReplayable_9_0= 'notReplayable' )
                    // InternalAceGen.g:4174:5: lv_notReplayable_9_0= 'notReplayable'
                    {
                    lv_notReplayable_9_0=(Token)match(input,78,FOLLOW_2); 

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
    // InternalAceGen.g:4190:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalAceGen.g:4190:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalAceGen.g:4191:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalAceGen.g:4197:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalAceGen.g:4203:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalAceGen.g:4204:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalAceGen.g:4204:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalAceGen.g:4205:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_93); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalAceGen.g:4212:3: (kw= '.' this_ID_2= RULE_ID )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==79) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // InternalAceGen.g:4213:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,79,FOLLOW_10); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_93); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop120;
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
    // InternalAceGen.g:4230:1: entryRuleWriteFunctionType returns [String current=null] : iv_ruleWriteFunctionType= ruleWriteFunctionType EOF ;
    public final String entryRuleWriteFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWriteFunctionType = null;


        try {
            // InternalAceGen.g:4230:57: (iv_ruleWriteFunctionType= ruleWriteFunctionType EOF )
            // InternalAceGen.g:4231:2: iv_ruleWriteFunctionType= ruleWriteFunctionType EOF
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
    // InternalAceGen.g:4237:1: ruleWriteFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) ;
    public final AntlrDatatypeRuleToken ruleWriteFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:4243:2: ( (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) )
            // InternalAceGen.g:4244:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            {
            // InternalAceGen.g:4244:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            int alt121=3;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt121=1;
                }
                break;
            case 81:
                {
                alt121=2;
                }
                break;
            case 82:
                {
                alt121=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }

            switch (alt121) {
                case 1 :
                    // InternalAceGen.g:4245:3: kw= 'POST'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:4251:3: kw= 'PUT'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:4257:3: kw= 'DELETE'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

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
    // InternalAceGen.g:4266:1: entryRuleReadFunctionType returns [String current=null] : iv_ruleReadFunctionType= ruleReadFunctionType EOF ;
    public final String entryRuleReadFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReadFunctionType = null;


        try {
            // InternalAceGen.g:4266:56: (iv_ruleReadFunctionType= ruleReadFunctionType EOF )
            // InternalAceGen.g:4267:2: iv_ruleReadFunctionType= ruleReadFunctionType EOF
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
    // InternalAceGen.g:4273:1: ruleReadFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'GET' ;
    public final AntlrDatatypeRuleToken ruleReadFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:4279:2: (kw= 'GET' )
            // InternalAceGen.g:4280:2: kw= 'GET'
            {
            kw=(Token)match(input,83,FOLLOW_2); 

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
    // InternalAceGen.g:4288:1: entryRuleType returns [String current=null] : iv_ruleType= ruleType EOF ;
    public final String entryRuleType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType = null;


        try {
            // InternalAceGen.g:4288:44: (iv_ruleType= ruleType EOF )
            // InternalAceGen.g:4289:2: iv_ruleType= ruleType EOF
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
    // InternalAceGen.g:4295:1: ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' ) ;
    public final AntlrDatatypeRuleToken ruleType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:4301:2: ( (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' ) )
            // InternalAceGen.g:4302:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' )
            {
            // InternalAceGen.g:4302:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' )
            int alt122=6;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt122=1;
                }
                break;
            case 85:
                {
                alt122=2;
                }
                break;
            case 86:
                {
                alt122=3;
                }
                break;
            case 87:
                {
                alt122=4;
                }
                break;
            case 88:
                {
                alt122=5;
                }
                break;
            case 89:
                {
                alt122=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }

            switch (alt122) {
                case 1 :
                    // InternalAceGen.g:4303:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getIntegerKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:4309:3: kw= 'String'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getStringKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:4315:3: kw= 'Float'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getFloatKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAceGen.g:4321:3: kw= 'Boolean'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getBooleanKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalAceGen.g:4327:3: kw= 'DateTime'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getDateTimeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalAceGen.g:4333:3: kw= 'Long'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); 

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
    // InternalAceGen.g:4342:1: entryRuleJsonDateTime returns [EObject current=null] : iv_ruleJsonDateTime= ruleJsonDateTime EOF ;
    public final EObject entryRuleJsonDateTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonDateTime = null;


        try {
            // InternalAceGen.g:4342:53: (iv_ruleJsonDateTime= ruleJsonDateTime EOF )
            // InternalAceGen.g:4343:2: iv_ruleJsonDateTime= ruleJsonDateTime EOF
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
    // InternalAceGen.g:4349:1: ruleJsonDateTime returns [EObject current=null] : ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleJsonDateTime() throws RecognitionException {
        EObject current = null;

        Token lv_dateTime_0_0=null;
        Token lv_pattern_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4355:2: ( ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) ) )
            // InternalAceGen.g:4356:2: ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) )
            {
            // InternalAceGen.g:4356:2: ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) )
            // InternalAceGen.g:4357:3: ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) )
            {
            // InternalAceGen.g:4357:3: ( (lv_dateTime_0_0= RULE_STRING ) )
            // InternalAceGen.g:4358:4: (lv_dateTime_0_0= RULE_STRING )
            {
            // InternalAceGen.g:4358:4: (lv_dateTime_0_0= RULE_STRING )
            // InternalAceGen.g:4359:5: lv_dateTime_0_0= RULE_STRING
            {
            lv_dateTime_0_0=(Token)match(input,RULE_STRING,FOLLOW_59); 

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

            // InternalAceGen.g:4375:3: ( (lv_pattern_1_0= RULE_STRING ) )
            // InternalAceGen.g:4376:4: (lv_pattern_1_0= RULE_STRING )
            {
            // InternalAceGen.g:4376:4: (lv_pattern_1_0= RULE_STRING )
            // InternalAceGen.g:4377:5: lv_pattern_1_0= RULE_STRING
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
    // InternalAceGen.g:4397:1: entryRuleJsonObject returns [EObject current=null] : iv_ruleJsonObject= ruleJsonObject EOF ;
    public final EObject entryRuleJsonObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObject = null;


        try {
            // InternalAceGen.g:4397:51: (iv_ruleJsonObject= ruleJsonObject EOF )
            // InternalAceGen.g:4398:2: iv_ruleJsonObject= ruleJsonObject EOF
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
    // InternalAceGen.g:4404:1: ruleJsonObject returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleJsonObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_members_2_0 = null;

        EObject lv_members_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4410:2: ( ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' ) )
            // InternalAceGen.g:4411:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' )
            {
            // InternalAceGen.g:4411:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' )
            // InternalAceGen.g:4412:3: () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}'
            {
            // InternalAceGen.g:4412:3: ()
            // InternalAceGen.g:4413:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonObjectAccess().getJsonObjectAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonObjectAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:4423:3: ( (lv_members_2_0= ruleJsonMember ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==RULE_ID) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalAceGen.g:4424:4: (lv_members_2_0= ruleJsonMember )
                    {
                    // InternalAceGen.g:4424:4: (lv_members_2_0= ruleJsonMember )
                    // InternalAceGen.g:4425:5: lv_members_2_0= ruleJsonMember
                    {

                    					newCompositeNode(grammarAccess.getJsonObjectAccess().getMembersJsonMemberParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_44);
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

            // InternalAceGen.g:4442:3: (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )*
            loop124:
            do {
                int alt124=2;
                int LA124_0 = input.LA(1);

                if ( (LA124_0==20) ) {
                    alt124=1;
                }


                switch (alt124) {
            	case 1 :
            	    // InternalAceGen.g:4443:4: otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_10); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonObjectAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:4447:4: ( (lv_members_4_0= ruleJsonMember ) )
            	    // InternalAceGen.g:4448:5: (lv_members_4_0= ruleJsonMember )
            	    {
            	    // InternalAceGen.g:4448:5: (lv_members_4_0= ruleJsonMember )
            	    // InternalAceGen.g:4449:6: lv_members_4_0= ruleJsonMember
            	    {

            	    						newCompositeNode(grammarAccess.getJsonObjectAccess().getMembersJsonMemberParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	    break loop124;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

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
    // InternalAceGen.g:4475:1: entryRuleJsonMember returns [EObject current=null] : iv_ruleJsonMember= ruleJsonMember EOF ;
    public final EObject entryRuleJsonMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonMember = null;


        try {
            // InternalAceGen.g:4475:51: (iv_ruleJsonMember= ruleJsonMember EOF )
            // InternalAceGen.g:4476:2: iv_ruleJsonMember= ruleJsonMember EOF
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
    // InternalAceGen.g:4482:1: ruleJsonMember returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) ) ;
    public final EObject ruleJsonMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4488:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) ) )
            // InternalAceGen.g:4489:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) )
            {
            // InternalAceGen.g:4489:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) )
            // InternalAceGen.g:4490:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) )
            {
            // InternalAceGen.g:4490:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:4491:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:4491:4: ( ruleQualifiedName )
            // InternalAceGen.g:4492:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonMemberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJsonMemberAccess().getAttributeAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_36);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_42); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonMemberAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:4510:3: ( (lv_value_2_0= ruleJsonValue ) )
            // InternalAceGen.g:4511:4: (lv_value_2_0= ruleJsonValue )
            {
            // InternalAceGen.g:4511:4: (lv_value_2_0= ruleJsonValue )
            // InternalAceGen.g:4512:5: lv_value_2_0= ruleJsonValue
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
    // InternalAceGen.g:4533:1: entryRuleJsonValue returns [EObject current=null] : iv_ruleJsonValue= ruleJsonValue EOF ;
    public final EObject entryRuleJsonValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonValue = null;


        try {
            // InternalAceGen.g:4533:50: (iv_ruleJsonValue= ruleJsonValue EOF )
            // InternalAceGen.g:4534:2: iv_ruleJsonValue= ruleJsonValue EOF
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
    // InternalAceGen.g:4540:1: ruleJsonValue returns [EObject current=null] : (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime ) ;
    public final EObject ruleJsonValue() throws RecognitionException {
        EObject current = null;

        EObject this_JsonObject_0 = null;

        EObject this_StringType_1 = null;

        EObject this_JsonArray_2 = null;

        EObject this_BooleanType_3 = null;

        EObject this_NullType_4 = null;

        EObject this_LongType_5 = null;

        EObject this_JsonDateTime_6 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4546:2: ( (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime ) )
            // InternalAceGen.g:4547:2: (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime )
            {
            // InternalAceGen.g:4547:2: (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime )
            int alt125=7;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt125=1;
                }
                break;
            case RULE_STRING:
                {
                int LA125_2 = input.LA(2);

                if ( (LA125_2==EOF||LA125_2==16||LA125_2==20||LA125_2==45) ) {
                    alt125=2;
                }
                else if ( (LA125_2==RULE_STRING) ) {
                    alt125=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 125, 2, input);

                    throw nvae;
                }
                }
                break;
            case 44:
                {
                alt125=3;
                }
                break;
            case 90:
            case 91:
                {
                alt125=4;
                }
                break;
            case 71:
                {
                alt125=5;
                }
                break;
            case RULE_INT:
                {
                alt125=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;
            }

            switch (alt125) {
                case 1 :
                    // InternalAceGen.g:4548:3: this_JsonObject_0= ruleJsonObject
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
                    // InternalAceGen.g:4557:3: this_StringType_1= ruleStringType
                    {

                    			newCompositeNode(grammarAccess.getJsonValueAccess().getStringTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringType_1=ruleStringType();

                    state._fsp--;


                    			current = this_StringType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:4566:3: this_JsonArray_2= ruleJsonArray
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
                    // InternalAceGen.g:4575:3: this_BooleanType_3= ruleBooleanType
                    {

                    			newCompositeNode(grammarAccess.getJsonValueAccess().getBooleanTypeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanType_3=ruleBooleanType();

                    state._fsp--;


                    			current = this_BooleanType_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalAceGen.g:4584:3: this_NullType_4= ruleNullType
                    {

                    			newCompositeNode(grammarAccess.getJsonValueAccess().getNullTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_NullType_4=ruleNullType();

                    state._fsp--;


                    			current = this_NullType_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalAceGen.g:4593:3: this_LongType_5= ruleLongType
                    {

                    			newCompositeNode(grammarAccess.getJsonValueAccess().getLongTypeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_LongType_5=ruleLongType();

                    state._fsp--;


                    			current = this_LongType_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalAceGen.g:4602:3: this_JsonDateTime_6= ruleJsonDateTime
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
    // InternalAceGen.g:4614:1: entryRuleJsonArray returns [EObject current=null] : iv_ruleJsonArray= ruleJsonArray EOF ;
    public final EObject entryRuleJsonArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonArray = null;


        try {
            // InternalAceGen.g:4614:50: (iv_ruleJsonArray= ruleJsonArray EOF )
            // InternalAceGen.g:4615:2: iv_ruleJsonArray= ruleJsonArray EOF
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
    // InternalAceGen.g:4621:1: ruleJsonArray returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleJsonArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4627:2: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' ) )
            // InternalAceGen.g:4628:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' )
            {
            // InternalAceGen.g:4628:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' )
            // InternalAceGen.g:4629:3: () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']'
            {
            // InternalAceGen.g:4629:3: ()
            // InternalAceGen.g:4630:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonArrayAccess().getJsonArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,44,FOLLOW_45); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonArrayAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalAceGen.g:4640:3: ( (lv_values_2_0= ruleJsonValue ) )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( ((LA126_0>=RULE_INT && LA126_0<=RULE_STRING)||LA126_0==15||LA126_0==44||LA126_0==71||(LA126_0>=90 && LA126_0<=91)) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalAceGen.g:4641:4: (lv_values_2_0= ruleJsonValue )
                    {
                    // InternalAceGen.g:4641:4: (lv_values_2_0= ruleJsonValue )
                    // InternalAceGen.g:4642:5: lv_values_2_0= ruleJsonValue
                    {

                    					newCompositeNode(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_46);
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

            // InternalAceGen.g:4659:3: (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )*
            loop127:
            do {
                int alt127=2;
                int LA127_0 = input.LA(1);

                if ( (LA127_0==20) ) {
                    alt127=1;
                }


                switch (alt127) {
            	case 1 :
            	    // InternalAceGen.g:4660:4: otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_42); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonArrayAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:4664:4: ( (lv_values_4_0= ruleJsonValue ) )
            	    // InternalAceGen.g:4665:5: (lv_values_4_0= ruleJsonValue )
            	    {
            	    // InternalAceGen.g:4665:5: (lv_values_4_0= ruleJsonValue )
            	    // InternalAceGen.g:4666:6: lv_values_4_0= ruleJsonValue
            	    {

            	    						newCompositeNode(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    break loop127;
                }
            } while (true);

            otherlv_5=(Token)match(input,45,FOLLOW_2); 

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


    // $ANTLR start "entryRuleStringType"
    // InternalAceGen.g:4692:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // InternalAceGen.g:4692:51: (iv_ruleStringType= ruleStringType EOF )
            // InternalAceGen.g:4693:2: iv_ruleStringType= ruleStringType EOF
            {
             newCompositeNode(grammarAccess.getStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringType=ruleStringType();

            state._fsp--;

             current =iv_ruleStringType; 
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
    // $ANTLR end "entryRuleStringType"


    // $ANTLR start "ruleStringType"
    // InternalAceGen.g:4699:1: ruleStringType returns [EObject current=null] : ( (lv_string_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringType() throws RecognitionException {
        EObject current = null;

        Token lv_string_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4705:2: ( ( (lv_string_0_0= RULE_STRING ) ) )
            // InternalAceGen.g:4706:2: ( (lv_string_0_0= RULE_STRING ) )
            {
            // InternalAceGen.g:4706:2: ( (lv_string_0_0= RULE_STRING ) )
            // InternalAceGen.g:4707:3: (lv_string_0_0= RULE_STRING )
            {
            // InternalAceGen.g:4707:3: (lv_string_0_0= RULE_STRING )
            // InternalAceGen.g:4708:4: lv_string_0_0= RULE_STRING
            {
            lv_string_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_string_0_0, grammarAccess.getStringTypeAccess().getStringSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringTypeRule());
            				}
            				setWithLastConsumed(
            					current,
            					"string",
            					lv_string_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

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
    // $ANTLR end "ruleStringType"


    // $ANTLR start "entryRuleBooleanType"
    // InternalAceGen.g:4727:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // InternalAceGen.g:4727:52: (iv_ruleBooleanType= ruleBooleanType EOF )
            // InternalAceGen.g:4728:2: iv_ruleBooleanType= ruleBooleanType EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanType=ruleBooleanType();

            state._fsp--;

             current =iv_ruleBooleanType; 
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
    // $ANTLR end "entryRuleBooleanType"


    // $ANTLR start "ruleBooleanType"
    // InternalAceGen.g:4734:1: ruleBooleanType returns [EObject current=null] : ( (lv_boolean_0_0= ruleJsonBoolean ) ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_boolean_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4740:2: ( ( (lv_boolean_0_0= ruleJsonBoolean ) ) )
            // InternalAceGen.g:4741:2: ( (lv_boolean_0_0= ruleJsonBoolean ) )
            {
            // InternalAceGen.g:4741:2: ( (lv_boolean_0_0= ruleJsonBoolean ) )
            // InternalAceGen.g:4742:3: (lv_boolean_0_0= ruleJsonBoolean )
            {
            // InternalAceGen.g:4742:3: (lv_boolean_0_0= ruleJsonBoolean )
            // InternalAceGen.g:4743:4: lv_boolean_0_0= ruleJsonBoolean
            {

            				newCompositeNode(grammarAccess.getBooleanTypeAccess().getBooleanJsonBooleanParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_boolean_0_0=ruleJsonBoolean();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getBooleanTypeRule());
            				}
            				set(
            					current,
            					"boolean",
            					lv_boolean_0_0,
            					"de.acegen.AceGen.JsonBoolean");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleBooleanType"


    // $ANTLR start "entryRuleNullType"
    // InternalAceGen.g:4763:1: entryRuleNullType returns [EObject current=null] : iv_ruleNullType= ruleNullType EOF ;
    public final EObject entryRuleNullType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullType = null;


        try {
            // InternalAceGen.g:4763:49: (iv_ruleNullType= ruleNullType EOF )
            // InternalAceGen.g:4764:2: iv_ruleNullType= ruleNullType EOF
            {
             newCompositeNode(grammarAccess.getNullTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNullType=ruleNullType();

            state._fsp--;

             current =iv_ruleNullType; 
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
    // $ANTLR end "entryRuleNullType"


    // $ANTLR start "ruleNullType"
    // InternalAceGen.g:4770:1: ruleNullType returns [EObject current=null] : ( (lv_null_0_0= ruleJsonNull ) ) ;
    public final EObject ruleNullType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_null_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4776:2: ( ( (lv_null_0_0= ruleJsonNull ) ) )
            // InternalAceGen.g:4777:2: ( (lv_null_0_0= ruleJsonNull ) )
            {
            // InternalAceGen.g:4777:2: ( (lv_null_0_0= ruleJsonNull ) )
            // InternalAceGen.g:4778:3: (lv_null_0_0= ruleJsonNull )
            {
            // InternalAceGen.g:4778:3: (lv_null_0_0= ruleJsonNull )
            // InternalAceGen.g:4779:4: lv_null_0_0= ruleJsonNull
            {

            				newCompositeNode(grammarAccess.getNullTypeAccess().getNullJsonNullParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_null_0_0=ruleJsonNull();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getNullTypeRule());
            				}
            				set(
            					current,
            					"null",
            					lv_null_0_0,
            					"de.acegen.AceGen.JsonNull");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleNullType"


    // $ANTLR start "entryRuleLongType"
    // InternalAceGen.g:4799:1: entryRuleLongType returns [EObject current=null] : iv_ruleLongType= ruleLongType EOF ;
    public final EObject entryRuleLongType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongType = null;


        try {
            // InternalAceGen.g:4799:49: (iv_ruleLongType= ruleLongType EOF )
            // InternalAceGen.g:4800:2: iv_ruleLongType= ruleLongType EOF
            {
             newCompositeNode(grammarAccess.getLongTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLongType=ruleLongType();

            state._fsp--;

             current =iv_ruleLongType; 
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
    // $ANTLR end "entryRuleLongType"


    // $ANTLR start "ruleLongType"
    // InternalAceGen.g:4806:1: ruleLongType returns [EObject current=null] : ( (lv_long_0_0= RULE_INT ) ) ;
    public final EObject ruleLongType() throws RecognitionException {
        EObject current = null;

        Token lv_long_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4812:2: ( ( (lv_long_0_0= RULE_INT ) ) )
            // InternalAceGen.g:4813:2: ( (lv_long_0_0= RULE_INT ) )
            {
            // InternalAceGen.g:4813:2: ( (lv_long_0_0= RULE_INT ) )
            // InternalAceGen.g:4814:3: (lv_long_0_0= RULE_INT )
            {
            // InternalAceGen.g:4814:3: (lv_long_0_0= RULE_INT )
            // InternalAceGen.g:4815:4: lv_long_0_0= RULE_INT
            {
            lv_long_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_long_0_0, grammarAccess.getLongTypeAccess().getLongINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getLongTypeRule());
            				}
            				setWithLastConsumed(
            					current,
            					"long",
            					lv_long_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

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
    // $ANTLR end "ruleLongType"


    // $ANTLR start "entryRuleJsonBoolean"
    // InternalAceGen.g:4834:1: entryRuleJsonBoolean returns [String current=null] : iv_ruleJsonBoolean= ruleJsonBoolean EOF ;
    public final String entryRuleJsonBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleJsonBoolean = null;


        try {
            // InternalAceGen.g:4834:51: (iv_ruleJsonBoolean= ruleJsonBoolean EOF )
            // InternalAceGen.g:4835:2: iv_ruleJsonBoolean= ruleJsonBoolean EOF
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
    // InternalAceGen.g:4841:1: ruleJsonBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleJsonBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:4847:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalAceGen.g:4848:2: (kw= 'true' | kw= 'false' )
            {
            // InternalAceGen.g:4848:2: (kw= 'true' | kw= 'false' )
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==90) ) {
                alt128=1;
            }
            else if ( (LA128_0==91) ) {
                alt128=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }
            switch (alt128) {
                case 1 :
                    // InternalAceGen.g:4849:3: kw= 'true'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJsonBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:4855:3: kw= 'false'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); 

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
    // InternalAceGen.g:4864:1: entryRuleJsonNull returns [String current=null] : iv_ruleJsonNull= ruleJsonNull EOF ;
    public final String entryRuleJsonNull() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleJsonNull = null;


        try {
            // InternalAceGen.g:4864:48: (iv_ruleJsonNull= ruleJsonNull EOF )
            // InternalAceGen.g:4865:2: iv_ruleJsonNull= ruleJsonNull EOF
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
    // InternalAceGen.g:4871:1: ruleJsonNull returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'null' ;
    public final AntlrDatatypeRuleToken ruleJsonNull() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:4877:2: (kw= 'null' )
            // InternalAceGen.g:4878:2: kw= 'null'
            {
            kw=(Token)match(input,71,FOLLOW_2); 

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


    // $ANTLR start "entryRulePrimitiveValue"
    // InternalAceGen.g:4886:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalAceGen.g:4886:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalAceGen.g:4887:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveValueRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveValue=rulePrimitiveValue();

            state._fsp--;

             current =iv_rulePrimitiveValue; 
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
    // $ANTLR end "entryRulePrimitiveValue"


    // $ANTLR start "rulePrimitiveValue"
    // InternalAceGen.g:4893:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_string_0_0=null;
        Token lv_long_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4899:2: ( ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) ) )
            // InternalAceGen.g:4900:2: ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) )
            {
            // InternalAceGen.g:4900:2: ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) )
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==RULE_STRING) ) {
                alt129=1;
            }
            else if ( (LA129_0==RULE_INT) ) {
                alt129=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;
            }
            switch (alt129) {
                case 1 :
                    // InternalAceGen.g:4901:3: ( (lv_string_0_0= RULE_STRING ) )
                    {
                    // InternalAceGen.g:4901:3: ( (lv_string_0_0= RULE_STRING ) )
                    // InternalAceGen.g:4902:4: (lv_string_0_0= RULE_STRING )
                    {
                    // InternalAceGen.g:4902:4: (lv_string_0_0= RULE_STRING )
                    // InternalAceGen.g:4903:5: lv_string_0_0= RULE_STRING
                    {
                    lv_string_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    					newLeafNode(lv_string_0_0, grammarAccess.getPrimitiveValueAccess().getStringSTRINGTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"string",
                    						lv_string_0_0,
                    						"org.eclipse.xtext.common.Terminals.STRING");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalAceGen.g:4920:3: ( (lv_long_1_0= RULE_INT ) )
                    {
                    // InternalAceGen.g:4920:3: ( (lv_long_1_0= RULE_INT ) )
                    // InternalAceGen.g:4921:4: (lv_long_1_0= RULE_INT )
                    {
                    // InternalAceGen.g:4921:4: (lv_long_1_0= RULE_INT )
                    // InternalAceGen.g:4922:5: lv_long_1_0= RULE_INT
                    {
                    lv_long_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    					newLeafNode(lv_long_1_0, grammarAccess.getPrimitiveValueAccess().getLongINTTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveValueRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"long",
                    						lv_long_1_0,
                    						"org.eclipse.xtext.common.Terminals.INT");
                    				

                    }


                    }


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
    // $ANTLR end "rulePrimitiveValue"

    // Delegated rules


    protected DFA63 dfa63 = new DFA63(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\2\4\1\67\1\4\1\70\1\4\1\120\1\70\2\uffff";
    static final String dfa_3s = "\1\66\1\4\1\67\1\4\1\117\1\4\1\123\1\117\2\uffff";
    static final String dfa_4s = "\10\uffff\1\1\1\2";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\61\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\26\uffff\1\5",
            "\1\7",
            "\3\10\1\11",
            "\1\6\26\uffff\1\5",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "2035:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000026002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000064012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000060010010L,0x0000000003F00000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001C84002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001C04002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001C00002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002080002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000001C200000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000010L,0x0000000003F00000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000010L,0x0000000003F00000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000380008002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000300008002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000200008002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000070000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000080002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000040000000012L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000100000008060L,0x000000000C000080L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000110010L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000300000108060L,0x000000000C000080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000200000100000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0003800000000010L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0003000000000010L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0002000000000010L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x003C000000022002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0038000000022002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0030000000022002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0070000000020012L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0020000000020012L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x2000000000020012L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000070000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x1E00000001000002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x1C00000001000002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x1800000021000012L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x1000000021000012L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000021000012L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x1E00004000000002L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x1C00004000000002L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x1800004020000012L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x1000004020000012L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000004020000012L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000060010010L,0x0000000003F01800L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x4000000000008002L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000108002L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000022L,0x0000000000000001L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000700L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000306L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000004L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000008000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000008002L,0x0000000000000200L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000060000010L,0x0000000003F01000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000060000010L,0x0000000003F00000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000002L,0x0000000000006000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});

}