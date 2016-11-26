/*
 * generated by Xtext 2.10.0
 */
grammar InternalAce;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package com.anfelisa.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
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

}

@parser::members {

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

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleProject
entryRuleProject returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getProjectRule()); }
	iv_ruleProject=ruleProject
	{ $current=$iv_ruleProject.current; }
	EOF;

// Rule Project
ruleProject returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getProjectAccess().getNameQualifiedNameParserRuleCall_0_0());
				}
				lv_name_0_0=ruleQualifiedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getProjectRule());
					}
					set(
						$current,
						"name",
						lv_name_0_0,
						"com.anfelisa.Ace.QualifiedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='target'
		{
			newLeafNode(otherlv_1, grammarAccess.getProjectAccess().getTargetKeyword_1());
		}
		(
			(
				(
					lv_target_2_1='ES6'
					{
						newLeafNode(lv_target_2_1, grammarAccess.getProjectAccess().getTargetES6Keyword_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getProjectRule());
						}
						setWithLastConsumed($current, "target", lv_target_2_1, null);
					}
					    |
					lv_target_2_2='JAVA'
					{
						newLeafNode(lv_target_2_2, grammarAccess.getProjectAccess().getTargetJAVAKeyword_2_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getProjectRule());
						}
						setWithLastConsumed($current, "target", lv_target_2_2, null);
					}
				)
			)
		)
		(
			otherlv_3='models'
			{
				newLeafNode(otherlv_3, grammarAccess.getProjectAccess().getModelsKeyword_3_0());
			}
			otherlv_4='{'
			{
				newLeafNode(otherlv_4, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_3_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getProjectAccess().getModelsModelParserRuleCall_3_2_0());
					}
					lv_models_5_0=ruleModel
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getProjectRule());
						}
						add(
							$current,
							"models",
							lv_models_5_0,
							"com.anfelisa.Ace.Model");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_6='}'
			{
				newLeafNode(otherlv_6, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_3_3());
			}
		)*
		(
			otherlv_7='data'
			{
				newLeafNode(otherlv_7, grammarAccess.getProjectAccess().getDataKeyword_4_0());
			}
			otherlv_8='{'
			{
				newLeafNode(otherlv_8, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_4_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getProjectAccess().getDataDataParserRuleCall_4_2_0());
					}
					lv_data_9_0=ruleData
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getProjectRule());
						}
						add(
							$current,
							"data",
							lv_data_9_0,
							"com.anfelisa.Ace.Data");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_10='}'
			{
				newLeafNode(otherlv_10, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_4_3());
			}
		)*
		(
			otherlv_11='actions'
			{
				newLeafNode(otherlv_11, grammarAccess.getProjectAccess().getActionsKeyword_5_0());
			}
			otherlv_12='{'
			{
				newLeafNode(otherlv_12, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_5_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getProjectAccess().getActionsActionParserRuleCall_5_2_0());
					}
					lv_actions_13_0=ruleAction
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getProjectRule());
						}
						add(
							$current,
							"actions",
							lv_actions_13_0,
							"com.anfelisa.Ace.Action");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_14='}'
			{
				newLeafNode(otherlv_14, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_5_3());
			}
		)*
		(
			otherlv_15='commands'
			{
				newLeafNode(otherlv_15, grammarAccess.getProjectAccess().getCommandsKeyword_6_0());
			}
			otherlv_16='{'
			{
				newLeafNode(otherlv_16, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_6_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getProjectAccess().getCommandsCommandParserRuleCall_6_2_0());
					}
					lv_commands_17_0=ruleCommand
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getProjectRule());
						}
						add(
							$current,
							"commands",
							lv_commands_17_0,
							"com.anfelisa.Ace.Command");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_18='}'
			{
				newLeafNode(otherlv_18, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_6_3());
			}
		)*
		(
			otherlv_19='events'
			{
				newLeafNode(otherlv_19, grammarAccess.getProjectAccess().getEventsKeyword_7_0());
			}
			otherlv_20='{'
			{
				newLeafNode(otherlv_20, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_7_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getProjectAccess().getEventsEventParserRuleCall_7_2_0());
					}
					lv_events_21_0=ruleEvent
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getProjectRule());
						}
						add(
							$current,
							"events",
							lv_events_21_0,
							"com.anfelisa.Ace.Event");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_22='}'
			{
				newLeafNode(otherlv_22, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_7_3());
			}
		)*
		(
			otherlv_23='views'
			{
				newLeafNode(otherlv_23, grammarAccess.getProjectAccess().getViewsKeyword_8_0());
			}
			otherlv_24='{'
			{
				newLeafNode(otherlv_24, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_8_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getProjectAccess().getViewsViewParserRuleCall_8_2_0());
					}
					lv_views_25_0=ruleView
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getProjectRule());
						}
						add(
							$current,
							"views",
							lv_views_25_0,
							"com.anfelisa.Ace.View");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_26='}'
			{
				newLeafNode(otherlv_26, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_8_3());
			}
		)*
	)
