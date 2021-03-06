import java.io.File;
import java.util.ResourceBundle;

import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.library.AnnotationLibrary;

import com.company.department.keywords.Echo;
import com.company.department.utils.Javadoc2Libdoc;

/**
 * FooBarLibrary is a ... library for the Robot Framework.<br>
 * <br>
 * <b>Insert library introduction here.</b>
 */
public class FooBarLibrary extends AnnotationLibrary {

	/**
	 * The list of keyword patterns for the AnnotationLibrary
	 */
	public static final String KEYWORD_PATTERN = "com.company.department".replace('.','/') + "/keywords/**/*.class";

	/**
	 * The javadoc to libdoc converter
	 */
	public static final Javadoc2Libdoc JAVADOC_2_LIBDOC = new Javadoc2Libdoc(FooBarLibrary.class);

	/**
	 * The library documentation is written in HTML
	 */
	public static final String ROBOT_LIBRARY_DOC_FORMAT = "HTML";

	/**
	 * The scope of this library is global.
	 */
	public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

	/**
	 * The actual version of this library. Loaded from maven project.
	 */
	public static final String ROBOT_LIBRARY_VERSION = loadRobotLibraryVersion();

	private static String loadRobotLibraryVersion() {
		try {
			return ResourceBundle.getBundle(FooBarLibrary.class.getCanonicalName().replace(".", File.separator))
					.getString("version");
		} catch (RuntimeException e) {
			return "unknown";
		}
	}
	
	/**
	 * FooBarLibrary can be imported with optional arguments.<br>
	 * <br>
	 * <b>Insert importing documentation here.</b>
	 */
	public FooBarLibrary() {
		super();
		addKeywordPattern(KEYWORD_PATTERN);
		createKeywordFactory(); // => init annotations
	}

	// ******************************
	// Autowired References
	// ******************************

	/**
	 * Instantiated Echo keyword bean
	 */
	@Autowired
	protected Echo echo;

	// ******************************
	// Getter / Setter
	// ******************************

	public Echo getEcho() {
		return echo;
	}

	// ******************************
	// AnnotationLibrary overrides
	// ******************************

	@Override
	public Object runKeyword(String keywordName, Object[] args) {
		return super.runKeyword(keywordName, toStrings(args));
	}

	@Override
	public String getKeywordDocumentation(String keywordName) {
		String keywordDocumentation = JAVADOC_2_LIBDOC.getKeywordDocumentation(keywordName);
		if (keywordDocumentation == null) {
			try {
				return super.getKeywordDocumentation(keywordName);
			} catch (NullPointerException e) {
				return "";
			}
		}
		return keywordDocumentation;
	}

	// ******************************
	// Internal Methods
	// ******************************

	/**
	 * Convert all arguments in the object array to string
	 */
	protected Object[] toStrings(Object[] args) {
		Object[] newArgs = new Object[args.length];
		for (int i = 0; i < newArgs.length; i++) {
			if (args[i].getClass().isArray()) {
				newArgs[i] = args[i];
			} else {
				newArgs[i] = args[i].toString();
			}
		}
		return newArgs;
	}
}