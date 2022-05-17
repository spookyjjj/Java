public class MulDiv {
    public static void main(String args[]) {
        //System.out. println("ABC" / 5); ->string과 int error 컴파일 자체가 안됨
        //System.out. println(50 / 0); ->int와 int라서 컴파일은 되지만, 실행시 error 뒤에 거 읽지도 않고 종료됨

        System.out. println("10 곱하기 5는 " + 10 * 5); //곱하기 나누기가 먼저! 그렇더라도, 사람 보기에 헷갈리지 말라고 괄호 넣어줌~
        System.out. println("22 나누기 4는 " + (22 / 4)); //정수로 넣어주면 결과값도 정수로
        System.out. println("22.0 나누기 4.0는 " + (22.0 / 4.0)); //실수로 넣어주면 결과값도 실수로

        System.out. println("프로그램 정상 종료");
    }
}