;

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_persistent_0_0='persistent'
				{
					newLeafNode(lv_persistent_0_0, grammarAccess.getModelAccess().getPersistentPersistentKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModelRule());
					}
					setWithLastConsumed($current, "persistent", true, "persistent");
				}
			)
		)?
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModelRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getModelAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getAttributesAttributeParserRuleCall_3_0());
				}
				lv_attributes_3_0=ruleAttribute
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"attributes",
						lv_attributes_3_0,
						"com.anfelisa.Ace.Attribute");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getModelAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleData
entryRuleData returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDataRule()); }
	iv_ruleData=ruleData
	{ $current=$iv_ruleData.current; }
	EOF;

// Rule Data
ruleData returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getDataAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDataRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getDataAccess().getColonKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getDataAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDataAccess().getModelsModelRefParserRuleCall_3_0());
				}
				lv_models_3_0=ruleModelRef
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDataRule());
					}
					add(
						$current,
						"models",
						lv_models_3_0,
						"com.anfelisa.Ace.ModelRef");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getDataAccess().getRightParenthesisKeyword_4());
		}
		(
			otherlv_5=':'
			{
				newLeafNode(otherlv_5, grammarAccess.getDataAccess().getColonKeyword_5_0());
			}
			otherlv_6='('
			{
				newLeafNode(otherlv_6, grammarAccess.getDataAccess().getLeftParenthesisKeyword_5_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDataAccess().getDataListsDataRefParserRuleCall_5_2_0());
					}
					lv_dataLists_7_0=ruleDataRef
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDataRule());
						}
						add(
							$current,
							"dataLists",
							lv_dataLists_7_0,
							"com.anfelisa.Ace.DataRef");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_8=')'
			{
				newLeafNode(otherlv_8, grammarAccess.getDataAccess().getRightParenthesisKeyword_5_3());
			}
		)?
	)
;

// Entry rule entryRuleModelRef
entryRuleModelRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRefRule()); }
	iv_ruleModelRef=ruleModelRef
	{ $current=$iv_ruleModelRef.current; }
	EOF;

// Rule ModelRef
ruleModelRef returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_list_0_0='List'
				{
					newLeafNode(lv_list_0_0, grammarAccess.getModelRefAccess().getListListKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModelRefRule());
					}
					setWithLastConsumed($current, "list", true, "List");
				}
			)
		)?
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModelRefRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getModelRefAccess().getModelModelCrossReference_1_0());
				}
				ruleQualifiedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleDataRef
entryRuleDataRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDataRefRule()); }
	iv_ruleDataRef=ruleDataRef
	{ $current=$iv_ruleDataRef.current; }
	EOF;

// Rule DataRef
ruleDataRef returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='List'
		{
			newLeafNode(otherlv_0, grammarAccess.getDataRefAccess().getListKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDataRefRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getDataRefAccess().getDataDataCrossReference_1_0());
				}
				ruleQualifiedName
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleAttribute
entryRuleAttribute returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAttributeRule()); }
	iv_ruleAttribute=ruleAttribute
	{ $current=$iv_ruleAttribute.current; }
	EOF;

