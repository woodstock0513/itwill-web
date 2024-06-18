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
            //포스트에 달려있는 모든 댓글 목록 보여주기
            getAllComments();
            btnToggleComment.innerHTML = '댓글 감추기';
        } else {
            btnToggleComment.innerHTML = '댓글 보기';
        }
    });
    
    // 버튼 btnRegisterComment 요소 찾기
    const btnRegisterComment = document.querySelector('button#btnRegisterComment');
    
    // 버튼에 클릭 이벤트 리스너 등록
    btnRegisterComment.addEventListener('click',registerComment);
    
    //부트스트랩 모달 객체 생성
    const commentModal = new bootstrap.Modal('div#commentModal', {backdrop:true});
    
    //모달의 저장 버튼을 찾고 클릭 이벤트 리스너 설정
    const btnUpdateComment = document.querySelector('button#btnUpdateComment');
    
    btnUpdateComment.addEventListener('click',updateComment);
    
    
    /*---------- 위는 실제 작동 순서, 밑은 함수 정의----------*/
    
    // 댓글 등록 이벤트 리스너 콜백(함수). 선언은 어디서 해도 상관업음 (펑션으로 할 때)
    function registerComment(){
        //댓글이 달릴 포스트 번호 찾기
        const postId = document.querySelector('input#id').value;
        
        //댓글 내용 찾기
        const ctext = document.querySelector('textarea#ctext').value;
        
        //댓글 작성자 찾기
        const username = document.querySelector('input#username').value;
        
        //댓글 내용, 댓글 작성자가 비어있는지 체크
        if (ctext === "" || username === ''){
            alert('댓글 내용과 작성자는 반드시 입력하세요.');
            return; //이벤트 리스너 종료
        }
        
        //ajax 요청에서 보낼 데이터 객체를 생성 
        /* 근데 보기 불편..
        const data = {
            postId: postId,
            ctext: ctext,
            username: username
        };*/
        const data = {postId, ctext, username}; //위랑 같음!
        //property이름이 dto의 필드랑 이름이 같아야함!!!
        
        console.log(data);
        
        //post 방식의 Ajax 요청을 보냄, 응답성공/실패에 대한 콜백을 등록
        axios 
        .post('../api/comment',data)  //post,get,delete(요청주소, 객체타입) 메서드 이름 - 요청방삭    
        .then((response)=>{  //성공시 콜백
            //console.log(response)
            console.log(response.data); //restController에서 보낸 응답 데이터 (컨트롤러의 result : 1)
            if (response.data === 1){
                alert('댓글 1개 등록 성공');
                document.querySelector('textarea#ctext').value = '';
                document.querySelector('input#username').value = '';
                // 댓글 목록 갱신
                getAllComments();
            }
        })
        .catch((error) => {
            console.log(error);
        }); //실패시 콜백
        
    }
    
    //포스트에 달려있는 모든 댓글 가져오기
    function getAllComments(){
        //댓글 목록을 요청하기 위한 포스트 번호
        const postId = document.querySelector('input#id').value;
        
        //댓글 목록을 요청하기 위한 rest api uri
        const uri = `../api/comment/all/${postId}`;
        
        //ajax 요청을 보냄
        axios.get(uri)
            .then((response) => {
                console.log(response.data);
                // 댓글 목록을 html로 작성해서 details.jsp의 div#comments 영역에 출력
                makeCommentElements(response.data); 
            })
            .catch((error)=>{
                console.log(error);
            });
        
        
    }
    
    //댓글목록(댓글객체들의 배열)을 아규먼트로 전달받아 html 작성
    function makeCommentElements(data){
        //댓글목록 html이 삽입될 div
        const divComments = document.querySelector('div#comments');
        
        // 댓글 목록 html 코드
        let htmlStr = '';
        for (let comment of data){
            const modifiedTime = new Date(comment.modifiedTime).toLocaleString();
            
            htmlStr += `
            <div class = "card card-body my-1">
                <div style ="font-size:0.75rem;">
                    <span>${comment.id}</span>
                    <span class = "fw-bold">${comment.username}</span>
                    <span class="text-secondary">${modifiedTime}</span>
                </div>
                <div>${comment.ctext}</div>
                <div>
                    <button class="btnDeleteComment btn btn-outline-danger btn-sm"
                    data-id="${comment.id}">삭제</button>
                    <button class="btnModifyComment btn btn-outline-primary btn-sm"
                    data-id="${comment.id}">수정</button>
                </div>
            </div>
            `;
        }
        //작성된 html 코드를 div영역에 삽입
        divComments.innerHTML = htmlStr;
        
        //html 코드를 div안에 넣은 이후에 !!! 버튼들이 만들어지므로 순서에 유의할 것
        //모든 삭제 버튼을 찾아서 클릭 이벤트 리스너 설정
        const btnDeletes= document.querySelectorAll('button.btnDeleteComment');
        for (let btn of btnDeletes){
            btn.addEventListener('click',deleteComment);
        }
        
        //모든 수정 버튼을 찾아서 클릭 이벤트 리스너 설정
        const btnModifies = document.querySelectorAll('button.btnModifyComment');
        for (let btn of btnModifies){
            btn.addEventListener('click',showCommentModal);
        }
        
    }
    
    function deleteComment(event){
        //이벤트 리스너 콜백의 아규먼트 event 객체는 target 속성을 가지고 있음.
        //target = 이벤트가 발생한 요소 
        //console.log(event.target);
        const id = event.target.getAttribute('data-id'); //html요소의 속성값 찾기
        
        //삭제 여부 재확인
        const result = confirm('정말 삭제하시겠습니까?');
        if(!result){ //사용자가 취소했을 때
            return;
        }
                
        //Ajax 요청을 보낼 URI
        const uri = `../api/comment/${id}`;
        
        //Ajax 요청 보내기
        axios
        .delete(uri)
        .then((response)=>{
            console.log(response.data);
            if(response.data === 1){
                alert(`${id}번 댓글 삭제 성공`)
                getAllComments(); //댓글 목록 갱신
            }           
        })
        .catch((error)=>{
            console.log(error);
        });
    }
    
    function showCommentModal(event){
        
        //이벤트 타겟(수정버튼)의 data-id 속성값을 읽음
        const id = event.target.getAttribute('data-id');
        
        //ajax 요청 보내기 (id로 댓글 검색)
        const uri = `../api/comment/${id}`;
        
        axios
        .get(uri)
        .then((response) => {
            console.log(response.data); //ajax는 항상 resp가 data속성을 가짐
            //const commentId = response.data.id; //response의 data(create000dto/id,ctext,mTime,username이 있는 객체)의 id
            
            //모달의 input(댓글번호), textarea(댓글 내용)를 채우기
            document.querySelector('input#modalCommentId').value = id;
            document.querySelector('textarea#modalCommentText').value = response.data.ctext;            
        })
        .catch((error) => console.log(error));
        
        commentModal.show();
    }
    
    function updateComment(){
        //업데이트할 댓글 번호
        const id = document.querySelector('input#modalCommentId').value;
        
        //업데이트할 댓글 내용
        const ctext = document.querySelector('textarea#modalCommentText').value;
        
        if (ctext === ""){
            alert('수정할 내용을 입력하세요');
            return; //이벤트 리스너 종료
        }
        
        //댓글 업데이트 요청 REST APT URI
        const uri = `../api/comment/${id}`;
        
        //ajax 요청
        axios  // {id, ctext}로 했으면 restController에서 setId를 할 필요가 없음!!
        .put(uri, {ctext}) //{ctext} = {ctext:ctext}. 객체의 프로퍼티 이름 : 그 안에 넣어줄 값(지역변수) 
        .then((response)=>{
            console.log(response);
            
            //댓글 목록 갱신
            getAllComments();
            
            //모달 감추기(숨김)
            commentModal.hide(); 
        })
        .catch((error)=>console.log(error));
        
    }
    
    
    
    
});