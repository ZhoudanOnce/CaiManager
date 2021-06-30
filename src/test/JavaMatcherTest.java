package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class JavaMatcherTest {

	
	
	public static void main(String[] args) {
		
		
		
		//密码正则测试
		String a = "123456";
		
//		System.out.println(Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", "123456"));
//		
//		System.out.println(Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", "aaaaa"));
//		System.out.println(Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", "aaaaaa"));
//		System.out.println(Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", "12345a"));
//		System.out.println(Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", "123456aaaa"));
		
		
		
		//邮箱正则测试
//		System.out.println(Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", "aaaaa"));
//		System.out.println(Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", "fpfwmoibeq@yahoo.com.cn"));
//		System.out.println(Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", "krhpvlsthqegedq@citiz.com"));
//		System.out.println(Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", "wnlemakjvst@sogou@com"));
		
		//必须全中文
//		System.out.println(Pattern.matches("[\\u4e00-\\u9fa5]+", "wnlemakjvst@sogou@com"));
//		System.out.println(Pattern.matches("[\\u4e00-\\u9fa5]+", "你好@sogou@com"));
//		System.out.println(Pattern.matches("[\\u4e00-\\u9fa5]+", "哇哇"));
//		System.out.println(Pattern.matches("[\\u4e00-\\u9fa5]+", "，，，，"));
//		System.out.println(Pattern.matches("[\\u4e00-\\u9fa5]+", "kkkk"));
		
		
		System.out.println(Pattern.matches("^[0-9]*$", "11"));
		
		
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
	}
	
}
