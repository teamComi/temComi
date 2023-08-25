/**
 * 파티 보여주는 페이지
 */

document.addEventListener("DOMContentLoaded", function(){
    /*
    //통신
    axios({
        url: '/comi/partysall?type=findParty', // 통신할 웹문서
        method: 'get', // 통신할 방식
        headers: { 'Content-Type': 'application/json' }
    }).then(function(response){
        var data = response.data;
        
        console.log('data : ' + data);
        var str = JSON.stringify(data);
        console.log('str : ' + str);
        var json = JSON.parse(str);
        console.log('json.list : ' + json.meid);
        
        //console.log('partyData : ' + partyData);

        for(var i in json.list) {
            console.log("i : " + i);
        }
        
    }).catch(function(error){
        console.log(error);
    });
    
    */

    //var makeParty = new MakeParty();

    for(var i in partyData) {
        var obj = partyData[i];
        //$('#portf_box').append(makeParty.getTag(obj));
    }
});
