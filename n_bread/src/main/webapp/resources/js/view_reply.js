
document.addEventListener("DOMContentLoaded", function(){
    var viewReply = new View_reply();
    viewReply.buttonEvent();
})

function View_reply(){
    
}

View_reply.prototype = {
    connection : function(panum, page) {

        $.ajax({
            url : '/comi/partycosel?panum=' + panum + '&page=' + page
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
        
        $('#review-write-login').on('click', function(){
            
            if(confirm('로그인을 하신 후 이용해 주시기 바랍니다.')) {
                //로그인 페이지로 이동
                location.href = '/comi/main.jsp';
            }else{

            }
        })

        //댓글쓰기
        $('#review_textarea_1').on('input', function(){
            console.log('댓글 길이 ');
            $('#review_textlabel_1').hide();
            $('#upload_btn_1').css({'background' : 'rgb(100, 166, 245)'});//#64A6F5

            $('#write_count_1').text($('#review_textarea_1').val().length);
        })

        $('#upload_btn_1').on('click', function(){
            //댓글 올리기
            //console.log('background-color : ' + $(this).css('background-color'))
            if($(this).css('background-color') == 'rgb(100, 166, 245)') {
                console.log('댓글 올리기');

            }

            return false;
        })
    }
}