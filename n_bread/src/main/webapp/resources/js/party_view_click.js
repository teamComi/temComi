

document.addEventListener("DOMContentLoaded", function(){
    
    //게시글 내용 붙이기
    var clickView = new ClickView();
    clickView.setSlide(partyData);
    clickView.init(partyData, memberData);
    clickView.buttonEvent();

    //채팅

    //하단 파티 리스트
    var setParty = new SetParty();
    setParty.init(partyData, $('#portf_box'));
    
});




function ComentsView(){

}

ComentsView.prototype = {
    insert : function(index){
        //나의 턴일때 아닐때 구분

        //통신
        axios({
            url: '/comi/partych', // 통신할 웹문서
            method: 'get', // 통신할 방식
            data: { // 인자로 보낼 데이터
                partyid : 121
            },
            headers: { 'Content-Type': 'application/json' }
        }).then(function(response){
            console.log('data : ' + response.data);

            if(member.id == response.data.id) {
                //내 메시지

                $('#chating_box').append(this.message());
            }else{
                //다른 사람 메시지
                $('#chating_box').append(this.message());
            }

            
        }).catch(function(error){
            console.log(error);
        });


        

    }
    ,
    message : function(){
        var tag = 
        `
        <div class="chating-body-msg">
            <div class="chating-body-msg-w">
                <div class="chating-body-msg-profile">
                    <img class="chating-body-msg-profile-img" src="/komi/resources/images/profile.png">
                    <div class="chating-body-msg-profile-name">`+nickname+`</div>
                </div>
                <div class="chating-body-msg-box">
                    <div class="chating-body-msg-box-read bubble-msg">`
                        +contents+
                    `</div>
                    <div class="chating-body-msg-box-date">
                        `+date+`
                    </div>
                    <button class="chating-body-msg-box-pop">
                        <img class="chating-body-msg-box-pop-img" src="./komi/resources/images/msg_pop_img.png">
                    </button>
                </div>
            </div>
        </div>`;

        
    }
}