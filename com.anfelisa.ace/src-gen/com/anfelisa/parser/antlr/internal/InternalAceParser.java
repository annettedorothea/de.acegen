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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'target'", "':'", "'PHP'", "'ES6'", "'actions'", "'{'", "'}'", "'commands'", "'events'", "'views'", "'executes'", "'on'", "'publishes'", "'('", "')'", "'triggers'", "'listenedToBy'", "'.'"
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
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
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
    // InternalAce.g:71:1: ruleProject returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'target' otherlv_2= ':' ( ( (lv_target_3_1= 'PHP' | lv_target_3_2= 'ES6' ) ) ) (otherlv_4= 'actions' otherlv_5= '{' ( (lv_actions_6_0= ruleAction ) )* otherlv_7= '}' )* (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleCommand ) )* otherlv_11= '}' )* (otherlv_12= 'events' otherlv_13= '{' ( (lv_events_14_0= ruleEvent ) )* otherlv_15= '}' )* (otherlv_16= 'views' otherlv_17= '{' ( (lv_views_18_0= ruleView ) )* otherlv_19= '}' )* ) ;
    public final EObject ruleProject() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_target_3_1=null;
        Token lv_target_3_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_actions_6_0 = null;

        EObject lv_commands_10_0 = null;

        EObject lv_events_14_0 = null;

        EObject lv_views_18_0 = null;



        	enterRule();

        try {
            // InternalAce.g:77:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'target' otherlv_2= ':' ( ( (lv_target_3_1= 'PHP' | lv_target_3_2= 'ES6' ) ) ) (otherlv_4= 'actions' otherlv_5= '{' ( (lv_actions_6_0= ruleAction ) )* otherlv_7= '}' )* (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleCommand ) )* otherlv_11= '}' )* (otherlv_12= 'events' otherlv_13= '{' ( (lv_events_14_0= ruleEvent ) )* otherlv_15= '}' )* (otherlv_16= 'views' otherlv_17= '{' ( (lv_views_18_0= ruleView ) )* otherlv_19= '}' )* ) )
            // InternalAce.g:78:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'target' otherlv_2= ':' ( ( (lv_target_3_1= 'PHP' | lv_target_3_2= 'ES6' ) ) ) (otherlv_4= 'actions' otherlv_5= '{' ( (lv_actions_6_0= ruleAction ) )* otherlv_7= '}' )* (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleCommand ) )* otherlv_11= '}' )* (otherlv_12= 'events' otherlv_13= '{' ( (lv_events_14_0= ruleEvent ) )* otherlv_15= '}' )* (otherlv_16= 'views' otherlv_17= '{' ( (lv_views_18_0= ruleView ) )* otherlv_19= '}' )* )
            {
            // InternalAce.g:78:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'target' otherlv_2= ':' ( ( (lv_target_3_1= 'PHP' | lv_target_3_2= 'ES6' ) ) ) (otherlv_4= 'actions' otherlv_5= '{' ( (lv_actions_6_0= ruleAction ) )* otherlv_7= '}' )* (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleCommand ) )* otherlv_11= '}' )* (otherlv_12= 'events' otherlv_13= '{' ( (lv_events_14_0= ruleEvent ) )* otherlv_15= '}' )* (otherlv_16= 'views' otherlv_17= '{' ( (lv_views_18_0= ruleView ) )* otherlv_19= '}' )* )
            // InternalAce.g:79:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'target' otherlv_2= ':' ( ( (lv_target_3_1= 'PHP' | lv_target_3_2= 'ES6' ) ) ) (otherlv_4= 'actions' otherlv_5= '{' ( (lv_actions_6_0= ruleAction ) )* otherlv_7= '}' )* (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleCommand ) )* otherlv_11= '}' )* (otherlv_12= 'events' otherlv_13= '{' ( (lv_events_14_0= ruleEvent ) )* otherlv_15= '}' )* (otherlv_16= 'views' otherlv_17= '{' ( (lv_views_18_0= ruleView ) )* otherlv_19= '}' )*
            {
            // InternalAce.g:79:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:80:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:80:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:81:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_name_0_0, grammarAccess.getProjectAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProjectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getProjectAccess().getTargetKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getProjectAccess().getColonKeyword_2());
            		
            // InternalAce.g:105:3: ( ( (lv_target_3_1= 'PHP' | lv_target_3_2= 'ES6' ) ) )
            // InternalAce.g:106:4: ( (lv_target_3_1= 'PHP' | lv_target_3_2= 'ES6' ) )
            {
            // InternalAce.g:106:4: ( (lv_target_3_1= 'PHP' | lv_target_3_2= 'ES6' ) )
            // InternalAce.g:107:5: (lv_target_3_1= 'PHP' | lv_target_3_2= 'ES6' )
            {
            // InternalAce.g:107:5: (lv_target_3_1= 'PHP' | lv_target_3_2= 'ES6' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            else if ( (LA1_0==14) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalAce.g:108:6: lv_target_3_1= 'PHP'
                    {
                    lv_target_3_1=(Token)match(input,13,FOLLOW_6); 

                    						newLeafNode(lv_target_3_1, grammarAccess.getProjectAccess().getTargetPHPKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProjectRule());
                    						}
                    						setWithLastConsumed(current, "target", lv_target_3_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalAce.g:119:6: lv_target_3_2= 'ES6'
                    {
                    lv_target_3_2=(Token)match(input,14,FOLLOW_6); 

                    						newLeafNode(lv_target_3_2, grammarAccess.getProjectAccess().getTargetES6Keyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProjectRule());
                    						}
                    						setWithLastConsumed(current, "target", lv_target_3_2, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalAce.g:132:3: (otherlv_4= 'actions' otherlv_5= '{' ( (lv_actions_6_0= ruleAction ) )* otherlv_7= '}' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAce.g:133:4: otherlv_4= 'actions' otherlv_5= '{' ( (lv_actions_6_0= ruleAction ) )* otherlv_7= '}'
            	    {
            	    otherlv_4=(Token)match(input,15,FOLLOW_7); 

            	    				newLeafNode(otherlv_4, grammarAccess.getProjectAccess().getActionsKeyword_4_0());
            	    			
            	    otherlv_5=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_5, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_4_1());
            	    			
            	    // InternalAce.g:141:4: ( (lv_actions_6_0= ruleAction ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==RULE_ID) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalAce.g:142:5: (lv_actions_6_0= ruleAction )
            	    	    {
            	    	    // InternalAce.g:142:5: (lv_actions_6_0= ruleAction )
            	    	    // InternalAce.g:143:6: lv_actions_6_0= ruleAction
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getActionsActionParserRuleCall_4_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_actions_6_0=ruleAction();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"actions",
            	    	    							lv_actions_6_0,
            	    	    							"com.anfelisa.Ace.Action");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);

            	    otherlv_7=(Token)match(input,17,FOLLOW_6); 

            	    				newLeafNode(otherlv_7, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_4_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalAce.g:165:3: (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleCommand ) )* otherlv_11= '}' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalAce.g:166:4: otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleCommand ) )* otherlv_11= '}'
            	    {
            	    otherlv_8=(Token)match(input,18,FOLLOW_7); 

            	    				newLeafNode(otherlv_8, grammarAccess.getProjectAccess().getCommandsKeyword_5_0());
            	    			
            	    otherlv_9=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_9, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_5_1());
            	    			
            	    // InternalAce.g:174:4: ( (lv_commands_10_0= ruleCommand ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==RULE_ID) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalAce.g:175:5: (lv_commands_10_0= ruleCommand )
            	    	    {
            	    	    // InternalAce.g:175:5: (lv_commands_10_0= ruleCommand )
            	    	    // InternalAce.g:176:6: lv_commands_10_0= ruleCommand
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getCommandsCommandParserRuleCall_5_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_commands_10_0=ruleCommand();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"commands",
            	    	    							lv_commands_10_0,
            	    	    							"com.anfelisa.Ace.Command");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);

            	    otherlv_11=(Token)match(input,17,FOLLOW_9); 

            	    				newLeafNode(otherlv_11, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_5_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalAce.g:198:3: (otherlv_12= 'events' otherlv_13= '{' ( (lv_events_14_0= ruleEvent ) )* otherlv_15= '}' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalAce.g:199:4: otherlv_12= 'events' otherlv_13= '{' ( (lv_events_14_0= ruleEvent ) )* otherlv_15= '}'
            	    {
            	    otherlv_12=(Token)match(input,19,FOLLOW_7); 

            	    				newLeafNode(otherlv_12, grammarAccess.getProjectAccess().getEventsKeyword_6_0());
            	    			
            	    otherlv_13=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_13, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_6_1());
            	    			
            	    // InternalAce.g:207:4: ( (lv_events_14_0= ruleEvent ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==RULE_ID) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalAce.g:208:5: (lv_events_14_0= ruleEvent )
            	    	    {
            	    	    // InternalAce.g:208:5: (lv_events_14_0= ruleEvent )
            	    	    // InternalAce.g:209:6: lv_events_14_0= ruleEvent
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getEventsEventParserRuleCall_6_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_events_14_0=ruleEvent();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"events",
            	    	    							lv_events_14_0,
            	    	    							"com.anfelisa.Ace.Event");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    otherlv_15=(Token)match(input,17,FOLLOW_10); 

            	    				newLeafNode(otherlv_15, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_6_3());
            	    			

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalAce.g:231:3: (otherlv_16= 'views' otherlv_17= '{' ( (lv_views_18_0= ruleView ) )* otherlv_19= '}' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalAce.g:232:4: otherlv_16= 'views' otherlv_17= '{' ( (lv_views_18_0= ruleView ) )* otherlv_19= '}'
            	    {
            	    otherlv_16=(Token)match(input,20,FOLLOW_7); 

            	    				newLeafNode(otherlv_16, grammarAccess.getProjectAccess().getViewsKeyword_7_0());
            	    			
            	    otherlv_17=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_17, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_7_1());
            	    			
            	    // InternalAce.g:240:4: ( (lv_views_18_0= ruleView ) )*
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==RULE_ID) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // InternalAce.g:241:5: (lv_views_18_0= ruleView )
            	    	    {
            	    	    // InternalAce.g:241:5: (lv_views_18_0= ruleView )
            	    	    // InternalAce.g:242:6: lv_views_18_0= ruleView
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getProjectAccess().getViewsViewParserRuleCall_7_2_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_views_18_0=ruleView();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getProjectRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"views",
            	    	    							lv_views_18_0,
            	    	    							"com.anfelisa.Ace.View");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);

            	    otherlv_19=(Token)match(input,17,FOLLOW_11); 

            	    				newLeafNode(otherlv_19, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_7_3());
            	    			

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
    // InternalAce.g:268:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalAce.g:268:47: (iv_ruleAction= ruleAction EOF )
            // InternalAce.g:269:2: iv_ruleAction= ruleAction EOF
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
    // InternalAce.g:275:1: ruleAction returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'executes' ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalAce.g:281:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'executes' ( (otherlv_2= RULE_ID ) ) )? ) )
            // InternalAce.g:282:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'executes' ( (otherlv_2= RULE_ID ) ) )? )
            {
            // InternalAce.g:282:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'executes' ( (otherlv_2= RULE_ID ) ) )? )
            // InternalAce.g:283:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'executes' ( (otherlv_2= RULE_ID ) ) )?
            {
            // InternalAce.g:283:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:284:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:284:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:285:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(lv_name_0_0, grammarAccess.getActionAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalAce.g:301:3: (otherlv_1= 'executes' ( (otherlv_2= RULE_ID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAce.g:302:4: otherlv_1= 'executes' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_13); 

                    				newLeafNode(otherlv_1, grammarAccess.getActionAccess().getExecutesKeyword_1_0());
                    			
                    // InternalAce.g:306:4: ( (otherlv_2= RULE_ID ) )
                    // InternalAce.g:307:5: (otherlv_2= RULE_ID )
                    {
                    // InternalAce.g:307:5: (otherlv_2= RULE_ID )
                    // InternalAce.g:308:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_2, grammarAccess.getActionAccess().getCommandCommandCrossReference_1_1_0());
                    					

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
    // InternalAce.g:324:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // InternalAce.g:324:48: (iv_ruleCommand= ruleCommand EOF )
            // InternalAce.g:325:2: iv_ruleCommand= ruleCommand EOF
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
    // InternalAce.g:331:1: ruleCommand returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_eventsOnOutcome_2_0 = null;



        	enterRule();

        try {
            // InternalAce.g:337:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* ) )
            // InternalAce.g:338:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* )
            {
            // InternalAce.g:338:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )* )
            // InternalAce.g:339:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )*
            {
            // InternalAce.g:339:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:340:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:340:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:341:5: lv_name_0_0= RULE_ID
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

            // InternalAce.g:357:3: (otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==16) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAce.g:358:4: otherlv_1= '{' ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )* otherlv_3= '}'
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_15); 

            	    				newLeafNode(otherlv_1, grammarAccess.getCommandAccess().getLeftCurlyBracketKeyword_1_0());
            	    			
            	    // InternalAce.g:362:4: ( (lv_eventsOnOutcome_2_0= ruleEventOnOutcome ) )*
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==22) ) {
            	            alt11=1;
            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalAce.g:363:5: (lv_eventsOnOutcome_2_0= ruleEventOnOutcome )
            	    	    {
            	    	    // InternalAce.g:363:5: (lv_eventsOnOutcome_2_0= ruleEventOnOutcome )
            	    	    // InternalAce.g:364:6: lv_eventsOnOutcome_2_0= ruleEventOnOutcome
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
            	    	    break loop11;
            	        }
            	    } while (true);

            	    otherlv_3=(Token)match(input,17,FOLLOW_14); 

            	    				newLeafNode(otherlv_3, grammarAccess.getCommandAccess().getRightCurlyBracketKeyword_1_2());
            	    			

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
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleEventOnOutcome"
    // InternalAce.g:390:1: entryRuleEventOnOutcome returns [EObject current=null] : iv_ruleEventOnOutcome= ruleEventOnOutcome EOF ;
    public final EObject entryRuleEventOnOutcome() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventOnOutcome = null;


        try {
            // InternalAce.g:390:55: (iv_ruleEventOnOutcome= ruleEventOnOutcome EOF )
            // InternalAce.g:391:2: iv_ruleEventOnOutcome= ruleEventOnOutcome EOF
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
    // InternalAce.g:397:1: ruleEventOnOutcome returns [EObject current=null] : (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( (otherlv_8= RULE_ID ) )* otherlv_9= ')' )? ) ;
    public final EObject ruleEventOnOutcome() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_outcome_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;


        	enterRule();

        try {
            // InternalAce.g:403:2: ( (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( (otherlv_8= RULE_ID ) )* otherlv_9= ')' )? ) )
            // InternalAce.g:404:2: (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( (otherlv_8= RULE_ID ) )* otherlv_9= ')' )? )
            {
            // InternalAce.g:404:2: (otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( (otherlv_8= RULE_ID ) )* otherlv_9= ')' )? )
            // InternalAce.g:405:3: otherlv_0= 'on' ( (lv_outcome_1_0= RULE_ID ) ) (otherlv_2= 'publishes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) )* otherlv_5= ')' )? (otherlv_6= 'triggers' otherlv_7= '(' ( (otherlv_8= RULE_ID ) )* otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getEventOnOutcomeAccess().getOnKeyword_0());
            		
            // InternalAce.g:409:3: ( (lv_outcome_1_0= RULE_ID ) )
            // InternalAce.g:410:4: (lv_outcome_1_0= RULE_ID )
            {
            // InternalAce.g:410:4: (lv_outcome_1_0= RULE_ID )
            // InternalAce.g:411:5: lv_outcome_1_0= RULE_ID
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

            // InternalAce.g:427:3: (otherlv_2= 'publishes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) )* otherlv_5= ')' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalAce.g:428:4: otherlv_2= 'publishes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) )* otherlv_5= ')'
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_17); 

                    				newLeafNode(otherlv_2, grammarAccess.getEventOnOutcomeAccess().getPublishesKeyword_2_0());
                    			
                    otherlv_3=(Token)match(input,24,FOLLOW_18); 

                    				newLeafNode(otherlv_3, grammarAccess.getEventOnOutcomeAccess().getLeftParenthesisKeyword_2_1());
                    			
                    // InternalAce.g:436:4: ( (otherlv_4= RULE_ID ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalAce.g:437:5: (otherlv_4= RULE_ID )
                    	    {
                    	    // InternalAce.g:437:5: (otherlv_4= RULE_ID )
                    	    // InternalAce.g:438:6: otherlv_4= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getEventOnOutcomeRule());
                    	    						}
                    	    					
                    	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_18); 

                    	    						newLeafNode(otherlv_4, grammarAccess.getEventOnOutcomeAccess().getEventsEventCrossReference_2_2_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,25,FOLLOW_19); 

                    				newLeafNode(otherlv_5, grammarAccess.getEventOnOutcomeAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }

            // InternalAce.g:454:3: (otherlv_6= 'triggers' otherlv_7= '(' ( (otherlv_8= RULE_ID ) )* otherlv_9= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAce.g:455:4: otherlv_6= 'triggers' otherlv_7= '(' ( (otherlv_8= RULE_ID ) )* otherlv_9= ')'
                    {
                    otherlv_6=(Token)match(input,26,FOLLOW_17); 

                    				newLeafNode(otherlv_6, grammarAccess.getEventOnOutcomeAccess().getTriggersKeyword_3_0());
                    			
                    otherlv_7=(Token)match(input,24,FOLLOW_18); 

                    				newLeafNode(otherlv_7, grammarAccess.getEventOnOutcomeAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalAce.g:463:4: ( (otherlv_8= RULE_ID ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==RULE_ID) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalAce.g:464:5: (otherlv_8= RULE_ID )
                    	    {
                    	    // InternalAce.g:464:5: (otherlv_8= RULE_ID )
                    	    // InternalAce.g:465:6: otherlv_8= RULE_ID
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getEventOnOutcomeRule());
                    	    						}
                    	    					
                    	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_18); 

                    	    						newLeafNode(otherlv_8, grammarAccess.getEventOnOutcomeAccess().getActionsActionCrossReference_3_2_0());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,25,FOLLOW_2); 

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
    // InternalAce.g:485:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalAce.g:485:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalAce.g:486:2: iv_ruleEvent= ruleEvent EOF
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
    // InternalAce.g:492:1: ruleEvent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalAce.g:498:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? ) )
            // InternalAce.g:499:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? )
            {
            // InternalAce.g:499:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )? )
            // InternalAce.g:500:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )?
            {
            // InternalAce.g:500:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:501:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:501:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:502:5: lv_name_0_0= RULE_ID
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

            // InternalAce.g:518:3: (otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAce.g:519:4: otherlv_1= 'listenedToBy' otherlv_2= '(' ( ( ruleQualifiedName ) )* otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_17); 

                    				newLeafNode(otherlv_1, grammarAccess.getEventAccess().getListenedToByKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,24,FOLLOW_18); 

                    				newLeafNode(otherlv_2, grammarAccess.getEventAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalAce.g:527:4: ( ( ruleQualifiedName ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_ID) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalAce.g:528:5: ( ruleQualifiedName )
                    	    {
                    	    // InternalAce.g:528:5: ( ruleQualifiedName )
                    	    // InternalAce.g:529:6: ruleQualifiedName
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getEventRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getEventAccess().getListenersRenderFunctionCrossReference_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_18);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,25,FOLLOW_2); 

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
    // InternalAce.g:552:1: entryRuleView returns [EObject current=null] : iv_ruleView= ruleView EOF ;
    public final EObject entryRuleView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleView = null;


        try {
            // InternalAce.g:552:45: (iv_ruleView= ruleView EOF )
            // InternalAce.g:553:2: iv_ruleView= ruleView EOF
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
    // InternalAce.g:559:1: ruleView returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleRenderFunction ) )* otherlv_3= '}' )* ) ;
    public final EObject ruleView() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_renderFunctions_2_0 = null;



        	enterRule();

        try {
            // InternalAce.g:565:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleRenderFunction ) )* otherlv_3= '}' )* ) )
            // InternalAce.g:566:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleRenderFunction ) )* otherlv_3= '}' )* )
            {
            // InternalAce.g:566:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleRenderFunction ) )* otherlv_3= '}' )* )
            // InternalAce.g:567:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleRenderFunction ) )* otherlv_3= '}' )*
            {
            // InternalAce.g:567:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:568:4: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:568:4: (lv_name_0_0= RULE_ID )
            // InternalAce.g:569:5: lv_name_0_0= RULE_ID
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

            // InternalAce.g:585:3: (otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleRenderFunction ) )* otherlv_3= '}' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==16) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalAce.g:586:4: otherlv_1= '{' ( (lv_renderFunctions_2_0= ruleRenderFunction ) )* otherlv_3= '}'
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_8); 

            	    				newLeafNode(otherlv_1, grammarAccess.getViewAccess().getLeftCurlyBracketKeyword_1_0());
            	    			
            	    // InternalAce.g:590:4: ( (lv_renderFunctions_2_0= ruleRenderFunction ) )*
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==RULE_ID) ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // InternalAce.g:591:5: (lv_renderFunctions_2_0= ruleRenderFunction )
            	    	    {
            	    	    // InternalAce.g:591:5: (lv_renderFunctions_2_0= ruleRenderFunction )
            	    	    // InternalAce.g:592:6: lv_renderFunctions_2_0= ruleRenderFunction
            	    	    {

            	    	    						newCompositeNode(grammarAccess.getViewAccess().getRenderFunctionsRenderFunctionParserRuleCall_1_1_0());
            	    	    					
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_renderFunctions_2_0=ruleRenderFunction();

            	    	    state._fsp--;


            	    	    						if (current==null) {
            	    	    							current = createModelElementForParent(grammarAccess.getViewRule());
            	    	    						}
            	    	    						add(
            	    	    							current,
            	    	    							"renderFunctions",
            	    	    							lv_renderFunctions_2_0,
            	    	    							"com.anfelisa.Ace.RenderFunction");
            	    	    						afterParserOrEnumRuleCall();
            	    	    					

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop19;
            	        }
            	    } while (true);

            	    otherlv_3=(Token)match(input,17,FOLLOW_14); 

            	    				newLeafNode(otherlv_3, grammarAccess.getViewAccess().getRightCurlyBracketKeyword_1_2());
            	    			

            	    }
            	    break;

            	default :
            	    break loop20;
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


    // $ANTLR start "entryRuleRenderFunction"
    // InternalAce.g:618:1: entryRuleRenderFunction returns [EObject current=null] : iv_ruleRenderFunction= ruleRenderFunction EOF ;
    public final EObject entryRuleRenderFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRenderFunction = null;


        try {
            // InternalAce.g:618:55: (iv_ruleRenderFunction= ruleRenderFunction EOF )
            // InternalAce.g:619:2: iv_ruleRenderFunction= ruleRenderFunction EOF
            {
             newCompositeNode(grammarAccess.getRenderFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRenderFunction=ruleRenderFunction();

            state._fsp--;

             current =iv_ruleRenderFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRenderFunction"


    // $ANTLR start "ruleRenderFunction"
    // InternalAce.g:625:1: ruleRenderFunction returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleRenderFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalAce.g:631:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalAce.g:632:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalAce.g:632:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalAce.g:633:3: (lv_name_0_0= RULE_ID )
            {
            // InternalAce.g:633:3: (lv_name_0_0= RULE_ID )
            // InternalAce.g:634:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getRenderFunctionAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getRenderFunctionRule());
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
    // $ANTLR end "ruleRenderFunction"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalAce.g:653:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalAce.g:653:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalAce.g:654:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalAce.g:660:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalAce.g:666:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalAce.g:667:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalAce.g:667:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalAce.g:668:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalAce.g:675:3: (kw= '.' this_ID_2= RULE_ID )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==28) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalAce.g:676:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,28,FOLLOW_13); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_21); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000001C8002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000001C0002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000420000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004800002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000002L});

}