
public class TestToy {

	public static void main(String[] args) {
		Toy toy1 = new Toy("새장난감", 5000);
		
//		안 스타틱일때		
//		ToyFactory fac = new ToyFactory();
//		Toy chucky = fac.makeToy();
		
//		스타틱일때		
		ToyFactory.makeToy();

	}

}
