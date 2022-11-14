package ch08;

class Student {
	private Integer no;                      // 회원번호(키값)
	private String  name;                    // 이름

	//--- 키값 ---//
	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//--- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + this.no + ") " + this.name + " ";
	}

	public Student(Integer snum, String sname) {
		this.no = snum;
		this.name = sname;
	}
	
	public Student(Student s) {
		this.no = s.no;
		this.name = s.name;
	}
	
	public Student() {
		this.no = null;
		this.name = null;
	}
}
