//의자 클래스 제조사,생산일자,가격,모델명 & 초기화 할 수 있는 생산자
class Chair {
	String brand;
	String birth;
	String price;
	String model;
	
	//생성자 만들기
	public Chair() {
		brand = "제조사를 입력하세요";
		birth = "생산일자를 입력하세요";
		price = "가격을 입력하세요";
		model = "모델명을 입력하세요";
	}
	public Chair(String br, String bi, String pr, String mo) {
		brand = br;
		birth = bi;
		price = pr;
		model = mo;
	}
	void printAll() {
		System.out.println(brand);
		System.out.println(birth);
		System.out.println(price);
		System.out.println(model);
	}
	
	public static void main(String arg[]) {
		Chair c = new Chair();
		c.printAll();
		
		Chair c2 = new Chair("시디즈", "2016-09-05", "37800원", "T50");
		c2.printAll();
	}
}

