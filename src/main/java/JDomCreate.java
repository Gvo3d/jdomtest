import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileWriter;
import java.io.IOException;

public class JDomCreate {
    public static void main(String[] args) {
        Element userElement = new Element("users");
        Document doc = new Document(userElement);

        int number = 66;
        String login = "Vasya";
        String password = "12345";

        Element newUser = new Element("user");
        newUser.setAttribute(new Attribute("id", Integer.toString(number)));

        Element newUserLogin = new Element("login");
        newUserLogin.setText(login);

        Element newUserPassword = new Element("password");
        newUserPassword.setText(password);

        newUser.addContent(newUserLogin);
        newUser.addContent(newUserPassword);

        doc.getRootElement().addContent(newUser);

        XMLOutputter xmlOutput = new XMLOutputter();

        // display ml
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(doc,new FileWriter("test.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
