package reader;

import java.io.File;
import java.io.IOException;

import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 
 * @author paakro@hotmail.com
 *
 */
public class FileReader
{

    public static List<String> putFileContentToList(String filePath) throws IOException
    {

        File file = new File(filePath);
        List<String> lines = FileUtils.readLines(file, "UTF-8");
        return lines;
    }

}
