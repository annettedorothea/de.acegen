package de.acegen.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAceGenLexer extends Lexer {
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

    public InternalAceGenLexer() {;} 
    public InternalAceGenLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalAceGenLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalAceGen.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:11:7: ( 'GET' )
            // InternalAceGen.g:11:9: 'GET'
            {
            match("GET"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:12:7: ( 'set' )
            // InternalAceGen.g:12:9: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:13:7: ( 'merge' )
            // InternalAceGen.g:13:9: 'merge'
            {
            match("merge"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:14:7: ( 'reset' )
            // InternalAceGen.g:14:9: 'reset'
            {
            match("reset"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:15:7: ( 'init' )
            // InternalAceGen.g:15:9: 'init'
            {
            match("init"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:16:7: ( 'POST' )
            // InternalAceGen.g:16:9: 'POST'
            {
            match("POST"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:17:7: ( 'PUT' )
            // InternalAceGen.g:17:9: 'PUT'
            {
            match("PUT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:18:7: ( 'DELETE' )
            // InternalAceGen.g:18:9: 'DELETE'
            {
            match("DELETE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:19:7: ( 'Integer' )
            // InternalAceGen.g:19:9: 'Integer'
            {
            match("Integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:20:7: ( 'String' )
            // InternalAceGen.g:20:9: 'String'
            {
            match("String"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:21:7: ( 'Float' )
            // InternalAceGen.g:21:9: 'Float'
            {
            match("Float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:22:7: ( 'Boolean' )
            // InternalAceGen.g:22:9: 'Boolean'
            {
            match("Boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:23:7: ( 'DateTime' )
            // InternalAceGen.g:23:9: 'DateTime'
            {
            match("DateTime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:24:7: ( 'Long' )
            // InternalAceGen.g:24:9: 'Long'
            {
            match("Long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:25:7: ( 'NotEmpty' )
            // InternalAceGen.g:25:9: 'NotEmpty'
            {
            match("NotEmpty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:26:7: ( 'NotNull' )
            // InternalAceGen.g:26:9: 'NotNull'
            {
            match("NotNull"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:27:7: ( 'HttpClient' )
            // InternalAceGen.g:27:9: 'HttpClient'
            {
            match("HttpClient"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:28:7: ( 'HttpServer' )
            // InternalAceGen.g:28:9: 'HttpServer'
            {
            match("HttpServer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:29:7: ( 'ACE' )
            // InternalAceGen.g:29:9: 'ACE'
            {
            match("ACE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:30:7: ( 'appState' )
            // InternalAceGen.g:30:9: 'appState'
            {
            match("appState"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:31:7: ( '<' )
            // InternalAceGen.g:31:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:32:7: ( '>' )
            // InternalAceGen.g:32:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:33:7: ( ',' )
            // InternalAceGen.g:33:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:34:7: ( 'call' )
            // InternalAceGen.g:34:9: 'call'
            {
            match("call"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:35:7: ( 'loadingFlag' )
            // InternalAceGen.g:35:9: 'loadingFlag'
            {
            match("loadingFlag"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:36:7: ( 'on' )
            // InternalAceGen.g:36:9: 'on'
            {
            match("on"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:37:7: ( '(' )
            // InternalAceGen.g:37:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:38:7: ( ')' )
            // InternalAceGen.g:38:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:39:7: ( 'triggers' )
            // InternalAceGen.g:39:9: 'triggers'
            {
            match("triggers"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:40:7: ( '|' )
            // InternalAceGen.g:40:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:41:7: ( ':' )
            // InternalAceGen.g:41:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:42:7: ( '{' )
            // InternalAceGen.g:42:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:43:7: ( '}' )
            // InternalAceGen.g:43:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:44:7: ( 'Authorization' )
            // InternalAceGen.g:44:9: 'Authorization'
            {
            match("Authorization"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:45:7: ( 'import' )
            // InternalAceGen.g:45:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:46:7: ( 'views' )
            // InternalAceGen.g:46:9: 'views'
            {
            match("views"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:47:7: ( 'models' )
            // InternalAceGen.g:47:9: 'models'
            {
            match("models"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:48:7: ( 'pathParams' )
            // InternalAceGen.g:48:9: 'pathParams'
            {
            match("pathParams"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:49:7: ( 'queryParams' )
            // InternalAceGen.g:49:9: 'queryParams'
            {
            match("queryParams"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:50:7: ( 'payload' )
            // InternalAceGen.g:50:9: 'payload'
            {
            match("payload"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:51:7: ( 'response' )
            // InternalAceGen.g:51:9: 'response'
            {
            match("response"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:52:7: ( 'extends' )
            // InternalAceGen.g:52:9: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:53:7: ( 'references' )
            // InternalAceGen.g:53:9: 'references'
            {
            match("references"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:54:7: ( '.' )
            // InternalAceGen.g:54:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:55:7: ( 'list' )
            // InternalAceGen.g:55:9: 'list'
            {
            match("list"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:56:7: ( 'location.hash' )
            // InternalAceGen.g:56:9: 'location.hash'
            {
            match("location.hash"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:57:7: ( 'storage' )
            // InternalAceGen.g:57:9: 'storage'
            {
            match("storage"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:58:7: ( 'proxy' )
            // InternalAceGen.g:58:9: 'proxy'
            {
            match("proxy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:59:7: ( 'authorize' )
            // InternalAceGen.g:59:9: 'authorize'
            {
            match("authorize"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:60:7: ( 'persistent' )
            // InternalAceGen.g:60:9: 'persistent'
            {
            match("persistent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:61:7: ( 'Unique' )
            // InternalAceGen.g:61:9: 'Unique'
            {
            match("Unique"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:62:7: ( 'PrimaryKey' )
            // InternalAceGen.g:62:9: 'PrimaryKey'
            {
            match("PrimaryKey"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:63:7: ( 'List' )
            // InternalAceGen.g:63:9: 'List'
            {
            match("List"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:6390:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalAceGen.g:6390:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalAceGen.g:6390:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalAceGen.g:6390:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalAceGen.g:6390:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalAceGen.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:6392:10: ( ( '0' .. '9' )+ )
            // InternalAceGen.g:6392:12: ( '0' .. '9' )+
            {
            // InternalAceGen.g:6392:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAceGen.g:6392:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:6394:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalAceGen.g:6394:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalAceGen.g:6394:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalAceGen.g:6394:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalAceGen.g:6394:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalAceGen.g:6394:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalAceGen.g:6394:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalAceGen.g:6394:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalAceGen.g:6394:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalAceGen.g:6394:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalAceGen.g:6394:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:6396:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalAceGen.g:6396:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalAceGen.g:6396:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalAceGen.g:6396:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:6398:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalAceGen.g:6398:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalAceGen.g:6398:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalAceGen.g:6398:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalAceGen.g:6398:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAceGen.g:6398:41: ( '\\r' )? '\\n'
                    {
                    // InternalAceGen.g:6398:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalAceGen.g:6398:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:6400:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalAceGen.g:6400:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalAceGen.g:6400:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalAceGen.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalAceGen.g:6402:16: ( . )
            // InternalAceGen.g:6402:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalAceGen.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=60;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalAceGen.g:1:10: T__11
                {
                mT__11(); 

                }
                break;
            case 2 :
                // InternalAceGen.g:1:16: T__12
                {
                mT__12(); 

                }
                break;
            case 3 :
                // InternalAceGen.g:1:22: T__13
                {
                mT__13(); 

                }
                break;
            case 4 :
                // InternalAceGen.g:1:28: T__14
                {
                mT__14(); 

                }
                break;
            case 5 :
                // InternalAceGen.g:1:34: T__15
                {
                mT__15(); 

                }
                break;
            case 6 :
                // InternalAceGen.g:1:40: T__16
                {
                mT__16(); 

                }
                break;
            case 7 :
                // InternalAceGen.g:1:46: T__17
                {
                mT__17(); 

                }
                break;
            case 8 :
                // InternalAceGen.g:1:52: T__18
                {
                mT__18(); 

                }
                break;
            case 9 :
                // InternalAceGen.g:1:58: T__19
                {
                mT__19(); 

                }
                break;
            case 10 :
                // InternalAceGen.g:1:64: T__20
                {
                mT__20(); 

                }
                break;
            case 11 :
                // InternalAceGen.g:1:70: T__21
                {
                mT__21(); 

                }
                break;
            case 12 :
                // InternalAceGen.g:1:76: T__22
                {
                mT__22(); 

                }
                break;
            case 13 :
                // InternalAceGen.g:1:82: T__23
                {
                mT__23(); 

                }
                break;
            case 14 :
                // InternalAceGen.g:1:88: T__24
                {
                mT__24(); 

                }
                break;
            case 15 :
                // InternalAceGen.g:1:94: T__25
                {
                mT__25(); 

                }
                break;
            case 16 :
                // InternalAceGen.g:1:100: T__26
                {
                mT__26(); 

                }
                break;
            case 17 :
                // InternalAceGen.g:1:106: T__27
                {
                mT__27(); 

                }
                break;
            case 18 :
                // InternalAceGen.g:1:112: T__28
                {
                mT__28(); 

                }
                break;
            case 19 :
                // InternalAceGen.g:1:118: T__29
                {
                mT__29(); 

                }
                break;
            case 20 :
                // InternalAceGen.g:1:124: T__30
                {
                mT__30(); 

                }
                break;
            case 21 :
                // InternalAceGen.g:1:130: T__31
                {
                mT__31(); 

                }
                break;
            case 22 :
                // InternalAceGen.g:1:136: T__32
                {
                mT__32(); 

                }
                break;
            case 23 :
                // InternalAceGen.g:1:142: T__33
                {
                mT__33(); 

                }
                break;
            case 24 :
                // InternalAceGen.g:1:148: T__34
                {
                mT__34(); 

                }
                break;
            case 25 :
                // InternalAceGen.g:1:154: T__35
                {
                mT__35(); 

                }
                break;
            case 26 :
                // InternalAceGen.g:1:160: T__36
                {
                mT__36(); 

                }
                break;
            case 27 :
                // InternalAceGen.g:1:166: T__37
                {
                mT__37(); 

                }
                break;
            case 28 :
                // InternalAceGen.g:1:172: T__38
                {
                mT__38(); 

                }
                break;
            case 29 :
                // InternalAceGen.g:1:178: T__39
                {
                mT__39(); 

                }
                break;
            case 30 :
                // InternalAceGen.g:1:184: T__40
                {
                mT__40(); 

                }
                break;
            case 31 :
                // InternalAceGen.g:1:190: T__41
                {
                mT__41(); 

                }
                break;
            case 32 :
                // InternalAceGen.g:1:196: T__42
                {
                mT__42(); 

                }
                break;
            case 33 :
                // InternalAceGen.g:1:202: T__43
                {
                mT__43(); 

                }
                break;
            case 34 :
                // InternalAceGen.g:1:208: T__44
                {
                mT__44(); 

                }
                break;
            case 35 :
                // InternalAceGen.g:1:214: T__45
                {
                mT__45(); 

                }
                break;
            case 36 :
                // InternalAceGen.g:1:220: T__46
                {
                mT__46(); 

                }
                break;
            case 37 :
                // InternalAceGen.g:1:226: T__47
                {
                mT__47(); 

                }
                break;
            case 38 :
                // InternalAceGen.g:1:232: T__48
                {
                mT__48(); 

                }
                break;
            case 39 :
                // InternalAceGen.g:1:238: T__49
                {
                mT__49(); 

                }
                break;
            case 40 :
                // InternalAceGen.g:1:244: T__50
                {
                mT__50(); 

                }
                break;
            case 41 :
                // InternalAceGen.g:1:250: T__51
                {
                mT__51(); 

                }
                break;
            case 42 :
                // InternalAceGen.g:1:256: T__52
                {
                mT__52(); 

                }
                break;
            case 43 :
                // InternalAceGen.g:1:262: T__53
                {
                mT__53(); 

                }
                break;
            case 44 :
                // InternalAceGen.g:1:268: T__54
                {
                mT__54(); 

                }
                break;
            case 45 :
                // InternalAceGen.g:1:274: T__55
                {
                mT__55(); 

                }
                break;
            case 46 :
                // InternalAceGen.g:1:280: T__56
                {
                mT__56(); 

                }
                break;
            case 47 :
                // InternalAceGen.g:1:286: T__57
                {
                mT__57(); 

                }
                break;
            case 48 :
                // InternalAceGen.g:1:292: T__58
                {
                mT__58(); 

                }
                break;
            case 49 :
                // InternalAceGen.g:1:298: T__59
                {
                mT__59(); 

                }
                break;
            case 50 :
                // InternalAceGen.g:1:304: T__60
                {
                mT__60(); 

                }
                break;
            case 51 :
                // InternalAceGen.g:1:310: T__61
                {
                mT__61(); 

                }
                break;
            case 52 :
                // InternalAceGen.g:1:316: T__62
                {
                mT__62(); 

                }
                break;
            case 53 :
                // InternalAceGen.g:1:322: T__63
                {
                mT__63(); 

                }
                break;
            case 54 :
                // InternalAceGen.g:1:328: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 55 :
                // InternalAceGen.g:1:336: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 56 :
                // InternalAceGen.g:1:345: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 57 :
                // InternalAceGen.g:1:357: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 58 :
                // InternalAceGen.g:1:373: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 59 :
                // InternalAceGen.g:1:389: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 60 :
                // InternalAceGen.g:1:397: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\20\55\3\uffff\3\55\2\uffff\1\55\4\uffff\4\55\1\uffff\1\55\1\53\2\uffff\3\53\2\uffff\1\55\1\uffff\30\55\3\uffff\3\55\1\177\2\uffff\1\55\4\uffff\6\55\1\uffff\1\55\5\uffff\1\u0089\1\u008a\10\55\1\u0094\13\55\1\u00a1\7\55\1\uffff\11\55\2\uffff\6\55\1\u00b8\1\55\1\u00ba\1\uffff\7\55\1\u00c2\1\u00c3\3\55\1\uffff\3\55\1\u00cb\2\55\1\u00ce\12\55\1\u00d9\1\55\1\u00db\2\55\1\uffff\1\55\1\uffff\5\55\1\u00e4\1\55\2\uffff\7\55\1\uffff\2\55\1\uffff\1\55\1\u00f0\2\55\1\u00f3\5\55\1\uffff\1\u00f9\1\uffff\2\55\1\u00fc\1\55\1\u00fe\2\55\1\u0101\1\uffff\13\55\1\uffff\2\55\1\uffff\3\55\1\u0112\1\u0113\1\uffff\2\55\1\uffff\1\55\1\uffff\1\55\1\u0118\1\uffff\1\u0119\1\55\1\u011b\11\55\1\u0125\2\55\1\u0128\2\uffff\1\u0129\2\55\1\u012c\2\uffff\1\u012d\1\uffff\3\55\1\u0131\3\55\1\u0135\1\55\1\uffff\2\55\2\uffff\2\55\2\uffff\3\55\1\uffff\1\u013e\1\55\2\uffff\3\55\1\u0143\1\u0144\1\u0145\1\u0146\1\55\1\uffff\1\55\1\u0149\1\u014a\1\55\4\uffff\1\55\1\u014d\2\uffff\1\u014e\1\55\2\uffff\1\u0150\1\uffff";
    static final String DFA12_eofS =
        "\u0151\uffff";
    static final String DFA12_minS =
        "\1\0\1\105\3\145\1\155\1\117\1\105\1\156\1\164\1\154\1\157\1\151\1\157\1\164\1\103\1\160\3\uffff\1\141\1\151\1\156\2\uffff\1\162\4\uffff\1\151\1\141\1\165\1\170\1\uffff\1\156\1\101\2\uffff\2\0\1\52\2\uffff\1\124\1\uffff\1\164\1\157\1\162\1\144\1\146\1\151\1\160\1\123\1\124\1\151\1\114\2\164\1\162\2\157\1\156\1\163\2\164\1\105\1\164\1\160\1\164\3\uffff\1\154\1\141\1\163\1\60\2\uffff\1\151\4\uffff\1\145\1\164\1\157\1\162\1\145\1\164\1\uffff\1\151\5\uffff\2\60\1\162\1\147\3\145\1\164\1\157\1\124\1\60\1\155\1\105\2\145\1\151\1\141\1\154\1\147\1\164\1\105\1\160\1\60\1\150\1\123\1\150\1\154\1\144\1\141\1\164\1\uffff\1\147\1\167\1\150\1\154\1\170\1\163\1\162\1\145\1\161\2\uffff\1\141\1\145\1\154\1\164\1\157\1\162\1\60\1\162\1\60\1\uffff\1\141\2\124\1\147\1\156\1\164\1\145\2\60\1\155\1\165\1\103\1\uffff\1\157\1\164\1\157\1\60\1\151\1\164\1\60\1\147\1\163\1\120\1\157\1\171\1\151\1\171\1\156\1\165\1\147\1\60\1\163\1\60\1\156\1\145\1\uffff\1\164\1\uffff\1\162\1\105\1\151\1\145\1\147\1\60\1\141\2\uffff\1\160\2\154\1\145\1\162\1\141\1\162\1\uffff\1\156\1\151\1\uffff\1\145\1\60\2\141\1\60\1\163\1\120\1\144\2\145\1\uffff\1\60\1\uffff\1\163\1\156\1\60\1\171\1\60\1\155\1\162\1\60\1\uffff\1\156\1\164\1\154\1\151\1\162\1\151\1\164\1\151\1\147\1\157\1\162\1\uffff\1\162\1\144\1\uffff\1\164\1\141\1\163\2\60\1\uffff\1\145\1\143\1\uffff\1\113\1\uffff\1\145\1\60\1\uffff\1\60\1\171\1\60\1\145\1\166\1\172\1\145\1\172\1\106\1\156\1\163\1\141\1\60\1\145\1\162\1\60\2\uffff\1\60\2\145\1\60\2\uffff\1\60\1\uffff\1\156\1\145\1\141\1\60\1\145\1\154\1\56\1\60\1\155\1\uffff\1\156\1\141\2\uffff\1\163\1\171\2\uffff\1\164\1\162\1\164\1\uffff\1\60\1\141\2\uffff\1\163\1\164\1\155\4\60\1\151\1\uffff\1\147\2\60\1\163\4\uffff\1\157\1\60\2\uffff\1\60\1\156\2\uffff\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\105\1\164\1\157\1\145\1\156\1\162\1\141\1\156\1\164\1\154\3\157\1\164\2\165\3\uffff\1\141\1\157\1\156\2\uffff\1\162\4\uffff\1\151\1\162\1\165\1\170\1\uffff\1\156\1\172\2\uffff\2\uffff\1\57\2\uffff\1\124\1\uffff\1\164\1\157\1\162\1\144\1\163\1\151\1\160\1\123\1\124\1\151\1\114\2\164\1\162\2\157\1\156\1\163\2\164\1\105\1\164\1\160\1\164\3\uffff\1\154\1\143\1\163\1\172\2\uffff\1\151\4\uffff\1\145\1\171\1\157\1\162\1\145\1\164\1\uffff\1\151\5\uffff\2\172\1\162\1\147\1\145\1\160\1\145\1\164\1\157\1\124\1\172\1\155\1\105\2\145\1\151\1\141\1\154\1\147\1\164\1\116\1\160\1\172\1\150\1\123\1\150\1\154\1\144\1\141\1\164\1\uffff\1\147\1\167\1\150\1\154\1\170\1\163\1\162\1\145\1\161\2\uffff\1\141\1\145\1\154\1\164\1\157\1\162\1\172\1\162\1\172\1\uffff\1\141\2\124\1\147\1\156\1\164\1\145\2\172\1\155\1\165\1\123\1\uffff\1\157\1\164\1\157\1\172\1\151\1\164\1\172\1\147\1\163\1\120\1\157\1\171\1\151\1\171\1\156\1\165\1\147\1\172\1\163\1\172\1\156\1\145\1\uffff\1\164\1\uffff\1\162\1\105\1\151\1\145\1\147\1\172\1\141\2\uffff\1\160\2\154\1\145\1\162\1\141\1\162\1\uffff\1\156\1\151\1\uffff\1\145\1\172\2\141\1\172\1\163\1\120\1\144\2\145\1\uffff\1\172\1\uffff\1\163\1\156\1\172\1\171\1\172\1\155\1\162\1\172\1\uffff\1\156\1\164\1\154\1\151\1\162\1\151\1\164\1\151\1\147\1\157\1\162\1\uffff\1\162\1\144\1\uffff\1\164\1\141\1\163\2\172\1\uffff\1\145\1\143\1\uffff\1\113\1\uffff\1\145\1\172\1\uffff\1\172\1\171\1\172\1\145\1\166\1\172\1\145\1\172\1\106\1\156\1\163\1\141\1\172\1\145\1\162\1\172\2\uffff\1\172\2\145\1\172\2\uffff\1\172\1\uffff\1\156\1\145\1\141\1\172\1\145\1\154\1\56\1\172\1\155\1\uffff\1\156\1\141\2\uffff\1\163\1\171\2\uffff\1\164\1\162\1\164\1\uffff\1\172\1\141\2\uffff\1\163\1\164\1\155\4\172\1\151\1\uffff\1\147\2\172\1\163\4\uffff\1\157\1\172\2\uffff\1\172\1\156\2\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\21\uffff\1\25\1\26\1\27\3\uffff\1\33\1\34\1\uffff\1\36\1\37\1\40\1\41\4\uffff\1\54\2\uffff\1\66\1\67\3\uffff\1\73\1\74\1\uffff\1\66\30\uffff\1\25\1\26\1\27\4\uffff\1\33\1\34\1\uffff\1\36\1\37\1\40\1\41\6\uffff\1\54\1\uffff\1\67\1\70\1\71\1\72\1\73\36\uffff\1\32\11\uffff\1\1\1\2\11\uffff\1\7\14\uffff\1\23\26\uffff\1\5\1\uffff\1\6\7\uffff\1\16\1\65\7\uffff\1\30\2\uffff\1\55\12\uffff\1\3\1\uffff\1\4\10\uffff\1\13\13\uffff\1\44\2\uffff\1\60\5\uffff\1\45\2\uffff\1\43\1\uffff\1\10\2\uffff\1\12\20\uffff\1\63\1\57\4\uffff\1\11\1\14\1\uffff\1\20\11\uffff\1\50\2\uffff\1\52\1\51\2\uffff\1\15\1\17\3\uffff\1\24\2\uffff\1\56\1\35\10\uffff\1\61\4\uffff\1\53\1\64\1\21\1\22\2\uffff\1\46\1\62\2\uffff\1\31\1\47\1\uffff\1\42";
    static final String DFA12_specialS =
        "\1\1\46\uffff\1\2\1\0\u0128\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\53\2\52\2\53\1\52\22\53\1\52\1\53\1\47\4\53\1\50\1\27\1\30\2\53\1\23\1\53\1\42\1\51\12\46\1\33\1\53\1\21\1\53\1\22\2\53\1\17\1\13\1\45\1\7\1\45\1\12\1\1\1\16\1\10\2\45\1\14\1\45\1\15\1\45\1\6\2\45\1\11\1\45\1\43\5\45\3\53\1\44\1\45\1\53\1\20\1\45\1\24\1\45\1\41\3\45\1\5\2\45\1\25\1\3\1\45\1\26\1\37\1\40\1\4\1\2\1\31\1\45\1\36\4\45\1\34\1\32\1\35\uff82\53",
            "\1\54",
            "\1\56\16\uffff\1\57",
            "\1\60\11\uffff\1\61",
            "\1\62",
            "\1\64\1\63",
            "\1\65\5\uffff\1\66\34\uffff\1\67",
            "\1\70\33\uffff\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\77\5\uffff\1\76",
            "\1\100",
            "\1\101",
            "\1\102\61\uffff\1\103",
            "\1\104\4\uffff\1\105",
            "",
            "",
            "",
            "\1\111",
            "\1\113\5\uffff\1\112",
            "\1\114",
            "",
            "",
            "\1\117",
            "",
            "",
            "",
            "",
            "\1\124",
            "\1\125\3\uffff\1\127\14\uffff\1\126",
            "\1\130",
            "\1\131",
            "",
            "\1\133",
            "\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\0\135",
            "\0\135",
            "\1\136\4\uffff\1\137",
            "",
            "",
            "\1\141",
            "",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\147\14\uffff\1\146",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "",
            "",
            "",
            "\1\173",
            "\1\174\1\uffff\1\175",
            "\1\176",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\1\u0080",
            "",
            "",
            "",
            "",
            "\1\u0081",
            "\1\u0082\4\uffff\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "",
            "\1\u0088",
            "",
            "",
            "",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e\12\uffff\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e\10\uffff\1\u009f",
            "\1\u00a0",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "",
            "",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00b9",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6\17\uffff\1\u00c7",
            "",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00cc",
            "\1\u00cd",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00da",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00dc",
            "\1\u00dd",
            "",
            "\1\u00de",
            "",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00e5",
            "",
            "",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "",
            "\1\u00ed",
            "\1\u00ee",
            "",
            "\1\u00ef",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00f1",
            "\1\u00f2",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u00fa",
            "\1\u00fb",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00fd",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u00ff",
            "\1\u0100",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "",
            "\1\u010d",
            "\1\u010e",
            "",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u0114",
            "\1\u0115",
            "",
            "\1\u0116",
            "",
            "\1\u0117",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u011a",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0126",
            "\1\u0127",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u012a",
            "\1\u012b",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0136",
            "",
            "\1\u0137",
            "\1\u0138",
            "",
            "",
            "\1\u0139",
            "\1\u013a",
            "",
            "",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u013f",
            "",
            "",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u0147",
            "",
            "\1\u0148",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u014b",
            "",
            "",
            "",
            "",
            "\1\u014c",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            "\1\u014f",
            "",
            "",
            "\12\55\7\uffff\32\55\4\uffff\1\55\1\uffff\32\55",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_40 = input.LA(1);

                        s = -1;
                        if ( ((LA12_40>='\u0000' && LA12_40<='\uFFFF')) ) {s = 93;}

                        else s = 43;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='G') ) {s = 1;}

                        else if ( (LA12_0=='s') ) {s = 2;}

                        else if ( (LA12_0=='m') ) {s = 3;}

                        else if ( (LA12_0=='r') ) {s = 4;}

                        else if ( (LA12_0=='i') ) {s = 5;}

                        else if ( (LA12_0=='P') ) {s = 6;}

                        else if ( (LA12_0=='D') ) {s = 7;}

                        else if ( (LA12_0=='I') ) {s = 8;}

                        else if ( (LA12_0=='S') ) {s = 9;}

                        else if ( (LA12_0=='F') ) {s = 10;}

                        else if ( (LA12_0=='B') ) {s = 11;}

                        else if ( (LA12_0=='L') ) {s = 12;}

                        else if ( (LA12_0=='N') ) {s = 13;}

                        else if ( (LA12_0=='H') ) {s = 14;}

                        else if ( (LA12_0=='A') ) {s = 15;}

                        else if ( (LA12_0=='a') ) {s = 16;}

                        else if ( (LA12_0=='<') ) {s = 17;}

                        else if ( (LA12_0=='>') ) {s = 18;}

                        else if ( (LA12_0==',') ) {s = 19;}

                        else if ( (LA12_0=='c') ) {s = 20;}

                        else if ( (LA12_0=='l') ) {s = 21;}

                        else if ( (LA12_0=='o') ) {s = 22;}

                        else if ( (LA12_0=='(') ) {s = 23;}

                        else if ( (LA12_0==')') ) {s = 24;}

                        else if ( (LA12_0=='t') ) {s = 25;}

                        else if ( (LA12_0=='|') ) {s = 26;}

                        else if ( (LA12_0==':') ) {s = 27;}

                        else if ( (LA12_0=='{') ) {s = 28;}

                        else if ( (LA12_0=='}') ) {s = 29;}

                        else if ( (LA12_0=='v') ) {s = 30;}

                        else if ( (LA12_0=='p') ) {s = 31;}

                        else if ( (LA12_0=='q') ) {s = 32;}

                        else if ( (LA12_0=='e') ) {s = 33;}

                        else if ( (LA12_0=='.') ) {s = 34;}

                        else if ( (LA12_0=='U') ) {s = 35;}

                        else if ( (LA12_0=='^') ) {s = 36;}

                        else if ( (LA12_0=='C'||LA12_0=='E'||(LA12_0>='J' && LA12_0<='K')||LA12_0=='M'||LA12_0=='O'||(LA12_0>='Q' && LA12_0<='R')||LA12_0=='T'||(LA12_0>='V' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||LA12_0=='d'||(LA12_0>='f' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='k')||LA12_0=='n'||LA12_0=='u'||(LA12_0>='w' && LA12_0<='z')) ) {s = 37;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 38;}

                        else if ( (LA12_0=='\"') ) {s = 39;}

                        else if ( (LA12_0=='\'') ) {s = 40;}

                        else if ( (LA12_0=='/') ) {s = 41;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 42;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='*' && LA12_0<='+')||LA12_0=='-'||LA12_0==';'||LA12_0=='='||(LA12_0>='?' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 43;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_39 = input.LA(1);

                        s = -1;
                        if ( ((LA12_39>='\u0000' && LA12_39<='\uFFFF')) ) {s = 93;}

                        else s = 43;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}