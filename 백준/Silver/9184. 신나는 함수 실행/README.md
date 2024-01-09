# [Silver II] 신나는 함수 실행 - 9184 

[문제 링크](https://www.acmicpc.net/problem/9184) 

### 성능 요약

메모리: 29416 KB, 시간: 692 ms

### 분류

다이나믹 프로그래밍, 재귀

### 제출 일자

2024년 1월 9일 14:43:07

### 문제 설명

<p>재귀 호출만 생각하면 신이 난다! 아닌가요?</p>

<p>다음과 같은 재귀함수 w(a, b, c)가 있다.</p>

<pre>if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
    1

if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
    w(20, 20, 20)

if a < b and b < c, then w(a, b, c) returns:
    w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)

otherwise it returns:
    w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
</pre>

<p>위의 함수를 구현하는 것은 매우 쉽다. 하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다. (예를 들면, a=15, b=15, c=15)</p>

<p>a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>입력은 세 정수 a, b, c로 이루어져 있으며, 한 줄에 하나씩 주어진다. 입력의 마지막은 -1 -1 -1로 나타내며, 세 정수가 모두 -1인 경우는 입력의 마지막을 제외하면 없다.</p>

### 출력 

 <p>입력으로 주어진 각각의 a, b, c에 대해서, w(a, b, c)를 출력한다.</p>

## 풀이 내용
나는 재귀를 이용해서 dp라는 배열에 저장하여 값이 기억되도록 풀어 내었다. 하지만 다른풀이를 보았는데 그 풀이는 재귀를 이용하는 것이 아닌 미리 배열에 저장해놓는 방식이었다.
```java
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int [][][] arr = new int [25][25][25];
		for(int i=0;i<=20;i++) {
			for(int j=0;j<=20;j++) {
				for(int k=0;k<=20;k++) {
					if(i==0 || j==0 || k==0)
						arr[i][j][k]=1;
					else
						arr[i][j][k]=arr[i-1][j][k]+arr[i-1][j-1][k]+arr[i-1][j][k-1]-arr[i-1][j-1][k-1];
				}
			}					
		}
		while(true) {
			int a=sc.nextInt(), b=sc.nextInt(),c=sc.nextInt();
			if(a==-1 && b==-1 && c==-1)
				break;
			System.out.printf("w(%d, %d, %d) = ",a,b,c);
			if(a<1 || b<1 || c<1)
				a=b=c=0;
			else if(a>20 || b>20 || c>20)
				a=b=c=20;
			System.out.printf("%d\n",arr[a][b][c]);
		}	
	}
}
```
문제에서 a,b,c중 하나라도 0이면 1이고, 하나라도 20을 넘으면 세개의 숫자 모두 20으로 하는것이니 21,21,21삼중배열을 미리 선언하여 값을 넣는 것이었다.
이렇게 하면 전체 배열을 우선적으로 다 계산을 해야하기때문에 재귀를 활용하는것보다는 더 걸리지만 문제를 이렇게 이해 할 수 있음에 놀랐다

