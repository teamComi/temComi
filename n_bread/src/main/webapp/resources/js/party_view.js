/**
 * 공유 찾기 계속 더 보여주기
 */

document.addEventListener("DOMContentLoaded", function(){
    
    //검색 
    $('.search-btn').on('click', function(){
        var val = $('.search-box-text').val();
        location.href = '/comi/partysearch/val=' + val;

    })

    if($('.search-box-text').val().length > 0) {
        //엔터키 눌르면 
        $(document).on('key')

    }
    
    return;
    $.ajax({
        url : '/comi/partysall?type=' + pageType + '&start=' + startCount
        ,type : 'get'
        ,dataType : 'json'
        ,success : function(data){
            
            var str = JSON.stringify(data);
            var json = JSON.parse(str);
            var value = '';
            console.log('json : ' + json.list);

            for(var i in json.list) {
                var obj = json.list[i];
                $('#portf_box').append(makeParty.getTag(obj));
            }
        }
        ,error : function(jqXHR, textStatus, errorThrown){
            console.log('error : ' + jqXHR + ', '+ textStatus + ', ' + errorThrown);
        }
    })
});



