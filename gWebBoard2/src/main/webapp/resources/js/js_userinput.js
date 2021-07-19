$(function(){
	// 사용자의 자료 입력여부를 검사하는 함수
	$('#confirm').click(function(){
    	if( $.trim($("#userId").val()) == '' ){
            alert("아이디를 입력해 주세요.");
            $("#userId").focus();
            return;
        }
    	
    	if($.trim($('#userPass').val())==''){
    		alert("비번입력해주세요.");
    		$('#userPass').focus();
    		return;
    	}
    	
    	if($.trim($('#userPass').val()) != $.trim($('#userPass2').val())){
    		alert("비밀번호가 일치하지 않습니다..");
    		$('#userPass2').focus();
    		return;
    	}
    	
    	
    	if($.trim($('#userName').val())==''){
    		alert("이름입력해주세요.");
    		$('#userName').foucs();
    		return;
    	}
       
        // 자료를 전송합니다.
        document.userinput.submit();
	});
	
	//아이디 중복체크 (몇년전에 유행한 keyup)
	// 사용자 모르게 백단으로 다녀오는 : ajax
	$('#userId').keyup(function(){
        $.ajax({
        	type : 'post', // 보내는 방식
        	url : 'idCheck.do', // 보내는 곳
        	contentType : 'application/x-www-form-urlencoded;charset=UTF-8', // 한글처리
        	data : { userId : $('#userId').val() }, // 보내는 데이터 처리
        	success : function(result){
        		$('#idCheckResult').text(result)
        		// 주의! text()와 html()의 차이
        		// 태그와 태그 사이에 글씨를 쓰는 text()
        	}
        })
       
	})
})
	
	
	
	
	
	
	
	
	