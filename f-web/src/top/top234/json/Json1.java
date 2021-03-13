package top.top234.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import top.top234.bean.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/10 9:43.
 *
 * ********************************
 *
 * @author top234
 *
 *         java中处理 Json 的几种方式:
 *         1.GSON
 */
public class Json1 {
    /**
     * 1.com.google.json.Gson
     */
    @Test
    public void test1() {
        Gson gson = new Gson();
        Book book = new Book(1, "java编程思想", 89.88, "2018-12-08");
        //java对象转json串
        String s = gson.toJson(book);
        System.out.println(s);

        //json串转java对象
        Book book1 = gson.fromJson(s, Book.class);
        System.out.println(book1);
        System.out.println(book.equals(book1));


        //使用Gson处理java集合
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            books.add(new Book(i, "java" + i, 100 + i, "2020-03-" + i));
        }
        //集合转为json数组
        String s1 = gson.toJson(books);
        System.out.println(s1);
        //json数组转java集合
        List<Book> books1 = gson.fromJson(s1, new TypeToken<LinkedList<Book>>() {
        }.getType());

        for (int i = 0; i < books1.size(); i++) {
            System.out.println(books1.get(i).getName());
        }
        System.out.println(books1.getClass());
    }
}
