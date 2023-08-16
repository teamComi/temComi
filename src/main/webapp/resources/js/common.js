
document.addEventListener("DOMContentLoaded", function(){
    
    var header = document.querySelector('#header_view');
    fetch('/komi/views/header.html')
    .then(res => res.text())
    .then(data => header.innerHTML = data)
    .then(function(response){
        //console.log('response : ' + response);
        listAddClass();
    });
    
    var footer = document.querySelector('#footer_view');
    fetch('/komi/views/footer.html')
    .then(res => res.text())
    .then(data => footer.innerHTML = data);
    
});

function listAddClass(){
    switch ($('title').eq(0).text()) {
        case 'party_make':
            $('.header_menu .header_text ul li').eq(0).addClass('active');
            break;
        case 'party_view':
            $('.header_menu .header_text ul li').eq(1).addClass('active');
            break;
        case 'party_closed':
            $('.header_menu .header_text ul li').eq(2).addClass('active');
            break;
        case 'question':
            $('.header_menu .header_text ul li').eq(3).addClass('active');
            break;
        default:
            break;
    }
}