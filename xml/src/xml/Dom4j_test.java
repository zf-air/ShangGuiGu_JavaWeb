package xml;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4j_test {
    @Test
    public void test01() throws Exception{
        // 要创建一个Document对象，需要我们先创建一个SAXReader对象
        SAXReader reader = new SAXReader();
        // 这个对象用于读取xml文件，然后返回一个Document
        Document document = reader.read("src/books.xml");
        //打印到控制台，看看是否创建成功
//        System.out.println(document);

    }

}
