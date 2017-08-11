package com.test.algo;

/**
 * String Algorithm
 * Created by JUN on 2017-08-10.
 */

public class StringTest {
    /**
     * 1. 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라.
     * 시간복잡도 : O(n), 공간복잡도 : O(1)
     * @param str
     * @return
     */
    public boolean isUniqueChar(String str) {
        if(str.length() > 256) return false;

        boolean char_set[] = new boolean[256]; // Ascii
        for(int i=0; i < str.length(); i++) {
            int str_num = str.charAt(i); // char number
            if(char_set[str_num]) {
                return false;
            }
            char_set[str_num] = true;
        }
        return true;
    }

    /**
     * 1-1 비트연산 이용
     * 비트연산을 사용하면 더 공간 사용을 1/8로 줄일 수 있다.
     32비트 기준으로 비트로 32 가지를 1,0 으로 표현할 수 있으므로, 32개 이내의 문자 종류 범위 내에서는 Unique를 판단할 수 있다.
     문자열의 문자를 소문자 기준으로 판단할 때, 소문자는 ASCII 코드로 97('a') ~ 122('z') 까지로 26개의 문자를 가진다.
     따라서, a~z 까지를 비트의 첫번째 자리에서 26번째 자리까지의 값으로 탐색 결과를 표현할 수 있다.

     문자열을 탐색하면서 문자에서 'a'를 빼면, a로 부터 몇번째 문자인지 구할 수 있으며,  "1<<val" 와 같은 비트 쉬프트로 1을 해당 번째만큼을 자리수로 표현할 수 있다.
     ex> 'c' 는 'a'보다 2크다.  1<< 3  = 100

     checker 변수는 checker|=(1<<val) 를 사용해, 등장한 문자에 해당하는 자리수의 값들을 1로 기록한다.
     checker와 1<<val  를 & 연산했을 때, 0보다 큰 결과가 나오는 것은 1로 중복되는 자리가 있다는 것이고 이것은 유일하지 않은 결과로 판단할 수 있다.
     */

    public boolean isUniqueCharBit(String str) {
        if(str.length() > 26) return false;

        int check = 0;
        for(int i=0; i < str.length(); i++) {
            int str_num = str.charAt(i) - 'a'; // charAt 인수번째의 문자를 읽어냄, indexOf 해당 문자의 위치
            if((check & (1 << str_num)) > 0) { // << 1 true
                return false;
            }

            check |= 1 << str_num;
        }

        return true;
    }

    /**
     * 2. 널 문자로 끝나는 문자열을 뒤집는 reverse(char str) 함수를 구현하라.
     */
    public String reverse(String str) {
        if(str.length() <= 0) return null;

        String reverseStr = "";

        for(int i=str.length()-1; i >= 0; i--) {
            reverseStr += str.charAt(i);
        }
        return reverseStr;
    }

    public static String reverseString2(String string) {
        char[] charArray = new char[string.length()];
        for(int i=0; i<charArray.length; i++)
            charArray[i] = string.charAt(string.length()-i-1);
        return new String(charArray);
    }

    /**
     *  3. 주어진 문자열 내의 모든 공백을 '%20'으로 바꾸는 메서드를 작성하라. 문자열 끝에 추가로 필요한 문자들을 더할 수 있는 충분한 공간이 있다고 가정하라. 그리고 공백을 포함하는 문자열의 길이도 함께 주어진다고 가정하라
     (주의 : 만일 Java로 구현한다면, 문자 배열을 사용하여 필요한 연산을 각 문자에 바로 적용할 수 있또록 하라)
     http://hyeonstorage.tistory.com/334
     */

    /**
     * 4. 같은 문자가 연속으로 반복될 경우, 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하라. 가령 압축해야 할 문자열이 aabccccccaaa 라면 a2b1c6a3 으로 압축되어야 한다.
     * 압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우, 이 메서드는 원래 문자열을 그대로 반환해야 한다.
     */

    /**
     * 5. 이미지를 표현하는 N x N 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다. 이때, 이미지를 90도 회전시키는 메서드를 작성하라.
     * 부가적인 행렬을 사용하지 않고서도 할 수 있겠는가?
     */

    /**
     * 6. M x N 행렬을 순회하면서 0인 원소를 발견하면, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성하라.
     */

    /**
     * 7. 한 단어가 다른 단어에 포함된 문자열인지 판별하는 isSubstring 이라는 메서드가 있다.
     * s1, s2 두 문자열이 주어졌을때 s2가 s1을 회전시킨 결과인지 판별하는 코드를 isSubstring 을 한 번만 호출하도록 작성하라.
     * ex) waterbottle -> erbottlewat 을 회전시켜서 얻을 수 있는 문자열이다.
     */

    public boolean isSubstring(String s1, String s2) {
        return true;
    }
}
