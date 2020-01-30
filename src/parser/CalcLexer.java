// Generated from /Users/isuruhaupe/Desktop/IntelliJ_projet/CCalc/src/parser/Calc.g4 by ANTLR 4.8
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, MINUS=8, NOT=9, 
		PLUS=10, MULTIPLICATIVE=11, RELATIONAL=12, EQUALITY=13, LOGICAL_AND=14, 
		LOGICAL_OR=15, IDENTIFIER=16, LITERAL=17, WS=18, LINE_COMMENT=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "MINUS", "NOT", 
			"PLUS", "MULTIPLICATIVE", "RELATIONAL", "EQUALITY", "LOGICAL_AND", "LOGICAL_OR", 
			"IDENTIFIER", "LITERAL", "WS", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'true'", "'false'", "'('", "')'", "'?'", "':'", "'-'", 
			"'!'", "'+'", null, null, null, "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "MINUS", "NOT", "PLUS", 
			"MULTIPLICATIVE", "RELATIONAL", "EQUALITY", "LOGICAL_AND", "LOGICAL_OR", 
			"IDENTIFIER", "LITERAL", "WS", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25~\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\5\rL\n\r\3\16\3\16\3\16\3\16\5\16R\n\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\7\21\\\n\21\f\21\16\21_\13\21\3\22\3\22\3"+
		"\22\7\22d\n\22\f\22\16\22g\13\22\5\22i\n\22\3\23\6\23l\n\23\r\23\16\23"+
		"m\3\23\3\23\3\24\3\24\3\24\3\24\7\24v\n\24\f\24\16\24y\13\24\3\24\3\24"+
		"\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\7\4\2,,\61\61\4\2>>@@\4\2\62"+
		";c|\5\2\13\f\17\17\"\"\3\2\f\f\2\u0085\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3"+
		"\2\2\2\5+\3\2\2\2\7\60\3\2\2\2\t\66\3\2\2\2\138\3\2\2\2\r:\3\2\2\2\17"+
		"<\3\2\2\2\21>\3\2\2\2\23@\3\2\2\2\25B\3\2\2\2\27D\3\2\2\2\31K\3\2\2\2"+
		"\33Q\3\2\2\2\35S\3\2\2\2\37V\3\2\2\2!Y\3\2\2\2#h\3\2\2\2%k\3\2\2\2\'q"+
		"\3\2\2\2)*\7?\2\2*\4\3\2\2\2+,\7v\2\2,-\7t\2\2-.\7w\2\2./\7g\2\2/\6\3"+
		"\2\2\2\60\61\7h\2\2\61\62\7c\2\2\62\63\7n\2\2\63\64\7u\2\2\64\65\7g\2"+
		"\2\65\b\3\2\2\2\66\67\7*\2\2\67\n\3\2\2\289\7+\2\29\f\3\2\2\2:;\7A\2\2"+
		";\16\3\2\2\2<=\7<\2\2=\20\3\2\2\2>?\7/\2\2?\22\3\2\2\2@A\7#\2\2A\24\3"+
		"\2\2\2BC\7-\2\2C\26\3\2\2\2DE\t\2\2\2E\30\3\2\2\2FL\t\3\2\2GH\7>\2\2H"+
		"L\7?\2\2IJ\7@\2\2JL\7?\2\2KF\3\2\2\2KG\3\2\2\2KI\3\2\2\2L\32\3\2\2\2M"+
		"N\7?\2\2NR\7?\2\2OP\7#\2\2PR\7?\2\2QM\3\2\2\2QO\3\2\2\2R\34\3\2\2\2ST"+
		"\7(\2\2TU\7(\2\2U\36\3\2\2\2VW\7~\2\2WX\7~\2\2X \3\2\2\2Y]\4c|\2Z\\\t"+
		"\4\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\"\3\2\2\2_]\3\2\2\2`"+
		"i\7\62\2\2ae\4\63;\2bd\4\62;\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2"+
		"fi\3\2\2\2ge\3\2\2\2h`\3\2\2\2ha\3\2\2\2i$\3\2\2\2jl\t\5\2\2kj\3\2\2\2"+
		"lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\b\23\2\2p&\3\2\2\2qr\7\61\2"+
		"\2rs\7\61\2\2sw\3\2\2\2tv\n\6\2\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2"+
		"\2\2xz\3\2\2\2yw\3\2\2\2z{\7\f\2\2{|\3\2\2\2|}\b\24\2\2}(\3\2\2\2\n\2"+
		"KQ]ehmw\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}