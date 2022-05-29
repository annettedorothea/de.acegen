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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'HttpClient'", "'HttpServer'", "'ACE'", "'ui'", "'JSX'", "'scenarios'", "'async'", "'('", "','", "')'", "'fromAppState'", "'call'", "'loadingFlag'", "'as'", "'on'", "'triggers'", "'delayInMillis'", "'takeLatest'", "'set'", "'merge'", "'noComponent'", "'List'", "'location'", "'storage'", "'{'", "'actions'", "'}'", "'GIVEN'", "'AND'", "'WHEN'", "'THEN'", "'exclude'", "'squishyValues'", "'uuid'", "'clientSystemTime'", "'serverSystemTime'", "'squishy'", "':'", "'expectedState'", "'verifications'", "'should'", "'not'", "'be'", "'['", "']'", "'Java'", "'C#'", "'Dropwizard'", "'NET6'", "'JDBI3'", "'EntityFramework'", "'Liquibase'", "'Authorization'", "'import'", "'views'", "'models'", "'<'", "'>'", "'authorize'", "'multipartFormData'", "'pathParams'", "'queryParams'", "'payload'", "'response'", "'NotNull'", "'afterCommit'", "'persistent'", "'extends'", "'x'", "'shouldBe'", "'persistence'", "'selectByPrimaryKey'", "'selectBy'", "'filterAndCountBy'", "'extract'", "'notNull'", "'null'", "'systemTime'", "'authorization'", "'Unique'", "'PrimaryKey'", "'references'", "'.'", "'POST'", "'PUT'", "'DELETE'", "'GET'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'Long'", "'FormData'", "'json'", "'undefined'", "'true'", "'false'"
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
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
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
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

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

                    if ( (LA2_0==RULE_ID||(LA2_0>=56 && LA2_0<=62)) ) {
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
    // InternalAceGen.g:150:1: ruleHttpClient returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'ui' ( (lv_jsx_4_0= 'JSX' ) )? ( (lv_container_5_0= ruleClientAttribute ) ) )? (otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )* )? ) ;
    public final EObject ruleHttpClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_jsx_4_0=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_aceOperations_2_0 = null;

        EObject lv_container_5_0 = null;

        EObject lv_scenarios_7_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:156:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'ui' ( (lv_jsx_4_0= 'JSX' ) )? ( (lv_container_5_0= ruleClientAttribute ) ) )? (otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )* )? ) )
            // InternalAceGen.g:157:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'ui' ( (lv_jsx_4_0= 'JSX' ) )? ( (lv_container_5_0= ruleClientAttribute ) ) )? (otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )* )? )
            {
            // InternalAceGen.g:157:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'ui' ( (lv_jsx_4_0= 'JSX' ) )? ( (lv_container_5_0= ruleClientAttribute ) ) )? (otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )* )? )
            // InternalAceGen.g:158:3: ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'ui' ( (lv_jsx_4_0= 'JSX' ) )? ( (lv_container_5_0= ruleClientAttribute ) ) )? (otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )* )?
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

                        if ( (LA4_0==RULE_ID||LA4_0==17) ) {
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

            // InternalAceGen.g:202:3: (otherlv_3= 'ui' ( (lv_jsx_4_0= 'JSX' ) )? ( (lv_container_5_0= ruleClientAttribute ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAceGen.g:203:4: otherlv_3= 'ui' ( (lv_jsx_4_0= 'JSX' ) )? ( (lv_container_5_0= ruleClientAttribute ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getHttpClientAccess().getUiKeyword_2_0());
                    			
                    // InternalAceGen.g:207:4: ( (lv_jsx_4_0= 'JSX' ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==15) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalAceGen.g:208:5: (lv_jsx_4_0= 'JSX' )
                            {
                            // InternalAceGen.g:208:5: (lv_jsx_4_0= 'JSX' )
                            // InternalAceGen.g:209:6: lv_jsx_4_0= 'JSX'
                            {
                            lv_jsx_4_0=(Token)match(input,15,FOLLOW_7); 

                            						newLeafNode(lv_jsx_4_0, grammarAccess.getHttpClientAccess().getJsxJSXKeyword_2_1_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getHttpClientRule());
                            						}
                            						setWithLastConsumed(current, "jsx", lv_jsx_4_0 != null, "JSX");
                            					

                            }


                            }
                            break;

                    }

                    // InternalAceGen.g:221:4: ( (lv_container_5_0= ruleClientAttribute ) )
                    // InternalAceGen.g:222:5: (lv_container_5_0= ruleClientAttribute )
                    {
                    // InternalAceGen.g:222:5: (lv_container_5_0= ruleClientAttribute )
                    // InternalAceGen.g:223:6: lv_container_5_0= ruleClientAttribute
                    {

                    						newCompositeNode(grammarAccess.getHttpClientAccess().getContainerClientAttributeParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_container_5_0=ruleClientAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHttpClientRule());
                    						}
                    						set(
                    							current,
                    							"container",
                    							lv_container_5_0,
                    							"de.acegen.AceGen.ClientAttribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:241:3: (otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAceGen.g:242:4: otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )*
                    {
                    otherlv_6=(Token)match(input,16,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getHttpClientAccess().getScenariosKeyword_3_0());
                    			
                    // InternalAceGen.g:246:4: ( (lv_scenarios_7_0= ruleClientScenario ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalAceGen.g:247:5: (lv_scenarios_7_0= ruleClientScenario )
                    	    {
                    	    // InternalAceGen.g:247:5: (lv_scenarios_7_0= ruleClientScenario )
                    	    // InternalAceGen.g:248:6: lv_scenarios_7_0= ruleClientScenario
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpClientAccess().getScenariosClientScenarioParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_3);
                    	    lv_scenarios_7_0=ruleClientScenario();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpClientRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"scenarios",
                    	    							lv_scenarios_7_0,
                    	    							"de.acegen.AceGen.ClientScenario");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
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
    // InternalAceGen.g:270:1: entryRuleHttpClientAce returns [EObject current=null] : iv_ruleHttpClientAce= ruleHttpClientAce EOF ;
    public final EObject entryRuleHttpClientAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientAce = null;


        try {
            // InternalAceGen.g:270:54: (iv_ruleHttpClientAce= ruleHttpClientAce EOF )
            // InternalAceGen.g:271:2: iv_ruleHttpClientAce= ruleHttpClientAce EOF
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
    // InternalAceGen.g:277:1: ruleHttpClientAce returns [EObject current=null] : ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )? (otherlv_7= 'fromAppState' otherlv_8= '(' ( (lv_refs_9_0= ruleFromAppStateRef ) ) (otherlv_10= ',' ( (lv_refs_11_0= ruleFromAppStateRef ) ) )* otherlv_12= ')' )? (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )* ) ;
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

        EObject lv_refs_9_0 = null;

        EObject lv_refs_11_0 = null;

        EObject lv_outcomes_17_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:283:2: ( ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )? (otherlv_7= 'fromAppState' otherlv_8= '(' ( (lv_refs_9_0= ruleFromAppStateRef ) ) (otherlv_10= ',' ( (lv_refs_11_0= ruleFromAppStateRef ) ) )* otherlv_12= ')' )? (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )* ) )
            // InternalAceGen.g:284:2: ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )? (otherlv_7= 'fromAppState' otherlv_8= '(' ( (lv_refs_9_0= ruleFromAppStateRef ) ) (otherlv_10= ',' ( (lv_refs_11_0= ruleFromAppStateRef ) ) )* otherlv_12= ')' )? (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )* )
            {
            // InternalAceGen.g:284:2: ( ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )? (otherlv_7= 'fromAppState' otherlv_8= '(' ( (lv_refs_9_0= ruleFromAppStateRef ) ) (otherlv_10= ',' ( (lv_refs_11_0= ruleFromAppStateRef ) ) )* otherlv_12= ')' )? (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )* )
            // InternalAceGen.g:285:3: ( (lv_async_0_0= 'async' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )? (otherlv_7= 'fromAppState' otherlv_8= '(' ( (lv_refs_9_0= ruleFromAppStateRef ) ) (otherlv_10= ',' ( (lv_refs_11_0= ruleFromAppStateRef ) ) )* otherlv_12= ')' )? (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )*
            {
            // InternalAceGen.g:285:3: ( (lv_async_0_0= 'async' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAceGen.g:286:4: (lv_async_0_0= 'async' )
                    {
                    // InternalAceGen.g:286:4: (lv_async_0_0= 'async' )
                    // InternalAceGen.g:287:5: lv_async_0_0= 'async'
                    {
                    lv_async_0_0=(Token)match(input,17,FOLLOW_9); 

                    					newLeafNode(lv_async_0_0, grammarAccess.getHttpClientAceAccess().getAsyncAsyncKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpClientAceRule());
                    					}
                    					setWithLastConsumed(current, "async", lv_async_0_0 != null, "async");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:299:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:300:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:300:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:301:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

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

            // InternalAceGen.g:317:3: (otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==18) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalAceGen.g:318:4: otherlv_2= '(' ( (lv_input_3_0= ruleInput ) ) (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getHttpClientAceAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalAceGen.g:322:4: ( (lv_input_3_0= ruleInput ) )
                    // InternalAceGen.g:323:5: (lv_input_3_0= ruleInput )
                    {
                    // InternalAceGen.g:323:5: (lv_input_3_0= ruleInput )
                    // InternalAceGen.g:324:6: lv_input_3_0= ruleInput
                    {

                    						newCompositeNode(grammarAccess.getHttpClientAceAccess().getInputInputParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_11);
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

                    // InternalAceGen.g:341:4: (otherlv_4= ',' ( (lv_input_5_0= ruleInput ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==19) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalAceGen.g:342:5: otherlv_4= ',' ( (lv_input_5_0= ruleInput ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_9); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getHttpClientAceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:346:5: ( (lv_input_5_0= ruleInput ) )
                    	    // InternalAceGen.g:347:6: (lv_input_5_0= ruleInput )
                    	    {
                    	    // InternalAceGen.g:347:6: (lv_input_5_0= ruleInput )
                    	    // InternalAceGen.g:348:7: lv_input_5_0= ruleInput
                    	    {

                    	    							newCompositeNode(grammarAccess.getHttpClientAceAccess().getInputInputParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
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
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,20,FOLLOW_12); 

                    				newLeafNode(otherlv_6, grammarAccess.getHttpClientAceAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:371:3: (otherlv_7= 'fromAppState' otherlv_8= '(' ( (lv_refs_9_0= ruleFromAppStateRef ) ) (otherlv_10= ',' ( (lv_refs_11_0= ruleFromAppStateRef ) ) )* otherlv_12= ')' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalAceGen.g:372:4: otherlv_7= 'fromAppState' otherlv_8= '(' ( (lv_refs_9_0= ruleFromAppStateRef ) ) (otherlv_10= ',' ( (lv_refs_11_0= ruleFromAppStateRef ) ) )* otherlv_12= ')'
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_13); 

                    				newLeafNode(otherlv_7, grammarAccess.getHttpClientAceAccess().getFromAppStateKeyword_3_0());
                    			
                    otherlv_8=(Token)match(input,18,FOLLOW_9); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpClientAceAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalAceGen.g:380:4: ( (lv_refs_9_0= ruleFromAppStateRef ) )
                    // InternalAceGen.g:381:5: (lv_refs_9_0= ruleFromAppStateRef )
                    {
                    // InternalAceGen.g:381:5: (lv_refs_9_0= ruleFromAppStateRef )
                    // InternalAceGen.g:382:6: lv_refs_9_0= ruleFromAppStateRef
                    {

                    						newCompositeNode(grammarAccess.getHttpClientAceAccess().getRefsFromAppStateRefParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_refs_9_0=ruleFromAppStateRef();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHttpClientAceRule());
                    						}
                    						add(
                    							current,
                    							"refs",
                    							lv_refs_9_0,
                    							"de.acegen.AceGen.FromAppStateRef");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:399:4: (otherlv_10= ',' ( (lv_refs_11_0= ruleFromAppStateRef ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==19) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalAceGen.g:400:5: otherlv_10= ',' ( (lv_refs_11_0= ruleFromAppStateRef ) )
                    	    {
                    	    otherlv_10=(Token)match(input,19,FOLLOW_9); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getHttpClientAceAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalAceGen.g:404:5: ( (lv_refs_11_0= ruleFromAppStateRef ) )
                    	    // InternalAceGen.g:405:6: (lv_refs_11_0= ruleFromAppStateRef )
                    	    {
                    	    // InternalAceGen.g:405:6: (lv_refs_11_0= ruleFromAppStateRef )
                    	    // InternalAceGen.g:406:7: lv_refs_11_0= ruleFromAppStateRef
                    	    {

                    	    							newCompositeNode(grammarAccess.getHttpClientAceAccess().getRefsFromAppStateRefParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_refs_11_0=ruleFromAppStateRef();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getHttpClientAceRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"refs",
                    	    								lv_refs_11_0,
                    	    								"de.acegen.AceGen.FromAppStateRef");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,20,FOLLOW_14); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpClientAceAccess().getRightParenthesisKeyword_3_4());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:429:3: (otherlv_13= 'call' ( ( ruleQualifiedName ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalAceGen.g:430:4: otherlv_13= 'call' ( ( ruleQualifiedName ) )
                    {
                    otherlv_13=(Token)match(input,22,FOLLOW_9); 

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
                    					
                    pushFollow(FOLLOW_15);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:451:3: (otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==23) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAceGen.g:452:4: otherlv_15= 'loadingFlag' ( ( ruleQualifiedName ) )
                    {
                    otherlv_15=(Token)match(input,23,FOLLOW_9); 

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
                    					
                    pushFollow(FOLLOW_16);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:473:3: ( (lv_outcomes_17_0= ruleHttpClientOutcome ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==25) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalAceGen.g:474:4: (lv_outcomes_17_0= ruleHttpClientOutcome )
            	    {
            	    // InternalAceGen.g:474:4: (lv_outcomes_17_0= ruleHttpClientOutcome )
            	    // InternalAceGen.g:475:5: lv_outcomes_17_0= ruleHttpClientOutcome
            	    {

            	    					newCompositeNode(grammarAccess.getHttpClientAceAccess().getOutcomesHttpClientOutcomeParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_16);
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
            	    break loop17;
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


    // $ANTLR start "entryRuleFromAppStateRef"
    // InternalAceGen.g:496:1: entryRuleFromAppStateRef returns [EObject current=null] : iv_ruleFromAppStateRef= ruleFromAppStateRef EOF ;
    public final EObject entryRuleFromAppStateRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFromAppStateRef = null;


        try {
            // InternalAceGen.g:496:56: (iv_ruleFromAppStateRef= ruleFromAppStateRef EOF )
            // InternalAceGen.g:497:2: iv_ruleFromAppStateRef= ruleFromAppStateRef EOF
            {
             newCompositeNode(grammarAccess.getFromAppStateRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFromAppStateRef=ruleFromAppStateRef();

            state._fsp--;

             current =iv_ruleFromAppStateRef; 
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
    // $ANTLR end "entryRuleFromAppStateRef"


    // $ANTLR start "ruleFromAppStateRef"
    // InternalAceGen.g:503:1: ruleFromAppStateRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= 'as' ( (lv_varName_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleFromAppStateRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_varName_2_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:509:2: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= 'as' ( (lv_varName_2_0= RULE_ID ) ) )? ) )
            // InternalAceGen.g:510:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= 'as' ( (lv_varName_2_0= RULE_ID ) ) )? )
            {
            // InternalAceGen.g:510:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= 'as' ( (lv_varName_2_0= RULE_ID ) ) )? )
            // InternalAceGen.g:511:3: ( ( ruleQualifiedName ) ) (otherlv_1= 'as' ( (lv_varName_2_0= RULE_ID ) ) )?
            {
            // InternalAceGen.g:511:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:512:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:512:4: ( ruleQualifiedName )
            // InternalAceGen.g:513:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFromAppStateRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFromAppStateRefAccess().getStateElementClientAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_17);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:527:3: (otherlv_1= 'as' ( (lv_varName_2_0= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==24) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAceGen.g:528:4: otherlv_1= 'as' ( (lv_varName_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getFromAppStateRefAccess().getAsKeyword_1_0());
                    			
                    // InternalAceGen.g:532:4: ( (lv_varName_2_0= RULE_ID ) )
                    // InternalAceGen.g:533:5: (lv_varName_2_0= RULE_ID )
                    {
                    // InternalAceGen.g:533:5: (lv_varName_2_0= RULE_ID )
                    // InternalAceGen.g:534:6: lv_varName_2_0= RULE_ID
                    {
                    lv_varName_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(lv_varName_2_0, grammarAccess.getFromAppStateRefAccess().getVarNameIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFromAppStateRefRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"varName",
                    							lv_varName_2_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

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
    // $ANTLR end "ruleFromAppStateRef"


    // $ANTLR start "entryRuleInput"
    // InternalAceGen.g:555:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalAceGen.g:555:46: (iv_ruleInput= ruleInput EOF )
            // InternalAceGen.g:556:2: iv_ruleInput= ruleInput EOF
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
    // InternalAceGen.g:562:1: ruleInput returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleInput() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:568:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalAceGen.g:569:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalAceGen.g:569:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:570:3: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:570:3: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:571:4: lv_name_0_0= RULE_ID
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
    // InternalAceGen.g:590:1: entryRuleHttpClientOutcome returns [EObject current=null] : iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF ;
    public final EObject entryRuleHttpClientOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientOutcome = null;


        try {
            // InternalAceGen.g:590:58: (iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF )
            // InternalAceGen.g:591:2: iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF
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
    // InternalAceGen.g:597:1: ruleHttpClientOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( (lv_triggerdAceOperations_7_0= ruleTriggerdAceOperation ) )* otherlv_8= ')' )? ) ;
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

        EObject lv_triggerdAceOperations_7_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:603:2: ( (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( (lv_triggerdAceOperations_7_0= ruleTriggerdAceOperation ) )* otherlv_8= ')' )? ) )
            // InternalAceGen.g:604:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( (lv_triggerdAceOperations_7_0= ruleTriggerdAceOperation ) )* otherlv_8= ')' )? )
            {
            // InternalAceGen.g:604:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( (lv_triggerdAceOperations_7_0= ruleTriggerdAceOperation ) )* otherlv_8= ')' )? )
            // InternalAceGen.g:605:3: otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( (lv_triggerdAceOperations_7_0= ruleTriggerdAceOperation ) )* otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpClientOutcomeAccess().getOnKeyword_0());
            		
            // InternalAceGen.g:609:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:610:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:610:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:611:5: lv_name_1_0= RULE_ID
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

            // InternalAceGen.g:627:3: (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==18) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalAceGen.g:628:4: otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_19); 

                    				newLeafNode(otherlv_2, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalAceGen.g:632:4: ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=29 && LA19_0<=30)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalAceGen.g:633:5: (lv_listeners_3_0= ruleHttpClientStateFunction )
                    	    {
                    	    // InternalAceGen.g:633:5: (lv_listeners_3_0= ruleHttpClientStateFunction )
                    	    // InternalAceGen.g:634:6: lv_listeners_3_0= ruleHttpClientStateFunction
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

                    otherlv_4=(Token)match(input,20,FOLLOW_20); 

                    				newLeafNode(otherlv_4, grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:656:3: (otherlv_5= 'triggers' otherlv_6= '(' ( (lv_triggerdAceOperations_7_0= ruleTriggerdAceOperation ) )* otherlv_8= ')' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==26) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalAceGen.g:657:4: otherlv_5= 'triggers' otherlv_6= '(' ( (lv_triggerdAceOperations_7_0= ruleTriggerdAceOperation ) )* otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,26,FOLLOW_13); 

                    				newLeafNode(otherlv_5, grammarAccess.getHttpClientOutcomeAccess().getTriggersKeyword_3_0());
                    			
                    otherlv_6=(Token)match(input,18,FOLLOW_21); 

                    				newLeafNode(otherlv_6, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalAceGen.g:665:4: ( (lv_triggerdAceOperations_7_0= ruleTriggerdAceOperation ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_ID||LA21_0==27) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalAceGen.g:666:5: (lv_triggerdAceOperations_7_0= ruleTriggerdAceOperation )
                    	    {
                    	    // InternalAceGen.g:666:5: (lv_triggerdAceOperations_7_0= ruleTriggerdAceOperation )
                    	    // InternalAceGen.g:667:6: lv_triggerdAceOperations_7_0= ruleTriggerdAceOperation
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpClientOutcomeAccess().getTriggerdAceOperationsTriggerdAceOperationParserRuleCall_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_21);
                    	    lv_triggerdAceOperations_7_0=ruleTriggerdAceOperation();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpClientOutcomeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"triggerdAceOperations",
                    	    							lv_triggerdAceOperations_7_0,
                    	    							"de.acegen.AceGen.TriggerdAceOperation");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,20,FOLLOW_2); 

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


    // $ANTLR start "entryRuleTriggerdAceOperation"
    // InternalAceGen.g:693:1: entryRuleTriggerdAceOperation returns [EObject current=null] : iv_ruleTriggerdAceOperation= ruleTriggerdAceOperation EOF ;
    public final EObject entryRuleTriggerdAceOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggerdAceOperation = null;


        try {
            // InternalAceGen.g:693:61: (iv_ruleTriggerdAceOperation= ruleTriggerdAceOperation EOF )
            // InternalAceGen.g:694:2: iv_ruleTriggerdAceOperation= ruleTriggerdAceOperation EOF
            {
             newCompositeNode(grammarAccess.getTriggerdAceOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTriggerdAceOperation=ruleTriggerdAceOperation();

            state._fsp--;

             current =iv_ruleTriggerdAceOperation; 
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
    // $ANTLR end "entryRuleTriggerdAceOperation"


    // $ANTLR start "ruleTriggerdAceOperation"
    // InternalAceGen.g:700:1: ruleTriggerdAceOperation returns [EObject current=null] : ( (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) ( (lv_takeLatest_2_0= 'takeLatest' ) )? )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleTriggerdAceOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_delay_1_0=null;
        Token lv_takeLatest_2_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:706:2: ( ( (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) ( (lv_takeLatest_2_0= 'takeLatest' ) )? )? ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:707:2: ( (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) ( (lv_takeLatest_2_0= 'takeLatest' ) )? )? ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:707:2: ( (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) ( (lv_takeLatest_2_0= 'takeLatest' ) )? )? ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:708:3: (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) ( (lv_takeLatest_2_0= 'takeLatest' ) )? )? ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:708:3: (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) ( (lv_takeLatest_2_0= 'takeLatest' ) )? )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==27) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalAceGen.g:709:4: otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) ( (lv_takeLatest_2_0= 'takeLatest' ) )?
                    {
                    otherlv_0=(Token)match(input,27,FOLLOW_22); 

                    				newLeafNode(otherlv_0, grammarAccess.getTriggerdAceOperationAccess().getDelayInMillisKeyword_0_0());
                    			
                    // InternalAceGen.g:713:4: ( (lv_delay_1_0= RULE_INT ) )
                    // InternalAceGen.g:714:5: (lv_delay_1_0= RULE_INT )
                    {
                    // InternalAceGen.g:714:5: (lv_delay_1_0= RULE_INT )
                    // InternalAceGen.g:715:6: lv_delay_1_0= RULE_INT
                    {
                    lv_delay_1_0=(Token)match(input,RULE_INT,FOLLOW_23); 

                    						newLeafNode(lv_delay_1_0, grammarAccess.getTriggerdAceOperationAccess().getDelayINTTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTriggerdAceOperationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"delay",
                    							lv_delay_1_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    // InternalAceGen.g:731:4: ( (lv_takeLatest_2_0= 'takeLatest' ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==28) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalAceGen.g:732:5: (lv_takeLatest_2_0= 'takeLatest' )
                            {
                            // InternalAceGen.g:732:5: (lv_takeLatest_2_0= 'takeLatest' )
                            // InternalAceGen.g:733:6: lv_takeLatest_2_0= 'takeLatest'
                            {
                            lv_takeLatest_2_0=(Token)match(input,28,FOLLOW_9); 

                            						newLeafNode(lv_takeLatest_2_0, grammarAccess.getTriggerdAceOperationAccess().getTakeLatestTakeLatestKeyword_0_2_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getTriggerdAceOperationRule());
                            						}
                            						setWithLastConsumed(current, "takeLatest", lv_takeLatest_2_0 != null, "takeLatest");
                            					

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalAceGen.g:746:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:747:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:747:4: ( ruleQualifiedName )
            // InternalAceGen.g:748:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTriggerdAceOperationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTriggerdAceOperationAccess().getAceOperationHttpClientAceCrossReference_1_0());
            				
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
    // $ANTLR end "ruleTriggerdAceOperation"


    // $ANTLR start "entryRuleHttpClientStateFunction"
    // InternalAceGen.g:766:1: entryRuleHttpClientStateFunction returns [EObject current=null] : iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF ;
    public final EObject entryRuleHttpClientStateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientStateFunction = null;


        try {
            // InternalAceGen.g:766:64: (iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF )
            // InternalAceGen.g:767:2: iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF
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
    // InternalAceGen.g:773:1: ruleHttpClientStateFunction returns [EObject current=null] : ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleHttpClientStateFunction() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_stateFunctionType_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:779:2: ( ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:780:2: ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:780:2: ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:781:3: ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:781:3: ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) )
            // InternalAceGen.g:782:4: (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType )
            {
            // InternalAceGen.g:782:4: (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType )
            // InternalAceGen.g:783:5: lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeHttpClientStateFunctionTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_9);
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

            // InternalAceGen.g:800:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:801:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:801:4: ( ruleQualifiedName )
            // InternalAceGen.g:802:5: ruleQualifiedName
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
    // InternalAceGen.g:820:1: entryRuleHttpClientStateFunctionType returns [String current=null] : iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF ;
    public final String entryRuleHttpClientStateFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHttpClientStateFunctionType = null;


        try {
            // InternalAceGen.g:820:67: (iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF )
            // InternalAceGen.g:821:2: iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF
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
    // InternalAceGen.g:827:1: ruleHttpClientStateFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'set' | kw= 'merge' ) ;
    public final AntlrDatatypeRuleToken ruleHttpClientStateFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:833:2: ( (kw= 'set' | kw= 'merge' ) )
            // InternalAceGen.g:834:2: (kw= 'set' | kw= 'merge' )
            {
            // InternalAceGen.g:834:2: (kw= 'set' | kw= 'merge' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==29) ) {
                alt25=1;
            }
            else if ( (LA25_0==30) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalAceGen.g:835:3: kw= 'set'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:841:3: kw= 'merge'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1());
                    		

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
    // InternalAceGen.g:850:1: entryRuleClientAttribute returns [EObject current=null] : iv_ruleClientAttribute= ruleClientAttribute EOF ;
    public final EObject entryRuleClientAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientAttribute = null;


        try {
            // InternalAceGen.g:850:56: (iv_ruleClientAttribute= ruleClientAttribute EOF )
            // InternalAceGen.g:851:2: iv_ruleClientAttribute= ruleClientAttribute EOF
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
    // InternalAceGen.g:857:1: ruleClientAttribute returns [EObject current=null] : ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (lv_location_3_0= 'location' ) )? ( (lv_storage_4_0= 'storage' ) )? (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* (otherlv_7= 'actions' otherlv_8= '{' ( (lv_actions_9_0= ruleUiAction ) )* otherlv_10= '}' )? otherlv_11= '}' )? ) ;
    public final EObject ruleClientAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_noComponent_0_0=null;
        Token lv_list_1_0=null;
        Token lv_name_2_0=null;
        Token lv_location_3_0=null;
        Token lv_storage_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_attributes_6_0 = null;

        EObject lv_actions_9_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:863:2: ( ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (lv_location_3_0= 'location' ) )? ( (lv_storage_4_0= 'storage' ) )? (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* (otherlv_7= 'actions' otherlv_8= '{' ( (lv_actions_9_0= ruleUiAction ) )* otherlv_10= '}' )? otherlv_11= '}' )? ) )
            // InternalAceGen.g:864:2: ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (lv_location_3_0= 'location' ) )? ( (lv_storage_4_0= 'storage' ) )? (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* (otherlv_7= 'actions' otherlv_8= '{' ( (lv_actions_9_0= ruleUiAction ) )* otherlv_10= '}' )? otherlv_11= '}' )? )
            {
            // InternalAceGen.g:864:2: ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (lv_location_3_0= 'location' ) )? ( (lv_storage_4_0= 'storage' ) )? (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* (otherlv_7= 'actions' otherlv_8= '{' ( (lv_actions_9_0= ruleUiAction ) )* otherlv_10= '}' )? otherlv_11= '}' )? )
            // InternalAceGen.g:865:3: ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (lv_location_3_0= 'location' ) )? ( (lv_storage_4_0= 'storage' ) )? (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* (otherlv_7= 'actions' otherlv_8= '{' ( (lv_actions_9_0= ruleUiAction ) )* otherlv_10= '}' )? otherlv_11= '}' )?
            {
            // InternalAceGen.g:865:3: ( (lv_noComponent_0_0= 'noComponent' ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==31) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalAceGen.g:866:4: (lv_noComponent_0_0= 'noComponent' )
                    {
                    // InternalAceGen.g:866:4: (lv_noComponent_0_0= 'noComponent' )
                    // InternalAceGen.g:867:5: lv_noComponent_0_0= 'noComponent'
                    {
                    lv_noComponent_0_0=(Token)match(input,31,FOLLOW_24); 

                    					newLeafNode(lv_noComponent_0_0, grammarAccess.getClientAttributeAccess().getNoComponentNoComponentKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "noComponent", lv_noComponent_0_0 != null, "noComponent");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:879:3: ( (lv_list_1_0= 'List' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==32) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalAceGen.g:880:4: (lv_list_1_0= 'List' )
                    {
                    // InternalAceGen.g:880:4: (lv_list_1_0= 'List' )
                    // InternalAceGen.g:881:5: lv_list_1_0= 'List'
                    {
                    lv_list_1_0=(Token)match(input,32,FOLLOW_9); 

                    					newLeafNode(lv_list_1_0, grammarAccess.getClientAttributeAccess().getListListKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "list", lv_list_1_0 != null, "List");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:893:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalAceGen.g:894:4: (lv_name_2_0= RULE_ID )
            {
            // InternalAceGen.g:894:4: (lv_name_2_0= RULE_ID )
            // InternalAceGen.g:895:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(lv_name_2_0, grammarAccess.getClientAttributeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClientAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:911:3: ( (lv_location_3_0= 'location' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAceGen.g:912:4: (lv_location_3_0= 'location' )
                    {
                    // InternalAceGen.g:912:4: (lv_location_3_0= 'location' )
                    // InternalAceGen.g:913:5: lv_location_3_0= 'location'
                    {
                    lv_location_3_0=(Token)match(input,33,FOLLOW_26); 

                    					newLeafNode(lv_location_3_0, grammarAccess.getClientAttributeAccess().getLocationLocationKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "location", lv_location_3_0 != null, "location");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:925:3: ( (lv_storage_4_0= 'storage' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAceGen.g:926:4: (lv_storage_4_0= 'storage' )
                    {
                    // InternalAceGen.g:926:4: (lv_storage_4_0= 'storage' )
                    // InternalAceGen.g:927:5: lv_storage_4_0= 'storage'
                    {
                    lv_storage_4_0=(Token)match(input,34,FOLLOW_27); 

                    					newLeafNode(lv_storage_4_0, grammarAccess.getClientAttributeAccess().getStorageStorageKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "storage", lv_storage_4_0 != null, "storage");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:939:3: (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* (otherlv_7= 'actions' otherlv_8= '{' ( (lv_actions_9_0= ruleUiAction ) )* otherlv_10= '}' )? otherlv_11= '}' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==35) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalAceGen.g:940:4: otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* (otherlv_7= 'actions' otherlv_8= '{' ( (lv_actions_9_0= ruleUiAction ) )* otherlv_10= '}' )? otherlv_11= '}'
                    {
                    otherlv_5=(Token)match(input,35,FOLLOW_28); 

                    				newLeafNode(otherlv_5, grammarAccess.getClientAttributeAccess().getLeftCurlyBracketKeyword_5_0());
                    			
                    // InternalAceGen.g:944:4: ( (lv_attributes_6_0= ruleClientAttribute ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID||(LA30_0>=31 && LA30_0<=32)) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalAceGen.g:945:5: (lv_attributes_6_0= ruleClientAttribute )
                    	    {
                    	    // InternalAceGen.g:945:5: (lv_attributes_6_0= ruleClientAttribute )
                    	    // InternalAceGen.g:946:6: lv_attributes_6_0= ruleClientAttribute
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientAttributeAccess().getAttributesClientAttributeParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_28);
                    	    lv_attributes_6_0=ruleClientAttribute();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClientAttributeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"attributes",
                    	    							lv_attributes_6_0,
                    	    							"de.acegen.AceGen.ClientAttribute");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    // InternalAceGen.g:963:4: (otherlv_7= 'actions' otherlv_8= '{' ( (lv_actions_9_0= ruleUiAction ) )* otherlv_10= '}' )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==36) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalAceGen.g:964:5: otherlv_7= 'actions' otherlv_8= '{' ( (lv_actions_9_0= ruleUiAction ) )* otherlv_10= '}'
                            {
                            otherlv_7=(Token)match(input,36,FOLLOW_29); 

                            					newLeafNode(otherlv_7, grammarAccess.getClientAttributeAccess().getActionsKeyword_5_2_0());
                            				
                            otherlv_8=(Token)match(input,35,FOLLOW_30); 

                            					newLeafNode(otherlv_8, grammarAccess.getClientAttributeAccess().getLeftCurlyBracketKeyword_5_2_1());
                            				
                            // InternalAceGen.g:972:5: ( (lv_actions_9_0= ruleUiAction ) )*
                            loop31:
                            do {
                                int alt31=2;
                                int LA31_0 = input.LA(1);

                                if ( (LA31_0==RULE_STRING) ) {
                                    alt31=1;
                                }


                                switch (alt31) {
                            	case 1 :
                            	    // InternalAceGen.g:973:6: (lv_actions_9_0= ruleUiAction )
                            	    {
                            	    // InternalAceGen.g:973:6: (lv_actions_9_0= ruleUiAction )
                            	    // InternalAceGen.g:974:7: lv_actions_9_0= ruleUiAction
                            	    {

                            	    							newCompositeNode(grammarAccess.getClientAttributeAccess().getActionsUiActionParserRuleCall_5_2_2_0());
                            	    						
                            	    pushFollow(FOLLOW_30);
                            	    lv_actions_9_0=ruleUiAction();

                            	    state._fsp--;


                            	    							if (current==null) {
                            	    								current = createModelElementForParent(grammarAccess.getClientAttributeRule());
                            	    							}
                            	    							add(
                            	    								current,
                            	    								"actions",
                            	    								lv_actions_9_0,
                            	    								"de.acegen.AceGen.UiAction");
                            	    							afterParserOrEnumRuleCall();
                            	    						

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop31;
                                }
                            } while (true);

                            otherlv_10=(Token)match(input,37,FOLLOW_31); 

                            					newLeafNode(otherlv_10, grammarAccess.getClientAttributeAccess().getRightCurlyBracketKeyword_5_2_3());
                            				

                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,37,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getClientAttributeAccess().getRightCurlyBracketKeyword_5_3());
                    			

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


    // $ANTLR start "entryRuleUiAction"
    // InternalAceGen.g:1005:1: entryRuleUiAction returns [EObject current=null] : iv_ruleUiAction= ruleUiAction EOF ;
    public final EObject entryRuleUiAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUiAction = null;


        try {
            // InternalAceGen.g:1005:49: (iv_ruleUiAction= ruleUiAction EOF )
            // InternalAceGen.g:1006:2: iv_ruleUiAction= ruleUiAction EOF
            {
             newCompositeNode(grammarAccess.getUiActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUiAction=ruleUiAction();

            state._fsp--;

             current =iv_ruleUiAction; 
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
    // $ANTLR end "entryRuleUiAction"


    // $ANTLR start "ruleUiAction"
    // InternalAceGen.g:1012:1: ruleUiAction returns [EObject current=null] : ( ( (lv_type_0_0= RULE_STRING ) ) ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleUiAction() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalAceGen.g:1018:2: ( ( ( (lv_type_0_0= RULE_STRING ) ) ( (otherlv_1= RULE_ID ) ) ) )
            // InternalAceGen.g:1019:2: ( ( (lv_type_0_0= RULE_STRING ) ) ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalAceGen.g:1019:2: ( ( (lv_type_0_0= RULE_STRING ) ) ( (otherlv_1= RULE_ID ) ) )
            // InternalAceGen.g:1020:3: ( (lv_type_0_0= RULE_STRING ) ) ( (otherlv_1= RULE_ID ) )
            {
            // InternalAceGen.g:1020:3: ( (lv_type_0_0= RULE_STRING ) )
            // InternalAceGen.g:1021:4: (lv_type_0_0= RULE_STRING )
            {
            // InternalAceGen.g:1021:4: (lv_type_0_0= RULE_STRING )
            // InternalAceGen.g:1022:5: lv_type_0_0= RULE_STRING
            {
            lv_type_0_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_type_0_0, grammarAccess.getUiActionAccess().getTypeSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUiActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalAceGen.g:1038:3: ( (otherlv_1= RULE_ID ) )
            // InternalAceGen.g:1039:4: (otherlv_1= RULE_ID )
            {
            // InternalAceGen.g:1039:4: (otherlv_1= RULE_ID )
            // InternalAceGen.g:1040:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUiActionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getUiActionAccess().getTargetHttpClientAceCrossReference_1_0());
            				

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
    // $ANTLR end "ruleUiAction"


    // $ANTLR start "entryRuleClientScenario"
    // InternalAceGen.g:1055:1: entryRuleClientScenario returns [EObject current=null] : iv_ruleClientScenario= ruleClientScenario EOF ;
    public final EObject entryRuleClientScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientScenario = null;


        try {
            // InternalAceGen.g:1055:55: (iv_ruleClientScenario= ruleClientScenario EOF )
            // InternalAceGen.g:1056:2: iv_ruleClientScenario= ruleClientScenario EOF
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
    // InternalAceGen.g:1062:1: ruleClientScenario returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) ) (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )* ) ;
    public final EObject ruleClientScenario() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_givenRefs_2_0 = null;

        EObject lv_clientWhenThen_3_0 = null;

        EObject lv_clientWhenThen_5_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1068:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) ) (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )* ) )
            // InternalAceGen.g:1069:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) ) (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )* )
            {
            // InternalAceGen.g:1069:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) ) (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )* )
            // InternalAceGen.g:1070:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) ) (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )*
            {
            // InternalAceGen.g:1070:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1071:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1071:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1072:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_32); 

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

            // InternalAceGen.g:1088:3: (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==38) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalAceGen.g:1089:4: otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )*
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_33); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientScenarioAccess().getGIVENKeyword_1_0());
                    			
                    // InternalAceGen.g:1093:4: ( (lv_givenRefs_2_0= ruleClientGivenRef ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==RULE_ID) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalAceGen.g:1094:5: (lv_givenRefs_2_0= ruleClientGivenRef )
                    	    {
                    	    // InternalAceGen.g:1094:5: (lv_givenRefs_2_0= ruleClientGivenRef )
                    	    // InternalAceGen.g:1095:6: lv_givenRefs_2_0= ruleClientGivenRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientScenarioAccess().getGivenRefsClientGivenRefParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_33);
                    	    lv_givenRefs_2_0=ruleClientGivenRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClientScenarioRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"givenRefs",
                    	    							lv_givenRefs_2_0,
                    	    							"de.acegen.AceGen.ClientGivenRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

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

            // InternalAceGen.g:1113:3: ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) )
            // InternalAceGen.g:1114:4: (lv_clientWhenThen_3_0= ruleClientWhenThen )
            {
            // InternalAceGen.g:1114:4: (lv_clientWhenThen_3_0= ruleClientWhenThen )
            // InternalAceGen.g:1115:5: lv_clientWhenThen_3_0= ruleClientWhenThen
            {

            					newCompositeNode(grammarAccess.getClientScenarioAccess().getClientWhenThenClientWhenThenParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_34);
            lv_clientWhenThen_3_0=ruleClientWhenThen();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClientScenarioRule());
            					}
            					add(
            						current,
            						"clientWhenThen",
            						lv_clientWhenThen_3_0,
            						"de.acegen.AceGen.ClientWhenThen");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1132:3: (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==39) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalAceGen.g:1133:4: otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) )
            	    {
            	    otherlv_4=(Token)match(input,39,FOLLOW_32); 

            	    				newLeafNode(otherlv_4, grammarAccess.getClientScenarioAccess().getANDKeyword_3_0());
            	    			
            	    // InternalAceGen.g:1137:4: ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) )
            	    // InternalAceGen.g:1138:5: (lv_clientWhenThen_5_0= ruleClientWhenThen )
            	    {
            	    // InternalAceGen.g:1138:5: (lv_clientWhenThen_5_0= ruleClientWhenThen )
            	    // InternalAceGen.g:1139:6: lv_clientWhenThen_5_0= ruleClientWhenThen
            	    {

            	    						newCompositeNode(grammarAccess.getClientScenarioAccess().getClientWhenThenClientWhenThenParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_34);
            	    lv_clientWhenThen_5_0=ruleClientWhenThen();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getClientScenarioRule());
            	    						}
            	    						add(
            	    							current,
            	    							"clientWhenThen",
            	    							lv_clientWhenThen_5_0,
            	    							"de.acegen.AceGen.ClientWhenThen");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // $ANTLR end "ruleClientScenario"


    // $ANTLR start "entryRuleClientWhenThen"
    // InternalAceGen.g:1161:1: entryRuleClientWhenThen returns [EObject current=null] : iv_ruleClientWhenThen= ruleClientWhenThen EOF ;
    public final EObject entryRuleClientWhenThen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientWhenThen = null;


        try {
            // InternalAceGen.g:1161:55: (iv_ruleClientWhenThen= ruleClientWhenThen EOF )
            // InternalAceGen.g:1162:2: iv_ruleClientWhenThen= ruleClientWhenThen EOF
            {
             newCompositeNode(grammarAccess.getClientWhenThenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClientWhenThen=ruleClientWhenThen();

            state._fsp--;

             current =iv_ruleClientWhenThen; 
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
    // $ANTLR end "entryRuleClientWhenThen"


    // $ANTLR start "ruleClientWhenThen"
    // InternalAceGen.g:1168:1: ruleClientWhenThen returns [EObject current=null] : ( () otherlv_1= 'WHEN' ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )? (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )? (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )? ) ;
    public final EObject ruleClientWhenThen() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_delayInMillis_4_0=null;
        Token otherlv_5=null;
        EObject lv_whenBlock_2_0 = null;

        EObject lv_thenBlock_6_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1174:2: ( ( () otherlv_1= 'WHEN' ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )? (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )? (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )? ) )
            // InternalAceGen.g:1175:2: ( () otherlv_1= 'WHEN' ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )? (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )? (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )? )
            {
            // InternalAceGen.g:1175:2: ( () otherlv_1= 'WHEN' ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )? (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )? (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )? )
            // InternalAceGen.g:1176:3: () otherlv_1= 'WHEN' ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )? (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )? (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )?
            {
            // InternalAceGen.g:1176:3: ()
            // InternalAceGen.g:1177:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClientWhenThenAccess().getClientWhenThenAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,40,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getClientWhenThenAccess().getWHENKeyword_1());
            		
            // InternalAceGen.g:1187:3: ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==EOF||LA37_1==RULE_ID||LA37_1==18||LA37_1==27||LA37_1==39||LA37_1==41||LA37_1==43||LA37_1==93) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // InternalAceGen.g:1188:4: (lv_whenBlock_2_0= ruleClientWhenBlock )
                    {
                    // InternalAceGen.g:1188:4: (lv_whenBlock_2_0= ruleClientWhenBlock )
                    // InternalAceGen.g:1189:5: lv_whenBlock_2_0= ruleClientWhenBlock
                    {

                    					newCompositeNode(grammarAccess.getClientWhenThenAccess().getWhenBlockClientWhenBlockParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_36);
                    lv_whenBlock_2_0=ruleClientWhenBlock();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getClientWhenThenRule());
                    					}
                    					set(
                    						current,
                    						"whenBlock",
                    						lv_whenBlock_2_0,
                    						"de.acegen.AceGen.ClientWhenBlock");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1206:3: (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==27) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalAceGen.g:1207:4: otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_22); 

                    				newLeafNode(otherlv_3, grammarAccess.getClientWhenThenAccess().getDelayInMillisKeyword_3_0());
                    			
                    // InternalAceGen.g:1211:4: ( (lv_delayInMillis_4_0= RULE_INT ) )
                    // InternalAceGen.g:1212:5: (lv_delayInMillis_4_0= RULE_INT )
                    {
                    // InternalAceGen.g:1212:5: (lv_delayInMillis_4_0= RULE_INT )
                    // InternalAceGen.g:1213:6: lv_delayInMillis_4_0= RULE_INT
                    {
                    lv_delayInMillis_4_0=(Token)match(input,RULE_INT,FOLLOW_37); 

                    						newLeafNode(lv_delayInMillis_4_0, grammarAccess.getClientWhenThenAccess().getDelayInMillisINTTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClientWhenThenRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"delayInMillis",
                    							lv_delayInMillis_4_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:1230:3: (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==41) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalAceGen.g:1231:4: otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) )
                    {
                    otherlv_5=(Token)match(input,41,FOLLOW_38); 

                    				newLeafNode(otherlv_5, grammarAccess.getClientWhenThenAccess().getTHENKeyword_4_0());
                    			
                    // InternalAceGen.g:1235:4: ( (lv_thenBlock_6_0= ruleClientThenBlock ) )
                    // InternalAceGen.g:1236:5: (lv_thenBlock_6_0= ruleClientThenBlock )
                    {
                    // InternalAceGen.g:1236:5: (lv_thenBlock_6_0= ruleClientThenBlock )
                    // InternalAceGen.g:1237:6: lv_thenBlock_6_0= ruleClientThenBlock
                    {

                    						newCompositeNode(grammarAccess.getClientWhenThenAccess().getThenBlockClientThenBlockParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_thenBlock_6_0=ruleClientThenBlock();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClientWhenThenRule());
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
    // $ANTLR end "ruleClientWhenThen"


    // $ANTLR start "entryRuleClientGivenRef"
    // InternalAceGen.g:1259:1: entryRuleClientGivenRef returns [EObject current=null] : iv_ruleClientGivenRef= ruleClientGivenRef EOF ;
    public final EObject entryRuleClientGivenRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientGivenRef = null;


        try {
            // InternalAceGen.g:1259:55: (iv_ruleClientGivenRef= ruleClientGivenRef EOF )
            // InternalAceGen.g:1260:2: iv_ruleClientGivenRef= ruleClientGivenRef EOF
            {
             newCompositeNode(grammarAccess.getClientGivenRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClientGivenRef=ruleClientGivenRef();

            state._fsp--;

             current =iv_ruleClientGivenRef; 
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
    // $ANTLR end "entryRuleClientGivenRef"


    // $ANTLR start "ruleClientGivenRef"
    // InternalAceGen.g:1266:1: ruleClientGivenRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )? ) ;
    public final EObject ruleClientGivenRef() throws RecognitionException {
        EObject current = null;

        Token lv_excludeGiven_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalAceGen.g:1272:2: ( ( ( ( ruleQualifiedName ) ) ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )? ) )
            // InternalAceGen.g:1273:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )? )
            {
            // InternalAceGen.g:1273:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )? )
            // InternalAceGen.g:1274:3: ( ( ruleQualifiedName ) ) ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )?
            {
            // InternalAceGen.g:1274:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1275:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1275:4: ( ruleQualifiedName )
            // InternalAceGen.g:1276:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClientGivenRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClientGivenRefAccess().getScenarioClientScenarioCrossReference_0_0());
            				
            pushFollow(FOLLOW_39);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1290:3: ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==42) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalAceGen.g:1291:4: ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN'
                    {
                    // InternalAceGen.g:1291:4: ( (lv_excludeGiven_1_0= 'exclude' ) )
                    // InternalAceGen.g:1292:5: (lv_excludeGiven_1_0= 'exclude' )
                    {
                    // InternalAceGen.g:1292:5: (lv_excludeGiven_1_0= 'exclude' )
                    // InternalAceGen.g:1293:6: lv_excludeGiven_1_0= 'exclude'
                    {
                    lv_excludeGiven_1_0=(Token)match(input,42,FOLLOW_40); 

                    						newLeafNode(lv_excludeGiven_1_0, grammarAccess.getClientGivenRefAccess().getExcludeGivenExcludeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClientGivenRefRule());
                    						}
                    						setWithLastConsumed(current, "excludeGiven", lv_excludeGiven_1_0 != null, "exclude");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,38,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getClientGivenRefAccess().getGIVENKeyword_1_1());
                    			

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
    // $ANTLR end "ruleClientGivenRef"


    // $ANTLR start "entryRuleClientWhenBlock"
    // InternalAceGen.g:1314:1: entryRuleClientWhenBlock returns [EObject current=null] : iv_ruleClientWhenBlock= ruleClientWhenBlock EOF ;
    public final EObject entryRuleClientWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientWhenBlock = null;


        try {
            // InternalAceGen.g:1314:56: (iv_ruleClientWhenBlock= ruleClientWhenBlock EOF )
            // InternalAceGen.g:1315:2: iv_ruleClientWhenBlock= ruleClientWhenBlock EOF
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
    // InternalAceGen.g:1321:1: ruleClientWhenBlock returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )? ) ;
    public final EObject ruleClientWhenBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_inputValues_2_0 = null;

        EObject lv_inputValues_4_0 = null;

        EObject lv_squishyValues_7_0 = null;

        EObject lv_squishyValues_9_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1327:2: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )? ) )
            // InternalAceGen.g:1328:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )? )
            {
            // InternalAceGen.g:1328:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )? )
            // InternalAceGen.g:1329:3: ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )?
            {
            // InternalAceGen.g:1329:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1330:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1330:4: ( ruleQualifiedName )
            // InternalAceGen.g:1331:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClientWhenBlockRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClientWhenBlockAccess().getActionHttpClientAceCrossReference_0_0());
            				
            pushFollow(FOLLOW_41);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1345:3: (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==18) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalAceGen.g:1346:4: otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_42); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientWhenBlockAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalAceGen.g:1350:4: ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==RULE_ID) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalAceGen.g:1351:5: ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )*
                            {
                            // InternalAceGen.g:1351:5: ( (lv_inputValues_2_0= ruleInputValue ) )
                            // InternalAceGen.g:1352:6: (lv_inputValues_2_0= ruleInputValue )
                            {
                            // InternalAceGen.g:1352:6: (lv_inputValues_2_0= ruleInputValue )
                            // InternalAceGen.g:1353:7: lv_inputValues_2_0= ruleInputValue
                            {

                            							newCompositeNode(grammarAccess.getClientWhenBlockAccess().getInputValuesInputValueParserRuleCall_1_1_0_0());
                            						
                            pushFollow(FOLLOW_11);
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

                            // InternalAceGen.g:1370:5: (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )*
                            loop41:
                            do {
                                int alt41=2;
                                int LA41_0 = input.LA(1);

                                if ( (LA41_0==19) ) {
                                    alt41=1;
                                }


                                switch (alt41) {
                            	case 1 :
                            	    // InternalAceGen.g:1371:6: otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) )
                            	    {
                            	    otherlv_3=(Token)match(input,19,FOLLOW_9); 

                            	    						newLeafNode(otherlv_3, grammarAccess.getClientWhenBlockAccess().getCommaKeyword_1_1_1_0());
                            	    					
                            	    // InternalAceGen.g:1375:6: ( (lv_inputValues_4_0= ruleInputValue ) )
                            	    // InternalAceGen.g:1376:7: (lv_inputValues_4_0= ruleInputValue )
                            	    {
                            	    // InternalAceGen.g:1376:7: (lv_inputValues_4_0= ruleInputValue )
                            	    // InternalAceGen.g:1377:8: lv_inputValues_4_0= ruleInputValue
                            	    {

                            	    								newCompositeNode(grammarAccess.getClientWhenBlockAccess().getInputValuesInputValueParserRuleCall_1_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_11);
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
                            	    break loop41;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_43); 

                    				newLeafNode(otherlv_5, grammarAccess.getClientWhenBlockAccess().getRightParenthesisKeyword_1_2());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:1401:3: (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==43) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAceGen.g:1402:4: otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )*
                    {
                    otherlv_6=(Token)match(input,43,FOLLOW_29); 

                    				newLeafNode(otherlv_6, grammarAccess.getClientWhenBlockAccess().getSquishyValuesKeyword_2_0());
                    			
                    // InternalAceGen.g:1406:4: ( (lv_squishyValues_7_0= ruleSquishyValue ) )
                    // InternalAceGen.g:1407:5: (lv_squishyValues_7_0= ruleSquishyValue )
                    {
                    // InternalAceGen.g:1407:5: (lv_squishyValues_7_0= ruleSquishyValue )
                    // InternalAceGen.g:1408:6: lv_squishyValues_7_0= ruleSquishyValue
                    {

                    						newCompositeNode(grammarAccess.getClientWhenBlockAccess().getSquishyValuesSquishyValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_squishyValues_7_0=ruleSquishyValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClientWhenBlockRule());
                    						}
                    						add(
                    							current,
                    							"squishyValues",
                    							lv_squishyValues_7_0,
                    							"de.acegen.AceGen.SquishyValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:1425:4: (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==19) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalAceGen.g:1426:5: otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) )
                    	    {
                    	    otherlv_8=(Token)match(input,19,FOLLOW_29); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getClientWhenBlockAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:1430:5: ( (lv_squishyValues_9_0= ruleSquishyValue ) )
                    	    // InternalAceGen.g:1431:6: (lv_squishyValues_9_0= ruleSquishyValue )
                    	    {
                    	    // InternalAceGen.g:1431:6: (lv_squishyValues_9_0= ruleSquishyValue )
                    	    // InternalAceGen.g:1432:7: lv_squishyValues_9_0= ruleSquishyValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getClientWhenBlockAccess().getSquishyValuesSquishyValueParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_44);
                    	    lv_squishyValues_9_0=ruleSquishyValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getClientWhenBlockRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"squishyValues",
                    	    								lv_squishyValues_9_0,
                    	    								"de.acegen.AceGen.SquishyValue");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


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


    // $ANTLR start "entryRuleSquishyValue"
    // InternalAceGen.g:1455:1: entryRuleSquishyValue returns [EObject current=null] : iv_ruleSquishyValue= ruleSquishyValue EOF ;
    public final EObject entryRuleSquishyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquishyValue = null;


        try {
            // InternalAceGen.g:1455:53: (iv_ruleSquishyValue= ruleSquishyValue EOF )
            // InternalAceGen.g:1456:2: iv_ruleSquishyValue= ruleSquishyValue EOF
            {
             newCompositeNode(grammarAccess.getSquishyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSquishyValue=ruleSquishyValue();

            state._fsp--;

             current =iv_ruleSquishyValue; 
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
    // $ANTLR end "entryRuleSquishyValue"


    // $ANTLR start "ruleSquishyValue"
    // InternalAceGen.g:1462:1: ruleSquishyValue returns [EObject current=null] : ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' ) ;
    public final EObject ruleSquishyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_uuid_3_0=null;
        Token otherlv_4=null;
        Token lv_clientSystemTime_5_0=null;
        Token otherlv_6=null;
        Token lv_serverSystemTime_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_value_11_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1468:2: ( ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' ) )
            // InternalAceGen.g:1469:2: ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' )
            {
            // InternalAceGen.g:1469:2: ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' )
            // InternalAceGen.g:1470:3: () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}'
            {
            // InternalAceGen.g:1470:3: ()
            // InternalAceGen.g:1471:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSquishyValueAccess().getSquishyValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_45); 

            			newLeafNode(otherlv_1, grammarAccess.getSquishyValueAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:1481:3: (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==44) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalAceGen.g:1482:4: otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )?
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_46); 

                    				newLeafNode(otherlv_2, grammarAccess.getSquishyValueAccess().getUuidKeyword_2_0());
                    			
                    // InternalAceGen.g:1486:4: ( (lv_uuid_3_0= RULE_STRING ) )
                    // InternalAceGen.g:1487:5: (lv_uuid_3_0= RULE_STRING )
                    {
                    // InternalAceGen.g:1487:5: (lv_uuid_3_0= RULE_STRING )
                    // InternalAceGen.g:1488:6: lv_uuid_3_0= RULE_STRING
                    {
                    lv_uuid_3_0=(Token)match(input,RULE_STRING,FOLLOW_47); 

                    						newLeafNode(lv_uuid_3_0, grammarAccess.getSquishyValueAccess().getUuidSTRINGTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSquishyValueRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"uuid",
                    							lv_uuid_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    // InternalAceGen.g:1504:4: (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==45) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalAceGen.g:1505:5: otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) )
                            {
                            otherlv_4=(Token)match(input,45,FOLLOW_46); 

                            					newLeafNode(otherlv_4, grammarAccess.getSquishyValueAccess().getClientSystemTimeKeyword_2_2_0());
                            				
                            // InternalAceGen.g:1509:5: ( (lv_clientSystemTime_5_0= RULE_STRING ) )
                            // InternalAceGen.g:1510:6: (lv_clientSystemTime_5_0= RULE_STRING )
                            {
                            // InternalAceGen.g:1510:6: (lv_clientSystemTime_5_0= RULE_STRING )
                            // InternalAceGen.g:1511:7: lv_clientSystemTime_5_0= RULE_STRING
                            {
                            lv_clientSystemTime_5_0=(Token)match(input,RULE_STRING,FOLLOW_48); 

                            							newLeafNode(lv_clientSystemTime_5_0, grammarAccess.getSquishyValueAccess().getClientSystemTimeSTRINGTerminalRuleCall_2_2_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSquishyValueRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"clientSystemTime",
                            								lv_clientSystemTime_5_0,
                            								"org.eclipse.xtext.common.Terminals.STRING");
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalAceGen.g:1528:4: (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==46) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalAceGen.g:1529:5: otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) )
                            {
                            otherlv_6=(Token)match(input,46,FOLLOW_46); 

                            					newLeafNode(otherlv_6, grammarAccess.getSquishyValueAccess().getServerSystemTimeKeyword_2_3_0());
                            				
                            // InternalAceGen.g:1533:5: ( (lv_serverSystemTime_7_0= RULE_STRING ) )
                            // InternalAceGen.g:1534:6: (lv_serverSystemTime_7_0= RULE_STRING )
                            {
                            // InternalAceGen.g:1534:6: (lv_serverSystemTime_7_0= RULE_STRING )
                            // InternalAceGen.g:1535:7: lv_serverSystemTime_7_0= RULE_STRING
                            {
                            lv_serverSystemTime_7_0=(Token)match(input,RULE_STRING,FOLLOW_49); 

                            							newLeafNode(lv_serverSystemTime_7_0, grammarAccess.getSquishyValueAccess().getServerSystemTimeSTRINGTerminalRuleCall_2_3_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSquishyValueRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"serverSystemTime",
                            								lv_serverSystemTime_7_0,
                            								"org.eclipse.xtext.common.Terminals.STRING");
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalAceGen.g:1552:4: (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==47) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // InternalAceGen.g:1553:5: otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) )
                            {
                            otherlv_8=(Token)match(input,47,FOLLOW_9); 

                            					newLeafNode(otherlv_8, grammarAccess.getSquishyValueAccess().getSquishyKeyword_2_4_0());
                            				
                            // InternalAceGen.g:1557:5: ( ( ruleQualifiedName ) )
                            // InternalAceGen.g:1558:6: ( ruleQualifiedName )
                            {
                            // InternalAceGen.g:1558:6: ( ruleQualifiedName )
                            // InternalAceGen.g:1559:7: ruleQualifiedName
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSquishyValueRule());
                            							}
                            						

                            							newCompositeNode(grammarAccess.getSquishyValueAccess().getAttributeAttributeCrossReference_2_4_1_0());
                            						
                            pushFollow(FOLLOW_50);
                            ruleQualifiedName();

                            state._fsp--;


                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_10=(Token)match(input,48,FOLLOW_51); 

                            					newLeafNode(otherlv_10, grammarAccess.getSquishyValueAccess().getColonKeyword_2_4_2());
                            				
                            // InternalAceGen.g:1577:5: ( (lv_value_11_0= rulePrimitiveValue ) )
                            // InternalAceGen.g:1578:6: (lv_value_11_0= rulePrimitiveValue )
                            {
                            // InternalAceGen.g:1578:6: (lv_value_11_0= rulePrimitiveValue )
                            // InternalAceGen.g:1579:7: lv_value_11_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getSquishyValueAccess().getValuePrimitiveValueParserRuleCall_2_4_3_0());
                            						
                            pushFollow(FOLLOW_31);
                            lv_value_11_0=rulePrimitiveValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getSquishyValueRule());
                            							}
                            							set(
                            								current,
                            								"value",
                            								lv_value_11_0,
                            								"de.acegen.AceGen.PrimitiveValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,37,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getSquishyValueAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleSquishyValue"


    // $ANTLR start "entryRuleInputValue"
    // InternalAceGen.g:1606:1: entryRuleInputValue returns [EObject current=null] : iv_ruleInputValue= ruleInputValue EOF ;
    public final EObject entryRuleInputValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputValue = null;


        try {
            // InternalAceGen.g:1606:51: (iv_ruleInputValue= ruleInputValue EOF )
            // InternalAceGen.g:1607:2: iv_ruleInputValue= ruleInputValue EOF
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
    // InternalAceGen.g:1613:1: ruleInputValue returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject ruleInputValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1619:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalAceGen.g:1620:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalAceGen.g:1620:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalAceGen.g:1621:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalAceGen.g:1621:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1622:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1622:4: ( ruleQualifiedName )
            // InternalAceGen.g:1623:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInputValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInputValueAccess().getInputInputCrossReference_0_0());
            				
            pushFollow(FOLLOW_50);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,48,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getInputValueAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:1641:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalAceGen.g:1642:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalAceGen.g:1642:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalAceGen.g:1643:5: lv_value_2_0= rulePrimitiveValue
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
    // InternalAceGen.g:1664:1: entryRuleClientThenBlock returns [EObject current=null] : iv_ruleClientThenBlock= ruleClientThenBlock EOF ;
    public final EObject entryRuleClientThenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientThenBlock = null;


        try {
            // InternalAceGen.g:1664:56: (iv_ruleClientThenBlock= ruleClientThenBlock EOF )
            // InternalAceGen.g:1665:2: iv_ruleClientThenBlock= ruleClientThenBlock EOF
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
    // InternalAceGen.g:1671:1: ruleClientThenBlock returns [EObject current=null] : ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )? ) ;
    public final EObject ruleClientThenBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_stateVerifications_2_0 = null;

        EObject lv_verifications_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1677:2: ( ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )? ) )
            // InternalAceGen.g:1678:2: ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )? )
            {
            // InternalAceGen.g:1678:2: ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )? )
            // InternalAceGen.g:1679:3: () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )?
            {
            // InternalAceGen.g:1679:3: ()
            // InternalAceGen.g:1680:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClientThenBlockAccess().getClientThenBlockAction_0(),
            					current);
            			

            }

            // InternalAceGen.g:1686:3: (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==49) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalAceGen.g:1687:4: otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )*
                    {
                    otherlv_1=(Token)match(input,49,FOLLOW_52); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientThenBlockAccess().getExpectedStateKeyword_1_0());
                    			
                    // InternalAceGen.g:1691:4: ( (lv_stateVerifications_2_0= ruleStateVerification ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==RULE_ID) ) {
                            int LA50_2 = input.LA(2);

                            if ( (LA50_2==RULE_ID) ) {
                                alt50=1;
                            }


                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalAceGen.g:1692:5: (lv_stateVerifications_2_0= ruleStateVerification )
                    	    {
                    	    // InternalAceGen.g:1692:5: (lv_stateVerifications_2_0= ruleStateVerification )
                    	    // InternalAceGen.g:1693:6: lv_stateVerifications_2_0= ruleStateVerification
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientThenBlockAccess().getStateVerificationsStateVerificationParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_52);
                    	    lv_stateVerifications_2_0=ruleStateVerification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClientThenBlockRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"stateVerifications",
                    	    							lv_stateVerifications_2_0,
                    	    							"de.acegen.AceGen.StateVerification");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1711:3: (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==50) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalAceGen.g:1712:4: otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )*
                    {
                    otherlv_3=(Token)match(input,50,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getClientThenBlockAccess().getVerificationsKeyword_2_0());
                    			
                    // InternalAceGen.g:1716:4: ( (lv_verifications_4_0= ruleCustomVerification ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==RULE_ID) ) {
                            int LA52_2 = input.LA(2);

                            if ( (LA52_2==EOF||LA52_2==RULE_ID||LA52_2==18||LA52_2==39) ) {
                                alt52=1;
                            }


                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalAceGen.g:1717:5: (lv_verifications_4_0= ruleCustomVerification )
                    	    {
                    	    // InternalAceGen.g:1717:5: (lv_verifications_4_0= ruleCustomVerification )
                    	    // InternalAceGen.g:1718:6: lv_verifications_4_0= ruleCustomVerification
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientThenBlockAccess().getVerificationsCustomVerificationParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_3);
                    	    lv_verifications_4_0=ruleCustomVerification();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClientThenBlockRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"verifications",
                    	    							lv_verifications_4_0,
                    	    							"de.acegen.AceGen.CustomVerification");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
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


    // $ANTLR start "entryRuleStateVerification"
    // InternalAceGen.g:1740:1: entryRuleStateVerification returns [EObject current=null] : iv_ruleStateVerification= ruleStateVerification EOF ;
    public final EObject entryRuleStateVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateVerification = null;


        try {
            // InternalAceGen.g:1740:58: (iv_ruleStateVerification= ruleStateVerification EOF )
            // InternalAceGen.g:1741:2: iv_ruleStateVerification= ruleStateVerification EOF
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
    // InternalAceGen.g:1747:1: ruleStateVerification returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'should' ( (lv_not_3_0= 'not' ) )? otherlv_4= 'be' ( (lv_value_5_0= ruleJsonValueClient ) ) ) ;
    public final EObject ruleStateVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token lv_not_3_0=null;
        Token otherlv_4=null;
        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1753:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'should' ( (lv_not_3_0= 'not' ) )? otherlv_4= 'be' ( (lv_value_5_0= ruleJsonValueClient ) ) ) )
            // InternalAceGen.g:1754:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'should' ( (lv_not_3_0= 'not' ) )? otherlv_4= 'be' ( (lv_value_5_0= ruleJsonValueClient ) ) )
            {
            // InternalAceGen.g:1754:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'should' ( (lv_not_3_0= 'not' ) )? otherlv_4= 'be' ( (lv_value_5_0= ruleJsonValueClient ) ) )
            // InternalAceGen.g:1755:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'should' ( (lv_not_3_0= 'not' ) )? otherlv_4= 'be' ( (lv_value_5_0= ruleJsonValueClient ) )
            {
            // InternalAceGen.g:1755:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1756:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1756:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1757:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            // InternalAceGen.g:1773:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1774:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1774:4: ( ruleQualifiedName )
            // InternalAceGen.g:1775:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateVerificationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStateVerificationAccess().getStateRefClientAttributeCrossReference_1_0());
            				
            pushFollow(FOLLOW_53);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,51,FOLLOW_54); 

            			newLeafNode(otherlv_2, grammarAccess.getStateVerificationAccess().getShouldKeyword_2());
            		
            // InternalAceGen.g:1793:3: ( (lv_not_3_0= 'not' ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==52) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalAceGen.g:1794:4: (lv_not_3_0= 'not' )
                    {
                    // InternalAceGen.g:1794:4: (lv_not_3_0= 'not' )
                    // InternalAceGen.g:1795:5: lv_not_3_0= 'not'
                    {
                    lv_not_3_0=(Token)match(input,52,FOLLOW_55); 

                    					newLeafNode(lv_not_3_0, grammarAccess.getStateVerificationAccess().getNotNotKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getStateVerificationRule());
                    					}
                    					setWithLastConsumed(current, "not", lv_not_3_0 != null, "not");
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,53,FOLLOW_56); 

            			newLeafNode(otherlv_4, grammarAccess.getStateVerificationAccess().getBeKeyword_4());
            		
            // InternalAceGen.g:1811:3: ( (lv_value_5_0= ruleJsonValueClient ) )
            // InternalAceGen.g:1812:4: (lv_value_5_0= ruleJsonValueClient )
            {
            // InternalAceGen.g:1812:4: (lv_value_5_0= ruleJsonValueClient )
            // InternalAceGen.g:1813:5: lv_value_5_0= ruleJsonValueClient
            {

            					newCompositeNode(grammarAccess.getStateVerificationAccess().getValueJsonValueClientParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_5_0=ruleJsonValueClient();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateVerificationRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_5_0,
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


    // $ANTLR start "entryRuleCustomVerification"
    // InternalAceGen.g:1834:1: entryRuleCustomVerification returns [EObject current=null] : iv_ruleCustomVerification= ruleCustomVerification EOF ;
    public final EObject entryRuleCustomVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomVerification = null;


        try {
            // InternalAceGen.g:1834:59: (iv_ruleCustomVerification= ruleCustomVerification EOF )
            // InternalAceGen.g:1835:2: iv_ruleCustomVerification= ruleCustomVerification EOF
            {
             newCompositeNode(grammarAccess.getCustomVerificationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCustomVerification=ruleCustomVerification();

            state._fsp--;

             current =iv_ruleCustomVerification; 
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
    // $ANTLR end "entryRuleCustomVerification"


    // $ANTLR start "ruleCustomVerification"
    // InternalAceGen.g:1841:1: ruleCustomVerification returns [EObject current=null] : ( ( (lv_functionName_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCustomVerification() throws RecognitionException {
        EObject current = null;

        Token lv_functionName_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalAceGen.g:1847:2: ( ( ( (lv_functionName_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? ) )
            // InternalAceGen.g:1848:2: ( ( (lv_functionName_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? )
            {
            // InternalAceGen.g:1848:2: ( ( (lv_functionName_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? )
            // InternalAceGen.g:1849:3: ( (lv_functionName_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )?
            {
            // InternalAceGen.g:1849:3: ( (lv_functionName_0_0= RULE_ID ) )
            // InternalAceGen.g:1850:4: (lv_functionName_0_0= RULE_ID )
            {
            // InternalAceGen.g:1850:4: (lv_functionName_0_0= RULE_ID )
            // InternalAceGen.g:1851:5: lv_functionName_0_0= RULE_ID
            {
            lv_functionName_0_0=(Token)match(input,RULE_ID,FOLLOW_57); 

            					newLeafNode(lv_functionName_0_0, grammarAccess.getCustomVerificationAccess().getFunctionNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCustomVerificationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"functionName",
            						lv_functionName_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:1867:3: (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==18) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalAceGen.g:1868:4: otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getCustomVerificationAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalAceGen.g:1872:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:1873:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:1873:5: ( ruleQualifiedName )
                    // InternalAceGen.g:1874:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCustomVerificationRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCustomVerificationAccess().getStateRefClientAttributeCrossReference_1_1_0());
                    					
                    pushFollow(FOLLOW_58);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getCustomVerificationAccess().getRightParenthesisKeyword_1_2());
                    			

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
    // $ANTLR end "ruleCustomVerification"


    // $ANTLR start "entryRuleJsonObjectClient"
    // InternalAceGen.g:1897:1: entryRuleJsonObjectClient returns [EObject current=null] : iv_ruleJsonObjectClient= ruleJsonObjectClient EOF ;
    public final EObject entryRuleJsonObjectClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObjectClient = null;


        try {
            // InternalAceGen.g:1897:57: (iv_ruleJsonObjectClient= ruleJsonObjectClient EOF )
            // InternalAceGen.g:1898:2: iv_ruleJsonObjectClient= ruleJsonObjectClient EOF
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
    // InternalAceGen.g:1904:1: ruleJsonObjectClient returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleJsonObjectClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_members_2_0 = null;

        EObject lv_members_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1910:2: ( ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' ) )
            // InternalAceGen.g:1911:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' )
            {
            // InternalAceGen.g:1911:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' )
            // InternalAceGen.g:1912:3: () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}'
            {
            // InternalAceGen.g:1912:3: ()
            // InternalAceGen.g:1913:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonObjectClientAccess().getJsonObjectClientAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonObjectClientAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:1923:3: ( (lv_members_2_0= ruleJsonMemberClient ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalAceGen.g:1924:4: (lv_members_2_0= ruleJsonMemberClient )
                    {
                    // InternalAceGen.g:1924:4: (lv_members_2_0= ruleJsonMemberClient )
                    // InternalAceGen.g:1925:5: lv_members_2_0= ruleJsonMemberClient
                    {

                    					newCompositeNode(grammarAccess.getJsonObjectClientAccess().getMembersJsonMemberClientParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_60);
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

            // InternalAceGen.g:1942:3: (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==19) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalAceGen.g:1943:4: otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_9); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonObjectClientAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:1947:4: ( (lv_members_4_0= ruleJsonMemberClient ) )
            	    // InternalAceGen.g:1948:5: (lv_members_4_0= ruleJsonMemberClient )
            	    {
            	    // InternalAceGen.g:1948:5: (lv_members_4_0= ruleJsonMemberClient )
            	    // InternalAceGen.g:1949:6: lv_members_4_0= ruleJsonMemberClient
            	    {

            	    						newCompositeNode(grammarAccess.getJsonObjectClientAccess().getMembersJsonMemberClientParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_60);
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
            	    break loop57;
                }
            } while (true);

            otherlv_5=(Token)match(input,37,FOLLOW_2); 

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
    // InternalAceGen.g:1975:1: entryRuleJsonMemberClient returns [EObject current=null] : iv_ruleJsonMemberClient= ruleJsonMemberClient EOF ;
    public final EObject entryRuleJsonMemberClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonMemberClient = null;


        try {
            // InternalAceGen.g:1975:57: (iv_ruleJsonMemberClient= ruleJsonMemberClient EOF )
            // InternalAceGen.g:1976:2: iv_ruleJsonMemberClient= ruleJsonMemberClient EOF
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
    // InternalAceGen.g:1982:1: ruleJsonMemberClient returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) ) ;
    public final EObject ruleJsonMemberClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1988:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) ) )
            // InternalAceGen.g:1989:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) )
            {
            // InternalAceGen.g:1989:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) )
            // InternalAceGen.g:1990:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) )
            {
            // InternalAceGen.g:1990:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1991:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1991:4: ( ruleQualifiedName )
            // InternalAceGen.g:1992:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonMemberClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJsonMemberClientAccess().getAttributeClientAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_50);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,48,FOLLOW_56); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonMemberClientAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:2010:3: ( (lv_value_2_0= ruleJsonValueClient ) )
            // InternalAceGen.g:2011:4: (lv_value_2_0= ruleJsonValueClient )
            {
            // InternalAceGen.g:2011:4: (lv_value_2_0= ruleJsonValueClient )
            // InternalAceGen.g:2012:5: lv_value_2_0= ruleJsonValueClient
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
    // InternalAceGen.g:2033:1: entryRuleJsonValueClient returns [EObject current=null] : iv_ruleJsonValueClient= ruleJsonValueClient EOF ;
    public final EObject entryRuleJsonValueClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonValueClient = null;


        try {
            // InternalAceGen.g:2033:56: (iv_ruleJsonValueClient= ruleJsonValueClient EOF )
            // InternalAceGen.g:2034:2: iv_ruleJsonValueClient= ruleJsonValueClient EOF
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
    // InternalAceGen.g:2040:1: ruleJsonValueClient returns [EObject current=null] : (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType ) ;
    public final EObject ruleJsonValueClient() throws RecognitionException {
        EObject current = null;

        EObject this_JsonObjectClient_0 = null;

        EObject this_StringType_1 = null;

        EObject this_JsonArrayClient_2 = null;

        EObject this_BooleanType_3 = null;

        EObject this_NullType_4 = null;

        EObject this_LongType_5 = null;

        EObject this_JsonDateTime_6 = null;

        EObject this_UndefinedType_7 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2046:2: ( (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType ) )
            // InternalAceGen.g:2047:2: (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType )
            {
            // InternalAceGen.g:2047:2: (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType )
            int alt58=8;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // InternalAceGen.g:2048:3: this_JsonObjectClient_0= ruleJsonObjectClient
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
                    // InternalAceGen.g:2057:3: this_StringType_1= ruleStringType
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
                    // InternalAceGen.g:2066:3: this_JsonArrayClient_2= ruleJsonArrayClient
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
                    // InternalAceGen.g:2075:3: this_BooleanType_3= ruleBooleanType
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
                    // InternalAceGen.g:2084:3: this_NullType_4= ruleNullType
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
                    // InternalAceGen.g:2093:3: this_LongType_5= ruleLongType
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
                    // InternalAceGen.g:2102:3: this_JsonDateTime_6= ruleJsonDateTime
                    {

                    			newCompositeNode(grammarAccess.getJsonValueClientAccess().getJsonDateTimeParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_JsonDateTime_6=ruleJsonDateTime();

                    state._fsp--;


                    			current = this_JsonDateTime_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalAceGen.g:2111:3: this_UndefinedType_7= ruleUndefinedType
                    {

                    			newCompositeNode(grammarAccess.getJsonValueClientAccess().getUndefinedTypeParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_UndefinedType_7=ruleUndefinedType();

                    state._fsp--;


                    			current = this_UndefinedType_7;
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
    // InternalAceGen.g:2123:1: entryRuleJsonArrayClient returns [EObject current=null] : iv_ruleJsonArrayClient= ruleJsonArrayClient EOF ;
    public final EObject entryRuleJsonArrayClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonArrayClient = null;


        try {
            // InternalAceGen.g:2123:56: (iv_ruleJsonArrayClient= ruleJsonArrayClient EOF )
            // InternalAceGen.g:2124:2: iv_ruleJsonArrayClient= ruleJsonArrayClient EOF
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
    // InternalAceGen.g:2130:1: ruleJsonArrayClient returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleJsonArrayClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2136:2: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' ) )
            // InternalAceGen.g:2137:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' )
            {
            // InternalAceGen.g:2137:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' )
            // InternalAceGen.g:2138:3: () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']'
            {
            // InternalAceGen.g:2138:3: ()
            // InternalAceGen.g:2139:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonArrayClientAccess().getJsonArrayClientAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,54,FOLLOW_61); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonArrayClientAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalAceGen.g:2149:3: ( (lv_values_2_0= ruleJsonValueClient ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( ((LA59_0>=RULE_INT && LA59_0<=RULE_STRING)||LA59_0==35||LA59_0==54||LA59_0==87||(LA59_0>=106 && LA59_0<=108)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalAceGen.g:2150:4: (lv_values_2_0= ruleJsonValueClient )
                    {
                    // InternalAceGen.g:2150:4: (lv_values_2_0= ruleJsonValueClient )
                    // InternalAceGen.g:2151:5: lv_values_2_0= ruleJsonValueClient
                    {

                    					newCompositeNode(grammarAccess.getJsonArrayClientAccess().getValuesJsonValueClientParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_62);
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

            // InternalAceGen.g:2168:3: (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==19) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalAceGen.g:2169:4: otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_56); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonArrayClientAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:2173:4: ( (lv_values_4_0= ruleJsonValueClient ) )
            	    // InternalAceGen.g:2174:5: (lv_values_4_0= ruleJsonValueClient )
            	    {
            	    // InternalAceGen.g:2174:5: (lv_values_4_0= ruleJsonValueClient )
            	    // InternalAceGen.g:2175:6: lv_values_4_0= ruleJsonValueClient
            	    {

            	    						newCompositeNode(grammarAccess.getJsonArrayClientAccess().getValuesJsonValueClientParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_62);
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
            	    break loop60;
                }
            } while (true);

            otherlv_5=(Token)match(input,55,FOLLOW_2); 

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
    // InternalAceGen.g:2201:1: entryRuleHttpServer returns [EObject current=null] : iv_ruleHttpServer= ruleHttpServer EOF ;
    public final EObject entryRuleHttpServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServer = null;


        try {
            // InternalAceGen.g:2201:51: (iv_ruleHttpServer= ruleHttpServer EOF )
            // InternalAceGen.g:2202:2: iv_ruleHttpServer= ruleHttpServer EOF
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
    // InternalAceGen.g:2208:1: ruleHttpServer returns [EObject current=null] : ( ( (lv_java_0_0= 'Java' ) )? ( (lv_cs_1_0= 'C#' ) )? ( (lv_dropwizard_2_0= 'Dropwizard' ) )? ( (lv_dotnet_3_0= 'NET6' ) )? ( (lv_JDBI3_4_0= 'JDBI3' ) )? ( (lv_EF_5_0= 'EntityFramework' ) )? ( (lv_liquibase_6_0= 'Liquibase' ) )? ( (lv_name_7_0= ruleQualifiedName ) ) (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )? (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )? (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )? (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )? (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )? ) ;
    public final EObject ruleHttpServer() throws RecognitionException {
        EObject current = null;

        Token lv_java_0_0=null;
        Token lv_cs_1_0=null;
        Token lv_dropwizard_2_0=null;
        Token lv_dotnet_3_0=null;
        Token lv_JDBI3_4_0=null;
        Token lv_EF_5_0=null;
        Token lv_liquibase_6_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_name_7_0 = null;

        EObject lv_authUser_9_0 = null;

        EObject lv_aceOperations_13_0 = null;

        EObject lv_views_15_0 = null;

        EObject lv_models_17_0 = null;

        EObject lv_scenarios_19_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2214:2: ( ( ( (lv_java_0_0= 'Java' ) )? ( (lv_cs_1_0= 'C#' ) )? ( (lv_dropwizard_2_0= 'Dropwizard' ) )? ( (lv_dotnet_3_0= 'NET6' ) )? ( (lv_JDBI3_4_0= 'JDBI3' ) )? ( (lv_EF_5_0= 'EntityFramework' ) )? ( (lv_liquibase_6_0= 'Liquibase' ) )? ( (lv_name_7_0= ruleQualifiedName ) ) (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )? (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )? (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )? (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )? (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )? ) )
            // InternalAceGen.g:2215:2: ( ( (lv_java_0_0= 'Java' ) )? ( (lv_cs_1_0= 'C#' ) )? ( (lv_dropwizard_2_0= 'Dropwizard' ) )? ( (lv_dotnet_3_0= 'NET6' ) )? ( (lv_JDBI3_4_0= 'JDBI3' ) )? ( (lv_EF_5_0= 'EntityFramework' ) )? ( (lv_liquibase_6_0= 'Liquibase' ) )? ( (lv_name_7_0= ruleQualifiedName ) ) (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )? (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )? (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )? (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )? (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )? )
            {
            // InternalAceGen.g:2215:2: ( ( (lv_java_0_0= 'Java' ) )? ( (lv_cs_1_0= 'C#' ) )? ( (lv_dropwizard_2_0= 'Dropwizard' ) )? ( (lv_dotnet_3_0= 'NET6' ) )? ( (lv_JDBI3_4_0= 'JDBI3' ) )? ( (lv_EF_5_0= 'EntityFramework' ) )? ( (lv_liquibase_6_0= 'Liquibase' ) )? ( (lv_name_7_0= ruleQualifiedName ) ) (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )? (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )? (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )? (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )? (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )? )
            // InternalAceGen.g:2216:3: ( (lv_java_0_0= 'Java' ) )? ( (lv_cs_1_0= 'C#' ) )? ( (lv_dropwizard_2_0= 'Dropwizard' ) )? ( (lv_dotnet_3_0= 'NET6' ) )? ( (lv_JDBI3_4_0= 'JDBI3' ) )? ( (lv_EF_5_0= 'EntityFramework' ) )? ( (lv_liquibase_6_0= 'Liquibase' ) )? ( (lv_name_7_0= ruleQualifiedName ) ) (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )? (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )? (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )? (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )? (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )?
            {
            // InternalAceGen.g:2216:3: ( (lv_java_0_0= 'Java' ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==56) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalAceGen.g:2217:4: (lv_java_0_0= 'Java' )
                    {
                    // InternalAceGen.g:2217:4: (lv_java_0_0= 'Java' )
                    // InternalAceGen.g:2218:5: lv_java_0_0= 'Java'
                    {
                    lv_java_0_0=(Token)match(input,56,FOLLOW_63); 

                    					newLeafNode(lv_java_0_0, grammarAccess.getHttpServerAccess().getJavaJavaKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "java", lv_java_0_0 != null, "Java");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2230:3: ( (lv_cs_1_0= 'C#' ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==57) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalAceGen.g:2231:4: (lv_cs_1_0= 'C#' )
                    {
                    // InternalAceGen.g:2231:4: (lv_cs_1_0= 'C#' )
                    // InternalAceGen.g:2232:5: lv_cs_1_0= 'C#'
                    {
                    lv_cs_1_0=(Token)match(input,57,FOLLOW_64); 

                    					newLeafNode(lv_cs_1_0, grammarAccess.getHttpServerAccess().getCsCKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "cs", lv_cs_1_0 != null, "C#");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2244:3: ( (lv_dropwizard_2_0= 'Dropwizard' ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==58) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalAceGen.g:2245:4: (lv_dropwizard_2_0= 'Dropwizard' )
                    {
                    // InternalAceGen.g:2245:4: (lv_dropwizard_2_0= 'Dropwizard' )
                    // InternalAceGen.g:2246:5: lv_dropwizard_2_0= 'Dropwizard'
                    {
                    lv_dropwizard_2_0=(Token)match(input,58,FOLLOW_65); 

                    					newLeafNode(lv_dropwizard_2_0, grammarAccess.getHttpServerAccess().getDropwizardDropwizardKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "dropwizard", lv_dropwizard_2_0 != null, "Dropwizard");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2258:3: ( (lv_dotnet_3_0= 'NET6' ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==59) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalAceGen.g:2259:4: (lv_dotnet_3_0= 'NET6' )
                    {
                    // InternalAceGen.g:2259:4: (lv_dotnet_3_0= 'NET6' )
                    // InternalAceGen.g:2260:5: lv_dotnet_3_0= 'NET6'
                    {
                    lv_dotnet_3_0=(Token)match(input,59,FOLLOW_66); 

                    					newLeafNode(lv_dotnet_3_0, grammarAccess.getHttpServerAccess().getDotnetNET6Keyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "dotnet", lv_dotnet_3_0 != null, "NET6");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2272:3: ( (lv_JDBI3_4_0= 'JDBI3' ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==60) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalAceGen.g:2273:4: (lv_JDBI3_4_0= 'JDBI3' )
                    {
                    // InternalAceGen.g:2273:4: (lv_JDBI3_4_0= 'JDBI3' )
                    // InternalAceGen.g:2274:5: lv_JDBI3_4_0= 'JDBI3'
                    {
                    lv_JDBI3_4_0=(Token)match(input,60,FOLLOW_67); 

                    					newLeafNode(lv_JDBI3_4_0, grammarAccess.getHttpServerAccess().getJDBI3JDBI3Keyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "JDBI3", lv_JDBI3_4_0 != null, "JDBI3");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2286:3: ( (lv_EF_5_0= 'EntityFramework' ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==61) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalAceGen.g:2287:4: (lv_EF_5_0= 'EntityFramework' )
                    {
                    // InternalAceGen.g:2287:4: (lv_EF_5_0= 'EntityFramework' )
                    // InternalAceGen.g:2288:5: lv_EF_5_0= 'EntityFramework'
                    {
                    lv_EF_5_0=(Token)match(input,61,FOLLOW_68); 

                    					newLeafNode(lv_EF_5_0, grammarAccess.getHttpServerAccess().getEFEntityFrameworkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "EF", lv_EF_5_0 != null, "EntityFramework");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2300:3: ( (lv_liquibase_6_0= 'Liquibase' ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==62) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalAceGen.g:2301:4: (lv_liquibase_6_0= 'Liquibase' )
                    {
                    // InternalAceGen.g:2301:4: (lv_liquibase_6_0= 'Liquibase' )
                    // InternalAceGen.g:2302:5: lv_liquibase_6_0= 'Liquibase'
                    {
                    lv_liquibase_6_0=(Token)match(input,62,FOLLOW_9); 

                    					newLeafNode(lv_liquibase_6_0, grammarAccess.getHttpServerAccess().getLiquibaseLiquibaseKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "liquibase", lv_liquibase_6_0 != null, "Liquibase");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2314:3: ( (lv_name_7_0= ruleQualifiedName ) )
            // InternalAceGen.g:2315:4: (lv_name_7_0= ruleQualifiedName )
            {
            // InternalAceGen.g:2315:4: (lv_name_7_0= ruleQualifiedName )
            // InternalAceGen.g:2316:5: lv_name_7_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getHttpServerAccess().getNameQualifiedNameParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_69);
            lv_name_7_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHttpServerRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_7_0,
            						"de.acegen.AceGen.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:2333:3: (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==63) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalAceGen.g:2334:4: otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) )
                    {
                    otherlv_8=(Token)match(input,63,FOLLOW_9); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerAccess().getAuthorizationKeyword_8_0());
                    			
                    // InternalAceGen.g:2338:4: ( (lv_authUser_9_0= ruleAuthUser ) )
                    // InternalAceGen.g:2339:5: (lv_authUser_9_0= ruleAuthUser )
                    {
                    // InternalAceGen.g:2339:5: (lv_authUser_9_0= ruleAuthUser )
                    // InternalAceGen.g:2340:6: lv_authUser_9_0= ruleAuthUser
                    {

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserAuthUserParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_70);
                    lv_authUser_9_0=ruleAuthUser();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    						}
                    						set(
                    							current,
                    							"authUser",
                    							lv_authUser_9_0,
                    							"de.acegen.AceGen.AuthUser");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:2358:3: (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==64) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalAceGen.g:2359:4: otherlv_10= 'import' ( ( ruleQualifiedName ) )
                    {
                    otherlv_10=(Token)match(input,64,FOLLOW_9); 

                    				newLeafNode(otherlv_10, grammarAccess.getHttpServerAccess().getImportKeyword_9_0());
                    			
                    // InternalAceGen.g:2363:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:2364:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:2364:5: ( ruleQualifiedName )
                    // InternalAceGen.g:2365:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpServerRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_9_1_0());
                    					
                    pushFollow(FOLLOW_71);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:2380:3: (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==13) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalAceGen.g:2381:4: otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )*
                    {
                    otherlv_12=(Token)match(input,13,FOLLOW_72); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpServerAccess().getACEKeyword_10_0());
                    			
                    // InternalAceGen.g:2385:4: ( (lv_aceOperations_13_0= ruleHttpServerAce ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==RULE_ID) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalAceGen.g:2386:5: (lv_aceOperations_13_0= ruleHttpServerAce )
                    	    {
                    	    // InternalAceGen.g:2386:5: (lv_aceOperations_13_0= ruleHttpServerAce )
                    	    // InternalAceGen.g:2387:6: lv_aceOperations_13_0= ruleHttpServerAce
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getAceOperationsHttpServerAceParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_72);
                    	    lv_aceOperations_13_0=ruleHttpServerAce();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aceOperations",
                    	    							lv_aceOperations_13_0,
                    	    							"de.acegen.AceGen.HttpServerAce");
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

            // InternalAceGen.g:2405:3: (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==65) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalAceGen.g:2406:4: otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )*
                    {
                    otherlv_14=(Token)match(input,65,FOLLOW_73); 

                    				newLeafNode(otherlv_14, grammarAccess.getHttpServerAccess().getViewsKeyword_11_0());
                    			
                    // InternalAceGen.g:2410:4: ( (lv_views_15_0= ruleHttpServerView ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==RULE_ID||LA72_0==76) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalAceGen.g:2411:5: (lv_views_15_0= ruleHttpServerView )
                    	    {
                    	    // InternalAceGen.g:2411:5: (lv_views_15_0= ruleHttpServerView )
                    	    // InternalAceGen.g:2412:6: lv_views_15_0= ruleHttpServerView
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getViewsHttpServerViewParserRuleCall_11_1_0());
                    	    					
                    	    pushFollow(FOLLOW_73);
                    	    lv_views_15_0=ruleHttpServerView();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"views",
                    	    							lv_views_15_0,
                    	    							"de.acegen.AceGen.HttpServerView");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2430:3: (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==66) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalAceGen.g:2431:4: otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )*
                    {
                    otherlv_16=(Token)match(input,66,FOLLOW_74); 

                    				newLeafNode(otherlv_16, grammarAccess.getHttpServerAccess().getModelsKeyword_12_0());
                    			
                    // InternalAceGen.g:2435:4: ( (lv_models_17_0= ruleModel ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==RULE_ID||LA74_0==77) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalAceGen.g:2436:5: (lv_models_17_0= ruleModel )
                    	    {
                    	    // InternalAceGen.g:2436:5: (lv_models_17_0= ruleModel )
                    	    // InternalAceGen.g:2437:6: lv_models_17_0= ruleModel
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getModelsModelParserRuleCall_12_1_0());
                    	    					
                    	    pushFollow(FOLLOW_74);
                    	    lv_models_17_0=ruleModel();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"models",
                    	    							lv_models_17_0,
                    	    							"de.acegen.AceGen.Model");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop74;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2455:3: (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==16) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalAceGen.g:2456:4: otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )*
                    {
                    otherlv_18=(Token)match(input,16,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getHttpServerAccess().getScenariosKeyword_13_0());
                    			
                    // InternalAceGen.g:2460:4: ( (lv_scenarios_19_0= ruleScenario ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==RULE_ID) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalAceGen.g:2461:5: (lv_scenarios_19_0= ruleScenario )
                    	    {
                    	    // InternalAceGen.g:2461:5: (lv_scenarios_19_0= ruleScenario )
                    	    // InternalAceGen.g:2462:6: lv_scenarios_19_0= ruleScenario
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getScenariosScenarioParserRuleCall_13_1_0());
                    	    					
                    	    pushFollow(FOLLOW_3);
                    	    lv_scenarios_19_0=ruleScenario();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"scenarios",
                    	    							lv_scenarios_19_0,
                    	    							"de.acegen.AceGen.Scenario");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop76;
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
    // InternalAceGen.g:2484:1: entryRuleHttpServerAce returns [EObject current=null] : iv_ruleHttpServerAce= ruleHttpServerAce EOF ;
    public final EObject entryRuleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAce = null;


        try {
            // InternalAceGen.g:2484:54: (iv_ruleHttpServerAce= ruleHttpServerAce EOF )
            // InternalAceGen.g:2485:2: iv_ruleHttpServerAce= ruleHttpServerAce EOF
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
    // InternalAceGen.g:2491:1: ruleHttpServerAce returns [EObject current=null] : (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) ;
    public final EObject ruleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject this_HttpServerAceWrite_0 = null;

        EObject this_HttpServerAceRead_1 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2497:2: ( (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) )
            // InternalAceGen.g:2498:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            {
            // InternalAceGen.g:2498:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            int alt78=2;
            alt78 = dfa78.predict(input);
            switch (alt78) {
                case 1 :
                    // InternalAceGen.g:2499:3: this_HttpServerAceWrite_0= ruleHttpServerAceWrite
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
                    // InternalAceGen.g:2508:3: this_HttpServerAceRead_1= ruleHttpServerAceRead
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
    // InternalAceGen.g:2520:1: entryRuleHttpServerAceWrite returns [EObject current=null] : iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF ;
    public final EObject entryRuleHttpServerAceWrite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceWrite = null;


        try {
            // InternalAceGen.g:2520:59: (iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF )
            // InternalAceGen.g:2521:2: iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF
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
    // InternalAceGen.g:2527:1: ruleHttpServerAceWrite returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? ( (lv_multipartFormData_7_0= 'multipartFormData' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* ) ;
    public final EObject ruleHttpServerAceWrite() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_url_5_0=null;
        Token lv_authorize_6_0=null;
        Token lv_multipartFormData_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_type_4_0 = null;

        EObject lv_pathParams_9_0 = null;

        EObject lv_queryParams_11_0 = null;

        EObject lv_payload_13_0 = null;

        EObject lv_outcomes_16_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2533:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? ( (lv_multipartFormData_7_0= 'multipartFormData' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* ) )
            // InternalAceGen.g:2534:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? ( (lv_multipartFormData_7_0= 'multipartFormData' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* )
            {
            // InternalAceGen.g:2534:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? ( (lv_multipartFormData_7_0= 'multipartFormData' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* )
            // InternalAceGen.g:2535:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? ( (lv_multipartFormData_7_0= 'multipartFormData' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )*
            {
            // InternalAceGen.g:2535:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:2536:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:2536:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:2537:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_75); 

            					newLeafNode(lv_name_0_0, grammarAccess.getHttpServerAceWriteAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,67,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getHttpServerAceWriteAccess().getLessThanSignKeyword_1());
            		
            // InternalAceGen.g:2557:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2558:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2558:4: ( ruleQualifiedName )
            // InternalAceGen.g:2559:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_76);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,68,FOLLOW_77); 

            			newLeafNode(otherlv_3, grammarAccess.getHttpServerAceWriteAccess().getGreaterThanSignKeyword_3());
            		
            // InternalAceGen.g:2577:3: ( (lv_type_4_0= ruleWriteFunctionType ) )
            // InternalAceGen.g:2578:4: (lv_type_4_0= ruleWriteFunctionType )
            {
            // InternalAceGen.g:2578:4: (lv_type_4_0= ruleWriteFunctionType )
            // InternalAceGen.g:2579:5: lv_type_4_0= ruleWriteFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getTypeWriteFunctionTypeParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_46);
            lv_type_4_0=ruleWriteFunctionType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHttpServerAceWriteRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_4_0,
            						"de.acegen.AceGen.WriteFunctionType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:2596:3: ( (lv_url_5_0= RULE_STRING ) )
            // InternalAceGen.g:2597:4: (lv_url_5_0= RULE_STRING )
            {
            // InternalAceGen.g:2597:4: (lv_url_5_0= RULE_STRING )
            // InternalAceGen.g:2598:5: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)match(input,RULE_STRING,FOLLOW_78); 

            					newLeafNode(lv_url_5_0, grammarAccess.getHttpServerAceWriteAccess().getUrlSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
            					}
            					setWithLastConsumed(
            						current,
            						"url",
            						lv_url_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalAceGen.g:2614:3: ( (lv_authorize_6_0= 'authorize' ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==69) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalAceGen.g:2615:4: (lv_authorize_6_0= 'authorize' )
                    {
                    // InternalAceGen.g:2615:4: (lv_authorize_6_0= 'authorize' )
                    // InternalAceGen.g:2616:5: lv_authorize_6_0= 'authorize'
                    {
                    lv_authorize_6_0=(Token)match(input,69,FOLLOW_79); 

                    					newLeafNode(lv_authorize_6_0, grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    					}
                    					setWithLastConsumed(current, "authorize", lv_authorize_6_0 != null, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2628:3: ( (lv_multipartFormData_7_0= 'multipartFormData' ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==70) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalAceGen.g:2629:4: (lv_multipartFormData_7_0= 'multipartFormData' )
                    {
                    // InternalAceGen.g:2629:4: (lv_multipartFormData_7_0= 'multipartFormData' )
                    // InternalAceGen.g:2630:5: lv_multipartFormData_7_0= 'multipartFormData'
                    {
                    lv_multipartFormData_7_0=(Token)match(input,70,FOLLOW_80); 

                    					newLeafNode(lv_multipartFormData_7_0, grammarAccess.getHttpServerAceWriteAccess().getMultipartFormDataMultipartFormDataKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    					}
                    					setWithLastConsumed(current, "multipartFormData", lv_multipartFormData_7_0 != null, "multipartFormData");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2642:3: (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==71) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalAceGen.g:2643:4: otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_8=(Token)match(input,71,FOLLOW_81); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:2647:4: ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==RULE_ID) ) {
                            int LA81_2 = input.LA(2);

                            if ( (LA81_2==EOF||LA81_2==RULE_ID||LA81_2==16||LA81_2==25||(LA81_2>=65 && LA81_2<=66)||(LA81_2>=72 && LA81_2<=75)||LA81_2==93) ) {
                                alt81=1;
                            }


                        }
                        else if ( (LA81_0==75) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // InternalAceGen.g:2648:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2648:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2649:6: lv_pathParams_9_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeParamRefParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_81);
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
                    	    break loop81;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2667:3: (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==72) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalAceGen.g:2668:4: otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_10=(Token)match(input,72,FOLLOW_82); 

                    				newLeafNode(otherlv_10, grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_9_0());
                    			
                    // InternalAceGen.g:2672:4: ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==RULE_ID) ) {
                            int LA83_2 = input.LA(2);

                            if ( (LA83_2==EOF||LA83_2==RULE_ID||LA83_2==16||LA83_2==25||(LA83_2>=65 && LA83_2<=66)||(LA83_2>=73 && LA83_2<=75)||LA83_2==93) ) {
                                alt83=1;
                            }


                        }
                        else if ( (LA83_0==75) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // InternalAceGen.g:2673:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2673:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2674:6: lv_queryParams_11_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeParamRefParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_82);
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
                    	    break loop83;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2692:3: (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==73) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalAceGen.g:2693:4: otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_12=(Token)match(input,73,FOLLOW_83); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_10_0());
                    			
                    // InternalAceGen.g:2697:4: ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==RULE_ID) ) {
                            int LA85_2 = input.LA(2);

                            if ( (LA85_2==EOF||LA85_2==RULE_ID||LA85_2==16||LA85_2==25||(LA85_2>=65 && LA85_2<=66)||(LA85_2>=74 && LA85_2<=75)||LA85_2==93) ) {
                                alt85=1;
                            }


                        }
                        else if ( (LA85_0==75) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // InternalAceGen.g:2698:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2698:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2699:6: lv_payload_13_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeParamRefParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_83);
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
                    	    break loop85;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2717:3: (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==74) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalAceGen.g:2718:4: otherlv_14= 'response' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_14=(Token)match(input,74,FOLLOW_84); 

                    				newLeafNode(otherlv_14, grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_11_0());
                    			
                    // InternalAceGen.g:2722:4: ( ( ruleQualifiedName ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==RULE_ID) ) {
                            int LA87_2 = input.LA(2);

                            if ( (LA87_2==EOF||LA87_2==RULE_ID||LA87_2==16||LA87_2==25||(LA87_2>=65 && LA87_2<=66)||LA87_2==93) ) {
                                alt87=1;
                            }


                        }


                        switch (alt87) {
                    	case 1 :
                    	    // InternalAceGen.g:2723:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:2723:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:2724:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeCrossReference_11_1_0());
                    	    					
                    	    pushFollow(FOLLOW_84);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop87;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2739:3: ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==25) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalAceGen.g:2740:4: (lv_outcomes_16_0= ruleHttpServerOutcome )
            	    {
            	    // InternalAceGen.g:2740:4: (lv_outcomes_16_0= ruleHttpServerOutcome )
            	    // InternalAceGen.g:2741:5: lv_outcomes_16_0= ruleHttpServerOutcome
            	    {

            	    					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getOutcomesHttpServerOutcomeParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_16);
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
            	    break loop89;
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
    // InternalAceGen.g:2762:1: entryRuleHttpServerOutcome returns [EObject current=null] : iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF ;
    public final EObject entryRuleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerOutcome = null;


        try {
            // InternalAceGen.g:2762:58: (iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF )
            // InternalAceGen.g:2763:2: iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF
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
    // InternalAceGen.g:2769:1: ruleHttpServerOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* ) ;
    public final EObject ruleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAceGen.g:2775:2: ( (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* ) )
            // InternalAceGen.g:2776:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* )
            {
            // InternalAceGen.g:2776:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* )
            // InternalAceGen.g:2777:3: otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )*
            {
            otherlv_0=(Token)match(input,25,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpServerOutcomeAccess().getOnKeyword_0());
            		
            // InternalAceGen.g:2781:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:2782:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:2782:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:2783:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_57); 

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

            // InternalAceGen.g:2799:3: (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==18) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalAceGen.g:2800:4: otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')'
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_42); 

            	    				newLeafNode(otherlv_2, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0());
            	    			
            	    // InternalAceGen.g:2804:4: ( ( ruleQualifiedName ) )*
            	    loop90:
            	    do {
            	        int alt90=2;
            	        int LA90_0 = input.LA(1);

            	        if ( (LA90_0==RULE_ID) ) {
            	            alt90=1;
            	        }


            	        switch (alt90) {
            	    	case 1 :
            	    	    // InternalAceGen.g:2805:5: ( ruleQualifiedName )
            	    	    {
            	    	    // InternalAceGen.g:2805:5: ( ruleQualifiedName )
            	    	    // InternalAceGen.g:2806:6: ruleQualifiedName
            	    	    {

            	    	    						if (current==null) {
            	    	    							current = createModelElement(grammarAccess.getHttpServerOutcomeRule());
            	    	    						}
            	    	    					

            	    	    						newCompositeNode(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0());
            	    	    					
            	    	    pushFollow(FOLLOW_42);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;


            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop90;
            	        }
            	    } while (true);

            	    otherlv_4=(Token)match(input,20,FOLLOW_57); 

            	    				newLeafNode(otherlv_4, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop91;
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
    // InternalAceGen.g:2829:1: entryRuleHttpServerAceRead returns [EObject current=null] : iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF ;
    public final EObject entryRuleHttpServerAceRead() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceRead = null;


        try {
            // InternalAceGen.g:2829:58: (iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF )
            // InternalAceGen.g:2830:2: iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF
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
    // InternalAceGen.g:2836:1: ruleHttpServerAceRead returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? ) ;
    public final EObject ruleHttpServerAceRead() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_url_5_0=null;
        Token lv_authorize_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_type_4_0 = null;

        EObject lv_pathParams_8_0 = null;

        EObject lv_queryParams_10_0 = null;

        EObject lv_payload_12_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2842:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? ) )
            // InternalAceGen.g:2843:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? )
            {
            // InternalAceGen.g:2843:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? )
            // InternalAceGen.g:2844:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )?
            {
            // InternalAceGen.g:2844:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:2845:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:2845:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:2846:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_75); 

            					newLeafNode(lv_name_0_0, grammarAccess.getHttpServerAceReadAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,67,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getHttpServerAceReadAccess().getLessThanSignKeyword_1());
            		
            // InternalAceGen.g:2866:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2867:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2867:4: ( ruleQualifiedName )
            // InternalAceGen.g:2868:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_76);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,68,FOLLOW_85); 

            			newLeafNode(otherlv_3, grammarAccess.getHttpServerAceReadAccess().getGreaterThanSignKeyword_3());
            		
            // InternalAceGen.g:2886:3: ( (lv_type_4_0= ruleReadFunctionType ) )
            // InternalAceGen.g:2887:4: (lv_type_4_0= ruleReadFunctionType )
            {
            // InternalAceGen.g:2887:4: (lv_type_4_0= ruleReadFunctionType )
            // InternalAceGen.g:2888:5: lv_type_4_0= ruleReadFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getTypeReadFunctionTypeParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_46);
            lv_type_4_0=ruleReadFunctionType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHttpServerAceReadRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_4_0,
            						"de.acegen.AceGen.ReadFunctionType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:2905:3: ( (lv_url_5_0= RULE_STRING ) )
            // InternalAceGen.g:2906:4: (lv_url_5_0= RULE_STRING )
            {
            // InternalAceGen.g:2906:4: (lv_url_5_0= RULE_STRING )
            // InternalAceGen.g:2907:5: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)match(input,RULE_STRING,FOLLOW_86); 

            					newLeafNode(lv_url_5_0, grammarAccess.getHttpServerAceReadAccess().getUrlSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
            					}
            					setWithLastConsumed(
            						current,
            						"url",
            						lv_url_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalAceGen.g:2923:3: ( (lv_authorize_6_0= 'authorize' ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==69) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalAceGen.g:2924:4: (lv_authorize_6_0= 'authorize' )
                    {
                    // InternalAceGen.g:2924:4: (lv_authorize_6_0= 'authorize' )
                    // InternalAceGen.g:2925:5: lv_authorize_6_0= 'authorize'
                    {
                    lv_authorize_6_0=(Token)match(input,69,FOLLOW_87); 

                    					newLeafNode(lv_authorize_6_0, grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    					}
                    					setWithLastConsumed(current, "authorize", lv_authorize_6_0 != null, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2937:3: (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==71) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalAceGen.g:2938:4: otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_7=(Token)match(input,71,FOLLOW_88); 

                    				newLeafNode(otherlv_7, grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_7_0());
                    			
                    // InternalAceGen.g:2942:4: ( (lv_pathParams_8_0= ruleAttributeParamRef ) )*
                    loop93:
                    do {
                        int alt93=2;
                        int LA93_0 = input.LA(1);

                        if ( (LA93_0==RULE_ID) ) {
                            int LA93_2 = input.LA(2);

                            if ( (LA93_2==EOF||LA93_2==RULE_ID||LA93_2==16||(LA93_2>=65 && LA93_2<=66)||(LA93_2>=72 && LA93_2<=75)||LA93_2==93) ) {
                                alt93=1;
                            }


                        }
                        else if ( (LA93_0==75) ) {
                            alt93=1;
                        }


                        switch (alt93) {
                    	case 1 :
                    	    // InternalAceGen.g:2943:5: (lv_pathParams_8_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2943:5: (lv_pathParams_8_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2944:6: lv_pathParams_8_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeParamRefParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_88);
                    	    lv_pathParams_8_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceReadRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"pathParams",
                    	    							lv_pathParams_8_0,
                    	    							"de.acegen.AceGen.AttributeParamRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop93;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2962:3: (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==72) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalAceGen.g:2963:4: otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_9=(Token)match(input,72,FOLLOW_89); 

                    				newLeafNode(otherlv_9, grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:2967:4: ( (lv_queryParams_10_0= ruleAttributeParamRef ) )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==RULE_ID) ) {
                            int LA95_2 = input.LA(2);

                            if ( (LA95_2==EOF||LA95_2==RULE_ID||LA95_2==16||(LA95_2>=65 && LA95_2<=66)||(LA95_2>=73 && LA95_2<=75)||LA95_2==93) ) {
                                alt95=1;
                            }


                        }
                        else if ( (LA95_0==75) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // InternalAceGen.g:2968:5: (lv_queryParams_10_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2968:5: (lv_queryParams_10_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2969:6: lv_queryParams_10_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeParamRefParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_89);
                    	    lv_queryParams_10_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceReadRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"queryParams",
                    	    							lv_queryParams_10_0,
                    	    							"de.acegen.AceGen.AttributeParamRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop95;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2987:3: (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==73) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalAceGen.g:2988:4: otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_11=(Token)match(input,73,FOLLOW_90); 

                    				newLeafNode(otherlv_11, grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_9_0());
                    			
                    // InternalAceGen.g:2992:4: ( (lv_payload_12_0= ruleAttributeParamRef ) )*
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( (LA97_0==RULE_ID) ) {
                            int LA97_2 = input.LA(2);

                            if ( (LA97_2==EOF||LA97_2==RULE_ID||LA97_2==16||(LA97_2>=65 && LA97_2<=66)||(LA97_2>=74 && LA97_2<=75)||LA97_2==93) ) {
                                alt97=1;
                            }


                        }
                        else if ( (LA97_0==75) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // InternalAceGen.g:2993:5: (lv_payload_12_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2993:5: (lv_payload_12_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2994:6: lv_payload_12_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeParamRefParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_90);
                    	    lv_payload_12_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceReadRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"payload",
                    	    							lv_payload_12_0,
                    	    							"de.acegen.AceGen.AttributeParamRef");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop97;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:3012:3: (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==74) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalAceGen.g:3013:4: otherlv_13= 'response' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_13=(Token)match(input,74,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_10_0());
                    			
                    // InternalAceGen.g:3017:4: ( ( ruleQualifiedName ) )*
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==RULE_ID) ) {
                            int LA99_2 = input.LA(2);

                            if ( (LA99_2==EOF||LA99_2==RULE_ID||LA99_2==16||(LA99_2>=65 && LA99_2<=66)||LA99_2==93) ) {
                                alt99=1;
                            }


                        }


                        switch (alt99) {
                    	case 1 :
                    	    // InternalAceGen.g:3018:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:3018:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:3019:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getResponseAttributeCrossReference_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_3);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop99;
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
    // InternalAceGen.g:3038:1: entryRuleAttributeParamRef returns [EObject current=null] : iv_ruleAttributeParamRef= ruleAttributeParamRef EOF ;
    public final EObject entryRuleAttributeParamRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeParamRef = null;


        try {
            // InternalAceGen.g:3038:58: (iv_ruleAttributeParamRef= ruleAttributeParamRef EOF )
            // InternalAceGen.g:3039:2: iv_ruleAttributeParamRef= ruleAttributeParamRef EOF
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
    // InternalAceGen.g:3045:1: ruleAttributeParamRef returns [EObject current=null] : ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleAttributeParamRef() throws RecognitionException {
        EObject current = null;

        Token lv_notNull_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:3051:2: ( ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:3052:2: ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:3052:2: ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:3053:3: ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:3053:3: ( (lv_notNull_0_0= 'NotNull' ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==75) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalAceGen.g:3054:4: (lv_notNull_0_0= 'NotNull' )
                    {
                    // InternalAceGen.g:3054:4: (lv_notNull_0_0= 'NotNull' )
                    // InternalAceGen.g:3055:5: lv_notNull_0_0= 'NotNull'
                    {
                    lv_notNull_0_0=(Token)match(input,75,FOLLOW_9); 

                    					newLeafNode(lv_notNull_0_0, grammarAccess.getAttributeParamRefAccess().getNotNullNotNullKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeParamRefRule());
                    					}
                    					setWithLastConsumed(current, "notNull", lv_notNull_0_0 != null, "NotNull");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:3067:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3068:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3068:4: ( ruleQualifiedName )
            // InternalAceGen.g:3069:5: ruleQualifiedName
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
    // InternalAceGen.g:3087:1: entryRuleHttpServerView returns [EObject current=null] : iv_ruleHttpServerView= ruleHttpServerView EOF ;
    public final EObject entryRuleHttpServerView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerView = null;


        try {
            // InternalAceGen.g:3087:55: (iv_ruleHttpServerView= ruleHttpServerView EOF )
            // InternalAceGen.g:3088:2: iv_ruleHttpServerView= ruleHttpServerView EOF
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
    // InternalAceGen.g:3094:1: ruleHttpServerView returns [EObject current=null] : ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? ) ;
    public final EObject ruleHttpServerView() throws RecognitionException {
        EObject current = null;

        Token lv_afterCommit_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_renderFunctions_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3100:2: ( ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? ) )
            // InternalAceGen.g:3101:2: ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? )
            {
            // InternalAceGen.g:3101:2: ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? )
            // InternalAceGen.g:3102:3: ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )?
            {
            // InternalAceGen.g:3102:3: ( (lv_afterCommit_0_0= 'afterCommit' ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==76) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalAceGen.g:3103:4: (lv_afterCommit_0_0= 'afterCommit' )
                    {
                    // InternalAceGen.g:3103:4: (lv_afterCommit_0_0= 'afterCommit' )
                    // InternalAceGen.g:3104:5: lv_afterCommit_0_0= 'afterCommit'
                    {
                    lv_afterCommit_0_0=(Token)match(input,76,FOLLOW_9); 

                    					newLeafNode(lv_afterCommit_0_0, grammarAccess.getHttpServerViewAccess().getAfterCommitAfterCommitKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerViewRule());
                    					}
                    					setWithLastConsumed(current, "afterCommit", lv_afterCommit_0_0 != null, "afterCommit");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:3116:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:3117:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:3117:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:3118:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_1_0, grammarAccess.getHttpServerViewAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerViewRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:3134:3: (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==35) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalAceGen.g:3135:4: otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_91); 

                    				newLeafNode(otherlv_2, grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalAceGen.g:3139:4: ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )*
                    loop103:
                    do {
                        int alt103=2;
                        int LA103_0 = input.LA(1);

                        if ( (LA103_0==RULE_ID) ) {
                            alt103=1;
                        }


                        switch (alt103) {
                    	case 1 :
                    	    // InternalAceGen.g:3140:5: (lv_renderFunctions_3_0= ruleHttpServerViewFunction )
                    	    {
                    	    // InternalAceGen.g:3140:5: (lv_renderFunctions_3_0= ruleHttpServerViewFunction )
                    	    // InternalAceGen.g:3141:6: lv_renderFunctions_3_0= ruleHttpServerViewFunction
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerViewAccess().getRenderFunctionsHttpServerViewFunctionParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_91);
                    	    lv_renderFunctions_3_0=ruleHttpServerViewFunction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerViewRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"renderFunctions",
                    	    							lv_renderFunctions_3_0,
                    	    							"de.acegen.AceGen.HttpServerViewFunction");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop103;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,37,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getHttpServerViewAccess().getRightCurlyBracketKeyword_2_2());
                    			

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
    // InternalAceGen.g:3167:1: entryRuleHttpServerViewFunction returns [EObject current=null] : iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF ;
    public final EObject entryRuleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerViewFunction = null;


        try {
            // InternalAceGen.g:3167:63: (iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF )
            // InternalAceGen.g:3168:2: iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF
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
    // InternalAceGen.g:3174:1: ruleHttpServerViewFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) ;
    public final EObject ruleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalAceGen.g:3180:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) )
            // InternalAceGen.g:3181:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            {
            // InternalAceGen.g:3181:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            // InternalAceGen.g:3182:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')'
            {
            // InternalAceGen.g:3182:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3183:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3183:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3184:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            otherlv_1=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getHttpServerViewFunctionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:3204:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3205:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3205:4: ( ruleQualifiedName )
            // InternalAceGen.g:3206:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerViewFunctionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_58);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_2); 

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
    // InternalAceGen.g:3228:1: entryRuleAuthUser returns [EObject current=null] : iv_ruleAuthUser= ruleAuthUser EOF ;
    public final EObject entryRuleAuthUser() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthUser = null;


        try {
            // InternalAceGen.g:3228:49: (iv_ruleAuthUser= ruleAuthUser EOF )
            // InternalAceGen.g:3229:2: iv_ruleAuthUser= ruleAuthUser EOF
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
    // InternalAceGen.g:3235:1: ruleAuthUser returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) ;
    public final EObject ruleAuthUser() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3241:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) )
            // InternalAceGen.g:3242:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            {
            // InternalAceGen.g:3242:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            // InternalAceGen.g:3243:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            {
            // InternalAceGen.g:3243:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3244:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3244:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3245:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_29); 

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

            // InternalAceGen.g:3261:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            // InternalAceGen.g:3262:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}'
            {
            otherlv_1=(Token)match(input,35,FOLLOW_92); 

            				newLeafNode(otherlv_1, grammarAccess.getAuthUserAccess().getLeftCurlyBracketKeyword_1_0());
            			
            // InternalAceGen.g:3266:4: ( (lv_attributes_2_0= ruleAttribute ) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==RULE_ID||LA105_0==32||LA105_0==75||(LA105_0>=90 && LA105_0<=91)||(LA105_0>=98 && LA105_0<=104)) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // InternalAceGen.g:3267:5: (lv_attributes_2_0= ruleAttribute )
            	    {
            	    // InternalAceGen.g:3267:5: (lv_attributes_2_0= ruleAttribute )
            	    // InternalAceGen.g:3268:6: lv_attributes_2_0= ruleAttribute
            	    {

            	    						newCompositeNode(grammarAccess.getAuthUserAccess().getAttributesAttributeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_92);
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
            	    break loop105;
                }
            } while (true);

            otherlv_3=(Token)match(input,37,FOLLOW_2); 

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
    // InternalAceGen.g:3294:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAceGen.g:3294:46: (iv_ruleModel= ruleModel EOF )
            // InternalAceGen.g:3295:2: iv_ruleModel= ruleModel EOF
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
    // InternalAceGen.g:3301:1: ruleModel returns [EObject current=null] : ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) ;
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
            // InternalAceGen.g:3307:2: ( ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) )
            // InternalAceGen.g:3308:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            {
            // InternalAceGen.g:3308:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            // InternalAceGen.g:3309:3: ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            {
            // InternalAceGen.g:3309:3: ( (lv_persistent_0_0= 'persistent' ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==77) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalAceGen.g:3310:4: (lv_persistent_0_0= 'persistent' )
                    {
                    // InternalAceGen.g:3310:4: (lv_persistent_0_0= 'persistent' )
                    // InternalAceGen.g:3311:5: lv_persistent_0_0= 'persistent'
                    {
                    lv_persistent_0_0=(Token)match(input,77,FOLLOW_9); 

                    					newLeafNode(lv_persistent_0_0, grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(current, "persistent", lv_persistent_0_0 != null, "persistent");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:3323:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:3324:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:3324:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:3325:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_93); 

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

            // InternalAceGen.g:3341:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==78) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalAceGen.g:3342:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_2=(Token)match(input,78,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getExtendsKeyword_2_0());
                    			
                    // InternalAceGen.g:3346:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:3347:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:3347:5: ( ruleQualifiedName )
                    // InternalAceGen.g:3348:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_94);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:3362:4: (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    loop107:
                    do {
                        int alt107=2;
                        int LA107_0 = input.LA(1);

                        if ( (LA107_0==19) ) {
                            alt107=1;
                        }


                        switch (alt107) {
                    	case 1 :
                    	    // InternalAceGen.g:3363:5: otherlv_4= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_9); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getModelAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:3367:5: ( ( ruleQualifiedName ) )
                    	    // InternalAceGen.g:3368:6: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:3368:6: ( ruleQualifiedName )
                    	    // InternalAceGen.g:3369:7: ruleQualifiedName
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModelRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_94);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


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

            // InternalAceGen.g:3385:3: (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==35) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalAceGen.g:3386:4: otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,35,FOLLOW_92); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalAceGen.g:3390:4: ( (lv_attributes_7_0= ruleAttribute ) )*
                    loop109:
                    do {
                        int alt109=2;
                        int LA109_0 = input.LA(1);

                        if ( (LA109_0==RULE_ID||LA109_0==32||LA109_0==75||(LA109_0>=90 && LA109_0<=91)||(LA109_0>=98 && LA109_0<=104)) ) {
                            alt109=1;
                        }


                        switch (alt109) {
                    	case 1 :
                    	    // InternalAceGen.g:3391:5: (lv_attributes_7_0= ruleAttribute )
                    	    {
                    	    // InternalAceGen.g:3391:5: (lv_attributes_7_0= ruleAttribute )
                    	    // InternalAceGen.g:3392:6: lv_attributes_7_0= ruleAttribute
                    	    {

                    	    						newCompositeNode(grammarAccess.getModelAccess().getAttributesAttributeParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_92);
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
                    	    break loop109;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,37,FOLLOW_2); 

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
    // InternalAceGen.g:3418:1: entryRuleScenario returns [EObject current=null] : iv_ruleScenario= ruleScenario EOF ;
    public final EObject entryRuleScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario = null;


        try {
            // InternalAceGen.g:3418:49: (iv_ruleScenario= ruleScenario EOF )
            // InternalAceGen.g:3419:2: iv_ruleScenario= ruleScenario EOF
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
    // InternalAceGen.g:3425:1: ruleScenario returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? ( (lv_whenThen_3_0= ruleWhenThen ) ) (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )* ) ;
    public final EObject ruleScenario() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_givenItems_2_0 = null;

        EObject lv_whenThen_3_0 = null;

        EObject lv_whenThen_5_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3431:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? ( (lv_whenThen_3_0= ruleWhenThen ) ) (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )* ) )
            // InternalAceGen.g:3432:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? ( (lv_whenThen_3_0= ruleWhenThen ) ) (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )* )
            {
            // InternalAceGen.g:3432:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? ( (lv_whenThen_3_0= ruleWhenThen ) ) (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )* )
            // InternalAceGen.g:3433:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? ( (lv_whenThen_3_0= ruleWhenThen ) ) (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )*
            {
            // InternalAceGen.g:3433:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3434:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3434:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3435:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_32); 

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

            // InternalAceGen.g:3451:3: (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==38) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalAceGen.g:3452:4: otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )*
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_33); 

                    				newLeafNode(otherlv_1, grammarAccess.getScenarioAccess().getGIVENKeyword_1_0());
                    			
                    // InternalAceGen.g:3456:4: ( (lv_givenItems_2_0= ruleGiven ) )*
                    loop111:
                    do {
                        int alt111=2;
                        int LA111_0 = input.LA(1);

                        if ( (LA111_0==RULE_ID) ) {
                            alt111=1;
                        }


                        switch (alt111) {
                    	case 1 :
                    	    // InternalAceGen.g:3457:5: (lv_givenItems_2_0= ruleGiven )
                    	    {
                    	    // InternalAceGen.g:3457:5: (lv_givenItems_2_0= ruleGiven )
                    	    // InternalAceGen.g:3458:6: lv_givenItems_2_0= ruleGiven
                    	    {

                    	    						newCompositeNode(grammarAccess.getScenarioAccess().getGivenItemsGivenParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_33);
                    	    lv_givenItems_2_0=ruleGiven();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getScenarioRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"givenItems",
                    	    							lv_givenItems_2_0,
                    	    							"de.acegen.AceGen.Given");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop111;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:3476:3: ( (lv_whenThen_3_0= ruleWhenThen ) )
            // InternalAceGen.g:3477:4: (lv_whenThen_3_0= ruleWhenThen )
            {
            // InternalAceGen.g:3477:4: (lv_whenThen_3_0= ruleWhenThen )
            // InternalAceGen.g:3478:5: lv_whenThen_3_0= ruleWhenThen
            {

            					newCompositeNode(grammarAccess.getScenarioAccess().getWhenThenWhenThenParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_34);
            lv_whenThen_3_0=ruleWhenThen();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioRule());
            					}
            					add(
            						current,
            						"whenThen",
            						lv_whenThen_3_0,
            						"de.acegen.AceGen.WhenThen");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3495:3: (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==39) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalAceGen.g:3496:4: otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) )
            	    {
            	    otherlv_4=(Token)match(input,39,FOLLOW_32); 

            	    				newLeafNode(otherlv_4, grammarAccess.getScenarioAccess().getANDKeyword_3_0());
            	    			
            	    // InternalAceGen.g:3500:4: ( (lv_whenThen_5_0= ruleWhenThen ) )
            	    // InternalAceGen.g:3501:5: (lv_whenThen_5_0= ruleWhenThen )
            	    {
            	    // InternalAceGen.g:3501:5: (lv_whenThen_5_0= ruleWhenThen )
            	    // InternalAceGen.g:3502:6: lv_whenThen_5_0= ruleWhenThen
            	    {

            	    						newCompositeNode(grammarAccess.getScenarioAccess().getWhenThenWhenThenParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_34);
            	    lv_whenThen_5_0=ruleWhenThen();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getScenarioRule());
            	    						}
            	    						add(
            	    							current,
            	    							"whenThen",
            	    							lv_whenThen_5_0,
            	    							"de.acegen.AceGen.WhenThen");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop113;
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
    // $ANTLR end "ruleScenario"


    // $ANTLR start "entryRuleWhenThen"
    // InternalAceGen.g:3524:1: entryRuleWhenThen returns [EObject current=null] : iv_ruleWhenThen= ruleWhenThen EOF ;
    public final EObject entryRuleWhenThen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhenThen = null;


        try {
            // InternalAceGen.g:3524:49: (iv_ruleWhenThen= ruleWhenThen EOF )
            // InternalAceGen.g:3525:2: iv_ruleWhenThen= ruleWhenThen EOF
            {
             newCompositeNode(grammarAccess.getWhenThenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWhenThen=ruleWhenThen();

            state._fsp--;

             current =iv_ruleWhenThen; 
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
    // $ANTLR end "entryRuleWhenThen"


    // $ANTLR start "ruleWhenThen"
    // InternalAceGen.g:3531:1: ruleWhenThen returns [EObject current=null] : (otherlv_0= 'WHEN' ( (lv_whenBlock_1_0= ruleWhenBlock ) ) otherlv_2= 'THEN' ( (lv_thenBlock_3_0= ruleThenBlock ) ) ) ;
    public final EObject ruleWhenThen() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_whenBlock_1_0 = null;

        EObject lv_thenBlock_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3537:2: ( (otherlv_0= 'WHEN' ( (lv_whenBlock_1_0= ruleWhenBlock ) ) otherlv_2= 'THEN' ( (lv_thenBlock_3_0= ruleThenBlock ) ) ) )
            // InternalAceGen.g:3538:2: (otherlv_0= 'WHEN' ( (lv_whenBlock_1_0= ruleWhenBlock ) ) otherlv_2= 'THEN' ( (lv_thenBlock_3_0= ruleThenBlock ) ) )
            {
            // InternalAceGen.g:3538:2: (otherlv_0= 'WHEN' ( (lv_whenBlock_1_0= ruleWhenBlock ) ) otherlv_2= 'THEN' ( (lv_thenBlock_3_0= ruleThenBlock ) ) )
            // InternalAceGen.g:3539:3: otherlv_0= 'WHEN' ( (lv_whenBlock_1_0= ruleWhenBlock ) ) otherlv_2= 'THEN' ( (lv_thenBlock_3_0= ruleThenBlock ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getWhenThenAccess().getWHENKeyword_0());
            		
            // InternalAceGen.g:3543:3: ( (lv_whenBlock_1_0= ruleWhenBlock ) )
            // InternalAceGen.g:3544:4: (lv_whenBlock_1_0= ruleWhenBlock )
            {
            // InternalAceGen.g:3544:4: (lv_whenBlock_1_0= ruleWhenBlock )
            // InternalAceGen.g:3545:5: lv_whenBlock_1_0= ruleWhenBlock
            {

            					newCompositeNode(grammarAccess.getWhenThenAccess().getWhenBlockWhenBlockParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_95);
            lv_whenBlock_1_0=ruleWhenBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhenThenRule());
            					}
            					set(
            						current,
            						"whenBlock",
            						lv_whenBlock_1_0,
            						"de.acegen.AceGen.WhenBlock");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,41,FOLLOW_22); 

            			newLeafNode(otherlv_2, grammarAccess.getWhenThenAccess().getTHENKeyword_2());
            		
            // InternalAceGen.g:3566:3: ( (lv_thenBlock_3_0= ruleThenBlock ) )
            // InternalAceGen.g:3567:4: (lv_thenBlock_3_0= ruleThenBlock )
            {
            // InternalAceGen.g:3567:4: (lv_thenBlock_3_0= ruleThenBlock )
            // InternalAceGen.g:3568:5: lv_thenBlock_3_0= ruleThenBlock
            {

            					newCompositeNode(grammarAccess.getWhenThenAccess().getThenBlockThenBlockParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_thenBlock_3_0=ruleThenBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWhenThenRule());
            					}
            					set(
            						current,
            						"thenBlock",
            						lv_thenBlock_3_0,
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
    // $ANTLR end "ruleWhenThen"


    // $ANTLR start "entryRuleGiven"
    // InternalAceGen.g:3589:1: entryRuleGiven returns [EObject current=null] : iv_ruleGiven= ruleGiven EOF ;
    public final EObject entryRuleGiven() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGiven = null;


        try {
            // InternalAceGen.g:3589:46: (iv_ruleGiven= ruleGiven EOF )
            // InternalAceGen.g:3590:2: iv_ruleGiven= ruleGiven EOF
            {
             newCompositeNode(grammarAccess.getGivenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGiven=ruleGiven();

            state._fsp--;

             current =iv_ruleGiven; 
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
    // $ANTLR end "entryRuleGiven"


    // $ANTLR start "ruleGiven"
    // InternalAceGen.g:3596:1: ruleGiven returns [EObject current=null] : (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall ) ;
    public final EObject ruleGiven() throws RecognitionException {
        EObject current = null;

        EObject this_GivenRef_0 = null;

        EObject this_CustomCall_1 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3602:2: ( (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall ) )
            // InternalAceGen.g:3603:2: (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall )
            {
            // InternalAceGen.g:3603:2: (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==RULE_ID) ) {
                int LA114_1 = input.LA(2);

                if ( (LA114_1==EOF||(LA114_1>=RULE_ID && LA114_1<=RULE_INT)||LA114_1==40||LA114_1==42||LA114_1==93) ) {
                    alt114=1;
                }
                else if ( (LA114_1==18) ) {
                    alt114=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 114, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }
            switch (alt114) {
                case 1 :
                    // InternalAceGen.g:3604:3: this_GivenRef_0= ruleGivenRef
                    {

                    			newCompositeNode(grammarAccess.getGivenAccess().getGivenRefParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_GivenRef_0=ruleGivenRef();

                    state._fsp--;


                    			current = this_GivenRef_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:3613:3: this_CustomCall_1= ruleCustomCall
                    {

                    			newCompositeNode(grammarAccess.getGivenAccess().getCustomCallParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CustomCall_1=ruleCustomCall();

                    state._fsp--;


                    			current = this_CustomCall_1;
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
    // $ANTLR end "ruleGiven"


    // $ANTLR start "entryRuleCustomCall"
    // InternalAceGen.g:3625:1: entryRuleCustomCall returns [EObject current=null] : iv_ruleCustomCall= ruleCustomCall EOF ;
    public final EObject entryRuleCustomCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomCall = null;


        try {
            // InternalAceGen.g:3625:51: (iv_ruleCustomCall= ruleCustomCall EOF )
            // InternalAceGen.g:3626:2: iv_ruleCustomCall= ruleCustomCall EOF
            {
             newCompositeNode(grammarAccess.getCustomCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCustomCall=ruleCustomCall();

            state._fsp--;

             current =iv_ruleCustomCall; 
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
    // $ANTLR end "entryRuleCustomCall"


    // $ANTLR start "ruleCustomCall"
    // InternalAceGen.g:3632:1: ruleCustomCall returns [EObject current=null] : ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? ) ;
    public final EObject ruleCustomCall() throws RecognitionException {
        EObject current = null;

        Token lv_customCallName_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_times_6_0=null;
        Token otherlv_7=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3638:2: ( ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? ) )
            // InternalAceGen.g:3639:2: ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? )
            {
            // InternalAceGen.g:3639:2: ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? )
            // InternalAceGen.g:3640:3: ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )?
            {
            // InternalAceGen.g:3640:3: ( (lv_customCallName_0_0= RULE_ID ) )
            // InternalAceGen.g:3641:4: (lv_customCallName_0_0= RULE_ID )
            {
            // InternalAceGen.g:3641:4: (lv_customCallName_0_0= RULE_ID )
            // InternalAceGen.g:3642:5: lv_customCallName_0_0= RULE_ID
            {
            lv_customCallName_0_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					newLeafNode(lv_customCallName_0_0, grammarAccess.getCustomCallAccess().getCustomCallNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCustomCallRule());
            					}
            					setWithLastConsumed(
            						current,
            						"customCallName",
            						lv_customCallName_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_96); 

            			newLeafNode(otherlv_1, grammarAccess.getCustomCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:3662:3: ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( ((LA116_0>=RULE_INT && LA116_0<=RULE_STRING)) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalAceGen.g:3663:4: ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )*
                    {
                    // InternalAceGen.g:3663:4: ( (lv_values_2_0= rulePrimitiveValue ) )
                    // InternalAceGen.g:3664:5: (lv_values_2_0= rulePrimitiveValue )
                    {
                    // InternalAceGen.g:3664:5: (lv_values_2_0= rulePrimitiveValue )
                    // InternalAceGen.g:3665:6: lv_values_2_0= rulePrimitiveValue
                    {

                    						newCompositeNode(grammarAccess.getCustomCallAccess().getValuesPrimitiveValueParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_values_2_0=rulePrimitiveValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCustomCallRule());
                    						}
                    						add(
                    							current,
                    							"values",
                    							lv_values_2_0,
                    							"de.acegen.AceGen.PrimitiveValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:3682:4: (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==19) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalAceGen.g:3683:5: otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_51); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getCustomCallAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalAceGen.g:3687:5: ( (lv_values_4_0= rulePrimitiveValue ) )
                    	    // InternalAceGen.g:3688:6: (lv_values_4_0= rulePrimitiveValue )
                    	    {
                    	    // InternalAceGen.g:3688:6: (lv_values_4_0= rulePrimitiveValue )
                    	    // InternalAceGen.g:3689:7: lv_values_4_0= rulePrimitiveValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getCustomCallAccess().getValuesPrimitiveValueParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_values_4_0=rulePrimitiveValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCustomCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"values",
                    	    								lv_values_4_0,
                    	    								"de.acegen.AceGen.PrimitiveValue");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop115;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_97); 

            			newLeafNode(otherlv_5, grammarAccess.getCustomCallAccess().getRightParenthesisKeyword_3());
            		
            // InternalAceGen.g:3712:3: ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==RULE_INT) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalAceGen.g:3713:4: ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x'
                    {
                    // InternalAceGen.g:3713:4: ( (lv_times_6_0= RULE_INT ) )
                    // InternalAceGen.g:3714:5: (lv_times_6_0= RULE_INT )
                    {
                    // InternalAceGen.g:3714:5: (lv_times_6_0= RULE_INT )
                    // InternalAceGen.g:3715:6: lv_times_6_0= RULE_INT
                    {
                    lv_times_6_0=(Token)match(input,RULE_INT,FOLLOW_98); 

                    						newLeafNode(lv_times_6_0, grammarAccess.getCustomCallAccess().getTimesINTTerminalRuleCall_4_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCustomCallRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"times",
                    							lv_times_6_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,79,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getCustomCallAccess().getXKeyword_4_1());
                    			

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
    // $ANTLR end "ruleCustomCall"


    // $ANTLR start "entryRuleGivenRef"
    // InternalAceGen.g:3740:1: entryRuleGivenRef returns [EObject current=null] : iv_ruleGivenRef= ruleGivenRef EOF ;
    public final EObject entryRuleGivenRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGivenRef = null;


        try {
            // InternalAceGen.g:3740:49: (iv_ruleGivenRef= ruleGivenRef EOF )
            // InternalAceGen.g:3741:2: iv_ruleGivenRef= ruleGivenRef EOF
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
    // InternalAceGen.g:3747:1: ruleGivenRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )? ) ;
    public final EObject ruleGivenRef() throws RecognitionException {
        EObject current = null;

        Token lv_times_1_0=null;
        Token otherlv_2=null;
        Token lv_excludeGiven_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAceGen.g:3753:2: ( ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )? ) )
            // InternalAceGen.g:3754:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )? )
            {
            // InternalAceGen.g:3754:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )? )
            // InternalAceGen.g:3755:3: ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )?
            {
            // InternalAceGen.g:3755:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3756:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3756:4: ( ruleQualifiedName )
            // InternalAceGen.g:3757:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGivenRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGivenRefAccess().getScenarioScenarioCrossReference_0_0());
            				
            pushFollow(FOLLOW_99);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3771:3: ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==RULE_INT) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // InternalAceGen.g:3772:4: ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x'
                    {
                    // InternalAceGen.g:3772:4: ( (lv_times_1_0= RULE_INT ) )
                    // InternalAceGen.g:3773:5: (lv_times_1_0= RULE_INT )
                    {
                    // InternalAceGen.g:3773:5: (lv_times_1_0= RULE_INT )
                    // InternalAceGen.g:3774:6: lv_times_1_0= RULE_INT
                    {
                    lv_times_1_0=(Token)match(input,RULE_INT,FOLLOW_98); 

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

                    otherlv_2=(Token)match(input,79,FOLLOW_39); 

                    				newLeafNode(otherlv_2, grammarAccess.getGivenRefAccess().getXKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:3795:3: ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==42) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalAceGen.g:3796:4: ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN'
                    {
                    // InternalAceGen.g:3796:4: ( (lv_excludeGiven_3_0= 'exclude' ) )
                    // InternalAceGen.g:3797:5: (lv_excludeGiven_3_0= 'exclude' )
                    {
                    // InternalAceGen.g:3797:5: (lv_excludeGiven_3_0= 'exclude' )
                    // InternalAceGen.g:3798:6: lv_excludeGiven_3_0= 'exclude'
                    {
                    lv_excludeGiven_3_0=(Token)match(input,42,FOLLOW_40); 

                    						newLeafNode(lv_excludeGiven_3_0, grammarAccess.getGivenRefAccess().getExcludeGivenExcludeKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGivenRefRule());
                    						}
                    						setWithLastConsumed(current, "excludeGiven", lv_excludeGiven_3_0 != null, "exclude");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,38,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getGivenRefAccess().getGIVENKeyword_2_1());
                    			

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
    // InternalAceGen.g:3819:1: entryRuleWhenBlock returns [EObject current=null] : iv_ruleWhenBlock= ruleWhenBlock EOF ;
    public final EObject entryRuleWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhenBlock = null;


        try {
            // InternalAceGen.g:3819:50: (iv_ruleWhenBlock= ruleWhenBlock EOF )
            // InternalAceGen.g:3820:2: iv_ruleWhenBlock= ruleWhenBlock EOF
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
    // InternalAceGen.g:3826:1: ruleWhenBlock returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* ) ;
    public final EObject ruleWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_dataDefinition_1_0 = null;

        EObject lv_authorization_2_0 = null;

        EObject lv_extractions_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3832:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* ) )
            // InternalAceGen.g:3833:2: ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* )
            {
            // InternalAceGen.g:3833:2: ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* )
            // InternalAceGen.g:3834:3: ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )*
            {
            // InternalAceGen.g:3834:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3835:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3835:4: ( ruleQualifiedName )
            // InternalAceGen.g:3836:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWhenBlockRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWhenBlockAccess().getActionHttpServerAceCrossReference_0_0());
            				
            pushFollow(FOLLOW_100);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3850:3: ( (lv_dataDefinition_1_0= ruleDataDefinition ) )
            // InternalAceGen.g:3851:4: (lv_dataDefinition_1_0= ruleDataDefinition )
            {
            // InternalAceGen.g:3851:4: (lv_dataDefinition_1_0= ruleDataDefinition )
            // InternalAceGen.g:3852:5: lv_dataDefinition_1_0= ruleDataDefinition
            {

            					newCompositeNode(grammarAccess.getWhenBlockAccess().getDataDefinitionDataDefinitionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_101);
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

            // InternalAceGen.g:3869:3: ( (lv_authorization_2_0= ruleAuthorization ) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==89) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalAceGen.g:3870:4: (lv_authorization_2_0= ruleAuthorization )
                    {
                    // InternalAceGen.g:3870:4: (lv_authorization_2_0= ruleAuthorization )
                    // InternalAceGen.g:3871:5: lv_authorization_2_0= ruleAuthorization
                    {

                    					newCompositeNode(grammarAccess.getWhenBlockAccess().getAuthorizationAuthorizationParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_102);
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

            // InternalAceGen.g:3888:3: ( (lv_extractions_3_0= ruleExtraction ) )*
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==85) ) {
                    alt121=1;
                }


                switch (alt121) {
            	case 1 :
            	    // InternalAceGen.g:3889:4: (lv_extractions_3_0= ruleExtraction )
            	    {
            	    // InternalAceGen.g:3889:4: (lv_extractions_3_0= ruleExtraction )
            	    // InternalAceGen.g:3890:5: lv_extractions_3_0= ruleExtraction
            	    {

            	    					newCompositeNode(grammarAccess.getWhenBlockAccess().getExtractionsExtractionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_102);
            	    lv_extractions_3_0=ruleExtraction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getWhenBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"extractions",
            	    						lv_extractions_3_0,
            	    						"de.acegen.AceGen.Extraction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop121;
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
    // $ANTLR end "ruleWhenBlock"


    // $ANTLR start "entryRuleThenBlock"
    // InternalAceGen.g:3911:1: entryRuleThenBlock returns [EObject current=null] : iv_ruleThenBlock= ruleThenBlock EOF ;
    public final EObject entryRuleThenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThenBlock = null;


        try {
            // InternalAceGen.g:3911:50: (iv_ruleThenBlock= ruleThenBlock EOF )
            // InternalAceGen.g:3912:2: iv_ruleThenBlock= ruleThenBlock EOF
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
    // InternalAceGen.g:3918:1: ruleThenBlock returns [EObject current=null] : ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? ) ;
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
            // InternalAceGen.g:3924:2: ( ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? ) )
            // InternalAceGen.g:3925:2: ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? )
            {
            // InternalAceGen.g:3925:2: ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? )
            // InternalAceGen.g:3926:3: ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )?
            {
            // InternalAceGen.g:3926:3: ( (lv_statusCode_0_0= RULE_INT ) )
            // InternalAceGen.g:3927:4: (lv_statusCode_0_0= RULE_INT )
            {
            // InternalAceGen.g:3927:4: (lv_statusCode_0_0= RULE_INT )
            // InternalAceGen.g:3928:5: lv_statusCode_0_0= RULE_INT
            {
            lv_statusCode_0_0=(Token)match(input,RULE_INT,FOLLOW_103); 

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

            // InternalAceGen.g:3944:3: (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==74) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalAceGen.g:3945:4: otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) )
                    {
                    otherlv_1=(Token)match(input,74,FOLLOW_104); 

                    				newLeafNode(otherlv_1, grammarAccess.getThenBlockAccess().getResponseKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,80,FOLLOW_105); 

                    				newLeafNode(otherlv_2, grammarAccess.getThenBlockAccess().getShouldBeKeyword_1_1());
                    			
                    // InternalAceGen.g:3953:4: ( (lv_response_3_0= ruleDataDefinition ) )
                    // InternalAceGen.g:3954:5: (lv_response_3_0= ruleDataDefinition )
                    {
                    // InternalAceGen.g:3954:5: (lv_response_3_0= ruleDataDefinition )
                    // InternalAceGen.g:3955:6: lv_response_3_0= ruleDataDefinition
                    {

                    						newCompositeNode(grammarAccess.getThenBlockAccess().getResponseDataDefinitionParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_106);
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

            // InternalAceGen.g:3973:3: (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==81) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // InternalAceGen.g:3974:4: otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )*
                    {
                    otherlv_4=(Token)match(input,81,FOLLOW_52); 

                    				newLeafNode(otherlv_4, grammarAccess.getThenBlockAccess().getPersistenceKeyword_2_0());
                    			
                    // InternalAceGen.g:3978:4: ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )*
                    loop123:
                    do {
                        int alt123=2;
                        int LA123_0 = input.LA(1);

                        if ( (LA123_0==RULE_ID) ) {
                            int LA123_2 = input.LA(2);

                            if ( (LA123_2==RULE_ID) ) {
                                alt123=1;
                            }


                        }


                        switch (alt123) {
                    	case 1 :
                    	    // InternalAceGen.g:3979:5: (lv_persistenceVerifications_5_0= rulePersistenceVerification )
                    	    {
                    	    // InternalAceGen.g:3979:5: (lv_persistenceVerifications_5_0= rulePersistenceVerification )
                    	    // InternalAceGen.g:3980:6: lv_persistenceVerifications_5_0= rulePersistenceVerification
                    	    {

                    	    						newCompositeNode(grammarAccess.getThenBlockAccess().getPersistenceVerificationsPersistenceVerificationParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_52);
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
                    	    break loop123;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:3998:3: (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==50) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalAceGen.g:3999:4: otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )*
                    {
                    otherlv_6=(Token)match(input,50,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getThenBlockAccess().getVerificationsKeyword_3_0());
                    			
                    // InternalAceGen.g:4003:4: ( (lv_verifications_7_0= ruleVerification ) )*
                    loop125:
                    do {
                        int alt125=2;
                        int LA125_0 = input.LA(1);

                        if ( (LA125_0==RULE_ID) ) {
                            int LA125_2 = input.LA(2);

                            if ( (LA125_2==EOF||LA125_2==RULE_ID||LA125_2==39) ) {
                                alt125=1;
                            }


                        }


                        switch (alt125) {
                    	case 1 :
                    	    // InternalAceGen.g:4004:5: (lv_verifications_7_0= ruleVerification )
                    	    {
                    	    // InternalAceGen.g:4004:5: (lv_verifications_7_0= ruleVerification )
                    	    // InternalAceGen.g:4005:6: lv_verifications_7_0= ruleVerification
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
                    	    break loop125;
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
    // InternalAceGen.g:4027:1: entryRulePersistenceVerification returns [EObject current=null] : iv_rulePersistenceVerification= rulePersistenceVerification EOF ;
    public final EObject entryRulePersistenceVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersistenceVerification = null;


        try {
            // InternalAceGen.g:4027:64: (iv_rulePersistenceVerification= rulePersistenceVerification EOF )
            // InternalAceGen.g:4028:2: iv_rulePersistenceVerification= rulePersistenceVerification EOF
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
    // InternalAceGen.g:4034:1: rulePersistenceVerification returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) ) ;
    public final EObject rulePersistenceVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4040:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) ) )
            // InternalAceGen.g:4041:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) )
            {
            // InternalAceGen.g:4041:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) )
            // InternalAceGen.g:4042:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) )
            {
            // InternalAceGen.g:4042:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:4043:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:4043:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:4044:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            // InternalAceGen.g:4060:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:4061:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:4061:4: ( ruleQualifiedName )
            // InternalAceGen.g:4062:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPersistenceVerificationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPersistenceVerificationAccess().getModelModelCrossReference_1_0());
            				
            pushFollow(FOLLOW_107);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:4076:3: ( (lv_expression_2_0= rulePersistenceVerificationExpression ) )
            // InternalAceGen.g:4077:4: (lv_expression_2_0= rulePersistenceVerificationExpression )
            {
            // InternalAceGen.g:4077:4: (lv_expression_2_0= rulePersistenceVerificationExpression )
            // InternalAceGen.g:4078:5: lv_expression_2_0= rulePersistenceVerificationExpression
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
    // InternalAceGen.g:4099:1: entryRulePersistenceVerificationExpression returns [EObject current=null] : iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF ;
    public final EObject entryRulePersistenceVerificationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersistenceVerificationExpression = null;


        try {
            // InternalAceGen.g:4099:74: (iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF )
            // InternalAceGen.g:4100:2: iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF
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
    // InternalAceGen.g:4106:1: rulePersistenceVerificationExpression returns [EObject current=null] : (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount ) ;
    public final EObject rulePersistenceVerificationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_SelectByUniqueAttribute_0 = null;

        EObject this_SelectByPrimaryKeys_1 = null;

        EObject this_Count_2 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4112:2: ( (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount ) )
            // InternalAceGen.g:4113:2: (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount )
            {
            // InternalAceGen.g:4113:2: (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount )
            int alt127=3;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt127=1;
                }
                break;
            case 82:
                {
                alt127=2;
                }
                break;
            case 84:
                {
                alt127=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }

            switch (alt127) {
                case 1 :
                    // InternalAceGen.g:4114:3: this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute
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
                    // InternalAceGen.g:4123:3: this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys
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
                    // InternalAceGen.g:4132:3: this_Count_2= ruleCount
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
    // InternalAceGen.g:4144:1: entryRuleSelectByPrimaryKeys returns [EObject current=null] : iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF ;
    public final EObject entryRuleSelectByPrimaryKeys() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByPrimaryKeys = null;


        try {
            // InternalAceGen.g:4144:60: (iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF )
            // InternalAceGen.g:4145:2: iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF
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
    // InternalAceGen.g:4151:1: ruleSelectByPrimaryKeys returns [EObject current=null] : (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) ) ;
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
            // InternalAceGen.g:4157:2: ( (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) ) )
            // InternalAceGen.g:4158:2: (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) )
            {
            // InternalAceGen.g:4158:2: (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) )
            // InternalAceGen.g:4159:3: otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) )
            {
            otherlv_0=(Token)match(input,82,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getSelectByPrimaryKeysAccess().getSelectByPrimaryKeyKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectByPrimaryKeysAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:4167:3: ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:4168:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:4168:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:4169:5: lv_attributeAndValues_2_0= ruleAttributeAndValue
            {

            					newCompositeNode(grammarAccess.getSelectByPrimaryKeysAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
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

            // InternalAceGen.g:4186:3: (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==19) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalAceGen.g:4187:4: otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_42); 

                    				newLeafNode(otherlv_3, grammarAccess.getSelectByPrimaryKeysAccess().getCommaKeyword_3_0());
                    			
                    // InternalAceGen.g:4191:4: ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    loop128:
                    do {
                        int alt128=2;
                        int LA128_0 = input.LA(1);

                        if ( (LA128_0==RULE_ID) ) {
                            alt128=1;
                        }


                        switch (alt128) {
                    	case 1 :
                    	    // InternalAceGen.g:4192:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    {
                    	    // InternalAceGen.g:4192:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    // InternalAceGen.g:4193:6: lv_attributeAndValues_4_0= ruleAttributeAndValue
                    	    {

                    	    						newCompositeNode(grammarAccess.getSelectByPrimaryKeysAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_42);
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
                    	    break loop128;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_104); 

            			newLeafNode(otherlv_5, grammarAccess.getSelectByPrimaryKeysAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,80,FOLLOW_108); 

            			newLeafNode(otherlv_6, grammarAccess.getSelectByPrimaryKeysAccess().getShouldBeKeyword_5());
            		
            // InternalAceGen.g:4219:3: ( (lv_expected_7_0= ruleSelectByExpectation ) )
            // InternalAceGen.g:4220:4: (lv_expected_7_0= ruleSelectByExpectation )
            {
            // InternalAceGen.g:4220:4: (lv_expected_7_0= ruleSelectByExpectation )
            // InternalAceGen.g:4221:5: lv_expected_7_0= ruleSelectByExpectation
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
    // InternalAceGen.g:4242:1: entryRuleSelectByUniqueAttribute returns [EObject current=null] : iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF ;
    public final EObject entryRuleSelectByUniqueAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByUniqueAttribute = null;


        try {
            // InternalAceGen.g:4242:64: (iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF )
            // InternalAceGen.g:4243:2: iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF
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
    // InternalAceGen.g:4249:1: ruleSelectByUniqueAttribute returns [EObject current=null] : (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) ) ;
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
            // InternalAceGen.g:4255:2: ( (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) ) )
            // InternalAceGen.g:4256:2: (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) )
            {
            // InternalAceGen.g:4256:2: (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) )
            // InternalAceGen.g:4257:3: otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) )
            {
            otherlv_0=(Token)match(input,83,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getSelectByUniqueAttributeAccess().getSelectByKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectByUniqueAttributeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:4265:3: ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:4266:4: (lv_attributeAndValue_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:4266:4: (lv_attributeAndValue_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:4267:5: lv_attributeAndValue_2_0= ruleAttributeAndValue
            {

            					newCompositeNode(grammarAccess.getSelectByUniqueAttributeAccess().getAttributeAndValueAttributeAndValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_58);
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

            otherlv_3=(Token)match(input,20,FOLLOW_104); 

            			newLeafNode(otherlv_3, grammarAccess.getSelectByUniqueAttributeAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,80,FOLLOW_108); 

            			newLeafNode(otherlv_4, grammarAccess.getSelectByUniqueAttributeAccess().getShouldBeKeyword_4());
            		
            // InternalAceGen.g:4292:3: ( (lv_expected_5_0= ruleSelectByExpectation ) )
            // InternalAceGen.g:4293:4: (lv_expected_5_0= ruleSelectByExpectation )
            {
            // InternalAceGen.g:4293:4: (lv_expected_5_0= ruleSelectByExpectation )
            // InternalAceGen.g:4294:5: lv_expected_5_0= ruleSelectByExpectation
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
    // InternalAceGen.g:4315:1: entryRuleCount returns [EObject current=null] : iv_ruleCount= ruleCount EOF ;
    public final EObject entryRuleCount() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCount = null;


        try {
            // InternalAceGen.g:4315:46: (iv_ruleCount= ruleCount EOF )
            // InternalAceGen.g:4316:2: iv_ruleCount= ruleCount EOF
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
    // InternalAceGen.g:4322:1: ruleCount returns [EObject current=null] : (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) ) ;
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
            // InternalAceGen.g:4328:2: ( (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) ) )
            // InternalAceGen.g:4329:2: (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) )
            {
            // InternalAceGen.g:4329:2: (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) )
            // InternalAceGen.g:4330:3: otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,84,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getCountAccess().getFilterAndCountByKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getCountAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:4338:3: ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:4339:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:4339:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:4340:5: lv_attributeAndValues_2_0= ruleAttributeAndValue
            {

            					newCompositeNode(grammarAccess.getCountAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
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

            // InternalAceGen.g:4357:3: (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==19) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // InternalAceGen.g:4358:4: otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_42); 

                    				newLeafNode(otherlv_3, grammarAccess.getCountAccess().getCommaKeyword_3_0());
                    			
                    // InternalAceGen.g:4362:4: ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    loop130:
                    do {
                        int alt130=2;
                        int LA130_0 = input.LA(1);

                        if ( (LA130_0==RULE_ID) ) {
                            alt130=1;
                        }


                        switch (alt130) {
                    	case 1 :
                    	    // InternalAceGen.g:4363:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    {
                    	    // InternalAceGen.g:4363:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    // InternalAceGen.g:4364:6: lv_attributeAndValues_4_0= ruleAttributeAndValue
                    	    {

                    	    						newCompositeNode(grammarAccess.getCountAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_42);
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
                    	    break loop130;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_104); 

            			newLeafNode(otherlv_5, grammarAccess.getCountAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,80,FOLLOW_22); 

            			newLeafNode(otherlv_6, grammarAccess.getCountAccess().getShouldBeKeyword_5());
            		
            // InternalAceGen.g:4390:3: ( (lv_expected_7_0= RULE_INT ) )
            // InternalAceGen.g:4391:4: (lv_expected_7_0= RULE_INT )
            {
            // InternalAceGen.g:4391:4: (lv_expected_7_0= RULE_INT )
            // InternalAceGen.g:4392:5: lv_expected_7_0= RULE_INT
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
    // InternalAceGen.g:4412:1: entryRuleAttributeAndValue returns [EObject current=null] : iv_ruleAttributeAndValue= ruleAttributeAndValue EOF ;
    public final EObject entryRuleAttributeAndValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeAndValue = null;


        try {
            // InternalAceGen.g:4412:58: (iv_ruleAttributeAndValue= ruleAttributeAndValue EOF )
            // InternalAceGen.g:4413:2: iv_ruleAttributeAndValue= ruleAttributeAndValue EOF
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
    // InternalAceGen.g:4419:1: ruleAttributeAndValue returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject ruleAttributeAndValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4425:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalAceGen.g:4426:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalAceGen.g:4426:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalAceGen.g:4427:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalAceGen.g:4427:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:4428:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:4428:4: ( ruleQualifiedName )
            // InternalAceGen.g:4429:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeAndValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAttributeAndValueAccess().getAttributeAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_50);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,48,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeAndValueAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:4447:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalAceGen.g:4448:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalAceGen.g:4448:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalAceGen.g:4449:5: lv_value_2_0= rulePrimitiveValue
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
    // InternalAceGen.g:4470:1: entryRuleVerification returns [EObject current=null] : iv_ruleVerification= ruleVerification EOF ;
    public final EObject entryRuleVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerification = null;


        try {
            // InternalAceGen.g:4470:53: (iv_ruleVerification= ruleVerification EOF )
            // InternalAceGen.g:4471:2: iv_ruleVerification= ruleVerification EOF
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
    // InternalAceGen.g:4477:1: ruleVerification returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4483:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalAceGen.g:4484:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalAceGen.g:4484:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:4485:3: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:4485:3: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:4486:4: lv_name_0_0= RULE_ID
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


    // $ANTLR start "entryRuleExtraction"
    // InternalAceGen.g:4505:1: entryRuleExtraction returns [EObject current=null] : iv_ruleExtraction= ruleExtraction EOF ;
    public final EObject entryRuleExtraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtraction = null;


        try {
            // InternalAceGen.g:4505:51: (iv_ruleExtraction= ruleExtraction EOF )
            // InternalAceGen.g:4506:2: iv_ruleExtraction= ruleExtraction EOF
            {
             newCompositeNode(grammarAccess.getExtractionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtraction=ruleExtraction();

            state._fsp--;

             current =iv_ruleExtraction; 
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
    // $ANTLR end "entryRuleExtraction"


    // $ANTLR start "ruleExtraction"
    // InternalAceGen.g:4512:1: ruleExtraction returns [EObject current=null] : (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExtraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4518:2: ( (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalAceGen.g:4519:2: (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalAceGen.g:4519:2: (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalAceGen.g:4520:3: otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,85,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getExtractionAccess().getExtractKeyword_0());
            		
            // InternalAceGen.g:4524:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:4525:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:4525:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:4526:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getExtractionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExtractionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleExtraction"


    // $ANTLR start "entryRuleSelectByExpectation"
    // InternalAceGen.g:4546:1: entryRuleSelectByExpectation returns [EObject current=null] : iv_ruleSelectByExpectation= ruleSelectByExpectation EOF ;
    public final EObject entryRuleSelectByExpectation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByExpectation = null;


        try {
            // InternalAceGen.g:4546:60: (iv_ruleSelectByExpectation= ruleSelectByExpectation EOF )
            // InternalAceGen.g:4547:2: iv_ruleSelectByExpectation= ruleSelectByExpectation EOF
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
    // InternalAceGen.g:4553:1: ruleSelectByExpectation returns [EObject current=null] : ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) ) ;
    public final EObject ruleSelectByExpectation() throws RecognitionException {
        EObject current = null;

        Token lv_isNotNull_1_0=null;
        Token lv_isNull_2_0=null;
        EObject lv_object_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4559:2: ( ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) ) )
            // InternalAceGen.g:4560:2: ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) )
            {
            // InternalAceGen.g:4560:2: ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) )
            int alt132=3;
            switch ( input.LA(1) ) {
            case 35:
            case 105:
                {
                alt132=1;
                }
                break;
            case 86:
                {
                alt132=2;
                }
                break;
            case 87:
                {
                alt132=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }

            switch (alt132) {
                case 1 :
                    // InternalAceGen.g:4561:3: ( (lv_object_0_0= ruleJsonObject ) )
                    {
                    // InternalAceGen.g:4561:3: ( (lv_object_0_0= ruleJsonObject ) )
                    // InternalAceGen.g:4562:4: (lv_object_0_0= ruleJsonObject )
                    {
                    // InternalAceGen.g:4562:4: (lv_object_0_0= ruleJsonObject )
                    // InternalAceGen.g:4563:5: lv_object_0_0= ruleJsonObject
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
                    // InternalAceGen.g:4581:3: ( (lv_isNotNull_1_0= 'notNull' ) )
                    {
                    // InternalAceGen.g:4581:3: ( (lv_isNotNull_1_0= 'notNull' ) )
                    // InternalAceGen.g:4582:4: (lv_isNotNull_1_0= 'notNull' )
                    {
                    // InternalAceGen.g:4582:4: (lv_isNotNull_1_0= 'notNull' )
                    // InternalAceGen.g:4583:5: lv_isNotNull_1_0= 'notNull'
                    {
                    lv_isNotNull_1_0=(Token)match(input,86,FOLLOW_2); 

                    					newLeafNode(lv_isNotNull_1_0, grammarAccess.getSelectByExpectationAccess().getIsNotNullNotNullKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSelectByExpectationRule());
                    					}
                    					setWithLastConsumed(current, "isNotNull", lv_isNotNull_1_0 != null, "notNull");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalAceGen.g:4596:3: ( (lv_isNull_2_0= 'null' ) )
                    {
                    // InternalAceGen.g:4596:3: ( (lv_isNull_2_0= 'null' ) )
                    // InternalAceGen.g:4597:4: (lv_isNull_2_0= 'null' )
                    {
                    // InternalAceGen.g:4597:4: (lv_isNull_2_0= 'null' )
                    // InternalAceGen.g:4598:5: lv_isNull_2_0= 'null'
                    {
                    lv_isNull_2_0=(Token)match(input,87,FOLLOW_2); 

                    					newLeafNode(lv_isNull_2_0, grammarAccess.getSelectByExpectationAccess().getIsNullNullKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSelectByExpectationRule());
                    					}
                    					setWithLastConsumed(current, "isNull", lv_isNull_2_0 != null, "null");
                    				

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
    // InternalAceGen.g:4614:1: entryRuleDataDefinition returns [EObject current=null] : iv_ruleDataDefinition= ruleDataDefinition EOF ;
    public final EObject entryRuleDataDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDefinition = null;


        try {
            // InternalAceGen.g:4614:55: (iv_ruleDataDefinition= ruleDataDefinition EOF )
            // InternalAceGen.g:4615:2: iv_ruleDataDefinition= ruleDataDefinition EOF
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
    // InternalAceGen.g:4621:1: ruleDataDefinition returns [EObject current=null] : ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? ) ;
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
            // InternalAceGen.g:4627:2: ( ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? ) )
            // InternalAceGen.g:4628:2: ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? )
            {
            // InternalAceGen.g:4628:2: ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? )
            // InternalAceGen.g:4629:3: () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )?
            {
            // InternalAceGen.g:4629:3: ()
            // InternalAceGen.g:4630:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataDefinitionAccess().getDataDefinitionAction_0(),
            					current);
            			

            }

            // InternalAceGen.g:4636:3: (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==44) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // InternalAceGen.g:4637:4: otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,44,FOLLOW_46); 

                    				newLeafNode(otherlv_1, grammarAccess.getDataDefinitionAccess().getUuidKeyword_1_0());
                    			
                    // InternalAceGen.g:4641:4: ( (lv_uuid_2_0= RULE_STRING ) )
                    // InternalAceGen.g:4642:5: (lv_uuid_2_0= RULE_STRING )
                    {
                    // InternalAceGen.g:4642:5: (lv_uuid_2_0= RULE_STRING )
                    // InternalAceGen.g:4643:6: lv_uuid_2_0= RULE_STRING
                    {
                    lv_uuid_2_0=(Token)match(input,RULE_STRING,FOLLOW_109); 

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

            // InternalAceGen.g:4660:3: (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==88) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // InternalAceGen.g:4661:4: otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,88,FOLLOW_46); 

                    				newLeafNode(otherlv_3, grammarAccess.getDataDefinitionAccess().getSystemTimeKeyword_2_0());
                    			
                    // InternalAceGen.g:4665:4: ( (lv_systemtime_4_0= RULE_STRING ) )
                    // InternalAceGen.g:4666:5: (lv_systemtime_4_0= RULE_STRING )
                    {
                    // InternalAceGen.g:4666:5: (lv_systemtime_4_0= RULE_STRING )
                    // InternalAceGen.g:4667:6: lv_systemtime_4_0= RULE_STRING
                    {
                    lv_systemtime_4_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

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

                    // InternalAceGen.g:4683:4: ( (lv_pattern_5_0= RULE_STRING ) )
                    // InternalAceGen.g:4684:5: (lv_pattern_5_0= RULE_STRING )
                    {
                    // InternalAceGen.g:4684:5: (lv_pattern_5_0= RULE_STRING )
                    // InternalAceGen.g:4685:6: lv_pattern_5_0= RULE_STRING
                    {
                    lv_pattern_5_0=(Token)match(input,RULE_STRING,FOLLOW_110); 

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

            // InternalAceGen.g:4702:3: ( (lv_data_6_0= ruleJsonObject ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==35||LA135_0==105) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalAceGen.g:4703:4: (lv_data_6_0= ruleJsonObject )
                    {
                    // InternalAceGen.g:4703:4: (lv_data_6_0= ruleJsonObject )
                    // InternalAceGen.g:4704:5: lv_data_6_0= ruleJsonObject
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
    // InternalAceGen.g:4725:1: entryRuleAuthorization returns [EObject current=null] : iv_ruleAuthorization= ruleAuthorization EOF ;
    public final EObject entryRuleAuthorization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthorization = null;


        try {
            // InternalAceGen.g:4725:54: (iv_ruleAuthorization= ruleAuthorization EOF )
            // InternalAceGen.g:4726:2: iv_ruleAuthorization= ruleAuthorization EOF
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
    // InternalAceGen.g:4732:1: ruleAuthorization returns [EObject current=null] : (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleAuthorization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_username_1_0=null;
        Token otherlv_2=null;
        Token lv_password_3_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4738:2: ( (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) ) )
            // InternalAceGen.g:4739:2: (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) )
            {
            // InternalAceGen.g:4739:2: (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) )
            // InternalAceGen.g:4740:3: otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,89,FOLLOW_46); 

            			newLeafNode(otherlv_0, grammarAccess.getAuthorizationAccess().getAuthorizationKeyword_0());
            		
            // InternalAceGen.g:4744:3: ( (lv_username_1_0= RULE_STRING ) )
            // InternalAceGen.g:4745:4: (lv_username_1_0= RULE_STRING )
            {
            // InternalAceGen.g:4745:4: (lv_username_1_0= RULE_STRING )
            // InternalAceGen.g:4746:5: lv_username_1_0= RULE_STRING
            {
            lv_username_1_0=(Token)match(input,RULE_STRING,FOLLOW_50); 

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

            otherlv_2=(Token)match(input,48,FOLLOW_46); 

            			newLeafNode(otherlv_2, grammarAccess.getAuthorizationAccess().getColonKeyword_2());
            		
            // InternalAceGen.g:4766:3: ( (lv_password_3_0= RULE_STRING ) )
            // InternalAceGen.g:4767:4: (lv_password_3_0= RULE_STRING )
            {
            // InternalAceGen.g:4767:4: (lv_password_3_0= RULE_STRING )
            // InternalAceGen.g:4768:5: lv_password_3_0= RULE_STRING
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
    // InternalAceGen.g:4788:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalAceGen.g:4788:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalAceGen.g:4789:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalAceGen.g:4795:1: ruleAttribute returns [EObject current=null] : ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_squishy_9_0= 'squishy' ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_unique_0_0=null;
        Token lv_primaryKey_1_0=null;
        Token lv_notNull_2_0=null;
        Token lv_list_3_0=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token lv_squishy_9_0=null;
        AntlrDatatypeRuleToken lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4801:2: ( ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_squishy_9_0= 'squishy' ) )? ) )
            // InternalAceGen.g:4802:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_squishy_9_0= 'squishy' ) )? )
            {
            // InternalAceGen.g:4802:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_squishy_9_0= 'squishy' ) )? )
            // InternalAceGen.g:4803:3: ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_squishy_9_0= 'squishy' ) )?
            {
            // InternalAceGen.g:4803:3: ( (lv_unique_0_0= 'Unique' ) )?
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==90) ) {
                alt136=1;
            }
            switch (alt136) {
                case 1 :
                    // InternalAceGen.g:4804:4: (lv_unique_0_0= 'Unique' )
                    {
                    // InternalAceGen.g:4804:4: (lv_unique_0_0= 'Unique' )
                    // InternalAceGen.g:4805:5: lv_unique_0_0= 'Unique'
                    {
                    lv_unique_0_0=(Token)match(input,90,FOLLOW_111); 

                    					newLeafNode(lv_unique_0_0, grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "unique", lv_unique_0_0 != null, "Unique");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4817:3: ( (lv_primaryKey_1_0= 'PrimaryKey' ) )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==91) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // InternalAceGen.g:4818:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    {
                    // InternalAceGen.g:4818:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    // InternalAceGen.g:4819:5: lv_primaryKey_1_0= 'PrimaryKey'
                    {
                    lv_primaryKey_1_0=(Token)match(input,91,FOLLOW_112); 

                    					newLeafNode(lv_primaryKey_1_0, grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "primaryKey", lv_primaryKey_1_0 != null, "PrimaryKey");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4831:3: ( (lv_notNull_2_0= 'NotNull' ) )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==75) ) {
                alt138=1;
            }
            switch (alt138) {
                case 1 :
                    // InternalAceGen.g:4832:4: (lv_notNull_2_0= 'NotNull' )
                    {
                    // InternalAceGen.g:4832:4: (lv_notNull_2_0= 'NotNull' )
                    // InternalAceGen.g:4833:5: lv_notNull_2_0= 'NotNull'
                    {
                    lv_notNull_2_0=(Token)match(input,75,FOLLOW_113); 

                    					newLeafNode(lv_notNull_2_0, grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "notNull", lv_notNull_2_0 != null, "NotNull");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4845:3: ( (lv_list_3_0= 'List' ) )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==32) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // InternalAceGen.g:4846:4: (lv_list_3_0= 'List' )
                    {
                    // InternalAceGen.g:4846:4: (lv_list_3_0= 'List' )
                    // InternalAceGen.g:4847:5: lv_list_3_0= 'List'
                    {
                    lv_list_3_0=(Token)match(input,32,FOLLOW_114); 

                    					newLeafNode(lv_list_3_0, grammarAccess.getAttributeAccess().getListListKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "list", lv_list_3_0 != null, "List");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4859:3: ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) )
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( ((LA140_0>=98 && LA140_0<=104)) ) {
                alt140=1;
            }
            else if ( (LA140_0==RULE_ID) ) {
                alt140=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;
            }
            switch (alt140) {
                case 1 :
                    // InternalAceGen.g:4860:4: ( (lv_type_4_0= ruleType ) )
                    {
                    // InternalAceGen.g:4860:4: ( (lv_type_4_0= ruleType ) )
                    // InternalAceGen.g:4861:5: (lv_type_4_0= ruleType )
                    {
                    // InternalAceGen.g:4861:5: (lv_type_4_0= ruleType )
                    // InternalAceGen.g:4862:6: lv_type_4_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getAttributeAccess().getTypeTypeParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_9);
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
                    // InternalAceGen.g:4880:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalAceGen.g:4880:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:4881:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:4881:5: ( ruleQualifiedName )
                    // InternalAceGen.g:4882:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getModelModelCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_9);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:4897:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalAceGen.g:4898:4: (lv_name_6_0= RULE_ID )
            {
            // InternalAceGen.g:4898:4: (lv_name_6_0= RULE_ID )
            // InternalAceGen.g:4899:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_115); 

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

            // InternalAceGen.g:4915:3: (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==92) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // InternalAceGen.g:4916:4: otherlv_7= 'references' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,92,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getReferencesKeyword_6_0());
                    			
                    // InternalAceGen.g:4920:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:4921:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:4921:5: ( ruleQualifiedName )
                    // InternalAceGen.g:4922:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_116);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:4937:3: ( (lv_squishy_9_0= 'squishy' ) )?
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==47) ) {
                alt142=1;
            }
            switch (alt142) {
                case 1 :
                    // InternalAceGen.g:4938:4: (lv_squishy_9_0= 'squishy' )
                    {
                    // InternalAceGen.g:4938:4: (lv_squishy_9_0= 'squishy' )
                    // InternalAceGen.g:4939:5: lv_squishy_9_0= 'squishy'
                    {
                    lv_squishy_9_0=(Token)match(input,47,FOLLOW_2); 

                    					newLeafNode(lv_squishy_9_0, grammarAccess.getAttributeAccess().getSquishySquishyKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "squishy", lv_squishy_9_0 != null, "squishy");
                    				

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
    // InternalAceGen.g:4955:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalAceGen.g:4955:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalAceGen.g:4956:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalAceGen.g:4962:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalAceGen.g:4968:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalAceGen.g:4969:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalAceGen.g:4969:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalAceGen.g:4970:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_117); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalAceGen.g:4977:3: (kw= '.' this_ID_2= RULE_ID )*
            loop143:
            do {
                int alt143=2;
                int LA143_0 = input.LA(1);

                if ( (LA143_0==93) ) {
                    alt143=1;
                }


                switch (alt143) {
            	case 1 :
            	    // InternalAceGen.g:4978:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,93,FOLLOW_9); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_117); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop143;
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
    // InternalAceGen.g:4995:1: entryRuleWriteFunctionType returns [String current=null] : iv_ruleWriteFunctionType= ruleWriteFunctionType EOF ;
    public final String entryRuleWriteFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWriteFunctionType = null;


        try {
            // InternalAceGen.g:4995:57: (iv_ruleWriteFunctionType= ruleWriteFunctionType EOF )
            // InternalAceGen.g:4996:2: iv_ruleWriteFunctionType= ruleWriteFunctionType EOF
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
    // InternalAceGen.g:5002:1: ruleWriteFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) ;
    public final AntlrDatatypeRuleToken ruleWriteFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:5008:2: ( (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) )
            // InternalAceGen.g:5009:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            {
            // InternalAceGen.g:5009:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            int alt144=3;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt144=1;
                }
                break;
            case 95:
                {
                alt144=2;
                }
                break;
            case 96:
                {
                alt144=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 144, 0, input);

                throw nvae;
            }

            switch (alt144) {
                case 1 :
                    // InternalAceGen.g:5010:3: kw= 'POST'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:5016:3: kw= 'PUT'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:5022:3: kw= 'DELETE'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); 

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
    // InternalAceGen.g:5031:1: entryRuleReadFunctionType returns [String current=null] : iv_ruleReadFunctionType= ruleReadFunctionType EOF ;
    public final String entryRuleReadFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReadFunctionType = null;


        try {
            // InternalAceGen.g:5031:56: (iv_ruleReadFunctionType= ruleReadFunctionType EOF )
            // InternalAceGen.g:5032:2: iv_ruleReadFunctionType= ruleReadFunctionType EOF
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
    // InternalAceGen.g:5038:1: ruleReadFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'GET' ;
    public final AntlrDatatypeRuleToken ruleReadFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:5044:2: (kw= 'GET' )
            // InternalAceGen.g:5045:2: kw= 'GET'
            {
            kw=(Token)match(input,97,FOLLOW_2); 

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
    // InternalAceGen.g:5053:1: entryRuleType returns [String current=null] : iv_ruleType= ruleType EOF ;
    public final String entryRuleType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType = null;


        try {
            // InternalAceGen.g:5053:44: (iv_ruleType= ruleType EOF )
            // InternalAceGen.g:5054:2: iv_ruleType= ruleType EOF
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
    // InternalAceGen.g:5060:1: ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' | kw= 'FormData' ) ;
    public final AntlrDatatypeRuleToken ruleType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:5066:2: ( (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' | kw= 'FormData' ) )
            // InternalAceGen.g:5067:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' | kw= 'FormData' )
            {
            // InternalAceGen.g:5067:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' | kw= 'FormData' )
            int alt145=7;
            switch ( input.LA(1) ) {
            case 98:
                {
                alt145=1;
                }
                break;
            case 99:
                {
                alt145=2;
                }
                break;
            case 100:
                {
                alt145=3;
                }
                break;
            case 101:
                {
                alt145=4;
                }
                break;
            case 102:
                {
                alt145=5;
                }
                break;
            case 103:
                {
                alt145=6;
                }
                break;
            case 104:
                {
                alt145=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 145, 0, input);

                throw nvae;
            }

            switch (alt145) {
                case 1 :
                    // InternalAceGen.g:5068:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getIntegerKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:5074:3: kw= 'String'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getStringKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:5080:3: kw= 'Float'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getFloatKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAceGen.g:5086:3: kw= 'Boolean'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getBooleanKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalAceGen.g:5092:3: kw= 'DateTime'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getDateTimeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalAceGen.g:5098:3: kw= 'Long'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getLongKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalAceGen.g:5104:3: kw= 'FormData'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getFormDataKeyword_6());
                    		

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


    // $ANTLR start "entryRuleJsonObject"
    // InternalAceGen.g:5113:1: entryRuleJsonObject returns [EObject current=null] : iv_ruleJsonObject= ruleJsonObject EOF ;
    public final EObject entryRuleJsonObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObject = null;


        try {
            // InternalAceGen.g:5113:51: (iv_ruleJsonObject= ruleJsonObject EOF )
            // InternalAceGen.g:5114:2: iv_ruleJsonObject= ruleJsonObject EOF
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
    // InternalAceGen.g:5120:1: ruleJsonObject returns [EObject current=null] : (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) ) ;
    public final EObject ruleJsonObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_JsonObjectAce_0 = null;

        EObject this_StringType_2 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5126:2: ( (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) ) )
            // InternalAceGen.g:5127:2: (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) )
            {
            // InternalAceGen.g:5127:2: (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) )
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==35) ) {
                alt146=1;
            }
            else if ( (LA146_0==105) ) {
                alt146=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 146, 0, input);

                throw nvae;
            }
            switch (alt146) {
                case 1 :
                    // InternalAceGen.g:5128:3: this_JsonObjectAce_0= ruleJsonObjectAce
                    {

                    			newCompositeNode(grammarAccess.getJsonObjectAccess().getJsonObjectAceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_JsonObjectAce_0=ruleJsonObjectAce();

                    state._fsp--;


                    			current = this_JsonObjectAce_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:5137:3: (otherlv_1= 'json' this_StringType_2= ruleStringType )
                    {
                    // InternalAceGen.g:5137:3: (otherlv_1= 'json' this_StringType_2= ruleStringType )
                    // InternalAceGen.g:5138:4: otherlv_1= 'json' this_StringType_2= ruleStringType
                    {
                    otherlv_1=(Token)match(input,105,FOLLOW_46); 

                    				newLeafNode(otherlv_1, grammarAccess.getJsonObjectAccess().getJsonKeyword_1_0());
                    			

                    				newCompositeNode(grammarAccess.getJsonObjectAccess().getStringTypeParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_StringType_2=ruleStringType();

                    state._fsp--;


                    				current = this_StringType_2;
                    				afterParserOrEnumRuleCall();
                    			

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
    // $ANTLR end "ruleJsonObject"


    // $ANTLR start "entryRuleJsonObjectAce"
    // InternalAceGen.g:5155:1: entryRuleJsonObjectAce returns [EObject current=null] : iv_ruleJsonObjectAce= ruleJsonObjectAce EOF ;
    public final EObject entryRuleJsonObjectAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObjectAce = null;


        try {
            // InternalAceGen.g:5155:54: (iv_ruleJsonObjectAce= ruleJsonObjectAce EOF )
            // InternalAceGen.g:5156:2: iv_ruleJsonObjectAce= ruleJsonObjectAce EOF
            {
             newCompositeNode(grammarAccess.getJsonObjectAceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJsonObjectAce=ruleJsonObjectAce();

            state._fsp--;

             current =iv_ruleJsonObjectAce; 
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
    // $ANTLR end "entryRuleJsonObjectAce"


    // $ANTLR start "ruleJsonObjectAce"
    // InternalAceGen.g:5162:1: ruleJsonObjectAce returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleJsonObjectAce() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_members_2_0 = null;

        EObject lv_members_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5168:2: ( ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' ) )
            // InternalAceGen.g:5169:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' )
            {
            // InternalAceGen.g:5169:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' )
            // InternalAceGen.g:5170:3: () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}'
            {
            // InternalAceGen.g:5170:3: ()
            // InternalAceGen.g:5171:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonObjectAceAccess().getJsonObjectAceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonObjectAceAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:5181:3: ( (lv_members_2_0= ruleJsonMember ) )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==RULE_ID) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // InternalAceGen.g:5182:4: (lv_members_2_0= ruleJsonMember )
                    {
                    // InternalAceGen.g:5182:4: (lv_members_2_0= ruleJsonMember )
                    // InternalAceGen.g:5183:5: lv_members_2_0= ruleJsonMember
                    {

                    					newCompositeNode(grammarAccess.getJsonObjectAceAccess().getMembersJsonMemberParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_60);
                    lv_members_2_0=ruleJsonMember();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJsonObjectAceRule());
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

            // InternalAceGen.g:5200:3: (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )*
            loop148:
            do {
                int alt148=2;
                int LA148_0 = input.LA(1);

                if ( (LA148_0==19) ) {
                    alt148=1;
                }


                switch (alt148) {
            	case 1 :
            	    // InternalAceGen.g:5201:4: otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_9); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonObjectAceAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:5205:4: ( (lv_members_4_0= ruleJsonMember ) )
            	    // InternalAceGen.g:5206:5: (lv_members_4_0= ruleJsonMember )
            	    {
            	    // InternalAceGen.g:5206:5: (lv_members_4_0= ruleJsonMember )
            	    // InternalAceGen.g:5207:6: lv_members_4_0= ruleJsonMember
            	    {

            	    						newCompositeNode(grammarAccess.getJsonObjectAceAccess().getMembersJsonMemberParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_60);
            	    lv_members_4_0=ruleJsonMember();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJsonObjectAceRule());
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
            	    break loop148;
                }
            } while (true);

            otherlv_5=(Token)match(input,37,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getJsonObjectAceAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleJsonObjectAce"


    // $ANTLR start "entryRuleJsonMember"
    // InternalAceGen.g:5233:1: entryRuleJsonMember returns [EObject current=null] : iv_ruleJsonMember= ruleJsonMember EOF ;
    public final EObject entryRuleJsonMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonMember = null;


        try {
            // InternalAceGen.g:5233:51: (iv_ruleJsonMember= ruleJsonMember EOF )
            // InternalAceGen.g:5234:2: iv_ruleJsonMember= ruleJsonMember EOF
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
    // InternalAceGen.g:5240:1: ruleJsonMember returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) ) ;
    public final EObject ruleJsonMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5246:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) ) )
            // InternalAceGen.g:5247:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) )
            {
            // InternalAceGen.g:5247:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) )
            // InternalAceGen.g:5248:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) )
            {
            // InternalAceGen.g:5248:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5249:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:5249:4: ( ruleQualifiedName )
            // InternalAceGen.g:5250:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonMemberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJsonMemberAccess().getAttributeAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_50);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,48,FOLLOW_118); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonMemberAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:5268:3: ( (lv_value_2_0= ruleJsonValue ) )
            // InternalAceGen.g:5269:4: (lv_value_2_0= ruleJsonValue )
            {
            // InternalAceGen.g:5269:4: (lv_value_2_0= ruleJsonValue )
            // InternalAceGen.g:5270:5: lv_value_2_0= ruleJsonValue
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
    // InternalAceGen.g:5291:1: entryRuleJsonValue returns [EObject current=null] : iv_ruleJsonValue= ruleJsonValue EOF ;
    public final EObject entryRuleJsonValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonValue = null;


        try {
            // InternalAceGen.g:5291:50: (iv_ruleJsonValue= ruleJsonValue EOF )
            // InternalAceGen.g:5292:2: iv_ruleJsonValue= ruleJsonValue EOF
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
    // InternalAceGen.g:5298:1: ruleJsonValue returns [EObject current=null] : (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime ) ;
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
            // InternalAceGen.g:5304:2: ( (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime ) )
            // InternalAceGen.g:5305:2: (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime )
            {
            // InternalAceGen.g:5305:2: (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime )
            int alt149=7;
            switch ( input.LA(1) ) {
            case 35:
            case 105:
                {
                alt149=1;
                }
                break;
            case RULE_STRING:
                {
                int LA149_2 = input.LA(2);

                if ( (LA149_2==RULE_STRING) ) {
                    alt149=7;
                }
                else if ( (LA149_2==EOF||LA149_2==19||LA149_2==37||LA149_2==55) ) {
                    alt149=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 149, 2, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                alt149=3;
                }
                break;
            case 107:
            case 108:
                {
                alt149=4;
                }
                break;
            case 87:
                {
                alt149=5;
                }
                break;
            case RULE_INT:
                {
                alt149=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 149, 0, input);

                throw nvae;
            }

            switch (alt149) {
                case 1 :
                    // InternalAceGen.g:5306:3: this_JsonObject_0= ruleJsonObject
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
                    // InternalAceGen.g:5315:3: this_StringType_1= ruleStringType
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
                    // InternalAceGen.g:5324:3: this_JsonArray_2= ruleJsonArray
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
                    // InternalAceGen.g:5333:3: this_BooleanType_3= ruleBooleanType
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
                    // InternalAceGen.g:5342:3: this_NullType_4= ruleNullType
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
                    // InternalAceGen.g:5351:3: this_LongType_5= ruleLongType
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
                    // InternalAceGen.g:5360:3: this_JsonDateTime_6= ruleJsonDateTime
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
    // InternalAceGen.g:5372:1: entryRuleJsonArray returns [EObject current=null] : iv_ruleJsonArray= ruleJsonArray EOF ;
    public final EObject entryRuleJsonArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonArray = null;


        try {
            // InternalAceGen.g:5372:50: (iv_ruleJsonArray= ruleJsonArray EOF )
            // InternalAceGen.g:5373:2: iv_ruleJsonArray= ruleJsonArray EOF
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
    // InternalAceGen.g:5379:1: ruleJsonArray returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleJsonArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5385:2: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' ) )
            // InternalAceGen.g:5386:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' )
            {
            // InternalAceGen.g:5386:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' )
            // InternalAceGen.g:5387:3: () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']'
            {
            // InternalAceGen.g:5387:3: ()
            // InternalAceGen.g:5388:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonArrayAccess().getJsonArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,54,FOLLOW_119); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonArrayAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalAceGen.g:5398:3: ( (lv_values_2_0= ruleJsonValue ) )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( ((LA150_0>=RULE_INT && LA150_0<=RULE_STRING)||LA150_0==35||LA150_0==54||LA150_0==87||LA150_0==105||(LA150_0>=107 && LA150_0<=108)) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // InternalAceGen.g:5399:4: (lv_values_2_0= ruleJsonValue )
                    {
                    // InternalAceGen.g:5399:4: (lv_values_2_0= ruleJsonValue )
                    // InternalAceGen.g:5400:5: lv_values_2_0= ruleJsonValue
                    {

                    					newCompositeNode(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_62);
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

            // InternalAceGen.g:5417:3: (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )*
            loop151:
            do {
                int alt151=2;
                int LA151_0 = input.LA(1);

                if ( (LA151_0==19) ) {
                    alt151=1;
                }


                switch (alt151) {
            	case 1 :
            	    // InternalAceGen.g:5418:4: otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_118); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonArrayAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:5422:4: ( (lv_values_4_0= ruleJsonValue ) )
            	    // InternalAceGen.g:5423:5: (lv_values_4_0= ruleJsonValue )
            	    {
            	    // InternalAceGen.g:5423:5: (lv_values_4_0= ruleJsonValue )
            	    // InternalAceGen.g:5424:6: lv_values_4_0= ruleJsonValue
            	    {

            	    						newCompositeNode(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_62);
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
            	    break loop151;
                }
            } while (true);

            otherlv_5=(Token)match(input,55,FOLLOW_2); 

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


    // $ANTLR start "entryRuleJsonDateTime"
    // InternalAceGen.g:5450:1: entryRuleJsonDateTime returns [EObject current=null] : iv_ruleJsonDateTime= ruleJsonDateTime EOF ;
    public final EObject entryRuleJsonDateTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonDateTime = null;


        try {
            // InternalAceGen.g:5450:53: (iv_ruleJsonDateTime= ruleJsonDateTime EOF )
            // InternalAceGen.g:5451:2: iv_ruleJsonDateTime= ruleJsonDateTime EOF
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
    // InternalAceGen.g:5457:1: ruleJsonDateTime returns [EObject current=null] : ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleJsonDateTime() throws RecognitionException {
        EObject current = null;

        Token lv_dateTime_0_0=null;
        Token lv_pattern_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5463:2: ( ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) ) )
            // InternalAceGen.g:5464:2: ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) )
            {
            // InternalAceGen.g:5464:2: ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) )
            // InternalAceGen.g:5465:3: ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) )
            {
            // InternalAceGen.g:5465:3: ( (lv_dateTime_0_0= RULE_STRING ) )
            // InternalAceGen.g:5466:4: (lv_dateTime_0_0= RULE_STRING )
            {
            // InternalAceGen.g:5466:4: (lv_dateTime_0_0= RULE_STRING )
            // InternalAceGen.g:5467:5: lv_dateTime_0_0= RULE_STRING
            {
            lv_dateTime_0_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

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

            // InternalAceGen.g:5483:3: ( (lv_pattern_1_0= RULE_STRING ) )
            // InternalAceGen.g:5484:4: (lv_pattern_1_0= RULE_STRING )
            {
            // InternalAceGen.g:5484:4: (lv_pattern_1_0= RULE_STRING )
            // InternalAceGen.g:5485:5: lv_pattern_1_0= RULE_STRING
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


    // $ANTLR start "entryRuleStringType"
    // InternalAceGen.g:5505:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // InternalAceGen.g:5505:51: (iv_ruleStringType= ruleStringType EOF )
            // InternalAceGen.g:5506:2: iv_ruleStringType= ruleStringType EOF
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
    // InternalAceGen.g:5512:1: ruleStringType returns [EObject current=null] : ( (lv_string_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringType() throws RecognitionException {
        EObject current = null;

        Token lv_string_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5518:2: ( ( (lv_string_0_0= RULE_STRING ) ) )
            // InternalAceGen.g:5519:2: ( (lv_string_0_0= RULE_STRING ) )
            {
            // InternalAceGen.g:5519:2: ( (lv_string_0_0= RULE_STRING ) )
            // InternalAceGen.g:5520:3: (lv_string_0_0= RULE_STRING )
            {
            // InternalAceGen.g:5520:3: (lv_string_0_0= RULE_STRING )
            // InternalAceGen.g:5521:4: lv_string_0_0= RULE_STRING
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
    // InternalAceGen.g:5540:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // InternalAceGen.g:5540:52: (iv_ruleBooleanType= ruleBooleanType EOF )
            // InternalAceGen.g:5541:2: iv_ruleBooleanType= ruleBooleanType EOF
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
    // InternalAceGen.g:5547:1: ruleBooleanType returns [EObject current=null] : ( (lv_boolean_0_0= ruleJsonBoolean ) ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_boolean_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5553:2: ( ( (lv_boolean_0_0= ruleJsonBoolean ) ) )
            // InternalAceGen.g:5554:2: ( (lv_boolean_0_0= ruleJsonBoolean ) )
            {
            // InternalAceGen.g:5554:2: ( (lv_boolean_0_0= ruleJsonBoolean ) )
            // InternalAceGen.g:5555:3: (lv_boolean_0_0= ruleJsonBoolean )
            {
            // InternalAceGen.g:5555:3: (lv_boolean_0_0= ruleJsonBoolean )
            // InternalAceGen.g:5556:4: lv_boolean_0_0= ruleJsonBoolean
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
    // InternalAceGen.g:5576:1: entryRuleNullType returns [EObject current=null] : iv_ruleNullType= ruleNullType EOF ;
    public final EObject entryRuleNullType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullType = null;


        try {
            // InternalAceGen.g:5576:49: (iv_ruleNullType= ruleNullType EOF )
            // InternalAceGen.g:5577:2: iv_ruleNullType= ruleNullType EOF
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
    // InternalAceGen.g:5583:1: ruleNullType returns [EObject current=null] : ( (lv_null_0_0= 'null' ) ) ;
    public final EObject ruleNullType() throws RecognitionException {
        EObject current = null;

        Token lv_null_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5589:2: ( ( (lv_null_0_0= 'null' ) ) )
            // InternalAceGen.g:5590:2: ( (lv_null_0_0= 'null' ) )
            {
            // InternalAceGen.g:5590:2: ( (lv_null_0_0= 'null' ) )
            // InternalAceGen.g:5591:3: (lv_null_0_0= 'null' )
            {
            // InternalAceGen.g:5591:3: (lv_null_0_0= 'null' )
            // InternalAceGen.g:5592:4: lv_null_0_0= 'null'
            {
            lv_null_0_0=(Token)match(input,87,FOLLOW_2); 

            				newLeafNode(lv_null_0_0, grammarAccess.getNullTypeAccess().getNullNullKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNullTypeRule());
            				}
            				setWithLastConsumed(current, "null", lv_null_0_0 != null, "null");
            			

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


    // $ANTLR start "entryRuleUndefinedType"
    // InternalAceGen.g:5607:1: entryRuleUndefinedType returns [EObject current=null] : iv_ruleUndefinedType= ruleUndefinedType EOF ;
    public final EObject entryRuleUndefinedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUndefinedType = null;


        try {
            // InternalAceGen.g:5607:54: (iv_ruleUndefinedType= ruleUndefinedType EOF )
            // InternalAceGen.g:5608:2: iv_ruleUndefinedType= ruleUndefinedType EOF
            {
             newCompositeNode(grammarAccess.getUndefinedTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUndefinedType=ruleUndefinedType();

            state._fsp--;

             current =iv_ruleUndefinedType; 
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
    // $ANTLR end "entryRuleUndefinedType"


    // $ANTLR start "ruleUndefinedType"
    // InternalAceGen.g:5614:1: ruleUndefinedType returns [EObject current=null] : ( (lv_undefined_0_0= 'undefined' ) ) ;
    public final EObject ruleUndefinedType() throws RecognitionException {
        EObject current = null;

        Token lv_undefined_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5620:2: ( ( (lv_undefined_0_0= 'undefined' ) ) )
            // InternalAceGen.g:5621:2: ( (lv_undefined_0_0= 'undefined' ) )
            {
            // InternalAceGen.g:5621:2: ( (lv_undefined_0_0= 'undefined' ) )
            // InternalAceGen.g:5622:3: (lv_undefined_0_0= 'undefined' )
            {
            // InternalAceGen.g:5622:3: (lv_undefined_0_0= 'undefined' )
            // InternalAceGen.g:5623:4: lv_undefined_0_0= 'undefined'
            {
            lv_undefined_0_0=(Token)match(input,106,FOLLOW_2); 

            				newLeafNode(lv_undefined_0_0, grammarAccess.getUndefinedTypeAccess().getUndefinedUndefinedKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getUndefinedTypeRule());
            				}
            				setWithLastConsumed(current, "undefined", lv_undefined_0_0 != null, "undefined");
            			

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
    // $ANTLR end "ruleUndefinedType"


    // $ANTLR start "entryRuleLongType"
    // InternalAceGen.g:5638:1: entryRuleLongType returns [EObject current=null] : iv_ruleLongType= ruleLongType EOF ;
    public final EObject entryRuleLongType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongType = null;


        try {
            // InternalAceGen.g:5638:49: (iv_ruleLongType= ruleLongType EOF )
            // InternalAceGen.g:5639:2: iv_ruleLongType= ruleLongType EOF
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
    // InternalAceGen.g:5645:1: ruleLongType returns [EObject current=null] : ( (lv_long_0_0= RULE_INT ) ) ;
    public final EObject ruleLongType() throws RecognitionException {
        EObject current = null;

        Token lv_long_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5651:2: ( ( (lv_long_0_0= RULE_INT ) ) )
            // InternalAceGen.g:5652:2: ( (lv_long_0_0= RULE_INT ) )
            {
            // InternalAceGen.g:5652:2: ( (lv_long_0_0= RULE_INT ) )
            // InternalAceGen.g:5653:3: (lv_long_0_0= RULE_INT )
            {
            // InternalAceGen.g:5653:3: (lv_long_0_0= RULE_INT )
            // InternalAceGen.g:5654:4: lv_long_0_0= RULE_INT
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
    // InternalAceGen.g:5673:1: entryRuleJsonBoolean returns [String current=null] : iv_ruleJsonBoolean= ruleJsonBoolean EOF ;
    public final String entryRuleJsonBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleJsonBoolean = null;


        try {
            // InternalAceGen.g:5673:51: (iv_ruleJsonBoolean= ruleJsonBoolean EOF )
            // InternalAceGen.g:5674:2: iv_ruleJsonBoolean= ruleJsonBoolean EOF
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
    // InternalAceGen.g:5680:1: ruleJsonBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleJsonBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:5686:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalAceGen.g:5687:2: (kw= 'true' | kw= 'false' )
            {
            // InternalAceGen.g:5687:2: (kw= 'true' | kw= 'false' )
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==107) ) {
                alt152=1;
            }
            else if ( (LA152_0==108) ) {
                alt152=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 152, 0, input);

                throw nvae;
            }
            switch (alt152) {
                case 1 :
                    // InternalAceGen.g:5688:3: kw= 'true'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJsonBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:5694:3: kw= 'false'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); 

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


    // $ANTLR start "entryRulePrimitiveValue"
    // InternalAceGen.g:5703:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalAceGen.g:5703:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalAceGen.g:5704:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalAceGen.g:5710:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_string_0_0=null;
        Token lv_long_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5716:2: ( ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) ) )
            // InternalAceGen.g:5717:2: ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) )
            {
            // InternalAceGen.g:5717:2: ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) )
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==RULE_STRING) ) {
                alt153=1;
            }
            else if ( (LA153_0==RULE_INT) ) {
                alt153=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 153, 0, input);

                throw nvae;
            }
            switch (alt153) {
                case 1 :
                    // InternalAceGen.g:5718:3: ( (lv_string_0_0= RULE_STRING ) )
                    {
                    // InternalAceGen.g:5718:3: ( (lv_string_0_0= RULE_STRING ) )
                    // InternalAceGen.g:5719:4: (lv_string_0_0= RULE_STRING )
                    {
                    // InternalAceGen.g:5719:4: (lv_string_0_0= RULE_STRING )
                    // InternalAceGen.g:5720:5: lv_string_0_0= RULE_STRING
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
                    // InternalAceGen.g:5737:3: ( (lv_long_1_0= RULE_INT ) )
                    {
                    // InternalAceGen.g:5737:3: ( (lv_long_1_0= RULE_INT ) )
                    // InternalAceGen.g:5738:4: (lv_long_1_0= RULE_INT )
                    {
                    // InternalAceGen.g:5738:4: (lv_long_1_0= RULE_INT )
                    // InternalAceGen.g:5739:5: lv_long_1_0= RULE_INT
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


    protected DFA58 dfa58 = new DFA58(this);
    protected DFA78 dfa78 = new DFA78(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\2\uffff\1\11\7\uffff";
    static final String dfa_3s = "\1\5\1\uffff\1\4\7\uffff";
    static final String dfa_4s = "\1\154\1\uffff\1\67\7\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\1\10\1\7\1\2";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\6\1\2\34\uffff\1\1\22\uffff\1\3\40\uffff\1\5\22\uffff\1\7\2\4",
            "",
            "\1\11\1\uffff\1\10\14\uffff\1\11\21\uffff\1\11\1\uffff\1\11\12\uffff\1\11\4\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2047:2: (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType )";
        }
    }
    static final String dfa_8s = "\11\uffff";
    static final String dfa_9s = "\1\4\1\103\1\4\1\104\1\4\1\136\1\104\2\uffff";
    static final String dfa_10s = "\1\4\1\103\1\4\1\135\1\4\1\141\1\135\2\uffff";
    static final String dfa_11s = "\7\uffff\1\1\1\2";
    static final String dfa_12s = "\11\uffff}>";
    static final String[] dfa_13s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\5\30\uffff\1\4",
            "\1\6",
            "\3\7\1\10",
            "\1\5\30\uffff\1\4",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2498:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x7F00000000000012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000016002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000034012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000180008010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000002E40002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002E00002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002C00002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004040002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000060100000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008100010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000E00000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000003180008010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000002000000040L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000014000000010L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000020008000012L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000020008000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000080000040002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000102000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000E02000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000C02000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000802000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0004000000000012L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0040000800000060L,0x00001C0000800000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000002000080010L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000002000080000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x00C0000800080060L,0x00001C0000800000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0080000000080000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x7E00000000000010L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x7C00000000000010L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x7800000000000010L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x7000000000000010L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x6000000000000010L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x4000000000000010L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x8000000000012002L,0x0000000000000007L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000012002L,0x0000000000000007L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000012002L,0x0000000000000006L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000010012L,0x0000000000000006L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000010012L,0x0000000000001004L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000010012L,0x0000000000002000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x00000001C0000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000002000002L,0x00000000000007E0L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000002000002L,0x00000000000007C0L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000002000002L,0x0000000000000780L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000002000012L,0x0000000000000F00L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000002000012L,0x0000000000000E00L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000002000012L,0x0000000000000C00L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000002000012L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000002L,0x00000000000007A0L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000780L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000F00L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000E00L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000C00L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000002100000010L,0x000001FC0C000800L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000800000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000800080002L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000100060L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000040000000022L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000100800000000L,0x0000020003200000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000002L,0x0000000002200000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0004000000000002L,0x0000000000020400L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0004100800000000L,0x0000020001020000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0004000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000000L,0x00000000001C0000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000800000000L,0x0000020000C00000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000800000002L,0x0000020001000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000800000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000100000010L,0x000001FC08000800L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000100000010L,0x000001FC00000800L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000100000010L,0x000001FC00000000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000000000000010L,0x000001FC00000000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000800000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0040000800000060L,0x00001A0000800000L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x00C0000800080060L,0x00001A0000800000L});

}