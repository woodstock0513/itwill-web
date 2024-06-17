/**
 * /post/details.jsp에 추가
 */


document.addEventListener('DOMContentLoaded',() => {
    // btnToggleComment 버튼 요소 찾기
    const btnToggleComment = document.querySelector('button#btnToggleComment');
                 // ajax : $('button#btnToggleComment)
    // collapseComments div 요소를 부트스트랩의 Collapse 객체로 생성.
    const bsCollapse = new bootstrap.Collapse('div#collapseComments',{toggle:false}); //접혀있는상태
    // 댓글 토글 버튼에 클릭 이벤트 리스너 등록
    btnToggleComment.addEventListener('click', () => {
        bsCollapse.toggle();
        if (btnToggleComment.innerHTML==='댓글 보기'){
            btnToggleComment.innerHTML = '댓글 감추기';
        } else {
            btnToggleComment.innerHTML = '댓글 보기';
        }
    });
    
    // 버튼 btnRegisterComment 요소 찾기
    const btnRegisterComment = document.querySelector('button#btnRegisterComment');
    
    // 버튼에 클릭 이벤트 리스너 등록
    btnRegisterComment.addEventListener('click',registerComment);
    
    // 댓글 등록 이벤트 리스너 콜백(함수). 선언은 어디서 해도 상관업음 (펑션으로 할 때)
    function registerComment(){
        //댓글이 달릴 포스트 번호 찾기
        const postId = document.querySelector('input#id').value;
        
        //댓글 내용 찾기
        const ctext = document.querySelector('textarea#ctext').value;
        
        //댓글 작성자 찾기
        const username = document.querySelector('input#username').value;
        
        console.log(postId, ctext, username);
    }
    
    
    
});