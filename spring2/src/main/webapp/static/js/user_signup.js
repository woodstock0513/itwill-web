/**
 * /user/signup.jsp 파일에 포함.
 */

document.addEventListener('DOMContentLoaded', () => {
    let useridChecked = false; // 사용자 아이디 중복 체크 결과. true: 사용할 수 있는 아이디.
    let passwordChecked = false; // 비밀번호 필드 작성 여부 체크.
    let emailChecked = false; // 이메일 필드 작성 여부 체크.
    
    const inputUserid = document.querySelector('input#userid');
    inputUserid.addEventListener('change', checkUserid);
    
    const inputPassword = document.querySelector('input#password');
    inputPassword.addEventListener('change', checkPassword);
    
    const inputEmail = document.querySelector('input#email');
    inputEmail.addEventListener('change', checkEmail);
    
    /* -------------------- 함수 선언 -------------------- */
        
    // 회원 가입 버튼 활성화/비활성화
    function changeButtonState() {
        const btnSignUp = document.querySelector('button#btnSignUp');
    
        if (useridChecked && passwordChecked && emailChecked) {
            // 버튼의 class 속성 값들 중 'disabled'를 제거. - 버튼 화렁화
            //console.log(btnSignUp.classList);
            btnSignUp.classList.remove('disabled');
        } else {
            // 버튼의 class 속성에 'disabled'를 추가. - 버튼 비활성화
            //console.log(useridChecked);
            //console.log(passwordChecked);
            //console.log(emailChecked);
            //console.log(btnSignUp.classList);
            btnSignUp.classList.add('disabled');
        }
    }
    
    // userid 입력 필드의 change 이벤트 리스너
    function checkUserid(event) {
        // TODO: 중복 아이디 체크 Ajax 요청을 보내고, 응답을 받았을 때 처리.
        const userid = event.target.value; // inputUserid
        console.log(userid); 
        
        const uri = `./checkid?userid=${userid}`; // 아ㅣㅇ디 중복체크 rest api
        
        axios
        .get(uri)
        .then((response) => {
            const checkUseridResult = document.querySelector('div#checkUseridResult')
            
            if(response.data === 'Y'){
                useridChecked = true;
                checkUseridResult.innerHTML = 'good~';
                checkUseridResult.classList.add('text-success');
                checkUseridResult.classList.remove('text-danger');
            } else {
                useridChecked = false;
                checkUseridResult.innerHTML = 'nope~';
                checkUseridResult.classList.remove('text-success');
                checkUseridResult.classList.add('text-danger');
            }
            
            changeButtonState(); //버튼 활성화 여부 변경
            
        })
        .catch((error) => console.log(error));
    }
    
    // 비밀번호 입력 필드의 change 이벤트 리스너
    function checkPassword(event) {
        // input#password 비어 있는 지를 체크
        if(event.target.value === '') { //inputPassword
            passwordChecked = false;
        } else {
            passwordChecked=true;
        }
        changeButtonState();
    }
    
    // 이메일 입력 필드의 change 이벤트 리스너
    function checkEmail(event) {
        // input#email 비어 있는 지를 체크
        if(event.target.value === '') { //inputEmail
            emailChecked = false;
        } else {
            emailChecked=true;
        }
        changeButtonState();
        
    }
    
});
