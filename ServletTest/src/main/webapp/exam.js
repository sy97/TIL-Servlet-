
	
	function numCheck(){
		let birthInput = document.getElementsByName("birth")[0].value;
	
		if(birthInput>0){
			return true;
		
		}
		else{
			alert("생년월일은 숫자만 입력가능합니다.");
			return false;
			}
		}
		