package com.smile;

public class CustomException extends Exception {

	public CustomException() {
	}

	public CustomException(String message) {
		super(message);
	}
}

class TestMyException {

	void test() throws CustomException {
	};

	public static void main(String[] args) {
		try {
			new TestMyException().test();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}