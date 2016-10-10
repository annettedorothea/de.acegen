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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'target'", "'ES6'", "'JAVA'", "'actions'", "'{'", "'}'", "'commands'", "'events'", "'views'", "'executes'", "'on'", "'publishes'", "'('", "')'", "'triggers'", "'listenedToBy'", "'.'", "'POST'", "'PUT'", "'DELETE'", "'GET'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
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
    // InternalAce.g:71:1: ruleProject returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= 'target' ( ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) ) ) (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleAction ) )* otherlv_6= '}' )* (otherlv_7= 'commands' otherlv_8= '{' ( (lv_commands_9_0= ruleCommand ) )* otherlv_10= '}' )* (otherlv_11= 'events' otherlv_12= '{' ( (lv_events_13_0= ruleEvent ) )* otherlv_14= '}' )* (otherlv_15= 'views' otherlv_16= '{' ( (lv_views_17_0= ruleView ) )* otherlv_18= '}' )* ) ;
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
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_actions_5_0 = null;

        EObject lv_commands_9_0 = null;

        EObject lv_events_13_0 = null;

        EObject lv_views_17_0 = null;



        	enterRule();

        try {
            // InternalAce.g:77:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= 'target' ( ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) ) ) (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleAction ) )* otherlv_6= '}' )* (otherlv_7= 'commands' otherlv_8= '{' ( (lv_commands_9_0= ruleCommand ) )* otherlv_10= '}' )* (otherlv_11= 'events' otherlv_12= '{' ( (lv_events_13_0= ruleEvent ) )* otherlv_14= '}' )* (otherlv_15= 'views' otherlv_16= '{' ( (lv_views_17_0= ruleView ) )* otherlv_18= '}' )* ) )
            // InternalAce.g:78:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= 'target' ( ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) ) ) (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleAction ) )* otherlv_6= '}' )* (otherlv_7= 'commands' otherlv_8= '{' ( (lv_commands_9_0= ruleCommand ) )* otherlv_10= '}' )* (otherlv_11= 'events' otherlv_12= '{' ( (lv_events_13_0= ruleEvent ) )* otherlv_14= '}' )* (otherlv_15= 'views' otherlv_16= '{' ( (lv_views_17_0= ruleView ) )* otherlv_18= '}' )* )
            {
            // InternalAce.g:78:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= 'target' ( ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) ) ) (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleAction ) )* otherlv_6= '}' )* (otherlv_7= 'commands' otherlv_8= '{' ( (lv_commands_9_0= ruleCommand ) )* otherlv_10= '}' )* (otherlv_11= 'events' otherlv_12= '{' ( (lv_events_13_0= ruleEvent ) )* otherlv_14= '}' )* (otherlv_15= 'views' otherlv_16= '{' ( (lv_views_17_0= ruleView ) )* otherlv_18= '}' )* )
            // InternalAce.g:79:3: ( (lv_name_0_0= ruleQualifiedName ) ) otherlv_1= 'target' ( ( (lv_target_2_1= 'ES6' | lv_target_2_2= 'JAVA' ) ) ) (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleAction ) )* otherlv_6= '}' )* (otherlv_7= 'commands' otherlv_8= '{' ( (lv_commands_9_0= ruleCommand ) )* otherlv_10= '}' )* (otherlv_11= 'events' otherlv_12= '{' ( (lv_events_13_0= ruleEvent ) )* otherlv_14= '}' )* (otherlv_15= 'views' otherlv_16= '{' ( (lv_views_17_0= ruleView ) )* otherlv_18= '}' )*
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

            // InternalAce.g:129:3: (otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleAction ) )* otherlv_6= '}' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAce.g:130:4: otherlv_3= 'actions' otherlv_4= '{' ( (lv_actions_5_0= ruleAction ) )* otherlv_6= '}'
            	    {
            	    otherlv_3=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_3, grammarAccess.getProjectAccess().getActionsKeyword_3_0());
            	    			
            	    otherlv_4=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_4, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_3_1());
            	    			
            	    // InternalAce.g:138:4: ( (lv_actions_5_0= ruleAction ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==RULE_ID||(LA2_0>=28 && LA2_0<=31)) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalAce.g:139:5: (lv_actions_5_0= ruleAction )
            	    	    {
            	    	    // InternalAce.g:139:5: (lv_actions_5_0= ruleAction )
            	    	    // InternalAce.g:140:6: lv_actions_5_0= ruleAction
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getActionsActionParserRuleCall_3_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_7);
            	    	    lv_actions_5_0=ruleAction();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"actions",
            	    	    							lv_actions_5_0,
            	    	    							"com.anfelisa.Ace.Action");
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

            // InternalAce.g:162:3: (otherlv_7= 'commands' otherlv_8= '{' ( (lv_commands_9_0= ruleCommand ) )* otherlv_10= '}' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalAce.g:163:4: otherlv_7= 'commands' otherlv_8= '{' ( (lv_commands_9_0= ruleCommand ) )* otherlv_10= '}'
            	    {
            	    otherlv_7=(Token)match(input,17,FOLLOW_6); 

            	    				newLeafNode(otherlv_7, grammarAccess.getProjectAccess().getCommandsKeyword_4_0());
            	    			
            	    otherlv_8=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_8, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_4_1());
            	    			
            	    // InternalAce.g:171:4: ( (lv_commands_9_0= ruleCommand ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==RULE_ID) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalAce.g:172:5: (lv_commands_9_0= ruleCommand )
            	    	    {
            	    	    // InternalAce.g:172:5: (lv_commands_9_0= ruleCommand )
            	    	    // InternalAce.g:173:6: lv_commands_9_0= ruleCommand
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getCommandsCommandParserRuleCall_4_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_commands_9_0=ruleCommand();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"commands",
            	    	    							lv_commands_9_0,
            	    	    							"com.anfelisa.Ace.Command");
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

            // InternalAce.g:195:3: (otherlv_11= 'events' otherlv_12= '{' ( (lv_events_13_0= ruleEvent ) )* otherlv_14= '}' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalAce.g:196:4: otherlv_11= 'events' otherlv_12= '{' ( (lv_events_13_0= ruleEvent ) )* otherlv_14= '}'
            	    {
            	    otherlv_11=(Token)match(input,18,FOLLOW_6); 

            	    				newLeafNode(otherlv_11, grammarAccess.getProjectAccess().getEventsKeyword_5_0());
            	    			
            	    otherlv_12=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_12, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_5_1());
            	    			
            	    // InternalAce.g:204:4: ( (lv_events_13_0= ruleEvent ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==RULE_ID) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalAce.g:205:5: (lv_events_13_0= ruleEvent )
            	    	    {
            	    	    // InternalAce.g:205:5: (lv_events_13_0= ruleEvent )
            	    	    // InternalAce.g:206:6: lv_events_13_0= ruleEvent
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getEventsEventParserRuleCall_5_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_events_13_0=ruleEvent();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"events",
            	    	    							lv_events_13_0,
            	    	    							"com.anfelisa.Ace.Event");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    otherlv_14=(Token)match(input,16,FOLLOW_10); 

            	    				newLeafNode(otherlv_14, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_5_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalAce.g:228:3: (otherlv_15= 'views' otherlv_16= '{' ( (lv_views_17_0= ruleView ) )* otherlv_18= '}' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalAce.g:229:4: otherlv_15= 'views' otherlv_16= '{' ( (lv_views_17_0= ruleView ) )* otherlv_18= '}'
            	    {
            	    otherlv_15=(Token)match(input,19,FOLLOW_6); 

            	    				newLeafNode(otherlv_15, grammarAccess.getProjectAccess().getViewsKeyword_6_0());
            	    			
            	    otherlv_16=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_16, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_6_1());
            	    			
            	    // InternalAce.g:237:4: ( (lv_views_17_0= ruleView ) )*
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==RULE_ID) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // InternalAce.g:238:5: (lv_views_17_0= ruleView )
            	    	    {
            	    	    // InternalAce.g:238:5: (lv_views_17_0= ruleView )
            	    	    // InternalAce.g:239:6: lv_views_17_0= ruleView
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getViewsViewParserRuleCall_6_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_views_17_0=ruleView();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"views",
            	    	    							lv_views_17_0,
            	    	    							"com.anfelisa.Ace.View");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);

            	    otherlv_18=(Token)match(input,16,FOLLOW_11); 

            	    				newLeafNode(otherlv_18, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_6_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop9;
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


    // $ANTLR start "entryRuleAction"
    // InternalAce.g:265:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalAce.g:265:47: (iv_ruleAction= ruleAction EOF )
            // InternalAce.g:266:2: iv_ruleAction= ruleAction EOF
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
    // InternalAce.g:272:1: ruleAction returns [EObject current=null] : ( ( (lv_type_0_0= ruleFunctionType ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'executes' ( ( ruleQualifiedName ) ) )? ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalAce.g:278:2: ( ( ( (lv_type_0_0= ruleFunctionType ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'executes' ( ( ruleQualifiedName ) ) )? ) )
            // InternalAce.g:279:2: ( ( (lv_type_0_0= ruleFunctionType ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'executes' ( ( ruleQualifiedName ) ) )? )
            {
            // InternalAce.g:279:2: ( ( (lv_type_0_0= ruleFunctionType ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'executes' ( ( ruleQualifiedName ) ) )? )
            // InternalAce.g:280:3: ( (lv_type_0_0= ruleFunctionType ) )? ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'executes' ( ( ruleQualifiedName ) ) )?
            {
            // InternalAce.g:280:3: ( (lv_type_0_0= ruleFunctionType ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=28 && LA10_0<=31)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAce.g:281:4: (lv_type_0_0= ruleFunctionType )
                    {
                    // InternalAce.g:281:4: (lv_type_0_0= ruleFunctionType )
                    // InternalAce.g:282:5: lv_type_0_0= ruleFunctionType
                    {

                    					newCompositeNode(grammarAccess.getActionAccess().getTypeFunctionTypeParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_12);
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

            // InternalAce.g:299:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalAce.g:300:4: (lv_name_1_0= RULE_ID )
            {
            // InternalAce.g:300:4: (lv_name_1_0= RULE_ID )
            // InternalAce.g:301:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); 

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

            // InternalAce.g:317:3: (otherlv_2= 'executes' ( ( ruleQualifiedName ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalAce.g:318:4: otherlv_2= 'executes' ( ( ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,20,FOLLOW_12); 

                    				newLeafNode(otherlv_2, grammarAccess.getActionAccess().getExecutesKeyword_2_0());
                    			
                    // InternalAce.g:322:4: ( ( ruleQualifiedName ) )
                    // InternalAce.g:323:5: ( ruleQualifiedName )
                    {
                    // InternalAce.g:323:5: ( ruleQualifiedName )
                    // InternalAce.g:324:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getActionAccess().getCommandCommandCrossReference_2_1_0());
                    					
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
    // InternalAce.g:343:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // InternalAce.g:343:48: (iv_ruleCommand= ruleCommand EOF )
            // InternalAce.g:344:2: iv_ruleCommand= ruleCommand EOF
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
    // InternalAce.g:350:1: ruleCommand returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_eventsOnOutcome_2_0 = null;



        	enterRule();

        try {
            // InternalAce.g:356:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* ) )
            // InternalAce.g:357:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* )
            {
            // InternalAce.g:357:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* )
            // InternalAce.g:358:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )*
            {
            // InternalAce.g:358:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:359:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:359:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:360:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            // InternalAce.g:376:3: (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==15) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalAce.g:377:4: otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}'
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCommandAccess().getLeftCurlyBracketKeyword_1_0());
            	    			
            	    // InternalAce.g:381:4: ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )*
            	    loop12:
            	    do {
            	        int alt12=2;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==21) ) {
            	            alt12=1;
            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // InternalAce.g:382:5: (lv_eventsOnOutcome_2_0= ruleEventOnOutcome )
            	    	    {
            	    	    // InternalAce.g:382:5: (lv_eventsOnOutcome_2_0= ruleEventOnOutcome )
            	    	    // InternalAce.g:383:6: lv_eventsOnOutcome_2_0= ruleEventOnOutcome
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getCommandAccess().getEventsOnOutcomeEventOnOutcomeParserRuleCall_1_1_0());
            	    	    					
            	    	    pushFollow(FOLLOW_15);
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
            	    	    break loop12;
            	        }
            	    } while (true);

            	    otherlv_3=(Token)match(input,16,FOLLOW_14); 

            	    				newLeafNode(otherlv_3, grammarAccess.getCommandAccess().getRightCurlyBracketKeyword_1_2());
            	    			

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
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleEventOnOutcome"
    // InternalAce.g:409:1: entryRuleEventOnOutcome returns [EObject current=null] : iv_ruleEventOnOutcome= ruleEventOnOutcome EOF ;
    public final EObject entryRuleEventOnOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventOnOutcome = null;


        try {
            // InternalAce.g:409:55: (iv_ruleEventOnOutcome= ruleEventOnOutcome EOF )
            // InternalAce.g:410:2: iv_ruleEventOnOutcome= ruleEventOnOutcome EOF
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
    // InternalAce.g:416:1: ruleEventOnOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )? ) ;
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
            // InternalAce.g:422:2: ( (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )? ) )
            // InternalAce.g:423:2: (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )? )
            {
            // InternalAce.g:423:2: (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )? )
            // InternalAce.g:424:3: otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getEventOnOutcomeAccess().getOnKeyword_0());
            		
            // InternalAce.g:428:3: ( (lv_outcome_1_0= RULE_ID ) )
            // InternalAce.g:429:4: (lv_outcome_1_0= RULE_ID )
            {
            // InternalAce.g:429:4: (lv_outcome_1_0= RULE_ID )
            // InternalAce.g:430:5: lv_outcome_1_0= RULE_ID
            {
            lv_outcome_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

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

            // InternalAce.g:446:3: (otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalAce.g:447:4: otherlv_2= 'publishes' otherlv_3= '(' ( ( ruleQualifiedName ) )* otherlv_5= ')'
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_17); 

                    				newLeafNode(otherlv_2, grammarAccess.getEventOnOutcomeAccess().getPublishesKeyword_2_0());
                    			
                    otherlv_3=(Token)match(input,23,FOLLOW_18); 

                    				newLeafNode(otherlv_3, grammarAccess.getEventOnOutcomeAccess().getLeftParenthesisKeyword_2_1());
                    			
                    // InternalAce.g:455:4: ( ( ruleQualifiedName ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalAce.g:456:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAce.g:456:5: ( ruleQualifiedName )
                    	    // InternalAce.g:457:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getEventOnOutcomeRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getEventOnOutcomeAccess().getEventsEventCrossReference_2_2_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
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

                    otherlv_5=(Token)match(input,24,FOLLOW_19); 

                    				newLeafNode(otherlv_5, grammarAccess.getEventOnOutcomeAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalAce.g:476:3: (otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAce.g:477:4: otherlv_6= 'triggers' otherlv_7= '(' ( ( ruleQualifiedName ) )* otherlv_9= ')'
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_17); 

                    				newLeafNode(otherlv_6, grammarAccess.getEventOnOutcomeAccess().getTriggersKeyword_3_0());
                    			
                    otherlv_7=(Token)match(input,23,FOLLOW_18); 

                    				newLeafNode(otherlv_7, grammarAccess.getEventOnOutcomeAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalAce.g:485:4: ( ( ruleQualifiedName ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalAce.g:486:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAce.g:486:5: ( ruleQualifiedName )
                    	    // InternalAce.g:487:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getEventOnOutcomeRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getEventOnOutcomeAccess().getActionsActionCrossReference_3_2_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
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
    // InternalAce.g:510:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalAce.g:510:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalAce.g:511:2: iv_ruleEvent= ruleEvent EOF
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
    // InternalAce.g:517:1: ruleEvent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAce.g:523:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? ) )
            // InternalAce.g:524:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? )
            {
            // InternalAce.g:524:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? )
            // InternalAce.g:525:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )?
            {
            // InternalAce.g:525:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:526:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:526:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:527:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_20); 

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

            // InternalAce.g:543:3: (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==26) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAce.g:544:4: otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,26,FOLLOW_17); 

                    				newLeafNode(otherlv_1, grammarAccess.getEventAccess().getListenedToByKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,23,FOLLOW_18); 

                    				newLeafNode(otherlv_2, grammarAccess.getEventAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalAce.g:552:4: ( ( ruleQualifiedName ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_ID) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalAce.g:553:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAce.g:553:5: ( ruleQualifiedName )
                    	    // InternalAce.g:554:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getEventRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getEventAccess().getListenersViewFunctionCrossReference_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
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
    // InternalAce.g:577:1: entryRuleView returns [EObject current=null] : iv_ruleView= ruleView EOF ;
    public final EObject entryRuleView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleView = null;


        try {
            // InternalAce.g:577:45: (iv_ruleView= ruleView EOF )
            // InternalAce.g:578:2: iv_ruleView= ruleView EOF
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
    // InternalAce.g:584:1: ruleView returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )* ) ;
    public final EObject ruleView() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_renderFunctions_2_0 = null;



        	enterRule();

        try {
            // InternalAce.g:590:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )* ) )
            // InternalAce.g:591:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )* )
            {
            // InternalAce.g:591:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )* )
            // InternalAce.g:592:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )*
            {
            // InternalAce.g:592:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:593:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:593:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:594:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_14); 

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

            // InternalAce.g:610:3: (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}' )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==15) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalAce.g:611:4: otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleViewFunction ) )* otherlv_3= '}'
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getViewAccess().getLeftCurlyBracketKeyword_1_0());
            	    			
            	    // InternalAce.g:615:4: ( (lv_renderFunctions_2_0= ruleViewFunction ) )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==RULE_ID) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // InternalAce.g:616:5: (lv_renderFunctions_2_0= ruleViewFunction )
            	    	    {
            	    	    // InternalAce.g:616:5: (lv_renderFunctions_2_0= ruleViewFunction )
            	    	    // InternalAce.g:617:6: lv_renderFunctions_2_0= ruleViewFunction
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
            	    	    break loop20;
            	        }
            	    } while (true);

            	    otherlv_3=(Token)match(input,16,FOLLOW_14); 

            	    				newLeafNode(otherlv_3, grammarAccess.getViewAccess().getRightCurlyBracketKeyword_1_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalAce.g:643:1: entryRuleViewFunction returns [EObject current=null] : iv_ruleViewFunction= ruleViewFunction EOF ;
    public final EObject entryRuleViewFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleViewFunction = null;


        try {
            // InternalAce.g:643:53: (iv_ruleViewFunction= ruleViewFunction EOF )
            // InternalAce.g:644:2: iv_ruleViewFunction= ruleViewFunction EOF
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
    // InternalAce.g:650:1: ruleViewFunction returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleViewFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalAce.g:656:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalAce.g:657:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalAce.g:657:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:658:3: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:658:3: (lv_name_0_0= RULE_ID )
            // InternalAce.g:659:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getViewFunctionAccess().getNameIDTerminalRuleCall_0());
            			

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


            }


            	leaveRule();

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
    // InternalAce.g:678:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalAce.g:678:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalAce.g:679:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalAce.g:685:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalAce.g:691:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalAce.g:692:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalAce.g:692:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalAce.g:693:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalAce.g:700:3: (kw= '.' this_ID_2= RULE_ID )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==27) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalAce.g:701:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,27,FOLLOW_12); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_21); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalAce.g:718:1: entryRuleFunctionType returns [String current=null] : iv_ruleFunctionType= ruleFunctionType EOF ;
    public final String entryRuleFunctionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFunctionType = null;


        try {
            // InternalAce.g:718:52: (iv_ruleFunctionType= ruleFunctionType EOF )
            // InternalAce.g:719:2: iv_ruleFunctionType= ruleFunctionType EOF
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
    // InternalAce.g:725:1: ruleFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' | kw= 'GET' ) ;
    public final AntlrDatatypeRuleToken ruleFunctionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalAce.g:731:2: ( (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' | kw= 'GET' ) )
            // InternalAce.g:732:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' | kw= 'GET' )
            {
            // InternalAce.g:732:2: (kw= 'POST' | kw= 'PUT' | kw= 'DELETE' | kw= 'GET' )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt23=1;
                }
                break;
            case 29:
                {
                alt23=2;
                }
                break;
            case 30:
                {
                alt23=3;
                }
                break;
            case 31:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalAce.g:733:3: kw= 'POST'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionTypeAccess().getPOSTKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAce.g:739:3: kw= 'PUT'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionTypeAccess().getPUTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalAce.g:745:3: kw= 'DELETE'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFunctionTypeAccess().getDELETEKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalAce.g:751:3: kw= 'GET'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000000000E4002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000F0010010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002400002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000002L});

}