// Rule Attribute
ruleAttribute returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_unique_0_0='Unique'
				{
					newLeafNode(lv_unique_0_0, grammarAccess.getAttributeAccess().getUniqueUniqueKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAttributeRule());
					}
					setWithLastConsumed($current, "unique", true, "Unique");
				}
			)
		)?
		(
			(
				lv_primaryKey_1_0='PrimaryKey'
				{
					newLeafNode(lv_primaryKey_1_0, grammarAccess.getAttributeAccess().getPrimaryKeyPrimaryKeyKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAttributeRule());
					}
					setWithLastConsumed($current, "primaryKey", true, "PrimaryKey");
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getAttributeAccess().getConstraintConstraintParserRuleCall_2_0());
				}
				lv_constraint_2_0=ruleConstraint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAttributeRule());
					}
					set(
						$current,
						"constraint",
						lv_constraint_2_0,
						"com.anfelisa.Ace.Constraint");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getAttributeAccess().getTypeModelTypeParserRuleCall_3_0());
				}
				lv_type_3_0=ruleModelType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAttributeRule());
					}
					set(
						$current,
						"type",
						lv_type_3_0,
						"com.anfelisa.Ace.ModelType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				lv_name_4_0=RULE_ID
				{
					newLeafNode(lv_name_4_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_4_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAttributeRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_4_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_5='references'
			{
				newLeafNode(otherlv_5, grammarAccess.getAttributeAccess().getReferencesKeyword_5_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAttributeRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getAttributeAccess().getForeignKeyAttributeCrossReference_5_1_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleAction
entryRuleAction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getActionRule()); }
	iv_ruleAction=ruleAction
	{ $current=$iv_ruleAction.current; }
	EOF;

// Rule Action
ruleAction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getActionAccess().getTypeFunctionTypeParserRuleCall_0_0());
				}
				lv_type_0_0=ruleFunctionType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getActionRule());
					}
					set(
						$current,
						"type",
						lv_type_0_0,
						"com.anfelisa.Ace.FunctionType");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getActionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getActionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_2='uses'
			{
				newLeafNode(otherlv_2, grammarAccess.getActionAccess().getUsesKeyword_2_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getActionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getActionAccess().getDataDataCrossReference_2_1_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_4='executes'
			{
				newLeafNode(otherlv_4, grammarAccess.getActionAccess().getExecutesKeyword_3_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getActionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getActionAccess().getCommandCommandCrossReference_3_1_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleCommand
entryRuleCommand returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCommandRule()); }
	iv_ruleCommand=ruleCommand
	{ $current=$iv_ruleCommand.current; }
	EOF;

// Rule Command
ruleCommand returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getCommandAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCommandRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_1='uses'
			{
				newLeafNode(otherlv_1, grammarAccess.getCommandAccess().getUsesKeyword_1_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getCommandRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getCommandAccess().getDataDataCrossReference_1_1_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_3='{'
			{
				newLeafNode(otherlv_3, grammarAccess.getCommandAccess().getLeftCurlyBracketKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getCommandAccess().getEventsOnOutcomeEventOnOutcomeParserRuleCall_2_1_0());
					}
					lv_eventsOnOutcome_4_0=ruleEventOnOutcome
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getCommandRule());
						}
						add(
							$current,
							"eventsOnOutcome",
							lv_eventsOnOutcome_4_0,
							"com.anfelisa.Ace.EventOnOutcome");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_5='}'
			{
				newLeafNode(otherlv_5, grammarAccess.getCommandAccess().getRightCurlyBracketKeyword_2_2());
			}
		)*
	)
;

// Entry rule entryRuleEventOnOutcome
entryRuleEventOnOutcome returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEventOnOutcomeRule()); }
	iv_ruleEventOnOutcome=ruleEventOnOutcome
	{ $current=$iv_ruleEventOnOutcome.current; }
	EOF;

// Rule EventOnOutcome
ruleEventOnOutcome returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='on'
		{
			newLeafNode(otherlv_0, grammarAccess.getEventOnOutcomeAccess().getOnKeyword_0());
		}
		(
			(
				lv_outcome_1_0=RULE_ID
				{
					newLeafNode(lv_outcome_1_0, grammarAccess.getEventOnOutcomeAccess().getOutcomeIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEventOnOutcomeRule());
					}
					setWithLastConsumed(
						$current,
						"outcome",
						lv_outcome_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_2='publishes'
			{
				newLeafNode(otherlv_2, grammarAccess.getEventOnOutcomeAccess().getPublishesKeyword_2_0());
			}
			otherlv_3='('
			{
				newLeafNode(otherlv_3, grammarAccess.getEventOnOutcomeAccess().getLeftParenthesisKeyword_2_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEventOnOutcomeRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEventOnOutcomeAccess().getEventsEventCrossReference_2_2_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_5=')'
			{
				newLeafNode(otherlv_5, grammarAccess.getEventOnOutcomeAccess().getRightParenthesisKeyword_2_3());
			}
		)?
		(
			otherlv_6='triggers'
			{
				newLeafNode(otherlv_6, grammarAccess.getEventOnOutcomeAccess().getTriggersKeyword_3_0());
			}
			otherlv_7='('
			{
				newLeafNode(otherlv_7, grammarAccess.getEventOnOutcomeAccess().getLeftParenthesisKeyword_3_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEventOnOutcomeRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEventOnOutcomeAccess().getActionsActionCrossReference_3_2_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_9=')'
			{
				newLeafNode(otherlv_9, grammarAccess.getEventOnOutcomeAccess().getRightParenthesisKeyword_3_3());
			}
		)?
	)
;

// Entry rule entryRuleEvent
entryRuleEvent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEventRule()); }
	iv_ruleEvent=ruleEvent
	{ $current=$iv_ruleEvent.current; }
	EOF;

// Rule Event
ruleEvent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getEventAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEventRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_1='uses'
			{
				newLeafNode(otherlv_1, grammarAccess.getEventAccess().getUsesKeyword_1_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEventRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEventAccess().getDataDataCrossReference_1_1_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_3='listenedToBy'
			{
				newLeafNode(otherlv_3, grammarAccess.getEventAccess().getListenedToByKeyword_2_0());
			}
			otherlv_4='('
			{
				newLeafNode(otherlv_4, grammarAccess.getEventAccess().getLeftParenthesisKeyword_2_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEventRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getEventAccess().getListenersViewFunctionCrossReference_2_2_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_6=')'
			{
				newLeafNode(otherlv_6, grammarAccess.getEventAccess().getRightParenthesisKeyword_2_3());
			}
		)?
	)
;

// Entry rule entryRuleView
entryRuleView returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getViewRule()); }
	iv_ruleView=ruleView
	{ $current=$iv_ruleView.current; }
	EOF;

// Rule View
ruleView returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getViewAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getViewRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_1='{'
			{
				newLeafNode(otherlv_1, grammarAccess.getViewAccess().getLeftCurlyBracketKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getViewAccess().getRenderFunctionsViewFunctionParserRuleCall_1_1_0());
					}
					lv_renderFunctions_2_0=ruleViewFunction
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getViewRule());
						}
						add(
							$current,
							"renderFunctions",
							lv_renderFunctions_2_0,
							"com.anfelisa.Ace.ViewFunction");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_3='}'
			{
				newLeafNode(otherlv_3, grammarAccess.getViewAccess().getRightCurlyBracketKeyword_1_2());
			}
		)*
	)
