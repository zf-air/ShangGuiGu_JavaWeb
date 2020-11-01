package xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Buzhou {
    @Test
    public void test() throws Exception{
        // 第一步,获取document对象
        SAXReader reader = new SAXReader();
        //默认以项目目录为根目录
        Document document = reader.read("src/books.xml");

        // 第二步,获取根元素
        Element root = document.getRootElement();

        // 第三步，获取所有子元素
        List<Element> books = root.elements();

        // 第四步，遍历子元素
        List<Book> bookslist = new ArrayList<Book>();
        for(Element book:books){
            // 获取book内容对象
            Element nameElement = book.element("name");
            Element authorElement = book.element("author");
            Element priceElement = book.element("price");
            String sn = book.attributeValue("sn");

            String name = nameElement.getText();
            String author = authorElement.getText();
            String price = priceElement.getText();

            //写入类中
            Book bookitem = new Book(sn,name,author,price);
            bookslist.add(bookitem);
        }
        System.out.println("size:"+bookslist.size());
        for(int i=0;i<bookslist.size();i++){
            System.out.println(bookslist.get(i).getSn()+" "+bookslist.get(i).getName()
            +" "+bookslist.get(i).getAuthor()+" "+bookslist.get(i).getPrice());
        }
    }
}
