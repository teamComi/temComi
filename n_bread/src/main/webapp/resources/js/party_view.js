/**
 * 공유 찾기 계속 더 보여주기
 */

document.addEventListener("DOMContentLoaded", function(){
    
    var makeParty = new MakeParty();
    /*
    for(var i in partyData) {
        var obj = partyData[i];
        $('#portf_box').append(makeParty.getTag(obj));
    }
    */
    var startCount = 0;
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