;

// Entry rule entryRuleViewFunction
entryRuleViewFunction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getViewFunctionRule()); }
	iv_ruleViewFunction=ruleViewFunction
	{ $current=$iv_ruleViewFunction.current; }
	EOF;

// Rule ViewFunction
ruleViewFunction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getViewFunctionAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getViewFunctionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_1='('
			{
				newLeafNode(otherlv_1, grammarAccess.getViewFunctionAccess().getLeftParenthesisKeyword_1_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getViewFunctionRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getViewFunctionAccess().getDataDataCrossReference_1_1_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_3=')'
			{
				newLeafNode(otherlv_3, grammarAccess.getViewFunctionAccess().getRightParenthesisKeyword_1_2());
			}
		)?
	)
;

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); }
	iv_ruleQualifiedName=ruleQualifiedName
	{ $current=$iv_ruleQualifiedName.current.getText(); }
	EOF;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
;

// Entry rule entryRuleFunctionType
entryRuleFunctionType returns [String current=null]:
	{ newCompositeNode(grammarAccess.getFunctionTypeRule()); }
	iv_ruleFunctionType=ruleFunctionType
	{ $current=$iv_ruleFunctionType.current.getText(); }
	EOF;

// Rule FunctionType
ruleFunctionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='POST'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getFunctionTypeAccess().getPOSTKeyword_0());
		}
		    |
		kw='PUT'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getFunctionTypeAccess().getPUTKeyword_1());
		}
		    |
		kw='DELETE'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getFunctionTypeAccess().getDELETEKeyword_2());
		}
		    |
		kw='GET'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getFunctionTypeAccess().getGETKeyword_3());
		}
	)
;

// Entry rule entryRuleModelType
entryRuleModelType returns [String current=null]:
	{ newCompositeNode(grammarAccess.getModelTypeRule()); }
	iv_ruleModelType=ruleModelType
	{ $current=$iv_ruleModelType.current.getText(); }
	EOF;

// Rule ModelType
ruleModelType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='Serial'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelTypeAccess().getSerialKeyword_0());
		}
		    |
		kw='Integer'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelTypeAccess().getIntegerKeyword_1());
		}
		    |
		kw='String'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelTypeAccess().getStringKeyword_2());
		}
		    |
		kw='Float'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelTypeAccess().getFloatKeyword_3());
		}
		    |
		kw='Boolean'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelTypeAccess().getBooleanKeyword_4());
		}
		    |
		kw='DateTime'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelTypeAccess().getDateTimeKeyword_5());
		}
		    |
		kw='Long'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getModelTypeAccess().getLongKeyword_6());
		}
	)
;

// Entry rule entryRuleConstraint
entryRuleConstraint returns [String current=null]:
	{ newCompositeNode(grammarAccess.getConstraintRule()); }
	iv_ruleConstraint=ruleConstraint
	{ $current=$iv_ruleConstraint.current.getText(); }
	EOF;

// Rule Constraint
ruleConstraint returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='NotEmpty'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getConstraintAccess().getNotEmptyKeyword_0());
		}
		    |
		kw='NotNull'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getConstraintAccess().getNotNullKeyword_1());
		}
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
