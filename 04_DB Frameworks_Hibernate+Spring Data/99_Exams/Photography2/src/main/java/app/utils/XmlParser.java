package app.utils;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component
public class XmlParser {

    public <T> void exportXml(T object, String path) throws JAXBException, IOException {
    	
        File file = new File(path);
        if(!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        OutputStream outputStream = new FileOutputStream(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        
        jaxbMarshaller.marshal(object, bufferedWriter);
    }

    public <T> T importXml(Class<T> clazz, String path) throws JAXBException, IOException {
        
    	JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        
        try (
            InputStream is = clazz.getResourceAsStream(path);
            BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
            ) {
            T result = (T) jaxbUnmarshaller.unmarshal(bfr);
            return result;
        }
    }
}
