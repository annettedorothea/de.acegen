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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'HttpClient'", "'HttpServer'", "'ACE'", "'appState'", "'<'", "','", "'>'", "'call'", "'loadingFlag'", "'on'", "'('", "')'", "'triggers'", "'set'", "'merge'", "'reset'", "'init'", "'list'", "'location.hash'", "'storage'", "'|'", "':'", "'{'", "'}'", "'Authorization'", "'import'", "'views'", "'models'", "'proxy'", "'authorize'", "'pathParams'", "'queryParams'", "'payload'", "'response'", "'persistent'", "'extends'", "'Unique'", "'PrimaryKey'", "'List'", "'references'", "'.'", "'POST'", "'PUT'", "'DELETE'", "'GET'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'Long'", "'NotEmpty'", "'NotNull'"
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
    // InternalAceGen.g:71:1: ruleProject returns [EObject current=null] : ( ( () otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? ) | (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? ) ) ;
    public final EObject ruleProject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_httpClient_2_0 = null;

        EObject lv_httpServer_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:77:2: ( ( ( () otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? ) | (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? ) ) )
            // InternalAceGen.g:78:2: ( ( () otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? ) | (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? ) )
            {
            // InternalAceGen.g:78:2: ( ( () otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? ) | (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalAceGen.g:79:3: ( () otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? )
                    {
                    // InternalAceGen.g:79:3: ( () otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )? )
                    // InternalAceGen.g:80:4: () otherlv_1= 'HttpClient' ( (lv_httpClient_2_0= ruleHttpClient ) )?
                    {
                    // InternalAceGen.g:80:4: ()
                    // InternalAceGen.g:81:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getProjectAccess().getProjectAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,11,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getProjectAccess().getHttpClientKeyword_0_1());
                    			
                    // InternalAceGen.g:91:4: ( (lv_httpClient_2_0= ruleHttpClient ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_ID) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalAceGen.g:92:5: (lv_httpClient_2_0= ruleHttpClient )
                            {
                            // InternalAceGen.g:92:5: (lv_httpClient_2_0= ruleHttpClient )
                            // InternalAceGen.g:93:6: lv_httpClient_2_0= ruleHttpClient
                            {

                            						newCompositeNode(grammarAccess.getProjectAccess().getHttpClientHttpClientParserRuleCall_0_2_0());
                            					
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
                    // InternalAceGen.g:112:3: (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? )
                    {
                    // InternalAceGen.g:112:3: (otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )? )
                    // InternalAceGen.g:113:4: otherlv_3= 'HttpServer' ( (lv_httpServer_4_0= ruleHttpServer ) )?
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getProjectAccess().getHttpServerKeyword_1_0());
                    			
                    // InternalAceGen.g:117:4: ( (lv_httpServer_4_0= ruleHttpServer ) )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==RULE_ID) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalAceGen.g:118:5: (lv_httpServer_4_0= ruleHttpServer )
                            {
                            // InternalAceGen.g:118:5: (lv_httpServer_4_0= ruleHttpServer )
                            // InternalAceGen.g:119:6: lv_httpServer_4_0= ruleHttpServer
                            {

                            						newCompositeNode(grammarAccess.getProjectAccess().getHttpServerHttpServerParserRuleCall_1_1_0());
                            					
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


            	leaveRule();

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
    // InternalAceGen.g:141:1: entryRuleHttpClient returns [EObject current=null] : iv_ruleHttpClient= ruleHttpClient EOF ;
    public final EObject entryRuleHttpClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClient = null;


        try {
            // InternalAceGen.g:141:51: (iv_ruleHttpClient= ruleHttpClient EOF )
            // InternalAceGen.g:142:2: iv_ruleHttpClient= ruleHttpClient EOF
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
    // InternalAceGen.g:148:1: ruleHttpClient returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )? ) ;
    public final EObject ruleHttpClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_aceOperations_2_0 = null;

        EObject lv_appState_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:154:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )? ) )
            // InternalAceGen.g:155:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )? )
            {
            // InternalAceGen.g:155:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )? )
            // InternalAceGen.g:156:3: ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )? (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )?
            {
            // InternalAceGen.g:156:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalAceGen.g:157:4: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalAceGen.g:157:4: (lv_name_0_0= ruleQualifiedName )
            // InternalAceGen.g:158:5: lv_name_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getHttpClientAccess().getNameQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
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

            // InternalAceGen.g:175:3: (otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalAceGen.g:176:4: otherlv_1= 'ACE' ( (lv_aceOperations_2_0= ruleHttpClientAce ) )*
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getHttpClientAccess().getACEKeyword_1_0());
                    			
                    // InternalAceGen.g:180:4: ( (lv_aceOperations_2_0= ruleHttpClientAce ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalAceGen.g:181:5: (lv_aceOperations_2_0= ruleHttpClientAce )
                    	    {
                    	    // InternalAceGen.g:181:5: (lv_aceOperations_2_0= ruleHttpClientAce )
                    	    // InternalAceGen.g:182:6: lv_aceOperations_2_0= ruleHttpClientAce
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpClientAccess().getAceOperationsHttpClientAceParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_5);
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

            // InternalAceGen.g:200:3: (otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAceGen.g:201:4: otherlv_3= 'appState' ( (lv_appState_4_0= ruleHttpClientStateElement ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getHttpClientAccess().getAppStateKeyword_2_0());
                    			
                    // InternalAceGen.g:205:4: ( (lv_appState_4_0= ruleHttpClientStateElement ) )
                    // InternalAceGen.g:206:5: (lv_appState_4_0= ruleHttpClientStateElement )
                    {
                    // InternalAceGen.g:206:5: (lv_appState_4_0= ruleHttpClientStateElement )
                    // InternalAceGen.g:207:6: lv_appState_4_0= ruleHttpClientStateElement
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
    // InternalAceGen.g:229:1: entryRuleHttpClientAce returns [EObject current=null] : iv_ruleHttpClientAce= ruleHttpClientAce EOF ;
    public final EObject entryRuleHttpClientAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientAce = null;


        try {
            // InternalAceGen.g:229:54: (iv_ruleHttpClientAce= ruleHttpClientAce EOF )
            // InternalAceGen.g:230:2: iv_ruleHttpClientAce= ruleHttpClientAce EOF
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
    // InternalAceGen.g:236:1: ruleHttpClientAce returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_input_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_input_4_0= RULE_ID ) ) )* otherlv_5= '>' )? (otherlv_6= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_10_0= ruleHttpClientOutcome ) )* ) ;
    public final EObject ruleHttpClientAce() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_input_2_0=null;
        Token otherlv_3=null;
        Token lv_input_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_outcomes_10_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:242:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_input_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_input_4_0= RULE_ID ) ) )* otherlv_5= '>' )? (otherlv_6= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_10_0= ruleHttpClientOutcome ) )* ) )
            // InternalAceGen.g:243:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_input_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_input_4_0= RULE_ID ) ) )* otherlv_5= '>' )? (otherlv_6= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_10_0= ruleHttpClientOutcome ) )* )
            {
            // InternalAceGen.g:243:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_input_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_input_4_0= RULE_ID ) ) )* otherlv_5= '>' )? (otherlv_6= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_10_0= ruleHttpClientOutcome ) )* )
            // InternalAceGen.g:244:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_input_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_input_4_0= RULE_ID ) ) )* otherlv_5= '>' )? (otherlv_6= 'call' ( ( ruleQualifiedName ) ) )? (otherlv_8= 'loadingFlag' ( ( ruleQualifiedName ) ) )? ( (lv_outcomes_10_0= ruleHttpClientOutcome ) )*
            {
            // InternalAceGen.g:244:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:245:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:245:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:246:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_0_0, grammarAccess.getHttpClientAceAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpClientAceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAceGen.g:262:3: (otherlv_1= '<' ( (lv_input_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_input_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalAceGen.g:263:4: otherlv_1= '<' ( (lv_input_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_input_4_0= RULE_ID ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,15,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getHttpClientAceAccess().getLessThanSignKeyword_1_0());
                    			
                    // InternalAceGen.g:267:4: ( (lv_input_2_0= RULE_ID ) )
                    // InternalAceGen.g:268:5: (lv_input_2_0= RULE_ID )
                    {
                    // InternalAceGen.g:268:5: (lv_input_2_0= RULE_ID )
                    // InternalAceGen.g:269:6: lv_input_2_0= RULE_ID
                    {
                    lv_input_2_0=(Token)match(input,RULE_ID,FOLLOW_8); 

                    						newLeafNode(lv_input_2_0, grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpClientAceRule());
                    						}
                    						addWithLastConsumed(
                    							current,
                    							"input",
                    							lv_input_2_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    // InternalAceGen.g:285:4: (otherlv_3= ',' ( (lv_input_4_0= RULE_ID ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==16) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalAceGen.g:286:5: otherlv_3= ',' ( (lv_input_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FOLLOW_6); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getHttpClientAceAccess().getCommaKeyword_1_2_0());
                    	    				
                    	    // InternalAceGen.g:290:5: ( (lv_input_4_0= RULE_ID ) )
                    	    // InternalAceGen.g:291:6: (lv_input_4_0= RULE_ID )
                    	    {
                    	    // InternalAceGen.g:291:6: (lv_input_4_0= RULE_ID )
                    	    // InternalAceGen.g:292:7: lv_input_4_0= RULE_ID
                    	    {
                    	    lv_input_4_0=(Token)match(input,RULE_ID,FOLLOW_8); 

                    	    							newLeafNode(lv_input_4_0, grammarAccess.getHttpClientAceAccess().getInputIDTerminalRuleCall_1_2_1_0());
                    	    						

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getHttpClientAceRule());
                    	    							}
                    	    							addWithLastConsumed(
                    	    								current,
                    	    								"input",
                    	    								lv_input_4_0,
                    	    								"org.eclipse.xtext.common.Terminals.ID");
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,17,FOLLOW_9); 

                    				newLeafNode(otherlv_5, grammarAccess.getHttpClientAceAccess().getGreaterThanSignKeyword_1_3());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:314:3: (otherlv_6= 'call' ( ( ruleQualifiedName ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAceGen.g:315:4: otherlv_6= 'call' ( ( ruleQualifiedName ) )
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_6); 

                    				newLeafNode(otherlv_6, grammarAccess.getHttpClientAceAccess().getCallKeyword_2_0());
                    			
                    // InternalAceGen.g:319:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:320:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:320:5: ( ruleQualifiedName )
                    // InternalAceGen.g:321:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpClientAceRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpClientAceAccess().getServerCallHttpServerAceCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:336:3: (otherlv_8= 'loadingFlag' ( ( ruleQualifiedName ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAceGen.g:337:4: otherlv_8= 'loadingFlag' ( ( ruleQualifiedName ) )
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_6); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpClientAceAccess().getLoadingFlagKeyword_3_0());
                    			
                    // InternalAceGen.g:341:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:342:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:342:5: ( ruleQualifiedName )
                    // InternalAceGen.g:343:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpClientAceRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpClientAceAccess().getLoadingFlagHttpClientStateElementCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:358:3: ( (lv_outcomes_10_0= ruleHttpClientOutcome ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalAceGen.g:359:4: (lv_outcomes_10_0= ruleHttpClientOutcome )
            	    {
            	    // InternalAceGen.g:359:4: (lv_outcomes_10_0= ruleHttpClientOutcome )
            	    // InternalAceGen.g:360:5: lv_outcomes_10_0= ruleHttpClientOutcome
            	    {

            	    					newCompositeNode(grammarAccess.getHttpClientAceAccess().getOutcomesHttpClientOutcomeParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_outcomes_10_0=ruleHttpClientOutcome();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHttpClientAceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"outcomes",
            	    						lv_outcomes_10_0,
            	    						"de.acegen.AceGen.HttpClientOutcome");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // InternalAceGen.g:381:1: entryRuleHttpClientOutcome returns [EObject current=null] : iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF ;
    public final EObject entryRuleHttpClientOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientOutcome = null;


        try {
            // InternalAceGen.g:381:58: (iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF )
            // InternalAceGen.g:382:2: iv_ruleHttpClientOutcome= ruleHttpClientOutcome EOF
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
    // InternalAceGen.g:388:1: ruleHttpClientOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? ) ;
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
            // InternalAceGen.g:394:2: ( (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? ) )
            // InternalAceGen.g:395:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? )
            {
            // InternalAceGen.g:395:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? )
            // InternalAceGen.g:396:3: otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )? (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpClientOutcomeAccess().getOnKeyword_0());
            		
            // InternalAceGen.g:400:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:401:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:401:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:402:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            // InternalAceGen.g:418:3: (otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalAceGen.g:419:4: otherlv_2= '(' ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )* otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_13); 

                    				newLeafNode(otherlv_2, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalAceGen.g:423:4: ( (lv_listeners_3_0= ruleHttpClientStateFunction ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=24 && LA12_0<=27)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalAceGen.g:424:5: (lv_listeners_3_0= ruleHttpClientStateFunction )
                    	    {
                    	    // InternalAceGen.g:424:5: (lv_listeners_3_0= ruleHttpClientStateFunction )
                    	    // InternalAceGen.g:425:6: lv_listeners_3_0= ruleHttpClientStateFunction
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpClientOutcomeAccess().getListenersHttpClientStateFunctionParserRuleCall_2_1_0());
                    	    					
                    	    pushFollow(FOLLOW_13);
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
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,22,FOLLOW_14); 

                    				newLeafNode(otherlv_4, grammarAccess.getHttpClientOutcomeAccess().getRightParenthesisKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalAceGen.g:447:3: (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalAceGen.g:448:4: otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,23,FOLLOW_15); 

                    				newLeafNode(otherlv_5, grammarAccess.getHttpClientOutcomeAccess().getTriggersKeyword_3_0());
                    			
                    otherlv_6=(Token)match(input,21,FOLLOW_16); 

                    				newLeafNode(otherlv_6, grammarAccess.getHttpClientOutcomeAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalAceGen.g:456:4: ( ( ruleQualifiedName ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalAceGen.g:457:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:457:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:458:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpClientOutcomeRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpClientOutcomeAccess().getAceOperationsHttpClientAceCrossReference_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_16);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,22,FOLLOW_2); 

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
    // InternalAceGen.g:481:1: entryRuleHttpClientStateFunction returns [EObject current=null] : iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF ;
    public final EObject entryRuleHttpClientStateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientStateFunction = null;


        try {
            // InternalAceGen.g:481:64: (iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF )
            // InternalAceGen.g:482:2: iv_ruleHttpClientStateFunction= ruleHttpClientStateFunction EOF
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
    // InternalAceGen.g:488:1: ruleHttpClientStateFunction returns [EObject current=null] : ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleHttpClientStateFunction() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_stateFunctionType_0_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:494:2: ( ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) ) )
            // InternalAceGen.g:495:2: ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) )
            {
            // InternalAceGen.g:495:2: ( ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) ) )
            // InternalAceGen.g:496:3: ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) ) ( ( ruleQualifiedName ) )
            {
            // InternalAceGen.g:496:3: ( (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType ) )
            // InternalAceGen.g:497:4: (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType )
            {
            // InternalAceGen.g:497:4: (lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType )
            // InternalAceGen.g:498:5: lv_stateFunctionType_0_0= ruleHttpClientStateFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeHttpClientStateFunctionTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_6);
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

            // InternalAceGen.g:515:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:516:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:516:4: ( ruleQualifiedName )
            // InternalAceGen.g:517:5: ruleQualifiedName
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
    // InternalAceGen.g:535:1: entryRuleHttpClientStateFunctionType returns [String current=null] : iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF ;
    public final String entryRuleHttpClientStateFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHttpClientStateFunctionType = null;


        try {
            // InternalAceGen.g:535:67: (iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF )
            // InternalAceGen.g:536:2: iv_ruleHttpClientStateFunctionType= ruleHttpClientStateFunctionType EOF
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
    // InternalAceGen.g:542:1: ruleHttpClientStateFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'set' | kw= 'merge' | kw= 'reset' | kw= 'init' ) ;
    public final AntlrDatatypeRuleToken ruleHttpClientStateFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:548:2: ( (kw= 'set' | kw= 'merge' | kw= 'reset' | kw= 'init' ) )
            // InternalAceGen.g:549:2: (kw= 'set' | kw= 'merge' | kw= 'reset' | kw= 'init' )
            {
            // InternalAceGen.g:549:2: (kw= 'set' | kw= 'merge' | kw= 'reset' | kw= 'init' )
            int alt16=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt16=1;
                }
                break;
            case 25:
                {
                alt16=2;
                }
                break;
            case 26:
                {
                alt16=3;
                }
                break;
            case 27:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalAceGen.g:550:3: kw= 'set'
                    {
                    kw=(Token)match(input,24,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getSetKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:556:3: kw= 'merge'
                    {
                    kw=(Token)match(input,25,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getMergeKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:562:3: kw= 'reset'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getHttpClientStateFunctionTypeAccess().getResetKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAceGen.g:568:3: kw= 'init'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

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
    // InternalAceGen.g:577:1: entryRuleHttpClientStateElement returns [EObject current=null] : iv_ruleHttpClientStateElement= ruleHttpClientStateElement EOF ;
    public final EObject entryRuleHttpClientStateElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientStateElement = null;


        try {
            // InternalAceGen.g:577:63: (iv_ruleHttpClientStateElement= ruleHttpClientStateElement EOF )
            // InternalAceGen.g:578:2: iv_ruleHttpClientStateElement= ruleHttpClientStateElement EOF
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
    // InternalAceGen.g:584:1: ruleHttpClientStateElement returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_list_1_0= 'list' ) )? ( (lv_hash_2_0= 'location.hash' ) )? ( (lv_storage_3_0= 'storage' ) )? ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )? ) ;
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
            // InternalAceGen.g:590:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_list_1_0= 'list' ) )? ( (lv_hash_2_0= 'location.hash' ) )? ( (lv_storage_3_0= 'storage' ) )? ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )? ) )
            // InternalAceGen.g:591:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_list_1_0= 'list' ) )? ( (lv_hash_2_0= 'location.hash' ) )? ( (lv_storage_3_0= 'storage' ) )? ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )? )
            {
            // InternalAceGen.g:591:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_list_1_0= 'list' ) )? ( (lv_hash_2_0= 'location.hash' ) )? ( (lv_storage_3_0= 'storage' ) )? ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )? )
            // InternalAceGen.g:592:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_list_1_0= 'list' ) )? ( (lv_hash_2_0= 'location.hash' ) )? ( (lv_storage_3_0= 'storage' ) )? ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )?
            {
            // InternalAceGen.g:592:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:593:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:593:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:594:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); 

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

            // InternalAceGen.g:610:3: ( (lv_list_1_0= 'list' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAceGen.g:611:4: (lv_list_1_0= 'list' )
                    {
                    // InternalAceGen.g:611:4: (lv_list_1_0= 'list' )
                    // InternalAceGen.g:612:5: lv_list_1_0= 'list'
                    {
                    lv_list_1_0=(Token)match(input,28,FOLLOW_18); 

                    					newLeafNode(lv_list_1_0, grammarAccess.getHttpClientStateElementAccess().getListListKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpClientStateElementRule());
                    					}
                    					setWithLastConsumed(current, "list", true, "list");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:624:3: ( (lv_hash_2_0= 'location.hash' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==29) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAceGen.g:625:4: (lv_hash_2_0= 'location.hash' )
                    {
                    // InternalAceGen.g:625:4: (lv_hash_2_0= 'location.hash' )
                    // InternalAceGen.g:626:5: lv_hash_2_0= 'location.hash'
                    {
                    lv_hash_2_0=(Token)match(input,29,FOLLOW_19); 

                    					newLeafNode(lv_hash_2_0, grammarAccess.getHttpClientStateElementAccess().getHashLocationHashKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpClientStateElementRule());
                    					}
                    					setWithLastConsumed(current, "hash", true, "location.hash");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:638:3: ( (lv_storage_3_0= 'storage' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==30) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAceGen.g:639:4: (lv_storage_3_0= 'storage' )
                    {
                    // InternalAceGen.g:639:4: (lv_storage_3_0= 'storage' )
                    // InternalAceGen.g:640:5: lv_storage_3_0= 'storage'
                    {
                    lv_storage_3_0=(Token)match(input,30,FOLLOW_20); 

                    					newLeafNode(lv_storage_3_0, grammarAccess.getHttpClientStateElementAccess().getStorageStorageKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpClientStateElementRule());
                    					}
                    					setWithLastConsumed(current, "storage", true, "storage");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:652:3: ( ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalAceGen.g:653:4: ( (lv_types_4_0= ruleHttpClientTypeDefinition ) ) (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )*
                    {
                    // InternalAceGen.g:653:4: ( (lv_types_4_0= ruleHttpClientTypeDefinition ) )
                    // InternalAceGen.g:654:5: (lv_types_4_0= ruleHttpClientTypeDefinition )
                    {
                    // InternalAceGen.g:654:5: (lv_types_4_0= ruleHttpClientTypeDefinition )
                    // InternalAceGen.g:655:6: lv_types_4_0= ruleHttpClientTypeDefinition
                    {

                    						newCompositeNode(grammarAccess.getHttpClientStateElementAccess().getTypesHttpClientTypeDefinitionParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_21);
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

                    // InternalAceGen.g:672:4: (otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==31) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalAceGen.g:673:5: otherlv_5= '|' ( (lv_types_6_0= ruleHttpClientTypeDefinition ) )
                    	    {
                    	    otherlv_5=(Token)match(input,31,FOLLOW_22); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getHttpClientStateElementAccess().getVerticalLineKeyword_4_1_0());
                    	    				
                    	    // InternalAceGen.g:677:5: ( (lv_types_6_0= ruleHttpClientTypeDefinition ) )
                    	    // InternalAceGen.g:678:6: (lv_types_6_0= ruleHttpClientTypeDefinition )
                    	    {
                    	    // InternalAceGen.g:678:6: (lv_types_6_0= ruleHttpClientTypeDefinition )
                    	    // InternalAceGen.g:679:7: lv_types_6_0= ruleHttpClientTypeDefinition
                    	    {

                    	    							newCompositeNode(grammarAccess.getHttpClientStateElementAccess().getTypesHttpClientTypeDefinitionParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_21);
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
                    	    break loop20;
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
    // InternalAceGen.g:702:1: entryRuleHttpClientTypeDefinition returns [EObject current=null] : iv_ruleHttpClientTypeDefinition= ruleHttpClientTypeDefinition EOF ;
    public final EObject entryRuleHttpClientTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpClientTypeDefinition = null;


        try {
            // InternalAceGen.g:702:65: (iv_ruleHttpClientTypeDefinition= ruleHttpClientTypeDefinition EOF )
            // InternalAceGen.g:703:2: iv_ruleHttpClientTypeDefinition= ruleHttpClientTypeDefinition EOF
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
    // InternalAceGen.g:709:1: ruleHttpClientTypeDefinition returns [EObject current=null] : (otherlv_0= ':' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleHttpClientStateElement ) )* otherlv_4= '}' ) ;
    public final EObject ruleHttpClientTypeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:715:2: ( (otherlv_0= ':' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleHttpClientStateElement ) )* otherlv_4= '}' ) )
            // InternalAceGen.g:716:2: (otherlv_0= ':' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleHttpClientStateElement ) )* otherlv_4= '}' )
            {
            // InternalAceGen.g:716:2: (otherlv_0= ':' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleHttpClientStateElement ) )* otherlv_4= '}' )
            // InternalAceGen.g:717:3: otherlv_0= ':' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleHttpClientStateElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpClientTypeDefinitionAccess().getColonKeyword_0());
            		
            // InternalAceGen.g:721:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:722:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:722:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:723:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_23); 

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

            otherlv_2=(Token)match(input,33,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getHttpClientTypeDefinitionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalAceGen.g:743:3: ( (lv_elements_3_0= ruleHttpClientStateElement ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalAceGen.g:744:4: (lv_elements_3_0= ruleHttpClientStateElement )
            	    {
            	    // InternalAceGen.g:744:4: (lv_elements_3_0= ruleHttpClientStateElement )
            	    // InternalAceGen.g:745:5: lv_elements_3_0= ruleHttpClientStateElement
            	    {

            	    					newCompositeNode(grammarAccess.getHttpClientTypeDefinitionAccess().getElementsHttpClientStateElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_24);
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
            	    break loop22;
                }
            } while (true);

            otherlv_4=(Token)match(input,34,FOLLOW_2); 

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
    // InternalAceGen.g:770:1: entryRuleHttpServer returns [EObject current=null] : iv_ruleHttpServer= ruleHttpServer EOF ;
    public final EObject entryRuleHttpServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServer = null;


        try {
            // InternalAceGen.g:770:51: (iv_ruleHttpServer= ruleHttpServer EOF )
            // InternalAceGen.g:771:2: iv_ruleHttpServer= ruleHttpServer EOF
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
    // InternalAceGen.g:777:1: ruleHttpServer returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'Authorization' ( (lv_authUser_2_0= ruleAuthUser ) ) )? (otherlv_3= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_5= 'ACE' ( (lv_aceOperations_6_0= ruleHttpServerAce ) )* )? (otherlv_7= 'views' ( (lv_views_8_0= ruleHttpServerView ) )* )? (otherlv_9= 'models' ( (lv_models_10_0= ruleModel ) )* )? ) ;
    public final EObject ruleHttpServer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_authUser_2_0 = null;

        EObject lv_aceOperations_6_0 = null;

        EObject lv_views_8_0 = null;

        EObject lv_models_10_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:783:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'Authorization' ( (lv_authUser_2_0= ruleAuthUser ) ) )? (otherlv_3= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_5= 'ACE' ( (lv_aceOperations_6_0= ruleHttpServerAce ) )* )? (otherlv_7= 'views' ( (lv_views_8_0= ruleHttpServerView ) )* )? (otherlv_9= 'models' ( (lv_models_10_0= ruleModel ) )* )? ) )
            // InternalAceGen.g:784:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'Authorization' ( (lv_authUser_2_0= ruleAuthUser ) ) )? (otherlv_3= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_5= 'ACE' ( (lv_aceOperations_6_0= ruleHttpServerAce ) )* )? (otherlv_7= 'views' ( (lv_views_8_0= ruleHttpServerView ) )* )? (otherlv_9= 'models' ( (lv_models_10_0= ruleModel ) )* )? )
            {
            // InternalAceGen.g:784:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'Authorization' ( (lv_authUser_2_0= ruleAuthUser ) ) )? (otherlv_3= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_5= 'ACE' ( (lv_aceOperations_6_0= ruleHttpServerAce ) )* )? (otherlv_7= 'views' ( (lv_views_8_0= ruleHttpServerView ) )* )? (otherlv_9= 'models' ( (lv_models_10_0= ruleModel ) )* )? )
            // InternalAceGen.g:785:3: ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= 'Authorization' ( (lv_authUser_2_0= ruleAuthUser ) ) )? (otherlv_3= 'import' ( ( ruleQualifiedName ) ) )? (otherlv_5= 'ACE' ( (lv_aceOperations_6_0= ruleHttpServerAce ) )* )? (otherlv_7= 'views' ( (lv_views_8_0= ruleHttpServerView ) )* )? (otherlv_9= 'models' ( (lv_models_10_0= ruleModel ) )* )?
            {
            // InternalAceGen.g:785:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalAceGen.g:786:4: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalAceGen.g:786:4: (lv_name_0_0= ruleQualifiedName )
            // InternalAceGen.g:787:5: lv_name_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getHttpServerAccess().getNameQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHttpServerRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"de.acegen.AceGen.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAceGen.g:804:3: (otherlv_1= 'Authorization' ( (lv_authUser_2_0= ruleAuthUser ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalAceGen.g:805:4: otherlv_1= 'Authorization' ( (lv_authUser_2_0= ruleAuthUser ) )
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getHttpServerAccess().getAuthorizationKeyword_1_0());
                    			
                    // InternalAceGen.g:809:4: ( (lv_authUser_2_0= ruleAuthUser ) )
                    // InternalAceGen.g:810:5: (lv_authUser_2_0= ruleAuthUser )
                    {
                    // InternalAceGen.g:810:5: (lv_authUser_2_0= ruleAuthUser )
                    // InternalAceGen.g:811:6: lv_authUser_2_0= ruleAuthUser
                    {

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserAuthUserParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_26);
                    lv_authUser_2_0=ruleAuthUser();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    						}
                    						set(
                    							current,
                    							"authUser",
                    							lv_authUser_2_0,
                    							"de.acegen.AceGen.AuthUser");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:829:3: (otherlv_3= 'import' ( ( ruleQualifiedName ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalAceGen.g:830:4: otherlv_3= 'import' ( ( ruleQualifiedName ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getHttpServerAccess().getImportKeyword_2_0());
                    			
                    // InternalAceGen.g:834:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:835:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:835:5: ( ruleQualifiedName )
                    // InternalAceGen.g:836:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getHttpServerRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getHttpServerAccess().getAuthUserRefAuthUserCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_27);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:851:3: (otherlv_5= 'ACE' ( (lv_aceOperations_6_0= ruleHttpServerAce ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==13) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalAceGen.g:852:4: otherlv_5= 'ACE' ( (lv_aceOperations_6_0= ruleHttpServerAce ) )*
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_28); 

                    				newLeafNode(otherlv_5, grammarAccess.getHttpServerAccess().getACEKeyword_3_0());
                    			
                    // InternalAceGen.g:856:4: ( (lv_aceOperations_6_0= ruleHttpServerAce ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==RULE_ID||LA25_0==39) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalAceGen.g:857:5: (lv_aceOperations_6_0= ruleHttpServerAce )
                    	    {
                    	    // InternalAceGen.g:857:5: (lv_aceOperations_6_0= ruleHttpServerAce )
                    	    // InternalAceGen.g:858:6: lv_aceOperations_6_0= ruleHttpServerAce
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getAceOperationsHttpServerAceParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_28);
                    	    lv_aceOperations_6_0=ruleHttpServerAce();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aceOperations",
                    	    							lv_aceOperations_6_0,
                    	    							"de.acegen.AceGen.HttpServerAce");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalAceGen.g:876:3: (otherlv_7= 'views' ( (lv_views_8_0= ruleHttpServerView ) )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==37) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalAceGen.g:877:4: otherlv_7= 'views' ( (lv_views_8_0= ruleHttpServerView ) )*
                    {
                    otherlv_7=(Token)match(input,37,FOLLOW_29); 

                    				newLeafNode(otherlv_7, grammarAccess.getHttpServerAccess().getViewsKeyword_4_0());
                    			
                    // InternalAceGen.g:881:4: ( (lv_views_8_0= ruleHttpServerView ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==RULE_ID) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalAceGen.g:882:5: (lv_views_8_0= ruleHttpServerView )
                    	    {
                    	    // InternalAceGen.g:882:5: (lv_views_8_0= ruleHttpServerView )
                    	    // InternalAceGen.g:883:6: lv_views_8_0= ruleHttpServerView
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getViewsHttpServerViewParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_29);
                    	    lv_views_8_0=ruleHttpServerView();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"views",
                    	    							lv_views_8_0,
                    	    							"de.acegen.AceGen.HttpServerView");
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

            // InternalAceGen.g:901:3: (otherlv_9= 'models' ( (lv_models_10_0= ruleModel ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==38) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalAceGen.g:902:4: otherlv_9= 'models' ( (lv_models_10_0= ruleModel ) )*
                    {
                    otherlv_9=(Token)match(input,38,FOLLOW_30); 

                    				newLeafNode(otherlv_9, grammarAccess.getHttpServerAccess().getModelsKeyword_5_0());
                    			
                    // InternalAceGen.g:906:4: ( (lv_models_10_0= ruleModel ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_ID||LA29_0==45) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalAceGen.g:907:5: (lv_models_10_0= ruleModel )
                    	    {
                    	    // InternalAceGen.g:907:5: (lv_models_10_0= ruleModel )
                    	    // InternalAceGen.g:908:6: lv_models_10_0= ruleModel
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerAccess().getModelsModelParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_30);
                    	    lv_models_10_0=ruleModel();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getHttpServerRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"models",
                    	    							lv_models_10_0,
                    	    							"de.acegen.AceGen.Model");
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


            }


            }


            	leaveRule();

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
    // InternalAceGen.g:930:1: entryRuleHttpServerAce returns [EObject current=null] : iv_ruleHttpServerAce= ruleHttpServerAce EOF ;
    public final EObject entryRuleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAce = null;


        try {
            // InternalAceGen.g:930:54: (iv_ruleHttpServerAce= ruleHttpServerAce EOF )
            // InternalAceGen.g:931:2: iv_ruleHttpServerAce= ruleHttpServerAce EOF
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
    // InternalAceGen.g:937:1: ruleHttpServerAce returns [EObject current=null] : (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) ;
    public final EObject ruleHttpServerAce() throws RecognitionException {
        EObject current = null;

        EObject this_HttpServerAceWrite_0 = null;

        EObject this_HttpServerAceRead_1 = null;



        	enterRule();

        try {
            // InternalAceGen.g:943:2: ( (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead ) )
            // InternalAceGen.g:944:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            {
            // InternalAceGen.g:944:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // InternalAceGen.g:945:3: this_HttpServerAceWrite_0= ruleHttpServerAceWrite
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
                    // InternalAceGen.g:954:3: this_HttpServerAceRead_1= ruleHttpServerAceRead
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
    // InternalAceGen.g:966:1: entryRuleHttpServerAceWrite returns [EObject current=null] : iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF ;
    public final EObject entryRuleHttpServerAceWrite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceWrite = null;


        try {
            // InternalAceGen.g:966:59: (iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF )
            // InternalAceGen.g:967:2: iv_ruleHttpServerAceWrite= ruleHttpServerAceWrite EOF
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
    // InternalAceGen.g:973:1: ruleHttpServerAceWrite returns [EObject current=null] : ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )? (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )? (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* ) ;
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

        EObject lv_outcomes_16_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:979:2: ( ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )? (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )? (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* ) )
            // InternalAceGen.g:980:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )? (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )? (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* )
            {
            // InternalAceGen.g:980:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )? (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )? (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )* )
            // InternalAceGen.g:981:3: ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleWriteFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )? (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )? (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )*
            {
            // InternalAceGen.g:981:3: ( (lv_proxy_0_0= 'proxy' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==39) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAceGen.g:982:4: (lv_proxy_0_0= 'proxy' )
                    {
                    // InternalAceGen.g:982:4: (lv_proxy_0_0= 'proxy' )
                    // InternalAceGen.g:983:5: lv_proxy_0_0= 'proxy'
                    {
                    lv_proxy_0_0=(Token)match(input,39,FOLLOW_6); 

                    					newLeafNode(lv_proxy_0_0, grammarAccess.getHttpServerAceWriteAccess().getProxyProxyKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    					}
                    					setWithLastConsumed(current, "proxy", true, "proxy");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:995:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:996:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:996:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:997:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_31); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getHttpServerAceWriteAccess().getLessThanSignKeyword_2());
            		
            // InternalAceGen.g:1017:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1018:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1018:4: ( ruleQualifiedName )
            // InternalAceGen.g:1019:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getModelModelCrossReference_3_0());
            				
            pushFollow(FOLLOW_32);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_33); 

            			newLeafNode(otherlv_4, grammarAccess.getHttpServerAceWriteAccess().getGreaterThanSignKeyword_4());
            		
            // InternalAceGen.g:1037:3: ( (lv_type_5_0= ruleWriteFunctionType ) )
            // InternalAceGen.g:1038:4: (lv_type_5_0= ruleWriteFunctionType )
            {
            // InternalAceGen.g:1038:4: (lv_type_5_0= ruleWriteFunctionType )
            // InternalAceGen.g:1039:5: lv_type_5_0= ruleWriteFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getTypeWriteFunctionTypeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_34);
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

            // InternalAceGen.g:1056:3: ( (lv_url_6_0= RULE_STRING ) )
            // InternalAceGen.g:1057:4: (lv_url_6_0= RULE_STRING )
            {
            // InternalAceGen.g:1057:4: (lv_url_6_0= RULE_STRING )
            // InternalAceGen.g:1058:5: lv_url_6_0= RULE_STRING
            {
            lv_url_6_0=(Token)match(input,RULE_STRING,FOLLOW_35); 

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

            // InternalAceGen.g:1074:3: ( (lv_authorize_7_0= 'authorize' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==40) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalAceGen.g:1075:4: (lv_authorize_7_0= 'authorize' )
                    {
                    // InternalAceGen.g:1075:4: (lv_authorize_7_0= 'authorize' )
                    // InternalAceGen.g:1076:5: lv_authorize_7_0= 'authorize'
                    {
                    lv_authorize_7_0=(Token)match(input,40,FOLLOW_36); 

                    					newLeafNode(lv_authorize_7_0, grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAuthorizeKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    					}
                    					setWithLastConsumed(current, "authorize", true, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1088:3: (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==41) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalAceGen.g:1089:4: otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_8=(Token)match(input,41,FOLLOW_37); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerAceWriteAccess().getPathParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:1093:4: ( ( ruleQualifiedName ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==RULE_ID) ) {
                            int LA34_2 = input.LA(2);

                            if ( (LA34_2==EOF||LA34_2==RULE_ID||LA34_2==20||(LA34_2>=37 && LA34_2<=39)||(LA34_2>=42 && LA34_2<=44)||LA34_2==51) ) {
                                alt34=1;
                            }


                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalAceGen.g:1094:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1094:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1095:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAttributeCrossReference_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_37);
                    	    ruleQualifiedName();

                    	    state._fsp--;


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

            // InternalAceGen.g:1110:3: (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==42) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalAceGen.g:1111:4: otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_10=(Token)match(input,42,FOLLOW_38); 

                    				newLeafNode(otherlv_10, grammarAccess.getHttpServerAceWriteAccess().getQueryParamsKeyword_9_0());
                    			
                    // InternalAceGen.g:1115:4: ( ( ruleQualifiedName ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==RULE_ID) ) {
                            int LA36_2 = input.LA(2);

                            if ( (LA36_2==EOF||LA36_2==RULE_ID||LA36_2==20||(LA36_2>=37 && LA36_2<=39)||(LA36_2>=43 && LA36_2<=44)||LA36_2==51) ) {
                                alt36=1;
                            }


                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalAceGen.g:1116:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1116:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1117:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAttributeCrossReference_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_38);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

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

            // InternalAceGen.g:1132:3: (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==43) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalAceGen.g:1133:4: otherlv_12= 'payload' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_12=(Token)match(input,43,FOLLOW_39); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpServerAceWriteAccess().getPayloadKeyword_10_0());
                    			
                    // InternalAceGen.g:1137:4: ( ( ruleQualifiedName ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==RULE_ID) ) {
                            int LA38_2 = input.LA(2);

                            if ( (LA38_2==EOF||LA38_2==RULE_ID||LA38_2==20||(LA38_2>=37 && LA38_2<=39)||LA38_2==44||LA38_2==51) ) {
                                alt38=1;
                            }


                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalAceGen.g:1138:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1138:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1139:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getPayloadAttributeCrossReference_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_39);
                    	    ruleQualifiedName();

                    	    state._fsp--;


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

            // InternalAceGen.g:1154:3: (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==44) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalAceGen.g:1155:4: otherlv_14= 'response' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_14=(Token)match(input,44,FOLLOW_40); 

                    				newLeafNode(otherlv_14, grammarAccess.getHttpServerAceWriteAccess().getResponseKeyword_11_0());
                    			
                    // InternalAceGen.g:1159:4: ( ( ruleQualifiedName ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID) ) {
                            int LA40_2 = input.LA(2);

                            if ( (LA40_2==EOF||LA40_2==RULE_ID||LA40_2==20||(LA40_2>=37 && LA40_2<=39)||LA40_2==51) ) {
                                alt40=1;
                            }


                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalAceGen.g:1160:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1160:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1161:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceWriteRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getResponseAttributeCrossReference_11_1_0());
                    	    					
                    	    pushFollow(FOLLOW_40);
                    	    ruleQualifiedName();

                    	    state._fsp--;


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

            // InternalAceGen.g:1176:3: ( (lv_outcomes_16_0= ruleHttpServerOutcome ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==20) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalAceGen.g:1177:4: (lv_outcomes_16_0= ruleHttpServerOutcome )
            	    {
            	    // InternalAceGen.g:1177:4: (lv_outcomes_16_0= ruleHttpServerOutcome )
            	    // InternalAceGen.g:1178:5: lv_outcomes_16_0= ruleHttpServerOutcome
            	    {

            	    					newCompositeNode(grammarAccess.getHttpServerAceWriteAccess().getOutcomesHttpServerOutcomeParserRuleCall_12_0());
            	    				
            	    pushFollow(FOLLOW_11);
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
            	    break loop42;
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
    // InternalAceGen.g:1199:1: entryRuleHttpServerOutcome returns [EObject current=null] : iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF ;
    public final EObject entryRuleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerOutcome = null;


        try {
            // InternalAceGen.g:1199:58: (iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF )
            // InternalAceGen.g:1200:2: iv_ruleHttpServerOutcome= ruleHttpServerOutcome EOF
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
    // InternalAceGen.g:1206:1: ruleHttpServerOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? ) ;
    public final EObject ruleHttpServerOutcome() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalAceGen.g:1212:2: ( (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? ) )
            // InternalAceGen.g:1213:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? )
            {
            // InternalAceGen.g:1213:2: (otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )? )
            // InternalAceGen.g:1214:3: otherlv_0= 'on' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )* (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getHttpServerOutcomeAccess().getOnKeyword_0());
            		
            // InternalAceGen.g:1218:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:1219:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:1219:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:1220:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            // InternalAceGen.g:1236:3: (otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==21) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalAceGen.g:1237:4: otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')'
            	    {
            	    otherlv_2=(Token)match(input,21,FOLLOW_16); 

            	    				newLeafNode(otherlv_2, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_2_0());
            	    			
            	    // InternalAceGen.g:1241:4: ( ( ruleQualifiedName ) )*
            	    loop43:
            	    do {
            	        int alt43=2;
            	        int LA43_0 = input.LA(1);

            	        if ( (LA43_0==RULE_ID) ) {
            	            alt43=1;
            	        }


            	        switch (alt43) {
            	    	case 1 :
            	    	    // InternalAceGen.g:1242:5: ( ruleQualifiedName )
            	    	    {
            	    	    // InternalAceGen.g:1242:5: ( ruleQualifiedName )
            	    	    // InternalAceGen.g:1243:6: ruleQualifiedName
            	    	    {

            	    	    						if (current==null) {
            	    	    							current = createModelElement(grammarAccess.getHttpServerOutcomeRule());
            	    	    						}
            	    	    					

            	    	    						newCompositeNode(grammarAccess.getHttpServerOutcomeAccess().getListenersHttpServerViewFunctionCrossReference_2_1_0());
            	    	    					
            	    	    pushFollow(FOLLOW_16);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;


            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop43;
            	        }
            	    } while (true);

            	    otherlv_4=(Token)match(input,22,FOLLOW_12); 

            	    				newLeafNode(otherlv_4, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_2_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            // InternalAceGen.g:1262:3: (otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==23) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalAceGen.g:1263:4: otherlv_5= 'triggers' otherlv_6= '(' ( ( ruleQualifiedName ) )* otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,23,FOLLOW_15); 

                    				newLeafNode(otherlv_5, grammarAccess.getHttpServerOutcomeAccess().getTriggersKeyword_3_0());
                    			
                    otherlv_6=(Token)match(input,21,FOLLOW_16); 

                    				newLeafNode(otherlv_6, grammarAccess.getHttpServerOutcomeAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalAceGen.g:1271:4: ( ( ruleQualifiedName ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==RULE_ID) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalAceGen.g:1272:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1272:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1273:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerOutcomeRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerOutcomeAccess().getAceOperationsHttpServerAceWriteCrossReference_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_16);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerOutcomeAccess().getRightParenthesisKeyword_3_3());
                    			

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
    // $ANTLR end "ruleHttpServerOutcome"


    // $ANTLR start "entryRuleHttpServerAceRead"
    // InternalAceGen.g:1296:1: entryRuleHttpServerAceRead returns [EObject current=null] : iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF ;
    public final EObject entryRuleHttpServerAceRead() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerAceRead = null;


        try {
            // InternalAceGen.g:1296:58: (iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF )
            // InternalAceGen.g:1297:2: iv_ruleHttpServerAceRead= ruleHttpServerAceRead EOF
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
    // InternalAceGen.g:1303:1: ruleHttpServerAceRead returns [EObject current=null] : ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )? (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )? (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ) ;
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



        	enterRule();

        try {
            // InternalAceGen.g:1309:2: ( ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )? (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )? (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? ) )
            // InternalAceGen.g:1310:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )? (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )? (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? )
            {
            // InternalAceGen.g:1310:2: ( ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )? (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )? (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )? )
            // InternalAceGen.g:1311:3: ( (lv_proxy_0_0= 'proxy' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '<' ( ( ruleQualifiedName ) ) otherlv_4= '>' ( (lv_type_5_0= ruleReadFunctionType ) ) ( (lv_url_6_0= RULE_STRING ) ) ( (lv_authorize_7_0= 'authorize' ) )? (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )? (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )? (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )? (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )?
            {
            // InternalAceGen.g:1311:3: ( (lv_proxy_0_0= 'proxy' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==39) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalAceGen.g:1312:4: (lv_proxy_0_0= 'proxy' )
                    {
                    // InternalAceGen.g:1312:4: (lv_proxy_0_0= 'proxy' )
                    // InternalAceGen.g:1313:5: lv_proxy_0_0= 'proxy'
                    {
                    lv_proxy_0_0=(Token)match(input,39,FOLLOW_6); 

                    					newLeafNode(lv_proxy_0_0, grammarAccess.getHttpServerAceReadAccess().getProxyProxyKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    					}
                    					setWithLastConsumed(current, "proxy", true, "proxy");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1325:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:1326:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:1326:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:1327:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_31); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getHttpServerAceReadAccess().getLessThanSignKeyword_2());
            		
            // InternalAceGen.g:1347:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1348:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1348:4: ( ruleQualifiedName )
            // InternalAceGen.g:1349:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getModelModelCrossReference_3_0());
            				
            pushFollow(FOLLOW_32);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_41); 

            			newLeafNode(otherlv_4, grammarAccess.getHttpServerAceReadAccess().getGreaterThanSignKeyword_4());
            		
            // InternalAceGen.g:1367:3: ( (lv_type_5_0= ruleReadFunctionType ) )
            // InternalAceGen.g:1368:4: (lv_type_5_0= ruleReadFunctionType )
            {
            // InternalAceGen.g:1368:4: (lv_type_5_0= ruleReadFunctionType )
            // InternalAceGen.g:1369:5: lv_type_5_0= ruleReadFunctionType
            {

            					newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getTypeReadFunctionTypeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_34);
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

            // InternalAceGen.g:1386:3: ( (lv_url_6_0= RULE_STRING ) )
            // InternalAceGen.g:1387:4: (lv_url_6_0= RULE_STRING )
            {
            // InternalAceGen.g:1387:4: (lv_url_6_0= RULE_STRING )
            // InternalAceGen.g:1388:5: lv_url_6_0= RULE_STRING
            {
            lv_url_6_0=(Token)match(input,RULE_STRING,FOLLOW_42); 

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

            // InternalAceGen.g:1404:3: ( (lv_authorize_7_0= 'authorize' ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==40) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalAceGen.g:1405:4: (lv_authorize_7_0= 'authorize' )
                    {
                    // InternalAceGen.g:1405:4: (lv_authorize_7_0= 'authorize' )
                    // InternalAceGen.g:1406:5: lv_authorize_7_0= 'authorize'
                    {
                    lv_authorize_7_0=(Token)match(input,40,FOLLOW_43); 

                    					newLeafNode(lv_authorize_7_0, grammarAccess.getHttpServerAceReadAccess().getAuthorizeAuthorizeKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    					}
                    					setWithLastConsumed(current, "authorize", true, "authorize");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1418:3: (otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )* )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==41) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalAceGen.g:1419:4: otherlv_8= 'pathParams' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_8=(Token)match(input,41,FOLLOW_44); 

                    				newLeafNode(otherlv_8, grammarAccess.getHttpServerAceReadAccess().getPathParamsKeyword_8_0());
                    			
                    // InternalAceGen.g:1423:4: ( ( ruleQualifiedName ) )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==RULE_ID) ) {
                            int LA49_2 = input.LA(2);

                            if ( (LA49_2==EOF||LA49_2==RULE_ID||(LA49_2>=37 && LA49_2<=39)||(LA49_2>=42 && LA49_2<=44)||LA49_2==51) ) {
                                alt49=1;
                            }


                        }


                        switch (alt49) {
                    	case 1 :
                    	    // InternalAceGen.g:1424:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1424:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1425:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPathParamsAttributeCrossReference_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_44);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

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

            // InternalAceGen.g:1440:3: (otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==42) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalAceGen.g:1441:4: otherlv_10= 'queryParams' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_10=(Token)match(input,42,FOLLOW_45); 

                    				newLeafNode(otherlv_10, grammarAccess.getHttpServerAceReadAccess().getQueryParamsKeyword_9_0());
                    			
                    // InternalAceGen.g:1445:4: ( ( ruleQualifiedName ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==RULE_ID) ) {
                            int LA51_2 = input.LA(2);

                            if ( (LA51_2==EOF||LA51_2==RULE_ID||(LA51_2>=37 && LA51_2<=39)||(LA51_2>=43 && LA51_2<=44)||LA51_2==51) ) {
                                alt51=1;
                            }


                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalAceGen.g:1446:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1446:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1447:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAttributeCrossReference_9_1_0());
                    	    					
                    	    pushFollow(FOLLOW_45);
                    	    ruleQualifiedName();

                    	    state._fsp--;


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

            // InternalAceGen.g:1462:3: (otherlv_12= 'payload' ( ( ruleQualifiedName ) )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==43) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalAceGen.g:1463:4: otherlv_12= 'payload' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_12=(Token)match(input,43,FOLLOW_46); 

                    				newLeafNode(otherlv_12, grammarAccess.getHttpServerAceReadAccess().getPayloadKeyword_10_0());
                    			
                    // InternalAceGen.g:1467:4: ( ( ruleQualifiedName ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==RULE_ID) ) {
                            int LA53_2 = input.LA(2);

                            if ( (LA53_2==EOF||LA53_2==RULE_ID||(LA53_2>=37 && LA53_2<=39)||LA53_2==44||LA53_2==51) ) {
                                alt53=1;
                            }


                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalAceGen.g:1468:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1468:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1469:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getHttpServerAceReadRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getHttpServerAceReadAccess().getPayloadAttributeCrossReference_10_1_0());
                    	    					
                    	    pushFollow(FOLLOW_46);
                    	    ruleQualifiedName();

                    	    state._fsp--;


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

            // InternalAceGen.g:1484:3: (otherlv_14= 'response' ( ( ruleQualifiedName ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==44) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalAceGen.g:1485:4: otherlv_14= 'response' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_14=(Token)match(input,44,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getHttpServerAceReadAccess().getResponseKeyword_11_0());
                    			
                    // InternalAceGen.g:1489:4: ( ( ruleQualifiedName ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==RULE_ID) ) {
                            int LA55_2 = input.LA(2);

                            if ( (LA55_2==EOF||LA55_2==RULE_ID||(LA55_2>=37 && LA55_2<=39)||LA55_2==51) ) {
                                alt55=1;
                            }


                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalAceGen.g:1490:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1490:5: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1491:6: ruleQualifiedName
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
                    	    break loop55;
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


    // $ANTLR start "entryRuleHttpServerView"
    // InternalAceGen.g:1510:1: entryRuleHttpServerView returns [EObject current=null] : iv_ruleHttpServerView= ruleHttpServerView EOF ;
    public final EObject entryRuleHttpServerView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerView = null;


        try {
            // InternalAceGen.g:1510:55: (iv_ruleHttpServerView= ruleHttpServerView EOF )
            // InternalAceGen.g:1511:2: iv_ruleHttpServerView= ruleHttpServerView EOF
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
    // InternalAceGen.g:1517:1: ruleHttpServerView returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleHttpServerView() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_renderFunctions_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1523:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? ) )
            // InternalAceGen.g:1524:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? )
            {
            // InternalAceGen.g:1524:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )? )
            // InternalAceGen.g:1525:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )?
            {
            // InternalAceGen.g:1525:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1526:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1526:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1527:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_47); 

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

            // InternalAceGen.g:1543:3: (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==33) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalAceGen.g:1544:4: otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_24); 

                    				newLeafNode(otherlv_1, grammarAccess.getHttpServerViewAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalAceGen.g:1548:4: ( (lv_renderFunctions_2_0= ruleHttpServerViewFunction ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==RULE_ID) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalAceGen.g:1549:5: (lv_renderFunctions_2_0= ruleHttpServerViewFunction )
                    	    {
                    	    // InternalAceGen.g:1549:5: (lv_renderFunctions_2_0= ruleHttpServerViewFunction )
                    	    // InternalAceGen.g:1550:6: lv_renderFunctions_2_0= ruleHttpServerViewFunction
                    	    {

                    	    						newCompositeNode(grammarAccess.getHttpServerViewAccess().getRenderFunctionsHttpServerViewFunctionParserRuleCall_1_1_0());
                    	    					
                    	    pushFollow(FOLLOW_24);
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
                    	    break loop57;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,34,FOLLOW_2); 

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
    // InternalAceGen.g:1576:1: entryRuleHttpServerViewFunction returns [EObject current=null] : iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF ;
    public final EObject entryRuleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHttpServerViewFunction = null;


        try {
            // InternalAceGen.g:1576:63: (iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF )
            // InternalAceGen.g:1577:2: iv_ruleHttpServerViewFunction= ruleHttpServerViewFunction EOF
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
    // InternalAceGen.g:1583:1: ruleHttpServerViewFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) ;
    public final EObject ruleHttpServerViewFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalAceGen.g:1589:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' ) )
            // InternalAceGen.g:1590:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            {
            // InternalAceGen.g:1590:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )
            // InternalAceGen.g:1591:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')'
            {
            // InternalAceGen.g:1591:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1592:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1592:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1593:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_15); 

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

            otherlv_1=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getHttpServerViewFunctionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalAceGen.g:1613:3: ( ( ruleQualifiedName ) )
            // InternalAceGen.g:1614:4: ( ruleQualifiedName )
            {
            // InternalAceGen.g:1614:4: ( ruleQualifiedName )
            // InternalAceGen.g:1615:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHttpServerViewFunctionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHttpServerViewFunctionAccess().getModelModelCrossReference_2_0());
            				
            pushFollow(FOLLOW_48);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_2); 

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
    // InternalAceGen.g:1637:1: entryRuleAuthUser returns [EObject current=null] : iv_ruleAuthUser= ruleAuthUser EOF ;
    public final EObject entryRuleAuthUser() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthUser = null;


        try {
            // InternalAceGen.g:1637:49: (iv_ruleAuthUser= ruleAuthUser EOF )
            // InternalAceGen.g:1638:2: iv_ruleAuthUser= ruleAuthUser EOF
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
    // InternalAceGen.g:1644:1: ruleAuthUser returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) ;
    public final EObject ruleAuthUser() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_attributes_2_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1650:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) ) )
            // InternalAceGen.g:1651:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            {
            // InternalAceGen.g:1651:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' ) )
            // InternalAceGen.g:1652:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            {
            // InternalAceGen.g:1652:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAceGen.g:1653:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAceGen.g:1653:4: (lv_name_0_0= RULE_ID )
            // InternalAceGen.g:1654:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_23); 

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

            // InternalAceGen.g:1670:3: (otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}' )
            // InternalAceGen.g:1671:4: otherlv_1= '{' ( (lv_attributes_2_0= ruleAttribute ) )* otherlv_3= '}'
            {
            otherlv_1=(Token)match(input,33,FOLLOW_49); 

            				newLeafNode(otherlv_1, grammarAccess.getAuthUserAccess().getLeftCurlyBracketKeyword_1_0());
            			
            // InternalAceGen.g:1675:4: ( (lv_attributes_2_0= ruleAttribute ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_ID||(LA59_0>=47 && LA59_0<=49)||(LA59_0>=56 && LA59_0<=63)) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalAceGen.g:1676:5: (lv_attributes_2_0= ruleAttribute )
            	    {
            	    // InternalAceGen.g:1676:5: (lv_attributes_2_0= ruleAttribute )
            	    // InternalAceGen.g:1677:6: lv_attributes_2_0= ruleAttribute
            	    {

            	    						newCompositeNode(grammarAccess.getAuthUserAccess().getAttributesAttributeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_49);
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
            	    break loop59;
                }
            } while (true);

            otherlv_3=(Token)match(input,34,FOLLOW_2); 

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
    // InternalAceGen.g:1703:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAceGen.g:1703:46: (iv_ruleModel= ruleModel EOF )
            // InternalAceGen.g:1704:2: iv_ruleModel= ruleModel EOF
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
    // InternalAceGen.g:1710:1: ruleModel returns [EObject current=null] : ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) ;
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
            // InternalAceGen.g:1716:2: ( ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? ) )
            // InternalAceGen.g:1717:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            {
            // InternalAceGen.g:1717:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )? )
            // InternalAceGen.g:1718:3: ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            {
            // InternalAceGen.g:1718:3: ( (lv_persistent_0_0= 'persistent' ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==45) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalAceGen.g:1719:4: (lv_persistent_0_0= 'persistent' )
                    {
                    // InternalAceGen.g:1719:4: (lv_persistent_0_0= 'persistent' )
                    // InternalAceGen.g:1720:5: lv_persistent_0_0= 'persistent'
                    {
                    lv_persistent_0_0=(Token)match(input,45,FOLLOW_6); 

                    					newLeafNode(lv_persistent_0_0, grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(current, "persistent", true, "persistent");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1732:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAceGen.g:1733:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAceGen.g:1733:4: (lv_name_1_0= RULE_ID )
            // InternalAceGen.g:1734:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_50); 

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

            // InternalAceGen.g:1750:3: (otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==46) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalAceGen.g:1751:4: otherlv_2= 'extends' ( ( ruleQualifiedName ) ) (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getExtendsKeyword_2_0());
                    			
                    // InternalAceGen.g:1755:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:1756:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:1756:5: ( ruleQualifiedName )
                    // InternalAceGen.g:1757:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModelRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_51);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalAceGen.g:1771:4: (otherlv_4= ',' ( ( ruleQualifiedName ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==16) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // InternalAceGen.g:1772:5: otherlv_4= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_6); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getModelAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalAceGen.g:1776:5: ( ( ruleQualifiedName ) )
                    	    // InternalAceGen.g:1777:6: ( ruleQualifiedName )
                    	    {
                    	    // InternalAceGen.g:1777:6: ( ruleQualifiedName )
                    	    // InternalAceGen.g:1778:7: ruleQualifiedName
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModelRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getModelAccess().getSuperModelsModelCrossReference_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_51);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


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

            // InternalAceGen.g:1794:3: (otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==33) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalAceGen.g:1795:4: otherlv_6= '{' ( (lv_attributes_7_0= ruleAttribute ) )* otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,33,FOLLOW_49); 

                    				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalAceGen.g:1799:4: ( (lv_attributes_7_0= ruleAttribute ) )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==RULE_ID||(LA63_0>=47 && LA63_0<=49)||(LA63_0>=56 && LA63_0<=63)) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // InternalAceGen.g:1800:5: (lv_attributes_7_0= ruleAttribute )
                    	    {
                    	    // InternalAceGen.g:1800:5: (lv_attributes_7_0= ruleAttribute )
                    	    // InternalAceGen.g:1801:6: lv_attributes_7_0= ruleAttribute
                    	    {

                    	    						newCompositeNode(grammarAccess.getModelAccess().getAttributesAttributeParserRuleCall_3_1_0());
                    	    					
                    	    pushFollow(FOLLOW_49);
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
                    	    break loop63;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,34,FOLLOW_2); 

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


    // $ANTLR start "entryRuleAttribute"
    // InternalAceGen.g:1827:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalAceGen.g:1827:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalAceGen.g:1828:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalAceGen.g:1834:1: ruleAttribute returns [EObject current=null] : ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_constraint_2_0= ruleConstraint ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_unique_0_0=null;
        Token lv_primaryKey_1_0=null;
        Token lv_list_3_0=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_constraint_2_0 = null;

        AntlrDatatypeRuleToken lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalAceGen.g:1840:2: ( ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_constraint_2_0= ruleConstraint ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? ) )
            // InternalAceGen.g:1841:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_constraint_2_0= ruleConstraint ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? )
            {
            // InternalAceGen.g:1841:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_constraint_2_0= ruleConstraint ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )? )
            // InternalAceGen.g:1842:3: ( (lv_unique_0_0= 'Unique' ) )? ( (lv_primaryKey_1_0= 'PrimaryKey' ) )? ( (lv_constraint_2_0= ruleConstraint ) )? ( (lv_list_3_0= 'List' ) )? ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) ) ( (lv_name_6_0= RULE_ID ) ) (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )?
            {
            // InternalAceGen.g:1842:3: ( (lv_unique_0_0= 'Unique' ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==47) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalAceGen.g:1843:4: (lv_unique_0_0= 'Unique' )
                    {
                    // InternalAceGen.g:1843:4: (lv_unique_0_0= 'Unique' )
                    // InternalAceGen.g:1844:5: lv_unique_0_0= 'Unique'
                    {
                    lv_unique_0_0=(Token)match(input,47,FOLLOW_52); 

                    					newLeafNode(lv_unique_0_0, grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "unique", true, "Unique");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1856:3: ( (lv_primaryKey_1_0= 'PrimaryKey' ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==48) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalAceGen.g:1857:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    {
                    // InternalAceGen.g:1857:4: (lv_primaryKey_1_0= 'PrimaryKey' )
                    // InternalAceGen.g:1858:5: lv_primaryKey_1_0= 'PrimaryKey'
                    {
                    lv_primaryKey_1_0=(Token)match(input,48,FOLLOW_53); 

                    					newLeafNode(lv_primaryKey_1_0, grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "primaryKey", true, "PrimaryKey");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1870:3: ( (lv_constraint_2_0= ruleConstraint ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=62 && LA67_0<=63)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalAceGen.g:1871:4: (lv_constraint_2_0= ruleConstraint )
                    {
                    // InternalAceGen.g:1871:4: (lv_constraint_2_0= ruleConstraint )
                    // InternalAceGen.g:1872:5: lv_constraint_2_0= ruleConstraint
                    {

                    					newCompositeNode(grammarAccess.getAttributeAccess().getConstraintConstraintParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_54);
                    lv_constraint_2_0=ruleConstraint();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getAttributeRule());
                    					}
                    					set(
                    						current,
                    						"constraint",
                    						lv_constraint_2_0,
                    						"de.acegen.AceGen.Constraint");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1889:3: ( (lv_list_3_0= 'List' ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==49) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalAceGen.g:1890:4: (lv_list_3_0= 'List' )
                    {
                    // InternalAceGen.g:1890:4: (lv_list_3_0= 'List' )
                    // InternalAceGen.g:1891:5: lv_list_3_0= 'List'
                    {
                    lv_list_3_0=(Token)match(input,49,FOLLOW_55); 

                    					newLeafNode(lv_list_3_0, grammarAccess.getAttributeAccess().getListListKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "list", true, "List");
                    				

                    }


                    }
                    break;

            }

            // InternalAceGen.g:1903:3: ( ( (lv_type_4_0= ruleType ) ) | ( ( ruleQualifiedName ) ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=56 && LA69_0<=61)) ) {
                alt69=1;
            }
            else if ( (LA69_0==RULE_ID) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalAceGen.g:1904:4: ( (lv_type_4_0= ruleType ) )
                    {
                    // InternalAceGen.g:1904:4: ( (lv_type_4_0= ruleType ) )
                    // InternalAceGen.g:1905:5: (lv_type_4_0= ruleType )
                    {
                    // InternalAceGen.g:1905:5: (lv_type_4_0= ruleType )
                    // InternalAceGen.g:1906:6: lv_type_4_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getAttributeAccess().getTypeTypeParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_6);
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
                    // InternalAceGen.g:1924:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalAceGen.g:1924:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:1925:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:1925:5: ( ruleQualifiedName )
                    // InternalAceGen.g:1926:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getModelModelCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_6);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAceGen.g:1941:3: ( (lv_name_6_0= RULE_ID ) )
            // InternalAceGen.g:1942:4: (lv_name_6_0= RULE_ID )
            {
            // InternalAceGen.g:1942:4: (lv_name_6_0= RULE_ID )
            // InternalAceGen.g:1943:5: lv_name_6_0= RULE_ID
            {
            lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_56); 

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

            // InternalAceGen.g:1959:3: (otherlv_7= 'references' ( ( ruleQualifiedName ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==50) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalAceGen.g:1960:4: otherlv_7= 'references' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,50,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getAttributeAccess().getReferencesKeyword_6_0());
                    			
                    // InternalAceGen.g:1964:4: ( ( ruleQualifiedName ) )
                    // InternalAceGen.g:1965:5: ( ruleQualifiedName )
                    {
                    // InternalAceGen.g:1965:5: ( ruleQualifiedName )
                    // InternalAceGen.g:1966:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAttributeRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    ruleQualifiedName();

                    state._fsp--;


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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalAceGen.g:1985:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalAceGen.g:1985:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalAceGen.g:1986:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalAceGen.g:1992:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalAceGen.g:1998:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalAceGen.g:1999:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalAceGen.g:1999:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalAceGen.g:2000:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_57); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalAceGen.g:2007:3: (kw= '.' this_ID_2= RULE_ID )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==51) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalAceGen.g:2008:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,51,FOLLOW_6); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_57); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop71;
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
    // InternalAceGen.g:2025:1: entryRuleWriteFunctionType returns [String current=null] : iv_ruleWriteFunctionType= ruleWriteFunctionType EOF ;
    public final String entryRuleWriteFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleWriteFunctionType = null;


        try {
            // InternalAceGen.g:2025:57: (iv_ruleWriteFunctionType= ruleWriteFunctionType EOF )
            // InternalAceGen.g:2026:2: iv_ruleWriteFunctionType= ruleWriteFunctionType EOF
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
    // InternalAceGen.g:2032:1: ruleWriteFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) ;
    public final AntlrDatatypeRuleToken ruleWriteFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:2038:2: ( (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' ) )
            // InternalAceGen.g:2039:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            {
            // InternalAceGen.g:2039:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' )
            int alt72=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt72=1;
                }
                break;
            case 53:
                {
                alt72=2;
                }
                break;
            case 54:
                {
                alt72=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // InternalAceGen.g:2040:3: kw= 'POST'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPOSTKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:2046:3: kw= 'PUT'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getWriteFunctionTypeAccess().getPUTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:2052:3: kw= 'DELETE'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

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
    // InternalAceGen.g:2061:1: entryRuleReadFunctionType returns [String current=null] : iv_ruleReadFunctionType= ruleReadFunctionType EOF ;
    public final String entryRuleReadFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReadFunctionType = null;


        try {
            // InternalAceGen.g:2061:56: (iv_ruleReadFunctionType= ruleReadFunctionType EOF )
            // InternalAceGen.g:2062:2: iv_ruleReadFunctionType= ruleReadFunctionType EOF
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
    // InternalAceGen.g:2068:1: ruleReadFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'GET' ;
    public final AntlrDatatypeRuleToken ruleReadFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:2074:2: (kw= 'GET' )
            // InternalAceGen.g:2075:2: kw= 'GET'
            {
            kw=(Token)match(input,55,FOLLOW_2); 

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
    // InternalAceGen.g:2083:1: entryRuleType returns [String current=null] : iv_ruleType= ruleType EOF ;
    public final String entryRuleType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType = null;


        try {
            // InternalAceGen.g:2083:44: (iv_ruleType= ruleType EOF )
            // InternalAceGen.g:2084:2: iv_ruleType= ruleType EOF
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
    // InternalAceGen.g:2090:1: ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' ) ;
    public final AntlrDatatypeRuleToken ruleType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:2096:2: ( (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' ) )
            // InternalAceGen.g:2097:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' )
            {
            // InternalAceGen.g:2097:2: (kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' | kw= 'Long' )
            int alt73=6;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt73=1;
                }
                break;
            case 57:
                {
                alt73=2;
                }
                break;
            case 58:
                {
                alt73=3;
                }
                break;
            case 59:
                {
                alt73=4;
                }
                break;
            case 60:
                {
                alt73=5;
                }
                break;
            case 61:
                {
                alt73=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // InternalAceGen.g:2098:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getIntegerKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:2104:3: kw= 'String'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getStringKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAceGen.g:2110:3: kw= 'Float'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getFloatKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAceGen.g:2116:3: kw= 'Boolean'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getBooleanKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalAceGen.g:2122:3: kw= 'DateTime'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getDateTimeKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalAceGen.g:2128:3: kw= 'Long'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

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


    // $ANTLR start "entryRuleConstraint"
    // InternalAceGen.g:2137:1: entryRuleConstraint returns [String current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final String entryRuleConstraint() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConstraint = null;


        try {
            // InternalAceGen.g:2137:50: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalAceGen.g:2138:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalAceGen.g:2144:1: ruleConstraint returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'NotEmpty' | kw= 'NotNull' ) ;
    public final AntlrDatatypeRuleToken ruleConstraint() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAceGen.g:2150:2: ( (kw= 'NotEmpty' | kw= 'NotNull' ) )
            // InternalAceGen.g:2151:2: (kw= 'NotEmpty' | kw= 'NotNull' )
            {
            // InternalAceGen.g:2151:2: (kw= 'NotEmpty' | kw= 'NotNull' )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==62) ) {
                alt74=1;
            }
            else if ( (LA74_0==63) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalAceGen.g:2152:3: kw= 'NotEmpty'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConstraintAccess().getNotEmptyKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:2158:3: kw= 'NotNull'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConstraintAccess().getNotNullKeyword_1());
                    		

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
    // $ANTLR end "ruleConstraint"

    // Delegated rules


    protected DFA31 dfa31 = new DFA31(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\2\4\1\17\1\4\1\21\1\4\1\64\1\21\2\uffff";
    static final String dfa_3s = "\1\47\1\4\1\17\1\4\1\63\1\4\1\67\1\63\2\uffff";
    static final String dfa_4s = "\10\uffff\1\1\1\2";
    static final String dfa_5s = "\12\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\42\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\41\uffff\1\5",
            "\1\7",
            "\3\10\1\11",
            "\1\6\41\uffff\1\5",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "944:2: (this_HttpServerAceWrite_0= ruleHttpServerAceWrite | this_HttpServerAceRead_1= ruleHttpServerAceRead )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000001C8002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000001C0002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000F400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000170000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000160000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000140000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000007800002002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000007000002002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000006000002002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x000000E000000012L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000012L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000200000000012L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0070000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00001F0000100002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00001E0000100002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00001C0000100012L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000180000100012L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000100000100012L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000100012L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00001F0000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x00001E0000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x00001C0000000012L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000180000000012L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000100000000012L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0xFF03800400000010L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000400200000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000200010002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0xFF03000000000010L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0xFF02000000000010L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x3F02000000000010L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x3F00000000000010L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0008000000000002L});

}