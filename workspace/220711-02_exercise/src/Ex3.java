import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//목록보기, 1명보기, 1명수정, 1명삭제
class Person implements Serializable {
	private int number;
	private String name;
	private String phone;
	private String email;

	public Person(int number, String name, String phone, String email) {
		this.number = number;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [number=" + number + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

}

public class Ex3 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		List<Person> list = new ArrayList<>(); // 프로그램 종료 전까지 list에 담고 프로그램 켜면 list에 불러오고
		// 리스트로 다해먹는게 편하다~
		ObjectOutputStream oos = null; // write
		ObjectInputStream ois = null; // read
		File file = new File("d:\\filetest\\ex3.txt");

		try {
			try {
				ois = new ObjectInputStream(new FileInputStream(file));
				while(true) {
				list.addAll((List) ois.readObject());
				}
			} catch(FileNotFoundException e) {
				file.createNewFile(); //.mkdir()는 폴더를 만듬 .createNewFile()는 파일만듬
				System.out.println("ex3.txt 생성");
			} catch (EOFException e) {
				System.out.println("파일 읽기 완료");
			}
			int push = 0;
			while (push != 9) {
				System.out.println("1. 등록하기");
				System.out.println("2. 목록보기");
				System.out.println("3. 1명 정보 수정");
				System.out.println("4. 1명 정보 삭제");
				System.out.println("9. 종료");
				push = scan.nextInt();
				if (push == 1) {
					System.out.println("번호?");
					int num = scan.nextInt();
					scan.nextLine();
					boolean runOrNot = true;
					for(Person p : list) {
						if (p.getNumber() == num) {
							runOrNot = false;
							break;
						}
					}
					if (runOrNot) {
						System.out.println("이름?");
						String name = scan.nextLine();
						System.out.println("전화번호?");
						String phone = scan.nextLine();
						System.out.println("이메일?");
						String email = scan.nextLine();
						Person p = new Person(num, name, phone, email);
						list.add(p);
					} else {
						System.out.println("이미 할당된 번호입니다");
					}
				}
				if (push == 2) {
					for (Person p : list) {
						System.out.println(p);
					}
				}
				if (push == 3) {
					System.out.println("수정할 사람의 번호를 입력해주세요");
					int num = scan.nextInt();
					scan.nextLine();
					Person editP = null;
					for (Person p : list) {
						if (p.getNumber() == num) {
							editP = p;
							break;
						}
					}
					if (editP != null) {
						System.out.println("수정할 이름?");
						String name = scan.nextLine();
						System.out.println("수정할 전화번호?");
						String phone = scan.nextLine();
						System.out.println("수정할 이메일?");
						String email = scan.nextLine();
						editP.setName(name);
						editP.setPhone(phone);
						editP.setEmail(email);
						System.out.println("수정완료");
					} else {
						System.out.println("해당번호에 사람이 없습니다");
					}

				}
				if (push == 4) {
					System.out.println("삭제할 사람의 번호를 입력해주세요");
					int num = scan.nextInt();
					scan.nextLine();
					Person delP = null;
					for (Person p : list) {
						if (p.getNumber() == num) {
							delP = p;
							break;
						}
					}
					if (delP != null) {
						list.remove(delP);
						System.out.println("삭제완료");
					} else {
						System.out.println("해당번호에 사람이 없습니다");
					}
				}
				if (push == 9) {
					System.out.println("프로그램을 종료합니다");
				}
			}
		} finally {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(list);
			if (oos != null) {
				oos.close();
			}
			if (ois != null) {
				ois.close();
			}
		}

	}

}
