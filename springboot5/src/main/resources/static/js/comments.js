/**
 * /post/details.html에 포함
 * 댓글 작성, 목록, 수정, 삭제.
 */

document.addEventListener('DOMContentLoaded', ()=>{
    let currentPageNo = 0; //현재 댓글 목록 페이지 번호
    //-> getAllComments()함수에서 Ajax 요청을 보내고 정상 응답이 오면 현재 페이지 번호가 바뀜
    // 더보기 버튼에서 사용!
/*    let totalPages = 0; //댓글 목록 전체 페이지 개수*/
    
    
    //bootstrap library의 collapse 객체를 생성:
    const bsCollapse = new bootstrap.Collapse('div#collapseComments', {toggle:false});
    
    //댓글보기 버튼을 찾아서 클릭이벤트 리스너 설정
    const btnToggle = document.querySelector('button#btnToggle');
    btnToggle.addEventListener('click',()=>{
        bsCollapse.toggle(); //collapse 객체 보기/감추기 토글        
        const toggle = btnToggle.getAttribute('data-toggle');
        if (toggle == 'collapse'){
            btnToggle.innerHTML = '댓글 감추기';
            btnToggle.setAttribute('data-toggle','unfold');
            
            //댓굴 목록 불러오기
            getAllComments(0);
        } else {
            btnToggle.innerHTML = '댓글 보기';
            btnToggle.setAttribute('data-toggle','collapse');
        }
        
    });
    
    //등록 버튼을 찾아서 클릭이벤트 리스너 설정
    const btnRegisterComment = document.querySelector('button#btnRegisterComment')
    btnRegisterComment.addEventListener('click', registerComment);
    
    
    //더보기 버튼을 찾아서 클릭이벤트 리스너 설정
    const btnMore = document.querySelector('button#btnMore');
    btnMore.addEventListener('click', ()=> getAllComments(currentPageNo+1)); 
    
    
    //-------함수 정의(선언)---------
    function registerComment(){
        //댓글이 달린 포스트의 아이디
        const postId = document.querySelector('input#id').value;
        //댓글 내용
        const ctext = document.querySelector('textarea#commentText').value;
        //댓글 작성자
        const writer = document.querySelector('input#commentWriter').value;
        
        if(ctext.trim()===''){
            alert('내용을 입력해주세요^^')
            return;
        }
        
        //Ajax 요청에서 보낼 데이터
/*        원래 js 객체 선언은 이런식인데 (아래)
        const obj = {
            age:10,
            name:'홍길동'
        } 혹은 이런식 (아래)
        const data = {
            postId:postId,
            ctext:ctext,
            writer:writer, //마지막 쉼표는 있어도 되고 없어도 됨
        }
        필드명이랑 들어갈 변수명이랑 같으면 아래처럼 간단하게 작성할 수 있음*/
        
        const data = {postId, ctext, writer}; //object(객체)를 만든 것 
        
        // Ajax POST 방식 요청을 보냄
        axios.post('/api/comment',data)
        .then((response) => {
            console.log(response.data);
            alert( '댓글 등록 성공')
            // 댓글 내용 입력란을 비움
            document.querySelector('textarea#commentText').value = '';
            
            //TODO:댓글 목록 갱신
           
            getAllComments(0)
            
        })
        .catch((error) => {
            console.log(error);
        })
        
    }
    
    
    function getAllComments(pageNo){
        //댓글들이 달린 포스트 아이디
        const postId = document.querySelector('input#id').value;
        
        //Ajax 요청을 보낼 주소
        //pathvariable: 댓글이 달린 포스트 아이디. request param: 페이지 번호
        const uri = `/api/comment/all/${postId}?p=${pageNo}`; //pathvariable
        
        //Ajax 요청을 보내고 성공/실패 콜백 설정:
        axios.get(uri)
        .then((response)=> {
            console.log(response);
            //TODO: 댓글 목록을 HTML로 작성
            currentPageNo = response.data.number; //number - 페이지 번호
            makeCommentElements(response.data.content, currentPageNo); //content - 배열임 . 
        })
        .catch((error)=> {
            console.log(error);
        });
        
    }
    
    
    function makeCommentElements(data,pageNo){
        //로그인 사용자 정보 -> 댓글 삭제, 수정 버튼에 이용
        const authUser = document.querySelector('span#authUser').innerText;
        
        //댓글 목록을 추가할 div 요소
        const divComments = document.querySelector('div#divComments');
        let htmlStr = ''; //div에 삽입할 html 코드(댓글 목록)
        for(let comment of data){ //for in - 배열에서 인덱스를 부름 / for of - 배열에서 데이터를 부름
            htmlStr +=`
            <div class = "card card-body mt-2">
                <div class="mt-2">
                    <span class="fw-bold">${comment.writer}</span>
                    <span classs="text-secondary">${comment.modifiedTime}</span>
                </div>
                <div class="mt-2">
                    <div class="mt-2">
                        <textarea class="form-control">${comment.ctext}</textarea>
                    </div>
                    `;
                    //로그인 사용자와 댓글 사용자가 같은 경우에만 삭제/수정버튼을 보여줌
                    if (authUser === comment.writer){
                        htmlStr += `<div class="mt-2" >
                        <button class="btnDelete btn btn-outline-danger btn-sm">삭제</button>
                        <button class="btnUpdate btn btn-outline-primary btn-sm">수정</button>
                    </div>
                </div>
            </div>
            `;
                    } else {
                        htmlStr += `</div>
                                </div>
                                `;
                    }
                    
        }
        if (pageNo==0){
            //댓글목록 첫번째 페이지면 기존 내용을 지우고 새로 작성
            divComments.innerHTML=htmlStr;
         } else{
            //댓글 목록의 2번째 페이지 이상이면 
            divComments.innerHTML += htmlStr;
         }
    }
    
    
    
});