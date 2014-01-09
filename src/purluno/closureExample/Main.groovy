package purluno.closureExample

class Main {
	/**
	 * 각각의 예제를 실행하는 메인 메소드
	 */
	static main(args) {
		def m = new Main()
//		m.example1()
//		m.example2()
//		m.example3()
//		m.example4()
//		m.example5()
//		m.example6()
//		m.example7()
//		m.example8()
		m.example9()
	}

	/**
	 * 클로져를 만들어 호출하는 가장 기본 예제
	 */
	def example1() {
		def clos = { println "hello!" }
		println "Executing the Closure:"
		clos()
	}

	/**
	 * 클로져에 명시적으로 인자를 지정하는 예제
	 * (인자를 지정하지 않으면 기본적으로 'it'이라는 인자가 만들어짐)
	 */
	def example2() {
		def printSum = { a, b -> println a+b }
		printSum(5, 7)
	}

	/**
	 * 클로져에서 바깥에 있는 변수 참조하기
	 */
	def example3() {
		def myConst = 5
		def incByConst = { num -> num + myConst }
		println incByConst(10)
	}

	/**
	 * 클로져를 리턴받아 호출하기
	 */
	def example4() {
		def clos = localMethod()
		println "Executing the Closure:"
		clos()
	}

	/**
	 * 로컬변수의 값을 출력하는 클로져를 리턴하는 메소드
	 */
	def localMethod() {
		def localVariable = new Date()
		return { println localVariable }
	}

	/**
	 * 기본 인자인 'it'을 사용하기
	 */
	def example5() {
		def clos = { println it }
		clos("hi there")
	}

	/**
	 * 클로져에서 'this', 'delegate', 'owner'의 의미 확인	
	 */
	def example6() {
		def clos = new Class1().closure
		clos.delegate = this
		clos()
	}
	
	/**
	 * 클로져에서 'this', 'delegate', 'owner'의 의미 확인	
	 */
	class Class1 {
		def closure = {
			println this.class.name
			println delegate.class.name
			def nestedClos = {
				println owner.class.name
			}
			nestedClos()
		}
	}

	/**
	 * 클로져를 인자로 받는 list.collect() 메소드 호출하기
	 */
	def example7() {
		def list = ['a', 'b', 'c', 'd']
		def newList = []
		list.collect(newList) {
			it.toUpperCase()
		}
		println newList
	}
	
	/**
	 * 클로져를 인자로 받는 list.collect() 메소드 호출하기 (다른 방법)	
	 */
	def example8() {
		def list = ['a', 'b', 'c', 'd']
		def newList = []
		
		def clos = { it + "X" }
		list.collect(newList, clos)
		println newList
	}
	
	def example9() {
		def a = ['a', 'b', 'c', 'd']
		def b = []
		Util.collect2(a, b)
		println a
		println b
		
		def aa = ['a', 'b', 'c', 'd']
		def bb = []
		def clos = { e -> e + "X" }
		Util.collect(aa, bb, clos)
		println aa
		println bb
		
		def aaa = ['a', 'b', 'c', 'd']
		def bbb = []
		def clos2 = { e -> e + "Y" }
		Util.collect(aaa, bbb, clos2)
		println aaa
		println bbb
	}
}
