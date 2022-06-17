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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'HttpClient'", "'HttpServer'", "'ACE'", "'ui'", "'JSX'", "'scenarios'", "'async'", "'('", "','", "')'", "'fromAppState'", "'call'", "'loadingFlag'", "'as'", "'on'", "'triggers'", "'delayInMillis'", "'takeLatest'", "'set'", "'merge'", "'noComponent'", "'List'", "'Tree'", "'group'", "'listId'", "'location'", "'storage'", "'fromParent'", "'{'", "'options'", "'actions'", "'}'", "'TextInput'", "'CheckBox'", "'Select'", "'PasswordInput'", "'Radio'", "'Button'", "'GIVEN'", "'AND'", "'WHEN'", "'THEN'", "'exclude'", "'squishyValues'", "'uuid'", "'clientSystemTime'", "'serverSystemTime'", "'squishy'", "':'", "'expectedState'", "'verifications'", "'should'", "'not'", "'be'", "'['", "']'", "'Java'", "'C#'", "'Dropwizard'", "'NET6'", "'JDBI3'", "'EntityFramework'", "'Liquibase'", "'Authorization'", "'import'", "'views'", "'models'", "'<'", "'>'", "'authorize'", "'multipartFormData'", "'pathParams'", "'queryParams'", "'payload'", "'response'", "'NotNull'", "'afterCommit'", "'persistent'", "'extends'", "'x'", "'shouldBe'", "'persistence'", "'selectByPrimaryKey'", "'selectBy'", "'filterAndCountBy'", "'extract'", "'notNull'", "'null'", "'systemTime'", "'authorization'", "'Unique'", "'PrimaryKey'", "'references'", "'.'", "'POST'", "'PUT'", "'DELETE'", "'GET'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'Long'", "'FormData'", "'json'", "'undefined'", "'true'", "'false'"
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
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
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

                    if ( (LA2_0==RULE_ID||(LA2_0>=67 && LA2_0<=73)) ) {
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
    // InternalAceGen.g:857:1: ruleClientAttribute returns [EObject current=null] : ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_tree_2_0= 'Tree' ) )? ( (lv_group_3_0= 'group' ) )? ( (lv_listId_4_0= 'listId' ) )? ( (lv_name_5_0= RULE_ID ) ) ( (lv_location_6_0= 'location' ) )? ( (lv_storage_7_0= 'storage' ) )? ( (lv_fromParent_8_0= 'fromParent' ) )? ( (lv_uiElement_9_0= ruleUIElement ) )? (otherlv_10= '{' ( (lv_attributes_11_0= ruleClientAttribute ) )* (otherlv_12= 'options' ( (lv_options_13_0= RULE_STRING ) )* )? (otherlv_14= 'actions' otherlv_15= '{' ( (lv_actions_16_0= ruleUiAction ) )* otherlv_17= '}' )? otherlv_18= '}' )? ) ;
    public final EObject ruleClientAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_noComponent_0_0=null;
        Token lv_list_1_0=null;
        Token lv_tree_2_0=null;
        Token lv_group_3_0=null;
        Token lv_listId_4_0=null;
        Token lv_name_5_0=null;
        Token lv_location_6_0=null;
        Token lv_storage_7_0=null;
        Token lv_fromParent_8_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_options_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_uiElement_9_0 = null;

        EObject lv_attributes_11_0 = null;

        EObject lv_actions_16_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:863:2: ( ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_tree_2_0= 'Tree' ) )? ( (lv_group_3_0= 'group' ) )? ( (lv_listId_4_0= 'listId' ) )? ( (lv_name_5_0= RULE_ID ) ) ( (lv_location_6_0= 'location' ) )? ( (lv_storage_7_0= 'storage' ) )? ( (lv_fromParent_8_0= 'fromParent' ) )? ( (lv_uiElement_9_0= ruleUIElement ) )? (otherlv_10= '{' ( (lv_attributes_11_0= ruleClientAttribute ) )* (otherlv_12= 'options' ( (lv_options_13_0= RULE_STRING ) )* )? (otherlv_14= 'actions' otherlv_15= '{' ( (lv_actions_16_0= ruleUiAction ) )* otherlv_17= '}' )? otherlv_18= '}' )? ) )
            // InternalAceGen.g:864:2: ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_tree_2_0= 'Tree' ) )? ( (lv_group_3_0= 'group' ) )? ( (lv_listId_4_0= 'listId' ) )? ( (lv_name_5_0= RULE_ID ) ) ( (lv_location_6_0= 'location' ) )? ( (lv_storage_7_0= 'storage' ) )? ( (lv_fromParent_8_0= 'fromParent' ) )? ( (lv_uiElement_9_0= ruleUIElement ) )? (otherlv_10= '{' ( (lv_attributes_11_0= ruleClientAttribute ) )* (otherlv_12= 'options' ( (lv_options_13_0= RULE_STRING ) )* )? (otherlv_14= 'actions' otherlv_15= '{' ( (lv_actions_16_0= ruleUiAction ) )* otherlv_17= '}' )? otherlv_18= '}' )? )
            {
            // InternalAceGen.g:864:2: ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_tree_2_0= 'Tree' ) )? ( (lv_group_3_0= 'group' ) )? ( (lv_listId_4_0= 'listId' ) )? ( (lv_name_5_0= RULE_ID ) ) ( (lv_location_6_0= 'location' ) )? ( (lv_storage_7_0= 'storage' ) )? ( (lv_fromParent_8_0= 'fromParent' ) )? ( (lv_uiElement_9_0= ruleUIElement ) )? (otherlv_10= '{' ( (lv_attributes_11_0= ruleClientAttribute ) )* (otherlv_12= 'options' ( (lv_options_13_0= RULE_STRING ) )* )? (otherlv_14= 'actions' otherlv_15= '{' ( (lv_actions_16_0= ruleUiAction ) )* otherlv_17= '}' )? otherlv_18= '}' )? )
            // InternalAceGen.g:865:3: ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_tree_2_0= 'Tree' ) )? ( (lv_group_3_0= 'group' ) )? ( (lv_listId_4_0= 'listId' ) )? ( (lv_name_5_0= RULE_ID ) ) ( (lv_location_6_0= 'location' ) )? ( (lv_storage_7_0= 'storage' ) )? ( (lv_fromParent_8_0= 'fromParent' ) )? ( (lv_uiElement_9_0= ruleUIElement ) )? (otherlv_10= '{' ( (lv_attributes_11_0= ruleClientAttribute ) )* (otherlv_12= 'options' ( (lv_options_13_0= RULE_STRING ) )* )? (otherlv_14= 'actions' otherlv_15= '{' ( (lv_actions_16_0= ruleUiAction ) )* otherlv_17= '}' )? otherlv_18= '}' )?
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
                    lv_list_1_0=(Token)match(input,32,FOLLOW_25); 

                    					newLeafNode(lv_list_1_0, grammarAccess.getClientAttributeAccess().getListListKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "list", lv_list_1_0 != null, "List");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:893:3: ( (lv_tree_2_0= 'Tree' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAceGen.g:894:4: (lv_tree_2_0= 'Tree' )
                    {
                    // InternalAceGen.g:894:4: (lv_tree_2_0= 'Tree' )
                    // InternalAceGen.g:895:5: lv_tree_2_0= 'Tree'
                    {
                    lv_tree_2_0=(Token)match(input,33,FOLLOW_26); 

                    					newLeafNode(lv_tree_2_0, grammarAccess.getClientAttributeAccess().getTreeTreeKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "tree", lv_tree_2_0 != null, "Tree");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:907:3: ( (lv_group_3_0= 'group' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAceGen.g:908:4: (lv_group_3_0= 'group' )
                    {
                    // InternalAceGen.g:908:4: (lv_group_3_0= 'group' )
                    // InternalAceGen.g:909:5: lv_group_3_0= 'group'
                    {
                    lv_group_3_0=(Token)match(input,34,FOLLOW_27); 

                    					newLeafNode(lv_group_3_0, grammarAccess.getClientAttributeAccess().getGroupGroupKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "group", lv_group_3_0 != null, "group");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:921:3: ( (lv_listId_4_0= 'listId' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==35) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalAceGen.g:922:4: (lv_listId_4_0= 'listId' )
                    {
                    // InternalAceGen.g:922:4: (lv_listId_4_0= 'listId' )
                    // InternalAceGen.g:923:5: lv_listId_4_0= 'listId'
                    {
                    lv_listId_4_0=(Token)match(input,35,FOLLOW_9); 

                    					newLeafNode(lv_listId_4_0, grammarAccess.getClientAttributeAccess().getListIdListIdKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "listId", lv_listId_4_0 != null, "listId");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:935:3: ( (lv_name_5_0= RULE_ID ) )
            // InternalAceGen.g:936:4: (lv_name_5_0= RULE_ID )
            {
            // InternalAceGen.g:936:4: (lv_name_5_0= RULE_ID )
            // InternalAceGen.g:937:5: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_name_5_0, grammarAccess.getClientAttributeAccess().getNameIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClientAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:953:3: ( (lv_location_6_0= 'location' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==36) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalAceGen.g:954:4: (lv_location_6_0= 'location' )
                    {
                    // InternalAceGen.g:954:4: (lv_location_6_0= 'location' )
                    // InternalAceGen.g:955:5: lv_location_6_0= 'location'
                    {
                    lv_location_6_0=(Token)match(input,36,FOLLOW_29); 

                    					newLeafNode(lv_location_6_0, grammarAccess.getClientAttributeAccess().getLocationLocationKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "location", lv_location_6_0 != null, "location");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:967:3: ( (lv_storage_7_0= 'storage' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==37) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAceGen.g:968:4: (lv_storage_7_0= 'storage' )
                    {
                    // InternalAceGen.g:968:4: (lv_storage_7_0= 'storage' )
                    // InternalAceGen.g:969:5: lv_storage_7_0= 'storage'
                    {
                    lv_storage_7_0=(Token)match(input,37,FOLLOW_30); 

                    					newLeafNode(lv_storage_7_0, grammarAccess.getClientAttributeAccess().getStorageStorageKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "storage", lv_storage_7_0 != null, "storage");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:981:3: ( (lv_fromParent_8_0= 'fromParent' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==38) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalAceGen.g:982:4: (lv_fromParent_8_0= 'fromParent' )
                    {
                    // InternalAceGen.g:982:4: (lv_fromParent_8_0= 'fromParent' )
                    // InternalAceGen.g:983:5: lv_fromParent_8_0= 'fromParent'
                    {
                    lv_fromParent_8_0=(Token)match(input,38,FOLLOW_31); 

                    					newLeafNode(lv_fromParent_8_0, grammarAccess.getClientAttributeAccess().getFromParentFromParentKeyword_8_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "fromParent", lv_fromParent_8_0 != null, "fromParent");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:995:3: ( (lv_uiElement_9_0= ruleUIElement ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=43 && LA34_0<=48)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAceGen.g:996:4: (lv_uiElement_9_0= ruleUIElement )
                    {
                    // InternalAceGen.g:996:4: (lv_uiElement_9_0= ruleUIElement )
                    // InternalAceGen.g:997:5: lv_uiElement_9_0= ruleUIElement
                    {

                    					newCompositeNode(grammarAccess.getClientAttributeAccess().getUiElementUIElementParserRuleCall_9_0());
                    				
                    pushFollow(FOLLOW_32);
                    lv_uiElement_9_0=ruleUIElement();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getClientAttributeRule());
                    					}
                    					set(
                    						current,
                    						"uiElement",
                    						lv_uiElement_9_0,
                    						"de.acegen.AceGen.UIElement");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1014:3: (otherlv_10= '{' ( (lv_attributes_11_0= ruleClientAttribute ) )* (otherlv_12= 'options' ( (lv_options_13_0= RULE_STRING ) )* )? (otherlv_14= 'actions' otherlv_15= '{' ( (lv_actions_16_0= ruleUiAction ) )* otherlv_17= '}' )? otherlv_18= '}' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==39) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalAceGen.g:1015:4: otherlv_10= '{' ( (lv_attributes_11_0= ruleClientAttribute ) )* (otherlv_12= 'options' ( (lv_options_13_0= RULE_STRING ) )* )? (otherlv_14= 'actions' otherlv_15= '{' ( (lv_actions_16_0= ruleUiAction ) )* otherlv_17= '}' )? otherlv_18= '}'
                    {
                    otherlv_10=(Token)match(input,39,FOLLOW_33); 

                    				newLeafNode(otherlv_10, grammarAccess.getClientAttributeAccess().getLeftCurlyBracketKeyword_10_0());
                    			
                    // InternalAceGen.g:1019:4: ( (lv_attributes_11_0= ruleClientAttribute ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==RULE_ID||(LA35_0>=31 && LA35_0<=35)) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalAceGen.g:1020:5: (lv_attributes_11_0= ruleClientAttribute )
                    	    {
                    	    // InternalAceGen.g:1020:5: (lv_attributes_11_0= ruleClientAttribute )
                    	    // InternalAceGen.g:1021:6: lv_attributes_11_0= ruleClientAttribute
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientAttributeAccess().getAttributesClientAttributeParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_33);
                    	    lv_attributes_11_0=ruleClientAttribute();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getClientAttributeRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"attributes",
                    	    							lv_attributes_11_0,
                    	    							"de.acegen.AceGen.ClientAttribute");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);

                    // InternalAceGen.g:1038:4: (otherlv_12= 'options' ( (lv_options_13_0= RULE_STRING ) )* )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==40) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalAceGen.g:1039:5: otherlv_12= 'options' ( (lv_options_13_0= RULE_STRING ) )*
                            {
                            otherlv_12=(Token)match(input,40,FOLLOW_34); 

                            					newLeafNode(otherlv_12, grammarAccess.getClientAttributeAccess().getOptionsKeyword_10_2_0());
                            				
                            // InternalAceGen.g:1043:5: ( (lv_options_13_0= RULE_STRING ) )*
                            loop36:
                            do {
                                int alt36=2;
                                int LA36_0 = input.LA(1);

                                if ( (LA36_0==RULE_STRING) ) {
                                    alt36=1;
                                }


                                switch (alt36) {
                            	case 1 :
                            	    // InternalAceGen.g:1044:6: (lv_options_13_0= RULE_STRING )
                            	    {
                            	    // InternalAceGen.g:1044:6: (lv_options_13_0= RULE_STRING )
                            	    // InternalAceGen.g:1045:7: lv_options_13_0= RULE_STRING
                            	    {
                            	    lv_options_13_0=(Token)match(input,RULE_STRING,FOLLOW_34); 

                            	    							newLeafNode(lv_options_13_0, grammarAccess.getClientAttributeAccess().getOptionsSTRINGTerminalRuleCall_10_2_1_0());
                            	    						

                            	    							if (current==null) {
                            	    								current = createModelElement(grammarAccess.getClientAttributeRule());
                            	    							}
                            	    							addWithLastConsumed(
                            	    								current,
                            	    								"options",
                            	    								lv_options_13_0,
                            	    								"org.eclipse.xtext.common.Terminals.STRING");
                            	    						

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop36;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // InternalAceGen.g:1062:4: (otherlv_14= 'actions' otherlv_15= '{' ( (lv_actions_16_0= ruleUiAction ) )* otherlv_17= '}' )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==41) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalAceGen.g:1063:5: otherlv_14= 'actions' otherlv_15= '{' ( (lv_actions_16_0= ruleUiAction ) )* otherlv_17= '}'
                            {
                            otherlv_14=(Token)match(input,41,FOLLOW_35); 

                            					newLeafNode(otherlv_14, grammarAccess.getClientAttributeAccess().getActionsKeyword_10_3_0());
                            				
                            otherlv_15=(Token)match(input,39,FOLLOW_36); 

                            					newLeafNode(otherlv_15, grammarAccess.getClientAttributeAccess().getLeftCurlyBracketKeyword_10_3_1());
                            				
                            // InternalAceGen.g:1071:5: ( (lv_actions_16_0= ruleUiAction ) )*
                            loop38:
                            do {
                                int alt38=2;
                                int LA38_0 = input.LA(1);

                                if ( (LA38_0==RULE_STRING) ) {
                                    alt38=1;
                                }


                                switch (alt38) {
                            	case 1 :
                            	    // InternalAceGen.g:1072:6: (lv_actions_16_0= ruleUiAction )
                            	    {
                            	    // InternalAceGen.g:1072:6: (lv_actions_16_0= ruleUiAction )
                            	    // InternalAceGen.g:1073:7: lv_actions_16_0= ruleUiAction
                            	    {

                            	    							newCompositeNode(grammarAccess.getClientAttributeAccess().getActionsUiActionParserRuleCall_10_3_2_0());
                            	    						
                            	    pushFollow(FOLLOW_36);
                            	    lv_actions_16_0=ruleUiAction();

                            	    state._fsp--;


                            	    							if (current==null) {
                            	    								current = createModelElementForParent(grammarAccess.getClientAttributeRule());
                            	    							}
                            	    							add(
                            	    								current,
                            	    								"actions",
                            	    								lv_actions_16_0,
                            	    								"de.acegen.AceGen.UiAction");
                            	    							afterParserOrEnumRuleCall();
                            	    						

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop38;
                                }
                            } while (true);

                            otherlv_17=(Token)match(input,42,FOLLOW_37); 

                            					newLeafNode(otherlv_17, grammarAccess.getClientAttributeAccess().getRightCurlyBracketKeyword_10_3_3());
                            				

                            }
                            break;

                    }

                    otherlv_18=(Token)match(input,42,FOLLOW_2); 

                    				newLeafNode(otherlv_18, grammarAccess.getClientAttributeAccess().getRightCurlyBracketKeyword_10_4());
                    			

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
    // InternalAceGen.g:1104:1: entryRuleUiAction returns [EObject current=null] : iv_ruleUiAction= ruleUiAction EOF ;
    public final EObject entryRuleUiAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUiAction = null;


        try {
            // InternalAceGen.g:1104:49: (iv_ruleUiAction= ruleUiAction EOF )
            // InternalAceGen.g:1105:2: iv_ruleUiAction= ruleUiAction EOF
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
    // InternalAceGen.g:1111:1: ruleUiAction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleUiAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:1117:2: ( ( ( (lv_name_0_0= RULE_STRING ) ) ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:1118:2: ( ( (lv_name_0_0= RULE_STRING ) ) ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:1118:2: ( ( (lv_name_0_0= RULE_STRING ) ) ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:1119:3: ( (lv_name_0_0= RULE_STRING ) ) ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:1119:3: ( (lv_name_0_0= RULE_STRING ) )
            // InternalAceGen.g:1120:4: (lv_name_0_0= RULE_STRING )
            {
            // InternalAceGen.g:1120:4: (lv_name_0_0= RULE_STRING )
            // InternalAceGen.g:1121:5: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_name_0_0, grammarAccess.getUiActionAccess().getNameSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUiActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalAceGen.g:1137:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1138:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1138:4: ( ruleQualifiedName )
            // InternalAceGen.g:1139:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUiActionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUiActionAccess().getTargetHttpClientAceCrossReference_1_0());
            				
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
    // $ANTLR end "ruleUiAction"


    // $ANTLR start "entryRuleUIElement"
    // InternalAceGen.g:1157:1: entryRuleUIElement returns [String current=null] : iv_ruleUIElement= ruleUIElement EOF ;
    public final String entryRuleUIElement() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUIElement = null;


        try {
            // InternalAceGen.g:1157:49: (iv_ruleUIElement= ruleUIElement EOF )
            // InternalAceGen.g:1158:2: iv_ruleUIElement= ruleUIElement EOF
            {
             newCompositeNode(grammarAccess.getUIElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUIElement=ruleUIElement();

            state._fsp--;

             current =iv_ruleUIElement.getText(); 
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
    // $ANTLR end "entryRuleUIElement"


    // $ANTLR start "ruleUIElement"
    // InternalAceGen.g:1164:1: ruleUIElement returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'TextInput' | kw= 'CheckBox' | kw= 'Select' | kw= 'PasswordInput' | kw= 'Radio' | kw= 'Button' ) ;
    public final AntlrDatatypeRuleToken ruleUIElement() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:1170:2: ( (kw= 'TextInput' | kw= 'CheckBox' | kw= 'Select' | kw= 'PasswordInput' | kw= 'Radio' | kw= 'Button' ) )
            // InternalAceGen.g:1171:2: (kw= 'TextInput' | kw= 'CheckBox' | kw= 'Select' | kw= 'PasswordInput' | kw= 'Radio' | kw= 'Button' )
            {
            // InternalAceGen.g:1171:2: (kw= 'TextInput' | kw= 'CheckBox' | kw= 'Select' | kw= 'PasswordInput' | kw= 'Radio' | kw= 'Button' )
            int alt41=6;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt41=1;
                }
                break;
            case 44:
                {
                alt41=2;
                }
                break;
            case 45:
                {
                alt41=3;
                }
                break;
            case 46:
                {
                alt41=4;
                }
                break;
            case 47:
                {
                alt41=5;
                }
                break;
            case 48:
                {
                alt41=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalAceGen.g:1172:3: kw= 'TextInput'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUIElementAccess().getTextInputKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:1178:3: kw= 'CheckBox'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUIElementAccess().getCheckBoxKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:1184:3: kw= 'Select'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUIElementAccess().getSelectKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAceGen.g:1190:3: kw= 'PasswordInput'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUIElementAccess().getPasswordInputKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalAceGen.g:1196:3: kw= 'Radio'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUIElementAccess().getRadioKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalAceGen.g:1202:3: kw= 'Button'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUIElementAccess().getButtonKeyword_5());
                    		

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
    // $ANTLR end "ruleUIElement"


    // $ANTLR start "entryRuleClientScenario"
    // InternalAceGen.g:1211:1: entryRuleClientScenario returns [EObject current=null] : iv_ruleClientScenario= ruleClientScenario EOF ;
    public final EObject entryRuleClientScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientScenario = null;


        try {
            // InternalAceGen.g:1211:55: (iv_ruleClientScenario= ruleClientScenario EOF )
            // InternalAceGen.g:1212:2: iv_ruleClientScenario= ruleClientScenario EOF
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
    // InternalAceGen.g:1218:1: ruleClientScenario returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) ) (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )* ) ;
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
            // InternalAceGen.g:1224:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) ) (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )* ) )
            // InternalAceGen.g:1225:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) ) (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )* )
            {
            // InternalAceGen.g:1225:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) ) (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )* )
            // InternalAceGen.g:1226:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) ) (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )*
            {
            // InternalAceGen.g:1226:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1227:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1227:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1228:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_38); 

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

            // InternalAceGen.g:1244:3: (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==49) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalAceGen.g:1245:4: otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )*
                    {
                    otherlv_1=(Token)match(input,49,FOLLOW_39); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientScenarioAccess().getGIVENKeyword_1_0());
                    			
                    // InternalAceGen.g:1249:4: ( (lv_givenRefs_2_0= ruleClientGivenRef ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==RULE_ID) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalAceGen.g:1250:5: (lv_givenRefs_2_0= ruleClientGivenRef )
                    	    {
                    	    // InternalAceGen.g:1250:5: (lv_givenRefs_2_0= ruleClientGivenRef )
                    	    // InternalAceGen.g:1251:6: lv_givenRefs_2_0= ruleClientGivenRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientScenarioAccess().getGivenRefsClientGivenRefParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_39);
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
                    	    break loop42;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1269:3: ( (lv_clientWhenThen_3_0= ruleClientWhenThen ) )
            // InternalAceGen.g:1270:4: (lv_clientWhenThen_3_0= ruleClientWhenThen )
            {
            // InternalAceGen.g:1270:4: (lv_clientWhenThen_3_0= ruleClientWhenThen )
            // InternalAceGen.g:1271:5: lv_clientWhenThen_3_0= ruleClientWhenThen
            {

            					newCompositeNode(grammarAccess.getClientScenarioAccess().getClientWhenThenClientWhenThenParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_40);
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

            // InternalAceGen.g:1288:3: (otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==50) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalAceGen.g:1289:4: otherlv_4= 'AND' ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) )
            	    {
            	    otherlv_4=(Token)match(input,50,FOLLOW_38); 

            	    				newLeafNode(otherlv_4, grammarAccess.getClientScenarioAccess().getANDKeyword_3_0());
            	    			
            	    // InternalAceGen.g:1293:4: ( (lv_clientWhenThen_5_0= ruleClientWhenThen ) )
            	    // InternalAceGen.g:1294:5: (lv_clientWhenThen_5_0= ruleClientWhenThen )
            	    {
            	    // InternalAceGen.g:1294:5: (lv_clientWhenThen_5_0= ruleClientWhenThen )
            	    // InternalAceGen.g:1295:6: lv_clientWhenThen_5_0= ruleClientWhenThen
            	    {

            	    						newCompositeNode(grammarAccess.getClientScenarioAccess().getClientWhenThenClientWhenThenParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_40);
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
            	    break loop44;
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
    // InternalAceGen.g:1317:1: entryRuleClientWhenThen returns [EObject current=null] : iv_ruleClientWhenThen= ruleClientWhenThen EOF ;
    public final EObject entryRuleClientWhenThen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientWhenThen = null;


        try {
            // InternalAceGen.g:1317:55: (iv_ruleClientWhenThen= ruleClientWhenThen EOF )
            // InternalAceGen.g:1318:2: iv_ruleClientWhenThen= ruleClientWhenThen EOF
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
    // InternalAceGen.g:1324:1: ruleClientWhenThen returns [EObject current=null] : ( () otherlv_1= 'WHEN' ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )? (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )? (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )? ) ;
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
            // InternalAceGen.g:1330:2: ( ( () otherlv_1= 'WHEN' ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )? (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )? (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )? ) )
            // InternalAceGen.g:1331:2: ( () otherlv_1= 'WHEN' ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )? (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )? (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )? )
            {
            // InternalAceGen.g:1331:2: ( () otherlv_1= 'WHEN' ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )? (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )? (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )? )
            // InternalAceGen.g:1332:3: () otherlv_1= 'WHEN' ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )? (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )? (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )?
            {
            // InternalAceGen.g:1332:3: ()
            // InternalAceGen.g:1333:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClientWhenThenAccess().getClientWhenThenAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,51,FOLLOW_41); 

            			newLeafNode(otherlv_1, grammarAccess.getClientWhenThenAccess().getWHENKeyword_1());
            		
            // InternalAceGen.g:1343:3: ( (lv_whenBlock_2_0= ruleClientWhenBlock ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==EOF||LA45_1==RULE_ID||LA45_1==18||LA45_1==27||LA45_1==50||LA45_1==52||LA45_1==54||LA45_1==104) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // InternalAceGen.g:1344:4: (lv_whenBlock_2_0= ruleClientWhenBlock )
                    {
                    // InternalAceGen.g:1344:4: (lv_whenBlock_2_0= ruleClientWhenBlock )
                    // InternalAceGen.g:1345:5: lv_whenBlock_2_0= ruleClientWhenBlock
                    {

                    					newCompositeNode(grammarAccess.getClientWhenThenAccess().getWhenBlockClientWhenBlockParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_42);
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

            // InternalAceGen.g:1362:3: (otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==27) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalAceGen.g:1363:4: otherlv_3= 'delayInMillis' ( (lv_delayInMillis_4_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_22); 

                    				newLeafNode(otherlv_3, grammarAccess.getClientWhenThenAccess().getDelayInMillisKeyword_3_0());
                    			
                    // InternalAceGen.g:1367:4: ( (lv_delayInMillis_4_0= RULE_INT ) )
                    // InternalAceGen.g:1368:5: (lv_delayInMillis_4_0= RULE_INT )
                    {
                    // InternalAceGen.g:1368:5: (lv_delayInMillis_4_0= RULE_INT )
                    // InternalAceGen.g:1369:6: lv_delayInMillis_4_0= RULE_INT
                    {
                    lv_delayInMillis_4_0=(Token)match(input,RULE_INT,FOLLOW_43); 

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

            // InternalAceGen.g:1386:3: (otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==52) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalAceGen.g:1387:4: otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleClientThenBlock ) )
                    {
                    otherlv_5=(Token)match(input,52,FOLLOW_44); 

                    				newLeafNode(otherlv_5, grammarAccess.getClientWhenThenAccess().getTHENKeyword_4_0());
                    			
                    // InternalAceGen.g:1391:4: ( (lv_thenBlock_6_0= ruleClientThenBlock ) )
                    // InternalAceGen.g:1392:5: (lv_thenBlock_6_0= ruleClientThenBlock )
                    {
                    // InternalAceGen.g:1392:5: (lv_thenBlock_6_0= ruleClientThenBlock )
                    // InternalAceGen.g:1393:6: lv_thenBlock_6_0= ruleClientThenBlock
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
    // InternalAceGen.g:1415:1: entryRuleClientGivenRef returns [EObject current=null] : iv_ruleClientGivenRef= ruleClientGivenRef EOF ;
    public final EObject entryRuleClientGivenRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientGivenRef = null;


        try {
            // InternalAceGen.g:1415:55: (iv_ruleClientGivenRef= ruleClientGivenRef EOF )
            // InternalAceGen.g:1416:2: iv_ruleClientGivenRef= ruleClientGivenRef EOF
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
    // InternalAceGen.g:1422:1: ruleClientGivenRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )? ) ;
    public final EObject ruleClientGivenRef() throws RecognitionException {
        EObject current = null;

        Token lv_excludeGiven_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalAceGen.g:1428:2: ( ( ( ( ruleQualifiedName ) ) ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )? ) )
            // InternalAceGen.g:1429:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )? )
            {
            // InternalAceGen.g:1429:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )? )
            // InternalAceGen.g:1430:3: ( ( ruleQualifiedName ) ) ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )?
            {
            // InternalAceGen.g:1430:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1431:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1431:4: ( ruleQualifiedName )
            // InternalAceGen.g:1432:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClientGivenRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClientGivenRefAccess().getScenarioClientScenarioCrossReference_0_0());
            				
            pushFollow(FOLLOW_45);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1446:3: ( ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==53) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalAceGen.g:1447:4: ( (lv_excludeGiven_1_0= 'exclude' ) ) otherlv_2= 'GIVEN'
                    {
                    // InternalAceGen.g:1447:4: ( (lv_excludeGiven_1_0= 'exclude' ) )
                    // InternalAceGen.g:1448:5: (lv_excludeGiven_1_0= 'exclude' )
                    {
                    // InternalAceGen.g:1448:5: (lv_excludeGiven_1_0= 'exclude' )
                    // InternalAceGen.g:1449:6: lv_excludeGiven_1_0= 'exclude'
                    {
                    lv_excludeGiven_1_0=(Token)match(input,53,FOLLOW_46); 

                    						newLeafNode(lv_excludeGiven_1_0, grammarAccess.getClientGivenRefAccess().getExcludeGivenExcludeKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClientGivenRefRule());
                    						}
                    						setWithLastConsumed(current, "excludeGiven", lv_excludeGiven_1_0 != null, "exclude");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,49,FOLLOW_2); 

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
    // InternalAceGen.g:1470:1: entryRuleClientWhenBlock returns [EObject current=null] : iv_ruleClientWhenBlock= ruleClientWhenBlock EOF ;
    public final EObject entryRuleClientWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientWhenBlock = null;


        try {
            // InternalAceGen.g:1470:56: (iv_ruleClientWhenBlock= ruleClientWhenBlock EOF )
            // InternalAceGen.g:1471:2: iv_ruleClientWhenBlock= ruleClientWhenBlock EOF
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
    // InternalAceGen.g:1477:1: ruleClientWhenBlock returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )? ) ;
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
            // InternalAceGen.g:1483:2: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )? ) )
            // InternalAceGen.g:1484:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )? )
            {
            // InternalAceGen.g:1484:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )? )
            // InternalAceGen.g:1485:3: ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )?
            {
            // InternalAceGen.g:1485:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1486:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1486:4: ( ruleQualifiedName )
            // InternalAceGen.g:1487:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClientWhenBlockRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClientWhenBlockAccess().getActionHttpClientAceCrossReference_0_0());
            				
            pushFollow(FOLLOW_47);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1501:3: (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==18) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalAceGen.g:1502:4: otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_48); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientWhenBlockAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalAceGen.g:1506:4: ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==RULE_ID) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalAceGen.g:1507:5: ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )*
                            {
                            // InternalAceGen.g:1507:5: ( (lv_inputValues_2_0= ruleInputValue ) )
                            // InternalAceGen.g:1508:6: (lv_inputValues_2_0= ruleInputValue )
                            {
                            // InternalAceGen.g:1508:6: (lv_inputValues_2_0= ruleInputValue )
                            // InternalAceGen.g:1509:7: lv_inputValues_2_0= ruleInputValue
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

                            // InternalAceGen.g:1526:5: (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )*
                            loop49:
                            do {
                                int alt49=2;
                                int LA49_0 = input.LA(1);

                                if ( (LA49_0==19) ) {
                                    alt49=1;
                                }


                                switch (alt49) {
                            	case 1 :
                            	    // InternalAceGen.g:1527:6: otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) )
                            	    {
                            	    otherlv_3=(Token)match(input,19,FOLLOW_9); 

                            	    						newLeafNode(otherlv_3, grammarAccess.getClientWhenBlockAccess().getCommaKeyword_1_1_1_0());
                            	    					
                            	    // InternalAceGen.g:1531:6: ( (lv_inputValues_4_0= ruleInputValue ) )
                            	    // InternalAceGen.g:1532:7: (lv_inputValues_4_0= ruleInputValue )
                            	    {
                            	    // InternalAceGen.g:1532:7: (lv_inputValues_4_0= ruleInputValue )
                            	    // InternalAceGen.g:1533:8: lv_inputValues_4_0= ruleInputValue
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
                            	    break loop49;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_49); 

                    				newLeafNode(otherlv_5, grammarAccess.getClientWhenBlockAccess().getRightParenthesisKeyword_1_2());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:1557:3: (otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==54) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalAceGen.g:1558:4: otherlv_6= 'squishyValues' ( (lv_squishyValues_7_0= ruleSquishyValue ) ) (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )*
                    {
                    otherlv_6=(Token)match(input,54,FOLLOW_35); 

                    				newLeafNode(otherlv_6, grammarAccess.getClientWhenBlockAccess().getSquishyValuesKeyword_2_0());
                    			
                    // InternalAceGen.g:1562:4: ( (lv_squishyValues_7_0= ruleSquishyValue ) )
                    // InternalAceGen.g:1563:5: (lv_squishyValues_7_0= ruleSquishyValue )
                    {
                    // InternalAceGen.g:1563:5: (lv_squishyValues_7_0= ruleSquishyValue )
                    // InternalAceGen.g:1564:6: lv_squishyValues_7_0= ruleSquishyValue
                    {

                    						newCompositeNode(grammarAccess.getClientWhenBlockAccess().getSquishyValuesSquishyValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_50);
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

                    // InternalAceGen.g:1581:4: (otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==19) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // InternalAceGen.g:1582:5: otherlv_8= ',' ( (lv_squishyValues_9_0= ruleSquishyValue ) )
                    	    {
                    	    otherlv_8=(Token)match(input,19,FOLLOW_35); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getClientWhenBlockAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:1586:5: ( (lv_squishyValues_9_0= ruleSquishyValue ) )
                    	    // InternalAceGen.g:1587:6: (lv_squishyValues_9_0= ruleSquishyValue )
                    	    {
                    	    // InternalAceGen.g:1587:6: (lv_squishyValues_9_0= ruleSquishyValue )
                    	    // InternalAceGen.g:1588:7: lv_squishyValues_9_0= ruleSquishyValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getClientWhenBlockAccess().getSquishyValuesSquishyValueParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_50);
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
    // $ANTLR end "ruleClientWhenBlock"


    // $ANTLR start "entryRuleSquishyValue"
    // InternalAceGen.g:1611:1: entryRuleSquishyValue returns [EObject current=null] : iv_ruleSquishyValue= ruleSquishyValue EOF ;
    public final EObject entryRuleSquishyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquishyValue = null;


        try {
            // InternalAceGen.g:1611:53: (iv_ruleSquishyValue= ruleSquishyValue EOF )
            // InternalAceGen.g:1612:2: iv_ruleSquishyValue= ruleSquishyValue EOF
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
    // InternalAceGen.g:1618:1: ruleSquishyValue returns [EObject current=null] : ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' ) ;
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
            // InternalAceGen.g:1624:2: ( ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' ) )
            // InternalAceGen.g:1625:2: ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' )
            {
            // InternalAceGen.g:1625:2: ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' )
            // InternalAceGen.g:1626:3: () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}'
            {
            // InternalAceGen.g:1626:3: ()
            // InternalAceGen.g:1627:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSquishyValueAccess().getSquishyValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,39,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getSquishyValueAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:1637:3: (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==55) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalAceGen.g:1638:4: otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )?
                    {
                    otherlv_2=(Token)match(input,55,FOLLOW_52); 

                    				newLeafNode(otherlv_2, grammarAccess.getSquishyValueAccess().getUuidKeyword_2_0());
                    			
                    // InternalAceGen.g:1642:4: ( (lv_uuid_3_0= RULE_STRING ) )
                    // InternalAceGen.g:1643:5: (lv_uuid_3_0= RULE_STRING )
                    {
                    // InternalAceGen.g:1643:5: (lv_uuid_3_0= RULE_STRING )
                    // InternalAceGen.g:1644:6: lv_uuid_3_0= RULE_STRING
                    {
                    lv_uuid_3_0=(Token)match(input,RULE_STRING,FOLLOW_53); 

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

                    // InternalAceGen.g:1660:4: (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==56) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // InternalAceGen.g:1661:5: otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) )
                            {
                            otherlv_4=(Token)match(input,56,FOLLOW_52); 

                            					newLeafNode(otherlv_4, grammarAccess.getSquishyValueAccess().getClientSystemTimeKeyword_2_2_0());
                            				
                            // InternalAceGen.g:1665:5: ( (lv_clientSystemTime_5_0= RULE_STRING ) )
                            // InternalAceGen.g:1666:6: (lv_clientSystemTime_5_0= RULE_STRING )
                            {
                            // InternalAceGen.g:1666:6: (lv_clientSystemTime_5_0= RULE_STRING )
                            // InternalAceGen.g:1667:7: lv_clientSystemTime_5_0= RULE_STRING
                            {
                            lv_clientSystemTime_5_0=(Token)match(input,RULE_STRING,FOLLOW_54); 

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

                    // InternalAceGen.g:1684:4: (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==57) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // InternalAceGen.g:1685:5: otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) )
                            {
                            otherlv_6=(Token)match(input,57,FOLLOW_52); 

                            					newLeafNode(otherlv_6, grammarAccess.getSquishyValueAccess().getServerSystemTimeKeyword_2_3_0());
                            				
                            // InternalAceGen.g:1689:5: ( (lv_serverSystemTime_7_0= RULE_STRING ) )
                            // InternalAceGen.g:1690:6: (lv_serverSystemTime_7_0= RULE_STRING )
                            {
                            // InternalAceGen.g:1690:6: (lv_serverSystemTime_7_0= RULE_STRING )
                            // InternalAceGen.g:1691:7: lv_serverSystemTime_7_0= RULE_STRING
                            {
                            lv_serverSystemTime_7_0=(Token)match(input,RULE_STRING,FOLLOW_55); 

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

                    // InternalAceGen.g:1708:4: (otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==58) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // InternalAceGen.g:1709:5: otherlv_8= 'squishy' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) )
                            {
                            otherlv_8=(Token)match(input,58,FOLLOW_9); 

                            					newLeafNode(otherlv_8, grammarAccess.getSquishyValueAccess().getSquishyKeyword_2_4_0());
                            				
                            // InternalAceGen.g:1713:5: ( ( ruleQualifiedName ) )
                            // InternalAceGen.g:1714:6: ( ruleQualifiedName )
                            {
                            // InternalAceGen.g:1714:6: ( ruleQualifiedName )
                            // InternalAceGen.g:1715:7: ruleQualifiedName
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSquishyValueRule());
                            							}
                            						

                            							newCompositeNode(grammarAccess.getSquishyValueAccess().getAttributeAttributeCrossReference_2_4_1_0());
                            						
                            pushFollow(FOLLOW_56);
                            ruleQualifiedName();

                            state._fsp--;


                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_10=(Token)match(input,59,FOLLOW_57); 

                            					newLeafNode(otherlv_10, grammarAccess.getSquishyValueAccess().getColonKeyword_2_4_2());
                            				
                            // InternalAceGen.g:1733:5: ( (lv_value_11_0= rulePrimitiveValue ) )
                            // InternalAceGen.g:1734:6: (lv_value_11_0= rulePrimitiveValue )
                            {
                            // InternalAceGen.g:1734:6: (lv_value_11_0= rulePrimitiveValue )
                            // InternalAceGen.g:1735:7: lv_value_11_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getSquishyValueAccess().getValuePrimitiveValueParserRuleCall_2_4_3_0());
                            						
                            pushFollow(FOLLOW_37);
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

            otherlv_12=(Token)match(input,42,FOLLOW_2); 

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
    // InternalAceGen.g:1762:1: entryRuleInputValue returns [EObject current=null] : iv_ruleInputValue= ruleInputValue EOF ;
    public final EObject entryRuleInputValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputValue = null;


        try {
            // InternalAceGen.g:1762:51: (iv_ruleInputValue= ruleInputValue EOF )
            // InternalAceGen.g:1763:2: iv_ruleInputValue= ruleInputValue EOF
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
    // InternalAceGen.g:1769:1: ruleInputValue returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject ruleInputValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1775:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalAceGen.g:1776:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalAceGen.g:1776:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalAceGen.g:1777:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalAceGen.g:1777:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1778:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1778:4: ( ruleQualifiedName )
            // InternalAceGen.g:1779:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInputValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInputValueAccess().getInputInputCrossReference_0_0());
            				
            pushFollow(FOLLOW_56);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,59,FOLLOW_57); 

            			newLeafNode(otherlv_1, grammarAccess.getInputValueAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:1797:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalAceGen.g:1798:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalAceGen.g:1798:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalAceGen.g:1799:5: lv_value_2_0= rulePrimitiveValue
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
    // InternalAceGen.g:1820:1: entryRuleClientThenBlock returns [EObject current=null] : iv_ruleClientThenBlock= ruleClientThenBlock EOF ;
    public final EObject entryRuleClientThenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientThenBlock = null;


        try {
            // InternalAceGen.g:1820:56: (iv_ruleClientThenBlock= ruleClientThenBlock EOF )
            // InternalAceGen.g:1821:2: iv_ruleClientThenBlock= ruleClientThenBlock EOF
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
    // InternalAceGen.g:1827:1: ruleClientThenBlock returns [EObject current=null] : ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )? ) ;
    public final EObject ruleClientThenBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_stateVerifications_2_0 = null;

        EObject lv_verifications_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1833:2: ( ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )? ) )
            // InternalAceGen.g:1834:2: ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )? )
            {
            // InternalAceGen.g:1834:2: ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )? )
            // InternalAceGen.g:1835:3: () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )?
            {
            // InternalAceGen.g:1835:3: ()
            // InternalAceGen.g:1836:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClientThenBlockAccess().getClientThenBlockAction_0(),
            					current);
            			

            }

            // InternalAceGen.g:1842:3: (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==60) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalAceGen.g:1843:4: otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )*
                    {
                    otherlv_1=(Token)match(input,60,FOLLOW_58); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientThenBlockAccess().getExpectedStateKeyword_1_0());
                    			
                    // InternalAceGen.g:1847:4: ( (lv_stateVerifications_2_0= ruleStateVerification ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==RULE_ID) ) {
                            int LA58_2 = input.LA(2);

                            if ( (LA58_2==RULE_ID) ) {
                                alt58=1;
                            }


                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalAceGen.g:1848:5: (lv_stateVerifications_2_0= ruleStateVerification )
                    	    {
                    	    // InternalAceGen.g:1848:5: (lv_stateVerifications_2_0= ruleStateVerification )
                    	    // InternalAceGen.g:1849:6: lv_stateVerifications_2_0= ruleStateVerification
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientThenBlockAccess().getStateVerificationsStateVerificationParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_58);
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
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1867:3: (otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )* )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==61) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalAceGen.g:1868:4: otherlv_3= 'verifications' ( (lv_verifications_4_0= ruleCustomVerification ) )*
                    {
                    otherlv_3=(Token)match(input,61,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getClientThenBlockAccess().getVerificationsKeyword_2_0());
                    			
                    // InternalAceGen.g:1872:4: ( (lv_verifications_4_0= ruleCustomVerification ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==RULE_ID) ) {
                            int LA60_2 = input.LA(2);

                            if ( (LA60_2==EOF||LA60_2==RULE_ID||LA60_2==18||LA60_2==50) ) {
                                alt60=1;
                            }


                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalAceGen.g:1873:5: (lv_verifications_4_0= ruleCustomVerification )
                    	    {
                    	    // InternalAceGen.g:1873:5: (lv_verifications_4_0= ruleCustomVerification )
                    	    // InternalAceGen.g:1874:6: lv_verifications_4_0= ruleCustomVerification
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
                    	    break loop60;
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
    // InternalAceGen.g:1896:1: entryRuleStateVerification returns [EObject current=null] : iv_ruleStateVerification= ruleStateVerification EOF ;
    public final EObject entryRuleStateVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateVerification = null;


        try {
            // InternalAceGen.g:1896:58: (iv_ruleStateVerification= ruleStateVerification EOF )
            // InternalAceGen.g:1897:2: iv_ruleStateVerification= ruleStateVerification EOF
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
    // InternalAceGen.g:1903:1: ruleStateVerification returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'should' ( (lv_not_3_0= 'not' ) )? otherlv_4= 'be' ( (lv_value_5_0= ruleJsonValueClient ) ) ) ;
    public final EObject ruleStateVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token lv_not_3_0=null;
        Token otherlv_4=null;
        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1909:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'should' ( (lv_not_3_0= 'not' ) )? otherlv_4= 'be' ( (lv_value_5_0= ruleJsonValueClient ) ) ) )
            // InternalAceGen.g:1910:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'should' ( (lv_not_3_0= 'not' ) )? otherlv_4= 'be' ( (lv_value_5_0= ruleJsonValueClient ) ) )
            {
            // InternalAceGen.g:1910:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'should' ( (lv_not_3_0= 'not' ) )? otherlv_4= 'be' ( (lv_value_5_0= ruleJsonValueClient ) ) )
            // InternalAceGen.g:1911:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'should' ( (lv_not_3_0= 'not' ) )? otherlv_4= 'be' ( (lv_value_5_0= ruleJsonValueClient ) )
            {
            // InternalAceGen.g:1911:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1912:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1912:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1913:5: lv_name_0_0= RULE_ID
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

            // InternalAceGen.g:1929:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1930:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1930:4: ( ruleQualifiedName )
            // InternalAceGen.g:1931:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateVerificationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStateVerificationAccess().getStateRefClientAttributeCrossReference_1_0());
            				
            pushFollow(FOLLOW_59);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,62,FOLLOW_60); 

            			newLeafNode(otherlv_2, grammarAccess.getStateVerificationAccess().getShouldKeyword_2());
            		
            // InternalAceGen.g:1949:3: ( (lv_not_3_0= 'not' ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==63) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalAceGen.g:1950:4: (lv_not_3_0= 'not' )
                    {
                    // InternalAceGen.g:1950:4: (lv_not_3_0= 'not' )
                    // InternalAceGen.g:1951:5: lv_not_3_0= 'not'
                    {
                    lv_not_3_0=(Token)match(input,63,FOLLOW_61); 

                    					newLeafNode(lv_not_3_0, grammarAccess.getStateVerificationAccess().getNotNotKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getStateVerificationRule());
                    					}
                    					setWithLastConsumed(current, "not", lv_not_3_0 != null, "not");
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,64,FOLLOW_62); 

            			newLeafNode(otherlv_4, grammarAccess.getStateVerificationAccess().getBeKeyword_4());
            		
            // InternalAceGen.g:1967:3: ( (lv_value_5_0= ruleJsonValueClient ) )
            // InternalAceGen.g:1968:4: (lv_value_5_0= ruleJsonValueClient )
            {
            // InternalAceGen.g:1968:4: (lv_value_5_0= ruleJsonValueClient )
            // InternalAceGen.g:1969:5: lv_value_5_0= ruleJsonValueClient
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
    // InternalAceGen.g:1990:1: entryRuleCustomVerification returns [EObject current=null] : iv_ruleCustomVerification= ruleCustomVerification EOF ;
    public final EObject entryRuleCustomVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomVerification = null;


        try {
            // InternalAceGen.g:1990:59: (iv_ruleCustomVerification= ruleCustomVerification EOF )
            // InternalAceGen.g:1991:2: iv_ruleCustomVerification= ruleCustomVerification EOF
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
    // InternalAceGen.g:1997:1: ruleCustomVerification returns [EObject current=null] : ( ( (lv_functionName_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCustomVerification() throws RecognitionException {
        EObject current = null;

        Token lv_functionName_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalAceGen.g:2003:2: ( ( ( (lv_functionName_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? ) )
            // InternalAceGen.g:2004:2: ( ( (lv_functionName_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? )
            {
            // InternalAceGen.g:2004:2: ( ( (lv_functionName_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? )
            // InternalAceGen.g:2005:3: ( (lv_functionName_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )?
            {
            // InternalAceGen.g:2005:3: ( (lv_functionName_0_0= RULE_ID ) )
            // InternalAceGen.g:2006:4: (lv_functionName_0_0= RULE_ID )
            {
            // InternalAceGen.g:2006:4: (lv_functionName_0_0= RULE_ID )
            // InternalAceGen.g:2007:5: lv_functionName_0_0= RULE_ID
            {
            lv_functionName_0_0=(Token)match(input,RULE_ID,FOLLOW_63); 

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

            // InternalAceGen.g:2023:3: (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==18) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalAceGen.g:2024:4: otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getCustomVerificationAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalAceGen.g:2028:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:2029:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:2029:5: ( ruleQualifiedName )
                    // InternalAceGen.g:2030:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCustomVerificationRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getCustomVerificationAccess().getStateRefClientAttributeCrossReference_1_1_0());
                    					
                    pushFollow(FOLLOW_64);
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
    // InternalAceGen.g:2053:1: entryRuleJsonObjectClient returns [EObject current=null] : iv_ruleJsonObjectClient= ruleJsonObjectClient EOF ;
    public final EObject entryRuleJsonObjectClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObjectClient = null;


        try {
            // InternalAceGen.g:2053:57: (iv_ruleJsonObjectClient= ruleJsonObjectClient EOF )
            // InternalAceGen.g:2054:2: iv_ruleJsonObjectClient= ruleJsonObjectClient EOF
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
    // InternalAceGen.g:2060:1: ruleJsonObjectClient returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleJsonObjectClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_members_2_0 = null;

        EObject lv_members_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2066:2: ( ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' ) )
            // InternalAceGen.g:2067:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' )
            {
            // InternalAceGen.g:2067:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' )
            // InternalAceGen.g:2068:3: () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}'
            {
            // InternalAceGen.g:2068:3: ()
            // InternalAceGen.g:2069:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonObjectClientAccess().getJsonObjectClientAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,39,FOLLOW_65); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonObjectClientAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:2079:3: ( (lv_members_2_0= ruleJsonMemberClient ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalAceGen.g:2080:4: (lv_members_2_0= ruleJsonMemberClient )
                    {
                    // InternalAceGen.g:2080:4: (lv_members_2_0= ruleJsonMemberClient )
                    // InternalAceGen.g:2081:5: lv_members_2_0= ruleJsonMemberClient
                    {

                    					newCompositeNode(grammarAccess.getJsonObjectClientAccess().getMembersJsonMemberClientParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_66);
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

            // InternalAceGen.g:2098:3: (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==19) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalAceGen.g:2099:4: otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_9); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonObjectClientAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:2103:4: ( (lv_members_4_0= ruleJsonMemberClient ) )
            	    // InternalAceGen.g:2104:5: (lv_members_4_0= ruleJsonMemberClient )
            	    {
            	    // InternalAceGen.g:2104:5: (lv_members_4_0= ruleJsonMemberClient )
            	    // InternalAceGen.g:2105:6: lv_members_4_0= ruleJsonMemberClient
            	    {

            	    						newCompositeNode(grammarAccess.getJsonObjectClientAccess().getMembersJsonMemberClientParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_66);
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
            	    break loop65;
                }
            } while (true);

            otherlv_5=(Token)match(input,42,FOLLOW_2); 

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
    // InternalAceGen.g:2131:1: entryRuleJsonMemberClient returns [EObject current=null] : iv_ruleJsonMemberClient= ruleJsonMemberClient EOF ;
    public final EObject entryRuleJsonMemberClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonMemberClient = null;


        try {
            // InternalAceGen.g:2131:57: (iv_ruleJsonMemberClient= ruleJsonMemberClient EOF )
            // InternalAceGen.g:2132:2: iv_ruleJsonMemberClient= ruleJsonMemberClient EOF
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
    // InternalAceGen.g:2138:1: ruleJsonMemberClient returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) ) ;
    public final EObject ruleJsonMemberClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2144:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) ) )
            // InternalAceGen.g:2145:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) )
            {
            // InternalAceGen.g:2145:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) )
            // InternalAceGen.g:2146:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) )
            {
            // InternalAceGen.g:2146:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2147:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2147:4: ( ruleQualifiedName )
            // InternalAceGen.g:2148:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonMemberClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJsonMemberClientAccess().getAttributeClientAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_56);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,59,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonMemberClientAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:2166:3: ( (lv_value_2_0= ruleJsonValueClient ) )
            // InternalAceGen.g:2167:4: (lv_value_2_0= ruleJsonValueClient )
            {
            // InternalAceGen.g:2167:4: (lv_value_2_0= ruleJsonValueClient )
            // InternalAceGen.g:2168:5: lv_value_2_0= ruleJsonValueClient
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
    // InternalAceGen.g:2189:1: entryRuleJsonValueClient returns [EObject current=null] : iv_ruleJsonValueClient= ruleJsonValueClient EOF ;
    public final EObject entryRuleJsonValueClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonValueClient = null;


        try {
            // InternalAceGen.g:2189:56: (iv_ruleJsonValueClient= ruleJsonValueClient EOF )
            // InternalAceGen.g:2190:2: iv_ruleJsonValueClient= ruleJsonValueClient EOF
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
    // InternalAceGen.g:2196:1: ruleJsonValueClient returns [EObject current=null] : (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType ) ;
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
            // InternalAceGen.g:2202:2: ( (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType ) )
            // InternalAceGen.g:2203:2: (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType )
            {
            // InternalAceGen.g:2203:2: (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType )
            int alt66=8;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // InternalAceGen.g:2204:3: this_JsonObjectClient_0= ruleJsonObjectClient
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
                    // InternalAceGen.g:2213:3: this_StringType_1= ruleStringType
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
                    // InternalAceGen.g:2222:3: this_JsonArrayClient_2= ruleJsonArrayClient
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
                    // InternalAceGen.g:2231:3: this_BooleanType_3= ruleBooleanType
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
                    // InternalAceGen.g:2240:3: this_NullType_4= ruleNullType
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
                    // InternalAceGen.g:2249:3: this_LongType_5= ruleLongType
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
                    // InternalAceGen.g:2258:3: this_JsonDateTime_6= ruleJsonDateTime
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
                    // InternalAceGen.g:2267:3: this_UndefinedType_7= ruleUndefinedType
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
    // InternalAceGen.g:2279:1: entryRuleJsonArrayClient returns [EObject current=null] : iv_ruleJsonArrayClient= ruleJsonArrayClient EOF ;
    public final EObject entryRuleJsonArrayClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonArrayClient = null;


        try {
            // InternalAceGen.g:2279:56: (iv_ruleJsonArrayClient= ruleJsonArrayClient EOF )
            // InternalAceGen.g:2280:2: iv_ruleJsonArrayClient= ruleJsonArrayClient EOF
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
    // InternalAceGen.g:2286:1: ruleJsonArrayClient returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleJsonArrayClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2292:2: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' ) )
            // InternalAceGen.g:2293:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' )
            {
            // InternalAceGen.g:2293:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' )
            // InternalAceGen.g:2294:3: () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']'
            {
            // InternalAceGen.g:2294:3: ()
            // InternalAceGen.g:2295:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonArrayClientAccess().getJsonArrayClientAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,65,FOLLOW_67); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonArrayClientAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalAceGen.g:2305:3: ( (lv_values_2_0= ruleJsonValueClient ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=RULE_INT && LA67_0<=RULE_STRING)||LA67_0==39||LA67_0==65||LA67_0==98||(LA67_0>=117 && LA67_0<=119)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalAceGen.g:2306:4: (lv_values_2_0= ruleJsonValueClient )
                    {
                    // InternalAceGen.g:2306:4: (lv_values_2_0= ruleJsonValueClient )
                    // InternalAceGen.g:2307:5: lv_values_2_0= ruleJsonValueClient
                    {

                    					newCompositeNode(grammarAccess.getJsonArrayClientAccess().getValuesJsonValueClientParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_68);
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

            // InternalAceGen.g:2324:3: (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==19) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalAceGen.g:2325:4: otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_62); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonArrayClientAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:2329:4: ( (lv_values_4_0= ruleJsonValueClient ) )
            	    // InternalAceGen.g:2330:5: (lv_values_4_0= ruleJsonValueClient )
            	    {
            	    // InternalAceGen.g:2330:5: (lv_values_4_0= ruleJsonValueClient )
            	    // InternalAceGen.g:2331:6: lv_values_4_0= ruleJsonValueClient
            	    {

            	    						newCompositeNode(grammarAccess.getJsonArrayClientAccess().getValuesJsonValueClientParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_68);
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
            	    break loop68;
                }
            } while (true);

            otherlv_5=(Token)match(input,66,FOLLOW_2); 

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
    // InternalAceGen.g:2357:1: entryRuleHttpServer returns [EObject current=null] : iv_ruleHttpServer= ruleHttpServer EOF ;
    public final EObject entryRuleHttpServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServer = null;


        try {
            // InternalAceGen.g:2357:51: (iv_ruleHttpServer= ruleHttpServer EOF )
            // InternalAceGen.g:2358:2: iv_ruleHttpServer= ruleHttpServer EOF
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
    // InternalAceGen.g:2364:1: ruleHttpServer returns [EObject current=null] : ( ( (lv_java_0_0= 'Java' ) )? ( (lv_cs_1_0= 'C#' ) )? ( (lv_dropwizard_2_0= 'Dropwizard' ) )? ( (lv_dotnet_3_0= 'NET6' ) )? ( (lv_JDBI3_4_0= 'JDBI3' ) )? ( (lv_EF_5_0= 'EntityFramework' ) )? ( (lv_liquibase_6_0= 'Liquibase' ) )? ( (lv_name_7_0= ruleQualifiedName ) ) (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )? (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )? (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )? (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )? (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )? ) ;
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
            // InternalAceGen.g:2370:2: ( ( ( (lv_java_0_0= 'Java' ) )? ( (lv_cs_1_0= 'C#' ) )? ( (lv_dropwizard_2_0= 'Dropwizard' ) )? ( (lv_dotnet_3_0= 'NET6' ) )? ( (lv_JDBI3_4_0= 'JDBI3' ) )? ( (lv_EF_5_0= 'EntityFramework' ) )? ( (lv_liquibase_6_0= 'Liquibase' ) )? ( (lv_name_7_0= ruleQualifiedName ) ) (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )? (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )? (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )? (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )? (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )? ) )
            // InternalAceGen.g:2371:2: ( ( (lv_java_0_0= 'Java' ) )? ( (lv_cs_1_0= 'C#' ) )? ( (lv_dropwizard_2_0= 'Dropwizard' ) )? ( (lv_dotnet_3_0= 'NET6' ) )? ( (lv_JDBI3_4_0= 'JDBI3' ) )? ( (lv_EF_5_0= 'EntityFramework' ) )? ( (lv_liquibase_6_0= 'Liquibase' ) )? ( (lv_name_7_0= ruleQualifiedName ) ) (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )? (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )? (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )? (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )? (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )? )
            {
            // InternalAceGen.g:2371:2: ( ( (lv_java_0_0= 'Java' ) )? ( (lv_cs_1_0= 'C#' ) )? ( (lv_dropwizard_2_0= 'Dropwizard' ) )? ( (lv_dotnet_3_0= 'NET6' ) )? ( (lv_JDBI3_4_0= 'JDBI3' ) )? ( (lv_EF_5_0= 'EntityFramework' ) )? ( (lv_liquibase_6_0= 'Liquibase' ) )? ( (lv_name_7_0= ruleQualifiedName ) ) (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )? (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )? (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )? (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )? (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )? )
            // InternalAceGen.g:2372:3: ( (lv_java_0_0= 'Java' ) )? ( (lv_cs_1_0= 'C#' ) )? ( (lv_dropwizard_2_0= 'Dropwizard' ) )? ( (lv_dotnet_3_0= 'NET6' ) )? ( (lv_JDBI3_4_0= 'JDBI3' ) )? ( (lv_EF_5_0= 'EntityFramework' ) )? ( (lv_liquibase_6_0= 'Liquibase' ) )? ( (lv_name_7_0= ruleQualifiedName ) ) (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )? (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )? (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )? (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )? (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )?
            {
            // InternalAceGen.g:2372:3: ( (lv_java_0_0= 'Java' ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==67) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalAceGen.g:2373:4: (lv_java_0_0= 'Java' )
                    {
                    // InternalAceGen.g:2373:4: (lv_java_0_0= 'Java' )
                    // InternalAceGen.g:2374:5: lv_java_0_0= 'Java'
                    {
                    lv_java_0_0=(Token)match(input,67,FOLLOW_69); 

                    					newLeafNode(lv_java_0_0, grammarAccess.getHttpServerAccess().getJavaJavaKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "java", lv_java_0_0 != null, "Java");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2386:3: ( (lv_cs_1_0= 'C#' ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==68) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalAceGen.g:2387:4: (lv_cs_1_0= 'C#' )
                    {
                    // InternalAceGen.g:2387:4: (lv_cs_1_0= 'C#' )
                    // InternalAceGen.g:2388:5: lv_cs_1_0= 'C#'
                    {
                    lv_cs_1_0=(Token)match(input,68,FOLLOW_70); 

                    					newLeafNode(lv_cs_1_0, grammarAccess.getHttpServerAccess().getCsCKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "cs", lv_cs_1_0 != null, "C#");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2400:3: ( (lv_dropwizard_2_0= 'Dropwizard' ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==69) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalAceGen.g:2401:4: (lv_dropwizard_2_0= 'Dropwizard' )
                    {
                    // InternalAceGen.g:2401:4: (lv_dropwizard_2_0= 'Dropwizard' )
                    // InternalAceGen.g:2402:5: lv_dropwizard_2_0= 'Dropwizard'
                    {
                    lv_dropwizard_2_0=(Token)match(input,69,FOLLOW_71); 

                    					newLeafNode(lv_dropwizard_2_0, grammarAccess.getHttpServerAccess().getDropwizardDropwizardKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "dropwizard", lv_dropwizard_2_0 != null, "Dropwizard");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2414:3: ( (lv_dotnet_3_0= 'NET6' ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==70) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalAceGen.g:2415:4: (lv_dotnet_3_0= 'NET6' )
                    {
                    // InternalAceGen.g:2415:4: (lv_dotnet_3_0= 'NET6' )
                    // InternalAceGen.g:2416:5: lv_dotnet_3_0= 'NET6'
                    {
                    lv_dotnet_3_0=(Token)match(input,70,FOLLOW_72); 

                    					newLeafNode(lv_dotnet_3_0, grammarAccess.getHttpServerAccess().getDotnetNET6Keyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "dotnet", lv_dotnet_3_0 != null, "NET6");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2428:3: ( (lv_JDBI3_4_0= 'JDBI3' ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==71) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalAceGen.g:2429:4: (lv_JDBI3_4_0= 'JDBI3' )
                    {
                    // InternalAceGen.g:2429:4: (lv_JDBI3_4_0= 'JDBI3' )
                    // InternalAceGen.g:2430:5: lv_JDBI3_4_0= 'JDBI3'
                    {
                    lv_JDBI3_4_0=(Token)match(input,71,FOLLOW_73); 

                    					newLeafNode(lv_JDBI3_4_0, grammarAccess.getHttpServerAccess().getJDBI3JDBI3Keyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "JDBI3", lv_JDBI3_4_0 != null, "JDBI3");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2442:3: ( (lv_EF_5_0= 'EntityFramework' ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==72) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalAceGen.g:2443:4: (lv_EF_5_0= 'EntityFramework' )
                    {
                    // InternalAceGen.g:2443:4: (lv_EF_5_0= 'EntityFramework' )
                    // InternalAceGen.g:2444:5: lv_EF_5_0= 'EntityFramework'
                    {
                    lv_EF_5_0=(Token)match(input,72,FOLLOW_74); 

                    					newLeafNode(lv_EF_5_0, grammarAccess.getHttpServerAccess().getEFEntityFrameworkKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "EF", lv_EF_5_0 != null, "EntityFramework");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2456:3: ( (lv_liquibase_6_0= 'Liquibase' ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==73) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalAceGen.g:2457:4: (lv_liquibase_6_0= 'Liquibase' )
                    {
                    // InternalAceGen.g:2457:4: (lv_liquibase_6_0= 'Liquibase' )
                    // InternalAceGen.g:2458:5: lv_liquibase_6_0= 'Liquibase'
                    {
                    lv_liquibase_6_0=(Token)match(input,73,FOLLOW_9); 

                    					newLeafNode(lv_liquibase_6_0, grammarAccess.getHttpServerAccess().getLiquibaseLiquibaseKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "liquibase", lv_liquibase_6_0 != null, "Liquibase");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2470:3: ( (lv_name_7_0= ruleQualifiedName ) )
            // InternalAceGen.g:2471:4: (lv_name_7_0= ruleQualifiedName )
            {
            // InternalAceGen.g:2471:4: (lv_name_7_0= ruleQualifiedName )
            // InternalAceGen.g:2472:5: lv_name_7_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getHttpServerAccess().getNameQualifiedNameParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_75);
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

            // InternalAceGen.g:2489:3: (otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==74) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalAceGen.g:2490:4: otherlv_8= 'Authorization' ( (lv_authUser_9_0= ruleAuthUser ) )
                    {
                    otherlv_8=(Token)match(input,74,FOLLOW_9); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerAccess().getAuthorizationKeyword_8_0());
                    			
                    // InternalAceGen.g:2494:4: ( (lv_authUser_9_0= ruleAuthUser ) )
                    // InternalAceGen.g:2495:5: (lv_authUser_9_0= ruleAuthUser )
                    {
                    // InternalAceGen.g:2495:5: (lv_authUser_9_0= ruleAuthUser )
                    // InternalAceGen.g:2496:6: lv_authUser_9_0= ruleAuthUser
                    {

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserAuthUserParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_76);
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

            // InternalAceGen.g:2514:3: (otherlv_10= 'import' ( ( ruleQualifiedName ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==75) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalAceGen.g:2515:4: otherlv_10= 'import' ( ( ruleQualifiedName ) )
                    {
                    otherlv_10=(Token)match(input,75,FOLLOW_9); 

                    				newLeafNode(otherlv_10, grammarAccess.getHttpServerAccess().getImportKeyword_9_0());
                    			
                    // InternalAceGen.g:2519:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:2520:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:2520:5: ( ruleQualifiedName )
                    // InternalAceGen.g:2521:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpServerRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_9_1_0());
                    					
                    pushFollow(FOLLOW_77);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:2536:3: (otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )* )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==13) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalAceGen.g:2537:4: otherlv_12= 'ACE' ( (lv_aceOperations_13_0= ruleHttpServerAce ) )*
                    {
                    otherlv_12=(Token)match(input,13,FOLLOW_78); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpServerAccess().getACEKeyword_10_0());
                    			
                    // InternalAceGen.g:2541:4: ( (lv_aceOperations_13_0= ruleHttpServerAce ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==RULE_ID) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // InternalAceGen.g:2542:5: (lv_aceOperations_13_0= ruleHttpServerAce )
                    	    {
                    	    // InternalAceGen.g:2542:5: (lv_aceOperations_13_0= ruleHttpServerAce )
                    	    // InternalAceGen.g:2543:6: lv_aceOperations_13_0= ruleHttpServerAce
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getAceOperationsHttpServerAceParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_78);
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
                    	    break loop78;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2561:3: (otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )* )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==76) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalAceGen.g:2562:4: otherlv_14= 'views' ( (lv_views_15_0= ruleHttpServerView ) )*
                    {
                    otherlv_14=(Token)match(input,76,FOLLOW_79); 

                    				newLeafNode(otherlv_14, grammarAccess.getHttpServerAccess().getViewsKeyword_11_0());
                    			
                    // InternalAceGen.g:2566:4: ( (lv_views_15_0= ruleHttpServerView ) )*
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==RULE_ID||LA80_0==87) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // InternalAceGen.g:2567:5: (lv_views_15_0= ruleHttpServerView )
                    	    {
                    	    // InternalAceGen.g:2567:5: (lv_views_15_0= ruleHttpServerView )
                    	    // InternalAceGen.g:2568:6: lv_views_15_0= ruleHttpServerView
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getViewsHttpServerViewParserRuleCall_11_1_0());
                    	    					
                    	    pushFollow(FOLLOW_79);
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
                    	    break loop80;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2586:3: (otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )* )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==77) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalAceGen.g:2587:4: otherlv_16= 'models' ( (lv_models_17_0= ruleModel ) )*
                    {
                    otherlv_16=(Token)match(input,77,FOLLOW_80); 

                    				newLeafNode(otherlv_16, grammarAccess.getHttpServerAccess().getModelsKeyword_12_0());
                    			
                    // InternalAceGen.g:2591:4: ( (lv_models_17_0= ruleModel ) )*
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==RULE_ID||LA82_0==88) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // InternalAceGen.g:2592:5: (lv_models_17_0= ruleModel )
                    	    {
                    	    // InternalAceGen.g:2592:5: (lv_models_17_0= ruleModel )
                    	    // InternalAceGen.g:2593:6: lv_models_17_0= ruleModel
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getModelsModelParserRuleCall_12_1_0());
                    	    					
                    	    pushFollow(FOLLOW_80);
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
                    	    break loop82;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2611:3: (otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )* )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==16) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalAceGen.g:2612:4: otherlv_18= 'scenarios' ( (lv_scenarios_19_0= ruleScenario ) )*
                    {
                    otherlv_18=(Token)match(input,16,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getHttpServerAccess().getScenariosKeyword_13_0());
                    			
                    // InternalAceGen.g:2616:4: ( (lv_scenarios_19_0= ruleScenario ) )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==RULE_ID) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // InternalAceGen.g:2617:5: (lv_scenarios_19_0= ruleScenario )
                    	    {
                    	    // InternalAceGen.g:2617:5: (lv_scenarios_19_0= ruleScenario )
                    	    // InternalAceGen.g:2618:6: lv_scenarios_19_0= ruleScenario
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
                    	    break loop84;
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
    // InternalAceGen.g:2640:1: entryRuleHttpServerAce returns [EObject current=null] : iv_ruleHttpServerAce= ruleHttpServerAce EOF ;
    public final EObject entryRuleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAce = null;


        try {
            // InternalAceGen.g:2640:54: (iv_ruleHttpServerAce= ruleHttpServerAce EOF )
            // InternalAceGen.g:2641:2: iv_ruleHttpServerAce= ruleHttpServerAce EOF
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
    // InternalAceGen.g:2647:1: ruleHttpServerAce returns [EObject current=null] : (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) ;
    public final EObject ruleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject this_HttpServerAceWrite_0 = null;

        EObject this_HttpServerAceRead_1 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2653:2: ( (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) )
            // InternalAceGen.g:2654:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            {
            // InternalAceGen.g:2654:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // InternalAceGen.g:2655:3: this_HttpServerAceWrite_0= ruleHttpServerAceWrite
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
                    // InternalAceGen.g:2664:3: this_HttpServerAceRead_1= ruleHttpServerAceRead
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
    // InternalAceGen.g:2676:1: entryRuleHttpServerAceWrite returns [EObject current=null] : iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF ;
    public final EObject entryRuleHttpServerAceWrite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceWrite = null;


        try {
            // InternalAceGen.g:2676:59: (iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF )
            // InternalAceGen.g:2677:2: iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF
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
    // InternalAceGen.g:2683:1: ruleHttpServerAceWrite returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? ( (lv_multipartFormData_7_0= 'multipartFormData' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* ) ;
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
            // InternalAceGen.g:2689:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? ( (lv_multipartFormData_7_0= 'multipartFormData' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* ) )
            // InternalAceGen.g:2690:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? ( (lv_multipartFormData_7_0= 'multipartFormData' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* )
            {
            // InternalAceGen.g:2690:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? ( (lv_multipartFormData_7_0= 'multipartFormData' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* )
            // InternalAceGen.g:2691:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? ( (lv_multipartFormData_7_0= 'multipartFormData' ) )? (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )? (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )? (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )*
            {
            // InternalAceGen.g:2691:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:2692:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:2692:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:2693:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_81); 

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

            otherlv_1=(Token)match(input,78,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getHttpServerAceWriteAccess().getLessThanSignKeyword_1());
            		
            // InternalAceGen.g:2713:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2714:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2714:4: ( ruleQualifiedName )
            // InternalAceGen.g:2715:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_82);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,79,FOLLOW_83); 

            			newLeafNode(otherlv_3, grammarAccess.getHttpServerAceWriteAccess().getGreaterThanSignKeyword_3());
            		
            // InternalAceGen.g:2733:3: ( (lv_type_4_0= ruleWriteFunctionType ) )
            // InternalAceGen.g:2734:4: (lv_type_4_0= ruleWriteFunctionType )
            {
            // InternalAceGen.g:2734:4: (lv_type_4_0= ruleWriteFunctionType )
            // InternalAceGen.g:2735:5: lv_type_4_0= ruleWriteFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getTypeWriteFunctionTypeParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_52);
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

            // InternalAceGen.g:2752:3: ( (lv_url_5_0= RULE_STRING ) )
            // InternalAceGen.g:2753:4: (lv_url_5_0= RULE_STRING )
            {
            // InternalAceGen.g:2753:4: (lv_url_5_0= RULE_STRING )
            // InternalAceGen.g:2754:5: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)match(input,RULE_STRING,FOLLOW_84); 

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

            // InternalAceGen.g:2770:3: ( (lv_authorize_6_0= 'authorize' ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==80) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalAceGen.g:2771:4: (lv_authorize_6_0= 'authorize' )
                    {
                    // InternalAceGen.g:2771:4: (lv_authorize_6_0= 'authorize' )
                    // InternalAceGen.g:2772:5: lv_authorize_6_0= 'authorize'
                    {
                    lv_authorize_6_0=(Token)match(input,80,FOLLOW_85); 

                    					newLeafNode(lv_authorize_6_0, grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    					}
                    					setWithLastConsumed(current, "authorize", lv_authorize_6_0 != null, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2784:3: ( (lv_multipartFormData_7_0= 'multipartFormData' ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==81) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalAceGen.g:2785:4: (lv_multipartFormData_7_0= 'multipartFormData' )
                    {
                    // InternalAceGen.g:2785:4: (lv_multipartFormData_7_0= 'multipartFormData' )
                    // InternalAceGen.g:2786:5: lv_multipartFormData_7_0= 'multipartFormData'
                    {
                    lv_multipartFormData_7_0=(Token)match(input,81,FOLLOW_86); 

                    					newLeafNode(lv_multipartFormData_7_0, grammarAccess.getHttpServerAceWriteAccess().getMultipartFormDataMultipartFormDataKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    					}
                    					setWithLastConsumed(current, "multipartFormData", lv_multipartFormData_7_0 != null, "multipartFormData");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2798:3: (otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )* )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==82) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalAceGen.g:2799:4: otherlv_8= 'pathParams' ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_8=(Token)match(input,82,FOLLOW_87); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:2803:4: ( (lv_pathParams_9_0= ruleAttributeParamRef ) )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==RULE_ID) ) {
                            int LA89_2 = input.LA(2);

                            if ( (LA89_2==EOF||LA89_2==RULE_ID||LA89_2==16||LA89_2==25||(LA89_2>=76 && LA89_2<=77)||(LA89_2>=83 && LA89_2<=86)||LA89_2==104) ) {
                                alt89=1;
                            }


                        }
                        else if ( (LA89_0==86) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // InternalAceGen.g:2804:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2804:5: (lv_pathParams_9_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2805:6: lv_pathParams_9_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeParamRefParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_87);
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
                    	    break loop89;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2823:3: (otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )* )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==83) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalAceGen.g:2824:4: otherlv_10= 'queryParams' ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_10=(Token)match(input,83,FOLLOW_88); 

                    				newLeafNode(otherlv_10, grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_9_0());
                    			
                    // InternalAceGen.g:2828:4: ( (lv_queryParams_11_0= ruleAttributeParamRef ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==RULE_ID) ) {
                            int LA91_2 = input.LA(2);

                            if ( (LA91_2==EOF||LA91_2==RULE_ID||LA91_2==16||LA91_2==25||(LA91_2>=76 && LA91_2<=77)||(LA91_2>=84 && LA91_2<=86)||LA91_2==104) ) {
                                alt91=1;
                            }


                        }
                        else if ( (LA91_0==86) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // InternalAceGen.g:2829:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2829:5: (lv_queryParams_11_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2830:6: lv_queryParams_11_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeParamRefParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_88);
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
                    	    break loop91;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2848:3: (otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )* )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==84) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalAceGen.g:2849:4: otherlv_12= 'payload' ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_12=(Token)match(input,84,FOLLOW_89); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_10_0());
                    			
                    // InternalAceGen.g:2853:4: ( (lv_payload_13_0= ruleAttributeParamRef ) )*
                    loop93:
                    do {
                        int alt93=2;
                        int LA93_0 = input.LA(1);

                        if ( (LA93_0==RULE_ID) ) {
                            int LA93_2 = input.LA(2);

                            if ( (LA93_2==EOF||LA93_2==RULE_ID||LA93_2==16||LA93_2==25||(LA93_2>=76 && LA93_2<=77)||(LA93_2>=85 && LA93_2<=86)||LA93_2==104) ) {
                                alt93=1;
                            }


                        }
                        else if ( (LA93_0==86) ) {
                            alt93=1;
                        }


                        switch (alt93) {
                    	case 1 :
                    	    // InternalAceGen.g:2854:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2854:5: (lv_payload_13_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2855:6: lv_payload_13_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeParamRefParserRuleCall_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_89);
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
                    	    break loop93;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2873:3: (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==85) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalAceGen.g:2874:4: otherlv_14= 'response' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_14=(Token)match(input,85,FOLLOW_90); 

                    				newLeafNode(otherlv_14, grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_11_0());
                    			
                    // InternalAceGen.g:2878:4: ( ( ruleQualifiedName ) )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==RULE_ID) ) {
                            int LA95_2 = input.LA(2);

                            if ( (LA95_2==EOF||LA95_2==RULE_ID||LA95_2==16||LA95_2==25||(LA95_2>=76 && LA95_2<=77)||LA95_2==104) ) {
                                alt95=1;
                            }


                        }


                        switch (alt95) {
                    	case 1 :
                    	    // InternalAceGen.g:2879:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:2879:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:2880:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeCrossReference_11_1_0());
                    	    					
                    	    pushFollow(FOLLOW_90);
                    	    ruleQualifiedName();

                    	    state._fsp--;


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

            // InternalAceGen.g:2895:3: ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==25) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalAceGen.g:2896:4: (lv_outcomes_16_0= ruleHttpServerOutcome )
            	    {
            	    // InternalAceGen.g:2896:4: (lv_outcomes_16_0= ruleHttpServerOutcome )
            	    // InternalAceGen.g:2897:5: lv_outcomes_16_0= ruleHttpServerOutcome
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
            	    break loop97;
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
    // InternalAceGen.g:2918:1: entryRuleHttpServerOutcome returns [EObject current=null] : iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF ;
    public final EObject entryRuleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerOutcome = null;


        try {
            // InternalAceGen.g:2918:58: (iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF )
            // InternalAceGen.g:2919:2: iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF
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
    // InternalAceGen.g:2925:1: ruleHttpServerOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* ) ;
    public final EObject ruleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAceGen.g:2931:2: ( (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* ) )
            // InternalAceGen.g:2932:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* )
            {
            // InternalAceGen.g:2932:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* )
            // InternalAceGen.g:2933:3: otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )*
            {
            otherlv_0=(Token)match(input,25,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpServerOutcomeAccess().getOnKeyword_0());
            		
            // InternalAceGen.g:2937:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:2938:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:2938:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:2939:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_63); 

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

            // InternalAceGen.g:2955:3: (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==18) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalAceGen.g:2956:4: otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')'
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_48); 

            	    				newLeafNode(otherlv_2, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0());
            	    			
            	    // InternalAceGen.g:2960:4: ( ( ruleQualifiedName ) )*
            	    loop98:
            	    do {
            	        int alt98=2;
            	        int LA98_0 = input.LA(1);

            	        if ( (LA98_0==RULE_ID) ) {
            	            alt98=1;
            	        }


            	        switch (alt98) {
            	    	case 1 :
            	    	    // InternalAceGen.g:2961:5: ( ruleQualifiedName )
            	    	    {
            	    	    // InternalAceGen.g:2961:5: ( ruleQualifiedName )
            	    	    // InternalAceGen.g:2962:6: ruleQualifiedName
            	    	    {

            	    	    						if (current==null) {
            	    	    							current = createModelElement(grammarAccess.getHttpServerOutcomeRule());
            	    	    						}
            	    	    					

            	    	    						newCompositeNode(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0());
            	    	    					
            	    	    pushFollow(FOLLOW_48);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;


            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop98;
            	        }
            	    } while (true);

            	    otherlv_4=(Token)match(input,20,FOLLOW_63); 

            	    				newLeafNode(otherlv_4, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop99;
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
    // InternalAceGen.g:2985:1: entryRuleHttpServerAceRead returns [EObject current=null] : iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF ;
    public final EObject entryRuleHttpServerAceRead() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceRead = null;


        try {
            // InternalAceGen.g:2985:58: (iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF )
            // InternalAceGen.g:2986:2: iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF
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
    // InternalAceGen.g:2992:1: ruleHttpServerAceRead returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? ) ;
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
            // InternalAceGen.g:2998:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? ) )
            // InternalAceGen.g:2999:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? )
            {
            // InternalAceGen.g:2999:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? )
            // InternalAceGen.g:3000:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )?
            {
            // InternalAceGen.g:3000:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3001:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3001:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3002:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_81); 

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

            otherlv_1=(Token)match(input,78,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getHttpServerAceReadAccess().getLessThanSignKeyword_1());
            		
            // InternalAceGen.g:3022:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3023:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3023:4: ( ruleQualifiedName )
            // InternalAceGen.g:3024:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_82);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,79,FOLLOW_91); 

            			newLeafNode(otherlv_3, grammarAccess.getHttpServerAceReadAccess().getGreaterThanSignKeyword_3());
            		
            // InternalAceGen.g:3042:3: ( (lv_type_4_0= ruleReadFunctionType ) )
            // InternalAceGen.g:3043:4: (lv_type_4_0= ruleReadFunctionType )
            {
            // InternalAceGen.g:3043:4: (lv_type_4_0= ruleReadFunctionType )
            // InternalAceGen.g:3044:5: lv_type_4_0= ruleReadFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getTypeReadFunctionTypeParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_52);
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

            // InternalAceGen.g:3061:3: ( (lv_url_5_0= RULE_STRING ) )
            // InternalAceGen.g:3062:4: (lv_url_5_0= RULE_STRING )
            {
            // InternalAceGen.g:3062:4: (lv_url_5_0= RULE_STRING )
            // InternalAceGen.g:3063:5: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)match(input,RULE_STRING,FOLLOW_92); 

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

            // InternalAceGen.g:3079:3: ( (lv_authorize_6_0= 'authorize' ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==80) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalAceGen.g:3080:4: (lv_authorize_6_0= 'authorize' )
                    {
                    // InternalAceGen.g:3080:4: (lv_authorize_6_0= 'authorize' )
                    // InternalAceGen.g:3081:5: lv_authorize_6_0= 'authorize'
                    {
                    lv_authorize_6_0=(Token)match(input,80,FOLLOW_93); 

                    					newLeafNode(lv_authorize_6_0, grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    					}
                    					setWithLastConsumed(current, "authorize", lv_authorize_6_0 != null, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:3093:3: (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==82) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalAceGen.g:3094:4: otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_7=(Token)match(input,82,FOLLOW_94); 

                    				newLeafNode(otherlv_7, grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_7_0());
                    			
                    // InternalAceGen.g:3098:4: ( (lv_pathParams_8_0= ruleAttributeParamRef ) )*
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( (LA101_0==RULE_ID) ) {
                            int LA101_2 = input.LA(2);

                            if ( (LA101_2==EOF||LA101_2==RULE_ID||LA101_2==16||(LA101_2>=76 && LA101_2<=77)||(LA101_2>=83 && LA101_2<=86)||LA101_2==104) ) {
                                alt101=1;
                            }


                        }
                        else if ( (LA101_0==86) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // InternalAceGen.g:3099:5: (lv_pathParams_8_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:3099:5: (lv_pathParams_8_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:3100:6: lv_pathParams_8_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeParamRefParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_94);
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
                    	    break loop101;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:3118:3: (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==83) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalAceGen.g:3119:4: otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_9=(Token)match(input,83,FOLLOW_95); 

                    				newLeafNode(otherlv_9, grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:3123:4: ( (lv_queryParams_10_0= ruleAttributeParamRef ) )*
                    loop103:
                    do {
                        int alt103=2;
                        int LA103_0 = input.LA(1);

                        if ( (LA103_0==RULE_ID) ) {
                            int LA103_2 = input.LA(2);

                            if ( (LA103_2==EOF||LA103_2==RULE_ID||LA103_2==16||(LA103_2>=76 && LA103_2<=77)||(LA103_2>=84 && LA103_2<=86)||LA103_2==104) ) {
                                alt103=1;
                            }


                        }
                        else if ( (LA103_0==86) ) {
                            alt103=1;
                        }


                        switch (alt103) {
                    	case 1 :
                    	    // InternalAceGen.g:3124:5: (lv_queryParams_10_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:3124:5: (lv_queryParams_10_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:3125:6: lv_queryParams_10_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeParamRefParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_95);
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
                    	    break loop103;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:3143:3: (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==84) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalAceGen.g:3144:4: otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_11=(Token)match(input,84,FOLLOW_96); 

                    				newLeafNode(otherlv_11, grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_9_0());
                    			
                    // InternalAceGen.g:3148:4: ( (lv_payload_12_0= ruleAttributeParamRef ) )*
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( (LA105_0==RULE_ID) ) {
                            int LA105_2 = input.LA(2);

                            if ( (LA105_2==EOF||LA105_2==RULE_ID||LA105_2==16||(LA105_2>=76 && LA105_2<=77)||(LA105_2>=85 && LA105_2<=86)||LA105_2==104) ) {
                                alt105=1;
                            }


                        }
                        else if ( (LA105_0==86) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // InternalAceGen.g:3149:5: (lv_payload_12_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:3149:5: (lv_payload_12_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:3150:6: lv_payload_12_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeParamRefParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_96);
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
                    	    break loop105;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:3168:3: (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==85) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalAceGen.g:3169:4: otherlv_13= 'response' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_13=(Token)match(input,85,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_10_0());
                    			
                    // InternalAceGen.g:3173:4: ( ( ruleQualifiedName ) )*
                    loop107:
                    do {
                        int alt107=2;
                        int LA107_0 = input.LA(1);

                        if ( (LA107_0==RULE_ID) ) {
                            int LA107_2 = input.LA(2);

                            if ( (LA107_2==EOF||LA107_2==RULE_ID||LA107_2==16||(LA107_2>=76 && LA107_2<=77)||LA107_2==104) ) {
                                alt107=1;
                            }


                        }


                        switch (alt107) {
                    	case 1 :
                    	    // InternalAceGen.g:3174:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:3174:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:3175:6: ruleQualifiedName
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
                    	    break loop107;
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
    // InternalAceGen.g:3194:1: entryRuleAttributeParamRef returns [EObject current=null] : iv_ruleAttributeParamRef= ruleAttributeParamRef EOF ;
    public final EObject entryRuleAttributeParamRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeParamRef = null;


        try {
            // InternalAceGen.g:3194:58: (iv_ruleAttributeParamRef= ruleAttributeParamRef EOF )
            // InternalAceGen.g:3195:2: iv_ruleAttributeParamRef= ruleAttributeParamRef EOF
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
    // InternalAceGen.g:3201:1: ruleAttributeParamRef returns [EObject current=null] : ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleAttributeParamRef() throws RecognitionException {
        EObject current = null;

        Token lv_notNull_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:3207:2: ( ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:3208:2: ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:3208:2: ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:3209:3: ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:3209:3: ( (lv_notNull_0_0= 'NotNull' ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==86) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalAceGen.g:3210:4: (lv_notNull_0_0= 'NotNull' )
                    {
                    // InternalAceGen.g:3210:4: (lv_notNull_0_0= 'NotNull' )
                    // InternalAceGen.g:3211:5: lv_notNull_0_0= 'NotNull'
                    {
                    lv_notNull_0_0=(Token)match(input,86,FOLLOW_9); 

                    					newLeafNode(lv_notNull_0_0, grammarAccess.getAttributeParamRefAccess().getNotNullNotNullKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeParamRefRule());
                    					}
                    					setWithLastConsumed(current, "notNull", lv_notNull_0_0 != null, "NotNull");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:3223:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3224:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3224:4: ( ruleQualifiedName )
            // InternalAceGen.g:3225:5: ruleQualifiedName
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
    // InternalAceGen.g:3243:1: entryRuleHttpServerView returns [EObject current=null] : iv_ruleHttpServerView= ruleHttpServerView EOF ;
    public final EObject entryRuleHttpServerView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerView = null;


        try {
            // InternalAceGen.g:3243:55: (iv_ruleHttpServerView= ruleHttpServerView EOF )
            // InternalAceGen.g:3244:2: iv_ruleHttpServerView= ruleHttpServerView EOF
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
    // InternalAceGen.g:3250:1: ruleHttpServerView returns [EObject current=null] : ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? ) ;
    public final EObject ruleHttpServerView() throws RecognitionException {
        EObject current = null;

        Token lv_afterCommit_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_renderFunctions_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3256:2: ( ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? ) )
            // InternalAceGen.g:3257:2: ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? )
            {
            // InternalAceGen.g:3257:2: ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? )
            // InternalAceGen.g:3258:3: ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )?
            {
            // InternalAceGen.g:3258:3: ( (lv_afterCommit_0_0= 'afterCommit' ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==87) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalAceGen.g:3259:4: (lv_afterCommit_0_0= 'afterCommit' )
                    {
                    // InternalAceGen.g:3259:4: (lv_afterCommit_0_0= 'afterCommit' )
                    // InternalAceGen.g:3260:5: lv_afterCommit_0_0= 'afterCommit'
                    {
                    lv_afterCommit_0_0=(Token)match(input,87,FOLLOW_9); 

                    					newLeafNode(lv_afterCommit_0_0, grammarAccess.getHttpServerViewAccess().getAfterCommitAfterCommitKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerViewRule());
                    					}
                    					setWithLastConsumed(current, "afterCommit", lv_afterCommit_0_0 != null, "afterCommit");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:3272:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:3273:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:3273:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:3274:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_32); 

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

            // InternalAceGen.g:3290:3: (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==39) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalAceGen.g:3291:4: otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_97); 

                    				newLeafNode(otherlv_2, grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalAceGen.g:3295:4: ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )*
                    loop111:
                    do {
                        int alt111=2;
                        int LA111_0 = input.LA(1);

                        if ( (LA111_0==RULE_ID) ) {
                            alt111=1;
                        }


                        switch (alt111) {
                    	case 1 :
                    	    // InternalAceGen.g:3296:5: (lv_renderFunctions_3_0= ruleHttpServerViewFunction )
                    	    {
                    	    // InternalAceGen.g:3296:5: (lv_renderFunctions_3_0= ruleHttpServerViewFunction )
                    	    // InternalAceGen.g:3297:6: lv_renderFunctions_3_0= ruleHttpServerViewFunction
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerViewAccess().getRenderFunctionsHttpServerViewFunctionParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_97);
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
                    	    break loop111;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,42,FOLLOW_2); 

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
    // InternalAceGen.g:3323:1: entryRuleHttpServerViewFunction returns [EObject current=null] : iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF ;
    public final EObject entryRuleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerViewFunction = null;


        try {
            // InternalAceGen.g:3323:63: (iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF )
            // InternalAceGen.g:3324:2: iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF
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
    // InternalAceGen.g:3330:1: ruleHttpServerViewFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) ;
    public final EObject ruleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalAceGen.g:3336:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) )
            // InternalAceGen.g:3337:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            {
            // InternalAceGen.g:3337:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            // InternalAceGen.g:3338:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')'
            {
            // InternalAceGen.g:3338:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3339:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3339:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3340:5: lv_name_0_0= RULE_ID
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
            		
            // InternalAceGen.g:3360:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3361:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3361:4: ( ruleQualifiedName )
            // InternalAceGen.g:3362:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerViewFunctionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_64);
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
    // InternalAceGen.g:3384:1: entryRuleAuthUser returns [EObject current=null] : iv_ruleAuthUser= ruleAuthUser EOF ;
    public final EObject entryRuleAuthUser() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthUser = null;


        try {
            // InternalAceGen.g:3384:49: (iv_ruleAuthUser= ruleAuthUser EOF )
            // InternalAceGen.g:3385:2: iv_ruleAuthUser= ruleAuthUser EOF
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
    // InternalAceGen.g:3391:1: ruleAuthUser returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) ;
    public final EObject ruleAuthUser() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3397:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) )
            // InternalAceGen.g:3398:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            {
            // InternalAceGen.g:3398:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            // InternalAceGen.g:3399:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            {
            // InternalAceGen.g:3399:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3400:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3400:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3401:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_35); 

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

            // InternalAceGen.g:3417:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            // InternalAceGen.g:3418:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}'
            {
            otherlv_1=(Token)match(input,39,FOLLOW_98); 

            				newLeafNode(otherlv_1, grammarAccess.getAuthUserAccess().getLeftCurlyBracketKeyword_1_0());
            			
            // InternalAceGen.g:3422:4: ( (lv_attributes_2_0= ruleAttribute ) )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==RULE_ID||LA113_0==32||LA113_0==86||(LA113_0>=101 && LA113_0<=102)||(LA113_0>=109 && LA113_0<=115)) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // InternalAceGen.g:3423:5: (lv_attributes_2_0= ruleAttribute )
            	    {
            	    // InternalAceGen.g:3423:5: (lv_attributes_2_0= ruleAttribute )
            	    // InternalAceGen.g:3424:6: lv_attributes_2_0= ruleAttribute
            	    {

            	    						newCompositeNode(grammarAccess.getAuthUserAccess().getAttributesAttributeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_98);
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
            	    break loop113;
                }
            } while (true);

            otherlv_3=(Token)match(input,42,FOLLOW_2); 

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
    // InternalAceGen.g:3450:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAceGen.g:3450:46: (iv_ruleModel= ruleModel EOF )
            // InternalAceGen.g:3451:2: iv_ruleModel= ruleModel EOF
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
    // InternalAceGen.g:3457:1: ruleModel returns [EObject current=null] : ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) ;
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
            // InternalAceGen.g:3463:2: ( ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) )
            // InternalAceGen.g:3464:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            {
            // InternalAceGen.g:3464:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            // InternalAceGen.g:3465:3: ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            {
            // InternalAceGen.g:3465:3: ( (lv_persistent_0_0= 'persistent' ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==88) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalAceGen.g:3466:4: (lv_persistent_0_0= 'persistent' )
                    {
                    // InternalAceGen.g:3466:4: (lv_persistent_0_0= 'persistent' )
                    // InternalAceGen.g:3467:5: lv_persistent_0_0= 'persistent'
                    {
                    lv_persistent_0_0=(Token)match(input,88,FOLLOW_9); 

                    					newLeafNode(lv_persistent_0_0, grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(current, "persistent", lv_persistent_0_0 != null, "persistent");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:3479:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:3480:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:3480:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:3481:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_99); 

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

            // InternalAceGen.g:3497:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==89) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalAceGen.g:3498:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_2=(Token)match(input,89,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getExtendsKeyword_2_0());
                    			
                    // InternalAceGen.g:3502:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:3503:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:3503:5: ( ruleQualifiedName )
                    // InternalAceGen.g:3504:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_100);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:3518:4: (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==19) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalAceGen.g:3519:5: otherlv_4= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_9); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getModelAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:3523:5: ( ( ruleQualifiedName ) )
                    	    // InternalAceGen.g:3524:6: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:3524:6: ( ruleQualifiedName )
                    	    // InternalAceGen.g:3525:7: ruleQualifiedName
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModelRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_100);
                    	    ruleQualifiedName();

                    	    state._fsp--;


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

            // InternalAceGen.g:3541:3: (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==39) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // InternalAceGen.g:3542:4: otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,39,FOLLOW_98); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalAceGen.g:3546:4: ( (lv_attributes_7_0= ruleAttribute ) )*
                    loop117:
                    do {
                        int alt117=2;
                        int LA117_0 = input.LA(1);

                        if ( (LA117_0==RULE_ID||LA117_0==32||LA117_0==86||(LA117_0>=101 && LA117_0<=102)||(LA117_0>=109 && LA117_0<=115)) ) {
                            alt117=1;
                        }


                        switch (alt117) {
                    	case 1 :
                    	    // InternalAceGen.g:3547:5: (lv_attributes_7_0= ruleAttribute )
                    	    {
                    	    // InternalAceGen.g:3547:5: (lv_attributes_7_0= ruleAttribute )
                    	    // InternalAceGen.g:3548:6: lv_attributes_7_0= ruleAttribute
                    	    {

                    	    						newCompositeNode(grammarAccess.getModelAccess().getAttributesAttributeParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_98);
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
                    	    break loop117;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,42,FOLLOW_2); 

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
    // InternalAceGen.g:3574:1: entryRuleScenario returns [EObject current=null] : iv_ruleScenario= ruleScenario EOF ;
    public final EObject entryRuleScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario = null;


        try {
            // InternalAceGen.g:3574:49: (iv_ruleScenario= ruleScenario EOF )
            // InternalAceGen.g:3575:2: iv_ruleScenario= ruleScenario EOF
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
    // InternalAceGen.g:3581:1: ruleScenario returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? ( (lv_whenThen_3_0= ruleWhenThen ) ) (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )* ) ;
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
            // InternalAceGen.g:3587:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? ( (lv_whenThen_3_0= ruleWhenThen ) ) (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )* ) )
            // InternalAceGen.g:3588:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? ( (lv_whenThen_3_0= ruleWhenThen ) ) (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )* )
            {
            // InternalAceGen.g:3588:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? ( (lv_whenThen_3_0= ruleWhenThen ) ) (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )* )
            // InternalAceGen.g:3589:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? ( (lv_whenThen_3_0= ruleWhenThen ) ) (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )*
            {
            // InternalAceGen.g:3589:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3590:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3590:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3591:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_38); 

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

            // InternalAceGen.g:3607:3: (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==49) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // InternalAceGen.g:3608:4: otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )*
                    {
                    otherlv_1=(Token)match(input,49,FOLLOW_39); 

                    				newLeafNode(otherlv_1, grammarAccess.getScenarioAccess().getGIVENKeyword_1_0());
                    			
                    // InternalAceGen.g:3612:4: ( (lv_givenItems_2_0= ruleGiven ) )*
                    loop119:
                    do {
                        int alt119=2;
                        int LA119_0 = input.LA(1);

                        if ( (LA119_0==RULE_ID) ) {
                            alt119=1;
                        }


                        switch (alt119) {
                    	case 1 :
                    	    // InternalAceGen.g:3613:5: (lv_givenItems_2_0= ruleGiven )
                    	    {
                    	    // InternalAceGen.g:3613:5: (lv_givenItems_2_0= ruleGiven )
                    	    // InternalAceGen.g:3614:6: lv_givenItems_2_0= ruleGiven
                    	    {

                    	    						newCompositeNode(grammarAccess.getScenarioAccess().getGivenItemsGivenParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_39);
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
                    	    break loop119;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:3632:3: ( (lv_whenThen_3_0= ruleWhenThen ) )
            // InternalAceGen.g:3633:4: (lv_whenThen_3_0= ruleWhenThen )
            {
            // InternalAceGen.g:3633:4: (lv_whenThen_3_0= ruleWhenThen )
            // InternalAceGen.g:3634:5: lv_whenThen_3_0= ruleWhenThen
            {

            					newCompositeNode(grammarAccess.getScenarioAccess().getWhenThenWhenThenParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_40);
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

            // InternalAceGen.g:3651:3: (otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) ) )*
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==50) ) {
                    alt121=1;
                }


                switch (alt121) {
            	case 1 :
            	    // InternalAceGen.g:3652:4: otherlv_4= 'AND' ( (lv_whenThen_5_0= ruleWhenThen ) )
            	    {
            	    otherlv_4=(Token)match(input,50,FOLLOW_38); 

            	    				newLeafNode(otherlv_4, grammarAccess.getScenarioAccess().getANDKeyword_3_0());
            	    			
            	    // InternalAceGen.g:3656:4: ( (lv_whenThen_5_0= ruleWhenThen ) )
            	    // InternalAceGen.g:3657:5: (lv_whenThen_5_0= ruleWhenThen )
            	    {
            	    // InternalAceGen.g:3657:5: (lv_whenThen_5_0= ruleWhenThen )
            	    // InternalAceGen.g:3658:6: lv_whenThen_5_0= ruleWhenThen
            	    {

            	    						newCompositeNode(grammarAccess.getScenarioAccess().getWhenThenWhenThenParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_40);
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
    // $ANTLR end "ruleScenario"


    // $ANTLR start "entryRuleWhenThen"
    // InternalAceGen.g:3680:1: entryRuleWhenThen returns [EObject current=null] : iv_ruleWhenThen= ruleWhenThen EOF ;
    public final EObject entryRuleWhenThen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhenThen = null;


        try {
            // InternalAceGen.g:3680:49: (iv_ruleWhenThen= ruleWhenThen EOF )
            // InternalAceGen.g:3681:2: iv_ruleWhenThen= ruleWhenThen EOF
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
    // InternalAceGen.g:3687:1: ruleWhenThen returns [EObject current=null] : (otherlv_0= 'WHEN' ( (lv_whenBlock_1_0= ruleWhenBlock ) ) otherlv_2= 'THEN' ( (lv_thenBlock_3_0= ruleThenBlock ) ) ) ;
    public final EObject ruleWhenThen() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_whenBlock_1_0 = null;

        EObject lv_thenBlock_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3693:2: ( (otherlv_0= 'WHEN' ( (lv_whenBlock_1_0= ruleWhenBlock ) ) otherlv_2= 'THEN' ( (lv_thenBlock_3_0= ruleThenBlock ) ) ) )
            // InternalAceGen.g:3694:2: (otherlv_0= 'WHEN' ( (lv_whenBlock_1_0= ruleWhenBlock ) ) otherlv_2= 'THEN' ( (lv_thenBlock_3_0= ruleThenBlock ) ) )
            {
            // InternalAceGen.g:3694:2: (otherlv_0= 'WHEN' ( (lv_whenBlock_1_0= ruleWhenBlock ) ) otherlv_2= 'THEN' ( (lv_thenBlock_3_0= ruleThenBlock ) ) )
            // InternalAceGen.g:3695:3: otherlv_0= 'WHEN' ( (lv_whenBlock_1_0= ruleWhenBlock ) ) otherlv_2= 'THEN' ( (lv_thenBlock_3_0= ruleThenBlock ) )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getWhenThenAccess().getWHENKeyword_0());
            		
            // InternalAceGen.g:3699:3: ( (lv_whenBlock_1_0= ruleWhenBlock ) )
            // InternalAceGen.g:3700:4: (lv_whenBlock_1_0= ruleWhenBlock )
            {
            // InternalAceGen.g:3700:4: (lv_whenBlock_1_0= ruleWhenBlock )
            // InternalAceGen.g:3701:5: lv_whenBlock_1_0= ruleWhenBlock
            {

            					newCompositeNode(grammarAccess.getWhenThenAccess().getWhenBlockWhenBlockParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_101);
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

            otherlv_2=(Token)match(input,52,FOLLOW_22); 

            			newLeafNode(otherlv_2, grammarAccess.getWhenThenAccess().getTHENKeyword_2());
            		
            // InternalAceGen.g:3722:3: ( (lv_thenBlock_3_0= ruleThenBlock ) )
            // InternalAceGen.g:3723:4: (lv_thenBlock_3_0= ruleThenBlock )
            {
            // InternalAceGen.g:3723:4: (lv_thenBlock_3_0= ruleThenBlock )
            // InternalAceGen.g:3724:5: lv_thenBlock_3_0= ruleThenBlock
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
    // InternalAceGen.g:3745:1: entryRuleGiven returns [EObject current=null] : iv_ruleGiven= ruleGiven EOF ;
    public final EObject entryRuleGiven() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGiven = null;


        try {
            // InternalAceGen.g:3745:46: (iv_ruleGiven= ruleGiven EOF )
            // InternalAceGen.g:3746:2: iv_ruleGiven= ruleGiven EOF
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
    // InternalAceGen.g:3752:1: ruleGiven returns [EObject current=null] : (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall ) ;
    public final EObject ruleGiven() throws RecognitionException {
        EObject current = null;

        EObject this_GivenRef_0 = null;

        EObject this_CustomCall_1 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3758:2: ( (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall ) )
            // InternalAceGen.g:3759:2: (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall )
            {
            // InternalAceGen.g:3759:2: (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall )
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==RULE_ID) ) {
                int LA122_1 = input.LA(2);

                if ( (LA122_1==18) ) {
                    alt122=2;
                }
                else if ( (LA122_1==EOF||(LA122_1>=RULE_ID && LA122_1<=RULE_INT)||LA122_1==51||LA122_1==53||LA122_1==104) ) {
                    alt122=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 122, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }
            switch (alt122) {
                case 1 :
                    // InternalAceGen.g:3760:3: this_GivenRef_0= ruleGivenRef
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
                    // InternalAceGen.g:3769:3: this_CustomCall_1= ruleCustomCall
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
    // InternalAceGen.g:3781:1: entryRuleCustomCall returns [EObject current=null] : iv_ruleCustomCall= ruleCustomCall EOF ;
    public final EObject entryRuleCustomCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomCall = null;


        try {
            // InternalAceGen.g:3781:51: (iv_ruleCustomCall= ruleCustomCall EOF )
            // InternalAceGen.g:3782:2: iv_ruleCustomCall= ruleCustomCall EOF
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
    // InternalAceGen.g:3788:1: ruleCustomCall returns [EObject current=null] : ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? ) ;
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
            // InternalAceGen.g:3794:2: ( ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? ) )
            // InternalAceGen.g:3795:2: ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? )
            {
            // InternalAceGen.g:3795:2: ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? )
            // InternalAceGen.g:3796:3: ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )?
            {
            // InternalAceGen.g:3796:3: ( (lv_customCallName_0_0= RULE_ID ) )
            // InternalAceGen.g:3797:4: (lv_customCallName_0_0= RULE_ID )
            {
            // InternalAceGen.g:3797:4: (lv_customCallName_0_0= RULE_ID )
            // InternalAceGen.g:3798:5: lv_customCallName_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,18,FOLLOW_102); 

            			newLeafNode(otherlv_1, grammarAccess.getCustomCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:3818:3: ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( ((LA124_0>=RULE_INT && LA124_0<=RULE_STRING)) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // InternalAceGen.g:3819:4: ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )*
                    {
                    // InternalAceGen.g:3819:4: ( (lv_values_2_0= rulePrimitiveValue ) )
                    // InternalAceGen.g:3820:5: (lv_values_2_0= rulePrimitiveValue )
                    {
                    // InternalAceGen.g:3820:5: (lv_values_2_0= rulePrimitiveValue )
                    // InternalAceGen.g:3821:6: lv_values_2_0= rulePrimitiveValue
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

                    // InternalAceGen.g:3838:4: (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )*
                    loop123:
                    do {
                        int alt123=2;
                        int LA123_0 = input.LA(1);

                        if ( (LA123_0==19) ) {
                            alt123=1;
                        }


                        switch (alt123) {
                    	case 1 :
                    	    // InternalAceGen.g:3839:5: otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_57); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getCustomCallAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalAceGen.g:3843:5: ( (lv_values_4_0= rulePrimitiveValue ) )
                    	    // InternalAceGen.g:3844:6: (lv_values_4_0= rulePrimitiveValue )
                    	    {
                    	    // InternalAceGen.g:3844:6: (lv_values_4_0= rulePrimitiveValue )
                    	    // InternalAceGen.g:3845:7: lv_values_4_0= rulePrimitiveValue
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
                    	    break loop123;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_103); 

            			newLeafNode(otherlv_5, grammarAccess.getCustomCallAccess().getRightParenthesisKeyword_3());
            		
            // InternalAceGen.g:3868:3: ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==RULE_INT) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalAceGen.g:3869:4: ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x'
                    {
                    // InternalAceGen.g:3869:4: ( (lv_times_6_0= RULE_INT ) )
                    // InternalAceGen.g:3870:5: (lv_times_6_0= RULE_INT )
                    {
                    // InternalAceGen.g:3870:5: (lv_times_6_0= RULE_INT )
                    // InternalAceGen.g:3871:6: lv_times_6_0= RULE_INT
                    {
                    lv_times_6_0=(Token)match(input,RULE_INT,FOLLOW_104); 

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

                    otherlv_7=(Token)match(input,90,FOLLOW_2); 

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
    // InternalAceGen.g:3896:1: entryRuleGivenRef returns [EObject current=null] : iv_ruleGivenRef= ruleGivenRef EOF ;
    public final EObject entryRuleGivenRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGivenRef = null;


        try {
            // InternalAceGen.g:3896:49: (iv_ruleGivenRef= ruleGivenRef EOF )
            // InternalAceGen.g:3897:2: iv_ruleGivenRef= ruleGivenRef EOF
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
    // InternalAceGen.g:3903:1: ruleGivenRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )? ) ;
    public final EObject ruleGivenRef() throws RecognitionException {
        EObject current = null;

        Token lv_times_1_0=null;
        Token otherlv_2=null;
        Token lv_excludeGiven_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAceGen.g:3909:2: ( ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )? ) )
            // InternalAceGen.g:3910:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )? )
            {
            // InternalAceGen.g:3910:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )? )
            // InternalAceGen.g:3911:3: ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )?
            {
            // InternalAceGen.g:3911:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3912:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3912:4: ( ruleQualifiedName )
            // InternalAceGen.g:3913:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGivenRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGivenRefAccess().getScenarioScenarioCrossReference_0_0());
            				
            pushFollow(FOLLOW_105);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3927:3: ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==RULE_INT) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalAceGen.g:3928:4: ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x'
                    {
                    // InternalAceGen.g:3928:4: ( (lv_times_1_0= RULE_INT ) )
                    // InternalAceGen.g:3929:5: (lv_times_1_0= RULE_INT )
                    {
                    // InternalAceGen.g:3929:5: (lv_times_1_0= RULE_INT )
                    // InternalAceGen.g:3930:6: lv_times_1_0= RULE_INT
                    {
                    lv_times_1_0=(Token)match(input,RULE_INT,FOLLOW_104); 

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

                    otherlv_2=(Token)match(input,90,FOLLOW_45); 

                    				newLeafNode(otherlv_2, grammarAccess.getGivenRefAccess().getXKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:3951:3: ( ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN' )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==53) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalAceGen.g:3952:4: ( (lv_excludeGiven_3_0= 'exclude' ) ) otherlv_4= 'GIVEN'
                    {
                    // InternalAceGen.g:3952:4: ( (lv_excludeGiven_3_0= 'exclude' ) )
                    // InternalAceGen.g:3953:5: (lv_excludeGiven_3_0= 'exclude' )
                    {
                    // InternalAceGen.g:3953:5: (lv_excludeGiven_3_0= 'exclude' )
                    // InternalAceGen.g:3954:6: lv_excludeGiven_3_0= 'exclude'
                    {
                    lv_excludeGiven_3_0=(Token)match(input,53,FOLLOW_46); 

                    						newLeafNode(lv_excludeGiven_3_0, grammarAccess.getGivenRefAccess().getExcludeGivenExcludeKeyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGivenRefRule());
                    						}
                    						setWithLastConsumed(current, "excludeGiven", lv_excludeGiven_3_0 != null, "exclude");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,49,FOLLOW_2); 

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
    // InternalAceGen.g:3975:1: entryRuleWhenBlock returns [EObject current=null] : iv_ruleWhenBlock= ruleWhenBlock EOF ;
    public final EObject entryRuleWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhenBlock = null;


        try {
            // InternalAceGen.g:3975:50: (iv_ruleWhenBlock= ruleWhenBlock EOF )
            // InternalAceGen.g:3976:2: iv_ruleWhenBlock= ruleWhenBlock EOF
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
    // InternalAceGen.g:3982:1: ruleWhenBlock returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* ) ;
    public final EObject ruleWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_dataDefinition_1_0 = null;

        EObject lv_authorization_2_0 = null;

        EObject lv_extractions_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3988:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* ) )
            // InternalAceGen.g:3989:2: ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* )
            {
            // InternalAceGen.g:3989:2: ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* )
            // InternalAceGen.g:3990:3: ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )*
            {
            // InternalAceGen.g:3990:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3991:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3991:4: ( ruleQualifiedName )
            // InternalAceGen.g:3992:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWhenBlockRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWhenBlockAccess().getActionHttpServerAceCrossReference_0_0());
            				
            pushFollow(FOLLOW_106);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:4006:3: ( (lv_dataDefinition_1_0= ruleDataDefinition ) )
            // InternalAceGen.g:4007:4: (lv_dataDefinition_1_0= ruleDataDefinition )
            {
            // InternalAceGen.g:4007:4: (lv_dataDefinition_1_0= ruleDataDefinition )
            // InternalAceGen.g:4008:5: lv_dataDefinition_1_0= ruleDataDefinition
            {

            					newCompositeNode(grammarAccess.getWhenBlockAccess().getDataDefinitionDataDefinitionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_107);
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

            // InternalAceGen.g:4025:3: ( (lv_authorization_2_0= ruleAuthorization ) )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==100) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // InternalAceGen.g:4026:4: (lv_authorization_2_0= ruleAuthorization )
                    {
                    // InternalAceGen.g:4026:4: (lv_authorization_2_0= ruleAuthorization )
                    // InternalAceGen.g:4027:5: lv_authorization_2_0= ruleAuthorization
                    {

                    					newCompositeNode(grammarAccess.getWhenBlockAccess().getAuthorizationAuthorizationParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_108);
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

            // InternalAceGen.g:4044:3: ( (lv_extractions_3_0= ruleExtraction ) )*
            loop129:
            do {
                int alt129=2;
                int LA129_0 = input.LA(1);

                if ( (LA129_0==96) ) {
                    alt129=1;
                }


                switch (alt129) {
            	case 1 :
            	    // InternalAceGen.g:4045:4: (lv_extractions_3_0= ruleExtraction )
            	    {
            	    // InternalAceGen.g:4045:4: (lv_extractions_3_0= ruleExtraction )
            	    // InternalAceGen.g:4046:5: lv_extractions_3_0= ruleExtraction
            	    {

            	    					newCompositeNode(grammarAccess.getWhenBlockAccess().getExtractionsExtractionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_108);
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
            	    break loop129;
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
    // InternalAceGen.g:4067:1: entryRuleThenBlock returns [EObject current=null] : iv_ruleThenBlock= ruleThenBlock EOF ;
    public final EObject entryRuleThenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThenBlock = null;


        try {
            // InternalAceGen.g:4067:50: (iv_ruleThenBlock= ruleThenBlock EOF )
            // InternalAceGen.g:4068:2: iv_ruleThenBlock= ruleThenBlock EOF
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
    // InternalAceGen.g:4074:1: ruleThenBlock returns [EObject current=null] : ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? ) ;
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
            // InternalAceGen.g:4080:2: ( ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? ) )
            // InternalAceGen.g:4081:2: ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? )
            {
            // InternalAceGen.g:4081:2: ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? )
            // InternalAceGen.g:4082:3: ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )?
            {
            // InternalAceGen.g:4082:3: ( (lv_statusCode_0_0= RULE_INT ) )
            // InternalAceGen.g:4083:4: (lv_statusCode_0_0= RULE_INT )
            {
            // InternalAceGen.g:4083:4: (lv_statusCode_0_0= RULE_INT )
            // InternalAceGen.g:4084:5: lv_statusCode_0_0= RULE_INT
            {
            lv_statusCode_0_0=(Token)match(input,RULE_INT,FOLLOW_109); 

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

            // InternalAceGen.g:4100:3: (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==85) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalAceGen.g:4101:4: otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) )
                    {
                    otherlv_1=(Token)match(input,85,FOLLOW_110); 

                    				newLeafNode(otherlv_1, grammarAccess.getThenBlockAccess().getResponseKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,91,FOLLOW_111); 

                    				newLeafNode(otherlv_2, grammarAccess.getThenBlockAccess().getShouldBeKeyword_1_1());
                    			
                    // InternalAceGen.g:4109:4: ( (lv_response_3_0= ruleDataDefinition ) )
                    // InternalAceGen.g:4110:5: (lv_response_3_0= ruleDataDefinition )
                    {
                    // InternalAceGen.g:4110:5: (lv_response_3_0= ruleDataDefinition )
                    // InternalAceGen.g:4111:6: lv_response_3_0= ruleDataDefinition
                    {

                    						newCompositeNode(grammarAccess.getThenBlockAccess().getResponseDataDefinitionParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_112);
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

            // InternalAceGen.g:4129:3: (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )?
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==92) ) {
                alt132=1;
            }
            switch (alt132) {
                case 1 :
                    // InternalAceGen.g:4130:4: otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )*
                    {
                    otherlv_4=(Token)match(input,92,FOLLOW_58); 

                    				newLeafNode(otherlv_4, grammarAccess.getThenBlockAccess().getPersistenceKeyword_2_0());
                    			
                    // InternalAceGen.g:4134:4: ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )*
                    loop131:
                    do {
                        int alt131=2;
                        int LA131_0 = input.LA(1);

                        if ( (LA131_0==RULE_ID) ) {
                            int LA131_2 = input.LA(2);

                            if ( (LA131_2==RULE_ID) ) {
                                alt131=1;
                            }


                        }


                        switch (alt131) {
                    	case 1 :
                    	    // InternalAceGen.g:4135:5: (lv_persistenceVerifications_5_0= rulePersistenceVerification )
                    	    {
                    	    // InternalAceGen.g:4135:5: (lv_persistenceVerifications_5_0= rulePersistenceVerification )
                    	    // InternalAceGen.g:4136:6: lv_persistenceVerifications_5_0= rulePersistenceVerification
                    	    {

                    	    						newCompositeNode(grammarAccess.getThenBlockAccess().getPersistenceVerificationsPersistenceVerificationParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_58);
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
                    	    break loop131;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:4154:3: (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==61) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // InternalAceGen.g:4155:4: otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )*
                    {
                    otherlv_6=(Token)match(input,61,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getThenBlockAccess().getVerificationsKeyword_3_0());
                    			
                    // InternalAceGen.g:4159:4: ( (lv_verifications_7_0= ruleVerification ) )*
                    loop133:
                    do {
                        int alt133=2;
                        int LA133_0 = input.LA(1);

                        if ( (LA133_0==RULE_ID) ) {
                            int LA133_2 = input.LA(2);

                            if ( (LA133_2==EOF||LA133_2==RULE_ID||LA133_2==50) ) {
                                alt133=1;
                            }


                        }


                        switch (alt133) {
                    	case 1 :
                    	    // InternalAceGen.g:4160:5: (lv_verifications_7_0= ruleVerification )
                    	    {
                    	    // InternalAceGen.g:4160:5: (lv_verifications_7_0= ruleVerification )
                    	    // InternalAceGen.g:4161:6: lv_verifications_7_0= ruleVerification
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
                    	    break loop133;
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
    // InternalAceGen.g:4183:1: entryRulePersistenceVerification returns [EObject current=null] : iv_rulePersistenceVerification= rulePersistenceVerification EOF ;
    public final EObject entryRulePersistenceVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersistenceVerification = null;


        try {
            // InternalAceGen.g:4183:64: (iv_rulePersistenceVerification= rulePersistenceVerification EOF )
            // InternalAceGen.g:4184:2: iv_rulePersistenceVerification= rulePersistenceVerification EOF
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
    // InternalAceGen.g:4190:1: rulePersistenceVerification returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) ) ;
    public final EObject rulePersistenceVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4196:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) ) )
            // InternalAceGen.g:4197:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) )
            {
            // InternalAceGen.g:4197:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) )
            // InternalAceGen.g:4198:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) )
            {
            // InternalAceGen.g:4198:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:4199:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:4199:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:4200:5: lv_name_0_0= RULE_ID
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

            // InternalAceGen.g:4216:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:4217:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:4217:4: ( ruleQualifiedName )
            // InternalAceGen.g:4218:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPersistenceVerificationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPersistenceVerificationAccess().getModelModelCrossReference_1_0());
            				
            pushFollow(FOLLOW_113);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:4232:3: ( (lv_expression_2_0= rulePersistenceVerificationExpression ) )
            // InternalAceGen.g:4233:4: (lv_expression_2_0= rulePersistenceVerificationExpression )
            {
            // InternalAceGen.g:4233:4: (lv_expression_2_0= rulePersistenceVerificationExpression )
            // InternalAceGen.g:4234:5: lv_expression_2_0= rulePersistenceVerificationExpression
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
    // InternalAceGen.g:4255:1: entryRulePersistenceVerificationExpression returns [EObject current=null] : iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF ;
    public final EObject entryRulePersistenceVerificationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersistenceVerificationExpression = null;


        try {
            // InternalAceGen.g:4255:74: (iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF )
            // InternalAceGen.g:4256:2: iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF
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
    // InternalAceGen.g:4262:1: rulePersistenceVerificationExpression returns [EObject current=null] : (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount ) ;
    public final EObject rulePersistenceVerificationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_SelectByUniqueAttribute_0 = null;

        EObject this_SelectByPrimaryKeys_1 = null;

        EObject this_Count_2 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4268:2: ( (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount ) )
            // InternalAceGen.g:4269:2: (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount )
            {
            // InternalAceGen.g:4269:2: (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount )
            int alt135=3;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt135=1;
                }
                break;
            case 93:
                {
                alt135=2;
                }
                break;
            case 95:
                {
                alt135=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;
            }

            switch (alt135) {
                case 1 :
                    // InternalAceGen.g:4270:3: this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute
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
                    // InternalAceGen.g:4279:3: this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys
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
                    // InternalAceGen.g:4288:3: this_Count_2= ruleCount
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
    // InternalAceGen.g:4300:1: entryRuleSelectByPrimaryKeys returns [EObject current=null] : iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF ;
    public final EObject entryRuleSelectByPrimaryKeys() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByPrimaryKeys = null;


        try {
            // InternalAceGen.g:4300:60: (iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF )
            // InternalAceGen.g:4301:2: iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF
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
    // InternalAceGen.g:4307:1: ruleSelectByPrimaryKeys returns [EObject current=null] : (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) ) ;
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
            // InternalAceGen.g:4313:2: ( (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) ) )
            // InternalAceGen.g:4314:2: (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) )
            {
            // InternalAceGen.g:4314:2: (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) )
            // InternalAceGen.g:4315:3: otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) )
            {
            otherlv_0=(Token)match(input,93,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getSelectByPrimaryKeysAccess().getSelectByPrimaryKeyKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectByPrimaryKeysAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:4323:3: ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:4324:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:4324:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:4325:5: lv_attributeAndValues_2_0= ruleAttributeAndValue
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

            // InternalAceGen.g:4342:3: (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==19) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // InternalAceGen.g:4343:4: otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_48); 

                    				newLeafNode(otherlv_3, grammarAccess.getSelectByPrimaryKeysAccess().getCommaKeyword_3_0());
                    			
                    // InternalAceGen.g:4347:4: ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    loop136:
                    do {
                        int alt136=2;
                        int LA136_0 = input.LA(1);

                        if ( (LA136_0==RULE_ID) ) {
                            alt136=1;
                        }


                        switch (alt136) {
                    	case 1 :
                    	    // InternalAceGen.g:4348:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    {
                    	    // InternalAceGen.g:4348:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    // InternalAceGen.g:4349:6: lv_attributeAndValues_4_0= ruleAttributeAndValue
                    	    {

                    	    						newCompositeNode(grammarAccess.getSelectByPrimaryKeysAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_48);
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
                    	    break loop136;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_110); 

            			newLeafNode(otherlv_5, grammarAccess.getSelectByPrimaryKeysAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,91,FOLLOW_114); 

            			newLeafNode(otherlv_6, grammarAccess.getSelectByPrimaryKeysAccess().getShouldBeKeyword_5());
            		
            // InternalAceGen.g:4375:3: ( (lv_expected_7_0= ruleSelectByExpectation ) )
            // InternalAceGen.g:4376:4: (lv_expected_7_0= ruleSelectByExpectation )
            {
            // InternalAceGen.g:4376:4: (lv_expected_7_0= ruleSelectByExpectation )
            // InternalAceGen.g:4377:5: lv_expected_7_0= ruleSelectByExpectation
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
    // InternalAceGen.g:4398:1: entryRuleSelectByUniqueAttribute returns [EObject current=null] : iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF ;
    public final EObject entryRuleSelectByUniqueAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByUniqueAttribute = null;


        try {
            // InternalAceGen.g:4398:64: (iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF )
            // InternalAceGen.g:4399:2: iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF
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
    // InternalAceGen.g:4405:1: ruleSelectByUniqueAttribute returns [EObject current=null] : (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) ) ;
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
            // InternalAceGen.g:4411:2: ( (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) ) )
            // InternalAceGen.g:4412:2: (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) )
            {
            // InternalAceGen.g:4412:2: (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) )
            // InternalAceGen.g:4413:3: otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) )
            {
            otherlv_0=(Token)match(input,94,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getSelectByUniqueAttributeAccess().getSelectByKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectByUniqueAttributeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:4421:3: ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:4422:4: (lv_attributeAndValue_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:4422:4: (lv_attributeAndValue_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:4423:5: lv_attributeAndValue_2_0= ruleAttributeAndValue
            {

            					newCompositeNode(grammarAccess.getSelectByUniqueAttributeAccess().getAttributeAndValueAttributeAndValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_64);
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

            otherlv_3=(Token)match(input,20,FOLLOW_110); 

            			newLeafNode(otherlv_3, grammarAccess.getSelectByUniqueAttributeAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,91,FOLLOW_114); 

            			newLeafNode(otherlv_4, grammarAccess.getSelectByUniqueAttributeAccess().getShouldBeKeyword_4());
            		
            // InternalAceGen.g:4448:3: ( (lv_expected_5_0= ruleSelectByExpectation ) )
            // InternalAceGen.g:4449:4: (lv_expected_5_0= ruleSelectByExpectation )
            {
            // InternalAceGen.g:4449:4: (lv_expected_5_0= ruleSelectByExpectation )
            // InternalAceGen.g:4450:5: lv_expected_5_0= ruleSelectByExpectation
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
    // InternalAceGen.g:4471:1: entryRuleCount returns [EObject current=null] : iv_ruleCount= ruleCount EOF ;
    public final EObject entryRuleCount() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCount = null;


        try {
            // InternalAceGen.g:4471:46: (iv_ruleCount= ruleCount EOF )
            // InternalAceGen.g:4472:2: iv_ruleCount= ruleCount EOF
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
    // InternalAceGen.g:4478:1: ruleCount returns [EObject current=null] : (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) ) ;
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
            // InternalAceGen.g:4484:2: ( (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) ) )
            // InternalAceGen.g:4485:2: (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) )
            {
            // InternalAceGen.g:4485:2: (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) )
            // InternalAceGen.g:4486:3: otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,95,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getCountAccess().getFilterAndCountByKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getCountAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:4494:3: ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:4495:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:4495:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:4496:5: lv_attributeAndValues_2_0= ruleAttributeAndValue
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

            // InternalAceGen.g:4513:3: (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==19) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // InternalAceGen.g:4514:4: otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_48); 

                    				newLeafNode(otherlv_3, grammarAccess.getCountAccess().getCommaKeyword_3_0());
                    			
                    // InternalAceGen.g:4518:4: ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    loop138:
                    do {
                        int alt138=2;
                        int LA138_0 = input.LA(1);

                        if ( (LA138_0==RULE_ID) ) {
                            alt138=1;
                        }


                        switch (alt138) {
                    	case 1 :
                    	    // InternalAceGen.g:4519:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    {
                    	    // InternalAceGen.g:4519:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    // InternalAceGen.g:4520:6: lv_attributeAndValues_4_0= ruleAttributeAndValue
                    	    {

                    	    						newCompositeNode(grammarAccess.getCountAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_48);
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
                    	    break loop138;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_110); 

            			newLeafNode(otherlv_5, grammarAccess.getCountAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,91,FOLLOW_22); 

            			newLeafNode(otherlv_6, grammarAccess.getCountAccess().getShouldBeKeyword_5());
            		
            // InternalAceGen.g:4546:3: ( (lv_expected_7_0= RULE_INT ) )
            // InternalAceGen.g:4547:4: (lv_expected_7_0= RULE_INT )
            {
            // InternalAceGen.g:4547:4: (lv_expected_7_0= RULE_INT )
            // InternalAceGen.g:4548:5: lv_expected_7_0= RULE_INT
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
    // InternalAceGen.g:4568:1: entryRuleAttributeAndValue returns [EObject current=null] : iv_ruleAttributeAndValue= ruleAttributeAndValue EOF ;
    public final EObject entryRuleAttributeAndValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeAndValue = null;


        try {
            // InternalAceGen.g:4568:58: (iv_ruleAttributeAndValue= ruleAttributeAndValue EOF )
            // InternalAceGen.g:4569:2: iv_ruleAttributeAndValue= ruleAttributeAndValue EOF
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
    // InternalAceGen.g:4575:1: ruleAttributeAndValue returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject ruleAttributeAndValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4581:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalAceGen.g:4582:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalAceGen.g:4582:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalAceGen.g:4583:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalAceGen.g:4583:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:4584:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:4584:4: ( ruleQualifiedName )
            // InternalAceGen.g:4585:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeAndValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAttributeAndValueAccess().getAttributeAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_56);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,59,FOLLOW_57); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeAndValueAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:4603:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalAceGen.g:4604:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalAceGen.g:4604:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalAceGen.g:4605:5: lv_value_2_0= rulePrimitiveValue
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
    // InternalAceGen.g:4626:1: entryRuleVerification returns [EObject current=null] : iv_ruleVerification= ruleVerification EOF ;
    public final EObject entryRuleVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerification = null;


        try {
            // InternalAceGen.g:4626:53: (iv_ruleVerification= ruleVerification EOF )
            // InternalAceGen.g:4627:2: iv_ruleVerification= ruleVerification EOF
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
    // InternalAceGen.g:4633:1: ruleVerification returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4639:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalAceGen.g:4640:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalAceGen.g:4640:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:4641:3: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:4641:3: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:4642:4: lv_name_0_0= RULE_ID
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
    // InternalAceGen.g:4661:1: entryRuleExtraction returns [EObject current=null] : iv_ruleExtraction= ruleExtraction EOF ;
    public final EObject entryRuleExtraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtraction = null;


        try {
            // InternalAceGen.g:4661:51: (iv_ruleExtraction= ruleExtraction EOF )
            // InternalAceGen.g:4662:2: iv_ruleExtraction= ruleExtraction EOF
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
    // InternalAceGen.g:4668:1: ruleExtraction returns [EObject current=null] : (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExtraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4674:2: ( (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalAceGen.g:4675:2: (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalAceGen.g:4675:2: (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalAceGen.g:4676:3: otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,96,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getExtractionAccess().getExtractKeyword_0());
            		
            // InternalAceGen.g:4680:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:4681:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:4681:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:4682:5: lv_name_1_0= RULE_ID
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
    // InternalAceGen.g:4702:1: entryRuleSelectByExpectation returns [EObject current=null] : iv_ruleSelectByExpectation= ruleSelectByExpectation EOF ;
    public final EObject entryRuleSelectByExpectation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByExpectation = null;


        try {
            // InternalAceGen.g:4702:60: (iv_ruleSelectByExpectation= ruleSelectByExpectation EOF )
            // InternalAceGen.g:4703:2: iv_ruleSelectByExpectation= ruleSelectByExpectation EOF
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
    // InternalAceGen.g:4709:1: ruleSelectByExpectation returns [EObject current=null] : ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) ) ;
    public final EObject ruleSelectByExpectation() throws RecognitionException {
        EObject current = null;

        Token lv_isNotNull_1_0=null;
        Token lv_isNull_2_0=null;
        EObject lv_object_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4715:2: ( ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) ) )
            // InternalAceGen.g:4716:2: ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) )
            {
            // InternalAceGen.g:4716:2: ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) )
            int alt140=3;
            switch ( input.LA(1) ) {
            case 39:
            case 116:
                {
                alt140=1;
                }
                break;
            case 97:
                {
                alt140=2;
                }
                break;
            case 98:
                {
                alt140=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;
            }

            switch (alt140) {
                case 1 :
                    // InternalAceGen.g:4717:3: ( (lv_object_0_0= ruleJsonObject ) )
                    {
                    // InternalAceGen.g:4717:3: ( (lv_object_0_0= ruleJsonObject ) )
                    // InternalAceGen.g:4718:4: (lv_object_0_0= ruleJsonObject )
                    {
                    // InternalAceGen.g:4718:4: (lv_object_0_0= ruleJsonObject )
                    // InternalAceGen.g:4719:5: lv_object_0_0= ruleJsonObject
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
                    // InternalAceGen.g:4737:3: ( (lv_isNotNull_1_0= 'notNull' ) )
                    {
                    // InternalAceGen.g:4737:3: ( (lv_isNotNull_1_0= 'notNull' ) )
                    // InternalAceGen.g:4738:4: (lv_isNotNull_1_0= 'notNull' )
                    {
                    // InternalAceGen.g:4738:4: (lv_isNotNull_1_0= 'notNull' )
                    // InternalAceGen.g:4739:5: lv_isNotNull_1_0= 'notNull'
                    {
                    lv_isNotNull_1_0=(Token)match(input,97,FOLLOW_2); 

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
                    // InternalAceGen.g:4752:3: ( (lv_isNull_2_0= 'null' ) )
                    {
                    // InternalAceGen.g:4752:3: ( (lv_isNull_2_0= 'null' ) )
                    // InternalAceGen.g:4753:4: (lv_isNull_2_0= 'null' )
                    {
                    // InternalAceGen.g:4753:4: (lv_isNull_2_0= 'null' )
                    // InternalAceGen.g:4754:5: lv_isNull_2_0= 'null'
                    {
                    lv_isNull_2_0=(Token)match(input,98,FOLLOW_2); 

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
    // InternalAceGen.g:4770:1: entryRuleDataDefinition returns [EObject current=null] : iv_ruleDataDefinition= ruleDataDefinition EOF ;
    public final EObject entryRuleDataDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDefinition = null;


        try {
            // InternalAceGen.g:4770:55: (iv_ruleDataDefinition= ruleDataDefinition EOF )
            // InternalAceGen.g:4771:2: iv_ruleDataDefinition= ruleDataDefinition EOF
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
    // InternalAceGen.g:4777:1: ruleDataDefinition returns [EObject current=null] : ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? ) ;
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
            // InternalAceGen.g:4783:2: ( ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? ) )
            // InternalAceGen.g:4784:2: ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? )
            {
            // InternalAceGen.g:4784:2: ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? )
            // InternalAceGen.g:4785:3: () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )?
            {
            // InternalAceGen.g:4785:3: ()
            // InternalAceGen.g:4786:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataDefinitionAccess().getDataDefinitionAction_0(),
            					current);
            			

            }

            // InternalAceGen.g:4792:3: (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==55) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // InternalAceGen.g:4793:4: otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,55,FOLLOW_52); 

                    				newLeafNode(otherlv_1, grammarAccess.getDataDefinitionAccess().getUuidKeyword_1_0());
                    			
                    // InternalAceGen.g:4797:4: ( (lv_uuid_2_0= RULE_STRING ) )
                    // InternalAceGen.g:4798:5: (lv_uuid_2_0= RULE_STRING )
                    {
                    // InternalAceGen.g:4798:5: (lv_uuid_2_0= RULE_STRING )
                    // InternalAceGen.g:4799:6: lv_uuid_2_0= RULE_STRING
                    {
                    lv_uuid_2_0=(Token)match(input,RULE_STRING,FOLLOW_115); 

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

            // InternalAceGen.g:4816:3: (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )?
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==99) ) {
                alt142=1;
            }
            switch (alt142) {
                case 1 :
                    // InternalAceGen.g:4817:4: otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,99,FOLLOW_52); 

                    				newLeafNode(otherlv_3, grammarAccess.getDataDefinitionAccess().getSystemTimeKeyword_2_0());
                    			
                    // InternalAceGen.g:4821:4: ( (lv_systemtime_4_0= RULE_STRING ) )
                    // InternalAceGen.g:4822:5: (lv_systemtime_4_0= RULE_STRING )
                    {
                    // InternalAceGen.g:4822:5: (lv_systemtime_4_0= RULE_STRING )
                    // InternalAceGen.g:4823:6: lv_systemtime_4_0= RULE_STRING
                    {
                    lv_systemtime_4_0=(Token)match(input,RULE_STRING,FOLLOW_52); 

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

                    // InternalAceGen.g:4839:4: ( (lv_pattern_5_0= RULE_STRING ) )
                    // InternalAceGen.g:4840:5: (lv_pattern_5_0= RULE_STRING )
                    {
                    // InternalAceGen.g:4840:5: (lv_pattern_5_0= RULE_STRING )
                    // InternalAceGen.g:4841:6: lv_pattern_5_0= RULE_STRING
                    {
                    lv_pattern_5_0=(Token)match(input,RULE_STRING,FOLLOW_116); 

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

            // InternalAceGen.g:4858:3: ( (lv_data_6_0= ruleJsonObject ) )?
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==39||LA143_0==116) ) {
                alt143=1;
            }
            switch (alt143) {
                case 1 :
                    // InternalAceGen.g:4859:4: (lv_data_6_0= ruleJsonObject )
                    {
                    // InternalAceGen.g:4859:4: (lv_data_6_0= ruleJsonObject )
                    // InternalAceGen.g:4860:5: lv_data_6_0= ruleJsonObject
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
    // InternalAceGen.g:4881:1: entryRuleAuthorization returns [EObject current=null] : iv_ruleAuthorization= ruleAuthorization EOF ;
    public final EObject entryRuleAuthorization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthorization = null;


        try {
            // InternalAceGen.g:4881:54: (iv_ruleAuthorization= ruleAuthorization EOF )
            // InternalAceGen.g:4882:2: iv_ruleAuthorization= ruleAuthorization EOF
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
    // InternalAceGen.g:4888:1: ruleAuthorization returns [EObject current=null] : (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleAuthorization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_username_1_0=null;
        Token otherlv_2=null;
        Token lv_password_3_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4894:2: ( (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) ) )
            // InternalAceGen.g:4895:2: (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) )
            {
            // InternalAceGen.g:4895:2: (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) )
            // InternalAceGen.g:4896:3: otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,100,FOLLOW_52); 

            			newLeafNode(otherlv_0, grammarAccess.getAuthorizationAccess().getAuthorizationKeyword_0());
            		
            // InternalAceGen.g:4900:3: ( (lv_username_1_0= RULE_STRING ) )
            // InternalAceGen.g:4901:4: (lv_username_1_0= RULE_STRING )
            {
            // InternalAceGen.g:4901:4: (lv_username_1_0= RULE_STRING )
            // InternalAceGen.g:4902:5: lv_username_1_0= RULE_STRING
            {
            lv_username_1_0=(Token)match(input,RULE_STRING,FOLLOW_56); 

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

            otherlv_2=(Token)match(input,59,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getAuthorizationAccess().getColonKeyword_2());
            		
            // InternalAceGen.g:4922:3: ( (lv_password_3_0= RULE_STRING ) )
            // InternalAceGen.g:4923:4: (lv_password_3_0= RULE_STRING )
            {
            // InternalAceGen.g:4923:4: (lv_password_3_0= RULE_STRING )
            // InternalAceGen.g:4924:5: lv_password_3_0= RULE_STRING
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
    // InternalAceGen.g:4944:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalAceGen.g:4944:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalAceGen.g:4945:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalAceGen.g:4951:1: ruleAttribute returns [EObject current=null] : ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_squishy_9_0= 'squishy' ) )? ) ;
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
            // InternalAceGen.g:4957:2: ( ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_squishy_9_0= 'squishy' ) )? ) )
            // InternalAceGen.g:4958:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_squishy_9_0= 'squishy' ) )? )
            {
            // InternalAceGen.g:4958:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_squishy_9_0= 'squishy' ) )? )
            // InternalAceGen.g:4959:3: ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_squishy_9_0= 'squishy' ) )?
            {
            // InternalAceGen.g:4959:3: ( (lv_unique_0_0= 'Unique' ) )?
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==101) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    // InternalAceGen.g:4960:4: (lv_unique_0_0= 'Unique' )
                    {
                    // InternalAceGen.g:4960:4: (lv_unique_0_0= 'Unique' )
                    // InternalAceGen.g:4961:5: lv_unique_0_0= 'Unique'
                    {
                    lv_unique_0_0=(Token)match(input,101,FOLLOW_117); 

                    					newLeafNode(lv_unique_0_0, grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "unique", lv_unique_0_0 != null, "Unique");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4973:3: ( (lv_primaryKey_1_0= 'PrimaryKey' ) )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==102) ) {
                alt145=1;
            }
            switch (alt145) {
                case 1 :
                    // InternalAceGen.g:4974:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    {
                    // InternalAceGen.g:4974:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    // InternalAceGen.g:4975:5: lv_primaryKey_1_0= 'PrimaryKey'
                    {
                    lv_primaryKey_1_0=(Token)match(input,102,FOLLOW_118); 

                    					newLeafNode(lv_primaryKey_1_0, grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "primaryKey", lv_primaryKey_1_0 != null, "PrimaryKey");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4987:3: ( (lv_notNull_2_0= 'NotNull' ) )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==86) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // InternalAceGen.g:4988:4: (lv_notNull_2_0= 'NotNull' )
                    {
                    // InternalAceGen.g:4988:4: (lv_notNull_2_0= 'NotNull' )
                    // InternalAceGen.g:4989:5: lv_notNull_2_0= 'NotNull'
                    {
                    lv_notNull_2_0=(Token)match(input,86,FOLLOW_119); 

                    					newLeafNode(lv_notNull_2_0, grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "notNull", lv_notNull_2_0 != null, "NotNull");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:5001:3: ( (lv_list_3_0= 'List' ) )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==32) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // InternalAceGen.g:5002:4: (lv_list_3_0= 'List' )
                    {
                    // InternalAceGen.g:5002:4: (lv_list_3_0= 'List' )
                    // InternalAceGen.g:5003:5: lv_list_3_0= 'List'
                    {
                    lv_list_3_0=(Token)match(input,32,FOLLOW_120); 

                    					newLeafNode(lv_list_3_0, grammarAccess.getAttributeAccess().getListListKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "list", lv_list_3_0 != null, "List");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:5015:3: ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) )
            int alt148=2;
            int LA148_0 = input.LA(1);

            if ( ((LA148_0>=109 && LA148_0<=115)) ) {
                alt148=1;
            }
            else if ( (LA148_0==RULE_ID) ) {
                alt148=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 148, 0, input);

                throw nvae;
            }
            switch (alt148) {
                case 1 :
                    // InternalAceGen.g:5016:4: ( (lv_type_4_0= ruleType ) )
                    {
                    // InternalAceGen.g:5016:4: ( (lv_type_4_0= ruleType ) )
                    // InternalAceGen.g:5017:5: (lv_type_4_0= ruleType )
                    {
                    // InternalAceGen.g:5017:5: (lv_type_4_0= ruleType )
                    // InternalAceGen.g:5018:6: lv_type_4_0= ruleType
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
                    // InternalAceGen.g:5036:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalAceGen.g:5036:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:5037:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:5037:5: ( ruleQualifiedName )
                    // InternalAceGen.g:5038:6: ruleQualifiedName
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

            // InternalAceGen.g:5053:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalAceGen.g:5054:4: (lv_name_6_0= RULE_ID )
            {
            // InternalAceGen.g:5054:4: (lv_name_6_0= RULE_ID )
            // InternalAceGen.g:5055:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_121); 

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

            // InternalAceGen.g:5071:3: (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )?
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==103) ) {
                alt149=1;
            }
            switch (alt149) {
                case 1 :
                    // InternalAceGen.g:5072:4: otherlv_7= 'references' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,103,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getReferencesKeyword_6_0());
                    			
                    // InternalAceGen.g:5076:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:5077:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:5077:5: ( ruleQualifiedName )
                    // InternalAceGen.g:5078:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_122);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:5093:3: ( (lv_squishy_9_0= 'squishy' ) )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==58) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // InternalAceGen.g:5094:4: (lv_squishy_9_0= 'squishy' )
                    {
                    // InternalAceGen.g:5094:4: (lv_squishy_9_0= 'squishy' )
                    // InternalAceGen.g:5095:5: lv_squishy_9_0= 'squishy'
                    {
                    lv_squishy_9_0=(Token)match(input,58,FOLLOW_2); 

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
    // InternalAceGen.g:5111:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalAceGen.g:5111:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalAceGen.g:5112:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalAceGen.g:5118:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalAceGen.g:5124:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalAceGen.g:5125:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalAceGen.g:5125:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalAceGen.g:5126:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_123); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalAceGen.g:5133:3: (kw= '.' this_ID_2= RULE_ID )*
            loop151:
            do {
                int alt151=2;
                int LA151_0 = input.LA(1);

                if ( (LA151_0==104) ) {
                    alt151=1;
                }


                switch (alt151) {
            	case 1 :
            	    // InternalAceGen.g:5134:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,104,FOLLOW_9); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_123); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop151;
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
    // InternalAceGen.g:5151:1: entryRuleWriteFunctionType returns [String current=null] : iv_ruleWriteFunctionType= ruleWriteFunctionType EOF ;
    public final String entryRuleWriteFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWriteFunctionType = null;


        try {
            // InternalAceGen.g:5151:57: (iv_ruleWriteFunctionType= ruleWriteFunctionType EOF )
            // InternalAceGen.g:5152:2: iv_ruleWriteFunctionType= ruleWriteFunctionType EOF
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
    // InternalAceGen.g:5158:1: ruleWriteFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) ;
    public final AntlrDatatypeRuleToken ruleWriteFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:5164:2: ( (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) )
            // InternalAceGen.g:5165:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            {
            // InternalAceGen.g:5165:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            int alt152=3;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt152=1;
                }
                break;
            case 106:
                {
                alt152=2;
                }
                break;
            case 107:
                {
                alt152=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 152, 0, input);

                throw nvae;
            }

            switch (alt152) {
                case 1 :
                    // InternalAceGen.g:5166:3: kw= 'POST'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:5172:3: kw= 'PUT'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:5178:3: kw= 'DELETE'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

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
    // InternalAceGen.g:5187:1: entryRuleReadFunctionType returns [String current=null] : iv_ruleReadFunctionType= ruleReadFunctionType EOF ;
    public final String entryRuleReadFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReadFunctionType = null;


        try {
            // InternalAceGen.g:5187:56: (iv_ruleReadFunctionType= ruleReadFunctionType EOF )
            // InternalAceGen.g:5188:2: iv_ruleReadFunctionType= ruleReadFunctionType EOF
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
    // InternalAceGen.g:5194:1: ruleReadFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'GET' ;
    public final AntlrDatatypeRuleToken ruleReadFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:5200:2: (kw= 'GET' )
            // InternalAceGen.g:5201:2: kw= 'GET'
            {
            kw=(Token)match(input,108,FOLLOW_2); 

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
    // InternalAceGen.g:5209:1: entryRuleType returns [String current=null] : iv_ruleType= ruleType EOF ;
    public final String entryRuleType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType = null;


        try {
            // InternalAceGen.g:5209:44: (iv_ruleType= ruleType EOF )
            // InternalAceGen.g:5210:2: iv_ruleType= ruleType EOF
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
    // InternalAceGen.g:5216:1: ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' | kw= 'FormData' ) ;
    public final AntlrDatatypeRuleToken ruleType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:5222:2: ( (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' | kw= 'FormData' ) )
            // InternalAceGen.g:5223:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' | kw= 'FormData' )
            {
            // InternalAceGen.g:5223:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' | kw= 'FormData' )
            int alt153=7;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt153=1;
                }
                break;
            case 110:
                {
                alt153=2;
                }
                break;
            case 111:
                {
                alt153=3;
                }
                break;
            case 112:
                {
                alt153=4;
                }
                break;
            case 113:
                {
                alt153=5;
                }
                break;
            case 114:
                {
                alt153=6;
                }
                break;
            case 115:
                {
                alt153=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 153, 0, input);

                throw nvae;
            }

            switch (alt153) {
                case 1 :
                    // InternalAceGen.g:5224:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getIntegerKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:5230:3: kw= 'String'
                    {
                    kw=(Token)match(input,110,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getStringKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:5236:3: kw= 'Float'
                    {
                    kw=(Token)match(input,111,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getFloatKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAceGen.g:5242:3: kw= 'Boolean'
                    {
                    kw=(Token)match(input,112,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getBooleanKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalAceGen.g:5248:3: kw= 'DateTime'
                    {
                    kw=(Token)match(input,113,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getDateTimeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalAceGen.g:5254:3: kw= 'Long'
                    {
                    kw=(Token)match(input,114,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getLongKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalAceGen.g:5260:3: kw= 'FormData'
                    {
                    kw=(Token)match(input,115,FOLLOW_2); 

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
    // InternalAceGen.g:5269:1: entryRuleJsonObject returns [EObject current=null] : iv_ruleJsonObject= ruleJsonObject EOF ;
    public final EObject entryRuleJsonObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObject = null;


        try {
            // InternalAceGen.g:5269:51: (iv_ruleJsonObject= ruleJsonObject EOF )
            // InternalAceGen.g:5270:2: iv_ruleJsonObject= ruleJsonObject EOF
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
    // InternalAceGen.g:5276:1: ruleJsonObject returns [EObject current=null] : (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) ) ;
    public final EObject ruleJsonObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_JsonObjectAce_0 = null;

        EObject this_StringType_2 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5282:2: ( (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) ) )
            // InternalAceGen.g:5283:2: (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) )
            {
            // InternalAceGen.g:5283:2: (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) )
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==39) ) {
                alt154=1;
            }
            else if ( (LA154_0==116) ) {
                alt154=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 154, 0, input);

                throw nvae;
            }
            switch (alt154) {
                case 1 :
                    // InternalAceGen.g:5284:3: this_JsonObjectAce_0= ruleJsonObjectAce
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
                    // InternalAceGen.g:5293:3: (otherlv_1= 'json' this_StringType_2= ruleStringType )
                    {
                    // InternalAceGen.g:5293:3: (otherlv_1= 'json' this_StringType_2= ruleStringType )
                    // InternalAceGen.g:5294:4: otherlv_1= 'json' this_StringType_2= ruleStringType
                    {
                    otherlv_1=(Token)match(input,116,FOLLOW_52); 

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
    // InternalAceGen.g:5311:1: entryRuleJsonObjectAce returns [EObject current=null] : iv_ruleJsonObjectAce= ruleJsonObjectAce EOF ;
    public final EObject entryRuleJsonObjectAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObjectAce = null;


        try {
            // InternalAceGen.g:5311:54: (iv_ruleJsonObjectAce= ruleJsonObjectAce EOF )
            // InternalAceGen.g:5312:2: iv_ruleJsonObjectAce= ruleJsonObjectAce EOF
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
    // InternalAceGen.g:5318:1: ruleJsonObjectAce returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleJsonObjectAce() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_members_2_0 = null;

        EObject lv_members_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5324:2: ( ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' ) )
            // InternalAceGen.g:5325:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' )
            {
            // InternalAceGen.g:5325:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' )
            // InternalAceGen.g:5326:3: () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}'
            {
            // InternalAceGen.g:5326:3: ()
            // InternalAceGen.g:5327:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonObjectAceAccess().getJsonObjectAceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,39,FOLLOW_65); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonObjectAceAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:5337:3: ( (lv_members_2_0= ruleJsonMember ) )?
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==RULE_ID) ) {
                alt155=1;
            }
            switch (alt155) {
                case 1 :
                    // InternalAceGen.g:5338:4: (lv_members_2_0= ruleJsonMember )
                    {
                    // InternalAceGen.g:5338:4: (lv_members_2_0= ruleJsonMember )
                    // InternalAceGen.g:5339:5: lv_members_2_0= ruleJsonMember
                    {

                    					newCompositeNode(grammarAccess.getJsonObjectAceAccess().getMembersJsonMemberParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_66);
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

            // InternalAceGen.g:5356:3: (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )*
            loop156:
            do {
                int alt156=2;
                int LA156_0 = input.LA(1);

                if ( (LA156_0==19) ) {
                    alt156=1;
                }


                switch (alt156) {
            	case 1 :
            	    // InternalAceGen.g:5357:4: otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_9); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonObjectAceAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:5361:4: ( (lv_members_4_0= ruleJsonMember ) )
            	    // InternalAceGen.g:5362:5: (lv_members_4_0= ruleJsonMember )
            	    {
            	    // InternalAceGen.g:5362:5: (lv_members_4_0= ruleJsonMember )
            	    // InternalAceGen.g:5363:6: lv_members_4_0= ruleJsonMember
            	    {

            	    						newCompositeNode(grammarAccess.getJsonObjectAceAccess().getMembersJsonMemberParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_66);
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
            	    break loop156;
                }
            } while (true);

            otherlv_5=(Token)match(input,42,FOLLOW_2); 

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
    // InternalAceGen.g:5389:1: entryRuleJsonMember returns [EObject current=null] : iv_ruleJsonMember= ruleJsonMember EOF ;
    public final EObject entryRuleJsonMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonMember = null;


        try {
            // InternalAceGen.g:5389:51: (iv_ruleJsonMember= ruleJsonMember EOF )
            // InternalAceGen.g:5390:2: iv_ruleJsonMember= ruleJsonMember EOF
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
    // InternalAceGen.g:5396:1: ruleJsonMember returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) ) ;
    public final EObject ruleJsonMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5402:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) ) )
            // InternalAceGen.g:5403:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) )
            {
            // InternalAceGen.g:5403:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) )
            // InternalAceGen.g:5404:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) )
            {
            // InternalAceGen.g:5404:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:5405:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:5405:4: ( ruleQualifiedName )
            // InternalAceGen.g:5406:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonMemberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJsonMemberAccess().getAttributeAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_56);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,59,FOLLOW_124); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonMemberAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:5424:3: ( (lv_value_2_0= ruleJsonValue ) )
            // InternalAceGen.g:5425:4: (lv_value_2_0= ruleJsonValue )
            {
            // InternalAceGen.g:5425:4: (lv_value_2_0= ruleJsonValue )
            // InternalAceGen.g:5426:5: lv_value_2_0= ruleJsonValue
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
    // InternalAceGen.g:5447:1: entryRuleJsonValue returns [EObject current=null] : iv_ruleJsonValue= ruleJsonValue EOF ;
    public final EObject entryRuleJsonValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonValue = null;


        try {
            // InternalAceGen.g:5447:50: (iv_ruleJsonValue= ruleJsonValue EOF )
            // InternalAceGen.g:5448:2: iv_ruleJsonValue= ruleJsonValue EOF
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
    // InternalAceGen.g:5454:1: ruleJsonValue returns [EObject current=null] : (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime ) ;
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
            // InternalAceGen.g:5460:2: ( (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime ) )
            // InternalAceGen.g:5461:2: (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime )
            {
            // InternalAceGen.g:5461:2: (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime )
            int alt157=7;
            switch ( input.LA(1) ) {
            case 39:
            case 116:
                {
                alt157=1;
                }
                break;
            case RULE_STRING:
                {
                int LA157_2 = input.LA(2);

                if ( (LA157_2==RULE_STRING) ) {
                    alt157=7;
                }
                else if ( (LA157_2==EOF||LA157_2==19||LA157_2==42||LA157_2==66) ) {
                    alt157=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 157, 2, input);

                    throw nvae;
                }
                }
                break;
            case 65:
                {
                alt157=3;
                }
                break;
            case 118:
            case 119:
                {
                alt157=4;
                }
                break;
            case 98:
                {
                alt157=5;
                }
                break;
            case RULE_INT:
                {
                alt157=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 157, 0, input);

                throw nvae;
            }

            switch (alt157) {
                case 1 :
                    // InternalAceGen.g:5462:3: this_JsonObject_0= ruleJsonObject
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
                    // InternalAceGen.g:5471:3: this_StringType_1= ruleStringType
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
                    // InternalAceGen.g:5480:3: this_JsonArray_2= ruleJsonArray
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
                    // InternalAceGen.g:5489:3: this_BooleanType_3= ruleBooleanType
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
                    // InternalAceGen.g:5498:3: this_NullType_4= ruleNullType
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
                    // InternalAceGen.g:5507:3: this_LongType_5= ruleLongType
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
                    // InternalAceGen.g:5516:3: this_JsonDateTime_6= ruleJsonDateTime
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
    // InternalAceGen.g:5528:1: entryRuleJsonArray returns [EObject current=null] : iv_ruleJsonArray= ruleJsonArray EOF ;
    public final EObject entryRuleJsonArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonArray = null;


        try {
            // InternalAceGen.g:5528:50: (iv_ruleJsonArray= ruleJsonArray EOF )
            // InternalAceGen.g:5529:2: iv_ruleJsonArray= ruleJsonArray EOF
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
    // InternalAceGen.g:5535:1: ruleJsonArray returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleJsonArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5541:2: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' ) )
            // InternalAceGen.g:5542:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' )
            {
            // InternalAceGen.g:5542:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' )
            // InternalAceGen.g:5543:3: () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']'
            {
            // InternalAceGen.g:5543:3: ()
            // InternalAceGen.g:5544:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonArrayAccess().getJsonArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,65,FOLLOW_125); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonArrayAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalAceGen.g:5554:3: ( (lv_values_2_0= ruleJsonValue ) )?
            int alt158=2;
            int LA158_0 = input.LA(1);

            if ( ((LA158_0>=RULE_INT && LA158_0<=RULE_STRING)||LA158_0==39||LA158_0==65||LA158_0==98||LA158_0==116||(LA158_0>=118 && LA158_0<=119)) ) {
                alt158=1;
            }
            switch (alt158) {
                case 1 :
                    // InternalAceGen.g:5555:4: (lv_values_2_0= ruleJsonValue )
                    {
                    // InternalAceGen.g:5555:4: (lv_values_2_0= ruleJsonValue )
                    // InternalAceGen.g:5556:5: lv_values_2_0= ruleJsonValue
                    {

                    					newCompositeNode(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_68);
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

            // InternalAceGen.g:5573:3: (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )*
            loop159:
            do {
                int alt159=2;
                int LA159_0 = input.LA(1);

                if ( (LA159_0==19) ) {
                    alt159=1;
                }


                switch (alt159) {
            	case 1 :
            	    // InternalAceGen.g:5574:4: otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_124); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonArrayAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:5578:4: ( (lv_values_4_0= ruleJsonValue ) )
            	    // InternalAceGen.g:5579:5: (lv_values_4_0= ruleJsonValue )
            	    {
            	    // InternalAceGen.g:5579:5: (lv_values_4_0= ruleJsonValue )
            	    // InternalAceGen.g:5580:6: lv_values_4_0= ruleJsonValue
            	    {

            	    						newCompositeNode(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_68);
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
            	    break loop159;
                }
            } while (true);

            otherlv_5=(Token)match(input,66,FOLLOW_2); 

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
    // InternalAceGen.g:5606:1: entryRuleJsonDateTime returns [EObject current=null] : iv_ruleJsonDateTime= ruleJsonDateTime EOF ;
    public final EObject entryRuleJsonDateTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonDateTime = null;


        try {
            // InternalAceGen.g:5606:53: (iv_ruleJsonDateTime= ruleJsonDateTime EOF )
            // InternalAceGen.g:5607:2: iv_ruleJsonDateTime= ruleJsonDateTime EOF
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
    // InternalAceGen.g:5613:1: ruleJsonDateTime returns [EObject current=null] : ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleJsonDateTime() throws RecognitionException {
        EObject current = null;

        Token lv_dateTime_0_0=null;
        Token lv_pattern_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5619:2: ( ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) ) )
            // InternalAceGen.g:5620:2: ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) )
            {
            // InternalAceGen.g:5620:2: ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) )
            // InternalAceGen.g:5621:3: ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) )
            {
            // InternalAceGen.g:5621:3: ( (lv_dateTime_0_0= RULE_STRING ) )
            // InternalAceGen.g:5622:4: (lv_dateTime_0_0= RULE_STRING )
            {
            // InternalAceGen.g:5622:4: (lv_dateTime_0_0= RULE_STRING )
            // InternalAceGen.g:5623:5: lv_dateTime_0_0= RULE_STRING
            {
            lv_dateTime_0_0=(Token)match(input,RULE_STRING,FOLLOW_52); 

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

            // InternalAceGen.g:5639:3: ( (lv_pattern_1_0= RULE_STRING ) )
            // InternalAceGen.g:5640:4: (lv_pattern_1_0= RULE_STRING )
            {
            // InternalAceGen.g:5640:4: (lv_pattern_1_0= RULE_STRING )
            // InternalAceGen.g:5641:5: lv_pattern_1_0= RULE_STRING
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
    // InternalAceGen.g:5661:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // InternalAceGen.g:5661:51: (iv_ruleStringType= ruleStringType EOF )
            // InternalAceGen.g:5662:2: iv_ruleStringType= ruleStringType EOF
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
    // InternalAceGen.g:5668:1: ruleStringType returns [EObject current=null] : ( (lv_string_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringType() throws RecognitionException {
        EObject current = null;

        Token lv_string_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5674:2: ( ( (lv_string_0_0= RULE_STRING ) ) )
            // InternalAceGen.g:5675:2: ( (lv_string_0_0= RULE_STRING ) )
            {
            // InternalAceGen.g:5675:2: ( (lv_string_0_0= RULE_STRING ) )
            // InternalAceGen.g:5676:3: (lv_string_0_0= RULE_STRING )
            {
            // InternalAceGen.g:5676:3: (lv_string_0_0= RULE_STRING )
            // InternalAceGen.g:5677:4: lv_string_0_0= RULE_STRING
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
    // InternalAceGen.g:5696:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // InternalAceGen.g:5696:52: (iv_ruleBooleanType= ruleBooleanType EOF )
            // InternalAceGen.g:5697:2: iv_ruleBooleanType= ruleBooleanType EOF
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
    // InternalAceGen.g:5703:1: ruleBooleanType returns [EObject current=null] : ( (lv_boolean_0_0= ruleJsonBoolean ) ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_boolean_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5709:2: ( ( (lv_boolean_0_0= ruleJsonBoolean ) ) )
            // InternalAceGen.g:5710:2: ( (lv_boolean_0_0= ruleJsonBoolean ) )
            {
            // InternalAceGen.g:5710:2: ( (lv_boolean_0_0= ruleJsonBoolean ) )
            // InternalAceGen.g:5711:3: (lv_boolean_0_0= ruleJsonBoolean )
            {
            // InternalAceGen.g:5711:3: (lv_boolean_0_0= ruleJsonBoolean )
            // InternalAceGen.g:5712:4: lv_boolean_0_0= ruleJsonBoolean
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
    // InternalAceGen.g:5732:1: entryRuleNullType returns [EObject current=null] : iv_ruleNullType= ruleNullType EOF ;
    public final EObject entryRuleNullType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullType = null;


        try {
            // InternalAceGen.g:5732:49: (iv_ruleNullType= ruleNullType EOF )
            // InternalAceGen.g:5733:2: iv_ruleNullType= ruleNullType EOF
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
    // InternalAceGen.g:5739:1: ruleNullType returns [EObject current=null] : ( (lv_null_0_0= 'null' ) ) ;
    public final EObject ruleNullType() throws RecognitionException {
        EObject current = null;

        Token lv_null_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5745:2: ( ( (lv_null_0_0= 'null' ) ) )
            // InternalAceGen.g:5746:2: ( (lv_null_0_0= 'null' ) )
            {
            // InternalAceGen.g:5746:2: ( (lv_null_0_0= 'null' ) )
            // InternalAceGen.g:5747:3: (lv_null_0_0= 'null' )
            {
            // InternalAceGen.g:5747:3: (lv_null_0_0= 'null' )
            // InternalAceGen.g:5748:4: lv_null_0_0= 'null'
            {
            lv_null_0_0=(Token)match(input,98,FOLLOW_2); 

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
    // InternalAceGen.g:5763:1: entryRuleUndefinedType returns [EObject current=null] : iv_ruleUndefinedType= ruleUndefinedType EOF ;
    public final EObject entryRuleUndefinedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUndefinedType = null;


        try {
            // InternalAceGen.g:5763:54: (iv_ruleUndefinedType= ruleUndefinedType EOF )
            // InternalAceGen.g:5764:2: iv_ruleUndefinedType= ruleUndefinedType EOF
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
    // InternalAceGen.g:5770:1: ruleUndefinedType returns [EObject current=null] : ( (lv_undefined_0_0= 'undefined' ) ) ;
    public final EObject ruleUndefinedType() throws RecognitionException {
        EObject current = null;

        Token lv_undefined_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5776:2: ( ( (lv_undefined_0_0= 'undefined' ) ) )
            // InternalAceGen.g:5777:2: ( (lv_undefined_0_0= 'undefined' ) )
            {
            // InternalAceGen.g:5777:2: ( (lv_undefined_0_0= 'undefined' ) )
            // InternalAceGen.g:5778:3: (lv_undefined_0_0= 'undefined' )
            {
            // InternalAceGen.g:5778:3: (lv_undefined_0_0= 'undefined' )
            // InternalAceGen.g:5779:4: lv_undefined_0_0= 'undefined'
            {
            lv_undefined_0_0=(Token)match(input,117,FOLLOW_2); 

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
    // InternalAceGen.g:5794:1: entryRuleLongType returns [EObject current=null] : iv_ruleLongType= ruleLongType EOF ;
    public final EObject entryRuleLongType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongType = null;


        try {
            // InternalAceGen.g:5794:49: (iv_ruleLongType= ruleLongType EOF )
            // InternalAceGen.g:5795:2: iv_ruleLongType= ruleLongType EOF
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
    // InternalAceGen.g:5801:1: ruleLongType returns [EObject current=null] : ( (lv_long_0_0= RULE_INT ) ) ;
    public final EObject ruleLongType() throws RecognitionException {
        EObject current = null;

        Token lv_long_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5807:2: ( ( (lv_long_0_0= RULE_INT ) ) )
            // InternalAceGen.g:5808:2: ( (lv_long_0_0= RULE_INT ) )
            {
            // InternalAceGen.g:5808:2: ( (lv_long_0_0= RULE_INT ) )
            // InternalAceGen.g:5809:3: (lv_long_0_0= RULE_INT )
            {
            // InternalAceGen.g:5809:3: (lv_long_0_0= RULE_INT )
            // InternalAceGen.g:5810:4: lv_long_0_0= RULE_INT
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
    // InternalAceGen.g:5829:1: entryRuleJsonBoolean returns [String current=null] : iv_ruleJsonBoolean= ruleJsonBoolean EOF ;
    public final String entryRuleJsonBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleJsonBoolean = null;


        try {
            // InternalAceGen.g:5829:51: (iv_ruleJsonBoolean= ruleJsonBoolean EOF )
            // InternalAceGen.g:5830:2: iv_ruleJsonBoolean= ruleJsonBoolean EOF
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
    // InternalAceGen.g:5836:1: ruleJsonBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleJsonBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:5842:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalAceGen.g:5843:2: (kw= 'true' | kw= 'false' )
            {
            // InternalAceGen.g:5843:2: (kw= 'true' | kw= 'false' )
            int alt160=2;
            int LA160_0 = input.LA(1);

            if ( (LA160_0==118) ) {
                alt160=1;
            }
            else if ( (LA160_0==119) ) {
                alt160=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 160, 0, input);

                throw nvae;
            }
            switch (alt160) {
                case 1 :
                    // InternalAceGen.g:5844:3: kw= 'true'
                    {
                    kw=(Token)match(input,118,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJsonBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:5850:3: kw= 'false'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); 

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
    // InternalAceGen.g:5859:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalAceGen.g:5859:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalAceGen.g:5860:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalAceGen.g:5866:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_string_0_0=null;
        Token lv_long_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5872:2: ( ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) ) )
            // InternalAceGen.g:5873:2: ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) )
            {
            // InternalAceGen.g:5873:2: ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) )
            int alt161=2;
            int LA161_0 = input.LA(1);

            if ( (LA161_0==RULE_STRING) ) {
                alt161=1;
            }
            else if ( (LA161_0==RULE_INT) ) {
                alt161=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 161, 0, input);

                throw nvae;
            }
            switch (alt161) {
                case 1 :
                    // InternalAceGen.g:5874:3: ( (lv_string_0_0= RULE_STRING ) )
                    {
                    // InternalAceGen.g:5874:3: ( (lv_string_0_0= RULE_STRING ) )
                    // InternalAceGen.g:5875:4: (lv_string_0_0= RULE_STRING )
                    {
                    // InternalAceGen.g:5875:4: (lv_string_0_0= RULE_STRING )
                    // InternalAceGen.g:5876:5: lv_string_0_0= RULE_STRING
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
                    // InternalAceGen.g:5893:3: ( (lv_long_1_0= RULE_INT ) )
                    {
                    // InternalAceGen.g:5893:3: ( (lv_long_1_0= RULE_INT ) )
                    // InternalAceGen.g:5894:4: (lv_long_1_0= RULE_INT )
                    {
                    // InternalAceGen.g:5894:4: (lv_long_1_0= RULE_INT )
                    // InternalAceGen.g:5895:5: lv_long_1_0= RULE_INT
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


    protected DFA66 dfa66 = new DFA66(this);
    protected DFA86 dfa86 = new DFA86(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\2\uffff\1\10\7\uffff";
    static final String dfa_3s = "\1\5\1\uffff\1\4\7\uffff";
    static final String dfa_4s = "\1\167\1\uffff\1\102\7\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\1\10\1\2\1\7";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\6\1\2\40\uffff\1\1\31\uffff\1\3\40\uffff\1\5\22\uffff\1\7\2\4",
            "",
            "\1\10\1\uffff\1\11\14\uffff\1\10\26\uffff\1\10\7\uffff\1\10\12\uffff\1\10\4\uffff\1\10",
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

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2203:2: (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType )";
        }
    }
    static final String dfa_8s = "\11\uffff";
    static final String dfa_9s = "\1\4\1\116\1\4\1\117\1\4\1\151\1\117\2\uffff";
    static final String dfa_10s = "\1\4\1\116\1\4\1\150\1\4\1\154\1\150\2\uffff";
    static final String dfa_11s = "\7\uffff\1\2\1\1";
    static final String dfa_12s = "\11\uffff}>";
    static final String[] dfa_13s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\5\30\uffff\1\4",
            "\1\6",
            "\3\10\1\7",
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

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2654:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L,0x00000000000003F8L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000016002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000034012L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000F80008010L});
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
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000F00000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000E00000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000C00000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0001F8F000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0001F8E000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0001F8C000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0001F88000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000070F80008010L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000060000000040L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000040000000040L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x000A000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x000A000000000010L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0010000008000012L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0010000008000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0040000000040002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0080040000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0700040000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0600040000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0400040000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x2000000000000012L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000008000000060L,0x00E0000400000002L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000040000080010L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000040000080000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000008000080060L,0x00E0000400000006L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000004L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000010L,0x00000000000003F0L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000010L,0x00000000000003E0L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000010L,0x00000000000003C0L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000380L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000200L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000012002L,0x0000000000003C00L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000012002L,0x0000000000003800L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000012002L,0x0000000000003000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000010012L,0x0000000000003000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000010012L,0x0000000000802000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000010012L,0x0000000001000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x00000E0000000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000002000002L,0x00000000003F0000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000002000002L,0x00000000003E0000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000002000002L,0x00000000003C0000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000002000012L,0x0000000000780000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000002000012L,0x0000000000700000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000002000012L,0x0000000000600000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000002000012L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000002L,0x00000000003D0000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000002L,0x00000000003C0000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000012L,0x0000000000780000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000012L,0x0000000000700000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000012L,0x0000000000600000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000040000000010L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000040100000010L,0x000FE06000400000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000008000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000008000080002L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000100060L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0020000000000022L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0080008000000000L,0x0010001900000000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000000002L,0x0000001100000000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x2000000000000002L,0x0000000010200000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x2080008000000000L,0x0010000810000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x2000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000000000L,0x00000000E0000000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0000008000000000L,0x0010000600000000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000008000000002L,0x0010000800000000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000008000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000100000010L,0x000FE04000400000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000100000010L,0x000FE00000400000L});
    public static final BitSet FOLLOW_119 = new BitSet(new long[]{0x0000000100000010L,0x000FE00000000000L});
    public static final BitSet FOLLOW_120 = new BitSet(new long[]{0x0000000000000010L,0x000FE00000000000L});
    public static final BitSet FOLLOW_121 = new BitSet(new long[]{0x0400000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_122 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_123 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_124 = new BitSet(new long[]{0x0000008000000060L,0x00D0000400000002L});
    public static final BitSet FOLLOW_125 = new BitSet(new long[]{0x0000008000080060L,0x00D0000400000006L});

}