/*
 * generated by Xtext 2.25.0
 */
package de.acegen.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.acegen.ide.contentassist.antlr.internal.InternalAceGenParser;
import de.acegen.services.AceGenGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class AceGenParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(AceGenGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, AceGenGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getProjectAccess().getAlternatives_1(), "rule__Project__Alternatives_1");
			builder.put(grammarAccess.getHttpClientStateFunctionTypeAccess().getAlternatives(), "rule__HttpClientStateFunctionType__Alternatives");
			builder.put(grammarAccess.getClientAttributeAccess().getAlternatives(), "rule__ClientAttribute__Alternatives");
			builder.put(grammarAccess.getJsonValueClientAccess().getAlternatives(), "rule__JsonValueClient__Alternatives");
			builder.put(grammarAccess.getHttpServerAceAccess().getAlternatives(), "rule__HttpServerAce__Alternatives");
			builder.put(grammarAccess.getGivenAccess().getAlternatives(), "rule__Given__Alternatives");
			builder.put(grammarAccess.getPersistenceVerificationExpressionAccess().getAlternatives(), "rule__PersistenceVerificationExpression__Alternatives");
			builder.put(grammarAccess.getSelectByExpectationAccess().getAlternatives(), "rule__SelectByExpectation__Alternatives");
			builder.put(grammarAccess.getAttributeAccess().getAlternatives_4(), "rule__Attribute__Alternatives_4");
			builder.put(grammarAccess.getWriteFunctionTypeAccess().getAlternatives(), "rule__WriteFunctionType__Alternatives");
			builder.put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
			builder.put(grammarAccess.getJsonObjectAccess().getAlternatives(), "rule__JsonObject__Alternatives");
			builder.put(grammarAccess.getJsonValueAccess().getAlternatives(), "rule__JsonValue__Alternatives");
			builder.put(grammarAccess.getJsonBooleanAccess().getAlternatives(), "rule__JsonBoolean__Alternatives");
			builder.put(grammarAccess.getPrimitiveValueAccess().getAlternatives(), "rule__PrimitiveValue__Alternatives");
			builder.put(grammarAccess.getProjectAccess().getGroup(), "rule__Project__Group__0");
			builder.put(grammarAccess.getProjectAccess().getGroup_1_0(), "rule__Project__Group_1_0__0");
			builder.put(grammarAccess.getProjectAccess().getGroup_1_1(), "rule__Project__Group_1_1__0");
			builder.put(grammarAccess.getHttpClientAccess().getGroup(), "rule__HttpClient__Group__0");
			builder.put(grammarAccess.getHttpClientAccess().getGroup_1(), "rule__HttpClient__Group_1__0");
			builder.put(grammarAccess.getHttpClientAccess().getGroup_2(), "rule__HttpClient__Group_2__0");
			builder.put(grammarAccess.getHttpClientAccess().getGroup_3(), "rule__HttpClient__Group_3__0");
			builder.put(grammarAccess.getHttpClientAceAccess().getGroup(), "rule__HttpClientAce__Group__0");
			builder.put(grammarAccess.getHttpClientAceAccess().getGroup_2(), "rule__HttpClientAce__Group_2__0");
			builder.put(grammarAccess.getHttpClientAceAccess().getGroup_2_2(), "rule__HttpClientAce__Group_2_2__0");
			builder.put(grammarAccess.getHttpClientAceAccess().getGroup_3(), "rule__HttpClientAce__Group_3__0");
			builder.put(grammarAccess.getHttpClientAceAccess().getGroup_3_3(), "rule__HttpClientAce__Group_3_3__0");
			builder.put(grammarAccess.getHttpClientAceAccess().getGroup_4(), "rule__HttpClientAce__Group_4__0");
			builder.put(grammarAccess.getHttpClientAceAccess().getGroup_5(), "rule__HttpClientAce__Group_5__0");
			builder.put(grammarAccess.getFromAppStateRefAccess().getGroup(), "rule__FromAppStateRef__Group__0");
			builder.put(grammarAccess.getFromAppStateRefAccess().getGroup_1(), "rule__FromAppStateRef__Group_1__0");
			builder.put(grammarAccess.getHttpClientOutcomeAccess().getGroup(), "rule__HttpClientOutcome__Group__0");
			builder.put(grammarAccess.getHttpClientOutcomeAccess().getGroup_2(), "rule__HttpClientOutcome__Group_2__0");
			builder.put(grammarAccess.getHttpClientOutcomeAccess().getGroup_3(), "rule__HttpClientOutcome__Group_3__0");
			builder.put(grammarAccess.getTriggerdAceOperationAccess().getGroup(), "rule__TriggerdAceOperation__Group__0");
			builder.put(grammarAccess.getTriggerdAceOperationAccess().getGroup_0(), "rule__TriggerdAceOperation__Group_0__0");
			builder.put(grammarAccess.getHttpClientStateFunctionAccess().getGroup(), "rule__HttpClientStateFunction__Group__0");
			builder.put(grammarAccess.getClientAttributeAccess().getGroup_1(), "rule__ClientAttribute__Group_1__0");
			builder.put(grammarAccess.getSingleClientAttributeAccess().getGroup(), "rule__SingleClientAttribute__Group__0");
			builder.put(grammarAccess.getSingleClientAttributeAccess().getGroup_5(), "rule__SingleClientAttribute__Group_5__0");
			builder.put(grammarAccess.getGroupedClientAttributeAccess().getGroup(), "rule__GroupedClientAttribute__Group__0");
			builder.put(grammarAccess.getClientScenarioAccess().getGroup(), "rule__ClientScenario__Group__0");
			builder.put(grammarAccess.getClientScenarioAccess().getGroup_1(), "rule__ClientScenario__Group_1__0");
			builder.put(grammarAccess.getClientScenarioAccess().getGroup_4(), "rule__ClientScenario__Group_4__0");
			builder.put(grammarAccess.getClientWhenBlockAccess().getGroup(), "rule__ClientWhenBlock__Group__0");
			builder.put(grammarAccess.getClientWhenBlockAccess().getGroup_1(), "rule__ClientWhenBlock__Group_1__0");
			builder.put(grammarAccess.getClientWhenBlockAccess().getGroup_1_1(), "rule__ClientWhenBlock__Group_1_1__0");
			builder.put(grammarAccess.getClientWhenBlockAccess().getGroup_1_1_1(), "rule__ClientWhenBlock__Group_1_1_1__0");
			builder.put(grammarAccess.getClientWhenBlockAccess().getGroup_2(), "rule__ClientWhenBlock__Group_2__0");
			builder.put(grammarAccess.getClientWhenBlockAccess().getGroup_2_2(), "rule__ClientWhenBlock__Group_2_2__0");
			builder.put(grammarAccess.getSquishyValueAccess().getGroup(), "rule__SquishyValue__Group__0");
			builder.put(grammarAccess.getSquishyValueAccess().getGroup_2(), "rule__SquishyValue__Group_2__0");
			builder.put(grammarAccess.getSquishyValueAccess().getGroup_2_2(), "rule__SquishyValue__Group_2_2__0");
			builder.put(grammarAccess.getSquishyValueAccess().getGroup_2_3(), "rule__SquishyValue__Group_2_3__0");
			builder.put(grammarAccess.getSquishyValueAccess().getGroup_2_4(), "rule__SquishyValue__Group_2_4__0");
			builder.put(grammarAccess.getInputValueAccess().getGroup(), "rule__InputValue__Group__0");
			builder.put(grammarAccess.getClientThenBlockAccess().getGroup(), "rule__ClientThenBlock__Group__0");
			builder.put(grammarAccess.getClientThenBlockAccess().getGroup_1(), "rule__ClientThenBlock__Group_1__0");
			builder.put(grammarAccess.getClientThenBlockAccess().getGroup_2(), "rule__ClientThenBlock__Group_2__0");
			builder.put(grammarAccess.getStateVerificationAccess().getGroup(), "rule__StateVerification__Group__0");
			builder.put(grammarAccess.getJsonObjectClientAccess().getGroup(), "rule__JsonObjectClient__Group__0");
			builder.put(grammarAccess.getJsonObjectClientAccess().getGroup_3(), "rule__JsonObjectClient__Group_3__0");
			builder.put(grammarAccess.getJsonMemberClientAccess().getGroup(), "rule__JsonMemberClient__Group__0");
			builder.put(grammarAccess.getJsonArrayClientAccess().getGroup(), "rule__JsonArrayClient__Group__0");
			builder.put(grammarAccess.getJsonArrayClientAccess().getGroup_3(), "rule__JsonArrayClient__Group_3__0");
			builder.put(grammarAccess.getHttpServerAccess().getGroup(), "rule__HttpServer__Group__0");
			builder.put(grammarAccess.getHttpServerAccess().getGroup_5(), "rule__HttpServer__Group_5__0");
			builder.put(grammarAccess.getHttpServerAccess().getGroup_6(), "rule__HttpServer__Group_6__0");
			builder.put(grammarAccess.getHttpServerAccess().getGroup_7(), "rule__HttpServer__Group_7__0");
			builder.put(grammarAccess.getHttpServerAccess().getGroup_8(), "rule__HttpServer__Group_8__0");
			builder.put(grammarAccess.getHttpServerAccess().getGroup_9(), "rule__HttpServer__Group_9__0");
			builder.put(grammarAccess.getHttpServerAccess().getGroup_10(), "rule__HttpServer__Group_10__0");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getGroup(), "rule__HttpServerAceWrite__Group__0");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getGroup_7(), "rule__HttpServerAceWrite__Group_7__0");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getGroup_8(), "rule__HttpServerAceWrite__Group_8__0");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getGroup_9(), "rule__HttpServerAceWrite__Group_9__0");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getGroup_10(), "rule__HttpServerAceWrite__Group_10__0");
			builder.put(grammarAccess.getHttpServerOutcomeAccess().getGroup(), "rule__HttpServerOutcome__Group__0");
			builder.put(grammarAccess.getHttpServerOutcomeAccess().getGroup_2(), "rule__HttpServerOutcome__Group_2__0");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getGroup(), "rule__HttpServerAceRead__Group__0");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getGroup_7(), "rule__HttpServerAceRead__Group_7__0");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getGroup_8(), "rule__HttpServerAceRead__Group_8__0");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getGroup_9(), "rule__HttpServerAceRead__Group_9__0");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getGroup_10(), "rule__HttpServerAceRead__Group_10__0");
			builder.put(grammarAccess.getAttributeParamRefAccess().getGroup(), "rule__AttributeParamRef__Group__0");
			builder.put(grammarAccess.getHttpServerViewAccess().getGroup(), "rule__HttpServerView__Group__0");
			builder.put(grammarAccess.getHttpServerViewAccess().getGroup_2(), "rule__HttpServerView__Group_2__0");
			builder.put(grammarAccess.getHttpServerViewFunctionAccess().getGroup(), "rule__HttpServerViewFunction__Group__0");
			builder.put(grammarAccess.getAuthUserAccess().getGroup(), "rule__AuthUser__Group__0");
			builder.put(grammarAccess.getAuthUserAccess().getGroup_1(), "rule__AuthUser__Group_1__0");
			builder.put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
			builder.put(grammarAccess.getModelAccess().getGroup_2(), "rule__Model__Group_2__0");
			builder.put(grammarAccess.getModelAccess().getGroup_2_2(), "rule__Model__Group_2_2__0");
			builder.put(grammarAccess.getModelAccess().getGroup_3(), "rule__Model__Group_3__0");
			builder.put(grammarAccess.getScenarioAccess().getGroup(), "rule__Scenario__Group__0");
			builder.put(grammarAccess.getScenarioAccess().getGroup_1(), "rule__Scenario__Group_1__0");
			builder.put(grammarAccess.getCustomCallAccess().getGroup(), "rule__CustomCall__Group__0");
			builder.put(grammarAccess.getCustomCallAccess().getGroup_2(), "rule__CustomCall__Group_2__0");
			builder.put(grammarAccess.getCustomCallAccess().getGroup_2_1(), "rule__CustomCall__Group_2_1__0");
			builder.put(grammarAccess.getCustomCallAccess().getGroup_4(), "rule__CustomCall__Group_4__0");
			builder.put(grammarAccess.getGivenRefAccess().getGroup(), "rule__GivenRef__Group__0");
			builder.put(grammarAccess.getGivenRefAccess().getGroup_1(), "rule__GivenRef__Group_1__0");
			builder.put(grammarAccess.getWhenBlockAccess().getGroup(), "rule__WhenBlock__Group__0");
			builder.put(grammarAccess.getThenBlockAccess().getGroup(), "rule__ThenBlock__Group__0");
			builder.put(grammarAccess.getThenBlockAccess().getGroup_1(), "rule__ThenBlock__Group_1__0");
			builder.put(grammarAccess.getThenBlockAccess().getGroup_2(), "rule__ThenBlock__Group_2__0");
			builder.put(grammarAccess.getThenBlockAccess().getGroup_3(), "rule__ThenBlock__Group_3__0");
			builder.put(grammarAccess.getPersistenceVerificationAccess().getGroup(), "rule__PersistenceVerification__Group__0");
			builder.put(grammarAccess.getSelectByPrimaryKeysAccess().getGroup(), "rule__SelectByPrimaryKeys__Group__0");
			builder.put(grammarAccess.getSelectByPrimaryKeysAccess().getGroup_3(), "rule__SelectByPrimaryKeys__Group_3__0");
			builder.put(grammarAccess.getSelectByUniqueAttributeAccess().getGroup(), "rule__SelectByUniqueAttribute__Group__0");
			builder.put(grammarAccess.getCountAccess().getGroup(), "rule__Count__Group__0");
			builder.put(grammarAccess.getCountAccess().getGroup_3(), "rule__Count__Group_3__0");
			builder.put(grammarAccess.getAttributeAndValueAccess().getGroup(), "rule__AttributeAndValue__Group__0");
			builder.put(grammarAccess.getExtractionAccess().getGroup(), "rule__Extraction__Group__0");
			builder.put(grammarAccess.getDataDefinitionAccess().getGroup(), "rule__DataDefinition__Group__0");
			builder.put(grammarAccess.getDataDefinitionAccess().getGroup_1(), "rule__DataDefinition__Group_1__0");
			builder.put(grammarAccess.getDataDefinitionAccess().getGroup_2(), "rule__DataDefinition__Group_2__0");
			builder.put(grammarAccess.getAuthorizationAccess().getGroup(), "rule__Authorization__Group__0");
			builder.put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
			builder.put(grammarAccess.getAttributeAccess().getGroup_6(), "rule__Attribute__Group_6__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getJsonObjectAccess().getGroup_1(), "rule__JsonObject__Group_1__0");
			builder.put(grammarAccess.getJsonObjectAceAccess().getGroup(), "rule__JsonObjectAce__Group__0");
			builder.put(grammarAccess.getJsonObjectAceAccess().getGroup_3(), "rule__JsonObjectAce__Group_3__0");
			builder.put(grammarAccess.getJsonMemberAccess().getGroup(), "rule__JsonMember__Group__0");
			builder.put(grammarAccess.getJsonArrayAccess().getGroup(), "rule__JsonArray__Group__0");
			builder.put(grammarAccess.getJsonArrayAccess().getGroup_3(), "rule__JsonArray__Group_3__0");
			builder.put(grammarAccess.getJsonDateTimeAccess().getGroup(), "rule__JsonDateTime__Group__0");
			builder.put(grammarAccess.getProjectAccess().getHttpClientAssignment_1_0_1(), "rule__Project__HttpClientAssignment_1_0_1");
			builder.put(grammarAccess.getProjectAccess().getHttpServerAssignment_1_1_1(), "rule__Project__HttpServerAssignment_1_1_1");
			builder.put(grammarAccess.getHttpClientAccess().getNameAssignment_0(), "rule__HttpClient__NameAssignment_0");
			builder.put(grammarAccess.getHttpClientAccess().getAceOperationsAssignment_1_1(), "rule__HttpClient__AceOperationsAssignment_1_1");
			builder.put(grammarAccess.getHttpClientAccess().getReact16_8Assignment_2_1(), "rule__HttpClient__React16_8Assignment_2_1");
			builder.put(grammarAccess.getHttpClientAccess().getContainerAssignment_2_2(), "rule__HttpClient__ContainerAssignment_2_2");
			builder.put(grammarAccess.getHttpClientAccess().getScenariosAssignment_3_1(), "rule__HttpClient__ScenariosAssignment_3_1");
			builder.put(grammarAccess.getHttpClientAceAccess().getAsyncAssignment_0(), "rule__HttpClientAce__AsyncAssignment_0");
			builder.put(grammarAccess.getHttpClientAceAccess().getNameAssignment_1(), "rule__HttpClientAce__NameAssignment_1");
			builder.put(grammarAccess.getHttpClientAceAccess().getInputAssignment_2_1(), "rule__HttpClientAce__InputAssignment_2_1");
			builder.put(grammarAccess.getHttpClientAceAccess().getInputAssignment_2_2_1(), "rule__HttpClientAce__InputAssignment_2_2_1");
			builder.put(grammarAccess.getHttpClientAceAccess().getRefsAssignment_3_2(), "rule__HttpClientAce__RefsAssignment_3_2");
			builder.put(grammarAccess.getHttpClientAceAccess().getRefsAssignment_3_3_1(), "rule__HttpClientAce__RefsAssignment_3_3_1");
			builder.put(grammarAccess.getHttpClientAceAccess().getServerCallAssignment_4_1(), "rule__HttpClientAce__ServerCallAssignment_4_1");
			builder.put(grammarAccess.getHttpClientAceAccess().getLoadingFlagAssignment_5_1(), "rule__HttpClientAce__LoadingFlagAssignment_5_1");
			builder.put(grammarAccess.getHttpClientAceAccess().getOutcomesAssignment_6(), "rule__HttpClientAce__OutcomesAssignment_6");
			builder.put(grammarAccess.getFromAppStateRefAccess().getStateElementAssignment_0(), "rule__FromAppStateRef__StateElementAssignment_0");
			builder.put(grammarAccess.getFromAppStateRefAccess().getVarNameAssignment_1_1(), "rule__FromAppStateRef__VarNameAssignment_1_1");
			builder.put(grammarAccess.getInputAccess().getNameAssignment(), "rule__Input__NameAssignment");
			builder.put(grammarAccess.getHttpClientOutcomeAccess().getNameAssignment_1(), "rule__HttpClientOutcome__NameAssignment_1");
			builder.put(grammarAccess.getHttpClientOutcomeAccess().getListenersAssignment_2_1(), "rule__HttpClientOutcome__ListenersAssignment_2_1");
			builder.put(grammarAccess.getHttpClientOutcomeAccess().getTriggerdAceOperationsAssignment_3_2(), "rule__HttpClientOutcome__TriggerdAceOperationsAssignment_3_2");
			builder.put(grammarAccess.getTriggerdAceOperationAccess().getDelayAssignment_0_1(), "rule__TriggerdAceOperation__DelayAssignment_0_1");
			builder.put(grammarAccess.getTriggerdAceOperationAccess().getTakeLatestAssignment_0_2(), "rule__TriggerdAceOperation__TakeLatestAssignment_0_2");
			builder.put(grammarAccess.getTriggerdAceOperationAccess().getAceOperationAssignment_1(), "rule__TriggerdAceOperation__AceOperationAssignment_1");
			builder.put(grammarAccess.getHttpClientStateFunctionAccess().getStateFunctionTypeAssignment_0(), "rule__HttpClientStateFunction__StateFunctionTypeAssignment_0");
			builder.put(grammarAccess.getHttpClientStateFunctionAccess().getStateElementAssignment_1(), "rule__HttpClientStateFunction__StateElementAssignment_1");
			builder.put(grammarAccess.getSingleClientAttributeAccess().getNoComponentAssignment_0(), "rule__SingleClientAttribute__NoComponentAssignment_0");
			builder.put(grammarAccess.getSingleClientAttributeAccess().getListAssignment_1(), "rule__SingleClientAttribute__ListAssignment_1");
			builder.put(grammarAccess.getSingleClientAttributeAccess().getNameAssignment_2(), "rule__SingleClientAttribute__NameAssignment_2");
			builder.put(grammarAccess.getSingleClientAttributeAccess().getHashAssignment_3(), "rule__SingleClientAttribute__HashAssignment_3");
			builder.put(grammarAccess.getSingleClientAttributeAccess().getStorageAssignment_4(), "rule__SingleClientAttribute__StorageAssignment_4");
			builder.put(grammarAccess.getSingleClientAttributeAccess().getAttributesAssignment_5_1(), "rule__SingleClientAttribute__AttributesAssignment_5_1");
			builder.put(grammarAccess.getGroupedClientAttributeAccess().getNameAssignment_0(), "rule__GroupedClientAttribute__NameAssignment_0");
			builder.put(grammarAccess.getGroupedClientAttributeAccess().getAttributeGroupAssignment_2(), "rule__GroupedClientAttribute__AttributeGroupAssignment_2");
			builder.put(grammarAccess.getGroupedClientAttributeAccess().getAttributeGroupAssignment_3(), "rule__GroupedClientAttribute__AttributeGroupAssignment_3");
			builder.put(grammarAccess.getClientScenarioAccess().getNameAssignment_0(), "rule__ClientScenario__NameAssignment_0");
			builder.put(grammarAccess.getClientScenarioAccess().getGivenRefsAssignment_1_1(), "rule__ClientScenario__GivenRefsAssignment_1_1");
			builder.put(grammarAccess.getClientScenarioAccess().getWhenBlockAssignment_3(), "rule__ClientScenario__WhenBlockAssignment_3");
			builder.put(grammarAccess.getClientScenarioAccess().getDelayInMillisAssignment_4_1(), "rule__ClientScenario__DelayInMillisAssignment_4_1");
			builder.put(grammarAccess.getClientScenarioAccess().getThenBlockAssignment_6(), "rule__ClientScenario__ThenBlockAssignment_6");
			builder.put(grammarAccess.getClientGivenRefAccess().getScenarioAssignment(), "rule__ClientGivenRef__ScenarioAssignment");
			builder.put(grammarAccess.getClientWhenBlockAccess().getActionAssignment_0(), "rule__ClientWhenBlock__ActionAssignment_0");
			builder.put(grammarAccess.getClientWhenBlockAccess().getInputValuesAssignment_1_1_0(), "rule__ClientWhenBlock__InputValuesAssignment_1_1_0");
			builder.put(grammarAccess.getClientWhenBlockAccess().getInputValuesAssignment_1_1_1_1(), "rule__ClientWhenBlock__InputValuesAssignment_1_1_1_1");
			builder.put(grammarAccess.getClientWhenBlockAccess().getSquishyValuesAssignment_2_1(), "rule__ClientWhenBlock__SquishyValuesAssignment_2_1");
			builder.put(grammarAccess.getClientWhenBlockAccess().getSquishyValuesAssignment_2_2_1(), "rule__ClientWhenBlock__SquishyValuesAssignment_2_2_1");
			builder.put(grammarAccess.getSquishyValueAccess().getUuidAssignment_2_1(), "rule__SquishyValue__UuidAssignment_2_1");
			builder.put(grammarAccess.getSquishyValueAccess().getClientSystemTimeAssignment_2_2_1(), "rule__SquishyValue__ClientSystemTimeAssignment_2_2_1");
			builder.put(grammarAccess.getSquishyValueAccess().getServerSystemTimeAssignment_2_3_1(), "rule__SquishyValue__ServerSystemTimeAssignment_2_3_1");
			builder.put(grammarAccess.getSquishyValueAccess().getAttributeAssignment_2_4_1(), "rule__SquishyValue__AttributeAssignment_2_4_1");
			builder.put(grammarAccess.getSquishyValueAccess().getValueAssignment_2_4_3(), "rule__SquishyValue__ValueAssignment_2_4_3");
			builder.put(grammarAccess.getInputValueAccess().getInputAssignment_0(), "rule__InputValue__InputAssignment_0");
			builder.put(grammarAccess.getInputValueAccess().getValueAssignment_2(), "rule__InputValue__ValueAssignment_2");
			builder.put(grammarAccess.getClientThenBlockAccess().getStateVerificationsAssignment_1_1(), "rule__ClientThenBlock__StateVerificationsAssignment_1_1");
			builder.put(grammarAccess.getClientThenBlockAccess().getVerificationsAssignment_2_1(), "rule__ClientThenBlock__VerificationsAssignment_2_1");
			builder.put(grammarAccess.getStateVerificationAccess().getNameAssignment_0(), "rule__StateVerification__NameAssignment_0");
			builder.put(grammarAccess.getStateVerificationAccess().getStateRefAssignment_1(), "rule__StateVerification__StateRefAssignment_1");
			builder.put(grammarAccess.getStateVerificationAccess().getValueAssignment_3(), "rule__StateVerification__ValueAssignment_3");
			builder.put(grammarAccess.getJsonObjectClientAccess().getMembersAssignment_2(), "rule__JsonObjectClient__MembersAssignment_2");
			builder.put(grammarAccess.getJsonObjectClientAccess().getMembersAssignment_3_1(), "rule__JsonObjectClient__MembersAssignment_3_1");
			builder.put(grammarAccess.getJsonMemberClientAccess().getAttributeAssignment_0(), "rule__JsonMemberClient__AttributeAssignment_0");
			builder.put(grammarAccess.getJsonMemberClientAccess().getValueAssignment_2(), "rule__JsonMemberClient__ValueAssignment_2");
			builder.put(grammarAccess.getJsonArrayClientAccess().getValuesAssignment_2(), "rule__JsonArrayClient__ValuesAssignment_2");
			builder.put(grammarAccess.getJsonArrayClientAccess().getValuesAssignment_3_1(), "rule__JsonArrayClient__ValuesAssignment_3_1");
			builder.put(grammarAccess.getHttpServerAccess().getLanguageAssignment_0(), "rule__HttpServer__LanguageAssignment_0");
			builder.put(grammarAccess.getHttpServerAccess().getTypeAssignment_1(), "rule__HttpServer__TypeAssignment_1");
			builder.put(grammarAccess.getHttpServerAccess().getPersistenceLayerAssignment_2(), "rule__HttpServer__PersistenceLayerAssignment_2");
			builder.put(grammarAccess.getHttpServerAccess().getMigrationsAssignment_3(), "rule__HttpServer__MigrationsAssignment_3");
			builder.put(grammarAccess.getHttpServerAccess().getNameAssignment_4(), "rule__HttpServer__NameAssignment_4");
			builder.put(grammarAccess.getHttpServerAccess().getAuthUserAssignment_5_1(), "rule__HttpServer__AuthUserAssignment_5_1");
			builder.put(grammarAccess.getHttpServerAccess().getAuthUserRefAssignment_6_1(), "rule__HttpServer__AuthUserRefAssignment_6_1");
			builder.put(grammarAccess.getHttpServerAccess().getAceOperationsAssignment_7_1(), "rule__HttpServer__AceOperationsAssignment_7_1");
			builder.put(grammarAccess.getHttpServerAccess().getViewsAssignment_8_1(), "rule__HttpServer__ViewsAssignment_8_1");
			builder.put(grammarAccess.getHttpServerAccess().getModelsAssignment_9_1(), "rule__HttpServer__ModelsAssignment_9_1");
			builder.put(grammarAccess.getHttpServerAccess().getScenariosAssignment_10_1(), "rule__HttpServer__ScenariosAssignment_10_1");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getNameAssignment_0(), "rule__HttpServerAceWrite__NameAssignment_0");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getModelAssignment_2(), "rule__HttpServerAceWrite__ModelAssignment_2");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getTypeAssignment_4(), "rule__HttpServerAceWrite__TypeAssignment_4");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getUrlAssignment_5(), "rule__HttpServerAceWrite__UrlAssignment_5");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getAuthorizeAssignment_6(), "rule__HttpServerAceWrite__AuthorizeAssignment_6");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getPathParamsAssignment_7_1(), "rule__HttpServerAceWrite__PathParamsAssignment_7_1");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getQueryParamsAssignment_8_1(), "rule__HttpServerAceWrite__QueryParamsAssignment_8_1");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getPayloadAssignment_9_1(), "rule__HttpServerAceWrite__PayloadAssignment_9_1");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getResponseAssignment_10_1(), "rule__HttpServerAceWrite__ResponseAssignment_10_1");
			builder.put(grammarAccess.getHttpServerAceWriteAccess().getOutcomesAssignment_11(), "rule__HttpServerAceWrite__OutcomesAssignment_11");
			builder.put(grammarAccess.getHttpServerOutcomeAccess().getNameAssignment_1(), "rule__HttpServerOutcome__NameAssignment_1");
			builder.put(grammarAccess.getHttpServerOutcomeAccess().getListenersAssignment_2_1(), "rule__HttpServerOutcome__ListenersAssignment_2_1");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getNameAssignment_0(), "rule__HttpServerAceRead__NameAssignment_0");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getModelAssignment_2(), "rule__HttpServerAceRead__ModelAssignment_2");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getTypeAssignment_4(), "rule__HttpServerAceRead__TypeAssignment_4");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getUrlAssignment_5(), "rule__HttpServerAceRead__UrlAssignment_5");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getAuthorizeAssignment_6(), "rule__HttpServerAceRead__AuthorizeAssignment_6");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getPathParamsAssignment_7_1(), "rule__HttpServerAceRead__PathParamsAssignment_7_1");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getQueryParamsAssignment_8_1(), "rule__HttpServerAceRead__QueryParamsAssignment_8_1");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getPayloadAssignment_9_1(), "rule__HttpServerAceRead__PayloadAssignment_9_1");
			builder.put(grammarAccess.getHttpServerAceReadAccess().getResponseAssignment_10_1(), "rule__HttpServerAceRead__ResponseAssignment_10_1");
			builder.put(grammarAccess.getAttributeParamRefAccess().getNotNullAssignment_0(), "rule__AttributeParamRef__NotNullAssignment_0");
			builder.put(grammarAccess.getAttributeParamRefAccess().getAttributeAssignment_1(), "rule__AttributeParamRef__AttributeAssignment_1");
			builder.put(grammarAccess.getHttpServerViewAccess().getAfterCommitAssignment_0(), "rule__HttpServerView__AfterCommitAssignment_0");
			builder.put(grammarAccess.getHttpServerViewAccess().getNameAssignment_1(), "rule__HttpServerView__NameAssignment_1");
			builder.put(grammarAccess.getHttpServerViewAccess().getRenderFunctionsAssignment_2_1(), "rule__HttpServerView__RenderFunctionsAssignment_2_1");
			builder.put(grammarAccess.getHttpServerViewFunctionAccess().getNameAssignment_0(), "rule__HttpServerViewFunction__NameAssignment_0");
			builder.put(grammarAccess.getHttpServerViewFunctionAccess().getModelAssignment_2(), "rule__HttpServerViewFunction__ModelAssignment_2");
			builder.put(grammarAccess.getAuthUserAccess().getNameAssignment_0(), "rule__AuthUser__NameAssignment_0");
			builder.put(grammarAccess.getAuthUserAccess().getAttributesAssignment_1_1(), "rule__AuthUser__AttributesAssignment_1_1");
			builder.put(grammarAccess.getModelAccess().getPersistentAssignment_0(), "rule__Model__PersistentAssignment_0");
			builder.put(grammarAccess.getModelAccess().getNameAssignment_1(), "rule__Model__NameAssignment_1");
			builder.put(grammarAccess.getModelAccess().getSuperModelsAssignment_2_1(), "rule__Model__SuperModelsAssignment_2_1");
			builder.put(grammarAccess.getModelAccess().getSuperModelsAssignment_2_2_1(), "rule__Model__SuperModelsAssignment_2_2_1");
			builder.put(grammarAccess.getModelAccess().getAttributesAssignment_3_1(), "rule__Model__AttributesAssignment_3_1");
			builder.put(grammarAccess.getScenarioAccess().getNameAssignment_0(), "rule__Scenario__NameAssignment_0");
			builder.put(grammarAccess.getScenarioAccess().getGivenItemsAssignment_1_1(), "rule__Scenario__GivenItemsAssignment_1_1");
			builder.put(grammarAccess.getScenarioAccess().getWhenBlockAssignment_3(), "rule__Scenario__WhenBlockAssignment_3");
			builder.put(grammarAccess.getScenarioAccess().getThenBlockAssignment_5(), "rule__Scenario__ThenBlockAssignment_5");
			builder.put(grammarAccess.getCustomCallAccess().getCustomCallNameAssignment_0(), "rule__CustomCall__CustomCallNameAssignment_0");
			builder.put(grammarAccess.getCustomCallAccess().getValuesAssignment_2_0(), "rule__CustomCall__ValuesAssignment_2_0");
			builder.put(grammarAccess.getCustomCallAccess().getValuesAssignment_2_1_1(), "rule__CustomCall__ValuesAssignment_2_1_1");
			builder.put(grammarAccess.getCustomCallAccess().getTimesAssignment_4_0(), "rule__CustomCall__TimesAssignment_4_0");
			builder.put(grammarAccess.getGivenRefAccess().getScenarioAssignment_0(), "rule__GivenRef__ScenarioAssignment_0");
			builder.put(grammarAccess.getGivenRefAccess().getTimesAssignment_1_0(), "rule__GivenRef__TimesAssignment_1_0");
			builder.put(grammarAccess.getGivenRefAccess().getExcludeGivenAssignment_2(), "rule__GivenRef__ExcludeGivenAssignment_2");
			builder.put(grammarAccess.getWhenBlockAccess().getActionAssignment_0(), "rule__WhenBlock__ActionAssignment_0");
			builder.put(grammarAccess.getWhenBlockAccess().getDataDefinitionAssignment_1(), "rule__WhenBlock__DataDefinitionAssignment_1");
			builder.put(grammarAccess.getWhenBlockAccess().getAuthorizationAssignment_2(), "rule__WhenBlock__AuthorizationAssignment_2");
			builder.put(grammarAccess.getWhenBlockAccess().getExtractionsAssignment_3(), "rule__WhenBlock__ExtractionsAssignment_3");
			builder.put(grammarAccess.getThenBlockAccess().getStatusCodeAssignment_0(), "rule__ThenBlock__StatusCodeAssignment_0");
			builder.put(grammarAccess.getThenBlockAccess().getResponseAssignment_1_2(), "rule__ThenBlock__ResponseAssignment_1_2");
			builder.put(grammarAccess.getThenBlockAccess().getPersistenceVerificationsAssignment_2_1(), "rule__ThenBlock__PersistenceVerificationsAssignment_2_1");
			builder.put(grammarAccess.getThenBlockAccess().getVerificationsAssignment_3_1(), "rule__ThenBlock__VerificationsAssignment_3_1");
			builder.put(grammarAccess.getPersistenceVerificationAccess().getNameAssignment_0(), "rule__PersistenceVerification__NameAssignment_0");
			builder.put(grammarAccess.getPersistenceVerificationAccess().getModelAssignment_1(), "rule__PersistenceVerification__ModelAssignment_1");
			builder.put(grammarAccess.getPersistenceVerificationAccess().getExpressionAssignment_2(), "rule__PersistenceVerification__ExpressionAssignment_2");
			builder.put(grammarAccess.getSelectByPrimaryKeysAccess().getAttributeAndValuesAssignment_2(), "rule__SelectByPrimaryKeys__AttributeAndValuesAssignment_2");
			builder.put(grammarAccess.getSelectByPrimaryKeysAccess().getAttributeAndValuesAssignment_3_1(), "rule__SelectByPrimaryKeys__AttributeAndValuesAssignment_3_1");
			builder.put(grammarAccess.getSelectByPrimaryKeysAccess().getExpectedAssignment_6(), "rule__SelectByPrimaryKeys__ExpectedAssignment_6");
			builder.put(grammarAccess.getSelectByUniqueAttributeAccess().getAttributeAndValueAssignment_2(), "rule__SelectByUniqueAttribute__AttributeAndValueAssignment_2");
			builder.put(grammarAccess.getSelectByUniqueAttributeAccess().getExpectedAssignment_5(), "rule__SelectByUniqueAttribute__ExpectedAssignment_5");
			builder.put(grammarAccess.getCountAccess().getAttributeAndValuesAssignment_2(), "rule__Count__AttributeAndValuesAssignment_2");
			builder.put(grammarAccess.getCountAccess().getAttributeAndValuesAssignment_3_1(), "rule__Count__AttributeAndValuesAssignment_3_1");
			builder.put(grammarAccess.getCountAccess().getExpectedAssignment_6(), "rule__Count__ExpectedAssignment_6");
			builder.put(grammarAccess.getAttributeAndValueAccess().getAttributeAssignment_0(), "rule__AttributeAndValue__AttributeAssignment_0");
			builder.put(grammarAccess.getAttributeAndValueAccess().getValueAssignment_2(), "rule__AttributeAndValue__ValueAssignment_2");
			builder.put(grammarAccess.getVerificationAccess().getNameAssignment(), "rule__Verification__NameAssignment");
			builder.put(grammarAccess.getExtractionAccess().getNameAssignment_1(), "rule__Extraction__NameAssignment_1");
			builder.put(grammarAccess.getSelectByExpectationAccess().getObjectAssignment_0(), "rule__SelectByExpectation__ObjectAssignment_0");
			builder.put(grammarAccess.getSelectByExpectationAccess().getIsNotNullAssignment_1(), "rule__SelectByExpectation__IsNotNullAssignment_1");
			builder.put(grammarAccess.getSelectByExpectationAccess().getIsNullAssignment_2(), "rule__SelectByExpectation__IsNullAssignment_2");
			builder.put(grammarAccess.getDataDefinitionAccess().getUuidAssignment_1_1(), "rule__DataDefinition__UuidAssignment_1_1");
			builder.put(grammarAccess.getDataDefinitionAccess().getSystemtimeAssignment_2_1(), "rule__DataDefinition__SystemtimeAssignment_2_1");
			builder.put(grammarAccess.getDataDefinitionAccess().getPatternAssignment_2_2(), "rule__DataDefinition__PatternAssignment_2_2");
			builder.put(grammarAccess.getDataDefinitionAccess().getDataAssignment_3(), "rule__DataDefinition__DataAssignment_3");
			builder.put(grammarAccess.getAuthorizationAccess().getUsernameAssignment_1(), "rule__Authorization__UsernameAssignment_1");
			builder.put(grammarAccess.getAuthorizationAccess().getPasswordAssignment_3(), "rule__Authorization__PasswordAssignment_3");
			builder.put(grammarAccess.getAttributeAccess().getUniqueAssignment_0(), "rule__Attribute__UniqueAssignment_0");
			builder.put(grammarAccess.getAttributeAccess().getPrimaryKeyAssignment_1(), "rule__Attribute__PrimaryKeyAssignment_1");
			builder.put(grammarAccess.getAttributeAccess().getNotNullAssignment_2(), "rule__Attribute__NotNullAssignment_2");
			builder.put(grammarAccess.getAttributeAccess().getListAssignment_3(), "rule__Attribute__ListAssignment_3");
			builder.put(grammarAccess.getAttributeAccess().getTypeAssignment_4_0(), "rule__Attribute__TypeAssignment_4_0");
			builder.put(grammarAccess.getAttributeAccess().getModelAssignment_4_1(), "rule__Attribute__ModelAssignment_4_1");
			builder.put(grammarAccess.getAttributeAccess().getNameAssignment_5(), "rule__Attribute__NameAssignment_5");
			builder.put(grammarAccess.getAttributeAccess().getForeignKeyAssignment_6_1(), "rule__Attribute__ForeignKeyAssignment_6_1");
			builder.put(grammarAccess.getAttributeAccess().getSquishyAssignment_7(), "rule__Attribute__SquishyAssignment_7");
			builder.put(grammarAccess.getJsonObjectAceAccess().getMembersAssignment_2(), "rule__JsonObjectAce__MembersAssignment_2");
			builder.put(grammarAccess.getJsonObjectAceAccess().getMembersAssignment_3_1(), "rule__JsonObjectAce__MembersAssignment_3_1");
			builder.put(grammarAccess.getJsonMemberAccess().getAttributeAssignment_0(), "rule__JsonMember__AttributeAssignment_0");
			builder.put(grammarAccess.getJsonMemberAccess().getValueAssignment_2(), "rule__JsonMember__ValueAssignment_2");
			builder.put(grammarAccess.getJsonArrayAccess().getValuesAssignment_2(), "rule__JsonArray__ValuesAssignment_2");
			builder.put(grammarAccess.getJsonArrayAccess().getValuesAssignment_3_1(), "rule__JsonArray__ValuesAssignment_3_1");
			builder.put(grammarAccess.getJsonDateTimeAccess().getDateTimeAssignment_0(), "rule__JsonDateTime__DateTimeAssignment_0");
			builder.put(grammarAccess.getJsonDateTimeAccess().getPatternAssignment_1(), "rule__JsonDateTime__PatternAssignment_1");
			builder.put(grammarAccess.getStringTypeAccess().getStringAssignment(), "rule__StringType__StringAssignment");
			builder.put(grammarAccess.getBooleanTypeAccess().getBooleanAssignment(), "rule__BooleanType__BooleanAssignment");
			builder.put(grammarAccess.getNullTypeAccess().getNullAssignment(), "rule__NullType__NullAssignment");
			builder.put(grammarAccess.getUndefinedTypeAccess().getUndefinedAssignment(), "rule__UndefinedType__UndefinedAssignment");
			builder.put(grammarAccess.getLongTypeAccess().getLongAssignment(), "rule__LongType__LongAssignment");
			builder.put(grammarAccess.getPrimitiveValueAccess().getStringAssignment_0(), "rule__PrimitiveValue__StringAssignment_0");
			builder.put(grammarAccess.getPrimitiveValueAccess().getLongAssignment_1(), "rule__PrimitiveValue__LongAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private AceGenGrammarAccess grammarAccess;

	@Override
	protected InternalAceGenParser createParser() {
		InternalAceGenParser result = new InternalAceGenParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public AceGenGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(AceGenGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
