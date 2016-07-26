import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Gvozd on 26.07.2016.
 */
public class JDomTest {
    public static void main(String[] args) throws JDOMException, IOException {
        File inputFile = new File("src/main/resources/users.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);

        System.out.println("Root element :"
                + document.getRootElement().getName());

        Element classElement = document.getRootElement();

        List<Element> studentList = classElement.getChildren();

        for (Element element:studentList){
            System.out.println(element.getChild("firstname").getValue().toString());
        }

    }
}
