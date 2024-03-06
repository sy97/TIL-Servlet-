function nulltest(){
	let kor = document.getElementById("kor").value;
	let eng = document.getElementById("eng").value;
	let math = document.getElementById("math").value;
	
	if(kor == null || eng == null || math == null){
		alert("빈 칸을 채워주시기 바랍니다.");
	}
}