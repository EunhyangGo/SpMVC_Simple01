package com.biz.simple.service;

import org.springframework.stereotype.Service;
/*
 * Service를 실행하는 클래스이다라는것을 알려주는 동시에
 * 	Spring에게 Myservice클래스를 객체로 생성해서 사용할 준비를 해 두어라는 지시어
 */
@Service
public class MyService {

	public int add(int intNum1, int intNum2) {
		return intNum1 +intNum2;
	}
	public int minus(int intNum1, int intNum2) {
		return intNum1 - intNum2;
	}
	public int multi(int intNum1, int intNum2) {
		return intNum1 * intNum2;
	}
	public int devide(int intNum1, int intNum2) {
		return  intNum1 /intNum2;
	}
}
