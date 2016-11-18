import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.*;


public class test {

public static void main(String[] args) throws Exception {

    boolean title_success = false;
    boolean text_success = false;
    WebClient client = new WebClient();

    if ( args.length < 3 ) {
	System.out.println("Please enter three arguments\n");
	System.out.println("1 - Website to test - full http:// address\n");
	System.out.println("2 - Title of the website - used as an assetion\n");
	System.out.println("3 - Random text on the web page to match - this is a CONTAINS match\n");
	System.exit(1);
    }

    HtmlPage currentPage = client.getPage(args[0]);
    try {
    	WebAssert.assertTitleEquals(currentPage, args[1]);
	title_success = true;
	}
    catch (AssertionError e) {
	System.out.println(e);
	}
    finally {
	if (title_success==true) System.out.println("Title: Successfully Tested");
	}
    try {
    	WebAssert.assertTextPresent(currentPage, args[2]);
	text_success = true;
	}
    catch (AssertionError e) {
	System.out.println(e);
	}
    finally {
	if (text_success) System.out.println("Text: Successfully Tested");
	}

	if (text_success && title_success) System.out.println("Success is 100%");
//    client.waitForBackgroundJavaScript(10000);
//    String textSource = currentPage.asXml();
//    System.out.println(textSource);
}

}
