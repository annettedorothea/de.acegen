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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'HttpClient'", "'HttpServer'", "'ACE'", "'ui'", "'React_16.8'", "'scenarios'", "'async'", "'('", "','", "')'", "'fromAppState'", "'call'", "'loadingFlag'", "'as'", "'on'", "'triggers'", "'delayInMillis'", "'set'", "'merge'", "'group'", "'noComponent'", "'List'", "'location.hash'", "'storage'", "'{'", "'}'", "'GIVEN'", "'WHEN'", "'THEN'", "'nonDeterministicValues'", "'uuid'", "'clientSystemTime'", "'serverSystemTime'", "'nonDeterministic'", "':'", "'expectedState'", "'verifications'", "'shouldBe'", "'['", "']'", "'Java'", "'Dropwizard'", "'JDBI3'", "'Liquibase'", "'Authorization'", "'import'", "'views'", "'models'", "'<'", "'>'", "'authorize'", "'pathParams'", "'queryParams'", "'payload'", "'response'", "'NotNull'", "'afterCommit'", "'persistent'", "'extends'", "'x'", "'excludeGIVEN'", "'persistence'", "'selectByPrimaryKey'", "'selectBy'", "'filterAndCountBy'", "'extract'", "'notNull'", "'null'", "'systemTime'", "'authorization'", "'Unique'", "'PrimaryKey'", "'references'", "'.'", "'POST'", "'PUT'", "'DELETE'", "'GET'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'Long'", "'json'", "'undefined'", "'true'", "'false'"
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
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
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

                    if ( (LA2_0==51) ) {
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
    // InternalAceGen.g:150:1: ruleHttpClient returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'ui' ( (lv_react16_8_4_0= 'React_16.8' ) )? ( (lv_container_5_0= ruleSingleClientAttribute ) ) )? (otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )* )? ) ;
    public final EObject ruleHttpClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_react16_8_4_0=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_aceOperations_2_0 = null;

        EObject lv_container_5_0 = null;

        EObject lv_scenarios_7_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:156:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'ui' ( (lv_react16_8_4_0= 'React_16.8' ) )? ( (lv_container_5_0= ruleSingleClientAttribute ) ) )? (otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )* )? ) )
            // InternalAceGen.g:157:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'ui' ( (lv_react16_8_4_0= 'React_16.8' ) )? ( (lv_container_5_0= ruleSingleClientAttribute ) ) )? (otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )* )? )
            {
            // InternalAceGen.g:157:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'ui' ( (lv_react16_8_4_0= 'React_16.8' ) )? ( (lv_container_5_0= ruleSingleClientAttribute ) ) )? (otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )* )? )
            // InternalAceGen.g:158:3: ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'ui' ( (lv_react16_8_4_0= 'React_16.8' ) )? ( (lv_container_5_0= ruleSingleClientAttribute ) ) )? (otherlv_6= 'scenarios' ( (lv_scenarios_7_0= ruleClientScenario ) )* )?
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

            // InternalAceGen.g:202:3: (otherlv_3= 'ui' ( (lv_react16_8_4_0= 'React_16.8' ) )? ( (lv_container_5_0= ruleSingleClientAttribute ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalAceGen.g:203:4: otherlv_3= 'ui' ( (lv_react16_8_4_0= 'React_16.8' ) )? ( (lv_container_5_0= ruleSingleClientAttribute ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getHttpClientAccess().getUiKeyword_2_0());
                    			
                    // InternalAceGen.g:207:4: ( (lv_react16_8_4_0= 'React_16.8' ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==15) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalAceGen.g:208:5: (lv_react16_8_4_0= 'React_16.8' )
                            {
                            // InternalAceGen.g:208:5: (lv_react16_8_4_0= 'React_16.8' )
                            // InternalAceGen.g:209:6: lv_react16_8_4_0= 'React_16.8'
                            {
                            lv_react16_8_4_0=(Token)match(input,15,FOLLOW_7); 

                            						newLeafNode(lv_react16_8_4_0, grammarAccess.getHttpClientAccess().getReact16_8React_168Keyword_2_1_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getHttpClientRule());
                            						}
                            						setWithLastConsumed(current, "react16_8", lv_react16_8_4_0 != null, "React_16.8");
                            					

                            }


                            }
                            break;

                    }

                    // InternalAceGen.g:221:4: ( (lv_container_5_0= ruleSingleClientAttribute ) )
                    // InternalAceGen.g:222:5: (lv_container_5_0= ruleSingleClientAttribute )
                    {
                    // InternalAceGen.g:222:5: (lv_container_5_0= ruleSingleClientAttribute )
                    // InternalAceGen.g:223:6: lv_container_5_0= ruleSingleClientAttribute
                    {

                    						newCompositeNode(grammarAccess.getHttpClientAccess().getContainerSingleClientAttributeParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_container_5_0=ruleSingleClientAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHttpClientRule());
                    						}
                    						set(
                    							current,
                    							"container",
                    							lv_container_5_0,
                    							"de.acegen.AceGen.SingleClientAttribute");
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
                    					

                    						newCompositeNode(grammarAccess.getHttpClientAceAccess().getLoadingFlagSingleClientAttributeCrossReference_5_1_0());
                    					
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
            				

            					newCompositeNode(grammarAccess.getFromAppStateRefAccess().getStateElementSingleClientAttributeCrossReference_0_0());
            				
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

                        if ( ((LA19_0>=28 && LA19_0<=29)) ) {
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
    // InternalAceGen.g:700:1: ruleTriggerdAceOperation returns [EObject current=null] : ( (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleTriggerdAceOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_delay_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:706:2: ( ( (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) )? ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:707:2: ( (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) )? ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:707:2: ( (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) )? ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:708:3: (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) )? ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:708:3: (otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==27) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalAceGen.g:709:4: otherlv_0= 'delayInMillis' ( (lv_delay_1_0= RULE_INT ) )
                    {
                    otherlv_0=(Token)match(input,27,FOLLOW_22); 

                    				newLeafNode(otherlv_0, grammarAccess.getTriggerdAceOperationAccess().getDelayInMillisKeyword_0_0());
                    			
                    // InternalAceGen.g:713:4: ( (lv_delay_1_0= RULE_INT ) )
                    // InternalAceGen.g:714:5: (lv_delay_1_0= RULE_INT )
                    {
                    // InternalAceGen.g:714:5: (lv_delay_1_0= RULE_INT )
                    // InternalAceGen.g:715:6: lv_delay_1_0= RULE_INT
                    {
                    lv_delay_1_0=(Token)match(input,RULE_INT,FOLLOW_9); 

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


                    }
                    break;

            }

            // InternalAceGen.g:732:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:733:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:733:4: ( ruleQualifiedName )
            // InternalAceGen.g:734:5: ruleQualifiedName
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
    // InternalAceGen.g:752:1: entryRuleHttpClientStateFunction returns [EObject current=null] : iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF ;
    public final EObject entryRuleHttpClientStateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientStateFunction = null;


        try {
            // InternalAceGen.g:752:64: (iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF )
            // InternalAceGen.g:753:2: iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF
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
    // InternalAceGen.g:759:1: ruleHttpClientStateFunction returns [EObject current=null] : ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleHttpClientStateFunction() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_stateFunctionType_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:765:2: ( ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:766:2: ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:766:2: ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:767:3: ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:767:3: ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) )
            // InternalAceGen.g:768:4: (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType )
            {
            // InternalAceGen.g:768:4: (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType )
            // InternalAceGen.g:769:5: lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType
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

            // InternalAceGen.g:786:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:787:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:787:4: ( ruleQualifiedName )
            // InternalAceGen.g:788:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpClientStateFunctionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpClientStateFunctionAccess().getStateElementSingleClientAttributeCrossReference_1_0());
            				
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
    // InternalAceGen.g:806:1: entryRuleHttpClientStateFunctionType returns [String current=null] : iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF ;
    public final String entryRuleHttpClientStateFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHttpClientStateFunctionType = null;


        try {
            // InternalAceGen.g:806:67: (iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF )
            // InternalAceGen.g:807:2: iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF
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
    // InternalAceGen.g:813:1: ruleHttpClientStateFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'set' | kw= 'merge' ) ;
    public final AntlrDatatypeRuleToken ruleHttpClientStateFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:819:2: ( (kw= 'set' | kw= 'merge' ) )
            // InternalAceGen.g:820:2: (kw= 'set' | kw= 'merge' )
            {
            // InternalAceGen.g:820:2: (kw= 'set' | kw= 'merge' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            else if ( (LA24_0==29) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalAceGen.g:821:3: kw= 'set'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:827:3: kw= 'merge'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

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
    // InternalAceGen.g:836:1: entryRuleClientAttribute returns [EObject current=null] : iv_ruleClientAttribute= ruleClientAttribute EOF ;
    public final EObject entryRuleClientAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientAttribute = null;


        try {
            // InternalAceGen.g:836:56: (iv_ruleClientAttribute= ruleClientAttribute EOF )
            // InternalAceGen.g:837:2: iv_ruleClientAttribute= ruleClientAttribute EOF
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
    // InternalAceGen.g:843:1: ruleClientAttribute returns [EObject current=null] : (this_SingleClientAttribute_0= ruleSingleClientAttribute | (otherlv_1= 'group' this_GroupedClientAttribute_2= ruleGroupedClientAttribute ) ) ;
    public final EObject ruleClientAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_SingleClientAttribute_0 = null;

        EObject this_GroupedClientAttribute_2 = null;



        	enterRule();

        try {
            // InternalAceGen.g:849:2: ( (this_SingleClientAttribute_0= ruleSingleClientAttribute | (otherlv_1= 'group' this_GroupedClientAttribute_2= ruleGroupedClientAttribute ) ) )
            // InternalAceGen.g:850:2: (this_SingleClientAttribute_0= ruleSingleClientAttribute | (otherlv_1= 'group' this_GroupedClientAttribute_2= ruleGroupedClientAttribute ) )
            {
            // InternalAceGen.g:850:2: (this_SingleClientAttribute_0= ruleSingleClientAttribute | (otherlv_1= 'group' this_GroupedClientAttribute_2= ruleGroupedClientAttribute ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID||(LA25_0>=31 && LA25_0<=32)) ) {
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
                    // InternalAceGen.g:851:3: this_SingleClientAttribute_0= ruleSingleClientAttribute
                    {

                    			newCompositeNode(grammarAccess.getClientAttributeAccess().getSingleClientAttributeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SingleClientAttribute_0=ruleSingleClientAttribute();

                    state._fsp--;


                    			current = this_SingleClientAttribute_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:860:3: (otherlv_1= 'group' this_GroupedClientAttribute_2= ruleGroupedClientAttribute )
                    {
                    // InternalAceGen.g:860:3: (otherlv_1= 'group' this_GroupedClientAttribute_2= ruleGroupedClientAttribute )
                    // InternalAceGen.g:861:4: otherlv_1= 'group' this_GroupedClientAttribute_2= ruleGroupedClientAttribute
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientAttributeAccess().getGroupKeyword_1_0());
                    			

                    				newCompositeNode(grammarAccess.getClientAttributeAccess().getGroupedClientAttributeParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_2);
                    this_GroupedClientAttribute_2=ruleGroupedClientAttribute();

                    state._fsp--;


                    				current = this_GroupedClientAttribute_2;
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
    // $ANTLR end "ruleClientAttribute"


    // $ANTLR start "entryRuleSingleClientAttribute"
    // InternalAceGen.g:878:1: entryRuleSingleClientAttribute returns [EObject current=null] : iv_ruleSingleClientAttribute= ruleSingleClientAttribute EOF ;
    public final EObject entryRuleSingleClientAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleClientAttribute = null;


        try {
            // InternalAceGen.g:878:62: (iv_ruleSingleClientAttribute= ruleSingleClientAttribute EOF )
            // InternalAceGen.g:879:2: iv_ruleSingleClientAttribute= ruleSingleClientAttribute EOF
            {
             newCompositeNode(grammarAccess.getSingleClientAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleClientAttribute=ruleSingleClientAttribute();

            state._fsp--;

             current =iv_ruleSingleClientAttribute; 
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
    // $ANTLR end "entryRuleSingleClientAttribute"


    // $ANTLR start "ruleSingleClientAttribute"
    // InternalAceGen.g:885:1: ruleSingleClientAttribute returns [EObject current=null] : ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (lv_hash_3_0= 'location.hash' ) )? ( (lv_storage_4_0= 'storage' ) )? (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* otherlv_7= '}' )? ) ;
    public final EObject ruleSingleClientAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_noComponent_0_0=null;
        Token lv_list_1_0=null;
        Token lv_name_2_0=null;
        Token lv_hash_3_0=null;
        Token lv_storage_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_attributes_6_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:891:2: ( ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (lv_hash_3_0= 'location.hash' ) )? ( (lv_storage_4_0= 'storage' ) )? (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* otherlv_7= '}' )? ) )
            // InternalAceGen.g:892:2: ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (lv_hash_3_0= 'location.hash' ) )? ( (lv_storage_4_0= 'storage' ) )? (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* otherlv_7= '}' )? )
            {
            // InternalAceGen.g:892:2: ( ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (lv_hash_3_0= 'location.hash' ) )? ( (lv_storage_4_0= 'storage' ) )? (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* otherlv_7= '}' )? )
            // InternalAceGen.g:893:3: ( (lv_noComponent_0_0= 'noComponent' ) )? ( (lv_list_1_0= 'List' ) )? ( (lv_name_2_0= RULE_ID ) ) ( (lv_hash_3_0= 'location.hash' ) )? ( (lv_storage_4_0= 'storage' ) )? (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* otherlv_7= '}' )?
            {
            // InternalAceGen.g:893:3: ( (lv_noComponent_0_0= 'noComponent' ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==31) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalAceGen.g:894:4: (lv_noComponent_0_0= 'noComponent' )
                    {
                    // InternalAceGen.g:894:4: (lv_noComponent_0_0= 'noComponent' )
                    // InternalAceGen.g:895:5: lv_noComponent_0_0= 'noComponent'
                    {
                    lv_noComponent_0_0=(Token)match(input,31,FOLLOW_23); 

                    					newLeafNode(lv_noComponent_0_0, grammarAccess.getSingleClientAttributeAccess().getNoComponentNoComponentKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSingleClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "noComponent", lv_noComponent_0_0 != null, "noComponent");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:907:3: ( (lv_list_1_0= 'List' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==32) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalAceGen.g:908:4: (lv_list_1_0= 'List' )
                    {
                    // InternalAceGen.g:908:4: (lv_list_1_0= 'List' )
                    // InternalAceGen.g:909:5: lv_list_1_0= 'List'
                    {
                    lv_list_1_0=(Token)match(input,32,FOLLOW_9); 

                    					newLeafNode(lv_list_1_0, grammarAccess.getSingleClientAttributeAccess().getListListKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSingleClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "list", lv_list_1_0 != null, "List");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:921:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalAceGen.g:922:4: (lv_name_2_0= RULE_ID )
            {
            // InternalAceGen.g:922:4: (lv_name_2_0= RULE_ID )
            // InternalAceGen.g:923:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_2_0, grammarAccess.getSingleClientAttributeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingleClientAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:939:3: ( (lv_hash_3_0= 'location.hash' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAceGen.g:940:4: (lv_hash_3_0= 'location.hash' )
                    {
                    // InternalAceGen.g:940:4: (lv_hash_3_0= 'location.hash' )
                    // InternalAceGen.g:941:5: lv_hash_3_0= 'location.hash'
                    {
                    lv_hash_3_0=(Token)match(input,33,FOLLOW_25); 

                    					newLeafNode(lv_hash_3_0, grammarAccess.getSingleClientAttributeAccess().getHashLocationHashKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSingleClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "hash", lv_hash_3_0 != null, "location.hash");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:953:3: ( (lv_storage_4_0= 'storage' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAceGen.g:954:4: (lv_storage_4_0= 'storage' )
                    {
                    // InternalAceGen.g:954:4: (lv_storage_4_0= 'storage' )
                    // InternalAceGen.g:955:5: lv_storage_4_0= 'storage'
                    {
                    lv_storage_4_0=(Token)match(input,34,FOLLOW_26); 

                    					newLeafNode(lv_storage_4_0, grammarAccess.getSingleClientAttributeAccess().getStorageStorageKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSingleClientAttributeRule());
                    					}
                    					setWithLastConsumed(current, "storage", lv_storage_4_0 != null, "storage");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:967:3: (otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* otherlv_7= '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==35) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalAceGen.g:968:4: otherlv_5= '{' ( (lv_attributes_6_0= ruleClientAttribute ) )* otherlv_7= '}'
                    {
                    otherlv_5=(Token)match(input,35,FOLLOW_27); 

                    				newLeafNode(otherlv_5, grammarAccess.getSingleClientAttributeAccess().getLeftCurlyBracketKeyword_5_0());
                    			
                    // InternalAceGen.g:972:4: ( (lv_attributes_6_0= ruleClientAttribute ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID||(LA30_0>=30 && LA30_0<=32)) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalAceGen.g:973:5: (lv_attributes_6_0= ruleClientAttribute )
                    	    {
                    	    // InternalAceGen.g:973:5: (lv_attributes_6_0= ruleClientAttribute )
                    	    // InternalAceGen.g:974:6: lv_attributes_6_0= ruleClientAttribute
                    	    {

                    	    						newCompositeNode(grammarAccess.getSingleClientAttributeAccess().getAttributesClientAttributeParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_27);
                    	    lv_attributes_6_0=ruleClientAttribute();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getSingleClientAttributeRule());
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

                    otherlv_7=(Token)match(input,36,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getSingleClientAttributeAccess().getRightCurlyBracketKeyword_5_2());
                    			

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
    // $ANTLR end "ruleSingleClientAttribute"


    // $ANTLR start "entryRuleGroupedClientAttribute"
    // InternalAceGen.g:1000:1: entryRuleGroupedClientAttribute returns [EObject current=null] : iv_ruleGroupedClientAttribute= ruleGroupedClientAttribute EOF ;
    public final EObject entryRuleGroupedClientAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupedClientAttribute = null;


        try {
            // InternalAceGen.g:1000:63: (iv_ruleGroupedClientAttribute= ruleGroupedClientAttribute EOF )
            // InternalAceGen.g:1001:2: iv_ruleGroupedClientAttribute= ruleGroupedClientAttribute EOF
            {
             newCompositeNode(grammarAccess.getGroupedClientAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGroupedClientAttribute=ruleGroupedClientAttribute();

            state._fsp--;

             current =iv_ruleGroupedClientAttribute; 
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
    // $ANTLR end "entryRuleGroupedClientAttribute"


    // $ANTLR start "ruleGroupedClientAttribute"
    // InternalAceGen.g:1007:1: ruleGroupedClientAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_attributeGroup_2_0= ruleClientAttribute ) ) ( (lv_attributeGroup_3_0= ruleClientAttribute ) )* otherlv_4= '}' ) ;
    public final EObject ruleGroupedClientAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_attributeGroup_2_0 = null;

        EObject lv_attributeGroup_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1013:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_attributeGroup_2_0= ruleClientAttribute ) ) ( (lv_attributeGroup_3_0= ruleClientAttribute ) )* otherlv_4= '}' ) )
            // InternalAceGen.g:1014:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_attributeGroup_2_0= ruleClientAttribute ) ) ( (lv_attributeGroup_3_0= ruleClientAttribute ) )* otherlv_4= '}' )
            {
            // InternalAceGen.g:1014:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_attributeGroup_2_0= ruleClientAttribute ) ) ( (lv_attributeGroup_3_0= ruleClientAttribute ) )* otherlv_4= '}' )
            // InternalAceGen.g:1015:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_attributeGroup_2_0= ruleClientAttribute ) ) ( (lv_attributeGroup_3_0= ruleClientAttribute ) )* otherlv_4= '}'
            {
            // InternalAceGen.g:1015:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1016:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1016:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1017:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_name_0_0, grammarAccess.getGroupedClientAttributeAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupedClientAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getGroupedClientAttributeAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:1037:3: ( (lv_attributeGroup_2_0= ruleClientAttribute ) )
            // InternalAceGen.g:1038:4: (lv_attributeGroup_2_0= ruleClientAttribute )
            {
            // InternalAceGen.g:1038:4: (lv_attributeGroup_2_0= ruleClientAttribute )
            // InternalAceGen.g:1039:5: lv_attributeGroup_2_0= ruleClientAttribute
            {

            					newCompositeNode(grammarAccess.getGroupedClientAttributeAccess().getAttributeGroupClientAttributeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_27);
            lv_attributeGroup_2_0=ruleClientAttribute();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGroupedClientAttributeRule());
            					}
            					add(
            						current,
            						"attributeGroup",
            						lv_attributeGroup_2_0,
            						"de.acegen.AceGen.ClientAttribute");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1056:3: ( (lv_attributeGroup_3_0= ruleClientAttribute ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID||(LA32_0>=30 && LA32_0<=32)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalAceGen.g:1057:4: (lv_attributeGroup_3_0= ruleClientAttribute )
            	    {
            	    // InternalAceGen.g:1057:4: (lv_attributeGroup_3_0= ruleClientAttribute )
            	    // InternalAceGen.g:1058:5: lv_attributeGroup_3_0= ruleClientAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getGroupedClientAttributeAccess().getAttributeGroupClientAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_27);
            	    lv_attributeGroup_3_0=ruleClientAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGroupedClientAttributeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributeGroup",
            	    						lv_attributeGroup_3_0,
            	    						"de.acegen.AceGen.ClientAttribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_4=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGroupedClientAttributeAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleGroupedClientAttribute"


    // $ANTLR start "entryRuleClientScenario"
    // InternalAceGen.g:1083:1: entryRuleClientScenario returns [EObject current=null] : iv_ruleClientScenario= ruleClientScenario EOF ;
    public final EObject entryRuleClientScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientScenario = null;


        try {
            // InternalAceGen.g:1083:55: (iv_ruleClientScenario= ruleClientScenario EOF )
            // InternalAceGen.g:1084:2: iv_ruleClientScenario= ruleClientScenario EOF
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
    // InternalAceGen.g:1090:1: ruleClientScenario returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleClientWhenBlock ) )? (otherlv_5= 'delayInMillis' ( (lv_delayInMillis_6_0= RULE_INT ) ) )? otherlv_7= 'THEN' ( (lv_thenBlock_8_0= ruleClientThenBlock ) ) ) ;
    public final EObject ruleClientScenario() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_delayInMillis_6_0=null;
        Token otherlv_7=null;
        EObject lv_givenRefs_2_0 = null;

        EObject lv_whenBlock_4_0 = null;

        EObject lv_thenBlock_8_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1096:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleClientWhenBlock ) )? (otherlv_5= 'delayInMillis' ( (lv_delayInMillis_6_0= RULE_INT ) ) )? otherlv_7= 'THEN' ( (lv_thenBlock_8_0= ruleClientThenBlock ) ) ) )
            // InternalAceGen.g:1097:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleClientWhenBlock ) )? (otherlv_5= 'delayInMillis' ( (lv_delayInMillis_6_0= RULE_INT ) ) )? otherlv_7= 'THEN' ( (lv_thenBlock_8_0= ruleClientThenBlock ) ) )
            {
            // InternalAceGen.g:1097:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleClientWhenBlock ) )? (otherlv_5= 'delayInMillis' ( (lv_delayInMillis_6_0= RULE_INT ) ) )? otherlv_7= 'THEN' ( (lv_thenBlock_8_0= ruleClientThenBlock ) ) )
            // InternalAceGen.g:1098:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleClientWhenBlock ) )? (otherlv_5= 'delayInMillis' ( (lv_delayInMillis_6_0= RULE_INT ) ) )? otherlv_7= 'THEN' ( (lv_thenBlock_8_0= ruleClientThenBlock ) )
            {
            // InternalAceGen.g:1098:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1099:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1099:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1100:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_30); 

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

            // InternalAceGen.g:1116:3: (otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==37) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalAceGen.g:1117:4: otherlv_1= 'GIVEN' ( (lv_givenRefs_2_0= ruleClientGivenRef ) )*
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_31); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientScenarioAccess().getGIVENKeyword_1_0());
                    			
                    // InternalAceGen.g:1121:4: ( (lv_givenRefs_2_0= ruleClientGivenRef ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_ID) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalAceGen.g:1122:5: (lv_givenRefs_2_0= ruleClientGivenRef )
                    	    {
                    	    // InternalAceGen.g:1122:5: (lv_givenRefs_2_0= ruleClientGivenRef )
                    	    // InternalAceGen.g:1123:6: lv_givenRefs_2_0= ruleClientGivenRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientScenarioAccess().getGivenRefsClientGivenRefParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_31);
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
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_3=(Token)match(input,38,FOLLOW_32); 

            			newLeafNode(otherlv_3, grammarAccess.getClientScenarioAccess().getWHENKeyword_2());
            		
            // InternalAceGen.g:1145:3: ( (lv_whenBlock_4_0= ruleClientWhenBlock ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalAceGen.g:1146:4: (lv_whenBlock_4_0= ruleClientWhenBlock )
                    {
                    // InternalAceGen.g:1146:4: (lv_whenBlock_4_0= ruleClientWhenBlock )
                    // InternalAceGen.g:1147:5: lv_whenBlock_4_0= ruleClientWhenBlock
                    {

                    					newCompositeNode(grammarAccess.getClientScenarioAccess().getWhenBlockClientWhenBlockParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_33);
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
                    break;

            }

            // InternalAceGen.g:1164:3: (otherlv_5= 'delayInMillis' ( (lv_delayInMillis_6_0= RULE_INT ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==27) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalAceGen.g:1165:4: otherlv_5= 'delayInMillis' ( (lv_delayInMillis_6_0= RULE_INT ) )
                    {
                    otherlv_5=(Token)match(input,27,FOLLOW_22); 

                    				newLeafNode(otherlv_5, grammarAccess.getClientScenarioAccess().getDelayInMillisKeyword_4_0());
                    			
                    // InternalAceGen.g:1169:4: ( (lv_delayInMillis_6_0= RULE_INT ) )
                    // InternalAceGen.g:1170:5: (lv_delayInMillis_6_0= RULE_INT )
                    {
                    // InternalAceGen.g:1170:5: (lv_delayInMillis_6_0= RULE_INT )
                    // InternalAceGen.g:1171:6: lv_delayInMillis_6_0= RULE_INT
                    {
                    lv_delayInMillis_6_0=(Token)match(input,RULE_INT,FOLLOW_34); 

                    						newLeafNode(lv_delayInMillis_6_0, grammarAccess.getClientScenarioAccess().getDelayInMillisINTTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getClientScenarioRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"delayInMillis",
                    							lv_delayInMillis_6_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,39,FOLLOW_35); 

            			newLeafNode(otherlv_7, grammarAccess.getClientScenarioAccess().getTHENKeyword_5());
            		
            // InternalAceGen.g:1192:3: ( (lv_thenBlock_8_0= ruleClientThenBlock ) )
            // InternalAceGen.g:1193:4: (lv_thenBlock_8_0= ruleClientThenBlock )
            {
            // InternalAceGen.g:1193:4: (lv_thenBlock_8_0= ruleClientThenBlock )
            // InternalAceGen.g:1194:5: lv_thenBlock_8_0= ruleClientThenBlock
            {

            					newCompositeNode(grammarAccess.getClientScenarioAccess().getThenBlockClientThenBlockParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_thenBlock_8_0=ruleClientThenBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClientScenarioRule());
            					}
            					set(
            						current,
            						"thenBlock",
            						lv_thenBlock_8_0,
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


    // $ANTLR start "entryRuleClientGivenRef"
    // InternalAceGen.g:1215:1: entryRuleClientGivenRef returns [EObject current=null] : iv_ruleClientGivenRef= ruleClientGivenRef EOF ;
    public final EObject entryRuleClientGivenRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientGivenRef = null;


        try {
            // InternalAceGen.g:1215:55: (iv_ruleClientGivenRef= ruleClientGivenRef EOF )
            // InternalAceGen.g:1216:2: iv_ruleClientGivenRef= ruleClientGivenRef EOF
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
    // InternalAceGen.g:1222:1: ruleClientGivenRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleClientGivenRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalAceGen.g:1228:2: ( ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:1229:2: ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:1229:2: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1230:3: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1230:3: ( ruleQualifiedName )
            // InternalAceGen.g:1231:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getClientGivenRefRule());
            				}
            			

            				newCompositeNode(grammarAccess.getClientGivenRefAccess().getScenarioClientScenarioCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleClientGivenRef"


    // $ANTLR start "entryRuleClientWhenBlock"
    // InternalAceGen.g:1248:1: entryRuleClientWhenBlock returns [EObject current=null] : iv_ruleClientWhenBlock= ruleClientWhenBlock EOF ;
    public final EObject entryRuleClientWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientWhenBlock = null;


        try {
            // InternalAceGen.g:1248:56: (iv_ruleClientWhenBlock= ruleClientWhenBlock EOF )
            // InternalAceGen.g:1249:2: iv_ruleClientWhenBlock= ruleClientWhenBlock EOF
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
    // InternalAceGen.g:1255:1: ruleClientWhenBlock returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'nonDeterministicValues' ( (lv_nonDeterministicValues_7_0= ruleNonDeterministicValue ) ) (otherlv_8= ',' ( (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue ) ) )* )? ) ;
    public final EObject ruleClientWhenBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_inputValues_2_0 = null;

        EObject lv_inputValues_4_0 = null;

        EObject lv_nonDeterministicValues_7_0 = null;

        EObject lv_nonDeterministicValues_9_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1261:2: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'nonDeterministicValues' ( (lv_nonDeterministicValues_7_0= ruleNonDeterministicValue ) ) (otherlv_8= ',' ( (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue ) ) )* )? ) )
            // InternalAceGen.g:1262:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'nonDeterministicValues' ( (lv_nonDeterministicValues_7_0= ruleNonDeterministicValue ) ) (otherlv_8= ',' ( (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue ) ) )* )? )
            {
            // InternalAceGen.g:1262:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'nonDeterministicValues' ( (lv_nonDeterministicValues_7_0= ruleNonDeterministicValue ) ) (otherlv_8= ',' ( (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue ) ) )* )? )
            // InternalAceGen.g:1263:3: ( ( ruleQualifiedName ) ) (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )? (otherlv_6= 'nonDeterministicValues' ( (lv_nonDeterministicValues_7_0= ruleNonDeterministicValue ) ) (otherlv_8= ',' ( (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue ) ) )* )?
            {
            // InternalAceGen.g:1263:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1264:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1264:4: ( ruleQualifiedName )
            // InternalAceGen.g:1265:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClientWhenBlockRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClientWhenBlockAccess().getActionHttpClientAceCrossReference_0_0());
            				
            pushFollow(FOLLOW_36);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:1279:3: (otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==18) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalAceGen.g:1280:4: otherlv_1= '(' ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,18,FOLLOW_37); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientWhenBlockAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalAceGen.g:1284:4: ( ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )* )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==RULE_ID) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalAceGen.g:1285:5: ( (lv_inputValues_2_0= ruleInputValue ) ) (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )*
                            {
                            // InternalAceGen.g:1285:5: ( (lv_inputValues_2_0= ruleInputValue ) )
                            // InternalAceGen.g:1286:6: (lv_inputValues_2_0= ruleInputValue )
                            {
                            // InternalAceGen.g:1286:6: (lv_inputValues_2_0= ruleInputValue )
                            // InternalAceGen.g:1287:7: lv_inputValues_2_0= ruleInputValue
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

                            // InternalAceGen.g:1304:5: (otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) ) )*
                            loop37:
                            do {
                                int alt37=2;
                                int LA37_0 = input.LA(1);

                                if ( (LA37_0==19) ) {
                                    alt37=1;
                                }


                                switch (alt37) {
                            	case 1 :
                            	    // InternalAceGen.g:1305:6: otherlv_3= ',' ( (lv_inputValues_4_0= ruleInputValue ) )
                            	    {
                            	    otherlv_3=(Token)match(input,19,FOLLOW_9); 

                            	    						newLeafNode(otherlv_3, grammarAccess.getClientWhenBlockAccess().getCommaKeyword_1_1_1_0());
                            	    					
                            	    // InternalAceGen.g:1309:6: ( (lv_inputValues_4_0= ruleInputValue ) )
                            	    // InternalAceGen.g:1310:7: (lv_inputValues_4_0= ruleInputValue )
                            	    {
                            	    // InternalAceGen.g:1310:7: (lv_inputValues_4_0= ruleInputValue )
                            	    // InternalAceGen.g:1311:8: lv_inputValues_4_0= ruleInputValue
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
                            	    break loop37;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_38); 

                    				newLeafNode(otherlv_5, grammarAccess.getClientWhenBlockAccess().getRightParenthesisKeyword_1_2());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:1335:3: (otherlv_6= 'nonDeterministicValues' ( (lv_nonDeterministicValues_7_0= ruleNonDeterministicValue ) ) (otherlv_8= ',' ( (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue ) ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==40) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalAceGen.g:1336:4: otherlv_6= 'nonDeterministicValues' ( (lv_nonDeterministicValues_7_0= ruleNonDeterministicValue ) ) (otherlv_8= ',' ( (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue ) ) )*
                    {
                    otherlv_6=(Token)match(input,40,FOLLOW_28); 

                    				newLeafNode(otherlv_6, grammarAccess.getClientWhenBlockAccess().getNonDeterministicValuesKeyword_2_0());
                    			
                    // InternalAceGen.g:1340:4: ( (lv_nonDeterministicValues_7_0= ruleNonDeterministicValue ) )
                    // InternalAceGen.g:1341:5: (lv_nonDeterministicValues_7_0= ruleNonDeterministicValue )
                    {
                    // InternalAceGen.g:1341:5: (lv_nonDeterministicValues_7_0= ruleNonDeterministicValue )
                    // InternalAceGen.g:1342:6: lv_nonDeterministicValues_7_0= ruleNonDeterministicValue
                    {

                    						newCompositeNode(grammarAccess.getClientWhenBlockAccess().getNonDeterministicValuesNonDeterministicValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_39);
                    lv_nonDeterministicValues_7_0=ruleNonDeterministicValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClientWhenBlockRule());
                    						}
                    						add(
                    							current,
                    							"nonDeterministicValues",
                    							lv_nonDeterministicValues_7_0,
                    							"de.acegen.AceGen.NonDeterministicValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:1359:4: (otherlv_8= ',' ( (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==19) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalAceGen.g:1360:5: otherlv_8= ',' ( (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue ) )
                    	    {
                    	    otherlv_8=(Token)match(input,19,FOLLOW_28); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getClientWhenBlockAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:1364:5: ( (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue ) )
                    	    // InternalAceGen.g:1365:6: (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue )
                    	    {
                    	    // InternalAceGen.g:1365:6: (lv_nonDeterministicValues_9_0= ruleNonDeterministicValue )
                    	    // InternalAceGen.g:1366:7: lv_nonDeterministicValues_9_0= ruleNonDeterministicValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getClientWhenBlockAccess().getNonDeterministicValuesNonDeterministicValueParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_39);
                    	    lv_nonDeterministicValues_9_0=ruleNonDeterministicValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getClientWhenBlockRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"nonDeterministicValues",
                    	    								lv_nonDeterministicValues_9_0,
                    	    								"de.acegen.AceGen.NonDeterministicValue");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


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


    // $ANTLR start "entryRuleNonDeterministicValue"
    // InternalAceGen.g:1389:1: entryRuleNonDeterministicValue returns [EObject current=null] : iv_ruleNonDeterministicValue= ruleNonDeterministicValue EOF ;
    public final EObject entryRuleNonDeterministicValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonDeterministicValue = null;


        try {
            // InternalAceGen.g:1389:62: (iv_ruleNonDeterministicValue= ruleNonDeterministicValue EOF )
            // InternalAceGen.g:1390:2: iv_ruleNonDeterministicValue= ruleNonDeterministicValue EOF
            {
             newCompositeNode(grammarAccess.getNonDeterministicValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNonDeterministicValue=ruleNonDeterministicValue();

            state._fsp--;

             current =iv_ruleNonDeterministicValue; 
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
    // $ANTLR end "entryRuleNonDeterministicValue"


    // $ANTLR start "ruleNonDeterministicValue"
    // InternalAceGen.g:1396:1: ruleNonDeterministicValue returns [EObject current=null] : ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'nonDeterministic' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' ) ;
    public final EObject ruleNonDeterministicValue() throws RecognitionException {
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
            // InternalAceGen.g:1402:2: ( ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'nonDeterministic' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' ) )
            // InternalAceGen.g:1403:2: ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'nonDeterministic' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' )
            {
            // InternalAceGen.g:1403:2: ( () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'nonDeterministic' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}' )
            // InternalAceGen.g:1404:3: () otherlv_1= '{' (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'nonDeterministic' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )? otherlv_12= '}'
            {
            // InternalAceGen.g:1404:3: ()
            // InternalAceGen.g:1405:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNonDeterministicValueAccess().getNonDeterministicValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getNonDeterministicValueAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:1415:3: (otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'nonDeterministic' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )? )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==41) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalAceGen.g:1416:4: otherlv_2= 'uuid' ( (lv_uuid_3_0= RULE_STRING ) ) (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )? (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )? (otherlv_8= 'nonDeterministic' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )?
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_41); 

                    				newLeafNode(otherlv_2, grammarAccess.getNonDeterministicValueAccess().getUuidKeyword_2_0());
                    			
                    // InternalAceGen.g:1420:4: ( (lv_uuid_3_0= RULE_STRING ) )
                    // InternalAceGen.g:1421:5: (lv_uuid_3_0= RULE_STRING )
                    {
                    // InternalAceGen.g:1421:5: (lv_uuid_3_0= RULE_STRING )
                    // InternalAceGen.g:1422:6: lv_uuid_3_0= RULE_STRING
                    {
                    lv_uuid_3_0=(Token)match(input,RULE_STRING,FOLLOW_42); 

                    						newLeafNode(lv_uuid_3_0, grammarAccess.getNonDeterministicValueAccess().getUuidSTRINGTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNonDeterministicValueRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"uuid",
                    							lv_uuid_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    // InternalAceGen.g:1438:4: (otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) ) )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==42) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalAceGen.g:1439:5: otherlv_4= 'clientSystemTime' ( (lv_clientSystemTime_5_0= RULE_STRING ) )
                            {
                            otherlv_4=(Token)match(input,42,FOLLOW_41); 

                            					newLeafNode(otherlv_4, grammarAccess.getNonDeterministicValueAccess().getClientSystemTimeKeyword_2_2_0());
                            				
                            // InternalAceGen.g:1443:5: ( (lv_clientSystemTime_5_0= RULE_STRING ) )
                            // InternalAceGen.g:1444:6: (lv_clientSystemTime_5_0= RULE_STRING )
                            {
                            // InternalAceGen.g:1444:6: (lv_clientSystemTime_5_0= RULE_STRING )
                            // InternalAceGen.g:1445:7: lv_clientSystemTime_5_0= RULE_STRING
                            {
                            lv_clientSystemTime_5_0=(Token)match(input,RULE_STRING,FOLLOW_43); 

                            							newLeafNode(lv_clientSystemTime_5_0, grammarAccess.getNonDeterministicValueAccess().getClientSystemTimeSTRINGTerminalRuleCall_2_2_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getNonDeterministicValueRule());
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

                    // InternalAceGen.g:1462:4: (otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==43) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalAceGen.g:1463:5: otherlv_6= 'serverSystemTime' ( (lv_serverSystemTime_7_0= RULE_STRING ) )
                            {
                            otherlv_6=(Token)match(input,43,FOLLOW_41); 

                            					newLeafNode(otherlv_6, grammarAccess.getNonDeterministicValueAccess().getServerSystemTimeKeyword_2_3_0());
                            				
                            // InternalAceGen.g:1467:5: ( (lv_serverSystemTime_7_0= RULE_STRING ) )
                            // InternalAceGen.g:1468:6: (lv_serverSystemTime_7_0= RULE_STRING )
                            {
                            // InternalAceGen.g:1468:6: (lv_serverSystemTime_7_0= RULE_STRING )
                            // InternalAceGen.g:1469:7: lv_serverSystemTime_7_0= RULE_STRING
                            {
                            lv_serverSystemTime_7_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

                            							newLeafNode(lv_serverSystemTime_7_0, grammarAccess.getNonDeterministicValueAccess().getServerSystemTimeSTRINGTerminalRuleCall_2_3_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getNonDeterministicValueRule());
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

                    // InternalAceGen.g:1486:4: (otherlv_8= 'nonDeterministic' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) ) )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==44) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalAceGen.g:1487:5: otherlv_8= 'nonDeterministic' ( ( ruleQualifiedName ) ) otherlv_10= ':' ( (lv_value_11_0= rulePrimitiveValue ) )
                            {
                            otherlv_8=(Token)match(input,44,FOLLOW_9); 

                            					newLeafNode(otherlv_8, grammarAccess.getNonDeterministicValueAccess().getNonDeterministicKeyword_2_4_0());
                            				
                            // InternalAceGen.g:1491:5: ( ( ruleQualifiedName ) )
                            // InternalAceGen.g:1492:6: ( ruleQualifiedName )
                            {
                            // InternalAceGen.g:1492:6: ( ruleQualifiedName )
                            // InternalAceGen.g:1493:7: ruleQualifiedName
                            {

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getNonDeterministicValueRule());
                            							}
                            						

                            							newCompositeNode(grammarAccess.getNonDeterministicValueAccess().getAttributeAttributeCrossReference_2_4_1_0());
                            						
                            pushFollow(FOLLOW_45);
                            ruleQualifiedName();

                            state._fsp--;


                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_10=(Token)match(input,45,FOLLOW_46); 

                            					newLeafNode(otherlv_10, grammarAccess.getNonDeterministicValueAccess().getColonKeyword_2_4_2());
                            				
                            // InternalAceGen.g:1511:5: ( (lv_value_11_0= rulePrimitiveValue ) )
                            // InternalAceGen.g:1512:6: (lv_value_11_0= rulePrimitiveValue )
                            {
                            // InternalAceGen.g:1512:6: (lv_value_11_0= rulePrimitiveValue )
                            // InternalAceGen.g:1513:7: lv_value_11_0= rulePrimitiveValue
                            {

                            							newCompositeNode(grammarAccess.getNonDeterministicValueAccess().getValuePrimitiveValueParserRuleCall_2_4_3_0());
                            						
                            pushFollow(FOLLOW_47);
                            lv_value_11_0=rulePrimitiveValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getNonDeterministicValueRule());
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

            otherlv_12=(Token)match(input,36,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getNonDeterministicValueAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleNonDeterministicValue"


    // $ANTLR start "entryRuleInputValue"
    // InternalAceGen.g:1540:1: entryRuleInputValue returns [EObject current=null] : iv_ruleInputValue= ruleInputValue EOF ;
    public final EObject entryRuleInputValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputValue = null;


        try {
            // InternalAceGen.g:1540:51: (iv_ruleInputValue= ruleInputValue EOF )
            // InternalAceGen.g:1541:2: iv_ruleInputValue= ruleInputValue EOF
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
    // InternalAceGen.g:1547:1: ruleInputValue returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject ruleInputValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1553:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalAceGen.g:1554:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalAceGen.g:1554:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalAceGen.g:1555:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalAceGen.g:1555:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1556:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1556:4: ( ruleQualifiedName )
            // InternalAceGen.g:1557:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInputValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInputValueAccess().getInputInputCrossReference_0_0());
            				
            pushFollow(FOLLOW_45);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,45,FOLLOW_46); 

            			newLeafNode(otherlv_1, grammarAccess.getInputValueAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:1575:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalAceGen.g:1576:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalAceGen.g:1576:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalAceGen.g:1577:5: lv_value_2_0= rulePrimitiveValue
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
    // InternalAceGen.g:1598:1: entryRuleClientThenBlock returns [EObject current=null] : iv_ruleClientThenBlock= ruleClientThenBlock EOF ;
    public final EObject entryRuleClientThenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClientThenBlock = null;


        try {
            // InternalAceGen.g:1598:56: (iv_ruleClientThenBlock= ruleClientThenBlock EOF )
            // InternalAceGen.g:1599:2: iv_ruleClientThenBlock= ruleClientThenBlock EOF
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
    // InternalAceGen.g:1605:1: ruleClientThenBlock returns [EObject current=null] : ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= RULE_ID ) )* )? ) ;
    public final EObject ruleClientThenBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_verifications_4_0=null;
        EObject lv_stateVerifications_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1611:2: ( ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= RULE_ID ) )* )? ) )
            // InternalAceGen.g:1612:2: ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= RULE_ID ) )* )? )
            {
            // InternalAceGen.g:1612:2: ( () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= RULE_ID ) )* )? )
            // InternalAceGen.g:1613:3: () (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )? (otherlv_3= 'verifications' ( (lv_verifications_4_0= RULE_ID ) )* )?
            {
            // InternalAceGen.g:1613:3: ()
            // InternalAceGen.g:1614:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getClientThenBlockAccess().getClientThenBlockAction_0(),
            					current);
            			

            }

            // InternalAceGen.g:1620:3: (otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==46) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalAceGen.g:1621:4: otherlv_1= 'expectedState' ( (lv_stateVerifications_2_0= ruleStateVerification ) )*
                    {
                    otherlv_1=(Token)match(input,46,FOLLOW_48); 

                    				newLeafNode(otherlv_1, grammarAccess.getClientThenBlockAccess().getExpectedStateKeyword_1_0());
                    			
                    // InternalAceGen.g:1625:4: ( (lv_stateVerifications_2_0= ruleStateVerification ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==RULE_ID) ) {
                            int LA46_2 = input.LA(2);

                            if ( (LA46_2==RULE_ID) ) {
                                alt46=1;
                            }


                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalAceGen.g:1626:5: (lv_stateVerifications_2_0= ruleStateVerification )
                    	    {
                    	    // InternalAceGen.g:1626:5: (lv_stateVerifications_2_0= ruleStateVerification )
                    	    // InternalAceGen.g:1627:6: lv_stateVerifications_2_0= ruleStateVerification
                    	    {

                    	    						newCompositeNode(grammarAccess.getClientThenBlockAccess().getStateVerificationsStateVerificationParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_48);
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
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:1645:3: (otherlv_3= 'verifications' ( (lv_verifications_4_0= RULE_ID ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==47) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalAceGen.g:1646:4: otherlv_3= 'verifications' ( (lv_verifications_4_0= RULE_ID ) )*
                    {
                    otherlv_3=(Token)match(input,47,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getClientThenBlockAccess().getVerificationsKeyword_2_0());
                    			
                    // InternalAceGen.g:1650:4: ( (lv_verifications_4_0= RULE_ID ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ID) ) {
                            int LA48_2 = input.LA(2);

                            if ( (LA48_2==EOF||LA48_2==RULE_ID) ) {
                                alt48=1;
                            }


                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalAceGen.g:1651:5: (lv_verifications_4_0= RULE_ID )
                    	    {
                    	    // InternalAceGen.g:1651:5: (lv_verifications_4_0= RULE_ID )
                    	    // InternalAceGen.g:1652:6: lv_verifications_4_0= RULE_ID
                    	    {
                    	    lv_verifications_4_0=(Token)match(input,RULE_ID,FOLLOW_3); 

                    	    						newLeafNode(lv_verifications_4_0, grammarAccess.getClientThenBlockAccess().getVerificationsIDTerminalRuleCall_2_1_0());
                    	    					

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getClientThenBlockRule());
                    	    						}
                    	    						addWithLastConsumed(
                    	    							current,
                    	    							"verifications",
                    	    							lv_verifications_4_0,
                    	    							"org.eclipse.xtext.common.Terminals.ID");
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
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
    // InternalAceGen.g:1673:1: entryRuleStateVerification returns [EObject current=null] : iv_ruleStateVerification= ruleStateVerification EOF ;
    public final EObject entryRuleStateVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateVerification = null;


        try {
            // InternalAceGen.g:1673:58: (iv_ruleStateVerification= ruleStateVerification EOF )
            // InternalAceGen.g:1674:2: iv_ruleStateVerification= ruleStateVerification EOF
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
    // InternalAceGen.g:1680:1: ruleStateVerification returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'shouldBe' ( (lv_value_3_0= ruleJsonValueClient ) ) ) ;
    public final EObject ruleStateVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1686:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'shouldBe' ( (lv_value_3_0= ruleJsonValueClient ) ) ) )
            // InternalAceGen.g:1687:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'shouldBe' ( (lv_value_3_0= ruleJsonValueClient ) ) )
            {
            // InternalAceGen.g:1687:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'shouldBe' ( (lv_value_3_0= ruleJsonValueClient ) ) )
            // InternalAceGen.g:1688:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) otherlv_2= 'shouldBe' ( (lv_value_3_0= ruleJsonValueClient ) )
            {
            // InternalAceGen.g:1688:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1689:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1689:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1690:5: lv_name_0_0= RULE_ID
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

            // InternalAceGen.g:1706:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1707:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1707:4: ( ruleQualifiedName )
            // InternalAceGen.g:1708:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateVerificationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStateVerificationAccess().getStateRefSingleClientAttributeCrossReference_1_0());
            				
            pushFollow(FOLLOW_49);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,48,FOLLOW_50); 

            			newLeafNode(otherlv_2, grammarAccess.getStateVerificationAccess().getShouldBeKeyword_2());
            		
            // InternalAceGen.g:1726:3: ( (lv_value_3_0= ruleJsonValueClient ) )
            // InternalAceGen.g:1727:4: (lv_value_3_0= ruleJsonValueClient )
            {
            // InternalAceGen.g:1727:4: (lv_value_3_0= ruleJsonValueClient )
            // InternalAceGen.g:1728:5: lv_value_3_0= ruleJsonValueClient
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
    // InternalAceGen.g:1749:1: entryRuleJsonObjectClient returns [EObject current=null] : iv_ruleJsonObjectClient= ruleJsonObjectClient EOF ;
    public final EObject entryRuleJsonObjectClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObjectClient = null;


        try {
            // InternalAceGen.g:1749:57: (iv_ruleJsonObjectClient= ruleJsonObjectClient EOF )
            // InternalAceGen.g:1750:2: iv_ruleJsonObjectClient= ruleJsonObjectClient EOF
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
    // InternalAceGen.g:1756:1: ruleJsonObjectClient returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleJsonObjectClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_members_2_0 = null;

        EObject lv_members_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1762:2: ( ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' ) )
            // InternalAceGen.g:1763:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' )
            {
            // InternalAceGen.g:1763:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}' )
            // InternalAceGen.g:1764:3: () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMemberClient ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )* otherlv_5= '}'
            {
            // InternalAceGen.g:1764:3: ()
            // InternalAceGen.g:1765:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonObjectClientAccess().getJsonObjectClientAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonObjectClientAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:1775:3: ( (lv_members_2_0= ruleJsonMemberClient ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalAceGen.g:1776:4: (lv_members_2_0= ruleJsonMemberClient )
                    {
                    // InternalAceGen.g:1776:4: (lv_members_2_0= ruleJsonMemberClient )
                    // InternalAceGen.g:1777:5: lv_members_2_0= ruleJsonMemberClient
                    {

                    					newCompositeNode(grammarAccess.getJsonObjectClientAccess().getMembersJsonMemberClientParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_52);
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

            // InternalAceGen.g:1794:3: (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==19) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalAceGen.g:1795:4: otherlv_3= ',' ( (lv_members_4_0= ruleJsonMemberClient ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_9); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonObjectClientAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:1799:4: ( (lv_members_4_0= ruleJsonMemberClient ) )
            	    // InternalAceGen.g:1800:5: (lv_members_4_0= ruleJsonMemberClient )
            	    {
            	    // InternalAceGen.g:1800:5: (lv_members_4_0= ruleJsonMemberClient )
            	    // InternalAceGen.g:1801:6: lv_members_4_0= ruleJsonMemberClient
            	    {

            	    						newCompositeNode(grammarAccess.getJsonObjectClientAccess().getMembersJsonMemberClientParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_52);
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
            	    break loop51;
                }
            } while (true);

            otherlv_5=(Token)match(input,36,FOLLOW_2); 

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
    // InternalAceGen.g:1827:1: entryRuleJsonMemberClient returns [EObject current=null] : iv_ruleJsonMemberClient= ruleJsonMemberClient EOF ;
    public final EObject entryRuleJsonMemberClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonMemberClient = null;


        try {
            // InternalAceGen.g:1827:57: (iv_ruleJsonMemberClient= ruleJsonMemberClient EOF )
            // InternalAceGen.g:1828:2: iv_ruleJsonMemberClient= ruleJsonMemberClient EOF
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
    // InternalAceGen.g:1834:1: ruleJsonMemberClient returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) ) ;
    public final EObject ruleJsonMemberClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1840:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) ) )
            // InternalAceGen.g:1841:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) )
            {
            // InternalAceGen.g:1841:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) ) )
            // InternalAceGen.g:1842:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValueClient ) )
            {
            // InternalAceGen.g:1842:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1843:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1843:4: ( ruleQualifiedName )
            // InternalAceGen.g:1844:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonMemberClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJsonMemberClientAccess().getAttributeSingleClientAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_45);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,45,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonMemberClientAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:1862:3: ( (lv_value_2_0= ruleJsonValueClient ) )
            // InternalAceGen.g:1863:4: (lv_value_2_0= ruleJsonValueClient )
            {
            // InternalAceGen.g:1863:4: (lv_value_2_0= ruleJsonValueClient )
            // InternalAceGen.g:1864:5: lv_value_2_0= ruleJsonValueClient
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
    // InternalAceGen.g:1885:1: entryRuleJsonValueClient returns [EObject current=null] : iv_ruleJsonValueClient= ruleJsonValueClient EOF ;
    public final EObject entryRuleJsonValueClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonValueClient = null;


        try {
            // InternalAceGen.g:1885:56: (iv_ruleJsonValueClient= ruleJsonValueClient EOF )
            // InternalAceGen.g:1886:2: iv_ruleJsonValueClient= ruleJsonValueClient EOF
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
    // InternalAceGen.g:1892:1: ruleJsonValueClient returns [EObject current=null] : (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType ) ;
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
            // InternalAceGen.g:1898:2: ( (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType ) )
            // InternalAceGen.g:1899:2: (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType )
            {
            // InternalAceGen.g:1899:2: (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType )
            int alt52=8;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // InternalAceGen.g:1900:3: this_JsonObjectClient_0= ruleJsonObjectClient
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
                    // InternalAceGen.g:1909:3: this_StringType_1= ruleStringType
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
                    // InternalAceGen.g:1918:3: this_JsonArrayClient_2= ruleJsonArrayClient
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
                    // InternalAceGen.g:1927:3: this_BooleanType_3= ruleBooleanType
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
                    // InternalAceGen.g:1936:3: this_NullType_4= ruleNullType
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
                    // InternalAceGen.g:1945:3: this_LongType_5= ruleLongType
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
                    // InternalAceGen.g:1954:3: this_JsonDateTime_6= ruleJsonDateTime
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
                    // InternalAceGen.g:1963:3: this_UndefinedType_7= ruleUndefinedType
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
    // InternalAceGen.g:1975:1: entryRuleJsonArrayClient returns [EObject current=null] : iv_ruleJsonArrayClient= ruleJsonArrayClient EOF ;
    public final EObject entryRuleJsonArrayClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonArrayClient = null;


        try {
            // InternalAceGen.g:1975:56: (iv_ruleJsonArrayClient= ruleJsonArrayClient EOF )
            // InternalAceGen.g:1976:2: iv_ruleJsonArrayClient= ruleJsonArrayClient EOF
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
    // InternalAceGen.g:1982:1: ruleJsonArrayClient returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleJsonArrayClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1988:2: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' ) )
            // InternalAceGen.g:1989:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' )
            {
            // InternalAceGen.g:1989:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']' )
            // InternalAceGen.g:1990:3: () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValueClient ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )* otherlv_5= ']'
            {
            // InternalAceGen.g:1990:3: ()
            // InternalAceGen.g:1991:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonArrayClientAccess().getJsonArrayClientAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,49,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonArrayClientAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalAceGen.g:2001:3: ( (lv_values_2_0= ruleJsonValueClient ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=RULE_INT && LA53_0<=RULE_STRING)||LA53_0==35||LA53_0==49||LA53_0==78||(LA53_0>=96 && LA53_0<=98)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalAceGen.g:2002:4: (lv_values_2_0= ruleJsonValueClient )
                    {
                    // InternalAceGen.g:2002:4: (lv_values_2_0= ruleJsonValueClient )
                    // InternalAceGen.g:2003:5: lv_values_2_0= ruleJsonValueClient
                    {

                    					newCompositeNode(grammarAccess.getJsonArrayClientAccess().getValuesJsonValueClientParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_54);
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

            // InternalAceGen.g:2020:3: (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==19) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalAceGen.g:2021:4: otherlv_3= ',' ( (lv_values_4_0= ruleJsonValueClient ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_50); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonArrayClientAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:2025:4: ( (lv_values_4_0= ruleJsonValueClient ) )
            	    // InternalAceGen.g:2026:5: (lv_values_4_0= ruleJsonValueClient )
            	    {
            	    // InternalAceGen.g:2026:5: (lv_values_4_0= ruleJsonValueClient )
            	    // InternalAceGen.g:2027:6: lv_values_4_0= ruleJsonValueClient
            	    {

            	    						newCompositeNode(grammarAccess.getJsonArrayClientAccess().getValuesJsonValueClientParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_54);
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
            	    break loop54;
                }
            } while (true);

            otherlv_5=(Token)match(input,50,FOLLOW_2); 

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
    // InternalAceGen.g:2053:1: entryRuleHttpServer returns [EObject current=null] : iv_ruleHttpServer= ruleHttpServer EOF ;
    public final EObject entryRuleHttpServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServer = null;


        try {
            // InternalAceGen.g:2053:51: (iv_ruleHttpServer= ruleHttpServer EOF )
            // InternalAceGen.g:2054:2: iv_ruleHttpServer= ruleHttpServer EOF
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
    // InternalAceGen.g:2060:1: ruleHttpServer returns [EObject current=null] : ( ( (lv_language_0_0= 'Java' ) ) ( (lv_type_1_0= 'Dropwizard' ) )? ( (lv_persistenceLayer_2_0= 'JDBI3' ) )? ( (lv_migrations_3_0= 'Liquibase' ) )? ( (lv_name_4_0= ruleQualifiedName ) ) (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )? (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )? (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )? (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )? (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )? ) ;
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
            // InternalAceGen.g:2066:2: ( ( ( (lv_language_0_0= 'Java' ) ) ( (lv_type_1_0= 'Dropwizard' ) )? ( (lv_persistenceLayer_2_0= 'JDBI3' ) )? ( (lv_migrations_3_0= 'Liquibase' ) )? ( (lv_name_4_0= ruleQualifiedName ) ) (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )? (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )? (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )? (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )? (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )? ) )
            // InternalAceGen.g:2067:2: ( ( (lv_language_0_0= 'Java' ) ) ( (lv_type_1_0= 'Dropwizard' ) )? ( (lv_persistenceLayer_2_0= 'JDBI3' ) )? ( (lv_migrations_3_0= 'Liquibase' ) )? ( (lv_name_4_0= ruleQualifiedName ) ) (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )? (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )? (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )? (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )? (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )? )
            {
            // InternalAceGen.g:2067:2: ( ( (lv_language_0_0= 'Java' ) ) ( (lv_type_1_0= 'Dropwizard' ) )? ( (lv_persistenceLayer_2_0= 'JDBI3' ) )? ( (lv_migrations_3_0= 'Liquibase' ) )? ( (lv_name_4_0= ruleQualifiedName ) ) (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )? (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )? (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )? (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )? (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )? )
            // InternalAceGen.g:2068:3: ( (lv_language_0_0= 'Java' ) ) ( (lv_type_1_0= 'Dropwizard' ) )? ( (lv_persistenceLayer_2_0= 'JDBI3' ) )? ( (lv_migrations_3_0= 'Liquibase' ) )? ( (lv_name_4_0= ruleQualifiedName ) ) (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )? (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )? (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )? (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )? (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )?
            {
            // InternalAceGen.g:2068:3: ( (lv_language_0_0= 'Java' ) )
            // InternalAceGen.g:2069:4: (lv_language_0_0= 'Java' )
            {
            // InternalAceGen.g:2069:4: (lv_language_0_0= 'Java' )
            // InternalAceGen.g:2070:5: lv_language_0_0= 'Java'
            {
            lv_language_0_0=(Token)match(input,51,FOLLOW_55); 

            					newLeafNode(lv_language_0_0, grammarAccess.getHttpServerAccess().getLanguageJavaKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerRule());
            					}
            					setWithLastConsumed(current, "language", lv_language_0_0, "Java");
            				

            }


            }

            // InternalAceGen.g:2082:3: ( (lv_type_1_0= 'Dropwizard' ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==52) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalAceGen.g:2083:4: (lv_type_1_0= 'Dropwizard' )
                    {
                    // InternalAceGen.g:2083:4: (lv_type_1_0= 'Dropwizard' )
                    // InternalAceGen.g:2084:5: lv_type_1_0= 'Dropwizard'
                    {
                    lv_type_1_0=(Token)match(input,52,FOLLOW_56); 

                    					newLeafNode(lv_type_1_0, grammarAccess.getHttpServerAccess().getTypeDropwizardKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "type", lv_type_1_0, "Dropwizard");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2096:3: ( (lv_persistenceLayer_2_0= 'JDBI3' ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==53) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalAceGen.g:2097:4: (lv_persistenceLayer_2_0= 'JDBI3' )
                    {
                    // InternalAceGen.g:2097:4: (lv_persistenceLayer_2_0= 'JDBI3' )
                    // InternalAceGen.g:2098:5: lv_persistenceLayer_2_0= 'JDBI3'
                    {
                    lv_persistenceLayer_2_0=(Token)match(input,53,FOLLOW_57); 

                    					newLeafNode(lv_persistenceLayer_2_0, grammarAccess.getHttpServerAccess().getPersistenceLayerJDBI3Keyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "persistenceLayer", lv_persistenceLayer_2_0, "JDBI3");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2110:3: ( (lv_migrations_3_0= 'Liquibase' ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==54) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalAceGen.g:2111:4: (lv_migrations_3_0= 'Liquibase' )
                    {
                    // InternalAceGen.g:2111:4: (lv_migrations_3_0= 'Liquibase' )
                    // InternalAceGen.g:2112:5: lv_migrations_3_0= 'Liquibase'
                    {
                    lv_migrations_3_0=(Token)match(input,54,FOLLOW_9); 

                    					newLeafNode(lv_migrations_3_0, grammarAccess.getHttpServerAccess().getMigrationsLiquibaseKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerRule());
                    					}
                    					setWithLastConsumed(current, "migrations", lv_migrations_3_0, "Liquibase");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2124:3: ( (lv_name_4_0= ruleQualifiedName ) )
            // InternalAceGen.g:2125:4: (lv_name_4_0= ruleQualifiedName )
            {
            // InternalAceGen.g:2125:4: (lv_name_4_0= ruleQualifiedName )
            // InternalAceGen.g:2126:5: lv_name_4_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getHttpServerAccess().getNameQualifiedNameParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_58);
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

            // InternalAceGen.g:2143:3: (otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==55) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalAceGen.g:2144:4: otherlv_5= 'Authorization' ( (lv_authUser_6_0= ruleAuthUser ) )
                    {
                    otherlv_5=(Token)match(input,55,FOLLOW_9); 

                    				newLeafNode(otherlv_5, grammarAccess.getHttpServerAccess().getAuthorizationKeyword_5_0());
                    			
                    // InternalAceGen.g:2148:4: ( (lv_authUser_6_0= ruleAuthUser ) )
                    // InternalAceGen.g:2149:5: (lv_authUser_6_0= ruleAuthUser )
                    {
                    // InternalAceGen.g:2149:5: (lv_authUser_6_0= ruleAuthUser )
                    // InternalAceGen.g:2150:6: lv_authUser_6_0= ruleAuthUser
                    {

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserAuthUserParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_59);
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

            // InternalAceGen.g:2168:3: (otherlv_7= 'import' ( ( ruleQualifiedName ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==56) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalAceGen.g:2169:4: otherlv_7= 'import' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,56,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getHttpServerAccess().getImportKeyword_6_0());
                    			
                    // InternalAceGen.g:2173:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:2174:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:2174:5: ( ruleQualifiedName )
                    // InternalAceGen.g:2175:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpServerRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_60);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:2190:3: (otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )* )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==13) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalAceGen.g:2191:4: otherlv_9= 'ACE' ( (lv_aceOperations_10_0= ruleHttpServerAce ) )*
                    {
                    otherlv_9=(Token)match(input,13,FOLLOW_61); 

                    				newLeafNode(otherlv_9, grammarAccess.getHttpServerAccess().getACEKeyword_7_0());
                    			
                    // InternalAceGen.g:2195:4: ( (lv_aceOperations_10_0= ruleHttpServerAce ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==RULE_ID) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalAceGen.g:2196:5: (lv_aceOperations_10_0= ruleHttpServerAce )
                    	    {
                    	    // InternalAceGen.g:2196:5: (lv_aceOperations_10_0= ruleHttpServerAce )
                    	    // InternalAceGen.g:2197:6: lv_aceOperations_10_0= ruleHttpServerAce
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getAceOperationsHttpServerAceParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_61);
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
                    	    break loop60;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2215:3: (otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )* )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==57) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalAceGen.g:2216:4: otherlv_11= 'views' ( (lv_views_12_0= ruleHttpServerView ) )*
                    {
                    otherlv_11=(Token)match(input,57,FOLLOW_62); 

                    				newLeafNode(otherlv_11, grammarAccess.getHttpServerAccess().getViewsKeyword_8_0());
                    			
                    // InternalAceGen.g:2220:4: ( (lv_views_12_0= ruleHttpServerView ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==RULE_ID||LA62_0==67) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalAceGen.g:2221:5: (lv_views_12_0= ruleHttpServerView )
                    	    {
                    	    // InternalAceGen.g:2221:5: (lv_views_12_0= ruleHttpServerView )
                    	    // InternalAceGen.g:2222:6: lv_views_12_0= ruleHttpServerView
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getViewsHttpServerViewParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_62);
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
                    	    break loop62;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2240:3: (otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==58) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalAceGen.g:2241:4: otherlv_13= 'models' ( (lv_models_14_0= ruleModel ) )*
                    {
                    otherlv_13=(Token)match(input,58,FOLLOW_63); 

                    				newLeafNode(otherlv_13, grammarAccess.getHttpServerAccess().getModelsKeyword_9_0());
                    			
                    // InternalAceGen.g:2245:4: ( (lv_models_14_0= ruleModel ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==RULE_ID||LA64_0==68) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalAceGen.g:2246:5: (lv_models_14_0= ruleModel )
                    	    {
                    	    // InternalAceGen.g:2246:5: (lv_models_14_0= ruleModel )
                    	    // InternalAceGen.g:2247:6: lv_models_14_0= ruleModel
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getModelsModelParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_63);
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
                    	    break loop64;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2265:3: (otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )* )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==16) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalAceGen.g:2266:4: otherlv_15= 'scenarios' ( (lv_scenarios_16_0= ruleScenario ) )*
                    {
                    otherlv_15=(Token)match(input,16,FOLLOW_3); 

                    				newLeafNode(otherlv_15, grammarAccess.getHttpServerAccess().getScenariosKeyword_10_0());
                    			
                    // InternalAceGen.g:2270:4: ( (lv_scenarios_16_0= ruleScenario ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==RULE_ID) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalAceGen.g:2271:5: (lv_scenarios_16_0= ruleScenario )
                    	    {
                    	    // InternalAceGen.g:2271:5: (lv_scenarios_16_0= ruleScenario )
                    	    // InternalAceGen.g:2272:6: lv_scenarios_16_0= ruleScenario
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
                    	    break loop66;
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
    // InternalAceGen.g:2294:1: entryRuleHttpServerAce returns [EObject current=null] : iv_ruleHttpServerAce= ruleHttpServerAce EOF ;
    public final EObject entryRuleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAce = null;


        try {
            // InternalAceGen.g:2294:54: (iv_ruleHttpServerAce= ruleHttpServerAce EOF )
            // InternalAceGen.g:2295:2: iv_ruleHttpServerAce= ruleHttpServerAce EOF
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
    // InternalAceGen.g:2301:1: ruleHttpServerAce returns [EObject current=null] : (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) ;
    public final EObject ruleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject this_HttpServerAceWrite_0 = null;

        EObject this_HttpServerAceRead_1 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2307:2: ( (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) )
            // InternalAceGen.g:2308:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            {
            // InternalAceGen.g:2308:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            int alt68=2;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // InternalAceGen.g:2309:3: this_HttpServerAceWrite_0= ruleHttpServerAceWrite
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
                    // InternalAceGen.g:2318:3: this_HttpServerAceRead_1= ruleHttpServerAceRead
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
    // InternalAceGen.g:2330:1: entryRuleHttpServerAceWrite returns [EObject current=null] : iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF ;
    public final EObject entryRuleHttpServerAceWrite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceWrite = null;


        try {
            // InternalAceGen.g:2330:59: (iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF )
            // InternalAceGen.g:2331:2: iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF
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
    // InternalAceGen.g:2337:1: ruleHttpServerAceWrite returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_15_0= ruleHttpServerOutcome ) )* ) ;
    public final EObject ruleHttpServerAceWrite() throws RecognitionException {
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

        EObject lv_outcomes_15_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2343:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_15_0= ruleHttpServerOutcome ) )* ) )
            // InternalAceGen.g:2344:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_15_0= ruleHttpServerOutcome ) )* )
            {
            // InternalAceGen.g:2344:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_15_0= ruleHttpServerOutcome ) )* )
            // InternalAceGen.g:2345:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleWriteFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_15_0= ruleHttpServerOutcome ) )*
            {
            // InternalAceGen.g:2345:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:2346:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:2346:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:2347:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_64); 

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

            otherlv_1=(Token)match(input,59,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getHttpServerAceWriteAccess().getLessThanSignKeyword_1());
            		
            // InternalAceGen.g:2367:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2368:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2368:4: ( ruleQualifiedName )
            // InternalAceGen.g:2369:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_65);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,60,FOLLOW_66); 

            			newLeafNode(otherlv_3, grammarAccess.getHttpServerAceWriteAccess().getGreaterThanSignKeyword_3());
            		
            // InternalAceGen.g:2387:3: ( (lv_type_4_0= ruleWriteFunctionType ) )
            // InternalAceGen.g:2388:4: (lv_type_4_0= ruleWriteFunctionType )
            {
            // InternalAceGen.g:2388:4: (lv_type_4_0= ruleWriteFunctionType )
            // InternalAceGen.g:2389:5: lv_type_4_0= ruleWriteFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getTypeWriteFunctionTypeParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_41);
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

            // InternalAceGen.g:2406:3: ( (lv_url_5_0= RULE_STRING ) )
            // InternalAceGen.g:2407:4: (lv_url_5_0= RULE_STRING )
            {
            // InternalAceGen.g:2407:4: (lv_url_5_0= RULE_STRING )
            // InternalAceGen.g:2408:5: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)match(input,RULE_STRING,FOLLOW_67); 

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

            // InternalAceGen.g:2424:3: ( (lv_authorize_6_0= 'authorize' ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==61) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalAceGen.g:2425:4: (lv_authorize_6_0= 'authorize' )
                    {
                    // InternalAceGen.g:2425:4: (lv_authorize_6_0= 'authorize' )
                    // InternalAceGen.g:2426:5: lv_authorize_6_0= 'authorize'
                    {
                    lv_authorize_6_0=(Token)match(input,61,FOLLOW_68); 

                    					newLeafNode(lv_authorize_6_0, grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    					}
                    					setWithLastConsumed(current, "authorize", lv_authorize_6_0 != null, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2438:3: (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==62) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalAceGen.g:2439:4: otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_7=(Token)match(input,62,FOLLOW_69); 

                    				newLeafNode(otherlv_7, grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_7_0());
                    			
                    // InternalAceGen.g:2443:4: ( (lv_pathParams_8_0= ruleAttributeParamRef ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==RULE_ID) ) {
                            int LA70_2 = input.LA(2);

                            if ( (LA70_2==EOF||LA70_2==RULE_ID||LA70_2==16||LA70_2==25||(LA70_2>=57 && LA70_2<=58)||(LA70_2>=63 && LA70_2<=66)||LA70_2==84) ) {
                                alt70=1;
                            }


                        }
                        else if ( (LA70_0==66) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalAceGen.g:2444:5: (lv_pathParams_8_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2444:5: (lv_pathParams_8_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2445:6: lv_pathParams_8_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeParamRefParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_69);
                    	    lv_pathParams_8_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceWriteRule());
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
                    	    break loop70;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2463:3: (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==63) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalAceGen.g:2464:4: otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_9=(Token)match(input,63,FOLLOW_70); 

                    				newLeafNode(otherlv_9, grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:2468:4: ( (lv_queryParams_10_0= ruleAttributeParamRef ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==RULE_ID) ) {
                            int LA72_2 = input.LA(2);

                            if ( (LA72_2==EOF||LA72_2==RULE_ID||LA72_2==16||LA72_2==25||(LA72_2>=57 && LA72_2<=58)||(LA72_2>=64 && LA72_2<=66)||LA72_2==84) ) {
                                alt72=1;
                            }


                        }
                        else if ( (LA72_0==66) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalAceGen.g:2469:5: (lv_queryParams_10_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2469:5: (lv_queryParams_10_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2470:6: lv_queryParams_10_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeParamRefParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_70);
                    	    lv_queryParams_10_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceWriteRule());
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
                    	    break loop72;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2488:3: (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==64) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalAceGen.g:2489:4: otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_11=(Token)match(input,64,FOLLOW_71); 

                    				newLeafNode(otherlv_11, grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_9_0());
                    			
                    // InternalAceGen.g:2493:4: ( (lv_payload_12_0= ruleAttributeParamRef ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==RULE_ID) ) {
                            int LA74_2 = input.LA(2);

                            if ( (LA74_2==EOF||LA74_2==RULE_ID||LA74_2==16||LA74_2==25||(LA74_2>=57 && LA74_2<=58)||(LA74_2>=65 && LA74_2<=66)||LA74_2==84) ) {
                                alt74=1;
                            }


                        }
                        else if ( (LA74_0==66) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalAceGen.g:2494:5: (lv_payload_12_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2494:5: (lv_payload_12_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2495:6: lv_payload_12_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeParamRefParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_71);
                    	    lv_payload_12_0=ruleAttributeParamRef();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerAceWriteRule());
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
                    	    break loop74;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2513:3: (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==65) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalAceGen.g:2514:4: otherlv_13= 'response' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_13=(Token)match(input,65,FOLLOW_72); 

                    				newLeafNode(otherlv_13, grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_10_0());
                    			
                    // InternalAceGen.g:2518:4: ( ( ruleQualifiedName ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==RULE_ID) ) {
                            int LA76_2 = input.LA(2);

                            if ( (LA76_2==EOF||LA76_2==RULE_ID||LA76_2==16||LA76_2==25||(LA76_2>=57 && LA76_2<=58)||LA76_2==84) ) {
                                alt76=1;
                            }


                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalAceGen.g:2519:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:2519:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:2520:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeCrossReference_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_72);
                    	    ruleQualifiedName();

                    	    state._fsp--;


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

            // InternalAceGen.g:2535:3: ( (lv_outcomes_15_0= ruleHttpServerOutcome ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==25) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalAceGen.g:2536:4: (lv_outcomes_15_0= ruleHttpServerOutcome )
            	    {
            	    // InternalAceGen.g:2536:4: (lv_outcomes_15_0= ruleHttpServerOutcome )
            	    // InternalAceGen.g:2537:5: lv_outcomes_15_0= ruleHttpServerOutcome
            	    {

            	    					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getOutcomesHttpServerOutcomeParserRuleCall_11_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_outcomes_15_0=ruleHttpServerOutcome();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHttpServerAceWriteRule());
            	    					}
            	    					add(
            	    						current,
            	    						"outcomes",
            	    						lv_outcomes_15_0,
            	    						"de.acegen.AceGen.HttpServerOutcome");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
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
    // InternalAceGen.g:2558:1: entryRuleHttpServerOutcome returns [EObject current=null] : iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF ;
    public final EObject entryRuleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerOutcome = null;


        try {
            // InternalAceGen.g:2558:58: (iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF )
            // InternalAceGen.g:2559:2: iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF
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
    // InternalAceGen.g:2565:1: ruleHttpServerOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* ) ;
    public final EObject ruleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAceGen.g:2571:2: ( (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* ) )
            // InternalAceGen.g:2572:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* )
            {
            // InternalAceGen.g:2572:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* )
            // InternalAceGen.g:2573:3: otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )*
            {
            otherlv_0=(Token)match(input,25,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpServerOutcomeAccess().getOnKeyword_0());
            		
            // InternalAceGen.g:2577:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:2578:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:2578:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:2579:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_73); 

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

            // InternalAceGen.g:2595:3: (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==18) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalAceGen.g:2596:4: otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')'
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_37); 

            	    				newLeafNode(otherlv_2, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0());
            	    			
            	    // InternalAceGen.g:2600:4: ( ( ruleQualifiedName ) )*
            	    loop79:
            	    do {
            	        int alt79=2;
            	        int LA79_0 = input.LA(1);

            	        if ( (LA79_0==RULE_ID) ) {
            	            alt79=1;
            	        }


            	        switch (alt79) {
            	    	case 1 :
            	    	    // InternalAceGen.g:2601:5: ( ruleQualifiedName )
            	    	    {
            	    	    // InternalAceGen.g:2601:5: ( ruleQualifiedName )
            	    	    // InternalAceGen.g:2602:6: ruleQualifiedName
            	    	    {

            	    	    						if (current==null) {
            	    	    							current = createModelElement(grammarAccess.getHttpServerOutcomeRule());
            	    	    						}
            	    	    					

            	    	    						newCompositeNode(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0());
            	    	    					
            	    	    pushFollow(FOLLOW_37);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;


            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop79;
            	        }
            	    } while (true);

            	    otherlv_4=(Token)match(input,20,FOLLOW_73); 

            	    				newLeafNode(otherlv_4, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop80;
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
    // InternalAceGen.g:2625:1: entryRuleHttpServerAceRead returns [EObject current=null] : iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF ;
    public final EObject entryRuleHttpServerAceRead() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceRead = null;


        try {
            // InternalAceGen.g:2625:58: (iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF )
            // InternalAceGen.g:2626:2: iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF
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
    // InternalAceGen.g:2632:1: ruleHttpServerAceRead returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? ) ;
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
            // InternalAceGen.g:2638:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? ) )
            // InternalAceGen.g:2639:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? )
            {
            // InternalAceGen.g:2639:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )? )
            // InternalAceGen.g:2640:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '<' ( ( ruleQualifiedName ) ) otherlv_3= '>' ( (lv_type_4_0= ruleReadFunctionType ) ) ( (lv_url_5_0= RULE_STRING ) ) ( (lv_authorize_6_0= 'authorize' ) )? (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )? (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )? (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )? (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )?
            {
            // InternalAceGen.g:2640:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:2641:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:2641:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:2642:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_64); 

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

            otherlv_1=(Token)match(input,59,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getHttpServerAceReadAccess().getLessThanSignKeyword_1());
            		
            // InternalAceGen.g:2662:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2663:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2663:4: ( ruleQualifiedName )
            // InternalAceGen.g:2664:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_65);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,60,FOLLOW_74); 

            			newLeafNode(otherlv_3, grammarAccess.getHttpServerAceReadAccess().getGreaterThanSignKeyword_3());
            		
            // InternalAceGen.g:2682:3: ( (lv_type_4_0= ruleReadFunctionType ) )
            // InternalAceGen.g:2683:4: (lv_type_4_0= ruleReadFunctionType )
            {
            // InternalAceGen.g:2683:4: (lv_type_4_0= ruleReadFunctionType )
            // InternalAceGen.g:2684:5: lv_type_4_0= ruleReadFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getTypeReadFunctionTypeParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_41);
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

            // InternalAceGen.g:2701:3: ( (lv_url_5_0= RULE_STRING ) )
            // InternalAceGen.g:2702:4: (lv_url_5_0= RULE_STRING )
            {
            // InternalAceGen.g:2702:4: (lv_url_5_0= RULE_STRING )
            // InternalAceGen.g:2703:5: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)match(input,RULE_STRING,FOLLOW_75); 

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

            // InternalAceGen.g:2719:3: ( (lv_authorize_6_0= 'authorize' ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==61) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalAceGen.g:2720:4: (lv_authorize_6_0= 'authorize' )
                    {
                    // InternalAceGen.g:2720:4: (lv_authorize_6_0= 'authorize' )
                    // InternalAceGen.g:2721:5: lv_authorize_6_0= 'authorize'
                    {
                    lv_authorize_6_0=(Token)match(input,61,FOLLOW_76); 

                    					newLeafNode(lv_authorize_6_0, grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    					}
                    					setWithLastConsumed(current, "authorize", lv_authorize_6_0 != null, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2733:3: (otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )* )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==62) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalAceGen.g:2734:4: otherlv_7= 'pathParams' ( (lv_pathParams_8_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_7=(Token)match(input,62,FOLLOW_77); 

                    				newLeafNode(otherlv_7, grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_7_0());
                    			
                    // InternalAceGen.g:2738:4: ( (lv_pathParams_8_0= ruleAttributeParamRef ) )*
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==RULE_ID) ) {
                            int LA82_2 = input.LA(2);

                            if ( (LA82_2==EOF||LA82_2==RULE_ID||LA82_2==16||(LA82_2>=57 && LA82_2<=58)||(LA82_2>=63 && LA82_2<=66)||LA82_2==84) ) {
                                alt82=1;
                            }


                        }
                        else if ( (LA82_0==66) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // InternalAceGen.g:2739:5: (lv_pathParams_8_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2739:5: (lv_pathParams_8_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2740:6: lv_pathParams_8_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeParamRefParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_77);
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
                    	    break loop82;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2758:3: (otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )* )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==63) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalAceGen.g:2759:4: otherlv_9= 'queryParams' ( (lv_queryParams_10_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_9=(Token)match(input,63,FOLLOW_78); 

                    				newLeafNode(otherlv_9, grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:2763:4: ( (lv_queryParams_10_0= ruleAttributeParamRef ) )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==RULE_ID) ) {
                            int LA84_2 = input.LA(2);

                            if ( (LA84_2==EOF||LA84_2==RULE_ID||LA84_2==16||(LA84_2>=57 && LA84_2<=58)||(LA84_2>=64 && LA84_2<=66)||LA84_2==84) ) {
                                alt84=1;
                            }


                        }
                        else if ( (LA84_0==66) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // InternalAceGen.g:2764:5: (lv_queryParams_10_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2764:5: (lv_queryParams_10_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2765:6: lv_queryParams_10_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeParamRefParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_78);
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
                    	    break loop84;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2783:3: (otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )* )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==64) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalAceGen.g:2784:4: otherlv_11= 'payload' ( (lv_payload_12_0= ruleAttributeParamRef ) )*
                    {
                    otherlv_11=(Token)match(input,64,FOLLOW_79); 

                    				newLeafNode(otherlv_11, grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_9_0());
                    			
                    // InternalAceGen.g:2788:4: ( (lv_payload_12_0= ruleAttributeParamRef ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==RULE_ID) ) {
                            int LA86_2 = input.LA(2);

                            if ( (LA86_2==EOF||LA86_2==RULE_ID||LA86_2==16||(LA86_2>=57 && LA86_2<=58)||(LA86_2>=65 && LA86_2<=66)||LA86_2==84) ) {
                                alt86=1;
                            }


                        }
                        else if ( (LA86_0==66) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // InternalAceGen.g:2789:5: (lv_payload_12_0= ruleAttributeParamRef )
                    	    {
                    	    // InternalAceGen.g:2789:5: (lv_payload_12_0= ruleAttributeParamRef )
                    	    // InternalAceGen.g:2790:6: lv_payload_12_0= ruleAttributeParamRef
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeParamRefParserRuleCall_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_79);
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
                    	    break loop86;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:2808:3: (otherlv_13= 'response' ( ( ruleQualifiedName ) )* )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==65) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalAceGen.g:2809:4: otherlv_13= 'response' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_13=(Token)match(input,65,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_10_0());
                    			
                    // InternalAceGen.g:2813:4: ( ( ruleQualifiedName ) )*
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==RULE_ID) ) {
                            int LA88_2 = input.LA(2);

                            if ( (LA88_2==EOF||LA88_2==RULE_ID||LA88_2==16||(LA88_2>=57 && LA88_2<=58)||LA88_2==84) ) {
                                alt88=1;
                            }


                        }


                        switch (alt88) {
                    	case 1 :
                    	    // InternalAceGen.g:2814:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:2814:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:2815:6: ruleQualifiedName
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
                    	    break loop88;
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
    // InternalAceGen.g:2834:1: entryRuleAttributeParamRef returns [EObject current=null] : iv_ruleAttributeParamRef= ruleAttributeParamRef EOF ;
    public final EObject entryRuleAttributeParamRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeParamRef = null;


        try {
            // InternalAceGen.g:2834:58: (iv_ruleAttributeParamRef= ruleAttributeParamRef EOF )
            // InternalAceGen.g:2835:2: iv_ruleAttributeParamRef= ruleAttributeParamRef EOF
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
    // InternalAceGen.g:2841:1: ruleAttributeParamRef returns [EObject current=null] : ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleAttributeParamRef() throws RecognitionException {
        EObject current = null;

        Token lv_notNull_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:2847:2: ( ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:2848:2: ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:2848:2: ( ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:2849:3: ( (lv_notNull_0_0= 'NotNull' ) )? ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:2849:3: ( (lv_notNull_0_0= 'NotNull' ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==66) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalAceGen.g:2850:4: (lv_notNull_0_0= 'NotNull' )
                    {
                    // InternalAceGen.g:2850:4: (lv_notNull_0_0= 'NotNull' )
                    // InternalAceGen.g:2851:5: lv_notNull_0_0= 'NotNull'
                    {
                    lv_notNull_0_0=(Token)match(input,66,FOLLOW_9); 

                    					newLeafNode(lv_notNull_0_0, grammarAccess.getAttributeParamRefAccess().getNotNullNotNullKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeParamRefRule());
                    					}
                    					setWithLastConsumed(current, "notNull", lv_notNull_0_0 != null, "NotNull");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2863:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:2864:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:2864:4: ( ruleQualifiedName )
            // InternalAceGen.g:2865:5: ruleQualifiedName
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
    // InternalAceGen.g:2883:1: entryRuleHttpServerView returns [EObject current=null] : iv_ruleHttpServerView= ruleHttpServerView EOF ;
    public final EObject entryRuleHttpServerView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerView = null;


        try {
            // InternalAceGen.g:2883:55: (iv_ruleHttpServerView= ruleHttpServerView EOF )
            // InternalAceGen.g:2884:2: iv_ruleHttpServerView= ruleHttpServerView EOF
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
    // InternalAceGen.g:2890:1: ruleHttpServerView returns [EObject current=null] : ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? ) ;
    public final EObject ruleHttpServerView() throws RecognitionException {
        EObject current = null;

        Token lv_afterCommit_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_renderFunctions_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:2896:2: ( ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? ) )
            // InternalAceGen.g:2897:2: ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? )
            {
            // InternalAceGen.g:2897:2: ( ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )? )
            // InternalAceGen.g:2898:3: ( (lv_afterCommit_0_0= 'afterCommit' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )?
            {
            // InternalAceGen.g:2898:3: ( (lv_afterCommit_0_0= 'afterCommit' ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==67) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalAceGen.g:2899:4: (lv_afterCommit_0_0= 'afterCommit' )
                    {
                    // InternalAceGen.g:2899:4: (lv_afterCommit_0_0= 'afterCommit' )
                    // InternalAceGen.g:2900:5: lv_afterCommit_0_0= 'afterCommit'
                    {
                    lv_afterCommit_0_0=(Token)match(input,67,FOLLOW_9); 

                    					newLeafNode(lv_afterCommit_0_0, grammarAccess.getHttpServerViewAccess().getAfterCommitAfterCommitKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerViewRule());
                    					}
                    					setWithLastConsumed(current, "afterCommit", lv_afterCommit_0_0 != null, "afterCommit");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:2912:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:2913:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:2913:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:2914:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_26); 

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

            // InternalAceGen.g:2930:3: (otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}' )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==35) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalAceGen.g:2931:4: otherlv_2= '{' ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,35,FOLLOW_80); 

                    				newLeafNode(otherlv_2, grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_2_0());
                    			
                    // InternalAceGen.g:2935:4: ( (lv_renderFunctions_3_0= ruleHttpServerViewFunction ) )*
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==RULE_ID) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                    	case 1 :
                    	    // InternalAceGen.g:2936:5: (lv_renderFunctions_3_0= ruleHttpServerViewFunction )
                    	    {
                    	    // InternalAceGen.g:2936:5: (lv_renderFunctions_3_0= ruleHttpServerViewFunction )
                    	    // InternalAceGen.g:2937:6: lv_renderFunctions_3_0= ruleHttpServerViewFunction
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerViewAccess().getRenderFunctionsHttpServerViewFunctionParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_80);
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
                    	    break loop92;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,36,FOLLOW_2); 

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
    // InternalAceGen.g:2963:1: entryRuleHttpServerViewFunction returns [EObject current=null] : iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF ;
    public final EObject entryRuleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerViewFunction = null;


        try {
            // InternalAceGen.g:2963:63: (iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF )
            // InternalAceGen.g:2964:2: iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF
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
    // InternalAceGen.g:2970:1: ruleHttpServerViewFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) ;
    public final EObject ruleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalAceGen.g:2976:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) )
            // InternalAceGen.g:2977:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            {
            // InternalAceGen.g:2977:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            // InternalAceGen.g:2978:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')'
            {
            // InternalAceGen.g:2978:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:2979:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:2979:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:2980:5: lv_name_0_0= RULE_ID
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
            		
            // InternalAceGen.g:3000:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3001:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3001:4: ( ruleQualifiedName )
            // InternalAceGen.g:3002:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerViewFunctionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_81);
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
    // InternalAceGen.g:3024:1: entryRuleAuthUser returns [EObject current=null] : iv_ruleAuthUser= ruleAuthUser EOF ;
    public final EObject entryRuleAuthUser() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthUser = null;


        try {
            // InternalAceGen.g:3024:49: (iv_ruleAuthUser= ruleAuthUser EOF )
            // InternalAceGen.g:3025:2: iv_ruleAuthUser= ruleAuthUser EOF
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
    // InternalAceGen.g:3031:1: ruleAuthUser returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) ;
    public final EObject ruleAuthUser() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3037:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) )
            // InternalAceGen.g:3038:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            {
            // InternalAceGen.g:3038:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            // InternalAceGen.g:3039:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            {
            // InternalAceGen.g:3039:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3040:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3040:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3041:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_28); 

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

            // InternalAceGen.g:3057:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            // InternalAceGen.g:3058:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}'
            {
            otherlv_1=(Token)match(input,35,FOLLOW_82); 

            				newLeafNode(otherlv_1, grammarAccess.getAuthUserAccess().getLeftCurlyBracketKeyword_1_0());
            			
            // InternalAceGen.g:3062:4: ( (lv_attributes_2_0= ruleAttribute ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==RULE_ID||LA94_0==32||LA94_0==66||(LA94_0>=81 && LA94_0<=82)||(LA94_0>=89 && LA94_0<=94)) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalAceGen.g:3063:5: (lv_attributes_2_0= ruleAttribute )
            	    {
            	    // InternalAceGen.g:3063:5: (lv_attributes_2_0= ruleAttribute )
            	    // InternalAceGen.g:3064:6: lv_attributes_2_0= ruleAttribute
            	    {

            	    						newCompositeNode(grammarAccess.getAuthUserAccess().getAttributesAttributeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_82);
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
            	    break loop94;
                }
            } while (true);

            otherlv_3=(Token)match(input,36,FOLLOW_2); 

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
    // InternalAceGen.g:3090:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAceGen.g:3090:46: (iv_ruleModel= ruleModel EOF )
            // InternalAceGen.g:3091:2: iv_ruleModel= ruleModel EOF
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
    // InternalAceGen.g:3097:1: ruleModel returns [EObject current=null] : ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) ;
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
            // InternalAceGen.g:3103:2: ( ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) )
            // InternalAceGen.g:3104:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            {
            // InternalAceGen.g:3104:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            // InternalAceGen.g:3105:3: ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            {
            // InternalAceGen.g:3105:3: ( (lv_persistent_0_0= 'persistent' ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==68) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalAceGen.g:3106:4: (lv_persistent_0_0= 'persistent' )
                    {
                    // InternalAceGen.g:3106:4: (lv_persistent_0_0= 'persistent' )
                    // InternalAceGen.g:3107:5: lv_persistent_0_0= 'persistent'
                    {
                    lv_persistent_0_0=(Token)match(input,68,FOLLOW_9); 

                    					newLeafNode(lv_persistent_0_0, grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(current, "persistent", lv_persistent_0_0 != null, "persistent");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:3119:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:3120:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:3120:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:3121:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_83); 

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

            // InternalAceGen.g:3137:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==69) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalAceGen.g:3138:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_2=(Token)match(input,69,FOLLOW_9); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getExtendsKeyword_2_0());
                    			
                    // InternalAceGen.g:3142:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:3143:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:3143:5: ( ruleQualifiedName )
                    // InternalAceGen.g:3144:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_84);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:3158:4: (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    loop96:
                    do {
                        int alt96=2;
                        int LA96_0 = input.LA(1);

                        if ( (LA96_0==19) ) {
                            alt96=1;
                        }


                        switch (alt96) {
                    	case 1 :
                    	    // InternalAceGen.g:3159:5: otherlv_4= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_9); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getModelAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:3163:5: ( ( ruleQualifiedName ) )
                    	    // InternalAceGen.g:3164:6: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:3164:6: ( ruleQualifiedName )
                    	    // InternalAceGen.g:3165:7: ruleQualifiedName
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModelRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_84);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop96;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:3181:3: (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==35) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalAceGen.g:3182:4: otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,35,FOLLOW_82); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalAceGen.g:3186:4: ( (lv_attributes_7_0= ruleAttribute ) )*
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==RULE_ID||LA98_0==32||LA98_0==66||(LA98_0>=81 && LA98_0<=82)||(LA98_0>=89 && LA98_0<=94)) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // InternalAceGen.g:3187:5: (lv_attributes_7_0= ruleAttribute )
                    	    {
                    	    // InternalAceGen.g:3187:5: (lv_attributes_7_0= ruleAttribute )
                    	    // InternalAceGen.g:3188:6: lv_attributes_7_0= ruleAttribute
                    	    {

                    	    						newCompositeNode(grammarAccess.getModelAccess().getAttributesAttributeParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_82);
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
                    	    break loop98;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,36,FOLLOW_2); 

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
    // InternalAceGen.g:3214:1: entryRuleScenario returns [EObject current=null] : iv_ruleScenario= ruleScenario EOF ;
    public final EObject entryRuleScenario() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario = null;


        try {
            // InternalAceGen.g:3214:49: (iv_ruleScenario= ruleScenario EOF )
            // InternalAceGen.g:3215:2: iv_ruleScenario= ruleScenario EOF
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
    // InternalAceGen.g:3221:1: ruleScenario returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) ) ;
    public final EObject ruleScenario() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_givenItems_2_0 = null;

        EObject lv_whenBlock_4_0 = null;

        EObject lv_thenBlock_6_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3227:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) ) )
            // InternalAceGen.g:3228:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) )
            {
            // InternalAceGen.g:3228:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) ) )
            // InternalAceGen.g:3229:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )? otherlv_3= 'WHEN' ( (lv_whenBlock_4_0= ruleWhenBlock ) ) otherlv_5= 'THEN' ( (lv_thenBlock_6_0= ruleThenBlock ) )
            {
            // InternalAceGen.g:3229:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3230:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3230:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3231:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_30); 

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

            // InternalAceGen.g:3247:3: (otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )* )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==37) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalAceGen.g:3248:4: otherlv_1= 'GIVEN' ( (lv_givenItems_2_0= ruleGiven ) )*
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_31); 

                    				newLeafNode(otherlv_1, grammarAccess.getScenarioAccess().getGIVENKeyword_1_0());
                    			
                    // InternalAceGen.g:3252:4: ( (lv_givenItems_2_0= ruleGiven ) )*
                    loop100:
                    do {
                        int alt100=2;
                        int LA100_0 = input.LA(1);

                        if ( (LA100_0==RULE_ID) ) {
                            alt100=1;
                        }


                        switch (alt100) {
                    	case 1 :
                    	    // InternalAceGen.g:3253:5: (lv_givenItems_2_0= ruleGiven )
                    	    {
                    	    // InternalAceGen.g:3253:5: (lv_givenItems_2_0= ruleGiven )
                    	    // InternalAceGen.g:3254:6: lv_givenItems_2_0= ruleGiven
                    	    {

                    	    						newCompositeNode(grammarAccess.getScenarioAccess().getGivenItemsGivenParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_31);
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
                    	    break loop100;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_3=(Token)match(input,38,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getScenarioAccess().getWHENKeyword_2());
            		
            // InternalAceGen.g:3276:3: ( (lv_whenBlock_4_0= ruleWhenBlock ) )
            // InternalAceGen.g:3277:4: (lv_whenBlock_4_0= ruleWhenBlock )
            {
            // InternalAceGen.g:3277:4: (lv_whenBlock_4_0= ruleWhenBlock )
            // InternalAceGen.g:3278:5: lv_whenBlock_4_0= ruleWhenBlock
            {

            					newCompositeNode(grammarAccess.getScenarioAccess().getWhenBlockWhenBlockParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_34);
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

            otherlv_5=(Token)match(input,39,FOLLOW_22); 

            			newLeafNode(otherlv_5, grammarAccess.getScenarioAccess().getTHENKeyword_4());
            		
            // InternalAceGen.g:3299:3: ( (lv_thenBlock_6_0= ruleThenBlock ) )
            // InternalAceGen.g:3300:4: (lv_thenBlock_6_0= ruleThenBlock )
            {
            // InternalAceGen.g:3300:4: (lv_thenBlock_6_0= ruleThenBlock )
            // InternalAceGen.g:3301:5: lv_thenBlock_6_0= ruleThenBlock
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


    // $ANTLR start "entryRuleGiven"
    // InternalAceGen.g:3322:1: entryRuleGiven returns [EObject current=null] : iv_ruleGiven= ruleGiven EOF ;
    public final EObject entryRuleGiven() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGiven = null;


        try {
            // InternalAceGen.g:3322:46: (iv_ruleGiven= ruleGiven EOF )
            // InternalAceGen.g:3323:2: iv_ruleGiven= ruleGiven EOF
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
    // InternalAceGen.g:3329:1: ruleGiven returns [EObject current=null] : (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall ) ;
    public final EObject ruleGiven() throws RecognitionException {
        EObject current = null;

        EObject this_GivenRef_0 = null;

        EObject this_CustomCall_1 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3335:2: ( (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall ) )
            // InternalAceGen.g:3336:2: (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall )
            {
            // InternalAceGen.g:3336:2: (this_GivenRef_0= ruleGivenRef | this_CustomCall_1= ruleCustomCall )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==RULE_ID) ) {
                int LA102_1 = input.LA(2);

                if ( (LA102_1==EOF||(LA102_1>=RULE_ID && LA102_1<=RULE_INT)||LA102_1==38||LA102_1==71||LA102_1==84) ) {
                    alt102=1;
                }
                else if ( (LA102_1==18) ) {
                    alt102=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 102, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // InternalAceGen.g:3337:3: this_GivenRef_0= ruleGivenRef
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
                    // InternalAceGen.g:3346:3: this_CustomCall_1= ruleCustomCall
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
    // InternalAceGen.g:3358:1: entryRuleCustomCall returns [EObject current=null] : iv_ruleCustomCall= ruleCustomCall EOF ;
    public final EObject entryRuleCustomCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomCall = null;


        try {
            // InternalAceGen.g:3358:51: (iv_ruleCustomCall= ruleCustomCall EOF )
            // InternalAceGen.g:3359:2: iv_ruleCustomCall= ruleCustomCall EOF
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
    // InternalAceGen.g:3365:1: ruleCustomCall returns [EObject current=null] : ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? ) ;
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
            // InternalAceGen.g:3371:2: ( ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? ) )
            // InternalAceGen.g:3372:2: ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? )
            {
            // InternalAceGen.g:3372:2: ( ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )? )
            // InternalAceGen.g:3373:3: ( (lv_customCallName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )? otherlv_5= ')' ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )?
            {
            // InternalAceGen.g:3373:3: ( (lv_customCallName_0_0= RULE_ID ) )
            // InternalAceGen.g:3374:4: (lv_customCallName_0_0= RULE_ID )
            {
            // InternalAceGen.g:3374:4: (lv_customCallName_0_0= RULE_ID )
            // InternalAceGen.g:3375:5: lv_customCallName_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,18,FOLLOW_85); 

            			newLeafNode(otherlv_1, grammarAccess.getCustomCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:3395:3: ( ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )* )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( ((LA104_0>=RULE_INT && LA104_0<=RULE_STRING)) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalAceGen.g:3396:4: ( (lv_values_2_0= rulePrimitiveValue ) ) (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )*
                    {
                    // InternalAceGen.g:3396:4: ( (lv_values_2_0= rulePrimitiveValue ) )
                    // InternalAceGen.g:3397:5: (lv_values_2_0= rulePrimitiveValue )
                    {
                    // InternalAceGen.g:3397:5: (lv_values_2_0= rulePrimitiveValue )
                    // InternalAceGen.g:3398:6: lv_values_2_0= rulePrimitiveValue
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

                    // InternalAceGen.g:3415:4: (otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) ) )*
                    loop103:
                    do {
                        int alt103=2;
                        int LA103_0 = input.LA(1);

                        if ( (LA103_0==19) ) {
                            alt103=1;
                        }


                        switch (alt103) {
                    	case 1 :
                    	    // InternalAceGen.g:3416:5: otherlv_3= ',' ( (lv_values_4_0= rulePrimitiveValue ) )
                    	    {
                    	    otherlv_3=(Token)match(input,19,FOLLOW_46); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getCustomCallAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalAceGen.g:3420:5: ( (lv_values_4_0= rulePrimitiveValue ) )
                    	    // InternalAceGen.g:3421:6: (lv_values_4_0= rulePrimitiveValue )
                    	    {
                    	    // InternalAceGen.g:3421:6: (lv_values_4_0= rulePrimitiveValue )
                    	    // InternalAceGen.g:3422:7: lv_values_4_0= rulePrimitiveValue
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
                    	    break loop103;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_86); 

            			newLeafNode(otherlv_5, grammarAccess.getCustomCallAccess().getRightParenthesisKeyword_3());
            		
            // InternalAceGen.g:3445:3: ( ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x' )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==RULE_INT) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalAceGen.g:3446:4: ( (lv_times_6_0= RULE_INT ) ) otherlv_7= 'x'
                    {
                    // InternalAceGen.g:3446:4: ( (lv_times_6_0= RULE_INT ) )
                    // InternalAceGen.g:3447:5: (lv_times_6_0= RULE_INT )
                    {
                    // InternalAceGen.g:3447:5: (lv_times_6_0= RULE_INT )
                    // InternalAceGen.g:3448:6: lv_times_6_0= RULE_INT
                    {
                    lv_times_6_0=(Token)match(input,RULE_INT,FOLLOW_87); 

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

                    otherlv_7=(Token)match(input,70,FOLLOW_2); 

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
    // InternalAceGen.g:3473:1: entryRuleGivenRef returns [EObject current=null] : iv_ruleGivenRef= ruleGivenRef EOF ;
    public final EObject entryRuleGivenRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGivenRef = null;


        try {
            // InternalAceGen.g:3473:49: (iv_ruleGivenRef= ruleGivenRef EOF )
            // InternalAceGen.g:3474:2: iv_ruleGivenRef= ruleGivenRef EOF
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
    // InternalAceGen.g:3480:1: ruleGivenRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? ) ;
    public final EObject ruleGivenRef() throws RecognitionException {
        EObject current = null;

        Token lv_times_1_0=null;
        Token otherlv_2=null;
        Token lv_excludeGiven_3_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:3486:2: ( ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? ) )
            // InternalAceGen.g:3487:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? )
            {
            // InternalAceGen.g:3487:2: ( ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )? )
            // InternalAceGen.g:3488:3: ( ( ruleQualifiedName ) ) ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )? ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )?
            {
            // InternalAceGen.g:3488:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3489:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3489:4: ( ruleQualifiedName )
            // InternalAceGen.g:3490:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGivenRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGivenRefAccess().getScenarioScenarioCrossReference_0_0());
            				
            pushFollow(FOLLOW_88);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3504:3: ( ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x' )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==RULE_INT) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalAceGen.g:3505:4: ( (lv_times_1_0= RULE_INT ) ) otherlv_2= 'x'
                    {
                    // InternalAceGen.g:3505:4: ( (lv_times_1_0= RULE_INT ) )
                    // InternalAceGen.g:3506:5: (lv_times_1_0= RULE_INT )
                    {
                    // InternalAceGen.g:3506:5: (lv_times_1_0= RULE_INT )
                    // InternalAceGen.g:3507:6: lv_times_1_0= RULE_INT
                    {
                    lv_times_1_0=(Token)match(input,RULE_INT,FOLLOW_87); 

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

                    otherlv_2=(Token)match(input,70,FOLLOW_89); 

                    				newLeafNode(otherlv_2, grammarAccess.getGivenRefAccess().getXKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:3528:3: ( (lv_excludeGiven_3_0= 'excludeGIVEN' ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==71) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // InternalAceGen.g:3529:4: (lv_excludeGiven_3_0= 'excludeGIVEN' )
                    {
                    // InternalAceGen.g:3529:4: (lv_excludeGiven_3_0= 'excludeGIVEN' )
                    // InternalAceGen.g:3530:5: lv_excludeGiven_3_0= 'excludeGIVEN'
                    {
                    lv_excludeGiven_3_0=(Token)match(input,71,FOLLOW_2); 

                    					newLeafNode(lv_excludeGiven_3_0, grammarAccess.getGivenRefAccess().getExcludeGivenExcludeGIVENKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getGivenRefRule());
                    					}
                    					setWithLastConsumed(current, "excludeGiven", lv_excludeGiven_3_0 != null, "excludeGIVEN");
                    				

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
    // InternalAceGen.g:3546:1: entryRuleWhenBlock returns [EObject current=null] : iv_ruleWhenBlock= ruleWhenBlock EOF ;
    public final EObject entryRuleWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhenBlock = null;


        try {
            // InternalAceGen.g:3546:50: (iv_ruleWhenBlock= ruleWhenBlock EOF )
            // InternalAceGen.g:3547:2: iv_ruleWhenBlock= ruleWhenBlock EOF
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
    // InternalAceGen.g:3553:1: ruleWhenBlock returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* ) ;
    public final EObject ruleWhenBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_dataDefinition_1_0 = null;

        EObject lv_authorization_2_0 = null;

        EObject lv_extractions_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3559:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* ) )
            // InternalAceGen.g:3560:2: ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* )
            {
            // InternalAceGen.g:3560:2: ( ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )* )
            // InternalAceGen.g:3561:3: ( ( ruleQualifiedName ) ) ( (lv_dataDefinition_1_0= ruleDataDefinition ) ) ( (lv_authorization_2_0= ruleAuthorization ) )? ( (lv_extractions_3_0= ruleExtraction ) )*
            {
            // InternalAceGen.g:3561:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3562:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3562:4: ( ruleQualifiedName )
            // InternalAceGen.g:3563:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWhenBlockRule());
            					}
            				

            					newCompositeNode(grammarAccess.getWhenBlockAccess().getActionHttpServerAceCrossReference_0_0());
            				
            pushFollow(FOLLOW_90);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3577:3: ( (lv_dataDefinition_1_0= ruleDataDefinition ) )
            // InternalAceGen.g:3578:4: (lv_dataDefinition_1_0= ruleDataDefinition )
            {
            // InternalAceGen.g:3578:4: (lv_dataDefinition_1_0= ruleDataDefinition )
            // InternalAceGen.g:3579:5: lv_dataDefinition_1_0= ruleDataDefinition
            {

            					newCompositeNode(grammarAccess.getWhenBlockAccess().getDataDefinitionDataDefinitionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_91);
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

            // InternalAceGen.g:3596:3: ( (lv_authorization_2_0= ruleAuthorization ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==80) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalAceGen.g:3597:4: (lv_authorization_2_0= ruleAuthorization )
                    {
                    // InternalAceGen.g:3597:4: (lv_authorization_2_0= ruleAuthorization )
                    // InternalAceGen.g:3598:5: lv_authorization_2_0= ruleAuthorization
                    {

                    					newCompositeNode(grammarAccess.getWhenBlockAccess().getAuthorizationAuthorizationParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_92);
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

            // InternalAceGen.g:3615:3: ( (lv_extractions_3_0= ruleExtraction ) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==76) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // InternalAceGen.g:3616:4: (lv_extractions_3_0= ruleExtraction )
            	    {
            	    // InternalAceGen.g:3616:4: (lv_extractions_3_0= ruleExtraction )
            	    // InternalAceGen.g:3617:5: lv_extractions_3_0= ruleExtraction
            	    {

            	    					newCompositeNode(grammarAccess.getWhenBlockAccess().getExtractionsExtractionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_92);
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
            	    break loop109;
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
    // InternalAceGen.g:3638:1: entryRuleThenBlock returns [EObject current=null] : iv_ruleThenBlock= ruleThenBlock EOF ;
    public final EObject entryRuleThenBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThenBlock = null;


        try {
            // InternalAceGen.g:3638:50: (iv_ruleThenBlock= ruleThenBlock EOF )
            // InternalAceGen.g:3639:2: iv_ruleThenBlock= ruleThenBlock EOF
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
    // InternalAceGen.g:3645:1: ruleThenBlock returns [EObject current=null] : ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? ) ;
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
            // InternalAceGen.g:3651:2: ( ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? ) )
            // InternalAceGen.g:3652:2: ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? )
            {
            // InternalAceGen.g:3652:2: ( ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )? )
            // InternalAceGen.g:3653:3: ( (lv_statusCode_0_0= RULE_INT ) ) (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )? (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )? (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )?
            {
            // InternalAceGen.g:3653:3: ( (lv_statusCode_0_0= RULE_INT ) )
            // InternalAceGen.g:3654:4: (lv_statusCode_0_0= RULE_INT )
            {
            // InternalAceGen.g:3654:4: (lv_statusCode_0_0= RULE_INT )
            // InternalAceGen.g:3655:5: lv_statusCode_0_0= RULE_INT
            {
            lv_statusCode_0_0=(Token)match(input,RULE_INT,FOLLOW_93); 

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

            // InternalAceGen.g:3671:3: (otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==65) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalAceGen.g:3672:4: otherlv_1= 'response' otherlv_2= 'shouldBe' ( (lv_response_3_0= ruleDataDefinition ) )
                    {
                    otherlv_1=(Token)match(input,65,FOLLOW_49); 

                    				newLeafNode(otherlv_1, grammarAccess.getThenBlockAccess().getResponseKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,48,FOLLOW_94); 

                    				newLeafNode(otherlv_2, grammarAccess.getThenBlockAccess().getShouldBeKeyword_1_1());
                    			
                    // InternalAceGen.g:3680:4: ( (lv_response_3_0= ruleDataDefinition ) )
                    // InternalAceGen.g:3681:5: (lv_response_3_0= ruleDataDefinition )
                    {
                    // InternalAceGen.g:3681:5: (lv_response_3_0= ruleDataDefinition )
                    // InternalAceGen.g:3682:6: lv_response_3_0= ruleDataDefinition
                    {

                    						newCompositeNode(grammarAccess.getThenBlockAccess().getResponseDataDefinitionParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_95);
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

            // InternalAceGen.g:3700:3: (otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )* )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==72) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalAceGen.g:3701:4: otherlv_4= 'persistence' ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )*
                    {
                    otherlv_4=(Token)match(input,72,FOLLOW_48); 

                    				newLeafNode(otherlv_4, grammarAccess.getThenBlockAccess().getPersistenceKeyword_2_0());
                    			
                    // InternalAceGen.g:3705:4: ( (lv_persistenceVerifications_5_0= rulePersistenceVerification ) )*
                    loop111:
                    do {
                        int alt111=2;
                        int LA111_0 = input.LA(1);

                        if ( (LA111_0==RULE_ID) ) {
                            int LA111_2 = input.LA(2);

                            if ( (LA111_2==RULE_ID) ) {
                                alt111=1;
                            }


                        }


                        switch (alt111) {
                    	case 1 :
                    	    // InternalAceGen.g:3706:5: (lv_persistenceVerifications_5_0= rulePersistenceVerification )
                    	    {
                    	    // InternalAceGen.g:3706:5: (lv_persistenceVerifications_5_0= rulePersistenceVerification )
                    	    // InternalAceGen.g:3707:6: lv_persistenceVerifications_5_0= rulePersistenceVerification
                    	    {

                    	    						newCompositeNode(grammarAccess.getThenBlockAccess().getPersistenceVerificationsPersistenceVerificationParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_48);
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
                    	    break loop111;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:3725:3: (otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )* )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==47) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalAceGen.g:3726:4: otherlv_6= 'verifications' ( (lv_verifications_7_0= ruleVerification ) )*
                    {
                    otherlv_6=(Token)match(input,47,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getThenBlockAccess().getVerificationsKeyword_3_0());
                    			
                    // InternalAceGen.g:3730:4: ( (lv_verifications_7_0= ruleVerification ) )*
                    loop113:
                    do {
                        int alt113=2;
                        int LA113_0 = input.LA(1);

                        if ( (LA113_0==RULE_ID) ) {
                            int LA113_2 = input.LA(2);

                            if ( (LA113_2==EOF||LA113_2==RULE_ID) ) {
                                alt113=1;
                            }


                        }


                        switch (alt113) {
                    	case 1 :
                    	    // InternalAceGen.g:3731:5: (lv_verifications_7_0= ruleVerification )
                    	    {
                    	    // InternalAceGen.g:3731:5: (lv_verifications_7_0= ruleVerification )
                    	    // InternalAceGen.g:3732:6: lv_verifications_7_0= ruleVerification
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
                    	    break loop113;
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
    // InternalAceGen.g:3754:1: entryRulePersistenceVerification returns [EObject current=null] : iv_rulePersistenceVerification= rulePersistenceVerification EOF ;
    public final EObject entryRulePersistenceVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersistenceVerification = null;


        try {
            // InternalAceGen.g:3754:64: (iv_rulePersistenceVerification= rulePersistenceVerification EOF )
            // InternalAceGen.g:3755:2: iv_rulePersistenceVerification= rulePersistenceVerification EOF
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
    // InternalAceGen.g:3761:1: rulePersistenceVerification returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) ) ;
    public final EObject rulePersistenceVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3767:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) ) )
            // InternalAceGen.g:3768:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) )
            {
            // InternalAceGen.g:3768:2: ( ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) ) )
            // InternalAceGen.g:3769:3: ( (lv_name_0_0= RULE_ID ) ) ( ( ruleQualifiedName ) ) ( (lv_expression_2_0= rulePersistenceVerificationExpression ) )
            {
            // InternalAceGen.g:3769:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:3770:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:3770:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:3771:5: lv_name_0_0= RULE_ID
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

            // InternalAceGen.g:3787:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:3788:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:3788:4: ( ruleQualifiedName )
            // InternalAceGen.g:3789:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPersistenceVerificationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPersistenceVerificationAccess().getModelModelCrossReference_1_0());
            				
            pushFollow(FOLLOW_96);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:3803:3: ( (lv_expression_2_0= rulePersistenceVerificationExpression ) )
            // InternalAceGen.g:3804:4: (lv_expression_2_0= rulePersistenceVerificationExpression )
            {
            // InternalAceGen.g:3804:4: (lv_expression_2_0= rulePersistenceVerificationExpression )
            // InternalAceGen.g:3805:5: lv_expression_2_0= rulePersistenceVerificationExpression
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
    // InternalAceGen.g:3826:1: entryRulePersistenceVerificationExpression returns [EObject current=null] : iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF ;
    public final EObject entryRulePersistenceVerificationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersistenceVerificationExpression = null;


        try {
            // InternalAceGen.g:3826:74: (iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF )
            // InternalAceGen.g:3827:2: iv_rulePersistenceVerificationExpression= rulePersistenceVerificationExpression EOF
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
    // InternalAceGen.g:3833:1: rulePersistenceVerificationExpression returns [EObject current=null] : (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount ) ;
    public final EObject rulePersistenceVerificationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_SelectByUniqueAttribute_0 = null;

        EObject this_SelectByPrimaryKeys_1 = null;

        EObject this_Count_2 = null;



        	enterRule();

        try {
            // InternalAceGen.g:3839:2: ( (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount ) )
            // InternalAceGen.g:3840:2: (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount )
            {
            // InternalAceGen.g:3840:2: (this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute | this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys | this_Count_2= ruleCount )
            int alt115=3;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt115=1;
                }
                break;
            case 73:
                {
                alt115=2;
                }
                break;
            case 75:
                {
                alt115=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }

            switch (alt115) {
                case 1 :
                    // InternalAceGen.g:3841:3: this_SelectByUniqueAttribute_0= ruleSelectByUniqueAttribute
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
                    // InternalAceGen.g:3850:3: this_SelectByPrimaryKeys_1= ruleSelectByPrimaryKeys
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
                    // InternalAceGen.g:3859:3: this_Count_2= ruleCount
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
    // InternalAceGen.g:3871:1: entryRuleSelectByPrimaryKeys returns [EObject current=null] : iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF ;
    public final EObject entryRuleSelectByPrimaryKeys() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByPrimaryKeys = null;


        try {
            // InternalAceGen.g:3871:60: (iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF )
            // InternalAceGen.g:3872:2: iv_ruleSelectByPrimaryKeys= ruleSelectByPrimaryKeys EOF
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
    // InternalAceGen.g:3878:1: ruleSelectByPrimaryKeys returns [EObject current=null] : (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) ) ;
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
            // InternalAceGen.g:3884:2: ( (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) ) )
            // InternalAceGen.g:3885:2: (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) )
            {
            // InternalAceGen.g:3885:2: (otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) ) )
            // InternalAceGen.g:3886:3: otherlv_0= 'selectByPrimaryKey' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= ruleSelectByExpectation ) )
            {
            otherlv_0=(Token)match(input,73,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getSelectByPrimaryKeysAccess().getSelectByPrimaryKeyKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectByPrimaryKeysAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:3894:3: ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:3895:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:3895:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:3896:5: lv_attributeAndValues_2_0= ruleAttributeAndValue
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

            // InternalAceGen.g:3913:3: (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==19) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // InternalAceGen.g:3914:4: otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_37); 

                    				newLeafNode(otherlv_3, grammarAccess.getSelectByPrimaryKeysAccess().getCommaKeyword_3_0());
                    			
                    // InternalAceGen.g:3918:4: ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    loop116:
                    do {
                        int alt116=2;
                        int LA116_0 = input.LA(1);

                        if ( (LA116_0==RULE_ID) ) {
                            alt116=1;
                        }


                        switch (alt116) {
                    	case 1 :
                    	    // InternalAceGen.g:3919:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    {
                    	    // InternalAceGen.g:3919:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    // InternalAceGen.g:3920:6: lv_attributeAndValues_4_0= ruleAttributeAndValue
                    	    {

                    	    						newCompositeNode(grammarAccess.getSelectByPrimaryKeysAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_37);
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
                    	    break loop116;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_49); 

            			newLeafNode(otherlv_5, grammarAccess.getSelectByPrimaryKeysAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,48,FOLLOW_97); 

            			newLeafNode(otherlv_6, grammarAccess.getSelectByPrimaryKeysAccess().getShouldBeKeyword_5());
            		
            // InternalAceGen.g:3946:3: ( (lv_expected_7_0= ruleSelectByExpectation ) )
            // InternalAceGen.g:3947:4: (lv_expected_7_0= ruleSelectByExpectation )
            {
            // InternalAceGen.g:3947:4: (lv_expected_7_0= ruleSelectByExpectation )
            // InternalAceGen.g:3948:5: lv_expected_7_0= ruleSelectByExpectation
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
    // InternalAceGen.g:3969:1: entryRuleSelectByUniqueAttribute returns [EObject current=null] : iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF ;
    public final EObject entryRuleSelectByUniqueAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByUniqueAttribute = null;


        try {
            // InternalAceGen.g:3969:64: (iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF )
            // InternalAceGen.g:3970:2: iv_ruleSelectByUniqueAttribute= ruleSelectByUniqueAttribute EOF
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
    // InternalAceGen.g:3976:1: ruleSelectByUniqueAttribute returns [EObject current=null] : (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) ) ;
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
            // InternalAceGen.g:3982:2: ( (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) ) )
            // InternalAceGen.g:3983:2: (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) )
            {
            // InternalAceGen.g:3983:2: (otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) ) )
            // InternalAceGen.g:3984:3: otherlv_0= 'selectBy' otherlv_1= '(' ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) ) otherlv_3= ')' otherlv_4= 'shouldBe' ( (lv_expected_5_0= ruleSelectByExpectation ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getSelectByUniqueAttributeAccess().getSelectByKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getSelectByUniqueAttributeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:3992:3: ( (lv_attributeAndValue_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:3993:4: (lv_attributeAndValue_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:3993:4: (lv_attributeAndValue_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:3994:5: lv_attributeAndValue_2_0= ruleAttributeAndValue
            {

            					newCompositeNode(grammarAccess.getSelectByUniqueAttributeAccess().getAttributeAndValueAttributeAndValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_81);
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

            otherlv_3=(Token)match(input,20,FOLLOW_49); 

            			newLeafNode(otherlv_3, grammarAccess.getSelectByUniqueAttributeAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,48,FOLLOW_97); 

            			newLeafNode(otherlv_4, grammarAccess.getSelectByUniqueAttributeAccess().getShouldBeKeyword_4());
            		
            // InternalAceGen.g:4019:3: ( (lv_expected_5_0= ruleSelectByExpectation ) )
            // InternalAceGen.g:4020:4: (lv_expected_5_0= ruleSelectByExpectation )
            {
            // InternalAceGen.g:4020:4: (lv_expected_5_0= ruleSelectByExpectation )
            // InternalAceGen.g:4021:5: lv_expected_5_0= ruleSelectByExpectation
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
    // InternalAceGen.g:4042:1: entryRuleCount returns [EObject current=null] : iv_ruleCount= ruleCount EOF ;
    public final EObject entryRuleCount() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCount = null;


        try {
            // InternalAceGen.g:4042:46: (iv_ruleCount= ruleCount EOF )
            // InternalAceGen.g:4043:2: iv_ruleCount= ruleCount EOF
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
    // InternalAceGen.g:4049:1: ruleCount returns [EObject current=null] : (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) ) ;
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
            // InternalAceGen.g:4055:2: ( (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) ) )
            // InternalAceGen.g:4056:2: (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) )
            {
            // InternalAceGen.g:4056:2: (otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) ) )
            // InternalAceGen.g:4057:3: otherlv_0= 'filterAndCountBy' otherlv_1= '(' ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) ) (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )? otherlv_5= ')' otherlv_6= 'shouldBe' ( (lv_expected_7_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,75,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getCountAccess().getFilterAndCountByKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getCountAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:4065:3: ( (lv_attributeAndValues_2_0= ruleAttributeAndValue ) )
            // InternalAceGen.g:4066:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            {
            // InternalAceGen.g:4066:4: (lv_attributeAndValues_2_0= ruleAttributeAndValue )
            // InternalAceGen.g:4067:5: lv_attributeAndValues_2_0= ruleAttributeAndValue
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

            // InternalAceGen.g:4084:3: (otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )* )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==19) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalAceGen.g:4085:4: otherlv_3= ',' ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_37); 

                    				newLeafNode(otherlv_3, grammarAccess.getCountAccess().getCommaKeyword_3_0());
                    			
                    // InternalAceGen.g:4089:4: ( (lv_attributeAndValues_4_0= ruleAttributeAndValue ) )*
                    loop118:
                    do {
                        int alt118=2;
                        int LA118_0 = input.LA(1);

                        if ( (LA118_0==RULE_ID) ) {
                            alt118=1;
                        }


                        switch (alt118) {
                    	case 1 :
                    	    // InternalAceGen.g:4090:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    {
                    	    // InternalAceGen.g:4090:5: (lv_attributeAndValues_4_0= ruleAttributeAndValue )
                    	    // InternalAceGen.g:4091:6: lv_attributeAndValues_4_0= ruleAttributeAndValue
                    	    {

                    	    						newCompositeNode(grammarAccess.getCountAccess().getAttributeAndValuesAttributeAndValueParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_37);
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
                    	    break loop118;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FOLLOW_49); 

            			newLeafNode(otherlv_5, grammarAccess.getCountAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,48,FOLLOW_22); 

            			newLeafNode(otherlv_6, grammarAccess.getCountAccess().getShouldBeKeyword_5());
            		
            // InternalAceGen.g:4117:3: ( (lv_expected_7_0= RULE_INT ) )
            // InternalAceGen.g:4118:4: (lv_expected_7_0= RULE_INT )
            {
            // InternalAceGen.g:4118:4: (lv_expected_7_0= RULE_INT )
            // InternalAceGen.g:4119:5: lv_expected_7_0= RULE_INT
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
    // InternalAceGen.g:4139:1: entryRuleAttributeAndValue returns [EObject current=null] : iv_ruleAttributeAndValue= ruleAttributeAndValue EOF ;
    public final EObject entryRuleAttributeAndValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeAndValue = null;


        try {
            // InternalAceGen.g:4139:58: (iv_ruleAttributeAndValue= ruleAttributeAndValue EOF )
            // InternalAceGen.g:4140:2: iv_ruleAttributeAndValue= ruleAttributeAndValue EOF
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
    // InternalAceGen.g:4146:1: ruleAttributeAndValue returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) ;
    public final EObject ruleAttributeAndValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4152:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) ) )
            // InternalAceGen.g:4153:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            {
            // InternalAceGen.g:4153:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) ) )
            // InternalAceGen.g:4154:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= rulePrimitiveValue ) )
            {
            // InternalAceGen.g:4154:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:4155:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:4155:4: ( ruleQualifiedName )
            // InternalAceGen.g:4156:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeAndValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAttributeAndValueAccess().getAttributeAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_45);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,45,FOLLOW_46); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeAndValueAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:4174:3: ( (lv_value_2_0= rulePrimitiveValue ) )
            // InternalAceGen.g:4175:4: (lv_value_2_0= rulePrimitiveValue )
            {
            // InternalAceGen.g:4175:4: (lv_value_2_0= rulePrimitiveValue )
            // InternalAceGen.g:4176:5: lv_value_2_0= rulePrimitiveValue
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
    // InternalAceGen.g:4197:1: entryRuleVerification returns [EObject current=null] : iv_ruleVerification= ruleVerification EOF ;
    public final EObject entryRuleVerification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerification = null;


        try {
            // InternalAceGen.g:4197:53: (iv_ruleVerification= ruleVerification EOF )
            // InternalAceGen.g:4198:2: iv_ruleVerification= ruleVerification EOF
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
    // InternalAceGen.g:4204:1: ruleVerification returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleVerification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4210:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalAceGen.g:4211:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalAceGen.g:4211:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:4212:3: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:4212:3: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:4213:4: lv_name_0_0= RULE_ID
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
    // InternalAceGen.g:4232:1: entryRuleExtraction returns [EObject current=null] : iv_ruleExtraction= ruleExtraction EOF ;
    public final EObject entryRuleExtraction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtraction = null;


        try {
            // InternalAceGen.g:4232:51: (iv_ruleExtraction= ruleExtraction EOF )
            // InternalAceGen.g:4233:2: iv_ruleExtraction= ruleExtraction EOF
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
    // InternalAceGen.g:4239:1: ruleExtraction returns [EObject current=null] : (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleExtraction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4245:2: ( (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalAceGen.g:4246:2: (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalAceGen.g:4246:2: (otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalAceGen.g:4247:3: otherlv_0= 'extract' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,76,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getExtractionAccess().getExtractKeyword_0());
            		
            // InternalAceGen.g:4251:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:4252:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:4252:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:4253:5: lv_name_1_0= RULE_ID
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
    // InternalAceGen.g:4273:1: entryRuleSelectByExpectation returns [EObject current=null] : iv_ruleSelectByExpectation= ruleSelectByExpectation EOF ;
    public final EObject entryRuleSelectByExpectation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectByExpectation = null;


        try {
            // InternalAceGen.g:4273:60: (iv_ruleSelectByExpectation= ruleSelectByExpectation EOF )
            // InternalAceGen.g:4274:2: iv_ruleSelectByExpectation= ruleSelectByExpectation EOF
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
    // InternalAceGen.g:4280:1: ruleSelectByExpectation returns [EObject current=null] : ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) ) ;
    public final EObject ruleSelectByExpectation() throws RecognitionException {
        EObject current = null;

        Token lv_isNotNull_1_0=null;
        Token lv_isNull_2_0=null;
        EObject lv_object_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4286:2: ( ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) ) )
            // InternalAceGen.g:4287:2: ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) )
            {
            // InternalAceGen.g:4287:2: ( ( (lv_object_0_0= ruleJsonObject ) ) | ( (lv_isNotNull_1_0= 'notNull' ) ) | ( (lv_isNull_2_0= 'null' ) ) )
            int alt120=3;
            switch ( input.LA(1) ) {
            case 35:
            case 95:
                {
                alt120=1;
                }
                break;
            case 77:
                {
                alt120=2;
                }
                break;
            case 78:
                {
                alt120=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;
            }

            switch (alt120) {
                case 1 :
                    // InternalAceGen.g:4288:3: ( (lv_object_0_0= ruleJsonObject ) )
                    {
                    // InternalAceGen.g:4288:3: ( (lv_object_0_0= ruleJsonObject ) )
                    // InternalAceGen.g:4289:4: (lv_object_0_0= ruleJsonObject )
                    {
                    // InternalAceGen.g:4289:4: (lv_object_0_0= ruleJsonObject )
                    // InternalAceGen.g:4290:5: lv_object_0_0= ruleJsonObject
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
                    // InternalAceGen.g:4308:3: ( (lv_isNotNull_1_0= 'notNull' ) )
                    {
                    // InternalAceGen.g:4308:3: ( (lv_isNotNull_1_0= 'notNull' ) )
                    // InternalAceGen.g:4309:4: (lv_isNotNull_1_0= 'notNull' )
                    {
                    // InternalAceGen.g:4309:4: (lv_isNotNull_1_0= 'notNull' )
                    // InternalAceGen.g:4310:5: lv_isNotNull_1_0= 'notNull'
                    {
                    lv_isNotNull_1_0=(Token)match(input,77,FOLLOW_2); 

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
                    // InternalAceGen.g:4323:3: ( (lv_isNull_2_0= 'null' ) )
                    {
                    // InternalAceGen.g:4323:3: ( (lv_isNull_2_0= 'null' ) )
                    // InternalAceGen.g:4324:4: (lv_isNull_2_0= 'null' )
                    {
                    // InternalAceGen.g:4324:4: (lv_isNull_2_0= 'null' )
                    // InternalAceGen.g:4325:5: lv_isNull_2_0= 'null'
                    {
                    lv_isNull_2_0=(Token)match(input,78,FOLLOW_2); 

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
    // InternalAceGen.g:4341:1: entryRuleDataDefinition returns [EObject current=null] : iv_ruleDataDefinition= ruleDataDefinition EOF ;
    public final EObject entryRuleDataDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataDefinition = null;


        try {
            // InternalAceGen.g:4341:55: (iv_ruleDataDefinition= ruleDataDefinition EOF )
            // InternalAceGen.g:4342:2: iv_ruleDataDefinition= ruleDataDefinition EOF
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
    // InternalAceGen.g:4348:1: ruleDataDefinition returns [EObject current=null] : ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? ) ;
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
            // InternalAceGen.g:4354:2: ( ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? ) )
            // InternalAceGen.g:4355:2: ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? )
            {
            // InternalAceGen.g:4355:2: ( () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )? )
            // InternalAceGen.g:4356:3: () (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )? (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )? ( (lv_data_6_0= ruleJsonObject ) )?
            {
            // InternalAceGen.g:4356:3: ()
            // InternalAceGen.g:4357:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDataDefinitionAccess().getDataDefinitionAction_0(),
            					current);
            			

            }

            // InternalAceGen.g:4363:3: (otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==41) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // InternalAceGen.g:4364:4: otherlv_1= 'uuid' ( (lv_uuid_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,41,FOLLOW_41); 

                    				newLeafNode(otherlv_1, grammarAccess.getDataDefinitionAccess().getUuidKeyword_1_0());
                    			
                    // InternalAceGen.g:4368:4: ( (lv_uuid_2_0= RULE_STRING ) )
                    // InternalAceGen.g:4369:5: (lv_uuid_2_0= RULE_STRING )
                    {
                    // InternalAceGen.g:4369:5: (lv_uuid_2_0= RULE_STRING )
                    // InternalAceGen.g:4370:6: lv_uuid_2_0= RULE_STRING
                    {
                    lv_uuid_2_0=(Token)match(input,RULE_STRING,FOLLOW_98); 

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

            // InternalAceGen.g:4387:3: (otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==79) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // InternalAceGen.g:4388:4: otherlv_3= 'systemTime' ( (lv_systemtime_4_0= RULE_STRING ) ) ( (lv_pattern_5_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,79,FOLLOW_41); 

                    				newLeafNode(otherlv_3, grammarAccess.getDataDefinitionAccess().getSystemTimeKeyword_2_0());
                    			
                    // InternalAceGen.g:4392:4: ( (lv_systemtime_4_0= RULE_STRING ) )
                    // InternalAceGen.g:4393:5: (lv_systemtime_4_0= RULE_STRING )
                    {
                    // InternalAceGen.g:4393:5: (lv_systemtime_4_0= RULE_STRING )
                    // InternalAceGen.g:4394:6: lv_systemtime_4_0= RULE_STRING
                    {
                    lv_systemtime_4_0=(Token)match(input,RULE_STRING,FOLLOW_41); 

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

                    // InternalAceGen.g:4410:4: ( (lv_pattern_5_0= RULE_STRING ) )
                    // InternalAceGen.g:4411:5: (lv_pattern_5_0= RULE_STRING )
                    {
                    // InternalAceGen.g:4411:5: (lv_pattern_5_0= RULE_STRING )
                    // InternalAceGen.g:4412:6: lv_pattern_5_0= RULE_STRING
                    {
                    lv_pattern_5_0=(Token)match(input,RULE_STRING,FOLLOW_99); 

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

            // InternalAceGen.g:4429:3: ( (lv_data_6_0= ruleJsonObject ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==35||LA123_0==95) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // InternalAceGen.g:4430:4: (lv_data_6_0= ruleJsonObject )
                    {
                    // InternalAceGen.g:4430:4: (lv_data_6_0= ruleJsonObject )
                    // InternalAceGen.g:4431:5: lv_data_6_0= ruleJsonObject
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
    // InternalAceGen.g:4452:1: entryRuleAuthorization returns [EObject current=null] : iv_ruleAuthorization= ruleAuthorization EOF ;
    public final EObject entryRuleAuthorization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthorization = null;


        try {
            // InternalAceGen.g:4452:54: (iv_ruleAuthorization= ruleAuthorization EOF )
            // InternalAceGen.g:4453:2: iv_ruleAuthorization= ruleAuthorization EOF
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
    // InternalAceGen.g:4459:1: ruleAuthorization returns [EObject current=null] : (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleAuthorization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_username_1_0=null;
        Token otherlv_2=null;
        Token lv_password_3_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:4465:2: ( (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) ) )
            // InternalAceGen.g:4466:2: (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) )
            {
            // InternalAceGen.g:4466:2: (otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) ) )
            // InternalAceGen.g:4467:3: otherlv_0= 'authorization' ( (lv_username_1_0= RULE_STRING ) ) otherlv_2= ':' ( (lv_password_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,80,FOLLOW_41); 

            			newLeafNode(otherlv_0, grammarAccess.getAuthorizationAccess().getAuthorizationKeyword_0());
            		
            // InternalAceGen.g:4471:3: ( (lv_username_1_0= RULE_STRING ) )
            // InternalAceGen.g:4472:4: (lv_username_1_0= RULE_STRING )
            {
            // InternalAceGen.g:4472:4: (lv_username_1_0= RULE_STRING )
            // InternalAceGen.g:4473:5: lv_username_1_0= RULE_STRING
            {
            lv_username_1_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

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

            otherlv_2=(Token)match(input,45,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getAuthorizationAccess().getColonKeyword_2());
            		
            // InternalAceGen.g:4493:3: ( (lv_password_3_0= RULE_STRING ) )
            // InternalAceGen.g:4494:4: (lv_password_3_0= RULE_STRING )
            {
            // InternalAceGen.g:4494:4: (lv_password_3_0= RULE_STRING )
            // InternalAceGen.g:4495:5: lv_password_3_0= RULE_STRING
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
    // InternalAceGen.g:4515:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalAceGen.g:4515:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalAceGen.g:4516:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalAceGen.g:4522:1: ruleAttribute returns [EObject current=null] : ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_nonDeterministic_9_0= 'nonDeterministic' ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_unique_0_0=null;
        Token lv_primaryKey_1_0=null;
        Token lv_notNull_2_0=null;
        Token lv_list_3_0=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token lv_nonDeterministic_9_0=null;
        AntlrDatatypeRuleToken lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4528:2: ( ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_nonDeterministic_9_0= 'nonDeterministic' ) )? ) )
            // InternalAceGen.g:4529:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_nonDeterministic_9_0= 'nonDeterministic' ) )? )
            {
            // InternalAceGen.g:4529:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_nonDeterministic_9_0= 'nonDeterministic' ) )? )
            // InternalAceGen.g:4530:3: ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_notNull_2_0= 'NotNull' ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ( (lv_nonDeterministic_9_0= 'nonDeterministic' ) )?
            {
            // InternalAceGen.g:4530:3: ( (lv_unique_0_0= 'Unique' ) )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==81) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // InternalAceGen.g:4531:4: (lv_unique_0_0= 'Unique' )
                    {
                    // InternalAceGen.g:4531:4: (lv_unique_0_0= 'Unique' )
                    // InternalAceGen.g:4532:5: lv_unique_0_0= 'Unique'
                    {
                    lv_unique_0_0=(Token)match(input,81,FOLLOW_100); 

                    					newLeafNode(lv_unique_0_0, grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "unique", lv_unique_0_0 != null, "Unique");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4544:3: ( (lv_primaryKey_1_0= 'PrimaryKey' ) )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==82) ) {
                alt125=1;
            }
            switch (alt125) {
                case 1 :
                    // InternalAceGen.g:4545:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    {
                    // InternalAceGen.g:4545:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    // InternalAceGen.g:4546:5: lv_primaryKey_1_0= 'PrimaryKey'
                    {
                    lv_primaryKey_1_0=(Token)match(input,82,FOLLOW_101); 

                    					newLeafNode(lv_primaryKey_1_0, grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "primaryKey", lv_primaryKey_1_0 != null, "PrimaryKey");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4558:3: ( (lv_notNull_2_0= 'NotNull' ) )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==66) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalAceGen.g:4559:4: (lv_notNull_2_0= 'NotNull' )
                    {
                    // InternalAceGen.g:4559:4: (lv_notNull_2_0= 'NotNull' )
                    // InternalAceGen.g:4560:5: lv_notNull_2_0= 'NotNull'
                    {
                    lv_notNull_2_0=(Token)match(input,66,FOLLOW_102); 

                    					newLeafNode(lv_notNull_2_0, grammarAccess.getAttributeAccess().getNotNullNotNullKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "notNull", lv_notNull_2_0 != null, "NotNull");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4572:3: ( (lv_list_3_0= 'List' ) )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==32) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // InternalAceGen.g:4573:4: (lv_list_3_0= 'List' )
                    {
                    // InternalAceGen.g:4573:4: (lv_list_3_0= 'List' )
                    // InternalAceGen.g:4574:5: lv_list_3_0= 'List'
                    {
                    lv_list_3_0=(Token)match(input,32,FOLLOW_103); 

                    					newLeafNode(lv_list_3_0, grammarAccess.getAttributeAccess().getListListKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "list", lv_list_3_0 != null, "List");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:4586:3: ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) )
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( ((LA128_0>=89 && LA128_0<=94)) ) {
                alt128=1;
            }
            else if ( (LA128_0==RULE_ID) ) {
                alt128=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }
            switch (alt128) {
                case 1 :
                    // InternalAceGen.g:4587:4: ( (lv_type_4_0= ruleType ) )
                    {
                    // InternalAceGen.g:4587:4: ( (lv_type_4_0= ruleType ) )
                    // InternalAceGen.g:4588:5: (lv_type_4_0= ruleType )
                    {
                    // InternalAceGen.g:4588:5: (lv_type_4_0= ruleType )
                    // InternalAceGen.g:4589:6: lv_type_4_0= ruleType
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
                    // InternalAceGen.g:4607:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalAceGen.g:4607:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:4608:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:4608:5: ( ruleQualifiedName )
                    // InternalAceGen.g:4609:6: ruleQualifiedName
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

            // InternalAceGen.g:4624:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalAceGen.g:4625:4: (lv_name_6_0= RULE_ID )
            {
            // InternalAceGen.g:4625:4: (lv_name_6_0= RULE_ID )
            // InternalAceGen.g:4626:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_104); 

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

            // InternalAceGen.g:4642:3: (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==83) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // InternalAceGen.g:4643:4: otherlv_7= 'references' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,83,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getReferencesKeyword_6_0());
                    			
                    // InternalAceGen.g:4647:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:4648:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:4648:5: ( ruleQualifiedName )
                    // InternalAceGen.g:4649:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_105);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:4664:3: ( (lv_nonDeterministic_9_0= 'nonDeterministic' ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==44) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // InternalAceGen.g:4665:4: (lv_nonDeterministic_9_0= 'nonDeterministic' )
                    {
                    // InternalAceGen.g:4665:4: (lv_nonDeterministic_9_0= 'nonDeterministic' )
                    // InternalAceGen.g:4666:5: lv_nonDeterministic_9_0= 'nonDeterministic'
                    {
                    lv_nonDeterministic_9_0=(Token)match(input,44,FOLLOW_2); 

                    					newLeafNode(lv_nonDeterministic_9_0, grammarAccess.getAttributeAccess().getNonDeterministicNonDeterministicKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "nonDeterministic", lv_nonDeterministic_9_0 != null, "nonDeterministic");
                    				

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
    // InternalAceGen.g:4682:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalAceGen.g:4682:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalAceGen.g:4683:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalAceGen.g:4689:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalAceGen.g:4695:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalAceGen.g:4696:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalAceGen.g:4696:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalAceGen.g:4697:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_106); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalAceGen.g:4704:3: (kw= '.' this_ID_2= RULE_ID )*
            loop131:
            do {
                int alt131=2;
                int LA131_0 = input.LA(1);

                if ( (LA131_0==84) ) {
                    alt131=1;
                }


                switch (alt131) {
            	case 1 :
            	    // InternalAceGen.g:4705:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,84,FOLLOW_9); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_106); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop131;
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
    // InternalAceGen.g:4722:1: entryRuleWriteFunctionType returns [String current=null] : iv_ruleWriteFunctionType= ruleWriteFunctionType EOF ;
    public final String entryRuleWriteFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWriteFunctionType = null;


        try {
            // InternalAceGen.g:4722:57: (iv_ruleWriteFunctionType= ruleWriteFunctionType EOF )
            // InternalAceGen.g:4723:2: iv_ruleWriteFunctionType= ruleWriteFunctionType EOF
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
    // InternalAceGen.g:4729:1: ruleWriteFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) ;
    public final AntlrDatatypeRuleToken ruleWriteFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:4735:2: ( (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) )
            // InternalAceGen.g:4736:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            {
            // InternalAceGen.g:4736:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            int alt132=3;
            switch ( input.LA(1) ) {
            case 85:
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
                    // InternalAceGen.g:4737:3: kw= 'POST'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:4743:3: kw= 'PUT'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:4749:3: kw= 'DELETE'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); 

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
    // InternalAceGen.g:4758:1: entryRuleReadFunctionType returns [String current=null] : iv_ruleReadFunctionType= ruleReadFunctionType EOF ;
    public final String entryRuleReadFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReadFunctionType = null;


        try {
            // InternalAceGen.g:4758:56: (iv_ruleReadFunctionType= ruleReadFunctionType EOF )
            // InternalAceGen.g:4759:2: iv_ruleReadFunctionType= ruleReadFunctionType EOF
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
    // InternalAceGen.g:4765:1: ruleReadFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'GET' ;
    public final AntlrDatatypeRuleToken ruleReadFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:4771:2: (kw= 'GET' )
            // InternalAceGen.g:4772:2: kw= 'GET'
            {
            kw=(Token)match(input,88,FOLLOW_2); 

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
    // InternalAceGen.g:4780:1: entryRuleType returns [String current=null] : iv_ruleType= ruleType EOF ;
    public final String entryRuleType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType = null;


        try {
            // InternalAceGen.g:4780:44: (iv_ruleType= ruleType EOF )
            // InternalAceGen.g:4781:2: iv_ruleType= ruleType EOF
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
    // InternalAceGen.g:4787:1: ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' ) ;
    public final AntlrDatatypeRuleToken ruleType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:4793:2: ( (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' ) )
            // InternalAceGen.g:4794:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' )
            {
            // InternalAceGen.g:4794:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' )
            int alt133=6;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt133=1;
                }
                break;
            case 90:
                {
                alt133=2;
                }
                break;
            case 91:
                {
                alt133=3;
                }
                break;
            case 92:
                {
                alt133=4;
                }
                break;
            case 93:
                {
                alt133=5;
                }
                break;
            case 94:
                {
                alt133=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }

            switch (alt133) {
                case 1 :
                    // InternalAceGen.g:4795:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getIntegerKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:4801:3: kw= 'String'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getStringKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:4807:3: kw= 'Float'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getFloatKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAceGen.g:4813:3: kw= 'Boolean'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getBooleanKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalAceGen.g:4819:3: kw= 'DateTime'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getDateTimeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalAceGen.g:4825:3: kw= 'Long'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

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


    // $ANTLR start "entryRuleJsonObject"
    // InternalAceGen.g:4834:1: entryRuleJsonObject returns [EObject current=null] : iv_ruleJsonObject= ruleJsonObject EOF ;
    public final EObject entryRuleJsonObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObject = null;


        try {
            // InternalAceGen.g:4834:51: (iv_ruleJsonObject= ruleJsonObject EOF )
            // InternalAceGen.g:4835:2: iv_ruleJsonObject= ruleJsonObject EOF
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
    // InternalAceGen.g:4841:1: ruleJsonObject returns [EObject current=null] : (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) ) ;
    public final EObject ruleJsonObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_JsonObjectAce_0 = null;

        EObject this_StringType_2 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4847:2: ( (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) ) )
            // InternalAceGen.g:4848:2: (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) )
            {
            // InternalAceGen.g:4848:2: (this_JsonObjectAce_0= ruleJsonObjectAce | (otherlv_1= 'json' this_StringType_2= ruleStringType ) )
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==35) ) {
                alt134=1;
            }
            else if ( (LA134_0==95) ) {
                alt134=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }
            switch (alt134) {
                case 1 :
                    // InternalAceGen.g:4849:3: this_JsonObjectAce_0= ruleJsonObjectAce
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
                    // InternalAceGen.g:4858:3: (otherlv_1= 'json' this_StringType_2= ruleStringType )
                    {
                    // InternalAceGen.g:4858:3: (otherlv_1= 'json' this_StringType_2= ruleStringType )
                    // InternalAceGen.g:4859:4: otherlv_1= 'json' this_StringType_2= ruleStringType
                    {
                    otherlv_1=(Token)match(input,95,FOLLOW_41); 

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
    // InternalAceGen.g:4876:1: entryRuleJsonObjectAce returns [EObject current=null] : iv_ruleJsonObjectAce= ruleJsonObjectAce EOF ;
    public final EObject entryRuleJsonObjectAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonObjectAce = null;


        try {
            // InternalAceGen.g:4876:54: (iv_ruleJsonObjectAce= ruleJsonObjectAce EOF )
            // InternalAceGen.g:4877:2: iv_ruleJsonObjectAce= ruleJsonObjectAce EOF
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
    // InternalAceGen.g:4883:1: ruleJsonObjectAce returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleJsonObjectAce() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_members_2_0 = null;

        EObject lv_members_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4889:2: ( ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' ) )
            // InternalAceGen.g:4890:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' )
            {
            // InternalAceGen.g:4890:2: ( () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}' )
            // InternalAceGen.g:4891:3: () otherlv_1= '{' ( (lv_members_2_0= ruleJsonMember ) )? (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )* otherlv_5= '}'
            {
            // InternalAceGen.g:4891:3: ()
            // InternalAceGen.g:4892:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonObjectAceAccess().getJsonObjectAceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonObjectAceAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalAceGen.g:4902:3: ( (lv_members_2_0= ruleJsonMember ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==RULE_ID) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // InternalAceGen.g:4903:4: (lv_members_2_0= ruleJsonMember )
                    {
                    // InternalAceGen.g:4903:4: (lv_members_2_0= ruleJsonMember )
                    // InternalAceGen.g:4904:5: lv_members_2_0= ruleJsonMember
                    {

                    					newCompositeNode(grammarAccess.getJsonObjectAceAccess().getMembersJsonMemberParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_52);
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

            // InternalAceGen.g:4921:3: (otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) ) )*
            loop136:
            do {
                int alt136=2;
                int LA136_0 = input.LA(1);

                if ( (LA136_0==19) ) {
                    alt136=1;
                }


                switch (alt136) {
            	case 1 :
            	    // InternalAceGen.g:4922:4: otherlv_3= ',' ( (lv_members_4_0= ruleJsonMember ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_9); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonObjectAceAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:4926:4: ( (lv_members_4_0= ruleJsonMember ) )
            	    // InternalAceGen.g:4927:5: (lv_members_4_0= ruleJsonMember )
            	    {
            	    // InternalAceGen.g:4927:5: (lv_members_4_0= ruleJsonMember )
            	    // InternalAceGen.g:4928:6: lv_members_4_0= ruleJsonMember
            	    {

            	    						newCompositeNode(grammarAccess.getJsonObjectAceAccess().getMembersJsonMemberParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_52);
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
            	    break loop136;
                }
            } while (true);

            otherlv_5=(Token)match(input,36,FOLLOW_2); 

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
    // InternalAceGen.g:4954:1: entryRuleJsonMember returns [EObject current=null] : iv_ruleJsonMember= ruleJsonMember EOF ;
    public final EObject entryRuleJsonMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonMember = null;


        try {
            // InternalAceGen.g:4954:51: (iv_ruleJsonMember= ruleJsonMember EOF )
            // InternalAceGen.g:4955:2: iv_ruleJsonMember= ruleJsonMember EOF
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
    // InternalAceGen.g:4961:1: ruleJsonMember returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) ) ;
    public final EObject ruleJsonMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:4967:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) ) )
            // InternalAceGen.g:4968:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) )
            {
            // InternalAceGen.g:4968:2: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) ) )
            // InternalAceGen.g:4969:3: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleJsonValue ) )
            {
            // InternalAceGen.g:4969:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:4970:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:4970:4: ( ruleQualifiedName )
            // InternalAceGen.g:4971:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJsonMemberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJsonMemberAccess().getAttributeAttributeCrossReference_0_0());
            				
            pushFollow(FOLLOW_45);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,45,FOLLOW_107); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonMemberAccess().getColonKeyword_1());
            		
            // InternalAceGen.g:4989:3: ( (lv_value_2_0= ruleJsonValue ) )
            // InternalAceGen.g:4990:4: (lv_value_2_0= ruleJsonValue )
            {
            // InternalAceGen.g:4990:4: (lv_value_2_0= ruleJsonValue )
            // InternalAceGen.g:4991:5: lv_value_2_0= ruleJsonValue
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
    // InternalAceGen.g:5012:1: entryRuleJsonValue returns [EObject current=null] : iv_ruleJsonValue= ruleJsonValue EOF ;
    public final EObject entryRuleJsonValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonValue = null;


        try {
            // InternalAceGen.g:5012:50: (iv_ruleJsonValue= ruleJsonValue EOF )
            // InternalAceGen.g:5013:2: iv_ruleJsonValue= ruleJsonValue EOF
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
    // InternalAceGen.g:5019:1: ruleJsonValue returns [EObject current=null] : (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime ) ;
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
            // InternalAceGen.g:5025:2: ( (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime ) )
            // InternalAceGen.g:5026:2: (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime )
            {
            // InternalAceGen.g:5026:2: (this_JsonObject_0= ruleJsonObject | this_StringType_1= ruleStringType | this_JsonArray_2= ruleJsonArray | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime )
            int alt137=7;
            switch ( input.LA(1) ) {
            case 35:
            case 95:
                {
                alt137=1;
                }
                break;
            case RULE_STRING:
                {
                int LA137_2 = input.LA(2);

                if ( (LA137_2==EOF||LA137_2==19||LA137_2==36||LA137_2==50) ) {
                    alt137=2;
                }
                else if ( (LA137_2==RULE_STRING) ) {
                    alt137=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 137, 2, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                alt137=3;
                }
                break;
            case 97:
            case 98:
                {
                alt137=4;
                }
                break;
            case 78:
                {
                alt137=5;
                }
                break;
            case RULE_INT:
                {
                alt137=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }

            switch (alt137) {
                case 1 :
                    // InternalAceGen.g:5027:3: this_JsonObject_0= ruleJsonObject
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
                    // InternalAceGen.g:5036:3: this_StringType_1= ruleStringType
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
                    // InternalAceGen.g:5045:3: this_JsonArray_2= ruleJsonArray
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
                    // InternalAceGen.g:5054:3: this_BooleanType_3= ruleBooleanType
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
                    // InternalAceGen.g:5063:3: this_NullType_4= ruleNullType
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
                    // InternalAceGen.g:5072:3: this_LongType_5= ruleLongType
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
                    // InternalAceGen.g:5081:3: this_JsonDateTime_6= ruleJsonDateTime
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
    // InternalAceGen.g:5093:1: entryRuleJsonArray returns [EObject current=null] : iv_ruleJsonArray= ruleJsonArray EOF ;
    public final EObject entryRuleJsonArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonArray = null;


        try {
            // InternalAceGen.g:5093:50: (iv_ruleJsonArray= ruleJsonArray EOF )
            // InternalAceGen.g:5094:2: iv_ruleJsonArray= ruleJsonArray EOF
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
    // InternalAceGen.g:5100:1: ruleJsonArray returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleJsonArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5106:2: ( ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' ) )
            // InternalAceGen.g:5107:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' )
            {
            // InternalAceGen.g:5107:2: ( () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']' )
            // InternalAceGen.g:5108:3: () otherlv_1= '[' ( (lv_values_2_0= ruleJsonValue ) )? (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )* otherlv_5= ']'
            {
            // InternalAceGen.g:5108:3: ()
            // InternalAceGen.g:5109:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getJsonArrayAccess().getJsonArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,49,FOLLOW_108); 

            			newLeafNode(otherlv_1, grammarAccess.getJsonArrayAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalAceGen.g:5119:3: ( (lv_values_2_0= ruleJsonValue ) )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( ((LA138_0>=RULE_INT && LA138_0<=RULE_STRING)||LA138_0==35||LA138_0==49||LA138_0==78||LA138_0==95||(LA138_0>=97 && LA138_0<=98)) ) {
                alt138=1;
            }
            switch (alt138) {
                case 1 :
                    // InternalAceGen.g:5120:4: (lv_values_2_0= ruleJsonValue )
                    {
                    // InternalAceGen.g:5120:4: (lv_values_2_0= ruleJsonValue )
                    // InternalAceGen.g:5121:5: lv_values_2_0= ruleJsonValue
                    {

                    					newCompositeNode(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_54);
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

            // InternalAceGen.g:5138:3: (otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) ) )*
            loop139:
            do {
                int alt139=2;
                int LA139_0 = input.LA(1);

                if ( (LA139_0==19) ) {
                    alt139=1;
                }


                switch (alt139) {
            	case 1 :
            	    // InternalAceGen.g:5139:4: otherlv_3= ',' ( (lv_values_4_0= ruleJsonValue ) )
            	    {
            	    otherlv_3=(Token)match(input,19,FOLLOW_107); 

            	    				newLeafNode(otherlv_3, grammarAccess.getJsonArrayAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalAceGen.g:5143:4: ( (lv_values_4_0= ruleJsonValue ) )
            	    // InternalAceGen.g:5144:5: (lv_values_4_0= ruleJsonValue )
            	    {
            	    // InternalAceGen.g:5144:5: (lv_values_4_0= ruleJsonValue )
            	    // InternalAceGen.g:5145:6: lv_values_4_0= ruleJsonValue
            	    {

            	    						newCompositeNode(grammarAccess.getJsonArrayAccess().getValuesJsonValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_54);
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
            	    break loop139;
                }
            } while (true);

            otherlv_5=(Token)match(input,50,FOLLOW_2); 

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
    // InternalAceGen.g:5171:1: entryRuleJsonDateTime returns [EObject current=null] : iv_ruleJsonDateTime= ruleJsonDateTime EOF ;
    public final EObject entryRuleJsonDateTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJsonDateTime = null;


        try {
            // InternalAceGen.g:5171:53: (iv_ruleJsonDateTime= ruleJsonDateTime EOF )
            // InternalAceGen.g:5172:2: iv_ruleJsonDateTime= ruleJsonDateTime EOF
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
    // InternalAceGen.g:5178:1: ruleJsonDateTime returns [EObject current=null] : ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleJsonDateTime() throws RecognitionException {
        EObject current = null;

        Token lv_dateTime_0_0=null;
        Token lv_pattern_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5184:2: ( ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) ) )
            // InternalAceGen.g:5185:2: ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) )
            {
            // InternalAceGen.g:5185:2: ( ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) ) )
            // InternalAceGen.g:5186:3: ( (lv_dateTime_0_0= RULE_STRING ) ) ( (lv_pattern_1_0= RULE_STRING ) )
            {
            // InternalAceGen.g:5186:3: ( (lv_dateTime_0_0= RULE_STRING ) )
            // InternalAceGen.g:5187:4: (lv_dateTime_0_0= RULE_STRING )
            {
            // InternalAceGen.g:5187:4: (lv_dateTime_0_0= RULE_STRING )
            // InternalAceGen.g:5188:5: lv_dateTime_0_0= RULE_STRING
            {
            lv_dateTime_0_0=(Token)match(input,RULE_STRING,FOLLOW_41); 

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

            // InternalAceGen.g:5204:3: ( (lv_pattern_1_0= RULE_STRING ) )
            // InternalAceGen.g:5205:4: (lv_pattern_1_0= RULE_STRING )
            {
            // InternalAceGen.g:5205:4: (lv_pattern_1_0= RULE_STRING )
            // InternalAceGen.g:5206:5: lv_pattern_1_0= RULE_STRING
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
    // InternalAceGen.g:5226:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // InternalAceGen.g:5226:51: (iv_ruleStringType= ruleStringType EOF )
            // InternalAceGen.g:5227:2: iv_ruleStringType= ruleStringType EOF
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
    // InternalAceGen.g:5233:1: ruleStringType returns [EObject current=null] : ( (lv_string_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringType() throws RecognitionException {
        EObject current = null;

        Token lv_string_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5239:2: ( ( (lv_string_0_0= RULE_STRING ) ) )
            // InternalAceGen.g:5240:2: ( (lv_string_0_0= RULE_STRING ) )
            {
            // InternalAceGen.g:5240:2: ( (lv_string_0_0= RULE_STRING ) )
            // InternalAceGen.g:5241:3: (lv_string_0_0= RULE_STRING )
            {
            // InternalAceGen.g:5241:3: (lv_string_0_0= RULE_STRING )
            // InternalAceGen.g:5242:4: lv_string_0_0= RULE_STRING
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
    // InternalAceGen.g:5261:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // InternalAceGen.g:5261:52: (iv_ruleBooleanType= ruleBooleanType EOF )
            // InternalAceGen.g:5262:2: iv_ruleBooleanType= ruleBooleanType EOF
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
    // InternalAceGen.g:5268:1: ruleBooleanType returns [EObject current=null] : ( (lv_boolean_0_0= ruleJsonBoolean ) ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_boolean_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:5274:2: ( ( (lv_boolean_0_0= ruleJsonBoolean ) ) )
            // InternalAceGen.g:5275:2: ( (lv_boolean_0_0= ruleJsonBoolean ) )
            {
            // InternalAceGen.g:5275:2: ( (lv_boolean_0_0= ruleJsonBoolean ) )
            // InternalAceGen.g:5276:3: (lv_boolean_0_0= ruleJsonBoolean )
            {
            // InternalAceGen.g:5276:3: (lv_boolean_0_0= ruleJsonBoolean )
            // InternalAceGen.g:5277:4: lv_boolean_0_0= ruleJsonBoolean
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
    // InternalAceGen.g:5297:1: entryRuleNullType returns [EObject current=null] : iv_ruleNullType= ruleNullType EOF ;
    public final EObject entryRuleNullType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullType = null;


        try {
            // InternalAceGen.g:5297:49: (iv_ruleNullType= ruleNullType EOF )
            // InternalAceGen.g:5298:2: iv_ruleNullType= ruleNullType EOF
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
    // InternalAceGen.g:5304:1: ruleNullType returns [EObject current=null] : ( (lv_null_0_0= 'null' ) ) ;
    public final EObject ruleNullType() throws RecognitionException {
        EObject current = null;

        Token lv_null_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5310:2: ( ( (lv_null_0_0= 'null' ) ) )
            // InternalAceGen.g:5311:2: ( (lv_null_0_0= 'null' ) )
            {
            // InternalAceGen.g:5311:2: ( (lv_null_0_0= 'null' ) )
            // InternalAceGen.g:5312:3: (lv_null_0_0= 'null' )
            {
            // InternalAceGen.g:5312:3: (lv_null_0_0= 'null' )
            // InternalAceGen.g:5313:4: lv_null_0_0= 'null'
            {
            lv_null_0_0=(Token)match(input,78,FOLLOW_2); 

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
    // InternalAceGen.g:5328:1: entryRuleUndefinedType returns [EObject current=null] : iv_ruleUndefinedType= ruleUndefinedType EOF ;
    public final EObject entryRuleUndefinedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUndefinedType = null;


        try {
            // InternalAceGen.g:5328:54: (iv_ruleUndefinedType= ruleUndefinedType EOF )
            // InternalAceGen.g:5329:2: iv_ruleUndefinedType= ruleUndefinedType EOF
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
    // InternalAceGen.g:5335:1: ruleUndefinedType returns [EObject current=null] : ( (lv_undefined_0_0= 'undefined' ) ) ;
    public final EObject ruleUndefinedType() throws RecognitionException {
        EObject current = null;

        Token lv_undefined_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5341:2: ( ( (lv_undefined_0_0= 'undefined' ) ) )
            // InternalAceGen.g:5342:2: ( (lv_undefined_0_0= 'undefined' ) )
            {
            // InternalAceGen.g:5342:2: ( (lv_undefined_0_0= 'undefined' ) )
            // InternalAceGen.g:5343:3: (lv_undefined_0_0= 'undefined' )
            {
            // InternalAceGen.g:5343:3: (lv_undefined_0_0= 'undefined' )
            // InternalAceGen.g:5344:4: lv_undefined_0_0= 'undefined'
            {
            lv_undefined_0_0=(Token)match(input,96,FOLLOW_2); 

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
    // InternalAceGen.g:5359:1: entryRuleLongType returns [EObject current=null] : iv_ruleLongType= ruleLongType EOF ;
    public final EObject entryRuleLongType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongType = null;


        try {
            // InternalAceGen.g:5359:49: (iv_ruleLongType= ruleLongType EOF )
            // InternalAceGen.g:5360:2: iv_ruleLongType= ruleLongType EOF
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
    // InternalAceGen.g:5366:1: ruleLongType returns [EObject current=null] : ( (lv_long_0_0= RULE_INT ) ) ;
    public final EObject ruleLongType() throws RecognitionException {
        EObject current = null;

        Token lv_long_0_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5372:2: ( ( (lv_long_0_0= RULE_INT ) ) )
            // InternalAceGen.g:5373:2: ( (lv_long_0_0= RULE_INT ) )
            {
            // InternalAceGen.g:5373:2: ( (lv_long_0_0= RULE_INT ) )
            // InternalAceGen.g:5374:3: (lv_long_0_0= RULE_INT )
            {
            // InternalAceGen.g:5374:3: (lv_long_0_0= RULE_INT )
            // InternalAceGen.g:5375:4: lv_long_0_0= RULE_INT
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
    // InternalAceGen.g:5394:1: entryRuleJsonBoolean returns [String current=null] : iv_ruleJsonBoolean= ruleJsonBoolean EOF ;
    public final String entryRuleJsonBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleJsonBoolean = null;


        try {
            // InternalAceGen.g:5394:51: (iv_ruleJsonBoolean= ruleJsonBoolean EOF )
            // InternalAceGen.g:5395:2: iv_ruleJsonBoolean= ruleJsonBoolean EOF
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
    // InternalAceGen.g:5401:1: ruleJsonBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleJsonBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:5407:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalAceGen.g:5408:2: (kw= 'true' | kw= 'false' )
            {
            // InternalAceGen.g:5408:2: (kw= 'true' | kw= 'false' )
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==97) ) {
                alt140=1;
            }
            else if ( (LA140_0==98) ) {
                alt140=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;
            }
            switch (alt140) {
                case 1 :
                    // InternalAceGen.g:5409:3: kw= 'true'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getJsonBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:5415:3: kw= 'false'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

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
    // InternalAceGen.g:5424:1: entryRulePrimitiveValue returns [EObject current=null] : iv_rulePrimitiveValue= rulePrimitiveValue EOF ;
    public final EObject entryRulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValue = null;


        try {
            // InternalAceGen.g:5424:55: (iv_rulePrimitiveValue= rulePrimitiveValue EOF )
            // InternalAceGen.g:5425:2: iv_rulePrimitiveValue= rulePrimitiveValue EOF
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
    // InternalAceGen.g:5431:1: rulePrimitiveValue returns [EObject current=null] : ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) ) ;
    public final EObject rulePrimitiveValue() throws RecognitionException {
        EObject current = null;

        Token lv_string_0_0=null;
        Token lv_long_1_0=null;


        	enterRule();

        try {
            // InternalAceGen.g:5437:2: ( ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) ) )
            // InternalAceGen.g:5438:2: ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) )
            {
            // InternalAceGen.g:5438:2: ( ( (lv_string_0_0= RULE_STRING ) ) | ( (lv_long_1_0= RULE_INT ) ) )
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==RULE_STRING) ) {
                alt141=1;
            }
            else if ( (LA141_0==RULE_INT) ) {
                alt141=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }
            switch (alt141) {
                case 1 :
                    // InternalAceGen.g:5439:3: ( (lv_string_0_0= RULE_STRING ) )
                    {
                    // InternalAceGen.g:5439:3: ( (lv_string_0_0= RULE_STRING ) )
                    // InternalAceGen.g:5440:4: (lv_string_0_0= RULE_STRING )
                    {
                    // InternalAceGen.g:5440:4: (lv_string_0_0= RULE_STRING )
                    // InternalAceGen.g:5441:5: lv_string_0_0= RULE_STRING
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
                    // InternalAceGen.g:5458:3: ( (lv_long_1_0= RULE_INT ) )
                    {
                    // InternalAceGen.g:5458:3: ( (lv_long_1_0= RULE_INT ) )
                    // InternalAceGen.g:5459:4: (lv_long_1_0= RULE_INT )
                    {
                    // InternalAceGen.g:5459:4: (lv_long_1_0= RULE_INT )
                    // InternalAceGen.g:5460:5: lv_long_1_0= RULE_INT
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


    protected DFA52 dfa52 = new DFA52(this);
    protected DFA68 dfa68 = new DFA68(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\2\uffff\1\11\7\uffff";
    static final String dfa_3s = "\1\5\1\uffff\1\4\7\uffff";
    static final String dfa_4s = "\1\142\1\uffff\1\62\7\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\1\10\1\7\1\2";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\6\1\2\34\uffff\1\1\15\uffff\1\3\34\uffff\1\5\21\uffff\1\7\2\4",
            "",
            "\1\11\1\uffff\1\10\14\uffff\1\11\20\uffff\1\11\12\uffff\1\11\2\uffff\1\11",
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

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1899:2: (this_JsonObjectClient_0= ruleJsonObjectClient | this_StringType_1= ruleStringType | this_JsonArrayClient_2= ruleJsonArrayClient | this_BooleanType_3= ruleBooleanType | this_NullType_4= ruleNullType | this_LongType_5= ruleLongType | this_JsonDateTime_6= ruleJsonDateTime | this_UndefinedType_7= ruleUndefinedType )";
        }
    }
    static final String dfa_8s = "\11\uffff";
    static final String dfa_9s = "\1\4\1\73\1\4\1\74\1\4\1\125\1\74\2\uffff";
    static final String dfa_10s = "\1\4\1\73\1\4\1\124\1\4\1\130\1\124\2\uffff";
    static final String dfa_11s = "\7\uffff\1\1\1\2";
    static final String dfa_12s = "\11\uffff}>";
    static final String[] dfa_13s = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\5\27\uffff\1\4",
            "\1\6",
            "\3\7\1\10",
            "\1\5\27\uffff\1\4",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2308:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0008000000000002L});
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
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000030100000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008100010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000E00000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000011C0008010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000001C0008010L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000008008000010L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000008008000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000010000040002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000021000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00001C1000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000181000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000101000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000800000000012L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0002000800000060L,0x0000000700004000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000001000080010L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000001000080000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0006000800080060L,0x0000000700004000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0004000000080000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0070000000000010L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0060000000000010L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0040000000000010L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0780000000012002L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0700000000012002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0600000000012002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0600000000010012L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0400000000010012L,0x0000000000000008L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000010012L,0x0000000000000010L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000E00000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0xE000000002000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0xC000000002000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x8000000002000012L,0x0000000000000007L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000002000012L,0x0000000000000007L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000002000012L,0x0000000000000006L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000002000012L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0xE000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0xC000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x8000000000000012L,0x0000000000000007L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000007L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000006L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000001100000010L,0x000000007E060004L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000800000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000800080002L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000100060L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000022L,0x0000000000000080L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000020800000000L,0x0000000080019000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000002L,0x0000000000011000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000800000000002L,0x0000000000000102L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000820800000000L,0x0000000080008100L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000800000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000E00L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000800000000L,0x0000000080006000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000800000002L,0x0000000080008000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000800000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000100000010L,0x000000007E040004L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000100000010L,0x000000007E000004L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000100000010L,0x000000007E000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000010L,0x000000007E000000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000100000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0002000800000060L,0x0000000680004000L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0006000800080060L,0x0000000680004000L});

}