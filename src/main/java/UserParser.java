import data.User;
import org.jdom2.Attribute;
import org.jdom2.Element;

/**
 * Created by Gvozd on 26.07.2016.
 */
public class UserParser {

    public static Element getElement(User user){
        int id = user.getId();
        String login = user.getLogin();
        String password = user.getPassword();

        Element newUser = new Element("user");
        newUser.setAttribute(new Attribute("id", Integer.toString(id)));

        Element newUserLogin = new Element("login");
        newUserLogin.setText(login);

        Element newUserPassword = new Element("password");
        newUserPassword.setText(password);

        newUser.addContent(newUserLogin);
        newUser.addContent(newUserPassword);

        return newUser;
    }
}
