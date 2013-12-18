package purluno.closureExample

class Util {
	static collect(a, b, clos) {
		for (def i = 0; i < a.size(); i++) {
			def c = a[i]
			def d = clos(c)
			b.add(d)
		}
		b
	}

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
