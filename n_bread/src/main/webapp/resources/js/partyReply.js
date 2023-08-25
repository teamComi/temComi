

function PartyReply(){
    
}

PartyReply.prototype = {
    init : function(page) {

        $.ajax({
            url : '/comi/partycosel?page=' + page
            ,type : 'get'
            ,dataType : 'json'
            ,success : function(data){
                
                var str = JSON.stringify(data);
                var json = JSON.parse(str);
                var value = '';
                console.log('json : ' + json.list);

                $('#review_number').html(reviewLength + '개의 댓글');

                //댓글 리스트 불러오기
                for(var i in json.list) {
                    var obj = json.list[i];
                    box.append(this.setReply(obj));
                }
            }
            ,error : function(jqXHR, textStatus, errorThrown){
                console.log('error : ' + jqXHR + ', '+ textStatus + ', ' + errorThrown);
            }
        })
    }
    ,
    setReply : function(data) {
        
    }
    ,
    buttonEvent : function(){

        $('.review-body-bottom-retext').each(function(){
            
        })
        

    }
}