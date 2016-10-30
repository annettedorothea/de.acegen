package com.anfelisa.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.anfelisa.services.AceGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAceParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'target'", "'ES6'", "'JAVA'", "'models'", "'{'", "'}'", "'data'", "'actions'", "'commands'", "'events'", "'views'", "'persistent'", "'('", "')'", "':'", "'Unique'", "'uses'", "'executes'", "'on'", "'publishes'", "'triggers'", "'listenedToBy'", "'.'", "'POST'", "'PUT'", "'DELETE'", "'GET'", "'Serial'", "'Integer'", "'String'", "'Float'", "'Boolean'", "'DateTime'", "'NotEmpty'", "'NotNull'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
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
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalAceParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAceParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAceParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAce.g"; }



     	private AceGrammarAccess grammarAccess;

        public InternalAceParser(TokenStream input, AceGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Project";
       	}

       	@Override
       	protected AceGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProject"
    // InternalAce.g:64:1: entryRuleProject returns [EObject current=null] : iv_ruleProject= ruleProject EOF ;
    public final EObject entryRuleProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProject = null;


        try {
            // InternalAce.g:64:48: (iv_ruleProject= ruleProject EOF )
            // InternalAce.g:65:2: iv_ruleProject= ruleProject EOF
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
    // InternalAce.g:71:1: ruleProject returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= 'target' ( ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) ) ) (otherlv_3= 'models' otherlv_4= '{' ( (lv_models_5_0= ruleModel ) )* otherlv_6= '}' )* (otherlv_7= 'data' otherlv_8= '{' ( (lv_data_9_0= ruleData ) )* otherlv_10= '}' )* (otherlv_11= 'actions' otherlv_12= '{' ( (lv_actions_13_0= ruleAction ) )* otherlv_14= '}' )* (otherlv_15= 'commands' otherlv_16= '{' ( (lv_commands_17_0= ruleCommand ) )* otherlv_18= '}' )* (otherlv_19= 'events' otherlv_20= '{' ( (lv_events_21_0= ruleEvent ) )* otherlv_22= '}' )* (otherlv_23= 'views' otherlv_24= '{' ( (lv_views_25_0= ruleView ) )* otherlv_26= '}' )* ) ;
    public final EObject ruleProject() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_target_2_1=null;
        Token lv_target_2_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_models_5_0 = null;

        EObject lv_data_9_0 = null;

        EObject lv_actions_13_0 = null;

        EObject lv_commands_17_0 = null;

        EObject lv_events_21_0 = null;

        EObject lv_views_25_0 = null;



        	enterRule();

        try {
            // InternalAce.g:77:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= 'target' ( ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) ) ) (otherlv_3= 'models' otherlv_4= '{' ( (lv_models_5_0= ruleModel ) )* otherlv_6= '}' )* (otherlv_7= 'data' otherlv_8= '{' ( (lv_data_9_0= ruleData ) )* otherlv_10= '}' )* (otherlv_11= 'actions' otherlv_12= '{' ( (lv_actions_13_0= ruleAction ) )* otherlv_14= '}' )* (otherlv_15= 'commands' otherlv_16= '{' ( (lv_commands_17_0= ruleCommand ) )* otherlv_18= '}' )* (otherlv_19= 'events' otherlv_20= '{' ( (lv_events_21_0= ruleEvent ) )* otherlv_22= '}' )* (otherlv_23= 'views' otherlv_24= '{' ( (lv_views_25_0= ruleView ) )* otherlv_26= '}' )* ) )
            // InternalAce.g:78:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= 'target' ( ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) ) ) (otherlv_3= 'models' otherlv_4= '{' ( (lv_models_5_0= ruleModel ) )* otherlv_6= '}' )* (otherlv_7= 'data' otherlv_8= '{' ( (lv_data_9_0= ruleData ) )* otherlv_10= '}' )* (otherlv_11= 'actions' otherlv_12= '{' ( (lv_actions_13_0= ruleAction ) )* otherlv_14= '}' )* (otherlv_15= 'commands' otherlv_16= '{' ( (lv_commands_17_0= ruleCommand ) )* otherlv_18= '}' )* (otherlv_19= 'events' otherlv_20= '{' ( (lv_events_21_0= ruleEvent ) )* otherlv_22= '}' )* (otherlv_23= 'views' otherlv_24= '{' ( (lv_views_25_0= ruleView ) )* otherlv_26= '}' )* )
            {
            // InternalAce.g:78:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= 'target' ( ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) ) ) (otherlv_3= 'models' otherlv_4= '{' ( (lv_models_5_0= ruleModel ) )* otherlv_6= '}' )* (otherlv_7= 'data' otherlv_8= '{' ( (lv_data_9_0= ruleData ) )* otherlv_10= '}' )* (otherlv_11= 'actions' otherlv_12= '{' ( (lv_actions_13_0= ruleAction ) )* otherlv_14= '}' )* (otherlv_15= 'commands' otherlv_16= '{' ( (lv_commands_17_0= ruleCommand ) )* otherlv_18= '}' )* (otherlv_19= 'events' otherlv_20= '{' ( (lv_events_21_0= ruleEvent ) )* otherlv_22= '}' )* (otherlv_23= 'views' otherlv_24= '{' ( (lv_views_25_0= ruleView ) )* otherlv_26= '}' )* )
            // InternalAce.g:79:3: ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= 'target' ( ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) ) ) (otherlv_3= 'models' otherlv_4= '{' ( (lv_models_5_0= ruleModel ) )* otherlv_6= '}' )* (otherlv_7= 'data' otherlv_8= '{' ( (lv_data_9_0= ruleData ) )* otherlv_10= '}' )* (otherlv_11= 'actions' otherlv_12= '{' ( (lv_actions_13_0= ruleAction ) )* otherlv_14= '}' )* (otherlv_15= 'commands' otherlv_16= '{' ( (lv_commands_17_0= ruleCommand ) )* otherlv_18= '}' )* (otherlv_19= 'events' otherlv_20= '{' ( (lv_events_21_0= ruleEvent ) )* otherlv_22= '}' )* (otherlv_23= 'views' otherlv_24= '{' ( (lv_views_25_0= ruleView ) )* otherlv_26= '}' )*
            {
            // InternalAce.g:79:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalAce.g:80:4: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalAce.g:80:4: (lv_name_0_0= ruleQualifiedName )
            // InternalAce.g:81:5: lv_name_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getProjectAccess().getNameQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProjectRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"com.anfelisa.Ace.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getProjectAccess().getTargetKeyword_1());
            		
            // InternalAce.g:102:3: ( ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) ) )
            // InternalAce.g:103:4: ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) )
            {
            // InternalAce.g:103:4: ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) )
            // InternalAce.g:104:5: (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' )
            {
            // InternalAce.g:104:5: (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==13) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalAce.g:105:6: lv_target_2_1= 'ES6'
                    {
                    lv_target_2_1=(Token)match(input,12,FOLLOW_5); 

                    						newLeafNode(lv_target_2_1, grammarAccess.getProjectAccess().getTargetES6Keyword_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProjectRule());
                    						}
                    						setWithLastConsumed(current, "target", lv_target_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalAce.g:116:6: lv_target_2_2= 'JAVA'
                    {
                    lv_target_2_2=(Token)match(input,13,FOLLOW_5); 

                    						newLeafNode(lv_target_2_2, grammarAccess.getProjectAccess().getTargetJAVAKeyword_2_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProjectRule());
                    						}
                    						setWithLastConsumed(current, "target", lv_target_2_2, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalAce.g:129:3: (otherlv_3= 'models' otherlv_4= '{' ( (lv_models_5_0= ruleModel ) )* otherlv_6= '}' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAce.g:130:4: otherlv_3= 'models' otherlv_4= '{' ( (lv_models_5_0= ruleModel ) )* otherlv_6= '}'
            	    {
            	    otherlv_3=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_3, grammarAccess.getProjectAccess().getModelsKeyword_3_0());
            	    			
            	    otherlv_4=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_4, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_3_1());
            	    			
            	    // InternalAce.g:138:4: ( (lv_models_5_0= ruleModel ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==RULE_ID||LA2_0==22) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalAce.g:139:5: (lv_models_5_0= ruleModel )
            	    	    {
            	    	    // InternalAce.g:139:5: (lv_models_5_0= ruleModel )
            	    	    // InternalAce.g:140:6: lv_models_5_0= ruleModel
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getModelsModelParserRuleCall_3_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_7);
            	    	    lv_models_5_0=ruleModel();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"models",
            	    	    							lv_models_5_0,
            	    	    							"com.anfelisa.Ace.Model");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);

            	    otherlv_6=(Token)match(input,16,FOLLOW_5); 

            	    				newLeafNode(otherlv_6, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_3_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalAce.g:162:3: (otherlv_7= 'data' otherlv_8= '{' ( (lv_data_9_0= ruleData ) )* otherlv_10= '}' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalAce.g:163:4: otherlv_7= 'data' otherlv_8= '{' ( (lv_data_9_0= ruleData ) )* otherlv_10= '}'
            	    {
            	    otherlv_7=(Token)match(input,17,FOLLOW_6); 

            	    				newLeafNode(otherlv_7, grammarAccess.getProjectAccess().getDataKeyword_4_0());
            	    			
            	    otherlv_8=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_8, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_4_1());
            	    			
            	    // InternalAce.g:171:4: ( (lv_data_9_0= ruleData ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==RULE_ID) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalAce.g:172:5: (lv_data_9_0= ruleData )
            	    	    {
            	    	    // InternalAce.g:172:5: (lv_data_9_0= ruleData )
            	    	    // InternalAce.g:173:6: lv_data_9_0= ruleData
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getDataDataParserRuleCall_4_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_data_9_0=ruleData();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"data",
            	    	    							lv_data_9_0,
            	    	    							"com.anfelisa.Ace.Data");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);

            	    otherlv_10=(Token)match(input,16,FOLLOW_9); 

            	    				newLeafNode(otherlv_10, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_4_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalAce.g:195:3: (otherlv_11= 'actions' otherlv_12= '{' ( (lv_actions_13_0= ruleAction ) )* otherlv_14= '}' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalAce.g:196:4: otherlv_11= 'actions' otherlv_12= '{' ( (lv_actions_13_0= ruleAction ) )* otherlv_14= '}'
            	    {
            	    otherlv_11=(Token)match(input,18,FOLLOW_6); 

            	    				newLeafNode(otherlv_11, grammarAccess.getProjectAccess().getActionsKeyword_5_0());
            	    			
            	    otherlv_12=(Token)match(input,15,FOLLOW_10); 

            	    				newLeafNode(otherlv_12, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_5_1());
            	    			
            	    // InternalAce.g:204:4: ( (lv_actions_13_0= ruleAction ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==RULE_ID||(LA6_0>=34 && LA6_0<=37)) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalAce.g:205:5: (lv_actions_13_0= ruleAction )
            	    	    {
            	    	    // InternalAce.g:205:5: (lv_actions_13_0= ruleAction )
            	    	    // InternalAce.g:206:6: lv_actions_13_0= ruleAction
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getActionsActionParserRuleCall_5_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_10);
            	    	    lv_actions_13_0=ruleAction();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"actions",
            	    	    							lv_actions_13_0,
            	    	    							"com.anfelisa.Ace.Action");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    otherlv_14=(Token)match(input,16,FOLLOW_11); 

            	    				newLeafNode(otherlv_14, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_5_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalAce.g:228:3: (otherlv_15= 'commands' otherlv_16= '{' ( (lv_commands_17_0= ruleCommand ) )* otherlv_18= '}' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalAce.g:229:4: otherlv_15= 'commands' otherlv_16= '{' ( (lv_commands_17_0= ruleCommand ) )* otherlv_18= '}'
            	    {
            	    otherlv_15=(Token)match(input,19,FOLLOW_6); 

            	    				newLeafNode(otherlv_15, grammarAccess.getProjectAccess().getCommandsKeyword_6_0());
            	    			
            	    otherlv_16=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_16, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_6_1());
            	    			
            	    // InternalAce.g:237:4: ( (lv_commands_17_0= ruleCommand ) )*
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==RULE_ID) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // InternalAce.g:238:5: (lv_commands_17_0= ruleCommand )
            	    	    {
            	    	    // InternalAce.g:238:5: (lv_commands_17_0= ruleCommand )
            	    	    // InternalAce.g:239:6: lv_commands_17_0= ruleCommand
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getCommandsCommandParserRuleCall_6_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_commands_17_0=ruleCommand();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"commands",
            	    	    							lv_commands_17_0,
            	    	    							"com.anfelisa.Ace.Command");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);

            	    otherlv_18=(Token)match(input,16,FOLLOW_12); 

            	    				newLeafNode(otherlv_18, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_6_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalAce.g:261:3: (otherlv_19= 'events' otherlv_20= '{' ( (lv_events_21_0= ruleEvent ) )* otherlv_22= '}' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalAce.g:262:4: otherlv_19= 'events' otherlv_20= '{' ( (lv_events_21_0= ruleEvent ) )* otherlv_22= '}'
            	    {
            	    otherlv_19=(Token)match(input,20,FOLLOW_6); 

            	    				newLeafNode(otherlv_19, grammarAccess.getProjectAccess().getEventsKeyword_7_0());
            	    			
            	    otherlv_20=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_20, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_7_1());
            	    			
            	    // InternalAce.g:270:4: ( (lv_events_21_0= ruleEvent ) )*
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==RULE_ID) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalAce.g:271:5: (lv_events_21_0= ruleEvent )
            	    	    {
            	    	    // InternalAce.g:271:5: (lv_events_21_0= ruleEvent )
            	    	    // InternalAce.g:272:6: lv_events_21_0= ruleEvent
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getEventsEventParserRuleCall_7_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_events_21_0=ruleEvent();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"events",
            	    	    							lv_events_21_0,
            	    	    							"com.anfelisa.Ace.Event");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop10;
            	        }
            	    } while (true);

            	    otherlv_22=(Token)match(input,16,FOLLOW_13); 

            	    				newLeafNode(otherlv_22, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_7_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalAce.g:294:3: (otherlv_23= 'views' otherlv_24= '{' ( (lv_views_25_0= ruleView ) )* otherlv_26= '}' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==21) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalAce.g:295:4: otherlv_23= 'views' otherlv_24= '{' ( (lv_views_25_0= ruleView ) )* otherlv_26= '}'
            	    {
            	    otherlv_23=(Token)match(input,21,FOLLOW_6); 

            	    				newLeafNode(otherlv_23, grammarAccess.getProjectAccess().getViewsKeyword_8_0());
            	    			
            	    otherlv_24=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_24, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_8_1());
            	    			
            	    // InternalAce.g:303:4: ( (lv_views_25_0= ruleView ) )*
            	    loop12:
            	    do {
            	        int alt12=2;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==RULE_ID) ) {
            	            alt12=1;
            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // InternalAce.g:304:5: (lv_views_25_0= ruleView )
            	    	    {
            	    	    // InternalAce.g:304:5: (lv_views_25_0= ruleView )
            	    	    // InternalAce.g:305:6: lv_views_25_0= ruleView
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getViewsViewParserRuleCall_8_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_views_25_0=ruleView();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"views",
            	    	    							lv_views_25_0,
            	    	    							"com.anfelisa.Ace.View");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop12;
            	        }
            	    } while (true);

            	    otherlv_26=(Token)match(input,16,FOLLOW_14); 

            	    				newLeafNode(otherlv_26, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_8_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleModel"
    // InternalAce.g:331:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalAce.g:331:46: (iv_ruleModel= ruleModel EOF )
            // InternalAce.g:332:2: iv_ruleModel= ruleModel EOF
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
    // InternalAce.g:338:1: ruleModel returns [EObject current=null] : ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ')' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_persistent_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_attributes_3_0 = null;



        	enterRule();

        try {
            // InternalAce.g:344:2: ( ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ')' ) )
            // InternalAce.g:345:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ')' )
            {
            // InternalAce.g:345:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ')' )
            // InternalAce.g:346:3: ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ')'
            {
            // InternalAce.g:346:3: ( (lv_persistent_0_0= 'persistent' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalAce.g:347:4: (lv_persistent_0_0= 'persistent' )
                    {
                    // InternalAce.g:347:4: (lv_persistent_0_0= 'persistent' )
                    // InternalAce.g:348:5: lv_persistent_0_0= 'persistent'
                    {
                    lv_persistent_0_0=(Token)match(input,22,FOLLOW_15); 

                    					newLeafNode(lv_persistent_0_0, grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(current, "persistent", true, "persistent");
                    				

                    }


                    }
                    break;

            }

            // InternalAce.g:360:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAce.g:361:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAce.g:361:4: (lv_name_1_0= RULE_ID )
            // InternalAce.g:362:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

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

            otherlv_2=(Token)match(input,23,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getModelAccess().getLeftParenthesisKeyword_2());
            		
            // InternalAce.g:382:3: ( (lv_attributes_3_0= ruleAttribute ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==26||(LA15_0>=38 && LA15_0<=45)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalAce.g:383:4: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // InternalAce.g:383:4: (lv_attributes_3_0= ruleAttribute )
            	    // InternalAce.g:384:5: lv_attributes_3_0= ruleAttribute
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getAttributesAttributeParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"attributes",
            	    						lv_attributes_3_0,
            	    						"com.anfelisa.Ace.Attribute");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_4=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getModelAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleData"
    // InternalAce.g:409:1: entryRuleData returns [EObject current=null] : iv_ruleData= ruleData EOF ;
    public final EObject entryRuleData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleData = null;


        try {
            // InternalAce.g:409:45: (iv_ruleData= ruleData EOF )
            // InternalAce.g:410:2: iv_ruleData= ruleData EOF
            {
             newCompositeNode(grammarAccess.getDataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleData=ruleData();

            state._fsp--;

             current =iv_ruleData; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleData"


    // $ANTLR start "ruleData"
    // InternalAce.g:416:1: ruleData returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' ) ;
    public final EObject ruleData() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAce.g:422:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' ) )
            // InternalAce.g:423:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )
            {
            // InternalAce.g:423:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )
            // InternalAce.g:424:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')'
            {
            // InternalAce.g:424:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:425:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:425:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:426:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(lv_name_0_0, grammarAccess.getDataAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getDataAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,23,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getDataAccess().getLeftParenthesisKeyword_2());
            		
            // InternalAce.g:450:3: ( ( ruleQualifiedName ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalAce.g:451:4: ( ruleQualifiedName )
            	    {
            	    // InternalAce.g:451:4: ( ruleQualifiedName )
            	    // InternalAce.g:452:5: ruleQualifiedName
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getDataRule());
            	    					}
            	    				

            	    					newCompositeNode(grammarAccess.getDataAccess().getModelsModelCrossReference_3_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    ruleQualifiedName();

            	    state._fsp--;


            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_4=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getDataAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleData"


    // $ANTLR start "entryRuleAttribute"
    // InternalAce.g:474:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalAce.g:474:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalAce.g:475:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalAce.g:481:1: ruleAttribute returns [EObject current=null] : ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_constraint_1_0= ruleConstraint ) )? ( (lv_type_2_0= ruleModelType ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_unique_0_0=null;
        Token lv_name_3_0=null;
        AntlrDatatypeRuleToken lv_constraint_1_0 = null;

        AntlrDatatypeRuleToken lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalAce.g:487:2: ( ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_constraint_1_0= ruleConstraint ) )? ( (lv_type_2_0= ruleModelType ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalAce.g:488:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_constraint_1_0= ruleConstraint ) )? ( (lv_type_2_0= ruleModelType ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalAce.g:488:2: ( ( (lv_unique_0_0= 'Unique' ) )? ( (lv_constraint_1_0= ruleConstraint ) )? ( (lv_type_2_0= ruleModelType ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalAce.g:489:3: ( (lv_unique_0_0= 'Unique' ) )? ( (lv_constraint_1_0= ruleConstraint ) )? ( (lv_type_2_0= ruleModelType ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            // InternalAce.g:489:3: ( (lv_unique_0_0= 'Unique' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAce.g:490:4: (lv_unique_0_0= 'Unique' )
                    {
                    // InternalAce.g:490:4: (lv_unique_0_0= 'Unique' )
                    // InternalAce.g:491:5: lv_unique_0_0= 'Unique'
                    {
                    lv_unique_0_0=(Token)match(input,26,FOLLOW_20); 

                    					newLeafNode(lv_unique_0_0, grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "unique", true, "Unique");
                    				

                    }


                    }
                    break;

            }

            // InternalAce.g:503:3: ( (lv_constraint_1_0= ruleConstraint ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=44 && LA18_0<=45)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAce.g:504:4: (lv_constraint_1_0= ruleConstraint )
                    {
                    // InternalAce.g:504:4: (lv_constraint_1_0= ruleConstraint )
                    // InternalAce.g:505:5: lv_constraint_1_0= ruleConstraint
                    {

                    					newCompositeNode(grammarAccess.getAttributeAccess().getConstraintConstraintParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_20);
                    lv_constraint_1_0=ruleConstraint();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getAttributeRule());
                    					}
                    					set(
                    						current,
                    						"constraint",
                    						lv_constraint_1_0,
                    						"com.anfelisa.Ace.Constraint");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAce.g:522:3: ( (lv_type_2_0= ruleModelType ) )
            // InternalAce.g:523:4: (lv_type_2_0= ruleModelType )
            {
            // InternalAce.g:523:4: (lv_type_2_0= ruleModelType )
            // InternalAce.g:524:5: lv_type_2_0= ruleModelType
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getTypeModelTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_15);
            lv_type_2_0=ruleModelType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"com.anfelisa.Ace.ModelType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalAce.g:541:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalAce.g:542:4: (lv_name_3_0= RULE_ID )
            {
            // InternalAce.g:542:4: (lv_name_3_0= RULE_ID )
            // InternalAce.g:543:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_3_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleAction"
    // InternalAce.g:563:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalAce.g:563:47: (iv_ruleAction= ruleAction EOF )
            // InternalAce.g:564:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalAce.g:570:1: ruleAction returns [EObject current=null] : ( ( (lv_type_0_0= ruleFunctionType ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'uses' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'executes' ( ( ruleQualifiedName ) ) )? ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalAce.g:576:2: ( ( ( (lv_type_0_0= ruleFunctionType ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'uses' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'executes' ( ( ruleQualifiedName ) ) )? ) )
            // InternalAce.g:577:2: ( ( (lv_type_0_0= ruleFunctionType ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'uses' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'executes' ( ( ruleQualifiedName ) ) )? )
            {
            // InternalAce.g:577:2: ( ( (lv_type_0_0= ruleFunctionType ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'uses' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'executes' ( ( ruleQualifiedName ) ) )? )
            // InternalAce.g:578:3: ( (lv_type_0_0= ruleFunctionType ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'uses' ( ( ruleQualifiedName ) ) )? (otherlv_4= 'executes' ( ( ruleQualifiedName ) ) )?
            {
            // InternalAce.g:578:3: ( (lv_type_0_0= ruleFunctionType ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=34 && LA19_0<=37)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAce.g:579:4: (lv_type_0_0= ruleFunctionType )
                    {
                    // InternalAce.g:579:4: (lv_type_0_0= ruleFunctionType )
                    // InternalAce.g:580:5: lv_type_0_0= ruleFunctionType
                    {

                    					newCompositeNode(grammarAccess.getActionAccess().getTypeFunctionTypeParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_15);
                    lv_type_0_0=ruleFunctionType();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getActionRule());
                    					}
                    					set(
                    						current,
                    						"type",
                    						lv_type_0_0,
                    						"com.anfelisa.Ace.FunctionType");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalAce.g:597:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAce.g:598:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAce.g:598:4: (lv_name_1_0= RULE_ID )
            // InternalAce.g:599:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAce.g:615:3: (otherlv_2= 'uses' ( ( ruleQualifiedName ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalAce.g:616:4: otherlv_2= 'uses' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_15); 

                    				newLeafNode(otherlv_2, grammarAccess.getActionAccess().getUsesKeyword_2_0());
                    			
                    // InternalAce.g:620:4: ( ( ruleQualifiedName ) )
                    // InternalAce.g:621:5: ( ruleQualifiedName )
                    {
                    // InternalAce.g:621:5: ( ruleQualifiedName )
                    // InternalAce.g:622:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getActionAccess().getDataDataCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalAce.g:637:3: (otherlv_4= 'executes' ( ( ruleQualifiedName ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalAce.g:638:4: otherlv_4= 'executes' ( ( ruleQualifiedName ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_15); 

                    				newLeafNode(otherlv_4, grammarAccess.getActionAccess().getExecutesKeyword_3_0());
                    			
                    // InternalAce.g:642:4: ( ( ruleQualifiedName ) )
                    // InternalAce.g:643:5: ( ruleQualifiedName )
                    {
                    // InternalAce.g:643:5: ( ruleQualifiedName )
                    // InternalAce.g:644:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getActionAccess().getCommandCommandCrossReference_3_1_0());
                    					
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
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleCommand"
    // InternalAce.g:663:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // InternalAce.g:663:48: (iv_ruleCommand= ruleCommand EOF )
            // InternalAce.g:664:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // InternalAce.g:670:1: ruleCommand returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_eventsOnOutcome_2_0 = null;



        	enterRule();

        try {
            // InternalAce.g:676:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* ) )
            // InternalAce.g:677:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* )
            {
            // InternalAce.g:677:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* )
            // InternalAce.g:678:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )*
            {
            // InternalAce.g:678:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:679:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:679:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:680:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(lv_name_0_0, grammarAccess.getCommandAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCommandRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAce.g:696:3: (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==15) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalAce.g:697:4: otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}'
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_24); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCommandAccess().getLeftCurlyBracketKeyword_1_0());
            	    			
            	    // InternalAce.g:701:4: ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )*
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==29) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // InternalAce.g:702:5: (lv_eventsOnOutcome_2_0= ruleEventOnOutcome )
            	    	    {
            	    	    // InternalAce.g:702:5: (lv_eventsOnOutcome_2_0= ruleEventOnOutcome )
            	    	    // InternalAce.g:703:6: lv_eventsOnOutcome_2_0= ruleEventOnOutcome
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getCommandAccess().getEventsOnOutcomeEventOnOutcomeParserRuleCall_1_1_0());
            	    	    					
            	    	    pushFollow(FOLLOW_24);
            	    	    lv_eventsOnOutcome_2_0=ruleEventOnOutcome();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getCommandRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"eventsOnOutcome",
            	    	    							lv_eventsOnOutcome_2_0,
            	    	    							"com.anfelisa.Ace.EventOnOutcome");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop22;
            	        }
            	    } while (true);

            	    otherlv_3=(Token)match(input,16,FOLLOW_23); 

            	    				newLeafNode(otherlv_3, grammarAccess.getCommandAccess().getRightCurlyBracketKeyword_1_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleEventOnOutcome"
    // InternalAce.g:729:1: entryRuleEventOnOutcome returns [EObject current=null] : iv_ruleEventOnOutcome= ruleEventOnOutcome EOF ;
    public final EObject entryRuleEventOnOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventOnOutcome = null;


        try {
            // InternalAce.g:729:55: (iv_ruleEventOnOutcome= ruleEventOnOutcome EOF )
            // InternalAce.g:730:2: iv_ruleEventOnOutcome= ruleEventOnOutcome EOF
            {
             newCompositeNode(grammarAccess.getEventOnOutcomeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEventOnOutcome=ruleEventOnOutcome();

            state._fsp--;

             current =iv_ruleEventOnOutcome; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventOnOutcome"


    // $ANTLR start "ruleEventOnOutcome"
    // InternalAce.g:736:1: ruleEventOnOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )? ) ;
    public final EObject ruleEventOnOutcome() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_outcome_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;


        	enterRule();

        try {
            // InternalAce.g:742:2: ( (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )? ) )
            // InternalAce.g:743:2: (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )? )
            {
            // InternalAce.g:743:2: (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )? )
            // InternalAce.g:744:3: otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getEventOnOutcomeAccess().getOnKeyword_0());
            		
            // InternalAce.g:748:3: ( (lv_outcome_1_0= RULE_ID ) )
            // InternalAce.g:749:4: (lv_outcome_1_0= RULE_ID )
            {
            // InternalAce.g:749:4: (lv_outcome_1_0= RULE_ID )
            // InternalAce.g:750:5: lv_outcome_1_0= RULE_ID
            {
            lv_outcome_1_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(lv_outcome_1_0, grammarAccess.getEventOnOutcomeAccess().getOutcomeIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEventOnOutcomeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"outcome",
            						lv_outcome_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAce.g:766:3: (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==30) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalAce.g:767:4: otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')'
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_16); 

                    				newLeafNode(otherlv_2, grammarAccess.getEventOnOutcomeAccess().getPublishesKeyword_2_0());
                    			
                    otherlv_3=(Token)match(input,23,FOLLOW_19); 

                    				newLeafNode(otherlv_3, grammarAccess.getEventOnOutcomeAccess().getLeftParenthesisKeyword_2_1());
                    			
                    // InternalAce.g:775:4: ( ( ruleQualifiedName ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_ID) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalAce.g:776:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAce.g:776:5: ( ruleQualifiedName )
                    	    // InternalAce.g:777:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getEventOnOutcomeRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getEventOnOutcomeAccess().getEventsEventCrossReference_2_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,24,FOLLOW_26); 

                    				newLeafNode(otherlv_5, grammarAccess.getEventOnOutcomeAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalAce.g:796:3: (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==31) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalAce.g:797:4: otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')'
                    {
                    otherlv_6=(Token)match(input,31,FOLLOW_16); 

                    				newLeafNode(otherlv_6, grammarAccess.getEventOnOutcomeAccess().getTriggersKeyword_3_0());
                    			
                    otherlv_7=(Token)match(input,23,FOLLOW_19); 

                    				newLeafNode(otherlv_7, grammarAccess.getEventOnOutcomeAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalAce.g:805:4: ( ( ruleQualifiedName ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_ID) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalAce.g:806:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAce.g:806:5: ( ruleQualifiedName )
                    	    // InternalAce.g:807:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getEventOnOutcomeRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getEventOnOutcomeAccess().getActionsActionCrossReference_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,24,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getEventOnOutcomeAccess().getRightParenthesisKeyword_3_3());
                    			

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
    // $ANTLR end "ruleEventOnOutcome"


    // $ANTLR start "entryRuleEvent"
    // InternalAce.g:830:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalAce.g:830:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalAce.g:831:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalAce.g:837:1: ruleEvent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAce.g:843:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? ) )
            // InternalAce.g:844:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? )
            {
            // InternalAce.g:844:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? )
            // InternalAce.g:845:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )?
            {
            // InternalAce.g:845:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:846:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:846:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:847:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEventAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAce.g:863:3: (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==32) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalAce.g:864:4: otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_16); 

                    				newLeafNode(otherlv_1, grammarAccess.getEventAccess().getListenedToByKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,23,FOLLOW_19); 

                    				newLeafNode(otherlv_2, grammarAccess.getEventAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalAce.g:872:4: ( ( ruleQualifiedName ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==RULE_ID) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalAce.g:873:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAce.g:873:5: ( ruleQualifiedName )
                    	    // InternalAce.g:874:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getEventRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getEventAccess().getListenersViewFunctionCrossReference_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_19);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,24,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getEventAccess().getRightParenthesisKeyword_1_3());
                    			

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
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleView"
    // InternalAce.g:897:1: entryRuleView returns [EObject current=null] : iv_ruleView= ruleView EOF ;
    public final EObject entryRuleView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleView = null;


        try {
            // InternalAce.g:897:45: (iv_ruleView= ruleView EOF )
            // InternalAce.g:898:2: iv_ruleView= ruleView EOF
            {
             newCompositeNode(grammarAccess.getViewRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleView=ruleView();

            state._fsp--;

             current =iv_ruleView; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleView"


    // $ANTLR start "ruleView"
    // InternalAce.g:904:1: ruleView returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )* ) ;
    public final EObject ruleView() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_renderFunctions_2_0 = null;



        	enterRule();

        try {
            // InternalAce.g:910:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )* ) )
            // InternalAce.g:911:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )* )
            {
            // InternalAce.g:911:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )* )
            // InternalAce.g:912:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )*
            {
            // InternalAce.g:912:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:913:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:913:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:914:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(lv_name_0_0, grammarAccess.getViewAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getViewRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAce.g:930:3: (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==15) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalAce.g:931:4: otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}'
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getViewAccess().getLeftCurlyBracketKeyword_1_0());
            	    			
            	    // InternalAce.g:935:4: ( (lv_renderFunctions_2_0= ruleViewFunction ) )*
            	    loop30:
            	    do {
            	        int alt30=2;
            	        int LA30_0 = input.LA(1);

            	        if ( (LA30_0==RULE_ID) ) {
            	            alt30=1;
            	        }


            	        switch (alt30) {
            	    	case 1 :
            	    	    // InternalAce.g:936:5: (lv_renderFunctions_2_0= ruleViewFunction )
            	    	    {
            	    	    // InternalAce.g:936:5: (lv_renderFunctions_2_0= ruleViewFunction )
            	    	    // InternalAce.g:937:6: lv_renderFunctions_2_0= ruleViewFunction
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getViewAccess().getRenderFunctionsViewFunctionParserRuleCall_1_1_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_renderFunctions_2_0=ruleViewFunction();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getViewRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"renderFunctions",
            	    	    							lv_renderFunctions_2_0,
            	    	    							"com.anfelisa.Ace.ViewFunction");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop30;
            	        }
            	    } while (true);

            	    otherlv_3=(Token)match(input,16,FOLLOW_23); 

            	    				newLeafNode(otherlv_3, grammarAccess.getViewAccess().getRightCurlyBracketKeyword_1_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // $ANTLR end "ruleView"


    // $ANTLR start "entryRuleViewFunction"
    // InternalAce.g:963:1: entryRuleViewFunction returns [EObject current=null] : iv_ruleViewFunction= ruleViewFunction EOF ;
    public final EObject entryRuleViewFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleViewFunction = null;


        try {
            // InternalAce.g:963:53: (iv_ruleViewFunction= ruleViewFunction EOF )
            // InternalAce.g:964:2: iv_ruleViewFunction= ruleViewFunction EOF
            {
             newCompositeNode(grammarAccess.getViewFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleViewFunction=ruleViewFunction();

            state._fsp--;

             current =iv_ruleViewFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleViewFunction"


    // $ANTLR start "ruleViewFunction"
    // InternalAce.g:970:1: ruleViewFunction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleViewFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalAce.g:976:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? ) )
            // InternalAce.g:977:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? )
            {
            // InternalAce.g:977:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )? )
            // InternalAce.g:978:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )?
            {
            // InternalAce.g:978:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:979:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:979:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:980:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_name_0_0, grammarAccess.getViewFunctionAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getViewFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAce.g:996:3: (otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==23) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalAce.g:997:4: otherlv_1= '(' ( ( ruleQualifiedName ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_15); 

                    				newLeafNode(otherlv_1, grammarAccess.getViewFunctionAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalAce.g:1001:4: ( ( ruleQualifiedName ) )
                    // InternalAce.g:1002:5: ( ruleQualifiedName )
                    {
                    // InternalAce.g:1002:5: ( ruleQualifiedName )
                    // InternalAce.g:1003:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getViewFunctionRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getViewFunctionAccess().getModelModelCrossReference_1_1_0());
                    					
                    pushFollow(FOLLOW_29);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,24,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getViewFunctionAccess().getRightParenthesisKeyword_1_2());
                    			

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
    // $ANTLR end "ruleViewFunction"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalAce.g:1026:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalAce.g:1026:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalAce.g:1027:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalAce.g:1033:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalAce.g:1039:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalAce.g:1040:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalAce.g:1040:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalAce.g:1041:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalAce.g:1048:3: (kw= '.' this_ID_2= RULE_ID )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==33) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalAce.g:1049:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,33,FOLLOW_15); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_30); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop33;
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


    // $ANTLR start "entryRuleFunctionType"
    // InternalAce.g:1066:1: entryRuleFunctionType returns [String current=null] : iv_ruleFunctionType= ruleFunctionType EOF ;
    public final String entryRuleFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFunctionType = null;


        try {
            // InternalAce.g:1066:52: (iv_ruleFunctionType= ruleFunctionType EOF )
            // InternalAce.g:1067:2: iv_ruleFunctionType= ruleFunctionType EOF
            {
             newCompositeNode(grammarAccess.getFunctionTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionType=ruleFunctionType();

            state._fsp--;

             current =iv_ruleFunctionType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionType"


    // $ANTLR start "ruleFunctionType"
    // InternalAce.g:1073:1: ruleFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' | kw= 'GET' ) ;
    public final AntlrDatatypeRuleToken ruleFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAce.g:1079:2: ( (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' | kw= 'GET' ) )
            // InternalAce.g:1080:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' | kw= 'GET' )
            {
            // InternalAce.g:1080:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' | kw= 'GET' )
            int alt34=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt34=1;
                }
                break;
            case 35:
                {
                alt34=2;
                }
                break;
            case 36:
                {
                alt34=3;
                }
                break;
            case 37:
                {
                alt34=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalAce.g:1081:3: kw= 'POST'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionTypeAccess().getPOSTKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAce.g:1087:3: kw= 'PUT'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionTypeAccess().getPUTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAce.g:1093:3: kw= 'DELETE'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionTypeAccess().getDELETEKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAce.g:1099:3: kw= 'GET'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionTypeAccess().getGETKeyword_3());
                    		

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
    // $ANTLR end "ruleFunctionType"


    // $ANTLR start "entryRuleModelType"
    // InternalAce.g:1108:1: entryRuleModelType returns [String current=null] : iv_ruleModelType= ruleModelType EOF ;
    public final String entryRuleModelType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModelType = null;


        try {
            // InternalAce.g:1108:49: (iv_ruleModelType= ruleModelType EOF )
            // InternalAce.g:1109:2: iv_ruleModelType= ruleModelType EOF
            {
             newCompositeNode(grammarAccess.getModelTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModelType=ruleModelType();

            state._fsp--;

             current =iv_ruleModelType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelType"


    // $ANTLR start "ruleModelType"
    // InternalAce.g:1115:1: ruleModelType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Serial' | kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' ) ;
    public final AntlrDatatypeRuleToken ruleModelType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAce.g:1121:2: ( (kw= 'Serial' | kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' ) )
            // InternalAce.g:1122:2: (kw= 'Serial' | kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' )
            {
            // InternalAce.g:1122:2: (kw= 'Serial' | kw= 'Integer' | kw= 'String' | kw= 'Float' | kw= 'Boolean' | kw= 'DateTime' )
            int alt35=6;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt35=1;
                }
                break;
            case 39:
                {
                alt35=2;
                }
                break;
            case 40:
                {
                alt35=3;
                }
                break;
            case 41:
                {
                alt35=4;
                }
                break;
            case 42:
                {
                alt35=5;
                }
                break;
            case 43:
                {
                alt35=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalAce.g:1123:3: kw= 'Serial'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getModelTypeAccess().getSerialKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAce.g:1129:3: kw= 'Integer'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getModelTypeAccess().getIntegerKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAce.g:1135:3: kw= 'String'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getModelTypeAccess().getStringKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAce.g:1141:3: kw= 'Float'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getModelTypeAccess().getFloatKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalAce.g:1147:3: kw= 'Boolean'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getModelTypeAccess().getBooleanKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalAce.g:1153:3: kw= 'DateTime'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getModelTypeAccess().getDateTimeKeyword_5());
                    		

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
    // $ANTLR end "ruleModelType"


    // $ANTLR start "entryRuleConstraint"
    // InternalAce.g:1162:1: entryRuleConstraint returns [String current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final String entryRuleConstraint() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConstraint = null;


        try {
            // InternalAce.g:1162:50: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalAce.g:1163:2: iv_ruleConstraint= ruleConstraint EOF
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
    // InternalAce.g:1169:1: ruleConstraint returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'NotEmpty' | kw= 'NotNull' ) ;
    public final AntlrDatatypeRuleToken ruleConstraint() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAce.g:1175:2: ( (kw= 'NotEmpty' | kw= 'NotNull' ) )
            // InternalAce.g:1176:2: (kw= 'NotEmpty' | kw= 'NotNull' )
            {
            // InternalAce.g:1176:2: (kw= 'NotEmpty' | kw= 'NotNull' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==44) ) {
                alt36=1;
            }
            else if ( (LA36_0==45) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalAce.g:1177:3: kw= 'NotEmpty'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConstraintAccess().getNotEmptyKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAce.g:1183:3: kw= 'NotNull'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

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


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000003E4002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000410010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000003E0002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000003C00010010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000003C0002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00003FC005000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00003FC004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020010000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000200000002L});

}