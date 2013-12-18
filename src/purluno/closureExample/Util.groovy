package purluno.closureExample

class Util {
	/**
	 * a 리스트로부터 각각의 항목을 읽어 clos 클로져로 넘기고 그 결과를
	 * b 리스트에 넣는다. 똑같은 코드를 반복 작성하지 않고도 다양한 목적으로
	 * 활용할 수 있다.
	 * 
	 * @param a 원본 리스트
	 * @param b 대상 리스트
	 * @param clos 클로져
	 * @return 대상 리스트
	 */
	static collect(a, b, clos) {
		for (def i = 0; i < a.size(); i++) {
			def c = a[i]
			def d = clos(c)
			b.add(d)
		}
		b
	}

	/**
	 * a 리스트로부터 각각의 항목을 읽어 f() 메소드로 넘기고 그 결과를
	 * b 리스트에 넣는다. 클로져를 활용하지 않고 f() 메소드를 활용하는
	 * 본 메소드를 살린 채로 각각의 항목에 대해 다른 작업을 하는 코드를
	 * 구현하려면 각각의 항목을 읽고 결과를 취합하는 똑같은 코드를
	 * 또 작성해야 한다.
	 * 
	 * @param a 원본 리스트
	 * @param b 대상 리스트
	 * @return 대상 리스트
	 */
	static collect2(a, b) {
		for (def i = 0; i < a.size(); i++) {
			def c = a[i]
			def d = f(c)
			b.add(d)
		}
		b
	}

	static f(obj) {
		obj + "X"
	}
}
