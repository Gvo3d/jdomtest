import data.User;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gvozd on 26.07.2016.
 */
public class JDomModify {
    public static void main(String[] args) {
        File inputFile = new File("test.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(inputFile);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element rootElement = document.getRootElement();


        List<Element> elementList = rootElement.getChildren();
        List<User> dataList = new LinkedList<User>();

        for (Element tempElement : elementList) {
            String login = tempElement.getChildText("login");
            String password = tempElement.getChildText("password");
            String id = tempElement.getAttributeValue("id");
            User user = new User(Integer.parseInt(id), login, password);
            dataList.add(user);
        }

        for (User user : dataList) {
            System.out.println(user.toString());
        }

        System.out.println();
        System.out.println("New user:");
        User user = new User(16, "Petya", "qwerty");
        System.out.println(user);

        Element newUser = UserParser.getElement(user);

        Document doc = new Document();
        doc.setRootElement(new Element("users"));

        for (User tempUser:dataList){
            doc.getRootElement().addContent(UserParser.getElement(tempUser));
        }

        doc.getRootElement().addContent(newUser);
        XMLOutputter xmlOutput = new XMLOutputter();

        // display ml
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(doc, new FileWriter("test.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("test.xml");
        File file2 = new File("test.xml");
        file.delete();
        file2.renameTo(new File("test.xml"));

    }
}
