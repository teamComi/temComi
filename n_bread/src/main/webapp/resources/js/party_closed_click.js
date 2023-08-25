

document.addEventListener("DOMContentLoaded", function(){
    
    //게시글 내용 붙이기
    var clickView = new ClickView();
    clickView.setSlide(partyData);
    clickView.init(partyData, memberData);
    clickView.buttonEvent();

    //댓글
    var partyReply = new PartyReply();
    partyReply.init(1);
    
    //하단 리스트 붙이기
    var setParty = new SetParty();
    setParty.init(partyData, $('#portf_box'));
    

    $('#replyMoreBtn').on('click', function(){

    })
});
