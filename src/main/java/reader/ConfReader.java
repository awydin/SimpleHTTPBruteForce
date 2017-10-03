package reader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.InputStream;


/**
 * 
 * @author paakro@hotmail.com
 *
 */

public class ConfReader
{

    private String url;
    private String userFieldId;
    private String passFiledId;
    private String filePath;
    private String userName;

    private static ConfReader instance = null;

    public static ConfReader getInstance()
    {
        if (instance == null)
        {
            instance = new ConfReader();
        }

        return instance;
    }

    private ConfReader()
    {
        try
        {
            InputStream is = ConfReader.class.getResourceAsStream("/conf.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("config");


                Node nNode = nList.item(0);

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode;
                    
                    setFilePath(eElement.getElementsByTagName("FILE_PATH").item(0).getTextContent());
                    setUrl(eElement.getElementsByTagName("URL").item(0).getTextContent());
                    setUserFieldId(eElement.getElementsByTagName("USERNAME_FIELD_ID").item(0).getTextContent());
                    setPassFiledId(eElement.getElementsByTagName("PASSWORD_FIELD_ID").item(0).getTextContent());
                    setUserName(eElement.getElementsByTagName("USERNAME").item(0).getTextContent());
                    
                   
                }
           
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUserFieldId()
    {
        return userFieldId;
    }

    public void setUserFieldId(String userFieldId)
    {
        this.userFieldId = userFieldId;
    }

    public String getPassFiledId()
    {
        return passFiledId;
    }

    public void setPassFiledId(String passFiledId)
    {
        this.passFiledId = passFiledId;
    }



    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

}
