package LibaryFiles;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class UtilityClass 
{
public static String PropertyFile(String key) throws IOException 
{
	FileInputStream pf=new FileInputStream("C:\\Users\\ATM\\OneDrive\\Desktop\\sparrow\\QA\\src\\test\\resources\\PropertyFiles.properties");
	Properties p=new Properties();
	p.load(pf);
	String value = p.getProperty(key);
	return value;
}
}
