public class Add {
    public static void main(String args[]) {
        //int: 정수형 data type(자료형)
        //변수이름은 영소문자로 시작, 공백X, 대소문자 구분, 키워드들은 안됨 ex)int, 같은 이름으로 선언 중복 안됨 ex)int x; int x;
        int x; //변수 선언(variable declare): 변수 자리 하나 마련해다오~ 정수 자리만큼~ x라는 이름 붙일게~
        int y;
        int sum;

        //초기화(initialize): 제일 처음에 값을 집어넣는 것을 말함
        x = 100; //=: 대입연산자(assignment), 오른쪽에 있는 것을 왼쪽으로 집어넣어줌
        y = 200;
        sum = x + y; //더하기 연산이 먼저, 그 후에 대입연산자가 집어넣음

        System.out.println(sum); //쌍따옴표 없이 부르면 변수를 부른것! 쌍따옴표 있으면 그냥 그 문자열이 출력됨

        System.out.println(x - y); //한번 쓰고 말거면 이렇게

        int minus;
        minus = x - y;
        System.out.println(minus); //저장해놓고 두고두고 쓸거면 이렇게

        return; //메인메소드의 종료! 돌아가시오~ }만으로도 ok, but 확실하게 하기 위해~
    }
}