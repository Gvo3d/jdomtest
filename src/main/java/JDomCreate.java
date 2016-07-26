import org.jdom2.Document;
import org.jdom2.Element;

public class JDomCreate {
    public static void main(String[] args) {
        Element userElement = new Element("users");
        Document doc = new Document(userElement);

        Element newUser = new Element("user");
        
    }
}
